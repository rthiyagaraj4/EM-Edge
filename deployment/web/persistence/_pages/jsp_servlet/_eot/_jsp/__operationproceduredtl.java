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
import eCommon.Common.CommonBean;
import eOT.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __operationproceduredtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperationProcedureDtl.jsp", 1730888904000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/Booking.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/BookingPatientSearch.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\' ></script>\n\t\t\t<style>\ntextarea {\n  resize: none;\n}\n</style>\n<script language=\'javascript\'>\t\n\nfunction setAllValues(keyData,oper_code,oper_desc,right_left,remarks,duration,avg_time,std_durn,splty_code,fpp_category)\n{\n\tvar frmObj=document.forms[0];\n\tfrmObj.oper_code.value=oper_code;\n\tfrmObj.operation_desc.value=oper_desc;\n\tfrmObj.appl_right_left_flag.value=right_left;\n\tif(right_left==\'R\'||right_left==\'L\'||right_left==\'B\')\n\t{\n\t\t frmObj.appl_right_left_flag.Mandatory=\'Y\';\n\t\t frmObj.appl_right_left_flag.disabled=false;\n\t}\n\telse\n\t{\n\t\t frmObj.appl_right_left_flag.Mandatory=\'N\';\n\t\t frmObj.appl_right_left_flag.disabled=true;\n\t}\n\tfrmObj.operation_desc.disabled=true;\n\tfrmObj.OperationLookUp.disabled=true;\n\tfrmObj.mode.value=\'U\';\n\tfrmObj.key.value=keyData;\n\tfrmObj.remarks.value=remarks;\n\tfrmObj.duration.value=duration;\n\tfrmObj.avgTime.value=avg_time;\n\tfrmObj.f_duration.value=std_durn;\n\tvar arr = std_durn.split(\" \");\n\tif(typeof arr[1]==\"undefined\")\n\t{\n\tfrmObj.stdduration.value=\"\";\n\t}\n\telse\n\t{\n\tfrmObj.stdduration.value=arr[1];\n\t}\n\tfrmObj.speciaitycode.value=splty_code;\n\tfrmObj.fpp_category.value=fpp_category;\n\tfrmObj.remarks.disabled=false;\t\n}\n\nfunction checkForSpecCharsforID(event)\n{\t\n    var strCheck = \'0123456789:\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\treturn (event.keyCode -= 32);\n\treturn true ;\n}\nfunction checkForSpecCharsforID1(event)\n{   \n    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,=+ \';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode); \n    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;  // Not a valid key\n\treturn true ;\n}\n\nfunction CheckChars2(Obj){\n        var str = Obj.value;\n        var specCharsExist = false;\n        for (u=0;u<str.length;u++){\n            if (((str.charCodeAt(u)>=42) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)|| (str.charCodeAt(u)==32)|| (str.charCodeAt(u)==61) || (str.charCodeAt(u)==13) || (str.charCodeAt(u)==10));\n            else{\n                specCharsExist = true;\n                break;\n            }\n        }\n        return specCharsExist;\n    }\n\tfunction CheckChars1(obj)\n\t{ \n\t   var specCharsExist=CheckChars2(obj);\n   \n\t   \n\t   if(specCharsExist==true) \n\t\t{\n\t\t alert(getMessage(\"APP-OT0162\",\"OT\"));\n\t\t\n\t\t  obj.focus();\n\t      return;\n\t\t}\n\t\tcheckLength();\n\t}\nfunction validateDuration(obj){\n\tvar retval=true;\t\n\t\n\tvar duration=obj.value;\n\tvar arr=duration.split(\":\");\n\t\n\tif(duration!=\'\'){\n\tif(duration.length!=\"5\" || arr[0].length!=\"2\"){\n\t\talert(getMessage(\"APP-OT0130\",\"OT\"));\n\t\tobj.select();\n\t\tobj.focus()\n\t\treturn;\n\t    }\n    }\n\tvar RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;\n\tif(obj.value!=\"\" && !RE_EXP.test(obj.value) ){\n\t\tvar err_text=\"\";\n\t    var time = obj.value;\n\t    var arr_time =  time.split(\":\")\n        if(arr_time.length!=2){\n\t\t\tvar retval=cal_error(getMessage(\"VALID_TIME_SLOTS\",\"OT\"),obj);\n\t\t}\n\t\tif(retval==true)\n\t\t{\n\t\tif(arr_time[1]==\'\' || arr_time[0]==\'\'){\n\t\tcal_error(getMessage(\"VALID_TIME_SLOTS\",\"OT\"),obj);\n\t\t}\n\t\t}\n\t\tif(retval==true)\n\t\t{\n\t\tif(arr_time[0]<0 || arr_time[0]>23 ){\n\t\t\terr_text+=getMessage(\"APP-OT0040\",\"OT\");\n\t\t}\n\t\t}\n\t\tif(retval==true)\n\t\t{\n\t\tif(arr_time[1]<0 || arr_time[1]>59 ){\n\t\t\terr_text+=getMessage(\"APP-OT0041\",\"OT\");\n\t\t}\n\t\t}\n\t\tif(err_text.length>0)\t\n\t\t\tvar retval=cal_error(err_text,obj);\n\t}\n\t\n\treturn true\n}\nfunction exceedngTheatreEndtime()\n{  \t\n\t/* Below Code is for Duration should not exceed Theatre End time By Sathish.K on 20-06-2009 against 11538*/\n\t\n    var frmObj=document.forms[0];\n\tvar msgFrm=parent.parent.parent.messageFrame;\n\tvar duration=frmObj.duration.value;\n\tvar arr=duration.split(\":\");\n\tvar end_time=frmObj.end_time.value;\n    var start_time=frmObj.start_time.value;\n    end_time=end_time.split(\":\");\n\tstart_time=start_time.split(\":\");\n\tvar hr=\"\";\n\tvar min=\"\";\n\tvar hrmin=\"\";\n\n\t\n\tvar h2=parseInt(Math.abs(end_time[0]));\n\tvar m2=parseInt(Math.abs(end_time[1]));\n\tvar h1=parseInt(Math.abs(start_time[0]));\n\tvar m1=parseInt(Math.abs(start_time[1]));\n\tvar arr0=parseInt(Math.abs(arr[0]));\n\tvar arr1=parseInt(Math.abs(arr[1]));\n\tvar h=\"\";\n\tvar m=\"\";\n\n    if(m2==m1){\n\t\th=h2-h1;\n\t\tm=0;\n\t}\n\telse if(m2>m1)\n\t{  \n\t\th=h2-h1;\n\t\tm=m2-m1;\n\t}else \n\t{   \n\t\th=h2-h1-1;\n\t\tm=m2-m1+60;\n\t}\n   msg1=getMessage(\"APP-OT0146\",\"OT\");\n  if((parseInt(arr0))>(parseInt(h)))\n\t{\n\t  \n\tmsgFrm.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg1;\n\treturn false;\n\t}\n\telse if((parseInt(arr0))==(parseInt(h)))\n    {   \n\t       \n\t\tif((parseInt(arr1))>(parseInt(m)))\n\t\t{   \n\t\t\tmsgFrm.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg1;\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t{  \n\t\thr=end_time[0]-arr[0];\n\t\tmin=end_time[1]-arr[1];\n\n\t\tif(arr[1]==end_time[1]){\n\t\thr=end_time[0]-arr[0];\n\t\tmin=0;\n\t\t}\n\t\telse if(end_time[1]>arr[1])\n\t\t{  \n\t\thr=end_time[0]-arr[0];\n\t\tmin=end_time[1]-arr[1];\n\t\t}else \n\t\t{   \n\t\thr=end_time[0]-arr[0]-1;\n\t\tmin=end_time[1]-arr[1]+60;\n\t\t}\n\t\t\n\t\thr=parseInt(Math.abs(hr));\n\t\tmin=parseInt(Math.abs(min));\n\t\tif(hr<10)\n\t\t{\n\t\t\thr=\"0\"+hr;\n\t\t}\n\t\tif(min<10)\n\t\t{\n\t\tmin=\"0\"+min;\n\t\t}\n\n\t\thrmin=hr+\":\"+min;\n\t\t\n        frmObj.end_time.value=hrmin;\n\t\treturn true;\n\t\t}\n\t}\n\telse{\n\t\thr=end_time[0]-arr[0];\n\t\tmin=end_time[1]-arr[1];\n\n\t\tif(arr[1]==end_time[1]){\n\t\thr=end_time[0]-arr[0];\n\t\tmin=0;\n\t\t}\n\t\telse if(end_time[1]>arr[1])\n\t\t{  \n\t\thr=end_time[0]-arr[0];\n\t\tmin=end_time[1]-arr[1];\n\t\t}else \n\t\t{   \n\t\thr=end_time[0]-arr[0]-1;\n\t\tmin=end_time[1]-arr[1]+60;\n\t\t}\n\t\t\n\t\tif(parseInt(Math.abs(hr))<10)\n\t\thr=\"0\"+hr;\n\t\tif(parseInt(Math.abs(min))<10)\n\t\tmin=\"0\"+min;\n\n\t\thrmin=hr+\":\"+min;\n        frmObj.end_time.value=hrmin;\n\t\n\t\treturn true;\n\t}\n}\n\n\nfunction cal_error (str_message,obj) {\n\talert (str_message);\n\tobj.focus();\n\tobj.select();\n\treturn;\n}\n\nfunction validate(){\n\tvar obj=document.forms[0];\n\tvar validatStr; \n\tvar dispStr; \n\tvar msgFrm=parent.parent.parent.messageFrame;\n\t//var REG_EXP = /^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/\n\t//Mesg  \n\tvar msg = \"APP0T05-Invalid Duration\";\n\t\n\tvar description =getLabel(\"Common.description.label\",\"Common\");\n\tvar sideApplicable =getLabel(\"eOT.SideApplicable.Label\",\"OT\");\n\tvar duration   =getLabel(\"Common.duration.label\",\"Common\");\n\n\tif(obj.duration.value==\"00:00\"){\n\t\tmsgFrm.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;\n\t\treturn false;\n\t}\n\tif(obj.appl_right_left_flag.Mandatory==\'Y\'){\n\t\t validatStr = new Array(\"operation_desc\",\"appl_right_left_flag\",\"duration\");\n\t\t dispStr    = new Array(description,sideApplicable,duration);\n\t}else{\n\t\tvalidatStr=new Array(\"operation_desc\",\"duration\");\n\t\tdispStr=new Array(description,duration);\n\t\tobj.appl_right_left_flag.value=\"\";\n\t}\n\treturn(validateMandatory(obj,validatStr,dispStr,msgFrm));\n}\n\nfunction setInitialValue(){\t\n\tvar frmObj=document.forms[0];\n\tif(frmObj!=null){\n\t\tvar orderid=frmObj.orderid.value;\n\t\tif(orderid.length>0){\n\t\t\tfrmObj.appl_right_left_flag.disabled=true;\n\t\t\tfrmObj.remarks.disabled=true;\n\t\t}\t \n\t}\n}\n\nfunction makeValidString2(txtObj)\n{\n    /* This function is available in common.js  \n\tTo show proper message  written this function here*/\n\tvar text_value  =   txtObj.value;\n    while(text_value.indexOf(\'\"\')!=-1)\n    {\n        text_value = text_value.replace(\'\"\',\"\'\");\n    }\n    txtObj.value = text_value;\n\n    if(text_value.indexOf(\"&\")==(text_value.length-1))\n    {\n        return false;\n    }\n\n    for(var i=0; i<text_value.length; i++)\n    {\n        if( (text_value.charAt(i)==\'&\')  || (text_value.charAt(i)==\'<\') )\n        {\n            if(text_value.charAt(i+1)!=\' \')\n            {\n                text_value  =   text_value.substring(0,(i+1))+\' \'+ text_value.substring((i+1),text_value.length);\n                i++;\n            }\n        }\n    }\n    txtObj.value = text_value;\n    if(txtObj.value.length>txtObj.maxLength)\n    {\n        //alert(getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null));\n\t\tvar max_len = getMessage(\"MAX_LENGTH_DATA\",\"OT\");\n\t\tvar max_len_msg_arr = max_len.split(\"#\");\n\t\tvar errors = max_len_msg_arr[0]+getLabel(\"Common.operation.label\",\"Common\")+max_len_msg_arr[1]+\" 500 \"+max_len_msg_arr[2];\n\t\talert(errors)\n\n        txtObj.select();\n        txtObj.focus();\n    }\n}\n\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n<body onLoad=\"setInitialValue(); onLoadOperation(); enableProcedudureDtlFields();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<form name=\'dtlForm\' id=\'dtlForm\' method=\'post\' action=\'../../eOT/jsp/OperationProcedureDtl.jsp\'>\n<table border=\'0\' cellpadding=2  cellspacing=\'0\' width=\'99%\'>\n\t<tr> \n\t\t<td class=\'label\' width=\"25%\">\n\t\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\'\'> \n\t\t</td> \n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\n\t\t\t\t<td class=\'fields\' width=\"25%\">\n\t\t\t<input type=\'text\' name=\'operation_desc\' id=\'operation_desc\' size=\'30\'  value=\'\' maxlength=\'30\' readonly  disabled >\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperationLookUp\' id=\'OperationLookUp\' \n\t\t\tonClick=\"funOTCheckDetail1(\'Operation\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\"  disabled >\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<!--Added Against ML-MMOH-CRF-1939-US2...starts-->\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<td class=\'fields\' width=\"25%\">\n\t\t\t<input type=\'text\' name=\'operation_desc\' id=\'operation_desc\' size=\'30\'  value=\'\' maxlength=\'30\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" onBlur=\"if(this.value!=\'\')funOTCheckDetail1(\'Operation\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\" disabled >\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperationLookUp\' id=\'OperationLookUp\' \n\t\t\tonClick=\"funOTCheckDetail1(\'Operation\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\"  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" disabled >\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\" >\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperationLookUp\' id=\'OperationLookUp\' \n\t\t\tonClick=\"funOTCheckDetail1(\'Operation\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t<!--Added Against ML-MMOH-CRF-1939-US2...ends-->\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t\n\t\t<td class=\'label\' width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\">\n\t\t\t<select name=\'appl_right_left_flag\' id=\'appl_right_left_flag\' DB_VALUE=\'\' Mandatory=\'\'>\n\t\t\t<option value=\'\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</option>\n\t\t\t<option value=\'R\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </option>\n\t\t\t<option value=\'L\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" </option>\n\t\t\t<option value=\'B\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </option>\n\t\t\t</select>\n\t\t\t<img name=\'imageflag\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=\'label\' width=\"25%\">\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\'text\' name=\'stdduration\' id=\'stdduration\' size=\'6\'  value=\'\' maxlength=\'6\'  readonly>\n\t\t</td>\n\t\n\t\t<td class=\'label\' width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" \n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\">\n\t\t\t<input type=\'text\' name=\'avgTime\' id=\'avgTime\' size=\'6\'  value=\'\' maxlength=\'6\'  readonly>\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=\'label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\">\n\t\t\t<input type=\'text\' name=\'duration\' id=\'duration\' size=\'6\'  value=\'\' maxlength=\'5\' onkeypress=\"return checkForSpecCharsforID(event);\" OnBlur=\'validateDuration(this)\'>\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>(HH24:mi)\n\t\t</td>\n\t<td class=\'label\'   width=\"25%\"  >\n\t<!-- Modified by Dhanasekar against issue Remarks 29473\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" -->\n\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \n\t\t\t\n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\">\n\t\t\t<textarea rows=\'2\' cols=\'30\' name=\'remarks\'   maxLength=\'500\' Onblur=\"makeValidString2(this);\"></textarea>\n\t\t</td>\n\n\t</tr>\n\n\t<tr>\n\t\t\n\t\t<td width=\"25%\"></td>\n\t\t<td width=\"25%\"></td>\n\t\t<td width=\"25%\"></td>\n\t\t<td width=\"25%\" >\n\t\t\t<input type=\'button\' class=\'button\'  value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' onClick=\'methodSubmit();\'>\n\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onClick=\'funRemoveDtl();\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >\n\t\t</td>\n\t\t<input type=\'hidden\' name=\'fpp_category\' id=\'fpp_category\' value=\'\'>\n\t</tr>\n</table>\n   <!-- added by Rajesh for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t<!-- end -->\n\n<!--<input type=\'hidden\' name=\'duration\' id=\'duration\' value=\'\'>-->\n<input type=\'hidden\' name=\'catalog_code\' id=\'catalog_code\' value=\'\'>\n<input type=\'hidden\' name=\'f_duration\' id=\'f_duration\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'key\' id=\'key\' value=\'\'>\n<input type=\'hidden\' name=\'codeCollect\' id=\'codeCollect\' value=\'\'>\n<input type=\'hidden\' name=\'specialityCollect\' id=\'specialityCollect\' value=\'\'>\n<input type=\'hidden\' name=\'speciaitycode\' id=\'speciaitycode\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' >\n<input type=\'hidden\' name=\'surgeonCode\' id=\'surgeonCode\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'orderid\' id=\'orderid\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'selOrderIds\' id=\'selOrderIds\' id=\'selOrderIds\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'> ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n<input type=\'hidden\' name=\'spltycode\' id=\'spltycode\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'spltycodedesc\' id=\'spltycodedesc\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'strSpecialityYN\' id=\'strSpecialityYN\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\'hidden\' name=\'bill_flag\' id=\'bill_flag\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\'hidden\' name=\'end_time\' id=\'end_time\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\'hidden\' name=\'start_time\' id=\'start_time\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\'hidden\' name=\'book_proc\' id=\'book_proc\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V  -->\n<input type=\'hidden\' name=\'durFromFrame\' id=\'durFromFrame\' value=\"\">\n<input type=\'hidden\' name=\'ot_Param\' id=\'ot_Param\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=\'hidden\' name=\'full_vacant\' id=\'full_vacant\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V  -->\n<input type=\'hidden\' name=\'customerId\' id=\'customerId\' id=\'customerId\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'> <!--  IN050472 -->\n<input type=\'hidden\' name=\'ammendFlag\' id=\'ammendFlag\' id=\'ammendFlag\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'> <!--  186 -->\n <!--Added Against ML-MMOH-CRF-1939-US2...starts-->\n<input type=\'hidden\' name=\'include_fpp_yn\' id=\'include_fpp_yn\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\'hidden\' name=\'isincludefpp\' id=\'isincludefpp\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type=\'hidden\' name=\'count\' id=\'count\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<!--Added Against ML-MMOH-CRF-1939-US2...ends-->\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 String locale = (String)session.getAttribute("LOCALE");
	String params = request.getQueryString(); 
	System.err.println("====params===OperationProcedureDtl==="+params);

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
String end_time=checkForNull(request.getParameter("end_time"));
String start_time=checkForNull(request.getParameter("start_time"));
String facilityid=(String)session.getValue("facility_id");//Added Against ML-MMOH-CRF-1939-US2
String Patient_class = request.getParameter("Patient_class");
String function_id = request.getParameter("function_id");
//out.println("fid = "+function_id);
	Patient_class = (Patient_class == null) ? "":Patient_class;
	//out.println("Pat= "+Patient_class);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	String spltycode="";
	String spltycodedesc="";
	String strSpecialityYN1="";
	String customerId = ""; //IN050472
	String strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));	
	spltycode=checkForNull(request.getParameter("spltycode"));
	spltycodedesc=checkForNull(request.getParameter("spltydesc"));
	strSpecialityYN1=checkForNull(request.getParameter("speciality_access"));
	String strOrderId=checkForNull(request.getParameter("orderid")).intern();
	String selOrderIds = checkForNull(request.getParameter("selOrderIds")); // ChAiTu - 186
	String ammendFlag = checkForNull(request.getParameter("ammendFlag")); // ChAiTu - 186
	System.err.println("====selOrderIds===OperationProcedureDtl==="+selOrderIds);
	System.err.println("====ammendFlag===OperationProcedureDtl==="+ammendFlag);
	String called_from=checkForNull(request.getParameter("called_from")).intern();
	String disable_flag=(strOrderId!="")?"disabled":"";
	String operation_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operation.label","common_labels")+",";
	String bill_flag = request.getParameter("bill_flag");
	System.err.println("====bill_flag===OperationProcedureDtl==="+bill_flag);
	String book_proc = checkForNull(request.getParameter("procedure"));
	
	//Added against ML-MMOH-CRF-1939-US2...starts
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	boolean isIncludeFpp = false;
	String Include_Fpp_yn = null;
	Integer count = 0;
	//Added against ML-MMOH-CRF-1939-US2...starts

	//CRF-004 Authorize Slots for Booking - Rajesh V 
	String fullVacant=checkForNull(request.getParameter("full_vacant"));
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String otParam = "";
	String sqlFacilityChk = "select NVL(SCHEDULE_RESTRICT_YN,'N') facility from OT_PARAM where rownum = 1";
	String sql_sm_report = "select customer_id from SM_SITE_PARAM where rownum = 1";//IN050472
	try
	{
		//Added Against ML-MMOH-CRF-1939-US2...starts
		con = ConnectionManager.getConnection(request);
		Include_Fpp_yn = checkForNull(bean.getIncludeFpp(facilityid));
		System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
		isIncludeFpp = CommonBean.isSiteSpecific(con,"OT","OT_FPP");
		System.err.println("isIncludeFpp --->"+isIncludeFpp);
		//isIncludeFpp = true;
		
		count = bean.getFppIcon();
		
		//Added Against ML-MMOH-CRF-1939-US2...starts
			
		stmt=con.prepareStatement(sqlFacilityChk);
		rs=stmt.executeQuery();
		if(rs !=null && rs.next())
			otParam=checkForNull(rs.getString("facility"));		
		 //IN050472 start
		stmt=null;
		rs=null;
		stmt = con.prepareStatement(sql_sm_report);
		rs = stmt.executeQuery();
		if(rs.next())
			customerId = rs.getString("CUSTOMER_ID");
		 //IN050472 end
	}
	catch(Exception e){
		e.printStackTrace();
		//System.err.println("Error in OperationProcedureDtl.jsp"+e);
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e){
			e.printStackTrace();
			//System.err.println("Error in OperationProcedureDtl.jsp"+e);
		}
	}
	//CRF-004 Authorize Slots for Booking - Rajesh V 

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
if(!book_proc.equals("")){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(operation_title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
if(isIncludeFpp){
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(operation_title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(operation_title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(operation_title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(operation_title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
}}
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(spltycode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(selOrderIds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(spltycode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(spltycodedesc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strSpecialityYN1));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bill_flag));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(book_proc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(otParam));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fullVacant));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(customerId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ammendFlag));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Include_Fpp_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(isIncludeFpp));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SideApplicable.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RightSide.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.LeftSide.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Bilateral.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.StandardDuration.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SurgeonAvgTime.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeComments.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
