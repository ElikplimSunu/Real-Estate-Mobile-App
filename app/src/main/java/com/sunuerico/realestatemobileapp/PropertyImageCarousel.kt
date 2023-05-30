package com.sunuerico.realestatemobileapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sunuerico.realestatemobileapp.ImageItem
import com.sunuerico.realestatemobileapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ImageCarousel(images: List<ImageItem>, autoScrollInterval: Long = 2000) {
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberLazyListState()
    var currentItemIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(autoScrollInterval)
            coroutineScope.launch {
                scrollState.animateScrollToItem(currentItemIndex + 1)
                currentItemIndex = (currentItemIndex + 1) % images.size
            }
        }
    }

    LazyRow(
        state = scrollState,
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        items(images) { item ->
            Image(
                painter = painterResource(id = item.id),
                contentDescription = null,
                modifier = Modifier
//                    .aspectRatio(1f)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }

    // Indicator colors
    val selectedColor = Color(0xFF80AD5D)
    val unselectedColor = Color(0xFFDFEAF5)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {


        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 125.dp)
        ) {
            images.forEachIndexed { index, _ ->
                if (index == currentItemIndex) {
                    Box(modifier = Modifier.padding(15.dp)
                        .size(6.dp)) {
                        Canvas(
                            modifier = Modifier
                                .size(size = 6.dp)
                        ) {
                            drawCircle(
                                color = unselectedColor,
                                radius = 13.dp.toPx(),
                                style = Stroke(width = 2.dp.toPx())
                            )
                            drawCircle(
                                color = selectedColor,
                                radius = 7.dp.toPx()
                            )
                        }
                    }
                }else {
                    Box(modifier = Modifier.padding(15.dp)
                        .size(7.dp)) {
                        Canvas(
                            modifier = Modifier
                                .size(size = 7.dp)
                        ) {
                            drawCircle(
                                color = unselectedColor,
                                radius = 7.dp.toPx()
                            )
                        }
                    }
                }
            }
        }
    }

}


val images = listOf(
    ImageItem(id = R.drawable.property_1),
    ImageItem(id = R.drawable.property_2),
    ImageItem(id = R.drawable.property_3),
    ImageItem(id = R.drawable.property_4)
    // Add more image items as needed
)
