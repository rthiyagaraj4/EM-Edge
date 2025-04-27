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
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __blvisitchargedetcloseconsult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLVisitChargeDetCloseConsult.jsp", 1727363240915L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<script language=\'javascript\'>\nfunction fetchValues()\n{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"8\";\n\t\tvar dialogWidth\t= \"35\";\n\t\tvar dialogTop = \"210\";\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \";  scroll=no ; status: \" + status + \" ; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\t\n\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\t\tvar facility_id = document.forms[0].facility_id.value;\n\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\tvar clinic_code = document.forms[0].clinic_code.value;\n\t\tvar visit_type_code = document.forms[0].visit_type_code.value;\n\t\tvar calling_module_id = document.forms[0].calling_module_id.value;\n\t\tvar visit_id = document.forms[0].visit_id.value;\n\t\tvar episode_id = document.forms[0].episode_id.value;\n\t\tvar episode_type = document.forms[0].episode_type.value;\n\t\tvar hospvisitchargeYN = document.forms[0].hospvisitchargeYN.value;\n\t\tvar medvisitchargeYN = document.forms[0].medvisitchargeYN.value;\n\t\tvar addlvisitchargeYN = document.forms[0].addlvisitchargeYN.value;\n\t\tvar exempt_date = document.forms[0].exempt_date.value;\n\t\tvar bill_gen = document.forms[0].bill_gen.value;\n\n\t\tvar hosp_serv_panel_ind = document.forms[0].hosp_serv_panel_ind.value;\n\t\tvar hosp_serv_panel_code = document.forms[0].hosp_serv_panel_code.value;\n//\t\tvar hosp_serv_panel_str = document.forms[0].hosp_serv_panel_str.value;\n\t\tvar hosp_serv_panel_qty = document.forms[0].hosp_serv_panel_qty.value;\n\t\tvar hosp_serv_chrg_amt = document.forms[0].hosp_serv_chrg_amt.value;\n\n\t\tvar med_serv_panel_ind = document.forms[0].med_serv_panel_ind.value;\n\t\tvar med_serv_panel_code = document.forms[0].med_serv_panel_code.value;\n//\t\tvar med_serv_panel_str = document.forms[0].med_serv_panel_str.value;\n\t\tvar med_serv_panel_qty = document.forms[0].med_serv_panel_qty.value;\n\t\tvar med_serv_chrg_amt = document.forms[0].med_serv_chrg_amt.value;\n\n\t\tvar addl_serv_panel_ind = document.forms[0].addl_serv_panel_ind.value;\n\t\tvar addl_serv_panel_code = document.forms[0].addl_serv_panel_code.value;\n//\t\tvar med_serv_panel_str = document.forms[0].med_serv_panel_str.value;\n\t\tvar addl_serv_panel_qty = document.forms[0].addl_serv_panel_qty.value;\n\t\tvar addl_serv_chrg_amt = document.forms[0].addl_serv_chrg_amt.value;\n\n\t\tvar str_hosp_chrg_amt = document.forms[0].str_hosp_chrg_amt.value;\n\t\tvar str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\tvar str_med_chrg_amt = document.forms[0].str_med_chrg_amt.value;\n\t\tvar str_med_chrg_pat_amt= document.forms[0].str_med_chrg_pat_amt.value;\n\t\tvar str_addl_chrg_amt = document.forms[0].str_addl_chrg_amt.value;\n\t\tvar str_addl_chrg_pat_amt= document.forms[0].str_addl_chrg_pat_amt.value;\n\n/*** CRF-362 SCRUM related changes starts ****/\n\t\tvar ae_bed_charge_appl_yn= document.forms[0].ae_bed_charge_appl_yn.value;\t\t\n\t\tvar encounterId= document.forms[0].strEncounterId.value;\n\t\tvar charge_net_amt= document.forms[0].charge_net_amt.value;\n\t\tvar patientPayble= document.forms[0].patientPayble.value;\n\t\tvar module_id= document.forms[0].module_id.value;\n\t\tvar ae_bed_calYN= document.forms[0].ae_bed_calYN.value;\n\t\tvar practitioner_type_ind= document.forms[0].practitioner_type_ind.value;\n/*** CRF-362 SCRUM related changes ends ****/\n\n\t\tif (hospvisitchargeYN == \"Y\" || medvisitchargeYN == \"Y\" || addlvisitchargeYN == \"Y\" || exempt_date!=\"\" || bill_gen!=\"\")\n\t\t{\t\n\t\t\t// CRF-362 charge_net_amt,encounterId two parameters added \n\t\n\t\t\tvar url = \"../../eBL/jsp/BLVisitChargeDet.jsp?module_id=\"+module_id+\"&patientPayble=\"+patientPayble+\"&encounterId=\"+encounterId+\"&charge_net_amt=\"+charge_net_amt+\"&call_after_reg=\"+call_after_reg+\"&hospvisitchargeYN=\"+hospvisitchargeYN+\"&medvisitchargeYN=\"+medvisitchargeYN+\"&addlvisitchargeYN=\"+addlvisitchargeYN+\"&exempt_date=\"+exempt_date+\"&bill_gen=\"+bill_gen+\"&facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&clinic_code=\"+clinic_code+\"&visit_type_code=\"+visit_type_code+\"&calling_module_id=\"+calling_module_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&hosp_serv_panel_ind=\"+hosp_serv_panel_ind+\"&hosp_serv_panel_code=\"+hosp_serv_panel_code+\"&hosp_serv_panel_qty=\"+hosp_serv_panel_qty+\"&hosp_serv_chrg_amt=\"+hosp_serv_chrg_amt+\"&med_serv_panel_ind=\"+med_serv_panel_ind+\"&med_serv_panel_code=\"+med_serv_panel_code+\"&med_serv_panel_qty=\"+med_serv_panel_qty+\"&med_serv_chrg_amt=\"+med_serv_chrg_amt+\"&addl_serv_panel_ind=\"+addl_serv_panel_ind+\"&addl_serv_panel_code=\"+addl_serv_panel_code+\"&addl_serv_panel_qty=\"+addl_serv_panel_qty+\"&addl_serv_chrg_amt=\"+addl_serv_chrg_amt+\"&str_hosp_chrg_amt=\"+str_hosp_chrg_amt+\"&str_med_chrg_amt=\"+str_med_chrg_amt+\"&str_addl_chrg_amt=\"+str_addl_chrg_amt+\"&str_hosp_chrg_pat_amt=\"+str_hosp_chrg_pat_amt+\"&str_med_chrg_pat_amt=\"+str_med_chrg_pat_amt+\"&str_addl_chrg_pat_amt=\"+str_addl_chrg_pat_amt+\"&practitioner_type_ind=\"+practitioner_type_ind+\"&ae_bed_calYN=\"+ae_bed_calYN;\n\t\t\t\n\t\t\t\n\n\t\t\tparent.frames[0].location.href=url;\n\t\t}\n\t\telse\n\t\t{\n//\t\t\talert(\"In VisitChargeDet1\");\n\t\t\tparent.window.returnValue=1;\n\t\t\tdocument.forms[0].action=\"../../servlet/eBL.BLFinancialDetailsCloseConsultServlet\";\n\t\t\tdocument.forms[0].submit();\n//\t\t\twindow.close();\n\t\t}\n}\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\t\t\t\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'\' id=\'\' method=\'post\' action=\'BLVisitChargeDetCloseConsult.jsp\'>\t\t\n\n<input type= \'hidden\' name=\"noofdecimal\" id=\"noofdecimal\"  value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<input type=\"hidden\" name=\"call_after_reg\" id=\"call_after_reg\"  value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"> </input>\n<input type=\"hidden\" name=\"start_valid\" id=\"start_valid\"  value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"> </input>\n<input type=\"hidden\" name=\"validated_state\" id=\"validated_state\"  value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></input>\n<input type=\"hidden\" name=\"clinic_code\" id=\"clinic_code\"  value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"></input>\n<input type=\"hidden\" name=\"visit_type_code\" id=\"visit_type_code\"   value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></input>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"   value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></input>\n<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></input>\n<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></input>\n<input type=\"hidden\" name=\"visit_id\" id=\"visit_id\"     value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></input>\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"     value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></input>\n<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\"     value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></input>\n<input type=\"hidden\" name=\"practitioner_type_ind\" id=\"practitioner_type_ind\"     value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></input>\n<input type=\"hidden\" name=\"calling_module_id\" id=\"calling_module_id\"     value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"></input>\n<input type=\"hidden\" name=\"logged_user_id\" id=\"logged_user_id\"     value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></input>\n<input type=\"hidden\" name=\"error_message\" id=\"error_message\"     value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></input>\n<input type=\"hidden\" name=\"error_level\" id=\"error_level\"     value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></input>\n<input type=\"hidden\" name=\"sys_message_id\" id=\"sys_message_id\"     value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"></input>\n\n<input type=\"hidden\" name=\"billing_group\" id=\"billing_group\"  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"></input>\n<input type=\"hidden\" name=\"cust_group_code\" id=\"cust_group_code\"  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></input>\n<input type=\"hidden\" name=\"cust_code\" id=\"cust_code\"  value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"></input>\n<input type=\'hidden\' name=\'policy_priority\' id=\'policy_priority\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'policy_type_code\' id=\'policy_type_code\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'policy_no\' id=\'policy_no\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'policy_start_date\' id=\'policy_start_date\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'credit_auth_ref\' id=\'credit_auth_ref\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'credit_auth_date\' id=\'credit_auth_date\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'credit_approval_days\' id=\'credit_approval_days\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'credit_approval_amount\' id=\'credit_approval_amount\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'policy_eff_from_date\' id=\'policy_eff_from_date\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'policy_eff_to_date\' id=\'policy_eff_to_date\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'non_ins_blng_grp_id\' id=\'non_ins_blng_grp_id\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'non_ins_cust_group_code\' id=\'non_ins_cust_group_code\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'non_ins_cust_code\' id=\'non_ins_cust_code\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\n<input type=\"hidden\" name=\"p_nursing_unit_code\" id=\"p_nursing_unit_code\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"></input>\n<input type=\"hidden\" name=\"p_nursing_unit_type_code\" id=\"p_nursing_unit_type_code\"    value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"></input>\n<input type=\"hidden\" name=\"p_bed_class_code\" id=\"p_bed_class_code\"\t\t value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"></input>\t\n<input type=\"hidden\" name=\"p_bed_type_code\" id=\"p_bed_type_code\"\t\t\t value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"></input>\t\n<input type=\"hidden\" name=\"p_bed_no\" id=\"p_bed_no\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"></input>\t\n<input type=\"hidden\" name=\"p_settlement_ind\" id=\"p_settlement_ind\"\t\t value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></input>\t\n<input type=\"hidden\" name=\"p_deposit_appl_yn\" id=\"p_deposit_appl_yn\"\t value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"></input>\t\n<input type=\"hidden\" name=\"p_addl_dep_reqd_yn\" id=\"p_addl_dep_reqd_yn\"\t value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></input>\t\n<input type=\"hidden\" name=\"p_dep_amt\" id=\"p_dep_amt\"\t value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"></input>\t\n<input type=\"hidden\" name=\"p_tot_dep_amt\" id=\"p_tot_dep_amt\"\t value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"></input>\t\n<input type=\"hidden\" name=\"p_calculated_yn\" id=\"p_calculated_yn\"\t value=\"N\"></input>\t\n\n<input type=\"hidden\" name=\"hospvisitchargeYN\" id=\"hospvisitchargeYN\"\t value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"></input>\n<input type=\"hidden\" name=\"medvisitchargeYN\" id=\"medvisitchargeYN\"\t value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"></input>\n<input type=\"hidden\" name=\"addlvisitchargeYN\" id=\"addlvisitchargeYN\"\t value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"></input>\n\n<input type=\"hidden\" name=\"exempt_date\" id=\"exempt_date\"\t value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"></input>\n<input type=\"hidden\" name=\"bill_gen\" id=\"bill_gen\"\t value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"></input>\n\n\n<input type=\"hidden\" name=\"hosp_serv_panel_ind\" id=\"hosp_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"></input>\t\n<input type=\"hidden\" name=\"hosp_serv_panel_code\" id=\"hosp_serv_panel_code\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"></input>\t\n<input type=\"hidden\" name=\"hosp_serv_panel_qty\" id=\"hosp_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"></input>\n<input type=\"hidden\" name=\"hosp_serv_chrg_amt\" id=\"hosp_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"></input>\n\n<input type=\"hidden\" name=\"med_serv_panel_ind\" id=\"med_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"></input>\t\n<input type=\"hidden\" name=\"med_serv_panel_code\" id=\"med_serv_panel_code\"\t value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"></input>\t\n<input type=\"hidden\" name=\"med_serv_panel_qty\" id=\"med_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"></input>\n<input type=\"hidden\" name=\"med_serv_chrg_amt\" id=\"med_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"></input>\n\n<input type=\"hidden\" name=\"addl_serv_panel_ind\" id=\"addl_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"></input>\t\n<input type=\"hidden\" name=\"addl_serv_panel_code\" id=\"addl_serv_panel_code\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"></input>\t\n<input type=\"hidden\" name=\"addl_serv_panel_qty\" id=\"addl_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"></input>\n<input type=\"hidden\" name=\"addl_serv_chrg_amt\" id=\"addl_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"></input>\n\n<input type=\"hidden\" name=\"str_hosp_chrg_amt\" id=\"str_hosp_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"></input>\n<input type=\"hidden\" name=\"str_hosp_chrg_pat_amt\" id=\"str_hosp_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"></input>\n<input type=\"hidden\" name=\"str_med_chrg_amt\" id=\"str_med_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"></input>\n<input type=\"hidden\" name=\"str_med_chrg_pat_amt\" id=\"str_med_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"></input>\n<input type=\"hidden\" name=\"str_addl_chrg_amt\" id=\"str_addl_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"></input>\n<input type=\"hidden\" name=\"str_addl_chrg_pat_amt\" id=\"str_addl_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"></input>\n\n<!-- CRF-362 SCRUM related changes starts -->\n<input type=\"hidden\" name=\"ae_bed_charge_appl_yn\" id=\"ae_bed_charge_appl_yn\"\t value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"></input>\n<input type=\"hidden\" name=\"strEncounterId\" id=\"strEncounterId\"\t value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"></input>\n<input type=\"hidden\" name=\"charge_net_amt\" id=\"charge_net_amt\"\t value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"></input>\n<input type=\"hidden\" name=\"patientPayble\" id=\"patientPayble\"\t value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"></input>\n<input type=\"hidden\" name=\"module_id\" id=\"module_id\"\t value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"></input>\n<input type=\"hidden\" name=\"ae_bed_calYN\" id=\"ae_bed_calYN\"\t value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"></input>\n<!-- CRF-362 SCRUM related changes starts -->\n\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n<script>\n\t\n\tvar state = document.forms[0].validated_state.value;\n\n\n\tif (state == \"Y\") \n\t{\n\t\tfetchValues();\n\t}\n\tif (state == \"E\") \n\t{\n\t\tif(document.forms[0].error_message.value!=null && document.forms[0].error_level.value==\"10\")\n\t\t{\n\t\t\talert(document.forms[0].error_message.value);\n\t\t\t//parent.window.returnValue=2;\n\t\t\t//parent.window.close();\n\t\t\tparent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = 2;\n\t\t\tparent.parent.document.getElementById(\'dialog_tag\').close();\n\t\t}\n\t\telse if(document.forms[0].sys_message_id.value!=null)\n\t\t{\n\t\t\tvar sys_message_id=document.forms[0].sys_message_id.value;\n\t\t\talert(getMessage(sys_message_id,\'BL\'));\n\t\t\t//parent.window.returnValue=2;\n\t\t\t//parent.window.close();\n\t\t\t\n\t\t\tparent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = 2;\n\t\t\tparent.parent.document.getElementById(\'dialog_tag\').close();\n\t\t}\n\t\tdocument.forms[0].validated_state.value = \"N\";\n\t}\n</script>\n\n</html>\n\n\n\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

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

	Connection con = null;
	CallableStatement statement;
	Statement stmt=null;
	PreparedStatement pstmt = null ;
	ResultSet rs=null;
	try
	{	
		request.setCharacterEncoding("UTF-8");

		con	=	ConnectionManager.getConnection(request);

		//System.out.println("request.getQueryString():"+request.getQueryString());

		int noofdecimal=2;

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}	
			if(rscurr != null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.err.println("Exception in No of Decimal Query="+e.toString());
		}	

		String clinic_code_check="";
		String visit_type_code_check="";
		String patient_id_check="";
		String pract_id_check="";
	
//		String calc_chrg_agn="";
		String call_after_reg="";
		String strStartValid =  "";
		String strClinicCode = "";
		String strVisitType = "";
		String strOldVisitType="";
		String strBLInterfaceYN = "";
		String strPatientId ="";
		String strEpisodeId ="";
		String strVisitId = "";

//		long encounter_id=0;
		int acc_seq_no=0;
		String strEncounterId="";
		String strAccSeqNo="";
		String strPractitionerId="";
		String strPractitionerTypeInd="";

		String strEpisodeType = "";
		String strFacilityId = "";
		String strUser ="";
		String strWsNo = "";
		String strValidatedState="N";
		String mode="C";
		String functionId="";
	
		String strBlnggrpId ="";
		String strCustGroupCode ="";
		String strCustCode ="";

		String strNonInsCustGroupCode ="";
		String strNonInsCustCode ="";
		String strNonInsBlnggrpId ="";
	
		String strPolicyTypeCode="";
		String strPolicyPriority="";
		String strPolicyNumber="";
		String strPolicyStartDate ="";
		String strPolicyExpiryDate="";
		String strCreditAuthRef="";
		String strCreditAuthDate="";
		String strEffectiveFrom="";
		String strEffectiveTo="";
		String strApprovedAmt="";
		String strApprovedDays="";
		
		//Added By Rajesh V
		String strAcrossGroupEncounter = "";
		//Added By Rajesh V

/*		
		String strPhysicianId ="";
		String strErrorMessage ="";
*/
		String strModuleId ="";

		// IP Related
		String strNursingUnitCode="";
		String strNursingUnitType="";
		String strBedClass="";
		String strBedType="";
		String strBedNo="";
		String strSettlementInd="";
		String strDepositApplYN="";
		String strAddlDepositApplYN="";
		String strDepositAmt="";
		String strAddlDepositAmt="";
		String strNull="";
/*
		String strErrMsg  = "";
		String strErrText  = "";
*/

		String strExemptdate="";
		String strBillGen="";

		String charge_basis_by_physician_yn="";
	
		String strHospServPanelInd="";
		String strHospServPanelCode="";
		String strHospServPanelStr="";
//		double strHospServPanelQty=1.0;
//		double strHospServChargeAmt=0.0;
		String strHospServPanelQty="1.0";
		String strHospServChargeAmt="";

		String strMedServPanelInd="";
		String strMedServPanelCode="";
		String strMedServPanelStr="";
//		double strMedServPanelQty=1;
//		double strMedServChargeAmt=0.0;
		String strMedServPanelQty="1.0";
		String strMedServChargeAmt="";

		String strAddlServAvailYN="N";
		String strAddlChargeType = "";
		String dflt_excl_overide_code="";
		String strAddlServPanelInd="";
		String strAddlServPanelCode="";
		String strAddlServPanelStr="";
		String strAddlServPanelQty="1.0";
		String strAddlServChargeAmt="";

		String exempt_date="";
	
		String hosp_charge_YN="";
		String med_charge_YN="";
		String addl_charge_YN="";

		String strNewHospChrgCreate="";
		String strNewMedChrgCreate="";
		String strNewAddlChrgCreate="";

		double hosp_chrg_amt=0.0;
		double hosp_chrg_pat_amt=0.0;
		String str_hosp_chrg_amt="";
		String str_hosp_chrg_pat_amt="";

		double med_chrg_amt=0.0;
		double med_chrg_pat_amt=0.0;
		String str_med_chrg_amt="";
		String str_med_chrg_pat_amt="";

		double addl_chrg_amt=0.0;
		double addl_chrg_pat_amt=0.0;
		String str_addl_chrg_amt="";
		String str_addl_chrg_pat_amt="";
	
		String tot_bill_text = "";

		String bill_gen_yn="";
		String bill_doc_type="";
		String bill_doc_number="";

		String str_bill_later_YN="N";
		String str_bill_gen_later="";
		String str_total_bill_amt="";

		String error_level="";
		String sys_message_id="";
		String error_text="";

/*** CRF-362 SCRUM related changes starts ****/
		String ae_bed_charge_appl_yn="";
		String charge_net_amt="";
		String patientPayble="";
		String ae_bed_calYN="";
/*** CRF-362 SCRUM related changes ends ****/

		HashMap hosp_dtls=new HashMap();
		HashMap prof_dtls=new HashMap();
		HashMap addl_dtls=new HashMap();

		Hashtable messageHashtable=new Hashtable();

		String service_date="",service_date_time="" ,encounter_date_time="";
		String strOldClinicCode="",strOldVstTypeCode="",strOldPractId="",strOldChargeByPractYN="";
		String call_revise_proc_YN ="N", call_charge_proc_YN="N";

//Unused Var's
/*
		String service_panel_code="";
		String service_panel_ind=""; 
		String serv_panel_qty="";
		String serv_panel_str="";
		String order_catalog_code="";
		String calling_module_id="";

		

		double d_tot_qty=0;double d_serv_amt=0; double d_pat_payable=0;double d_min_chr_amt=0;double d_patient_paid=0;
		String str_excl_incl_ind=""; String str_preappr_yn=""; String str_override_yn="";
		String str_blng_serv_desc=""; String str_rate_chr_ind="";

		String str_charge_based_yn="";String str_excl_incl_act="";String str_act_reason_code="";
		double serv_qty=0;

		HashMap hm_string=(HashMap)session.getAttribute("BlChargeRecord");

		String temp_str="";
*/

		String locale			= (String)session.getAttribute("LOCALE");
		String proc_success="Y";

		String hosp_panel_str_YN=(String)session.getAttribute("hosp_panel_str_YN");
		if(hosp_panel_str_YN==null) hosp_panel_str_YN="";

		String prof_panel_str_YN=(String)session.getAttribute("prof_panel_str_YN");
		if(prof_panel_str_YN==null) prof_panel_str_YN="";

		String addl_panel_str_YN=(String)session.getAttribute("addl_panel_str_YN");
		if(addl_panel_str_YN==null) addl_panel_str_YN="";

//		String hosp_chrg_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.HOSP_CHRG.label","bl_labels");
//		String prof_chrg_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PROF_CHRG.label","bl_labels");
		String vst_chrg_exmpt_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VISIT_CHRG_EXEMPT_UPTO.label","bl_labels");	
//		String bill_gen_yn_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PLS_NOTE_DOWN_THE_BILL.label","bl_labels");	
//		String bill_gen_yn_leg1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.FOR_THE_VISIT_CHRG.label","bl_labels");	

		messageHashtable=MessageManager.getMessage(locale,"BL1130","BL");
		//System.out.println("messageHashtable *** BLVisitChargeDetCloseConsult.jsp "+messageHashtable);
		String op_dtls_nt_found=(String)messageHashtable.get("message");
		if(op_dtls_nt_found==null || op_dtls_nt_found.equals("")) op_dtls_nt_found="";
		String op_dtls_nt_found_mes_id="BL1130";
		//System.out.println("op_dtls_nt_found_mes_id *** BLVisitChargeDetCloseConsult.jsp "+op_dtls_nt_found_mes_id);

		String module_id=request.getParameter("call_after_reg");
	

		call_after_reg=request.getParameter("call_after_reg") ;
		//System.out.println("call_after_reg *** BLVisitChargeDetCloseConsult.jsp "+call_after_reg);

		if(call_after_reg==null || call_after_reg.equals("")) call_after_reg="";

		if(call_after_reg.equals("Y"))
		{
			strModuleId =   request.getParameter("calling_module_id") ;
			if (strModuleId == null) strModuleId="";

			functionId=request.getParameter("calling_function_id");
			if (functionId == null) functionId="";

			if (strModuleId.equals("OP")||strModuleId.equals("AE"))
			{
				strStartValid =  request.getParameter("start_valid") ;
				if (strStartValid == null) strStartValid="N";
			
				//System.out.println("strStartValid:"+strStartValid);
				if (strStartValid.equals("Y"))
				{
/*** CRF-362 SCRUM related changes starts ****/
					ae_bed_calYN=request.getParameter("ae_bed_calYN");
					ae_bed_charge_appl_yn = request.getParameter("ae_bed_charge_appl_yn") ;
					charge_net_amt = request.getParameter("charge_net_amt") ;					
					charge_net_amt=String.valueOf(charge_net_amt);					
					patientPayble = request.getParameter("patientPayble") ;
					patientPayble=String.valueOf(patientPayble);
/*** CRF-362 SCRUM related changes ends ****/

					strClinicCode = request.getParameter("clinic_code") ;
					strVisitType = request.getParameter("visit_type_code") ;
					strOldVisitType= request.getParameter("old_visit_type_code") ;
					strBLInterfaceYN = request.getParameter("billing_interface_yn") ;
					strPatientId = request.getParameter("patient_id") ;
					strEpisodeType = request.getParameter("episode_type");
					strFacilityId = request.getParameter("facility_id");
					strEpisodeId =request.getParameter("episode_id");
					strVisitId =request.getParameter("visit_id");
					strEncounterId=request.getParameter("encounter_id");
//					strAccSeqNo=request.getParameter("acc_seq_no");
				
					strPractitionerId = request.getParameter("practitioner_id");
					strPractitionerTypeInd = request.getParameter("practitioner_type_ind");

					if (strFacilityId  == null) strFacilityId = "";

					strUser = request.getParameter("logged_user_id");
					if (strUser == null) strUser = "";
		
					strBlnggrpId=request.getParameter("billing_group");
					strCustCode=request.getParameter("cust_group_code");
					strCustCode=request.getParameter("cust_code");
					strPolicyPriority=request.getParameter("policy_priority");
					strPolicyTypeCode=request.getParameter("policy_type_code");
					strPolicyNumber=request.getParameter("policy_no");
					strPolicyStartDate=request.getParameter("policy_start_date");
					strPolicyExpiryDate=request.getParameter("policy_expiry_date");
					strCreditAuthRef=request.getParameter("credit_auth_ref");
					strCreditAuthDate=request.getParameter("credit_auth_date");
					strApprovedDays=request.getParameter("credit_approval_days");
					strApprovedAmt=request.getParameter("credit_approval_amount");
					strEffectiveFrom=request.getParameter("policy_eff_from_date");
					strEffectiveTo=request.getParameter("policy_eff_to_date");
					strNonInsBlnggrpId=request.getParameter("non_ins_blng_grp_id");
					strNonInsCustGroupCode=request.getParameter("non_ins_cust_group_code");
					strNonInsCustCode=request.getParameter("non_ins_cust_code");

					if (strClinicCode		==null)	strClinicCode        ="";     	
					if (strVisitType		==null)	strVisitType         ="";
					if (strOldVisitType		==null) strOldVisitType		 ="";
					if (strBLInterfaceYN	==null)	strBLInterfaceYN     ="";
					if (strPatientId 		==null)	strPatientId         ="";
					if (strEpisodeId 		==null)	strEpisodeId         ="";
					if (strVisitId 			==null)	strVisitId           ="";
					if (strEpisodeType 		==null)	strEpisodeType       ="";
					if (strFacilityId 		==null)	strFacilityId        ="";
					if (strUser 			==null)	strUser              ="";
					if (strWsNo 			==null)	strWsNo              ="";
//					if(strAccSeqNo           ==null) strAccSeqNo		 ="1";
					if(strEncounterId         ==null) strEncounterId	 ="";
	
					if (strBlnggrpId		==null)	strBlnggrpId         ="";
					if (strCustGroupCode			==null)	strCustGroupCode          ="";
					if (strCustCode			==null)	strCustCode          ="";
					if (strPolicyPriority 	==null)	strPolicyPriority    ="";
					if (strPolicyTypeCode 	==null)	strPolicyTypeCode    ="";
					if (strPolicyNumber 	==null)	strPolicyNumber      ="";
					if (strPolicyStartDate 	==null)	strPolicyStartDate   ="";
					if (strPolicyExpiryDate ==null)	strPolicyExpiryDate  ="";
					if (strCreditAuthRef 	==null)	strCreditAuthRef     ="";
					if (strCreditAuthDate 	==null)	strCreditAuthDate    ="";
					if (strApprovedDays 	==null)	strApprovedDays      ="";
					if (strApprovedAmt 		==null)	strApprovedAmt       ="";
					if (strEffectiveFrom 	==null)	strEffectiveFrom     ="";
					if (strEffectiveTo 		==null)	strEffectiveTo       ="";
					if (strNonInsBlnggrpId	==null)	strNonInsBlnggrpId   ="";
					if (strNonInsCustGroupCode	==null)	strNonInsCustGroupCode    ="";
					if (strNonInsCustCode	==null)	strNonInsCustCode    ="";
	
					if (strPractitionerId  == null || strPractitionerId.equals("")) strPractitionerId = "";
					if (strPractitionerTypeInd  == null || strPractitionerTypeInd.equals("")) strPractitionerTypeInd = "";

					if(strEpisodeId.equals("")) strEpisodeId="0";
					if(strVisitId.equals("")) strVisitId="0";
//					encounter_id=Long.parseLong(strEncounterId);
//					acc_seq_no=Integer.parseInt(strAccSeqNo);

//					System.err.println("strPractitionerId:"+strPractitionerId);
//					System.err.println("strPractitionerTypeInd:"+strPractitionerTypeInd);

					/*System.err.println("strFacilityId:"+strFacilityId);
					System.err.println("strModuleId:"+strModuleId);
					System.err.println("strEpisodeType:"+strEpisodeType);
					System.err.println("strPatientId:"+strPatientId);
					System.err.println("strEpisodeId:"+strEpisodeId);
					System.err.println("strVisitId:"+strVisitId);
					System.err.println("strEncounterId:"+strEncounterId);
					System.err.println("strPractitionerTypeInd:"+strPractitionerTypeInd);
					System.err.println("strPractitionerId:"+strPractitionerId);
					System.err.println("locale:"+locale);
					System.err.println("strClinicCode:"+strClinicCode);
					System.err.println("strVisitType:"+strVisitType);
					System.err.println("strOldVisitType:"+strOldVisitType);*/


					/*System.err.println("strBlnggrpId:"+strBlnggrpId);
					System.err.println("strCustCode:"+strCustCode);
					System.err.println("strPolicyTypeCode:"+strPolicyTypeCode);
					System.err.println("strPolicyPriority:"+strPolicyPriority);
					System.err.println("strPolicyNumber:"+strPolicyNumber);
					System.err.println("strPolicyStartDate:"+strPolicyStartDate);
					System.err.println("strPolicyExpiryDate:"+strPolicyExpiryDate);
					System.err.println("strCreditAuthRef:"+strCreditAuthRef);
					System.err.println("strCreditAuthDate:"+strCreditAuthDate);
					System.err.println("strEffectiveFrom:"+strEffectiveFrom);
					System.err.println("strEffectiveTo:"+strEffectiveTo);
					System.err.println("strApprovedAmt:"+strApprovedAmt);
					System.err.println("strApprovedDays:"+strApprovedDays);
					System.err.println("strNonInsBlnggrpId:"+strNonInsBlnggrpId);
					System.err.println("strNonInsCustCode:"+strNonInsCustCode);*/

					clinic_code_check=(String)session.getAttribute("clinic_code");
					visit_type_code_check=(String)session.getAttribute("visit_type_code");
					patient_id_check=(String)session.getAttribute("patient_id");
					pract_id_check=(String)session.getAttribute("practitioner_id");

					if(!strClinicCode.equals(clinic_code_check) || !strVisitType.equals(visit_type_code_check) || !strPatientId.equals(patient_id_check) || !strPractitionerId.equals(pract_id_check))
					{
						session.removeAttribute("hosp_panel_str");
						session.removeAttribute("prof_panel_str");
						session.removeAttribute("addl_panel_str");
						session.removeAttribute("prof_panel_str_YN");
						session.removeAttribute("hosp_panel_str_YN");
						session.removeAttribute("addl_panel_str_YN");
						session.removeAttribute("upd_hosp_chrg_amt");
						session.removeAttribute("upd_hosp_chrg_pat_amt");
						session.removeAttribute("upd_med_chrg_amt");
						session.removeAttribute("upd_med_chrg_pat_amt");
						session.removeAttribute("upd_addl_chrg_amt");
						session.removeAttribute("upd_addl_chrg_pat_amt");
						session.removeAttribute("hosp_dtls");
						session.removeAttribute("prof_dtls");
						session.removeAttribute("addl_dtls");
						session.removeAttribute("hosp_panel");
						session.removeAttribute("prof_panel");
						session.removeAttribute("addl_panel");
					}
					session.setAttribute("clinic_code",strClinicCode);
					session.setAttribute("visit_type_code",strVisitType);
					session.setAttribute("patient_id",strPatientId);
					session.setAttribute("practitioner_id",strPractitionerId);

					try
					{
						String old_visit_dtls_sql="select CLINIC_CODE,VISIT_TYPE_CODE,PHYSICIAN_ID,CUR_CHARGING_BASIS_BY_PRACT_YN from bl_visit_exm_fin_dtls where OPERATING_FACILITY_ID='"+strFacilityId+"' AND EPISODE_TYPE ='"+strEpisodeType+"' AND EPISODE_ID='"+strEpisodeId+"' AND VISIT_ID ='"+strVisitId+"' AND PATIENT_ID  ='"+strPatientId+"'";

						stmt = con.createStatement();
						rs = stmt.executeQuery(old_visit_dtls_sql) ;
						if( rs != null ) 
						{
							while( rs.next() )
							{  
								strOldClinicCode = rs.getString(1);
								strOldVstTypeCode = rs.getString(2);
								strOldPractId= rs.getString(3);
								strOldChargeByPractYN = rs.getString(4);
							}
						}
						if(rs != null) rs.close();
						stmt.close();

						if(strOldClinicCode==null || strOldClinicCode.equals("")) strOldClinicCode="";
						if(strOldVstTypeCode==null || strOldVstTypeCode.equals("")) strOldVstTypeCode="";
						if(strOldPractId==null || strOldPractId.equals("")) strOldPractId="";

						//System.err.println("strOldClinicCode:"+strOldClinicCode);
						//System.err.println("strOldVstTypeCode:"+strOldVstTypeCode);
						//System.err.println("strOldPractId:"+strOldPractId);
					}
					catch(Exception e)
					{
						System.err.println("Exception in old_visit_dtls_sql:"+e);
					}

/*
					if(functionId.equals("REVISE_VISIT") || functionId.equals("ASSIGN_PRACTITIONER"))
					{
						if(functionId.equals("ASSIGN_PRACTITIONER"))
						{
							strOldVisitType=strVisitType;
						}

						try
						{
							CallableStatement call = con.prepareCall("{ ? = call   BL_OP_REVISE_VISIT.Cal_charge_during_revise(?,?,?,?,?,?,?,?,?)}");	
							call.registerOutParameter(1,java.sql.Types.VARCHAR);
							call.setString(2,strFacilityId);
							call.setString(3,strClinicCode);
							call.setString(4,strVisitType);
							call.setString(5,strOldVisitType);//old_visit_id
							call.setString(6,strPractitionerId);
							call.setString(7,strPatientId);
							call.setString(8,strEpisodeType);
							call.setString(9,strEpisodeId);
							call.setString(10,strVisitId);
							call.execute();
			
							calc_chrg_agn = call.getString(1);			
//							if ( calc_chrg_agn == null ) calc_chrg_agn = true;

							System.err.println("calc_chrg_agn:"+calc_chrg_agn);
	
							call.close();	

							if(calc_chrg_agn.equals("Y"))
							{
								strValidatedState="N";
							}
							else
							{
								strValidatedState="Y";
							}
						}
						catch(Exception e)
						{
							System.err.println("Exception in BL_OP_REVISE_VISIT.Cal_charge_during_revise:"+e);
						}
					}
*/

					if (strClinicCode.equals("") || strVisitType.equals("") || strPatientId.equals("") || strFacilityId.equals("") || strUser.equals(""))
					{
						strValidatedState="E";
//						sys_message_id = op_dtls_nt_found;
						sys_message_id = op_dtls_nt_found_mes_id;

					}
					if (strValidatedState.equals("N"))
					{
						try
						{
							String acc_seq_no_sql="select max(NVL(ACCT_SEQ_NO,1))  from bl_encounter_payer_priority where OPERATING_FACILITY_ID='"+strFacilityId+"' AND EPISODE_TYPE ='"+strEpisodeType+"' AND EPISODE_ID='"+strEpisodeId+"' AND VISIT_ID ='"+strVisitId+"' AND PATIENT_ID  ='"+strPatientId+"'";

							stmt = con.createStatement();
							rs = stmt.executeQuery(acc_seq_no_sql) ;
							if( rs != null ) 
							{
								while( rs.next() )
								{  
									strAccSeqNo= rs.getString(1);
								}
							}
							if(rs != null) rs.close();
							stmt.close();

							if(strAccSeqNo==null || strAccSeqNo.equals("")) strAccSeqNo="0";

							//System.err.println("strAccSeqNo:"+strAccSeqNo);
						}
						catch(Exception e)
						{
							System.err.println("Exception in Acc Seq No:"+e);
						}
					
						acc_seq_no=Integer.parseInt(strAccSeqNo);
						//System.err.println("acc_seq_no:"+acc_seq_no);

						try
						{
							String query_date="select to_char(sysdate,'DD/MON/YYYY') from dual";
							stmt = con.createStatement();
							rs = stmt.executeQuery(query_date) ;
							if( rs != null ) 
							{
								while( rs.next() )
								{  
									service_date = rs.getString(1);
								}
							}
							if(rs != null) rs.close();
							stmt.close();
						}
						catch(Exception e)
						{
							System.err.println("Exception in Sys Date :"+e);
						}

						try
						{
							String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
							stmt = con.createStatement();
							rs = stmt.executeQuery(query_date) ;
							if( rs != null ) 
							{
								while( rs.next() )
								{  
									service_date_time = rs.getString(1);
								}
							}
							if(rs != null) rs.close();
							stmt.close();
						}
						catch(Exception e)
						{
							out.println("Exception in Sys Date :"+e);
						}
	
						//System.err.println("service_datee:"+service_date);
						//System.err.println("service_date_time:"+service_date_time);
						try
						{
							CallableStatement call = con.prepareCall("{ call BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

							call.setString(1,strFacilityId);
							call.setString(2,strClinicCode);
							call.setString(3,strVisitType);
							call.setString(4,strPractitionerId);

							call.registerOutParameter(5,java.sql.Types.INTEGER);
							call.registerOutParameter(6,java.sql.Types.INTEGER);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.registerOutParameter(8,java.sql.Types.VARCHAR);
							call.registerOutParameter(9,java.sql.Types.VARCHAR);
							call.registerOutParameter(10,java.sql.Types.VARCHAR);
							call.registerOutParameter(11,java.sql.Types.VARCHAR);
							call.registerOutParameter(12,java.sql.Types.VARCHAR);
							call.registerOutParameter(13,java.sql.Types.VARCHAR);	
							call.registerOutParameter(14,java.sql.Types.VARCHAR);
							call.registerOutParameter(15,java.sql.Types.VARCHAR);
							call.registerOutParameter(16,java.sql.Types.VARCHAR);

							call.execute();
	
							charge_basis_by_physician_yn=call.getString(7);
							if(charge_basis_by_physician_yn==null) charge_basis_by_physician_yn="";

							strHospServPanelInd=call.getString(10);
							if(strHospServPanelInd==null) strHospServPanelInd="";
							strHospServPanelCode=call.getString(11);
							if(strHospServPanelCode==null) strHospServPanelCode="";
							strMedServPanelInd=call.getString(12);
							if(strMedServPanelInd==null) strMedServPanelInd="";
							strMedServPanelCode=call.getString(13);
							if(strMedServPanelCode==null) strMedServPanelCode="";
							error_level=call.getString(14);
							sys_message_id=call.getString(15);
							error_text=call.getString(16);
							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";

							/*System.err.println("charge_basis_by_physician_yn:"+charge_basis_by_physician_yn);
							System.err.println("strHospServPanelInd:"+strHospServPanelInd);
							System.err.println("strHospServPanelCode:"+strHospServPanelCode);
							System.err.println("strMedServPanelInd:"+strMedServPanelInd);
							System.err.println("strMedServPanelCode:"+strMedServPanelCode);
							System.err.println("error_level in BLOPIN:"+error_level);
							System.err.println("sys_message_id in BLOPIN:"+sys_message_id);
							System.err.println("error_text in BLOPIN:"+error_text);*/

							if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
							{
								strValidatedState = "E";
								proc_success="N";
							}
							else
							{
								strValidatedState = "Y";
								proc_success="Y";
							}
						
							call.close();
						}
						catch(Exception e)
						{
							proc_success="N";
							System.err.println("Exception in Procedure GET_VISIT_RULE_BY_CLINIC:"+e);
						}
						
						boolean specialConditionForEmergency=true;
						if(strEpisodeType.equals("E")) {
							specialConditionForEmergency= ("".equals(strOldPractId)==false);
						}

						if( (!strOldClinicCode.equals(strClinicCode)) || (!strOldVstTypeCode.equals(strVisitType)) || 
						((charge_basis_by_physician_yn.equals("Y") && !strOldPractId.equals(strPractitionerId) && specialConditionForEmergency ) || (charge_basis_by_physician_yn.equals("N") && !strOldPractId.equals(strPractitionerId)) ))
						{
							call_revise_proc_YN = "Y";
						}
						else
						{
							call_charge_proc_YN = "Y";
						}	
	
						try
						{
							if(proc_success.equals("Y"))
							{
								CallableStatement call = con.prepareCall("{ call BLVISITCHARGE.GET_APPL_POLICY_SPEC_SERV(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

								call.setString(1,strFacilityId);
								call.setString(2,strPatientId);
								call.setString(3,strEpisodeId);
								call.setString(4,strEpisodeType);
								call.setString(5,strVisitId);
								call.setString(6,strClinicCode);
								call.setString(7,strVisitType);
								call.setString(8,strPractitionerId);
								call.setString(9,service_date);//service_date_time

								call.registerOutParameter(10,java.sql.Types.VARCHAR);
								call.registerOutParameter(11,java.sql.Types.VARCHAR);
								call.registerOutParameter(12,java.sql.Types.VARCHAR);
								call.registerOutParameter(13,java.sql.Types.VARCHAR);
								call.registerOutParameter(14,java.sql.Types.VARCHAR);
								call.registerOutParameter(15,java.sql.Types.VARCHAR);
								call.registerOutParameter(16,java.sql.Types.VARCHAR);
								call.registerOutParameter(17,java.sql.Types.VARCHAR);

								call.execute();

								strAddlChargeType = call.getString(10);
								if(strAddlChargeType == null) strAddlChargeType="";

								dflt_excl_overide_code = call.getString(11);
								if(dflt_excl_overide_code == null) dflt_excl_overide_code="";
							
								strAddlServAvailYN = call.getString(12); 
								if(strAddlServAvailYN == null ) strAddlServAvailYN="N";

								strAddlServPanelInd=call.getString(13);
								if(strAddlServPanelInd==null) strAddlServPanelInd="";

								strAddlServPanelCode=call.getString(14);
								if(strAddlServPanelCode==null) strAddlServPanelCode="";

								error_level=call.getString(15);
								sys_message_id=call.getString(16);
								error_text=call.getString(17);

								if (error_level == null) error_level ="";
								if (sys_message_id ==null) sys_message_id ="";
								if (error_text ==null) error_text ="";

								call.close();

								/*System.err.println("strAddlChargeType:"+strAddlChargeType);
								System.err.println("dflt_excl_overide_code:"+dflt_excl_overide_code);						
								System.err.println("strAddlServAvailYN:"+strAddlServAvailYN);
								System.err.println("strAddlServPanelInd:"+strAddlServPanelInd);
								System.err.println("strAddlServPanelCode:"+strAddlServPanelCode);
								System.err.println("error_level in GET_APPL_POLICY_SPEC_SERV:"+error_level);
								System.err.println("sys_message_id in GET_APPL_POLICY_SPEC_SERV:"+sys_message_id);
								System.err.println("error_text in GET_APPL_POLICY_SPEC_SERV:"+error_text);*/

								if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
								{
									strValidatedState = "E";	
									proc_success="N";
								}
								else
								{
									strValidatedState = "Y";
									proc_success="Y";
								}
							}
						}
						catch(Exception e)
						{
							strValidatedState = "E";
							proc_success="N";
							System.err.println("Exception in GET_APPL_POLICY_SPEC_SERV call:"+e);
						}

					if(proc_success.equals("Y"))
					{
						try
						{
							String hosp_panel_str=(String)session.getAttribute("hosp_panel_str");
							if(hosp_panel_str==null || hosp_panel_str.equals("")) hosp_panel_str="";

							CallableStatement call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	

							call.setString(1,strFacilityId);//facility_id
							call.setString(2,strModuleId);	//module_id
							call.setString(3,strNull); //key
							call.setString(4,strNull); //key_line_no
							call.setString(5,strEpisodeType);//Episode_type
							call.setString(6,strPatientId);//patient_id
							call.setString(7,strEpisodeId);//strEpisodeId
							call.setString(8,strVisitId);
							call.setString(9,strEncounterId);
							call.setInt(10,acc_seq_no);
							call.setString(11,service_date_time);//service_date
							call.setString(12,strNull);//item_code
							call.setString(13,strHospServPanelInd);//service_panel_ind
							call.setString(14,strHospServPanelCode);//service_panel_code
							call.setDouble(15,1);//service_qty
							call.setString(16,strNull);//charge_based_amt
							call.setString(17,strPractitionerTypeInd);//pract_staff_ind
							call.setString(18,strPractitionerId);//pract_staff_id
							call.setString(25,strNull);//excl_incl_action_ind
							call.setString(26,strNull);//action_reason_code
							call.setString(30,locale);//locale
							call.registerOutParameter(19,java.sql.Types.VARCHAR);
							call.registerOutParameter(20,java.sql.Types.VARCHAR);
							call.registerOutParameter(21,java.sql.Types.VARCHAR);
							call.registerOutParameter(22,java.sql.Types.VARCHAR);
							call.registerOutParameter(23,java.sql.Types.VARCHAR);
							call.registerOutParameter(24,java.sql.Types.VARCHAR);
							call.registerOutParameter(27,java.sql.Types.VARCHAR);
							call.registerOutParameter(28,java.sql.Types.VARCHAR);
							call.registerOutParameter(29,java.sql.Types.VARCHAR);	
							call.registerOutParameter(31,java.sql.Types.VARCHAR);
							call.registerOutParameter(32,java.sql.Types.VARCHAR);
							call.registerOutParameter(33,java.sql.Types.VARCHAR);
							call.execute();	
			
							strHospServPanelStr=call.getString(19);	
							/*System.err.println("Charge bases YN in Hospital:"+(String)call.getString(20));		
							System.err.println("Total Amount in Hospital:"+(String)call.getString(21));
							System.err.println("Patient Payable Amount in Hospital:"+(String)call.getString(22));	
							System.err.println("strHospServPanelStr: " + strHospServPanelStr);*/	
							if(strHospServPanelStr==null) strHospServPanelStr="";
	
							error_level=call.getString(31);
							sys_message_id=call.getString(32);
							error_text=call.getString(33);
	
							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";
	
							/*System.err.println("error_level for Hosp_panel:"+error_level);
							System.err.println("sys_message_id for Hosp_panel:"+sys_message_id);
							System.err.println("error_text for Hosp_panel:"+error_text);*/
	
							if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
							{
								strValidatedState = "E";
								proc_success="N";
							}
							else
							{
								strValidatedState = "Y";
								proc_success="Y";
							}
	
							call.close();

							if(hosp_panel_str.equals(""))
							{
								session.setAttribute("hosp_panel_str",strHospServPanelStr);
			//System.err.println("hosp_panel_str in Validation Main IF: "+session.getAttribute("hosp_panel_str"));
							}	
							else
							{
								if(hosp_panel_str_YN.equals("Y"))
								{
									String hosp_panel=(String)session.getAttribute("hosp_panel");
									if(hosp_panel==null || hosp_panel.equals("")) hosp_panel="";

									session.setAttribute("hosp_panel_str",hosp_panel);
			//System.err.println("hosp_panel_str in Validation IF :"+session.getAttribute("hosp_panel_str"));
								}
								else
								{
									session.setAttribute("hosp_panel_str",strHospServPanelStr);
			//System.err.println("hosp_panel_str in Validation ELSE :"+session.getAttribute("hosp_panel_str"));
								}
							}
						}
						catch(Exception e)
						{
							proc_success="N";
							System.err.println("Exception in Hospital:"+e);
						}
					}
//Professional Charge
					if(proc_success.equals("Y"))
					{
						try
						{
							String prof_panel_str=(String)session.getAttribute("prof_panel_str");
							if(prof_panel_str==null || prof_panel_str.equals("")) prof_panel_str="";

							CallableStatement call = con.prepareCall("{ call 	BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");		

							call.setString(1,strFacilityId);//facility_id
							call.setString(2,strModuleId);	//module_id
							call.setString(3,strNull); //key
							call.setString(4,strNull); //key_line_no
							call.setString(5,strEpisodeType);//Episode_type
							call.setString(6,strPatientId);//patient_id
							call.setString(7,strEpisodeId);//strEpisodeId
							call.setString(8,strVisitId);
							call.setString(9,strEncounterId);
							call.setInt(10,acc_seq_no);
							call.setString(11,service_date_time);//service_date
							call.setString(12,strNull);//item_code
							call.setString(13,strMedServPanelInd);//service_panel_ind
							call.setString(14,strMedServPanelCode);//service_panel_code
							call.setDouble(15,1);//service_qty
							call.setString(16,strNull);//charge_based_amt
							call.setString(17,strPractitionerTypeInd);//pract_staff_ind
							call.setString(18,strPractitionerId);//pract_staff_id
							call.setString(25,strNull);//excl_incl_action_ind
							call.setString(26,strNull);//action_reason_code
							call.setString(30,locale);//locale
							call.registerOutParameter(19,java.sql.Types.VARCHAR);
							call.registerOutParameter(20,java.sql.Types.VARCHAR);
							call.registerOutParameter(21,java.sql.Types.VARCHAR);
							call.registerOutParameter(22,java.sql.Types.VARCHAR);
							call.registerOutParameter(23,java.sql.Types.VARCHAR);
							call.registerOutParameter(24,java.sql.Types.VARCHAR);
							call.registerOutParameter(27,java.sql.Types.VARCHAR);
							call.registerOutParameter(28,java.sql.Types.VARCHAR);
							call.registerOutParameter(29,java.sql.Types.VARCHAR);	
							call.registerOutParameter(31,java.sql.Types.VARCHAR);
							call.registerOutParameter(32,java.sql.Types.VARCHAR);
							call.registerOutParameter(33,java.sql.Types.VARCHAR);
							call.execute();	

							strMedServPanelStr=call.getString(19);
							/*System.err.println("Charge bases YN in Medical:"+(String)call.getString(20));
							System.err.println("Total Amount in Medical:"+(String)call.getString(21));
							System.err.println("Patient Payable Amount in Medical:"+(String)call.getString(22));
							System.err.println("strMedServPanelStr:" + strMedServPanelStr);	*/
							if(strMedServPanelStr==null) strMedServPanelStr="";

							error_level=call.getString(31);
							sys_message_id=call.getString(32);
							error_text=call.getString(33);
	
							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";
	
							/*System.err.println("error_level for Hosp_panel:"+error_level);
							System.err.println("sys_message_id for Hosp_panel:"+sys_message_id);
							System.err.println("error_text for Hosp_panel:"+error_text);*/
	
							if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
							{
								strValidatedState = "E";
								proc_success="N";
							}
							else
							{
								strValidatedState = "Y";
								proc_success="Y";
							}
							call.close();
							
							if(prof_panel_str.equals(""))
							{
								session.setAttribute("prof_panel_str",strMedServPanelStr);
			//System.err.println("prof_panel_str in Validation Main IF:"+session.getAttribute("prof_panel_str"));
							}
							else
							{
								if(prof_panel_str_YN.equals("Y"))
								{
									String prof_panel=(String)session.getAttribute("prof_panel");
									if(prof_panel==null || prof_panel.equals("")) prof_panel="";

									session.setAttribute("prof_panel_str",prof_panel);
			//System.err.println("prof_panel_str in Validation IF:"+session.getAttribute("prof_panel_str"));
								}
								else
								{
									session.setAttribute("prof_panel_str",strMedServPanelStr);
			//System.err.println("prof_panel_str in Validation ELSE:"+session.getAttribute("prof_panel_str"));
								}
							}
						}
						catch(Exception exp1)
						{			
							proc_success="N";
							System.err.println("error in Prof"+exp1);
						}
					}

					if(proc_success.equals("Y"))
					{
						try
						{
							String addl_panel_str=(String)session.getAttribute("addl_panel_str");
							if(addl_panel_str==null || addl_panel_str.equals("")) addl_panel_str="";

							CallableStatement call = con.prepareCall("{ call 	BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");		

							call.setString(1,strFacilityId);//facility_id
							call.setString(2,strModuleId);	//module_id
							call.setString(3,strNull); //key
							call.setString(4,strNull); //key_line_no
							call.setString(5,strEpisodeType);//Episode_type
							call.setString(6,strPatientId);//patient_id
							call.setString(7,strEpisodeId);//strEpisodeId
							call.setString(8,strVisitId);
							call.setString(9,strEncounterId);
							call.setInt(10,acc_seq_no);
							call.setString(11,service_date_time);//service_date
							call.setString(12,strNull);//item_code
							call.setString(13,strAddlServPanelInd);//service_panel_ind
							call.setString(14,strAddlServPanelCode);//service_panel_code
							call.setDouble(15,1);//service_qty
							call.setString(16,strNull);//charge_based_amt
							call.setString(17,strPractitionerTypeInd);//pract_staff_ind
							call.setString(18,strPractitionerId);//pract_staff_id
							if(strAddlChargeType.equals("P"))
								{
									call.setString(25,"E");//excl_incl_action_ind
									call.setString(26,dflt_excl_overide_code);//action_reason_code
								}
								else
								{
									call.setString(25,"");//excl_incl_action_ind
									call.setString(26,"");//action_reason_code
								}	
							call.setString(30,locale);//locale
							call.registerOutParameter(19,java.sql.Types.VARCHAR);
							call.registerOutParameter(20,java.sql.Types.VARCHAR);
							call.registerOutParameter(21,java.sql.Types.VARCHAR);
							call.registerOutParameter(22,java.sql.Types.VARCHAR);
							call.registerOutParameter(23,java.sql.Types.VARCHAR);
							call.registerOutParameter(24,java.sql.Types.VARCHAR);
							call.registerOutParameter(27,java.sql.Types.VARCHAR);
							call.registerOutParameter(28,java.sql.Types.VARCHAR);
							call.registerOutParameter(29,java.sql.Types.VARCHAR);	
							call.registerOutParameter(31,java.sql.Types.VARCHAR);
							call.registerOutParameter(32,java.sql.Types.VARCHAR);
							call.registerOutParameter(33,java.sql.Types.VARCHAR);
							call.execute();	

							strAddlServPanelStr=call.getString(19);
							/*System.err.println("Charge bases YN in Addl:"+(String)call.getString(20));
							System.err.println("Total Amount in Addl:"+(String)call.getString(21));
							System.err.println("Patient Payable Amount in Addl:"+(String)call.getString(22));
							System.err.println("strMedServPanelStr:" + strMedServPanelStr);	*/
							if(strAddlServPanelStr==null) strAddlServPanelStr="";

							error_level=call.getString(31);
							sys_message_id=call.getString(32);
							error_text=call.getString(33);
	
							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";
	
							/*System.err.println("error_level for Addl_panel:"+error_level);
							System.err.println("sys_message_id for Addl_panel:"+sys_message_id);
							System.err.println("error_text for Addl_panel:"+error_text);*/
	
							if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
							{
								strValidatedState = "E";
								proc_success="N";
							}
							else
							{
								strValidatedState = "Y";
								proc_success="Y";
							}
							call.close();
							
							if(addl_panel_str.equals(""))
							{
								session.setAttribute("addl_panel_str",strAddlServPanelStr);
				//System.err.println("addl_panel_str in Validation Main IF:"+session.getAttribute("addl_panel_str"));
							}
							else
							{
								if(addl_panel_str_YN.equals("Y"))
								{
									String addl_panel=(String)session.getAttribute("addl_panel");
									if(addl_panel==null || addl_panel.equals("")) addl_panel="";

									session.setAttribute("addl_panel_str",addl_panel);
				//System.err.println("addl_panel_str in Validation IF:"+session.getAttribute("addl_panel_str"));
								}
								else
								{
									session.setAttribute("addl_panel_str",strAddlServPanelStr);
				//System.err.println("addl_panel_str in Validation ELSE:"+session.getAttribute("addl_panel_str"));
								}
							}
						}
						catch(Exception exp1)
						{			
							proc_success="N";
							System.err.println("error in Addl"+exp1);
						}
					}
					
					if(proc_success.equals("Y"))
					{
						try
						{
/*
							String sql="{call blopin.proc_main('"+mode+"','"+functionId+"','"+strFacilityId+"','"+strModuleId+"','"+strClinicCode+"','"+strVisitType+"','"+strNull+"','"+strPatientId+"','"+strEpisodeType+"','"+strEncounterId+"','"+strEpisodeId+"','"+strVisitId+"','"+strPractitionerTypeInd+"','"+strPractitionerId+"','"+strBlnggrpId+"','"+strCustCode+"','"+strPolicyTypeCode+"','"+strPolicyPriority+"','"+strPolicyNumber+"','"+strPolicyStartDate+"','"+strPolicyExpiryDate+"','"+strCreditAuthRef+"','"+strCreditAuthDate+"','"+strEffectiveFrom+"','"+strEffectiveTo+"','"+strApprovedAmt+"','"+strApprovedDays+"','"+strNonInsBlnggrpId+"','"+strNonInsCustCode+"','"+strHospServPanelInd+"','"+strHospServPanelCode+"','"+strHospServPanelStr+"','"+strHospServPanelQty+"','"+strHospServChargeAmt+"','"+strMedServPanelInd+"','"+strMedServPanelCode+"','"+strMedServPanelStr+"',"+strMedServPanelQty+",'"+strMedServChargeAmt+"','"+strUser+"','"+strWsNo+"','"+strWsNo+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?)}";
*/

							if(call_charge_proc_YN.equals("Y"))
							{
								//System.err.println("No Change. Just Charge");		
								//Added By Rajesh V
								
								if("".equals(strCustGroupCode) && "".equals(strCustCode) && "".equals(strPolicyTypeCode)){
									strAcrossGroupEncounter = "";
								}
								else{
									HashMap validAcrossEncMap = (HashMap)session.getAttribute("VALID_ACROSS_ENCOUNTER_MAP");	
									StringTokenizer pcyToken =  new StringTokenizer(strPolicyTypeCode,"|");
									StringTokenizer prtyToken = new StringTokenizer(strPolicyPriority,"|");
									String pcyElement = "";
									String prtyElement = "";
									while(pcyToken.hasMoreTokens()){
										pcyElement = pcyToken.nextToken();
										prtyElement = prtyToken.nextToken();
										if(validAcrossEncMap!=null){
											if(validAcrossEncMap.containsKey(pcyElement+prtyElement)){
												strAcrossGroupEncounter = strAcrossGroupEncounter + (String)validAcrossEncMap.get(pcyElement+prtyElement) + "|";
											}
											else{
												strAcrossGroupEncounter = strAcrossGroupEncounter + " " + "|";
											}
										}
										else{
											strAcrossGroupEncounter = strAcrossGroupEncounter + " " + "|";
										}
									}								
								}
								//System.err.println("strAcrossGroupEncounter->"+strAcrossGroupEncounter);
								//Added By Rajesh V
								String sql="{call BLVisitCharge.proc_main('"+mode+"','"+functionId+"','"+strFacilityId+"','"+strModuleId+"','"+strClinicCode+"','"+strVisitType+"','"+strNull+"','"+strPatientId+"','"+strEpisodeType+"','"+strEncounterId+"','"+strEpisodeId+"','"+strVisitId+"','"+encounter_date_time+"','"+strPractitionerTypeInd+"','"+strPractitionerId+"','"+strBlnggrpId+"','"+strCustGroupCode+"','"+strCustCode+"','"+strPolicyTypeCode+"','"+strPolicyPriority+"','"+strPolicyNumber+"','"+strPolicyStartDate+"','"+strPolicyExpiryDate+"','"+strCreditAuthRef+"','"+strCreditAuthDate+"','"+strEffectiveFrom+"','"+strEffectiveTo+"','"+strApprovedAmt+"','"+strApprovedDays+"','"+strNonInsBlnggrpId+"','"+strNonInsCustGroupCode+"','"+strNonInsCustCode+"','"+strNewHospChrgCreate+"','"+strNewMedChrgCreate+"','"+strNewAddlChrgCreate+"','"+strHospServPanelInd+"','"+strHospServPanelCode+"','"+strHospServPanelStr+"','"+strHospServPanelQty+"','"+strHospServChargeAmt+"','"+strMedServPanelInd+"','"+strMedServPanelCode+"','"+strMedServPanelStr+"','"+strMedServPanelQty+"','"+strMedServChargeAmt+"','"+strAddlServPanelInd+"','"+strAddlServPanelCode+"','"+strAddlServPanelStr+"','"+strAddlServPanelQty+"','"+strAddlServChargeAmt+"','"+str_bill_later_YN+"','"+strUser+"','"+strWsNo+"','"+strWsNo+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+strAcrossGroupEncounter+"')}";

								System.err.println("sql 1070 : "+sql);
								statement=con.prepareCall(sql);

								statement.registerOutParameter( 1, java.sql.Types.VARCHAR);		
								statement.registerOutParameter( 2, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 3, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 4, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 5, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 6, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 7, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 8, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 9, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 10, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 11, java.sql.Types.VARCHAR);								statement.registerOutParameter( 12, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 13, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 14, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 15, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 16, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 17, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 18, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 19, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 20, java.sql.Types.VARCHAR);

								statement.execute();

								hosp_charge_YN= statement.getString(1);
								if(hosp_charge_YN==null || hosp_charge_YN.equals("")) hosp_charge_YN="";

								med_charge_YN= statement.getString(2);
								if(med_charge_YN==null || med_charge_YN.equals("")) med_charge_YN="";

								addl_charge_YN= statement.getString(3);
								if(addl_charge_YN==null || addl_charge_YN.equals("")) addl_charge_YN="";

								exempt_date= statement.getString(4);

								hosp_chrg_amt= statement.getDouble(5);
								hosp_chrg_pat_amt=statement.getDouble(6);
								
								med_chrg_amt= statement.getDouble(7);
								med_chrg_pat_amt=statement.getDouble(8);

								addl_chrg_amt= statement.getDouble(9);
								addl_chrg_pat_amt=statement.getDouble(10);

								bill_gen_yn=statement.getString(11);
								if(bill_gen_yn==null) bill_gen_yn="";
								bill_doc_type=statement.getString(12);
								if(bill_doc_type==null) bill_doc_type="";
								bill_doc_number=statement.getString(13);
								if(bill_doc_number==null) bill_doc_number="";
								str_bill_gen_later=statement.getString(14);
								if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="";
								str_total_bill_amt=statement.getString(15);
								if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";

								error_level=statement.getString(18);
								sys_message_id=statement.getString(19);
								error_text=statement.getString(20);
								if (error_level == null) error_level ="";
								if (sys_message_id ==null) sys_message_id ="";
								if (error_text ==null) error_text ="";
				
								statement.close();
			
/*								System.err.println("hosp_charge_YN:"+hosp_charge_YN);
								System.err.println("med_charge_YN:"+med_charge_YN);
								System.err.println("addl_charge_YN:"+addl_charge_YN);
								System.err.println("hosp_chrg_amt gen from proc_main:"+hosp_chrg_amt);
								System.err.println("hosp_chrg_pat_amt gen from proc_main:"+hosp_chrg_pat_amt);
								System.err.println("med_chrg_amt gen from proc_main:"+med_chrg_amt);
								System.err.println("med_chrg_pat_amt gen from proc_main:"+med_chrg_pat_amt);
								System.err.println("addl_chrg_amt gen from proc_main:"+addl_chrg_amt);
								System.err.println("addl_chrg_pat_amt gen from proc_main:"+addl_chrg_pat_amt);
								System.err.println("exempt_date:"+exempt_date);
								System.err.println("bill_gen_yn:"+bill_gen_yn);
								System.err.println("bill_doc_type:"+bill_doc_type);
								System.err.println("bill_doc_number:"+bill_doc_number);
								System.err.println("str_bill_gen_later:"+str_bill_gen_later);
								System.err.println("str_total_bill_amt:"+str_total_bill_amt);

								System.err.println("error_level:"+error_level);
								System.err.println("sys_message_id:"+sys_message_id);
								System.err.println("error_text:"+error_text);
*/
							}
							else if (call_revise_proc_YN.equals("Y"))
							{
								//System.err.println("On Change of Clinic/Visit/Practitoner");
								String sql_revise_visit="{call blvisitrevise.proc_main('"+mode+"','"+functionId+"','"+strFacilityId+"','"+strModuleId+"','"+strClinicCode+"','"+strVisitType+"','"+strVisitType+"','"+strNull+"','"+strPatientId+"','"+strEpisodeType+"','"+strEncounterId+"','"+strEpisodeId+"','"+strVisitId+"','"+strPractitionerTypeInd+"','"+strPractitionerId+"','"+strBlnggrpId+"','"+strCustGroupCode+"','"+strCustCode+"','"+strPolicyTypeCode+"','"+strPolicyPriority+"','"+strPolicyNumber+"','"+strPolicyStartDate+"','"+strPolicyExpiryDate+"','"+strCreditAuthRef+"','"+strCreditAuthDate+"','"+strEffectiveFrom+"','"+strEffectiveTo+"','"+strApprovedAmt+"','"+strApprovedDays+"','"+strNonInsBlnggrpId+"','"+strNonInsCustGroupCode+"','"+strNonInsCustCode+"','"+strHospServPanelInd+"','"+strHospServPanelCode+"','"+strHospServPanelStr+"','"+strHospServPanelQty+"','"+strHospServChargeAmt+"','"+strMedServPanelInd+"','"+strMedServPanelCode+"','"+strMedServPanelStr+"','"+strMedServPanelQty+"','"+strMedServChargeAmt+"','"+strAddlServPanelInd+"','"+strAddlServPanelCode+"','"+strAddlServPanelStr+"','"+strAddlServPanelQty+"','"+strAddlServChargeAmt+"','"+str_bill_later_YN+"','"+strUser+"','"+strWsNo+"','"+strWsNo+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
							

								//System.err.println("sql : 1161 "+sql_revise_visit);
								statement=con.prepareCall(sql_revise_visit);

								statement.registerOutParameter( 1, java.sql.Types.VARCHAR);		
								statement.registerOutParameter( 2, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 3, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 4, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 5, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 6, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 7, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 8, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 9, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 10, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 11, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 12, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 13, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 14, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 15, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 16, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 17, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 18, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 19, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 20, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 21, java.sql.Types.VARCHAR);
								statement.registerOutParameter( 22, java.sql.Types.VARCHAR);

								statement.execute();

								hosp_charge_YN= statement.getString(1);
								if(hosp_charge_YN==null || hosp_charge_YN.equals("")) hosp_charge_YN="";

								med_charge_YN= statement.getString(2);
								if(med_charge_YN==null || med_charge_YN.equals("")) med_charge_YN="";

								addl_charge_YN= statement.getString(3);
								if(addl_charge_YN==null || addl_charge_YN.equals("")) addl_charge_YN="";

								exempt_date= statement.getString(4);

								hosp_chrg_amt= statement.getDouble(5);
								hosp_chrg_pat_amt=statement.getDouble(6);
								
								med_chrg_amt= statement.getDouble(7);
								med_chrg_pat_amt=statement.getDouble(8);

								addl_chrg_amt= statement.getDouble(9);
								addl_chrg_pat_amt=statement.getDouble(10);

								bill_gen_yn=statement.getString(12);
								if(bill_gen_yn==null) bill_gen_yn="";
								bill_doc_type=statement.getString(13);
								if(bill_doc_type==null) bill_doc_type="";
								bill_doc_number=statement.getString(14);
								if(bill_doc_number==null) bill_doc_number="";

								tot_bill_text = statement.getString(15);
								if(tot_bill_text == null) tot_bill_text="";

								str_bill_gen_later=statement.getString(16);
								if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="";
								str_total_bill_amt=statement.getString(17);
								if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";
		
								error_level=statement.getString(20);
								sys_message_id=statement.getString(21);
								error_text=statement.getString(22);

								if (error_level == null) error_level ="";
								if (sys_message_id ==null) sys_message_id ="";
								if (error_text ==null) error_text ="";
				
								statement.close();

/*								System.err.println("hosp_charge_YN:"+hosp_charge_YN);
								System.err.println("med_charge_YN:"+med_charge_YN);
								System.err.println("addl_charge_YN:"+addl_charge_YN);
								System.err.println("hosp_chrg_amt gen from proc_main:"+hosp_chrg_amt);
								System.err.println("hosp_chrg_pat_amt gen from proc_main:"+hosp_chrg_pat_amt);
								System.err.println("med_chrg_amt gen from proc_main:"+med_chrg_amt);
								System.err.println("med_chrg_pat_amt gen from proc_main:"+med_chrg_pat_amt);
								System.err.println("addl_chrg_amt gen from proc_main:"+addl_chrg_amt);
								System.err.println("addl_chrg_pat_amt gen from proc_main:"+addl_chrg_pat_amt);
								System.err.println("exempt_date:"+exempt_date);
								System.err.println("bill_gen_yn:"+bill_gen_yn);
								System.err.println("bill_gen_yn:"+bill_gen_yn);
								System.err.println("bill_doc_type:"+bill_doc_type);
								System.err.println("bill_doc_number:"+bill_doc_number);
								System.err.println("tot_bill_text:"+tot_bill_text);
								System.err.println("str_bill_gen_later:"+str_bill_gen_later);
								System.err.println("str_total_bill_amt:"+str_total_bill_amt);

								System.err.println("error_level:"+error_level);
								System.err.println("sys_message_id:"+sys_message_id);
								System.err.println("error_text:"+error_text);
*/
							}

/*
							if(error_text.equals("") && (error_level.equals("") || !error_level.equals(10)) && sys_message_id.equals(""))
							{
								strValidatedState = "Y";
							}	
							else
							{
								strValidatedState = "E";	
							}
*/
							if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
							{
								strValidatedState = "E";
								proc_success="N";
							}
							else
							{
								strValidatedState = "Y";
								proc_success="Y";
							}

							str_hosp_chrg_amt=String.valueOf(hosp_chrg_amt);
							str_hosp_chrg_pat_amt=String.valueOf(hosp_chrg_pat_amt);
							str_med_chrg_amt=String.valueOf(med_chrg_amt);
							str_med_chrg_pat_amt=String.valueOf(med_chrg_pat_amt);
							str_addl_chrg_amt=String.valueOf(addl_chrg_amt);
							str_addl_chrg_pat_amt=String.valueOf(addl_chrg_pat_amt);
						
							String upd_hosp_chrg_amt=(String)session.getAttribute("upd_hosp_chrg_amt");
							if(upd_hosp_chrg_amt!=null)
							{
								str_hosp_chrg_amt=upd_hosp_chrg_amt;
								hosp_chrg_amt=Double.parseDouble(str_hosp_chrg_amt);
							}
				
							String upd_med_chrg_amt=(String)session.getAttribute("upd_med_chrg_amt");
							if(upd_med_chrg_amt!=null)
							{
								str_med_chrg_amt=upd_med_chrg_amt;
								med_chrg_amt=Double.parseDouble(str_med_chrg_amt);
							}

							String upd_hosp_chrg_pat_amt=(String)session.getAttribute("upd_hosp_chrg_pat_amt");
							if(upd_hosp_chrg_pat_amt!=null)
							{
								str_hosp_chrg_pat_amt=upd_hosp_chrg_pat_amt;
								hosp_chrg_pat_amt=Double.parseDouble(str_hosp_chrg_pat_amt);
							}

							String upd_med_chrg_pat_amt=(String)session.getAttribute("upd_med_chrg_pat_amt");
							if(upd_med_chrg_pat_amt!=null)
							{
								str_med_chrg_pat_amt=upd_med_chrg_pat_amt;
								med_chrg_pat_amt=Double.parseDouble(str_med_chrg_pat_amt);
							}

							try
							{
								CurrencyFormat cf1 = new CurrencyFormat();
		
								if (str_hosp_chrg_amt!=null)
								    str_hosp_chrg_amt = cf1.formatCurrency(str_hosp_chrg_amt, noofdecimal);
								if(str_med_chrg_amt!=null)
								    str_med_chrg_amt = cf1.formatCurrency(str_med_chrg_amt, noofdecimal);
								if(str_addl_chrg_amt!=null)
								    str_addl_chrg_amt = cf1.formatCurrency(str_addl_chrg_amt, noofdecimal);
								if(str_hosp_chrg_pat_amt!=null)
									str_hosp_chrg_pat_amt = cf1.formatCurrency(str_hosp_chrg_pat_amt, noofdecimal);
								if(str_med_chrg_pat_amt!=null)
									str_med_chrg_pat_amt = cf1.formatCurrency(str_med_chrg_pat_amt, noofdecimal);		
								if(str_addl_chrg_pat_amt!=null)
									str_addl_chrg_pat_amt = cf1.formatCurrency(str_addl_chrg_pat_amt, noofdecimal);		
							}
							catch(Exception e)
							{
								System.err.println("Currency exception ::"+e);
							}
	
							if(exempt_date!=null && !exempt_date.equals(""))
							{	
								strExemptdate=vst_chrg_exmpt_leg+" "+exempt_date;
							}
						
							HashMap hosp_dtls_check=(HashMap)session.getAttribute("hosp_dtls");
							if(hosp_dtls_check==null)
							{
								hosp_dtls.put("hosp_serv_panel_ind",strHospServPanelInd);
								hosp_dtls.put("hosp_serv_panel_code",strHospServPanelCode);
								hosp_dtls.put("hosp_serv_panel_str",strHospServPanelStr);
								hosp_dtls.put("hosp_serv_panel_qty",String.valueOf(strHospServPanelQty));
								hosp_dtls.put("hosp_serv_chrg_amt",String.valueOf(strHospServChargeAmt));
								session.setAttribute("hosp_dtls",hosp_dtls);
							}
							//System.err.println("hosp_dtls: "+session.getAttribute("hosp_dtls"));
	
							HashMap prof_dtls_check=(HashMap)session.getAttribute("prof_dtls");
							if(prof_dtls_check==null)
							{
								prof_dtls.put("prof_serv_panel_ind",strMedServPanelInd);
								prof_dtls.put("prof_serv_panel_code",strMedServPanelCode);
								prof_dtls.put("prof_serv_panel_str",strMedServPanelStr);
								prof_dtls.put("prof_serv_panel_qty",String.valueOf(strMedServPanelQty));
								prof_dtls.put("prof_serv_chrg_amt",String.valueOf(strMedServChargeAmt));
								session.setAttribute("prof_dtls",prof_dtls);
							}
							//System.err.println("prof_dtls: "+session.getAttribute("prof_dtls"));

							HashMap addl_dtls_check=(HashMap)session.getAttribute("addl_dtls");
							if(addl_dtls_check==null)
							{
								addl_dtls.put("addl_serv_panel_ind",strAddlServPanelInd);
								addl_dtls.put("addl_serv_panel_code",strAddlServPanelCode);
								addl_dtls.put("addl_serv_panel_str",strAddlServPanelStr);
								addl_dtls.put("addl_serv_panel_qty",String.valueOf(strAddlServPanelQty));
								addl_dtls.put("addl_serv_chrg_amt",String.valueOf(strAddlServChargeAmt));
								session.setAttribute("addl_dtls",addl_dtls);
							}
							//System.err.println("addl_dtls: "+session.getAttribute("addl_dtls"));
	
						}
						catch(Exception e)
						{
							proc_success="N";
							System.err.println("Exception IN PROC MAIN:"+e);
							out.println("Exception IN PROC MAIN:"+e);
						}
					}
				}
			}
		}
	}

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_after_reg));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strStartValid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strValidatedState));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strClinicCode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strVisitType));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strPractitionerId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strPractitionerTypeInd));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strUser));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(error_text));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(error_level));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sys_message_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strBlnggrpId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strCustGroupCode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strCustCode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strPolicyPriority));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPolicyTypeCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strPolicyNumber));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strPolicyStartDate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strPolicyExpiryDate));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strCreditAuthRef));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strCreditAuthDate));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strApprovedDays));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strApprovedAmt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strEffectiveFrom));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strEffectiveTo));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strNonInsBlnggrpId));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strNonInsCustGroupCode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strNonInsCustCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strNursingUnitCode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strNursingUnitType));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strBedClass));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strBedType));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strBedNo));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strSettlementInd));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strDepositApplYN));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strAddlDepositApplYN));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strDepositAmt));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strAddlDepositAmt));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(hosp_charge_YN));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(med_charge_YN));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(addl_charge_YN));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strExemptdate));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strBillGen));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strHospServPanelInd));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(strHospServPanelCode));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(strHospServPanelQty));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strHospServChargeAmt));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strMedServPanelInd));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strMedServPanelCode));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strMedServPanelQty));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(strMedServChargeAmt));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strAddlServPanelInd));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(strAddlServPanelCode));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(strAddlServPanelQty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(strAddlServChargeAmt));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(str_hosp_chrg_amt));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(str_hosp_chrg_pat_amt));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(str_med_chrg_amt));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(str_med_chrg_pat_amt));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(str_addl_chrg_amt));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(str_addl_chrg_pat_amt));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(ae_bed_charge_appl_yn));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(charge_net_amt));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(patientPayble));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(ae_bed_calYN));
            _bw.write(_wl_block82Bytes, _wl_block82);

	}
	catch(Exception e)
	{
		System.err.println("Main Exception:"+e);
		out.println("Main Exception:"+e);
	}
	finally
	{ 
		con.rollback();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block83Bytes, _wl_block83);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
