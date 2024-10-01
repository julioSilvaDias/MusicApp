package com.example.musicapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

var cont: Int = 0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            musicAppEstado()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Preview(
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
)
@Composable
fun musicAppEstado() {
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            musicAppHorizontal()
        }

        else -> {
            musicAppVertical()
        }

    }
}


@Composable
fun musicAppVertical() {
    val btnPause = R.drawable.pause
    val btnPlay = R.drawable.play_arrow
    val btnNext = R.drawable.skip_next
    val btnPrevious = R.drawable.skip_previous
    val btnList = R.drawable.list
    val btnEditNote = R.drawable.edit_note
    val btnShare = R.drawable.share
    val imageDisco = R.drawable.disco_image
    var currentImage by remember { mutableStateOf(btnPlay) }
    val nombreGrupo = stringResource(R.string.nombre_grupo)
    val nombreCancion = stringResource(R.string.nombre_cancion)


    fun onClickPlayPause() {
        currentImage = if (currentImage == btnPlay) {
            btnPause
        } else {
            btnPlay
        }
    }

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth()) {
            image(R.drawable.volume_up, 59)
            seekBar(70f)
        }
        filaBotones(imagen2 = btnList,
            imagen1 = btnShare,
            imagen3 = btnEditNote,
            onClick1 = {},
            onClick2 = {},
            onClick3 = {},
            size = 40

        )

        Row(
            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            image(imageDisco, 400)
        }

        textView(nombreGrupo, 30)
        textView(nombreCancion, 24)
        Row(Modifier.fillMaxWidth()) {
            seekBar(25f)
        }
        filaBotones(imagen2 = currentImage,
            imagen1 = btnPrevious,
            imagen3 = btnNext,
            onClick1 = {},
            onClick2 = { onClickPlayPause() },
            onClick3 = {},
            size = 89

        )
    }
}

@Composable
fun musicAppHorizontal() {
    val btnPause = R.drawable.pause
    val btnPlay = R.drawable.play_arrow
    val btnNext = R.drawable.skip_next
    val btnPrevious = R.drawable.skip_previous
    val btnList = R.drawable.list
    val btnEditNote = R.drawable.edit_note
    val btnShare = R.drawable.share
    val imageDisco = R.drawable.disco_image
    var currentImage by remember { mutableStateOf(btnPlay) }
    val nombreGrupo = stringResource(R.string.nombre_grupo)
    val nombreCancion = stringResource(R.string.nombre_cancion)


    fun onClickPlayPause() {
        currentImage = if (currentImage == btnPlay) {
            btnPause
        } else {
            btnPlay
        }
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.SpaceEvenly) {
            Row(
                Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                image(imageDisco, 300)
            }

            Row{
                filaBotones(imagen2 = btnList,
                    imagen1 = btnShare,
                    imagen3 = btnEditNote,
                    onClick1 = {},
                    onClick2 = {},
                    onClick3 = {},
                    size = 40

                )
            }
        }
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.SpaceEvenly) {
            Row(Modifier.fillMaxWidth().padding(top=20.dp, bottom = 20.dp)) {
                image(R.drawable.volume_up, 59)
                seekBar(70f)
            }

            textView(nombreGrupo, 30)
            textView(nombreCancion, 24)
            Row(Modifier.fillMaxWidth().padding(top=20.dp, bottom = 20.dp)) {
                seekBar(25f)
            }
            filaBotones(imagen2 = currentImage,
                imagen1 = btnPrevious,
                imagen3 = btnNext,
                onClick1 = {},
                onClick2 = { onClickPlayPause() },
                onClick3 = {},
                size = 89

            )

        }
    }
}

@Composable
fun seekBar(percent: Float) {
    var sliderPosition by remember { mutableStateOf(percent) }
    Slider(
        value = sliderPosition, onValueChange = { newValue ->
            sliderPosition = newValue
        }, valueRange = 0f..100f
    )

}


@Composable
fun filaBotones(
    imagen1: Int,
    imagen2: Int,
    imagen3: Int,
    onClick2: () -> Unit,
    onClick1: () -> Unit,
    onClick3: () -> Unit,
    size: Int
) {
    Row(
        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            modifier = Modifier.size(size.dp), onClick = onClick1

        ) {
            Icon(
                painter = painterResource(id = imagen1),
                contentDescription = "Descripción de la imagen"
            )
        }

        IconButton(
            modifier = Modifier.size(size.dp), onClick = onClick2
        ) {
            Icon(
                painter = painterResource(id = imagen2),
                contentDescription = "Descripción de la imagen"
            )
        }

        IconButton(
            modifier = Modifier.size(size.dp), onClick = onClick3

        ) {
            Icon(
                painter = painterResource(id = imagen3),
                contentDescription = "Descripción de la imagen"
            )
        }
    }


}

@Composable
fun textView(text: String, fontSize: Int) {
    Row(
        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun image(id: Int, size: Int) {

    Image(
        painter = painterResource(id),
        contentDescription = "Descripción de la imagen",
        modifier = Modifier
            .size(size.dp)
            .padding(16.dp)
    )

}
