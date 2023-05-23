package com.sunuerico.realestatemobileapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignIn(modifier: Modifier = Modifier){
    val gillSans = FontFamily(
        Font(R.font.gill_sans, FontWeight.Normal),
        Font(R.font.gill_sans_bold, FontWeight.Bold),
        Font(R.font.gill_sans_light, FontWeight.Light),
        Font(R.font.gill_sans_medium, FontWeight.Medium),
        Font(R.font.gill_sans_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.gill_sans_heavy_italic, FontWeight.Bold, FontStyle.Italic)
    )

Box(modifier = modifier.fillMaxSize()) {
    Image(
        painter = painterResource(id = R.drawable.image_4),
        contentDescription = "image 4",
        modifier = Modifier
            .size(size = 669.dp),
        contentScale = ContentScale.FillBounds)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = modifier.weight(1f)) {
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color(0xFFA873EB)),
                        startY = 400.0f,
                        endY = 670f
                    )
                ),
            contentAlignment = Alignment.Center

        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(style = TextStyle(
                    fontSize = 43.sp,
                    fontFamily = gillSans,
                    color = Color.White
                ).copy(lineHeight = 57.sp),
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append("Perfect choice")
                        }
                        append("\nfor your future")
                    })

                Spacer(modifier = Modifier.height(7.09.dp))

                Text(
                    style = TextStyle(fontSize = 20.sp, fontFamily = gillSans, color = Color.White)
                        .copy(lineHeight = 30.sp),
                    text = "Our properties the masterpiece for every client with lasting value."
                )

                Spacer(modifier = Modifier.height(43.01.dp))

                Box() {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(bottom = 18.9.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Skip", Modifier.clickable { /*TODO*/ },
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = gillSans,
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            ).copy(lineHeight = 45.sp)
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White
                            )
                        )
                        {
                            Text(
                                text = "Sign In",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontFamily = gillSans,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF05293C)
                                ).copy(lineHeight = 45.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}
}