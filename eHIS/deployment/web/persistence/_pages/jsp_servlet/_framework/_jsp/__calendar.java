package jsp_servlet._framework._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __calendar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/framework/jsp/Calendar.jsp", 1709122576675L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n \n<html>\n    <title>Calendar</title>\n    <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"../../framework/css/calendar-system.css\" title=\"system\" />\t\t\n    ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n  <head>\n  </head>\n  \n <body>\n ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<TABLE align=\"center\" >\n\t\t<TR>\n\t\t<TD>\n\t\t<div id=\"calendar-container\"></div>\n\t\t</TD>\n\t\t</TR>\n\t\t</table>\n\t</body>\n\n\t<script type=\"text/javascript\">\n\t \n\t\t  function dateChanged(calendar) { \n\t\t     // Beware that this function is called even if the end-user only\n\t\t    // changed the month/year.  In order to determine if a date was\n\t\t    // clicked you can use the dateClicked property of the calendar:\n\t\t    if (calendar.dateClicked) {\n\t\t      // OK, a date was clicked, redirect to /yyyy/mm/dd/index.php  \n\t\t\t  \n\t\t\t  var y = calendar.date.getFullYear();\n\t\t      var m = calendar.date.getMonth();     // integer, 0..11\n\t\t      var d = calendar.date.getDate();      // indbgl-gw02, 1..31\n\t\t      var date = calendar.date;\n\t\t\t  var time = date.getTime();\n       \t\t  var date2 = new Date(time);\n\t\t\t  var locale = \'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\';\n\t\t\t  formattedDate=date2.print(window.opener.calend);\n\t\t\tvar dateToDisplay = formattedDate.substring(0, 10);\n\t\t\tvar timeToDisplay = formattedDate.substring(11, 16);\n\t\t\t  if(locale == \'th\')\n\t\t\t  {\n\t\t\t\t\tformattedDate = selected(calendar, dateToDisplay, \'%d/%m/%Y\');\n\t\t\t\t\tvar id=window.opener.calend;\n\t\t\t\t\twindow.opener.currentDateElement.value=formattedDate + \" \" + timeToDisplay;\n\t\t\t  }\n\t\t\t  else\n\t\t\t  {\n\t\t\t\twindow.opener.currentDateElement.value=date2.print(window.opener.calend);\n\t\t\t  }\n\t\t\t // redirect...\n\t\t      window.close();\n\t\t      //window.location = \"/\" + y + \"/\" + m + \"/\" + d + \"/index.php\";\n\t\t    }\n\t\t  };\n\t\t  Calendar.setup(\n\t\t    {\n\t\t      flat         : \"calendar-container\", // ID of the parent element\n\t\t      flatCallback :  dateChanged,          // our callback function\n\t\t      ifFormat     :    window.opener.calend,\n\t\t      showsTime    :    window.opener.time,\n\t   \t\t  timeFormat   :    \"24\",\n\t   \t\t  value \t   :\twindow.opener.currentDateElement.value,\n\t   \t\t  weekNumbers  : true\n\t   \t\t}\n\t\t  );\n\t\t \t\t \n\t\t window.focus();\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);

  String locale = (String) session.getAttribute("LOCALE");
  //out.println("LOC"+locale);
  
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         com.iba.framework.core.pojo.web.taglib.CalandarConfigTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  com.iba.framework.core.pojo.web.taglib.CalandarConfigTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class com.iba.framework.core.pojo.web.taglib.CalandarConfigTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
