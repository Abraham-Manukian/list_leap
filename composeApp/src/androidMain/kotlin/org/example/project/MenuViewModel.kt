package org.example.project

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MenuViewModel: ViewModel() {
    //Индекс текущей вкладки
    val selectedTabIndex = mutableStateOf(2)

    //Функция для изменения выбранной вкладки
    fun onTabSelected(index: Int) {
        selectedTabIndex.value = index
    }
}