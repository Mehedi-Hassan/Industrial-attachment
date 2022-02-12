import com.example.ia.model.Color

data class PaginationColor(
    val page : Int,
    val per_page : Int,
    val total : Int,
    val total_pages : Int,
    val data : List<Color>
)
