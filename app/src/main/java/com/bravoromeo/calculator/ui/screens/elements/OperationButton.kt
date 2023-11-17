package com.bravoromeo.calculator.ui.screens.elements

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bravoromeo.calculator.ui.theme.CalculatorTheme

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewOperationButton(){
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
fun OperationButton(
    modifier: Modifier = Modifier,
    symbol: Char? = null,
    height: Int? = null,
    width: Int? = null,
    onClick: (Char) -> Unit
){
    Card(
        modifier = modifier
            .padding(2.dp)
            .height(height?.dp ?: 30.dp)
            .width(width?.dp ?: 30.dp)
            .clickable { onClick.invoke(symbol ?: '+') },
        elevation = CardDefaults.cardElevation(
            focusedElevation = 1.dp,
            pressedElevation = 0.dp,
            defaultElevation = 2.dp,
            hoveredElevation = 1.dp
        ),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = symbol?.toString() ?: "+",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}
@Composable
fun EqualToButton(
    modifier: Modifier = Modifier,
    height: Int? = null,
    width: Int? = null,
    onClick: () -> Unit
){
    Card(
        modifier = modifier
            .padding(2.dp)
            .height(height?.dp ?: 30.dp)
            .width(width?.dp ?: 30.dp)
            .clickable { onClick.invoke() },
        elevation = CardDefaults.cardElevation(
            focusedElevation = 1.dp,
            pressedElevation = 0.dp,
            defaultElevation = 2.dp,
            hoveredElevation = 1.dp
        ),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "=",
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}