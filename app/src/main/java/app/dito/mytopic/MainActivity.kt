package app.dito.mytopic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    GridHobbyList(
        topicList = ImageData.topics
    )
}

@Preview(showBackground = true)
@Composable
fun GridListHobbyPreview() {
    MyTopicTheme {
        GridHobby()
    }
}


@Composable
fun GridHobbyImageLayout(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(topic.images),
                contentDescription = stringResource(topic.topicDescription)
            )

            Column {
                Text(
                    text = LocalContext.current.getString(topic.topicDescription)
                )

                Text(
                    text = LocalContext.current.getString(topic.topicImages)
                )
            }
        }
    }
}

@Composable
fun GridHobbyList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 6.dp)
    ) {
        items(topicList) { topicList ->
            GridHobbyImageLayout(
                topic = topicList,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}
