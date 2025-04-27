package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import eBL.BLReportIdMapper;
import java.util.*;
import com.ehis.util.*;

public final class __bladhocdiscbypayer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAdhocDiscByPayer.jsp", 1733998629351L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<STYLE TYPE=\"text/CSS\">\n/* This style is used for locking the table\'s heading  */\n\n\tTD.YW{\n\t\tBACKGROUND-COLOR:YELLOW;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n\n\tTD.GY{\n\t\tBACKGROUND-COLOR:GREY;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t}\n\n\t\tTD.GR{\n\t\tBACKGROUND-COLOR:GREEN;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n\t\t\tTD.DC{\n\t\tBACKGROUND-COLOR:DARKCYAN;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t\t}\n\t\t\tTD.BL{\n\t\tBACKGROUND-COLOR:BLUE;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t\t}\n\n\t\t\tTD.PK{\n\t\tBACKGROUND-COLOR:PINK;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t\t}\n\t\t\tTD.WH{\n\t\tBACKGROUND-COLOR:WHITE;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t\t}\t\t\n\n\n/* This style is used for locking the table\'s heading  */\n\ndiv#tbl-container {\nheight: 225px;\noverflow: auto;\n}\n\nthead td, thead td.locked\t{\nposition:relative;\n}\n\nthead td {\ntop: expression(document.getElementById(\"tbl-container\").scrollTop-2); \nz-index: 20;\n}\n\n</STYLE>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/BLAdhocDisc.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<script>\nasync function callAdhocDisc(i)\n{\n\tvar adhoc_user_id=\"\";\n\tvar adhoc_reason_code=\"\";\n\tvar total_records=document.forms[0].total_records.value;\n\t\t\t\n\tvar patient_id = document.forms[0].patient_id.value;\n\tvar episode_type = document.forms[0].episode_type.value;\n\tvar episode_id = document.forms[0].episode_id.value;\n\tvar visit_id = document.forms[0].visit_id.value;\n\tvar module_id = document.forms[0].module_id.value;\n\tvar decimal = document.forms[0].noofdecimal.value;\n\tvar existing_reason_code = document.forms[0].existing_reason_code.value;\n\n\tvar selected_serv_rec = document.forms[0].selected_serv_rec.value;\n\tselected_serv_rec=eval(selected_serv_rec);\n\n\tvar blng_serv_code = eval(\"document.forms[0].blng_serv_code\"+i);\t\n\tblng_serv_code = blng_serv_code.value;\n\n\tvar serv_item_code = eval(\"document.forms[0].serv_item_code\"+i);\t\n\tserv_item_code = serv_item_code.value;\n\n\tvar serv_item_desc = eval(document.getElementById(\"serv_item_desc\"+i));\t\n\tserv_item_desc = encodeURIComponent(serv_item_desc.innerText);\n\n\tvar upd_net_charge_amt = eval(document.getElementById(\"net_amt\"+i));\t\n\tupd_net_charge_amt = upd_net_charge_amt.innerText;\n\tvar act_gross_amt = eval(\"document.forms[0].act_gross_amt\"+i);\t\n\tact_gross_amt = act_gross_amt.value;\t\n\tvar upd_gross_charge_amt = eval(document.getElementById(\"gross_amt\"+i));\t\n\tupd_gross_charge_amt = upd_gross_charge_amt.innerText;\t\n\tvar upd_disc_amt = eval(document.getElementById(\"disc_amt\"+i));\n\tupd_disc_amt = upd_disc_amt.innerText;\n\t\t\t\n\t//Added V200326-MuthuN/NMC-JD-CRF-050\n\tvar org_disc_amt = eval(document.getElementById(\"org_disc_amt\"+i));\n\torg_disc_amt = org_disc_amt.value;\n\t//Added V200326-MuthuN/NMC-JD-CRF-050\n\t\t\t\n\tvar trx_doc_ref = eval(\"document.forms[0].trx_doc_ref\"+i);\t\n\ttrx_doc_ref = trx_doc_ref.value;\t\n\tvar trx_doc_ref_line_no = eval(\"document.forms[0].trx_doc_ref_line_no\"+i);\t\n\ttrx_doc_ref_line_no = trx_doc_ref_line_no.value;\t\n\tvar trx_doc_ref_seq_no = eval(\"document.forms[0].trx_doc_ref_seq_no\"+i);\t\n\ttrx_doc_ref_seq_no = trx_doc_ref_seq_no.value;\t\n\n\tvar disc_allowed_yn=eval(\"document.forms[0].dis_yes_no\"+i);\n\tdisc_allowed_yn=disc_allowed_yn.value;\t\t\t\n\tif(disc_allowed_yn==\"N\")\n\t{\n\t\talert(\'Adhoc Discount not applicable for the copay amount\');\n\t\treturn;\n\t}\t\n\t\t\t\n\t//cust code details\n\tvar cust_code_ref = eval(\"document.forms[0].cust_code\"+i);\t\n\t\t\t\n\tvar cust_code\t=\tcust_code_ref.value;\n\tvar retVal=\"\";\n\tvar dialogHeight= \"70vh\" ;\n\tvar dialogWidth\t= \"80vw\" ;\n\tvar dialogTop = \"10\" ;\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; scroll=no; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\t\n\t//var title=encodeURIComponent(getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\"));\n\tvar title=\"\";//\"Adhoc Discount\";\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"patient_id=\"+patient_id+\"&\"+\"episode_type=\"+episode_type+\"&\"+\"episode_id=\"+episode_id+\"&\"+\"visit_id=\"+visit_id+\"&\"+\"blng_serv_code=\"+blng_serv_code+\"&\"+\"serv_item_code=\"+serv_item_code+\"&\"+\"serv_item_desc=\"+serv_item_desc+\"&\"+\"upd_net_charge_amt=\"+upd_net_charge_amt+\"&\"+\"act_gross_amt=\"+act_gross_amt+\"&\"+\"upd_gross_charge_amt=\"+upd_gross_charge_amt+\"&\"+\"upd_disc_amt=\"+upd_disc_amt+\"&\"+\"trx_doc_ref=\"+trx_doc_ref+\"&\"+\"trx_doc_ref_line_no=\"+trx_doc_ref_line_no+\"&\"+\"trx_doc_ref_seq_no=\"+trx_doc_ref_seq_no+\"&\"+\"existing_reason_code=\"+existing_reason_code+\"&called_frm_frame=P&module_id=\"+module_id+\"&cust_code=\"+cust_code+\"&org_disc_amt=\"+org_disc_amt;//Added V200326-MuthuN/NMC-JD-CRF-050\n\n\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLAdhocDiscDtlsEditFrame.jsp?\"+param,arguments,features);\t\t\t\n\n\tif (retVal != null || retVal!=\"\")\n\t{\n\t\tif(retVal!=\'undefined\' && retVal!=undefined)\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\t\t\t\n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"|\");\t\t\t\t\t\n\t\t\t\tadhoc_user_id = arr[0];\n\t\t\t\tadhoc_reason_code = arr[1];\n\n\t\t\t\tvar disc_reason_code = eval(\"document.forms[0].disc_reason_code\"+i);\t\n\t\t\t\tdisc_reason_code.value = adhoc_reason_code;\n\n\t\t\t\tvar adhoc_user_id = eval(\"document.forms[0].adhoc_user_id\"+i);\t\n\t\t\t\tadhoc_user_id.value=adhoc_user_id;\n\n\t\t\t\tdocument.forms[0].existing_reason_code.value = adhoc_reason_code;\n\n\t\t\t\tvar payer_retArr = refresh_payer_disc(i,trx_doc_ref,trx_doc_ref_line_no,trx_doc_ref_seq_no,existing_reason_code,patient_id,episode_type,episode_id,visit_id);\n\n\t\t\t\tvar payer_arr_msg = new Array();\n\t\t\t\tpayer_arr_msg=payer_retArr.split(\"|\");\n\t\t\t\t\t\t\n\t\t\t\tvar payer_upd_gross_charge_amt = eval(document.getElementById(\"gross_amt\"+i));\n\t\t\t\tpayer_upd_gross_charge_amt.innerText = payer_arr_msg[0];\n\t\t\t\t\t\t\n\t\t\t\tvar payer_upd_disc_amt = eval(document.getElementById(\"disc_amt\"+i));\t\n\t\t\t\tpayer_upd_disc_amt.innerText = payer_arr_msg[1];\n\n\t\t\t\tvar payer_upd_net_charge_amt = eval(document.getElementById(\"net_amt\"+i));\n\t\t\t\tpayer_upd_net_charge_amt.innerText = payer_arr_msg[2];\n\n\t\t\t\tvar payer_act_gross_amt = eval(\"document.forms[0].act_gross_amt\"+i);\t\n\t\t\t\tpayer_act_gross_amt.value = payer_arr_msg[3];\n\t\t\t\t\t\t\n\t\t\t\t/* Added V180116-Aravindh/MMSVAT Starts*/\n\t\t\t\tvar payer_addl_chrg_amt = eval(document.getElementById(\"addl_charge_for_payer\"+i));\n\t\t\t\tpayer_addl_chrg_amt.innerText = payer_arr_msg[4];\n\t\t\t\t/* Added V180116-Aravindh/MMSVAT Ends*/\n\n\t\t\t\tvar serv_retArr = refresh_serv_disc(i,trx_doc_ref,trx_doc_ref_line_no,existing_reason_code,patient_id,episode_type,episode_id,visit_id);\n\n\t\t\t\tvar serv_arr_msg = new Array();\n\t\t\t\tserv_arr_msg=serv_retArr.split(\"|\");\n\t\t\t\t\t\t\n\t\t\t\tvar serv_upd_gross_charge_amt = eval(parent.frames[1].document.getElementById(\"gross_amt\"+selected_serv_rec));\n\t\t\t\tserv_upd_gross_charge_amt.innerText = serv_arr_msg[0];\n\t\t\t\t\t\t\n\t\t\t\tvar serv_upd_disc_amt = eval(parent.frames[1].document.getElementById(\"disc_amt\"+selected_serv_rec));\t\n\t\t\t\tserv_upd_disc_amt.innerText = serv_arr_msg[1];\n\n\t\t\t\tvar serv_upd_net_charge_amt = eval(parent.frames[1].document.getElementById(\"net_amt\"+selected_serv_rec));\n\t\t\t\tserv_upd_net_charge_amt.innerText = serv_arr_msg[2];\n\n\t\t\t\tvar serv_act_gross_amt = eval(\"parent.frames[1].document.forms[0].act_gross_amt\"+selected_serv_rec);\t\n\t\t\t\tserv_act_gross_amt.value = serv_arr_msg[3];\n\n\t\t\t\tparent.frames[3].document.getElementById(\"tot_gross_amt\").innerText = serv_arr_msg[0];\n\t\t\t\t\t\n\t\t\t\tparent.frames[3].document.getElementById(\"tot_disc_amt\").innerText = serv_arr_msg[1];\n\n\t\t\t\tparent.frames[3].document.getElementById(\"tot_net_amt\").innerText = serv_arr_msg[2];\n\n\t\t\t\tvar tot_rec_by_ser = parent.frames[1].document.forms[0].total_records.value;\n\t\t\t\tvar temp_tot_gross_amt=0, temp_tot_disc_amt=0, temp_tot_net_amt=0; \n\n\t\t\t\tfor(var i=0;i<tot_rec_by_ser;i++)\n\t\t\t\t{\n\t\t\t\t\tvar tot_serv_upd_gross_charge_amt = eval(parent.frames[1].document.getElementById(\"gross_amt\"+i));\n\t\t\t\t\ttemp_tot_gross_amt = temp_tot_gross_amt+eval(tot_serv_upd_gross_charge_amt.innerText);\n\n\t\t\t\t\tvar tot_serv_upd_disc_amt = eval(parent.frames[1].document.getElementById(\"disc_amt\"+i));\t\n\t\t\t\t\ttemp_tot_disc_amt = temp_tot_disc_amt+eval(tot_serv_upd_disc_amt.innerText);\n\n\t\t\t\t\tvar tot_serv_upd_net_charge_amt = eval(parent.frames[1].document.getElementById(\"net_amt\"+i));\n\t\t\t\t\ttemp_tot_net_amt = temp_tot_net_amt+eval(tot_serv_upd_net_charge_amt.innerText);\n\t\t\t\t}\n\t\t\t\ttemp_tot_gross_amt = temp_tot_gross_amt.toFixed(decimal);\n\t\t\t\ttemp_tot_disc_amt = temp_tot_disc_amt.toFixed(decimal);\n\t\t\t\ttemp_tot_net_amt = temp_tot_net_amt.toFixed(decimal);\n\n\t\t\t\tdocument.forms[0].tot_serv_gross_amt.value = temp_tot_gross_amt;\n\t\t\t\tdocument.forms[0].tot_serv_disc_amt.value = temp_tot_disc_amt;\n\t\t\t\tdocument.forms[0].tot_serv_net_amt.value = temp_tot_net_amt;\n\t\t\t\t\t\t\n\t\t\t\tputdeci(document.forms[0].tot_serv_gross_amt);\n\t\t\t\tputdeci(document.forms[0].tot_serv_disc_amt);\n\t\t\t\tputdeci(document.forms[0].tot_serv_net_amt);\n\n//\t\t\t\t\t\tdocument.forms[0].target=\'payer_frame\';\n//\t\t\t\t\t\tdocument.forms[0].action=\"../../eBL/jsp/BLAdhocDiscByPayer.jsp\";\n//\t\t\t\t\t\tdocument.forms[0].submit();\n\t\t\t}\n\t\t}\n\t}\n}\t\n\t\t\nasync function callAddlChargeDistri(sel_rec)\n{\n\tvar trx_doc_ref = eval(\"document.forms[0].trx_doc_ref\"+sel_rec);\t\n\ttrx_doc_ref = trx_doc_ref.value;\t\n\n\tvar trx_doc_ref_line_no = eval(\"document.forms[0].trx_doc_ref_line_no\"+sel_rec);\t\n\ttrx_doc_ref_line_no = trx_doc_ref_line_no.value;\t\n\n\tvar trx_doc_ref_seq_no = eval(\"document.forms[0].trx_doc_ref_seq_no\"+sel_rec);\t\n\ttrx_doc_ref_seq_no = trx_doc_ref_seq_no.value;\t\n\n\tvar addl_charge_for_payer = eval(document.getElementById(\"addl_charge_for_payer\"+sel_rec));\t\n\taddl_charge_for_payer = addl_charge_for_payer.innerText;\t\t\t\t\n\n\tvar retVal=\"\";\n\tvar dialogHeight= \"41vh\" ;\n\tvar dialogWidth\t= \"40vw\" ;\n\tvar dialogTop = \"10\" ;\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; scroll=no; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\t\n\n\tvar title=\"\";\n\tvar arguments = \"\" ;\n\n\tvar param = \"title=\"+title+\"&trx_doc_ref=\"+trx_doc_ref+\"&trx_doc_ref_line_no=\"+trx_doc_ref_line_no+\"&trx_doc_ref_seq_no=\"+trx_doc_ref_seq_no+\"&total_addl_charge_for_payer=\"+addl_charge_for_payer;\n\n\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLAddlServChargeDtlsFrame.jsp?\"+param,arguments,features);\n}\n\nfunction chkForIncl(sel_row)\n{\n\tvar sel_row_serv_incl_for_disc=eval(\"document.forms[0].serv_incl_for_disc\"+sel_row);\t\n\n\tif(sel_row_serv_incl_for_disc.value == \"YES\")\n\t{\n\t\tsel_row_serv_incl_for_disc.checked = true;\n\t}\n\telse\n\t{\n\t\tsel_row_serv_incl_for_disc.checked=false;\n\t}\n\n}\n</script>\n\n<BODY onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n<FORM name=\'AdhocDicountsbyPayerForm\' id=\'AdhocDicountsbyPayerForm\' action=\"\" method=\'\'>\n\n<table cellpadding=\'3\' cellspacing=\'0\'  width=\'100%\'>\n\t<tr>\n\t\t<td width=\'35%\' class=\'l";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="abel\' >&nbsp;</td>\n\t\t<td width=\'20%\' class=\'label\'><div align=\"right\"><b>";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="</b></div></td>\n\t\t<td width=\'15%\' class=\"fields\"><div align=\"right\"><input type=\'text\' name=\'tot_serv_gross_amt\' id=\'tot_serv_gross_amt\' size=\'5\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' readonly style=\'text-align:right\' ></div></td>\n\t\t<td width=\'15%\' class=\"fields\"><div align=\"right\"><input type=\'text\' name=\'tot_serv_disc_amt\' id=\'tot_serv_disc_amt\' size=\'5\'  maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' readonly style=\'text-align:right\'></div></td>\n\t\t<td width=\'15%\' class=\"fields\"><div align=\"right\"><input type=\'text\' name=\'tot_serv_net_amt\' id=\'tot_serv_net_amt\' size=\'5\'  maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' readonly style=\'text-align:right\'></div></td>\n\t</tr>\n</table>\n<div id=\'tbl-container\'>\n\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\t\n\t<thead>\n\t\t<tr>\t\t\t\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td class=\'COLUMNHEADER\' width=\'3%\'>Color ind</td>\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'12%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n<!--\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n-->\n\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t<!-- Added V190820-MuthuN/NMC-JD-SCF-0015 -->\n\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</td>\n\t\t\t<!-- Added V190820-MuthuN/NMC-JD-SCF-0015 -->\n\t\t</tr>\n\t</thead>\n\t<tbody>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<tr>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' width=\'3%\'>&nbsp</td>\t\t\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" width=\'12%\'><div id=\"billing_service";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<td class=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" width=\'15%\'><div id=\"billing_service";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\t\n\t\t\t<font size=1>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font></div></td>\n\t\t\t<input type=\"hidden\" name=\"blng_serv_code";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"blng_serv_code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"\tvalue=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t\t\t<td class=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" width=\'15%\'><div id=\"serv_item_desc";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"><font size=1>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</font></div></td>\n\t\t\t<input type=\"hidden\" name=\"serv_item_code";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"serv_item_code";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" width=\'15%\'><div id=\"billing_group";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font></div></td>\n\t\t\t<input type=\"hidden\" name=\"blng_grp_id";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"blng_grp_id";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" width=\'15%\'><div id=\"payer";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</font></div></td>\n\t\t\t<input type=\"hidden\" name=\"cust_code";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"cust_code";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" width=\'15%\'><div id=\"policy";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</font></div></td>\n\t\t\t<input type=\"hidden\" name=\"policy_type_code";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"policy_type_code";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" width=\'5%\' ><div style=\'text-align:right\' id=\"gross_amt";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</div></td>\n\t\t\t<td class=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" width=\"5%\">\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<a href=\"#\" onClick=\"callAdhocDisc(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')\" ><div id=\'disc_amt";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' align=\'right\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</div></a>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t<a href=\"#\" onClick=\"callAdhocDisc(\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t<div id=\'disc_amt";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</div>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t</td>\t\n\t\t\t<td class=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" width=\'5%\' ><div style=\'text-align:right\' id=\"net_amt";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</div></td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t<td class=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" width=\'5%\' ><div align=\'center\'><INPUT TYPE=\"checkbox\" name=\"serv_incl_for_disc";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"serv_incl_for_disc";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" value=\"YES\" CHECKED onClick=\"chkForIncl(\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\');\"></div></td>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" value=\"NO\" onClick=\"chkForIncl(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t<!-- Added V190820-MuthuN/NMC-JD-SCF-0015 -->\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t<td class=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" width=\'5%\' ><div style=\'text-align:right\'><a id=\"addl_charge_for_payer";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" href=\"#\" onClick=\"callAddlChargeDistri(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\')\" title=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</a></div></td>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" width=\'5%\' ><div style=\'text-align:right\' id=\"addl_charge_for_payer";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" title=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t<input type=\"hidden\" name=\"act_gross_amt";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"act_gross_amt";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n\t\t\t<input type=\"hidden\" name=\"trx_doc_ref";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"trx_doc_ref";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t\t\t<input type=\"hidden\" name=\"trx_doc_ref_line_no";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"trx_doc_ref_line_no";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\n\t\t\t<input type=\"hidden\" name=\"trx_doc_ref_seq_no";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"trx_doc_ref_seq_no";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\n\t\t\t<input type=\"hidden\" name=\"discount_allowed_yn";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"discount_allowed_yn";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"\tvalue=\"\" >\n\t\t\t<input type=\"hidden\" name=\"disc_reason_code";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"disc_reason_code";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"\tvalue=\"\" >\n\t\t\t<input type=\"hidden\" name=\"adhoc_disc_amt";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"adhoc_disc_amt";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n\t\t\t<input type=\"hidden\" name=\"adhoc_user_id";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"adhoc_user_id";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\n\t\t\t<input type=\"hidden\" name=\"dis_yes_no";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"dis_yes_no";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t<!-- Added V200330-MuthuN/NMC-JD-CRF-050 -->\n\t\t\t<input type=\"hidden\" name=\"org_disc_amt";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"org_disc_amt";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" >\n\t\t\t<!-- Added V200330-MuthuN/NMC-JD-CRF-050 -->\n\t\t</tr>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="  \n\t</tbody>\n\t</table>\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\"\tvalue=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" >\n\t<input type=\"hidden\" name=\"total_records\" id=\"total_records\"\tvalue=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" >\n\t<input type=\"hidden\" name=\"noofdecimal\" id=\"noofdecimal\"\tvalue=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" >\n\t<input type=\"hidden\" name=\"checked_services\" id=\"checked_services\" value=\"\">\n\t<input type=\"hidden\" name=\"existing_reason_code\" id=\"existing_reason_code\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t<input type=\"hidden\" name=\"trx_doc_ref\" id=\"trx_doc_ref\"\tvalue=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" >\n\t<input type=\"hidden\" name=\"trx_doc_ref_line_no\" id=\"trx_doc_ref_line_no\"\tvalue=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" >\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" >\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" >\n\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\"\tvalue=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" >\n\t<input type=\"hidden\" name=\"visit_id\" id=\"visit_id\"\tvalue=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" >\n\t<input type=\"hidden\" name=\"selected_serv_rec\" id=\"selected_serv_rec\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t<!-- Added V200327-MuthuN/NMC-JD-CRF-050 -->\n\t<input type=\"hidden\" name=\"preConfigDiscAmt\" id=\"preConfigDiscAmt\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t<!-- Added V200327-MuthuN/NMC-JD-CRF-050 -->\n\n</form>\n<script>\n\tparent.frames[3].location.href=\"../../eBL/jsp/BLAdhocDiscBtn.jsp?";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"\n</script>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	ResultSet rs				= null;	
	ResultSet rs1				= null;	
	CallableStatement  cstmt1 	= null;
	String classval="" ;
	int noofdecimal=2;
	boolean amountRoundOff = true; //Added V180125-Subha/MMS-JU-SCF-0102
	boolean siteSpecNMC=false;//Added V190820-MuthuN/NMC-JD-SCF-0015
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	//Added V200323-MuthuN/NMC-JD-CRF-050
	boolean preConfigDiscAmt_YN=false;//Added V200323-MuthuN/NMC-JD-CRF-050
	String preConfigDiscAmt="";
	String settlementIndfolio="";//NMC-JD-SCF-055
	//Added V200323-MuthuN/NMC-JD-CRF-050
	try
	{
		con	=	ConnectionManager.getConnection(request);
		siteSpecNMC = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_CMN_FUN_ME_YN");//Added V190820-MuthuN/NMC-JD-SCF-0015

		//Added V200323-MuthuN/NMC-JD-CRF-050
		preConfigDiscAmt_YN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ADDITIONAL_ADHOC");
		if(preConfigDiscAmt_YN){
			preConfigDiscAmt="Y";
		}
		else{
			preConfigDiscAmt="N";
		}
		//Added V200323-MuthuN/NMC-JD-CRF-050

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		CurrencyFormat cf1 = new CurrencyFormat();
		String query_string=request.getQueryString();

		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	

		String str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String str_custmr_id = request.getParameter("customer_id");	
		if(str_custmr_id==null) str_custmr_id="";
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1		
		try {
			site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
			} catch(Exception ex) {
				System.err.println("Error in BlAdhocDiscByPayer.jsp for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
			}
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}		
			rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("3="+e.toString());
		}
		
		//Added V180125-Subha/MMS-JU-SCF-0102 try
		try {
			pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
			rs = pstmt.executeQuery();	
			if ( rs != null && rs.next()) {
				if(rs.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
					amountRoundOff = false;
				}
			}
		} catch(Exception e) {   
			e.printStackTrace();
			System.out.println("4="+e.toString());
		} finally {
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 		
		}
	
		//Added V171212-Gayathri/MMS-DM-CRF-0118/Starts
		Boolean SiteSpec_VAT=false;
		String SiteSpecific_VAT ="";
		try
		{
			SiteSpec_VAT = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","VAT_CHANGES_APPLICABLE_YN");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(SiteSpec_VAT){
			SiteSpecific_VAT="Y";
		}
		else{
			SiteSpecific_VAT="N";
		}
		//Added V171212-Gayathri/MMS-DM-CRF-0118/Ends
		String str_module_id     =  request.getParameter("module_id");	
		if(str_module_id == null) str_module_id="";
		String str_patient_id = request.getParameter("patient_id");	
		if(str_patient_id==null) str_patient_id="";	
		
		String str_episode_type = request.getParameter("episode_type");	
		if(str_episode_type==null) str_episode_type="";	
	
		String str_episode_id = request.getParameter("episode_id");	
		if(str_episode_id==null) str_episode_id="";	

		String str_visit_id = request.getParameter("visit_id");	
		if(str_visit_id==null) str_visit_id="";	
	
		String str_encounter_id = request.getParameter("encounter_id");	
		if(str_encounter_id==null) str_encounter_id="";	

		String selected_serv_rec = request.getParameter("selected_serv_rec");
		if(selected_serv_rec==null) selected_serv_rec="";	

		String tot_upd_gross_charge_amt = request.getParameter("tot_upd_gross_charge_amt");
		if(tot_upd_gross_charge_amt==null) tot_upd_gross_charge_amt="0";		
		//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
		if(amountRoundOff) {
			tot_upd_gross_charge_amt = cf1.formatCurrency(tot_upd_gross_charge_amt, noofdecimal);
		} else {
			tot_upd_gross_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(tot_upd_gross_charge_amt, noofdecimal);	
		}

		String tot_upd_disc_amt = request.getParameter("tot_upd_disc_amt");
		if(tot_upd_disc_amt==null) tot_upd_disc_amt="0";	
		//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
		if(amountRoundOff) {
			tot_upd_disc_amt = cf1.formatCurrency(tot_upd_disc_amt, noofdecimal);
		} else {
			tot_upd_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(tot_upd_disc_amt, noofdecimal);
		}

		String tot_upd_net_charge_amt = request.getParameter("tot_upd_net_charge_amt");
		if(tot_upd_net_charge_amt==null) tot_upd_net_charge_amt="0";		
		//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
		if(amountRoundOff) {
			tot_upd_net_charge_amt = cf1.formatCurrency(tot_upd_net_charge_amt, noofdecimal);
		} else {
			tot_upd_net_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(tot_upd_net_charge_amt, noofdecimal);
		}

		String blng_serv_code ="", serv_desc="",blng_grp_id="",blng_grp_desc="", policy_type_code="", cust_code="", cust_long_name="", policy_desc="", adhoc_disc_amt="",act_gross_amt="", serv_item_code="",serv_item_desc="", org_gross_amt="";
		
		String trx_doc_ref="",trx_doc_ref_line_no="",trx_doc_ref_seq_no="", str_addl_charge_for_payer="",str_addl_chg_value="";

		int i=0;
		double addl_charge_for_payer=0;
		
		String upd_gross_charge_amt="", upd_disc_amt="" , upd_net_charge_amt="" , existing_reason_code="" ;

		String org_disc_amt="";//NMC-JD-CRF-050

		trx_doc_ref = request.getParameter("trx_doc_ref");	
		if(trx_doc_ref==null) trx_doc_ref="";	
		
		trx_doc_ref_line_no = request.getParameter("trx_doc_ref_line_no");	
		if(trx_doc_ref_line_no==null) trx_doc_ref_line_no="";	
		
		String   trx_doc_ref_seq_num="";
		String  str_color_code  ="";
		String  str_color_band ="";
		String str_settlement_ind="";
		String  str_trx_status ="";		
		String discountYesNo="";//Added by Vijay A.P. for PMG CRF

            _bw.write(_wl_block5Bytes, _wl_block5);
	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tot_upd_gross_charge_amt));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tot_upd_disc_amt));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tot_upd_net_charge_amt));
            _bw.write(_wl_block11Bytes, _wl_block11);
	//Added site3TierAlmoFeatureYN V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		if(str_custmr_id.equals("ALMO") || site3TierAlmoFeature == true)
		{  
			cstmt1  =  con.prepareCall("{ call BLCOMMONPROC.GET_COLOR_CODE(?,?,?,?,?,?,?)}");		
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}else { 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
if(siteSpecNMC){
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
} else {
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

		try
		{		
	
			String strsql = "select BLNG_SERV_CODE,BLNG_GRP_ID,POLICY_TYPE_CODE,CUST_CODE,UPD_GROSS_CHARGE_AMT,NVL(UPD_DISC_AMT,0),UPD_NET_CHARGE_AMT,TRX_DOC_REF_SEQ_NUM,ACT_GROSS_AMT,NVL(ADHOC_DISC_AMT,0),SERV_ITEM_CODE,DECODE(?,'en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC, ORG_GROSS_CHARGE_AMT,TRX_DOC_REF_SEQ_NUM, org_disc_amt,SETTLEMENT_IND from bl_patient_charges_folio"
			+" where operating_facility_id = ?"
			+" and episode_type = ?"
			+" and patient_id   = ?"
			//Commented V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 start
			/* +" and episode_id = NVL('"+str_episode_id+"',EPISODE_ID)"
			+" and visit_id   = NVL('"+str_visit_id+"',VISIT_ID)" */
			//Commented V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 end
			//Added V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 start
			+" AND ((? IN ('O', 'E') AND episode_id = NVL (?, episode_id) AND visit_id = NVL (?, visit_id))"
			+" OR (? IN ('I', 'D') AND episode_id = NVL (?, episode_id)) OR ? = 'R')"
			//Added V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 end
			+" and TRX_DOC_REF = ?"
			+" and TRX_DOC_REF_LINE_NUM = ?"
			+" and nvl(confirmed_yn,'N')='Y'"
			+" and nvl(billed_flag,'N') != 'Y'"
			+" and bill_doc_type_code is null"
			+" and ( nvl(package_ind,'X') = 'S' or (nvl(package_trx_ind,'X')='Y' and nvl(package_ind,'X') = 'P') )"
			+" and nvl(trx_finalize_ind,'N')= 'Y'" 
			+" and nvl(ins_pkg_pat_ind,'N') != 'K'"
			+" and bill_doc_type_code is null"
			+" and (nvl(trx_status,'N')<>'C'" 
			+" or ( nvl(trx_status,'N')='C' and ( ( REV_ADJ_TRX_IND in ('R', 'B','A') and (ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM,ORIG_DOC_REF_SEQ_NUM) in (select trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM from bl_patient_charges_folio where trx_status = 'C' and bill_doc_type_code is not null and operating_facility_id = ? and patient_id = ? AND ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID)) OR ( ? IN('I','D') and episode_id = NVL(?,EPISODE_ID)) OR ? = 'R'))) or ( (trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM) in ( select ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NUM from bl_patient_charges_folio where trx_status = 'C' and operating_facility_id = ? and patient_id = ? and ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID)) OR(? IN('I','D') and episode_id = NVL(?,EPISODE_ID)) or ? = 'R' ) and bill_doc_type_code is not null and ORIG_DOC_REF is not null ))))) order by  nvl(priority ,9999)";//NMC-JD-CRF-050

			pstmt = con.prepareStatement(strsql);
			pstmt.setString(1, locale);
			pstmt.setString(2, str_facility_id);
			pstmt.setString(3, str_episode_type);
			pstmt.setString(4, str_patient_id);
			pstmt.setString(5, str_episode_type);
			pstmt.setString(6, str_episode_id);
			pstmt.setString(7, str_visit_id);
			pstmt.setString(8, str_episode_type);
			pstmt.setString(9, str_episode_id);
			pstmt.setString(10, str_episode_type);
			pstmt.setString(11, trx_doc_ref);
			pstmt.setString(12, trx_doc_ref_line_no);
			pstmt.setString(13, str_facility_id);
			pstmt.setString(14, str_patient_id);
			pstmt.setString(15, str_episode_type);
			pstmt.setString(16, str_episode_id);
			pstmt.setString(17, str_visit_id);
			pstmt.setString(18, str_episode_type);
			pstmt.setString(19, str_episode_id);
			pstmt.setString(20, str_episode_type);
			pstmt.setString(21, str_facility_id);
			pstmt.setString(22, str_patient_id);
			pstmt.setString(23, str_episode_type);
			pstmt.setString(24, str_episode_id);
			pstmt.setString(25, str_visit_id);
			pstmt.setString(26, str_episode_type);
			pstmt.setString(27, str_episode_id);
			pstmt.setString(28, str_episode_type);
			
			rs1 = pstmt.executeQuery();	

			if( rs1 != null ) 
			{
				while( rs1.next() )
				{  
					blng_serv_code = rs1.getString(1);
					if(blng_serv_code == null) blng_serv_code="";

					blng_grp_id = rs1.getString(2);
					if(blng_grp_id == null) blng_grp_id="";

					policy_type_code = rs1.getString(3);	
					if(policy_type_code == null) policy_type_code="";

					cust_code = rs1.getString(4);
					if(cust_code == null) cust_code="";
					
					upd_gross_charge_amt = rs1.getString(5);
					if(upd_gross_charge_amt == null) upd_gross_charge_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_gross_charge_amt = cf1.formatCurrency(upd_gross_charge_amt, noofdecimal);
					} else {
						upd_gross_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_gross_charge_amt, noofdecimal);
					}

					upd_disc_amt = rs1.getString(6);
					if(upd_disc_amt == null) upd_disc_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_disc_amt = cf1.formatCurrency(upd_disc_amt, noofdecimal);
					} else {
						upd_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_disc_amt, noofdecimal);
					}
					double db_upd_disc_amt=Double.parseDouble(upd_disc_amt);

					upd_net_charge_amt = rs1.getString(7);
					if(upd_net_charge_amt == null) upd_net_charge_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_net_charge_amt = cf1.formatCurrency(upd_net_charge_amt, noofdecimal);
					} else {
						upd_net_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_net_charge_amt, noofdecimal);
					}

					trx_doc_ref_seq_no = rs1.getString(8);
					if(trx_doc_ref_seq_no == null) trx_doc_ref_seq_no="";
					
					act_gross_amt = rs1.getString(9);
					if(act_gross_amt == null) act_gross_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						act_gross_amt = cf1.formatCurrency(act_gross_amt, noofdecimal);
					} else {
						act_gross_amt = BLReportIdMapper.truncateUptoTwoDecimal(act_gross_amt, noofdecimal);
					}
					double db_act_gross_amt=Double.parseDouble(act_gross_amt);

					adhoc_disc_amt = rs1.getString(10);
					if(adhoc_disc_amt == null) adhoc_disc_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						adhoc_disc_amt = cf1.formatCurrency(adhoc_disc_amt, noofdecimal);
					} else {
						adhoc_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(adhoc_disc_amt, noofdecimal);
					}
					double db_adhoc_disc_amt=Double.parseDouble(adhoc_disc_amt);

					serv_item_code = rs1.getString(11);
					if(serv_item_code == null) serv_item_code="";

					serv_item_desc = rs1.getString(12);
					if(serv_item_desc == null) serv_item_desc="&nbsp;";

					org_gross_amt = rs1.getString(13);
					if(org_gross_amt == null) org_gross_amt="0";

					//NMC-JD-CRF-050
					org_disc_amt = rs1.getString(15);
					if(org_disc_amt == null) org_disc_amt="0";
					System.err.println("698, org_disc_amt==>"+org_disc_amt);
					//NMC-JD-CRF-050
					
					//NMC-JD-SCF-055
					settlementIndfolio =rs1.getString(16);
					if(settlementIndfolio == null) settlementIndfolio="";
					System.err.println("672, settlementIndfolio==>"+settlementIndfolio);
					//NMC-JD-SCF-055

					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						org_gross_amt = cf1.formatCurrency(org_gross_amt, noofdecimal);
					} else {
						org_gross_amt = BLReportIdMapper.truncateUptoTwoDecimal(org_gross_amt,noofdecimal);
					}
					double db_org_gross_amt=Double.parseDouble(org_gross_amt);
					
					trx_doc_ref_seq_num =  rs1.getString(14);
					str_color_band	= "WH";

			if(str_custmr_id.equals("ALMO") && cust_code.length()==0)
					{
						try
						{
						cstmt1.setString(1,str_facility_id);
						cstmt1.setString(2,trx_doc_ref);
						cstmt1.setString(3,trx_doc_ref_line_no);
						cstmt1.setString(4,trx_doc_ref_seq_num);
						cstmt1.registerOutParameter(5,java.sql.Types.VARCHAR);
						cstmt1.registerOutParameter(6,java.sql.Types.VARCHAR);
						cstmt1.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt1.execute();					
						
						str_trx_status=cstmt1.getString(5);
						if(str_trx_status==null)  str_trx_status ="";
						
						str_settlement_ind=cstmt1.getString(6);		
						if(str_settlement_ind==null)  str_settlement_ind ="";
						
						str_color_code=cstmt1.getString(7);
						if(str_color_code==null)  str_color_code ="";
						
					//	if(str_settlement_ind.equals("C") || str_settlement_ind.equals("R") || str_settlement_ind.equals("X"))
						str_color_band =  str_color_code;
					//	else
					//		str_color_band = "WH";
						}catch(Exception  ee1)  {
						ee1.printStackTrace();
						}
						if(cstmt1 != null ) cstmt1.close();						
					}

					try
					{
						String sql1= " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE=? and LANGUAGE_ID =? ";
						pstmt = con.prepareStatement(sql1);
						pstmt.setString(1, blng_serv_code);
						pstmt.setString(2, locale);
						rs = pstmt.executeQuery();	

						while(rs.next())
						{
						   serv_desc  =  rs.getString(1);	
						   if(serv_desc == null) serv_desc="";
						}	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("1="+e.toString());
					}
					finally{
						rs.close();
						pstmt.close();
					}

					try
					{
						String sql2= " select SHORT_DESC from BL_BLNG_GRP_LANG_VW where BLNG_GRP_ID=? and LANGUAGE_ID =? ";
						pstmt = con.prepareStatement(sql2);
						pstmt.setString(1, blng_grp_id);
						pstmt.setString(2, locale);
						rs = pstmt.executeQuery();	
		
						while(rs.next())
						{
						   blng_grp_desc  =  rs.getString(1);
						   if(blng_grp_desc == null) blng_grp_desc="";				   
						}	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("2="+e.toString());
					}
					finally{
						rs.close();
						pstmt.close();
					}
					
					try
					{
						String sql3= " select SHORT_NAME from AR_CUSTOMER_LANG_VW where CUST_CODE=? and LANGUAGE_ID =? ";
						pstmt = con.prepareStatement(sql3);
						pstmt.setString(1, cust_code);
						pstmt.setString(2, locale);
						rs = pstmt.executeQuery();	
		
						while(rs.next())
						{
						   cust_long_name  =  rs.getString(1);	
   						   if(cust_long_name == null) cust_long_name="";
						}	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("3="+e.toString());
					}
					finally{
						rs.close();
						pstmt.close();
					}

					try							
					{
						String sql4= " select SHORT_DESC from BL_INS_POLICY_TYPES_LANG_VW where POLICY_TYPE_CODE=? and LANGUAGE_ID =? ";
						pstmt = con.prepareStatement(sql4);
						pstmt.setString(1, policy_type_code);
						pstmt.setString(2, locale);
						rs = pstmt.executeQuery();	

						while(rs.next())
						{
						   policy_desc  =  rs.getString(1);	
   						   if(policy_desc == null) policy_desc="";
						}	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("4="+e.toString());
					}
					finally{
						rs.close();
						pstmt.close();
					}

					try							
					{
					//Modified the Query V171212-Gayathri/MMS-DM-CRF-0118
					String sql_addl_charge_for_payer="";
					
					if(("Y").equals(SiteSpecific_VAT)){
						 sql_addl_charge_for_payer=" Select DECODE (nvl(rule_coverage,'N'), 'E', nvl(rule_coverage,'N'), 'Y'), Sum(Nvl(Addl_Charge_Amt,0)) From  BL_PAT_CHRG_FOLIO_ADDL_CHARGE where TRX_DOC_REF = ? and TRX_DOC_REF_LINE_NUM = ? and Trx_Doc_Ref_Seq_Num = ? and operating_facility_id=? AND rule_code IS NOT NULL group by DECODE (nvl(rule_coverage,'N'), 'E', nvl(rule_coverage,'N'), 'Y')";
					}
					else{		
						
						sql_addl_charge_for_payer= " Select Sum(Nvl(Addl_Charge_Amt,0)) From  BL_PAT_CHRG_FOLIO_ADDL_CHARGE where TRX_DOC_REF = ? and TRX_DOC_REF_LINE_NUM = ? and Trx_Doc_Ref_Seq_Num = ? and operating_facility_id= ? ";
						
					}
						//stmt = con.createStatement();
						/* Fixed SQL Injection for Common-ICN-0222 */
			
					 	pstmt = con.prepareStatement(sql_addl_charge_for_payer);
			
					 		pstmt.setString(1, trx_doc_ref);
						 	pstmt.setString(2, trx_doc_ref_line_no);
						 	pstmt.setString(3, trx_doc_ref_seq_no);
						 	pstmt.setString(4, str_facility_id);
						
						rs = pstmt.executeQuery();	
						str_addl_charge_for_payer="0";
						while(rs.next())
						{							
					//27-Feb-20 GHL-ICN-0062(Invalid Column Index)
					if(("Y").equals(SiteSpecific_VAT)){
						str_addl_chg_value=rs.getString(1);
						str_addl_charge_for_payer  =  rs.getString(2);
					}else{
						str_addl_charge_for_payer  =  rs.getString(1);
					}
					//27-Feb-20 GHL-ICN-0062(Invalid Column Index)
							if(str_addl_charge_for_payer == null && ("").equals(str_addl_charge_for_payer)) str_addl_charge_for_payer="0";
						}	
						
						//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
						if(amountRoundOff) {
							str_addl_charge_for_payer = cf1.formatCurrency(str_addl_charge_for_payer, noofdecimal);
						} else {
							str_addl_charge_for_payer = BLReportIdMapper.truncateUptoTwoDecimal(str_addl_charge_for_payer,noofdecimal);
						}
						addl_charge_for_payer = Double.parseDouble(str_addl_charge_for_payer);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("sql_addl_charge_for_payer:"+e.toString());
					} 
					finally{
						rs.close();
						pstmt.close();
					}
			
					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}

				/* Added By Vijay A.P. For PMG CRF 0002 */
					try{
						//if("".equals(cust_code))
						if(cust_code.equals(""))
						{
							pstmt=con.prepareStatement("select blcommon.chk_disc_allow_for_cash_copay(?,?,?,?,?,?,?,?,?,?,?,?,?) discountYesNo from dual");
							pstmt.setString(1, str_facility_id);
							pstmt.setString(2, str_episode_id);
							pstmt.setString(3, str_episode_type);
							pstmt.setString(4, str_visit_id);
							pstmt.setString(5, str_patient_id);
							pstmt.setString(6, cust_code);
							pstmt.setString(7, "S");
							pstmt.setString(8, null);
							pstmt.setString(9, null);
							pstmt.setString(10,blng_serv_code);
							pstmt.setString(11, trx_doc_ref);
							pstmt.setString(12, trx_doc_ref_line_no);
							pstmt.setString(13, trx_doc_ref_seq_num);
							rs = pstmt.executeQuery();	
							
							if(rs!=null)
							{
								while(rs.next())
								{
									discountYesNo=rs.getString("discountYesNo");								
								}
							}						
						}
					}catch(Exception e){
						System.out.println("Exception in blng_serv_code"+e);
						e.printStackTrace();						
					}
					finally{
						rs.close();
						pstmt.close();
					}

            _bw.write(_wl_block26Bytes, _wl_block26);
	
			if(str_color_band.equals("WH")) str_color_band = classval;
		if(str_custmr_id.equals("ALMO") || site3TierAlmoFeature == true) 	//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeature & AAKH-SCF-0404.1
		{  
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_color_band));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else { 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
} 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(serv_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(blng_serv_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(serv_item_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(serv_item_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((cust_long_name==null || cust_long_name.equals(""))?"&nbsp;":cust_long_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((policy_desc==null || policy_desc.equals(""))?"&nbsp;":policy_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(policy_type_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(upd_gross_charge_amt));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);

/*Code added by Karthik to disable link when max discount percentage or max discount amount is null - Starts*/
	String currdate="";
	String max_disc_per="";
	String max_disc_amt="";
	String str_serv_max_disc_per="";
	String str_serv_max_disc_amt = "";
	String str_payer_max_disc_per="";
	String str_payer_max_disc_amt="";
	String settlement_ind="";	
	
		try
		{		
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			pstmt=con.prepareStatement(query_date);
			rs = pstmt.executeQuery();
			if (rs!=null)
			{
				if (rs.next())
				{
					currdate = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error in date" +e);
		}
		try	{
				CallableStatement  call = 
				con.prepareCall("{ ? = call  blcore.Check_Service_discount(?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?)}");	
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.setString(2,str_facility_id);
				call.setString(3,blng_serv_code);
				call.setString(4,strloggeduser);
				call.setString(5,currdate);
				if(str_module_id.equals("PH") || str_module_id.equals("ST") || str_module_id.equals("PS") || str_module_id.equals("MM"))
				{
					call.setString(6,serv_item_code);
				}
				else
				{
					call.setString(6,"");
				}
				call.registerOutParameter(7,java.sql.Types.VARCHAR);
				call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.registerOutParameter(9,java.sql.Types.VARCHAR);
				call.registerOutParameter(10,java.sql.Types.VARCHAR);
				call.execute();				
				
				str_serv_max_disc_per = call.getString(7);		
				if(str_serv_max_disc_per==null) str_serv_max_disc_per="";

				str_serv_max_disc_amt = call.getString(8);		
				if(str_serv_max_disc_amt==null) str_serv_max_disc_amt="";					

				str_payer_max_disc_per = call.getString(9);		
				if(str_payer_max_disc_per==null) str_payer_max_disc_per="";

				str_payer_max_disc_amt = call.getString(10);		
				if(str_payer_max_disc_amt==null) str_payer_max_disc_amt="";

				if(call!=null)
				call.close();	
			}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error in date" +e);
		}
		
		try
		{		
			String query_slmt_ind="select SETTLEMENT_IND from bl_blng_grp where blng_grp_id=?";
			pstmt=con.prepareStatement(query_slmt_ind);
			pstmt.setString(1, blng_grp_id);
			rs = pstmt.executeQuery();
			if (rs!=null)
			{
				if (rs.next())
				{
					settlement_ind = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.println("error in date" +e);
		}
		
		settlement_ind = settlementIndfolio;//NMC-JD-SCF-055

		/*System.out.println("$$$$$ in str_payer_max_disc_per:"+str_payer_max_disc_per);
		System.out.println("$$$$$ in str_payer_max_disc_amt:"+str_payer_max_disc_amt);
		System.out.println("$$$$$ in str_serv_max_disc_per:"+str_serv_max_disc_per);
		System.out.println("$$$$$ in str_serv_max_disc_amt:"+str_serv_max_disc_amt);
		System.out.println("$$$$$ in blng_grp_id:"+blng_grp_id);			
		System.out.println("$$$$$ in settlement_ind:"+settlement_ind);*/
		
		if(cust_code.equals("")){
			max_disc_per=str_serv_max_disc_per;
			max_disc_amt=str_serv_max_disc_amt;					
		}else{				
			max_disc_per=str_payer_max_disc_per;
			max_disc_amt=str_payer_max_disc_amt;
		}		
		
/*Code added by Karthik to disable link when max discount percentage or max discount amount is null - Ends*/

		if(db_adhoc_disc_amt == db_upd_disc_amt && db_act_gross_amt!=0 && db_org_gross_amt != 0 && (!max_disc_per.equals("") || !max_disc_amt.equals("")))
		{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(upd_disc_amt));
            _bw.write(_wl_block58Bytes, _wl_block58);

		}//Added V200323-MuthuN/NMC-JD-CRF-050
		else if(db_act_gross_amt!=0 && db_org_gross_amt != 0 && (!max_disc_per.equals("") || !max_disc_amt.equals("")) && (settlement_ind.equalsIgnoreCase("C")) && preConfigDiscAmt.equals("Y"))
		{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(upd_disc_amt));
            _bw.write(_wl_block58Bytes, _wl_block58);

		}//Added V200323-MuthuN/NMC-JD-CRF-050
		else
		{

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(upd_disc_amt));
            _bw.write(_wl_block61Bytes, _wl_block61);

		}

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(upd_net_charge_amt));
            _bw.write(_wl_block64Bytes, _wl_block64);

			if((db_adhoc_disc_amt == db_upd_disc_amt) && db_act_gross_amt!=0 && db_org_gross_amt != 0)
			{

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);

			}
			else
			{

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);

			}
		//Added V171212-Gayathri/MMS-DM-CRF-0118
if("Y".equals(SiteSpecific_VAT)){
	
	if(!("".equals(str_addl_chg_value)))
	{

            _bw.write(_wl_block71Bytes, _wl_block71);
if(siteSpecNMC){
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_VAT_CHARGE_DTL.label","bl_labels")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_addl_charge_for_payer));
            _bw.write(_wl_block76Bytes, _wl_block76);
} else {
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_ADDL_CHARGE_DTL.label","bl_labels")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_addl_charge_for_payer));
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block71Bytes, _wl_block71);

	}
	else
	{

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_ADDL_CHARGE_DTL.label","bl_labels")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_addl_charge_for_payer));
            _bw.write(_wl_block64Bytes, _wl_block64);

	}
}
else{
		if(addl_charge_for_payer != 0)
		{

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_ADDL_CHARGE_DTL.label","bl_labels")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_addl_charge_for_payer));
            _bw.write(_wl_block76Bytes, _wl_block76);

			}
			else
			{

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_ADDL_CHARGE_DTL.label","bl_labels")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_addl_charge_for_payer));
            _bw.write(_wl_block64Bytes, _wl_block64);

			}
}

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(act_gross_amt));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(trx_doc_ref));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(trx_doc_ref_line_no));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(trx_doc_ref_seq_no));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(adhoc_disc_amt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(discountYesNo));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(org_disc_amt));
            _bw.write(_wl_block100Bytes, _wl_block100);
			
					cust_long_name="";
					policy_desc="";
					i++;
				}//while		
			}//rs 
			
			/* Fixed SQL Injection for Common-ICN-0222 */
			if (rs1 != null)   rs1.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in main qry :"+e);
		}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(str_module_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(existing_reason_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(trx_doc_ref));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(trx_doc_ref_line_no));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(str_patient_id));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(str_episode_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(str_visit_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(selected_serv_rec));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(preConfigDiscAmt));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block114Bytes, _wl_block114);

	}catch(Exception ee)
	{
		ee.printStackTrace();
		System.err.println("Error in main Adhoc disc " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISCOUNT_AMT.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NetAmount.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISC_APPL.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Vat_Charges.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADDL_CHARGE.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
