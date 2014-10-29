package org.jboss.reddeer.quickstart.test;

import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.jboss.reddeer.swt.condition.ShellWithTextIsAvailable;
import org.jboss.reddeer.swt.impl.button.PushButton;
import org.jboss.reddeer.swt.impl.menu.ShellMenu;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.jboss.reddeer.swt.impl.text.LabeledText;
import org.jboss.reddeer.swt.impl.tree.DefaultTreeItem;
import org.jboss.reddeer.swt.wait.WaitWhile;
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

}
