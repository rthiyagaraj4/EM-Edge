/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v2.9.9.61 Copyright 2000 Atanas Neshkov  Date: 6/3/2009 9:50:16 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   CalandarConfigTag.java

package com.iba.framework.core.pojo.web.taglib;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public final class CalandarConfigTag extends TagSupport
{

    public CalandarConfigTag()
    {
    }

    public int doStartTag()
    {
        HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
        HttpSession httpSession = req.getSession();
        String locale = httpSession.getAttribute("LOCALE") == null ? "en" : (String)httpSession.getAttribute("LOCALE");
        contextPath = req.getContextPath();
        JspWriter out = pageContext.getOut();
        try
        {
            out.println((new StringBuilder("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"")).append(contextPath).append("/framework/css/calendar-system.css\" title=\"system\" />").toString());
            out.println((new StringBuilder("<script language=\"javascript\" src=\"")).append(contextPath).append("/framework/js/PopupWindow.js\"></script>").toString());
            out.println((new StringBuilder("<script language=\"javascript\" src=\"")).append(contextPath).append("/framework/js/IbaScripts.js\"></script>").toString());
            out.println((new StringBuilder("<script language=\"javascript\" src=\"")).append(contextPath).append("/framework/js/calendar").append(locale).append(".js\"></script>").toString());
            out.println((new StringBuilder("<script language=\"javascript\" src=\"")).append(contextPath).append("/framework/js/lang/calendar-").append(locale).append(".js\"></script>").toString());
            out.println((new StringBuilder("<script language=\"javascript\" src=\"")).append(contextPath).append("/framework/js/calendar-setup.js\"></script>").toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return 1;
    }

    private String contextPath;
}
