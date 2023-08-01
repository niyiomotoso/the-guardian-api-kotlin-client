package the.guardian.api.client

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import the.guardian.api.entity.Content
import the.guardian.api.entity.Editions
import the.guardian.api.entity.Sections
import the.guardian.api.entity.SingleItem
import the.guardian.api.entity.Tags

class GuardianApiTest {

    private val validApiKey = "YOUR_VALID_API_KEY"
    private val invalidApiKey = "abc"

    private lateinit var guardianApi: GuardianApi

    @BeforeEach
    fun setUp() {
        guardianApi = GuardianApi(validApiKey)
    }

    @Test
    fun testValidApiKey() {
        // No exception should be thrown for a valid API key
    }

    @Test
    fun testInvalidApiKey() {
        assertThrows(IllegalArgumentException::class.java) {
            GuardianApi(invalidApiKey)
        }
    }

    @Test
    fun testContentMethodReturnsInstanceOfContent() {
        val content = guardianApi.content()
        assertInstanceOf(Content::class.java, content)
    }

    @Test
    fun testTagsMethodReturnsInstanceOfTags() {
        val tags = guardianApi.tags()
        assertInstanceOf(Tags::class.java, tags)
    }

    @Test
    fun testSectionsMethodReturnsInstanceOfSections() {
        val sections = guardianApi.sections()
        assertInstanceOf(Sections::class.java, sections)
    }

    @Test
    fun testEditionsMethodReturnsInstanceOfEditions() {
        val editions = guardianApi.editions()
        assertInstanceOf(Editions::class.java, editions)
    }

    @Test
    fun testSingleItemMethodReturnsInstanceOfSingleItem() {
        val singleItem = guardianApi.singleItem()
        assertInstanceOf(SingleItem::class.java, singleItem)
    }

    private fun <T> assertInstanceOf(expectedClass: Class<T>, obj: Any) {
        assertEquals(expectedClass, obj::class.java)
    }
}
