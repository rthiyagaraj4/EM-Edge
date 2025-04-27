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

public final class __addmodifydischargeadvbuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AddModifyDischargeAdvButtons.jsp", 1742365738276L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n \t<script src=\"../js/CancelAdmission.js\" language=\"JavaScript\"></Script> \n \t<script src=\"../js/DischargeAdvice.js\" language=\"JavaScript\"></Script> \n\t<script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tvar isShift = false;\n\n\nfunction setShift()\n\t{\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 16) isShift=true;\n\t}\n\nfunction shift_tab(){\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 9 && isShift == true){\n\t\t\t\n\t\t\tparent.frames[3].document.getElementById(\'close\').focus();\n\t\n\t\t}\n\t\t\n\t}\n\n\t\n\t</script>\n<!-- \t -->\n</HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<BODY onKeyDown=\'lockKey();setShift();\'>\n\t<form name=\'Discahrge_button_form\' id=\'Discahrge_button_form\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey();\">\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' >\n\t\t<tr>\n\t\t\t <td class=\'fields\' width=\"80%\" colspan=\'2\'>\n\t\t\t\t<input type=button class=\'button\' name = \'family\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'   onClick=\'getPatientFamily()\' disabled >\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<input type=button class=\'button\' name = \'diagnosis\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onclick=\"callFunctions(\'DD\')\">\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<!--<input type=\"button\"  class= \'button\' name=\"Medical_Certificate\" id=\"Medical_Certificate\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onClick =\"OpenMedCert()\" id=\"medical_certificate\" >-->\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\n\t\t\t<!--Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1-->\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<input type=\'button\' class=\'button\' name = \'main_procedure\' id = \'main_procedure\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onclick=\"callCAMainProcedure();\">\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t</td>\n\n<!-- \t\t\t\t<select name=\'Demo\' id=\'Demo\' multiple size=\'3\'  onclick=\'FreezePage()\'>\n\t\t\t\t\t<option  selected ><A HREF=\'javascript:FreezePage()\'>Register Refferal</A></option>\n\t\t\t\t\t<option>Place Orders</option>\n\t\t\t\t\t<option>Record Diagnosis</option>\n\t\t\t\t</select>\n -->\t\t\n\t\t\t\n\t\t\t<td class=\'fields\' width=\"20%\" ><input type=button class=\'button\' name = \'record\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' align=\'right\'  onClick=\"Record(this);\" onkeydown=\"shift_tab();\"><input type=button class=\'button\' name = \'clear\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' align=\'right\'  onClick=\'resetVals();\' onkeydown=\"shift_tab();\"><input type=button class=\'button\' name = \'close\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' align=\'right\'  onClick=\'CloseWin()\' onkeydown=\"shift_tab();\">&nbsp;</td>\n\t\t </tr>\n\t </table>\n\t\t<input type=\"hidden\" name=\"mo_install_yn\" id=\"mo_install_yn\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\"hidden\" name=\"access_yn\" id=\"access_yn\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\"hidden\" name=\"invoke_death_reg_yn\" id=\"invoke_death_reg_yn\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<!--Below line added for this CRF ML-MMOH-CRF-0688-->\n\t\t<input type=\"hidden\" name=\"death_reg_mandatory_yn\" id=\"death_reg_mandatory_yn\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"> \n\t\t<input type=\"hidden\" name=\"enable_dis_diagnosis_yn\" id=\"enable_dis_diagnosis_yn\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\n\t\t<!--Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1-->\n\t\t<input type=\"hidden\" name=\"isMDSForMainProcAppl\" id=\"isMDSForMainProcAppl\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\n\t\t<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->\n\t\t<input type=\"hidden\" name=\"isDeceasedDiagClassDeathRegAppl\" id=\"isDeceasedDiagClassDeathRegAppl\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\"hidden\" name=\"primary_diag_class\" id=\"primary_diag_class\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<input type=\"hidden\" name=\"pri_mand_postmortem_ip_yn\" id=\"pri_mand_postmortem_ip_yn\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type=\"hidden\" name=\"pri_mand_postmortem_dc_yn\" id=\"pri_mand_postmortem_dc_yn\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t<input type=\"hidden\" name=\"pri_mand_non_postmortem_ip_yn\" id=\"pri_mand_non_postmortem_ip_yn\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type=\"hidden\" name=\"pri_mand_non_postmortem_dc_yn\" id=\"pri_mand_non_postmortem_dc_yn\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type=\"hidden\" name=\"secondary_diag_class\" id=\"secondary_diag_class\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\"hidden\" name=\"sec_mand_postmortem_ip_yn\" id=\"sec_mand_postmortem_ip_yn\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\"hidden\" name=\"sec_mand_postmortem_dc_yn\" id=\"sec_mand_postmortem_dc_yn\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<input type=\"hidden\" name=\"sec_mand_non_postmortem_ip_yn\" id=\"sec_mand_non_postmortem_ip_yn\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<input type=\"hidden\" name=\"sec_mand_non_postmortem_dc_yn\" id=\"sec_mand_non_postmortem_dc_yn\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\n\t </form>\n\t</BODY>\n\t<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->\n\t<!--End-->\n\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n\t<script>\n\tsetTimeout(\"DisableConfirm_Dummy()\",500);\n\tfunction DisableConfirm_Dummy(){\n\tif(parent.frames[1].document.forms[0])\n\t\t{\n\t\tif(parent.frames[1].document.forms[0].mr_mds_recorded && parent.frames[1].document.forms[0].mds_chk)\n\t\t\t{\n\t\t\tDisableConfirm();\n\t\t\t}\n\t\telse{\n\t\t\tsetTimeout(\"DisableConfirm_Dummy()\",500);\n\t\t\t}\n\t\t}\n\telse{\n\t\tsetTimeout(\"DisableConfirm_Dummy()\",500);\n\t\t}\t\t\t\n\t}\n\tfunction DisableConfirm(){\n\t\tif((parent.frames[1].document.forms[0].mr_mds_recorded.value!=\'Y\')&&(parent.frames[1].document.forms[0].mds_chk.value!=0)){\n\t\t\tdocument.getElementById(\'record\').disabled=true;\n\t\t\t\n\t\t\t//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1\n\t\t\tif(document.getElementById(\"isMDSForMainProcAppl\").value==\'true\'){\n\t\t\t\tif(parent.frames[1].document.forms[0].main_proc_rec_yn.value==\'Y\'){\n\t\t\t\t\tdocument.getElementById(\'main_procedure\').disabled=true;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\n\t\t//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1\n\t\tif(document.getElementById(\"isMDSForMainProcAppl\").value==\'true\'){\n\t\t\tif((parent.frames[1].document.forms[0].mr_mds_recorded.value==\'Y\')&&(parent.frames[1].document.forms[0].mds_chk.value!=0)){\n\t\t\t\tdocument.getElementById(\'main_procedure\').disabled=true;\n\t\t\t}\n\n\t\t\tif(parent.frames[1].document.forms[0].cnm_proceed_yn.value==\'Y\'){\n\t\t\t\tdocument.getElementById(\'record\').disabled=false;\n\t\t\t}\n\t\t}\n\n\t}\n\t</script>\n\t<!--End-->\n</HTML>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rs			= null;
	String ca_install_yn	= "N";
	String mr_install_yn	= "N";
	String mo_install_yn	= "N";
	String invoke_death_reg_yn	= "N";
	String access_yn	= "N";
	String facilityId	= (String)session.getValue("facility_id");
	String loginUser	= (String)session.getValue("login_user");
	String nursingunitcode 		= checkForNull(request.getParameter("nursingunitcode"));
	String oper_stn_id	="";
    
	//Added for this CRF ML-MMOH-CRF-0688
	String death_reg_mandatory_yn	= "N"; 
	String enable_dis_diagnosis_yn  = "N"; //ADDED BY SUJI KEERTHI ON 26-MAR-2020 FOR MOHE-CRF-0014
	
	//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
	Boolean isMDSForMainProcAppl = false;
	
	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String primary_diag_class = "";
	String pri_mand_postmortem_ip_yn = "N";
	String pri_mand_postmortem_dc_yn = "N";
	String pri_mand_non_postmortem_ip_yn = "N";
	String pri_mand_non_postmortem_dc_yn = "N";
	String secondary_diag_class = "";
	String sec_mand_postmortem_ip_yn = "N";
	String sec_mand_postmortem_dc_yn = "N";
	String sec_mand_non_postmortem_ip_yn = "N";
	String sec_mand_non_postmortem_dc_yn = "N";

	try
	{
		con = ConnectionManager.getConnection(request);

		//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
		isMDSForMainProcAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MDS_FOR_MAIN_PROCEDURE");

		isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742

		//To Enable/Disable Discharge Diagnosis Button ... 
		StringBuffer CAinstall = new StringBuffer();
		CAinstall.append("SELECT install_yn FROM sm_module WHERE module_id = 'CA'");
		stmt	= con.createStatement();
		rs		= stmt.executeQuery(CAinstall.toString());	

		if ((rs != null) && (rs.next()))
			ca_install_yn = rs.getString("install_yn");
		
		if(ca_install_yn  == null) ca_install_yn ="N";
		if(rs	 != null)   rs.close();


		rs		= stmt.executeQuery("SELECT install_yn FROM sm_module WHERE module_id = 'MR'");	
		if ((rs != null) && (rs.next()))
			mr_install_yn = rs.getString("install_yn");
		if(mr_install_yn  == null) mr_install_yn ="N";
		if(rs	 != null)   rs.close();

		rs		= stmt.executeQuery("SELECT install_yn FROM sm_module WHERE module_id = 'MO'");	
		if ((rs != null) && (rs.next()))
			mo_install_yn = rs.getString("install_yn");
		if(mo_install_yn  == null) mo_install_yn ="N";
		if(rs	 != null)   rs.close();
       
	    /*Below line added for this CRF ML-MMOH-CRF-0688*/
		//Modified by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		rs	= stmt.executeQuery(" SELECT a.allow_invoke_maintn_dth_reg_yn, a.death_register_mandatory_yn, a.enable_disch_diagnosis_yn, b.primary_diag_class, b.pri_mand_postmortem_ip_yn, b.pri_mand_postmortem_dc_yn, b.pri_mand_non_postmortem_ip_yn, b.pri_mand_non_postmortem_dc_yn, b.secondary_diag_class, b.sec_mand_postmortem_ip_yn, b.sec_mand_postmortem_dc_yn, b.sec_mand_non_postmortem_ip_yn, b.sec_mand_non_postmortem_dc_yn FROM ip_param a, mr_parameter b WHERE a.facility_id = '"+facilityId+"' ");	
		if ((rs != null) && (rs.next())) {
			invoke_death_reg_yn = rs.getString("allow_invoke_maintn_dth_reg_yn");
		    if(invoke_death_reg_yn  == null) invoke_death_reg_yn ="N";
			
			death_reg_mandatory_yn = rs.getString("death_register_mandatory_yn");
		    if(death_reg_mandatory_yn  == null) death_reg_mandatory_yn ="N";
		    
		    enable_dis_diagnosis_yn = rs.getString("enable_disch_diagnosis_yn"); //ADDED BY SUJI KEERTHI ON 26-MAR-2020 FOR MOHE-CRF-0014
		    if(enable_dis_diagnosis_yn  == null) enable_dis_diagnosis_yn ="N";

			primary_diag_class = rs.getString("primary_diag_class");
		    if(primary_diag_class == null) primary_diag_class = "";

			pri_mand_postmortem_ip_yn = rs.getString("pri_mand_postmortem_ip_yn");
		    if(pri_mand_postmortem_ip_yn == null) pri_mand_postmortem_ip_yn = "N";

			pri_mand_postmortem_dc_yn = rs.getString("pri_mand_postmortem_dc_yn");
		    if(pri_mand_postmortem_dc_yn == null) pri_mand_postmortem_dc_yn = "N";

			pri_mand_non_postmortem_ip_yn = rs.getString("pri_mand_non_postmortem_ip_yn");
		    if(pri_mand_non_postmortem_ip_yn == null) pri_mand_non_postmortem_ip_yn = "N";

			pri_mand_non_postmortem_dc_yn = rs.getString("pri_mand_non_postmortem_dc_yn");
		    if(pri_mand_non_postmortem_dc_yn == null) pri_mand_non_postmortem_dc_yn = "N";

			secondary_diag_class = rs.getString("secondary_diag_class");
		    if(secondary_diag_class == null) secondary_diag_class = "";

			sec_mand_postmortem_ip_yn = rs.getString("sec_mand_postmortem_ip_yn");
		    if(sec_mand_postmortem_ip_yn == null) sec_mand_postmortem_ip_yn = "N";

			sec_mand_postmortem_dc_yn = rs.getString("sec_mand_postmortem_dc_yn");
		    if(sec_mand_postmortem_dc_yn == null) sec_mand_postmortem_dc_yn = "N";

			sec_mand_non_postmortem_ip_yn = rs.getString("sec_mand_non_postmortem_ip_yn");
		    if(sec_mand_non_postmortem_ip_yn == null) sec_mand_non_postmortem_ip_yn = "N";

			sec_mand_non_postmortem_dc_yn = rs.getString("sec_mand_non_postmortem_dc_yn");
		    if(sec_mand_non_postmortem_dc_yn == null) sec_mand_non_postmortem_dc_yn = "N";
		}		
		//End this CRF ML-MMOH-CRF-0688
		
		if(rs	 != null)   rs.close();		

		rs		= stmt.executeQuery("select a.oper_stn_id oper_stn_id from AM_OPER_STN a, AM_USER_FOR_OPER_STN b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id	and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"' and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ");	
		 if ((rs != null) && (rs.next()))
			{
				oper_stn_id	 = checkForNull(rs.getString("oper_stn_id"));
			}
		if(oper_stn_id  == null) oper_stn_id ="";
		if(rs	 != null)   rs.close();		
			
			rs		= stmt.executeQuery("SELECT maintain_death_register_yn FROM am_os_user_locn_access_vw b WHERE b.facility_id =  '"+facilityId+"' AND locn_code = '"+nursingunitcode+"'  AND b.oper_stn_id = '"+oper_stn_id+"'  AND b.appl_user_id = '"+loginUser+"' ");	
		 if ((rs != null) && (rs.next()))
			{
				access_yn	 = checkForNull(rs.getString("maintain_death_register_yn"));
			}
		if(access_yn  == null) access_yn ="";
		if(rs	 != null)   rs.close();	
		
		if(stmt	 != null)   stmt.close();

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientDetails.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
	if (ca_install_yn.equals("Y") && enable_dis_diagnosis_yn.equals("Y"))
				{	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeDiagnosis.label","ip_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}	
            _bw.write(_wl_block12Bytes, _wl_block12);
	if (mr_install_yn.equals("Y"))
				{	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.certificate.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
	}	
            _bw.write(_wl_block15Bytes, _wl_block15);
if(isMDSForMainProcAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.main.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(mo_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(access_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(invoke_death_reg_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(death_reg_mandatory_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(enable_dis_diagnosis_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isMDSForMainProcAppl));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(isDeceasedDiagClassDeathRegAppl));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(primary_diag_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(pri_mand_postmortem_ip_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pri_mand_postmortem_dc_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(pri_mand_non_postmortem_ip_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pri_mand_non_postmortem_dc_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(secondary_diag_class));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sec_mand_postmortem_ip_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_mand_postmortem_dc_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sec_mand_non_postmortem_ip_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sec_mand_non_postmortem_dc_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);

	}catch(Exception e)
	{
		out.println("Exception : "+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block40Bytes, _wl_block40);
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
