class DiscountCardRepositoryImpl : DiscountCardRepository {


    override fun getCardById(id: Int): DiscountCard {
        return DiscountCard(
            id,
            when (id % 4) {
                1 -> {DiscountCardType.WOODEN}
                2 -> {DiscountCardType.SILVER}
                3 -> {DiscountCardType.GOLD}
                else -> {DiscountCardType.PLATINUM}
            }
        )
    }

}