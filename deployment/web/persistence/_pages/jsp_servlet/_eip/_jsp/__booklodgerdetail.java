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

public final class __booklodgerdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BookLodgerDetail.jsp", 1742367858557L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n    <head>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n        <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n        \n        <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n        <script src=\'../js/BookLodger.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t\t<script>\n\n\nfunction SubmitPage()\n{\n\tvar chk_out_dt_time =document.forms[0].chk_out_dt_time.value;\n\n\tif (parseInt(chk_out_dt_time.length) <= 0 )\n\t{\n\t\tvar error = getMessage(\'CAN_NOT_BE_BLANK\',\'common\');\n\t\terror = error.replace(\'$\',getLabel(\"eIP.checkoutdatetime.label\",\"IP\"));\n\t\talert(error);\t\t\t\t\t\t\n\t\tdocument.forms[0].chk_out_dt_time.focus();\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].submit();\n\t}\n}\n\n\n\n// Function will check for empty values before calling up the common lookup func..\nfunction beforeGetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)\n{\n\t\tif(document.forms[0].nursing_unit_desc.value != \"\")\n\t\t\tgetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID);\n}\n\n\n//// CODED ON 21 FEB 2004 BY SRIDHAR \n//// FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] \n//// Func will return an alert message if TO DATE is Less than FROM DATE\nfunction ComparePeriodTime(from,to)\n{\n\tif(to.value == \'\' || to.value == \'\')\n\t\treturn ;\n\telse\n\t{\n\t\tif(to.value != \'\' )\n\t\t{\n\t\t\tif(!doDateTimeChk(to))\n\t\t\t\t{\n\t\t\t\t\talert( getMessage(\"INVALID_DATE_TIME\",\"SM\") );\n\t\t\t\t\tto.focus();\n\t\t\t\t\tto.select();\n\t\t\t\t\treturn ;\n\t\t\t\t}\n\t\t}\n\n\t\tif(from.value != \'\' )\n\t\t{\n\t\t\tif(!doDateTimeChk(from))\n\t\t\t\t{\n\t\t\t\t\talert( getMessage(\"INVALID_DATE_TIME\",\"SM\") );\n\t\t\t\t\tfrom.focus();\n\t\t\t\t\tfrom.select();\n\t\t\t\t\treturn ;\n\t\t\t\t}\n\t\t\tvar frdt = from.value;\n\t\t\tvar tdt = to.value;\n\n\t\t\tPeriodcheckDateTime(frdt,tdt);\n\t\t}\n\t\telse\n\t\t\treturn ;\n\t}\n}\n\n\nfunction PeriodcheckDateTime(obj1,obj2)\n{\t\n\tvar a=obj1.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tvar splitdate1 = a[0].split(\"/\")\n\tvar splittime1 = a[1].split(\":\")\n\n\t var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));\n\n\t a=obj2.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\n\t splitdate1 = a[0].split(\"/\")\n\t splittime1 = a[1].split(\":\")\n\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));\n\n\t if(Date.parse(to_date) < Date.parse(from_date))\n\t{\n\t\talert( getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\") );\n\t\tdocument.forms[0].period_to.focus();\n\t\tdocument.forms[0].period_to.select();\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\tvar Category = document.forms[0].Category.value;\n\t\tif(Category == \'A\')\n\t\t{\n\t\t\tvar discharge_period = document.forms[0].Acc_Disc_Period;\n\t\t\tvar discharge_period_unit = document.forms[0].Acc_Disc_Period_unit;\n\t\t}\n\t\telse if(Category == \'L\')\n\t\t{\n\t\t\tvar discharge_period = document.forms[0].Lodger_Disc_Period;\n\t\t\tvar discharge_period_unit = document.forms[0].Lodger_Disc_Period_unit;\n\t\t}\n\n\t\tValidateDischargeDateTime(obj1,obj2,discharge_period,discharge_period_unit )\n\t}\t\n}\t\n/* END OF PERIOD VALIDTION */\n\n\n//// CODED ON 17 MAY 2004 BY SRIDHAR \n//// Func will test the Period To value with Maximum Period of Stay after Discharge from IP param & return an alert message if TO DATE is greated than Discharge Time..\nfunction ValidateDischargeDateTime(from, to, discharge_period, unit)\n{\t\n\tif(discharge_period.value != \"\")\n\t{\n\t\tvar prefDateTime = from;\n\t\tvar retval = true;\n\t\t\n\t\tvar a =  from.split(\" \")\n\t\tsplitdate=a[0];\n\t\tsplittime=a[1];\n\t\tvar splitdate1 =a[0].split(\"/\");\n\t\tvar splittime1= a[1].split(\":\");\n\n\t\tvar from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\t\ta = to.split(\" \")\n\t\tsplitdate=a[0];\n\t\tsplittime=a[1];\n\t\tsplitdate1 =a[0].split(\"/\");\n\t\tsplittime1= a[1].split(\":\");\n\n\t\tvar to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\t\n\t\tif(unit.value == \'D\')\n\t\t{\n\t\t\tvar expDaysofStay = discharge_period.value;\n\t\t\tvar xmlDoc = \"\"\n\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\txmlStr =\"<root><SEARCH criteria=\'Days\' prefDateTime=\\\"\"+prefDateTime+\"\\\" expDaysofStay=\\\"\"+expDaysofStay+\"\\\" /></root>\"\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\txmlHttp.open(\"POST\",\"ValidateRenewPeriod.jsp\",false)\n\t\t\txmlHttp.send(xmlDoc)\n\t\t\tresponseText=xmlHttp.responseText\n\t\t\tresponseText = trimString(responseText)\n\n\t\t}\n\t\telse if(unit.value == \'H\')\n\t\t{\n\t\t\tvar expHoursofStay = discharge_period.value;\n\t\t\texpHoursofStay = expHoursofStay / 24;\n\n\t\t\tvar xmlDoc = \"\"\n\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\txmlStr =\"<root><SEARCH criteria=\'Hours\' prefDateTime=\\\"\"+prefDateTime+\"\\\" expHoursofStay=\\\"\"+expHoursofStay+\"\\\" /></root>\"\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\txmlHttp.open(\"POST\",\"ValidateRenewPeriod.jsp\",false)\n\t\t\txmlHttp.send(xmlDoc)\n\t\t\tresponseText=xmlHttp.responseText\n\t\t\tresponseText = trimString(responseText)\n\t\t}\t\t\n\t\t\n\t\ta = responseText.split(\" \")\n\t\tsplitdate=a[0];\n\t\tsplittime=a[1]\n\n\t\tsplitdate1 =a[0].split(\"/\")\n\t\tsplittime1= a[1].split(\":\")\n\n\t\tvar exp_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\t\tif((Date.parse(from_date) > Date.parse(to_date)) || (Date.parse(to_date) > Date.parse(exp_date)))\n\t\t{\n\t\t\tvar Category = document.forms[0].Category.value;\n\t\t\tif(Category == \'A\')\n\t\t\t{\n\t\t\t\tvar error\t= getMessage(\"LODGER_PERIOD_CHECK\",\"IP\") ;\n\t\t\t\terror\t\t= error.replace(\"Lodger\", getLabel(\"eIP.AccompanyingPerson.label\",\"IP\"));\n\t\t\t\talert(error);\n\t\t\t}\n\t\t\telse if(Category == \'L\')\n\t\t\t{\n\t\t\t\talert( getMessage(\"LODGER_PERIOD_CHECK\",\"IP\") );\n\t\t\t}\n\n\t\t\tdocument.forms[0].period_to.focus();\n\t\t\tdocument.forms[0].period_to.select();\n\t\t\tretval = false;\n\t\t\treturn retval\n\t\t}\n\t   return retval\n\t}\n}\n\n\n//// CODED ON 23 FEB 2004 BY SRIDHAR \n//// FUNC USED TO COMPARE [PERIOD FROM DATE TIME] WITH [CHECK IN DATE TIME] \n//// Func will return an alert message if FROM DATE is Less than CHDCKIN DATE\nfunction CompareCheckInTime(from,to)\n{\n\tvar str = new Object(from.value);\n\tif(from.value != \'\' && to.value != \'\')\n\t{\n\t\tif(!doDateTimeChk(from))\n\t\t{\n\t\t\tfrom.focus();\n\t\t\tfrom.select();\n\t\t\talert( getMessage(\"INVALID_DATE_TIME\",\"SM\") );\n\t\t\treturn;\n\t\t}\n\t\telse\n\t\tif(!doDateTimeChk(to))\n\t\t{\n\t\t\tto.focus();\n\t\t\tto.select();\n\t\t\talert( getMessage(\"INVALID_DATE_TIME\",\"SM\") );\n\t\t\treturn;\n\t\t}\n\n\tCheckInDateTime(from.value,to.value);\n\t}\n\telse return;\n}\n\nfunction CheckInDateTime(obj1,obj2)\n{\t\n\tvar a=obj1.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tvar splitdate1 = a[0].split(\"/\")\n\tvar splittime1 = a[1].split(\":\")\n\n\t var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));\n\n\t a=obj2.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\n\t splitdate1 = a[0].split(\"/\")\n\t splittime1 = a[1].split(\":\")\n\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));\n\n\t if(Date.parse(to_date) < Date.parse(from_date))\n\t{\n\t\talert(getMessage(\"PR_GT_CHK_DT\",\"IP\"));\n\t\tdocument.forms[0].period_from.focus();\n\t\tdocument.forms[0].period_from.select();\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\t\n}\t\n/* END OF PERIOD VALIDTION */\n\nfunction localValidations(obj)\n{}\n\n\nfunction CompareCheckTime(Obj)\n{\n\tvar dateTo=Obj;\n\tvar dateFrom=document.forms[0].period_from;\n\tif(!doDateCheckAlert(dateTo,dateFrom))\n\t{\n\t\talert(getMessage(\"PR_GT_CHK_DT\",\"IP\"));\n\t\tdocument.forms[0].period_from.focus();\n\t\tdocument.forms[0].period_from.select();\n\t}\n}\t\n\n//// FUNC USED TO COMPARE [CHECK IN DATE TIME] WITH [SYSTEM DATE]\n//// Func will return an alert message if CheckinTime is Less than System date\nfunction CompareCheckinTime(obj,sysdateTime)\n{\n\tvar str = new Object(obj.value);\n\tif(obj.value !=\t\'\' )\n\t{\n\t\tif(!doDateTimeChk(obj))\n\t\t\t{\n\t\t\t\tobj.focus();\n\t\t\t\tobj.select();\n\t\t\t\talert( getMessage(\"INVALID_DATE_TIME\",\"SM\") );\n\t\t\t\treturn;\n\t\t\t}\n\t\t\t\tcheckDateTime(obj.value,sysdateTime);\n\t}\n\telse return;\n}\n\n\nfunction checkDateTime(from,to)\n{\t\n\tvar a = from.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tvar splitdate1 =a[0].split(\"/\")\n\tvar splittime1= a[1].split(\":\")\n\n\t var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\t a=  to.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\n\t splitdate1 =a[0].split(\"/\")\n\t splittime1= a[1].split(\":\")\n\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\t if(Date.parse(to_date) > Date.parse(from_date))\n\t{\n\t\talert(getMessage(\"CHKIN_TIME_GR_SYSDATE\",\"IP\"));\n//\t\t(\"Check-In Date Time should be Greater than System Time\");\n\t\tdocument.forms[0].chk_in_dt_time.focus();\n\t\tdocument.forms[0].chk_in_dt_time.select();\n\n\t\treturn false\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\t\n}\t\n/* End of check in time validation*/\n\nfunction compareDate(obj,checkinTimeObj,sysdateTime)\n{\n\tvar str = new Object(obj.value);\n\tif(obj != null && checkinTimeObj != null)\n\t{\n\t\tif(obj.value !=\t\'\' )\n\t\t{\n\t\t\tif(!doDateTimeChk(obj))\n\t\t\t{\n\t\t\t\tobj.focus();\n\t\t\t\tobj.select();\n\t\t\t\talert( getMessage(\"INVALID_DATE_TIME\",\"SM\") );\n\t\t\t\treturn;\n\t\t\t}\n\t\t\tif(!ValidateDateTime(checkinTimeObj,obj))\n\t\t\t{\n\t\t\t\talert(getMessage(\"CHKOUT_TIME_GT_CHKIN_TIME\",\"IP\"));\n\t\t\t\tobj.focus();\n\t\t\t\tobj.select();\n\t\t\t}\n\t\t\telse\n\t\t\t\tcheckOutDateTime(obj.value,sysdateTime);\n\t\t}\n\t\telse return;\n\t}\n}\n\n\nfunction checkOutDateTime(from,to)\n{\t\n\tvar a = from.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tvar splitdate1 =a[0].split(\"/\")\n\tvar splittime1= a[1].split(\":\")\n\n\t var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\t a=  to.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\n\t splitdate1 =a[0].split(\"/\")\n\t splittime1= a[1].split(\":\")\n\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\t if(Date.parse(to_date) < Date.parse(from_date))\n\t{\n\t\talert(getMessage(\"CHKOUT_TIME_SH_LESS_SYSTIME\",\"IP\"));\n\t\tdocument.forms[0].chk_out_dt_time.focus();\n\t\tdocument.forms[0].chk_out_dt_time.select();\n\t\treturn false ; \n\t}\n\telse\n\t{\n\t\treturn true ;\n\t}\t\n}\t\n\n\nfunction checkMax(obj)\n{\n\tif(obj.value.length > 200)\n\t{\n\t\talert(getMessage(\'REMARKS_NOT_EXCEED_200_CH\',\'SM\'));\n\t\tobj";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 =".focus();\n\t\tobj.select();\n\t}\n\telse \n\tmakeValidString(obj);\n}\n\n\nfunction CheckMaxLength(obj,max) \n{\n\tif(obj.value.length >= max) \n\t\treturn false;\n\telse \n\t\treturn true;\n}\n\n</script>\n\n\t\t";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n\n</head>\n\n<body onLoad= \'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'BlockLodgerForm\' id=\'BlockLodgerForm\' method=\'post\' action=\'../../servlet/eIP.BookLodgerServlet\' target=\'messageFrame\'>\n\t\n\t<input type=\"hidden\" name=\"hddCitizen\" id=\"hddCitizen\" value=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =">\n\t<input type=\"hidden\" name=\"hddLegal\" id=\"hddLegal\" value=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n\n\t<input type=\'hidden\' name=\'Lodger_Disc_Period\' id=\'Lodger_Disc_Period\' value= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\'hidden\' name=\'Lodger_Disc_Period_unit\' id=\'Lodger_Disc_Period_unit\' value= \"H\">\n\n\t<input type=\'hidden\' name=\'Acc_Disc_Period\' id=\'Acc_Disc_Period\' value= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\'hidden\' name=\'Acc_Disc_Period_unit\' id=\'Acc_Disc_Period_unit\' value= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" >\n\t<tr>\n\t\t<th colspan=\'7\' align=\'left\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t</tr>\n\n<!-- ###### ADDED TO DISPLAY [ ACCOMPANYING DETAILS ] FRAME FROM eMP ####### -->\n<!--  ADDED BY SRIDHAR ON 17 FEB 2004 -->\n<tr>\n\t<td align=\'left\' colspan=\'7\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \t\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \t\t\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="   \n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>  \n</tr>   \n</table>\n\n<!-- ADDED FOR LOCALLY ASIGNING THE VALUES TO THE MP FORM IN THE UPDATE MODE  -->\n<!-- ADDED BY SRIDHAR ON 9th FEB 2004   -->\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n  <script>\n\n\t\tdocument.BlockLodgerForm.patient_id.value \t= \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\tdocument.BlockLodgerForm.patient_id.disabled = true;\n\t\tdocument.BlockLodgerForm.search.disabled = true;\n\t\t\n\t\tdocument.BlockLodgerForm.patient_name.value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\tdocument.BlockLodgerForm.patient_name.disabled = true; \n\t\t\n\t\tif(document.BlockLodgerForm.name_prefix1)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.name_prefix1.value \t= \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\tdocument.BlockLodgerForm.name_prefix1.disabled = true;\n\t\t}\n\t\t\n\t\tif(document.BlockLodgerForm.family_name)\n\t\t{\n\t\tdocument.BlockLodgerForm.family_name.value \t= \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\tdocument.BlockLodgerForm.family_name.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.first_name)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.first_name.value \t= \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\tdocument.BlockLodgerForm.first_name.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.second_name)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.second_name.value \t= \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\tdocument.BlockLodgerForm.second_name.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.third_name)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.third_name.value \t= \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\tdocument.BlockLodgerForm.third_name.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.name_suffix1)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.name_suffix1.value \t= \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\tdocument.BlockLodgerForm.name_suffix1.disabled = true;\n\t\t}\n\t\t\n\t\tdocument.BlockLodgerForm.sex.value \t= \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\tdocument.BlockLodgerForm.sex.disabled = true;\n\n\t\t// DATE OD BIRTH \n\t\tdocument.BlockLodgerForm.date_of_birth.value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\tdocument.BlockLodgerForm.date_of_birth.disabled = true;\n\n\t\tdocument.BlockLodgerForm.b_birth.disabled = true;\n\t\tdocument.getElementById(\'dob\').disabled = true;\n\t\tdocument.BlockLodgerForm.b_age.disabled = true;\n\t\tdocument.BlockLodgerForm.b_months.disabled = true;\n\t\tdocument.BlockLodgerForm.b_days.disabled = true;\n\n\t\tdocument.BlockLodgerForm.Birth_place_code.value \t= \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\n\t\tif((document.BlockLodgerForm.Birth_place_code.value == null) || (document.BlockLodgerForm.Birth_place_code.value == \"\"))\n\t\t{\t\n\t\t\tdocument.BlockLodgerForm.place_of_birth.value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t}else\n\t\tdocument.BlockLodgerForm.birth_place.value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\n\t\tdocument.BlockLodgerForm.birth_place.disabled= true;\n\t\tdocument.BlockLodgerForm.place_of_birth.disabled= true;\n\n\t\tdocument.BlockLodgerForm.nationality_code1.value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\tdocument.BlockLodgerForm.nationality_desc.value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\tdocument.BlockLodgerForm.nationality_desc.disabled= true;\n\t\tdocument.BlockLodgerForm.nationality_id.disabled = true;\n\n\t\tdocument.BlockLodgerForm.national_id_no.value \t= \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\tdocument.BlockLodgerForm.national_id_no.disabled =true;\n\n\t\tif(document.BlockLodgerForm.myKadBtn)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.myKadBtn.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.alt_id1_no)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id1_no.value \t= \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id1_no.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id2_no)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id2_no.value \t= \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id2_no.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id3_no)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id3_no.value \t= \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id3_no.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id4_no)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id4_no.value \t= \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id4_no.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id1_exp_date)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id1_exp_date.value \t= \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id1_exp_date.disabled = true;\n\t\t}\n\t\t\n\t\tif(document.BlockLodgerForm.alt_id2_exp_date)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id2_exp_date.value \t= \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id2_exp_date.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id3_exp_date)\n\t\t{\t\n\t\t\tdocument.BlockLodgerForm.alt_id3_exp_date.value = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id3_exp_date.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id4_exp_date)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id4_exp_date.value = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id4_exp_date.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.other_alt_type)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.other_alt_type.value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\tdocument.BlockLodgerForm.other_alt_type.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.other_alt_Id)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.other_alt_Id.value = \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\t\t\tdocument.BlockLodgerForm.other_alt_Id.disabled = true;\n\t\t}\n\t\n\t\tdocument.BlockLodgerForm.ethnic_group.value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\tdocument.BlockLodgerForm.ethnic_group.disabled = true;\n\n\t\tdocument.BlockLodgerForm.race_code.value = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\n\t\tif(document.BlockLodgerForm.race_desc) {\n\t\t\tdocument.BlockLodgerForm.race_desc.value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\tdocument.BlockLodgerForm.race_desc.disabled = true;\n\t\t\tdocument.BlockLodgerForm.race_desc_id.disabled = true;\n\t\t}\n\n// For populating EthnicSubGrp..\n\n\t\t/*\n\t\tvar obj =document.forms[0].race_code;\n\t\tvar opt= document.createElement(\'Option\');\n\t\topt.text=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"; \n\t\topt.value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"; \n\t\tobj.add(opt)\n\t\topt.selected = true;\n\t\tdocument.BlockLodgerForm.race_code.disabled = true;\n\t\t*/\n\t\t\n\t\t\n\t\tif(document.BlockLodgerForm.hddCitizen.value == \"Y\")\n\t\t\tdocument.BlockLodgerForm.citizen_yn[0].checked = true;\n\t\telse\n\t\t\tdocument.BlockLodgerForm.citizen_yn[1].checked = true;\n\n\t\tdocument.BlockLodgerForm.citizen_yn[0].disabled = true;\t\t\n\t\tdocument.BlockLodgerForm.citizen_yn[1].disabled = true;\t\t\n\n\n\t\tif(document.BlockLodgerForm.hddLegal.value == \"Y\")\n\t\t\tdocument.BlockLodgerForm.legal_yn[0].checked = true;\n\t\telse\n\t\t\tdocument.BlockLodgerForm.legal_yn[1].checked = true;\n\n\t\tdocument.BlockLodgerForm.legal_yn[0].disabled = true;\t\t\n\t\tdocument.BlockLodgerForm.legal_yn[1].disabled = true;\t\t\n\n\t\t//\tPatient contact details popup ================ \n\t\t// to diable the Contact Detail Button\n\t\t//\tdocument.BlockLodgerForm.contact_details.disabled = true;\n\n\t\tdocument.BlockLodgerForm.addr_line1.value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\tdocument.BlockLodgerForm.addr_line1.disabled = true;\n\n\t\tdocument.BlockLodgerForm.addr_line2.value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\tdocument.BlockLodgerForm.addr_line2.disabled = true;\n\n\t\tdocument.BlockLodgerForm.addr_line3.value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\tdocument.BlockLodgerForm.addr_line3.disabled = true;\n\n\t\tdocument.BlockLodgerForm.addr_line4.value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\tdocument.BlockLodgerForm.addr_line4.disabled = true;\n\n\t\tdocument.BlockLodgerForm.res_town_code.value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\tdocument.BlockLodgerForm.res_town_desc.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\n\t\tdocument.BlockLodgerForm.res_area_code.value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\tdocument.BlockLodgerForm.res_area_desc.value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\n\t\tdocument.BlockLodgerForm.region_code.value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\tdocument.BlockLodgerForm.region_desc.value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\t\t\n\t\tdocument.BlockLodgerForm.postal_code.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\tdocument.BlockLodgerForm.country_desc.value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\n\t\tdocument.BlockLodgerForm.contact1_name.value=\'\';\n\n\t\tdocument.BlockLodgerForm.addr2_type.value=\'\';\n\n\t\tdocument.BlockLodgerForm.mail_addr_line1.value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\t\tdocument.BlockLodgerForm.mail_addr_line1.disabled = true;\n\n\t\tdocument.BlockLodgerForm.mail_addr_line2.value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\tdocument.BlockLodgerForm.mail_addr_line2.disabled = true;\n\n\t\tdocument.BlockLodgerForm.mail_addr_line3.value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\n\t\tdocument.BlockLodgerForm.mail_addr_line3.disabled = true;\n\n\t\tdocument.BlockLodgerForm.mail_addr_line4.value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\t\tdocument.BlockLodgerForm.mail_addr_line4.disabled = true;\n\n\t\tdocument.BlockLodgerForm.mail_res_town_code.value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\tdocument.BlockLodgerForm.mail_res_town_desc.value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\t\t\n\t\tdocument.BlockLodgerForm.mail_res_area_code.value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\tdocument.BlockLodgerForm.mail_res_area_desc.value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\t\t\n\t\tdocument.BlockLodgerForm.mail_postal_code.value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\n\t\tdocument.BlockLodgerForm.mail_region_code.value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\t\tdocument.BlockLodgerForm.mail_region_desc.value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\tdocument.BlockLodgerForm.mail_region_desc.readOnly = true; \n\n\t\tdocument.BlockLodgerForm.mail_country_code.value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\tdocument.BlockLodgerForm.mail_country_desc.value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\n\t\tdocument.BlockLodgerForm.contact2_name.value=\'\';\n\t\tdocument.BlockLodgerForm.contact1_no.value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\t\tdocument.BlockLodgerForm.contact2_no.value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\t\tdocument.BlockLodgerForm.email.value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n </script>\n\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" >\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t<tr><th align=\'left\' colspan=\'8\' >&nbsp;";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" </th><th></th></tr> \n\n<!--  ADDED BY SRIDHAR ON 13 FEB 2004 -->\n<!--****************** CHECK IN DATE / TIME  ******************-->\n<tr>\n<td class=\"label\" align=\"right\" >\n\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\nCheck in Date/time&nbsp;&nbsp;</td>\n<td nowrap class=\'QUERYDATA\' >\n\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t<input type=\"text\" id=\'blockfrom\' name=\"chk_in_dt_time\" id=\"chk_in_dt_time\" maxlength=16 size=16 onblur =\"CompareCheckinTime(this,\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\');\" value =\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" ><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].chk_in_dt_time.focus();return showCalendar(\'blockfrom\',null,\'hh:mm\');\">\n\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="     \n</td> \n\n<!--****************** RELATION WITH PATIENT ******************-->\n<!--  ADDED BY SRIDHAR ON 20 FEB 2004 -->\n</td>\n\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" \n\t<td class=\"label\" align=\"right\"  nowrap size =\'15\' maxlength = \'15\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="&nbsp;</td>\n\t<td class=\'QUERYDATA\' >\n\n\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t\n</td>\n<!--******************* PERIOD FROM ********************-->\n<tr>\n<td class=\"label\" align=\"right\" nowrap> ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="&nbsp;&nbsp;</td>\n<td nowrap class=\'QUERYDATA\' >\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t<input type=\"text\" id=\'periodfrom\' name=\"period_from\" id=\"period_from\" maxlength=16 size=16 onblur =\"CompareCheckInTime(chk_in_dt_time,this);ComparePeriodTime(this,period_to);\" value =\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].period_from.focus();return showCalendar(\'periodfrom\',null,\'hh:mm\');\" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>  \n\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="   \n</td>  \n\n<!--****************** PERIOD TO *********************-->\n<td class=\"label\" align=\"right\" nowrap> ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="&nbsp;&nbsp;</td>\n<td colspan=\"4\" nowrap class=\'QUERYDATA\' >\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t<input type=\"text\" id=\'periodto\' align= \"left\" name=\"period_to\" id=\"period_to\" maxlength=16 size=16 onblur=\"ComparePeriodTime(period_from,this);\" value =\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" ><input type=\"image\" \tsrc=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].period_to.focus();return showCalendar(\'periodto\',null,\'hh:mm\');\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>  \n\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n</tr>\n\n<!--****************** NURSING UNIT **************-->\n<tr>\n\t<td class=\"label\" align=\"right\" nowrap>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&nbsp;&nbsp;</td>\n\t<td nowrap class=\'QUERYDATA\' >\n\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t<input type=text name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" width=\"16\" maxlength=16 size=16  onblur=\"beforeGetNursingUnit(this, \'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\',\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\');\" ><input type=button class=button name=\'nursing_unit_lookup\' id=\'nursing_unit_lookup\'  value=\'?\' onClick=\"getNursingUnit(nursing_unit_desc, \'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\');\" >\n\t\t<input type=hidden name=\"lodger_nursing_unit\" id=\"lodger_nursing_unit\" width=\"15\" >\n\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n</td>\n\n<!--*************** AUTHORIZED BY ************************-->\n\n<td class=\"label\" align=\"right\" >";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="&nbsp;</td>\n\t<td colspan=4 nowrap class=\'QUERYDATA\' >\n\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t<input type=\"text\" name=\"authorised_by\" id=\"authorised_by\" maxlength=16 size=16 value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" onBlur=\'makeValidString(this);\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" \n\t</td>\n</tr>\n\n<!--******************** REMARKS *******************-->\n<tr>\n\t<td class=\"label\" align=\"right\" >";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="&nbsp;&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t<td class=\'QUERYDATA\' colspan=6 wrap>\n\t\t\t<textarea name=\"remarks\" rows=3  cols=84 maxLength=\'200\' onKeypress=\"return CheckMaxLength(this,200)\" onBlur=\"checkMax(this);\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</textarea>\n\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t<td class=\'QUERYDATA\' colspan=\'8\'>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td></tr>\n\t\t\t<tr><td class=\'blankRowDisp\' colspan=\'8\' align=\'left\'>&nbsp;</td><td></td></tr>\n\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" \n\t\t</td>\n</tr>\n\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n<!--**************** CHECK OUT DATE / TIME ************-->\n\t <tr>\n\t\t <td class=\"label\" align=\"right\" nowrap>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" Check Out Date/time&nbsp;&nbsp;</td>\n\t\t<input type=\"hidden\" name=\"chk_in_dt_time\" id=\"chk_in_dt_time\" maxlength=16 size=16 onblur =\"dateVal(this)\" value =\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"></td>\n\t\t<td><input type=\"text\" id=\'chkoutdttime\' name=\"chk_out_dt_time\" id=\"chk_out_dt_time\" maxlength=16 size=16 onblur =\"compareDate(this,document.forms[0].chk_in_dt_time,\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" ><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].chk_out_dt_time.select();return showCalendar(\'chkoutdttime\', null, \'hh:mm\' );\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t<td colspan=\'8\'>&nbsp;</td>\n\n\t\t</tr>  \n\n\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n  </td>\n</tr>\n\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n<tr><td colspan=\'10\' align=\'left\' class=\'button\'>&nbsp;</td></tr>\n\t<tr>\n\t\t\t<td colspan=\'10\' align=\'right\' class=\'button\'>\n\t\t\t\t<input type=\'button\' value=\'Release Lodger/ Attendant\' name=\'release_lodger\' id=\'release_lodger\' class=\'button\' onClick=\"SubmitPage()\">\n\t\t\t\t<input type=\'button\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' name=\'cancel\' class=\'button\' onclick=\'parent.window.close();\'>\n\t\t\t</td>\n\t\t</tr>\n<tr><td colspan=\'10\' align=\'left\' class=\'button\'>&nbsp;</td></tr>\n<tr><td colspan=\'10\' align=\'left\' class=\'button\'>&nbsp;</td></tr>\n<tr><td colspan=\'10\' align=\'left\' class=\'button\'>&nbsp;</td></tr>\n<tr><td colspan=\'10\' align=\'left\' class=\'button\'>&nbsp;</td></tr>\n\n\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" \n</table>\n            <input type=\"hidden\" name=\'Category\' id=\'Category\' value = \"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"> \n            <input type=\"hidden\" name=\'lodger_ref_no\' id=\'lodger_ref_no\' value = \"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"> \n\t        <input type=\"hidden\" name=\'pat_id\' id=\'pat_id\' value = \"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">  \n            <input type=\"hidden\" name=\'encounter_id\' id=\'encounter_id\' value = \"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"> \n\t\t\t<input type=\"hidden\" name=\"to_chk_in_dt_time\" id=\"to_chk_in_dt_time\" maxlength=16 size=16 onblur =\"dateVal(this)\" value =\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"> \n            <input type=\'hidden\' name=\'mode\' id=\'mode\' value= \"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t\t\t<input type=\'hidden\' name=\'label\' id=\'label\' value= \"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t\t\t<input type=\'hidden\' name=\'pLine_Pat_id\' id=\'pLine_Pat_id\' value= \"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\t<input type=\'hidden\' name=\'Lodger_Max_RefNo\' id=\'Lodger_Max_RefNo\' value= \"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t\t<input type=\'hidden\' name=\'Lodger_Next_RefNo\' id=\'Lodger_Next_RefNo\' value= \"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\n        </form>\n        <script>\n\t\tif((\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" == \"insert\") && (\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" == \"L\"))\n        {\n\t\t\tparent.frames[0].document.getElementById(\'attendant\').disabled=true;\n        }\n        </script>\n\n        ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n   </body>\n</html>\n";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

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

/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckInLodger && Lodger -> CheckOutLodger
/// Developer		:	SRIDHAR R

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

			request.setCharacterEncoding("UTF-8"); 
            String facility_id = (String)session.getValue ( "facility_id" ) ;
			String p_oper_stn_id="";
			String loginUser = (String)session.getValue("login_user");

            Connection con = null;

			Statement PatIDStmt = null;
			ResultSet PatIDRS	= null ;			
			Statement stmt		= null;
            ResultSet rs		= null ;
			Statement stmt_opn	= null;
			ResultSet rs_opn	= null;
			Statement ParamStmt = null;
            ResultSet ParamRS	= null ;

            String encounter_id = request.getParameter("EncounterId");
            if(encounter_id ==null)
                encounter_id="";

            String Category = request.getParameter("Category");
            if(Category == null)
                Category = "L" ;
			
			String pat_id = request.getParameter("lodger_patient_id");
            if(pat_id ==null)    pat_id="";

/*DECLARATION OF VARIABLES */
			
			String lodger_patient_name	= "" ;
			String reason_for_stay		= "";
			String alt_long_desc		= "";
			String check_in_date_time	= "";
			String Period_date_time_from= "";
			String Period_date_time_to	= "";
			String authorized_by		= "";  
			String nursing_desc			="";
			String patientID			= "";
			String sql					="";
			String rdonly				="";
			String disabled				=""; 
			String sysdateTime			= "";
			String lodger_ref_no		= "";			
			String remarks				= "";                			
			String patient_id			= "";
			String lodger_relation_code ="";
			String pat_name_as_multipart_yn = "";
			String nameprefix		= "";
			String firstname		= "";
			String secondname		="";
			String thirdname		= "";
			String familyname		= "";
			String namesuffix		= "";
			String gender			= "";
			String date_of_birth	= "";
			String place_of_birth_code = "";
			String place_of_birth_desc = "";
			String citizen			= "";
			String legal			= "";
			String email_id			= "";
			String national_id_no	= "";
			String alt_id1_no		= "";
			String alt_id2_no		= "";
			String alt_id3_no		= "";
			String alt_id4_no		= "";
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
			String postal_code		= "";
			String country_code		= "";
			String mail_addr_line1	= "";
			String mail_addr_line2	= "";
			String mail_addr_line3	= "";
			String mail_addr_line4	= "";
			String mail_country_code= "";
			String mail_country_desc= "";
			String mail_town_code	= "";
			String mail_town_desc	= "";
			String mail_area_code	= "";
			String mail_area_desc	= "";
			String mail_region_code	= "";	
			String mail_region_desc	= "";
			String mail_postal_code	= "";
			String other_tel_no		= "";
			String oth_contact_no	= "";
			String eth_grp			= "";
			String eth_sub_grp		= "";
			String nationality_code = "";
			String alt_id1_exp_date = "";
			String alt_id2_exp_date = "";
			String alt_id3_exp_date = "";
			String alt_id4_exp_date = "";
			String lod_pat_id		= "";
			String revised_yn		= "";
			String nationality_long_desc = "";

           
           java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
            java.util.Date dt=new java.util.Date();
            String currDate = dateFormat.format( dt ) ;
            
            String min = String.valueOf(dt.getMinutes()) ;
            if(min.length() == 1)   min = "0"+min ;
            currDate=currDate + " "+String.valueOf(dt.getHours())+":"+min;
            check_in_date_time = currDate ;   
			
            String mode = request.getParameter("mode") ;
			 if( mode == null )  mode = "insert" ;

	try{
		con = ConnectionManager.getConnection(request);

		String Lodger_Max_RefNo = "";
		String Lodger_Next_RefNo = "";

		String Lodger_Period	= "";	
		String Acc_Period		= "";
		String Acc_Period_unit	= "";

		String paramSql="select LODGER_MAX_SRL_NO, LODGER_NEXT_SRL_NO, MAX_STAY_OF_LODGER_AFTER_DISC, DFLT_GATE_PASS_PERIOD, DFLT_GATE_PASS_UNIT from ip_param where facility_ID='"+facility_id+"'";

		ParamStmt = con.createStatement();
		ParamRS = ParamStmt.executeQuery( paramSql );

		if(ParamRS!=null)
		{
			if ( ParamRS.next() )
			{
				Lodger_Max_RefNo = ParamRS.getString("LODGER_MAX_SRL_NO");
				Lodger_Next_RefNo = ParamRS.getString("LODGER_NEXT_SRL_NO");

				Lodger_Period	= ParamRS.getString("MAX_STAY_OF_LODGER_AFTER_DISC");
				Acc_Period		= ParamRS.getString("DFLT_GATE_PASS_PERIOD");
				Acc_Period_unit	= ParamRS.getString("DFLT_GATE_PASS_UNIT");
			}
		}

			if(Lodger_Max_RefNo == null) Lodger_Max_RefNo="";	
			if(Lodger_Next_RefNo == null) Lodger_Next_RefNo="";	
			if(Lodger_Period == null) Lodger_Period="";
	    	if(Acc_Period == null) Acc_Period = "";
	    	if(Acc_Period_unit == null) Acc_Period_unit = "";

			if(ParamStmt == null) ParamStmt.close();
			if(ParamRS == null) ParamRS.close();

		int count=0;
		String patIDSql="select a.LODGER_PATIENT_ID LODGER_PATIENT_ID,a.LODGER_REF_NO LODGER_REF_NO, b.REVISED_YN REVISED_YN from IP_LODGER_DETAIL a, IP_LODGER_GATE_PASS b where a.facility_ID='"+facility_id+"' and a.facility_ID=b.facility_ID and a.LODGER_REF_NO=b.LODGER_REF_NO and a.LODGER_PATIENT_ID is not null";

		PatIDStmt = con.createStatement();
		PatIDRS = PatIDStmt.executeQuery( patIDSql );

		if(PatIDRS != null)
		{
			while( PatIDRS.next() )
			{
				lod_pat_id = PatIDRS.getString("lodger_patient_id");
				revised_yn = PatIDRS.getString("REVISED_YN");
				count++;
			}
		}
	
		if(PatIDStmt != null) PatIDStmt.close();
		if(PatIDRS != null)   PatIDRS.close();

		if(lod_pat_id == null) lod_pat_id = "";
		if(revised_yn == null) revised_yn = "";

		
		String operSql =" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facility_id+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ";
	
		stmt_opn = con.createStatement();
		rs_opn = stmt_opn.executeQuery(operSql);

		if (rs_opn.next())
		{
			p_oper_stn_id = rs_opn.getString("oper_stn_id");
		}

		if(rs_opn!=null)    rs_opn.close();
		if(stmt_opn!=null)  stmt_opn.close();

		stmt = con.createStatement();

		sql = "select patient_id_length, to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, pat_name_as_multipart_yn from mp_param ";

		rs  = stmt.executeQuery(sql);

		if (rs.next())
		{
			sysdateTime				= rs.getString(2);
			pat_name_as_multipart_yn = rs.getString(3);
		}
		if(rs!=null)    rs.close();
		if(stmt!=null)  stmt.close();

		sql="";

		// Get the Patient_id, if it is for Attendant
		if(Category!=null && !Category.equals("L"))
		{
			sql  = " select PATIENT_ID from PR_ENCOUNTER where encounter_id = '"+encounter_id+"' and FACILITY_ID ='"+facility_id+"' " ;    
			stmt = con.createStatement();
			rs = stmt.executeQuery( sql );
			if(rs!=null && rs.next())
			{
				patient_id = rs.getString(1);
			}
			if(rs!=null)    rs.close();
		   if(stmt!=null)  stmt.close();
		}

if( mode.equals("update") )
{
	lodger_ref_no = request.getParameter("lodger_ref_no") ;
    if(lodger_ref_no .equals("null"))  lodger_ref_no ="" ;

	nursing_desc = request.getParameter("nursing_desc") ;
	if(nursing_desc.equals("null"))  nursing_desc ="" ;

	patientID = request.getParameter("PatID") ;
    if(patientID .equals("null"))  patientID ="" ;
	
	StringBuffer ExeSQL = new StringBuffer();

ExeSQL.append(" SELECT a.PATIENT_ENCOUNTER_ID,");
ExeSQL.append(" a.LODGER_RELATION_CODE,");
ExeSQL.append(" a.REASON_FOR_STAY_CODE,");
ExeSQL.append(" a.LODGER_NAME,");
ExeSQL.append(" to_char(a.check_in_date_time,'dd/mm/rrrr hh24:mi')CHECK_IN_DATE_TIME,");
ExeSQL.append(" to_char(a.PERIOD_FROM_DATE,'dd/mm/rrrr hh24:mi')PERIOD_FROM_DATE,");
ExeSQL.append(" to_char(a.PERIOD_TO_DATE,'dd/mm/rrrr hh24:mi')PERIOD_TO_DATE,");
ExeSQL.append(" a.ATTACHED_TO_INPATIENT_YN,");
ExeSQL.append(" a.NURSING_UNIT_CODE,a.REMARKS,a.AUTHORISED_BY,a.LODGER_GENDER,");
ExeSQL.append(" to_char(a.LODGER_DOB,'dd/mm/rrrr ')LODGER_DOB,");
ExeSQL.append(" a.NAME_PREFIX, a.FIRST_NAME, a.SECOND_NAME, a.THIRD_NAME,");
ExeSQL.append(" a.FAMILY_NAME, a.NAME_SUFFIX,");
ExeSQL.append(" a.CITIZEN_YN, a.LEGAL_YN,");
ExeSQL.append(" a.ALT_ID1_TYPE,a.ALT_ID1_NO,");
ExeSQL.append(" to_char(a.ALT_ID1_EXP_DATE,'dd/mm/rrrr')ALT_ID1_EXP_DATE,");
ExeSQL.append(" a.ALT_ID2_TYPE,a.ALT_ID2_NO,");
ExeSQL.append(" to_char(a.ALT_ID2_EXP_DATE,'dd/mm/rrrr')ALT_ID2_EXP_DATE,");
ExeSQL.append(" a.ALT_ID3_TYPE, a.ALT_ID3_NO,");
ExeSQL.append(" to_char(a.ALT_ID3_EXP_DATE,'dd/mm/rrrr')ALT_ID3_EXP_DATE,");
ExeSQL.append(" a.ALT_ID4_TYPE, a.ALT_ID4_NO,");
ExeSQL.append(" to_char(a.ALT_ID4_EXP_DATE,'dd/mm/rrrr')ALT_ID4_EXP_DATE,");
ExeSQL.append(" a.OTH_ALT_ID_TYPE OTH_ALT_ID_TYPE,");
ExeSQL.append(" p.short_desc alt_short_desc,");
ExeSQL.append(" a.OTH_ALT_ID_NO OTH_ALT_ID_NO,");
ExeSQL.append(" a.LN1_LODGER_ADD, a.LN2_LODGER_ADD,");
ExeSQL.append(" a.LN3_LODGER_ADD, a.LN4_LODGER_ADD,");
ExeSQL.append(" a.LODGER_RES_TEL_NUM, a.LODGER_OFF_TEL_NUM,");
ExeSQL.append(" a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2,");
ExeSQL.append(" a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4,");
ExeSQL.append(" a.lodger_patient_id, a.national_id_no,");
ExeSQL.append(" a.BIRTH_PLACE_CODE BIRTH_PLACE_CODE, b.LONG_DESC birth_place_desc,");
ExeSQL.append(" a.ETHNIC_GROUP_CODE, c.short_Desc ETHNIC_DESCRIPTION,");
ExeSQL.append(" a.RACE_CODE, d.LONG_DESC RACE_DESCRIPTION,");
ExeSQL.append(" a.MAIL_AREA_CODE MAIL_AREA_CODE, e.short_desc MAIL_AREA_DESCRIPTION,");
ExeSQL.append(" a.MAIL_TOWN_CODE MAIL_TOWN_CODE, f.short_desc MAIL_TOWN_DESCRIPTION,");
ExeSQL.append(" a.MAIL_REGION_CODE MAIL_REGION_CODE,  g.long_desc MAIL_REGION_DESCRIPTION,");
ExeSQL.append(" a.MAIL_POSTAL_CODE MAIL_POSTAL_CODE, q.POSTAL_CODE MAIL_POSTAL_DESCRIPTION,");
ExeSQL.append(" a.MAIL_COUNTRY_CODE, i.short_name MAIL_COUNTRY_DESCRIPTION,");
ExeSQL.append(" a.RES_AREA_CODE RES_AREA_CODE , j.short_desc RES_AREA_DESCRIPTION,");
ExeSQL.append(" a.RES_TOWN_CODE RES_TOWN_CODE, f.short_desc RES_TOWN_DESCRIPTION,");
ExeSQL.append(" a.RES_REGION_CODE RES_REGION_CODE, g.long_desc RES_REGION_DESCRIPTION,");
ExeSQL.append(" a.RES_POSTAL_CODE , h.POSTAL_CODE RES_POSTAL_DESCRIPTION,");
ExeSQL.append(" a.RES_COUNTRY_CODE, i.short_name RES_COUNTRY_DESCRIPTION,");
ExeSQL.append(" a.LODGER_EMAIL,");
ExeSQL.append(" o.long_desc NATIONALITY_DESC, a.NATIONALITY_CODE NATIONALITY_CODE");
ExeSQL.append(" FROM ");
ExeSQL.append(" ip_lodger_detail a,");
ExeSQL.append(" mp_birth_place b,");
ExeSQL.append(" mp_ethnic_group c,");
ExeSQL.append(" mp_race d,");
ExeSQL.append(" mp_res_area e,");
ExeSQL.append(" mp_res_town f,");
ExeSQL.append(" mp_region g,");
ExeSQL.append(" mp_postal_code h,");
ExeSQL.append(" mp_country i,");
ExeSQL.append(" mp_res_area j,");
ExeSQL.append(" mp_res_town k,");
ExeSQL.append(" mp_region l,");
ExeSQL.append(" mp_postal_code m,");
ExeSQL.append(" mp_country n,");
ExeSQL.append(" mp_country o,");
ExeSQL.append(" MP_ALTERNATE_ID_TYPE p,");
ExeSQL.append(" mp_postal_code q");
ExeSQL.append(" WHERE ");
ExeSQL.append(" a.birth_place_code = b.birth_place_code (+) AND");
ExeSQL.append(" a.ethnic_group_code = c.ethnic_group_code (+) AND");
ExeSQL.append(" a.race_code = d.race_code (+) AND");
ExeSQL.append(" a.mail_area_code = e.res_area_code (+) AND");
ExeSQL.append(" a.mail_town_code = f.res_town_code (+) AND");
ExeSQL.append(" a.mail_region_code = g.region_code (+) AND");
ExeSQL.append(" a.mail_postal_code = q.postal_code (+) AND");
ExeSQL.append(" a.mail_country_code = i.country_code (+) AND");
ExeSQL.append(" a.res_area_code = j.res_area_code (+) AND");
ExeSQL.append(" a.res_town_code = k.res_town_code (+) AND");
ExeSQL.append(" a.res_region_code = l.region_code (+) AND");
ExeSQL.append(" a.res_postal_code = m.postal_code (+) AND");
ExeSQL.append(" a.res_country_code = n.country_code (+) AND");
ExeSQL.append(" a.nationality_code = o.country_code (+) AND");
ExeSQL.append(" a.oth_alt_id_no = p.alt_id_type (+) AND");
ExeSQL.append(" facility_id = '"+ facility_id +"' AND");
ExeSQL.append(" lodger_ref_no ='"+ lodger_ref_no +"' ");

    stmt = con.createStatement();
	rs = stmt.executeQuery(ExeSQL.toString());

	if(rs!=null)
	{
		if ( rs.next() )
		{
			rdonly = "readonly" ;
			disabled ="disabled" ;

			Category = rs.getString("ATTACHED_TO_INPATIENT_YN") ; 
			if(Category.equals("Y"))
				Category = "A" ;
			else
				Category = "L" ;


			encounter_id         = String.valueOf( rs.getLong("patient_encounter_id") );
			if(encounter_id ==null)
				encounter_id ="";

			lodger_relation_code     = rs.getString( "lodger_relation_code" );
			if(lodger_relation_code ==null)
				lodger_relation_code ="";

			reason_for_stay      = rs.getString( "reason_for_stay_code" );
			if(reason_for_stay ==null)
				reason_for_stay ="";
	
			lodger_patient_name  = rs.getString( "lodger_name" );
			if(lodger_patient_name ==null)
				lodger_patient_name ="";

			check_in_date_time   = rs.getString( "check_in_date_time" );
			 if(check_in_date_time == null)  check_in_date_time = "";


			Period_date_time_from = rs.getString("PERIOD_FROM_DATE"); 
				if(Period_date_time_from == null)	Period_date_time_from = "";


			Period_date_time_to = rs.getString("PERIOD_TO_DATE"); 
				if(	Period_date_time_to == null)	Period_date_time_to = "";

			remarks   = rs.getString( "REMARKS" );
				if(remarks ==null)     remarks ="";

			if (!remarks.equals("")) 
			{
				if (remarks.length() == 200)
					remarks = remarks.substring(0,70)+"\n"+remarks.substring(71,140)+"\n"+remarks.substring(141,200);
				else if (remarks.length() > 140)
					remarks = 	remarks.substring(0,70)+"\n"+remarks.substring(71,140)+"\n"+remarks.substring(141,remarks.length());
				else if (remarks.length() > 70)
					remarks = remarks.substring(0,70)+"\n"+remarks.substring(71,remarks.length());	
			}

			
				authorized_by        = rs.getString( "authorised_by" );
				if(authorized_by ==null)		authorized_by ="";  

				gender       = rs.getString( "lodger_gender" );
				if(gender==null) gender="";

				date_of_birth    = rs.getString( "LODGER_DOB" );
				if(date_of_birth==null) date_of_birth = "";

				nameprefix= rs.getString( "NAME_PREFIX" );
				if(nameprefix==null) nameprefix = "";

				firstname= rs.getString( "FIRST_NAME" );
				if(firstname==null) firstname="";

				secondname= rs.getString( "SECOND_NAME");
				if(secondname==null) secondname="";

				thirdname= rs.getString( "THIRD_NAME" );
				if(thirdname==null) thirdname="";

				familyname = rs.getString( "FAMILY_NAME" );
				if(familyname == null) familyname = "";

				namesuffix= rs.getString( "NAME_SUFFIX" );
				if(namesuffix==null) namesuffix="";

				citizen = rs.getString("CITIZEN_YN");
				if(citizen == null) citizen = "";

				legal = rs.getString("LEGAL_YN");
				if(legal == null) legal = "";

				alt_id1_exp_date= rs.getString( "ALT_ID1_EXP_DATE");
				if(alt_id1_exp_date==null) alt_id1_exp_date="";

				alt_id2_exp_date= rs.getString( "ALT_ID2_EXP_DATE" );
				if(alt_id2_exp_date==null) alt_id2_exp_date="";

				alt_id3_exp_date= rs.getString( "ALT_ID3_EXP_DATE" );
				if(alt_id3_exp_date==null) alt_id3_exp_date="";

				alt_id4_exp_date= rs.getString( "ALT_ID4_EXP_DATE" );
				if(alt_id4_exp_date==null) alt_id4_exp_date="";

				alt_id1_no= rs.getString( "ALT_ID1_NO" );
				if(alt_id1_no==null) alt_id1_no="";

				alt_id2_no	= rs.getString( "ALT_ID2_NO" );
				if(alt_id2_no==null) alt_id2_no="";
				
				alt_id3_no= rs.getString( "ALT_ID3_NO" );
				if(alt_id3_no==null) alt_id3_no="";

				alt_id4_no= rs.getString( "ALT_ID4_NO" );
				if(alt_id4_no==null) alt_id4_no="";

				oth_alt_id_no = rs.getString( "OTH_ALT_ID_NO" );
				if(oth_alt_id_no==null) oth_alt_id_no = "";
				
				oth_alt_id_type = rs.getString( "OTH_ALT_ID_TYPE" );
				if(oth_alt_id_type == null) oth_alt_id_type = "";

				alt_long_desc = rs.getString( "alt_short_desc" );
				if(alt_long_desc == null) alt_long_desc = "";

				place_of_birth_desc = rs.getString( "birth_place_desc" );
				if(place_of_birth_desc == null) place_of_birth_desc = "";

				place_of_birth_code = rs.getString( "BIRTH_PLACE_CODE" );
				if(place_of_birth_code == null) place_of_birth_code = "";

				eth_grp= rs.getString( "ETHNIC_GROUP_CODE" );
				if(eth_grp==null) eth_grp="";

				eth_sub_grp= rs.getString( "RACE_DESCRIPTION" );
				if(eth_sub_grp==null) eth_sub_grp="";

				national_id_no= rs.getString( "NATIONAL_ID_NO" );
				if(national_id_no==null) national_id_no="";

				nationality_code = rs.getString( "NATIONALITY_CODE" );
				if(nationality_code==null) nationality_code="";

				nationality_long_desc = rs.getString( "NATIONALITY_DESC" );
				if(nationality_long_desc  == null) nationality_long_desc  = "";

				// RESIDENCE ADDRESS & CONTACT DETAILS ==========

				res_addr_line1  = rs.getString( "LN1_LODGER_ADD" );
				if(res_addr_line1==null) res_addr_line1="";

				res_addr_line2  = rs.getString( "LN2_LODGER_ADD" );
				if(res_addr_line2==null) res_addr_line2="";

				res_addr_line3  = rs.getString( "LN3_LODGER_ADD" );
				if(res_addr_line3==null) res_addr_line3="";

				res_addr_line4  = rs.getString( "LN4_LODGER_ADD" );
				if(res_addr_line4==null) res_addr_line4="";
		
				res_town_code= rs.getString( "RES_TOWN_CODE" );
				if(res_town_code==null) res_town_code="";

				res_town_desc= rs.getString( "RES_TOWN_DESCRIPTION" );
				if(res_town_desc==null) res_town_desc="";

				res_area_code= rs.getString( "RES_AREA_CODE" );
				if(res_area_code==null) res_area_code="";

				res_area_desc= rs.getString( "RES_AREA_DESCRIPTION" );
				if(res_area_desc==null) res_area_desc="";

				res_region_code		= rs.getString("RES_REGION_CODE");
				if(res_region_code==null) res_region_code="";

				res_region_desc		= rs.getString("RES_REGION_DESCRIPTION");
				if(res_region_desc==null) res_region_desc="";

				postal_code= rs.getString( "RES_POSTAL_DESCRIPTION" );
				if(postal_code==null) postal_code="";

				country_code= rs.getString( "RES_COUNTRY_DESCRIPTION" );
				if(country_code==null) country_code="";
			
			//	MAILING ADDRESS & CONTACT DETAILS ==========
				
				mail_addr_line1= rs.getString( "MAIL_ADDR_LINE1" );
				if(mail_addr_line1==null) mail_addr_line1="";

				mail_addr_line2= rs.getString( "MAIL_ADDR_LINE2" );
				if(mail_addr_line2==null) mail_addr_line2="";

				mail_addr_line3= rs.getString( "MAIL_ADDR_LINE3" );
				if(mail_addr_line3==null) mail_addr_line3="";

				mail_addr_line4= rs.getString( "MAIL_ADDR_LINE4" );
				if(mail_addr_line4==null) mail_addr_line4="";

				mail_town_code		= rs.getString("MAIL_TOWN_CODE");
				if(mail_town_code==null) mail_town_code="";

				mail_town_desc		= rs.getString("MAIL_TOWN_DESCRIPTION");
				if(mail_town_desc==null) mail_town_desc="";

				mail_area_code		= rs.getString("MAIL_AREA_CODE");
				if(mail_area_code==null) mail_area_code="";

				mail_area_desc		= rs.getString("MAIL_AREA_DESCRIPTION");
				if(mail_area_desc==null) mail_area_desc="";

				mail_region_code	= rs.getString("MAIL_REGION_CODE");
				if(mail_region_code==null) mail_region_code="";

				mail_region_desc	= rs.getString("MAIL_REGION_DESCRIPTION");
				if(mail_region_desc==null) mail_region_desc="";

				mail_postal_code	= rs.getString("MAIL_POSTAL_CODE");
				if(mail_postal_code==null) mail_postal_code="";

				mail_country_code	= rs.getString("MAIL_COUNTRY_CODE");
				if(mail_country_code==null) mail_country_code="";
	
				mail_country_desc	= rs.getString("MAIL_COUNTRY_DESCRIPTION");
				if(mail_country_desc==null) mail_country_desc="";

				//	TEL NO & EMAIL-ID DETAILS ==========
				
				oth_contact_no       = rs.getString( "lodger_off_tel_num" );
				if(oth_contact_no ==null)		oth_contact_no ="";  

				other_tel_no       = rs.getString( "lodger_res_tel_num" );
				if(other_tel_no ==null)		other_tel_no ="";  

				email_id= rs.getString( "LODGER_EMAIL" );
				if(email_id==null) email_id="";

		}//E.o RS
	}// E.o RS !null
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(citizen));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(legal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Lodger_Period));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Acc_Period));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Acc_Period_unit));
            _bw.write(_wl_block13Bytes, _wl_block13);
out.println(( Category.equals("A") ? "&nbsp;Accompanying Person Details" : "&nbsp;Lodger Details"));
            _bw.write(_wl_block14Bytes, _wl_block14);
		
	if(mode.equals("insert"))
	{

            _bw.write(_wl_block15Bytes, _wl_block15);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("top.frames[1].frames[1].frames[2]")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("top.frames[1].frames[2]")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);
	}
	else
	{

            _bw.write(_wl_block18Bytes, _wl_block18);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("top.frames[0]")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("top.frames[1]")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);
	}

            _bw.write(_wl_block20Bytes, _wl_block20);

if(!mode.equals("insert"))
{

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lodger_patient_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nameprefix));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(familyname));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(firstname));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(secondname));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(thirdname));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(place_of_birth_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( place_of_birth_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( place_of_birth_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nationality_long_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id2_exp_date));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(alt_id3_exp_date));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alt_id4_exp_date));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(oth_alt_id_type));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(oth_alt_id_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(eth_grp));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(eth_sub_grp));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(eth_sub_grp));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(eth_sub_grp));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(eth_sub_grp));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(res_addr_line1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(res_addr_line2));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(res_addr_line3));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(res_addr_line4));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(res_region_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_region_desc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(mail_addr_line1));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(mail_addr_line2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(mail_addr_line3));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(mail_addr_line4));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mail_town_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mail_town_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(mail_area_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(mail_area_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(mail_postal_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(mail_region_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(mail_region_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(mail_country_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(mail_country_desc));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(other_tel_no));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(oth_contact_no));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
 } 
            _bw.write(_wl_block81Bytes, _wl_block81);
  String label ="";
	
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
	if(Category.equals("L"))
		out.println("Lodger");
	
            _bw.write(_wl_block84Bytes, _wl_block84);
  
		if(mode.equals("insert"))
	{
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(sysdateTime));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(check_in_date_time));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
	else
	{
		out.println( check_in_date_time ) ;
	}
            _bw.write(_wl_block88Bytes, _wl_block88);
 if(Category.equals("A")) { 
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

		String sel ="";                                     
		StringBuffer sqlBuff  = new StringBuffer();
		sqlBuff.append(" select relationship_code, short_desc from mp_relationship where eff_status = 'E' ");
		if(mode.equals ("insert"))
		{
			out.println( "<select name='reln_with_patient' id='reln_with_patient' "+ disabled +" >" ); 
			out.println("<option value=''>------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----------</option>") ;
		}
		else
			sqlBuff.append(" and relationship_code ='"+ lodger_relation_code +"' ");

		sqlBuff.append(" order by short_desc ");

		stmt = con.createStatement();
		rs = stmt.executeQuery (sql) ;
		while ( rs.next() )
		{
			if(mode.equals("insert"))
			{
				if(reason_for_stay.equals(rs.getString(1)))
				sel = "selected" ;
				out.println( "<option value= '"+ rs.getString(1) +"' "+ sel +">" + rs.getString(2) + "</option>" ) ;
				sel = "";
			}
			else
			{
				out.println( rs.getString(2) ) ; 
				out.println("</td><td colspan='2'>&nbsp;</td>");
			}
		}
		out.println("</td><td colspan='4'>&nbsp;</td>");
	}
	else if(Category.equals("L"))
		{
			/*	REASON FOR STAY	  */			
			out.println("<td colspan='4' class='label' align='right' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforStay.label","ip_labels")+"&nbsp;</td><td nowrap class='QUERYDATA'>");
		
			sql = "   select reason_for_stay_code, short_desc from ip_reason_for_lodger_stay where eff_status = 'E'"  ;

			if (mode.equals("update"))
				sql = sql + " and reason_for_stay_code='"+ reason_for_stay +"' " ;
			
			sql = sql + " order by short_desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql) ;

			if(rs!=null)
			{
				if(mode.equals ("insert"))
				{
					out.println( "<select name='reason_for_stay' id='reason_for_stay' >" ); 
					out.println("<option value=''>------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----------</option>") ;
				}
					
				while ( rs.next() )
				{
					if(mode.equals("insert"))
					{
						out.println( "<option value= \""+ rs.getString(1) +"\" >" + rs.getString(2) + "</option>" ) ;
					}
					else
					{
						out.println(rs.getString(2)) ; 
						out.println(" <td colspan='4'>&nbsp;</td> ");
					}
				}
			}

			if(mode.equals("insert"))
				out.println( "</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>");
			out.println("</td>");
	}

	if(mode.equals("update"))
		{
			out.println(" <tr><td colspan='8' align='left' >&nbsp;</td><td></td></tr>");
		}
	
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
if(mode.equals("insert"))
		{
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(sysdateTime));
            _bw.write(_wl_block94Bytes, _wl_block94);
}
		else
		{
			out.println( Period_date_time_from ) ;
		}
		
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
if(mode.equals("insert"))
	{
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(Period_date_time_to));
            _bw.write(_wl_block98Bytes, _wl_block98);
}
	else
	{
		if(mode.equals("update"))
			{
				out.println(Period_date_time_to) ;
				out.println(" <td colspan='4' >&nbsp;</td>");
				out.println(" <tr><td colspan='8' align='left' >&nbsp;</td><td></td></tr> ");
			}
	}

            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
if(mode.equals("insert"))
	{
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block104Bytes, _wl_block104);
}
	else
	{
	out.println (nursing_desc) ;
	}

            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
if(mode.equals("insert"))
		{
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(authorized_by));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block109Bytes, _wl_block109);
}
		else
		{
			out.println( authorized_by ) ;
			out.println(" <td colspan='4' >&nbsp;</td>");
			out.println(" <tr><td colspan='8' align='right' >&nbsp;&nbsp;</td><td></td></tr> ");
		}
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
if(mode.equals("insert"))
		{
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block114Bytes, _wl_block114);
}
		else
		{
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block116Bytes, _wl_block116);
}
            _bw.write(_wl_block117Bytes, _wl_block117);
if(mode.equals("update"))	{
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(label));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(check_in_date_time));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(sysdateTime));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block121Bytes, _wl_block121);
}
            _bw.write(_wl_block122Bytes, _wl_block122);
if(mode.equals("update")){
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
}
	else
	{
		out.println("<tr rowspan='20'>");
		out.println(" <td class='blankRowDisp' colspan='10' align='left' height='100' >&nbsp;</td> ");
		out.println("</tr>");
	}
	
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(Category));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(lodger_ref_no));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(label));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(Lodger_Max_RefNo));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(Lodger_Next_RefNo));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(Category));
            _bw.write(_wl_block137Bytes, _wl_block137);

}catch(Exception e) {out.println(e.toString());}
 finally
  {
	if (rs != null)			rs.close();
	if (stmt != null)		stmt.close();
	if (rs_opn != null)		rs_opn.close();
	if (stmt_opn != null)	stmt_opn.close();
	if (PatIDRS != null)	PatIDRS.close();
	if (PatIDStmt != null)	PatIDStmt.close();

	ConnectionManager.returnConnection(con,request);
  }
     
            _bw.write(_wl_block138Bytes, _wl_block138);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.staydetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relationshipwithpatient.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodfrom.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodto.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
