package com.example.android_container_transform.containerTranform

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_container_transform.R
import kotlinx.coroutines.delay

// create data class for storing data
data class ItemData(
    val imageResId: Int,
    val title: String,
    val description: String
)

// Define a list of ItemData
val itemList = listOf(
    ItemData(
        imageResId = R.drawable.kpc, // Use actual image resource
        title = "ខេត្តកំពង់ឆ្នាំង",
        description = "ខេត្តកំពង់ឆ្នាំងស្ថិតនៅភាគកណ្ដាលប្រទេសកម្ពុជា។ ខេត្តកំពង់ឆ្នាំងមានព្រំប្រទល់ខាងជើងជាប់ខេត្តកំពង់ធំ ខាងកើតជាប់ខេត្តកំពង់ចាម ខាងត្បូងជាប់ខេត្តកំពង់ស្ពឺ និងខាងលិចជាប់ខេត្តពោធិ៍សាត់។ ខេត្តនេះស្ថិតនៅចម្ងាយប្រមាណ ៩១ គ.ម. ពីរាជធានីភ្នំពេញ។ ខេត្តកំពង់ឆ្នាំងមានអាកាសធាតុក្ដៅហើយសើមដូចបណ្ដាខេត្តទូទាំងប្រទេសកម្ពុជាដទៃទៀតដែរ។ រដូវវស្សាចាប់ពីខែ ឧសភា ដល់ខែ តុលា (សីតុណ្ហភាពពី ២៧ ទៅ ៣៥អង្សា សំណើម ៩០ % ) រដូវរងារពីខែ វិច្ឆិកាដល់ខែ មីនា (សីតុណ្ហភាពពី ១៨ ទៅ ២៨ អង្សា) និងរដូវក្ដៅពីខែ មីនា ដល់ ខែ ឧសភា (សីតុណ្ហភាពពី ២៨ ទៅ ៣៦ អង្សា)។"
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
    ),
    ItemData(
        imageResId = R.drawable.kpt,
        title = "ខេត្តកំពង់ធំ",
        description = "គឺជាខេត្តមួយក្នុងប្រទេសកម្ពុជា ។ វាមានព្រំប្រទល់ជាប់ខេត្តសៀមរាប នៅភាគពាយព្យ ព្រះវិហារ នៅភាគខាងជើង ស្ទឹងត្រែងនៅភាគឦសាន ក្រចេះនៅខាងកើត កំពង់ចាម កំពង់ឆ្នាំង នៅខាងត្បូង និង បឹងទន្លេសាបនៅភាគខាងលិច។"
    ),
    ItemData(
        imageResId = R.drawable.ps,
        title = "ខេត្តពោតិ៍សាត់",
        description = "ខេត្តពោធិ៍សាត់. ខេត្តនៃព្រះរាជាណាចក្រកម្ពុជា. ភាសា តាមដាន · កែប្រែ. ខេត្តពោធិ៍សាត់ជាខេត្តមួយនៅភាគខាងលិចនៃប្រទេសកម្ពុជា។ ខេត្តពោធិ៍សាត់មានទីរួមខេត្តនៅ ក្រុងពោធិ៍សាត់។ ខេត្តពោធិ៍សាត់គឺជាខេត្តមួយដែលសិ្ថតនៅក្នុងតំបន់បឹងទនេ្លសាប មានទីតាំងនៅទិសបចិ្ចមនៃប្រទេស។"
    )
)

// this Composable for Design Card to Show Data
// General we are use Expandable Composable for clicked
@Composable
fun ExpandableItemCard(item: ItemData, onClick: () -> Unit) {
    //item: ItemData it for get data when ItemData provided
    // define card to catch and show  other information
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }, // When click on card parameter use with Expandable Composable
        shape = RoundedCornerShape(8.dp) // Card Rounded

    ) {
        // This Column define for imageResId , title , and Description
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = item.imageResId), // get image by id
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp)) // set Spacer 8.dp between image and title
            Text(text = item.title, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium, // font size use MaterialThem
                maxLines = 2,// it show only 2 line
                overflow = TextOverflow.Ellipsis //if has description 2 line it show (...)
            )
        }
    }
}

/**
 * This composable that to show full screen when use client
 * and show ItemData by Id when clicked
 **/
@Composable
fun FullScreenItem(item: ItemData, onClose: @Composable () -> Unit) {
    //onClose:  @Composable () -> Unit it working when Reset or back
    var isDescriptionVisible by remember { mutableStateOf(true) } // Define state for text view hide and show when click on Image

    // Box is used to layout elements on top of each other
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black), // show background black

        contentAlignment = Alignment.Center // align content center (like image)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth() // full screen of vertically
                    .weight(1f) // show 1 item for 50% of screen
                    .clickable {
                        isDescriptionVisible = !isDescriptionVisible
                    } // when clicked 1time false and true
            )
            if (isDescriptionVisible) { // it check if true it show text, Spacer , and Text
                Text(text = item.title, color = Color.White, fontSize = 24.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.description, color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

/**
 * create DisplayItem composable for user interact other
 * and display each animation of Container Transform
 * note only it handling when clicked back button
 */
@Composable
fun DisplayItems(items: List<ItemData>) { // items: List<ItemData> it get ItemData as List
// state select item for display full screen view
    var selectedItem by remember { mutableStateOf<ItemData?>(null) }
    //sate for exit process
    var isExiting by remember { mutableStateOf(false) }

    // Back button handling
    BackHandler(enabled = selectedItem != null) {
        // Start exit animation
        isExiting = true
    }

    // Use a Box to layer content
    Box(modifier = Modifier.fillMaxSize()) {
        // Normal view showing the list of items that can scrolling
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(items) { item ->
                ExpandableItemCard(item) {
                    selectedItem = item // Set the clicked item to full-screen
                    isExiting = false // Ensure we're not exiting when selecting an item
                }
            }
        }

        // Full-screen view for the selected item with proper animation handling
        AnimatedVisibility(
            // Show when an item is selected and we are not exiting.
            visible = selectedItem != null && !isExiting,

            // Enter animation: Slide in from the bottom and fade in simultaneously.
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight }, // Slide in from below
                animationSpec = tween(durationMillis = 700) // Enter animation duration
            ) + fadeIn(animationSpec = tween(durationMillis = 700)),

            // Exit animation: Slide out to the top and fade out simultaneously.
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> fullHeight }, // Slide out to above
                animationSpec = tween(durationMillis = 300) // Exit animation duration
            ) + fadeOut(animationSpec = tween(durationMillis = 300)),
            modifier = Modifier.fillMaxSize() // Ensure full screen
        ) {
            selectedItem?.let { item ->
                FullScreenItem(item) {
                    // Close the full-screen view by triggering the exit animation
                    isExiting = true
                    // Reset selectedItem after animation delay
                    LaunchedEffect(isExiting) {
                        if (isExiting) {
                            delay(300) // Match this with the exit animation duration
                            selectedItem =
                                null // Reset `selectedItem` to null, closing the full-screen view.
                            isExiting = false // Reset the exit state
                        }
                    }
                }
            }
        }
    }
}


/**
 * animation left to right
 * AnimatedVisibility(
 *             // Show when an item is selected and we are not exiting.
 *             visible = selectedItem != null && !isExiting,
 *
 *             // Enter animation: Slide in from the left and fade in simultaneously.
 *             enter = slideInHorizontally(
 *                 initialOffsetX = { fullWidth -> -fullWidth }, // Slide in from the left
 *                 animationSpec = tween(durationMillis = 700) // Enter animation duration
 *             ) + fadeIn(animationSpec = tween(durationMillis = 700)),
 *
 *             // Exit animation: Slide out to the right and fade out simultaneously.
 *             exit = slideOutHorizontally(
 *                 targetOffsetX = { fullWidth -> fullWidth }, // Slide out to the right
 *                 animationSpec = tween(durationMillis = 300) // Exit animation duration
 *             ) + fadeOut(animationSpec = tween(durationMillis = 300)),
 *             modifier = Modifier.fillMaxSize() // Ensure full screen
 *         )
 */
