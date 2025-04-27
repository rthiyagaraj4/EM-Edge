package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;

public final class __scheduleresult1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ScheduleResult1.jsp", 1727688706320L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\t\t\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<!-- Below frame modified for this incident  [IN:048861]-->\n<html>\n\t<iframe name=\'arrows\' id=\'arrows\' src=\"../../eOA/jsp/DisplayArrows.jsp?Date=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="&end_date=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" frameborder=no scrolling=no noresize style=\'height:9vh;width:98vw\'></iframe>\n\t<iframe name=\'result1\' id=\'result1\' src=\"../../eOA/jsp/ScheduleResult.jsp?order_catalog_code=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&order_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&order_line_num=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&week=no&month=yes&days=no&Date=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&oper_stn_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&clinic=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&practitioner=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&practitioner_type=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&visittype=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&speciality=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&ca_patient_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&pref_start_date=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&pref_end_date=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&call_date_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&disp_ear_sch=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&ca_mode=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&callingMode=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&hddSpeclty=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&Difference=0&care_locn_ind=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&res_class=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&or_catalogue_code=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&specialty_codema1=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&req_id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&install_yn_val=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&from_OR=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&create_wait_list_yn=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&visit_flag_OP=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&no_dwm=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&dwm_desc=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&from_page=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&noshow_ctrl_by_splty_or_clinic=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&min_ela_per_resc_noshow_in_day=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&from_facility_id=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&from_encounter_id=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&calledFrom=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&position=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&addtl_splty=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&patient_id_temp=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&name_prefix=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&first_name=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&second_name=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&third_name=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&family_name=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&name_suffix=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&name_prefix_oth_lang=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&first_name_oth_lang=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&second_name_oth_lang=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&third_name_oth_lang=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&family_name_oth_lang=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&name_suffix_oth_lang=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&gender=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&contact_no=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&language_code_temp=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&nationality_code_temp=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&term_set_id=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&linking_code=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&rd_appt_yn=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&schedule_gender=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" frameborder=no scrolling=\'auto\' noresize style=\'height:67vh;width:98vw\'></iframe>\n\t<iframe name=\'checkbox\' id=\'checkbox\' src=\'../../eOA/jsp/CheckBoxDisplay.jsp?disp_ear_sch=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'  frameborder=0 scrolling=\'no\' style=\'height:14vh;width:98vw\'></iframe>\n\n</html>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );


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
			
		request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			String order_catalog_code=request.getParameter("order_catalog_code");
			if(order_catalog_code==null) order_catalog_code="";
			String Date=(String)request.getParameter("Date");
			String end_date=(String)request.getParameter("end_date");
			String pref_start_date=(String)request.getParameter("pref_start_date");
			String pref_end_date=(String)request.getParameter("pref_end_date");
			String call_date_yn=(String)request.getParameter("call_date_yn");
			String clinic=(String)request.getParameter("clinic");
			String practitioner=(String)request.getParameter("practitioner");
			String practitioner_type=(String)request.getParameter("practitioner_type");
			String speciality=(String)request.getParameter("speciality");
			String disp_ear_sch=(String)request.getParameter("disp_ear_sch");			
			String visittype=(String)request.getParameter("visittype");
			String oper_stn_id=(String)request.getParameter("oper_stn_id");
			String ca_mode=(String)request.getParameter("ca_mode");
			String ca_patient_id=(String)request.getParameter("ca_patient_id");	
			String hddSpeclty=(String)request.getParameter("hddSpeclty");
			String care_locn_ind=request.getParameter("care_locn_ind");
			String res_class=request.getParameter("res_class");
			String visit_flag_OP=request.getParameter("visit_flag_OP");
			if(visit_flag_OP==null) visit_flag_OP="N";	
//Added by suman for getting the value from OP Checkout
		
	String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";

			//Added by suman for getting the value for Calling Mode and OR related values
		
			String callingMode=(String)request.getParameter("callingMode");		
			if (callingMode==null) callingMode = "";

			String calledFrom=(String)request.getParameter("calledFrom");	//Added by Sathish.S for IN020026 onMonday, March 22, 2010 
			if (calledFrom==null) calledFrom = "";
			

			String order_line_num=request.getParameter("order_line_num");
			if(order_line_num==null) order_line_num="";

			String order_id=request.getParameter("order_id");
			if(order_id ==null) order_id="";

			String or_catalogue_code=request.getParameter("or_catalogue_code");
			if(or_catalogue_code==null) or_catalogue_code="";

			String specialty_codema1=request.getParameter("specialty_codema1");
			if(specialty_codema1 ==null) specialty_codema1="";
			//ends hre
		//MR
			String req_id=request.getParameter("req_id");
			if(req_id ==null) req_id="";
			String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="N";

	String from_OR=request.getParameter("from_OR");
	if(from_OR==null) from_OR="N";
	String create_wait_list_yn=request.getParameter("create_wait_list_yn");
	if(create_wait_list_yn ==null) create_wait_list_yn="";
	String no_dwm=request.getParameter("no_dwm");
	if(no_dwm ==null) no_dwm="";
String dwm_desc=request.getParameter("dwm_desc");
if(dwm_desc ==null) dwm_desc="";
 String from_page=request.getParameter("from_page");
if(from_page ==null) from_page="";
 String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
 if(noshow_ctrl_by_splty_or_clinic ==null) noshow_ctrl_by_splty_or_clinic="";
 String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
 if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";
 String position=request.getParameter("position")==null?"":request.getParameter("position");
 String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
 
 	String patient_id_temp			= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix				= checkForNull(request.getParameter("name_prefix")); 
	String first_name				= checkForNull(request.getParameter("first_name")); 
	String second_name				= checkForNull(request.getParameter("second_name"));
	String third_name				= checkForNull(request.getParameter("third_name")); 
	String family_name				= checkForNull(request.getParameter("family_name"));
	String name_suffix				= checkForNull(request.getParameter("name_suffix")); 
	
	String name_prefix_oth_lang				= checkForNull(request.getParameter("name_prefix_oth_lang")); 
	String first_name_oth_lang				= checkForNull(request.getParameter("first_name_oth_lang")); 
	String second_name_oth_lang				= checkForNull(request.getParameter("second_name_oth_lang"));
	String third_name_oth_lang				= checkForNull(request.getParameter("third_name_oth_lang")); 
	String family_name_oth_lang				= checkForNull(request.getParameter("family_name_oth_lang"));
	String name_suffix_oth_lang				= checkForNull(request.getParameter("name_suffix_oth_lang")); 
	String gender					= checkForNull(request.getParameter("gender")); 
	String contact_no				= checkForNull(request.getParameter("contact_no"));
	String language_code_temp		= checkForNull(request.getParameter("language_code_temp")); 
	String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
	String term_set_id				= checkForNull(request.getParameter("term_set_id"));
	String linking_code				= checkForNull(request.getParameter("linking_code")); 
	String rd_appt_yn				= checkForNull(request.getParameter("rd_appt_yn")); 
	String schedule_gender				= checkForNull(request.getParameter("schedule_gender")); //Added for this CRF [Bru-HIMS-CRF-167]

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(Date));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Date));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(clinic));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(visittype));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pref_start_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pref_end_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(call_date_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disp_ear_sch));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(hddSpeclty));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(care_locn_ind));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(specialty_codema1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(no_dwm));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dwm_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(position));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(addtl_splty));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id_temp));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(name_suffix));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(name_prefix_oth_lang));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(first_name_oth_lang));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(second_name_oth_lang));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(third_name_oth_lang));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(family_name_oth_lang));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(name_suffix_oth_lang));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(contact_no));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(language_code_temp));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(nationality_code_temp));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(linking_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(schedule_gender));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(disp_ear_sch));
            _bw.write(_wl_block63Bytes, _wl_block63);
            _bw.write(_wl_block64Bytes, _wl_block64);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
