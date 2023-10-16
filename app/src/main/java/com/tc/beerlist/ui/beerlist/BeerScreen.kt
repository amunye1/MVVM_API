package com.tc.beerlist.ui.beerlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.tc.beerlist.data.model.beer.BeerListItemModel
import com.tc.beerlist.ui.navigation.Screens

@Composable
fun BeerScreen(
    navController: NavController
){
    val viewModel = hiltViewModel<BeerListViewModel>()
    val beers by viewModel.beers.collectAsState()

    val navigateToDetail: (String)-> Unit = {id->
        navController.navigate("${Screens.Detail.route}/$id")
    }

    LazyColumn{
        items(beers){beer ->
            BeerItem(beer, navigateToDetail)


        }
    }
}

@Composable
fun BeerItem(beer: BeerListItemModel, navigateToDetail: (String) -> Unit) {

    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxHeight()
            .clickable { navigateToDetail(beer.id.toString()) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .height(99.dp)
                .background(color = Color(0xFFD1D1D1))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = "${beer.imageUrl}"),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 90.dp, width = 60.dp)
                    .weight(0.5f)
                    .padding(5.dp)
            )
            Text(
                text = "${beer.id}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 10.dp),
                fontSize = 20.sp
            )
            Text(
                text = "${beer.name}",
                color = Color.Black,
                modifier = Modifier
                    .weight(3f)
                    .padding(end = 5.dp),
                textAlign = TextAlign.End
            )
        }
    }

}