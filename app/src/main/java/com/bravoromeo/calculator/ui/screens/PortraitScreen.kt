package com.bravoromeo.calculator.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bravoromeo.calculator.R
import com.bravoromeo.calculator.ui.screens.elements.ACButton
import com.bravoromeo.calculator.ui.screens.elements.DeleteButton
import com.bravoromeo.calculator.ui.screens.elements.Display
import com.bravoromeo.calculator.ui.screens.elements.EqualToButton
import com.bravoromeo.calculator.ui.screens.elements.NumberButton
import com.bravoromeo.calculator.ui.screens.elements.OperationButton
import com.bravoromeo.calculator.ui.screens.elements.OtherOperationsButton
import com.bravoromeo.calculator.ui.screens.elements.ParenthesisButton
import com.bravoromeo.calculator.ui.screens.elements.PiButton
import com.bravoromeo.calculator.ui.theme.CalculatorTheme

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPortraitScreen(){
    CalculatorTheme {
        Surface{ PortraitScreen() }
    }
}

@Composable
fun PortraitScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(1.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {
            Display{}
        }
        Row(
            modifier = modifier
                .fillMaxSize()
        ) {
            val listSpecialButtons = listOf(
                "˄",
                "√",
                "pi",
                stringResource(id = R.string.sine),
                stringResource(id = R.string.cosine),
                stringResource(id = R.string.tangent),
                stringResource(id = R.string.secant),
                stringResource(id = R.string.cosecant),
            )
            Column(
                modifier = modifier
                    .fillMaxSize()
            ) {
                LazyRow(
                    modifier = modifier
                        .fillMaxHeight(0.15f),
                    contentPadding = PaddingValues(6.dp)
                ){
                    items(listSpecialButtons){ element ->
                        if (element == "pi") PiButton(width = 80){ pi -> }
                        else OtherOperationsButton(symbol = element, width = 80){symbol -> }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    Column(//AC
                        modifier = modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        ACButton(modifier = modifier.weight(1f)) {}
                        NumberButton(number = '7', modifier = modifier.weight(1f)){ number -> }
                        NumberButton(number = '4', modifier = modifier.weight(1f) ){ number -> }
                        NumberButton(number = '1', modifier = modifier.weight(1f)){ number -> }
                        NumberButton(number = '0', modifier = modifier.weight(1f)){ number -> }
                    }
                    Column(//()
                        modifier = modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        ParenthesisButton(modifier = modifier.weight(1f)){/*TODO*/}
                        NumberButton(number = '8', modifier = modifier.weight(1f)){ number -> }
                        NumberButton(number = '5', modifier = modifier.weight(1f) ){ number -> }
                        NumberButton(number = '2', modifier = modifier.weight(1f)){ number -> }
                        NumberButton(number = '.', modifier = modifier.weight(1f)){ number -> }
                    }
                    Column(//%
                        modifier = modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        OperationButton(symbol = '%', modifier = modifier.weight(1f)){}
                        NumberButton(number = '9', modifier = modifier.weight(1f)){ number -> }
                        NumberButton(number = '6', modifier = modifier.weight(1f) ){ number -> }
                        NumberButton(number = '3', modifier = modifier.weight(1f)){ number -> }
                        DeleteButton(modifier = modifier.weight(1f)){ /*TODO*/ }
                    }
                    Column(///
                        modifier = modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        OperationButton(symbol = '÷', modifier = modifier.weight(1f)){}
                        OperationButton(symbol = '*', modifier = modifier.weight(1f)){}
                        OperationButton(symbol = '-', modifier = modifier.weight(1f)){}
                        OperationButton(symbol = '+', modifier = modifier.weight(1f)){}
                        EqualToButton(modifier = modifier.weight(1f)) {}
                    }
                }
            }
        }
    }
}