package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __addoperatorstationrstrndetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addOperatorStationRstrnDetails.jsp", 1723118684533L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n\t\t\n<script language=\"JavaScript\">\n \n\n\n\n\n\n//THE FOLLOWING CHECKING IS NOT NECESSARY\nfunction chk_book(obj)\n{\n\tif(obj.checked==true)\n\t{\n\t}else{\n\t}\n}\n\nfunction chk_transfer(obj){\nif(obj.checked==true){\n}else{\n}\n}\nfunction chk_register(obj){\nif(obj.checked==true){\n}else{\n}\n}\n\n\nfunction disencfrm()\n{\n\tif(document.forms[0].create_booking_with_conf_yn_hdd.value == \'Y\')\n\t\tdocument.forms[0].CREATE_BOOKING_WITH_CONF_YN.disabled = false;\n\telse\n\t\tdocument.forms[0].CREATE_BOOKING_WITH_CONF_YN.disabled = true;\n}\n\nfunction disencr()\n{\n\tif(document.forms[0].create_booking_yn_hdd.value == \'Y\')\n\t\tdocument.getElementById(\'create_booking_yn\').disabled = false;\n\telse\n\t\tdocument.getElementById(\'create_booking_yn\').disabled = true;\n}\n\n\n\nfunction codeArrestforScroll(e)\n{\n\t//alert(\'Welcome to eHIS\');\n\talert(getMessage(\"WELCOME\",\"Common\"));\n\treturn false;\n}\n\nfunction ckhValue(Obj)\n{\n\tif(Obj.checked)\n\t\tObj.value=\'Y\'\n\telse\n\t\tObj.value=\'N\'\n}\n\nfunction chngadmtassign(obj)\n{   /*Below line modified for this CRF Bru-HIMS-CRF-261*/\n\tif(obj.name == \'admit_pat_yn\')\n\t{\n\t\tif(obj.checked == true)\n\t\t{\n\t\t\tif(document.forms[0].admit_patient_with_bed_yn_hdd)\n\t\t\t{\n\t\t\tif(document.forms[0].admit_patient_with_bed_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = true;\n\t\t\t}\n\t\t\tif(document.forms[0].quick_admission_yn)\n\t\t\tdocument.forms[0].quick_admission_yn.disabled=false;  //this line Added for this CRF Bru-HIMS-CRF-261\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(document.forms[0].ADMIT_PATIENT_WITH_BED_YN)\n\t\t\t{\n\t\t\t\tdocument.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked = false;\n\t\t\t\tdocument.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = true;\n\t\t\t}\n\t\t\t //this line Added for this CRF Bru-HIMS-CRF-261\n\t\t\tif(document.forms[0].quick_admission_yn){\n\t\t\tdocument.forms[0].quick_admission_yn.checked=false;\n\t\t\tdocument.forms[0].quick_admission_yn.disabled=true;\n\t\t\t}\n\t\t\t//End Bru-HIMS-CRF-261\n\t\t}\n\t}\n\telse if(obj.name == \'assign_bed_yn\')\n\t{\n\t\tif(obj.checked == true)\n\t\t{\n\t\t\tif(document.forms[0].chg_nurs_unit_in_assign_bed_yn_hdd)\n\t\t\t{\n\t\t\tif(document.forms[0].chg_nurs_unit_in_assign_bed_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled = true;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN)\n\t\t\t{\n\t\t\tdocument.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.checked = false;\n\t\t\tdocument.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled = true;\n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(document.forms[0].admit_pat_yn)\n\t\t{\n\t\tif(document.forms[0].admit_pat_yn.checked==true)\n\t\t{\n\t\t\tif(document.forms[0].admit_patient_with_bed_yn_hdd)\n\t\t\t{\t\n\t\t\tif(document.forms[0].admit_patient_with_bed_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = true;\n\t\t\t}\n\n\t\t\tif(document.forms[0].register_pat_in_admn_yn_hdd)\n\t\t\t{\t\t\t\n\t\t\tif(document.forms[0].register_pat_in_admn_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.getElementById(\"register_pat_in_admn_yn\").disabled = false; \n\t\t\telse\n\t\t\t\tdocument.getElementById(\"register_pat_in_admn_yn\").disabled = true; \n\t\t\t}\n\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(document.forms[0].ADMIT_PATIENT_WITH_BED_YN)\n\t\t\t{\n\t\t\t\tif(document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked==true)\n\t\t\t{\n\t\t\t\tdocument.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked=false;\n\t\t\t}\n\t\t\t\n\t\t\tdocument.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled = true;\n\t\t\t}\n\t\t\tif(document.getElementById(\"register_pat_in_admn_yn\"))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"register_pat_in_admn_yn\").disabled = true;\n\t\t\t}\n\t\t}\n\n\t}\n}\n\nfunction chkUnchkValue(Obj)\n{\n\tif(Obj.name == \'register_visit_yn\')\n\t{\n\t\tif(Obj.checked == true)\n\t\t{\n\t\t\tif(document.forms[0].register_visit_walkin_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].register_visit_walkin_yn.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].register_visit_walkin_yn.disabled = true;\n\n\t\t\tif(document.forms[0].register_visit_referral_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].register_visit_referral_yn.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].register_visit_referral_yn.disabled = true;\n\n\t\t\tif(document.forms[0].register_pat_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].register_pat_yn.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].register_pat_yn.disabled = true;\n\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].register_visit_walkin_yn.checked   = false;\n\t\t\tdocument.forms[0].register_visit_referral_yn.checked = false;\n\t\t\tdocument.forms[0].register_pat_yn.checked\t\t\t = false;\n\t\t\tdocument.forms[0].register_visit_walkin_yn.disabled   = true;\n\t\t\tdocument.forms[0].register_visit_referral_yn.disabled = true;\n\t\t\tdocument.forms[0].register_pat_yn.disabled\t\t\t  = true;\n\t\t}\n\t}\n\n\tif(Obj.name == \'register_visit_walkin_yn\')\n\t{\n\t\tif(Obj.checked == true)\n\t\t{\n\t\t\tObj.value=\'Y\';\n\t\t\tif(document.forms[0].OVERRIDE_WALKIN_YN_HDD.value == \'Y\')\n\t\t\t\tdocument.forms[0].OVERRIDE_WALKIN_YN.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].OVERRIDE_WALKIN_YN.disabled = true;\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tObj.value=\'N\';\n\t\t\tdocument.forms[0].OVERRIDE_WALKIN_YN.checked   = false;\t\t\t\n\t\t\tdocument.forms[0].OVERRIDE_WALKIN_YN.disabled  = true;\t\t\t\n\t\t}\n\t}\n}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t\n<script>\nfunction chk_others(obj)\n{\n\tif(obj.name==\'book_appt_yn\')\n\t{\n\t\tif(obj.checked==true)\n\t\t{\n\t\t\tif(document.forms[0].book_appt_wo_pid_yn_hdd)\n\t\t\t{\n\t\t\t\tif(document.forms[0].book_appt_wo_pid_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].book_appt_wo_pid_yn.disabled = false;\n\t\t\telse\n\t\t\tif(document.forms[0].book_appt_wo_pid_yn)\t\n\t\t\tdocument.forms[0].book_appt_wo_pid_yn.disabled = true;\n\t\t\t}\n\t\n\t\t\tif(document.forms[0].obook_appt_yn_hdd)\n\t\t\t{\n\t\t\t\tif(document.forms[0].obook_appt_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].obook_appt_yn.disabled = false;\n\t\t\telse\n\t\t\tif(document.forms[0].obook_appt_yn)\t\n\t\t\tdocument.forms[0].obook_appt_yn.disabled = true;\n\t\t\t}\n\n\t\t\tif(document.forms[0].book_appt_across_catg_yn_hdd)\n\t\t\t{\n\t\t\t\tif(document.forms[0].book_appt_across_catg_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].book_appt_across_catg_yn.disabled = false;\n\t\t\telse\n\t\t\tif(document.forms[0].book_appt_across_catg_yn)\t\n\t\t\tdocument.forms[0].book_appt_across_catg_yn.disabled = true;\n\t\t\t}\n\n\t\t\tif(document.forms[0].forced_book_appt_yn_hdd)\n\t\t\t{\n\t\t\t\tif(document.forms[0].forced_book_appt_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].FORCED_BOOK_APPT_YN.disabled = false;\n\t\t\telse\n\t\t\t\tdocument.forms[0].FORCED_BOOK_APPT_YN.disabled = true;\n\t\t\t}\n\n\t\t\tif(document.forms[0].global_book_appt_yn_hdd)\n\t\t\t{\n\t\t\t\tif(document.forms[0].global_book_appt_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].GLOBAL_BOOK_APPT_YN.disabled = false;\n\t\t\telse\n\t\t\tif(document.forms[0].GLOBAL_BOOK_APPT_YN)\t\n\t\t\tdocument.forms[0].GLOBAL_BOOK_APPT_YN.disabled = true;\n\t\t\t}\n\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(document.forms[0].book_appt_wo_pid_yn)\n\t\t\t\tdocument.forms[0].book_appt_wo_pid_yn.checked=false;\n\t\t\tif(document.forms[0].book_appt_wo_pid_yn)\n\t\t\tdocument.forms[0].book_appt_wo_pid_yn.disabled=true;\n\t\t\tif(document.forms[0].FORCED_BOOK_APPT_YN)\n\t\t\tdocument.forms[0].FORCED_BOOK_APPT_YN.checked=false;\n\t\t\tif(document.forms[0].FORCED_BOOK_APPT_YN)\n\t\t\tdocument.forms[0].FORCED_BOOK_APPT_YN.disabled=true;\n\t\t\tif(document.forms[0].GLOBAL_BOOK_APPT_YN)\n\t\t\tdocument.forms[0].GLOBAL_BOOK_APPT_YN.checked=false;\n\t\t\tif(document.forms[0].GLOBAL_BOOK_APPT_YN)\n\t\t\tdocument.forms[0].GLOBAL_BOOK_APPT_YN.disabled=true;\n\t\t\tif(document.forms[0].obook_appt_yn)\n\t\t\tdocument.forms[0].obook_appt_yn.checked=false;\n\t\t\tif(document.forms[0].obook_appt_yn)\n\t\t\tdocument.forms[0].obook_appt_yn.disabled=true;\n\t\t\tif(document.forms[0].book_appt_across_catg_yn)\n\t\t\tdocument.forms[0].book_appt_across_catg_yn.checked=false;\n\t\t\tif(document.forms[0].book_appt_across_catg_yn)\n\t\t\tdocument.forms[0].book_appt_across_catg_yn.disabled=true; \n\n\t\t}\n\t}\n\telse if(obj.name==\'tfr_appt_yn\')\n\t{\n\t\tif(obj.checked==true)\n\t\t{\n\t\t\tif(document.forms[0].tfr_appt_across_catg_yn_hdd)\n\t\t\t{\n\t\t\tif(document.forms[0].tfr_appt_across_catg_yn_hdd.value == \'Y\')\n\t\t\t\tdocument.forms[0].tfr_appt_across_catg_yn.disabled = false;\n\t\t\t}\n\t\t\telse\n\t\t\tif(document.forms[0].tfr_appt_across_catg_yn)\n\t\t\tdocument.forms[0].tfr_appt_across_catg_yn.disabled = true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(document.forms[0].tfr_appt_across_catg_yn)\n\t\t\t{\n\t\t\tdocument.forms[0].tfr_appt_across_catg_yn.checked=false;\n\t\t\tdocument.forms[0].tfr_appt_across_catg_yn.disabled=true;\n\t\t\t}\n\t\t}\n\t} \n\telse if(obj.name==\'register_visit_yn\')\n\t{\n\t\tif(obj.checked==true)\n\t\t{\n\t\t\tif(document.forms[0].regvis.value==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].register_pat_yn.disabled=false;\n\t\t\t\tdocument.forms[0].register_visit_walkin_yn.disabled=false;\n\t\t\t\tdocument.forms[0].register_visit_referral_yn.disabled=false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].register_pat_yn.checked=false;\n\t\t\tdocument.forms[0].register_pat_yn.disabled=true;\n\t\t\tdocument.forms[0].register_visit_walkin_yn.checked=false;\n\t\t\tdocument.forms[0].register_visit_walkin_yn.disabled=true;\n\t\t\tdocument.forms[0].register_visit_referral_yn.checked=false;\n\t\t\tdocument.forms[0].register_visit_referral_yn.disabled=true;\n\t\t}\n\t}\n}\n</script>\n\n\t<body  OnMouseDown=\"CodeArrest()\" onSelect=\"codeArrestforScroll(this.event)\" onKeyDown = \'lockKey()\' onload=\"chngadmtassign(\'\');\" >\n\t\t<form name=\'opstn_detail_form\' id=\'opstn_detail_form\' action=\'../../servlet/eAM.OperatorStationRstrnServlet\' method=\'post\' target=\'messageFrame\' >\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<a name=\'appointment\' id=\'appointment\'>\n\n\t\t<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\t\t\n\t\t\n\t\t<tr>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\n</tr>\n\n\n<TR>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\n\t<TD class =\'QRYEVEN\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </TD>\t\t\n\t\t\t\n\t<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"book_appt_yn\" id=\"book_appt_yn\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" onclick=\'chk_others(this);\' ></TD>\n\n</tr>\n\n<tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\n\t<TD class=\'QRYODD\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </TD>\t\t\n\t\t\n\t<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"book_appt_wo_pid_yn\" id=\"book_appt_wo_pid_yn\"  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="  onclick=\'chk_book(this)\'; ></TD>\n\n</tr>\n\n<tr>\n\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\n\t<TD class =\'QRYEVEN\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </TD>\t\t\n\t\t\t\n\t<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"obook_appt_yn\" id=\"obook_appt_yn\"  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" onclick=\'chk_book(this)\';></TD>\n</tr>\n\n\n\n<tr>\n\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\n\t<TD class=\'QRYODD\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TD>\t\t\n\t\t\t\n\t<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"FORCED_BOOK_APPT_YN\" id=\"FORCED_BOOK_APPT_YN\"  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" ></TD>\n\n</tr>\n\n<tr>\n\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n\t\t\t\n\t<TD class =\'QRYEVEN\' >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</TD>\t\t\n\t\n\t<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"GLOBAL_BOOK_APPT_YN\" id=\"GLOBAL_BOOK_APPT_YN\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t\t\t\n\t<TD class =\'QRYODD\' >Override Allocation Rule For book appointment</TD>\t\t\n\t\n\t<TD class =\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"book_appt_across_catg_yn\" id=\"book_appt_across_catg_yn\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\n\t<TD class=\'QRYEVEN\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</TD>\t\t\n\t\t\t\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"tfr_appt_yn\" id=\"tfr_appt_yn\"  ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" onclick=\'chk_others(this)\';></TD>\n\n</tr>\n\n\n<tr>\n\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\n\t<TD class =\'QRYODD\' >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" </TD>\t\t\n\t\t\t\n\t<TD class =\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"canc_appt_yn\" id=\"canc_appt_yn\"  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="></TD>\n\n</tr>\n\n<tr>\n\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\n\t<TD class=\'QRYEVEN\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</TD>\t\t\n\t\t\t\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"create_wait_list_yn\" id=\"create_wait_list_yn\"  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\n\t<TD class =\'QRYODD\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</TD>\n\t\t\n\t<TD class =\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"modify_wait_list_yn\" id=\"modify_wait_list_yn\"  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</TD>\n\t\t\t\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"cancel_wait_list_yn\" id=\"cancel_wait_list_yn\"  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="></TD>\n\n</tr>\n\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n<a name= \'visit\' id= \'visit\'>\n\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<tr>\n\n<td class=\'columnheader\' colspan=\'2\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\n</tr>\n\n<tr>\n\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\n\t\t\t\n\t<TD class =\'QRYEVEN\' colspan=\'2\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" </TD>\t\t\n\t\t\t\n\t<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"register_visit_yn\" id=\"register_visit_yn\"  onClick=\'chkUnchkValue(this);\' ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t<TD class=\'QRYODD\' width =\'5%\'>&nbsp;</TD>\n\t\t\t\n\t<TD class=\'QRYODD\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</TD>\t\t\n\t\t\t\n\t<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" onclick=\'chkUnchkValue(this);\' name=\"register_visit_walkin_yn\" id=\"register_visit_walkin_yn\"  ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" ></TD>\n\n\n</tr>\n\n<tr>\n\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\n\t<TD class=\'QRYEVEN\' width =\'5%\'>&nbsp;</TD>\n\t\t\t\n\t<TD class=\'QRYEVEN\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</TD>\t\t\n\t\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"OVERRIDE_WALKIN_YN\" id=\"OVERRIDE_WALKIN_YN\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n\t<TD class=\'QRYODD\' width =\'5%\'>&nbsp;</TD>\n\t\t\t\n\t<TD class =\'QRYODD\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" </TD>\t\t\n\t\t\t\n\t<TD class =\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" onclick=\'ckhValue(this)\' name=\"register_visit_referral_yn\" id=\"register_visit_referral_yn\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\t\t\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\n\t<TD class=\'QRYEVEN\' width =\'5%\'>&nbsp;</TD>\n\t\t\n\t<TD class=\'QRYEVEN\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" </TD>\t\t\n\t\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"register_pat_yn\" id=\"register_pat_yn\"  ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" onclick=\'chk_register(this)\';></TD>\n\n</tr>\n\n<tr>\n\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\n\t<TD class =\'QRYODD\' colspan=\'2\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" </TD>\t\n\t\n\t<TD class =\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"manage_queue_yn\" id=\"manage_queue_yn\"  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\n\t<TD class=\'QRYEVEN\' colspan=\'2\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" </TD>\t\t\n\t\t\t\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"cancel_visit_yn\" id=\"cancel_visit_yn\"  ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\n\t<TD class =\'QRYODD\' colspan=\'2\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" </TD>\t\t\n\t\t\t\n\t<TD class =\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"revise_visit_yn\" id=\"revise_visit_yn\"  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\n\t<TD class=\'QRYEVEN\' colspan=\'2\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" </TD>\t\t\n\t\t\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"checkout_pat_yn\" id=\"checkout_pat_yn\"  ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="></TD>\n\n\n</tr>\n<tr>\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\n\t<TD class =\'QRYODD\' colspan=\'2\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</TD>\n\t\t\t\n\t<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"cancel_checkout_yn\" id=\"cancel_checkout_yn\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\n\t<TD class =\'QRYEVEN\' colspan=\'2\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" </TD>\t\t\n\t\t\t\n\t<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"RESERVE_BED_BAY_YN\" id=\"RESERVE_BED_BAY_YN\" ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\n\t<TD class=\'QRYODD\' colspan=\'2\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</TD>\t\t\n\t\n\t<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"RELEASE_BED_BAY_YN\" id=\"RELEASE_BED_BAY_YN\" ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" ></TD>\n\n</tr>\t\t\n\t\t</TABLE>\n\t\t<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\t\t<br><br><br><br><br><br><br><br><br>\n\t\t<br><br><br>\n\n\t\t<a name= \'others\' id= \'others\'>\n\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<tr>\n<td class=\'columnheader\' colspan=\'2\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n</tr>\n\n<tr>\n   ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n    \t\n\t<TD class =\'QRYEVEN\' colspan=\'2\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" </TD>\t\n\t<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"diag_proc_recode_for_op_yn\" id=\"diag_proc_recode_for_op_yn\" ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" ></TD>\n\n</tr>\n<!-- <tr>\n \n\n ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\n ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n<TD class = \'QRYEVEN\' colspan=\'2\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</TD>\t\n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"MAINTAIN_DEATH_REGISTER_YN\" id=\"MAINTAIN_DEATH_REGISTER_YN\"  ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="></TD>\n\n</tr> -->\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t\t\n\t\n\n<a name=\'booking\' id=\'booking\' >\n\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<tr>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\n</tr>\n\n<tr>\n\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="               \n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\n<TD class =\'QRYEVEN\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</TD>\t\t\n\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"create_booking_yn\" id=\"create_booking_yn\"  ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" onclick=\"disencfrm()\"></TD>\n\n</tr>\n\n<tr>\n\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n<TD class=\'QRYODD\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</TD>\n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"revise_booking_yn\" id=\"revise_booking_yn\"  ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="></TD>\n\n</tr>\n\n<tr>\n\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</TD>\n\t\t\t\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"canc_booking_yn\" id=\"canc_booking_yn\"  ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" ></TD>\n\n</tr>\n\n<tr>\n\n<TD class=\'QRYODD\'>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</TD>\t\t\n\t\t\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"CONFIRM_BOOKING_YN\" id=\"CONFIRM_BOOKING_YN\"   ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</TD>\t\n\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"CREATE_BOOKING_WITH_CONF_YN\" id=\"CREATE_BOOKING_WITH_CONF_YN\"  ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" onclick = \"disencr();\"></TD>\n\n</tr>\n\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n<a name= \'admission\' id= \'admission\'>\n\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<tr>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\n</tr>\n\n<tr>\n\n<TD class =\'QRYEVEN\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</TD>\t\t\n\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"admit_pat_yn\" id=\"admit_pat_yn\"  ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="  onclick=\'chngadmtassign(this);\'></TD>\n\n</tr>\n\n<!--Below line Added for this CRF  Bru-HIMS-CRF-261-->\n<tr>\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</TD>\t\t\n  ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" \n\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="            \n<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"quick_admission_yn\" id=\"quick_admission_yn\"  ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="  ></TD>\n</tr>\n<!--End this CRF Bru-HIMS-CRF-261 -->\n\n<tr>\n\n<TD class=\'QRYODD\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</TD>\t\n\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\"  name=\"ADMIT_PATIENT_WITH_BED_YN\" id=\"ADMIT_PATIENT_WITH_BED_YN\"  ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" ></TD>\n\n</tr>\n\n<tr>\n\n<TD class =\'QRYEVEN\'>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"register_pat_in_admn_yn\" id=\"register_pat_in_admn_yn\"  ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="></TD>\n\n</tr>\n\n<tr>\n\n<TD class=\'QRYODD\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"assign_bed_yn\" id=\"assign_bed_yn\"  ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" onclick=\'chngadmtassign(this);\'></TD>\n\n</tr>\n\n<tr>\n\n<td class =\'QRYEVEN\'>\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</TD>\n\t\t\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\t\n\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"CHG_NURS_UNIT_IN_ASSIGN_BED_YN\" id=\"CHG_NURS_UNIT_IN_ASSIGN_BED_YN\"  ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"assign_treat_pract_yn\" id=\"assign_treat_pract_yn\"  ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" ></TD>\n\n</tr>\n\n\n<tr>\n\n<TD class=\'QRYEVEN\'>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\n<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"revise_admission_yn\" id=\"revise_admission_yn\"  ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" ></TD>\n\n</tr>\n\n\n<tr>\n\n<TD class =\'QRYODD\'>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="               \n<TD class =\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"canc_admission_yn\" id=\"canc_admission_yn\"  ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="></TD>\n\n</tr>\n\n<tr>\n\n<TD class=\'QRYEVEN\'>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="                \n<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"BACKDATED_ADMISSION_YN\" id=\"BACKDATED_ADMISSION_YN\"  ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="></TD>\n\n</tr>\n\n<tr>\n\n<TD class =\'QRYODD\'>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</TD>\t\n\t\t\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" \n\t\t\n<TD class =\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"LINK_BABY_TO_MOTHER_YN\" id=\"LINK_BABY_TO_MOTHER_YN\" ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" ></TD>\n\n</tr>\n\n<tr>\n\n<TD class=\'QRYEVEN\'>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="      \n<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"REG_NEWBORN_FOR_IP_YN\" id=\"REG_NEWBORN_FOR_IP_YN\" ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =" ></TD>\n\n</tr>\n\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n<a name= \'transfer\' id= \'transfer\'>\n\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<tr>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"emergency_tfr_yn\" id=\"emergency_tfr_yn\" ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</TD>\t\n\t\t\t\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"routine_tfr_yn\" id=\"routine_tfr_yn\"  ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =" ></TD>\n\n</tr>\n\n<tr>\n\n<TD class =\'QRYEVEN\'> ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="               \n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"canc_req_yn\" id=\"canc_req_yn\"  ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" ></TD>\n\n</tr>\n\n<tr>\n\n<TD class=\'QRYODD\'> ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</td>\n\t\t\t\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="   \n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"cfrm_req_yn\" id=\"cfrm_req_yn\"   ";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\t\n\t\t\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"TRANSFER_OUT_PATIENT_YN\" id=\"TRANSFER_OUT_PATIENT_YN\" ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</TD>\t\t\n\t\t\t\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="                \n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"can_tfr_out_yn\" id=\"can_tfr_out_yn\"  ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =" </TD>\t\t\n\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="               \n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"TRANSFER_IN_PATIENT_YN\" id=\"TRANSFER_IN_PATIENT_YN\"  ";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"SWAP_BED_YN\" id=\"SWAP_BED_YN\"   ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" ></TD>\n\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\n<TD class=\'QRYEVEN\'>";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</TD>\n\t\t\t\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"emergency_transfer_yn\" id=\"emergency_transfer_yn\"  ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="></TD>\n\t</tr>\n\n<tr>\n\n<TD class =\'QRYODD\'>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="                \n<TD class =\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"pract_tfr_yn\" id=\"pract_tfr_yn\"  ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =" ></TD>\n\n</tr>\n\n<!--\nCancel ReserveBed function append start\n-->\n<tr>\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</TD>\n\t\t\t\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"CANCEL_RESERVE_BED_YN\" id=\"CANCEL_RESERVE_BED_YN\"  ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="></TD>\n\t</tr>\n<!--\nCancel ReserveBed function append End\n-->\n\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n\n<a name= \'discharge\' id= \'discharge\'>\n\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n\n<tr>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\t\t\n\t\t\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="               \n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"dchrg_adv_yn\" id=\"dchrg_adv_yn\"  ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="        \n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"discharge_pat_yn\" id=\"discharge_pat_yn\"  ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"BED_CLASS_CHANGE_YN\" id=\"BED_CLASS_CHANGE_YN\"  ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"DISCHARGE_CHECKLIST_YN\" id=\"DISCHARGE_CHECKLIST_YN\" ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\n<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"cancel_discharge_yn\" id=\"cancel_discharge_yn\" ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =" ></TD>\n\n</tr>\n\n\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n\n<a name= \'others\' id= \'others\'>\n\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<tr>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\n\n</tr>\n\n\n<tr>\n\n<TD class =\'QRYEVEN\'>";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</td>\t\t\n\t\t\t\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="               \n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"block_bed_yn\" id=\"block_bed_yn\"  ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</TD>\n\t\t\t\t\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"release_bed_yn\" id=\"release_bed_yn\"  ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"revise_leave_yn\" id=\"revise_leave_yn\"  ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</td>\t\t\n\n";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"check_lodger_yn\" id=\"check_lodger_yn\"   ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =" ></TD>\n\n</tr>\n\n<tr>\n\n <TD class =\'QRYEVEN\'>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\n<TD class =\'QRYEVEN\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"REG_IP_REFERRAL_YN\" id=\"REG_IP_REFERRAL_YN\" ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\"  value=\"Y\" name=\"CONFIRM_BEDSIDE_REFERRAL_YN\" id=\"CONFIRM_BEDSIDE_REFERRAL_YN\" ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =" ></TD>\n\n</tr>\n<!-- <tr>\n\n\t";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</TD>\n\t\t\t\n\t<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"CANCEL_CHECKOUT_YN\" id=\"CANCEL_CHECKOUT_YN\"  ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="></TD>\n\n</tr> -->\n\n<tr>\n";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n   \n\n\n\t<TD class=\'QRYEVEN\'>";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</TD>\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"diag_proc_recode_for_ip_yn\" id=\"diag_proc_recode_for_ip_yn\"  ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="></TD>\n\n</tr>\n\n<tr>\n \n\n ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\n<TD class = \'QRYEVEN\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="></TD>\n\n</tr>\n\n\n</table>\n\n";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\t\t\n\n\n\n<input type=\"hidden\" name=\"tfr_appt_across_catg_yn_hdd\" id=\"tfr_appt_across_catg_yn_hdd\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n<input type=\"hidden\" name=\"create_booking_with_conf_yn_hdd\" id=\"create_booking_with_conf_yn_hdd\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n<input type=\"hidden\" name=\"create_booking_yn_hdd\" id=\"create_booking_yn_hdd\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n<input type=\"hidden\" name=\"book_appt_wo_pid_yn_hdd\" id=\"book_appt_wo_pid_yn_hdd\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n<input type=\"hidden\" name=\"book_appt_across_catg_yn_hdd\" id=\"book_appt_across_catg_yn_hdd\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n<input type=\"hidden\" name=\"forced_book_appt_yn_hdd\" id=\"forced_book_appt_yn_hdd\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n<input type=\"hidden\" name=\"global_book_appt_yn_hdd\" id=\"global_book_appt_yn_hdd\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n<input type=\"hidden\" name=\"obook_appt_yn_hdd\" id=\"obook_appt_yn_hdd\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n<input type=\"hidden\" name=\"tfr_appt_yn_hdd\" id=\"tfr_appt_yn_hdd\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\n<input type=\"hidden\" name=\"register_visit_yn_hdd\" id=\"register_visit_yn_hdd\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n<input type=\"hidden\" name=\"register_pat_in_admn_yn_hdd\" id=\"register_pat_in_admn_yn_hdd\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n<input type=\"hidden\" name=\"register_visit_walkin_yn_hdd\" id=\"register_visit_walkin_yn_hdd\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n<input type=\"hidden\" name=\"register_visit_referral_yn_hdd\" id=\"register_visit_referral_yn_hdd\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n<input type=\"hidden\" name=\"register_pat_yn_hdd\" id=\"register_pat_yn_hdd\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n<input type=\"hidden\" name=\"admit_patient_with_bed_yn_hdd\" id=\"admit_patient_with_bed_yn_hdd\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n<input type=\"hidden\" name=\"chg_nurs_unit_in_assign_bed_yn_hdd\" id=\"chg_nurs_unit_in_assign_bed_yn_hdd\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n\n<input type=\"hidden\" name=\"LINK_BABY_TO_MOTHER_YN_HDD\" id=\"LINK_BABY_TO_MOTHER_YN_HDD\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n<input type=\"hidden\" name=\"REG_NEWBORN_FOR_IP_YN_HDD\" id=\"REG_NEWBORN_FOR_IP_YN_HDD\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n<input type=\"hidden\" name=\"DISCHARGE_CHECKLIST_YN_HDD\" id=\"DISCHARGE_CHECKLIST_YN_HDD\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n<input type=\"hidden\" name=\"CANCEL_DISCHARGE_YN_HDD\" id=\"CANCEL_DISCHARGE_YN_HDD\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n\n<input type=\"hidden\" name=\"RESERVE_BED_BAY_YN_HDD\" id=\"RESERVE_BED_BAY_YN_HDD\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n<input type=\"hidden\" name=\"RELEASE_BED_BAY_YN_HDD\" id=\"RELEASE_BED_BAY_YN_HDD\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\n<input type=\"hidden\" name=\"REG_IP_REFERRAL_YN_HDD\" id=\"REG_IP_REFERRAL_YN_HDD\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n<input type=\"hidden\" name=\"CONFIRM_BEDSIDE_REFERRAL_YN_HDD\" id=\"CONFIRM_BEDSIDE_REFERRAL_YN_HDD\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n<input type=\"hidden\" name=\"OVERRIDE_WALKIN_YN_HDD\" id=\"OVERRIDE_WALKIN_YN_HDD\" value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n<input type=\"hidden\" name=\"oprstn\" id=\"oprstn\">\n<input type=\"hidden\" name=\"locid\" id=\"locid\">\n<input type=\"hidden\" name=\"loctype\" id=\"loctype\">\n<input type=\"hidden\" name=\"user\" id=\"user\" value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'>\n<input type=\"hidden\" name=\"ws_no\" id=\"ws_no\">\n<input type=\"hidden\" name=\"operation_type\" id=\"operation_type\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n<input type=\"hidden\" name=\"bkwipd\" id=\"bkwipd\" value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'>\n<input type=\"hidden\" name=\"bkwipd\" id=\"bkwipd\" value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'>\n<input type=\"hidden\" name=\"a1\" id=\"a1\" value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n<input type=\"hidden\" name=\"a2\" id=\"a2\" value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n<input type=\"hidden\" name=\"obappt\" id=\"obappt\" value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n<input type=\"hidden\" name=\"bkapptac\" id=\"bkapptac\"  value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\' >\n<input type=\"hidden\" name=\"tfrappt\" id=\"tfrappt\" value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'>\n<input type=\"hidden\" name=\"regvis\" id=\"regvis\" value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'>\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

Connection con = null; 
ResultSet rset = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;
Statement stmt = null;
ResultSet rset1 = null;
Statement stmt1 = null;
String recordexists = "N";
String location_type = "";
String valueexits = "N";
String dis = "disabled";
String chk = "";
String bkwipd="";
String obappt="";     
String bkapptac="";
String tfrappt="";  
String regvis="";
String a1="";
String a2="";
String reg_dis = "";
String chkoutpatchk = "";
String cancelvisitchk = "";
String appluserid="";
ResultSet rschk = null;
Statement stchk = null;
String quick_admission_yn="";

	String mode = checkForNull(request.getParameter("mode"));
	if(mode.equals("update"))
	{
		location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type"); 
	}
	else
	{
		location_type = request.getParameter("locationtype")==null?"":request.getParameter("locationtype"); 
	}

	String facilityID = request.getParameter("facility_id");
		if(facilityID == null) facilityID="";
	String operationtype = request.getParameter("operationtype");
		if(operationtype == null ) operationtype ="insert";


try
{
	con = ConnectionManager.getConnection(request);
	String operstntype = request.getParameter("oper_stn_type")==null?"B":request.getParameter("oper_stn_type");
	String operstnid = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	 appluserid = request.getParameter("user")==null?"":request.getParameter("user");
	//String locncode = request.getParameter("location_type")==null?"":request.getParameter("location_type"); 
	//String user =request.getParameter("appluserid1") == null?"":request.getParameter("appluserid1");
	String locationid=request.getParameter("locncode1") == null?"":request.getParameter("locncode1");

		stmt = con.createStatement();
		stmt1 = con.createStatement();

		StringBuffer stringBuffer = new StringBuffer("");
		
		/*Below line Modified for this CRF Bru-HIMS-CRF-261*/

		stringBuffer.append(" SELECT facility_id, oper_stn_id, long_desc, short_desc, nurs_unit_code, ");
		stringBuffer.append(" shift_operated_yn, shift_group, ws_no, eff_status, ");
		stringBuffer.append(" NVL (book_appt_yn, 'N') book_appt_yn, ");
		stringBuffer.append(" NVL (book_appt_wo_pid_yn, 'N') book_appt_wo_pid_yn,");
		stringBuffer.append(" NVL (obook_appt_yn, 'N') obook_appt_yn,");
		stringBuffer.append(" NVL (forced_book_appt_yn, 'N') forced_book_appt_yn,");
		stringBuffer.append(" NVL (create_wait_list_yn, 'N') create_wait_list_yn,");
		stringBuffer.append(" NVL (modify_wait_list_yn, 'N') modify_wait_list_yn,");
		stringBuffer.append(" NVL (cancel_wait_list_yn, 'N') cancel_wait_list_yn,");
		stringBuffer.append(" NVL (cancel_checkout_yn, 'N') cancel_checkout_yn,");
		//16-sep-2008 CANCEL_RESERVE_BED_YN has
		stringBuffer.append(" NVL (CANCEL_RESERVE_BED_YN, 'N') CANCEL_RESERVE_BED_YN,");
		stringBuffer.append(" NVL (create_booking_with_conf_yn, 'N') create_booking_with_conf_yn,");
		stringBuffer.append(" NVL (global_book_appt_yn, 'N') global_book_appt_yn,");
		stringBuffer.append(" NVL (transfer_out_patient_yn, 'N') transfer_out_patient_yn,");
		stringBuffer.append(" NVL (transfer_in_patient_yn, 'N') transfer_in_patient_yn,");		stringBuffer.append("NVL(chg_nurs_unit_in_assign_bed_yn,'N')chg_nurs_unit_in_assign_bed_yn,");
		stringBuffer.append(" NVL (admit_patient_with_bed_yn, 'N') admit_patient_with_bed_yn,");
		stringBuffer.append(" NVL (swap_bed_yn, 'N') swap_bed_yn,");
		stringBuffer.append(" NVL (backdated_admission_yn, 'N') backdated_admission_yn,");
		stringBuffer.append(" NVL (bed_class_change_yn, 'N') bed_class_change_yn,");
		stringBuffer.append(" NVL (confirm_request_yn, 'N') confirm_request_yn,");
		stringBuffer.append(" NVL (cancel_request_yn, 'N') cancel_request_yn,");
		stringBuffer.append(" NVL (cancel_transfer_out_yn, 'N') cancel_transfer_out_yn,");
		stringBuffer.append(" NVL (pract_transfer_yn, 'N') pract_transfer_yn,");
		stringBuffer.append(" NVL (discharge_advice_yn, 'N') discharge_advice_yn,");
		stringBuffer.append(" NVL (book_appt_across_catg_yn, 'N') book_appt_across_catg_yn,");
		stringBuffer.append(" NVL (tfr_appt_yn, 'N') tfr_appt_yn,");
		stringBuffer.append(" NVL (tfr_appt_across_catg_yn, 'N') tfr_appt_across_catg_yn,");
		stringBuffer.append(" NVL (canc_appt_yn, 'N') canc_appt_yn,");
		stringBuffer.append(" NVL (register_visit_yn, 'N') register_visit_yn,");
		stringBuffer.append(" NVL (register_pat_yn, 'N') register_pat_yn,");
		stringBuffer.append(" NVL (cancel_visit_yn, 'N') cancel_visit_yn,");
		stringBuffer.append(" NVL (revise_visit_yn, 'N') revise_visit_yn,");
		stringBuffer.append(" NVL (manage_queue_yn, 'N') manage_queue_yn,");
		stringBuffer.append(" NVL (checkout_pat_yn, 'N') checkout_pat_yn, oper_stn_type,");
		stringBuffer.append(" NVL (create_booking_yn, 'N') create_booking_yn,");
		stringBuffer.append(" NVL (revise_booking_yn, 'N') revise_booking_yn,");
		stringBuffer.append(" NVL (canc_booking_yn, 'N') canc_booking_yn,");
		stringBuffer.append(" NVL (confirm_booking_yn, 'N') confirm_booking_yn,");
		stringBuffer.append(" NVL (admit_pat_yn, 'N') admit_pat_yn,");
		stringBuffer.append(" NVL (register_pat_in_admn_yn, 'N') register_pat_in_admn_yn,");
		stringBuffer.append(" NVL (assign_bed_yn, 'N') assign_bed_yn,");
		stringBuffer.append(" NVL (assign_treat_pract_yn, 'N') assign_treat_pract_yn,");
		stringBuffer.append(" NVL (revise_admission_yn, 'N') revise_admission_yn,");
		stringBuffer.append(" NVL (canc_admission_yn, 'N') canc_admission_yn,");
		stringBuffer.append(" NVL (emergency_tfr_yn, 'N') emergency_tfr_yn,");
		stringBuffer.append(" NVL (MAINTAIN_DEATH_REGISTER_YN, 'N') MAINTAIN_DEATH_REGISTER_YN,");
		stringBuffer.append(" NVL (routine_tfr_yn, 'N') routine_tfr_yn,");
		stringBuffer.append(" NVL (discharge_pat_yn, 'N') discharge_pat_yn,");
		stringBuffer.append(" NVL (revise_leave_yn, 'N') revise_leave_yn,");
		stringBuffer.append(" NVL (check_lodger_yn, 'N') check_lodger_yn,");
		stringBuffer.append(" NVL (block_bed_yn, 'N') block_bed_yn,");
		stringBuffer.append(" NVL (release_bed_yn, 'N') release_bed_yn,");
		stringBuffer.append(" NVL (register_visit_walkin_yn, 'N') register_visit_walkin_yn,");
		stringBuffer.append(" NVL (register_visit_referral_yn, 'N') register_visit_referral_yn ,");
		stringBuffer.append(" NVL (LINK_BABY_TO_MOTHER_YN, 'N') LINK_BABY_TO_MOTHER_YN,");
		stringBuffer.append(" NVL (REG_NEWBORN_FOR_IP_YN, 'N') REG_NEWBORN_FOR_IP_YN,");
		stringBuffer.append(" NVL (DISCHARGE_CHECKLIST_YN, 'N') DISCHARGE_CHECKLIST_YN,");
		stringBuffer.append(" NVL (RESERVE_BED_BAY_YN, 'N') RESERVE_BED_BAY_YN,");
		stringBuffer.append(" NVL (RELEASE_BED_BAY_YN, 'N') RELEASE_BED_BAY_YN, ");
		stringBuffer.append(" NVL (REG_IP_REFERRAL_YN, 'N') REG_IP_REFERRAL_YN,");
		stringBuffer.append(" NVL (CONFIRM_BEDSIDE_REFERRAL_YN, 'N') CONFIRM_BEDSIDE_REFERRAL_YN, ");
		stringBuffer.append(" NVL (CANCEL_DISCHARGE_YN, 'N') CANCEL_DISCHARGE_YN , NVL (OVERRIDE_WALKIN_YN, 'N') OVERRIDE_WALKIN_YN, NVL (DIAG_PROC_RECODE_FOR_IP_YN, 'N') DIAG_PROC_RECODE_FOR_IP_YN, NVL (DIAG_PROC_RECODE_FOR_OP_YN, 'N') DIAG_PROC_RECODE_FOR_OP_YN  ");
		stringBuffer.append(" ,NVL (emergency_transfer_yn, 'N') emergency_transfer_yn,nvl(quick_admission_yn,'N') quick_admission_yn");
		stringBuffer.append(" FROM AM_OPER_STN ");
		stringBuffer.append(" WHERE oper_stn_id =? AND facility_id =?");
		//rset = stmt.executeQuery(stringBuffer.toString());
		
		
		pstmt   = con.prepareStatement(stringBuffer.toString());
		pstmt.setString	(	1,	operstnid		);
		pstmt.setString	(	2,	facilityID		);
		rset		 = pstmt.executeQuery();

		if(rset !=null && rset.next())
		{
			bkwipd	= rset.getString("book_appt_wo_pid_yn");
			obappt	= rset.getString("obook_appt_yn");       
			bkapptac= rset.getString("book_appt_across_catg_yn");
			tfrappt	= rset.getString("tfr_appt_across_catg_yn");
			regvis	= rset.getString("register_pat_yn");
			quick_admission_yn	= rset.getString("quick_admission_yn");

			recordexists = "Y";
		}

		String sql1 ="select facility_id ,nvl(book_appt_yn,'N') book_appt_yn  ,nvl(book_appt_wo_pid_yn,'N') book_appt_wo_pid_yn,nvl(obook_appt_yn,'N') obook_appt_yn,nvl(book_appt_across_catg_yn ,'N') book_appt_across_catg_yn ,nvl(tfr_appt_yn,'N') tfr_appt_yn,nvl(tfr_appt_across_catg_yn,'N') tfr_appt_across_catg_yn,nvl(canc_appt_yn,'N') canc_appt_yn,nvl(FORCED_BOOK_APPT_YN,'N') FORCED_BOOK_APPT_YN, nvl(GLOBAL_BOOK_APPT_YN,'N') GLOBAL_BOOK_APPT_YN, nvl(create_wait_list_yn,'N') create_wait_list_yn, nvl(modify_wait_list_yn,'N') modify_wait_list_yn, nvl(cancel_wait_list_yn,'N') cancel_wait_list_yn,nvl(cancel_checkout_yn,'N') cancel_checkout_yn,nvl(CANCEL_RESERVE_BED_YN,'N') CANCEL_RESERVE_BED_YN,nvl(LINK_BABY_TO_MOTHER_YN,'N') LINK_BABY_TO_MOTHER_YN, nvl(REG_NEWBORN_FOR_IP_YN,'N') REG_NEWBORN_FOR_IP_YN,nvl(DISCHARGE_CHECKLIST_YN,'N') DISCHARGE_CHECKLIST_YN,nvl(RESERVE_BED_BAY_YN,'N') RESERVE_BED_BAY_YN,nvl(RELEASE_BED_BAY_YN,'N') RELEASE_BED_BAY_YN,nvl(REG_IP_REFERRAL_YN,'N') REG_IP_REFERRAL_YN,nvl(CONFIRM_BEDSIDE_REFERRAL_YN,'N') CONFIRM_BEDSIDE_REFERRAL_YN,nvl(CREATE_BOOKING_WITH_CONF_YN,'N') CREATE_BOOKING_WITH_CONF_YN, nvl(TRANSFER_OUT_PATIENT_YN,'N') TRANSFER_OUT_PATIENT_YN, nvl(TRANSFER_IN_PATIENT_YN,'N')   TRANSFER_IN_PATIENT_YN , nvl(CHG_NURS_UNIT_IN_ASSIGN_BED_YN,'N') CHG_NURS_UNIT_IN_ASSIGN_BED_YN, nvl(ADMIT_PATIENT_WITH_BED_YN,'N') ADMIT_PATIENT_WITH_BED_YN, nvl(SWAP_BED_YN,'N') SWAP_BED_YN,nvl(BACKDATED_ADMISSION_YN,'N') BACKDATED_ADMISSION_YN,nvl(BED_CLASS_CHANGE_YN,'N') BED_CLASS_CHANGE_YN,nvl(CONFIRM_REQUEST_YN,'N') CONFIRM_REQUEST_YN,nvl(CANCEL_REQUEST_YN,'N') CANCEL_REQUEST_YN,nvl(CANCEL_TRANSFER_OUT_YN,'N') CANCEL_TRANSFER_OUT_YN,nvl(PRACT_TRANSFER_YN,'N') PRACT_TRANSFER_YN,nvl(DISCHARGE_ADVICE_YN,'N') DISCHARGE_ADVICE_YN, nvl(register_visit_yn ,'N') register_visit_yn ,nvl(register_pat_yn,'N') register_pat_yn,nvl(cancel_visit_yn,'N') cancel_visit_yn,nvl(revise_visit_yn,'N') revise_visit_yn,nvl(manage_queue_yn ,'N') manage_queue_yn ,nvl(checkout_pat_yn,'N') checkout_pat_yn,nvl(create_booking_yn,'N') create_booking_yn,nvl(revise_booking_yn ,'N') revise_booking_yn ,nvl(canc_booking_yn,'N') canc_booking_yn,nvl(CONFIRM_BOOKING_YN,'N') CONFIRM_BOOKING_YN,nvl(admit_pat_yn,'N') admit_pat_yn,nvl(register_pat_in_admn_yn,'N') register_pat_in_admn_yn,nvl(assign_bed_yn ,'N') assign_bed_yn  ,nvl(assign_treat_pract_yn,'N') assign_treat_pract_yn,nvl(revise_admission_yn,'N') revise_admission_yn,nvl(canc_admission_yn,'N') canc_admission_yn,nvl(emergency_tfr_yn,'N') emergency_tfr_yn,nvl(MAINTAIN_DEATH_REGISTER_YN,'N') MAINTAIN_DEATH_REGISTER_YN,nvl(routine_tfr_yn ,'N') routine_tfr_yn  ,nvl(discharge_pat_yn,'N') discharge_pat_yn,nvl(revise_leave_yn,'N') revise_leave_yn,nvl(check_lodger_yn,'N')  check_lodger_yn, nvl(block_bed_yn,'N') block_bed_yn,  nvl(release_bed_yn,'N') release_bed_yn,NVL (register_visit_walkin_yn, 'N') register_visit_walkin_yn, NVL (register_visit_referral_yn, 'N') register_visit_referral_yn ,NVL (LINK_BABY_TO_MOTHER_YN, 'N') LINK_BABY_TO_MOTHER_YN,NVL (REG_NEWBORN_FOR_IP_YN, 'N') REG_NEWBORN_FOR_IP_YN, NVL (DISCHARGE_CHECKLIST_YN, 'N') DISCHARGE_CHECKLIST_YN, NVL(RESERVE_BED_BAY_YN, 'N') RESERVE_BED_BAY_YN,NVL (RELEASE_BED_BAY_YN, 'N') RELEASE_BED_BAY_YN, NVL (REG_IP_REFERRAL_YN, 'N') REG_IP_REFERRAL_YN, NVL (CONFIRM_BEDSIDE_REFERRAL_YN, 'N') CONFIRM_BEDSIDE_REFERRAL_YN ,added_by_id,added_date,added_at_ws_no,added_facility_id ,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id ,nvl(register_visit_walkin_yn,'N') register_visit_walkin_yn ,nvl(register_visit_referral_yn,'N') register_visit_referral_yn ,nvl(cancel_discharge_yn,'n') cancel_discharge_yn, nvl(OVERRIDE_WALKIN_YN,'n') OVERRIDE_WALKIN_YN, nvl(DIAG_PROC_RECODE_FOR_IP_YN,'n') DIAG_PROC_RECODE_FOR_IP_YN, nvl(DIAG_PROC_RECODE_FOR_OP_YN,'n') DIAG_PROC_RECODE_FOR_OP_YN,nvl(emergency_transfer_yn,'N') emergency_transfer_yn,nvl(quick_admission_yn,'N') quick_admission_yn from  AM_RESTRN_FOR_OPER_STN where oper_stn_id=? and facility_id=? and appl_user_id = ?  and locn_code = ? and LOCN_TYPE=?";	

		
		//rset1 = stmt1.executeQuery(sql1);
		pstmt1   = con.prepareStatement(sql1);
		pstmt1.setString	(	1,	operstnid		);
		pstmt1.setString	(	2,	facilityID		);
		pstmt1.setString	(	3,	appluserid		);
		pstmt1.setString	(	4,	locationid		);
		pstmt1.setString	(	5,	location_type		);
		rset1		 = pstmt1.executeQuery();


		if(rset1.next())
		{		
			a1=rset1.getString("FORCED_BOOK_APPT_YN");
			if(a1 .equals("Y"))
			{
				dis = "disabled = false";
				chk = "checked = true";
			}
		
			if((a1 .equals("N")) || (a1 .equals("")))
			{
				dis = "disabled = true";
				chk = "checked = false";
			}
			a2=rset1.getString("GLOBAL_BOOK_APPT_YN");
			if(a2 .equals("Y"))
			{
				dis = "disabled = false";
				chk = "checked = true";
			}
			
			if(a2 .equals("N"))
			{
				dis = "disabled = true";
				chk = "checked = false";
			}
	
			if(rset1.getString("checkout_pat_yn").equals("Y"))
				chkoutpatchk = "checked";
			if(rset1.getString("cancel_visit_yn").equals("Y"))
				cancelvisitchk = "checked";

			valueexits = "Y";

		}	
            _bw.write(_wl_block7Bytes, _wl_block7);
if (!location_type.equals("N"))
	{
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
if(recordexists.equals("Y") && rset.getString("book_appt_yn").equals("Y")) dis=""; else dis="disabled"; 
		
	if(valueexits.equals("Y") && rset1.getString("book_appt_yn").equals("Y")) chk="checked"; else 	chk=""; 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(recordexists.equals("Y") && rset.getString("book_appt_wo_pid_yn").equals("Y")) dis=""; else dis=" disabled "; 
            _bw.write(_wl_block15Bytes, _wl_block15);
if(valueexits.equals("Y")) { if(rset1.getString("book_appt_wo_pid_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(recordexists.equals("Y") && rset.getString("obook_appt_yn").equals("Y")) dis=""; else dis=" disabled "; 
            _bw.write(_wl_block15Bytes, _wl_block15);
if(valueexits.equals("Y")) { if(rset1.getString("obook_appt_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(recordexists.equals("Y")) { if(rset.getString("FORCED_BOOK_APPT_YN").equals("Y"))  dis=""; else dis=" disabled "; }
		
	if(valueexits.equals("Y")) { if(rset1.getString("FORCED_BOOK_APPT_YN").equals("Y")) chk=" checked "; else chk=""; } 
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(recordexists.equals("Y")) {if(rset.getString("GLOBAL_BOOK_APPT_YN").equals("Y")) dis=""; else dis=" disabled "; }
			
	if(valueexits.equals("Y")) { if(rset1.getString("GLOBAL_BOOK_APPT_YN").equals("Y")) chk=" checked "; else chk=""; } 	
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(recordexists.equals("Y")) {if(rset.getString("BOOK_APPT_ACROSS_CATG_YN").equals("Y")) dis=""; else dis=" disabled "; }
			
	if(valueexits.equals("Y")) { if(rset1.getString("BOOK_APPT_ACROSS_CATG_YN").equals("Y")) chk=" checked "; else chk=""; } 	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block25Bytes, _wl_block25);
if(recordexists.equals("Y") && rset.getString("tfr_appt_yn").equals("Y")) dis=""; else dis=" disabled "; 
            _bw.write(_wl_block15Bytes, _wl_block15);
if(valueexits.equals("Y")) { if(rset1.getString("tfr_appt_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(recordexists.equals("Y")) { if(rset.getString("canc_appt_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block32Bytes, _wl_block32);
if(valueexits.equals("Y")) { if(rset1.getString("canc_appt_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block35Bytes, _wl_block35);
if(recordexists.equals("Y")) { if(rset.getString("create_wait_list_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block15Bytes, _wl_block15);
if(valueexits.equals("Y")) { if(rset1.getString("create_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block35Bytes, _wl_block35);
if(recordexists.equals("Y")) { if(rset.getString("modify_wait_list_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block15Bytes, _wl_block15);
if(valueexits.equals("Y")) { if(rset1.getString("modify_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block35Bytes, _wl_block35);
if(recordexists.equals("Y")) { if(rset.getString("cancel_wait_list_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block15Bytes, _wl_block15);
if(valueexits.equals("Y")) { if(rset1.getString("cancel_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
if(recordexists.equals("Y")) { if(rset.getString("register_visit_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block15Bytes, _wl_block15);
if(valueexits.equals("Y")){ if(rset1.getString("register_visit_yn").equals("Y")) {chk=" checked ";reg_dis = "";}else chk=""; }
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block35Bytes, _wl_block35);
 if(recordexists.equals("Y") && rset.getString("register_visit_walkin_yn").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block45Bytes, _wl_block45);
if(valueexits.equals("Y")) { if(rset1.getString("register_visit_walkin_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(reg_dis));
            _bw.write(_wl_block48Bytes, _wl_block48);

		if(valueexits.equals("Y")) 
		{ 
			if(rset1.getString("register_visit_walkin_yn").equals("Y"))
			{
				if(recordexists.equals("Y") && rset.getString("OVERRIDE_WALKIN_YN").equals("Y"))	
				{
					dis="";		
				}	
				else
				{					
					dis=" disabled "; 
				}
				if(valueexits.equals("Y") && rset1.getString("OVERRIDE_WALKIN_YN").equals("Y"))	
				{
					chk="checked";	
				}	
				else
				{
					chk="";
				}
			}
			else
			{
				dis=" disabled ";
				chk="";
			}

		}
	
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(recordexists.equals("Y") && rset.getString("register_visit_referral_yn").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block15Bytes, _wl_block15);
if(valueexits.equals("Y")) { if(rset1.getString("register_visit_referral_yn").equals("Y")){ chk="CHECKED ";}else{ chk=""; }}
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(reg_dis));
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(recordexists.equals("Y") && rset.getString("register_pat_yn").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block53Bytes, _wl_block53);
if(valueexits.equals("Y")) { if(rset1.getString("register_pat_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(reg_dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block56Bytes, _wl_block56);
if(recordexists.equals("Y")) { if(rset.getString("manage_queue_yn").equals("Y")) dis=""; else dis="disabled "; }
            _bw.write(_wl_block32Bytes, _wl_block32);
if(valueexits.equals("Y")) { if(rset1.getString("manage_queue_yn").equals("Y")){ chk=" checked ";}else{ chk="";}}
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block35Bytes, _wl_block35);
if(recordexists.equals("Y")) { if(rset.getString("cancel_visit_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block32Bytes, _wl_block32);
 if(valueexits.equals("Y") && rset1.getString("cancel_visit_yn").equals("Y")) chk="checked"; else chk=""; 
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cancelvisitchk));
            _bw.write(_wl_block35Bytes, _wl_block35);
 if(recordexists.equals("Y") && rset.getString("revise_visit_yn").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block32Bytes, _wl_block32);
if(valueexits.equals("Y")) { if(rset1.getString("revise_visit_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block35Bytes, _wl_block35);
	if(recordexists.equals("Y")) { if(rset.getString("checkout_pat_yn").equals("Y"))	{		dis="";		}		else	dis=" disabled "; 	}	
            _bw.write(_wl_block32Bytes, _wl_block32);
 if(valueexits.equals("Y") && rset1.getString("checkout_pat_yn").equals("Y")) chk="checked"; else chk=""; 
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chkoutpatchk));
            _bw.write(_wl_block65Bytes, _wl_block65);
if(valueexits.equals("Y")) { if(rset1.getString("cancel_checkout_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(recordexists.equals("Y") && rset.getString("RESERVE_BED_BAY_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block53Bytes, _wl_block53);
if(valueexits.equals("Y")) { if(rset1.getString("RESERVE_BED_BAY_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(reg_dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block25Bytes, _wl_block25);
if(recordexists.equals("Y")) { if(rset.getString("RELEASE_BED_BAY_YN").equals("Y"))	{		dis="";		}		else	dis=" disabled "; 	}	
            _bw.write(_wl_block45Bytes, _wl_block45);
 if(valueexits.equals("Y") && rset1.getString("RELEASE_BED_BAY_YN").equals("Y")) chk="checked"; else chk=""; 
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
 if(recordexists.equals("Y") && rset.getString("DIAG_PROC_RECODE_FOR_OP_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block74Bytes, _wl_block74);
if(valueexits.equals("Y")) { if(rset1.getString("DIAG_PROC_RECODE_FOR_OP_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block77Bytes, _wl_block77);
 if(recordexists.equals("Y") && rset.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block78Bytes, _wl_block78);
if(valueexits.equals("Y")) { if(rset1.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block81Bytes, _wl_block81);
}else {
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
if(recordexists.equals("Y")) { if(rset.getString("create_booking_yn").equals("Y")) dis=""; else dis="disabled"; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("create_booking_yn").equals("Y")) chk="checked"; else chk=""; }
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
if(recordexists.equals("Y")) { if(rset.getString("revise_booking_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("revise_booking_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block91Bytes, _wl_block91);
if(recordexists.equals("Y")) { if(rset.getString("canc_booking_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block2Bytes, _wl_block2);
if(valueexits.equals("Y")) { if(rset1.getString("canc_booking_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_BOOKING_YN").equals("Y")) dis=""; else dis= "disabled"; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("CONFIRM_BOOKING_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block91Bytes, _wl_block91);
 if(recordexists.equals("Y") && rset.getString("CREATE_BOOKING_WITH_CONF_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block74Bytes, _wl_block74);
if(valueexits.equals("Y")) { if(rset1.getString("CREATE_BOOKING_WITH_CONF_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
if(recordexists.equals("Y")) { if(rset.getString("admit_pat_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("admit_pat_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
if(recordexists.equals("Y")) { if(rset.getString("quick_admission_yn").equals("Y"))dis=""; else dis=dis;}
            _bw.write(_wl_block103Bytes, _wl_block103);
if(valueexits.equals("Y")) { if(rset1.getString("quick_admission_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
if(recordexists.equals("Y")) { if(rset.getString("ADMIT_PATIENT_WITH_BED_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block103Bytes, _wl_block103);
if(valueexits.equals("Y")) { if(rset1.getString("ADMIT_PATIENT_WITH_BED_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
if(recordexists.equals("Y")) { if(rset.getString("register_pat_in_admn_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("register_pat_in_admn_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
if(recordexists.equals("Y")) { if(rset.getString("assign_bed_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block2Bytes, _wl_block2);
if(valueexits.equals("Y")) { if(rset1.getString("assign_bed_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
 if(recordexists.equals("Y") && rset.getString("CHG_NURS_UNIT_IN_ASSIGN_BED_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block114Bytes, _wl_block114);
if(valueexits.equals("Y")) { if(rset1.getString("CHG_NURS_UNIT_IN_ASSIGN_BED_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
if(recordexists.equals("Y")) { if(rset.getString("assign_treat_pract_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block74Bytes, _wl_block74);
if(valueexits.equals("Y")) { if(rset1.getString("assign_treat_pract_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
if(recordexists.equals("Y")) { if(rset.getString("revise_admission_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block74Bytes, _wl_block74);
if(valueexits.equals("Y")) { if(rset1.getString("revise_admission_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
if(recordexists.equals("Y")) { if(rset.getString("canc_admission_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("canc_admission_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
if(recordexists.equals("Y")) { if(rset.getString("BACKDATED_ADMISSION_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("BACKDATED_ADMISSION_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
if(recordexists.equals("Y")) { if(rset.getString("LINK_BABY_TO_MOTHER_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("LINK_BABY_TO_MOTHER_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
if(recordexists.equals("Y")) { if(rset.getString("REG_NEWBORN_FOR_IP_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("REG_NEWBORN_FOR_IP_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
if(recordexists.equals("Y")) { if(rset.getString("emergency_tfr_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block74Bytes, _wl_block74);
if(valueexits.equals("Y")) { if(rset1.getString("emergency_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
if(recordexists.equals("Y")) { if(rset.getString("routine_tfr_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("routine_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
if(recordexists.equals("Y")) { if(rset.getString("CANCEL_REQUEST_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("CANCEL_REQUEST_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_REQUEST_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("CONFIRM_REQUEST_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
if(recordexists.equals("Y") && rset.getString("TRANSFER_OUT_PATIENT_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("TRANSFER_OUT_PATIENT_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
if(recordexists.equals("Y")) { if(rset.getString("CANCEL_TRANSFER_OUT_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("CANCEL_TRANSFER_OUT_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
 if(recordexists.equals("Y") && rset.getString("TRANSFER_IN_PATIENT_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block74Bytes, _wl_block74);
if(valueexits.equals("Y")) { if(rset1.getString("TRANSFER_IN_PATIENT_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
 if(recordexists.equals("Y") && rset.getString("SWAP_BED_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("SWAP_BED_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block144Bytes, _wl_block144);
if(recordexists.equals("Y")) { if(rset.getString("emergency_transfer_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block2Bytes, _wl_block2);
if(valueexits.equals("Y")) { if(rset1.getString("emergency_transfer_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
if(recordexists.equals("Y")) { if(rset.getString("PRACT_TRANSFER_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block84Bytes, _wl_block84);
if(valueexits.equals("Y")) { if(rset1.getString("PRACT_TRANSFER_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block149Bytes, _wl_block149);
if(recordexists.equals("Y")) { if(rset.getString("CANCEL_RESERVE_BED_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block2Bytes, _wl_block2);
if(valueexits.equals("Y")) { if(rset1.getString("CANCEL_RESERVE_BED_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
 if(recordexists.equals("Y") && rset.getString("DISCHARGE_ADVICE_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("DISCHARGE_ADVICE_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
if(recordexists.equals("Y")) { if(rset.getString("discharge_pat_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("discharge_pat_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
if(recordexists.equals("Y")) { if(rset.getString("BED_CLASS_CHANGE_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("BED_CLASS_CHANGE_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

		
if(recordexists.equals("Y")) { if(rset.getString("DISCHARGE_CHECKLIST_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("DISCHARGE_CHECKLIST_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);


if(recordexists.equals("Y")) { if(rset.getString("CANCEL_DISCHARGE_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("cancel_discharge_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("block_bed_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block74Bytes, _wl_block74);
if(valueexits.equals("Y")) { if(rset1.getString("block_bed_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
if(recordexists.equals("Y")) { if(rset.getString("RELEASE_BED_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("RELEASE_BED_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("revise_leave_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("revise_leave_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
if(recordexists.equals("Y")) { if(rset.getString("check_lodger_yn").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("check_lodger_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
if(recordexists.equals("Y")) { if(rset.getString("REG_IP_REFERRAL_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("REG_IP_REFERRAL_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_BEDSIDE_REFERRAL_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block74Bytes, _wl_block74);
if(valueexits.equals("Y")) { if(rset1.getString("CONFIRM_BEDSIDE_REFERRAL_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block170Bytes, _wl_block170);
if(recordexists.equals("Y")) { if(rset.getString("CANCEL_CHECKOUT_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block15Bytes, _wl_block15);
if(valueexits.equals("Y")) { if(rset1.getString("CANCEL_CHECKOUT_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block172Bytes, _wl_block172);

if(recordexists.equals("Y")) { if(rset.getString("DIAG_PROC_RECODE_FOR_IP_YN").equals("Y")) dis=""; else dis=" disabled "; }
            _bw.write(_wl_block88Bytes, _wl_block88);
if(valueexits.equals("Y")) { if(rset1.getString("DIAG_PROC_RECODE_FOR_IP_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block175Bytes, _wl_block175);
 if(recordexists.equals("Y") && rset.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) dis=""; else dis="disabled"; 
            _bw.write(_wl_block78Bytes, _wl_block78);
if(valueexits.equals("Y")) { if(rset1.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block177Bytes, _wl_block177);
}
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(rset.getString("tfr_appt_across_catg_yn")));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(rset.getString("create_booking_with_conf_yn")));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(rset.getString("create_booking_yn")));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(rset.getString("book_appt_wo_pid_yn")));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(rset.getString("book_appt_across_catg_yn")));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(rset.getString("forced_book_appt_yn")));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(rset.getString("global_book_appt_yn")));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(rset.getString("obook_appt_yn")));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(rset.getString("tfr_appt_yn")));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(rset.getString("register_visit_yn")));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(rset.getString("register_pat_in_admn_yn")));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(rset.getString("register_visit_walkin_yn")));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(rset.getString("register_visit_referral_yn")));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(rset.getString("register_pat_yn")));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(rset.getString("admit_patient_with_bed_yn")));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(rset.getString("chg_nurs_unit_in_assign_bed_yn")));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(rset.getString("LINK_BABY_TO_MOTHER_YN")));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(rset.getString("REG_NEWBORN_FOR_IP_YN")));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(rset.getString("DISCHARGE_CHECKLIST_YN")));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(rset.getString("CANCEL_DISCHARGE_YN")));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(rset.getString("RESERVE_BED_BAY_YN")));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(rset.getString("RELEASE_BED_BAY_YN")));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(rset.getString("REG_IP_REFERRAL_YN")));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(rset.getString("CONFIRM_BEDSIDE_REFERRAL_YN")));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(rset.getString("OVERRIDE_WALKIN_YN")));
            _bw.write(_wl_block203Bytes, _wl_block203);


	/*	if(location_type.equals("N"))
			out.println("<script>tab_click('additional_tab')</script>");
		else
			out.println("<script>tab_click('search_tab')</script>");     */

		out.println("<input type=\"hidden\" name=\"operstntype\" value="+operstntype+">");

		if(mode.equals("insert"))
		{
			
			if(location_type.equals("N"))
			{
				//out.println("<script>alert(' location insert')</script>");

				if(rset.getString("create_booking_with_conf_yn").equals("Y"))
				out.println("<script>document.forms[0].CREATE_BOOKING_WITH_CONF_YN.checked = true;</script>");
				if(rset.getString("transfer_out_patient_yn").equals("Y"))
				out.println("<script>document.forms[0].TRANSFER_OUT_PATIENT_YN.checked = true;</script>");
				if(rset.getString("transfer_in_patient_yn").equals("Y"))
				out.println("<script>document.forms[0].TRANSFER_IN_PATIENT_YN.checked = true;</script>");
				if(rset.getString("chg_nurs_unit_in_assign_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.checked = true;</script>");
				if(rset.getString("admit_patient_with_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked = true;</script>");
				
				/*Below line Added for this CRF Bru-HIMS-CRF-261*/
				if(rset.getString("quick_admission_yn").equals("Y"))
				out.println("<script>if(document.forms[0].quick_admission_yn)document.forms[0].quick_admission_yn.checked = true;</script>");
				//End Bru-HIMS-CRF-261
				
				if(rset.getString("swap_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].SWAP_BED_YN.checked = true;</script>");
				if(rset.getString("backdated_admission_yn").equals("Y"))
				out.println("<script>document.forms[0].BACKDATED_ADMISSION_YN.checked = true;</script>");
				if(rset.getString("bed_class_change_yn").equals("Y"))
				out.println("<script>document.forms[0].BED_CLASS_CHANGE_YN.checked = true;</script>");
				if(rset.getString("confirm_request_yn").equals("Y"))
				out.println("<script>document.forms[0].cfrm_req_yn.checked = true;</script>");
				if(rset.getString("cancel_request_yn").equals("Y"))
				out.println("<script>document.forms[0].canc_req_yn.checked = true;</script>");
				if(rset.getString("cancel_transfer_out_yn").equals("Y"))
				out.println("<script>document.forms[0].can_tfr_out_yn.checked = true;</script>");
				if(rset.getString("pract_transfer_yn").equals("Y"))
				out.println("<script>document.forms[0].pract_tfr_yn.checked = true;</script>");
				if(rset.getString("discharge_advice_yn").equals("Y"))
				out.println("<script>document.forms[0].dchrg_adv_yn.checked = true;</script>");
				if(rset.getString("create_booking_yn").equals("Y"))
				out.println("<script>document.forms[0].create_booking_yn.checked = true;</script>");
				if(rset.getString("revise_booking_yn").equals("Y"))
				out.println("<script>document.forms[0].revise_booking_yn.checked = true;</script>");
				if(rset.getString("canc_booking_yn").equals("Y"))
				out.println("<script>document.forms[0].canc_booking_yn.checked = true;</script>");
				if(rset.getString("confirm_booking_yn").equals("Y"))
				out.println("<script>document.forms[0].CONFIRM_BOOKING_YN.checked = true;</script>");
				if(rset.getString("admit_pat_yn").equals("Y"))
				out.println("<script>document.forms[0].admit_pat_yn.checked = true;</script>");
				if(rset.getString("register_pat_in_admn_yn").equals("Y"))
				out.println("<script>document.forms[0].register_pat_in_admn_yn.checked = true;</script>");
				if(rset.getString("assign_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].assign_bed_yn.checked = true;</script>");
				if(rset.getString("assign_treat_pract_yn").equals("Y"))
				out.println("<script>document.forms[0].assign_treat_pract_yn.checked = true;</script>");
                if(rset.getString("revise_admission_yn").equals("Y"))
				out.println("<script>document.forms[0].revise_admission_yn.checked = true;</script>");
				if(rset.getString("canc_admission_yn").equals("Y"))
				out.println("<script>document.forms[0].canc_admission_yn.checked = true;</script>");
				if(rset.getString("emergency_tfr_yn").equals("Y"))
				out.println("<script>document.forms[0].emergency_tfr_yn.checked = true;</script>");
				if(rset.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y"))
				out.println("<script>document.forms[0].MAINTAIN_DEATH_REGISTER_YN.checked = true;</script>");
				if(rset.getString("routine_tfr_yn").equals("Y"))
				out.println("<script>document.forms[0].routine_tfr_yn.checked = true;</script>");
				if(rset.getString("discharge_pat_yn").equals("Y"))
				out.println("<script>document.forms[0].discharge_pat_yn.checked = true;</script>");
				if(rset.getString("revise_leave_yn").equals("Y"))
				out.println("<script>document.forms[0].revise_leave_yn.checked = true;</script>");
				if(rset.getString("check_lodger_yn").equals("Y"))
				out.println("<script>document.forms[0].check_lodger_yn.checked = true;</script>");
				if(rset.getString("block_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].block_bed_yn.checked = true;</script>");
				if(rset.getString("release_bed_yn").equals("Y"))
				out.println("<script>document.forms[0].release_bed_yn.checked = true;</script>");
				if(rset.getString("cancel_discharge_yn").equals("Y"))
				out.println("<script>document.forms[0].cancel_discharge_yn.checked = true;</script>");

				if(rset.getString("CANCEL_RESERVE_BED_YN").equals("Y"))
				out.println("<script>document.forms[0].CANCEL_RESERVE_BED_YN.checked = true;</script>");
				
				if(rset.getString("emergency_transfer_yn").equals("Y"))
				out.println("<script>document.forms[0].emergency_transfer_yn.checked = true;</script>");

				/*out.println("<script>document.forms[0].book_appt_wo_pid_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].book_appt_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].tfr_appt_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].tfr_appt_across_catg_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].obook_appt_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].book_appt_across_catg_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].canc_appt_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].FORCED_BOOK_APPT_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].GLOBAL_BOOK_APPT_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].create_wait_list_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].modify_wait_list_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].cancel_wait_list_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_visit_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].manage_queue_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_visit_walkin_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_pat_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].cancel_visit_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].revise_visit_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_visit_referral_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].checkout_pat_yn.value = 'N';</script>");*/

				
			}
			else
			{
				if(rset.getString("book_appt_wo_pid_yn").equals("Y"))
			//out.println("<script>alert('book_appt_wo_pid_yn')</script>");	
				out.println("<script>document.forms[0].book_appt_wo_pid_yn.checked = true;</script>");
				if(rset.getString("book_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].book_appt_yn.checked = true;</script>");
				if(rset.getString("tfr_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].tfr_appt_yn.checked = true;</script>");
				if(rset.getString("tfr_appt_across_catg_yn").equals("Y"))
				out.println("<script>document.forms[0].tfr_appt_across_catg_yn.checked = true;</script>");
				if(rset.getString("obook_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].obook_appt_yn.checked = true;</script>");
				if(rset.getString("book_appt_across_catg_yn").equals("Y"))
				out.println("<script>document.forms[0].book_appt_across_catg_yn.checked = true;</script>");
				if(rset.getString("canc_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].canc_appt_yn.checked = true;</script>");
				if(rset.getString("forced_book_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].FORCED_BOOK_APPT_YN.checked = true;</script>");
				if(rset.getString("global_book_appt_yn").equals("Y"))
				out.println("<script>document.forms[0].GLOBAL_BOOK_APPT_YN.checked = true;</script>");
				if(rset.getString("create_wait_list_yn").equals("Y"))
				out.println("<script>document.forms[0].create_wait_list_yn.checked = true;</script>");
				if(rset.getString("modify_wait_list_yn").equals("Y"))
				out.println("<script>document.forms[0].modify_wait_list_yn.checked = true;</script>");
				if(rset.getString("cancel_wait_list_yn").equals("Y"))
				out.println("<script>document.forms[0].cancel_wait_list_yn.checked = true;</script>");
				
				

//cancel checkout
                if(rset.getString("cancel_checkout_yn").equals("Y"))
				out.println("<script>document.forms[0].cancel_checkout_yn.checked = true;</script>");

				if(rset.getString("register_visit_yn").equals("Y"))
				out.println("<script>document.forms[0].register_visit_yn.checked = true;</script>");
				if(rset.getString("manage_queue_yn").equals("Y"))
				out.println("<script>document.forms[0].manage_queue_yn.checked = true;</script>");
				if(rset.getString("register_visit_walkin_yn").equals("Y"))
				out.println("<script>document.forms[0].register_visit_walkin_yn.checked = true;</script>");
				if(rset.getString("register_pat_yn").equals("Y"))
				out.println("<script>document.forms[0].register_pat_yn.checked = true;</script>");
				if(rset.getString("cancel_visit_yn").equals("Y"))
				out.println("<script>document.forms[0].cancel_visit_yn.checked = true;</script>");
				if(rset.getString("revise_visit_yn").equals("Y"))
				out.println("<script>document.forms[0].revise_visit_yn.checked = true;</script>");
				if(rset.getString("register_visit_referral_yn").equals("Y"))
				out.println("<script>document.forms[0].register_visit_referral_yn.checked = true;</script>");
				if(rset.getString("checkout_pat_yn").equals("Y"))
				out.println("<script>document.forms[0].checkout_pat_yn.checked = true;</script>");

				
			/*	out.println("<script>document.forms[0].CREATE_BOOKING_WITH_CONF_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].TRANSFER_OUT_PATIENT_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].TRANSFER_IN_PATIENT_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].ADMIT_PATIENT_WITH_BED_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].SWAP_BED_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].BACKDATED_ADMISSION_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].BED_CLASS_CHANGE_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].cfrm_req_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].canc_req_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].can_tfr_out_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].pract_tfr_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].dchrg_adv_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].create_booking_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].revise_booking_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].canc_booking_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].CONFIRM_BOOKING_YN.value = 'N';</script>");
				out.println("<script>document.forms[0].admit_pat_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].register_pat_in_admn_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].assign_bed_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].assign_treat_pract_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].canc_admission_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].emergency_tfr_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].routine_tfr_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].discharge_pat_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].revise_leave_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].check_lodger_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].block_bed_yn.value = 'N';</script>");
				out.println("<script>document.forms[0].release_bed_yn.value = 'N';</script>");*/
			}
		}
	//} ///// EOF MAIN ELSE 
}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
}
finally 
{
	try
	{
		if ( rschk != null)  rschk.close();
		if ( stchk != null)  stchk.close();
		if (stmt != null) stmt.close();
		if (pstmt != null) pstmt.close();
		if (rset != null)   rset.close();
		if (stmt1 != null) stmt1.close();
		if (pstmt1 != null) pstmt1.close();
		if (rset1 != null)   rset1.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(appluserid));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(bkwipd));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(bkwipd));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(a1));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(a2));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(obappt));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(bkapptac));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(tfrappt));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(regvis));
            _bw.write(_wl_block215Bytes, _wl_block215);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bookappointment.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.BookAppointmentwithoutPatientID.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.OverbookAppointment.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.AllowForcedinAppointment.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.AllowGlobalBooking.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferAppointment.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelAppointment.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CreateWaitList.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModifyWaitList.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelWaitList.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegisterVisit.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterWalkIn.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.OverrideWalkIn.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterReferral.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterPatientfromRegisterVisit.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ManageQueue.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.CancelVisit.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReviseVisit.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.CheckoutPatient.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelCheckout.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ReserveBedBay.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ReleaseBedBay.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisProcedureRecode.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MaintainDeathRegister.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CreateBooking.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.revisebooking.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelBooking.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConfirmBooking.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ConfirmonCreatebooking.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmitPatient.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.QuickAdmission.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.AdmitPatientwithBed.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterPatientFromAdmitPatient.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AssignBed.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.AllowChangingNursingUnitinAssignBed.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AssignTreatingPractitioner.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ChangeAdmDtls.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelAdmission.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.BackdatedAdmission.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LinkBabyToMother.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterNewbornforIP.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferPatient.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestforTransfer.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelRequest.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ConfirmRequest.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferOut.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.CancelTransferOut.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.TransferIn.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.SwapBed.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.EmergencyTransfer.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PractitionerTransfer.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelReservBeds.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargeAdvice.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargePatient.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.BedClasschange.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.Dischargechecklist.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelDischarge.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockBed.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReleaseBed.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RecordAmendLeave.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.CheckInCheckOutLodger.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegisterInpatientReferral.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConfirmBedsideReferral.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelCheckout.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisProcedureRecode.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MaintainDeathRegister.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }
}
