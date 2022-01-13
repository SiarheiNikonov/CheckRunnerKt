data class Product(
    val id: Int,
    val title: String,
    val priceInCents: Int,
    val description: String,
    val producer: String,
    val barcode: Long,
    val onSale: Boolean
)