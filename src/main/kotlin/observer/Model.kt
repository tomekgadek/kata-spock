package io.github.tomekgadek.observer

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

class Model {

    private val propertyChange = PropertyChangeSupport(this)

    var oldValue = ""
    var newValue = ""

    fun calculate(mathOperation: String) {
        newValue = mathOperation
        onChange(newValue)
    }

    private fun onChange(newValue: String) {
        propertyChange.firePropertyChange(PropertyName.CALCULATED_VALUE.name, oldValue, newValue)
        this.oldValue = newValue
    }

    fun onChangeListener(listener: PropertyChangeListener?) {
        propertyChange.addPropertyChangeListener(listener)
    }
}