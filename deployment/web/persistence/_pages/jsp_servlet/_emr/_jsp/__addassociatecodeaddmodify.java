package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __addassociatecodeaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AddAssociateCodeAddModify.jsp", 1743665137038L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n<HEAD>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n\n\tasync function SearchDiagCode()\n\t{\n\t\t\n\t\tvar dialogHeight= \"27.22vh\" ;\n\t\tvar dialogWidth = \"44vw\" ;\n\t\tvar status = \"no\";\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\tretVal = await window.showModalDialog(\"TermCodeSearchMainFrame.jsp?term_set_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&Dob=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Age=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Sex=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&code_indicator=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",arguments,features);\n\n\t\t//retVal = window.showModalDialog(\"PaintConsultationFrame.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",arguments,features);\n\t\t\n\t\tif(retVal != null)\n\t\t{\n\t\t\tdocument.forms[0].diag_code.value = retVal;\n\t\t\tdocument.forms[0].diag_code.onblur();\n\t\t}\n\t}\n\tfunction doSelect(val)\n\t{\n\t\tvar diag_code = document.AddAssociateCodeAddModifyForm.diag_code.value;\n\t\tvar diag_desc = document.AddAssociateCodeAddModifyForm.diag_desc.value;\n\t\tvar mode = document.AddAssociateCodeAddModifyForm.mode.value;\n\t\t\t\n\t\t if(val == \'A\')\n\t\t{\n\t\t\tif(document.AddAssociateCodeAddModifyForm.diag_code.value == \'\' || document.AddAssociateCodeAddModifyForm.diag_desc.value == \'\' )\n\t\t\t{\n\t\t\t\talert(getMessage(\'ASS_DIAG_IN_SUF_DATA\',\'MR\'));\n\t\t\t}\t\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar convals_array = document.AddAssociateCodeAddModifyForm.convals.value.split(\'|\');\t\n\t\t\t\tif(convals_array.length >= 1)\n\t\t\t\t{\n\t\t\t\t\tfor(i=0;i<convals_array.length;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar temp_conval = convals_array[i].split(\'|\');\n\t\t\t\t\t\tfor(j=0;j<temp_conval.length;j++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar temp_conval_code = temp_conval[j].split(\'~\');\n\t\t\t\t\t\t\tif(temp_conval_code[0] == diag_code)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar msg=getMessage(\'AM0141\',\'AM\');\n\t\t\t\t\t\t\t\tmsg= msg.replace(\'ID\',getLabel(\"Common.Associate.label\",\"Common\")+\' \'+getLabel(\"Common.code.label\",\"Common\"));\n\t\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.value=\'\';\n\t\t\t\t\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_desc.value=\'\';\n\t\t\t\t\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.focus();\n\n\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\t\n\t\t\t\tvar convals = document.AddAssociateCodeAddModifyForm.convals.value;\n\t\t\t\tif(document.AddAssociateCodeAddModifyForm.convals.value != \"\")\n\t\t\t\t\tconvals +=  \"|\";\n\t\t\t\tconvals += escape(diag_code) + \"~\" + escape(diag_desc);\n\t\t\t\tdocument.AddAssociateCodeAddModifyForm.convals.value = convals;\n\t\t\t\n\t\t\t\t//parent.AddAssociateCodeListFrame.location.href = \"../../eCA/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&diag_desc=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&title=\"+encodeURIComponent(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')+\"&p_diag_code=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&p_diag_scheme_desc=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&Encounter_Id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&p_auth_yn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&cause_indicator=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&p_scheme=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&diag_code=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&convals=\" + convals;\n\t\t\t\tparent.AddAssociateCodeListFrame.location.href = \"../../eMR/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&term_set_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&convals=\" + convals;\n\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.value = \"\";\n\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_desc.value = \"\";\n\t\t\t\t\n\t\t\t}\n\t\t\tdocument.AddAssociateCodeAddModifyForm.flag_to_add.value = \'\';\n\t\t}\n\t\telse if(val == \'DELETE\')\n\t\t{\n\t\t\t\n\t\t\tvar delconvals = \"\";\n\t\t\tvar del_code = document.AddAssociateCodeAddModifyForm.diag_code.value;\n\t\t\tvar convals_array = document.AddAssociateCodeAddModifyForm.convals.value.split(\'|\');\n\t\t\t\tif(convals_array.length > 0)\n\t\t\t\t{\n\t\t\t\t\tfor(i=0;i<convals_array.length;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar temp_conval = convals_array[i].split(\'|\');\n\t\t\t\t\t\tfor(j=0;j<temp_conval.length;j++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar temp_conval_code = temp_conval[j].split(\'~\');\n\t\t\t\t\t\t\tif(temp_conval_code[0] != del_code)\n\t\t\t\t\t\t\t\tdelconvals +=temp_conval[j]+\"|\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\t\n\t\t\t\t\n\t\t\t\n\t\t\t//parent.AddAssociateCodeListFrame.location.href = \"../../eCA/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&convals=\" + delconvals;\n\n\t\t\tparent.AddAssociateCodeListFrame.location.href = \"../../eMR/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&convals=\" + delconvals;\n\t\t\tdocument.AddAssociateCodeAddModifyForm.convals.value =delconvals ;\n\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.value = \"\";\n\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_desc.value = \"\";\n\n\t\t}\n\t\telse if(val == \'CANCEL\')\n\t\t{\n\t\t\twindow.returnValue = document.AddAssociateCodeAddModifyForm.convals.value;\n\t\t\tparent.window.close();\n\t\t}\n\t\telse if(val == \'CLEAR\')\n\t\t{\n\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.value = \"\";\n\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_desc.value = \"\";\n\t\t}\n\t\telse if(val == \'OK\')\n\t\t{\t\t\t\n\t\t\twindow.returnValue = document.AddAssociateCodeAddModifyForm.convals.value;\n\t\t\twindow.close();\n\t\t}\n\t\telse if(val == \'TEMP\')\n\t\t{\t\t\t\n\t\t\tif(document.AddAssociateCodeAddModifyForm.flag_to_add.value == \'Y\')\n\t\t\t\tdoSelect(\'A\');\n\t\t\telse\n\t\t\t\tdocument.AddAssociateCodeAddModifyForm.flag_to_add.value = \'Y\';\t\t\t\n\t\t}\n\t}\n\tfunction getDiagDescription(obj)\n\t{\n\t\tif(obj.value != \"\")\n\t\t{\n\t\t\tobj.value = obj.value.toUpperCase();\n\t\t\tvar diag_code = obj.value;\n\n\t\t\t\n\t\t\tvar HTMLVal = \"<form name=\'getDiagVal\' id=\'getDiagVal\' action=\'../../eMR/jsp/AddAssociateCodeValidate.jsp\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'term_set_code\' id=\'term_set_code\' value =\'\" + diag_code + \"\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value =\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'Sex\' id=\'Sex\' value =\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'Dob\' id=\'Dob\' value =\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'code_indicator\' id=\'code_indicator\' value =\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'mode\' id=\'mode\' value =\'Externalcause\'>\";\n\t\t\tHTMLVal += \"</form>\";\n\n\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'beforeend\',HTMLVal);\n\t\t\t//parent.messageFrame.document.write(HTMLVal);\n\t\t\tparent.messageFrame.document.getDiagVal.submit();\n\n\t\t\t\n\t\t}\n\t\t\n\t}\n\tasync function showLongDescription()\n\t{\n\t\tvar dialogHeight= \"20vh\" ;\n\t\tvar dialogWidth = \"23vw\" ;\n\t\tvar a = document.AddAssociateCodeAddModifyForm.long_desc.value;\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\";\n\t\tawait window.showModalDialog(\"../../eMR/jsp/PatProblemDialogLongDesc.jsp?longDesc=\"+a,\"\",features);\n\t}\n\t//-->\n\t</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n\t<BODY onKeyDown=\'lockKey()\'>\n\t\t<form name=\"AddAssociateCodeAddModifyForm\" id=\"AddAssociateCodeAddModifyForm\">\n\t<br>\t\t\t\t\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'80%\' align=\'center\'>\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t<td width=\'85%\'>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" align = \"right\" width=\'30%\'>\n\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align = left class=\"label\" >\n\t\t\t\t\t\t<input type=\"text\" name = \"diag_code\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onblur = \"getDiagDescription(this)\" maxlength=\'5\' size=\'5\'>\n\t\t\t\t\t\t<input type=\"button\" name=\"question\" id=\"question\" value= \"?\" class=\"button\" onclick = \'SearchDiagCode()\'>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!-- <tr>\n\t\t\t\t\t<td colspan=2>\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t</tr>   -->\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" align = right>\n\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align = left class=\"label\">\n\t\t\t\t\t\t<input type=\"text\" name = \"diag_desc\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" readonly >\n\t\t\t\t\t\t<input type=\"button\" name=\"exclamation\" id=\"exclamation\" value= \"!\" class=\"button\" disabled onclick=\"showLongDescription()\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t<td width=\'85%\'>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'button\' colspan=2>\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Select\" id=\"Select\" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' onClick=\"doSelect(\'TEMP\')\">&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Delete\" id=\"Delete\" value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onClick=\"return doSelect(\'DELETE\')\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">&nbsp;&nbsp;\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Ok\" id=\"Ok\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' onClick=\"doSelect(\'OK\')\">&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Clear\" id=\"Clear\" value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onClick=\"doSelect(\'CLEAR\')\">&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Cancel\" id=\"Cancel\" value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' onClick=\"doSelect(\'CANCEL\')\">&nbsp;&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t<input type=\"hidden\" name=\"convals\" id=\"convals\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t<input type=\"hidden\" name=\"long_desc\" id=\"long_desc\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"flag_to_add\" id=\"flag_to_add\" value=\"\">\n\t\t</form>\n\t</BODY>\n\t</HTML>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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

try
{

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String code_indicator = (request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator"));
	String diag_desc = (request.getParameter("diag_desc")==null?"":request.getParameter("diag_desc"));
	String title = (request.getParameter("title")==null?"":request.getParameter("title"));
	String p_diag_code = (request.getParameter("p_diag_code")==null?"":request.getParameter("p_diag_code"));
	String p_diag_scheme_desc = (request.getParameter("p_diag_scheme_desc")==null?"":request.getParameter("p_diag_scheme_desc"));
	String Encounter_Id = (request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id"));
	String p_auth_yn = (request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn"));
	String cause_indicator = (request.getParameter("cause_indicator")==null?"":request.getParameter("cause_indicator"));
	String Age = (request.getParameter("Age")==null?"":request.getParameter("Age"));
	String Sex = (request.getParameter("Sex")==null?"":request.getParameter("Sex"));
	String Dob = (request.getParameter("Dob")==null?"":request.getParameter("Dob"));

	String currConVals = (request.getParameter("currConVals")==null?"":request.getParameter("currConVals"));
	String convals = (request.getParameter("convals")==null?"":request.getParameter("convals"));
	
	String disable_delete = (currConVals.equals("")?"disabled":"");
	StringTokenizer strToken = new StringTokenizer(currConVals, "~");
	String diag_code = "";
	String curr_diag_desc = "";
	String mode = (request.getParameter("mode")==null?"":request.getParameter("mode"));;
	String p_scheme = (request.getParameter("p_scheme")==null?"":request.getParameter("p_scheme"));;

	String associate_codes  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
	
	String param_diag_code  = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");

	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");

	
	if(!associate_codes.equals(""))
		convals = associate_codes;

	while(strToken.hasMoreTokens())
	{
		diag_code = java.net.URLEncoder.encode((String)strToken.nextToken());
		curr_diag_desc = java.net.URLEncoder.encode((String)strToken.nextToken());
	}

	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(title));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_diag_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_diag_scheme_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_auth_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_scheme));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(param_diag_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(title));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_diag_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_diag_scheme_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_auth_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_scheme));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(param_diag_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(title));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_diag_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_diag_scheme_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_auth_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_scheme));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(param_diag_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(title));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_diag_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_diag_scheme_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_auth_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_scheme));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(param_diag_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLDecoder.decode(diag_code)));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(java.net.URLDecoder.decode(curr_diag_desc)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disable_delete));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(convals));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
catch(Exception e)
{
	//out.println("Exception in AddAssociateCodeAddModify.jsp" + e.toString());
	e.printStackTrace();
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
}
