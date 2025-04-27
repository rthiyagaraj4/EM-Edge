package jsp_servlet._emr._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __dprecodingbutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingButton.jsp", 1709118908673L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script> \n\t<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n\n\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n</head>\n<body onKeyDown=\'lockKey()\'  onload=\"dis_but_dum(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\">\n<form name=\'RecodeButton\' id=\'RecodeButton\'>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\n\t\t\t<table align=\'right\' cellpadding=0 cellspacing=0 border=0>\n\t\t\t<tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<td><input type=\'button\' name=\'new_code_diag\' id=\'new_code_diag\' id=\'newCodeButton\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' class=\'button\'  onclick=\'newCode(\"Diag\");\' style=\"visibility:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" width=\'10\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<td><input type=\'button\' name=\'new_code_proc\' id=\'new_code_proc\' id=\'newCodeButton\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' class=\'button\'  onclick=\'newCode(\"Proc\");\'  style=\"visibility:";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\n\t\t\t\t\t<td><input type=\'button\' name=\'recode\' id=\'recode\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' class=\'button\'  onclick=\'recodeScreen()\'>&nbsp;</td> <!-- modified by mujafar for ML-MMOH-CRF-1270 -->\n\t\t\t\t\t\t\n\t\t\t\t\t<td><input type=\'button\' name=\'error\' id=\'error\' id=\'error_button\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' class=\'button\'  onclick=\'markScreen();\'>&nbsp;</td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<td  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" ><input type=\'button\' name=\'confirm\' id=\'confirm\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' class=\'button\'  onclick=\'confirmScreen();\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<td>\n\t\t\t\t\t<input type=\'button\' name=\'complete\' id=\'complete\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' class=\'button\'  onclick=\'completeScreen();\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<td><input type=\'button\' name=\'authorize\' id=\'authorize\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' class=\'button\'  onclick=\'Click_Authorize();\'>&nbsp;<input type=\'button\' name=\'reject\' id=\'reject\'  value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' class=\'button\'   onclick=\'rejectScreen();\'>&nbsp;</td>\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<!--td><input type=\'button\' name=\'sequence\' id=\'sequence\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' class=\'button\'   onclick=\'\'>&nbsp;</td-->\t\n\t\t\t\t\t\t<td><input type=\'button\' name=\'calDrg\' id=\'calDrg\' id=\'calDRG\'  value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' class=\'button\'  onclick=\'recallDRG();\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =">&nbsp;\n\t\t\t\t\t\t<input type=\'button\' name=\'seqDrg\' id=\'seqDrg\' id=\'seqImg\'  value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' class=\'button\'  onclick=\"Open_DRG(\'x\')\"; ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="> &nbsp;</td>\n\t\t\t\t\t\t<td><input type=\'button\' name=\'reject\' id=\'reject\' id=\'reject1\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' class=\'button\'   onclick=\'Reject_Drg()\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" >&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<td><input type=\'button\' name=\'reject\' id=\'reject\' id=\'reject1\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t</tr>\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<!-- Added On 10/21/2009 \n\t\t   For FreeText Enable Disable Confirm Button GHL 41.\n\t-->\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t<!--\n\t\tdisableDiagProcChkbox(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\n\t//-->\n\t</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<input type=\'hidden\' name=\'Pat_id\' id=\'Pat_id\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'EncounterId\' id=\'EncounterId\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\'hidden\' name=\'proc_cnt\' id=\'proc_cnt\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\'hidden\' name=\'authorize_cnt\' id=\'authorize_cnt\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\'hidden\' name=\'stage_no\' id=\'stage_no\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \n\t<input type=\'hidden\' name=\'confirm_appl\' id=\'confirm_appl\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"> <!-- added by mujafar for ML-MMOH-CRF-0878 -->\n\t\n\t<!-- <input type=\'text\' name=\'Complete_YN\' id=\'Complete_YN\' value=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="> -->\n\t<input type=\'hidden\' name=\'activity\' id=\'activity\' value=\"\">\n\t<input type=\'hidden\' name=\'Confirm_Dig_Data\' id=\'Confirm_Dig_Data\' value=\"\">\n\t<input type=\'hidden\' name=\'Confirm_Proc_Data\' id=\'Confirm_Proc_Data\' value=\"\">\n\t<input type=\'hidden\' name=\'sel_proc_srl_no\' id=\'sel_proc_srl_no\' value=\"\">\n\t<input type=\'hidden\' name=\'marked_err_diagvals\' id=\'marked_err_diagvals\' value=\"\">\n\t<input type=\'hidden\' name=\'sel_srl_no\' id=\'sel_srl_no\' value=\"\">\n\t<input type=\'hidden\' name=\'sel_status\' id=\'sel_status\' value=\"\">\n\t<input type=\'hidden\' name=\'grpby_val\' id=\'grpby_val\' value=\"\">\n\t<input type=\'hidden\' name=\'sel_stages_val\' id=\'sel_stages_val\' value=\"\">\n\t<input type=\'hidden\' name=\'procedure_yn\' id=\'procedure_yn\' value=\"\">\n\t<input type=\'hidden\' name=\'Patient_Class\' id=\'Patient_Class\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\'hidden\' name=\'applicationID\' id=\'applicationID\' value=\"TGRP\">\n\t<input type=\'hidden\' name=\'eventType\' id=\'eventType\' value=\"D01\">\n\t<input type=\'hidden\' name=\'profileID\' id=\'profileID\' value=\"SRRDRG1\">\n\t<input type=\'hidden\' name=\'diag_stage_values_cnfrm\' id=\'diag_stage_values_cnfrm\' value=\"\">\n\t<input type=\'hidden\' name=\'proc_stage_values_cnfrm\' id=\'proc_stage_values_cnfrm\' value=\"\">\n\t<input type=\'hidden\' name=\'diag_group_values_cnfrm\' id=\'diag_group_values_cnfrm\' value=\"\">\n\t<input type=\'hidden\' name=\'diag_group_seq_values_cnfrm\' id=\'diag_group_seq_values_cnfrm\' value=\"\">\n\t<input type=\'hidden\' name=\'proc_group_values_cnfrm\' id=\'proc_group_values_cnfrm\' value=\"\">\n\t<input type=\'hidden\' name=\'proc_group_seq_values_cnfrm\' id=\'proc_group_seq_values_cnfrm\' value=\"\">\n\t<input type=\'hidden\' name=\'diag_status_values_cnfrm\' id=\'diag_status_values_cnfrm\' value=\'\'>\n\t<input type=\'hidden\' name=\'proc_status_values_cnfrm\' id=\'proc_status_values_cnfrm\' value=\'\'>\n\n\t<input type=\'hidden\' name=\'diag_new_seq\' id=\'diag_new_seq\' value=\"\">\n\t<input type=\'hidden\' name=\'proc_new_seq\' id=\'proc_new_seq\' value=\"\">\n\t<input type=\'hidden\' name=\'allow_recode_diag_yn\' id=\'allow_recode_diag_yn\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\'hidden\' name=\'allow_recode_proc_yn\' id=\'allow_recode_proc_yn\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\'hidden\' name=\'principal_diag\' id=\'principal_diag\' value=\'\'>\n\t<input type=\'hidden\' name=\'prin_stg_srl_no\' id=\'prin_stg_srl_no\' value=\'\'>\n\t<input type=\'hidden\' name=\'drg_yn\' id=\'drg_yn\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t<input type=\'hidden\' name=\'final_diag_confirm_yn\' id=\'final_diag_confirm_yn\' value=\'\'>\n\t<input type=\'hidden\' name=\'final_proc_confirm_yn\' id=\'final_proc_confirm_yn\' value=\'\'>\n\t<input type=\'hidden\' name=\'final_Diag_group_yn\' id=\'final_Diag_group_yn\' value=\'\'><!-- Added On 7/2/2009 -->\n\t<input type=\'hidden\' name=\'final_Proc_group_yn\' id=\'final_Proc_group_yn\' value=\'\'><!--Added On 7/2/2009  -->\n\t<input type=\'hidden\' name=\'stage_auth\' id=\'stage_auth\' value=\'\'>\n<!-- \t<input type=\'hidden\' name=\'sel_mod_id\' id=\'sel_mod_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'sel_cod_xtn\' id=\'sel_cod_xtn\' value=\'\'>\n\t<input type=\'hidden\' name=\'sel_acess_num\' id=\'sel_acess_num\' value=\'\'>\n\t<input type=\'hidden\' name=\'sel_cod_xtn_dtl\' id=\'sel_cod_xtn_dtl\' value=\'\'>\n -->\n\t<input type=\'hidden\' name=\'rec_diag_tset\' id=\'rec_diag_tset\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t<input type=\'hidden\' name=\'rec_proc_tset\' id=\'rec_proc_tset\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t<!-- Added On 2/16/2010 for SRR-CRF-303.2(IN015597)  -->\n\t<input type=\'hidden\' name=\'group_yn_data\' id=\'group_yn_data\' value=\'\'>\n\t<input type=\'hidden\' name=\'group_seq_no_data\' id=\'group_seq_no_data\' value=\'\'>\n\t<input type=\'hidden\' name=\'support_seq_no_data\' id=\'support_seq_no_data\' value=\'\'>\n\t<input type=\'hidden\' name=\'hdr_modified_dt\' id=\'hdr_modified_dt\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'> \n\t<input type=\'hidden\' name=\'isMultiDescAppl\' id=\'isMultiDescAppl\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'> <!-- added by mujfar for ML-MMOH-CRF-1281 -->\n\t</form>\n</body>\n</html>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
	
Connection conn=null;

try{
 	conn = ConnectionManager.getConnection(request);	
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

 String sStyle				 = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
 String loginUser		 = (String)session.getValue("login_user");
 String stage_no		 = request.getParameter("stage_no");
 String Pat_id			 = request.getParameter("Pat_id");
 String EncounterId	 = request.getParameter("EncounterId");
 String pat_class		  = checkForNull(request.getParameter("pat_class"));
 String open_recal_drg	= checkForNull(request.getParameter("open_recal_drg"),"N");
String sel_val				= checkForNull(request.getParameter("sel_val"));
String execute_hdr_qry	= checkForNull(request.getParameter("execute_hdr_qry"),"N");
String p_facility_id		= (String) session.getValue( "facility_id" ) ;
String confirm_appl         = checkForNull(request.getParameter("confirm_appl"));
Boolean isConfirmApplicable = false; // added by mujafar for ML-MMOH-CRF-0878 start
String dis_yn= "";
isConfirmApplicable      = eCommon.Common.CommonBean.isSiteSpecific(conn, "MR", "CONFIRM_IN_RECODE_APPL"); 
confirm_appl  = checkForNull(eMR.MRCommonBean.getConfirmRecode(conn,p_facility_id,loginUser));

	if(isConfirmApplicable && confirm_appl.equals("N"))
			dis_yn="style=\'display:none'"; // added by mujafar for ML-MMOH-CRF-0878 end
		
Boolean isMultiDescAppl = false; 
isMultiDescAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281
String allow_recode_diag_yn				= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn				= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
String allow_ot_proc_recode_yn			= checkForNull((String)session.getAttribute("allow_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String allow_non_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_non_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String drg_yn										= checkForNull((String)session.getAttribute("drg_calculation_yn"),"N");
String rec_diag_trm_st="";
String rec_proc_trm_st="";
if(sel_val.equals("")){
	sel_val=stage_no;
}
String disable_recal_btn="disabled";
String disable_drg_btn="";
if(open_recal_drg.equals("Y")){
	disable_recal_btn ="";
	disable_drg_btn   ="disabled";
}
 		


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			int proc_cnt = 0;
			int authorize_cnt = 0;
			String authorise_yn = "";
			String pcalss_status= "";
			String hdr_modified_dt= ""; //Added on  2/26/2010 for Concurrent Users.



		String hdr_level ="";
		String hdr_status ="";
		String L1_hdr_status = "";
		String L2_hdr_status = "";
		String L3_hdr_status = "";
		String disp_none="N";


		if(execute_hdr_qry.equals("Y")){
			String sql_hdr_sts="SELECT CURR_LEVEL,nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS,to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"'";

			pstmt = conn.prepareStatement(sql_hdr_sts);
			rs = pstmt.executeQuery();	
			while(rs.next()){
				hdr_level=rs.getString("CURR_LEVEL");
				L1_hdr_status=rs.getString("LEVEL1_STATUS");
				L2_hdr_status=rs.getString("LEVEL2_STATUS");
				L3_hdr_status=rs.getString("LEVEL3_STATUS");
				hdr_modified_dt=rs.getString("MODIFIED_DATE");
			}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		}else{
			L1_hdr_status = checkForNull(request.getParameter("L1_hdr_status"));
			L2_hdr_status = checkForNull(request.getParameter("L2_hdr_status"));
			L3_hdr_status = checkForNull(request.getParameter("L3_hdr_status"));
			hdr_modified_dt		= checkForNull(request.getParameter("hdr_modified_dt_qr"));
			hdr_level		= checkForNull(request.getParameter("curr_level"));
		}
		if(sel_val.equals("1")){
			if(!L2_hdr_status.equals("P") || !L3_hdr_status.equals("P")){		
				disp_none="Y";
			}
			hdr_status=L1_hdr_status;
		}else if(sel_val.equals("2")){
			if(L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){// aded 19/jun	
				if(L1_hdr_status.equals("A")){
					L2_hdr_status="A";
				}
			}
			if( !L3_hdr_status.equals("P")){				
				disp_none="Y";
			}
			hdr_status=L2_hdr_status;
			
		}else if(sel_val.equals("3")){
			if(L3_hdr_status.equals("P")){ // aded 19/jun	
				if((L1_hdr_status.equals("A") && L2_hdr_status.equals("P")) || L2_hdr_status.equals("A")){
					L3_hdr_status="A";
				}
			}
			hdr_status=L3_hdr_status;
			
		}
		
		if(Integer.parseInt(sel_val)< Integer.parseInt(stage_no)){
			disp_none="Y";
		}

		String sql3="SELECT AUTHORIZE_YN FROM MR_RECODE_PRIVI_SETUP_DTL WHERE STAGE_NO='"+stage_no+"' and APPL_USER_ID='"+loginUser+"' and facility_id = '"+p_facility_id+"' ";
		pstmt = conn.prepareStatement(sql3);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			authorise_yn = rs.getString("AUTHORIZE_YN");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();


		if(authorise_yn.equals("")){
			String sql_recode="SELECT ALLOW_AUTHORIZATION_YN FROM MR_RECODE_PRIVI_SETUP WHERE STAGE_NO='"+stage_no+"'";
		pstmt = conn.prepareStatement(sql_recode);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			authorise_yn = rs.getString("ALLOW_AUTHORIZATION_YN");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		}
		
		/*sql3="select nvl(DRG_CALCULATION_YN,'N') DRG_CALCULATION_YN from mr_parameter";
		pstmt = conn.prepareStatement(sql3);
		rs = pstmt.executeQuery();	
		String drg_yn="";
		while(rs.next()){
			drg_yn = checkForNull(rs.getString("DRG_CALCULATION_YN"));

		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();*/

		/*if(auth_at_stage.equals("")){

			String sql_recode="SELECT ALLOW_AUTHORIZATION_YN FROM MR_RECODE_PRIVI_SETUP WHERE STAGE_NO='"+stage_no+"'";
			pstmt = conn.prepareStatement(sql_recode);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				authorise_yn = rs.getString("ALLOW_AUTHORIZATION_YN");

			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}else{
			if(Integer.parseInt(stage_no)>= Integer.parseInt(auth_at_stage)){
				authorise_yn="Y";
			}else{
				authorise_yn="N";
			}
		}
		*/
		
		/*String  complete_yn="";
		String confirm_yn="";
		String enable_confirm="N";

		String sql_sttuscheck="SELECT CONFIRM_YN from mr_diagnosis_recoding_dtl where facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and active_yn='Y' and stage_no='"+sel_val+"' union SELECT CONFIRM_YN from mr_procedure_recoding_dtl where facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and active_yn='Y' and stage_no='"+sel_val+"'";

		pstmt = conn.prepareStatement(sql_sttuscheck);
		rs = pstmt.executeQuery();	

		while(rs.next()){
			confirm_yn = rs.getString("CONFIRM_YN");
			if(confirm_yn.equals("N")){
				enable_confirm="Y";
				break;
			}			
		}

		if(enable_confirm.equals("N")){
			if(stage_no.equals("1") && L1_hdr_status.equals("P")){
				enable_confirm="Y";
			}else if(stage_no.equals("2") && L2_hdr_status.equals("P")){
				enable_confirm="Y";
			}else if(stage_no.equals("3") && L3_hdr_status.equals("P")){
				enable_confirm="Y";
			}			
		}

		if(enable_confirm.equals("Y")){
			complete_yn="N";
		}else{
			complete_yn="Y";
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		*/

/*To disable New Procedure Code and New Diagnosis Code Buttons 
the following count queries are used*/	
int diag_count=0;
String new_diag_btn="";
int proc_count=0;
String new_proc_btn="";
String Diag_EncounterID=EncounterId;//If allow_recode_diag_yn="Y";
String Proc_EncounterID=EncounterId;//If allow_recode_diag_yn="Y";

if(allow_recode_diag_yn.equals("N")){
	Diag_EncounterID	=	"";
}

/*
Commented on 4/27/2010 for PE 
String diag_count_SQL	="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+Diag_EncounterID+"' ";

		pstmt = conn.prepareStatement(diag_count_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			diag_count = rs.getInt("COUNT");
			if(diag_count==0){
				new_diag_btn	="hidden";				
			}else{
				new_diag_btn="visible";
		}
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();*/
/*Added On 7/7/2009*/
String CONTR_MOD_ID	="";
if(allow_recode_proc_yn.equals("Y")){
	if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
		CONTR_MOD_ID ="";
	}/*else if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("N")){
		Proc_EncounterID="";
	}*/else if(allow_ot_proc_recode_yn.equals("Y")){
		CONTR_MOD_ID	=" AND CONTR_MOD_ID='OT' ";
	}else if(allow_non_ot_proc_recode_yn.equals("Y")){
		CONTR_MOD_ID	=" AND nvl(CONTR_MOD_ID,'x')!=nvl('OT','x') ";
	}else{
		Proc_EncounterID="";
	}
}else if(allow_recode_proc_yn.equals("N")){
	Proc_EncounterID	=	"";
}


/*
Commented on 4/27/2010 for PE 
String proc_count_SQL	="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+Proc_EncounterID+"' "+CONTR_MOD_ID+"  ";



		pstmt = conn.prepareStatement(proc_count_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			proc_count = rs.getInt("COUNT");
			if(proc_count==0){
				new_proc_btn	="hidden";				
			}else{
				new_proc_btn="visible";
		}
	}
	
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();*/
	/*The below query was merging of both quries of which was commented for PE.*/
	String diag_proc_count_SQL	="SELECT (SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+Diag_EncounterID+"')DIAG_COUNT,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+Proc_EncounterID+"' "+CONTR_MOD_ID+")PROC_COUNT FROM DUAL";
		pstmt = conn.prepareStatement(diag_proc_count_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			diag_count = rs.getInt("DIAG_COUNT");
			proc_count = rs.getInt("PROC_COUNT");
		}
		
		
		if(diag_count==0){
			new_diag_btn	="hidden";				
		}else{
			new_diag_btn="visible";
		}
		if(proc_count==0){
			new_proc_btn	="hidden";				
		}else{
			new_proc_btn="visible";
		}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	String recodable_ts	="SELECT TERM_SET_ID,TERM_SET_DESC,DIAG_SPEC_YN,PROC_SPEC_YN FROM MR_TERM_SET WHERE RECODERS_APPL_YN='Y'";
	pstmt = conn.prepareStatement(recodable_ts);
	rs = pstmt.executeQuery();

	while(rs.next()){
		
		if(rs.getString("DIAG_SPEC_YN").equals("Y")){
			rec_diag_trm_st	=rs.getString("TERM_SET_ID");				
		}
		if(rs.getString("PROC_SPEC_YN").equals("Y")){
			rec_proc_trm_st	=rs.getString("TERM_SET_ID");				
		}
	}
		
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sel_val));
            _bw.write(_wl_block9Bytes, _wl_block9);

if(hdr_status.equals("R")){
	hdr_status="S";
}

	if(!sel_val.equals("0")){
		if(disp_none.equals("N")){
            _bw.write(_wl_block10Bytes, _wl_block10);
if(!hdr_status.equals("A")){
            _bw.write(_wl_block11Bytes, _wl_block11);
if(hdr_status.equals("P") || hdr_status.equals("S")){
            _bw.write(_wl_block12Bytes, _wl_block12);
if(new_diag_btn.equals("visible")){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NewDiagnosis.label","mr_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(new_diag_btn));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
if(new_proc_btn.equals("visible")){
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NewProcedure.label","mr_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(new_proc_btn));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MarkError.label","common_labels")));
            _bw.write(_wl_block22Bytes, _wl_block22);
//if(enable_confirm.equals("Y")){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dis_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirm.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
//}
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
if(!hdr_status.equals("A") && !hdr_status.equals("C")){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
			
					
				if(hdr_status.equals("C") && authorise_yn.equals("Y")){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
			}



			if(hdr_status.equals("A") && authorise_yn.equals("Y") ){
					if(pat_class.equals("IP")&& drg_yn.equals("Y")){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Sequence.label","mr_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CalculateDRG.label","mr_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pcalss_status));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disable_recal_btn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DRG.label","mr_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(pcalss_status));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disable_drg_btn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectDRG.label","mr_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pcalss_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pcalss_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
				}
            _bw.write(_wl_block43Bytes, _wl_block43);
}
	}
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disp_none));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(proc_cnt));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(authorize_cnt));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(stage_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(confirm_appl));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(stage_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(allow_recode_diag_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(allow_recode_proc_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drg_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(rec_diag_trm_st));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rec_proc_trm_st));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(hdr_modified_dt));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(isMultiDescAppl));
            _bw.write(_wl_block61Bytes, _wl_block61);

}catch(Exception e){
	e.printStackTrace();
 }finally{
		ConnectionManager.returnConnection(conn,request);

 }
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
