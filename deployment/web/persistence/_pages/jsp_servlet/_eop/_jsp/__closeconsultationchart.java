package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __closeconsultationchart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/CloseConsultationChart.jsp", 1709119431836L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\"DIRECT_VISIT_COMPL_PARAM_NOT_DEFINED\",\"OP\"));\n\t\t\t\t\t\t\thistory.go(-1);\n\t\t\t\t\t\t\tif(top.content.CommonToolbar.ShowMenu)\n\t\t\t\t\t\t\t\ttop.content.CommonToolbar.ShowMenu.click();\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'CONS_NOT_APPL\',\'CA\'));\n\t\t\t\t\t\t\thistory.go(-1);\n\t\t\t\t\t\t\tif(top.content.CommonToolbar.ShowMenu)\n\t\t\t\t\t\t\t\ttop.content.CommonToolbar.ShowMenu.click();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\"MANAGE_QUEUE_NOT_ALL_CHECKOUT\",\"OP\"));\n\t\t\t\t\t\t\thistory.go(-1);\n\t\t\t\t\t\t\tif(top.content.CommonToolbar.ShowMenu)\n\t\t\t\t\t\t\t\ttop.content.CommonToolbar.ShowMenu.click();\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\"PRACT_NOT_ASSIGN\",\"OP\"));\n\t\t\t\t\t\t\thistory.go(-1);\n\t\t\t\t\t\t\tif(top.content.CommonToolbar.ShowMenu)\n\t\t\t\t\t\t\t\ttop.content.CommonToolbar.ShowMenu.click();\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\"INAPPROPRAITE_BILLIG_SETUP\",\"OP\"));\n\t\t\t\t\t\t\thistory.go(-1);\n\t\t\t\t\t\t\tif(top.content.CommonToolbar.ShowMenu)\n\t\t\t\t\t\t\t\ttop.content.CommonToolbar.ShowMenu.click();\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script> \n\n\t\t\t\t\t\tfunction submitToServlet() {\n\n\t\t\t\t\t\t\tif(parent.messageFrame.document.body) {\n\t\t\t\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\t\n\t\t\t\t\t\t\t\tparent.messageFrame.document.Checkout_form.submit();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tvar HTMLVal  = \"<html><form name=\'Checkout_form\' id=\'Checkout_form\'action=\'../../servlet/eOP.PatCheckoutServlet\' method=\'post\'><input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'\'><input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'><input type=\'hidden\' name=\'Encounter\' id=\'Encounter\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\t<input type=\'hidden\' name=\'P_patient_id\' id=\'P_patient_id\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\t\t\t\t\t\t<input type=\'hidden\' name=\'P_locn_code\' id=\'P_locn_code\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\t\t\t\t\t\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\t\t\t\t\t\t<input type=\'hidden\' name=\'reg_reff_chkout_yn\' id=\'reg_reff_chkout_yn\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\t\t\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\t\t\t\t\t\t<input type=\'hidden\' name=\'episode_visit_num\' id=\'episode_visit_num\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\t\t\t<input type=\'hidden\' name=\'P_practitioner_id\' id=\'P_practitioner_id\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\t\t\t<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'><input type=\'hidden\' name=\'ae_treatment_area_code\' id=\'ae_treatment_area_code\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'><input type=\'hidden\' name=\'SickLeaveRecordFlag\' id=\'SickLeaveRecordFlag\' value=\'N\'><input type=\'hidden\' name=\'SickLeaveDetails\' id=\'SickLeaveDetails\' value=\'\'>\t<input type=\'hidden\' name=\'DECEASED_YN\' id=\'DECEASED_YN\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'> \t\t\t\t\t\t<input type=\'hidden\' name=\'Conclude\' id=\'Conclude\' value=\'\'>\t   \t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'medical_yn\' id=\'medical_yn\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\t\t\t\t\t\t\t<input type=\'hidden\' name=\'surgical_yn\' id=\'surgical_yn\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\t  \t\t\t\t\t<input type=\'hidden\' name=\'mlc_yn\' id=\'mlc_yn\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\t  \t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\'N\'><input type=\'hidden\' name=\'deceased_date_time\' id=\'deceased_date_time\' value=\'\'><input type=\'hidden\' name=\'released_date_time\' id=\'released_date_time\' value=\'\'> <input type=\'hidden\' name=\'postmortem_yn\' id=\'postmortem_yn\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'><input type=\'hidden\' name=\'tocomeback\' id=\'tocomeback\' value=\'N\'><input type=\'hidden\' name=\'high_risk_yn\' id=\'high_risk_yn\' value=\'N\'><input type=\'hidden\' name=\'bdead_yn\' id=\'bdead_yn\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'><input type=\'hidden\' name=\'days_unit\' id=\'days_unit\' value=\'\'><input type=\'hidden\' name=\'dat_val\' id=\'dat_val\' value=\'\'>\t\t\t\t\t<input type=\'hidden\' name=\'P_locn_type\' id=\'P_locn_type\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'> \t\t\t\t\t\t<input type=\'hidden\' name=\'circumstance_of_injury\' id=\'circumstance_of_injury\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\t<input type=\'hidden\' name=\'attending_practitioner\' id=\'attending_practitioner\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\t\t<input type=\'hidden\' name=\'inv_ordered1\' id=\'inv_ordered1\' value=\'\'><input type=\'hidden\' name=\'inv_ordered2\' id=\'inv_ordered2\' value=\'\'><input type=\'hidden\' name=\'inv_ordered3\' id=\'inv_ordered3\' value=\'\'>\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'disposition_date_time1\' id=\'disposition_date_time1\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\t\t\t<input type=\'hidden\' name=\'disposition_type\' id=\'disposition_type\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\t\t\t\t<input type=\'hidden\' name=\'reason\' id=\'reason\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'><input type=\'hidden\' name=\'instructionsrecall\' id=\'instructionsrecall\' value=\'\'><input type=\'hidden\' name=\'pract_assigned_yn\' id=\'pract_assigned_yn\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'><!-- <input type=\'hidden\' name=\'prn_visit_yn\' id=\'prn_visit_yn\' value=\'\'>\t<input type=\'hidden\' name=\'prn_visit_before\' id=\'prn_visit_before\' value=\'\'> --><input type=\'hidden\' name=\'p_queue_date\' id=\'p_queue_date\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'><input type=\'hidden\' name=\'dispReqd\' id=\'dispReqd\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><input type=\'hidden\' name=\'diagReqd\' id=\'diagReqd\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\t\t<input type=\'hidden\' name=\'notesReqd\' id=\'notesReqd\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'><input type=\'hidden\' name=\'arrive_date_time\' id=\'arrive_date_time\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'><input type=\'hidden\' name=\'vital_signs_date_time\' id=\'vital_signs_date_time\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'><input type=\'hidden\' name=\'i_appt_ref_no\' id=\'i_appt_ref_no\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'><input type=\'hidden\' name=\'visit_adm_type_ind\' id=\'visit_adm_type_ind\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>  <input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\'\'>\t  <input type=\'hidden\' name=\'pract_speciality\' id=\'pract_speciality\' value=\'\'><input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'><input type=\'hidden\' name=\'option_id\' id=\'option_id\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'><input type=\'hidden\' name=\'close_pat_chart_on_checkout_yn\' id=\'close_pat_chart_on_checkout_yn\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'></form></html>\"; \n\n\t\t\t\t\t\tsetTimeout(\"submitToServlet()\",200);\n\n\t\t\t\t\t\t</script> \t\t\n        \n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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

		request.setCharacterEncoding("UTF-8");	

		String fac_id       = (String) session.getValue( "facility_id" ) ;
		String userid                  = (String) session.getValue("login_user");
		String locale=(String)session.getAttribute("LOCALE"); 		
		
		String P_encounter_id = request.getParameter("episode_id") == null?"":request.getParameter("episode_id");	
		String P_locn_code = request.getParameter("location_code") == null?"":request.getParameter("location_code");	
		String P_locn_type = request.getParameter("location_type") == null?"":request.getParameter("location_type");	
		String P_patient_id = request.getParameter("patient_id") == null?"":request.getParameter("patient_id"); 
		String option_id = request.getParameter("option_id") == null?"":request.getParameter("option_id");	
		
		int visit_status =0;
		

		PreparedStatement stmt1=null;
		ResultSet rs1=null;

		PreparedStatement stmt=null;
		ResultSet rs=null;
		Connection con=null;

		StringBuffer sql               = new StringBuffer(); 	
		String practitioner_name       = "";		
		String episode_type="";
		String visit_type_code=""; 		
		String diagReqd="N";
		String notesReqd="N";
		String dispReqd="N";
		String OsVal = "";
		String vital_signs_date_time="";
		String arrive_date_time="";
		String close_pat_chart_on_checkout_yn="";		
		String called_from = "CA";
		String ca_practitioner_id="";
		String ca_pract_type="";
		

		if(called_from.equals("CA"))
		{
			ca_practitioner_id=(String) session.getValue("ca_practitioner_id") ;
			if(ca_practitioner_id == null)ca_practitioner_id="";
		}	
		
		
		String P_practitioner_id = "";			
		String p_queue_date="";	  		   
		String P_module_id = ""; 
		String P_ae_brought_dead_yn = "";		
		String P_ae_treatment_area_code = ""; 		
		String patient_class="";
		int mother_cut_off_age=0;
		int mother_max_age=0;
		int mother_min_age=0; 	
		String appt_id="";
		String visit_adm_type_ind=""; 		   
		String X_visit_type_desc    ="";
		String X_attend_prac_id     ="";
		String X_episode_id ="";			
		String systemdatetime="";		
		String check_out_yn="";	 		
		String episode_visit_num="";  
		String referral_id = "";	
		int patientage=0;
		String patientgender=""; 		
		String X_pract_assigned_yn = "N";			
		String mlc_yn=""; 	  
		String deceased_time="";
		String dronly="";
		String ddis="";
		String medical_yn="";
		String surgical_yn="";
		String spec_code=""; 		
		String reg_reff_chkout_yn="";
		String disposition_type="";	
		String circumstance_of_injury="";	
		String reason="";
		String deceased_yn = "";
		String charging_stage = "";
		String med_charging_stage = "";

		try
			{
				con=ConnectionManager.getConnection(request);

				stmt1 = con.prepareStatement("Select nvl(DISP_REQD_FOR_MDS_YN,'N') DISP_YN, nvl(DIAG_REQD_FOR_MDS_YN,'N') DIAG_YN, nvl(NOTES_REQD_FOR_MDS_YN,'N') NOTES_YN,REG_REFERRAL_ON_CHECKOUT_YN ,DISP_TYPE_FOR_CHECKOUT,close_pat_chart_on_checkout_yn  from OP_PARAM where operating_facility_id = '"+fac_id+"'");
				
				rs1 = stmt1.executeQuery();
				if(rs1!=null  && rs1.next())
				{	
					dispReqd=rs1.getString("DISP_YN");
					diagReqd=rs1.getString("DIAG_YN");
					notesReqd=rs1.getString("NOTES_YN");
		            reg_reff_chkout_yn=rs1.getString("REG_REFERRAL_ON_CHECKOUT_YN");
			        disposition_type=rs1.getString("DISP_TYPE_FOR_CHECKOUT"); 		         close_pat_chart_on_checkout_yn=rs1.getString("close_pat_chart_on_checkout_yn")==null?"N":
						rs1.getString("close_pat_chart_on_checkout_yn");			
					if(disposition_type==null)disposition_type="";
				}
				if(rs1 != null) rs1.close();
				if(stmt1 != null) stmt1.close();

				stmt1 = con.prepareStatement("SELECT CHARGING_STAGE, MED_CHARGING_STAGE FROM BL_OP_CLINIC WHERE	FACILITY_ID = '"+fac_id+"' AND CLINIC_CODE = '"+P_locn_code+"' AND CHARGING_STAGE IS NOT NULL");

				rs1 = stmt1.executeQuery();
				if(rs1!=null  && rs1.next())
				{	
					charging_stage = rs1.getString("CHARGING_STAGE");
					med_charging_stage = rs1.getString("MED_CHARGING_STAGE");
				}
				
				if(rs1 != null) rs1.close();
				if(stmt1 != null) stmt1.close();	

				stmt1=con.prepareStatement("Select queue_Status visit_status, practitioner_id attend_practitioner_id, patient_class, brought_dead_yn, treatment_area_code  from op_patient_queue where facility_id  = '"+fac_id+"' and encounter_id = "+P_encounter_id+"");
				rs1=stmt1.executeQuery();

				if(rs1!=null)
				{
					while(rs1.next()){
						visit_status=rs1.getInt(1);
						P_practitioner_id=rs1.getString("attend_practitioner_id")==null?"":rs1.getString("attend_practitioner_id");
						patient_class=rs1.getString("patient_class");
						P_ae_treatment_area_code=rs1.getString("treatment_area_code")==null?"":rs1.getString("treatment_area_code");
						P_ae_brought_dead_yn = rs1.getString("brought_dead_yn");
						if(P_ae_brought_dead_yn==null) P_ae_brought_dead_yn="N";
						if(P_ae_brought_dead_yn.equals("Y"))
							deceased_yn	 = "Y";
					}
				}
				if(rs1!=null) rs1.close();
				if(stmt1!=null) stmt1.close();
				if(patient_class.equals("EM"))
				{
					P_module_id="AE";						

					/*String sql_ae2="Select treatment_area_code from op_patient_queue where facility_id='"+fac_id+"' and encounter_id="+P_encounter_id+" ";
					stmt=con.prepareStatement(sql_ae2);
					rs=stmt.executeQuery();

					if(rs!=null)
					{
						while(rs.next())
						{
							P_ae_treatment_area_code = rs.getString(1);
						}
					}*/

				}
				else
					P_module_id = "OP";

				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();

				if(called_from.equals("CA")) { 				
					String sql_new = "Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') FROM dual" ;  
						
					stmt=con.prepareStatement(sql_new);
					rs=stmt.executeQuery();
					rs.next();
					OsVal=rs.getString(1);
					
					if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
					{
					   check_out_yn="Y";
					} else {
					   check_out_yn="N";
					}  	
					if(rs!=null)
						rs.close();
					if(stmt!=null)
						stmt.close();
				} else {
					 check_out_yn="Y";
				}

				if(close_pat_chart_on_checkout_yn.equals("N") || reg_reff_chkout_yn.equals("Y")) {
					
            _bw.write(_wl_block6Bytes, _wl_block6);
 				

				} else if(rs1==null ||  visit_status>=7) {
					
            _bw.write(_wl_block7Bytes, _wl_block7);


				}  else if(check_out_yn.equals("N")) {
					
            _bw.write(_wl_block8Bytes, _wl_block8);

				} else if(P_practitioner_id.equals("")) {
					
            _bw.write(_wl_block9Bytes, _wl_block9);
					
				} else if(charging_stage.equals("COMP") || med_charging_stage.equals("COMP")) {
					
            _bw.write(_wl_block10Bytes, _wl_block10);

				}
				else
				{
						sql.append("SELECT  SERVICE_CODE,am_get_desc.am_service(SERVICE_CODE,'"+locale+"',2)SERVICE_desc,  TO_CHAR(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time   ,a. patient_class   ,a.patient_class Nature,a.LOCN_CODE assign_care_locn_code ,a.LOCN_TYPE assign_care_locn_type  ,a.VISIT_TYPE_CODE adm_type  ,op_get_desc.OP_VISIT_TYPE(facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type ,DECODE(a.practitioner_id,'*ALL','',a. practitioner_id) prac_id ,a.referral_id  ,CALCULATE_AGE(TO_CHAR(c.DATE_OF_BIRTH,'DD/MM/YYYY'),1)age ,c.sex,a.arrive_date_time arrive_date_time ,a.vital_signs_date_time vital_signs_date_time,a.VISIT_TYPE_IND visit_adm_type_ind,a.appt_id appt_id  ,a.episode_id episode_id,a.OP_EPISODE_VISIT_NUM episode_visit_num,a.treatment_area_code treatment_area_code  ,a.mlc_yn mlc_yn  ,TO_CHAR(c.DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_time  ,a.medical_yn medical_yn  ,a.surgical_yn surgical_yn  ,a.SPECIALITY_CODE SPECIALTY_CODE,TO_CHAR(a.queue_date,'dd/mm/yyyy') queue_date, TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') sydate  ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1) practitioner_name FROM  op_patient_queue a ,mp_patient c WHERE a.facility_id = '"+fac_id+"' AND a.encounter_id = '"+P_encounter_id+"' AND a.patient_id=c.patient_id"); 	   		
			
						stmt=con.prepareStatement(sql.toString());
						rs = stmt.executeQuery();
						if(rs!=null && rs.next())
						{                  
								   
							X_visit_type_desc = (rs.getString("visit_type") == null)?"":rs.getString("visit_type");
							X_attend_prac_id = (rs.getString("prac_id") == null)?"":rs.getString("prac_id");
							practitioner_name = (rs.getString("practitioner_name") == null)?"":rs.getString("practitioner_name");

							if(X_attend_prac_id == null)
								X_attend_prac_id="";
							
							P_locn_code = rs.getString("assign_care_locn_code") ;
							if(P_locn_code==null)   P_locn_code = "" ;
							P_locn_type = rs.getString("ASSIGN_CARE_LOCN_TYPE") ;
							if(P_locn_type==null)   P_locn_type = "" ; 							
							referral_id = rs.getString("referral_id");
							if(referral_id == null || referral_id.equals("null")) referral_id = "";
							patient_class=(rs.getString("patient_class")== null)?"":rs.getString("patient_class");
							if(patient_class.equals("EM"))
							episode_type="E";	
							else
							episode_type="O";	 
							
							patientage=Integer.parseInt(rs.getString("age"));
							patientgender=(rs.getString("sex") == null)?"":rs.getString("sex");
							arrive_date_time= (rs.getString("arrive_date_time") == null)?"":rs.getString("arrive_date_time");
							vital_signs_date_time=(rs.getString("vital_signs_date_time") == null)?"":rs.getString("vital_signs_date_time");
							visit_adm_type_ind=(rs.getString("visit_adm_type_ind") == null)?"":rs.getString("visit_adm_type_ind");
							appt_id=(rs.getString("appt_id") == null)?"":rs.getString("appt_id");
							X_episode_id=(rs.getString("episode_id") == null)?"":rs.getString("episode_id");
							visit_type_code=(rs.getString("adm_type") == null)?"":rs.getString("adm_type");
							episode_visit_num =(rs.getString("episode_visit_num") == null)?"":rs.getString("episode_visit_num");

							if(P_ae_treatment_area_code.equals(""))
							{
								P_ae_treatment_area_code=(rs.getString("treatment_area_code") == null)?"":rs.getString("treatment_area_code");
							}
							
							P_practitioner_id=X_attend_prac_id;

							mlc_yn=rs.getString("mlc_yn");
							if(mlc_yn == null) mlc_yn="N";
							deceased_time=rs.getString("deceased_time");
							
							if(deceased_time == null) deceased_time="";

							if(!deceased_time.equals(""))
							{
								dronly="";
								ddis="";
							}
							else
							{
								dronly="readOnly";
								ddis="disabled";
							}
							
							medical_yn=rs.getString("medical_yn");
							if(medical_yn == null) medical_yn="N";

							surgical_yn=rs.getString("surgical_yn");
							if(surgical_yn == null) surgical_yn="N"; 
							
							spec_code=rs.getString("SPECIALTY_CODE");
							if(spec_code == null) spec_code="";
							p_queue_date=rs.getString("queue_date");
							if(p_queue_date == null) p_queue_date="";
							systemdatetime = rs.getString("sydate"); 							
												
							if(patientgender.equals("F"))
							{
								stmt1=con.prepareStatement("select nb_mother_cutoff_age mother_cut_off_age, nb_mother_upper_age mother_max_age,nb_mother_min_age mother_min_age from mp_param");
								rs1=stmt1.executeQuery();
								if(rs1 != null && rs1.next())
								{
									mother_cut_off_age=(rs1.getString("mother_cut_off_age")	== null)?Integer.parseInt("0"):							Integer.parseInt(rs1.getString("mother_cut_off_age"));
									mother_max_age=(rs1.getString("mother_max_age")	== null)?Integer.parseInt("0"):Integer.parseInt(rs1.getString("mother_max_age"));
									mother_min_age=(rs1.getString("mother_min_age")	== null)?Integer.parseInt("0"):Integer.parseInt(rs1.getString("mother_min_age"));

								}

								if(rs1 != null) rs1.close();
								if(stmt1 != null) stmt1.close();
							}              
						 }

						if(rs != null) rs.close();
						if(stmt != null) stmt.close();		
						sql.setLength(0);

						if(called_from.equals("CA") && patient_class.equals("EM"))
						{
							stmt=con.prepareStatement("select PRACT_TYPE from am_practitioner where practitioner_id='"+ca_practitioner_id+"'");
							rs=stmt.executeQuery();
							if(rs != null && rs.next())
							{
								ca_pract_type=rs.getString("PRACT_TYPE");
							}

							
							if(rs != null) rs.close();
							if(stmt != null) stmt.close();
						}
						if((!X_attend_prac_id.equals("") && !patient_class.equals("EM"))  || ((called_from.equals("CA") && !patient_class.equals("EM")) || ((called_from.equals("CA") && patient_class.equals("EM")) && (!ca_pract_type.equals("MD") && !ca_pract_type.equals("SG") && !ca_pract_type.equals("PS") && !ca_pract_type.equals("DN")))))
						{
							P_practitioner_id = X_attend_prac_id;	
						}
						else
						{
							X_pract_assigned_yn = "Y";						
						}  

						stmt=con.prepareStatement("Select short_desc, circumstance_of_injury_code from AM_CIRCUM_OF_INJURY_LANG_VW where language_id='"+locale+"' and eff_status = 'E' order by short_desc ");
						rs = stmt.executeQuery();

						if( rs != null )
						{
							while( rs.next() )
							{
								 circumstance_of_injury = rs.getString( "circumstance_of_injury_code" );  		 
							}
						}

						if(rs != null) rs.close();
						if(stmt != null) stmt.close();

						stmt=con.prepareStatement("select contact_reason_code,contact_reason from am_contact_reason_lang_vw where nvl(REASON_FOR_RECALL_YN,'N') = 'Y' and eff_status='E' and language_id='"+locale+"' order by contact_reason");	
						rs=stmt.executeQuery();
						if(rs != null)
						{
							while(rs.next())
							{
								reason = rs.getString("contact_reason_code");
								
								
							}
						}
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
							

	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_locn_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(reg_reff_chkout_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(X_episode_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_visit_num));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_module_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_ae_treatment_area_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(surgical_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_ae_brought_dead_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(circumstance_of_injury));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(X_attend_prac_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(systemdatetime));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disposition_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(X_pract_assigned_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dispReqd));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(diagReqd));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(notesReqd));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(arrive_date_time));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(vital_signs_date_time));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(visit_adm_type_ind));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(close_pat_chart_on_checkout_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);

				}
				
			}catch(Exception e)
			{
				out.println("Exception::"+e);
				e.printStackTrace();	
			}
			finally
			{
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();

				if(stmt1!=null) stmt1.close();
				if(rs1!=null) rs1.close();
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}

            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
