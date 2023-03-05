package io.github.lamorak.pages

import SocialButton
import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.*

@Page
@Composable
fun HomePage() {
    Column (
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column {
            H1(attrs = {
                style {
                    property("", "")
                }
            }) {
                Text("Hello, world!")
                Br()
                Text("I'm Ondrej, freelance software engineer from Berlin")
            }
        }
        Row {
            SocialButton("https://linkedin.com/in/ondrejv", "linkedin-in")
            SocialButton("https://github.com/lamorak", "github")
            SocialButton("https://stackoverflow.com/users/4584675/lamorak?tab=profile", "stack-overflow")
        }
    }
}
