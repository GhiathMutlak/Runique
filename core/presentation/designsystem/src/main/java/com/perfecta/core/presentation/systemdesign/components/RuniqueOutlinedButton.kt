package com.perfecta.core.presentation.systemdesign.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.perfecta.core.presentation.systemdesign.RuniqueBlack
import com.perfecta.core.presentation.systemdesign.RuniqueGray
import com.perfecta.core.presentation.systemdesign.RuniqueTheme

@Composable
fun RuniqueOutlinedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    isLoading: Boolean = false,
    isEnabled: Boolean = true,
) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        onClick = onClick,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            disabledContainerColor = RuniqueGray,
            disabledContentColor = RuniqueBlack
        ),
        shape = RoundedCornerShape(100f),
        border = BorderStroke(width = 0.5.dp, color = MaterialTheme.colorScheme.onBackground)
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(15.dp)
                    .alpha(if (isLoading) 1f else 0f),
                strokeWidth = 1.5.dp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                modifier = Modifier.alpha(if (isLoading) 0f else 1f),
                text = text,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }

}

@Preview
@Composable
private fun RuniqueOutlinedButtonPreview() {
    RuniqueTheme {
        RuniqueOutlinedButton(onClick = { /*TODO*/ }, text = "Sign up")
    }
}