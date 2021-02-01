package clone.vtpay.utils

object Utils {
    fun getHistoryIcon(isluong: Boolean): String? {
        return if (isluong) {
            "icon_39"
        } else {
            "icon_34"
        }
    }
}