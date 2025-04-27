package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __amendgatepassdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AmendGatePassDetail.jsp", 1732521940158L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html> \n    <head>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<style>\n\t    input:disabled , select:disabled {\n\t      background-color: #d3d3d3;\n\t      color: #a9a9a9;\n\t      border: 1px solid #a9a9a9;\n\t      cursor: not-allowed;\n\t      opacity: 0.6;\n\t      pointer-events: none;\n\t    }\n  \t</style>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<script src=\'../js/CheckinLodger.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n<script>\nfunction localValidations(obj)\n{}\n\nfunction SubmitPage()\n{\n\tvar revise_period_from_val = document.forms[0].revise_period_from.value;\n\tvar revise_period_to_val = document.forms[0].revise_period_to.value;\n\n\tif(parseInt(revise_period_from_val.length) <= 0 )\n\t{\n\n\t\tvar error = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\terror = error.replace(\'$\',getLabel(\"eIP.reviseperiodfrom.label\",\"IP\"));\n\t\talert(error);\t\t\t\t\t\t\n\t\tdocument.forms[0].revise_period_from.focus();\n\t}\n\telse \n\tif(parseInt(revise_period_to_val.length) <= 0 )\n\t{\n\t\tvar error = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\terror = error.replace(\'$\',getLabel(\"eIP.reviseperiodto.label\",\"IP\"));\n\t\talert(error);\t\t\t\t\t\t\n\t\tdocument.forms[0].revise_period_to.focus();\n\t}\n\telse \n\tif(document.forms[0].Authorised_lookup.readOnly == true && parseInt(document.forms[0].Authorised_text.length) <= 0)\n\t{\n\t\tvar error = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\terror = error.replace(\'$\',getLabel(\"Common.authorizedby.label\",\"Common\"));\n\t\talert(error);\t\t\t\t\t\t\n\t\tdocument.forms[0].Authorised_text.focus();\n\t}\n\telse\n\tif(document.forms[0].Authorised_text.readOnly == true && parseInt(document.forms[0].Authorised_lookup.value.length) <= 0 )\n\t{\n\t\tvar error = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\terror = error.replace(\'$\',getLabel(\"Common.authorizedby.label\",\"Common\"));\n\t\talert(error);\t\t\t\t\t\t\n\t\tdocument.forms[0].Authorised_lookup.focus();\n\t}\n\telse\n\tif(document.forms[0].Authorised_lookup.readOnly == false &&  document.forms[0].Authorised_text.readOnly == false)\n\t{\n\t\tvar error = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\terror = error.replace(\'$\',getLabel(\"Common.authorizedby.label\",\"Common\"));\n\t\talert(error);\t\t\t\t\t\t\n\t\tdocument.forms[0].Authorised_lookup.focus();\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].submit();\n\t}\n}\n\n\n// Added by Sridhar on 7 AUG 2004\n// Function will check for empty values before calling up the common lookup func..\n\t\t\nfunction beforeGetAuthorised(target_id,target)\n{\n\tif(document.forms[0].Authorised_hid.value != document.forms[0].Authorised_lookup.value)\n\t{\n\t\tif(document.forms[0].Authorised_lookup.value != \"\")\n\t\t\t getAuthoriser(target_id,target);\n\t}\n}\n\nasync function getAuthoriser(target_id,target)\n{\n\tvar facility_id = document.forms[0].facility_id.value;\n\tvar argumentArray=new Array(8);\n\tvar title = getLabel(\"Common.authorizedby.label\",\"Common\");\n \n\targumentArray[0]=\"select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER_LANG_VW  where language_id=\'\"+localeName+\"\' and EFF_STATUS like ? and APPL_USER_ID like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) \";\n\n\targumentArray[1]=new Array(\"EFF_STATUS\");\n\targumentArray[2]=new Array(\"E\");\n\targumentArray[3]=new Array(STRING,STRING);\n\targumentArray[4]=\"2,3\";\n\targumentArray[5]=target.value;\n\targumentArray[6]=CODE_DESC_LINK;\n\targumentArray[7]=CODE_DESC;\n\n\t\t\t\n\tvar retVal=await CommonLookup(title,argumentArray);\n\t\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].Authorised_hid.value\t\t=\tarr[0];\t\t\n\t\tdocument.forms[0].Authorised_lookup.value\t=\tarr[1];\n\t\tdocument.forms[0].Authorised_lookup.focus();\n\t\tdocument.forms[0].Authorised_hid.value\t\t= document.forms[0].Authorised_lookup.value;\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].Authorised_hid.value\t\t= \"\";\t\tdocument.forms[0].Authorised_lookup.value\t= \"\";\n\t}\n}\n\n\nfunction enableDisable(lookup,text)\n{\n\tif(lookup.value == \'\')\n\t{\n\t\tdocument.forms[0].Authorised_text.readOnly\t= false;\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].Authorised_text.value\t\t= \'\';\n\t\tdocument.forms[0].Authorised_text.readOnly\t= true;\n\t}\n\t\n\tif(text.value == \'\')\n\t{\n\t\tdocument.forms[0].Authorised_lookup.readOnly\t= false;\n\t\tdocument.forms[0].search_Authorised.disabled\t= false;\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].Authorised_lookup.value\t\t= \'\';\n\t\tdocument.forms[0].Authorised_lookup.readOnly\t= true;\n\t\tdocument.forms[0].search_Authorised.disabled\t= true;\n\t}\n}\n\n\n/// CODED ON 26 APR 2004 BY SRIDHAR \n//// Function : This func is called for validating the Maximum Renewal Period . It will add the no of Days/Hours to the [Renew period from] & return the value.\n\nfunction testMaxPeriod(obj)\n{\n\t//var objchk = obj.value;\n\tvar retval=true\n\t//if(objchk != 0)\n\tif(obj.value != \'\')\n\t{\n\t\t/*if(!doDateTimeChk(obj))\n\t\t{\n\t\t\tretval= false;\t\t\t\n\t\t\tobj.focus();\n\t\t}*/\n\t\tif(!validDateObj(obj,\"DMYHM\",localeName))\n\t\t\tretval= false;\t\n\n\t\tif(retval)\t\n\t\t{\t\n\t\t\t\n\t\t\t//var OTdate = objchk; \n\t\t\tvar OTdate = convertDate(obj.value,\"DMYHM\",localeName,\"en\");\n\t\t\tvar renewdate = document.forms[0].revise_period_from.value; \t\n\t\t\tif(renewdate.length > 1)\t\n\t\t\t{\n\t\t\t\tvar greg_renewdate = convertDate(document.forms[0].revise_period_from.value,\"DMYHM\",localeName,\"en\");\n\t\t\t\tvar gate_pass_period = document.forms[0].gate_pass_period.value;\n\t\t\t\tretval = ValidateRenewDateTime(greg_renewdate,OTdate,gate_pass_period);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t}\n\t\t}\n\t return retval;\n    }\n}\n\nfunction ValidateRenewDateTime(from,to,gate_pass_period)\n{\t\n  if(gate_pass_period != \"\")\n  {\n\tvar prefDateTime = from;\n\tvar a =  from.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\t\n\tvar retval=true\n\tvar splitdate1 =a[0].split(\"/\")\n\tvar splittime1= a[1].split(\":\")\n\tvar from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\ta = to.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tsplitdate1 =a[0].split(\"/\")\n\tsplittime1= a[1].split(\":\")\n\n\tvar to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\tif(document.forms[0].hddRenewUnit.value == \"D\")\n\t{\n\t\tvar expDaysofStay = gate_pass_period;\n\t\tvar xmlDoc = \"\"\n\t\tvar xmlHttp = new XMLHttpRequest()\n\t\txmlStr =\"<root><SEARCH criteria=\'Days\' prefDateTime=\\\"\"+prefDateTime+\"\\\" expDaysofStay=\\\"\"+expDaysofStay+\"\\\" /></root>\"\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\txmlHttp.open(\"POST\",\"ValidateRenewPeriod.jsp\",false)\n\t\txmlHttp.send(xmlDoc)\n\t\tresponseText=xmlHttp.responseText\n\t\tresponseText = trimString(responseText)\n\t}\n\telse\n\t{\n\t\tvar expHoursofStay = gate_pass_period;\n\t\texpHoursofStay = expHoursofStay / 24;\n\t\tvar xmlDoc = \"\"\n\t\tvar xmlHttp = new XMLHttpRequest()\n\t\txmlStr =\"<root><SEARCH criteria=\'Hours\' prefDateTime=\\\"\"+prefDateTime+\"\\\" expHoursofStay=\\\"\"+expHoursofStay+\"\\\" /></root>\"\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\txmlHttp.open(\"POST\",\"ValidateRenewPeriod.jsp\",false)\n\t\txmlHttp.send(xmlDoc)\n\t\tresponseText=xmlHttp.responseText\n\t\tresponseText = trimString(responseText)\n\t}\n\n\ta = responseText.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tsplitdate1 =a[0].split(\"/\")\n\tsplittime1= a[1].split(\":\")\n\n\tvar exp_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\tif((Date.parse(from_date) > Date.parse(to_date)) || (Date.parse(to_date) > Date.parse(exp_date)))\n\t{\n\t\talert(getMessage(\"RENEW_DT_LT_MAX_PR\",\"IP\") );\n\t\tdocument.forms[0].revise_period_to.focus();\n\t\tdocument.forms[0].revise_period_to.select();\n\t\tretval = false;\n\t\treturn retval\n\t}\n   return retval\n  }\n}\n\n\n\n//// CODED ON 11 MAR 2004 BY SRIDHAR \n//// FUNC USED TO COMPARE [REVISE PERIOD FROM] DATE WITH [REVISE PERIOD TO] \n//// Func will return an alert message if REVISE TO DATE is Less than REVISE FROM DATE\nfunction CompareReviseTime(from,to)\n{\n\tvar continue_YN = \"\";\n\tif(to.value != \'\' )\n\t\t{\n\t\t\t\n\t\t\tif(validDateObj(to,\"DMYHM\",localeName))\n\t\t\t{\n\t\t\t\tcontinue_YN = \"Y\";\n\t\t\t}\n\t\t\telse\n\t\t\t\treturn false;\n\t\t\n\t\t\t/*if(!doDateTimeChk(to))\n\t\t\t\t{\n\t\t\t\t\talert( getMessage(\"INVALID_DATE_TIME\",\"SM\") );\n\t\t\t\t\tto.focus();\n\t\t\t\t\tto.select();\n\t\t\t\t\treturn ;\n\t\t\t\t}\n\t\t\telse\n\t\t\t\tcontinue_YN = \"Y\";*/\n\t\t}\n\t\tif(from.value != \'\')\n\t\t\t{\n\t\t\t\t\n\t\t\t\tif(!validDateObj(from,\"DMYHM\",localeName))\n\t\t\t\t\treturn false;\n\n\t\t\n\t\t\t\t/*if(!doDateTimeChk(from))\n\t\t\t\t\t{\n\t\t\t\t\t\talert( getMessage(\"INVALID_DATE_TIME\",\"SM\") );\n\t\t\t\t\t\tfrom.focus();\n\t\t\t\t\t\tfrom.select();\n\t\t\t\t\t\treturn ;\n\t\t\t\t\t}*/\n\t\t\t\t\n\t\t\t\t//var frdt = from.value;\n\t\t\t\t//var tdt = to.value;\n\t\t\t\tvar greg_fromdate = convertDate(from.value,\"DMYHM\",localeName,\"en\");\n\t\t\t\tvar greg_todate = convertDate(to.value,\"DMYHM\",localeName,\"en\");\n\t\t\t\tif(continue_YN == \"Y\")\n\t\t\t\t\t//RevisePeriodcheckDateTime(frdt,tdt);\n\t\t\t\t{\n\t\t\t\t\tif(isAfter(greg_fromdate,greg_todate,\"DMYHM\",\"en\"))\n\t\t\t\t\t{\n\t\t\t\t\t\talert( getMessage(\"RENEW_TODT_GT_FRDT\",\"IP\") );\n\t\t\t\t\t\tdocument.forms[0].revise_period_to.value = \'\' ;\n\t\t\t\t\t\tdocument.forms[0].revise_period_to.focus();\n\t\t\t\t\t\tdocument.forms[0].revise_period_to.select();\n\t\t\t\t\t\treturn false\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\ttestMaxPeriod(document.forms[0].revise_period_to);\n\t\t\t\t\t}\t\n\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\telse\n\t\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t\treturn false;\n\t\t\n}\n\nfunction RevisePeriodcheckDateTime(obj1,obj2)\n{\t\n \tvar a=obj1.split(\" \");\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tvar splitdate1 = a[0].split(\"/\")\n\tvar splittime1 = a[1].split(\":\")\n\n\t var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));\n\n\t a=obj2.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\n\t splitdate1 = a[0].split(\"/\")\n\t splittime1 = a[1].split(\":\")\n\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));\n\n\tif(Date.parse(to_date) < Date.parse(from_date))\n\t{\n\t\talert( getMessage(\"RENEW_TODT_GT_FRDT\",\"IP\") );\n\t\tdocument.forms[0].revise_period_to.focus();\n\t\tdocument.forms[0].revise_period_to.select();\n\t\treturn false\n\t}\n\telse\n\t{\n\t\ttestMaxPeriod(document.forms[0].revise_period_to);\n\t}\t\n}\t\n\n\n//// CODED ON 11 MAR 2004 BY SRIDHAR \n//// FUNC USED TO COMPARE [REVISE PERIOD FROM] DATE WITH [PERIOD TO] \n//// Func will return an alert message if [REVISE FROM DATE] is Less than [TO DATE]\n\nfunction compareDate(periodFromobj,p";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="eriodToObj)\n{\n\t\n\tif(periodFromobj.value !=\'\' && periodToObj.value !=\'\')\n\t{\n\t\t//if(periodFromobj.value != \'\' )\n\t\t//{\n\t\t\t/*if(!doDateTimeChk(periodFromobj))\n\t\t\t{\n\t\t\t\tperiodFromobj.focus();\n\t\t\t\tperiodFromobj.select();\n\t\t\t\treturn;\n\t\t\t}*/\n\t\t\tif(validDateObj(periodFromobj,\"DMYHM\",localeName))\n\t\t\t{\n\t\t\t\tvar greg_period_from_date = convertDate(periodFromobj.value,\"DMYHM\",localeName,\"en\");\n\n\t\t\t\t\n\t\t\t\tif(isBefore(greg_period_from_date,periodToObj.value,\"DMYHM\",\"en\"))\n\t\t\t\t{\n\t\t\t\t\talert( getMessage(\"RENEW_LT_PR_DT\",\"IP\") );\n\t\t\t\t\tperiodFromobj.focus();\n\t\t\t\t\tperiodFromobj.select();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\treturn\tCompareReviseTime(periodFromobj,document.forms[0].revise_period_to);\n\t\t\t\t/*if(!ValidateDateTime(periodToObj,periodFromobj))\n\t\t\t\t{\n\t\t\t\t\talert( getMessage(\"RENEW_LT_PR_DT\",\"IP\") );\n\t\t\t\t\tperiodFromobj.focus();\n\t\t\t\t\tperiodFromobj.select();\n\t\t\t\t\treturn;\n\t\t\t\t}*/\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\t\n\t\t\t/*else\n\t\t\t{\t\n\t\t\t}*/\n\t\t//}\n\t\t//else return;\n\t}\n\telse\n\t\treturn CompareReviseTime(periodFromobj,document.forms[0].revise_period_to);\n\t\n}\n\n\nfunction checkMax(obj)\n{\n\tif(obj.value.length > 200)\n\t{\n\t\talert(getMessage(\'REMARKS_NOT_EXCEED_200_CH\',\'SM\'));\n\t\tobj.focus();\n\t\tobj.select();\n\t}\n\telse \n\tmakeValidString(obj);\n}\n\n\nfunction CheckMaxLength(obj,max) \n{\n\tif(obj.value.length >= max) \n\t\treturn false;\n\telse \n\t\treturn true;\n}\n\n</script>\n\t\t";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'BlockLodgerForm\' id=\'BlockLodgerForm\' method=\'post\' action=\'../../servlet/eIP.BookLodgerServlet\' target=\'messageFrame\'>\n\t<input type=\"hidden\" name=\"hddCitizen\" id=\"hddCitizen\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" >\n\t<input type=\"hidden\" name=\"hddLegal\" id=\"hddLegal\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \">\n\t<input type=\"hidden\" name=\"hddRenewUnit\" id=\"hddRenewUnit\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >\n\t\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" align=\'center\'>\n\t<tr>\n\t   ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</tr>\n<!--  ADDED TO DISPLAY [ ACCOMPANYING DETAILS ] FRAME FROM eMP -->\n<!--  ADDED BY SRIDHAR ON 17 FEB 2004 -->\n\t<tr> \n\t\t<td colspan=\'4\'> \n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \t\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \t\t\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \t\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="   \n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<input type=\'hidden\' name=\'ageschk\' id=\'ageschk\' value= \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t</td>  \n\t</tr>   \n</table>\n\n<!-- ADDED FOR LOCALLY ASIGNING THE VALUES TO THE MP FORM IN THE UPDATE MODE  -->\n<!-- ADDED BY SRIDHAR ON 9th FEB 2004   -->\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n  <script>\n\t\tdocument.BlockLodgerForm.patient_id.value \t= \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\tdocument.BlockLodgerForm.patient_id.disabled = true;\n\t\tdocument.BlockLodgerForm.search.disabled = true;\n\n\t\tdocument.getElementById(\"patient_name1\").innerHTML = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\tdocument.getElementById(\"patient_name1\").disabled = true; \n\n\t\t/*if(document.BlockLodgerForm.name_prefix1)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.name_prefix1.value\t\t= \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\tdocument.BlockLodgerForm.name_prefix1.disabled\t= true;\n\t\t}*/\n\t\t\n\t\tif(document.BlockLodgerForm.name_prefix)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.name_prefix.value\t\t= \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\tdocument.BlockLodgerForm.name_prefix.disabled\t= true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.family_name)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.family_name.value \t= \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\tdocument.BlockLodgerForm.family_name.disabled = true;\n\t\t\tif(document.BlockLodgerForm.bfam)\n\t\t\tdocument.BlockLodgerForm.bfam.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.first_name)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.first_name.value \t= \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\tdocument.BlockLodgerForm.first_name.disabled = true;\n\t\t\tif(document.BlockLodgerForm.bf)\n\t\t\tdocument.BlockLodgerForm.bf.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.second_name)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.second_name.value \t= \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\tdocument.BlockLodgerForm.second_name.disabled = true;\n\t\t\tif(document.BlockLodgerForm.bs)\n\t\t\tdocument.BlockLodgerForm.bs.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.third_name)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.third_name.value \t= \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\tdocument.BlockLodgerForm.third_name.disabled = true;\n\t\t\tif(document.BlockLodgerForm.bt)\n\t\t\tdocument.BlockLodgerForm.bt.disabled = true;\n\t\t}\n\n\t\t/*if(document.BlockLodgerForm.name_suffix1)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.name_suffix1.value \t= \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\tdocument.BlockLodgerForm.name_suffix1.disabled = true;\n\t\t}*/\n\n\t\tif(document.BlockLodgerForm.name_suffix)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.name_suffix.value \t= \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\tdocument.BlockLodgerForm.name_suffix.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.name_prefix_oth_lang)\n\t    {\n\t\t\tdocument.BlockLodgerForm.name_prefix_oth_lang.value \t= \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\tdocument.BlockLodgerForm.name_prefix_oth_lang.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.first_name_oth_lang)\n\t    {\n\t\t\tdocument.BlockLodgerForm.first_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\tdocument.BlockLodgerForm.first_name_oth_lang.disabled = true;\n\t\t\tif(document.BlockLodgerForm.bfo)\n\t\t\tdocument.BlockLodgerForm.bfo.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.second_name_oth_lang)\n\t    {\n\t\t\tdocument.BlockLodgerForm.second_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\tdocument.BlockLodgerForm.second_name_oth_lang.disabled = true;\n\t\t\tif(document.BlockLodgerForm.bso)\n\t\t\tdocument.BlockLodgerForm.bso.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.third_name_oth_lang)\n\t    {\n\t\t\tdocument.BlockLodgerForm.third_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\tdocument.BlockLodgerForm.third_name_oth_lang.disabled = true;\n\t\t\tif(document.BlockLodgerForm.bto)\n\t\t\tdocument.BlockLodgerForm.bto.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.family_name_oth_lang)\n\t    {\n\t\t\tdocument.BlockLodgerForm.family_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\tdocument.BlockLodgerForm.family_name_oth_lang.disabled = true;\n\t\t\tif(document.BlockLodgerForm.bfamo)\n\t\t\tdocument.BlockLodgerForm.bfamo.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.name_suffix_oth_lang)\n\t    {\n\t\t\tdocument.BlockLodgerForm.name_suffix_oth_lang.value \t= \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\tdocument.BlockLodgerForm.name_suffix_oth_lang.disabled = true;\n\t\t}\n\n\t\tdocument.getElementById(\"patient_name_local_lang1\").innerText \t= \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\tdocument.BlockLodgerForm.patient_name_local_lang.value \t= \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\n\t\tdocument.BlockLodgerForm.sex.value \t= \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\tdocument.BlockLodgerForm.sex.disabled = true;\n\n\t\tvar ages = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\n\t\t//// Alternative for date of bith ...using sql function...\n\t\tdocument.BlockLodgerForm.b_age.value\t= \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\tdocument.BlockLodgerForm.b_months.value\t= \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\tdocument.BlockLodgerForm.b_days.value\t= \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\n\t\tif(document.BlockLodgerForm.b_birth)\n\t\t\tdocument.BlockLodgerForm.b_birth.disabled = true;\n\n\t\tif(document.getElementById(\"dob\"))\n\t\t\tdocument.getElementById(\"dob\").disabled = true;\n\n\t\tif(document.BlockLodgerForm.b_age)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.b_age.disabled = true;\n\t\t\tdocument.BlockLodgerForm.b_months.disabled = true;\n\t\t\tdocument.BlockLodgerForm.b_days.disabled = true;\n\t\t}\n\t\tdocument.BlockLodgerForm.national_id_no.value \t= \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\tdocument.BlockLodgerForm.national_id_no.disabled =true;\n\n\t\tif(document.BlockLodgerForm.myKadBtn)\n\t\t{\t\t\t\n\t\t\tdocument.BlockLodgerForm.myKadBtn.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.alt_id1_no)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id1_no.value \t= \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id1_no.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id2_no)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id2_no.value \t= \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id2_no.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id3_no)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id3_no.value \t= \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id3_no.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id4_no)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id4_no.value \t= \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id4_no.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id1_exp_date)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id1_exp_date.value \t= \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id1_exp_date.disabled = true;\n\t\t}\n\t\t\n\t\tif(document.BlockLodgerForm.alt_id2_exp_date)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id2_exp_date.value \t= \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id2_exp_date.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id3_exp_date)\n\t\t{\t\n\t\t\tdocument.BlockLodgerForm.alt_id3_exp_date.value = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id3_exp_date.disabled = true;\n\t\t}\n\t\tif(document.BlockLodgerForm.alt_id4_exp_date)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.alt_id4_exp_date.value = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\t\tdocument.BlockLodgerForm.alt_id4_exp_date.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.other_alt_type)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.other_alt_type.value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\tdocument.BlockLodgerForm.other_alt_type.disabled = true;\n\t\t}\n\n\t\tif(document.BlockLodgerForm.other_alt_Id)\n\t\t{\n\t\t\tdocument.BlockLodgerForm.other_alt_Id.value = \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\tdocument.BlockLodgerForm.other_alt_Id.disabled = true;\n\t\t}\n\n\t\t// ================== Patient contact details popup ================ \n\t\t// to diable the Contact Detail Button\n\t\t//\tdocument.BlockLodgerForm.contact_details.disabled = true;\n\n\t\tdocument.BlockLodgerForm.addr_line1.value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\tdocument.BlockLodgerForm.addr_line1.disabled = true;\n\n\t\tdocument.BlockLodgerForm.addr_line2.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\tdocument.BlockLodgerForm.addr_line2.disabled = true;\n\n\t\tdocument.BlockLodgerForm.addr_line3.value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\tdocument.BlockLodgerForm.addr_line3.disabled = true;\n\n\t\tdocument.BlockLodgerForm.addr_line4.value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\tdocument.BlockLodgerForm.addr_line4.disabled = true;\n\n\t\tdocument.BlockLodgerForm.res_town_code.value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\tdocument.BlockLodgerForm.res_town_desc.value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\n\t\tdocument.BlockLodgerForm.res_area_code.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\tdocument.BlockLodgerForm.res_area_desc.value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\n\t\tdocument.BlockLodgerForm.region_code.value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\t\tdocument.BlockLodgerForm.region_desc.value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\t\t\n\n\t\tdocument.BlockLodgerForm.postal_code.value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\n\n\t\tdocument.BlockLodgerForm.country_desc.value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\n\t\tdocument.BlockLodgerForm.contact1_name.value=\"\";\n\n\t\tdocument.BlockLodgerForm.addr2_type.value=\"\";\n\n\t\tdocument.BlockLodgerForm.mail_addr_line1.value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\tdocument.BlockLodgerForm.mail_addr_line1.disabled = true;\n\n\t\tdocument.BlockLodgerForm.mail_addr_line2.value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\t\tdocument.BlockLodgerForm.mail_addr_line2.disabled = true;\n\n\t\tdocument.BlockLodgerForm.mail_addr_line3.value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\tdocument.BlockLodgerForm.mail_addr_line3.disabled = true;\n\n\t\tdocument.BlockLodgerForm.mail_addr_line4.value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\t\tdocument.BlockLodgerForm.mail_addr_line4.disabled = true;\n\n\t\tdocument.BlockLodgerForm.mail_res_town_code.value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\tdocument.BlockLodgerForm.mail_res_town_desc.value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\t\t\n\t\tdocument.BlockLodgerForm.mail_res_area_code.value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\tdocument.BlockLodgerForm.mail_res_area_desc.value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\n\t\tdocument.BlockLodgerForm.mail_postal_code.value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\n\t\tdocument.BlockLodgerForm.mail_region_code.value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\t\tdocument.BlockLodgerForm.mail_region_desc.value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\t\tdocument.BlockLodgerForm.mail_region_desc.readOnly = true; \n\n\t\tdocument.BlockLodgerForm.mail_country_code.value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n\t\tdocument.BlockLodgerForm.mail_country_desc.value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\t\tdocument.BlockLodgerForm.contact2_name.value=\'\';\n\t\tdocument.BlockLodgerForm.contact1_no.value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\t\tdocument.BlockLodgerForm.contact2_no.value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\tdocument.BlockLodgerForm.email.value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\n\t\t/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/\n\t\tdocument.BlockLodgerForm.alt_addr_line1.value\t= \"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\n\t\tdocument.BlockLodgerForm.alt_addr_line1.disabled = true;\n\t\tdocument.BlockLodgerForm.alt_addr_line2.value\t= \"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\";\n\t\tdocument.BlockLodgerForm.alt_addr_line2.disabled = true;\n\t\tdocument.BlockLodgerForm.alt_addr_line3.value\t= \"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\t\tdocument.BlockLodgerForm.alt_addr_line3.disabled = true;\n\t\tdocument.BlockLodgerForm.alt_addr_line4.value\t= \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t\tdocument.BlockLodgerForm.alt_addr_line4.disabled = true;\n\t\tdocument.BlockLodgerForm.alt_area_code.value\t\t= \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\";\n\t\tdocument.BlockLodgerForm.alt_area_desc.value\t\t= \"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\tdocument.BlockLodgerForm.alt_town_code.value\t\t= \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\n\t\tdocument.BlockLodgerForm.alt_town_desc.value\t\t= \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\tdocument.BlockLodgerForm.alt_postal_code.value\t= \"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\n\t\tdocument.BlockLodgerForm.alt_postal_desc.value\t= \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\";\n\t\tdocument.BlockLodgerForm.alt_region_code.value\t= \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\";\n\t\tdocument.BlockLodgerForm.alt_region_desc.value\t= \"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\t\tdocument.BlockLodgerForm.alt_country_code.value\t= \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\tdocument.BlockLodgerForm.alt_country_desc.value\t= \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t/*End*/\n\n</script>\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"4\" width=\"100%\" align=\'center\'>\n\t<tr><td colspan=\'4\' align=\'left\' class= \"COLUMNHEADER\">";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td></tr>\n\t<input type=\'hidden\' name=\'PeriodToVal\' id=\'PeriodToVal\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\t\n\t<tr>\n\t\t<td class=\"label\" width=\"20%\">";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t\t<td class=\'QUERYDATA\' width=\"30%\">";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>  \n\t\t<td width=\"25%\" class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\n\t</tr>\n\t<tr>\n\t\t<!-- PERIOD FROM --> \n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n\t\t<td nowrap class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>  \n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t<td class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="<input type=\"hidden\" name=\"gate_pass_period\" id=\"gate_pass_period\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" ></td>\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\t</tr>\n\n\t<tr><td align=\'left\' colspan=\'4\' class= \"COLUMNHEADER\">";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td></tr>\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</td>\n\t\t<td class=\'fields\'>\n\t\t\t<!--<input type=\"text\" id=\'reviseperiodfrom\' name=\"revise_period_from\" id=\"revise_period_from\" maxlength=16 size=16 value =\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" onblur=\"compareDate(this,PeriodToVal);CompareReviseTime(this,revise_period_to);\" > -->\n\t\t\t\n\t\t\t<input type=\"text\" id=\'reviseperiodfrom\' name=\"revise_period_from\" id=\"revise_period_from\" maxlength=16 size=16 value =\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" onblur=\"compareDate(this,PeriodToVal);\" ><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].revise_period_from.focus();return showCalendar(\'reviseperiodfrom\',null,\'hh:mm\');\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t</td>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t\t<td class=\'fields\'>\n\t\t<!--<input type=\"text\" id=\'reviseperiodto\' name=\"revise_period_to\" id=\"revise_period_to\" maxlength=16 size=16 onblur=\"CompareReviseTime(revise_period_from,this);\" value =\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" >-->\n\t\t\n\t\t<input type=\"text\" id=\'reviseperiodto\' name=\"revise_period_to\" id=\"revise_period_to\" maxlength=16 size=16 onblur=\"CompareReviseTime(revise_period_from,this);\" value =\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" ><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].revise_period_to.focus();return showCalendar(\'reviseperiodto\',null,\'hh:mm\');\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t<td class=\'fields\'><input type=\"text\" name=\"Authorised_lookup\" id=\"Authorised_lookup\" maxlength=16 size=16 value=\"\" onBlur=\'beforeGetAuthorised(document.forms[0].Authorised_hid,this);enableDisable(this,Authorised_text);\'><input type=button class=button name=\'search_Authorised\' id=\'search_Authorised\' value=\'?\' onclick=\"getAuthoriser(document.forms[0].Authorised_hid,document.forms[0].Authorised_lookup)\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img><input type=\"text\" name=\"Authorised_text\" id=\"Authorised_text\" maxlength=16 size=16 value=\"\" onBlur=\'makeValidString(this);enableDisable(Authorised_lookup,this);\'><input type=hidden name=\"Authorised_hid\" id=\"Authorised_hid\" value=\'\'></td>\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t<td class=\'label\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t<td class=\'fields\' colspan=\'2\'><textarea style=\"resize:none\" name=\"ReviseRemarks\" rows=\"4\" cols=\"50\" maxLength=\'200\' onKeypress=\"return CheckMaxLength(this,200);\" onBlur=\"checkMax(this);\"></textarea></td>        \n\t\t<td valign=\"bottom\" class=\'fields\'><input type=\'button\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' name=\'Revise\' class=\'button\' onClick=\"SubmitPage()\"><input type=\'button\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' name=\'cancel\' class=\'button\' onclick=\'parent.parent.document.getElementById(\"dialog_tag\").close();\'>\n\t\t</td>\n\n\t</tr>     \n\t\t\n\t\t<input type=\"hidden\" name=\"ReviseGatePass\" id=\"ReviseGatePass\" value=\"PASS\">\t\t\n\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n  </table>\n        <input type=\"hidden\" name=\'locale\' id=\'locale\' value = \"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"> \n\t\t<input type=\"hidden\" name=\'Category\' id=\'Category\' value = \"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"> \n\t\t<input type=\"hidden\" name=\'lodger_ref_no\' id=\'lodger_ref_no\' value = \"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"> \n\t\t<input type=\"hidden\" name=\'encounter_id\' id=\'encounter_id\' value = \"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"> \n\t\t<input type=\"hidden\" name=\"to_chk_in_dt_time\" id=\"to_chk_in_dt_time\" maxlength=16 size=16 onblur=\"dateVal(this)\" value =\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"> \n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value= \"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t<input type=\'hidden\' name=\'label\' id=\'label\' value= \"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value= \"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\n</form>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

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
/// Function Name	:	Lodger -> RenewGatePass
/// Developer		:	SRIDHAR R
/// Created On		:	FEB 2004
/// Funtion			:	This File is called from ReleaseBookLodgerDetail.jsp.

// This File will be called when the user want to Renew the Gate Pass..
//	The Details are inserted to IP_LODGER_GATE_PASS & Updated in IP_LODGER_DETAIL table.

            _bw.write(_wl_block1Bytes, _wl_block1);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

			request.setCharacterEncoding("UTF-8");
			//MMS-ME-SCF-0096 vulnerability Issue
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//MMS-ME-SCF-0096 vulnerability Issue
			String locale			= (String)session.getAttribute("LOCALE");

			String renewalValid_to ="";
			String  renewalValid_fr ="";
			 

            Connection con = null;

			Statement stmt		= null;
            ResultSet rs		= null ;
			Statement ParamStmt = null; 
			ResultSet ParamRS	= null;
			
			String facility_id	= (String)session.getValue ("facility_id") ;
		
			String mode = request.getParameter("mode") ;
            if( mode == null )  mode = "insert" ;

			String encounter_id = request.getParameter("EncounterId");
            if(encounter_id ==null) encounter_id="";
                
            String Category = request.getParameter("Category");
            if(Category == null) Category = "L" ;

            String pat_id = request.getParameter("lodger_patient_id");
            if(pat_id ==null) pat_id="";

			// DECLARATION OF VARIABLES
			String years	= "";
			String months   = "";
			String days     = "";

			String lodger_patient_name	= "" ;
			String reason_for_stay		= "";
			String alt_long_desc		= "";
			String check_in_date_time	= "";
			String check_in_dis_dat_tim = "";
			String Period_date_time_from= "";
			String Period_date_time_to	= "";
			String Period_dat_dis_tim_fr= "";
			String Period_dat_dis_tim_to= "";
			String authorized_by		= "";  
			String nursing_desc			= "";
			String patientID			= "";
			String lodger_ref_no		= "";			
			String remarks				= "";                			
			String lodger_relation_code = "";

			String nameprefix			= "";
			String firstname			= "";
			String secondname			= "";
			String thirdname			= "";
			String familyname			= "";
			String namesuffix			= "";
			String gender				= "";
			String date_of_birth		= "";
			String place_of_birth_code	= "";
			String place_of_birth_desc	= "";
			String citizen				= "";
			String legal				= "";
			String email_id				= "";
			String national_id_no		= "";
			String alt_id1_no			= "";
			String alt_id2_no			= "";
			String alt_id3_no			= "";
			String alt_id4_no			= "";
			String oth_alt_id_no		= ""; 
			String oth_alt_id_type		= "";
			String res_addr_line1		= "";
			String res_addr_line2		= "";
			String res_addr_line3		= "";
			String res_addr_line4		= "";
			String res_town_code		= "";
			String res_town_desc		= "";
			String res_area_code		= "";
			String res_area_desc		= "";
			String res_region_code		= "";
			String res_region_desc		= "";
			String postal_code			= "";
			String country_code			= "";
			String mail_addr_line1		= "";
			String mail_addr_line2		= "";
			String mail_addr_line3		= "";
			String mail_addr_line4		= "";
			String mail_country_code	= "";
			String mail_country_desc	= "";
			String mail_town_code		= "";
			String mail_town_desc		= "";
			String mail_area_code		= "";
			String mail_area_desc		= "";
			String mail_region_code		= "";	
			String mail_region_desc		= "";
			String mail_postal_code		= "";
			String other_tel_no			= "";
			String oth_contact_no		= "";
			String eth_grp				= "";
			String eth_sub_grp			= "";
			String nationality_code		= "";
			String alt_id1_exp_date		= "";
			String alt_id2_exp_date		= "";
			String alt_id3_exp_date		= "";
			String alt_id4_exp_date		= "";
			String Acc_person_age		= "";
			String name_prefix_loc_lang	= "";
			String first_name_loc_lang	= "";
			String second_name_loc_lang	= "";
			String third_name_loc_lang	= "";
			String family_name_loc_lang	= "";
			String name_suffix_loc_lang	= "";
			String patient_name_loc_lang= "";

			/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
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

            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
            java.util.Date dt=new java.util.Date();
            String currDate = dateFormat.format( dt ) ;
            
            String min = String.valueOf(dt.getMinutes()) ;
            if(min.length() == 1)   min = "0"+min ;
            currDate=currDate + " "+String.valueOf(dt.getHours())+":"+min;
            check_in_date_time = currDate ;   
try
{
	con = ConnectionManager.getConnection(request);

	String gate_pass_period = "";
	String gate_pass_unit = "";
	String label	= "";

	if( mode.equals("update") )
	{

	String paramSql="select DFLT_GATE_PASS_PERIOD, DFLT_GATE_PASS_UNIT from ip_param where facility_ID='"+facility_id+"'";

		ParamStmt = con.createStatement();
		ParamRS = ParamStmt.executeQuery( paramSql );

		if(ParamRS!=null)
		{
			if ( ParamRS.next() )
			{
				gate_pass_period = ParamRS.getString("DFLT_GATE_PASS_PERIOD");
				gate_pass_unit = ParamRS.getString("DFLT_GATE_PASS_UNIT"); 
			}
		}
	
	if(gate_pass_period == null) gate_pass_period ="";
	if(gate_pass_unit == null) gate_pass_unit ="";


	if(gate_pass_period.equals("") || gate_pass_period.equals("0"))
	{
		out.println("<script>alert(getMessage('RENEW_GATE_PASS_NOT_DEF','IP'));parent.window.close();</script>");
	}

	lodger_ref_no = request.getParameter("lodger_ref_no") ;
    if(lodger_ref_no.equals("null"))  lodger_ref_no ="" ;

	nursing_desc = request.getParameter("nursing_desc") ;
	if(nursing_desc.equals("null"))  nursing_desc ="" ;

	patientID = request.getParameter("PatID") ;
    if(patientID.equals("null"))  patientID ="" ;

	StringBuffer ExeSQL = new StringBuffer();
		
	ExeSQL.append(" SELECT a.PATIENT_ENCOUNTER_ID,");
	ExeSQL.append(" a.LODGER_RELATION_CODE,");
	ExeSQL.append(" a.REASON_FOR_STAY_CODE,");
	ExeSQL.append(" a.LODGER_NAME,");
	ExeSQL.append(" to_char(a.check_in_date_time,'dd/mm/rrrr hh24:mi') CHECK_IN_DATE_TIME,");
	ExeSQL.append(" to_char(a.PERIOD_FROM_DATE,'dd/mm/rrrr hh24:mi') PERIOD_FROM_DATE,");
	ExeSQL.append(" to_char(a.PERIOD_TO_DATE,'dd/mm/rrrr hh24:mi') PERIOD_TO_DATE,");
	ExeSQL.append(" to_char(a.period_to_date+ (1 / 1440), 'dd/mm/rrrr hh24:mi') renewal_valid_from_date,");	ExeSQL.append("TO_CHAR(decode('"+gate_pass_unit+"','H',a.period_to_date+('"+gate_pass_period+"'/24),'D',a.period_to_date+'"+gate_pass_period+"'),'dd/mm/rrrr hh24:mi') renewal_valid_to_date,");
	ExeSQL.append(" a.ATTACHED_TO_INPATIENT_YN,");
	ExeSQL.append(" a.NURSING_UNIT_CODE,a.REMARKS,a.AUTHORISED_BY,a.LODGER_GENDER,");
	ExeSQL.append(" to_char(a.LODGER_DOB,'dd/mm/rrrr') LODGER_DOB,");
	ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),1)years, ");
	ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),2)months, ");
	ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),3)days, ");
	ExeSQL.append(" get_age(a.LODGER_DOB) Acc_person_age,");
	ExeSQL.append(" a.NAME_PREFIX, a.FIRST_NAME, a.SECOND_NAME, a.THIRD_NAME,");
	ExeSQL.append(" a.FAMILY_NAME, a.NAME_SUFFIX,");
	ExeSQL.append(" a.CITIZEN_YN, a.LEGAL_YN,");
	ExeSQL.append(" a.ALT_ID1_TYPE,a.ALT_ID1_NO,");
	ExeSQL.append(" to_char(a.ALT_ID1_EXP_DATE,'dd/mm/rrrr') ALT_ID1_EXP_DATE,");
	ExeSQL.append(" a.ALT_ID2_TYPE,a.ALT_ID2_NO,");
	ExeSQL.append(" to_char(a.ALT_ID2_EXP_DATE,'dd/mm/rrrr') ALT_ID2_EXP_DATE,");
	ExeSQL.append(" a.ALT_ID3_TYPE, a.ALT_ID3_NO,");
	ExeSQL.append(" to_char(a.ALT_ID3_EXP_DATE,'dd/mm/rrrr') ALT_ID3_EXP_DATE,");
	ExeSQL.append(" a.ALT_ID4_TYPE, a.ALT_ID4_NO,");
	ExeSQL.append(" to_char(a.ALT_ID4_EXP_DATE,'dd/mm/rrrr')ALT_ID4_EXP_DATE,");
	ExeSQL.append(" a.OTH_ALT_ID_TYPE OTH_ALT_ID_TYPE,");
	ExeSQL.append(" (CASE WHEN a.OTH_ALT_ID_TYPE IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(a.OTH_ALT_ID_TYPE,'"+locale+"',1)) END) alt_short_desc,");
	ExeSQL.append(" a.OTH_ALT_ID_NO OTH_ALT_ID_NO,");
	ExeSQL.append(" a.LN1_LODGER_ADD, a.LN2_LODGER_ADD,");
	ExeSQL.append(" a.LN3_LODGER_ADD, a.LN4_LODGER_ADD,");
	ExeSQL.append(" a.LODGER_RES_TEL_NUM, a.LODGER_OFF_TEL_NUM,"); 
	ExeSQL.append(" a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2,");
	ExeSQL.append(" a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4,");
	ExeSQL.append(" a.lodger_patient_id, a.national_id_no,");
	ExeSQL.append(" a.BIRTH_PLACE_CODE BIRTH_PLACE_CODE, (CASE WHEN a.BIRTH_PLACE_CODE IS NOT NULL THEN (mp_get_desc.MP_BIRTH_PLACE(a.BIRTH_PLACE_CODE,'"+locale+"',1)) END) birth_place_desc,");
	ExeSQL.append(" a.ETHNIC_GROUP_CODE, (CASE WHEN a.ETHNIC_GROUP_CODE IS NOT NULL THEN (mp_get_desc.MP_ETHNIC_GROUP(a.ETHNIC_GROUP_CODE,'"+locale+"',1)) END) ETHNIC_DESCRIPTION,");
	ExeSQL.append(" a.RACE_CODE, ");
	ExeSQL.append("(CASE WHEN a.race_code IS NOT NULL THEN (mp_get_desc.mp_race(a.race_code,'"+locale+"',1)) END) RACE_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_AREA_CODE MAIL_AREA_CODE, (CASE WHEN a.MAIL_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"',1)) END) MAIL_AREA_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_TOWN_CODE MAIL_TOWN_CODE, (CASE WHEN a.MAIL_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"',1)) END) MAIL_TOWN_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_REGION_CODE MAIL_REGION_CODE,  (CASE WHEN a.MAIL_REGION_CODE IS NOT NULL THEN (mp_get_desc.MP_REGION(a.MAIL_REGION_CODE,'"+locale+"',1)) END) MAIL_REGION_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_POSTAL_CODE MAIL_POSTAL_CODE, ");
	ExeSQL.append(" a.MAIL_COUNTRY_CODE, (CASE WHEN a.MAIL_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.MAIL_COUNTRY_CODE,'"+locale+"',1)) END) MAIL_COUNTRY_DESCRIPTION,");
	ExeSQL.append(" a.RES_AREA_CODE RES_AREA_CODE , (CASE WHEN a.RES_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.RES_AREA_CODE,'"+locale+"',1)) END) RES_AREA_DESCRIPTION,");
	ExeSQL.append(" a.RES_TOWN_CODE RES_TOWN_CODE, (CASE WHEN a.RES_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.RES_TOWN_CODE,'"+locale+"',1)) END) RES_TOWN_DESCRIPTION,");
	ExeSQL.append(" a.RES_REGION_CODE RES_REGION_CODE, (CASE WHEN a.RES_REGION_CODE IS NOT NULL THEN (mp_get_desc.MP_REGION(a.RES_REGION_CODE,'"+locale+"',1)) END) RES_REGION_DESCRIPTION,");
	ExeSQL.append(" a.RES_POSTAL_CODE RES_POSTAL_DESCRIPTION,");
	ExeSQL.append(" a.RES_COUNTRY_CODE, (CASE WHEN a.RES_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.RES_COUNTRY_CODE,'"+locale+"',1)) END) RES_COUNTRY_DESCRIPTION,");
	ExeSQL.append(" a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc,");//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
	ExeSQL.append(" a.LODGER_EMAIL,");
	ExeSQL.append(" (CASE WHEN a.NATIONALITY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.NATIONALITY_CODE,'"+locale+"',1)) END) NATIONALITY_DESC, a.NATIONALITY_CODE NATIONALITY_CODE");  
	ExeSQL.append("  , NAME_PREFIX_LOC_LANG ");
	ExeSQL.append("  , FIRST_NAME_LOC_LANG ");
	ExeSQL.append("  , SECOND_NAME_LOC_LANG ");
	ExeSQL.append("  , THIRD_NAME_LOC_LANG ");
	ExeSQL.append("  , FAMILY_NAME_LOC_LANG ");
	ExeSQL.append("  , NAME_SUFFIX_LOC_LANG ");
	ExeSQL.append("  , LODGER_NAME_LOC_LANG ");
	ExeSQL.append(" FROM ");
	ExeSQL.append(" ip_lodger_detail a");
	ExeSQL.append(" WHERE ");
	ExeSQL.append(" a.facility_id = '"+facility_id+"' AND");
	ExeSQL.append(" a.lodger_ref_no ='"+lodger_ref_no+"' "); 

	

    stmt = con.createStatement();
	rs = stmt.executeQuery(ExeSQL.toString());

	if(rs!=null)
	{
		if ( rs.next() )
		{
			Category = rs.getString("ATTACHED_TO_INPATIENT_YN") ; 
			if(Category.equals("Y"))
				Category = "A" ;
			else
				Category = "L" ;


			years	= rs.getString( "years" );
				if(years ==null)	years ="";
			months  = rs.getString( "months" );
				if(months ==null)	months ="";
			days    = rs.getString( "days" );
				if(days ==null)	days ="";

			encounter_id         = String.valueOf( rs.getLong("patient_encounter_id") );
			if(encounter_id ==null)	encounter_id ="";

			lodger_relation_code     = rs.getString( "lodger_relation_code" );
			if(lodger_relation_code ==null)	lodger_relation_code ="";

			reason_for_stay      = rs.getString( "reason_for_stay_code" );
			if(reason_for_stay ==null) 	reason_for_stay ="";

			lodger_patient_name  = rs.getString( "lodger_name" );
			if(lodger_patient_name ==null)	lodger_patient_name ="";

			check_in_date_time   = rs.getString( "check_in_date_time" );
			 if(check_in_date_time == null)  check_in_date_time = "";

			Period_date_time_from = rs.getString("PERIOD_FROM_DATE"); 
			if(Period_date_time_from == null)	Period_date_time_from = "";

			Period_date_time_to = rs.getString("PERIOD_TO_DATE"); 
			if(	Period_date_time_to == null)	Period_date_time_to = "";

			renewalValid_fr = rs.getString("renewal_valid_from_date"); 
			if(	renewalValid_fr == null)	renewalValid_fr = "";
			renewalValid_fr  = DateUtils.convertDate(renewalValid_fr,"DMYHM","en",locale);
			renewalValid_to = rs.getString("renewal_valid_to_date"); 
			if(	renewalValid_to == null)	renewalValid_to = "";
			renewalValid_to  = DateUtils.convertDate(renewalValid_to,"DMYHM","en",locale);
			
			if(!(check_in_date_time==null || check_in_date_time.equals("")))
				check_in_dis_dat_tim  = DateUtils.convertDate(check_in_date_time,"DMYHM","en",locale);
			if(!(Period_date_time_from==null || Period_date_time_from.equals("")))
				Period_dat_dis_tim_fr = DateUtils.convertDate(Period_date_time_from,"DMYHM","en",locale);
			if(!(Period_date_time_to==null || Period_date_time_to.equals("")))
				Period_dat_dis_tim_to = DateUtils.convertDate(Period_date_time_to,"DMYHM","en",locale);

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

			Acc_person_age    = rs.getString("Acc_person_age");
			if(Acc_person_age==null) Acc_person_age="";

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

			if(!(alt_id1_exp_date==null || alt_id1_exp_date.equals("")))
				alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY","en",locale);

			alt_id2_exp_date= rs.getString( "ALT_ID2_EXP_DATE" );
			if(alt_id2_exp_date==null) alt_id2_exp_date="";

			if(!(alt_id2_exp_date==null || alt_id2_exp_date.equals("")))
				alt_id2_exp_date = DateUtils.convertDate(alt_id2_exp_date,"DMY","en",locale);


			alt_id3_exp_date= rs.getString( "ALT_ID3_EXP_DATE" );
			if(alt_id3_exp_date==null) alt_id3_exp_date="";

			if(!(alt_id3_exp_date==null || alt_id3_exp_date.equals("")))
				alt_id3_exp_date = DateUtils.convertDate(alt_id3_exp_date,"DMY","en",locale);


			alt_id4_exp_date= rs.getString( "ALT_ID4_EXP_DATE" );
			if(alt_id4_exp_date==null) alt_id4_exp_date="";

			if(!(alt_id4_exp_date==null || alt_id4_exp_date.equals("")))
				alt_id4_exp_date = DateUtils.convertDate(alt_id4_exp_date,"DMY","en",locale);


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


//++++++++++++++++++++++++ RESIDENCE ADDRESS DETAILS ++++++++++++++++++++++++++++

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

//++++++++++++++++++++++++ MAILING ADDRESS DETAILS ++++++++++++++++++++++++++++

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

			oth_contact_no       = rs.getString( "lodger_off_tel_num" );
			if(oth_contact_no ==null)		oth_contact_no ="";  

			other_tel_no       = rs.getString( "lodger_res_tel_num" );
			if(other_tel_no ==null)		other_tel_no ="";  

			email_id= rs.getString( "LODGER_EMAIL" );
			if(email_id==null) email_id="";

			/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
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


			name_prefix_loc_lang	= checkForNull(rs.getString("name_prefix_loc_lang"));
			first_name_loc_lang		= checkForNull(rs.getString("first_name_loc_lang"));
			second_name_loc_lang	= checkForNull(rs.getString("second_name_loc_lang"));
			third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang"));
			family_name_loc_lang	= checkForNull(rs.getString("family_name_loc_lang"));
			name_suffix_loc_lang	= checkForNull(rs.getString("name_suffix_loc_lang"));
			patient_name_loc_lang	= checkForNull(rs.getString("lodger_name_loc_lang"));
		}//E.o RS
	}// E.o RS !null
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(citizen));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(legal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(gate_pass_unit));
            _bw.write(_wl_block11Bytes, _wl_block11);
if(Category.equals("A")){
	   out.println( "<td colspan='4' align='left' class=\"COLUMNHEADER\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonDetails.label","ip_labels")+"</td>" ) ;
	   }else{
	   out.println( "<td colspan='4'class= \"COLUMNHEADER\" align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.LodgerDetails.label","ip_labels")+"</td>" ) ;
	   }
	
            _bw.write(_wl_block12Bytes, _wl_block12);

	if(mode.equals("insert"))
	{

            _bw.write(_wl_block13Bytes, _wl_block13);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf("RENEW_GATE_PASS")},{ weblogic.utils.StringUtils.valueOf("lodger_relation_code"), weblogic.utils.StringUtils.valueOf(lodger_relation_code
                        )},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("readonly_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("top.frames[0]")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("top.frames[1]")},};
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
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf("CHECK_IN_ACCMP_PERSON")},{ weblogic.utils.StringUtils.valueOf("lodger_relation_code"), weblogic.utils.StringUtils.valueOf(lodger_relation_code
                        )},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("readonly_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("top.frames[0]")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("top.frames[1]")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);
	}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Acc_person_age));
            _bw.write(_wl_block21Bytes, _wl_block21);

if(!mode.equals("insert"))
{	
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lodger_patient_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nameprefix));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nameprefix));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(familyname));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(firstname));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(secondname));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(thirdname));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(name_suffix_loc_lang));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(Acc_person_age));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(years));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(months));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(days));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(alt_id2_exp_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_id3_exp_date));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(alt_id4_exp_date));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(oth_alt_id_type));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(oth_alt_id_no));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(res_addr_line1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(res_addr_line2));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(res_addr_line3));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(res_addr_line4));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(res_region_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(res_region_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mail_addr_line1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mail_addr_line2));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(mail_addr_line3));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(mail_addr_line4));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(mail_town_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(mail_town_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(mail_area_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(mail_area_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(mail_postal_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(mail_region_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(mail_region_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(mail_country_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(mail_country_desc));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(other_tel_no));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(oth_contact_no));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(alt_addr_line1));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(alt_addr_line2));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(alt_addr_line3));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(alt_addr_line4));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(alt_area_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(alt_area_desc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(alt_town_code));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(alt_town_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(alt_postal_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(alt_postal_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(alt_region_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(alt_region_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(alt_country_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(alt_country_desc));
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(Period_date_time_to));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(check_in_dis_dat_tim));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(nursing_desc));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(Period_dat_dis_tim_fr));
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(Period_dat_dis_tim_to));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(gate_pass_period));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(authorized_by));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(Period_date_time_to));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(renewalValid_fr));
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(Period_date_time_to));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(renewalValid_to));
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.renewgatepass.label","ip_labels")));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block122Bytes, _wl_block122);
 } 
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(Category));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(lodger_ref_no));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(label));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block131Bytes, _wl_block131);

}catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();
	}
finally
{
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (ParamRS != null) ParamRS.close();
	if (ParamStmt != null) ParamStmt.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block132Bytes, _wl_block132);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CurrentValidityDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CheckInDateTime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodfrom.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodto.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RenewalValidityDetails.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodfrom.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodto.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
