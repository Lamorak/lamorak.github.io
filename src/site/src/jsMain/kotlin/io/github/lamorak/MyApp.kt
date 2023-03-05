package io.github.lamorak

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.style.KobwebComposeStyleSheet
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.KobwebApp
import com.varabyte.kobweb.silk.SilkStyleSheet
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.init.*
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.vh

@InitSilk
fun updateTheme(ctx: InitSilkContext) {
    ctx.stylesheet.apply {
        registerBaseStyle("*") {
            Modifier.fontFamily("Poppins", "sans-serif")
        }
        registerBaseStyle("h1") {
            Modifier.fontWeight(300)
        }
    }
    ctx.config.initialColorMode = ColorMode.DARK
}

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    remember {
        // Use (abuse?) remember to run logic only first time SilkApp is called
        initSilk { ctx -> initSilkHook(ctx) }
    }

    KobwebApp {
        Style(KobwebComposeStyleSheet)
        Style(SilkStyleSheet)
        Style(object: StyleSheet() {
            init {
                "@font-face" {
                    property("font-family", "Poppins")
                    property("src", "url(font/Poppins-Light.ttf)")
                }
            }
        })
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            content()
        }
    }
}
