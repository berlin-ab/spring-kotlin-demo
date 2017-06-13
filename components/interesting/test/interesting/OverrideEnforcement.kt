package interesting

import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

interface SomeInterface {
    fun foo(): String
}

class OverrideEnforcement : SomeInterface {
    override fun foo() : String {
        return "removing this override will cause a compilation error"
    }
}

@RunWith(JUnitPlatform::class)
class OverrideEnforcementSpec : Spek({
    it("demonstrates") {
        assertEquals(OverrideEnforcement().foo(), "removing this override will cause a compilation error")
    }
})