package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.util.*;
import com.ehis.util.*;

public final class __blvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLValidation.jsp", 1742753329890L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<Script Language=\"JavaScript\">\n\n\tfunction funClose()\n\t{\n\t\tvar state = document.forms[0].validated_state.value;\n\t\tvar strSpecialistClinicYN = document.forms[0].strSpecialistClinicYN.value;\n\t\tvar strSpecialistCashCntrYN = document.forms[0].strSpecialistCashCntrYN.value;\n\n\t\tif (state == \"Y\") \n\t\t{\n\t\t\tparent.frames[0].document.getElementById(\'close_button\').click();\n\t\t}\n\t\tif (state == \"E\") \n\t\t{\n\t\t\tif(document.forms[0].error_message.value!=null && document.forms[0].error_level.value==\"10\")\n\t\t\t{\n\t\t\t\talert(document.forms[0].error_message.value);\n\t\t\t}\n\t\t\telse if(document.forms[0].sys_message_id.value!=null && document.forms[0].sys_message_id.value!=\'\')\n\t\t\t{\n\t\t\t\tvar sys_message_id=document.forms[0].sys_message_id.value;\n\t\t\t\talert(getMessage(sys_message_id,\"BL\"));\n\t\t\t}\n/*\n\t\t\telse if(strSpecialistClinicYN == \'Y\' && strSpecialistCashCntrYN == \'N\')\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6241\",\"BL\"));\n\t\t\t}\n\t\t\telse if(strSpecialistClinicYN == \'N\' && strSpecialistCashCntrYN == \'Y\')\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6240\",\"BL\"));\n\t\t\t}\n*/\n\t\t\tparent.ValidFrame.document.forms[0].validated_state.value = \"N\";\n\t\t}\n\t\t\n\t}\n</Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n<!-- <body onLoad=\"funClose();\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">-->\n<body onLoad=\"setTimeout(funClose(),500);\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form name=\'PatFinValidationForm\' id=\'PatFinValidationForm\' method=\'post\'  action=\'BLValidation.jsp\'   >\n\n<input type= \'hidden\' name=\"noofdecimal\" id=\"noofdecimal\"  value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n<input type= \'hidden\' name=\"disaster_regn_YN\" id=\"disaster_regn_YN\"  value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n\n\n<input type=\"hidden\" name=\"start_valid\" id=\"start_valid\"  value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"> </input>\n<input type=\"hidden\" name=\"validated_state\" id=\"validated_state\"  value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></input>\n<input type=\"hidden\" name=\"clinic_code\" id=\"clinic_code\"  value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></input>\n<input type=\"hidden\" name=\"visit_type_code\" id=\"visit_type_code\"   value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"></input>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"   value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></input>\n<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"></input>\n<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></input>\n<input type=\"hidden\" name=\"visit_id\" id=\"visit_id\"     value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></input>\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"     value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></input>\n<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\"     value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></input>\n<input type=\"hidden\" name=\"practitioner_type_ind\" id=\"practitioner_type_ind\"     value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></input>\n<input type=\"hidden\" name=\"calling_module_id\" id=\"calling_module_id\"     value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></input>\n<input type=\"hidden\" name=\"calling_function_id\" id=\"calling_function_id\"     value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></input>\n<input type=\"hidden\" name=\"logged_user_id\" id=\"logged_user_id\"     value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></input>\n<input type=\"hidden\" name=\"error_message\" id=\"error_message\"     value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"></input>\n<input type=\"hidden\" name=\"error_level\" id=\"error_level\"     value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></input>\n<input type=\"hidden\" name=\"sys_message_id\" id=\"sys_message_id\"     value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></input>\n\n<input type=\"hidden\" name=\"encounter_date_time\" id=\"encounter_date_time\"     value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></input>\n<input type=\"hidden\" name=\"rtn_pat_ser_code\" id=\"rtn_pat_ser_code\"     value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"></input>\n<input type=\'hidden\' name=\'charge_for_pat_regn_yn\' id=\'charge_for_pat_regn_yn\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\n<input type=\"hidden\" name=\"billing_group\" id=\"billing_group\"  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></input>\n<input type=\"hidden\" name=\"cust_group_code\" id=\"cust_group_code\"  value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"></input>\n<input type=\"hidden\" name=\"cust_code\" id=\"cust_code\"  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></input>\n<input type=\'hidden\' name=\'policy_priority\' id=\'policy_priority\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'policy_type_code\' id=\'policy_type_code\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'policy_no\' id=\'policy_no\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'policy_start_date\' id=\'policy_start_date\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'credit_auth_ref\' id=\'credit_auth_ref\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'credit_auth_date\' id=\'credit_auth_date\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'credit_approval_days\' id=\'credit_approval_days\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'credit_approval_amount\' id=\'credit_approval_amount\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'policy_eff_from_date\' id=\'policy_eff_from_date\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'policy_eff_to_date\' id=\'policy_eff_to_date\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'non_ins_blng_grp_id\' id=\'non_ins_blng_grp_id\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'non_ins_cust_group_code\' id=\'non_ins_cust_group_code\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'non_ins_cust_code\' id=\'non_ins_cust_code\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\n<input type=\"hidden\" name=\"p_nursing_unit_code\" id=\"p_nursing_unit_code\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"></input>\n<input type=\"hidden\" name=\"p_nursing_unit_type_code\" id=\"p_nursing_unit_type_code\"    value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"></input>\n<input type=\"hidden\" name=\"p_bed_class_code\" id=\"p_bed_class_code\"\t\t value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"></input>\t\n<input type=\"hidden\" name=\"p_bed_type_code\" id=\"p_bed_type_code\"\t\t\t value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"></input>\t\n<input type=\"hidden\" name=\"p_bed_no\" id=\"p_bed_no\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></input>\t\n<input type=\"hidden\" name=\"p_settlement_ind\" id=\"p_settlement_ind\"\t\t value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"></input>\t\n<input type=\"hidden\" name=\"p_deposit_appl_yn\" id=\"p_deposit_appl_yn\"\t value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></input>\t\n<input type=\"hidden\" name=\"p_addl_dep_reqd_yn\" id=\"p_addl_dep_reqd_yn\"\t value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"></input>\t\n<input type=\"hidden\" name=\"p_dep_amt\" id=\"p_dep_amt\"\t value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"></input>\t\n<input type=\"hidden\" name=\"p_tot_dep_amt\" id=\"p_tot_dep_amt\"\t value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"></input>\t\n<input type=\"hidden\" name=\"p_calculated_yn\" id=\"p_calculated_yn\"\t value=\"N\"></input>\t\n\n\n<input type=\"hidden\" name=\"hospvisitchargeYN\" id=\"hospvisitchargeYN\"\t value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"></input>\n<input type=\"hidden\" name=\"medvisitchargeYN\" id=\"medvisitchargeYN\"\t value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"></input>\n<input type=\"hidden\" name=\"addlvisitchargeYN\" id=\"addlvisitchargeYN\"\t value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"></input>\n<input type=\"hidden\" name=\"exempt_date\" id=\"exempt_date\"\t value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"></input>\n<input type=\"hidden\" name=\"bill_gen\" id=\"bill_gen\"\t value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"></input>\n\n<input type=\"hidden\" name=\"hosp_serv_panel_ind\" id=\"hosp_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"></input>\t\n<input type=\"hidden\" name=\"hosp_serv_panel_code\" id=\"hosp_serv_panel_code\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"></input>\t\n<input type=\"hidden\" name=\"hosp_serv_panel_qty\" id=\"hosp_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"></input>\n<input type=\"hidden\" name=\"hosp_serv_chrg_amt\" id=\"hosp_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"></input>\n\n<input type=\"hidden\" name=\"med_serv_panel_ind\" id=\"med_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"></input>\t\n<input type=\"hidden\" name=\"med_serv_panel_code\" id=\"med_serv_panel_code\"\t value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"></input>\t\n<input type=\"hidden\" name=\"med_serv_panel_qty\" id=\"med_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"></input>\n<input type=\"hidden\" name=\"med_serv_chrg_amt\" id=\"med_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"></input>\n\n<input type=\"hidden\" name=\"addl_serv_panel_ind\" id=\"addl_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"></input>\t\n<input type=\"hidden\" name=\"addl_serv_panel_code\" id=\"addl_serv_panel_code\"\t value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"></input>\t\n<input type=\"hidden\" name=\"addl_serv_panel_qty\" id=\"addl_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"></input>\n<input type=\"hidden\" name=\"addl_serv_chrg_amt\" id=\"addl_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"></input>\n\n<input type=\"hidden\" name=\"str_hosp_chrg_amt\" id=\"str_hosp_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"></input>\n<input type=\"hidden\" name=\"str_hosp_chrg_pat_amt\" id=\"str_hosp_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"></input>\n<input type=\"hidden\" name=\"str_med_chrg_amt\" id=\"str_med_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"></input>\n<input type=\"hidden\" name=\"str_med_chrg_pat_amt\" id=\"str_med_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"></input>\n<input type=\"hidden\" name=\"str_addl_chrg_amt\" id=\"str_addl_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"></input>\n<input type=\"hidden\" name=\"str_addl_chrg_pat_amt\" id=\"str_addl_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"></input>\n<input type=\'hidden\' name=\'str_epi_type_clinic_code\' id=\'str_epi_type_clinic_code\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\n<input type=\"hidden\" name=\"strSpecialistClinicYN\" id=\"strSpecialistClinicYN\"\t value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"></input>\n<input type=\"hidden\" name=\"strSpecialistCashCntrYN\" id=\"strSpecialistCashCntrYN\"\t value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"></input>\n\n<input type=\"hidden\" name=\"strOrderCtlgCode\" id=\"strOrderCtlgCode\"\t value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" /><!-- Added V190403-Aravindh/GHL-CRF-0525 -->\n<input type=\"hidden\" name=\"strOrderCtlgDtls\" id=\"strOrderCtlgDtls\"\t value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" /><!-- Added V190403-Aravindh/GHL-CRF-0525 -->\n<input type=\"hidden\" name=\"strOrderCtlgTotal\" id=\"strOrderCtlgTotal\"\t value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" /><!-- Added V190403-Aravindh/GHL-CRF-0525 -->\n<input type=\"hidden\" name=\"chkOrderCtlgAmt\" id=\"chkOrderCtlgAmt\"\t \t value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" /><!-- Added V190403-Aravindh/GHL-CRF-0525 -->\n<input type=\"hidden\" name=\"mcn_for_policy\" id=\"mcn_for_policy\" value=\"\" /> <!--V220908-->\n<input type=\"hidden\" name=\"reg_ref_id\" id=\"reg_ref_id\" value=\"\" /> <!--V230315-->\n<input type=\"hidden\" name=\"rtn_reg_referral_flag\" id=\"rtn_reg_referral_flag\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" /> <!--V230616-->\n<input type=\"hidden\" name=\"userId_for_priv\" id=\"userId_for_priv\" value=\"\" /> <!--V230707-->\n<input type=\"hidden\" name=\"reasonCode_for_priv\" id=\"reasonCode_for_priv\" value=\"\" /> <!--V230707-->\n</form>\t  \n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

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
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1           V230616						MMS-DM-SCF-0886 		Namrata Charate
 2			 V230707						AAKH-CRF-0142.1			Namrata Charate
 */ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con = null;
	//PreparedStatement pstmt = null ;
	CallableStatement statement = null;
	CallableStatement call = null;

	//ResultSet rs = null;
	//ResultSet rs1 = null;
	Statement stmt=null;
	PreparedStatement pstmt = null ;
	ResultSet rs=null;


//		HttpSession session = request.getSession(false);
	String disaster_regn_YN="";
	String strStartValid =  "";
	String strClinicCode = "";
	String strVisitType = "";
	String strBLInterfaceYN = "";
	String strPatientId ="";
	String strPatSerCode="", charge_for_pat_regn_yn="N";
	String strEpisodeId ="";
	String strVisitId = "";
	String strEncounterId="";
	String strSpecialistClinicYN="", strSpecialistCashCntrYN="";
	String strCashCounter="";String vst_bill_yn = "";

	int noofdecimal=2;

//	long encounter_id=0;
	String strPractitionerId="";
	String strPractitionerTypeInd="";

	String strEpisodeType = "";
	String strFacilityId = "";
	String strUser ="";
	String strWsNo = "";
	String strValidatedState="N";
	String mode="C";
	String strFunctionId="";
	
	String strBlnggrpId ="";
	String strCustGroupCode = "";
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
	HashMap fin_dtls_to_chrg_dtls=new HashMap();
		
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

//	String strHospVisitCharge = "";
//	String strMedVisitCharge = "";
	String strExemptdate ="";
	String strBillGen="";

	String strNewHospChrgCreate="";
	String strNewMedChrgCreate="";
	String strNewAddlChrgCreate="";

	String strHospServPanelInd="";
	String strHospServPanelCode="";
	String strHospServPanelStr="";
//	double strHospServPanelQty=1.0;
//	double strHospServChargeAmt=0.0;
	String strHospServPanelQty="1.0";
	String strHospServChargeAmt="";

	String strMedServPanelInd="";
	String strMedServPanelCode="";
	String strMedServPanelStr="";
//	double strMedServPanelQty=1.0;
//	double strMedServChargeAmt=0.0;
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
	
	int acc_seq_no=1;

	String exempt_date="";
//	String charge_YN="";
	String hosp_charge_YN="";
	String med_charge_YN="";
	String addl_charge_YN="";

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
	
	String bill_gen_yn="";
	String bill_doc_type="";
	String bill_doc_number="";

	String str_bill_later_YN="N";
	String str_bill_gen_later="";
	String str_total_bill_amt="";
		String regn_charge_YN ="";

	String error_level="";
	String sys_message_id="";
	String error_text="";
	String reg_referral_flag="N";   //V230616

	HashMap hosp_dtls=new HashMap();
	HashMap prof_dtls=new HashMap();
	HashMap addl_dtls=new HashMap();

	String service_date="", encounter_date_time="";

	HttpSession httpSession = request.getSession(false);

	String locale			= (String)session.getAttribute("LOCALE");

	Properties p = (Properties)httpSession.getValue("jdbc");	

	String proc_success="N";

	String hosp_panel_str_YN=(String)session.getAttribute("hosp_panel_str_YN");
	if(hosp_panel_str_YN==null) hosp_panel_str_YN="";

	String prof_panel_str_YN=(String)session.getAttribute("prof_panel_str_YN");
	if(prof_panel_str_YN==null) prof_panel_str_YN="";

	String addl_panel_str_YN=(String)session.getAttribute("addl_panel_str_YN");
	if(addl_panel_str_YN==null) addl_panel_str_YN="";

	String str_epi_type_clinic_code="";

//	String hosp_chrg_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.HOSP_CHRG.label","bl_labels");
//	String prof_chrg_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PROF_CHRG.label","bl_labels");
	String vst_chrg_exmpt_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VISIT_CHRG_EXEMPT_UPTO.label","bl_labels");	
//	String bill_gen_yn_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PLS_NOTE_DOWN_THE_BILL.label","bl_labels");	
//	String bill_gen_yn_leg1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.FOR_THE_VISIT_CHRG.label","bl_labels");	

	boolean chkOrderCtlgAmt = false;//Added V190403-Aravindh/GHL-CRF-0525
	String orderCatalogCodeStr = "", orderCtlgDtls = "", orderCtlgTotal = "";//Added V190403-Aravindh/GHL-CRF-0525
	
	try
	{
		// Added getting connection in the main try on Bangalore  13/10/2005  
		con = ConnectionManager.getConnection(request);
		request.setCharacterEncoding("UTF-8");
//		System.err.println("****inside BLValidation******");

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI') from sm_acc_entity_param where acc_entity_id='ZZ'");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);
				service_date = rscurr.getString(2);
			}
			if(rscurr != null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.err.println("Exception in No of Decimal Query="+e.toString());
		}	
		
		/* Added V190403-Aravindh/GHL-CRF-0525/Starts */
		try {
			chkOrderCtlgAmt = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_CALC_AMT_ORD_CTLG_YN");
		} catch(Exception ex) {
			System.err.println("Error in BLValidation.jsp: "+ex);
			ex.printStackTrace();
		}
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */

		strModuleId =   request.getParameter("calling_module_id") ;
		if (strModuleId == null) strModuleId="";

		charge_for_pat_regn_yn= request.getParameter("charge_for_pat_regn_yn");
		if (charge_for_pat_regn_yn == null) charge_for_pat_regn_yn="N";

		if (strModuleId.equals("OP")||strModuleId.equals("AE") || (strModuleId.equals("MP") && charge_for_pat_regn_yn.equals("Y")))
		{
			strStartValid =  request.getParameter("start_valid") ;
//			System.err.println("strStartValid;"+strStartValid);
			if (strStartValid == null) strStartValid="N";

			if (strStartValid.equals("Y"))
			{
				disaster_regn_YN=request.getParameter("disaster_regn_YN") ;
				if (disaster_regn_YN == null || disaster_regn_YN.equals("")) disaster_regn_YN="";

				strFunctionId=  request.getParameter("calling_function_id") ;
				if (strFunctionId == null) strFunctionId="";

				strClinicCode = request.getParameter("clinic_code") ;
				if (strClinicCode == null) strClinicCode="";

				strVisitType = request.getParameter("visit_type_code") ;
				if (strVisitType == null) strVisitType="";
		
				strBLInterfaceYN = request.getParameter("billing_interface_yn") ;
				if (strBLInterfaceYN == null) strBLInterfaceYN="";
		
				strPatientId = request.getParameter("patient_id") ;
				if (strPatientId == null) strPatientId="";
		
				strEpisodeId =request.getParameter("episode_id");
				if (strEpisodeId == null || strEpisodeId.equals("")) strEpisodeId="0";
		
				strVisitId =request.getParameter("visit_id");
				if (strVisitId == null || strVisitId.equals("")) strVisitId="0";
		
				strEpisodeType = request.getParameter("episode_type");
				if (strEpisodeType == null) strEpisodeType="";
		
				strEncounterId=request.getParameter("encounter_id");
				if (strEncounterId == null) strEncounterId="";
		
				strFacilityId = request.getParameter("facility_id");
				if (strFacilityId == null) strFacilityId="";

				strPractitionerId = request.getParameter("practitioner_id");
				if (strPractitionerId == null) strPractitionerId="";
		
				strPractitionerTypeInd = request.getParameter("practitioner_type_ind");
				if (strPractitionerTypeInd == null) strPractitionerTypeInd="";

				strUser = request.getParameter("logged_user_id");
				if (strUser == null) strUser = "";

				strWsNo     =  p.getProperty("client_ip_address");
				if(strWsNo == null) strWsNo="";
			
				strBlnggrpId=request.getParameter("billing_group");
				if (strBlnggrpId == null) strBlnggrpId="";

				strCustGroupCode=request.getParameter("cust_group_code");
				if (strCustGroupCode == null) strCustGroupCode="";

				strCustCode=request.getParameter("cust_code");
				if (strCustCode == null) strCustCode="";

				strPolicyPriority=request.getParameter("policy_priority");
				if (strPolicyPriority == null) strPolicyPriority="";
		
				strPolicyTypeCode=request.getParameter("policy_type_code");
				if (strPolicyTypeCode == null) strPolicyTypeCode="";

				strPolicyNumber=request.getParameter("policy_no");
				if (strPolicyNumber == null) strPolicyNumber="";
		
				strPolicyStartDate=request.getParameter("policy_start_date");
				if (strPolicyStartDate == null) strPolicyStartDate="";

				strPolicyExpiryDate=request.getParameter("policy_expiry_date");
				if (strPolicyExpiryDate == null) strPolicyExpiryDate="";
		
				strCreditAuthRef=request.getParameter("credit_auth_ref");
				if (strCreditAuthRef == null) strCreditAuthRef="";
		
				strCreditAuthDate=request.getParameter("credit_auth_date");
				if (strCreditAuthDate == null) strCreditAuthDate="";
		
				strApprovedDays=request.getParameter("credit_approval_days");
				if (strApprovedDays == null) strApprovedDays="";
		
				strApprovedAmt=request.getParameter("credit_approval_amount");
				if (strApprovedAmt == null) strApprovedAmt="";
		
				strEffectiveFrom=request.getParameter("policy_eff_from_date");
				if (strEffectiveFrom == null) strEffectiveFrom="";
		
				strEffectiveTo=request.getParameter("policy_eff_to_date");
				if (strEffectiveTo == null) strEffectiveTo="";
			
				strNonInsBlnggrpId=request.getParameter("non_ins_blng_grp_id");
				if (strNonInsBlnggrpId == null) strNonInsBlnggrpId="";

				strNonInsCustGroupCode=request.getParameter("non_ins_cust_group_code");
				if (strNonInsCustGroupCode == null) strNonInsCustGroupCode="";

				strNonInsCustCode=request.getParameter("non_ins_cust_code");
				if (strNonInsCustCode == null) strNonInsCustCode="";

				encounter_date_time = request.getParameter("encounter_date_time");
				if (encounter_date_time == null) encounter_date_time="";
				
				orderCatalogCodeStr = request.getParameter("strOrderCtlgCode");//Added V190403-Aravindh/GHL-CRF-0525
				if (orderCatalogCodeStr == null) orderCatalogCodeStr="";//Added V190403-Aravindh/GHL-CRF-0525

/* Commented the Conversion as the date is fetched in english always, hence no need for conversion. Commented for IN023909 on 05/10/2010 by maniveln
				if(!encounter_date_time.equals(""))
				{
					encounter_date_time = com.ehis.util.DateUtils.convertDate(encounter_date_time,"DMYHM",locale,"en") ;
				}
*/
				strPatSerCode = request.getParameter("rtn_pat_ser_code");
				if (strPatSerCode == null) strPatSerCode="";
				
				reg_referral_flag = request.getParameter("rtn_reg_referral_flag");  //V230616
				if (reg_referral_flag == null) reg_referral_flag="";
				System.err.println("reg_referral_flag is: "+reg_referral_flag);
				
				
/* Karthik added for Change to get Visit Type - Starts*/
 	
				StringTokenizer stPriority=new StringTokenizer(strPolicyPriority,"|");				
				StringTokenizer stCustGrp=new StringTokenizer(strCustGroupCode,"|");
				StringTokenizer stCust=new StringTokenizer(strCustCode,"|");
				StringTokenizer stPolicy=new StringTokenizer(strPolicyTypeCode,"|");
				StringTokenizer stBlngGrp=new StringTokenizer(strBlnggrpId,"|");
				CallableStatement cstmt = null;
				ResultSet rst = null;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String strPriority = "";
				String strCustGroup = "";
				String strCust = "";
				String strPolicy = "";
				String strBlngGrpId = "";
				//String strClinicCode = (String)session.getAttribute("clinic_code");
				//String strFacilityId = (String)session.getAttribute("facility_id") ;	
				String calling_function_id = "";
				String outEpisodeId = "";
				String visitType = "";
				String opParam = "";
				String outBlngGrpId = "";
				String outCustGrpCode = "";
				String outCustCode = "";
				String outPolicyCode = "";
					pstmt = con.prepareStatement("Select VISIT_TYPE_DERV_RULE from op_param where operating_facility_id = ? ");
					pstmt.setString(1, strFacilityId);
					rst = pstmt.executeQuery();
					if(rst != null){
						while(rst.next()){
							opParam = rst.getString("VISIT_TYPE_DERV_RULE");
						}
					}
					
					System.err.println("opParam->"+opParam);
					


					if("B".equals(opParam))
					{
					while(stPriority.hasMoreTokens()){
						strPriority = stPriority.nextToken();
						strCustGroup =stCustGrp.nextToken();
						strCust = stCust.nextToken();
						strPolicy =stPolicy.nextToken();
						strBlngGrpId = stBlngGrp.nextToken();
						if("1".equals(strPriority)){
								break;
								}
					}



							String clinicPatType = (String) session.getAttribute("clinic_code_bl_op");
							if(clinicPatType == null){
								clinicPatType = "";
							}
							
							String arr[] = clinicPatType.split("::##");
							String strTmpPatientId = "";
							String stClinicCode = "";
							String strEpsdType = "";
							String visitDate = "";
							System.err.println("clinicPatType"+clinicPatType+" arr.length->"+arr.length);
							if(arr.length == 5){
								stClinicCode = arr[0];
								strTmpPatientId = arr[1];
								strEpsdType = arr[2];
								calling_function_id = arr[3];
								visitDate = arr[4];
							}
							if(("O".equals(strEpsdType))&&("VISIT_REGISTRATION".equals(calling_function_id)))
								{
								
									cstmt = con.prepareCall("{ call   bl_interface_proc.proc_first_or_followup_visit (?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?,?,?) }");
									//System.err.println("bl_interface_proc.proc_first_or_followup_visit ("+strFacilityId+","+strTmpPatientId+","+strEpsdType+","+stClinicCode+","+visitDate+","+strCustGroup+","+strCust+","+strPolicy+","+strBlngGrpId+")");
									cstmt.setString(1, strFacilityId);
									cstmt.setString(2, strTmpPatientId);
									cstmt.setString(3, strEpsdType);
									cstmt.setString(4, stClinicCode);
									cstmt.setString(16, strVisitType);
									if((visitDate == null) || (("").equals(visitDate))){
										cstmt.setString(5, "SYSDATE");
									}
									else{
										cstmt.setString(5, visitDate);
									}
									
									cstmt.setString(6, strCustGroup);
									cstmt.setString(7, strCust);
									cstmt.setString(8, strPolicy);
									if(strBlngGrpId == null || "".equals(strBlngGrpId)){
										strBlngGrpId =""; //str_blng_grp;
									}
									
									cstmt.setString(9, strBlngGrpId);
									cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);
									cstmt.execute();
									visitType = cstmt.getString(11);
									//System.err.println("visitType->"+visitType);
									if("F".equals(visitType))
									strVisitType="N";									
								}
					}

				/*Karthik added for change - ends*/
				
/*				System.err.println("strClinicCode:"+strClinicCode);
				System.err.println("strVisitType:"+strVisitType);
				System.err.println("strEpisodeType:"+strEpisodeType);
				System.err.println("strEpisodeId:"+strEpisodeId);
				System.err.println("strVisitId:"+strVisitId);
				System.err.println("strPatientId:"+strPatientId);
				System.err.println("strFacilityId:"+strFacilityId);
				System.err.println("strUser:"+strUser);
				System.err.println("strWsNo:"+strWsNo);
				System.err.println("strBlnggrpId:"+strBlnggrpId);
				System.err.println("strPractitionerId:"+strPractitionerId);
				System.err.println("strPractitionerTypeInd:"+strPractitionerTypeInd);
				System.err.println("encounter_date_time:"+encounter_date_time);
				System.err.println("strFunctionId:"+strFunctionId);
				System.err.println("strPatSerCode:"+strPatSerCode);
				System.err.println("charge_for_pat_regn_yn:"+charge_for_pat_regn_yn);
*/
				try
				{		
					String bill_gen_later_YN_qry="select nvl(ADHOC_DISCOUNT_ALLOWED_YN,'N') from  bl_parameters where operating_facility_id='"+strFacilityId+"'";
//					System.err.println("bill_gen_later_YN_qry:"+bill_gen_later_YN_qry);
					pstmt = con.prepareStatement(bill_gen_later_YN_qry);
					rs = pstmt.executeQuery();	
					if( rs != null ) 
					{
						while( rs.next() )
						{  
							str_bill_later_YN  =  rs.getString(1);	
						}
					}
					if(str_bill_later_YN == null) str_bill_later_YN="N";
//					System.err.println("str_bill_later_YN:"+str_bill_later_YN);
					pstmt.close();
					if(rs!=null) rs.close();
				}
				catch(Exception e)
				{
					System.err.println("Exception in No of bill_gen_later_YN_qry Query="+e.toString());
				}

				CallableStatement callstmt = con.prepareCall("{ call Bl_User_Check_For_Cash_Counter(?,?,?,?,?,?,?)}");
				callstmt.setString(1,strFacilityId);
				callstmt.setString(2,"O");
				callstmt.setString(3,strUser);
				callstmt.setString(4,strWsNo);

				callstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(7,java.sql.Types.VARCHAR);

				callstmt.execute();

				strCashCounter=callstmt.getString(5);
				String strShiftId=callstmt.getString(6);
				String strMessageId=callstmt.getString(7);

				if(strCashCounter==null) strCashCounter="";
				if(strShiftId==null) strShiftId="";
				if(strMessageId==null) strMessageId="";

//				System.err.println("strCashCounter:"+strCashCounter);
//				System.err.println("strShiftId:"+strShiftId);
//				System.err.println("strMessageId:"+strMessageId);

				callstmt.close();

				callstmt = con.prepareCall("{ call blopin.get_blng_grp_clinic_bill_print(?,?,?,?,?,?,?,?,?,?,?)}");
				callstmt.setString(1,strFacilityId);
				callstmt.setString(2,strBlnggrpId.substring(0,2));
				callstmt.setString(3,strClinicCode);

				callstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(11,java.sql.Types.VARCHAR);

				callstmt.execute();

				vst_bill_yn = callstmt.getString(4);
				error_level=callstmt.getString(9);
				sys_message_id=callstmt.getString(10);
				error_text=callstmt.getString(11);

				if(vst_bill_yn == null) vst_bill_yn = "";
				if(error_level == null) error_level = "";
				if(error_text == null) error_text = "";
				if(sys_message_id == null) sys_message_id = "";

//				System.err.println("vst_bill_yn:"+vst_bill_yn);

				callstmt.close();

				if (strClinicCode.equals("") || strVisitType.equals("") || strPatientId.equals("") || strFacilityId.equals("") || strUser.equals("") || strBlnggrpId.equals("") )
				{
//					System.err.println("Inside the Null Values Check");

					if(strPatientId.equals("") && disaster_regn_YN.equals("Y") && strModuleId.equals("AE"))
					{
//						System.err.println("Inside the Null Values Check1");
						strValidatedState="Y";

						if(vst_bill_yn.equals("V"))
						{
							if(strCashCounter.equals("") || strShiftId.equals(""))
							{
								sys_message_id="BL1024";
							}
							else
							{
// Else Loop is commented as its been taken care in the procedure level 
/*
								String special_clinic_qry="Select nvl(SPECIALIST_CLINIC_YN,'N') SPECIALIST_CLINIC_YN from op_clinic where facility_id = '"+strFacilityId+"' and CLINIC_CODE = '"+strClinicCode+"'";
								System.err.println("special_clinic_qry in Disaster:"+special_clinic_qry);
								pstmt = con.prepareStatement(special_clinic_qry);
								rs = pstmt.executeQuery() ;
								if( rs != null ) 
								{	
									while( rs.next() )
									{  
										strSpecialistClinicYN = rs.getString("SPECIALIST_CLINIC_YN");
									}
								}
								else
								{
									strSpecialistClinicYN = "N";
								}

								if(strSpecialistClinicYN == null) strSpecialistClinicYN= "N";

								if (rs != null) rs.close();
								pstmt.close();

								System.err.println("strSpecialistClinicYN Disaster:"+strSpecialistClinicYN);

								String special_cash_cntr_qry="Select nvl(IS_SPECIAL_CLINIC,'N') IS_SPECIAL_CLINIC from bl_cash_counter where OPERATING_FACILITY_ID = '"+strFacilityId+"' and CASH_COUNTER_CODE = '"+strCashCounter+"'";
								System.err.println("special_cash_cntr_qry Disaster:"+special_cash_cntr_qry);
								pstmt = con.prepareStatement(special_cash_cntr_qry);
								rs = pstmt.executeQuery() ;
								if( rs != null ) 
								{	
									while( rs.next() )
									{  
										strSpecialistCashCntrYN = rs.getString("IS_SPECIAL_CLINIC");
									}
								}
								else
								{
									strSpecialistCashCntrYN = "N";
								}

								if(strSpecialistCashCntrYN == null) strSpecialistCashCntrYN= "N";

								if (rs != null) rs.close();
								pstmt.close();

								System.err.println("strSpecialistCashCntrYN Disaster:"+strSpecialistCashCntrYN);

								if(strSpecialistClinicYN.equals("Y") && strSpecialistCashCntrYN.equals("N"))
								{
									strValidatedState="E";
									sys_message_id="BL6241";
								}
								else if(strSpecialistClinicYN.equals("N") && strSpecialistCashCntrYN.equals("Y"))
								{
									strValidatedState="E";
									sys_message_id="BL6240";
								}
*/
							}
							if(!strMessageId.equals(""))
							{
								sys_message_id=strMessageId;
							}

							if(!sys_message_id.equals(""))
							{
								strValidatedState="E";
							}
						}
					}
					else if(disaster_regn_YN.equals("N") && strModuleId.equals("MP"))
					{
						strValidatedState="N";
					}
					else
					{
						//System.out.println("518 *** BLValidation.jsp ");
						strValidatedState="E";
						sys_message_id="BL1130";
						//System.out.println("521 *** BLValidation.jsp "+sys_message_id);
					}
				}
				else
				{
// Else Loop is commented as its been taken care in the procedure level 
/*
					if(vst_bill_yn.equals("V"))
					{
						String special_clinic_qry="Select nvl(SPECIALIST_CLINIC_YN,'N') SPECIALIST_CLINIC_YN from op_clinic where facility_id = '"+strFacilityId+"' and CLINIC_CODE = '"+strClinicCode+"'";
	System.err.println("special_clinic_qry:"+special_clinic_qry);
						pstmt = con.prepareStatement(special_clinic_qry);
						rs = pstmt.executeQuery() ;
						if( rs != null ) 
						{	
							while( rs.next() )
							{  
								strSpecialistClinicYN = rs.getString("SPECIALIST_CLINIC_YN");
							}
						}
						else
						{
							strSpecialistClinicYN = "N";
						}

						if(strSpecialistClinicYN == null) strSpecialistClinicYN= "N";

						if (rs != null) rs.close();
						pstmt.close();

						System.err.println("strSpecialistClinicYN:"+strSpecialistClinicYN);

						String special_cash_cntr_qry="Select nvl(IS_SPECIAL_CLINIC,'N') IS_SPECIAL_CLINIC from bl_cash_counter where OPERATING_FACILITY_ID = '"+strFacilityId+"' and CASH_COUNTER_CODE = '"+strCashCounter+"'";
	System.err.println("special_cash_cntr_qry:"+special_cash_cntr_qry);
						pstmt = con.prepareStatement(special_cash_cntr_qry);
						rs = pstmt.executeQuery() ;
						if( rs != null ) 
						{	
							while( rs.next() )
							{  
								strSpecialistCashCntrYN = rs.getString("IS_SPECIAL_CLINIC");
							}
						}
						else
						{
							strSpecialistCashCntrYN = "N";
						}

						if(strSpecialistCashCntrYN == null) strSpecialistCashCntrYN= "N";

						if (rs != null) rs.close();
						pstmt.close();

						System.err.println("strSpecialistCashCntrYN:"+strSpecialistCashCntrYN);

						if(strSpecialistClinicYN.equals("Y") && strSpecialistCashCntrYN.equals("N"))
						{
							strValidatedState="E";
							sys_message_id="BL6241";
						}
						else if(strSpecialistClinicYN.equals("N") && strSpecialistCashCntrYN.equals("Y"))
						{
							strValidatedState="E";
							sys_message_id="BL6240";
						}
					}
*/
				}
				str_epi_type_clinic_code=strEpisodeType+"#"+strClinicCode;
//				System.err.println("str_epi_type_clinic_code:"+str_epi_type_clinic_code);
//				System.err.println("strValidatedState:"+strValidatedState);

//				System.err.println("strFunctionId RRRRR:"+strFunctionId);
				if(strModuleId.equals("MP") && strFunctionId.equals("CHG_PAT_DTLS"))
				{
					strValidatedState="Y";
				}


				if (strValidatedState.equals("N"))
				{
					if(strModuleId.equals("AE") || strModuleId.equals("OP"))
					{
						try
						{
							call = con.prepareCall("{ call BLVISITCHARGINGRULE.GET_VISIT_RULE_BY_CLINIC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

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
							call.close();
//							System.err.println("strHospServPanelInd:"+strHospServPanelInd);
//							System.err.println("strHospServPanelCode:"+strHospServPanelCode);
//							System.err.println("strMedServPanelInd:"+strMedServPanelInd);
//							System.err.println("strMedServPanelCode:"+strMedServPanelCode);

//							System.err.println("error_level in BLOPIN:"+error_level);
//							System.err.println("sys_message_id in BLOPIN:"+sys_message_id);
//							System.err.println("error_text in BLOPIN:"+error_text);
							
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
						catch(Exception e)
						{
							proc_success="N";
							System.err.println("Exception in Procedure GET_VISIT_RULE_BY_CLINIC:"+e);
						}
					}
					else if(strModuleId.equals("MP"))
					{
						try
						{
//							System.err.println("strFunctionId.equals CHG_PAT_DTLS");
							String main_blng_grp_id = "";
							String main_cust_grp_code = "";
							String main_cust_code = "";

							if(!strNonInsBlnggrpId.equals(""))
							{
								main_blng_grp_id = strBlnggrpId.substring(0,strBlnggrpId.indexOf("|"));
								main_cust_grp_code = strCustGroupCode.substring(0,strCustGroupCode.indexOf("|"));
								main_cust_code = strCustCode.substring(0,strCustCode.indexOf("|"));
							}
							else
							{
								main_blng_grp_id = strBlnggrpId;
								main_cust_grp_code = strCustGroupCode;
								main_cust_code = strCustCode;
							}
//							System.err.println("main_blng_grp_id:"+main_blng_grp_id);
//							System.err.println("main_cust_grp_code:"+main_cust_grp_code);
//							System.err.println("main_cust_code:"+main_cust_code);
//							System.err.println("strPatSerCode:"+strPatSerCode);
							call = con.prepareCall("{ call BLPATIENTREGNCHARGE.GETPATREGNSERVDTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

							call.setString(1,strFacilityId);
							call.setString(2,strPatSerCode);//P_pat_ser_grp_code
							call.setString(3,main_blng_grp_id);
							call.setString(4,main_cust_grp_code);
							call.setString(5,main_cust_code);

							call.registerOutParameter(6,java.sql.Types.VARCHAR);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.registerOutParameter(8,java.sql.Types.VARCHAR);
							call.registerOutParameter(9,java.sql.Types.VARCHAR);
							call.registerOutParameter(10,java.sql.Types.VARCHAR);
							call.registerOutParameter(11,java.sql.Types.VARCHAR);
							call.registerOutParameter(12,java.sql.Types.VARCHAR);
							call.registerOutParameter(13,java.sql.Types.VARCHAR);
							call.registerOutParameter(14,java.sql.Types.VARCHAR);
							call.execute();
//							System.err.println("Check");
							regn_charge_YN = call.getString(6);
							if(regn_charge_YN == null) regn_charge_YN="N";

							String regn_charge_dur_enc_YN = call.getString(7);
							if(regn_charge_dur_enc_YN == null) regn_charge_dur_enc_YN="N";

							strHospServPanelInd=call.getString(8);
							if(strHospServPanelInd==null) strHospServPanelInd="";
							strHospServPanelCode=call.getString(9);
							if(strHospServPanelCode==null) strHospServPanelCode="";

							error_level=call.getString(10);
							sys_message_id=call.getString(11);
							error_text=call.getString(12);

							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";

							call.close();

//							System.err.println("regn_charge_YN CHG_PAT_DTLS:"+regn_charge_YN);
//							System.err.println("regn_charge_dur_enc_YN CHG_PAT_DTLS:"+regn_charge_dur_enc_YN);
//							System.err.println("strHospServPanelInd CHG_PAT_DTLS:"+strHospServPanelInd);
//							System.err.println("strHospServPanelCode CHG_PAT_DTLS:"+strHospServPanelCode);

//							System.err.println("error_level in GETPATREGNSERVDTL CHG_PAT_DTLS:"+error_level);
//							System.err.println("sys_message_id in GETPATREGNSERVDTL CHG_PAT_DTLS:"+sys_message_id);
//							System.err.println("error_text in GETPATREGNSERVDTL CHG_PAT_DTLS:"+error_text);
							
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
						catch(Exception e)
						{
							proc_success="N";
							System.err.println("Exception in Procedure GETPATREGNSERVDTL in BLValidation.jsp:"+e);
							e.printStackTrace();
						}
					}

					if(proc_success.equals("Y") && !strModuleId.equals("MP"))
					{
						try
						{
							if(!strNonInsBlnggrpId.equals(""))
							{
								ArrayList blng_grp_al = new ArrayList();
								StringTokenizer st= new StringTokenizer(strBlnggrpId,"|");
								while(st.hasMoreTokens())
								{
									blng_grp_al.add(st.nextToken());
								}

								ArrayList cust_grp_al = new ArrayList();
								st= new StringTokenizer(strCustGroupCode,"|");
								while(st.hasMoreTokens())
								{
									cust_grp_al.add(st.nextToken());
								}

								ArrayList cust_al = new ArrayList();
								st= new StringTokenizer(strCustCode,"|");
								while(st.hasMoreTokens())
								{
									cust_al.add(st.nextToken());
								}

								ArrayList pol_type_al = new ArrayList();
								st= new StringTokenizer(strPolicyTypeCode,"|");
								while(st.hasMoreTokens())
								{
									pol_type_al.add(st.nextToken());
								}
								
								for(int i=0;i<blng_grp_al.size();i++)
								{
									if(strAddlServAvailYN.equals("N"))
									{
										call = con.prepareCall("{ call BLVISITCHARGE.CHECK_ADDL_SERV_CHARGE_BY_CL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

										call.setString(1,strFacilityId);
										call.setString(2,"V");
										call.setString(3,(String)blng_grp_al.get(i));
										call.setString(4,(String)cust_grp_al.get(i));
										call.setString(5,(String)cust_al.get(i));
										call.setString(6,(String)pol_type_al.get(i));
										call.setString(7,strClinicCode);
										call.setString(8,strVisitType);
										call.setString(9,strPractitionerId);

										call.registerOutParameter(10,java.sql.Types.VARCHAR);
										call.registerOutParameter(11,java.sql.Types.VARCHAR);
										call.registerOutParameter(12,java.sql.Types.VARCHAR);
										call.registerOutParameter(13,java.sql.Types.VARCHAR);
										call.registerOutParameter(14,java.sql.Types.VARCHAR);
										call.registerOutParameter(15,java.sql.Types.VARCHAR);
										call.registerOutParameter(16,java.sql.Types.VARCHAR);
										call.registerOutParameter(17,java.sql.Types.VARCHAR);

										call.execute();
									
										strAddlServAvailYN = call.getString(10); 
										if(strAddlServAvailYN == null ) strAddlServAvailYN="N";

										strAddlServPanelInd=call.getString(11);
										if(strAddlServPanelInd==null) strAddlServPanelInd="";

										strAddlServPanelCode=call.getString(12);
										if(strAddlServPanelCode==null) strAddlServPanelCode="";

										strAddlChargeType = call.getString(13);
										if(strAddlChargeType == null) strAddlChargeType="";

										dflt_excl_overide_code = call.getString(14);
										if(dflt_excl_overide_code == null) dflt_excl_overide_code="";
		
										error_level=call.getString(15);
										sys_message_id=call.getString(16);
										error_text=call.getString(17);

										if (error_level == null) error_level ="";
										if (sys_message_id ==null) sys_message_id ="";
										if (error_text ==null) error_text ="";

										call.close();

//										System.err.println("strAddlServAvailYN:"+strAddlServAvailYN);
//										System.err.println("strAddlServPanelInd:"+strAddlServPanelInd);
//										System.err.println("strAddlServPanelCode:"+strAddlServPanelCode);
//										System.err.println("strAddlChargeType:"+strAddlChargeType);
//										System.err.println("dflt_excl_overide_code:"+dflt_excl_overide_code);

//										System.err.println("error_level in CHECK_ADDL_SERV_CHARGE_BY_CL:"+error_level);
//										System.err.println("sys_message_id in CHECK_ADDL_SERV_CHARGE_BY_CL:"+sys_message_id);
//										System.err.println("error_text in CHECK_ADDL_SERV_CHARGE_BY_CL:"+error_text);
									}
									
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
						}
						catch(Exception e)
						{
							System.err.println("Exception in Procedure call:"+e);
						}
					}
/* Commented and moved above for PE Changes	
					try
					{
						String query_service_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
						stmt = con.createStatement();
						rs = stmt.executeQuery(query_service_date) ;
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
*/

					if(proc_success.equals("Y"))
					{
						try
						{
							String hosp_panel_str=(String)session.getAttribute("hosp_panel_str");
							if(hosp_panel_str==null || hosp_panel_str.equals("")) hosp_panel_str="";
//							System.err.println("Calling BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS for hosp_panel_str");
							call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY  HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	

							call.setString(1,strFacilityId);//facility_id
							call.setString(2,strModuleId);	//module_id
							call.setString(3,str_epi_type_clinic_code);//Episode_type strEpisodeType 
							call.setString(4,strPatientId);//patient_id
							call.setString(5,strEpisodeId);//strEpisodeId
							call.setString(6,strVisitId);
	//						call.setLong(7,encounter_id);
							call.setString(7,strEncounterId);
							call.setInt(8,acc_seq_no);
							call.setString(9,service_date);//service_date
							call.setString(10,strHospServPanelInd);//service_panel_ind
							call.setString(11,strHospServPanelCode);//service_panel_code
							call.setDouble(12,1);//service_qty
							call.setString(13,strPractitionerTypeInd);//pract_staff_ind
							call.setString(14,strPractitionerId);//pract_staff_id
							call.setString(41,locale);//locale
							call.setString(15,strBlnggrpId);
							call.setString(16,strCustGroupCode);
							call.setString(17,strCustCode);
							call.setString(18,strPolicyTypeCode);
							call.setString(19,strPolicyPriority);
							call.setString(20,strPolicyNumber);
							call.setString(21,strPolicyStartDate);
							call.setString(22,strPolicyExpiryDate);
							call.setString(23,strCreditAuthRef);
							call.setString(24,strCreditAuthDate);
							call.setString(25,strEffectiveFrom);
							call.setString(26,strEffectiveTo);
							call.setString(27,strApprovedAmt);
							call.setString(28,strApprovedDays);
							call.setString(29,strNonInsBlnggrpId);
							call.setString(30,strNonInsCustGroupCode);
							call.setString(31,strNonInsCustCode);
							call.registerOutParameter(32,java.sql.Types.VARCHAR);
							call.registerOutParameter(33,java.sql.Types.VARCHAR);
							call.registerOutParameter(34,java.sql.Types.DOUBLE);
							call.registerOutParameter(35,java.sql.Types.DOUBLE);
							call.registerOutParameter(36,java.sql.Types.VARCHAR);
							call.registerOutParameter(37,java.sql.Types.VARCHAR);
							call.setString(38,"");//excl_incl_action_ind
							call.setString(39,"");//action_reason_code
							call.registerOutParameter(40,java.sql.Types.VARCHAR);	
							call.registerOutParameter(42,java.sql.Types.VARCHAR);
							call.registerOutParameter(43,java.sql.Types.VARCHAR);
							call.registerOutParameter(44,java.sql.Types.VARCHAR);
							call.execute();	
//							System.err.println("after Calling BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS for hosp_panel_str");
							strHospServPanelStr=call.getString(32);	
//							System.err.println("Charge bases YN in Hospital:"+(String)call.getString(33));						
//							System.err.println("Total Amount in Hospital:"+(String)call.getString(34));
//							System.err.println("Patient Payable Amount in Hospital:"+(String)call.getString(35));

	//						System.err.println("strHospServPanelStr: " + strHospServPanelStr);	
							if(strHospServPanelStr==null) strHospServPanelStr="";

							error_level=call.getString(42);
							sys_message_id=call.getString(43);
							error_text=call.getString(44);

							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";
							call.close();
//							System.err.println("error_level for Hosp_panel:"+error_level);
//							System.err.println("sys_message_id for Hosp_panel:"+sys_message_id);
//							System.err.println("error_text for Hosp_panel:"+error_text);

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
		
//							System.err.println("hosp_panel_str:"+hosp_panel_str);
							if(hosp_panel_str.equals(""))
							{
								session.setAttribute("hosp_panel_str",strHospServPanelStr);
//								System.err.println("hosp_panel_str in Validation Main IF:"+session.getAttribute("hosp_panel_str"));
							}
							else
							{
								if(hosp_panel_str_YN.equals("Y"))
								{
									String hosp_panel=(String)session.getAttribute("hosp_panel");
									if(hosp_panel==null || hosp_panel.equals("")) hosp_panel="";

									session.setAttribute("hosp_panel_str",hosp_panel);
//									System.err.println("hosp_panel_str in Validation IF:"+session.getAttribute("hosp_panel_str"));
								}
								else
								{
									session.setAttribute("hosp_panel_str",strHospServPanelStr);
//									System.err.println("hosp_panel_str in Validation ELSE:"+session.getAttribute("hosp_panel_str"));
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

					if(proc_success.equals("Y") && !strModuleId.equals("MP"))
					{
						try
						{

							String prof_panel_str=(String)session.getAttribute("prof_panel_str");
							if(prof_panel_str==null || prof_panel_str.equals("")) prof_panel_str="";

							call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY  HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	

							call.setString(1,strFacilityId);//facility_id
							call.setString(2,strModuleId);	//module_id
							call.setString(3,str_epi_type_clinic_code);//Episode_type strEpisodeType 
							call.setString(4,strPatientId);//patient_id
							call.setString(5,strEpisodeId);//strEpisodeId
							call.setString(6,strVisitId);
	//						call.setLong(7,encounter_id);
							call.setString(7,strEncounterId);
							call.setInt(8,acc_seq_no);
							call.setString(9,service_date);//service_date
							call.setString(10,strMedServPanelInd);//service_panel_ind
							call.setString(11,strMedServPanelCode);//service_panel_code
							call.setDouble(12,1);//service_qty
							call.setString(13,strPractitionerTypeInd);//pract_staff_ind
							call.setString(14,strPractitionerId);//pract_staff_id
							call.setString(41,locale);//locale
							call.setString(15,strBlnggrpId);
							call.setString(16,strCustGroupCode);
							call.setString(17,strCustCode);
							call.setString(18,strPolicyTypeCode);
							call.setString(19,strPolicyPriority);
							call.setString(20,strPolicyNumber);
							call.setString(21,strPolicyStartDate);
							call.setString(22,strPolicyExpiryDate);
							call.setString(23,strCreditAuthRef);
							call.setString(24,strCreditAuthDate);
							call.setString(25,strEffectiveFrom);
							call.setString(26,strEffectiveTo);
							call.setString(27,strApprovedAmt);
							call.setString(28,strApprovedDays);
							call.setString(29,strNonInsBlnggrpId);
							call.setString(30,strNonInsCustGroupCode);
							call.setString(31,strNonInsCustCode);
							call.registerOutParameter(32,java.sql.Types.VARCHAR);
							call.registerOutParameter(33,java.sql.Types.VARCHAR);
							call.registerOutParameter(34,java.sql.Types.DOUBLE);
							call.registerOutParameter(35,java.sql.Types.DOUBLE);
							call.registerOutParameter(36,java.sql.Types.VARCHAR);
							call.registerOutParameter(37,java.sql.Types.VARCHAR);
							call.setString(38,"");//excl_incl_action_ind
							call.setString(39,"");//action_reason_code
							call.registerOutParameter(40,java.sql.Types.VARCHAR);	
							call.registerOutParameter(42,java.sql.Types.VARCHAR);
							call.registerOutParameter(43,java.sql.Types.VARCHAR);
							call.registerOutParameter(44,java.sql.Types.VARCHAR);
							call.execute();	

							strMedServPanelStr=call.getString(32);
//							System.err.println("Charge bases YN in Medical:"+(String)call.getString(33));
//							System.err.println("Total Amount in Medical:"+(String)call.getString(34));
//							System.err.println("Patient Payable Amount in Medical:"+(String)call.getString(35));
						//	System.err.println("strMedServPanelStr:" + strMedServPanelStr);	
							if(strMedServPanelStr==null) strMedServPanelStr="";

							error_level=call.getString(42);
							sys_message_id=call.getString(43);
							error_text=call.getString(44);

							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";

//							System.err.println("error_level for Hosp_panel:"+error_level);
//							System.err.println("sys_message_id for Hosp_panel:"+sys_message_id);
//							System.err.println("error_text for Hosp_panel:"+error_text);

							call.close();

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
							
							if(prof_panel_str.equals(""))
							{
								session.setAttribute("prof_panel_str",strMedServPanelStr);
//								System.err.println("prof_panel_str in Validation Main IF:"+session.getAttribute("prof_panel_str"));
							}
							else
							{
								if(prof_panel_str_YN.equals("Y"))
								{
									String prof_panel=(String)session.getAttribute("prof_panel");
									if(prof_panel==null || prof_panel.equals("")) prof_panel="";

									session.setAttribute("prof_panel_str",prof_panel);
//									System.err.println("prof_panel_str in Validation IF:"+session.getAttribute("prof_panel_str"));
								}
								else
								{
									session.setAttribute("prof_panel_str",strMedServPanelStr);
//									System.err.println("prof_panel_str in Validation ELSE:"+session.getAttribute("prof_panel_str"));
								}
							}
						}
						catch(Exception exp1)
						{
							proc_success="N";
							System.err.println("error in Prof"+exp1);
						}
					}

					if(proc_success.equals("Y") && !strModuleId.equals("MP"))
					{
						if(strAddlServAvailYN.equals("Y") && !strAddlServPanelCode.equals(""))
						{
							try
							{
								String addl_panel_str=(String)session.getAttribute("addl_panel_str");
								if(addl_panel_str==null || addl_panel_str.equals("")) addl_panel_str="";

								call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY  HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	

								call.setString(1,strFacilityId);//facility_id
								call.setString(2,strModuleId);	//module_id
								call.setString(3,str_epi_type_clinic_code);//Episode_type strEpisodeType 
								call.setString(4,strPatientId);//patient_id
								call.setString(5,strEpisodeId);//strEpisodeId
								call.setString(6,strVisitId);
		//						call.setLong(7,encounter_id);
								call.setString(7,strEncounterId);
								call.setInt(8,acc_seq_no);
								call.setString(9,service_date);//service_date
								call.setString(10,strAddlServPanelInd);//service_panel_ind
								call.setString(11,strAddlServPanelCode);//service_panel_code
								call.setDouble(12,1);//service_qty
								call.setString(13,strPractitionerTypeInd);//pract_staff_ind
								call.setString(14,strPractitionerId);//pract_staff_id
								call.setString(41,locale);//locale
								call.setString(15,strBlnggrpId);
								call.setString(16,strCustGroupCode);
								call.setString(17,strCustCode);
								call.setString(18,strPolicyTypeCode);
								call.setString(19,strPolicyPriority);
								call.setString(20,strPolicyNumber);
								call.setString(21,strPolicyStartDate);
								call.setString(22,strPolicyExpiryDate);
								call.setString(23,strCreditAuthRef);
								call.setString(24,strCreditAuthDate);
								call.setString(25,strEffectiveFrom);
								call.setString(26,strEffectiveTo);
								call.setString(27,strApprovedAmt);
								call.setString(28,strApprovedDays);
								call.setString(29,strNonInsBlnggrpId);
								call.setString(30,strNonInsCustGroupCode);
								call.setString(31,strNonInsCustCode);
								call.registerOutParameter(32,java.sql.Types.VARCHAR);
								call.registerOutParameter(33,java.sql.Types.VARCHAR);
								call.registerOutParameter(34,java.sql.Types.DOUBLE);
								call.registerOutParameter(35,java.sql.Types.DOUBLE);
								call.registerOutParameter(36,java.sql.Types.VARCHAR);
								call.registerOutParameter(37,java.sql.Types.VARCHAR);
								if(strAddlChargeType.equals("P"))
								{
									call.setString(38,"E");//excl_incl_action_ind
									call.setString(39,dflt_excl_overide_code);//action_reason_code
								}
								else
								{
									call.setString(38,"");//excl_incl_action_ind
									call.setString(39,"");//action_reason_code
								}							
								call.registerOutParameter(40,java.sql.Types.VARCHAR);	
								call.registerOutParameter(42,java.sql.Types.VARCHAR);
								call.registerOutParameter(43,java.sql.Types.VARCHAR);
								call.registerOutParameter(44,java.sql.Types.VARCHAR);
								call.execute();	

								strAddlServPanelStr=call.getString(32);
//								System.err.println("Charge bases YN in Addl:"+(String)call.getString(33));
//								System.err.println("Total Amount in Addl:"+(String)call.getString(34));
//								System.err.println("Patient Payable Amount in Addl:"+(String)call.getString(35));
							//	System.err.println("strMedServPanelStr:" + strMedServPanelStr);	
								if(strAddlServPanelStr==null) strAddlServPanelStr="";

								error_level=call.getString(42);
								sys_message_id=call.getString(43);
								error_text=call.getString(44);

								if (error_level == null) error_level ="";
								if (sys_message_id ==null) sys_message_id ="";
								if (error_text ==null) error_text ="";

//								System.err.println("error_level for Addl_panel:"+error_level);
//								System.err.println("sys_message_id for Addl_panel:"+sys_message_id);
//								System.err.println("error_text for Addl_panel:"+error_text);

								call.close();

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
								
								if(addl_panel_str.equals(""))
								{
									session.setAttribute("addl_panel_str",strAddlServPanelStr);
//									System.err.println("addl_panel_str in Validation Main IF:"+session.getAttribute("addl_panel_str"));
								}
								else
								{
									if(addl_panel_str_YN.equals("Y"))
									{
										String addl_panel=(String)session.getAttribute("addl_panel");
										if(addl_panel==null || addl_panel.equals("")) addl_panel="";

										session.setAttribute("addl_panel_str",addl_panel);
//										System.err.println("addl_panel_str in Validation IF:"+session.getAttribute("addl_panel_str"));
									}
									else
									{
										session.setAttribute("addl_panel_str",strAddlServPanelStr);
//										System.err.println("addl_panel_str in Validation ELSE:"+session.getAttribute("addl_panel_str"));
									}
								}

							}
							catch(Exception exp1)
							{
								proc_success="N";
								System.err.println("error in Addl"+exp1);
							}
						}
					}
					
					if(proc_success.equals("Y"))
					{
						if(!strModuleId.equals("MP"))
						{
						try
						{
	//						statement=con.prepareCall("{call blopin.proc_main(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
							
	/*						String sql="{call blopin.proc_main('"+mode+"','"+strFunctionId+"','"+strFacilityId+"','"+strModuleId+"','"+strClinicCode+"','"+strVisitType+"','"+strNull+"','"+strPatientId+"','"+strEpisodeType+"','"+strEncounterId+"','"+strEpisodeId+"','"+strVisitId+"','"+strPractitionerTypeInd+"','"+strPractitionerId+"','"+strBlnggrpId+"','"+strCustCode+"','"+strPolicyTypeCode+"','"+strPolicyPriority+"','"+strPolicyNumber+"','"+strPolicyStartDate+"','"+strPolicyExpiryDate+"','"+strCreditAuthRef+"','"+strCreditAuthDate+"','"+strEffectiveFrom+"','"+strEffectiveTo+"','"+strApprovedAmt+"','"+strApprovedDays+"','"+strNonInsBlnggrpId+"','"+strNonInsCustCode+"','"+strHospServPanelInd+"','"+strHospServPanelCode+"','"+strHospServPanelStr+"','"+strHospServPanelQty+"','"+strHospServChargeAmt+"','"+strMedServPanelInd+"','"+strMedServPanelCode+"','"+strMedServPanelStr+"','"+strMedServPanelQty+"','"+strMedServChargeAmt+"','"+strUser+"','"+strWsNo+"','"+strWsNo+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?)}";
	*/

	//System.out.println("Testing for OutPatient Management BlValidation.jsp "); 
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
							String sql="{call BLVisitCharge.proc_main('"+mode+"','"+strFunctionId+"','"+strFacilityId+"','"+strModuleId+"','"+strClinicCode+"','"+strVisitType+"','"+strNull+"','"+strPatientId+"','"+strEpisodeType+"','"+strEncounterId+"','"+strEpisodeId+"','"+strVisitId+"',to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI'),'"+strPractitionerTypeInd+"','"+strPractitionerId+"','"+strBlnggrpId+"','"+strCustGroupCode+"','"+strCustCode+"','"+strPolicyTypeCode+"','"+strPolicyPriority+"','"+strPolicyNumber+"','"+strPolicyStartDate+"','"+strPolicyExpiryDate+"','"+strCreditAuthRef+"','"+strCreditAuthDate+"','"+strEffectiveFrom+"','"+strEffectiveTo+"','"+strApprovedAmt+"','"+strApprovedDays+"','"+strNonInsBlnggrpId+"','"+strNonInsCustGroupCode+"','"+strNonInsCustCode+"','"+strNewHospChrgCreate+"','"+strNewMedChrgCreate+"','"+strNewAddlChrgCreate+"','"+strHospServPanelInd+"','"+strHospServPanelCode+"','"+strHospServPanelStr+"','"+strHospServPanelQty+"','"+strHospServChargeAmt+"','"+strMedServPanelInd+"','"+strMedServPanelCode+"','"+strMedServPanelStr+"','"+strMedServPanelQty+"','"+strMedServChargeAmt+"','"+strAddlServPanelInd+"','"+strAddlServPanelCode+"','"+strAddlServPanelStr+"','"+strAddlServPanelQty+"','"+strAddlServChargeAmt+"','"+str_bill_later_YN+"','"+strUser+"','"+strWsNo+"','"+strWsNo+"',"+acc_seq_no+",'"+strNull+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+strAcrossGroupEncounter+"','"+reg_referral_flag+"')}";  //V230616
							System.err.println("sql:"+sql);

							statement=con.prepareCall(sql);
//System.out.println("Testing for OutPatient Management BlValidation.jsp _1 "+sql); //27-2-12
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

//System.out.println("Testing for OutPatient Management BlValidation.jsp _2 "+sql); //27-2-12
							statement.execute();
//System.out.println("Testing for OutPatient Management BlValidation.jsp _3 "+sql); //27-2-12
							hosp_charge_YN= statement.getString(1);
							if(hosp_charge_YN==null || hosp_charge_YN.equals("")) hosp_charge_YN="";

							med_charge_YN= statement.getString(2);
							if(med_charge_YN==null || med_charge_YN.equals("")) med_charge_YN="";

							addl_charge_YN= statement.getString(3);
							if(addl_charge_YN==null || addl_charge_YN.equals("")) addl_charge_YN="";
							
							exempt_date= statement.getString(4);
							if(exempt_date==null) exempt_date="";

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

							System.err.println("hosp_chrg_amt gen from proc_main12:"+hosp_chrg_amt);
							System.err.println("hosp_chrg_pat_amt gen from proc_main12:"+hosp_chrg_pat_amt);

//							System.err.println("med_chrg_amt gen from proc_main:"+med_chrg_amt);
//							System.err.println("med_chrg_pat_amt gen from proc_main:"+med_chrg_pat_amt);

//							System.err.println("addl_chrg_amt gen from proc_main:"+addl_chrg_amt);
//							System.err.println("addl_chrg_pat_amt gen from proc_main:"+addl_chrg_pat_amt);

							error_level=statement.getString(18);
							sys_message_id=statement.getString(19);
							error_text=statement.getString(20);
//System.out.println("Testing for OutPatient Management BlValidation.jsp _4 "+sql); //27-2-12
							statement.close();
							
							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";

//							System.err.println("error_level:"+error_level);
//							System.err.println("sys_message_id:"+sys_message_id);
//							System.err.println("error_text:"+error_text);
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
//System.out.println("Testing for OutPatient Management BlValidation.jsp _5 "+sql); //27-2-12
							if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
							{
								strValidatedState = "E";	
							}
							else
							{
								strValidatedState = "Y";
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

							String upd_addl_chrg_amt=(String)session.getAttribute("upd_addl_chrg_amt");
							if(upd_addl_chrg_amt!=null)
							{
								str_addl_chrg_amt=upd_addl_chrg_amt;
								addl_chrg_amt=Double.parseDouble(str_addl_chrg_amt);
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

							String upd_addl_chrg_pat_amt=(String)session.getAttribute("upd_addl_chrg_pat_amt");
							if(upd_addl_chrg_pat_amt!=null)
							{
								str_addl_chrg_pat_amt=upd_addl_chrg_pat_amt;
								addl_chrg_pat_amt=Double.parseDouble(str_addl_chrg_pat_amt);
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

	//						System.err.println("charge_YN:"+charge_YN);
//							System.err.println("hosp_charge_YN:"+hosp_charge_YN);
//							System.err.println("med_charge_YN:"+med_charge_YN);						
//							System.err.println("addl_charge_YN:"+addl_charge_YN);						
//							System.err.println("exempt_date:"+exempt_date);
//							System.err.println("hosp_chrg_amt:"+hosp_chrg_amt);
//							System.err.println("med_chrg_amt:"+med_chrg_amt);
//							System.err.println("bill_gen_yn:"+bill_gen_yn);
//							System.err.println("str_bill_gen_later:"+str_bill_gen_later);
//							System.err.println("str_total_bill_amt:"+str_total_bill_amt);

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
//								System.err.println("hosp_dtls Inside:"+session.getAttribute("hosp_dtls"));
							}
//							System.err.println("hosp_dtls:"+session.getAttribute("hosp_dtls"));

							HashMap prof_dtls_check=(HashMap)session.getAttribute("prof_dtls");
							if(prof_dtls_check==null)
							{
								prof_dtls.put("prof_serv_panel_ind",strMedServPanelInd);
								prof_dtls.put("prof_serv_panel_code",strMedServPanelCode);
								prof_dtls.put("prof_serv_panel_str",strMedServPanelStr);
								prof_dtls.put("prof_serv_panel_qty",String.valueOf(strMedServPanelQty));
								prof_dtls.put("prof_serv_chrg_amt",String.valueOf(strMedServChargeAmt));
								session.setAttribute("prof_dtls",prof_dtls);
	//							System.err.println("prof_dtls:"+session.getAttribute("prof_dtls"));
							}

							HashMap addl_dtls_check=(HashMap)session.getAttribute("addl_dtls");
							if(addl_dtls_check==null)
							{
								addl_dtls.put("addl_serv_panel_ind",strAddlServPanelInd);
								addl_dtls.put("addl_serv_panel_code",strAddlServPanelCode);
								addl_dtls.put("addl_serv_panel_str",strAddlServPanelStr);
								addl_dtls.put("addl_serv_panel_qty",String.valueOf(strAddlServPanelQty));
								addl_dtls.put("addl_serv_chrg_amt",String.valueOf(strAddlServChargeAmt));
								session.setAttribute("addl_dtls",addl_dtls);
	//							System.err.println("prof_dtls:"+session.getAttribute("prof_dtls"));
							}

//							System.err.println("addl_dtls:"+session.getAttribute("addl_dtls"));
							try
							{

								fin_dtls_to_chrg_dtls.put("billing_group",strBlnggrpId);
								fin_dtls_to_chrg_dtls.put("cust_group_code",strCustGroupCode);
								fin_dtls_to_chrg_dtls.put("cust_code",strCustCode);
								fin_dtls_to_chrg_dtls.put("policy_type_code",strPolicyTypeCode);
								fin_dtls_to_chrg_dtls.put("policy_priority",strPolicyPriority);
								fin_dtls_to_chrg_dtls.put("policy_no",strPolicyNumber);
								fin_dtls_to_chrg_dtls.put("policy_start_date",strPolicyStartDate);
								fin_dtls_to_chrg_dtls.put("policy_exp_date",strPolicyExpiryDate);
								fin_dtls_to_chrg_dtls.put("credit_auth_ref",strCreditAuthRef);
								fin_dtls_to_chrg_dtls.put("credit_auth_date",strCreditAuthDate);
								fin_dtls_to_chrg_dtls.put("policy_eff_from_date",strEffectiveFrom);
								fin_dtls_to_chrg_dtls.put("policy_eff_to_date",strEffectiveTo);
								fin_dtls_to_chrg_dtls.put("approved_amt",strApprovedAmt);
								fin_dtls_to_chrg_dtls.put("approved_days",strApprovedDays);
								fin_dtls_to_chrg_dtls.put("non_ins_blng_grp_id",strNonInsBlnggrpId);
								fin_dtls_to_chrg_dtls.put("non_ins_cust_group_code",strNonInsCustGroupCode);
								fin_dtls_to_chrg_dtls.put("non_ins_cust_code",strNonInsCustCode);
								fin_dtls_to_chrg_dtls.put("user_id",strUser);
								fin_dtls_to_chrg_dtls.put("ws_no",strWsNo);
								session.setAttribute("fin_dtls_to_chrg_dtls",fin_dtls_to_chrg_dtls);
							}
							catch(Exception e)
							{
								System.err.println("Exception in Session Setup after proc_main exec"+e);
							}
	System.err.println("fin_dtls_to_chrg_dtls:"+(HashMap)session.getAttribute("fin_dtls_to_chrg_dtls"));
						}
						catch(Exception e)
						{
							proc_success="N";
							System.err.println("Exception IN PROC MAIN:"+e);
						}
						
				/* Added V190403-Aravindh/GHL-CRF-0525/Starts */
				try {
					if(chkOrderCtlgAmt && !"".equals(orderCatalogCodeStr)) {
						statement=con.prepareCall(" { call bl_get_ord_cat_dtls_bef_reg(?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) } ");
						
						orderCatalogCodeStr = orderCatalogCodeStr.replace("~~", "##");
						/* Added V191204-Aravindh/GHL-ICN-0056/Starts */
						String approvedAmtArr [] = strApprovedAmt.split("\\|");
						//GHL-ICN-0061 Starts
						//if("".equals(strApprovedAmt)) {
						if(" |".equals(strApprovedAmt) || "".equals(strApprovedAmt) || "|".equals(strApprovedAmt)) {
							approvedAmtArr[0] = "0";
						}
						//GHL-ICN-0061 Ends
						double balApprovedAmt = Double.parseDouble(approvedAmtArr[0]) - (hosp_chrg_amt + med_chrg_amt + addl_chrg_amt);						
						if(balApprovedAmt < 0) {
							balApprovedAmt = 0;
						}
						/* Added V191204-Aravindh/GHL-ICN-0056/Ends */

						
						statement.setString(1, strFacilityId);
						statement.setString(2, strModuleId);
						statement.setString(3, strEpisodeType);
						statement.setString(4, strPatientId);
						statement.setString(5, strEncounterId);
						statement.setString(6, strEpisodeId);
						statement.setString(7, strVisitId);
						statement.setString(8, strHospServPanelInd);
						statement.setString(9, orderCatalogCodeStr);
						statement.setString(10, "1");
						statement.setString(11, "0");
						statement.setString(12, strBlnggrpId);
						statement.setString(13, strCustGroupCode);
						statement.setString(14, strCustCode);
						statement.setString(15, strPolicyTypeCode);
						statement.setString(16, strPolicyPriority);
						statement.setString(17, strPolicyNumber);
						statement.setString(18, strPolicyStartDate);
						statement.setString(19, strPolicyExpiryDate);
						statement.setString(20, strCreditAuthRef);
						statement.setString(21, strCreditAuthDate);
						statement.setString(22, strEffectiveFrom);
						statement.setString(23, strEffectiveTo);
						statement.setString(24, String.valueOf(balApprovedAmt).concat("|"));//Modified V191204-Aravindh/GHL-ICN-0056/strApprovedAmt -> String.valueOf(balApprovedAmt).concat("|")
						statement.setString(25, strApprovedDays);
						statement.setString(26, strNonInsBlnggrpId);
						statement.setString(27, strNonInsCustGroupCode);
						statement.setString(28, strNonInsCustCode);
						statement.setString(29, strUser);
						statement.setString(30, strWsNo);
						statement.setInt(31, acc_seq_no);
						statement.setString(32, strNull);
						statement.setString(33, locale);
						statement.setString(34, strClinicCode);
						
						statement.registerOutParameter(35, java.sql.Types.VARCHAR);
						statement.registerOutParameter(36, java.sql.Types.VARCHAR);
						statement.registerOutParameter(37, java.sql.Types.VARCHAR);
						statement.registerOutParameter(38, java.sql.Types.VARCHAR);
						statement.registerOutParameter(39, java.sql.Types.VARCHAR);
						statement.registerOutParameter(40, java.sql.Types.VARCHAR);
						statement.registerOutParameter(41, java.sql.Types.VARCHAR);
						statement.registerOutParameter(42, java.sql.Types.VARCHAR);
						statement.registerOutParameter(43, java.sql.Types.VARCHAR);
						statement.registerOutParameter(44, java.sql.Types.VARCHAR);
						statement.registerOutParameter(45, java.sql.Types.VARCHAR);
						statement.registerOutParameter(46, java.sql.Types.VARCHAR);
						statement.registerOutParameter(47, java.sql.Types.VARCHAR);
						statement.registerOutParameter(48, java.sql.Types.VARCHAR);
						statement.registerOutParameter(49, java.sql.Types.VARCHAR);
						statement.registerOutParameter(50, java.sql.Types.INTEGER);
						statement.registerOutParameter(51, java.sql.Types.VARCHAR);
						statement.registerOutParameter(52, java.sql.Types.VARCHAR);
						statement.registerOutParameter(53, java.sql.Types.VARCHAR);
						statement.registerOutParameter(54, java.sql.Types.VARCHAR);
						statement.registerOutParameter(55, java.sql.Types.VARCHAR);
						statement.registerOutParameter(56, java.sql.Types.INTEGER);
						statement.registerOutParameter(57, java.sql.Types.INTEGER);
						statement.registerOutParameter(58, java.sql.Types.INTEGER);
						statement.registerOutParameter(59, java.sql.Types.INTEGER);
						statement.registerOutParameter(60, java.sql.Types.INTEGER);
						statement.registerOutParameter(61, java.sql.Types.INTEGER);
						statement.registerOutParameter(62, java.sql.Types.INTEGER);
						statement.registerOutParameter(63, java.sql.Types.INTEGER);
						statement.registerOutParameter(64, java.sql.Types.INTEGER);
						statement.registerOutParameter(65, java.sql.Types.INTEGER);
						statement.registerOutParameter(66, java.sql.Types.INTEGER);
						statement.registerOutParameter(67, java.sql.Types.VARCHAR);
						statement.registerOutParameter(68, java.sql.Types.VARCHAR);
						statement.execute();
						

						
						orderCtlgDtls = statement.getString(67);
						if(null == orderCtlgDtls) {
							orderCtlgDtls = "";
						}
						orderCtlgTotal = statement.getString(68);
						if(null == orderCtlgTotal) {
							orderCtlgTotal = "";
						}
						
						statement.close();
						
						System.err.println("orderDtls: "+orderCtlgDtls+"; orderCtlgTotal: "+orderCtlgTotal);
					}
				} catch(Exception ex) {
					System.err.println("Exception in getting order catalog Amounts: "+ex);
					ex.printStackTrace();
				}
				/* Added V190403-Aravindh/GHL-CRF-0525/Ends */
						
					}
					else 
					{
						
						try
						{
							String sql="{call BLPatientRegnCharge.Main('"+mode+"','"+strFunctionId+"','"+strFacilityId+"','"+strModuleId+"','"+strPatientId+"','"+strPatSerCode+"','"+strEpisodeType+"',to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI'),'"+strPractitionerTypeInd+"','"+strPractitionerId+"','"+strBlnggrpId+"','"+strCustGroupCode+"','"+strCustCode+"','"+strPolicyTypeCode+"','"+strPolicyPriority+"','"+strPolicyNumber+"','"+strPolicyStartDate+"','"+strPolicyExpiryDate+"','"+strCreditAuthRef+"','"+strCreditAuthDate+"','"+strEffectiveFrom+"','"+strEffectiveTo+"','"+strApprovedAmt+"','"+strApprovedDays+"','"+strNonInsBlnggrpId+"','"+strNonInsCustGroupCode+"','"+strNonInsCustCode+"','Y','"+strHospServPanelInd+"','"+strHospServPanelCode+"','"+strHospServPanelStr+"','"+strHospServPanelQty+"','"+strHospServChargeAmt+"','"+str_bill_later_YN+"','"+strUser+"','"+strWsNo+"','"+strWsNo+"','"+strNull+"','"+strNull+"','"+locale+"',?,'"+strNull+"','"+strNull+"','"+strNull+"','"+strNull+"','"+strNull+"',?,?,?,?,?,?,?,?,?,?,?,?)}";
//								System.err.println("sql:"+sql);

							statement=con.prepareCall(sql);

							statement.setString(1,"Y");

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

							statement.execute();
							
							hosp_charge_YN= statement.getString(1);
							if(hosp_charge_YN==null || hosp_charge_YN.equals("")) hosp_charge_YN="";

							hosp_chrg_amt= statement.getDouble(2);
							hosp_chrg_pat_amt=statement.getDouble(3);
							
							bill_gen_yn=statement.getString(4);
							if(bill_gen_yn==null) bill_gen_yn="";
							bill_doc_type=statement.getString(5);
							if(bill_doc_type==null) bill_doc_type="";
							bill_doc_number=statement.getString(6);
							if(bill_doc_number==null) bill_doc_number="";
							str_bill_gen_later=statement.getString(7);
							if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="";
							str_total_bill_amt=statement.getString(8);
							if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";

							//System.err.println("hosp_chrg_amt gen from proc_main:"+hosp_chrg_amt);
							//System.err.println("hosp_chrg_pat_amt gen from proc_main:"+hosp_chrg_pat_amt);

							error_level=statement.getString(9);
							sys_message_id=statement.getString(10);
							error_text=statement.getString(11);
				
							statement.close();
							
							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";

//								System.err.println("error_level:"+error_level);
//								System.err.println("sys_message_id:"+sys_message_id);
//								System.err.println("error_text:"+error_text);

							if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
							{
								strValidatedState = "E";	
							}
							else
							{
								strValidatedState = "Y";
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
				
							String upd_hosp_chrg_pat_amt=(String)session.getAttribute("upd_hosp_chrg_pat_amt");
							if(upd_hosp_chrg_pat_amt!=null)
							{
								str_hosp_chrg_pat_amt=upd_hosp_chrg_pat_amt;
								hosp_chrg_pat_amt=Double.parseDouble(str_hosp_chrg_pat_amt);
							}

							try
							{
								CurrencyFormat cf1 = new CurrencyFormat();
		
								if (str_hosp_chrg_amt!=null)
									str_hosp_chrg_amt = cf1.formatCurrency(str_hosp_chrg_amt, noofdecimal);
								if(str_hosp_chrg_pat_amt!=null)
									str_hosp_chrg_pat_amt = cf1.formatCurrency(str_hosp_chrg_pat_amt, noofdecimal);
							}
							catch(Exception e)
							{
								System.err.println("Currency exception ::"+e);
							}

//								System.err.println("hosp_charge_YN:"+hosp_charge_YN);
//								System.err.println("hosp_chrg_amt:"+hosp_chrg_amt);
//								System.err.println("bill_gen_yn:"+bill_gen_yn);
//								System.err.println("str_bill_gen_later:"+str_bill_gen_later);
//								System.err.println("str_total_bill_amt:"+str_total_bill_amt);

							HashMap hosp_dtls_check=(HashMap)session.getAttribute("hosp_dtls");
							if(hosp_dtls_check==null)
							{
								hosp_dtls.put("hosp_serv_panel_ind",strHospServPanelInd);
								hosp_dtls.put("hosp_serv_panel_code",strHospServPanelCode);
								hosp_dtls.put("hosp_serv_panel_str",strHospServPanelStr);
								hosp_dtls.put("hosp_serv_panel_qty",String.valueOf(strHospServPanelQty));
								hosp_dtls.put("hosp_serv_chrg_amt",String.valueOf(strHospServChargeAmt));
								session.setAttribute("hosp_dtls",hosp_dtls);
//									System.err.println("hosp_dtls111:"+session.getAttribute("hosp_dtls"));
							}
//								System.err.println("hosp_dtls:"+session.getAttribute("hosp_dtls"));

							HashMap prof_dtls_check=(HashMap)session.getAttribute("prof_dtls");
							if(prof_dtls_check==null)
							{
								prof_dtls.put("prof_serv_panel_ind",strMedServPanelInd);
								prof_dtls.put("prof_serv_panel_code",strMedServPanelCode);
								prof_dtls.put("prof_serv_panel_str",strMedServPanelStr);
								prof_dtls.put("prof_serv_panel_qty",String.valueOf(strMedServPanelQty));
								prof_dtls.put("prof_serv_chrg_amt",String.valueOf(strMedServChargeAmt));
								session.setAttribute("prof_dtls",prof_dtls);
	//							System.err.println("prof_dtls:"+session.getAttribute("prof_dtls"));
							}

							HashMap addl_dtls_check=(HashMap)session.getAttribute("addl_dtls");
							if(addl_dtls_check==null)
							{
								addl_dtls.put("addl_serv_panel_ind",strAddlServPanelInd);
								addl_dtls.put("addl_serv_panel_code",strAddlServPanelCode);
								addl_dtls.put("addl_serv_panel_str",strAddlServPanelStr);
								addl_dtls.put("addl_serv_panel_qty",String.valueOf(strAddlServPanelQty));
								addl_dtls.put("addl_serv_chrg_amt",String.valueOf(strAddlServChargeAmt));
								session.setAttribute("addl_dtls",addl_dtls);
	//							System.err.println("prof_dtls:"+session.getAttribute("prof_dtls"));
							}

//								System.err.println("addl_dtls:"+session.getAttribute("addl_dtls"));
							try
							{

								fin_dtls_to_chrg_dtls.put("billing_group",strBlnggrpId);
								fin_dtls_to_chrg_dtls.put("cust_group_code",strCustGroupCode);
								fin_dtls_to_chrg_dtls.put("cust_code",strCustCode);
								fin_dtls_to_chrg_dtls.put("policy_type_code",strPolicyTypeCode);
								fin_dtls_to_chrg_dtls.put("policy_priority",strPolicyPriority);
								fin_dtls_to_chrg_dtls.put("policy_no",strPolicyNumber);
								fin_dtls_to_chrg_dtls.put("policy_start_date",strPolicyStartDate);
								fin_dtls_to_chrg_dtls.put("policy_exp_date",strPolicyExpiryDate);
								fin_dtls_to_chrg_dtls.put("credit_auth_ref",strCreditAuthRef);
								fin_dtls_to_chrg_dtls.put("credit_auth_date",strCreditAuthDate);
								fin_dtls_to_chrg_dtls.put("policy_eff_from_date",strEffectiveFrom);
								fin_dtls_to_chrg_dtls.put("policy_eff_to_date",strEffectiveTo);
								fin_dtls_to_chrg_dtls.put("approved_amt",strApprovedAmt);
								fin_dtls_to_chrg_dtls.put("approved_days",strApprovedDays);
								fin_dtls_to_chrg_dtls.put("non_ins_blng_grp_id",strNonInsBlnggrpId);
								fin_dtls_to_chrg_dtls.put("non_ins_cust_group_code",strNonInsCustGroupCode);
								fin_dtls_to_chrg_dtls.put("non_ins_cust_code",strNonInsCustCode);
								fin_dtls_to_chrg_dtls.put("user_id",strUser);
								fin_dtls_to_chrg_dtls.put("ws_no",strWsNo);
								session.setAttribute("fin_dtls_to_chrg_dtls",fin_dtls_to_chrg_dtls);
							}
							catch(Exception e)
							{
								System.err.println("Exception in Session Setup after proc_main exec"+e);
							}

	//						System.err.println("fin_dtls_to_chrg_dtls:"+(HashMap)session.getAttribute("fin_dtls_to_chrg_dtls"));
						}
						catch(Exception e)
						{
							proc_success="N";
							System.err.println("Exception IN PROC MAIN:"+e);
						}
					
					}
				}
			}
		}
	}			// Module Id OP End if

//	System.err.println("Over");	
	}
	catch(Exception exp)
	{	
		System.err.println("Main Error:"+exp);
		error_text = exp.toString();
		error_level="10";
		strValidatedState = "E";
	}
	finally
	{  // Added on Bangalore on 13/10/2005
		if (con != null)
		{
			ConnectionManager.returnConnection(con,request);	
		}
	}	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(disaster_regn_YN));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strStartValid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strValidatedState));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strClinicCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strVisitType));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strPractitionerId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strPractitionerTypeInd));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strFunctionId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strUser));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(error_text));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(error_level));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sys_message_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(encounter_date_time));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strPatSerCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(charge_for_pat_regn_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strBlnggrpId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strCustGroupCode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strCustCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPolicyPriority));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strPolicyTypeCode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strPolicyNumber));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strPolicyStartDate));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strPolicyExpiryDate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strCreditAuthRef));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strCreditAuthDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strApprovedDays));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strApprovedAmt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strEffectiveFrom));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strEffectiveTo));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strNonInsBlnggrpId));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strNonInsCustGroupCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strNonInsCustCode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strNursingUnitCode));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strNursingUnitType));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strBedClass));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strBedType));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strBedNo));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strSettlementInd));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strDepositApplYN));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strAddlDepositApplYN));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strDepositAmt));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strAddlDepositAmt));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(hosp_charge_YN));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(med_charge_YN));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(addl_charge_YN));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strExemptdate));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strBillGen));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(strHospServPanelInd));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(strHospServPanelCode));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strHospServPanelQty));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strHospServChargeAmt));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strMedServPanelInd));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strMedServPanelCode));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(strMedServPanelQty));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strMedServChargeAmt));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(strAddlServPanelInd));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(strAddlServPanelCode));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(strAddlServPanelQty));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strAddlServChargeAmt));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(str_hosp_chrg_amt));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(str_hosp_chrg_pat_amt));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(str_med_chrg_amt));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(str_med_chrg_pat_amt));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(str_addl_chrg_amt));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(str_addl_chrg_pat_amt));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(str_epi_type_clinic_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(strSpecialistClinicYN));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strSpecialistCashCntrYN));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(orderCatalogCodeStr));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(orderCtlgDtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(orderCtlgTotal));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(chkOrderCtlgAmt));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(reg_referral_flag));
            _bw.write(_wl_block85Bytes, _wl_block85);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
