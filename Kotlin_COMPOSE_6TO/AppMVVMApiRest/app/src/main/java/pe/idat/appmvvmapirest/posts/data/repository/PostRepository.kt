package pe.idat.appmvvmapirest.posts.data.repository

import pe.idat.appmvvmapirest.posts.data.network.response.PostResponse
import pe.idat.appmvvmapirest.posts.data.network.service.PostService
import javax.inject.Inject

class PostRepository @Inject constructor(private val api:PostService){
    suspend fun getPost():List<PostResponse>{
        return api.getPost()
    }
}