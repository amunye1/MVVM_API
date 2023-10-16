package com.tc.beerlist.data.remote

import com.tc.beerlist.data.model.beer.BeerListItemModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {
    @GET(ApiDetails.BEER_LIST)
    suspend fun getBeers():List<BeerListItemModel>
            //suspend -> pauses functionality until resources become available
            //helps run in the background
            //required to run in coroutines

    @GET(ApiDetails.BEER_ITEM)
    suspend fun getBeerItem(@Path("id") id:Int): List<BeerListItemModel>


}