package jsp_servlet._eoa._jsp;

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
import eCommon.XSSRequestWrapper;

public final class __oaapptschedulingextapp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OAApptSchedulingExtApp.jsp", 1718354621493L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\"> -->\n<HTML>\n<HEAD>\n<TITLE></TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\tfunction openHistory(){\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'==\'Y\'){\t\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'==\'true\'){\n\n\t\t\t\t\t\t if (\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' ==\'N\' || \'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' ==\'N\') {\n\t\t\t\t\t\t\t alert(getMessage(\'NO_TRFR_APPT_OPER\',\'OA\'));\n\t\t\t\t\t\t }else if(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'==\'N\'){\n\t\t\t\t\t\t\t alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t\t }else{\n\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' == \'RESCHEDULE\'){\n\t\t\t\t\t\t\t\t\twindow.open(\'../../eOA/jsp/TransferAppointmentFrame.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'eHIS\',\'location=0,height=700,width=1200,top=0,left=0,resizable=yes\');\t\n\n\t\t\t\t\t\t\t\t}else if(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' == \'CANCEL\'){\n\t\t\t\t\t\t\t\t\twindow.open(\'../../eOA/jsp/CancelAppointmentFrame.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'eHIS\',\'location=0,height=700,width=1200,top=0,left=0,resizable=yes\');\t\n\n\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\talert(getMessage(\"NO_OPER_STN_FOR_USER\",\"Common\"));\n\t\t\t\t\t\t}\n\t\t\t\t\t}else{\n\t\t\t\t\t\talert(getMessage(\"INVALID_USER_ID\",\"Common\"));\n\t\t\t\t\t}\n\t\t\t}\n</script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<body onload=\'openHistory()\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</BODY>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

public static String checkForNull(String inputString)
{
	return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
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

Connection con = null;
PreparedStatement pstmtValidUser=null; 
PreparedStatement pstmtResp=null; 
PreparedStatement pstmtApptDtls=null; 
ResultSet rset =null;
ResultSet rsetResp =null;
ResultSet rsetApptDtls =null;
try{

	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String locale = "en";
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");	
	String login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");	
	String functionCall = request.getParameter("functionCall") == null ? "" : request.getParameter("functionCall");	
	String i_appt_ref_no = request.getParameter("i_appt_ref_no") == null ? "" : request.getParameter("i_appt_ref_no");	
	String client_ip_address = "";
	client_ip_address = request.getRemoteAddr();
	String jdbc_props = "";
	String preferred_style = "";
	String facility_name = "";
	 String s = request.getQueryString();
	 String isValidLogin	= "N";
	String oper_stn_id="";
	String currentdate="";
	String canc_appt_yn="";
	String tfr_appt_yn="";
	String book_appt_yn="";
	String tfr_appt_across_catg_yn="";
	boolean allow_inside=true;
	String arguments	= "";
	String isApptExists	= "N";

	 con =  ConnectionManager.getConnection(request);

	 String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where APPL_USER_ID=?";

	pstmtValidUser = con.prepareStatement(strSqlValidUser);
	pstmtValidUser.setString(1,facility_id);
	pstmtValidUser.setString(2,login_user.trim());
	rset = pstmtValidUser.executeQuery();
	
	if(rset !=null && rset.next()){
		
		preferred_style = rset.getString("preferred_style");
		facility_name = rset.getString("facility_name");
				
		if(facility_name == null || facility_name.equals(""))
            facility_name = "";
           if(preferred_style == null || preferred_style.equals(""))
            preferred_style = "IeStyle.css";

			rset.close();
			isValidLogin	= "Y";

			String operSql	= "SELECT a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn, a.tfr_appt_across_catg_yn tfr_appt_across_catg_yn, to_char(sysdate,'dd/mm/yyyy') dt FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			pstmtResp = con.prepareStatement(operSql);
			pstmtResp.setString(1,facility_id);
			pstmtResp.setString(2,login_user.trim());
			rsetResp = pstmtResp.executeQuery();
			
			if(rsetResp !=null && rsetResp.next()){
				oper_stn_id=rsetResp.getString("oper_stn_id");
				canc_appt_yn=rsetResp.getString("canc_appt_yn");
				tfr_appt_yn=rsetResp.getString("tfr_appt_yn");
				book_appt_yn=rsetResp.getString("book_appt_yn");
				tfr_appt_across_catg_yn=rsetResp.getString("tfr_appt_across_catg_yn");


				session.putValue("PREFERRED_STYLE",preferred_style);
				session.putValue("facility_name",facility_name);
				session.putValue("LOCALE",locale);		
				session.putValue("facility_id",facility_id);
				session.putValue("login_user",login_user);
				session.putValue("connection_pooling_yn","Y");
				Properties p = new Properties() ;
				p.setProperty( "login_user",login_user) ;
				p.setProperty("connection_pooling_yn","Y") ;
				p.setProperty("client_ip_address",client_ip_address) ;
				p.setProperty("jdbc_props",jdbc_props) ;
				p.setProperty("LOCALE",locale) ;
				session.putValue( "jdbc",p ) ;


				//String apptSql	= "SELECT TO_CHAR (appt_slab_from_time, 'HH24:MI:SS') i_from_time, TO_CHAR (appt_slab_to_time, 'HH24:MI:SS') i_to_time, clinic_code i_clinic_code, practitioner_id i_practitioner_id, to_char(appt_date,'dd/mm/yyyy') i_appt_date, TO_CHAR (appt_date, 'DAY') appt_day1, APPT_TYPE_CODE visit_type_ind, team_id i_team_id, care_locn_type_ind clinic_type, op_get_desc.op_clinic (facility_id, clinic_code, '"+locale+"', 1 ) clinic_name, resource_class res_type, DECODE (resource_class,  'P', am_get_desc.am_practitioner (practitioner_id, '"+locale+"', 1),  'R', practitioner_id,  am_get_desc.am_resource (facility_id, practitioner_id, '"+locale+"', '2' ) ) practitioner_name   FROM oa_appt WHERE facility_id = '"+facility_id+"' AND appt_ref_no = '"+i_appt_ref_no+"'";
				String apptSql	= "SELECT TO_CHAR (appt_slab_from_time, 'HH24:MI:SS') i_from_time, TO_CHAR (appt_slab_to_time, 'HH24:MI:SS') i_to_time, clinic_code i_clinic_code, practitioner_id i_practitioner_id, to_char(appt_date,'dd/mm/yyyy') i_appt_date, TO_CHAR (appt_date, 'DAY') appt_day1, APPT_TYPE_CODE visit_type_ind, team_id i_team_id, care_locn_type_ind clinic_type, op_get_desc.op_clinic (facility_id, clinic_code, ? , 1 ) clinic_name, resource_class res_type, DECODE (resource_class,  'P', am_get_desc.am_practitioner (practitioner_id, ?, 1),  'R', practitioner_id,  am_get_desc.am_resource (facility_id, practitioner_id, ?, '2' ) ) practitioner_name   FROM oa_appt WHERE facility_id =? AND appt_ref_no = ? ";
				pstmtApptDtls = con.prepareStatement(apptSql);
				pstmtApptDtls.setString(1,locale);
				pstmtApptDtls.setString(2,locale);
				pstmtApptDtls.setString(3,locale);
				pstmtApptDtls.setString(4,facility_id);
				pstmtApptDtls.setString(5,i_appt_ref_no);
				rsetApptDtls = pstmtApptDtls.executeQuery();
				
				if(rsetApptDtls !=null && rsetApptDtls.next()){
					isApptExists	= "Y";
					String i_from_time	= checkForNull(rsetApptDtls.getString("i_from_time"));
					String i_to_time	= checkForNull(rsetApptDtls.getString("i_to_time"));
					String i_clinic_code	= checkForNull(rsetApptDtls.getString("i_clinic_code"));
					String i_practitioner_id	= checkForNull(rsetApptDtls.getString("i_practitioner_id"));
					String i_appt_date	= checkForNull(rsetApptDtls.getString("i_appt_date"));
					String new_appt_date	= i_appt_date; 
					String appt_day1	= checkForNull(rsetApptDtls.getString("appt_day1").trim());
					String visit_type_ind	= checkForNull(rsetApptDtls.getString("visit_type_ind"));
					String i_team_id	= checkForNull(rsetApptDtls.getString("i_team_id"));
					String clinic_type	= checkForNull(rsetApptDtls.getString("clinic_type"));
					String clinic_name	= checkForNull(rsetApptDtls.getString("clinic_name"));
					String res_type	= checkForNull(rsetApptDtls.getString("res_type"));
					String practitioner_name	= checkForNull(rsetApptDtls.getString("practitioner_name"));
					arguments	= "&i_from_time="+i_from_time+"&i_to_time="+i_to_time+"&i_clinic_code="+i_clinic_code+"&i_practitioner_id="+i_practitioner_id+"&i_appt_date="+i_appt_date+"&new_appt_date="+new_appt_date+"&appt_day1="+appt_day1+"&visit_type_ind="+visit_type_ind+"&i_team_id="+i_team_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&over_booked=N&Forced=N&rd_appt_yn=N"+"&practitioner_name="+practitioner_name+"&clinic_name="+clinic_name;

				}
			}else{
				allow_inside	= false;
			}
			rsetResp.close();
			rsetApptDtls.close();
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(isValidLogin));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(allow_inside));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(isApptExists));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(functionCall));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(s));
            out.print( String.valueOf(arguments));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(functionCall));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(s));
            out.print( String.valueOf(arguments));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
} catch(Exception e){
	e.printStackTrace();
}finally{		 
	if (rset !=null) rset.close();
	if (pstmtValidUser!=null) pstmtValidUser.close(); 
	if (pstmtResp!=null) pstmtResp.close(); 
	if (pstmtApptDtls!=null) pstmtApptDtls.close(); 
	if(con!=null)ConnectionManager.returnConnection(con,request);		
}
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
