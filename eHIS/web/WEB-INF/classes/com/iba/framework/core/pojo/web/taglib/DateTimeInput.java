/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v2.9.9.61 Copyright 2000 Atanas Neshkov  Date: 6/3/2009 9:50:05 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DateTimeInput.java

package com.iba.framework.core.pojo.web.taglib;

import com.iba.framework.cache.pojo.business.Cache;
import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.framework.core.exception.DataNotFoundException;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.Logger;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.TextTag;

public class DateTimeInput extends TextTag
{

    public DateTimeInput()
    {
        format = null;
        pattern = null;
        isString = "false";
        timeDisp = false;
        dateformat_map = new HashMap();
        timeformat_map = new HashMap();
        dateformat_map.put("dd/MM/yyyy", "%d/%m/%Y");
        dateformat_map.put("dd/MM/yy", "%d/%m/%y");
        dateformat_map.put("dd/MMM/yyyy", "%d/%b/%Y");
        dateformat_map.put("dd/MMM/yy", "%d/%b/%y");
        dateformat_map.put("MM/dd/yyyy", "%m/%d/%Y");
        dateformat_map.put("MM/dd/yy", "%m/%d/%y");
        dateformat_map.put("MMM/dd/yyyy", "%b/%d/%Y");
        dateformat_map.put("MMM/dd/yy", "%b/%d/%y");
        dateformat_map.put("yyyy/MM/dd", "%Y/%m/%d");
        dateformat_map.put("yy/MM/dd", "%y/%m/%d");
        dateformat_map.put("yyyy/MMM/dd", "%Y/%b/%d");
        dateformat_map.put("yy/MMM/dd", "%y/%b/%d");
        timeformat_map.put("hh:mm", "%H:%M");
        timeformat_map.put("hh:mm:ss", "%H:%M:%S");
    }

    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    public int doStartTag()
        throws JspException
    {
        StringBuffer blurBuffer = new StringBuffer();
        if(getOnblur() != null)
            blurBuffer.append(getOnblur());
        if(format == null)
        {
            format = "%d/%m/%Y";
            blurBuffer.append(";if(this.value!='')IBADateValidator.validateDateJS(this.value,'dd/MM/yyyy',isDatevalid);");
        }
        if(format.indexOf('H') != -1)
        {
            timeDisp = true;
            blurBuffer.append((new StringBuilder(";if(this.value!='')IBADateValidator.validateDateJS(this.value,'")).append(format).append("',isDatevalid);").toString());
        }
        if(format != null)
        {
            timeDisp = true;
            blurBuffer.append((new StringBuilder(";if(this.value!='')IBADateValidator.validateDateJS(this.value,'")).append(format).append("',isDatevalid);").toString());
        }
        setOnblur(blurBuffer.toString());
        if(getOnkeypress() != null)
            setOnkeypress((new StringBuilder(String.valueOf(getOnkeypress()))).append(";assignDate(this,false);").toString());
        else
            setOnkeypress("assignDate(this,false);");
        if(getOnkeydown() != null)
            setOnkeydown((new StringBuilder(String.valueOf(getOnkeydown()))).append(";assignDate(this,false);").toString());
        else
            setOnkeydown("assignDate(this,false);");
        return super.doStartTag();
    }

    public synchronized int doEndTag()
        throws JspException
    {
        StringBuffer dataBuffer = new StringBuffer();
        HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
        contextPath = req.getContextPath();
        //UserPreferences userPrefs = null;
		UserPreferences userPrefs = new UserPreferences();
		//AMRI-SCF-0679
		userPrefs.setDateFormat("dd/MM/yyyy") ;
		userPrefs.setTimeFormat("HH:mm");
		userPrefs.setLocale("en");
		//AMRI-SCF-0679
        /* Cache cache = CacheManager.getCache();
        try
        {
            userPrefs = (UserPreferences)cache.getObject("US", pageContext.getSession().getId(), "user_prefs");
        }
        catch(DataNotFoundException datanotfoundexception) { } */ //AMRI-SCF-0679
        if(format == null)
            format = "dd/MM/yyyy";
        if(userPrefs != null)
        {
            String dateFormat = userPrefs.getDateFormat();
            String timeFormat = userPrefs.getTimeFormat();
            IBALogger.getLogger().debug(getClass(), (new StringBuilder("format=========>")).append(format).toString(), null);
            if(format != null && format.indexOf("h") != -1)
                format = (new StringBuilder(String.valueOf(dateFormat))).append(" ").append(timeFormat).toString();
            pattern = (String)dateformat_map.get(dateFormat);
            IBALogger.getLogger().debug(getClass(), (new StringBuilder("this.pattern========== = ")).append(pattern).toString(), null);
            if(format.indexOf('h') != -1)
            {
                timeDisp = true;
                String timePattern = (String)timeformat_map.get(timeFormat);
                pattern = (new StringBuilder(String.valueOf(pattern))).append(" ").append(timePattern).toString();
            }
        }
        int endReturn = super.doEndTag();
        dataBuffer.append((new StringBuilder("<a onclick=\"return showCal('")).append(getProperty()).append("', '").append(pattern).append("', ").append(timeDisp).append(", true,'").append(getProperty().substring(getProperty().lastIndexOf('.') + 1, getProperty().length())).append("id');\" name='").append(getProperty().substring(getProperty().lastIndexOf('.'), getProperty().length())).append("id' id='").append(getProperty().substring(getProperty().lastIndexOf('.') + 1, getProperty().length())).append("id'><img src=\"").append(contextPath).append("/framework/images/img.gif\"></a>").toString());
        if(getIsString().equals("false"))
        {
            if(getIsString().equals("false"))
                dataBuffer.append((new StringBuilder("<input type='hidden' name='")).append(getProperty()).append(".pattern' value='").append(format).append("'>").toString());
            TagUtils.getInstance().write(super.pageContext, dataBuffer.toString());
        }
        return endReturn;
    }

    public String getIsString()
    {
        return isString;
    }

    public void setIsString(String isString)
    {
        this.isString = isString;
    }

    private String format;
    private String pattern;
    private String contextPath;
    private String isString;
    boolean timeDisp;
    HashMap dateformat_map;
    HashMap timeformat_map;
}
