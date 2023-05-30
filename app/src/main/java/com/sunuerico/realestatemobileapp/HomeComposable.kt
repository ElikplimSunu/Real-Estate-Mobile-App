package com.sunuerico.realestatemobileapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sunuerico.realestatemobileapp.ui.theme.RealEstateMobileAppTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(color = Color(0xFFF5F6FF))){
        Column(modifier = modifier.fillMaxSize()
            .background(color = Color(0xFFF5F6FF))) {
            Row (verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()) {
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
                IconButton(onClick = { /*TODO*/ },
                    modifier = modifier
                        .size(50.dp)
                        .padding(15.5.dp)
                        .clip(shape = CircleShape)
                        .background(color = Color.White)) {
                    Icon(
                        modifier = modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.magnifying_glass),
                        contentDescription = "search button",
                        tint = Color(0xFF072A3E)
                    )
                }
            }
            Spacer(modifier = modifier.size(20.dp))
            //House and condo buttons
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()) {
                //House button
                IconButton(onClick = { /*TODO*/ },
                    modifier = modifier.weight(1f)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.fillMaxSize()
                    ) {
                        Box(
                            modifier = modifier
                                .clip(shape = CircleShape)
                                .size(50.dp)
                                .background(color = Color(0xFFE1E7FE))
                        ) {
                            Icon(
                                modifier = modifier.size(24.dp)
                                    .align(Alignment.Center),
                                painter = painterResource(id = R.drawable.house),
                                contentDescription = "search button",
                                tint = Color(0xFF325EF1)
                            )
                        }
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        Text(
                            //modifier = Modifier.weight(2f),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = gillSans,
                                color = Color(0xFF1B1B1D)
                            ).copy(lineHeight = 26.sp),
                            text = "House"
                        )
                    }
                }

                //Condo button
                IconButton(onClick = { /*TODO*/ },
                    modifier = modifier.weight(1f)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        //modifier = modifier.fillMaxSize()
                    ) {
                        Box(
                            modifier = modifier
                                .clip(shape = CircleShape)
                                .size(50.dp)
                                .background(color = Color(0xFFF6E6F6))
                        ) {
                            Icon(
                                modifier = modifier.size(24.dp)
                                    .align(Alignment.Center),
                                painter = painterResource(id = R.drawable.condo),
                                contentDescription = "condo button",
                                tint = Color(0xFFFF569D)
                            )
                        }
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        Text(
                            //modifier = Modifier.weight(2f),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = gillSans,
                                color = Color(0xFF1B1B1D)
                            ).copy(lineHeight = 26.sp),
                            text = "Condo"
                        )
                    }
                }
            }

            Spacer(modifier = modifier.size(10.dp))
            //Villa and Apartment buttons
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()) {
                //Villa button
                IconButton(onClick = { /*TODO*/ },
                    modifier = modifier.weight(1f)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.fillMaxSize()
                    ) {
                        Box(
                            modifier = modifier
                                .clip(shape = CircleShape)
                                .size(50.dp)
                                .background(color = Color(0xFFF4E7FF))
                        ) {
                            Icon(
                                modifier = modifier.size(24.dp)
                                    .align(Alignment.Center),
                                painter = painterResource(id = R.drawable.villa),
                                contentDescription = "villa button",
                                tint = Color(0xFFB558FE)
                            )
                        }
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        Text(
                            //modifier = Modifier.weight(2f),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = gillSans,
                                color = Color(0xFF1B1B1D)
                            ).copy(lineHeight = 26.sp),
                            text = "Villa"
                        )
                    }
                }

                //Condo button
                IconButton(onClick = { /*TODO*/ },
                    modifier = modifier.weight(1f)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        //modifier = modifier.fillMaxSize()
                    ) {
                        Box(
                            modifier = modifier
                                .clip(shape = CircleShape)
                                .size(50.dp)
                                .background(color = Color(0xFFF6E6F6))
                        ) {
                            Icon(
                                modifier = modifier.size(24.dp)
                                    .align(Alignment.Center),
                                painter = painterResource(id = R.drawable.condo),
                                contentDescription = "condo button",
                                tint = Color(0xFFFF569D)
                            )
                        }
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        Text(
                            //modifier = Modifier.weight(2f),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = gillSans,
                                color = Color(0xFF1B1B1D)
                            ).copy(lineHeight = 26.sp),
                            text = "Apartment"
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeComposablePreview() {
    RealEstateMobileAppTheme {
        HomeScreen()
    }
}