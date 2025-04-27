package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

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
        if (sci.isResourceStale("/eca/jsp/AddAssociateCodeAddModify.jsp", 1743576600574L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t<!--\n\tasync function SearchDiagCode()\n\t{\n\t\tvar dialogHeight= \"27.22\" ;\n\t\tvar dialogWidth = \"44\" ;\n\t\tvar status = \"no\";\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\tretVal =await window.showModalDialog(\"PaintConsultationFrame.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\",arguments,features);\n\t\tif(retVal != null)\n\t\t{\n\t\t\tdocument.forms(0).diag_code.value = retVal;\n\t\t\tdocument.forms(0).diag_code.onblur();\n\t\t}\n\t}\n\tfunction doSelect(val)\n\t{\n\t\tvar diag_code = document.AddAssociateCodeAddModifyForm.diag_code.value;\n\t\tvar diag_desc = document.AddAssociateCodeAddModifyForm.diag_desc.value;\n\t\tvar long_desc = document.AddAssociateCodeAddModifyForm.long_desc.value;\n\t\tvar mode = document.AddAssociateCodeAddModifyForm.mode.value;\n\t\tif(val == \'A\')\n\t\t{\n\t\t\tif(document.AddAssociateCodeAddModifyForm.diag_code.value == \'\' || document.AddAssociateCodeAddModifyForm.diag_desc.value == \'\' )\n\t\t\t{\n\t\t\t\talert(getMessage(\'ASS_DIAG_IN_SUF_DATA\',\'CA\'));\n\t\t\t}\t\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar convals_array = document.AddAssociateCodeAddModifyForm.convals.value.split(\'|\');\t\n\t\t\t\tif(convals_array.length >= 1)\n\t\t\t\t{\n\t\t\t\t\tfor(i=0;i<convals_array.length;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar temp_conval = convals_array[i].split(\'|\');\n\t\t\t\t\t\tfor(j=0;j<temp_conval.length;j++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar temp_conval_code = temp_conval[j].split(\'~\');\n\t\t\t\t\t\t\tif(temp_conval_code[0] == diag_code)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\talert(getMessage(\'ASS_DIAG_UNIQUE_CHK\',\'CA\'));\n\n\t\t\t\t\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.value=\'\';\n\t\t\t\t\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_desc.value=\'\';\n\t\t\t\t\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.focus();\n\n\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\t\n\t\t\t\tvar convals = document.AddAssociateCodeAddModifyForm.convals.value;\n\t\t\t\tif(document.AddAssociateCodeAddModifyForm.convals.value != \"\")\n\t\t\t\t\tconvals +=  \"|\";\n\t\t\t\tconvals += escape(diag_code) + \"~\" + escape(diag_desc)+\"~\"+escape(long_desc);\n\t\t\t\tdocument.AddAssociateCodeAddModifyForm.convals.value = convals;\n\t\t\t\t\n\t\t\t\tparent.AddAssociateCodeListFrame.location.href = \"../../eCA/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&diag_desc=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&title=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&p_diag_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&p_diag_scheme_desc=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&Encounter_Id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&p_auth_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&cause_indicator=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&Age=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&Sex=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&Dob=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&p_scheme=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&diag_code=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&convals=\" + convals;\n\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.value = \"\";\n\t\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_desc.value = \"\";\n\t\t\t\tdocument.AddAssociateCodeAddModifyForm.long_desc.value = \"\";\n\t\t\t}\n\t\t\tdocument.AddAssociateCodeAddModifyForm.flag_to_add.value = \'\';\n\t\t}\n\t\telse if(val == \'DELETE\')\n\t\t{\n\t\t\tvar delconvals = \"\";\n\t\t\tvar del_code = document.AddAssociateCodeAddModifyForm.diag_code.value;\n\t\t\tvar convals_array = document.AddAssociateCodeAddModifyForm.convals.value.split(\'|\');\n\t\t\t\tif(convals_array.length > 0)\n\t\t\t\t{\n\t\t\t\t\tfor(i=0;i<convals_array.length;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar temp_conval = convals_array[i].split(\'|\');\n\t\t\t\t\t\tfor(j=0;j<temp_conval.length;j++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar temp_conval_code = temp_conval[j].split(\'~\');\n\t\t\t\t\t\t\tif(temp_conval_code[0] != del_code)\n\t\t\t\t\t\t\t\tdelconvals +=temp_conval[j]+\"|\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\t\n\t\t\tparent.AddAssociateCodeListFrame.location.href = \"../../eCA/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&convals=\" + delconvals;\n\t\t\t\n\t\t\tdocument.AddAssociateCodeAddModifyForm.convals.value =delconvals ;\n\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.value = \"\";\n\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_desc.value = \"\";\n\t\t\tdocument.AddAssociateCodeAddModifyForm.long_desc.value = \"\";\n\n\t\t}\n\t\telse if(val == \'CANCEL\')\n\t\t{\n\t\t\twindow.returnValue = document.AddAssociateCodeAddModifyForm.convals.value;\n\t\t\tparent.window.close();\n\t\t}\n\t\telse if(val == \'CLEAR\')\n\t\t{\n\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_code.value = \"\";\n\t\t\tdocument.AddAssociateCodeAddModifyForm.diag_desc.value = \"\";\n\t\t\tdocument.AddAssociateCodeAddModifyForm.long_desc.value = \"\";\n\t\t}\n\t\telse if(val == \'OK\')\n\t\t{\t\t\t\n\t\t\twindow.returnValue = document.AddAssociateCodeAddModifyForm.convals.value;\n\t\t\twindow.close();\n\t\t}\n\t\telse if(val == \'TEMP\')\n\t\t{\t\t\n\t\t\tdocument.AddAssociateCodeAddModifyForm.exclamation.disabled=true;\n\t\t\tif(document.AddAssociateCodeAddModifyForm.flag_to_add.value == \'Y\')\n\t\t\t\tdoSelect(\'A\');\n\t\t\telse\n\t\t\t\tdocument.AddAssociateCodeAddModifyForm.flag_to_add.value = \'Y\';\t\t\t\n\t\t}\n\t}\n\tfunction getDiagDescription(obj)\n\t{\n\t\tif(obj.value != \"\")\n\t\t{\n\t\t\tobj.value = obj.value.toUpperCase();\n\t\t\tvar diag_code = obj.value;\n\t\t\tvar HTMLVal = \"<html>\";\n\t\t\tHTMLVal += \"<head>\";\n\t\t\tHTMLVal += \"<body>\";\n\t\t\tHTMLVal += \"<form name=\'getDiagValForm\' action=\'../../eCA/jsp/AddAssociateCodeGetDiagVal.jsp\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'diag_code\' value =\'\" + escape(diag_code) + \"\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'p_scheme\' value =\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'Sex\' value =\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'Dob\' value =\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\";\n\t\t\tHTMLVal += \"<input type=\'hidden\' name=\'code_indicator\' value =\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\";\n\t\t\tHTMLVal += \"</form>\";\n\t\t\tHTMLVal += \"</body>\";\n\t\t\tHTMLVal += \"</head>\";\n\t\t\tHTMLVal += \"</html>\";\n\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tparent.messageFrame.document.getDiagValForm.submit();\n\t\t}\n\t}\n\tfunction showLongDescription()\n\t{\n\t\tvar dialogHeight= \"20\" ;\n\t\tvar dialogWidth = \"23\" ;\n\t\tvar a = document.AddAssociateCodeAddModifyForm.long_desc.value;\n\t\t\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\";\n\t\twindow.showModalDialog(\"../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc=\"+a,\"\",features);\n\t}\n\t//-->\n\t</SCRIPT>\n\t</HEAD>\n<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\'>\n\t\t<form name=\"AddAssociateCodeAddModifyForm\" id=\"AddAssociateCodeAddModifyForm\">\n\t\t\n\t<br>\t\t\t\t\n\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'80%\' align=\'center\'>\t\t\t\t\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\"  width=\'30%\'>\n\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"fields\" >\n\t\t\t\t\t\t<input type=\"text\" name = \"diag_code\" value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onblur = \"getDiagDescription(this)\" maxlength=\'5\' size=\'5\'>\n\t\t\t\t\t\t<input type=\"button\" name=\"question\" id=\"question\" value= \"?\" class=\"button\" onclick = \'SearchDiagCode()\'>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!-- <tr>\n\t\t\t\t\t<td colspan=2>\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t</tr>   -->\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" >\n\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;\n\t\t\t\t\t</td>\n                    ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t<input type=\"text\" name = \"diag_desc\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" readonly >\n\t\t\t\t\t\t<input type=\"button\" name=\"exclamation\" id=\"exclamation\" value= \"!\" class=\"button\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onclick=\"showLongDescription()\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<!-- <tr>\n\t\t\t\t\t<td width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t<td width=\'85%\'>&nbsp;</td>\n\t\t\t\t</tr> -->\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=right colspan=2>\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Select\" id=\"Select\" value=\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \' onClick=\"doSelect(\'TEMP\')\">&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Delete\" id=\"Delete\" value=\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \' onClick=\"return doSelect(\'DELETE\')\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">&nbsp;&nbsp;\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Ok\" id=\"Ok\" value=\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" \' onClick=\"doSelect(\'OK\')\">&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Clear\" id=\"Clear\" value=\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" \' onClick=\"doSelect(\'CLEAR\')\">&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"button\" class=BUTTON name=\"Cancel\" id=\"Cancel\" value=\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \' onClick=\"doSelect(\'CANCEL\')\">&nbsp;&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t<input type=\"hidden\" name=\"convals\" id=\"convals\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t<input type=\"hidden\" name=\"long_desc\" id=\"long_desc\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t<input type=\"hidden\" name=\"flag_to_add\" id=\"flag_to_add\" value=\"\">\n\t\t</form>\n\t</BODY>\n\t</HTML>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

try
{
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
	String curr_long_desc = "";
	String mode = (request.getParameter("mode")==null?"":request.getParameter("mode"));;
	String p_scheme = (request.getParameter("p_scheme")==null?"":request.getParameter("p_scheme"));;

	String associate_codes  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
	String param_diag_code  = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");
	if(!associate_codes.equals(""))
		convals = associate_codes;

	while(strToken.hasMoreTokens())
	{
		diag_code = java.net.URLEncoder.encode((String)strToken.nextToken());
		curr_diag_desc = java.net.URLEncoder.encode((String)strToken.nextToken());
        if(strToken.hasMoreTokens())
		curr_long_desc = java.net.URLEncoder.encode((String)strToken.nextToken());
	}

	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(title));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_diag_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_diag_scheme_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_auth_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_scheme));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(param_diag_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(title));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_diag_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_diag_scheme_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_auth_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_scheme));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(param_diag_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_scheme));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLDecoder.decode(diag_code)));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						String dis="disabled";
						if(mode.equals("modify"))
                        dis="";  
						
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(java.net.URLDecoder.decode(curr_diag_desc)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disable_delete));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(convals));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(curr_long_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
catch(Exception e)
{
	//out.println("Exception in AddAssociateCodeAddModify.jsp" + e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}

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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
