package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __termcodeconsultation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/emr/jsp/TermCodeConsultation.jsp", 1709119100864L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n function Call() {\n\t parent.frames[1].location.href=\'TermCodeCustomList.jsp?";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'\n }\n\n function CallSearch() {\n \t parent.frames[1].location.href=\'TermCodeSearchProblem.jsp?";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'\n }\n\n function CallSelect() {\n\t \t parent.frames[1].location.href=\'TermCodeSearchScreenFrmes.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n }\n\n var currentTab = new String();\n currentTab = \"demogrp_tab\";\n\n function tab_click(objName) {\n \t\t// FIRST CHANGE THE CURRENT SELECTED TAB\n \t\tchangeTab(objName);\n/*\n \t\tif (objName == \'demogrp_tab\')\n \t\t\tparent.group_head.moveToTab(1);\n \t\telse if (objName == \'cmodeaddr_tab\')\n \t\t\tparent.group_head.moveToTab(2);\n \t\telse if (objName == \'rlcnts_tab\')\n \t\t\tparent.group_head.moveToTab(3);\n\n*/\n}\n\nfunction changeTab(TabName)\t{\n\t// RESET THE OLD TAB WHICH IS SELECTED FIRST .............\n\t\t if (currentTab == \'demogrp_tab\')\n\t\t\tdocument.getElementById(\"demogrp_tab\").src = \'../../eCA/images/Custom List_click.gif\';\n\t\telse if (currentTab == \'cmodeaddr_tab\')\n\t\t\tdocument.getElementById(\"cmodeaddr_tab\").src = \'../../eCA/images/Search_click.gif\';\n\t\telse if (currentTab == \'rlcnts_tab\')\n\t\t\tdocument.getElementById(\"rlcnts_tab\").src = \'../../eCA/images/Select_click.gif\';\n\n\n\t// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............\n\n\t\tif (TabName == \'demogrp_tab\')\n\t\t\tdocument.getElementById(\"demogrp_tab\").src = \'../../eCA/images/Custom_List.gif\';\n\t\telse if (TabName == \'cmodeaddr_tab\')\n\t\t\tdocument.getElementById(\"cmodeaddr_tab\").src = \'../../eCA/images/Search.gif\';\n\t\telse if (TabName == \'rlcnts_tab\')\n\t\t\tdocument.getElementById(\"rlcnts_tab\").src = \'../../eCA/images/Select.gif\';\n\n\n\t// FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER\n\t\tcurrentTab = TabName;\n}\n\n</script>\n\n<body onload=\"tab_click(\'demogrp_tab\')\" onKeyDown=\'lockKey()\'>\n <table  width=\'100%\' cellspacing=\'0%\' cellpadding=\'0%\'>\n<tr>\n<td align=\'left\' class=\'BODYCOLORFILLED\'>\n<a href=\t\"javascript:tab_click(\'demogrp_tab\')\" alt=\'Custom List\'><img name=\'demogrp_tab\' border=\'0\' src=\'../../eCA/images/Custom List_click.gif\' alt=\'Custom List\' onClick=\'Call(this)\'></img></a>\n\n<a href=\"javascript:tab_click(\'cmodeaddr_tab\')\" alt=\'Search\' ><img name=\'cmodeaddr_tab\' border=\'0\' src=\'../../eCA/images/Search_click.gif\' alt=\'Search\' onclick=\'CallSearch(this)\'></img></a>\n\n<a href=\"javascript:tab_click(\'rlcnts_tab\')\" alt=\'Select\'><img name=\'rlcnts_tab\' border=\'0\' src=\'../../eCA/images/Select_click.gif\'  onclick=\'CallSelect(this)\' alt=\'Select\'></img></a>\n\n</tr>\n</table>\n\n</BODY>\n</html>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
