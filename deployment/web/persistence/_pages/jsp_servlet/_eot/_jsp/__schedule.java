package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import eOT.Common.OTRepository;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __schedule extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/Schedule.jsp", 1732086578000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script  language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eOT/js/jquery-latest.js\'></script>\n<script language=\'javascript\'  src=\'../../eOT/js/CancelTransfer.js\' ></script> \n<script language=\'javascript\'  src=\'../../eOT/js/Booking.js\' ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n<script type=\"text/javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n<script language=\'javascript\'>\nfunction setAssignValue(dat)\n{\n\treturn dat;\n}\n\nfunction funCompareTime(hiddenTime)\n{\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\tparam=\"sql=SELECT FLOOR(TO_DATE(TO_CHAR(SYSDATE,\'dd/mm/yyyy hh24:mi\'),\'dd/mm/yyyy hh24:mi\')-TO_DATE(\'\"+hiddenTime+\"\',\'dd/mm/yyyy hh24:mi\')) FROM dual\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"../../servlet/eOT.CommonQueryServlet?\"+param,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = xmlHttp.responseText;\t\t\n\tretVal=eval(retVal);\n\tvar val=parseInt(retVal,10);\t \n\t if(val<0) \n\t\t return true;\n\t else\t \n\t\t return false;\n}\n\nasync function showBookingDialog1(spltycode,spltydesc,fromTime,hiddenTime,specialityCode,index)\n{\t\n\tvar dialogHeight= \"99vh\" ;\n\tvar dialogTop = \"10px\" ;\n\tvar dialogWidth\t= \"90vw\" ;\n\tvar dialogLeft\t= \"25px\" ;\n\tvar features = \"dialogLeft:\"+dialogLeft+\"; dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status:no\";\n\tvar arguments\t\t\t= \"\";\n\tvar retVal=\"\";\n\tvar retVal1=\"\";\n\tvar obj=document.forms[0];\n\tvar chkSize;\n\tvar selSurgeonCode;//ML-BRU-SCF-1439 [051911]\n\tif(document.forms[0].chkSize.value == \'\')\n\t\tchkSize = 0;\n\tchkSize = parseInt(document.forms[0].chkSize.value);\n\tselSurgeonCode = document.forms[0].selSurgeonCode.value;// ML-BRU-SCF-1439 [051911]\n\tvar end_time=obj.end_time.value;\n\tvar called_from=obj.called_from.value;\n\tvar procedure=obj.procedure.value;\n\tvar locale = obj.locale.value;\n\tvar function_id = obj.function_id.value;\n\tvar specialityDesc=eval(\"obj.splty\"+index+\".value\");\n\tvar bo_date=obj.booking_date.value+\"  \"+fromTime;\n\tvar chkFlag=funCompareTime(bo_date);\n\tvar totalDurPend = 0;\n\t//002495\n\tvar strval = obj.orderid.value;//002495\n\tif(chkFlag==false)\n\t\talert(getMessage(\"TIME_LESS_THAN\",\"OT\"));\t\n\telse\n\t{\n\t\t//PMG2014-CRF-0024 US-3 start\n\t\tvar duplPatientIdSearchFlag = true;\n\t\tvar facilityId = $(\'#facilityId\').val();\n\t\tvar todaysDate = $(\'#todaysDate\').val();\n\t\tvar bookingDate = $(\'#bookingDate\').val();\n\t\tvar patientId = $(\'#patientId\').val();\n\t\t\t\t\n\t\t//PMG MOD CRF-24 US-3 START\t\n\t\tif(patientId == \'\' || patientId==\'undefined\' || patientId==null)\n\t\t{\n\t\t\tvar orderId=document.forms[0].orderid.value;\t\t\t\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar xmlStr =\"<root></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=getPatientId&orderId=\"+orderId+\"&facilityId=\"+facilityId, false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tpatientId = localTrimString(xmlHttp.responseText);\t\t\t\n\t\t}\n\t\t//PMG MOD CRF-24 US-3 END\n\t\t\n\t\tif(todaysDate == bookingDate)\n\t\t{\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar xmlStr =\"<root></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=duplPatientIdSearch&patient_id=\"+patientId+\"&facilityId=\"+facilityId, false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar duplPatientIdSearch = localTrimString(xmlHttp.responseText);\n\t\t\tvar duplPatientIdSearchArray = duplPatientIdSearch.split(\"~\");\n\t\t\tif(duplPatientIdSearchArray[0] == \"REC_EXIST\")\n\t\t\t{\n\t\t\t\tif(duplPatientIdSearchArray[2] == \'Y\')\n\t\t\t\t{\n\t\t\t\t\t\tif(!window.confirm(getMessage(\"APP-OT0228\",\"OT\")))\n\t\t\t\t\t\t\tduplPatientIdSearchFlag = false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tif(duplPatientIdSearchFlag)\n\t\t{\n\t\t//PMG2014-CRF-0024 end\n\t\tvar strval=obj.orderid.value;//002495\n\t\t//Added against KAUH-SCF-0282 Starts here\t\t   \n\t\tvar customer_id1=obj.customer_id1.value;\n\t\tvar facility_id=obj.facility_id.value;\t\t\n\t\tvar booking_date1=obj.booking_date.value;\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\tvar params = \"order_id=\"+strval+\"&queried_pref_surg_date=\"+booking_date1+\"&facility_id=\"+facility_id+\"&booking_no=\"+fromTime+\"&customerId=\"+customer_id1;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=validateElectiveCutOffTime&\"+params,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\tif(retVal.length>1)\n\t\t{\n\t\t\tvar msg = getMessage(\"APP-OT0124\",\"OT\");\n\t\t\talert(msg);\n\t\t}\n\t\telse\n\t\t{\n\t\t//Added against KAUH-SCF-0282 Ends here\n\t\tif(obj.booking_no.value == null || obj.booking_no.value == \'\')\n\t\t{\t\t\n\t\t\tvar param=\"booking_date=\"+convertDate(obj.booking_date.value,\'DMY\',\'en\',locale)+\n\t\t\t\"&start_time=\"+fromTime+\n\t\t\t\"&end_time=\"+end_time+\n\t\t\t\"&roomCode=\"+obj.roomCode.value+\n\t\t\t\"&roomDesc=\"+encodeURIComponent(obj.roomDesc.value)+\n\t\t\t\"&surgeonCode=\"+obj.surgeonCode.value+\n\t\t\t\"&surgeonName=\"+encodeURIComponent(obj.surgeonName.value)+\n\t\t\t\"&speciality_code=\"+specialityCode+\n\t\t\t\"&selSurgeonCode=\"+selSurgeonCode+\n\t\t\t\"&hidden_time=\"+hiddenTime+\n\t\t\t\"&called_from=\"+called_from+\n\t\t\t\"&spltycode=\"+spltycode+\n\t\t\t\"&spltydesc=\"+spltydesc+\n\t\t\t\"&procedure=\"+procedure+\n\t\t\t\"&function_id=\"+function_id+\n\t\t\t\"&speciality_desc=\"+encodeURIComponent(specialityDesc)+\n\t\t\t\"&orderid=\"+strval+\n\t\t\t\"&patientId=\"+patientId+\n\t\t\t\"&full_vacant=\"+obj.full_vacant.value+\n\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\"&selBookingNumber=\"+obj.selBookingNumber.value+\n\t\t\t\"&fpp_category=\"+obj.fpp_category.value+//ML-MMOH-CRF-1939-US005\n\t\t\t\"&ammendFlag=\"+obj.ammendFlag.value;//MMS-QH-CRF-186\n\n\t\t\tretVal1=\"\"+await top.window.showModalDialog(\"../../eOT/jsp/OperationRegisterFrame.jsp?\"+param,arguments,features);\n\t\t\tvar par=\"\";\n\t\t\t//Refresh Issue while ammend Booking starts\n\t\t\tvar ammendFlag1=obj.ammendFlag.value;\n\t\t\t//Added Against alpha-ICN\t\t\n\t\t\t/* var param1=\"booking_date=\"+convertDate(obj.booking_date.value,\'DMY\',\'en\',locale)+\n\t\t\t\t\t\t\"&roomCode=\"+obj.roomCode.value+\n\t\t\t\t\t\t\"&roomDesc=\"+encodeURIComponent(obj.roomDesc.value)+\n\t\t\t\t\t\t\"&surgeonCode=\"+obj.surgeonCode.value+\n\t\t\t\t\t\t\"&surgeonName=\"+encodeURIComponent(obj.surgeonName.value)+\n\t\t\t\t\t\t\"&speciality_code=\"+specialityCode+\n\t\t\t\t\t\t\"&speciality_desc=\"+encodeURIComponent(specialityDesc)+\n\t\t\t\t\t\t\"&orderid=\"+strval+\n\t\t\t\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\t\t\t\"&called_from=\"+called_from+\n\t\t\t\t\t\t\"&procedure=\"+procedure+\n\t\t\t\t\t\t\"&function_id=\"+function_id+\n\t\t\t\t\t\t\"&selSurgeonCode=\"+selSurgeonCode+\n\t\t\t\t\t\t\"&full_vacant=\"+obj.full_vacant.value+\t\t\t\t\t\n\t\t\t\t\t\t\"&booking_no=\"+obj.booking_no.value+\n\t\t\t\t\t\t\"&start_time=\"+fromTime+\n\t\t\t\t\t\t\"&end_time=\"+end_time+\n\t\t\t\t\t\t\"&chkSize=1\"; */\n\t\t\t\t\t\t\n\t\t\tvar param1=\"booking_date=\"+obj.booking_date.value+\n\t\t\t\t\t\t\"&roomCode=\"+obj.roomCode.value+\n\t\t\t\t\t\t\"&roomDesc=\"+encodeURIComponent(obj.roomDesc.value)+\n\t\t\t\t\t\t\"&surgeonCode=\"+obj.surgeonCode.value+\n\t\t\t\t\t\t\"&surgeonName=\"+encodeURIComponent(obj.surgeonName.value)+\n\t\t\t\t\t\t\"&speciality_code=\"+specialityCode+\n\t\t\t\t\t\t\"&speciality_desc=\"+encodeURIComponent(specialityDesc)+\n\t\t\t\t\t\t\"&orderid=\"+strval+\n\t\t\t\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\t\t\t\"&called_from=\"+called_from+\n\t\t\t\t\t\t\"&procedure=\"+procedure+\n\t\t\t\t\t\t\"&function_id=\"+function_id+\n\t\t\t\t\t\t\"&selSurgeonCode=\"+selSurgeonCode+\n\t\t\t\t\t\t\"&full_vacant=\"+obj.full_vacant.value+\t\t\t\t\t\n\t\t\t\t\t\t\"&booking_no=\"+obj.booking_no.value+\n\t\t\t\t\t\t\"&start_time=\"+fromTime+\n\t\t\t\t\t\t\"&end_time=\"+end_time+\n\t\t\t\t\t\t\"&chkSize=1\";\t //Modified Against SKR-SCF-1384\n\t\t\t\n\t\t\tif(retVal1.charAt(0)==\'1\')\n\t\t\t{\n\t\t\t\tif(chkSize == \'0\' || chkSize == \'1\' || chkSize == \'\' || isNaN(chkSize))\n\t\t\t\t\tpar = obj.param1.value;\n\t\t\t\telse if(chkSize == \'2\')\n\t\t\t\t\tpar = parent.result0.document.getElementById(\"param1\").value + \"~\" + parent.result1.document.getElementById(\"param1\").value;\n\t\t\t\telse if(chkSize == \'3\')\n\t\t\t\t\tpar = parent.result0.document.getElementById(\"param1\").value + \"~\" + parent.result1.document.getElementById(\"param1\").value + \"~~\" + parent.result2.document.getElementById(\"param1\").value;\n\t\t\t\t\n\t\t\t\tif((obj.orderid!=null&&obj.orderid.value.length > 0) || (obj.booking_no!=null&&obj.booking_no.value.length >0)){\n\t\t\t\t\t//par += \"&fun=1\"; //commented for alpha-ICN (Need to check here)\t\n\t\t\t\t}\n\t\t\t\tif(ammendFlag1 ==\'Y\'){\n\t\t\t\tparent.dispSlotsFrame.location.href=\"../../eOT/jsp/Schedule.jsp?\"+par;\n\t\t\t\t}\t//Refresh Issue while ammend Booking ends\n\t\t\t\telse if(chkSize == \'0\' || chkSize == \'\' || (isNaN(chkSize))){\t//44391-Chaitanya //57524\n\t\t\t\t\t\t// Commented and Added Below line\n\t\t\t\t\t\t//parent.qa_query_result.location.href=\"../../eOT/jsp/Schedule.jsp?\"+par;\n\t\t\t\t\t\tparent.qa_query_result.location.href=\"../../eOT/jsp/Schedule.jsp?\"+param1;\n\t\t\t\t}\n\t\t\t\telse if(chkSize == \'1\' || chkSize == \'2\' || chkSize == \'3\'){\n\t\t\t\t\t\tparent.parent.qa_query_result.location.href=\"../../eOT/jsp/ScheduleFrame.jsp?\"+par;\n\t\t\t\t}\t\t\n\t\t\t\t\tif(called_from!=\'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(chkSize == \'0\' || chkSize == \'\' || isNaN(chkSize))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//parent.qa_query_result.location.href=\"../../eOT/jsp/Schedule.jsp?\"+par; // commented by selvin script error\n\t\t\t\t\t\t\t/* parent.frames[2].location.href=\"../../eOT/jsp/Schedule.jsp?\"+par;\n\t\t\t\t\t\t\tparent.result0.ScheduleStatus.disabled=true;\n\t\t\t\t\t\t\tparent.frames[0].ScheduleStatusspan.disabled=true; */\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(chkSize == \'1\' || chkSize == \'2\' || chkSize == \'3\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//Added Against start alpha-ICN\n\t\t\t\t\t\t\tif(chkSize == \'1\'){\n\t\t\t\t\t\t\t\tparent.parent.qa_query_result.location.href=\"../../eOT/jsp/ScheduleFrame.jsp?\"+param1;\n\t\t\t\t\t\t\t}else if(chkSize == \'2\' || chkSize == \'3\'){\n\t\t\t\t\t\t\t\tparent.parent.qa_query_result.location.href=\"../../eOT/jsp/ScheduleFrame.jsp?\"+par;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t//Added Against end alpha-ICN\n\t\t\t\t\t\t\tparent.parent.frames[0].ScheduleStatus.disabled=true;\n\t\t\t\t\t\t\tparent.parent.frames[0].ScheduleStatusspan.disabled=true;\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\n\t\t\t\tvar param=\"booking_date=\"+obj.booking_date.value+\"&roomCode=\"+obj.roomCode.value+\"&roomDesc=\"+obj.roomDesc.value+\"&surgeonCode=\"+obj.surgeonCode.value+\"&surgeonName=\"+encodeURIComponent(obj.surgeonName.value)+\"&speciality_code=\"+specialityCode+\"&start_time=\"+fromTime+\"&end_time=\"+end_time+\"&hidden_time=\"+hiddenTime+\"&transfer=1\"+\"&booking_no=\"+obj.booking_no.value+\"&facility_id=\"+obj.facility_id.value+\"&order_id=\"+obj.orderid.value+\"&spltycode=\"+spltycode+\"&procedure=\"+procedure+\"&function_id=\"+function_id+\"&speciality_desc=\"+encodeURIComponent(specialityDesc)+\"&startTime=\"+obj.startTime.value+\"&endTime=\"+obj.endTime.value+\"&timeDifference=\"+obj.timeDifference.value;//spltycode using for checking block speciality case\n\t\t\t\tparam+=\"&selOrderIds=\"+obj.selOrderIds.value;\n\t\t\t\tretVal1=\"\"+await top.window.showModalDialog(\"../../eOT/jsp/BookingDetailFrame.jsp?\"+param,arguments,features);\n\t\t\t\tvar par=\"\";\n\t\t\t\tparam+=\"&full_vacant=\"+obj.full_vacant.value;\n\t\t\t\tif(retVal1.charAt(0)==\'1\')\n\t\t\t\t{\n\t\t\t\t\tif(chkSize == \'0\' || chkSize == \'1\' || chkSize == \'\' || isNaN(chkSize))\n\t\t\t\t\t\tpar = obj.param1.value;\n\t\t\t\t\telse if(chkSize == \'2\')\n\t\t\t\t\t\tpar = parent.result0.document.getElementById(\"param1\").value + \"~\" + parent.result1.document.getEl";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="ementById(\"param1\").value;\n\t\t\t\t\telse if(chkSize == \'3\')\n\t\t\t\t\t\tpar = parent.result0.document.getElementById(\"param1\").value + \"~\" + parent.result1.document.getElementById(\"param1\").value + \"~~\" + parent.result2.document.getElementById(\"param1\").value;\n\t\t\t\t\tif((obj.orderid!=null&&obj.orderid.value.length > 0) || (obj.booking_no!=null&&obj.booking_no.value.length >0))\n\t\t\t\t\t\tpar=par+\"&fun=1\";\t\n\t\t\t\t\tif(chkSize == \'0\' || chkSize == \'\' || isNaN(chkSize))//44391-Chaitanya\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.qa_query_result.location.href=\"../../eOT/jsp/Schedule.jsp?\"+par;\n\t\t\t\t\t\tparent.frames[0].ScheduleStatus.disabled=true;\n\t\t\t\t\t\tparent.frames[0].ScheduleStatusspan.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\telse if(chkSize == \'1\' || chkSize == \'2\' || chkSize == \'3\')\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.qa_query_result.location.href=\"../../eOT/jsp/ScheduleFrame.jsp?\"+par;\n\t\t\t\t\t\tparent.parent.frames[0].ScheduleStatus.disabled=true;\n\t\t\t\t\t\tparent.parent.frames[0].ScheduleStatusspan.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}//Added  against Kauh SCF-0282\n\t\t}\n\t}\n}\n\nfunction getDurationForPendingorder(obj) //002495\n{\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar xmlStr =\"<root><SEARCH  /></root>\";\n\tvar param=\"func_mode=getDurnForPendOrder&order_id=\"+obj;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"../../eOT/jsp/OTCommonValidation.jsp?\"+param,false);\n\txmlHttp.send(xmlDoc);\n\tvar duration = localTrimString(xmlHttp.responseText);\t\n\treturn duration;\n}\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\'displayresults\' id=\'displayresults\'>\n";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' id=\'results\'>\n\t<tr style=\"position: sticky; top: 0; background-color: white; z-index: 1;\">\n\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</table>\n\n<input type=\"hidden\" name=\"booking_date\" id=\"booking_date\" id=\"bookingDate\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<input type=\"hidden\" name=\"roomCode\" id=\"roomCode\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<input type=\"hidden\" name=\"surgeonName\" id=\"surgeonName\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type=\"hidden\" name=\"surgeonCode\" id=\"surgeonCode\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\"hidden\" name=\"roomDesc\" id=\"roomDesc\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\"hidden\" name=\"speciality_desc\" id=\"speciality_desc\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\"hidden\" name=\"param1\" id=\"param1\" id=\"param1\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name=\"orderid\" id=\"orderid\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\'hidden\' name=\'selOrderIds\' id=\'selOrderIds\' id=\'selOrderIds\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<input type=\'hidden\' name=\'selBookingNumber\' id=\'selBookingNumber\' id=\'selBookingNumber\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<input type=\"hidden\" name=\"booking_no\" id=\"booking_no\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'startTime\' id=\'startTime\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'> <!-- 44528 - Chaitanya -->\n<input type=\'hidden\' name=\'endTime\' id=\'endTime\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"patientId\" id=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\'hidden\' name=\'end_time\' id=\'end_time\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\'hidden\' name=\'timeDifference\' id=\'timeDifference\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"> <!-- 44528 - Chaitanya -->\n<input type=\'hidden\' name=\'procedure\' id=\'procedure\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\'hidden\' name=\'chkSize\' id=\'chkSize\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\'hidden\' name=\'fpp_category\' id=\'fpp_category\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\t<!--ML-MMOH-CRF-1939-US005-->\n<input type=\'hidden\' name=\'selSurgeonCode\' id=\'selSurgeonCode\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"> <!-- ML-BRU-SCF-1439 [051911] -->\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->\n<input type=\'hidden\' name=\'full_vacant\' id=\'full_vacant\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"todaysDate\" id=\"todaysDate\" id=\"todaysDate\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"ammendFlag\" id=\"ammendFlag\" id=\"ammendFlag\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->\n<input type=\"hidden\" name=\"customer_id1\" id=\"customer_id1\" id=\"customer_id1\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"><!--Added Against KAUH-SCF-0282-->\n</form>\n \t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
 
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String ammendFlag = checkForNull(request.getParameter("ammendFlag"));
	String fpp_category = checkForNull(request.getParameter("fpp_category"));	//ML-MMOH-CRF-1939-US005
	System.err.println("fpp_category in param "+fpp_category);

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

	String sql = "";
	StringBuffer resultSql = new StringBuffer();
		resultSql.append("	SELECT   TO_CHAR (from_time, 'HH24:MI') from_time1,	");
		resultSql.append("	TO_CHAR (from_time, 'DD/MM/YYYY HH24:MI') from_time2,	");
		resultSql.append("	TO_CHAR (to_time, 'HH24:MI') to_time1, patient_id patient_id1,	");
		resultSql.append("	DECODE(?,'en',PATIENT_NAME,PATIENT_LOC_NAME) PATIENT_NAME1,	");
		resultSql.append("	(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_vw WHERE PRACTITIONER_ID = SURGEON_CODE AND LANGUAGE_ID =?) SURGEON_LANG_NAME,	");
		resultSql.append("	(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = SURGEON_CODE) SURGEON_ENG_NAME,	");
		resultSql.append("	SPECIALITY_DESC SPECIALITY_DESC1,SPECIALITY_CODE  SPECIALITY_CODE1,BOOKING_NUM BOOKING_NUM1,	");
		resultSql.append("	OPER_DESC OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1,STATUS STATUS1,TOOL_TIP_MSG TOOL_TIP_MSG1, "); //ML-MMOH-CRF-0337.1
		resultSql.append("	CASE WHEN (booking_date < TRUNC (SYSDATE) OR (booking_date = TRUNC (SYSDATE) AND "); //ML-MMOH-CRF-0337.1
		resultSql.append("	TO_CHAR (from_time, 'SSSSS') < TO_CHAR (SYSDATE,'SSSSS'))) THEN 0 ELSE 1 END slot_status "); //ML-MMOH-CRF-0337.1
		resultSql.append("	FROM OT_BOOKING_TIME_SLOTS_VW  A  	");
		resultSql.append("	WHERE OPERATING_FACILITY_ID=? AND OPER_ROOM_CODE=? AND NVL(LANGUAGE_ID,?) = ?	");
		resultSql.append("	AND (SELECT COUNT (*) slots FROM ot_diary_schedule WHERE operating_facility_id = ? AND oper_room_code = ? 	");

	if(!ammendFlag.equalsIgnoreCase("Y")){
		resultSql.append("	AND booking_date = TO_DATE (?, 'DD/MM/YYYY') AND team_doctor_code = ?) > 0 	");
	}else{
		resultSql.append("	AND booking_date = TO_DATE (?, 'DD/MM/YYYY') ) > 0 	");
	}

	resultSql.append("	AND BOOKING_DATE=TO_DATE(?,'DD/MM/YYYY') ORDER BY  to_date(to_char(FROM_TIME,'HH24:MI'),'HH24:MI')	");

	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels");
	String strBookingDate="";
	String strRoomCode="";
	String strFacilityId="";
	String strSurgeonName="";
	String strSurgeonCode="";
	String selSurgeonCode=""; // ML-BRU-SCF-1439 [051911]
	String strRoomDesc="";
	String strSpecialityCode="";
	String strSpecialityDesc="";
	String strSpecialityDesc1="";
	String strOrderId="";
	String strBookingNo="";
	String strTempBookNo="";
	String strOperDesc="";
	String strMultipleOperYN="";
	String fun="";
	String strFromTime="";
	String strToTime="";
	int islotstatus = 0;	//Added for ML-MMOH-CRF-0337.1
	String strPatientID="";
	String strSurgeon="";
	String strSpltycode="";
	String strSpltycodedesc="";
	String strName="";
	String strStatus="";
	String strQuery="";
	String org_pat_id="";
	String strProcname="";
	String startTime="";// 44528 - Chaitanya
	String endTime="";
	int fetchCount=0;
	String strFromHiddenTime="";
	String strToolTipMsg="";
	Date startTimeFormat = null;
	Date endTimeFormat = null;
	long timeDifference = 0;
	StringBuffer reason_title=new StringBuffer("");
	String called_from=checkForNull(request.getParameter("called_from"));
	String no_of_slots=checkForNull(request.getParameter("no_of_slots"));
	String chkSize = checkForNull(request.getParameter("chkSize"));
	boolean orderBookingFlag = false;
	reason_title=reason_title.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels"));
	String todaysDate = com.ehis.util.DateUtils.getCurrentDate("dd/mm/yyyy", locale); //PMG2014-CRF-0024 US-3
	String patientId = checkForNull(request.getParameter("patientId")); //PMG2014-CRF-0024 US-3
	strBookingDate=request.getParameter("booking_date");
	strRoomCode=request.getParameter("roomCode");
	strOrderId=request.getParameter("orderid");
	String selOrderIds = checkForNull(request.getParameter("selOrderIds")); // ChAiTu - 186
	String selBookingNumber = checkForNull(request.getParameter("selBookingNumber")); // ChAiTu - 186
	strOrderId=strOrderId==null?"":strOrderId;
	fun=checkForNull(request.getParameter("fun"));
	strFacilityId=""+session.getValue("facility_id");
	String performing_facility_id = (String)session.getValue("performing_facility");
	//CRF-004 Authorize Slots for Booking - Rajesh V
	String fullVacant = checkForNull(request.getParameter("full_vacant"));
	//CRF-004 Authorize Slots for Booking - Rajesh V
	String fullVacantVal = checkForNull(request.getParameter("fullVacantVal"));

	if(performing_facility_id!=null && performing_facility_id.length()>0)
		strFacilityId = (String)session.getValue("performing_facility");
	
	strSurgeonName=checkForNull(request.getParameter("surgeonName"));
	strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));
	selSurgeonCode = request.getParameter("selSurgeonCode");// ML-BRU-SCF-1439 [051911]
	System.err.println("404,Schedule.jsp==strSurgeonCode=="+strSurgeonCode+"==selSurgeonCode=="+selSurgeonCode);
	strRoomDesc=checkForNull(request.getParameter("roomDesc"));
	strSpecialityCode=checkForNull(request.getParameter("speciality_code"));
	strSpecialityDesc=checkForNull(request.getParameter("speciality_desc"));
	strBookingNo=checkForNull(request.getParameter("booking_no"));
	startTime=checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
	endTime=checkForNull(request.getParameter("endTime"));
	StringBuilder sbr_menu = new StringBuilder();	
	StringBuilder sbr_code = new StringBuilder();
	if(startTime!=null && startTime.trim().length() > 0 && endTime!=null && endTime.trim().length() > 0)// 44528 - Chaitanya - start
	{
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		startTimeFormat = timeFormat.parse(startTime);
		endTimeFormat = timeFormat.parse(endTime);
		timeDifference = (endTimeFormat.getTime() - startTimeFormat.getTime())/1000/60;
	}// 44528 - Chaitanya - end
	strProcname=checkForNull(request.getParameter("procedure"));
	String function_id=request.getParameter("function_id");
	String customer_id1="";// Added for IN:41808
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
	conn = ConnectionManager.getConnection(request);
try
{	
	pstmt=conn.prepareStatement(sql_sm_report); // Added for IN:41808
	rs=pstmt.executeQuery();
	if(rs !=null && rs.next())
		customer_id1=checkForNull(rs.getString("customer_id"));
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();// End for IN:41808
	

	pstmt = conn.prepareStatement(resultSql.toString());
	pstmt.setString(1,locale);	
	pstmt.setString(2,locale);	
	pstmt.setString(3,strFacilityId);
	pstmt.setString(4,strRoomCode);	
	pstmt.setString(5,locale);	
	pstmt.setString(6,locale);	
	pstmt.setString(7,strFacilityId);
	pstmt.setString(8,strRoomCode);
	pstmt.setString(9,strBookingDate);
	if(ammendFlag.equalsIgnoreCase("Y")){
		//pstmt.setString(10,"*All");
		pstmt.setString(10,strBookingDate);
		//pstmt.setString(10,strSurgeonCode);
	}else{
		pstmt.setString(10,strSurgeonCode);
		pstmt.setString(11,strBookingDate);	
	}
	//pstmt.setString(11,strBookingDate);
	rs=pstmt.executeQuery();
	fetchCount=0;

	sql=""+OTRepository.getOTKeyValue("SQL_OT_SCHEDULE_SELECT2");
	pstmt1=conn.prepareStatement(sql);
	if(rs.isBeforeFirst())
	{
	while(rs.next())
	{
		fetchCount++;
		sbr_menu.delete(0, sbr_menu.length()); // Added for IN:045530
		sbr_code.delete(0, sbr_code.length()); 
		strFromTime=checkForNull(rs.getString("FROM_TIME1"));	
		strFromHiddenTime=rs.getString("FROM_TIME2");
		strToTime=checkForNull(rs.getString("TO_TIME1"));
		islotstatus=rs.getInt("SLOT_STATUS");	//Added for ML-MMOH-CRF-0337.1
		strPatientID=checkForNull(rs.getString("PATIENT_ID1"));
		strName=checkForNull(rs.getString("PATIENT_NAME1"));
		if(locale.equals("en"))
			strSurgeon=checkForNull(rs.getString("SURGEON_ENG_NAME"));
		else
		{
			strSurgeon=checkForNull(rs.getString("SURGEON_LANG_NAME"));
			if(strSurgeon.equals(""))
				strSurgeon=checkForNull(rs.getString("SURGEON_ENG_NAME"));
		}
		if(strSurgeon.equals("") && locale.equals("en") && !strName.equals(""))
			strSurgeon=all_surgeons;	
		else if(strSurgeon.equals("") && !locale.equals("en")&& !strName.equals(""))
			strSurgeon=all_surgeons;	
			strOperDesc=checkForNull(rs.getString("OPER_DESC1"));
			strMultipleOperYN=checkForNull(rs.getString("MULTIPLE_OPERS_YN1"));
			strStatus=checkForNull(rs.getString("STATUS1"));			
			strToolTipMsg=checkForNull(rs.getString("TOOL_TIP_MSG1"));
			strSpltycode=checkForNull(rs.getString("SPECIALITY_CODE1"));
			strSpltycodedesc=checkForNull(rs.getString("SPECIALITY_DESC1"));

		if(fetchCount%2==0)
			strQuery="class='gridData'";
		else
			strQuery="class='gridData'";

		if(strStatus.equals("30")==false && strPatientID.length()==0&&fun.length()==0)
		{
				out.println("<input type='hidden' name='splty"+fetchCount+"' id='splty"+fetchCount+"' value=\""+strSpecialityDesc+"\" >"); 
				out.println("<tr >  <td width=6%  "+strQuery+" >");
			if(no_of_slots.equals("0"))
				out.println(strFromTime+"  </td>");
			else
			if(islotstatus == 0)	// Added for ML-MMOH-CRF-0337.1
				out.println(strFromTime+"  </td>");
			else
				out.println("<a class='gridLink' href=\" javascript:showBookingDialog1('"+strSpltycode+"','"+strSpltycodedesc+"','"+strFromTime+"','"+strFromHiddenTime+"','"+strSpecialityCode+"',"+fetchCount+");\">"+strFromTime+"</a></td>");
		}
		else
		{
			out.println("<tr>  ");
			if(strStatus.equals("30"))
			{
				strTempBookNo=reason_title.append(",").toString();
				strTempBookNo+=strToolTipMsg;
				out.println("<input type='hidden' name='reasonX"+fetchCount+"' id='reasonX"+fetchCount+"' value=\""+strTempBookNo+"\" >"); 				
				//out.println("<td width=6%  "+strQuery+" OnMouseOver=\"reasonToolTipBlockSlotReason('reasonX',"+fetchCount+")\"  //onMouseOut='hideToolTip();'\" > <font color='RED' >" +strFromTime+"</font></td>");
				out.println("<td width=6%  "+strQuery+" OnMouseOver=\"Tip(reasonToolTipBlockSlotReason('reasonX',"+fetchCount+"))\"  onMouseOut='UnTip();'\" > <font color='RED' >" +strFromTime+"</font></td>");//58860
			}
			else
			{					
				orderBookingFlag = true;//186 && added below against  for IN 57507
				//if((strPatientID != null && patientId != null) && (strPatientID.equals(patientId) && strPatientID.contains("********")))
				if((strPatientID != null && patientId != null) && (strPatientID.equals(patientId))) //&& strPatientID.contains("**********")))
				{
					// Added / Modified for ML-MMOH-CRF-0337.1 Start
					out.println("<input type='hidden' name='splty"+fetchCount+"' id='splty"+fetchCount+"' value=\""+strSpecialityDesc+"\" >");
					out.println("<tr >  <td width=6%  "+strQuery+" >");
					if(islotstatus == 0)
						out.println(strFromTime+"  </td>");
					else
						out.println("<a class='gridLink' href=\" javascript:showBookingDialog1('"+strSpltycode+"','"+strSpltycodedesc+"','"+strFromTime+"','"+strFromHiddenTime+"','"+strSpecialityCode+"',"+fetchCount+");\">"+strFromTime+"</a></td>");
					// Added/Modified for ML-MMOH-CRF-0337.1 End
				}
				else
					out.println("<td width=6%  "+strQuery+"> "+strFromTime+"  </td>");	
					out.println("<input type='hidden' name='orderBookingFlag"+fetchCount+"' id='orderBookingFlag"+fetchCount+"' value='"+orderBookingFlag+"'/>");
			}
		}
			out.println(" <td width=6%  "+strQuery+">");
		if(strStatus.equals("30")==true) 
			out.println("<font color='RED'>" +strToTime+"</font></td>");
		else
			out.println(""+strToTime+"</td>");	
			strSpecialityDesc1=checkForNull(rs.getString("SPECIALITY_DESC1"));	//strSpecialityCode1=checkForNull(rs.getString("SPECIALITY_CODE1"));
			strTempBookNo=checkForNull(rs.getString("BOOKING_NUM1"));

		if(strPatientID.length()>0)
		{			
			if(!strPatientID.startsWith("*") && customer_id1.equalsIgnoreCase("RTN") )
			{
				org_pat_id = strPatientID;
				sbr_menu.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels"));
				sbr_menu.append(",");
				sbr_menu.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperSiteIdentify.Label","ot_labels"));
				sbr_code.append("RS1");
				sbr_code.append(",");
				sbr_code.append("BQ7");
				out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue'  onClick=\"commonDisplayTooltip('"+sbr_code+"','"+sbr_menu+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\"  width='10%'  '><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('"+sbr_code+"','"+sbr_menu+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\">"+strPatientID+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>"); 			
			}
			else if(!strPatientID.startsWith("*"))
			{
				org_pat_id = strPatientID;
				String bookingDetails_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels");				
				out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue'  onClick=\"commonDisplayTooltip('RS1','"+bookingDetails_title+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\"  width='10%'  '><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('RS1','"+bookingDetails_title+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\">"+strPatientID+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>"); 					
			}
			else
			{
				org_pat_id = strPatientID;
				String bookingDetails_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels");
				out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue'  onClick=\"commonDisplayTooltip('RS1','"+bookingDetails_title+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\"  width='10%'  '><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('RS1','"+bookingDetails_title+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\">"+strPatientID+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
			}
		} 
		else
			out.println("<td width=10%  "+strQuery+">"+strPatientID+"</td>");	
			out.println("<td width=20%  "+strQuery+">"+strName+"</td>");	
			out.println("<td width=20%  "+strQuery+">"+strSurgeon+"</td>");	
		//	strMultipleOperYN = "Y";//186
		if(strMultipleOperYN.equals("Y"))		
		{
			pstmt1.setString(1,locale);
			pstmt1.setString(2,strTempBookNo);
			pstmt1.setString(3,strFacilityId);//KDAH-SCF-0520
			rs1=pstmt1.executeQuery();
			strTempBookNo=strTempBookNo+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")+",";
			while(rs1.next())
			{
				strTempBookNo=strTempBookNo+rs1.getString(1)+",";
			}
			rs1.close();
			out.println("<input type='hidden' name='reason"+fetchCount+"' id='reason"+fetchCount+"' value=\""+strTempBookNo+"\" >"); 
			out.println("<td width=20%  "+strQuery+" OnMouseOver=\"Tip(reasonToolTip('reason','"+fetchCount+"'))\"  onMouseOut='UnTip();'><font color='BLUE' >"+strOperDesc+"</font></td>");							
		}//ML-MMOH-SCF-0387 [IN:060022] 
		else
			out.println("<td width=20%  "+strQuery+">"+strOperDesc+"</td>");	
			out.println("<td width=20%  "+strQuery+">"+strSpecialityDesc1+"</td></tr>");	
	}
	}
	else
	{
		out.println("</table><table style='margin-top:230px'><tr><td valign=bottom align=right class='gridData' nowrap>");
		out.println("For the selected date Schedule is not available</td></tr>");
	}
	pstmt.close();
}
catch(Exception ee)
{
	//System.err.println("Error in Schedule.jsp====>>"+ee);
	ee.printStackTrace();
}
finally
{
	if(rs!=null)
		rs.close();
	if(pstmt1!=null)
		pstmt1.close();
	if(pstmt!=null)
		pstmt.close(); 
	if(conn!=null)
		conn.close();
}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strRoomCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strRoomDesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strSpecialityCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(selOrderIds));
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(selBookingNumber));
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strBookingNo));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(startTime));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(endTime));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strToTime));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(timeDifference));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strProcname));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(chkSize));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fpp_category));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(selSurgeonCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(fullVacant));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(todaysDate));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ammendFlag));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(customer_id1));
            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Procedure(s).Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
