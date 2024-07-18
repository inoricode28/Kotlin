package pe.idat.appmvvmapirest.posts.data.network.retrofitclient

import pe.idat.appmvvmapirest.posts.data.network.response.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface PostClient {
    @GET("/posts")
    suspend fun getPosts():Response<List<PostResponse>>


}