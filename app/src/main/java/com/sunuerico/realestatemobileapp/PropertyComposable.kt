package com.sunuerico.realestatemobileapp

import android.text.Layout
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sunuerico.realestatemobileapp.ui.theme.RealEstateMobileAppTheme
import java.lang.reflect.AnnotatedElement

val mulish = FontFamily(
    Font(R.font.mulish_light, FontWeight.Light),
    Font(R.font.mulish_regular, FontWeight.Normal),
    Font(R.font.mulish_medium, FontWeight.Medium),
    Font(R.font.mulish_bold, FontWeight.Bold),
    Font(R.font.mulish_bold_italic, FontWeight.Bold, FontStyle.Italic)
)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PropertyScreen(modifier: Modifier = Modifier){

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val halfScreenHeight = screenHeight / 2

    ConstraintLayout {
        val (textBox, imageBox) = createRefs()

        Box(modifier = modifier
            .height(515.dp)
            .fillMaxWidth()
            .constrainAs(imageBox) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }){
            ImageCarousel(images = images,  autoScrollInterval = 2000L)

        }
        Box (modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp)
            )
            .constrainAs(textBox) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .height(halfScreenHeight)
            .fillMaxWidth()
            .padding(20.dp)) {

            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (button, textColumn) = createRefs()
                Column(modifier = Modifier.constrainAs(textColumn) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }) {
                    Text(
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = gillSans,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF072A3E)
                        ).copy(lineHeight = 29.sp),
                        text = "Classic Apartment"
                    )

                    Spacer(modifier = modifier.height(11.dp))

                    Text(
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = mulish,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF072A3E),
                            letterSpacing = 0.2.sp
                        ).copy(lineHeight = 29.sp),
                        text = "New Boston"
                    )

                    Spacer(modifier = modifier.height(14.dp))

                    Row {
                        RatingBar(modifier = modifier, rating = 4.0f, spaceBetween = 4.69.dp)

                        Spacer(modifier = modifier.width(10.dp))
                        //number of reviews
                        val numberOfReviews = 178
                        Text(
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = gillSans,
                                fontWeight = FontWeight(600),
                                color = Color(0xFFB8C6D6)
                            ).copy(lineHeight = 29.sp),
                            text = "( $numberOfReviews reviews )"
                        )
                    }

                    Spacer(modifier = modifier.height(23.dp))

                    Row (verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.router), contentDescription = "router icon")
                        val numberOfRouters = 3; val numberOfBeds = 2; val numberOfBathrooms = 2; val numberOfBathtubs = 4
                        Text(
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = gillSans,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF212843),
                                letterSpacing = 0.2.sp
                            ).copy(lineHeight = 29.sp),
                            text = "$numberOfRouters"
                        )

                        Spacer(modifier = modifier.width(16.89.dp))

                        Image(painter = painterResource(id = R.drawable.bed), contentDescription = "bed icon")
                        Text(
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = gillSans,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF212843),
                                letterSpacing = 0.2.sp
                            ).copy(lineHeight = 29.sp),
                            text = "$numberOfBeds"
                        )

                        Spacer(modifier = modifier.width(16.89.dp))

                        Image(painter = painterResource(id = R.drawable.bathroom), contentDescription = "bathroom icon")
                        Text(
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = gillSans,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF212843),
                                letterSpacing = 0.2.sp
                            ).copy(lineHeight = 29.sp),
                            text = "$numberOfBathrooms"
                        )

                        Spacer(modifier = modifier.width(16.89.dp))

                        Image(painter = painterResource(id = R.drawable.bathtub), contentDescription = "bathtub icon")
                        Text(
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = gillSans,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF212843),
                                letterSpacing = 0.2.sp
                            ).copy(lineHeight = 29.sp),
                            text = "$numberOfBathtubs"
                        )
                    }

                    Text(
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = mulish,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF345AD8)
                        ).copy(lineHeight = 29.sp),
                        text = "\$1,135.00"
                    )

                    Spacer(modifier = modifier.height(17.dp))

                    val tabTitles = listOf("Details", "Reviews", "Map")
                    val tabItems = listOf(stringResource(R.string.details_tab_text),
                        stringResource(R.string.details_tab_text), stringResource(R.string.details_tab_text))
                    val pagerState = rememberPagerState(
                        initialPage = 0,
                        initialPageOffsetFraction = 0f
                    ) {
                        // provide pageCount
                        tabTitles.size
                    }

                    TabRow(selectedTabIndex = pagerState.currentPage, indicator = {
                            tabPositions ->
//                        TabRowDefaults.Indicator(
//                            modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
//                                .padding(horizontal = 40.dp)
//                                .width(31.dp)
//                                .height(3.dp),
//                            color = Color(0xFFA588FF),
//                            height = 3.dp
//                        )

                        Box(
                            modifier = modifier
                                .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                                .width(31.dp)
                                .height(5.dp)
                                .align(Alignment.Start)
                                .padding(top = 0.dp, bottom = 0.dp, end = 70.dp)
                                .background(
                                    color = Color(0xFFA588FF),
                                    shape = RoundedCornerShape(2.dp)
                                )
                        )
                    }) {
                        tabTitles.forEachIndexed { index, title ->
                            Tab (
                                text = {
//                                        Row(modifier = modifier.fillMaxSize(1f).align(Alignment.Start), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Bottom) {

                                    Text(modifier = modifier
                                        .fillMaxSize()
                                        .align(Alignment.Start),
                                        textAlign = TextAlign.Start,
                                        text = title,
                                        style = if (pagerState.currentPage == index) {
                                            TextStyle(
                                                fontSize = 14.sp,
                                                fontFamily = gillSans,
                                                fontWeight = FontWeight(600),
                                                color = Color(0xFF212843)
                                            )
                                        } else {
                                            TextStyle(
                                                fontSize = 14.sp,
                                                fontFamily = gillSans,
                                                fontWeight = FontWeight(600),
                                                color = Color(0xFFB8C6D6)
                                            )
                                        }
                                    )
//                                        }
                                },
                                // Customize the color of the tab title
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.White)
//                                    .padding(bottom = 0.dp, end = 40.dp) // Shift the tab title downwards
                                    .align(Alignment.Start),
                                selected = pagerState.currentPage == index,
                                onClick = { /*TODO*/ })
                        }
                    }

                    Spacer(modifier = modifier.height(12.dp))

                    HorizontalPager(state = pagerState) { page ->
                        ExpandingText(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 12.sp,
                                        fontFamily = gillSans,
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF212843),
                                        letterSpacing = 0.15.sp
                                    )
                                ) {
                                    append(tabItems[page])
                                }
                        }
                        )
                    }
                }

                Button(modifier = Modifier
                    .constrainAs(button) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(top = 52.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF072A3E)
                    ),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "Continue",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = gillSans,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFFFFFFF)
                        ).copy(lineHeight = 21.sp)
                    )

                }
            }

        }
    }

}

@Composable
fun RatingBar (modifier: Modifier, rating: Float, spaceBetween: Dp = 0.dp) {
    val image = painterResource(id = R.drawable.unfilled_star)
    val imageFull = painterResource(id = R.drawable.filled_star)

    Row(modifier = modifier) {
        for (i in 1..5) {
            if (i <= rating) {
                Image(imageFull, null)
            } else {
                Image(image, null)
            }
            Spacer(modifier = Modifier.width(spaceBetween))
        }
    }
}

private const val MINIMIZED_MAX_LINES = 3

@Composable
fun ExpandingText(modifier: Modifier = Modifier, text: AnnotatedString) {
    var isExpanded by remember { mutableStateOf(false) }
    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    var isClickable by remember { mutableStateOf(false) }
    var finalText: AnnotatedString by remember { mutableStateOf(text) }

    val textLayoutResult = textLayoutResultState.value
    LaunchedEffect(textLayoutResult) {
        if (textLayoutResult == null) return@LaunchedEffect

        when {
            isExpanded -> {
                finalText = buildAnnotatedString {
                    append(text)
                    withStyle(style = SpanStyle(
                        fontFamily = gillSans,
                        fontSize = 12.sp,
                        color = Color(0xFF345AD8),
                        fontWeight = FontWeight.Bold
                    )
                    ) {
                        append(" See Less")
                    }
                }
            }
            !isExpanded && textLayoutResult.hasVisualOverflow -> {
                val lastCharIndex = textLayoutResult.getLineEnd(MINIMIZED_MAX_LINES - 1)
                val showMoreString = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        fontFamily = gillSans,
                        fontSize = 12.sp,
                        color = Color(0xFF345AD8),
                        fontWeight = FontWeight.Bold
                    )
                    ) {
                        append(" See More")
                    }
                }

                val adjustedText = text
                    .substring(startIndex = 0, endIndex = lastCharIndex)
                    .dropLast(showMoreString.length)
                    .dropLastWhile { it == ' ' || it == '.' }

                finalText = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = gillSans,
                        fontSize = 12.sp,
                        color = Color(0xFF212843),
                        fontWeight = FontWeight(500))){append(adjustedText)}

                    withStyle(style = SpanStyle(
                        fontFamily = gillSans,
                        fontSize = 12.sp,
                        color = Color(0xFF345AD8),
                        fontWeight = FontWeight.Bold
                    )){append(showMoreString)}

                }

                isClickable = true
            }
        }
    }

    Text(
        text = finalText,
        maxLines = if (isExpanded) Int.MAX_VALUE else MINIMIZED_MAX_LINES,
        onTextLayout = { textLayoutResultState.value = it },
        modifier = modifier
            .clickable(enabled = isClickable) { isExpanded = !isExpanded }
            .animateContentSize(),
    )

}


@Preview(showBackground = true)
@Composable
fun PropertyScreenPreview() {
    RealEstateMobileAppTheme {
        PropertyScreen(modifier = Modifier)
    }
}