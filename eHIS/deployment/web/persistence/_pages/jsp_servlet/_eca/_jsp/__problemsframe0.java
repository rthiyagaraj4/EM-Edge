package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __problemsframe0 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/Problemsframe0.jsp", 1739956693142L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/DateCheck.js\' ></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCA/js/ProblemList.js\"></script>\n\t\t<script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\n\t<script language=javascript>\n\t\t\n\t//\tfunction funSearch()\n\t//\t{\n\t//\t\t//parent.problemsframe1.funTest();\n\t//\t}\n\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n<script>\n\tvar rb;\n\tvar pr=\"N\";\n\tvar dt=\"\";\n\n\t\n\n\tfunction callSenseProb(obj){\n\t\t   if(rb==null)\trb=\'A\';\n\t\t\tif (document.radioform.senseprob.value==\'Authorize Mode\'){\n\t\t\t\tpr=\"Y\";\n\t\t\t\t//alert(\'111...\');\n\t\t\t\tauthorised(obj);\n\t\t\t}else{\n\t\t\t\tpr=\"N\";\n\t\t\t\tdocument.radioform.senseprob.value=\'Authorize Mode\'\n\t\t\t\t//alert(\'2222...\');\n\t\t\t\tcallProbRadio();\n\t\t\t}\n\t}\n\n\n\tfunction callProbRadio(){\n\t\t//alert(\"document.radioform.code_set.value;=\"+document.radioform.code_set.value);\n\t\tif(rb==\"A\"){\n\t\t\t//alert(\'3333...\');\n\t\t\tdocument.getElementById(\"x1\").width=\"10%\";\n\t\t\tdocument.getElementById(\"x\").width=\"10%\";\n\t\t\tdocument.getElementById(\"z\").width=\"10%\";\n\t\t\tdocument.getElementById(\"h\").width=\"15%\";\n\t\t\t//document.getElementById(\"h\").innerText=\"\";\n\t\t\tdocument.getElementById(\"h\").innerText=\'Status\'\n\t\t\tdocument.getElementById(\"h\").style.visibility=\'visible\'\n\t\t\tdocument.getElementById(\"a\").width=\"40%\";\n\t\t\tdocument.getElementById(\"c\").width=\"9%\";\n\t\t\tdocument.getElementById(\"th1\").width=\"100%\";\n\t\t}else{\n\t\t\t//alert(\'44444...\');\n//\t\t\tdocument.getElementById(\"x1\").width=\"5%\";\n\t\t\tdocument.getElementById(\"x\").width=\"5%\";\n\t\t\tdocument.getElementById(\"z\").width=\"5%\";\n\t\t\tdocument.getElementById(\"a\").width=\"40%\"\n\t\t\tdocument.getElementById(\"c\").width=\"13%\"\n\t\t\tdocument.getElementById(\"h\").width=\'15%\'\n\t\t\tdocument.getElementById(\"h\").innerText=\'Status\'\n\t\t\tdocument.getElementById(\"h\").style.visibility=\'visible\'\n\t\t\tdocument.getElementById(\"th1\").width=\'100%\'\n\t\t}\n\n\t\tvar orderBy =document.radioform.orderBy.value;\n\t\tvar reOrder = document.radioform.reOrder.value;\n\n\t\t\tif(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" == \"Y\"){\n\t\t\t\tparent.problemsdetails.location.href=\'ProblemsDetails.jsp?modal_yn=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'\n\t\t\t\tparent.problemsassessments.location.href=\'ProblemsAssessment.jsp?modal_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'\n\t\t\t\tparent.problemsframe1.location.href=\"Problemsframe1.jsp?probstatus=\"+rb+\"&pr=\"+pr+\"&diag_type=\"+dt+\"&Patient_Id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&P_function_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&P_no_of_items=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&P_option_type=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&modal_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&orderBy=\"+orderBy+\"&reOrder=\"+reOrder+\"&term_set_id=\"+document.radioform.code_set.value;\n\t\t\t}else{\n\t\t\t\ttop.content.workAreaFrame.problemsdetails.location.href=\'ProblemsDetails.jsp?modal_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\n\t\t\t\ttop.content.workAreaFrame.problemsassessments.location.href=\'ProblemsAssessment.jsp?modal_yn=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'\n\t\t\t\ttop.content.workAreaFrame.problemsframe1.location.href=\"Problemsframe1.jsp?probstatus=\"+rb+\"&pr=\"+pr+\"&diag_type=\"+dt+\"&Patient_Id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&orderBy=\"+orderBy+\"&reOrder=\"+reOrder+\"&term_set_id=\"+document.radioform.code_set.value;\n\t\t\t}\n\t}\n\n\tfunction funSearch()\n\t{\n\t\tvar problems_radio=\"\";\n\t\tif (document.radioform.problems_radio[0].checked)\n\t\t\tproblems_radio=document.radioform.problems_radio[0].value;\n\t\telse\n\t\t\tproblems_radio=document.radioform.problems_radio[1].value;\t\t\t\n\n\t\tvar diag_type = \"\";\n\t\tvar code = document.radioform.code.value;\n\t\tvar from_date = document.radioform.txtFromDate.value;\n\t\tvar to_date= document.radioform.txtToDate.value;\n\t\tvar encounter_id = document.radioform.encounter_id.value;\n\t\t//if(encounter_id == null || encounter_id == \'\')\n\t\t\t//encounter_id = document.radioform.Encounter_Id.value;\n\t\tvar orderBy =document.radioform.orderBy.value;\n\t\tvar reOrder = document.radioform.reOrder.value;\n\t\tvar term_set_id = document.radioform.code_set.value;\n\t\tif (!CheckDate(document.radioform.txtToDate,null))\n\t\t\treturn false;\n\n\t\tif (!CheckDate(document.radioform.txtFromDate,null))\n\t\t\treturn false;\n\n\t\t\n\t\tif(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" == \"Y\")\n\t\t{\n\t\t\tparent.problemsdetails.location.href=\'ProblemsDetails.jsp?modal_yn=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'\n\t\t\tparent.problemsassessments.location.href=\'ProblemsAssessment.jsp?modal_yn=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'\n\t\t\tparent.problemsframe1.location.href=\"Problemsframe1.jsp?probstatus=\"+problems_radio+\"&pr=\"+pr+\"&diag_type=\"+diag_type+\"&Patient_Id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&code=\"+code+\"&from_date=\"+from_date+\"&to_date=\"+to_date+\"&orderBy=\"+orderBy+\"&reOrder=\"+reOrder+\"&encounter_id=\"+encounter_id+\"&term_set_id=\"+term_set_id;\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttop.content.workAreaFrame.problemsdetails.location.href=\'ProblemsDetails.jsp?modal_yn=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'\n\t\t\ttop.content.workAreaFrame.problemsassessments.location.href=\'ProblemsAssessment.jsp?modal_yn=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'\n\t\t\ttop.content.workAreaFrame.problemsframe1.location.href=\"Problemsframe1.jsp?probstatus=\"+problems_radio+\"&pr=\"+pr+\"&diag_type=\"+diag_type+\"&Patient_Id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&code=\"+code+\"&from_date=\"+from_date+\"&to_date=\"+to_date+\"&orderBy=\"+orderBy+\"&reOrder=\"+reOrder+\"&encounter_id=\"+encounter_id+\"&term_set_id=\"+term_set_id;\n\t\t}\n\t}\n\t\n\tfunction callProg(obj){\n\t\trb = obj.value;\n\t\tcallProbRadio()\n\t}\n\n\tfunction callProg2(obj){\n\t\t\tdt = obj.value;\n\t\t\tif(\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'\n\t\t\t\tparent.problemsframe1.location.href=\"Problemsframe1.jsp?probstatus=\"+rb+\"&pr=\"+pr+\"&diag_type=\"+obj.value+\"&Patient_Id=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&term_set_id=\"+document.radioform.code_set.value;\n\t\t\t}else{\n\t\t\t\ttop.content.workAreaFrame.problemsdetails.location.href=\'ProblemsDetails.jsp?modal_yn=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'\n\t\t\t\ttop.content.workAreaFrame.problemsframe1.location.href=\"Problemsframe1.jsp?probstatus=\"+rb+\"&pr=\"+pr+\"&diag_type=\"+obj.value+\"&Patient_Id=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&term_set_id=\"+document.radioform.code_set.value;\n\t\t\t}\n\t}\n\n\t\t\tasync function authorised(Obj)\n\t\t\t{\n\t\t\t\tif(document.forms[0].mode.value == \'normal\')\n\t\t\t\t{\n\t\t\t\t\tpr = \"Y\";\n\t\t\t\t\tdocument.forms[0].mode.value = \'authorized\';\n\t\t\t\t\tawait show_window();\n\t\t\t\t}\n\t\t\t\telse if(document.forms[0].mode.value == \'authorized\')\n\t\t\t\t{\n\t\t\t\t\tpr = \"N\";\n\t\t\t\t\tdocument.forms[0].mode.value = \'normal\';\n\t\t\t\t\tfunSearch();\n\t\t\t\t\tdocument.radioform.senseprob.value=\'Authorize Mode\';\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tasync function show_window()\n\t\t\t{\n\t\t\t\tvar val1 = \'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' ;\n\t\t\t\tvar val2 = \'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' ;\n\t\t\t\tvar val3 = \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' ;\n\t\t\t\tvar val5=\t \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'\n\t\t\t\tvar val = val1+\'/\'+val2+\'/\'+val3+\'/\';\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= \"9\" ;\n\t\t\t\tvar dialogWidth\t= \"25\" ;\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tretVal = await window.showModalDialog(\"AuthorizeMRAccess.jsp?constr=\"+val,arguments,features);\n\t\t\t\tif(retVal == \"T\" )\n\t\t\t\t{\n\t\t\t\t\tfunSearch();\n\t\t\t\t\tradioform.senseprob.value  =\"Normal Mode\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tpr = \"N\";\n\t\t\t\t}\n\t\t\t}\n\n\tfunction CheckForSpecCharsNoCaps(event){\n    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* \';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode);\n\treturn true ;\n\t}\n\n</script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<form name=\"radioform\" id=\"radioform\">\n<table align=center border=\'0\' width=100%  cellspacing=\'0\' cellpadding=\'3\'>\n<tr>\n\t<th class=\'columnHeader\'  colspan=6 align=\"left\"><b>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</b></th>\n</tr>\t\n<tr>\n\t\t<td class=fields width=\'25%\' colspan=2 >\n\t\t<input type=\"radio\" name=\"problems_radio\" id=\"problems_radio\" class=\"label\" value=\"A\" onClick=\"\" checked ><font size=\'1\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;\n\t\t<input type=\"radio\" name=\"problems_radio\" id=\"problems_radio\" class=\"label\" value=\"O\" onClick=\"\">\n\t\t<font size=\'1\'>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n</td>\n<!-- <td colspan=1></td>\n -->\t<td class=label width=\'25%\' colspan=2><!--";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\"diag_type\" id=\"diag_type\" onChange=\"\"><option value=\'\'>---------- ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="----------\n\t\t\t<option value=\'P\' >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<option  value=\'D\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<option  value=\'F\' >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t</select> -->\n</td> \n\n</tr>\n\t<tr>\n\t\t<td class = label  >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t<td class = \'fields\' colspan=2  >\n\t\t<select name=\"code_set\" id=\"code_set\"  onChange=\"enableCode(this);\" ><option value=\'\'>----- ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" -----</option>\n\t\t\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\n\t\t</select>\n\t\t<input type=\"text\" name=\"code\" id=\"code\" size=5 Onblur=\'show_desc(this)\' readOnly><input type=\"button\" class=\'Button\' name=\"search_button\" id=\"search_button\" title=\'Search\' value=\"?\" onClick=\"show_window1(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\" disabled > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'text\' name=\'code_desc\' id=\'code_desc\' size=25 readOnly></input></td>\n\t\t<td colspan=1></td>\n\t</tr>\n\t<tr>\n\t\t<td class=label width=\'25%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t<td class = \'fields\'  width=\'25%\' colspan=1 ><input type=\"text\" name=\"encounter_id\" id=\"encounter_id\" size=12 maxlength=12 value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' ><input type=\"button\" class=\'Button\' name=\"encounter_search_button\" id=\"encounter_search_button\" title=\'Encounter Search\' value=\"?\" onClick=\"View_Encounter(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\')\"  ></td>\n\t\t<td  class=label width=\'25%\' colspan=2>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&nbsp;&nbsp;&nbsp;\n\t\t\t\t<input type=\"text\" name=\'txtFromDate\' id=\'txtFromDate\' value=\'\' size=9 onBlur=\'CheckDate(this,null);doDateCheck(this,txtToDate, \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\",\"DMY\",\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\");\'><input type=\'image\'  src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'txtFromDate\');\" > - \n\t\t\t\t<input type=\"text\" name=\"txtToDate\" id=\"txtToDate\" onBlur=\'CheckDate(this,null);doDateCheck(txtFromDate,this, \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\");\' size=9><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'txtToDate\');\" > \t\t\n\t\t</td>\n\n\t</tr>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t<!--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSensitive \tProblem<inputtype=\"checkbox\" name=\"senseprob\"  value=\'N\' align=\"right\" onclick=\"callSenseProb(this)\">-->\n<!-- <tr>\n\t<td width=\'25%\'></td><td width=\'25%\'></td><td width=\'25%\'></td>\n\t<td width=\'25%\' >\n\t<input type=\'button\' name=\'senseprob\' id=\'senseprob\'  value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' onclick=\"callSenseProb(this)\" class=\'button\'> -->\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t<tr>\n\t<td colspan=3>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\t\n\t<input type=\'button\' name=\'senseprob\' id=\'senseprob\'  value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp;";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onclick=\"authorised(this)\" class=\'button\'>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t</td>\n\t<td width=\'25%\' align=\'right\'>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t<input type=\"button\" class=\"button\" name=\"btnSearch\" id=\"btnSearch\" value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' onClick=\"funSearch();\"><input type=\"button\" class=\"button\" name=\"clearSearch\" id=\"clearSearch\" value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' onClick=\"Clear_All();\">\t\n</td>\n</tr>\n<!--<tr>\n<td colspan=8 width=100% >\n<table align=left width=99% border=1 cellspacing=\'0\' cellpadding=\'3\' id=\'th1\'>\n<td class=\'columnHeadercenter\' width=\"11%\"  id=\'x1\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td> \n<td class=\'columnHeadercenter\' width=\"11%\"  id=\'x\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td> \n<td class=\'columnHeadercenter\' width=\"20%\"  id=\'a\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n<td class=\'columnHeadercenter\' width=\"10%\"  id=\'a\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n<td class=\'columnHeadercenter\' width=\"11%\"  id=\'b\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n<td class=\'columnHeadercenter\' width=\"8%\"  id=\'c\'>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n<td class=\'columnHeadercenter\' width=\"11%\"  id=\'d\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n<td class=\'columnHeadercenter\' width=\'7%\' ID=\'h\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n<td class=\'columnHeadercenter\'   id=\'z\' width=\"11%\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n<td class=\'columnHeadercenter\'  id=\'sc\' width=\"5%\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t<th class=\'columnHeader\' width=7%  >&nbsp;&nbsp;&nbsp;</th>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n</table>\n</td>\n</tr>-->\n</table>\n\n<!-- // added by Arvind @ 03-12-08  -->\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\n\n\t\t\t\t<!-- end here -->\n\t\t<input type=\"hidden\" name=\"P_access_type\" id=\"P_access_type\" value=";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" >\n\t\t<input type=\"hidden\" name=\"P_access_data\" id=\"P_access_data\" value=";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" >\n\t\t<input type=\"hidden\" name=\"P_patient_type\" id=\"P_patient_type\" value=";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" >\n\t\t<input type=\"hidden\" name=\"scheme\" id=\"scheme\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t<input type=\"hidden\" name=\"scheme_desc\" id=\"scheme_desc\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t<input type=\"hidden\" name=\"db_date\" id=\"db_date\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t<input type=hidden name=orderBy value=\'\'>\n\t\t<input type=hidden name=reOrder value=\'\'>\n\t\t<input type=\'hidden\' name=\'dob\' id=\'dob\'\tvalue=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t\t<input type=\'hidden\' name=\'age\' id=\'age\'\tvalue=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t\t<input type=\'hidden\' name=\'sex1\' id=\'sex1\'\tvalue=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t\t<input type=\'hidden\' name=\'Practitioner_Id\' id=\'Practitioner_Id\'\tvalue=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t\t<input type=\'hidden\' name=\'Encounter_Id\' id=\'Encounter_Id\'\tvalue=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\'\tvalue=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'normal\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

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
	Connection			conn 	= null;
	PreparedStatement	stmt1	= null;
	PreparedStatement	pstmt1	= null;
	PreparedStatement	pstmt	= null;
	PreparedStatement	stmt	= null;
	ResultSet			rs1		= null;
	ResultSet			oRs		= null;
	ResultSet			rset	= null;
	ResultSet			rset1	= null;
	ResultSet			rs		= null;
	
	String patientid=request.getParameter("Patient_Id");
	//****added for PH function usage
	String P_function_id=request.getParameter("P_function_id");
	String P_no_of_items=request.getParameter("P_no_of_items");
	String P_option_type=request.getParameter("P_option_type");
	String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	String age =(request.getParameter("Age")==null)?"":request.getParameter("Age");
	String sex1 =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
	String Practitioner_Id =(request.getParameter("Practitioner_Id")==null)?"":request.getParameter("Practitioner_Id");
	String speciality_code =(request.getParameter("speciality_code")==null)?"":request.getParameter("speciality_code");
	//****

            _bw.write(_wl_block6Bytes, _wl_block6);


String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
// added by Arvind @ 03-12-08 
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try{
		conn 	=	ConnectionManager.getConnection(request);
		String facilityId 	=	(String) session.getValue( "facility_id" ) ;
		String modal_yn=request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
		java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
		String locale = (String) p.getProperty("LOCALE");
		String login_user=p.getProperty( "login_user" ) ;
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

		if (encounter_id.equals("0"))
			encounter_id="";

		String context_value =request.getParameter("PQ"); //request.getParameter("Context");
		if (context_value==null) context_value="Y";
		String sql=" select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date from mr_parameter ";
		stmt = null;
		oRs  = null;
		String scheme = "";
		String scheme_desc="";
		String db_date = "";
        stmt = conn.prepareStatement(sql);
        oRs = stmt.executeQuery();
        
        if(oRs.next())
		{
            scheme      = oRs.getString("scheme");
            out.print("<script>scheme='"+scheme+"'</script>");
            scheme_desc = oRs.getString("scheme_desc");
            db_date     = oRs.getString("db_date");
        }
		// endshere
    
		String sql1 ="";

		//String set_flag="";
		int count=0;

		String P_patient_type="";
		String P_access_type="V";
		String P_access_data="SD";

		String term_set_id="";
		String term_set_desc="";

		if(context_value.equals("Y"))
				P_patient_type="O";
		else
				P_patient_type="C";

		//String sql="";
		
		rset=null;
try{

		if (context_value.equals("Y")){
			sql1= "Select '1' from mr_user_access_rights_vw where appl_user_id=? and access_type='V' and patient_type='C' and access_scope='SD' and facility_id=?";
		}else{
			sql1="Select '1' from mr_user_access_rights_vw where appl_user_id=? and access_type='V' and patient_type='O' and access_scope='SD' and facility_id=?";
		}

		stmt1 = conn.prepareStatement(sql1);
		stmt1.setString(1,login_user);
		stmt1.setString(2,facilityId);
		rs1 = stmt1.executeQuery();

		/*if (!(rs1.next()))
			set_flag="Y";
		else
			set_flag="N";*/
	}catch(Exception e){
		//out.println("Error"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}

	try{
			 StringBuffer strBuff_sql = new StringBuffer();
				
			strBuff_sql.append("select 'x' from mr_user_access_rights_vw where  FACILITY_ID   =?  and APPL_USER_ID=? and ACCESS_TYPE    ='V'  and access_scope='SD' and ");	
			   if(context_value.equals("Y")){
				   strBuff_sql.append(" PATIENT_TYPE='C' ");
			   }else{
				   strBuff_sql.append(" PATIENT_TYPE='O' ");
			   }
			strBuff_sql.append(" and exists(Select 'Y' from PR_DIAGNOSIS A,MR_TERM_CODE D WHERE D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and nvl(sensitive_yn,'N') ='Y' AND ROWNUM=1 ) ");
			pstmt=conn.prepareStatement(strBuff_sql.toString());
			pstmt.setString(1,facilityId);
			pstmt.setString(2,login_user);
			pstmt.setString(3,patientid);

		 rset = pstmt.executeQuery();
		 if (rset.next())
		 	count=1;
		  }

		 catch(Exception e){
			e.toString();
		 }		 
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(P_access_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(P_access_data));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(P_patient_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block35Bytes, _wl_block35);

			String sysdateSql="select to_char(sysdate,'dd/mm/yyyy') toDate from dual";
			String toDate="";	
			pstmt1 = conn.prepareStatement(sysdateSql);
			rset1 = pstmt1.executeQuery();
			if(rset1.next()){
					toDate=rset1.getString(1);
			}
	
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

		String diagset_qry ="select a.term_set_id,term_set_desc from MR_TERM_SET a where eff_status = 'E' ";

		 try
		{
		  pstmt = conn.prepareStatement(diagset_qry);
		  rs = pstmt.executeQuery();
		  while(rs!=null && rs.next())
		  {
			term_set_id   =rs.getString(1);
			term_set_desc =rs.getString(2);
			out.println("<option value='"+term_set_id+"' >"+term_set_desc+"</option>");
							
		  }
		  if(rs!=null) 
			  rs.close();
		  if(pstmt!=null) 
			  pstmt.close();
		}//try 
		catch(Exception eg)
		{
		 //  out.println("Exception="+eg.toString());//COMMON-ICN-0181
			eg.printStackTrace();//COMMON-ICN-0181
		}


		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block56Bytes, _wl_block56);

	/*if( count>0)
	{ */

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")));
            _bw.write(_wl_block58Bytes, _wl_block58);

	/*}
	else
	{*/

            _bw.write(_wl_block59Bytes, _wl_block59);
	
	if( count>0)
	{

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels")));
            _bw.write(_wl_block62Bytes, _wl_block62);

	}
	else
		out.println("&nbsp;");

            _bw.write(_wl_block63Bytes, _wl_block63);

	//}

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
if(P_function_id.equals("PH")){
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);
  if(!imgUrl.equals("")){
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(P_access_type ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(P_access_data ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(P_patient_type ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(scheme_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(db_date));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(age));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(sex1));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block93Bytes, _wl_block93);

}catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
}finally
{
	if(rs1!=null) rs1.close();
	if(oRs!=null) oRs.close();
	if(rset!=null) rset.close();
	if(rset1!=null) rset1.close();

	if(stmt1 !=null) stmt1.close();
	if(pstmt1 !=null) pstmt1.close();
	if(stmt !=null) stmt.close();	
	if(pstmt !=null) pstmt.close();	

	if(conn!=null) ConnectionManager.returnConnection(conn,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problems.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ActiveOnly.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Provisional.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Differential.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.final.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RecordedDateAndTime.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stage.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CloseDate.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SupportingDiagCode.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }
}
