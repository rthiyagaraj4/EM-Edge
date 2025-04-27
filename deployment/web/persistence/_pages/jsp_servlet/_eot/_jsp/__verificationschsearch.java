package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.SlateBean;
import java.util.ArrayList;
import java.util.HashMap;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.HashMap;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import eOT.Common.OTRepository;
import java.net.URLDecoder;

public final class __verificationschsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/VerificationSchSearch.jsp", 1733927722000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html> \n<head>\n<title></title> \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/Tabs.css\"></link>\n\n<!--<script type=\"text/javascript\" src=\"../../eOT/js/common.js\"></script>-->\n<script language=\"Javascript\" src=\"../../eOT/js/Booking.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/BookingPatientSearch.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/WaitList.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script> \n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script src=\'../../eXH/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script language=\"Javascript\">\n\nfunction checkNumeric(obj){\n\tvar xx=0;\n\tvar strVal=obj.value;\n\tif(strVal.length==0) return false;\n\tfor(xx=0;xx<strVal.length;xx++)\n\tif(strVal.charAt(xx)<\'0\' || strVal.charAt(xx) >\'9\'){ \n\t\talert(getMessage(\"NUMERIC_ENTRY_ONLY\",\'OT\'));\n\t\tobj.value=\"\";\n\t\tobj.focus();\n\t\treturn false;\n\t }\n\t return true;\n}\t\nfunction checkValidation(objCheck){\n\tvar frmObj=document.forms[0];\n\tvar pos=objCheck.getAttribute(\'position\');\n\t\n\tvar serial_no =frmObj.serial_no.value;\n\tvar user_id=frmObj.user_id.value;\n\tvar next_stage_code=eval(\"frmObj.next_stage_code\"+pos+\".value\");\n\tvar to_stage_code=eval(\"frmObj.to_stage_code\"+pos+\".value\");\n//\teval(\"frmObj.to_stage_code\"+pos+\".value\")=objCheck.value;\n\tvar next_specific_ind=eval(\"frmObj.next_specific_ind\"+pos+\".value\");\n\tvar next_action_done=eval(\"frmObj.next_action_done\"+pos+\".value\");\n\tvar next_stage_desc=eval(\"frmObj.next_stage_desc\"+pos+\".value\");\n\tvar previlage=eval(\"frmObj.previlage\"+pos+\".value\");\n\tvar msg_1 = getMessage(\"APP-OT0071\",\"OT\");\n\tvar msgArray = msg_1.split(\"#\");\n\tvar not_done_msg = msgArray[0]+next_stage_desc+msgArray[1];\n\t//Added  [IN:048375]\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\t\t\txmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=booking_verifi_stage&req_stage_code=\"+to_stage_code+\"&serial_no=\"+serial_no,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText);\t\n\tvar comp = retVal.split(\"::\");\n\t//Added [IN:048375]\n   if(objCheck.value!=next_stage_code){\n\t  if(next_action_done==\'S\'){\n\t\t  alert(not_done_msg);\n\t\t  objCheck.value=\"\";\n\t  }\n\t  if(next_action_done==\'A\'){\n\t\t  alert(not_done_msg);\n\t  }   \n  }\n\t  if((previlage==\'N\' && comp[0]==\'SPC\')&&(comp[1]!=user_id)){\n\t\talert(getMessage(\"APP-OT0072\",\"OT\"));\n\t\tobjCheck.value=\"\";\n\t\t  }\n\n\t}\nfunction setInitValue(){\n\tvar frmObj=document.VerificationDtlForm; //Added for ML-MMOH-SCF-2410\n\t\n\tvar max=frmObj.maxno.value;\n\tvar maxno;\tvar pos;\n\tvar priority;\n//\talert(\"init value\");\n\n\tif (max!=\'\'&&max!=null){\n\t  maxno=parseInt(max,10);\n\t  for(pos=0;pos<=maxno;pos++){\n\t\tpriority=eval(\"frmObj.priority_code\"+pos);\n\t\treason_code=eval(\"frmObj.reason_code\"+pos);\n\t\tif(priority != null && priority != \'undefined\'&& priority !=\'\'){\n\t\t\tpriority.value=priority.DB_VALUE;\n\t\t}\n\t  }//end of for\n\t}//end of if\n\t}\n\nfunction getReArrangeSeqFlag_booking_veri()\n{\n\tvar formObj=parent.parent.frames[1].document.VerificationSearchForm;\n\tvar facility_id=formObj.facility_id.value;  \n\tvar sql=\"select RESEQUENCE_REASON_MANDATORY_YN from ot_param_for_facility where operating_facility_id=\'\"+facility_id+\"\' \";\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar xmlStr =\"<root></root>\";\n\tparam=\"flag=MED_SER&sql=\"+sql;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\", \"../../servlet/eOT.CommonQueryServlet?\"+param,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = localTrimString(xmlHttp.responseText);\n\treturn retVal;\n}\n\n    function validateReason_rear(){\n\n\t\tvar objForm=document.VerificationDtlForm;\n\t\t\n\t\tvar reason_flag=true;\n\t\t var seq; var reason;var bookingseqno;\n\t\tvar max_no=objForm.maxno.value;\n\t\tif (max_no!=null && max_no!=\'\'){\n\t\t\tmax_no=parseInt(max_no,10);\n\t\t\tfor(pos=0;pos<=max_no-1;pos++){\n\t\t\t\tseq=eval(\"objForm.seq_no\"+pos+\".value\");\n\t\t\t\tbookingseqno=eval(\"objForm.sequence_no\"+pos+\".value\");\n\t\t\t\treason = eval(\"objForm.reason_code\"+pos+\".value\");\n\n\t\t\t\tif((seq==\"\"|| seq==999) && reason!=\"\")\n\t\t\t\t{\n\t\t\t\t\treason=\"\";\n\t\t\t\t}\n\t\t\t\tif(  (seq!=999 && seq!=\"\" && reason!=\"\" ) || ( (seq==999 || seq==\"\") && reason==\"\" ) )  { \n\t\t\t\t\tcontinue;\n\t\t\t\t}else{\n\t\t\t\t\treason_flag=false;\n\t\t\t\tbreak;\n\t\t\t}\n\t\t}\n\t\treturn reason_flag;\n\t }\n   }\n\n \tfunction submitPrevNext(from, to)\n{\n\tdocument.forms[0].from.value = from;\n\tdocument.forms[0].to.value = to; \n\t\tif(confirm(getMessage(\'APP-OT0191\',\'OT\')))\n\t\t{\n\tvar submit_flag=false;\n\t\n\tvar msg_blank = getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\tvar msgArray = msg_blank.split(\"&\");\n\tvar msg = msgArray[0]+getLabel(\"Common.reason.label\",\"Common\")+\" \"+msgArray[1];\n\n\t\tvar formObj=parent.parent.frames[1].document.VerificationSearchForm;\n\t\n\tvar re_arange_seq_flag=getReArrangeSeqFlag_booking_veri();\n\tif(formObj.chk_sequence.checked==true && re_arange_seq_flag==\"Y\"){\n\t\t\tif(validateReason_rear()==false){\n\t\t\t\tsubmit_flag=false;\n\t\t\t}else{\n\t\t\t\tsubmit_flag=true;\n\t\t\t}\n\t}else{\n\t\tsubmit_flag=true;\n\t}\n\t\n\tvar objForm1=document.VerificationDtlForm;\n\n\t\tif(objForm1!=null)\n\t{\n\t\t var stagecode; \n\t\tvar max_no=objForm1.maxno.value;\n\t\tvar from=objForm1.from.value;\n\t\tvar to=objForm1.to.value;\n\t\t\nif(formObj.chk_sequence.checked==false)\n\t{\n\t\tif (from!=\'\'&&from!=null){\n\t\t\tmax_no=parseInt(max_no);\n\t\t\tfrom=parseInt(from-1);\n\t\t\tto=parseInt(to-1);\n\n\t\t\tfor(pos=0;pos<max_no-1;pos++){\n\t\t\t\tvar stagecode=eval(\"objForm1.to_stage_code\"+pos+\".value\");\n\t\t\t\tvar stageFinalizationCode=eval(\"objForm1.finalizationcode\"+pos+\".value\");\n\t\t\t\tvar facilityid=eval(\"objForm1.facilityid\"+pos+\".value\");\n\t\t\t\t\n\t\t\t\tvar patient_id=eval(\"objForm1.patient_id\"+pos+\".value\");\n\t\n\t\t\t\tvar order_id=eval(\"objForm1.order_id\"+pos+\".value\");\n\t\t\t\t\t\t\t\n\t\t\t\tvar booking_num=eval(\"objForm1.booking_num\"+pos+\".value\");\n\t\t\n\t\t\t\tif(stagecode==stageFinalizationCode)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\tvar temp_jsp=\"BookingValidation.jsp?booking_no=\"+booking_num+\"&facility_id=\"+facilityid+\"&patient_id=\"+patient_id+\"&mode=insert\"+\"&orderid=\"+order_id;\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar resText =trimString1(xmlHttp.responseText);\n\t\t\t\t\t\n\t\t\t\t\tvar pt_array  = resText.split(\"##\");\n\t\t\t\t\tif(pt_array[0]==\"E\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\talert(pt_array[2]);\n\t\t\t\t\t\t\talert(pt_array[3]);\n\t\t\t\t\t\t\tsubmit_flag=false;\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\tif(pt_array[0]==\"S\" && pt_array[1]==\"S\")\n\t\t\t\t\t{\n\t\t\t\t\t\talert(pt_array[2]);\n\t\t\t\t\t\tsubmit_flag=false;\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\n\t\t\t\t\t\n\t\t\t\t\tif(pt_array[0]==\"S\" && pt_array[1]==\"O\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(window.confirm(pt_array[2]))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tsubmit_flag=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tsubmit_flag=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(pt_array[0]==\"S\" && pt_array[1]==\"A\")\n\t\t\t\t\t{\n\t\t\t\t\t\tsubmit_flag=true;\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\tif(pt_array[0]==\"S\" && pt_array[1]==\"M\")\n\t\t\t\t\t{\n\t\t\t\t\t\talert(pt_array[2]);\n\t\t\t\t\t\tsubmit_flag=true;\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\n\t\t\t\tif(submit_flag==false)\n\t\t\t\t{\n\t\t\t\t\tmsg=\"\";\n\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t}\n\t\tif(submit_flag==true){\n\t\n\t\tvar objForm=document.VerificationDtlForm;\n\t\tvar xmlStr= collectAllDetails(objForm);\n\t\tvar xmlDoc=\"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\txmlStr=\"<root>\"+xmlStr;\n\t\txmlStr+=\"</root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\tif(xmlStr.indexOf(\"<root></root>\")!=-1){\n\t\tvar msg1 = getMessage(\"NO_CHANGE_TO_SAVE\",\"Common\");\n\t\tmessageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg1;\n\t\treturn;\n\t    }\n\t\txmlHttp.open(\"POST\", \"../../servlet/eOT.BookingServlet\", false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar resTxt=xmlHttp.responseText;\n\t\tvar objf=parent.parent.parent.parent.frames[2].document.forms[0];\n\t\t\tparent.parent.parent.frames[0].document.location.href=objf.qury.value;\n\t\t\tparent.parent.frames[2].document.location.href=\"../../eOT/jsp/VerificationSchSearch.jsp?\"+objForm.param1.value;\n\t\t\n\t\tvar msg_inserted = getMessage(\"RECORD_INSERTED\",\"SM\");\n\t\tparent.parent.parent.frames[2].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg_inserted;\t\n\t}else\n\t\t{\n\t\t\tmessageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;\n\t\t}\n\n\t}else\n\t{\n\n\t}\n\t\t}else\n\t\t{\n\t\t\t\tvar frmObj=document.forms[0];\n\tif(frmObj.surgeon_code.value==\'*ALL\') frmObj.surgeon_code.value=\'\';\n\tif(frmObj.room_code.value==\'*ALL\') frmObj.room_code.value=\'\';\n\tvar locale = frmObj.locale.value;\n    var theatre_date=dateUtils(frmObj.theatre_date.value,locale);\n\tvar booking_stage=frmObj.booking_stage.value;\n\tvar seq = (frmObj.chk_sequence.checked==true) ?\"Y\":\"N\"\n\tvar param=\'room_code=\'+frmObj.room_code.value+\'&chk_sequence=\'+seq+\"&theatre_date=\"+theatre_date+\"&speciality_code=\"+frmObj.speciality_code1.value+\"&surgeon_code=\"+frmObj.surgeon_code.value+\"&theatre_type_code=\"+frmObj.theatre_type_code.value+\"&surgery_type=\"+frmObj.surgery_type.value+\"&from=\"+from+\"&to=\"+to+\"&booking_stage=\"+booking_stage;\n\n\tparent.parent.frames[2].location.href = \'../../eOT/jsp/VerificationHdrFrame.jsp?\'+param;\t\n\tparent.parent.frames[3].location.href=\'../../eOT/jsp/VerificationColorInd.jsp\';\n\t\n\t\t}\n}\n\nfunction submitPrevNext_emer(from, to)\n{\n\n\tdocument.forms[0].from.value = from;\n\tdocument.forms[0].to.value = to; \n\n\tvar frmObj=document.forms[0];\n\tif(frmObj.surgeon_code.value==\'*ALL\') frmObj.surgeon_code.value=\'\';\n  //  var theatre_date=frmObj.theatre_date.value;\n    var facility_id=frmObj.facility_id.value;\n\tvar locale = frmObj.locale.value;\n\tvar sql=\"SELECT PATIENT_ID, (select  decode( \'\"+locale+\"\',\'en\',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = A.PATIENT_ID) PATIENT_NAME, OPER_DESC SPECIALITY_DESC,BOOKING_NUM, SURGEON_NAME, SURGERY_TYPE, TRUNC(SYSDATE - WAITLIST_DATE) WAITLISTED_DAYS,ORDER_ID,WAITLIST_NUM,TO_CHAR(PREFERRED_DATE,\'DD/MM/YYYY\') PREFERRED_DATE ,TO_CHAR(WAITLIST_DATE,\'DD/MM/YYYY HH24:MI\') WAITLIST_DATE, NVL2(BOOKING_NUM,\'Assigned\',\'Unassigned\') STATUS, TO_CHAR(BOOKING_DATE,\'DD/MM/YYYY\') BOOKING_DATE, THEATRE_DESC, TO_CHAR(BOOKING_START_TIME,\'HH24:MI\') BOOKING_START_TIME FROM OT_WAITLIST_VW A WHERE OPERATING_FACILITY_ID= \'\"+facility_id+\"\' AND NATURE_TYPE=\'EM\' AND LANGUAGE_ID=\'\"+locale+\"\'\" ;\n\tvar where=\"\";\n\tif(isNull(frmObj.view.value)==false && frmObj.view.value==\"A\"){\n\t\twhere+=\"AND (BOOKING_NUM IS NULL OR (BOOKING_NUM IS NOT";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 =" NULL AND TRUNC(BOOKING_DATE) = TRUNC(SYSDATE)))\";\n\t}\n\t\n\tif(isNull(frmObj.view.value)==false && frmObj.view.value==\"U\"){\n\t\twhere+=\" AND BOOKING_NUM IS NULL\";\n\t}\n\tif(isNull(frmObj.view.value)==false && frmObj.view.value==\"S\"){\n\t\twhere+=\"  AND BOOKING_NUM IS NOT NULL AND TRUNC(BOOKING_DATE) = TRUNC(SYSDATE)\";\n\t}\n\n\tif(isNull(frmObj.speciality_code.value)==false)\t \t \t\n\twhere+=\" AND SPECIALITY_CODE =\'\"+frmObj.speciality_code1.value+\"\'\";\n\n\tif(isNull(frmObj.surgeon_code.value)==false)\t \t\n\t\twhere+=\" AND SURGEON_CODE =\'\"+frmObj.surgeon_code.value+\"\'\";\n\n\tif(isNull(frmObj.surgery_type.value)==false)\t \t \t\n\t\twhere +=\"  AND  NATURE_CODE =\'\"+frmObj.surgery_type.value+\"\'\";\n\n\tsql+=where;  \n\tvar param=\'sql=\'+sql+\'&from=\'+from+\'&to=\'+to+\'&waitlistkey=YES\';\n\n\n\tparent.parent.frames[2].location.href = \'../../eOT/jsp/VerificationHdrFrame.jsp?\'+param;\t\n}\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onLoad=\'setInitValue()\'>\n<!--<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>-->\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n<form name=\"VerificationDtlForm\" id=\"VerificationDtlForm\">\n";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\n\t<table width=\'100%\' border=\'0\' align=\'center\' >\n\t\t<tr>\n\t\t<td width=\'20%\' align=\'right\' class=\'NONURGENT\'>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =",";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")\' id=\'prev\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =")\' id=\'next\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a><input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\n\t</td>\n\t </tr>\n\t\t</table>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n<table class=\'grid\' border=\'1\' width=\'100%\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\'>\n\t<tr>\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t<!-- Added by MuthuN CHL-CRF-0014 starts -->\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t<!-- Added by MuthuN CHL-CRF-0014 ends -->\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\t\t\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th> <!-- newly added CRF 0021  -->\n\t\t\t\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" \n\t\t<table class=\'grid\' border=\'1\' width=\'100%\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' >\n\t\t<tr>\n\t\t\t<th class=\'columnHeader\' nowrap >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th> <!-- newly added CRF 0021  -->\n\t\t\t\n\t\t\t\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n      <input type=\'hidden\' name=\'patsexdob";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'patsexdob";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t   <input type=\'hidden\' name=\'proc_desc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'proc_desc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t   \n\t\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\n\t\t<input type=\"hidden\" name=\"order_status_text_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"order_status_text_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\n\t\t<input type=\"hidden\" name=\"patient_id_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"patient_id_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\n\t\t<!--<td style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =";background-color:";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\n\t\t<img src=\'../../eOT/images/drugInfo.gif\' onmouseover=\"Tip(indicatorToolTip(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\" onmouseout=\"UnTip()\">\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>-->\n\n\t\t<!--Modified by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012f-->\n\t\t<td style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\n\t\t<img src=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' onmouseover=\"Tip(indicatorToolTip(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\" onmouseout=\"UnTip()\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\n\t\t<td width=\'\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' style=\'cursor:pointer\' class=\'gridDataBlue\' onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',this,\'imgArrow";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\')\"  \n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" width=\'13%\' ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" width=\'18%\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" \' \n\t\t><a href=\"#\" style=\"color: blue; text-decoration: underline;\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</a><img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t<input type=\"hidden\" name=\"order_status_text_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<td style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t<td width=\'\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\')\"\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" width=\'16%\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="    onMouseOver=\'hidemenu();\'>\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\t\n\t\t\n\n\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n</td>\n\n\t\t\n\t\t<td width=\'15%\' style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" nowrap>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\n\t\t\n\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\n\t\t<!-- Start CRF-0014-->\n\t\t\t<td width=\'8%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t</td>\n\t\t\t<!-- End -->\n\t\t\t<td  width=\'15%\' style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\t\n\t\t\t\n\t\t\t<td width=\'15%\' style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t</td>\n\t\t\t<td  class=\"gridData\" style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" ><img src=\'../../eOT/images/drugInfo.gif\' onmouseover=\"Tip(reasonToolTip(\'proc_desc\',";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =") )\" onmouseout=\"UnTip()\">\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" </td>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t<td width=\'5%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" >\n\t\t\t\t<select name=\'to_stage_code";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'to_stage_code";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' position=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" OnChange=\"checkValidation(this);\" ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" >\n\t\t\t\t<option name=\'\' value=\'\'>&nbsp;</option>\n\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t</select>\n\t\t\t\t</td>\n\n\n\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t<td class=\"gridData\" width=\'12%\' style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t</td>\n\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\n\t\t\t\t\t<td  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" width=\"3%\" >\n\t\t<select name=\'priority_code";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' id=\'priority_code";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' DB_VALUE=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" >\n\t\t<option name=\'\' value=\'\'></option>\n\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t</select>\t\t\t\t\n\t</td>\n\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\n\n\t\t\t<td  width=\'11%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\n\t\t\t<td width=\'8%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t</td>\n\t\t\t\t<!-- Start CRF-0021-->\n\t\t\t<td width=\'8%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t</td>\n\t\t\t<!-- End -->\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" \n\t\t\t\t\n\t\t\t<td width=\'8%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t</td><!-- Added for 44637 -->\n\t\t\t<td  width=\'12%\' style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" >\n\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t<td width=\'5%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"  >\n\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t</td>\n\n\t\t\t\t <td  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =") )\" onmouseout=\"UnTip()\">\n\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" \n\t\n\t\t\t</td> \n\t\t\t<td width=\'11%\' style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" nowrap>\n\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t<td  width=\"7%\" style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" >\n\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t<input type=\'text\' name=\'seq_no";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' id=\'seq_no";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' class=\'label\' size=\'3\' maxlength=\'3\' DB_VALUE=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" position=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" value=\"\" ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="  OnBlur=\"checkNumeric(this);\">\n\t</td>\n\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\n\n\t\t</select>\n\t\t</td>\n\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t<td  width=\"18%\"  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"  nowrap>\n\t\t<input type=\'hidden\' name=\'reason_code";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' id=\'reason_code";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' class=\'label\' DB_VALUE=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' value=\'\'>\n\t\t<input name=\'reason_desc";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' id=\'reason_desc";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'  position=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" size=\'15\' maxlength=\'250\' value=\"\" onBlur=\"if(this.value!=\'\')return searchreason(reason_desc";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =",reason_code";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =");else reason_code";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =".value=\'\'\">\n\n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'surButton\' id=\'surButton\'   onClick=\" return searchreason(reason_desc";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =");\" >\n\t</td>\n\n<td width=\'7%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t</td>\n\t\t\t<td  width=\'8%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t</td>\n\t\t\t\t<!-- Added for 44637 -->\n\t\n\t\t\t<td width=\'8%\'  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t</td>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\n\n\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t<input type=\"hidden\" name=\"next_stage_code";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" id=\"next_stage_code";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\"hidden\" name=\"next_specific_ind";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" id=\"next_specific_ind";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\"hidden\" name=\"next_action_done";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" id=\"next_action_done";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"> \n\t<input type=\"hidden\" name=\"next_stage_desc";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" id=\"next_stage_desc";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"> \n    <input type=\"hidden\" name=\"previlage";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"previlage";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t<input type=\"hidden\" name=\"from_stage_code";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" id=\"from_stage_code";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" id=\"order_id";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" id=\"patient_id";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t<input type=\"hidden\" name=\"room_code";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" id=\"room_code";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"> \n\t<input type=\"hidden\" name=\"booking_num";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" id=\"booking_num";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"> \n\t<input type=\"hidden\" name=\"sequence_no";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" id=\"sequence_no";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"> \n  \t<input type=\"hidden\" name=\"booking_date";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" id=\"booking_date";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"> \n  \t<input type=\"hidden\" name=\"finalizationcode";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" id=\"finalizationcode";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"> \n  \t<input type=\"hidden\" name=\"stageFinalizationCode\" id=\"stageFinalizationCode\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"> \n  \t<input type=\"hidden\" name=\"facilityid";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" id=\"facilityid";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\"> \n  \t<input type=\"hidden\" name=\"facility_ids\" id=\"facility_ids\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\"> \n\t<input type=\"hidden\" name=\"seq_change_yn";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" id=\"seq_change_yn";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\"> \n\t</tr>\n\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n\t\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n\t\t\t\t\t\n\n\t\t<table width=\'100%\' border=\'0\' align=\'center\' >\n\t\t<tr>\n\t\t<td width=\'20%\' align=\'right\' class=\'NONURGENT\'>\n\t\t";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t<a href=\'javascript:submitPrevNext_emer(";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</a>\n\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</a><input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\n\t</td>\n\t </tr>\n\t</table>\n\t\t<table class=\'grid\' border=\'1\' width=\'100%\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\'>\n<tr nowrap>\n\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="</th>\n\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</th>\t\t\n\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</th>\t\n\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</th>\n\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n<tr>\n<!-- ***IMPORTANT NOTE:-- on click of displaytooltip, assignment and references  of these values is different in related java script function.. .the names assigned here will not match with the java script fucnction..***-->\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t<td class=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" style=\"font-size:7pt;font-weight:normal;\"  nowrap>\n\t\t<input type=\"hidden\" name=\"order_status_text_";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t\t<img src=\'../../eOT/images/drugInfo.gif\' \n\t\tonmouseover=\"Tip(indicatorToolTip(\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'),HEIGHT,-100,FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',FONTCOLOR,\'#CCFFCC\',STICKY,true,CLICKCLOSE,true)\"\n\t\tonmouseout=\"UnTip()\"> \n\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t</td>\n\t<td width=\'\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\' style=\'cursor:pointer\' class=\'gridDataBlue\'  onClick=\"displayToolTipEmergency(\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\',\'WAIT\',\'\',\n\t\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\')\"  \n\t width=\'15%\'   onMouseOver=\'hidemenu();\'>";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'>\n</td>\n";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n<td class=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" style=\"font-size:7pt;font-weight:normal\"  nowrap>\n\t\t<input type=\"hidden\" name=\"order_status_text_";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\n\t\t<img src=\'../../eOT/images/drugInfo.gif\' \n\t\tonmouseover=\"Tip(indicatorToolTip(\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'),HEIGHT,-100,FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',FONTCOLOR,\'#CCFFCC\',STICKY,true,CLICKCLOSE,true)\"\n\t\tonmouseout=\"UnTip()\"> ";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t</td>\n\n\t<td width=\'\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' style=\'cursor:pointer\' class=\'gridDataBlue\' onClick=\"displayToolTip4(\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\',\'WAIT\',this,\'imgArrow";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\')\"  width=\'40%\'   onMouseOver=\'hideToolTip1();\'>";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'>\n\n\t\n</td>\n";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\n\t\t<td class=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" width=\'15%\'  nowrap>";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="</td>\n\n<input type =\"hidden\" name=\'proc_desc";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" >\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n<td nowrap class=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" width=\'15%\' ><img src=\'../../eOT/images/drugInfo.gif\' onmouseover=\"Tip(reasonToolTip(\'proc_desc\',";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 =") )\" onmouseout=\"UnTip()\">\n<!--removed URI decode for ML-BRU-SCF-1401  start-->\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n</td>\n<td class=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" width=\'14%\' nowrap >\n";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" width=\'11%\'>\n";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n</td>\n<!--removed URI decode for ML-BRU-SCF-1401 end-->\n<td class=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" width=\'11%\'>";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</td>\n<td class=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" width=\'11%\' nowrap>";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="</td>\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\n\t<td class=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" width=\'11%\' style=\"font-size:7pt;font-weight:normal;color:red\" nowrap><img src=\'../../eOT/images/drugInfo.gif\' OnMouseOver=\"reasonToolTip3(\'reason\',";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =")\" onMouseOut=\"hidemenu();\" >";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\n\t</td>\n";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t<td class=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" width=\'11%\' >";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n<tr>\t\t\n\t<input type=\"hidden\" name=\"booking_num";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n\t<input type=\"hidden\" name=\"waitlist_num";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" id=\"waitlist_num";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\"> \n\n";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\n<input type=\'hidden\' name=\'chk_sequence\' id=\'chk_sequence\' value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n<input type=\'hidden\' name=\'param1\' id=\'param1\' value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\">\n<input type=\'hidden\' name=\'waitlist_key_dtl\' id=\'waitlist_key_dtl\' value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n<input type=\'hidden\' name=\"maxno\" id=\"maxno\" id=\"maxno\" value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\">\n<input type=\'hidden\' name=\'test\' id=\'test\' value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n<input type=\'hidden\' name=\'hidden_surgeon_code\' id=\'hidden_surgeon_code\' value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n<input type=\'hidden\' name=\'surgeon_code\' id=\'surgeon_code\' value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n<input type=\'hidden\' name=\'stages1\' id=\'stages1\' value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">   <!-- Added crf - 0021 -->\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">   <!-- Added crf - 0014 -->\n<input type=\'hidden\' name=\'surgery_type\' id=\'surgery_type\' value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">\n<input type=\'hidden\' name=\'speciality_code1\' id=\'speciality_code1\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\n<input type=\'hidden\' name=\'view\' id=\'view\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n<input type=\'hidden\' name=\'room_code\' id=\'room_code\' value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\n<input type=\'hidden\' name=\'theatre_date\' id=\'theatre_date\' value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n<input type=\'hidden\' name=\'booking_stage\' id=\'booking_stage\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n<input type=\'hidden\' name=\'theatre_type_code\' id=\'theatre_type_code\' value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n<input type=\'hidden\' name=\'Hidn_enc_id_check\' id=\'Hidn_enc_id_check\' value=";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 =">\n<input type=\'hidden\' name=\'preferred_from\' id=\'preferred_from\' value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n<input type=\'hidden\' name=\'preferred_to\' id=\'preferred_to\' value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n<input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n<input type=\'hidden\' name=\'serial_no\' id=\'serial_no\' value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n</table>\n\n";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\'>\n<input type=\'hidden\' name=\'customer_name\' id=\'customer_name\' value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\"> <!-- Added for IN:41808 -->\n</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:80%; top:9px; visibility:hidden;\' bgcolor=\'blue\'></div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );
 
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

 public static String encode(String data){	  
	  byte byteData[] = data.getBytes();
	  String outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
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
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String locale = ((String)session.getAttribute("LOCALE"));          

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

	String chk_sequence = checkForNull(request.getParameter("chk_sequence"));
	String roomCode=checkForNull(request.getParameter("room_code"));
	String waitlistkey=checkForNull(request.getParameter("waitlistkey"));
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;
	String sql="",strPatientId="",strPatientName="",strTheatreDesc="",strBookingDate="",strBookingStatus="",surgery_type="",waitlisted_days="",waitlisted_date="",preferred_date="",waitlist_num="",status="",booking_date="",theatre_desc="",booking_start_time="",strApptFromTime="",strSpecialityDesc="",strSurgeonName="",strCurStage="",strPacStageYN="",strBookingSeq="",strPriorityCode="",strSerialNo="",strBookingNum="",strRoomCode="",strStageCode="",strSeqCheck="",strDisable="",strDisable1="",strOrderId="",strSex="",strDOB="",strReasonCode="",reason_code_1="",strNextStageCode="",strNextSpecificInd="",strNextActionDone="",strNextStageDesc="",strUserPrevilage="",stageFinalizationCode="",strPacYN="",strSurgeonCode="",strSpecialityCode="",oper_status="",oper_status_desc="",reason_description="",proc_description="",strEncounterId="",current_locn="",room_bed_no="",curr_locn="",roomNo="",bed_no="",order_status_text = "",strOper_desc = "";
	int count_oper=0;
	String user_id = (String)session.getValue("login_user");
   	String assignTheatre =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AssignedTheatre.Label","ot_labels");
	String assignDate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels");
	String assignTime = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AssignedTime.Label","ot_labels");
	String facilityid  = (String) session.getValue("facility_id");
	String user_id1  = (String) session.getValue("login_user");
	String theatre_date = request.getParameter("theatre_date");
	String booking_stage = request.getParameter("booking_stage");
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String patient_id = checkForNull(request.getParameter("patient_id"));//MO-CRF-20082
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String room_code = checkForNull(request.getParameter("room_code"));
	String theatre_type_code = checkForNull(request.getParameter("theatre_type_code"));
	String surgerytype = checkForNull(request.getParameter("surgery_type"));
	strSeqCheck=checkForNull(request.getParameter("chk_sequence"));
	String stages1 = checkForNull(request.getParameter("stages1"));		//crf-0021
	String patient_class = checkForNull(request.getParameter("patient_class")); //crf-0014
	String view = checkForNull(request.getParameter("view"));
	String seq = checkForNull(request.getParameter("seq"));
	String empty="".intern();
	String customer_id1="";// Added for IN:41808
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
//    String asaScoreCode = "";
	//Anitha Added on 12/17/2010
	String patientid = checkForNull(request.getParameter("patientid"));//MO-CRF-20082
	String preferred_from = checkForNull(request.getParameter("preferred_from"));
	String preferred_to = checkForNull(request.getParameter("preferred_to"));

	StringBuffer staus_times;

	StringBuffer proc_desc = new StringBuffer();
	StringBuffer show_proc = new StringBuffer();
	StringBuffer emr_proc_desc=new StringBuffer();
	StringBuffer where_cond = new StringBuffer();
	String bean_id	 = "SlateBean";
	String bean_name = "eOT.SlateBean";
	SlateBean bean	 = (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String req_start = "", req_end = "";
		int start = 0 ;
		int end = 0 ;
		int s=0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	{

		if(chk_sequence.equals("Y"))
		{
			end=300;

		}else
		{
	  	end = 50 ;

		}
	}
	else
	{
		end = Integer.parseInt( to ) ;
	}

		req_start       =   (request.getParameter("start")==null)?"0" :   request.getParameter("start");
		req_end         =   (request.getParameter("end")==null)?"0" :   request.getParameter("end");

	HashMap all_scheduled_case_details = bean.getScheduledCases();
	HashMap scheduled_case_details=new HashMap();
	StringBuffer sb_oper_desc = new StringBuffer();
	String operationsProcedures_value=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
	sb_oper_desc.append(operationsProcedures_value);
	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;
	PreparedStatement pstmt4=null;
	PreparedStatement pstmt5=null;
	PreparedStatement pstmt6=null;
	PreparedStatement pstmtreason=null;
	PreparedStatement pstmt7=null;
	PreparedStatement pstmt_locn_room_bed=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs_locn_room_bed=null;
	sql=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT1");
	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
	PreparedStatement pstmt8 = null;
	ResultSet rst3 = null;
	String Disp_Image="";
	//String Text_Image_color="";
	try{		
			conn = ConnectionManager.getConnection(request);
			pstmt=conn.prepareStatement(sql_sm_report); // Added for IN:41808
			rs=pstmt.executeQuery();
			if(rs !=null && rs.next())
			{
			customer_id1=checkForNull(rs.getString("customer_id"));
			}	
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();// End for IN:41808
            //Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
			pstmt8 =conn.prepareStatement("SELECT * from PR_HIGH_RISK_CONDITION where PATIENT_ID=? AND CLOSE_DATE IS NULL");
	
		String 	classvalue=empty;
		HashMap hashIndColor=new HashMap();
		HashMap hashTxtColor=new HashMap();
		String color_ind = "",text_color = "",sql1="",sql2="",sql3="",sql4="",sql5="";
		String sql_status="SELECT STATUS_DESC FROM OT_STATUS_LANG_VW WHERE STATUS_CODE=? AND LANGUAGE_ID='"+locale+"' ";
		PreparedStatement pstmtstatus=conn.prepareStatement(sql_status);
		String sqlreason1="SELECT REASON_DESC,REASON_CODE FROM OT_REASONS_LANG_VW WHERE REASON_CODE = ? AND LANGUAGE_ID='"+locale+"' ";

		pstmtreason=conn.prepareStatement(sqlreason1);
		int i=0;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,locale);
		rs= pstmt.executeQuery();
		while (rs.next()){
			strStageCode=rs.getString("STAGE_CODE1");
			color_ind	= empty+rs.getString("COLOR_IND1");
			text_color	= empty+rs.getString("TEXT_COLOR1");
			hashIndColor.put(strStageCode,color_ind);
			hashTxtColor.put(strStageCode,text_color);
	   }

	   rs.close();
	   pstmt.close();

		if(waitlistkey.equals(empty)){
			//Query moved from booking.js

					sql ="SELECT A.PATIENT_ID PATIENT_ID1,A.BOOKING_STATUS BOOKING_STATUS1,A.ORDER_ID ORDER_ID1, decode( '"+locale+"' ,'en',nvl(b.patient_name,b.patient_name_loc_lang), nvl(b.patient_name_loc_lang,b.patient_name)) PATIENT_NAME1,B.SEX SEX1,to_char(B.DATE_OF_BIRTH,'dd/mm/yyyy') DOB1,C.SHORT_DESC THEATRE_DESC1,to_char(A.APPT_DATE,'dd/mm/yyyy') APPT_DATE1,to_Char(A.APPT_FROM_TIME,'hh24:mi') APPT_FROM_TIME1,D.SHORT_DESC SPECIALITY_DESC1,DECODE(SURGEON_CODE,NULL,NULL,E.SHORT_NAME) SURGEON_NAME1,F.STAGE_CODE STAGE_CODE1,F.POST_STAGE_DESC CUR_STAGE_DESC1,F.SERIAL_NO SERIAL_NO1,NVL(F.PAC_STAGE_YN,'N') PAC_STAGE_YN1,G.PRIORITY_DESC PRIORITY_DESC1,G.PRIORITY_CODE PRIORITY_CODE1,A.BOOKING_SEQUENCE BOOKING_SEQUENCE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1,A.APPT_REF_NUM  BOOKING_NUM1,A.SEQ_CHNG_REASON_CODE REASON_CODE,A.SURGEON_CODE SURG_CODE,A.PRIMARY_SPECIALITY_CODE SPLTY_CODE,A.OPER_STATUS OPER_STATUS1,OT_PAT_CURR_LOCATION (A.OPERATING_FACILITY_ID,NULL,A.APPT_REF_NUM,NULL,'"+locale+"') current_locn,h.long_desc oper_desc,a.asa_score_code,i.patient_class FROM OT_QUEUE A,MP_PATIENT B,OT_OPER_ROOM_LANG_VW C,AM_SPECIALITY_LANG_VW D,ot_booking_hdr i,(SELECT x.language_id, x.practitioner_id,x.PRACTITIONER_NAME short_name FROM am_practitioner_lang_vw x WHERE x.language_id = ? and x.practitioner_id	<>'*ALL'	UNION SELECT language_id, '*ALL' practitioner_id, 'All' short_name FROM sm_language Where language_id='"+locale+"')  E,OT_BOOKING_FIN_STAGES F,OT_BOOKING_PRIORITY G,OT_OPER_MAST_LANG_VW H  WHERE D.LANGUAGE_ID=? AND E.LANGUAGE_ID=?  AND C.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID= ?  AND A.APPT_YN = 'Y'  AND A.APPT_DATE = TO_DATE(?,'DD/MM/YYYY') AND (?= '*A' OR BOOKING_STAGE= ?) AND A.PATIENT_ID = B.PATIENT_ID AND  A.OPER_STATUS <> '99'  AND A.BOOKING_STATUS <> '9' AND  a.PRIMARY_OPER_CODE = h.oper_code AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.OPER_ROOM_CODE = C.OPER_ROOM_CODE AND A.PRIMARY_SPECIALITY_CODE= D.SPECIALITY_CODE  	 AND NVL(A.SURGEON_CODE,'*ALL')	= E.PRACTITIONER_ID  AND A.BOOKING_STAGE	= F.STAGE_CODE and a.booking_priority_code = g.priority_code (+) and h.language_id ='"+locale+"' and a.order_id = i.order_id and i.CANCELLATION_DATE is NULL" ;  // added asa_score_code for crf-0021 and [IN:045158] 

			if(! "".equals(speciality_code)){
				where_cond.append(" AND INSTR(NVL(A.ALL_SPECIALITY_CODES,A.PRIMARY_SPECIALITY_CODE),'#"+speciality_code+"#')>0");
			}
			if(!patient_class.equals("")){ 				//crf-0014
			 patient_class=patient_class.toUpperCase();
				where_cond.append("  AND i.patient_class ='"+patient_class+"'");
			}
			
			if(! "".equals(surgeon_code)){
				where_cond.append(" AND A.SURGEON_CODE ='"+surgeon_code+"'");
			}
			//MO-CRF-20082 START
			if(! "".equals(patient_id)){
							where_cond.append(" AND A.PATIENT_ID ='"+patient_id+"'");
			}
			//MO-CRF-20082 END
			if(! "".equals(room_code)&& "".equals(theatre_type_code)){
				where_cond.append(" AND A.OPER_ROOM_CODE ='"+room_code+"'");
			}
			
			if(! "".equals(theatre_type_code)&& "".equals(room_code)){
				where_cond.append(" AND A.OPER_ROOM_CODE IN (SELECT OPER_ROOM_CODE  FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID='"+facilityid+"'   AND THEATRE_TYPE ='"+theatre_type_code+"')");
			}
            if(! "".equals(room_code)&& !"".equals(theatre_type_code)){
				where_cond.append(" AND A.OPER_ROOM_CODE ='"+room_code+"' AND C.THEATRE_TYPE = '"+theatre_type_code+"' ");
			}

			if(! "".equals(surgerytype)){
				where_cond.append("  AND A.APPT_REF_NUM IN (SELECT BOOKING_NUM FROM OT_BOOKING_HDR WHERE NATURE_CODE ='"+surgerytype+"')");
			}
			if(!stages1.equals("")){  //crf-0021
			 stages1=stages1.toUpperCase();
				where_cond.append("  AND a.ASA_SCORE_CODE ='"+stages1+"'");
			} 
			if( "Y".equals(seq)){
				where_cond.append(" ORDER BY  BOOKING_SEQUENCE1");
			} else {
				where_cond.append(" ORDER BY  APPT_FROM_TIME1,SERIAL_NO1");
			}

			//where_cond.append(order_by);

			sql+=where_cond.toString();

			where_cond.setLength(0);
			strStageCode=checkForNull(request.getParameter("stage_code"));
			sql2=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT3");
			pstmt2=conn.prepareStatement(sql2);
			
			pstmt2.setString(1,locale);
			sql3=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT5");
			pstmt3=conn.prepareStatement(sql3);
			sql4="SELECT 'X' FROM OT_BOOKING_FIN_STAGES_DTL WHERE STAGE_CODE = ? AND FACILITY_ID = ? AND APPL_USER_ID=?"; 
			pstmt4=conn.prepareStatement(sql4);
			sql5=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT2");	
			pstmt5=conn.prepareStatement(sql5);
		
			String sql6="SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW WHERE NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('SC')  AND NVL(ACTIVE_YN,'N')='Y')  AND LANGUAGE_ID='"+locale+"' ";
			pstmt6=conn.prepareStatement(sql6);
			String sql7 = "SELECT STAGE_CODE FROM OT_BOOKING_FIN_STAGES WHERE SERIAL_NO IN (SELECT MAX(SERIAL_NO) FROM OT_BOOKING_FIN_STAGES) ORDER BY SERIAL_NO";
			pstmt=conn.prepareStatement(sql7);
	
			//String oper_sql = "SELECT B.LONG_DESC LONG_DESC1  FROM  OT_BOOKING_DTLS A, OT_OPER_MAST_LANG_VW B WHERE A.OPERATING_FACILITY_ID 	= ? AND	 A.BOOKING_NUM 	= ?  AND  A.OPER_CODE	= B.OPER_CODE  AND LANGUAGE_ID='"+locale+"' ";
			//pstmt7=conn.prepareStatement(oper_sql);
			rs= pstmt.executeQuery();
			//proc_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")).append(",");  
			while (rs.next()){
				stageFinalizationCode=checkForNull(rs.getString(1));
			}
			rs.close();
			pstmt.close();

			sql1=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT4");	
			pstmt1=conn.prepareStatement(sql1);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facilityid);
			pstmt.setString(6,theatre_date);
//			pstmt.setString(7,theatre_date); // COMMENTED FOR PE
			pstmt.setString(7,booking_stage);
			pstmt.setString(8,booking_stage);
			rs=pstmt.executeQuery();
			if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{
			while( s<=end && rs.next()){	

			if(i==0)
						{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
			

		if(chk_sequence.equals("Y"))
		{
		if ( !(start <= 1)) {
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((start-300)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end-300)));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
	//	if ( !((start+15) > i ))
			{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((start+300)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end+300)));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		}else
		{
		
		if ( !(start <= 1)) {
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((start-50)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end-50)));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
	//	if ( !((start+15) > i ))
			{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((start+50)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end+50)));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		}
	
            _bw.write(_wl_block18Bytes, _wl_block18);

proc_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")).append(",");			
if(roomCode.length()!=0 || strSeqCheck.equals("Y")==true)/*// Changed for 44637*/ {
	
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}	
            _bw.write(_wl_block2Bytes, _wl_block2);

			}

			count_oper++;
			oper_status_desc="";
			strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
			strBookingStatus=checkForNull(rs.getString("BOOKING_STATUS1"));
			strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));
			strSex=checkForNull(rs.getString("SEX1"));
			strDOB=checkForNull(rs.getString("DOB1"));
			strTheatreDesc=checkForNull(rs.getString("THEATRE_DESC1"));
			strBookingDate=checkForNull(rs.getString("APPT_DATE1"));
			strApptFromTime=checkForNull(rs.getString("APPT_FROM_TIME1"));	
			strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));
			strSurgeonName=checkForNull(rs.getString("SURGEON_NAME1"));
			strCurStage=checkForNull(rs.getString("CUR_STAGE_DESC1"));
			strStageCode=checkForNull(rs.getString("STAGE_CODE1"));
			strPacStageYN=checkForNull(rs.getString("PAC_STAGE_YN1"));
			strPriorityCode=checkForNull(rs.getString("PRIORITY_CODE1"));
			strSerialNo=checkForNull(rs.getString("SERIAL_NO1"));
			strBookingSeq=checkForNull(rs.getString("BOOKING_SEQUENCE1"));
			strBookingNum=checkForNull(rs.getString("BOOKING_NUM1"));
			strRoomCode=checkForNull(rs.getString("OPER_ROOM_CODE1"));
			oper_status=checkForNull(rs.getString("OPER_STATUS1"));
			strOrderId=checkForNull(rs.getString("ORDER_ID1"));
			strReasonCode=checkForNull(rs.getString("REASON_CODE"));
			strSurgeonCode=checkForNull(rs.getString("SURG_CODE"));
			strSpecialityCode=checkForNull(rs.getString("SPLTY_CODE"));
			current_locn=checkForNull(rs.getString("current_locn"));
			strOper_desc=checkForNull(rs.getString("oper_desc"));
			stages1=checkForNull(rs.getString("asa_score_code")); //crf-0021
			patient_class=checkForNull(rs.getString("patient_class")); //crf-0014
			//proc_desc = (count_oper==1)?proc_desc.append(strOper_desc):proc_desc.append(","+strOper_desc);
			 //show_proc =(count_oper==1)?show_proc.append("<B>").append(count_oper).append(". ").append("</B>").append(proc_description).append("<B>").append("(").append((strSpecialityDesc)).append(")").append("</B>"):show_proc.append(",").append("<B>").append(count_oper+". ").append("</B>").append(proc_description).append("<B>").append("(").append((strSpecialityDesc)).append(")").append("</B>");
			if(strSurgeonCode.equals("")){
				strSurgeonName=all_surgeons;
			}
			strOper_desc=strOper_desc+"( "+strSpecialityDesc+")";
				try {
	if(current_locn!=""){	
			int counter=0;
				StringTokenizer strToken1=new StringTokenizer(current_locn,"$$");
				 counter=strToken1.countTokens();

				if(strToken1.hasMoreTokens()){
					 if(counter <=1)
					{
				 curr_locn=strToken1.nextToken();
				 if(curr_locn.equals("^")) curr_locn="";
				  roomNo="";
					bed_no="";
					}else if(counter <=2)
					{
						 curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo=strToken1.nextToken();
						  if(roomNo.equals("^")) roomNo="";
						  bed_no="";
					}else
					{
				curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo=strToken1.nextToken();
						  if(roomNo.equals("^")) roomNo="";
				 bed_no=strToken1.nextToken();
				  if(bed_no.equals("^")) bed_no="";
					}
				}

				
			if(roomNo.equals("") && bed_no.equals(""))
				{
					room_bed_no=curr_locn;
					
				}else	if(roomNo.equals(""))
				{
				room_bed_no=curr_locn+"/"+bed_no;
			
				}else if(bed_no.equals(""))
				{
					room_bed_no=curr_locn+"/"+roomNo;
					
				}else if(curr_locn.equals(""))
				{
				room_bed_no=roomNo+"/"+bed_no;
				
				}else 
				{
					room_bed_no=curr_locn+"/"+roomNo+"/"+bed_no;
				
				}
			}else{
				room_bed_no="";
			}
				}catch(Exception e){
			   //System.err.println("Verification Sch Search.jsp Curr Location "+e);
			   e.printStackTrace();
		   }
			int count=0;
		   color_ind=empty+hashIndColor.get(strStageCode);
		   text_color=empty+hashTxtColor.get(strStageCode);
		   classvalue="OTCLASS"+strStageCode;
		   color_ind = checkForNull(color_ind);

	
            _bw.write(_wl_block27Bytes, _wl_block27);

			try{
				strPacYN="N";
				pstmt1.setString(1,strStageCode);
				rs1=pstmt1.executeQuery();
				while (rs1.next()){			 
					strPacYN=checkForNull(rs1.getString("PAC_YN1"));	
				}	
				if(strOrderId.length()==0) strPacYN="N";
				rs1.close();
	}catch(Exception xx) {
		xx.printStackTrace();
	}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(strPatientName,"UTF-8")+"::"+strSex+"::"+strDOB));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(proc_desc.toString()));
            _bw.write(_wl_block33Bytes, _wl_block33);

      if(strBookingStatus.equals("R")==false){
		strDisable1=empty;
		scheduled_case_details=(HashMap)all_scheduled_case_details.get(i+"");

	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012 starts here
		pstmt8.setString(1,strPatientId);
		rst3 = pstmt8.executeQuery();
		if(rst3.next()){
			Disp_Image ="../../eOT/images/High_risk.gif";
			//Text_Image_color="RED";
				}
		else{
			Disp_Image ="../../eOT/images/drugInfo.gif";
			//Text_Image_color="BLACK";
				}
    //Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012 ends here
		
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_status_text));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Disp_Image));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strRoomCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strSeqCheck));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strPacYN));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strStageCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(stageFinalizationCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(java.net.URLEncoder.encode(strSurgeonName,"UTF-8")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strSpecialityCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(java.net.URLEncoder.encode(strSpecialityDesc,"UTF-8")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oper_status));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strBookingStatus));
            _bw.write(_wl_block51Bytes, _wl_block51);
 if(strSeqCheck.equals("Y")==true){
            _bw.write(_wl_block52Bytes, _wl_block52);
}else{
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
}	else{
			strDisable1="disabled";
			strCurStage="Rescheduled";
		
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_status_text));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strRoomCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strSeqCheck));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strPacYN));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strStageCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(stageFinalizationCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(java.net.URLEncoder.encode(strSurgeonName,"UTF-8")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strSpecialityCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(java.net.URLEncoder.encode(strSpecialityDesc,"UTF-8")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oper_status));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strBookingStatus));
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(strSeqCheck.equals("Y")==true){
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(room_bed_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
  if(strSeqCheck.equals("Y")==false){	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strTheatreDesc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strApptFromTime));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(strOper_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);

		
				if(strSeqCheck.equals("Y") !=true){
				
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(strDisable1));
            _bw.write(_wl_block82Bytes, _wl_block82);
 
					pstmt5.setString(1,locale);
					pstmt5.setString(2,strStageCode);
					rs1=pstmt5.executeQuery();
					if(rs1!=null){
						while (rs1.next()){			 
							out.print("<option value='"+rs1.getString("STAGE_CODE1")+"'>"		+rs1.getString("STAGE_DESC1")+"</option>");
						}	
						rs1.close();
					}
				
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block86Bytes, _wl_block86);
	if(strSeqCheck.equals("Y") !=true){
	
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strPriorityCode));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(strDisable1));
            _bw.write(_wl_block92Bytes, _wl_block92);

			rs1=pstmt2.executeQuery();
			if(rs1!=null){
			while (rs1.next()){			 
				out.print("<option value='"+rs1.getString("PRIORITY_CODE1")+"'>"+rs1.getString("PRIORITY_DESC1")+"</option>");

			}
			rs1.close();
		}
		}

            _bw.write(_wl_block93Bytes, _wl_block93);
 
	
			if(!oper_status.equals("") && !oper_status.equals("10")){
				pstmtstatus.setString(1,oper_status);
				rs2= pstmtstatus.executeQuery();
				while (rs2.next()){
					oper_status_desc="("+checkForNull(rs2.getString("STATUS_DESC"))+")";
				}
			}
			
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(strCurStage+oper_status_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strBookingSeq));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(stages1));
            _bw.write(_wl_block97Bytes, _wl_block97);
 } else { //Rearrange checked 
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(strTheatreDesc));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(strApptFromTime));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(strOper_desc));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block108Bytes, _wl_block108);

		if(strSeqCheck.equals("Y")==true)
			strDisable=empty;
		else 	
			strDisable="disabled";
	   if(strDisable1.equals("disabled"))
		    strDisable=strDisable1;
	
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(strBookingSeq));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(strDisable));
            _bw.write(_wl_block114Bytes, _wl_block114);
}
            _bw.write(_wl_block115Bytes, _wl_block115);

		if(strSeqCheck.equals("Y")==true){
			if(!strReasonCode.equals(empty)){
		   pstmtreason.setString(1,strReasonCode);
		   rs1=pstmtreason.executeQuery();
			if(rs1!=null){
				while (rs1.next()){			 
					reason_description=rs1.getString("REASON_DESC");
					reason_code_1=rs1.getString("REASON_CODE");
				}
				rs1.close();
			}

		}
	
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(reason_code_1));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(reason_description));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(strCurStage));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(strBookingSeq));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(stages1));
            _bw.write(_wl_block131Bytes, _wl_block131);
} else{ 
            _bw.write(_wl_block132Bytes, _wl_block132);
}
            _bw.write(_wl_block1Bytes, _wl_block1);

	strNextStageCode=empty; 
	strNextSpecificInd=empty; 
	strNextActionDone=empty;
	strNextStageDesc=empty;
	pstmt3.setString(1,locale);
	pstmt3.setString(2,strSerialNo);
	rs1=pstmt3.executeQuery();
	if(rs1!=null){
		while (rs1.next()){			 
			strNextStageCode=checkForNull(rs1.getString("STAGE_CODE1"));
			strNextSpecificInd=checkForNull(rs1.getString("SPECIFIC_IND1"));
			strNextActionDone=checkForNull(rs1.getString("ACTION_IF_NOT_DONE1"));
			strNextStageDesc=checkForNull(rs1.getString("POST_STAGE_DESC1"));	
		}	
		if(rs1!=null) rs1.close();
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	strUserPrevilage="N";
	if(strNextSpecificInd.equals("SPC")==true){
		pstmt4.setString(1,strNextStageCode);
		pstmt4.setString(2,facilityid);
		pstmt4.setString(3,user_id1);
		rs1=pstmt4.executeQuery();
		if(rs1!=null){
			while (rs1.next()){			 
				strUserPrevilage="Y";
			}	
			if(rs1!=null) rs1.close();
		}
	}
	

            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strNextStageCode));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strNextSpecificInd));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strNextActionDone));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strNextStageDesc));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strUserPrevilage));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strStageCode));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strRoomCode));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strBookingSeq));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(stageFinalizationCode));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(stageFinalizationCode));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPacStageYN));
            _bw.write(_wl_block165Bytes, _wl_block165);

	s++;
i++;
	}
				}

if(i==0)
			{
	 out.println("<script>callNoRecord();</script>");
}
		if ( i < 15 || (!rs.next()) ) {
		
            _bw.write(_wl_block166Bytes, _wl_block166);
 
				} else {
            _bw.write(_wl_block167Bytes, _wl_block167);
}

//handling of emergence cases Logic Started Here.......
} else if(waitlistkey.equals("YES")){
	String strQuery=empty;
	
	String emr_proc_sql = "SELECT B.SHORT_DESC DESC1  FROM  OT_WAITLISTING_DTL A, OT_OPER_MAST_LANG_VW B WHERE A.OPERATING_FACILITY_ID  = ? AND  A.WAITLIST_NUM  = ?  AND  A.OPER_CODE = B.OPER_CODE AND LANGUAGE_ID='"+locale+"' " ;
	sql=checkForNull(request.getParameter("sql"));

	//Added for ML-MMOH-SCF-2410 - starts
	String preferredfrom=request.getParameter("preferred_from");
	String preferredto=request.getParameter("preferredto");
	if(preferredfrom.equals("true")){
	String value1=request.getParameter("value1");
	sql+="  AND  TO_DATE(PREFERRED_DATE) >= to_date('"+value1+"','dd/mm/yyyy HH24:MI')";
	}
	if(preferredto.equals("true")){
	String value2=request.getParameter("value2");
	sql+="  AND  TO_DATE(PREFERRED_DATE) <= (to_date('"+value2+"','dd/mm/yyyy HH24:MI'))";
	}//Added for ML-MMOH-SCF-2410 - ends

	pstmt=conn.prepareStatement(sql);
	pstmt1=conn.prepareStatement(emr_proc_sql);
	rs=pstmt.executeQuery();

		if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{

	while(s<=end && rs.next()){	

		if(i==0)
		{
		
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(start));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(end));
            _bw.write(_wl_block170Bytes, _wl_block170);

		if ( !(start <= 1)) {
		
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf((start-15)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end-15)));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);

			}
		//	if ( !((start+15) > fetchCount ))
				{
		
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf((start+15)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((end+15)));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

			}
		
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);
}
	  strPatientId=checkForNull(rs.getString("PATIENT_ID"));
	  strPatientName=java.net.URLEncoder.encode(checkForNull(rs.getString("PATIENT_NAME")));
	  strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC"));
	  //strSurgeonName=java.net.URLEncoder.encode(checkForNull(rs.getString("SURGEON_NAME")));//commented for 056016
		//056016 start
		//strSurgeonName=URLDecoder.decode(checkForNull(rs.getString("SURGEON_NAME")),"UTF-8");
		strSurgeonName=checkForNull(rs.getString("SURGEON_NAME"));
		//056016 end
	  surgery_type=checkForNull(rs.getString("SURGERY_TYPE"));
	  waitlisted_days=checkForNull(rs.getString("WAITLISTED_DAYS"));
	  waitlisted_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("WAITLIST_DATE"),"DMYHM","en",locale));
  	  preferred_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("PREFERRED_DATE"),"DMY","en",locale));
	  waitlist_num=checkForNull(rs.getString("WAITLIST_NUM"));
	  strBookingNum=checkForNull(rs.getString("BOOKING_NUM"));
	  strOrderId=checkForNull(rs.getString("ORDER_ID"));
	  status=checkForNull(rs.getString("STATUS"));
	  booking_date=checkForNull(rs.getString("BOOKING_DATE"));
	  theatre_desc=checkForNull(rs.getString("THEATRE_DESC"));
	  booking_start_time=checkForNull(rs.getString("BOOKING_START_TIME"));	  
	  if(hashIndColor!=null){
	  color_ind=empty+hashIndColor.get(strStageCode);
	  text_color=empty+hashTxtColor.get(strStageCode);
	  }
	  strQuery = (i%2==0)?"gridData":"gridData";
	  if(strSurgeonName.equals("")){
			strSurgeonName=all_surgeons;
	  }
      
	  pstmt1.setString(1,facilityid);
	  pstmt1.setString(2,waitlist_num);
	  rs1=pstmt1.executeQuery();
	  int count = 0;
	  emr_proc_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")).append(",");
	  while (rs1.next()){			 
		 count++;
		 proc_description=rs1.getString(1);
		emr_proc_desc = (count==1)?emr_proc_desc.append(proc_description):emr_proc_desc.append(","+proc_description);	
	  }
	  rs1.close();

            _bw.write(_wl_block179Bytes, _wl_block179);

		try {
				
				//056016 start
				String locnSql = "SELECT OT_PAT_CURR_LOCATION(?, ?, ?, ?, ?) CURR_LOCN FROM DUAL";
				pstmt_locn_room_bed = conn.prepareStatement(locnSql); 
				//056016 end
				
				 pstmt_locn_room_bed.setString(1,facilityid);
				 pstmt_locn_room_bed.setString(2,"");
				 pstmt_locn_room_bed.setString(3,"");
				 pstmt_locn_room_bed.setString(4,waitlist_num);
				 pstmt_locn_room_bed.setString(5,locale);
				
				rs_locn_room_bed = pstmt_locn_room_bed.executeQuery();
				if( rs_locn_room_bed.next())
				{
					current_locn=rs_locn_room_bed.getString(1);
					if(current_locn ==null) current_locn="";
			
				}
				StringTokenizer strToken1=new StringTokenizer(current_locn,"$$");
				//56016 start
					curr_locn="";roomNo="";bed_no="";room_bed_no="";
				//56016 end
				if(strToken1.hasMoreTokens()){
				 curr_locn=strToken1.nextToken();
				   if(curr_locn.equals("^")) curr_locn="";
				 roomNo=strToken1.nextToken();
				 if(roomNo.equals("^")) roomNo=""; 
				 bed_no=strToken1.nextToken();
				 if(bed_no.equals("^")) bed_no="";
				}
				if(roomNo.equals("") && bed_no.equals(""))
				{
					room_bed_no=curr_locn;
				}else	if(roomNo.equals(""))
				{
				room_bed_no=curr_locn+"/"+bed_no;
				}else if(bed_no.equals(""))
				{
					room_bed_no=curr_locn+"/"+roomNo;
				}else if(curr_locn.equals(""))
				{
				room_bed_no=roomNo+"/"+bed_no;
				}else 
				{
					room_bed_no=curr_locn+"/"+roomNo+"/"+bed_no;
				}

				}catch(Exception e){
			   e.printStackTrace();
		   }
		   //56016
		   if(status.equals("Unassigned")) {
			scheduled_case_details=(HashMap)all_scheduled_case_details.get(i+"");
	
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_status_text));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(waitlisted_days));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(booking_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(booking_start_time));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(theatre_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(status));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(surgery_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(waitlist_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strSpecialityCode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(rs.getString("PATIENT_NAME")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block188Bytes, _wl_block188);
} else {

            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_status_text));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(i));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(rs.getString("PATIENT_NAME")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block197Bytes, _wl_block197);
}
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(room_bed_no));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(emr_proc_desc));
            _bw.write(_wl_block201Bytes, _wl_block201);
emr_proc_desc.setLength(0);
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(i));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(surgery_type));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(preferred_date));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(waitlisted_date));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(waitlisted_days));
            _bw.write(_wl_block212Bytes, _wl_block212);
	staus_times=new StringBuffer();
		if(status.equals("Assigned")){
		
		staus_times.append(""+assignTheatre+" : ");
		staus_times.append(theatre_desc);
		staus_times.append("#");
		staus_times.append(" "+assignDate+"     : ");
		//Modified by DhanasekarV against the issue IN025145 on 20/11/2010
		 
 		staus_times.append(DateUtils.convertDate(booking_date,"DMY","en",locale));
//		staus_times.append(booking_date);
		staus_times.append("#");
		staus_times.append(""+assignTime+"      : ");
		staus_times.append(booking_start_time);
		out.println("<input type='hidden' name='reason"+i+"' id='reason"+i+"' value=\""+staus_times+"\" >");
		//

            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(i));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(status));
            _bw.write(_wl_block216Bytes, _wl_block216);
}else{
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(status));
            _bw.write(_wl_block212Bytes, _wl_block212);
}
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(i));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(i));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(waitlist_num));
            _bw.write(_wl_block222Bytes, _wl_block222);
	  i++;
	s++;

}
				}
	
	if(i==0)
		 out.println("<script>callNoRecord();</script>");

		if ( i < 15 || (!rs.next()) ) {
		
            _bw.write(_wl_block166Bytes, _wl_block166);
 
				} else {
            _bw.write(_wl_block223Bytes, _wl_block223);
}

	rs.close();
	pstmt.close();
            _bw.write(_wl_block1Bytes, _wl_block1);
}
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(strSeqCheck));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(strSpecialityCode));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(waitlistkey));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(i));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(theatre_date));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(stages1));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(surgerytype));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(view));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(room_code));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(theatre_date));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(booking_stage));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(theatre_type_code));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(session.getAttribute("enc_id")));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(preferred_from));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(preferred_to));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(strSerialNo));
            _bw.write(_wl_block249Bytes, _wl_block249);

	if(rs!=null)	rs.close();
	if(rs1!=null) rs1.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();
	if(pstmt2!=null) pstmt2.close();
	if(pstmt3!=null) pstmt3.close();
	if(pstmt4!=null) pstmt4.close();
	if(pstmt5!=null) pstmt5.close();
	if(pstmt7!=null) pstmt7.close();
	if(pstmtstatus!=null) pstmtstatus.close(); 
	if(pstmtreason!=null)pstmtreason.close();
	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012f
	if(rst3 != null) rst3.close();
	if(pstmt8!= null) pstmt8.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(rs_locn_room_bed!=null) rs_locn_room_bed.close();
		if(pstmt_locn_room_bed!=null)pstmt_locn_room_bed.close();
		proc_desc.setLength(0);
		show_proc.setLength(0);
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
	}

            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(checkForNull(request.getParameter("function_id"))));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(customer_id1));
            _bw.write(_wl_block252Bytes, _wl_block252);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Currentlocation/RoomNo/BedNo.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChangeSequence.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CurrentStage.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CurrentSequence.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AsaScore.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Currentlocation/RoomNo/BedNo.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChangeStage.Label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CurrentStage.Label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CurrentSequence.Label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AsaScore.Label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Currentlocation/RoomNo/BedNo.Label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SurgeryType.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.WaitlistDate.Label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.WaitlistDays.Label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
}
