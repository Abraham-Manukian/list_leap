package org.example.project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.example.project.ui.AppColors


val bottomMenuItems = listOf(
    BottomMenuItem("", R.drawable.ic_settings),
    BottomMenuItem("",R.drawable.ic_calendar),
    BottomMenuItem("Дом", R.drawable.ic_home),
    BottomMenuItem("Документы", R.drawable.ic_documents),
    BottomMenuItem("Профиль", R.drawable.ic_person),
)

data class BottomMenuItem(val title: String, val iconId: Int)

@Composable
fun BottomNavigationBar(viewModel: MenuViewModel) {
    // Обертка для BottomNavigation и Divider
    Box {
        // Divider в Box для верхней границы
        Divider(
            color = AppColors.strokeMenu,
            thickness = 1.dp,
            modifier = Modifier
                .align(Alignment.TopStart) // Выравнивание сверху
                .fillMaxWidth() // Заполнение максимальной ширины
        )

        // BottomNavigation ниже Divider
        BottomNavigation(
            backgroundColor = AppColors.primaryDark, // Темный фон для BottomNavigation
            contentColor = AppColors.primaryLight, // Цвет контента (иконок и текста)
            modifier = Modifier.padding(top = 1.dp) // Отступ сверху, чтобы Divider был виден
        ) {
            bottomMenuItems.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.iconId),
                            contentDescription = item.title
                        )
                    },
                    selected = viewModel.selectedTabIndex.value == index,
                    onClick = { viewModel.onTabSelected(index) },
                    selectedContentColor = AppColors.secondary, // Цвет выбранной иконки
                    unselectedContentColor = AppColors.menuButton, // Цвет не выбранных иконок
                    alwaysShowLabel = false // Скрыть текст метки
                )
            }
        }
    }
}

