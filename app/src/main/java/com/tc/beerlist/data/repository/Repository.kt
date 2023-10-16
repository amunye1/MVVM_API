package com.tc.beerlist.data.repository

import com.tc.beerlist.data.model.beer.BeerListItemModel
import com.tc.beerlist.data.remote.ApiDetails
import retrofit2.http.GET
import retrofit2.http.Path
//like a tree this is the base
//central access for all api data when we have multiple data
interface Repository {


    suspend fun getBeers():List<BeerListItemModel>
    //suspend -> pauses functionality until resources become available
    //helps run in the background
    //required to run in coroutines


    suspend fun getBeerItem( id:Int): List<BeerListItemModel>
}