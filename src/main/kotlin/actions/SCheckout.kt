package actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.openapi.ui.ComboBox
import git4idea.config.GitVcsSettings
import javax.swing.JFrame
import javax.swing.JPanel

class SCheckout : DumbAwareAction(), GitAction {

    override fun actionPerformed(e: AnActionEvent) {
        // Show branches popup -> perform command
        val branches = GitVcsSettings
            .getInstance(e.getRequiredData(CommonDataKeys.PROJECT))
            .recentBranchesByRepository

        setupUI(branches.keys.toList())
    }

    override val gitCommandName: String = "git scheckout"

    private fun setupUI(items: List<String>) {
        val frame = JFrame()
        val panel = JPanel()

        panel.add(
            ComboBox(items.toTypedArray()).apply {
                addItemListener {
                    performCommand(it.item.toString())
                }
            })

        frame.add(panel)
        frame.contentPane = panel
        frame.isVisible = true
    }

}