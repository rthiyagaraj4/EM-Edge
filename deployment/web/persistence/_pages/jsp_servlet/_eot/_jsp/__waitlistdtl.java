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
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eOT.Common.OTRepository;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __waitlistdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/WaitListDtl.jsp", 1740053956000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script><!-- 57404 -->\n\t<script language=\"JavaScript\" src=\"../../eOT/js/Booking.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\t\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n <head>\n <script>\n \n var remarks_value=getLabel(\"eOT.PreOperativeDiagnosis.Label\",\"OT\");//Added by lakshmi against MO-CRF-20051\n function submitPrevNext(from, to)\n { \n\tvar frmObj=document.forms[0];//VerificationSearchForm\n\tvar locale = frmObj.locale.value;\n\tvar change_from_date = dateUtils(frmObj.from_date.value,locale); \n\tvar change_to_date = dateUtils(frmObj.to_date.value,locale); \n\tif(!callDateCheck(change_from_date,change_to_date)) return;\n\n\tif(frmObj.from_date.value!=\'\'){\n\t//Commented against MO-CRF-20086\n\t//var sql=\"SELECT (to_date(to_char(SYSDATE,\'dd/mm/yyyy\'),\'dd/mm/yyyy\')-to_date(to_char(WAITLIST_DATE,\'dd/mm/yyyy\'),\'dd/mm/yyyy\')) R_DAY1,NVL(C.WARN_LIMIT_WAITLIST_DAYS,0) WARNING_DAYS, NVL(c.WARN_UNSCHEDULED_CASES_ONLY,\'N\') STAT1,v.PATIENT_ID  PATIENT_ID1, (select  decode( \'\"+locale+\"\',\'en\',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = v.PATIENT_ID ) PATIENT_NAME1,  v.SURGERY_TYPE SURGERY_TYPE1,v.SPECIALITY_DESC SPECIALITY_DESC1, v.SURGEON_NAME SURGEON_NAME1, to_char(v.PREFERRED_DATE,\'dd/mm/yyyy\') PREFERRED_DATE1, to_char(v.WAITLIST_DATE,\'dd/mm/yyyy HH24:MI\')  WAITLIST_DATE1, v.ORDER_ID ORDER_ID1, v.SURGEON_CODE SURGEON_CODE1,v.BOOKING_NUM BOOKING_NUM1,v.WAITLIST_NUM WAITLIST_NUM1, v.SPECIALITY_CODE  SPECIALITY_CODE1,OPER_DESC  OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1, TO_CHAR(SYSDATE - V.WAITLIST_DATE) WAITLIST_DAYS,v.STATUS  FROM  OT_WAITLIST_VW v,OT_PARAM_FOR_FACILITY C WHERE v.OPERATING_FACILITY_ID = \'\"+frmObj.facility_id.value+\"\' and C.OPERATING_FACILITY_ID = \'\"+frmObj.facility_id.value+\"\' and v.language_id=\'\"+locale+\"\'\";\n\t//Added against MO-CRF-20086\n\tvar sql=\"SELECT * FROM (SELECT (to_date(to_char(SYSDATE,\'dd/mm/yyyy\'),\'dd/mm/yyyy\')-to_date(to_char(WAITLIST_DATE,\'dd/mm/yyyy\'),\'dd/mm/yyyy\')) R_DAY1,NVL(C.WARN_LIMIT_WAITLIST_DAYS,0) WARNING_DAYS, NVL(c.WARN_UNSCHEDULED_CASES_ONLY,\'N\') STAT1,v.PATIENT_ID  PATIENT_ID1, (select  decode( \'\"+locale+\"\',\'en\',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = v.PATIENT_ID ) PATIENT_NAME1,  v.SURGERY_TYPE SURGERY_TYPE1,v.SPECIALITY_DESC SPECIALITY_DESC1, v.SURGEON_NAME SURGEON_NAME1, to_char(v.PREFERRED_DATE,\'dd/mm/yyyy\') PREFERRED_DATE1, to_char(v.WAITLIST_DATE,\'dd/mm/yyyy HH24:MI\')  WAITLIST_DATE1, v.ORDER_ID ORDER_ID1, v.SURGEON_CODE SURGEON_CODE1,v.BOOKING_NUM BOOKING_NUM1,v.WAITLIST_NUM WAITLIST_NUM1, v.SPECIALITY_CODE  SPECIALITY_CODE1,OPER_DESC  OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1, TO_CHAR(SYSDATE - V.WAITLIST_DATE) WAITLIST_DAYS,v.STATUS,(SELECT ORDER_FIELD_VALUE from or_order_field_values D where D.ORDER_ID=V.ORDER_ID and D.ADDED_FACILITY_ID=V.OPERATING_FACILITY_ID and D.ORDER_FIELD_MNEMONIC = \'OT_CATEGORY_TYPE\' AND ROWNUM=1)  CATEGORY,(SELECT ORDER_FIELD_VALUE from or_order_field_values D where D.ORDER_ID=V.ORDER_ID and D.ADDED_FACILITY_ID=V.OPERATING_FACILITY_ID and D.ORDER_FIELD_MNEMONIC = \'PRIORITY\'  AND ROWNUM=1)  PRIORITY  FROM  OT_WAITLIST_VW v,OT_PARAM_FOR_FACILITY C WHERE v.OPERATING_FACILITY_ID = \'\"+frmObj.facility_id.value+\"\' and C.OPERATING_FACILITY_ID = \'\"+frmObj.facility_id.value+\"\' and v.language_id=\'\"+locale+\"\'\";\n\t\n\tvar where=\"\";\n\tvar where2=\"\";//Added against MO-CRF-20086\n   if(frmObj.speciality_code.value!=null && frmObj.speciality_code.value!=\'\')\n\twhere=escape(\" and instr(NVL(ALL_SPECIALITY_CODES,SPECIALITY_CODE),\'#\"+frmObj.speciality_code.value+\"#\')>0\");\n\n   if(frmObj.surgeon_code.value!=null && frmObj.surgeon_code.value!=\'\')\n\twhere+=escape(\" and v.SURGEON_CODE =\'\"+frmObj.surgeon_code.value+\"\'\");\n\n\tif(frmObj.order_id.value!=null && frmObj.order_id.value!=\'\')\n\t   where+=escape(\" and v.ORDER_ID =\'\"+frmObj.order_id.value+\"\'\");\n\n\tif((frmObj.from_date.value!=null && frmObj.from_date.value!=\'\')||(frmObj.to_date.value!=null && frmObj.to_date.value!=\'\'))\n     where +=\" AND PREFERRED_DATE  BETWEEN TO_DATE(NVL(\'\"+change_from_date+\"\',\'01/01/1900\')||\'00:00\', \'DD/MM/YYYY HH24:MI\') AND TO_DATE(NVL(\'\"+change_to_date+\"\',\'01/01/3000\')|| \'23:59\',\'DD/MM/YYYY HH24:MI\')\";\n\n\tif(frmObj.patient_id.value!=null && frmObj.patient_id.value!=\'\')\n\t   where+=escape(\" and v.PATIENT_ID =\'\"+frmObj.patient_id.value+\"\'\");\n\telse\n\t\tif(frmObj.patient_name.value!=null&&frmObj.patient_name.value!=\'\')\n\t\twhere+= escape(\" and UPPER(v.PATIENT_NAME) like UPPER(\'\"+frmObj.patient_name.value+\"%\')\");\n\n\tif(frmObj.status_old.value==\'S\')\n\t where+=escape(\" and v.BOOKING_NUM IS NOT NULL\");\n\telse\n\tif(frmObj.status_old.value==\'U\')\n\t where+=escape(\" and v.BOOKING_NUM IS  NULL\");\n\t\n\tsql+=where+\")\";//modified against MO-CRF-20086\n\t\n\t//Added against MO-CRF-20086 Starts Here\n\tif((frmObj.category.value!=null && frmObj.category.value!=\'\') && (frmObj.priority.value!=null && frmObj.priority.value!=\'\'))\n\t where2+=escape(\"where  ((NVL(\'\"+frmObj.category.value+\"\',CATEGORY)=CATEGORY AND \'\"+frmObj.category.value+\"\' IS NOT NULL) OR (\'\"+frmObj.category.value+\"\' IS NULL)) AND ((NVL(\'\"+frmObj.priority.value+\"\',PRIORITY)=PRIORITY AND \'\"+frmObj.priority.value+\"\' IS NOT NULL) OR (\'\"+frmObj.priority.value+\"\' IS NULL)) \");\n\t  \n\telse if(frmObj.category.value!=null && frmObj.category.value!=\'\')\n\t   where2+=escape(\"where  ((NVL(\'\"+frmObj.category.value+\"\',CATEGORY)=CATEGORY AND \'\"+frmObj.category.value+\"\' IS NOT NULL) OR (\'\"+frmObj.category.value+\"\' IS NULL))\");\n\t   \n\telse \n\tif(frmObj.priority.value!=null && frmObj.priority.value!=\'\')\n\t   where2+=escape(\"where  ((NVL(\'\"+frmObj.priority.value+\"\',PRIORITY)=PRIORITY AND \'\"+frmObj.priority.value+\"\' IS NOT NULL) OR (\'\"+frmObj.priority.value+\"\' IS NULL))\");\n    \n\tsql+=where2;\t\n\t//Added against MO-CRF-20086 Ends Here\n\tvar param=\'sql=\'+sql+\'&surgeonCode=\'+frmObj.surgeon_code.value+\"&from=\"+from+\"&to=\"+to+\"&speciality_code=\"+frmObj.speciality_code.value+\"&surgeon_code=\"+frmObj.surgeon_code.value+\"&order_id=\"+frmObj.order_id.value+\"&patient_id=\"+frmObj.patient_id.value+\"&patient_name=\"+frmObj.patient_name.value+\"&from_date=\"+frmObj.from_date.value+\"&to_date=\"+frmObj.to_date.value+\"&status=\"+frmObj.status_old.value+\"&category=\"+frmObj.category.value+\"&priority=\"+frmObj.priority.value;//Modified against MO-CRF-20086\n\tparent.frames[0].location.href = \'../../eOT/jsp/WaitListDtlFrame.jsp?\'+param;\t\n\t}else{\n\t\tvar msg = getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\tvar msgArray = msg.split(\"&\");\n\t\talert(msgArray[0]+getLabel(\"Common.fromdate.label\",\"Common\")+msgArray[1]);\n\t}\n }\n </script>\n  </head>\n\n<body >\n<form name=\'pendingOrderDtlForm\' id=\'pendingOrderDtlForm\' action=\'\' method = \'post\' >\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\t\t\t\t\t\n\n\t\t\t\t\t\t<table width=\'100%\' border=\'0\' align=\'center\' >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\'20%\' align=\'right\' class=\'NONURGENT\'>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =",";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")\' id=\'prev\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =")\' id=\'next\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a><input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\n\t\t\t\t\t\t\t\t</td>\n\t \t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<table class=\'grid\' border=\'0\' width=\'100%\' cellpadding=3  cellspacing=0>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t\t\t\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\t\t\n\t\t\t\t\t\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\t\n\t\t\t\t\t\t\t    \t<!--  Added Starts Against MO-CRF-20086-->\t\n\t\t\t\t\t\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\t\n\t\t\t\t\t\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\t\n\t\t\t\t\t\t\t\t<!--  Added Ends Against MO-CRF-20086-->\t\n\t\t\t\t\t\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t\t\t\t\t\t\t<!--Added by lakshmi against MO-CRF-20051-->\n\t\t\t\t\t\t\t\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'xx";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'xx";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'speciality_code_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'speciality_code_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'yy";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'yy";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t<td width=\'\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' style=\'cursor:pointer\' class=\'gridDataBlue\' onClick=\"displayToolTip3(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',this,\'imgArrow";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\"  width=\'10%\'  onMouseOver=\'hidemenu();\' nowrap>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'></td>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' style=\'cursor:pointer\' class=\'gridDataBlue\' onClick=\" displayToolTip2(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'reason";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'reason";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' >\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' OnMouseOver=\"reasonToolTip(\'reason\',";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =")\"  onMouseOut=\'hidemenu();\' nowrap>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'  nowrap>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t\t\t<!--Added against MO-CRF-20086 Starts Here-->\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t\t\t\t\t<!--Added against MO-CRF-20086 Ends Here-->\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' nowrap > <font color=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t\t\t    <td class=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t\t\t\t\t<!--Added by lakshmi against MO-CRF-20051-->\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' >\n\t<!--<input type=\'hidden\' name=\'MYREMARKS";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'MYREMARKS";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">-->\n\t\t\t\t\t\t\t<a  class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' href=\"javascript:showWaitlistRemarks(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</a>\n\t\t\t\t\t\t\t</td> \t\t\n<!--\t<a  class=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' href=\"javascript:showRemarks(document.forms[0].MYREMARKS";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =",\'0\',remarks_value,1500);\">\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</a></td> -->\n\t\t\t<!--<a  class=\'gridLink\' href=\"javascript:showRemarks(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\',\'0\',remarks_value);\">\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</a></td>-->\n\t\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t</script>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n \t\t\t\t</table>\n \t\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n \t\t\t\t<input type=\'hidden\' name=\'from_date\' id=\'from_date\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'surgeon_code\' id=\'surgeon_code\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'status_old\' id=\'status_old\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\"patientId\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"><!--PMG MOD CRF-0024 US-3-->\n\t\t\t\t<!--Added against MO-CRF-20086 Starts Here-->\n\t\t\t\t<input type=\'hidden\' name=\'category\' id=\'category\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t\t<!--Added against MO-CRF-20086 Ends Here-->\n\t \t</form>\n\t \t<!--div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t\t</div--> \n\t\t<!--IE-11 059507-->\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t \t<table id=\'tooltiptable\' cellpadding=\"0\" cellspacing=0 border=\'0\'   style=\'position:absolute;\' width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'menu_table\'></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t</body>\n\t<!--IE-11 059507-->\n\t\n</html> ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
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
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String cancelled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
String pending =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
String apptscheduled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApptScheduled.Label","ot_labels");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	

	String sql=request.getParameter("sql");
	String strPatientId="",strPatientName="",strSurgeoryType="",strSpecialityDesc="",strSurgeonName="",strSurgeonCode="",strOrderId="",strQuery="",strOperDesc="",strPrefDate="",strSpeciality="",strBookingNum="",strColor="",strColorStat="",strTextColor="",strMultipleOperYN="",strTempBookNo="",strWaitListNo="",strWaitlist="",strwarningdays="",waitListDays="",status="";
	String strCategory="",strPriority="";//Added against MO-CRF-20086
	String strPreOperDiag=""; //Added by lakshmi against MO-CRF-20051

	int colorDt=0;
	int colorDt1=0;
	int fetchCount=0;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	PreparedStatement pstmt1=null;
	ResultSet rs1=null;
		String from = request.getParameter( "from"  );
		String to = request.getParameter( "to")  ;
		String from_date = request.getParameter( "from_date") ;
		String to_date = request.getParameter( "to_date" );
		String surgeon_code = CommonBean.checkForNull(request.getParameter( "surgeon_code" )) ;
		String order_id = CommonBean.checkForNull(request.getParameter( "order_id" )) ;
		String speciality_code = CommonBean.checkForNull(request.getParameter( "speciality_code" )) ;
		String patient_id = CommonBean.checkForNull(request.getParameter( "patient_id" )) ;
		String patient_name =CommonBean.checkForNull( request.getParameter( "patient_name" )) ;
		String facilityid=(String)session.getValue("facility_id");
		//Added against MO-CRF-20086
		String category=CommonBean.checkForNull( request.getParameter( "category" ));
		String priority=CommonBean.checkForNull( request.getParameter( "priority" ));
		//Added against MO-CRF-20086
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

		String sql_desc="SELECT SHORT_DESC OPER_DESC FROM OT_WAITLISTING_DTL A, OT_OPER_MAST B WHERE  A.WAITLIST_NUM = ? AND A.OPER_CODE = B.OPER_CODE ";
		pstmt1=conn.prepareStatement(sql_desc);
	
		pstmt=conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if ( start != 1 )
			for( int j=1; j<start; s++,j++ )
			{
				rs.next() ;
			}
			if(rs != null)
			{
				while(s<=end && rs.next() ){

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
						if ( !((start+15) > fetchCount ))
						{
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+15)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end+15)));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

						}
			
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

						}

						strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
						strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));
						strSurgeoryType=checkForNull(rs.getString("SURGERY_TYPE1"));
						strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));
						strSurgeonName=checkForNull(rs.getString("SURGEON_NAME1"));	
						strSurgeonCode=checkForNull(rs.getString("SURGEON_CODE1"));
						strWaitListNo=checkForNull(rs.getString("WAITLIST_NUM1"));
						strMultipleOperYN=checkForNull(rs.getString("MULTIPLE_OPERS_YN1"));
						strOperDesc=checkForNull(rs.getString("OPER_DESC1"));
						strOrderId=checkForNull(rs.getString("ORDER_ID1"));
						strPrefDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("PREFERRED_DATE1"),"DMY","en",locale));
						strSpeciality=checkForNull(rs.getString("SPECIALITY_CODE1"));
						strBookingNum=checkForNull(rs.getString("BOOKING_NUM1"));
						strColorStat=checkForNull(rs.getString("STAT1"));
						strColor=checkForNull(rs.getString("R_DAY1"));
						strWaitlist=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("WAITLIST_DATE1"),"DMYHM","en",locale));
						strwarningdays=checkForNull(rs.getString("WARNING_DAYS"));
						waitListDays = checkForNull(rs.getString("R_DAY1"));
						status = checkForNull(rs.getString("STATUS"));
						strCategory=checkForNull(rs.getString("CATEGORY"));//Added against MO-CRF-20086
			            strPriority=checkForNull(rs.getString("PRIORITY"));//Added against MO-CRF-20086
			
						if(("9").equals(status))
							status=cancelled;
						else if(("P").equals(status))
							status=pending;
						else if(("A").equals(status))
							status=apptscheduled;
			
						colorDt=Integer.parseInt(strColor);
						colorDt1=Integer.parseInt(strwarningdays);
						strQuery=(fetchCount%2==0)?"gridData":"gridData";
						//strPreOperDiag = checkForNull(rs.getString("PRE_OPER_DIAG"));//Added by lakshmi against MO-CRF-20051
						//System.out.println("strPreOperDiag:::lakshmi"+strPreOperDiag);//lakshmi
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strSpeciality));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block33Bytes, _wl_block33);

						strTextColor="BLACK";
						if(colorDt>=colorDt1)
						{  
							if(strColorStat.equals("Y") && strBookingNum.length()==0)
							{
								strTextColor="RED";
							}else if(strColorStat.equals("N")){
								strTextColor="RED";
							}
						}
		
						if(strBookingNum.length()>0){
			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPrefDate));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strWaitListNo));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block40Bytes, _wl_block40);

						}
						else
						{
			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPrefDate));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strWaitListNo));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block40Bytes, _wl_block40);

						}

			
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strSurgeoryType));
            _bw.write(_wl_block45Bytes, _wl_block45);

						if(strMultipleOperYN.equals("Y"))
						{
							String operationsProcedures_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")+",";
							pstmt1.setString(1,strWaitListNo);
							rs1=pstmt1.executeQuery();
							strTempBookNo=operationsProcedures_value;
							while(rs1.next()){
								strTempBookNo=strTempBookNo+rs1.getString(1)+",";
							}		
							rs1.close();
			
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strTempBookNo));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strOperDesc));
            _bw.write(_wl_block45Bytes, _wl_block45);

						}
						else
						{
			
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strOperDesc));
            _bw.write(_wl_block45Bytes, _wl_block45);
 
						} 
			
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strPrefDate));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strCategory));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strPriority));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strTextColor));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strWaitlist));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(waitListDays));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(status));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strPreOperDiag));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(strPreOperDiag));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

					fetchCount++;
					s++;
				}
			}
	

			if(fetchCount==0){
				out.println("<script>callNoRecord();</script>");
			}
			if ( fetchCount < 15 || (!rs.next()) ) {
			
            _bw.write(_wl_block72Bytes, _wl_block72);
 
			} 
			else 
			{
			
            _bw.write(_wl_block73Bytes, _wl_block73);

			}
			
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(status));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(category));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block87Bytes, _wl_block87);

	}catch(Exception ee){
		ee.printStackTrace();
		//System.err.println("Exception "+ee);
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(conn,request);
	}
	
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SurgeryType.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CategoryType.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.WaitlistDate.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.WaitlistDays.Label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
