package actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.ex.ComboBoxAction
import com.intellij.openapi.project.DumbAwareAction
import git4idea.branch.GitBranchUtil
import git4idea.config.GitVcsSettings
import git4idea.ui.branch.GitBranchPopup

class SCheckout : DumbAwareAction(), GitAction {

    override fun actionPerformed(e: AnActionEvent) {
        // Show branches popup -> perform command
        val project = e.getRequiredData(CommonDataKeys.PROJECT)
        val vcsSettings = GitVcsSettings.getInstance(project)
        val file = e.getData(CommonDataKeys.VIRTUAL_FILE)
        val repository =
            if (file == null) GitBranchUtil.getCurrentRepository(project) else GitBranchUtil.getRepositoryOrGuess(
                project,
                file
            )
        if (repository != null) {
            GitBranchPopup.getInstance(project, repository).asListPopup().showCenteredInCurrentWindow(project)
        }
    }

    override fun update(e: AnActionEvent) {
        val project = e.project
        e.presentation.isEnabledAndVisible = project != null && !project.isDisposed
    }

    override val gitCommandName: String = "git scheckout"
}