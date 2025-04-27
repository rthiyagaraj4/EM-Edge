package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __setupoperationtimerangesaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SetupOperationTimeRangesAddModify.jsp", 1732964772000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\" ></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n\t<script language=\'javascript\' src=\'../../eOT/js/SetupOperationTimeRanges.js\'></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\'javascript\'>\nvar RE_NUM = /^\\-?\\d+$/;\nfunction checkForPositiveNumber(obj)\n{\n\t//RE_EXP=/^[1-9]$/\n\t//if(RE_EXP.exec(obj))\nvar object=obj.value;\n\n\tif(isNaN(object)==true)\n\t{\n\t\t//alert(\"Enter a valid no\");\n\t\talert(getMessage(\"INVALID_NEXT_NUMBER\",\"common\"));\n\t   obj.select();\n\t   obj.focus();\n\t   \n\t}\n\tif(object!=\"\" && object<=0 ){\n\t  //alert(\"No. should be > 0\");\n\t  alert(getMessage(\"INVALID_POSITIVE_NUMBER\",\"common\"));\n\t  obj.select();\n\t  obj.focus();\n\t}\n}\n\nfunction checkForSpecCharsforID(event)\n{\n    var strCheck = \'0123456789:\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n/*\nfunction timeValidity(obj) {\n\tvar str_time=obj.value;\n    var dt_date = new Date();\n\tvar arr_time = String(str_time ? str_time : \'\').split(\':\');\n\tif (!arr_time[0]) dt_date.setHours(0);\n\t\n\telse if (RE_NUM.exec(arr_time[0]))\n\t\tif (arr_time[0] < 24) dt_date.setHours(arr_time[0]);\n\t\t\telse return cal_error (\"Invalid hours value: \'\" + arr_time[0] + \"\'.\\nAllowed range is 00-23.\",obj);\n\telse return cal_error (\"Invalid hours value: \'\" + arr_time[0] + \"\'.\\nAllowed format is HH24:MM\",obj);\n\t\t//alert(\"88\");\n\tif (!arr_time[1]) dt_date.setMinutes(0);\n\telse if (RE_NUM.exec(arr_time[1]))\n\t\tif (arr_time[1] < 60) dt_date.setMinutes(arr_time[1]);\n\t\telse return cal_error (\"Invalid minutes value: \'\" + arr_time[1] + \"\'.\\nAllowed range is 00-59.\",obj);\n\telse return cal_error (\"Invalid minutes value: \'\" + arr_time[1] + \"\'.\\nAllowed format is HH24:MM\",obj);\n\treturn true;\n}\n\nfunction cal_error (str_message,obj) {\n\talert (str_message);\n\treturn false;\n}\n*/\nfunction timeCheckBetObjects(objst,objend)\n{\n\t\tvar st_date =  objst.value; \n\t\tvar end_date = objend.value; \n\t\t\n\t\tvar start_date_arr = st_date.split(\':\');\n\t\tvar end_date_arr = end_date.split(\':\');\n\n\t\tvar\tdt_date_start = new Date();\n\t\tvar\tdt_date_end = new Date();\n\n\t\tdt_date_start.setHours(start_date_arr[0]);\n\t\tdt_date_start.setMinutes(start_date_arr[1]);\n\t\tdt_date_end.setHours(end_date_arr[0]);\n\t\tdt_date_end.setMinutes(end_date_arr[1]);\n\t\n       if(start_date_arr[1]>59){\n\t\t\treturn true;\n\t   }else if(dt_date_end > dt_date_start){\n\t\t\treturn true;\n\t   }else if(dt_date_start.length!=5|| dt_date_end.length!=5){\n\t\t\t\treturn true;\n\t\t}else {\n\t\t\treturn false;\n\t\t}\n\t\n}\nfunction chkTime_local(strfromTime){\n\tstrfromTimeVal = strfromTime.value;\n\tstrSplitTime = strfromTimeVal.split(\":\");\n\thr = strSplitTime[0];\n\tmin = strSplitTime[1];\n\tif(strfromTime.value.length !=5)\n\t{\n\t\t//alert(getMessage(\"INVALID_TIME_FMT\",\"CA\"));\n\t\talert(getMessage(\"AM0161\",\"AM\"));// Time in Minutes should be between 0 and 59\n\t\t//strfromTime.select();\n\t\tstrfromTime.value=\"\";\n\t\treturn false;\n\t}\n\tif(hr>23){\n\t\t//alert(getMessage(\"INVALID_TIME_HOUR\"),\"CA\");\n\t\talert(getMessage(\"AM0160\",\"AM\"));//Time in Hours should be between 0 and 23\n\t\t//strfromTime.select();\n\t\tstrfromTime.value = \"\";\n\t\treturn false;\n\t}\n\tif(min>59){\n\t\t//\talert(getMessage(\"INVALID_TIME_MINUTE\",\"CA\"));\n\t\talert(getMessage(\"AM0161\",\"AM\"));\n\t\t//strfromTime.select();\n\t\tstrfromTime.value = \"\";\n\t\t//return false;\n\t\treturn false;\n\t}\n\treturn true;\n}\nfunction TimeCheck(obj,field)\n{   \n\tvar formObj = document.SetupOperationTimeRanges_form;\n\tvar objTrace = null;\n\tvar objId = null;\n\tvar previousObj  = null;\n\teval(\'formObj.slot_\'+field).value=obj.value;\n\tvar flag1=true;\n\tfor (dtCnt=1;dtCnt<=field;dtCnt++ )\n\t{\n\t\tobjTrace = eval(\'this.document.SetupOperationTimeRanges_form.time_slot_\'+dtCnt); \n\t\tobjId = eval(\'this.document.SetupOperationTimeRanges_form.time_slot_id_\'+dtCnt); \n\t\tif(objTrace.value!=null && objTrace.value!=\"\"){\n\t\tif (dtCnt==field ){\n\t\t\tvar flag = chkTime_local(objTrace);// timeValidity(objTrace);\n\t\t}else{\n\t\t    var flag = true;\n\n\t\t}\n\t\t\tif ( flag == true && flag1==true){\n\t\t\t\tif (dtCnt>1){\n\t\t\t\t\tpreviousObj = eval(\'this.document.SetupOperationTimeRanges_form.time_slot_\'+(dtCnt-1)); \n\t\t\t\t\tif(previousObj!=null){\n\t\t\t\t\t\tif (dtCnt==field){\n\t\t\t\t\t\t\tif (timeCheckBetObjects(previousObj,objTrace) == false && flag1==true){\n\t\t\t\t\t\t\t\t//alert(\"if\")\n\t\t\t\t\t\t\t\t//objTrace.select();\t\n\t\t\t\t\t\t\t\talert(getMessage(\"APP-OT0113\",\"OT\"));//This time slot should be greater than the previous time slot\n\t\t\t\t\t\t\t\tobjTrace.focus();\n\t\t\t\t\t\t\t\t//objTrace.select();\n\t\t\t\t\t\t\t\tobjTrace.value = \"\";\n\t\t\t\t\t\t\t\tflag1=false;\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}else{\n\t\t\t\treturn;\n\n\t\t\t}\n\n\t\t}\n\t\t\n\t}\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onload=\"parent.commontoolbarFrame.document.forms[0].apply.disabled=false\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"SetupOperationTimeRanges_form\" id=\"SetupOperationTimeRanges_form\"  onload=\'FocusFirstElement()\' action=\"../../servlet/eOT.SetupOperationTimeRangesServlet\" method=\'post\' target=\"messageFrame\"> \n<br><br><br><br><br><br>\n<table border=0 cellspacing=0 cellpadding=3 width=\'70%\'  align=center>\n<tr>\n\t<td width=\'35%\'></td>\n\t<td width=\'65%\'></td>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</td>\n\t<td class=\'fields\' width=\"25%\" colspan=\"3\">\n\t\t<input type=\"text\" name=\"time_range_code\" id=\"time_range_code\" onkeypress=\"return checkForSpecCharsforID(event);\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" size=4 maxlength=4 ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" onBlur=\"checkForPositiveNumber(this);\">  \n        <img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td> \n</tr>\n\n<tr>\n    <th class=\'columnheader\' width=\"25%\" colspan=\"4\">\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</th>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\"25%\">1</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<!-- <input type=\"text\" name=\"time_slot_1\" id=\"time_slot_1\" id=\'time_slot_id_1\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" size=5 maxlength=5 onBlur=\"if(this.value!=\'\')TimeCheck(this,1);\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ><img src=\'../../eCommon/images/mandatory.gif\'> -->\n\t\t<input type=\"text\" name=\"time_slot_1\" id=\"time_slot_1\" id=\'time_slot_id_1\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" size=5 maxlength=5  onkeypress=\"return checkForSpecCharsforID(event);\" onBlur=\"if(this.value!=\'\')TimeCheck(this,1);\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t<td class=\'label\' width=\"25%\">2</td>\n\t<td class=\'fields\' width=\"25%\" nowrap>\n\t\t<input type=\"text\" name=\"time_slot_2\" id=\"time_slot_2\" id=\'time_slot_id_2\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  size=5 maxlength=5 onkeypress=\"return checkForSpecCharsforID(event);\" onBlur=\"if(this.value!=\'\')TimeCheck(this,2);\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">3</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\"text\" name=\"time_slot_3\" id=\"time_slot_3\" id=\'time_slot_id_3\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" size=5 maxlength=5 onBlur=\"if(this.value!=\'\')TimeCheck(this,3);\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t<td class=\'label\' width=\"25%\">4</td>\n\t<td class=\'fields\' width=\"25%\" nowrap>\n\t\t<input type=\"text\" name=\"time_slot_4\" id=\"time_slot_4\" id=\'time_slot_id_4\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" size=5 maxlength=5 onBlur=\"if(this.value!=\'\')TimeCheck(this,4);\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\t\n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">5</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\"text\" name=\"time_slot_5\" id=\"time_slot_5\" id=\'time_slot_id_5\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" size=5 maxlength=5 onBlur=\"if(this.value!=\'\')TimeCheck(this,5);\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t<td class=\'label\' width=\"25%\">6</td>\n\t<td class=\'fields\' width=\"25%\" nowrap>\n\t\t<input type=\"text\" name=\"time_slot_6\" id=\"time_slot_6\" id=\'time_slot_id_6\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" size=5 maxlength=5 onBlur=\"if(this.value!=\'\')TimeCheck(this,6);\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t\n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">7</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\"text\" name=\"time_slot_7\" id=\"time_slot_7\" id=\'time_slot_id_7\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" size=5 maxlength=5 onBlur=\"if(this.value!=\'\')TimeCheck(this,7);\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" ><img src=\'../../eCommon/images/mandatory.gif\' >\n\t</td>\n\t<td class=\'label\' width=\"25%\">8</td>\n\t<td class=\'fields\' width=\"25%\" nowrap>\n\t\t<input type=\"text\" name=\"time_slot_8\" id=\"time_slot_8\" id=\'time_slot_id_8\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" size=5 maxlength=5 onBlur=\"if(this.value!=\'\')TimeCheck(this,8);\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t\n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">9</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\"text\" name=\"time_slot_9\" id=\"time_slot_9\" id=\'time_slot_id_9\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" size=5 maxlength=5 onBlur=\"if(this.value!=\'\')TimeCheck(this,9);\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t<td class=\'label\' width=\"25%\">10</td>\n\t<td class=\'fields\' width=\"25%\" nowrap>\n\t\t<input type=\"text\" name=\"time_slot_10\" id=\"time_slot_10\" id=\'time_slot_id_10\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" size=5 maxlength=5 onBlur=\"if(this.value!=\'\')TimeCheck(this,10);\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t\n</tr>\n<tr>\n\t<td class=\"label\" width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t</td>\n\t\t<td class=\'fields\' colspan=\"3\">\n\t\t\t<input type=\"checkbox\" name=\"status\" id=\"status\" onClick=\'setCheckValue();\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" >\n\t\t</td>\n\n</tr>\n\n<tr>\n\t<td width=\'35%\'></td>\n\t<td width=\'65%\'></td>\n</tr>\n</table>\n<input type=\"hidden\" name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\"hidden\" name=\'time_range_code1\' id=\'time_range_code1\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\'slot_1\' id=\'slot_1\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\'slot_2\' id=\'slot_2\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\"hidden\" name=\'slot_3\' id=\'slot_3\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\"hidden\" name=\'slot_4\' id=\'slot_4\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=\"hidden\" name=\'slot_5\' id=\'slot_5\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\"hidden\" name=\'slot_6\' id=\'slot_6\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\'slot_7\' id=\'slot_7\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\'slot_8\' id=\'slot_8\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\'slot_9\' id=\'slot_9\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\'slot_10\' id=\'slot_10\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\"hidden\" name=\'curr_date\' id=\'curr_date\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\'disable_flag\' id=\'disable_flag\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\"hidden\" name=\'time_range_code_from_DB\' id=\'time_range_code_from_DB\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con=null;
Connection con1=null;
PreparedStatement stmt=null;
PreparedStatement stmt1=null;
ResultSet rs=null;
ResultSet rs1=null;
String mode=request.getParameter("mode");
String time_range_code = request.getParameter("time_range_code")==null?"":request.getParameter( "time_range_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String time_slot_1="";
String time_slot_2="";
String time_slot_3="";
String time_slot_4="";
String time_slot_5="";
String time_slot_6="";
String time_slot_7="";
String time_slot_8="";
String time_slot_9="";
String time_slot_10="";
String status="";
String sql="";
String time_range_code_disable="";
StringBuffer time_range_code_from_DB=new StringBuffer();

if(mode.equals("modify"))
{
	try{

		con1=ConnectionManager.getConnection(request);
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();
		sql="SELECT TIME_RANGE_CODE,TO_CHAR(TIME_1_SLOT,'HH24:MI'), TO_CHAR(TIME_2_SLOT,'HH24:MI'),TO_CHAR(TIME_3_SLOT,'HH24:MI'), TO_CHAR(TIME_4_SLOT,'HH24:MI'),TO_CHAR(TIME_5_SLOT,'HH24:MI'),TO_CHAR(TIME_6_SLOT,'HH24:MI'),TO_CHAR(TIME_7_SLOT,'HH24:MI'),TO_CHAR(TIME_8_SLOT,'HH24:MI'),TO_CHAR(TIME_9_SLOT,'HH24:MI'),TO_CHAR(TIME_10_SLOT,'HH24:MI'), NVL(STATUS,'E') STATUS FROM  OT_OPER_TIME_RANGE WHERE TIME_RANGE_CODE=?";

		stmt1=con1.prepareStatement(sql);
		stmt1.setString(1,time_range_code);
		rs1=stmt1.executeQuery();
		if(rs1!=null && rs1.next())
		{

			time_slot_1=rs1.getString(2);
			time_slot_2=rs1.getString(3);
			time_slot_3=rs1.getString(4);
			time_slot_4=rs1.getString(5);
			time_slot_5=rs1.getString(6);
			time_slot_6=rs1.getString(7);
			time_slot_7=rs1.getString(8);
			time_slot_8=rs1.getString(9);
			time_slot_9=rs1.getString(10);
			time_slot_10=rs1.getString(11);
			status=rs1.getString(12);			
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			chk_value="E";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
	time_range_code_disable="disabled";	

}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt1!=null) stmt1.close();
			if(rs1!=null)rs1.close();
			if(con1!=null)
			ConnectionManager.returnConnection(con1);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
}else if(mode.equals("insert")){
   
		try{
		con=ConnectionManager.getConnection(request);
		sql="SELECT TIME_RANGE_CODE FROM OT_OPER_TIME_RANGE";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
        		
		while(rs!=null && rs.next())
		{
			time_range_code_from_DB=time_range_code_from_DB.append(",").append(rs.getString(1));
			//out.println("time_range_code_from_DB===="+time_range_code_from_DB);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
	}


            _bw.write(_wl_block9Bytes, _wl_block9);

	PreparedStatement stmt2=null;
	ResultSet rs2=null;
	String curr_date="";

	try{
		con=ConnectionManager.getConnection(request);
		con=ConnectionManager.getConnection(request);
		sql="select '01'||to_char(sysdate,'/mm/yyyy') from dual";
		stmt2=con.prepareStatement(sql);
		rs2=stmt2.executeQuery();

		if(rs2!=null && rs2.next())
		{
			curr_date=rs2.getString(1);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt2!=null) stmt2.close();
			if(rs2!=null)rs2.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(time_range_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(time_range_code_disable));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(time_slot_1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(time_slot_1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(time_slot_2));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(time_slot_3));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(time_slot_4));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(time_slot_5));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(time_slot_6));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(time_slot_7));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(time_slot_8));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(time_slot_9));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(time_slot_10));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chk_value));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(chk_checked));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(time_range_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(time_slot_1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(time_slot_2));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(time_slot_3));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(time_slot_4));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(time_slot_5));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(time_slot_6));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(time_slot_7));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(time_slot_8));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(time_slot_9));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(time_slot_10));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(curr_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(time_range_code_from_DB));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TimeRangeCode.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TimeSlots.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
}
