package com.example.android_container_transform.containerTranform

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_container_transform.R

data class ItemData(
    val imageResId: Int,
    val title: String,
    val description: String
)

val itemList = listOf(
    ItemData(
        imageResId = R.drawable.kpc, // Use actual image resource
        title = "ខេត្តកំពង់ឆ្នាំង",
        description = "ខេត្តកំពង់ឆ្នាំងស្ថិតនៅភាគកណ្ដាលប្រទេសកម្ពុជា។ ខេត្តកំពង់ឆ្នាំងមានព្រំប្រទល់ខាងជើងជាប់ខេត្តកំពង់ធំ ខាងកើតជាប់ខេត្តកំពង់ចាម ខាងត្បូងជាប់ខេត្តកំពង់ស្ពឺ និងខាងលិចជាប់ខេត្តពោធិ៍សាត់។ ខេត្តនេះស្ថិតនៅចម្ងាយប្រមាណ ៩១ គ.ម. ពីរាជធានីភ្នំពេញ។\n" +
                "\n" +
                "ខេត្តកំពង់ឆ្នាំងមានអាកាសធាតុក្ដៅហើយសើមដូចបណ្ដាខេត្តទូទាំងប្រទេសកម្ពុជាដទៃទៀតដែរ។ រដូវវស្សាចាប់ពីខែ ឧសភា ដល់ខែ តុលា (សីតុណ្ហភាពពី ២៧ ទៅ ៣៥អង្សា សំណើម ៩០ % ) រដូវរងារពីខែ វិច្ឆិកាដល់ខែ មីនា (សីតុណ្ហភាពពី ១៨ ទៅ ២៨ អង្សា) និងរដូវក្ដៅពីខែ មីនា ដល់ ខែ ឧសភា (សីតុណ្ហភាពពី ២៨ ទៅ ៣៦ អង្សា)។"
    ),
    ItemData(
        imageResId = R.drawable.btb,
        title = "ខេត្តបាត់ដំបង",
        description = "ខេត្តបាត់ដំបង គឺជាខេត្តមួយនៅភាគពាយ័ព្យនៃព្រះរាជាណាចក្រកម្ពុជា។ ខេត្តបាត់ដំបង មានទីប្រជុំជនធំនៅក្រុងបាត់ដំបង។ ខេត្តបាត់ដំបងមានព្រំប្រទល់ ខាងជើងជាប់ខេត្តបន្ទាយមានជ័យ ខាងកើតជាប់ខេត្តសៀមរាបនិងបឹងទន្លេសាប ខាងត្បូងជាប់ខេត្តពោធិ៍សាត់"
    ),
    ItemData(
        imageResId = R.drawable.sr,
        title = "ខេត្តសៀមរាប",
        description = "ខេត្តសៀមរាប គឺជាខេត្តមួយដែលមានទីតាំងនៅភាគខាងពាយ័ព្យនៃប្រទេសកម្ពុជា ដែលមានទីតាំងស្ថិតនៅក្បែរបឹងទន្លេសាប។ ទីរួមខេត្តរបស់ខេត្តសៀមរាបនេះគឺ ក្រុងសៀមរាប។ ខេត្តសៀមរាបត្រូវបានដាក់ឈ្មោះបែបនេះដើម្បី រំលឹកដល់ជ័យជំនះនៅកងទ័ពខ្មែរលើកងទ័ពសៀមនៅសម័យលង្វែកសតវត្ស១៦។"
    )
)

@Composable
fun ItemCard(item: ItemData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = item.title,
            modifier = Modifier.size(width = 800.dp, height = 300.dp)
        )
        Text(text = item.title, style = MaterialTheme.typography.displayLarge)
        Text(text = item.description, style = MaterialTheme.typography.displaySmall)
    }
}

@Composable
fun ExpandableItemCard(item: ItemData, onClick: () -> Unit) {
    // Load image using painterResource
    val imagePainter: Painter = painterResource(item.imageResId)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }, // Expand to full screen on click
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Image
            Image(
                painter = imagePainter,
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Title
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Shortened description
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                maxLines = 3
            )
        }
    }
}

@Composable
fun FullScreenItem(item: ItemData, onClose: () -> Unit) {
    val imagePainter: Painter = painterResource(item.imageResId)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .clickable { onClose() }, // Exit full screen on click
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Take up as much height as possible
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Display title and description on full screen
            Text(
                text = item.title,
                color = Color.White,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.description,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun DisplayItems(items: List<ItemData>) {
    var selectedItem by remember { mutableStateOf<ItemData?>(null) } // Track selected item for full screen

    // If an item is selected, show it in full screen
    if (selectedItem != null) {
        FullScreenItem(selectedItem!!) { selectedItem = null } // Show full screen for the selected item
    } else {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(items) { item ->
                ExpandableItemCard(item) { selectedItem = item } // Show normal card
            }
        }
    }
}