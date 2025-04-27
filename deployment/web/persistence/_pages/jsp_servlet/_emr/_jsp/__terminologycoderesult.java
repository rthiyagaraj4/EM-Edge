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
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __terminologycoderesult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TerminologyCodeResult.jsp", 1743501782325L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></link>\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script language=\"JavaScript\" src=\"../../eMR/js/TerminologyCode.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script>\nfunction submitPrevNext(from, to)\n{\n\t\tdocument.term_code_result.from.value\t= from;\n\t    document.term_code_result.to.value\t\t= to; \n\t    var termcode\t\t= document.term_code_result.termcode.value; \n\t    var termcode1\t\t= document.term_code_result.termcode1.value; \n\t    var termsetid\t\t= document.term_code_result.termsetid.value; \n\t    codelevel\t\t\t= document.term_code_result.codelevel.value; \n\t    var search_text\t\t= document.term_code_result.search_text.value; \n\t\tvar search_criteria = document.term_code_result.search_criteria.value;\n\t\tvar search_flag\t\t= document.term_code_result.search_flag.value;\n\t\tvar last_reloded_from\t= document.term_code_result.last_reloded_from.value;\n\t\tvar termdescription\t=document.term_code_result.termdescription.value;\n\t\tvar alphalink\t\t= \"\";\n\t\t/*if(search_flag!=\'C\'){\n\t\t\talphalink=parent.frames[2].document.getElementById(\"alphalink\").value;\n\t\t}*/\n\t\t/*\n\t\t\tThe Above code was commented on 10/26/2010 for the issue IN024671  Issue 1\n\t\t\tThe following code was modified.\n\t\t*/\n\t\t if( last_reloded_from==\"L\"){\n\t\t\t\talphalink\t= parent.frames[2].document.getElementById(\"alphalink\").value;\n\t\t}else{\n\t\t\t\talphalink\t= \'\';\n\t\t}\n\t\tparent.f_term_code_result.location.href=\"../../eMR/jsp/TerminologyCodeResult.jsp?termdesc=\"+alphalink+\"&termcode=\"+termcode1+\"&termsetid=\"+termsetid+\"&codelevel=\"+codelevel+\"&from=\"+from+\"&to=\"+to+\"&search_text=\"+search_text+\"&search_flag=\"+search_flag+\"&search_criteria=\"+search_criteria+\"&diag_spec_yn=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&proc_spec_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&last_reloded_from=\"+last_reloded_from+\"\";\n\n}\n\nfunction call(termcode,termdesc)\n{\n\tvar termsetid\t\t\t= document.term_code_result.termsetid.value; \n\tvar className\t\t\t= \"\";\n\tdocument.term_code_result.className.value\t= \"\";\n\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.class_lvl.value\t= parent.f_term_result_header.document.term_code_result_header.class_lvl.value;\n\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.className.value\t= \"\";\n\tparent.f_term_result_header.document.term_code_result_header.className.value\t\t\t= \"\";\n\tparent.f_term_add_modify.document.term_code_addmodify.mode.value\t\t\t\t\t\t= \"\";\n\tvar codelvl\t\t\t\t= eval(document.term_code_result.codelevel.value); \n\tcdlvl\t\t\t\t\t= eval(parent.f_term_code_set.document.forms[0].dyanmic_level.value)+1;\n\tcodelevel\t\t\t\t= codelvl + 1;\n\n\tif(cdlvl!=codelevel)\n\t{\n\t\tif(codelevel==2)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode2.value = termcode;\n\t\t}\n\t\telse if(codelevel==3)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode3.value = termcode;\n\t\t}\n\t\telse if(codelevel==4)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode4.value = termcode;\n\t\t}\n\t\telse if(codelevel==5)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode5.value = termcode;\n\t\t}\n\t\telse if(codelevel==6)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode6.value = termcode;\n\t\t}\n\t\telse if(codelevel==7)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode7.value = termcode;\n\t\t}\n\t\telse if(codelevel==8)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode8.value = termcode;\n\t\t}\n\t\telse if(codelevel==9)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode9.value = termcode;\n\t\t}\n\t\telse if(codelevel==10)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode10.value = termcode;\n\t\t}\n\t\tparent.f_term_add_modify.document.term_code_addmodify.term_code.value\t\t= \"\";\n\t\tparent.f_term_add_modify.document.term_code_addmodify.term_code.readOnly\t= false;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.short_desc.value\t\t= \"\";\n\t\tparent.f_term_add_modify.document.term_code_addmodify.long_desc.value\t\t= \"\";\n\t\tparent.f_term_add_modify.document.term_code_addmodify.eff_status.checked\t= true;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.selectable.checked\t= false;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.selectable.disabled\t= false;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.proc_diag.value\t\t= \"\";\n\t\tparent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.termsetid.value\t\t= termsetid;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.codelevel.value\t\t= codelevel;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.termcode.value\t\t= termcode;\n\t\t// This part dynamic rows are generated for final frame selected value based on click of result page.\n \t\tvar rowvar\t\t= parent.f_term_selected_frms.f_term_selected_values.document.getElementById(\"tableId\").insertRow();\n\t\tvar cellvar\t\t= rowvar.insertCell();\n\t\ttermdesc\t\t=  unescape(termdesc);\n\t\tfor(var i= 0 ; i < termdesc.length;i++){\n\t\t\ttermdesc = \ttermdesc.replace(\'|\',\' \');\n\t\t}\n\t\t/*\n\t\t\tModified On 10/26/2010 for the issue IN024671 Issue 2\n\t\t*/\n\t\twhile(termdesc.indexOf(\"$\")!=-1){\n\t\t\ttermdesc\t= termdesc.replace(\'$\' ,\"\'\");\n\t\t}\n\t\tcellvar.insertAdjacentHTML(\"beforeend\",termdesc);\n\t\tif(codelevel%2==0)\n\t\t{\n\t\t\tcellvar.className = \'QRYEVEN\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcellvar.className = \'QRYODD\';\n\t\t}\n\t\t// End of dynamic rows creation.\n\t\tif(codelevel==(cdlvl-1))\n\t\t{\n\t\t\tclassName\t\t  = \"className\";\n\t\t\tdocument.term_code_result.className.value = \"className\";\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.className.value = \"className\";\n\t\t\tparent.f_term_result_header.document.term_code_result_header.className.value = \"className\";\n\t\t}\n\t\tparent.f_term_code_result.location.href=\"../../eMR/jsp/TerminologyCodeResult.jsp?termcode=\"+termcode+\"&termsetid=\"+termsetid+\"&codelevel=\"+codelevel+\"&className=\"+className+\"&diag_spec_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&last_reloded_from=DES\";\n\t\tvar htmlvalue = \"<html><body onKeyDown=\'lockKey()\'><form name=\'dynamic_value\' id=\'dynamic_value\' method=\'post\' action=\'../../eMR/jsp/TerminologyCodeDynamicValues.jsp\'><input type=\'hidden\' name=\'termsetid\' id=\'termsetid\' value=\'\"+termsetid+\"\'><input type=\'hidden\' name=\'codelevel\' id=\'codelevel\' value=\'\"+codelevel+\"\'><input type=\'hidden\' name=\'termcode\' id=\'termcode\' value=\'\"+termcode+\"\'></form></body></html>\"\n\t\tparent.blankFrame.document.write(htmlvalue);\n\t\tparent.blankFrame.document.dynamic_value.submit();\n\t}\n\telse\n\t{\n\t\t\n\t\t// This part dynamic rows are generated for final frame seleted value based on click of result page last level.\n\t\tif(document.forms[0].last_level.value==\"\")\n\t\t{\n\t\t\tvar rowvar = parent.f_term_selected_frms.f_term_selected_values.document.getElementById(\"tableId\").insertRow();\n\t\t\tvar cellvar = rowvar.insertCell();\n\t\t\ttermdesc    =  unescape(termdesc);\n\t\t\t\n\t\t\tfor(var i= 0 ; i < termdesc.length;i++)\n\t\t\t{\n\t\t\t\ttermdesc = \ttermdesc.replace(\'|\',\' \');\n\t\t\t}\t\t\n\t\t\t/*Wednesday, February 23, 2011 , SRR20056-SCF-6970 [IN:026635] issue 2 */\n\t\t\twhile(termdesc.indexOf(\"$\")!=-1){\n\t\t\t\ttermdesc=termdesc.replace(\'$\' ,\"\'\");\n\t\t\t}\n\t\t\t/**/\n\t\t\tcellvar.insertAdjacentHTML(\"beforeend\",termdesc);\n\t\t\tif(codelevel%2==0)\n\t\t\t{\n\t\t\t\tcellvar.className=\'QRYEVEN\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tcellvar.className=\'QRYODD\';\n\t\t\t}\n\t\t\tdocument.forms[0].last_level.value = \"lastlevel\";\n\t\t}\n\t\t// End of dynamic rows creation at last level.\n\t\n\t}\n\n\t \n\tparent.messageFrame.document.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n}\t\nfunction addmod(mode,termcode)\n{\n\tvar termsetid = document.term_code_result.termsetid.value; \n\tvar codelevel = document.term_code_result.codelevel.value; \n\tif(document.term_code_result.className.value == \"className\")\n\t\tclassName = \"className\";\n\telse\n\t\tclassName = \"\";\n\t\n\tparent.f_term_add_modify.location.href=\"../../eMR/jsp/TerminologyCodeAddModify.jsp?termcode=\"+termcode+\"&mode=\"+mode+\"&termsetid=\"+termsetid+\"&codelevel=\"+codelevel+\"&className=\"+className+\"\";\n\tparent.messageFrame.document.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n}\n\n</script>\n</head>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'> \n<FORM METHOD=\'POST\' name=\'term_code_result\' id=\'term_code_result\'>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<table width=\'95%\'>\n\t\t\t<tr>\n\t\t\t<table align=\'right\'>\n\t\t\t<tr>\n<!--<td align=\'right\'  id=\'prevNext\'  class=\'BODYCOLORFILLED\'>-->\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</tr>\n\t\t\t</table >\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<br>\n\t\t\t<br>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'95%\' >\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<tr>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\"></td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'75%\'><a href=\'javascript:call(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\")\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a></td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' width=\'5%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'7%\'> <a href=\'javascript:addmod(\"Modify\",\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a></td>\n\t\t\t\t\t</tr>\n\t\t\t\t  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\n\t</table>\n<INPUT TYPE=\"hidden\" name=\"termsetid\" id=\"termsetid\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode\" id=\"termcode\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode1\" id=\"termcode1\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<INPUT TYPE=\"hidden\" name=\"codelevel\" id=\"codelevel\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<INPUT type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<INPUT type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<INPUT type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<INPUT type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<INPUT TYPE=\"hidden\" name=\"desc\" id=\"desc\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\'className\' id=\'className\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\t\n<INPUT TYPE=\"hidden\" name=\'last_level\' id=\'last_level\' value=\'\'>\n<INPUT TYPE=\"hidden\" name=\'search_text\' id=\'search_text\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<INPUT TYPE=\"hidden\" name=\'search_criteria\' id=\'search_criteria\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<INPUT TYPE=\"hidden\" name=\'search_flag\' id=\'search_flag\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<INPUT TYPE=\"hidden\" name=\'last_reloded_from\' id=\'last_reloded_from\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<INPUT TYPE=\"hidden\" name=\'termdescription\' id=\'termdescription\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); 
Connection con			= null;
Statement stmt			= null;
PreparedStatement psmt=null;
ResultSet rset			= null ;
ResultSet rset1			= null ;
String cd_lvl			= request.getParameter("codelevel");
if(cd_lvl==null || cd_lvl.equals("")) cd_lvl="1";
int code_level			= Integer.parseInt(cd_lvl);
String className		= request.getParameter("className");
if(className==null) className = "";
String classValue		= "";
String termsetid		= request.getParameter("termsetid");
String diag_spec_yn		= request.getParameter("diag_spec_yn");
String proc_spec_yn		= request.getParameter("proc_spec_yn");
String termdescription	= request.getParameter("termdesc");
String search_criteria	= request.getParameter("search_criteria");
String search_text		= request.getParameter("search_text");
String termcode			= request.getParameter("termcode");
String termcode1		= request.getParameter("termcode");
String search_flag		= request.getParameter("search_flag");
String last_reloded_from	= checkForNull(request.getParameter("last_reloded_from"));
String termdescription_new	= "";

String whereclause		= "";
//String cntSql = "";
String sqltermcoderesult	= "";
String desc				= "";
String defnlevelSql		= "";
String from				= request.getParameter("from") ;
String to				= request.getParameter("to") ;
//String classificationDescriptionLink = "";


if(termcode==null) termcode = "";
if(termcode1==null) termcode1 = "";
if(termsetid==null) termsetid = "";
if(code_level==1)
	termcode			= "";
if((termdescription==null)||(termdescription.equals("All"))) termdescription="";
termdescription_new=termdescription;
if(search_criteria==null) search_criteria="";
if(search_text==null) search_text="";
if(search_flag==null) search_flag="";


try
	{
		con				= ConnectionManager.getConnection(request);
		from			= request.getParameter("from") ;
		to				= request.getParameter("to") ;

		if(search_flag.equals("C"))
		{
			//search_criteria="C"; commented by S.Sathish for IN021712 on Tuesday, June 01, 2010
			termdescription = "";
		}

		if(!search_text.equals(""))
		{
			
			termdescription = search_text;
		}
		if(search_criteria.equals("S") && termdescription_new !="")
		{
			if(termdescription_new.equals("OT")){
				 whereclause = "upper(short_desc) like '"+termdescription + "%' and (UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
			}
			else{

		    whereclause = "upper(short_desc) like '"+termdescription + "%' AND upper(short_desc) like '"+termdescription_new+"%'";	
			}
		}
		else if(search_criteria.equals("E") && termdescription_new !="")
		{

			if(termdescription_new.equals("OT")){
				 whereclause ="upper(short_desc) like '%" + termdescription +"' and (UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
			}
			else{
			whereclause = "upper(short_desc) like '%" + termdescription +"' AND upper(short_desc) like '"+termdescription_new+"%'";
			}
		}
		else if(search_criteria.equals("C") && termdescription_new !="")
		{

			if(termdescription_new.equals("OT")){
				 whereclause ="upper(short_desc) like '%"+ termdescription + "%' and (UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
			}
			else{
			whereclause = "upper(short_desc) like '%"+ termdescription + "%' AND upper(short_desc) like '"+termdescription_new+"%'";
			}
		}         
		else if(search_criteria.equals("S"))
		{
			whereclause = "upper(short_desc) like '"+termdescription + "%'";
		}
		else if(search_criteria.equals("E"))
		{
			whereclause =  "upper(short_desc) like '%" + termdescription +"'";
		}
		else if(search_criteria.equals("C"))
		{
			whereclause = "upper(short_desc) like '%"+ termdescription + "%'";
		}
		else
		{
			whereclause = "upper(short_desc) like '"+termdescription + "%'";
		}
		if(termdescription.equals("OT"))
		{
			
			whereclause = "(UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
		}
		
		int maxRecord	= 0;
		int start		= 0 ;
		int end			= 0 ;
		int i			= 1;
		if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
		if (to == null){ end = 11 ; }   else {  end = Integer.parseInt( to ) ; }
		i				= 1;
		/*if(termcode.equals(""))
		{
			cntSql= "select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"order by short_desc";
		}
		else
		{
			cntSql= "select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and code_level="+code_level+" order by short_desc";
		}
		stmt=con.createStatement();
		rset1 = stmt.executeQuery(cntSql);
		if(rset1!=null)
		{
			if(rset1.next())
			{
				maxRecord = rset1.getInt(1);
			}
			if(rset1!=null) rset1.close();
			if(stmt!=null) stmt.close();
		}*/

		if(code_level==1)
		{
			defnlevelSql	= "select level_1_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==2)
		{
			defnlevelSql	= "select level_2_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==3)
		{
			defnlevelSql	= "select level_3_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==4)
		{
			defnlevelSql	= "select level_4_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==5)
		{
			defnlevelSql	= "select level_5_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==6)
		{
			defnlevelSql	= "select level_6_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==7)
		{
			defnlevelSql	= "select level_7_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==8)
		{
			defnlevelSql	= "select level_8_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==9)
		{
			defnlevelSql	= "select level_9_desc from mr_term_set where term_set_id=?";
		}
		else if(code_level==10)
		{
			defnlevelSql	= "select level_10_desc from mr_term_set where term_set_id=?";
		}
		//stmt				= con.createStatement();
		psmt = con.prepareStatement(defnlevelSql);
		psmt.setString(1,termsetid);
		rset1				= psmt.executeQuery();

		
		if(rset1!=null)
		{
			if(rset1.next())
			{
				desc = rset1.getString(1);
				if(rset1!=null) rset1.close();
				if(psmt!=null) psmt.close();
			}
		}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(diag_spec_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(proc_spec_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(diag_spec_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(proc_spec_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
	if (maxRecord==0)
		{
            _bw.write(_wl_block14Bytes, _wl_block14);

			if ( !(start <= 1))
			{
				//out.println("<td align ='right' id='prev'  class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-11)+","+(end-11)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
				/*Tuesday, February 22, 2011 , modified for SRR20056-SCF-6970 [IN:026635] issue 1*/
				out.println("<td align ='right' id='prev'  class='BODYCOLORFILLED'><a href='../../eMR/jsp/TerminologyCodeResult.jsp?termdesc="+termdescription+"&termcode="+termcode1+"&termsetid="+termsetid+"&codelevel="+code_level+"&from="+(start-11)+"&to="+(end-11)+"&search_text="+search_text+"&search_flag="+search_flag+"&search_criteria="+search_criteria+"&diag_spec_yn="+diag_spec_yn+"&proc_spec_yn="+proc_spec_yn+"&last_reloded_from="+last_reloded_from+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
			}
			//if ( !((start+11) > maxRecord ))
			//{

				//out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+11)+","+(end+11)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
				/*Tuesday, February 22, 2011 , modified for SRR20056-SCF-6970 [IN:026635] issue 1*/
				out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='../../eMR/jsp/TerminologyCodeResult.jsp?termdesc="+termdescription+"&termcode="+termcode1+"&termsetid="+termsetid+"&codelevel="+code_level+"&from="+(start+11)+"&to="+(end+11)+"&search_text="+search_text+"&search_flag="+search_flag+"&search_criteria="+search_criteria+"&diag_spec_yn="+diag_spec_yn+"&proc_spec_yn="+proc_spec_yn+"&last_reloded_from="+last_reloded_from+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
			//}

            _bw.write(_wl_block15Bytes, _wl_block15);

		}		
	
            _bw.write(_wl_block16Bytes, _wl_block16);

	
			if(termcode.equals(""))
			{
				sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and (diagnosis_yn='"+diag_spec_yn+"' or procedure_yn='"+proc_spec_yn+"' ) order by short_desc";
			}
			else
			{
				//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and code_level="+code_level+" order by short_desc";

				sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and part_term_code ='"+termcode+"' and code_level="+code_level+" and (diagnosis_yn='"+diag_spec_yn+"' or procedure_yn='"+proc_spec_yn+"' ) order by short_desc";
			}
			stmt = con.createStatement();
			rset=null;
			rset=stmt.executeQuery(sqltermcoderesult);
			String tempString  = "";
			String classValmod = "";
			
		       if ( start != 0 )
				{
					for( int j=1; j<start; i++,j++ )
					{
						rset.next() ;
					}
				}
			

				boolean isRecordFound = false;
				//while(rset.next() && i<=end )
				while( i<=end  && rset.next())
				{
                   	if(!isRecordFound)
					{
						isRecordFound = true;
                      
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
/*				if(className.equals(""))
			{
				if((i%2) == 1)
				{
					classValue = "QRYODD";
					classValmod = "QRYODD";
				}
				else
				{
					classValue ="QRYEVEN";
					classValmod = "QRYEVEN";
				}
			}
			else
*/
					if((i%2) == 1)
					{
						classValue = "QRYODD";
						classValmod = "QRYODD";
					}
					else
					{
						classValue ="QRYEVEN";
						classValmod = "QRYEVEN";
					}
					out.println("<tr>");
					tempString=rset.getString("short_desc");
					tempString = tempString.replace(' ','|');
					tempString = tempString;
					tempString =tempString.replace("'", "$");//	Modified On 10/26/2010 for the issue IN024671 Issue 2
					termcode   = rset.getString("term_code");
					String status = rset.getString("eff_status");
					if(status.equals("E"))
						status = "&nbsp;";
					else if(status.equals("D"))
						status = "D";

					//classificationDescriptionLink = "call('"+termcode+"','"+tempString+"')";

					//out.println("<td class='"+classValue+"' width='75%' onclick="+classificationDescriptionLink+"; >"+rset.getString("short_desc")+"</td>");



					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(termcode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tempString));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rset.getString("short_desc")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(status));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(termcode));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
			
					i++;
					maxRecord++;
				}
				
				if ( maxRecord < 11 || (!rset.next()) )
					{
						
            _bw.write(_wl_block29Bytes, _wl_block29);
 
					}
					else
					{
            _bw.write(_wl_block30Bytes, _wl_block30);

					}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
           
	if(isRecordFound==false)
		{
		     out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			 //out.println("<script>parent.frames[2].document.forms[0].search_text.value='';</script>");
			 out.println("<script>parent.frames[4].frames[1].document.location.reload();</script>");
		}
	

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(termcode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(termcode1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(code_level));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(start));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(end));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(start));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(end));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(className));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(search_text));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(search_flag));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(last_reloded_from));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(termdescription));
            _bw.write(_wl_block45Bytes, _wl_block45);
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Modify.label", java.lang.String .class,"key"));
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
