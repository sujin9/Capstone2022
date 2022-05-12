package com.ildango.capstone.data.service

import com.ildango.capstone.mypages.mywishlist.MyWishItem
import retrofit2.Response
import retrofit2.http.GET

interface MyWishService {
    @GET("myposts/17")      // 17 : userId
    suspend fun getAllWishProduct() : Response<List<MyWishItem>>
}