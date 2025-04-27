package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __singlepractvwnew extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/SinglePractVwNew.jsp", 1709716315045L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<iframe name=\'images12\' id=\'images12\' src=\'../../eOA/jsp/DisplayTabs.jsp?clinic_code=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&practitioner_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&ca_mode=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&ca_patient_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&callingMode=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&Date=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&install_yn_val=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&from_OR=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&speciality=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&clinic_old=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&practitioner_old=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&practitioner_type=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&or_catalogue_code=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&order_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&order_line_num=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&order_catalog_code=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&pref_start_date=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&pref_end_date=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&clinic_type=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&no_dwm=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&visittype=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&dwm_desc=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&noshow_ctrl_by_splty_or_clinic=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&min_ela_per_resc_noshow_in_day=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&contact_num_reqd_yn=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&no_of_noshow_appts_for_alert=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&per_chk_for_no_show_alert=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&calledFrom=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&position=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&addtl_splty=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&rd_appt_yn=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' frameborder=no scrolling=no noresize style=\'height:3vh;width:100vw\'></iframe>\n\t<iframe name=\'queries\' id=\'queries\'src=\'../../eOA/jsp/SinglePractVw.jsp?clinic_code=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&decide=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&res_type=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&oper_stn_id=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&slot_appt_ctrl=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&override_no_of_slots_yn=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&visit_limit_rule=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&alcn_criteria=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&req_id=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&create_wait_list_yn=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&visit_flag_OP=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&capture_fin_dtls_yn=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&from_page=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&from_facility_id=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&from_encounter_id=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' frameborder=no scrolling=no noresize style=\'height:97vh;width:100vw\'></iframe>\n\t<iframe name=\'tempStorageFrame\' id=\'tempStorageFrame\'src=\"../../eOA/jsp/OATempStorage.jsp?clinic_code=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&patient_id_temp=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&name_prefix_temp=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&first_name_temp=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&second_name_temp=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&third_name_temp=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&family_name_temp=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&name_suffix_temp=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&name_prefix_oth_lang_temp=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&first_name_oth_lang_temp=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&second_name_oth_lang_temp=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&third_name_oth_lang_temp=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&family_name_oth_lang_temp=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&name_suffix_oth_lang_temp=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&gender_temp=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&contact_no_temp=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&rule_appl_yn=";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&nationality_code_temp=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="&language_code_temp=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&term_set_id=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="&linking_code=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="&apptrefno=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" frameborder=no scrolling=no noresize style=\'height:0vh;width:100vw\'></iframe>\n\n\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\n</html>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
	
    // Modified for CRF - SRR -0425 -- Order Catalog.
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		String clinic_code=(String)request.getParameter("clinic_code");
		String practitioner_id=(String)request.getParameter("practitioner_id");
		String Date=(String)request.getParameter("Date");
		String decide=(String)request.getParameter("decide");
		String ca_mode=(String)request.getParameter("ca_mode");
		String ca_patient_id=(String)request.getParameter("ca_patient_id");
		//Added for getting value for Calling Mode 
		String callingMode = request.getParameter("callingMode");
		//String title=request.getParameter("title");
		String create_wait_list_yn=request.getParameter("create_wait_list_yn");
		if(create_wait_list_yn ==null) create_wait_list_yn="";
		String clinic_type=request.getParameter("clinic_type");
		String res_type=request.getParameter("res_type");
		String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
		String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id== null) oper_stn_id="";
		//String clinic_alcn="";
		//String clinic_alcn_sql="select alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+clinic_code+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+Date+"','dd/mm/yyyy')";

		if (clinic_type==null) clinic_type = "C";
		if (res_type==null) res_type = "P";

		if (callingMode==null) callingMode = "";
		//Added by Suman regd Sql tuning	
		String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
		if(slot_appt_ctrl == null) slot_appt_ctrl="";
		String visit_limit_rule=request.getParameter("visit_limit_rule");
		if(visit_limit_rule== null) visit_limit_rule="";
		String alcn_criteria=request.getParameter("alcn_criteria");
		if(alcn_criteria ==null) alcn_criteria="";
		String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn");
		if(override_no_of_slots_yn==null)override_no_of_slots_yn="";
		// End of the addition	

		//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
		String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="N";
		String from_OR=request.getParameter("from_OR");
		if(from_OR ==null)from_OR="N";
		String visit_flag_OP=request.getParameter("visit_flag_OP");
		if(visit_flag_OP==null) visit_flag_OP="N";	

		String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn");
		if(capture_fin_dtls_yn ==null) capture_fin_dtls_yn="";
		String speciality=request.getParameter("speciality");
		if(speciality ==null) speciality="";
		String clinic_old=request.getParameter("clinic_old");
		if(clinic_old ==null) clinic_old="";
		String practitioner_old=request.getParameter("practitioner_old");
		if(practitioner_old ==null) practitioner_old="";
		String practitioner_type=request.getParameter("practitioner_type");
		if(practitioner_type ==null) practitioner_type="";
	//	String or_catalogue_code=request.getParameter("or_catalogue_code");
	//	if(or_catalogue_code ==null) or_catalogue_code="";
		String pref_start_date=request.getParameter("pref_start_date");
		if(pref_start_date ==null) pref_start_date="";
		String pref_end_date=request.getParameter("pref_end_date");
		if(pref_end_date ==null) pref_end_date="";
		String no_dwm=request.getParameter("no_dwm");
		if(no_dwm ==null) no_dwm="";
		String visittype=(String)request.getParameter("visittype");
		if(visittype == null || visittype.equals("null")) visittype ="";
		String dwm_desc=request.getParameter("dwm_desc");
if(dwm_desc ==null) dwm_desc="";
 String from_page=request.getParameter("from_page");
if(from_page ==null) from_page="";
String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";

String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
if(noshow_ctrl_by_splty_or_clinic ==null ) noshow_ctrl_by_splty_or_clinic="";
String contact_num_reqd_yn= request.getParameter("contact_num_reqd_yn");
		if(contact_num_reqd_yn ==null) contact_num_reqd_yn="";
//Added by suman for getting the value from OP Checkout
		
	String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";

 String no_of_noshow_appts_for_alert =  request.getParameter("no_of_noshow_appts_for_alert");
  if(no_of_noshow_appts_for_alert ==null) no_of_noshow_appts_for_alert="";

String per_chk_for_no_show_alert    =   request.getParameter("per_chk_for_no_show_alert");
 if(per_chk_for_no_show_alert ==null) per_chk_for_no_show_alert="";

 String calledFrom    =   request.getParameter("calledFrom"); //Added by Sathish.S for IN020026 on Monday, March 22, 2010
 if(calledFrom ==null) calledFrom="";

 	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	String rule_appl_yn			= checkForNull(request.getParameter("rule_appl_yn"));
	String patient_id_temp		= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix_temp		= checkForNull(request.getParameter("name_prefix_temp"));
	String first_name_temp		= checkForNull(request.getParameter("first_name_temp"));
	String second_name_temp		= checkForNull(request.getParameter("second_name_temp"));
	String third_name_temp		= checkForNull(request.getParameter("third_name_temp"));
	String family_name_temp		= checkForNull(request.getParameter("family_name_temp"));
	String name_suffix_temp	=checkForNull(request.getParameter("name_suffix_temp"));	
	String name_prefix_oth_lang_temp	=checkForNull(request.getParameter("name_prefix_oth_lang_temp"));
	String first_name_oth_lang_temp	=checkForNull(request.getParameter("first_name_oth_lang_temp"));
	String second_name_oth_lang_temp	=checkForNull(request.getParameter("second_name_oth_lang_temp"));
	String third_name_oth_lang_temp	=checkForNull(request.getParameter("third_name_oth_lang_temp"));
	String family_name_oth_lang_temp	=checkForNull(request.getParameter("family_name_oth_lang_temp"));
	String name_suffix_oth_lang_temp	=checkForNull(request.getParameter("name_suffix_oth_lang_temp"));
	String gender_temp			= checkForNull(request.getParameter("gender_temp"));
	String contact_no_temp		= checkForNull(request.getParameter("contact_no_temp"));
	String nationality_code_temp= checkForNull(request.getParameter("nationality_code_temp"));
	String language_code_temp	= checkForNull(request.getParameter("language_code_temp"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String linking_code			= checkForNull(request.getParameter("linking_code")); 	
	String apptrefno			= checkForNull(request.getParameter("apptrefno")); 	
	
	

try{ 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinic_old));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_old));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pref_start_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pref_end_date));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(no_dwm));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(visittype));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dwm_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(position));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(addtl_splty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(decide));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(position));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(addtl_splty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(decide));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(position));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(addtl_splty));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_id_temp));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(name_prefix_temp));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(first_name_temp));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(second_name_temp));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(third_name_temp));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(family_name_temp));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(name_suffix_temp));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(name_prefix_oth_lang_temp));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(first_name_oth_lang_temp));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(second_name_oth_lang_temp));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(third_name_oth_lang_temp));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(family_name_oth_lang_temp));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(name_suffix_oth_lang_temp));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(gender_temp));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(contact_no_temp));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(nationality_code_temp));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(language_code_temp));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(linking_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);

	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
}catch(Exception ex){
	ex.printStackTrace();
 }finally{
	 ConnectionManager.returnConnection(con,request);
 }
            _bw.write(_wl_block76Bytes, _wl_block76);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bookappointment.label", java.lang.String .class,"key"));
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
