package com.sunuerico.realestatemobileapp

import android.media.Image
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sunuerico.realestatemobileapp.ui.theme.RealEstateMobileAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PropertyScreen(modifier: Modifier = Modifier){

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val halfScreenHeight = screenHeight / 2

    Box(modifier = modifier.fillMaxSize()){
        Column {
            Box(modifier = modifier
                .height(halfScreenHeight)
                .fillMaxWidth()){
               ImageCarousel(images = images,  autoScrollInterval = 3000L)

            }
            Box {

            }
        }
    }
}


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
                    .aspectRatio(1f)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }

    // Indicator colors
    val selectedColor = Color.Green
    val unselectedColor = Color.LightGray

    // Indicator radius and spacing
    val indicatorSize = 12.dp
    val indicatorSpacing = 12.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyRow(
            state = scrollState,
            modifier = Modifier.fillMaxSize()
        ) {
            items(images) { item ->
                Image(
                    painter = painterResource(id = item.id),
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            images.forEachIndexed { index, _ ->
                if (index == currentItemIndex) {
                    Box(modifier = Modifier.padding(4.dp)
                        .size(6.dp)) {
                        Canvas(
                            modifier = Modifier
                                .size(size = 6.dp)
//                                .padding(2.dp)
                        ) {
                            drawCircle(
                                color = selectedColor,
                                radius = 6.dp.toPx(),
                                style = Stroke(width = 1.dp.toPx())
                            )
                            drawCircle(
                                color = selectedColor,
                                radius = 4.dp.toPx()
                            )
                        }
                    }
                }else {
                    Box(modifier = Modifier.padding(4.dp)
                        .size(4.dp)) {
                        Canvas(
                            modifier = Modifier
                                .size(size = 4.dp)
                        ) {
                            drawCircle(
                                color = unselectedColor,
                                radius = 4.dp.toPx()
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

@Preview(showBackground = true)
@Composable
fun PropertyScreenPreview() {
    RealEstateMobileAppTheme {
        PropertyScreen(modifier = Modifier)
    }
}