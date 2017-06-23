import api.ScannedItemsController
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import supermarket.Checkout

class ScannedItemsControllerTest {
    val checkoutSpy = CheckoutSpy()
    val scanItemController = ScannedItemsController(checkoutSpy)
    val client = MockMvcBuilders.standaloneSetup(scanItemController).build()

    @Test
    fun itScansTheGivenItem() {
        makeARequest()

        assertThat(checkoutSpy.itemAdded, equalTo("apple"))
        assertThat(checkoutSpy.quantityAdded, equalTo(3))
    }

    @Test
    fun itReturnsAnOk() {
        makeARequest().andExpect(status().is2xxSuccessful)
    }

    @Test
    fun itReturnsAnOkForTotal() {
        getRequest().andExpect(status().is2xxSuccessful)
    }

    @Test
    fun itReturnsTheTotalFromCheckout() {
        checkoutSpy.stubTotal(100)
        getRequest().andExpect(content().string("""{"total":100}"""))
    }

    private fun makeARequest(): ResultActions {
        return client.perform(
                post("/scannedItems")
                        .param("id", "apple")
                        .param("quantity", "3")
        )
    }

    private fun getRequest(): ResultActions {
        return client.perform(
                get("/scannedItemsTotal")
        )
    }
}

class CheckoutSpy : Checkout {
    var itemAdded: String? = null
    var quantityAdded: Int? = null
    private var stubbedTotal: Int = 0

    override fun add(item: String, quantity: Int) {
        itemAdded = item
        quantityAdded = quantity
    }

    override fun total(): Int {
        return stubbedTotal
    }

    fun stubTotal(total: Int) {
        this.stubbedTotal = total
    }
}
