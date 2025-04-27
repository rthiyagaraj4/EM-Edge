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

public final class __aecheckout extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AECheckOut.jsp", 1709706326133L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n﻿";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eAE/js/AEManagePatient.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:6vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eAE/jsp/AEManagePatientMain.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:84vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=\'0\' noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\t\t\t\t\n\t     \t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t<script>\t\n\t\t\t\talert(getMessage(\'OP_PARAM_NOT_FOUND\',\'OP\'));\n\t\t\t\twindow.location.href = \'../../eCommon/jsp/dmenu.jsp\' ;\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection			con			=	null; 
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	String	 facility_id				=	"";
	String	 login_user_id			=	"";
	String	 queue_refresh_interval		=	"";
	String	 count		=	"";
	StringBuffer query_string		=	new StringBuffer();
	String  sys_date				=   "";
	 String OsVal = "";
	String  checkout_yn ="Y";
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String url						=	"../../eCommon/jsp/commonToolbar.jsp?" ;
	String params					=	request.getQueryString() ;
	String source					=	url + params ;
	String pid_length				=	""; //Rameez for ML-BRU-SCF-0605 [IN:036358] on 23-11-2012
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
	String five_level_triage_appl_yn	= "N";
	String cutoff_hours_prv_day_visit	= "";
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/
	try
	{

		con				=	(Connection)	ConnectionManager.getConnection(request);
		facility_id		=	(String)		session.getValue("facility_id");
		login_user_id	=	(String)		session.getValue("login_user");
		StringBuffer queryOPParam = new StringBuffer();
        queryOPParam.append("select to_char(sysdate ,'hh24:mi') hmin, queue_refresh_interval, (select 1  from ae_param  where OPERATING_FACILITY_ID=?) count, (Select AM_OPER_STN_ACCESS_CHECK(?,?,'C','','CHECKOUT_PAT_YN') FROM dual) OsVal, (SELECT patient_id_length FROM mp_param) patient_id_length, (select five_level_triage_appl_yn  from ae_param  where OPERATING_FACILITY_ID='"+facility_id+"') five_level_triage_appl_yn, (select CUTOFF_HOURS_PRV_DAY_VISIT  from ae_param  where OPERATING_FACILITY_ID='"+facility_id+"') CUTOFF_HOURS_PRV_DAY_VISIT from op_param where operating_facility_id = ?"); //Rameez for ML-BRU-SCF-0605 [IN:036358] on 23-11-2012 - Modified query to add 'patient_id_length'

        //queryOPParam.append("(select 1  from ae_param  where OPERATING_FACILITY_ID=?) count, ");
        //queryOPParam.append("(Select AM_OPER_STN_ACCESS_CHECK(?,?,'C','','CHECKOUT_PAT_YN') ");
		//queryOPParam.append(" FROM dual ) OsVal from op_param where operating_facility_id = ? ");	
		pstmt			=	con.prepareStatement(queryOPParam.toString());
		pstmt.setString	(	1,	facility_id		);
		pstmt.setString	(	2,	facility_id		);
		pstmt.setString	(	3,	login_user_id	);
		pstmt.setString	(	4,	facility_id		);
		rs				=	pstmt.executeQuery();

		if(rs!=null && rs.next())	{			
			sys_date	=	rs.getString("hmin")==null?"":rs.getString("hmin");
			queue_refresh_interval	=	rs.getString("queue_refresh_interval")==null?"":rs.getString("queue_refresh_interval");
			count	=	rs.getString("count")==null?"":rs.getString("count");
			OsVal	=	rs.getString("OsVal")==null?"":rs.getString("OsVal");	
			pid_length	=	rs.getString("patient_id_length")==null?"":rs.getString("patient_id_length"); //Rameez for ML-BRU-SCF-0605 [IN:036358] on 23-11-2012				
			five_level_triage_appl_yn	=  (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");
			cutoff_hours_prv_day_visit	=  (rs.getString("CUTOFF_HOURS_PRV_DAY_VISIT")==null || rs.getString("CUTOFF_HOURS_PRV_DAY_VISIT")=="")?"N":rs.getString("CUTOFF_HOURS_PRV_DAY_VISIT");
			if(count.equals("")) {
				out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
			} else { 
					if(OsVal.equals("1")) 	{
						out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 } else if(OsVal.equals("2")) {
						out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 }else  if(OsVal.equals("3")) {
						out.print(" <script>alert(getMessage('CHECKOUT_NOT_ALL_OPERSTN','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 }else  if(OsVal.equals("4")) {
						out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 } else  if(OsVal.equals("5")) {
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 }else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5"))) {
						 query_string.append(source);	query_string.append("&queue_refresh_interval="+queue_refresh_interval+"&checkout_yn="+checkout_yn+"&sys_date="+sys_date+"&oper_stn_id="+OsVal+"&pid_length="+pid_length+"&five_level_triage_appl_yn="+five_level_triage_appl_yn+"&p_cutoff_hours_prv_day_visit="+cutoff_hours_prv_day_visit+" "); //Rameez for ML-BRU-SCF-0605 [IN:036358] on 23-11-2012 - added 'pid_length' param
					 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);

					}
				}
		 } else {
	
            _bw.write(_wl_block11Bytes, _wl_block11);
}

		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if((queryOPParam != null) && (queryOPParam.length() > 0)) {
			queryOPParam.delete(0,queryOPParam.length());
		}         
        if((query_string != null) && (query_string.length() > 0)) {
			query_string.delete(0,query_string.length());
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
