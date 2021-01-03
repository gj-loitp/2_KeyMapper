package io.github.sds100.keymapper.data.model

import android.content.Intent
import io.github.sds100.keymapper.R

/**
 * Created by sds100 on 01/01/21.
 */

sealed class IntentExtraType {
    abstract val labelStringRes: Int
    abstract val exampleStringRes: Int

    abstract fun putInIntent(intent: Intent, name: String, value: String)

    /**
     * Return null if it is invalid
     */
    abstract fun parse(value: String): Any?

    fun isValid(value: String) = parse(value) != null
}

class BoolExtraType : IntentExtraType() {
    override val labelStringRes = R.string.intent_type_bool_header
    override val exampleStringRes = R.string.intent_type_bool_example

    override fun putInIntent(intent: Intent, name: String, value: String) {
        intent.putExtra(name, parse(value))
    }

    override fun parse(value: String): Boolean? = when (value.trim()) {
        "true" -> true
        "false" -> false
        else -> null
    }
}

class IntArrayExtraType : IntentExtraType() {
    override val labelStringRes = R.string.intent_type_int_header
    override val exampleStringRes = R.string.intent_type_int_example

    override fun putInIntent(intent: Intent, name: String, value: String) {
        intent.putExtra(name, parse(value))
    }

    override fun parse(value: String): IntArray? {
        return value
            .trim()
            .split(',')
            .map {
                try {
                    it.toInt()
                } catch (e: NumberFormatException) {
                    return null
                }
            }
            .toIntArray()
    }
}
