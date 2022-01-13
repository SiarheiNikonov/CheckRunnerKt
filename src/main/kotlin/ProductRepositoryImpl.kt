class ProductRepositoryImpl : ProductRepository {
    private val products = mutableListOf<Product>().apply {
        for (i in 1..50) {
            this.add(
                Product(
                    id = i,
                    title = "Product$i",
                    priceInCents = (10..10000).random(),
                    description = "description$i",
                    producer = when (i % 5) {
                        0 -> {
                            "HP"
                        }
                        1 -> {
                            "SAMSUNG"
                        }
                        2 -> {
                            "LENOVO"
                        }
                        3 -> {
                            "DELL"
                        }
                        else -> {
                            "APPLE"
                        }
                    },
                    1234567891112 + i,
                    i % 3 == 0
                )
            )
        }
    }

    override fun getProductById(id: Int): Product {
        return products[id-1]
    }
}