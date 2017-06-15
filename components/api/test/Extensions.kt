package api

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

fun MockMvc.performAsync(request: MockHttpServletRequestBuilder): MvcResult {
    return perform(
            MockMvcRequestBuilders.asyncDispatch(perform(request).andReturn())
    ).andReturn()
}
