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
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __equivalenttermcoderesult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/EquivalentTermCodeResult.jsp", 1722863666069L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block9 ="\"></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\" src=\"../../eMR/js/EquivalentTermCode.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script>\nfunction submitPrevNext(from, to,obj)\n{       \n\n\t\tvar alphalink=document.term_code_result.alphalink.value;\n\t    document.term_code_result.from.value = from;\n\t    document.term_code_result.to.value = to; \n\t    var termcode = document.term_code_result.termsetid.value;\n\t\tvar termdescription = document.term_code_result.termdesc.value;\n\t    var termsetid = document.term_code_result.termsetid.value; \n\t\tvar search_criteria = document.term_code_result.search_criteria.value;\n\t    codelevel = document.term_code_result.codelevel.value;\n\t\tvar FirstConbox = document.term_code_result.FirstConbox.value;\n\t\tvar SecondValue = document.term_code_result.SecondValue.value;\n\t\tvar ThirdConbox = document.term_code_result.ThirdConbox.value;\n\t\tvar type_set    = document.term_code_result.type_set.value;\n\t\t\n\t\n\t\tif(document.term_code_result.mr_term_set.value==\'N\')\n\t    {\n\t\t\tparent.parent.messageFrame.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\";\n\t\t\t//if(confirm(\'Do you want to submit the current page\'))\n\t\t\tif(confirm(getMessage(\'SUBMIT_CURR_PAGE\',\'MR\')))\n\t\t\t{\t\t\t\t\t\n\t\t\t\tparent.f_batch_result.document.term_code_result.action = \"../../servlet/eMR.EquivalentTermCodeServlet?msg=n&obj=\"+obj+\"&type_set=\"+type_set;\n\t\t\t\tparent.f_batch_result.document.term_code_result.target = \"messageFrame\";\n\t\t\t\tparent.f_batch_result.document.term_code_result.submit();\n\t\t\t\t\n\t\t\t}\t\n\t\t\tvar search_text=parent.f_query_criteria.document.forms[0].search_text.value;\n\t\t     \tparent.f_batch_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?search_text=\"+search_text+\"&termcode=\"+termcode+\"&termsetid=\"+termsetid+\"&termdesc=\"+termdescription+\"&codelevel=\"+codelevel+\"&search_criteria=\"+search_criteria+\"&from=\"+from+\"&to=\"+to+\"&Terminology=\"+FirstConbox+\"&termset_id=\"+SecondValue+\"&ThirdConbox=\"+ThirdConbox+\"&alphalink=\"+alphalink+\"&type_set=\"+type_set+\"&mr_term_set=N\";\n\t\t\t\n\t\t} \n\t\telse\n\t\t{  \n\t\t\t parent.messageFrame.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\";   \n\t\t\tparent.f_term_code_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?termcode=\"+termcode+\"&termsetid=\"+termsetid+\"&termdesc=\"+termdescription+\"&codelevel=\"+codelevel+\"&search_criteria=\"+search_criteria+\"&alphalink=\"+alphalink+\"&from=\"+from+\"&to=\"+to+\"&type_set=\"+type_set;\n\t\t\tparent.f_term_selected_frms.document.location.href = \"../../eCommon/html/blank.html\";\n\t\t\t\n\t\t}\n\n\n}\n\nfunction call(termcode,termdesc)\n{\n\tvar termsetid = document.term_code_result.termsetid.value; \n\tvar className = \"\";\n\tdocument.term_code_result.className.value = \"\";\n\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.class_lvl.value = parent.f_term_result_header.document.term_code_result_header.class_lvl.value;\n\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.className.value = \"\";\n\tparent.f_term_result_header.document.term_code_result_header.className.value = \"\";\n\tparent.f_term_add_modify.document.term_code_addmodify.mode.value=\"\";\n\tvar codelvl = eval(document.term_code_result.codelevel.value); \n\tcdlvl = eval(parent.f_term_code_set.document.forms[0].dyanmic_level.value)+1;\n\tcodelevel = codelvl + 1;\n\tif(cdlvl!=codelevel)\n\t{\n\t\tif(codelevel==2)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode2.value=termcode;\n\t\t}\n\t\telse if(codelevel==3)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode3.value=termcode;\n\t\t}\n\t\telse if(codelevel==4)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode4.value=termcode;\n\t\t}\n\t\telse if(codelevel==5)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode5.value=termcode;\n\t\t}\n\t\telse if(codelevel==6)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode6.value=termcode;\n\t\t}\n\t\telse if(codelevel==7)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode7.value=termcode;\n\t\t}\n\t\telse if(codelevel==8)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode8.value=termcode;\n\t\t}\n\t\telse if(codelevel==9)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode9.value=termcode;\n\t\t}\n\t\telse if(codelevel==10)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode10.value=termcode;\n\t\t}\n\t\tparent.f_term_add_modify.document.term_code_addmodify.term_code.value=\"\";\n\t\tparent.f_term_add_modify.document.term_code_addmodify.term_code.readOnly=false;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.short_desc.value=\"\";\n\t\tparent.f_term_add_modify.document.term_code_addmodify.long_desc.value=\"\";\n\t\tparent.f_term_add_modify.document.term_code_addmodify.eff_status.checked=true;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.selectable.checked=false;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.selectable.disabled=false;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.proc_diag.value=\"\";\n\t\tparent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.termsetid.value = termsetid;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;\n\t\tparent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;\n\t\t// This part dynamic rows are generated for final frame selected value based on click of result page.\n \t\tvar rowvar = parent.f_term_selected_frms.f_term_selected_values.document.getElementById(\"tableId\").insertRow();\n\t\tvar cellvar = rowvar.insertCell();\n\t\ttermdesc    =  unescape(termdesc);\n\t\tfor(var i= 0 ; i < termdesc.length;i++)\n\t\t{\n\t\t\ttermdesc = \ttermdesc.replace(\'|\',\' \');\n\t\t}\n\t\tcellvar.insertAdjacentHTML(\"BeforeEnd\",termdesc);\n\t\tif(codelevel%2==0)\n\t\t{\n\t\t\tcellvar.className=\'ATCQRYEVEN\';\n\t\t}\n\t\t else\n\t\t{\n\t\t\tcellvar.className=\'ATCQRYODD\';\n\t\t}\n\t\t// End of dynamic rows creation.\n\t\tif(codelevel==(cdlvl-1))\n\t\t{\n\t\t\tclassName = \"className\";\n\t\t\tdocument.term_code_result.className.value = \"className\";\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.className.value = \"className\";\n\t\t\tparent.f_term_result_header.document.term_code_result_header.className.value = \"className\";\n\t\t}\n\t\tparent.f_term_code_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?termcode=\"+termcode+\"&termsetid=\"+termsetid+\"&codelevel=\"+codelevel+\"&className=\"+className+\"\";\n\t\tvar htmlvalue = \"<html><body onKeyDown=\'lockKey()\'><form name=\'dynamic_value\' id=\'dynamic_value\' method=\'post\' action=\'../../eMR/jsp/EquivalentTermCodeDynamicValues.jsp\'><input type=\'hidden\' name=\'termsetid\' id=\'termsetid\' value=\'\"+termsetid+\"\'><input type=\'hidden\' name=\'codelevel\' id=\'codelevel\' value=\'\"+codelevel+\"\'><input type=\'hidden\' name=\'termcode\' id=\'termcode\' value=\'\"+termcode+\"\'></form></body></html>\"\n\t\tparent.f_term_selected_frms.document.write(htmlvalue);\n\t\tparent.f_term_selected_frms.document.dynamic_value.submit();\n\t}\n\t \n\tparent.messageFrame.document.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n}\t\nfunction addmod(mode,termcode)\n{\n\tvar termsetid = document.term_code_result.termsetid.value; \n\tvar codelevel = document.term_code_result.codelevel.value; \n\tif(document.term_code_result.className.value == \"className\")\n\t\tclassName = \"className\";\n\telse\n\t\tclassName = \"\";\n\t\n\tparent.messageFrame.document.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n}\nfunction checkVal(termset_id){\n\n\t\n\tparent.messageFrame.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\";\n\tvar termsetid = document.term_code_result.termsetid.value;\n\tvar type_set = document.term_code_result.type_set.value;\n\n\tparent.f_term_selected_frms.location.href=\"../../eMR/jsp/EquivalentTermCode1.jsp?termsetid=\"+termsetid+\"&termset_id=\"+termset_id+\"&type_set=\"+type_set+\" \";\n\tdocument.term_code_result.equalform.value=\'Y\';\n\tparent.frames[1].frm_terminology_code.termcode_text.value=termset_id;\n}\n\n\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'> \n<FORM METHOD=\'POST\' name=\'term_code_result\' id=\'term_code_result\' target=\'f_term_selected_frms\' ACTION=\"\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table width=\'95%\'>\n<tr>\n<table align=\'right\'>\n<tr>\n<!--<td align=\'right\'  id=\'prevNext\'  class=\'BODYCOLORFILLED\'>-->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td id=\'prev\'><a href=\'javascript:submitPrevNext(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"Previous\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<td id=\'next\' style=\'visibility:hidden\'><a href=\'javascript:submitPrevNext(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"Next\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></td>\n</tr>\n</table>\n</tr>\n</table>\n<br>\n<br>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'95%\' >\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t<th class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t\t\t<th class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<th class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<INPUT TYPE=\"hidden\" name=\"chkall\" id=\"chkall\"onclick=\'chkallvall(this,";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =",";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =")\'></th>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t   \n\t\t\n\t\t\t<!--<th align=\'left\'>Code</th>\n\t\t\t<th align=\'center\'>Description</th>-->\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<!--<th align=\'left\'>Select &nbsp;<INPUT TYPE=\"hidden\" name=\"chkall\" id=\"chkall\"onclick=\'chkallvall(this,";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =")\'></th>-->\n\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t</td>\n\t\t\t\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp; <img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"></td> \n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="><a HREF=\"javascript:onClick=checkVal(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\"> ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</a></td> \n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" \n\t\t\t\t<td class=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="><input type =\"checkbox\"  id=\"check_id\" name=\'chks_factor";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'chks_factor";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" onclick=\"remchk(this)\"  ></td>\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"namecheck";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"namecheck";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\n\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t  ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\n</table>\n \n<INPUT TYPE=\"hidden\" name=\"FirstConbox\" id=\"FirstConbox\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<INPUT TYPE=\"hidden\" name=\"SecondValue\" id=\"SecondValue\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<INPUT TYPE=\"hidden\" name=\"ThirdConbox\" id=\"ThirdConbox\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<INPUT TYPE=\"hidden\" name=\"termsetid\" id=\"termsetid\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode\" id=\"termcode\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode1\" id=\"termcode1\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<INPUT TYPE=\"hidden\" name=\"codelevel\" id=\"codelevel\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<INPUT TYPE=\"hidden\" name=\"termdesc\" id=\"termdesc\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<INPUT TYPE=\"hidden\" name=\"search_criteria\" id=\"search_criteria\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<INPUT type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<INPUT type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<INPUT type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<INPUT type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<INPUT TYPE=\"hidden\" name=\"desc\" id=\"desc\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"selectall\" id=\"selectall\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\'className\' id=\'className\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'> \n<INPUT TYPE=\"hidden\" name=\"mr_term_set\" id=\"mr_term_set\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<INPUT TYPE=\"hidden\" name=\"alphalink\" id=\"alphalink\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<INPUT TYPE=\"hidden\" name=\"equalform\" id=\"equalform\" value=\"N\">\n<INPUT TYPE=\"hidden\" name=\"type_set\" id=\"type_set\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

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
	Connection con=null;
	Statement stmt=null;
	ResultSet rset=null ;
//	ResultSet rset1=null ;
	ResultSet rs_c = null;
	Statement st_c = null;
	PreparedStatement psmt=null;
	String cd_lvl = request.getParameter("codelevel");
	if(cd_lvl==null||cd_lvl.equals("")) cd_lvl="1";
	int code_level = Integer.parseInt(cd_lvl);
	String className= request.getParameter("className");
	if(className==null) className = "";
	String classValue = "";
	String status="";
	String termsetid="";
	String type_set = "";
	
	String alphalink = request.getParameter("alphalink")==null?"All":request.getParameter("alphalink"); 

	

	String status1 =request.getParameter("status")==null?"N":request.getParameter("status");
	termsetid = checkForNull(request.getParameter("termsetid"));



	String Terminology = checkForNull(request.getParameter("Terminology"));
	String termset_id = checkForNull(request.getParameter("termset_id"));
	type_set = checkForNull(request.getParameter("type_set"));
	String termcode_text = checkForNull(request.getParameter("termcode_text"));

	String FirstConbox=Terminology;
	String SecondValue=termset_id;
	String ThirdConbox=termsetid;
	String termdescription = request.getParameter("termdesc")==null?"":request.getParameter("termdesc");
	String search_criteria = checkForNull(request.getParameter("search_criteria"));
	String search_text = checkForNull(request.getParameter("search_text"));

	String callres = checkForNull(request.getParameter("callres"));
	String codeResult = checkForNull(request.getParameter("codeResult"));

	String termcode = checkForNull(request.getParameter("termcode"));
	String termcode1 = checkForNull(request.getParameter("termcode"));


	String mr_term_set=request.getParameter("mr_term_set")==null?"":request.getParameter("mr_term_set");


	String chked_factor = "";
	String factor_val = "";
	ArrayList ListAll= new ArrayList();
	
	HashMap ListValues= new HashMap();
	String whereclause = "";
	
	String sqltermcoderesult = "";
//	String desc = "";
//	String defnlevelSql = "";
	String from = checkForNull(request.getParameter("from") );
	String to = checkForNull(request.getParameter("to") );
	String termset_desc="";
	String eff_status="";
	
	if(termcode==null) termcode="";
	if(termcode1==null) termcode1="";
	if(termsetid==null) termsetid="";
	if(code_level==1)
		termcode = "";
	if((termdescription==null)||(termdescription.equals("All"))) termdescription="";
	if(search_criteria==null) search_criteria="";
	if(search_text==null) search_text="";
try
	{
		con = ConnectionManager.getConnection(request);
		from = request.getParameter("from") ;
		to = request.getParameter("to") ;
	
		if(!search_text.equals(""))
		{
			termdescription = search_text;
			

		}
		if(search_criteria.equals("S"))
		{
			whereclause = "upper(short_desc) like upper('"+termdescription + "%')";
		}
		else if(search_criteria.equals("E"))
		{
			whereclause =  "upper(short_desc) like  upper('%" + termdescription +"')";
		}
		else if(search_criteria.equals("C"))
		{
			whereclause = "upper(short_desc) like  upper('%"+ termdescription + "%')";
		}
		else
		{
			whereclause = "upper(short_desc) like  upper('"+termdescription + "%')";
		}
	
		if(termdescription.equals("OT"))
		{
			whereclause = whereclause +" and (UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
		}


		if(!type_set.equals(""))
		{
			if(type_set.equals("DA")){
				whereclause = whereclause +" and cross_ref_type like '%D' and diagnosis_yn = 'Y'";
			}else if(type_set.equals("CO")){
				whereclause = whereclause +" and cross_ref_type like '%C' and diagnosis_yn = 'Y'";
			}else if(type_set.equals("EQ")){
				//whereclause = whereclause +" and cross_ref_type is NULL";
			}else if(type_set.equals("AS")){
				/*Wednesday, January 27, 2010 , modified for SRR20056-CRF-0303.2 [IN:015597] to list dagger dependent Astrisk Codes */
				//whereclause = "cross_ref_type like '%A'";
					whereclause = whereclause +" and cross_ref_type like '%A' ";
			}else if(type_set.equals("EC")){
				whereclause = whereclause +" and cross_ref_type like '%E'";
			}
		}
		if(!termcode_text.equals(""))
		{
			whereclause= whereclause +" and upper(term_code) like '"+termcode_text + "%'";
		}


		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;
		int start_check = 1;
		int end_check = 0;
		if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
		if (to == null){ end = 7 ; }   else {  end = Integer.parseInt( to ) ; }
		i = 1;
		/*String cntSql="";
		if(termcode.equals(""))
		{
			if(alphalink.equals("All")){
			cntSql="select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" order by short_desc";
	        }
			else if (alphalink.equals("OT"))	{

			 cntSql="select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";
	  
	          }
			else {
			cntSql="select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and UPPER (short_desc) like '"+alphalink+"%' order by short_desc";
	   
	      }
		}
		else
		{
			cntSql="select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and code_level="+code_level+"order by short_desc";
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
		} */

		/*if(code_level==1)
		{
			defnlevelSql = "select level_1_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==2)
		{
			defnlevelSql = "select level_2_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==3)
		{
			defnlevelSql = "select level_3_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==4)
		{
			defnlevelSql = "select level_4_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==5)
		{
			defnlevelSql = "select level_5_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==6)
		{
			defnlevelSql = "select level_6_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==7)
		{
			defnlevelSql = "select level_7_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==8)
		{
			defnlevelSql = "select level_8_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==9)
		{
			defnlevelSql = "select level_9_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==10)
		{
			defnlevelSql = "select level_10_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		stmt=con.createStatement();
		rset1 = stmt.executeQuery(defnlevelSql);
		if(rset1!=null)
		{
			if(rset1.next())
			{
				desc = rset1.getString(1);
				if(rset1!=null) rset1.close();
				if(stmt!=null) stmt.close();
			}
		}

		*/ // the entire block commented on 1-4-2010 as the variable desc was noot used any where..
		

            _bw.write(_wl_block10Bytes, _wl_block10);

	if (maxRecord==0)
		{

            _bw.write(_wl_block11Bytes, _wl_block11);

	if ( !(start <= 1))
	{
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((start-7)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end-7)));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

	}
	//if ( !((start+7) > maxRecord ))
	//{
		
	//}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((start+7)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end+7)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		}

            _bw.write(_wl_block19Bytes, _wl_block19);

//	if(termcode.equals("") && search_text.equals(""))
	if(termcode.equals(""))
	{    
		if(search_text.equals(""))
		{	
			
				   if(alphalink.equals("All")){				  
					   
					//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" order by short_desc";
					
					// query modified on 4-1-2010 to make it level independent.
					sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' order by short_desc";

				   }
				   else if (alphalink.equals("OT"))	{				  
					//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";

					// query modified on 4-1-2010 to make it level independent.	
				    sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";
					
				   }
				   else {					
					//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and UPPER (short_desc) like '"+alphalink+"%' order by short_desc";		

					// query modified on 4-1-2010 to make it level independent.
   					sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' and UPPER (short_desc) like '"+alphalink+"%' order by short_desc";		
				   }
		}else{				
							
			if(callres.equals("search")){
			
					if(search_criteria.equals("S"))
						 search_text = search_text +"%";
					 else if(search_criteria.equals("E"))
								 search_text ="%"+search_text;
					 else if(search_criteria.equals("C"))
								 search_text = "%"+search_text+"%";
					 else
								 search_text = "%";		
					 
					//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and  Upper(short_desc) like Upper('"+search_text+"') order by short_desc";

					// query modified on 4-1-2010 to make it level independent.
					sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' and  Upper(short_desc) like Upper('"+search_text+"') order by short_desc";

			}
			else{

								
				 if(alphalink.equals("All")){

						 if(search_criteria.equals("S")){
							 search_text = "upper(short_desc) like '"+ search_text.toUpperCase() + "%'";			
							 }
							 else if(search_criteria.equals("E")){
										 search_text ="upper(short_desc) like '%"+ search_text.toUpperCase() + "'";
										 
							 }
							 else if(search_criteria.equals("C")){
										  search_text ="upper(short_desc) like '%"+ search_text.toUpperCase() + "%'";
							 }
							 else{
										 search_text = "%";	
							 }
									 String typeSet="";

							if(!type_set.equals(""))
								{
									if(type_set.equals("DA"))
										typeSet = "cross_ref_type like '%D'";
									else if(type_set.equals("EC"))
										typeSet = "cross_ref_type like '%E'";
									else if(type_set.equals("EQ"))
										typeSet = "cross_ref_type is NULL";
									else if(type_set.equals("AS"))
										/*Wednesday, January 27, 2010 , modified for SRR20056-CRF-0303.2 [IN:015597] to list dagger dependent Astrisk Codes */
										//whereclause = "cross_ref_type like '%A'";
										typeSet = "cross_ref_type like '%A' ";
									else if(type_set.equals("CO"))
										typeSet = "cross_ref_type like '%C'";
								}
								  
								   if(codeResult.equals("result")){

									  /* if(search_criteria.equals("S"))
										 search_text = search_text +"%";
									 else if(search_criteria.equals("E"))
												 search_text ="%"+search_text;
									 else if(search_criteria.equals("C"))
												 search_text = "%"+search_text+"%";
									 else
												 search_text = "%";	

										String typeSet="";
										*/	 




								
									//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where   term_set_id='"+termsetid+"' and "+typeSet+"  and  code_level="+code_level+" and  "+search_text+" order by short_desc";

									// query modified on 4-1-2010 to make it level independent.

									sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where   term_set_id='"+termsetid+"' and "+typeSet+"  and  SELECT_YN='Y' and  "+search_text+" order by short_desc";
								   }
								   else
									 {
									   
										//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and    "+search_text+" and term_set_id='"+termsetid+"' and code_level="+code_level+"  order by short_desc";
	
										// query modified on 4-1-2010 to make it level independent.

										sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and    "+search_text+" and term_set_id='"+termsetid+"' and SELECT_YN='Y'  order by short_desc";

										
									 }

							   }
							   else if (alphalink.equals("OT"))	{
								   
									   //sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and  term_set_id='"+termsetid+"' and code_level="+code_level+" and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";

					   					// query modified on 4-1-2010 to make it level independent.


									   sqltermcoderesult="select term_code,short_desc,eff_status from,dagger_independent_yn mr_term_code where "+whereclause+" and  term_set_id='"+termsetid+"' and SELECT_YN='Y' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' order by short_desc";

									   
							
							   }
							   else {
										   if(search_criteria.equals("S")){
												 search_text = "upper(short_desc) like '"+ search_text.toUpperCase() + "%' AND upper(short_desc) like '"+alphalink+"%'";							 

										   }
											 else if(search_criteria.equals("E")){
														 search_text ="upper(short_desc) like '%"+ search_text.toUpperCase() + "' AND upper(short_desc) like '"+alphalink+"%'";
														 
											 }
											 else if(search_criteria.equals("C")){
														  search_text ="upper(short_desc) like '%"+ search_text.toUpperCase() + "%' AND upper(short_desc) like '"+alphalink+"%'";
											 }
											 else{
														 search_text = "%"+alphalink+"%";
											 }
											 
											
										//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where  "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and  "+search_text+" order by short_desc";

										// query modified on 4-1-2010 to make it level independent.

										sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where  "+whereclause+" and term_set_id='"+termsetid+"' and SELECT_YN='Y' and  "+search_text+" order by short_desc";
										
								
							   
							   }




								/*
								sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+"and  upper(short_desc) like '"+search_text+"%' order by short_desc";
								*/
							}
						}
	}
	else
	{
		
		//sqltermcoderesult="select term_code,short_desc,eff_status from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and code_level="+code_level+"order by short_desc";

		// query modified on 4-1-2010 to make it level independent.


		sqltermcoderesult="select term_code,short_desc,eff_status,dagger_independent_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and term_code like'"+termcode+"%' and SELECT_YN='Y' order by short_desc";

		


	}

	stmt = con.createStatement();
	rset=stmt.executeQuery(sqltermcoderesult);
    String tempString  = "";
	String classValmod = "";

	
	ArrayList ar_c = new ArrayList();

	if(FirstConbox != null && SecondValue !=null && ThirdConbox != null)
	{
		String sq = "select EQUIVALENT_TERM_CODE from MR_EQUIVALENT_TERM_CODE where  TERM_SET_ID=? and TERM_CODE=? and EQUIVALENT_TERM_SET_ID=?";	

	
		//st_c = con.createStatement();
		psmt = con.prepareStatement(sq);
		psmt.setString(1,FirstConbox);
		psmt.setString(2,SecondValue);
		psmt.setString(3,ThirdConbox);
		rs_c = psmt.executeQuery();

		while(rs_c.next())
		{
			ar_c.add(rs_c.getString(1));		
		}

	}

	if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rset.next() ;
			}
		}
		start_check = i;

	String dagger_independent_yn="";
	String hide_mand="hidden";
	while(i<=end && rset.next() )
		{

			if(maxRecord==0)
			{   
			
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
	if(mr_term_set.equals("N"))
				{
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
			}
            _bw.write(_wl_block27Bytes, _wl_block27);
 
		/*if((maxRecord==0)&&status1.equals("Y"))
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			*/
            _bw.write(_wl_block28Bytes, _wl_block28);
	/*if(mr_term_set.equals("N"))
		{*/
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(start));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end));
            _bw.write(_wl_block30Bytes, _wl_block30);
/*
		}}*/
            _bw.write(_wl_block31Bytes, _wl_block31);

	
	/*ResultSet rs_c = null;
	ArrayList ar_c = new ArrayList();
	
	if(FirstConbox != null && SecondValue !=null && ThirdConbox != null)
	{
		String sq = "select EQUIVALENT_TERM_CODE from MR_EQUIVALENT_TERM_CODE where  TERM_SET_ID='"+FirstConbox+"' and TERM_CODE='"+SecondValue+"' and EQUIVALENT_TERM_SET_ID='"+ThirdConbox+"'";		
		Statement st_c = con.createStatement();
		rs_c = st_c.executeQuery(sq);
		while(rs_c.next())
		{
			ar_c.add(rs_c.getString(1));		
		}

	}*/
//if(rset!=null)
	//{
		/*if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rset.next() ;
			}
		}
		start_check = i;*/
		//while(rset.next() && i<=end )
		//{


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
				
				tempString = tempString.replace(' ','|');
				tempString = java.net.URLEncoder.encode(tempString);
				status = rset.getString("eff_status");
				termset_id = rset.getString("term_code")==null ? "":rset.getString("term_code");
				termset_desc = rset.getString("short_desc")==null ? "":rset.getString("short_desc");
				eff_status = rset.getString("eff_status")==null ? "":rset.getString("eff_status");
				dagger_independent_yn = rset.getString("dagger_independent_yn")==null ? "":rset.getString("dagger_independent_yn");
				if(dagger_independent_yn.equals("Y")){
					hide_mand="visible";
				}else{
					hide_mand="hidden";
				}

				
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(termset_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(mr_term_set.equals("N")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(termset_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(hide_mand));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(termset_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(termset_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
	if(mr_term_set.equals("N")){
					 ListValues.put("termset_id",termset_id);
			         ListValues.put("termset_desc",termset_desc);
			         ListValues.put("eff_status",eff_status);
                     ListAll.add(ListValues);
			 for(int k=0; k<ListAll.size(); k++){
				   HashMap DoseHashMap=new HashMap();
					DoseHashMap = (HashMap)ListAll.get(k);
                   
                     for(int x = 0;x<ar_c.size();x++)
				     { 
				   if(termset_id.equals(ar_c.get(x)))
					  {  

						chked_factor = "checked";
						factor_val = "E";
						
						break;
					}
					else
					{
						chked_factor = "";
						factor_val = "D";
				  	}
                 
				 }

            }

			
			
			  end_check = i;
			
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(factor_val));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(chked_factor));
            _bw.write(_wl_block48Bytes, _wl_block48);
out.println("<input type='hidden' name=factor_code"+i+" value='"+rset.getString(1)+"'>");
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
			
			i++;
			maxRecord++;			
		}

				
		if ( maxRecord < 7 || (!rset.next()) )
		{
			
            _bw.write(_wl_block53Bytes, _wl_block53);
 
		}
		else
		{
            _bw.write(_wl_block54Bytes, _wl_block54);

		}

		if((maxRecord==0)&&status1.equals("Y"))
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	if(rs_c!=null) rs_c.close();
	if(st_c!=null) st_c.close();
	if(psmt!=null) psmt.close();
	//}

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(FirstConbox));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(SecondValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ThirdConbox));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(termcode));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(termcode1));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(code_level));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(termdescription));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(start_check));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(end_check));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(start));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(end));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(className));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mr_term_set));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(alphalink));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(type_set));
            _bw.write(_wl_block72Bytes, _wl_block72);
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		if(rs_c!=null) rs_c.close();
		if(st_c!=null) st_c.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block73Bytes, _wl_block73);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
