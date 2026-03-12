package com.example.profileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileApp()
        }
    }
}

@Composable
fun ProfileApp() {

    var showButtons by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        showButtons = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F2027),
                        Color(0xFF203A43),
                        Color(0xFF2C5364)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(60.dp))

            ProfileSection()

            Spacer(modifier = Modifier.height(15.dp))

            AnimatedVisibility(
                visible = showButtons,
                enter = fadeIn()
            ) {
                ProfileButtons()
            }

            Spacer(modifier = Modifier.height(35.dp))

            ContactCard()

            Spacer(modifier = Modifier.height(25.dp))

            HorizontalDivider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(25.dp))

            SkillSection()
        }
    }
}

@Composable
fun ProfileSection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .border(3.dp, Color.White, CircleShape)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Card(
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.08f)
            )
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Prima Sembiring",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Teknik Informatika",
                    color = Color(0xFFB0BEC5)
                )

                Text(
                    text = "Data Scientist",
                    color = Color(0xFF00E5FF),
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Institut Teknologi Sumatera (ITERA)",
                    color = Color(0xFFB0BEC5)
                )
            }
        }
    }
}

@Composable
fun ProfileButtons() {

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Button(
            onClick = { },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00E5FF)
            )
        ) {

            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = "Send"
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "Kirim Pesan",
                color = Color.Black
            )
        }

        OutlinedButton(
            onClick = { },
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, Color(0xFF00E5FF))
        ) {

            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Add Friend",
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "Add Friend",
                color = Color.White
            )
        }
    }
}

@Composable
fun ContactCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.08f)
        )
    ) {

        Column(
            modifier = Modifier.padding(25.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            ContactItem(Icons.Default.Email,"Email","prima@email.com")
            ContactItem(Icons.Default.Phone,"WhatsApp","+62 812345678")
            ContactItem(Icons.Default.LocationOn,"Location","Lampung, Indonesia")

        }
    }
}

@Composable
fun ContactItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = Color(0xFF00E5FF),
            modifier = Modifier.size(30.dp)
        )

        Spacer(modifier = Modifier.width(18.dp))

        Column {

            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = value,
                color = Color(0xFFB0BEC5)
            )
        }
    }
}

@Composable
fun SkillSection() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.08f)
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "Skills",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            SkillCategory("Programming","Python, SQL, R")
            Spacer(modifier = Modifier.height(12.dp))

            SkillCategory("Data Analysis","Pandas, NumPy, EDA, Data Cleaning")
            Spacer(modifier = Modifier.height(12.dp))

            SkillCategory("Machine Learning","Classification, Regression, Clustering")

            Text(
                text = "Random Forest, XGBoost, LightGBM",
                color = Color(0xFFB0BEC5),
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            SkillCategory("Visualization","Matplotlib, Seaborn, Tableau")
            Spacer(modifier = Modifier.height(12.dp))

            SkillCategory("Statistics","Hypothesis Testing, Probability, Regression")
        }
    }
}

@Composable
fun SkillCategory(title:String,content:String){

    Column {

        Text(
            text = title,
            color = Color(0xFF90CAF9),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = content,
            color = Color(0xFFB0BEC5),
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}