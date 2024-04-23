package org.matrix.android.sdk.sample.compoment

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class ExpandableCardViewModel : ViewModel() {
    val name = mutableStateOf("")
}