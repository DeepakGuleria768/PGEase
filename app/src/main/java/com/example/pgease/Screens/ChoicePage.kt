package com.example.pgease.Screens


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pgease.R
import com.example.pgease.ui.theme.myFont


@Composable
fun ChooseType() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(top = 50.dp), horizontalArrangement = Arrangement.Start) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.clickable {}.background(color = Color.White).
                    size(230.dp),
                    painter = painterResource(R.drawable.ownerimage),
                    contentDescription = "image"
                )
                Text("OWNER", fontSize = 40.sp, fontWeight = FontWeight.Bold, fontFamily = myFont)
            }
        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 50.dp), horizontalArrangement = Arrangement.End) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.clickable {}.size(230.dp).background(color = Color.White),
                    painter = painterResource(R.drawable.tenantimage),
                    contentDescription = "image"
                )
                Text("TENANT", fontSize = 40.sp, fontWeight = FontWeight.Bold, fontFamily = myFont)
            }
        }
    }
}

