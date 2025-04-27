/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.autocomplete.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @author saisirishag 
 * IbaAutoCompleteSetupTag is a setup tag class that holds
 * only the location of scripts and stlye sheets necessary for
 * autocomplete text and combo box.
 */
public class IbaAutoCompleteSetupTag extends BodyTagSupport {
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {

			out
					.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"../../eCommon/html/autocomplete.css\">");

			out
					.println("<link rel=\"STYLESHEET\" type=\"text/css\" href=\"../../eCommon/html/dhtmlxcombo.css\">");
			out
					.println("<script type=\"text/javascript\" src=\"../../eCommon/js/yahoo-dom-event.js\"></script>");
			out
					.println("<script type=\"text/javascript\" src=\"../../eCommon/js/animation-min.js\"></script>  ");

			out
					.println("<script type=\"text/javascript\" src=\"../../eCommon/js/autocomplete-min.js\"></script>");
			out
					.println("<script  src=\"../../eCommon/js/dhtmlxcommon.js\"></script>");
			out
					.println("<script  src=\"../../eCommon/js/dhtmlxcombo.js\"></script>");
			out
					.println("<script  src=\"../../eCommon/js/dhtmlxcombo_whp.js\"></script>");

			out
					.println("<script>window.dhx_globalImgPath=\"../../eCommon/images/\"</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}
}
