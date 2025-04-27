package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import eBL.BLBillDetailsBean;
import eBL.BLMultiBillSettlementBean;
import eBL.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blbillslmtdetirb extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtDetIRB.jsp", 1740492163228L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5_0 ="\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script type=\"text/javascript\">\nfunction checkAlpha(event){\n\tvar strCheck = \'1234567890\';\n\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\tkey = String.fromCharCode(whichCode);  \n\tif (strCheck.indexOf(key) == -1) return false;  \n\treturn true ;\n}\n\nfunction checkForNumber(obj){\n\tif(isNaN(obj.value)){\n\t\talert(getMessage(\'BL8532\',\'BL\'));\n\t\tobj.select();\n\t}\n\telse if(obj.value<0){\n\t\talert(getMessage(\'BL1209\',\'BL\'));\n\t\tobj.select();\n\t}\n}\n\nfunction putDecimal_Text(Obj,maxvalue,deci)\n{\n\tvar temp1=$.trim(Obj.text());\n\tvar temp4=temp1.length;\n\tvar count=parseInt(maxvalue) -parseInt(deci);\n\tif (parseInt(deci) > 0)\n\t{\n\t\tif(temp1.indexOf(\'.\') <0)\n\t\t{\n\t\t\tif (temp4 <= parseInt(maxvalue))\n\t\t\t{\n\t\t\t\tif(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)\n\t\t\t\t{\n\t\t\t\t\tvar temp2=temp1.substring(0,count);\n\t\t\t\t\tvar temp3=temp2+\".\"+temp1.substring(count,temp1.length)\n\t\t\t\t\tif(temp3.length-1 < parseInt(maxvalue))\n\t\t\t\t\t{\n\t\t\t\t\t\tfor(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\ttemp3+=\"0\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tObj.text(temp3);\n\t\t\t\t}\n\t\t\t\telse if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)\n\t\t\t\t{\n\t\t\t\t\tvar temp3=temp1+\'.\';\n\t\t\t\t\tfor(var m=0;m<deci;m++)\n\t\t\t\t\ttemp3+=\"0\";\n\t\t\t\t\tObj.text(temp3);\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif (temp1.length == 0 )\n\t\t\t\t{\n\t\t\t \t\ttemp3=\"0.\";\n\t\t\t\t\tfor(var m=0;m<deci;m++)\n\t\t\t\t\ttemp3+=\"0\";\n\t\t\t\t\tObj.text(temp3);\n\t \n\t\t\t\t}\n   \n \n\t\t\t}\n\n\t\t}else{\n\t\t\tvar temp5=temp1.indexOf(\'.\');\n\t\t\tvar temp7=temp1.substring(0,temp5);\n\t\t\tvar temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));\n\t\t\tvar localTemp=\'\';\n\t\t\tvar len=parseInt(deci)-parseInt(temp6.length);\n\t\t\tfor(var m=0;m<len;m++){\n\t\t\t\tlocalTemp+=\'0\';\n\t\t\t}\n\t\t\tObj.text(temp7+\".\"+temp6+localTemp);\n\t\n\t\t}\n\t}\n}\n\nfunction isValidDateTime(obj){\n\tif(obj.value!=\"\"){\n\t\tvar flag=true;\n\t\tvar RE_NUM =  /^\\/?\\d+$/;\n\t\tvar dateTimeObj = obj.value;\n\t\tvar dateTimeArr = dateTimeObj.split(\" \");\n\t\tif(dateTimeArr.length != 2)  flag=false;\n\t\tvar str_date = dateTimeArr[0];\n\t\tvar str_time = dateTimeArr[1];\n\t\t\n\t\tif(!(checkDt(str_date))){\n\t\t\treturn cal_error (getMessage(\'INVALID_DATE_FMT\',\'SM\'),obj);\n\t\t}\n\t\t\n\t\tif(!(isValidTime(str_time))){\n\t\t\treturn cal_error (getMessage(\'INVALID_DATE_FMT\',\'SM\'),obj);\n\t\t}\n\t}\n\n\treturn true;\n}\n\nfunction isValidTime(time1)\n{\n\tif (time1.value != undefined)\n\t{\n\t\ttime1 = time1.value;\n\t}\n\telse\n\t{\n\t\ttime1=time1;\n\t}\n   time1=trimString(time1); \n   var retval=true;\n   var strCheck = \':0123456789\';\n    for(var i=0;i<=time1.length;i++) {\n        if (strCheck.indexOf(time1.charAt(i)) == -1){\n            retval = false;\n            break;\n        }\n    }\t\t\t\n    if (retval)\n    {\t\t\n       var time1arr=new Array()\n       time1arr=time1.split(\":\")\n            if(time1arr.length==2)\n            {\n                var time1hr=time1arr[0];\n                var time1min=time1arr[1];\n                var time1sec = time1arr[2];\n\t\t\t\tif (time1hr.length != 2 || time1min.length != 2)\n\t\t\t\t{\n\t\t\t\t\t retval=false;\n\t\t\t\t}\n\n                time1hr=eval(time1hr)\n                time1min=eval(time1min)\n\n                if(time1hr<=23)\n                {\n                    if(time1min>59)\n                    {\n                            retval=false;                      \n                    }                   \n                }\n                else\n                        retval=false;\n            }\n            else{\t\t\t\t\t\t\n                retval=false;\n\t\t\t}\n        \n    }\t\t\t\n    return retval;\n}\n\nfunction cal_error (str_message,obj) {\n\talert (str_message);\n\tobj.focus();\n\tobj.select();\n\treturn false;\n}\nfunction callCommonLookupCode(obj, code, sqlSelect, codeDesc, commonCode) {\n\n\t/*parent.frames[1].document.forms[0].stlmt_amount.value=\'\';\n\n\tvar formObj = document.EnterReceiptRefundForm;*/\n\tvar locale = document.forms[0].locale.value;\n\t/*var facility_id = formObj.facility_id.value\n\tvar rcptNatcode = formObj.receipt_nature_code.value;\n\tvar recTypCode= formObj.receipt_type_code.value;\n\tvar patient_id = formObj.patient_id.value;\n\tvar acc_entity_code = \'ZZ\';\n\tvar recpt_refund_ind = formObj.recpt_refund_ind.value;\n\n\tvar rcpt_ip_allowed_yn = formObj.rcpt_ip_allowed_yn.value;\n\n\tvar rcpt_op_allowed_yn = formObj.rcpt_op_allowed_yn.value;\n\n\tvar rcpt_ref_allowed_yn = formObj.rcpt_ref_allowed_yn.value;\n\n\tvar rfnd_ip_allowed_yn = formObj.rfnd_ip_allowed_yn.value;\n\n\tvar rfnd_op_allowed_yn = formObj.rfnd_op_allowed_yn.value;\n\n\tvar rfnd_ref_allowed_yn = formObj.rfnd_ref_allowed_yn.value;\n\n\tvar rfnd_allowed_yn = formObj.rfnd_allowed_yn.value;\n\n\tvar rcpt_allowed_yn = formObj.rcpt_allowed_yn.value;*/\n\n\n\tvar argumentArray = new Array();\n\tvar dataNameArray = new Array();\n\tvar dataValueArray = new Array();\n\tvar dataTypeArray = new Array();\n\tvar sql = \'\';\n\tvar title = \'\';\n\tvar codeval = \'\';\n\tswitch (sqlSelect) {\n\n\t\n\tcase 2: {\n\t\tsql = \"Select code,description from (SELECT A.DOC_TYPE_CODE code ,B.SHORT_DESC description FROM BL_TRN_DOC_TYPE A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND   UPPER(LANGUAGE_ID) = UPPER(\'\"\n\t\t\t\t+ locale\n\t\t\t\t+ \"\') AND A.ACC_ENTITY_CODE = \'ZZ\' and a.operating_facility_id = \'\"\n\t\t\t\t+ facility_id\n\t\t\t\t+ \"\'  and ((a.ENTITY_OR_FACILITY_BASED= \'F\' and substr(a.doc_type_code,1,2)= \'\"\n\t\t\t\t+ facility_id\n\t\t\t\t+ \"\' ) or (a.ENTITY_OR_FACILITY_BASED= \'E\' and  A.ACC_ENTITY_CODE =  \'ZZ\')) AND ((A.TRX_TYPE_CODE = \'5\' AND \'\"\n\t\t\t\t+ recpt_refund_ind\n\t\t\t\t+ \"\' = \'R\' AND (\'\"\n\t\t\t\t+ rcpt_op_allowed_yn\n\t\t\t\t+ \"\' = \'Y\' OR \'\"\n\t\t\t\t+ rcpt_ip_allowed_yn\n\t\t\t\t+ \"\' = \'Y\' OR \'\"\n\t\t\t\t+ rcpt_ref_allowed_yn\n\t\t\t\t+ \"\'  = \'Y\') AND\t\'\"\n\t\t\t\t+ rcpt_allowed_yn\n\t\t\t\t+ \"\' = \'Y\') OR (A.TRX_TYPE_CODE = \'6\' AND \'\"\n\t\t\t\t+ recpt_refund_ind\n\t\t\t\t+ \"\' = \'F\' AND (\'\"\n\t\t\t\t+ rfnd_op_allowed_yn\n\t\t\t\t+ \"\' = \'Y\'  OR \'\"\n\t\t\t\t+ rfnd_ip_allowed_yn\n\t\t\t\t+ \"\' = \'Y\'  OR \'\"\n\t\t\t\t+ rfnd_ref_allowed_yn\n\t\t\t\t+ \"\' = \'Y\') AND \'\"\n\t\t\t\t+ rfnd_allowed_yn\n\t\t\t\t+ \"\' = \'Y\'))) where upper(code) like upper(?)  and upper(description) like upper(?) order by 1\";\n\t\ttitle = \'Document No\';\n\t\tbreak;\n\n\t}\n\tcase 3: {\n\t\tsql = \"Select code,description from (SELECT DISTINCT a.action_reason_code  Code  , a.action_reason_desc description FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND UPPER (language_id) = UPPER (\'\"\n\t\t\t\t+ locale\n\t\t\t\t+ \"\') AND b.action_type = \'DT\'AND NVL (b.active_yn, \'N\') = \'Y\' )  where upper(code) like upper(?)  and upper(description) like upper(?) order by 2\";\n\t\ttitle = \'Reason\';\n\t\tbreak;\n\t}\n\n\t\n\t}\n\n\targumentArray[0] = sql;\n\targumentArray[1] = dataNameArray;\n\targumentArray[2] = dataValueArray;\n\targumentArray[3] = dataTypeArray;\n\tif (codeDesc == \'1\') {\n\t\targumentArray[4] = \"1,2\";\n\t\targumentArray[5] = code.value;\n\t\targumentArray[6] = CODE_LINK;\n\t\targumentArray[7] = CODE_DESC;\n\t} else if (codeDesc == \'2\') {\n\t\targumentArray[4] = \"2,1\";\n\t\targumentArray[5] = obj.value;\n\t\targumentArray[6] = DESC_LINK;\n\t\targumentArray[7] = CODE_DESC;\n\t}\n\treturnedValues = CommonLookup(title, argumentArray);\n\tif ((returnedValues != null) && (returnedValues != \"\")) {\n\t\tobj.value = returnedValues[1];\n\t\tcode.value = returnedValues[0];\n\t\tcodeval = code.value;\n\t} else {\n\t\tobj.value = \'\';\n\t\tcode.value = \'\';\n\t}\n\n\tif (sqlSelect == 1) {\n\t\trectypecheck();\n\t\t//actcode_dep();\n\t\treqidshow(codeval);\n\t\tremark();\n\n\t}\n\tif (sqlSelect == 2) {\n\t\tobj.value = \'\';\n\n\t}\n\tif (sqlSelect == 5) {\n\t\trecref();\n\n\t}\n\n\tif (sqlSelect == 7) {\n\t\t\n\t\tvar check=obj.value;\n\t\tcheck=check.slice(0,-9);\n\t\t\n\t\tparent.frames[1].document.forms[0].stlmt_amount.value=check;\n\t\tparent.frames[1].document.forms[0].reqamount.value=check;\n\t\tobj.value=\'\';\n\t}\n\n\t\t//alert(\"rcptNatcode / sqlSelect :: \"+rcptNatcode +\"/\"+  sqlSelect);\n\t if($(\'#cusid\').val()==\"KDAH\" || ($(\'#cusid\').val()==\"AMS\"))\n\t{\n\t\t\n\t\n\t\n\tif(rcptNatcode==\'MI\'){\n\t//\talert(\"check for spl agency\");\n\t\t\n\t\tif(sqlSelect==1)\n\t\t{\n\t\t\t//alert(\"recTypCode=\"+recTypCode);\n\t\t\trecTypCode=returnedValues[0];\n\t\t\t//alert(\"recTypCode=\"+recTypCode);\n\t\t\t$.ajax({\n\t\t\t\ttype:\"POST\",\n\t\t\t\turl:\"../jsp/SpecialAgenDepCheck.jsp?recTypCode=\"+recTypCode+\"&rcptNatcode=\"+rcptNatcode,\t\t\t\t\t\t\n\t\t\t\tdataType:\"text\",\n\t\t\t\tasync:false,\n\t\t\t\tsuccess: function(data){\n\t\t\t\t\t\t//alert(\"data\"+data);\n\t\t\t\t\t\tvar dataArr = $.trim(data).split(\"::\"); \n\t\t\t\t\t\tvar splAgnDepChk=dataArr[2];\n\t\t\t\t\t//alert(\"splcheck \"+splAgnDepChk);\n\t\t\t\t\tif(splAgnDepChk==\'Y\'){\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(\"#splAgnDep\").show();\n\t\t\t\t\t\tdocument.forms[0].splAgnDepChkYN.value=\'Y\';\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t$(\"#splAgnDep\").hide();\n\t\t\t\t\t\tdocument.forms[0].splAgnDepChkYN.value=\'N\';\n\t\t\t\t\t}\n\t\t\t\t\t//alert(\"splAgnDepChkYN  :::::::\"+document.forms[0].splAgnDepChkYN.value);\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\t error: function(data){\n\t\t\t\t\t alert(\"error:: \"+data);\n\t\t\t     }\n\t\t\t});\n\t\t\n\t\t}\n\t\t\n\t}\n\t\t\t\n\tif(sqlSelect==5)\n\t{\n\t\trcptNatcode=code.value;\n\t\tif(rcptNatcode != \'MI\'){\n\t\t\t\n\t\t\t$(\"#splAgnDep\").hide();\n\t\t}\n\t\telse if(rcptNatcode==\'MI\'){\n\t\t\t\t\t\t\n\t\t\t\t//alert(\"recTypCode=\"+recTypCode);\n\t\t\t\t//alert(\"rcptNatcode=\"+rcptNatcode);\n\t\t\t\t\n\t\t\t\t$.ajax({\n\t\t\t\t\ttype:\"POST\",\n\t\t\t\t\turl:\"../jsp/SpecialAgenDepCheck.jsp?recTypCode=\"+recTypCode+\"&rcptNatcode=\"+rcptNatcode,\t\t\t\t\t\t\n\t\t\t\t\tdataType:\"text\",\n\t\t\t\t\tasync:false,\n\t\t\t\t\tsuccess: function(data){\n\t\t\t\t\t\t//\talert(\"data\"+data);\n\t\t\t\t\t\t\tvar dataArr = $.trim(data).split(\"::\"); \n\t\t\t\t\t\t\tvar splAgnDepChk=dataArr[2];\n\t\t\t\t\t//\talert(\"splcheck \"+splAgnDepChk);\n\t\t\t\t\t\tif(splAgnDepChk==\'Y\'){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t$(\"#splAgnDep\").show();\n\t\t\t\t\t\t\tdocument.forms[0].splAgnDepChkYN.value=\'Y\';\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t$(\"#splAgnDep\").hide();\n\t\t\t\t\t\t\tdocument.forms[0].splAgnDepChkYN.value=\'N\';\n\t\t\t\t\t\t}\n\t\t\t\t\t//\talert(\"splAgnDepChkYN  :::::::\"+document.forms[0].splAgnDepChkYN.value);\n\t\t\t\t\t\t\n\t\t\t\t\t},\n\t\t\t\t\t error: function(data){\n\t\t\t\t\t\t alert(\"error:: \"+data);\n\t\t\t\t     }\n\t\t\t\t});\n\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\n\t}\n\t\t\n}\n\t \n}\nfunction fnClearCode(obj) {\n\tobj.value = \'\';\n}\n</script>\n<script type=\"text/javascript\"> \n$(document).ready(function(){\n\n\t$(\'#trDownTypeEntry\').hide();\n\t\n\t$(\"#downTimeEntry\").change(function(){\n\t\tif ($(this).is(\":checked\"))\n\t\t{\t\t\n\t\t\tif(parseFloat($(\"#billslmtamtdet\").val()) < 0){\n\t\t\t\t$(\'#doc_type_number\').val($(\'#blRefundType\').val());\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#doc_type_number\').val(";
    private final static byte[]  _wl_block5_0Bytes = _getBytes( _wl_block5_0 );

    private final static java.lang.String  _wl_block5_1 ="$(\'#blReceiptType\').val());\n\t\t\t}\n\t\t\t\n\t\t\t$(\"#trDownTypeEntry\").show();\t\t\t\n\t\t}\t\n\t\t\t\t \n\t\telse\n\t\t{\n\t\t\t$(\"#trDownTypeEntry\").hide();\n\t\t}\n\t});\t\n\t\n\tif(parseFloat($(\"#billslmtamtdet\").val()) < 0){\n\t\t$(\'#blRecRefInd\').val(\'F\');\n\t}\n\telse{\n\t\t$(\'#blRecRefInd\').val(\'R\');\n\t}\n\t\n\t $(\"#adjDeposit\").click(async function(){ \n\t\t \t/*Commented below lines for #59527 Rajesh V*/\n\t\t    /*var adjustmentCheck = window.parent.frames[2].document.forms[0].total_records.value;\t\t   \n\t\t    if(adjustmentCheck==0){\t\t*/    \t\n\t\t    \n\t\t\tvar submitBtn = \'Y\';\n\t\t    var totalAmountSettled = parent.frames[3].document.forms[0].total_settled_amt.value;\n\t\t      \t\t\n\t\t\tvar billslmtamtdet = $(\"#billslmtamtdet\").val();  \n\n\t\t\tif(billslmtamtdet<0){\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse{\n\t\t\tif(billslmtamtdet == \'\'){\n\t\t\t\talert(getMessage(\'BL00932\',\'BL\'));\n\t\t    \treturn false;\n\t\t\t}\n\t\t\tif((parseFloat(totalAmountSettled) - parseFloat(billslmtamtdet))>0){\n\t\t\t\tsubmitBtn = \'N\';\n\t\t\t\talert(getMessage(\'BL00933\',\'BL\'));\n\t\t    \treturn false;\n\t\t    }\n\t\t    else if((parseFloat(totalAmountSettled) - parseFloat(billslmtamtdet)) == 0){\n\t\t    \tsubmitBtn = \'N\';\n\t\t    \tvar opnChk = confirm(getMessage(\'BL00934\',\'BL\'));\n\t\t    \tif(!opnChk){\n\t\t    \t\treturn false;\n\t\t    \t}\n\t\t    }\t\t\t\n\t\t\tbillslmtamtdet = parseFloat(billslmtamtdet) - parseFloat(totalAmountSettled);\n\t\t\tvar billpayableamt =  $(\"#billpayableamt\").val(); \n\t\t\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\t\t\tvar strpatientid =   $(\"#strpatientid\").val(); \n\t\t\tvar dialogUrl       = \"../../eBL/jsp/BLBillSlmtServiceDeposit.jsp?submitBtn=\"+submitBtn+\"&billslmtamtdet=\"+billslmtamtdet+\"&patientid=\"+strpatientid+\"&noofdecimal=\"+noofdecimal;\n\t\t\tvar dialogFeatures  =\"dialogHeight:\" + \"49vh\" + \"; dialogWidth:\" + \"50vw\" +\" ; scroll=false; \"+\"status=no\";\n\t\t\tvar returnValue = await window.showModalDialog(dialogUrl,null,dialogFeatures);\n\t\t\t\n\t\t\tif(returnValue != undefined){\n\t\t\t\tvar retValArr = returnValue.split(\":::\");\n\t\t\t\tvar returnVal = parseFloat(totalAmountSettled)+parseFloat(retValArr[0]);\n\t\t\t\t$(\'#depAdjAmt\').val(retValArr[1]);\n\t\t\t\t$(\'#spAdjFrmDep\').text(retValArr[1]);\n\t\t\t\tputDecimal_Text($(\'#spAdjFrmDep\'),17,document.forms[0].noofdecimal.value);\n\t\t\tif(parseFloat(billpayableamt)==parseFloat(returnVal)){\n\t\t\t\t\n\t\t\t\t$(\"#depositAdjustedIndicator\").val(false);\n\t\t\t\t\n\t\t\t\tif($(\"#settleByService\").val()==true){\n\t\t\t\t$(\"#selectServiceList\").show();\t\t\n\t\t\t\t$(\"#serviceCriteriaDiv\").show();\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\t\n\t\t\t\t$(\"#depositAdjustedIndicator\").val(true);\n\t\t\t\t\n\t\t\t\tif($(\"#settleByService\").val()==true){\n\t\t\t\t$(\"#selectServiceList\").hide();\n\t\t\t\t$(\"#serviceCriteriaDiv\").hide();\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tif(returnValue!=\'N\'){\n\t\t\t\t$(\'#slmtAmtAfterDep\').val(returnVal);\n\t\t\t\t$(\"#billslmtamtdet\").val(returnVal);\n\t\t\tputdeci(document.forms[0].billslmtamtdet);\n\t\t\t$(\"#billslmtamtdet\").prop(\'disabled\',true);\n\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t\t\n\t\t   /* }else{\n\t\t    \talert(\"Payment Already Processed So Cannot Adjust Deposit\")\n\t\t    }*/\n\n\t\t\t\n\t  });\n\t \n\t $(\'#clearDeposit\').click(function(){\n\t\t var params = \"calledFrom=clearDepositAdjustments\";\n\t\t $.ajax({\n\t\t\t\ttype:\"GET\",\n\t\t\t\turl:\"../jsp/BillReceiptAjax.jsp\",\n\t\t\t\tdata:params,\n\t\t\t\tdataType:\"text\",\n\t\t\t\tasync:false,\n\t\t\t\tsuccess: function(data){\n\t\t\t\t\tif($(\'#slmtAlreadyDisabled\').val() == \'N\'){\n\t\t\t\t\t\t$(\"#billslmtamtdet\").prop(\'disabled\',false);\n\t\t\t\t\t}\t\t\t\t\n\n\t\t\t\t\t$(\"#billslmtamtdet\").val($(\"#billpayableamt\").val());\n\t\t\t\t\t$(\'#spAdjFrmDep\').text(0);\n\t\t\t\t\tputDecimal_Text($(\'#spAdjFrmDep\'),17,document.forms[0].noofdecimal.value);\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\t error: function(data){\n\t\t\t\t\t alert(data)\n\t\t\t     }\n\t\t});\n\t });\n\t \n\t $(\"#billList\").click(function(){ \n\t\t\tvar dialogUrl       = \"../../eBL/jsp/BLBillSlmtReceiptTypeList.jsp\";\n\t\t\tvar dialogFeatures  =  \"dialogTop:\" +\"-246px\"+\";dialogHeight:\" + \"38vh\" + \"; dialogWidth:\" + \"45vw\" +\" ; scroll=false; \"+\"status=no\";\n\t\t\tvar returnVal =window.showModalDialog(dialogUrl,null,dialogFeatures);\t\n\t\t\t\n\t  });\n\t \n\t \n\t $(\"#svcList\").click(async function(){\n\t\t\tvar query_string=document.forms[0].query_string.value;\n\t\t\tvar slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;\n\t\t\tvar billslmtamtdet = document.forms[0].billslmtamtdet.value;\n\t\t\tvar total_settled_amt = parent.frames[3].document.forms[0].total_settled_amt.value;\n\t\t\tvar billLevelTax = document.BillSlmtDetForm.billLevelTax.value;\t\n\t\t\tvar addlChargeAmtForBill = document.BillSlmtDetForm.addlChargeAmtForBill.value;\n\t\t\tvar bill_doc_no_selected=$(\"#bill_doc_no_list  option:selected\").text();\n\t\t\tvar bill_doc_type_selected=$(\"#bill_doc_no_list  option:selected\").val();\n\t\t\tvar dialogUrl       = \"../../eBL/jsp/BLBillSlmtServiceListFrame.jsp?\"+query_string+\"&slmt_amt_disabled_YN=\"+slmt_amt_disabled_YN+\"&billslmtamtdet=\"+billslmtamtdet+\"&total_settled_amt=\"+total_settled_amt+\"&billLevelTax=\"+billLevelTax+\"&addlChargeAmtForBill=\"+addlChargeAmtForBill+\n\t\t\t\t\t\"&bill_doc_no_selected=\"+bill_doc_no_selected+\"&bill_doc_type_selected=\"+bill_doc_type_selected;\n\t\t\tvar dialogFeatures  = \"dialogHeight:\" + \"30\" + \"; dialogWidth:\" + \"80\" +\" ; scroll=false; \";\n\t\t\tvar returnVal = await window.showModalDialog(dialogUrl,null,dialogFeatures);\n\t\t\tif(returnVal==\'SUCCESS\'){\n\t\t\t\tparent.frames[1].location.href =\"../../eBL/jsp/BLBillSlmtServiceSelectedList.jsp\";\n\t\t\t}\n\t  });\n\t \n\t  $(\"#all_service_criteria\").change(function(){\n\t\t\t $.ajax({\n\t\t\t\t     url:\"../../eBL/jsp/BLBillSlmtServiceListStorage.jsp\",\n\t\t\t\t     type:\'post\',\n\t\t\t\t     data: {\n\t\t\t\t   \t\toperation: \"ALL_INCLUDE_EXCLUDE\", \n\t\t\t\t \t\tall_service_criteria: $(\"#all_service_criteria\").val()\n\t\t\t\t     },\n\t\t\t\t     success: function(data) {\n\t\t\t\t         var obj = jQuery.parseJSON(data);\n\t\t\t\t\t\t parent.frames[1].location.href =\"../../eBL/jsp/BLBillSlmtServiceSelectedList.jsp\";\n\t\t\t\t     }\n\t\t\t\t });  \n\t\t  }); \n\t  \n\t  $( window ).load(function() {\n\t\t  parent.frames[1].location.href =\"../../eBL/jsp/BLBillSlmtServiceSelectedList.jsp\";\n\t\t});\n\t   \n});\t\n\n</script>\n";
    private final static byte[]  _wl_block5_1Bytes = _getBytes( _wl_block5_1 );

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n<HEAD>\n<!--\t<TITLE> Bill Settlement Details  11 </TITLE> -->\n\t\t<TITLE> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </TITLE>\n<!--\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- \t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\n\t<script>\t\t\n\t\t\tfunction ChkNumberInput1(fld, e, deci,sn)\n\t\t\t{\n\t\t\t\tvar strCheck =\"\";\n\t\t\t\tif(document.forms[0].billpayableamt.value < 0)\n\t\t\t\t{\n\t\t\t\t\tif (parseInt(deci)>0)\n\t\t\t\t\t\tstrCheck = \'-.0123456789\';\n\t\t\t\t\telse\n\t\t\t\t\t\tstrCheck = \'-0123456789\';\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif (parseInt(deci)>0)\n\t\t\t\t\t\tstrCheck = \'.0123456789\';\n\t\t\t\t\telse\n\t\t\t\t\t\tstrCheck = \'0123456789\';\t\n\t\t\t\t}\n\t\t\t\tvar whichCode = (window.Event) ? e.which : e.keyCode;\n\t\t\t\tif (whichCode == 13) return true;  // Enter\n\t\t\t\t\n\t\t\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\n\t\t\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\t\t\tif(key == \".\" && fld.value.indexOf(key) != -1) return false; // Not more than one \'.\' char\n\t\t\t\tif(key == \"-\" && fld.value.indexOf(key) != -1) return false; // Not more than one \'-\' char\n\t\t\t}\n\n\tfunction putdeci(object)\n\t{\t\t\n\t\t\n\t\tif(object.value!=\'\')\n\t\t{\n\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\tputDecimal(object,17,decimal);\n\t\t}\n\t\t\n\t\t\n\t}\n\nfunction funServiceDet()\n{\n\t\n\tvar query_string=document.forms[0].query_string.value;\n\tvar amt_sett=document.forms[0].billslmtamtdet.value;\n\tvar pay_amt=document.forms[0].billpayableamt.value;\n\tvar remOutStndAmt = parseFloat(pay_amt)-parseFloat(amt_sett);\n\tvar custId = document.forms[0].custId.value;\n\tvar sett_amt=parent.frames[3].document.forms[0].total_settled_amt.value;\t\t\n//\tvar slmt_amt_disabled_YN = parent.frames[3].document.forms[0].slmt_amt_disabled_YN.value;\n\t\tvar slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;\n\tif(pay_amt < 0)\n\t{\n\t\tvar temp=amt_sett.indexOf(\'-\');\n\t\tif(temp != -1 ) \n\t\t{\n\t\t\tif(temp != 0 ) \n\t\t\t{\t\t\t\t\n\t\t\t\talert(getMessage(\"INVALID_NUMBER_FORMAT\",\"common\"));\n\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\t\n\tif(pay_amt>0 && amt_sett<0)\n\t{\n\t\talert(getMessage(\"BL9863\",\"BL\"));\n\t\tdocument.forms[0].billslmtamtdet.select();\t\n\t\treturn false;\n\t}\n\tif(pay_amt<0 && amt_sett>0)\n\t{\n\t\talert(getMessage(\"BL9863\",\"BL\"));\n\t\tdocument.forms[0].billslmtamtdet.select();\t\n\t\treturn false;\n\t}\n\t\t\n\t\tif(amt_sett!=\"\")\n\t\t{\n\t\t\tif(sett_amt!=0)\n\t\t\t{\n\t\t\t\tif(parseFloat(amt_sett)<parseFloat(sett_amt) || parseFloat(amt_sett)>parseFloat(sett_amt))\n\t\t\t\t{\n\t\t\t\t\t alert(getMessage(\"BL9782\",\"BL\"));\n//\t\t\t\t\t document.forms[0].billslmtamtdet.select();\n//\t\t\t\t\t return false;\n\t\t\t\t}\n\t\t\t}\n\t\t\n\t\t\tvar out_standing_amt=document.forms[0].billpayableamt.value;\n\t\t\tif(amt_sett<0)\n\t\t\t{\t\t\t\t\n\t\t\t\n\t\t\t//if(parseFloat(amt_sett)>parseFloat(out_standing_amt))\n\t\t\tif(parseFloat(out_standing_amt)>parseFloat(amt_sett))\n\n\t\t\t{\t\t\t\n\t\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tvar slmtAmtAfterDep = $(\'#slmtAmtAfterDep\').val();\n\n\t\t\tif(slmtAmtAfterDep != \'\' && parseFloat(amt_sett)>parseFloat(slmtAmtAfterDep))\n\n\t\t\t{\t\t\t\n\t\t\t\talert(getMessage(\'BL00935\',\'BL\'));\n\t\t\t\t//document.forms[0].billslmtamtdet.select();\n\t\t\t\t//return false;\n\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\tif(amt_sett>0)\n\t\t\t{\n\t\t\t\n\t\t\tif(parseFloat(amt_sett)>parseFloat(out_standing_amt))\n\n\t\t\t{\t\t\t\n\t\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tvar slmtAmtAfterDep = $(\'#slmtAmtAfterDep\').val();\n\n\t\t\tif(slmtAmtAfterDep != \'\' && parseFloat(amt_sett)>parseFloat(slmtAmtAfterDep))\n\n\t\t\t{\t\t\t\n\t\t\t\talert(getMessage(\'BL00935\',\'BL\'));\n\t\t\t\t//document.forms[0].billslmtamtdet.select();\n\t\t\t\t//return false;\n\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\t\tif(custId == \'MOHBR\'){\t\n\t\t\t\t\tif(amt_sett!=\'\'){\n\t\t\t\t\t\t\tvar remamt = document.forms[0].remOutStndAmt.value;\n\t\t\t\t\t\t\tvar ttamt=\"0.0\";\n\t\t\t\t\t\t\t if(remamt!=\'\' )\n\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t var blamtt = document.forms[0].billslmtamtdet.value;\n\t\t\t\t\t\t\t\t var ttamt = parseFloat(blamtt) + parseFloat(remamt);\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t  }\n\t\t\t\t\t\tif(parseFloat(pay_amt)>0){\n\t\t\t\t\t\t\tif(parseFloat(ttamt) !=  parseFloat(pay_amt) && parseFloat(amt_sett)<parseFloat(pay_amt)){\n\t\t\t\t\t\t\t\tvar resp = confirm(\"Partial settlement being processed \\n  Do you want to continue? \");\n\t\t\t\t\t\t\t\tif(resp == true){\n\t\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = remOutStndAmt;\n\t\t\t\t\t\t\t\t\tputdeci(document.forms[0].remOutStndAmt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tdocument.forms[0].billslmtamtdet.value = pay_amt;\n\t\t\t\t\t\t\t\t\tputdeci(document.forms[0].billslmtamtdet);\n\t\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = \'0.0\';\n\t\t\t\t\t\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = remOutStndAmt;\n\t\t\t\t\t\t\t\tputdeci(document.forms[0].remOutStndAmt)\n\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tif(parseFloat(ttamt) !=  parseFloat(pay_amt) && parseFloat(pay_amt)<parseFloat(amt_sett)){\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.forms[0].billslmtamtdet.value = pay_amt;\n\t\t\t\t\t\t\t\tputdeci(document.forms[0].billslmtamtdet);\n\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = \'0.0\';\n\t\t\t\t\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\t\t\t\t\treturn false;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = remOutStndAmt;\n\t\t\t\t\t\t\t\tputdeci(document.forms[0].remOutStndAmt)\n\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = \'\';\n\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\tdocument.forms[0].service_check.value=\'Y\';\n}\n\nfunction funServiceDet_onLoad()\n{\n\tvar query_string=document.forms[0].query_string.value;\n\tvar slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;\n\tvar amt_sett=document.forms[0].billslmtamtdet.value;\n//\t\tvar sett_amt=parent.frames[3].document.forms[0].total_settled_amt.value;\t\n\t\t\n\t\tif(amt_sett!=\"\")\n\t\t{\n\t\tvar out_standing_amt=document.forms[0].billpayableamt.value;\n\t\tif(parseFloat(amt_sett)>parseFloat(out_standing_amt))\n\t\t{\t\t\t\n\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t document.forms[0].billslmtamtdet.select();\n\t\t\t return false;\n\n\t\t}\n\t\t}\n\tdocument.forms[0].service_check.value=\'Y\';\n\n}\n\n\n\n\n\n\nfunction rectypelkup()\n\t\t{\n\t\tvar msg=\"\";\n\t\tvar target\t\t\t\t= document.forms[0].rectype;\n\t\tvar retVal\t\t\t\t= new String();\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"40\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar tit\t\t\t\t\t= \"\";\n\t\t//Below line (v_facility_id) is added by muthu against IN:032615 on 10-5-12\n\t\tvar v_facility_id =document.forms[0].strfacilityid.value;// \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\n\t\tvar v_ext_acc_interface_yn = document.forms[0].ext_acc_interface_yn.value;//\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\tvar\tv_single_serv_grp = document.forms[0].str_single_service_grp_yn.value;//\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\t\t\n\t\tvar v_acc_episode_type = document.forms[0].str_acc_episode_type.value;//\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\t\n\t\tvar v_acc_catg_code = document.forms[0].str_acc_category_code.value;//\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\t\t\n\t\tvar v_acc_serv_grp_used_yn = document.forms[0].str_acc_serv_grp_used_yn.value;//\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\t\t\n\t\tvar v_serv_grp = document.forms[0].str_service_grp.value;//\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\t\t\n\t\tvar v_episode_type =document.forms[0].str_episode_type.value;// \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\t\t\n\t\tvar v_reln_code =document.forms[0].str_reln_code.value;//\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\n\n\t\tvar locale = document.forms[0].locale.value;\n\t\t\n\n// PE Changes\t\t\t\n\n\t\tsql = \"select receipt_type_code, long_desc from bl_receipt_type_lang_vw where language_id=`\"+locale+\"` and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id=`\"+v_facility_id+\"`) and recpt_nature_code = `BI` and status is null and (( `\"+v_ext_acc_interface_yn+\"` = `Y` and  receipt_type_code in ( select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code = `BI` and status is null and ((`\"+v_single_serv_grp+\"`=`Y` and episode_type in (`\"+v_acc_episode_type+\"`,`U`) and category in (`UNRESTRICTED`,`\"+v_acc_catg_code+\"`) and ((`\"+v_acc_serv_grp_used_yn+\"` = `Y` and blng_serv_grp = `\"+v_serv_grp+\"`) or (`\"+v_acc_serv_grp_used_yn+\"` = `N` and  blng_serv_grp is null ))) or (`\"+v_single_serv_grp+\"`=`N` and episode_type in (`U`,`\"+v_episode_type+\"`) and category IN ( `\"+v_reln_code+\"`,`UNRESTRICTED`) and blng_serv_grp is null )))) or `\"+v_ext_acc_interface_yn+\"` = `N`)\";\t\t\t\n\n\t\tsearch_code=\"receipt_type_code\";\n\t\tsearch_desc=\"long_desc\";\n\t\ttit=encodeURIComponent(getLabel(\"eBL.RECEIPT_TYPE.label\",\"BL\"));\n\t\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\t\tvar arr=new Array();\n\t\tif (!(retVal == null))\n\t\t{\n  \t\t    var retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"::\");\n\t\t\n\t\t\tdocument.forms[0].rectypedesc.value=arr[0];\n\t\t    document.forms[0].rectype.value=arr[1];\n\t\t\t\n\t\t\tdocument.forms[0].acccode.value=\'\';\n\t\t\tdocument.forms[0].acccodedesc.value=\'\';\n\n\t\t\tdocument.forms[0].dept.value=\'\';\n\t\t\tdocument.forms[0].deptdesc.value=\'\';\n\n\t\t}\n\t\telse\n\t\t{\t\t\n\t\t\n\t\t\tdocument.forms[0].rectypedesc.value=\'\';\n\t\t\tdocument.forms[0].rectype.value = \'\';\t\t\t\t\t\t\n\n\t\t\tdocument.forms[0].acccode.value=\'\';\n\t\t\tdocument.forms[0].acccodedesc.value=\'\';\n\n\t\t\tdocument.forms[0].dept.value=\'\';\n\t\t\tdocument.forms[0].deptdesc.value=\'\';\n\n\t\t\ttarget.focus();\n\t\t}\n\t\n\n\t}\n\nfunction acccodelkup()\n\t\t{\n\t\tvar msg=\"\";\n\t\tvar target\t\t\t\t= document.forms[0].acccode;\n\t\tvar retVal\t\t\t\t= new String();\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"40\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar tit\t\t\t\t\t= \"\";\n\t\t\n\t\tvar v_ext_acc_interface_yn = document.forms[0].ext_acc_interface_yn.value;//\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\';\n\t\tvar v_acc_catg_code = document.forms[0].str_acc_category_code.value;//\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\';\t\t\n\t\tvar v_rec_type = document.forms[0].rectype.value;\t\t\n\t\tvar locale = document.forms[0].locale.value;\n\n\tsql = \"select account_code,long_desc from (select a.account_code, b.long_desc , decode(a.episode_type, `\"+v_acc_episode_type+\"`,`1`,`999`) order1, decode(a.category,`\"+v_acc_catg_code+\"`\t,1,999) order2 from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`\"+locale+\"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code and a.acc_entity_code = b.acc_entity_code and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `\"+v_rec_type+\"` and a.status is null and a.episode_type in (`U`, `\"+v_acc_episode_type+\"`) and a.category in(`UNRESTRICTED`,`\"+v_acc_catg_code+\"`) order by 3,4 ) where rownum=1\";\n\n\t\t\tsearch_code=\"account_code\"; \n\t\t\tsearch_desc=\"long_desc\";\n\t\t\t\n\t\ttit=encodeURIComponent(getLabel(\"eBL.ACCOUNT_CODE.label\",\"BL\"));\n\t\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\t\tvar arr=new Array();\n\n\t\tif (!(retVal == null))\n\t\t{\n  \t\t    var retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"::\");\n\t\t\n\t\t\tdocument.forms[0].acccodedesc.value=arr[0];\n\t\t    document.forms[0].acccode.value=arr[1];\n\t\t\tdocument.forms[0].acccode.focus();\t\t\t\t\n\t\t\t\n\t\t}\n\t\telse\n\t\t{\t\t\n\t\t\n\t\t\tdocument.forms[0].acccodedesc.value=\'\';\n\t\t\tdocument.forms[0].acccode.value = \'\';\t\t\t\t\t\t\t\t\t\n\n\t\t\ttarget.focus();\n\t\t}\n\t}\n\tfunction deptlkup()\n\t{\n\t\tvar msg=\"\";\n\t\tvar target\t\t\t\t= document.forms[0].dept;\n\t\tvar retVal\t\t\t\t= new String();\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"40\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar tit\t\t\t\t\t= \"\";\t\t\n\t\tvar v_dept_code =document.forms[0].str_ext_dept_code.value;//\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\t\tvar v_facility_id =document.forms[0].strfacilityid.value;// \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\t\tvar locale = document.forms[0].locale.value;\t\t\n\t\tsql = \"\tselect dept_code, long_desc from am_dept_lang_vw where language_id=`\"+locale+\"` and dept_code like nvl(`\"+v_dept_code+\"`,dept_code )\";\n\t\tsearch_code=\"dept_code\";\n\t\tsearch_desc=\"long_desc\";\n\t\ttit=encodeURIComponent(getLabel(\"eBL.ACCOUNTING_DEPT.label\",\"BL\"));\n\t\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\t\tvar arr=new Array();\n\t\tif (!(retVal == null))\n\t\t{\n  \t\t    var retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"::\");\t\t\n\t\t\tdocument.forms[0].deptdesc.value=arr[0];\n\t\t    document.forms[0].dept.value=arr[1];\n\t\t\tdocument.forms[0].dept.focus();\t\t\n\t\t}\n\t\telse\n\t\t{\t\t\t\t\n\t\t\tdocument.forms[0].deptdesc.value=\'\';\n\t\t\tdocument.forms[0].dept.value = \'\';\t\t\t\t\t\t\n\t\t\ttarget.focus();\n\t\t}\n\t\n\n\t}\t\nfunction funCurStlmt()\n{ \n\tvar total_records=document.forms[0].total_records.value;\n\tvar v_tot_curr_stlmt=document.forms[0].tot_curr_stlmt.value;\n\n\t\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tvar pend_amt=eval(\"document.forms[0].pend_set\"+j);\n\t\tvar curr_set=eval(\"document.forms[0].curr_set\"+j);\n\t\tif(curr_set.value==\"\")\n\t\t{\n\t\t\tcurr_set.value=0.00;\n\t\t\tputdeci(curr_set);\n\t\t\t//curr_set.focus();\n\t\t\tcurr_set.select();\n\t\t\treturn false;\n\t\t}\n\n\n\t\tif ( parseFloat(curr_set.value) > parseFloat(pend_amt.value))\n\t\t{\n\t\t\t alert(getMessage(\"BL9658\",\"BL\"));\n   \t\t\tcurr_set.select();\n\t\t}\n\t\ttotCurrSlmt();\n\t\t\n\t\t\n\t\n\tif(parseFloat(curr_set.value) >parseFloat(v_tot_curr_stlmt))\n\t\t{\n\t\t\talert(getMessage(\"BL9621\",\"BL\"));\n\t\t\tcurr_set.value=0.00;\n\t\t\tputdeci(curr_set);\n\t\t\t//curr_set.focus();\n\t\t\tcurr_set.select();\n\t\t\treturn false;\n\t\t}\n\t}\n}\n\nfunction funCurrMultSlmt()\n\t\t{\n\t      var s_amt=document.forms[0].billslmtamtdet.value;\t\t  \n\t\t  var total_records=document.forms[0].total_records.value;\t\n\t\t  if(total_records>0)\n\t\t\t{\n\t\t  for(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t  var pend_amt=eval(\"document.forms[0].pend_set\"+j);\t\t\t  \n\t\t\t  var v_pend_amt=pend_amt.value;\n\t\t\t  var curr_set=eval(\"document.forms[0].curr_set\"+j);\n\t\t\t  if(parseFloat(s_amt)> parseFloat(pend_amt.value))\n\t\t\t\t{\t\t\t\t  \t\t \n\t\t\t\t  curr_set.value=v_pend_amt;\t\t\t\t  \n\t\t\t\t  putdeci(curr_set);\n\t\t\t\t}\n\t\t\t\telse{\t\t\t\t\t\n\t\t\t\t\tif(parseFloat(s_amt)>0)\n\t\t\t\t\t{\t\t\t\t\t \n\t\t\t\t\t curr_set.value=s_amt;\n\t\t\t\t\t putdeci(curr_set);\n\t\t\t\t\t}\n\t\t\t\t\telse{curr_set.value=0;\n\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t\t}\n\n\t\t\t\t }\n\t\t\t\ts_amt=parseFloat(s_amt)-parseFloat(v_pend_amt);\t\t\t\t\t\n\n\t\t\ttotCurrSlmt();\n\t\t\t}\n\t\t\t}\n\t\t}\n\n\tfunction totCurrSlmt()\n\t\t{\n\t\t\tvar tot_curr_set=0.0;\n\t\t\tvar v_curr_set=\"\";\n\t\t\tvar a1=new Array();\n\t\t\tvar s_amt=document.forms[0].billslmtamtdet.value;\n\t\t\tvar total_records=document.forms[0].total_records.value;\t\t  \n\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tv_curr_set=eval(\"document.forms[0].curr_set\"+j);\n\t\t\t\ta1[j]=v_curr_set.value;\n\t\t\t\t if(a1[j]==\"\"){a1[j]=\"0.0\";}\n\t\t\t\ttot_curr_set=parseFloat(tot_curr_set) + parseFloat(a1[j]);\n\t\t\t\t\n\t\t\t}\n\t\t\tdocument.forms[0].tot_curr_stlmt.value=tot_curr_set;\n\t\t\tvar total_curr_stlmt=eval(\"document.forms[0].tot_curr_stlmt\");\n\t\t\tputdeci(total_curr_stlmt);\n\t\t\t\n\t\t}\n\n\tfunction slmt_amt_disabled_YN()\n\t{\n\t\t/*var alw_co_wit_bl_slmt_yn=document.forms[0].alw_co_wit_bl_slmt_yn.value;\n\t\tvar called_frm=document.forms[0].called_frm.value;\n\t\tvar str_episode_type=document.forms[0].episode_type.value;\n\t\tvar slmt_amt_disabled_YN=document.forms[0].slmt_amt_disabled_YN.value;\n\n\t\tif(alw_co_wit_bl_slmt_yn == \"Y\" && called_frm==\"CHECKOUT_VISIT\" && str_episode_type == \"E\")\n\t\t{\n\t\t\tdocument.forms[0].billslmtamtdet.disabled=true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(slmt_amt_disabled_YN==\"Y\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].billslmtamtdet.disabled=true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].billslmtamtdet.disabled=false;\n\t\t\t}\n\t\t\t\n\t\t\t//The below If Condition makes the Settlement Column disabled, when user is settling partially\n\t\t\tif($(\'#partSettled\').val()==\'Y\'){\n\t\t\t\tdocument.forms[0].billslmtamtdet.disabled=true;\n\t\t\t}\n\t\t}*/\n\t\tif($(\'#fromBillGen\').val() == \'Y\'){\n\t\t\tdocument.forms[0].billslmtamtdet.disabled=false;\n\t\t}\n\t\telse{\n\t\t\tdocument.forms[0].billslmtamtdet.disabled=true;\n\t\t}\n\t\t\n\t\t\n\t\tif($(\'#billslmtamtdet\').prop(\'disabled\') == true){\n\t\t\t$(\'#slmtAlreadyDisabled\').val(\'Y\');\n\t\t}\n\t\telse{\n\t\t\t$(\'#slmtAlreadyDisabled\').val(\'N\');\n\t\t}\n\t}\n\t\n\t//Added for KDAH-CRF-0318\n\tfunction fnDispBillTaxDesc(){\n\t\tvar billLevelTax = document.BillSlmtDetForm.billLevelTax.value;\n\t\tvar addlChargeAmt = document.BillSlmtDetForm.addlChargeAmtForBill.value;\n\t\tif(addlChargeAmt == \'\'){\n\t\t\taddlChargeAmt = 0;\n\t\t}\n\t\tif(billLevelTax == \'Y\' && addlChargeAmt > 0){\n\t\t\tdocument.getElementById(\'billLevelTaxDesc\').innerText = \'(Including Bill level Tax)\';\n\t\t\tdocument.getElementById(\'billLevelTaxDesc\').style.display = \'inline\';\t\t\t\n\t\t}\n\t}\n\t</script>\t  \n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <script> \n\t\t\t\tvar v_error_text = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\t\t\t\t\t\n\t\t\t\tif ( v_error_text != \'\')\n\t\t\t    {\n\t\t\t\t\t\talert(v_error_text);\n\n\t\t\t\t\t\t//return false;\n\t\t\t\t\t\t//window.close();\t\n\t\t\t\t}\n\t\t\t\t</script>  \n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n</HEAD>\n\n\t<BODY onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\" onload=\'slmt_amt_disabled_YN();funServiceDet_onLoad();fnDispBillTaxDesc();\' >\n\t<FORM name=\'BillSlmtDetForm\' id=\'BillSlmtDetForm\' method=\'post\'  action=\'\'  scrolling=\'NO\' >\n<!--Added by Muthu on 9/5/12 against against JD-0008 Starts here -->\n<!--Added by Muthu on 9/5/12 against against JD-0008 Ends here -->\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' >\t\n\t\t<tr style=\"width: 100%;\">\n\t\t <td class=\"label\" colspan = \'5\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<input type=\"checkbox\" id=\'downTimeEntry\' name=\"downTimeEntry\" id=\"downTimeEntry\" value=\'\'  >\t</td>\n\t\t</tr>\n\t\t<tr id=\"trDownTypeEntry\" style=\"width: 100%;\">\n\t\t<td class=\"label\"  style=\"width: 12%\" >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</td>\n\t\t<td  style=\"width: 28%\"> \n\t\t<input type=\'text\' name=\'doc_type_number\' id=\'doc_type_number\' id=\'doc_type_number\' size=\'10\' maxlength=\'30\'  value=\'\'    >\t\t \n\t\t <label>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</label>\n\t\t<input type=\'text\' name=\'document_number\' id=\'document_number\' id=\'document_number\' size=\'10\' maxlength=\'8\'  value=\'\'  onkeypress=\'return checkAlpha(event);\' onBlur=\'checkForNumber(this)\' ><input type=\'button\' class=\'button\' name=\"docnumber\" id=\"docnumber\"   value=\'?\'  tabindex=\'0\' ><img src=\'../../eCommon/images/mandatory.gif\'>\t\t\t\t\t \n\t\t</td>\n\t\t<td class=\"label\" style=\"width: 10%\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t </td>\n\t\t <td width=\"17%\" >\n\t\t <input type=\'text\' name=\'deposit_date\' id=\'deposit_date\' id=\'deposit_date\' size=\'15\' maxlength=\'19\'  value=\'\' onBlur=\'isValidDateTime(deposit_date);\'  >\n\t\t &nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'deposit_date\',\'dd/mm/yyyy\',\'hh:mm\');\" >\n\t\t &nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\t\t \t\t\n\t\t</td>\n\t\t <td class=\"label\" style=\"width: 12%\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t</td>\n\t\t <td style=\"width: 21%\" >\n\t\t <input type=\'text\' name=\'deposit_reason\' id=\'deposit_reason\' id=\'deposit_reason\' size=\'10\' maxlength=\'30\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(dep_reason,deposit_reason,3,1); } else{ fnClearCode(dep_reason); }\">\t\t\t \t\t\n\t\t<input type=\'text\' name=\'dep_reason\' id=\'dep_reason\' id=\'dep_reason\' size=\'10\' maxlength=\'30\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(dep_reason,deposit_reason,3,2); } else{ fnClearCode(dep_reason); }\">\n\t\t&nbsp;<input type=\'button\' class=\'button\' name=\"reason\" id=\"reason\"   value=\'?\'  tabindex=\'0\' onClick=\"callCommonLookupCode(dep_reason,deposit_reason,3,2);\"><img src=\'../../eCommon/images/mandatory.gif\'>\t\t\t\t\t \n\t\t</td>\t\t\t \t\t\t\t\n\t\t</tr>\n\t\t</table>\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\t\t \n\t\t<tr><td class=\'columnHeader\' colspan=\'16\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td></tr>\n\t\t<tr>\n<!--\t<td class=\"label\" width=\"25%\">Bill No</td>\t -->\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\t \n\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"billdoctype\" id=\"billdoctype\" SIZE=\"7\" MAXLENGTH=\"10\" \t\t\t\tVALUE=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  style=\'text-align:left\' READONLY> / <INPUT TYPE=\"TEXT\" \n\t\t name=\"billdocnum\" id=\"billdocnum\" SIZE=\"8\" MAXLENGTH=\"10\"  VALUE=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' style=\'text-align:right\' READONLY>\n\t\n<!--\t<td class=\"label\" width=\"25%\">Payable Amount</td>\t-->\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" &nbsp;<span style=\'display: none;font-size: 9px;\' id=\'billLevelTaxDesc\' name=\'billLevelTaxDesc\'></span></td>\t\n<!--\n\t\t<td>&nbsp;<INPUT TYPE=\"TEXT\" READONLY name=\"billpayableamt\" id=\"billpayableamt\" SIZE=\"8\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'  style=\'text-align:right\'>&nbsp;<INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"  OK  \" onClick=\'billslmtprocess()\'><td> \t-->\t\n\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY id=\"billpayableamt\" name=\"billpayableamt\" id=\"billpayableamt\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'  style=\'text-align:right\'>&nbsp;</td> \n<!--Added by Muthu on 9/5/12 against against JD-0008 Starts here -->\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t<td width=\"25%\" class=\"fields\"><INPUT TYPE=\"TEXT\" name=\"drugpenality\" id=\"drugpenality\" SIZE=\"15\" MAXLENGTH=\"20\" VALUE=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'  style=\'text-align:right\' readOnly/> </td>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n<!--Added by Muthu on 9/5/12 against against JD-0008 Ends here -->\n\t\t</tr>\n\t\t<tr>\n<!--added here by ram-->\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\n\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t<td width=\"25%\" class=\"fields\">\n\t\t<a name=\'billList\' id=\'billList\' href=\"#\" >Modify Receipt Details</a><img src=\'../../eCommon/images/mandatory.gif\'>  </td>\n\t\t<input type= hidden name=\"rectypedesc\" id=\"rectypedesc\"  value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\t\n\t\t</tr>\n\t\t<tr>\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\n\t\t<td width=\"25%\" class=\"fields\"><INPUT TYPE=\"TEXT\"  id=\"billslmtamtdet\"  name=\"billslmtamtdet\" id=\"billslmtamtdet\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,2,1))\' onBlur=\'putdeci(this);funServiceDet()\'></td>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\n\t\t\t\t\t<td width=\"25%\" class=\"fields\"><INPUT TYPE=\"TEXT\" readonly name=\"remOutStndAmt\" id=\"remOutStndAmt\" SIZE=\"14\" MAXLENGTH=\"10\" \tVALUE=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,2))\' onBlur=\'putdeci(this);funServiceDet()\'> </td>\n\t\t\t\t\t<td width=\"25%\"  class=\"fields\">&nbsp;</td>\t\n\t\t\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\n\n</tr>\t\n<!--here end-->\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t<tr>\n\t<td class=\"label\"  width=\"25%\">Service Criteria</td>\n\t\n\t<td  width=\"25%\" class=\"fields\">\n\t\t<div id=\'serviceCriteriaDiv\'><select name=\"all_service_criteria\" id=\"all_service_criteria\" id=\"all_service_criteria\">\n\t\t  <option ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" value=\"I\">All Services Included</option>\n\t\t  <option ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" value=\"E\">All Services Excluded</option>\n\t\t</select>\n\t\t</div>\n\t</td>\t\n\t\n\t<td class=\"label\" width=\"25%\">\n\t<div id=\'selectServiceList\'><a name=\'svcList\' id=\'svcList\' href=\"#\" >Service List</a> </div>\n\t</td>\n\t<td class=\"label\">&nbsp;</td>\n\t<td></td>\n\t</tr>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t<tr>\n\t<td class=\"label\"  width=\"25%\">Service Criteria</td>\n\t<td  width=\"25%\" class=\"fields\">\n\t\t<div id=\'serviceCriteriaDiv\'><select name=\"all_service_criteria\" id=\"all_service_criteria\" id=\"all_service_criteria\">\n\t\t  <option ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" selected value=\"I\">All Services Included</option>\n\t\t</select>\n\t\t</div>\n\t</td>\n\t<td class=\"label\">&nbsp;</td>\n\t<td></td>\n\t</tr>\t\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\n\t<tr>\n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t<td class=\"fields\" width=\"25%\" ><input type=\'checkbox\' name=\'recievedthrumail\' id=\'recievedthrumail\' ></td>\n\t<td class=\"label\" width=\"25%\">\n\t<a name=\'adjDeposit\' id=\'adjDeposit\' href=\"#\" >Adjust from Deposit</a>\n\t&nbsp;<span id=\'spAdjFrmDep\' name=\'spAdjFrmDep\'>0.00</span>\n\t</td>\n\t<td class=\"label\" width=\"25%\">\n\t<a name=\'clearDeposit\' id=\'clearDeposit\' href=\"#\" >Clear Deposit</a>\n\t</td>\n\t</tr>\n\t\n\t\t<!-- <td class=\"label\"> </td> -->\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t</table> \n<div id=\"RecordsIncludedExcluded\"></div>\n<!-- Karthik added the Code for Bulk Bill Settlement Details - Ends -->\n\n<input TYPE=\"hidden\"  id=\"settleByService\"  name=\"settleByService\" id=\"settleByService\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n<input TYPE=\"hidden\"  id=\"strpatientid\"  name=\"strpatientid\" id=\"strpatientid\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"pagecloseind\" id=\"pagecloseind\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"0\">\t\t\n<INPUT TYPE=\"HIDDEN\" name=\"dfltslmttypecode\" id=\"dfltslmttypecode\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'\' >\t \t\n<INPUT TYPE=\"HIDDEN\" name=\"slmtdate\" id=\"slmtdate\"\t   SIZE=\"20\" MAXLENGTH=\"20\" \tVALUE=\"\"> \n<INPUT TYPE=\"HIDDEN\" name=\"slmtdocrefdesc\" id=\"slmtdocrefdesc\" SIZE=\"50\" MAXLENGTH=\"100\"\tVALUE=\"\">\t\n<INPUT TYPE=\"HIDDEN\" name=\"slmtdocref\" id=\"slmtdocref\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"\">\n<INPUT TYPE=\"HIDDEN\" name=\"ext_acc_interface_yn\" id=\"ext_acc_interface_yn\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_ext_acc_facility_id\" id=\"str_ext_acc_facility_id\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_ext_account_code\" id=\"str_ext_account_code\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_ext_dept_ind\" id=\"str_ext_dept_ind\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_ext_dept_code\" id=\"str_ext_dept_code\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_single_service_grp_yn\" id=\"str_single_service_grp_yn\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_service_grp\" id=\"str_service_grp\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_acc_episode_type\" id=\"str_acc_episode_type\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\n<INPUT TYPE=\"HIDDEN\" name=\"str_acc_serv_grp_used_yn\" id=\"str_acc_serv_grp_used_yn\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\t\n<INPUT TYPE=\"HIDDEN\" name=\"str_acc_category_code\" id=\"str_acc_category_code\"  SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\t\n<INPUT TYPE=\"HIDDEN\" name=\"str_reln_code\" id=\"str_reln_code\"      SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\t\n\n<INPUT TYPE=\"HIDDEN\" name=\"str_episode_type\" id=\"str_episode_type\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"strfacilityid\" id=\"strfacilityid\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n<input type=\"hidden\" name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n<input type=\"hidden\" name=\"noofdecimal\" id=\"noofdecimal\"  value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n<input type=\"hidden\" name=\"service_check\" id=\"service_check\"  value=\'\'>\n<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n<input type=\'hidden\' name=\"query_string\" id=\"query_string\"  value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n<input type=\'hidden\' name=\"strroundingamt\" id=\"strroundingamt\"  value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\n<input type=\'hidden\' name=\"slmt_amt_disabled_YN\" id=\"slmt_amt_disabled_YN\"  value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\n<input type=\'hidden\' name=\"called_frm\" id=\"called_frm\"  value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n<input type=\'hidden\' name=\"alw_co_wit_bl_slmt_yn\" id=\"alw_co_wit_bl_slmt_yn\"  value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n<input type=\'hidden\' name=\"episode_type\" id=\"episode_type\"  value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<input type=\'hidden\' name=\'custId\' id=\'custId\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<input type=\'hidden\' name=\'addlChargeAmtForBill\' id=\'addlChargeAmtForBill\' id=\'addlChargeAmtForBill\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\'hidden\' name=\'billLevelTax\' id=\'billLevelTax\' id=\'billLevelTax\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n<input type=\'hidden\' name=\'depositAdjustedIndicator\' id=\'depositAdjustedIndicator\'  id=\'depositAdjustedIndicator\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<!-- Added by Rajesh V for 59527 -->\n<input type=\'hidden\' name=\'slmtAmtAfterDep\' id=\'slmtAmtAfterDep\' id=\'slmtAmtAfterDep\' value=\'\'>\n<input type=\'hidden\' name=\'depAdjAmt\' id=\'depAdjAmt\' id=\'depAdjAmt\' value=\'\'>\n<input type=\'hidden\' name=\'partSettled\' id=\'partSettled\' id=\'partSettled\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n<input type=\'hidden\' name=\'slmtAlreadyDisabled\' id=\'slmtAlreadyDisabled\' id=\'slmtAlreadyDisabled\' value=\'\'>\n<input type=\'hidden\' name=\'blReceiptType\' id=\'blReceiptType\' id=\'blReceiptType\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n<input type=\'hidden\' name=\'blRefundType\' id=\'blRefundType\' id=\'blRefundType\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n<input type=\'hidden\' name=\'blRecRefInd\' id=\'blRecRefInd\' id=\'blRecRefInd\' value=\'\'>\n<input type=\'hidden\' name=\'fromBillGen\' id=\'fromBillGen\' id=\'fromBillGen\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n</FORM>\t\n\n</BODY>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5_0Bytes, _wl_block5_0);
            _bw.write(_wl_block5_1Bytes, _wl_block5_1);

 	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			
	String strclientip ="";
	strclientip=p.getProperty("client_ip_address");	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; ResultSet rs21 = null; ResultSet rscurr=null;
	String		ext_acc_interface_yn=""; 	String		str_receipt_type_code = "";	String		str_ext_acc_facility_id = "";
	String		str_ext_account_code	= ""; 	String		str_ext_dept_ind = "";	String		str_ext_dept_code     = "";
	String		str_single_service_grp_yn = ""; 	String		str_service_grp		= ""; 	String		str_acc_episode_type= "";
	String		str_acc_category_code	= ""; 	String		str_acc_serv_grp_used_yn	= ""; 	String		str_reln_code		= "";
	String		str_episode_type		= "";	
	String		str_error_text		= ""; 	String      strslmttype		=""; String		strfacilityid	=""; 	
	int noofdecimal=2;  	String strbilldoctypecode=""; 	String strbilldocnum=""; 
	String strbillpayableamt=""; double v_billpayableamt=0; 	  
	String strrectypedesc="";	 	//String stracccode ="";  	
	String stracccodedesc ="";
	String strdeptdesc =""; 	
	int total_records=0;String query_string="";	 
	String slmt_amt_disabled_YN="";	String strdfltcashbillslmtamt = "";String strslmtamt = "";String strchangereceiptamtind = "";
	String strrcptallowedyn = "",strroundingamt="";

	String called_frm="",alw_co_wit_bl_slmt_yn="N";
	String custId = BLReportIdMapper.getCustomerId();
	//KDAH-CRF-0318
	String addlChargeAmtForBill = "";
	String billLevelTax = "N";
	boolean settleByService=false;
	boolean depositAdjustedIndicator=false;

// <!-- Karthik added the Code for Bulk Bill Settlement Details - Starts -->

	String beanId = "BillDetailsBean";
	String beanName = "eBL.BLBillDetailsBean";
	BLBillDetailsBean bean=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
	HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=bean.getBillDtlMap();
	ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");
	ArrayList<String> docNumListArray=new ArrayList<String>();
	ArrayList<String> docTypeCodeArray=new ArrayList<String>();
	
	for(BLBillDetailsBean beanObj:billDetailList){
		docNumListArray.add(beanObj.getDocNum());
		docTypeCodeArray.add(beanObj.getDocTypeCode());
	}
	
	String allIncluded="";
	String allExcluded="";
	
	String all_services_included_excluded_slmt = (String) session.getAttribute("all_services_included_excluded_slmt");
	if(all_services_included_excluded_slmt==null){	 
		all_services_included_excluded_slmt ="I";
		session.setAttribute("all_services_included_excluded_slmt",all_services_included_excluded_slmt);
	}
	
	System.out.println("all_services_included_excluded_slmt::::::"+ all_services_included_excluded_slmt);
	if(all_services_included_excluded_slmt.equals("I"))	{
		allIncluded="selected";	
	}else{
		allExcluded="selected";
	}
	
	String partSettled = request.getParameter("partSettled");
	String blReceiptType = "";
	String blRefundType = "";
	String fromBillGen = request.getParameter("fromBillGen");
	if(fromBillGen == null){
		fromBillGen = "";
	}

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		strfacilityid = request.getParameter("facilityid");	
		if(strfacilityid==null || strfacilityid.equals("")) strfacilityid="";
		String recRefQuery = "select DOWNTIME_RECEIPT_DOC_TYPE, DOWNTIME_REFUND_DOC_TYPE "+
							 "from   BL_PARAMETERS "+
  	    					 "where  OPERATING_FACILITY_ID = ? ";
		pstmt = con.prepareStatement(recRefQuery);
		pstmt.setString(1, strfacilityid);
		rs = pstmt.executeQuery();
		if(rs != null && rs.next()){
			blReceiptType = rs.getString("DOWNTIME_RECEIPT_DOC_TYPE");
			blRefundType = rs.getString("DOWNTIME_REFUND_DOC_TYPE");
		}
		pstmt=null;
		rs=null;
		query_string=request.getQueryString();
		if(query_string==null || query_string.equals("")) query_string="";
//		System.out.println("query_string from det:" + query_string);
		strbilldoctypecode = request.getParameter("billdoctypecode");	
		if(strbilldoctypecode==null || strbilldoctypecode.equals("")) strbilldoctypecode="";
//		System.out.println("strbilldoctypecode req:"+strbilldoctypecode);	
		strbilldocnum = request.getParameter("billdocnum");	
		if(strbilldocnum==null || strbilldocnum.equals("")) strbilldocnum="";
		strbillpayableamt = request.getParameter("billpayableamt");	
		if(strbillpayableamt==null || strbillpayableamt.equals("")) strbillpayableamt="";
		if(!strbillpayableamt.equals(""))
		{
			v_billpayableamt=Double.parseDouble(strbillpayableamt);
		}
		

		String strpatientid  = request.getParameter("patientid");	
		String strepisodetype = request.getParameter("episodetype");
		String strepisodeid = request.getParameter("episodeid");	
		String strvisitid = request.getParameter("visitid");	
		String strslmtpayername = request.getParameter("slmtpayername");
		String struser = request.getParameter("loggeduser");	
		String strslmtidno = request.getParameter("slmtidno");
		String strcashcounter = request.getParameter("cashcounter");
		String strrcptallowedynuser = "";
		String strchangereceiptalloweduser = "";
		//String strchangeyn	= "N";	
		strroundingamt = request.getParameter("strroundingamt");
		if ( strroundingamt == null || strroundingamt.equalsIgnoreCase("null")) 
		{strroundingamt ="";}
//		System.out.println("strroundingamt in DET" + strroundingamt);

		if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
		{strbilldoctypecode ="";}
		if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
		{strbilldocnum = "";}
		if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
		{strbillpayableamt = "";}
		if ( strfacilityid == null || strfacilityid.equalsIgnoreCase("null")) 
		{strfacilityid = "";}
		if ( strpatientid == null || strpatientid.equalsIgnoreCase("null")) 
		{strpatientid = "";}
		if ( strepisodetype == null || strepisodetype.equalsIgnoreCase("null")) 
		{strepisodetype = "";}
		if ( strepisodeid == null || strepisodeid.equalsIgnoreCase("null")) 
		{strepisodeid = "";}
		if ( strvisitid == null || strvisitid.equalsIgnoreCase("null")) strvisitid = "";
		if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null"))  
		{strslmtpayername = "";}
		if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) strslmtidno = "";
		if ( struser == null || struser.equalsIgnoreCase("null")) struser = "";
		if ( strcashcounter == null || strcashcounter.equalsIgnoreCase("null")) 
		strcashcounter ="";

		called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";

		alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
		if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";

		strdfltcashbillslmtamt = request.getParameter("dfltcashbillslmtamt");
		if ( strdfltcashbillslmtamt == null || strdfltcashbillslmtamt.equalsIgnoreCase("null")) 
			strdfltcashbillslmtamt = "N";
		ext_acc_interface_yn = request.getParameter("ext_acc_interface_yn");
		if(ext_acc_interface_yn == null || ext_acc_interface_yn.equalsIgnoreCase("null")) ext_acc_interface_yn="N";
		
		addlChargeAmtForBill = request.getParameter("addl_charge_amt");
		if(addlChargeAmtForBill == null || "null".equals(addlChargeAmtForBill)){
			addlChargeAmtForBill = "";
		}
		
		
 	  try{
			pstmt = con.prepareStatement("select DONT_SETTLE_BY_SERV_YN from bl_parameters where  OPERATING_FACILITY_ID = ? "); //OPERATING_FACILITY_ID Added for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
			pstmt.setString(1,strfacilityid);
			rs = pstmt.executeQuery();					
			if(rs != null && rs.next()){
				String dontSettleByService = rs.getString(1);
				if(dontSettleByService==null || dontSettleByService.equals("N")){
				settleByService=true;
				}
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		try
		{		
		
			pstmt = con.prepareStatement("select decode(sign(?),'1', decode('E','O',nvl(op_applicable_ind,'N'),'E',nvl(op_applicable_ind,'N'),'R', nvl(REF_APPLICABLE_IND,'N')) ,'-1',decode('E','O',nvl(OP_REFUND_IND,'N'),'E',nvl(OP_REFUND_IND,'N'),'R', nvl(REF_REFUND_IND,'N')) ) op_ref_applicable,decode(sign(?),'1',nvl(change_receipt_amt_ind,'N'),'-1',nvl(CHANGE_REFUND_AMT_IND,'N')) op_ref_changea_amt_ind from  bl_cash_counter where cash_counter_code = ?  and operating_facility_id = ? ");
			
			pstmt.setString(1,strbillpayableamt);
			pstmt.setString(2,strbillpayableamt);
			pstmt.setString(3,strcashcounter);
			pstmt.setString(4,strfacilityid);			

			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strrcptallowedyn =  rs.getString(1);			
				strchangereceiptamtind =  rs.getString(2);			
			}
			else
			{
				strrcptallowedyn = "N";
				strchangereceiptamtind = "N";
			}		
			
			pstmt = null;
			rs = null;
			pstmt = con.prepareStatement("Select NVL(Bill_level_tax_yn,'N') Bill_level_tax_yn from bl_parameters");
			rs = pstmt.executeQuery();	
			if(rs != null && rs.next()){
				billLevelTax = rs.getString("Bill_level_tax_yn");
			}
			
			rs.close();
		pstmt.close();
		strrcptallowedyn="Y";
		strchangereceiptamtind="Y";
		}
		
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_cash_counter query:"+e);
		}
		
		if ( strrcptallowedyn == null || strrcptallowedyn.equalsIgnoreCase("null")) 
			strrcptallowedyn = "N";
		if (strchangereceiptamtind == null || strchangereceiptamtind.equalsIgnoreCase("null")) 
		    strchangereceiptamtind = "N";

		try	
		{		
			//pstmt = con.prepareStatement("select nvl(receipt_auth_yn,'N'), nvl(change_receipt_allowed_yn,'N') from bl_users_for_credit_auth where operating_facility_id = '" + strfacilityid + "' and credit_auth_user_id = '" + struser + "'");
			pstmt = con.prepareStatement("select decode(sign(?),'1',nvl(receipt_auth_yn,'N'),'-1',nvl(REFUND_AUTH_YN,'N')) receipt_refund_auth_yn, decode(sign(?),'1',nvl(change_receipt_allowed_yn,'N'),'-1',nvl(CHANGE_REFUND_ALLOWED_YN,'N')) rec_ref_change_allowed_yn from bl_users_for_credit_auth where operating_facility_id = ? and credit_auth_user_id = ? ");
			
			pstmt.setString(1,strbillpayableamt);
			pstmt.setString(2,strbillpayableamt);
			pstmt.setString(3,strfacilityid);
			pstmt.setString(4,struser);			
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strrcptallowedynuser =  rs.getString(1);				
				strchangereceiptalloweduser =  rs.getString(2);						
			}
			else
			{
				strrcptallowedynuser = "N";
				strchangereceiptalloweduser = "N";
			}
			rs.close();
			pstmt.close();
		}		
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_users_for_credit_auth query:"+e);
		}

		if (strrcptallowedynuser == null || strrcptallowedynuser.equalsIgnoreCase("null")) 
			strrcptallowedynuser = "N";
		if (strchangereceiptalloweduser == null || strchangereceiptalloweduser.equalsIgnoreCase("null")) 
		    strchangereceiptalloweduser = "N";	

		if(strrcptallowedyn.equals("Y") && strrcptallowedynuser.equals("Y"))
		{
			if(strdfltcashbillslmtamt.equals("Y"))
			{
				strslmtamt = strbillpayableamt;
			}

			if(strchangereceiptalloweduser.equals("Y") && strchangereceiptamtind.equals("Y"))
			{
				slmt_amt_disabled_YN="N";
			}
			else
			{
				//slmt_amt_disabled_YN="Y";
				//This Field makes the Settlement Amount Disabled. By Removing this Validation, it will be enabled always
				slmt_amt_disabled_YN="N"; // Quick Fix to make Similar to 2 Tier Application
			}
		}

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}
			rscurr.close();
		pstmt.close();
			}
			catch(Exception e)
			{    e.printStackTrace();
				System.out.println("3="+e.toString());
			}


            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(str_single_service_grp_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(str_acc_episode_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(str_acc_category_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(str_acc_serv_grp_used_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(str_service_grp));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(str_reln_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(str_single_service_grp_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(str_acc_episode_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(str_acc_category_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(str_acc_serv_grp_used_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(str_service_grp));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(str_reln_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(str_ext_dept_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block23Bytes, _wl_block23);

//String cash_slmt_flag = "";		
if( strslmttype == null) strslmttype="";
	try{
			
			for(BLBillDetailsBean billBean:billDetailList){
				if( billBean.getReceiptTypeCode()!=null && billBean.getReceiptTypeCode().equals("")){
					HashMap<String,String> extAccDetails=bean.extAccDetailsFetch(con, strfacilityid, billBean.getDocTypeCode(), billBean.getDocNum());
					billBean.setReceiptNature(extAccDetails.get("receipt_nature"));
					billBean.setReceiptTypeCode(BLHelper.getDescriptionViaSQL(con,BlRepository.getBlKeyValue("MULTI_BILL_SLMT_DFLT_RCPT_TYPE")));//extAccDetails.get("receipt_type_code")
					billBean.setExtAccCode(extAccDetails.get("ext_account_code"));
					billBean.setExtAccDept(extAccDetails.get("ext_dept_code"));
				}
			}
			System.out.println(billDetailList);
			
	
			
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block25Bytes, _wl_block25);


		}
		catch(Exception e )
			{
			 e.printStackTrace();
			out.println(e);
			} 



            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block38Bytes, _wl_block38);

	String drug_penalty_yn ="";
	double strdrugpenaltyamt =0.00;	
	
	
	
	String multiSlmtBeanId = "BLMultiBillSettlementBean";
	String multiSlmtBeanName = "eBL.BLMultiBillSettlementBean";
	BLMultiBillSettlementBean multiSlmtBean=(BLMultiBillSettlementBean) getBeanObject(multiSlmtBeanId, multiSlmtBeanName, request);

	HashMap<String,String> penaltyCharge=multiSlmtBean.getDrugPenaltyCharges(con,strfacilityid,docTypeCodeArray,docNumListArray);
	drug_penalty_yn=penaltyCharge.get("status");
	
    if(drug_penalty_yn.equals("Y"))
	{
    	strdrugpenaltyamt=Double.parseDouble(penaltyCharge.get("amount"));
		DecimalFormat df = new DecimalFormat("0.00");      
 	
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(df.format(strdrugpenaltyamt)));
            _bw.write(_wl_block41Bytes, _wl_block41);

	}	

            _bw.write(_wl_block42Bytes, _wl_block42);
	
		double remOutStnndAmt = 0.00;
		try{
			remOutStnndAmt = Double.parseDouble(strbillpayableamt) - Double.parseDouble(strslmtamt);			
		}
		catch(Exception e){
			remOutStnndAmt = 0.00;
		}

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strrectypedesc));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
 if(session.getAttribute("deposit_adjusted_payable_amount")!=null){
			strslmtamt=(String)session.getAttribute("deposit_adjusted_payable_amount") ;
			depositAdjustedIndicator=true;
		}
		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strslmtamt));
            _bw.write(_wl_block48Bytes, _wl_block48);

			if("MOHBR".equals(custId)){ 
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(remOutStnndAmt));
            _bw.write(_wl_block51Bytes, _wl_block51);
}
		

            _bw.write(_wl_block52Bytes, _wl_block52);
if(settleByService==true){ 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(allIncluded ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(allExcluded ));
            _bw.write(_wl_block55Bytes, _wl_block55);
} else{
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(allIncluded ));
            _bw.write(_wl_block57Bytes, _wl_block57);
} 
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(settleByService));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(str_ext_acc_facility_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(str_ext_account_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(str_ext_dept_ind));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(str_ext_dept_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(str_single_service_grp_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(str_service_grp));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_acc_episode_type));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(str_acc_serv_grp_used_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(str_acc_category_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(str_reln_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(strroundingamt));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(slmt_amt_disabled_YN));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(custId ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(addlChargeAmtForBill ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(billLevelTax ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(depositAdjustedIndicator));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(partSettled));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(blReceiptType ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(blRefundType ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(fromBillGen));
            _bw.write(_wl_block91Bytes, _wl_block91);

}catch(Exception e)
	{
	 e.printStackTrace();
	System.out.println("Exception in main detl="+e);}
	finally{					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
			}

            _bw.write(_wl_block92Bytes, _wl_block92);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_SLMT_DTL.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DownTimeEntry.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DocumentNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DocNoslash.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DepositDate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DepositReason.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillDetails.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_NO.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYABLE_AMT.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DrugPenalty.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECEIPT_TYPE.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SLMT_AMT.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OutstandingAmount.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECD_THRU_MAIL.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
