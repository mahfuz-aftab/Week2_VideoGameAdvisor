package com.mdev.videogameadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGames = findViewById<Button>(R.id.find_game)

        findGames.setOnClickListener {
            val gameGenres = findViewById<Spinner>(R.id.game_genres)
            val genre = gameGenres.selectedItem
            val gamesList = getGames(genre.toString())
            val reducedGamesList = gamesList.reduce {str, item -> str + '\n' + item}
            val games = findViewById<TextView>(R.id.games)
            games.text = reducedGamesList

            val gamesDescriptionList = getGamesDescriptions(genre.toString()).reduce() {str, item->str + '\n' + item}
            val gamesDescriptions = findViewById<TextView>(R.id.games_descriptions)
            gamesDescriptions.text = gamesDescriptionList
        }
    }

    fun getGames(genre: String) : List<String> {
        return when (genre) {
            "Action" -> listOf("Legend of Zelda", "GTA5")
            "Adventure" -> listOf("Final Fantasy", "Elden Ring")
            "Strategy" -> listOf("Age of Empires", "StarCraft")
            "Sports" -> listOf("FIFA22", "NBA2K22")
            "RPG" -> listOf("Elder Scrolls 4", "Fallout")
            else -> listOf("Super Mario", "Kirby")
        }
    }

    fun getGamesDescriptions(genre: String) : List<String> {
        return when(genre) {
            "Action" -> listOf("An action game is a video game genre that emphasizes physical challenges.")
            "Adventure" -> listOf("An adventure game is a video game genre in which the player assumes the role of a protagonist in an interactive story driven by exploration and/or puzzle-solving.")
            "Strategy" -> listOf("A strategy game or strategic game is a game in which the players' uncoerced, and often autonomous.")
            "Sports" -> listOf("A sports video game is a video game that simulates the practice of sports.")
            "RPG" -> listOf("RPG stands for \"role playing game\" in which the player assumes the role of a character set in a fictional setting.")
            else -> listOf("This is Other")
        }
    }
}
