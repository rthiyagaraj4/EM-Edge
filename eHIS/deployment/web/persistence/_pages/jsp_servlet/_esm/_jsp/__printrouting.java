package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __printrouting extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/PrintRouting.jsp", 1727962873733L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n<script language=\"JavaScript\">\n\nasync function selectPrinter1(desc,code)\n{\n\tif(desc.value == \"\")\n\t{desc.value=\"\";\n\t code.value=\"\";\n\t  \n\t\n\tif(desc.name==\"printer_id1desc\")\n\t\t {\n\t\tdisableTime1(desc)\n\t\t }else if(desc.name==\"printer_id2desc\")\n\t\t\t {\n\t\t\t disableTime2(desc)\n\t\t\t }else if(desc.name==\"printer_id3desc\")\n\t\t\t {\n\t\t\t disableTime3(desc)\n\t\t\t }\n\treturn ;\n\t}\nawait selectPrinter(desc,code)\n\n}\nasync\tfunction selectPrinter(desc,code)\n\t{\n\t\t\ttar=desc.value\n\t\t\n\t\tvar retVal =    new String();\n\t\tvar argumentArray  = new Array() ;\n\t\tvar dataNameArray  = new Array() ;\n\t\tvar dataValueArray = new Array() ;\n\t\tvar dataTypeArray  = new Array() ;\n\t\tvar tit=getLabel(\'eSM.Printers.label\',\'SM\')\t\n\t\tvar reportclass=document.forms[0].reportclass.value\n\t\t\t\n\t\t\n\t\t\tsql=\"Select printer_id code,printer_name description from sm_printer where eff_status=\'E\' and upper(printer_id) like upper(?) and upper(printer_name) like upper(?) order by 2\";\n\t\n\t\n\t\targumentArray[0] =sql;\n\t\targumentArray[1] = dataNameArray ;\n\t\targumentArray[2] = dataValueArray ;\n\t\targumentArray[3] = dataTypeArray ;\n\t\targumentArray[4] = \"1,2\";\n\t\targumentArray[5] = tar;\n\t\targumentArray[6] = DESC_LINK  ;\n\t\targumentArray[7] = DESC_CODE ;\n\t\tretVal = await CommonLookup( tit, argumentArray );\n\t//\tretArray = await CommonLookup( title, argArray );\t\t\n\tvar ret1=unescape(retVal);\n\t\t \tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t}\n\t\t\n\t\tif(retVal != null && retVal != \"\" )\n\t\t  {\n\t\t\t\n\t\t    var ret1=unescape(retVal);\n\t\t\tarr=ret1.split(\",\");\n\t\t\tdesc.value=arr[1];\n\t\t\tcode.value=arr[0];\n\t\t\t\n\t\t\tif(desc.name==\"printer_id1desc\")\n\t\t\t {\n\t\t\t\tdisableTime1(desc)\n\t\t\t \n\t\t\t }else if(desc.name==\"printer_id2desc\")\n\t\t\t {\n\t\t\t disableTime2(desc)\n\t\t\t }else if(desc.name==\"printer_id3desc\")\n\t\t\t {\n\t\t\t disableTime3(desc)\n\t\t\t }\n\t/*\tif(retVal != null && retVal != \"\" )\n\t\t  {\n\t\t\t\n\t\t  //  var ret1=unescape(retVal);\n\t\t\t//arr=ret1.split(\",\");\n\t\t\t//desc.value=arr[1];\n\t\t\t//code.value=arr[0];\n\t\t\tvar ret1=unescape(retVal);\n\t\t \tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t}\n\t\t\t\n\t\t\tif(desc.name==\"printer_id1desc\")\n\t\t\t {\n\t\t\t\tdisableTime1(desc)\n\t\t\t \n\t\t\t }else if(desc.name==\"printer_id2desc\")\n\t\t\t {\n\t\t\t disableTime2(desc)\n\t\t\t }else if(desc.name==\"printer_id3desc\")\n\t\t\t {\n\t\t\t disableTime3(desc)\n\t\t\t }*/\n\n\t\t\t//desc.blur();\n\t\t\t}else\n\t\t{\n\t\t//desc.value=\"\";\n\t\t//code.value=\"\";\n\t\t\tdesc.value=arr[1];\n\t\t\tcode.value=arr[0];\n\t\t}\n\t\t\t\t\n\t}\nfunction CheckPositiveNumber1(obj)\n\t\t{\tif ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {\t\t\n\t}\n\telse {\n  \t\tif ( obj.value.length > 0 ) {\n  \t\t\talert(getMessage(\'COPY_GR_ZERO\',\'SM\'));\n  \t\t\tobj.select();\n  \t\t\tobj.focus();\n  \t\t}\n  \t}\n}\n\nfunction ChkNumberInput1(fld, e)\n{\n   var strCheck = \'0123456789\';\n\tvar whichCode = (window.Event) ? e.which : e.keyCode;\n\tif (whichCode == 13) return true;  // Enter\n\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n}\n\n\tfunction checkNum(obj) {\n\t\t\tif ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {\t\t\n\t\t\t\tif(obj.value.indexOf(\".\") >= 0)\n\t\t\t\t{\n\t\t\t\t\talert(parent.parent.frames[0].getMessage(\'INVALID_INTEGER\',\'SM\'));\n\t\t\t\t\tobj.select();\n\t\t\t\t\tobj.focus();\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tif ( obj.value.length > 0 ) {\n\t\t\t\t\t\talert(getMessage(\'NUM_ALLOWED\',\'SM\'));\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t\t\t\t}\n\t}\n\nfunction CheckTime(obj) {\n\t  if (obj.value.length>0 )\n\t\t     {\n\t\t\t\tif(ValidateTime(obj)==false) {\n\t\t\t\t\talert(getMessage(\'INVALID_TIME_FMT\',\'SM\'));\n\t\t\t\t\t//obj.select();\n\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\tobj.readOnly=false;\nobj.focus();\n\t\t\t\t  }\n\t\t\t }\n}\nfunction ValidateTime(obj)\n{\n\ttime = obj.value\nif (time.indexOf(\":\") > -1) {\n\tif  (time.length<5) return false;\n\tvar a=  time.split(\":\")\n\tsplithrs=a[0];\n\tsplitmin=a[1]\n\t\n\tif (splithrs >23 || splithrs <0) \n\t\t{\n\t\t\talert(getMessage(\'HR_LESS_TWENTYFOUR\',\'SM\'));\n\t\t\tobj.select();\n\t\t\tobj.focus();\n\t\t}\n\tif (splitmin >59 || splitmin <0) \n\t\t{\n\t\t\talert(getMessage(\'MI_LESS_SIXTY\',\'SM\'));\n\t\t\tobj.select();\n\t\t    obj.focus();\n\t\t}\n\t} else return false;\n\treturn true\n}\n\nfunction disableTime1(obj){\n\t\t\t\tvar fieldval = obj.value;\n\t\t\t\t\n\t\t\t\tif(fieldval != \'\')\n\t\t\t\t{   \n\t\t\t\t\tdocument.forms[0].printer_id2desc.readOnly = false;\n\t\t\t\t\tdocument.forms[0].from_time.readOnly = false;\n\t\t\t\t\tdocument.forms[0].from_time.value = \"\";\n\t\t\t\t\tdocument.forms[0].printer_id2.disabled = false;\n\t\t\t\t\tdocument.forms[0].printer_id3.value = \"\";\n\t\t\t\t\tdocument.forms[0].printer_id3desc.readOnly = true;\n\t\t\t\t\tdocument.forms[0].from_time3.readOnly= true;\n\t\t\t\t    document.forms[0].printer2.disabled = false;\n\t\t\t\t\t// document.forms[0].printer3.disabled = false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\tdocument.forms[0].printer_id2desc.value=\"\";\n\t\t\t\t    document.forms[0].printer_id3desc.value=\"\";\n\t\t\t\t\tdocument.forms[0].from_time.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_time.readOnly=true;\n\t\t\t\t\tdocument.forms[0].from_2time.value=\'\';\n\t\t\t\t\tdocument.forms[0].printer_id2.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_3time.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_3time.readOnly=true;\n\t\t\t\t\tdocument.forms[0].printer_id3.value=\'\';\n\t\t\t\t\tdocument.forms[0].printer_id3.disabled=true;\n\t\t\t\t\tdocument.forms[0].from_2time.readOnly = true;\n\t\t\t\t\tdocument.forms[0].printer_id2.disabled = true;\n\t\t\t\t    document.forms[0].printer_id2desc.readOnly = true;\n\t\t\t\t\tdocument.forms[0].printer2.disabled = true;\n\t\t\t\t\tdocument.forms[0].printer3.disabled = true;\n\t\t\t\t}\n\t\t\t}\n\n\n\t\t\tfunction disableTime2(obj){\n\t\t\t\tvar fieldval = obj.value;\n\t\t\t\t\n\t\t\t\tif(fieldval != \'\')\n\t\t\t\t{document.forms[0].printer_id2desc.disabled=false;\n\t\t\t\t\tdocument.forms[0].from_2time.readOnly = false;\n\t\t\t\t\tdocument.forms[0].from_2time.value = \"\";\n\t\t\t\t\tdocument.forms[0].from_3time.readOnly = false;\n\t\t\t\t\t//document.forms[0].printer_id3.disabled = false;\n\t\t\t\t\tdocument.forms[0].printer_id3desc.readOnly = false;\n\t\t\t\t\tdocument.getElementById(\"printer3\").disabled=false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\tdocument.forms[0].printer_id3desc.value=\"\";\n\t\t\t\t\tdocument.forms[0].from_2time.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_3time.value=\'\';\n\t\t\t\t\tdocument.forms[0].printer_id3.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_2time.readOnly = true;\n\t\t\t\n\t\t\t\t\tdocument.forms[0].from_3time.readOnly = true;\n\t\t\t\t\tdocument.forms[0].printer_id3desc.readOnly = true;\n\t\t\t\t\tdocument.getElementById(\"printer3\").disabled=true;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction disableTime3(obj){\n\t\t\t\tif(obj.value != \'\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].from_3time.readOnly = false;\n\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].from_3time.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_2time.readOnly = true;\n\t\t\t\t\tdocument.forms[0].from_3time.readOnly = true;\n\t\t\t\t}\n\t\t\t}\n\nfunction initialLoad()\n\t\t\t{\n\t\t\t\tif(document.forms[0].printer_id.value!=\"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].printer_id2desc.readOnly = false;\n\t\t\t\t\tdocument.forms[0].printer2.disabled = false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].printer_id2desc.readOnly = true;\n\t\t\t\t\tdocument.forms[0].printer3.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].printer_id2.value!=\"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].printer_id3desc.readOnly = false;\n\t\t\t\t\tdocument.forms[0].printer3.disabled = false;\n\t\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].printer_id3desc.readOnly = true;\n\t\t\t\t\tdocument.forms[0].printer3.disabled = true;\n\t\t\t\t}\n\t\t\t}\n\n\tfunction Pass2MsgFrm(num){\n\n\t\t\t\t\n\t\tif(num==\"one\")\n\t\t\t{\n               if(document.getElementById(\"module_id\").value==\"\")\n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\"printer_id1desc\").value=\"\";\n\t\t\t\tdocument.getElementById(\"printer_id2desc\").value=\"\";\n\t\t\t\tdocument.getElementById(\"printer_id3desc\").value=\"\";\n                document.getElementById(\"printer_id\").value=\"\";\n\t\t\t\tdocument.getElementById(\"printer_id2\").value=\"\";\n\t\t\t\tdocument.getElementById(\"printer_id3\").value=\"\";\n\t\t\t    document.forms[0].printer_id1desc.readOnly = true;\n\t\t\t\tdocument.forms[0].printer1.disabled = true;\n\t\t\t\tdocument.forms[0].printer_id2desc.readOnly = true;\n\t\t\t\tdocument.forms[0].printer2.disabled = true;\n\t\t\t\tdocument.forms[0].printer_id3desc.readOnly = true;\n\t\t\t\tdocument.forms[0].printer3.disabled = true;\n\t\t\t\treturn false;\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"facility_id\").disabled=false;\n\t\t\t\t\tdocument.getElementById(\"dest_locn_code\").disabled=false;\n\t\t\t\t\tdocument.getElementById(\"facimg\").style.visibility=\'visible\';\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\tvar n=parent.document.f_query_add_mod.document.forms[0].report_id.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].report_id.remove(\"report_id\");\n\t\t\t\t}\t\t\n\t\t\n\t\t\t\tvar n1=parent.document.f_query_add_mod.document.forms[0].dest_locn_type.options.length;\n\t\t\t\tfor(var i=0;i<n1;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].dest_locn_type.remove(\"dest_locn_type\");\n\t\t\t\t}\n\n\t\t\t\tvar n2=parent.document.f_query_add_mod.document.forms[0].facility_id.options.length;\n\t\t\t\tfor(var i=0;i<n2;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].facility_id.remove(\"facility_id\");\n\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\tvar n3=parent.document.f_query_add_mod.document.forms[0].dest_locn_code.options.length;\n\t\t\t\tfor(var i=0;i<n3;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].dest_locn_code.remove(\"dest_locn_code\");\n\t\t\t\t}\n\t\t\t\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest()\t;\n\t\t\t\t\t\n\t\t\t    xmlStr =\"<root><SEARCH Chksrc=\\\"\"+num+\"\\\" Common_Text=\\\"\"+document.getElementById(\"module_id\").value+\"\\\" Common_Text1=\\\"\"+document.getElementById(\"report_id\").value+\"\\\" /></root>\"\n \t\t\t    xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\t\t\t\n\t\t\t    xmlHttp.open(\"POST\",\"GetValues.jsp\",false)\n\n\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t    responseText=xmlHttp.responseText\n\t\t\t    responseText = trimString(responseText)\n\t\t\t\n\t\t\t   eval(responseText)\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\t}\n\t\t\telse if (num==\"three\")\n\t\t\t{\n\t\t\t\t\n\t\t\t\tvar n=parent.document.f_query_add_mod.document.forms[0].dest_locn_code.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].dest_locn_code.remove(\"dest_locn_code\");\n\t\t\t\t}\t\t\n\t\t\t\t\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t    xmlStr =\"<root><SEARCH Chksrc=\\\"\"+num+\"\\\" Common_Text=\\\"\"+document.getElementById(\"dest_locn_type\").value+\"\\\" mod_id=\\\"\"+document.getElementById(\"module_id\").value+\"\\\"  Common_Text1=\\\"\"+document.getElementById(\"facility_id\").value+\"#\"+document.getElementById(\"report_id\").value+\"\\\" /></root>\"\n \t\t\t    xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t    xmlHttp.open(\"POST\",\"GetValues.jsp\",false)\n\n\t\t\t    xmlHttp.send(xmlDoc)\n\t\t\t    responseText=xm";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="lHttp.responseText\n\t\t\t    responseText = trimString(responseText)\n\t\t\t\t\n\t\t\t    eval(responseText)\n\t\t\t\t\t\n\t\t\t}\n\t\t\telse if(num==\"five\")\n\t\t\t{\n\t\t\t\tvar n=parent.document.f_query_add_mod.document.forms[0].dflt_report_mode.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t    xmlStr =\"<root><SEARCH Chksrc=\\\"\"+num+\"\\\" Common_Text=\\\"\"+document.getElementById(\"module_id\").value+\"\\\" Common_Text1=\\\"\"+document.getElementById(\"report_id\").value+\"\\\" /></root>\"\n \t\t\t    xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t    xmlHttp.open(\"POST\",\"GetLocnValues.jsp\",false)\n\n\t\t\t    xmlHttp.send(xmlDoc)\n\t\t\t    responseText=xmlHttp.responseText\n\t\t\t    responseText = trimString(responseText)\n\t\t\t    eval(responseText)\n\t\t\t}\n\t\t\telse if(num==\"six\")\n\t\t\t{\n\t\t\t\t\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t    xmlStr =\"<root><SEARCH Chksrc=\\\"\"+num+\"\\\" Common_Text=\\\"\"+document.getElementById(\"dflt_report_mode\").value+\"\\\" Common_Text1=\\\"\"+document.getElementById(\"module_id\").value+\"\\\" Common_Text2=\\\"\"+document.getElementById(\"report_id\").value+\"\\\" /></root>\"\n \t\t\t    xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t    xmlHttp.open(\"POST\",\"GetLocnValues.jsp\",false)\n\n\t\t\t    xmlHttp.send(xmlDoc)\n\t\t\t    responseText=xmlHttp.responseText\n\t\t\t    responseText = trimString(responseText)\n\t\t\t    eval(responseText)\n\t\t\t\t\n\t\t\t}\n\t\t\telse //for two\n\t\t\t{\n\t\t\t\t\t\t\t\t\t\n\t\t\t\tdocument.getElementById(\"printer_id1desc\").value=\"\";\n\t\t\t\tdocument.getElementById(\"printer_id2desc\").value=\"\";\n\t\t\t\tdocument.getElementById(\"printer_id3desc\").value=\"\";\n                document.getElementById(\"printer_id\").value=\"\";\n\t\t\t\tdocument.getElementById(\"printer_id2\").value=\"\";\n\t\t\t\tdocument.getElementById(\"printer_id3\").value=\"\";\n\t\t\t\t\n\t\t\t\tif(document.getElementById(\"report_id\").value==\"\")\n\t\t\t\t{\n\t\t\t\t// Tuesday, February 16, 2010  19357 Venkat S.\n\t\t\t\tdocument.getElementById(\"facility_id\").disabled=false;\n\t\t\t\tvar n=document.forms[0].facility_id.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\tdocument.forms[0].facility_id.remove(\"facility_id\");\n\t\t\t\t}\n\t\t\t    var tp =\"-----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+ \"--------\"\n\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\topt.text=tp;\n\t\t\t\topt.value=\"\";\n\t\t\t\tdocument.forms[0].facility_id.add(opt);\n\t\t\t\t// end \n\t\t\t\tdocument.getElementById(\"printer_id1desc\").readOnly=true\n\t\t\t\tdocument.getElementById(\"printer1\").disabled=true\n\t\t\t\tdocument.getElementById(\"printer_id2desc\").readOnly=true\n\t\t\t\tdocument.getElementById(\"printer2\").disabled=true\n\t\t\t\tdocument.getElementById(\"printer_id3desc\").readOnly=true\n\t\t\t\tdocument.getElementById(\"printer3\").disabled=true\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\"printer_id1desc\").readOnly=false\n\t\t\t\tdocument.getElementById(\"printer1\").disabled=false\n\t\t\t\t/*document.getElementById(\"printer_id2desc\").readOnly=false\n\t\t\t\tdocument.getElementById(\"printer2\").disabled=false\n\t\t\t\tdocument.getElementById(\"printer_id3desc\").readOnly=false\n\t\t\t\tdocument.getElementById(\"printer3\").disabled=false*/\n\t\t\t\t\t}\n\t\t\t\tvar n=parent.document.f_query_add_mod.document.forms[0].dest_locn_type.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].dest_locn_type.remove(\"dest_locn_type\");\n\t\t\t\t}\n\t\t\t\t\n\t\t\t/*\tvar n=parent.document.frames[1].document.forms[0].printer_id.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id.remove(\"printer_id\");\n\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t\tvar n2=parent.document.frames[1].document.forms[0].printer_id2.options.length;\n\t\t\t\tfor(var i=0;i<n2;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id2.remove(\"printer_id2\");\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tvar n3=parent.document.frames[1].document.forms[0].printer_id3.options.length;\n\t\t\t\tfor(var i=0;i<n3;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id3.remove(\"printer_id3\");\n\t\t\t\t}*/\t\n\t\t\t\t\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t    xmlStr =\"<root><SEARCH Chksrc=\\\"\"+num+\"\\\" Common_Text=\\\"\"+document.getElementById(\"module_id\").value+\"\\\" Common_Text1=\\\"\"+document.getElementById(\"report_id\").value+\"\\\" /></root>\"\n \t\t\t    xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t    xmlHttp.open(\"POST\",\"GetValues.jsp\",false)\n\n\t\t\t    xmlHttp.send(xmlDoc)\n\t\t\t    responseText=xmlHttp.responseText\n\t\t\t    responseText = trimString(responseText)\n\t\t\t\t\t\n\t\t\t    eval(responseText)\n\t\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t}\n\t\t\t\n\t}\t\t\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onLoad=\'initialLoad();FocusFirstElement()\' >\n<form name=\"printrouting_form\" id=\"printrouting_form\" action=\"../../servlet/eSM.PrintRoutingServlet\" method=\"post\" target=\"messageFrame\">\n\n<table name=mainTable border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"95%\" align=\'center\'>\n  \t<tr>\n  \t\t<td width=\'25%\'>&nbsp;</td>\n  \t\t<td>&nbsp;</td>\n\t\t<td>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td class=\'fields\' colspan=\"2\"><select name=\"module_id\" id=\"module_id\" onChange=\"Pass2MsgFrm(\'one\')\">\n\t\t<OPTION VALUE=\'\'>&nbsp;&nbsp;---------- ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="----------&nbsp&nbsp;  \t\t\t       \n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t    \t\t    <OPTION VALUE=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t     \t \n\t\t  </select> <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t</tr>\n  <tr>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n  </tr>\n  <tr>\n      <td class=\"label\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n      <td nowrap class=\'fields\' colspan=\"2\"><select name=\"report_id\" id=\"report_id\" onChange=\"Pass2MsgFrm(\'two\')\">\n\t       \t<option value=\"\">-----------------------";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="------------------\n\t \t </select>\n\t    \t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t  </td>\n  </tr>\n <tr>\n \t<td>&nbsp;</td>\n \t<td>&nbsp;</td>\n \t<td>&nbsp;</td>\n </tr>\n\t<tr>\n\t\t<td nowrap class=\"label\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td nowrap class=\'fields\' colspan=\"2\"><select name=\"facility_id\" id=\"facility_id\"  onChange=\"Pass2MsgFrm(\'three\')\">\n\t\t\t\t<OPTION VALUE=\'\'>---------";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="---------\t\n\t\t\t</select>\n\t\t\t<img id=\"facimg\" src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t\t\t\n \n\t\t</td>\n\t</tr>\n\t      ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n   <tr>\n   \t<td>&nbsp;</td>\n   \t<td>&nbsp;</td>\n   \t<td>&nbsp;</td>\n   </tr>\n    <tr>\n\t      <td nowrap class=\"label\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t      <td nowrap class=\'fields\'><select name=\"dest_locn_type\" id=\"dest_locn_type\"  onChange=\"Pass2MsgFrm(\'three\')\">\n\t      <OPTION VALUE=\'\'>-------";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="-------\n\t      </select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t       <td class=\'fields\'><select name=\"dest_locn_code\" id=\"dest_locn_code\">\n\t       <OPTION VALUE=\'\'>-------------";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="-------------\n\t      </select><img id=\"locnimg\" src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t      <input type=\"text\" name=\"dest_locn_code1\" id=\"dest_locn_code1\"  onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\'makeValidString(this)\' size=\"6\" maxlength=\"6\" disabled><img id=\"locnimg1\" src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t       \n\t\t   </td>\n\t\t<script>document.getElementById(\"locnimg1\").style.visibility = \'hidden\';document.getElementById(\"locnimg\").style.visibility = \'hidden\';document.getElementById(\"facimg\").style.visibility = \'visible\';</script>\n  </tr>\n<tr>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n</tr>\n    <tr>\n\t      <td  nowrap class=\"label\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t<td nowrap colspan=\"2\"  class=\'fields\'><input type=\"text\" name=\"ws_no\" id=\"ws_no\" size=\"32\" maxlength=\"30\" onBlur=\'ChangeUpperCase(this)\'onKeyPress=\"return CheckForSpecChars_1(event)\" ></td> <!-- on keypress Method Name Changed against incident Number 30866 on 30-03-2012 by Saanthaakumar-->\n\t\n\t\n    \n  </tr> \n\n<tr>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n</tr> \n  <tr>\n   \t\t<td nowrap class=\"label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n       \t\t<td nowrap colspan=\"2\"  class=\'fields\'><select name=\"dflt_report_mode\" id=\"dflt_report_mode\" >\n \t       \t<option value=\"\">------------ ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="-------------\n \t       \t       \t\n \t \t </select>\n \t    \t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n \t  </td>\n  </tr>\n \n<tr>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n</tr>\n\n  <tr>\n\t      <td nowrap class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t      <td colspan=\"2\" class=\'fields\'><input type=\"text\" name=\"no_of_copies\" id=\"no_of_copies\" size=\"2\" maxlength=\"2\" value=\"1\"   onBlur=\"CheckPositiveNumber1(this)\" onKeyPress=\"return ChkNumberInput1(this,event)\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n  </tr>\n  <tr>\n\t<td colspan=3>&nbsp;</td>\n  </tr>\n</table>\n\n<table name=mainTable1 border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"95%\" align=\'center\'>\n\n\t\t<tr class=\"black\" width=\"100\">\n\t\t\t\t\t<th  align=\'left\' colspan=\'8\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th>\t\t\n\t\t</tr>\n<tr>\n\t<td colspan=7>&nbsp;</td>\n  </tr>\n\n  <tr>\n   \t\t<td  nowrap class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;1</td>\n       \t\t<td colspan=\"4\"  class=\'fields\'><INPUT TYPE=\"text\" name=\"printer_id1desc\" id=\"printer_id1desc\"   onblur=\'selectPrinter1(printer_id1desc,printer_id);return makeValidString(this);\'  readOnly value=\'\' size=60><input type=button class=button value=\'?\' disabled name=\'printer1\' id=\'printer1\' onClick=\'selectPrinter(printer_id1desc,printer_id);\' ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n         \t <!-- <select name=\"printer_id\" id=\"printer_id\" onChange=\'disableTime1(this)\'>\n \t       \t<option value=\"\">-------------------------- Select ---------------------------\n \t \t </select> -->\n \t    \t\n\t\t\t<INPUT TYPE=\"hidden\"   name=\'printer_id\' id=\'printer_id\'>\n\t\t\t</td>\n\t\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t<td class=\'fields\'><input type=\"text\" name=\"from_time\" id=\"from_time\" size=\"5\" onBlur=\'CheckTime(this)\' maxlength=\"5\" >\n\t\t\t</td>\n \t \n  </tr>\n  <tr>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n  </tr>\n  <tr>\n   \t\t<td nowrap class=\"label\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;2</td>\n       \t\t<td colspan=\"4\"  class=\'fields\'><INPUT TYPE=\"text\" name=\"printer_id2desc\" id=\"printer_id2desc\" onblur=\'selectPrinter1(printer_id2desc,printer_id2);return makeValidString(this);\' readOnly value=\'\' size=60><input type=button class=button value=\'?\' disabled name=\'printer2\' id=\'printer2\' onClick=\'selectPrinter(printer_id2desc,printer_id2);\' ><!-- <select name=\"printer_id2\" id=\"printer_id2\"  onChange=\'disableTime2(this)\'>\n \t       \t<option value=\"\">-------------------------- Select ---------------------------\n \t \t </select> -->\n\t\t <INPUT TYPE=\"hidden\"   name=\'printer_id2\' id=\'printer_id2\'>\n\t\t </td>\n\t\t <td class=\'label\' nowrap >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t<td class=\'fields\'><input type=\"text\" name=\"from_2time\" id=\"from_2time\" readonly size=\"5\" onBlur=\'CheckTime(this)\'\t\tmaxlength=\"5\" ></td>\n \t \n  </tr>\n  <tr>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n  \t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n  </tr>\n  <tr>\n   \t\t<td nowrap class=\"label\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;3</td>\n       \t<td colspan=\"4\" class=\'fields\'><INPUT TYPE=\"text\" name=\"printer_id3desc\" id=\"printer_id3desc\"  onblur=\'selectPrinter1(printer_id3desc,printer_id3);return makeValidString(this);\' readOnly value=\'\' size=60 ><input type=button class=button value=\'?\' disabled name=\'printer3\' id=\'printer3\' onClick=\'selectPrinter(printer_id3desc,printer_id3);\' >\n\n\t\t\t<!-- <select name=\"printer_id3\" id=\"printer_id3\" onChange=\'disableTime3(this)\'>\n \t       \t<option value=\"\">-------------------------- Select ---------------------------\n \t \t\t</select> -->\n\t\t\t\n\t\t\t<INPUT TYPE=\"hidden\" name=\'printer_id3\' id=\'printer_id3\' ></td>\n\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t<td class=\'fields\'>\n\t\t\t<input type=\"text\" name=\"from_3time\" id=\"from_3time\" size=\"5\" onBlur=\'CheckTime(this)\' readonly  maxlength=\"5\" >\n\t\t\t</td>\n\n  </tr>\n<tr><td colspan=7 class=label>&nbsp;</td></tr>\n</table>\n<input type=\"hidden\" name=\"checkval\" id=\"checkval\" value=\"two\">\n<input type=\"hidden\" name=\"dst_loc_code\" id=\"dst_loc_code\" value=\"\">\n<input type=\"hidden\" name=\"sys\" id=\"sys\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\n<input type=\"hidden\" name=\"from_time1\" id=\"from_time1\" >\n<input type=\"hidden\" name=\"from_time2\" id=\"from_time2\" >\n<input type=\"hidden\" name=\"from_time3\" id=\"from_time3\" >\n\n<input type=\"hidden\" name=\"function\" id=\"function\" value=\"insert\">\n<input type=\"hidden\" name=\"eff_date_from\" id=\"eff_date_from\" >\n<input type=\"hidden\" name=\"eff_date_to\" id=\"eff_date_to\" >\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t<input type=\'hidden\' name=\'reportclass\' id=\'reportclass\' value=\'\'>\n\t\n\n<input type=\"hidden\" name=\"function1\" id=\"function1\" value=\"insert\">\n\n<input type=\"hidden\" name=\"facilityYN\" id=\"facilityYN\" value=\"N\">\n<input type=\"hidden\" name=\"login_facility\" id=\"login_facility\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\n\n</form>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" \n<!-- Modififcation Against incident number 30866 on 30-03-2012 by Saanthaakumar-->\n<Script>\n\tfunction CheckForSpecChars_1(event){\n    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*-\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n</script>\t\n<!-- Modidifcation Over Here-->\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);



	
	Connection con=null;
	try{
	
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	String facilityId = (String)session.getValue("facility_id");
		
	Statement stmt =con.createStatement();
	ResultSet rs =null;	
	String sdate="";
	
	String sysdate="Select to_char(sysdate,'dd/mm/yyyy')sys from dual ";
	ResultSet rsdate=stmt.executeQuery(sysdate);
	while (rsdate.next())
	sdate=rsdate.getString("sys");

	if( rsdate != null) rsdate.close();

            _bw.write(_wl_block6Bytes, _wl_block6);

          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		    rs = stmt.executeQuery( "Select distinct a.module_id,a.module_name from sm_module a , sm_report b where install_yn='Y' and b.module_id=a.module_id order by module_name");
	
		      if( rs != null )
		       {
		          while( rs.next() )
			    {
			     String moduleid = rs.getString( "module_id" ) ;
				 String modulename = rs.getString("module_name");
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( moduleid ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( modulename ));
            _bw.write(_wl_block13Bytes, _wl_block13);

			    } 
	      		}
	      		rs.close();
	      		stmt.close();
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	         if( stmt != null) stmt.close();
	         if( rs != null) rs.close();
	      
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

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block35Bytes, _wl_block35);


	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
}catch(Exception e){
	out.println(e);
	e.printStackTrace();
	}

finally { 
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Module.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.report.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Destination.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.workstation.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.DefaultReportMode.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.NumberofCopies.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PrinterDetails.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Printer.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Printer.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Printer.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
}
