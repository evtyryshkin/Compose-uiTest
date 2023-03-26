package ru.etyryshkin.composeuitest

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ClickerUiTest {

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun clickIncrease_counterIncreased(): Unit = with(rule) {
        rule.setContent { Content() }

        onNodeWithTag("Increase")
            .performClick()

        onNodeWithText("Current value: ", substring = true)
            .assertTextEquals("Current value: 1")
    }

    @Test
    fun clickDecrease_counterDecreased(): Unit = with(rule) {
        rule.setContent { Content() }

        onNodeWithTag(activity.getString(R.string.decrease_button))
            .performClick()

        onNodeWithText("Current value:", substring = true)
            .assertTextEquals("Current value: -1")
    }
}
