package com.tc.beerlist.ui.beeritem

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
class BeerItemViewModel @Inject constructor(
    private val repository:Repository
) :ViewModel() {
    private val _beerItem = MutableStateFlow<BeerListItemModel>(BeerListItemModel())
    val beerItem: StateFlow<BeerListItemModel> = _beerItem


    fun getBeerItem(id: Int) {
        if (id < 1) return
        viewModelScope.launch {
            val response = repository.getBeerItem(id)

//            _beers.value = response ?: emptyList()
            _beerItem.emit(response[0] ?: BeerListItemModel())
        }
    }
}