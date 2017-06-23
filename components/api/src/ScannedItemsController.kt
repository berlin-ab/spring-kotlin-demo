package api

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import supermarket.Checkout

@Controller
class ScannedItemsController(val checkout: Checkout) {
    @PostMapping("/scannedItems")
    fun post(
            @RequestParam id: String,
            @RequestParam quantity: Int): ResponseEntity<Void> {
        checkout.add(id, quantity)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/scannedItemsTotal")
    fun get(): ResponseEntity<*> {
        val total = checkout.total()

        return ResponseEntity.ok(mapOf("total" to total))
    }
}