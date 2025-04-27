package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __referraldetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ReferralDetails.jsp", 1742454546331L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n\t<script>//alert(\"Opening ReferralDetails.jsp\")</script>\n\t<TITLE>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</TITLE>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eMP/js/ReferralDtls.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</HEAD>\n<BODY onKeyDown = \'lockKey();\'>\n\t<form name=\'ReferralDtls_form\' id=\'ReferralDtls_form\'  method=\"post\" onload=\"\" action=\"../../servlet/eMP.RegisterReferralsServlet\" target=\"messageFrame1\" >\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<TABLE id=\"referral_table\" cellspacing=0 cellpadding=0 border=\"0\" width=\"100%\" >\n<!--Below line modidfied for this CRF Bru-HIMS-CRF-261-->\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</tr>\n\n\t<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<script>if(document.getElementById(\'prefDateImg\'))document.getElementById(\'prefDateImg\').style.visibility\t= \'visible\';</script>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t<tr>\n\t<table border=\'0\' width=\'100%\'>\n\t<tr>\n\t\t\n\t\t<!-- below condition added by Venkatesh.S on 21/12/2012 againist 36866 -->\n\t\t<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 -->\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<td align=\'right\' colspan=\'7\'><input type=\'button\' name=\'record\' id=\'record\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' class=\'button\' onclick=\'submitPage()\'><input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' class=\'button\' onclick=\'clearAll()\'></td>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->\n\t\t<td align=\'right\' colspan=\'7\'><input type=\'button\' name=\'record\' id=\'record\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' class=\'button\' onclick=\'clearAll()\'><input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' class=\'button\' onclick=\'closeWin()\'><input type=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' name=\'Refresh\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' class=\'button\' onclick=\'reloadPage()\'></td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<!-- end 36866 -->\n\t</tr>\n\t<tr>\n\t\t\t\t\t\t<td colspan=\"4\" class=label height=5></td>\n\t\t\t\t\t</tr>\n\n\t</table>\n\t</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\n<input type = \'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n<input type = \'hidden\' name=\'patient_name\' id=\'patient_name\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\n<input type = \'hidden\' name=\'from_facility_id\' id=\'from_facility_id\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n<input type = \'hidden\' name=\'from_encounter_id\' id=\'from_encounter_id\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n<input type = \'hidden\' name=\'from_hcare_setting_type\' id=\'from_hcare_setting_type\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n<input type = \'hidden\' name=\'from_locn_type\' id=\'from_locn_type\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n<input type = \'hidden\' name=\'from_ref_code\' id=\'from_ref_code\' value=\"\" >\n<input type = \'hidden\' name=\'from_ref_type\' id=\'from_ref_type\' value=\"L\" >\n<input type = \'hidden\' name=\'from_pract_id\' id=\'from_pract_id\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n<input type = \'hidden\' name=\'from_pract_name\' id=\'from_pract_name\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n<input type = \'hidden\' name=\'from_service_code\' id=\'from_service_code\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n<input type = \'hidden\' name=\'from_speciality_code\' id=\'from_speciality_code\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\n<input type = \'hidden\' name=\'from_locn_code\' id=\'from_locn_code\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n<input type = \'hidden\' name=\'from_locn_desc\' id=\'from_locn_desc\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n<input type = \'hidden\' name=\'Module\' id=\'Module\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n<input type = \'hidden\' name=\'Transaction_type\' id=\'Transaction_type\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n<input type = \'hidden\' name=\'hdd_discharge_indicator\' id=\'hdd_discharge_indicator\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\n<input type = \'hidden\' name=\'referral_idS\' id=\'referral_idS\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n<input type = \'hidden\' name=\'mode\' id=\'mode\' value=\"\" >\n<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 -->\n<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<!--  added by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023 start -->\n<input type=\'hidden\' name=\'recFun\' id=\'recFun\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'recFunVal\' id=\'recFunVal\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'referral_id\' id=\'referral_id\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<!--  added by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023 end -->\n<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n<input type=\'hidden\' name=\'CA_REF_LETTER_NOTES_REC_YN\' id=\'CA_REF_LETTER_NOTES_REC_YN\' value=\"N\">\n</table>\n<script>updateRefDtls();</script>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
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

///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// Module			: OP
/// Created By		: SRIDHAR R 
/// Created Date	: 6 SEP 2004

/// Function		: To Insert the Referral details into PR_REFERRAL_REGISTER Table...
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con			=	null;
	Statement stmt			=	null;
	ResultSet rs			=	null;
	String locale           = (String) session.getAttribute("LOCALE");
	try
	{
		con	= ConnectionManager.getConnection(request);
		stmt= con.createStatement();

		Boolean isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS"); //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		Boolean isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023

		String facilityID		= (String) session.getValue("facility_id");
		
		
String function_id= checkForNull(request.getParameter("function_id")); //this line Added for this CRF-Bru-HIMS-CRF-261
	
		
		String Transaction_type	= request.getParameter("Transaction_type");
			if(Transaction_type	== null	) Transaction_type = "";

		String patient_id		= request.getParameter("patient_id");
			if(patient_id	== null	) patient_id = "";
	/*Added by lakshmanan for ML-MMOH-CRF-1972 on 20/07/2023 start*/	
		String recFun		= request.getParameter("recFun");
		if(recFun	== null	) recFun = "";
		if (!recFun.equals("")){
			function_id=recFun;
		}
		String recFunVal		= request.getParameter("recFunVal");
		if(recFunVal	== null	) recFunVal = "";
		String referral_id1		= request.getParameter("referral_id");
		if(referral_id1	== null	) referral_id1 = "";
		/*Added by lakshmanan for ML-MMOH-CRF-1972 on 20/07/2023 end*/

		String EncounterId		= request.getParameter("EncounterId");
			if(EncounterId	== null	) EncounterId = "";
		String Module			= request.getParameter("Module");
        String regOutref=request.getParameter("regOutref");
		      if(regOutref==null) regOutref="";
		String discharge_indicator		= request.getParameter("discharge_indicator");
			if(discharge_indicator	== null	) discharge_indicator = "";

		String Sql						= "";
		String service_code				= "";
		String specialty_code			= "";
		String practitioner_id			= "";
		String nursing_unit_code		= "";
		
		
		String patient_name				= "";
		
		String practitioner_name		= "";
		String hcare_setting_type_code	= "";
		String nursing_unit_short_desc	= "";
		String locn_type				= "";
		StringBuffer referral_idS		=new StringBuffer();
		String referral_id				= "";

    /*Below line modified for this CRF HSA-CRF-0263.1*/
	String allow_muti_bedside_review_yn = checkForNull(request.getParameter("allow_muti_bedside_review_yn"),"N");
    		
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
	String refButton="button"; 
	String referral_id2="";
	String transfer_case_yn="N";
	String to_ref_type="";
	String to_ref_code="";
	String to_ref_desc="";
	String to_hcare_setting_type="";
	String to_locn_code="";
	String to_locn_desc="";
	String to_speciality_code="";
	String to_locn_type="";
	String to_service_code="";
	String to_service_desc="";
	String to_pract_id="";
	String to_pract_desc="";
	String to_pract_name="";
	String referred_for="";
	String preferred_treatment_date="";
	String referral_reason_code="";
	String referral_reason_desc="";
	String referral_priority="";
	if(isForAdmission && recFun.equals("ModifyReferral")){
		PreparedStatement pstmt1	= null;
		ResultSet rs1 = null;
		String Sql1="";
		String Sql2="";
		
		Sql1  = " select DISP_REFERRAL_ID from  op_patient_queue where  ENCOUNTER_ID=? ";
		pstmt1	= con.prepareStatement(Sql1);
		pstmt1.setString(1,EncounterId );
		rs1=pstmt1.executeQuery();
		if (rs1!=null && rs1.next()) {
			referral_id2=checkForNull(rs1.getString("DISP_REFERRAL_ID"));
		}
		if(pstmt1!=null) pstmt1.close();
		if(rs1!=null) rs1.close();
		
		Sql2 ="select transfer_case_yn, to_ref_type , to_ref_code , am_get_desc.am_referral(to_ref_code,?,'1') as to_ref_desc ,to_facility_id , (case when to_facility_id is not null then( sm_get_desc.sm_facility_param(to_facility_id,?,'1')) end) to_facility_name,  to_hcare_setting_type, to_speciality_code, to_locn_code , to_locn_type , to_locn_desc, to_service_code, am_get_desc.am_service(to_service_code,?,'2') as to_service_desc , to_pract_id ,  DECODE (to_ref_type, 'X', am_get_desc.am_ext_practitioner (to_pract_id, ?, 1 ), am_get_desc.am_practitioner (to_pract_id, ?, 1))  as to_pract_desc ,to_pract_name , referred_for_ip , to_char(preferred_treatment_date,'dd/mm/yyyy') PREFERRED_TREATMENT_DATE , referral_reason_code , am_get_desc.am_contact_reason(referral_reason_code, ?,'1') as referral_reason_desc , referral_priority from pr_referral_register where REFERRAL_ID=?" ;
		pstmt1	= con.prepareStatement(Sql2);
		pstmt1.setString(1,locale );
		pstmt1.setString(2,locale );
		pstmt1.setString(3,locale );
		pstmt1.setString(4,locale );
		pstmt1.setString(5,locale );
		pstmt1.setString(6,locale );
		pstmt1.setString(7,referral_id2 );
		rs1=pstmt1.executeQuery();
		if (rs1!=null && rs1.next()) {
			transfer_case_yn=checkForNull(rs1.getString("transfer_case_yn"),"N");
			to_ref_type=checkForNull(rs1.getString("to_ref_type"));
			if (to_ref_type.equals("X")){
			to_ref_code=checkForNull(rs1.getString("to_ref_code"));
			to_ref_desc=checkForNull(rs1.getString("to_ref_desc"));
			} else {
				to_ref_code=checkForNull(rs1.getString("to_facility_id"));
				to_ref_desc=checkForNull(rs1.getString("to_facility_name"));
			}
			to_hcare_setting_type=checkForNull(rs1.getString("to_hcare_setting_type"));
			to_locn_code=checkForNull(rs1.getString("to_locn_code"));
			to_locn_desc=checkForNull(rs1.getString("to_locn_desc"));
			to_speciality_code=checkForNull(rs1.getString("to_speciality_code"));
			to_locn_type=checkForNull(rs1.getString("to_locn_type"));
			to_service_code=checkForNull(rs1.getString("to_service_code"));
			to_service_desc=checkForNull(rs1.getString("to_service_desc"));
			to_pract_id=checkForNull(rs1.getString("to_pract_id"));
			to_pract_desc=checkForNull(rs1.getString("to_pract_desc"));
			to_pract_name=checkForNull(rs1.getString("to_pract_name"));
			referred_for=checkForNull(rs1.getString("referred_for_ip"));
			preferred_treatment_date=checkForNull(rs1.getString("PREFERRED_TREATMENT_DATE")); 
			referral_reason_code=checkForNull(rs1.getString("referral_reason_code")); 
			referral_reason_desc=checkForNull(rs1.getString("referral_reason_desc")); 
			referral_priority=checkForNull(rs1.getString("referral_priority")); 
		}
			
	}
	if(isForAdmission && (recFun.equals("ModifyReferral") || recFun.equals("for_admission")))
			{
			 refButton="hidden";	
	} 
	
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
		
            _bw.write(_wl_block1Bytes, _wl_block1);
		if(Transaction_type.equals("DP"))
		{

		
			locn_type			= checkForNull(request.getParameter("from_locn_type"));
			service_code		= checkForNull(request.getParameter("from_service_code"));
			specialty_code		= checkForNull(request.getParameter("from_specialty_code"));
			practitioner_id		= checkForNull(request.getParameter("from_practitioner_id"));
			practitioner_name	= checkForNull(request.getParameter("from_practitioner_name"));
			nursing_unit_code	= checkForNull(request.getParameter("from_nursing_unit_code"));
			nursing_unit_short_desc	= checkForNull(request.getParameter("from_nursing_unit_short_desc"));
		
			Sql  = " SELECT REFERRAL_ID FROM pr_referral_register WHERE from_facility_id = '"+facilityID+"' AND from_encounter_id = '"+EncounterId+"' order by REFERRAL_ID";
	
		
			rs		= stmt.executeQuery(Sql);

			referral_idS.setLength(0);
			
			if(rs != null)
			{
				while(rs.next())
				{
					referral_id		= rs.getString("REFERRAL_ID");
					if(referral_id == null ) 
					{
						referral_idS.append("'"+referral_id+"'");
					}
					else
					{
						referral_idS.append(referral_id+"/");
					}
				}
			}

			if(rs != null) rs.close();
		}
		else if(Transaction_type.equals("DA") || Transaction_type.equals("CO"))
		{	
		
		
			Sql = " SELECT a.attend_practitioner_id , a.patient_id, decode('"+localeName+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+localeName+"', 1) practitioner_name, service_code, decode(a.assign_care_locn_type, 'N', ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code, '"+localeName+"', 1), op_get_desc.op_clinic(a.facility_id, a.assign_care_locn_code, '"+localeName+"', 1)) clinic_name , specialty_code, assign_care_locn_code, assign_care_locn_type FROM pr_encounter a, mp_patient b WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+EncounterId+"' and a.patient_id = b.patient_id";	
		
			rs		= stmt.executeQuery(Sql);

			if(rs != null)
			{
				while(rs.next())
				{
					locn_type			= rs.getString("assign_care_locn_type");
					practitioner_id		= rs.getString("attend_practitioner_id");
					practitioner_name	= rs.getString("practitioner_name");
					patient_name		= rs.getString("patient_name");
					patient_id			= rs.getString("patient_id");
					specialty_code		= rs.getString("specialty_code");
					service_code		= rs.getString("service_code");
					nursing_unit_code	= rs.getString("assign_care_locn_code");
					nursing_unit_short_desc	= rs.getString("clinic_name");
				}
			}

            _bw.write(_wl_block1Bytes, _wl_block1);

			if(rs != null) rs.close();
		}	
		
		rs		= stmt.executeQuery("select HCARE_SETTING_TYPE_CODE from SM_FACILITY_PARAM where FACILITY_ID = '"+facilityID+"'");

		if(rs != null)
		{
			while(rs.next())
			{
				hcare_setting_type_code	= rs.getString("HCARE_SETTING_TYPE_CODE");
			}
		}
		if(rs != null)	rs.close();
		if(stmt!= null) stmt.close();


            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eMP/jsp/ReferralDetailsComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("Module"), weblogic.utils.StringUtils.valueOf(Module
                        )},{ weblogic.utils.StringUtils.valueOf("ReasonForRef"), weblogic.utils.StringUtils.valueOf("N")},{ weblogic.utils.StringUtils.valueOf("Option"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[1]")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[3]")},{ weblogic.utils.StringUtils.valueOf("Transaction_type"), weblogic.utils.StringUtils.valueOf(Transaction_type
                        )},{ weblogic.utils.StringUtils.valueOf("discharge_indicator"), weblogic.utils.StringUtils.valueOf(discharge_indicator
                        )},{ weblogic.utils.StringUtils.valueOf("regOutref"), weblogic.utils.StringUtils.valueOf(regOutref
                        )},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf(function_id
                        )},{ weblogic.utils.StringUtils.valueOf("allow_muti_bedside_review_yn"), weblogic.utils.StringUtils.valueOf(allow_muti_bedside_review_yn
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("OP")},{ weblogic.utils.StringUtils.valueOf("referral_id"), weblogic.utils.StringUtils.valueOf(referral_id2 
                        )},{ weblogic.utils.StringUtils.valueOf("recFun"), weblogic.utils.StringUtils.valueOf(recFun
                        )},{ weblogic.utils.StringUtils.valueOf("recFunVal"), weblogic.utils.StringUtils.valueOf(recFunVal
                        )},{ weblogic.utils.StringUtils.valueOf("transfer_case_yn"), weblogic.utils.StringUtils.valueOf(transfer_case_yn
                        )},{ weblogic.utils.StringUtils.valueOf("ref_type"), weblogic.utils.StringUtils.valueOf(to_ref_type
                        )},{ weblogic.utils.StringUtils.valueOf("referred_to_value"), weblogic.utils.StringUtils.valueOf(to_ref_code
                        )},{ weblogic.utils.StringUtils.valueOf("referred_to_desc"), weblogic.utils.StringUtils.valueOf(to_ref_desc
                        )},{ weblogic.utils.StringUtils.valueOf("ref_hcare_setting_type"), weblogic.utils.StringUtils.valueOf(to_hcare_setting_type
                        )},{ weblogic.utils.StringUtils.valueOf("ref_locn_code"), weblogic.utils.StringUtils.valueOf(to_locn_code
                        )},{ weblogic.utils.StringUtils.valueOf("to_locn_desc"), weblogic.utils.StringUtils.valueOf(to_locn_desc
                        )},{ weblogic.utils.StringUtils.valueOf("ref_specialty"), weblogic.utils.StringUtils.valueOf(to_speciality_code
                        )},{ weblogic.utils.StringUtils.valueOf("ref_locn_type"), weblogic.utils.StringUtils.valueOf(to_locn_type
                        )},{ weblogic.utils.StringUtils.valueOf("ref_service_code"), weblogic.utils.StringUtils.valueOf(to_service_code
                        )},{ weblogic.utils.StringUtils.valueOf("to_service_desc"), weblogic.utils.StringUtils.valueOf(to_service_desc
                        )},{ weblogic.utils.StringUtils.valueOf("to_pract_id"), weblogic.utils.StringUtils.valueOf(to_pract_id
                        )},{ weblogic.utils.StringUtils.valueOf("to_pract_desc"), weblogic.utils.StringUtils.valueOf(to_pract_desc
                        )},{ weblogic.utils.StringUtils.valueOf("to_pract_name"), weblogic.utils.StringUtils.valueOf(to_pract_name
                        )},{ weblogic.utils.StringUtils.valueOf("referred_for"), weblogic.utils.StringUtils.valueOf(referred_for
                        )},{ weblogic.utils.StringUtils.valueOf("preferred_treatment_date"), weblogic.utils.StringUtils.valueOf(preferred_treatment_date
                        )},{ weblogic.utils.StringUtils.valueOf("referral_reason_code"), weblogic.utils.StringUtils.valueOf(referral_reason_code
                        )},{ weblogic.utils.StringUtils.valueOf("referral_reason_desc"), weblogic.utils.StringUtils.valueOf(referral_reason_desc
                        )},{ weblogic.utils.StringUtils.valueOf("ref_priority"), weblogic.utils.StringUtils.valueOf(referral_priority
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block14Bytes, _wl_block14);
if(!isImproveReferralProcessAppl || function_id.equals("RegisterInpatientReferral")){
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
if(regOutref.equals("REG_OUT_REF") || function_id.equals("RegPatRefFromAEAssessment")){
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(refButton));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

/// For Calling Function from IP_DISCAHRGE_ADVICE..
	if(Transaction_type.equals("DA") && discharge_indicator.equals("ED"))
	{
		out.println("<script>document.forms[0].close.disabled = true;</script>");
		out.println("<script>alert(getMessage('REGISTER_ONE_REFERRAL','MP'))</script>");
	}


            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(hcare_setting_type_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Module));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Transaction_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(discharge_indicator));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(referral_idS.toString()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(recFun));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recFunVal));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(referral_id2));
            _bw.write(_wl_block46Bytes, _wl_block46);

 
 referral_idS.setLength(0);

}catch(Exception e) 
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block47Bytes, _wl_block47);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargeAdvise.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Refresh.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
