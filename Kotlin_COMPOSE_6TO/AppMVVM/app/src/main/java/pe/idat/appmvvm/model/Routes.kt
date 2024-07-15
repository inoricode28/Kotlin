package pe.idat.appmvvm.model

sealed class Routes(val path: String) {
    object  loginScreen: Routes("loginScreen")
    object homeScreen: Routes("homeScreen/{id}"){
        fun paramHome(id: Int) = "homeScreen/$id"
    }
}