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
import java.text.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifybooking extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AddModifyBooking.jsp", 1733735086479L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n";
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

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n<script src=\"../../eCommon/js/dchk.js\" language=\"javaScript\"></script>\n<script src=\"../../eIP/js/Booking.js\" language=\"JavaScript\"></script>\n<script src=\"../../eIP/js/Booking1.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eIP/js/IPPractitionerComponent.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style type=\"text/css\">\nul {\n    display: block;\n    list-style-type: disc;\n    margin-block-start: 1em;\n    margin-block-end: 1em;\n    margin-inline-start: 0px;\n    margin-inline-end: 0px;\n    padding-inline-start: 0px;\n    unicode-bidi: isolate;\n}\n</style>\n\n\n<TITLE>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" </TITLE>\n</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<script>\n\n\tfunction LoadBookingDetails()\n\t{\n\t\tif(document.forms[0].call_function.value == \"OT\")\n\t\t{\t\n\t\t\t/*Tuesday, December 21, 2010 , commented for  MO-GN-5329 [IN:025559] , pref_adm_date date calculation will be done by pre_op_days value passed from OT */\n\t\t\t//document.forms[0].pref_adm_date.value = convertDate(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\"DMYHM\",\"en\",localeName);\n\t\t\tdocument.forms[0].ot_date_time.value  = convertDate(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\"DMYHM\",\"en\",localeName);\n\t\t\tcalcPrefDateForPreparationDay();\n\t\t\tdateCal(document.forms[0].pref_adm_date);\n\t\t\t/*Tuesday, December 21, 2010 , commented for  MO-GN-5329 [IN:025559]*/\n\t\t\tif(document.forms[0].ot_date_time.value == \'\' )\n\t\t\t{\n\t\t\t\tdocument.forms[0].ot_date_time.disabled\t\t= false;\n\t\t\t\tdocument.getElementById(\"otdt\").disabled\t\t\t\t\t= false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].ot_date_time.disabled\t\t= true;\n\t\t\t\tdocument.getElementById(\"otdt\").disabled\t\t\t\t\t= true;\n\t\t\t}\n\t\t\tdocument.forms[0].pre_op_days.value\t\t\t\t\t= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\tif(document.forms[0].pre_op_days.value == null || document.forms[0].pre_op_days.value == \'\')\n\t\t\t\tdocument.forms[0].pre_op_days.value\t\t\t= \'0\';\n\t\t\tdocument.forms[0].exp_days_of_stay.value\t\t\t= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\tif(document.forms[0].exp_days_of_stay.value == null || document.forms[0].exp_days_of_stay.value == \'\')\n\t\t\t\tdocument.forms[0].exp_days_of_stay.value\t\t\t= \'1\';\n\t\t\t/**/\n\t\t\tif(document.forms[0].exp_days_of_stay.value != \'\' && document.forms[0].pref_adm_date.value != \'\')\n\t\t\t{\n\t\t\t\t\n\t\t\t\tvar expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,\'DMYHM\',localeName,document.forms[0].exp_days_of_stay.value,\'d\');\n\t\t\t\tdocument.forms[0].exp_discharge_date.value\t= expdischargeDate;\t\t\t\n\t\n\t\t\t}\n\t\t\tcalcPrefDateForPreparationDay1();\n\n\t\t\tif(document.forms[0].med_service_grp.value == \'\' )\n\t\t\t\tdocument.forms[0].med_service_grp.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].med_service_grp.disabled = true;\n\n\t\t\tdocument.forms[0].Splcode_desc.value\t\t= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\tdocument.forms[0].Splcode.value\t\t\t\t= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\tdocument.forms[0].practid_desc.value\t\t= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\tdocument.forms[0].practid.value\t\t\t\t= \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\n\t\t\tvar physician_code=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\tvar specialty_code=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\tvar nursing_unit_code=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\tvar medical_service=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\n\t\t\t// code added for  this incident: 18350\n\t\t\tvar xmlDoc = \"\"\n\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\txmlStr =\"<root><SEARCH step=\'six\'  medical_service=\\\"\"+medical_service+\"\\\"   nursing_unit_code=\\\"\"+nursing_unit_code+\"\\\"/></root>\"\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\txmlHttp.open(\"POST\",\"BookingGetExpDaysDate.jsp\",false)\n\t\t\txmlHttp.send(xmlDoc)\n\t\t\tresponseText=xmlHttp.responseText\n\t\t\tresponseText= trimString(responseText)\n           var arr1 = responseText.split(\"||\");\t\n\n\t\t\tif(arr1[0]==\'N\')\n\t\t\t{\n\t\t\t\talert(getMessage(\"INVALID_MSG_NUT_RIGHTS\",\"IP\"));\n\t\t\t\tdocument.forms[0].nursing_unit_desc.value\t= \"\";\t\n\t\t\t\t document.forms[0].nursing_unit.value\t\t= \"\";\t\n\t\t\t\tdocument.forms[0].nurs_unit_desc_hid.value\t= \"\";\t\n\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t\t/*\n\t\t\t\t\tend here 18350\n\n\t\t\t\t\tcode developed for incident:18206\n\t\t\t\t\t*/\n\t\t\t\t\tvar xmlDoc = \"\"\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\t\t\txmlStr =\"<root><SEARCH step=\'five\'  practitioner_id=\\\"\"+physician_code+\"\\\"  specialty_code=\\\"\"+specialty_code+\"\\\"  nursing_unit_code=\\\"\"+nursing_unit_code+\"\\\"/></root>\"\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t\t\txmlHttp.open(\"POST\",\"BookingGetExpDaysDate.jsp\",false)\n\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\t\tresponseText= trimString(responseText)\n\t\t\t\t   var arr = responseText.split(\"||\");\t\n\t\t\t\t\t\n\t\t\t\t  \n\t\t\t\t\tif(arr[0]!=\'\'&&arr[1]!=\'\') \n\t\t\t\t\t{\n\t\t\t\t\t\t\tvar practCount=arr[0];\n\t\t\t\t\t\t\tvar spltCount=arr[1];\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(practCount==0&&spltCount==0)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\talert(getMessage(\"PRACT_ADMN_RIGHTS_DENIED\",\"IP\")+\"\\n\"+getMessage(\"SPLTY_ADMN_RIGHTS_DENIED\",\"IP\"))\n\t\t\t\t\t\t\t\t\tdocument.forms[0].nursing_unit_desc.value\t= \"\";\t\n\t\t\t\t\t\t\t\t document.forms[0].nursing_unit.value\t\t= \"\";\t\n\t\t\t\t\t\t\t\t  document.forms[0].nurs_unit_desc_hid.value\t= \"\";\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(practCount==0||spltCount==0)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tif(practCount==0)\n\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\"PRACT_ADMN_RIGHTS_DENIED\",\"IP\"))\n\t\t\t\t\t\t\t\t\t\t\telse if(spltCount==0)\n\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\"SPLTY_ADMN_RIGHTS_DENIED\",\"IP\"))\n\n\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].nursing_unit_desc.value\t= \"\";\t\n\t\t\t\t\t\t\t\t\t\t   document.forms[0].nursing_unit.value\t\t= \"\";\t\n\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].nurs_unit_desc_hid.value\t= \"\";\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t  document.forms[0].nursing_unit_desc.value\t= \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\t\n\t\t\t\t\t\t\t\t\t\t   document.forms[0].nursing_unit.value\t\t= \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\t\n\t\t\t\t\t\t\t\t\t\t   document.forms[0].nurs_unit_desc_hid.value\t= \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\t\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.forms[0].nursing_unit_desc.value\t= \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\t\n\t\t\t\t\t   document.forms[0].nursing_unit.value\t\t= \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\t\n\t\t\t\t\t   document.forms[0].nurs_unit_desc_hid.value\t= \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\t\n\t\t\t\t\t   \n\t\t\t\t\t}\n\t\t\t}\n\t\t\t\n\n\t\t\t/*\n\t\t\tcode end here\n\t\t\t*/\n\n\t\t\t\n\n\n\t\t\t\n\t\t\t\n\t\t\t/* Saturday, June 13, 2009 modified for IN010922 \n\t\t\t\n\t\t\tif(document.forms[0].Splcode_desc.value!=\'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].Splcode_desc.disabled\t\t=\ttrue;\n\t\t\t\tdocument.forms[0].Splcode_lookup.disabled\t=\ttrue;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].Splcode_desc.disabled\t\t=\tfalse;\n\t\t\t\tdocument.forms[0].Splcode_lookup.disabled\t=\tfalse;\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\tif(document.forms[0].practid_desc.value!=\'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].practid_desc.disabled\t\t=\ttrue;\n\t\t\t\tdocument.forms[0].pract_id_search.disabled\t=\ttrue;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].practid_desc.disabled\t\t=\tfalse;\n\t\t\t\tdocument.forms[0].pract_id_search.disabled\t=\tfalse;\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\tif(document.forms[0].nursing_unit_desc.value!=\'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].nursing_unit_desc.disabled\t\t=\ttrue;\n\t\t\t\tdocument.forms[0].nursing_unit_lookup.disabled\t\t=\ttrue;\n\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].nursing_unit_desc.disabled\t\t=\tfalse;\n\t\t\t\tdocument.forms[0].nursing_unit_lookup.disabled\t\t=\tfalse;\t\t\n\t\t\t}\n\t\t\t*/\n\t\t\t//document.forms[0].practid_desc.disabled\t\t= false;\n\t\t\t//document.forms[0].pract_id_search.disabled\t= false;\n\t\t\tdocument.forms[0].referral_id.disabled\t\t= true;\n\t\t\tdocument.forms[0].referral_details.disabled = false;\n\t\t\tdocument.forms[0].pref_adm_date.readOnly\t= false;\n\t\t\tdocument.getElementById(\"prefdt\").disabled\t\t\t\t= false;\n\t\t\tsetTimeout(\'populatepatDetails()\',1000);\n\n\t\t\tChangeVal(parent.frames[1].document.forms[0].med_service_grp);\n\t\t\t\n\t\t\t//document.forms[0].exp_days_of_stay.onblur();\n\n\t\t\t\n\n\t\t\t\n\t\t\t/*if(document.forms[0].Splcode.value!=\'\' && document.forms[0].nursing_unit.value!=\'\' && document.forms[0].practid.value!=\'\')\n\t\t\t{\n\t\t\t\t\tvalidateNursingUnitSplCodePractID(document.forms[0].Splcode.value,document.forms[0].nursing_unit.value,document.forms[0].practid.value);\n\t\t\t}*/\n\t\t\t/*else\n\t\t\t{\n\t\t\t\tChangeVal(parent.frames[1].document.forms[0].med_service_grp);\n\t\t\t\tdocument.forms[0].exp_days_of_stay.onblur();\n\t\t\t}*/\n\t\t\t\n\t\t\t//alert(\'start\');\n\t\t\t/*ChangeVal(parent.frames[1].document.forms[0].med_service_grp);\n\t\t\t*/\n\t\t\t//alert(\'end\');\n\t\t\t//\n\t\t\t\n\t\t}\t\n\t}\n\n\n\tfunction setFocus() \n\t{\n\t\tif( document.forms[0].pref_adm_date.readOnly == false && document.forms[0].pref_adm_date.disabled == false )\n\t\t{\n\t\t\tdocument.forms[0].pref_adm_date.focus();\n\t\t}\n\t}\nfunction checkMaxLimitOfRemark(obj)\n\t{\n\t\tif ( obj.value.length > 250 )\n\t\t{\n\t\t\tvar error = getMessage(\"REMARKS_CANNOT_EXCEED\",\"common\");\n\t\t\tvar remarks = getLabel(\"Common.booking.label\",\"common\") + \" \" + getLabel(\"Common.remarks.label\",\"common\");\n\t\t\terror = error.replace(\"$\",remarks);\n\t\t\terror = error.replace(\"#\",\"250\")\n\t\t\talert(error);\n\t\t\tobj.select();\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t\treturn true;\n\t}\n\tfunction CheckForSpecChars_Remarks(event){\n\t\n    //var strCheck = \'\"+%?@#$~\\\'<>\';\n    var strCheck =\'~`!@#$%^&*()-_=+{[}]|:;\",./?\\<>\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    //if (strCheck.indexOf(key) == -1) return true;  // Not a valid key\n\tif (strCheck.indexOf(key) == -1 && whichCode != 92) return true; // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode);\n\treturn false ;\n}\nfunction imposeMaxLength(obj)\n{\n var mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\tobj.value=obj.value.substring(0,mlength)\n}\n</script>\n<body onLoad=\"gifpop();";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="getWaitlist();";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="Control_NursingUnit();LoadBookingDetails();\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'booking_form\' id=\'booking_form\' action=\'../../servlet/eIP.BookingServlet\' method=\'post\' target=\'messageFrame\'> \n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t<a name=\'tab1\' id=\'tab1\'></a>\n\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t<li class=\"tablistitem\" title=\"Booking Details\">\n\t\t\t\t<a onclick=\"tab_click(\'booking_tab\')\" class=\"tabClicked\" id=\"booking_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Financial Details\">\n\t\t\t\t<a onclick=\"tab_click(\'findtl_tab\')\" class=\"tabA\" id=\"findtl_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t</ul>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t\t<tr>\n\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t<td class=\'fields\' width=\'20%\' ><input type=text  name=\'ot_date_time\' id=\'ot_date_time\'  onBlur=\"doOTDateTimeChk2(this);\" size=\"16\" maxlength=\"16\"  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" value=\"\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ><img name=\'otdt\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'ot_date_time\',null,\'hh:mm\');document.forms[0].ot_date_time.select();\"/>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t<td width=\'10%\' class=\'label\'></td>\n\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t<td class=\'fields\' width=\'20%\' ><INPUT TYPE=\'text\' value=\"0\" name=\'pre_op_days\' id=\'pre_op_days\' size=\"3\" maxlength=\"3\"  onKeyPress=\'return(ChkNumberInput(this,event,0))\'  onBlur=\"CheckNum(this);displayDefaultValue(this);calcPrefDateForPreparationDay1();\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td  width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t<td  width=\'20%\' class=\'field\' ><input type=\"hidden\" name =\"sdate\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\tvalue=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">\n\t    <INPUT TYPE=\"text\" name=\"pref_adm_date\" id=\"pref_adm_date\"   ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" size=\"16\" maxlength=\"16\"  onBlur=\"Allfunc(this,document.forms[0].sdate2);calcDate(this);\" onKeyPress=\'return(ChkNumberInput1(this,event,2))\'><img name=\'prefdt\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'pref_adm_date\',null,\'hh:mm\');document.forms[0].pref_adm_date.focus();\"/><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img><input type=\'hidden\' name=\'hdnBlur\' id=\'hdnBlur\' value=\'\'>\n\t\t</td> \n\t   <td width=\'10%\' id=\"DayVal\" class=\"label\" align=\"left\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\t \n\t   <td width=\'20%\' class=\'label\'  nowrap>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n   \t   <td width=\'20%\' class=\'field\'>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<input type=\"text\" size =\"14\" maxlength=\"14\" name=\'referral_id\' id=\'referral_id\' value=\"\" disabled><input type=\'button\' class =\'button\' Value =\'?\' name=\'referral_details\' id=\'referral_details\' disabled>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\'ref_img\' style=\"visibility:hidden\"></img>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<input type=\"text\" size =\"14\" maxlength=\"14\" name=\'referral_id\' id=\'referral_id\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="onBlur=\"ChangeUpperCase(this);referralDetails(this,\'N\');movtab();\" onKeyPress=\'return CheckForSpecChars(event)\' ><input type=\'button\' class =\'button\' Value =\'?\' name=\'referral_details\' id=\'referral_details\' onClick=\'PopRefDetails()\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'ref_img\' style=\"visibility:hidden\"></img>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n\t\t</td>\n   \t</tr>\n\t<tr>\n\t\t<td  width=\'20%\' class=\'label\'   >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t<td  width=\'20%\' class=\'fields\' ><SELECT name=\"med_service_grp\" id=\"med_service_grp\" onBlur=\"\" onChange=\"ChangeVal(this)\"><option value=\'\' selected>---";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="---\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t     \n\t   \t</SELECT>\n      \t<input type=\'hidden\' name=\'generatenumyn\' id=\'generatenumyn\' value=\'\'><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img><input type=\'hidden\' name=\'app_pat_class\' id=\'app_pat_class\' value=\'\'></td> \n\t\t<td  width=\'10%\' ></td>\n\t\t<td width=\'20%\' class=\'label\' nowrap  >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n   \t\t<td width=\'20%\' class=\'fields\'><INPUT TYPE=\'text\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" name=\'booking_ref_no\' id=\'booking_ref_no\' size=\"12\" maxlength=\"12\" onKeyPress=\'return CheckForSpecChars(event)\' onBlur=\"specialChar(this,\'Char\');\"><img id = \"gifpop\" src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></td>   \t   \n\t</tr>\n\t<tr>\n   \t   <td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n   \t   <!--<td class=\'fields\' colspan=\'2\'><INPUT TYPE=\'text\' value=\"1\" name=\'exp_days_of_stay\' id=\'exp_days_of_stay\' size=\"4\" maxlength=\"3\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNum(this);CheckZeroVal(this);displayDefaultValue(this);CheckProcDtTime(this);calcDate(this);\"></td>\n\t    <td class=\"label\" >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\t  \n\t\t<td  class=\'fields\' ><input type=\'text\' name=\'exp_discharge_date\' id=\'exp_discharge_date\' id=\'exp_discharge_date_id\' value=\"\" size=\'16\' maxlength=\'16\' readonly></td>-->\n\t\t<td width=\'20%\'class=\'fields\'><INPUT TYPE=\'text\' value=\"1\" name=\'exp_days_of_stay\' id=\'exp_days_of_stay\' size=\"4\" maxlength=\"3\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNum(this);CheckZeroVal(this);displayDefaultValue(this);calcDateForExpDisc(this);\"></td>\n\t\t\t<td  width=\'10%\'></td>\n\t    <td width=\'20%\' class=\"label\" >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\t  \n\t\t<td width=\'20%\' class=\'fields\' ><input type=\'text\' name=\'exp_discharge_date\' id=\'exp_discharge_date\' id=\'exp_discharge_date_id\' value=\"\" size=\'16\' maxlength=\'16\' readonly></td>\n\t</tr>\n\t<tr>\n   \t\t<td class = \'label\'  width=\'20%\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t<td class=\'field\' colspan=\'4\'><SELECT name =\'priority_ind\'><option value =\'N\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</option><option value =\'U\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</option></SELECT></td>\n  \t</tr>\n</table>\n\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td class=\"COLUMNHEADER\" colspan=\'5\' ><b>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</b></td></tr>\n\t    \n\t\t<tr>\t   \n\t\t<td  colspan=\'5\' class=\'fields\' >\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 24/01/2013-->\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t   </td>\n\t</tr>\n</table>\t\t\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<tr><td class=\"COLUMNHEADER\" colspan=\'5\' ><b>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</b></td></tr>\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<tr><td colspan=5 class=\'label\' height=\'5\' ></td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t<td  class=\'fields\' width=\'20%\'><b>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="<b></td>\n\t\t\t<td  width=\'10%\' ></td>\n\t\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t<td class=\'fields\' width=\'20%\'><b>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="<b></td>\n\t\t\t\n\t\t</tr>\n\t\t<tr><td colspan=5 class=\'label\' height=\'5\' ></td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="<b></td>\n\t\t\t<td  class=\'label\' colspan=\'3\' ></td>\n\t\t</tr>\n\t\t<tr><td colspan=5 class=\'label\' height=\'5\' ></td></tr>\n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t<tr><td  class=\'label\'  colspan = \'3\'></td>\n\t<td  class=\'label\' id=\'OpenBooking\' colspan = \'2\'></td></tr>\n\t<tr>\n\t\t<td class=\'label\'  width=\'20%\' >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t<td class=\'fileds\' width=\'20%\' ><input type=\"text\" name=\'chief_complaint\' id=\'chief_complaint\' size=\"30\"  maxLength=\"200\" onChange=\"ReasonLookupBlur();\"><input type=hidden name=\'complaintcode\' id=\'complaintcode\' ><input type=hidden name=\'chief_complaint_hid\' id=\'chief_complaint_hid\'><input type=button name=\'chfcomp_lookup\' id=\'chfcomp_lookup\' value=\'?\' class=button onClick=\"if(document.forms[0].chief_complaint.value == \'\')ReasonLookup();\"></td>\t\t\n\t\t<!--/*modification for SRR20056-CRF-0506*/-->\n\t\t<td  width=\'10%\' ></td>\n\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t<td  class=\'fileds\' width=\'20%\'><SELECT name=\"booking_Type\" id=\"booking_Type\" onBlur=\"\" ><option value=\'\' selected>-----";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="-----\n\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t<option value=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</option>\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\t\n\t\t</select></td>\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t\t<td  class=\'fileds\' width=\'20%\'><input type=\"text\" name=\'Splcode_desc\' id=\'Splcode_desc\' maxlength=\"15\" size=\"15\" onBlur=\"SpecialtyLookupBlur();\"><input type=\'hidden\' name=\'Splcode\' id=\'Splcode\' ><input type=button name=\'Splcode_lookup\' id=\'Splcode_lookup\' value=\'?\' class=button onClick=\"if(document.forms[0].Splcode_desc.value == \'\')SpecialtyLookup();\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t<td  width=\'10%\' ></td>\n\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t<td class=\'fileds\' width=\'20%\'><input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' value=\"\" size=\"20\" maxlength=\"30\" onBlur=\"getPractIDBlur(document.forms[0].pract_id_search,practid_desc);\"><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"\"><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"if(document.forms[0].practid_desc.value  == \'\') getPractID(this,practid_desc);\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t<td class=\'fileds\' width=\'20%\'><select name=\"team_id\" id=\"team_id\" disabled><option value=\'\'>---";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="---</select></td>\n\t\t<!--<td class=\'label\' colspan=\'2\'></td>-->\n\t\t<!--<td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t<td class=\'fileds\' width=\'25%\' ><input type=text  name=\'ot_date_time\' id=\'ot_date_time\' id=\"otdatetime\" onBlur=\"doOTDateTimeChk2(this);\" size=\"15\" maxlength=\"16\"  value=\"\" ><input type=\'image\' name=\'otdt\' id=\'otdt\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].ot_date_time.select();return showCalendar(\'otdatetime\',null,\'hh:mm\');\"></td>-->\n\t\t<td  width=\'10%\' ></td>\n\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="&nbsp";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t<td class=\'fileds\' width=\'20%\'><textarea style=\'resize: none\' name=\"booking_remarks\" rows=\"2\"  maxlength=\'250\'   onBlur=\"makeValidString(this);checkMaxLimitOfRemark(this);\" onKeyPress=\"/*return CheckForSpecChars_Remarks(event);*/\" onkeyup=\"return imposeMaxLength(this);\"></textarea></td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t\t<td width=\'20%\' class=\'fields\' ><input type=text name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" maxlength=15 size=15 value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" onblur=\"NursingUnitLookupBlur(\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\',\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'),setdefault();removePatInsSession();\" ><input type=button class=button name=nursing_unit_lookup value=\'?\' onClick=\"if(document.forms[0].nursing_unit_desc.value == \'\')NursingUnitLookup(\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\');removePatInsSession();\" ><input type=hidden name=\"nurs_unit_desc_hid\" id=\"nurs_unit_desc_hid\"  value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"></td>\n\t\t<td  width=\'10%\' ></td>\n\t\t<td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t<td class=\'fields\' width=\'20%\'><select name=\"service_desc\" id=\"service_desc\" onChange=\'\' style=\"width:115\"><option value=\"\">---";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="---</select><input type=\'hidden\' name=\"service_desc_hid\" id=\"service_desc_hid\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t</td>\n\t\t<input type=\'hidden\' name=\"nursing_unit\" id=\"nursing_unit\"  value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t<input type=\'hidden\' name=\"service_code\" id=\"service_code\"  value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t</tr>\n<!--\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'114%\' align=\'center\' id =\'bed_detail\' >\n-->\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n      \n\t\t<input type = \'hidden\' value = \"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" name = \'old_nursing_unit\'>  \n\t\t<tr>\n\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\t\t<td  class=\'fields\' width=\'20%\'><select name=\"bed_class_desc\" id=\"bed_class_desc\" style=\"width:115\" onChange=\'clearBedValues();populateBedType(this.value)\' dir=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'><option value=\"\">---";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="---</option></select><input type=hidden name=\"bed_class_code\" id=\"bed_class_code\"  value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"><input type=hidden name=\"bed_class_desc_hid\" id=\"bed_class_desc_hid\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"></td>\n\t\t<td  width=\'10%\' ></td>\n\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t<td  class=\'fields\' width=\'20%\'><select name=\"bed_type_desc\" id=\"bed_type_desc\"  onChange=\'clearBedValues();\'><option value=\"\">---";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="---</select><input type=hidden name=\"bedtypecode\" id=\"bedtypecode\"  value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"><input type=hidden name=\"bed_type_desc_hid\" id=\"bed_type_desc_hid\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"></td>\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t<td  class=\'fields\' width=\'20%\'><input type=\'text\' id =\'bed_no\' name=\'bed_no\' id=\'bed_no\'  value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" size=\"8\" maxlength = \"8\" onBlur=\'getRoomNo(this),ChangeVal(this);\'  onKeyPress=\'return CheckForSpecChars(event)\' readonly><input type=\'hidden\' name=\'old_bed_no\' id=\'old_bed_no\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"><input type=\'button\' name=\'bed_avail_chart\' id=\'bed_avail_chart\' onClick=\"openBedChart();\" value=\'?\'class=\'button\' ></td>\n\t\t<td  width=\'10%\' ></td>\n\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t\t<td  class=\'fields\' width=\'20%\'><input type=\'text\' name=\'room_no\' id=\'room_no\' onKeyPress=\'return CheckForSpecChars(event)\' value=\"\" size=\"10\" maxlength=\"10\" readonly>&nbsp;</td>\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t<td class=\'fields\' width=\'20%\'><input type=\'checkbox\' name =\'override\' ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" onClick=\"changeOVRVal(this)\" disabled>&nbsp;</td>\n\t\t<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 09/01/2013-->\n\t\t<!--Start-->\n\t\t<td  colspan=3></td>\n\t</tr>\n\t\t\n\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n<!--Included for the CRF - RUT CRF 013 23396 -->\n\t<tr>\n\t\n\t\t<td  class=\'label\'><a href=\'javascript:PatInsModalWindow()\'>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</a><img src=\'../../eCommon/images/InfoAlert.PNG\' id=\'NUInstsExist\' style=\'visibility:hidden\'/></td>\t\n\t\t<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 09/01/2013-->\n\t\t<!--Start-->\n\t\t<td  colspan=2></td>\n\t\t<td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\t\t<td width=\'20%\' class=\'fields\'><input name=\"surgery_order\" id=\"surgery_order\" type=\"text\" value=\"\" onblur=\"if(this .value!=\'\'){ GetSurgeryOrder(document.forms[0].patient_id.value,\'\');} else { GetSurgeryOrder_blank(document.forms[0].patient_id.value,\'\');}\"><input type=\'button\' name=\'surgery_order_name\' id=\'surgery_order_name\' onClick=\"GetSurgeryOrder(document.forms[0].patient_id.value,\'\');\" value=\'?\'class=\'button\' ></td><input name=\"surgery_order_code\" id=\"surgery_order_code\" type=\"hidden\" value=\"\"><input name=\"surgery_order_id\" id=\"surgery_order_id\" type=\"hidden\" value=\"\"><input name=\"surgery_order_line_no\" id=\"surgery_order_line_no\" type=\"hidden\" value=\"\">\n\t\t</td>\n\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t<td  colspan=3></td>\n\t\t<td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</td>\n\t\t<td width=\'20%\' class=\'QUERYDATA\' id=\'surgery_order_dt_id\'></td><input name=\"surgery_order_date\" id=\"surgery_order_date\" type=\"hidden\" value=\"\">\n\t\t</tr>\n\t\t<!--End-->\n\t\t\n</table> \n\t<input type=\'hidden\' name =\'confirm_yn\' value =\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n\t<input type=\'hidden\' name =\'override_yn\' value =\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" >\n\t<input type=\'hidden\' name=\'currdate\' id=\'currdate\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t<input type=\'hidden\' name=\'is_ca_yn\' id=\'is_ca_yn\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t<input type=\'hidden\' name=\'p_oper_stn_id\' id=\'p_oper_stn_id\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<input type=\'hidden\' name=\'qryString\' id=\'qryString\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\'hidden\' name=\'Unregpatbkgyn\' id=\'Unregpatbkgyn\' value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t<input type=\'hidden\' name=\'Splcode_desc_hid\' id=\'Splcode_desc_hid\' value=\'\'>\n\t<input type=\'hidden\' name=\'surgery_order_desc_hid\' id=\'surgery_order_desc_hid\' value=\'\'><!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 28/01/2013-->\n\t<input type=\'hidden\' name=\'practid_desc_hid\' id=\'practid_desc_hid\' value=\'\'>\n\t<input type=\'hidden\' name=\'faclity_id\' id=\'faclity_id\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<!--<input type=\'hidden\' name=\'name_prefix_prompt\' id=\'name_prefix_prompt\' value=\"\">-->\n\t<input type=\'hidden\' name=\'appt_ref\' id=\'appt_ref\' value=\"\">\n\t<input type=\'hidden\' name=\'hid_pref_dt\' id=\'hid_pref_dt\' value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t<!--added by kishore on 8/12/2004-->\n\t<input type=\'hidden\' name=\'is_oa_yn\' id=\'is_oa_yn\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t<input type=\'hidden\' name=\'wait_list_ref_no\' id=\'wait_list_ref_no\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t<input type=\'hidden\' name=\'oa_patient_id\' id=\'oa_patient_id\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t<input type=\'hidden\' name=\'oa_patient_name\' id=\'oa_patient_name\' value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t<input type=\'hidden\' name=\'oa_patient_name_loc_lang\' id=\'oa_patient_name_loc_lang\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t<input type=\'hidden\' name=\'oa_spl_code\' id=\'oa_spl_code\' value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t<input type=\'hidden\' name=\'oa_spl_desc\' id=\'oa_spl_desc\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t<input type=\'hidden\' name=\'oa_prct_id\' id=\'oa_prct_id\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t<input type=\'hidden\' name=\'oa_prct_desc\' id=\'oa_prct_desc\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t<input type=\'hidden\' name=\'oa_date_of_birth\' id=\'oa_date_of_birth\' value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t<input type=\'hidden\' name=\'oa_birth_plc\' id=\'oa_birth_plc\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t<input type=\'hidden\' name=\'oa_race_code\' id=\'oa_race_code\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t<input type=\'hidden\' name=\'oa_race_desc\' id=\'oa_race_desc\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t<input type=\'hidden\' name=\'oa_name_prfx\' id=\'oa_name_prfx\' value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\t\n\t<input type=\'hidden\' name=\'oa_gendar\' id=\'oa_gendar\' value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t<input type=\'hidden\' name=\'oa_conutry_code\' id=\'oa_conutry_code\' value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t<input type=\'hidden\' name=\'oa_nationality\' id=\'oa_nationality\' value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t<input type=\'hidden\' name=\'oa_ethic_code\' id=\'oa_ethic_code\' value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t<input type=\'hidden\' name=\'oa_ethic_desc\' id=\'oa_ethic_desc\' value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t<input type=\'hidden\' name=\'oa_family_name\' id=\'oa_family_name\' value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t<input type=\'hidden\' name=\'oa_name_sufx\' id=\'oa_name_sufx\' value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t<input type=\'hidden\' name=\'allowed_booking_type\' id=\'allowed_booking_type\' value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t<input type=\'hidden\' name=\'multi_book_pat_yn\' id=\'multi_book_pat_yn\' value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t<input type=\'hidden\' name=\'Bedcode\' id=\'Bedcode\' value=\"\">\n\t<!--Additional Fields -->\n\t<input type=\'hidden\' name=\'oa_alt_id1\' id=\'oa_alt_id1\' value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t<input type=\'hidden\' name=\'oa_alt_id1_exp_date\' id=\'oa_alt_id1_exp_date\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t<input type=\'hidden\' name=\'oa_alt_id2\' id=\'oa_alt_id2\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t<input type=\'hidden\' name=\'oa_alt_id2_exp_date\' id=\'oa_alt_id2_exp_date\' value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t<input type=\'hidden\' name=\'oa_alt_id3\' id=\'oa_alt_id3\' value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t<input type=\'hidden\' name=\'oa_alt_id3_exp_date\' id=\'oa_alt_id3_exp_date\' value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t<input type=\'hidden\' name=\'oa_alt_id4\' id=\'oa_alt_id4\' value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t<input type=\'hidden\' name=\'oa_alt_id4_exp_date\' id=\'oa_alt_id4_exp_date\' value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t<input type=\'hidden\' name=\'oa_oth_alt_id\' id=\'oa_oth_alt_id\' value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t<input type=\'hidden\' name=\'oa_first_name\' id=\'oa_first_name\' value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t<input type=\'hidden\' name=\'oa_second_name\' id=\'oa_second_name\' value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t<input type=\'hidden\' name=\'oa_third_name\' id=\'oa_third_name\' value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t<input type=\'hidden\' name=\'oa_name_prefix_loc_lang\' id=\'oa_name_prefix_loc_lang\' value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t<input type=\'hidden\' name=\'oa_first_name_loc_lang\' id=\'oa_first_name_loc_lang\' value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t<input type=\'hidden\' name=\'oa_second_name_loc_lang\' id=\'oa_second_name_loc_lang\' value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t<input type=\'hidden\' name=\'oa_third_name_loc_lang\' id=\'oa_third_name_loc_lang\' value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t<input type=\'hidden\' name=\'oa_family_name_loc_lang\' id=\'oa_family_name_loc_lang\' value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t<input type=\'hidden\' name=\'oa_name_suffix_loc_lang\' id=\'oa_name_suffix_loc_lang\' value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\t\n\t<input type=\'hidden\' name=\'oa_oth_alt_id_type\' id=\'oa_oth_alt_id_type\' value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\t\t\n\t<input type=\'hidden\' name=\'oa_years\' id=\'oa_years\' value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\t\t\n\t<input type=\'hidden\' name=\'oa_months\' id=\'oa_months\' value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\t\t\n\t<input type=\'hidden\' name=\'oa_days\' id=\'oa_days\' value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\t\n\t<input type=\'hidden\' name=\'oa_addr_line1\' id=\'oa_addr_line1\' value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\t\n\t<input type=\'hidden\' name=\'oa_addr_line2\' id=\'oa_addr_line2\' value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\t\n\t<input type=\'hidden\' name=\'oa_addr_line3\' id=\'oa_addr_line3\' value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\t\n\t<input type=\'hidden\' name=\'oa_addr_line4\' id=\'oa_addr_line4\' value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\t\n\t<input type=\'hidden\' name=\'oa_res_area_code\' id=\'oa_res_area_code\' value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\t\n\t<input type=\'hidden\' name=\'oa_res_area_desc\' id=\'oa_res_area_desc\' value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\t\n\t<input type=\'hidden\' name=\'oa_res_reg_code\' id=\'oa_res_reg_code\' value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\t\n\t<input type=\'hidden\' name=\'oa_res_reg_desc\' id=\'oa_res_reg_desc\' value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\t\n\t<input type=\'hidden\' name=\'oa_res_town_code\' id=\'oa_res_town_code\' value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\t\n\t<input type=\'hidden\' name=\'oa_res_town_desc\' id=\'oa_res_town_desc\' value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\t\n\t<input type=\'hidden\' name=\'oa_res_country_code\' id=\'oa_res_country_code\' value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\t\n\t<input type=\'hidden\' name=\'oa_res_country_name\' id=\'oa_res_country_name\' value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\t\n\t<input type=\'hidden\' name=\'oa_res_postal_code\' id=\'oa_res_postal_code\' value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\t\n\t<input type=\'hidden\' name=\'oa_email_id\' id=\'oa_email_id\' value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n\t<input type=\'hidden\' name=\'oa_res_tel_no\' id=\'oa_res_tel_no\' value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\t\n\t<input type=\'hidden\' name=\'oa_oth_contact_no\' id=\'oa_oth_contact_no\' value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t<input type=\'hidden\' name=\'oa_res_postal_desc\' id=\'oa_res_postal_desc\' value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_postal_desc\' id=\'oa_mail_postal_desc\' value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">\n\t<input type=\'hidden\' name=\'oa_mail_addr_line1\' id=\'oa_mail_addr_line1\' value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_addr_line2\' id=\'oa_mail_addr_line2\' value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_addr_line3\' id=\'oa_mail_addr_line3\' value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_addr_line4\' id=\'oa_mail_addr_line4\' value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_res_area_code\' id=\'oa_mail_res_area_code\' value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_res_area_desc\' id=\'oa_mail_res_area_desc\' value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_res_reg_code\' id=\'oa_mail_res_reg_code\' value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_res_reg_desc\' id=\'oa_mail_res_reg_desc\' value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_res_town_code\' id=\'oa_mail_res_town_code\' value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_res_town_desc\' id=\'oa_mail_res_town_desc\' value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_res_country_code\' id=\'oa_mail_res_country_code\' value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_res_country_name\' id=\'oa_mail_res_country_name\' value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">\t\n\t<input type=\'hidden\' name=\'oa_mail_res_postal_code\' id=\'oa_mail_res_postal_code\' value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\t\n\t<input type=\'hidden\' name=\'bkg_grace_period\' id=\'bkg_grace_period\' value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\t\n\t<input type=\'hidden\' name=\'maxPatAge\' id=\'maxPatAge\' value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" > \n\t\n\t<script>\n\t\tif(\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\' == \'CA_Task_IP_Booking\')\n\t\t{\n\n\t\t\tdocument.forms[0].referral_id.readOnly= true;\n\t\t\tdocument.forms[0].referral_details.disabled= false;\n\t\t\tcheckPatient(document.forms[0].patient_id);\n\t\t\t\n\t\t\tif(document.forms[0].patient_id.value != \"\")\n\t\t\t\tdocument.forms[0].patient_id.disabled= true;\n\t\t}\n\n\t\tif(\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\' == \'OA_IP_Booking\')\n\t\t{\n\t\t\tcheckPatient(document.forms[0].patient_id);\n\t\t}\n\t\t/*\n\t\tif(\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\' == \'N\')\n\t\t{\n\t\t\tdocument.getElementById(\"bed_detail\").style.visibility=\"hidden\";\n\t\t}\n\t\t\n\t*/\n\t\tif(\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\' == \'N\')\n\t\t{\n\t\t\tdocument.forms[0].patgif.style.visibility=\"visible\";\n\t\t}\n\n\t\tif(\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\' == \'R\')\n\t\t\tdocument.forms[0].ref_img.style.visibility=\"visible\";\n\t\telse\n\t\t\tdocument.forms[0].ref_img.style.visibility=\"hidden\";\n\t</script>\n\n";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t\t<script>\n\t\t\tdocument.forms[0].referral_id.onblur();\n\t\t\tdocument.forms[0].referral_details.disabled = true;\n\t\t\tdocument.forms[0].referral_id.disabled = true;\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t<script>\n\t\tdocument.booking_form.patient_id.disabled = true;\n\t\tdocument.booking_form.search.disabled = true;\n\n\t\tif(document.booking_form.name_prefix1)\n\t\t\tdocument.booking_form.name_prefix1.disabled = true;\n\n\t\tif(document.booking_form.name_prefix)\n\t\t\tdocument.booking_form.name_prefix.disabled = true;\n\n\n\t\tif(document.booking_form.family_name)\n\t\t\tdocument.booking_form.family_name.disabled = true;\n\n\t\tif(document.booking_form.first_name)\n\t\t\tdocument.booking_form.first_name.disabled = true;\n\n\t\tif(document.booking_form.second_name)\n\t\t\tdocument.booking_form.second_name.disabled = true;\n\n\t\tif(document.booking_form.third_name)\n\t\t\tdocument.booking_form.third_name.disabled = true;\n\n\t\tif(document.booking_form.name_suffix1)\n\t\t\tdocument.booking_form.name_suffix1.disabled = true;\n\n\t\tif(document.booking_form.name_suffix)\n\t\t\tdocument.booking_form.name_suffix.disabled = true;\n\n\t\tdocument.booking_form.sex.disabled = true;\n\n\t\tif(document.booking_form.b_birth)\n\t\t\tdocument.booking_form.b_birth.disabled = true;\n\n\t\tdocument.booking_form.b_age.disabled = true;\n\t\tdocument.booking_form.b_months.disabled = true;\n\t\tdocument.booking_form.b_days.disabled = true;\n\t\tdocument.booking_form.date_of_birth.disabled = true;\n\t\tdocument.getElementById(\"dob\").disabled = true;\n\t\tdocument.booking_form.national_id_no.disabled =true;\n\t\tdocument.booking_form.nationality_desc.disabled= true;\n\t\tdocument.booking_form.nationality_id.disabled = true;\n\t\tdocument.booking_form.birth_place.disabled\t= true;\n\t\tdocument.booking_form.place_of_birth.disabled\t= true;\n\t\t//document.booking_form.race_code.disabled = true;\n\t\tif(document.booking_form.race_desc) {\n\t\t\tdocument.booking_form.race_desc.disabled = true;\n\t\t\tdocument.booking_form.race_desc_id.disabled = true;\n\t\t}\n\t\tdocument.booking_form.ethnic_group.disabled = true;\n\t\tdocument.booking_form.citizen_yn[0].disabled = true;\t\t\n\t\tdocument.booking_form.citizen_yn[1].disabled = true;\t\t\n\t\tdocument.booking_form.legal_yn[0].disabled = true;\t\t\n\t\tdocument.booking_form.legal_yn[1].disabled = true;\t\t\n\n\t\tif(document.booking_form.alt_id1_no)\n\t\t\tdocument.booking_form.alt_id1_no.disabled = true;\n\n\t\tif(document.booking_form.alt_id2_no)\n\t\t\tdocument.booking_form.alt_id2_no.disabled = true;\n\n\t\tif(document.booking_form.alt_id3_no)\n\t\t\tdocument.booking_form.alt_id3_no.disabled = true;\n\n\t\tif(document.booking_form.alt_id4_no)\n\t\t\tdocument.booking_form.alt_id4_no.disabled = true;\n\t\t\t\n\t\tif(document.booking_form.alt_id1_exp_date)\n\t\t\tdocument.booking_form.alt_id1_exp_date.disabled = true;\n\n\t\tif(document.booking_form.alt_id2_exp_date)\n\t\t\tdocument.booking_form.alt_id2_exp_date.disabled = true;\n\n\t\tif(document.booking_form.alt_id3_exp_date)\n\t\t\tdocument.booking_form.alt_id3_exp_date.disabled = true;\n\n\t\tif(document.booking_form.alt_id4_exp_date)\n\t\t\tdocument.booking_form.alt_id4_exp_date.disabled = true;\n\n\t\tif(document.booking_form.other_alt_type)\n\t\t\tdocument.booking_form.other_alt_type.disabled = true;\n\n\t\tif(document.booking_form.other_alt_Id)\n\t\t\tdocument.booking_form.other_alt_Id.disabled = true;\n\n\t\tdocument.booking_form.addr_line1.disabled = true;\n\t\tdocument.booking_form.addr_line2.disabled = true;\n\t\tdocument.booking_form.addr_line3.disabled = true;\n\t\tdocument.booking_form.addr_line4.disabled = true;\n\t\tdocument.booking_form.mail_addr_line1.disabled = true;\n\t\tdocument.booking_form.mail_addr_line2.disabled = true;\n\t\tdocument.booking_form.mail_addr_line3.disabled = true;\n\t\tdocument.booking_form.mail_addr_line4.disabled = true;\n\t\tdocument.booking_form.mail_region_desc.readOnly = true; \n\n\n\n\n\tif(document.booking_form.name_prefix_oth != null)\n\t{\n\t\tdocument.booking_form.name_prefix_oth_lang.disabled = true;\n\t}\n\n\n\tif(document.booking_form.first_oth_name_reqd_yn != null)\n\t{\n\t\tdocument.booking_form.first_name_oth_lang.disabled = true;\n\t}\n\n\tif(document.booking_form.second_oth_name_reqd_yn != null)\n\t{\n\t\tdocument.booking_form.second_name_oth_lang.disabled = true;\n\t}\n\n\tif(document.booking_form.third_oth_name_reqd_yn != null)\n\t{\n\t\tdocument.booking_form.third_name_oth_lang.disabled = true;\n\t}\n\n\tif(document.booking_form.family_oth_name_reqd_yn != null)\n\t{\n\t\tdocument.booking_form.family_name_oth_lang.disabled = true;\n\t}\n\n\n\tif(document.booking_form.name_suffix_oth != null)\n\t{\n\t\tdocument.booking_form.name_suffix_oth_lang.disabled = true;\n\t}\n\n\n\n\t</script>\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t   <input type=\'hidden\' name=\'chk_booking_limit_by\' id=\'chk_booking_limit_by\' value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" >\n\t   <input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" >\n\t   <input type=\'hidden\' name=\'sdate2\' id=\'sdate2\' value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\" >\n\t   <input type=\'hidden\' name=\'gifval\' id=\'gifval\' value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" >\n\t   <input type=\'hidden\' name=\'pref_adm_date_hid\' id=\'pref_adm_date_hid\' value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\" >\n\t   <input type=\'hidden\' name=\'unregisteredpatientsbkgyn\' id=\'unregisteredpatientsbkgyn\' value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\"> \n\t   <input type=\'hidden\' name=\'contactvals\' id=\'contactvals\' value=\'\'>\n\t   <input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\'\'>\n\t   <input type=\'hidden\' name=\'source\' id=\'source\' value=\'\'>\n\t   <input type=\'hidden\' name=\'medsergrpcode_hid\' id=\'medsergrpcode_hid\' value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n\t   <input type=\'hidden\' name=\'locale1\' id=\'locale1\' value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n\t   <input type=\'hidden\' name=\'block_bed_based_on\' id=\'block_bed_based_on\' value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\" >\n\t   <input type=\'hidden\' name=\'is_op_pending_referral_booking\' id=\'is_op_pending_referral_booking\' value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">\n\t   <input type=\'hidden\' name=\'physician_code\' id=\'physician_code\' value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'>\n\t   <input type=\'hidden\' name=\'physician_desc\' id=\'physician_desc\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\'>\n\t   <input type=\'hidden\' name=\'ot_medical_service\' id=\'ot_medical_service\' value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'>\n\t   <input type=\'hidden\' name=\'ot_nursing_unit_code\' id=\'ot_nursing_unit_code\' value=\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'>\n\t   <input type=\'hidden\' name=\'ot_nursing_unit_short_desc\' id=\'ot_nursing_unit_short_desc\' value=\'";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\'>\n\t   <!--  billing related variables -->\n\t   <input type=\'hidden\' name=\'package_flag\' id=\'package_flag\' value=\'N\'>\n\t   <input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'\'>\n\t   <input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'>\n\t   <input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\'\'>\n\t   <input type=\'hidden\' name=\'pkg_bill_type\' id=\'pkg_bill_type\' value=\'\'>\n\t   <input type=\'hidden\' name=\'pkg_bill_no\' id=\'pkg_bill_no\' value=\'\'>\n\t   <input type=\"hidden\" name=\"patient_class_id\" id=\"patient_class_id\" value=\"IP\">\n\t   <input type=\'hidden\' name=\'health_card_expired_yn\' id=\'health_card_expired_yn\' value=\'\'>\n\t   <input type=\'hidden\' name=\'Chg_to_Visitor_Grp\' id=\'Chg_to_Visitor_Grp\' value=\'N\'>\n\t   <input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\"> \n\t   <input type=\'hidden\' name=\'bl_future_admn_YN\' id=\'bl_future_admn_YN\' value=\'\'>\n\t   <input type=\'hidden\' name=\'financial_detail_ref_id\' id=\'financial_detail_ref_id\' value=\'\'>\n\t   <input type=\'hidden\' name=\'org_type_ind\' id=\'org_type_ind\' value=\'\'>\n\t   <input type=\'hidden\' name=\'att_practid\' id=\'att_practid\' value=\"\">\n\t   <input type=\'hidden\' name=\'isBlInstalled\' id=\'isBlInstalled\' value=\'";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\'>\n\t   <input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\'N\'>\n\t   <input type=\'hidden\' name=\'insTrackDtlsExists\' id=\'insTrackDtlsExists\' value=\'\'>\n\t   <input type=\'hidden\' name=\'isBlInterfaced\' id=\'isBlInterfaced\' value=\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\'>\n\t   <input type=\'hidden\' name=\'iscapture_fin_dtls_yn\' id=\'iscapture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\'>\n\t   <input type=\'hidden\' name=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'>\n\t   <input type=\'hidden\' name=\'create_booking_with_conf_yn\' id=\'create_booking_with_conf_yn\' value=\'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\'>\n\t   <input type=\'hidden\' name=\'removePatInstruction\' id=\'removePatInstruction\' value=\'\'>\n\t   <input type=\'hidden\' name=\'isReviseBkgAftrConfrmAppl\' id=\'isReviseBkgAftrConfrmAppl\' value=\'";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\'><!--Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622-->\n\t   \n\t \t</form>\n\t</BODY>\n</HTML>\n\n\t";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t\t<script>\n\t\t\n\n\t\tparent.frames[0].document.forms[0].reset.disabled = true;\n\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );


// This method is checking for the null values
private String checkForNull(String inputString)
{
	return ((inputString==null) || (inputString.equals("null")) || (inputString.equals("")))	?	""	:	inputString;
}

// This method is used for populating the contact details
public StringBuffer getContactDetails(String from,String P_fromValue,String appt_ref_no,HttpServletRequest request,JspWriter out,Connection con, String locale, String facilityID) throws Exception
{
	
	PreparedStatement		pstmt			= null ;
	ResultSet				resultSet		= null ;
	String                  fromValue		= P_fromValue;

	String a_res_addr_line1		= "";
	String a_res_addr_line2		= "";
	String a_res_addr_line3		= "";
	String a_res_addr_line4		= "";
	String a_country_code		= "";
	String a_postal_code		= "";
	String a_res_area			= "";
	String a_res_area_code		= "";
	String a_res_town2_code		= "";
	String a_res_town2_desc		= "";
	String a_res_region_code	= "";
	String a_res_region_desc	= "" ;
	String m_res_addr_line1		= "";
	String m_res_addr_line2		= "";
	String m_res_addr_line3		= "";
	String m_res_addr_line4		= "";
	String m_postal_code		= "";
	String m_country_code		= "";
	String m_res_area_code		= "";
	String m_res_area_desc		= "";
	String m_res_town2_code		= "";
	String m_res_town2_desc		= "";
	String m_res_region_code	= "";
	String m_res_region_desc	= "";
	String 	strPrimaryResNo		= "";
	String 	strOtherResNo		= "";
	String 	strEmail			= "";
	StringBuffer contactAddress = new StringBuffer();
	StringBuffer sqlContact		= new StringBuffer();

	if(!appt_ref_no.equals(""))
	{
		//thai - oa_appt
		if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
		sqlContact.append(" select res_addr_line1 addr1_line1, res_addr_line2 addr1_line2, res_addr_line3 addr1_line3, res_addr_line4 addr1_line4, res_town_code, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') res_town, res_area_code, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1')  res_area, res_region_code region_code, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','2') region, country_code country1_code, postal_code postal1_code, mail_addr_line1 addr2_line1, mail_addr_line2 addr2_line2, mail_addr_line3 addr2_line3, mail_addr_line4 addr2_line4, mail_town_code res_town2_code, MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','2') res_town2, mail_area_code res_area2_code, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','2') res_area2, mail_region_code region2_code, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','2') region2_desc, mail_country_code country2_code, mail_postal_code postal2_code, res_tel_no contact1_no, oth_contact_no contact2_no, email_id from OA_APPT WHERE facility_id='"+facilityID+"' and appt_ref_no = ? ");
		fromValue = appt_ref_no;
	}
	else // If its from refferal id then it will search the contact details from pr_refferal_register
	{
		if(from.equals("referral_id"))
		{
			//thai -  chk for address - rest done
			if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
			sqlContact.append(" select addr_line1 addr1_line1, addr_line2 addr1_line2, addr_line3 ddr1_line3, addr_line4 addr1_line4, res_town_code, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') res_town, res_area_code, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') res_area, region_code,  MP_GET_DESC.MP_REGION(region_code,'"+locale+"','2') region, country_code country1_code, postal_code postal1_code, mail_addr_line1 addr2_line1, mail_addr_line2 addr2_line2, mail_addr_line3 addr2_line3, mail_addr_line4 addr2_line4, mail_res_town_code res_town2_code, MP_GET_DESC.MP_RES_TOWN(MAIL_RES_TOWN_CODE,'"+locale+"','2') res_town2, mail_res_area_code res_area2_code, MP_GET_DESC.MP_RES_AREA(MAIL_RES_AREA_CODE,'"+locale+"','2') res_area2, mail_region_code region2_code, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','2') region2_desc, mail_country_code country2_code, mail_postal_code postal2_code, contact1_no, contact2_no, email_id FROM PR_REFERRAL_REGISTER where referral_id = ? ");
		}

		// If its from patient id then it will search the contact details from mp_patient and mp_pat_addresses
		if(from.equals("patient_id"))
		{
			 //thai - chk for address - rest done
			if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
		 	sqlContact.append(" select a.addr1_type, a.addr1_line1, a.addr1_line2, a.addr1_line3, a.addr1_line4, a.postal1_code, a.country1_code, a.contact1_name, a.invalid1_yn, MP_GET_DESC.MP_RES_AREA(b.RES_AREA_CODE,'"+locale+"','1') res_area, b.res_area_code, MP_GET_DESC.MP_RES_TOWN(b.RES_TOWN_CODE,'"+locale+"','2') res_town, b.res_town_code, MP_GET_DESC.MP_REGION(b.REGION_CODE,'"+locale+"','2') region, b.region_code, a.addr2_type, a.addr2_line1, a.addr2_line2, a.addr2_line3, a.addr2_line4, a.postal2_code, a.country2_code, a.contact2_name, a.invalid2_yn, MP_GET_DESC.MP_RES_AREA(a.res_area2_code,'"+locale+"','2')  res_area2, a.res_area2_code, MP_GET_DESC.MP_RES_TOWN(a.res_town2_code,'"+locale+"','2') res_town2, a.res_town2_code, MP_GET_DESC.MP_REGION(a.region2_code,'"+locale+"','2') region2_desc, a.region2_code, b.contact1_no, b.contact2_no, b.email_id from MP_PAT_ADDRESSES a, MP_PATIENT b where b.patient_id = a.patient_id and  b.patient_id = ? ");
		}
	} 

	try 
	{
		con					= ConnectionManager.getConnection(request);
		pstmt               = con.prepareStatement(sqlContact.toString()) ;
		pstmt.setString( 1, fromValue);
		resultSet			= pstmt.executeQuery() ;
		// adition to contact details pop starts here on 2/17/2004...
		if(resultSet != null)
		{
			while(resultSet.next())
			{
				a_res_addr_line1		= checkForNull(resultSet.getString("addr1_line1"));
				a_res_addr_line2		= checkForNull(resultSet.getString("addr1_line2"));
				a_res_addr_line3		= checkForNull(resultSet.getString("addr1_line3"));
				a_res_addr_line4		= checkForNull(resultSet.getString("addr1_line4"));
				a_country_code			= checkForNull(resultSet.getString("country1_code"));
				a_postal_code			= checkForNull(resultSet.getString("postal1_code"));
				a_res_area_code			= checkForNull(resultSet.getString("res_area_code"));
				a_res_area				= checkForNull(resultSet.getString("res_area"));			
				a_res_town2_code		= checkForNull(resultSet.getString("res_town_code"));
				a_res_town2_desc		= checkForNull(resultSet.getString("res_town"));
				a_res_region_code		= checkForNull(resultSet.getString("region_code"));
				a_res_region_desc		= checkForNull(resultSet.getString("region"));			
				m_res_addr_line1		= checkForNull(resultSet.getString("addr2_line1"));
				m_res_addr_line2		= checkForNull(resultSet.getString("addr2_line2"));
				m_res_addr_line3		= checkForNull(resultSet.getString("addr2_line3"));
				m_res_addr_line4		= checkForNull(resultSet.getString("addr2_line4"));
				m_postal_code			= checkForNull(resultSet.getString("postal2_code"));
				m_country_code			= checkForNull(resultSet.getString("country2_code"));
				m_res_area_code			= checkForNull(resultSet.getString("res_area2_code"));
				m_res_area_desc			= checkForNull(resultSet.getString("res_area2"));
				m_res_town2_code		= checkForNull(resultSet.getString("res_town2_code"));
				m_res_town2_desc		= checkForNull(resultSet.getString("res_town2"));
				m_res_region_code		= checkForNull(resultSet.getString("region2_code"));
				m_res_region_desc		= checkForNull(resultSet.getString("region2_desc"));
				strPrimaryResNo			= checkForNull(resultSet.getString("CONTACT1_NO"));
				strOtherResNo			= checkForNull(resultSet.getString("CONTACT2_NO"));
				strEmail				= checkForNull(resultSet.getString("EMAIL_ID"));	
			}
		}
		contactAddress.append(""+"^^");
		contactAddress.append(a_res_addr_line1+"^^");
		contactAddress.append(a_res_addr_line2+"^^");
		contactAddress.append(a_res_addr_line3+"^^");
		contactAddress.append(a_res_addr_line4+"^^");
		contactAddress.append(a_res_town2_code+"^^");
		contactAddress.append(a_res_area_code+"^^");
		contactAddress.append(a_postal_code+"^^");
		contactAddress.append(a_res_region_code+"^^");
		contactAddress.append(a_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(m_res_addr_line1+"^^");
		contactAddress.append(m_res_addr_line2+"^^");
		contactAddress.append(m_res_addr_line3+"^^");
		contactAddress.append(m_res_addr_line4+"^^");
		contactAddress.append(m_res_town2_code+"^^");
		contactAddress.append(m_res_area_code+"^^");
		contactAddress.append(m_postal_code+"^^");
		contactAddress.append(m_res_region_code+"^^");
		contactAddress.append(m_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(strPrimaryResNo+"^^");
		contactAddress.append(strOtherResNo+"^^");
		contactAddress.append(strEmail+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(a_res_town2_desc+"^^");
		contactAddress.append(a_res_area+"^^");
		contactAddress.append(a_res_region_desc+"^^");
		contactAddress.append(m_res_town2_desc+"^^");
		contactAddress.append(m_res_area_desc+"^^");
		contactAddress.append(m_res_region_desc);

	if(pstmt!=null)         pstmt.close();
	if(resultSet!=null)     resultSet.close();

	}catch ( Exception e )
	{
		
		e.printStackTrace() ;
				out.println(e.toString());   
	}
	finally
	{
			ConnectionManager.returnConnection(con,request);
	}
 	return contactAddress;
}	


	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString==null) || (inputString.equals("null")) ? defaultValue : inputString);
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	String	loginUser				= (String)session.getAttribute("login_user");
	StringBuffer sql				= new StringBuffer();
	String	sqlsd2					= "";
	String	DayVal					= ""; 
	String	generatenumyn			= "";
	String	bed_no					= "";
	String	service_code			= "";
	String  service_desc			= "";
	String	old_nursing_unit		= "";
	String	nursing_unit_code		= "";
	String	nursing_unit_short_desc = "";
	String  bed_class_desc			= "";
	String  bed_class_code			= "";
	String  bed_type_desc			= "";
	String  bed_type_code			= "";
	String checkBoxAttribute		= "";
	String medservdesc				= "";
	String medservcode				= "";
	String app_pat_class			= "";
	String sqlsd1					= "";
	String booking_ref_no			= "";
	String  Patient_Id	            = "";
	String  medical_service	        = "";
	String  booking_date_time	    = "";
	String  medical_speciality_desc	= "";
	String  medical_speciality_code	= "";
	String  physician_desc      	= "";
	String  physician_code	        = "";
	String	oper_room_code			= "";
	String oper_room_desc			= "";
	String patient_class			= "";
	String override_yn				= "N";
	String confirm_bkg_auth			= "N";
	String speciality_code			= "";
	String patientid				= "";
	String pref_date				= "";
	String spl_desc					= "";
	String pract_id					= "";
	String pract_name				= "";
	String national_id				= "";
	String name_prfx				= "";
	String patient_name				= "";
	String gender					= "";
	//String date_of_birth			= "";
	String country_code				= "";
	String race_desc				= "";
	String race_code				= "";
	String ethic_code				= "";
	String ethic_desc				= "";
	String birth_place				= "";
	String family_name				= "";
	String name_sufx				= "";
	String locale					= (String)session.getAttribute("LOCALE");
	String facilityID				= (String)session.getAttribute("facility_id");
	String queryString				= (String) session.getAttribute( "queryString" ) ;
	String disabledAttrib			= "disabled";
	String med_hid_val				= "disabled";
	String referral_id				= checkForNull(request.getParameter("referral_id"));
	String is_ca_yn					= checkForNull(request.getParameter("is_ca_yn"));
	String ca_patient_id			= checkForNull(request.getParameter("ca_patient_id"));
	String call_function			= request.getParameter("call_function");
	String oa_patient_id			= request.getParameter("oa_patient_id");
	String is_oa_yn					= checkForNull(request.getParameter("is_oa_yn"));
	String wait_ref_no				= checkForNull(request.getParameter("oa_wait_ref_no"));
	String oa_pref_date				= checkForNull(request.getParameter("oa_pref_date_time"));
	String p_oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String allowed_booking_type		= checkForNull(request.getParameter("allowed_booking_type"));
	String multi_book_pat_yn		= checkForNull(request.getParameter("multi_book_pat_yn"));
	String chk_booking_limit_by		= checkForNull(request.getParameter("chk_booking_limit_by"));
	String Unregpatbkgyn			= checkForNull(request.getParameter("unregistered_patients_bkg_yn"));
	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));	
	String capture_fin_dtls_yn		= checkForNull(request.getParameter("capture_fin_dtls_yn"));	
	String bl_operational			= (String)session.getValue("bl_operational");
	String block_bed_based_on		= checkForNull(request.getParameter("block_bed_based_on"));	
	String is_op_pending_referral_booking = checkForNull(request.getParameter("is_op_pending_referral_booking"));
	String deactivate_pseudo_bed_yn = checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String create_booking_with_conf_yn = checkForNull(request.getParameter("create_booking_with_conf_yn"),"N");
	String bkg_grace_period			= checkForNull(request.getParameter("bkg_grace_period"));
	sqlsd2							= checkForNull(request.getParameter("sqlsd2"));
	sqlsd1							= sqlsd2.substring(0,10);
	
	String	oa_alt_id1				= "";
	String	oa_alt_id1_exp_date		= "";
	String	oa_alt_id2				= "";
	String	oa_alt_id2_exp_date		= "";
	String	oa_alt_id3				= "";
	String	oa_alt_id3_exp_date		= "";
	String	oa_alt_id4				= "";
	String	oa_alt_id4_exp_date		= "";
	String	oa_oth_alt_id			= ""; 
	String	oa_first_name			= "";
	String	oa_second_name			= "";
	String	oa_third_name			= "";
	String	oa_name_prefix_loc_lang	= "";
	String	oa_first_name_loc_lang	= "";
	String	oa_second_name_loc_lang	= "";
	String	oa_third_name_loc_lang	= "";
	String	oa_family_name_loc_lang	= "";
	String	oa_name_suffix_loc_lang	= "";
	String	oa_date_of_birth		= "";
	String	oa_oth_alt_id_type		= "";
	String	oa_years				= "";
	String	oa_months				= "";
	String	oa_days					= "";
	String	oa_patient_name_loc_lang	= "";
	String	oa_addr_line1			= "";
	String	oa_addr_line2			= "";
	String	oa_addr_line3			= "";
	String	oa_addr_line4			= "";
	String	oa_res_area_code		= "";
	String	oa_res_area_desc		= "";
	String	oa_res_reg_code			= "";
	String	oa_res_reg_desc			= "";
	String	oa_res_town_code		= "";
	String	oa_res_town_desc		= "";
	String	oa_res_country_code		= "";
	String	oa_res_country_name		= "";
	String	oa_res_postal_code		= "";
	String	oa_email_id				= "";
	String	oa_res_tel_no			= "";
	String	oa_oth_contact_no		= "";
	String	oa_res_postal_desc		= "";
	String	oa_mail_postal_desc		= "";
	String	oa_mail_addr_line1			= "";
	String	oa_mail_addr_line2			= "";
	String	oa_mail_addr_line3			= "";
	String	oa_mail_addr_line4			= "";
	String	oa_mail_res_area_code		= "";
	String	oa_mail_res_area_desc		= "";
	String	oa_mail_res_reg_code			= "";
	String	oa_mail_res_reg_desc			= "";
	String	oa_mail_res_town_code		= "";
	String	oa_mail_res_town_desc		= "";
	String	oa_mail_res_country_code		= "";
	String	oa_mail_res_country_name		= "";
	String oa_mail_res_postal_code			= "";
	String max_patient_age					= "";
	String PreOpPreparationDays				= "";
	//String booking_type_code				= "";
	//String booking_long_desc				= "";
	/*modification for SRR20056-CRF-0506*/
	ArrayList bookingtype_list				= new ArrayList();	
	//Included for the CRF RUT-CRF-013
	TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");			
	if(patInstructionsMap != null)
	{
		patInstructionsMap.clear();	
		session.setAttribute("ipPatInstructionsMap",patInstructionsMap);
	}

	boolean isBlInterfaced = false;

	if(bl_interfaced_yn.equals("Y"))
		isBlInterfaced = true;
	else 
		isBlInterfaced = false;

	if(call_function==null || call_function.equals("")) 
		call_function="IP_Booking";

	boolean isReviseBkgAftrConfrmAppl = false;

	Connection			con 		= null;
	Statement			stmt		= null;
	PreparedStatement	pstmt		= null;
	ResultSet			rs 			= null;
	ResultSet			prs			= null;
	con		= ConnectionManager.getConnection(request);
	if(call_function.equals("OT"))
	{

		Patient_Id				= checkForNull(request.getParameter("Patient_Id"));
		medical_service			= checkForNull(request.getParameter("medical_service"));
		booking_date_time		= checkForNull(request.getParameter("booking_date_time"));
		medical_speciality_desc	= checkForNull(request.getParameter("medical_speciality_desc"));
		medical_speciality_code	= checkForNull(request.getParameter("medical_speciality_code"));
		physician_desc			= checkForNull(request.getParameter("physician_desc"));
		physician_code			= checkForNull(request.getParameter("physician_code"));
		oper_room_code			= checkForNull(request.getParameter("oper_room_code"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		oper_room_desc			= checkForNull(request.getParameter("oper_room_desc"));
		PreOpPreparationDays	= checkForNull(request.getParameter("PreOpPreparationDays"),"0");
		/*Saturday, June 13, 2009 modified for IN010922 */
		if(patient_class!=null && patient_class.equals("IP"))
		{
			nursing_unit_code		= checkForNull(request.getParameter("nursing_unit_code"));
			//nursing_unit_short_desc	= checkForNull(request.getParameter("nursing_unit_desc"));


			String OT_SQL="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id=? and a.facility_id=? and a.patient_class='IP' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N'  and b.appl_user_id=?  and  a.nursing_unit_code = ? ";


/* 			stmt	= con.createStatement();
			rs		= stmt.executeQuery(OT_SQL.toString()); */
			
			pstmt = con.prepareStatement(OT_SQL);
			pstmt.setString(1, locale);
			pstmt.setString(2, facilityID);
			pstmt.setString(3, loginUser);
			pstmt.setString(4, nursing_unit_code);
			
			rs = pstmt.executeQuery();
        
			if(rs.next())
			{
				nursing_unit_short_desc= checkForNull(rs.getString("description"));			
			} 	

			if(rs	 != null)   rs.close();
			if(pstmt	 != null)   pstmt.close();
	
		}
	
			
	
		

		if(patient_class!=null && patient_class.equals("IP"))
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
		else if(patient_class!=null && patient_class.equals("DC"))
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
		else if(patient_class!=null && patient_class.equals("EM"))
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		else if(patient_class!=null && patient_class.equals("OP"))
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
		else 
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");





	}
 
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" );
	java.util.Date dt	= new java.util.Date();
	String Sdate		= dateFormat.format( dt ) ;
	Sdate				=	Sdate + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
	
	//sql.append("select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual");
	
	try
	{ 

		isReviseBkgAftrConfrmAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","REVISE_BKG_AFTR_CONFIRM");//Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622

		/*
		stmt	= con.createStatement();
		rs		= stmt.executeQuery(sql.toString());
        
		if(rs.next())
		{
			sqlsd2= checkForNull(rs.getString("sdate"));			
		} 	

		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();
		*/
		
		// This query is used for checking whether this operator station have confirmation booking or not..
		/*
		StringBuffer confSql = new StringBuffer();
		confSql.append(" select CREATE_BOOKING_WITH_CONF_YN from AM_OPER_STN where FACILITY_ID = '");
		confSql.append(facilityID);
		confSql.append("' and OPER_STN_ID = '");
		confSql.append(p_oper_stn_id);
		confSql.append("'");
		stmt	= con.createStatement();
		rs = stmt.executeQuery(confSql.toString());
		if (rs.next())
		{
			confirm_bkg_auth = rs.getString("CREATE_BOOKING_WITH_CONF_YN");
		}
		
		if(rs	 != null)   rs.close(); 
		if(stmt	 != null)   stmt.close();
		*/
		if(is_oa_yn.equals("Y"))
		{
			StringBuffer ref_sql = new StringBuffer();
			if(rs	 != null)   rs.close();
			if(stmt	 != null)   stmt.close();
			
			if(ref_sql.length() > 0) ref_sql.delete(0,ref_sql.length());
			
			ref_sql.append("select SPECIALTY_CODE, PATIENT_ID, SPECIALITY_DESC, BOOKING_REF_NO, PRACTITIONER_ID , PRACTITIONER_FULL_NAME, NATIONAL_ID_NO, NAME_SUFFIX, NAME_PREFIX, patient_name, patient_name_loc_lang, GENDER, BIRTH_PLACE_DESC, RES_COUNTRY_CODE, RACE_DESC, RACE_CODE, ETHNIC_GROUP_CODE, ETHNIC_GROUP_DESC, FAMILY_NAME, to_char(preferred_date_time,'dd/mm/rrrr hh24:mi') preferred_date_time, to_char(date_of_birth,'dd/mm/rrrr') date_of_birth ");
			ref_sql.append(" ,calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),1) years,calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),2) months,calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),3) days");
			ref_sql.append(" ,ALT_ID1_NO, to_char(ALT_ID1_EXP_DATE,'dd/mm/rrrr') ALT_ID1_EXP_DATE,ALT_ID2_NO, to_char(ALT_ID2_EXP_DATE,'dd/mm/rrrr') ALT_ID2_EXP_DATE,ALT_ID3_NO, to_char(ALT_ID3_EXP_DATE,'dd/mm/rrrr') ALT_ID3_EXP_DATE,ALT_ID4_NO,  to_char(ALT_ID4_EXP_DATE,'dd/mm/rrrr') ALT_ID4_EXP_DATE,OTH_ALT_ID_NO, OTH_ALT_ID_TYPE"); 		
			ref_sql.append(" ,FIRST_NAME,SECOND_NAME, THIRD_NAME, NAME_PREFIX_LOC_LANG, FIRST_NAME_LOC_LANG, SECOND_NAME_LOC_LANG, THIRD_NAME_LOC_LANG, FAMILY_NAME_LOC_LANG, NAME_SUFFIX_LOC_LANG "); 		

			ref_sql.append(" ,RES_ADDR_LINE1,RES_ADDR_LINE2, RES_ADDR_LINE3, RES_ADDR_LINE4, RES_AREA_CODE, RES_AREA_DESC, RES_REGION_CODE, RES_REGION_DESC, RES_TOWN_CODE, RES_TOWN_DESC,RES_COUNTRY_CODE,RES_COUNTRY_NAME,RES_POSTAL_CODE,	 MAIL_ADDR_LINE1,MAIL_ADDR_LINE2, MAIL_ADDR_LINE3, MAIL_ADDR_LINE4, MAIL_AREA_CODE, MAIL_AREA_DESC, MAIL_REGION_CODE, MAIL_REGION_DESC, MAIL_TOWN_CODE , MAIL_TOWN_DESC,MAIL_COUNTRY_CODE,MAIL_COUNTRY_NAME,MAIL_POSTAL_CODE,EMAIL_ID, RES_TEL_NO, OTH_CONTACT_NO ,MP_GET_DESC.MP_POSTAL_CODE(RES_POSTAL_CODE,?,'2') POSTAL_DESC, MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,?,'2') MAIL_POSTAL_DESC ");
      		
			ref_sql.append(" from PR_WAIT_LIST_VW where facility_id = ? and  wait_list_no=?");

			//out.println("<script>alert(\""+ref_sql.toString()+"\");</script>");

/* 			stmt = con.createStatement();
			rs	 = stmt.executeQuery(ref_sql.toString()); */

			pstmt = con.prepareStatement(ref_sql.toString());
			pstmt.setString(1, localeName);
			pstmt.setString(2, localeName);
			pstmt.setString(3, facilityID);
			pstmt.setString(4, wait_ref_no);
			
			rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				speciality_code	= checkForNull(rs.getString("SPECIALTY_CODE"));
				patientid		= checkForNull(rs.getString("PATIENT_ID"));
				spl_desc		= checkForNull(rs.getString("SPECIALITY_DESC"));
				booking_ref_no	= checkForNull(rs.getString("BOOKING_REF_NO"));
				pract_id		= checkForNull(rs.getString("PRACTITIONER_ID"));
				pract_name		= checkForNull(rs.getString("PRACTITIONER_FULL_NAME"));
				national_id		= checkForNull(rs.getString("NATIONAL_ID_NO"));
				name_sufx		= checkForNull(rs.getString("NAME_SUFFIX"));
				name_prfx		= checkForNull(rs.getString("NAME_PREFIX"));
				patient_name	= checkForNull(rs.getString("PATIENT_NAME"));
				oa_patient_name_loc_lang	= checkForNull(rs.getString("PATIENT_NAME_LOC_LANG"));
				
				gender			= checkForNull(rs.getString("GENDER"));
				birth_place		= checkForNull(rs.getString("BIRTH_PLACE_DESC"));
				country_code	= checkForNull(rs.getString("RES_COUNTRY_CODE"));
				race_desc		= checkForNull(rs.getString("RACE_DESC"));
				race_code		= checkForNull(rs.getString("RACE_CODE"));
				ethic_code		= checkForNull(rs.getString("ETHNIC_GROUP_CODE"));
				ethic_desc		= checkForNull(rs.getString("ETHNIC_GROUP_DESC"));
				family_name		= checkForNull(rs.getString("FAMILY_NAME"));
				oa_date_of_birth= checkForNull(rs.getString("date_of_birth"));
				if(!(oa_date_of_birth==null && oa_date_of_birth.equals("")))
					oa_date_of_birth	=	DateUtils.convertDate(oa_date_of_birth,"DMY","en",locale);
				oa_alt_id1				= checkForNull(rs.getString("ALT_ID1_NO"));
				oa_alt_id1_exp_date		= checkForNull(rs.getString("ALT_ID1_EXP_DATE"));
				if(!(oa_alt_id1_exp_date==null && oa_alt_id1_exp_date.equals("")))
					oa_alt_id1_exp_date	=	DateUtils.convertDate(oa_alt_id1_exp_date,"DMY","en",locale);	
				oa_alt_id2		= checkForNull(rs.getString("ALT_ID2_NO"));
				oa_alt_id2_exp_date		= checkForNull(rs.getString("ALT_ID2_EXP_DATE"));
				if(!(oa_alt_id2_exp_date==null && oa_alt_id2_exp_date.equals("")))
					oa_alt_id2_exp_date	=	DateUtils.convertDate(oa_alt_id2_exp_date,"DMY","en",locale);			
				oa_alt_id3		= checkForNull(rs.getString("ALT_ID3_NO"));
				oa_alt_id3_exp_date		= checkForNull(rs.getString("ALT_ID3_EXP_DATE"));
				if(!(oa_alt_id3_exp_date==null && oa_alt_id3_exp_date.equals("")))
					oa_alt_id3_exp_date	=	DateUtils.convertDate(oa_alt_id3_exp_date,"DMY","en",locale);			
				oa_alt_id4		= checkForNull(rs.getString("ALT_ID4_NO"));
				oa_alt_id4_exp_date		= checkForNull(rs.getString("ALT_ID4_EXP_DATE"));
				if(!(oa_alt_id4_exp_date==null && oa_alt_id4_exp_date.equals("")))
					oa_alt_id4_exp_date	=	DateUtils.convertDate(oa_alt_id4_exp_date,"DMY","en",locale);			
				oa_oth_alt_id			= checkForNull(rs.getString("OTH_ALT_ID_NO")); 
				
				oa_first_name			= checkForNull(rs.getString("FIRST_NAME"));
				oa_second_name			= checkForNull(rs.getString("SECOND_NAME"));
				oa_third_name			= checkForNull(rs.getString("THIRD_NAME"));
				oa_name_prefix_loc_lang	= checkForNull(rs.getString("NAME_PREFIX_LOC_LANG"));
				oa_first_name_loc_lang	= checkForNull(rs.getString("FIRST_NAME_LOC_LANG"));
				oa_second_name_loc_lang	= checkForNull(rs.getString("SECOND_NAME_LOC_LANG"));
				oa_third_name_loc_lang	= checkForNull(rs.getString("THIRD_NAME_LOC_LANG"));
				oa_family_name_loc_lang	= checkForNull(rs.getString("FAMILY_NAME_LOC_LANG"));
				oa_name_suffix_loc_lang	= checkForNull(rs.getString("NAME_SUFFIX_LOC_LANG"));
				oa_oth_alt_id_type		= checkForNull(rs.getString("OTH_ALT_ID_TYPE"));				
				oa_years				= checkForNull(rs.getString("years"));
				oa_months				= checkForNull(rs.getString("months"));
				oa_days					= checkForNull(rs.getString("days")); 
				oa_addr_line1			= checkForNull(rs.getString("RES_ADDR_LINE1"));
				oa_addr_line2			= checkForNull(rs.getString("RES_ADDR_LINE2"));
				oa_addr_line3			= checkForNull(rs.getString("RES_ADDR_LINE3"));
				oa_addr_line4			= checkForNull(rs.getString("RES_ADDR_LINE4"));
				oa_res_area_code		= checkForNull(rs.getString("RES_AREA_CODE"));
				oa_res_area_desc		= checkForNull(rs.getString("RES_AREA_DESC"));
				oa_res_reg_code			= checkForNull(rs.getString("RES_REGION_CODE"));
				oa_res_reg_desc			= checkForNull(rs.getString("RES_REGION_DESC"));
				oa_res_town_code		= checkForNull(rs.getString("RES_TOWN_CODE"));
				oa_res_town_desc		= checkForNull(rs.getString("RES_TOWN_DESC"));
				oa_res_country_code		= checkForNull(rs.getString("RES_COUNTRY_CODE"));
				oa_res_country_name		= checkForNull(rs.getString("RES_COUNTRY_NAME"));
				oa_res_postal_code		= checkForNull(rs.getString("RES_POSTAL_CODE"));
				oa_res_postal_desc		= checkForNull(rs.getString("POSTAL_DESC"));  			
				oa_mail_addr_line1			= checkForNull(rs.getString("MAIL_ADDR_LINE1"));
				oa_mail_addr_line2			= checkForNull(rs.getString("MAIL_ADDR_LINE2"));
				oa_mail_addr_line3			= checkForNull(rs.getString("MAIL_ADDR_LINE3"));
				oa_mail_addr_line4			= checkForNull(rs.getString("MAIL_ADDR_LINE4"));
				oa_mail_res_area_code		= checkForNull(rs.getString("MAIL_AREA_CODE"));
				oa_mail_res_area_desc		= checkForNull(rs.getString("MAIL_AREA_DESC"));
				oa_mail_res_reg_code			= checkForNull(rs.getString("MAIL_REGION_CODE"));
				oa_mail_res_reg_desc			= checkForNull(rs.getString("MAIL_REGION_DESC"));
				oa_mail_res_town_code		= checkForNull(rs.getString("MAIL_TOWN_CODE"));
				oa_mail_res_town_desc		= checkForNull(rs.getString("MAIL_TOWN_DESC"));
				oa_mail_res_country_code		= checkForNull(rs.getString("MAIL_COUNTRY_CODE"));
				oa_mail_res_country_name		= checkForNull(rs.getString("MAIL_COUNTRY_NAME"));
				oa_mail_res_postal_code		= checkForNull(rs.getString("MAIL_POSTAL_CODE"));  
				oa_mail_postal_desc		= checkForNull(rs.getString("MAIL_POSTAL_DESC"));  
				oa_email_id				= checkForNull(rs.getString("EMAIL_ID"));  
				oa_res_tel_no			= checkForNull(rs.getString("RES_TEL_NO"));  
				oa_oth_contact_no		= checkForNull(rs.getString("OTH_CONTACT_NO")); 
					
				
				
			}
			if(rs	 != null)   rs.close();
			if(pstmt	 != null)   pstmt.close();
		}
		
    	/*Added Below Line code for this incident [23474] */
			String language_direction="";
			try{
			int count=0;
		   /*  stmt=con.createStatement(); */
			//preparedStatement pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			
/* 		    rs = stmt.executeQuery("" ) ; */
			
		    pstmt = con.prepareStatement("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID=?");
		    
			pstmt.setString(1, locale);
			rs = pstmt.executeQuery();
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
			
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			
	
	}catch(Exception e1){
	 e1.printStackTrace();
	}
	/*Added Above Line code for incident [23474] */
		
	
		
		

	if(call_function.equals("OA_IP_Booking") && allowed_booking_type.equals("R") && referral_id.equals(""))
	{
		out.println("<script>alert(getMessage('BOOKING_NOT_ALLOWED','IP'));parent.window.close();</script>");
	}

	/*modification for SRR20056-CRF-0506*/
	
	try{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select booking_type_code,ip_get_desc.ip_booking_type(booking_type_code,?,'2')short_desc,(select max_patient_age from mp_param where module_id = 'MP') max_patient_age from ip_booking_type where eff_status = 'E' order by 2");

				pstmt =   con.prepareStatement(sql.toString());	
				pstmt.setString(1,localeName);
				rs   = pstmt.executeQuery();

				if(rs != null)
				{
					while(rs.next())
					{
						bookingtype_list.add(checkForNull(rs.getString(1)));
						bookingtype_list.add(checkForNull(rs.getString(2)));
						max_patient_age = rs.getString("max_patient_age");
					}
				}
				if(rs != null)	rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e)
			{
				
				e.printStackTrace();
			}

		

            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(booking_date_time));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(PreOpPreparationDays));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(PreOpPreparationDays));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(medical_speciality_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(medical_speciality_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(physician_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(physician_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(physician_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(medical_speciality_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(medical_service));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(is_oa_yn.equals("Y")){
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);

		if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y"))
		{ 
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
	
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
if(call_function.equals("OT")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pref_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
if(call_function.equals("OT")){
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
if(is_oa_yn.equals("Y")){
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pref_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sqlsd1));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
if(is_oa_yn.equals("Y")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pref_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(DayVal));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
		if(call_function.equals("OA_IP_Booking"))
		{	
            _bw.write(_wl_block50Bytes, _wl_block50);
		}
		else
		{	
            _bw.write(_wl_block51Bytes, _wl_block51);
if(is_op_pending_referral_booking.equals("Y")){
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
		}	
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
  
			//This query is used for populating the medical service group
			try
			{
			StringBuffer sqlmedserv = new StringBuffer();
			if(sqlmedserv.length() > 0) sqlmedserv.delete(0,sqlmedserv.length());
			sqlmedserv.append(" select distinct IP_GET_DESC.IP_MEDICAL_SERVICE_GROUP(FACILITY_ID,med_ser_grp_code,?,'2') med_ser_grp_short_desc, med_ser_grp_code, generate_num_yn FROM IP_MED_SER_GRP_NURS_UT_TYPE_VW where facility_id = ? and nursing_unit_type_code IN(SELECT DISTINCT nursing_unit_type_code FROM IP_NURSING_UNIT a, am_os_user_locn_access_vw b WHERE a.facility_id = ? AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.locn_code AND b.oper_stn_id = ? AND b.appl_user_id = ? AND b.admit_pat_yn='Y' and a.locn_type=b.locn_type AND 	A.EFF_STATUS='E') AND eff_status = 'E' order by med_ser_grp_short_desc" );
			pstmt	=   con.prepareStatement(sqlmedserv.toString());	
			pstmt.setString(1,locale);
			pstmt.setString(2,facilityID);
			pstmt.setString(3,facilityID);
			pstmt.setString(4,p_oper_stn_id);
			pstmt.setString(5,loginUser);
			rs = pstmt.executeQuery();

			String sel ="";
			if(call_function.equals("OT"))
			{
				while( rs.next() )
				{
					medservdesc   = checkForNull(rs.getString(1));
					medservcode   = checkForNull(rs.getString(2));	
					generatenumyn = checkForNull(rs.getString(3));  
					if(medical_service.equals(medservcode))
			         sel="selected";
					else
					 sel="";

					med_hid_val = medservcode+'#'+generatenumyn+'#'+app_pat_class;
					
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(medservcode+'#'+generatenumyn+'#'+app_pat_class));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(medservdesc));
            _bw.write(_wl_block58Bytes, _wl_block58);
		}
			}
			else
			{
				if( rs != null )
				{
					while( rs.next() )
					{
						medservdesc   = checkForNull(rs.getString(1));
						medservcode   = checkForNull(rs.getString(2));	
						generatenumyn = checkForNull(rs.getString(3));  
						
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( medservcode+'#'+generatenumyn+'#'+app_pat_class ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( medservdesc ));
            _bw.write(_wl_block58Bytes, _wl_block58);
 	        }
				}
			}
			if(pstmt	 != null)   pstmt.close();
			if(rs	 != null)   rs.close();
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
			
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
	if(call_function.equals("CA_Task_IP_Booking"))
			{	
            _bw.write(_wl_block71Bytes, _wl_block71);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(ca_patient_id
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block58Bytes, _wl_block58);
	}else if(call_function.equals("OA_IP_Booking"))
			{	
            _bw.write(_wl_block71Bytes, _wl_block71);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(oa_patient_id
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block58Bytes, _wl_block58);
	}else if(call_function.equals("OT"))
			{	
            _bw.write(_wl_block71Bytes, _wl_block71);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(Patient_Id
                        )},{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("OT")},{ weblogic.utils.StringUtils.valueOf("op_call"), weblogic.utils.StringUtils.valueOf("IP_BOOKING")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block58Bytes, _wl_block58);
	}else{	
            _bw.write(_wl_block72Bytes, _wl_block72);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("op_call"), weblogic.utils.StringUtils.valueOf("IP_BOOKING")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block58Bytes, _wl_block58);
	}	
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
if(call_function.equals("OT")){
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(physician_desc));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(oper_room_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

			for(int i=0;i<bookingtype_list.size();i+=2){
		
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(bookingtype_list.get(i)));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(bookingtype_list.get(i+1)));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block106Bytes, _wl_block106);
if(create_booking_with_conf_yn.equals("Y")){
 /*modified below line code for this incident [23474] */

            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(old_nursing_unit ));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(bed_class_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bed_type_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(disabledAttrib));
            _bw.write(_wl_block124Bytes, _wl_block124);
}
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(create_booking_with_conf_yn));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(override_yn));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(Sdate));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(is_ca_yn));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(Unregpatbkgyn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(oa_pref_date));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(is_oa_yn));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(wait_ref_no));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(oa_patient_name_loc_lang));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(spl_desc));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(oa_date_of_birth));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(birth_place));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(name_prfx));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(national_id));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(ethic_code));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(ethic_desc));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(name_sufx));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(allowed_booking_type));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(multi_book_pat_yn));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(oa_alt_id1));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(oa_alt_id1_exp_date));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(oa_alt_id2));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(oa_alt_id2_exp_date));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(oa_alt_id3));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(oa_alt_id3_exp_date));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(oa_alt_id4));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(oa_alt_id4_exp_date));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(oa_oth_alt_id));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(oa_first_name));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(oa_second_name));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(oa_third_name));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(oa_name_prefix_loc_lang));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(oa_first_name_loc_lang));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(oa_second_name_loc_lang));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(oa_third_name_loc_lang));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(oa_family_name_loc_lang));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(oa_name_suffix_loc_lang));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(oa_oth_alt_id_type));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(oa_years));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(oa_months));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(oa_days));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(oa_addr_line1));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(oa_addr_line2));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(oa_addr_line3));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(oa_addr_line4));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(oa_res_area_code));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(oa_res_area_desc));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(oa_res_reg_code));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(oa_res_reg_desc));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(oa_res_town_code));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(oa_res_town_desc));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(oa_res_country_code));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(oa_res_country_name));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(oa_res_postal_code));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(oa_email_id));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(oa_res_tel_no));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(oa_oth_contact_no));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(oa_res_postal_desc));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(oa_mail_postal_desc));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(oa_mail_addr_line1));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(oa_mail_addr_line2));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(oa_mail_addr_line3));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(oa_mail_addr_line4));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(oa_mail_res_area_code));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(oa_mail_res_area_desc));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(oa_mail_res_reg_code));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(oa_mail_res_reg_desc));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(oa_mail_res_town_code));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(oa_mail_res_town_desc));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(oa_mail_res_country_code));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(oa_mail_res_country_name));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(oa_mail_res_postal_code));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(max_patient_age));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(confirm_bkg_auth));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(Unregpatbkgyn));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(allowed_booking_type));
            _bw.write(_wl_block223Bytes, _wl_block223);

	if(is_op_pending_referral_booking.equals("Y"))
		{
	
            _bw.write(_wl_block224Bytes, _wl_block224);

		}
if(allowed_booking_type.equals("R"))
{	
            _bw.write(_wl_block225Bytes, _wl_block225);
 }

	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (prs != null)  prs.close();
	if (pstmt != null) pstmt.close();
	/*modification for SRR20056-CRF-0506*/
	if ( bookingtype_list != null) bookingtype_list.clear();
}catch(Exception e) 
{
/* 	out.println(e.toString()); */
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(chk_booking_limit_by));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(sqlsd2));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(Unregpatbkgyn));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(booking_date_time));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(Unregpatbkgyn));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(med_hid_val));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(block_bed_based_on));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(is_op_pending_referral_booking));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(physician_code));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(physician_desc));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(medical_service));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(isBlInterfaced));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(isBlInterfaced));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(create_booking_with_conf_yn));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(isReviseBkgAftrConfrmAppl));
            _bw.write(_wl_block248Bytes, _wl_block248);
if(call_function.equals("OT"))
		{
	
            _bw.write(_wl_block249Bytes, _wl_block249);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingAdmissionDetails.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MedicalServiceGroup.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BookingRefNo.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpdaysofStay.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectedDischargeDateTime.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingDetails.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OperatingRoom.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingType.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmittingPractitioner.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ProcedureSurgeryDateTime.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.override.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryOrder.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryDate.label", java.lang.String .class,"key"));
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
}
