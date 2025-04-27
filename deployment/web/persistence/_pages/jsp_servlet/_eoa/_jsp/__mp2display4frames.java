package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __mp2display4frames extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/MP2Display4Frames.jsp", 1734679570315L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'javascript\'></script>\n</head>\n\t<!--<iframe name=\'query\' id=\'query\' src=\'../../eOA/jsp/MP2DisplayLabels.jsp?value_chk=display0&clinic_code1=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="&practitioner_id1=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&clinic_code2=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&callingMode=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&practitioner_id2=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&Date=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&Date1=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&value12=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&value13=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&old_clinic=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&old_practitioner=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&pre_pat_alcn_catg_code=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&ca_patient_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&ca_mode=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&mode_find=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&clinic_type1=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&res_type1=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&clinic_type2=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&res_type2=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&or_catalogue_code=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&oper_stn_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&alcn_criteria=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&visit_limit_rule=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&slot_appt_ctrl =";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&override_no_of_slots_yn=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&req_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&install_yn_val=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' frameborder=no scrolling=no noresize style=\'height:100vh;width:100vw\'></iframe>  --> \n\t<iframe name=\'result\' id=\'result\' style=\'height:80vh;width:48vw\' src=\'../../eOA/jsp/MP2DisplayResults.jsp?value_chk=display0&clinic_code1=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&old_from_time=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&old_to_time=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&old_date=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&order_id=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&order_line_num=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&order_catalog_code=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&slot_appt_ctrl=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&create_wait_list_yn=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&visit_flag_OP=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&capture_fin_dtls_yn=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&from_page=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&noshow_ctrl_by_splty_or_clinic=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&min_ela_per_resc_noshow_in_day=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&from_facility_id=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&from_encounter_id=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&contact_num_reqd_yn=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&no_of_noshow_appts_for_alert=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&per_chk_for_no_show_alert=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&rd_appt_yn=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' frameborder=no noresize scrolling=auto ></iframe>\n\t<!-- <iframe name=\'query\' id=\'query\' src=\'../../eOA/jsp/MP2DisplayLabels.jsp?value_chk=display1&clinic_code1=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' frameborder=no scrolling=no noresize style=\'height:100vh;width:100vw\'></iframe> --> \n\t<iframe name=\'result\' id=\'result\' style=\'height:80vh;width:50vw\' src=\'../../eOA/jsp/MP2DisplayResults.jsp?value_chk=display1&clinic_code1=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' frameborder=no noresize scrolling=auto ></iframe>\n</html>\n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

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
	    // Modified for CRF - SRR -0425 -- Order Catalog.



		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//Added for getting value for Calling Mode 
		String callingMode = request.getParameter("callingMode");
		if (callingMode==null) callingMode = "";
		// End of the addition	
		String mode_find=request.getParameter("mode_find");		
		String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
		if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";
		String clinic_code1=(String)request.getParameter("clinic_code1");
		String practitioner_id1=(String)request.getParameter("practitioner_id1");
		String clinic_code2=(String)request.getParameter("clinic_code2");
		String practitioner_id2=(String)request.getParameter("practitioner_id2");
		String value12=(String)request.getParameter("value12");
		String value13=(String)request.getParameter("value13");
		// addend by Suman 
		String order_id=request.getParameter("order_id");
		if(order_id==null) order_id="";
			String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";
		String order_line_num=request.getParameter("order_line_num");
		if(order_line_num==null) order_line_num="";
		 String from_page=request.getParameter("from_page");
		if(from_page ==null) from_page="";
		String order_catalog_code=request.getParameter("order_catalog_code");
		if(order_catalog_code ==null) order_catalog_code="";

		String or_catalogue_code=request.getParameter("or_catalogue_code");
		if(or_catalogue_code ==null) or_catalogue_code="";



		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id == null) oper_stn_id="";


		//Added by Suman ends hre

		String Date=(String)request.getParameter("Date");
		String Date1=(String)request.getParameter("Date1");
		String old_clinic=(String)request.getParameter("old_clinic");
		if(old_clinic  == null || old_clinic.equals("null"))old_clinic="";

		String old_practitioner=(String)request.getParameter("old_practitioner");
		if(old_practitioner== null || old_practitioner.equals("null"))old_practitioner="";

		String old_from_time = request.getParameter("old_from_time");
		if( old_from_time == null) old_from_time="";

		String old_to_time = request.getParameter("old_to_time");
		if( old_to_time == null) old_to_time="";

		String old_date=(String)request.getParameter("old_date");
		if(old_date  == null || old_date.equals("null")) old_date="";
		String ca_mode=(String)request.getParameter("ca_mode");
		String ca_patient_id=(String)request.getParameter("ca_patient_id");
		String clinic_type1=request.getParameter("clinic_type1");
		String res_type1=request.getParameter("res_type1");
		String clinic_type2=request.getParameter("clinic_type2");
		String res_type2=request.getParameter("res_type2");

		if (clinic_type1==null) clinic_type1 = "C";
		if (res_type1==null) res_type1 = "P";

		if (clinic_type2==null) clinic_type2 = "C";
		if (res_type2==null) res_type2 = "P";
			//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
			String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="";
			String visit_flag_OP=request.getParameter("visit_flag_OP");
					if(visit_flag_OP==null) visit_flag_OP="N";	



			 //OPCheckout
		String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";

		String slot_appt_ctrl=request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
		String visit_limit_rule=request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule");
		String alcn_criteria=request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn")==null?"":request.getParameter("override_no_of_slots_yn");
		String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn")==null?"N":request.getParameter("capture_fin_dtls_yn");
		String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day")==null?"":request.getParameter("min_ela_per_resc_noshow_in_day");
		String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic")==null?"":request.getParameter("noshow_ctrl_by_splty_or_clinic");
		String contact_num_reqd_yn=request.getParameter("contact_num_reqd_yn")==null?"N":request.getParameter("contact_num_reqd_yn");
		String no_of_noshow_appts_for_alert=request.getParameter("no_of_noshow_appts_for_alert")==null?"":request.getParameter("no_of_noshow_appts_for_alert");
		String per_chk_for_no_show_alert=request.getParameter("per_chk_for_no_show_alert")==null?"":request.getParameter("per_chk_for_no_show_alert");
		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn"); 

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(practitioner_id1));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(clinic_code2));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(practitioner_id2));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Date));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Date1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(value12));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(value13));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_clinic));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(old_practitioner));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mode_find));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clinic_type1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(res_type1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(clinic_type2));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(res_type2));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(practitioner_id1));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(clinic_code2));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(practitioner_id2));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Date));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Date1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(value12));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(value13));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_clinic));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(old_practitioner));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(old_from_time));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(old_to_time));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mode_find));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clinic_type1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(res_type1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(clinic_type2));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(res_type2));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(practitioner_id1));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(clinic_code2));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(practitioner_id2));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Date));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Date1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(value12));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(value13));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_clinic));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(old_practitioner));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mode_find));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clinic_type1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(res_type1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(clinic_type2));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(res_type2));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(practitioner_id1));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(clinic_code2));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(practitioner_id2));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Date));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Date1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(value12));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(value13));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_clinic));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(old_practitioner));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(old_from_time));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(old_to_time));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mode_find));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clinic_type1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(res_type1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(clinic_type2));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(res_type2));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
