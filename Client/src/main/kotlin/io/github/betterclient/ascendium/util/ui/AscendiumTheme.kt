package io.github.betterclient.ascendium.util.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.betterclient.ascendium.Ascendium

object AscendiumTheme {
    val shapes: Shapes
        @ReadOnlyComposable @Composable get() = MaterialTheme.shapes
    val colorScheme: ColorScheme
        @ReadOnlyComposable @Composable get() = MaterialTheme.colorScheme
    val typography: Typography
        @ReadOnlyComposable @Composable get() = MaterialTheme.typography
    //TODO: move these to own mutable states
}

@Composable
fun AscendiumTheme(content: @Composable () -> Unit) {
    val colorScheme = colorScheme()
    var t = Typography()
    if (Ascendium.settings.mcFontState) t = t.MCFont()

    val shapes = shapes()
    
    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = t,
        shapes = shapes
    )
}

@Composable
private fun colorScheme() = when(Ascendium.settings.themeState) {
    "Dark" -> darkColorScheme().setButtonColors()
    "Light" -> lightColorScheme().setButtonColors()
    "Minecraft" -> mcColorScheme
    "Diamond" -> cornflowerColorScheme
    "Cornflower" -> cornflowerColorScheme
    "Regolith" -> regolithColorScheme
    else -> throw IllegalStateException()
}

private fun shapes() = Shapes(
    small = RoundedCornerShape((Ascendium.settings.cornerRadiusState * 0.55).dp),
    medium = RoundedCornerShape(Ascendium.settings.cornerRadiusState.dp),
    large = RoundedCornerShape((Ascendium.settings.cornerRadiusState * 1.3333).dp)
)

private fun ColorScheme.setButtonColors() = this.copy(primary = primaryContainer, onPrimary = onPrimaryContainer)

private val mcColorScheme = ColorScheme(
    primary = Color(0xFF5A8A44),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF456B37),
    onPrimaryContainer = Color(0xFFB3E0A3),
    inversePrimary = Color(0xFF6A9B54),
    secondary = Color(0xFF8D9296),
    onSecondary = Color(0xFF1E2122),
    secondaryContainer = Color(0xFF42474A),
    onSecondaryContainer = Color(0xFFDCE2E6),
    tertiary = Color(0xFF68D1E3),
    onTertiary = Color(0xFF00252A),
    tertiaryContainer = Color(0xFF004D58),
    onTertiaryContainer = Color(0xFFB9F2FF),
    background = Color(0xFF1A1C19),
    onBackground = Color(0xFFE2E3DE),
    surface = Color(0xFF1A1C19),
    onSurface = Color(0xFFE2E3DE),
    surfaceVariant = Color(0xFF414940),
    onSurfaceVariant = Color(0xFFC1C9BE),
    surfaceTint = Color(0xFF6A9B54),
    inverseSurface = Color(0xFFE2E3DE),
    inverseOnSurface = Color(0xFF1A1C19),
    error = Color(0xFFC53434),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFF7A2020),
    onErrorContainer = Color(0xFFF9DADA),
    outline = Color(0xFF8B9389),
    outlineVariant = Color(0xFF414940),
    scrim = Color(0x99000000),
    surfaceBright = Color(0xFF383A36),
    surfaceDim = Color(0xFF121411),
    surfaceContainer = Color(0xFF1E201D),
    surfaceContainerHigh = Color(0xFF282B27),
    surfaceContainerHighest = Color(0xFF333632),
    surfaceContainerLow = Color(0xFF1A1C19),
    surfaceContainerLowest = Color(0xFF151714),
    primaryFixed = Color(0xFFB3E0A3),
    primaryFixedDim = Color(0xFF456B37),
    onPrimaryFixed = Color(0xFF1E2122),
    onPrimaryFixedVariant = Color(0xFFB3E0A3),
    secondaryFixed = Color(0xFFDCE2E6),
    secondaryFixedDim = Color(0xFF42474A),
    onSecondaryFixed = Color(0xFF1E2122),
    onSecondaryFixedVariant = Color(0xFFDCE2E6),
    tertiaryFixed = Color(0xFFB9F2FF),
    tertiaryFixedDim = Color(0xFF004D58),
    onTertiaryFixed = Color(0xFF00252A),
    onTertiaryFixedVariant = Color(0xFFB9F2FF),
)

private val cornflowerColorScheme = ColorScheme(
    primary = Color(0xFF6C99FF),
    onPrimary = Color(0xFF001D53),
    primaryContainer = Color(0xFF2E468A),
    onPrimaryContainer = Color(0xFFD9E2FF),
    inversePrimary = Color(0xFF4C61A1),
    secondary = Color(0xFF8A9296),
    onSecondary = Color(0xFF1E2122),
    secondaryContainer = Color(0xFF42474A),
    onSecondaryContainer = Color(0xFFDCE2E6),
    tertiary = Color(0xFFDDB0FF),
    onTertiary = Color(0xFF432258),
    tertiaryContainer = Color(0xFF5C3A70),
    onTertiaryContainer = Color(0xFFF0D9FF),
    background = Color(0xFF1A1C1E),
    onBackground = Color(0xFFE2E2E6),
    surface = Color(0xFF1A1C1E),
    onSurface = Color(0xFFE2E2E6),
    surfaceVariant = Color(0xFF42474C),
    onSurfaceVariant = Color(0xFFC2C7CD),
    surfaceTint = Color(0xFF6C99FF),
    inverseSurface = Color(0xFFE2E2E6),
    inverseOnSurface = Color(0xFF1A1C1E),
    error = Color(0xFFC53434),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFF7A2020),
    onErrorContainer = Color(0xFFF9DADA),
    outline = Color(0xFF8C9198),
    outlineVariant = Color(0xFF42474C),
    scrim = Color(0x99000000),
    surfaceBright = Color(0xFF373A3C),
    surfaceDim = Color(0xFF111415),
    surfaceContainer = Color(0xFF1E2022),
    surfaceContainerHigh = Color(0xFF282A2C),
    surfaceContainerHighest = Color(0xFF333537),
    surfaceContainerLow = Color(0xFF1A1C1E),
    surfaceContainerLowest = Color(0xFF151718),
    primaryFixed = Color(0xFFD9E2FF),
    primaryFixedDim = Color(0xFF2E468A),
    onPrimaryFixed = Color(0xFF001D53),
    onPrimaryFixedVariant = Color(0xFFD9E2FF),
    secondaryFixed = Color(0xFFDCE2E6),
    secondaryFixedDim = Color(0xFF42474A),
    onSecondaryFixed = Color(0xFF1E2122),
    onSecondaryFixedVariant = Color(0xFFDCE2E6),
    tertiaryFixed = Color(0xFFF0D9FF),
    tertiaryFixedDim = Color(0xFF5C3A70),
    onTertiaryFixed = Color(0xFF432258),
    onTertiaryFixedVariant = Color(0xFFF0D9FF),
)

private val regolithColorScheme = ColorScheme(
    primary = Color(0xD9FFFFFF),
    onPrimary = Color(0xFF303230),
    primaryContainer = Color(0xA6FFFFFF),
    onPrimaryContainer = Color(0xFF303230),
    inversePrimary = Color(0xFFBEC3BD),
    secondary = Color(0x80FFFFFF),
    onSecondary = Color(0xFFBEC3BD),
    secondaryContainer = Color(0x70FFFFFF),
    onSecondaryContainer = Color(0xFFE5E6E4),
    tertiary = Color(0x70FFFFFF),
    onTertiary = Color(0xFFBEC3BD),
    tertiaryContainer = Color(0x60FFFFFF),
    onTertiaryContainer = Color(0xFFE5E6E4),
    background = Color(0xFF101110),
    onBackground = Color(0xFFE5E6E4),
    surface = Color(0x45FFFFFF),
    onSurface = Color(0xFFE5E6E4),
    surfaceVariant = Color(0x55FFFFFF),
    onSurfaceVariant = Color(0xFFBEC3BD),
    surfaceTint = Color(0xFFFFFFFF),
    inverseSurface = Color(0xFFE5E6E4),
    inverseOnSurface = Color(0xFF181918),
    error = Color(0xFFC53434),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFF7A2020),
    onErrorContainer = Color(0xFFF9DADA),
    outline = Color(0x60FFFFFF),
    outlineVariant = Color(0x48FFFFFF),
    scrim = Color(0x99000000),
    surfaceBright = Color(0x70FFFFFF),
    surfaceDim = Color(0xFF101110),
    surfaceContainer = Color(0x3CFFFFFF),
    surfaceContainerHigh = Color(0x58FFFFFF),
    surfaceContainerHighest = Color(0x68FFFFFF),
    surfaceContainerLow = Color(0x3CFFFFFF),
    surfaceContainerLowest = Color(0x30FFFFFF),
    primaryFixed = Color(0xFFE5E6E4),
    primaryFixedDim = Color(0xFFBEC3BD),
    onPrimaryFixed = Color(0xFF1E1E1E),
    onPrimaryFixedVariant = Color(0xFF303230),
    secondaryFixed = Color(0xFFBEC3BD),
    secondaryFixedDim = Color(0xFF8F938F),
    onSecondaryFixed = Color(0xFF1E1E1E),
    onSecondaryFixedVariant = Color(0xFF303230),
    tertiaryFixed = Color(0xFFBEC3BD),
    tertiaryFixedDim = Color(0xFF8F938F),
    onTertiaryFixed = Color(0xFF1E1E1E),
    onTertiaryFixedVariant = Color(0xFF303230),
)