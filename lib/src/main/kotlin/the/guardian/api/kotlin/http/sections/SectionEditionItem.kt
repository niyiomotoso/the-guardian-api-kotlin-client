package the.guardian.api.kotlin.http.sections

class SectionEditionItem {
    var id: String? = null
    var webTitle: String? = null
    var webUrl: String? = null
    var apiUrl: String? = null
    var code: String? = null

    override fun toString(): String {
        return "SectionEditionItem(id=$id, webTitle=$webTitle, webUrl=$webUrl, apiUrl=$apiUrl, code=$code)"
    }
}