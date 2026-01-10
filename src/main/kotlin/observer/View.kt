package io.github.tomekgadek.observer

import java.awt.FlowLayout
import java.awt.Font
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel

import java.awt.*
import java.awt.event.ActionListener
import javax.swing.*

class View : JFrame() {

    private val expressionField = JTextField(15)
    private val resultLabel = JLabel("0")
    private val clearButton = JButton("Wyczyść")
    private val evalButton = JButton("Oblicz")

    init {
        title = "ONP Kalkulator"
        defaultCloseOperation = EXIT_ON_CLOSE
        layout = BorderLayout(12, 12)

        contentPane.background = Color(245, 245, 245)

        minimumSize = Dimension(420, 200)
        isResizable = false

        // Panel górny: "karta" z cieniem (w FlatLaf wygląda jak karta/sekcja)
        val topPanel = JPanel(GridBagLayout())
        topPanel.isOpaque = true
        topPanel.background = Color(252, 252, 252)
        topPanel.border = BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10),
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color(230, 230, 230)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            )
        )

        val gbc = GridBagConstraints().apply {
            gridy = 0
            insets = Insets(0, 6, 0, 6)
            anchor = GridBagConstraints.CENTER
        }

        expressionField.font = Font("JetBrains Mono", Font.PLAIN, 18)
        expressionField.toolTipText = "Wpisz wyrażenie w ONP, np. \"3 4 +\""

        gbc.gridx = 0
        gbc.weightx = 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL
        topPanel.add(expressionField, gbc)

        val equalsLabel = JLabel("=")
        equalsLabel.font = Font("Segoe UI", Font.BOLD, 18)

        gbc.gridx = 1
        gbc.weightx = 0.0
        gbc.fill = GridBagConstraints.NONE
        topPanel.add(equalsLabel, gbc)

        resultLabel.font = Font("Segoe UI", Font.BOLD, 20)
        resultLabel.horizontalAlignment = SwingConstants.RIGHT
        resultLabel.preferredSize = Dimension(90, 28)
        resultLabel.foreground = Color(40, 40, 40)

        gbc.gridx = 2
        topPanel.add(resultLabel, gbc)

        add(topPanel, BorderLayout.NORTH)

        val bottomPanel = JPanel(FlowLayout(FlowLayout.CENTER, 20, 5))
        bottomPanel.isOpaque = false
        bottomPanel.border = BorderFactory.createEmptyBorder(0, 10, 10, 10)

        clearButton.preferredSize = Dimension(120, 32)
        evalButton.preferredSize = Dimension(120, 32)

        rootPane.defaultButton = evalButton

        bottomPanel.add(clearButton)
        bottomPanel.add(evalButton)

        add(bottomPanel, BorderLayout.SOUTH)

        pack()
        setLocationRelativeTo(null)
        isVisible = true
    }

    fun setEvalListener(listener: ActionListener) {
        evalButton.addActionListener(listener)
        expressionField.addActionListener(listener)
    }

    fun setClearListener(listener: ActionListener) {
        clearButton.addActionListener(listener)
    }

    fun getExpression(): String = expressionField.text

    fun clearExpressionAndResult() {
        expressionField.text = ""
        resultLabel.text = "0"
    }

    fun setResult(text: String) {
        resultLabel.text = text
    }
}

