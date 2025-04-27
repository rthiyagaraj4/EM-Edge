package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;

public final class __swabcountreportoption extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SwabCountReportOption.jsp", 1709120398000L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head><title></title>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n<script src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\"../../eOT/js/OtReports.js\" ></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n\t<input type=\"hidden\" name=\"p_user_id\" id=\"p_user_id\"\tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t<input type=\"hidden\" name=\"p_oper_num\" id=\"p_oper_num\"\tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t<input type=\"hidden\" name=\"p_patient_id\" id=\"p_patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \tvalue=\"OT\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"\tvalue=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<input type=\"hidden\" name=\"P_NO_OF_SWAB_COUNT\" id=\"P_NO_OF_SWAB_COUNT\"\tvalue=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n</form>\n</body>\n</html>\n<script>\n\tCaseSlipRun();\n</script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_id = (String)session.getValue("facility_id");
	String slate_user_id	= request.getParameter("slate_user_id");
	String oper_num		= request.getParameter("oper_num");	
	String patient_id		= request.getParameter("patient_id");	
	String pReportId = request.getParameter("p_report_id");
	String pNoOfSwabCount = request.getParameter("P_NO_OF_SWAB_COUNT");
	System.out.println("===pReportId==="+pReportId);
	System.out.println("===pNoOfSwabCount==="+pNoOfSwabCount);
	if(facility_id == null) facility_id="";
	if(slate_user_id == null) slate_user_id="";
	if(oper_num == null) oper_num="";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(pReportId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(pNoOfSwabCount));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
