package the.guardian.api.kotlin.http.sections

class SectionItem {
    var id: String? = null
    var webTitle: String? = null
    var webUrl: String? = null
    var apiUrl: String? = null
    var editions: Array<SectionEditionItem>? = null

    override fun toString(): String {
        return "SectionItem(id=$id, webTitle=$webTitle, webUrl=$webUrl, apiUrl=$apiUrl, editions=${editions?.contentToString()})"
    }
}