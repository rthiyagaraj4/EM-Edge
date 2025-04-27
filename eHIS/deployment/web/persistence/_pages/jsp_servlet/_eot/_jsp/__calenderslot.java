package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.Common.OTRepository;
import java.sql.Types;
import java.util.Date;
import java.util.Calendar;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __calenderslot extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/Calenderslot.jsp", 1743148902084L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eOA/js/Validate.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eOA/js/Validate1.js\" language=\"JavaScript\"></Script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/Booking.js\"></script>\n\t<!--337-->\n\t<style type=\"text/css\">\n\t\t.menu {text-align:left;position:absolute;width:400px;}\n\t\t.menu1 {text-align:left;position:absolute;width:860px;}\n\t</style>\n<script>\nfunction scrollTitle()\n{\n\t\tvar tab1=document.getElementById(\"divTitleTable1\");\n\t\tvar tab2=document.getElementById(\"divTitleTable\");\n\t\tvar tab3=document.getElementById(\"divTitleTable23\");\n\t\tvar widthValue=400;\n\t\tvar x = document.body.scrollLeft;\n\t\tvar y = document.body.scrollTop;\n\t\tif(x > 0)\n\t\t{\n\t\t\ttab1.style.left=(x-4)+\"px\";\n\t\t\ttab3.style.left=(x-4)+\"px\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttab1.style.left=\"0px\";\n\t\t\ttab3.style.left=\"0px\";\n\t\t\tx=0;\n\t\t}\n\t\tif(y > 0)\n\t\t{\n\t\t\ttab1.style.top=(y-4)+\"px\";\n\t\t\ttab2.style.top=(y-4)+\"px\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttab1.style.top=\"4px\";\n\t\t\ttab2.style.top=\"4px\";\n\t\t\ty=4;\n\t\t}\n\t}\n\nasync function chkPermSlotsBooking(bookingDate,operRoom,doctorCode,specialityCode,totalDuration)\n{\n\t\tvar customerId = document.forms[0].customerId.value;\n\t\tif(customerId == \'MOHBR\') //IN050472\n\t\t{\n\t\tvar authFlag = false;//002495\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH  /></root>\";\n\t\tvar param=\"func_mode=chkPermSlots&booking_date=\"+bookingDate+\"&doctor_code=\"+doctorCode+\"&oper_room=\"+operRoom+\"&speciality_code=\"+specialityCode+\"&total_dur=\"+totalDuration;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eOT/jsp/OTCommonValidation.jsp?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar role_type = localTrimString(xmlHttp.responseText);\t\n\t\tif(role_type == \'NO\')\n\t\t{\n\t\t\tvar confirmBox = confirm(getMessage(\"APP-OT0199\",\"OT\"));\n\t\t\tif(confirmBox)\n\t\t\t{\n\t\t\t\tvar url\t\t= \"../../eOT/jsp/AuthenticateBookingUsers.jsp?&oper_room=\"+operRoom+\"&doctor_code=\"+doctorCode; ;\n\t\t\t\tvar dialogHeight\t= \"11\" ;\n\t\t\t\tvar dialogWidth\t= \"25\" ;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status:no\" ;\n\t\t\t\tvar reportURL \t= await window.showModalDialog( url, arguments, features ) ;\n\t\t\t\tif(reportURL==\'YES\')\n\t\t\t\t{\n\t\t\t\t\trole_type = \'YES\';\n\t\t\t\t\tauthFlag = true;//002495\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\treturn (role_type + \"~\" + authFlag);\n\t\t}\n\t\telse //IN050472\n\t\t\treturn (\"YES~true\");\n}\n\t\nfunction chkPermSlotsBookingAuthent(bookingDate,operRoom,doctorCode,specialityCode,totalDuration)\n{\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH  /></root>\";\n\t\tvar param=\"func_mode=chkPermSlots&booking_date=\"+bookingDate+\"&doctor_code=\"+doctorCode+\"&oper_room=\"+operRoom+\"&speciality_code=\"+specialityCode+\"&total_dur=\"+totalDuration;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eOT/jsp/OTCommonValidation.jsp?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar role_type = localTrimString(xmlHttp.responseText);\n\t\treturn role_type;\n}\n\t\n//CRF-004.1 - 36448\nfunction chkPermSlotsBooking1(bookingDate,operRoom,doctorCode,specialityCode,totalDuration)\n{\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH  /></root>\";\n\t\tvar param=\"func_mode=chkPermSlots&booking_date=\"+bookingDate+\"&doctor_code=\"+doctorCode+\"&oper_room=\"+operRoom+\"&speciality_code=\"+specialityCode+\"&total_dur=\"+totalDuration;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eOT/jsp/OTCommonValidation.jsp?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar role_type = localTrimString(xmlHttp.responseText);\t\n \t\treturn role_type;\n}\n//CRF-004.1 - 36448 \nfunction localTrimString(sInString) \n{\n\t\t  return sInString.replace(/^\\s+|\\s+$/g,\"\");\n}\n\nfunction getDurationForPendingorder(obj)\n{\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH  /></root>\";\n\t\tvar param=\"func_mode=getDurnForPendOrder&order_id=\"+obj;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eOT/jsp/OTCommonValidation.jsp?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar duration = localTrimString(xmlHttp.responseText);\t\n\t\treturn duration;\n}\n//CRF-004 Authorize Slots for Booking - Rajesh V\n\nfunction assign()\n{\n\t\tvar tab1=document.getElementById(\"divTitleTable1\");\n\t\tvar tab2=document.getElementById(\"divTitleTable\");\n\t\tvar tab3=document.getElementById(\"divTitleTable23\");\n\t\tvar topValue=4;\n//\t\tvar widthValue=400;\n\t\tvar widthValue=380;\n\t\ttab1.style.top=topValue+\"px\";\n\t\ttab1.style.left=\"0px\";\n\t\ttab1.style.width=widthValue+\"px\";\n\t\ttab1.style.visibility=\'visible\';\n\t\ttab2.style.top=\"4px\";\n\t\ttab2.style.left=widthValue+\"px\";\n\t\ttab2.style.width=\"713px\";\n\t\ttab2.style.visibility=\'visible\';\n\t\ttab3.style.top=\"65px\";\n\t\ttab3.style.left=\"0px\";\n\t\ttab3.style.width=widthValue+\"px\";\n\t\ttab3.style.visibility=\'visible\';\n\t\ttab3.style.position=\'absolute\';\n}\n\t\nfunction checkBoxMaxSelect(fetchCount)\n{\n\t\tvar total = 0;\n\t\tvar max = document.forms[0].fetchCount.value;\n\t\tfor (var idx = 0; idx < max; idx++)\n\t\t{\n\t\t\tif (eval(\"document.forms[0].check\"+idx+\".checked\") == true)\n\t\t\t{\n\t\t\t\ttotal = total+1;\n\t\t\t\tif(total > 3)\n\t\t\t\t{\n\t\t\t\t\teval(\"document.forms[0].check\"+fetchCount).checked = false;\n\t\t\t\t\talert(getMessage(\'PRACT_SELECT_VALIDATION\',\'OA\'));\n\t\t\t\t}\n\t\t\t}\n\t\t}\n}\n\nfunction moveNext(boDate,obDM,full_vacant, cellPos)\n{\n\t\tvar cellPosLst = cellPos.substring(cellPos.indexOf(\"_\")+1, cellPos.length);\n\t\tvar max = document.forms[0].fetchCount.value;\n\t\tvar patientId = document.forms[0].patientId.value; //PMG2014-CRF-0024 U-3\n\t\tvar retArray = new Array();//002495\n\t\tvar customerId = document.forms[0].customerId.value;\n\t\tif(max == null) \n\t\t\tmax = 1;\n\t\tvar retVal = trimString(validateElectiveCutOffTime(boDate));\n\t\tvar overBookingWindowYN = document.forms[0].overBookingWindowYN.value;\n\t\tvar authFlag = false;\n\t\tvar fullVacantVal = \'\';\n\t\tif(retVal.length>1)\n\t\t{\n\t\t\tvar msg = getMessage(\"APP-OT0124\",\"OT\");\n\t\t\talert(msg);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar f = new Array();\n\t\t\tif(customerId != \'KDAH\')\n\t\t\t{\n\t\t\t\tvar j = 0;\n\t\t\t\tfor (var idx = 0; idx < max; idx++)\n\t\t\t\t{\n\t\t\t\t\tif (eval(\"document.forms[0].check\"+idx+\".checked\"))\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tif (eval(\"document.forms[0].check\"+idx+\".checked\") == true)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tf[j] = idx;\n\t\t\t\t\t\t\tj++;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tif(f.length > 1)\n\t\t\t{\n\t\t\t\tfor (var z = 0; z < f.length; z++)\n\t\t\t\t{\n\t\t\t\t\tvar obj = document.forms[0];\n\t\t\t\t\tfullVacantVal = \'\';\n\t\t\t\t\tvar roomCode;\n\t\t\t\t\tvar surgeonCode;\n\t\t\t\t\tvar objS = eval(\"document.forms[0].xx\"+f[z]+\"\");\n\t\t\t\t\tvar totalDurPend = 0;\n\t\t\t\t\tvar speciality_code=\'\';\n\t\t\t\t\t\n\t\t\t\t\tif(objS != null)\n\t\t\t\t\t{\n\t\t\t\t\t\troomCode = objS.getAttribute(\'OperRoomCode\');\n\t\t\t\t\t\tsurgeonCode = objS.getAttribute(\'SurgeonCode\');\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(obj.Speciality_Code.value != null && obj.Speciality_Code.value != \'\')\n\t\t\t\t\t\tspeciality_code=obj.Speciality_Code.value;\n\t\t\t\t\t\tif(document.getElementById(\"fullVacantVal\"+f[z]+\'_\'+cellPosLst) != null)\n\t\t\t\t\t\t\tfullVacantVal = document.getElementById(\"fullVacantVal\"+f[z]+\'_\'+cellPosLst).value;\n\t\t\t\t\tvar otParam = obj.ot_Param.value;\n\t\t\t\t\tvar orderIdVal = obj.orderid.value;\n\t\t\t\t\tif(fullVacantVal == \'VAC\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(otParam == \'Y\' || otParam==\'y\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(orderIdVal.length > 1)\n\t\t\t\t\t\t\t\ttotalDurPend = getDurationForPendingorder(orderIdVal);\n\t\t\t\t\t\t\tvar ret = chkPermSlotsBookingAuthent(boDate, roomCode, surgeonCode, speciality_code, 0);//002495\n\t\t\t\t\t\t\tif(ret == \'NO\')\n\t\t\t\t\t\t\t\tauthFlag = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tif(authFlag)\n\t\t\t{\n\t\t\t\tfor(var a = 0; a < f.length; a++)\n\t\t\t\t\teval(\"document.forms[0].check\"+f[a]).checked = false;\n\t\t\t\talert(getMessage(\"APP-OT0218\",\"OT\"));\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(f.length == 0)\n\t\t\t\t{\n\t\t\t\t\tvar obj = document.forms[0];\n\t\t\t\t\tvar objS = eval(\"document.forms[0].\"+obDM);\n\t\t\t\t\tvar speciality_code=\'\';\n\t\t\t\t\tvar speciality_desc=\'\';\n\t\t\t\t\tvar called_from=obj.called_from.value;\n\t\t\t\t\tvar function_id=obj.function_id.value;\n\t\t\t\t\tvar roomCode=objS.getAttribute(\'OperRoomCode\');\n\t\t\t\t\tvar roomDesc=objS.getAttribute(\'OperRoomDesc\');\n\t\t\t\t\tvar surgeonCode=objS.getAttribute(\'SurgeonCode\');\n\t\t\t\t\tvar selSurgeonCode = obj.selSurgeonCode.value;// 051911\n\t\t\t\t\tif(selSurgeonCode != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(selSurgeonCode == \'*ALL\' && surgeonCode == \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode = surgeonCode;\n\t\t\t\t\t\telse if(selSurgeonCode == \'*ALL\' && surgeonCode != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode = surgeonCode;\n\t\t\t\t\t\telse if(selSurgeonCode != \'*ALL\' && surgeonCode != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode = surgeonCode;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tselSurgeonCode = surgeonCode;\n\t\t\t\t\t//051911\n\t\t\t\t\tvar surgeonName=objS.getAttribute(\'SurgeonName\');\n\t\t\t\t\tvar procedure=obj.procedure_hdn.value;\n\t\t\t\t\tif(obj.Speciality_Code.value!=null&&obj.Speciality_Code.value!=\'\')\n\t\t\t\t\t\tspeciality_code=obj.Speciality_Code.value;\n\t\t\t\t\tif(obj.Speciality_Desc.value!=null&&obj.Speciality_Desc.value!=\'\')\n\t\t\t\t\t\tspeciality_desc=obj.Speciality_Desc.value;\n\n\t\t\t\t\t//CRF-004 Authorize Slots for Booking - Rajesh V\n\t\t\t\t\tvar otParam = obj.ot_Param.value;\n\t\t\t\t\tvar orderIdVal = obj.orderid.value;\n\t\t\t\t\tvar totalDurPend = 0;\n\t\t\t\t\tif(full_vacant == \'VACANT\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(otParam == \'Y\' || otParam==\'y\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(orderIdVal.length > 1)\n\t\t\t\t\t\t\t\ttotalDurPend = getDurationForPendingorder(orderIdVal);\n\t\t\t\t\t\t\t//002495\n\t\t\t\t\t\t\tvar ret = chkPermSlotsBooking(boDate,roomCode,surgeonCode,speciality_code,0);\n\t\t\t\t\t\t\tretArray = ret.split(\"~\");\n\t\t\t\t\t\t\tret = retArray[0];\n\t\t\t\t\t\t\t//002495\n\t\t\t\t\t\t\tif(ret==\'NO\')\n\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t//CRF-004 Authorize Slots for Booking - Rajesh V\n\t\t\t\t\tvar param = \"booking_date=\"+boDate+\n\t\t\t\t\t\t\t\t\"&roomCode=\"+roomCode+\n\t\t\t\t\t\t\t\t\"&roomDesc=\"+roomDesc+\n\t\t\t\t\t\t\t\t\"&surgeonCode=\"+surgeonCode+\n\t\t\t\t\t\t\t\t\"&surgeonName=\"+encodeURIComponent(surgeonName)+//IN055121\n\t\t\t\t\t\t\t\t\"&speciality_code=\"+speciality_code+\n\t\t\t\t\t\t\t\t\"&speciality_desc=\"+speciality_desc+\n\t\t\t\t\t\t\t\t\"&orderid=\"+obj.orderid.value+\n\t\t\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\t\t\t\t\t\"&booking_no=\"+obj.booking_no.value+\n\t\t\t\t\t\t\t\t\"&startTime=\"+obj.startTime.value+// 44528 - Chaitanya\n\t\t\t\t\t\t\t\t\"&endTime=\"+obj.endTime.value+\n\t\t\t\t\t\t\t\t\"&called_from=\"+obj.called_from.value+\n\t\t\t\t\t\t\t\t\"&fpp_category=\"+obj.fpp_category.value+ //ML-MMOH-CRF-1939-US005\n\t\t\t\t\t\t\t\t\"&procedure=\"+procedure+\n\t\t\t\t\t\t\t\t\"&function_id=\"+function_id+\n\t\t\t\t\t\t\t\t\"&authFlag=\"+retArray[1]+//002495\n\t\t\t\t\t\t\t\t\"&overBookingWindowYN=\"+overBookingWindowYN+\n\t\t\t\t\t\t\t\t\"&patientId=\"+patientId+ //PMG2014-CRF-0024 U-3\n\t\t\t\t\t\t\t\t\"&selSurgeonCode=\"+selSurgeonCo";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="de+// 051911\n\t\t\t\t\t\t\t\t\"&full_vacant=\"+full_vacant;\n\n\t\t\t\t\tif(full_vacant==\"VACANT\" || full_vacant==\"FULL_OVER_BOOKING_NO\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.f_query_add_mod.location.href=\"../../eOT/jsp/ScheduleHdr.jsp?\"+param;\n\t\t\t\t\t\tparent.parent.frames[0].changeTab(\"DaySchedule\");\n\t\t\t\t\t\tparent.parent.qa_query_result.location.href=\"../../eOT/jsp/Schedule.jsp?\"+param;\n\t\t\t\t\t\tparent.parent.qa_query_result_tail.location.href=\"../../eOT/jsp/TailScheduleLegend.jsp?\"+param;\n\t\t\t\t\t}\n\t\t\t\t\telse if(full_vacant==\"FULL_OVER_BOOKING_YES\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\tif(selSurgeonCode != null){\n\t\t\t\t\t\t\tsurgeonCode = selSurgeonCode; // for SCF-1640\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tshowBookingDialog1(speciality_code,speciality_desc,surgeonCode,surgeonName,roomCode,roomDesc,boDate,full_vacant,obj.called_from.value);\n\t\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(f.length == 1)\n\t\t\t\t{\n\t\t\t\t\tvar param = \'\';\n\t\t\t\t\tvar param0 = \'\';\n\t\t\t\t\tvar fullVacantVal0 = \'\';\n\t\t\t\t\tvar obj = document.forms[0];\n\t\t\t\t\tvar called_from = obj.called_from.value;\n\t\t\t\t\tvar function_id = obj.function_id.value;\n\t\t\t\t\tvar speciality_code = \'\';\n\t\t\t\t\tvar speciality_desc = \'\';\n\t\t\t\t\tvar procedure = obj.procedure_hdn.value;\n\t\t\t\t\tif(obj.Speciality_Code.value != null && obj.Speciality_Code.value != \'\')\n\t\t\t\t\t\tspeciality_code = obj.Speciality_Code.value;\n\t\t\t\t\tif(obj.Speciality_Desc.value != null && obj.Speciality_Desc.value != \'\')\n\t\t\t\t\t\tspeciality_desc = obj.Speciality_Desc.value;\n\t\t\t\t\tvar otParam = obj.ot_Param.value;\n\t\t\t\t\tvar orderIdVal = obj.orderid.value;\n\t\t\t\t\tvar objS0 = eval(\"document.forms[0].xx\"+f[0]+\"\");\n\t\t\t\t\tvar roomCode0 = objS0.getAttribute(\'OperRoomCode\');\n\t\t\t\t\tvar roomDesc0 = objS0.getAttribute(\'OperRoomDesc\');\n\t\t\t\t\tvar surgeonCode0 = objS0.getAttribute(\'SurgeonCode\');\n\t\t\t\t\t// start MMS-SCF-0431 [051825]\n\t\t\t\t\tvar selSurgeonCode = obj.selSurgeonCode.value;\n\t\t\t\t\tif(selSurgeonCode != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(selSurgeonCode == \'*ALL\' && surgeonCode0 == \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode = surgeonCode0;\n\t\t\t\t\t\telse if(selSurgeonCode == \'*ALL\' && surgeonCode0 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode = surgeonCode0;\n\t\t\t\t\t\telse if(selSurgeonCode != \'*ALL\' && surgeonCode0 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode = surgeonCode0;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tselSurgeonCode = surgeonCode0;\n\t\t\t\t\t// end MMS-SCF-0431 [051825]\n\n\t\t\t\t\tvar surgeonName0 = objS0.getAttribute(\'SurgeonName\');\n\t\t\t\t\tvar totalDurPend = 0;\n\t\t\t\t\tvar ret;\n\t\t\t\t\tif(document.getElementById(\"fullVacantVal\"+f[0]+\'_\'+cellPosLst) != null)\n\t\t\t\t\t\tfullVacantVal0 = document.getElementById(\"fullVacantVal\"+f[0]+\'_\'+cellPosLst).value;\n\t\t\t\t\t\n\t\t\t\t\tif(full_vacant == \'VACANT\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(otParam == \'Y\' || otParam==\'y\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(orderIdVal.length > 1)\n\t\t\t\t\t\t\t\ttotalDurPend = getDurationForPendingorder(orderIdVal);\n\t\t\t\t\t\t\t//002495\n\t\t\t\t\t\t\tret = chkPermSlotsBooking(boDate, roomCode0, surgeonCode0, speciality_code, 0);\n\t\t\t\t\t\t\tretArray = ret.split(\"~\");\n\t\t\t\t\t\t\tret = retArray[0];\n\t\t\t\t\t\t\t//002495\n\t\t\t\t\t\t\tif(ret==\'NO\')\n\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tparam0 = \"booking_date=\"+boDate+\n\t\t\t\t\t\t\t\t\t\"&roomCode=\"+roomCode0+\n\t\t\t\t\t\t\t\t\t\"&roomDesc=\"+roomDesc0+\n\t\t\t\t\t\t\t\t\t\"&surgeonCode=\"+surgeonCode0+\n\t\t\t\t\t\t\t\t\t\"&surgeonName=\"+encodeURIComponent(surgeonName0)+//IN055121\n\t\t\t\t\t\t\t\t\t\"&speciality_code=\"+speciality_code+\n\t\t\t\t\t\t\t\t\t\"&speciality_desc=\"+speciality_desc+\n\t\t\t\t\t\t\t\t\t\"&orderid=\"+obj.orderid.value+\n\t\t\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\t\t\"&fpp_category=\"+obj.fpp_category.value+ //ML-MMOH-CRF-1939-US005\n\t\t\t\t\t\t\t\t\t\"&booking_no=\"+obj.booking_no.value+\n\t\t\t\t\t\t\t\t\t\"&startTime=\"+obj.startTime.value+// 44528 - Chaitanya\n\t\t\t\t\t\t\t\t\t\"&endTime=\"+obj.endTime.value+\n\t\t\t\t\t\t\t\t\t\"&called_from=\"+obj.called_from.value+\n\t\t\t\t\t\t\t\t\t\"&overBookingWindowYN=\"+overBookingWindowYN+\n\t\t\t\t\t\t\t\t\t\"&patientId=\"+patientId+ //PMG2014-CRF-0024  U-3\n\t\t\t\t\t\t\t\t\t\"&procedure=\"+procedure+\n\t\t\t\t\t\t\t\t\t\"&function_id=\"+function_id+\n\t\t\t\t\t\t\t\t\t\"&authFlag=\"+retArray[1]+//002495\n\t\t\t\t\t\t\t\t\t\"&chkSize=1\"+\n\t\t\t\t\t\t\t\t\t\"&frameNmbr=0\"+\n\t\t\t\t\t\t\t\t\t\"&fullVacantVal=\"+fullVacantVal0+\n\t\t\t\t\t\t\t\t\t\"&selSurgeonCode=\"+selSurgeonCode+// MMS-SCF-0431 [051825]\n\t\t\t\t\t\t\t\t\t\"&full_vacant=\"+full_vacant;\n\t\t\t\t\tparam = param0;\n\t\t\t\t\t\tparent.parent.f_query_add_mod.location.href=\"../../eOT/jsp/ScheduleHdrFrame.jsp?\"+param;\n\t\t\t\t\t\tparent.parent.frames[0].changeTab(\"DaySchedule\");\n\t\t\t\t\t\tparent.parent.qa_query_result.location.href=\"../../eOT/jsp/ScheduleFrame.jsp?\"+param;\n\t\t\t\t\t\tparent.parent.qa_query_result_tail.location.href=\"../../eOT/jsp/TailScheduleLegendFrame.jsp?\"+param;\n\t\t\t\t}\n\t\t\telse if(f.length == 2)\n\t\t\t{\n\t\t\t\tvar param = \'\';\n\t\t\t\tvar param0 = \'\';\n\t\t\t\tvar param1 = \'\';\n\t\t\t\tvar fullVacantVal0 = \'\';\n\t\t\t\tvar fullVacantVal1 = \'\';\n\t\t\t\tvar obj = document.forms[0];\n\t\t\t\tvar called_from = obj.called_from.value;\n\t\t\t\tvar function_id = obj.function_id.value;\n\t\t\t\tvar speciality_code = \'\';\n\t\t\t\tvar speciality_desc = \'\';\n\t\t\t\tvar procedure = obj.procedure_hdn.value;\n\t\t\t\tif(obj.Speciality_Code.value != null && obj.Speciality_Code.value != \'\')\n\t\t\t\t\tspeciality_code = obj.Speciality_Code.value;\n\t\t\t\tif(obj.Speciality_Desc.value != null && obj.Speciality_Desc.value != \'\')\n\t\t\t\t\tspeciality_desc = obj.Speciality_Desc.value;\n\t\t\t\tvar otParam = obj.ot_Param.value;\n\t\t\t\tvar orderIdVal = obj.orderid.value;\n\t\t\t\tvar objS0 = eval(\"document.forms[0].xx\"+f[0]+\"\");\n\t\t\t\tvar objS1 = eval(\"document.forms[0].xx\"+f[1]+\"\");\n\t\t\t\tvar roomCode0 = objS0.getAttribute(\'OperRoomCode\');\n\t\t\t\tvar roomDesc0 = objS0.getAttribute(\'OperRoomDesc\');\n\t\t\t\tvar surgeonCode0 = objS0.getAttribute(\'SurgeonCode\');\n\n\t\t\t\t\t// start MMS-SCF-0431 [051825]\n\t\t\t\t\tvar selSurgeonCode0 = obj.selSurgeonCode.value;\n\t\t\t\t\tif(selSurgeonCode0 != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(selSurgeonCode0 == \'*ALL\' && surgeonCode0 == \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode0 = surgeonCode0;\n\t\t\t\t\t\telse if(selSurgeonCode0 == \'*ALL\' && surgeonCode0 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode0 = surgeonCode0;\n\t\t\t\t\t\telse if(selSurgeonCode0 != \'*ALL\' && surgeonCode0 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode0 = surgeonCode0;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tselSurgeonCode0 = surgeonCode0;\n\t\t\t\t\t// end MMS-SCF-0431 [051825]\n\n\t\t\t\tvar surgeonName0 = objS0.getAttribute(\'SurgeonName\');\n\t\t\t\tvar roomCode1 = objS1.getAttribute(\'OperRoomCode\');\n\t\t\t\tvar roomDesc1 = objS1.getAttribute(\'OperRoomDesc\');\n\t\t\t\tvar surgeonCode1 = objS1.getAttribute(\'SurgeonCode\');\n\n\t\t\t\t\t// start MMS-SCF-0431 [051825]\n\t\t\t\t\tvar selSurgeonCode1 = obj.selSurgeonCode.value;\n\t\t\t\t\tif(selSurgeonCode1 != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(selSurgeonCode1 == \'*ALL\' && surgeonCode1 == \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode1 = surgeonCode1;\n\t\t\t\t\t\telse if(selSurgeonCode1 == \'*ALL\' && surgeonCode1 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode1 = surgeonCode1;\n\t\t\t\t\t\telse if(selSurgeonCode1 != \'*ALL\' && surgeonCode1 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode1 = surgeonCode1;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tselSurgeonCode1 = surgeonCode1;\n\t\t\t\t\t// end MMS-SCF-0431 [051825]\n\n\t\t\t\tvar surgeonName1 = objS1.getAttribute(\'SurgeonName\');\n\t\t\t\tvar totalDurPend = 0;\n\t\t\t\tvar ret;\n\t\t\t\tif(document.getElementById(\"fullVacantVal\"+f[0]+\'_\'+cellPosLst) != null)\n\t\t\t\t\tfullVacantVal0 = document.getElementById(\"fullVacantVal\"+f[0]+\'_\'+cellPosLst).value;\n\t\t\t\tif(document.getElementById(\"fullVacantVal\"+f[1]+\'_\'+cellPosLst) != null)\n\t\t\t\t\tfullVacantVal1 = document.getElementById(\"fullVacantVal\"+f[1]+\'_\'+cellPosLst).value;\n\t\t\t\tparam0 = \"booking_date=\"+boDate+\n\t\t\t\t\t\t\t\t\"&roomCode=\"+roomCode0+\n\t\t\t\t\t\t\t\t\"&roomDesc=\"+roomDesc0+\n\t\t\t\t\t\t\t\t\"&surgeonCode=\"+surgeonCode0+\n\t\t\t\t\t\t\t\t\"&surgeonName=\"+encodeURIComponent(surgeonName0)+//IN055121\n\t\t\t\t\t\t\t\t\"&speciality_code=\"+speciality_code+\n\t\t\t\t\t\t\t\t\"&speciality_desc=\"+speciality_desc+\n\t\t\t\t\t\t\t\t\"&orderid=\"+obj.orderid.value+\n\t\t\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\t\t\t\t\t\"&booking_no=\"+obj.booking_no.value+\n\t\t\t\t\t\t\t\t\"&startTime=\"+obj.startTime.value+// 44528 - Chaitanya\n\t\t\t\t\t\t\t\t\"&endTime=\"+obj.endTime.value+\n\t\t\t\t\t\t\t\t\"&called_from=\"+obj.called_from.value+\n\t\t\t\t\t\t\t\t\"&fpp_category=\"+obj.fpp_category.value+ //Added By Gaurav Against ML-MMOH-SCF-2511\n\t\t\t\t\t\t\t\t\"&procedure=\"+procedure+\n\t\t\t\t\t\t\t\t\"&function_id=\"+function_id+\n\t\t\t\t\t\t\t\t\"&overBookingWindowYN=\"+overBookingWindowYN+\n\t\t\t\t\t\t\t\t\"&patientId=\"+patientId+//PMG2014-CRF-0024  U-3\n\t\t\t\t\t\t\t\t\"&chkSize=2\"+\n\t\t\t\t\t\t\t\t\"&frameNmbr=0\"+\n\t\t\t\t\t\t\t\t\"&fullVacantVal=\"+fullVacantVal0+\n\t\t\t\t\t\t\t\t\"&selSurgeonCode=\"+selSurgeonCode0+// MMS-SCF-0431 [051825]\n\t\t\t\t\t\t\t\t\"&full_vacant=\"+full_vacant;\n\t\t\t\tparam1 = \"booking_date=\"+boDate+\n\t\t\t\t\t\t\t\t\"&roomCode=\"+roomCode1+\n\t\t\t\t\t\t\t\t\"&roomDesc=\"+roomDesc1+\n\t\t\t\t\t\t\t\t\"&surgeonCode=\"+surgeonCode1+\n\t\t\t\t\t\t\t\t\"&surgeonName=\"+encodeURIComponent(surgeonName1)+//IN055121\n\t\t\t\t\t\t\t\t\"&speciality_code=\"+speciality_code+\n\t\t\t\t\t\t\t\t\"&speciality_desc=\"+speciality_desc+\n\t\t\t\t\t\t\t\t\"&orderid=\"+obj.orderid.value+\n\t\t\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\t\t\t\t\t\"&booking_no=\"+obj.booking_no.value+\n\t\t\t\t\t\t\t\t\"&startTime=\"+obj.startTime.value+// 44528 - Chaitanya\n\t\t\t\t\t\t\t\t\"&endTime=\"+obj.endTime.value+\n\t\t\t\t\t\t\t\t\"&called_from=\"+obj.called_from.value+\n\t\t\t\t\t\t\t\t\"&fpp_category=\"+obj.fpp_category.value+ //ML-MMOH-CRF-1939-US005\n\t\t\t\t\t\t\t\t\"&procedure=\"+procedure+\n\t\t\t\t\t\t\t\t\"&function_id=\"+function_id+\n\t\t\t\t\t\t\t\t\"&overBookingWindowYN=\"+overBookingWindowYN+\n\t\t\t\t\t\t\t\t\"&patientId=\"+patientId+ //PMG2014-CRF-0024  U-3\n\t\t\t\t\t\t\t\t\"&chkSize=2\"+\n\t\t\t\t\t\t\t\t\"&frameNmbr=1\"+\n\t\t\t\t\t\t\t\t\"&fullVacantVal=\"+fullVacantVal1+\n\t\t\t\t\t\t\t\t\"&selSurgeonCode=\"+selSurgeonCode1+// MMS-SCF-0431 [051825]\n\t\t\t\t\t\t\t\t\"&full_vacant=\"+full_vacant;\n\t\t\t\tparam = param0 + \"~\" + param1;\n\t\t\t\t\tparent.parent.f_query_add_mod.location.href=\"../../eOT/jsp/ScheduleHdrFrame.jsp?\"+param;\n\t\t\t\t\tparent.parent.frames[0].changeTab(\"DaySchedule\");\n\t\t\t\t\tparent.parent.qa_query_result.location.href=\"../../eOT/jsp/ScheduleFrame.jsp?\"+param;\n\t\t\t\t\tparent.parent.qa_query_result_tail.location.href=\"../../eOT/jsp/TailScheduleLegendFrame.jsp?\"+param;\n\t\t\t}\n\t\t\telse if(f.length == 3)\n\t\t\t{\n\t\t\t\tvar param = \'\';\n\t\t\t\tvar param0 = \'\';\n\t\t\t\tvar param1 = \'\';\n\t\t\t\tvar param2 = \'\';\n\t\t\t\tvar obj = document.forms[0];\n\t\t\t\tvar called_from = obj.called_from.value;\n\t\t\t\tvar function_id = obj.function_id.value;\n\t\t\t\tvar speciality_code = \'\';\n\t\t\t\tvar speciality_desc = \'\';\n\t\t\t\tvar procedure = obj.procedure_hdn.value;\n\t\t\t\tif(obj.Speciality_Code.value != null && obj.Speciality_Code.value != \'\')\n\t\t\t\t\tspeciality_code = obj.Speciality_Code.value;\n\t\t\t\tif(obj.Speciality_Desc.value != null && obj.Speciality_Desc.value != \'\')\n\t\t\t\t\tspeciality_desc = obj.Speciality_Desc.value;\n\t\t\t\tvar otParam = obj.ot_Param.value;\n\t\t\t\tvar orderIdVal = obj.orderid.value;\n\t\t\t\tvar fullVacantVal0 = \'\';\n\t\t\t\tvar fullVacantVal1 = \'\';\n\t\t\t\tvar fullVacantVal2 = \'\';\n\t\t\t\tvar objS0 = eval(\"document.forms[0].xx\"+f[0]+\"\");\n\t\t\t\tvar objS1 = eval(\"document.forms[0].xx\"+f[1]+\"\");\n\t\t\t\tvar objS2 = eval(\"document.forms[0].xx\"+f[2]+\"\");\n\t\t\t\tvar roomCode0 = objS0.getAttribute(\'OperRoomCode\');\n\t\t\t\tvar roomDesc0 = objS0.getAttribute(\'OperRoomDesc\');\n\t\t\t\tvar surgeonCode0 = objS0.getAttribute(\'SurgeonCode\');\n\t\t\t\t\n\n\n\t\t\t\t\t// start MMS-SCF-0431 [051825]\n\t\t\t\t\tvar selSurgeonCode0 = obj.selSurgeonCode.value;\n\t\t\t\t\tif(selSurgeonCode0 != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 ="(selSurgeonCode0 == \'*ALL\' && surgeonCode0 == \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode0 = surgeonCode0;\n\t\t\t\t\t\telse if(selSurgeonCode0 == \'*ALL\' && surgeonCode0 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode0 = surgeonCode0;\n\t\t\t\t\t\telse if(selSurgeonCode0 != \'*ALL\' && surgeonCode0 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode0 = surgeonCode0;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tselSurgeonCode0 = surgeonCode0;\n\t\t\t\t\t// end MMS-SCF-0431 [051825]\n\n\t\t\t\tvar surgeonName0 = objS0.getAttribute(\'SurgeonName\');\n\t\t\t\tvar roomCode1 = objS1.getAttribute(\'OperRoomCode\');\n\t\t\t\tvar roomDesc1 = objS1.getAttribute(\'OperRoomDesc\');\n\t\t\t\tvar surgeonCode1 = objS1.getAttribute(\'SurgeonCode\');\n\n\t\t\t\t\t// start MMS-SCF-0431 [051825]\n\t\t\t\t\tvar selSurgeonCode1 = obj.selSurgeonCode.value;\n\t\t\t\t\tif(selSurgeonCode1 != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(selSurgeonCode1 == \'*ALL\' && surgeonCode1 == \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode1 = surgeonCode1;\n\t\t\t\t\t\telse if(selSurgeonCode1 == \'*ALL\' && surgeonCode1 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode1 = surgeonCode1;\n\t\t\t\t\t\telse if(selSurgeonCode1 != \'*ALL\' && surgeonCode1 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode1 = surgeonCode1;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tselSurgeonCode1 = surgeonCode1;\n\t\t\t\t\t// end MMS-SCF-0431 [051825]\n\n\t\t\t\tvar surgeonName1 = objS1.getAttribute(\'SurgeonName\');\n\t\t\t\tvar roomCode2 = objS2.getAttribute(\'OperRoomCode\');\n\t\t\t\tvar roomDesc2 = objS2.getAttribute(\'OperRoomDesc\');\n\t\t\t\tvar surgeonCode2 = objS2.getAttribute(\'SurgeonCode\');\n\n\t\t\t\t\t// start MMS-SCF-0431 [051825]\n\t\t\t\t\tvar selSurgeonCode2 = obj.selSurgeonCode.value;\n\t\t\t\t\tif(selSurgeonCode2 != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(selSurgeonCode2 == \'*ALL\' && surgeonCode2 == \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode2 = surgeonCode2;\n\t\t\t\t\t\telse if(selSurgeonCode2 == \'*ALL\' && surgeonCode2 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode2 = surgeonCode2;\n\t\t\t\t\t\telse if(selSurgeonCode2 != \'*ALL\' && surgeonCode2 != \'*ALL\')\n\t\t\t\t\t\t\tselSurgeonCode2 = surgeonCode2;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tselSurgeonCode2 = surgeonCode2;\n\t\t\t\t\t// end MMS-SCF-0431 [051825]\n\n\t\t\t\tvar surgeonName2 = objS2.getAttribute(\'SurgeonName\');\n\t\t\t\tif(document.getElementById(\"fullVacantVal\"+f[0]+\'_\'+cellPosLst) != null)\n\t\t\t\t\tfullVacantVal0 = document.getElementById(\"fullVacantVal\"+f[0]+\'_\'+cellPosLst).value;\n\t\t\t\tif(document.getElementById(\"fullVacantVal\"+f[1]+\'_\'+cellPosLst) != null)\n\t\t\t\t\tfullVacantVal1 = document.getElementById(\"fullVacantVal\"+f[1]+\'_\'+cellPosLst).value;\n\t\t\t\tif(document.getElementById(\"fullVacantVal\"+f[2]+\'_\'+cellPosLst))\n\t\t\t\t\tfullVacantVal2 = document.getElementById(\"fullVacantVal\"+f[2]+\'_\'+cellPosLst).value;\n\t\t\t\tvar totalDurPend = 0;\n\t\t\t\tvar ret;\n\t\t\t\tparam0 = \"booking_date=\"+boDate+\n\t\t\t\t\t\t\t\t\"&roomCode=\"+roomCode0+\n\t\t\t\t\t\t\t\t\"&roomDesc=\"+roomDesc0+\n\t\t\t\t\t\t\t\t\"&surgeonCode=\"+surgeonCode0+\n\t\t\t\t\t\t\t\t\"&surgeonName=\"+encodeURIComponent(surgeonName0)+//IN055121\n\t\t\t\t\t\t\t\t\"&speciality_code=\"+speciality_code+\n\t\t\t\t\t\t\t\t\"&speciality_desc=\"+speciality_desc+\n\t\t\t\t\t\t\t\t\"&orderid=\"+obj.orderid.value+\n\t\t\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\t\t\t\t\t\"&booking_no=\"+obj.booking_no.value+\n\t\t\t\t\t\t\t\t\"&startTime=\"+obj.startTime.value+// 44528 - Chaitanya\n\t\t\t\t\t\t\t\t\"&endTime=\"+obj.endTime.value+\n\t\t\t\t\t\t\t\t\"&called_from=\"+obj.called_from.value+\n\t\t\t\t\t\t\t\t\"&fpp_category=\"+obj.fpp_category.value+ //Added By Gaurav Against ML-MMOH-SCF-2511\n\t\t\t\t\t\t\t\t\"&procedure=\"+procedure+\n\t\t\t\t\t\t\t\t\"&function_id=\"+function_id+\n\t\t\t\t\t\t\t\t\"&overBookingWindowYN=\"+overBookingWindowYN+\n\t\t\t\t\t\t\t\t\"&patientId=\"+patientId+ //PMG2014-CRF-0024  U-3\n\t\t\t\t\t\t\t\t\"&chkSize=3\"+\n\t\t\t\t\t\t\t\t\"&frameNmbr=0\"+\n\t\t\t\t\t\t\t\t\"&fullVacantVal=\"+fullVacantVal0+\n\t\t\t\t\t\t\t\t\"&selSurgeonCode=\"+selSurgeonCode0+// MMS-SCF-0431 [051825]\n\t\t\t\t\t\t\t\t\"&full_vacant=\"+full_vacant;\n\t\t\t\t\n\t\t\t\tparam1 = \"booking_date=\"+boDate+\n\t\t\t\t\t\t\t\t\"&roomCode=\"+roomCode1+\n\t\t\t\t\t\t\t\t\"&roomDesc=\"+roomDesc1+\n\t\t\t\t\t\t\t\t\"&surgeonCode=\"+surgeonCode1+\n\t\t\t\t\t\t\t\t\"&surgeonName=\"+encodeURIComponent(surgeonName1)+//IN055121\n\t\t\t\t\t\t\t\t\"&speciality_code=\"+speciality_code+\n\t\t\t\t\t\t\t\t\"&speciality_desc=\"+speciality_desc+\n\t\t\t\t\t\t\t\t\"&orderid=\"+obj.orderid.value+\n\t\t\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\t\t\t\t\t\"&booking_no=\"+obj.booking_no.value+\n\t\t\t\t\t\t\t\t\"&startTime=\"+obj.startTime.value+// 44528 - Chaitanya\n\t\t\t\t\t\t\t\t\"&endTime=\"+obj.endTime.value+\n\t\t\t\t\t\t\t\t\"&called_from=\"+obj.called_from.value+\n\t\t\t\t\t\t\t\t\"&fpp_category=\"+obj.fpp_category.value+ //Added By Gaurav Against ML-MMOH-SCF-2511\n\t\t\t\t\t\t\t\t\"&procedure=\"+procedure+\n\t\t\t\t\t\t\t\t\"&function_id=\"+function_id+\n\t\t\t\t\t\t\t\t\"&overBookingWindowYN=\"+overBookingWindowYN+\n\t\t\t\t\t\t\t\t\"&patientId=\"+patientId+ //PMG2014-CRF-0024 U-3\n\t\t\t\t\t\t\t\t\"&chkSize=3\"+\n\t\t\t\t\t\t\t\t\"&frameNmbr=1\"+\n\t\t\t\t\t\t\t\t\"&fullVacantVal=\"+fullVacantVal1+\n\t\t\t\t\t\t\t\t\"&selSurgeonCode=\"+selSurgeonCode1+// MMS-SCF-0431 [051825]\n\t\t\t\t\t\t\t\t\"&full_vacant=\"+full_vacant;\n\n\t\t\t\tparam2 = \"booking_date=\"+boDate+\n\t\t\t\t\t\t\t\t\"&roomCode=\"+roomCode2+\n\t\t\t\t\t\t\t\t\"&roomDesc=\"+roomDesc2+\n\t\t\t\t\t\t\t\t\"&surgeonCode=\"+surgeonCode2+\n\t\t\t\t\t\t\t\t\"&surgeonName=\"+encodeURIComponent(surgeonName2)+//IN055121\n\t\t\t\t\t\t\t\t\"&speciality_code=\"+speciality_code+\n\t\t\t\t\t\t\t\t\"&speciality_desc=\"+speciality_desc+\n\t\t\t\t\t\t\t\t\"&orderid=\"+obj.orderid.value+\n\t\t\t\t\t\"&selOrderIds=\"+obj.selOrderIds.value+\n\t\t\t\t\t\t\t\t\"&booking_no=\"+obj.booking_no.value+\n\t\t\t\t\t\t\t\t\"&startTime=\"+obj.startTime.value+// 44528 - Chaitanya\n\t\t\t\t\t\t\t\t\"&endTime=\"+obj.endTime.value+\n\t\t\t\t\t\t\t\t\"&fpp_category=\"+obj.fpp_category.value+ //ML-MMOH-CRF-1939-US005\n\t\t\t\t\t\t\t\t\"&called_from=\"+obj.called_from.value+\n\t\t\t\t\t\t\t\t\"&procedure=\"+procedure+\n\t\t\t\t\t\t\t\t\"&function_id=\"+function_id+\n\t\t\t\t\t\t\t\t\"&overBookingWindowYN=\"+overBookingWindowYN+\n\t\t\t\t\t\t\t\t\"&patientId=\"+patientId+ //PMG2014-CRF-0024 U-3\n\t\t\t\t\t\t\t\t\"&chkSize=3\"+\n\t\t\t\t\t\t\t\t\"&frameNmbr=2\"+\n\t\t\t\t\t\t\t\t\"&fullVacantVal=\"+fullVacantVal2+\n\t\t\t\t\t\t\t\t\"&selSurgeonCode=\"+selSurgeonCode2+// MMS-SCF-0431 [051825]\n\t\t\t\t\t\t\t\t\"&full_vacant=\"+full_vacant;\n\t\t\t\tparam = param0 + \"~\" + param1 + \"~~\" + param2;\n\t\t\t\t\tparent.parent.f_query_add_mod.location.href = \"../../eOT/jsp/ScheduleHdrFrame.jsp?\"+param;\n\t\t\t\t\tparent.parent.frames[0].changeTab(\"DaySchedule\");\n\t\t\t\t\tparent.parent.qa_query_result.location.href = \"../../eOT/jsp/ScheduleFrame.jsp?\"+param;\n\t\t\t\t\tparent.parent.qa_query_result_tail.location.href = \"../../eOT/jsp/TailScheduleLegendFrame.jsp?\"+param;\n\t\t\t}\n\t\t}//Else part\n\t}\n}\n\t//CRF-004.1 - 36448\nfunction moveNext1(boDate,obDM,full_vacant,posnew,rowId)\n{\n\t\tvar retVal = trimString(validateElectiveCutOffTime(boDate));\n\t\tif(retVal.length>1)\n\t\t{\n\t\t\tvar msg = getMessage(\"APP-OT0124\",\"OT\");\n\t\t\talert(msg);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar obj=document.forms[0];\n\t\t\tvar speciality_code=\'\';\n\t\t\tvar speciality_desc=\'\';\n\t\t\tvar objS=eval(\"document.forms[0].\"+obDM);\t\t\n\t\t\tvar called_from=document.getElementById(\"called_from\").value;\n\t\t\tvar function_id=document.getElementById(\"function_id\").value;\t\t\n\t\t\tvar objS=document.getElementById(obDM);\n\t\t\tvar obj=document.forms[0];\n\t\t\tvar procedure=document.getElementById(\"procedure_hdn\").value;\n\t\t\tvar specialityCode=document.getElementById(\"Speciality_Code\").value;\n\t\t\tvar specialityDesc=document.getElementById(\"Speciality_Desc\").value;\n\t\t\tvar surgeonName=document.getElementById(\"str_Surgeon_Name\").value;\n\t\t\tvar roomCode=objS.OperRoomCode;\n\t\t\tvar surgeonCode=objS.SurgeonCode;\n\t\t\tvar locale=document.getElementById(\"locale\").value;//337\n\t\t\tvar facility_id=document.getElementById(\"facility_id\").value;//337\n\t\t\tif(specialityCode!=null&&specialityCode!=\'\')\n\t\t\t\tspeciality_code=specialityCode;\t\t\n\t\t\tif(specialityDesc !=null&&specialityDesc!=\'\')\n\t\t\t\tspeciality_desc=specialityDesc;\t\t\n\t\t\tvar otParam = document.getElementById(\"ot_Param\").value;\n\t\t\tvar orderIdVal = document.getElementById(\"orderid\").value;\n\t\t\tvar isVacant=\"\";\n\t\t\tif(document.getElementById(\"Hid_isVacant\"+rowId+\'_\'+posnew))\n\t\t\t\tisVacant=document.getElementById(\"Hid_isVacant\"+rowId+\'_\'+posnew).value;\n\t\t\tvar totalDurPend = 0;\n\t\t\tif(full_vacant == \'VACANT\' && isVacant==\'Y\')\n\t\t\t{\n\t\t\t\tif(otParam == \'Y\' || otParam==\'y\')\n\t\t\t\t{\n\t\t\t\t\t//if(orderIdVal.length>1)//Commented against 1323\n\t\t\t\t\t//\ttotalDurPend = getDurationForPendingorder(orderIdVal);//Commented against 1323\n\t\t\t\t\tvar ret = chkPermSlotsBooking1(boDate, roomCode, surgeonCode, speciality_code, 0);//002495\n\t\t\t\t\tif(ret == \'NO\')\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'cell\'+rowId+\'_\'+posnew).className=\'CYANCLR\';\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}//Else part\n}\t\n//KDAH-SCF-0266\nfunction displaySlotColour(boDate, slotColourDisp, full_vacant, posnew, rowId)\n{\n\t\tvar retVal = trimString(validateElectiveCutOffTime(boDate));      \n\t\tif(retVal.length>1)\n\t\t{\n\t\t\tvar msg = getMessage(\"APP-OT0124\",\"OT\");\n\t\t\talert(msg);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar isVacant=\"\";\n\t\t\tif(document.getElementById(\"Hid_isVacant\"+rowId+\'_\'+posnew))\n\t\t\t\tisVacant=document.getElementById(\"Hid_isVacant\"+rowId+\'_\'+posnew).value;\n\t\t\tvar otParam = document.getElementById(\"ot_Param\").value;\n\t\t\tif(full_vacant == \'VACANT\' && isVacant==\'Y\')\n\t\t\t{\n\t\t\t\tif(otParam == \'Y\' || otParam==\'y\')\n\t\t\t\t{\n\t\t\t\t\tif(slotColourDisp == \'NO\')\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'cell\'+rowId+\'_\'+posnew).className=\'CYANCLR\';\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}//Else part\n}\n//KDAH-SCF-0266\n//CRF-004.1 - 36448\t\nasync function showBookingDialog1(specialityCode,specialityDesc,surgeonCode,surgeonName,roomCode,roomDesc,booking_date,full_vacant,called_from)\n{\n\t\n\tvar dialogHeight \t\t= \"16\";\n\tvar dialogWidth  \t\t= screen.availWidth;\n\tvar dialogTop   \t\t= \"0\";\n\tvar dialogLeft   \t\t= \"0\";\n\tvar features\t\t\t= \"dialogLeft:\"+dialogLeft+\"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status:no\";\n\tvar arguments\t\t\t= \"\";\n\tvar retVal=\"\";\n\tvar retVal1=\"\";\n\tvar obj=document.forms[0];\n\tvar locale = obj.locale.value;\n\tvar procedure = obj.procedure_hdn.value;\n\tvar fromTime=obj.overbook_start_time.value;\n\tvar hiddenTime=booking_date+\" \"+obj.overbook_start_time.value;\n\tvar strval=obj.orderid.value;\n\tvar selOrderIds=obj.selOrderIds.value;\n\tvar facility_id = obj.facility_id.value;\n\tvar fpp_category = obj.fpp_category.value; //ML-MMOH-CRF-1939-US005\n\tvar bookingAvailable;\n\tvar overBookingWindowYN = obj.overBookingWindowYN.value;\n\tif(obj.booking_no.value == null || obj.booking_no.value == \'\')\n\t{\n\t\tvar param=\"booking_date=\"+convertDate(booking_date,\'DMY\',\'en\',locale)+\"&roomCode=\"+roomCode+\"&roomDesc=\"+encodeURIComponent(roomDesc)+\"&surgeonCode=\"+surgeonCode+\"&surgeonName=\"+encodeURIComponent(surgeonName)+\"&speciality_code=\"+specialityCode+\"&speciality_desc=\"+encodeURIComponent(specialityDesc)+\"&start_time=\"+fromTime+\"&hidden_time=\"+hiddenTime+\"&over_booking_case_yn=Y\"+\"&called_from=\"+called_from+\"&procedure=\"+procedure;\n\t\tparam+=\"&orderid=\"+strval;\t\t\n\t\tparam+=\"&selOrderIds=\"+selOrderIds;\n\t\tif (overBookingWindowYN == \'N\')\n\t\t{\n\t\t\t//43811 added by Chaitanya on 10/19/2013\n\t\t\tbookingAvailable = chkOverBookingAvailable(roomCode, booking_date, facility_id);\n\t\t\tif(bookingAvailable == \'Y\')\n\t\t\t{\n\t\t\tdialogHeight = screen.availHeight;\n\t\t\tfeatures = \"dialogLeft:\"+dialogLeft+\"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status:no\";\n\t\t\t\tr";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block7_3 ="etVal1=\"\"+ await window.showModalDialog(\"../../eOT/jsp/OperationRegisterFrame.jsp?\"+param,arguments,features);//Sanja\n\t\t\t}\n\t\t\telse\n\t\t\t\talert(getMessage(\"APP-OT0219\",\"OT\"));\n\t\t\t//43811 added by Chaitanya on 10/19/2013\n\t\t}\n\t\telse \n\t\t\tretVal1=\"\"+await window.showModalDialog(\"../../eOT/jsp/OperOverBookingFrame.jsp?\"+param,arguments,features);//Sanjay\n\t}\n\telse\n\t{\n\t\tvar function_id=obj.function_id.value;\n\t\tvar param=\"booking_date=\"+convertDate(booking_date,\'DMY\',\'en\',locale)+\"&roomCode=\"+roomCode+\"&roomDesc=\"+encodeURIComponent(roomDesc)+\"&surgeonCode=\"+surgeonCode+\"&surgeonName=\"+encodeURIComponent(surgeonName)+\"&speciality_code=\"+specialityCode+\"&speciality_desc=\"+encodeURIComponent(specialityDesc)+\"&start_time=\"+fromTime+\"&hidden_time=\"+hiddenTime+\"&transfer=1\"+\"&booking_no=\"+obj.booking_no.value+\"&startTime=\"+obj.startTime.value+\"&endTime=\"+obj.endTime.value+\"&facility_id=\"+obj.facility_id.value+\"&order_id=\"+strval+\"&over_booking_case_yn=Y\"+\"&called_from=\"+called_from+\"&function_id=\"+function_id;\t\t// 44528 - Chaitanya\n\t\tparam+=\"&orderid=\"+strval;\t\n\t\tparam+=\"&selOrderIds=\"+selOrderIds;\n\t\tif (overBookingWindowYN == \'N\')\n\t\t{\n\t\t\tdialogHeight = screen.availHeight;\n\t\t\tfeatures = \"dialogLeft:\"+dialogLeft+\"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status:no\";\t\t\t\n\t\t\tretVal1=\"\"+await window.showModalDialog(\"../../eOT/jsp/BookingDetailFrame.jsp?\"+param,arguments,features);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tretVal1=\"\"+await window.showModalDialog(\"../../eOT/jsp/OperOverBookingFrame.jsp?\"+param,arguments,features);//Sanjay\n\t\t\tif (retVal1 == \"YES\")\n\t\t\t{\t\n\t\t\t\tparent.parent.frames[1].location.href=\"../../eOT/jsp/DiarySheduleSearch.jsp?reschedule=Y\";//Sanjay\n\t\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/html/blank.html\";//Sanjay\n\t\t\t}\n\t\t}\t\t\n\t}\n\tif(obj.booking_no.value==null||obj.booking_no.value==\'\')\n\t{\n\t\tvar param=\"booking_date=\"+booking_date+\"&roomCode=\"+roomCode+\"&roomDesc=\"+encodeURIComponent(roomDesc)+\"&surgeonCode=\"+surgeonCode+\"&surgeonName=\"+encodeURIComponent(surgeonName)+\"&speciality_code=\"+specialityCode+\"&speciality_desc=\"+encodeURIComponent(specialityDesc)+\"&start_time=\"+fromTime+\"&hidden_time=\"+hiddenTime+\"&over_booking_case_yn=Y\"+\"&called_from=\"+called_from+\"&procedure=\"+procedure;\n\t\tvar strval=obj.orderid.value;\n\t\tparam+=\"&orderid=\"+strval;\n\t\tparam+=\"&selOrderIds=\"+selOrderIds;\n\t}\n\telse\n\t{\n\t\t\t\tvar function_id=obj.function_id.value;\n\t\tvar param=\"booking_date=\"+booking_date+\"&roomCode=\"+roomCode+\"&roomDesc=\"+encodeURIComponent(roomDesc)+\"&surgeonCode=\"+surgeonCode+\"&surgeonName=\"+encodeURIComponent(surgeonName)+\"&speciality_code=\"+specialityCode+\"&speciality_desc=\"+encodeURIComponent(specialityDesc)+\"&start_time=\"+fromTime+\"&hidden_time=\"+hiddenTime+\"&transfer=1\"+\"&booking_no=\"+obj.booking_no.value+\"&startTime=\"+obj.startTime.value+\"&endTime=\"+obj.endTime.value+\"&facility_id=\"+obj.facility_id.value+\"&order_id=\"+obj.orderid.value+\"&over_booking_case_yn=Y\"+\"&called_from=\"+called_from+\"&function_id=\"+function_id+\"&selOrderIds=\"+selOrderIds;// 44528 - Chaitanya\n\t}\n\n\t\tvar par=\"\";\n\t\tif(retVal1.charAt(0)==\'1\'){\n\t\t\tif((obj.orderid!=null&&obj.orderid.value.length > 0) || (obj.booking_no!=null&&obj.booking_no.value.length >0)){\n\t\t\t\tparam=param+\"&fun=1\";\t\n\t\t\t}\n\t\t\tparam += \"&fpp_category=\"+fpp_category; //ML-MMOH-CRF-1939-US005\n\t\t\tparent.parent.f_query_add_mod.location.href=\"../../eOT/jsp/ScheduleHdr.jsp?\"+param;\n\t\t\tparent.parent.frames[0].changeTab(\"DaySchedule\");\n\t\t\t\n\t\t\tparent.parent.qa_query_result.location.href=\"../../eOT/jsp/Schedule.jsp?\"+param;\n\t\t\tparent.parent.qa_query_result_tail.location.href=\"../../eOT/jsp/TailScheduleLegend.jsp?\"+param;\n\t\t}\n}\n\nfunction validateElectiveCutOffTime(boDate)\n{ \n\tvar formObj = document.calendar;\n\tvar order_id=document.getElementById(\"orderid\").value;\n\t\n\n\tvar selOrderIds = document.getElementById(\"selOrderIds\").value;\n\tvar booking_num=document.getElementById(\"booking_no\").value;\n\tvar facility_id=document.getElementById(\"facility_id\").value;\n       /* var order_id = formObj.orderid.value;//\n\tvar booking_num = formObj.booking_no.value;\n\tvar facility_id = formObj.facility_id.value;*/ //\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar params = \"order_id=\"+order_id+\"&queried_pref_surg_date=\"+boDate+\"&facility_id=\"+facility_id+\"&booking_num=\"+booking_num;\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=validateElectiveCutOffTime&\"+params,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText);\n\treturn retVal;\n}\n//43811 added by Chaitanya on 10/19/2013\nfunction chkOverBookingAvailable(roomCode, booking_date, facility_id)\n{\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar locale = document.forms[0].locale.value;\n\tvar xmlStr =\"<root><SEARCH  /></root>\";\n\tvar param=\"func_mode=chkOverBookingAvailable&roomCode=\"+roomCode+\"&strBookingDate=\"+convertDate(booking_date,\'DMY\',\'en\',locale)+\"&facility_id=\"+facility_id;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"../../eOT/jsp/OTCommonValidation.jsp?\"+param,false);\n\txmlHttp.send(xmlDoc);\n\tvar check_count = localTrimString(xmlHttp.responseText);\t\n\treturn check_count;\n}\n//43811 added by Chaitanya on 10/19/2013\n</script>\n</head>\n<body onLoad=\'assign()\' onscroll=\"scrollTitle()\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>  \n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n";
    private final static byte[]  _wl_block7_3Bytes = _getBytes( _wl_block7_3 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- DIV TABLE 1 -->\n<div id=\"divTitleTable1\"  class=\'menu1\' >\n<table>\t\t\n<tr>\n\t<td class=\'ush\' width=\'340px\' NOWRAP ></td>\n</tr>\n</table>\n\n<table border=0 width=\'380px\' align=\"left\" >\n<tr>\n\t<td class=\'OALABEL\' width=\'170px\' NOWRAP ></td>\n\t<td class=\'OALABEL\' width=\'170px\' NOWRAP ></td> \n</tr>\n\n<tr>\n\t<th class=\'columnheader\'  align=\"center\"  height=\'47px\' width=\'170px\' NOWRAP> \n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </th>\n\t<th class=\'columnheader\'  align=\"center\"  height=\'47px\' width=\'170px\' NOWRAP> \n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</th>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<th class=\'columnheader\'  align=\"center\"  width=\'35px\' height=\'47px\'> </th>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</tr>\n</table>\n</div>\n<!--END DIV TABLE1-->\n<!--DIV TBALE2-->\n\n<div id=\"divTitleTable\" class=\'menu\' >\n<table border=0 width=\'840px\' bgColor=\'white\' align=\"center\"   >\n<tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</tr>\t\n</table>\n\n<table border=1 width=\'840px\'  bgColor=white  id=\'colors\' align=\"left\" >\n<tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</tr>\n<tr>\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n</tr>\n</table>\n</div>\n\n<!--END DIV TBALE2-->\n</br></br>\n</br></br>\n\n<!--DIV TBALE3-->\n<form name=\'calendar\' id=\'calendar\'>\n<div id=\"divTitleTable23\" style=\"z-index:100;margin-top:3px;\">\n<table width=\'380px\' align=\"left\"   >\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</table>\n</div>\n<!--END DIV TBALE3-->\n<!-- Detail FORM-->\n\n<!-- CRF-004.1 - 36448  -->\n<input type=\'hidden\' name=\'Speciality_Code\' id=\'Speciality_Code\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\'hidden\' name=\'Speciality_Desc\' id=\'Speciality_Desc\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\'hidden\' name=\'booking_no\' id=\'booking_no\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'startTime\' id=\'startTime\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'> ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<input type=\'hidden\' name=\'endTime\' id=\'endTime\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\"patientId\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<input type=\'hidden\' name=\'orderid\' id=\'orderid\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'selOrderIds\' id=\'selOrderIds\' id=\'selOrderIds\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\'hidden\' name=\'procedure_hdn\' id=\'procedure_hdn\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\'hidden\' name=\'ot_Param\' id=\'ot_Param\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'oper_room_code\' id=\'oper_room_code\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\'hidden\' name=\'str_Surgeon_Name\' id=\'str_Surgeon_Name\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\'hidden\' name=\'str_Surgeon_Code\' id=\'str_Surgeon_Code\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<br>\n<table border=1 width=\'1196px\' align=\"left\" style=\"margin-left:0px;margin-top:-2px\">\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n\t\t\t\t\t<td class=\'OARED\' BORDERCOLOR=\'#FF0000\' align=\'center\' width=\'21px\' id=\'cell\"+";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="+\"_\"+";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="+\"\' OnMouseOver=\"Tip(BlockedToolTip(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'));\" onMouseOut=\'UnTip();\'>\n\t\t\t\t\t<!--<font color=white><a href=\"javascript:moveNext(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',\'xx\'+";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =",\'FULL_OVER_BOOKING_NO\',";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="+\'_\'+";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =")\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</a></font>-->\n\t\t\t\t\t<font color=white><a href=\"javascript:moveNext(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =")\">&nbsp</a></font>\n\t\t\t\t\t<input type=\'hidden\' name=\'fullVacantVal\' id=\'fullVacantVal\'+";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="+\' value=\'FOBY\'>\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t<td class=\'OAFULL\' BORDERCOLOR=\'#FF0000\' align=\'center\' width=\'21px\' id=\'cell\"+";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'));\" onMouseOut=\'UnTip();\'>\n\t\t\t\t<font color=white><a href=\"javascript:moveNext(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =",\'VACANT\',";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a></font>\n\t\t\t\t</td>\n\t\t\t\t<input type=\'hidden\' name=\'Hid_isVacant\"+pos+\"_\"+indexclor+\"\' id=\'Hid_isVacant\"+pos+\"_\"+indexclor+\"\' value=\'Y\'>\n\t\t\t\t<input type=\'hidden\' name=\'fullVacantVal\' id=\'fullVacantVal\'+";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="+\' value=\'FOBY\'>\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<td class=\'EMERGENT\' BORDERCOLOR=\'#FF0000\' align=\'center\' width=\'21px\' id=\'cell\"+";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="+\"\' OnMouseOver=\"BlockedToolTip(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');\" onMouseOut=\'hideToolTip1();\'>\n\t\t\t\t<font color=white><a href=\"javascript:moveNext(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =",\'FULL_OVER_BOOKING_YES\',";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</a></font>\n\t\t\t\t</td>\n\t\t\t\t<input type=\'hidden\' name=\'fullVacantVal\' id=\'fullVacantVal\'+";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<!-- 46615 Starts -->\n\t <script>\n\t \tvar posJS=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'; \n\t \tvar test=\"xx\"+posJS;\n\t\tvar customerId = document.getElementById(\'customerId\').value;\n\t if(customerId == \'MOHBR\') //IN050472\n\t \tmoveNext1(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\', test, \'VACANT\', \'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\', \'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\');\n\t </script>\n\t <!-- 46615 Ends -->\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\t\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n</table>\n\n<input type=\'hidden\' name=\'overBookingWindowYN\' id=\'overBookingWindowYN\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<input type=\'hidden\' name=\'overbook_start_time\' id=\'overbook_start_time\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<input type=\'hidden\' name=\'fpp_category\' id=\'fpp_category\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"> <!--ML-MMOH-CRF-1939-US005-->\n<input type=\'hidden\' name=\'selSurgeonCode\' id=\'selSurgeonCode\' id=\'selSurgeonCode\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"><!-- 051911 -->\n</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:visible;\' bgcolor=\'blue\'>\t\n</div>\n<script language=\'javascript\'>assign();</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );
 
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


	public boolean ComparingDate(String date)
	{
	boolean flag=true;
	try{
			String DATE_FORMAT = "dd/MM/yyyy";
			Calendar c1 = Calendar.getInstance(); 
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);

			Date preferdate = sdf.parse(date);   
			Date today = sdf.parse(sdf.format(c1.getTime()));   
	if(today.after(preferdate))    
	{    
		flag =true;
	}    
	else  
	{ 
		flag= false;
	}
	}catch(Exception ee){
		ee.printStackTrace();
	}
	return flag;
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
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String) session.getValue("facility_id");	
	/*//Added by lakshmi against change in performing_facility starts here
	String performing_facility_id = (String)session.getValue("performing_facility");
	if(performing_facility_id!=null && performing_facility_id.length()>0)
	facility_id = (String)session.getValue("performing_facility");
	//Added by lakshmi against change in performing_facility ends here */
	
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block7_2Bytes, _wl_block7_2);
            _bw.write(_wl_block7_3Bytes, _wl_block7_3);

	int arr[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	String dayValue[]={"","Su","Mo","Tu","We","Th","Fr","Sa"};
	int cou=0,count=0,date=0,dayStart=0,dat=0,flag=0,holidayCount=0,date11=0,month11=0,year11=0,dat1=0;
	int holiday[]=new int[10];	
	int tempDate=0,tempMonth=0,tempYear=0;
	String strSpecialityCode="";
	String strSpecialityDesc="";
	String strSpecificSplty="";
	String strBookingNo="";
	String dateStr="";
	//KDAH-SCF-0266
	String daysArray[] = new String[31];
	String slotColourDisp="";
	//KDAH-SCF-0266
	String dateValue="";
	String strSlot="";
	String strOrderId="";
	String strFromValue="";
	String customerId = "";
	String otParam = "";
	String sqlOtParam = "select NVL(SCHEDULE_RESTRICT_YN,'N') facility from OT_PARAM where rownum = 1";
	String sqlOverBookingParam = "select NVL(over_booking_window_user, 'N') from OT_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ?";
	String overBookingWindowYN = "";
	HashMap hashHolidaylist=new HashMap();
	strBookingNo=request.getParameter("booking_no");
	strBookingNo=strBookingNo==null?"":strBookingNo;
	strOrderId=request.getParameter("orderid");
	strOrderId=strOrderId==null?"":strOrderId;
	strFromValue=request.getParameter("from_value");
	String called_from=checkForNull(request.getParameter("called_from"));
	strFromValue=strFromValue==null?"":strFromValue;
	strSpecialityCode=request.getParameter("speciality_code");
	strSpecialityCode=strSpecialityCode==null?"":strSpecialityCode;
	strSpecialityDesc=request.getParameter("speciality_desc");
	strSpecialityDesc=java.net.URLEncoder.encode(strSpecialityDesc,"UTF-8");
	strSpecialityDesc=strSpecialityDesc==null?"":strSpecialityDesc;
	String function_id=checkForNull(request.getParameter("function_id"));
	String startTime = checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
	String selOrderIds=request.getParameter("selOrderIds");//Chaitanya
	String endTime = checkForNull(request.getParameter("endTime"));
	String patientId = checkForNull(request.getParameter("patientId")); //PMG2014-CRF-0024 U-3
	String fpp_category = checkForNull(request.getParameter("fpp_category"));  //ML-MMOH-CRF-1939-US005
	String strProc=request.getParameter("procedure");
	strProc=strProc==null?"":strProc; 
	dateValue = request.getParameter("date");
	int month=0,year=0;
	StringTokenizer strToken=new StringTokenizer(dateValue,"/");
	StringTokenizer colourDispTokens = null;//KDAH-SCF-0266
	if(strToken.hasMoreTokens())
	{
		date=Integer.parseInt(strToken.nextToken());
		month=Integer.parseInt(strToken.nextToken());
		year=Integer.parseInt(strToken.nextToken());
	}

	String[] date_arr = dateValue.split("/"); 
	String thai_year = date_arr[2];

	if(month==2){
		if(year%100==0&&year%400==0){
			arr[month]=arr[month]+1;
		}else if((year%100)!=0&&(year%4)==0){
			arr[month]=arr[month]+1;
		}
	}

	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement overbook_pstmt=null;	
	ResultSet rs=null;
	ResultSet overbook_rs=null;
	CallableStatement callableStatement=null;
	PreparedStatement pstmtOverBookingParam=null;
	ResultSet rsOverBookingParam=null;
	String  sql=OTRepository.getOTKeyValue("SQL_OT_CALENDAR_SELECT1");
	conn = ConnectionManager.getConnection(request);
	String overbook_start_time="";
	try{ 
		overbook_pstmt = conn.prepareStatement("SELECT TO_DATE(?,'DD/MM/YYYY HH24:MI') END_DATE_TIME,TO_CHAR((TO_DATE(?,'DD/MM/YYYY HH24:MI')- TO_CHAR(UNIT_OT_TIME,'SSSSS')/(24*60*60)),'HH24:MI') START_DATE_TIME FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?");
		overbook_pstmt.setString(1,dateValue+" 00:00");
		overbook_pstmt.setString(2,dateValue+" 00:00");
		overbook_pstmt.setString(3,facility_id);
		overbook_rs = overbook_pstmt.executeQuery();
		//overbook_rs = overbook_pstmt.executeQuery();
		while(overbook_rs.next()){
			overbook_start_time = overbook_rs.getString("START_DATE_TIME");
		}
		String sql_sm_report = "select customer_id from SM_SITE_PARAM where rownum = 1"; //IN044993
		pstmt = conn.prepareStatement(sql_sm_report);
		rs=pstmt.executeQuery();
		if(rs.next())
			customerId = rs.getString("CUSTOMER_ID");
		if(rs!=null)
			rs.close();
		if(pstmt !=null)
			pstmt.close();	//IN044993 
		pstmt = conn.prepareStatement(sqlOtParam);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			otParam=checkForNull(rs.getString("facility"));		
		}
		pstmt = null;
		rs = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,dateValue);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()==true)
			dayStart=Integer.parseInt(rs.getString(1));
		pstmtOverBookingParam = conn.prepareStatement(sqlOverBookingParam);
		pstmtOverBookingParam.setString(1,facility_id);
		rsOverBookingParam=pstmtOverBookingParam.executeQuery();
		if(rsOverBookingParam!=null && rsOverBookingParam.next()==true)
			overBookingWindowYN=checkForNull(rsOverBookingParam.getString(1));
	}catch(Exception ee){
		ee.printStackTrace();
	}finally{
		if(rs!=null)   rs.close();
		if(pstmt!=null) pstmt.close();
		if(overbook_rs !=null)	overbook_rs.close();
		if(overbook_pstmt!=null) overbook_pstmt.close();
		if(rsOverBookingParam !=null)	rsOverBookingParam.close();
		if(pstmtOverBookingParam!=null) pstmtOverBookingParam.close();
	}
            _bw.write(_wl_block8Bytes, _wl_block8);

	try{
		String sql1="SELECT b.DAY_code DAY_CODE1, a.DAY_OF_WEEK  FROM OT_DAY_OF_WEEK a, (select to_char(sysdate,'D') day_code, to_char(sysdate,'DAY') day_of_week from dual union select to_char(sysdate+1,'D') day_code, to_char(sysdate+1,'DAY') day_of_week from dual union select to_char(sysdate+2,'D') day_code, to_char(sysdate+2,'DAY') day_of_week from dual union select to_char(sysdate+3,'D') day_code, to_char(sysdate+3,'DAY') day_of_week from dual union select to_char(sysdate+4,'D') day_code, to_char(sysdate+4,'DAY') day_of_week from dual union select to_char(sysdate+5,'D') day_code, to_char(sysdate+5,'DAY') day_of_week from dual union select to_char(sysdate+6,'D') day_code, to_char(sysdate+6,'DAY') day_of_week from dual) b where trim(a.day_of_week) = trim(b.day_of_week) AND A.day_status = 'H'";
		pstmt1 = conn.prepareStatement(sql1);
	   	rs=pstmt1.executeQuery();
		holidayCount=0;
		while(rs.next()==true){
				holiday[holidayCount]=Integer.parseInt(rs.getString("DAY_CODE1"));
				 holidayCount++;
			}
		}catch(Exception ee){
			ee.printStackTrace();
			//System.err.println("Err Msg From CalendarSlot.jsp-->"+ee);
		}finally{
			if(rs!=null) rs.close();
	    	pstmt1.close();
		}
	try{
			HashMap HashHoliday1 = null;
			sql="SELECT  TO_CHAR(A.HOLIDAY_DATE,'DD/MM/YYYY') HOLIDAY_DATE,  TO_CHAR(HOLIDAY_DATE,'DD/MM/YYYY') DATE1 ,UPPER(TO_CHAR( HOLIDAY_DATE,'DAY')) DAYNAME, DAY_CODE  FROM OT_HOLIDAY A , OT_DAY_OF_WEEK B WHERE B.DAY_OF_WEEK = TRIM(UPPER(TO_CHAR(A.HOLIDAY_DATE,'DAY'))) AND OPERATING_FACILITY_ID =?";
			pstmt = conn.prepareStatement(sql);
			String  login_user=""+session.getValue("facility_id");
			int index_holiday=0;
			pstmt.setString(1,login_user);
			rs=pstmt.executeQuery();		
			while(rs.next()){
				index_holiday++;
				HashHoliday1 = new HashMap();
				HashHoliday1.put("holiday_date",rs.getString("HOLIDAY_DATE"));
				HashHoliday1.put("date1",rs.getString("DATE1"));
				HashHoliday1.put("dayname",rs.getString("DAYNAME"));
				HashHoliday1.put("day_code",rs.getString("DAY_CODE"));
				hashHolidaylist.put(index_holiday+"",HashHoliday1);
			 }
	}catch(Exception ee){
		ee.printStackTrace();
		//System.err.println("Error Msg in CalenderSlot : "+ee);
	}finally{
		if(rs!=null)	rs.close();
		pstmt.close();
	}	

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

if(!customerId.equalsIgnoreCase("KDAH")){//Added agaomst KDAH-SCF-0214 [IN:045516]

            _bw.write(_wl_block12Bytes, _wl_block12);

}//Added agaomst KDAH-SCF-0214 [IN:045516]

            _bw.write(_wl_block13Bytes, _wl_block13);
 
	int new_month=0;
	int new_month1=0;
	int new_year=0;
	int new_thai_year=0;

	String th_year = com.ehis.util.DateUtils.convertDate(""+month+"/"+thai_year,"MY","en",locale);

		strToken=new StringTokenizer(th_year,"/");
		if(strToken.hasMoreTokens())
		{
			month=Integer.parseInt(strToken.nextToken());
			thai_year=strToken.nextToken();
		}

   if(date ==1&&arr[month]==31){
	   out.println("<td  align='left'  width='840px'  colspan='"+arr[month]+"' class=ush>&nbsp;"+month+"/"+thai_year+"</td>");
	   
   }else{
	   if((month+1)>12){
			new_month=1;
			new_year =year+1;
			new_thai_year = Integer.parseInt(thai_year)+1;
	   }else{
			new_month=month+1;
			new_year=year;
			new_thai_year = Integer.parseInt(thai_year);
	   }
		out.println("<td align='left' width='"+((arr[month]-date)*23)+"px' colspan='"+(arr[month]-date)+"' class=ush>&nbsp;"+month+"/"+thai_year+"</td>");
		out.println("<td  align='left'  width='"+((30-(arr[month]-date))*23)+"px'  colspan='"+(30-(arr[month]-date))+"' class=ush>&nbsp;"+new_month+"/"+new_thai_year+"</td>");
			if(new_month==2) {
		if(date==31){
			new_month1=new_month+1;
			out.println("<td  align='right'  width='840px'    colspan='"+arr[month]+"' class=ush>&nbsp;"+new_month1+"/"+thai_year+"</td>");
		}
		else if(date==30){
			if(!((new_year%100==0&&new_year%400==0)||((new_year%100)!=0&&(new_year%4)==0))) {
					new_month1=new_month+1;
					out.println("<td  align='right'   width='840px'  colspan='"+arr[month]+"' class=ush>&nbsp;"+new_month1+"/"+thai_year+"</td>");
					}
				}
	}
   }         

            _bw.write(_wl_block14Bytes, _wl_block14);

		count=31;
	for(dat=1,cou=dayStart;dat<=count;dat++)
	{			
	out.println("<td class=OALABEL width='21px' >"+dayValue[cou]+"</td>");
	cou=(cou%7)+1;
	}

            _bw.write(_wl_block15Bytes, _wl_block15);

	HashMap map = new HashMap();
	int dayss=dayStart;
	for( dat=date, count=1; dat<=arr[month];dat++, count++)
	{
	flag=0;
	for(cou=0;cou<holidayCount;cou++)
		{
			 if(dayss==holiday[cou]) 
			 {
			flag=1;
			break;
		}
		}
		for(int i1=1;i1<=hashHolidaylist.size();i1++)
		{
		map = (HashMap) hashHolidaylist.get(i1+"");
		String date1=(String)map.get("date1");
		StringTokenizer strToken1=new StringTokenizer(date1,"/");
			if(strToken1.hasMoreTokens())
			{
			 date11=Integer.parseInt(strToken1.nextToken());
			 month11=Integer.parseInt(strToken1.nextToken());
			 year11=Integer.parseInt(strToken1.nextToken());
		}
			if(date11==dat && month11==month && year11==year)
			flag=1;
		}
		if(flag == 0)
		out.print("<td class='OALABEL ' width='21px' >"+dat+"</td>");
		else
		out.print("<td class='OAHOLIDAY' width='21px' >"+dat+"</td>");
	dayss=(dayss%7)+1;
	}
if(count<=31)
{
for( dat=1;dat<=(32-count);dat++)
{	
flag=0;
for(cou=0;cou<holidayCount;cou++)
			{
				if(dayss==holiday[cou])
				{
					flag=1;
					break;
				}
			}
	dat1=dat;
			if(new_month==2) 
			{
				if(new_year%100==0&&new_year%400==0) 
				{
					if(dat==30)
						dat1=1;
					}
				else if((new_year%100)!=0&&(new_year%4)==0)
				{
					if(dat==30)
						dat1=1;
					}
				else
				{
					if(dat==29)
						dat1=1;
					else if(dat==30)
						dat1=2;
					else
						dat1=dat;
					}
				}
			else
		dat1=dat;
if(flag==0)
	out.print("<td class='OALABEL ' width='21px' >"+dat1+"</td>");
else
	out.print("<td class='OAHOLIDAY' width='21px' >"+dat1+"</td>");
dayss=(dayss%7)+1;
}
}

            _bw.write(_wl_block16Bytes, _wl_block16);

	HashMap hashSurgeonCode=new HashMap();
	HashMap hashRoomCode=new HashMap();
	HashMap hashSurgeonName=new HashMap();
	HashMap hashSpecificSplty=new HashMap();
	HashMap hashRoomDesc=new HashMap();
	//CRF-004.1 - 36448 
	 ArrayList objslot = new ArrayList();	 
	 ArrayList indexIncr = new ArrayList();
	 ArrayList posslot = new ArrayList();
	//CRF-004.1 - 36448 
	String strSurgeonCode="";
	String strOperRoomCode="";
	String strSurgeonName="";
	String strOperRoomDesc="";
	String strValue="";
	String chkBoxChked = "";
	String strResultString="";
	String allowableSlots = "";//KDAH-SCF-0266
	int index=0;
	ResultSet rst = null;
	String selSurgeonCode = "";// 051911
try
{
    sql=request.getParameter("sql");
	//Added Against MOHE-SCF-0209...starts
	String[] ar = sql.split("::");
	String key = ar[0].substring(2,13);
	if(key.equals("INTERNALREP")){
	int var = 1;
	String sql_query="";
	try {
	MessageManager mm = new MessageManager();
	java.util.Hashtable mesg = mm.getMessage(locale,ar[0],ar[1]);
	sql_query = (String) mesg.get("message");
	StringBuffer sb = new StringBuffer();
	int start = 0,end = 0;
	
	for(int i=0;i<sql_query.length();i++){
		end=i;
		if(sql_query.charAt(i) == '#'){
			sb.append(sql_query.substring(start, end));
			var++;
			sb.append(ar[var]);
			start = i+1;
		}
		if(i==sql_query.length()-1) sb.append(sql_query.substring(start,i+1));
		//System.err.println("sql = "+sb);
	}

	sql = sb.toString();
	System.err.println(sql);
	}
	catch (Exception e) {
		e.printStackTrace();
		//System.err.println("Err Msg CalendarSlot.jsp in getting SQL "+e.getMessage());
	}
	}
	//Added Against MOHE-SCF-0209...ends
	selSurgeonCode = request.getParameter("selSurgeonCode");// 051911
	
	System.out.println(" ********************* SQL Query in Calendarslot :"+sql);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,dateValue);
	pstmt.setString(2,dateValue);
	rst=pstmt.executeQuery();
	int fetchCount=0;
	while(rst.next())
	{
		strSurgeonCode=rst.getString("SURGEON_CODE1");	
		strOperRoomCode=rst.getString("OPER_ROOM_CODE1");
		strSurgeonName=rst.getString("SURGEON_NAME1");
		if(strSurgeonName.length()>22){
		strSurgeonName=strSurgeonName.substring(0,1).toUpperCase() +
              strSurgeonName.substring(1).toLowerCase(); // muthu 07-10-11 
		}
		else{
			strSurgeonName = rst.getString("SURGEON_NAME1");
		}
		strOperRoomDesc=rst.getString("OPER_ROOM_DESC1");
		strSpecificSplty=rst.getString("SPECIALITY_CODE1");
		hashSurgeonCode.put(""+fetchCount,strSurgeonCode);
		hashRoomCode.put(""+fetchCount,strOperRoomCode);
		hashSurgeonName.put(""+fetchCount,strSurgeonName);
		hashRoomDesc.put(""+fetchCount,strOperRoomDesc);
		hashSpecificSplty.put(""+fetchCount,strSpecificSplty);

		out.println("<tr>");
		out.println("<td class='OALABEL' width='170px' height='29px' style='nowrap' >"+strSurgeonName+"</td>");
		out.println("<td class='OALABEL' width='170px' height='29px' style='nowrap' >"+strOperRoomDesc+"</td>");
		//CRF 0085 change	
			System.out.println("--------customerId---------:"+customerId);
		if(customerId != null && !customerId.equalsIgnoreCase("MOHBR") && !customerId.equalsIgnoreCase("SHALM") && !customerId.equalsIgnoreCase("WCH") && fetchCount < 3)	//IN044993 & 58919
			chkBoxChked = "checked";
       	if(!customerId.equalsIgnoreCase("KDAH"))//Added against KDAH-SCF-0214 [IN:045516]
			out.println("<td class='OALABEL' width='30px' NOWRAP ><input type=checkbox "+ chkBoxChked +" name='check"+fetchCount+"' id='check"+fetchCount+"' id='check"+fetchCount+"' onClick=checkBoxMaxSelect("+fetchCount+")></td>");
		//Added agaomst KDAH-SCF-0214 [IN:045516]
		strToken=new StringTokenizer(strResultString,"#");
		out.println("</tr>");
		fetchCount++;
		chkBoxChked = "";
	}
	out.println("<input type='hidden' name='fetchCount' id='fetchCount' value='"+fetchCount+"'/>");
	out.println("<input type='hidden' name='customerId' id='customerId' id='customerId' value='"+customerId+"'/>");//KDAH-SCF-0266
}catch(Exception ee)
	{
		ee.printStackTrace();
		//System.err.println("cmg in loop 2 :" +ee);
		}
	finally{
		if(rst!=null)   rst.close();
		if(rs!=null)   rs.close();
		pstmt.close();
	}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strSpecialityCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strBookingNo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(startTime));
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(endTime));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(selOrderIds));
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strProc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(otParam));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strOperRoomCode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block36Bytes, _wl_block36);

try{
//FacilityID Parameter is added additionally in procedure and changes done by Bala subramanian as instructed by vishwa on 05/06/2006
callableStatement=conn.prepareCall("{ call OT_SURGEON_CALENDAR(?,?,?,?,?)}");
	
for(int pos=0;pos<hashSurgeonCode.size();pos++)
{
	index=0;
	callableStatement.setString(++index,facility_id);
	callableStatement.setString(++index,""+hashSurgeonCode.get(""+pos));
	callableStatement.setString(++index,""+hashRoomCode.get(""+pos));
	callableStatement.setString(++index,dateValue);		
	strSurgeonCode=""+hashSurgeonCode.put(""+pos,strSurgeonCode);
	strSurgeonName=""+hashSurgeonName.put(""+pos,strSurgeonName);
	strOperRoomCode=""+hashRoomCode.put(""+pos,strOperRoomCode);
	strOperRoomDesc=""+hashRoomDesc.put(""+pos,strOperRoomDesc);
	callableStatement.registerOutParameter(++index,Types.VARCHAR);
	callableStatement.execute();
	strResultString=callableStatement.getString(index);
	String borderc = "";//CRF-337
	
	//CRF-004.1 - 36448 
	int indexclor=0;
	//CRF-004.1 - 36448  
	out.println("<tr>");
	out.println("<td>");
	
	strToken=new StringTokenizer(strResultString,"#");
	tempDate=date;
	tempMonth=month;
	tempYear=year;
	out.println("<input type='hidden' name='xx"+pos+"' id='xx"+pos+"' SurgeonName=\""+strSurgeonName+"\"  specificSplty=\""+strSpecificSplty+"\"  SurgeonCode=\""+strSurgeonCode+"\"	OperRoomCode=\""+strOperRoomCode+"\"  OperRoomDesc=\""+strOperRoomDesc+"\">&nbsp</td>");
	while(strToken.hasMoreTokens())
	{
		strValue=strToken.nextToken();
		strSlot=""+strValue.charAt(2)+strValue.charAt(3);
	if(tempDate <10)
			dateStr="0"+tempDate+"/";
		else
			dateStr=""+tempDate+"/";
	if(tempMonth <10)    
			dateStr+="0"+tempMonth+"/";
	else    
		dateStr+=""+tempMonth+"/";
		dateStr+=""+tempYear;
	   tempDate++;
	   if(tempDate>arr[tempMonth])
	   {
	          tempDate=1;
			  tempMonth++;
			if(tempMonth>12)
			  {
					tempYear++;
					tempMonth=1;
			  }
			  }
	   out.println("<input type='hidden' name='Hid_pos' id='Hid_pos' value='"+pos+"'/>");
		switch(strValue.charAt(0))
		{
			case 'U':  
				if(strSlot.equals("00")) 
					strSlot="";
		        out.print(" <td class='OALABEL' width='21px' height='29px' style='word-wrap: break-word' align='center' id='cell"+pos+"_"+indexclor+"'> "+strSlot+"</td>"); 
		        break;  
			case 'S':
				if(strSlot.equals("00")) 
					strSlot="0";
			  	out.println(" <td class='OAGREEN' width='21px' align='center' style='word-wrap: break-word'  height='29px' id='cell"+pos+"_"+indexclor+"'>");
				if(strFromValue.equals("1")==true && ComparingDate(dateStr))
					out.println(""+strSlot+"</td>");
				else
				{
					out.println("<a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','VACANT','"+pos+"_"+indexclor+"');\">"+strSlot+" </a></td>");
					out.println("<input type='hidden' name='Hid_isVacant"+pos+"_"+indexclor+"' id='Hid_isVacant"+pos+"_"+indexclor+"' value='Y'>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='VAC'>");
				}	
			break;	
		    case 'F':
		    	if(strSlot.equals("00")) 
		    		strSlot="0"; // Character 'F' Fully booked Cases and Over Booking Not Allowed
				out.print(" <td class='OAFULL' width='21px' align='center' id='cell"+pos+"_"+indexclor+"'>");		    
				if(strFromValue.equals("1")==true && ComparingDate(dateStr))
					out.println(""+strSlot+"</td>");
				else
				{
					out.println("<font color=white><a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','FULL_OVER_BOOKING_NO','"+pos+"_"+indexclor+"');\">"+strSlot+"</a></font></td>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='FOBN'>");
				}				
			break;
		    case 'O':
		    	if(strSlot.equals("00")) 
		    		strSlot="0"; // character 'O' Fully booked Cases and Over Booking is Allowed
				out.print(" <td class='EMERGENT' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
				if(strFromValue.equals("1")==true && ComparingDate(dateStr))
					out.println(""+strSlot+"</td>");
				else
				{
					out.println("<font color=white><a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','FULL_OVER_BOOKING_YES','"+pos+"_"+indexclor+"');\">"+strSlot+"</a></font></td>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='FOBY'>");
				}				
			break;
			
			// Added start for New Blocked Theatre CRF - 337
			case 'B':
		    	if(strSlot.equals("00")) 
		    		strSlot="0"; // character 'B' Fully blocked Cases and Over Booking is Allowed
				//out.print(" <td class='OARED' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
				if(strFromValue.equals("1")==true && ComparingDate(dateStr)){
					//out.print(" <td class='OARED' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
					out.println(""+strSlot+"</td>");
				}	
				else
				{
					/*out.print(" <td class='OARED' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
					out.println("<font color=white><a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','FULL_OVER_BOOKING_NO','"+pos+"_"+indexclor+"');\">"+strSlot+"</a></font></td>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='FOBY'>");*/
				
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strOperRoomCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strSlot));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block48Bytes, _wl_block48);
	
				}				
			break;
			case 'P':
				if(strSlot.equals("00")) 
					strSlot="0";
			  	out.println(" <td class='OAGREEN' BORDERCOLOR='#FF0000' width='21px' align='center' style='word-wrap: break-word'  height='29px' id='cell"+pos+"_"+indexclor+"' OnMouseOver=\"Tip(BlockedToolTip('"+dateStr+"','"+strOperRoomCode+"','"+locale+"','"+facility_id+"'))\" onMouseOut=\"UnTip()\">");
				if(strFromValue.equals("1")==true && ComparingDate(dateStr))
					out.println(""+strSlot+"</td>");
				else
				{
					out.println("<a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','VACANT','"+pos+"_"+indexclor+"');\">"+strSlot+" </a></td>");
					out.println("<input type='hidden' name='Hid_isVacant"+pos+"_"+indexclor+"' id='Hid_isVacant"+pos+"_"+indexclor+"' value='Y'>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='VAC'>");
				}	
			break;	
			
			case 'Q':
		    	if(strSlot.equals("00")) 
	    		strSlot="0"; // character 'P' Fully booked Cases and Over Booking is Allowed
				borderc = "BORDERCOLOR='#FF0000'";
				if(strFromValue.equals("1")==true && ComparingDate(dateStr)){
				out.println(""+strSlot+"</td>");
				}	
				else
				{	
				
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strOperRoomCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strSlot));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}				
			break;
			
		    //Vikash added for CRF-337 starts
			case 'R':
		    	if(strSlot.equals("00")) 
	    		strSlot="0"; // character 'R' Partial Blocked and Over Booking is Allowed
				borderc = "BORDERCOLOR='#FF0000'";
				if(strFromValue.equals("1")==true && ComparingDate(dateStr)){
				//out.print(" <td class='EMERGENT' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
				out.println(""+strSlot+"</td>");
				}	
				else
				{	
				
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strOperRoomCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strSlot));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}				
			break;			
			//Vikash added for 337 ends
			//Added End for New Blocked Theatre CRF -337			
			
		}		   
	 //CRF-004.1 - 36448 

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(indexclor));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(pos));
            _bw.write(_wl_block63Bytes, _wl_block63);

	  indexclor++;
	//CRF-004.1 - 36448 
      }
		}
		out.println("</tr>");
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	finally
	{
		callableStatement.close();
		hashSurgeonCode=null;
		hashSurgeonName=null;
		hashSpecificSplty=null;
		hashRoomCode=null;
		hashRoomDesc=null;
		if(overbook_rs !=null)	overbook_rs.close();
		if(overbook_pstmt!=null) overbook_pstmt.close();
		ConnectionManager.returnConnection(conn, request);
	}

            _bw.write(_wl_block64Bytes, _wl_block64);
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(overBookingWindowYN));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(overbook_start_time));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(fpp_category));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(selSurgeonCode));
            _bw.write(_wl_block69Bytes, _wl_block69);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
}
