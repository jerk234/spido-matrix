package com.example.spido_matrix2.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar


interface ToolbarConfigurable {

    fun AppCompatActivity.configureToolbar(toolbar: Toolbar, displayBack: Boolean = true) {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(displayBack)
            it.setDisplayHomeAsUpEnabled(displayBack)
            it.title = null
        }
    }

    fun Fragment.configureToolbar(toolbar: Toolbar, displayBack: Boolean = true) {
        (activity as? AppCompatActivity)?.configureToolbar(toolbar, displayBack)
    }
}
