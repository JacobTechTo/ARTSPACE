package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtspaceTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtspaceTheme {
                ArtSpaceApp()
            }
        }
    }
}



@Composable
fun ArtSpaceApp() {

    val images = listOf(
        R.drawable.mystic, // Replace these with your actual drawable resource IDs
        R.drawable.north_dakota_mansion,
        R.drawable.download__2_,
        R.drawable.download__3_,
        R.drawable.michael_douglas_and_catherine_zeta_jones_splash_out_on_mansion
    )

    val (artTitle, setArtTitle) = remember { mutableStateOf("") }
    val (artistName, setArtistName) = remember { mutableStateOf("") }
    
    

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            items(images) { imageRes ->
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Art Image",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }

        TextField(
            value = artTitle,
            onValueChange = setArtTitle,
            label = { Text("Art Title") },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        TextField(
            value = artistName,
            onValueChange = setArtistName,
            label = { Text("Artist Name") },
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            CustomButton(text = "Like") {
                //TODO: Add like functionality
            }
            CustomButton(text = "Share") {
                //TODO: Add share functionality
            }
        }
    }
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Blue,
        contentColor = Color.White,
        disabledContainerColor = Color.Gray,
        disabledContentColor = Color.DarkGray
    )
    val isHovered by interactionSource.collectIsHoveredAsState()

    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(50))
            .background(if (isHovered) Color.Cyan else Color.Gray),
        colors = buttonColors,
        interactionSource = interactionSource
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtspaceTheme {
        ArtSpaceApp()
    }
}