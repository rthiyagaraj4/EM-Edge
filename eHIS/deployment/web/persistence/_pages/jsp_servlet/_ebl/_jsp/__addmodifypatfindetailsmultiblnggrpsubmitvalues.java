package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;

public final class __addmodifypatfindetailsmultiblnggrpsubmitvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsMultiBlngGrpSubmitValues.jsp", 1709114354917L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2_0 ="\n<script>\n\tfunction test()\n\t{\n\t\tdocument.forms[0].total_records.value=parent.frames[2].document.forms[0].total_records.value;\n\t\tdocument.forms[0].rtn_ins_blng_grp.value=parent.frames[2].document.forms[0].rtn_ins_blng_grp.value;\n\t\tdocument.forms[0].rtn_ins_blng_grp_desc.value=parent.frames[2].document.forms[0].rtn_ins_blng_grp_desc.value;\n\t\tdocument.forms[0].rtn_ins_payer_desc.value=parent.frames[2].document.forms[0].rtn_ins_payer_desc.value;\n\t\tdocument.forms[0].rtn_ins_cust_code.value=parent.frames[2].document.forms[0].rtn_ins_cust_code.value;\n\t\tdocument.forms[0].rtn_ins_cust_priority.value=parent.frames[2].document.forms[0].rtn_ins_cust_priority.value;\n\t\tdocument.forms[0].rtn_ins_policy_type_desc.value=parent.frames[2].document.forms[0].rtn_ins_policy_type_desc.value;\n\t\tdocument.forms[0].rtn_ins_policy_type_code.value=parent.frames[2].document.forms[0].rtn_ins_policy_type_code.value;\n\t\tdocument.forms[0].rtn_ins_policy_no.value=parent.frames[2].document.forms[0].rtn_ins_policy_no.value;\n\t\tdocument.forms[0].rtn_ins_policy_start_date.value=parent.frames[2].document.forms[0].rtn_ins_policy_start_date.value;\n\t\tdocument.forms[0].rtn_ins_policy_expiry_date.value=parent.frames[2].document.forms[0].rtn_ins_policy_expiry_date.value;\n\t\tdocument.forms[0].rtn_ins_credit_auth_ref.value=parent.frames[2].document.forms[0].rtn_ins_credit_auth_ref.value;\n\t\tdocument.forms[0].rtn_ins_credit_auth_date.value=parent.frames[2].document.forms[0].rtn_ins_credit_auth_date.value;\n\t\tdocument.forms[0].rtn_ins_cred_auth_req_yn.value=parent.frames[2].document.forms[0].rtn_ins_cred_auth_req_yn.value;\n\t\tdocument.forms[0].rtn_ins_cred_auth_mand_capt_yn.value=parent.frames[2].document.forms[0].rtn_ins_cred_auth_mand_capt_yn.value;\n\t\tdocument.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value=parent.frames[2].document.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value;\n\n\t\tdocument.forms[0].rtn_ins_credit_approval_days.value=parent.frames[2].document.forms[0].rtn_ins_credit_approval_days.value;\n\t\tdocument.forms[0].rtn_ins_credit_approval_amount.value=parent.frames[2].document.forms[0].rtn_ins_credit_approval_amount.value;\n\t\tdocument.forms[0].rtn_ins_policy_eff_from_date.value=parent.frames[2].document.forms[0].rtn_ins_policy_eff_from_date.value;\n\t\tdocument.forms[0].rtn_ins_policy_eff_to_date.value=parent.frames[2].document.forms[0].rtn_ins_policy_eff_to_date.value;\n\t\tdocument.forms[0].rtn_ins_adj_rule_ind.value=parent.frames[2].document.forms[0].rtn_ins_adj_rule_ind.value;\n\t\tdocument.forms[0].rtn_ins_adj_perc_amt_ind.value=parent.frames[2].document.forms[0].rtn_ins_adj_perc_amt_ind.value;\n\t\tdocument.forms[0].rtn_ins_adj_perc_amt_value.value=parent.frames[2].document.forms[0].rtn_ins_adj_perc_amt_value.value;\n\t\tdocument.forms[0].rtn_ins_pmnt_diff_adj_int.value=parent.frames[2].document.forms[0].rtn_ins_pmnt_diff_adj_int.value;\n\t\tdocument.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value=parent.frames[2].document.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value;\n\t\tdocument.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value=parent.frames[2].document.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value;\n\n\t\tdocument.forms[0].rtn_ins_restrict_check.value=parent.frames[2].document.forms[0].rtn_ins_restrict_check.value;\n\t\tdocument.forms[0].rtn_ins_apprd_amt_restrict_check.value=parent.frames[2].document.forms[0].rtn_ins_apprd_amt_restrict_check.value;\n\t\tdocument.forms[0].rtn_ins_apprd_days_restrict_check.value=parent.frames[2].document.forms[0].rtn_ins_apprd_days_restrict_check.value;\n\n\t\tdocument.forms[0].rtn_ins_valid_payer_YN.value=parent.frames[2].document.forms[0].rtn_ins_valid_payer_YN.value;\n\t\tdocument.forms[0].rtn_ins_valid_policy_type_code_YN.value=parent.frames[2].document.forms[0].rtn_ins_valid_policy_type_code_YN.value;\n\n\t\tdocument.forms[0].rtn_ins_cust_group_code.value=parent.frames[2].document.forms[0].rtn_ins_cust_group_code.value;\n\t\tdocument.forms[0].rtn_ins_cust_group_name.value=parent.frames[2].document.forms[0].rtn_ins_cust_group_name.value;\t\n\t\tdocument.forms[0].rtn_ins_policy_coverage_basis_ind.value=parent.frames[2].document.forms[0].rtn_ins_policy_coverage_basis_ind.value;\n\t\tdocument.forms[0].rtn_ref_src_main_code.value=parent.frames[2].document.forms[0].rtn_ref_src_main_code.value;\n\t\tdocument.forms[0].rtn_ref_src_main_desc.value=parent.frames[2].document.forms[0].rtn_ref_src_main_desc.value;\n\t\tdocument.forms[0].rtn_ref_src_sub_code.value=parent.frames[2].document.forms[0].rtn_ref_src_sub_code.value;\n\t\tdocument.forms[0].rtn_ref_src_sub_desc.value=parent.frames[2].document.forms[0].rtn_ref_src_sub_desc.value;\n\n\t\tdocument.forms[0].rtn_payerEligibilityParamSession.value=parent.frames[2].document.forms[0].rtn_payerEligibilityParamSession.value;\n\t\tdocument.forms[0].rtn_responseCode.value=parent.frames[2].document.forms[0].rtn_responseCode.value;\t\n\t\tdocument.forms[0].rtn_responseCodeDesc.value=parent.frames[2].document.forms[0].rtn_responseCodeDesc.value;\n\t\tdocument.forms[0].rtn_statuDescription.value=parent.frames[2].document.forms[0].rtn_statuDescription.value;\n\t\tdocument.forms[0].rtn_validityPeriod.value=parent.frames[2].document.forms[0].rtn_validityPeriod.value;\n\t\tdocument.forms[0].rtn_validityPeriodDesc.value=parent.frames[2].document.forms[0].rtn_validityPeriodDesc.value;\n\t\tdocument.forms[0].rtn_eligibilityCode.value=parent.frames[2].document.forms[0].rtn_eligibilityCode.value;\n\t\tdocument.forms[0].rtn_transactionId.value=parent.frames[2].document.forms[0].rtn_transactionId.value;\n\t\tdocument.forms[0].rtn_responseDateTime.value=parent.frames[2].document.forms[0].rtn_responseDateTime.value;\n\n\t\t//V232504\n\t\tdocument.forms[0].rtn_mcn_for_policy.value=parent.frames[2].document.forms[0].rtn_mcn_for_policy.value;\n\t\tdocument.forms[0].rtn_reg_ref_id.value=parent.frames[2].document.forms[0].rtn_reg_ref_id.value;\n\t\t\n\n\n\n\n\t\tdocument.forms[0].action=\"../../servlet/eBL.AddModifyPatFinDetailsMultiBlngGrpServlet\";\n\t\tdocument.forms[0].submit();\n\t}\n\n</script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n<html>\n<body onLoad=\"test()\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'BLFinDetSubForm\' id=\'BLFinDetSubForm\' method=\'post\' >\n\n<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_blng_grp_desc\' id=\'rtn_ins_blng_grp_desc\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_blng_grp\' id=\'rtn_ins_blng_grp\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_payer_desc\' id=\'rtn_ins_payer_desc\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_cust_code\' id=\'rtn_ins_cust_code\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_cust_priority\' id=\'rtn_ins_cust_priority\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_policy_type_desc\' id=\'rtn_ins_policy_type_desc\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_policy_type_code\' id=\'rtn_ins_policy_type_code\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_policy_no\' id=\'rtn_ins_policy_no\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_policy_start_date\' id=\'rtn_ins_policy_start_date\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_policy_expiry_date\' id=\'rtn_ins_policy_expiry_date\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_credit_auth_ref\' id=\'rtn_ins_credit_auth_ref\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_credit_auth_date\' id=\'rtn_ins_credit_auth_date\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_cred_auth_req_yn\' id=\'rtn_ins_cred_auth_req_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cred_auth_mand_capt_yn\' id=\'rtn_ins_cred_auth_mand_capt_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_dflt_auth_ref_as_pol_no_yn\' id=\'rtn_ins_dflt_auth_ref_as_pol_no_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_credit_approval_days\' id=\'rtn_ins_credit_approval_days\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_credit_approval_amount\' id=\'rtn_ins_credit_approval_amount\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_policy_eff_from_date\' id=\'rtn_ins_policy_eff_from_date\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_policy_eff_to_date\' id=\'rtn_ins_policy_eff_to_date\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_adj_rule_ind\' id=\'rtn_ins_adj_rule_ind\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_adj_perc_amt_ind\' id=\'rtn_ins_adj_perc_amt_ind\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_adj_perc_amt_value\' id=\'rtn_ins_adj_perc_amt_value\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_pmnt_diff_adj_int\' id=\'rtn_ins_pmnt_diff_adj_int\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_drg_pmnt_diff_adj_int\' id=\'rtn_ins_drg_pmnt_diff_adj_int\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_spl_srv_pmnt_diff_adj_int\' id=\'rtn_ins_spl_srv_pmnt_diff_adj_int\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_restrict_check\' id=\'rtn_ins_restrict_check\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_apprd_amt_restrict_check\' id=\'rtn_ins_apprd_amt_restrict_check\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_apprd_days_restrict_check\' id=\'rtn_ins_apprd_days_restrict_check\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_valid_payer_YN\' id=\'rtn_ins_valid_payer_YN\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_valid_policy_type_code_YN\' id=\'rtn_ins_valid_policy_type_code_YN\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_cust_group_code\' id=\'rtn_ins_cust_group_code\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_cust_group_name\' id=\'rtn_ins_cust_group_name\' value=\'\'>\n<input type=\'hidden\' name=\'rtn_ins_policy_coverage_basis_ind\' id=\'rtn_ins_policy_coverage_basis_ind\' value=\'\'>\n\n<input type=\'hidden\' name=\'rtn_ref_src_main_code\' id=\'rtn_ref_src_main_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_main_desc\' id=\'rtn_ref_src_main_desc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_sub_code\' id=\'rtn_ref_src_sub_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_sub_desc\' id=\'rtn_ref_src_sub_desc\' value=\"\">\n\n\n<input type=\'hidden\' name=\'rtn_payerEligibilityParamSession\' id=\'rtn_payerEligibilityParamSession\' value=\"\">\n<input type=\'hidden\' name=\'rtn_responseCode\' id=\'rtn_responseCode\' value=\"\">\n<input type=\'hidden\' name=\'rtn_responseCodeDesc\' id=\'rtn_responseCodeDesc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_statuDescription\' id=\'rtn_statuDescription\' value=\"\">\n<input type=\'hidden\' name=\'rtn_validityPeriod\' id=\'rtn_validityPeriod\' value=\"\">\n<input type=\'hidden\' name=\'rtn_validityPeriodDesc\' id=\'rtn_validityPeriodDesc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_eligibilityCode\' id=\'rtn_eligibilityCode\' value=\"\">\n<input type=\'hidden\' name=\'rtn_transactionId\' id=\'rtn_transactionId\' value=\"\">\n<input type=\'hidden\' name=\'rtn_responseDateTime\' id=\'rtn_responseDateTime\' value=\"\">\n\n<input type=\'hidden\' name=\'rtn_mcn_for_policy\' id=\'rtn_mcn_for_policy\' value=\"\">  <!-- V232504 -->\n<input type=\'hidden\' name=\'rtn_reg_ref_id\' id=\'rtn_reg_ref_id\' value=\"\">  <!-- V232504 -->\n\n\n";
    private final static byte[]  _wl_block2_0Bytes = _getBytes( _wl_block2_0 );

    private final static java.lang.String  _wl_block2_1 ="\n\n</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block2_1Bytes = _getBytes( _wl_block2_1 );

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

/*
Sr No        Version            Incident          SCF/CRF             Developer Name
1           V232504							SKR-SCF-1731-TF         Namrata Charate
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2_0Bytes, _wl_block2_0);
            _bw.write(_wl_block2_1Bytes, _wl_block2_1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
