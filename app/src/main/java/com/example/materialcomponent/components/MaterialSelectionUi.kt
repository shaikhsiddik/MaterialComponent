package com.example.materialcomponent.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialcomponent.ui.theme.MaterialComponentTheme

@Composable
fun MaterialSelectionUi(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
    ) {

        Checkboxes()

    }

}


data class ToggleableInfo(
    val isChecked: Boolean,
    val text: String
)

@Composable
private fun Checkboxes(){

    val checkBoxes = remember {

        mutableStateListOf(

            ToggleableInfo(
                isChecked = false,
                text = "Photos"
            ),
            ToggleableInfo(
                isChecked = false,
                text = "Videos"
            ),
            ToggleableInfo(
                isChecked = false,
                text = "Audio"
            )
        )

    }
    
    var triState by remember {
        
        mutableStateOf(ToggleableState.Indeterminate)
        
    }
    
    val toggleTriState = {
        
        triState = when(triState) {
            
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            else -> ToggleableState.On
        }
        
        checkBoxes.indices.forEach { index -> 
        
            checkBoxes[index] = checkBoxes[index].copy(
                isChecked = triState == ToggleableState.On
            )
            
        }
        
    }
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {

            toggleTriState()

        }
    ) {
        TriStateCheckbox(state = triState, onClick = toggleTriState)
        Text(text = "File Types")
    }

    checkBoxes.forEachIndexed { index, toggleableInfo ->

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {

                checkBoxes[index] = toggleableInfo.copy(

                    isChecked = !toggleableInfo.isChecked
                )

            }.padding(end = 16.dp)
        ){

            Checkbox(checked = toggleableInfo.isChecked, onCheckedChange = { isChecked ->
                checkBoxes[index] = toggleableInfo.copy(
                    isChecked = isChecked
                ) }
            )
            Text(text = toggleableInfo.text)
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun CheckboxesPreview(){

    MaterialComponentTheme {

        Checkboxes()

    }

}

