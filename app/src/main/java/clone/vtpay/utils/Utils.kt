package clone.vtpay.utils

object Utils {
    fun getHistoryIcon(path: String): String? {
        return when (path) {
            "01" -> "icon_34"
            "02" -> "icon_34"
            "03" -> "icon_39"
            else -> null
        }
    }
}