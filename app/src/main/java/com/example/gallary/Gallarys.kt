package com.example.gallary

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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Gallarys() {
    var selectedIndexImage by remember { mutableStateOf<Int?>(null) }
    val gallery = remember { mutableListOf(
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
    ) }
    val openDialog = remember { mutableStateOf(false)}
    if(selectedIndexImage == null) {

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
                    selectedIndexImage = index
                }
            }
        }
    } else {
        Box(

        ) {
            Image(
                painter = painterResource(id = gallery[selectedIndexImage!!]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(alignment = Alignment.Center)
            )
            Text(
                text = " ${selectedIndexImage!! + 1} из ${gallery.size}",
                modifier = Modifier
                    .align(alignment = Alignment.TopEnd)
                    .padding(10.dp),
                color = Color.Cyan,
                fontSize = 24.sp
            )
            IconButton(
                onClick = { openDialog.value = true },
                modifier = Modifier.align(Alignment.BottomCenter),
            ){
                Icon(
                    painter = painterResource(R.drawable.trashcan_delete_remove_trash_icon_178327),
                    contentDescription = null,
                    tint = Color.Magenta
                )
            }
            if (selectedIndexImage!! > 0) {
                IconButton(
                    onClick = { selectedIndexImage = selectedIndexImage!! - 1 },
                    modifier = Modifier.align(alignment = Alignment.CenterStart)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.left),
                        contentDescription = null,
                        tint = Color.Cyan
                    )
                }
            }
            if (selectedIndexImage!! < gallery.size - 1) {
                IconButton(
                    { selectedIndexImage = selectedIndexImage!! + 1 },
                    modifier = Modifier.align(alignment = Alignment.CenterEnd)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.right),
                        contentDescription = null,
                        tint = Color.Cyan
                    )
                }
            }
            IconButton(
                { selectedIndexImage = null },
                modifier = Modifier.align(alignment = Alignment.TopStart)
            ) {
                Icon(
                    painter = painterResource(R.drawable.down),
                    contentDescription = null,
                    tint = Color.Cyan
                )
            }
        }
        if (openDialog.value){
            AlertDialog(
                onDismissRequest = {openDialog.value = false},
                modifier = Modifier.padding(30.dp),
                text = {
                    Text(
                        text = "вы действительно хотите удалить фотографию?",
                        fontSize = 18.sp,)
                },
                confirmButton = {
                    Button(
                        onClick = {
                            gallery.removeAt(selectedIndexImage!!)
                            openDialog.value = false
                        },
                    ){
                        Text("удалить")
                    }
                },
                dismissButton = {

                    Button(
                        {openDialog.value = false}
                    ){
                        Text("отмена")
                    }
                }
            )
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
