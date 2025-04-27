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

public final class __bladhocdisc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAdhocDisc.jsp", 1734604050224L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<STYLE TYPE=\"text/CSS\">\n\n/* This style is used for locking the table\'s heading  */\n\ndiv#tbl-container {\nheight: 245px;\noverflow: auto;\n}\n\nthead td, thead td.locked\t{\nposition:relative;\n}\n\nthead td {\ntop: expression(document.getElementById(\"tbl-container\").scrollTop-2); \nz-index: 20;\n}\n\n</STYLE>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLAdhocDisc.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<script>\n\t\tfunction show_perc_text(i)\n\t\t{\n\t\t\tvar disc_list = eval(document.getElementById(\"disc_list\"+i));\t\t\t\n\n\t\t\tif(disc_list.value==\"P\")\n\t\t\t{\n\t\t\t\tvar pert_amt_disp=eval(document.getElementById(\"pert_amt_disp\"+i));\n\t\t\t\tpert_amt_disp.style=\"display\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar pert_amt_disp=eval(document.getElementById(\"pert_amt_disp\"+i));\n\t\t\t\tpert_amt_disp.style.display=\'none\';\n\t\t\t}\n\t\t}\n\n\t\tasync function callAdhocDisc(i)\n\t\t{\n//alert(1);\n\t\t\tvar adhoc_user_id=\"\";\n\t\t\tvar adhoc_reason_desc=\"\";\n\t\t\tvar trx_ind=\"1\";\n\t\t\tvar total_records=document.forms[0].total_records.value;\n\n\t\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\t\tvar episode_type = document.forms[0].episode_type.value;\n\t\t\tvar episode_id = document.forms[0].episode_id.value;\n\t\t\tvar visit_id = document.forms[0].visit_id.value;\n\t\t\tvar module_id = document.forms[0].module_id.value;\n\t\t\tvar decimal = document.forms[0].noofdecimal.value;\n\n\t\t\tvar existing_reason_code = document.forms[0].existing_reason_code.value;\n\n\t\t\tvar trx_doc_ref_seq_num_count = eval(\"document.forms[0].trx_doc_ref_seq_num_count\"+i);\n\t\t\ttrx_doc_ref_seq_num_count = trx_doc_ref_seq_num_count.value;\n\n\t\t\tvar blng_serv_code = eval(\"document.forms[0].blng_serv_code\"+i);\t\n\t\t\tblng_serv_code = blng_serv_code.value;\n\n\t\t\tvar serv_item_code = eval(\"document.forms[0].serv_item_code\"+i);\t\n\t\t\tserv_item_code = serv_item_code.value;\n\n\t\t\tvar serv_item_desc = eval(document.getElementById(\"serv_item_desc\"+i));\t\n\t\t\tserv_item_desc = encodeURIComponent(serv_item_desc.innerText);\n//alert(\"serv_item_desc:\"+serv_item_desc);\n\t\t\tvar upd_net_charge_amt = eval(document.getElementById(\"net_amt\"+i));\t\n\t\t\tupd_net_charge_amt = upd_net_charge_amt.innerText;\n//alert(\"upd_net_charge_amt:\"+upd_net_charge_amt);\n\t\t\tvar act_gross_amt = eval(\"document.forms[0].act_gross_amt\"+i);\t\n\t\t\tact_gross_amt = act_gross_amt.value;\t\n//alert(\"act_gross_amt:\"+act_gross_amt);\n\t\t\tvar upd_gross_charge_amt = eval(document.getElementById(\"gross_amt\"+i));\t\n\t\t\tupd_gross_charge_amt = upd_gross_charge_amt.innerText;\t\n//alert(\"upd_gross_charge_amt:\"+upd_gross_charge_amt);\n\t\t\tvar upd_disc_amt = eval(document.getElementById(\"disc_amt\"+i));\t\n\t\t\tupd_disc_amt = upd_disc_amt.innerText;\t\n//alert(\"upd_disc_amt:\"+upd_disc_amt);\n\n\t\t\tvar trx_doc_ref_line_no = eval(\"document.forms[0].trx_doc_ref_line_no\"+i);\t\n\t\t\ttrx_doc_ref_line_no = trx_doc_ref_line_no.value;\t\n//alert(\"trx_doc_ref_line_no:\"+trx_doc_ref_line_no);\n\t\t\tvar trx_doc_ref = eval(\"document.forms[0].trx_doc_ref\"+i);\t\n\t\t\ttrx_doc_ref = trx_doc_ref.value;\t\n//alert(\"trx_doc_ref:\"+trx_doc_ref);\n\t\t\tvar retVal=\"\";\n\t\t\tvar dialogHeight= \"70vh\" ;\n\t\t\tvar dialogWidth\t= \"80vw\" ;\n\t\t\tvar dialogTop = \"10\" ;\n\t\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; scroll=no; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\t\n\t\t\t//var title=encodeURIComponent(getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\"));\n\t\t\tvar title=\"\";//\"Adhoc Discount\";\n\t\t\tvar arguments = \"\" ;\n\t\t\tvar column_sizes = escape(\"\");               \n\t\t\tvar column_descriptions =\"\";\t\n\t\t\t\n\t\t\tif(eval(act_gross_amt)<0)\n\t\t\t{\n\t\t\t\ttrx_ind=\"-1\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\ttrx_ind=\"1\";\n\t\t\t}\n\n\t\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"patient_id=\"+patient_id+\"&\"+\"episode_type=\"+episode_type+\"&\"+\"episode_id=\"+episode_id+\"&\"+\"visit_id=\"+visit_id+\"&\"+\"blng_serv_code=\"+blng_serv_code+\"&\"+\"serv_item_code=\"+serv_item_code+\"&\"+\"serv_item_desc=\"+serv_item_desc+\"&\"+\"upd_net_charge_amt=\"+upd_net_charge_amt+\"&\"+\"act_gross_amt=\"+act_gross_amt+\"&\"+\"upd_gross_charge_amt=\"+upd_gross_charge_amt+\"&\"+\"upd_disc_amt=\"+upd_disc_amt+\"&\"+\"trx_doc_ref_line_no=\"+trx_doc_ref_line_no+\"&\"+\"trx_doc_ref=\"+trx_doc_ref+\"&\"+\"trx_doc_ref_seq_num_count=\"+trx_doc_ref_seq_num_count+\"&\"+\"existing_reason_code=\"+existing_reason_code+\"&trx_ind=\"+trx_ind+\"&called_frm_frame=S&module_id=\"+module_id;\n\n\t\t\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLAdhocDiscDtlsEditFrame.jsp?\"+param,arguments,features);\t\t\n\n\t\t\tif (retVal != null || retVal!=\"\")\n\t\t\t{\n\t\t\t\tif(retVal!=\'undefined\' && retVal!=undefined)\n\t\t\t\t{\n\t\t\t\t\tvar retVal=unescape(retVal);\t\t\t\n\t\t\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t\t\t{\n\t\t\t\t\t\tarr=retVal.split(\"|\");\t\t\t\t\t\n\t\t\t\t\t\tadhoc_user_id = arr[0];\n\t\t\t\t\t\tadhoc_reason_code = arr[1];\n\n\t\t\t\t\t\tvar adhoc_user_id = eval(\"document.forms[0].adhoc_user_id\"+i);\t\n\t\t\t\t\t\tadhoc_user_id.value=arr[0];\n\n\t\t\t\t\t\tvar disc_reason_code = eval(\"document.forms[0].disc_reason_code\"+i);\t\n\t\t\t\t\t\tdisc_reason_code.value = arr[1];\n\n\t\t\t\t\t\tdocument.forms[0].existing_reason_code.value = adhoc_reason_code;\n\n\t\t\t\t\t\tvar serv_retArr = refresh_serv_disc(i,trx_doc_ref,trx_doc_ref_line_no,existing_reason_code,patient_id,episode_type,episode_id,visit_id);\n\n\t\t\t\t\t\tvar serv_arr_msg = new Array();\n\t\t\t\t\t\tserv_arr_msg=serv_retArr.split(\"|\");\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar serv_upd_gross_charge_amt = eval(parent.frames[1].document.getElementById(\"gross_amt\"+i));\n\t\t\t\t\t\tserv_upd_gross_charge_amt.innerText = serv_arr_msg[0];\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar serv_upd_disc_amt = eval(parent.frames[1].document.getElementById(\"disc_amt\"+i));\t\n\t\t\t\t\t\tserv_upd_disc_amt.innerText = serv_arr_msg[1];\n\n\t\t\t\t\t\tvar serv_upd_net_charge_amt = eval(parent.frames[1].document.getElementById(\"net_amt\"+i));\n\t\t\t\t\t\tserv_upd_net_charge_amt.innerText = serv_arr_msg[2];\n\n\t\t\t\t\t\tvar serv_act_gross_amt = eval(\"parent.frames[1].document.forms[0].act_gross_amt\"+i);\t\n\t\t\t\t\t\tserv_act_gross_amt.value = serv_arr_msg[3];\n\n\t\t\t\t\t\tvar tot_rec_by_ser = parent.frames[1].document.forms[0].total_records.value;\n\t\t\t\t\t\tvar temp_tot_gross_amt=0, temp_tot_disc_amt=0, temp_tot_net_amt=0; \n\n\t\t\t\t\t\tfor(var j=0;j<tot_rec_by_ser;j++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar tot_serv_upd_gross_charge_amt = eval(parent.frames[1].document.getElementById(\"gross_amt\"+j));\n\t\t\t\t\t\t\ttemp_tot_gross_amt = temp_tot_gross_amt+eval(tot_serv_upd_gross_charge_amt.innerText);\n\n\t\t\t\t\t\t\tvar tot_serv_upd_disc_amt = eval(parent.frames[1].document.getElementById(\"disc_amt\"+j));\t\n\t\t\t\t\t\t\ttemp_tot_disc_amt = temp_tot_disc_amt+eval(tot_serv_upd_disc_amt.innerText);\n\n\t\t\t\t\t\t\tvar tot_serv_upd_net_charge_amt = eval(parent.frames[1].document.getElementById(\"net_amt\"+j));\n\t\t\t\t\t\t\ttemp_tot_net_amt = temp_tot_net_amt+eval(tot_serv_upd_net_charge_amt.innerText);\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttemp_tot_gross_amt = temp_tot_gross_amt.toFixed(decimal);\n\t\t\t\t\t\ttemp_tot_disc_amt = temp_tot_disc_amt.toFixed(decimal);\n\t\t\t\t\t\ttemp_tot_net_amt = temp_tot_net_amt.toFixed(decimal);\n\t\t\t\t\t\tparent.frames[2].document.forms[0].tot_serv_gross_amt.value = temp_tot_gross_amt;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].tot_serv_disc_amt.value = temp_tot_disc_amt;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].tot_serv_net_amt.value = temp_tot_net_amt;\n\n\t\t\t\t\t\tputdeci(parent.frames[2].document.forms[0].tot_serv_gross_amt);\n\t\t\t\t\t\tputdeci(parent.frames[2].document.forms[0].tot_serv_disc_amt);\n\t\t\t\t\t\tputdeci(parent.frames[2].document.forms[0].tot_serv_net_amt);\n\n\t\t\t\t\t\tdocument.forms[0].tot_upd_gross_charge_amt.value = parent.frames[2].document.forms[0].tot_serv_gross_amt.value;\n\t\t\t\t\t\tdocument.forms[0].tot_upd_disc_amt.value = parent.frames[2].document.forms[0].tot_serv_disc_amt.value;\n\t\t\t\t\t\tdocument.forms[0].tot_upd_net_charge_amt.value = parent.frames[2].document.forms[0].tot_serv_net_amt.value;\n\n\t\t\t\t\t\tcallByService(i);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\n\t\tfunction callByService(i)\n\t\t{\n\t\t\tvar trx_doc_ref = eval(\"document.forms[0].trx_doc_ref\"+i);\t\n\t\t\ttrx_doc_ref = trx_doc_ref.value;\t\n\n\t\t\tvar trx_doc_ref_line_no = eval(\"document.forms[0].trx_doc_ref_line_no\"+i);\t\n\t\t\ttrx_doc_ref_line_no = trx_doc_ref_line_no.value;\t\n\n\t\t\tvar gross_amt = eval(document.getElementById(\"gross_amt\"+i));\t\n\t\t\tgross_amt = gross_amt.innerText;\t\n\n\t\t\tvar disc_amt = eval(document.getElementById(\"disc_amt\"+i));\t\n\t\t\tdisc_amt = disc_amt.innerText;\t\n\n\t\t\tvar net_amt = eval(document.getElementById(\"net_amt\"+i));\t\n\t\t\tnet_amt = net_amt.innerText;\t\n\n\t\t\tvar tot_upd_gross_charge_amt = document.forms[0].tot_upd_gross_charge_amt.value;\t\n\n\t\t\tvar tot_upd_disc_amt = document.forms[0].tot_upd_disc_amt.value;\t\n\n\t\t\tvar tot_upd_net_charge_amt = document.forms[0].tot_upd_net_charge_amt.value;\t\n\t\n\t\t\tvar query_string =  document.forms[0].query_string.value; \n\t\t\tparent.frames[2].location.href=\"../../eBL/jsp/BLAdhocDiscByPayer.jsp?trx_doc_ref=\"+trx_doc_ref+\"&trx_doc_ref_line_no=\"+trx_doc_ref_line_no+\"&selected_serv_rec=\"+i+\"&gross_amt=\"+gross_amt+\"&disc_amt=\"+disc_amt+\"&net_amt=\"+net_amt+\"&tot_upd_gross_charge_amt=\"+tot_upd_gross_charge_amt+\"&tot_upd_disc_amt=\"+tot_upd_disc_amt+\"&tot_upd_net_charge_amt=\"+tot_upd_net_charge_amt+\"&\"+query_string;\n\t\t}\n\n\t\tfunction call_first_serv()\n\t\t{\n\t\t\t\n\t\t\tvar total_records = document.forms[0].total_records.value;\n\t\t\tif(total_records >0 )\n\t\t\t{\n\t\t\t\tvar trx_doc_ref = eval(\"document.forms[0].trx_doc_ref\"+0);\t\n\t\t\t\ttrx_doc_ref = trx_doc_ref.value;\t\n\n\t\t\t\tvar trx_doc_ref_line_no = eval(\"document.forms[0].trx_doc_ref_line_no\"+0);\t\n\t\t\t\ttrx_doc_ref_line_no = trx_doc_ref_line_no.value;\t\n\n\t\t\t\tvar gross_amt = eval(document.getElementById(\"gross_amt\"+0));\t\n\t\t\t\tgross_amt = gross_amt.innerText;\t\n\n\t\t\t\tvar disc_amt = eval(document.getElementById(\"disc_amt\"+0));\t\n\t\t\t\tdisc_amt = disc_amt.innerText;\t\n\n\t\t\t\tvar net_amt = eval(document.getElementById(\"net_amt\"+0));\t\n\t\t\t\tnet_amt = net_amt.innerText;\t\n\n\t\t\t\tvar tot_upd_gross_charge_amt = document.forms[0].tot_upd_gross_charge_amt.value;\t\n\n\t\t\t\tvar tot_upd_disc_amt = document.forms[0].tot_upd_disc_amt.value;\t\n\n\t\t\t\tvar tot_upd_net_charge_amt = document.forms[0].tot_upd_net_charge_amt.value;\t\n\t\t\t\t\n\t\t\t\tvar query_string =  document.forms[0].query_string.value; \n\t\t\t\tparent.frames[2].location.href=\"../../eBL/jsp/BLAdhocDiscByPayer.jsp?trx_doc_ref=\"+trx_doc_ref+\"&trx_doc_ref_line_no=\"+trx_doc_ref_line_no+\"&selected_serv_rec=0\"+\"&gross_amt=\"+gross_amt+\"&disc_amt=\"+disc_amt+\"&net_amt=\"+net_amt+\"&tot_upd_gross_charge_amt=\"+tot_upd_gross_charge_amt+\"&tot_upd_disc_amt=\"+tot_upd_disc_a";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="mt+\"&tot_upd_net_charge_amt=\"+tot_upd_net_charge_amt+\"&\"+query_string;\n\t\t\t}\n\t\t}\n</script>\n\n<BODY onLoad=\"call_first_serv();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n<FORM name=\'AdhocDicountsbyServiceForm\' id=\'AdhocDicountsbyServiceForm\' action=\"\" method=\'\'>\t\n\n<div id=\'tbl-container\'>\t\n\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\t\n\t<thead>\n\t\t<tr>\n\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="</td>\t\t\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t</tr>\n\t</thead>\n\t<tbody>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<tr>\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t<td class=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" width=\'30%\'><div id=\"billing_service";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\n\t\t\t\t<a name=\'blng_serv_anchor";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' href=\"#\" onClick=\"javascript:callByService(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\n\t\t\t\t</div></td>\n\t\t\t\t<input type=\"hidden\" name=\"blng_serv_code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"blng_serv_code";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" width=\'30%\'><div id=\"serv_item_desc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div></td>\n\t\t\t\t<input type=\"hidden\" name=\"serv_item_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"serv_item_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" width=\'10%\' ><div id=\"serv_date";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div></td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" width=\'10%\' ><div id=\"gross_amt";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" style=\'text-align:right\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</div></td>\n<!--\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" width=\"15%\"><div align=\'right\'><a name=\'disc_amt";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' href=\"#\" onClick=\"callByService(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');javascript:callAdhocDisc(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</a></div></td>\t\n-->\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" width=\"10%\">\n<!--\t\t\t\t\n\t\t\t\t<div style=\'text-align:right\' id=\'disc_amt";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</div>\n-->\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t\t\t\t<a href=\"#\" onClick=\"callAdhocDisc(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\" ><div id=\'disc_amt";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' align=\'right\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</div></a>\n<!--\n\t\t\t\t<div id=\'disc_amt";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<div id=\'disc_amt";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</div>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\n\t\t\t\t</td>\t\n\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" width=\'10%\'><div style=\'text-align:right\' id=\"net_amt";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</div></td>\n\n\t\t\t\t<input type=\"hidden\" name=\"trx_doc_ref_line_no";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"trx_doc_ref_line_no";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"trx_doc_ref";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"trx_doc_ref";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"act_gross_amt";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"act_gross_amt";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"disc_reason_code";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"disc_reason_code";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"\tvalue=\"\" >\n\t\t\t\t<input type=\"hidden\" name=\"adhoc_user_id";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"adhoc_user_id";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"trx_doc_ref_seq_num_count";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"trx_doc_ref_seq_num_count";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\t\t\t\t\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" \n\n\t</tbody>\n\t</table>\n\t<input type=\"hidden\" name=\"total_records\" id=\"total_records\"\tvalue=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t<input type=\"hidden\" name=\"noofdecimal\" id=\"noofdecimal\"\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\t<input type=\"hidden\" name=\"checked_services\" id=\"checked_services\" value=\"\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\"\tvalue=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t<input type=\"hidden\" name=\"visit_id\" id=\"visit_id\"\tvalue=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\tvalue=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\"\tvalue=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\t<input type=\"hidden\" name=\"clinic_code\" id=\"clinic_code\"\tvalue=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\t<input type=\"hidden\" name=\"visit_type_code\" id=\"visit_type_code\"\tvalue=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" >\n\t<input type=\"hidden\" name=\"blnggrp\" id=\"blnggrp\"\tvalue=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\n\t<input type=\"hidden\" name=\"existing_reason_code\" id=\"existing_reason_code\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\"\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >\n\t<input type=\"hidden\" name=\"called_frm\" id=\"called_frm\"  value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\t\n\t<input type=\"hidden\" name=\"called_butt\" id=\"called_butt\"  value=\"\">\n\t<input type=\"hidden\" name=\"doc_no\" id=\"doc_no\"  value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\"  value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t<input type= \'hidden\' name=\"slmt_reqd_yn\" id=\"slmt_reqd_yn\"  value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\"  value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\"hidden\" name=\"ws_no\" id=\"ws_no\"  value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t<input type=\"hidden\" name=\"machine_id\" id=\"machine_id\"  value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\t\n\n\t<input type=\"hidden\" name=\"tot_upd_gross_charge_amt\" id=\"tot_upd_gross_charge_amt\"  value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\t\n\t<input type=\"hidden\" name=\"tot_upd_disc_amt\" id=\"tot_upd_disc_amt\"  value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\t\n\t<input type=\"hidden\" name=\"tot_upd_net_charge_amt\" id=\"tot_upd_net_charge_amt\"  value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\t\n\n\t<input type=\"hidden\" name=\"allow_chkout_with_bill_stmt_yn\" id=\"allow_chkout_with_bill_stmt_yn\"  value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\t\n<!-- added for ghl-crf-1.2-->\n\t<input type=\"hidden\" name=\"called_for_reg_chg\" id=\"called_for_reg_chg\"  value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\t\n<!--end-->\n\t<input type=\"hidden\" name=\"strpackageseqno\" id=\"strpackageseqno\"  value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\t\n\t<input type=\"hidden\" name=\"package_enabled_yn\" id=\"package_enabled_yn\"  value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\t\n\t<input type=\"hidden\" name=\"pkg_codes_for_disc\" id=\"pkg_codes_for_disc\"  value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n</form>\n</BODY>\n\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n<script>\n//Commented by Gayathri for AMRI-SCF-0444\n\twindow.returnValue=\' | |N\';\n\twindow.close();\n\t//parent.parent.document.querySelectorAll(\'#dialog-body\')[parent.parent.document.querySelectorAll(\'#dialog-body\').length-1].contentWindow.returnValue=\' | |N\';\n\t//parent.parent.document.querySelectorAll(\'#dialog_tag\')[parent.parent.document.querySelectorAll(\'#dialog_tag\').length-1].close();\n</script>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t<script>\n\twindow.returnValue=\' | |N\';\n\twindow.close();\n\t//parent.parent.document.querySelectorAll(\'#dialog-body\')[parent.parent.document.querySelectorAll(\'#dialog-body\').length-1].contentWindow.returnValue=\' | |N\';\n\t//parent.parent.document.querySelectorAll(\'#dialog_tag\')[parent.parent.document.querySelectorAll(\'#dialog_tag\').length-1].close();\n\n</script>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n</HTML>\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;	
	ResultSet rs2				= null;	
	ResultSet rss				= null;	
	
	
	String classval="";
	boolean amountRoundOff = true; //Added V180125-Subha/MMS-JU-SCF-0102
	boolean pkgDepApplicable_YN=true;
	String pkgDepAdjAppl="";
	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		pkgDepApplicable_YN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","PKG_DEP_ADJ_APPL_YN");
		if(pkgDepApplicable_YN){
			pkgDepAdjAppl="Y";
		}
		else{
			pkgDepAdjAppl="N";
		}
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		CurrencyFormat cf1 = new CurrencyFormat();
		String query_string=request.getQueryString();
		//System.err.println("query_string in BLAdhocDisc.jsp:"+query_string);
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	

		String str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
//		System.err.println("strclientip "+strclientip);
		
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

		String str_function_id     =  request.getParameter("function_id");	
		if(str_function_id == null) str_function_id="";

		String str_module_id     =  request.getParameter("module_id");	
		if(str_module_id == null) str_module_id="";

		String str_clinic_code     =  request.getParameter("locn_code");	
		if(str_clinic_code == null) str_clinic_code="";

		String str_visit_type_code     =  request.getParameter("visit_type_code");	
		if(str_visit_type_code == null) str_visit_type_code="";

		String str_blng_grp_id     =  request.getParameter("blnggrp");
		if(str_blng_grp_id == null) str_blng_grp_id="";

		String called_frm     =  request.getParameter("called_frm");
		if(called_frm == null) called_frm="";

		String str_doc_no     =  request.getParameter("doc_no");
		if(str_doc_no == null) str_doc_no="";

		String str_store_code     =  request.getParameter("store_code");
		if(str_store_code == null) str_store_code="";

		String p_slmt_reqd_yn = request.getParameter("slmt_reqd_yn");	
		if(p_slmt_reqd_yn==null) p_slmt_reqd_yn="";	
		
		String str_custmr_id = request.getParameter("customer_id");	
		if(str_custmr_id==null) str_custmr_id="";
		
		
		
		String allow_chkout_with_bill_stmt_yn = request.getParameter("allow_chkout_with_bill_stmt_yn");
		if(allow_chkout_with_bill_stmt_yn == null) allow_chkout_with_bill_stmt_yn="N";
		/***********Added for ghl-crf-1.2******************************/
		String called_for_reg_chg = request.getParameter("called_for_reg_chg");
		if(called_for_reg_chg == null) called_for_reg_chg="N";
		/***************end*********************************************/
		
		String blng_serv_code ="", serv_desc="",act_gross_amt="",trx_doc_ref="",blng_serv_date="",trx_doc_ref_line_num="", serv_item_code="", serv_item_desc=""; //blng_grp_id="", policy_type_code="" UNUSED
		
		int i=0,noofdecimal=2,cnt=0;

		String upd_gross_charge_amt="", upd_disc_amt="", upd_net_charge_amt="", adhoc_disc_amt="";

		double v_act_gross_amt=0, v_upd_gross_charge_amt=0, v_upd_disc_amt=0, v_upd_net_charge_amt=0;

		double v_tot_upd_gross_charge_amt=0, v_tot_upd_disc_amt=0, v_tot_upd_net_charge_amt=0;

		String existing_reason_code="" ;
		String package_ind,sql1;
		/**************Added for package biling*************starts********************/
		String strpackageseqno = request.getParameter("strpackageseqno");	
		if(strpackageseqno==null) strpackageseqno="";	
		//System.out.println("strpackageseqno in AdhocDisc.jsp:"+strpackageseqno);
		String package_enabled_yn = request.getParameter("package_enabled_yn");	
		if(package_enabled_yn==null) package_enabled_yn="";	
		String pkg_codes_for_disc = request.getParameter("pkg_codes_for_disc");	
		if(pkg_codes_for_disc==null) pkg_codes_for_disc="";
		//System.out.println("v in AdhocDisc.jsp:"+package_enabled_yn);
		/**************Added for package biling*************ends********************/
		String strChargeLogic=""; 
		String bl_items_sl_no = request.getParameter("bl_items_sl_no");
		if (bl_items_sl_no == null) bl_items_sl_no = "";
		
		


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
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

StringBuffer strbuf = new StringBuffer();

//	bl_items_sl_no = "QFSTSI-659,1";
	StringTokenizer str1 = new StringTokenizer(bl_items_sl_no ,";");
	StringTokenizer str = null;
	String strbufquery="";
	String tempValue=null;

	StringBuffer stbuf = new StringBuffer();
	int flag = 0;
	int flagMain = 0;
	
	
	  while (str1.hasMoreElements())
	 {
	 
	   tempValue = 	str1.nextToken();
	    
	   if(tempValue.length()>0)
		{
		str = new StringTokenizer(tempValue,",");	
		if(str.hasMoreElements())
		 {
			if(flagMain == 1) strbuf.append(" OR ");
				strbuf.append("(SEC_KEY_MAIN = '"+str.nextToken()+"'  AND (");
				flagMain = 1;
	  	        flag = 0;	 		  
		while(str.hasMoreElements())
		 {
	 
		if(flag ==1)   strbuf.append(" OR ");       
		  strbuf.append("SEC_KEY_LINE_NO LIKE ('"+str.nextToken()+"%')");
		 flag = 1;
		 }	
		strbuf.append("))");
	 }
		}
	}
	 

	 if(bl_items_sl_no.length()==0)
		  strbufquery="SEC_KEY_MAIN='"+str_doc_no+"'";
	 else 
		 strbufquery=strbuf.toString();
		try
		{
			
			try
			{		
				pstmt = con.prepareStatement( " select nvl(charge_logic_yn,'N') from  bl_parameters where operating_facility_id = '"+str_facility_id+"'");
				ResultSet rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					strChargeLogic  =  rscurr.getString(1);		
				}		
				rscurr.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("3  1="+e.toString());
			}
			
			//Added V180125-Subha/MMS-JU-SCF-0102 try
			try {
					pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
					
					rs = pstmt.executeQuery();	
					if ( rs != null && rs.next())
					{
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
			String query="";
			int column_count = 1;
			if(strChargeLogic.equals("Y"))
				
			{	
				 strsql="Select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,BLNG_SERV_CODE,to_char(SERVICE_DATE,'dd/mm/yyyy HH24:MI:SS'),SUM(ACT_GROSS_AMT),SUM(UPD_GROSS_CHARGE_AMT),SUM(UPD_DISC_AMT),SUM(UPD_NET_CHARGE_AMT),count(TRX_DOC_REF_SEQ_NUM),SUM(ADHOC_DISC_AMT),SERV_ITEM_CODE,DECODE('en','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC,PACKAGE_IND From Bl_Patient_Charges_Folio"
						 	+" where patient_id = ?"
				 			+" and episode_type = ?"
						 	+" AND ( (? IN('O','E') and episode_id = ? and visit_id   = ?)" 
				            +" OR ( ? IN('I','D') and episode_id = ?)" 
							+" OR ? = 'R')" 
							+" AND NVL (billed_flag, 'N') = 'N'";		
				
			}

			else
			{
			 strsql="Select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,BLNG_SERV_CODE,to_char(SERVICE_DATE,'dd/mm/yyyy HH24:MI:SS'),SUM(ACT_GROSS_AMT),SUM(UPD_GROSS_CHARGE_AMT),SUM(UPD_DISC_AMT),SUM(UPD_NET_CHARGE_AMT),count(TRX_DOC_REF_SEQ_NUM),SUM(ADHOC_DISC_AMT),SERV_ITEM_CODE,DECODE('en','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC,PACKAGE_IND From Bl_Patient_Charges_Folio" 
			+" where episode_type = ?" 
			+" and patient_id   = ?"  
			+" and episode_id = NVL(? ,EPISODE_ID)" 
			+" and visit_id   = NVL(? ,VISIT_ID)" 
			+" and nvl(confirmed_yn,'N')='Y'" 
			+" and nvl(billed_flag,'N') != 'Y'" 
			+" and bill_doc_type_code is null" 
			+" and (nvl(package_ind,'X') = 'S' or (nvl(package_trx_ind,'X')='Y' and nvl(package_ind,'X') = 'P') )" 
			+" and nvl(trx_finalize_ind,'N')= 'Y'"  
				//+" and nvl(ins_pkg_pat_ind,'N') != 'K'" commented for package billing  added  next line
			+"  and nvl(package_trx_yn,'N') !='Y'" 
			+" and bill_doc_type_code is null" 
			+" and (nvl(trx_status,'N')<>'C'"  
			+" or ( nvl(trx_status,'N')='C'"  
			+" and ( ( REV_ADJ_TRX_IND in ('R', 'B','A')"  
		    +" and (ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM,ORIG_DOC_REF_SEQ_NUM) in" 
			+" (select trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM"  
            +" from bl_patient_charges_folio where trx_status = 'C'" 
            +" and bill_doc_type_code is not null" 
           // +" and operating_facility_id = '"+str_facility_id+"'" //Commented by MuthuN against 34961
            +" and patient_id = ?"  
            +" AND ( (? IN('O','E') and episode_id = NVL(? ,EPISODE_ID) and visit_id   = NVL(? ,VISIT_ID) )" 
            +" OR ( ? IN('I','D') and episode_id = NVL(? ,EPISODE_ID))" 
			+" OR ? = 'R') ))" 
			+" OR ( (trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM) in" 
			+" ( select ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NUM" 
           	+" from bl_patient_charges_folio"  
            +" where trx_status = 'C' "           		
          //  +" and operating_facility_id = '"+str_facility_id+"' " //Commented by MuthuN against 34961
           	+" and patient_id = ? " 
            +" and ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID))" 
            +" OR(? IN('I','D') and episode_id = NVL(?,EPISODE_ID))" 
            +" OR ? = 'R' )" 
           	+" and bill_doc_type_code is not null" 
           	+" and ORIG_DOC_REF is not null"  
            +" )))))";
				 try{
					 query="Select count(*) cnt From Bl_Patient_Charges_Folio" 
							+" where episode_type = ?" 
							+" and patient_id   = ?"  
							+" and episode_id = NVL(? ,EPISODE_ID)" 
							+" and visit_id   = NVL(? ,VISIT_ID)" 
							+" and nvl(confirmed_yn,'N')='Y'" 
							+" and nvl(billed_flag,'N') != 'Y'" 
							+" and bill_doc_type_code is null" 
							+" and (nvl(package_ind,'X') = 'S' or (nvl(package_trx_ind,'X')='Y' and nvl(package_ind,'X') = 'P') )" 
							+" and nvl(trx_finalize_ind,'N')= 'Y'"  
								//+" and nvl(ins_pkg_pat_ind,'N') != 'K'" commented for package billing  added  next line
							//+"  and nvl(package_trx_yn,'N') !='Y'" 
							+" and bill_doc_type_code is null" 
							+" AND (SETTLEMENT_IND = 'X' "
							+" AND  'Y' in (select ALL_PAYERS_BILL_TOGETHER_YN from BL_PARAMETERS WHERE OPERATING_FACILITY_ID = ?) or  SETTLEMENT_IND <> 'X') "								
							+" and (nvl(trx_status,'N')<>'C'"  
							+" or ( nvl(trx_status,'N')='C'"  
							+" and ( ( REV_ADJ_TRX_IND in ('R', 'B','A')"  
						    +" and (ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM,ORIG_DOC_REF_SEQ_NUM) in" 
							+" (select trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM"  
				            +" from bl_patient_charges_folio where trx_status = 'C'" 
				            +" and bill_doc_type_code is not null" 
				           // +" and operating_facility_id = '"+str_facility_id+"'" //Commented by MuthuN against 34961
				            +" and patient_id = ?"  
				            +" AND ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID) )" 
				            +" OR ( ? IN('I','D') and episode_id = NVL(?,EPISODE_ID))" 
							+" OR ? = 'R') ))" 
							+" OR ( (trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM) in" 
							+" ( select ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NUM" 
				           	+" from bl_patient_charges_folio"  
				            +" where trx_status = 'C' "           		
				          //  +" and operating_facility_id = '"+str_facility_id+"' " //Commented by MuthuN against 34961
				           	+" and patient_id = ? " 
				            +" and ( (? IN('O','E') and episode_id = NVL(? ,EPISODE_ID) and visit_id   = NVL(? ,VISIT_ID))" 
				            +" OR(? IN('I','D') and episode_id = NVL(? ,EPISODE_ID))" 
				            +" OR ? = 'R' )" 
				           	+" and bill_doc_type_code is not null" 
				           	+" and ORIG_DOC_REF is not null"  
				            +" )))))";
							System.err.println("bill_serv_code :"+query);
				 	//stmt2 = con.createStatement();
					
			/* Fixed SQL Injection for Common-ICN-0222 */
				 		column_count = 1;
					 	pstmt = con.prepareStatement(query);
					 	pstmt.setString(column_count, str_episode_type);
					 	pstmt.setString(++column_count, str_patient_id);
					 	pstmt.setString(++column_count, str_episode_id);
					 	pstmt.setString(++column_count, str_visit_id);
					 	pstmt.setString(++column_count, str_facility_id);
					 	pstmt.setString(++column_count, str_patient_id);	
						pstmt.setString(++column_count, str_episode_type);
						pstmt.setString(++column_count, str_episode_id);
						pstmt.setString(++column_count, str_visit_id);
						pstmt.setString(++column_count, str_episode_type);
						pstmt.setString(++column_count, str_episode_id);
						pstmt.setString(++column_count, str_episode_type);
					 	pstmt.setString(++column_count, str_patient_id);
					 	pstmt.setString(++column_count, str_episode_type);
					 	pstmt.setString(++column_count, str_episode_id);
					 	pstmt.setString(++column_count, str_visit_id);
					 	pstmt.setString(++column_count, str_episode_type);
						pstmt.setString(++column_count, str_episode_id);
						pstmt.setString(++column_count, str_episode_type);
	
						rs2 = pstmt.executeQuery() ;
					if( rs2 != null ) 
					{
						while( rs2.next() )
						{
							cnt = rs2.getInt(1);
						}			
					}
				 }	
				catch(Exception e)
				{
					System.out.println("error in date" +e);
				}
				 finally{
					 rs2.close();
					 pstmt.close();
				 }
			}
			if(str_module_id.equals("PH") || str_module_id.equals("ST"))
			{
				strsql = strsql	+ " and (TRX_DOC_REF,TRX_DOC_REF_LINE_NUM) in (select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM from bl_patient_charges_interface where "+ strbufquery+")";
			}
			strsql=strsql+" GROUP BY TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,SERV_ITEM_CODE,DECODE('en','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)),BLNG_SERV_CODE,to_char(SERVICE_DATE,'dd/mm/yyyy HH24:MI:SS'),PACKAGE_IND";
			

			//stmt = con.createStatement();
			System.err.println("BLAdhocDISC ############### strSQL "+strsql);
			column_count = 1;
			pstmt = con.prepareStatement(strsql);	
			//pstmt.setString(column_count, locale);
			if(strChargeLogic.equals("Y"))	
			{	
				pstmt.setString(column_count, str_patient_id);	
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_visit_id);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_episode_type);
			}else{	
				pstmt.setString(column_count, str_episode_type);
				pstmt.setString(++column_count, str_patient_id);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_visit_id);
				pstmt.setString(++column_count, str_patient_id);	
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_visit_id);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_patient_id);	
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_visit_id);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_episode_type);
				
			}
			//pstmt.setString(++column_count, locale);
			
			rs = pstmt.executeQuery();
			if( rs != null ) 
			{
				while( rs.next() )
				{  

					trx_doc_ref = rs.getString(1);
					if(trx_doc_ref == null) trx_doc_ref="";
					trx_doc_ref_line_num = rs.getString(2);
					if(trx_doc_ref_line_num == null) trx_doc_ref_line_num="";
					blng_serv_code = rs.getString(3);
					if(blng_serv_code == null) blng_serv_code="";
					blng_serv_date = rs.getString(4);
					if(blng_serv_date == null) blng_serv_date="";

					if(!locale.equals("en"))
					{
						if(!blng_serv_date.equals(""))
							blng_serv_date=com.ehis.util.DateUtils.convertDate(blng_serv_date,"DMYHMS","en",locale);
					}
					
					act_gross_amt = rs.getString(5);
					if(act_gross_amt == null) act_gross_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						act_gross_amt = cf1.formatCurrency(act_gross_amt, noofdecimal);
					} else {
						act_gross_amt = BLReportIdMapper.truncateUptoTwoDecimal(act_gross_amt, noofdecimal);
					}
					v_act_gross_amt = Double.parseDouble(act_gross_amt);

					upd_gross_charge_amt = rs.getString(6);
					if(upd_gross_charge_amt == null) upd_gross_charge_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_gross_charge_amt = cf1.formatCurrency(upd_gross_charge_amt, noofdecimal);
					} else {
						upd_gross_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_gross_charge_amt, noofdecimal);
					}
					v_upd_gross_charge_amt = Double.parseDouble(upd_gross_charge_amt);
					v_tot_upd_gross_charge_amt = v_tot_upd_gross_charge_amt+v_upd_gross_charge_amt;

					upd_disc_amt = rs.getString(7);
					if(upd_disc_amt == null) upd_disc_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_disc_amt = cf1.formatCurrency(upd_disc_amt, noofdecimal);
					}else {
						upd_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_disc_amt, noofdecimal);
					}
					v_upd_disc_amt = Double.parseDouble(upd_disc_amt);
					v_tot_upd_disc_amt = v_tot_upd_disc_amt+v_upd_disc_amt;

					upd_net_charge_amt = rs.getString(8);
					if(upd_net_charge_amt == null) upd_net_charge_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_net_charge_amt = cf1.formatCurrency(upd_net_charge_amt, noofdecimal);
					} else {
						upd_net_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_net_charge_amt, noofdecimal);
					}
					v_upd_net_charge_amt = Double.parseDouble(upd_net_charge_amt);
					v_tot_upd_net_charge_amt = v_tot_upd_net_charge_amt+v_upd_net_charge_amt;

					String trx_doc_ref_seq_num_count = rs.getString(9);
//					System.err.println("trx_doc_ref_seq_num_count:"+trx_doc_ref_seq_num_count);

					adhoc_disc_amt = rs.getString(10);
					if(adhoc_disc_amt == null) adhoc_disc_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						adhoc_disc_amt = cf1.formatCurrency(adhoc_disc_amt, noofdecimal);
					} else {
						adhoc_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(adhoc_disc_amt, noofdecimal);
					}
					double db_adhoc_disc_amt=Double.parseDouble(adhoc_disc_amt);

					serv_item_code = rs.getString(11);
					if(serv_item_code == null) serv_item_code="";

					serv_item_desc = rs.getString(12);
					if(serv_item_desc == null) serv_item_desc="&nbsp;";
					
					package_ind =  rs.getString(13);
					if(package_ind == null) package_ind="";
					
					
//					System.err.println("trx_doc_ref @@" +trx_doc_ref);
//					System.err.println("trx_doc_ref_line_num @@" +trx_doc_ref_line_num);
//					System.err.println("blng_serv_code @@" +blng_serv_code);
//					System.err.println("blng_serv_date @@" +blng_serv_date);

//					System.err.println("serv_item_code @@" +serv_item_code);
//					System.err.println("serv_item_desc @@" +serv_item_desc);


					if(blng_serv_code==null) blng_serv_code="";
					
					
					
					
				
					

				 	try
					{
				 		if(package_ind.equals("P"))
				 			sql1= " select SHORT_DESC from bl_package_lang_vw where PACKAGE_CODE=? and LANGUAGE_ID =? ";
				 			
				 		else
							sql1= " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE=? and LANGUAGE_ID =? ";
						
						
					System.err.println(" BLAdhocDisc  service desctiption strsql sql1 "+sql1);
						/* stmt1 = con.createStatement();
						rs1 = stmt1.executeQuery(sql1);	 */
						pstmt = con.prepareStatement(sql1);
						pstmt.setString(1, blng_serv_code);
						pstmt.setString(2, locale);
						rs1 = pstmt.executeQuery();
		
						while(rs1.next())
						{
						   serv_desc  =  rs1.getString(1);	
//						   System.err.println("serv_desc :"+serv_desc);
						}	
						rs1.close();
						pstmt.close();
					}
					catch(Exception e)
					{
						System.err.println("1="+e.toString());
					}
		
					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
  if(package_ind.equals("P")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(serv_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
} else { 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(serv_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
 } 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(blng_serv_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(serv_item_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(serv_item_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(blng_serv_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(upd_gross_charge_amt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(upd_disc_amt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(upd_disc_amt));
            _bw.write(_wl_block41Bytes, _wl_block41);


/* Code added by Karthik to fetch billing group id for null cases - Starts */
String qry_for_blng_grp="";

if(str_blng_grp_id.equals("")){
	
	if( str_episode_type.equals("I") ||  str_episode_type.equals("D") ){
		qry_for_blng_grp="select BLNG_GRP_ID from BL_EPISODE_FIN_DTLS where OPERATING_FACILITY_ID= ? and EPISODE_ID= ? and  PATIENT_ID= ?  ";
	}	else if( str_episode_type.equals("O") ||  str_episode_type.equals("E") ){
		qry_for_blng_grp="select BLNG_GRP_ID from BL_VISIT_FIN_DTLS   where  OPERATING_FACILITY_ID= ? and EPISODE_ID= ? and visit_id= ? and  PATIENT_ID= ? ";
	}	else{ //if str_episode_type.equals("R")
		qry_for_blng_grp="select BLNG_GRP_ID from BL_PATIENT_FIN_DTLS where PATIENT_ID= ? ";
	}
	
//	System.out.println("blng grp fetch qry: "+qry_for_blng_grp);
	
	try
	{		
		pstmt=con.prepareStatement(qry_for_blng_grp);
		column_count = 1;
		if( str_episode_type.equals("I") ||  str_episode_type.equals("D") ){
			pstmt.setString(column_count,str_facility_id);	
			pstmt.setString(++column_count,str_episode_id);
			pstmt.setString(++column_count,str_patient_id);
		} else if( str_episode_type.equals("O") ||  str_episode_type.equals("E") ){
			pstmt.setString(column_count,str_facility_id);
			pstmt.setString(++column_count,str_episode_id);
			pstmt.setString(++column_count,str_visit_id);
			pstmt.setString(++column_count,str_patient_id);
		}else{			//if str_episode_type.equals("R")					
			pstmt.setString(column_count,str_patient_id);
		}
		rss = pstmt.executeQuery();
		if (rss!=null)
		{
			if (rss.next())
			{
				str_blng_grp_id = rss.getString(1);
				if(str_blng_grp_id==null) str_blng_grp_id="";
			}
		}
		if (rss != null)   rss.close();
		if (pstmt != null)   pstmt.close();
	}
	catch(Exception e)
	{
		System.out.println("error while fetching blng_grp_id" +e);
	}
	
}


/*Code added by Karthik to disable link when max discount percentage or max discount amount is null - Starts*/
	String currdate="";
	String str_serv_max_disc_per="";
	String str_serv_max_disc_amt = "";
	String settlement_ind="";
	
			try
			{		
				String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
				pstmt=con.prepareStatement(query_date);
				rss = pstmt.executeQuery();
				if (rss!=null)
				{
					if (rss.next())
					{
						currdate = rss.getString(1);
					}
				}
				if (rss != null)   rss.close();
				if (pstmt != null)   pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("error in date" +e);
			}
			try	{
				//	System.out.println(" $$$$$ "+str_facility_id+"~"+blng_serv_code+"~"+strloggeduser+"~"+currdate+"~"+serv_item_code);
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
					
					if(call!=null)
					call.close();	

				}
			catch(Exception e)
			{
				System.out.println("error in date" +e);
			}

			try
			{		
				String query_slmt_ind="select SETTLEMENT_IND from bl_blng_grp where blng_grp_id= ? ";
				pstmt=con.prepareStatement(query_slmt_ind);
				pstmt.setString(1, str_blng_grp_id);
				rss = pstmt.executeQuery();
				if (rss!=null)
				{
					if (rss.next())
					{
						settlement_ind = rss.getString(1);
					}
				}
				if (rss != null)   rss.close();
				if (pstmt != null)   pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("error in date" +e);
			}
			
/*			System.out.println("$$$$$ in str_serv_max_disc_per:"+str_serv_max_disc_per);
			System.out.println("$$$$$ in str_serv_max_disc_amt:"+str_serv_max_disc_amt);
			System.out.println("$$$$$ in blng_grp_id:"+str_blng_grp_id);			
			System.out.println("$$$$$ in settlement_ind:"+settlement_ind);
			System.out.println("$$$$$ in v_upd_gross_charge_amt!=0 :"+v_upd_gross_charge_amt);
			System.out.println("$$$$$ in db_adhoc_disc_amt :"+db_adhoc_disc_amt);
			System.out.println("$$$$$ in v_upd_disc_amt :"+v_upd_disc_amt);
			*/

/*Code added by Karthik to disable link when max discount percentage or max discount amount is null - Ends*/

			if(db_adhoc_disc_amt == v_upd_disc_amt && v_upd_gross_charge_amt != 0 && (!str_serv_max_disc_per.equals("") || !str_serv_max_disc_amt.equals("")) && (settlement_ind.equalsIgnoreCase("C") ||settlement_ind.equalsIgnoreCase("X")) )
			{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(upd_disc_amt));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(upd_disc_amt));
            _bw.write(_wl_block41Bytes, _wl_block41);

			}
			else
			{

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(upd_disc_amt));
            _bw.write(_wl_block47Bytes, _wl_block47);

			}

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(upd_net_charge_amt));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(trx_doc_ref_line_num));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(trx_doc_ref));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(act_gross_amt));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(trx_doc_ref_seq_num_count));
            _bw.write(_wl_block62Bytes, _wl_block62);
			
//					System.err.println("bill_serv_code :"+blng_serv_code);
//					System.err.println("blng_grp_id :"+blng_grp_id);
//					System.err.println("policy_type_code :"+policy_type_code);
//					System.err.println("upd_disc_amt :"+upd_disc_amt);
//					System.err.println("act_gross_amt :"+act_gross_amt);	
					i++;
				}//while		
			}//rs 
		}
		catch(Exception e)
		{
			System.err.println("Exception in main qry :"+e);
		}
		finally{	
			if(pstmt != null) pstmt.close();
			if(rs!=null) rs.close();
		}

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(str_patient_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(str_episode_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_visit_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(str_encounter_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(str_function_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(str_module_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(str_clinic_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(str_visit_type_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(str_blng_grp_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(existing_reason_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(str_doc_no));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(str_store_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(p_slmt_reqd_yn));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strclientip));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(strclientip));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(v_tot_upd_gross_charge_amt));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(v_tot_upd_disc_amt));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(v_tot_upd_net_charge_amt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(called_for_reg_chg));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strpackageseqno));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(package_enabled_yn));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(pkg_codes_for_disc));
            _bw.write(_wl_block92Bytes, _wl_block92);

	System.out.println("strChargeLogic-->"+strChargeLogic+"i-->"+i+"cnt-->"+cnt);
if(strChargeLogic.equals("N")&& i==0 && cnt >0)
		{
		if(("Y").equals(pkgDepAdjAppl)){

            _bw.write(_wl_block93Bytes, _wl_block93);

		}
		}
		else{
			if(i==0 ){
				
            _bw.write(_wl_block94Bytes, _wl_block94);

			}
		}

            _bw.write(_wl_block95Bytes, _wl_block95);

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

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_DATE.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISCOUNT_AMT.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NetAmount.label", java.lang.String .class,"key"));
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
}
