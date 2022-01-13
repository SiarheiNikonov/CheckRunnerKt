import kotlin.math.roundToInt

fun main(args: Array<String>) {

    val map: LinkedHashMap<Product, Int> = LinkedHashMap()
    val productRepository = ProductRepositoryImpl()
    val discountCardRepository = DiscountCardRepositoryImpl()
    var card: DiscountCard? = null
    args.forEach { argument ->
        argument.split("-").also {
            if (it[0] == "card") card = discountCardRepository.getCardById(it[1].toInt())
            else {
                val product = productRepository.getProductById(it[0].toInt())
                val quantity = it[1].toInt()
                map.put(product, quantity)
            }
        }
    }

    println("CASH RECEIPT")
    println("SOME USELESS INFO")

    var total = 0
    var wholesaleDiscount = 0
    var cardDiscount = 0

    map.forEach {
        val price = it.key.priceInCents
        val fullCost = price * it.value
        total += fullCost
        var discount: Int
        print("${it.value}  ${it.key.title} ${price.toDollarsWithCents()} ${fullCost.toDollarsWithCents()}")
        if (it.value > 5 && it.key.onSale) {
            discount = (fullCost * 0.1).roundToInt()
            wholesaleDiscount += discount
            println("(-${discount.toDollarsWithCents()})")
        } else println()
    }

    println("SUMMARY COST: ${total.toDollarsWithCents()}")
    if (wholesaleDiscount != 0) println("WHOLESALE DISCOUNT: ${wholesaleDiscount.toDollarsWithCents()}")

    card?.let {
        cardDiscount = ((total - wholesaleDiscount) * it.type.discount / 100.0).roundToInt()
        println("CARD DISCOUNT: ${cardDiscount.toDollarsWithCents()}")
    }

    println("TOTAL ${(total - wholesaleDiscount - cardDiscount).toDollarsWithCents()}")
}

fun Int.toDollarsWithCents(): String {
    return "$${this / 100},${this % 100}"
}
