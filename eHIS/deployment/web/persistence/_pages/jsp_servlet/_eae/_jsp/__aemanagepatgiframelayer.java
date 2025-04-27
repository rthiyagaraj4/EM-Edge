package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __aemanagepatgiframelayer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEManagePatGIFrameLayer.jsp", 1709113834960L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatientGI.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body  id=\'b\' onKeyDown = \'lockKey()\'> \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script> \n\t\t\t//resetValues(); \n\t\t\t//var tab= parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.tabIndicator.value;\n\t\t\t//if(tab==\'char_tab\')\n\t\t\t\t//alert(\'venkat\')\n\t\t\t//alert(getMessage(\"NO_BED_FOR_CRITERIA\",\"AE\"));\n\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<script>\n\t\t\t\t\t\tresetValues(); \n\t\t\t\t\t\tvar tab= parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.tabIndicator.value;\n\t\t\t\t\t\tif(tab==\'char_tab\')\n\t\t\t\t\t\talert(getMessage(\"NO_BED_FOR_CRITERIA\",\"AE\"));\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
  
	//Conversion
	public String specialCharacter(String single){
		int i=0;
				
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		}
	
		return single ;
	}	
/*********************/
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
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

	Connection	con						= null;
	java.sql.Statement	stmt			= null; 
	ResultSet	rs						= null;
	PreparedStatement pstmt				= null;
	request.setCharacterEncoding("UTF-8");
	String locale				        = (String)session.getAttribute("LOCALE");
	String facility_id					= checkForNull((String) session.getAttribute("facility_id"));
	String clinic_code					= checkForNull(request.getParameter("clinic_code"));
	String treatment_area				= (!checkForNull(request.getParameter("treatment_area_code1")).equals(""))?request.getParameter("treatment_area_code1"):checkForNull(request.getParameter("treatment_area_code"));
	String bed_no						= checkForNull(request.getParameter("bed_no"));
	String gender						= checkForNull(request.getParameter("gender"));
	String bed_status					= checkForNull(request.getParameter("bed_status"));
	String treatment_area_code_prev		= "" ;
	String disp_content1				= "";
	String disp_content					= "";
	String info							= "";
    String chk_Select1					= checkForNull(request.getParameter("chk_Select1"));
	String CAInstalled					= "";
	String practitioner_id1				= checkForNull(request.getParameter("practitioner_id"));
	String priority1					= checkForNull(request.getParameter("priority"));
	String patient_id1					= checkForNull(request.getParameter("patient_id"));
	String patient_id					= checkForNull(request.getParameter("patient_id"));
	String SERVICE_DESC					= "";
	String PAT_CURR_LOCN_DESC			= "";
	String fs_locn_code					= "";
	String reason_for_reserve			= "";
	String priority_zone				= "";
	String cursor						= "cursor:pointer";

	priority_zone	=	(request.getParameter("priority_zone")==null)	? "" : request.getParameter("priority_zone");	
	if (bed_status.equals(""))
		bed_status = "A";
	int		bed_col_num		= 1;
	if(bed_status.equals("A") && chk_Select1.equals("")){
		cursor="";
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

	StringBuffer whereBuffer  = new StringBuffer();
	StringBuffer whereBuffer1 = new StringBuffer();
	StringBuffer queryBuffer  = new StringBuffer();
	StringBuffer queryBuffer1 = new StringBuffer();
	
	Boolean increasedaddressLength =false ; //Added for ML-MMOH-CRF-0860.2
	
	try { 
		con	=	  ConnectionManager.getConnection(request);
        String CAInstallSQL= "select install_yn from sm_module where module_id='CA' ";
		PreparedStatement CAInstallPSTMT				= con.prepareStatement(CAInstallSQL);
		ResultSet CAInstallRS							= CAInstallPSTMT.executeQuery();
		
		//Added for this CRF ML-MMOH-CRF-0860.2
		increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");

		if(CAInstallRS!=null && CAInstallRS.next()) 	{
		    CAInstalled = CAInstallRS.getString(1);
		}

        if(CAInstallPSTMT!=null) CAInstallPSTMT.close();
        if(CAInstallRS!=null) CAInstallRS.close();

		//queryBuffer.append("select to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth,a.locn_code, c.LONG_DESC locn_desc,a.locn_type,a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.locn_code, a.TREATMENT_AREA_CODE,'"+locale+"'    ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area,c.open_to_all_pract_yn,a.practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"'    ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"'    ,'1') practitioner_full_name, a.priority_indicator,  a.priority_zone,to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time,to_char(a.check_in_date_time,'hh24:mi') check_in_date_time, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,  a.patient_id,(decode('"+locale+"'    ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name,b.sex  gender, a.encounter_id, get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time,to_char(a.queue_date,'dd/mm/yyyy') queue_date1,to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date,a.queue_status,a.queue_status queue_status_desc, a.trauma_yn,a.brought_dead_yn,  NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.AE_BED_NO bed_no,d.current_status current_status,d.pseudo_bed_yn, null high_risk, null allergy, null result,A.SERVICE_CODE,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'"+locale+"'  ,'2') SERVICE_DESC,a.priority_indicator PATIENT_PRIORITY_NO,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"'    ,'2') PATIENT_PRIORITY_DESC,DECODE (a.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.pat_curr_locn_code,'"+locale+"'    ,'2'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.facility_id, a.pat_curr_locn_code,'"+locale+"'    ,'2'),                       OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"'    ,'1')) pat_curr_locn_desc,c.mr_location_code fs_locn_code,null reason_for_reserve from  ae_current_patient a, mp_patient b,op_clinic_lang_vw c,ae_bed_for_trmt_area d where a.facility_id = '"+facility_id+"'   and a.queue_status <= '07'  and  TRUNC(TO_DATE(a.Queue_date,'dd/mm/yyyy'))BETWEEN TRUNC(TO_DATE(SYSDATE-1,'dd/mm/yyyy')) AND SYSDATE  and TRUNC(TO_DATE(a.Queue_date,'dd/mm/yyyy'))BETWEEN TRUNC(TO_DATE(SYSDATE-1,'dd/mm/yyyy')) AND SYSDATE  and a.patient_id = b.patient_id and c.language_id = '"+locale+"'     and a.locn_code = c.clinic_code and a.facility_id = c.facility_id and d.facility_id=a.facility_id AND a.locn_code=d.CLINIC_CODE AND a.TREATMENT_AREA_CODE=d.TREATMENT_AREA_CODE AND a.AE_BED_NO=d.bed_no  AND d.occupying_patient_id IS NOT NULL "); Tuesday, June 01, 2010 PE_EXE

		queryBuffer.append("select to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth,a.locn_code, c.LONG_DESC locn_desc,a.locn_type,a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.locn_code, a.TREATMENT_AREA_CODE,'"+locale+"'    ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area,c.open_to_all_pract_yn,a.practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"'    ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"'    ,'1') practitioner_full_name, a.priority_indicator,  a.priority_zone,to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time,to_char(a.check_in_date_time,'hh24:mi') check_in_date_time, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,  a.patient_id,(decode('"+locale+"'    ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name,b.sex  gender, a.encounter_id, get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time,to_char(a.queue_date,'dd/mm/yyyy') queue_date1,to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date,a.queue_status,a.queue_status queue_status_desc, a.trauma_yn,a.brought_dead_yn,  NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.AE_BED_NO bed_no,d.current_status current_status,d.pseudo_bed_yn, null high_risk, null allergy, null result,A.SERVICE_CODE,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'"+locale+"'  ,'2') SERVICE_DESC,a.priority_indicator PATIENT_PRIORITY_NO,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"'    ,'2') PATIENT_PRIORITY_DESC,DECODE (a.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.pat_curr_locn_code,'"+locale+"'    ,'2'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.facility_id, a.pat_curr_locn_code,'"+locale+"'    ,'2'),                       OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"'    ,'1')) pat_curr_locn_desc,c.mr_location_code fs_locn_code,null reason_for_reserve,(SELECT count(*) FROM ae_bed_for_trmt_area WHERE occupied_until_date_time >= SYSDATE AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code AND bed_no = a.ae_bed_no AND facility_id = a.facility_id) counting from  ae_current_patient a, mp_patient b,op_clinic_lang_vw c,ae_bed_for_trmt_area d where a.facility_id = '"+facility_id+"'   and a.queue_status <= '07'  and  TRUNC(a.Queue_date) BETWEEN TRUNC(SYSDATE-1) AND SYSDATE  and a.patient_id = b.patient_id and c.language_id = '"+locale+"'     and a.locn_code = c.clinic_code and a.facility_id = c.facility_id and d.facility_id=a.facility_id AND a.locn_code=d.CLINIC_CODE AND a.TREATMENT_AREA_CODE=d.TREATMENT_AREA_CODE AND a.AE_BED_NO=d.bed_no  AND d.occupying_patient_id IS NOT NULL ");

		if(!bed_status.equals("O")){
		whereBuffer.append(" and d.EFF_STATUS = 'E' ");
		}

		if (!clinic_code.equals("")){
		    whereBuffer.append(" and a.locn_code = '"+clinic_code+"'");
 	    }
		if (!treatment_area.equals("")){
			whereBuffer.append(" and a.treatment_area_code = '"+treatment_area+"' ");
		}

		if (!practitioner_id1.equals("")){
			whereBuffer.append(" and a.practitioner_id = '"+practitioner_id1+"' ");
		}

		if (!patient_id1.equals("")){
			whereBuffer.append(" and a.patient_id = '"+patient_id1+"' ");
		}

        if (!priority1.equals("")){
			whereBuffer.append(" and a.priority_indicator = '"+priority1+"' ");
		}
		
		/*if(priority_zone.equals("R"))		whereBuffer.append(" and a.priority_zone = 'R' ");
		else if(priority_zone.equals("Y"))		whereBuffer.append(" and a.priority_zone = 'Y' ");
		else if(priority_zone.equals("G"))		whereBuffer.append(" and a.priority_zone = 'G' ");
		else if(priority_zone.equals("U"))		whereBuffer.append(" and a.priority_zone = 'U' ");*/
		
		
		if(!priority_zone.equals("")){
			whereBuffer.append(" and a.priority_zone = '"+priority_zone+"' ");
		}
		
		
		
		if(bed_status.equals("B") || bed_status.equals("R")){
		    cursor ="";
		}
		if(bed_status.equals("A")){
	     // whereBuffer.append("AND ( NVL(current_status, 'X') = '"+bed_status+"' or (NVL(current_status, 'X') = 'R' and sysdate >= occupied_until_date_time))");	
	     whereBuffer.append("AND( current_status = '"+bed_status+"' or (current_status = 'R' and sysdate >= occupied_until_date_time))");	
		}else if(bed_status.equals("R")){
	     // whereBuffer.append("AND ( NVL(current_status, 'X') = '"+bed_status+"' and (occupied_until_date_time>=sysdate))");	
	      whereBuffer.append("AND (current_status = '"+bed_status+"' and (occupied_until_date_time>=sysdate))");	
		}else if(bed_status.equals("O")){
 		   //whereBuffer.append(" AND NVL(current_status,'X') = '"+bed_status+"' ");
 		   whereBuffer.append(" AND current_status = '"+bed_status+"' ");

		}
		
		//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
		String hide_pat_unauth_pract = "N";
	   	String access_res_pat_yn = "N";
		String loginUser			= checkForNull((String)session.getValue("login_user"));
	    
	     pstmt = con.prepareStatement("select (select HIDE_PAT_UNAUTH_PRACT_YN from CA_PARAM_BY_FACILITY where facility_id = ?) hide_pat_unauth_pract_yn, (SELECT a.access_res_pat_yn FROM ca_access_view_restr_patient a WHERE a.practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = ?) AND a.facility_id = ? AND (   (    a.access_from_date IS NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) ))access_res_pat_yn from dual ");
	   	pstmt.setString(1, facility_id);
	   	pstmt.setString(2, loginUser);
	   	pstmt.setString(3, facility_id);
	   	rs = pstmt.executeQuery();
	   	rs.next();
	   	hide_pat_unauth_pract = checkForNull(rs.getString("hide_pat_unauth_pract_yn"),"N");
	   	access_res_pat_yn = checkForNull(rs.getString("access_res_pat_yn"), "N");
	  //  System.out.println(hide_pat_unauth_pract + " : hide_pat_unauth_pract; " +access_res_pat_yn + " : access_res_pat_yn");
	    if(pstmt!=null) pstmt.close();
	    if(rs!=null) rs.close();
	    
	    if(access_res_pat_yn.equals("N") && hide_pat_unauth_pract.equals("Y")){
			whereBuffer.append(" AND ((b.restrict_reinstate_yn = 'N' or b.restrict_reinstate_yn is null)  OR (b.restrict_reinstate_yn = 'Y' AND a.practitioner_id is null )) ");
	    }
	    
		//End of MMS-DM-CRF-0210
		
		if (!patient_id1.equals("")){
			queryBuffer1.append(" minus ");
		}else{
			queryBuffer1.append(" union "); 
		}
		
		//queryBuffer1.append(" SELECT null date_of_birth, a.clinic_code locn_code,b.long_desc locn_desc,null locn_type,a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.clinic_code, a.treatment_area_code,'"+locale+"'    ,'2') treatment_area_desc, null triage_area,null open_to_all_pract_yn,null practitioner_id, null practitioner_name, null practitioner_full_name ,null priority_indicator, c.priority_zone priority_zone, null queue_date_time, null check_in_date_time, null sys_date_time, null patient_id, null patient_name, null gender, 0 encounter_id,  null waiting_time, null queue_date1, null  assign_date,  null queue_status, null queue_status_desc, null trauma_yn, null brought_dead_yn,  null open_to_all_prac_for_clinic_yn, null patient_class, a.bed_no, a.current_status,a.pseudo_bed_yn, null high_risk,null allergy,null result ,null SERVICE_CODE, null SERVICE_DESC,null PATIENT_PRIORITY_NO,null PATIENT_PRIORITY_DESC,null PAT_CURR_LOCN_DESC, null fs_locn_code,substr(a.reason_for_reserve,1,30) reason_for_reserve from ae_bed_for_trmt_area a,op_clinic_lang_vw b, ae_tmt_area_for_clinic c where a.facility_id = '"+facility_id+"' and b.language_id = '"+locale+"'  and a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = c.facility_id and a.clinic_code = c.clinic_code and a.treatment_area_code = c.treatment_area_code ");Tuesday, June 01, 2010 pe_exe

		queryBuffer1.append(" SELECT null date_of_birth, a.clinic_code locn_code,b.long_desc locn_desc,null locn_type,a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.clinic_code, a.treatment_area_code,'"+locale+"'    ,'2') treatment_area_desc, null triage_area,null open_to_all_pract_yn,null practitioner_id, null practitioner_name, null practitioner_full_name ,null priority_indicator, c.priority_zone priority_zone, null queue_date_time, null check_in_date_time, null sys_date_time, null patient_id, null patient_name, null gender, 0 encounter_id,  null waiting_time, null queue_date1, null  assign_date,  null queue_status, null queue_status_desc, null trauma_yn, null brought_dead_yn,  null open_to_all_prac_for_clinic_yn, null patient_class, a.bed_no, a.current_status,a.pseudo_bed_yn, null high_risk,null allergy,null result ,null SERVICE_CODE, null SERVICE_DESC,null PATIENT_PRIORITY_NO,null PATIENT_PRIORITY_DESC,null PAT_CURR_LOCN_DESC, null fs_locn_code,substr(a.reason_for_reserve,1,30) reason_for_reserve,(SELECT count(*) FROM ae_bed_for_trmt_area WHERE occupied_until_date_time >= SYSDATE  AND clinic_code = a.clinic_code AND treatment_area_code = a.treatment_area_code AND bed_no = a.bed_no AND facility_id = a.facility_id) counting from ae_bed_for_trmt_area a,op_clinic_lang_vw b, ae_tmt_area_for_clinic c where a.facility_id = '"+facility_id+"' and b.language_id = '"+locale+"'  and a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = c.facility_id and a.clinic_code = c.clinic_code and a.treatment_area_code = c.treatment_area_code ");


		whereBuffer1.append(" and a.EFF_STATUS = 'E' ");
		
		if (!clinic_code.equals("")){
			whereBuffer1.append(" and a.clinic_code = '"+clinic_code+"'");
  	    }
		
		if (!treatment_area.equals("")){
			whereBuffer1.append(" and a.treatment_area_code = '"+treatment_area+"' ");
		}
		if (!patient_id1.equals("")){
			whereBuffer1.append(" and a.occupying_patient_id = '"+patient_id1+"' ");
		}else{
			whereBuffer1.append(" and a.occupying_patient_id is null ");
		}
		
	   /* if(priority_zone.equals("R"))		whereBuffer1.append(" and c.priority_zone = 'R' ");
		else if(priority_zone.equals("Y"))		whereBuffer1.append(" and c.priority_zone = 'Y' ");
	    else if(priority_zone.equals("G"))		whereBuffer1.append(" and c.priority_zone = 'G' ");*/
	    if(!priority_zone.equals("")){
	    	whereBuffer1.append(" and c.priority_zone = '"+priority_zone+"' ");
	    }
		
		if(bed_status.equals("A")){
		//  whereBuffer1.append("AND ( NVL(a.current_status, 'X') = '"+bed_status+"' or (NVL(a.current_status, 'X') = 'R' and sysdate >= a.occupied_until_date_time))");	
		  whereBuffer1.append("AND ( a.current_status= '"+bed_status+"' or (a.current_status = 'R' and sysdate >= a.occupied_until_date_time))");	
		}else if(bed_status.equals("R")){
         // whereBuffer1.append("AND ( NVL(a.current_status, 'X') = '"+bed_status+"' and (a.occupied_until_date_time>=sysdate))");	
           whereBuffer1.append("AND (a.current_status = '"+bed_status+"' and (a.occupied_until_date_time>=sysdate))");	
		}else if(bed_status.equals("O")){
 		  // whereBuffer1.append(" AND NVL(a.current_status,'X') = '"+bed_status+"' ");
 		   whereBuffer1.append(" AND a.current_status= '"+bed_status+"' ");
		}
		whereBuffer1.append("order by locn_desc, locn_code, treatment_area_desc, treatment_area_code  ,bed_no  ");		
		queryBuffer.append(whereBuffer.toString());
		queryBuffer1.append(whereBuffer1.toString());
		queryBuffer.append(queryBuffer1.toString());

        StringBuffer TableStr = new StringBuffer();
        StringBuffer tip = new StringBuffer();
        TableStr.append("<form name='query_form' id='query_form'><table  cellpadding=1 cellspacing=1 align='left' border='0' width='100%'  >");
		int max_count	= 0;

		// Tuesday, June 01, 2010 pe_exe pstmt			= con.prepareStatement(queryBuffer.toString());
		//rs				= pstmt.executeQuery();
		//while(rs!=null && rs.next()) 	{
			//max_count ++;
		//}

		//if(max_count == 0) {

            _bw.write(_wl_block9Bytes, _wl_block9);

		//}  else 	{
		    stmt   = con.createStatement() ;
			rs     = stmt.executeQuery(queryBuffer.toString()) ;
		
			//if(rs!=null && rs.next()) {Tuesday, June 01, 2010 pe_exe	
			    String clinic_desc				=  ""; 
				String treatment_area_code		=  ""; 
				String trmt_area_short_desc		=  ""; 
				String pseudo_bed_yn			=  ""; 
				String patient_name				=  ""; 
				String date_of_birth			=  ""; 
				String current_status			=  ""; 
				String nationality_short_desc	=  ""; 
				String butt_color 				=  "";
				String butt_color_borderless	=  "";
				String placeholder 				=  "";
				String clinic_type				=  "";
				String queue_status				=  "";
				String encounter_id				=  "";
				String triage_area				=  "";
				String trauma_yn				=  "";
				String practitioner_id			=  "";
				String practitioner_full_name	=  "";
				String open_to_all_prac_for_clinic_yn=  "";
				String queue_date_time			=  "";
				String sys_date_time			=  "";
				String queue_date				=  "";
				String brought_dead_yn			=  "";
				String assign_tmt_area_time		=  "";
				String open_to_all_pract_yn		=  "";
				String patient_class			=  "";
				String highrisk					=  "";
				String allergy					=  "";
				String result					=  "";
				String occupyDateValid			=	"N";
				int maxRecord					=	0;
				int count_buttn					=	0;
	            tip.setLength(0);

				while(rs.next())  {
					max_count++;
					occupyDateValid = "N";
					clinic_code					= checkForNull(rs.getString("locn_code")) ;
					clinic_desc					= checkForNull(rs.getString("locn_desc")) ;
					treatment_area_code			= checkForNull(rs.getString("treatment_area_code")) ;
		            priority_zone				= checkForNull(rs.getString("priority_zone")) ;
					trmt_area_short_desc		= checkForNull(rs.getString("treatment_area_desc")) ;
					bed_no						= checkForNull(rs.getString("bed_no")) ;
					pseudo_bed_yn				= checkForNull(rs.getString("pseudo_bed_yn")) ;
				
					if(pseudo_bed_yn.equals("")) pseudo_bed_yn="N";
					patient_id					= checkForNull(rs.getString("patient_id")) ;
					patient_name				= checkForNull(rs.getString("patient_name")) ;
					gender						= checkForNull(rs.getString("gender")) ;
					date_of_birth				= checkForNull(rs.getString("date_of_birth")) ;
					current_status				= checkForNull(rs.getString("current_status")) ;
					clinic_type					= checkForNull(rs.getString("locn_type")) ;
					queue_status				= checkForNull(rs.getString("queue_status")) ;
					encounter_id				= checkForNull(rs.getString("encounter_id")) ;
					triage_area					= checkForNull(rs.getString("triage_area")) ;
					trauma_yn					= checkForNull(rs.getString("trauma_yn")) ;
					practitioner_id				= checkForNull(rs.getString("practitioner_id")) ;
					practitioner_full_name		= checkForNull(rs.getString("practitioner_full_name")) ;
					open_to_all_prac_for_clinic_yn= checkForNull(rs.getString("open_to_all_prac_for_clinic_yn")) ;
					queue_date_time				= checkForNull(rs.getString("queue_date_time")) ;
					sys_date_time				= checkForNull(rs.getString("sys_date_time")) ;
					queue_date					= checkForNull(rs.getString("queue_date1")) ;
					brought_dead_yn				= checkForNull(rs.getString("brought_dead_yn")) ;
					assign_tmt_area_time		= checkForNull(rs.getString("assign_date")) ;
					open_to_all_pract_yn		= checkForNull(rs.getString("open_to_all_pract_yn")) ;
					patient_class				= checkForNull(rs.getString("patient_class")) ;
					highrisk					= checkForNull(rs.getString("high_risk")) ;
					allergy						= checkForNull(rs.getString("allergy")) ;
					result						= checkForNull(rs.getString("result")) ;

					SERVICE_DESC				= checkForNull(rs.getString("SERVICE_DESC")) ;
					PAT_CURR_LOCN_DESC			= checkForNull(rs.getString("PAT_CURR_LOCN_DESC")) ;
					fs_locn_code				= checkForNull(rs.getString("fs_locn_code")) ;
					reason_for_reserve			= checkForNull(rs.getString("reason_for_reserve")) ;
					maxRecord					= rs.getInt("counting");
                         	
					/*pstat  = con.prepareStatement("select (1) from ae_bed_for_trmt_area where occupied_until_date_time >= sysdate and clinic_code = ? and treatment_area_code = ?   and bed_no = ? and facility_id = ?");
				Tuesday, June 01, 2010 pe_exe

				    pstat.setString(1, clinic_code);
				    pstat.setString(2, treatment_area_code);
				    pstat.setString(3, bed_no);
				    pstat.setString(4, facility_id);
					maxRecord=0;			
                    rs1 = pstat.executeQuery();
                    if (rs1!=null)  {
						while (rs1.next()) {
                            maxRecord = rs1.getInt(1);
                        }
			        }
		            if(rs1!=null) rs1.close();
					if (pstat != null) pstat.close();
					*/
				    if (!(maxRecord==0)) {
						occupyDateValid="Y";
					}
					          
					butt_color 					=	"IP_GreenButton";
					placeholder					=	"";
					disp_content1				=	"";
					disp_content				=	"";
					tip.setLength(0);
					placeholder					=	"";
					info						=	"";
					String info1				=	"";
						
					highrisk					= checkForNull(rs.getString("high_risk")) ;
					allergy						= checkForNull(rs.getString("allergy")) ;
					result						= checkForNull(rs.getString("result")) ;

					if(! highrisk.equals("")){
						info=highrisk+"/" ;
						info1=highrisk+"/" ;							
					}else{
						info1="/" ;
					}
					if(! allergy.equals("")){
						info=info+allergy+"/" ;
						info1=info1+allergy+"/" ;							
					}else{
						info1=info1+"/" ;
					}

					if(! result.equals("")){
						info=info+result+"/" ;	
						info1=info1+result+"/" ;							
					}else{
						info1=info1+"/" ;
					}
						
					if(info.length()>0)
						info	=info.substring(0,info.length()-1);
					placeholder = specialCharacter(bed_no);
					tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+" ^^"+placeholder+"<br>");
					disp_content1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.BedBay.label","ae_labels") + " " + placeholder+" " ;
					placeholder = "";
					placeholder = specialCharacter(clinic_desc);
					tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+" ^^"+placeholder+"<br>");
					placeholder = ""; 
					placeholder = specialCharacter(trmt_area_short_desc);
					tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.treatmentarea.label","common_labels")+" ^^"+placeholder+"<br>");
						 
					if ((current_status.equals("O")) ||  ((current_status.equals("R")))) {			
						placeholder = "";
						placeholder = specialCharacter(patient_id);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")	+"^^"+placeholder+"<br>");
												
						if(current_status.equals("O") || current_status.equals("R") ){ 	}
 
		               	disp_content=" ";
						placeholder = "";
						placeholder = specialCharacter(patient_name);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")	+" ^^"+placeholder+"<br>");
						if(placeholder != null && placeholder.length() >27){
							String tmp="";
							tmp=placeholder.substring(0,27);
							disp_content=" "+tmp+"<br>" ;
						}else{
							disp_content=" "+placeholder+"<br>" ;
						}

						placeholder = "";
						placeholder = specialCharacter(gender);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")	+" ^^"+placeholder+"<br>");
						disp_content=disp_content+placeholder +"<br>";
	
						disp_content=disp_content+SERVICE_DESC+"<br>" ;
						disp_content=disp_content+PAT_CURR_LOCN_DESC+"<br>" ;
						if((!reason_for_reserve.equals("")) && (current_status.equals("R")) && (occupyDateValid.equals("Y"))) {
							disp_content=disp_content+reason_for_reserve+"<br>" ;
					    }
	
						if(! info.equals("")){
							disp_content=disp_content+"<br>" + info;
						} 
					 
						placeholder = "";
						placeholder = specialCharacter(date_of_birth);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")	+" ^^"+placeholder+"<br>");
						placeholder = "";
						placeholder = specialCharacter(nationality_short_desc);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels")	+" ^^"+placeholder+"<br>");
					}
						
					if((current_status.equals("A")|| 
					(current_status.equals("R")&& occupyDateValid.equals("N"))
					) && (pseudo_bed_yn.equals("Y")) ) {
						butt_color = "AE_LIGHTGREEN";
						butt_color_borderless="AE_LIGHTGREEN_borderless";
					}
					if ((current_status.equals("O")) && (pseudo_bed_yn.equals("Y"))) {
						butt_color = "AE_LIGHTPINK"; 
						butt_color_borderless="AE_LIGHTPINK_borderless";
					}
					if((current_status.equals("A")|| 
					(current_status.equals("R")&& occupyDateValid.equals("N"))
					) && (pseudo_bed_yn.equals("N")) ) {
						butt_color = "AE_green";
						butt_color_borderless="AE_green_borderless";
					}
					if ((current_status.equals("O")) && (pseudo_bed_yn.equals("N"))) {
							butt_color = "AE_RedButton";
							butt_color_borderless="AE_RedButton_borderless";
					}
						
					if((current_status.equals("R")) && (occupyDateValid.equals("Y"))) {
						butt_color = "AE_brown";
						butt_color_borderless="AE_brown_borderless";
					}
					if(current_status.equals("O")){ }
					if(current_status.equals("R")  && bed_status.equals("A") ) {
    					if((pseudo_bed_yn.equals("N"))){
								butt_color = "AE_green";
								butt_color_borderless="AE_green_borderless";
						}
						if((pseudo_bed_yn.equals("Y"))){
							butt_color = "AE_LIGHTGREEN";
							butt_color_borderless="AE_LIGHTGREEN_borderless";
						}
						current_status="A";
					
					}
					if(!bed_no.equals(""))  {
				        if(treatment_area_code.equals(treatment_area_code_prev)){
					}else{ 
						String header = "" ;
						header			 = clinic_desc +"/"+ trmt_area_short_desc;
						treatment_area_code_prev=treatment_area_code;
						TableStr.append("<tr><td colspan=4><table width='100%' border=0><th class='GROUPING' align='left' width='100%' colspan=4> "+ header +"</th></table></td></tr><tr>");
						bed_col_num = 1;
					}
					TableStr.append("<td align=left  valign='abstop' class='"+butt_color+"' Border  width='25%' height='80'><table border=0 width='100%' cellpadding=0 cellspacing=0 >");

					TableStr.append("<tr ><td    class='"+butt_color_borderless+"' style='"+cursor+"' onclick='closeWin(\""+bed_no+"\",\""+butt_color+"\",\""+clinic_code+"\",\""+specialCharacter(clinic_desc)+"\",\""+clinic_type+"\",\""+patient_id+"\",\""+priority_zone+"\",\""+queue_status+"\",\""+encounter_id+"\",\""+triage_area+"\", \""+trauma_yn+"\",\""+treatment_area_code+"\",\""+practitioner_id+"\",\""+specialCharacter(practitioner_full_name)+"\",\""+specialCharacter(trmt_area_short_desc)+"\",\""+open_to_all_prac_for_clinic_yn+"\",\""+queue_date_time+"\",\""+sys_date_time+"\", \""+queue_date+"\",\""+gender+"\",\""+brought_dead_yn+"\",\""+assign_tmt_area_time+"\",\""+open_to_all_pract_yn+"\",\""+patient_class+"\",\""+current_status+"\",\""+date_of_birth+"\",\""+fs_locn_code+"\",\""+specialCharacter(patient_name)+"\",\""+info1+"\",\""+pseudo_bed_yn+"\");'>"+disp_content1+"</td></tr>");  

			
				    TableStr.append("<tr><td class='"+butt_color_borderless+"' align=left ><a href= javascript:pat_click(\""+patient_id+"\",\""+encounter_id+"\")><b><font size=1.5>"+patient_id+"</font></b></a></td></tr>");

					TableStr.append("<tr><td  colspan='1'   class='"+butt_color_borderless+"' style='"+cursor+"' onclick='closeWin(\""+bed_no+"\",\""+butt_color+"\",\""+clinic_code+"\",\""+specialCharacter(clinic_desc)+"\",\""+clinic_type+"\",\""+patient_id+"\",\""+priority_zone+"\",\""+queue_status+"\",\""+encounter_id+"\",\""+triage_area+"\", \""+trauma_yn+"\",\""+treatment_area_code+"\",\""+practitioner_id+"\",\""+specialCharacter(practitioner_full_name)+"\",\""+specialCharacter(trmt_area_short_desc)+"\",\""+open_to_all_prac_for_clinic_yn+"\",\""+queue_date_time+"\",\""+sys_date_time+"\", \""+queue_date+"\",\""+gender+"\",\""+brought_dead_yn+"\",\""+assign_tmt_area_time+"\",\""+open_to_all_pract_yn+"\",\""+patient_class+"\",\""+current_status+"\",\""+date_of_birth+"\",\""+fs_locn_code+"\",\""+specialCharacter(patient_name)+"\",\""+info1+"\",\""+pseudo_bed_yn+"\");' >"+disp_content+"</td></tr>");

			
					TableStr.append("</table></td> ");
					
					if ( bed_col_num == 4) {
					    bed_col_num = 0;
					    TableStr.append("</tr><tr>");
				    }
        			bed_col_num++ ;
				    count_buttn++ ;
					
			        }	// if bed!=null loop						
	            }//while main loop

/****************************************/

	            for(int i=bed_col_num; i<=4;i++ ){
                    String pseudo="";

                    TableStr.append("<td align=left  valign='abstop' class=IP_WHITE Border  ><table border=0 cellpadding=0 cellspacing=0  width='100%'>");
	
	                TableStr.append("<tr><td  class=IP_WHITE style='"+cursor+"' >"+pseudo+"</td><td class=IP_WHITE colspan=1 align=left ></td></tr>");
	                TableStr.append("</table></td>");
	            }
/***********/	

			//}else{
				if(max_count==0){
					
            _bw.write(_wl_block10Bytes, _wl_block10);

				}

			//}
			TableStr.append("</tr>");
		//}
		//CAInstalled="N";
		TableStr.append("<input type='hidden' name='CAInstalled' id='CAInstalled' value='"+CAInstalled+"' >");
		
		TableStr.append("<input type='hidden' name='increasedaddressLength' id='increasedaddressLength' value='"+increasedaddressLength+"' >"); //Added for ML-MMOH-CRF-0860.2
				
		TableStr.append("</form>");
		out.print(TableStr.toString());
	
		whereBuffer.setLength(0);
		whereBuffer1.setLength(0); 
		queryBuffer.setLength(0);
		queryBuffer1.setLength(0); 
		TableStr.setLength(0); 

        if (rs != null) rs.close();
		if (stmt != null) stmt.close();

	
	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();}
	finally {
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
