package org.jboss.reddeer.quickstart.test;

import org.jboss.reddeer.gef.impl.editpart.AbstractEditPart;

public class BPELActivity extends AbstractEditPart {

	public BPELActivity(String name) {
		super(new ActivityWithName(name));
	}

}
