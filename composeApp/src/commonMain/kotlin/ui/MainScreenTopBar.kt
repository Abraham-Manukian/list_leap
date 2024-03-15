package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import getPlatformSpecificImage
import org.example.project.ui.AppColors

@Composable
fun MainScreenTopBar() {
    TopAppBar(
        backgroundColor = AppColors.primaryDark, // Темный фон для BottomNavigation
        title = {
            Text(
                text = date.getCurrentDate(),
                color = AppColors.textLight,
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
        },
        navigationIcon = {
            IconButton(modifier = Modifier.clickable(onClick = { /*TODO*/ }), onClick = { /*TODO*/}) {

                Icon(painter = getPlatformSpecificImage("my_icon_back"), contentDescription = "Previous Day", tint = AppColors.textLight)
            }
        },
        actions = {
            IconButton(modifier = Modifier.clickable(onClick = { /*TODO*/ }), onClick = { /*TODO*/}) {
                Icon(painter = getPlatformSpecificImage("my_icon_next"), contentDescription = "Next Day", tint = AppColors.textLight)
            }
        }
    )
}