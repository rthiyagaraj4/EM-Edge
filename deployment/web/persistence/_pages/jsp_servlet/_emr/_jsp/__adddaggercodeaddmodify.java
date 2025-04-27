package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __adddaggercodeaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AddDaggerCodeAddModify.jsp", 1740625520048L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n \n<HTML>\n<HEAD>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<style>\n\t.container {\n\t\twidth:630px;\n\t}\n\n\t.container table {\n\t\twidth: 620px;\n\t\ttable-layout: fixed;\n\t}\n\n\t.inner_table { \n\t\twidth:100%; \n\t\theight: 170px;\n\t\toverflow-y: auto;\n\t}\n\n\t.inner_table_site { \n\t\twidth:100%; \n\t\theight: 100px;\n\t\toverflow-y: auto;\n\t}\n\t</style>\n</HEAD>\n\n<SCRIPT LANGUAGE=\"JavaScript\">\nfunction Checkdiagcode(obj)\n{\n\tvar convals = document.form1.convals.value;  \n\tif(obj.checked)\n\t{\n\t\tparent.frames[1].document.daggar_buttons.OK.disabled=false;\n\t\tif(convals != \"\")\n\t\t\tconvals += \"|\";\n\t\tvar obj_temp = obj.name.split(\"~\");\n\t\tconvals += obj_temp[0].replace(\'+\',\'%2B\') + \"~\" + obj_temp[1];\n\t\tdocument.form1.convals.value = convals;\n\t}\n\telse\n\t{\n\t\tvar diag_code = obj.name.split(\"~\");\n\t\tvar delconvals = \"\";\n\t\tvar del_code = unescape(diag_code[0]);\n\t\tvar convals1 = unescape(document.form1.convals.value);\n\t\tvar convals_array = convals1.split(\'|\');\t\t\n\t\tif(convals_array.length > 0)\n\t\t{\n\t\t\tfor(i=0;i<convals_array.length;i++)\n\t\t\t{\t\t\t\t\n\t\t\t\tvar temp_conval = convals_array[i].split(\'|\');\n\t\t\t\tfor(j=0;j<temp_conval.length;j++)\n\t\t\t\t{\n\t\t\t\t\tvar temp_conval_code = temp_conval[j].split(\'~\');\n\t\t\t\t\tif(temp_conval_code[0] != del_code)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(delconvals != \'\')\n\t\t\t\t\t\t\tdelconvals += \"|\";\n\t\t\t\t\t\tdelconvals += (temp_conval[j].replace(\'+\', \'%2B\'));\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tdocument.form1.convals.value = delconvals;\n\t\tif(document.form1.convals1.value !=\'\')\n\t\t{\n\t\t\tif(document.form1.convals.value ==\'\')\n\t\t\t{\n\t\t\t\talert(getMessage(\"MR_EX_SELECT_ONE_DIAG\",\'MR\'));\n\t\t\t\tparent.frames[1].document.daggar_buttons.OK.disabled=true;\n\t\t\t\t//obj.focus;\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t\tparent.frames[1].document.daggar_buttons.OK.disabled=false;\n\t\t}\n\t}\n}\n\nfunction formValidate(obj)\n{\n\tvar convals = document.form1.convals.value;  \n\tif(obj.checked)\n\t{\n\t\tif(convals != \"\")\n\t\t\tconvals += \"|\";\n\t\tvar obj_temp = obj.name.split(\"~\");\n\t\tconvals += obj_temp[0].replace(\'+\',\'%2B\') + \"~\" + obj_temp[1];\n\t\tdocument.form1.convals.value = convals;\n\t}\n\telse\n\t{\n\t\tvar diag_code = obj.name.split(\"~\");\n\t\tvar delconvals = \"\";\n\t\tvar del_code = unescape(diag_code[0]);\n\t\tvar convals1 = unescape(document.form1.convals.value);\n\t\tvar convals_array = convals1.split(\'|\');\t\t\n\t\tif(convals_array.length > 0)\n\t\t{\n\t\t\tfor(i=0;i<convals_array.length;i++)\n\t\t\t{\t\t\t\t\n\t\t\t\tvar temp_conval = convals_array[i].split(\'|\');\n\t\t\t\tfor(j=0;j<temp_conval.length;j++)\n\t\t\t\t{\n\t\t\t\t\tvar temp_conval_code = temp_conval[j].split(\'~\');\n\t\t\t\t\tif(temp_conval_code[0] != del_code)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(delconvals != \'\')\n\t\t\t\t\t\t\tdelconvals += \"|\";\n\t\t\t\t\t\tdelconvals += (temp_conval[j].replace(\'+\', \'%2B\'));\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tdocument.form1.convals.value = delconvals;\n\t\tif(document.form1.convals.value ==\'\')\n\t\t{\n\t\t\talert(getMessage(\"MR_EX_SELECT_ONE_DIAG\",\"MR\"));\n\t\t\tobj.focus;\n\t\t\treturn false;\n\t\t}\n\t}\n}\n\n//Added by sangeetha for ML-MMOH-CRF-0733  -- START\nfunction storeVal(currad){\n\t\tradioval = currad.value;\n\t}\n\nfunction CheckForSpecChars_event(event){\n\tif(event.keyCode!=\'13\'){\n\t\tvar strCheck = \'\"\';\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\tkey = String.fromCharCode(whichCode);  \n\t\tif (strCheck.indexOf(key) == -1) return true;  \n\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\t\treturn (event.keyCode -= 32);\n\t\treturn false ;\n\t}else{\n\t\treturn false;\n\t}\n}\n\nfunction CallDescFrame(){ \n    \n\tvar radioValue=\"\";\t\n\tif(document.form1.search_by[0].checked) radioValue=document.form1.search_by[0].value;\t\n\tif(document.form1.search_by[1].checked) radioValue=document.form1.search_by[1].value;\t\n\t\n\tvar HTMLVal = new String();  \n\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'formDummy\' action=\'../../eMR/jsp/AddDaggerCodeAddModify.jsp\'>\"+\n\t\t\t  \"<input type= \'hidden\' name= \'search_by\' value=\'\" +radioValue+\"\'>\"+\n\t\t\t  \"<input type= \'hidden\' name= \'Search_criteria\' value=\'\" + document.forms[0].Search_criteria.value +\"\'>\"+\n\t\t      \"<input type= \'hidden\' name= \'Search_text\' value=\'\" + document.forms[0].Search_text.value +\"\'>\"+\n\t\t\t  \"<input type= \'hidden\' name= \'associate_codes_modify\' value=\'\"+decodeURIComponent(document.forms[0].associate_codes_modify.value)+\"\'>\"+\n\t\t\t  \"<input type= \'hidden\' name= \'code_indicator\' value=\'\"+ document.forms[0].code_indicator.value +\"\'>\"+\n\t\t\t  \"<input type= \'hidden\' name= \'diag_code\' value=\'\"+ document.forms[0].diag_code.value +\"\'>\"+\n\t\t\t  \"<input type= \'hidden\' name= \'mode\' value=\'\" + document.forms[0].mode.value +\"\'>\"+\n\t\t\t  \"<input type= \'hidden\' name= \'associate_codes\' value=\'\"+ decodeURIComponent(document.forms[0].convals1.value)+\"\'>\"+\n\t\t\t  \"<input type= \'hidden\' name= \'convals1\' value=\'\"+ decodeURIComponent(document.forms[0].convals1.value)+\"\'>\"+\n\t\t\t  \"<input type= \'hidden\' name= \'code_set\' value=\'\" + document.forms[0].term_set_id.value +\"\'></form></BODY></HTML>\";\n\n\tdocument.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tdocument.formDummy.submit();\n\n}\n\nfunction CallReset()\n{\n\tdocument.form1.search_by[0].checked=true;\n\tdocument.form1.Search_criteria.options[1].selected=true;\n\tdocument.form1.Search_text.value=\"\";\n\tCallDescFrame();\n}\n//Added by sangeetha for ML-MMOH-CRF-0733  -- END\n\n/*Below line added for this CRF ML-MMOH-CRF-0792*/\nfunction onMMove(obj,e,diagTemp,code) {\n\t\tvar treat1=unescape(document.getElementById(\'supprtDiag\'+diagTemp).value);\n\t\tvar Totalcount=document.getElementById(\"Totalcount\").value;\n\t\tvar diagcode =code;\n\t\tif(treat=!\"\"){\n\t\tobj.style.left=e.x+10;\n\t\tif(parseInt(diagTemp)>5 && parseInt(diagTemp)!=parseInt(Totalcount)){\t\t\n\t\t  obj.style.top=e.y-30;\n\t\t}else if(parseInt(diagTemp)>5 && parseInt(diagTemp)==parseInt(Totalcount)){\t\t\n\t\t  obj.style.top=e.y-90;\n\t\t}else{\t\t\n\t\t  obj.style.top=e.y;\n\t\t}\t\t\n\t\tobj.style.borderColor=\'pink\';\n\t\tobj.style.borderWidth=\'thin\';\n\t\tobj.style.borderStyle=\'groove\';\n\t\tobj.style.width=560;\n\t\tobj.innerHTML=\"<table cellspacing=\'0\' cellpadding=\'0\' border=\'0\' height=100% width=\'100%\'><tr><td class=\'ordata\' valign=\'top\'>\"+diagcode+\"/\"+treat1+\"</td></tr></table>\";\n\t\t}\n\t\telse\n\t\t\treturn false;\n\t\t\t\n}\n\nfunction onMOut(obj){\n\n\t\tif(treat=!\"\"){\n\t\tobj.innerHTML=\'\';\n\t\tobj.style.width=0;\n\t\tobj.style.borderColor=\'\';\n\t\tobj.style.borderWidth=\'\';\n\t\tobj.style.borderStyle=\'\';\n\t\t}\n\t\telse\n\t\t\treturn false;\n}\n\n//End this CRF ML-MMOH-CRF-0792\n</SCRIPT>\n<BODY onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\"form1\" id=\"form1\">\n\t\n\t<!-- Below code added by Sangeetha for ML_MMOH-CRF-733 -->\n\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t&nbsp;&nbsp;&nbsp;\n\t\n\t<table align=center border=\"0\" width=100% cellspacing=\'0\' cellpadding=\'3\'>\n\n\t  <tr>\n\t\t<td colspan=\'2\' class=\"label\">\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<input type=\"radio\" name=\"search_by\" id=\"search_by\" class=\"label\" value=\"D\"  checked  onclick=\'storeVal(this)\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<input type=\"radio\" name=\"search_by\" id=\"search_by\" class=\"label\" value=\"C\" onclick=\'storeVal(this)\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</td>\n\t\t<td class=\"label\" colspan=\"1\" width = \'25%\'>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t</td>\n\t\t<td class =\'fields\' >\n\t\t<select name=\"Search_criteria\" id=\"Search_criteria\">\n\t\t<option value=\"C\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\n\t\t<option value=\"S\" selected>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t<option value=\"E\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t</select>\n\t\t</td>\n     </tr>\n\n\t<tr>\n\t\t<td class=\'label\' colspan=1  width = \'25%\' nowrap >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<input class = fields\' type=\"text\"  name=\"Search_text\" id=\"Search_text\" onkeypress=\"return CheckForSpecChars_event(event)\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' width=30% align=\"left\" size=\'20\' maxlength=\'20\' >\n\t\t\t\n\t\t</td>\n\t\t<td colspan = 2 width = \'25%\' align = \'right\'>\n\t\t\t<input type=\"button\" width=\'6%\' align=\"right\" name=\"Search\" id=\"Search\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onClick=\"CallDescFrame()\" class=\'button\' >\n\t\t</td>\n\t\t<td colspan = 2 width = \'25%\' align = \'left\'>\n\t\t\t<input type=\"button\" width=\'6%\' align=\"right\" name=\"Reset\" id=\"Reset\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \' onClick=\"CallReset()\" class=\'button\' >\n\t\t</td>\n   </tr> \n <!--Added by Sangeetha for ML-MMOH-CRF-0733 -->  \n<script>  \nif(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'!=null && document.form1.Search_text!=null){\n document.form1.Search_text.value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n }\nif(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"==\"D\" && document.form1.search_by!=null){ \ndocument.form1.search_by[0].checked=true;\ndocument.form1.search_by[0].value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"\n}\nif(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"==\"C\" && document.form1.search_by!=null){ \ndocument.form1.search_by[1].checked=true;\ndocument.form1.search_by[1].value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"\n}\n\nif(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'==\"C\" && document.form1.Search_criteria!=null){\ndocument.form1.Search_criteria.options[0].selected=true;\n}\n\nif(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'==\"S\" && document.form1.Search_criteria!=null){\ndocument.form1.Search_criteria.options[1].selected=true;\n}\nif(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'==\"E\" && document.form1.Search_criteria!=null){\ndocument.form1.Search_criteria.options[2].selected=true;\n}\n</script>\n</table>\n\n\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n     &nbsp;&nbsp;&nbsp;\n\t<!--<div class=\"container\">-->\n\t<table class=\"head\" width=\"100%\"  border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px #83aab4\">\n\t<tr>\n\t\t\t\t\n\t<td class=\"COLUMNHEADER\"width=\"15%\" >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t<td class=\"COLUMNHEADER\"width=\"75%\" >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t<td class=\"COLUMNHEADER\"width=\"10%\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t</tr>\n\t</table>\n\t\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<div class=\"inner_table_site\">\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<div class=\"inner_table\">\n\t    ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\n\t\t<table width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px solid #83aab4\">\n\t\t\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n\t\n\t<!--Below line added for this CRF ML-MMOH-CRF-0792-->  \n\t\t<tr>\n\t\t\t<td width=\"15%\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</a></td>\n\t\t\t<td width=\"75%\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t<td width=\"10%\"><input type=\"checkbox\" name=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" \" Onclick=\"Checkdiagcode(this)\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="><td>\n\t\t\t<input type=\"hidden\" name=\"supprtDiag";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"supprtDiag";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"> <!--Added for this CRF ML-MMOH-CRF-0792-->\t\t\t\n\t\t</tr>\n\t\t\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<input type=\"hidden\" name=\"Totalcount\" id=\"Totalcount\" id=\"Totalcount\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"> <!--Added for this CRF ML-MMOH-CRF-0792-->\n</table>\n</div>\n</div>\n\t\t<!--</div>\n\t\t</td>\n\t\t</tr> -->\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<input type=\"hidden\" name=\"convals\" id=\"convals\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></input>\n<input type=\"hidden\" name=\"convals1\" id=\"convals1\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"></input>\n\n<!-- Added by Sangeetha for ML-MMOH-CRF-0733 -->\n<input type= \"hidden\" name= \"associate_codes_modify\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type= \"hidden\" name= \"code_indicator\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type= \"hidden\" name= \"term_set_id\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type= \"hidden\" name= \"diag_code\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type= \"hidden\" name= \"mode\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" \n<!--Below line added for this CRF ML-MMOH-CRF-0792-->\n<div name=\'msg\' id=\'msg\' style=\"position:absolute;width: 0; height: 0; left: 100; top: 62\">\n</div>\n<!--End this CRF ML-MMOH-CRF-0792-->\n</form>\n\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

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
 request.setCharacterEncoding("UTF-8");
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	  String locale = checkForNull((String)session.getAttribute("LOCALE")); 
	  
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);



String convals  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
String associate_codes_modify  = request.getParameter("associate_codes_modify")==null?"":request.getParameter("associate_codes_modify");
String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
String term_set_id = request.getParameter("code_set")==null?"":request.getParameter("code_set");
String code_indicator1 ="";
String splitvalsDB ="";
String codeDB = "";
String codeDBdesc = "";
String searchTxt="";    //Added by Sangeetha for ML-MMOH-CRF-0733
ArrayList tempConvals			= new ArrayList();


if((code_indicator.equals("A")) || (code_indicator.equals("D")))
	code_indicator1="AS";
else if(code_indicator.equals("E") || (code_indicator.equals("C")))
	code_indicator1="EC";

Connection con = null;
PreparedStatement stmt = null;
ResultSet rs= null;
PreparedStatement stmt1 = null;
ResultSet rs1= null;
String diag_code=""; //Added for this CRF GDOH-CRF-0082
//Below line added for this CRF GDOH-CRF-0082
String mode="",old_diagcode="";

String searchby="",searchcriteria="",searchtext="";

try
{
	diag_code	= 	request.getParameter("diag_code"); //Modified for this CRF GDOH-CRF-0082
	
	//Below line added for this CRF GDOH-CRF-0082
	mode=request.getParameter("mode");	
	if(mode ==null || mode.equals("null") || mode.equals("")) mode="insert";	
	if(mode.equals("insert")){	
	  if((String )session.getAttribute("diagnosis_code")==null){
	       session.setAttribute("diagnosis_code",diag_code);
	   }else if((String )session.getAttribute("diagnosis_code")!=null){
	      old_diagcode=(String )session.getAttribute("diagnosis_code");		 
		  if(!old_diagcode.equals(diag_code)){
		  convals="";		  
		  session.setAttribute("diagnosis_code",diag_code);
		  		  
		  }
	   }	 	   
	 } 
	// End this CRF GDOH-CRF-0082
	
	con  = ConnectionManager.getConnection(request);

    //Added by Sangeetha for ML-MMOH-CRF-0733
	boolean SearchCritSiteSpecific	=  eCommon.Common.CommonBean.isSiteSpecific(con, "MR","SUPPORT_DIAG_SEARCH_CRITERIA");
	
	//Below line added for this CRF ML-MMOH-CRF-0792
	boolean support_diagnosis	=  eCommon.Common.CommonBean.isSiteSpecific(con, "MR","SUPPORTING_DIAGNOSIS");
	
	
	StringBuffer WhereCodn	=   new StringBuffer();
	 searchby			=	request.getParameter("search_by"); 
	 searchcriteria	=	request.getParameter("Search_criteria"); 
	 searchtext		=	request.getParameter("Search_text");  
	 if(searchtext==null || searchtext.equals("null")) searchtext="";
		
			if(!(searchby == null)) {
				if(searchby.equals("D")){ 
					WhereCodn.append(" and upper(bb.SHORT_DESC) like upper(?)");	
				}else{
					WhereCodn.append(" and upper(aa.EQUIVALENT_TERM_CODE) like upper(?)");
				}
			}
			
		
	StringTokenizer strDB = new StringTokenizer(associate_codes_modify, "|");
		if(!associate_codes_modify.equals(""))
		{
			
			while(strDB.hasMoreTokens())
			{
				splitvalsDB = strDB.nextToken();
				StringTokenizer str2DB = new StringTokenizer(splitvalsDB,"~");
				while(str2DB.hasMoreTokens())
				{
					codeDB = str2DB.nextToken();
					codeDBdesc = str2DB.nextToken();
					codeDBdesc = codeDBdesc.replace(' ','+');
					tempConvals.add(codeDB);
				}
			}
		}

	//String query = "select a.DAG_DIAG_CODE, a.ASTK_DIAG_CODE, b.SHORT_DESC  from  mr_icd_code_dtl a, mr_icd_code b where a.ASTK_DIAG_CODE = b.DIAG_CODE and a.DAG_DIAG_CODE = ?  and b.DIAG_CODE_SCHEME = (select diag_code_scheme from mr_parameter)";

	//Commented By Sangeetha
	//String query = "SELECT TERM_CODE,EQUIVALENT_TERM_CODE FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_CODE=? AND CROSS_REF_TYPE='"+code_indicator1+"' and term_set_id = '"+term_set_id+"'";

	//Added by Sangeetha for ML-MMOH-CRF-0733
	String query = "SELECT aa.term_code, aa.equivalent_term_code, bb.short_desc, bb.long_desc FROM mr_equivalent_term_code aa, MR_D_"+term_set_id+"_LANG_VW bb WHERE aa.term_code = ? AND aa.term_set_id = '"+term_set_id+"' AND aa.equivalent_term_code = bb.term_code AND bb.language_id = ? and  aa.CROSS_REF_TYPE = '"+code_indicator1+"' ";
	
	String order_by = " order by aa.equivalent_term_code asc "; 	
	//Above query modified for this CRF ML-MMOH-CRF-0792
	
		if(SearchCritSiteSpecific){
				stmt = con.prepareStatement(query + WhereCodn.toString() + order_by);
		}else{
				stmt = con.prepareStatement(query + order_by);
		}
	
	stmt.setString(1, diag_code);
	stmt.setString(2, locale);

	if(!(searchcriteria == null)) {
		if(searchcriteria.equals("S")) {  
			stmt.setString(3,searchtext+"%");		
		} else if(searchcriteria.equals("E")) {
			stmt.setString(3,"%"+searchtext);		
		} else if(searchcriteria.equals("C")) {
			stmt.setString(3,"%"+searchtext+"%");		
		}
	}

	rs = stmt.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);
 if(SearchCritSiteSpecific){ 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(searchTxt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(searchtext));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(searchtext));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(searchby));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(searchby));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(searchby));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(searchby));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(searchcriteria));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(searchcriteria));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(searchcriteria));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(SearchCritSiteSpecific){ 
            _bw.write(_wl_block34Bytes, _wl_block34);
 } else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
	
	String classval ="";
	String short_desc ="";
	int i= 0;
	int flag = 0;
	
	//Added for this CRF ML-MMOH-CRF-0792
	String suportlong_desc=""; 
	int temp=0;
   //End this CRF ML-MMOH-CRF-0792

	while(rs.next())
	{
		flag = 1;
		String astk_diag_code = rs.getString("EQUIVALENT_TERM_CODE");
		//String short_desc = rs.getString("SHORT_DESC");
		String checked = "";
		String disVal = "";

//		String sql="SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_CODE =? AND TERM_SET_ID=?";
		
		//Commented by Sangeetha for ML-MMOH-CRF-0733
		/*String sql="SELECT SHORT_DESC FROM MR_D_"+term_set_id+"_LANG_VW WHERE TERM_CODE =? AND TERM_SET_ID=? AND LANGUAGE_ID=?";
		
		stmt1 = con.prepareStatement(sql);

		stmt1.setString(1, astk_diag_code);
		stmt1.setString(2, term_set_id);
		stmt1.setString(3, locale);
		rs1 = stmt1.executeQuery();
		while(rs1.next())
		{
			short_desc = rs1.getString("SHORT_DESC");
		}

		if(rs1!= null) rs1.close();
		if(stmt1 != null) stmt1.close();*/



		//Added by Sangeetha for ML-MMOH-CRF-0733
		short_desc = rs.getString("SHORT_DESC");
		
		//Below line added for this CRF ML-MMOH-CRF-0792
		suportlong_desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");

		if(i%2 == 0)
				classval = "QRYODD";
			else
				classval = "QRYEVEN";
		StringTokenizer str1 = new StringTokenizer(convals, "|");
		if(!convals.equals(""))
		{
			String code = "";
			String codeDesc = "";
			while(str1.hasMoreTokens())
			{
				String splitvals = str1.nextToken();
				StringTokenizer str2 = new StringTokenizer(splitvals,"~");
				while(str2.hasMoreTokens())
				{
					code = str2.nextToken();
					codeDesc = str2.nextToken();
					codeDesc = codeDesc.replace(' ','+');
					if(code.equals(astk_diag_code))
					{
						checked = "Checked";
					}
					if(tempConvals.contains(astk_diag_code))
					{
						disVal	= "disabled";
					}else
					{
						disVal	= "";
					}
				}
			}
		}
		
            _bw.write(_wl_block37Bytes, _wl_block37);
if(support_diagnosis){out.println("<a onMouseover='javascript:onMMove(msg,event,\""+i+"\",\""+java.net.URLEncoder.encode(astk_diag_code)+"\");'  onMouseout='javascript:onMOut(msg);'>"); out.println(astk_diag_code);
}else{ out.println(astk_diag_code);
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(astk_diag_code+"~"+short_desc.replaceAll("\'","")	));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disVal));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(suportlong_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);

		temp=i; //added for this CRF ML-MMOH-CRF-0792
		i++;
	}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block47Bytes, _wl_block47);
if(rs != null) rs.close();
	if(stmt != null) stmt.close();

	if(flag == 0)
	{
		//Added by Sangeetha for ML-MMOH-CRF-0733
		if(SearchCritSiteSpecific){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}else{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
			out.println("window.close();</script>");   
		}
	}
	
}
catch(Exception e)
{
	//out.println("Exception in AddDaggerCodeAddModify.jsp " + e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)convals)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)convals)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(associate_codes_modify));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block55Bytes, _wl_block55);

//Added below line for GDOH-CRF-0082
if(mode.equals("insert")){	
	if(!old_diagcode.equals(diag_code)){ 
	    out.println("<script>document.form1.convals.value='';</script>");
	    out.println("<script>document.form1.convals1.value='';</script>");
	} 
}	
//End GDOH-CRF-0082


            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchby.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SearchCriteria.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contains.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startsWith.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.endsWith.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchtext.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }
}
