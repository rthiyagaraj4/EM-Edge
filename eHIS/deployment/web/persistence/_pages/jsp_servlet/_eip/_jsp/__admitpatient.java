package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.net.*;

public final class __admitpatient extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AdmitPatient.jsp", 1733462665843L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n\t\n\t<script language=\'javascript\' src=\'../js/AdmitPatient.js\'></script>\n\t<script language=\'javascript\' src=\'../js/AdmitPatient1.js\'></script>\n\t<script language=\'javascript\' src=\'../js/AdmitPatient2.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<!-- modified for MMS-QH-CRF-0144 : passing reason_reqd_Flag parameter-->\n\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" frameborder=0 scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\"../../eIP/jsp/PaintAdmitPatient.jsp?patient_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&oper_stn_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&register_pat_in_admn_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&P_call_func=PATREG&nurs_unt_auth_val=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&backdated_admission_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&max_disch_period_for_dc=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&f_nursing_unit=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&deactivate_pseudo_bed_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&allowed_admission_type=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&called_from=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&quick_admission_type=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&quick_adm_referralid=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&quick_adm=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&ref_encounter_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&reason_reqd_Flag=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" frameborder=0 scrolling=\'no\' style=\'height:82vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\t\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t<!-- modified for MMS-QH-CRF-0144 : passing reason_reqd_Flag parameter-->\n\t\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" frameborder=0 scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\'../../eIP/jsp/PaintAdmitPatient.jsp?P_call_func=ADMIT&oper_stn_id=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nurs_unt_auth_val=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&noshow_bkng_period=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&from_adv_bed_mgmt=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&bedNo=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nursing_unit=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&appl_patient_class=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' frameborder=0 scrolling=\'auto\' style=\'height:82vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" frameborder=0 scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\'../jsp/BedAvailabilityChart.jsp?P_call_func=ADMIT\' frameborder=0 scrolling=\'auto\' style=\'height:82vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );
	
	private String checkForNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
	}	
	public static String checkForNull(String inputString, String defaultValue){
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	String url				= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String facilityId		= (String)session.getValue("facility_id");		
	String loginUser		= (String)session.getValue("login_user");
	String patientid		= checkForNull((String)request.getParameter("patient_id"));
	String menuid			= checkForNull((String)request.getParameter("menu_id"));
	String f_nursing_unit	= checkForNull((String)request.getParameter("f_nursing_unit"));
	/*The Patient Id Getting From NewBornRegistrationServlet.java from MP*/
	String called_from=checkForNull((String)request.getParameter("function_id"));
	//below code added for ABM CRF 643.1 ICN:36736
	String from_adv_bed_mgmt=checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");
	String bedNo=checkForNull((String)request.getParameter("bedNo"));
	String nursing_unit	= checkForNull((String)request.getParameter("nursing_unit"));
	String appl_patient_class	= checkForNull((String)request.getParameter("appl_patient_class"));

	/*Below line Added for this CRF  Bru-HIMS-CRF-261*/
	String quick_admission_type	= checkForNull((String)request.getParameter("quick_admission_type"));
	String quick_adm_referralid	= checkForNull((String)request.getParameter("quick_adm_referralid"));
	String quick_adm= checkForNull((String)request.getParameter("quick_adm"));
	String ref_encounter_id=checkForNull((String)request.getParameter("ref_encounter_id"));

	boolean result 					= true;
	Connection con					= null;
	int adm_date_chk_days			= 0;
	ResultSet rs 					= null;
	ResultSet rs2 					= null; 
	ResultSet rset_clinic			= null;
	ResultSet rset_opr 				= null;
	//ResultSet sqlRs 				= null;
	//Statement sqlStmt				= null;
	Statement stmt					= null;
	String adm_date_chk_days_type	= "";
	String admitpatyn				= "";
	String allowed_admission_type	= "";
	String back_date				= "";
	String backdated_admission_yn	= "";
	String bkg_grace_period			= "";
	String bl_interfaced_yn			= "";
	String call_func				= "";
	String deactivate_pseudo_bed_yn	= "N";
	String max_disch_period_for_dc	= "";
	String nurs_unt_auth_val		= "";
	String oper_stn_id				= "";
	String pat_checkin_yn			= "";
	String register_pat_in_admn_yn	= "";
	String reason_reqd_Flag 		= "N"; //Added for MMS-QH-CRF-0144
	//StringBuffer operSql	= new StringBuffer();
	StringBuffer queryString= new StringBuffer();
	StringBuffer sqlSb		= new StringBuffer();
	int nurs_unit_count=0;
	String noshow_bkng_period   = "";//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	
	try{	
		con	= ConnectionManager.getConnection(request);
		stmt= con.createStatement();
		//rs	= stmt.executeQuery("select allowed_admission_type, max_disch_period_for_dc, start_admit_screen, pat_check_in_allowed_yn, bl_interfaced_yn, adm_date_chk_days, adm_date_chk_days_type, bkg_grace_period, deactivate_pseudo_bed_yn from IP_PARAM where facility_id='"+facilityId+"' ") ;
		/**************Modified the below query for MMS-QH-CRF-0144 - getting REASON_MANDATORY_FOR_ADMN_YN column***************/
		rs	= stmt.executeQuery("SELECT a.oper_stn_id, a.admit_pat_yn, a.register_pat_in_admn_yn, a.admit_patient_with_bed_yn, a.backdated_admission_yn,(SELECT COUNT(*) FROM AM_OS_USER_LOCN_ACCESS_VW b WHERE b.facility_id='"+facilityId+"' AND b.locn_type = 'N' AND b.oper_stn_id = a.oper_stn_id AND b.appl_user_id = '"+loginUser+"' AND b.admit_pat_yn = 'Y' ) nurs_count, b.allowed_admission_type, b.max_disch_period_for_dc, b.start_admit_screen, b.pat_check_in_allowed_yn, b.bl_interfaced_yn, b.adm_date_chk_days, b.adm_date_chk_days_type, b.bkg_grace_period, b.deactivate_pseudo_bed_yn, b.noshow_bkng_period, b.REASON_MANDATORY_FOR_ADMN_YN FROM AM_OPER_STN a, ip_param b WHERE a.facility_id = '"+facilityId+"' AND a.facility_id = b.facility_id AND a.oper_stn_id = (SELECT oper_stn_id FROM AM_USER_FOR_OPER_STN WHERE facility_id = '"+facilityId+"' AND appl_user_id = '"+loginUser+"' AND TRUNC (SYSDATE) BETWEEN eff_date_from AND NVL (eff_date_to, TRUNC (SYSDATE)))") ;// modified   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
		
		
		if(rs.next()){
			max_disch_period_for_dc	= checkForNull(rs.getString("max_disch_period_for_dc"));
			call_func				= checkForNull(rs.getString("start_admit_screen"));
			
			pat_checkin_yn			= checkForNull(rs.getString("pat_check_in_allowed_yn"));
			bl_interfaced_yn		= checkForNull(rs.getString("BL_INTERFACED_YN"));
			adm_date_chk_days		= rs.getInt("adm_date_chk_days");
			adm_date_chk_days_type	= checkForNull(rs.getString("adm_date_chk_days_type"));
			bkg_grace_period		= checkForNull(rs.getString("bkg_grace_period"));
			deactivate_pseudo_bed_yn= checkForNull(rs.getString("deactivate_pseudo_bed_yn"),"N");
			allowed_admission_type	= checkForNull(rs.getString("allowed_admission_type"));
			admitpatyn				= rs.getString("admit_pat_yn");
			if(admitpatyn == null) admitpatyn ="N";		
			register_pat_in_admn_yn = rs.getString("register_pat_in_admn_yn");
			nurs_unt_auth_val       = rs.getString("admit_patient_with_bed_yn");
			backdated_admission_yn	= rs.getString("backdated_admission_yn");
			oper_stn_id				= rs.getString("oper_stn_id");
			nurs_unit_count			= rs.getInt("nurs_count");
			noshow_bkng_period   = checkForNull(rs.getString("noshow_bkng_period"));//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			reason_reqd_Flag 	 = rs.getString("REASON_MANDATORY_FOR_ADMN_YN");  //Added for MMS-QH-CRF-0144
          
			if (sqlSb.length() > 0) sqlSb.delete(0, sqlSb.length());
			//Commented for PE By Sudhakar
			/*if(adm_date_chk_days_type.equals("H"))
				sqlSb.append("SELECT TO_CHAR(SYSDATE-"+adm_date_chk_days+"/24,'dd/mm/rrrr hh24:mi') setup_date FROM dual");
			else
				sqlSb.append("SELECT TO_CHAR(SYSDATE-"+adm_date_chk_days+",'dd/mm/rrrr hh24:mi') setup_date FROM dual");

			sqlStmt	= con.createStatement();
			sqlRs	= sqlStmt.executeQuery(sqlSb.toString());
            
			while(sqlRs.next())
			{
				back_date = sqlRs.getString("setup_date");
			}

			if(sqlRs !=null) sqlRs.close();
			if(sqlStmt !=null) sqlStmt.close();*/	

			queryString.append("bl_interfaced_yn="+bl_interfaced_yn+"&adm_date_chk_days="+adm_date_chk_days);		queryString.append("&back_date="+java.net.URLEncoder.encode(back_date)+"&adm_date_chk_days_type="+adm_date_chk_days_type+"&bkg_grace_period="+bkg_grace_period+"&pat_checkin_yn="+pat_checkin_yn+"&max_disch_period_for_dc='"+max_disch_period_for_dc);

			/*
			//Added by Devang For Operator Station & Clinic  Check
			operSql.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
			rset_opr  = stmt.executeQuery(operSql.toString());
			if(rset_opr!=null)
			{
				if(rset_opr.next())
				{
					oper_stn_id = rset_opr.getString("OPER_STN_ID");
					if(oper_stn_id == null) oper_stn_id ="";			
				}	
				else
				{ 
					out.println("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));</script>");
					result = false;
					if(patientid.equals("") && !menuid.equals(""))
					{
						out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
				}
			}
			if(rset_opr != null) rset_opr.close();

			if (!oper_stn_id.equals("") && result)
			{
				// This query is to check whether the current operator station has acces to the Admit Patient function.
				if(operSql.length() > 0)
				operSql.delete(0,operSql.length());

				operSql.append("select admit_pat_yn, register_pat_in_admn_yn  from am_oper_stn ");
				operSql.append(" where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn  "); 
				operSql.append(" where facility_id='"+facilityId+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) ");
				rs2 = stmt.executeQuery(operSql.toString());
				if(rs2!= null)
				{
					while(rs2.next())
					{
						admitpatyn = rs2.getString("admit_pat_yn");
						if(admitpatyn == null) admitpatyn ="";		
						register_pat_in_admn_yn	 = checkForNull(rs2.getString("register_pat_in_admn_yn"),"N");
					}
				}

				//Check whether the user have authority for bed booking or not
				if (sqlSb.length() > 0) sqlSb.delete(0, sqlSb.length());
				sqlSb.append(" SELECT ADMIT_PATIENT_WITH_BED_YN, BACKDATED_ADMISSION_YN  FROM am_os_user_locn_access_vw WHERE facility_id='"+facilityId+"' AND oper_stn_id= '"+oper_stn_id+"' AND appl_user_id = '"+loginUser+"' and LOCN_TYPE = 'N' "); 

				sqlStmt	= con.createStatement();
				sqlRs	= sqlStmt.executeQuery(sqlSb.toString());
				if(sqlRs!=null)
				{
					while(sqlRs.next())
					{
						nurs_unt_auth_val = sqlRs.getString("ADMIT_PATIENT_WITH_BED_YN");
						backdated_admission_yn = sqlRs.getString("BACKDATED_ADMISSION_YN");
					}
				}

				if(sqlRs !=null) sqlRs.close();
				if(sqlStmt !=null) sqlStmt.close();	
*/
				/*if(operSql.length() > 0)
				operSql.delete(0,operSql.length());
				//Commented for PE By Sudhakar

				operSql.append("SELECT a.oper_stn_id, a.admit_pat_yn, a.register_pat_in_admn_yn,        a.admit_patient_with_bed_yn, a.backdated_admission_yn FROM AM_OPER_STN a WHERE a.facility_id = '"+facilityId+"' AND a.oper_stn_id = (SELECT oper_stn_id FROM AM_USER_FOR_OPER_STN where facility_id = '"+facilityId+"' AND appl_user_id = '"+loginUser+"' AND TRUNC (SYSDATE) BETWEEN eff_date_from AND NVL (eff_date_to, TRUNC (SYSDATE)))/* AND EXISTS ( SELECT locn_code from AM_LOCN_FOR_OPER_STN where facility_id = '"+facilityId+"' AND oper_stn_id = a.oper_stn_id AND locn_type = 'N' ) ");
				
				rs2 = stmt.executeQuery(operSql.toString());
				
				if(rs2!= null)
				{
					while(rs2.next())
					{
						admitpatyn				= rs2.getString("admit_pat_yn");
						if(admitpatyn == null) admitpatyn ="N";		
						register_pat_in_admn_yn = rs2.getString("register_pat_in_admn_yn");
						nurs_unt_auth_val       = rs2.getString("admit_patient_with_bed_yn");
						backdated_admission_yn	= rs2.getString("backdated_admission_yn");
						oper_stn_id				= rs2.getString("oper_stn_id");
					}
				}*/

				if (oper_stn_id.equals("")){
					out.println("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));</script>");
					result = false;
					if(patientid.equals("") && !menuid.equals("")){
						out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
				}else if(admitpatyn.equals("Y")){
					// The following query will check whether the logged in user has access to any nursing unit, which are associated to the operator station.
					//Commented for PE By Sudhakar
					/*if(operSql.length() > 0)
					operSql.delete(0,operSql.length());
					operSql.append(" SELECT b.locn_code FROM AM_OS_USER_LOCN_ACCESS_VW b WHERE b.facility_id='"+facilityId+"' and b.locn_type = 'N' AND b.oper_stn_id = '"+oper_stn_id+"' AND b.appl_user_id = '"+loginUser+"' AND b.admit_pat_yn = 'Y' ");

					rs = stmt.executeQuery(operSql.toString());*/
					if (!(nurs_unit_count > 0)){
						if(!patientid.equals("")){
							out.println("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));window.parent.close();</script>");
						}else{
							out.println("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));</script>");
							if(patientid.equals("") && !menuid.equals("")){ 
								out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
							}
						}
					}else{
						if(!patientid.equals("")){
							if(!called_from.equals("NEWBORN_REG"))//added for  ICN 7440 12/31/2008
							source="../../eIP/jsp/AdmitPatientToolbar.jsp" ;
							/*Below line modified  for this CRF  Bru-HIMS-CRF-261*/
							
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(register_pat_in_admn_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nurs_unt_auth_val));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(backdated_admission_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(f_nursing_unit));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(allowed_admission_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(quick_admission_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(quick_adm_referralid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(quick_adm));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ref_encounter_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(reason_reqd_Flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(queryString.toString()));
            _bw.write(_wl_block26Bytes, _wl_block26);
		}else{
							if(call_func.equals("D")){
							
							if(from_adv_bed_mgmt.equals("Y")){
								source="../../eIP/jsp/AdmitPatientToolbar.jsp?from_adv_bed_mgmt='Y'" ;
							}
							/*Below line modified for this CRF  Bru-HIMS-CRF-261*/
							
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(nurs_unt_auth_val));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(backdated_admission_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(register_pat_in_admn_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(allowed_admission_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(noshow_bkng_period));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(from_adv_bed_mgmt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(appl_patient_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(quick_admission_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(quick_adm_referralid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(quick_adm));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ref_encounter_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(reason_reqd_Flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( queryString.toString()));
            _bw.write(_wl_block35Bytes, _wl_block35);
		}else{	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block37Bytes, _wl_block37);
		}
						}
					} //e.o. !rs.next -- for ip clinic
				}//e.o.if Admit = "Y"
				else{
					if(!patientid.equals("")){
						out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));window.parent.close();</script>");
					}else{ 
						out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));</script>");
						if(patientid.equals("") && !menuid.equals("")){ 
							out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp'</script>");
						}
					}
				}		
		//	}// opr
		}else if(!patientid.equals("")){ 
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));window.parent.close();</script>");
		}else{
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));</script>");
			if(patientid.equals("") ){
				out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
			}
		}
		if(rs!=null) 			rs.close();
		if(rs2!=null)			rs2.close();
		if(rset_opr!=null)		rset_opr.close();
		if(rset_clinic!=null)	rset_clinic.close();
		if(stmt!=null) 			stmt.close();
	}catch(Exception e){
		//out.print("Exception in AdmitPatient.jsp : "+e.toString());
		e.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block38Bytes, _wl_block38);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmitPatient.label", java.lang.String .class,"key"));
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
