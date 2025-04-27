package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eOT.*;
import eOT.Common.*;
import eOT.Common.OTRepository;
import java.net.URLDecoder;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __pendingorderdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PendingOrderDtl.jsp", 1723884686775L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<STYLE TYPE=\"text/CSS\">\n\n/* This style is used for the horizontal and vertical scroll - SKR-SCF-0847 [IN:044280]  */\ndiv#order_ctlg_tbl {\nwidth: 100%;\nheight: 100%;\noverflow-x: auto;\noverflow-y: auto;\nposition: fixed;\n}\n\n#Dis{\n\tbottom:-10;\n\tposition:absolute;\n    color:red;\t\n\tfont:italic;\n\tfont-family:\'sans\';\n}\n\n</STYLE>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<link rel=\'StyleSheet\' href=\'../../eOT/html/style.css\' type=\'text/css\'/>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eOT/js/jquery-latest.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/Booking.js\'></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script>\n// Commented Against TH-KW-CRF-0126\n/* function submitPrevNext(from, to) \n{\n\tdocument.forms[0].from.value = from;\n\tdocument.forms[0].to.value = to;\t\n\tvar frmObj=document.forms[0];\n\tvar locale = frmObj.locale.value;\n\t//MMS-QH-CRF-0186\n\tvar ammendBooking = $(\'#ammendBooking\').val();\n\tvar ChkExistDays;\t\n\tif(frmObj.chkBookingExistDays.value != \'\')\n\t{\n\t\tChkExistDays=\"+\"+\" \"+frmObj.chkBookingExistDays.value;\n\t}\n\telse\n\t{\n\t\tChkExistDays=\"+ 0\";\n\t}\n\t//MMS-QH-CRF-0186\n\t\n\t//\tvar sql=\"SELECT PATIENT_ID PATIENT_ID1,PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,SHORT_NAME SHORT_NAME1, SEX SEX1, SURGERY_NATURE_DESC SURGERY_TYPE1, SPECIALITY_DESC SPECIALITY_DESC1, TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, ORDER_ID ORDER_ID1,WAITLIST_NUM WAITLIST_NUM1, to_char(PREF_SURG_DATE,\'dd/mm/yyyy\') PREF_SURG_DATE1 FROM OT_PENDING_ORDERS_VW   WHERE PERFORMING_FACILITY_ID = \'\"+frmObj.facility_id.value+\"\'\";\n\n\t// added by rajesh for from/to date thai conversion\n\t\tvar change_from_date = dateUtils(frmObj.from_date.value,locale); \n\t\tvar change_to_date = dateUtils(frmObj.to_date.value,locale);\n\t\tif(!callDateCheck(change_from_date,change_to_date)) return;\n\n\tif(frmObj.from_date.value!=\'\')\n\t{\n\t\tvar sql = \" SELECT DISTINCT \";\n\t\tif((typeof(frmObj.priority) == \'undefined\') || (frmObj.priority.value != null && frmObj.priority.value == \'\'))\n\t\t{\n\t\t\tsql += \" A.PATIENT_ID PATIENT_ID1,A.ENCOUNTER_ID ENCOUNTER_ID1,A.EPISODE_TYPE EPISODE_TYPE1,A.VISIT_ID VISIT_ID1,A.SPECIALITY_CODE SPECIALITY_CODE1,to_char(A.ORDER_DATE_TIME,\'dd/mm/yyyy\') ORDER_DATE_TIME1,to_char(A.PREF_SURG_DATE,\'dd/mm/yyyy\') PREF_SURG_DATE1, (select decode( \'\"+locale+\"\' ,\'en\',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) SHORT_NAME1, A.SEX SEX1, A.SURGERY_NATURE_DESC SURGERY_NATURE_DESC1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, A.ORDER_ID ORDER_ID1,A.PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,A.STATUS STATUS1, A.WAITLIST_NUM WAITLIST_NUM1,b.oper_code oper_code,B.SHORT_DESC OPER_DESC1, b.long_desc longdesc, a.physician_id physician_id ,(SELECT c.short_name FROM am_practitioner_lang_vw c WHERE c.practitioner_id = a.physician_id AND c.language_id =\'\"+locale+\"\') ordering_surgeon_name,(SELECT COUNT (*) booking_cnt   FROM ot_booking_hdr c  WHERE c.patient_id = a.patient_id AND c.operating_facility_id = \'\"+frmObj.facility_id.value+\"\' AND  c.booking_start_time >= SYSDATE AND c.booking_start_time <= SYSDATE \"+encodeURIComponent(ChkExistDays,\"UTF-8\")+\"  AND c.booking_status != \'9\' AND EXISTS ( SELECT 1 AS booking_final FROM ot_queue d  WHERE d.appt_ref_num = c.booking_num  AND (booking_stage < (select stage_code from ot_booking_fin_stages where serial_no=(select max(serial_no) from ot_booking_fin_stages)) OR booking_stage IS NOT NULL)) )as booking_cnt, ot_check_consent(a.order_id) AS consentresult  FROM OT_PENDING_ORDERS_VW A, OT_OPER_MAST_LANG_VW B  \";\n\t\t\t//KDAH-CRF-0283 [IN:050553] MMS-QH-CRF-186 added on 27-Sept-2015 & IN066057\n\n\t\t\tsql += \"WHERE A.LANGUAGE_ID=\'\"+locale+\"\' AND B.LANGUAGE_ID=\'\"+locale+\"\'\";\n\t\t\tsql += \"AND  A.PERFORMING_FACILITY_ID =\'\"+frmObj.facility_id.value+\"\'\";\n\t\t\t\n\t\t\tsql += \"AND B.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_PENDING_ORDER_LINE WHERE ORDER_ID = A.ORDER_ID AND ROWNUM = 1)\";//MO-GN-5507\n\t\t\t\n\t\t}\n\t\telse if(frmObj.priority.value != null && frmObj.priority.value != \'\')\n\t\t{\n\t\t\tsql += \" order_field_mnemonic, order_field_value, A.PATIENT_ID PATIENT_ID1,A.ENCOUNTER_ID ENCOUNTER_ID1,A.EPISODE_TYPE EPISODE_TYPE1,A.VISIT_ID VISIT_ID1,A.SPECIALITY_CODE SPECIALITY_CODE1,to_char(A.ORDER_DATE_TIME,\'dd/mm/yyyy\') ORDER_DATE_TIME1,to_char(A.PREF_SURG_DATE,\'dd/mm/yyyy\') PREF_SURG_DATE1, (select decode( \'\"+locale+\"\' ,\'en\',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) SHORT_NAME1, A.SEX SEX1, A.SURGERY_NATURE_DESC SURGERY_NATURE_DESC1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, A.ORDER_ID ORDER_ID1,A.PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,A.STATUS STATUS1, A.WAITLIST_NUM WAITLIST_NUM1,b.oper_code oper_code, B.SHORT_DESC OPER_DESC1, b.long_desc longdesc, a.physician_id physician_id ,(SELECT COUNT (*) booking_cnt   FROM ot_booking_hdr c  WHERE c.patient_id = a.patient_id AND c.operating_facility_id = \'\"+frmObj.facility_id.value+\"\' AND  c.booking_start_time >= SYSDATE AND c.booking_start_time <= SYSDATE \"+encodeURIComponent(ChkExistDays,\"UTF-8\")+\"  AND c.booking_status != \'9\' AND EXISTS ( SELECT 1 AS booking_final FROM ot_queue d  WHERE d.appt_ref_num = c.booking_num  AND (booking_stage < (select stage_code from ot_booking_fin_stages where serial_no=(select max(serial_no) from ot_booking_fin_stages)) OR booking_stage IS NOT NULL)) )as booking_cnt, ot_check_consent(a.order_id) AS consentresult  FROM OT_PENDING_ORDERS_VW A, OT_OPER_MAST_LANG_VW B, or_order_field_values c  WHERE A.LANGUAGE_ID=\'\"+locale+\"\' AND B.LANGUAGE_ID=\'\"+locale+\"\' AND a.order_id = c.order_id AND  A.PERFORMING_FACILITY_ID =\'\"+frmObj.facility_id.value+\"\' \"; // KDAH-CRF-0283 [IN:050553]MMS-QH-CRF-186 & IN066057\n\n\t\t\tsql += \"and ORDER_FIELD_MNEMONIC = \'PRIORITY\'\";\n\t\t\t\n\t\t\tsql += \"AND B.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_PENDING_ORDER_LINE WHERE ORDER_ID = A.ORDER_ID AND ROWNUM = 1)\";//MO-GN-5507\n\t\t}\n\n\t\tvar where = \" \";\n\t\tif(frmObj.speciality_code.value!=null && frmObj.speciality_code.value!=\'\')\n\t\t\twhere+=escape(\" and A.SPECIALITY_CODE =\'\"+frmObj.speciality_code.value+\"\'\");\n\n\t\tif(frmObj.surgeon_code.value!=null && frmObj.surgeon_code.value!=\'\') // start KDAH-CRF-0283 [IN:050553]\n\t\t{\n\t\t\tif(frmObj.customerId.value == \'KDAH\')\n\t\t\t\twhere += escape(\" and A.physician_id =\'\"+frmObj.surgeon_code.value+\"\'\");\n\t\t\telse\n\t\t\t\twhere += escape(\" and A.PERFORMING_TEAM_SURGEON =\'\"+frmObj.surgeon_code.value+\"\'\");\n\t\t} // end KDAH-CRF-0283 [IN:050553]\n\n\t\tif(frmObj.order_id.value!=null && frmObj.order_id.value!=\'\')\n\t\t\twhere+=escape(\" and A.ORDER_ID =\'\"+frmObj.order_id.value+\"\'\");\n\n\t\tif((frmObj.from_date.value!=null && frmObj.from_date.value!=\'\')||(frmObj.to_date.value!=null && frmObj.to_date.value!=\'\'))\n\t\t\twhere +=escape(\" AND A.PREF_SURG_DATE  BETWEEN TO_DATE(NVL(\'\"+change_from_date+\"\',\'01/01/1900\')||\'00:00\', \'DD/MM/YYYY HH24:MI\') AND TO_DATE(NVL(\'\"+change_to_date+\"\',\'01/01/3000\')|| \'23:59\',\'DD/MM/YYYY HH24:MI\')\");\n\n\t\tif(frmObj.patient_id.value!=null && frmObj.patient_id.value!=\'\')   \n\t\t\twhere+=escape(\" and PATIENT_ID =\'\"+frmObj.patient_id.value+\"\'\");\n\t\telse if(frmObj.patient_name.value!=null&&frmObj.patient_name.value!=\'\') \n\t\t\twhere+= escape(\" and short_name like \'\"+frmObj.patient_name.value+\"%\'\");\n\t\t if(frmObj.checkin_booking_flag.value==\'CHECK_IN\')\n\t\t\twhere+= \" and  A.STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE =\'10\' )\";\n\n\t\t//if(ammendBooking == \'Y\')\n\t\t\t//where += \"order by A.PATIENT_ID,pref_surg_date1 ,b.long_desc,a.speciality_desc\";\n\t\twhere += \"ORDER BY a.patient_id, pref_surg_date1, a.speciality_desc,b.long_desc\"; //added by selvin\n\t\tsql+=where;\n\t\talert(\"sql===>\"+sql)\n\t\t// start KDAH-CRF-0283 [IN:050553]\n\t\tvar param=\'sql=\'+sql+\'&surgeonCode=\'+frmObj.surgeon_code.value+\'&checkin_booking_flag=\'+frmObj.checkin_booking_flag.value+\"&from=\"+from+\"&to=\"+to+\"&speciality_code=\"+frmObj.speciality_code.value+\"&surgeon_code=\"+frmObj.surgeon_code.value+\"&order_id=\"+frmObj.order_id.value+\"&patient_id=\"+frmObj.patient_id.value+\"&patient_name=\"+frmObj.patient_name.value+\"&from_date=\"+frmObj.from_date.value+\"&to_date=\"+frmObj.to_date.value+\"&called_from=\"+frmObj.called_from.value; //+\"&totalRecCnt=\"+totalRecCnt; //+\"&totalRecCnt=\"frmObj.totalRecCnt.value; // Added [called_from] against for [IN:057473] \n\t\tif(frmObj.priority != null && frmObj.priority != \'undefined\')\n\t\t\tparam += \"&priorityValue=\"+frmObj.priority.value;\n\t\tparam += \"&bookingPriorityOrdersYN=\"+frmObj.bookingPriorityOrdersYN.value\n\t\t\t\t\t\t+\"&customerId=\"+frmObj.customerId.value;\n\t\t// end KDAH-CRF-0283 [IN:050553]\n\t\talert(\"param =>\"+param)\n\t\tparent.parent.qa_query_result.location.href = \'../../eOT/jsp/PendingOrderDtlFrame.jsp?\'+param;\t\n\t\t//End IN024288\n\t}\n\telse\n\t{\n\t\tvar msg = getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\tvar msgArray = msg.split(\"&\");\n\t\talert(msgArray[0]+getLabel(\"Common.fromdate.label\",\"Common\")+msgArray[1]);\n\t}\n} */\n</script>\n<head>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script> <!-- KDAH-CRF-0283 [IN:050553] -->\n<div id=\"order_ctlg_tbl\"><!--Added for the SCF - SKR-SCF-0847 [IN:044280] -->      \n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'pendingOrderDtlForm\' id=\'pendingOrderDtlForm\' action=\'\' method = \'post\'>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t<table width=\'100%\' border=\'0\' align=\'center\' >\n\t\t<tr>\n\t\t<td width=\'20%\' align=\'right\' class=\'NONURGENT\'>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =",";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\' id=\'prev\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\' id=\'next\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a><input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\n\t</td>\n\t </tr>\n\t</table>\n\n\t\t\t<table class=\'grid\' border=\'1\' width=\'100%\' cellpadding=3 cellspacing=0>\n<tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<th class=\'columnHeader\' nowrap>\n\t\t\t\t\t<input type=\"checkbox\" name=\"bukngsToSchedule\" id=\"bukngsToSchedule\" id=\"bukngsToSchedule\" onclick=\"disableAll(\'\', \'All\');\" disabled>\n\t\t\t\t</th>\n\t\t\t\t<!--MMS-QH-CRF-0186-->\n\t\t\t\t<th class=\"columnHeader\" nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</th>\n\t\t\t\t<!--MMS-QH-CRF-0186-->\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n            <th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</th>\t\t\n\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</th>\t\t\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</tr>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<input type=\'hidden\' name=\'patIdCnt";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'patIdCnt";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n\t\t\t<input type=\'hidden\' name=\'xx";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'xx";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<input type=\'hidden\' name=\'yy";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'yy";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t<input type=\'hidden\' name=\'speciality_code_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'speciality_code_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=\'hidden\' name=\'selOrderIds_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'selOrderIds_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\'hidden\' name=\'operCode_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'operCode_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t<input type=\'hidden\' name=\'surgeonCode_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'surgeonCode_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t<input type=\'hidden\' name=\'prefDate_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'prefDate_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t<tr>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<!--MMS-QH-CRF-0186-->\n\t\t\t\n\t\t\t\t<td ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" nowrap> \n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t<input type=\"checkbox\" name=\"bukngsToSchedule";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"bukngsToSchedule";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" onclick=\"disableAll(\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\', \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\">  ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<input type=\"hidden\" name=\"chkBoxSelect";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"chkBoxSelect";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" value=\'false\'> ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t<!--<input type=\"checkbox\" name=\"bukngsToSchedule";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\');\" disabled> -->\n\t\t\t\t<input type=\"checkbox\"  disabled>\n\t\t\t\t\n\t\t\t\t<!--<input type=\"checkbox\" name=\"bukngsToSchedule";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\');\"> -->\n\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<!--MMS-QH-CRF-0186-->\n\t\t\t\t<!--MMS-QH-CRF-0186 start-->\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<!--<td nowrap style=\"FONT-SIZE: 8pt ;BORDER-STYLE: solid;BORDER-BOTTOM: #CC9966 0px solid;BORDER-LEFT: #CC9966 0px solid;BORDER-RIGHT:#CC9966 0px solid;BORDER-TOP: #CC9966 1px solid;BACKGROUND-COLOR:green\"></td>-->\n\t\t\t\t\t<td align==\'right\' width=\'2%\' class=\'gridDataBookingAvailabel\'>&nbsp; </td>\n\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t<td ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" nowrap>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\t\t\t\t\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t<!--MMS-QH-CRF-0186 end-->\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t<!--MMS-QH-CRF-0186 start-->\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t<td ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" nowrap></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" nowrap><img id=\"img_src_res\" src=\'../../eOT/images/Obtained.PNG\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" nowrap><img id=\"img_src_res\" src=\'../../eOT/images/NotObtained.PNG\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t<!--<td ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" nowrap><img id=\"img_src_res\" src=\'../../eOT/images/Obtained.PNG\'></td>-->\n                \n   ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t <td ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" nowrap> ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\t\t\n        ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t   <td ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" nowrap>NA</td>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t        <td ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" </td>\n    ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t<!--Added Against TH-KW-CRF-0126...ends-->\n\t\t\t\t<!--MMS-QH-CRF-0186 end-->\n\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" </td>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t<td ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" </td>\n\t\t\t<td ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" </td>\n\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t<td ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" OnMouseOver=\"showOperLongDesc(\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\')\"  onmouseout=\"hideToolTip1()\" nowrap >\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" nowrap >\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" nowrap>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t</td>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" nowrap>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t\t\t<td ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" nowrap> \n\t\t\t\t\t<a href=\'javascript:showPreOperativeComments(\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\", \"Pre-Operative Clinical Comments\");\'> Pre-operative clinical comments  </a> <!-- KDAH-CRF-0283 [IN:050553] -->\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t</tr>\n\t\t\t<input type=\'hidden\' name=\'reason";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' id=\'reason";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' > \n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t<input type=\'hidden\' name=\'patIdCnt";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="<script>callNoRecord();</script>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n </table>\n ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n <div id=\"Dis\">\n <h4>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</h4>\n </div>\n ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n </div>\n\n<input type=\'hidden\' name=\'checkin_booking_flag\' id=\'checkin_booking_flag\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n<input type=\'hidden\' name=\'from_date\' id=\'from_date\' value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"><!-- PMG2014-CRF-0024 U-3-->\n<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' id=\"patientId\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n<input type=\'hidden\' name=\'surgeon_code\' id=\'surgeon_code\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n<input type=\'hidden\' name=\'priority\' id=\'priority\' id=\'priority\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n<input type=\'hidden\' name=\'customerId\' id=\'customerId\' id=\'customerId\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'> <!-- KDAH-CRF-0283 [IN:050553] -->\n<input type=\'hidden\' name=\'bookingPriorityOrdersYN\' id=\'bookingPriorityOrdersYN\' id=\'bookingPriorityOrdersYN\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'> <!-- KDAH-CRF-0283 [IN:050553] -->\n<input type=\"hidden\" name=\"todaysDate\" id=\"todaysDate\" id=\"todaysDate\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"> ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n<input type=\"hidden\" name=\"totalRecCnt\" id=\"totalRecCnt\" id=\"totalRecCnt\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n<input type=\"hidden\" name=\"ammendBooking\" id=\"ammendBooking\" id=\"ammendBooking\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n<input type=\"hidden\" name=\"chkBookingExistDays\" id=\"chkBookingExistDays\" id=\"chkBookingExistDays\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"> \n<input type=\"hidden\" name=\"selSpeciality\" id=\"selSpeciality\" id=\"selSpeciality\" value=\'\'>\n<input type=\"hidden\" name=\"selOrderId\" id=\"selOrderId\" id=\"selOrderId\" value=\'\'>\n<input type=\"hidden\" name=\"NoOfCheckBoxSelected\" id=\"NoOfCheckBoxSelected\" id=\"NoOfCheckBoxSelected\" value=\'\'>\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n<input type=\'hidden\' name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"> <!-- Added against for [IN:057473] -->\n</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'>\n</div>\n </body>\n</html>\n\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 /* request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); */
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String	called_from = checkForNull(request.getParameter("called_from")); // [IN:057473]
	
            _bw.write(_wl_block9Bytes, _wl_block9);
  
	String strPatientId="",strEncounterId ="",strEpisodeType ="",strPatientName="",strSex="",strSurgeoryType="",strSpecialityDesc="",strSpecialityCode="",strSurgeonName="",
	strSurgeonCode="",strOrderId="",strQuery="",strOperDesc="",operCode="",strPrefDate="",strWaitListNo="",strStatus="",strCheckinFlag="",strOrderStatus="",strPriority="",strOrderDate="",sql="";
	String strMnemonic = "";
	StringBuffer innerSql = new StringBuffer();
	// start KDAH-CRF-0283 [IN:050553]
	String longDescription = ""; 
	String physicianId = "";
	String patientAge = "";
	StringBuffer getAgeSqlBuffer = new StringBuffer(); 
	// end KDAH-CRF-0283 [IN:050553]
	String priorityColValue = "";
	int daysGap = 0;
	StringBuffer strTempBookNo=new StringBuffer();
	Connection conn=null;
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;
	String todaysDate = com.ehis.util.DateUtils.getCurrentDate("dd/mm/yyyy", locale);
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement innerPstmt = null;
	//MMS-QH-CRF-0186 start
	PreparedStatement innerPstmtConsent = null;
	StringBuffer ConsentImageQuery=new StringBuffer();
	boolean ConsentNotRecord=false,ConsentRecord=false,ConsentNotRequired=false;
	//newly added by vikash	for 186
	String consentresutlt="";	
	//Added against TH-KW-CRF-0126...starts
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	boolean isInsuranceStatus = false;
    boolean bill_flag = false;	
	String patient_class = "";
	String order_line_no = "";
	ResultSet resultset = null;
	//Added against TH-KW-CRF-0126...ends
	
	ConsentImageQuery.append("	SELECT NVL (ord_consent_reqd_yn, 'N') ord_consent_reqd_yn,					");
	ConsentImageQuery.append("	NVL (num_of_consent_req_bo, 0)												");
	ConsentImageQuery.append("	+ NVL (num_of_consent_req_br, 0) ord_consent_status							");
	ConsentImageQuery.append("	FROM or_order_line a														");
	ConsentImageQuery.append("	WHERE order_id = ?															");
	ConsentImageQuery.append("	AND NVL (num_of_consent_req_bo, 0) + NVL (num_of_consent_req_br, 0) < =		");
	ConsentImageQuery.append("	(SELECT COUNT (*)															");
	ConsentImageQuery.append("	FROM or_consent_ref_dtl b													");
	ConsentImageQuery.append("	WHERE order_id = a.order_id AND order_line_num = a.order_line_num)			");
	//MMS-QH-CRF-0186 End
	
	// start KDAH-CRF-0283 [IN:050553]
	PreparedStatement getAgePstmt = null;
	ResultSet getAgeRs = null;
	// end KDAH-CRF-0283 [IN:050553]
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet innerRs = null;
	//MMS-QH-CRF-0186
	ResultSet innerRsConsent = null;
	int fetchCount=0;
	String visit_id="";
	String episode_id="";
	String from = request.getParameter( "from"  );
	String to = request.getParameter( "to")  ;
	String from_date = request.getParameter( "from_date") ;
	String to_date = request.getParameter( "to_date" );
	String surgeon_code = CommonBean.checkForNull(request.getParameter( "surgeon_code" )) ;
	String order_id = CommonBean.checkForNull(request.getParameter( "order_id" )) ;
	String priorityValue = CommonBean.checkForNull(request.getParameter( "priorityValue" )) ;
	String customerId = CommonBean.checkForNull(request.getParameter( "customerId" )) ;//KDAH-CRF-0283 [IN:050553]
	String bookingPriorityOrdersYN = CommonBean.checkForNull(request.getParameter( "bookingPriorityOrdersYN" )) ;//KDAH-CRF-0283 [IN:050553]
	String speciality_code = CommonBean.checkForNull(request.getParameter( "speciality_code" )) ;
	String patient_id = CommonBean.checkForNull(request.getParameter( "patient_id" )) ;
	String priority = CommonBean.checkForNull(request.getParameter( "priority" )) ;
	String patient_name =CommonBean.checkForNull( request.getParameter( "patient_name" )) ;
	String facilityid=(String)session.getValue("facility_id");
	//MMS-QH-CRF-0186
	String ammendBooking = "";
	String chkBookingExistDays = "";
	String tempStrPatientId = "";
	//MMS-QH-CRF-0186

	int patIdCnt = 0;
	int start = 0 ;
	int end = 0 ;
	int s=0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 10 ;		
	else
		end = Integer.parseInt( to ) ;

	try{
		conn = ConnectionManager.getConnection(request);
		
		//Added Against TH-KW-CRF-0126...starts
		isInsuranceStatus = CommonBean.isSiteSpecific(conn,"OT","OT_BILLING_STATUS");
		System.err.println("isInsuranceStatus --->"+isInsuranceStatus);
				
		CallableStatement cstmt = null;
	    String bl_installed="";
	    String err_text = "";
	    String bl_interface="";
		String params = request.getQueryString();
	    called_from = CommonBean.checkForNull(request.getParameter("called_from"));

		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=conn.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facilityid );
		cstmt.setString(2,facilityid );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			bill_flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}else
		{
			//err_text = cstmt.getString(7);
			err_text = cstmt.getString(8);
		}
		
		//Added Against TH-KW-CRF-0126...ends 
		
		//MMS-QH-CRF-0186 start
		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();
		String getValOfAmmendBooking = "select nvl(ammend_bookings, 'N') ammend_bookings, chk_bookings_exist_days from ot_param_for_facility where operating_facility_id =?";
		pstmt = conn.prepareStatement(getValOfAmmendBooking);
		pstmt.setString(1,facilityid);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			ammendBooking = rs.getString("ammend_bookings");
			chkBookingExistDays = rs.getString("chk_bookings_exist_days");
		}
		
		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();
		//MMS-QH-CRF-0186 end
		innerSql.append("	SELECT order_field_value	");
		innerSql.append("	FROM or_order_field_values	");
		innerSql.append("	WHERE order_id = ? AND order_field_mnemonic = 'PRIORITY'	");
		innerSql.append("	AND UPPER(order_field_value) IN ('PRIORITY-1','PRIORITY-2','PRIORITY-3')"); //Added for IN:045883
		if(priorityValue != null && priorityValue.trim().length() > 0)
			innerSql.append("	and order_field_value = ?	");
		innerPstmt = conn.prepareStatement(innerSql.toString());

		getAgeSqlBuffer.append("	SELECT mp_get_age_ymdh (a.date_of_birth, a.deceased_date) age	");
		getAgeSqlBuffer.append("	FROM mp_patient a	");
		getAgeSqlBuffer.append("	WHERE patient_id = ?		");
		getAgePstmt = conn.prepareStatement(getAgeSqlBuffer.toString());

		sql=OTRepository.getOTKeyValue("SQL_OT_PENDING_DTL_SELECT1");
		pstmt = conn.prepareStatement(sql);
		System.err.println("269, PendingOrderDtl.jsp sql==="+sql);
		rs=pstmt.executeQuery();
		if(rs.next())
			strOrderStatus=rs.getString("ORDER_STATUS_CODE1");
			//System.err.println("281,PendingOrderDtl.jsp strOrderStatus==="+strOrderStatus);
		if(rs!=null)
			rs.close();
		if(pstmt !=null)
			pstmt.close();

		strCheckinFlag=checkForNull(request.getParameter("checkin_booking_flag"));
 		strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));
		sql=request.getParameter("sql");
		System.err.println("281,sql==="+sql);
 		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		pstmt1=conn.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PENDING_DTL_SELECT2"));

			if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{

		while(s<=end && rs.next())
		{
		  strPatientId = checkForNull(rs.getString("PATIENT_ID1"));
		  
		  // Added against TH-KW-CRF-0126 Starts
		  strEncounterId = checkForNull(rs.getString("ENCOUNTER_ID1"));
		  strEpisodeType = checkForNull(rs.getString("EPISODE_TYPE1"));
		  strOrderId = checkForNull(rs.getString("ORDER_ID1"));
		 		  
		String sql1="select distinct a.patient_class from pr_encounter a, or_order b where a.patient_id = b.patient_id and a.patient_id=? and a.encounter_id=? and a.encounter_id = b.encounter_id " ;
			pstmt = conn.prepareStatement(sql1) ;
			pstmt.setString(1,strPatientId);
			pstmt.setString(2,strEncounterId);
				
			resultset = pstmt.executeQuery();
			if (resultset!=null && resultset.next()) {
				patient_class=resultset.getString("PATIENT_CLASS");
			}
			 if(patient_class.equals("OP") || patient_class.equals("EM")){
			        episode_id =strEncounterId.substring(0,(strEncounterId.length()-4));  
			        visit_id =strEncounterId.substring(strEncounterId.length()-4);  
				}
			  if(patient_class.equals("IP") || patient_class.equals("DC")){
							episode_id =strEncounterId; 
				} 
				
				
			String insurance_patient_yn = "";
			String insurance_status_desc ="";
			String PatientPayementStatus = "";
			ArrayList InsuranceDescList = new ArrayList();
		    InsuranceDescList=bean.getInsuranceDesc(strPatientId,episode_id,visit_id,strEpisodeType,facilityid,strOrderId);
		   PatientPayementStatus=bean.getPatientPayment(facilityid,"OR",strOrderId,"1");
		
		    System.err.println("InsuranceDescList :"+InsuranceDescList);
		  if(InsuranceDescList!=null && InsuranceDescList.size()>0)
			{
		   insurance_patient_yn = (String)InsuranceDescList.get(3);
		 if(insurance_patient_yn!=null || insurance_patient_yn!="C")
		  insurance_status_desc = (String)InsuranceDescList.get(2);
			}
		  
			// Added against TH-KW-CRF-0126 Ends
			
			if(fetchCount==0)
			{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);

		if ( !(start <= 1)) 
		{
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
		//	if ( !((start+11) > fetchCount ))
				{
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		
			}
		
            _bw.write(_wl_block19Bytes, _wl_block19);

	if(!called_from.equalsIgnoreCase("OT_MENU")) { // [IN:057473]

            _bw.write(_wl_block1Bytes, _wl_block1);

			if(ammendBooking != null && ammendBooking.equals("Y"))
			{

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			}

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
} // [IN:057473]
            _bw.write(_wl_block24Bytes, _wl_block24);

		if(isInsuranceStatus && bill_flag){ //Added Against TH-KW-CRF-0126
		
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

             }
			
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			} // end KDAH-CRF-0283 [IN:050553]

            _bw.write(_wl_block1Bytes, _wl_block1);

			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			}

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			}

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
			else
			{

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			}

            _bw.write(_wl_block1Bytes, _wl_block1);

			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

			}

            _bw.write(_wl_block35Bytes, _wl_block35);
 
			tempStrPatientId = strPatientId;
		}
			//strPatientId=checkForNull(rs.getString("PATIENT_ID1"));//186
			strPatientName=checkForNull(rs.getString("SHORT_NAME1"));
			strSex=checkForNull(rs.getString("SEX1"));
			//strMnemonic=checkForNull(rs.getString("ORDER_FIELD_MNEMONIC"));
			if(priorityValue != null && priorityValue.trim().length() > 0)
				priorityColValue = checkForNull(rs.getString("order_field_value"));
			strSurgeoryType=checkForNull(rs.getString("SURGERY_NATURE_DESC1"));	
			strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));
			strSpecialityCode=checkForNull(rs.getString("SPECIALITY_CODE1"));
			strSurgeonName=checkForNull(rs.getString("TEAM_SURGEON_NAME1"));
			strSurgeonCode=checkForNull(rs.getString("PERFORMING_TEAM_SURGEON1"));
			strWaitListNo=checkForNull(rs.getString("WAITLIST_NUM1"));
			strOperDesc=checkForNull(rs.getString("longdesc"));//MMS-QH-CRF-0199
			operCode = checkForNull(rs.getString("oper_code"));			
			strOrderId=checkForNull(rs.getString("ORDER_ID1"));
			strOrderDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ORDER_DATE_TIME1"),"DMY","en",locale));			
			strPrefDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("PREF_SURG_DATE1"),"DMY","en",locale));
			daysGap = com.ehis.util.DateUtils.daysBetween(strOrderDate, todaysDate, "DMY", locale);
			strStatus=checkForNull(rs.getString("STATUS1"));
			longDescription = checkForNull(rs.getString("longdesc")); //KDAH-CRF-0283 [IN:050553]
			//physicianId = checkForNull(rs.getString("physician_id")); //KDAH-CRF-0283 [IN:050553]
			physicianId = checkForNull(rs.getString("ordering_surgeon_name")); //KDAH-CRF-0283 [IN:050553]
			
			if(priorityValue == null || priorityValue.trim().length() == 0)
			{
				innerPstmt.setString(1, strOrderId);
				if(priorityValue != null && priorityValue.trim().length() > 0)
					innerPstmt.setString(2, priorityValue);
				innerRs = innerPstmt.executeQuery();
				priorityColValue = "";
				while(innerRs.next())
					priorityColValue = checkForNull(innerRs.getString("order_field_value"));
			}
			// start KDAH-CRF-0283 [IN:050553]

			getAgePstmt.setString(1, strPatientId);
			getAgeRs = getAgePstmt.executeQuery();
			while(getAgeRs.next())
				patientAge = checkForNull(getAgeRs.getString("age"));
			// end KDAH-CRF-0283 [IN:050553]

			if(tempStrPatientId != null && tempStrPatientId.equals(strPatientId))
				patIdCnt++;
			else
			{

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tempStrPatientId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tempStrPatientId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tempStrPatientId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patIdCnt));
            _bw.write(_wl_block39Bytes, _wl_block39);

				patIdCnt = 1;
			}
			tempStrPatientId = strPatientId;

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strSpecialityCode));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(operCode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strPrefDate));
            _bw.write(_wl_block55Bytes, _wl_block55);
            _bw.write(_wl_block1Bytes, _wl_block1);

			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y") && priorityColValue.equalsIgnoreCase("Priority-1")) //052733
				strQuery = (fetchCount%2==0) ? "class='gridDataPriority'" : "class='gridDataPriority'";
			else
				strQuery = (fetchCount%2==0) ? " class = 'gridData' " : " class = 'gridData' ";

            _bw.write(_wl_block56Bytes, _wl_block56);

			if(!called_from.equalsIgnoreCase("OT_MENU")) {   // [IN:057473]

            _bw.write(_wl_block1Bytes, _wl_block1);

			if(ammendBooking != null && ammendBooking.equals("Y"))
			{

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block58Bytes, _wl_block58);

				if(strStatus.equals(strOrderStatus)==false){
				
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(operCode));
            _bw.write(_wl_block64Bytes, _wl_block64);
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block67Bytes, _wl_block67);
            _bw.write(_wl_block68Bytes, _wl_block68);

				}else{
				patIdCnt--;	//added against 057504
				
				
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(operCode));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(operCode));
            _bw.write(_wl_block71Bytes, _wl_block71);

				}
				
				
            _bw.write(_wl_block72Bytes, _wl_block72);

					int Disp_Image_YN=0;					
					Disp_Image_YN=Integer.parseInt(rs.getString("booking_cnt"));					
					
				if(Disp_Image_YN>0){
				
            _bw.write(_wl_block73Bytes, _wl_block73);

					}else{
				
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block75Bytes, _wl_block75);

					}
				
            _bw.write(_wl_block76Bytes, _wl_block76);

			}
			
            _bw.write(_wl_block77Bytes, _wl_block77);

			}   // [IN:057473]
			
            _bw.write(_wl_block78Bytes, _wl_block78);

				//CRF-186 for consent starts
					ConsentNotRecord=false;ConsentRecord=false;ConsentNotRequired=false;
							consentresutlt=checkForNull(rs.getString("consentresult"));
							// System.err.println("consentresutlt: "+consentresutlt);
							if(consentresutlt!=null && consentresutlt!=""){
								// System.err.println("first If");
								if(consentresutlt.contains("Y") && consentresutlt.contains("PC")){
									// System.err.println("second If");
									ConsentNotRecord=true;
								}else if(consentresutlt.contains("Y") && !consentresutlt.contains("PC")){
								// System.err.println("Third If");
									ConsentRecord=true;
								}else if(consentresutlt.contains("N") && !consentresutlt.contains("Y")){
								// System.err.println("fourth If");
								ConsentNotRequired=true;
							}							
							}else if(consentresutlt.contains("N")){
							// System.err.println("fifth If");
								ConsentNotRequired=true;
							}else{
								// System.err.println("else");
								ConsentRecord=true;
							}
						//CRF-186 for consent ends
				
				
            _bw.write(_wl_block77Bytes, _wl_block77);
 if(!called_from.equalsIgnoreCase("OT_MENU")) {
            _bw.write(_wl_block79Bytes, _wl_block79);

					if(ConsentNotRequired){
					
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block81Bytes, _wl_block81);

					}else if(ConsentRecord){
					
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block82Bytes, _wl_block82);

					}else if(ConsentNotRecord){
					
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block83Bytes, _wl_block83);

					}
				
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block85Bytes, _wl_block85);
if(isInsuranceStatus && bill_flag){ //Added Against TH-KW-CRF-0126
	  
	    if(insurance_patient_yn.equals("I")){
  
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(insurance_status_desc));
            _bw.write(_wl_block88Bytes, _wl_block88);

	    }
       else{
        
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block90Bytes, _wl_block90);
 
		}	
		
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(PatientPayementStatus));
            _bw.write(_wl_block92Bytes, _wl_block92);
		
	}
	
            _bw.write(_wl_block93Bytes, _wl_block93);

			
			if(strCheckinFlag.equalsIgnoreCase("CHECK_IN") == true)
				out.println("<td "+strQuery+"  width='10%' class='"+strQuery+"'  align='left' OnClick=\"javascript:funMoveNext('"+strOrderId+"','"+strSurgeonCode+"','"+strPrefDate+"','"+fetchCount+"','"+strPatientId+"');\"><font class='gridLink' style='font-size:7pt;color:blue;cursor:pointer;font-weight:normal'>"+strPatientId+"</font></td>");
			else
			{
				if(strWaitListNo.length()==0)
				{
					if(strStatus.equals(strOrderStatus)==false)
					{
						out.println("<input type='hidden' name='validateMenuDisp' id='validateMenuDisp'"+fetchCount+" id='validateMenuDisp'"+fetchCount+" value='1' >");//186
						out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"displayToolTip1('"+strOrderId+"','"+strSurgeonCode+"','"+strPrefDate+"','"+fetchCount+"','"+strPatientId+"','1',this,'imgArrow"+fetchCount+"');\"  width='10%'  onMouseOver='hidemenu();' nowrap>"+strPatientId+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
					}
					else
					{
						out.println("<input type='hidden' name='validateMenuDisp' id='validateMenuDisp'"+fetchCount+" id='validateMenuDisp'"+fetchCount+" value='2' >");//186
						out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"displayToolTip1('"+strOrderId+"','"+strSurgeonCode+"','"+strPrefDate+"','"+fetchCount+"','"+strPatientId+"','2',this,'imgArrow"+fetchCount+"');\"  width='10%'  onMouseOver='hidemenu();' nowrap>"+strPatientId+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
					}
				}
				else
				{
					if(strStatus.equals(strOrderStatus)==false)
					{
						out.println("<input type='hidden' name='validateMenuDisp' id='validateMenuDisp'"+fetchCount+" id='validateMenuDisp'"+fetchCount+" value='0' >");//186
						out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"displayToolTip1('"+strOrderId+"','"+strSurgeonCode+"','"+strPrefDate+"','"+fetchCount+"','"+strPatientId+"','0',this,'imgArrow"+fetchCount+"');\"  width='10%'  onMouseOver='hidemenu();' nowrap>"+strPatientId+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
					}
					else
					{

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block94Bytes, _wl_block94);

					}
				}
			}

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block97Bytes, _wl_block97);

			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(patientAge));
            _bw.write(_wl_block94Bytes, _wl_block94);

			}

            _bw.write(_wl_block1Bytes, _wl_block1);

			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(priorityColValue));
            _bw.write(_wl_block94Bytes, _wl_block94);

			}

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strSurgeoryType));
            _bw.write(_wl_block94Bytes, _wl_block94);

			pstmt1.setString(1, locale);
			pstmt1.setString(2, strOrderId);
			rs1=pstmt1.executeQuery();
			strTempBookNo.setLength(0);
			strTempBookNo=new StringBuffer();
			strTempBookNo.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels"));
			strTempBookNo.append(",");
			while(rs1.next())
			{
				strTempBookNo.append(rs1.getString(1));
				strTempBookNo.append(",");
			}		
			if(rs1!=null) 
				rs1.close();

            _bw.write(_wl_block99Bytes, _wl_block99);

			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(longDescription));
            _bw.write(_wl_block101Bytes, _wl_block101);

			}
			else
			{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block102Bytes, _wl_block102);

			}

            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(strOperDesc));
            _bw.write(_wl_block34Bytes, _wl_block34);

			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block104Bytes, _wl_block104);

						if(daysGap > 0)
						{

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(daysGap));
            _bw.write(_wl_block1Bytes, _wl_block1);

						}

            _bw.write(_wl_block106Bytes, _wl_block106);

			}

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(strPrefDate));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block34Bytes, _wl_block34);

			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(physicianId));
            _bw.write(_wl_block34Bytes, _wl_block34);

			}
			else
			{
			if(strSurgeonCode.equals(""))
			{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(all_surgeons));
            _bw.write(_wl_block34Bytes, _wl_block34);

			}
			else
			{
		//testing selvin
		if(strSurgeonName.equals("")){ 

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(all_surgeons));
            _bw.write(_wl_block34Bytes, _wl_block34);

			}
		else{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block34Bytes, _wl_block34);

		}
	//testing selvin
	
            _bw.write(_wl_block1Bytes, _wl_block1);

				
			}
			}

            _bw.write(_wl_block1Bytes, _wl_block1);

			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block110Bytes, _wl_block110);

			}

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strTempBookNo));
            _bw.write(_wl_block113Bytes, _wl_block113);

			fetchCount++;
			s++;
		}
	}


            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(tempStrPatientId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tempStrPatientId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tempStrPatientId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patIdCnt));
            _bw.write(_wl_block39Bytes, _wl_block39);

		if(fetchCount==0)
			
            _bw.write(_wl_block115Bytes, _wl_block115);

			
		if ( fetchCount < 10 || (!rs.next()) ) 
		{

            _bw.write(_wl_block116Bytes, _wl_block116);
 
			} 
			else 
			{

            _bw.write(_wl_block117Bytes, _wl_block117);

			}

	}catch(Exception ee){
		ee.printStackTrace();
	}finally{
		if(rs!=null) rs.close();
		if(resultset!=null) resultset.close();
		if(pstmt1!=null) pstmt1.close();
		if(pstmt!=null)pstmt.close();
		ConnectionManager.returnConnection(conn,request);
		strTempBookNo.setLength(0);
	}

            _bw.write(_wl_block118Bytes, _wl_block118);
if(isInsuranceStatus && bill_flag){ //Added Against TH-KW-CRF-0126
	 
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

 }
 
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(strCheckinFlag));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(customerId));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bookingPriorityOrdersYN));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(todaysDate));
            _bw.write(_wl_block135Bytes, _wl_block135);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(ammendBooking));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(chkBookingExistDays));
            _bw.write(_wl_block139Bytes, _wl_block139);
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block141Bytes, _wl_block141);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FutureAppointment.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Consent.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InsuranceStatus.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PatientPayement.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SurgeryType.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Procedure(s).Label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Pending.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OrderingSurgeon.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DisclaimerForBillStatus.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
