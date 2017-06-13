package interesting

import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith


@RunWith(JUnitPlatform::class)
class DirectoryPackageIndependence: Spek({
    it("is able to access a visible class in a sub directory because it is in the same package") {
        assertEquals(SomeOtherClass().data, "Foo")
    }
})
