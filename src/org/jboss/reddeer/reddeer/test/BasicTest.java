package org.jboss.reddeer.reddeer.test;

import static org.junit.Assert.assertTrue;

import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(RedDeerSuite.class)
public class BasicTest {

	@Test
	public void basicTest() {
		assertTrue(new DefaultShell().getText() != null);
	}

}
