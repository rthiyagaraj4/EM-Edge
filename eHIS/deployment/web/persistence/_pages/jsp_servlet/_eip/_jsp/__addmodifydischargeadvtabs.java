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
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifydischargeadvtabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AddModifyDischargeAdvTabs.jsp", 1740472115478L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7\" >\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </TITLE>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<Script src=\"../../eCommon/js/locale.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eMR/js/SickLeave.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n<script src=\"../js/DischargeAdvice.js\" language=\"JavaScript\"></Script>\n<script src=\"../js/IPPractitionerComponent.js\" language=\"JavaScript\"></Script>\n<script src=\"../js/CancelAdmission.js\" language=\"JavaScript\"></Script>\n\n<script>\n\nfunction enablePolice(obj)\n{\n\tif(document.forms[0].medico_legal.checked==true)\n\t{\n\t\tdocument.forms[0].pol_rep_no.disabled=false;\n\t\tdocument.forms[0].pol_stn_id.disabled=false;\n\t\tdocument.forms[0].pol_id.disabled=false;\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].pol_rep_no.value=\'\';\n\t\tdocument.forms[0].pol_rep_no.disabled=true;\n\t\tdocument.forms[0].pol_stn_id.value=\'\';\n\t\tdocument.forms[0].pol_stn_id.disabled=true;\n\t\tdocument.forms[0].pol_id.value=\'\';\n\t\tdocument.forms[0].pol_id.disabled=true;\n\t}\n}\n\nfunction DateValidations(obj)\n{\n\tif(document.forms[0].patient_class_value.value == \"IP\")\n\t\tvalidateDateTimes(obj,\'A\');\n\telse if(document.forms[0].patient_class_value.value == \"DC\")\n\t{\n\t\t\tif(validDateObj(obj,\"DMYHM\", localeName))\n\t\t\t\tdayCareDateCheck(obj);\n\t}\n}\n\nfunction expandCollapse(calledFrom) \n{\t\t\t\t\t\n\tif(calledFrom == \'Discharge_Details_tab\') \n\t{\n\t\tdocument.getElementById(\"Discharge_Details\").style.display = \'inline\';\n\t\tdocument.getElementById(\"Other_Details\").style.display = \'none\';\t\t\t\t\t\t\n\t} \n\telse if(calledFrom == \'Other_Details_tab\') \n\t{\n\t\tdocument.getElementById(\"Discharge_Details\").style.display = \'none\';\n\t\tdocument.getElementById(\"Other_Details\").style.display = \'inline\';\t\t\t\t\t\t\n\t}\n}\n\nfunction LoadRecordButton()\n{\n\t//Added by Kamatchi S for ML-MMOH-SCF-1643\n\tif(parent.frames[1].document.forms[0].weight_on_admission)\n\t\t//parent.frames[1].document.forms[0].weight_on_admission.value=parent.frames[2].document.forms[0].weight_on_admission_load.value;\n\t\tparent.frames[1].document.forms[0].weight_on_admission.value=parent.f_query_add_mod.document.getElementById(\"weight_on_admission_load\").value;\n\tif(parent.frames[1].document.forms[0].height_on_admission)\n\t\t//parent.frames[1].document.forms[0].height_on_admission.value=parent.frames[2].document.forms[0].height_on_admission_load.value;\n\t\tparent.frames[1].document.forms[0].height_on_admission.value=parent.f_query_add_mod.document.getElementById(\"height_on_admission_load\").value;\n\tif(parent.frames[1].document.forms[0].bmi)\n\t\t//parent.frames[1].document.forms[0].bmi.value=parent.frames[2].document.forms[0].bmi_load.value;\n\t\tparent.frames[1].document.forms[0].bmi.value=parent.f_query_add_mod.document.getElementById(\"bmi_load\").value;\t\n}\n\n</script>\n<!--FD-PMG20089-CRF-0547-IP\n<script language=\"vbscript\">\nfunction myMessageBox(title, prompt, buttons)\nmyMessageBox = MsgBox(prompt, buttons, title)\nend function\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n-->\n</HEAD>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<BODY onload=\"LoadRecordButton();document.forms[0].expecteddischargedate.focus();disableFields();";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="calculateBmi(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey();setShift();\">\n<form name=\'dischargeadvice_form\' id=\'dischargeadvice_form\' action=\'../../servlet/eIP.DischargeAdviceServlet\' method=\'post\' target=\'messageFrame\' onSelect = \"lockKey()\">\n<div id = \'Discharge_Details\'>\n<!-- <a name=\"tab1\" tabindex=\'0\'></a>   -->\n<ul id=\"tablist\" class=\"tablist\">\n\t<li class=\"tablistitem\" title=\"Discharge Details\">\n\t\t<a class=\"tabClicked\" id=\"discDetails\" >\n\t\t\t<span class=\"tabSpanclicked\" id=\"firstkinspan\" onClick=\'javascript:expandCollapse(\"Discharge_Details_tab\")\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n\t\t</a>\n\t</li>\n\t<li class=\"tablistitem\" title=\"Other Details\">\n\t\t<a class=\"tabA\" id=\"otherDetails\" >\n\t\t\t<span class=\"tabAspan\" id=\"firstkin1span\" onClick=\'javascript:expandCollapse(\"Other_Details_tab\")\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t</a>\n\t</li>\n</ul>\n\t<table border=\'0\' id=\'other_table\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n\t\t<input type=\'hidden\' name=\'encounterID\' id=\'encounterID\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\'hidden\' name=\'nursingunitcode\' id=\'nursingunitcode\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\'hidden\' name=\'bedno\' id=\'bedno\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\'hidden\' name=\'roomno\' id=\'roomno\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\t \n\t\t<input type=\'hidden\' name=\'admissiondatetime\' id=\'admissiondatetime\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=\'hidden\' name=\'admissiondatedisplay\' id=\'admissiondatedisplay\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\"hidden\" name=\"system_date_time\" id=\"system_date_time\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td><td class=\'fields\' width=\'25%\'><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" ><input type=\'text\' name=\'auth_pract_desc\' id=\'auth_pract_desc\'   value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" size=\'30\' maxlength=\'30\' onChange=\"getPractitionerLocal(practid,auth_pract_desc, \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\" onkeydown=\"shift_tab();\" tabindex = \'1\'><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerLocal(practid,auth_pract_desc, \'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');\" onkeydown=\"shift_tab();\" tabindex = \'2\'><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t</td>\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'expecteddischargedate\' id=\'expecteddischargedate\'  onKeyPress=\'return(ChkNumberInput1(this,event,2));\'  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" size=\'15\' maxlength=\'16\' onblur=\"DateValidations(this);compare_death_exptDisch();\" onkeydown=\"shift_tab();\" tabindex = \'3\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].expecteddischargedate.select();return showCalendar(\'expecteddischargedate\',null,\'hh:mm\');\" id=\"calendrGif\" tabindex = \'4\'><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' ></img>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n\t<tr> \n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td><td class=\'fields\' width=\'20%\'><SELECT name=\'dischargetype\' id=\'dischargetype\' onchange=\"callValidate(this.value);\" tabindex = \'5\' dir=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'><option value=\'\' selected>-----";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="-----\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<OPTION VALUE = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</OPTION>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t</SELECT><img src=\'../../eCommon/images/mandatory.gif\' align = \'center\'></img>\n\t<input type=\'hidden\' name=\'discharge_code\' id=\'discharge_code\' value= \"\"  >\n\t<input type=\'hidden\' name=\'dischage_indicator\' id=\'dischage_indicator\' value= \"\"  >\n\t</td>\n<!-- modified on 2/07/2008 for SCR 3228 -->\n\n\t<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<td class= \'label\' id=\'dislabel\' nowrap>\n\t<td class=\'fields\' width=\'3%\' nowrap>\n\t<input type=\"text\" name=\"discharge_to\"  id=\'distext\' style=\'display:none\' OnBlur=\'ChangeUpperCase(this);if(this.value != \"\") searchCode(discharge_to_value,this);\'><input type=\'button\' align=\'left\' name=\'discharge_to_value\' id=\'disbtn\' style=\'display:none\' value=\'?\' class=\'button\' onClick=\'searchCode(this,discharge_to)\'>\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t</td>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t<td class=\'label\' width=\'12%\' nowrap>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td><td class=\'fields\' width=\'20%\' ><SELECT name=\'dischargestatus\' id=\'dischargestatus\' onchange=\'capt_value(this)\' tabindex = \'6\' ><option value=\'\'>---";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="---\n\t\n\t</SELECT><img src=\'../../eCommon/images/mandatory.gif\' align = \'center\'></img>\n\t<input type=\'hidden\' name=\'discharge_status\' id=\'discharge_status\' value= \"\"  >\n\t<input type=\'hidden\' name=\'dischage_status_indicator\' id=\'dischage_status_indicator\' value= \"\"  >\n\t\n\t<td class=\'label\' id=\'deathlable\' nowrap></td>\n\t<td class=\'fields\'><input type=\'text\' name=\'death_date\' id=\"death_id\" style=\'visibility:hidden\' disabled onKeyPress=\'return(ChkNumberInput1(this,event,2));\' size=\'15\' maxlength=\'16\' onblur=\"validateDateTimes(this,\'A\');dayCareDateCheck(this);compare_death_exptDisch();\" tabindex = \'7\'><img name=\"calImage1\" src=\"../../eCommon/images/CommonCalendar.gif\" id=\'selcalimg\'  style=\'visibility:hidden\' onClick=\"calender();\" tabindex = \'8\'/><img id=\"deathimg\"align=\'center\' src=\'../../eCommon/images/mandatory.gif\'>\n\t<!--above one line is modified by venkatesh.s on 09/Aug/2012 against SS-SCF-0674 [IN:034278]-->\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<a href=\"javascript:getDeathRegFormAccessionNum(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',\'\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'IP\');\" id=\'deathRegFormLink\'  style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</a>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n</td>\n</tr>\n\n<!--Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505-->\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n<tbody id=\'AadharCardAndRel\' style=\'display:none\'>\n\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t<td class=\'fields\'><input type=\'text\' name=\'aadhar_card\' id=\'aadhar_card\' size=\'20\' maxlength=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' onKeyPress=\'return SpecialCharRestriction(event)\' onBlur=\'fnChkAlphaNumericForAadharCard(this,\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\");makeValidString(this);checkUniqueForAadharCard(this);\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t<td class=\'fields\'>\n\t\t\t<select name=\"relationship\" id=\"relationship\">\n\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="---</option>\n\t\t\t\t<option value=\"1\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</option>\n\t\t\t\t<option value=\"2\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</option>\n\t\t\t\t<option value=\"3\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</option>\n\t\t\t</select>\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t</td>\n\t</tr>\n</tbody>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n<!--End GHL-CRF-0505-->\n\n</table>\n\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t<td class=\'fields\'><textarea NAME=\"remarks\" ROWS=\"3\" COLS=\"70\" maxlength=\'200\' onBlur=\"checkForMaximum(this.value);\" tabindex = \'9\' style=\"resize: none;\"></textarea>\n\t\t</td>\n\t\t<td class=\'label\' id=\'postmortlable\'></td>\n\t<td class=\'fields\'><input type=\'checkbox\' style=\'visibility:hidden\' id=\'post_check\' name=\'post_mortem_request\' id=\'post_mortem_request\' value= \"Y\"></td>\n\t<input type=\'hidden\' name=\'dischgsumsigned\' id=\'dischgsumsigned\' value= \"N\"  >\n\n<div style=\'position:relative;dispaly:none\'>\n</div>\n\t</tr>\n</table>\n\n\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n<td colspan=\'6\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n<tr>\n<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n<!--end ML-MMOH-CRF-0354 [IN057191 -->\n<td  class=\'fields\'><INPUT TYPE=\"checkbox\" name=\"medico_legal\" id=\"medico_legal\" value=\"Y\" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="  onClick=\"getMedicoValues(this);enablePolice(this);\" onBlur=\'focusNext();\' tabindex = \'10\' ><input type=\'hidden\' name=\'dischgsumsigned\' id=\'dischgsumsigned\' value= \"N\" ></td>\n</tr>\n\n</table>\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n\t<tr height=\'1\'>\n\t\t<td width=\'25%\'> </td>\n\t\t<td width=\'25%\'> </td>\n\t\t<td width=\'25%\'> </td>\n\t\t<td width=\'25%\'> </td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t<td class=\'fields\' width=\'\' colspan=\'3\'><INPUT TYPE=\'text\' name=\'pol_rep_no\' id=\'pol_rep_no\' value= \"\" size=\'20\' maxlength=\'30\' tabindex = \'11\'>\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\'\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t<td class=\'fields\' width=\'\'><INPUT TYPE=\'text\' name=\'pol_stn_id\' id=\'pol_stn_id\' value=\"\" size=\'20\' maxlength=\'30\' tabindex = \'12\'>\n\t</td>\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t<td class=\'fields\'><INPUT TYPE=\'text\' name=\'pol_id\' id=\'pol_id\' onblur=\"focusNext()\" value=\"\" size=\'20\' maxlength=\'30\' tabindex = \'13\'>\n\t</td>\n</tr>\n</table>\n\n\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n<tr><td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td></tr>\n</table>\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\n<div id = \'ab_details\' style=\"visibility:hidden\">\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n<tr><td colspan=\'4\' class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n</div>\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n<!-- To Freeze  Above Form elements <div id=\"TestDiv\"> used and Display the Adaptive Menu <div id=TestDiv1> uesed -->\n<div  id=\'TestDiv\'  style=\"visibility:hidden;z-index:5;position:absolute;top:0px;width:100vw;height:600px;background-color:#CCCCCC;filter:alpha(opacity=80);\" >\n\t<!-- Construction Of Adaptive Menu Starts  -->\n\n\t<!--<div  id=\'TestDiv1\' style=\" z-index:2;position:absolute;top:";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="px;left:750px;width:190px;height:40px;visibility:hidden;filter:alpha(opacity=100);\" >\n\t\n\t<table width=\'100%\' height=\'100%\' style=\"background-color:black\" style=\"padding: 5px;\">\t-->\n\n\t<!--Modified by Ashwini on 02-Jul-2018 for ML-MMOH-CRF-1047-->\n\t<div  id=\'TestDiv1\' style=\" z-index:2;position:absolute;top:";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="px;left:400px;width:250px;height:100px;visibility:hidden;filter:alpha(opacity=100);border-style:solid;border-color:#5f5f5f;border-width:1px;\">\t\n\n\t\t<table width=\'100%\' height=\'100%\' style=\"background-color:#FFFFFF\" style=\"padding:5px;\">\t\t\n\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t<tr>\t\t\t\t\n\t\t\t\t\t\t<td id=\"TD";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" style=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" >\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;<img src=\'../../eCommon/images/tree_handlerightmiddle.gif\' align=\'center\'></img>&nbsp;&nbsp;<a href=\"javascript:ShowWindow(\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\');\" id=\'linkID";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' name=\"Regstr\" onkeydown=\"NextItem(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\');\" onmouseover=\"MouseClick(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\')\"  style=\'cursor:pointer\' > <font color=\"#000000\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</font></a>\n\t\t\t\t\t\t</td>\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t</table>\n\t</div>\n</div>\n<input type=\'hidden\' name=\"max_record\" id=\"max_record\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n<input type=\'hidden\' name=\"record_exists\" id=\"record_exists\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n<input type=\'hidden\' name=\"top\" id=\"top\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n<input type=\'hidden\' name=\"size\" id=\"size\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n<!-- \t<div  id=\'TestDiv1\' style=\" z-index:2;position:absolute;top:320px;left:750px;width:190px;visibility:hidden;filter:alpha(opacity=100);\" >\n\t\t<table width=\'100%\' style=\"background-color:#25383C\" style=\"padding: 5px;\">\n\t\t\t\n\t\t\t<tr><td id=\"Td1\" style=\"background-color:#595959\" ><a href=\"javascript:RegisterMoreReferral(\'encounterID\',\'patient_Id\');\" id=\'linkID\' name=\"Regstr\" onkeydown=\"NextItem(this);\" onmouseover=\"MouseClick(this)\"  style=\'cursor:pointer\' ><font color=\"white\">Register Refferal</font></a></td></tr>\n\t\t\t<tr><td id=\"Td2\" ><a href=\"#\" style=\'cursor:pointer\'  id=\'linkID1\' name=\"Order\" onkeydown=\"NextItem(this);\" onkeyup=\"PrevItem(this);\" onmouseover=\"MouseClick(this)\" ><font color=\"white\">Place Orders</font></a></td></tr>\n\t\t\t<tr><td id=\"Td3\" ><a href=\"#\" id=\'linkID2\' name=\"RcrdDiag\" onkeyup=\'PrevItem(this);\' onmouseover=\"MouseClick(this)\" style=\'cursor:pointer\' ><font color=\"white\">Record Diagnosis</font></a></td></tr>\n\t\t</table>\n\t</div> -->\n\n<!-- \t\t\t\t\t<ul style=\"margin: 0; padding: 0; list-style-type: none; list-style-image: none; \">\n\t\t\t\t\t\t<li style=\"padding: 5px;\"><font color=\'blue\'><a href=\"\" id=\'linkID\' name=\"Regstr\" onkeydown=\"NextItem(this);\" >Register Refferal</a></font></li>\n\t\t\t\t\t\t<li  style=\"padding: 5px;\"><font color=\'blue\'><a href=\"\" id=\'linkID1\' name=\"Order\" onkeydown=\"NextItem(this);\"  onkeyup=\"PrevItem(this);\">Place Orders</a></font></li>\n\t\t\t\t\t\t<li  style=\"padding: 5px;\"><font color=\'blue\'><a href=\"\" id=\'linkID2\' name=\"RcrdDiag\" onkeyup=\'PrevItem(this);\'>Record Diagnosis</a></font></li>\n\t\t\t\t\t</ul> -->\n<!-- \t\t\t\t\t<img src=\"C:\\Documents and Settings\\chiranjeevic\\Desktop\\MenuIcon.gif\"/>\n -->\t\t\n </div>\n<!-- <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR> -->\n <!-- <a name=\"tab2\" tabindex=\'0\' ></a> -->\n<!--<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\'>\n\t<tr>\n\t\t<td width=\'50%\' class=\'BODYCOLORFILLED\'><a align=\'left\' href=\"javascript:tab_click(\'other_details\')\" tabindex=\'-1\'><img  src=\"../../eIP/images/Discharge_click.gif\" border=0></a><a align=\'left\' href=\"javascript:tab_click(\'others_details\')\"><img  src=\"../../eIP/images/Other Details_click.gif\" border=0></a></td>\n\t</tr>\n</table>\t --> \n<div id = \'Other_Details\' style = \'display:none\'>\n<ul id=\"tablist\" class=\"tablist\">\n\t<li class=\"tablistitem\" title=\"Discharge Details\">\n\t\t<a class=\"tabA\" id=\"discDetails1\" >\n\t\t\t<span class=\"tabASpan\" id=\"firstkinspan\"  onClick=\'javascript:expandCollapse(\"Discharge_Details_tab\")\'>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</span>\n\t\t</a>\n\t</li>\n\t<li class=\"tablistitem\" title=\"Other Details\">\n\t\t<a class=\"tabClicked\" id=\"otherDetails1\" >\n\t\t\t<span class=\"tabSpanclicked\" id=\"firstkin1span\"  onClick=\'javascript:expandCollapse(\"Other_Details_tab\")\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</span>\n\t\t</a>\n\t</li>\n</ul>\n\n<!-- <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n\n<a name=\"tab3\" tabindex=\'0\' ></a>\n\n<ul id=\"tablist\" class=\"tablist\">\n\t<li class=\"tablistitem\" title=\"Discharge Details\">\n\t\t<a class=\"tabA\" id=\"discDetails\" >\n\t\t\t<span class=\"tabAspan\" id=\"firstkinspan\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</span>\n\t\t</a>\n\t</li>\n\t<li class=\"tablistitem\" title=\"Other Details\">\n\t\t<a class=\"tabClicked\" id=\"otherDetails\" >\n\t\t\t<span class=\"tabSpanclicked\" id=\"firstkin1span\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</span>\n\t\t</a>\n\t</li>\n</ul> -->\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n</div>\n\n<!-- <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR> -->\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t<!-- By Annadurai 11/5/2004  - for DC identification Starts-->\n\t<input type=\'hidden\' name=\'dead_yndt\' id=\'dead_yndt\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t<input type=\"hidden\" name=\"patient_class_value\" id=\"patient_class_value\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" >\n\t<input type=\"hidden\" name=\"target_date\" id=\"target_date\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" >\n\t<input type=\"hidden\" name=\"max_disch_period_for_dc\" id=\"max_disch_period_for_dc\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" >\n\t<!-- By Annadurai 11/5/2004  - for DC identification End-->\n\t<input type=\'hidden\' name=\'currdate\' id=\'currdate\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\'hidden\' name=\'dis_date_chk_days\' id=\'dis_date_chk_days\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<input type=\"hidden\" name=\"SickLeaveRecordFlag\" id=\"SickLeaveRecordFlag\" value=\"N\">\n\t<input type=\"hidden\" name=\"SickLeaveDetails\" id=\"SickLeaveDetails\" value=\"\">\n\t<input type=\"hidden\" name=\"SickLeaveDetails1\" id=\"SickLeaveDetails1\" value=\"\">\n\t<input type=\'hidden\' name=\'setup_bl_dtls_in_ip_yn\' id=\'setup_bl_dtls_in_ip_yn\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<input type=\'hidden\' name=\'is_ca_yn\' id=\'is_ca_yn\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t<input type=\'hidden\' name=\'SplCode\' id=\'SplCode\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t<input type=\'hidden\' name=\'close_val\' id=\'close_val\' value=\"N\">\n\t<input type=\'hidden\' name=\'patient_status\' id=\'patient_status\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t<input type=\'hidden\' name=\'absdate\' id=\'absdate\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t<input type=\'hidden\' name=\'locale1\' id=\'locale1\' value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\n\t<input type=\'hidden\' name=\'check_death_date\' id=\'check_death_date\' value=\"\">\n\t<input type=\"hidden\" name=\"hcare_setting_type_desc\" id=\"hcare_setting_type_desc\"  value =\'\' >\n\t<input type=\"hidden\" name=\"open_to_all_pract_yn\" id=\"open_to_all_pract_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t<input type=\"hidden\" name=\"practitioner_type\" id=\"practitioner_type\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t<input type=\"hidden\" name=\"curdateWithoutTime\" id=\"curdateWithoutTime\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'PREP_DISCH_ADVICE\'>\n\t<input type=\'hidden\' name=\"pat_dtls_unknown_yn\" id=\"pat_dtls_unknown_yn\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t<input type=\'hidden\' name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t<input type=\'hidden\' name=\"DOB\" id=\"DOB\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t<input type=\'hidden\' name=\"valid\" id=\"valid\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t<input type=\'hidden\' name=\"from_time\" id=\"from_time\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t<input type=\'hidden\' name=\"max_param_date\" id=\"max_param_date\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t<input type=\'hidden\' name=\"valid_date\" id=\"valid_date\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t<input type=\'hidden\' name=\"ip_Trn_Date\" id=\"ip_Trn_Date\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t<input type=\'hidden\' name=\"proceed\" id=\"proceed\" value=\"Y\">\n\t<input type=\'hidden\' name=\"query_string\" id=\"query_string\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t<input type=\'hidden\' name=\"practitionername\" id=\"practitionername\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t<input type=\'hidden\' name=\"bl_interfaced_yn\" id=\"bl_interfaced_yn\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t<input type=\'hidden\' name=\"bl_operational\" id=\"bl_operational\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t<input type=\'hidden\' name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t<input type=\"hidden\" name=\"pol_rep_no_db\" id=\"pol_rep_no_db\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t<input type=\"hidden\" name=\"pol_stn_id_db\" id=\"pol_stn_id_db\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t<input type=\"hidden\" name=\"pol_id_db\" id=\"pol_id_db\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t<input type=\"hidden\" name=\"modified_date_val\" id=\"modified_date_val\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start -->\n\t<input type=\"hidden\" name=\"weight_on_admission\" id=\"weight_on_admission\" value=\"\">\n\t<input type=\"hidden\" name=\"weight_on_admission_unit\" id=\"weight_on_admission_unit\" value=\"\">\n\t<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End -->\n\n\t<!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->\n\t<input type=\"hidden\" name=\"height_on_admission\" id=\"height_on_admission\" value=\"\">\n\t<input type=\"hidden\" name=\"height_on_admission_unit\" id=\"height_on_admission_unit\" value=\"\">\n\t<input type=\"hidden\" name=\"bmi\" id=\"bmi\" value=\"\"> \n\t<input type=\"hidden\" name=\"isHeightAndBmiEnable\" id=\"isHeightAndBmiEnable\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 End -->\n\n\n\t<!--Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505-->\n\t<input type=\"hidden\" name=\"isAadharCardAndRelAppl\" id=\"isAadharCardAndRelAppl\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t<input type=\"hidden\" name=\"citizen_yn\" id=\"citizen_yn\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t<input type=\"hidden\" name=\"alt_id4_type_desc\" id=\"alt_id4_type_desc\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\"hidden\" name=\"alt_id4_type\" id=\"alt_id4_type\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 08-08-2023  -->\n\t<input type=\"hidden\" name=\"isDeathRegisterFormAppl\" id=\"isDeathRegisterFormAppl\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\"hidden\" name=\"enable_death_reg_form\" id=\"enable_death_reg_form\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t<input type=\"hidden\" name=\"death_reg_form_accession_num\" id=\"death_reg_form_accession_num\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<input type =\'hidden\' name= \'callback_mode\' value=\"Add\">\n\t<!--End GHL-CRF-0505-->\n\t<!--Added by Kamatchi s for ML-MMOH-SCF-1643-->\n\t\t\t<input type=\'hidden\' name=\'weight_on_admission_load\' id=\'weight_on_admission_load\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'height_on_admission_load\' id=\'height_on_admission_load\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'bmi_load\' id=\'bmi_load\' value=\'\'>\n\t\n\t<script>document.forms[0].absconding_rep_to.value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\";</script>\n\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t<script>\n\t\t\talert(getMessage(\'BED_NOT_ASSIGNED\',\'IP\'));\n\t\t\tif(document.forms[0].is_ca_yn.value == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.location.href=\'../../eCommon/html/blank.html\';parent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';parent.frames[1].document.location.href = \'../../eCommon/html/blank.html\';parent.frames[3].document.location.href = \'../../eCommon/html/blank.html\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.window.close(); \n\t\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\n\n</form>\n\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t<script>\n\t\t\tdocument.forms[0].medico_legal.checked\t=\ttrue;\n\t\t\tdocument.forms[0].medico_legal.value\t=\t\"Y\";\n\t\t\tdocument.forms[0].medico_legal.disabled\t=\ttrue;\n\t\t</script>\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t<script>\n\t\t\t\tdocument.forms[0].pol_rep_no.disabled\t=\ttrue;\n\t\t\t\tdocument.forms[0].pol_stn_id.disabled\t=\ttrue;\n\t\t\t\tdocument.forms[0].pol_id.disabled\t\t=\ttrue;\n\t\t\t</script>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t<script>\n\t\tif(document.forms[0].medico_legal.checked == false)\n\t\t{\n\t\t\t\n\t\t\tdocument.forms[0].pol_rep_no.disabled\t=\ttrue;\n\t\t\tdocument.forms[0].pol_stn_id.disabled\t=\ttrue;\n\t\t\tdocument.forms[0].pol_id.disabled\t\t=\ttrue;\n\t\t}\n\t// End of addition on 4/25/2005 by Sridhar R ...\n\t</script>\n\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t<script>\n\t\t\tdocument.forms[0].absconding_yn.checked\t= true;\n\t\t\tdocument.forms[0].absconding_yn.disabled\t= true;\n\t\t\tdocument.forms[0].absconding_yn.value\t= \'Y\';\n\t\t\tdocument.getElementById(\"AbsImg\").style.visibility = \"Visible\";\n\t\t\tdocument.forms[0].absconding_date.disabled= true;\n\t\t\tdocument.getElementById(\"calImage\").disabled\t\t= true;\n\t\t    document.forms[0].absconding_rep_to.disabled\t= true;\n\t\t</script>\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t<script>\n\t\t\tdocument.forms[0].absconding_yn.checked\t= false;\n\t\t\tdocument.forms[0].absconding_yn.disabled\t= true;\n\t\t\tdocument.forms[0].absconding_yn.value\t\t= \'\';\n\t\t\tdocument.forms[0].absconding_date.disabled\t= true;\n\t\t\tdocument.forms[0].absconding_date.value\t\t= \'\';\n\t\t\tdocument.getElementById(\"AbsImg\").style.visibility\t\t= \"hidden\";\n\t\t\tdocument.getElementById(\"calImage\").disabled\t\t\t\t= true;\n\t\t\tdocument.forms[0].absconding_rep_to.disabled\t\t= true;\n\t\t\tdocument.forms[0].absconding_rep_to.value\t\t\t= \'\';\n\t\t</script>\n";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t<script>\n\t\t\tdocument.dischargeadvice_form.newmedicine.checked=false;\n\t\t\tdocument.dischargeadvice_form.newmedicine.disabled=true;\n\t\t\tdocument.dischargeadvice_form.stockmedicine.checked=false;\n\t\t\tdocument.dischargeadvice_form.stockmedicine.disabled=true;\n\t\t\tdocument.dischargeadvice_form.lab.checked=false;\n\t\t\tdocument.dischargeadvice_form.lab.disabled=true;\n\t\t\tdocument.dischargeadvice_form.xray.checked=false;\n\t\t\tdocument.dischargeadvice_form.xray.disabled=true;\n\t\t\tdocument.dischargeadvice_form.scan.checked=false;\n\t\t\tdocument.dischargeadvice_form.scan.disabled=true;\n\t\t\tdocument.dischargeadvice_form.ultrasound.checked=false;\n\t\t\tdocument.dischargeadvice_form.ultrasound.disabled=true;\n\t\t\tdocument.dischargeadvice_form.mri.checked=false;\n\t\t\tdocument.dischargeadvice_form.mri.disabled=true;\n\t\t\tdocument.dischargeadvice_form.rt.checked=false;\n\t\t\tdocument.dischargeadvice_form.rt.disabled=true;\n\t\t\tdocument.dischargeadvice_form.physio.checked=false;\n\t\t\tdocument.dischargeadvice_form.physio.disabled=true;\n\t\t\tdocument.dischargeadvice_form.ecg.checked=false;\n\t\t\tdocument.dischargeadvice_form.ecg.disabled=true;\n\t\t\tdocument.dischargeadvice_form.diet.checked=false;\n\t\t\tdocument.dischargeadvice_form.diet.disabled=true;\n\t\t\tdocument.dischargeadvice_form.pharmacy.disabled=true;\n\t\t</script>\n\t\t\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\n\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

// By Annadurai 12/5/2004  - To handle NullPointerException
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	String bl_operational	= (String)session.getValue("bl_operational");
	Connection con			=	null;
	Statement stmt			=	null;
	ResultSet rs			=	null;
	PreparedStatement pstmt		=	null;//Added by Ajay Hatwate for AAKH-CRF-0179
	String facilityID		= (String)session.getValue("facility_id");
	String patient_Id		= request.getParameter("patient_Id");
	String encounterID		= checkForNull(request.getParameter("EncounterId"));
	String is_ca_yn			= checkForNull(request.getParameter("is_ca_yn"));
    String chck_val			= checkForNull(request.getParameter("chck_val"));
    String function_id		= checkForNull(request.getParameter("function_id"));
	
	if(function_id.equals("")) function_id = "PRE_DIS_ADVICE";
	String dead_yn			= "";
	String informed_to		= "";
	String informed_name	= "";
	String informed_date	= "";
	String pol_rep_no		= "";	
	String pol_stn_id		= "";	
	String pol_id			= "";
	String absdate			= "";
	String reported_to		= "";
	int mother_cut_off_age	= 0;
	int mother_max_age		= 0;
	int maxrecord			=0;
	String pol_rep_no_vw	= "";
	String pol_stn_id_vw	= ""; 
	String pol_id_vw		= "";
	String mlc_yn			= "";
	String disabled_yn		= "N";
	String valid			= "";
	String from_time		= "";
	String max_param_date	= "";
	String valid_date		= "";
	String ip_Trn_Date		= "";	
	// By Annadurai 11/5/2004  - For DC module Starts
	
	/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
	boolean isAadharCardAndRelAppl = false;
	String citizen_yn = "";
	String aadhar_card_no = "";
	JSONObject AadharCardAndRelJson	= new JSONObject();
	String alt_id4_length = "";
	String alt_id4_alphanum_yn = "";
	String alt_id4_type_desc = "";
	String alt_id4_type = "";
	JSONObject AltIdLengthAndTypeJson = new JSONObject(); 
	/*End GHL-CRF-0505*/
	//Added by KAMATCHI S for ML-MMOH-CRF-1527 on 23-JUN-2020
	boolean isHeightAndBmiEnable =false;

	String target_date				= "";
	int max_disch_period_for_dc		= 0;
	String system_date_time			= "";
	String leave_exp_dt_flag		= "";
	String pat_dtls_unknown_yn		= "N";
	String setup_bl_dtls_in_ip_yn	= "N";
	int dis_date_chk_days			= 0;
	String	login_pract_id			= (String)session.getValue("ca_practitioner_id");
	String	login_pract_type		= "";
	String	login_pract_name		= "";
	String sql_adap					= "";
	String adap_func_ref			= "";
	String adap_func_name			= "";
	String adap_exec_name			= "";
	String bl_interfaced_yn			= "";
	boolean record_exists			= false;
	String contact1_name			= "";
	String contact2_name			= "";
	java.text.SimpleDateFormat dateFormat	=	new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt						=	new java.util.Date();
	String Sdate							=	dateFormat.format( dt ) ;
	Sdate	=	Sdate + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
	StringBuffer sqlSB = new StringBuffer();
	String admissiondatetime		= checkForNull(request.getParameter("admissiondatetime"));
	String admissiondatedisplay		= "" ;
	String practitionername			= checkForNull(request.getParameter("practitionername"));
	String bedno					= checkForNull(request.getParameter("bedno"));
	String roomno					= checkForNull(request.getParameter("roomno"));
	String practitioner_id			= checkForNull(request.getParameter("practitioner_id"));
	String spltycode				= checkForNull(request.getParameter("spltycode"));
	String nursingunitcode 			= checkForNull(request.getParameter("nursingunitcode"));
	String gender					= checkForNull(request.getParameter("gender"));
	String DOB						= checkForNull(request.getParameter("DOB"));
	String expdischargedatetime		= checkForNull(request.getParameter("expdischargedatetime"));
	String query_string				= checkForNull(request.getParameter("query_string"));
	String modified_date_val		= checkForNull(request.getParameter("modified_date_val"));
	String exp_date_display			= "";
	if(expdischargedatetime == null || expdischargedatetime.equals("null"))
	{
		exp_date_display = "&nbsp;";
	}else
	{
		exp_date_display			= DateUtils.convertDate(expdischargedatetime,"DMYHM","en",locale);
	}
	if(admissiondatetime == null || admissiondatetime.equals("null"))
	{
		admissiondatedisplay = "&nbsp;";
	}else
	{
		admissiondatedisplay		= DateUtils.convertDate(admissiondatetime,"DMYHM","en",locale);
	}
	String patient_class			= checkForNull(request.getParameter("patient_class"));
	String patient_status			= checkForNull(request.getParameter("patient_status"));
	leave_exp_dt_flag				= checkForNull(request.getParameter("leave_exp_dt_flag"),"N");
	int patient_age = 0;
	String patient_age_str			= checkForNull(request.getParameter("patient_age"));
	if(!patient_age_str.equals(""))
	{
			patient_age = Integer.parseInt(patient_age_str);
	}
// added for sathya sai migrated Wednesday, June 09, 2010 Venkat S
	String max_disch_period_for_predc=request.getParameter("max_disch_period_for_predc");
		if((max_disch_period_for_predc==null || max_disch_period_for_predc.equals("")))
		max_disch_period_for_predc ="0";
	String mother_cut_off_age_pda=request.getParameter("mother_cut_off_age_pda");
		if((mother_cut_off_age_pda==null || mother_cut_off_age_pda.equals("")))
		mother_cut_off_age_pda ="0";
	String mother_max_age_pda=request.getParameter("mother_max_age_pda");
		if((mother_max_age_pda==null || mother_max_age_pda.equals("")))
		mother_max_age_pda ="0";
	
	//Added by Ajay Hatwate for AAKH-CRF-0179 on 07/08/2023
	Boolean isDeathRegisterFormAppl = false;
	String enable_death_reg_form = "N";
	String death_reg_form_accession_num = "";
	//End of AAKH-CRF-0179
	try
	{
		con = ConnectionManager.getConnection(request);
		/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
		boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
		/*end ML-MMOH-CRF-0354 [IN057191] */

		isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "DEATH_REGISTER_FORM_APPL"); //Added by Ajay Hatwate for AAKH-CRF-0179 on 08-08-2023
		
		enable_death_reg_form = eMP.MPCommonBean.getEnableDeathRegisterFormYN(con);
	
		
		isHeightAndBmiEnable	= eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
		/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
		isAadharCardAndRelAppl	=	eCommon.Common.CommonBean.isSiteSpecific(con, "IP","AADHAR_CARD_RELATIONSHIP"); 

		AadharCardAndRelJson	=	eIP.IPCommonBean.getAadharCardAndRel(con, patient_Id);
		citizen_yn				=	(String)AadharCardAndRelJson.get("citizen_yn");
		aadhar_card_no			=	(String)AadharCardAndRelJson.get("aadhar_card_no");

		AltIdLengthAndTypeJson	=	eIP.IPCommonBean.getAltIdLengthAndType(con);
		alt_id4_length			=	(String)AltIdLengthAndTypeJson.get("alt_id4_length");
		alt_id4_alphanum_yn		=	(String)AltIdLengthAndTypeJson.get("alt_id4_alphanum_yn");
		alt_id4_type_desc		=	(String)AltIdLengthAndTypeJson.get("alt_id4_type_desc");
		alt_id4_type			=	(String)AltIdLengthAndTypeJson.get("alt_id4_type");
		/*End GHL-CRF-0505*/

		stmt=con.createStatement();
		if(isDeathRegisterFormAppl){
			if (sqlSB.length() > 0)
			{
				sqlSB.delete(0, sqlSB.length());
			}

			if(enable_death_reg_form.equals("Y")){
				if (sqlSB.length() > 0)
				{
					sqlSB.delete(0, sqlSB.length());
				}
				sqlSB.append(" SELECT death_reg_form_accession_num FROM PR_ENCOUNTER WHERE FACILITY_ID=? and ENCOUNTER_ID = ?");
				pstmt = con.prepareStatement(sqlSB.toString());
				pstmt.setString(1, facilityID);
				pstmt.setString(2, encounterID);
				rs		= pstmt.executeQuery();
				if ((rs != null) && (rs.next())){
					death_reg_form_accession_num	=	checkForNull(rs.getString("death_reg_form_accession_num"));
				}
			}
		}
		/*sqlSB.append(" Select dis_date_chk_days, dis_date_chk_days_unit, to_char(sysdate - decode( dis_date_chk_days_unit,'H', dis_date_chk_days/24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date, setup_bl_dtls_in_ip_yn, max_disch_period_for_dc,bl_interfaced_yn from IP_PARAM where facility_id='"+facilityID+"' ");
		rs		=	stmt.executeQuery(sqlSB.toString());
		if(rs!=null )
		{
			while(rs.next())
			{
				setup_bl_dtls_in_ip_yn	= rs.getString("setup_bl_dtls_in_ip_yn");
				Sdate					= rs.getString("allow_discharge_date");
				max_disch_period_for_dc	= rs.getInt("max_disch_period_for_dc"); 
				bl_interfaced_yn		= rs.getString("bl_interfaced_yn"); 
			}
		}
		if (rs != null)		rs.close();
		*/
		/* Added For PE On 5/5/2010 
			Above Query was commented and the values are getting from the Result page from same IP Param table
		*/	
		setup_bl_dtls_in_ip_yn	= checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"));
		Sdate					= checkForNull(request.getParameter("allow_discharge_date_predc"));
		try{
			max_disch_period_for_dc = Integer.parseInt(request.getParameter("max_disch_period_for_predc")==null?"0":request.getParameter("max_disch_period_for_predc"));

		}catch (Exception e) {

			out.println(e.toString());
			e.printStackTrace();
		}
		bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"));		 
		// added for sathya sai migrated Wednesday, June 09, 2010 Venkat S mother_cut_off_age = Integer.parseInt(request.getParameter("mother_cut_off_age_pda")==null?"0":request.getParameter("mother_cut_off_age_pda"));
		//mother_max_age			= Integer.parseInt(request.getParameter("mother_max_age_pda")==null?"0":request.getParameter("mother_max_age_pda"));
		mother_cut_off_age			= Integer.parseInt(mother_cut_off_age_pda);
		mother_max_age				= Integer.parseInt(mother_max_age_pda);
		pat_dtls_unknown_yn		= checkForNull(request.getParameter("pat_dtls_unknown_yn_pda"));
		contact1_name			= checkForNull(request.getParameter("contact1_name_pda"));
		contact2_name			= checkForNull(request.getParameter("contact2_name_pda"));
		disabled_yn				= checkForNull(request.getParameter("disabled_yn"));
		mlc_yn					= checkForNull(request.getParameter("mlc_yn"));
		pol_rep_no_vw			= checkForNull(request.getParameter("pol_rep_no"));
		pol_stn_id_vw			= checkForNull(request.getParameter("pol_stn_id"));
		pol_id_vw				= checkForNull(request.getParameter("pol_id"));
		String bmi= checkForNull(request.getParameter("bmi")); /*Added by KAMATCHI S on 23-JUN-2020 foR ML-MMOH-CRF-1527*/
		if (sqlSB.length() > 0)
		{
			sqlSB.delete(0, sqlSB.length());
		}
		sqlSB.append(" select to_char(absconding_date,'dd/mm/rrrr HH24:mi') absconding_date, reported_to, pol_rep_no, pol_stn_id, pol_id, informed_to, informed_name, to_char (informed_date_time, 'dd/mm/rrrr hh24:mi')informed_date_time from IP_LEAVE_DETAIL where facility_id = '"+facilityID+"' and encounter_id = '"+encounterID+"' and leave_status='"+patient_status+"' order by srl_no desc ");
		rs		= stmt.executeQuery(sqlSB.toString());
		if ((rs != null) && (rs.next())){
			informed_to			=	checkForNull(rs.getString("INFORMED_TO"));
			informed_name		=	checkForNull(rs.getString("INFORMED_NAME"));
			informed_date		=	checkForNull(rs.getString("INFORMED_DATE_TIME"));
			if(patient_status.equals("4"))
			{
				reported_to		=	checkForNull(rs.getString("reported_to"));
				absdate			=	checkForNull(rs.getString("ABSCONDING_DATE"));
				pol_rep_no		=	checkForNull(rs.getString("POL_REP_NO"));
				pol_stn_id		=	checkForNull(rs.getString("POL_STN_ID"));
				pol_id			=	checkForNull(rs.getString("POL_ID"));
			}
		}
		if(mlc_yn.equals("Y"))
		{
			if(pol_rep_no.equals("") && pol_stn_id.equals("") && pol_id.equals(""))
			{
				if(!pol_rep_no_vw.equals("") || !pol_stn_id_vw.equals("") || !pol_id_vw.equals(""))
				{
					pol_rep_no	= pol_rep_no_vw ;
					pol_stn_id	= pol_stn_id_vw ; 
					pol_id		= pol_id_vw ;
					disabled_yn = "Y";
				}
			}
		}
		if (rs != null)		rs.close();
		if (sqlSB.length() > 0){sqlSB.delete(0, sqlSB.length());}

		if(patient_class.equals("DC"))
		{
				/* Commented and merged with below query for PE on 10/05/2010

				sqlSB.append(" select to_char((sysdate+");
				sqlSB.append(max_disch_period_for_dc);
				sqlSB.append("/24),'dd/mm/rrrr hh24:mi') target_date, to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(sysdate,'dd/mm/rrrr') system_date from DUAL ");
				rs		= stmt.executeQuery(sqlSB.toString());
				if ((rs != null) && (rs.next())){
					target_date				= rs.getString("target_date");
					system_date_time	= rs.getString("system_date_time");
				}
				if (sqlSB.length() > 0){sqlSB.delete(0, sqlSB.length());}
				if (rs!=null) rs.close();*/
				sqlSB.append(" select to_char((sysdate+");
				sqlSB.append(max_disch_period_for_dc);
				sqlSB.append("/24),'dd/mm/rrrr hh24:mi') target_date,"); 
				
				/* This query commented by Venkatesh.S on 30-Aug-2012 against SS-SCF-0674 [IN:034278] */
				
				/*sqlSB.append("  to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(sysdate,'dd/mm/rrrr') system_date, TO_CHAR((SELECT MAX (trn_date_time) FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ), 'dd/mm/rrrr hh24:mi') FROM_TIME, TO_CHAR(TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE, (CASE WHEN TRUNC (TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID, TO_CHAR((CASE WHEN TRUNC (  TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE('"+admissiondatetime+"', 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE  from dual" );*/
				
				/* In Below query  last two lines only added by Venkatesh.S against SS-SCF-0674 [IN:034278]  on 30-Aug-2012 to get recent trn_date_time */
				
				sqlSB.append("  to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(sysdate,'dd/mm/rrrr') system_date, TO_CHAR((SELECT MAX (trn_date_time) FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ), 'dd/mm/rrrr hh24:mi') FROM_TIME, TO_CHAR(TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE, (CASE WHEN TRUNC (TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID, TO_CHAR((CASE WHEN TRUNC (  TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE('"+admissiondatetime+"', 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE('"+admissiondatetime+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE , TO_CHAR((SELECT MAX (trn_date_time) FROM ip_adt_trn WHERE facility_id='"+facilityID+"' AND encounter_id ='"+encounterID+"'),'dd/mm/rrrr hh24:mi') ip_trn_date from dual" );
				
				
				rs		= stmt.executeQuery(sqlSB.toString());
				if ((rs != null) && (rs.next())){
					valid			 = rs.getString("VALID");
					from_time		 = rs.getString("FROM_TIME");
					max_param_date	 = rs.getString("MAX_PARAM_DATE");
					valid_date		 = rs.getString("VALID_DATE");
					valid_date		 = DateUtils.convertDate(valid_date,"DMY","en",locale);
					target_date		 = rs.getString("target_date");
					system_date_time = rs.getString("system_date_time");
					
					/* Below one line added by Venkatesh.S on 30-Aug-2012 against SS-SCF-0674 [IN:034278] */
					ip_Trn_Date       =rs.getString("ip_trn_date");
					
				}
				//valid_date = valid_date+ " 23:59";
				valid_date = max_param_date; //Modified for AAKH-SCF-0093
		}
		if(patient_class.equals("IP"))
		{
				if (sqlSB.length() > 0){sqlSB.delete(0, sqlSB.length());}
				sqlSB.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(MAX(trn_date_time),'dd/mm/rrrr hh24:mi') ip_trn_date FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ");
				rs		= stmt.executeQuery(sqlSB.toString());
				if ((rs != null) && (rs.next())){
					ip_Trn_Date		= rs.getString("ip_Trn_Date");
					system_date_time= rs.getString("system_date_time");
				}
				if (rs!=null) rs.close();
		}
		
		if (rs!=null) rs.close();
		/*Thursday, May 06, 2010 , IN021214*/
		/*
		if(!( system_date_time==null || system_date_time.equals("")))
			system_date_time_display=DateUtils.convertDate(system_date_time,"DMYHM","en",locale);
			*/
		// By Annadurai 11/5/2004 - For Day Care Issues end.
		if (sqlSB.length() > 0){sqlSB.delete(0, sqlSB.length());}
		/*
			Commented On 5/5/2010 for PE both Quries are merged to Single @ line 311.
		*/
		/*
		sqlSB.append("select pat_dtls_unknown_yn from MP_PATIENT where patient_id = '");
		sqlSB.append(patient_Id);
		sqlSB.append("' ");
		rs	 = stmt.executeQuery(sqlSB.toString());
		if ((rs != null) && (rs.next())){
		pat_dtls_unknown_yn	= rs.getString("pat_dtls_unknown_yn");
		}
		if (rs!=null) rs.close();
		if (sqlSB.length() > 0)	sqlSB.delete(0, sqlSB.length()); 
		sqlSB.append( "select nb_mother_cutoff_age mother_cut_off_age, nb_mother_upper_age mother_max_age from MP_PARAM" );
        
		rs		= stmt.executeQuery(sqlSB.toString());

		if ((rs != null) && (rs.next()))
		{
		mother_cut_off_age	= rs.getInt("mother_cut_off_age");
		mother_max_age		= rs.getInt("mother_max_age");
		}
		sqlSB.append(" SELECT A.PAT_DTLS_UNKNOWN_YN,B.CONTACT1_NAME,B.CONTACT2_NAME FROM MP_PATIENT A ,MP_PAT_REL_CONTACTS B WHERE A.PATIENT_ID = '"+patient_Id+"' AND A.PATIENT_ID=B.PATIENT_ID");
		rs		= stmt.executeQuery(sqlSB.toString());
		while(rs.next()){
			pat_dtls_unknown_yn	= rs.getString("PAT_DTLS_UNKNOWN_YN");
//			mother_cut_off_age	 	= rs.getInt("MOTHER_CUT_OFF_AGE");
//			mother_max_age			= rs.getInt("MOTHER_MAX_AGE");
			contact1_name				= checkForNull(rs.getString("CONTACT1_NAME"));
			contact2_name				= checkForNull(rs.getString("CONTACT2_NAME"));

		}
		if (rs!=null) rs.close();*/
		if(is_ca_yn.equals(""))
			login_pract_id = practitioner_id;

			if (sqlSB.length() > 0)
			sqlSB.delete(0, sqlSB.length()); 
			sqlSB.append( " select pract_type, practitioner_name from AM_PRACTITIONER_LANG_VW where practitioner_id = '"+login_pract_id+"' and language_id = '"+locale+"' ");
			rs		= stmt.executeQuery(sqlSB.toString());
			if ((rs != null) && (rs.next())){
				login_pract_type	= rs.getString("pract_type");
				login_pract_name	= rs.getString("practitioner_name");
			}
			if(login_pract_type.equals("MD") || login_pract_type.equals("PS") ||login_pract_type.equals("SG") || login_pract_type.equals("DN")){
				practitioner_id = login_pract_id;
				practitionername = login_pract_name;
			}
			if (rs!=null) rs.close();
		/*
		COMMENTED ON 5/5/2010  THE QUERY WAS MERGED @LINE 311 
		try{
			mp_pat_rel_contacts.append(" select contact1_name,contact2_name from mp_pat_rel_contacts where patient_id ='"+patient_Id+"' ");
			//stmt = con.createStatement();    
			rs = stmt.executeQuery(mp_pat_rel_contacts.toString());

				if(rs != null && rs.next())
				{
					contact1_name	=	checkForNull(rs.getString("contact1_name"));
					contact2_name	=	checkForNull(rs.getString("contact2_name"));
				}
		}
		catch(Exception e)
		{
			out.println("Exception in getting mp_pat_rel_contacts:"+e.toString());
		}	
		if(rs !=null) rs.close(); //if(stmt != null) stmt.close();
		if (mp_pat_rel_contacts.length() > 0)
				mp_pat_rel_contacts.delete(0, mp_pat_rel_contacts.length());
	 */
			
			/*Added Below Line code for [AK-SCF-0153] by Senthil */
			String language_direction="";
			int count=0;
			stmt=con.createStatement() ;
			//preparedStatement pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			
		   rs = stmt.executeQuery("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID='"+locale+"'" ) ;
				 
			 if ( rs != null && rs.next() ) 
			 {
			 count = rs.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "RTL" ;
			}else
			{
				 language_direction = "LTR" ;
			}
			
			if(rs!=null)rs.close();
			/*Added Above Line code for [AK-SCF-0153] by Senthil */

            _bw.write(_wl_block9Bytes, _wl_block9);
if(isHeightAndBmiEnable){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedno));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(admissiondatetime));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(admissiondatedisplay));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(system_date_time));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitionername));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(exp_date_display));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
/*"dir" Added Above Line code for [AK-SCF-0153] by Senthil */

			StringBuffer dischgtype_Sql	=new StringBuffer();
		dischgtype_Sql.append("SELECT deceased_yn, discharge_type_code||'='||indicator  discharge_type_code , short_desc from "); 
		dischgtype_Sql.append(" IP_DISCHARGE_TYPE_LANG_VW where language_id = '"+locale+"' and eff_status='E' ");

		if(pat_dtls_unknown_yn.equals("Y"))
			dischgtype_Sql.append(" and ( indicator in('DS','ED') ");
		else if(!patient_status.equals("3") && !patient_status.equals("4") && leave_exp_dt_flag.equals("Y"))
			dischgtype_Sql.append(" and ( indicator in('AB','AO','DS') ");
		else if(patient_status.equals("1") && leave_exp_dt_flag.equals("Y"))
			dischgtype_Sql.append(" and ( indicator in('AB','AO') ");
		else if(patient_status.equals("1") && leave_exp_dt_flag.equals("N"))
			dischgtype_Sql.append(" and ( indicator not in('NS','LE') ");
		else if(patient_status.equals("3"))
			dischgtype_Sql.append(" and ( indicator in('AB','AO','DS') ");
		else if(patient_status.equals("4"))
			dischgtype_Sql.append(" and ( indicator in('AB','AO','DS') ");
		else
			dischgtype_Sql.append(" and ( indicator not in('NS','LE') ");

		if(gender.equals("F")) // gender specific indicators..
		{		
			if((patient_age >= mother_cut_off_age)&&(patient_age <= mother_max_age))
			{
				dischgtype_Sql.append(" or maternal_death_yn = 'Y' ) ");
			}
			else
			{
				dischgtype_Sql.append(" and maternal_death_yn = 'N' ) ");
			}
		}
		else
		{
			dischgtype_Sql.append(" and maternal_death_yn = 'N' ) ");
		}
		
			dischgtype_Sql.append(" order by short_desc");
		String disCode="";
		String disDesc="";	
     	
		rs= stmt.executeQuery(dischgtype_Sql.toString());
		if(rs!= null)
		{
			while(rs.next())
			{
				disCode = checkForNull(rs.getString("discharge_type_code"));
				disDesc = checkForNull(rs.getString("short_desc"));
		
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disCode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disDesc));
            _bw.write(_wl_block34Bytes, _wl_block34);
	}
		}
		if (rs!=null) rs.close();

            _bw.write(_wl_block35Bytes, _wl_block35);
if(isHeightAndBmiEnable){
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
/*"dir" Added Above Line code for this SCF[AK-SCF-0153]*/
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y")){ 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(admissiondatetime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(spltycode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(death_reg_form_accession_num));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
if(isAadharCardAndRelAppl && citizen_yn.equals("Y") && (!("").equals(alt_id4_type))){
	
	String aadhar_card_en_dis = "";

	if(!aadhar_card_no.equals("")) {
		aadhar_card_en_dis = "disabled";
	}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(alt_id4_type_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(aadhar_card_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(alt_id4_alphanum_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(aadhar_card_en_dis));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
if(siteSpecific){
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
}else{
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(chck_val));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            {java.lang.String __page ="../../eIP/jsp/InformedDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("called_from"), weblogic.utils.StringUtils.valueOf("Discharge_Advice")},{ weblogic.utils.StringUtils.valueOf("informed_to"), weblogic.utils.StringUtils.valueOf(informed_to
                        )},{ weblogic.utils.StringUtils.valueOf("informed_name"), weblogic.utils.StringUtils.valueOf(informed_name
                        )},{ weblogic.utils.StringUtils.valueOf("informed_date_time"), weblogic.utils.StringUtils.valueOf(informed_date
                        )},{ weblogic.utils.StringUtils.valueOf("admissiondatetime"), weblogic.utils.StringUtils.valueOf(admissiondatetime
                        )},{ weblogic.utils.StringUtils.valueOf("encounterID"), weblogic.utils.StringUtils.valueOf(encounterID
                        )},{ weblogic.utils.StringUtils.valueOf("system_date_time"), weblogic.utils.StringUtils.valueOf(system_date_time
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            {java.lang.String __page ="../../eIP/jsp/AbscondingDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("Discharge_Advice")},{ weblogic.utils.StringUtils.valueOf("absconded_date"), weblogic.utils.StringUtils.valueOf(absdate
                        )},{ weblogic.utils.StringUtils.valueOf("reported_to"), weblogic.utils.StringUtils.valueOf(reported_to
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block72Bytes, _wl_block72);
	
int size = 0;
HashMap data_map		 = new HashMap();
HashMap result_map    = new HashMap();
HashMap records_map =null;
/*Commented On 5/5/2010 for PE 
	The same tables are getting called twice one for count and data.
*/
//String sql_adap_cnt = "select count(*) from SM_QUICK_LINK_ADPT_MNU_DTL a,SM_QUICK_LINK_ADPT_MNU b where a.L_ADPT_FUNCTION_REF=b.ADPT_FUNCTION_REF AND A.S_ADPT_FUNCTION_REF='IP_PRE_DIS_ADVICE' AND a.EFF_STATUS='E' ORDER BY A.DISPLAY_ORDER ";
 sql_adap="select a.L_ADPT_FUNCTION_REF,b.ADPT_FUNCTION_NAME,b.ADPT_EXECUTABLE_NAME from SM_QUICK_LINK_ADPT_MNU_DTL a,SM_QUICK_LINK_ADPT_MNU b where a.L_ADPT_FUNCTION_REF=b.ADPT_FUNCTION_REF AND A.S_ADPT_FUNCTION_REF='IP_PRE_DIS_ADVICE' AND a.EFF_STATUS='E' ORDER BY A.DISPLAY_ORDER desc";
 rs= stmt.executeQuery(sql_adap);
 int key=0;
while(rs.next()){
	records_map =new HashMap();
	String adpt_function_ref		= rs.getString(1);
	String adpt_function_name	 = rs.getString(2);
	String adpt_executable_name= rs.getString(3);
	records_map.put("L_ADPT_FUNCTION_REF",adpt_function_ref);
	records_map.put("ADPT_FUNCTION_NAME",adpt_function_name);
	records_map.put("ADPT_EXECUTABLE_NAME",adpt_executable_name);
	data_map.put(key,records_map);
	key++;
}
if(rs != null) rs.close ();
size = data_map.size();

//Modified by Ashwini on 02-Jul-2018 for ML-MMOH-CRF-1047
int top=5;
/*
int top=0;
if(is_ca_yn  == "Y" || is_ca_yn.equals("Y")){
	top=350;
}else{
	top=360;
}
if(size>2){
	for(int j=3;j<=size;j++){
		top=top-20;
	}
}*/
 /*sql_adap="select a.L_ADPT_FUNCTION_REF,b.ADPT_FUNCTION_NAME,b.ADPT_EXECUTABLE_NAME from SM_QUICK_LINK_ADPT_MNU_DTL a,SM_QUICK_LINK_ADPT_MNU b where a.L_ADPT_FUNCTION_REF=b.ADPT_FUNCTION_REF AND A.S_ADPT_FUNCTION_REF='IP_PRE_DIS_ADVICE' AND a.EFF_STATUS='E' ORDER BY A.DISPLAY_ORDER desc";
 rs= stmt.executeQuery(sql_adap);*/

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(top));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(top));
            _bw.write(_wl_block75Bytes, _wl_block75);
		
			int i=0;	
			String bg_color="";
				for(int kk=0;kk<data_map.size();kk++){
					maxrecord++;
					record_exists=true;
					result_map=(HashMap)data_map.get(kk);
					adap_func_ref		= (String)result_map.get("L_ADPT_FUNCTION_REF");
					adap_func_name	= (String)result_map.get("ADPT_FUNCTION_NAME");
					adap_exec_name	= (String)result_map.get("ADPT_EXECUTABLE_NAME");
					if(i==size-1){
						//Modified by Ashwini on 02-Jul-2018 for ML-MMOH-CRF-1047
						//bg_color="background-color:#595959";
						bg_color="background-color:#ebebeb";
					}
					
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bg_color));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(adap_func_ref));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(adap_exec_name));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(adap_func_name));
            _bw.write(_wl_block83Bytes, _wl_block83);
 i++;
				}
		
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(record_exists));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(top));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(size));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            {java.lang.String __page ="../../eIP/jsp/AddModifyDischargeAdvTabs1.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block93Bytes, _wl_block93);

	if(setup_bl_dtls_in_ip_yn.equals("Y"))
		out.println("<Script>if(document.getElementById('bl_field')){document.getElementById('bl_field').style.visibility='visible';}</Script>");

	if(stmt	!=	null) stmt.close();
	if(rs!= null) rs.close();

	}catch(Exception e) 
	{
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
	

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(dead_yn));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(target_date));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(Sdate));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(dis_date_chk_days));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(is_ca_yn));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(spltycode));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(patient_status));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(absdate));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(login_pract_type));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(Sdate));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(pat_dtls_unknown_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(DOB));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(contact1_name));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(contact2_name));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(valid));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(max_param_date));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(valid_date));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(ip_Trn_Date));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(practitionername));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(pol_rep_no));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(pol_stn_id));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(pol_id));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(modified_date_val));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(isHeightAndBmiEnable));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(isAadharCardAndRelAppl));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(citizen_yn));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(alt_id4_type_desc));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(alt_id4_type));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(isDeathRegisterFormAppl));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(enable_death_reg_form));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(death_reg_form_accession_num));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(reported_to));
            _bw.write(_wl_block140Bytes, _wl_block140);
	if(bedno.equals(""))
	{	
            _bw.write(_wl_block141Bytes, _wl_block141);
	}	
            _bw.write(_wl_block142Bytes, _wl_block142);
	
	/// Added by Sridhar R on 4/25/2005 - will validate MLC details based on values fetched from ip_open_encounter table...
	if(mlc_yn.equals("Y"))
	{	
            _bw.write(_wl_block143Bytes, _wl_block143);
	}

	if(disabled_yn.equals("Y"))
	{
		if(!pol_rep_no_vw.equals("") || !pol_stn_id_vw.equals("") || !pol_id_vw.equals(""))
		{	
			
            _bw.write(_wl_block144Bytes, _wl_block144);
		}
	}

            _bw.write(_wl_block145Bytes, _wl_block145);
	

	if(patient_status.equals("4"))
	{	
            _bw.write(_wl_block146Bytes, _wl_block146);
	}	

	if(patient_status.equals("3"))
	{	
            _bw.write(_wl_block147Bytes, _wl_block147);
	}
		

	if(patient_status.equals("3") || patient_status.equals("4"))
	{	
            _bw.write(_wl_block148Bytes, _wl_block148);
	}	
	out.println("<script>document.forms[0].absconding_date.disabled= true;</script>");

            _bw.write(_wl_block149Bytes, _wl_block149);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargeAdvice.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeDetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuthorizingPractitioner.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectedDischargeDateTime.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargetype.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeStatus.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DeathRegForm.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.self.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Attendant.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Spouse.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlcdetails.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceReportNo.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.station.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.InformedDetails.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AbscondingDetails.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeDetails.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeDetails.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }
}
