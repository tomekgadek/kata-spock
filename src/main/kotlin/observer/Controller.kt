package io.github.tomekgadek.observer

import java.util.logging.Logger

class Controller(private val model: Model, private val view: View) {

    private val log = Logger.getAnonymousLogger()

    init {

        view.setEvalListener { evt ->
            log.info("zmina modelu, obliczenia")

            model.calculate(view.getExpression())
        }

        view.setClearListener { evt ->
            log.info("zmiana modelu, czysci pole edycji")

            view.clearExpressionAndResult()
        }

        model.onChangeListener { evt ->
            log.info("model zmieniony, wiec aktualizuje widok")

            if (PropertyName.CALCULATED_VALUE.name == evt.propertyName) {
                view.setResult(evt.newValue.toString())
            }
        }
    }
}