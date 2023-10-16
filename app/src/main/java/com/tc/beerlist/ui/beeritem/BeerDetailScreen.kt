package com.tc.beerlist.ui.beeritem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import coil.compose.rememberAsyncImagePainter
import com.tc.beerlist.data.model.beer.BeerListItemModel

@Composable
fun BeerDetailScreen(
    beerId: Int
) {

    val viewModel = hiltViewModel<BeerItemViewModel>()
    val beerItem by viewModel.beerItem.collectAsState()

    viewModel.getBeerItem(beerId)

    BeerDetailContent(beerItem)
}

@Composable
fun BeerDetailContent(beerItem: BeerListItemModel) {
    Column() {
        Card(
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .height(99.dp)
                        .background(color = Color(0xFFD1D1D1))
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = "${beerItem.imageUrl}"),
                        contentDescription = null,
                        modifier = Modifier
                            .size(height = 90.dp, width = 60.dp)
                            .weight(0.5f)
                            .padding(5.dp)
                    )
                    Text(
                        text = "${beerItem.id}",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(start = 10.dp),
                        fontSize = 20.sp
                    )
                    Text(
                        text = "${beerItem.name}",
                        color = Color.Black,
                        modifier = Modifier
                            .weight(3f)
                            .padding(end = 5.dp),
                        textAlign = TextAlign.End
                    )
                }
            }
        }
        Column() {
            Text(
                text = "${beerItem.description}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Text(
                text = "First brew: ${beerItem.firstBrewed}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}