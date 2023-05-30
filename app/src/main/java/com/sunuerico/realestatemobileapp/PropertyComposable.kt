package com.sunuerico.realestatemobileapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sunuerico.realestatemobileapp.ui.theme.RealEstateMobileAppTheme

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
                    ImageCarousel(images = images,  autoScrollInterval = 3000L)

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
                            Text(style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = gillSans,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF072A3E)
                            ).copy(lineHeight = 29.sp),
                                text = "Classic Apartment"
                            )
                        }

                        Button(modifier = Modifier
                            .constrainAs(button) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .fillMaxWidth()
                            .height(55.dp),
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


@Preview(showBackground = true)
@Composable
fun PropertyScreenPreview() {
    RealEstateMobileAppTheme {
        PropertyScreen(modifier = Modifier)
    }
}