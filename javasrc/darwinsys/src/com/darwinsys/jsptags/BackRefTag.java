package com.darwinsys.jsptags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * BackRefTag - generate a href back to the referrer, initially for use on help.
 * @version $Id: BackRefTag.java,v 1.3 2004/06/16 18:50:24 ian Exp $
 */
public class BackRefTag extends TagSupport {
	private final static String DEFAULT_LABEL = "Back";
	private String surroundingtag;
	private String label;

	/** Invoked at the end tag boundary, does the work */
	public int doEndTag() throws JspException {
		final String myLabel = label == null ? DEFAULT_LABEL : label;
		try {
			final HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			final JspWriter out = pageContext.getOut();
			final String whereFrom = request.getHeader("referer");
			if (whereFrom == null) {
				System.out.println("Warning: BackRefTag: no referer");
				return SKIP_BODY;
			}
			if (surroundingtag != null) {
				out.println("<" + surroundingtag + ">");
			}
			out.println("<a href=" + whereFrom + ">" + 
							(label == null ? DEFAULT_LABEL : label) + "</a>");
			if (surroundingtag != null) {
				out.println("<" + "/" + surroundingtag + ">");
			}
			out.flush();
			return SKIP_BODY;
		} catch (Throwable t) {
			System.err.println("Tag caught: " + t);
			throw new JspException(t.toString());
		}
	}

	/**
	 * @param lab The label to print (e.g., "Back");
	 */
	public void setLabel(String lab) {
		label = lab;
	}
	
	/**
	 * @param surround The HTML tag to surrounding the link (e.g., "h6").
	 */
	public void setSurroundingtag(String surround) {
		surroundingtag = surround;
	}
}
