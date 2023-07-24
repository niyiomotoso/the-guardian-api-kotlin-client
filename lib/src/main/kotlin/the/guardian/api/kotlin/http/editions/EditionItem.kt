package the.guardian.api.kotlin.http.editions;

class EditionItem {
    var id: String? = null
    var edition: String? = null
    var webTitle: String? = null
    var webUrl: String? = null
    var apiUrl: String? = null
    var path: String? = null


    override fun toString(): String {
        return "EditionItem(id=$id, edition=$edition, webTitle=$webTitle, webUrl=$webUrl, apiUrl=$apiUrl, path=$path)"
    }
}
