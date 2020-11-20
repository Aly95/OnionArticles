package alyhuggan.onionarticles.data.objects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String
) {
    override fun toString(): String {
        return title
    }
}