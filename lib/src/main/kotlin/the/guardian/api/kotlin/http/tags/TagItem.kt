package the.guardian.api.kotlin.http.tags;

class TagItem {
    var id: String? = null
    var type: String? = null
    var webTitle: String? = null
    var webUrl: String? = null
    var apiUrl: String? = null
    var sectionId: String? = null
    var sectionName: String? = null

    override fun toString(): String {
        return "TagItem(id=$id, type=$type, webTitle=$webTitle, webUrl=$webUrl, apiUrl=$apiUrl, sectionId=$sectionId, sectionName=$sectionName)"
    }
}
