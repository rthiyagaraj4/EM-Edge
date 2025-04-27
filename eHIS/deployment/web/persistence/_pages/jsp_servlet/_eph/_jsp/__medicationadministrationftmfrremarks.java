package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eST.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __medicationadministrationftmfrremarks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAdministrationFTMFRRemarks.jsp", 1709120944799L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministrationFixedTime.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t<script>\n\t\tfunction returnStatus(btn){\n\t\t\tif(btn==\"ok\"){\n\t\t\t\tvar frmobjRem=document.MedicationAdministrationFTMFRRemarks;\n\t\t\t\tvar linkValue=frmobjRem.linkValue.value;\n\t\t\t\tvar callfrom=frmobjRem.callfrom.value;\n\t\t\t\tvar validateTime1=frmobjRem.validateTime1.value;\n\t\t\t\tvar validateTime2=frmobjRem.validateTime2.value;\n\t\t\t\tvar obj=frmobjRem.admin_date_time;\n\t\t\t\t\n\t\t\t\tvar actiontime=obj.value;\n\t\t\t\tvar locale=frmobjRem.locale.value;\n\t\t\t\t//if(actiontime!=\"\")                                                 // Commented for LEAP-INT-PH-SCF-14813 [IN057865]\n\t\t\t\t\t//actiontime=convertDate(actiontime,\"DMYHM\",locale,\"en\"); \n\t\t\t\tif(locale!=\"en\")   // if block Added for LEAP-INT-PH-SCF-14813 [IN057865]\n\t\t\t\t\tactiontime=convertDate(actiontime,\"DMYHM\",locale,\"en\");    \n\t\t\t\n\t\t\t\tvar timeMsg=getMessage(\"PH_ACTION_DATE_TIME_BETWEEN_CURR_DATE_TIME\",\'PH\');\n\t\t\t\tvar timeMsg1=getMessage(\"PH_ACTION_DATE_TIME_SHOULD_BE_GREATER\",\'PH\');\n\t\t\t\tvar timeMsg2=getMessage(\"PH_ACTION_DATE_TIME_SHOULD_BE_LESS\",\'PH\');\n\t\t\t\tvar timeMsg3=getMessage(\"ACTION_BY_CANNOT_BLANK\",\'PH\');\n\t\t\t\tvar timeMsg4=getMessage(\"CURRENT_TIME_SHOULD_BE_GREATER\",\'PH\');\n\t\t\t\tif(actiontime!=\"\"){\n\t\t\t\t\tif(validateTime1!=\"\" && validateTime2!=\"\"){\t\n\t\t\t\t\t\tif(!isBetween(validateTime1, validateTime2, actiontime, \'DMYHM\', \"en\")){     // locale changed to \"en\" for LEAP-INT-PH-SCF-14813 [IN057865]\n\t\t\t\t\t\t\ttimeMsg=timeMsg.replace(\'$\',convertDate(validateTime1,\"DMYHM\",\"en\",locale));\n\t\t\t\t\t\t\ttimeMsg=timeMsg.replace(\'#\',convertDate(validateTime2,\"DMYHM\",\"en\",locale));\n\t\t\t\t\t\t\talert(timeMsg);\n\t\t\t\t\t\t\tif(linkValue!=\"CO\"){\n\t\t\t\t\t\t\t\tobj.value = convertDate(validateTime1,\"DMYHM\",\"en\",locale);\n\t\t\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse if(validateTime1!=\"\"){\n\t\t\t\t\t\tif(!isBefore(validateTime1,actiontime,\'DMYHM\',locale)){\n\t\t\t\t\t\t\ttimeMsg1=timeMsg1.replace(\'$\',convertDate(validateTime1,\"DMYHM\",\"en\",locale));\n\t\t\t\t\t\t\talert(timeMsg1);\n\t\t\t\t\t\t\tif(linkValue!=\"CO\"){\n\t\t\t\t\t\t\t\tobj.value = convertDate(validateTime1,\"DMYHM\",\"en\",locale);\n\t\t\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t}\n\t\t\t\t\telse if(validateTime2!=\"\"){ \n\t\t\t\t\t\t//Added !(not)IsBefore  Regarding incident num:24297 on 15/Oct/2010 ==By Sandhya\n\t\t\t\t\t\tif(!isBefore(actiontime,validateTime2,\'DMYHM\', \'en\')){\t//locale\t\n\t\t\t\t\t\t\ttimeMsg2=timeMsg2.replace(\'$\',convertDate(validateTime2,\"DMYHM\",\"en\",locale));\n\t\t\t\t\t\t\tif(linkValue!=\"CO\"){\n\t\t\t\t\t\t\t\tobj.value = convertDate(validateTime2,\"DMYHM\",\"en\",locale);\n\t\t\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\t\t\talert(timeMsg2);\n\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse {//\n\t\t\t\t\t\t\t\t//if (callfrom!=\"SCH\"){\n\t\t\t\t\t\t\t\t\ttimeMsg4=timeMsg4.replace(\'$\',convertDate(actiontime,\"DMYHM\",\"en\",locale));\n\t\t\t\t\t\t\t\t\talert(timeMsg4);\n\t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t\t//}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(frmobjRem.admin_by.value==\"\" || frmobjRem.admin_by.value==\" \"){ //replaced administered_by_id with admin_by for IN24890 --15/11/2010-- priya\n\t\t\t\t\ttimeMsg3=timeMsg3.replace(\'$\',frmobjRem.linkValueString.value);\n\t\t\t\t\talert(timeMsg3);\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tvar rem=frmobjRem.remarks.value;\n\t\t\t\tif(linkValue==\"HO\")\t{\n\t\t\t\t\tif(rem==\"\")\t{\n\t\t\t\t\t\talert(getMessage(\"PH_MANDATORY\",\'PH\'));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tvar retVal=new Array();\n\t\t\t\tretVal[0]=frmobjRem.linkValue.value;\n\t\t\t\tretVal[1]=frmobjRem.administered_by_id.value;\n\t\t\t\tretVal[2]=actiontime;\n\t\t\t\tif(rem!=\"\")\n\t\t\t\t\trem=encodeURIComponent(rem,\"UTF-8\");\n\t\t\t\tretVal[3]=rem;\n\t\t\t\tif(linkValue==\"RE\"){\n\t\t\t\t\tif(frmobjRem.Remarks_MFR_flow_rate.value==\"\"){\n\t\t\t\t\t\talert(getMessage(\"PH_ENTER_FLOW_RATE\",\"PH\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\telse if(parseFloat(frmobjRem.Remarks_MFR_flow_rate.value)==0){\n\t\t\t\t\t\talert(getMessage(\"PH_ENTER_VALID_FLOW_RATE\",\"PH\"));\t\t\t\t\t\t\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t/*else{\n\t\t\t\t\t\tif(parseFloat(frmobjRem.Remarks_MFR_flow_rate.value)>parseFloat(frmobjRem.h_iv_admin_qty.value)){\n\t\t\t\t\t\t\t//alert(getMessage(\"PH_ENTER_VALID_FLOW_RATE\",\"PH\"));\t\t\t\t\t\t\n\t\t\t\t\t\t\talert(\"Flow Rate cannot be greater than the total Volume\");\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}*/\n\t\t\t\t}\n\t\t\t\tif(linkValue==\"CH\"){\n\t\t\t\t\tvar ch_flow_rate_from = frmobjRem.ch_flow_rate_from.value;\n\t\t\t\t\tvar ch_flow_rate_to = frmobjRem.ch_flow_rate_to.value;\n\t\t\t\t\tvar remarks\t\t\t= frmobjRem.remarks.value;//Added for SKR-SCF-0913[Inc:46556]\n\t\t\t\t\tif(ch_flow_rate_to==\"\"){\n\t\t\t\t\t\talert(getMessage(\"PH_ENTER_FLOW_RATE\",\"PH\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\telse if(parseFloat(ch_flow_rate_to)==0 || parseFloat(ch_flow_rate_from)==parseFloat(ch_flow_rate_to)){\n\t\t\t\t\t\talert(getMessage(\"PH_ENTER_VALID_FLOW_RATE\",\"PH\"));\t\t\t\t\t\t\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\tif(remarks==\"\"){//Added if condition for SKR-SCF-0913[Inc:46556]\n\t\t\t\t\t   \talert(getMessage(\"REMARKS_CAN_NOT_BE_BLANK\",\"PH\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\tretVal[4]=ch_flow_rate_to;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\tretVal[4]=frmobjRem.Remarks_MFR_flow_rate.value;\n\n\t\t\t\tif(callfrom==\"SCH\" && linkValue==\"CO\"){\n\t\t\t\t\tretVal[5]=frmobjRem.iv_batch_id.value;\n\t\t\t\t\tretVal[6]=frmobjRem.iv_expiry_date.value;\n\t\t\t\t\tretVal[7]=frmobjRem.iv_trade_id.value;\n\t\t\t\t\tretVal[8]=frmobjRem.iv_trade_name.value;\n\t\t\t\t\tretVal[9]=frmobjRem.iv_qty_in_disp_mode.value;\n\t\t\t\t}\n\t\t\t\twindow.returnValue = retVal;\n\t\t\t}\n\t\t\twindow.close();\n\t\t}\n\t\t</script>\n\t</head>\n\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t<form name=\"MedicationAdministrationFTMFRRemarks\" id=\"MedicationAdministrationFTMFRRemarks\" >\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"102%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t<td class=\"label\" colspan=\'3\' width=\'75%\'>&nbsp;<b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr style=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\t<td class=\"label\" width=\'20%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t<td  class=\"label\" width=\'30%\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<input type=\"text\" id=\"iv_batch_id\"  name=\"iv_batch_id\" id=\"iv_batch_id\" size=\"9\" maxlength=\"10\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" style=\"font-size:11;\" disabled >\n\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"?\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  onClick=\"calcQuantityInDispensingUOM(\'IVSCH\', \'1\');callMednBatchSearch(\'iv_batch_id\',\'iv_expiry_date\',\'iv_trade_name\',\'iv_trade_id\',\'iv_bin_code\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'\',\'iv_infusion_period\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'IVSCH\',\'\')\" id=\"iv_batch_id_but\" name=\"iv_batch_id_but\" >\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t<select id=\"iv_batch_id\" name=\"iv_batch_id\" id=\"iv_batch_id\" style=\"font-size:11;\" onChange=\"assignBatchDetails(\'SCH\',\'IV\',this)\">\n\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="---</option>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t</select>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\'20%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t<td  class=\"label\" width=\'30%\'><input type=\"text\" name=\"iv_expiry_date\" id=\"iv_expiry_date\" size=\"9\" maxlength=\"10\" disabled value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"></td>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_bin_code\" id=\"iv_bin_code\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_id\" id=\"iv_trade_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_name\" id=\"iv_trade_name\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_type\" id=\"iv_dosage_type\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_num\" id=\"order_line_num\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_qty\" id=\"iv_admin_qty\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_uom\" id=\"iv_qty_uom\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_in_disp_mode\" id=\"iv_qty_in_disp_mode\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period\" id=\"iv_infusion_period\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t </tr>\n\t\t\t\t <tr ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =">\n\t\t\t\t\t <td class=\"label\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t <td class=\"label\" colspan=\'3\'><input type=\"text\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" name=\"Remarks_MFR_flow_rate\" size=2 maxlength=9 class=\"number\" style=\"font-size:11;color:blue\" onKeyPress=\"return allowValidNumber(this,event,6,2);\"><b><label style=\"font-size:10;\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="/";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</label></b></td>\n\t\t\t\t </tr>\n\t\t\t\t <tr style=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t\t <td class=\"label\" width=\'20%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t <td class=\"label\" width=\'30%\'><input type=\"text\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" name=\"ch_flow_rate_from\"class=\"number\" style=\"font-size:11;color:blue\" disabled size=\'5\'><b><!--Increased Size from 3 to 5 for SKR-SCF-0913[Inc 46556] --><label style=\"font-size:10;\">&nbsp; ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</label></b></td>\n\t\t\t\t\t <td class=\"label\" width=\'20%\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t\t\t <td class=\"label\" width=\'30%\'><input type=\"text\" value=\"\" name=\"ch_flow_rate_to\" id=\"ch_flow_rate_to\" size=\'3\' maxlength=\'9\' class=\"number\" style=\"font-size:11;color:blue\" onKeyPress=\"return allowValidNumber(this,event,6,2);\"><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" ></img><b>&nbsp;<label style=\"font-size:10;\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</label></b></td>\n\t\t\t\t </tr>\n\t\t\t\t <tr>\n\t\t\t\t\t <td class=\"label\"  >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t <td class=\"label\" colspan=\'3\' ><textarea rows=\"4\" cols=\"43\" name=\"remarks\" onKeyPress=\"return(checkMaxLimit(this,255));\" onBlur=\"callCheckMaxLen(this,255,\' Remarks \')\"></textarea><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="></img></td>\n\t\t\t\t </tr>\n\t\t\t\t <tr>\n\t\t\t\t\t <td class=\"label\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t\t <td class=\"label\" colspan=\'3\'><input type=\"text\" name=\"admin_by\" id=\"admin_by\" maxlength=\"30\" size=\"30\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" onBlur=\"if(this.value!=\'\' ) searchUser(this,\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\');\"><input type=\"button\" class=\"button\" name=\"btnAdminBy\" id=\"btnAdminBy\" value=\"?\" onClick=\"searchUser(document.MedicationAdministrationFTMFRRemarks.admin_by,\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')\">\n\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" ></img></td>\n\t\t\t\t</tr>\n\t\t\t\t \n\t\t\t\t <tr>\n\t\t\t\t\t <td class=\"label\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t\t\t <td class=\"label\" colspan=\'3\'><input type=\"text\" name=\"admin_date_time\" id=\"admin_date_time\" maxlength=\"16\" size=\"15\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" onChange=\"validateTime(this,\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\');\" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="> &nbsp;<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\'adm_dt_cal\' onClick=\" showCalendar(\'admin_date_time\',null,\'hh:mm\');\" style=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" ></td><!--commented com.ehis.util.DateUtils.convertDate(current_dt_time,\"DMYHM\",\"en\",locale) SKR-SCF-0913[Inc : 46556]-->\n\t\t\t\t </tr>\n\t\t\t\t <tr>\n\t\t\t\t\t<td class=\"button\" colspan=\"4\" align=\'center\'>\n\t\t\t\t\t\t<input type=\"button\" name=\"btnOK1\" id=\"btnOK1\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' class=\"button\" onClick=\"returnStatus(\'ok\');\">&nbsp;\n\t\t\t\t\t\t<input type=\"button\" name=\"btnCANCEL1\" id=\"btnCANCEL1\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' class=\"button\" onClick=\"returnStatus(\'cancel\');\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t </table>\n\t\t\t<input type=\"hidden\" name=\"linkValue\" id=\"linkValue\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t<input type=\"hidden\" name=\"linkValueString\" id=\"linkValueString\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t<input type=\"hidden\" name=\"administered_by_id\" id=\"administered_by_id\" id=\"administered_by_id\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t<input type=\"hidden\" name=\"validateTime1\" id=\"validateTime1\" id=\"validateTime1\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t<input type=\"hidden\" name=\"validateTime2\" id=\"validateTime2\" id=\"validateTime2\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\"hidden\" name=\"SQL_PH_MED_ADMIN_APPL_USERS\" id=\"SQL_PH_MED_ADMIN_APPL_USERS\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t<input type=\"hidden\" name=\"h_iv_admin_qty\" id=\"h_iv_admin_qty\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t<input type=\"hidden\" name=\"sch_date_time\" id=\"sch_date_time\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\t<!-- added for SCF-7528-->\n\t\t\t<input type=\"hidden\" name=\"callfrom\" id=\"callfrom\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );
	
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


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

 	request.setCharacterEncoding("UTF-8");

		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends

	String locale = (String) session.getAttribute("LOCALE");
	String login_user		=	(String)session.getValue("login_user");
	String bean_id							= "MedicationAdministrationFTBean";
	String bean_name						= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	String login_user_desc	=	bean.getSMUserName(login_user);
	//out.println(login_user);
		
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String linkValue=request.getParameter("linkValue");
	String drugdesc=request.getParameter("drugdesc")==null?"":request.getParameter("drugdesc");
	String current_dt_time=request.getParameter("current_date_time")==null?"":request.getParameter("current_date_time");
	String validateTime1=request.getParameter("validateTime1")==null?"":request.getParameter("validateTime1");
	String validateTime2=request.getParameter("validateTime2")==null?"":request.getParameter("validateTime2");
	String sch_date_time=request.getParameter("sch_date_time");		//added SCF-7528
	String linkValueString="";
	String calendar_displaystyle="visibility:visible;display:inline";
	String date_disabled="";
	String mandatory_remarks="style=display:none";
	String displayFlowRate ="style=display:none";
	String MFR_flow_rate =request.getParameter("MFR_flow_rate")==null?"":request.getParameter("MFR_flow_rate");
	String flowRateDurationUnitDesc =request.getParameter("flowRateDurationUnitDesc")==null?"":request.getParameter("flowRateDurationUnitDesc");
	String infusion_vol_str_unit_desc =request.getParameter("sch_infusion_vol_str_unit_desc")==null?"":request.getParameter("sch_infusion_vol_str_unit_desc"); // sch_infusion_vol_str_unit chanegd to sch_infusion_vol_str_unit_desc for SKR-SCF-0215 [IN:029303]
	String h_iv_admin_qty =request.getParameter("h_iv_admin_qty")==null?"":request.getParameter("h_iv_admin_qty");
	String callfrom =request.getParameter("callfrom")==null?"":request.getParameter("callfrom");
	String batch_id =request.getParameter("batch_id")==null?"":request.getParameter("batch_id");
	String expiry_date ="";//request.getParameter("expiry_date")==null?"":request.getParameter("expiry_date");
	String trade_id =request.getParameter("trade_id")==null?"":request.getParameter("trade_id");
	String trade_name =request.getParameter("trade_name")==null?"":request.getParameter("trade_name");
	String iv_Auto_Admin =request.getParameter("iv_Auto_Admin")==null?"":request.getParameter("iv_Auto_Admin");
	String patient_id =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String drug_code =request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String admin_from_date =request.getParameter("admin_from_date")==null?"":request.getParameter("admin_from_date");
	String admin_to_date =request.getParameter("admin_to_date")==null?"":request.getParameter("admin_to_date");
	String order_id =request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_line_num =request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
	String Store_locn_code =request.getParameter("Store_locn_code")==null?"":request.getParameter("Store_locn_code");
	String dosage_type =request.getParameter("dosage_type")==null?"":request.getParameter("dosage_type");
	String iv_admin_qty =request.getParameter("iv_admin_qty")==null?"":request.getParameter("iv_admin_qty");
	String iv_qty_uom =request.getParameter("iv_qty_uom")==null?"":request.getParameter("iv_qty_uom");
	String iv_bin_code =request.getParameter("iv_bin_code")==null?"":request.getParameter("iv_bin_code");
	String mar_iv_compl_dt_ind =request.getParameter("mar_iv_compl_dt_ind")==null?"":request.getParameter("mar_iv_compl_dt_ind");
	String iv_infusion_period =request.getParameter("iv_infusion_period")==null?"":request.getParameter("iv_infusion_period");
	String iv_prep_yn =request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String displayBatch ="display:none", auto_Admin_dis="", displayFlowCahnge="display:none";
	ArrayList iv_batch_ids = new ArrayList();
	if(linkValue.equals("ST"))
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Start.label","common_labels");
	else if(linkValue.equals("HO")){
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hold.label","common_labels");
		mandatory_remarks="";
	}
	else if(linkValue.equals("RE")){			
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Resume.label","ph_labels");
		displayFlowRate="";
	}
	else if(linkValue.equals("CO")){
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels");
		if(!callfrom.equals("SCH") ){
			date_disabled ="disabled";
			calendar_displaystyle="visibility:hidden;display:none";
		}
		else{
			if(mar_iv_compl_dt_ind.equals("I")){
				date_disabled ="disabled";
				calendar_displaystyle="visibility:hidden;display:none";
			}
			if(iv_prep_yn.equals("5"))
				displayBatch="display:inline";
			iv_batch_ids =bean.getAllBatchIDS(order_id,order_line_num,"N");
			if(iv_batch_ids==null || iv_batch_ids.size()==0){
				if(iv_Auto_Admin.equals("N"))
					auto_Admin_dis="disabled";
				else 
					auto_Admin_dis="";
			}
			else if(iv_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
				batch_id = (String)iv_batch_ids.get(0);
				expiry_date = (String)iv_batch_ids.get(1);
				trade_id	= (String)iv_batch_ids.get(2);
				trade_name  = (String)iv_batch_ids.get(3);
				auto_Admin_dis="disabled";
				float returned_qty=0, tot_administered_qty=0, ret_qty=0;
				ArrayList totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
				for(int j=0;j<totQty.size();j=j+4){
					returned_qty = (Float)totQty.get(j+2);
					tot_administered_qty=  (Float)totQty.get(j+3);
					ret_qty=returned_qty-tot_administered_qty;							 
				}
				if(ret_qty<=0){
					batch_id = (String)iv_batch_ids.get(0);
					expiry_date = (String)iv_batch_ids.get(1);
					trade_id	= (String)iv_batch_ids.get(2);
					trade_name  = (String)iv_batch_ids.get(3);
				}
				else{
					batch_id = "";
					expiry_date = "";
				}
			}
		}
	}
	else if(linkValue.equals("CH")){
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.change.label","common_labels");
		//calendar_displaystyle="visibility:hidden;display:none";
		//date_disabled ="disabled";
		mandatory_remarks="";
		displayFlowCahnge="display:inline";
	}

	String title = linkValueString+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MFR.label","ph_labels");
	
	if(!locale.equals("en")){ //Added below if condition for SKR-SCF-0913[Inc : 46556]
		 current_dt_time=com.ehis.util.DateUtils.convertDate(current_dt_time,"DMYHM","en",locale);
		 sch_date_time=com.ehis.util.DateUtils.convertDate(sch_date_time,"DMYHM","en",locale);
	 }

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(title));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(drugdesc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(displayBatch));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

						if(iv_batch_ids == null || iv_batch_ids.size() <= 9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block17Bytes, _wl_block17);

						}
						else{

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

							for (int kk=0;kk<iv_batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)iv_batch_ids.get(kk)));
            _bw.write(_wl_block22Bytes, _wl_block22);

							} 

            _bw.write(_wl_block23Bytes, _wl_block23);

						}

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(iv_bin_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(iv_admin_qty));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(iv_qty_uom));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(iv_infusion_period));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(displayFlowRate));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(MFR_flow_rate));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(flowRateDurationUnitDesc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(displayFlowCahnge));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(MFR_flow_rate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(flowRateDurationUnitDesc));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(flowRateDurationUnitDesc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(linkValueString));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mandatory_remarks));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(linkValueString));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(login_user_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(linkValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(linkValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(linkValueString));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(current_dt_time));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(date_disabled));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(calendar_displaystyle));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(linkValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(linkValueString));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(validateTime1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(validateTime2));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_APPL_USERS")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(h_iv_admin_qty));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block72Bytes, _wl_block72);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.By.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
