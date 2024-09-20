package com.example.android_container_transform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.android_container_transform.containerTranform.DisplayItems
import com.example.android_container_transform.containerTranform.itemList
import com.example.android_container_transform.ui.theme.AndroidcontainertransformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DisplayItems(items = itemList)
//            MainScreen()

        }
    }
}

