package actions

interface GitAction {
    val gitCommandName: String

    fun performCommand(args: Array<String>?) {
        val argsString = args?.joinToString(separator = " ") ?: ""
        try {
            Runtime.getRuntime().exec("$gitCommandName $argsString")
        } catch (e: Exception) {
            println(e.message ?: "Exception message is unknown")
        }
    }
}