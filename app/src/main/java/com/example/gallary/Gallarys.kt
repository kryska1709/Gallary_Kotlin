package com.example.gallery

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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gallary.R

@Composable
fun Gallarys() {
    val selectedImage = remember { mutableStateOf<Int?>(null) }
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

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(gallery) { imageId ->
            GalleryPhoto(
                imageId = imageId,
                onClick = {
                    selectedImage.value = imageId
                }
            )
        }
    }
    selectedImage.value?.let {
        AlertDialog(
            onDismissRequest = { selectedImage.value },
            modifier = Modifier.fillMaxSize(),
            confirmButton = {
                Button({ selectedImage.value = null }) {
                    Text(text = "назад")
                }
            },
            text = {Image(
                painter = painterResource(it),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
            )}
        )
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
