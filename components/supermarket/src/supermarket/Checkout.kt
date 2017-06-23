package supermarket

import javax.inject.Named

interface CheckoutApp {}

data class ScannedItem(
        val id: String,
        val quantity: Int
)

interface Checkout {
    fun add(item: String, quantity: Int = 1)
    fun total(): Int
}

@Named
class RealCheckout : Checkout {
    val items = mutableListOf<ScannedItem>()

    override fun add(item: String, quantity: Int) {
        items.add(ScannedItem(id = item, quantity = quantity))
    }

    override fun total(): Int {
        if (items.isEmpty()) {
            return 0
        }

        return items.map {
            getCost(it)
        }.reduce { acc, i ->
            acc + i
        }
    }

    fun getCost(scannedItem: ScannedItem): Int {
        var cost = when (scannedItem.id) {
            "apple" -> 10
            "orange" -> 3
            else -> 0
        }
        return scannedItem.quantity * cost
    }
}