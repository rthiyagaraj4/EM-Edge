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

public final class __blfindetailsauthorise extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDetailsAuthorise.jsp", 1740638769827L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           TFS/Incident        SCF/CRF            \t\t Developer Name\n--------------------------------------------------------------------------------------------------------\n1            V210129             13523         \t MOHE-CRF-0060       \t\t  Shikha Seth\n--------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html lang=\"en\">\n<head>\n <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<!--\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t-->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n<!-- \t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n\t<script language=\'javascript\'>\n\t\t\tfunction retModal(obj)\n\t\t\t{\t\t\t\t\n\t\t\t\tvar called_frm = document.forms[0].called_frm.value;\n\t\t\t\tvar upd_fin_dtl=\"\";\t\t\t\t\n\t\t\t\tvar returnArray = new Array (\"N\")\t\t\t\n\t\t\t\tparent.window.returnValue = returnArray;\t\t\t\t\t\n\t\t\t\tparent.window.close();\n\t\t\t\t/*let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\tdialogBody.contentWindow.returnValue = returnArray;\n    \n\t\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t\tdialogTag.close();*/\n\t\t\t}\n\n\t\t\tfunction confirmPasswdchk(obj)\n\t\t\t{\n\t\t\t\t//alert(\"confirmPasswdchk inside 126\");\n\t\t\t\t//Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5\n\t\t\t\tvar isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;\n\t\t\t\tvar login_user_type = document.forms[0].login_user_type.value;\n\t\t\t\tvar user_ID = document.forms[0].user_id.value;\n\t\t\t\tvar usr_id = user_ID.toUpperCase();\n\n\t\t\t\tvar active_dir_id\t= \"\";\n\t\t\t\tvar appl_user_id\t= \"\";\n\n\t\t\t\tif(isSSOIntegrationAppl == \'true\' && login_user_type != \'EM\'){\n\t\t\t\t\tvar xmlDoc = \"\";\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\txmlStr = \"<root><SEARCH  action=\'getLinkedADUserDetails\' loginID=\\\"\"+encodeURIComponent(usr_id)+\"\\\" /></root>\"\n\t\t\t\t\txmlDoc.loadXML(xmlStr)\n\t\t\t\t\txmlHttp.open(\"POST\",\"../../eSM/jsp/SMIntermediate.jsp\",false)\n\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\tresponseText = xmlHttp.responseText\n\t\t\t\t\tresponseText = trimString(responseText)\n\n\t\t\t\t\tvar retVal_arr = responseText.split(\"~\");\n\n\t\t\t\t\tactive_dir_id = retVal_arr[0];\n\t\t\t\t\tappl_user_id = retVal_arr[1];\n\n\t\t\t\t\tif(active_dir_id != \"\"){\n\n\t\t\t\t\t\tusr_id = appl_user_id;\n\t\t\t\t\t\tlogin_user_type = \"AD\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\tvar xmlDoc = \"\";\n\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\t\txmlStr = \"<root><SEARCH  action=\'getEMUserLinkedToADUserDetails\' loginID=\\\"\"+encodeURIComponent(usr_id)+\"\\\" /></root>\"\n\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\txmlHttp.open(\"POST\",\"../../eSM/jsp/SMIntermediate.jsp\",false)\n\t\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\t\tresponseText = xmlHttp.responseText\n\t\t\t\t\t\tresponseText = trimString(responseText)\n\n\t\t\t\t\t\tlnkd_actv_dir_id = responseText;\n\n\t\t\t\t\t\tif(lnkd_actv_dir_id != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar errors = getMessage(\'EM_USER_LINKED_TO_AD_USER\',\'SM\');\n\t\t\t\t\t\t\terrors = errors.replace(\"#\",usr_id);\n\t\t\t\t\t\t\talert(errors);\n\t\t\t\t\t\t\tdocument.forms[0].user_id.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tlogin_user_type = \"EM\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t//alert(\"confirmPasswdchk outside 178\");\n\t\t\t\t\tvar called_frm = document.forms[0].called_frm.value;\n\t\t\t\t\tvar blng_serv_date = document.forms[0].blng_serv_date.value;\n\t\t\t\t\tvar blng_serv_code = document.forms[0].blng_serv_code.value;\n\t\t\t\t\tvar serv_item_code = document.forms[0].serv_item_code.value;\n\t\t\t\t\tvar serv_module_id = document.forms[0].serv_module_id.value;\n\t\t\t\t\tvar loggeduser=document.forms[0].loggeduser;\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tvar cancel_reason_code = document.forms[0].cancel_reason_code.value;\n\t\t\t\t\tvar cancel_reason_desc = document.forms[0].cancel_reason_desc.value;\n\t\t\t\t\t\n\t\t\t\t\tvar void_Number=document.forms[0].voidNumber.value;\n\t\t\t\t\tvar pass_wd=document.forms[0].passwd;\n\t\t\t\t\tvar rmks=document.forms[0].remarks;\n\t\t\t\t\tvar reimb_reason_code = \'\';\n\t\t\t\t\t//alert(\"confirmPasswdchk 194\");\n\t\t\t\t\tif (document.forms[0].reimb_reason_code != null && document.forms[0].reimb_reason_code != \'undefined\' && document.forms[0].reimb_reason_code != undefined)\n\t\t\t\t\t\t//alert(\"196\");\n\t\t\t\t\t reimb_reason_code = document.forms[0].reimb_reason_code.value;\t\n\t\t\t\t\tvar upd_fin_dtl=document.forms[0].upd_fin_dtl;\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar print  = \'N\';\n\t\t\t\t\t//alert(\"200\");\n\t\t\t\t\tif (document.forms[0].print != null && document.forms[0].print != \'undefined\' && document.forms[0].print != undefined)\n\t\t\t\t\t print = document.forms[0].print.value;\t\t\n//alert(\"203\");\t\t\t\t \n\t\t\t\t\tvar recept_Refund_ind =document.forms[0].recept_Refund_ind.value;\t\n\t\t\t\t\tvar rec_ref_flag=document.forms[0].rec_ref_flag.value;\n\t\t\t\t\t//alert(\"206\");\n\t\t\t\t\tif(upd_fin_dtl.checked==true){\n\t\t\t\t\t\t//alert(\"208\");\n\t\t\t\t\t\tupd_fin_dtl.value=\'Y\';\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t//alert(\"212\");\n\t\t\t\t\t\tupd_fin_dtl.value=\'N\';\n\t\t\t\t\t}\t\t\t\t\n\t\t\t\t\t//alert(\"outside the else\");\n\t\t\t\t\t\tif(usr_id==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t//\talert(\"217\");\n//\t\t\t\t\t\t\talert(getMessage(\"BL9112\"));\n\t\t\t\t\t\t\talert(getMessage(\"BL9112\",\"BL\"));\n\t\t\t\t\t\t\tdocument.forms[0].user_id.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(pass_wd.value==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//alert(\"225\");\n//\t\t\t\t\t\t\talert(getMessage(\"BL9113\"));\n\t\t\t\t\t\t\talert(getMessage(\"BL9113\",\"BL\"));\n\t\t\t\t\t\t\tpass_wd.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(called_frm == \"\"  || called_frm == \"PKG_BULK_UPD_ACCESS\" || (called_frm == \"EBL_TRANS_SETL_RECEIPT\" && print==\"Y\") )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//alert(\"234\");\n\t\t\t\t\t\t\tif(rmks.value==\"\")\n\t\t\t\t\t\t\t{ \n\t\t\t\t\t\t//alert(\"237\");\n\t//\t\t\t\t\t\t\talert(getMessage(\"BL9306\"));\n\t\t\t\t\t\t\t\talert(getMessage(\"BL9306\",\"BL\"));\n\t\t\t\t\t\t\t\trmks.focus();\n\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t}\n\t\t\t\t\telse if(called_frm == \"BILL_REIMB_AMT\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//alert(\"247\");\n\t\t\t\t\t\t\tif(reimb_reason_code == \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//\talert(\"250\");\n\t\t\t\t\t\t\t\talert(getMessage(\"BL1356\",\"BL\"));\n\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t\tif( (called_frm == \"EBL_TRANS_SETL_REPRNT\"  && print != \"Y\")|| (called_frm == \"EBL_TRANS_SETL_RECEIPT\"  && print != \"Y\"))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//alert(\"257\");\n\t\t\t\t\t\t\tif(cancel_reason_code == \"\" || cancel_reason_desc == \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//\talert(\"260\");\n\t\t\t\t\t\t\t\talert(getMessage(\"BL1356\",\"BL\"));\n\t\t\t\t\t\t\t\t//cancel_reason_desc.focus();\n\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//alert(\"266\");\n\t\t\t\t\t\tvar HTMLVal=\"<html><body><form name=\'BLConfirmPassWdForm\' id=\'BLConfirmPassWdForm\' method=\'post\' action=\'../../eBL/jsp/BLConfirmPassWd.jsp\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'usr_id\' id=\'usr_id\' value=\'\"+usr_id+\"\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'pass_wd\' id=\'pass_wd\' value=\'\"+pass_wd.value+\"\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'upd_fin_dtl\' id=\'upd_fin_dtl\' value=\'\"+upd_fin_dtl.value+\"\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\"+rmks.value+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'mod_fin_chk\' id=\'mod_fin_chk\' value=\'Y\'>\"+\n                        \"<input type=\'hidden\' name=\'called_frm\' id=\'called_frm\' value=\'\"+called_frm+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'blng_serv_date\' id=\'blng_serv_date\' value=\'\"+blng_serv_date+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'blng_serv_code\' id=\'blng_serv_code\' value=\'\"+blng_serv_code+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'serv_item_code\' id=\'serv_item_code\' value=\'\"+serv_item_code+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'serv_module_id\' id=\'serv_module_id\' value=\'\"+serv_module_id+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'reimb_reason_code\' id=\'reimb_reason_code\' value=\'\"+reimb_reason_code+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'cancel_reason_code\' id=\'cancel_reason_code\' value=\'\"+cancel_reason_code+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'cancel_reason_desc\' id=\'cancel_reason_desc\' value=\'\"+cancel_reason_desc+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'void_Number\' id=\'void_Number\' value=\'\"+void_Number+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'print\' id=\'print\' value=\'\"+print+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'loggeduser\' id=\'loggeduser\' value=\'\"+loggeduser.value+\"\'>\"+\n                        \"<input type=\'hidden\' name=\'recept_Refund_ind\' id=\'recept_Refund_ind\' value=\'\"+recept_Refund_ind+\"\'>\"+ //V210129 \n                        \n\t\t\t\t\t\t\"</form></body></html>\";\n\t\t\t\t\t//alert(\"287\");\n\t\t\t\t\t\tparent.frames[1].document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\t\t\t\t\t//alert(\"289\");\n\t\t\t\t\t\t/* parent.frames[1].document.BLConfirmPassWdForm.action=\"../../eCommon/jsp/report_options.jsp\";\n \n\t\t\t\t\t\tparent.frames[1].document.BLConfirmPassWdForm.target=\"messageFrame\"; */\n\t\t\t\t\t\tparent.frames[1].document.BLConfirmPassWdForm.submit();\t\n//alert(\"291\");\t\t\t\t\t\t\n\t\t\t\t\t\treturn true;\n\t\t\t}\n//alert(\"294\");\n\t\t\tasync function searchReason(clng_evnt)\n\t\t\t{\n\t\t\t//\talert(\"297\");\n\t\t\t\tif(clng_evnt == \'B\')\n\t\t\t\t{\n\t\t\t\t\tif(document.forms[0].reimb_reason_desc.value == \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].reimb_reason_desc.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].reimb_reason_code.value=\"\";\t\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tvar target\t\t\t= document.forms[0].reimb_reason_desc;\n\t\t\t\tvar retVal\t\t\t=  new String();\n\t\t\t\tvar dialogTop\t = \"10\";\n\t\t\t\tvar dialogHeight = \"90vh\" ;\n\t\t\t\tvar dialogWidth\t = \"80vw\" ;\n\t\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\t\tvar search_desc\t\t\t= \"\";\n\t\t\t\tvar title =getLabel(\"eBL.ADHOC_DISC_REASON.label\",\"BL\");\t\t\n\t\t//\t\tvar title = encodeURIComponent(title);\t\t\n\t\t\t\tvar locale  = document.forms[0].locale.value;\t\t\n\t\t\t\t\n\t\t\t\tvar sql2=\"select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,\'X\') <> \'S\' and NVL(b.active_yn, \'N\') = \'Y\' and upper(language_id) = upper(\'\"+locale+\"\') AND ACTION_TYPE=\'OR\' and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1\";\n\n\t\t\t\tvar argArray = new Array();\n\t\t\t\tvar namesArray = new Array();\n\t\t\t\tvar valuesArray = new Array();\n\t\t\t\tvar datatypesArray = new Array();\n\n\t\t\t\targArray[0] = sql2;\n\t\t\t\targArray[1] = namesArray;\n\t\t\t\targArray[2] = valuesArray;\n\t\t\t\targArray[3] = datatypesArray;\n\t\t\t\targArray[4] = \"1,2\";\n\t\t\t\targArray[5] = target.value;\n\t\t\t\targArray[6] = DESC_LINK;\n\t\t\t\targArray[7] = DESC_CODE;\t\t\n\t\t\t\tretArray = await CommonLookup( title, argArray );\t\t\n\t\t\t\tvar ret1=unescape(retArray);\n\t\t\t \tvar arr=ret1.split(\",\");\n\t\t\t \tif(arr[1]==undefined) \n\t\t \t\t{\n\t\t\t \t\tarr[0]=\"\";\t\n\t\t\t \t\tarr[1]=\"\";\t\n\t\t \t\t}\n\t\t\t\tif(retArray != null && retArray !=\"\")\n\t\t\t\t{\t\t\t\t\n\t\t\t\t\tdocument.forms[0].reimb_reason_code.value=arr[0];\n\t\t\t\t\tdocument.forms[0].reimb_reason_desc.value=arr[1];\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\t\t\t\n\t\t\t\t\tdocument.forms[0].reimb_reason_desc.value=\"\";\n\t\t\t\t\tdocument.forms[0].reimb_reason_code.value=\"\";\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tasync function searchCancelReason()\n\t\t\t{\t\t\t\t\n\t\t\t\t\t/*if(document.forms[0].cancel_reason_desc.value == \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].cancel_reason_desc.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].cancel_reason_code.value=";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="\"\";\t\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}*/\n\t\t\t\tvar target\t\t\t= document.forms[0].cancel_reason_desc;\n\t\t\t\tvar retVal\t\t\t=  new String();\n\t\t\t\tvar dialogTop\t = \"\";\n\t\t\t\tvar dialogHeight = \"90vh\" ;\n\t\t\t\tvar dialogWidth\t = \"80vw\" ;\n\t\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\t\tvar search_desc\t\t\t= \"\";\n\t\t\t\tvar title =\"Cancel Reason\"//getLabel(\"eBL.ADHOC_DISC_REASON.label\",\"BL\");\t\t\n\t\t//\t\tvar title = encodeURIComponent(title);\t\t\n\t\t\t\tvar called_frm = document.forms[0].called_frm.value;\n\t\t\t\tvar locale  = document.forms[0].locale.value;\t\n\t\t\t\n\t\t\t\t if(called_frm == \"EBL_TRANS_SETL_RECEIPT\"){\t\t\t\t\t\t\t\n\t\t\t\t     var sql2=\"select a.ACTION_REASON_CODE code,a.ACTION_REASON_DESC description  from BL_ACTION_REASON_LANG_VW a, BL_ACTION_REASON_BY_TYPE b where a.ACTION_REASON_CODE=b.ACTION_REASON_CODE and ACTION_TYPE = \'CR\' and active_yn =\'Y\' AND  upper(a.language_id) = upper(\'\"+locale+\"\')and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) ORDER BY 1 \";\t\t\t\n\t\t\t\t }\telse{\t\n          \t \t\t\tvar sql2=\"select a.ACTION_REASON_CODE code,a.ACTION_REASON_DESC description from BL_ACTION_REASON_lang_vw a, BL_ACTION_REASON_BY_TYPE b where a.ACTION_REASON_CODE=b.ACTION_REASON_CODE and ACTION_TYPE = \'CB\' and active_yn =\'Y\' and  upper(a.language_id) = upper(\'\"+locale+\"\') and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) ORDER BY 1 \";\n\t\t\t\t }\n\t\t\t\t //  var sql2=\"select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,\'X\') <> \'S\' and NVL(b.active_yn, \'N\') = \'Y\' and upper(language_id) = upper(\'\"+locale+\"\') AND ACTION_TYPE=\'OR\' and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1\";\n\n\t\t\t\tvar argArray = new Array();\n\t\t\t\tvar namesArray = new Array();\n\t\t\t\tvar valuesArray = new Array();\n\t\t\t\tvar datatypesArray = new Array();\n\n\t\t\t\targArray[0] = sql2;\n\t\t\t\targArray[1] = namesArray;\n\t\t\t\targArray[2] = valuesArray;\n\t\t\t\targArray[3] = datatypesArray;\n\t\t\t\targArray[4] = \"1,2\";\n\t\t\t\targArray[5] = target.value;\n\t\t\t\targArray[6] = DESC_LINK;\n\t\t\t\targArray[7] = DESC_CODE;\t\t\n\t\t\t\tretVal = await searchCancelReasonLookup( title, argArray );\t\n\t\t\t\t/* var ret1=unescape(retVal);\n\t\t\t\t var arr=ret1.split(\",\");\n\n\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t{\n\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t\n\t\t\t\t\t} */\n\t\t\t\tif(retVal != null && retVal !=\"\")\n\t\t\t\t{\t\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\t var arr=ret1.split(\",\");\n\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t} \n\t\t\t\t\tdocument.getElementById(\"cancel_reason_code\").setAttribute(\"value\",arr[0]);\t\t\n\t\t\t\t\t\n\n\t\t\t\t\tdocument.getElementById(\"cancel_reason_desc\").value=arr[1];\n\t\t\t\t\tdocument.getElementById(\"cancel_reason_desc\").setAttribute(\"value\",arr[1]);\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\t\t\t\n\t\t\t\t\tdocument.forms[0].cancel_reason_code.value=\"\";\n\t\t\t\t\tdocument.forms[0].cancel_reason_desc.value=\"\";\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tasync function searchCancelReasonLookup(title, pArgumentArray) {\n\n\t\t\t    var retVal = new String();\n\t\t\t    /*\n\t\t\t    var dialogHeight= \"30\" ;\n\t\t\t    var dialogWidth = \"50\" ;\n\t\t\t    */\n\t\t\t    \n\t\t\t    var dialogTop   = \"10px\";\n\t\t\t    var dialogHeight= \"450px\" ;\n\t\t\t    var dialogWidth = \"700px\" ;\n\t\t\t    \n\t\t\t    var status = \"no\";\n\t\t\t\t//var fin_Val=pArgumentArray.split(\",\");\n\t\t\t    var xmlDoc = \"\" ;\n\t\t\t    var xmlHttp = new XMLHttpRequest() ;\n\n\t\t\t\tfirstCodeVal = \"\" ;\n\t\t\t\tfirstDescVal = \"\" ;\n\n\t\t\t    xmlStr =\"<root><SEARCH \" ;\n\t\t\t    xmlStr +=\" /></root>\" ;\n\t\t\t    \n\t\t\t    // added for PE on 26th April 2010\n\t\t\t    \n\t\t\t    if (pArgumentArray[5] != \"\")\n\t\t\t    {\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open( \"GET\", \"../../eCommon/jsp/CommonLookupResult.jsp?callFrom=0&\" + formQueryString(pArgumentArray,0) , false ) ;\n\t\t\t\t\txmlHttp.send( xmlDoc ) ;\n\t\t\t\t\tresponseText=xmlHttp.responseText ;\n\t\t\t\t\tresponseText = trimString(responseText);\n\t\t\t\t\teval(responseText) ;\n\t\t\t\t}\n\t\t\t    if(firstCodeVal == \"\")\n\t\t\t    {\n\n\t\t\t\t\tvar dialogUrl       = \"../../eCommon/jsp/CommonLookup.jsp?title=\"+title;\n\t\t\t\t\t\n\t\t\t\t\tpArgumentArray[9] = title;\n\n\t\t\t\t\tvar dialogArguments = pArgumentArray ;\n\t\t\t        var dialogFeatures  = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\t        \n\t\t\t        var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status;\n\t\t\t        \n\t\t\t\t\t//var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);\t\n\t\t\t        \n\t\t\t        var returnVal = \"\";  \n\t\t\t        \n\t\t\t        returnVal =   await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);\t\n\t\t\t        \n\t\t\t        if( returnVal == null || returnVal == \"\" )\n\t\t\t            return \"\";\n\t\t\t        else\n\t\t\t            return returnVal.split(\"\\\"\") ;\n\t\t\t\t\t\n\t\t\t     }\n\t\t\t\t \n\t\t\t     else\n\t\t\t     {\n\t\t\t         if(pArgumentArray[7] == CODE_DESC )\n\t\t\t         {\n\t\t\t            var temp = firstCodeVal\n\t\t\t            firstCodeVal = firstDescVal\n\t\t\t            firstDescVal = temp\n\t\t\t         }\n\t\t\t\t\t \n\t\t\t          returnVal = firstCodeVal + \"\\\"\" + firstDescVal\n\n\t\t\t         return returnVal.split(\"\\\"\") ;\n\t\t\t     }\n\t\t\t}\n\n\n\t\t\tfunction dflt_prev_reason()\n\t\t\t{\n\t\t\t\tif(document.forms[0].sel_frm_prev_reason.checked)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].reimb_reason_desc.value = document.forms[0].existing_reason_desc.value;\n\t\t\t\t\tdocument.forms[0].reimb_reason_code.value = document.forms[0].existing_reason_code.value;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].reimb_reason_desc.value = \"\";\n\t\t\t\t\tdocument.forms[0].reimb_reason_code.value = \"\";\n\t\t\t\t}\n\t\t\t}\n\nfunction fnClearCode(obj){\n\tobj.value = \'\';\n}\n\n\t//Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5\n\tfunction checkADAndEMUserYN(obj){\n\t\tvar loginID = trimString(obj.value);\n\n\t\tvar xmlDoc=\"\"\n\t\tvar xmlHttp = new XMLHttpRequest()\n\t\txmlStr = \"<root><SEARCH  action=\'getADAndEMUserYN\' loginID=\\\"\"+encodeURIComponent(loginID)+\"\\\" /></root>\"\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\txmlHttp.open(\"POST\",\"../../eSM/jsp/SMIntermediate.jsp\",false)\n\t\txmlHttp.send(xmlDoc)\n\t\tresponseText = xmlHttp.responseText\n\t\tresponseText = trimString(responseText)\n\n\t\tif(responseText == \'Y\'){\n\t\t\tif(confirm(getMessage(\"LOGIN_AS_AD_OR_EM_USER\",\"SM\"))){\n\t\t\t\tdocument.forms[0].login_user_type.value = \'AD\';\n\t\t\t}else{\n\t\t\t\tdocument.forms[0].login_user_type.value = \'EM\';\n\t\t\t}\n\t\t}else{\n\t\t\tdocument.forms[0].login_user_type.value = \'\';\n\t\t}\n\t}\n\n\t</script>\n<title>";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="</title> \n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<center>\n<form name=\'AuthForm\' id=\'AuthForm\'>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\n<tr>\n\t<td colspan=15>&nbsp;</td>\n</tr>\n\n<tr>\n<!--\t<td width=\"35%\" align=\"right\" class=\"label\">User ID</td> -->\n\t<td width=\"50%\" class=\"label\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td width=\"50%\" class=\"fields\"><input type=\'text\' name=\'user_id\' id=\'user_id\' size=\'20\' maxlength=\'20\' onKeyPress=\'return makeUpperCase()\' ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="onBlur=\"checkADAndEMUserYN(this);\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="><img src=\'../../eCommon/images/mandatory.gif\'></td>\n </tr>\n <tr>\n<!--\t<td width=\"35%\" align=\"right\" class=\"label\">Pin No</td> -->\n\t<td width=\"50%\" class=\"label\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td width=\"50%\" class=\"fields\"><input type=\'password\' name=\'passwd\' id=\'passwd\' size=\'20\' maxlength=\'64\' autocomplete=\"off\"><!--V230508-41626 --><img src=\'../../eCommon/images/mandatory.gif\'></td>\n </tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n <tr>\n<!--\t<td width=\"35%\" align=\"right\" class=\"label\">Remarks</td> -->\n\t<td width=\"50%\"class=\"label\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td width=\"50%\" class=\"fields\" nowrap><textarea name=\'remarks\'  id=\'remarks\' rows=\"2\" cols=\"25\" style=\"resize:none\" onKeyPress=\'checkMaxLimit(this,50)\'></textarea><img src=\'../../eCommon/images/mandatory.gif\'></td>\n </tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<input type= \'hidden\' name=\"remarks\" id=\"remarks\"  value=\'\'>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<tr>\n<!--\t<td width=\"35%\" align=\"right\" class=\"label\" nowrap>Update Patient<br>Financial Details</td> -->\n\t\t<td width=\"50%\" class=\"label\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td width=\"50%\" class=\"fields\" ><input type=\'checkbox\' name=\'upd_fin_dtl\' id=\'upd_fin_dtl\' value=\'\' ></td>\n\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<input type=\'hidden\' name=\'upd_fin_dtl\' id=\'upd_fin_dtl\' value=\'\'>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<tr>\n\t\t<td width=\"25%\"  class=\"label\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t<td width=\"75%\" class=\"fields\"><INPUT TYPE=\"checkbox\" name=\"sel_frm_prev_reason\" id=\"sel_frm_prev_reason\" onClick=\"dflt_prev_reason();\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="></td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<td width=\'75%\' class=\"fields\" colspan=\'3\'><textarea id=\"reimb_reason_desc\" name=\"reimb_reason_desc\" style=\"resize:none\" rows=\"5\" cols=\"20\" value=\"\" onBlur=\"searchReason(\'B\')\"></textarea><input type=\"button\" class=\"Button\" name=\"lookup\" id=\"lookup\" value=\"?\" onClick=\"searchReason(\'C\')\" ><input type=\"hidden\" name=\"reimb_reason_code\" id=\"reimb_reason_code\" value=\"\" ><img src=\'../../eCommon/images/mandatory.gif\'></td>\t\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<tr>\n\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td width=\'75%\' class=\"fields\" colspan=\'3\'><textarea name=\"cancel_reason_desc\" id=\"cancel_reason_desc\" style=\"resize:none\" rows=\"5\" cols=\"20\" value=\"\" ></textarea><input type=\"button\" class=\"Button\" name=\"lookup\" id=\"lookup\" value=\"?\" onClick=\"searchCancelReason()\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\t\t\t\t\t\n\t</tr>\n\t<!-- <input type=\"hidden\" name=\"cancel_reason_code\" id=\"cancel_reason_code\" value=\"\" > -->\n\t<input type=\"hidden\" name=\"reimb_reason_code\" id=\"reimb_reason_code\" value=\"\" >\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t<td width=\'75%\' class=\"fields\" colspan=\'2\'><textarea name=\"cancel_reason_desc\" id=\"cancel_reason_desc\" style=\"resize:none\" rows=\"5\" cols=\"20\" value=\"\" ></textarea><input type=\"button\" class=\"Button\" name=\"lookup\" id=\"lookup\" value=\"?\" onClick=\"searchCancelReason()\"><input type=\"hidden\" name=\"cancel_reason_code\" id=\"cancel_reason_code\" value=\"\" ><img src=\'../../eCommon/images/mandatory.gif\'></td>\t\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<tr>\n\t\t<td width=\'50%\' class=\'label\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\t\t\t\t\t   \n\t\t<td width=\"50%\" class=\"fields\"><input type=\'text\' name=\'voidNumber\' id=\'voidNumber\' size=\'20\' maxlength=\'30\' onKeyPress=\'return makeUpperCase()\'></td>\n\t </tr>\n\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t <tr>\n\t\t\t\t\t\t   \n\t\t<td width=\"50%\" class=\"fields\"><input type=\'hidden\' name=\'voidNumber\' id=\'voidNumber\' size=\'20\' maxlength=\'30\' onKeyPress=\'return makeUpperCase()\'></td>\n\t </tr>\n\t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t <input type=\"hidden\" name=\"reimb_reason_code\" id=\"reimb_reason_code\" value=\"\" >\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<input type= \'hidden\' name=\"cancel_reason_code\" id=\"cancel_reason_code\"  value=\'\'>\n\t<input type= \'hidden\' name=\"voidNumber\" id=\"voidNumber\"  value=\'\'>\n\t<input type= \'hidden\' name=\"cancel_reason_desc\" id=\"cancel_reason_desc\"  value=\'\'>\n\t\t<input type=\"hidden\" name=\"reimb_reason_code\" id=\"reimb_reason_code\" value=\"\" >\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<input type=\"hidden\" name=\"reimb_reason_code\" id=\"reimb_reason_code\" value=\"\" >\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n<!--\n <tr>\n\t<td width=\"35%\" ></td>\n\t<td width=\"50%\"  colspan=\"2\"></td>\n </tr>\n -->\n\n<tr>\n\t<td width=\"50%\"></td>\n\t<td width=\"50%\">\n\t<input type=\'button\' class=\'button\' name=\'auth_ok\' id=\'auth_ok\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onClick =\'return confirmPasswdchk(this);\'>\n\t<input type=\'button\' class=\'button\' name=\'auth_cancel\' id=\'auth_cancel\'  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onClick=\'return retModal(this);\'>\n\t</td>\n</tr>\n\n<tr>\n\t<td colspan=15>&nbsp;</td>\n</tr>\n<tr>\n\t<td colspan=15>&nbsp;</td>\n</tr>\n\n\t<script>\n\t\tdocument.forms[0].user_id.focus();\n\t</script>\n</table>\n<input type= \'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type= \'hidden\' name=\"called_frm\" id=\"called_frm\"  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type= \'hidden\' name=\"print\" id=\"print\"  value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type= \'hidden\' name=\"recept_Refund_ind\" id=\"recept_Refund_ind\"  value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type= \'hidden\' name=\"rec_ref_flag\" id=\"rec_ref_flag\"  value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type= \'hidden\' name=\"blng_serv_date\" id=\"blng_serv_date\"  value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type= \'hidden\' name=\"blng_serv_code\" id=\"blng_serv_code\"  value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type= \'hidden\' name=\"serv_item_code\" id=\"serv_item_code\"  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type= \'hidden\' name=\"serv_module_id\" id=\"serv_module_id\"  value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type= \'hidden\' name=\"existing_reason_code\" id=\"existing_reason_code\"  value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type= \'hidden\' name=\"existing_reason_desc\" id=\"existing_reason_desc\"  value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type= \'hidden\' name=\"loggeduser\" id=\"loggeduser\"  value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\n<!--Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5-->\n<input type=\'hidden\' name=\'isSSOIntegrationAppl\' id=\'isSSOIntegrationAppl\' value=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">\n<input type=\'hidden\' name=\'login_user_type\' id=\'login_user_type\' value=\"\">\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n<input type= \'hidden\' name=\"cancel_reason_desc\" id=\"cancel_reason_desc\"  value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n<input type= \'hidden\' name=\"voidNumber\" id=\"voidNumber\"  value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type= \'hidden\' name=\"cancel_reason_code\" id=\"cancel_reason_code\"  value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n <input type= \'hidden\' name=\"cancel_reason_desc\" id=\"cancel_reason_desc\"  value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n <input type= \'hidden\' name=\"voidNumber\" id=\"voidNumber\"  value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\n ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" \n</form>\n</center>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
//	PreparedStatement pstmt = null ;	
	Statement stmt = null; 
	ResultSet rs1=null;	

	//Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5
    boolean isSSOIntegrationAppl = false;
 
	try
	{
		String disable_chk_box = "", str_existing_reason_desc="",str_existing_reason_code="", str_cancel_reason_desc="",str_cancel_reason_code="";
		String str_voidNumber=""; 
		con	=	ConnectionManager.getConnection(request);

		//Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5
		isSSOIntegrationAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "SSO_INTEGRATION");
		
		String include=request.getParameter("mode");
		if(include==null) include="N";	
		include="N";
		
		String print = request.getParameter("print");	
		if(print == null) print = "";
		String rec_ref_flag = request.getParameter("rec_ref_flag");
		System.out.println("rec_ref_flag= "+rec_ref_flag);
		if(rec_ref_flag == null) rec_ref_flag = "";
		
		String recept_Refund_ind = request.getParameter("recept_Refund_ind");
		System.out.println("recept_Refund_indrecept_Refund_ind= "+recept_Refund_ind);
		if(recept_Refund_ind == null) recept_Refund_ind = "";
		String void_number= request.getParameter("void_number");	
		System.out.println("void_number11111="+void_number);
		if(void_number == null) void_number = "";
		String called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";
	
		String blng_serv_date = request.getParameter("blng_serv_date");
		if(blng_serv_date == null) blng_serv_date="";
	
		String blng_serv_code = request.getParameter("blng_serv_code");
		if(blng_serv_code == null) blng_serv_code="";
	
		String serv_item_code = request.getParameter("serv_item_code");
		if(serv_item_code == null) serv_item_code="";
		
		String serv_module_id = request.getParameter("serv_module_id");
		if(serv_module_id == null) serv_module_id="";
	
		str_existing_reason_code = request.getParameter("existing_reason_code");	
		if(str_existing_reason_code==null) str_existing_reason_code="";		
	//	System.err.println("str_existing_reason_code:"+str_existing_reason_code);
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";
	
		String loggeduser=request.getParameter("loggeduser");
		if(loggeduser==null) loggeduser="";
		
		if(str_existing_reason_code.equals(""))	{
			disable_chk_box="DISABLED";
		}
		if(!str_existing_reason_code.equals("")){
			try	{
	/*			String exist_act_reason_code_qry= "select a.action_reason_desc description from bl_action_reason_lang_vw a where nvl(status,'!') != 'S' and upper(language_id) = upper('"+locale+"') AND exists (select b.action_reason_code from bl_action_reason_by_type b  where A.action_reason_code = '"+str_existing_reason_code+"' and b.action_reason_code = a.action_reason_code and b.active_yn = 'Y' and  ACTION_TYPE='SD')";8*/
	
				String exist_act_reason_code_qry= "select a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,'X') <> 'S' and NVL(b.active_yn, 'N') = 'Y' and upper(language_id) = upper('"+locale+"') AND ACTION_TYPE='OR' and A.action_reason_code = '"+str_existing_reason_code+"'";
	
				stmt = con.createStatement();
				rs1 = stmt.executeQuery(exist_act_reason_code_qry);	
			
				while(rs1.next())
				{
				   str_existing_reason_desc  =  rs1.getString(1);	
				}	
				if(str_existing_reason_desc == null) str_existing_reason_desc="";
				rs1.close();
				stmt.close();	
			}catch(Exception e)	{
				System.err.println("exist_act_reason_code_qry:"+e.toString());
			}
		}

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
if(isSSOIntegrationAppl){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

System.out.println("called_frm="+called_frm+"--print="+print+"qwwer="+(called_frm.equals("EBL_TRANS_SETL_RECEIPT")&&print.equals("Y")));
	if(!called_frm.equals("BILL_REIMB_AMT") && !called_frm.equals("EBL_TRANS_SETL_REPRNT") && !called_frm.equals("EBL_TRANS_SETL_RECEIPT") || (called_frm.equals("EBL_TRANS_SETL_RECEIPT")&&print.equals("Y")))
	{ System.out.println("called_frm=="+called_frm);

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	else
	{

            _bw.write(_wl_block15Bytes, _wl_block15);

	}
	if(include.equals("Y"))
	{

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	}
	else
	{

            _bw.write(_wl_block18Bytes, _wl_block18);

	}
	if(called_frm.equals("BILL_REIMB_AMT"))
	{

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_chk_box));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

	}
	if(called_frm.equals("EBL_TRANS_SETL_REPRNT") && !print.equals("Y"))
	{

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

	}
	if(called_frm.equals("EBL_TRANS_SETL_RECEIPT") && !print.equals("Y"))
	{

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
if(called_frm.equals("EBL_TRANS_SETL_RECEIPT") && void_number.equals("A") && recept_Refund_ind.equals("R") )
	{ System.out.println("void_number in if"+void_number);
		
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
		 System.out.println("void_number in else"+void_number);
	 
            _bw.write(_wl_block28Bytes, _wl_block28);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);
            _bw.write(_wl_block30Bytes, _wl_block30);

	}
	if(called_frm.equals("EBL_TRANS_SETL_RECEIPT") && print.equals("Y")){

            _bw.write(_wl_block31Bytes, _wl_block31);
}
	if(called_frm.equals("EBL_TRANS_SETL_REPRNT") && print.equals("Y")){
		
            _bw.write(_wl_block32Bytes, _wl_block32);
}

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recept_Refund_ind));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rec_ref_flag));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(blng_serv_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(blng_serv_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(serv_item_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(serv_module_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(str_existing_reason_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str_existing_reason_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(loggeduser));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(isSSOIntegrationAppl));
            _bw.write(_wl_block48Bytes, _wl_block48);
 if(!called_frm.equals("EBL_TRANS_SETL_RECEIPT") && !print.equals("Y") ){ 
            _bw.write(_wl_block1Bytes, _wl_block1);
 if(!called_frm.equals("EBL_TRANS_SETL_REPRNT")){ 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(str_cancel_reason_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
} 
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(str_voidNumber));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_cancel_reason_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
} else if(!called_frm.equals("EBL_TRANS_SETL_RECEIPT") && print.equals("Y")){
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(str_cancel_reason_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(str_voidNumber));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_cancel_reason_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
} 
            _bw.write(_wl_block57Bytes, _wl_block57);

	}
	catch(Exception ee)
	{
	  System.err.println("Error in BLFinDetailsAuthorise.jsp: " +ee);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AUTH_SCREEN.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.userid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PIN.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UPDATE_PATIENT_FIN_DTL.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.USE_PREV_REASON.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VOIDNUMBER.label", java.lang.String .class,"key"));
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
}
