package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import blipin.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __findpatientdischarge extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/FindPatientDischarge.jsp", 1732948032711L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- MOD#0A import blipin.* -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t<script>alert(getMessage(\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\',\'IP\'));</script>\n\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t<script>alert(getMessage(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\',\'BL\'));</script>\n\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t <script>alert(getMessage(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'BL\'));</script>\n\t\t\t ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\n\t\t\t<script>alert(getMessage(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<input type = \'hidden\' name =\'err_mesg\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script> \n\n\t\tfindPatDischOnload();\n\n\t\tasync function findPatDischOnload(){\n\t\t\n\t\t\tvar frames_list = parent.frames[2].document.forms[0];\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\tif( frames_list.modal.value != \'yes\')\n\t\t\t{\n\t\t\t\t\n\t\t\t\tvar jsp_name1=frames_list.jsp_name.value;\n\t\t\t\t/*alert(jsp_name1)\n\t\t\t\t//10/17/2008\t\n\t\t\t\tvar call_function = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'\n\t\t\t\tvar bed_no = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'\n\t\t\t\t//\n\t\t\t\tif(call_function == \'TransferPatient\')\n\t\t\t\t{\n\t\t\t\t//var jsp_name1=parent.frames[2].document.forms[0].jsp_name.value;\n\t\t\t\tif(bed_no==\"\"){\n\t\t\t\t\t\t\tvar confirmref=window.confirm(getMessage(\'BED_CAN_NOT_ASSIGN_CONFIRM\',\"IP\"));\n\n\t\t\t\t\t\tif(confirmref)\n\t\t\t\t\t\t\tjsp_name1=\'AssignBedMain.jsp\';\n\n\t\t\t\t\t\t\telse \n\t\t\t\t\t\t\t jsp_name1=\"PaintEmergencyTransfer.jsp\";\t\n\t\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//10/17/2008\n\t\t\t\t*/\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tvar patient_id\t= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\t\n\t\t\t\tvar encid\t\t= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\tvar practitioner_id = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\t\n\t\t\t\tvar call_function = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\tvar sex = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\t\t\t\n\t\t\t\tvar IPval = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\t\t\n\t\t\t\tvar p_service_type = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"; \t\t\t\t\n\t\t\t\tvar function_id = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"; \t\t\t\t\n\n\t\t\t\tvar win_height=frames_list.win_height.value;\n\t\t\t\t\tif(win_height == \"\" || win_height <= 27) win_height=\"32\";\n\t\t\t\t\n\t\t\t\tvar dialogTop=frames_list.dialogTop.value;\n\t\t\t\t\tif(dialogTop == \"\") dialogTop=\"80\";\t\t\t\t\n\t\t\t\t\n\t\t\t\tvar win_width=frames_list.win_width.value;\n\t\t\t\t\tif(win_width == \"\") win_width=\"40\";\n\t\t\t\t\n\t\t\t\tvar module1=frames_list.module.value;\n\t\t\t\t\tif(module1 == \"\") module1=\"eIP\";\n\t\t\t\t\n\t\t\t\tvar model_window=frames_list.model_window.value;\n\t\t\t\tif( model_window == \"\") model_window =\"\";\n\n\t\t\t\tif( model_window == \'NO\')\n\t\t\t\t{  \n\t\t\t\t\t//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527\n\t\t\t\t\tparent.parent.frames[1].document.location.href=\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?encounterId=\"+encid+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_d+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex+\"&function_id=\"+function_id+\"&weight_on_admn_mandatory=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&height_on_admn_mandatory=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&enable_height_bmi_pat_cls=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\tif( model_window == \'N\')\n\t\t\t\t{\t\n\t\t\t\t\t//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527\n\t\t\t\t\tparent.frames[3].document.location.href=\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?encounterId=\"+encid+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_id+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex+\"&function_id=\"+function_id+\"&weight_on_admn_mandatory=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\t}\t\t\t\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\tvar dialogHeight= \"95vh\";\n\t\t\t\t\tvar dialogWidth = \"85vw\";\n\t\t\t\t\tvar dialogHeight= \"95vh\";\n\t\t\t\t\tvar dialogPadding = \"3px\";\n\t\t\t\t\tvar dialogTop\t= \"0vh\";\n\t\t\t\t\tif(call_function==\"CANCEL_DISCHARGE_PATIENT\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tdialogHeight= \"95vh\";\n\t\t\t\t\t\tdialogWidth = \"85vw\";\n\t\t\t\t\t\tdialogTop\t= \"0vh\";\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tvar center = \"1\" ;\n\t\t\t\t\tvar status=\"no\";\n\t\t\t\t\t\n\t\t\t\t\tvar features\t=\"dialogPadding:\" + dialogPadding + \";dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\t\tvar arguments\t= \"\" ;\t\n\n\t\t\t\t\t/*alert(\"module1------------->\"+module1);\n\t\t\t\t\talert(\"jsp_name1------------->\"+jsp_name1);\n\t\t\t\t\talert(\"IPval------------->\"+IPval);\n\t\t\t\t\talert(\"encid------------->\"+encid);\n\t\t\t\t\talert(\"patient_id------------->\"+patient_id);\n\t\t\t\t\talert(\"practitioner_id------------->\"+practitioner_id);\n\t\t\t\t\talert(\"call_function------------->\"+call_function);\n\t\t\t\t\talert(\"p_service_type.value------------->\"+p_service_type.value);\n\t\t\t\t\talert(\"sex------------->\"+sex);\n\t\t\t\t\talert(\"function_id------------->\"+function_id);*/\n\t\t\t\t\t\n\t\t\t\t\tretVal = await parent.window.showModalDialog(\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?location_code=\"+IPval+\"&encounterId=\"+encid+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_id+\"&callfrom=IP&call_function=\"+call_function+\"&p_service_type=\"+p_service_type.value+\"&Sex=\"+sex+\"&mode=modal&function_id=\"+function_id+\"&bl_interfaced_yn=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&discharge_checklist_app_yn=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&bed_block_period_dis=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&dis_date_chk_days=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&dis_date_chk_days_unit=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&diag_update_period_max_unit=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&max_disch_period_for_predc=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&deactivate_pseudo_bed_yn=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&allow_late_discharge_reason=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&disch_reason_mand_yn=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&weight_on_admn_mandatory=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" ,arguments,features);\n\t\t\t\t\t//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527\n\t\t\t\t\tparent.frames[2].document.location.reload();\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\twindow.parent.returnValue=enc;\n\t\t\t\twindow.parent.close();\n\t\t\t}\n\t\t}\n\t\t</script> \n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	Connection con  = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rsetBL = null;
    con = ConnectionManager.getConnection(request);	
	
	String bl_operational =	(String)session.getValue("bl_operational");
	//String loginUser		=	checkForNull((String)session.getValue("login_user"));
	String err_mesg = "";
	String dis_adv_status = "";
	String disc_blg_stage = "";
	String disc_bill_exists = "";
	//String rect_loc_code    = "";
	//String cancel_bill = "";
	String mode = request.getParameter("mode");
		if (mode==null) mode = "";

	String patient_id = request.getParameter("patient_Id");
		if (patient_id==null) patient_id = "";
	
	String encid		= request.getParameter("encounter_Id");
		if (encid==null) encid = "";
	
	String practitioner_id = request.getParameter("practitioner_Id");
		if (practitioner_id==null) practitioner_id ="";
	
	String call_function = request.getParameter("call_function");		
		if (call_function==null) call_function ="";
		

	String sex = request.getParameter("Sex");		
		if (sex==null) sex ="";

	
	
	String IPval = request.getParameter("IPval");		
		if (IPval==null) IPval ="";
	
	String p_service_type = request.getParameter("p_service_type");	
		if (p_service_type==null) p_service_type =""; 

	String bl_install_yn = checkForNull(request.getParameter("bl_install_yn"));	
	String oth_adt_status = "";
	String function_id    = checkForNull(request.getParameter("function_id"));

		
	String bl_interfaced_yn    = checkForNull(request.getParameter("bl_interfaced_yn"));
	String discharge_checklist_app_yn    = checkForNull(request.getParameter("discharge_checklist_app_yn"));
	String bed_block_period_dis    = checkForNull(request.getParameter("bed_block_period_dis"));
	String dis_date_chk_days    = checkForNull(request.getParameter("dis_date_chk_days"));
	String dis_date_chk_days_unit    = checkForNull(request.getParameter("dis_date_chk_days_unit"));
	String diag_update_period_max_unit    = checkForNull(request.getParameter("diag_update_period_max_unit"));
	String max_disch_period_for_predc    = checkForNull(request.getParameter("max_disch_period_for_predc"));
	String deactivate_pseudo_bed_yn    = checkForNull(request.getParameter("deactivate_pseudo_bed_yn"));
	String disch_reason_mand_yn=checkForNull(request.getParameter("disch_reason_mand_yn"));
	String allow_late_discharge_reason=checkForNull(request.getParameter("allow_late_discharge_reason"));
	
	String weight_on_admn_mandatory			= checkForNull(request.getParameter("weight_on_admn_mandatory"));//Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541] 
	String height_on_admn_mandatory			= checkForNull(request.getParameter("height_on_admn_mandatory"));//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527		
			/*
		String location_code	=	checkForNull(request.getParameter("location_code"));
			if (location_code==null) location_code ="";

		String oper_stn_id	=	checkForNull(request.getParameter("oper_stn_id"));
			if (oper_stn_id==null) oper_stn_id ="";

		String bed_no	=	checkForNull(request.getParameter("bed_no"));
			if (bed_no==null) bed_no ="";

//out.println("<script>alert(\"QueryString:"+request.getQueryString()+"\");</script>");bed_no
out.println("<script>alert(\"call_function:"+call_function+"\");</script>");
		*/



	/* START MODIFICATION BY ARUN */
		// MOD#01 Billing starts here
//out.println("<script>alert(\"call_function:"+call_function+"\");</script>");
		
		
	try
	{
		String facility_id = (String)session.getValue("facility_id");		
		
		try
		{
			if(call_function.equals("PaintDischargePatient.jsp"))
			{
				try
				{
					stmt = con.createStatement();
					rsetBL = stmt.executeQuery(" SELECT oth_adt_status from IP_OPEN_ENCOUNTER where patient_id ='"+patient_id+"' and facility_id='"+facility_id+"' and encounter_id='"+encid+"'  ");
					while(rsetBL.next())
					{
						oth_adt_status = rsetBL.getString("oth_adt_status");
						if(oth_adt_status == null) oth_adt_status = "";
	//out.println("<script>alert(\""+oth_adt_status+"\");</script>");				
					}

				
				if(!oth_adt_status.equals("7"))
				  err_mesg = "NO_ACTV_DISC_ADV_NO_DISC";
				//err_mesg = "ADMIN_ALREADY_CANCELLED";
					if(rsetBL!=null) rsetBL.close();
					if(stmt!=null) stmt.close();
				}
				catch(Exception ed)
				{
				out.println("Exception in FindPatientDischarge.jsp page"+ed.toString());
				ed.printStackTrace();
				}
			}
			
			if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
			{
				/*Tuesday, June 01, 2010 , commented for PE , query executed in InpatientLookupQueryResult.jsp at line no 166*/
				/*StringBuffer mo_deceased_check = new StringBuffer();
				if (mo_deceased_check.length() > 0)
					mo_deceased_check.delete(0,mo_deceased_check.length());
				mo_deceased_check.append("select  install_yn from  sm_module where   module_id ='MO'");
				String mo_install_yn = "N";

				try
				{
					stmt	= con.createStatement();
					rsetBL	= stmt.executeQuery(mo_deceased_check.toString());	
					if(rsetBL != null && rsetBL.next())
					{
						mo_install_yn				= rsetBL.getString("install_yn");	
					}
					if(rsetBL!=null) rsetBL.close();
					//if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					out.println("Exception in FindPatientDischarge.jsp page on fetch of data from sm_module table"+e.toString());
					e.printStackTrace();
				}*/
				/*Tuesday, June 01, 2010 commented for PE , query moved to InpatientLookupQueryResult.jsp at line no 2492 & alert message at line no 644*/
				/*
				try	{

					String chk_open_enc = "select 1 cnt from ip_open_encounter where facility_id = '"+facility_id+"' and patient_id = '"+patient_id+"'";
						
					rsetBL	= stmt.executeQuery(chk_open_enc);	
				
					if(rsetBL != null && rsetBL.next())
					{
						int no_of_open_enc = rsetBL.getInt("cnt");	
							
						if(no_of_open_enc>0)
							err_mesg = "CANNOT_CANCEL_DISCHARGE";						
					}
					if(rsetBL!=null) rsetBL.close();
					//if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					out.println("Exception in FindPatientDischarge.jsp page on fetch of data from mo_mortuary_regn table");
					e.printStackTrace();
				}
				*/
				String mo_install_yn = request.getParameter("mo_install_yn")==null?"N":request.getParameter("mo_install_yn");
				StringBuffer mo_deceased_check = new StringBuffer();
				if (mo_deceased_check.length() > 0)
					mo_deceased_check.delete(0,mo_deceased_check.length());
				if(mo_install_yn.equals("Y"))
				{
					if (mo_deceased_check.length() > 0)
						mo_deceased_check.delete(0,mo_deceased_check.length());
					mo_deceased_check.append(" select count(*) no_of_record from mo_mortuary_regn where  patient_id='"+patient_id+"' and facility_id='"+facility_id+"' and encounter_id='"+encid+"' ");

					try
					{
						stmt	= con.createStatement();
						rsetBL	= stmt.executeQuery(mo_deceased_check.toString());	
						if(rsetBL != null && rsetBL.next())
						{
							int no_of_record				= rsetBL.getInt("no_of_record");	
							
							if(no_of_record>0)
								err_mesg = "REGISTERED_IN_MORTUARY";
						}
						if(rsetBL!=null) rsetBL.close();
						if(stmt!=null) stmt.close();
					}
					catch(Exception e)
					{
						out.println("Exception in FindPatientDischarge.jsp page on fetch of data from mo_mortuary_regn table");
						e.printStackTrace();
					}
				}			

			}
			
			//10/17/2008 5089 MF-CRF-0017 IP
			
			if(call_function.equals("TransferPatient"))
			{
				//out.println("<script>alert(\"QueryString:"+request.getQueryString()+"\");</script>");
				/*
				StringBuffer user_rest_check = new StringBuffer();
				user_rest_check.append("Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = '"+facility_id+"' and locn_code = '"+location_code+"' and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+loginUser+"' and b.ASSIGN_BED_YN ='Y'");

				try
				{
					stmt	= con.createStatement();
					rsetBL	= stmt.executeQuery(user_rest_check.toString());	
					if(rsetBL != null && rsetBL.next())
					{
						rect_loc_code				= rsetBL.getString("1");	
						if(rect_loc_code == null) rect_loc_code = "";


					}
//out.println("<script>alert(\"rect_loc_code:"+rect_loc_code+"\");</script>");
					if(!rect_loc_code.equals(""))
					err_mesg = "ASSIGN_BED_USER_ACCESS";
					if(rsetBL!=null) rsetBL.close();
					if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					out.println("Exception in FindPatientDischarge.jsp page on fetch of data from sm_module table");
				}

			}*/
			}
			//10/17/2008 5089 MF-CRF-0017 IP
		if(bl_operational.equals("Y") && err_mesg.equals("") && bl_install_yn.equals("Y")) 
		{
				
			String episode_id = encid;
			if(call_function.equals("PaintDischargePatient.jsp"))
			{	
				try
				{
					stmt = con.createStatement();
					rsetBL = stmt.executeQuery(" SELECT BL_IP_DETAILS.GET_DISCHARGE_BILLING_STAGE('"+facility_id+"') disc_blg_stage FROM dual ");
					while(rsetBL!=null && rsetBL.next())
					{
						disc_blg_stage = rsetBL.getString("disc_blg_stage");
						if(disc_blg_stage == null) disc_blg_stage = "";

					}
				}catch (Exception e)
				{
					out.println("1st Exception in FindPatientDischarge.jsp : "+e);
					e.printStackTrace();
				}

				if(disc_blg_stage.equals("1"))
				{
				
					if(rsetBL != null )rsetBL.close();
					if(stmt != null )stmt.close();
					try
					{
						stmt = con.createStatement();
						rsetBL = stmt.executeQuery(" SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST('"+facility_id+"','"+episode_id+"') disc_bill_exists FROM dual ");
						while(rsetBL.next())
						{
							disc_bill_exists = rsetBL.getString("disc_bill_exists");
							if(disc_bill_exists == null) disc_bill_exists = "";
						}

					}catch (Exception e)
					{
						out.println("2nd Exception in FindPatientDischarge.jsp : "+e);
						e.printStackTrace();
					}
	
				
					if(disc_bill_exists.equals("N") && !call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					{
						err_mesg = "BL9312";
					}
				//else if(disc_bill_exists.equals("Y") && call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					//err_mesg = "DISCHARGE_BILL_RAISED";

					if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";

				}
				else if(disc_blg_stage.equals("2") && !call_function.equals("CANCEL_DISCHARGE_PATIENT"))
				{
					pstmt = con.prepareStatement( " select dis_adv_status from ip_discharge_advice where encounter_id = '"+encid+"' and  dis_adv_srl_no = (select max(dis_adv_srl_no) from ip_discharge_advice where encounter_id ='"+encid+"' and FACILITY_ID = '"+facility_id+"') " );
					if(rsetBL != null )rsetBL.close();
					rsetBL = pstmt.executeQuery();
					while(rsetBL.next())
					{
						dis_adv_status = rsetBL.getString("dis_adv_status");
						if(dis_adv_status == null) dis_adv_status = "";
					}
					if(dis_adv_status.equals("9"))
					{
					    err_mesg = "NO_ACTV_DISC_ADV_NO_DISC";
					}
			
					if (err_mesg==null || err_mesg.equals("")) 
						err_mesg = "0";
				}
            if(rsetBL != null )rsetBL.close();
			if(stmt != null )stmt.close();
			

			if(err_mesg.equals("0") || err_mesg.equals(""))
				{
             
					if(call_function.equals("PaintDischargePatient.jsp"))
					{
						function_id ="DISCHARGE_PATIENT" ;
					}
					

					String billinSql =  "{call BL_IP_DETAILS.CHECK_FIN_CLEAR_DUR_IP_TRX(?,?,?,?)}";
					CallableStatement fileCreateCS = con.prepareCall(billinSql);
					fileCreateCS.setString(1, function_id);
					fileCreateCS.setString(2, facility_id);
					fileCreateCS.setString(3, episode_id);
					fileCreateCS.registerOutParameter( 4,java.sql.Types.VARCHAR);

					try
					{
						fileCreateCS.execute();
						err_mesg = fileCreateCS.getString(4);
						
						if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";

						

					    fileCreateCS.close();

					} catch(Exception e1) {

						e1.printStackTrace();
					} 
				}
			}else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
			{
					//
					try{
					stmt = con.createStatement();
					rsetBL = stmt.executeQuery("SELECT BL_IP_DETAILS.check_cancel_discharge('"+facility_id+"','"+episode_id+"') from dual");
					while(rsetBL!=null && rsetBL.next())
					{
						disc_bill_exists = rsetBL.getString(1);
						if(disc_bill_exists == null) disc_bill_exists = "";

					}
				}catch(Exception e)
				{
					out.println("Exception in FindPatientDischarge.jsp : "+e);
					e.printStackTrace();
				}

				
				
				if(!disc_bill_exists.equals(""))
				{
				
					if(disc_bill_exists.equals("BL9314"))
					{
						err_mesg = "BL9314";
						
					}
					else if(disc_bill_exists.equals("BL9315"))
					{
						err_mesg = "BL9315";
						
					}

				if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
					//
				}

				}
				
			}
			

				if(rsetBL != null )rsetBL.close();
			if(stmt != null )stmt.close();
		if(pstmt != null )pstmt.close();
	
	}catch (Exception e)
	{
		out.println("3rd Exception in FindPatientDischarge.jsp : "+e);
		e.printStackTrace();
	}
		 // End of MOD#01
	/* END MODIFICATION BY ARUN */
	if (err_mesg==null || err_mesg.equals("null") || err_mesg =="") 
		err_mesg = "0";
	
	if(!(err_mesg.equals("0")))
	{
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script language='javascript' src='../../eCommon/js/common.js'></script>");
		
		out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
		out.println("<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>");

		out.println("</head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' class='message'></body></html>");

		if (!err_mesg.substring(0,2).equals("**") && !call_function.equals("CANCEL_DISCHARGE_PATIENT")) 
		 {
			
			if(dis_adv_status.equals("9"))
			 {
			
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block3Bytes, _wl_block3);

			 }
			  else if(!oth_adt_status.equals("7"))
			{
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block3Bytes, _wl_block3);

			}
			 else
			 {
			
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block5Bytes, _wl_block5);

			 }
		 }
		 else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
		{ 
			
			 if(!disc_bill_exists.equals("")){
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block3Bytes, _wl_block3);
}
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		 else	{	
			out.println("<script>alert('"+err_mesg+"');</script>");	
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
			
		
	}
	else
	{ 
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script language='javascript' src='../../eCommon/js/common.js'></script>");
		
		out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
		out.println("<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>");


		out.println("</head><body class='message' onKeyDown='lockKey()'></body></html>");
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block13Bytes, _wl_block13);
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(height_on_admn_mandatory));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(height_on_admn_mandatory));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(discharge_checklist_app_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bed_block_period_dis));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis_date_chk_days));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(dis_date_chk_days_unit));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(diag_update_period_max_unit));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(allow_late_discharge_reason));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disch_reason_mand_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(height_on_admn_mandatory));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block37Bytes, _wl_block37);
	}
}catch (Exception e)
{
	out.println("Final Exception in FindPatientDischarge.jsp : "+e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block38Bytes, _wl_block38);
            _bw.write(_wl_block38Bytes, _wl_block38);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
