package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.apache.commons.lang.StringEscapeUtils;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eOT.Common.OTRepository;

public final class __canceltransferdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/CancelTransferDtl.jsp", 1725009804000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/CancelTransfer.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/Booking.js\" language=\"javascript\"></script>\n<Script src=\"../../eXH/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n<head>\n<script>\nfunction checkDate(){\n\tvar data=\"\";\n\tvar data1=\"\";\n\tvar obj=document.forms[0];\n\tdata=obj.from_date.value;\n\tdata=changeDate(data);\n\tdata1=obj.to_date.value;\n\tdata1=changeDate(data1);\n\tvar dat=new Date(data);\n\tvar dat1=new Date(data1);\n\tif(dat>dat1){\n\t\t//alert(\"To Date should not be less than from date\");\n\t\tvar msg = getMessage(\"DATE1_NOT_LESSER_THAN_DATE2\",\"OT\");\n\t\tvar msgArray = msg.split(\"#\");\n\t\tvar todate_label = getLabel(\"Common.todate.label\",\"common\");\n\t\tvar fromdate_label = getLabel(\"Common.fromdate.label\",\"common\");\n\t\talert(msgArray[0]+todate_label+msgArray[1]+fromdate_label+msgArray[2]);\n\t\t//\tobj.to_date.value.focus();\n\t\treturn false;\n\t}else\n\t\treturn true;\n}\nfunction submitPrevNext(from, to)\n{\n\tdocument.forms[0].from.value = from;\n\tdocument.forms[0].to.value = to; \n\t\n\tvar frmObj=document.forms[0];\n\tvar locale = frmObj.locale.value;\n\n\tvar facility_id = frmObj.facility_id.value;\n\tvar change_from_date = dateUtils(frmObj.from_date.value,locale,\"DMY\"); \n\tvar change_to_date = dateUtils(frmObj.to_date.value,locale,\"DMY\"); \n\n\tif(checkDate()){\n\n\t\tif(change_from_date!=\'\'){\n\t\tvar sql=\"SELECT APPT_REF_NUM APPT_REF_NUM1, SURGEON_CODE SURGEON_CODE1,ORDER_ID ORDER_ID1, to_char(APPT_DATE,\'dd/mm/yyyy\') APPT_DATE1, PATIENT_ID PATIENT_ID1, (select decode( \'\"+locale+\"\' ,\'en\',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = A.patient_id ) PATIENT_NAME1,OPER_ROOM_DESC OPER_ROOM_DESC1, TO_CHAR (appt_from_time, \'DD/MM/YYYY HH24:MI:SS\') APPTFROMDATETIME, TO_CHAR (appt_to_time, \'DD/MM/YYYY HH24:MI:SS\') APPTTODATETIME, to_char(APPT_FROM_TIME,\'hh24:mi\') APPT_FROM_TIME1, to_char(APPT_TO_TIME,\'hh24:mi\')  APPT_TO_TIME1,SPECIALITY_DESC SPECIALITY_DESC1,SPECIALITY_CODE SPECIALITY_CODE1, SURGEON_NAME SURGEON_NAME1 FROM OT_SCHD_OPERS_VW A  where OPERATING_FACILITY_ID = \'\"+frmObj.facility_id.value+\"\' and A.LANGUAGE_ID=\'\"+locale+\"\' \";\n\t\tvar where=\"\";\n\n\t\tif(frmObj.speciality_code.value!=null && frmObj.speciality_code.value!=\'\')\n\t\t\twhere=escape(\"  and instr(NVL(ALL_SPECIALITY_CODES,SPECIALITY_CODE),\'#\"+frmObj.speciality_code.value+\"#\') > 0 \");\n\n\t\tif(frmObj.theatre_type_code.value!=null && frmObj.theatre_type_code.value!=\'\')\n\t\twhere+=escape(\" and OPER_ROOM_CODE IN (SELECT OPER_ROOM_CODE FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID=\'\"+facility_id+\"\' AND THEATRE_TYPE=\'\"+frmObj.theatre_type_code.value+\"\')\");\n\n\n\t\tif(frmObj.surgeon_code.value!=null && frmObj.surgeon_code.value!=\'\')\n\t\twhere+=escape(\" and SURGEON_CODE =\'\"+frmObj.surgeon_code.value+\"\'\");\n\nif(frmObj.room_code.value!=null && frmObj.room_code.value!=\'\')\n\twhere+=escape(\" and OPER_ROOM_CODE =\'\"+frmObj.room_code.value+\"\'\");\n\n\n\t\tif((change_from_date!=null && change_from_date!=\'\')||(change_to_date!=null && change_to_date!=\'\'))\n\t\t where +=escape(\" AND APPT_DATE  BETWEEN TO_DATE(NVL(\'\"+change_from_date+\"\',\'01/01/1900\')||\'00:00\', \'DD/MM/YYYY HH24:MI\') AND TO_DATE(NVL(\'\"+change_to_date+\"\',\'01/01/3000\')|| \'23:59\',\'DD/MM/YYYY HH24:MI\')\");\n\n\n\t\tif((frmObj.ref_no.value !=null && frmObj.ref_no.value!=\'\')||(frmObj.ref_no.value!=null && frmObj.ref_no.value!=\'\'))\n\t\t\twhere+= escape(\" AND APPT_REF_NUM =\'\"+frmObj.ref_no.value+\"\' \");\n\n\n\t\tif(frmObj.patient_id.value!=null && frmObj.patient_id.value!=\'\')\n\t\t\t   where+=escape(\" and PATIENT_ID =\'\"+frmObj.patient_id.value+\"\'\");\n\t\telse\n\t\t if(frmObj.patient_name.value!=null&&frmObj.patient_name.value!=\'\')\n\t\t\t\twhere+= escape(\" and UPPER(patient_name) like UPPER(\'\"+frmObj.patient_name.value+\"%\')\");\n\n\t\twhere += escape(\" AND OPER_NUM IS NULL \");\n\t\twhere += escape(\" AND NVL(BOOKING_STATUS,\'X\') <> \'9\' AND NVL(OPER_STATUS,\'XX\') <> \'99\' \");\n\n\t\tsql+=where;  \n\n\t\t\tvar param=\'sql=\'+sql+\'&date_compare=\'+dateUtils(frmObj.date_compare.value,locale)+\'&cancel_yn=\'+frmObj.cancel_yn.value+\'&transfer_yn=\'+frmObj.transfer_yn.value+\"&from=\"+from+\"&to=\"+to+\"&speciality_code=\"+frmObj.speciality_code.value+\"&surgeon_code=\"+frmObj.surgeon_code.value+\"&ref_no=\"+frmObj.ref_no.value+\"&patient_id=\"+frmObj.patient_id.value+\"&patient_name=\"+frmObj.patient_name.value+\"&from_date=\"+frmObj.from_date.value+\"&to_date=\"+frmObj.to_date.value+\"&room_code=\"+frmObj.room_code.value+\"&theatre_type_code=\"+frmObj.theatre_type_code.value+\"&room_code=\"+frmObj.room_code.value+\"&function_id=\"+frmObj.function_id.value;\n\t\tparent.parent.frames[1].location.href = \'../../eOT/jsp/CancelTransferDtlFrm.jsp?\'+param;\t\n\t}else{\n\t\t //alert(\"APP-OT1 Appt Date cannot be Blank\");\n\t\t var msg = getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\t var msgArray = msg.split(\"&\");\n\t\t //alert(msgArray[0]+\" Appt Date \"+msgArray[1]);\n\t\t alert(msgArray[0]+getLabel(\"Common.AppointmentDate.label\",\"Common\")+msgArray[1]);\t\t \n\t}\n}\n}\n</script>\n </head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'pendingOrderDtlForm\' id=\'pendingOrderDtlForm\' action=\'\' method = \'post\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t\t\t\n\n\t\t<table width=\'100%\' border=\'0\' align=\'center\' >\n\t\t<tr>\n\t\t<td width=\'20%\' align=\'right\' class=\'NONURGENT\'>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =",";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")\' id=\'prev\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\' id=\'next\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a><input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\n\t</td>\n\t </tr>\n\t</table>\n\n\t\t<table class=\'grid\' border=\'1\' width=\'100%\' cellpadding=3 cellspacing=0>\n<tr>\n\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\t\t\n\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n</tr>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<tr>\n\t\t<input type=\'hidden\' name=\'xx";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'xx";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=\'hidden\' name=\'splty";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'splty";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' >\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<td ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="  width=\'10%\' class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  align=\'left\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t<td ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="  width=\'11%\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="  width=\'20%\'class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  align=\'left\'nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  align=\'left\' nowrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="  width=\'5%\' class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" width=\'5%\' class=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="  width=\'15%\' class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" width=\'15%\'class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n </table>\n\n <input type=\'hidden\' name=\'param1\' id=\'param1\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n <input type=\'hidden\' name=\'login_user\' id=\'login_user\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n <input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n <input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\'hidden\' name=\'from_date\' id=\'from_date\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\'hidden\' name=\'theatre_type_code\' id=\'theatre_type_code\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\'hidden\' name=\'surgeon_code\' id=\'surgeon_code\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\'hidden\' name=\'room_code\' id=\'room_code\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\'hidden\' name=\'ref_no\' id=\'ref_no\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type=\'hidden\' name=\'date_compare\' id=\'date_compare\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\'hidden\' name=\'cancel_yn\' id=\'cancel_yn\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<input type=\'hidden\' name=\'transfer_yn\' id=\'transfer_yn\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<input type=\'hidden\' name=\'restrict_theatre_booking_yn\' id=\'restrict_theatre_booking_yn\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<input type=\'hidden\' name=\'book_yn\' id=\'book_yn\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\"patientId\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"><!--PMG MOD CRF-0024 US-3-->\n\n </form>\n \t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n</html>\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );
 public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	String facilityid  = (String) session.getValue("facility_id");
	Connection conn=null;
	PreparedStatement pstmt=null;	
	ResultSet rs=null;
	String user_id = (String)session.getValue("login_user");
	int fetchCount=0;
	String sql="",function_id="",strApptRefNo="",strApptDate="",strPatientId="",strPatientName="",strOperRoomDesc="",strApptFromTime="",strApptToTime="",strSpecialityDesc="",strSpecialityCode="",strSurgeonName="",strSurgeonCode="",strSysDate="",strCancelYN="",strTransferYN="",strOrderId="",strQuery="";
	String apptfromdatetime = "";
	String appttodatetime = "";

	String cancelappointment_title   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels");
	String transferappointment_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels");
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;
		String from = request.getParameter( "from"  );
		String to = request.getParameter( "to")  ;
		String from_date = request.getParameter( "from_date") ;
		String to_date = request.getParameter( "to_date" );
		String surgeon_code = CommonBean.checkForNull(request.getParameter( "surgeon_code" )) ;
		String theatre_type_code = CommonBean.checkForNull(request.getParameter( "theatre_type_code" )) ;
		String speciality_code = CommonBean.checkForNull(request.getParameter( "speciality_code" )) ;
		String patient_id = CommonBean.checkForNull(request.getParameter( "patient_id" )) ;
		String patient_name =CommonBean.checkForNull( request.getParameter( "patient_name" )) ;
		String room_code =CommonBean.checkForNull( request.getParameter( "room_code" )) ;
		String ref_no =request.getParameter( "ref_no" ) ;
		if(ref_no ==null) ref_no="";
		String date_compare = request.getParameter( "date_compare" ) ;
		String cancel_yn =CommonBean.checkForNull( request.getParameter( "cancel_yn" )) ;
		 function_id =CommonBean.checkForNull( request.getParameter( "function_id" )) ;
		String transfer_yn =CommonBean.checkForNull( request.getParameter( "transfer_yn" )) ;
		String restrict_theatre_booking_yn =CommonBean.checkForNull( request.getParameter( "restrict_theatre_booking_yn" )) ;
		String book_yn =CommonBean.checkForNull( request.getParameter( "book_yn" )) ;
		int start = 0 ;
		int end = 0 ;
		int s=0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 15 ;
	else
		end = Integer.parseInt( to ) ;

try{

	conn = ConnectionManager.getConnection(request);

	strCancelYN=checkForNull(request.getParameter("cancel_yn"));
	strTransferYN=checkForNull(request.getParameter("transfer_yn"));
	sql=StringEscapeUtils.unescapeHtml(request.getParameter("sql"));
	strSysDate=request.getParameter("date_compare");
	pstmt=conn.prepareStatement(sql);
	rs=pstmt.executeQuery();

		if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{

while(s<=end && rs.next()){
			
			if(fetchCount==0)
						{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block10Bytes, _wl_block10);

		if ( !(start <= 1)) {
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start-15)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end-15)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
		//	if ( !((start+15) > fetchCount ))
				{
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start+15)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end+15)));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
		
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);


	}
		strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
		strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));
		strApptRefNo=checkForNull(rs.getString("APPT_REF_NUM1"));
		strApptDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("APPT_DATE1"),"DMY","en",locale));
		strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));	
		strSpecialityCode=checkForNull(rs.getString("SPECIALITY_CODE1"));
		strSurgeonName=checkForNull(rs.getString("SURGEON_NAME1"));
		strApptFromTime=checkForNull(rs.getString("APPT_FROM_TIME1"));
		strApptToTime=checkForNull(rs.getString("APPT_TO_TIME1"));	
		apptfromdatetime = checkForNull(rs.getString("APPTFROMDATETIME"));
		appttodatetime = checkForNull(rs.getString("APPTTODATETIME"));
		strSurgeonCode=checkForNull(rs.getString("SURGEON_CODE1"));	
		strOperRoomDesc=checkForNull(rs.getString("OPER_ROOM_DESC1"));
		strOrderId=checkForNull(rs.getString("ORDER_ID1"));

		if(strSurgeonCode.equals("")){
				strSurgeonName=all_surgeons;
			}

	strQuery=(fetchCount%2==0)?"class='gridData'":"class='gridData'";
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block26Bytes, _wl_block26);

		out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue'  onClick=\"commonDisplayTooltip('CT1,CT2','"+cancelappointment_title+","+transferappointment_title+"','"+strApptRefNo+","+facilityid+","+strSurgeonCode+","+fetchCount+","+strSysDate+","+strSpecialityCode+","+fetchCount+","+strOrderId+","+strPatientId+","+strApptFromTime+","+strApptToTime+"',this,'imgArrow"+fetchCount+"');\" width='5%'  onMouseOver='hideToolTip();'><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('CT1,CT2','"+cancelappointment_title+","+transferappointment_title+"','"+strApptRefNo+","+facilityid+","+strSurgeonCode+","+fetchCount+","+strSysDate+","+strSpecialityCode+","+fetchCount+","+strOrderId+","+strPatientId+","+strApptFromTime+","+strApptToTime+"',this,'imgArrow"+fetchCount+"');\">"+strApptRefNo+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strApptDate));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strOperRoomDesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strApptFromTime));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strApptToTime));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block39Bytes, _wl_block39);
fetchCount ++;
	s++;

		}
	}
if(fetchCount==0)
	 out.println("<script>callNoRecord1();</script>");

	if ( fetchCount < 15 || (!rs.next()) ) {
		
            _bw.write(_wl_block40Bytes, _wl_block40);
 
				} else {
            _bw.write(_wl_block41Bytes, _wl_block41);
}

}catch(Exception ee){
	System.err.println("Err Msg in CancelTransferDtl.jsp: "+ee);
	ee.printStackTrace();
}
finally{
	if(rs!=null) rs.close();
	pstmt.close();
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(theatre_type_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(room_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(ref_no));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(date_compare));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(cancel_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(transfer_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(restrict_theatre_booking_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(book_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block63Bytes, _wl_block63);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Appt.RefNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AppointmentDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
}
