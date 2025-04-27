package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __report_process extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/report_process.jsp", 1736416821888L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="<head>\n  ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\' />\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n    <script src=\"../../eCommon/js/common.js\"></script>\n    <script language=\"JavaScript\">\n\t\tvar outputWindow;\n        function onFormLoad() {\n            window.document.title = \'eHIS\' ;\n        }\n\n        function openReport( reportURL ) {\n            if ( reportURL != null ) {\n                var closeWindow = report_process_form.closeWindow.value ;\n                var myBars      = \'directories=no,location=no,menubar=no,status=no\' ;\n                var myOptions   = \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=yes\' ;\n                var myFeatures  = myBars + \', \' + myOptions ;\n\n                if ( closeWindow == \"true\" ) {\n                    var index = reportURL.indexOf( \"&closeWindow=true\" ) ;\n                    reportURL = reportURL.substring( 0, index ) ;\n                }\n\n// By sbchand start on 29th June 2002\n//              var outputWindow    = open( reportURL, \'_blank\', myFeatures ) ;\n                outputWindow    = open( reportURL, \'_self\', myFeatures ) ;\n// By sbchand end on 29th June 2002\n\n                outputWindow.title= \"Medicom Report Viewer\" ;\n                outputWindow.resizeTo( screen.availWidth, screen.availHeight ) ;\n                outputWindow.moveTo( 0,0 ) ;\n                outputWindow.focus() ;\n\n                if ( closeWindow == \"true\" ) { \n\t\t\t\t\tsetTimeout(\'callclose()\',3000);\n\t\t\t\t\t//outputWindow.close() ;\n                    //window.close() ;\n                }\n            }\n        }\nfunction callclose()\n{\n\toutputWindow.close() ;\n    window.close() ;\n\n}\n    </script>\n</head>\n\n<body onLoad=\"onFormLoad();\" OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<form name=\"report_process_form\" id=\"report_process_form\">\n<input type=\"hidden\" name=\"closeWindow\" id=\"closeWindow\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n</form>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n</body>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		request.setCharacterEncoding("UTF-8");	
    String params       = request.getQueryString() ;
   //39764 - START
    if(params.contains("*"))
    	params = params.replaceAll("\\*","");
   //39764 - END
    String closeWindow  = request.getParameter( "closeWindow" ) ;
    String des_spreadsheetYN  = request.getParameter( "desformat" ) ;

	if ( closeWindow == null ) closeWindow = "false" ;

    if ( closeWindow.equalsIgnoreCase( "true" ) ) {
        out.println( "<script language='JavaScript'>alert(getMessage('REPORT_SUBMIT_SERVER','Common') ) ;</script>" ) ;
    } else {
        out.println( "<table align='center'>" ) ;
        out.println( "<tr height=500>" ) ;
        out.println( "<td align='center'>" ) ;

        out.println( "Processing Report.  Please Wait...<br><br>" ) ;
		out.println( "<input type='button' align='center' name='Cancel' id='Cancel' onClick='window.close()' class='button' value='Cancel'>" ) ;

        //out.println( "<img src='../images/BBcancel.gif' alt='Cancel' onClick='window.close()'>" ) ;

        out.println( "</td>" ) ;
        out.println( "</tr>" ) ;
        out.println( "</table>" ) ;
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( closeWindow ));
            _bw.write(_wl_block6Bytes, _wl_block6);

    if ( params != null ) {
        out.println( "<script language=\"JavaScript\">openReport(\"" + params + "\")</script>" ) ;
        out.println( "<script language=\"JavaScript\">onFormLoad();</script>" ) ;
    }

            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
