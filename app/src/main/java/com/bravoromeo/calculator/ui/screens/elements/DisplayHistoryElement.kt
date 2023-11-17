package com.bravoromeo.calculator.ui.screens.elements

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bravoromeo.calculator.ui.theme.CalculatorTheme

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDisplayElements(){
    CalculatorTheme {
        Surface{
            Column {
                DisplayHistoryElement {}
                DisplayHistoryElement(text = "150") {}
                DisplayResultsElement(text = "20+10")
            }
        }
    }
}

@Composable
fun DisplayHistoryElement(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClick: (String) -> Unit
){
    Text(
        modifier = modifier
            .clickable { onClick.invoke(text ?: "") }
            .padding(4.dp)
            .fillMaxWidth(),
        text = text ?: "25",
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = TextAlign.Right,
        fontWeight = FontWeight.Light
    )
}