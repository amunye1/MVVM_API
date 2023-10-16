package com.tc.beerlist.ui.navigation

enum class Screens(val route: String, val header: String) {
    BeerList(route = ScreenName.BEER_SCREEN, header = "Beer list"),
    Detail(route = ScreenName.BEER_DETAIL_SCREEN , header = "Beer Item")






}
 object ScreenName{
    const val BEER_SCREEN : String = "beer_screen"
    const val BEER_DETAIL_SCREEN : String = "beer_detail_screen"


}