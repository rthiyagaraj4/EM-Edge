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
import java.util.*;
import com.ehis.util.*;

public final class __blbillreimburseamtbillservdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillReimburseAmtBillServDetails.jsp", 1744003602862L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<style>\n\t\tthead td, thead td.locked\t{\n\t\tbackground-color: navy;\n\t\tcolor: white;\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-5); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\t</style>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eBL/js/BLBillReimburseAmtDetails.js\'></script>\n\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n</head>\n<script>\nvar flag_YN = \"N\";//Modified by Muthukumar against crf-668 on 14-11-11\nvar retVal=new Array();//Modified by Muthukumar against crf-668 on 14-11-11\nfunction reimburse_check()\n{\n\tvar total_records = document.forms[0].total_records.value;\n\n\tfor(var i=0;i<total_records;i++)\n\t{\n\t\tvar stup_reimb_type_hid = eval(\"document.forms[0].stup_reimb_type_hid_\"+i);\n\t\tstup_reimb_type_hid = stup_reimb_type_hid.value;\n\t\t\n\t\tvar stup_reimb_type_id = \"stup_reimb_type_\"+i;\n\n\t\tvar stup_reimb_type = eval(parent.frames[1].document.getElementById(stup_reimb_type_id));\n\n\t\tif(stup_reimb_type_hid == \"F\")\n\t\t{\n\t\t\tstup_reimb_type.innerText = getLabel(\"eBL.FULL.label\",\"BL\");\n\t\t}\n\t\telse if(stup_reimb_type_hid == \"P\")\n\t\t{\n\t\t\tstup_reimb_type.innerText = getLabel(\"eBL.PART.label\",\"BL\");\n\t\t}\n\t\telse if(stup_reimb_type_hid == \"N\")\n\t\t{\n\t\t\tstup_reimb_type.innerText = getLabel(\"eBL.NA.label\",\"BL\");\n\t\t}\n\t\telse\n\t\t{\n\t\t\tstup_reimb_type.innerText = \"\";\n\t\t}\n\t}\n}\n\nfunction load_audit_dtls(sel_rec)\n{\n\tvar tot_rec = document.forms[0].total_records.value;\n\tvar rec_to_load;\n\n\tfor(var i=0;i<tot_rec;i++)\n\t{\n\t\tif(i==sel_rec)\n\t\t{\n\t\t\tvar trx_doc_ref = eval(\"document.forms[0].trx_doc_ref_\"+i);\n\t\t\ttrx_doc_ref = trx_doc_ref.value;\n\n\t\t\tvar trx_doc_ref_line_num = eval(\"document.forms[0].trx_doc_ref_line_num_\"+i);\n\t\t\ttrx_doc_ref_line_num = trx_doc_ref_line_num.value;\n\n\t\t\tvar trx_doc_ref_seq_num = eval(\"document.forms[0].trx_doc_ref_seq_num_\"+i);\n\t\t\ttrx_doc_ref_seq_num = trx_doc_ref_seq_num.value;\n\t\n\t\t\tparent.frames[2].location.href = \"../../eBL/jsp/BLBillReimburseAmtBillServAuditDetails.jsp?trx_doc_ref=\"+trx_doc_ref+\"&trx_doc_ref_line_num=\"+trx_doc_ref_line_num+\"&trx_doc_ref_seq_num=\"+trx_doc_ref_seq_num;\n//\t\t\tbreak;\n\t\t}\n\t}\n}\n\nfunction check_for_override(sel_rec)\n{\n\tvar tot_rec = document.forms[0].total_records.value;\n\tvar locale = document.forms[0].locale.value;\n\tvar override_reimbursable_yn = eval(\"document.forms[0].override_reimbursable_yn_\"+sel_rec);\n\t//var retVal=new Array(); //commented by Muthukumar against crf-668 on 14-11-11\n\toverride_reimbursable_yn = override_reimbursable_yn.value;\n\n\tvar serv_date = document.getElementById(\'serv_date_\'+sel_rec);\n\tserv_date = serv_date.innerText;\n\n\tserv_date = convertDate(serv_date,\'DMYHMS\',locale,\"en\");\n\n\tvar serv_module_id= eval(\"document.forms[0].serv_module_id_\"+sel_rec);\n\tserv_module_id = serv_module_id.value;\n\n\tvar blng_serv_code = eval(\"document.forms[0].blng_serv_code_\"+sel_rec);\n\tblng_serv_code = blng_serv_code.value;\n\n\tvar serv_item_code = eval(\"document.forms[0].serv_item_code_\"+sel_rec);\n\tserv_item_code = serv_item_code.value;\n\n\tvar override_YN = eval(\"document.forms[0].override_YN_\"+sel_rec);\n\n\tif(override_YN.checked)\n\t{\n\t\tif(override_reimbursable_yn == \"N\")\n\t\t{\n\t\t\talert(getMessage(\"BL6326\",\"BL\"));//Needs to be added in JAVA resource bundle\n\t\t\toverride_YN.checked=false;\n\t\t\treturn false;\n\t\t}\n//commented by Muthukumar against crf-668 on 14-11-11\n\t\t/*else\n\t\t{\n\t\t\tauthScr(sel_rec,serv_date,blng_serv_code,serv_item_code,serv_module_id);\n\t\t}*/\n//commented by Muthukumar against crf-668 on 14-11-11\n// Added by Muthukumar against crf-668 on 14-11-11 Starts Here\n\t\telse if (flag_YN == \"N\" && override_reimbursable_yn == \"Y\"){\n                   authScr(sel_rec,serv_date,blng_serv_code,serv_item_code,serv_module_id);\t\t\t\n\t\t\t\t   }\t\t\n\n\t\telse if (flag_YN == \"Y\" && override_reimbursable_yn == \"Y\"){\t\t\n\t\t\tvar reimb_override_allow_YN = eval(\"document.forms[0].reimb_override_allow_YN_\"+sel_rec);\n\t\t\treimb_override_allow_YN.value = retVal[0];\n\n\t\t\tvar max_part_serv_reim_per = eval(\"document.forms[0].max_part_serv_reim_per_\"+sel_rec);\n\t\t\tmax_part_serv_reim_per.value = retVal[1];\n\n\t\t\tvar max_part_serv_reim_amt = eval(\"document.forms[0].max_part_serv_reim_amt_\"+sel_rec);\n\t\t\tmax_part_serv_reim_amt.value = retVal[2];\n\t\t\n\t\t\tvar override_control = eval(\"document.forms[0].override_control_\"+sel_rec);\t\t\t\n\t\t\toverride_control.value = retVal[3];\n\n\t\t\tvar reimb_reason_code = eval(\"document.forms[0].reimb_reason_code_\"+sel_rec);\n\t\t\treimb_reason_code.value = retVal[4];\n\t\t\t\n\t\t\tdocument.forms[0].existing_reason_code.value = reimb_reason_code.value;\t\n\n\t\t\tvar curr_reimb_YN = eval(\"document.forms[0].curr_reimb_YN_\"+sel_rec);\n\t\t\tcurr_reimb_YN.disabled = false;\n\t\t\t\n\t\t\tif(override_control.value != \'F\')\t\n\t\t\t\tcurr_reimb_items_check(sel_rec);\t\t\n\t\t}\t\n// Added by Muthukumar against crf-668 on 14-11-11 Ends Here\n\t}\n\telse\n\t{\n\t\tvar override_reimbursable_yn = eval(\"document.forms[0].curr_reimb_YN_\"+sel_rec);\n\t\tvar curr_reimb_type = eval(\"document.forms[0].curr_reimb_type_\"+sel_rec);\n\t\tvar curr_rev_amt = eval(\"document.forms[0].curr_rev_amt_\"+sel_rec);\n\t\t\t\n\t\toverride_reimbursable_yn.checked = false;\n\t\toverride_reimbursable_yn.disabled = true;\n\t\n\t\tcurr_reimb_type.value = \"\";\n\t\tcurr_reimb_type.disabled = true;\n\n\t\tcurr_rev_amt.value = \"\";\n\t\tcurr_rev_amt.disabled = true;\n\t}\n}\n\nasync function authScr(sel_rec,serv_date,blng_serv_code,serv_item_code,serv_module_id)\n{\t\n\tvar existing_reason_code = document.forms[0].existing_reason_code.value;\n\t//var retVal=new Array();//commented by Muthukumar against crf-668 on 14-11-11\n\tvar dialogHeight= \"16vh\" ;\n\tvar dialogWidth\t= \"25vw\" ;\n\tvar dialogTop = \"225\" ;\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\t\n\tvar url = \"../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?called_frm=BILL_REIMB_AMT&blng_serv_date=\"+serv_date+\"&blng_serv_code=\"+blng_serv_code+\"&serv_item_code=\"+serv_item_code+\"&serv_module_id=\"+serv_module_id+\"&existing_reason_code=\"+existing_reason_code;\n\tretVal =await window.showModalDialog(url,arguments,features);\n\tif(retVal==null) retVal=\"\";\n\tif(retVal.length>0)\n\t{\t\n\t\tif(retVal[0] == \"Y\")\n\t\t{\n\t\t\tflag_YN = \"Y\";//Modified by Muthukumar against crf-668 on 14-11-11\n\t\t\tvar reimb_override_allow_YN = eval(\"document.forms[0].reimb_override_allow_YN_\"+sel_rec);\n\t\t\treimb_override_allow_YN.value = retVal[0];\n\n\t\t\tvar max_part_serv_reim_per = eval(\"document.forms[0].max_part_serv_reim_per_\"+sel_rec);\n\t\t\tmax_part_serv_reim_per.value = retVal[1];\n\n\t\t\tvar max_part_serv_reim_amt = eval(\"document.forms[0].max_part_serv_reim_amt_\"+sel_rec);\n\t\t\tmax_part_serv_reim_amt.value = retVal[2];\n\n\t\t\tvar override_control = eval(\"document.forms[0].override_control_\"+sel_rec);\n\t\t\toverride_control.value = retVal[3];\n\n\t\t\tvar reimb_reason_code = eval(\"document.forms[0].reimb_reason_code_\"+sel_rec);\n\t\t\treimb_reason_code.value = retVal[4];\n\n\t\t\tdocument.forms[0].existing_reason_code.value = reimb_reason_code.value;\t\t\t\n\n\t\t\tvar curr_reimb_YN = eval(\"document.forms[0].curr_reimb_YN_\"+sel_rec);\n\t\t\tcurr_reimb_YN.disabled = false; \n\t\t\t\n\t\t\t\n\t\t\tif(override_control.value != \'F\')\t\n\t\t\t\tcurr_reimb_items_check(sel_rec);\n\t\t}\n/*\n\t\telse if(retVal[0] == \"N\")\n\t\t{\n\t\t\talert(getMessage(\"BL6327\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n*/\n\t}\n\telse\n\t{\n\t\tvar override_YN = eval(\"document.forms[0].override_YN_\"+sel_rec);\n\t\toverride_YN.checked = false;\n\t\tvar curr_reimb_YN = eval(\"document.forms[0].curr_reimb_YN_\"+sel_rec);\n\t\tcurr_reimb_YN.checked = false;\n\t\tvar curr_reimb_type = eval(\"document.forms[0].curr_reimb_type_\"+sel_rec);\n\t\tcurr_reimb_type.value = \"\";\n\t\tvar curr_rev_amt = eval(\"document.forms[0].curr_rev_amt_\"+sel_rec);\n\t\tcurr_rev_amt.value = \"\";\n\t}\n}\n\nfunction curr_reimb_items_check(sel_rec)\n{\n\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\tvar override_control1 = eval(\"document.forms[0].override_control_\"+sel_rec);\n\t//override_control = override_control.value; //commented by Muthukumar against crf-668 on 14-11-11\n\toverride_control = override_control1.value;\n\n\tvar net_chrg_amt = document.getElementById(\'net_chrg_amt_\'+sel_rec);\n\tnet_chrg_amt = net_chrg_amt.innerText;\n\n\tvar stup_reimb_YN = eval(\"document.forms[0].stup_reimb_YN_\"+sel_rec);\n\n\tvar stup_reimb_type = eval(\"document.forms[0].stup_reimb_type_hid_\"+sel_rec);\n\tstup_reimb_type = stup_reimb_type.value;\n\n\tvar stup_reimb_amt = document.getElementById(\'stup_reimb_amt_\'+sel_rec);\n\tstup_reimb_amt = stup_reimb_amt.innerText;\n\n\tvar curr_reimb_YN = eval(\"document.forms[0].curr_reimb_YN_\"+sel_rec);\n\tvar curr_reimb_type = eval(\"document.forms[0].curr_reimb_type_\"+sel_rec);\n\tvar curr_rev_amt = eval(\"document.forms[0].curr_rev_amt_\"+sel_rec);\n\n\tif(override_control == \"F\")\n\t{\n\t\tif(curr_reimb_YN.checked)\n\t\t{\n\t\t\tif(stup_reimb_type == \"F\")\n\t\t\t{\n\t\t\t\tcurr_reimb_type.value = \'P\';\n\t\t\t\tcurr_rev_amt.value = 0;\n\t\t\t\tcurr_rev_amt.disabled = false;\n\t\t\t\tcurr_reimb_type.DISABLED;\n\t\t\t}\n\t\t\telse if(stup_reimb_type == \"P\")\n\t\t\t{\n\t\t\t\tcurr_reimb_type.value = \'F\';\n\t\t\t\tcurr_rev_amt.value = net_chrg_amt;\n\t\t\t\tcurr_reimb_type.disabled = false;\n\t\t\t\tcurr_rev_amt.DISABLED;\n\t\t\t}\n\t\t\telse if(stup_reimb_type == \"N\")\n\t\t\t{\n\t\t\t\tcurr_reimb_type.value = \'F\';\n\t\t\t\tcurr_rev_amt.value = net_chrg_amt;\n\t\t\t\tcurr_reimb_type.disabled = false;\n\t\t\t\tcurr_rev_amt.disabled = true;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcurr_reimb_type.value = \"N\";\n\n\t\t\tif(stup_reimb_YN.checked || stup_reimb_type == \"N\")\n\t\t\t{\n\t\t\t\tcurr_rev_amt.value = 0;\n\t\t\t\tcurr_rev_amt.disabled = true;\n\t\t\t}\n\t\t}\n\t}\n\telse if(override_control == \"R\")\n\t{\n\t\tif(stup_reimb_YN.checked)\n\t  \t{\n\t\t\tcurr_reimb_YN.checked = false;\n\t\t\tcurr_reimb_type.value = \"N\";\n  \t\t    curr_rev_amt.value = 0;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcurr_reimb_YN.checked = true;\n\t\t\tif(stup_reimb_type == \"F\")\n\t\t\t\tcurr_reimb_type.value = \"P\";\n\t\t\telse if(stup_reimb_type == \"P\")\n\t\t\t\tcurr_reimb_type.value = \"F\";\n\t\t\telse if(stup_reimb_type == \"N\")\n\t\t\t{\n\t\t\t\tcurr_reimb_type.value = \"F\";\n\t\t\t\tcurr_rev_amt.value = net_chrg_amt;\n\t\t\t}\n\t\t}\n\t}\n\tif(curr_rev_amt.value != \"\")\n\t{\n\t\tput_decimal(curr_rev_amt,noofdecimal);\n\t}\n}\n\nfunction curr_reimb_type_chg(sel_rec)\n{\n\n\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\n\tvar override_control = eval(\"document.forms[0].override_control_\"+sel_rec);\n\toverride_control = override_control.v";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="alue;\n\n\tvar net_chrg_amt = document.getElementById(\'net_chrg_amt_\'+sel_rec);\n\tnet_chrg_amt = net_chrg_amt.innerText;\n\n\tvar stup_reimb_YN = eval(\"document.forms[0].stup_reimb_YN_\"+sel_rec);\n\n\tvar stup_reimb_type = eval(\"document.forms[0].stup_reimb_type_hid_\"+sel_rec);\n\tstup_reimb_type = stup_reimb_type.value;\n\n\tvar stup_reimb_amt =document.getElementById(\'stup_reimb_amt_\'+sel_rec);\n\tstup_reimb_amt = stup_reimb_amt.innerText;\n\n\tvar curr_reimb_YN = eval(\"document.forms[0].curr_reimb_YN_\"+sel_rec);\n\tvar curr_reimb_type = eval(\"document.forms[0].curr_reimb_type_\"+sel_rec);\n\tvar curr_rev_amt = eval(\"document.forms[0].curr_rev_amt_\"+sel_rec);\n\n\tif(override_control == \"F\")\n\t{\n\t\tif(curr_reimb_YN.checked)\n\t\t{\n//\t\tif(stup_reimb_type == \"N\")\n//\t\t\t{\n\t\t\t\tif(curr_reimb_type.value == \"F\")\n\t\t\t\t{\n\t\t\t\t\tcurr_rev_amt.value = net_chrg_amt;\n\t\t\t\t\tcurr_reimb_type.disabled = false;\n\t\t\t\t\tcurr_rev_amt.disabled = true;\n\t\t\t\t}\n\t\t\t\telse if(curr_reimb_type.value == \"P\")\n\t\t\t\t{\n\t\t\t\t\tcurr_rev_amt.value = 0;\n\t\t\t\t\tcurr_reimb_type.disabled = false;\n\t\t\t\t\tcurr_rev_amt.disabled = false;\n\t\t\t\t}\n\t\t\t\telse if(curr_reimb_type.value == \"N\")\n\t\t\t\t{\n\t\t\t\t\tcurr_reimb_type.value = \"F\";\n\t\t\t\t\tcurr_rev_amt.value = net_chrg_amt;\n\t\t\t\t\tcurr_reimb_type.disabled = false;\n\t\t\t\t\tcurr_rev_amt.disabled = true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tcurr_reimb_type.value = \"F\";\n\t\t\t\t\tcurr_rev_amt.value = net_chrg_amt;\n\t\t\t\t\tcurr_reimb_type.disabled = false;\n\t\t\t\t\tcurr_rev_amt.disabled = true;\n\t\t\t\t}\n//\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcurr_reimb_type.value = \"N\";\n\n\t\t\tif(stup_reimb_YN.checked || stup_reimb_type == \"N\")\n\t\t\t{\n\t\t\t\tcurr_rev_amt.value = 0;\n\t\t\t\tcurr_rev_amt.disabled = true;\n\t\t\t}\n\t\t}\n\t}\n\telse if(override_control == \"R\")\n\t{\n\t\tif(stup_reimb_YN.checked)\n\t  \t{\n\t\t\tcurr_reimb_YN.checked = false;\n\t\t\tcurr_reimb_type.value = \"N\";\n  \t\t    curr_rev_amt.value = 0;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcurr_reimb_YN.checked = true;\n\t\t\tif(stup_reimb_type == \"F\")\n\t\t\t\tcurr_reimb_type.value = \"P\";\n\t\t\telse if(stup_reimb_type == \"P\")\n\t\t\t\tcurr_reimb_type.value = \"F\";\n\t\t\telse if(stup_reimb_type == \"N\")\n\t\t\t{\n\t\t\t\tcurr_reimb_type.value = \"F\";\n\t\t\t\tcurr_rev_amt.value = net_chrg_amt;\n\t\t\t}\n\t\t}\n\t}\n\n\tif(curr_rev_amt.value != \"\")\n\t{\n\t\tput_decimal(curr_rev_amt,noofdecimal);\n\t}\n}\n\nfunction chk_for_allwd_amt(sel_rec)\n{\n\tvar curr_rev_amt = eval(\"document.forms[0].curr_rev_amt_\"+sel_rec);\n\n\tif(CheckForChar(curr_rev_amt))\n\t{\n\t\tvar allowed_amt = get_allowed_amt(sel_rec);\n\t\tvar\tperc_amt_label = get_perc_amt_messg(sel_rec);\n\t\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\n\t\tput_decimal(curr_rev_amt,noofdecimal);\n\n\t\tvar curr_reimb_type = eval(\"document.forms[0].curr_reimb_type_\"+sel_rec);\n\t\tcurr_reimb_type = curr_reimb_type.value;\n\n\t\tvar net_chrg_amt = document.getElementById(\'net_chrg_amt_\'+sel_rec);\n\t\tnet_chrg_amt = net_chrg_amt.innerText;\n\n\t\tif(curr_reimb_type == \'P\')\n\t\t{\n\t\t\tif(eval(curr_rev_amt.value) > eval(allowed_amt))\n\t\t\t{\n\t\t\t\tvar mess_disp = getMessage(\"BL6328\",\"BL\");\n\t\t\t\tmess_disp = mess_disp.replace(\"%1\",perc_amt_label);\n\t\t\t\t\t\n\t\t\t\talert(mess_disp);\n\t\t\t\tcurr_rev_amt.value = \"\";\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif(eval(net_chrg_amt) < eval(curr_rev_amt.value)) \n\t\t\t{\n\t\t\t\tvar mess_disp = getMessage(\"BL6328\",\"BL\");\n\t\t\t\tmess_disp = mess_disp.replace(\"%1\",net_chrg_amt);\n\t\t\t\talert(mess_disp);\n\t\t\t\tcurr_rev_amt.value = \"\";\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\n\t\t\tif (eval(curr_rev_amt.value) <= 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL1188\",\"BL\"));\n\t\t\t\tcurr_rev_amt.value = \"\";\n\t\t\t\treturn false;\n\t\t\t}\t\n\t\t\tput_decimal(curr_rev_amt,noofdecimal);\n\t\t}\n\t}\n}\n\nfunction get_allowed_amt(sel_rec)\n{\n\tvar reimb_override_allow_YN = eval(\"document.forms[0].reimb_override_allow_YN_\"+sel_rec);\n\treimb_override_allow_YN = reimb_override_allow_YN.value;\n\n\tvar max_part_serv_reim_per = eval(\"document.forms[0].max_part_serv_reim_per_\"+sel_rec);\n\tmax_part_serv_reim_per = max_part_serv_reim_per.value;\n\n\tvar max_part_serv_reim_amt = eval(\"document.forms[0].max_part_serv_reim_amt_\"+sel_rec);\n\tmax_part_serv_reim_amt = max_part_serv_reim_amt.value;\n\n\tvar override_control = eval(\"document.forms[0].override_control_\"+sel_rec);\n\toverride_control = override_control.value;\n\n\tvar allowd_amt = document.getElementById(\'net_chrg_amt_\'+sel_rec);\n\tallowd_amt = allowd_amt.innerText;\n\n\tif(max_part_serv_reim_per != \"\" && max_part_serv_reim_amt != \"\")\n\t{\n\t\tallowd_amt = eval(allowd_amt) * max_part_serv_reim_per/100;\n\n\t\tif(allowd_amt<max_part_serv_reim_amt)\n\t \t  return allowd_amt;\n\t\telse\n\t \t  return max_part_serv_reim_amt;\n\t}\n\telse if(max_part_serv_reim_per == \"\" && max_part_serv_reim_amt != \"\")\n\t{\n\t\tif(allowd_amt < max_part_serv_reim_amt)\n \t\t\treturn allowd_amt;\n\t\telse\n \t\t\treturn max_part_serv_reim_amt;\n\t}\n\telse if(max_part_serv_reim_per != \"\" && max_part_serv_reim_amt == \"\")\n\t{\n\t   \tallowd_amt = allowd_amt * max_part_serv_reim_per/100;\n   \t\treturn allowd_amt;\n\t}\n\telse\n\t{\n\t\treturn allowd_amt;\n\t}\n}\n\nfunction get_perc_amt_messg(sel_rec)\n{\n\tvar reimb_override_allow_YN = eval(\"document.forms[0].reimb_override_allow_YN_\"+sel_rec);\n\treimb_override_allow_YN = reimb_override_allow_YN.value;\n\n\tvar max_part_serv_reim_per = eval(\"document.forms[0].max_part_serv_reim_per_\"+sel_rec);\n\tmax_part_serv_reim_per = max_part_serv_reim_per.value;\n\n\tvar max_part_serv_reim_amt = eval(\"document.forms[0].max_part_serv_reim_amt_\"+sel_rec);\n\tmax_part_serv_reim_amt = max_part_serv_reim_amt.value;\n\n\tvar override_control = eval(\"document.forms[0].override_control_\"+sel_rec);\n\toverride_control = override_control.value;\n\n\tvar allowd_amt = document.getElementById(\'net_chrg_amt_\'+sel_rec);\n\tallowd_amt = allowd_amt.innerText;\n\n\tvar perc_label = getLabel(\"Common.Percent.label\",\"common\");\n\n\tif(max_part_serv_reim_per != \"\" && max_part_serv_reim_amt != \"\")\n\t{\n\t\tallowd_amt = eval(allowd_amt) * max_part_serv_reim_per/100;\n\n\t\tif(allowd_amt<max_part_serv_reim_amt)\n\t\t\treturn (max_part_serv_reim_per+\" \"+perc_label);\n\t\telse\n\t\t\treturn max_part_serv_reim_amt;\n\t}\n\telse if(max_part_serv_reim_per == \"\" && max_part_serv_reim_amt != \"\")\n\t{\n\t\tif(allowd_amt < max_part_serv_reim_amt)\n \t\t\treturn allowd_amt;\n\t\telse\n \t\t\treturn max_part_serv_reim_amt;\n\t}\n\telse if(max_part_serv_reim_per != \"\" && max_part_serv_reim_amt == \"\")\n\t{\n\t   \tallowd_amt = allowd_amt * max_part_serv_reim_per/100;\n   \t\treturn (max_part_serv_reim_per+\" \"+perc_label);\n\t}\n\telse\n\t{\n\t\treturn allowd_amt;\n\t}\n}\n\nfunction CheckForChar(Obj)\n{\n\tvar check_var = Obj.value;\n\n\tnumList = \'1234567890.\';\n\t\n\tfor (i=0;i<check_var.length;i++)\n\t{\n\t\tif (numList.indexOf(check_var.charAt(i)) == -1) \n\t\t{\n\t\t\talert(getMessage(\"INVALID_NUMBER_FORMAT\",\"Common\"));\n\t\t\tObj.select();\n\t\t\treturn false;  \n\t\t}\n\t}\n\treturn true;\n}\n\nfunction disable_but()\n{\n\tparent.parent.frames[0].document.forms[0].home.disabled = true;\n}\n</script>\n\n<BODY onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" onLoad=\"disable_but();reimburse_check();load_audit_dtls(\'0\');\">\n<FORM name=\'BLBillReimbAmtBillServDtlsForm\' id=\'BLBillReimbAmtBillServDtlsForm\' method=\'post\' onLoad=\"\" action=\"\" method=\"\" target=\"\">\t\n\t<div id=\"tbl-container\" STYLE=\"overflow: auto; width: 100%; height: 340px;   padding:3px; margin: 0px\">\n\t\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\n\t<thead>\n\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\' colspan=\'11\' align=\'left\'>";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t</tr>\n\t\t<tr><td></td></tr>\n\t\t<tr>\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t</tr>\n\t</thead>\n\t<tbody>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<tr>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" width=\'20%\'><a href=\"javascript:load_audit_dtls(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\" title=\"Click for Audit Details\"><div id=\'blng_serv_desc_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</div></a></td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" width=\'20%\'><div id=\'item_desc_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div></td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" width=\'20%\'><div id=\'serv_date_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" width=\'20%\'><div id=\'net_chrg_amt_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' style=\'text-align:right\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" width=\'20%\'><div align=\'center\'><input type=\"checkbox\" name=\"stup_reimb_YN_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"stup_reimb_YN_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" DISABLED></input></div></td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" width=\'20%\'><div id=\"stup_reimb_type_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" align=\'center\'></div>\n<!--\t\t\t<select name=\"stup_reimb_type_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"stup_reimb_type_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" DISABLED>\n\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="---</option>\n\t\t\t\t<option value=\'F\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\n\t\t\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t\t<option value=\'N\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</option>\n\t\t\t\t</select>\n-->\n\t\t\t\t</td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" width=\'20%\'><div id=\'stup_reimb_amt_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" width=\'20%\'><div align=\'center\'><input type=\"checkbox\" name=\"override_YN_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"override_YN_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onClick=\"check_for_override(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\"></div></td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" width=\'20%\'><div align=\'center\'><input type=\"checkbox\" name=\"curr_reimb_YN_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"curr_reimb_YN_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" DISABLED onClick=\"curr_reimb_items_check(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\"></input></div></td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" width=\'20%\'>\n\t\t\t\t\t<select name=\"curr_reimb_type_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"curr_reimb_type_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" DISABLED onChange=\"curr_reimb_type_chg(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\">\n\t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="---</option>\n\t\t\t\t\t\t<option value=\'F\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t\t\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n\t\t\t\t\t\t<option value=\'N\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" width=\'20%\'><input type=\'text\' name=\"curr_rev_amt_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"curr_rev_amt_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value));\' value=\"\" onBlur=\"chk_for_allwd_amt(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');\" DISABLED style=\'text-align:right\'></td>\n\t\t\t</tr>\n\t\t\t<input type=\'hidden\' name=\'blng_serv_code_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'blng_serv_code_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t<input type=\'hidden\' name=\'serv_item_code_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'serv_item_code_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t<input type=\'hidden\' name=\'stup_reimb_type_hid_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'stup_reimb_type_hid_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t<input type=\'hidden\' name=\'override_reimbursable_yn_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'override_reimbursable_yn_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\t\t\t\n\t\t\t<input type=\'hidden\' name=\'trx_doc_ref_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'trx_doc_ref_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t<input type=\'hidden\' name=\'trx_doc_ref_line_num_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'trx_doc_ref_line_num_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t<input type=\'hidden\' name=\'trx_doc_ref_seq_num_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'trx_doc_ref_seq_num_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t<input type=\'hidden\' name=\'serv_module_id_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'serv_module_id_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\t\t\t\n\t\t\t<input type=\'hidden\' name=\'blng_grp_id_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' id=\'blng_grp_id_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\t\t\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'reimb_override_allow_YN_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'reimb_override_allow_YN_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' value=\"\">\t\t\t\n\t\t\t<input type=\'hidden\' name=\'max_part_serv_reim_per_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' id=\'max_part_serv_reim_per_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' value=\"\">\t\t\t\n\t\t\t<input type=\'hidden\' name=\'max_part_serv_reim_amt_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' id=\'max_part_serv_reim_amt_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' value=\"\">\t\t\t\n\t\t\t<input type=\'hidden\' name=\'override_control_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' id=\'override_control_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' value=\"\">\t\n\t\t\t<input type=\'hidden\' name=\'reimb_reason_code_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'reimb_reason_code_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' value=\"\">\t\n\n\t\t\t<input type=\"hidden\" name=\"rtn_stup_reimb_YN_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"rtn_stup_reimb_YN_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"\tvalue=\"\" >\t\n\t\t\t<input type=\"hidden\" name=\"rtn_stup_reimb_type_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"rtn_stup_reimb_type_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"\tvalue=\"\" >\t\n\t\t\t<input type=\"hidden\" name=\"rtn_stup_reimb_amt_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"rtn_stup_reimb_amt_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"\tvalue=\"\" >\t\n\n\t\t\t<input type=\"hidden\" name=\"rtn_curr_reimb_YN_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"rtn_curr_reimb_YN_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"\tvalue=\"\" >\t\n\t\t\t<input type=\"hidden\" name=\"rtn_curr_reimb_type_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"rtn_curr_reimb_type_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"\tvalue=\"\" >\t\n\t\t\t<input type=\"hidden\" name=\"rtn_curr_rev_amt_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"rtn_curr_rev_amt_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"\tvalue=\"\" >\t\n\t\t\t\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="  \n\t</tbody>\n\t</table>\n\t</div>\n\n\t<input type=\'hidden\' name=\'bill_doc_type_code\' id=\'bill_doc_type_code\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\'hidden\' name=\'bill_doc_num\' id=\'bill_doc_num\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\t\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\tvalue=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\n\t<input type=\"hidden\" name=\"total_records\" id=\"total_records\"\tvalue=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" >\n\t<input type=\"hidden\" name=\"noofdecimal\" id=\"noofdecimal\"\tvalue=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" >\n\t<input type=\"hidden\" name=\"existing_reason_code\" id=\"existing_reason_code\" value=\"\">\t\n\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" >\t\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" >\t\n\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\"\tvalue=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" >\t\n\t<input type=\"hidden\" name=\"visit_id\" id=\"visit_id\"\tvalue=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" >\t\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" >\t\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\"\tvalue=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" >\t\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\tvalue=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" >\t\n\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\"\tvalue=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" >\t\n</form>\n</BODY>\n<script>\n\tvar total_records = document.forms[0].total_records.value;\n\tvar function_id = document.forms[0].function_id.value;\n\n//\talert(total_records);\n\tif(total_records == 0)\n\t{\n\t\tif(function_id == \"EBL_OP_OVERIDE_UNBLD_REIM_DTLS\" || function_id == \"EBL_IP_OVERIDE_UNBLD_REIM_DTLS\")\n\t\t{\n\t\t\t/* parent.window.returnValue = \"Y\";\n\t\t\tparent.window.close(); */\n\t\t\t var dialogBody = parent.parent.parent.document.getElementById(\'dialog-body\');\n\t\t\tdialogBody.contentWindow.returnValue = \"Y\";\n\t\t\t    \n\t\t\tconst dialogTag = parent.parent.parent.document.getElementById(\'dialog_tag\');    \n\t\t\tdialogTag.close();\n\t\t}\n\t}\n</script>\n</HTML>\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	Statement stmt				= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	String classval="";
	try
	{
		con	=	ConnectionManager.getConnection(request);

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		int i=0,noofdecimal=2;

		String doc_type_code="",doc_num="", checked_var="CHECKED";

		String locale="", str_facility_id="", strloggeduser="", strclientip="", str_patient_id="", str_episode_type="", str_episode_id="", str_visit_id="", str_encounter_id="", str_module_id="", str_function_id="";

		String blng_serv_code="",blng_serv_desc="",serv_item_code="",serv_item_desc="",service_date="",org_net_charge_amt="",reimbursable_yn="N",reimbursable_ind="",net_reimbursable_amt="",override_reimbursable_yn="N",serv_module_id="",blng_grp_id="";

		String trx_doc_ref="",trx_doc_ref_line_num="",trx_doc_ref_seq_num="";

		double v_org_net_charge_amt=0, v_net_reimbursable_amt=0;
		
		CurrencyFormat cf1 = new CurrencyFormat();

		String query_string=request.getQueryString();

		try
		{
			locale	= (String)session.getAttribute("LOCALE");	
			if(locale==null || locale.equals("")) locale="en";	

			str_facility_id = (String) session.getValue("facility_id");
			if (str_facility_id==null) str_facility_id = "";

			strloggeduser	=  (String) session.getValue("login_user");	
			if (strloggeduser==null) strloggeduser = "";

			strclientip = p.getProperty("client_ip_address");
			if (strclientip==null) strclientip = "";

			str_patient_id = request.getParameter("patient_id");	
			if(str_patient_id==null) str_patient_id="";	
			
			str_episode_type = request.getParameter("episode_type");	
			if(str_episode_type==null) str_episode_type="";	
		
			str_episode_id = request.getParameter("episode_id");	
			if(str_episode_id==null) str_episode_id="";	

			str_visit_id = request.getParameter("visit_id");	
			if(str_visit_id==null) str_visit_id="";	
		
			str_encounter_id = request.getParameter("encounter_id");	
			if(str_encounter_id==null) str_encounter_id="";	

			str_module_id     =  request.getParameter("module_id");	
			if(str_module_id == null) str_module_id="";

			doc_type_code =  request.getParameter("billdoctypecode");
			if(doc_type_code == null) doc_type_code="";

			doc_num =  request.getParameter("billdocnum");
			if(doc_num == null) doc_num="";

			str_function_id =  request.getParameter("function_id");
			if(str_function_id == null) str_function_id="";
		}
		catch(Exception e)
		{
			System.err.println("Error in BLBillListDtls.jsp - fetching values:"+e);
		}

            _bw.write(_wl_block6Bytes, _wl_block6);
	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		try
		{
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
				System.err.println("3="+e.toString());
			}

			String strsql="";

			if(str_function_id.equals("EBL_OP_OVERRIDE_REIM_DTLS") || str_function_id.equals("EBL_IP_OVERRIDE_REIM_DTLS"))
			{
				strsql="SELECT BLNG_SERV_CODE,SERV_ITEM_CODE,to_char(SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS') SERVICE_DATE,ORG_NET_CHARGE_AMT,REIMBURSABLE_YN,REIMBURSABLE_IND,NET_REIMBURSABLE_AMT,DECODE('"+locale+"','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC,TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,OVERRIDE_REIMBURSABLE_YN,MODULE_ID,a.BLNG_GRP_ID FROM BL_PATIENT_CHARGES_FOLIO A, BL_BILL_HDR B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.BILL_DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.BILL_DOC_NUM = B.DOC_NUM AND A.Operating_Facility_Id='"+str_facility_id+"' AND A.PATIENT_ID = '"+str_patient_id+"' AND NVL(A.ORG_NET_CHARGE_AMT,0)>0 AND B.DOC_TYPE_CODE='"+doc_type_code+"' AND B.DOC_NUM='"+doc_num+"'";
			}
			else if(str_function_id.equals("EBL_OP_OVERIDE_UNBLD_REIM_DTLS") || str_function_id.equals("EBL_IP_OVERIDE_UNBLD_REIM_DTLS"))
			{
				strsql="SELECT BLNG_SERV_CODE,SERV_ITEM_CODE,to_char(SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS') SERVICE_DATE,ORG_NET_CHARGE_AMT,REIMBURSABLE_YN,REIMBURSABLE_IND,NET_REIMBURSABLE_AMT,DECODE('"+locale+"','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC,TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,OVERRIDE_REIMBURSABLE_YN,MODULE_ID,a.BLNG_GRP_ID FROM BL_PATIENT_CHARGES_FOLIO A Where Operating_Facility_Id='"+str_facility_id+"' AND PATIENT_ID = '"+str_patient_id+"' And Episode_Type='"+str_episode_type+"' And (( Episode_Type IN ('O','E','I','D') And NVL(Episode_Id,99999999) = Nvl('"+str_episode_id+"',99999999)) OR Episode_Type NOT IN ('O','E','I','D')) And (( Episode_Type IN ('O','E') And Nvl(Visit_Id,9999)=Nvl('"+str_visit_id+"',9999)) OR Episode_Type NOT IN ('O','E')) AND NVL(ORG_NET_CHARGE_AMT,0)>0 And NVL(TRX_STATUS,'O')='O' And NVL(BILLED_FLAG,'N')='N' And BILL_DOC_TYPE_CODE IS NULL And Cust_Code Is Null";
			}

//			System.err.println("strsql "+strsql);	

			stmt = con.createStatement();
			rs = stmt.executeQuery(strsql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					blng_serv_code = rs.getString(1);
					if(blng_serv_code == null) blng_serv_code="";

					serv_item_code = rs.getString(2);
					if(serv_item_code == null) serv_item_code="";

					service_date = rs.getString(3);
					if(service_date == null) service_date="";

					org_net_charge_amt=rs.getString(4);
					if(org_net_charge_amt == null) org_net_charge_amt="0";
					org_net_charge_amt = cf1.formatCurrency(org_net_charge_amt, noofdecimal);
					v_org_net_charge_amt = Double.parseDouble(org_net_charge_amt);

					reimbursable_yn = rs.getString(5);
					if(reimbursable_yn == null) reimbursable_yn="N";

					reimbursable_ind =rs.getString(6);
					if(reimbursable_ind == null) reimbursable_ind="";

					net_reimbursable_amt=rs.getString(7);
					if(net_reimbursable_amt == null) net_reimbursable_amt="0";
					net_reimbursable_amt = cf1.formatCurrency(net_reimbursable_amt, noofdecimal);
					v_net_reimbursable_amt = Double.parseDouble(net_reimbursable_amt);

					serv_item_desc=rs.getString(8);
					if(serv_item_desc == null) serv_item_desc="&nbsp;";

					trx_doc_ref=rs.getString(9);
					if(trx_doc_ref == null) trx_doc_ref="";
					
					trx_doc_ref_line_num=rs.getString(10);
					if(trx_doc_ref_line_num == null) trx_doc_ref_line_num="";
					
					trx_doc_ref_seq_num=rs.getString(11);
					if(trx_doc_ref_seq_num == null) trx_doc_ref_seq_num="";

					override_reimbursable_yn=rs.getString(12);
					if(override_reimbursable_yn == null) override_reimbursable_yn="N";

					serv_module_id = rs.getString(13);
					if(serv_module_id == null) serv_module_id="";

					blng_grp_id = rs.getString(14);
					if(blng_grp_id == null) blng_grp_id="";

					if(reimbursable_yn.equals("Y"))
					{
						checked_var="CHECKED";
					}
					else
					{
						checked_var="";
					}

					try
					{		
						pstmt1 = con.prepareStatement( " select SHORT_DESC from bl_blng_serv_lang_vw where blng_serv_code='"+blng_serv_code+"' and language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();	
						while(rs1.next())
						{
							blng_serv_desc  =  rs1.getString(1);		
						}		
						if(blng_serv_desc == null) blng_serv_desc="";
						rs1.close();
						pstmt1.close();
					}
					catch(Exception e)
					{
						System.err.println("Billing Serv Desc Fetching="+e.toString());
					}

					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(blng_serv_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(serv_item_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(service_date,"DMYHMS","en",locale)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(org_net_charge_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(checked_var));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(net_reimbursable_amt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(blng_serv_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(serv_item_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(reimbursable_ind));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(override_reimbursable_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(trx_doc_ref));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(trx_doc_ref_line_num));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(trx_doc_ref_seq_num));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(serv_module_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
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
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
			
					i++;
				}//while		
			}//rs 
			stmt.close();
			rs.close();
		}
		catch(Exception e)
		{
			System.err.println("Exception in main qry :"+e);
		}

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(doc_num));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(str_patient_id));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(str_episode_id));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(str_visit_id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(str_encounter_id));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(str_module_id));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(str_module_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(str_function_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block111Bytes, _wl_block111);

	}
	catch(Exception ee)
	{
	  System.err.println("Error in main Adhoc disc " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.LIST_OF_SERV.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ServiceDescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_DATE.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NET_CHARGE.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DFND_REIMB.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DFN_REIMB_TYPE.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DFN_REIMB_AMT.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.override.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CURR_REIMB.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CURR_REIMB_TYPE.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REVISED_AMT.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FULL.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PART.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NA.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FULL.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PART.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NA.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
