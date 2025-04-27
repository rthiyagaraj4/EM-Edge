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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.iba.autocomplete.utilities.SortUtility;

/**
 * @author saisirishag 
 * IbaAutoCompleteComboTag is tag class for autocomplete combo box.
 */
public class IbaAutoCompleteComboTag extends BodyTagSupport {

	private String id;

	private String name;

	private HashMap map;

	private String defaultSelection;

	private int width = 0;

	private String onblur;

	private String onclick;

	private String onchange;

	private String onfocus;

	private String onkeydown;

	private String onkeypress;

	private String onkeyup;

	private String onmousedown;

	private String onmousemove;

	private String onmouseout;

	private String onmouseover;

	private String onmouseup;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		String outputString = buildCombo();
		try {
			out.println(outputString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	/**
	 * buildCombo() method builds the string necessary which is can be used to
	 * display the autocomplete combo Box. we have to set the options list for
	 * combo in the form of HashMap.
	 * 
	 * @return outputString
	 */
	public String buildCombo() {
		StringBuffer outputString = new StringBuffer();

		try {

			HashMap inputListUnordered = (HashMap) getMap();
			Map sortedMap = SortUtility.sortMapByValue(inputListUnordered, true);
			StringBuffer appendEvents = appendEvevnts();
			if (getWidth() == 0) {

				outputString.append("<select id=\"" + getId() + "\" name=\""
						+ getName() + "\" " + appendEvents
						+ "style='width:200px;'>");

			} else {

				outputString.append("<select id=\"" + getId() + "\" name=\""
						+ getName() + "\" " + appendEvents + "style='width:"
						+ getWidth() + "px;'>");

			}

			if (getDefaultSelection() != null
					&& !(getDefaultSelection().equals(""))) {

				if (!(sortedMap.get(getDefaultSelection()).equals(""))) {
					outputString.append("<option  value=\""
							+ getDefaultSelection()
							+ "\" selected=\"selected\">"
							+ sortedMap.get(getDefaultSelection())
							+ "</option>");
				} else {
					outputString.append("<option value=\""
							+ getDefaultSelection()
							+ "\" selected=\"selected\">"
							+ getDefaultSelection() + "</option>");

				}
			sortedMap.remove(getDefaultSelection());
			}
			Set set = sortedMap.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Entry element = (Entry) iterator.next();

				if (!(element.getValue().equals(""))) {
					outputString.append("<option value=\"" + element.getKey()
							+ "\">" + element.getValue() + "</option>");
				} else {
					outputString.append("<option value=\"" + element.getKey()
							+ "\">" + element.getKey() + "</option>");
				}
			}
			outputString.append("</select>");
			
			outputString.append("<script type=\"text/javascript\">var "
					+ getId() + "=dhtmlXComboFromSelect(\"" + getId() + "\");	"
					+ getId() + ".enableFilteringMode(true);" + getId()
					+ ".enableOptionAutoPositioning(true);dhtmlxEvent("+ getId() + ".DOMelem,\"click\",function(){" + getId()+ "._last=(new Date()).valueOf();})</script>");
			/*
			  outputString.append("<script type=\"text/javascript\">var " +
			  getId() + "=dhtmlXComboFromSelect(\"" + getId() + "\"); " +
			  getId() + ".enableFilteringMode(true);" + getId() +
			  ".enableOptionAutoPositioning(true);</script>");*/
			 
			 
			outputString
					.append("<script type=\"text/javascript\">"
							+ getId()
							+ ".attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-("
							+ getId() + "._last||0) > 100) return;var text = "+ getId() + ".getComboText();" + getId()+ ".setComboText(\"\");" + getId()
							+ ".filterSelf();},1); })</script>");
			
			/*if (getDefaultSelection() != null
					&& !(getDefaultSelection().equals(""))) {
				outputString.append("<script type=\"text/javascript\">"+getId()+".updateOption(\""+getDefaultSelection()+"\") ;</script>");
				
			}*/
			
			
			 
			/*
			 * if (getOnblur() != null) { outputString.append("<script
			 * type=\"text/javascript\"> " + getId() +
			 * ".attachEvent(\"onBlur\",function(){ " + getOnblur() + " });
			 * </script>"); }
			 */
			/*
			 * if (getOnkeypress() != null) { outputString.append("<script
			 * type=\"text/javascript\">" + getId() +
			 * ".attachEvent(\"onKeyPressed\",function(){ " + getOnkeypress() + "
			 * }); </script>"); }
			 */

			if (getOnmouseover() != null) {

				outputString.append(eventsLogic(getId(), "mouseover",
						getOnmouseover()));
			}
			if (getOnchange() != null) {

				outputString.append(eventsLogic(getId(), "onchange",
						getOnchange()));
			}
			if (getOnmouseup() != null) {

				outputString.append(eventsLogic(getId(), "mouseup",
						getOnmouseup()));
			}
			if (getOnfocus() != null) {
				outputString
						.append(eventsLogic(getId(), "focus", getOnfocus()));

			}
			if (getOnclick() != null) {
				outputString
						.append(eventsLogic(getId(), "click", getOnclick()));
			}
			if (getOnkeydown() != null) {
				outputString.append(eventsLogic(getId(), "keydown",
						getOnkeydown()));
			}
			if (getOnkeyup() != null) {
				outputString
						.append(eventsLogic(getId(), "keyup", getOnkeyup()));
			}
			if (getOnmousedown() != null) {
				outputString.append(eventsLogic(getId(), "mousedown",
						getOnmousedown()));
			}
			if (getOnmousemove() != null) {
				outputString.append(eventsLogic(getId(), "mousemove",
						getOnmousemove()));
			}
			if (getOnmouseout() != null) {
				outputString.append(eventsLogic(getId(), "mouseout",
						getOnmouseout()));
			}
			if (getOnkeypress() != null) {
				outputString.append(eventsLogic(getId(), "keypress",
						getOnkeypress()));
			}
			if (getOnblur() != null) {
				outputString.append(eventsLogic(getId(), "blur", getOnblur()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return outputString.toString();
	}

	/**
	 * eventsLogic(...) method takes the logic for an event to act in dhtml.
	 * 
	 * @param id
	 * @param eventName
	 * @param event
	 * @return outputLine
	 */

	public String eventsLogic(String id, String eventName, String event) {
		String outputLine = "";
		outputLine = "<script type=\"text/javascript\">dhtmlxEvent(" + id
				+ ".DOMelem_input,\"" + eventName + "\",function(){" + event
				+ "});</script>";

		return outputLine;
	}

	/**
	 * appendEvevnts() method appends the events specified for any respective
	 * combo box.
	 * 
	 * @return appendEvent
	 */
	public StringBuffer appendEvevnts() {

		StringBuffer appendEvent = new StringBuffer();
		if (getOnblur() != null) {
			appendEvent.append("onblur=\"" + getOnblur() + "\" ");
		}

		/*
		 * if (getOnblur() != null) { appendEvent.append("onblur=\"" +
		 * getOnblur() + "\" "); }
		 */
		if (getOnchange() != null) {
			appendEvent.append("onchange=\"" + getOnchange() + "\" ");
		}
		if (getOnclick() != null) {
			appendEvent.append("onclick=\"" + getOnclick() + "\" ");
		}
		if (getOnfocus() != null) {
			appendEvent.append("onfocus=\"" + getOnfocus() + "\" ");
		}
		if (getOnkeydown() != null) {
			appendEvent.append("onkeydown=\"" + getOnkeydown() + "\" ");
		}
		if (getOnkeypress() != null) {
			appendEvent.append("onkeypress=\"" + getOnkeypress() + "\" ");
		}
		if (getOnkeyup() != null) {
			appendEvent.append("onkeyup=\"" + getOnkeyup() + "\" ");
		}
		if (getOnmousedown() != null) {
			appendEvent.append("onmousedown=\"" + getOnmousedown() + "\" ");
		}
		if (getOnmousemove() != null) {
			appendEvent.append("onmousemove=\"" + getOnmousemove() + "\" ");
		}
		if (getOnmouseout() != null) {
			appendEvent.append("onmouseout=\"" + getOnmouseout() + "\" ");
		}
		if (getOnmouseover() != null) {
			appendEvent.append("onmouseover=\"" + getOnmouseover() + "\" ");
		}
		if (getOnmouseup() != null) {
			appendEvent.append("onmouseup=\"" + getOnmouseup() + "\" ");
		}

		return appendEvent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	/**
	 * sets the name of combo box
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of combo box
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the default selection value for combo box.
	 * 
	 * @return defaultSelection
	 */
	public String getDefaultSelection() {
		return defaultSelection;
	}

	/**
	 * sets the default selection value for combo box.
	 * 
	 * @param defaultSelection
	 */
	public void setDefaultSelection(String defaultSelection) {
		this.defaultSelection = defaultSelection;
	}

	/**
	 * gets the width for combo box.
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * sets the width for combo box.
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * gets the options list for combo as HashMap
	 * 
	 * @return map
	 */
	public HashMap getMap() {
		return map;
	}

	/**
	 * sets the options list for combo as HashMap
	 * 
	 * @param map
	 */
	public void setMap(HashMap map) {
		this.map = map;
	}

	/**
	 * gets the onblur event.
	 * 
	 * @return onblur
	 */
	public String getOnblur() {
		return onblur;
	}

	/**
	 * sets the onblur event.
	 * 
	 * @param onblur
	 */
	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	/**
	 * gets the onchange event.
	 * 
	 * @return onchange
	 */
	public String getOnchange() {
		return onchange;
	}

	/**
	 * sets the onchange event.
	 * 
	 * @param onchange
	 */
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	/**
	 * sets the onclick event.
	 * 
	 * @return onclick
	 */
	public String getOnclick() {
		return onclick;
	}

	/**
	 * sets the onclick event.
	 * 
	 * @param onclick
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	/**
	 * gets the onfocus event.
	 * 
	 * @return onfocus
	 */
	public String getOnfocus() {
		return onfocus;
	}

	/**
	 * sets the onfocus event.
	 * 
	 * @param onfocus
	 */
	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	/**
	 * sets the onkeydown event.
	 * 
	 * @return onkeydown
	 */
	public String getOnkeydown() {
		return onkeydown;
	}

	/**
	 * sets the onkeydown event.
	 * 
	 * @param onkeydown
	 */
	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	/**
	 * gets the onkeypress event.
	 * 
	 * @return onkeypress
	 */
	public String getOnkeypress() {
		return onkeypress;
	}

	/**
	 * sets the onkeypress event.
	 * 
	 * @param onkeypress
	 */
	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	/**
	 * gets the onkeyup event.
	 * 
	 * @return onkeyup
	 */
	public String getOnkeyup() {
		return onkeyup;
	}

	/**
	 * sets the onkeyup event.
	 * 
	 * @param onkeyup
	 */
	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	/**
	 * gets the onmousedown event.
	 * 
	 * @return onmousedown
	 */
	public String getOnmousedown() {
		return onmousedown;
	}

	/**
	 * sets the onmousedown event.
	 * 
	 * @param onmousedown
	 */
	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	/**
	 * gets the onmousemove event.
	 * 
	 * @return onmousemove
	 */
	public String getOnmousemove() {
		return onmousemove;
	}

	/**
	 * sets the onmousemove event.
	 * 
	 * @param onmousemove
	 */
	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	/**
	 * gets the onmouseout event.
	 * 
	 * @return onmouseout
	 */
	public String getOnmouseout() {
		return onmouseout;
	}

	/**
	 * sets the onmouseout event.
	 * 
	 * @param onmouseout
	 */
	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	/**
	 * sets the onmouseover event.
	 * 
	 * @return onmouseover
	 */
	public String getOnmouseover() {
		return onmouseover;
	}

	/**
	 * sets the onmouseover event.
	 * 
	 * @param onmouseover
	 */
	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	/**
	 * gets the onmouseup event.
	 * 
	 * @return onmouseup
	 */
	public String getOnmouseup() {
		return onmouseup;
	}

	/**
	 * sets the onmouseup event.
	 * 
	 * @param onmouseup
	 */
	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	/**
	 * gets the id of combo box.
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * sets the id of combo box.
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
}
