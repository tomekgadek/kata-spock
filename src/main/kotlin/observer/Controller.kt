package io.github.tomekgadek.observer

import java.util.logging.Logger

class Controller(private val model: Model, private val view: View) {

    private val log = Logger.getAnonymousLogger()

    init {

        view.buttonListener { evt ->
            log.info("zmina modelu")

            model.increment()
        }

        model.onChangeListener { evt ->
            log.info("model zmieniony, wiec aktualizuje widok")

            if (PropertyName.INCREMENT.name == evt.propertyName) {
                view.updateLabel(evt.newValue.toString())
            }
        }
    }
}