package the.guardian.api.kotlin.http.sections

import the.guardian.api.kotlin.http.AbstractResponse

class SectionsResponse: AbstractResponse() {
        var status: String? = null
        var userTier: String? = null
        var total = 0
        var results: Array<SectionItem>? = null

        override fun toString(): String {
                return "SectionsResponse(status=$status, userTier=$userTier, total=$total, results=${results?.contentToString()})"
        }

}