package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __newbornregistrationdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/NewbornRegistrationDetails.jsp", 1742472345717L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\n<head>\n\t<link type=\"text/css\" rel=\"stylesheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\n</head>\n\n<body onKeyDown = \'lockKey()\'>\n<form name=\"newborndtls_form\" id=\"newborndtls_form\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<script language=\"JavaScript\">\n\n\t\tfunction changeToolBar(calling_module_id) {\n\t\t\tvar accessRights = parent.newbornmain_frame.document.getElementById(\'accessRights\').value;\n\t\t\tif(calling_module_id == \'IP\' || calling_module_id == \'AE\')\n\t\t\t\thome_required_yn = \'N\';\n\t\t\telse \n\t\t\t\thome_required_yn = \'Y\';\n\t\t\tparent.parent.commontoolbarFrame.location.href = \'../../eCommon/jsp/commonToolbar.jsp?module_id=MP&function_id=NEWBORN_REG&function_name=Register New Born&function_type=F&access=\'+accessRights+\'&home_required_yn=\'+home_required_yn;\n\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/error.jsp\';\n\t\t}\n\n\t\tasync function callAdmitPatient(patientId,calling_module_id)\n\t\t{\n\t\t\tvar dialogHeight = \'90vh\';\n\t\t\tvar dialogWidth = \'90vw\';\n\t\t\tvar wintop = \'65\';\n\t\t\tvar retVal = \"\";\n\t\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +  \'; dialogTop: \' + wintop +\';status=no\';\n\t\t\tvar arguments = \'\';\t\t\t\n\t\t\tvar param = \"../../eIP/jsp/AdmitPatient.jsp?module_id=IP&function_id=NEWBORN_REG&access=NYNNN&patient_id=\"+patientId+\"&&home_required_yn=N\";\n\n\t\t\tretVal = await top.window.showModalDialog(param,arguments,features);\n\t\t\tparent.newborndtls_frame.location.href = self.location.href; \t\t\t\n\t\t\t\n\t\t\tif(retVal == undefined || retVal == true) {\n\t\t\t\tchangeToolBar(calling_module_id);\n\t\t\t} \t\n\t\t\t\n\t\t}\n\n\t\tasync function callRegisterAttendance(patientId,calling_module_id){\n\t\t\tvar dialogHeight = \'45\';\n\t\t\tvar dialogWidth = \'64\';\n\t\t\tvar wintop = \'65\';\n\t\t\tvar retVal = \"\";\n\t\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +  \'; dialogTop: \' + wintop +\';status=no\';\n\t\t\tvar arguments = \'\';\t\t\t\n\t\t\tvar param = \"../../eAE/jsp/AERegisterAttn.jsp?patient_id=\"+patientId+\"&menu_id=AE&module_id=AE&function_id=AE_REGISTER_ATTN&function_type=F&access=NYNNN&desktopFlag=N&invoke_from=EMER_REGN_NB&function_name=Register Attendance\";\n\n\t\t\tretVal = await window.showModalDialog(param,arguments,features);\n\t\t\tparent.newborndtls_frame.location.href = self.location.href; \t\t\t\n\t\t\t\n\t\t\tif(retVal == undefined || retVal == true) {\n\t\t\t\tchangeToolBar(calling_module_id);\n\t\t\t} \t\n\t\t}\n\n\t\tfunction callOnlineReports(patientID,pat_ser_grp_code,encounter_id,mother_nursing_unit,function_id_new,outcome){\n\t\t\tif(patientID!=null) \n\t\t\t{\n\t\t\t\t\t var HTMLVal=\"<html><body onKeyDown=\'lockKey()\'><form name=\'tempform1\' method=\'post\' action=\'../../eMP/jsp/GetRelationship.jsp\'><input type=\'hidden\' name=\'callfunction\' value=\'callOnlineReports\'><input type=\'hidden\' name=\'patient_id1\' value=\"+patientID+\"><input type=\'hidden\' name=\'pat_ser_grp_code\' value = \'\"+pat_ser_grp_code+\"\'><input type=\'hidden\' name=\'encounter_id\' value=\"+encounter_id+\"><input type=\'hidden\' name=\'mother_nursing_unit\' value=\"+mother_nursing_unit+\"><input type=\'hidden\' name=\'function_id\' value=\"+function_id_new+\"><input type=\'hidden\' name=\'outcome\' value=\"+outcome+\"></form></body></html>\";\n\t\t\t\t\t parent.parent.frames[2].document.write(HTMLVal);\n\t\t\t\t\t parent.parent.frames[2].document.tempform1.submit();\t\t\t\t \n\t\t\t}\t\t\n\t\t}\n\n\t\tasync function callChangePatDtls(patientId,calling_module_id)\n\t\t{\n\t\t\tvar dialogHeight = \'90vh\';\n\t\t\tvar dialogWidth = \'80vw\';\n\t\t\tvar wintop = \'\';\n\n\t\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +  \'; dialogTop: \' + wintop +\';status=no\';\n\t\t\tvar arguments = \'\';\n\t\t\tvar retVal = \'\';\n\t\t\t\n\t\t\tvar param = \"../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=Y&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID=\"+patientId;\n\t\t\tvar retVal = await top.window.showModalDialog(param,arguments,features);\n\n\t\t\tparent.newborndtls_frame.location.href = self.location.href;\n\t\t\t\n\t\t\tif(retVal == undefined || retVal == true) {\n\t\t\t\tchangeToolBar(calling_module_id);\n\t\t\t} \t\t\t\n\t\t}\n\t\t\n        //Below function parameter modified for this CRF  HSA-CRF-0182 linked incident [54168]\n\t\tfunction viewPatDtls(patientID,function_id,function_id_new,encounter_id,nursing_unit,inhouse_birth_yn,nb_use_mother_ser,accessRights,parent_details,function_invoked,module_invoked,mother_nursing_unit,mother_bed_no,function_name,disable_button_yn,invoke_adm_from_newborn_yn,outcome,calling_module_id,finalized_yn,pat_ser_grp_code,pat_ser_grp_desc,newTransactionYN,called_from_mothercare,siteId,mother_pat_id,resuscitated_pract_id,born_where,isNewBornChngsAppl)\n\t\t{   \n\t\t\tvar nbMainJsp\t\t= \"NewbornRegistrationMain.jsp\";\n\t\t\tif(calling_module_id==\"IP\" && isNewBornChngsAppl==\"true\"){\n\t\t\t\tnbMainJsp\t\t= \"NewbornRegistrationMainSLY.jsp\";\n\t\t\t}\n\t\t\tif(finalized_yn == \'Y\'){\n\t\t\t\tvar ip_install_yn =parent.newbornmain_frame.document.forms[0].ip_install_yn.value;\n\t\t\t\tparent.newbornheader_frame.location.href=\"../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id=\"+patientID+\"&function_id_new=MAINTAIN_BIRTH&invoked_from=details_page&calling_module_id=\"+calling_module_id+\"&chd_id=\"+patientID+\"&pat_ser_grp_code=\"+pat_ser_grp_code+\"&pat_ser_grp_desc=\"+pat_ser_grp_desc+\"&buttonType=R&disable_button_yn=Y\"; \n\t\t\t\tparent.newbornmain_frame.location.href=\"../../eMP/jsp/\"+nbMainJsp+\"?mother_id=\"+patientID+\"&function_id=\"+function_id+\"&function_id_new=\"+function_id_new+\"&encounter_id=\"+encounter_id+\"&nursing_unit=\"+nursing_unit+\"&inhouse_birth_yn=\"+inhouse_birth_yn+\"&nb_use_mother_ser=\"+nb_use_mother_ser+\"&accessRights=\"+accessRights+\"&parent_details=\"+parent_details+\"&function_invoked=\"+function_invoked+\"&module_invoked=\"+module_invoked+\"&mother_nursing_unit=\"+mother_nursing_unit+\"&mother_bed_no=\"+mother_bed_no+\"&function_name=\"+function_name+\"&invoke_adm_from_newborn_yn=\"+invoke_adm_from_newborn_yn+\"&disable_button_yn=\"+disable_button_yn+\"&invoked_from=details_page&calling_module_id=\"+calling_module_id+\"&newTransactionYN=\"+newTransactionYN+\"&regnStatus=F&finalizeYN=Y&siteId=\"+siteId+\"&ip_install_yn=\"+ip_install_yn+\"&mother_pat_id=\"+mother_pat_id+\"&finalized_mult_birth_yn=\"+finalized_yn+\"&disable_finalized_button_yn=Y&resuscitated_pract_id=\"+resuscitated_pract_id+\"&born_where=\"+born_where+\"&outcome=\"+outcome+\"&newbornReg=Y&isNewBornChngsAppl=\"+isNewBornChngsAppl+\"\";  //Added for this CRF ML-MMOH-CRF-0621\n\n\t\t\t} else if(finalized_yn == \'N\'){\n\n\t\t\t\t\n\t\t\t\tif(confirm(\"Do you want to Finalize\")) {\n\t\t\t\t\tvar ip_install_yn =parent.newbornmain_frame.document.forms[0].ip_install_yn.value;\n\t\t\t\t\tparent.newbornheader_frame.location.href=\"../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id=\"+patientID+\"&function_id_new=MAINTAIN_BIRTH&invoked_from=details_page&calling_module_id=\"+calling_module_id+\"&chd_id=\"+patientID+\"&pat_ser_grp_code=\"+pat_ser_grp_code+\"&pat_ser_grp_desc=\"+pat_ser_grp_desc+\"&buttonType=F&disable_button_yn=N\"; \n\t\t\t\t\tvar url=\"../../eMP/jsp/\"+nbMainJsp+\"?mother_id=\"+patientID+\"&function_id=\"+function_id+\"&function_id_new=\"+function_id_new+\"&encounter_id=\"+encounter_id+\"&nursing_unit=\"+nursing_unit+\"&inhouse_birth_yn=\"+inhouse_birth_yn+\"&nb_use_mother_ser=\"+nb_use_mother_ser+\"&accessRights=\"+accessRights+\"&parent_details=\"+parent_details+\"&function_invoked=\"+function_invoked+\"&module_invoked=\"+module_invoked+\"&mother_nursing_unit=\"+mother_nursing_unit+\"&mother_bed_no=\"+mother_bed_no+\"&function_name=\"+function_name+\"&invoke_adm_from_newborn_yn=\"+invoke_adm_from_newborn_yn+\"&disable_button_yn=\"+disable_button_yn+\"&invoked_from=details_page&outcome=\"+outcome+\"&calling_module_id=\"+calling_module_id+\"&newTransactionYN=\"+newTransactionYN+\"&regnStatus=R&finalizeYN=Y&called_from_mothercare=\"+called_from_mothercare+\"&siteId=\"+siteId+\"&ip_install_yn=\"+ip_install_yn+\"&mother_pat_id=\"+mother_pat_id+\"&finalized_mult_birth_yn=\"+finalized_yn+\"&disable_finalized_button_yn=N&resuscitated_pract_id=\"+resuscitated_pract_id+\"&born_where=\"+born_where+\"&newbornReg=Y&isNewBornChngsAppl=\"+isNewBornChngsAppl+\"\";  //Added for this CRF ML-MMOH-CRF-0621\n\t\t\t\t\tparent.newbornmain_frame.location.href=url;\n\t\t\t\t}else{\n\t\t\t\t\tcallOnlineReports(patientID,pat_ser_grp_code,encounter_id,mother_nursing_unit,function_id_new,outcome);\n\t\t\t\t}\n\t\t\t}\n\t\t\t//var accessRights=frm.accessRights.value;\n\t\t}\n\t</script>\n\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\n\t\t\t<table border=1 cellpadding=0 cellspacing=0 width=\'100%\'>\n\t\t\t\t<tr>\t\t\t\n\t\t\t\t\t\n\t\t<td class=\"COLUMNHEADER\" align=\'center\'><B>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</B></td>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\'center\'><B>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\n\t\t<td class=\"COLUMNHEADER\" align=\'center\'><B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B></td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\'center\'><B>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<input type=\'hidden\' name=\'motherid\' id=\'motherid\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'></B>\n\t\t\t\t\t</td>\t\t\t\t\n\t\t\t        <td class=\"COLUMNHEADER\" align=\'center\'><B>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</B>\n\t\t\t\t\t<input type=\'hidden\' name=\'newbornpatsergrp\' id=\'newbornpatsergrp\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'nb_use_mother_ser\' id=\'nb_use_mother_ser\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'exceedMaxBirthYN\' id=\'exceedMaxBirthYN\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\'center\'><B>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</B></td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<td ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ><a href=\"javascript:viewPatDtls(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    String locale =((String)session.getAttribute("LOCALE"));

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection con = null;		

		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String motherid = request.getParameter("mother_id")==null?"": request.getParameter("mother_id");
		String function_id = request.getParameter("function_id")==null?"": request.getParameter("function_id");
		String function_id_new = request.getParameter("function_id_new")==null?"": request.getParameter("function_id_new");
		String encounter_id = request.getParameter("encounter_id")==null?" ": request.getParameter("encounter_id");
		String nursing_unit = request.getParameter("nursing_unit")==null?"": request.getParameter("nursing_unit");
		String siteId = request.getParameter("siteId")==null?"":request.getParameter("siteId");

		/*
		String unit_of_wt_nb = request.getParameter("unit_of_wt_nb")==null?"": request.getParameter("unit_of_wt_nb");
		String unit_of_circum_nb = request.getParameter("unit_of_circum_nb")==null?"": request.getParameter("unit_of_circum_nb");
		String unitofchestunit = request.getParameter("unitofchestunit")==null?"": request.getParameter("unitofchestunit");
		String unit_of_length_nb = request.getParameter("unit_of_length_nb")==null?"": request.getParameter("unit_of_length_nb");
		String unit_of_gest_nb = request.getParameter("unit_of_gest_nb")==null?"": request.getParameter("unit_of_gest_nb");
		String patient_id_length = request.getParameter("patient_id_length")==null?"": request.getParameter("patient_id_length");
		String name_suffix_male_nb = request.getParameter("name_suffix_male_nb")==null?"": request.getParameter("name_suffix_male_nb");
		String name_suffix_female_nb = request.getParameter("name_suffix_female_nb")==null?"": request.getParameter("name_suffix_female_nb");
		*/

		String inhouse_birth_yn = request.getParameter("inhouse_birth_yn")==null?"": request.getParameter("inhouse_birth_yn"); 
		String new_born_pat_ser_grp = request.getParameter("new_born_pat_ser_grp")==null?"": request.getParameter("new_born_pat_ser_grp");
		String nb_use_mother_ser = request.getParameter("nb_use_mother_ser")==null?"": request.getParameter("nb_use_mother_ser");

		//String allow_nb_regn_within_days = request.getParameter("allow_nb_regn_within_days")==null?"": request.getParameter("allow_nb_regn_within_days");

		String accessRights = request.getParameter("accessRights")==null?"": request.getParameter("accessRights");
		String parent_details = request.getParameter("parent_details")==null?"": request.getParameter("parent_details");
		parent_details = java.net.URLEncoder.encode(parent_details);

		//String alt_id_type_desc = request.getParameter("alt_id_type_desc")==null?"": request.getParameter("alt_id_type_desc");

		String function_invoked = request.getParameter("function_invoked")==null?"": request.getParameter("function_invoked");
		String called_from_mothercare = request.getParameter("called_from_mothercare")==null?"": request.getParameter("called_from_mothercare");
		String module_invoked = request.getParameter("module_invoked")==null?"": request.getParameter("module_invoked");
		String mother_nursing_unit = request.getParameter("mother_nursing_unit")==null?"": request.getParameter("mother_nursing_unit");
		String mother_bed_no = request.getParameter("mother_bed_no")==null?"": request.getParameter("mother_bed_no");
		String function_name = request.getParameter("function_name")==null?"": request.getParameter("function_name");		
		String disable_button_yn = request.getParameter("disable_button_yn")==null?"": request.getParameter("disable_button_yn");
        String invoke_adm_from_newborn_yn =                                    request.getParameter("invoke_adm_from_newborn_yn")==null?"": request.getParameter("invoke_adm_from_newborn_yn");
        String calling_module_id =                                    request.getParameter("calling_module_id")==null?"": request.getParameter("calling_module_id");	
        String exceedMaxBirthYN =                                    request.getParameter("exceedMaxBirthYN")==null?"N": request.getParameter("exceedMaxBirthYN");		
        String newTransactionYN =                                    request.getParameter("newTransactionYN")==null?"Y": request.getParameter("newTransactionYN");		
		String isNewBornChngsAppl = request.getParameter("isNewBornChngsAppl")==null?"false": request.getParameter("isNewBornChngsAppl");		
		
		String birth_date="";
	    String birth_date_time="";
	    String birth_time="";
	    String speciality="";	  
	    String baby_bed_no="";	  
		String patientid ="";
		String outcome ="";
		String finalized_yn ="";
		String pat_ser_grp_code ="";
		String pat_ser_grp_desc ="";
		String regnStatusStyle  ="";
		
		String born_where=""; //Added for this CRF ML-MMOH-CRF-0621
		
		String mother_pat_id="";//Added for this HSA-CRF-0182 linked incident [54168]
		
	    String resuscitated_pract_id="", resuscitated_pract_desc=""; //Added for this CRF ML-MMOH-CRF-0621
		
	
	
            _bw.write(_wl_block8Bytes, _wl_block8);

	try{
		con = ConnectionManager.getConnection(request);				
		if (rset != null) rset.close();
        //Below line modified for this CRF  HSA-CRF-0182 linked incident [54168]
		String sql = "SELECT /*+index(b mp_patient_pk)*/ TO_CHAR(a.TIME_OF_BIRTH,'dd/mm/yyyy'),  TO_CHAR(a.TIME_OF_BIRTH,'hh24:mi'), a.OUTCOME, a.NB_SEX, DECODE('"+locale+"', 'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name)) patient_name, a.PATIENT_ID, a.WEIGHT, a.WEIGHT_UNIT,  AM_GET_DESC.AM_PRACTITIONER(a.attend_physician_id,'"+locale+"','1') practitioner_name, DECODE(c.BED_NO,NULL, d.bed_num,c.bed_no) bed_no, ip_get_desc.ip_nursing_unit(DECODE(c.facility_id,NULL,d.facility_id,c.facility_id),DECODE(c.nursing_unit_code,NULL,d.nursing_unit_code,c.nursing_unit_code),'"+locale+"','1') nursing_unit_desc , Am_Get_desc.Am_speciality(DECODE(c.specialty_code,NULL,d.specialty_code,c.specialty_code),'"+locale+"','1') speciality, a.finalized_yn, b.pat_ser_grp_code pat_ser_grp_code, mp_get_desc.mp_pat_ser_grp(b.pat_ser_grp_code,'"+locale+"',2) pat_ser_grp_desc,a.mother_patient_id mother_patient_id, a.resuscitated_pract_id, am_get_desc.am_practitioner(a.resuscitated_pract_id,'"+locale+"',1) resuscitated_pract_desc, a.bba_yn FROM mp_birth_register a, mp_patient b, ip_nursing_unit_bed c, ip_open_encounter d WHERE a.MOTHER_PATIENT_ID='"+motherid+"' AND a.patient_id = b.patient_id AND c.OCCUPYING_PATIENT_ID(+)=a.patient_id AND d.patient_id(+) = a.patient_id order by a.birth_order, a.time_of_birth";


	
		pstmt = con.prepareStatement(sql.toString());
		rset = pstmt.executeQuery();
		int i=0;
		//String classValue = "";		
		String birth_weight = "";
         
		if(rset!=null && rset.next())
		{	
				
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
  if((calling_module_id.equals("IP") & invoke_adm_from_newborn_yn.equals("Y")) || calling_module_id.equals("AE"))
			         {
					    
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
  }  
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(new_born_pat_ser_grp));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(exceedMaxBirthYN));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			do
			{
				i++;

				/*
				if(i%2 == 0) 
					classValue="QRYEVEN";
				else
					classValue = "QRYODD";
				*/

				patientid = rset.getString("PATIENT_ID");
				nursing_unit = rset.getString("nursing_unit_desc")==null?"":rset.getString("nursing_unit_desc");
				speciality = rset.getString("speciality")==null?"":rset.getString("speciality");
				finalized_yn = rset.getString("finalized_yn")==null?"N":rset.getString("finalized_yn");
				pat_ser_grp_code = rset.getString("pat_ser_grp_code")==null?"":rset.getString("pat_ser_grp_code");
				pat_ser_grp_desc = rset.getString("pat_ser_grp_desc")==null?"":rset.getString("pat_ser_grp_desc");
				outcome = rset.getString("OUTCOME")==null?"":rset.getString("OUTCOME");
				//Below line Added for this CRF  HSA-CRF-0182 linked incident [54168]
				mother_pat_id=rset.getString("mother_patient_id")==null?"":rset.getString("mother_patient_id");
				
				/*Below line added for this CRF ML-MMOH-CRF-0621*/
				resuscitated_pract_id=rset.getString("resuscitated_pract_id")==null?"":rset.getString("resuscitated_pract_id");
				resuscitated_pract_desc=rset.getString("resuscitated_pract_desc")==null?"":rset.getString("resuscitated_pract_desc"); 
				born_where=rset.getString("bba_yn")==null?"":rset.getString("bba_yn"); 
				//End ML-MMOH-CRF-0621
				
				if(finalized_yn.equals("Y")) {
					//out.println("<tr style='background-color:#00FFFF'>");
					regnStatusStyle = "style='background-color:#00FFFF'";
				} else if(finalized_yn.equals("N")) {					
					//out.println("<tr style='background-color:#FECBFA'>");
					regnStatusStyle = "style='background-color:#FECBFA'";
				} 								
				//Below line modified for this CRF  HSA-CRF-0182 linked incident [54168]
				/*Below line added for this CRF ML-MMOH-CRF-0621*/
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(regnStatusStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(function_id_new));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(inhouse_birth_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(module_invoked));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_button_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(invoke_adm_from_newborn_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(outcome));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(finalized_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pat_ser_grp_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pat_ser_grp_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(newTransactionYN));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(called_from_mothercare));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(siteId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(mother_pat_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(resuscitated_pract_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(born_where));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block26Bytes, _wl_block26);


				if(calling_module_id.equals("IP") & invoke_adm_from_newborn_yn.equals("Y")) {
					out.println("<td "+regnStatusStyle+" ><a href=\"javascript:callAdmitPatient('"+patientid+"','"+calling_module_id+"')\"> "+   com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admit.label","common_labels")+"</a></td>");
				} else if(calling_module_id.equals("AE")) {
					out.println("<td "+regnStatusStyle+" ><a href=\"javascript:callRegisterAttendance('"+patientid+"','"+calling_module_id+"')\"> "+   com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterAttendance.label","common_labels")+"</a></td>");
				}

				if(finalized_yn.equals("Y")) {
					out.println("<td "+regnStatusStyle+" >"+rset.getString(5)+"</td>");
				} else {
					out.println("<td "+regnStatusStyle+" ><a href=\"javascript:callChangePatDtls('"+patientid+"','"+calling_module_id+"')\">"+rset.getString(5)+"</a></td>");
				}
				
				baby_bed_no = rset.getString("bed_no")==null?"":rset.getString("bed_no");						
				birth_date=rset.getString(1)==null?"":rset.getString(1);
				birth_time=rset.getString(2)==null?"":rset.getString(2);			birth_date=DateUtils.convertDate(birth_date,"DMY","en",localeName);
				birth_date_time=birth_date+" "+birth_time;
				if(birth_date_time.equals(" "))
					birth_date_time = "&nbsp;";
					
				out.println("<td "+regnStatusStyle+" >"+birth_date_time+"</td>");
			 
		  
            _bw.write(_wl_block27Bytes, _wl_block27);
  
				
				birth_weight = rset.getString(7)==null?"":rset.getString(7);
				String weight_unit=rset.getString(8)==null?"":rset.getString(8);
				if(weight_unit.toUpperCase().equals("K"))
                {					weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.kg.label","common_labels");
				}
				else if(weight_unit.toUpperCase().equals("L"))
                {			   weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.lb.label","common_labels");
				}
				if(!birth_weight.equals(""))
					out.println("<td "+regnStatusStyle+" >"+birth_weight+" "+weight_unit+"</td>");
				else
					out.println("<td "+regnStatusStyle+" >"+birth_weight+"</td>");

				if(finalized_yn.equals("Y")) {												out.println("<td "+regnStatusStyle+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalized.label","common_labels")+"</td>");
				} else if(finalized_yn.equals("N")) {					out.println("<td "+regnStatusStyle+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Registered.label","common_labels")+"</td>");
				}

				if(!speciality.equals(""))
				{
				out.println("<td "+regnStatusStyle+">"+speciality+ "</td>");
				}
				else
				{
				  out.println("<td "+regnStatusStyle+">"+"&nbsp"+ "</td>");
				}
				if(!nursing_unit.equals(""))
				{
					out.println("<td "+regnStatusStyle+">"+ nursing_unit+"</td>");
			    } else {
					out.println("<td "+regnStatusStyle+">"+"&nbsp"+ "</td>");
				}
				if(!baby_bed_no.equals(""))
				{
					out.println("<td "+regnStatusStyle+">"+ baby_bed_no+"</td>");
				} else {
					out.println("<td "+regnStatusStyle+">"+"&nbsp"+ "</td>");
				}
				out.println("</tr>");
			}while(rset.next());
			out.println("</table><table border='1' cellpadding=0 cellspacing=0 width='100%'><tr><td width = '5%' bordercolor='black' style='background-color:#FECBFA' >&nbsp;</td><td width = '25%'> &nbsp;" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FirstStageRegistrationRecords.label","mp_labels")+"</td><td width = '5%' bordercolor='black' style='background-color:#00FFFF'> &nbsp;</td><td width = '25%'> &nbsp;" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FinalizedRecords.label","mp_labels")+"</td><td width='40%'>&nbsp;</td></tr></table>");
			
		}
		
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block28Bytes, _wl_block28);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NewbornID.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Task.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BabyName.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthWeight.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }
}
