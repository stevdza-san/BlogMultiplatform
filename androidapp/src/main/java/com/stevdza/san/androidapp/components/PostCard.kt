package com.stevdza.san.androidapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.blogmultiplatform.models.Category
import com.stevdza.san.androidapp.models.PostSync
import com.stevdza.san.androidapp.util.convertLongToDate
import com.stevdza.san.androidapp.util.decodeThumbnailImage

@Composable
fun PostCard(
    post: PostSync,
    onPostClick: (String) -> Unit
) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(size = 12.dp))
            .clickable { onPostClick(post._id) },
        tonalElevation = 1.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                modifier = Modifier.height(260.dp),
                model = ImageRequest
                    .Builder(context)
                    .data(
                        if (post.thumbnail.contains("http")) post.thumbnail
                        else post.thumbnail.decodeThumbnailImage()
                    )
                    .build(),
                contentDescription = "Post Thumbnail",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 6.dp)
                        .alpha(0.5f),
                    text = post.date.convertLongToDate(),
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    modifier = Modifier.padding(bottom = 6.dp),
                    text = post.title,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                Text(
                    modifier = Modifier.padding(bottom = 6.dp),
                    text = post.subtitle,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
                SuggestionChip(
                    onClick = { },
                    label = { Text(text = Category.valueOf(post.category).name) }
                )
            }
        }
    }
}