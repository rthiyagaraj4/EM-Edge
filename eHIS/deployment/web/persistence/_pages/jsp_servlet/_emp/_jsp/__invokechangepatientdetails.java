package jsp_servlet._emp._jsp;

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

public final class __invokechangepatientdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/InvokeChangePatientDetails.jsp", 1709118626135L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>  \n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body >\n</body>\n<script>\t\n\t if(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' == \'CHG_PAT_DTLS\'){\n\t\twindow.open(\'../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&module_id=MP&function_name=Change Patient Details&function_type=F&access=NYNNN&function_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&home_required_yn=N&Patient_ID=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'eHIS\',\'location=0,height=700,width=1050,top=0,left=0,resizable=yes\');\n\t }else  if(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' == \'PAT_SEARCH\'){\n\t\tvar p_ses_id = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\t\t\n\t\tpat_id=PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'Y\',\'Visitreg\');\t\t\n\t\tif(pat_id!=null){\n\t\t\tpatFlag=pat_id.charAt(0);\t\t\t\n\t\tif(patFlag == \'Y\'){\n\t\t\tvar patientid=pat_id.substring(1,pat_id.length);\n\t\t\tlocation.href =\'../../eMP/jsp/InsertPatientDetails.jsp?pat_id=\'+escape(patientid)+\'&p_ses_id=\'+p_ses_id;\n\t\t  }else if(pat_id!=\"\") { \n\t\t\t  location.href =\'../../eMP/jsp/InsertPatientDetails.jsp?pat_id=\'+escape(pat_id)+\'&p_ses_id=\'+p_ses_id;\n\t\t  }\n\t\t}\n\t }\n</script>\n\t\t   \n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt=null; 
ResultSet rset =null;
ResultSet rs =null;
String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where APPL_USER_ID=? and APPL_USER_PASSWORD=? ";
PreparedStatement pstmtValidUser = null;
String client_ip_address = request.getRemoteAddr();
String jdbc_props = "";
String direct_facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
String p_ses_id = request.getParameter("p_session_id") == null ? "" : request.getParameter("p_session_id");
String direct_resp_id = request.getParameter("responsibility_id") == null ? "" : request.getParameter("responsibility_id");
String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String direct_login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");
String direct_login_pwd = request.getParameter("login_pwd") == null ? "" : request.getParameter("login_pwd");
String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
String preferred_style="",facility_name="";	
String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
session.putValue("responsibility_id",direct_resp_id);
session.putValue("facility_id",direct_facility_id);
session.putValue("login_user",direct_login_user);
session.putValue("connection_pooling_yn","Y");
session.putValue("LOCALE",locale);
session.putValue("mp_bl_oper_yn","Y");
Properties p = new Properties() ;
p.setProperty( "login_user",direct_login_user ) ;
p.setProperty("connection_pooling_yn","Y") ;
p.setProperty("client_ip_address",client_ip_address) ;
p.setProperty("jdbc_props",jdbc_props) ;
p.setProperty("LOCALE",locale) ;
session.putValue( "jdbc",p ) ;
	try
		{
		con =  ConnectionManager.getConnection(request);
		pstmtValidUser = con.prepareStatement(strSqlValidUser);
		pstmtValidUser.setString(1,direct_facility_id);
		pstmtValidUser.setString(2,direct_login_user.trim());
		pstmtValidUser.setString(3,direct_login_pwd.trim());
		rset = pstmtValidUser.executeQuery();
		if(rset !=null && rset.next())
			{
			preferred_style = rset.getString("preferred_style");
			facility_name = rset.getString("facility_name");
			if(facility_name == null || facility_name.equals(""))
            facility_name = "";
		    if(preferred_style == null || preferred_style.equals(""))
            preferred_style = "IeStyle.css";
			session.setAttribute("PREFERRED_STYLE",preferred_style);
			session.putValue("facility_name",facility_name);
			rset.close();
			pstmtValidUser.close();
			}
		}
	catch(Exception e2)	
		{
		System.out.println("Exception occurred while getting the PREFERRED_STYLE details : "+e2);
		e2.printStackTrace();
		}		
	try 
		{
		pstmt = con.prepareStatement( "select install_yn bl_install_yn,(select operational_yn from sm_modules_facility where module_id='BL' and facility_id =?) operational_yn from sm_module where module_id='BL'" ) ;
		pstmt.setString( 1, direct_facility_id ) ;
		rs = pstmt.executeQuery() ;
		if ( rs != null && rs.next() ) 
			{
			String bl_install_yn = rs.getString("bl_install_yn") == null ? "N": rs.getString("bl_install_yn");
			String operational_yn = rs.getString("operational_yn") == null ? "N": rs.getString("operational_yn");
			if(bl_install_yn.equals("Y") && operational_yn.equals("Y"))
				{
				session.putValue("mp_bl_oper_yn", "Y");
				}
			else
				{
				session.putValue("mp_bl_oper_yn", "N");
				}
			}
		rs.close();	
		pstmt.close();
		}
	catch(Exception e1)	
		{
		System.out.println("Exception occurred while getting the billing details : "+e1);
		e1.printStackTrace();
		}
	try
		{
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
		}
	catch(Exception  e)	{}
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_ses_id));
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
