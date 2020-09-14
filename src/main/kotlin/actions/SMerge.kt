package actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class SMerge : AnAction(), GitAction {
    override fun actionPerformed(e: AnActionEvent) {
        // Show branches popup -> perform command
    }

    override val gitCommandName: String = "git smerge"
}