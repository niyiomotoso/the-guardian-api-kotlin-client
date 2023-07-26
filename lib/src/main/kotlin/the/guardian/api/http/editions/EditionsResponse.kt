package the.guardian.api.http.editions

import the.guardian.api.http.AbstractResponse

class EditionsResponse: AbstractResponse() {
        var status: String? = null
        var userTier: String? = null
        var total = 0
        var results: Array<EditionItem>? = null

        override fun toString(): String {
                return "EditionsResponse(status=$status, userTier=$userTier, total=$total, results=${results?.contentToString()})"
        }
}