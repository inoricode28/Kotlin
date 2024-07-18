package pe.idat.appmvvmapirest.posts.data.network.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.idat.appmvvmapirest.posts.data.network.response.PostResponse
import pe.idat.appmvvmapirest.posts.data.network.retrofitclient.PostClient
import javax.inject.Inject

class PostService @Inject constructor(private val postClient: PostClient){
    suspend fun getPost():List<PostResponse>{
        return withContext(Dispatchers.IO){
            val response = postClient.getPosts()
            response.body()!!
        }
    }
}