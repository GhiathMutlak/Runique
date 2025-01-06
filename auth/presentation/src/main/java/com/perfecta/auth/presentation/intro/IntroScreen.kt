package com.perfecta.auth.presentation.intro

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.perfecta.auth.presentation.R
import com.perfecta.core.presentation.systemdesign.RuniqueTheme
import com.perfecta.core.presentation.systemdesign.Typography
import com.perfecta.core.presentation.systemdesign.components.GradientBackground
import com.perfecta.core.presentation.systemdesign.components.RuniqueActionButton
import com.perfecta.core.presentation.systemdesign.components.RuniqueOutlinedButton

@Composable
fun IntroScreenRoot(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    IntroScreen(
        modifier = modifier,
        onAction = { introAction ->
            when (introAction) {
                IntroAction.OnSignInClick -> onSignInClick()
                IntroAction.OnSignUpClick -> onSignUpClick()
            }
        }
    )
}

@Composable
fun IntroScreen(
    modifier: Modifier = Modifier,
    onAction: (IntroAction) -> Unit,
) {
    GradientBackground {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            RuniqueLogoVertical()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(bottom = 48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.welcome_to_runique),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.welcome_body),
                style = Typography.bodySmall
            )

            Spacer(modifier = Modifier.height(32.dp))

            RuniqueOutlinedButton(
                onClick = { onAction(IntroAction.OnSignInClick) },
                text = stringResource(id = R.string.sign_in)
            )

            Spacer(modifier = Modifier.height(16.dp))

            RuniqueActionButton(
                onClick = { onAction(IntroAction.OnSignUpClick) },
                text = stringResource(id = R.string.sign_up)
            )
        }
    }
}

@Preview
@Composable
private fun IntroScreenPreview() {
    RuniqueTheme {
        IntroScreen {

        }
    }
}