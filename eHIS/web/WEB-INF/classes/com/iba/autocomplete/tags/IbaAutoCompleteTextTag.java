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
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.iba.framework.cache.pojo.business.Cache;
import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.framework.core.util.Constants;

/**
 * @author saisirishag 
 * IbaAutoCompleteTextTag is tag class for autocomplete Text box.
 */
public class IbaAutoCompleteTextTag extends BodyTagSupport {

	private String divIdOutter;

	private String inputId;

	private String divIdInner;

	private int width = 0;

	private String onblur;

	private String name;

	private String value;

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

	private String onselect;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		String outString = buildText();
		try {
			out.println(outString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	/**
	 * buildText() method builds the string necessary which is can be used to
	 * diplay the autocomplete Text Box. Text entered in text box is put into
	 * user session cache getting the cache instance from CacheManager. For next
	 * visit text wiil be picked up from cache.
	 * 
	 * @return outputString
	 */
	public String buildText() {
		StringBuffer outputString = new StringBuffer();
		try {

			StringBuffer appendBlurEvent = new StringBuffer("addToCache('"
					+ getInputId() + "');");
			if (getOnblur() != null) {
				appendBlurEvent.append(getOnblur());
			}
			StringBuffer appendEvents = appendEvevnts();
			StringBuffer buffer = new StringBuffer();

			Cache cache = CacheManager.getCache();
			String key = "";
			key = "AutoList" + getInputId();
			ArrayList cacheList = new ArrayList();
			if (cache.exists(Constants.USER_SESSION_CACHE, key)) {
				cacheList = (ArrayList) cache.getObject(
						Constants.USER_SESSION_CACHE, key);
				if (!cacheList.isEmpty()) {
					int sizeVal=cacheList.size();
					for (int i = 0; i < sizeVal; i++) {
						buffer.append(",\"" + cacheList.get(i).toString()
								+ "\"");
					}
				}
			} else {
				cache.putObject(Constants.USER_SESSION_CACHE, key, cacheList);
			}
			outputString.append("<div id=\"" + getDivIdOutter() + getInputId()
					+ "\">");
			if (getWidth() == 0) {
				if (!(appendEvents.equals(""))) {
					outputString.append("<input type=\"text\" id=\""
							+ getInputId() + "\" onblur=\"" + appendBlurEvent
							+ "\" class=\"yui-ac-input\" name=\"" + getName()
							+ "\" " + appendEvents
							+ "style='width:15em;'></input>");
				} else {
					outputString.append("<input type=\"text\" id=\""
							+ getInputId() + "\" onblur=\"" + appendBlurEvent
							+ "\" class=\"yui-ac-input\" name=\"" + getName()
							+ "\" " + appendEvents
							+ "style='width:15em;'></input>");
				}
			} else {
				if (!(appendEvents.equals(""))) {
					outputString.append("<input type=\"text\" id=\""
							+ getInputId() + "\" onblur=\"" + appendBlurEvent
							+ "\" class=\"yui-ac-input\" name=\"" + getName()
							+ "\" " + appendEvents + "style='width:"
							+ getWidth() + "em;'></input>");
				} else {
					outputString.append("<input type=\"text\" id=\""
							+ getInputId() + "\" onblur=\"" + appendBlurEvent
							+ "\" class=\"yui-ac-input\" name=\"" + getName()
							+ "\" " + appendEvents + "style='width:"
							+ getWidth() + "em;'></input>");
				}
			}

			outputString.append("<div id=\"" + getDivIdInner() + getInputId()
					+ "\"/ >");
			outputString.append("</div>");

			outputString.append("<script type=\"text/javascript\"> \n"
					+ "var displayArray" + getInputId() + " = [" + buffer
					+ "];");

			outputString.append("</script>");
			outputString
					.append("<script type=\"text/javascript\"> \n"
							+ "YAHOO.example.ACJSArray = function() {"
							+ "var oACDS;var oAutoComp;return {init: function() {oACDS = new YAHOO.widget.DS_JSArray(displayArray"
							+ getInputId()
							+ ");"
							+ "oAutoComp = new YAHOO.widget.AutoComplete('"
							+ getInputId()
							+ "','"
							+ (getDivIdInner() + getInputId())
							+ "', oACDS);"
							+ "oAutoComp.queryDelay = 0;oAutoComp.prehighlightClassName = \"yui-ac-prehighlight\";oAutoComp.typeAhead = true;},"
							+ "validateForm: function() {return false;}};}();YAHOO.util.Event.addListener(this,'load',YAHOO.example.ACJSArray.init);");
			outputString.append("</script>");

			outputString.append("</script>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputString.toString();
	}

	/**
	 * appendEvevnts() method appends the events specified for any respective
	 * Text box.
	 * 
	 * @return appendEvent
	 */
	public StringBuffer appendEvevnts() {

		StringBuffer appendEvent = new StringBuffer();

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
	 * gets the id for the text box.
	 * 
	 * @return inputId
	 */
	public String getInputId() {
		return inputId;
	}

	/**
	 * sets the id for the text box.
	 * 
	 * @param inputId
	 */
	public void setInputId(String inputId) {
		this.inputId = inputId;
	}

	/**
	 * gets the inner div's id for the text box.
	 * 
	 * @return divIdInner
	 */
	public String getDivIdInner() {
		return divIdInner;
	}

	/**
	 * sets the inner div's id for the text box.
	 * 
	 * @param divIdInner
	 */
	public void setDivIdInner(String divIdInner) {
		this.divIdInner = divIdInner;
	}

	/**
	 * gets the outer div's id for the text box.
	 * 
	 * @return divIdOutter
	 */
	public String getDivIdOutter() {
		return divIdOutter;
	}

	/**
	 * sets the outer div's id for the text box.
	 * 
	 * @param divIdOutter
	 */
	public void setDivIdOutter(String divIdOutter) {
		this.divIdOutter = divIdOutter;
	}

	/**
	 * gets the width of text box.
	 * 
	 * @return width
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * sets the width of text box.
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * gets the name of text box.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of text box.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the value of text box.
	 * 
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * sets the value of text box.
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * gets the onblur event for text box.
	 * 
	 * @return onblur
	 */
	public String getOnblur() {
		return onblur;
	}

	/**
	 * sets the onblur event for text box.
	 * 
	 * @param onblur
	 */
	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	/**
	 * gets the onchange event for text box.
	 * 
	 * @return onchange
	 */
	public String getOnchange() {
		return onchange;
	}

	/**
	 * sets the onchange event for text box.
	 * 
	 * @param onchange
	 */
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	/**
	 * gets the onclick event for text box.
	 * 
	 * @return onclick
	 */
	public String getOnclick() {
		return onclick;
	}

	/**
	 * sets the onclick event for text box.
	 * 
	 * @param onclick
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	/**
	 * gets the onfocus event for text box.
	 * 
	 * @return onfocus
	 */
	public String getOnfocus() {
		return onfocus;
	}

	/**
	 * sets the onfocus event for text box.
	 * 
	 * @param onfocus
	 */
	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	/**
	 * gets the onkeydown event for text box.
	 * 
	 * @return onkeydown
	 */
	public String getOnkeydown() {
		return onkeydown;
	}

	/**
	 * sets the onkeydown event for text box.
	 * 
	 * @param onkeydown
	 */
	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	/**
	 * gets the onkeypress event for text box.
	 * 
	 * @return onkeypress
	 */
	public String getOnkeypress() {
		return onkeypress;
	}

	/**
	 * sets the onkeypress event for text box.
	 * 
	 * @param onkeypress
	 */
	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	/**
	 * gets the onkeyup event for text box.
	 * 
	 * @return onkeyup
	 */
	public String getOnkeyup() {
		return onkeyup;
	}

	/**
	 * sets the onkeyup event for text box.
	 * 
	 * @param onkeyup
	 */
	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	/**
	 * gets the onmousedown event for text box.
	 * 
	 * @return onmousedown
	 */
	public String getOnmousedown() {
		return onmousedown;
	}

	/**
	 * sets the onmousedown event for text box.
	 * 
	 * @param onmousedown
	 */
	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	/**
	 * gets the onmousemove event for text box.
	 * 
	 * @return onmousemove
	 */
	public String getOnmousemove() {
		return onmousemove;
	}

	/**
	 * sets the onmousemove event for text box.
	 * 
	 * @param onmousemove
	 */
	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	/**
	 * gets the onmouseout event for text box.
	 * 
	 * @return onmouseout
	 */
	public String getOnmouseout() {
		return onmouseout;
	}

	/**
	 * sets the onmouseout event for text box.
	 * 
	 * @param onmouseout
	 */
	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	/**
	 * gets the onmouseover event for text box.
	 * 
	 * @return onmouseover
	 */
	public String getOnmouseover() {
		return onmouseover;
	}

	/**
	 * sets the onmousemover event for text box.
	 * 
	 * @param onmouseover
	 */
	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	/**
	 * gets the onmouseup event for text box.
	 * 
	 * @return onmouseup
	 */
	public String getOnmouseup() {
		return onmouseup;
	}

	/**
	 * sets the onmouseup event for text box.
	 * 
	 * @param onmouseup
	 */
	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	/**
	 * gets the onselect event for text box.
	 * 
	 * @return onselect
	 */
	public String getOnselect() {
		return onselect;
	}

	/**
	 * sets the onselect event for text box.
	 * 
	 * @param onselect
	 */
	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}
}
