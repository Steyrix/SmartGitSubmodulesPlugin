package actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import git4idea.branch.GitBranchUtil

class SbCheckout : AnAction(), GitAction {

    override fun actionPerformed(e: AnActionEvent) {
        // Show branches popup -> perform command
        val project = e.getRequiredData(CommonDataKeys.PROJECT)
        val repo = GitBranchUtil.getCurrentRepository(project)
        
    }

    override val gitCommandName: String = "git sbcheckout"
}