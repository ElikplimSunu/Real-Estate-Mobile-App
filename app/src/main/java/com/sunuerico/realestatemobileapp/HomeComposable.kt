package com.sunuerico.realestatemobileapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sunuerico.realestatemobileapp.ui.theme.RealEstateMobileAppTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF5F6FF))
            .padding(20.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color(0xFFF5F6FF))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(style = TextStyle(
                    fontSize = 43.sp,
                    fontFamily = gillSans,
                    color = Color(0xFF072A3E)
                ).copy(lineHeight = 57.sp),
                    text = buildAnnotatedString {
                        append("What are you")
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append("\nlooking")
                        }
                        append(" for?")

                    })
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = modifier
                        .size(50.dp)
                        .padding(15.5.dp)
                        .clip(shape = CircleShape)
                        .background(color = Color.White)
                ) {
                    Icon(
                        modifier = modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.magnifying_glass),
                        contentDescription = "search button",
                        tint = Color(0xFF072A3E)
                    )
                }
            }
            Spacer(modifier = modifier.height(20.dp))

            Row (modifier = modifier.fillMaxWidth()) {

                ConstraintLayout(modifier = modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .height(70.dp),
                    ) {
                    val (houseButton, villaButton) = createRefs()
                    //House button
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .fillMaxSize()
                            .constrainAs(houseButton) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.fillMaxSize()
                        ) {
                            Surface(
                                modifier = modifier
                                    .clip(shape = CircleShape)
                                    .size(60.dp)
                                    .background(color = Color(0xFFE1E7FE))
                                    .padding(13.dp)

                            ) {
                                Icon(
                                    modifier = modifier
                                        .size(24.dp)
                                        .background(color = Color(0xFFE1E7FE)),
                                    painter = painterResource(id = R.drawable.house),
                                    contentDescription = "search button",
                                    tint = Color(0xFF325EF1)
                                )
                            }
                            Spacer(modifier = Modifier.width(width = 8.dp))
                            Text(
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = gillSans,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF1B1B1D)
                                ).copy(lineHeight = 26.sp),
                                text = "House"
                            )
                        }
                    }

                    //Villa button
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .fillMaxSize()
                            .constrainAs(villaButton) {
                                start.linkTo(parent.start)
                                top.linkTo(houseButton.bottom)
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.fillMaxSize()
                        ) {
                            Surface(
                                modifier = modifier
                                    .clip(shape = CircleShape)
                                    .size(60.dp)
                                    .background(color = Color(0xFFF4E7FF))
                                    .padding(13.dp)

                            ) {
                                Icon(
                                    modifier = modifier
                                        .size(24.dp)
                                        .background(color = Color(0xFFF4E7FF)),
                                    painter = painterResource(id = R.drawable.villa),
                                    contentDescription = "villa button",
                                    tint = Color(0xFFB558FE)
                                )
                            }
                            Spacer(modifier = Modifier.width(width = 8.dp))
                            Text(
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = gillSans,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF1B1B1D)
                                ).copy(lineHeight = 26.sp),
                                text = "Villa"
                            )
                        }
                    }
                }

                ConstraintLayout(modifier = modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .height(70.dp)) {
                    val (condoButton, apartmentButton) = createRefs()
                    //House button
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .fillMaxSize()
                            .constrainAs(condoButton) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.fillMaxSize()
                        ) {
                            Surface(
                                modifier = modifier
                                    .clip(shape = CircleShape)
                                    .size(60.dp)
                                    .background(color = Color(0xFFF6E6F6))
                                    .padding(13.dp)

                            ) {
                                Icon(
                                    modifier = modifier
                                        .size(24.dp)
                                        .background(color = Color(0xFFF6E6F6)),
                                    painter = painterResource(id = R.drawable.condo),
                                    contentDescription = "condo button",
                                    tint = Color(0xFFFF569D)
                                )
                            }
                            Spacer(modifier = Modifier.width(width = 8.dp))
                            Text(
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = gillSans,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF1B1B1D)
                                ).copy(lineHeight = 26.sp),
                                text = "Condo"
                            )
                        }
                    }

                    //Apartment button
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .fillMaxSize()
                            .constrainAs(apartmentButton) {
                                start.linkTo(parent.start)
                                top.linkTo(condoButton.bottom)
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.fillMaxSize()
                        ) {
                            Surface(
                                modifier = modifier
                                    .clip(shape = CircleShape)
                                    .size(60.dp)
                                    .background(color = Color(0xFFCDEDF1))
                                    .padding(13.dp)

                            ) {
                                Icon(
                                    modifier = modifier
                                        .size(24.dp)
                                        .background(color = Color(0xFFCDEDF1)),
                                    painter = painterResource(id = R.drawable.apartment),
                                    contentDescription = "apartment button",
                                    tint = Color(0xFF34CD8E)
                                )
                            }
                            Spacer(modifier = Modifier.width(width = 8.dp))
                            Text(
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = gillSans,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF1B1B1D)
                                ).copy(lineHeight = 26.sp),
                                text = "Apartment"
                            )
                        }
                    }
                }
            }

            Spacer(modifier = modifier.height(56.dp))

            Row(modifier = modifier
                .fillMaxWidth()
                .padding(top = 56.dp)
                .height(26.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = gillSans,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF05293C)
                    ).copy(lineHeight = 26.sp),
                    text = "Trending Properties"
                )

                Spacer(modifier = modifier.width(36.dp))

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = modifier.fillMaxSize()
                    ) {
                        Text(
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = gillSans,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF375FE3),
                                textAlign = TextAlign.Right
                            ).copy(lineHeight = 26.sp),
                            text = "See All"
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                            Icon(
                                modifier = modifier
                                    .width(8.dp)
                                    .height(12.dp),
                                painter = painterResource(id = R.drawable.see_more_arrow),
                                contentDescription = "see more arrow",
                                tint = Color(0xFF325EF1)
                            )
                    }
                }

            }

            Spacer(modifier = Modifier.height(29.dp))

            LazyRow {
                items(propertyItems) { item ->
                    TrendingProperties(item = item)
                    Spacer(modifier = Modifier.width(width = 28.dp))
                }
            }
        }
    }
}

@Composable
fun TrendingProperties(item: PropertyItem) {
    Box(modifier = Modifier
        .width(207.dp)
        .height(272.dp)
        .background(item.background, shape = RoundedCornerShape(16.dp))
        .padding(15.dp)) {
        ConstraintLayout {
            val (propertyImage, propertyName, propertyLocation, ratingStar, propertyRating) = createRefs()

            Image(
                modifier = Modifier
                    .width(177.dp)
                    .height(183.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .constrainAs(propertyImage) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    },
                painter = painterResource(id = item.image),
                contentDescription = "property image",
                contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier.constrainAs(propertyName) {
                    start.linkTo(parent.start)
                    top.linkTo(propertyImage.bottom, margin = 8.dp)
                },
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = gillSans,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF1B1B1D)
                ),
                text = item.name
            )


            Text(
                modifier = Modifier.constrainAs(propertyLocation) {
                    start.linkTo(parent.start)
                    top.linkTo(propertyName.bottom, margin = 4.dp)
                },
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = gillSans,
                    fontWeight = FontWeight(300),
                    color = Color(0xFF05293C)
                ),
                text = item.location
            )

            Image(modifier = Modifier.constrainAs(ratingStar) {
                end.linkTo(propertyRating.start)
                top.linkTo(propertyName.bottom, margin = 4.dp)
            },
            painter = painterResource(id = R.drawable.star),
            contentDescription = "rating star")

            Text(
                modifier = Modifier.constrainAs(propertyRating) {
                    end.linkTo(parent.end)
                    top.linkTo(propertyName.bottom, margin = 4.dp)
                },
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = gillSans,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF05293C)
                ),
                text = item.rating.toString()
            )
        }
    }
}

val propertyItems = listOf(
    PropertyItem(
        image = R.drawable.property_4,
        name = "Wiley’s Cottage",
        location = "Brookline",
        rating = 4.5,
        background = Brush.linearGradient(listOf(Color(0xFFFF8899), Color(0xFFFFE8EB)))
    ),
    PropertyItem(
        image = R.drawable.property_3,
        name = "Town Center",
        location = "Dorchester",
        rating = 4.9,
        background = Brush.linearGradient(listOf(Color(0xFFA7D3FD), Color(0xFFE9F4FF)))
    ),
    PropertyItem(
        image = R.drawable.property_2,
        name = "The Grand",
        location = "New York, USA",
        rating = 4.3,
        background = Brush.linearGradient(listOf(Color(0xFFFF8899), Color(0xFFFFE8EB)))
    ),
    PropertyItem(
        image = R.drawable.property_1,
        name = "Cottage",
        location = "New York, USA",
        rating = 4.2,
        background = Brush.linearGradient(listOf(Color(0xFFA7D3FD), Color(0xFFE9F4FF)))
    )
)


@Preview(showBackground = true)
@Composable
fun HomeComposablePreview() {
    RealEstateMobileAppTheme {
        HomeScreen()
    }
}