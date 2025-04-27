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

public final class __paintcanceldischargepatient extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PaintCancelDischargePatient.jsp", 1731495118777L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title><script src=\'../../eIP/js/CancelDischarge.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<style>\n\t\tbody {\n\t\t\tdisplay: block;\n\t\t    margin: 0px;\n\t\t}\n\t</style>\n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t\t<!-- IP_17591  <frameset id=\'cancel_discharge_frame\' rows=\'2.5,8,14,2,2\' border=0> Wednesday, December 23, 2009\t-->\n\t\t<iframe name=\"PatientLine_frame\" id=\"PatientLine_frame\" src=\"../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\n\t\t<!--<frame name=\"Transfer_frame_display\" id=\"Transfer_frame_display\" src=\"addModifyDischargePatient.jsp?encounter_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&admission_date_time=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&admission_short_desc=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&specialty_short_desc=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&practitioner_name=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nursing_unit_short_desc=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&service_short_desc=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&bed_no=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&room_no=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&bed_class_short_desc=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&practitioner_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&bed_type_desc=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&medteamid=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&medteamdesc=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" scrolling=\'no\' noresize>-->\n\t\t<!--Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527-->\n\t\t<!--Modified by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start-->\n\t\t<iframe name=\"Transfer_frame_display\" id=\"Transfer_frame_display\" src=\"addModifyDischargePatient.jsp?encounter_id=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&weight_on_admission=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&patient_class=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&weight_on_admission_unit=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&weight_on_admission_unit_display=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&height_on_admission=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&height_on_admission_unit=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&bmi=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" scrolling=\'auto\' noresize style=\'height:33vh;width:100vw\'></iframe>\n\t\t<!--Modified by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End-->\n\t\t<!--Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527-->\n\t\t<iframe name=\"Transfer_frame\" id=\"Transfer_frame\" src=\"addModifyCancelDischargePatientTabs.jsp?encounter_id=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&to_ref_code=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&to_specialty_code=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&to_service_code=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&to_locn_type=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&post_mortem_req_yn=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&to_locn_code=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&med_lgl_case_yn=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&informed_to=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&informed_date_time=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&patient_type_short_desc=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&patient_id=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&bed_type_code=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&bed_class_code=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&specialty_code=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&auth_practitioner_id=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&auth_practitioner_name=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nursing_unit_code=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&discharge_type_desc=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&service_code=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&patient_type=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&gender=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&date_of_birth=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&locn_type=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&patient_status=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&absconded_date=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&absconded_yn=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&discharge_date_time=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&EXPECTED_DISCHARGE_DATE=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&deceased_date_time=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&discharge_summary_yn=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&take_home_new_med_yn=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&discharge_type_code=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&last_encounter_inform_to=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&last_encounter_inform_name=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&last_encounter_inform_date_time=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&blocking_type_code=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&high_risk_body_yn=";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&body_release_date_time=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="&discharge_date=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&assign_care_locn_type=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="&admission_type=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="&disposition_type=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="&referral_id=";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="&discharge_status_code=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="&function_id=";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" scrolling=\'auto\' noresize style=\'height:40vh;width:100vw\'></iframe>\n\n\t\t<iframe name=\"Transfer_frame_buttons\" id=\"Transfer_frame_buttons\" src=\"addModifyDischargePatientButtons.jsp?encounter_id=encounterid&";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" scrolling=\'no\' noresize style=\'height:5vh;width:100vw\'></iframe>\n\t\t<iframe src=\"../../eCommon/jsp/error.jsp\" name=\"message_frame\" id=\"message_frame\" scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t<!--<frame src=\"../../eCommon/jsp/error.jsp\" name=\"msg_frame\" id=\"msg_frame\" scrolling=\'yes\' noresize>-->\n</html>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\n\n\n\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

	// By Sridhar R  March 8th 2005, to handle NullPointerException.
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

request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
String locale			= (String)session.getAttribute("LOCALE");
 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	String facilityId = (String)session.getValue("facility_id");
	String encounterid				= checkForNull(request.getParameter("encounterId"));
	String patient_id				= checkForNull(request.getParameter("patientId"));
	String practitioner_id			= checkForNull(request.getParameter("Practitioner_Id"));
	//String call_function			= checkForNull(request.getParameter("call_function"));
	String function_id				= checkForNull(request.getParameter("function_id"));
	
	String  auth_practitioner_id	= "";
	String  auth_practitioner_name	= "";
	String specialty_code			= "";
	String bed_type_desc			= "";
	String locn_type				= "";
	String admission_date_time		= "";
	String admission_short_desc		= ""; 
	String specialty_short_desc		= ""; 
	String practitioner_name		= "";
	String patient_type_short_desc	= "";
	String nursing_unit_short_desc	= "";
	String service_short_desc		= "";
	String bed_no					= "";
	String room_no					= "";
	String bed_class_short_desc		= "";
	String bed_type_code			= "";
	String bed_class_code			= "";
	String nursing_unit_code		= "";
	String service_code				= "";
	String patient_type				= "";
	String gender					= "";
	String to_ref_code				= "";
	String to_specialty_code		= "";
	String to_service_code			= "";
	String to_locn_type				= "";
	String to_locn_code				= "";
	String post_mortem_req_yn		= "";
	String med_lgl_case_yn			= "";
	String informed_to				= "";
	String informed_date_time		= "";
	String informed_name			= "";
	String pol_rep_no				= "";
	String pol_stn_id				= "";
	String pol_id					= "";
	String discharge_narration		= "";
	String date_of_birth			= "";
	String patient_class			= "";
	String patient_status			= "";
	String absconded_date			= "";
	String absconded_yn				= "";
	String reported_to				= "";
	String EXPECTED_DISCHARGE_DATE  = "";
	String discharge_date_time		= "";
	String	discharge_type_desc		= "";
	String medteamdesc 				= "";
	String medteamid 				= "";
	String deceased_date_time		= "";
	String discharge_summary_yn		= "";
	String take_home_new_med_yn     = "";
	String discharge_type_code      = "";
	String last_encounter_inform_to	= "";
	String last_encounter_inform_name	= "";
	String last_encounter_inform_date_time	= "";
	//String last_encounter_absconded_date = "";
	//String bed_block_date_time		= "";
	String blocking_type_code		= "";
	String high_risk_body_yn		= "";
	String body_release_date_time	= "";
	String discharge_date			= "";
	String assign_care_locn_type	= "";
	String admission_type			= "";
	String referral_id				= "";
	String disposition_type			= "";
	String discharge_status_code    = "";

	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
	String weight_on_admission		="";
	String weight_on_admission_unit	="";
	String weight_on_admission_unit_display		="";
	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
	
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission		="";
	String height_on_admission_unit	="";
	String bmi		="";
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/

	StringBuffer stringBuffer = new StringBuffer();
	Connection con	= null;
	Statement stmt 	= null;
	ResultSet rset	= null;
	
try
{
	con		= ConnectionManager.getConnection(request);

	//stringBuffer.append(" SELECT d.deceased_yn deceased_yn,  TO_CHAR (admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, ip_get_desc.ip_admission_type(a.ADMISSION_TYPE, '"+locale+"',2) admission_short_desc,  am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc,   am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_name,  am_get_desc.am_practitioner(a.Admit_practitioner_id, '"+locale+"', 1) practitioner_short_name,  null patient_type_short_desc,        ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc, a.bed_num bed_no,   a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc,   NULL dly_charge, a.patient_id patient_id,    a.bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2) bed_type_short_desc, a.bed_class_code bed_class_code, a.attend_practitioner_id practitioner_id,    a.specialty_code, a.nursing_unit_code, a.service_code, null patient_type,     b.sex gender, TO_CHAR (b.date_of_birth, 'dd/mm/rrrr') date_of_birth,  'N' locn_type,   TO_CHAR (c.expected_discharge_date, 'dd/mm/rrrr hh24:mi' ) expected_discharge_date,  TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr hh24:mi' ) discharge_date_time, c.auth_practitioner_id cauth_practitioner_id, (case when c.auth_practitioner_id is not null then   am_get_desc.am_practitioner(c.auth_practitioner_id, '"+locale+"', 1) end) auth_practitioner_name, c.referred_yn, c.to_hcare_setting_type, c.to_ref_type, c.to_ref_code,   c.referral_priority,  TO_CHAR (c.preferred_treatment_date,'dd/mm/rrrr') preferred_treatment_date, c.to_specialty_code, c.to_service_code, c.to_locn_type,c.post_mortem_req_yn, c.to_locn_code, c.to_pract_id, c.to_pract_name,c.med_lgl_case_yn, c.informed_to,  TO_CHAR (c.informed_date_time,'dd/mm/rrrr hh24:mi') informed_date_time, c.informed_name, c.pol_rep_no, c.pol_stn_id, c.pol_id, c.discharge_narration,  c.to_locn_desc, c.referred_for_ip, a.patient_class, c.ref_notes,  TO_CHAR (c.absconded_date, 'dd/mm/rrrr hh24:mi') absconded_date,  c.absconded_yn, c.reported_to, a.team_id, am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_short_desc,tO_CHAR (c.DECEASED_DATE_TIME,'dd/mm/rrrr hh24:mi') DECEASED_DATE_TIME, c.discharge_summary_yn, c.take_home_new_med_yn, c.discharge_type_code, ip_get_desc.ip_discharge_type(a.DISCHARGE_TYPE_CODE,'"+locale+"',2) discharge_type_desc FROM IP_PATIENT_LAST_ENCOUNTER a, MP_PATIENT b, IP_DISCHARGE_ADVICE c, IP_DISCHARGE_TYPE d  WHERE a.facility_id = '"+facilityId+"'    AND a.encounter_id = '"+encounterid+"'    AND a.patient_id = b.patient_id AND a.facility_id = c.facility_id    AND a.encounter_id = c.encounter_id    AND c.dis_Adv_srl_no like '%%'AND c.dis_adv_status = '1' AND c.discharge_type_code = d.discharge_type_code ");

	
	stringBuffer.append(" SELECT ");
	stringBuffer.append(" d.deceased_yn deceased_yn ");
	stringBuffer.append(" , TO_CHAR (a.visit_adm_date_time,'dd/mm/rrrr hh24:mi') admission_date_time ");
	stringBuffer.append(" , a.visit_adm_type admission_type");
	stringBuffer.append(" , ip_get_desc.ip_admission_type(a.visit_adm_type, '"+locale+"',2) admission_short_desc ");
	stringBuffer.append(" , am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc ");
	//stringBuffer.append(" , am_get_desc.am_practitioner(a.attend_practitioner_id,'"+locale+"',1) practitioner_name ");
	stringBuffer.append(" , am_get_desc.am_practitioner(a.disch_practitioner_id,'"+locale+"',1) practitioner_name ");
	stringBuffer.append(" , am_get_desc.am_practitioner(a.Admit_practitioner_id, '"+locale+"', 1) practitioner_short_name ");
	stringBuffer.append(" , null patient_type_short_desc ");
	stringBuffer.append(" , ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,'"+locale+"',2) nursing_unit_short_desc ");
	stringBuffer.append(" , am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc ");
	stringBuffer.append(" , a.assign_bed_num bed_no ");
	stringBuffer.append(" , a.assign_room_num room_no ");
	stringBuffer.append(" , ip_get_desc.ip_bed_class(a.assign_bed_class_code,'"+locale+"',2) bed_class_short_desc ");
	stringBuffer.append(" , NULL dly_charge ");
	stringBuffer.append(" , a.patient_id patient_id ");
	stringBuffer.append(" , a.assign_bed_type_code bed_type_code ");
	stringBuffer.append(" , ip_get_desc.ip_bed_type(a.assign_bed_type_code,'"+locale+"',2) bed_type_short_desc ");
	stringBuffer.append(" , a.assign_bed_class_code bed_class_code ");
	//stringBuffer.append(" , a.attend_practitioner_id practitioner_id ");
	stringBuffer.append(" , a.disch_practitioner_id practitioner_id ");
	stringBuffer.append(" , a.specialty_code ");
	stringBuffer.append(" , a.assign_care_locn_type ");
	stringBuffer.append(" , a.assign_care_locn_code nursing_unit_code");
	stringBuffer.append(" , a.service_code ");
	stringBuffer.append(" , null patient_type ");
	stringBuffer.append(" , b.sex gender ");
	stringBuffer.append(" , TO_CHAR (b.date_of_birth, 'dd/mm/rrrr') date_of_birth ");
	stringBuffer.append(" , 'N' locn_type ");
	stringBuffer.append(" , TO_CHAR (c.expected_discharge_date, 'dd/mm/rrrr hh24:mi' ) expected_discharge_date ");
	stringBuffer.append(" , TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr hh24:mi' ) discharge_date_time ");
	stringBuffer.append(" , TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr' ) discharge_date ");
	stringBuffer.append(" , c.auth_practitioner_id cauth_practitioner_id ");
	stringBuffer.append(" , ( CASE WHEN c.auth_practitioner_id IS not null THEN ");
	stringBuffer.append(" am_get_desc.am_practitioner(c.auth_practitioner_id, '"+locale+"', 1)  ");
	stringBuffer.append(" END) auth_practitioner_name ");
	stringBuffer.append(" , TO_CHAR (c.absconded_date, 'dd/mm/rrrr hh24:mi') absconded_date ");
	stringBuffer.append(" , TO_CHAR (c.informed_date_time,'dd/mm/rrrr hh24:mi') informed_date_time ");
	stringBuffer.append(" , TO_CHAR (c.preferred_treatment_date,'dd/mm/rrrr') preferred_treatment_date ");
	stringBuffer.append(" , TO_CHAR (a.BODY_RELEASE_DATE_TIME,'dd/mm/rrrr hh24:mi') body_release_date_time");	
	stringBuffer.append(" , a.patient_class ");
	stringBuffer.append(" , a.team_id ");
	stringBuffer.append(" , am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_short_desc ");
	stringBuffer.append(" , a.high_risk_yn ");	
	stringBuffer.append(" , c.absconded_yn ");
	stringBuffer.append(" , c.discharge_narration ");
	stringBuffer.append(" , c.discharge_summary_yn ");
	stringBuffer.append(" , c.discharge_type_code ");
	stringBuffer.append(" , c.informed_name ");
	stringBuffer.append(" , c.informed_to ");
	stringBuffer.append(" , c.pol_id ");
	stringBuffer.append(" , c.pol_rep_no ");
	stringBuffer.append(" , c.pol_stn_id ");
	stringBuffer.append(" , c.ref_notes ");
	stringBuffer.append(" , c.referral_priority ");
	stringBuffer.append(" , c.referred_for_ip ");
	stringBuffer.append(" , c.referred_yn ");
	stringBuffer.append(" , c.reported_to ");
	stringBuffer.append(" , c.take_home_new_med_yn ");
	stringBuffer.append(" , c.to_hcare_setting_type ");
	stringBuffer.append(" , c.to_locn_code ");
	stringBuffer.append(" , c.to_locn_desc ");
	stringBuffer.append(" , c.to_locn_type ");
	stringBuffer.append(" , c.to_pract_id ");
	stringBuffer.append(" , c.to_pract_name ");
	stringBuffer.append(" , c.to_ref_code ");
	stringBuffer.append(" , c.to_ref_type ");
	stringBuffer.append(" , c.to_service_code ");
	stringBuffer.append(" , c.to_specialty_code ");
	stringBuffer.append(" , ip_get_desc.ip_discharge_type(a.disposition_type,'"+locale+"',2)discharge_type_desc ");
	stringBuffer.append(" ,TO_CHAR (c.DECEASED_DATE_TIME,'dd/mm/rrrr hh24:mi') DECEASED_DATE_TIME ");
	stringBuffer.append(" ,c.med_lgl_case_yn ");
	//stringBuffer.append(" ,c.post_mortem_req_yn ");
	stringBuffer.append(" ,a.pm_yn post_mortem_req_yn ");
	stringBuffer.append(" ,a.disposition_type ");
	stringBuffer.append(" ,a.discharge_status_code ");
	stringBuffer.append(" ,a.referral_id ");	

	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
	stringBuffer.append(" ,a.weight_on_admission");
	stringBuffer.append(" ,a.weight_on_admission_unit");
	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
	
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	stringBuffer.append(" ,a.height_on_admission");
	stringBuffer.append(" ,a.bmi");
	/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/

	stringBuffer.append(" FROM ");
	stringBuffer.append(" PR_ENCOUNTER a ");
	stringBuffer.append(" , MP_PATIENT b ");
	stringBuffer.append(" , IP_DISCHARGE_ADVICE c ");
	stringBuffer.append(" , IP_DISCHARGE_TYPE d  ");
	stringBuffer.append(" WHERE a.facility_id = '"+facilityId+"' ");
	stringBuffer.append(" AND a.encounter_id = '"+encounterid+"' ");
	stringBuffer.append(" AND a.patient_id = b.patient_id  ");
	stringBuffer.append(" AND a.facility_id = c.facility_id  ");
	stringBuffer.append(" AND a.encounter_id = c.encounter_id  ");
	stringBuffer.append(" AND c.dis_adv_status = '1'  ");
	stringBuffer.append(" AND c.discharge_type_code = d.discharge_type_code ");



	/*stringBuffer.append(" SELECT ");
	stringBuffer.append(" d.deceased_yn deceased_yn ");
	stringBuffer.append(" , TO_CHAR (admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time ");
	stringBuffer.append(" , ip_get_desc.ip_admission_type(a.ADMISSION_TYPE, '"+locale+"',2) admission_short_desc ");
	stringBuffer.append(" , am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc ");
	stringBuffer.append(" , am_get_desc.am_practitioner(a.attend_practitioner_id,'"+locale+"',1) practitioner_name ");
	stringBuffer.append(" , am_get_desc.am_practitioner(a.Admit_practitioner_id, '"+locale+"', 1) practitioner_short_name ");
	stringBuffer.append(" , null patient_type_short_desc ");
	stringBuffer.append(" , ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc ");
	stringBuffer.append(" , am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc ");
	stringBuffer.append(" , a.bed_num bed_no ");
	stringBuffer.append(" , a.room_num room_no ");
	stringBuffer.append(" , ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc ");
	stringBuffer.append(" , NULL dly_charge ");
	stringBuffer.append(" , a.patient_id patient_id ");
	stringBuffer.append(" , a.bed_type_code bed_type_code ");
	stringBuffer.append(" , ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2) bed_type_short_desc ");
	stringBuffer.append(" , a.bed_class_code bed_class_code ");
	stringBuffer.append(" , a.attend_practitioner_id practitioner_id ");
	stringBuffer.append(" , a.specialty_code ");
	stringBuffer.append(" , a.nursing_unit_code ");
	stringBuffer.append(" , a.service_code ");
	stringBuffer.append(" , null patient_type ");
	stringBuffer.append(" , b.sex gender ");
	stringBuffer.append(" , TO_CHAR (b.date_of_birth, 'dd/mm/rrrr') date_of_birth ");
	stringBuffer.append(" , 'N' locn_type ");
	stringBuffer.append(" , TO_CHAR (c.expected_discharge_date, 'dd/mm/rrrr hh24:mi' ) expected_discharge_date ");
	stringBuffer.append(" , TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr hh24:mi' ) discharge_date_time ");
	stringBuffer.append(" , c.auth_practitioner_id cauth_practitioner_id ");
	stringBuffer.append(" , ( CASE WHEN c.auth_practitioner_id IS not null THEN ");
	stringBuffer.append(" am_get_desc.am_practitioner(c.auth_practitioner_id, '"+locale+"', 1)  ");
	stringBuffer.append(" END) auth_practitioner_name ");
	stringBuffer.append(" , TO_CHAR (c.absconded_date, 'dd/mm/rrrr hh24:mi') absconded_date ");
	stringBuffer.append(" , TO_CHAR (c.informed_date_time,'dd/mm/rrrr hh24:mi') informed_date_time ");
	stringBuffer.append(" , TO_CHAR (c.preferred_treatment_date,'dd/mm/rrrr') preferred_treatment_date ");
	stringBuffer.append(" , a.patient_class ");
	stringBuffer.append(" , a.team_id ");
	stringBuffer.append(" , am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_short_desc ");
	stringBuffer.append(" , c.absconded_yn ");
	stringBuffer.append(" , c.discharge_narration ");
	stringBuffer.append(" , c.discharge_summary_yn ");
	stringBuffer.append(" , c.discharge_type_code ");
	stringBuffer.append(" , c.informed_name ");
	stringBuffer.append(" , c.informed_to ");
	stringBuffer.append(" , c.pol_id ");
	stringBuffer.append(" , c.pol_rep_no ");
	stringBuffer.append(" , c.pol_stn_id ");
	stringBuffer.append(" , c.ref_notes ");
	stringBuffer.append(" , c.referral_priority ");
	stringBuffer.append(" , c.referred_for_ip ");
	stringBuffer.append(" , c.referred_yn ");
	stringBuffer.append(" , c.reported_to ");
	stringBuffer.append(" , c.take_home_new_med_yn ");
	stringBuffer.append(" , c.to_hcare_setting_type ");
	stringBuffer.append(" , c.to_locn_code ");
	stringBuffer.append(" , c.to_locn_desc ");
	stringBuffer.append(" , c.to_locn_type ");
	stringBuffer.append(" , c.to_pract_id ");
	stringBuffer.append(" , c.to_pract_name ");
	stringBuffer.append(" , c.to_ref_code ");
	stringBuffer.append(" , c.to_ref_type ");
	stringBuffer.append(" , c.to_service_code ");
	stringBuffer.append(" , c.to_specialty_code ");
	stringBuffer.append(" , ip_get_desc.ip_discharge_type(a.DISCHARGE_TYPE_CODE,'"+locale+"',2)discharge_type_desc ");
	stringBuffer.append(" ,TO_CHAR (c.DECEASED_DATE_TIME,'dd/mm/rrrr hh24:mi') DECEASED_DATE_TIME ");
	stringBuffer.append(" ,c.med_lgl_case_yn ");
	stringBuffer.append(" ,c.post_mortem_req_yn ");
	stringBuffer.append(" FROM ");
	stringBuffer.append(" IP_PATIENT_LAST_ENCOUNTER a ");
	stringBuffer.append(" , MP_PATIENT b ");
	stringBuffer.append(" , IP_DISCHARGE_ADVICE c ");
	stringBuffer.append(" , IP_DISCHARGE_TYPE d  ");
	stringBuffer.append(" WHERE a.facility_id = '"+facilityId+"' ");
	stringBuffer.append(" AND a.encounter_id = '"+encounterid+"' ");
	stringBuffer.append(" AND a.patient_id = b.patient_id  ");
	stringBuffer.append(" AND a.facility_id = c.facility_id  ");
	stringBuffer.append(" AND a.encounter_id = c.encounter_id  ");
	stringBuffer.append(" AND c.dis_adv_status = '1'  ");
	stringBuffer.append(" AND c.discharge_type_code = d.discharge_type_code ");
*/
	

	
	stmt = con.createStatement();
	rset	 =	 stmt.executeQuery(stringBuffer.toString());
	
	if(rset != null && rset.next())
	{
		EXPECTED_DISCHARGE_DATE		= checkForNull(rset.getString("expected_discharge_date"));//
		absconded_date				= checkForNull(rset.getString("ABSCONDED_DATE"));
		absconded_yn				= checkForNull(rset.getString("ABSCONDED_YN"));
		admission_date_time			= checkForNull(rset.getString("admission_date_time"));
		admission_short_desc		= checkForNull(rset.getString("admission_short_desc"));
		auth_practitioner_id 		= checkForNull(rset.getString("cauth_practitioner_id"), practitioner_id);
		auth_practitioner_name		= checkForNull(rset.getString("auth_practitioner_name"), practitioner_name);//
		bed_class_code				= checkForNull(rset.getString("bed_class_code"));
		bed_class_short_desc		= checkForNull(rset.getString("bed_class_short_desc"));
		bed_no						= checkForNull(rset.getString("bed_no"));
		bed_type_code				= checkForNull(rset.getString("bed_type_code"));
		bed_type_desc				= checkForNull(rset.getString("bed_type_short_desc"));
		date_of_birth				= checkForNull(rset.getString("date_of_birth"));
		deceased_date_time			= checkForNull(rset.getString("DECEASED_DATE_TIME"));
		discharge_date_time			= checkForNull(rset.getString("discharge_date_time"));//
		discharge_narration			= checkForNull(rset.getString("discharge_narration"));
		discharge_summary_yn		= checkForNull(rset.getString("discharge_summary_yn"));
		discharge_type_code         = checkForNull(rset.getString("discharge_type_code"));
		discharge_type_desc			= checkForNull(rset.getString("discharge_type_desc"));//
		gender						= checkForNull(rset.getString("gender"));
		informed_date_time			= checkForNull(rset.getString("informed_date_time")); 
		informed_name				= checkForNull(rset.getString("informed_name"));
		informed_to					= checkForNull(rset.getString("informed_to"));
		locn_type					= checkForNull(rset.getString("locn_type"));
		med_lgl_case_yn				= checkForNull(rset.getString("med_lgl_case_yn"));
		medteamdesc                 = checkForNull(rset.getString("team_short_desc"));
		medteamid	                = checkForNull(rset.getString("team_id"));
		nursing_unit_code			= checkForNull(rset.getString("nursing_unit_code"));
		nursing_unit_short_desc		= checkForNull(rset.getString("nursing_unit_short_desc"));
		patient_class				= checkForNull(rset.getString("patient_class"));
		patient_id					= checkForNull(rset.getString("patient_id"));
		patient_type				= checkForNull(rset.getString("patient_type"));
		patient_type_short_desc		= checkForNull(rset.getString("patient_type_short_desc"));
		pol_id						= checkForNull(rset.getString("pol_id"));
		pol_rep_no					= checkForNull(rset.getString("pol_rep_no"));
		pol_stn_id					= checkForNull(rset.getString("pol_stn_id"));
		post_mortem_req_yn			= checkForNull(rset.getString("post_mortem_req_yn"));
		practitioner_id				= checkForNull(rset.getString("practitioner_id"));
		practitioner_name			= checkForNull(rset.getString("practitioner_name"));//
		reported_to					= checkForNull(rset.getString("REPORTED_TO"));
		room_no						= checkForNull(rset.getString("room_no"));
		service_code				= checkForNull(rset.getString("service_code"));
		service_short_desc			= checkForNull(rset.getString("service_short_desc"));
		specialty_code				= checkForNull(rset.getString("specialty_code")); 
		specialty_short_desc		= checkForNull(rset.getString("specialty_short_desc"));
		take_home_new_med_yn		= checkForNull(rset.getString("take_home_new_med_yn"));
		to_locn_code				= checkForNull(rset.getString("to_locn_code"));
		to_locn_type				= checkForNull(rset.getString("to_locn_type"));
		to_ref_code					= checkForNull(rset.getString("to_ref_code"));
		to_service_code				= checkForNull(rset.getString("to_service_code"));
		to_specialty_code			= checkForNull(rset.getString("to_specialty_code"));
		high_risk_body_yn			= checkForNull(rset.getString("high_risk_yn"));
		body_release_date_time		= checkForNull(rset.getString("body_release_date_time"));
		discharge_date				= checkForNull(rset.getString("discharge_date"));
		assign_care_locn_type		= checkForNull(rset.getString("assign_care_locn_type"));
		admission_type				= checkForNull(rset.getString("admission_type"));
		disposition_type 			= checkForNull(rset.getString("disposition_type"));
		referral_id		 			= checkForNull(rset.getString("referral_id"));
		discharge_status_code		= checkForNull(rset.getString("discharge_status_code"));

		/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
		weight_on_admission			= checkForNull(rset.getString("weight_on_admission"));
		weight_on_admission_unit	= checkForNull(rset.getString("weight_on_admission_unit"));
		/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		height_on_admission			= checkForNull(rset.getString("height_on_admission"));
		bmi	= checkForNull(rset.getString("bmi"));
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/

		
	}
		if(rset != null) rset.close(); 
		if(stmt != null) stmt.close();
			/*
			pageContext.setAttribute("discharge_narration",discharge_narration,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("reported_to",reported_to,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("informed_name",informed_name,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("pol_rep_no",pol_rep_no,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("pol_stn_id",pol_stn_id,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("pol_id",pol_id,pageContext.SESSION_SCOPE);
			pageContext.setAttribute("blocking_remarks",blocking_remarks,pageContext.SESSION_SCOPE);
			*/
	
		weight_on_admission_unit_display=(weight_on_admission_unit.equals("K"))?"Kg":(weight_on_admission_unit.equals("G"))?"Gram":""; //Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123]
		height_on_admission_unit=(height_on_admission.equals(""))?"":"Cm";//Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterid,"UTF-8")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(admission_date_time,"UTF-8")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(admission_short_desc,"UTF-8")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialty_short_desc,"UTF-8")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_name,"UTF-8")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursing_unit_short_desc,"UTF-8")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(service_short_desc,"UTF-8")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no,"UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(room_no,"UTF-8")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_class_short_desc,"UTF-8")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_id,"UTF-8")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type_desc,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(medteamid,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(medteamdesc,"UTF-8")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterid,"UTF-8")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(admission_date_time,"UTF-8")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(admission_short_desc,"UTF-8")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialty_short_desc,"UTF-8")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_name,"UTF-8")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursing_unit_short_desc,"UTF-8")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(service_short_desc,"UTF-8")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no,"UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(room_no,"UTF-8")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_class_short_desc,"UTF-8")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_id,"UTF-8")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type_desc,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(medteamid,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(medteamdesc,"UTF-8")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(weight_on_admission));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(weight_on_admission_unit));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(weight_on_admission_unit_display));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(height_on_admission));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(height_on_admission_unit));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(to_ref_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(to_specialty_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(to_service_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(to_locn_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(post_mortem_req_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(to_locn_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(med_lgl_case_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(informed_to,"UTF-8")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode(informed_date_time,"UTF-8")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(admission_date_time,"UTF-8")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(admission_short_desc,"UTF-8")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialty_short_desc,"UTF-8")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_name,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_type_short_desc,"UTF-8")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursing_unit_short_desc,"UTF-8")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(service_short_desc,"UTF-8")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_class_short_desc,"UTF-8")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type_desc,"UTF-8")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(auth_practitioner_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(java.net.URLEncoder.encode(auth_practitioner_name,"UTF-8")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(discharge_type_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_type));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(java.net.URLEncoder.encode(date_of_birth,"UTF-8")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patient_status));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(java.net.URLEncoder.encode(absconded_date,"UTF-8")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(absconded_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(java.net.URLEncoder.encode(discharge_date_time,"UTF-8")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(java.net.URLEncoder.encode(EXPECTED_DISCHARGE_DATE,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(medteamid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(medteamdesc,"UTF-8")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(java.net.URLEncoder.encode(deceased_date_time,"UTF-8")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(discharge_summary_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(take_home_new_med_yn));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(discharge_type_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(last_encounter_inform_to));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(java.net.URLEncoder.encode(last_encounter_inform_name,"UTF-8")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(java.net.URLEncoder.encode(last_encounter_inform_date_time,"UTF-8")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(blocking_type_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(high_risk_body_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(java.net.URLEncoder.encode(body_release_date_time,"UTF-8")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(java.net.URLEncoder.encode(discharge_date,"UTF-8")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(admission_type));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(disposition_type));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(discharge_status_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block79Bytes, _wl_block79);
	}catch(Exception e)
	{
		out.print("Exception "+e);
	}	
	finally   
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block80Bytes, _wl_block80);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CancelDischargePatient.label", java.lang.String .class,"key"));
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
