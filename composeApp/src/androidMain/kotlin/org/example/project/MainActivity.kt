package org.example.project

import App
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
            val viewModel: MenuViewModel by viewModels()
            MainScreen(viewModel)
        }
    }
}

@Composable
fun MainScreen(viewModel: MenuViewModel) {
    Scaffold(
        bottomBar = { BottomNavigationBar(viewModel) }
    ) { innerPadding ->
        // Тело вашего основного экрана, который будет меняться в зависимости от выбранного пункта меню
        // Используем innerPadding, чтобы добавить отступы
        MainContent(viewModel, innerPadding);
    }
}



@Composable
fun MainContent(viewModel: MenuViewModel, paddingValues: PaddingValues) {
    Box(modifier = Modifier.padding(paddingValues)) {
        // Область для содержимого, выбранного в нижнем меню
        // Используйте viewModel.selectedTabIndex, чтобы определить, какой экран показать
        when (viewModel.selectedTabIndex.value) {
            0 -> print("Настройки")
            1 -> print("Календарь")
            2 -> App()
            3 -> print("Документы")
            // и так далее для каждого пункта меню
        }
    }
}




@Preview
@Composable
fun AppAndroidPreview() {
    App()
}