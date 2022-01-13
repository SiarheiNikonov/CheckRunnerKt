interface ProductRepository {
    fun getProductById(id: Int): Product
}