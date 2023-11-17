package com.bravoromeo.calculator.ui.screens.elements

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bravoromeo.calculator.ui.theme.CalculatorTheme

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDisplayElement(){
    CalculatorTheme {
        Surface{
            Column {
                Display(
                    items = listOf("15", "30", "24")
                ){}
            }
        }
    }
}

@Composable
fun Display(
    modifier: Modifier = Modifier,
    items: List<String>? = null,
    onHistoryElementClicked: (String) -> Unit
){
    Card(
        modifier = modifier
            .padding(2.dp)
            .fillMaxSize(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(
            modifier = modifier
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row {
                LazyColumn{
                    items(items ?: emptyList()){ item->
                        DisplayHistoryElement(text = item) {historyElement ->
                            onHistoryElementClicked.invoke(historyElement)
                        }
                    }
                }
            }
            Row {
                DisplayResultsElement()
            }
        }
    }
}