package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aemanagepatients extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEManagePatients.jsp", 1733806071140L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eAE/js/AEManagePatient.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:6vh;width:100vw\'></iframe> \n\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eAE/jsp/AEManagePatientMain.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&function_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:88vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=\'0\' noresize scrolling=\'auto\' style=\'height:6vh;width:100vw\'></iframe>\t\n\t\t\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\' src=\'\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:0vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</html>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String function_id	= checkForNull(request.getParameter("function_id"));

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	Connection			con			=	null; 
	PreparedStatement	pstmt		=	null;	
	ResultSet			rs			=	null;	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String facility_id	=	"";
	String login_user_id	=	"";
	String	 nursing_unit_code	=	"";	
	String sys_date	=	"";
	String	 queue_refresh_interval	=	"";
	String OsVal= "" ;	
	String pid_length = "" ;	
	String observe_id = "" ;	
	String checkout_yn	=   "N";
	String allow_chkout_with_bill_stmt_yn ="N";
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
	String five_level_triage_appl_yn	= "N";
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/
	StringBuffer	query_string	= new StringBuffer();
	StringBuffer sqlDate = new StringBuffer();

	int p_cutoff_hours_prv_day_visit=   0;

	try
	{
		con				=	(Connection)	ConnectionManager.getConnection(request);
		facility_id		=	(String)		session.getValue("facility_id");
		login_user_id	=	(String)		session.getValue("login_user");
		
		
		sqlDate.append("select to_char(sysdate ,'hh24:mi') hmin,ae_observe_battery_id,");
		sqlDate.append("CUTOFF_HOURS_PRV_DAY_VISIT,queue_refresh_interval,nursing_unit_code,allow_chkout_with_bill_stmt_yn,");
		/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
		sqlDate.append("five_level_triage_appl_yn,");
		/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/
		
		sqlDate.append("(select patient_id_length from mp_param where module_id = 'MP') pid_length,");
		sqlDate.append("(Select AM_OPER_STN_ACCESS_CHECK(?,?,'C','','MANAGE_QUEUE_YN') FROM dual)");
		sqlDate.append("OsVal from ae_param where operating_facility_id=? ");		
		pstmt  = con.prepareStatement(sqlDate.toString());
		pstmt.setString(1,facility_id);		
		pstmt.setString(2,login_user_id);
		pstmt.setString(3,facility_id);
		rs = pstmt.executeQuery();

		if(rs!=null && rs.next()){
			sys_date						=	rs.getString("hmin");
			p_cutoff_hours_prv_day_visit	=	rs.getInt("CUTOFF_HOURS_PRV_DAY_VISIT");
			queue_refresh_interval			=	rs.getString("queue_refresh_interval");
			queue_refresh_interval			= ""+((rs.getInt("queue_refresh_interval") * 60)*1000);
			nursing_unit_code              =	checkForNull(rs.getString("nursing_unit_code"));
			allow_chkout_with_bill_stmt_yn  =	checkForNull(rs.getString("allow_chkout_with_bill_stmt_yn"));
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
			five_level_triage_appl_yn	=  (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/
			observe_id  =	checkForNull(rs.getString("ae_observe_battery_id"));		
			pid_length  =	checkForNull(rs.getString("pid_length"));		
			OsVal =	checkForNull(rs.getString("OsVal"));				   
			if(OsVal.equals("1")) 	{
				out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			} else if(OsVal.equals("2")) {
				out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("3")) {
				out.print(" <script>alert(getMessage('AE_MANAGEQ_NOT_ALL_OPERSTN','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4")) {
				out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			else  if(OsVal.equals("5")) {
				out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5"))) {
				query_string.append(	"queue_refresh_interval="+queue_refresh_interval+"&checkout_yn="+checkout_yn+"");
				/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
				query_string.append("&five_level_triage_appl_yn="+five_level_triage_appl_yn+"");
				/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/
				query_string.append(	"&sys_date="+sys_date+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&oper_stn_id="+OsVal+"&nursing_unit_code="+nursing_unit_code+"&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&observe_id="+observe_id+"&pid_length="+pid_length+" ");
				query_string.append("&"+params+"");				
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
  }			
		}else {
			out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		  }		 
			if(rs != null) rs.close();
			if(pstmt!=null) pstmt.close(); 
			if((query_string != null) && (query_string.length() > 0))
			{
				query_string.delete(0,query_string.length());
			}			
		   if((sqlDate != null) && (sqlDate.length() > 0)){
				sqlDate.delete(0,sqlDate.length());
			}
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
