package com.darwinsys.jsptags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * LoggedInUser - include body content if the user is logged in as "user".
 * @version $Id: LoggedInUserTag.java,v 1.3 2004/06/16 18:50:24 ian Exp $
 */
public class LoggedInUserTag extends BodyTagSupport {
	private String userName;

	/** Invoked at the tag start transition; does the work */
	public int doStartTag() throws JspException {
		String myLabel = null;

		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		return request.getRemoteUser().equals(userName) ? EVAL_BODY_INCLUDE : SKIP_BODY;

	}

	/**
	 * @param label The role to check for (e.g., "admin");
	 */
	public void setUser(String label) {
		this.userName = label;
	}
}
