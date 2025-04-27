package jsp_servlet._ebl._jsp;

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
import java.io.*;
import webbeans.op.CurrencyFormat;
import eOR.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __bladhocdiscdtlsedit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAdhocDiscDtlsEdit.jsp", 1731677958085L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<script language=\'javascript\' src=\'../js/BLAdhocDisc.js\'></script>\t\t\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\t\t\n<script>\nfunction cancel()\n{\n\t//parent.window.close();\n\tparent.parent.document.getElementById(\'dialog_tag\').close();\n}\n\nasync function searchReason(clng_evnt)\n{\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif(document.forms[0].disc_reason_desc.value == \"\")\n\t\t{\n\t\t\tdocument.forms[0].disc_reason_desc.value=\"\";\n\t\t\tdocument.forms[0].disc_reason_code.value=\"\";\t\n\t\t\treturn;\n\t\t}\n\t}\n\tvar target\t\t\t= document.forms[0].disc_reason_desc;\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t = \"10\";\n\tvar dialogHeight = \"10\" ;\n\tvar dialogWidth\t = \"30\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title =getLabel(\"eBL.ADHOC_DISC_REASON.label\",\"BL\");\t\t\n//\t\tvar title = encodeURIComponent(title);\t\t\n\tvar locale  = document.forms[0].locale.value;\t\t\n\t\n\tvar sql2=\"select  a.action_reason_code code,replace(a.action_reason_desc,chr(10),\'\') description from bl_action_reason_lang_vw a where nvl(status,\'!\') != \'S\' and upper(language_id) = upper(\'\"+locale+\"\') AND exists (select b.action_reason_code from bl_action_reason_by_type b  where b.action_reason_code = a.action_reason_code   and b.active_yn = \'Y\' and  ACTION_TYPE=\'SD\') and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1\";\n\n\tvar argArray = new Array();\n\tvar namesArray = new Array();\n\tvar valuesArray = new Array();\n\tvar datatypesArray = new Array();\n\n\targArray[0] = sql2;\n\targArray[1] = namesArray;\n\targArray[2] = valuesArray;\n\targArray[3] = datatypesArray;\n\targArray[4] = \"1,2\";\n\targArray[5] = target.value;\n\targArray[6] = DESC_LINK;\n\targArray[7] = DESC_CODE;\t\t\n\tretArray =await CommonLookup( title, argArray );\t\t\n\tvar str =unescape(retArray);\n\tvar arr = str.split(\",\");\n\tif(retArray != null && retArray !=\"\")\n\t{\t\t\t\t\n\t\tdocument.forms[0].disc_reason_code.value=arr[0];\n\t\tdocument.forms[0].disc_reason_desc.value=arr[1];\t\t\t\t\t\t\n\t}\n\telse\n\t{\t\t\t\n\t\tdocument.forms[0].disc_reason_desc.value=\"\";\n\t\tdocument.forms[0].disc_reason_code.value=\"\";\t\t\n\t}\n}\n\nasync function finalize_disc_amt()\n{\n\tvar adhoc_disc_amt = document.forms[0].adhoc_disc_amt.value;\n\tvar adhoc_user_id = document.forms[0].adhoc_user_id.value;\n\tvar user_password = document.forms[0].user_password.value;\n\tvar disc_reason_desc = document.forms[0].disc_reason_desc.value;\n\tvar trx_doc_ref_seq_num_count = document.forms[0].trx_doc_ref_seq_num_count.value;\n\tvar called_frm_frame = document.forms[0].called_frm_frame.value;\n\tvar trx_ind = document.forms[0].trx_ind.value;\n\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\tvar preConfigDiscAmt = document.forms[0].preConfigDiscAmt.value;\n\tvar upd_disc_amt = document.forms[0].disc_amt.value;\n\tvar org_disc_amt = document.forms[0].org_disc_amt.value;\n\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\n\tif(adhoc_user_id == \"\")\n\t{\n\t\talert(getMessage(\"BL9112\",\"BL\"));\n\t\tdocument.forms[0].adhoc_user_id.focus();\n\t\treturn false;\n\t}\n\n\tif(user_password == \"\")\n\t{\n\t\talert(getMessage(\"BL9541\",\"BL\"));\n\t\tdocument.forms[0].user_password.focus();\n\t\treturn false;\n\t}\n\n\tif(adhoc_disc_amt == \"\")\n\t{\n\t\talert(getMessage(\"BL6322\",\"BL\"));\n\t\tdocument.forms[0].adhoc_disc_amt.focus();\n\t\treturn false;\n\t}\n\n\tif(disc_reason_desc == \"\")\n\t{\n\t\talert(getMessage(\"BL6268\",\"BL\"));\n\t\tdocument.forms[0].disc_reason_desc.focus();\n\t\treturn false;\n\t}\n\tvar retVal= true;\n\t\n\tif(retVal)\n\t{\t\t\n\t\tretVal = await userValidation(document.forms[0].adhoc_user_id.value,document.forms[0].blng_serv_code.value,document.forms[0].serv_item_code.value,\"U\");//User Validation\n\t\tif(retVal)\n\t\t{\n\t\t\tretVal = await userValidation(document.forms[0].user_password.value,document.forms[0].blng_serv_code.value,document.forms[0].serv_item_code.value,\"P\");//Password Validation\n\n\t\t\tif(retVal)\n\t\t\t{\n\t\t\t\tretVal  =await disc_amt_valiation(document.forms[0].adhoc_disc_amt.value,document.forms[0].act_gross_amt.value,document.forms[0].serv_max_disc_per.value,document.forms[0].serv_max_disc_amt.value,document.forms[0].payer_max_disc_per.value,document.forms[0].payer_max_disc_amt.value,called_frm_frame);\n\t\t\t}\n\t\t}\n\t}\n\n\tif(retVal == true)\n\t{\n\t\tdocument.forms[0].called_butt.value = \"SUBMIT_BUTTON\";\n\t\tdocument.forms[0].target=\'validation_frame\';\n\t\tdocument.forms[0].action=\"../../eBL/jsp/BLAdhocDiscSubmit.jsp\";\n\t\tdocument.forms[0].submit();\n\t}\n}\n\nfunction dflt_prev_reason()\n{\n\tif(document.forms[0].sel_frm_prev_reason.checked)\n\t{\n\t\tdocument.forms[0].disc_reason_desc.value = document.forms[0].existing_reason_desc.value;\n\t\tdocument.forms[0].disc_reason_code.value = document.forms[0].existing_reason_code.value;\n/* Change added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */\n\t\tdocument.forms[0].sel_frm_default_reason.checked=false;\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].disc_reason_desc.value = \"\";\n\t\tdocument.forms[0].disc_reason_code.value = \"\";\n\t}\n}\n/* Function dflt_load added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */\nfunction dflt_load(str_default_reason_code,str_default_reason_desc)\n{\n\t\tdocument.forms[0].sel_frm_default_reason.checked=true;\n\t\tdocument.forms[0].disc_reason_desc.value = str_default_reason_desc;\n\t\tdocument.forms[0].disc_reason_code.value = str_default_reason_code;\t\t\t\n\t\tdocument.forms[0].sel_frm_prev_reason.checked=false;\n\n}\n\n/* Function dflt_reason added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */\nfunction dflt_reason(str_default_reason_code,str_default_reason_desc)\n{\n\tif(document.forms[0].sel_frm_default_reason.checked)\n\t{\n\t\tdocument.forms[0].disc_reason_desc.value = str_default_reason_desc;\n\t\tdocument.forms[0].disc_reason_code.value = str_default_reason_code;\t\t\t\n\t\tdocument.forms[0].sel_frm_prev_reason.checked=false;\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].disc_reason_desc.value = \"\";\n\t\tdocument.forms[0].disc_reason_code.value = \"\";\t\t\t\n\t}\n}\n\n/* Function put_focus modified by Karthik on 19-Nov-2012  for AMS-SCF-0170  */\nfunction put_focus(str_default_reason_code,str_default_reason_desc)\n{\n\t\n\tif(document.forms[0].loggd_user_valid_for_disc_YN.value == \"Y\")\n\t{\n\t\tif(document.forms[0].adhoc_user_id.value != \"\" && document.forms[0].user_password.value != \"\")\n\t\t{\n//\t\t\t\tdocument.forms[0].adhoc_disc_perc.disabled=false;\n\t\t\tdocument.forms[0].adhoc_disc_amt.disabled=false;\t\t\t\t\n//\t\t\t\tdocument.forms[0].adhoc_disc_perc.focus();\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(document.forms[0].adhoc_user_id.value == \"\")\n\t\t{\n\t\t\tdocument.forms[0].adhoc_user_id.focus();\n//\t\t\t\tdocument.forms[0].adhoc_disc_perc.disabled=true;\n\t\t\tdocument.forms[0].adhoc_disc_amt.disabled=true;\n\t\t}\n\t}\n\t/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */\t\t\t\n\tdflt_load(str_default_reason_code,str_default_reason_desc);\n}\n\nfunction ChkNumberInputWithMinus(fld, e, deci)\n{\n\tif (parseInt(deci)>0)\n\t   var strCheck = \'-.0123456789\';\n\telse\n\t   var strCheck = \'0123456789\';\n\t\t\n\tvar whichCode = (window.Event) ? e.which : e.keyCode;\n\tif (whichCode == 13) return true;  // Enter\n\n\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\n\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\n\tif(key == \".\" && fld.value.indexOf(key) != -1) return false; // Not more than one \'.\' char\n\tif(key == \"-\" && fld.value.indexOf(key) != -1) return false;// Not more than one \'-\' char\n}\n\t\nfunction validate_disc_amt(Obj)\n{\n\tvar no_of_decimal = document.forms[0].noofdecimal.value;\n\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\tvar preConfigDiscAmt = document.forms[0].preConfigDiscAmt.value;\n\tvar pat_deduct_amount = document.forms[0].pat_deduct_amount.value;\n\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\tif(Obj.value != \"\")\n\t{\n\t\tvar flag = CheckForChar(Obj);\n\n\t\tif(flag)\n\t\t{\n\t\t\tif(chk_for_sign_loc(Obj))\n\t\t\t{\n\t\t\t\tputdeci(Obj);\n\t\t\t\tif(Math.abs(Obj.value) == 0) \n\t\t\t\t{\n\t\t\t\t\tObj.value=\"0\"; \n\t\t\t\t\tputdeci(Obj);\n\t\t\t\t}\n\t\t\t\tif(chk_negative_entry_allow_YN())\n\t\t\t\t{\n\t\t\t\t\tif(chkDiscAmt())\n\t\t\t\t\t{\n\t\t\t\t\t\tvar disc_amt = document.forms[0].adhoc_disc_amt.value;\n\t\t\t\t\t\tvar act_gross_amt = document.forms[0].act_gross_amt.value;\n\t\t\t\t\t\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\t\t\t\t\t\tvar final_act_gross_amt = act_gross_amt;\n\t\t\t\t\t\tif (preConfigDiscAmt==\"Y\" && pat_deduct_amount!=0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tfinal_act_gross_amt=(final_act_gross_amt-pat_deduct_amount);\n\t\t\t\t\t\t}\t\t\t\t\n\t\t\t\t\t\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\t\t\t\t\t\t\n\t\t\t\t\t\t//var cal_disc_perc = (Math.abs(disc_amt)*100)/Math.abs(act_gross_amt);//Commented against V200327-MuthuN/NMC-JD-CRF-050\n\n\t\t\t\t\t\tvar cal_disc_perc = (Math.abs(disc_amt)*100)/Math.abs(final_act_gross_amt);\n\t\t\t\t\t\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\n\t\t\t\t\t\tcal_disc_perc = Math.round(cal_disc_perc*Math.pow(10,no_of_decimal))/Math.pow(10,no_of_decimal);\n\t\t\t\t\t\tcal_disc_perc = roundNumber(cal_disc_perc,no_of_decimal);\n\n\t\t\t\t\t\tdocument.forms[0].adhoc_disc_perc.value = cal_disc_perc;\n\t\t\t\t\t\tputdeci(document.forms[0].adhoc_disc_perc);\n\t\t\t\t\t\treturn true;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t}\n}\n\nfunction validate_disc_perc(Obj)\n{\n\tvar no_of_decimal = document.forms[0].noofdecimal.value;\n\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\tvar preConfigDiscAmt = document.forms[0].preConfigDiscAmt.value;\n\tvar pat_deduct_amount = document.forms[0].pat_deduct_amount.value;\n\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\tif(Obj.value != \"\")\n\t{\n\t\tvar act_gross_amt = document.forms[0].act_gross_amt.value;\n\t\tvar final_act_gross_amt = act_gross_amt;//Added V200327-MuthuN/NMC-JD-CRF-050\n\t\tvar flag = CheckForChar_withoutMinusSign(Obj);\n\t\tif(flag)\n\t\t{\n\t\t\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\t\t\tif (preConfigDiscAmt==\"Y\" && pat_deduct_amount!=0)\n\t\t\t{\n\t\t\t\tfinal_act_gross_amt=(final_act_gross_amt-pat_deduct_amount);\n\t\t\t}\t\t\t\t\n\t\t\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\n\t\t\tputdeci(Obj);\n\n\t\t\t//var disc_amt_conv = (Math.abs(act_gross_amt) * Math.abs(Obj.value))/100;//Commented against V200327-MuthuN/NMC-JD-CRF-050\n\n\t\t\tvar disc_amt_conv = (Math.abs(final_act_gross_amt) * Math.abs(Obj.value))/100;\n\t\t\t//Added V200327-MuthuN/NMC-JD-CRF-050\n\n\t\t\tdisc_amt_conv = Math.round(disc_amt_conv*Math.pow(10,no_of_decimal))/Math.pow(10,no_of_decimal);\n\t\t\tdisc_amt_conv = roundNumber(disc_amt_conv,no_of_decimal);\n\n\t\t\tdocument.forms[0].adhoc_disc_amt.value = disc_amt_conv;\n\t\t\tputdeci(document.forms[0].adhoc_disc_amt);\n\t\t\tif(!validate_disc_amt(Obj))\n\t\t\t{\n\t\t\t\tdocument.forms[0].adhoc_disc_perc.value=\"\";\n\t\t\t\tdocument.forms[0].adhoc_disc_amt.value=\"\";\n\t\t\t\tdocument.forms[0].adhoc_disc_perc.select();\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction CheckForChar(Obj)\n{\n\tvar check_var = Obj.value;\n\n\tnumList = \'1234567890.-\';\n\t\n\tfor (i=0;i<check_var.length;i++)\n\t{\n\t\tif (numList.indexOf(check_var.charAt(i)) == -1) \n\t\t{\n\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\'Common\'));\n\t\t\tObj.select();\n\t\t\treturn false;  \n\t\t}\n\t}\n\treturn true;\n}\n\nfunction CheckForChar_withoutMinusSign(Obj)\n{\n\tvar check_var = Obj.value;\n\n\tnumList = \'1234567890.-\';\n\t\n\tfor (i=0;i<check";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="_var.length;i++)\n\t{\n\t\tif (numList.indexOf(check_var.charAt(i)) == -1) \n\t\t{\n\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\'Common\'));\n\t\t\tObj.select();\n\t\t\treturn false;  \n\t\t}\n\t}\n\treturn true;\n}\n\nfunction chk_for_sign_loc(Obj)\n{\n\tvar adhoc_disc_amt = Obj.value;\n\tvar act_gross_amt = document.forms[0].act_gross_amt.value;\n\n\tvar index_of_neg_sign = adhoc_disc_amt.indexOf(\'-\');\n\t\n\tif(act_gross_amt != \"\" && act_gross_amt <0)\n\t{\n\t\tif(index_of_neg_sign != 0 && index_of_neg_sign != -1)\n\t\t{\n\t\t\talert(getMessage(\"INVALID_NUMBER_FORMAT\",\"common\"));\n\t\t\tObj.select();\n\t\t\treturn false;\n\t\t}\n\t}\n\treturn true;\n}\n\nfunction chk_negative_entry_allow_YN()\n{\n\tvar adhoc_disc_amt = document.forms[0].adhoc_disc_amt.value;\n\tvar act_gross_amt = document.forms[0].act_gross_amt.value;\n\n\tif((act_gross_amt) < 0)\n\t{\n\t\tif((adhoc_disc_amt) > 0)\n\t\t{\n\t\t\talert(getMessage(\"BL6281\",\"BL\"));\n\t\t\tdocument.forms[0].adhoc_disc_amt.select();\n\t\t\treturn false;\n\t\t}\n\t}\n\telse if((act_gross_amt) > 0)\n\t{\n\t\tif((adhoc_disc_amt) < 0)\n\t\t{\n\t\t\talert(getMessage(\"BL6281\",\"BL\"));\n\t\t\tdocument.forms[0].adhoc_disc_amt.select();\n\t\t\treturn false;\n\t\t}\n\t}\n\telse if((act_gross_amt) == 0)\n\t{\n\t\talert(getMessage(\"BL6281\",\"BL\"));\n\t\tdocument.forms[0].adhoc_disc_amt.select();\n\t\treturn false;\n\t}\n\treturn true;\n}\n\nasync function chkDiscAmt()\n{\n\tif(document.forms[0].adhoc_disc_amt.value != \'\')\n\t{\n\t\tvar disc_amt = document.forms[0].adhoc_disc_amt.value;\n\t\tvar act_gross_amt = document.forms[0].act_gross_amt.value;\n\t\tvar serv_max_disc_per = document.forms[0].serv_max_disc_per.value;\n\t\tvar serv_max_disc_amt = document.forms[0].serv_max_disc_amt.value;\n\t\tvar payer_max_disc_per = document.forms[0].payer_max_disc_per.value;\n\t\tvar payer_max_disc_amt = document.forms[0].payer_max_disc_amt.value;\n\t\tvar called_frm_frame = document.forms[0].called_frm_frame.value;\t\t\n\t\t\n\t\t//Added V200325-MuthuN/NMC-JD-CRF-050\t\t\t\n\t\tvar upd_gross_charge_amt = document.forms[0].gross_amt.value;\n\t\tvar preConfigDiscAmt = document.forms[0].preConfigDiscAmt.value;\n\t\tvar upd_disc_amt = document.forms[0].disc_amt.value;\n\t\t/*var allow_cash_copay_disc_op_yn = document.forms[0].allow_cash_copay_disc_op_yn.value;\n\t\tvar allow_cash_copay_disc_ip_yn = document.forms[0].allow_cash_copay_disc_ip_yn.value;\n\t\tvar allow_cash_copay_disc_ex_yn = document.forms[0].allow_cash_copay_disc_ex_yn.value;*/\n\t\tvar pat_deduct_amount = document.forms[0].pat_deduct_amount.value;\n\t\tvar final_act_gross_amt =act_gross_amt;\n\t\t//Added V200325-MuthuN/NMC-JD-CRF-050\t\t\t\t\n\n\t\t//Added V200325-MuthuN/NMC-JD-CRF-050\n\t\tif (preConfigDiscAmt==\"Y\" && pat_deduct_amount!=0)\n\t\t\t{\n\t\t\t\tfinal_act_gross_amt=(final_act_gross_amt-pat_deduct_amount);\n\t\t\t}\t\t\t\n\t\t\n\t\tif(preConfigDiscAmt==\"Y\"){\t\t\t\t\n\t\t\tif(serv_max_disc_amt==\'\' && serv_max_disc_per !=0)\n\t\t\t{\t\t\t\t\n\t\t\t\tserv_max_disc_amt=\n\t\t\t\t((Math.abs(parseFloat(upd_gross_charge_amt)))*(Math.abs(parseFloat(serv_max_disc_per)))/100);\t\t\t\t\n\t\t\t}\n\t\t}\n\t\t//Added V200325-MuthuN/NMC-JD-CRF-050\n\n\t\tif(Math.abs(parseFloat(act_gross_amt)) < Math.abs(parseFloat(disc_amt)))\t\n\t\t{\n\t\t\talert(getMessage(\"BL6269\",\"BL\"));\n\t\t\tdocument.forms[0].adhoc_disc_amt.select();\t\t\n\t\t\treturn false;\n\t\t}\t\t\n\n\t\t//Added V200404-MuthuN/NMC-JD-CRF-050\n\t\tif((Math.abs(parseFloat(upd_disc_amt))+Math.abs(parseFloat(disc_amt))) > (Math.abs(parseFloat(act_gross_amt))))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6269\",\"BL\"));\n\t\t\t\tdocument.forms[0].adhoc_disc_amt.select();\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\n\t\tif(preConfigDiscAmt==\"Y\"){\n\t\t\tif(((Math.abs(parseFloat(final_act_gross_amt))) < (Math.abs(parseFloat(disc_amt)))) || ((Math.abs(parseFloat(serv_max_disc_amt))) < (Math.abs(parseFloat(disc_amt))+Math.abs(parseFloat(upd_disc_amt)))))\n\t\t\t{\n\t\t\t\t//alert(getMessage(\"BL6269\",\"BL\"));\n\t\t\t\talert(\"APP-BL0860 Sum of service discount and adhoc discount cannot exceed the maximum allowed discount amount\");\n\t\t\t\tdocument.forms[0].adhoc_disc_amt.select();\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t//Added V200325-MuthuN/NMC-JD-CRF-050\n\t\t\n\t\t/*Added by karthik to validate based on customer code\n\t\tif cust_code is null then pass \"S\" to the validation procedure\n\t\tif cust_code is not null then pass \"P\" to the validation procedure\n\t\t*/\n\t\tvar cust_code = document.forms[0].cust_code.value;\t\t\t\n\t\t\n\t\tif(cust_code==\'\'){\n\t\t\tcalled_frm_frame=\'S\';\t\t\t\t\n\t\t}else{\n\t\t\tcalled_frm_frame=\'P\';\t\n\t\t}\n\t\t\n\t\tvar retVal= await disc_amt_valiation(disc_amt,final_act_gross_amt,serv_max_disc_per,serv_max_disc_amt,payer_max_disc_per,payer_max_disc_amt,called_frm_frame);//Added V200325-MuthuN/NMC-JD-CRF-050\n\t\treturn retVal;\n\t}\n}\n\n</script>\n<html>\t\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"put_focus(\'";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\" >\n<form name=\'\' id=\'\'  ACTION=\'\' method=\'post\' target=\'\'>\n\t<table cellpadding=3 cellspacing=0 border=\'0\' width=\"100%\" align=\'right\'>\t\n\t\t<tr>\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'service\' id=\'service\' size=\'40\'  maxlength=\'40\'  value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onBlur=\'\' readonly></td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'item\' id=\'item\' size=\'40\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\n\n\t\t\t<!--Discount Percent-->\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' style=\'text-align:right\' name=\'DiscPercent\' id=\'DiscPercent\' size=\'15\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" readonly></td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t\t</tr>\n\t<!--Discount Percent-->\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<tr>\n\t\t<td width=\'25%\' class=\'label\'>&nbsp;</td>\n\t\t\t<td width=\'25%\' class=\'label\'>&nbsp;</td>\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" readonly></td>\n\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<tr>\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'gross_amt\' id=\'gross_amt\' size=\'15\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" style=\'text-align:right\' readonly></td>\n\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'disc_amt\' id=\'disc_amt\' size=\'15\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" readonly style=\'text-align:right\'></td><!--//V201008 added-->\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" readonly style=\'text-align:right\'></td>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'net_amt\' id=\'net_amt\' size=\'15\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" style=\'text-align:right\' readonly></td>\t\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'addl_charges\' id=\'addl_charges\' size=\'15\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" readonly style=\'text-align:right\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'adhoc_user_id\' id=\'adhoc_user_id\' size=\'15\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"  onkeypress =\"changeToUpper()\" onBlur =\"userValidation(this,document.forms[0].blng_serv_code.value,document.forms[0].serv_item_code.value,\'U\');\" tabIndex=\'1\'></td>\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'password\' name=\'user_password\' id=\'user_password\' size=\'15\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"  onblur=\"userValidation(this,document.forms[0].blng_serv_code.value,document.forms[0].serv_item_code.value,\'P\');\" tabIndex=\'2\' autocomplete=\"off\"><!--V230508-41626 --> </td>\t\t\t\t\t\t\n\t\t</tr>\n<!--\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n-->\n<!--\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'adhoc_disc_amt\' id=\'adhoc_disc_amt\' size=\'15\'  maxlength=\'15\'  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" style=\'text-align:right\' onKeyPress=\'return(ChkNumberInputWithMinus(this,event,document.forms[0].noofdecimal.value));\' onblur=\"putdeci(this);chkDiscAmt()\" tabIndex=\'3\'></td>\t\t\n-->\n\t\t<tr>\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'act_gross_amt\' id=\'act_gross_amt\' size=\'15\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" readonly style=\'text-align:right\'></td>\n\t\t\t<td width=\"25%\"  class=\"label\">&nbsp;</td>\n\t\t\t<td width=\"25%\"  class=\"label\">&nbsp;</td>\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\">\n\t\t\t\t<input type=\'text\' name=\'adhoc_disc_perc\' id=\'adhoc_disc_perc\' size=\'3\'  maxlength=\'4\'  value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value));\' onblur=\"validate_disc_perc(this);\" tabIndex=\'3\'>\n\t\t\t</td>\t\t\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\">\n\t\t\t\t<input type=\'text\' name=\'adhoc_disc_amt\' id=\'adhoc_disc_amt\' size=\'15\'  maxlength=\'15\'  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" style=\'text-align:right\' onKeyPress=\'return(ChkNumberInputWithMinus(this,event,document.forms[0].noofdecimal.value));\' onblur=\"validate_disc_amt(this);\" tabIndex=\'4\'>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t<!--\n\tIncident No - IN017099\n\tDate/Time - 17/12/2009\n\tDeveloper Name - Manivel N\n\tBrief Description about the modification - Key for the Legend is changed from USE_PREV_DISC_REASON to USE_PREV_REASON to generalize the message\n\t-->\n\t<!-- Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 starts -->\n\t\t\t<td width=\"25%\"  class=\"label\">\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="<br><br>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t</td>\t\t\n\t\t\t<td width=\"25%\"  class=\"label\">\n\t\t\t<INPUT TYPE=\"checkbox\" name=\"sel_frm_default_reason\" id=\"sel_frm_default_reason\" onClick=\"dflt_reason(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\" checked=true tabIndex=\'5\'><br><br>\n\t\t\t<INPUT TYPE=\"checkbox\" name=\"sel_frm_prev_reason\" id=\"sel_frm_prev_reason\" onClick=\"dflt_prev_reason();\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" tabIndex=\'5\'>\n\t\t\t</td>\n\t\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t<td width=\'25%\' class=\"fields\"><textarea style=\"resize:none;\" name=\"disc_reason_desc\" id=\"disc_reason_desc\" rows=\"5\" cols=\"20\" value=\"\" tabIndex=\'6\' onBlur=\"searchReason(\'B\')\"></textarea><input type=\"button\" class=\"Button\" name=\"lookup\" id=\"lookup\" value=\"?\" onClick=\"searchReason(\'C\')\" tabIndex=\'7\'><input type=\"hidden\" name=\"disc_reason_code\" id=\"disc_reason_code\" value=\"\" ></td>\t\t\t\n\t<!-- Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170  ends-->\n\t</tr>\n\t\t<td width=\"25%\"  class=\"label\">&nbsp;</td>\n\t\t<td width=\"25%\"  class=\"label\">&nbsp;</td>\n\t\t<td width=\"25%\"  class=\"label\">&nbsp;</td>\t\t\t\t\n\t\t<td width=\"25%\"  class=\'labels\'><INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"    ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" onClick=\"finalize_disc_amt()\" tabIndex=\'8\'><input type=\'button\' class=\"BUTTON\" name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" class=\'button\' onClick=\'cancel()\' tabIndex=\'9\'></td>\n\t</tr>\n\t</table>\n\t<input type=\"hidden\" name=\"blng_serv_code\" id=\"blng_serv_code\"\tvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n\t<input type=\"hidden\" name=\"serv_item_code\" id=\"serv_item_code\"\tvalue=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n\t\n\t<input type=\"hidden\" name=\"noofdecimal\" id=\"noofdecimal\"\tvalue=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t<input type=\"hidden\" name=\"trx_ind\" id=\"trx_ind\"\tvalue=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\n\t<input type=\"hidden\" name=\"logged_user\" id=\"logged_user\"\tvalue=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t<input type=\"hidden\" name=\"client_ip_addr\" id=\"client_ip_addr\"\tvalue=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\tvalue=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\"\tvalue=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n\t\n\t<input type=\"hidden\" name=\"called_butt\" id=\"called_butt\"\tvalue=\"\" >\t\n\t<input type=\"hidden\" name=\"called_frm_frame\" id=\"called_frm_frame\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\t\n\t<input type=\"hidden\" name=\"loggd_user_valid_for_disc_YN\" id=\"loggd_user_valid_for_disc_YN\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\t\t\n\n\t<input type=\"hidden\" name=\"trx_doc_ref\" id=\"trx_doc_ref\"\tvalue=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n\t<input type=\"hidden\" name=\"trx_doc_ref_line_no\" id=\"trx_doc_ref_line_no\"\tvalue=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t<input type=\"hidden\" name=\"trx_doc_ref_seq_no\" id=\"trx_doc_ref_seq_no\"\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\"\tvalue=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t<input type=\"hidden\" name=\"visit_id\" id=\"visit_id\"\tvalue=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\t\t\n\t<input type=\"hidden\" name=\"default_reason_code\" id=\"default_reason_code\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" name=\"default_reason_desc\" id=\"default_reason_desc\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<!-- Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 -->\n\t<input type=\"hidden\" name=\"existing_reason_code\" id=\"existing_reason_code\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\"hidden\" name=\"existing_reason_desc\" id=\"existing_reason_desc\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\"hidden\" name=\"trx_doc_ref_seq_num_count\" id=\"trx_doc_ref_seq_num_count\"\tvalue=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" >\n\t<input type=\"hidden\" name=\"discount_allowed_yn\" id=\"discount_allowed_yn\"\tvalue=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\n\t<input type=\"hidden\" name=\"serv_max_disc_per\" id=\"serv_max_disc_per\"\tvalue=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" >\n\t<input type=\"hidden\" name=\"serv_max_disc_amt\" id=\"serv_max_disc_amt\"\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >\n\t<input type=\"hidden\" name=\"payer_max_disc_per\" id=\"payer_max_disc_per\"\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" >\n\t<input type=\"hidden\" name=\"payer_max_disc_amt\" id=\"payer_max_disc_amt\"\tvalue=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >\n\t<input type=\"hidden\" name=\"org_disc_amt\" id=\"org_disc_amt\"\tvalue=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n\t<input type=\"hidden\" name=\"cust_code\" id=\"cust_code\"\tvalue=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n\n\t<!-- Added V200326-MuthuN/NMC-JD-CRF-050 -->\n\t<input type=\"hidden\" name=\"preConfigDiscAmt\" id=\"preConfigDiscAmt\"\tvalue=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" >\n\t<input type=\"hidden\" name=\"allow_cash_copay_disc_op_yn\" id=\"allow_cash_copay_disc_op_yn\"\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t<input type=\"hidden\" name=\"allow_cash_copay_disc_ip_yn\" id=\"allow_cash_copay_disc_ip_yn\"\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" >\n\t<input type=\"hidden\" name=\"allow_cash_copay_disc_ex_yn\" id=\"allow_cash_copay_disc_ex_yn\"\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\n\t<input type=\"hidden\" name=\"pat_deduct_amount\" id=\"pat_deduct_amount\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" >\n\t<!-- Added V200326-MuthuN/NMC-JD-CRF-050 -->\t\n\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n</html>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201008                         NMC-JD-CRF-0066         Ram Kumar S
2            V201021                         NMC-JD-CRF-0066         Ram Kumar S
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
	
	request.setCharacterEncoding("UTF-8");	
	Connection con = null;
	PreparedStatement pstmt = null;	
	ResultSet rs1=null;
	//Added V200326-MuthuN/NMC-JD-CRF-050
	PreparedStatement pst5=null;
	ResultSet rst5=null;
	PreparedStatement pst6=null;
	ResultSet rst6=null;
	PreparedStatement pstmt_bl_visit=null;
	ResultSet rst_bl_visit=null;
	PreparedStatement pstmt_bl_epd=null;
	ResultSet rst_bl_epd=null;
	PreparedStatement pstmt_bl_pat=null;
	ResultSet rst_bl_pat=null;
	
	String settlement_ind_visit="";
	String settlement_ind_epd ="";
	String settlement_ind_pat="";
	String allow_cash_copay_disc_op_yn="";
	String allow_cash_copay_disc_ip_yn="";
	String allow_cash_copay_disc_ex_yn="";
	String pat_deduct_amount="0";
	boolean preConfigDiscAmt_YN=false;
	String preConfigDiscAmt="";
	String org_disc_amt="";
	//Added V200326-MuthuN/NMC-JD-CRF-050

	String str_patient_id="", str_episode_type="", str_episode_id="", str_visit_id="";

	String blng_serv_code="",serv_item_code="", serv_item_desc="",blng_grp_id="",policy_type_code="",cust_code="",disc_amt="",disc_perc="",currdate="",discount_allowed_yn="",user_pasword="",act_gross_amt="",trx_doc_ref_line_no="",trx_doc_ref_seq_no="",addl_charge_amt="",trx_doc_ref="",serv_desc="";

	String str_serv_max_disc_per="",str_serv_max_disc_amt="",str_payer_max_disc_per="",str_payer_max_disc_amt="";

	String upd_net_charge_amt="",upd_gross_charge_amt="",upd_disc_amt="", str_existing_reason_code="", str_existing_reason_desc="";
	/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170  */
	String str_default_reason_code="", str_default_reason_desc="";
			
	int noofdecimal=2;

	String disable_chk_box="", str_called_frm_frame="", trx_doc_ref_seq_num_count="";
	String strNull="";
	String loggd_user_valid_for_disc_YN="N", str_trx_ind="1";	

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try
	{
		con	=	ConnectionManager.getConnection(request);
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
		
		String locale = (String)session.getAttribute("LOCALE");			
		if(locale==null || locale.equals("")) locale="en";		
		
		CurrencyFormat cf1 = new CurrencyFormat();

		String str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String module_id = request.getParameter("module_id");	
		if(module_id==null) module_id="";	

		blng_serv_code = request.getParameter("blng_serv_code");	
		if(blng_serv_code==null) blng_serv_code="";	

		serv_item_code = request.getParameter("serv_item_code");	
		if(serv_item_code==null) serv_item_code="";	

		serv_item_desc = request.getParameter("serv_item_desc");	
		if(serv_item_desc==null) serv_item_desc="";	

		blng_grp_id = request.getParameter("blng_grp_id");	
		if(blng_grp_id==null) blng_grp_id="";	

		policy_type_code = request.getParameter("policy_type_code");	
		if(policy_type_code==null) policy_type_code="";	
		
		cust_code = request.getParameter("cust_code");	
		if(cust_code==null) cust_code="";	
		
		upd_net_charge_amt = request.getParameter("upd_net_charge_amt");	
		if(upd_net_charge_amt==null) upd_net_charge_amt="";		
		
		act_gross_amt = request.getParameter("act_gross_amt");	
		if(act_gross_amt==null) act_gross_amt="0";	

		upd_gross_charge_amt = request.getParameter("upd_gross_charge_amt");	
		if(upd_gross_charge_amt==null) upd_gross_charge_amt="";	
		
		//Added V200323-MuthuN/NMC-JD-CRF-050
		//if(preConfigDiscAmt_YN){//074331
			org_disc_amt = request.getParameter("org_disc_amt");
				
		//}//074331
		if(org_disc_amt==null || org_disc_amt=="") org_disc_amt="0";//074331
		//Added V200323-MuthuN/NMC-JD-CRF-050		
		//V201008 Starts
		//Finding Discount percent from Upd_Gross_Charge_amount and org_discount_amount
		float DiscounPercentage;
		float GrossAmt;
		float DiscountAmt;
		double DisPercent=0.0d;
		DiscountAmt =Float.parseFloat(org_disc_amt);
		GrossAmt = Float.parseFloat(act_gross_amt);  //V201021 Modified

		DiscounPercentage = (float)((DiscountAmt / GrossAmt) * 100);
		DisPercent=Math.round(DiscounPercentage * 100.0) / 100.0;
		//V201008 Ends
		upd_disc_amt = request.getParameter("upd_disc_amt");	
		if(upd_disc_amt==null) upd_disc_amt="";

		trx_doc_ref_line_no = request.getParameter("trx_doc_ref_line_no");	
		if(trx_doc_ref_line_no==null) trx_doc_ref_line_no="";

		trx_doc_ref_seq_no = request.getParameter("trx_doc_ref_seq_no");	
		if(trx_doc_ref_seq_no==null) trx_doc_ref_seq_no="";	

		trx_doc_ref = request.getParameter("trx_doc_ref");	
		if(trx_doc_ref==null) trx_doc_ref="";

		str_patient_id = request.getParameter("patient_id");	
		if(str_patient_id==null) str_patient_id="";	

		str_episode_type = request.getParameter("episode_type");	
		if(str_episode_type==null) str_episode_type="";	

		str_episode_id = request.getParameter("episode_id");	
		if(str_episode_id==null) str_episode_id="";			

		str_visit_id = request.getParameter("visit_id");	
		if(str_visit_id==null) str_visit_id="";	

		str_existing_reason_code = request.getParameter("existing_reason_code");	
		if(str_existing_reason_code==null) str_existing_reason_code="";	

		str_called_frm_frame = request.getParameter("called_frm_frame");	
		if(str_called_frm_frame==null) str_called_frm_frame="";		
		
		if(cust_code.length()==0)	str_called_frm_frame = "S";
		else	str_called_frm_frame = "P";		
		
		trx_doc_ref_seq_num_count =  request.getParameter("trx_doc_ref_seq_num_count");	
		if(trx_doc_ref_seq_num_count==null) trx_doc_ref_seq_num_count="";

		str_trx_ind =  request.getParameter("trx_ind");	
		if(str_trx_ind==null) str_trx_ind="1";
		
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);
				currdate = rscurr.getString(2);
			}		
			if(rscurr != null ) rscurr.close();
			if(pstmt != null ) pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit sm_acc_entity_param===>"+e.toString());
		}
		//Added V200326-MuthuN/NMC-JD-CRF-050
		if(preConfigDiscAmt.equals("Y")){
			/* Below query for taking 3 columns from bl_parameters */
			try
			{		
				String sql_blparameter="SELECT NVL (allow_cash_copay_disc_op_yn, 'N') allow_cash_copay_disc_op_yn, NVL (allow_cash_copay_disc_ip_yn, 'N') allow_cash_copay_disc_ip_yn, NVL (allow_cash_copay_disc_ex_yn, 'N') allow_cash_copay_disc_ex_yn FROM bl_parameters where operating_facility_id = '"+str_facility_id+"'";
				pst5=con.prepareStatement(sql_blparameter);
				rst5 = pst5.executeQuery();
				if (rst5!=null)
				{
				   if (rst5.next())
				   {
					allow_cash_copay_disc_op_yn = rst5.getString(1);
					allow_cash_copay_disc_ip_yn = rst5.getString(2);
					allow_cash_copay_disc_ex_yn = rst5.getString(3);
				   }
				}
				if (rst5 != null)   rst5.close();
				if (pst5 != null)   pst5.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.err.println("Error BLAdhocDiscDtlsEdit bl_parameters==>"+e);
			}
			
			/* Below query for taking settlement_ind for all episode type */
			/* Fixed SQL Injection for Common-ICN-0222 */
			String sql_bl_visit = "select settlement_ind from bl_visit_fin_dtls where operating_facility_id = ? and episode_id = ?  and visit_id = ? ";
			pstmt_bl_visit = con.prepareStatement(sql_bl_visit);
			pstmt_bl_visit.setString(1, str_facility_id);
			pstmt_bl_visit.setString(2, str_episode_id);
			pstmt_bl_visit.setString(3, str_visit_id);
			rst_bl_visit = pstmt_bl_visit.executeQuery();
			if(rst_bl_visit !=null && rst_bl_visit.next())
			{
				settlement_ind_visit=checkForNull(rst_bl_visit.getString(1));
			}
			/* Fixed SQL Injection for Common-ICN-0222 */
			String sql_bl_epd = "select settlement_ind from bl_episode_fin_dtls where operating_facility_id = ? and episode_id = ? ";
			pstmt_bl_epd = con.prepareStatement(sql_bl_epd);
			pstmt_bl_epd.setString(1, str_facility_id);
			pstmt_bl_epd.setString(2, str_episode_id);
			rst_bl_epd = pstmt_bl_epd.executeQuery();
			if(rst_bl_epd !=null && rst_bl_epd.next())
			{
				settlement_ind_epd=checkForNull(rst_bl_epd.getString(1));
			}
			/* Fixed SQL Injection for Common-ICN-0222 */
			String sql_bl_pat = "select settlement_ind from bl_patient_fin_dtls where patient_id=?";
			pstmt_bl_pat = con.prepareStatement(sql_bl_pat);
			pstmt_bl_pat.setString(1, str_patient_id);
			rst_bl_pat=pstmt_bl_pat.executeQuery();
			if(rst_bl_pat !=null && rst_bl_pat.next())
			{
				settlement_ind_pat=checkForNull(rst_bl_pat.getString(1));
			}
			
			if((!settlement_ind_visit.equals("C") && ((str_episode_type.equals("O") || str_episode_type.equals("E")) && allow_cash_copay_disc_op_yn.equals("N")))
			|| (!settlement_ind_epd.equals("C") && ((str_episode_type.equals("I") || str_episode_type.equals("D") ) && allow_cash_copay_disc_ip_yn.equals("N")))
			|| (!settlement_ind_pat.equals("C") && (str_episode_type.equals("R") && allow_cash_copay_disc_ex_yn.equals("N")))) {
			/* Below query for taking PATIENT_DEDUCTIBLE_AMT from bl_patient_charges_folio */
			try
			{		
				String sql_patdeductAmt="select nvl(sum(nvl(PATIENT_DEDUCTIBLE_AMT,0)),0) patient_deductible_amt from bl_patient_charges_folio where trx_doc_ref = ?  and trx_doc_Ref_line_num = ? and settlement_ind <> 'C' and nvl(trx_status,'X') <> 'C'";
				/* Fixed SQL Injection for Common-ICN-0222 */
			
				pst6=con.prepareStatement(sql_patdeductAmt);
				pst6.setString(1, trx_doc_ref);
				pst6.setString(2, trx_doc_ref_line_no);
				rst6 = pst6.executeQuery();
				if (rst6!=null)
				{
				   if (rst6.next())
				   {
						 pat_deduct_amount = checkForNull(rst6.getString(1));
				   }
				}
				if (rst6 != null)   rst6.close();
				if (pst6 != null)   pst6.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.err.println("Error BLAdhocDiscDtlsEdit pat_deduct_amount==>"+e);
				}
			}//If Closure
		}//SiteSpecific If Closure
		//Added V200326-MuthuN/NMC-JD-CRF-050

		try
		{
			CallableStatement  call = 
			con.prepareCall("{ ? = call  blcore.Check_Service_discount(?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?)}");	
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.setString(2,str_facility_id);
			call.setString(3,blng_serv_code);
			call.setString(4,strloggeduser);
			call.setString(5,currdate);
			if(module_id.equals("PH") || module_id.equals("ST") || module_id.equals("PS") || module_id.equals("MM"))
			{
				call.setString(6,serv_item_code);
			}
			else
			{
				call.setString(6,strNull);
			}
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);
			call.execute();		
			
			discount_allowed_yn = call.getString(1);
			if(discount_allowed_yn==null) discount_allowed_yn="";

			str_serv_max_disc_per = call.getString(7);
			if(str_serv_max_disc_per == null) str_serv_max_disc_per="";

			str_serv_max_disc_amt = call.getString(8);
			if(str_serv_max_disc_amt == null) str_serv_max_disc_amt="";

			str_payer_max_disc_per = call.getString(9);
			if(str_payer_max_disc_per == null) str_payer_max_disc_per="";

			str_payer_max_disc_amt = call.getString(10);
			if(str_payer_max_disc_amt == null) str_payer_max_disc_amt="";
			
			call.close();
		}
		catch(Exception ul)
		{
			ul.printStackTrace();
			System.err.println("Exception BLAdhocDiscDtlsEdit Check_Service_discount==>"+ul);
		}

		try
		{	
			if(discount_allowed_yn.equals("Y"))
			{
				String query_pswd="select upper(app_password.decrypt(APPL_USER_PASSWORD)) as password from sm_appl_user where appl_user_id='"+ strloggeduser + "'";
				PreparedStatement pst3=con.prepareStatement(query_pswd);
				ResultSet rst3 = pst3.executeQuery();
				if (rst3!=null)
				{
				   if (rst3.next())
				   {
						 user_pasword = rst3.getString(1);
				   }
				}
				if(user_pasword==null) user_pasword="";
				loggd_user_valid_for_disc_YN = "Y";
				if (rst3 != null)   rst3.close();
				if (pst3 != null)   pst3.close();
			}
			else
			{
				user_pasword="";
				strloggeduser="";
				loggd_user_valid_for_disc_YN = "N";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit pwd===>" +e);
		}
		
		try
		{	
			String query_addl_amt="";
			if(str_called_frm_frame.equals("P"))
			{
				query_addl_amt="Select Sum(Nvl(Addl_Charge_Amt,0)) From  BL_PAT_CHRG_FOLIO_ADDL_CHARGE Where Trx_Doc_Ref=?  And Trx_Doc_Ref_Line_Num=? And Trx_Doc_Ref_Seq_Num =? and operating_facility_id=?";
			}
			else if(str_called_frm_frame.equals("S"))
			{
				query_addl_amt="Select Sum(Nvl(Addl_Charge_Amt,0)) From  BL_PAT_CHRG_FOLIO_ADDL_CHARGE Where Trx_Doc_Ref=?  And Trx_Doc_Ref_Line_Num=? and operating_facility_id=?";
			}
			/* Fixed SQL Injection for Common-ICN-0222 */
			PreparedStatement pst4=con.prepareStatement(query_addl_amt);
			pst4.setString(1, trx_doc_ref);
			pst4.setString(2, trx_doc_ref_line_no);
			if(str_called_frm_frame.equals("P"))
			{
				pst4.setString(3, trx_doc_ref_seq_no);
				pst4.setString(4, str_facility_id);
			}
			else if(str_called_frm_frame.equals("S"))
			{
				pst4.setString(3, str_facility_id);
			}
			
			ResultSet rst4 = pst4.executeQuery();
			if (rst4!=null)
			{
			   if (rst4.next())
			   {
				 addl_charge_amt = rst4.getString(1);
			   }
			}
			if(addl_charge_amt==null || addl_charge_amt.equals("")) addl_charge_amt="0";
			addl_charge_amt = cf1.formatCurrency(addl_charge_amt, noofdecimal);
			if (rst4 != null)   rst4.close();
			if (pst4 != null)   pst4.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit addl_charge_amt===>" +e);
		}

		try
		{
			String sql1= " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE= ? and LANGUAGE_ID = ? ";
			/* Fixed SQL Injection for Common-ICN-0222 */
		 	pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, blng_serv_code);
			pstmt.setString(2, locale);
			rs1 = pstmt.executeQuery();	
			while(rs1.next())
			{
			   serv_desc  =  rs1.getString(1);	
			}	
			if (rs1 != null)   rs1.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit bl_blng_serv===>"+e.toString());
		}
		
		/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 starts */		
		str_default_reason_code= (String)session.getAttribute("str_default_reason_code");
		if(str_default_reason_code==null || str_default_reason_code.equals(""))
		{
		str_default_reason_code="";
		str_default_reason_desc="";
		}
		/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 ends */

		try
		{
			String exist_act_reason_code_qry= " select replace(a.action_reason_desc,chr(10),'') description from bl_action_reason_lang_vw a where nvl(status,'!') != 'S' and upper(language_id) = upper(?) AND exists (select b.action_reason_code from bl_action_reason_by_type b  where A.action_reason_code = ? and b.action_reason_code = a.action_reason_code and b.active_yn = 'Y' and  ACTION_TYPE='SD')";

//			System.out.println("exist_act_reason_code_qry:"+exist_act_reason_code_qry);
			/* Fixed SQL Injection for Common-ICN-0222 */
		 	pstmt = con.prepareStatement(exist_act_reason_code_qry);
			pstmt.setString(1, locale);
			pstmt.setString(2, str_existing_reason_code);
			rs1 = pstmt.executeQuery();	
		
			while(rs1.next())
			{
			   str_existing_reason_desc  =  rs1.getString(1);	
//			   System.out.println("str_existing_reason_desc :"+str_existing_reason_desc);
			}	
			if (rs1 != null)   rs1.close();
			if (pstmt != null)   pstmt.close();
			if(str_existing_reason_desc == null) str_existing_reason_desc="";
			
		/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 starts */
		if(!(str_default_reason_code==null || str_default_reason_code.equals("")))
		{
			String default_act_reason_code_qry = " select replace(a.action_reason_desc,chr(10),'') description from bl_action_reason_lang_vw a where nvl(status,'!') != 'S' and upper(language_id) = upper(?) AND exists (select b.action_reason_code from bl_action_reason_by_type b  where A.action_reason_code = ? and b.action_reason_code = a.action_reason_code and b.active_yn = 'Y' and  ACTION_TYPE='SD')";
			//stmt = con.createStatement();
			
			pstmt = con.prepareStatement(default_act_reason_code_qry);
			pstmt.setString(1, locale);
			pstmt.setString(2, str_default_reason_code);
			rs1 = pstmt.executeQuery();
			while(rs1.next())
			{
				str_default_reason_desc  =  rs1.getString(1);	
			}	
		}
		/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 ends */
			
			if (rs1 != null)   rs1.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error BLAdhocDiscDtlsEdit default_act_reason_code_qry===>"+e.toString());
		}

		if(str_existing_reason_code.equals(""))
		{
			disable_chk_box="DISABLED";
		}		

            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);
            out.print( String.valueOf(str_default_reason_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(str_default_reason_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(serv_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

			if(!serv_item_code.equals(""))
			{

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(serv_item_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
			else
			{
			//V201008 Starts

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(DisPercent));
            _bw.write(_wl_block18Bytes, _wl_block18);

			//V201008 Ends
			}

            _bw.write(_wl_block19Bytes, _wl_block19);

	//V201008 Starts
	if(!serv_item_code.equals(""))
	{

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(DisPercent));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
			//V201008 Ends
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(upd_gross_charge_amt));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
if(preConfigDiscAmt_YN){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( Float.parseFloat(org_disc_amt)));
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(upd_disc_amt));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(upd_net_charge_amt));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(addl_charge_amt));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(user_pasword));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disc_amt));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(act_gross_amt));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disc_perc));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disc_amt));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(str_default_reason_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(str_default_reason_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disable_chk_box));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(blng_serv_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(serv_item_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(str_trx_ind));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strclientip));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(str_called_frm_frame));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(loggd_user_valid_for_disc_YN));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(trx_doc_ref));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(trx_doc_ref_line_no));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(trx_doc_ref_seq_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(str_patient_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(str_episode_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_visit_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(str_default_reason_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(str_default_reason_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(str_existing_reason_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(str_existing_reason_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(trx_doc_ref_seq_num_count));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(discount_allowed_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(str_serv_max_disc_per));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(str_serv_max_disc_amt));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(str_payer_max_disc_per));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(str_payer_max_disc_amt));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(org_disc_amt));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(preConfigDiscAmt));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(allow_cash_copay_disc_op_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(allow_cash_copay_disc_ip_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(allow_cash_copay_disc_ex_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(pat_deduct_amount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            _bw.write(_wl_block87Bytes, _wl_block87);

	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		System.out.println("Error in final BLAdhocDiscDtlsEdit===>" +ee);
	}
	finally 
	{
		try{
			if(rst_bl_visit!=null)		rst_bl_visit.close();
			if(pstmt_bl_visit!=null)	pstmt_bl_visit.close();
			if(rst_bl_epd!=null)        rst_bl_epd.close();
			if(pstmt_bl_epd!=null)		pstmt_bl_epd.close();
			if(rst_bl_pat!=null)		rst_bl_pat.close();
			if(pstmt_bl_pat!=null)		pstmt_bl_pat.close();
			if(con!=null)
			{
				ConnectionManager.returnConnection(con, request);
			}
		 }catch(Exception es){es.printStackTrace();}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISC_PERC.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISC_PERC.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISCOUNT_AMT.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NetAmount.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADDL_CHARGE.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.userid.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PIN.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADHOC_DISC_AMT.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ACT_GROSS_AMT.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADHOC_DISC_PERC.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADHOC_DISC_AMT.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.USE_DEFAULT_REASON.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.USE_PREV_REASON.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADHOC_DISC_REASON.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
