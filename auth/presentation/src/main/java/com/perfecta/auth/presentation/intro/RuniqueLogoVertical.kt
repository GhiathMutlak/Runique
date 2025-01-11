package com.perfecta.auth.presentation.intro

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.perfecta.auth.presentation.R
import com.perfecta.core.presentation.designsystem.LogoIcon
import com.perfecta.core.presentation.designsystem.RuniqueTheme

@Composable
fun RuniqueLogoVertical(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = LogoIcon,
            contentDescription = "Runique Logo",
            tint = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(id = R.string.runique),
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Medium,
            fontSize = 23.sp
        )
    }
}

@Preview
@Composable
private fun RuniqueLogoVerticalPreview() {
    RuniqueTheme {
        RuniqueLogoVertical()
    }
}