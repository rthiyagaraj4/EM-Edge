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
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __repaeatttoemgydeptform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/repAEAtttoEmgyDeptForm.jsp", 1743671141468L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\t\n<HEAD>\n<TITLE></TITLE>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\n\t<script src=\"../../eMR/js/MRReports.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nfunction ValidString(event)\n{\n\tif((((event.keyCode>=48) && (event.keyCode<=57))\n\t\t||((event.keyCode>=65) && (event.keyCode<=90))\n\t\t||((event.keyCode>=97) && (event.keyCode<=122))\n\t\t||(event.keyCode==42)||(event.keyCode==95)))\n\t{\n\t\treturn true\n\t}\n\telse\n\t{\t\n\t\treturn false\n\t}\n}\n\nasync function searchCode1(obj,target)\n\t\t{\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"80vh\" ;\n\t\t\tvar dialogWidth\t= \"60vw\" ;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar sql=\"\";\n\t\t\tvar search_code=\"\";\n\t\t\tvar search_desc=\"\";\n\t\t\tvar tit=\"\";\n\t\t\tvar facility = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\n\t\t\tif (obj.name == \"clinic\") \n\t\t\t{\n\t\t\t\ttit=getLabel(\"Common.emergency.label\",\"Common\")+\' \'+getLabel(\"Common.clinic.label\",\"Common\");\n\t\t\t\tsql=\"select clinic_code, long_desc from op_clinic where facility_id=`\"+facility+\"` and CARE_LOCN_TYPE_IND=`C` and LEVEL_OF_CARE_IND=`E`\"; \n\t\t\t\tsearch_code=\"clinic_code\";\n\t\t\t\tsearch_desc= \"long_desc\";\n\t\t\t}\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\tretVal = await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit),arguments,features);\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\ttarget.value=retVal;\n\t\t\t}\n\t\t\telse\n\t\t\t\ttarget.focus();\n\t}\n\n/*Added by Ashwini on 03-Sep-2020 for ML-MMOH-CRF-1351*/\nasync function searchCodeClinicLoc(obj,target)\n{  \n\tvar facility = document.forms[0].p_facility_id.value;\n\tvar retVal = new String();\n\tvar dialogHeight = \"80vh\" ;\n\tvar dialogWidth\t= \"60vw\" ;\n\tvar status = \"no\";\n\tvar arguments = \"\" ;\n\tvar sql = \"\";\n\tvar search_code = \"\";\n\tvar search_desc = \"\";\n\tvar tit = \"\";\n\t\n\tif(obj.value==\"ED\")\n\t{\n\t\ttit=getLabel(\"eMR.EmergencyDepartment.label\",\"MR\");\n\n\t\tsql=\"SELECT a.clinic_code, b.short_desc FROM mr_rep_op_attend_zone_catg a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `\"+facility+\"` and a.service_code = `ED`\";\t\t\t\t\t\t\n\t\t\n\t\tsearch_code=\"a.clinic_code\";\n\t\tsearch_desc= \"b.short_desc\";\n\t}\n\telse\n\t{\n\t\ttit=getLabel(\"Common.Observation.label\",\"Common\");\n\t\t\n\t\tsql=\"SELECT a.clinic_code, b.short_desc FROM mr_rep_op_attend_zone_catg a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `\"+facility+\"` and a.service_code = `OB`\";\n\t\t\t\t\t\t\n\t\tsearch_code=\"a.clinic_code\";\n\t\tsearch_desc= \"b.short_desc\";\n\t}\n\n\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\n\tretVal = await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit),arguments,features);\n\n\tif (!(retVal == null))\n\t{\n\t\ttarget.value = retVal;\n\t}\n\telse\n\t\ttarget.focus();\n}\n/*End ML-MMOH-CRF-1351*/\n\nfunction clearList(objSelect)\n{\n\tvar length = objSelect.options.length;\n\tfor(var index = 1 ;index < length ;index++)\n\t{\n\t\tobjSelect.remove(1)\n\t}\n}\n\nfunction repAEAttto_change()\n{\n\t if (document.getElementById(\"report_type\").value==\'M\')\n\t {\n\t\t document.getElementById(\"MY1\").innerHTML=getLabel(\"Common.month.label\",\"Common\")+\"&nbsp;\"\n\t\t  document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\'  maxlength=\'7\' size=\'7\' readonly onblur=\'ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_fm_Date.select();return showCalendar(\'p_fm_Date\',\'mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t\n\t }\n\t else  if (document.getElementById(\"report_type\").value==\'Y\')\n\t {\n\t\t document.getElementById(\"MY1\").innerHTML=getLabel(\"Common.year.label\",\"Common\")+\"&nbsp;\"\n\t\t document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\'  maxlength=\'4\' size=\'4\' readonly onblur=\'ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_fm_Date.select();return showCalendar(\'p_fm_Date\',\'y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t  else  if (document.getElementById(\"report_type\").value==\'D\')\n\t {\n\t\t document.getElementById(\"MY1\").innerHTML=getLabel(\"Common.date.label\",\"Common\")+\"&nbsp;\"\n\t\t document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\'  maxlength=\'10\' size=\'10\' readonly onblur=\'ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_fm_Date.select();return showCalendar(\'p_fm_Date\',\'dd/mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\n\t  if (document.getElementById(\"report_type\").value==\'M\')\n\t {\n\t\t  document.getElementById(\"MY3\").innerHTML = \"<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\'  maxlength=\'7\' size=\'7\' readonly onblur=\'ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_to_Date.select();return showCalendar(\'p_to_Date\',\'mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t else  if (document.getElementById(\"report_type\").value==\'Y\')\n\t {\n\t\t document.getElementById(\"MY3\").innerHTML = \"<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\'  maxlength=\'4\' size=\'4\'  readonly onblur=\'ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\' ><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_to_Date.select();return showCalendar(\'p_to_Date\',\'y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t  else  if (document.getElementById(\"report_type\").value==\'D\')\n\t {\n\t\t document.getElementById(\"MY3\").innerHTML = \"<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\'  maxlength=\'10\' size=\'10\'  readonly onblur=\'ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\\\"report_type\\\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_to_Date.select();return showCalendar(\'p_to_Date\',\'dd/mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n }\n \t\t\t\nasync function searchCode(obj,target)\n{\n\tvar retVal = \tnew String();\n\tvar dialogHeight= \"28vh\" ;\n\tvar dialogWidth\t= \"43vw\" ;\n\tvar status = \"no\";\n\tvar arguments\t= \"\" ;\n\tvar sql=\"\";\n\tvar search_code=\"\";\n\tvar search_desc=\"\";\n\tvar tit=\"\";\n\tvar allfacilityid\t=\tdocument.Rep2YrlyAdmnTypeForm.p_all_facility_id.value;\n\tvar from_pract_type = document.Rep2YrlyAdmnTypeForm.fm_pract_type.value;\n\tvar to_pract_type = document.Rep2YrlyAdmnTypeForm.to_pract_type.value;\n\n\ttit=getLabel(\"Common.speciality.label\",\"Common\");\n\tsql=\"select speciality_code, short_desc from am_speciality \";\n\tsearch_code=\"speciality_code\";\n\tsearch_desc= \"short_desc\";\n\t\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\tretVal = await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit),arguments,features);\n\n\tif (!(retVal == null))\n\t{\n\t\ttarget.value=retVal;\n\t}\n\telse\n\t\ttarget.focus();\n}\n\n\nfunction ChkDateFormat(Object2) \n{\n\tvar datefield = Object2;\n\tif (ChkDate1(Object2) == false) \n\t{\n\t\talert(parent.parent.parent.frames[0].getMessage(\'INVALID_DATE_FMT\',\'SM\'));\n\t\tdatefield.select();\n\t\tdatefield.focus();\t\t\n\t\treturn false;\n\t}else {\n\t\treturn true;\n\t}\n}\n\t\t\nfunction ChkDate1(Object3) \n{\n\tvar strDate;\t\n\tvar strMonth;\n\tvar strYear;\t\n\tvar datefield = Object3;\n\tvar strDateArray = new Array();\n\n\tstrDate = datefield.value;\n\tif (strDate.length == 0) \n\t\treturn true; \n\n\tstrDateArray = strDate.split(\"/\");\n\tif (strDateArray.length != 2)\n\t{\n\t\treturn false;\n\t}\telse {\n\t\tstrMonth = strDateArray[0];\n\t\tstrYear = strDateArray[1];\n\t}\n\n\tif (strYear.length < 4) return false;\n\tif (isNaN(strMonth)==true) return false;\n\tif (isNaN(strYear)==true) return false;\n\tif (strYear < 1900) return false;\n\tif (strMonth>12 || strMonth<1) \treturn false;\n\n\treturn true;\n}\n\nfunction clinicClearRepAEAtt()\n{\n\tdocument.forms[0].p_clinic_code.value = \"\";\n\n\tvar service = document.forms[0].p_service_type.value;\n\n\tif(service == \"\")\n\t{\n\t\tdocument.forms[0].p_clinic_code.disabled = true;\n\t\tdocument.forms[0].clinic.disabled = true;\n\t}else\n\t{\n\t\tdocument.forms[0].p_clinic_code.disabled = false;\n\t\tdocument.forms[0].clinic.disabled = false;\n\t}\n}\n</script>\n\n</HEAD>\n\n<BODY onMouseDown=\"CodeArrest();\" onLoad=\"repAEAttto_change();";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="clinicClearRepAEAtt();";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onKeyDown = \'lockKey()\'>\n<br>\n<br>\n<form name=\"repAEAtttoEmgyDeptForm\" id=\"repAEAtttoEmgyDeptForm\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<input type=\"hidden\" name=\"current_date\" id=\"current_date\"\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n\n\t\t<th align=\'left\'> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</th>\n\n\t<tr>\n\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\n\t\t\t<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\' >\n\n\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'35%\' class=\"label\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'>\n\t\t\t\t\t\t <SELECT name=\"report_type\" id=\"report_type\" onchange=\'repAEAttto_change()\'>\n\t\t\t\t\t\t <option value=\"D\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\n\t\t\t\t\t\t <option value=\"M\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t\t\t\t <option value=\"Y\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t\t\t\t </SELECT>\n\t\t\t\t\t</td>\n\t\t\t\t\t\t <td >&nbsp; </td>\n\t\t\t\t</tr>\n\t\t\t\t\t\t <td colspan =\'3\'> \n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'35%\' class=\"label\">&nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  ></td>\n\t\t\t\t\t<td >&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t\t<td colspan =\'3\'></td>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'right\' id=\'MY1\'class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t<td align=\'left\' id=\'MY\' >&nbsp;</td>\n\t\t\t\t\t\t<td align=\'left\' id=\'MY3\' >&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'35%\' class=\"label\"> &nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  ></td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<!--Added by Ashwini on 08-Apr-2021 for ML-MMOH-CRF-1604-->\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<tr>\n\t\t\t\t\t <td width=\'30%\' align=\'right\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" &nbsp;&nbsp;</td>\n\t\t\t\t\t <td align=\'left\'>\n\t\t\t\t\t\t<input name=\'p_clinic_code\' id=\'p_clinic_code\' value=\'\' size=\'5\' maxlength=\'4\' onkeypress=\'ChangeUpperCase(this);\' onblur=\'ChangeUpperCase(this);\'>\n\t\t\t\t\t\t<input type=\'button\' name=\'clinic\' id=\'clinic\' value=\'?\' class=\'button\' onclick=\'searchCode1(this,p_clinic_code)\'>\n\t\t\t\t\t\t<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<!--Added by Ashwini on 03-Sep-2020 for ML-MMOH-CRF-1351-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\'  class=\"label\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t   <SELECT name=\'p_service_type\' id=\'p_service_type\' onchange=\"clinicClearRepAEAtt()\"> \n\t\t\t\t\t\t   <!--Modified by Ashwini on 29-Jul-2019 for ML-MMOH-CRF-1352-->\n\t\t\t\t\t\t   <option value=\'\' style=\'align:center\'> ----------- ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ----------- </option>\n\t\t\t\t\t\t   <option value=\'ED\' style=\'align:center\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t\t\t   <option value=\"OB\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</option>\n\t\t\t\t\t\t</select>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=text onkeypress=\'return ValidString(event)\' onblur=\'ChangeUpperCase(this);\' name=\'p_clinic_code\' id=\'p_clinic_code\' size=\"4\" maxlength=\"4\"><input type=\'button\' name=\'clinic\' id=\'clinic\' value=\'?\' class=\'button\' onclick=\"searchCodeClinicLoc(p_service_type,p_clinic_code)\">&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!--End ML-MMOH-CRF-1351-->\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'35%\' class=\"label\">&nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  ></td>\n\t\t\t\t\t<td >&nbsp;</td>\n\t\t\t\t</tr>\n\t\n\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'35%\' class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'>\n\t\t\t\t\t<SELECT name=\"p_type\" id=\"p_type\" >\n\t\t\t\t\t<option value=\"D\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t\t\t\t<option value=\"M\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t\t\t\t</SELECT>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td >&nbsp; </td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t</table>\n\t</td>\n</tr>\n</table>\n\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\tvalue=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\n</form>\n</BODY>\n</HTML>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
	
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
    Connection con =null;
	ResultSet rs = null;
	Statement stmt = null;
	String sysdateSql ="";
	String SystemDate ="";
	String p_report_id = "";
    String p_module_id		= "MR" ; 
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	//Added by Ashwini on 08-Apr-2021 for ML-MMOH-CRF-1604
	String function_id = checkForNull(request.getParameter("function_id")) ;

	if(function_id.equals("MRAECSCT_V2003"))
	{
		p_report_id = "MRAECSCTV1" ;
	}else
	{
		p_report_id = "MRAECSCT" ;
	}

try {
     con=ConnectionManager.getConnection(request);
	 sysdateSql="select to_char(sysdate,'dd/mm/yyyy')SystemDate from dual";
	stmt = con.createStatement();
	rs	=	stmt.executeQuery(sysdateSql);
	if (rs.next() && rs != null)
	{
		SystemDate = rs.getString("SystemDate");
	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
if(!function_id.equals("MRAECSCT_V2003")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(function_id.equals("MRAECSCT_V2003")){
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( function_id ));
            _bw.write(_wl_block32Bytes, _wl_block32);

} catch(Exception e) {  /* out.println("in else "+e); */ e.printStackTrace();}
finally
{
	if(con != null)ConnectionManager.returnConnection(con,request);
	 if(rs!= null) rs.close();
	 if(stmt!=null) stmt.close();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportcritera.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reporttype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daily.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.month.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.year.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EmergencyClinicCode.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EmergencyDepartment.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Observation.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReportBy.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
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
}
