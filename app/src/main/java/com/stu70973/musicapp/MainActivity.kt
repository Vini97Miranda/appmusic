package com.stu70973.musicapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerScreen()
        }
    }
}

@Composable
fun MusicPlayerScreen() {
    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.chapel) }
    var isPlaying by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            if (!isPlaying) {
                mediaPlayer.start()
                isPlaying = true
            }
        }) {
            Text("Play Music")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0) // Reset to the beginning
                isPlaying = false
            }
        }) {
            Text("Stop Music")
        }
    }
}
