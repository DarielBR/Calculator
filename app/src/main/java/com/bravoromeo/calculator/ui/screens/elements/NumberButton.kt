package com.bravoromeo.calculator.ui.screens.elements

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bravoromeo.calculator.ui.theme.CalculatorTheme

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNumberButton(){
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
fun NumberButton(
    modifier: Modifier = Modifier,
    number: Char? = null,
    onClick: (Char) -> Unit
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxSize()
            .clickable { onClick.invoke(number ?: '1') },
        elevation = CardDefaults.cardElevation(
            focusedElevation = 1.dp,
            pressedElevation = 0.dp,
            defaultElevation = 2.dp,
            hoveredElevation = 1.dp
        ),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = number?.toString() ?: "1",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 32.sp
            )
        }
    }
}