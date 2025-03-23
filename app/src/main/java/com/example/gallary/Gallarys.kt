package com.example.gallary

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun Gallarys() {
    val selectedIndexImage = remember { mutableStateOf<Int?>(null) }
    val context = LocalContext.current
    val gallery = listOf(
        R.drawable.may,
        R.drawable.airo,
        R.drawable.appa,
        R.drawable.buni,
        R.drawable.momo,
        R.drawable.azula,
        R.drawable.katara,
        R.drawable.kioshi,
        R.drawable.ozai,
        R.drawable.sokka,
        R.drawable.taily,
        R.drawable.toph,
        R.drawable.zuki,
        R.drawable.zuko,
        R.drawable.may,
        R.drawable.airo,
        R.drawable.appa,
        R.drawable.buni,
        R.drawable.momo,
        R.drawable.azula,
        R.drawable.katara,
        R.drawable.kioshi,
        R.drawable.ozai,
        R.drawable.sokka,
        R.drawable.taily,
        R.drawable.toph,
        R.drawable.zuki,
        R.drawable.zuko
    )
    if(selectedIndexImage.value == null) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(gallery.size) { index :Int ->
                GalleryPhoto(
                    imageId = gallery[index]
                ){
                    selectedIndexImage.value = index
                }
            }
        }
    } else {
        Box(

        ) {
            Image(
                painter = painterResource(id = gallery[selectedIndexImage.value!!]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(alignment = Alignment.Center)
            )
            if (selectedIndexImage.value!! > 0) {
                IconButton(
                    { selectedIndexImage.value = selectedIndexImage.value!! - 1 },
                    modifier = Modifier.align(alignment = Alignment.CenterStart)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.left),
                        contentDescription = null,
                        tint = Color.Cyan,
                    )
                }
            } else {
                Toast.makeText(context, "вы на первой фотографии", Toast.LENGTH_SHORT).show()
            }
            if (selectedIndexImage.value!! < gallery.size - 1) {
                IconButton(
                    { selectedIndexImage.value = selectedIndexImage.value!! + 1 },
                    modifier = Modifier.align(alignment = Alignment.CenterEnd)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.right),
                        contentDescription = null,
                        tint = Color.Cyan
                    )
                }
            } else {
                Toast.makeText(context, "вы на последней фотографии", Toast.LENGTH_SHORT).show()
            }

            IconButton(
                { selectedIndexImage.value = null },
                modifier = Modifier.align(alignment = Alignment.BottomCenter)
            ) {
                Icon(
                    painter = painterResource(R.drawable.down),
                    contentDescription = null,
                    tint = Color.Cyan
                )
            }
        }
    }
}

@Composable
fun GalleryPhoto(
    imageId: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(
                Color.Black,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier = Modifier.aspectRatio(1f)
        )
    }
}
