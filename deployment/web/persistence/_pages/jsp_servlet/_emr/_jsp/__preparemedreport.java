package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __preparemedreport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/PrepareMedReport.jsp", 1709119009005L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language =\'javascript\' src=\'../../eMR/js/PrepareMedReport.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\t\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<frameset rows=\'0%,50%,50%,0%\'>\n\t\t<frame name=\'tool\' id=\'tool\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize>\n\t\t<!-- <frame name=\'criteriaFrame\' id=\'criteriaFrame\' \tsrc=\'../jsp/ReportRequestQueryCriteria.jsp?call_function=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&function_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&called_from=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&patientid=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0 scrolling=\'no\' noresize> --> <!--  commented for ML-MMOH-CRF-0388 - IN057153 -->\n\t\t<frame name=\'criteriaFrame\' id=\'criteriaFrame\' \tsrc=\'../jsp/ReportRequestQueryCriteria.jsp?call_function=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&result_def_frm_ca=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&sum_comp_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nav_menu_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' frameborder=0 scrolling=\'no\' noresize> <!--  modified for ML-MMOH-CRF-0388 - IN057153 -->\n\t\t<frame name=\'resultFrame\' id=\'resultFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize>\n\t\t<frame name=\'messageFrame\' id=\'messageFrame\'\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\' noresize>\n\t</frameset>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<frameset rows=\'8%,45%,*,8%\'>\n\t\t<frame name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" frameborder=0 scrolling=\'no\' noresize>\n\t\t<frame name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\'../jsp/ReportRequestQueryCriteria.jsp?call_function=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=0 scrolling=\'no\' noresize>\n\t\t<frame name=\'result\' id=\'result\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize>\n\t\t<frame name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'no\' noresize>\n\t</frameset>\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	 request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;	
	String source = url + params ;
	String function_id=request.getParameter("function_id");

	//Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701
	String sum_comp_id	= checkForNull(request.getParameter("sum_comp_id"));

	//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331
	String nav_menu_id = checkForNull(request.getParameter("nav_menu_id"));

	String called_from=request.getParameter("called_from");
		if(called_from == null) called_from = "";
	if(called_from.equals("CA")) 
		function_id = "PREPARE_MEDICAL_REPORT";

	String patientid = request.getParameter("patient_id");
		if(patientid == null) patientid = "";

	String result_def_frm_ca = 	request.getParameter("result_def_frm_ca") == null?"":request.getParameter("result_def_frm_ca"); //ML-MMOH-CRF-0388 - IN057153
if(called_from.equals("CA")) 
{	
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(result_def_frm_ca));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sum_comp_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nav_menu_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
	else{	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(source));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block15Bytes, _wl_block15);
	}	
            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
