package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __invokemanagepatientpackagewrapper extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/InvokeManagePatientPackageWrapper.jsp", 1709114667882L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident             SCF/CRF             Developer Name\n--------------------------------------------------------------------------------------\n1\t\t\tV230106\t\t\t\t36652\t\t\tTH-KW-CRF-0145.1\t\t\tMohanapriya\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE></TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\tfunction openMPP(){\n\t\t var ie7 = (document.all && !window.opera && window.XMLHttpRequest) ? true : false;  \n\t     if (ie7) \n\t\t {\n\t\t\t   //This method is required to close a window without any prompt for IE7/IE8\n\t\t\t   window.open(\'\',\'_parent\',\'\');\n\t\t\t   window.close();\n           }\n\t\t   else \n           {\n\t\t\t   //This method is required to close a window without any prompt for IE6\n\t\t\t   this.focus();\n\t\t\t   self.opener = this;\n\t\t\t   self.close();\n           }\n\n\t\tvar  screenHeight=screen.height;\n\t\tvar  screenWidth=screen.width;\n\t\tvar features =\"location=0,height=\"+screenHeight+\",width=\"+screenWidth+\",top=0,left=0,resizable=yes\";\n\t\twindow.open(\'../../eBL/jsp/InvokeManagePatientPackage.jsp?patient_id=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="&mode=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&facility_id=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&responsibility_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&login_user=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&login_pwd=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&episode_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&encounter_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&locale=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&function_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&calledFrom=managePatientPopup\',\'eHIS\',features);\t\n\t\n\t//window.open(\'../../eBL/jsp/InvokeManagePatientPackage.jsp?patient_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'eHIS\',features);\t\n\t}\n\n</script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n</HEAD>\n<BODY onload=\'openMPP();\' onKeyDown=\'lockKey()\'>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

	request.setCharacterEncoding("UTF-8");
	String limit_function_id = request.getParameter("limit_function_id") == null ? "" : request.getParameter("limit_function_id");

	//String queryString = request.getQueryString()== null?"":request.getQueryString();
	String login_id = request.getParameter("p_login_user") == null ? "" : request.getParameter("p_login_user");
	String login_pwd = request.getParameter("p_user_password") == null ? "" : request.getParameter("p_user_password");
	String mode = request.getParameter("mode") == null ? "V" : request.getParameter("mode");
	
	String facility_id = request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
	String resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
	String patient_id = request.getParameter("p_patient_id") == null ? "" : request.getParameter("p_patient_id");

	String encounter_id = request.getParameter("p_encounter_id") == null ? "" : request.getParameter("p_encounter_id");

	String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");


	//String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String function_id = request.getParameter("limit_function_id") == null ? "" : request.getParameter("limit_function_id");
System.out.println("login_id "+login_id+" login_pwd "+login_pwd+" mode "+mode +" facility_id "+facility_id+" patient_id "+patient_id +"encounter_id"+encounter_id);
System.out.println("function_id "+function_id);
	if(locale.equals(""))
	{
		System.out.println("locale value is comming as empty in InvokePatientHistoryWrapper.jsp");
	}

	session.putValue("LOCALE",locale);
	
	

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(login_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(login_pwd));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(login_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(login_pwd));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
