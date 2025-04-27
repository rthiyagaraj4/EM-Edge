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
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyconfirmbooking extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AddModifyConfirmBooking.jsp", 1742365495493L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--***** Function to Revise the Booking -- *******---> \n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eIP/js/IPPractitionerComponent.js\' language=\'javascript\'></script>\n<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 28/01/2013-->\n<!--Start-->\n<script src=\'../../eIP/js/Booking.js\' language=\'javascript\'></script>\n<!--End-->\n<script>\n\tfunction checkMaxLimitOfRemark(obj)\n\t{\n\t\tif ( obj.value.length > 250 )\n\t\t{\n\t\t\tvar error = getMessage(\"REMARKS_CANNOT_EXCEED\",\"common\");\n\t\t\tvar remarks = getLabel(\"Common.booking.label\",\"common\") + \" \" + getLabel(\"Common.remarks.label\",\"common\");\n\t\t\terror = error.replace(\"$\",remarks);\n\t\t\terror = error.replace(\"#\",\"250\")\n\t\t\talert(error);\n\t\t\tobj.select();\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t\treturn true;\n\t}\n\tfunction disdate()\n\t{\n\t// this commenting for IP_17014_ConfirmReviseBooking document.confirmbooking_form.ot_date_time.value= document.confirmbooking_form.pref_adm_date.value ;\n\tdocument.forms[0].exp_discharge_date.focus();\n\t}\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\n<script>\nfunction CheckForSpecChars_Remarks(event){\n\t\n    //var strCheck = \'\"+%?@#$~\\\'<>\';\n    var strCheck =\'~`!@#$%^&*()-_=+{[}]|:;\",./?\\<>\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n   // if (strCheck.indexOf(key) == -1) return true;  // Not a valid key\n   if (strCheck.indexOf(key) == -1 && whichCode != 92) return true; // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode);\n\treturn false ;\n}\nfunction imposeMaxLength(obj)\n{\n var mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\tobj.value=obj.value.substring(0,mlength)\n}\n//This function is used for finding the practioners list\nfunction getPractID(obj,target)\n{\n\tvar practName_FName\t\t= \"\";\n\tvar practName_FValue\t= \"\";\n\tvar practId_FName\t\t= \"\";\n\tif(document.forms[0].practid_desc.value ==\'\')\n\t\tdocument.forms[0].practid1.value=\'\';\n\tpractName_FName\t\t\t=\ttarget.name;\n\tpractName_FValue\t\t= target.value;\n\tpractId_FName\t\t\t= document.forms[0].practid1.name;\n\tvar splty\t\t\t\t= document.forms[0].Splcode1.value;\n\tvar locale\t\t\t\t= document.forms[0].locale.value;\n\tvar facility_id\t\t\t= \"\";\n\tfacility_id\t\t\t\t= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\tvar sql2\t\t\t\t= \"\";\n\n\tgetPractitioner(obj, target, facility_id, splty,\"\",\"Q1\");\n\t\n\t/*sql = \" SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1) practitioner_name , am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,\'\"+locale+\"\',2) practitioner_type,  a.specialty_code, am_get_desc.AM_SPECIALITY(a.specialty_code,\'\"+locale+\"\',2 ) primary_specialty, a.gender, am_get_desc.am_position(a.position_code,\'\"+locale+\"\',1) job_title FROM am_pract_all_splty_vw a WHERE a.facility_id = \'\"+facility_id+\"\' AND a.specialty_code = \'\"+splty+\"\' AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND (   UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER (NVL (?, a.practitioner_name)) ) AND a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) AND 1 = 1 \";\n\n\tsql2 = \" SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1) practitioner_name , am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,\'\"+locale+\"\',2) practitioner_type,  a.specialty_code, am_get_desc.AM_SPECIALITY(a.specialty_code,\'\"+locale+\"\',2 ) primary_specialty, a.gender, am_get_desc.am_position(a.position_code,\'\"+locale+\"\',1) job_title FROM am_pract_all_splty_vw a WHERE a.facility_id = \'\"+facility_id+\"\' AND a.specialty_code = \'\"+splty+\"\' AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND (   UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) AND UPPER (am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER (NVL (?, a.practitioner_name)) ) AND a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) AND 1 = 1 \";\n\n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\txmlStr\t=\"<root><SEARCH \" ;\n\txmlStr += \" practName_FName=\\\"\" + practName_FName + \"\\\"\";\n\txmlStr += \" practName_FValue=\\\"\" + encodeURIComponent(practName_FValue) + \"\\\"\";\n\txmlStr += \" sql=\\\"\" +escape(sql)+ \"\\\"\";\n\txmlStr += \" sqlSec=\\\"\" +escape(sql2)+ \"\\\"\";\n\txmlStr += \" practitioner_type=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" specialty_code=\\\"\" + splty+ \"\\\"\";\n\txmlStr += \" job_title=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" gender=\\\"\" + \"\" + \"\\\"\";\n\n\txmlStr +=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\txmlHttp.send(xmlDoc);\n\tresponseText=xmlHttp.responseText;\n\tresponseText = trimString(responseText);\n\teval(responseText);*/\t\n}\n</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../js/ConfirmBooking.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<TITLE>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </TITLE>\n</HEAD>\n<BODY onLoad =\"PatDetDisab();Control_NursingUnit(\'N\');disdate();checkPatInstns();\n\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'confirmbooking_form\' id=\'confirmbooking_form\' action=\'../../servlet/eIP.ConfirmBookingServlet\' method=\'post\' target=\'messageFrame\'> \n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\n\t\t<a name=\'tab1\'></a>\n\t\t<ul id=\'tablist\' class=\'tablist\' style=\"padding-left:0px;\">\n\t\t\t<li class=\'tablistitem\' title=\'Booking Details\'>\n\t\t\t\t<a class=\'tabClicked\' id=\"booking_tab\"  onclick=\"tab_click(\'booking_tab\')\">\n\t\t\t\t\t<span class=\'tabSpanclicked\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\'tablistitem\' title=\'Financial Details\'>\n\t\t\t\t<a class=\'tabA\' id=\"findtl_tab\" onclick=\"tab_click(\'findtl_tab\')\">\n\t\t\t\t\t<span class=\'tabAspan\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t</ul>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\'fields\' width=\'20%\'>\n\t<input type=text  id =otdatetime name=\'ot_date_time\' id=\'ot_date_time\'  onBlur=\'doOTDateTimeChk2(this);\' size=\"16\" maxlength=\'16\'  value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"><img name =\"ambul\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'otdatetime\',null,\'hh:mm\');\"></img>\n\t</td>\n\t<td width=\'10%\' class=\'label\'></td>\n\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td class=\'fields\' width=\'20%\' ><INPUT TYPE=\'text\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' name=\'pre_op_days\' size=\"3\" maxlength=\"3\"  onKeyPress=\'return(ChkNumberInput(this,event,0))\'  onBlur=\"CheckNum(this);displayDefaultValue(this);calcPrefDateForPreparationDay1();\"></td>\n</tr>\n<tr>\n\t<td  class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td  class=\'fields\' width=\'20%\'>\n\t<input type=\"hidden\" name =\"sdate\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<INPUT TYPE=\"text\"  id =prefadmdate name=\"pref_adm_date\" id=\"pref_adm_date\" value=\"\" size=\"16\" maxlength=\'16\'  onBlur=\'Allfunc(this,document.forms[0].sdate2);calcDate(this);\'  onKeyPress=\'return(ChkNumberInput1(this,event,2))\'><img name =\"ambul\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'prefadmdate\',null,\'hh:mm\');\" ></img><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t<td id=\"DayVal\" class=\"Querydata\" width=\'10%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\t \n\t<!--\n   \t<td class=\'label\' width=\'18%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\n\t<td class=\'fields\' width=\'10%\'><input type=\'text\' name=\'exp_days_of_stay\' id=\'exp_days_of_stay\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' size=\'3\' maxlength=\'3\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNum(this);CheckZeroVal(this);displayDefaultValue(this);calcDate(this);\"></td>-->\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<td class=\'label\'  width=\'20%\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>   \t\n\t<td class=\'QUERYDATA\'  width=\'20%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<td class=\'label\' width=\'20%\'></td>   \t\n\t\t<td class=\'QUERYDATA\' width=\'20%\'></td>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n</tr>\n<tr>\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t<td class=\'QUERYDATA\' width=\'20%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t   \t\n\t<input type = \'hidden\' value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" name = \'med_service_grp\'>\t   \n\t</td>\n\t<td class=\'label\' width=\'10%\'></td>\t\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t<td class = \'QUERYDATA\' width=\'20%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t<input type= \'hidden\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" name = \'booking_ref_no\'>\n\t<!--\n\t<td class=\"label\" >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\t  \n\t<td  class=\'field\' ><input type=\'text\' name=\'exp_discharge_date\' id=\'exp_discharge_date\' id=\'exp_discharge_date_id\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" size=\'16\' maxlength=\'16\' readonly></td>\t-->\n </tr>\n <tr>\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t<td class=\'fields\' width=\'20%\'><input type=\'text\' name=\'exp_days_of_stay\' id=\'exp_days_of_stay\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' size=\'3\' maxlength=\'3\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNum(this);CheckZeroVal(this);displayDefaultValue(this);calcDate(this);\"></td>\n\t<td class=\'label\' width=\'10%\'></td>\n\t<td class=\"label\" width=\'20%\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\t  \n\t<td  class=\'field\' width=\'20%\'><input type=\'text\' name=\'exp_discharge_date\' id=\'exp_discharge_date\' id=\'exp_discharge_date_id\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" size=\'16\' maxlength=\'16\' readonly></td>\n </tr>\n\t <tr>\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t<td class=\'fields\' width=\'20%\'><select name=\"priority\" id=\"priority\">\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<option value=\"N\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="  </option>\n\t\t\t<option value=\"U\" selected>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="  </option>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<option value=\"N\" selected>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="  </option>\n\t\t\t<option value=\"U\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t   \n\t</td>\n\t<td class=\'label\' width=\'10%\'></td>\n\t <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>  \n\t<td  class = \'QUERYDATA\' width=\'20%\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" </td>\n\t<!--<td class=\'label\' colspan =\'1\'></td>-->\t\n </tr>\n </table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n   <tr>\t\n\t    <td class=\'columnheader\' colspan=\'5\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</th>\n        </tr>\n<tr>\n    <td align=\'left\' colspan=\'5\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t</td>\n</tr>\n</table>\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n   <td class=\'columnheader\' colspan=\'5\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n</tr>\t\n<tr>\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\n<td width=\'20%\' class=\'QUERYDATA\' style = \'word-break:break-all;\'>\n\t\n\t\t<input type=hidden name=\'complaintcode\' id=\'complaintcode\' width=\"15\" >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" </td>\n   <td class=\'label\' width=\'10%\'></td>\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\n\t\t<td  width=\'20%\' class=\'QUERYDATA\' style = \'word-break:break-all;\'>\n\t\t<input type=hidden name=\'rev_hid\' id=\'rev_hid\' width=\"15\" >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t<td class= \'QUERYDATA\' width=\'20%\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t<input type=\"hidden\" name=\"Splcode1\" id=\"Splcode1\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">   \n\t</td>\n\t  <td class=\'label\' width=\'10%\'></td>\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t<td class=\'QUERYDATA\' width=\'20%\'><input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" size=\"20\" maxlength=\"30\" onBlur=\"getPractIDBlur(document.forms[0].pract_id_search,practid_desc);\" ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"if(document.forms[0].practid_desc.value  == \'\') getPractID(this,practid_desc);\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'pract_img\'></img>\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t<td class=\'QUERYDATA\' width=\'20%\'>\n\t<select name=\"team_id\" id=\"team_id\" disabled><option value=\'\'>---&nbsp;";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;---\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" Selected>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</option>\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t</select>\t\n\t</td>\n\t<td class=\'label\' width=\'10%\'></td>\n\t<!--<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t<td class=\'fields\' colspan=\'1\'>\n\t<input type=text  id =otdatetime name=\'ot_date_time\' id=\'ot_date_time\'  onBlur=\'doOTDateTimeChk2(this);\' size=\"15\" maxlength=\'16\'  value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"><img name =\"ambul\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].ot_date_time.focus();return showCalendar(\'otdatetime\',null,\'hh:mm\');\"></img>\n\t</td>-->\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="&nbsp";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t<td class=\'fileds\' width=\'20%\'><textarea name=\"booking_remarks\" rows=\"2\"  maxlength=\'250\'   onBlur=\"makeValidString(this);checkMaxLimitOfRemark(this);\" onKeyPress=\"/*return CheckForSpecChars_Remarks(event);*/\" onkeyup=\"return imposeMaxLength(this);\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</textarea></td>\n</tr>\n<tr>\n\t\t<!--/*modification for SRR20056-CRF-0506*/-->\n\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t<td  class=\'fileds\' width=\'20%\'><SELECT name=\"booking_Type_Code\" id=\"booking_Type_Code\" onBlur=\"\"><option value=\'\' selected>-----";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="-----\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t<option value=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" selected>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t<option value=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =">";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t\n\t\t</select></td>\n\t\t<td class=\'label\' width = \'10%\'></td>\n\t\t<td class=\'label\' width = \'20%\'></td>\n\t\t<td class=\'fields\' width = \'20%\'></td>\n\t</tr>\n\n\n<tr>\n\t<td class=\'columnheader\' colspan=\'5\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t<input type = \'hidden\' value = \'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' name = \'old_nursing_unit\'>  \n</tr>\n<tr>\n\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t<td class=\'fields\' width=\'20%\'>\n\t<input type=text name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" width=\"15\" maxlength=15 size=15 value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" onblur=\"NursingUnitLookupBlur(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\',\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\');removePatInsSession();\"><input type=button class=button name=nursing_unit_lookup value=\'?\' onClick=\"if(document.forms[0].nursing_unit_desc.value == \'\')NursingUnitLookup(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\');removePatInsSession();\">\n\t<input type=hidden name=\"nursing_unit\" id=\"nursing_unit\" width=\"15\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t<input type=hidden name=\"nurs_unit_desc_hid\" id=\"nurs_unit_desc_hid\" width=\"15\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t</td>\n\t<td class=\'label\' width = \'10%\'></td>\n    <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t<td class=\'fields\' width=\'20%\'>\n\n\t<select name =\'service\'> \n\t\n\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" ---</option>\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' selected>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</option>\n\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t</select>\n\t\n\t</td>\n\t</tr>\n<!--Below line modified for this incient [23474] -->\n<tr>\n   <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n   <td class=\'fields\' width=\'20%\'><select name=\'Bedcode\' id=\'Bedcode\' onChange=\"populateBedType(this.value)\" dir=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n <option value=\'\' selected>--- ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" ---\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" selected >";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n<td class=\'label\' width = \'10%\'></td>\n   <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n   <td class=\'fields\' width=\'20%\' >\n\n   <select name=\"bed_type_desc\" id=\"bed_type_desc\" onChange=\'ClearNursingUnitDtls();\'>\n\t   <option value=\"\">--- ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" ---</option>\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n</select>\n\n\t<input type=hidden name=\"bedtypecode\" id=\"bedtypecode\"  value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t<input type=hidden name=\"bed_type_desc_hid\" id=\"bed_type_desc_hid\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"></td>\n </tr>\n<tr>\n   <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n   <td class=\'fields\' width=\'20%\'>\n\t<input type=\'text\' name=\'bed_no\' id=\'bed_no\' id=\'bed_no\' align =\'left\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" size=\"8\" maxlength = \"8\" onBlur=\'ChangeVal(this)\' onKeyPress=\'return CheckForSpecChars(event)\' disabled><input type=\'hidden\' name=\'old_bed_no\' id=\'old_bed_no\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"><input type=\'button\' name=\'bed_avail_chart\' id=\'bed_avail_chart\' onClick=\"openBedChart();\" value=\'?\'class=\'button\'></td>\n\t<td class=\'label\' width = \'10%\'></td>\n   <td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\n   <td class=\'fields\' width=\'20%\'>\n   <input type=\'text\' name=\'room_no\' id=\'room_no\' onKeyPress=\'return CheckForSpecChars(event)\' value=\"\" size=\"10\" maxlength=\"10\" readonly>\n   <!--comment for  IP_17014_ConfirmReviseBooking ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n   <input type=\'checkbox\' name =\'override\' ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" onClick=\"changeOVRVal(this)\"> -->\n </td>\n</tr>\n<tr>\n\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t<td class=\'fields\' > <input type=\'checkbox\' name =\'override\' ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" onClick=\"changeOVRVal(this)\">&nbsp;</td>\n\t\t <!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 28/01/2013-->\n\t\t <!--Maheshwaran K modified for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013-->\n\t\t<!--Start-->\n\t\t<td  colspan=1></td>\n\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t\t<td class=\'fields\' ><input name=\"surgery_order\" id=\"surgery_order\" type=\"text\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" onblur=\"if(this .value!=\'\'){GetSurgeryOrder(document.forms[0].patient_id.value,\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\');} else { GetSurgeryOrder_blank(document.forms[0].patient_id.value,\'\');}\"><input type=\'button\' name=\'surgery_order_name\' id=\'surgery_order_name\' onClick=\"GetSurgeryOrder(document.forms[0].patient_id.value,\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\');\" value=\'?\'class=\'button\'></td><input name=\"surgery_order_code\" id=\"surgery_order_code\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"><input name=\"surgery_order_id\" id=\"surgery_order_id\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"><input name=\"surgery_order_line_no\" id=\"surgery_order_line_no\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">&nbsp;</td>\n\t\t<!--End-->\n\t</tr>\n\t<!-- Included for the CRF - RUT-CRF013 - 23396 -->\n<tr>\n\t\t<td  class=\'label\'><a href=\'javascript:PatInsModalWindow()\'>";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</a>\n\t\t<img src=\'../../eCommon/images/InfoAlert.PNG\' id=\'NUInstsExist\' style=\'visibility:hidden\'/></td>\t\n\t\t<td  colspan=2></td>\t\n\t\t<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 28/01/2013-->\n\t\t<!--Start-->\n\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</td>\n\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t<td class=\'QUERYDATA\' id=\'surgery_order_dt_id\' >&nbsp;";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td><input name=\"surgery_order_date\" id=\"surgery_order_date\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t<td class=\'fields\' id=\'surgery_order_dt_id\' >&nbsp;</td><input name=\"surgery_order_date\" id=\"surgery_order_date\" type=\"hidden\" value=\"\">\n\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t<!--End-->\n\t\t</tr>\n<tr>\n\t <td colspan=\"4\" class=\"label\">&nbsp;</td>\n\t <td class=\'button\'> <input type=\'button\' name=\'confirm\' id=\'confirm\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' class=\'button\' onclick=\'apply();\'><input type=\'button\' name=\'Close\' id=\'Close\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' class=\'button\' onclick=\'parent.window.close();\'></td></tr>\n\n\t\t\n</table> \n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t<input type=\'hidden\' name=\'currdate\' id=\'currdate\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n\t<input type=\'hidden\' name=\'multi_book_pat_yn\' id=\'multi_book_pat_yn\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n\t<input type=\'hidden\' name=\'old_pref_adm_date\' id=\'old_pref_adm_date\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t<input type=\'hidden\' name=\'bkg_lst_ref_no\' id=\'bkg_lst_ref_no\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\t\n\t<input type=\"hidden\" name=\"hddCitizen\" id=\"hddCitizen\" value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n\t<input type=\"hidden\" name=\"hddLegal\" id=\"hddLegal\" value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n\t<input type=\"hidden\" name=\"name_prefix1\" id=\"name_prefix1\" >\n\t<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 28/01/2013-->\n\t<input type=\'hidden\' name=\'surgery_order_desc_hid\' id=\'surgery_order_desc_hid\' value=";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =">\n\t<input type=\'hidden\' name=\'block_bed_based_on\' id=\'block_bed_based_on\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' >\n\t<input type=\'hidden\' name=\'booking_status\' id=\'booking_status\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' >\n\t<input type=\'hidden\' name=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t<script>\n\n\t\tdocument.confirmbooking_form.patient_id.value \t= \"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\";\n\t\tdocument.confirmbooking_form.patient_id.disabled = true;\n\t\tdocument.confirmbooking_form.search.disabled = true;\n\t\t\t\n\t\tdocument.confirmbooking_form.pref_adm_date.value = \"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\";\n\t\t\n\t\tdocument.confirmbooking_form.room_no.value \t= \"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\";\n\n\t\tdocument.confirmbooking_form.patient_name.value \t= \"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\";\n\t\tdocument.getElementById(\'patient_name1\').innerHTML = \"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\";\n\t\tdocument.confirmbooking_form.patient_name.disabled = true;\n\n\t\t/*if(document.confirmbooking_form.name_prefix1)\n\t\t{\t\t\t\n\t\t\tdocument.confirmbooking_form.name_prefix1.value \t= \"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\";\n\t\t\tdocument.confirmbooking_form.name_prefix1.disabled = true;\n\t\t}*/\n\t\tif(document.confirmbooking_form.name_prefix)\n\t\t{\t\t\t\n\t\t\tdocument.confirmbooking_form.name_prefix.value \t= \"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\";\n\t\t\tdocument.confirmbooking_form.name_prefix.disabled = true;\n\t\t}\n\t\t/*if(document.confirmbooking_form.name_suffix1)\n\t\t{\n\t\t\tdocument.confirmbooking_form.name_suffix1.value \t= \"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\";\n\t\t\tdocument.confirmbooking_form.name_suffix1.disabled = true;\n\t\t}*/\n\t\tif(document.confirmbooking_form.name_suffix)\n\t\t{\n\t\t\tdocument.confirmbooking_form.name_suffix.value \t= \"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\";\n\t\t\tdocument.confirmbooking_form.name_suffix.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.first_name)\n\t    {\n\t\t\tdocument.confirmbooking_form.first_name.value \t= \"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\";\n\t\t\tdocument.confirmbooking_form.first_name.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.second_name)\n\t    {\n\t\t\tdocument.confirmbooking_form.second_name.value \t= \"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\";\n\t\t\tdocument.confirmbooking_form.second_name.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.third_name)\n\t    {\n\t\t\tdocument.confirmbooking_form.third_name.value \t= \"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\";\n\t\t\tdocument.confirmbooking_form.third_name.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.family_name)\n\t    {\n\t\t\tdocument.confirmbooking_form.family_name.value \t= \"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\";\n\t\t\tdocument.confirmbooking_form.family_name.disabled = true;\n\t\t}\n\n\n\t\tif(document.confirmbooking_form.name_prefix_oth_lang)\n\t    {\n\t\t\tdocument.confirmbooking_form.name_prefix_oth_lang.value \t= \"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\";\n\t\t\tdocument.confirmbooking_form.name_prefix_oth_lang.disabled = true;\n\t\t}\n\n\t\tif(document.confirmbooking_form.first_name_oth_lang)\n\t    {\n\t\t\tdocument.confirmbooking_form.first_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\";\n\t\t\tdocument.confirmbooking_form.first_name_oth_lang.disabled = true;\n\t\t}\n\n\t\tif(document.confirmbooking_form.second_name_oth_lang)\n\t    {\n\t\t\tdocument.confirmbooking_form.second_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\";\n\t\t\tdocument.confirmbooking_form.second_name_oth_lang.disabled = true;\n\t\t}\n\n\t\tif(document.confirmbooking_form.third_name_oth_lang)\n\t    {\n\t\t\tdocument.confirmbooking_form.third_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\";\n\t\t\tdocument.confirmbooking_form.third_name_oth_lang.disabled = true;\n\t\t}\n\n\t\tif(document.confirmbooking_form.family_name_oth_lang)\n\t    {\n\t\t\tdocument.confirmbooking_form.family_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\";\n\t\t\tdocument.confirmbooking_form.family_name_oth_lang.disabled = true;\n\t\t}\n\n\t\tif(document.confirmbooking_form.name_suffix_oth_lang)\n\t    {\n\t\t\tdocument.confirmbooking_form.name_suffix_oth_lang.value \t= \"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\";\n\t\t\tdocument.confirmbooking_form.name_suffix_oth_lang.disabled = true;\n\t\t}\n\n\n\t\tdocument.getElementById(\'patient_name_local_lang1\').innerText \t= \"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\";\n\t\tdocument.confirmbooking_form.patient_name_local_lang.value \t= \"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\";\n\n\t\tdocument.confirmbooking_form.sex.value \t= \"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\";\n\t\tdocument.confirmbooking_form.sex.disabled = true;\n\t\tdocument.confirmbooking_form.date_of_birth.value = \"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"; \n\t\t//document.revisebooking_form.date_of_birth.onblur();\n\t\t/*Wednesday, June 23, 2010,IN022062*/\n\t\tvar maxAge = \'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\';\n\t\tvar age\t   = \'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\';\n\t\tvar months\t   = \'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\';\n\t\tvar days\t   = \'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\';\n\t\tif(parseInt(maxAge) < parseInt(age))\n\t\t{\n\t\t\tmsg = getMessage(\'MAX_PATIENT_AGE\',\'MP\');\n\t\t\tmsg = msg.replace(\'#\', \'$\');\n\t\t\tmsg = msg+\' \'+maxAge+\' \'+ getLabel(\'Common.Years.label\',\'common\');\n\t\t\talert(msg);\n\t\t\twindow.close();\n\t\t}else if((parseInt(age) == parseInt(maxAge)) && ((parseInt(months) > 0) ||  (parseInt(days) > 0)))\n\t\t{\n\t\t\tmsg = getMessage(\'MAX_PATIENT_AGE\',\'MP\');\n\t\t\tmsg = msg.replace(\'#\', \'$\');\n\t\t\tmsg = msg+\' \'+maxAge+\' \'+ getLabel(\'Common.Years.label\',\'common\');\n\t\t\talert(msg);\n\t\t\twindow.close();\n\t\t}\n\t\tdocument.confirmbooking_form.date_of_birth.disabled = true;\n\t\tdocument.getElementById(\'dob\').disabled=true;\n\t\t/*Wednesday, January 12, 2011 , IN025850*/\n\t\tdocument.confirmbooking_form.b_age.value = \"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\";\n\t\tdocument.confirmbooking_form.b_months.value = \"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\";\n\t\tdocument.confirmbooking_form.b_days.value = \"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\";\n\t\t/**/\n\t\tdocument.confirmbooking_form.b_age.disabled = true;\n\t\tdocument.confirmbooking_form.b_months.disabled = true;\n\t\tdocument.confirmbooking_form.b_days.disabled = true;\n\n\t\tdocument.confirmbooking_form.complaintcode.value =\t\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\";\t\n\t\tdocument.confirmbooking_form.rev_hid.value\t\t = \"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\";\n\n\t\tvar override_yn = \"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\";\t\n\n\t\tif(override_yn == \"Y\")\t\t\n\t\t\tdocument.confirmbooking_form.override.checked = true;\n\t\telse\n\t\tdocument.confirmbooking_form.override.checked =false;\n\t//\tdocument.confirmbooking_form.ot_date_time.value \t= \"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\";\n\t\tdocument.confirmbooking_form.ot_date_time.value \t= \"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\";\n\t\tdocument.confirmbooking_form.Bedcode.value \t= \"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\";\n\t\tdocument.confirmbooking_form.nursing_unit.value \t= \"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\";\t\n\t\tdocument.confirmbooking_form.old_nursing_unit.value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\";\n\t    document.confirmbooking_form.Birth_place_code.value \t= \"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\";\n\n\t\tif((document.confirmbooking_form.Birth_place_code.value == null) || (document.confirmbooking_form.Birth_place_code.value == \"\"))\n\t\t{\t\n\t\t\tdocument.confirmbooking_form.place_of_birth.value = \"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\";\n\t\t}else\n\t\tdocument.confirmbooking_form.birth_place.value = \"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\";\n\n\t\tdocument.confirmbooking_form.birth_place.disabled= true;\n\t\tdocument.confirmbooking_form.place_of_birth.disabled= true;\n\t\tdocument.confirmbooking_form.b_birth.disabled= true;\n\t\tdocument.confirmbooking_form.nationality_code1.value \t= \"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\";\n\t\tdocument.confirmbooking_form.nationality_desc.value = \"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\";\n\t\tdocument.confirmbooking_form.nationality_desc.disabled= true;\n\t\tdocument.confirmbooking_form.nationality_id.disabled= true;\n\t\tdocument.confirmbooking_form.national_id_no.value \t= \"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\";\n\t\tdocument.confirmbooking_form.national_id_no.disabled \t= true;\n\n\t\tdocument.confirmbooking_form.national_id_no.disabled =true;\n\t\tif(document.confirmbooking_form.alt_id1_no)\n\t\t{\n\t\t\tdocument.confirmbooking_form.alt_id1_no.value \t= \"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\";\n\t\t\tdocument.confirmbooking_form.alt_id1_no.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.alt_id2_no)\n\t\t{\n\t\t\tdocument.confirmbooking_form.alt_id2_no.value \t= \"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\";\n\t\t\tdocument.confirmbooking_form.alt_id2_no.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.alt_id3_no)\n\t\t{\n\t\t\tdocument.confirmbooking_form.alt_id3_no.value \t= \"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\";\n\t\t\tdocument.confirmbooking_form.alt_id3_no.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.alt_id4_no)\n\t\t{\n\t\t\tdocument.confirmbooking_form.alt_id4_no.value \t= \"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\";\n\t\t\tdocument.confirmbooking_form.alt_id4_no.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.alt_id1_exp_date)\n\t\t{\n\t\t\tdocument.confirmbooking_form.alt_id1_exp_date.value \t= \"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\";\n\t\t\tdocument.confirmbooking_form.alt_id1_exp_date.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.alt_id2_exp_date)\n\t\t{\n\t\t\tdocument.confirmbooking_form.alt_id2_exp_date.value \t= \"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\";\n\t\t\tdocument.confirmbooking_form.alt_id2_exp_date.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.alt_id3_exp_date)\n\t\t{\n\t\t\tdocument.confirmbooking_form.alt_id3_exp_date.value \t= \"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\";\n\t\t\tdocument.confirmbooking_form.alt_id3_exp_date.disabled = true;\n\t\t}\n\t\tif(document.confirmbooking_form.alt_id4_exp_date)\n\t\t{\n\t\t\tdocument.confirmbooking_form.alt_id4_exp_date.value \t= \"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\";\n\t\t\tdocument.confirmbooking_form.alt_id4_exp_date.disabled = true;\n\t\t}\n\n\t\tif(document.confirmbooking_form.other_alt_type)\n\t\t{\n\t\t\tdocument.confirmbooking_form.other_alt_type.value = \"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\";\n\t\t\tdocument.confirmbooking_form.other_alt_type.disabled = true;\n\t\t}\n\n\t\tif(document.confirmbooking_form.other_alt_Id)\n\t\t{\n\t\t\tdocument.confirmbooking_form.other_alt_Id.value = \"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\";\n\t\t\tdocument.confirmbooking_form.other_alt_Id.disabled = true;\n\t\t}\n\n/*\t\topt = document.createElement(\"OPTION\");\n\t\tvar n = document.forms[0].ethnic_group.options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t\tdocument.forms[0].ethnic_group.remove(\"ethnic_group\");\t\n\t\topt.text = \"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\";\n\t\topt.value=  \"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\";\n\t\tdocument.getElementById(\'ethnic_group\').add(opt);\n\t\tdocument.getElementById(\'ethnic_group\').options[0].selected = true;\n*/\n\t\tdocument.getElementById(\'ethnic_group\').disabled = true;\n\t\tdocument.confirmbooking_form.ethnic_group.value = \"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\";\n\t\tdocument.confirmbooking_form.race_code.value = \"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\";\n\t\tif(document.confirmbooking_form.race_desc)\n\t\t\tdocument.confirmbooking_form.race_desc.value = \"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\";\n\t\t/*\n\t\tvar obj =document.forms[0].race_code;\n\t\tvar opt= document.createElement(\'Option\');\n\t\topt.text=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\"; \n\t\topt.value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\"; \n\t\tobj.add(opt);\n\t\topt.selected = true;\n\t\t*/\n\n\t\t//document.confirmbooking_form.race_code.disabled = true;\n\n\t\tif(document.confirmbooking_form.race_desc.value!=\"\") {\n\t\t\tdocument.confirmbooking_form.race_desc.disabled = true;\n\t\t\tdocument.confirmbooking_form.race_desc_id.disabled = true;\n\t\t}else // For 17676 \n\t\t{\n\t\t\tdocument.confirmbooking_form.race_desc.disabled = false;\n\t\t\tdocument.confirmbooking_form.race_desc_id.disabled = false;\n\t\t}\n\t\tdocument.confirmbooking_form.ethnic_group.disabled = true;\n\n\tif(document.confirmbooking_form.hddCitizen.value == \"Y\")\n\t\tdocument.confirmbooking_form.citizen_yn[0].checked = true;\n\telse\n\t\tdocument.confirmbooking_form.citizen_yn[1].checked = true;\n\n\t\tdocument.confirmbooking_form.citizen_yn[0].disabled = true;\t\t\n\t\tdocument.confirmbooking_form.citizen_yn[1].disabled = true;\t\n\n\tif(document.confirmbooking_form.hddLegal.value == \"Y\")\n\t\tdocument.confirmbooking_form.legal_yn[0].checked = true;\n\telse\n\t\tdocument.confirmbooking_form.legal_yn[1].checked = true;\t\n\n\t\tdocument.confirmbooking_form.legal_yn[0].disabled = true;\n\t\tdocument.confirmbooking_form.legal_yn[1].disabled = true;\n\n\t\tdocument.confirmbooking_form.change_address.value=\'\';\n\t\tdocument.confirmbooking_form.concat_address_hidden.value=\'\';\t\tdocument.confirmbooking_form.concat_NatIdDetails_hidden.value=\'\';\t\t\n\t\tdocument.confirmbooking_form.addr1_type.value=\'\';\n\t\tdocument.confirmbooking_form.addr_line1.value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\";\n\t\tdocument.confirmbooking_form.addr_line2.value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\";\n\t\tdocument.confirmbooking_form.addr_line3.value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\";\n\t\tdocument.confirmbooking_form.addr_line4.value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\";\n\t\tdocument.confirmbooking_form.res_town_code.value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\";\n\t\tdocument.confirmbooking_form.res_town_desc.value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\";\n\n\t\tdocument.confirmbooking_form.res_area_code.value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\";\n\t\tdocument.confirmbooking_form.res_area_desc.value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\";\n\n\t\tdocument.confirmbooking_form.postal_code.value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\";\n\t\tdocument.confirmbooking_form.r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\";\n\t\t\n\t\tdocument.confirmbooking_form.region_code.value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\";\n\t\tdocument.confirmbooking_form.region_desc.value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\";\n\t\tdocument.confirmbooking_form.country_code.value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\";\n\t\tdocument.confirmbooking_form.country_desc.value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\";\n\t\tdocument.confirmbooking_form.contact1_name.value=\'\';\n\t\tdocument.confirmbooking_form.invalid1_yn.value=\'\';\n\n\t\tdocument.confirmbooking_form.addr2_type.value=\'\';\n\n\t\tdocument.confirmbooking_form.mail_addr_line1.value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\";\n\t\tdocument.confirmbooking_form.mail_addr_line2.value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\";\n\t\tdocument.confirmbooking_form.mail_addr_line3.value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\";\n\t\tdocument.confirmbooking_form.mail_addr_line4.value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\";\n\t\tdocument.confirmbooking_form.mail_res_town_code.value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\";\n\t\tdocument.confirmbooking_form.mail_res_town_desc.value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\";\n\n\t\tdocument.confirmbooking_form.mail_res_area_code.value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\";\n\t\tdocument.confirmbooking_form.mail_res_area_desc.value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\";\n\t\tdocument.confirmbooking_form.mail_postal_code.value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\";\n\t\tdocument.confirmbooking_form.m_postal_code_desc.value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\";\n\t\t\n\t\tdocument.confirmbooking_form.mail_region_code.value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\";\n\t\tdocument.confirmbooking_form.mail_region_desc.value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\";\n\t\tdocument.confirmbooking_form.mail_country_code.value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\";\n\t\tdocument.confirmbooking_form.mail_country_desc.value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\";\n\t\tdocument.confirmbooking_form.contact2_name.value=\'\';\n\t\tdocument.confirmbooking_form.invalid2_yn.value=\'\';\n\t\t\n\t\t/*Added by Thamizh selvi on 8th Feb 2017 against ML-MMOH-CRF-0601 Start*/\n\t\tdocument.confirmbooking_form.alt_addr_line1.value = \"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\";\n\t\tdocument.confirmbooking_form.alt_addr_line2.value =\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\";\n\t\tdocument.confirmbooking_form.alt_addr_line3.value = \"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\";\n\t\tdocument.confirmbooking_form.alt_addr_line4.value = \"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\";\n\t\tdocument.confirmbooking_form.alt_area_code.value = \"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\";\n\t\tdocument.confirmbooking_form.alt_area_desc.value = \"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\";\n\t\tdocument.confirmbooking_form.alt_town_code.value = \"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\";\n\t\tdocument.confirmbooking_form.alt_town_desc.value = \"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\";\n\t\tdocument.confirmbooking_form.alt_region_code.value = \"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\";\n\t\tdocument.confirmbooking_form.alt_region_desc.value = \"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\";\n\t\tdocument.confirmbooking_form.alt_postal_code.value = \"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\";\n\t\tdocument.confirmbooking_form.alt_postal_desc.value = \"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\";\n\t\tdocument.confirmbooking_form.alt_country_code.value = \"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\";\n\t\tdocument.confirmbooking_form.alt_country_desc.value = \"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\";\n\t\t/*End*/\n\n\t\tdocument.confirmbooking_form.contact1_no.value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\";\n\t\tdocument.confirmbooking_form.contact2_no.value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\";\n\t\tdocument.confirmbooking_form.email.value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\";\n\n\t\t";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\n\t</script>\n\n\t<input type =\'hidden\' name = \'practid1\' \tvalue = \"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\">  \n\t<input type =\'hidden\' name = \'old_nursing_unit\' value = \"\"> \n\n\t<input type =\'hidden\' name = \'PatClass\' \t\tvalue = \"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\"> \t\n\t<input type=\'hidden\' name =\'override_yn\' \tvalue =\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" >\n\n";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\n\t <input type=\'hidden\' name=\'chk_booking_limit_by\' id=\'chk_booking_limit_by\' value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" >\n\t<input type = \'hidden\' value=\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\' name = \'sdate2\'> \n\t<!--<input type = \'hidden\' value=\'IP_Booking\' name = \'call_function\'> -->\n\t<input type = \'hidden\' value=\'IP_ConfirmBooking\' name = \'call_function\'>\n\t<input type = \'hidden\' value=\'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\' name = \'queryString\'> \n\t<input type=\'hidden\'  name=\'bclasscode\' id=\'bclasscode\' value=\"\">\n\t<input type=\'hidden\'  name=\'service_hid\' id=\'service_hid\' value=\"\">\n\t<input type=\'hidden\'  name=\'bno\' id=\'bno\' value=\"\">\n\t<input type=\'hidden\'  name=\'rno\' id=\'rno\' value=\"\">\n\t<input type=\'hidden\'  name=\'nunitcode\' id=\'nunitcode\' value=\"\">   \n\t<input type=\'hidden\' name=\'modifiedDate\' id=\'modifiedDate\' value=\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\' >\n\t<input type=\'hidden\' name=\'practid_desc_hid\' id=\'practid_desc_hid\' value=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\'>\n\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\'>\n\t<input type=\'hidden\' name=\'pre_op_days_hidden\' id=\'pre_op_days_hidden\' value=\'";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\' >\n\n\n\n\t<!--  billing related variables -->\n\t\t   <input type=\'hidden\' name=\'package_flag\' id=\'package_flag\' value=\'N\'>\n\t\t   <!--<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'>-->\n\t\t   <input type=\'hidden\' name=\'pkg_bill_type\' id=\'pkg_bill_type\' value=\'\'>\n\t\t   <input type=\'hidden\' name=\'pkg_bill_no\' id=\'pkg_bill_no\' value=\'\'>\n\t\t   <input type=\"hidden\" name=\"patient_class_id\" id=\"patient_class_id\" value=\"IP\">\n\t\t   <input type=\'hidden\' name=\'health_card_expired_yn\' id=\'health_card_expired_yn\' value=\'\'>\n\t\t   <input type=\'hidden\' name=\'Chg_to_Visitor_Grp\' id=\'Chg_to_Visitor_Grp\' value=\'N\'>\n\t\t   <input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\"> \n\t\t   <input type=\'hidden\' name=\'financial_detail_ref_id\' id=\'financial_detail_ref_id\' value=\'\'>\n\t\t   <input type=\'hidden\' name=\'org_type_ind\' id=\'org_type_ind\' value=\'\'>\n\t\t   <input type=\'hidden\' name=\'att_practid\' id=\'att_practid\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'isBlInstalled\' id=\'isBlInstalled\' value=\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\'>\n\t\t   <input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\'N\'>\n\t\t   <input type=\'hidden\' name=\'insTrackDtlsExists\' id=\'insTrackDtlsExists\' value=\'\'>\n\t\t   <input type=\'hidden\' name=\'isBlInterfaced\' id=\'isBlInterfaced\' value=\'";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\'>\n\t\t   <input type=\'hidden\' name=\'iscapture_fin_dtls_yn\' id=\'iscapture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\'>\n\t\t   <input type=\'hidden\' name=\'billing_group_operation\' id=\'billing_group_operation\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'removePatInstruction\' id=\'removePatInstruction\' value=\'\'>\n\t\t   <script>\n\t\t\tif ( (document.forms[0].billing_group) && (document.forms[0].billing_group.value != \'\') ) \n\t\t\tdocument.forms[0].bl_success.value = \'Y\';\n\t\t   </script>\n</form>\n</BODY>\n\n</HTML>\n";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String locale				= (String)session.getAttribute("LOCALE");
String disabledAttrib		= "";
String checkBoxAttribute	= "";
String sqlsd1				= "";
String booking_ref_no		= "";
String Sdate 				= "";
String p_oper_stn_id		= request.getParameter("oper_stn_id");
String modifiedDate			= "";
String pract_name			= "";
String facilityID			= (String)session.getValue("facility_id");
String loginUser			= (String)session.getValue("login_user");
boolean isBlInterfaced		= false;
String bl_operational		= "";
String capture_fin_dtls_yn	= "";
String bl_interfaced_yn		= "";
String chk_booking_limit_by = "";
String pre_op_days			= "";
String booking_status		= "";
session.removeAttribute("ipPatInstructionsMap");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con			= null;
	PreparedStatement pstmt = null;
	Statement stmt1			= null;
	Statement stmt			= null;
    PreparedStatement stmt2	= null;
	ResultSet rs			= null;
    ResultSet rs1			= null;
    ResultSet rs2			= null;
   	ResultSet prs			= null;
	//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 24/01/2013
	//Start
	ResultSet rset			= null;
	Statement rstmt			= null;
	//End

	String queryString		= checkForNull( (String)session.getValue( "queryString" ) ) ;

	try{
		con					= ConnectionManager.getConnection(request);
		stmt				= con.createStatement();
		stmt1				= con.createStatement();

		String DayVal			= ""; 
		String bed_no			= "";
		String old_nursing_unit = "";
		String med_service_grp	= "";
		String preferred_date	= "";
		String nameprefix		= "";
		String firstname		= "";
		String secondname		= "";
		String thirdname		= "";
		String familyname		= "";
		String namesuffix		= "";
		String patientname		= "";
		String gender			= "";
		String specialty_code	= "";
		String roomno			= "";
		String date_of_birth	= "";
		String Practitioner_id	= "";
		String override_yn		= "";
		String ot_date_time		= "";
		String bed_class_code	= "";
		String bed_class_desc	= "";
		String bed_type_desc    = "";
		String bed_type_code    = "";
		String nursing_unit_code= "";
		String nurs_unit_sdesc  = "";
		String res_tel_no		= "";
		String email_id			= "";
		String national_id_no	= "";
		String alt_id1_no		= "";	
		String alt_id2_no		= "";
		String alt_id3_no		= "";	
		String alt_id4_no		= "";
		String alt_id1_exp_dt	= "";	
		String alt_id2_exp_dt	= "";
		String alt_id3_exp_dt	= "";	
		String alt_id4_exp_dt	= "";
		String oth_alt_id_no	= "";	
		String oth_alt_id_type	= "";
		String res_addr_line1	= "";
		String res_addr_line2	= "";
		String res_addr_line3	= "";
		String res_addr_line4	= "";
		String res_town_code	= "";	
		String res_town_desc	= "";
		String res_area_code	= "";	
		String res_area_desc	= "";
		String res_region_code	= "";	
		String res_region_desc	= "";
		String mail_addr_line1	= "";	
		String mail_addr_line2	= "";
		String mail_addr_line3	= "";	
		String mail_addr_line4	= "";
		String mail_town_code	= "";	
		String mail_town_desc	= "";
		String mail_area_code	= "";	
		String mail_area_desc	= "";
		String mail_region_code	= "";	
		String mail_region_desc	= "";
		String mail_postal_code	= "";
		String mail_postal_code_desc	= "";
		String mail_country_code= "";	
		String mail_country_desc= "";
		String postal_code		= "";
		String postal_code_desc	= "";
		String country_code		= "";	
		String country_desc		= "";
		String other_tel_no		= "";
		String patient_id		= "";
		String spl_name			= "";
		String medsershortdesc	= "";
		String chief_complaint	= "";
		String reason_revise	= "";
		String comp_desc		= "";
		String rev_desc			= "";
		
		String patientclasscode	= "";
		String blood_donation_yn= "";     
		String amb_reqd_yn      = "";    
		String team_code		= "";
		String nationality		= "";
		String nationality_desc = "";
		String alt_id1_exp_date = "";
		String exp_days_of_stay	= "";
		String referral_id		= "";
		String priority			= "";
		String service_code		= "";
		String booking_date_time= "";
		String eth_grp			= "";
		String eth_sub_grp		= "";
		String race_desc		= "";
		String eth_grp_desc		= "";
		String birth_place_code = "";		
		String birth_place_desc	= "";
		String citizen_yn		= "";		
		String legal_yn			= "";
		String name_prefix_loc_lang	= "";
		String first_name_loc_lang	= "";
		String second_name_loc_lang	= "";
		String third_name_loc_lang	= "";
		String family_name_loc_lang	= "";
		String name_suffix_loc_lang	= "";
		String patient_name_loc_lang= "";
		String booking_date_time_converted  = "";
		String ot_date_time_converted		= "";
		String preferred_date_converted		= "";
		String date_of_birth_converted		= "";
		String expected_discharge_date		= "";
		String booking_remarks      = "";
		String booking_type_code    = "";
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
		//Start
		String order_id="";
		String order_line_no="";
		String oper_code="";
		String oper_desc="";
		String pref_surg_date="";
		String disable_surg="";
		//End
		/*Added by Thamizh selvi on 8th Feb 2018 against ML-MMOH-CRF-0601 Start*/
		String alt_addr_line1	= "";
		String alt_addr_line2	= "";
		String alt_addr_line3	= "";
		String alt_addr_line4	= "";
		String alt_postal_code  = "";
		String alt_postal_desc  = "";
		String alt_country_code = "";
		String alt_country_desc = "";
		String alt_area_code	= "";
		String alt_area_desc	= "";
		String alt_town_code	= "";
		String alt_town_desc	= "";
		String alt_region_code	= "";
		String alt_region_desc	= "";
		/*End*/ 
		ArrayList bookingtype_list	= new ArrayList();


		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
		java.util.Date dt					  = new java.util.Date();
		Sdate								  = dateFormat.format( dt ) ;
		Sdate=Sdate + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
		String bkg_lst_ref_no = checkForNull(request.getParameter("bkg_lst_ref_no"));
		String multi_book_pat_yn = checkForNull(request.getParameter("multi_book_pat_yn"));

		bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"));	
		capture_fin_dtls_yn		= checkForNull(request.getParameter("capture_fin_dtls_yn"));	
		chk_booking_limit_by		= checkForNull(request.getParameter("chk_booking_limit_by"));

		bl_operational			= (String)session.getValue("bl_operational");
		String block_bed_based_on	= checkForNull(request.getParameter("block_bed_based_on"));
		String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"));

		String max_patient_age			= "";
		int DAYS					= 0;
		int	MONTHS					= 0;
		int	AGE						= 0;		
		if(bl_interfaced_yn.equals("Y"))
			isBlInterfaced = true;
		else 
			isBlInterfaced = false;
		

		try
		{
			// This query is used for retriving all the booking details from view
			//Changed by Vinod 6/23/2006 11:47 AM
				StringBuffer PatVal = new StringBuffer();
				PatVal.append("SELECT" );
				PatVal.append("  bkg_lst_ref_no" );
				PatVal.append("  , room_no" );
				PatVal.append("  , bed_no" );
				PatVal.append("  , med_ser_grp_code" );
				PatVal.append("  , exp_days_of_stay" );
				PatVal.append("  , priority_ind" );
				PatVal.append("  , ip_get_desc.IP_MEDICAL_SERVICE_GROUP (facility_id, MED_SER_GRP_CODE, '"+locale+"', 2) med_ser_short_desc" );
				PatVal.append("  , am_get_desc.am_speciality(specialty_code, '"+locale+"', 2) specialty_short_desc" );
				PatVal.append("  , am_get_desc.am_practitioner(practitioner_id, '"+locale+"', 1) practitioner_name" );
				PatVal.append("  , TO_CHAR(preferred_date,'dd/mm/rrrr hh24:mi') preferred_date" );
				PatVal.append("  , patient_id" );
				PatVal.append("  , name_prefix" );
				PatVal.append("  , first_name" );
				PatVal.append("  , second_name" );
				PatVal.append("  , third_name" );
				PatVal.append("  , family_name" );
				PatVal.append("  , name_suffix" );
				PatVal.append("  , patient_name" );
				PatVal.append("  , gender" );
				PatVal.append("  , TO_CHAR(date_of_birth, 'dd/mm/rrrr')date_of_birth" );
				PatVal.append("  , res_tel_no" );
				PatVal.append("  , oth_contact_no" );
				PatVal.append("  , email_id" );
				PatVal.append("  , national_id_no" );
				PatVal.append("  , alt_id1_no" );
				PatVal.append("  , ALT_ID2_NO" );
				PatVal.append("  , ALT_ID3_NO" );
				PatVal.append("  , ALT_ID4_NO" );
				PatVal.append("  , OTH_ALT_ID_TYPE" );
				PatVal.append("  , OTH_ALT_ID_NO" );
				PatVal.append("  , TO_CHAR(ALT_ID1_EXP_DATE,'dd/mm/rrrr') ALT_ID1_EXP_DATE" );
				PatVal.append("  , TO_CHAR(ALT_ID2_EXP_DATE,'dd/mm/rrrr') ALT_ID2_EXP_DATE" );
				PatVal.append("  , TO_CHAR(ALT_ID3_EXP_DATE,'dd/mm/rrrr') ALT_ID3_EXP_DATE" );
				PatVal.append("  , TO_CHAR(ALT_ID4_EXP_DATE,'dd/mm/rrrr') ALT_ID4_EXP_DATE" );
				PatVal.append("  , res_addr_line1" );
				PatVal.append("  , res_addr_line2" );
				PatVal.append("  , res_addr_line3" );
				PatVal.append("  , res_addr_line4" );
				PatVal.append("  , postal_code" );
				PatVal.append("  , mp_get_desc.mp_postal_code(postal_code,'"+locale+"',2)postal_code_desc" );
				PatVal.append("  , country_code" );
				PatVal.append("  , patient_class_code" );
				PatVal.append("  , specialty_code" );
				PatVal.append("  , practitioner_id" );
				PatVal.append("  , chief_complaint" );
				PatVal.append("  , am_get_desc.am_complaint (chief_complaint,'"+locale+"', '1'  ) complaint_desc" );
				PatVal.append("  , REASON_FOR_REVISION_CODE" );
				PatVal.append("  , am_get_desc.am_contact_reason (reason_for_revision_code,'"+locale+"', '1'  ) contact_reason " );
				PatVal.append("  , CITIZEN_YN" );
				PatVal.append("  , LEGAL_ILLEGAL_YN" );
				PatVal.append("  , TO_CHAR(ot_date_time,'dd/mm/rrrr hh24:mi') ot_date_time" );
				PatVal.append("  , override_yn" );
				PatVal.append("  , bed_class_code" );
				PatVal.append("  , ip_get_desc.ip_bed_class(bed_class_code, '"+locale+"', 2) bed_class_short_desc ");
				PatVal.append("  , bed_type_code" );
				PatVal.append("  , ip_get_desc.ip_bed_type(bed_type_code,'"+locale+"',2)bed_type_short_desc" );
				PatVal.append("  , nursing_unit_code" );
				PatVal.append("  , ip_get_desc.ip_nursing_unit(facility_id, nursing_unit_code, '"+locale+"', 2) nursing_unit_short_desc" );
				PatVal.append("  , nursing_unit_type_code" );
				PatVal.append("  , TO_CHAR(booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time" );
				PatVal.append("  , team_id" );
				PatVal.append("  , blood_donation_yn" );
				PatVal.append("  , amb_reqd_yn" );
				PatVal.append("  , nationality_code" );
				PatVal.append("  , mp_get_desc.mp_country(nationality_code, '"+locale+"', 1) NATIONALITY_LONG_DESC" );
				PatVal.append("  , TO_CHAR(alt_id1_exp_date,'dd/mm/rrrr') alt_id1_exp_date" );
				PatVal.append("  , service_code" );
				PatVal.append("  , alt_id1_type" );
				PatVal.append("  , modified_date modified_date" );
				PatVal.append("  , RES_TOWN_CODE" );
				PatVal.append("  , RES_AREA_CODE" );
				PatVal.append("  , RES_REGION_CODE" );
				PatVal.append("  , MAIL_ADDR_LINE1" );
				PatVal.append("  , MAIL_ADDR_LINE2" );
				PatVal.append("  , MAIL_ADDR_LINE3" );
				PatVal.append("  , MAIL_ADDR_LINE4" );
				PatVal.append("  , MAIL_TOWN_CODE" );
				PatVal.append("  , MAIL_AREA_CODE" );
				PatVal.append("  , MAIL_REGION_CODE" );
				PatVal.append("  , MAIL_POSTAL_CODE" );
				PatVal.append("  , mp_get_desc.mp_postal_code(mail_postal_code,'"+locale+"',2)mail_postal_code_desc " );
				PatVal.append("  , MAIL_COUNTRY_CODE" );
				PatVal.append("  , ETHNIC_GRP_CODE" );
				PatVal.append("  , mp_get_desc.mp_ethnic_group(ethnic_grp_code, '"+locale+"', 1) ETHNIC_GROUP_DESC" );
				PatVal.append("  , RACE_CODE" );
				PatVal.append("  , mp_get_desc.mp_race(race_code, '"+locale+"', 1) RACE_DESC" );
				PatVal.append("  , mp_get_desc.mp_res_town(res_town_code, '"+locale+"',1) RES_TOWN_DESC" );
				PatVal.append("  , mp_get_desc.mp_res_area(res_area_code, '"+locale+"',1) RES_AREA_DESC" );
				PatVal.append("  , mp_get_desc.mp_region(res_region_code, '"+locale+"',1) RES_REGION_DESC" );
				PatVal.append("  , mp_get_desc.mp_country(country_code, '"+locale+"', 1) RES_COUNTRY_NAME" );
				PatVal.append("  , mp_get_desc.mp_res_town(mail_town_code, '"+locale+"',1) MAIL_TOWN_DESC" );
				PatVal.append("  , mp_get_desc.mp_res_area(mail_area_code, '"+locale+"',1) MAIL_AREA_DESC" );
				PatVal.append("  , mp_get_desc.mp_region(mail_region_code, '"+locale+"',1) MAIL_REGION_DESC" );
				PatVal.append("  , mp_get_desc.mp_country(mail_country_code, '"+locale+"', 1) MAIL_COUNTRY_DESC" );
				PatVal.append("  , referral_id" );
				PatVal.append("  , alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc" );//Added by Thamizh selvi on 8th Feb 2017 against ML-MMOH-CRF-0601
				PatVal.append("  , birth_place_code" );
				PatVal.append("  , mp_get_desc.mp_birth_place(birth_place_code, '"+locale+"', 1) BIRTH_PLACE_DESC" );
				PatVal.append("  , to_char(sysdate,'dd/mm/rrrr ') sdate " );
				PatVal.append("  , NAME_PREFIX_LOC_LANG ");
				PatVal.append("  , FIRST_NAME_LOC_LANG ");
				PatVal.append("  , SECOND_NAME_LOC_LANG ");
				PatVal.append("  , THIRD_NAME_LOC_LANG ");
				PatVal.append("  , FAMILY_NAME_LOC_LANG ");
				PatVal.append("  , NAME_SUFFIX_LOC_LANG ");
				PatVal.append("  , PATIENT_NAME_LOC_LANG ");
				PatVal.append("  , TO_CHAR(EXPECTED_DISCHARGE_DATE,'dd/mm/rrrr hh24:mi') EXPECTED_DISCHARGE_DATE ");
				PatVal.append("  ,round(ot_date_time-preferred_date) pre_op_days ");
				PatVal.append("  ,DIAGNOSIS_REMARKS ");
				PatVal.append("  ,booking_type_code ");
				PatVal.append("  ,booking_status ");
				/*Wednesday, June 23, 2010,IN022062*/
				PatVal.append("  ,(select max_patient_age from mp_param where module_id = 'MP') max_patient_age ");
				PatVal.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),1) Years" );
				PatVal.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),2) Months" );
				PatVal.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),3) Days" );
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
				//Start
				PatVal.append("  , order_id order_id,order_line_no order_line_no,oper_code oper_code,oper_short_desc oper_desc, TO_CHAR (pref_surg_date, 'dd/mm/yyyy') pref_surg_date  " );
				//End
				/**/
				PatVal.append(" FROM " );
				PatVal.append("  IP_BOOKING_LIST " );
				/*Tuesday, April 27, 2010 , commented for PE since mp_param is not used in the query to get data*/
				//PatVal.append("  , MP_PARAM " );
				PatVal.append(" WHERE facility_id = '"+facilityID+"' " );
				PatVal.append("  AND bkg_lst_ref_no = '"+bkg_lst_ref_no+"'" );
				stmt = con.createStatement();
				rs= stmt.executeQuery(PatVal.toString());

		}catch(Exception e){
			//out.println("error"+ e);
			e.printStackTrace();}
		while (rs.next())
		{		

			roomno						= checkForNull(rs.getString("room_no"));
			nameprefix					= checkForNull(rs.getString("name_prefix"));
			firstname					= checkForNull(rs.getString("first_name"));
			secondname					= checkForNull(rs.getString("second_name"));
			thirdname					= checkForNull(rs.getString("third_name"));
			familyname					= checkForNull(rs.getString("family_name"));
			namesuffix					= checkForNull(rs.getString("name_suffix"));
			patientname					= checkForNull(rs.getString("patient_name"));
			gender						= checkForNull(rs.getString("gender"));
			med_service_grp				= checkForNull(rs.getString("med_ser_grp_code"));
			medsershortdesc				= checkForNull(rs.getString("med_ser_short_desc"));
			preferred_date				= checkForNull(rs.getString("preferred_date"));
			if(!(preferred_date==null || preferred_date.equals("")))
				preferred_date_converted= DateUtils.convertDate(preferred_date,"DMYHM","en",locale);			
			exp_days_of_stay			= checkForNull(rs.getString("exp_days_of_stay"));
			referral_id					= checkForNull(rs.getString("referral_id"));
			priority					= checkForNull(rs.getString("priority_ind"));
			booking_ref_no				= checkForNull(rs.getString("bkg_lst_ref_no"));
			date_of_birth				= checkForNull(rs.getString("date_of_birth"));
			if(!(date_of_birth==null || date_of_birth.equals("")))
				date_of_birth_converted = DateUtils.convertDate(date_of_birth,"DMY","en",locale);			
			Practitioner_id				= checkForNull(rs.getString("Practitioner_id"));
			pract_name					= checkForNull(rs.getString("practitioner_name"));
			specialty_code				= checkForNull(rs.getString("specialty_code"));
			spl_name					= checkForNull(rs.getString("specialty_short_desc"));
			bed_no						= checkForNull(rs.getString("bed_no"));
			override_yn					= checkForNull(rs.getString("override_yn"));
			ot_date_time				= checkForNull(rs.getString("ot_date_time"));
			if(!(ot_date_time==null || ot_date_time.equals("")))
				ot_date_time_converted = DateUtils.convertDate(ot_date_time,"DMYHM","en",locale);
			
			bed_class_code				= checkForNull(rs.getString("bed_class_code"));
			bed_class_desc				= checkForNull(rs.getString("bed_class_short_desc"));
			nursing_unit_code			= checkForNull(rs.getString("nursing_unit_code"));
			nurs_unit_sdesc				= checkForNull(rs.getString("nursing_unit_short_desc"));
			res_tel_no					= checkForNull(rs.getString("res_tel_no"));
			other_tel_no				= checkForNull(rs.getString("oth_contact_no"));
			email_id					= checkForNull(rs.getString("email_id"));
			national_id_no				= checkForNull(rs.getString("national_id_no"));
			alt_id1_no					= checkForNull(rs.getString("alt_id1_no"));
			alt_id2_no					= checkForNull(rs.getString("alt_id2_no"));
			alt_id3_no					= checkForNull(rs.getString("alt_id3_no"));
			alt_id4_no					= checkForNull(rs.getString("alt_id4_no"));
			alt_id1_exp_dt				= checkForNull(rs.getString("ALT_ID1_EXP_DATE"));
			alt_id2_exp_dt				= checkForNull(rs.getString("ALT_ID2_EXP_DATE"));
			alt_id3_exp_dt				= checkForNull(rs.getString("ALT_ID3_EXP_DATE"));
			alt_id4_exp_dt				= checkForNull(rs.getString("ALT_ID4_EXP_DATE"));
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
			//Start
			order_id=checkForNull(rs.getString("order_id"));
			order_line_no=checkForNull(rs.getString("order_line_no"));
			oper_code=checkForNull(rs.getString("oper_code"));
			oper_desc=checkForNull(rs.getString("oper_desc"));		
			pref_surg_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("pref_surg_date"),"DMY","en",locale));	
			//End	
			if(!(alt_id1_exp_dt==null || alt_id1_exp_dt.equals("")))
				alt_id1_exp_dt = DateUtils.convertDate(alt_id1_exp_dt,"DMY","en",locale);	

			if(!(alt_id2_exp_dt==null || alt_id2_exp_dt.equals("")))
				alt_id2_exp_dt = DateUtils.convertDate(alt_id2_exp_dt,"DMY","en",locale);	

			if(!(alt_id3_exp_dt==null || alt_id3_exp_dt.equals("")))
				alt_id3_exp_dt = DateUtils.convertDate(alt_id3_exp_dt,"DMY","en",locale);
				
			if(!(alt_id4_exp_dt==null || alt_id4_exp_dt.equals("")))
				alt_id4_exp_dt = DateUtils.convertDate(alt_id4_exp_dt,"DMY","en",locale);	

			oth_alt_id_no				= checkForNull(rs.getString("OTH_ALT_ID_NO"));
			oth_alt_id_type				= checkForNull(rs.getString("OTH_ALT_ID_TYPE"));
			res_addr_line1				= checkForNull(rs.getString("res_addr_line1"));
			res_addr_line2				= checkForNull(rs.getString("res_addr_line2"));
			res_addr_line3				= checkForNull(rs.getString("res_addr_line3"));
			res_addr_line4				= checkForNull(rs.getString("res_addr_line4"));
			postal_code					= checkForNull(rs.getString("postal_code"));
			postal_code_desc			= checkForNull(rs.getString("postal_code_desc"));
			country_code				= checkForNull(rs.getString("country_code"));
			country_desc				= checkForNull(rs.getString("RES_COUNTRY_NAME")); 
			patient_id					= checkForNull(rs.getString("patient_id"));
			chief_complaint				= checkForNull(rs.getString("chief_complaint"));
			comp_desc					= checkForNull(rs.getString("complaint_desc"));
			reason_revise				= checkForNull(rs.getString("reason_for_revision_code"));
			rev_desc					= checkForNull(rs.getString("contact_reason"));
			patientclasscode			= checkForNull(rs.getString("patient_class_code"));
			team_code					= checkForNull(rs.getString("team_id"));     
			nationality					= checkForNull(rs.getString("nationality_code"));
			nationality_desc			= checkForNull(rs.getString("NATIONALITY_LONG_DESC"));
			alt_id1_exp_date			= checkForNull(rs.getString("alt_id1_exp_date"));
			service_code				= checkForNull(rs.getString("service_code"));
			booking_date_time			= checkForNull(rs.getString("booking_date_time"));
			if(!(booking_date_time==null || booking_date_time.equals("")))
				booking_date_time_converted = DateUtils.convertDate(booking_date_time,"DMYHM","en",locale);

			modifiedDate			= checkForNull(rs.getString("modified_date"));
			res_town_code			= checkForNull(rs.getString("RES_TOWN_CODE"));
			res_town_desc			= checkForNull(rs.getString("RES_TOWN_DESC"));
			res_area_code			= checkForNull(rs.getString("RES_AREA_CODE"));
			res_area_desc			= checkForNull(rs.getString("RES_AREA_DESC"));
			res_region_code			= checkForNull(rs.getString("RES_REGION_CODE"));
			res_region_desc			= checkForNull(rs.getString("RES_REGION_DESC"));
			mail_addr_line1			= checkForNull(rs.getString("MAIL_ADDR_LINE1"));
			mail_addr_line2			= checkForNull(rs.getString("MAIL_ADDR_LINE2"));
			mail_addr_line3			= checkForNull(rs.getString("MAIL_ADDR_LINE3"));
			mail_addr_line4			= checkForNull(rs.getString("MAIL_ADDR_LINE4"));
			mail_town_code			= checkForNull(rs.getString("MAIL_TOWN_CODE"));
			mail_town_desc			= checkForNull(rs.getString("MAIL_TOWN_DESC"));
			mail_area_code			= checkForNull(rs.getString("MAIL_AREA_CODE"));
			mail_area_desc			= checkForNull(rs.getString("MAIL_AREA_DESC"));
			mail_region_code		= checkForNull(rs.getString("MAIL_REGION_CODE"));
			mail_region_desc		= checkForNull(rs.getString("MAIL_REGION_DESC"));
			mail_postal_code		= checkForNull(rs.getString("MAIL_POSTAL_CODE"));
			mail_postal_code_desc	= checkForNull(rs.getString("mail_postal_code_desc"));
			mail_country_code		= checkForNull(rs.getString("MAIL_COUNTRY_CODE"));
			mail_country_desc		= checkForNull(rs.getString("MAIL_COUNTRY_DESC"));
			eth_grp					= checkForNull(rs.getString("ETHNIC_GRP_CODE"));
			eth_grp_desc			= checkForNull(rs.getString("ETHNIC_GROUP_DESC"));
			eth_sub_grp				= checkForNull(rs.getString("RACE_CODE"));
			race_desc				= checkForNull(rs.getString("RACE_DESC"));
			birth_place_code		= checkForNull(rs.getString("BIRTH_PLACE_CODE"));
			birth_place_desc		= checkForNull(rs.getString("BIRTH_PLACE_DESC"));
			bed_type_code		    = checkForNull(rs.getString("bed_type_code"));     
			bed_type_desc		    = checkForNull(rs.getString("BED_TYPE_SHORT_DESC"));   
			sqlsd1					= checkForNull(rs.getString("sdate"));
			/*Added by Thamizh selvi on 8th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(rs.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(rs.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(rs.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(rs.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(rs.getString("alt_area_code"));
			alt_area_desc		= checkForNull(rs.getString("alt_area_desc"));
			alt_town_code		= checkForNull(rs.getString("alt_town_code"));
			alt_town_desc		= checkForNull(rs.getString("alt_town_desc"));
			alt_region_code		= checkForNull(rs.getString("alt_region_code"));
			alt_region_desc		= checkForNull(rs.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(rs.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(rs.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(rs.getString("alt_country_code"));
			alt_country_desc	= checkForNull(rs.getString("alt_country_desc"));
			/*End*/
			blood_donation_yn		= rs.getString("blood_donation_yn");     
				if(blood_donation_yn.equals("Y")) blood_donation_yn = "Yes";	
				else blood_donation_yn = "No";

			amb_reqd_yn				= rs.getString("amb_reqd_yn");     
				if(amb_reqd_yn.equals("Y")) amb_reqd_yn = "Yes";	
				else amb_reqd_yn	= "No";

 			citizen_yn				= checkForNull(rs.getString("CITIZEN_YN"));
			legal_yn				= checkForNull(rs.getString("LEGAL_ILLEGAL_YN"));

			name_prefix_loc_lang	= checkForNull(rs.getString("NAME_PREFIX_LOC_LANG"));
			first_name_loc_lang		= checkForNull(rs.getString("first_name_loc_lang"));
			second_name_loc_lang	= checkForNull(rs.getString("second_name_loc_lang"));
			third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang"));
			family_name_loc_lang	= checkForNull(rs.getString("family_name_loc_lang"));
			name_suffix_loc_lang	= checkForNull(rs.getString("name_suffix_loc_lang"));
			patient_name_loc_lang	= checkForNull(rs.getString("patient_name_loc_lang"));
			expected_discharge_date	= checkForNull(rs.getString("EXPECTED_DISCHARGE_DATE"));
			if(!(expected_discharge_date==null || expected_discharge_date.equals("")))
			expected_discharge_date = DateUtils.convertDate(expected_discharge_date,"DMYHM","en",locale);
			/*Wednesday, June 23, 2010,IN022062*/
			max_patient_age			= rs.getString("max_patient_age");
			AGE						= rs.getInt("Years");
			MONTHS					= rs.getInt("Months");
			DAYS					= rs.getInt("Days");
			/**/
			pre_op_days				= checkForNull(rs.getString("pre_op_days"));
			
			if(pre_op_days==null || pre_op_days.equals(""))
				pre_op_days = "0";

			booking_remarks         = checkForNull(rs.getString("DIAGNOSIS_REMARKS"));
			booking_type_code       = checkForNull(rs.getString("booking_type_code"));
			booking_status			= checkForNull(rs.getString("booking_status"));
		}

			if(stmt	 != null)   stmt.close();
			if(rs	 != null)   rs.close();
			// This query is used ofr getting the admission reason
			/*
			StringBuffer sqlsb = new StringBuffer();
			sqlsb.append("select complaint_code ,complaint_desc from am_complaint_lang_vw where language_id='"+locale+"' and eff_status ='E' and complaint_code = '"+chief_complaint+"'");
			stmt = con.createStatement();
			rs= stmt.executeQuery(sqlsb.toString());
			
			if (rs.next())
			{
				comp_desc = rs.getString("complaint_desc");

			}	
			if(stmt	 != null)   stmt.close();
			if(rs	 != null)   rs.close();
			StringBuffer sqlrevise = new StringBuffer();
			sqlrevise.append("select CONTACT_REASON_CODE, CONTACT_REASON from AM_CONTACT_REASON_lang_vw where language_id='"+locale+"' and REASON_FOR_REVISE_BKG_YN = 'Y' and CONTACT_REASON_CODE = '"+reason_revise+"'");
			stmt = con.createStatement();
			rs= stmt.executeQuery(sqlrevise.toString());
			
			if (rs.next())
			{
				rev_desc = rs.getString("CONTACT_REASON");
			}
			if(stmt	 != null)   stmt.close();
			if(rs	 != null)   rs.close();
			*/

			try
			{
				StringBuffer sqlsb = new StringBuffer();
				if(sqlsb.length() > 0) sqlsb.delete(0,sqlsb.length());
				sqlsb.append("select booking_type_code,ip_get_desc.ip_booking_type(booking_type_code,'"+locale+"','2')short_desc from ip_booking_type where eff_status = 'E' order by 2");
				stmt =   con.createStatement();	
				rs   = stmt.executeQuery(sqlsb.toString());

				if(rs != null)
				{
					while(rs.next())
					{
						bookingtype_list.add(checkForNull(rs.getString(1)));
						bookingtype_list.add(checkForNull(rs.getString(2)));
					}
				}
				if(rs != null)	rs.close();
				if(stmt != null) stmt.close();
			}catch(Exception e)
			{
				
				e.printStackTrace();
			}
	//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 24/01/2013
	//Start
	try
		{
		//Maheshwaran K modified for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
		String ot_sql="SELECT  a.order_id order_id,c.order_line_no order_line_no,b.oper_code oper_code,b.short_desc oper_desc, TO_CHAR (a.pref_surg_date, 'dd/mm/yyyy') pref_surg_date  FROM ot_pending_orders_vw a, ot_oper_mast_lang_vw b , ot_pending_order_line c WHERE a.language_id = '"+locale+"'  AND b.language_id = '"+locale+"' AND a.performing_facility_id = '"+facilityID+"' and b.order_catalog_code=c.order_catalog_code  and a.order_id=c.order_id  AND b.order_catalog_code IN (SELECT order_catalog_code   FROM ot_pending_order_line WHERE order_id = a.order_id AND ROWNUM = 1)  AND a.pref_surg_date BETWEEN TO_DATE (NVL (to_char(SYSDATE,'DD/MM/YYYY'), '01/01/1900') || '00:00','DD/MM/YYYY HH24:MI') AND TO_DATE (NVL ('', '01/01/3000') || '23:59','DD/MM/YYYY HH24:MI') and a.patient_id='"+patient_id+"' and a.order_id in (select order_id from ip_booking_list where patient_id='"+patient_id+"' and facility_id='"+facilityID+"'and order_id is not null and bkg_lst_ref_no='"+bkg_lst_ref_no+"') and a.patient_id = (SELECT  x.patient_id FROM ot_pending_orders_vw x, ot_oper_mast_lang_vw y ,ot_pending_order_line z WHERE x.language_id = '"+locale+"'  AND y.language_id = '"+locale+"' AND x.performing_facility_id = '"+facilityID+"' AND y.order_catalog_code = z.order_catalog_code  AND x.order_id = z.order_id AND y.order_catalog_code IN (SELECT order_catalog_code   FROM ot_pending_order_line WHERE order_id = x.order_id AND ROWNUM = 1)  AND x.pref_surg_date BETWEEN TO_DATE (NVL (to_char(SYSDATE,'DD/MM/YYYY'), '01/01/1900') || '00:00','DD/MM/YYYY HH24:MI') AND TO_DATE (NVL ('', '01/01/3000') || '23:59','DD/MM/YYYY HH24:MI') and x.patient_id='"+patient_id+"' group by x.patient_id having count(x.patient_id)=1) ";
		rstmt=con.createStatement();
		rset=rstmt.executeQuery(ot_sql);
		}
	catch(SQLException e)	
		{
	//	System.out.println("Exception occurred while executing the query to get Surgery Order Details : "+e);
		e.printStackTrace();
		}
	try
		{
		if(order_id.equals(""))
			{
			if(rset!=null)
				{
				if(rset.next())
					{
					order_id=checkForNull(rset.getString("order_id"));
					order_line_no=checkForNull(rset.getString("order_line_no"));
					oper_code=checkForNull(rset.getString("oper_code"));
					oper_desc=checkForNull(rset.getString("oper_desc"));		
					pref_surg_date=checkForNull(com.ehis.util.DateUtils.convertDate(rset.getString("pref_surg_date"),"DMY","en",locale));	
					//disable_surg="disabled";//Maheshwaran K commented for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
					}
				//else//Maheshwaran K commented for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
					//{
					//disable_surg="";
				//	}
				}
			}
		rstmt.close();
		rset.close();
		}
	catch(SQLException e)	
		{
	//	System.out.println("Exception occurred while getting the Surgery Order Details  : "+e);
		e.printStackTrace();
		}	
	finally
		{
		try
			{if(rstmt!=null)
			rstmt.close();
			}
		catch(Exception e)	
			{
				e.printStackTrace();
			}
		}

	//End
	
	/*Added Below Line code for this incident [23474] */
			String language_direction="";
			try{
			int count=0;
		    rstmt=con.createStatement();
			//preparedStatement pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			
		   rset = rstmt.executeQuery("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID='"+locale+"'" ) ;
				 
			 if ( rset != null && rset.next() ) 
			 {
			 count = rset.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "RTL" ;
			}else
			{
				 language_direction = "LTR" ;
			}
			
			if (rset!=null) rset.close();
			if (rstmt!=null) rstmt.close();
			
	
	}catch(Exception e1){
	 e1.printStackTrace();
	}
	/*Added Above Line code for incident [23474] */
	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y"))
		{ 
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
	
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ot_date_time_converted));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pre_op_days));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(sqlsd1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(DayVal));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(exp_days_of_stay));
            _bw.write(_wl_block24Bytes, _wl_block24);
 if(referral_id != "") { 
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
} else {
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(medsershortdesc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(expected_discharge_date));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(exp_days_of_stay));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(expected_discharge_date));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
  if(priority.equals("U")) {		
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
	} if(priority.equals("N"))	{	
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
		}	
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(booking_date_time_converted));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(rev_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(spl_name));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

	// This query is used for populating the medical team
	StringBuffer teamsql = new StringBuffer();
	teamsql.append("Select AM_GET_DESC.AM_MEDICAL_TEAM(facility_id,team_id, ?,'2') TEAM_SHORT_DESC, TEAM_ID from AM_PRACT_FOR_TEAM_VW where facility_id =? and practitioner_id =? and appl_for_ip_yn = 'Y' and speciality_code = ? order by 1");
	stmt2				= con.prepareStatement(teamsql.toString());
	stmt2.setString(1,locale);
	stmt2.setString(2,facilityID);
	stmt2.setString(3,Practitioner_id);
	stmt2.setString(4,specialty_code);
	rs2					= stmt2.executeQuery();
	if(rs2 != null)
	{
		while(rs2.next())
		{
			String TeamCode = rs2.getString("TEAM_ID");	
			String TeamDesc = rs2.getString("TEAM_SHORT_DESC");	

			if(team_code.equals(TeamCode)){ 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(TeamCode));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(TeamDesc));
            _bw.write(_wl_block67Bytes, _wl_block67);
}else { 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(TeamCode));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(TeamDesc));
            _bw.write(_wl_block69Bytes, _wl_block69);
 }
		}
 	}

            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(ot_date_time_converted));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(booking_remarks));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

			for(int i=0;i<bookingtype_list.size();i+=2){
			if(booking_type_code.equals(bookingtype_list.get(i)))
			{
			
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bookingtype_list.get(i)));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bookingtype_list.get(i+1)));
            _bw.write(_wl_block67Bytes, _wl_block67);
}else
				{
		
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bookingtype_list.get(i)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bookingtype_list.get(i+1)));
            _bw.write(_wl_block69Bytes, _wl_block69);
}}
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(old_nursing_unit));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(nurs_unit_sdesc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(nurs_unit_sdesc));
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

	if(!nursing_unit_code.equals(""))	
	{
		// This query is used for populating the services for selected nursing unit
		StringBuffer sqlservice = new StringBuffer();
		sqlservice.append("Select service_code,am_get_desc.am_service(service_code,'"+locale+"','2') service_short_desc ");
		sqlservice.append("from ip_nurs_unit_for_service where ");
		sqlservice.append("facility_id = ? and nursing_unit_code = ? ");
		sqlservice.append("union select service_code, am_get_desc.am_service(service_code,'"+locale+"','2') service_short_desc ");
		sqlservice.append("from ip_nursing_unit where facility_id = ? ");
		sqlservice.append("and nursing_unit_code = ? order by 2 ");
		pstmt = con.prepareStatement(sqlservice.toString());
		pstmt.setString(1,facilityID);
		pstmt.setString(2,nursing_unit_code);
		pstmt.setString(3,facilityID);
		pstmt.setString(4,nursing_unit_code);
		prs = pstmt.executeQuery();

		if(prs != null)
		{
			while(prs.next())
			{
				if(service_code.equals(prs.getString(1))){
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(prs.getString(1)));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(prs.getString(2)));
            _bw.write(_wl_block96Bytes, _wl_block96);
}	else {
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(prs.getString(1)));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(prs.getString(2)));
            _bw.write(_wl_block99Bytes, _wl_block99);
          }
			}	
		}
	}
	
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

		if(!bed_class_code.equals(""))
		{
			if((bed_class_code!=null))

            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bed_class_desc));
            _bw.write(_wl_block1Bytes, _wl_block1);
	
		}

            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

		if(!bed_type_code.equals(""))
		{
			if((bed_type_code!=null))

            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bed_type_desc));
            _bw.write(_wl_block1Bytes, _wl_block1);
	
		}

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bed_type_desc));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.override.label","common_labels")));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(disabledAttrib));
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(disabledAttrib));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(oper_desc));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(bkg_lst_ref_no));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(bkg_lst_ref_no));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

		if(pref_surg_date!=null)
			{
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(pref_surg_date));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(pref_surg_date));
            _bw.write(_wl_block132Bytes, _wl_block132);

			}
		else
			{
			
            _bw.write(_wl_block133Bytes, _wl_block133);
}
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirm.label","common_labels")));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block136Bytes, _wl_block136);


	if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y"))
		{
			
            _bw.write(_wl_block137Bytes, _wl_block137);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("IP")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf("CONFIRMBOOKING")},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("I")},{ weblogic.utils.StringUtils.valueOf("bookingrefno"), weblogic.utils.StringUtils.valueOf(booking_ref_no
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block139Bytes, _wl_block139);

		}
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(Sdate));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(multi_book_pat_yn));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(preferred_date));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(bkg_lst_ref_no));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(citizen_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(legal_yn));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(oper_desc));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(block_bed_based_on));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(booking_status));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(preferred_date_converted));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(nameprefix));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(nameprefix));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(firstname));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(secondname));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(thirdname));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(familyname));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(name_suffix_loc_lang));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(date_of_birth_converted));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(max_patient_age));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(AGE));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(MONTHS));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(DAYS));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(AGE));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(MONTHS));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(DAYS));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(chief_complaint));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(reason_revise));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(override_yn));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(ot_date_time));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(ot_date_time_converted));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf( birth_place_desc));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf( birth_place_desc));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(alt_id1_exp_dt));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(alt_id2_exp_dt));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(alt_id3_exp_dt));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(alt_id4_exp_dt));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(oth_alt_id_type));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(oth_alt_id_no));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(eth_grp_desc));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(eth_grp));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(eth_grp));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(eth_sub_grp));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(eth_sub_grp));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(res_addr_line1));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(res_addr_line2));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(res_addr_line3));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(res_addr_line4));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(postal_code_desc));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(res_region_code));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(res_region_desc));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(country_desc));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(mail_addr_line1));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(mail_addr_line2));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(mail_addr_line3));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(mail_addr_line4));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(mail_town_code));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(mail_town_desc));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(mail_area_code));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(mail_area_desc));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(mail_postal_code));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(mail_postal_code_desc));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(mail_region_code));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(mail_region_desc));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(mail_country_code));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(mail_country_desc));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(alt_addr_line1));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(alt_addr_line2));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(alt_addr_line3));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(alt_addr_line4));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(alt_area_code));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(alt_area_desc));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(alt_town_code));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(alt_town_desc));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(alt_region_code));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(alt_region_desc));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(alt_postal_code));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(alt_postal_desc));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(alt_country_code));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(alt_country_desc));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(res_tel_no));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(other_tel_no));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block256Bytes, _wl_block256);
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(Practitioner_id));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(patientclasscode));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(override_yn));
            _bw.write(_wl_block260Bytes, _wl_block260);

		if (rs != null)		rs.close();  
		if (stmt != null)	stmt.close();
		if (rs1 != null)	rs1.close(); 
		if (stmt1 != null)	stmt1.close();
		if (rs2 != null)	rs2.close(); 
		if (stmt2 != null)	stmt2.close();
		if (prs != null)	prs.close(); 
		if (pstmt != null)	pstmt.close();

	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(chk_booking_limit_by));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(Sdate));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf( modifiedDate));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(pre_op_days));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(isBlInterfaced));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(isBlInterfaced));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block272Bytes, _wl_block272);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ConfirmBookingDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ProcedureSurgeryDateTime.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PreOpPreparationDays.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrefAdmDateTime.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpdaysofStay.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MedicalServiceGroup.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingRef.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectedDischargeDateTime.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpdaysofStay.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectedDischargeDateTime.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nonurgent.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nonurgent.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingDateTime.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingDetails.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforAdmissionBooking.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforRevision.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmittingPractitioner.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ProcedureSurgeryDateTime.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingType.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitDetails.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.override.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryOrder.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryDate.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }
}
