package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __em_scanner_head extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EM_Scanner_Head.jsp", 1709115196903L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<title>Scan Documents</title>\n</head>\n<body>\n\t<table align=\"center\" border=\"4\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 700px;\">\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<!--<applet code=\"ScannerApplet.class\" codebase=\"../Scanner/\" archive=\"EMScanner.jar, JTwain.jar\" width=\"400\" height=\"300\">-->\n\t\t\t\t<!--<applet code=\"ScanImageApplet.class\" codebase=\"../Scanner/\" archive=\"ScanImageDemo.jar, JTwain.jar\" width=\"800\" height=\"600\">-->\n\t\t\t\t<applet code=\"ScanImageApplet.class\" codebase=\"../Scanner/\" archive=\"ScanPatientDocument.jar, JTwain.jar\" width=\"700\" height=\"400\">\n\t\t\t\t<PARAM name=\"servletPath\" value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n\t\t\t\t<PARAM name=\"facility_id\" value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n\t\t\t\t<PARAM name=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t\t\t\t<PARAM name=\"patient_id\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t\t\t\t Sorry, Your browser does not support Java applet!\n\t\t\t\t</applet>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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

	System.out.println(" - - -  Inside EM_Scanner_Head.jsp  - - - ");

	String appPath = request.getRequestURL().toString();
	String contextPath = request.getContextPath();

	appPath = appPath.substring(0,appPath.indexOf(contextPath)+contextPath.length());

	String facilityId = "", patientid = "", encounterid = "";

	facilityId	= (String)session.getValue("facility_id");
	patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

	System.out.println(" - - - patient_id - - - "+patientid+" - - - encounterid - - - "+encounterid);

	//session.getServletContext().getRealPath("/");

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(appPath));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
