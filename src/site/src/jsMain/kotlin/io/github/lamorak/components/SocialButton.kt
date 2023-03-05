import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.navigation.open
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.FaIcon
import com.varabyte.kobweb.silk.components.icons.fa.IconCategory
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import kotlinx.browser.window
import org.jetbrains.compose.web.css.px

@Composable
fun SocialButton(link: String, icon: String) {
    Button(
        modifier = Modifier.clip(Circle())
            .backgroundColor(Colors.Transparent),
        onClick = {
            window.open(link, OpenLinkStrategy.IN_NEW_TAB_FOREGROUND)
        }
    ) {
        Box(Modifier.margin(8.px)) { FaIcon(icon, Modifier, IconCategory.BRAND, IconSize.LG) }
    }
}