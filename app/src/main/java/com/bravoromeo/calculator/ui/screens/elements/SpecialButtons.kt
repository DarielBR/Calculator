package com.bravoromeo.calculator.ui.screens.elements

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bravoromeo.calculator.R
import com.bravoromeo.calculator.ui.theme.CalculatorTheme

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSpecialButtons(){
    CalculatorTheme {
        Column{
            Row {
                NumberButton {}
                OperationButton {}
                EqualToButton {}
            }
            Row {
                ACButton {}
                DeleteButton {}
                OtherOperationsButton {}
            }
        }
    }
}

@Composable
fun ACButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxSize()
            .clickable { onClick.invoke() },
        elevation = CardDefaults.cardElevation(
            focusedElevation = 1.dp,
            pressedElevation = 0.dp,
            defaultElevation = 2.dp,
            hoveredElevation = 1.dp
        ),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "AC",
                color = MaterialTheme.colorScheme.onErrorContainer,
                fontSize = 32.sp
            )
        }
    }
}
@Composable
fun DeleteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxSize()
            .clickable { onClick.invoke() },
        elevation = CardDefaults.cardElevation(
            focusedElevation = 1.dp,
            pressedElevation = 0.dp,
            defaultElevation = 2.dp,
            hoveredElevation = 1.dp
        ),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "◄",
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = 32.sp
            )
        }
    }
}
@Composable
fun OtherOperationsButton(
    modifier: Modifier = Modifier,
    symbol: String? = null,
    width: Int? = null,
    onClick: (String) -> Unit
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxHeight()
            .width(width?.dp ?: 30.dp)
            .clickable { onClick.invoke( (symbol ?: "SIN")  + "(") },
        elevation = CardDefaults.cardElevation(
            focusedElevation = 1.dp,
            pressedElevation = 0.dp,
            defaultElevation = 2.dp,
            hoveredElevation = 1.dp
        ),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = symbol ?: stringResource(id = R.string.sine),
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 32.sp
            )
        }
    }
}
@Composable
fun PiButton(
    modifier: Modifier = Modifier,
    width: Int? = null,
    onClick: (String) -> Unit
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxHeight()
            .width(width?.dp ?: 30.dp)
            .clickable { onClick.invoke("pi") },
        elevation = CardDefaults.cardElevation(
            focusedElevation = 1.dp,
            pressedElevation = 0.dp,
            defaultElevation = 2.dp,
            hoveredElevation = 1.dp
        ),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "π",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 32.sp
            )
        }
    }
}