package org.matrix.android.sdk.sample.compoment

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class ExpandableCardViewModel : ViewModel() {
    val name = mutableStateOf("")
    val weightText = mutableStateOf("")
    val waterml = mutableStateOf("")
    val workfood = mutableStateOf("")
    val sleepTime = mutableStateOf("")
    val weightfat = mutableStateOf("")
    val weightday = mutableStateOf("")
    val fooda = mutableStateOf("")
    val watera = mutableStateOf("")
    val sleepa = mutableStateOf("")


}