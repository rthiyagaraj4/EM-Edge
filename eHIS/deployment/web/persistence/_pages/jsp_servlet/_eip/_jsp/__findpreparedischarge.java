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
import blipin.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __findpreparedischarge extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/FindPrepareDischarge.jsp", 1733485924640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\t//alert(getMessage(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'BL\'));\t\t\t\t\n\t\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n\n\t\t\tfindprepdischonload();\n\t\t\t\n\t\t\tasync function findprepdischonload(){\n\t\t\tvar frames_list = parent.frames[2].document.forms[0];\n\t\t\tif( frames_list.modal.value != \'yes\')\n\t\t    {   \n\t\t\t\tvar jsp_name1=frames_list.jsp_name.value;\n\t\t\t\tvar patient_id\t= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\tvar encid\t\t= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\tvar practitioner_id = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\tvar leave_exp_dt_flag = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\tvar call_function = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\tvar sex = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\tvar IPval = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\tvar p_service_type = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\tvar function_id = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t/*Added On 5/5/2010 for PE passing the values from Result page to PDA pages*/\n\t\t\t\tvar setup_bl_dtls_in_ip_yn = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\tvar bl_interfaced_yn = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\tvar allow_discharge_date_predc  = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\tvar max_disch_period_for_predc = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\tvar mother_cut_off_age_pda\t\t= \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\tvar mother_max_age_pda\t\t\t= \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\tvar pat_dtls_unknown_yn_pda\t= \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\tvar contact1_name_pda\t\t\t\t= \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\tvar contact2_name_pda\t\t\t\t= \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t/**/\n\t\t\t\tvar win_height=frames_list.win_height.value;\n\t\t\t\tif(win_height == \"\") win_height=\"27\";\n\t\t\t\tvar dialogTop=frames_list.dialogTop.value;\n\t\t\t\tif(dialogTop == \"\") dialogTop=\"80\";\n\t\t\t\tvar win_width=frames_list.win_width.value;\n\t\t\t\tif(win_width == \"\") win_width=\"40\";\n\t\t\t\tvar module1=frames_list.module.value;\n\t\t\t\tif(module1 == \"\") module1=\"eIP\";\n\t\t\t\tvar model_window=frames_list.model_window.value;\n\t\t\t\tif( model_window == \"\") model_window =\"\";\n\t\t\t\tif( model_window == \'NO\')\n\t\t\t\t{\n\t\t\t\t\t//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527\n\t\t\t\t\tparent.parent.frames[1].document.location.href=\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?encounterId=\"+encid+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_d+\"&leave_exp_dt_flag=\"+leave_exp_dt_flag+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex+\"&function_id=\"+function_id+\"&weight_on_admn_mandatory=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&height_on_admn_mandatory=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&enable_height_bmi_pat_cls=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\tif( model_window == \'N\')\n\t\t\t\t{\n\t\t\t\t\t//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527\n\t\t\t\t\tparent.frames[3].document.location.href=\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?encounterId=\"+encid+\"&leave_exp_dt_flag=\"+leave_exp_dt_flag+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_id+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex+\"&function_id=\"+function_id+\"&weight_on_admn_mandatory=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\tvar dialogHeight= \"90vh\";\n\t\t\t\t\tvar dialogWidth = \"90vw\";\n\t\t\t\t\tvar dialogTop\t= \"2\";\n\t\t\t\t\tvar center = \"1\" ;\n\t\t\t\t\tvar status=\"no\";\n\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\tretVal = await top.window.showModalDialog(\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?location_code=\"+IPval+\"&encounterId=\"+encid+\"&leave_exp_dt_flag=\"+leave_exp_dt_flag+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_id+\"&callfrom=IP&call_function=\"+call_function+\"&p_service_type=\"+p_service_type.value+\"&Sex=\"+sex+\"&mode=modal&function_id=\"+function_id+\"&setup_bl_dtls_in_ip_yn=\"+setup_bl_dtls_in_ip_yn+\"&bl_interfaced_yn=\"+bl_interfaced_yn+\"&allow_discharge_date_predc=\"+allow_discharge_date_predc+\"&max_disch_period_for_predc=\"+max_disch_period_for_predc+\"&mother_cut_off_age_pda=\"+mother_cut_off_age_pda+\"&mother_max_age_pda=\"+mother_max_age_pda+\"&pat_dtls_unknown_yn_pda=\"+pat_dtls_unknown_yn_pda+\"&contact1_name_pda=\"+encodeURIComponent(contact1_name_pda)+\"&contact2_name_pda=\"+encodeURIComponent(contact2_name_pda)+\"&weight_on_admn_mandatory=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",arguments,features);//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527\n\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\twindow.parent.returnValue=enc;\n\t\t\t\twindow.parent.close();\n\t\t\t}\n\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con =null;
	ResultSet rs =null;
	Boolean bill_result=true;
	String bl_operational =	(String)session.getValue("bl_operational");
	String err_mesg = "";
	String mode = request.getParameter("mode");
	if (mode==null) mode = "";
	String facility_id	= (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_Id");
	if (patient_id==null) patient_id = "";
	String encid		= request.getParameter("encounter_Id");
	 if (encid==null) encid = "";
	String leave_exp_dt_flag = request.getParameter("leave_exp_dt_flag");
	if(leave_exp_dt_flag==null) leave_exp_dt_flag = "";
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
	
	String p_patient_class = request.getParameter("patient_class");
	if (p_patient_class==null) p_patient_class ="";
	String function_id = request.getParameter("function_id");
	if (function_id==null) function_id ="";
	String bl_interfaced_yn						 = checkForNull(request.getParameter("bl_interfaced_yn"));
	String allow_discharge_date_predc	 = checkForNull(request.getParameter("allow_discharge_date_predc"));
	String max_disch_period_for_predc	 = checkForNull(request.getParameter("max_disch_period_for_predc"));
	String setup_bl_dtls_in_ip_yn			 = checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"));
	String mother_cut_off_age_pda		 = checkForNull(request.getParameter("mother_cut_off_age_pda"));
	String mother_max_age_pda				 = checkForNull(request.getParameter("mother_max_age_pda"));
	String pat_dtls_unknown_yn_pda		 = checkForNull(request.getParameter("pat_dtls_unknown_yn_pda"));
	String contact1_name_pda				 = checkForNull(request.getParameter("contact1_name_pda"));
	String contact2_name_pda				 = checkForNull(request.getParameter("contact2_name_pda"));
	String weight_on_admn_mandatory			= checkForNull(request.getParameter("weight_on_admn_mandatory"));//Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541] 
	String height_on_admn_mandatory			= checkForNull(request.getParameter("height_on_admn_mandatory"));//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
		CallableStatement cstmt = null;
	try
	{
		con = ConnectionManager.getConnection(request);	
		try 
		{
	 		
			if ( bl_operational.equals("Y")) 
	 		{
	 			HttpSession httpSession = request.getSession(false);
	 			Properties p = (Properties)httpSession.getValue("jdbc");	
	 			String episode_id = encid;
				String episode_type ="";
				if(p_patient_class.equals("IP"))
	 				episode_type = "I";
				else if(p_patient_class.equals("DC"))
					episode_type = "D";
	 			Hashtable hashtableBL = new Hashtable();
	 			hashtableBL.put("patient_id",patient_id);
	 			hashtableBL.put("encid",encid);
	 			hashtableBL.put("call_function",call_function);
	 			hashtableBL.put("episode_type",episode_type);
	 			hashtableBL.put("episode_id",episode_id);
	 			hashtableBL.put("facility_id",facility_id);
	 			BLPrepareDischargeAdvice blPrepareDischargeAdvice = new BLPrepareDischargeAdvice();
	 			Hashtable resultsBL = blPrepareDischargeAdvice.billPatientService(p,con,hashtableBL);
				bill_result = ((Boolean) resultsBL.get("status")).booleanValue();
				if(!bill_result)
	 				err_mesg	 = (String) resultsBL.get("error");	
				if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
	 		}
	 	}
	 	catch (Exception e)
	 	{
	 		out.println("Exception "+e);
	       
	 	}
		// End of MOD#01
		/* END MODIFICATION BY ARUN */
		if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
		if(!(err_mesg.equals("0")))
		{
			out.println("<html><head>");
			out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
			
			out.println("</head><body class='message' onKeyDown='lockKey()'></body></html>");
			if (!err_mesg.substring(0,2).equals("**")) 
			{
				
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			else		
				out.println("<script>alert('"+err_mesg+"');</script>");
		}
		else
		{
			out.println("<html><head>");
			out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
			
			out.println("</head><body class='message' onKeyDown='lockKey()'></body></html>");
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encid));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(leave_exp_dt_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(allow_discharge_date_predc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(mother_cut_off_age_pda));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(mother_max_age_pda));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pat_dtls_unknown_yn_pda));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(contact1_name_pda));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(contact2_name_pda));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(height_on_admn_mandatory));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(height_on_admn_mandatory));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(height_on_admn_mandatory));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block33Bytes, _wl_block33);

		}
	}//E.o.Try
	catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	finally
	{
		if(rs!=null)	rs.close();
		if(cstmt!=null) cstmt.close();
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
}
