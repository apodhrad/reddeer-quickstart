package org.jboss.reddeer.quickstart.test;

import org.jboss.reddeer.gef.editor.GEFEditor;
import org.jboss.reddeer.gef.impl.editpart.LabeledEditPart;
import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.jboss.reddeer.requirements.openperspective.OpenPerspectiveRequirement.OpenPerspective;
import org.jboss.reddeer.swt.condition.JobIsRunning;
import org.jboss.reddeer.swt.condition.ShellWithTextIsAvailable;
import org.jboss.reddeer.swt.impl.button.PushButton;
import org.jboss.reddeer.swt.impl.combo.LabeledCombo;
import org.jboss.reddeer.swt.impl.menu.ContextMenu;
import org.jboss.reddeer.swt.impl.menu.ShellMenu;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.jboss.reddeer.swt.impl.text.LabeledText;
import org.jboss.reddeer.swt.impl.tree.DefaultTreeItem;
import org.jboss.reddeer.swt.wait.WaitWhile;
import org.jboss.reddeer.workbench.impl.view.WorkbenchView;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <h3>RedDeer Quickstart</h3>
 * 
 * A basic test which creates a general project. You can run the test as follows:
 * 
 * <p>Run > Run Configurations... > RedDeer Test > Basic Test</p>
 * 
 * @author Andrej Podhradsky
 *
 */
@OpenPerspective(BPELPerspective.class)
@RunWith(RedDeerSuite.class)
public class BasicTest {

	@Test
	public void basicTest() {
		new ShellMenu("File", "New", "Project...").select();
		new DefaultShell("New Project");
		new DefaultTreeItem("General", "Project").select();
		new PushButton("Next >").click();
		new LabeledText("Project name:").setText("general");
		new PushButton("Finish").click();
		new WaitWhile(new ShellWithTextIsAvailable("New Project"));
	}
	
	@Test
	public void bpelTest() {
		new ShellMenu("File","New","Project...").select();
		new DefaultShell("New Project");
		new DefaultTreeItem("BPEL 2.0","BPEL Project").select();
		new PushButton("Next >").click();
		new LabeledText("Project name:").setText("hello");
		new PushButton("Finish").click();
		new WaitWhile(new JobIsRunning());
		
		new WorkbenchView("Package Explorer");
		new DefaultTreeItem("hello","bpelContent").select();
		new ContextMenu("New","Other...").select();
		new DefaultShell("New");
		new DefaultTreeItem("BPEL 2.0","BPEL Process File").select();
		new PushButton("Next >").click();
		new LabeledText("Process Name:").setText("hello");
		new LabeledCombo("Namespace:").setSelection(0);
		new PushButton("Next >").click();
		new PushButton("Next >").click();
		new PushButton("Finish").click();
		new WaitWhile(new JobIsRunning());

		new GEFEditor("hello.bpel").save();
		new LabeledEditPart("receiveInput").select();
	
		new BPELActivity("main").select();
		new BPELActivity("FIX_ME-Add_Business_Logic_Here").select();
		new ContextMenu("Delete").select();
		new GEFEditor("hello.bpel").save();
	}

}
