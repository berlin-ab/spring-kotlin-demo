package demo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringRunner::class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired private lateinit var context: WebApplicationContext

	@Test
	fun contextLoads() {
		val client = MockMvcBuilders.webAppContextSetup(context).build()
		client.perform(get("/scannedItemsTotal")).andExpect(
				status().is2xxSuccessful
		)
	}


}
