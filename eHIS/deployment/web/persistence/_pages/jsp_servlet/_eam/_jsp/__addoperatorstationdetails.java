package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addoperatorstationdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addOperatorStationDetails.jsp", 1719916849249L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n      <head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\'></link>\n\t\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eAM/js/OperatorStation.js\'></script>\n\n      \t<script>\n\n\n\n\n\nfunction callfocusfun()\n{\n     \n\t if(parent.frames[0].document.forms[0].operstntype.value==\'O\')\n\t document.forms[0].book_appt_yn.focus()\n}\n\nfunction disencfrm()\n {\n\n\tif(document.forms[0].eff_status.value == \'E\')\n\t{\n\t\t\n\t\t\n\t if( document.forms[0].create_booking_yn.checked == true)\n\t {\n\n\t\t document.getElementById(\"CREATE_BOOKING_WITH_CONF_YN\").disabled = true;\n\t\t document.getElementById(\"CREATE_BOOKING_WITH_CONF_YN\").checked = false;\n\t\t document.getElementById(\"CREATE_BOOKING_WITH_CONF_YN\").value = \"N\";\n\t\t\n\t }\n\t else \n\t {\n\t\t\n\t\tdocument.getElementById(\"CREATE_BOOKING_WITH_CONF_YN\").disabled = false;\n\t\t  \n\t\t  \n\t }\n\t}\n }\n\n function disencr()\n{\n\tif(document.forms[0].eff_status.value == \'E\')\n\t{\n\t if( document.forms[0].CREATE_BOOKING_WITH_CONF_YN.checked)\n\t {\n\t\t document.forms[0].create_booking_yn.disabled = true;\n\t\t document.getElementById(\'create_booking_yn\').checked = false;\n\t\t document.getElementById(\'create_booking_yn\').value = \"N\";\n\t }\n\t else\n\t {\n\t\t document.forms[0].create_booking_yn.disabled = false;\n\t\t\n\t }\n\t}\n }\n\n function chk_others(obj){\n  if(obj.name==\'book_appt_yn\'){\n\t if(obj.checked==true){\n\t\n\t document.forms[0].book_appt_wo_pid_yn.disabled=false;\n\t document.forms[0].obook_appt_yn.disabled=false;\n\n\t// document.forms[0].book_appt_across_catg_yn.disabled=false; \n\t\n\t document.getElementById(\'FORCED_BOOK_APPT_YN\').disabled=false;\n\n\t document.getElementById(\'GLOBAL_BOOK_APPT_YN\').disabled=false; \n\t// document.getElementById(\'BOOK_APPT_ACROSS_CATG_YN\').disabled=false;\n\n\t }\n\t else{\n\t\t\n\t document.forms[0].book_appt_wo_pid_yn.checked=false;\n\t document.forms[0].book_appt_wo_pid_yn.disabled=true;\n\t document.forms[0].obook_appt_yn.checked=false;\n\t document.forms[0].obook_appt_yn.disabled=true;\n\t// document.forms[0].book_appt_across_catg_yn.checked=false;\n\t// document.forms[0].book_appt_across_catg_yn.disabled=true; \n\t  \n\t  document.getElementById(\'FORCED_BOOK_APPT_YN\').checked=false; \n\t  \n\t  document.getElementById(\'FORCED_BOOK_APPT_YN\').disabled=true;\n  \t document.getElementById(\'GLOBAL_BOOK_APPT_YN\').checked=false; \n\t document.getElementById(\'GLOBAL_BOOK_APPT_YN\').disabled=true; \n\t// document.getElementById(\'BOOK_APPT_ACROSS_CATG_YN\').checked=false;\n\t// document.getElementById(\'BOOK_APPT_ACROSS_CATG_YN\').disabled=true;\n\t \n\t }\n \n }\n/* else if(obj.name==\'tfr_appt_yn\'){\n\tif(obj.checked==true){\n\t  document.forms[0].tfr_appt_across_catg_yn.disabled=false;\n\t }\n\t else{\n\t \t document.forms[0].tfr_appt_across_catg_yn.checked=false;\n\t\t document.forms[0].tfr_appt_across_catg_yn.disabled=true;\n\t }\n } */\n else if(obj.name==\'register_visit_yn\'){\n\tif(obj.checked==true){\n\t document.forms[0].register_pat_yn.disabled=false;\n\t document.forms[0].register_visit_walkin_yn.disabled=false;\n\t document.forms[0].register_visit_referral_yn.disabled=false;\n\t }\n\t else{\n\t \t document.forms[0].register_pat_yn.checked=false;\n\t\t document.forms[0].register_pat_yn.disabled=true;\n\t\t document.forms[0].register_visit_walkin_yn.checked=false;\n\t \tdocument.forms[0].register_visit_walkin_yn.disabled=true;\n\t \tdocument.forms[0].register_visit_referral_yn.checked=false;\n\t \tdocument.forms[0].register_visit_referral_yn.disabled=true;\n\t }\n }\n else if(obj.name==\'register_visit_walkin_yn\'){\n\t if(obj.checked==true){\n\t\tdocument.forms[0].OVERRIDE_WALKIN_YN.disabled=false;\t \n\t }\n\t else{\n\t \tdocument.forms[0].OVERRIDE_WALKIN_YN.checked=false;\n\t\tdocument.forms[0].OVERRIDE_WALKIN_YN.disabled=true;\t\t\n\t }\n }\n\n \n \n }\n function setVal(Obj)\n {\n\n\tif(Obj.checked == true)      \t\t\n\t\tObj.value = \'Y\';     \t\t\n\telse if(Obj.checked == false)\n\t\tObj.value = \'N\';\n\n\n }\n\n\nvar optype;\n\n/*function setView()\n{\n\toptype=parent.frames[0].document.forms[0].operstntype.value;\n\tif (optype==\'I\')\n\t{\n\t\tdocument.getElementById(\'inpat_act_tab_vw\').scrollIntoView();\n\t\tdocument.getElementById(\'create_booking_yn\').focus();\n\t}\n\telse if(optype==\'O\')\n\t{\n\t\tdocument.getElementById(\'outpat_act_tab_vw\').scrollIntoView();\n\t\tdocument.getElementById(\'book_appt_yn\').focus();\n\t}\n}*/\n\n\nfunction codeArrestforScroll(e)\n{\n\t\n\talert(getMessage(\"WELCOME\",\"Common\"));\n\treturn false;\n}\n   \t\n \n\nfunction chkDetails(obj)\n{\n\t\n\tif (document.forms[0].function_name.value!=\'insert\')\n\t{\n\t\tif(document.forms[0].FORCED_BOOK_APPT_YN)\n\t\t{\n\t\tif (obj.checked==true)\t\n\t\t\tdocument.forms[0].FORCED_BOOK_APPT_YN.value=\"Y\";\n\t\telse if (obj.checked==false)\t\n\t\t\tdocument.forms[0].FORCED_BOOK_APPT_YN.value=\"N\";\n\t\t}\n\t}\t\n\tif (document.forms[0].function_name.value!=\'insert\')\n\t{\n\t\tif(document.forms[0].MAINTAIN_DEATH_REGISTER_YN)\n\t\t{\n\t\tif (obj.checked==true)\t\n\t\t\tdocument.forms[0].MAINTAIN_DEATH_REGISTER_YN.value=\"Y\";\n\t\telse if (obj.checked==false)\t\n\t\t\tdocument.forms[0].MAINTAIN_DEATH_REGISTER_YN.value=\"N\";\n\t\t}\t\t\n\t}\t\n\t\n\tif (document.forms[0].function_name.value!=\'insert\')\n\t{\n\t\tif (obj.name==\'pract_tfr_yn\')\t\t\t\n\t\t{\t\t\t\n\t\t\tif (parseInt(document.forms[0].PTFR_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\t//9/16/2008 chking validation for CancelReserve bed start\n\t\t\n\t\tif (obj.name==\'cancel_reBeds_yn\')\t\t\t\n\t\t{\n\t\t\t//alert(document.forms[0].CRB__YN_CNT.value);\n\t\t\n\t\t\tif (parseInt(document.forms[0].CRB__YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\t//9/16/2008 chking validation for CancelReserve bed end\n\t\telse if (obj.name==\'BED_CLASS_CHANGE_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].BC_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\t\t\n\t\telse if (obj.name==\'book_appt_yn\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].book_appt_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\t\t\n\t\telse if (obj.name==\'book_appt_wo_pid_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].book_appt_wo_pid_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'obook_appt_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].obook_appt_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\t\t\t\n\t\telse if (obj.name==\'FORCED_BOOK_APPT_YN\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].FORCED_BOOK_APPT_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\t///Newly added on 09/01/2005\n\t\telse if (obj.name==\'create_wait_list_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].create_wait_list_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'modify_wait_list_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].modify_wait_list_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'cancel_wait_list_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].cancel_wait_list_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'GLOBAL_BOOK_APPT_YN\')\n\t\t{\t\t\t\n\t\t\tvar flag=\"Y\";\n\t\t\tif (parseInt(document.forms[0].GLOBAL_BOOK_APPT_YN_CNT.value) > 0)\n\t\t\t{\t\t\t\t\t\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t\tflag=\"N\";\n\t\t\t}\n\t\t\tif(document.forms[0].GLOBAL_BOOK_APPT_YN.checked==false){ \n\t\t\t\tif ((parseInt(document.forms[0].GLOBAL_LOCN_APPT_YN_CNT.value) > 0)&& (flag==\"Y\"))\n\t\t\t\t{\t\t\t\t\n\t\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN_LOCN\",\"AM\"));\n\t\t\t\t\tobj.checked=true;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\n\t\telse if (obj.name==\'tfr_appt_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].tfr_appt_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\t/*else if (obj.name==\'tfr_appt_across_catg_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].tfr_appt_across_catg_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}*/\n\t\telse if (obj.name==\'canc_appt_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].canc_appt_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'register_visit_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].register_visit_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'register_pat_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].register_pat_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'cancel_visit_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].cancel_visit_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'revise_visit_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].revise_visit_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'manage_queue_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].manage_queue_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'checkout_pat_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].checkout_pat_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'create_booking_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].create_booking_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'revise_booking_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].revise_booking_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'canc_booking_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].canc_booking_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'CONFIRM_BOOKING_YN\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].CONFIRM_BOOKING_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'admit_pat_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].admit_pat_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="\n\t\t}\n\t\telse if (obj.name==\'quick_admission_yn\')\n\t\t{\t//this condtion added for this CRF Bru-HIMS-CRF-261\t\n\t\t\tif (parseInt(document.forms[0].quick_admission_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'register_pat_in_admn_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].register_pat_in_admn_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'assign_bed_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].assign_bed_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'assign_treat_pract_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].assign_treat_pract_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'canc_admission_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].canc_admission_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'emergency_tfr_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].emergency_tfr_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'routine_tfr_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].routine_tfr_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'discharge_pat_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].discharge_pat_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'revise_leave_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].revise_leave_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'check_lodger_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].check_lodger_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'block_bed_yn\')\n\t\t{\t\t\n\t\t\tif (parseInt(document.forms[0].block_bed_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'release_bed_yn\')\n\t\t{\n\t\t\tif (parseInt(document.forms[0].release_bed_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'register_visit_walkin_yn\')\n\t\t{\n\t\t\tif (parseInt(document.forms[0].register_visit_walkin_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'register_visit_referral_yn\')\n\t\t{\n\t\t\tif (parseInt(document.forms[0].register_visit_referral_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'canc_req_yn\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].CRQ_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'cfrm_req_yn\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].CFQ_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'TRANSFER_OUT_PATIENT_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].TRANSFER_OUT_PATIENT_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'can_tfr_out_yn\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].CTO_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'TRANSFER_OUT_PATIENT_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].TRANSFER_OUT_PATIENT_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'TRANSFER_IN_PATIENT_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].TRANSFER_IN_PATIENT_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'SWAP_BED_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].SWAP_BED_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'ADMIT_PATIENT_WITH_BED_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].ADMIT_PATIENT_WITH_BED_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'CHG_NURS_UNIT_IN_ASSIGN_BED_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'BACKDATED_ADMISSION_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].BA_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'dchrg_adv_yn\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].DADV_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}else if (obj.name==\'LINK_BABY_TO_MOTHER_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].link_baby_to_mother_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'REG_NEWBORN_FOR_IP_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].reg_newborn_for_ip_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}else if (obj.name==\'DISCHARGE_CHECKLIST_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].discharge_checklist_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}else if(obj.name==\'CANCEL_DISCHARGE_YN\')\n\t\t{\n\t\t\t\n\t\t\tif (parseInt(document.forms[0].cancel_discharge_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'RESERVE_BED_BAY_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].reserve_bed_bay_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'RELEASE_BED_BAY_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].release_bed_bay_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\n\nelse if (obj.name==\'DIAG_PROC_RECODE_FOR_OP_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].dia_proc_recode_for_op_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\n\n   else if (obj.name==\'DIAG_PROC_RECODE_FOR_IP_YN\')\t\t\t\n\t\t{\n\t   \t\tif (parseInt(document.forms[0].dia_proc_recode_for_ip_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\t\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\n\t\telse if (obj.name==\'REG_IP_REFERRAL_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].reg_ip_referral_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'CONFIRM_BEDSIDE_REFERRAL_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].conf_bed_ref_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\n\t\telse if (obj.name==\'OVERRIDE_WALKIN_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].override_walkin_yn_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\t\n\t\telse if (obj.name==\'CANCEL_CHECKOUT_YN\')\t\t\t\n\t\t{\n\t\t\tif (parseInt(document.forms[0].CANCEL_CHECKOUT_YN.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if (obj.name==\'MAINTAIN_DEATH_REGISTER_YN\')\t\t\t\n\t\t{\t\t\t\n\t\t\tif (parseInt(document.forms[0].MAINTAIN_DEATH_REGISTER_YN_CNT.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t}\n\t\telse if(obj.name==\'BOOK_APPT_ACROSS_CATG_YN\'){\n\t\t\tif(obj.checked==true){\n\t\t\t\tobj.value=\'Y\';\n\t\t\t}else{\n\t\t\t\tobj.value=\'N\';\n\t\t\t}\n\t\t}\n\t\t\n\t\tif (obj.name==\'emergency_transfer_yn\')\t\t\t\n\t\t{\t        \n\t\t\tif (parseInt(document.forms[0].emergency_transfer_cnt.value) > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_DISABLE_OPER_STN\",\"AM\"));\n\t\t\t\tobj.checked=true;\n\t\t\t}\n\t\t\t\n\t\t}\n\n\t}\n}\n\n\n\nfunction chngadmtassign()\n{   \n\t       /*Below line modified for this CRF Bru-HIMS-CRF-261*/\n\t        if(document.forms[0].admit_pat_yn.checked==true)\n\t\t\t\t{  \n\t\t\t\t\tif(document.forms[0].admit_pat_yn.disabled==false)\n\t\t\t\t\tdocument.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled=false;\n\t\t\t\t\tif(document.forms[0].admit_pat_yn.disabled==false)\n\t\t\t\t\tdocument.forms[0].quick_admission_yn.disabled=false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t  if(document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked==true)\n\t\t\t\t\t{\n\t\t\t\t      document.forms[0].ADMIT_PATIENT_WITH_BED_YN.checked=false;\n\t\t\t\t\t}\n\t\t\t\t   document.forms[0].ADMIT_PATIENT_WITH_BED_YN.disabled=true;\n\t\t\t\t   \n\t\t\t\t   if(document.forms[0].quick_admission_yn.checked)\n\t\t\t\t\t{\n\t\t\t\t      document.forms[0].quick_admission_yn.checked=false;\n\t\t\t\t\t  \n\t\t\t\t\t}\n\t\t\t\t\tdocument.forms[0].quick_admission_yn.disabled=true;\n\t\t\t\t\t//else{\n\t\t\t\t     //  document.forms[0].quick_admission_yn.disabled=true;\n\t\t\t\t  // }\n\t\t\t\t}\n\tif(document.forms[0].assign_bed_yn.checked==true)\n\t\t{\n\t\t\tif(document.forms[0].assign_bed_yn.diabled==false)\n\t\t\tdocument.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled=false;\n\t\t}\n\telse\n\t\t{\n\t\t   if(document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.checked==true)\n\t\t\t{\n\t\t   document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.checked=false;\n\t\t\t}\n\t\t   document.forms[0].CHG_NURS_UNIT_IN_ASSIGN_BED_YN.disabled=true;\n\t\t}\n}\n\n   \t</script>\n   \t</head>\n     <body OnMouseDown=\"CodeArrest()\"  onKeyDown = \'lockKey()\' onclick =\"CodeArrest()\" onSelect=\"codeArrestThruSelect();\" >\n\n      ";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="\t\n<form name=\'opstn_detail_form\' id=\'opstn_detail_form\' action=\'../../servlet/eAM.OperatorStationServlet\' method=\'post\' target=\'messageFrame\'>\n\n<a name= \'outpat_act_tab_vw\' id= \'outpat_act_tab_vw\' >\n\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<input type=\'hidden\' name=\'book_appt_yn_cnt\' id=\'book_appt_yn_cnt\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\n<input type=\'hidden\' name=\'create_wait_list_yn_cnt\' id=\'create_wait_list_yn_cnt\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\n<input type=\'hidden\' name=\'modify_wait_list_yn_cnt\' id=\'modify_wait_list_yn_cnt\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\n<input type=\'hidden\' name=\'cancel_wait_list_yn_cnt\' id=\'cancel_wait_list_yn_cnt\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\n\n\n<input type=\'hidden\' name=\'book_appt_wo_pid_yn_cnt\' id=\'book_appt_wo_pid_yn_cnt\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'obook_appt_yn_cnt\' id=\'obook_appt_yn_cnt\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'book_appt_across_catg_yn_cnt\' id=\'book_appt_across_catg_yn_cnt\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'tfr_appt_yn_cnt\' id=\'tfr_appt_yn_cnt\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'tfr_appt_across_catg_yn_cnt\' id=\'tfr_appt_across_catg_yn_cnt\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'canc_appt_yn_cnt\' id=\'canc_appt_yn_cnt\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'register_visit_yn_cnt\' id=\'register_visit_yn_cnt\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\'hidden\' name=\'register_pat_yn_cnt\' id=\'register_pat_yn_cnt\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'cancel_visit_yn_cnt\' id=\'cancel_visit_yn_cnt\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'revise_visit_yn_cnt\' id=\'revise_visit_yn_cnt\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'manage_queue_yn_cnt\' id=\'manage_queue_yn_cnt\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'checkout_pat_yn_cnt\' id=\'checkout_pat_yn_cnt\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=\'hidden\' name=\'CANCEL_CHECKOUT_YN_CNT\' id=\'CANCEL_CHECKOUT_YN_CNT\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\n<input type=\'hidden\' name=\'create_booking_yn_cnt\' id=\'create_booking_yn_cnt\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\'hidden\' name=\'revise_booking_yn_cnt\' id=\'revise_booking_yn_cnt\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'canc_booking_yn_cnt\' id=\'canc_booking_yn_cnt\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\n<input type=\'hidden\' name=\'ADMIT_PATIENT_WITH_BED_YN_CNT\' id=\'ADMIT_PATIENT_WITH_BED_YN_CNT\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\n<input type=\'hidden\' name=\'CHG_NURS_UNIT_IN_ASSIGN_BED_YN_CNT\' id=\'CHG_NURS_UNIT_IN_ASSIGN_BED_YN_CNT\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'> \n\n<input type=\'hidden\' name=\'TRANSFER_OUT_PATIENT_YN_CNT\' id=\'TRANSFER_OUT_PATIENT_YN_CNT\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\n\n<input type=\'hidden\' name=\'SWAP_BED_YN_CNT\' id=\'SWAP_BED_YN_CNT\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'BA_CNT\' id=\'BA_CNT\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'BC_CNT\' id=\'BC_CNT\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\n<input type=\'hidden\' name=\'CRQ_YN_CNT\' id=\'CRQ_YN_CNT\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\n<input type=\'hidden\' name=\'CTO_YN_CNT\' id=\'CTO_YN_CNT\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\n<input type=\'hidden\' name=\'CFQ_YN_CNT\' id=\'CFQ_YN_CNT\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\n<input type=\'hidden\' name=\'DADV_YN_CNT\' id=\'DADV_YN_CNT\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\n<input type=\'hidden\' name=\'PTFR_YN_CNT\' id=\'PTFR_YN_CNT\' value= \'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<!--\n9/16/2008 hidden field for cancelreserve bed for operation restriction start\n\n-->\n<input type=\'hidden\' name=\'CRB__YN_CNT\' id=\'CRB__YN_CNT\' value= \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<!--\n9/16/2008 hidden field for cancelreserve bed for operation restriction end\n\n-->\n\n<input type=\'hidden\' name=\'TRANSFER_IN_PATIENT_YN_CNT\' id=\'TRANSFER_IN_PATIENT_YN_CNT\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\n<input type=\'hidden\' name=\'FORCED_BOOK_APPT_YN_CNT\' id=\'FORCED_BOOK_APPT_YN_CNT\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\n<input type=\'hidden\' name=\'GLOBAL_BOOK_APPT_YN_CNT\' id=\'GLOBAL_BOOK_APPT_YN_CNT\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'GLOBAL_LOCN_APPT_YN_CNT\' id=\'GLOBAL_LOCN_APPT_YN_CNT\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'CREATE_BOOKING_WITH_CONF_YN_CNT\' id=\'CREATE_BOOKING_WITH_CONF_YN_CNT\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\n<input type=\'hidden\' name=\'CONFIRM_BOOKING_YN_CNT\' id=\'CONFIRM_BOOKING_YN_CNT\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\n\n<input type=\'hidden\' name=\'reject_admission_yn_cnt\' id=\'reject_admission_yn_cnt\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\' name=\'admit_pat_yn_cnt\' id=\'admit_pat_yn_cnt\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n<input type=\'hidden\' name=\'register_pat_in_admn_yn_cnt\' id=\'register_pat_in_admn_yn_cnt\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<!--Below line Added for this CRF Bru-HIMS-CRF-261 -->\n <input type=\'hidden\' name=\'quick_admission_yn_cnt\' id=\'quick_admission_yn_cnt\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\n<input type=\'hidden\' name=\'assign_bed_yn_cnt\' id=\'assign_bed_yn_cnt\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\n<input type=\'hidden\' name=\'assign_treat_pract_yn_cnt\' id=\'assign_treat_pract_yn_cnt\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=\'hidden\' name=\'revise_admission_yn_cnt\' id=\'revise_admission_yn_cnt\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n<input type=\'hidden\' name=\'canc_admission_yn_cnt\' id=\'canc_admission_yn_cnt\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n<input type=\'hidden\' name=\'emergency_tfr_yn_cnt\' id=\'emergency_tfr_yn_cnt\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n<input type=\'hidden\' name=\'routine_tfr_yn_cnt\' id=\'routine_tfr_yn_cnt\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n<input type=\'hidden\' name=\'discharge_pat_yn_cnt\' id=\'discharge_pat_yn_cnt\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n<input type=\'hidden\' name=\'revise_leave_yn_cnt\' id=\'revise_leave_yn_cnt\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n<input type=\'hidden\' name=\'check_lodger_yn_cnt\' id=\'check_lodger_yn_cnt\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n<input type=\'hidden\' name=\'block_bed_yn_cnt\' id=\'block_bed_yn_cnt\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n<input type=\'hidden\' name=\'release_bed_yn_cnt\' id=\'release_bed_yn_cnt\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n<input type=\'hidden\' name=\'register_visit_walkin_yn_cnt\' id=\'register_visit_walkin_yn_cnt\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<input type=\'hidden\' name=\'register_visit_referral_yn_cnt\' id=\'register_visit_referral_yn_cnt\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<input type=\'hidden\' name=\'link_baby_to_mother_yn_cnt\' id=\'link_baby_to_mother_yn_cnt\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n<input type=\'hidden\' name=\'reg_newborn_for_ip_yn_cnt\' id=\'reg_newborn_for_ip_yn_cnt\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n<input type=\'hidden\' name=\'discharge_checklist_yn_cnt\' id=\'discharge_checklist_yn_cnt\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n<input type=\'hidden\' name=\'cancel_discharge_yn_cnt\' id=\'cancel_discharge_yn_cnt\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n<input type=\'hidden\' name=\'reserve_bed_bay_yn_cnt\' id=\'reserve_bed_bay_yn_cnt\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n<input type=\'hidden\' name=\'release_bed_bay_yn_cnt\' id=\'release_bed_bay_yn_cnt\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\n<input type=\'hidden\' name=\'dia_proc_recode_for_op_cnt\' id=\'dia_proc_recode_for_op_cnt\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\n<input type=\'hidden\' name=\'reg_ip_referral_yn_cnt\' id=\'reg_ip_referral_yn_cnt\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n<input type=\'hidden\' name=\'conf_bed_ref_yn_cnt\' id=\'conf_bed_ref_yn_cnt\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n<input type=\'hidden\' name=\'dia_proc_recode_for_ip_cnt\' id=\'dia_proc_recode_for_ip_cnt\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\n<input type=\'hidden\' name=\'override_walkin_yn_cnt\' id=\'override_walkin_yn_cnt\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n<input type=\'hidden\' name=\'emergency_transfer_cnt\' id=\'emergency_transfer_cnt\' value= \'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n<input type=\'hidden\' name=\'MAINTAIN_DEATH_REGISTER_YN_CNT\' id=\'MAINTAIN_DEATH_REGISTER_YN_CNT\' value= \'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n<input type=\'hidden\' name=\'CONFIRM_BOOKING_YN_CNT\' id=\'CONFIRM_BOOKING_YN_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'book_appt_yn_cnt\' id=\'book_appt_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'book_appt_wo_pid_yn_cnt\' id=\'book_appt_wo_pid_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'obook_appt_yn_cnt\' id=\'obook_appt_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'book_appt_across_catg_yn_cnt\' id=\'book_appt_across_catg_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'tfr_appt_yn_cnt\' id=\'tfr_appt_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'tfr_appt_across_catg_yn_cnt\' id=\'tfr_appt_across_catg_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'canc_appt_yn_cnt\' id=\'canc_appt_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'register_visit_yn_cnt\' id=\'register_visit_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'register_pat_yn_cnt\' id=\'register_pat_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'cancel_visit_yn_cnt\' id=\'cancel_visit_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'revise_visit_yn_cnt\' id=\'revise_visit_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'manage_queue_yn_cnt\' id=\'manage_queue_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'checkout_pat_yn_cnt\' id=\'checkout_pat_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'CANCEL_CHECKOUT_YN_CNT\' id=\'CANCEL_CHECKOUT_YN_CNT\' value=\'0\'>\n\n\n<input type=\'hidden\' name=\'create_booking_yn_cnt\' id=\'create_booking_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'revise_booking_yn_cnt\' id=\'revise_booking_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'canc_booking_yn_cnt\' id=\'canc_booking_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'reject_admission_yn_cnt\' id=\'reject_admission_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'admit_pat_yn_cnt\' id=\'admit_pat_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'register_pat_in_admn_yn_cnt\' id=\'register_pat_in_admn_yn_cnt\' value=\'0\'>\n\n<!--Below line Added for this CRF Bru-HIMS-CRF- 261-->\n<input type=\'hidden\' name=\'quick_admission_yn_cnt\' id=\'quick_admission_yn_cnt\' value=\'0\'>\n\n<input type=\'hidden\' name=\'assign_bed_yn_cnt\' id=\'assign_bed_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'assign_treat_pract_yn_cnt\' id=\'assign_treat_pract_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'revise_admission_yn_cnt\' id=\'revise_admission_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'canc_admission_yn_cnt\' id=\'canc_admission_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'emergency_tfr_yn_cnt\' id=\'emergency_tfr_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'routine_tfr_yn_cnt\' id=\'routine_tfr_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'discharge_pat_yn_cnt\' id=\'discharge_pat_yn_cnt\' value=\'\'>\n<input type=\'hidden\' name=\'revise_leave_yn_cnt\' id=\'revise_leave_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'check_lodger_yn_cnt\' id=\'check_lodger_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'block_bed_yn_cnt\' id=\'block_bed_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'release_bed_yn_cnt\' id=\'release_bed_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'register_visit_walkin_yn_cnt\' id=\'register_visit_walkin_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'register_visit_referral_yn_cnt\' id=\'register_visit_referral_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'create_wait_list_yn_cnt\' id=\'create_wait_list_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'modify_wait_list_yn_cnt\' id=\'modify_wait_list_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'cancel_wait_list_yn_cnt\' id=\'cancel_wait_list_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'FORCED_BOOK_APPT_YN_CNT\' id=\'FORCED_BOOK_APPT_YN_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'GLOBAL_BOOK_APPT_YN_CNT\' id=\'GLOBAL_BOOK_APPT_YN_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'GLOBAL_LOCN_APPT_YN_CNT\' id=\'GLOBAL_LOCN_APPT_YN_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'TRANSFER_IN_PATIENT_YN_CNT\' id=\'TRANSFER_IN_PATIENT_YN_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'TRANSFER_OUT_PATIENT_YN_CNT\' id=\'TRANSFER_OUT_PATIENT_YN_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'SWAP_BED_YN_CNT\' id=\'SWAP_BED_YN_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'CRQ_YN_CNT\' id=\'CRQ_YN_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'BA_CNT\' id=\'BA_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'BC_CNT\' id=\'BC_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'CTO_YN_CNT\' id=\'CTO_YN_CNT\' value=\'0\'>\n<input type=\'hidden\' name=\'ADMIT_PATIENT_WITH_BED_YN_CNT\' id=\'ADMIT_PATIENT_WITH_BED_YN_CNT\' value=\'0\'>\n\n<input type=\'hidden\' name=\'CFQ_YN_CNT\' id=\'CFQ_YN_CNT\' value=\'0\'>\n\n<input type=\'hidden\' name=\'DADV_YN_CNT\' id=\'DADV_YN_CNT\' value=\'0\'>\n\n<input type=\'hidden\' name=\'PTFR_YN_CNT\' id=\'PTFR_YN_CNT\' value= \'0\'>\n<!--9/16/2008 for CANCEL_RESERVE_BED_YN gives hidden field start\n-->\n<input type=\'hidden\' name=\'CRB__YN_CNT\' id=\'CRB__YN_CNT\' value= \'0\'>\n<!--9/16/2008 for CANCEL_RESERVE_BED_YN gives hidden field start\n-->\n<input type=\'hidden\' name=\'link_baby_to_mother_yn_cnt\' id=\'link_baby_to_mother_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'reg_newborn_for_ip_yn_cnt\' id=\'reg_newborn_for_ip_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'discharge_checklist_yn_cnt\' id=\'discharge_checklist_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'cancel_discharge_yn_cnt\' id=\'cancel_discharge_yn_cnt\'value=\'0\'>\n<input type=\'hidden\' name=\'reserve_bed_bay_yn_cnt\' id=\'reserve_bed_bay_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'release_bed_bay_yn_cnt\' id=\'release_bed_bay_yn_cnt\' value=\'0\'>\n\n<input type=\'hidden\' name=\'dia_proc_recode_for_op_yn\' id=\'dia_proc_recode_for_op_yn\' value=\'0\'>\n\n<input type=\'hidden\' name=\'reg_ip_referral_yn_cnt\' id=\'reg_ip_referral_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'conf_bed_ref_yn_cnt\' id=\'conf_bed_ref_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'dia_proc_recode_for_ip_yn\' id=\'dia_proc_recode_for_ip_yn\' value=\'0\'>\n<input type=\'hidden\' name=\'override_walkin_yn_cnt\' id=\'override_walkin_yn_cnt\' value=\'0\'>\n<input type=\'hidden\' name=\'emergency_transfer_cnt\' id=\'emergency_transfer_cnt\' value= \'0\'>\n<input type=\'hidden\' name=\'MAINTAIN_DEATH_REGISTER_YN_CNT\' id=\'MAINTAIN_DEATH_REGISTER_YN_CNT\' value= \'0\'>\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n </table>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n<a name=\'appointment\' id=\'appointment\'>\n <table name=\'appt_tab_table\' id=\'appt_tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n \n<tr>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\n<TD class = \'QRYODD\'  >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" </TD>\t\t\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"book_appt_yn\" id=\"book_appt_yn\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" onclick=\'chkDetails(this);chk_others(this);\' ></TD>\n\n</tr>\n\n<tr>\n\n\n ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" \n\t\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" </TD>\t\t\n<TD  class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"book_appt_wo_pid_yn\" id=\"book_appt_wo_pid_yn\"  ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" \n\t\n\t\n<TD  class = \'QRYODD\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" </TD>\t\t\n<TD  class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"obook_appt_yn\" id=\"obook_appt_yn\"  ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" onclick=\'chkDetails(this);\'></TD>\n\t\t\t\t\n</tr>\n\n\n\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\t\t\n\n<TD class = \'QRYEVEN\' > ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</TD>\t\t\n<TD  class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"FORCED_BOOK_APPT_YN\" id=\"FORCED_BOOK_APPT_YN\"  ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" onclick=\'chkDetails(this);\' ></TD>\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\t\t\n<TD class = \'QRYODD\' >  ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</TD>\t\t\n<TD  class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"GLOBAL_BOOK_APPT_YN\" id=\"GLOBAL_BOOK_APPT_YN\"  ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" onclick=\'chkDetails(this);\'></TD>\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\n<TD class = \'QRYEVEN\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</TD>\t\t\n<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"tfr_appt_yn\" id=\"tfr_appt_yn\"  ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" onclick=\'chkDetails(this);chk_others(this)\';></TD>\n</tr>\n\n\n\n<tr>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\t\t\n\n<TD  class = \'QRYODD\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" </TD>\t\t\n<TD  class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"canc_appt_yn\" id=\"canc_appt_yn\" onclick=\'chkDetails(this);\' ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="></TD>\n\n\n</tr>\n\n<tr>\n ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n \n<TD  class = \'QRYEVEN\'>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</TD>\t\t\n<TD  class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"create_wait_list_yn\" id=\"create_wait_list_yn\" onclick=\'chkDetails(this);\' ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="></TD>\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\n<TD  class = \'QRYODD\'>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</TD>\n<TD  class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"modify_wait_list_yn\" id=\"modify_wait_list_yn\" onclick=\'chkDetails(this);\' ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="></TD>\n\n</tr>\n\n<tr>\n\n ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\n<TD  class = \'QRYEVEN\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</TD>\n<TD  class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"cancel_wait_list_yn\" id=\"cancel_wait_list_yn\" onclick=\'chkDetails(this);\' ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="></TD>\n\n</tr>\n<tr>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\t\t\n<TD class = \'QRYODD\' >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</TD>\t\t\n<TD  class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"BOOK_APPT_ACROSS_CATG_YN\" id=\"BOOK_APPT_ACROSS_CATG_YN\"  ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" onclick=\'chkDetails(this);\'></TD>\n</tr>\n\n\n</table>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br>\t\n\n<a name=\'visit\' id=\'visit\'></a>\n\n<table name=\'visit_tab_table\' id=\'visit_tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n \n<td class=\'columnheader\' colspan=\'2\'>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\n<tr>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\n<TD class = \'QRYODD\' colspan=\'2\'>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" </TD>\t\t\n<TD  class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"register_visit_yn\" id=\"register_visit_yn\"  ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" onclick=\'chkDetails(this);chk_others(this)\';></TD>\n\n</tr>\n\n<tr>\n\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\n\n<TD class = \'QRYEVEN\' colspan=\'2\'>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</TD>\t\t\n<TD  class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\"   name=\"register_visit_walkin_yn\" id=\"register_visit_walkin_yn\"  ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" onclick=\'chkDetails(this);chk_others(this)\'></TD>\n\n</tr>\n\n\n<tr>\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n<td class=\'QRYODD\' colspan=\'2\'>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"OVERRIDE_WALKIN_YN\" id=\"OVERRIDE_WALKIN_YN\"  ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" onclick=\'chkDetails(this);\' ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="></TD>\n\t\t\n</tr>\n\n<tr>\n\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t<TD class = \'QRYEVEN\' colspan=\'2\'>";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</TD>\t\t\n\t\t<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"register_visit_referral_yn\" id=\"register_visit_referral_yn\"  ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =" onclick=\'chkDetails(this);\'></TD>\n\t\t\t\t\n</tr>\n\n<tr>\n\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\n\t<TD class = \'QRYODD\'colspan=\'2\' >";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =" </TD>\t\t\n\t<TD  class=\'QRYODD\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"register_pat_yn\" id=\"register_pat_yn\"  ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n<td  class=\'QRYEVEN\' colspan=\'2\'> ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</td>\n\t\n<TD  class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"manage_queue_yn\" id=\"manage_queue_yn\"  ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\n<td   class=\'QRYODD\' colspan=\'2\'>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"cancel_visit_yn\" id=\"cancel_visit_yn\"  ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\n<td  class=\'QRYEVEN\' colspan=\'2\'>";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</td>\n<TD  class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"revise_visit_yn\" id=\"revise_visit_yn\"  ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\n<td  class=\'QRYODD\' colspan=\'2\'>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</td>\n\n<TD  class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"checkout_pat_yn\" id=\"checkout_pat_yn\"  ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" onclick=\'chkDetails(this);\' ></TD>\n\n</tr>\n<tr>\n\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\n<TD  class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"CANCEL_CHECKOUT_YN\" id=\"CANCEL_CHECKOUT_YN\"  ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" onclick=\'cancelCheckout(this);chkDetails(this);\' /></TD>\n\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" </TD>\t\t\n<TD  class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"RESERVE_BED_BAY_YN\" id=\"RESERVE_BED_BAY_YN\" ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =" </td>\n<TD  class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"RELEASE_BED_BAY_YN\" id=\"RELEASE_BED_BAY_YN\"  ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =" onclick=\'chkDetails(this);\'></TD>\n\t\t\n</tr>\n\n\n</TABLE>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br>\n\n<a name=\'others1\' id=\'others1\'></a>\n\n<table name=\'others_tab_table\' id=\'others_tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n \n<td class=\'columnheader\' colspan=\'2\'>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\n<tr>\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n<TD class = \'QRYEVEN\'colspan=\'2\'>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</TD>\n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"DIAG_PROC_RECODE_FOR_OP_YN\" id=\"DIAG_PROC_RECODE_FOR_OP_YN\"  ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =" onclick=\'chkDetails(this);\'></TD>\n</tr>\n\n</table>\n\n\n\n\n\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\t\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\n\n<a name=\'inpat_act_tab_vw\' id=\'inpat_act_tab_vw\'>\n\n\n<a name=\'booking\' id=\'booking\' >\n\n<table name=\'booking_tab_table\' id=\'booking_tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</td>\n<tr>\n\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</TD>\t\t\n\t   \n\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="               \n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"create_booking_yn\" id=\"create_booking_yn\"  ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="  onclick=\'chkDetails(this);disencfrm()\'></TD>\n\n</tr>\n\n<tr>\n\n<TD class = \'QRYODD\'>";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</TD>\t\t\n\t\t\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"revise_booking_yn\" id=\"revise_booking_yn\"  ";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n\n<TD class = \'QRYEVEN\'>";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</TD>\t\t\n\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"canc_booking_yn\" id=\"canc_booking_yn\"  ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n\n<TD class = \'QRYODD\'>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\n<TD  class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"CONFIRM_BOOKING_YN\" id=\"CONFIRM_BOOKING_YN\"  ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =" </TD>\n\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="               \n\t\t\n<TD class = \'QRYEVEN\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"CREATE_BOOKING_WITH_CONF_YN\" id=\"CREATE_BOOKING_WITH_CONF_YN\"  ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" onclick=\'chkDetails(this);disencr();\'></TD>\t\n\n</tr>\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br>\n<a name=\'transfer\' id=\'transfer\' >\n\n\n<table name=\'transfer_tab_table\' id=\'transfer_tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\n<TD class = \'QRYEVEN\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"emergency_tfr_yn\" id=\"emergency_tfr_yn\"  ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =" onclick=\'chkDetails(this);\'></TD> \n\n</tr>\n\n<tr>\n\n<TD class = \'QRYODD\' >";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</TD>\t\n\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"routine_tfr_yn\" id=\"routine_tfr_yn\"  ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</TD>\t\t\n\t    ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="               \n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"canc_req_yn\" id=\"canc_req_yn\"  ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =" onclick=\'chkDetails(this);\'></TD>\n\n\n</tr>\n\n<tr>\n\n<TD class = \'QRYODD\' >";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</td>\n\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"cfrm_req_yn\" id=\"cfrm_req_yn\"   ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 =" onclick=\'chkDetails(this);\'></TD>\n</tr>\n\n<tr>\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\t\n\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"TRANSFER_OUT_PATIENT_YN\" id=\"TRANSFER_OUT_PATIENT_YN\"   ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n<TD class = \'QRYODD\'  width=\'auto\' nowrap>";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="               \n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"can_tfr_out_yn\" id=\"can_tfr_out_yn\"  ";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 =" onclick=\'chkDetails(this);\'></TD>\n\n\n</tr>\n\n<tr>\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =" </TD>\t\t\n\t    ";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="               \n\t\t\n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"TRANSFER_IN_PATIENT_YN\" id=\"TRANSFER_IN_PATIENT_YN\"  ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n<TD class = \'QRYODD\' >";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="               \n<TD class = \'QRYODD\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"SWAP_BED_YN\" id=\"SWAP_BED_YN\"  ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 =" onclick=\'chkDetails(this);\'></TD>\n</tr>\n<tr>\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="               \n<TD  class = \'QRYEVEN\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"emergency_transfer_yn\" id=\"emergency_transfer_yn\"  ";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 =" onclick=\'chkDetails(this);\'></TD>\n</tr>\n<tr>\n<TD class = \'QRYODD\' >";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="               \n<TD  class = \'QRYODD\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"pract_tfr_yn\" id=\"pract_tfr_yn\"  ";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 =" onclick=\'chkDetails(this);\'></TD>\n</tr>\n<!--\nNew Row append for CancelReservBeds start 15 -sep-2008\n-->\n<tr>\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="               \n<TD  class = \'QRYEVEN\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"cancel_reBeds_yn\" id=\"cancel_reBeds_yn\"  ";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =" onclick=\'chkDetails(this);\'></TD>\n</tr>\n<!--\nNew Row append for CancelReservBeds end  15 -sep-2008\n-->\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n<a name=\'admission\' id=\'admission\' >\n\n\n\n<table name=\'admission_tab_table\' id=\'admission_tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="               \n<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"admit_pat_yn\" id=\"admit_pat_yn\"  ";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 =" onclick=\'chkDetails(this);chngadmtassign();\'></TD>\n\n</tr>\n<!--Below line Added for this CRF  Bru-HIMS-CRF-261-->\n<tr>\n\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="               \n<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"quick_admission_yn\" id=\"quick_admission_yn\"  ";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 =" onclick=\'chkDetails(this);\' ></TD>\n\n</tr>\n<!--End this CRF Bru-HIMS-CRF-261 -->\n<!--Below line modified for this CRF  Bru-HIMS-CRF-261-->\n<tr>\n\n<TD class = \'QRYODD\'>";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n<TD  class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"ADMIT_PATIENT_WITH_BED_YN\" id=\"ADMIT_PATIENT_WITH_BED_YN\"  ";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n<!--End Bru-HIMS-CRF-261 -->\n<tr>\n\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n<TD class = \'QRYEVEN\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"register_pat_in_admn_yn\" id=\"register_pat_in_admn_yn\"  ";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n\n<TD class = \'QRYODD\' >";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"assign_bed_yn\" id=\"assign_bed_yn\"  ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 =" onclick=\'chkDetails(this);chngadmtassign();\'></TD>\n\n</tr>\n\n<tr>\n\n<td class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</TD>\n\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"CHG_NURS_UNIT_IN_ASSIGN_BED_YN\" id=\"CHG_NURS_UNIT_IN_ASSIGN_BED_YN\"  ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n\n <TD class = \'QRYODD\' >";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"assign_treat_pract_yn\" id=\"assign_treat_pract_yn\"  ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="               \n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"revise_admission_yn\" id=\"revise_admission_yn\"  ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="               \n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"canc_admission_yn\" id=\"canc_admission_yn\"  ";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n\n <TD class = \'QRYEVEN\'  width=\'auto\' nowrap>";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="               \n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"BACKDATED_ADMISSION_YN\" id=\"BACKDATED_ADMISSION_YN\"  ";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</TD>\t\t\n\t\t\n\t   ";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="      \n\t         \n<TD  class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"LINK_BABY_TO_MOTHER_YN\" id=\"LINK_BABY_TO_MOTHER_YN\" ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n\n <TD class = \'QRYEVEN\'>";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</TD>\t\t\n\t ";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="    \n           \n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"REG_NEWBORN_FOR_IP_YN\" id=\"REG_NEWBORN_FOR_IP_YN\"  ";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n<a name=\'discharge\' id=\'discharge\'  >\n\n\n\n<table name=\'discharge_tab_table\' id=\'discharge_tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="</td>\n<tr>\n<TD class = \'QRYEVEN\'>";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="</td>\t\t\n\t\t\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"dchrg_adv_yn\" id=\"dchrg_adv_yn\"  ";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n<TD class = \'QRYODD\'  >";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</TD>\t\n\n";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="               \n<TD class=\'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"discharge_pat_yn\" id=\"discharge_pat_yn\"  ";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="               \n<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"BED_CLASS_CHANGE_YN\" id=\"BED_CLASS_CHANGE_YN\"  ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 =" onclick=\'chkDetails(this);\'></TD>\n</tr>\n\n<tr>\n<TD class = \'QRYODD\' >";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="</TD>\t\t\n\n";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n               \n <TD class=\'QRYODD\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"DISCHARGE_CHECKLIST_YN\" id=\"DISCHARGE_CHECKLIST_YN\"  ";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t onclick=\'chkDetails(this);\'></TD>\n</tr>\n\n<tr>\n<TD class=\'QRYEVEN\'  >";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</TD>\n\n";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\n\t<TD class=\'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"CANCEL_DISCHARGE_YN\" id=\"CANCEL_DISCHARGE_YN\" ";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 =" onClick=\'chkDetails(this);\'></TD>\n\n\t</tr>\n  </table>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n<a name=\'others\' id=\'others\' >\n\n<table name=\'others_tab_table\' id=\'others_tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="</td>\n<tr>\n<TD class = \'QRYEVEN\' >";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="</td>\t\t\n\t    ";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="               \n<TD class = \'QRYEVEN\' ><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"block_bed_yn\" id=\"block_bed_yn\"  ";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="  onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n<tr>\n\n<TD class = \'QRYODD\' >";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t\n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"release_bed_yn\" id=\"release_bed_yn\"  ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="               \n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"revise_leave_yn\" id=\"revise_leave_yn\"  ";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="               \n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"check_lodger_yn\" id=\"check_lodger_yn\"  ";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</td>\t\t\n   ";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="               \n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"REG_IP_REFERRAL_YN\" id=\"REG_IP_REFERRAL_YN\"  ";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</td>\t\t\n\n";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="               \n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"CONFIRM_BEDSIDE_REFERRAL_YN\" id=\"CONFIRM_BEDSIDE_REFERRAL_YN\"  ";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="</td>\t\t\n\n ";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="              \n<TD class = \'QRYEVEN\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"DIAG_PROC_RECODE_FOR_IP_YN\" id=\"DIAG_PROC_RECODE_FOR_IP_YN\"  ";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n<tr>\n\n<TD class = \'QRYODD\'>";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\n<TD class = \'QRYODD\'><INPUT TYPE=\"checkbox\" value=\"Y\" name=\"MAINTAIN_DEATH_REGISTER_YN\" id=\"MAINTAIN_DEATH_REGISTER_YN\"  ";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 =" onclick=\'chkDetails(this);\'></TD>\n\n</tr>\n\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br>\n\n\n\n\n\n";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n\n<input type=\'hidden\' name=\'rule\' id=\'rule\' value=";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 =">\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'\'>\n<input type=\'hidden\' name=\'operstntype\' id=\'operstntype\' value=\'\'>\n<input type=\'hidden\' name=\'short_desc\' id=\'short_desc\' value=\'\'>\n<input type=\'hidden\' name=\'long_desc\' id=\'long_desc\' value=\'\'>\n<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'\'>\n<input type=\'hidden\' name=\'ws_no\' id=\'ws_no\' value=\'\'>\n<input type=\'hidden\' name=\'eff_status\' id=\'eff_status\' value=\'";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\' >\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" >\n\n";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);


		 String oper_stn_id="";
		 
		 String operstntype="";
		 String disabled="";
		 String book_appt_chk="";
		 String trans_appt_chk="";
		 String register_chk="";
		 String override_dis="";
		 
		 String admit_chk="";//this line Added for this CRF Bru-HIMS-CRF-261
	
		
			
		
		 
   	 	 String rule="";
   	 	String chk = ""; 
   	 	String dis = ""; 
   	 	String chkCancel = ""; 

		 oper_stn_id=request.getParameter("oper_stn_id");
		 if(oper_stn_id==null) oper_stn_id="";
		String facilityId=request.getParameter("facility_id");
		 if(facilityId ==null) facilityId="";
		
		 operstntype=request.getParameter("oper_stn_type");

	
		

		
	 	 Connection conn = null;
	 

		 String recordexists = "N";

		 String eff_status = request.getParameter("eff_status");
			if(eff_status == null) eff_status="";
		
		 ResultSet rs= null;
		 ResultSet rset=null;
		 Statement stmt = null;
		 PreparedStatement pstmt = null;


try{
	conn = ConnectionManager.getConnection(request);
	stmt=conn.createStatement();
	if(!oper_stn_id.equals(""))
	{
		   /*Below query Modified for this CRF Br-HIMS-CRF-261*/
			
			String sql ="select facility_id,oper_stn_id,long_desc,short_desc,nurs_unit_code "+
						" ,shift_operated_yn,shift_group,ws_no,eff_status "+
						" ,nvl(book_appt_yn,'N') book_appt_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and book_appt_yn ='Y') book_appt_yn_cnt "+
						" ,nvl(create_wait_list_yn,'N') create_wait_list_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and create_wait_list_yn ='Y') create_wait_list_yn_cnt "+
                       " , nvl(cancel_wait_list_yn,'N') cancel_wait_list_yn, nvl(modify_wait_list_yn,'N') modify_wait_list_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and modify_wait_list_yn ='Y') modify_wait_list_yn_cnt, "+
						" (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CANCEL_WAIT_LIST_YN ='Y') cancel_wait_list_yn_cnt "+
						" ,nvl(book_appt_wo_pid_yn,'N') book_appt_wo_pid_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and book_appt_wo_pid_yn ='Y') book_appt_wo_pid_yn_cnt,  nvl(obook_appt_yn,'N') obook_appt_yn, (SELECT COUNT(1) FROM   AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and obook_appt_yn ='Y') obook_appt_yn_cnt, nvl(book_appt_across_catg_yn ,'N') book_appt_across_catg_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and book_appt_across_catg_yn ='Y') book_appt_across_catg_yn_cnt,nvl(FORCED_BOOK_APPT_YN ,'N') FORCED_BOOK_APPT_YN "+",(SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and FORCED_BOOK_APPT_YN ='Y') FORCED_BOOK_CNT,nvl(CONFIRM_BOOKING_YN ,'N') CONFIRM_BOOKING "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CONFIRM_BOOKING_YN ='Y') CON_CNT,nvl(CREATE_BOOKING_WITH_CONF_YN ,'N') CR_B_WH_C_YN "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CREATE_BOOKING_WITH_CONF_YN ='Y') CR_B_WH_C_CNT,  nvl(GLOBAL_BOOK_APPT_YN ,'N') GLOBAL_BOOK_APPT_YN "+
						" , (SELECT COUNT (1) FROM am_restrn_for_oper_stn a WHERE a.facility_id = ?   AND a.oper_stn_id = ? AND a.global_book_appt_yn = 'Y') GLOBAL_BOOK_CNT, (SELECT COUNT (1) FROM am_locn_for_oper_stn b WHERE b.facility_id = ? AND b.oper_stn_id = ? AND b.global_locn_yn = 'Y') GLOBAL_LOCN_CNT, nvl(tfr_appt_yn,'N') tfr_appt_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and tfr_appt_yn ='Y') tfr_appt_yn_cnt, nvl(tfr_appt_across_catg_yn,'N') tfr_appt_across_catg_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and tfr_appt_across_catg_yn ='Y') tfr_appt_across_catg_yn_cnt, nvl(canc_appt_yn,'N') canc_appt_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and canc_appt_yn ='Y') canc_appt_yn_cnt, nvl(register_visit_yn ,'N') register_visit_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_visit_yn ='Y') register_visit_yn_cnt, nvl(register_pat_yn,'N') register_pat_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_pat_yn ='Y') register_pat_yn_cnt, nvl(cancel_visit_yn,'N') cancel_visit_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  cancel_visit_yn ='Y')  cancel_visit_yn_cnt, nvl(revise_visit_yn,'N') revise_visit_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and revise_visit_yn ='Y') revise_visit_yn_cnt, nvl(manage_queue_yn ,'N') manage_queue_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and manage_queue_yn ='Y') manage_queue_yn_cnt, nvl(checkout_pat_yn,'N') checkout_pat_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and checkout_pat_yn ='Y') checkout_pat_yn_cnt, oper_stn_type,nvl(create_booking_yn,'N') create_booking_yn, "+
						"(SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and create_booking_yn ='Y') create_booking_yn_cnt, nvl(revise_booking_yn ,'N') revise_booking_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and revise_booking_yn ='Y') revise_booking_yn_cnt, nvl(canc_booking_yn,'N') canc_booking_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and canc_booking_yn ='Y') canc_booking_yn_cnt, nvl(ADMIT_PATIENT_WITH_BED_YN,'N') ADMIT_PATIENT_WITH_BED_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and ADMIT_PATIENT_WITH_BED_YN ='Y') ADMIT_PATIENT_CNT, nvl(CHG_NURS_UNIT_IN_ASSIGN_BED_YN,'N') CHG_NURS_UNIT_IN_ASSIGN_BED_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CHG_NURS_UNIT_IN_ASSIGN_BED_YN ='Y') CHG_NURS_UNIT_IN_CNT, nvl(TRANSFER_OUT_PATIENT_YN,'N') TRANSFER_OUT_PATIENT_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and TRANSFER_OUT_PATIENT_YN ='Y') TRANSFER_OUT_CNT,	nvl(TRANSFER_IN_PATIENT_YN,'N') TRANSFER_IN_PATIENT_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and TRANSFER_IN_PATIENT_YN ='Y') TRANSFER_IN_CNT,	 nvl(SWAP_BED_YN,'N') SWAP_BED_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and SWAP_BED_YN ='Y') SWAP_CNT,nvl(BACKDATED_ADMISSION_YN,'N') BACKDATED_ADMISSION_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and BACKDATED_ADMISSION_YN ='Y') BA_CNT,nvl(BED_CLASS_CHANGE_YN,'N') BED_CLASS_CHANGE_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and BED_CLASS_CHANGE_YN ='Y') BC_CNT,nvl(CANCEL_REQUEST_YN,'N') canc_req_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CANCEL_REQUEST_YN ='Y') CRQ_CNT,nvl(CANCEL_TRANSFER_OUT_YN,'N')can_tfr_out_yn , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CANCEL_TRANSFER_OUT_YN ='Y') CTO_CNT,nvl(PRACT_TRANSFER_YN,'N') pract_tfr_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and PRACT_TRANSFER_YN ='Y') PTFR_CNT,nvl(CONFIRM_REQUEST_YN,'N') cfrm_req_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and CONFIRM_REQUEST_YN ='Y') CFQ_CNT,nvl(DISCHARGE_ADVICE_YN,'N') DCHRG_ADV_YN, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and DISCHARGE_ADVICE_YN ='Y') DADV_CNT, nvl(reject_admission_yn,'N') reject_admission_yn, (SELECT COUNT(1) FROM 		 AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and reject_admission_yn ='Y') reject_admission_yn_cnt, nvl(admit_pat_yn,'N') admit_pat_yn,  (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and admit_pat_yn ='Y') admit_pat_yn_cnt,nvl(quick_admission_yn,'N') quick_admission_yn,  (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and quick_admission_yn ='Y') quick_admission_yn_cnt, nvl(register_pat_in_admn_yn,'N') register_pat_in_admn_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_pat_in_admn_yn ='Y') register_pat_in_admn_yn_cnt, nvl(assign_bed_yn ,'N') assign_bed_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and assign_bed_yn ='Y') assign_bed_yn_cnt, nvl(assign_treat_pract_yn,'N') assign_treat_pract_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and assign_treat_pract_yn ='Y') assign_treat_pract_yn_cnt, nvl(revise_admission_yn,'N') revise_admission_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and revise_admission_yn ='Y') revise_admission_yn_cnt, nvl(canc_admission_yn,'N') canc_admission_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and canc_admission_yn ='Y') canc_admission_yn_cnt, nvl(emergency_tfr_yn,'N') emergency_tfr_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and emergency_tfr_yn ='Y') emergency_tfr_yn_cnt, nvl(routine_tfr_yn ,'N') routine_tfr_yn "+
						" , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and routine_tfr_yn ='Y') routine_tfr_yn_cnt, nvl(discharge_pat_yn,'N') discharge_pat_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and discharge_pat_yn ='Y') discharge_pat_yn_cnt, nvl(revise_leave_yn,'N')revise_leave_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and revise_leave_yn ='Y') revise_leave_yn_cnt, nvl(check_lodger_yn,'N')  check_lodger_yn,  (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and check_lodger_yn ='Y') check_lodger_yn_cnt, nvl(block_bed_yn,'N') block_bed_yn,  (SELECT COUNT(1) FROM   AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and block_bed_yn ='Y') block_bed_yn_cnt, "+
						" nvl(release_bed_yn,'N') release_bed_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and release_bed_yn ='Y') release_bed_yn_cnt,"+"nvl(DIAG_PROC_RECODE_FOR_OP_YN,'N') DIAG_PROC_RECODE_FOR_OP_YN, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and DIAG_PROC_RECODE_FOR_OP_YN ='Y') dia_proc_recode_for_op_cnt , nvl(register_visit_walkin_yn,'N') register_visit_walkin_yn , (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_visit_walkin_yn ='Y') register_visit_walkin_yn_cnt,nvl(register_visit_referral_yn,'N') register_visit_referral_yn, (SELECT COUNT(1) FROM AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and register_visit_referral_yn ='Y')register_visit_referral_yn_cnt ,nvl(LINK_BABY_TO_MOTHER_YN,'N') link_baby_to_mother_yn, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  LINK_BABY_TO_MOTHER_YN ='Y')  link_baby_to_mother_yn_cnt ,nvl(REG_NEWBORN_FOR_IP_YN,'N') reg_newborn_for_ip_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  REG_NEWBORN_FOR_IP_YN   ='Y')  reg_newborn_for_ip_yn_cnt,nvl(DISCHARGE_CHECKLIST_YN,'N') discharge_checklist_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  DISCHARGE_CHECKLIST_YN ='Y')  discharge_checklist_yn_cnt,nvl(CANCEL_DISCHARGE_YN,'N') CANCEL_DISCHARGE_YN,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  CANCEL_DISCHARGE_YN ='Y')  CANCEL_DISCHARGE_YN_CNT,nvl(RESERVE_BED_BAY_YN,'N') reserve_bed_bay_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  RESERVE_BED_BAY_YN ='Y')  reserve_bed_bay_yn_cnt,nvl(RELEASE_BED_BAY_YN,'N') release_bed_bay_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  RELEASE_BED_BAY_YN ='Y')  release_bed_bay_yn_cnt,nvl(REG_IP_REFERRAL_YN,'N') reg_ip_referral_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  REG_IP_REFERRAL_YN ='Y')  reg_ip_referral_yn_cnt,nvl(CONFIRM_BEDSIDE_REFERRAL_YN,'N') confirm_bedside_referral_yn,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  CONFIRM_BEDSIDE_REFERRAL_YN ='Y')  conf_bed_ref_yn_cnt,nvl(DIAG_PROC_RECODE_FOR_IP_YN,'N') DIAG_PROC_RECODE_FOR_IP_YN,(SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  DIAG_PROC_RECODE_FOR_IP_YN ='Y') dia_proc_recode_for_ip_cnt, nvl(OVERRIDE_WALKIN_YN,'N') OVERRIDE_WALKIN_YN, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  OVERRIDE_WALKIN_YN ='Y')  override_walkin_yn_cnt,nvl(CANCEL_CHECKOUT_YN,'N') CANCEL_CHECKOUT_YN, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  CANCEL_CHECKOUT_YN ='Y')  CANCEL_CHECKOUT_YN_CNT "+",nvl(CANCEL_RESERVE_BED_YN,'N') cancel_reserve_bed, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  CANCEL_RESERVE_BED_YN ='Y')  CANCEL_RESERVE_BED_YN "+",nvl(EMERGENCY_TRANSFER_YN,'N') emergency_transfer, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  EMERGENCY_TRANSFER_YN ='Y')  EMERGENCY_TRANSFER_YN_CNT "+" ,nvl(MAINTAIN_DEATH_REGISTER_YN,'N') MAINTAIN_DEATH_REGISTER_YN, (SELECT COUNT(1) FROM  AM_RESTRN_FOR_OPER_STN WHERE  facility_id = ? AND oper_stn_id = ? and  MAINTAIN_DEATH_REGISTER_YN ='Y')  MAINTAIN_DEATH_REGISTER_YN_CNT "+"  	from am_oper_stn  "+" where facility_id = ? and oper_stn_id=? ";
						
						
				//rset = stmt.executeQuery(sql);
				
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	facilityId		);
				pstmt.setString	(	2,	oper_stn_id		);
				pstmt.setString	(	3,	facilityId		);
				pstmt.setString	(	4,	oper_stn_id		);
				pstmt.setString	(	5,	facilityId		);
				pstmt.setString	(	6,	oper_stn_id		);
				pstmt.setString	(	7,	facilityId		);
				pstmt.setString	(	8,	oper_stn_id		);
				pstmt.setString	(	9,	facilityId		);
				pstmt.setString	(	10,	oper_stn_id		);
				pstmt.setString	(	11,	facilityId		);
				pstmt.setString	(	12,	oper_stn_id		);
				pstmt.setString	(	13,	facilityId		);
				pstmt.setString	(	14,	oper_stn_id		);
				pstmt.setString	(	15,	facilityId		);
				pstmt.setString	(	16,	oper_stn_id		);
				pstmt.setString	(	17,	facilityId		);
				pstmt.setString	(	18,	oper_stn_id		);
				pstmt.setString	(	19,	facilityId		);
				pstmt.setString	(	20,	oper_stn_id		);
				pstmt.setString	(	21,	facilityId		);
				pstmt.setString	(	22,	oper_stn_id		);
				pstmt.setString	(	23,	facilityId		);
				pstmt.setString	(	24,	oper_stn_id		);
				pstmt.setString	(	25,	facilityId		);
				pstmt.setString	(	26,	oper_stn_id		);
				pstmt.setString	(	27,	facilityId		);
				pstmt.setString	(	28,	oper_stn_id		);
				pstmt.setString	(	29,	facilityId		);
				pstmt.setString	(	30,	oper_stn_id		);
				pstmt.setString	(	31,	facilityId		);
				pstmt.setString	(	32,	oper_stn_id		);
				pstmt.setString	(	33,	facilityId		);
				pstmt.setString	(	34,	oper_stn_id		);
				pstmt.setString	(	35,	facilityId		);
				pstmt.setString	(	36,	oper_stn_id		);
				pstmt.setString	(	37,	facilityId		);
				pstmt.setString	(	38,	oper_stn_id		);
				pstmt.setString	(	39,	facilityId		);
				pstmt.setString	(	40,	oper_stn_id		);
				pstmt.setString	(	41,	facilityId		);
				pstmt.setString	(	42,	oper_stn_id		);
				pstmt.setString	(	43,	facilityId		);
				pstmt.setString	(	44,	oper_stn_id		);
				pstmt.setString	(	45,	facilityId		);
				pstmt.setString	(	46,	oper_stn_id		);
				pstmt.setString	(	47,	facilityId		);
				pstmt.setString	(	48,	oper_stn_id		);
				pstmt.setString	(	49,	facilityId		);
				pstmt.setString	(	50,	oper_stn_id		);
				pstmt.setString	(	51,	facilityId		);
				pstmt.setString	(	52,	oper_stn_id		);
				pstmt.setString	(	53,	facilityId		);
				pstmt.setString	(	54,	oper_stn_id		);
				pstmt.setString	(	55,	facilityId		);
				pstmt.setString	(	56,	oper_stn_id		);
				pstmt.setString	(	57,	facilityId		);
				pstmt.setString	(	58,	oper_stn_id		);
				pstmt.setString	(	59,	facilityId		);
				pstmt.setString	(	60,	oper_stn_id		);
				pstmt.setString	(	61,	facilityId		);
				pstmt.setString	(	62,	oper_stn_id		);
				pstmt.setString	(	63,	facilityId		);
				pstmt.setString	(	64,	oper_stn_id		);
				pstmt.setString	(	65,	facilityId		);
				pstmt.setString	(	66,	oper_stn_id		);
				pstmt.setString	(	67,	facilityId		);
				pstmt.setString	(	68,	oper_stn_id		);
				pstmt.setString	(	69,	facilityId		);
				pstmt.setString	(	70,	oper_stn_id		);
				pstmt.setString	(	71,	facilityId		);
				pstmt.setString	(	72,	oper_stn_id		);
				pstmt.setString	(	73,	facilityId		);
				pstmt.setString	(	74,	oper_stn_id		);
				pstmt.setString	(	75,	facilityId		);
				pstmt.setString	(	76,	oper_stn_id		);
				pstmt.setString	(	77,	facilityId		);
				pstmt.setString	(	78,	oper_stn_id		);
				pstmt.setString	(	79,	facilityId		);
				pstmt.setString	(	80,	oper_stn_id		);
				pstmt.setString	(	81,	facilityId		);
				pstmt.setString	(	82,	oper_stn_id		);
				pstmt.setString	(	83,	facilityId		);
				pstmt.setString	(	84,	oper_stn_id		);
				pstmt.setString	(	85,	facilityId		);
				pstmt.setString	(	86,	oper_stn_id		);
				pstmt.setString	(	87,	facilityId		);
				pstmt.setString	(	88,	oper_stn_id		);
				pstmt.setString	(	89,	facilityId		);
				pstmt.setString	(	90,	oper_stn_id		);
				pstmt.setString	(	91,	facilityId		);
				pstmt.setString	(	92,	oper_stn_id		);
				pstmt.setString	(	93,	facilityId		);
				pstmt.setString	(	94,	oper_stn_id		);
				pstmt.setString	(	95,	facilityId		);
				pstmt.setString	(	96,	oper_stn_id		);
				pstmt.setString	(	97,	facilityId		);
				pstmt.setString	(	98,	oper_stn_id		);
				pstmt.setString	(	99,	facilityId		);
				pstmt.setString	(	100,	oper_stn_id		);
				pstmt.setString	(	101,	facilityId		);
				pstmt.setString	(	102,	oper_stn_id		);
				pstmt.setString	(	103,	facilityId		);
				pstmt.setString	(	104,	oper_stn_id		);
				pstmt.setString	(	105,	facilityId		);
				pstmt.setString	(	106,	oper_stn_id		);
				pstmt.setString	(	107,	facilityId		);
				pstmt.setString	(	108,	oper_stn_id		);
				pstmt.setString	(	109,	facilityId		);
				pstmt.setString	(	110,	oper_stn_id		);
				pstmt.setString	(	111,	facilityId		);
				pstmt.setString	(	112,	oper_stn_id		);
				pstmt.setString	(	113,	facilityId		);
				pstmt.setString	(	114,	oper_stn_id		);
				pstmt.setString	(	115,	facilityId		);
				pstmt.setString	(	116,	oper_stn_id		);
				pstmt.setString	(	117,	facilityId		);
				pstmt.setString	(	118,	oper_stn_id		);
				pstmt.setString	(	119,	facilityId		);
				pstmt.setString	(	120,	oper_stn_id		);
				pstmt.setString	(	121,	facilityId		);
				pstmt.setString	(	122,	oper_stn_id		);
				pstmt.setString	(	123,	facilityId		);
				pstmt.setString	(	124,	oper_stn_id		);
				pstmt.setString	(	125,	facilityId		);
				pstmt.setString	(	126,	oper_stn_id		);
				pstmt.setString	(	127,	facilityId		);
				pstmt.setString	(	128,	oper_stn_id		);
				pstmt.setString	(	129,	facilityId		);
				pstmt.setString	(	130,	oper_stn_id		);
				pstmt.setString	(	131,	facilityId		);
				pstmt.setString	(	132,	oper_stn_id		);
				pstmt.setString	(	133,	facilityId		);
				pstmt.setString	(	134,	oper_stn_id		);
				pstmt.setString	(	135,	facilityId		);
				pstmt.setString	(	136,	oper_stn_id		);
				pstmt.setString	(	137,	facilityId		);
				pstmt.setString	(	138,	oper_stn_id		);
				rset		 = pstmt.executeQuery();
				

				if(rset !=null && rset.next())
				{
					recordexists = "Y";
					//operationtype = "modify";
					eff_status = rset.getString("eff_status");				
					
				}
				
		}

            _bw.write(_wl_block7Bytes, _wl_block7);
if(recordexists.equals("Y")) { 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rset.getString("book_appt_yn_cnt")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rset.getString("create_wait_list_yn_cnt")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rset.getString("modify_wait_list_yn_cnt")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rset.getString("cancel_wait_list_yn_cnt")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rset.getString("book_appt_wo_pid_yn_cnt")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString("obook_appt_yn_cnt")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rset.getString("book_appt_across_catg_yn_cnt")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rset.getString("tfr_appt_yn_cnt")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rset.getString("tfr_appt_across_catg_yn_cnt")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rset.getString("canc_appt_yn_cnt")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rset.getString("register_visit_yn_cnt")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rset.getString("register_pat_yn_cnt")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rset.getString("cancel_visit_yn_cnt")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rset.getString("revise_visit_yn_cnt")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rset.getString("manage_queue_yn_cnt")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rset.getString("checkout_pat_yn_cnt")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rset.getString("CANCEL_CHECKOUT_YN_CNT")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rset.getString("create_booking_yn_cnt")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rset.getString("revise_booking_yn_cnt")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rset.getString("canc_booking_yn_cnt")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rset.getString("ADMIT_PATIENT_CNT")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rset.getString("CHG_NURS_UNIT_IN_CNT")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rset.getString("TRANSFER_OUT_CNT")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rset.getString("SWAP_CNT")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rset.getString("BA_CNT")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rset.getString("BC_CNT")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rset.getString("CRQ_CNT")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rset.getString("CTO_CNT")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rset.getString("CFQ_CNT")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rset.getString("DADV_CNT")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rset.getString("PTFR_CNT")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rset.getString("CANCEL_RESERVE_BED_YN")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rset.getString("TRANSFER_IN_CNT")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rset.getString("FORCED_BOOK_CNT")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rset.getString("GLOBAL_BOOK_CNT")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rset.getString("GLOBAL_LOCN_CNT")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rset.getString("CR_B_WH_C_CNT")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rset.getString("CON_CNT")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(rset.getString("reject_admission_yn_cnt")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rset.getString("admit_pat_yn_cnt")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rset.getString("register_pat_in_admn_yn_cnt")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rset.getString("quick_admission_yn_cnt")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rset.getString("assign_bed_yn_cnt")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rset.getString("assign_treat_pract_yn_cnt")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(rset.getString("revise_admission_yn_cnt")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rset.getString("canc_admission_yn_cnt")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rset.getString("emergency_tfr_yn_cnt")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rset.getString("routine_tfr_yn_cnt")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(rset.getString("discharge_pat_yn_cnt")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(rset.getString("revise_leave_yn_cnt")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rset.getString("check_lodger_yn_cnt")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rset.getString("block_bed_yn_cnt")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(rset.getString("release_bed_yn_cnt")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rset.getString("register_visit_walkin_yn_cnt")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rset.getString("register_visit_referral_yn_cnt")));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rset.getString("link_baby_to_mother_yn_cnt")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rset.getString("reg_newborn_for_ip_yn_cnt")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rset.getString("discharge_checklist_yn_cnt")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rset.getString("CANCEL_DISCHARGE_YN_CNT")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rset.getString("reserve_bed_bay_yn_cnt")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rset.getString("release_bed_bay_yn_cnt")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rset.getString("dia_proc_recode_for_op_cnt")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rset.getString("reg_ip_referral_yn_cnt")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rset.getString("conf_bed_ref_yn_cnt")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rset.getString("dia_proc_recode_for_ip_cnt")));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(rset.getString("override_walkin_yn_cnt")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(rset.getString("EMERGENCY_TRANSFER_YN_CNT")));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(rset.getString("MAINTAIN_DEATH_REGISTER_YN_CNT")));
            _bw.write(_wl_block76Bytes, _wl_block76);

	
}
else
{
	

            _bw.write(_wl_block77Bytes, _wl_block77);
	}
	
            _bw.write(_wl_block78Bytes, _wl_block78);
if(!operstntype.equals("I")) {
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
if(recordexists.equals("Y")) { if(rset.getString("book_appt_yn").equals("Y")){ chk=" checked ";}else{ chk=""; book_appt_chk="disabled";}}
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block84Bytes, _wl_block84);
if(recordexists.equals("Y")){ if(rset.getString("book_appt_wo_pid_yn").equals("Y")){ chk=" checked "; disabled="";}else{chk="";disabled=book_appt_chk;}
     }
     else{
     disabled="disabled";
	 }
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block88Bytes, _wl_block88);
if(recordexists.equals("Y")){ if(rset.getString("obook_appt_yn").equals("Y")){ chk=" checked "; disabled="";}else{chk="";disabled=book_appt_chk;}
     }
     else{
     disabled="disabled";
	 }
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block91Bytes, _wl_block91);
if(recordexists.equals("Y")) { if(rset.getString("FORCED_BOOK_APPT_YN").equals("Y")) chk="checked"; else chk=""; }
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block94Bytes, _wl_block94);
if(recordexists.equals("Y")) { if(rset.getString("GLOBAL_BOOK_APPT_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block97Bytes, _wl_block97);
if(recordexists.equals("Y")) { if(rset.getString("tfr_appt_yn").equals("Y")){ chk=" checked ";}else{chk="";  trans_appt_chk="disabled";} }
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block100Bytes, _wl_block100);
if(recordexists.equals("Y")) { if(rset.getString("canc_appt_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block103Bytes, _wl_block103);
if(recordexists.equals("Y")) { if(rset.getString("create_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block106Bytes, _wl_block106);
if(recordexists.equals("Y")) { if(rset.getString("modify_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block109Bytes, _wl_block109);
if(recordexists.equals("Y")) { if(rset.getString("cancel_wait_list_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block112Bytes, _wl_block112);
if(recordexists.equals("Y")) { if(rset.getString("BOOK_APPT_ACROSS_CATG_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
if(recordexists.equals("Y")) { if(rset.getString("register_visit_yn").equals("Y")) 			{chk=" checked "; }else{ chk=""; register_chk="disabled";}}
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block119Bytes, _wl_block119);
if(recordexists.equals("Y")) { if(rset.getString("register_visit_walkin_yn").equals("Y")){ chk=" checked ";override_dis="";}else{ chk=""; disabled=register_chk;override_dis="disabled";}}
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block122Bytes, _wl_block122);
if(recordexists.equals("Y")) { if(rset.getString("OVERRIDE_WALKIN_YN").equals("Y")){ chk=" checked ";} else{ chk=""; disabled=override_dis;}}
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block126Bytes, _wl_block126);
if(recordexists.equals("Y")) { if(rset.getString("register_visit_referral_yn").equals("Y")){ chk=" checked ";}else{ chk=""; disabled=register_chk;}}
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block129Bytes, _wl_block129);
if(recordexists.equals("Y")) { if(rset.getString("register_pat_yn").equals("Y")){ chk=" checked ";}else{ chk=""; disabled=register_chk;}}
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block132Bytes, _wl_block132);
if(recordexists.equals("Y")) { if(rset.getString("manage_queue_yn").equals("Y")) chk=" checked "; else chk=""; }
		
		
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block135Bytes, _wl_block135);
if(recordexists.equals("Y")) { if(rset.getString("cancel_visit_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block135Bytes, _wl_block135);
if(recordexists.equals("Y")) { if(rset.getString("revise_visit_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block132Bytes, _wl_block132);
if(recordexists.equals("Y")) { if(rset.getString("checkout_pat_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block142Bytes, _wl_block142);
if(recordexists.equals("Y")) { if(rset.getString("CANCEL_CHECKOUT_YN").equals("Y")) chkCancel=" checked "; else chkCancel=""; }
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(chkCancel));
            _bw.write(_wl_block144Bytes, _wl_block144);
if(recordexists.equals("Y")) { if(rset.getString("RESERVE_BED_BAY_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block135Bytes, _wl_block135);
if(recordexists.equals("Y")) { if(rset.getString("RELEASE_BED_BAY_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
if(recordexists.equals("Y")) { if(rset.getString("DIAG_PROC_RECODE_FOR_OP_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block151Bytes, _wl_block151);
}
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
if(recordexists.equals("Y")) { if(rset.getString("create_booking_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);
if(recordexists.equals("Y")) { if(rset.getString("revise_booking_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("canc_booking_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_BOOKING").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
if(recordexists.equals("Y")) { if(rset.getString("CR_B_WH_C_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block166Bytes, _wl_block166);
if(recordexists.equals("Y")) { if(rset.getString("create_booking_yn").equals("Y")) dis=" disabled "; else dis=""; }
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("emergency_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);
if(recordexists.equals("Y")) { if(rset.getString("routine_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("canc_req_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);
if(recordexists.equals("Y")) { if(rset.getString("cfrm_req_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
if(recordexists.equals("Y")) { if(rset.getString("TRANSFER_OUT_PATIENT_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("can_tfr_out_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);
if(recordexists.equals("Y")) { if(rset.getString("TRANSFER_IN_PATIENT_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block186Bytes, _wl_block186);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("SWAP_BED_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("emergency_transfer").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("pract_tfr_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("cancel_reserve_bed").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("admit_pat_yn").equals("Y")) {chk=" checked ";}else{ chk=""; admit_chk="disabled";}} 
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("quick_admission_yn").equals("Y")){chk=" checked "; disabled="";}else{chk="";disabled=admit_chk;}
     }
     else{
     disabled="disabled";
	 }
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("ADMIT_PATIENT_WITH_BED_YN").equals("Y")) {chk=" checked "; disabled="";}else{chk="";disabled=admit_chk;}
     }
     else{
     disabled="disabled";
	 }
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("register_pat_in_admn_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("assign_bed_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
if(recordexists.equals("Y")) { if(rset.getString("CHG_NURS_UNIT_IN_ASSIGN_BED_YN").equals("Y"))
			chk=" checked "; else chk=""; }
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("assign_treat_pract_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("revise_admission_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("canc_admission_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block211Bytes, _wl_block211);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
if(recordexists.equals("Y")) { if(rset.getString("BACKDATED_ADMISSION_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
if(recordexists.equals("Y")) { if(rset.getString("link_baby_to_mother_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);
if(recordexists.equals("Y")) { if(rset.getString("reg_newborn_for_ip_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);
if(recordexists.equals("Y")) { if(rset.getString("dchrg_adv_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
if(recordexists.equals("Y")) { if(rset.getString("discharge_pat_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
if(recordexists.equals("Y")) { if(rset.getString("BED_CLASS_CHANGE_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block227Bytes, _wl_block227);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block228Bytes, _wl_block228);
if(recordexists.equals("Y")) { if(rset.getString("DISCHARGE_CHECKLIST_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);
	if(recordexists.equals("Y")) 
	{ 
		if(rset.getString("cancel_discharge_yn").equals("Y"))
			chk=" checked "; 
		else 
			chk=""; 
	}	
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block233Bytes, _wl_block233);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);
if(recordexists.equals("Y")) { if(rset.getString("block_bed_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
if(recordexists.equals("Y")) { if(rset.getString("release_bed_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);
if(recordexists.equals("Y")) { if(rset.getString("revise_leave_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);
if(recordexists.equals("Y")) { if(rset.getString("check_lodger_yn").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);
if(recordexists.equals("Y")) { if(rset.getString("REG_IP_REFERRAL_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);
if(recordexists.equals("Y")) { if(rset.getString("CONFIRM_BEDSIDE_REFERRAL_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);
if(recordexists.equals("Y")) { if(rset.getString("DIAG_PROC_RECODE_FOR_IP_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block247Bytes, _wl_block247);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);
if(recordexists.equals("Y")) { if(rset.getString("MAINTAIN_DEATH_REGISTER_YN").equals("Y")) chk=" checked "; else chk=""; }
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block249Bytes, _wl_block249);


}
   catch(Exception e){
	out.println(e);
	e.printStackTrace();
}
finally
{
	try
	{
	if (rset!= null) rset.close();
	if (stmt != null) stmt.close();
	if (rs != null) rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(conn,request);

}

            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(rule));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block253Bytes, _wl_block253);

	if(eff_status.equals("D"))
	{
	out.println("<script>");
	out.println("for(j=0;j<document.forms[0].elements.length;j++) document.forms[0].elements[j].disabled=true;");
	out.println("</script>");
	
	}

            _bw.write(_wl_block254Bytes, _wl_block254);
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.OverrideAllocationRuleforBookAppointment.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegisterVisit.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterWalkIn.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.OverrideWalkIn.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterReferral.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterPatientfromRegisterVisit.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ManageQueue.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.CancelVisit.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReviseVisit.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.CheckoutPatient.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelCheckout.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ReserveBedBay.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ReleaseBedBay.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisProcedureRecode.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferPatient.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestforTransfer.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelRequest.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ConfirmRequest.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferOut.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.CancelTransferOut.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.TransferIn.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.SwapBed.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.EmergencyTransfer.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PractitionerTransfer.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelReservBeds.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmitPatient.label", java.lang.String .class,"key"));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.QuickAdmission.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.AdmitPatientwithBed.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterPatientFromAdmitPatient.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AssignBed.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.AllowChangingNursingUnitinAssignBed.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AssignTreatingPractitioner.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ChangeAdmDtls.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelAdmission.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.BackdatedAdmission.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LinkBabyToMother.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RegisterNewbornforIP.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisProcedureRecode.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MaintainDeathRegister.label", java.lang.String .class,"key"));
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
}
