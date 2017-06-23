package supermarket

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class SupermarketSpec : Spek({
    describe("a checkout") {
        var checkout = RealCheckout()

        beforeEachTest {
            checkout = RealCheckout()
        }

        it("returns the total for a single item") {
            checkout.add("apple")
            assertThat(checkout.total(), equalTo(10))
        }

        it("returns the total for two items") {
            checkout.add("apple", quantity = 2)
            assertThat(checkout.total(), equalTo(20))
        }

        it("returns the total cost for another type of items") {
            checkout.add("orange")
            assertThat(checkout.total(), equalTo(3))
        }

        it("returns the total cost for two types of items") {
            checkout.add("orange")
            checkout.add("apple")
            assertThat(checkout.total(), equalTo(13))
        }
    }
})


