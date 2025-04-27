package jsp_servlet._eop._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __managespatqueue extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ManageSPatQueue.jsp", 1738736811454L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n    Developed by    :   R.Nanda Kumar \n    Created on\t\t:   22/12/2000\n    Module\t\t\t:   Out Patient Management\n    Function\t\t:   This file is used for dynamically generating toolbar for the\n\t\t\t\t\t\tfunction. Here 1 frame is defined for the function.\n                it is from op_param table and column name is queue_refresh_interval\n-->\n\n<html>\n<head>\n    ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    <!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n    <script language=\'javascript\' src=\'../../eOP/js/ManageSPatQueueVsign.js\'></script>\n    <script language=\'javascript\' src=\'../../eOP/js/ManageSPatQueueChkout.js\'></script>\n    <script language=\'javascript\' src=\'../../eOP/js/ManageSPatQueue.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<title>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t</title>\n</head>\n\t\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'    src=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe> \n\t\t<iframe name=\'frame1\' id=\'frame1\' \tsrc=\'../../eOP/jsp/ManageMPatQueueQuery.jsp?function_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&QQue=Que&refresh=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&access_rule=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&oprstn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&call_from=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&speciality_code=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&pat_id_length=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&bl_package_enabled_yn=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&sdate=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&open_search_reqd_yn=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&action_on_pending_bill=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:40vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:8vh;width:100vw\'></iframe>\n\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n<!--Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297]  -->\n\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'    src=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" frameborder=0 scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe> \n\t\t<iframe name=\'frame1\' id=\'frame1\' src=\'../../eOP/jsp/ManageSPatQueueFr2.jsp?function_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&Que=Que&refresh=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&oper_stn_access_rule=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&oper_id=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' frameborder=\'0\' scrolling=\'no\' noresize style=\'height:85vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:7vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<script>\n\t\trefresh_param = ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \n    </script>\n\n\t<input type = \'hidden\' name = \'OsVal_chkout\' id = \'OsVal_chkout\' value = \'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t<input type = \'hidden\' name = \'allergy_yn\' id = \'allergy_yn\' value = \'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type = \'hidden\' name = \'caInsYn\' id = \'caInsYn\' value = \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t<input type = \'hidden\' name = \'assign_queue_num_by\' id = \'assign_queue_num_by\' value = \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t<input type = \'hidden\' name = \'open_search_reqd_yn\' id = \'open_search_reqd_yn\' value = \'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t<input type = \'hidden\' name = \'mins1_for_wait_time\' id=\'mins1_for_wait_time\' value = \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t<input type = \'hidden\' name = \'mins2_for_wait_time\' id = \'mins2_for_wait_time\' value = \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t<input type = \'hidden\' name = \'action_on_pending_bill\' id = \'action_on_pending_bill\' value = \'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'><!--  Added For MMS-QH-CRF-0126 [IN:041880] -->\n\t<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->\n\t<input type = \'hidden\' name = \'isQMSapplicable\' id = \'isQMSapplicable\'  value = \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Started-->\n\t\n \n\n</html>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

        Connection con=null;
        try{ 		
					
            con=ConnectionManager.getConnection(request);        
			Statement stmt=null;
			ResultSet rs=null;
			String fac_id       = (String) session.getValue( "facility_id" ) ;
			String userid           = (String) session.getValue("login_user");
			String bl_oper_yn = (String)session.getValue("bl_operational")==null?"N":(String)session.getValue("bl_operational");
			String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
			StringBuffer sql = new StringBuffer();
			int refresh_interval = 0;			
			String oper_stn_access_rule="";			
			String OsVal="";
			String OsVal_chkout="";
			String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"); 
			//String ca_install_yn = "N";
			String pat_id_length = "";
			String bl_package_enabled_yn = "N";
			String sdate = "";
			String caInsYn = "N";
			String allergy_yn = "N";
			String assign_queue_num_by = "";
			String open_search_reqd_yn = "N";
			String action_on_pending_bill	= "";// Added For MMS-QH-CRF-0126 [IN:041880]
			int mins1_for_wait_time = 0;
			int mins2_for_wait_time = 0;
			
			boolean isQMSapplicable=false;
			isQMSapplicable=eCommon.Common.CommonBean.isSiteSpecific(con,"OP","EXT_QUEUE_NO"); //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
	
			sql.append(" select queue_refresh_interval, oper_stn_access_rule, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','MANAGE_QUEUE_YN') osval, (Select patient_id_length from mp_param where module_id = 'MP') pat_id_length,");
			
			if(bl_oper_yn.equals("Y")) {
				sql.append(" (select PACKAGE_ENABLED_YN from bl_parameters where operating_facility_id ='"+fac_id+"') bl_package_enabled_yn, ");
			}
			
			sql.append(" to_char(sysdate,'hh24:mi') sdate, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') OsVal_chkout, (select install_yn from sm_module where module_id ='CA') install_yn, GET_TASK_APPLICABILITY('ALLERGIES', NULL, '"+resp_id+"', NULL) allergy_yn, ASSIGN_QUEUE_NUM_BY,open_search_reqd_yn,MINS1_FOR_WAIT_TIME,MINS2_FOR_WAIT_TIME,ACTION_ON_PENDING_BILL from op_param where operating_facility_id='"+fac_id+"' ");	
			
			stmt	= con.createStatement();			
			rs	= stmt.executeQuery(sql.toString()) ;
			if(rs!=null && rs.next()) {	

				refresh_interval = (rs.getInt("queue_refresh_interval") * 60)*1000; 			
				oper_stn_access_rule = rs.getString("oper_stn_access_rule") == null?"":rs.getString("oper_stn_access_rule");
				OsVal = rs.getString("osval") == null?"":rs.getString("osval");
				//ca_install_yn = rs.getString("ca_install_yn") == null?"N":rs.getString("ca_install_yn");
				pat_id_length = rs.getString("pat_id_length") == null?"":rs.getString("pat_id_length");
				
				if(bl_oper_yn.equals("Y")) {
					bl_package_enabled_yn = rs.getString("bl_package_enabled_yn") == null?"N":rs.getString("bl_package_enabled_yn");
				}

				sdate = rs.getString("sdate") == null?"":rs.getString("sdate");

				OsVal_chkout = rs.getString("OsVal_chkout") == null?"":rs.getString("OsVal_chkout");
				allergy_yn = rs.getString("allergy_yn") == null?"N":rs.getString("allergy_yn");
				caInsYn = rs.getString("install_yn") == null?"N":rs.getString("install_yn");
				assign_queue_num_by = rs.getString("assign_queue_num_by") == null?"":rs.getString("assign_queue_num_by");
				open_search_reqd_yn = rs.getString("open_search_reqd_yn") == null?"N":rs.getString("open_search_reqd_yn");
				action_on_pending_bill	= rs.getString("ACTION_ON_PENDING_BILL") == null?"":rs.getString("ACTION_ON_PENDING_BILL"); // Added For MMS-QH-CRF-0126 [IN:041880]
				mins1_for_wait_time = rs.getInt("MINS1_FOR_WAIT_TIME");
				mins2_for_wait_time = rs.getInt("MINS2_FOR_WAIT_TIME");
					
					

				if(OsVal.equals("1"))
				{
					out.print(" <script>alert(getMessage('MANAGE_QUEUE_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else if(OsVal.equals("2"))
				{
					out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("3"))
				{
					out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("4"))
				{
					out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("5"))
				{
					out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}
				else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
				{
				} 										
           } else {
				out.println("<script>alert(parent.frames[0].getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
           }
                

    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString();
	String source = url + params ;
	String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
	String function_id=request.getParameter("function_id");
	 
    if(function_id == null) function_id = "";
/*
 Below is defined a frameset having 3 frames :
	1.	The first frame is for the common toolbar .
	2.	The second frame displays the main functionality page.
	3.	The third frame is for the messages and the inetrmediate jsp validations.
*/

            _bw.write(_wl_block10Bytes, _wl_block10);

	if(call_from.equals("CA"))	{
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(source));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(refresh_interval));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oper_stn_access_rule));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bl_package_enabled_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(open_search_reqd_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(action_on_pending_bill));
            _bw.write(_wl_block23Bytes, _wl_block23);
} else {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(source));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(refresh_interval));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(oper_stn_access_rule));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bl_package_enabled_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(open_search_reqd_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(action_on_pending_bill));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(refresh_interval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(OsVal_chkout));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(caInsYn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(assign_queue_num_by));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(open_search_reqd_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mins1_for_wait_time));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(mins2_for_wait_time));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(action_on_pending_bill));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(isQMSapplicable));
            _bw.write(_wl_block40Bytes, _wl_block40);

	if (stmt != null)    stmt.close();
    if (rs != null)       rs.close(); 	
}catch(Exception e) {e.printStackTrace();}
finally{	
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ManagePatQ.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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
