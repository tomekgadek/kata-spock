package io.github.tomekgadek.observer

import java.awt.FlowLayout
import java.awt.Font
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel

class View : JFrame() {
    private val incButton = JButton("+1")
    private val label = JLabel("0")

    init {
        setTitle("Observer v1.0")
        setDefaultCloseOperation(EXIT_ON_CLOSE)
        setSize(300, 120)

        label.setFont(Font("Arial", Font.BOLD, 20))

        add(label)
        add(incButton)

        layout = FlowLayout()
        isVisible = true
    }

    fun buttonListener(listener: ActionListener?) {
        incButton.addActionListener(listener)
    }

    fun updateLabel(text: String?) {
        label.setText(text)
    }
}