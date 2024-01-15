package app.dito.mytopic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.dito.mytopic.data.ImageData
import app.dito.mytopic.models.Topic
import app.dito.mytopic.ui.theme.MyTopicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTopicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    GridListHobbyPreview()
                }
            }
        }
    }
}

@Composable
fun GridHobby() {
    GridHobbyList(topicsList = ImageData.topics)
}

@Composable
fun GridHobbyImageLayout(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(topic.images),
                contentDescription = stringResource(topic.topicDescription),
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(68.dp, 68.dp)
                    .aspectRatio(1f)
            )

            Column {
                Text(
                    text = LocalContext.current.getString(topic.topicDescription),
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 12.sp
                )
                Spacer(
                    modifier = Modifier.height(5.dp)
                )
                Text(
                    text = topic.topicImages.toString(),
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 10.sp
                )
            }
        }
    }
}


@Composable
fun GridHobbyList(topicsList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(topicsList) { topicList ->
            GridHobbyImageLayout(
                topic = topicList, modifier = modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridListHobbyPreview() {
    MyTopicTheme {
        GridHobby()
    }
}
