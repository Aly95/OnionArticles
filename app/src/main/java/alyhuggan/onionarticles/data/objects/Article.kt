package alyhuggan.onionarticles.data.objects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
data class Article(
    var title: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}