package com.tc.beerlist.ui.beerlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.beerlist.data.model.beer.BeerListItemModel
import com.tc.beerlist.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerListViewModel @Inject constructor(
    private val repository : Repository
):ViewModel() {
    //read and wirte mutable
    private val _beers = MutableStateFlow<List<BeerListItemModel>>(emptyList())
    //read only state
    val beers : StateFlow<List<BeerListItemModel>> = _beers

    //intializing whenever we create an object it calls it
    //will be called automatically whenever an instance/object is create
    init{
        getBeers()
    }

    fun getBeers() {
       viewModelScope.launch {
           val response = repository.getBeers()
           //we use this beers because we need to write to it
           _beers.value = response ?: emptyList()
           _beers.emit(response ?: emptyList())
       }
    }

}