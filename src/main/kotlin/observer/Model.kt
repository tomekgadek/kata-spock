package io.github.tomekgadek.observer

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

class Model {

    private val propertyChange = PropertyChangeSupport(this)
    var oldValue = 0
    var newValue = 0

    fun increment() {
        newValue += 1
        onChange(newValue)
    }

    private fun onChange(newValue: Int) {
        propertyChange.firePropertyChange(PropertyName.INCREMENT.name, oldValue, newValue)
        this.oldValue = newValue
    }

    fun onChangeListener(listener: PropertyChangeListener?) {
        propertyChange.addPropertyChangeListener(listener)
    }
}