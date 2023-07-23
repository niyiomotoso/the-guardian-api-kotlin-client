package the.guardian.api.kotlin.entity

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.mashape.unirest.http.ObjectMapper
import com.mashape.unirest.http.Unirest
import the.guardian.api.kotlin.http.AbstractResponse
import java.io.IOException

/**
 * Base class for all available guardian API entities
 */
abstract class ApiEntity(_baseUrl: String) {
    /** Query term to search for */
    var query: String = ""
    /** The base API URL for the API entity */
    var baseUrl: String = ""
    /** The format to return the results in. */
    var format: String = "json"

    init {
        this.baseUrl = _baseUrl
        Unirest.setObjectMapper(object : ObjectMapper {
            private val jacksonObjectMapper: com.fasterxml.jackson.databind.ObjectMapper = com.fasterxml.jackson.databind.ObjectMapper()

            override fun <T> readValue(value: String, valueType: Class<T>): T {
                return try {
                    jacksonObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).readValue(value, valueType)
                } catch (e: IOException) {
                    throw RuntimeException(e)
                }
            }

            override fun writeValue(value: Any): String {
                return try {
                    jacksonObjectMapper.writeValueAsString(value)
                } catch (e: JsonProcessingException) {
                    throw RuntimeException(e)
                }
            }
        })
    }

    /**
     * Constructs valid request URL from set parameters
     * @return string Valid URL from set parameters
     */
    abstract fun buildUrl()

    abstract fun  fetch(): AbstractResponse?
}