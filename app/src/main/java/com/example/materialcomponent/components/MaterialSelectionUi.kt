package com.example.materialcomponent.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.graphics.Color
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

        Spacer(modifier = Modifier.height(8.dp))

        Material3Switch()

        Spacer(modifier = Modifier.height(8.dp))

        LabeledMaterial3Switch()

        Spacer(modifier = Modifier.height(8.dp))

        CustomSwitch()

        Spacer(modifier = Modifier.height(8.dp))

        Material3RadioButton()

        Spacer(modifier = Modifier.height(8.dp))

        Material3RadioButtonGroup()

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

                }
                .padding(end = 16.dp)
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

@Composable
fun Material3Switch() {
    var isChecked by remember { mutableStateOf(false) }

    Switch(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun LabeledMaterial3Switch() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = if (isChecked) "Switch is ON" else "Switch is OFF")
        Spacer(modifier = Modifier.width(8.dp))
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
    }
}

@Composable
fun CustomSwitch(){

    var isChecked by remember { mutableStateOf(false) }

    Switch(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            uncheckedThumbColor = Color.Red,
            checkedTrackColor = Color.LightGray,
            uncheckedTrackColor = Color.DarkGray
        )
    )

}

@Composable
fun Material3RadioButton() {
    var selected by remember { mutableStateOf("Option 1") }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            RadioButton(
                selected = selected == "Option 1",
                onClick = { selected = "Option 1" }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Option 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            RadioButton(
                selected = selected == "Option 2",
                onClick = { selected = "Option 2" }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Option 2")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            RadioButton(
                selected = selected == "Option 3",
                onClick = { selected = "Option 3" }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Option 3")
        }
    }
}

@Composable
fun Material3RadioButtonGroup() {
    var selectedOption by remember { mutableStateOf("Option A") }

    Column(modifier = Modifier.padding(16.dp)) {
        listOf("Option A", "Option B", "Option C").forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green,
                        unselectedColor = Color.Red
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
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

