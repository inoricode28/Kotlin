package pe.idat.appmvvmapirest.posts.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.appmvvmapirest.posts.domain.GetPostUseCase
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postUseCase: GetPostUseCase) :ViewModel(){
    fun getPost(){
        viewModelScope.launch {
            Log.i("PostLIST",postUseCase().toString())
        }
    }

}