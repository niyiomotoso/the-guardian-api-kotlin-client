package the.guardian.api.kotlin.entity

class ContentItem {
        var id: String? = null
        var type: String? = null
        var sectionId: String? = null
        var sectionName: String? = null
        var webPublicationDate: String? = null
        var webTitle: String? = null
        var webUrl: String? = null
        var apiUrl: String? = null
        var pillarId: String? = null
        var pillarName: String? = null
        var isHosted: Boolean? = null

        override fun toString(): String {
                return "ContentItem(id=$id, type=$type, sectionId=$sectionId, sectionName=$sectionName, webPublicationDate=$webPublicationDate, webTitle=$webTitle, webUrl=$webUrl, apiUrl=$apiUrl, pillarId=$pillarId, pillarName=$pillarName, isHosted=$isHosted)"
        }


}
