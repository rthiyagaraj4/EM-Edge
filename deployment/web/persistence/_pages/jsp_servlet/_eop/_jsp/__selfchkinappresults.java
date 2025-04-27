package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import blopin.*;
import eOR.*;
import eBL.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.Common.*;
import eOP.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __selfchkinappresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/SelfChkInAppResults.jsp", 1730208920800L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script src=\"../../eOP/js/SelfChkInAppt.js\"></script>\n    <Script src=\"../../eOP/js/VisitRegistration1.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t\t<form name=\"self_chk_in_appt_frames\" id=\"self_chk_in_appt_frames\" method=\'post\' action=\'../../servlet/eOP.VisitRegistrationServlet\' target=\"messageFrame\" >\n\t\t\t\t\t<table cellspacing=\'0\' cellpadding=\'3\' align=\'center\' width=\'100%\' border=\'1\' >\n\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'1%\' class=\"COLUMNHEADERCENTER\" align=\'center\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td width=\'10%\' class=\"COLUMNHEADERCENTER\" align=\'center\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\'15%\' class=\"COLUMNHEADERCENTER\" align=\'center\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" - (en)&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\'15%\' class=\"COLUMNHEADERCENTER\" align=\'center\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="  - (en)&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\'15%\' class=\"COLUMNHEADERCENTER\" align=\'center\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="  - (ar)&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\'15%\' class=\"COLUMNHEADERCENTER\" align=\'center\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" - (ar)&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\'5%\' class=\"COLUMNHEADERCENTER\" align=\'center\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class= \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' align=\'left\' width=\'1%\' nowrap><a href=\"javascript:view_appt_dtl(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\', \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\">+</a>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\'10%\' class= \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' align=\'center\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' align=\'center\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' align=\'center\' > \n\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"button\" name=\"submitBtn\" id=\"submitBtn\"  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" disabled";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" onclick=\"submitForm(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\" /></td>\n\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<input type=\'hidden\' name=\'AllowedDate\' id=\'AllowedDate\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></input>\n\t<input type=\'hidden\' name=\'sysDateSer\' id=\'sysDateSer\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"></input>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\n\t\t\t\n<input type=\'hidden\' name=\'vst_regn_date_time\' id=\'vst_regn_date_time\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' /> \n<input type=\'hidden\' name=\'vst_regn_date_time_new\' id=\'vst_regn_date_time_new\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' /> \n<input type=\'hidden\' name=\'vis_det_temp_code\' id=\'vis_det_temp_code\' value=\'\' /> \n<input type=\'hidden\' name=\'assign_care_locn_desc\' id=\'assign_care_locn_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'assign_care_locn_code\' id=\'assign_care_locn_code\' value=\'\' /> \n<input type=\'hidden\' name=\'room_no\' id=\'room_no\' value=\'\' /> \n<input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\'\' /> \n<input type=\'hidden\' name=\'subservice_code\' id=\'subservice_code\' value=\'\' /> \n<input type=\'hidden\' name=\'isMohbr\' id=\'isMohbr\' value=\'false\' /> \n<input type=\'hidden\' name=\'visit_adm_type\' id=\'visit_adm_type\' value=\'\' /> \n<input type=\'hidden\' name=\'pract_name\' id=\'pract_name\' value=\'\' /> \n<input type=\'hidden\' name=\'attend_practitioner_id\' id=\'attend_practitioner_id\' value=\'\' /> \n<input type=\'hidden\' name=\'appt_practitioner_id\' id=\'appt_practitioner_id\' value=\'\' /> \n<input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\'\' /> \n<input type=\'hidden\' name=\'other_res_type\' id=\'other_res_type\' value=\'\' /> \n<input type=\'hidden\' name=\'other_res_txt\' id=\'other_res_txt\' value=\'\' /> \n<input type=\'hidden\' name=\'other_res_code\' id=\'other_res_code\' value=\'\' /> \n<input type=\'hidden\' name=\'order_cat_txt\' id=\'order_cat_txt\' value=\'\' /> \n<input type=\'hidden\' name=\'order_cat_txt_hidd\' id=\'order_cat_txt_hidd\' value=\'\' /> \n<input type=\'hidden\' name=\'order_cat_code\' id=\'order_cat_code\' value=\'\' /> \n<input type=\'hidden\' name=\'order_category_code\' id=\'order_category_code\' value=\'\' /> \n<input type=\'hidden\' name=\'order_type_code\' id=\'order_type_code\' value=\'\' /> \n<input type=\'hidden\' name=\'ordering_facility_id\' id=\'ordering_facility_id\' value=\'\' /> \n<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'\' /> \n<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\'\' /> \n<input type=\'hidden\' name=\'contact_reason_txt\' id=\'contact_reason_txt\' value=\'\' /> \n<input type=\'hidden\' name=\'contact_reason_txt_hidd\' id=\'contact_reason_txt_hidd\' value=\'\' /> \n<input type=\'hidden\' name=\'contact_reason_code\' id=\'contact_reason_code\' value=\'\' /> \n<input type=\'hidden\' name=\'emergency_details\' id=\'emergency_details\' value=\'\' /> \n<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\'\' /> \n<input type=\'hidden\' name=\'billing_class\' id=\'billing_class\' value=\'\' /> \n<input type=\'hidden\' name=\'employer_code\' id=\'employer_code\' value=\'\' /> \n<input type=\'hidden\' name=\'cash_set_type1\' id=\'cash_set_type1\' value=\'\' /> \n<input type=\'hidden\' name=\'cash_insmt_ref1\' id=\'cash_insmt_ref1\' value=\'\' /> \n<input type=\'hidden\' name=\'cash_insmt_date1\' id=\'cash_insmt_date1\' value=\'\' /> \n<input type=\'hidden\' name=\'cash_insmt_rmks1\' id=\'cash_insmt_rmks1\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_1\' id=\'cust_1\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_doc_date1\' id=\'credit_doc_date1\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_2\' id=\'cust_2\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_doc_date2\' id=\'credit_doc_date2\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_3\' id=\'cust_3\' value=\'\' /> \n<input type=\'hidden\' name=\'policy_type\' id=\'policy_type\' value=\'\' /> \n<input type=\'hidden\' name=\'policy_no\' id=\'policy_no\' value=\'\' /> \n<input type=\'hidden\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' value=\'\' /> \n<input type=\'hidden\' name=\'non_insur_blng_grp\' id=\'non_insur_blng_grp\' value=\'\' /> \n<input type=\'hidden\' name=\'cash_set_type2\' id=\'cash_set_type2\' value=\'\' /> \n<input type=\'hidden\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' value=\'\' /> \n<input type=\'hidden\' name=\'cash_insmt_date2\' id=\'cash_insmt_date2\' value=\'\' /> \n<input type=\'hidden\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_4\' id=\'cust_4\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_doc_date3\' id=\'credit_doc_date3\' value=\'\' /> \n<input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' value=\'\' /> \n<input type=\'hidden\' name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' value=\'\' /> \n<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_auth_date\' id=\'credit_auth_date\' value=\'\' /> \n<input type=\'hidden\' name=\'app_days\' id=\'app_days\' value=\'\' /> \n<input type=\'hidden\' name=\'app_amount\' id=\'app_amount\' value=\'\' /> \n<input type=\'hidden\' name=\'health_card_expired_yn\' id=\'health_card_expired_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'annual_income\' id=\'annual_income\' value=\'\' /> \n<input type=\'hidden\' name=\'family_asset\' id=\'family_asset\' value=\'\' /> \n<input type=\'hidden\' name=\'no_of_dependants\' id=\'no_of_dependants\' value=\'\' /> \n<input type=\'hidden\' name=\'resp_for_payment\' id=\'resp_for_payment\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_doc_reqd_yn2\' id=\'credit_doc_reqd_yn2\' value=\'\' /> \n<input type=\'hidden\' name=\'eff_frm_date\' id=\'eff_frm_date\' value=\'\' /> \n<input type=\'hidden\' name=\'gl_holder_name\' id=\'gl_holder_name\' value=\'\' /> \n<input type=\'hidden\' name=\'gl_holder_reln\' id=\'gl_holder_reln\' value=\'\' /> \n<input type=\'hidden\' name=\'new_op_episode_yn\' id=\'new_op_episode_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'\' /> \n<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\' /> \n<input type=\'hidden\' name=\'upd_user_flag\' id=\'upd_user_flag\' value=\'\' /> \n<input type=\'hidden\' name=\'reccnt\' id=\'reccnt\' value=\'\' /> \n<input type=\'hidden\' name=\'pkg_bill_doc_type\' id=\'pkg_bill_doc_type\' value=\'\' /> \n<input type=\'hidden\' name=\'pkg_bill_doc_num\' id=\'pkg_bill_doc_num\' value=\'\' /> \n<input type=\'hidden\' name=\'policy_type_code\' id=\'policy_type_code\' value=\'\' /> \n<input type=\'hidden\' name=\'effective_date\' id=\'effective_date\' value=\'\' /> \n<input type=\'hidden\' name=\'credit_auth_ref\' id=\'credit_auth_ref\' value=\'\' /> \n<input type=\'hidden\' name=\'approved_days\' id=\'approved_days\' value=\'\' /> \n<input type=\'hidden\' name=\'base_qty\' id=\'base_qty\' value=\'\' /> \n<input type=\'hidden\' name=\'base_rate\' id=\'base_rate\' value=\'\' /> \n<input type=\'hidden\' name=\'base_charge_amt\' id=\'base_charge_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'gross_charge_amt\' id=\'gross_charge_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'disc_amt\' id=\'disc_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'net_charge_amt\' id=\'net_charge_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'pat_base_qty\' id=\'pat_base_qty\' value=\'\' /> \n<input type=\'hidden\' name=\'pat_base_rate\' id=\'pat_base_rate\' value=\'\' /> \n<input type=\'hidden\' name=\'pat_serv_qty\' id=\'pat_serv_qty\' value=\'\' /> \n<input type=\'hidden\' name=\'pat_base_charge_amt\' id=\'pat_base_charge_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'pat_gross_charge_amt\' id=\'pat_gross_charge_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'pat_disc_amt\' id=\'pat_disc_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'pat_net_charge_amt\' id=\'pat_net_charge_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_base_qty\' id=\'cust_base_qty\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_base_rate\' id=\'cust_base_rate\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_serv_qty\' id=\'cust_serv_qty\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_base_charge_amt\' id=\'cust_base_charge_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_gross_charge_amt\' id=\'cust_gross_charge_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_disc_amt\' id=\'cust_disc_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_net_charge_amt\' id=\'cust_net_charge_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'split_yn\' id=\'split_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'pkg_ins_pat_ind\' id=\'pkg_ins_pat_ind\' value=\'\' /> \n<input type=\'hidden\' name=\'req_pkg_qty\' id=\'req_pkg_qty\' value=\'\' /> \n<input type=\'hidden\' name=\'req_addl_qty\' id=\'req_addl_qty\' value=\'\' /> \n<input type=\'hidden\' name=\'req_std_qty\' id=\'req_std_qty\' value=\'\' /> \n<input type=\'hidden\' name=\'curr_availed\' id=\'curr_availed\' value=\'\' /> \n<input type=\'hidden\' name=\'canadj_alert_ind\' id=\'canadj_alert_ind\' value=\'\' /> \n<input type=\'hidden\' name=\'pkg_serv_code\' id=\'pkg_serv_code\' value=\'\' /> \n<input type=\'hidden\' name=\'visit_charge_stage\' id=\'visit_charge_stage\' value=\'\' /> \n<input type=\'hidden\' name=\'day_type_code\' id=\'day_type_code\' value=\'\' /> \n<input type=\'hidden\' name=\'time_type_code\' id=\'time_type_code\' value=\'\' /> \n<input type=\'hidden\' name=\'disc_perc\' id=\'disc_perc\' value=\'\' /> \n<input type=\'hidden\' name=\'addl_fctr\' id=\'addl_fctr\' value=\'\' /> \n<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'\' /> \n<input type=\'hidden\' name=\'order_catalog_desc\' id=\'order_catalog_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'orderId\' id=\'orderId\' value=\'\' /> \n<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\'\' /> \n<input type=\'hidden\' name=\'populate_visit_type\' id=\'populate_visit_type\' value=\'\' /> \n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'\' /> \n<input type=\'hidden\' name=\'pkg_sel\' id=\'pkg_sel\' value=\'\' /> \n<input type=\'hidden\' name=\'pkg_bill_type\' id=\'pkg_bill_type\' value=\'\' /> \n<input type=\'hidden\' name=\'pkg_bill_no\' id=\'pkg_bill_no\' value=\'\' /> \n<input type=\'hidden\' name=\'resource_class\' id=\'resource_class\' value=\'\' /> \n<input type=\'hidden\' name=\'res_pract_id\' id=\'res_pract_id\' value=\'\' /> \n<input type=\'hidden\' name=\'cred_start_dt1\' id=\'cred_start_dt1\' value=\'\' /> \n<input type=\'hidden\' name=\'cred_start_dt2\' id=\'cred_start_dt2\' value=\'\' /> \n<input type=\'hidden\' name=\'cred_start_dt3\' id=\'cred_start_dt3\' value=\'\' /> \n<input type=\'hidden\' name=\'entitlement_by_cat_yn\' id=\'entitlement_by_cat_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'isOrderCtlgAmtCalc\' id=\'isOrderCtlgAmtCalc\' value=\'\' /> \n<input type=\'hidden\' name=\'isPractoApptYn\' id=\'isPractoApptYn\' value=\'N\' /> \n<input type=\'hidden\' name=\'pat_ser_grp_code\' id=\'pat_ser_grp_code\' value=\'\' /> \n<input type=\'hidden\' name=\'exceded_max_walkin\' id=\'exceded_max_walkin\' value=\'\' /> \n<input type=\'hidden\' name=\'no_of_multi_orders\' id=\'no_of_multi_orders\' value=\'\' /> \n<input type=\'hidden\' name=\'override_walkin_yn\' id=\'override_walkin_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'queueNo\' id=\'queueNo\' value=\'\' /> \n<input type=\'hidden\' name=\'waitTime\' id=\'waitTime\' value=\'\' /> \n<input type=\'hidden\' name=\'inv_splty_code\' id=\'inv_splty_code\' value=\'\' /> \n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' /> \n<input type=\'hidden\' name=\'override_pract_for_appt\' id=\'override_pract_for_appt\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" /> \n<input type=\'hidden\' name=\'assign_q_num_by\' id=\'assign_q_num_by\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' /> \n<input type=\'hidden\' name=\'bl_patient_id\' id=\'bl_patient_id\' value=\'\' /> \n<input type=\'hidden\' name=\'oa_install_yn\' id=\'oa_install_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'patFlag\' id=\'patFlag\' value=\'\' /> \n<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' /> \n<input type=\'hidden\' name=\'pat_details\' id=\'pat_details\' value=\'\' /> \n<input type=\'hidden\' name=\'date_of_birth\' id=\'date_of_birth\' value=\'\' /> \n<input type=\'hidden\' name=\'sec_level\' id=\'sec_level\' value=\'\' /> \n<input type=\'hidden\' name=\'protection_ind\' id=\'protection_ind\' value=\'\' /> \n<input type=\'hidden\' name=\'outst_amt\' id=\'outst_amt\' value=\'\' /> \n<input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\'\' /> \n<input type=\'hidden\' name=\'last_visit_date\' id=\'last_visit_date\' value=\'\' /> \n<input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'no_practitioner_for_appt\' id=\'no_practitioner_for_appt\' value=\'\' /> \n<input type=\'hidden\' name=\'ident_at_checkin\' id=\'ident_at_checkin\' value=\'\' /> \n<input type=\'hidden\' name=\'h_visit_type_ind\' id=\'h_visit_type_ind\' value=\'\' /> \n<input type=\'hidden\' name=\'gen_file_yn\' id=\'gen_file_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'build_episode_rule\' id=\'build_episode_rule\' value=\'S\' /> \n<input type=\'hidden\' name=\'or_install_yn\' id=\'or_install_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\'N\' /> \n<input type=\'hidden\' name=\'function\' id=\'function\' value=\'\' /> \n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'\' /> \n<input type=\'hidden\' name=\'Chg_to_Visitor_Grp\' id=\'Chg_to_Visitor_Grp\' value=\'\' /> \n<input type=\'hidden\' name=\'health_card_expired_yn1\' id=\'health_card_expired_yn1\' value=\'\' /> \n<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\'\' /> \n<input type=\'hidden\' name=\'override_vtype_on_epsd_yn\' id=\'override_vtype_on_epsd_yn\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' /> \n<input type=\'hidden\' name=\'episode_close_days_fu\' id=\'episode_close_days_fu\' value=\'\' /> \n<input type=\'hidden\' name=\'episode_close_days_wo_fu\' id=\'episode_close_days_wo_fu\' value=\'\' /> \n<input type=\'hidden\' name=\'dur_for_fu_vsts_in_days\' id=\'dur_for_fu_vsts_in_days\' value=\'\' /> \n<input type=\'hidden\' name=\'no_of_fu_visits_allowed\' id=\'no_of_fu_visits_allowed\' value=\'\' /> \n<input type=\'hidden\' name=\'ct_patient_id\' id=\'ct_patient_id\' value=\'\' /> \n<input type=\'hidden\' name=\'error\' id=\'error\' value=\'\' /> \n<input type=\'hidden\' name=\'old_op_episode_id\' id=\'old_op_episode_id\' value=\'\' /> \n<input type=\'hidden\' name=\'old_op_episode_visit_num\' id=\'old_op_episode_visit_num\' value=\'\' /> \n<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' /> \n<input type=\'hidden\' name=\'l_encounter_id\' id=\'l_encounter_id\' value=\'\' /> \n<input type=\'hidden\' name=\'new_episode_yn\' id=\'new_episode_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'referral_code\' id=\'referral_code\' value=\'\' /> \n<input type=\'hidden\' name=\'reg_vis_param\' id=\'reg_vis_param\' value=\'\' /> \n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' /> \n<input type=\'hidden\' name=\'visit_adm_type_ind\' id=\'visit_adm_type_ind\' value=\'\' /> \n<input type=\'hidden\' name=\'old_episode_no\' id=\'old_episode_no\' value=\'\' /> \n<input type=\'hidden\' name=\'op_episode_id\' id=\'op_episode_id\' value=\'\' /> \n<input type=\'hidden\' name=\'cur_episode_id\' id=\'cur_episode_id\' value=\'\' /> \n<input type=\'hidden\' name=\'op_episode_visit_num\' id=\'op_episode_visit_num\' value=\'\' /> \n<input type=\'hidden\' name=\'register_pat_yn\' id=\'register_pat_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'wait_list_flag\' id=\'wait_list_flag\' value=\'\' /> \n<input type=\'hidden\' name=\'DispAlert\' id=\'DispAlert\' value=\'\' /> \n<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\'\' /> \n<input type=\'hidden\' name=\'financial_detail_ref_id\' id=\'financial_detail_ref_id\' value=\'\' /> \n<input type=\'hidden\' name=\'org_type\' id=\'org_type\' value=\'\' /> \n<input type=\'hidden\' name=\'room_type\' id=\'room_type\' value=\'\' /> \n<input type=\'hidden\' name=\'rm_no\' id=\'rm_no\' value=\'\' /> \n<input type=\'hidden\' name=\'q_visit_adm_type_ind\' id=\'q_visit_adm_type_ind\' value=\'R\' /> \n<input type=\'hidden\' name=\'q_visit_adm_type\' id=\'q_visit_adm_type\' value=\'\' /> \n<input type=\'hidden\' name=\'change_address\' id=\'change_address\' value=\'\' /> \n<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\'\' /> \n<input type=\'hidden\' name=\'concat_NatIdDetails_hidden\' id=\'concat_NatIdDetails_hidden\' value=\'\' /> \n<input type=\'hidden\' name=\'addr1_type\' id=\'addr1_type\' value=\'\' /> \n<input type=\'hidden\' name=\'addr_line1\' id=\'addr_line1\' value=\'\' /> \n<input type=\'hidden\' name=\'addr_line2\' id=\'addr_line2\' value=\'\' /> \n<input type=\'hidden\' name=\'addr_line3\' id=\'addr_line3\' value=\'\' /> \n<input type=\'hidden\' name=\'addr_line4\' id=\'addr_line4\' value=\'\' /> \n<input type=\'hidden\' name=\'res_town_code\' id=\'res_town_code\' value=\'\' /> \n<input type=\'hidden\' name=\'res_town_desc\' id=\'res_town_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'res_area_code\' id=\'res_area_code\' value=\'\' /> \n<input type=\'hidden\' name=\'res_area_desc\' id=\'res_area_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'postal_code\' id=\'postal_code\' value=\'\' /> \n<input type=\'hidden\' name=\'region_code\' id=\'region_code\' value=\'\' /> \n<input type=\'hidden\' name=\'region_desc\' id=\'region_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'country_code\' id=\'country_code\' value=\'\' /> \n<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'\' /> \n<input type=\'hidden\' name=\'invalid1_yn\' id=\'invalid1_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'addr2_type\' id=\'addr2_type\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_addr_line1\' id=\'mail_addr_line1\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_addr_line2\' id=\'mail_addr_line2\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_addr_line3\' id=\'mail_addr_line3\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_addr_line4\' id=\'mail_addr_line4\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_res_town_code\' id=\'mail_res_town_code\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_res_town_desc\' id=\'mail_res_town_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_res_area_code\' id=\'mail_res_area_code\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_res_area_desc\' id=\'mail_res_area_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_postal_code\' id=\'mail_postal_code\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_region_code\' id=\'mail_region_code\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_region_desc\' id=\'mail_region_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_country_code\' id=\'mail_country_code\' value=\'\' /> \n<input type=\'hidden\' name=\'r_postal_code1\' id=\'r_postal_code1\' value=\'\' /> \n<input type=\'hidden\' name=\'m_postal_code1\' id=\'m_postal_code1\' value=\'\' /> \n<input type=\'hidden\' name=\'addr3_type\' id=\'addr3_type\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_addr_line1\' id=\'alt_addr_line1\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_addr_line2\' id=\'alt_addr_line2\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_addr_line3\' id=\'alt_addr_line3\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_addr_line4\' id=\'alt_addr_line4\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_town_code\' id=\'alt_town_code\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_town_desc\' id=\'alt_town_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_area_code\' id=\'alt_area_code\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_area_desc\' id=\'alt_area_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_postal_code1\' id=\'alt_postal_code1\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_region_code\' id=\'alt_region_code\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_region_desc\' id=\'alt_region_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_country_code\' id=\'alt_country_code\' value=\'\' /> \n<input type=\'hidden\' name=\'alt_country_desc\' id=\'alt_country_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'\' /> \n<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'\' /> \n<input type=\'hidden\' name=\'invalid2_yn\' id=\'invalid2_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'country_desc\' id=\'country_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'mail_country_desc\' id=\'mail_country_desc\' value=\'\' /> \n<input type=\'hidden\' name=\'bed_num\' id=\'bed_num\' value=\'\' /> \n<input type=\'hidden\' name=\'discharge_date_time\' id=\'discharge_date_time\' value=\'\' /> \n<input type=\'hidden\' name=\'functionId\' id=\'functionId\' value=\'\' /> \n<input type=\'hidden\' name=\'menu_function_id\' id=\'menu_function_id\' value=\'\' /> \n<input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'appt_ref_no_2\' id=\'appt_ref_no_2\' value=\'\' /> \n<input type=\'hidden\' name=\'appt_ref_no\' id=\'appt_ref_no\' value=\'\' /> \n<input type=\'hidden\' name=\'clptype\' id=\'clptype\' value=\'\' /> \n<input type=\'hidden\' name=\'order_req\' id=\'order_req\' value=\'\' /> \n<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'\' /> \n<input type=\'hidden\' name=\'contact1_no\' id=\'contact1_no\' value=\'\' /> \n<input type=\'hidden\' name=\'contact2_no\' id=\'contact2_no\' value=\'\' /> \n<input type=\'hidden\' name=\'email\' id=\'email\' value=\'\' /> \n<input type=\'hidden\' name=\'locationSpeciality\' id=\'locationSpeciality\' value=\'\' /> \n<input type=\'hidden\' name=\'from_reg\' id=\'from_reg\' value=\'\' /> \n<input type=\'hidden\' name=\'new_file_no\' id=\'new_file_no\' value=\'\' /> \n<input type=\'hidden\' name=\'dummy_visit_type\' id=\'dummy_visit_type\' value=\'\' /> \n<input type=\'hidden\' name=\'dummy_locn_code\' id=\'dummy_locn_code\' value=\'\' /> \n<input type=\'hidden\' name=\'dummy_visit_dttime\' id=\'dummy_visit_dttime\' value=\'\' /> \n<input type=\'hidden\' name=\'episodeReqd\' id=\'episodeReqd\' value=\'X\' /> \n<input type=\'hidden\' name=\'bl_enter_yn\' id=\'bl_enter_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\'\' /> \n<input type=\'hidden\' name=\'invitation_no\' id=\'invitation_no\' value=\'\' /> \n<input type=\'hidden\' name=\'room_no1\' id=\'room_no1\' value=\'\' /> \n<input type=\'hidden\' name=\'frame_ref\' id=\'frame_ref\' value=\'\' /> \n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'\' /> \n<input type=\'hidden\' name=\'iSPractVisitLoad\' id=\'iSPractVisitLoad\' value=\'\' /> \n<input type=\'hidden\' name=\'isAllowRegForSameService\' id=\'isAllowRegForSameService\' value=\'false\' /> \n<input type=\'hidden\' name=\'q_appt_time\' id=\'q_appt_time\' value=\'\' /> \n<input type=\'hidden\' name=\'rec_no\' id=\'rec_no\' value=\'\' /> \n<input type=\'hidden\' name=\'visit_for_inpat_yn\' id=\'visit_for_inpat_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'auth_win_reqd_yn\' id=\'auth_win_reqd_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'episode\' id=\'episode\' value=\'\' /> \n<input type=\'hidden\' name=\'record\' id=\'record\' value=\'\' /> \n<input type=\'hidden\' name=\'from_head\' id=\'from_head\' value=\'\' /> \n<input type=\'hidden\' name=\'locn_ind\' id=\'locn_ind\' value=\'\' /> \n<input type=\'hidden\' name=\'waitlist_status\' id=\'waitlist_status\' value=\'\' /> \n<input type=\'hidden\' name=\'p_hosp_main\' id=\'p_hosp_main\' value=\'\' /> \n<input type=\'hidden\' name=\'p_hosp_sub\' id=\'p_hosp_sub\' value=\'\' /> \n<input type=\'hidden\' name=\'p_card_id\' id=\'p_card_id\' value=\'\' /> \n<input type=\'hidden\' name=\'p_expiry_date\' id=\'p_expiry_date\' value=\'\' /> \n<input type=\'hidden\' name=\'p_privl_type_code\' id=\'p_privl_type_code\' value=\'\' /> \n<input type=\'hidden\' name=\'p_all_services\' id=\'p_all_services\' value=\'\' /> \n<input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'multiple_orders_yn\' id=\'multiple_orders_yn\' value=\'N\'>\n<input type=\'hidden\' name=\'accept_dis_inv_no\' id=\'accept_dis_inv_no\' value=\'\' /> \n<input type=\'hidden\' name=\'visit_type_derv_rule\' id=\'visit_type_derv_rule\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' /> \n<input type=\'hidden\' name=\'visit_back_yn\' id=\'visit_back_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'vst_type_ind\' id=\'vst_type_ind\' value=\'\' /> \n<input type=\'hidden\' name=\'multi_speciality_yn\' id=\'multi_speciality_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'appt_order\' id=\'appt_order\' value=\'\' /> \n<input type=\'hidden\' name=\'order_count_select\' id=\'order_count_select\' value=\'\' /> \n<input type=\'hidden\' name=\'blng_grp_id\' id=\'blng_grp_id\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_grp_code\' id=\'cust_grp_code\' value=\'\' /> \n<input type=\'hidden\' name=\'cust_code\' id=\'cust_code\' value=\'\' /> \n<input type=\'hidden\' name=\'policy_type_code\' id=\'policy_type_code\' value=\'\' /> \n<input type=\'hidden\' name=\'proceed_visit_regn\' id=\'proceed_visit_regn\' value=\'\' /> \n<input type=\'hidden\' name=\'upt_contact_dtls_oa_yn\' id=\'upt_contact_dtls_oa_yn\' value=\'\' /> \n<input type=\'hidden\' name=\'downtimePatient\' id=\'downtimePatient\' value=\'\' /> \n<input type=\'hidden\' name=\'isForm60Available\' id=\'isForm60Available\' value=\'\' /> \n<input type=\'hidden\' name=\'reg_date_time\' id=\'reg_date_time\' value=\'\' /> \n<input type=\'hidden\' name=\'validationForPanCardAvail\' id=\'validationForPanCardAvail\' value=\'\' /> \n<input type=\'hidden\' name=\'form60_YN\' id=\'form60_YN\' value=\'\' /> \n<input type=\'hidden\' name=\'defFinDtls\' id=\'defFinDtls\' value=\'\' /> \n<input type=\'hidden\' name=\'assign_care_locn_desc_prev\' id=\'assign_care_locn_desc_prev\' value=\'\' /> \n<input type=\'hidden\' name=\'apptrefno\' id=\'apptrefno\' value=\'\' /> \n<input type=\'hidden\' name=\'isRoomMandatoryRegVisit\' id=\'isRoomMandatoryRegVisit\' value=\'\' /> \n<input type=\'hidden\' name=\'is_prac_blocked\' id=\'is_prac_blocked\' value=\'\' /> \n<input type=\'hidden\' name=\'action_on_pract_schedule\' id=\'action_on_pract_schedule\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' /> \n<input type=\'hidden\' name=\'assigncare_loctype_ind\' id=\'assigncare_loctype_ind\' value=\'\' /> \n<input type=\'hidden\' name=\'assigncare_locacode\' id=\'assigncare_locacode\' value=\'\' /> \n<input type=\'hidden\' name=\'isReferral\' id=\'isReferral\' value=\'\' /> \n<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\'\' /> \n<input type=\'hidden\' name=\'others_id\' id=\'others_id\' value=\'\' />\n<input type=\'hidden\' name=\'self_chkin_appt_yn\' id=\'self_chkin_appt_yn\' value=\'Y\' />\n\n\t\t</form>\n\t\t</body>\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<script>\n\t\t\t\tfnShowNoRecords();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\n</html>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
String bean_id = "refusalOrdersBean" ;
String bean_name = "eOR.RefusalOrdersBean";
boolean iSPractVisitLoad=false;//added by munisekhar for MMS-QH-CRF-0167 [IN:044923] 
RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;

Orderables.clearObject();
Properties p=(java.util.Properties) session.getValue("jdbc"); //Added for this CRF GDOH-CRF-0129
//Start - Added for GDOH-CRF-149
	session.removeAttribute("str_clinic_code");
	session.removeAttribute("classTypChangeAuthYnPatId");
//End - Added for GDOH-CRF-149
		


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	Connection con=null;



	try {
		con						=  ConnectionManager.getConnection(request);
			
		String patient_id		= checkForNull(request.getParameter("patientId"));
		String facility_id		=	(String)session.getAttribute("facility_id");
		String locale			= (String) session.getValue( "LOCALE" ) ;
		String userid           = (String) session.getValue("login_user");

		int visit_backdate_days_val=0;
		String visit_back_yn = "";
		

		if(userid == null || userid.equals("null"))
			userid = "";

		String oper_stn_id		= CommonBean.getOperStationId(con,facility_id, userid,"REGISTER_VISIT_YN");
		String or_install_yn	= CommonBean.getModuleInstalledYN(con,facility_id, "OR");
		
		JSONObject opParamDtls = new JSONObject();
		JSONObject followupVisitDtls = new JSONObject();
		opParamDtls				 = eOP.OPCommonBean.getOPParamDtls(con,facility_id);
		String action_on_pract_schedule	= checkForNull((String) opParamDtls.get("action_on_pract_schedule"));
		String assign_q_num_by		= checkForNull((String) opParamDtls.get("assign_q_num_by"));
		String vst_regn_date		= checkForNull((String) opParamDtls.get("vst_regn_date"));
		String vst_regn_date_new		= checkForNull((String) opParamDtls.get("vst_regn_date_new"));
		String override_pract_for_appt_yn		= checkForNull((String) opParamDtls.get("override_pract_for_appt_yn"));
		String override_vtype_on_epsd_yn		= checkForNull((String) opParamDtls.get("override_vtype_on_epsd_yn"));
		String visit_backdate_days		= checkForNull((String) opParamDtls.get("visit_backdate_days"));
		String allowed_date		= checkForNull((String) opParamDtls.get("allowed_date"));
		String vis_det_temp_yn		= checkForNull((String) opParamDtls.get("vis_det_temp_yn"));
		String visit_type_derv_rule		= checkForNull((String) opParamDtls.get("visit_type_derv_rule"));
		
		vst_regn_date	= DateUtils.convertDate(vst_regn_date,"DMYHMS","en",locale);
		if(!( visit_backdate_days ==null || visit_backdate_days.equals("") ))
			visit_backdate_days_val =Integer.parseInt(visit_backdate_days);

		if (visit_backdate_days_val > 0) {
			visit_back_yn = "Y";
		}



		
		JSONArray patApptListArray 			= (JSONArray) eOP.OPCommonBean.getPatientApptDtls(con,locale,facility_id,oper_stn_id,patient_id);
		int patApptListCount					= patApptListArray.size();

		if(patApptListCount > 0){
	 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);


							for(int i = 0 ; i < patApptListCount ; i++) {
								JSONObject patApptList	= (JSONObject)patApptListArray.get(i);
								String appt_ref_no			= (String) patApptList.get("appt_ref_no");
								String patient_name				= (String) patApptList.get("patient_name");
								String patient_name_ar			= (String) patApptList.get("patient_name_ar");
								String clinic_desc				= (String) patApptList.get("clinic_desc");
								String clinic_desc_ar			= (String) patApptList.get("clinic_desc_ar");
								String clinic_code				= (String) patApptList.get("clinic_code");
								String pract_id					= (String) patApptList.get("pract_id");
								String resource_class			= (String) patApptList.get("resource_class");
								String clinic_type				= (String) patApptList.get("clinic_type");
								String appt_date				= (String) patApptList.get("appt_date");
								String from_time				= (String) patApptList.get("from_time");
								String to_time					= (String) patApptList.get("to_time");
								String appt_time				= (String) patApptList.get("appt_time");
								String service_code				= (String) patApptList.get("service_code");
								String visit_adm_type			= (String) patApptList.get("appt_type_code");
								String order_id					= (String) patApptList.get("order_id");
								String order_line_num			= (String) patApptList.get("order_line_num");
								String order_type_code			= (String) patApptList.get("order_type_code");
								String order_catlog_code		= (String) patApptList.get("order_catlog_code");
								String order_catalog_desc		= (String) patApptList.get("order_catalog_desc");
								String ordering_facility_id		= (String) patApptList.get("ordering_facility_id");
								String visit_type_ind		= (String) patApptList.get("visit_type_ind");

								String no_of_fu_visits_allowed	= "0";
								String dur_for_fu_vsts_in_days	= "0";
								String op_episode_id	= "";
								//String last_visit_num	= "";
								String episode_close_days_wo_fu	= "";
								//String visit_date	= "";
								String old_episode_no	= "";
								String episode_close_days_fu	= "";
							//	String episode_id	= "";
								//String last_visit_fu_reqd_yn	= "";
								String last_visit_date	= "";
								String new_op_episode_yn	= "Y";
								String op_episode_visit_num	= "0";

								
								if(!service_code.equals("") ){

									followupVisitDtls				 = eOP.OPCommonBean.getFollowupVisitDtls(con,facility_id,patient_id,service_code,override_vtype_on_epsd_yn,visit_type_ind,clinic_code);
									System.err.println(followupVisitDtls.toString());	
									
									no_of_fu_visits_allowed	= checkForNull((String) followupVisitDtls.get("no_of_fu_visits_allowed"));
									dur_for_fu_vsts_in_days	= checkForNull((String) followupVisitDtls.get("dur_for_fu_vsts_in_days"));
									op_episode_id	= checkForNull((String) followupVisitDtls.get("op_episode_id"));
									//last_visit_num	= checkForNull((String) followupVisitDtls.get("last_visit_num"));
									episode_close_days_wo_fu	= checkForNull((String) followupVisitDtls.get("episode_close_days_wo_fu"));
									old_episode_no	= checkForNull((String) followupVisitDtls.get("old_episode_no"));
									episode_close_days_fu	= checkForNull((String) followupVisitDtls.get("episode_close_days_fu"));
									last_visit_date	= checkForNull((String) followupVisitDtls.get("last_visit_date"));
									new_op_episode_yn	= checkForNull((String) followupVisitDtls.get("new_op_episode_yn"));
									op_episode_visit_num	= checkForNull((String) followupVisitDtls.get("op_episode_visit_num"));
								}

								


						
												
								
								String classValue				= "QRYODD";
								String clinic_type_desc			= ""; 
								if(clinic_type.equals("C"))  { 
									clinic_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); 
								} else if(clinic_type.equals("E")) {                                                																	clinic_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
								}
								
								int row	= i;
								if(row%2==0){
									classValue					= "QRYEVEN";
								}else{
									classValue					= "QRYODD";
								}
															
							
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(to_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(appt_time));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinic_desc_ar));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_name_ar));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
if(service_code.equals("")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(to_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(appt_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_catlog_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_catalog_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(no_of_fu_visits_allowed));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dur_for_fu_vsts_in_days));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(op_episode_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_close_days_wo_fu));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(old_episode_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_close_days_fu));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(last_visit_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(new_op_episode_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
 if (visit_back_yn.equalsIgnoreCase("Y")) { 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(allowed_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(vst_regn_date));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(vst_regn_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(vst_regn_date_new));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(override_pract_for_appt_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(assign_q_num_by));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(override_vtype_on_epsd_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(visit_type_derv_rule));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(action_on_pract_schedule));
            _bw.write(_wl_block47Bytes, _wl_block47);

		}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
	} catch(Exception e){
		e.printStackTrace();
	}
   finally
    {
		ConnectionManager.returnConnection(con,request);
    }
	
            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Register.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Register.label", java.lang.String .class,"key"));
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
}
