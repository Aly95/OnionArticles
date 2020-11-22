package alyhuggan.onionarticles.data.objects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String = ""
) {
    override fun toString(): String {
        return title
    }

    fun generateID(): Int {
        return (1..999999999).random()
    }
}