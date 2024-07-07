package pe.idat.appmvvm.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel:ViewModel() {

    private val _usuario = MutableLiveData<String>()
    val usuario : LiveData<String> = _usuario

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    fun onLoginTextChanged(usuario: String, password: String){
        _usuario.value = usuario
        _password.value = password
    }
    fun autenticarUsuario():Boolean{
        if (usuario.value.equals("lsalvatierra") && password.value.equals("123456")){
            return true
        }
        return false
    }

}