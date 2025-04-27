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
import java.util.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __dischargeadvicemain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeAdviceMain.jsp", 1733139276464L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'</link>\n\t<script language=\'javascript\' src=\'../js/CancelAdmission.js\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\n\n<iframe name=\'PLINE\' id=\'PLINE\' SRC=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Facility_Id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' noresize  frameborder=no scrolling=\'no\' style=\'height:8vh;width:100vw\'></iframe><iframe name=\'f_query_add_mod_display\' id=\'f_query_add_mod_display\' \t src=\'addmodifyDischargeAdvice.jsp?jsp_name=&win_height=1&win_width=33&EncounterId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&patient_class=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patient_Id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&admissiondatetime=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&admissiontypedesc=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&specialtyshortdesc=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&practitionername=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nursingunitshortdesc=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&serviceshortdesc=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&bedno=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&roomno=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&bedclassshortdesc=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&bed_type_desc=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&weight_on_admission=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&weight_on_admission_unit=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&weight_on_admission_unit_display=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&is_validate_weight_on_admission=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&is_value_already_captured=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&height_on_admission=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&height_on_admission_unit=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&is_validate_height_on_admission=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&bmi=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&enable_height_bmi_pat_cls=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&is_value_already_captured_height=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:33vh;width:100vw\'></iframe> \n\t<!--Maheshwaran K added patient_Id for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013--><!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\'AddModifyDischargeAdvTabs.jsp?jsp_name=&win_height=1&win_width=40&EncounterId=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&leave_exp_dt_flag=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&practitioner_id=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&spltycode=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&patienttype=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nursingunitcode=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&gender=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&DOB=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&expdischargedatetime=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&patient_status=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&patient_age=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&&mlc_yn=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&pol_rep_no_vw=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&pol_stn_id_vw=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&pol_id_vw=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&function_id=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&modified_date_val=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&setup_bl_dtls_in_ip_yn=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&allow_discharge_date_predc=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&max_disch_period_for_predc=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&mother_cut_off_age_pda=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&mother_max_age_pda=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&pat_dtls_unknown_yn_pda=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&contact1_name_pda=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&contact2_name_pda=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:54vh;width:100vw\'></iframe> \n\n\t<iframe name=\'f_query_add_mod_button\' id=\'f_query_add_mod_button\' \t    src=\'AddModifyDischargeAdvButtons.jsp?jsp_name=&win_height=1&win_width=40&patient_Id=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:5vh;width:100vw\'></iframe>\n\t\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:0vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame1\' id=\'messageFrame1\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:0vh;width:100vw\'></iframe>\n\t\n</html>\n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	String locale			= (String)session.getAttribute("LOCALE");
	
	Connection con			=	null;
	Statement stmt			=	null;
	ResultSet rs			=	null;
	StringBuffer SqlSB = new StringBuffer();
	String facilityID		= (String)session.getValue("facility_id");
	String encounterid		= checkForNull(request.getParameter("encounterId"));
	String patient_Id		= checkForNull(request.getParameter("patientId"));
	String leave_exp_dt_flag= checkForNull(request.getParameter("leave_exp_dt_flag"));
	String function_id= checkForNull(request.getParameter("function_id"));
	String setup_bl_dtls_in_ip_yn			= checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"));
	String bl_interfaced_yn						= checkForNull(request.getParameter("bl_interfaced_yn"));
	String allow_discharge_date_predc	= checkForNull(request.getParameter("allow_discharge_date_predc"));
	String max_disch_period_for_predc	= checkForNull(request.getParameter("max_disch_period_for_predc"));
	String mother_cut_off_age_pda		= checkForNull(request.getParameter("mother_cut_off_age_pda"));
	String mother_max_age_pda				= checkForNull(request.getParameter("mother_max_age_pda"));
	String pat_dtls_unknown_yn_pda		= checkForNull(request.getParameter("pat_dtls_unknown_yn_pda"));
	String contact1_name_pda				= checkForNull(request.getParameter("contact1_name_pda"));
	String contact2_name_pda				= checkForNull(request.getParameter("contact2_name_pda"));
	String admissiondatetime	= "";
	String admissiontypedesc	= "";
	String specialtyshortdesc	= "";
	String practitionername		= "";
	String nursingunitshortdesc = "";
	String serviceshortdesc		= "";
	String bedno				= "";
	String roomno				= "";
	String bedclassshortdesc	= "";
	String bed_type_desc		= "";
	String practitioner_id		= "";
	int patient_age				= 0;
	String spltycode			= "";
	String patienttype 			= "";
	String nursingunitcode 		= "";
	String gender				= "";
	String DOB					= "";
	String expdischargedatetime = "";
	String patient_class		= "";
	String patient_status		= "";
	String pol_rep_no_vw		= "";
	String pol_stn_id_vw		= ""; 
	String pol_id_vw			= "";
	String mlc_yn				= "";
	String modified_date_val	= "" ;

	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
	String age								= "";
	String weight_on_admission				= "";
	String weight_on_admission_unit			= "";
	String weight_on_admission_unit_display	= "";
	String weight_on_admn_mandatory			= checkForNull(request.getParameter("weight_on_admn_mandatory"));
	String is_value_already_captured		= "";
	int no_of_days							= 0;
	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= "";
	String height_on_admission_unit			= "";
	String height_on_admn_mandatory         = "";
	String enable_height_bmi_pat_cls        = "";
	String bmi="";
	String is_value_already_captured_height="";
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527  END*/

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();

		SqlSB.append(" SELECT TO_CHAR(a.admission_date_time,'dd/mm/rrrr HH24:mi') admission_date_time,");
		SqlSB.append(" b.sex gender, ");
		SqlSB.append(" TO_CHAR (a.exp_discharge_date_time,'dd/mm/rrrr HH24:mi') exp_discharge_date_time,");
		SqlSB.append(" IP_GET_DESC.IP_ADMISSION_TYPE(a.admission_type,'"+locale+"','2') admission_short_desc, a.specialty_code, ");
		SqlSB.append(" AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specialty_short_desc, ");
		SqlSB.append(" a.attend_practitioner_id practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,'"+locale+"','1') practitioner_name, null patient_type_short_desc,");
		SqlSB.append(" a.nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, ");
		SqlSB.append(" AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') service_short_desc, a.bed_num bed_no, a.room_num room_no, a.patient_class, a.oth_adt_status, ");
		SqlSB.append(" to_char(b.date_of_birth,'dd/mm/rrrr') date_of_birth,");
		SqlSB.append(" calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/rrrr'),1) patient_age,");
		SqlSB.append(" IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc, IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc, ");
		SqlSB.append(" a.pol_rep_no, a.pol_stn_id, a.pol_id, a.mlc_yn ");
		SqlSB.append(" , to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date  ");
		SqlSB.append(" ,a.height_on_admission,a.bmi ");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
		SqlSB.append(" , get_age(b.DATE_OF_BIRTH) age,a.weight_on_admission,a.weight_on_admission_unit,trunc (sysdate) - trunc (b.DATE_OF_BIRTH) no_of_days  ");//Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541] 
		
		SqlSB.append(" FROM ");
		SqlSB.append(" IP_OPEN_ENCOUNTER a, mp_patient b ");
		SqlSB.append(" WHERE ");
		SqlSB.append(" a.facility_id = '"+facilityID+"' ");
		SqlSB.append(" AND a.encounter_id ='"+encounterid+"' ");
		SqlSB.append(" AND a.patient_id = b.patient_id ");

		rs=stmt.executeQuery(SqlSB.toString());
		if(rs.next())
		{
			admissiondatetime 	= checkForNull(rs.getString("admission_date_time"));
			admissiontypedesc 	= checkForNull(rs.getString("admission_short_desc"));
			specialtyshortdesc 	= checkForNull(rs.getString("specialty_short_desc"));
			practitionername 	= checkForNull(rs.getString("practitioner_name"));
			nursingunitshortdesc= checkForNull(rs.getString("Nursing_unit_short_desc"));
			serviceshortdesc 	= checkForNull(rs.getString("service_short_desc"));
			bedno 				= checkForNull(rs.getString("bed_no"));
			roomno 				= checkForNull(rs.getString("room_no"));
			bedclassshortdesc 	= checkForNull(rs.getString("bed_class_short_desc"));
			bed_type_desc		= checkForNull(rs.getString("bed_type_short_desc"));
				session.putValue("practitioner_name",practitionername);
			practitioner_id		= checkForNull(rs.getString("practitioner_id"));
			patient_age			= Integer.parseInt(rs.getString("patient_age"))	;
			spltycode			= checkForNull(rs.getString("specialty_code"));
			patienttype 		= checkForNull(rs.getString("patient_type_short_desc"));
			nursingunitcode 	= checkForNull(rs.getString("nursing_unit_code"));
			gender				= checkForNull(rs.getString("gender"));
			DOB					= checkForNull(rs.getString("date_of_birth"));
			expdischargedatetime= checkForNull(rs.getString("exp_discharge_date_time"));
			patient_class		= checkForNull(rs.getString("patient_class"));
			patient_status		= checkForNull(rs.getString("OTH_ADT_STATUS"));
			mlc_yn				= checkForNull(rs.getString("MLC_YN"),"N");
			pol_rep_no_vw		= checkForNull(rs.getString("POL_REP_NO"));
			pol_stn_id_vw		= checkForNull(rs.getString("POL_STN_ID"));
			pol_id_vw			= checkForNull(rs.getString("POL_ID"));
			modified_date_val   = checkForNull(rs.getString("modified_date"));
			
			/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
			age  				= checkForNull(rs.getString("age"));
			weight_on_admission			= checkForNull(rs.getString("weight_on_admission"));
			weight_on_admission_unit	= checkForNull(rs.getString("weight_on_admission_unit"));
			no_of_days					= rs.getInt("no_of_days");
			/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/

			/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
			height_on_admission			= checkForNull(rs.getString("height_on_admission"));
			bmi			= checkForNull(rs.getString("bmi"));
			/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END*/
		}
		if (rs != null)		rs.close();
		if (stmt != null)	stmt.close();
		/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/

		if(weight_on_admn_mandatory.equals("")){//If discharge advise called from CA.
			stmt=con.createStatement();
			rs=stmt.executeQuery("select WEIGHT_ON_ADMN_MANDATORY from ip_param where facility_id = '"+facilityID+"'");
			if(rs.next()){
				weight_on_admn_mandatory	= checkForNull(rs.getString("weight_on_admn_mandatory"));
			}
			
		}
		if (rs != null)		rs.close();
		if (stmt != null)	stmt.close();
		
		String is_validate_weight_on_admission	= (weight_on_admn_mandatory.equals("P")?"Y":"N");
		
		
		
		if(weight_on_admission.equals("") && weight_on_admission_unit.equals("")){
			/*String lastchar	="";
			int calculate_age	= 0;
			if (age.length() > 0 ){
				lastchar		= age.substring(age.length() - 1);
				if (!age.contains("Y"))
					calculate_age	= Integer.parseInt(age.substring(0, age.length()-1));
			}
			weight_on_admission_unit	= (lastchar.equals("D")?(calculate_age >30 ? "K":"G"):"K");*/
			weight_on_admission_unit	= (no_of_days >30 ? "K":"G");
		}else{
			is_value_already_captured	= "Y";
		}
		weight_on_admission_unit_display	= (weight_on_admission_unit.equals("G")?"Gram":"Kg");
		/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/

		/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527  Start*/
		if(height_on_admn_mandatory.equals("")||enable_height_bmi_pat_cls.equals("")){//If discharge advise called from CA.
			stmt=con.createStatement();
			rs=stmt.executeQuery("select HEIGHT_ON_ADMN_MANDATORY,ENABLE_HEIGHT_BMI_PAT_CLS from ip_param where facility_id = '"+facilityID+"'");
			if(rs.next()){
				 height_on_admn_mandatory	= checkForNull(rs.getString("height_on_admn_mandatory"));
				 enable_height_bmi_pat_cls	= checkForNull(rs.getString("enable_height_bmi_pat_cls"));
			}
		}
		if (rs != null)		rs.close();
		if (stmt != null)	stmt.close();
		String is_validate_height_on_admission = (height_on_admn_mandatory.equals("P")?"Y":"N");
		if(height_on_admission.equals("") && height_on_admission_unit.equals("")){
			height_on_admission_unit	= ("Cm");
		}
		else{
			is_value_already_captured_height	= "Y";
		}
		/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527  End*/


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterid)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterid)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_Id)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiondatetime)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitionername,"UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedno,"UTF-8")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(roomno,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type_desc,"UTF-8")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(weight_on_admission));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(weight_on_admission_unit));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(weight_on_admission_unit_display));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(is_validate_weight_on_admission));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(is_value_already_captured));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(height_on_admission));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(height_on_admission_unit));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(is_validate_height_on_admission));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(is_value_already_captured_height));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterid)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_Id)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(leave_exp_dt_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiondatetime)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(admissiontypedesc,"UTF-8")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialtyshortdesc,"UTF-8")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitionername,"UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitshortdesc,"UTF-8")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(serviceshortdesc,"UTF-8")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedno,"UTF-8")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(roomno,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedclassshortdesc,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type_desc,"UTF-8")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_id)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(java.net.URLEncoder.encode(spltycode)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(patienttype)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitcode)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(gender)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(DOB)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(java.net.URLEncoder.encode(expdischargedatetime)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_status)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(java.net.URLEncoder.encode(mlc_yn)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(java.net.URLEncoder.encode(pol_rep_no_vw)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(java.net.URLEncoder.encode(pol_stn_id_vw)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(java.net.URLEncoder.encode(pol_id_vw)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(modified_date_val)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(allow_discharge_date_predc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(mother_cut_off_age_pda));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(mother_max_age_pda));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(pat_dtls_unknown_yn_pda));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(contact1_name_pda));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(contact2_name_pda));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_Id)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitcode)));
            _bw.write(_wl_block62Bytes, _wl_block62);

	}catch(Exception e) 
	{
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrepareDischargeAdvice.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
