package com.sunuerico.realestatemobileapp
//
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.interaction.collectIsDraggedAsState
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.pager.HorizontalPager
//import androidx.compose.foundation.pager.PagerState
//import androidx.compose.foundation.pager.rememberPagerState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.dimensionResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import androidx.paging.compose.LazyPagingItems
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
//@Composable
//fun HomeMediaCarousel(
//    list: LazyPagingItems<ImageItem>,
//    totalItem: Int = 4,
//    pagerState: PagerState = rememberPagerState(),
//    autoScrollDuration: Long = 3000L,
//    onItemClicked: (ImageItem) -> Unit
//) {
//    val pageCount = list.itemCount.coerceAtMost(totalItem)
//    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
//    if (isDragged.not()) {
//        with(pagerState) {
//            if (pageCount > 0) {
//                var currentPageKey by remember { mutableIntStateOf(0) }
//                LaunchedEffect(key1 = currentPageKey) {
//                    launch {
//                        delay(timeMillis = autoScrollDuration)
//                        val nextPage = (currentPage + 1).mod(pageCount)
//                        animateScrollToPage(page = nextPage)
//                        currentPageKey = nextPage
//                    }
//                }
//            }
//        }
//    }
//
//    Box {
//        HorizontalPager(
//            pageCount = pageCount,
//            state = pagerState,
//            contentPadding = PaddingValues(
//                horizontal = 32.dp
//            ),
//            pageSpacing = 16.dp
//        ) { page ->
//            val item:ImageItem = list[page]!!
//            Card(
//                onClick = { onItemClicked(item) },
//                modifier = Modifier
//            ) {
//                CarouselItem(item)
//            }
//        }
//
//        DotIndicators(
//            pageCount = pageCount,
//            pagerState = pagerState,
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//        )
//    }
//}
//
//@Composable
//fun CarouselItem(item: ImageItem) {
//    Box {
//        Image(
//            painter = painterResource(id = R.drawable.property_1),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .height(160.dp)
//                .fillMaxWidth()
//        )
////        val gradient =
////            Brush.verticalGradient(listOf(Color.Transparent, flick_color_translucent_black))
//
////        Text(
////            text = item.name,
////            color = Color.White,
////            maxLines = 2,
////            overflow = TextOverflow.Ellipsis,
////            modifier = Modifier
////                .fillMaxWidth()
////                .align(Alignment.BottomCenter)
////                .background(gradient)
////                .padding(
////                    horizontal = dimensionResource(id = R.dimen.normal_padding),
////                    vertical = dimensionResource(id = R.dimen.normal_padding)
////                )
////        )
//    }
//}
//
//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun DotIndicators(
//    pageCount: Int,
//    pagerState: PagerState,
//    selectedColor: Color = Color.DarkGray,
//    unselectedColor: Color = Color.LightGray,
//    modifier: Modifier
//) {
//    Row(
//        modifier = modifier
//            .height(15.dp)
//            .fillMaxWidth()
//            .padding(bottom = 6.dp),
//        horizontalArrangement = Arrangement.Center,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        repeat(pageCount) { iteration ->
//            if (pagerState.currentPage == iteration) {
//                Box(modifier = Modifier.padding(4.dp)
//                    .size(6.dp)) {
//                    Canvas(
//                        modifier = Modifier
//                            .size(size = 6.dp)
////                                .padding(2.dp)
//                    ) {
//                        drawCircle(
//                            color = selectedColor,
//                            radius = 6.dp.toPx(),
//                            style = Stroke(width = 1.dp.toPx())
//                        )
//                        drawCircle(
//                            color = selectedColor,
//                            radius = 4.dp.toPx()
//                        )
//                    }
//                }
//            } else {
//                Box(modifier = Modifier.padding(4.dp)
//                    .size(4.dp)) {
//                    Canvas(
//                        modifier = Modifier
//                            .size(size = 4.dp)
//                    ) {
//                        drawCircle(
//                            color = unselectedColor,
//                            radius = 4.dp.toPx()
//                        )
//                    }
//                }
//            }
//
//
//
////                Box(
////                    modifier = Modifier
////                        .padding(dimensionResource(id = R.dimen.dot_indicator_padding))
////                        .clip(CircleShape)
////                        .background(Color.LightGray)
////                        .size(dimensionResource(id = R.dimen.dot_indicator_size))
////
////                )
//
//        }
//    }
//}
