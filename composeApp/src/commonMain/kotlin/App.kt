



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.example.project.ui.AppColors
import org.jetbrains.compose.resources.ExperimentalResourceApi


@OptIn(ExperimentalResourceApi::class)
private val DarkTheme = Color(color = 0xff040B18)

@Composable
expect fun getPlatformSpecificImage(resource: String): Painter



@Composable
fun App() {
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = Color(color = 0xffffffff),
    )

    MaterialTheme () {
        Box(Modifier.fillMaxSize().background(DarkTheme))
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    )
    {
        MainScreenTopBar()
        OverdueScreen()
        TodayTaskScreen()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    )
    {
        AddButton()
    }

}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreenTopBar() {
    TopAppBar(
        backgroundColor = AppColors.primaryDark, // Темный фон для BottomNavigation
        title = {
            Text(
                text = getCurrentDate(),
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

@Composable
fun OverdueScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Overdue",
             color = Color.White,
             fontSize = 20.sp,
             modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun TodayTaskScreen(){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Today's tasks",
             color = Color.White,
             fontSize = 20.sp,
             modifier = Modifier.padding(16.dp)
        )
    }
}
@Composable
fun AddButton(){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd
    )
    {
        FloatingActionButton(
            onClick = { /* обработчик нажатия */ },
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp) // Выравниваем по нижнему правому углу и добавляем отступ
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }
    }
}

@Composable
fun ToolMenu(){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    )
    {

    }
}

fun getCurrentDate(): String {
    val currentMoment = Clock.System.now()
    val dateTime = currentMoment.toLocalDateTime(TimeZone.currentSystemDefault())
    return "${dateTime.dayOfMonth}.${dateTime.monthNumber}.${dateTime.year}"
}