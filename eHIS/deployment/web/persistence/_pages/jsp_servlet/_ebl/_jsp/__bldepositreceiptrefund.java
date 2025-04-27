package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __bldepositreceiptrefund extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLDepositReceiptRefund.jsp", 1738044675269L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<!-- \nSr No        Version          TFS/Incident        SCF/CRF            \t\t    \tDeveloper Name\n--------------------------------------------------------------------------------------------------------\n1\t\t\t V220801\t\t\t34745\t\tBL-Deposit Receipt/Refund-Encounter\t    Mohanapriya\n--------------------------------------------------------------------------------------------------------\n-->\n\n<script language=\"javascript\" src=\"../../eBL/js/BLDepositReceipt.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\n\n\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\n <script>\n\nfunction trimString(sInString)\n{\n  sInString = sInString.replace( /^\\s+/g, \"\" );// strip leading\n  return sInString.replace( /\\s+$/g, \"\" );// strip trailing\n}\n\nfunction cancel()\n\t{\t\t\n\t\tvar function_id=parent.frames[1].document.forms[0].function_id.value;\n\t\tvar deposit_man_yn=parent.frames[1].document.forms[0].deposit_man_yn.value;\n\t\tvar packseqno=parent.frames[1].document.forms[0].packseqno.value;\t\t\n\t\tvar pkgCode=parent.frames[1].document.forms[0].pkgCode.value;\t\t\t\n\t\tvar min_dep_amt_man   = parent.frames[1].document.forms[0].min_dep_amt_man.value;\t\n\t\t var stlmt_amount   = parent.frames[1].document.forms[0].stlmt_amount.value;\t\t \n\t\t var tot_package_amt   = parent.frames[1].document.forms[0].d_tot_package_amt.value;\t\n\t\t var called_from_mode    = parent.frames[1].document.forms[0].funct_mode.value;\n\t\t var total_settled_amt    = parent.frames[3].document.forms[0].total_settled_amt.value;\t\t \t\n\t\t var total_records    = parent.frames[2].document.forms[0].total_records.value;\t\t\t\t\n\t\tvar confirm_check = false;\t\t\n\t\tif(function_id==\"PKG_BILLING\" )//&& deposit_man_yn==\"Y\")\n\t\t{\t\n\t\t\tif(total_records>0)\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t//confirm_check = confirm(\"Deposit is mandatory, Do you want to Cancel the Subscription\");\n\t\t\t//Added Logic for MMS-DM-SCF-0013\n\n\t\t\tvar ignoreMandValidationDtl = parent.frames[1].document.forms[0].ignoreMandValidationDtl.value;\n\t\t\t//This variable is from this page\n\t\t\tvar ignoreMandValidation = document.forms[0].ignoreMandValidation.value;\n\t\t\tvar minMandAmtFinal = document.forms[0].totMinDeposit.value;\n\t\t\tvar minMandAmtDtl = parent.frames[1].document.forms[0].totMinDepositDtl.value;\n\t\t\tvar derivedFromDtl = parent.frames[1].document.forms[0].derivedFromDtl.value;\n\t\t\t//In Details page if value is Y then override this page value\n\t\t\tif(derivedFromDtl == \'Y\'){\n\t\t\t\tminMandAmtFinal = minMandAmtDtl;\n\t\t\t}\n\t\t\t\n\t\t\tmin_dep_amt_man = parseFloat(min_dep_amt_man) - parseFloat(minMandAmtFinal);\n\t\t\t//Added Logic for MMS-DM-SCF-0013\n\n\t\tif(parseFloat(total_settled_amt)  < parseFloat(min_dep_amt_man)){\t\t\t\t\t\t\n\t\t\tconfirm_check = confirm(getMessage(\"BL8659\",\"BL\"));\n\t\t\t//confirm_check = confirm(\"Minimum Deposit Collection is mandatory, Do you want to Cancel the Subscription\");\n\t\t\tif(confirm_check){\t\t\t\t\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr+= \"packseqno=\\\"\" + packseqno + \"\\\" \" ;\t\t\t\t\t\n\t\t\t\t\txmlStr+= \"pkgCode=\\\"\" + pkgCode + \"\\\" \" ;\t\t\t\t\t\n\t\t\t\t\txmlStr+= \"called_from_mode=\\\"\" + called_from_mode + \"\\\" \" ;\t\t\t\t\t\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\tvar temp_jsp=\"PkgSubscriptionValidation.jsp?func_mode=REM_PKG_SUBS&function_id=\"+function_id;\t\t\t\t\t\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar responseText=trimString(xmlHttp.responseText) ;\n\t\t\t\t\t//eval(responseText);\n\t\t\t\t\t//Added Logic for MMS-DM-SCF-0013\n\t\t\t\t\tif(responseText == \"\"){\n\t\t\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\t\t    dialogBody.contentWindow.returnValue = \"C\";\n\t\t\t\t\t    \n\t\t\t\t\t    \n\t\t\t\t\t\t//window.parent.returnValue=\"C\";\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t//window.parent.returnValue=\"N\";\n\t\t\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\t\t    dialogBody.contentWindow.returnValue = \"N\";\n\t\t\t\t\t}\n\t\t\t\t\t//Added Logic for MMS-DM-SCF-0013\n\t\t\t\t\t\n\t\t\t\t\t//parent.window.close();\n\t\t\t\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t\t\t    dialogTag.close();\n\t\t\t}else{\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}else{\t\t\t\t\n\t\t\t//window.parent.returnValue=\"Y\";\n\t\t\t//parent.window.close();\n\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t    dialogBody.contentWindow.returnValue = \"Y\";\n\t\t    \n\t\t    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t    dialogTag.close();\n\t\t}\n\t\t}else{\t\n\t\t\tif(function_id==\"PKG_BILLING\" )//&& deposit_man_yn==\"N\")\n\t\t\t{\t\t\t\t\t\n\t\t\t\t//window.parent.returnValue=\"Y\";\n\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t    dialogBody.contentWindow.returnValue = \"Y\";\n\t\t\t}\n\t\t\t//parent.window.close();\n\t\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t    dialogTag.close();\n\t\t}\n\t\t\n\t}\n\tfunction funSubmit()\n\t\n\t{\n\t\t\n\t\t\tvar ref=parent.frames[1].document.forms[0].recpt_refund_ind.value;\n\t\t//alert(ref);\n\t\tvar v_ext_acc_interface_yn=parent.frames[1].document.forms[0].ext_acc_int_YN.value;\n\t\t//alert(v_ext_acc_interface_yn);\t\t\n\t/*\tvar rec_typ=parent.frames[1].document.forms[0].receipt_type_code.value;\n\t\talert(\'receipt type:\'+rec_typ);\n\t\tvar ccode=parent.frames[1].document.forms[0].customer_code.value;\n\t\talert(\'ccode:\'+ccode);\n\t\tvar recnat=parent.frames[1].document.forms[0].receipt_nature_code.value;\n\t\talert(\'nature:\'+recnat);\n\t\tvar epitype=parent.frames[1].document.forms[0].episode_typ.value;\n\t\talert(\'episode:\'+epitype);\n\t\tvar remarks=parent.frames[1].document.forms[0].remarks.value;\n\t\talert(\'remarks:\'+remarks);\n\t\tvar docno=parent.frames[1].document.forms[0].doc_number.value;\n\t\talert(\'docno:\'+docno);\n\t\tvar amt=parent.frames[1].document.forms[0].stlmt_amount.value;\n\t\talert(\'amt:\'+amt);\n\t\tvar ref=parent.frames[1].document.forms[0].reference.value;\n\t\talert(\'ref:\'+ref);\n\t\tvar actcode=parent.frames[1].document.forms[0].ext_acc_code.value;\n\t\talert(\'actcode:\'+actcode);\n\t\tvar dept=parent.frames[1].document.forms[0].dept_desc.value;\n\t\talert(\'dept:\'+dept);\n\t\tvar deptype=parent.frames[1].document.forms[0].dep_type.value;\n\t\talert(\'deptype:\'+deptype);\n\t\t*/\t\n\t\t\tif (parent.frames[1].document.getElementById(\'DownTimeEntry\').checked)\n\t\t\t{\n\t\t\t\t\n\t\t\t\tparent.frames[1].document.getElementById(\'tdentry\').value=\'Y\';\t\t\n\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].doc_type_number.value==\"\") \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\talert(getMessage(\"BL1514\",\"BL\"));\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].document_number.value==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(getMessage(\"BL1515\",\"BL\"));\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].deposit_date.value==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(getMessage(\"BL1516\",\"BL\"));\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].deposit_reason.value==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(getMessage(\"BL1517\",\"BL\"));\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\t\t\n\t\t }\n\t\t\telse\n\t\t\t\t{\n\t\t\t\t\n\t\t\t\tparent.frames[1].document.getElementById(\'tdentry\').value=\'N\';\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\t\t\n\t\tif(parent.frames[1].document.forms[0].receipt_type_code.value==\"\") \n\t\t{\n\t\t\t\n\t\t\talert(getMessage(\"BL9524\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t\t\n\t\t\n\t\tif(parent.frames[1].document.forms[0].remarks.value==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL1357\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t\n\t\n\t\t\t\n\t\t\n\t\t\n\t\t\n\t\tvar dep=parent.frames[1].document.forms[0].dep_type.value;\n\t\t\n\n\t\tvar dep=parent.frames[1].document.forms[0].dep_type.value;\n\t\t\n\t\t\tif(parent.frames[1].document.forms[0].dep_type.value==\"S\"  && parent.frames[1].document.forms[0].reference.value==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL00300\",\"BL\"));\n\t\t\t\n\t\t\treturn;\n\t\t}\n\n\t\tif(parent.frames[1].document.forms[0].dep_type.value==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL7290\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t\t\n\t\t\n\t\tif (parent.frames[1].document.getElementById(\"receipt_nature_code\").value==\"CU\")\n\t\t{\n\n\n\t\t\tif(parent.frames[1].document.forms[0].customer_code.value==\"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9102\",\"BL\"));\n\t\t\t\treturn;\n\t\t\t}\n\t\t\t\n\t\t\n\t\t}\n\t//\talert(\"397\");\n\t\tif (parent.frames[1].document.getElementById(\"cusid\").value==\"SHALM\" || parent.frames[1].document.getElementById(\"cusid\").value==\"MOHBR\")\n\t\t{\n//\t\t\talert(\"400\");\n\t\tvar\tv_external_acc=parent.frames[1].document.forms[0].ext_acc_code.value;\n\t\tvar\tv_dept_code=parent.frames[1].document.forms[0].dept_desc.value;\t\n\t\t\t\n\t\t\tif ( v_external_acc == \"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9525\",\"BL\"));\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tif ( v_dept_code == \"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9526\",\"BL\"));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t\n\t\t\n\t\tif(parent.frames[1].document.forms[0].stlmt_amount.value==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t\t\n\t\tif(parent.frames[2].document.forms[0].total_records.value==0)\n\t\t{\n\t\t\talert(getMessage(\"BL6288\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t\tvar stlmt_amount = parent.frames[1].document.forms[0].stlmt_amount.value;\n\t\tvar total_settled_amt = parent.frames[3].document.forms[0].total_settled_amt.value;\n\n\t\tif(parseFloat(stlmt_amount)!= parseFloat(total_settled_amt))\n\t\t{\n\t\t\talert(getMessage(\"BL9782\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t\t\n\t\n\t\tif(parent.frames[1].document.forms[0].reqcheck.value ==\"Y\" && parent.frames[1].document.forms[0].reqid.value==\"\") \t\t\t\n\t\t{\t\t\n\t\t\talert(getMessage(\"BL1535\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t\t\n\t\t\n\t\t\n\t\n/*********************END********************************/\n\t\tvar splAgnDepChkYN=parent.frames[1].document.forms[0].splAgnDepChkYN.value;\n\t\t//alert(\"splAgnDepChkYN \"+splAgnDepChkYN);\n\n\t\tif(splAgnDepChkYN == \'Y\'){\n\t\t\tvar splAgnEffFromObj=parent.frames[1].document.forms[0].splAgnEffFrom;\n\t\t\tvar splAgnEffToObj=parent.frames[1].document.forms[0].splAgnEffTo;\n\t\t\t\n\t\t\tif(splAgnEffFromObj==undefined || splAgnEffToObj==undefined ){\n\t\t\t\talert(\"spl agency details must be entered\");\n\t\t\t\treturn;\n\t\t\t}\n\t\t\telse{\n\t\t\t\tif((splAgnEffFromObj.value ==\'\' || splAgnEffFromObj.value == \'undefined\') && (splAgnEffToObj.value ==\'\' || splAgnEffToObj.value == \'undefined\')){\n\t\t\t\t\talert(\"spl agency details must be entered\");\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tparent.frames[2].document.forms[0].splAgnDpstYN.value=parent.frames[1].document.forms[0].splAgnDepChkYN.value;\t\t\n\t\t\t\t\tparent.frames[2].document.forms[0].splAgnDepEffFrom.value=splAgnEffFromObj.value;\n\t\t\t\t\tparent.frames[2].document.forms[0].splAgnDepEffTo.value=splAgnEffToObj.value;\n\t\t\t\t\t//alert(\"splAgnDepEffFrom \"+parent.frames[2].document.forms[0].splAgnDepEffFrom.value);\n\t\t\t\t\t//alert(\"splAgnDepEffTo \"+parent.frames[2].document.forms[0].splAgnDepEffTo.value);\n\t\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t}\n\t\t\n\t\tparent.frames[2].document.forms[0].rcpt_rfnd_ind.value=parent.frames[1].document.forms[0].recpt_refund_ind.value;\n\t\t//alert(\'recref:\'+parent.frames[2].document.forms[0].rcpt_rfnd_ind.value);\n\t\tparent.frames[2].document.forms[0].rcpt_nature_code.value=parent.frames[1].document.forms[0].receipt_nature_code.value;\n\t\t//alert(\'nature:\'+parent.frames[2].document.forms[0].rcpt_nature_code.value);\n\t\t//\talert(parent.frames[1].document.forms[0].receipt_code.value);\t\n\t\tparent.frames[2].document.forms[0].rcpt_type_code.value=parent.frames[1].document.forms[0].receipt_type_code.value;\t\n\t\t//alert(\'rectype:\'+parent.frames[2].document.forms[0].rcpt_type_code.value);\n\t\tparent.frames[2].document.forms[0].shift_id.value=parent.frames[1].document.forms[0].shift_id.value;\t\t\n\t\t//alert(\'shift:\'+parent.frames[2].document.forms[0].shift_id.value);\n\t\tparent.frames[2].document.forms[0].cash_counter_code.value=parent.frames[1].document.forms[0].cash_counter_code.value;\n\t\t//a";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="lert(\'cahscounter:\'+parent.frames[2].document.forms[0].cash_counter_code.value);\n\t\tparent.frames[2].document.forms[0].doc_amt.value =parent.frames[1].document.forms[0].stlmt_amount.value;\t\n\t\tparent.frames[2].document.forms[0].refnumber.value =parent.frames[1].document.forms[0].reference.value;\t\n\t\t//alert(\'refnumber:\'+parent.frames[2].document.forms[0].refnumber.value )\n\t\t//alert(\'amt:\'+parent.frames[2].document.forms[0].doc_amt.value);\n\t\tparent.frames[2].document.forms[0].episode_type.value =parent.frames[1].document.forms[0].episode_type.value;\n\t\t//alert(\'epi:\'+parent.frames[2].document.forms[0].episode_type.value);\n\t\tparent.frames[2].document.forms[0].episode_id.value=parent.frames[1].document.forms[0].episode_id.value;\n\t//\talert(\'episode_id:\'+parent.frames[2].document.forms[0].episode_id.value);\t\n\t\tparent.frames[2].document.forms[0].visit_id.value=parent.frames[1].document.forms[0].visit_id.value;\n\t\t//alert(\'visit:\'+parent.frames[2].document.forms[0].visit_id.value);\t\n\t\tparent.frames[2].document.forms[0].encounter_id.value=parent.frames[1].document.forms[0].encounter_id.value;\n\t\t//alert(\'encounter_id:\'+parent.frames[2].document.forms[0].encounter_id.value);\t\n\t\tparent.frames[2].document.forms[0].customercode.value =parent.frames[1].document.forms[0].customer_code.value;\n\t\t//alert(\'ccode:\'+parent.frames[2].document.forms[0].customercode.value);\n\t\tparent.frames[2].document.forms[0].narration.value =parent.frames[1].document.forms[0].remarks.value;\n\t\t//alert(\'remarks:\'+parent.frames[2].document.forms[0].remark.value);\n\t\tparent.frames[2].document.forms[0].origdocnumber.value =parent.frames[1].document.forms[0].doc_number.value;\n\t\t//alert(\'docno:\'+parent.frames[2].document.forms[0].origdocnumber.value);\n\t\tparent.frames[2].document.forms[0].ref.value =parent.frames[1].document.forms[0].reference.value;\n\t\t//alert(\'ref:\'+parent.frames[2].document.forms[0].ref.value);\n\t\tparent.frames[2].document.forms[0].totalbill.value =parent.frames[1].document.forms[0].totalbillamt.value;\n\t\t//alert(\'totalamt:\'+parent.frames[2].document.forms[0].totalbill.value);\n\t\tparent.frames[2].document.forms[0].billpaid.value =parent.frames[1].document.forms[0].billpaidamt.value;\n\t\t//alert(\'billpaid:\'+parent.frames[2].document.forms[0].billpaid.value);\n\t\tparent.frames[2].document.forms[0].ext_acc_code.value =parent.frames[1].document.forms[0].ext_acc_code.value;\n\t\t//alert(\'actcode:\'+parent.frames[2].document.forms[0].ext_acc_code.value);\n\t\tparent.frames[2].document.forms[0].ext_acc_dept_code.value =parent.frames[1].document.forms[0].dept_desc.value;\n\t\t//alert(\'dept:\'+parent.frames[2].document.forms[0].ext_acc_dept_code.value);\n\t\tparent.frames[2].document.forms[0].ip_adm_trf_dep_ind.value=parent.frames[1].document.forms[0].dep_type.value;\t\n\t\t//alert(\'deptype:\'+parent.frames[2].document.forms[0].ip_adm_trf_dep_ind.value);\n\t\tparent.frames[2].document.forms[0].downtime_doc_type_code.value=parent.frames[1].document.forms[0].doc_type_number.value;\n\t\t//alert(\'downtime doc code::\'+parent.frames[2].document.forms[0].downtime_doc_type_code.value);\n\t\tparent.frames[2].document.forms[0].downtime_doc_num.value=parent.frames[1].document.forms[0].document_number.value;\t\n\t\t//alert(\'doc num::\'+parent.frames[2].document.forms[0].downtime_doc_num.value);\n\t\tparent.frames[2].document.forms[0].downtime_doc_date.value=parent.frames[1].document.forms[0].deposit_date.value;\t\n\t\t//alert(\'doc date::\'+parent.frames[2].document.forms[0].downtime_doc_date.value);\n\t\tparent.frames[2].document.forms[0].downtime_reason_code.value=parent.frames[1].document.forms[0].deposit_reason.value;\n\t\t//alert(\'reason::\'+parent.frames[2].document.forms[0].downtime_reason_code.value);\n\t\tparent.frames[2].document.forms[0].request_id.value=parent.frames[1].document.forms[0].reqid.value;\t\n\t\t//alert(\'request_id::\'+parent.frames[2].document.forms[0].request_id.value);\n\t\tparent.frames[2].document.forms[0].total_settled_amt.value=parent.frames[3].document.forms[0].total_settled_amt.value;\n\t\t//alert(\'total=\'+parent.frames[2].document.forms[0].total_settled_amt.value);\n\t\tparent.frames[2].document.forms[0].downtime_entry_yn.value=parent.frames[1].document.forms[0].tdentry.value;\n\t\t//alert(\'downtime:\'+parent.frames[2].document.forms[0].downtime_entry_yn.value);\n\t\tparent.frames[2].document.forms[0].orgdoctype.value=parent.frames[1].document.forms[0].doc_number.value;\n\t\tparent.frames[2].document.forms[0].orgdocnumber.value=parent.frames[1].document.forms[0].doc_num.value;\n\t\tparent.frames[2].document.forms[0].orgdocsrno.value=parent.frames[1].document.forms[0].documnumber.value;\n\t\t\n\t\tparent.frames[2].document.forms[0].rec_ref_format_ind.value =\"\";\t\n\t\tparent.frames[2].document.forms[0].rfnd_dep_in_use_yn.value\t=\"\";\n\n\t\tvar t_mail=eval(\"parent.frames[1].document.forms[0].thru_mail\");\n\t\tif(t_mail.checked)\n\t\t{\n\t\t\tparent.frames[2].document.forms[0].pmnt_thru_mail.value\t=\"Y\";\n\t\t}\n\t\telse{\n\t\t\tparent.frames[2].document.forms[0].pmnt_thru_mail.value\t=\"N\";\t\t\t\t\t\n\t\t}\n\t\t\n\t\t\n\t\tparent.frames[2].document.forms[0].mult_slmt_yn.value=\"\" ;\n\t\t//parent.frames[2].document.forms[0].downtime_entry_yn.value=\"\";\n\t\t//parent.frames[2].document.forms[0].downtime_doc_type_code.value=\"\";\n\t\t//parent.frames[2].document.forms[0].downtime_doc_num.value=\"\";\n\t\t//parent.frames[2].document.forms[0].downtime_doc_date.value=\"\";\n\t\tparent.frames[2].document.forms[0].cc_machine_id.value=\"\";\n\t\tparent.frames[2].document.forms[0].payers_add1.value=\"\";\n\t\tparent.frames[2].document.forms[0].payers_add2.value=\"\"\t;\n\t\tparent.frames[2].document.forms[0].payers_add3.value=\"\";\n\t\tparent.frames[2].document.forms[0].currdate.value=\"";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\tparent.frames[2].document.forms[0].str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\tparent.frames[2].document.forms[0].hand_without_counter_chk_out.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t/*************ADDED FOR PAKAGE BILLING**************************/\n\t\t/*if(function_id==\"PKG_BILLING\"){\n\t\tvar pkgSeqNo=parent.frames[1].document.forms[0].pkgSeqNo.value\t\t\t\n\t\tparent.frames[2].document.forms[0].pkgSeqNo.value=parent.frames[1].document.forms[0].pkgSeqNo.value;\n\t}*/\n\t/*************ENDS**************************/\n\n\t\tparent.frames[2].document.forms[0].payers_tel_num.value\t=\"\";\n\t\tparent.frames[2].document.forms[0].consolidated_receipt_yn.value=\"\";\n\t\tparent.frames[2].document.forms[0].patient_id.value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\t\n\t\t/*   $.ajax({ \n               //url:\"../../eBL/jsp/BLBillSlmtAllServicesSubmit.jsp?episode_type=\"+episode_type+\"&slmt_amt=\"+slmt_amt,\n               url:\"../../servlet/eBL.BLDepositRecRefundServlet,\n               type:\'post\',\n               data: $(\"#BillSlmtTypeForm\",window.parent.frames[2].document).serialize(),\n               success: function(data) {   \n                           //var obj = jQuery.parseJSON(data);\n                           var obj =data;\n               }\n\t\t   });*/\n\t\t//document.forms[0].record_button.disabled = true;\n\t\t   var episode_type=parent.frames[2].document.forms[0].episode_type.value;\n\t\t   var rec_ref=parent.frames[2].document.forms[0].rcpt_rfnd_ind.value;\n\t\t   \n\t\t   if(rec_ref==\"F\")\n\t\t\t   {\n\t\t\t   \n\t\t\t   rec_ref=\"REFUND\";\n\t\t\t   }\n\t\t   else\n\t\t\t   {\n\t\t\t   rec_ref=\"RECEIPT\";\n\t\t\t   }\n\t\t   \n\t\t  // alert(\"episode_type/rec_ref\"+episode_type+\",\"+rec_ref);\n\t\t    $.ajax({\n\t\t        url:\"../../eBL/jsp/BLCashCounterReceiptRefundValidation.jsp\",\n\t\t        type:\'post\',\n\t\t        data: {\n\t\t              episodeType:episode_type, // \"I\",\"O\",\"D\",\"E\"..\n\t\t              receiptRefundIndicator:rec_ref  // \"REFUND\" , \"RECEIPT\"\n\t\t          },\n\t\t        success: function(data) {\n\t\t           var obj = jQuery.parseJSON(data);\n\t\t            \n\t\t            if((obj.flag)!=\'N\')\n\t\t            \t{\n\t\t\t\t\t\t\t\t            \t\n\t\t        \t\tparent.frames[2].document.forms[0].target=\'submit_frame\';\n\t\t        \t\tparent.frames[2].document.forms[0].action=\"../../servlet/eBL.BLDepositRecRefundServlet\";\n\t\t        \t\tparent.frames[2].document.forms[0].submit();\n\n\t\t            \t}\n\t\t            //Y - Success  , N ? Failure\n\t\t            else{       \n\t\t            \t\n\t\t            \tvar messageid=obj.messageid;\n\t\t            \talert(getMessage(messageid,\'BL\')); \n\t\t            }\n\t\t            \n\t\t            \n\t\t            \n\t\t            }\n\t\t            \n\t\t        \n\t\t});\n\n\t\t   \n\t\t   \n\t\n\t\n/*\t\tparent.frames[2].document.forms[0].target=\'submit_frame\';\n\t\tparent.frames[2].document.forms[0].action=\"../../eBL/jsp/BLEnterReceiptrefundSubmit_temp.jsp\";\n\t\tparent.frames[2].document.forms[0].submit();*/\n\n\n\t}\n\n </script>\n\n<HTML>\n<HEAD>\n\n\t\t<TITLE> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </TITLE>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t<BODY onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  \tonSelect=\"codeArrestThruSelect();\">\n\t\t<FORM name=\'\' id=\'\' action=\"\" method=\'\'>\t\n\n\t\t\n\t\n\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\t\n\t <tr>\n\t \t<td class=\"label\" width=\"12.5%\"><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></td>\n\t  <td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'cash_ctr\' id=\'cash_ctr\' size=\'10\' maxlength=\'30\t\'  value=\'\'  onBlur=\"\">\n\t   <label>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</label>\n\t  <input type=\'text\' name=\'shift\' id=\'shift\' size=\'10\' maxlength=\'30\t\'  value=\'\'  onBlur=\"\">\n\t  </td>\n\t  <td class=\'label\' width=\'30%\'></td>\n\t\t<td class=\"label\" width=\"9%\"><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t <td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'postmthyr\' id=\'postmthyr\' size=\'10\' maxlength=\'30\t\'  value=\'\'  onBlur=\"\">\n\t\t  <label>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</label>\t\n\t\t <input type=\'text\' name=\'postmonthyr\' id=\'postmonthyr\' size=\'10\' maxlength=\'30\'  value=\'\'  onBlur=\"\"></td>\n\t</tr>\n\t  \t\n<tr>\t\t  \t\n\t\t <td class=\"label\" width=\"12.5%\"><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></td>\n\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'doc_date\' id=\'doc_date\' size=\'18\' maxlength=\'30\'  value=\'\'  onBlur=\"\"></td>\n\t\t<td class=\'label\' width=\'30%\'></td>\n\t\t<td width=\"5%\"  class=\'labels\'><INPUT TYPE=\"button\" name=\'record_button\' id=\'record_button\'  class=\"BUTTON\" VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onClick=\'funSubmit()\' ><input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" class=\'button\' onClick=\'cancel()\'></td>\n\n</tr>\n\t\n\t</table>\t\n\t<input type=\"hidden\" name=\'ignoreMandValidation\' id=\'ignoreMandValidation\' id=\'ignoreMandValidation\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t<input type=\'hidden\' name=\'totMinDeposit\' id=\'totMinDeposit\' id=\'totMinDeposit\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t<input type=\'hidden\' name=\'name\' id=\'name\' id=\'id\' value=\"\">\n\t\t<input type=\'hidden\' name=\'checkreq\' id=\'checkreq\' id=\'checkreq\' value=\"\">\n\t\n</FORM>\t\n\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
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
            _bw.write(_wl_block6Bytes, _wl_block6);

 	request.setCharacterEncoding("UTF-8");
	Connection con = null;	
	//String locale	= (String)session.getAttribute("LOCALE");
	//HttpSession httpSession = request.getSession(false);
//	Properties p = (Properties)httpSession.getValue("jdbc");			
//	String strclientip ="";

	try{
		
		con	=	ConnectionManager.getConnection(request);
		CallableStatement cstmt=null;

		String str_facility_id	=  (String) session.getValue("facility_id");

		//String patient_id = request.getParameter("patient_id");	 //V220801
		String patient_id ;
		String strencounter_id;
		
		//String strencounter_id = replaceNull(request.getParameter("encounter_id"));	//V220801
		
		if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
			patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
			strencounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
		}else{
			patient_id	= replaceNull(request.getParameter("patient_id"));
			strencounter_id	= replaceNull(request.getParameter("encounter_id"));
		}//V220801
		System.err.println("strencounter_id "+strencounter_id);
		System.err.println("patient_id "+patient_id);
		String strepisode_id = replaceNull(request.getParameter("episode_id"));	
		int episode_id=0;
		if("".equals(strepisode_id)){
			episode_id=0;
		}		
		else
		{
			try
			{
				episode_id=Integer.parseInt(strepisode_id);	
			}catch(Exception e)
			{
				episode_id=0;
			}
		}
		
		//if(episode_id==null) episode_id="";	
		System.out.println("episodeid deposit rec refund"+episode_id);

		String strVisit_id = replaceNull(request.getParameter("visit_id"));	
		int visit_id=0;
		if("".equals(strVisit_id)){
			visit_id=0;
		}		
		else
		{
			try
			{
				visit_id=Integer.parseInt(strVisit_id);	
			}catch(Exception e)
			{
				visit_id=0;
			}
		}
	
		System.out.println("visit_id"+visit_id);
		
		int encounter_id=0;
		if("".equals(strencounter_id)){
			encounter_id=0;
		}		
		else
		{
			try
			{
				encounter_id=Integer.parseInt(strencounter_id);	
			}catch(Exception e)
			{
				encounter_id=0;
			}
		}
		System.out.println("encounter_id="+encounter_id);

		String currdate="",str_slmt_mode_wise_rcpt_yn="",hand_without_counter_chk_out="";
	/************ADDED FOR PACKAGE BILLING **********************/
	
	
	String function_id = request.getParameter("function_id");	
		if(function_id==null) function_id="";	
		String packseqno = request.getParameter("packseqno");	
		if(packseqno==null) packseqno="";	
	/******************ends package billing*********************/
	String ignoreMandValidation = "N";
	//Added for MMS-DM-SCF-0013
	double totMinDeposit = 0.0;
	 try{
		
		String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
		PreparedStatement pst2=con.prepareStatement(query_date);
		ResultSet rst2 = pst2.executeQuery();
		if (rst2!=null)
		{
		   if (rst2.next())
		   {
				 currdate = rst2.getString(1);
				
		   		
		   }
		}

		if (rst2 != null)   rst2.close();
		if (pst2 != null)   pst2.close();
	

	}catch(Exception e)
	{
		System.out.println("error in date"+e);
		e.printStackTrace();
	}
	 
	 
	 
	 
//	System.out.println("currdate :" +currdate); 
 try{
//fetchiing HAND_WITHOUT_COUNTER_CHK_OUT for CRF-13
		String sqlst2="select SLMT_MODE_WISE_RCPT_YN,HAND_WITHOUT_COUNTER_CHK_OUT from BL_PARAMETERS where OPERATING_FACILITY_ID = '"+str_facility_id+"'";
		PreparedStatement pst=con.prepareStatement(sqlst2);
		ResultSet rst3 = pst.executeQuery();
		if (rst3!=null)
		{
		   if (rst3.next())
		   {
				 str_slmt_mode_wise_rcpt_yn = rst3.getString(1);
				 hand_without_counter_chk_out = rst3.getString(2);
		   }
		}

		if (rst3 != null)   rst3.close();
		if (pst != null)   pst.close();

//	System.out.println("str_slmt_mode_wise_rcpt_yn dep :"+str_slmt_mode_wise_rcpt_yn);



	}catch(Exception e)
	{
		System.out.println("error in date");
		e.printStackTrace();
	}


 
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(str_slmt_mode_wise_rcpt_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(hand_without_counter_chk_out));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//Added Logic for MMS-DM-SCF-0013
		try{
			PreparedStatement pstmt = null;
			ResultSet rst = null;
			String packageCode = request.getParameter("pkgCode");
			if(packageCode == null){
				packageCode = "";
			}
			
			if(!"".equals(packseqno)){
				StringTokenizer stPackSeqNo = new StringTokenizer(packseqno,"^");
				
				String stPkg = "";
				String stSeq = "";
				String rsCustGroup = "";
				String rsCustCode = "";
				String rsBlngClass = "";
				String depositReqYn = "";
				String custSpecificYn = "";

				
				StringTokenizer stPackCode = new StringTokenizer(packageCode,"^");
				while(stPackSeqNo.hasMoreTokens()){					
					pstmt = null;
					rst = null;
					stSeq = stPackSeqNo.nextToken();
					stPkg = stPackCode.nextToken();
					pstmt = con.prepareStatement("Select nvl(cust_group_code,'N') cust_group_code, nvl(cust_code,'N') cust_code, blng_class_code,nvl(cust_specific_yn,'N')  cust_specific_yn, nvl(deposit_req_yn,'N') deposit_req_yn from bl_package_sub_hdr where operating_facility_id = ? and patient_id = ? and package_code = ? and package_seq_no = ?");
					pstmt.setString(1, str_facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,stPkg);
					pstmt.setString(4,stSeq);
					rst = pstmt.executeQuery();
					if(rst != null && rst.next()){
						rsCustGroup = rst.getString("cust_group_code");
						rsCustCode = rst.getString("cust_code");
						rsBlngClass = rst.getString("blng_class_code");
						custSpecificYn = rst.getString("cust_specific_yn"); 
						depositReqYn = rst.getString("deposit_req_yn"); 
						if(!"N".equals(rsCustGroup) && !"N".equals(rsCustCode)){
							
							
							if("Y".equals(custSpecificYn)){
								/*
								Code Flow comes here when the given customer definition is
								available in the Package
								*/
								if(!"Y".equals(depositReqYn)){
									ignoreMandValidation = "Y";
								}
							}
							else{
								/*
								Code Flow comes here when the given customer definition is
								unavailable and derived from cash
								*/
								CallableStatement call12 = con.prepareCall("{ call  getpackageMinDeposit(?,?,?,?,?,sysdate,?,?,?,?,?)}");		
								call12.setString(1,str_facility_id);				
								call12.setString(2,stPkg);				
								call12.setString(3,rsBlngClass);				
								call12.setString(4,rsCustGroup);	
								call12.setString(5,rsCustCode);	
								call12.registerOutParameter(6,java.sql.Types.VARCHAR);      		
								call12.registerOutParameter(7,java.sql.Types.VARCHAR); 		
								call12.registerOutParameter(8,java.sql.Types.VARCHAR); 		
								call12.registerOutParameter(9,java.sql.Types.VARCHAR); 		
								call12.registerOutParameter(10,java.sql.Types.VARCHAR); 
							
								call12.execute();				

								String str_min_dep_amt	 = call12.getString(7);	
								
								if ( str_min_dep_amt == null ){
									str_min_dep_amt = "";
								}
								
								if("".equals(str_min_dep_amt)){
									str_min_dep_amt = "0.0";
								}
								
								
								totMinDeposit = totMinDeposit + Double.parseDouble(str_min_dep_amt);
			
								call12.close();	
								ignoreMandValidation = "Y";
							}
						}
					}
				}
			}

			
			if(pstmt != null){
				pstmt.close();
			}
			if(rst != null){
				rst.close();
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting ignoreMandValidation ->"+e);
			ignoreMandValidation = "N";
		}
		//Added Logic for MMS-DM-SCF-0013

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ignoreMandValidation));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(totMinDeposit));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}
	catch(Exception e )
	{ 
		System.out.println("BLEnterServiceSerachResult:"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) {
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_SLMT_DTL.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_COUNTER.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SHIFT.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DocNoslash.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PostMthYr.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DocNoslash.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
}
