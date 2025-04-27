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
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import org.apache.commons.codec.binary.Base64;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __bldepositrefund extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLDepositRefund.jsp", 1742750760987L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<!-- \nSr No        Version          TFS/Incident        SCF/CRF            \t\t    \tDeveloper Name\n--------------------------------------------------------------------------------------------------------\n1\t\t\t V220801\t\t\t34745\t\tBL-Deposit Receipt/Refund-Encounter\t    Mohanapriya\n1            V220816            34122           TH-KW-CRF-0156                      Namrata/Manivel\n--------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\t<script>alert(getMessage(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\',\'BL\'));\n\t\t\t\t//window.close();\n\t\t\t\t\n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close();   \n\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\t\t\t<script>alert(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\n\t\t\t\t//window.parent.returnValue=\"Y\";\n\t\t\t\t//window.close();\n\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    dialogBody.contentWindow.returnValue = \"Y\";\n    \n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close();   \n\t\t\t\t\n\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<html>\n\t<head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLDepositReceipt.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\n\t\t\n\t\t<script>\n\t\t\n\t\t$(document).ready(function(){\n\t\t\t\n\t\t//added by Vijay for bill generation patient deposit collection  \n\t\t\t\n\t\t\tif($(\'#called_from\').val()==\'bill_generation\')\n\t\t\t\t{\n\t\t\t\t\n\t\t\t$(\'#receipt_nature_code\').val(\'AD\');\n\t\t\t$(\'#receipt_nature\').val(\'Patient Deposit\');\n\t\t\t$(\'#receipt_nature_code\').attr(\'readonly\',\'readonly\');\n\t\t\t$(\'#receipt_nature\').attr(\'readonly\',\'readonly\');\n\t\t\t$(\'#rec_ref\').attr(\'disabled\',\'disabled\');\n\t\t\t$(\'#dep_type\').attr(\'disabled\',\'disabled\');\n\t\t\t$(\'#depest\').hide();\n\t\t\t$(\'#dep_type\').val(\'N\');\n\t\t\t$(\'#receiptNatureBtn\').attr(\'disabled\',\'disabled\');\n\t\t\t\t\n\t\t\t\t}\n\t\t\t//ends-------------\n\t\t\tvar formObj=document.EnterReceiptRefundForm;\n\t\t$(\'#customerid\').hide();\n\t\t$(\'#cus_id\').hide();\n\t\t\t$(\"#spldep\").attr(\"disabled\", \"disabled\");\n\t\t\t$(\"#doc_number\").attr(\"disabled\", \"disabled\");\n\t\t\t$(\"#doc_num\").attr(\"disabled\", \"disabled\");\n\t\t\t$(\"#documnumber\").attr(\"disabled\", \"disabled\");\n\t\t\t$(\"#doc_btn\").attr(\"disabled\", \"disabled\");\n\t\t\t//$(\"#rec_ref option[value*=\'F\']\").prop(\'disabled\',true);\t\n\t\t\t//$(\"#dep_type option[value*=\'K\']\").prop(\'disabled\',true);\n\t\t\t$(\'#reference\').attr(\"disabled\",\"disabled\");\n\t\t\t$(\'#request_id\').hide();\n\t\t\t$(\"#reqcheck\").val(\"N\");\n\t\t\t$(\'#reqlabel\').hide();\t\n\t\t\t$(\'#accountcode\').hide();\n\t\t\t$(\'#act_code\').hide();\n\t\t\t$(\'#deptcode\').hide();\n\t\t\t$(\'#deptdesc\').hide();\n\t\t\t$(\"#dept_btn\").hide();\n\t\t\t$(\"#cusmandatory\").hide();\n\t\t\t//$(\"#document_number1\").hide();\n\t\t\t//$(\"#doclabel\").hide();\n\t\t\t$(\"#stlmt_amount\").val(\"\")\t;\n\t\t\t$(\"#dep_type option[value*=\'K\']\").remove();\n\t\t\n\t\t\t\n\t\t\t//parent.frames[1].document.forms[0].stlmt_amount.value=\"\";\n\t\t\t\t\n\t\t\t//var episode_type = formObj.episode_type.value;\n\t\t/*\tif($(\"#episode_type\").val()==\"O\" || $(\"#episode_type\").val()==\"R\")\n\t\t\t\t{\n\t\t\t\n\t\t\t\t$(\"#dep_type option[value*=\'K\']\").prop(\'disabled\',true);\n\t\t\t\t//$(\"#dep_type option[value*=\'S\']\").prop(\'disabled\',true);\n\t\t\t\t//$(\"#dep_type option[value*=\'N\']\").prop(\'disabled\',true);\n\t\t\t\t$(\"#dep_type option[value*=\'T\']\").prop(\'disabled\',true);\n\t\t\t\t$(\"#dep_type option[value*=\'O\']\").prop(\'disabled\',true);\n\t\t\t\t$(\"#dep_type option[value*=\'A\']\").prop(\'disabled\',true);\n\n\t\t\t\t}*/\n\t\t\t\t\n\t\t\t\n\t\t\tif($(\'#cusid\').val()==\"SHALM\" || ($(\'#cusid\').val()==\"MOHBR\"))\n\t\t\t\t{\n\t\t\t\t\n\t\t\t\t$(\'#act_code\').show();\n\t\t\t\t$(\'#accountcode\').show();\n\t\t\t\t$(\'#deptcode\').show();\n\t\t\t\t$(\'#deptdesc\').show();\n\t\t\t\t$(\"#dept_btn\").show();\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t$(\'#act_code\').hide();\n\t\t\t\t$(\'#accountcode\').hide();\n\t\t\t\t$(\'#deptdesc\').hide();\n\t\t\t\t$(\'#deptcode\').hide();\n\t\t\t\t$(\"#dept_btn\").hide();\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\n\t\t\tvar episode_type=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\t\t\t\n\t\t\t$(\"#episode_typ option[value!=\'\"+episode_type+\"\']\").prop(\'disabled\',true);\n  \n\t\t\t$(\"#trdowntypeentry\").hide();\n\t\t\t$(\"#totamt\").hide();\n\t\t\t$(\"#paidamt\").hide();\t\t\n\t\t\t   $(\"#splAgnDep\").hide();\n\t\t\t$(\"#totalbillamt\").hide();\n\t\t\t$(\"#billpaidamt\").hide();\n\t\t\t$(\"#depest\").hide();\t \n\t\t\t$(\"#DownTimeEntry\").change(function()\n\t\t\t{\n\t\t\t\t  \n\t\t if ($(this).is(\":checked\"))\n\t\t    {\t\t\t\t\n\t\t\t\t\n\t\t\t\t$(\"#trdowntypeentry\").show();\t\n\n\t\t\t\tif($(\'#rec_ref\').val() == \'R\'){\n\t\t\t\t\t$(\'#doc_type_number\').val($(\'#receiptDownCode\').val());\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\t$(\'#doc_type_number\').val($(\'#refundDownCode\').val());\n\t\t\t\t}\n\t\t\t}\t\n\t\t\t\t \n\t\t else\n\t\t\t{\n\t\t\t\t$(\"#trdowntypeentry\").hide();\n\t\t\t}\n\t\t});\t\n\t\t\t \n\t\t\t$(\"#rec_ref\").change(function() \n\t\t\t{\n\t\t\t\t\n\t\t\t\t if ($(\'#DownTimeEntry\').is(\":Checked\"))\n\t\t\t\t\t {\n\t\t\t\t\n\t\t\t\tif($(\'#rec_ref\').val() == \'R\'){\n\t\t\t\t\t$(\'#doc_type_number\').val($(\'#receiptDownCode\').val());\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\t$(\'#doc_type_number\').val($(\'#refundDownCode\').val());\n\t\t\t\t}\n\t\t\t\t\t }\n\t\t\t\t\n\t\t\t\tif($(this).val()!= \"F\") \n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t$(\"#doc_number\").val(\'\')\n\t\t\t\t\t$(\"#doc_num\").val(\'\');\n\t\t\t\t\t$(\"#documnumber\").val(\'\');\n\t\t\t\t\t$(\'#stlmt_amount\').val(\'\'); \n\t\t\t\t\t\n\t\t\t\t\t$(\"#doc_number\").attr(\"disabled\", \"disabled\");\n\t\t\t\t\t$(\"#doc_num\").attr(\"disabled\", \"disabled\");\n\t\t\t\t\t$(\"#documnumber\").attr(\"disabled\", \"disabled\");\n\t\t\t\t\t$(\"#doc_btn\").attr(\"disabled\", \"disabled\");\n\t\t\t\t\n\t\t\t\t\t $(\'#receipt_type_code\').removeAttr(\'readonly\');\n\t\t\t\t\t $(\'#receipt_desc\').removeAttr(\'readonly\');\n\t\t\t\t\t$(\'#rec_type\').removeAttr(\'disabled\');\n\t\t\t\n\t\t\t\t\t$(\'#receipt_type_code\').val(\'\');\n\t\t\t\t\t $(\'#receipt_desc\').val(\'\');  \n\t\t\t\t\t \n\t\t\t\t\t $(\'#receipt_nature_code\').removeAttr(\'readonly\');\n\t\t\t\t\t $(\'#receipt_nature\').removeAttr(\'readonly\');\n\t\t\t\t\t $(\'#receiptNatureBtn\').removeAttr(\'disabled\');\n\t\t\t\t\t $(\'#dep_type\').removeAttr(\'disabled\'); \n\t\t\t\t\t \n\t\t\t\t\t \n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t {    \n\t\t\t\t\t$(\"#doc_number\").removeAttr(\"disabled\");\n\t\t\t\t\t$(\"#doc_num\").removeAttr(\"disabled\");\n\t\t\t\t \t$(\"#documnumber\").removeAttr(\"disabled\");\n\t\t\t\t \t$(\"#doc_btn\").removeAttr(\"disabled\");\n\t\t\t\t \t$(\'#stlmt_amount\').val(\'\'); \n\t\t\t\t\t $(\'#receipt_type_code\').attr(\'readonly\', \'true\');\n\t\t\t\t\t $(\'#receipt_desc\').attr(\'readonly\', \'true\');\n\t\t\t\t\t$(\'#rec_type\').attr(\'disabled\',\'disabled\');\n\n\t\t\t\t\t$(\'#receipt_type_code\').val(\'\');\n\t\t\t\t\t $(\'#receipt_desc\').val(\'\');\n\t\t\t\t\t$(\'#remarks\').val(\'\');\n\t\t\t\t\t //$(\'#dep_type\').attr(\'disabled\',\'disabled\');\n\t\t\t\t\t \n\t\t\t\t }\n\t\t});\t\t\n\t\t\t\t\n\t\t\t  $(\"#rec_ref\").change(function() \n\t\t\t  {\n\t\t\t\t\trecref();\n\t\t\t\t\t\t\t\n\t\t});\n\t\t\t/*\t$(\"#receipt_nature_code\").blur(function() \n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\trecref();\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t}); */\n\t\t\n\t\t\t\t$(\"#receipt_type_code\").blur(function() \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif($(\"#rec_ref\").val()!=\"F\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\tremark();\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t}); \t\n\t\t\t\t\n\t\t});\n\t\t</script>\n\t\t</head>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'BL\'));\n\t\t\t\t\t//window.close();\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');\n\t\t\t\t\t//window.parent.returnValue=\"Y\";\n\t\t\t\t\t//window.close();\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\n<script>\n\t\t//window.parent.returnValue=\"Y\";\n\t\t//window.close();\n\t\tlet dialogBody = parent.parent.parent.document.getElementById(\'dialog-body\');\n\t\tdialogBody.contentWindow.returnValue = \"Y\";\n\t\t\n\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\tdialogTag.close(); \n\t\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<script>alert(getMessage(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'BL\'));\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<script>alert(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<script>\n\t\tvar v_collect=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'\n\t\tif(v_collect==\"N\")\n\t\t{\n\t\t\n\t\t\twindow.close();\n\t\t}\n\t\t</script>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'BL\'));\n\t\t\t\twindow.close();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<!-- alert(getMessage(\"BL1260\",\"BL\")); \n\t\t\t\t\t\t window.close();\n\t\t\t\t\t</script>-->\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'BL\'));\n\t\t\t\t//window.close();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25_0 ="\n\n\t<script>\n\t\n\t /*document.getElementById(\"depest\").onclick = function () {\n\t\n\t\t location.href = \"EstimateForDeposit.jsp\";\n\t    };\n\t   */ \n\tasync function estdep()\n{\n\t\t // alert(\'episode_id\'+episode_id);\n\n\tvar formObj=document.EnterReceiptRefundForm;\n\tvar patient_id=formObj.patient_id.value;\n\tvar episode_id=formObj.episode_id.value;\n\tvar episode_type=formObj.episode_type.value;\n\tvar encounter_id=formObj.encounter_id.value;\n\tvar visit_id=formObj.visit_id.value;\n\t\n\t\n\tvar url=\"../../eBL/jsp/Esmfordeposit.jsp?patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&encounter_id=\"+encounter_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id;\n\t\n\tvar dialogHeight= \"55vh\" ;\n\tvar dialogWidth\t= \"86vw\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status: \" + status + \"; scroll=auto; center:yes\";\n\tvar retVal =await window.showModalDialog(url,null,features);  \n\tvar stlmt_amnt=formObj.stlmt_amount.value;\n\tif(retVal==\'undefined\' || retVal==undefined)\n\t\t{\n\t\tformObj.stlmt_amount.value =stlmt_amnt;\n\t\t}\n\telse\n\t\t{\n\tformObj.stlmt_amount.value = retVal;\n\t\t}\n\t\n}\n\tasync function splAgencyDeposit()\n\t{\n\t\t//alert(\"splAgencyDeposit call\");\n\t\t\n\t\tif($(\"#cusid\").val()==\"SHALM\" || $(\"#cusid\").val()==\"MOHBR\")\n\t\t\t{\n\t\tif(document.getElementById(\"dept_desc\").value==null || document.getElementById(\"dept_desc\").value==\"\" ){\n\t\t\talert(\"Department code cannot be blank\");\n\t\t\treturn;\n\t\t}\n\t\t\t}\n\t\tvar facilityId=document.forms[0].facility_id.value;\n\t\tvar patientId=document.forms[0].patient_id.value;\n\t\tvar episodeType=document.forms[0].episode_type.value;\n\t\t\n\t\t//alert(\"facilityId / patientId / episodeType ::: \"+facilityId+\" / \"+patientId+\" / \"+episodeType);\n\t\t\n\t\tvar url=\"../../eBL/jsp/SplAgencyDeposit.jsp?facilityId=\"+facilityId+\"&patientId=\"+patientId+\"&episodeType=\"+episodeType+\"&effFromDt=\"+document.forms[0].splAgnEffFrom.value+\"&effToDt=\"+document.forms[0].splAgnEffTo.value;\n\t\t\n\t\tvar dialogHeight= \"30\" ;\n\t\tvar dialogWidth\t= \"65\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status: \" + status + \"; scroll=auto; center:yes\";\n\t\tvar retVal =await window.showModalDialog(url,null,features);  \n\t\t//alert(\"retVal\"+retVal);\n\t\tvar dataArr = $.trim(retVal).split(\"::\"); \t\n\t\tdocument.forms[0].splAgnEffFrom.value=dataArr[1];\n\t\tdocument.forms[0].splAgnEffTo.value=dataArr[2];\n\t\t\n\t\t\t\n\t\t}\n\n\nasync function DocNoLookup()\n\t\t{\n\t\t\t\t\n\t\tvar retVal\t\t\t= new String();\t\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar sql3\t\t\t\t= \"\";\t\t\n\t\tvar locale = document.forms[0].locale.value;\n\t\tvar facility_id = document.forms[0].facility_id.value;\n\t\tacc_entity_code\t= \'ZZ\';\t\n\t\trecpt_refund_ind = document.forms[0].recpt_refund_ind.value;\n\t\trcpt_ip_allowed_yn = document.forms[0].rcpt_ip_allowed_yn.value;\n\t\trcpt_op_allowed_yn = document.forms[0].rcpt_op_allowed_yn.value;\n\t\trcpt_ref_allowed_yn = document.forms[0].rcpt_ref_allowed_yn.value;\n\t\trfnd_ip_allowed_yn = document.forms[0].rfnd_ip_allowed_yn.value;\n\t\trfnd_op_allowed_yn = document.forms[0].rfnd_op_allowed_yn.value; \n\t\trfnd_ref_allowed_yn = document.forms[0].rfnd_ref_allowed_yn.value;\n\t\trfnd_allowed_yn = document.forms[0].rfnd_allowed_yn.value;\n\t\trcpt_allowed_yn = document.forms[0].rcpt_allowed_yn.value;\t\t \n\t\t\n\n\n\t\tvar title=\"doc no look up\";\n\t\tvar column_sizes = escape(\"15%,10%,10%,10%\");\n\t\tdesc=\"decription\";\n\t\tcode=\"code\";\n\t\tvar column_descriptions =desc+\",\"+code; \n\t\tvar message = \'\';\t\n\t\tsql3=\"SELECT B.SHORT_DESC short_desc, A.DOC_TYPE_CODE doc_type_code FROM BL_TRN_DOC_TYPE A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND   UPPER(LANGUAGE_ID) = UPPER(\'\"+locale+\"\') AND A.ACC_ENTITY_CODE = \'ZZ\' and a.operating_facility_id = \'\"+facility_id+\"\'  and ((a.ENTITY_OR_FACILITY_BASED= \'F\' and substr(a.doc_type_code,1,2)= \'\"+facility_id+\"\' ) or (a.ENTITY_OR_FACILITY_BASED= \'E\' and  A.ACC_ENTITY_CODE =  \'ZZ\')) AND ((A.TRX_TYPE_CODE = \'5\' AND \'\"+recpt_refund_ind+\"\' = \'R\' AND (\'\"+rcpt_op_allowed_yn+\"\' = \'Y\' OR \'\"+rcpt_ip_allowed_yn+\"\' = \'Y\' OR \'\"+rcpt_ref_allowed_yn+\"\'  = \'Y\') AND\t\'\"+rcpt_allowed_yn+\"\' = \'Y\') OR (A.TRX_TYPE_CODE = \'6\' AND \'\"+recpt_refund_ind+\"\' = \'F\' AND (\'\"+rfnd_op_allowed_yn+\"\' = \'Y\'  OR \'\"+rfnd_ip_allowed_yn+\"\' = \'Y\'  OR \'\"+rfnd_ref_allowed_yn+\"\' = \'Y\') AND \'\"+rfnd_allowed_yn+\"\' = \'Y\'))\";\n\t\t sql = escape(sql3);\t\n\t\t var param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(\'\')+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYYY\";\n\t\t retVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t \n\t\t var arr=new Array();\n\t\t if(retVal == null) retVal=\'\';\n\t\t if (retVal != null || retVal!=\"\")\n\t\t {\n\t\t\t if(retVal!=\'undefined\' && retVal!=undefined)\n\t\t\t{\n\t\t\t var retVal=unescape(retVal);\t\t \n\t\t\t\t if(retVal != null && retVal.length>0)\n\t\t\t\t\t{\n\t\t\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\t\t\tdocument.forms[0].doc_type_number.value=arr[0];\t\t\t\t\n\t\t\t\t\tdocument.forms[0].document_number.value=arr[1];\t\t\t\t  \n\t\t\t\t\t}\n\t\t\t }\n\t\t}\n\t\n\t}\nasync function reasonLookup()\n{\n\t\tvar target\t\t\t= document.forms[0].reason;\t\t\n\t\tvar retVal\t\t\t=  new String();\n\t\tvar dialogTop\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar title =\"Reason\"\n\t\t//var title = encodeURIComponent(title);\t\t\n\t\tvar locale  = document.forms[0].locale.value;\t\t\t\n\t\tvar sql2=\"SELECT  a.action_reason_code code ,a.action_reason_desc description FROM   bl_action_reason_lang_vw a where nvl(status,\'!\') != \'S\'and upper(language_id) = upper(\'en\')and exists (select action_type from bl_action_reason_by_type b where b.action_type = \'DT\' AND    NVL(b.active_yn, \'N\') = \'Y\') and upper(a.action_reason_code) like upper (?) and upper(a.action_reason_desc) like upper(?) order by 1\";\n\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql2;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\n\t\targArray[5] = target.value;\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = DESC_CODE;\t\t\n\t\tretArray = await CommonLookup( title, argArray );\n\n\t\t\tvar ret1=unescape(retArray);\n\t\t \tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t} \t\t\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\t\t\n\t\t\t//alert(retArray[0]);\n\t\t\tdocument.forms[0].reason.value=arr[1];\t\t\t\n\t\t\t\n\t\t}\n\t}\t\n\n\tasync function origdocLookup()\n\t\t{\n\t\tvar target\t\t\t= document.forms[0].reason;\t\t\n\t\tvar retVal\t\t\t=  new String();\n\t\tvar dialogTop\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar title =\"Reason\"\n\t\t//var title = encodeURIComponent(title);\t\t\n\t\tvar locale  = document.forms[0].locale.value;\t\t\t\n\t\tvar sql2=\"SELECT a.BLNG_SERV_CODE code, a.SHORT_DESC description FROM BL_BLNG_SERV_LANG_VW a where nvl(status,\'!\') != \'S\'and upper(language_id) = upper(\'en\') and upper(a.BLNG_SERV_CODE) like upper (?) and upper(a.SHORT_DESC) like upper(?) order by 1\";\n\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql2;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\n\t\targArray[5] = target.value;\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = DESC_CODE;\t\t\n\t\tretArray = await CommonLookup( title, argArray );\n\t\t\n\t\tvar ret1=unescape(retArray);\n\t\t \tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t} \n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\t\t\n\t\t\t//alert(retArray[0]);\n\t\t\tdocument.forms[0].original_doc_no.value=arr[1];\t\t\t\n\t\t\t\n\t\t}\n\t}\t\n\n\tasync function deptLookup(click_event)\n\t{\n\t\tvar target\t= document.forms[0].dept_desc;\n\t\tif(click_event == \'B\')\n\t\t{\n\t\t\tif(document.forms[0].dept_desc.value == \"\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].dept_desc.value = \"\";\n\t\t\t\tdocument.forms[0].ext_acc_dept_code.value = \"\";\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\t\tvar retVal\t\t\t= new String();\t\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\n\t\tvar locale = document.forms[0].locale.value;\n\t\tvar facility_id = document.forms[0].facility_id.value;\n\n\t\tvar title=getLabel(\"Common.department.label\",\"common\");\n\t\ttitle=encodeURIComponent(title);\t\n\n\t\tvar column_sizes = escape(\"30%,70%\");\n\t\t\n\t\tvar code=getLabel(\"Common.code.label\",\"common\");\n\t\tcode=encodeURIComponent(code);\t\n\t\t\n\t\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\t\tdesc=encodeURIComponent(desc);\n\n\t\tvar column_descriptions = code+\",\"+desc;\n\t\tvar message = \'\';\n\t\t\n\t\tsql=\"select dept_code DEPT_CODE,short_desc SHORT_DESC from sy_dept_LANG_VW where nvl(status,\'x\') != \'S\' AND UPPER(LANGUAGE_ID) = UPPER(\'\"+locale+\"\') and operating_facility_id = \'\"+facility_id+\"\'\";\t\t\n\n\t\tsql = escape(sql);\t\t\n\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\n\t\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\t\t\n\t\tvar arr=new Array();\n\t\tif(retVal == null || retVal == \"undefined\" || retVal == undefined) retVal=\"\";\n\t\tif (retVal != \"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\t\t \n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\t\tdocument.forms[0].ext_acc_dept_code.value=arr[0];\t\t\t\t\n\t\t\t\tdocument.forms[0].dept_desc.value=arr[1];\t\t\t\t  \n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].ext_acc_dept_code.value=\"\";\n\t\t\tdocument.forms[0].dept_desc.value=\"\";\n\t\t}\n\t}\n\n\tasync function custLookup()\n\t{\n\t\tvar retVal\t\t\t= new String();\t\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar sql3\t\t\t\t= \"\";\t\t\n\t\tvar locale = document.forms[0].locale.value;\n\t\tvar fac";
    private final static byte[]  _wl_block25_0Bytes = _getBytes( _wl_block25_0 );

    private final static java.lang.String  _wl_block25_1 ="ility_id = document.forms[0].facility_id.value;\n\t\tvar title=\"Department\";\n\t\tvar column_sizes = escape(\"15%,10%,10%,10%\");\n\t\tdesc=\"decription\";\n\t\tcode=\"code\";\n\t\tvar column_descriptions =desc+\",\"+code; \n\t\tvar message = \'\';\t\n\t\tsql3=\"select cust_code,decode(nvl(chinese_reporting_flag,\'N\'), \'N\', long_name, long_name_chinese) from ar_customer_lang_vw where nvl(status,\'X\') != \'S\'AND   UPPER(LANGUAGE_ID) = UPPER(\'\"+facility_id+\"\') and acc_entity_code in ( select acc_entity_code from sy_acc_entity where acc_entity_id = \'\"+facility_id+\"\' ) \";\n\t\tprompt(\" \",sql3); \n\t\tsql = escape(sql3);\t\n\t\t var param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(\"\")+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYYY\";\n\t\t retVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t \n\t\t var arr=new Array();\n\t\t if(retVal == null) retVal=\'\';\n\t\t if (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\t if(retVal!=\'undefined\' && retVal!=undefined)\n\t\t\t{\n\t\t\t var retVal=unescape(retVal);\t\t \n\t\t\t if(retVal != null && retVal.length>0)\n\t\t\t  {\n\n\t\t\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\t\t\tdocument.forms[0].cust_code.value=arr[0];\t\t\t\t\n\t\t\t\t\tdocument.forms[0].cust_desc.value=arr[1];\t\t\t\t  \n\t\t\n\t\t\t  }\n\t\t\t}\n\t\t}\n\t}\n\tasync function ReceiptTypeLookup(click_event)\n\t{\n\t\tvar ext_acc_int_YN = document.forms[0].ext_acc_int_YN.value;\n\n\t\tif(click_event == \'B\')\n\t\t{\n\t\t\tif(document.forms[0].receipt_type.value == \"\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].receipt_type.value = \"\";\n\t\t\t\tdocument.forms[0].receipt_code.value = \"\";\n\t\t\t\tif(ext_acc_int_YN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].ext_acc_code.value = \"\";\n\t\t\t\t\tdocument.forms[0].ext_acc_dept_code.value = \"\";\n\t\t\t\t\tdocument.forms[0].dept_desc.value = \"\";\n\t\t\t\t\tdocument.forms[0].dept_desc.disabled = true;\n\t\t\t\t\tdocument.forms[0].dept_btn.disabled = true;\n\t\t\t\t}\n\t\t\t\treturn;\n\t\t\t}\n\t\t\t\n\t\t}\n\t\tvar retVal\t\t\t= new String();\t\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar sql3\t\t\t\t= \"\";\t\t\n\t\tvar locale = document.forms[0].locale.value;\n\t\tvar facility_id = document.forms[0].facility_id.value;\t\n\t\tvar reln_code = document.forms[0].reln_code.value;\n\t\tvar episode_type = document.forms[0].episode_type.value;\n\n\t\tvar title=getLabel(\"eBL.RECEIPT_TYPE.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar column_sizes = escape(\"20%,80%\");\n\t\tvar code=getLabel(\"Common.code.label\",\"common\");\n\t\tvar desc=getLabel(\"Common.description.label\",\"common\");\t\n\t\tdesc=encodeURIComponent(desc);\n\t\tvar column_descriptions = code+\",\"+desc; \n\t\tvar message = \'\';\t\n\t\t/*****ADDED function_id CHECK  FOR PACKAGE BILLING*******/\n\t\t\tvar function_id=document.forms[0].function_id.value;\n\t\t/*if(function_id==\"PKG_BILLING\")\n\t\t{\n\t\t\tsql3=\"select receipt_type_code code,long_desc description from bl_receipt_type_lang_vw where nvl(status,\'x\') != \'S\' AND   UPPER(LANGUAGE_ID) = UPPER(\'\"+locale+\"\') and ADDED_FACILITY_ID = \'\"+facility_id+\"\' and RECPT_NATURE_CODE=\'PK\' and((\'\"+ext_acc_int_YN+\"\' = \'Y\' and receipt_type_code in (select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code =\'PK\' and nvl(status,\'X\') <> \'S\'\tand ((\'PK\' not in (\'BI\',\'DC\') and episode_type IN (\'U\',\'\"+episode_type+\"\') and category IN (\'\"+reln_code+\"\',\'UNRESTRICTED\'))))) or \'\"+ext_acc_int_YN+\"\' = \'N\')\";\n\t\t\tsql3=\"SELECT * FROM BL_RECEIPT_TYPE_lang_vw WHERE RECEIPT_TYPE_CODE IN (SELECT pat_dep_for_pkg FROM bl_parameters WHERE operating_facility_id=\'\"+facility_id+\"\') ANDUPPER(LANGUAGE_ID) = UPPER(\'\"+locale+\"\') AND acc_entity_code= (SELECT ACC_ENTITY_CODE FROM sy_Acc_entity WHERE ACC_ENTITY_ID=\'\"+facility_id+\"\')\";\n\n\t\t}else{*/\n\t/*\tCommented against incident 41239  on  4/7/2013\n\t\t\n\tsql3=\"select receipt_type_code code,long_desc description from bl__lang_vw where nvl(status,\'x\') != \'S\' AND   UPPER(LANGUAGE_ID) = UPPER(\'\"+locale+\"\') and ADDED_FACILITY_ID = \'\"+facility_id+\"\' and RECPT_NATURE_CODE=\'AD\' and((\'\"+ext_acc_int_YN+\"\' = \'Y\' and receipt_type_code in (select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code =\'AD\' and nvl(status,\'X\') <> \'S\'\tand ((\'AD\' not in (\'BI\',\'DC\') and episode_type IN (\'U\',\'\"+episode_type+\"\') and category IN (\'\"+reln_code+\"\',\'UNRESTRICTED\'))))) or \'\"+ext_acc_int_YN+\"\' = \'N\')\";\n\t*/\n\n\t\t\tsql3=\"select receipt_type_code code,long_desc description from bl_receipt_type_lang_vw where nvl(status,\'x\') != \'S\' AND   UPPER(LANGUAGE_ID) = UPPER(\'\"+locale+\"\')  and ACC_ENTITY_CODE in (select ACC_ENTITY_ID from   SM_ACC_ENTITY_PARAM_FACL where FACILITY_ID =\'\"+facility_id+\"\' ) and RECPT_NATURE_CODE=\'AD\' and((\'\"+ext_acc_int_YN+\"\' = \'Y\' and receipt_type_code in (select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code =\'AD\' and nvl(status,\'X\') != \'S\'\tand ((\'AD\' not in (\'BI\',\'DC\') and episode_type IN (\'U\',\'\"+episode_type+\"\') and category IN (\'\"+reln_code+\"\',\'UNRESTRICTED\'))))) or \'\"+ext_acc_int_YN+\"\' = \'N\')\";\n\n\n\t\t//}\n\n\t\tsql = escape(sql3);\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(document.forms[0].value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\t\t retVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t \n\t\tvar arr=new Array();\n\n\t\tif(retVal == null || retVal==\"undefined\" || retVal==undefined) retVal=\"\";\n\t\tif (retVal != \"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\t\t \n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\t\tdocument.forms[0].receipt_code.value=arr[0];\t\t\t\t\n\t\t\t\tdocument.forms[0].receipt_type.value=arr[1];\t\t\t\t  \n\t\t\t}\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].receipt_code.value=\"\";\t\t\t\t\n\t\t\tdocument.forms[0].receipt_type.value=\"\";\t\t\t\t  \n\t\t}\n\n\t\tif(document.forms[0].receipt_code.value != \"\" && ext_acc_int_YN == \"Y\")\n\t\t{\n\t\t\tvar patient_id=document.forms[0].patient_id.value;\n\n\t\t\tvar episode_type=document.forms[0].episode_type.value;\n\t\t\tvar episode_id=document.forms[0].episode_id.value;\n\t\t\tvar visit_id=document.forms[0].visit_id.value;\n\t\t\tvar encounter_id=document.forms[0].encounter_id.value;\n\t\t\tvar rcpt_nat_code=document.forms[0].receipt_nature_code.value;\n\t\t\tvar rcpt_type_code=document.forms[0].receipt_code.value;\n\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\n\t\t\tvar param=\"patient_id=\"+patient_id+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&encounter_id=\"+encounter_id+\"&rcpt_nat_code=\"+rcpt_nat_code+\"&rcpt_type_code=\"+rcpt_type_code;\n\n\t\t\tvar temp_jsp=\"../../eBL/jsp/BLEnterReceiptRefundValidation.jsp?\"+param;\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tresponseText=trimString(xmlHttp.responseText);\n\n\t\t\tvar retVal = responseText.split(\"&^&\");\n\n\t\t\tvar srch_status = retVal[0];\n\n\t\t\tif(srch_status == \'E\') // Error Txt\n\t\t\t{\n\t\t\t\t//alert(retVal[1]);\n\t\t\t\tdocument.forms[0].ext_acc_code.value = \"\";\n\t\t\t\tdocument.forms[0].ext_acc_dept_code.value = \"\";\n\t\t\t\tdocument.forms[0].dept_desc.value = \"\";\n\t\t\t\tdocument.forms[0].dept_desc.disabled = true;\n\t\t\t\tdocument.forms[0].dept_btn.disabled = true;\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse if(srch_status == \'M\') // Message\n\t\t\t{\n\t\t\t\talert(getMessage(retVal[1],\"BL\"));\n\t\t\t\tdocument.forms[0].ext_acc_code.value = \"\";\n\t\t\t\tdocument.forms[0].ext_acc_dept_code.value = \"\";\n\t\t\t\tdocument.forms[0].dept_desc.value = \"\";\n\t\t\t\tdocument.forms[0].dept_desc.disabled = true;\n\t\t\t\tdocument.forms[0].dept_btn.disabled = true;\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse if(srch_status == \'Y\') // External Acc Code found\n\t\t\t{\n\t\t\t\tdocument.forms[0].ext_acc_facility_id.value = retVal[1];\n\t\t\t\tdocument.forms[0].ext_acc_code.value = retVal[2];\n\t\t\t\tvar ext_dept_ind = retVal[3];\n\t\t\t\tdocument.forms[0].ext_dept_ind.value = ext_dept_ind;\n\t\t\t\tif(ext_dept_ind == \"E\") // Enterable\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].dept_desc.value = \"\";\n\t\t\t\t\tdocument.forms[0].ext_acc_dept_code.value = \"\";\n\t\t\t\t\tdocument.forms[0].dept_desc.disabled = false;\n\t\t\t\t\tdocument.forms[0].dept_btn.disabled = false;\n\t\t\t\t}\n\t\t\t\telse if(ext_dept_ind == \"S\") // From Source Location\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].ext_acc_dept_code.value = retVal[4];\n\t\t\t\t\tdocument.forms[0].dept_desc.value = retVal[5];\n\t\t\t\t\tdocument.forms[0].dept_desc.disabled = true;\n\t\t\t\t\tdocument.forms[0].dept_btn.disabled = true;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction enableall()\n\t{\n\t\tvar checked_key=document.forms[0].down_town_entry.checked;\n\t\tif(checked_key==true)\n\t\t{\n\t\t\tdocument.forms[0].doc_no_desc.readOnly=false;\n\t\t\tdocument.forms[0].doc_no_desc.value=down_time_rcpt_doc_type;\n\t\t\tdocument.forms[0].doc_no.readOnly=false;\n\t\t\t//document.forms[0].doc_date.readOnly=false;\n\t\t\tdocument.forms[0].reason.readOnly=false;\n\t\t\tdocument.forms[0].doc_btn.disabled=false;\n\t\t\tdocument.forms[0].reason_btn.disabled=false;\t\t\t\n\t\t\tdocument.getElementById(\'cal_img_id\').style.display=\'inline\';\n\n\n\t\t}\n\t\telse{\n\t\t\tdocument.forms[0].doc_no_desc.readOnly=true;\n\t\t\tdocument.forms[0].doc_no.readOnly=true;\n\t\t\t//document.forms[0].doc_date.readOnly=true;\n\t\t\tdocument.forms[0].reason.readOnly=true;\n\t\t\tdocument.forms[0].doc_btn.disabled=true;\n\t\t\tdocument.forms[0].reason_btn.disabled=true;\t\t\t\n\t\t\tdocument.getElementById(\'cal_img_id\').style.display=\'none\';\n\t\t}\n\t}\n\n\tfunction callOriDoc()\n\t{\n\t\tvar rec_refnd_ind=document.forms[0].rec_refnd_ind.value;\n\t\tif(rec_refnd_ind==\'refund\')\n\t\t{\n\t\t\tdocument.getElementById(\'ori_doc_btn_id\').style.display=\'inline\';\n\t\t}\n\t\telse{\n\t\t\t\tdocument.getElementById(\'ori_doc_btn_id\').style.display=\'none\';\n\t\t}\n\t}\n\n\tfunction validDateChk()\n\t{\t\n\t\tvar locale = document.forms[0].locale.value;\n\t\tvar noodDays = document.forms[0].downTimeAllowDays.value;\t\t\n\t\tvar fromDate = document.forms[0].doc_date.value;\n\t\tvar currDate = getCurrentDate(\'DMYHM\',locale);\n\t\tvar daysB = daysBetween(fromDate,currDate,\'DMYHM\',locale);\t\t\n\t\tif(fromDate>currDate)\n\t\t{\n\t\t\talert(\"Date cannot be greater then sysdate\");\n\t\t\tdocument.forms[0].doc_date.select();\t\t\n\t\t}\n\t\t\tif(daysB>noodDays)\n\t\t\t{\t\t\t\t\n\t\t\t\talert(\"Downtime Entry more then 2 days is not allowed\"); \t\t\t\t\n\t\t\t\tdocument.forms[0].doc_date.select();\n\t\t\t}\n\t}\n\n\tasync function funBLStmt()\n\t{\n\t\tvar retVal = new Array();\n\t\tvar billdoctype= \'HSBLOP\';  //document.forms[0].billdoctypecode.value;\t\n\t\tvar billdocnum=\'1658\'   //document.forms[0].billdocnum.value;\t\n\t\tvar blnggrp=\"CA\";\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"100\";\n\t\tvar dialogHeight = \"40\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\"";
    private final static byte[]  _wl_block25_1Bytes = _getBytes( _wl_block25_1 );

    private final static java.lang.String  _wl_block25_2 =";status=no\" ;\n\t\tvar title=\"\";\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billdoctypecode=\"+billdoctype+\"&\"+\"billdocnum=\"+billdocnum+\"&\"+\"blnggrp=\"+blnggrp;\n\t\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMain.jsp?\"+param,arguments,features);\n\t\t\n\t}\n\n\tfunction putdeci(object)\n\t{\n\t\tif(object.value!=\'\')\n\t\t{\n\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\tputDecimal(object,17,decimal);\n\t\t}\n\t}\n\tfunction setAmt(billpayableamt)\n\t\t{\n\t\t \t}\n\n\n\t\tfunction setDepType()\n\t\t{\n\t\t\t\t\t\t\t\n\t\t\tvar function_id = document.forms[0].function_id.value;\n\t\t\t\t\t\t\n\t\t\tif (function_id!=\"PKG_BILLING\")\n\t\t\t{\t\t\t\n\t\t\tvar tot_adm_dep_amt=document.forms[0].tot_adm_dep_amt.value;\n\t\t\tvar tot_trf_dep_amt=document.forms[0].tot_trf_dep_amt.value;\n\t\t\tvar tot_othr_dep_amt=document.forms[0].tot_othr_dep_amt.value;\n\t\t\t\n\t\t\tif(parseFloat(tot_adm_dep_amt)>0)\n\t\t\t{\n\t\t\t\t\n\t\t\t\tdocument.forms[0].dep_type.selectedIndex=1;\n\t\t\t\tdocument.forms[0].stlmt_amount.value=tot_adm_dep_amt;\n\t\t\t}\n\t\t\telse if(parseFloat(tot_trf_dep_amt)>0)\n\t\t\t{\n\t\t\t\t\tdocument.forms[0].dep_type.selectedIndex=2;\n\t\t\t\t\tdocument.forms[0].stlmt_amount.value=tot_trf_dep_amt;\n\t\t\t}\n\t\t\telse if(parseFloat(tot_othr_dep_amt)>0)\n\t\t\t\t{\n\t\t\t\t\n\t\t\t\tdocument.forms[0].dep_type.selectedIndex=3;\n\t\t\t\t\tdocument.forms[0].stlmt_amount.value=tot_othr_dep_amt;\n\t\t\t}\n\t\t\telse{\n\t\t\t\t\n\t\t\t\tdocument.forms[0].dep_type.selectedIndex=0;\n\t\t\t\t\t//document.forms[0].stlmt_amount.value=\"\";\n\t\t\t\t}\n\t\t\t\t/***************Added function id check PACKAGE BILING**********************************/\n\t\t\t}else{\n\t\t\t\t\n\t\t\t\t\t//var pkgAmount=document.forms[0].pkgAmount.value;\tram\t\t\t\t \n\t\t\t\t\tvar tot_package_amt=document.forms[0].tot_package_amt.value;\t\n\t\t\t\t\tvar d_tot_package_amt=document.forms[0].d_tot_package_amt.value;\t\t\t\t\t \t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].stlmt_amount.value=d_tot_package_amt;\n\n\t\t\t\t\t//var amt_temp=(\"document.forms[0].stlmt_amount\");\n\t\t\t\t\t//putdeci(amt_temp);\n\t\t\t\t}\n\t\t}\n\t\tfunction listChange()\n\t\t{\n\t\t\tdocument.forms[0].stlmt_amount.value=\"\";\n\t\t\tvar tot_adm_dep_amt=document.forms[0].tot_adm_dep_amt.value;\n\t\t\tvar tot_trf_dep_amt=document.forms[0].tot_trf_dep_amt.value;\n\t\t\tvar tot_othr_dep_amt=document.forms[0].tot_othr_dep_amt.value;\n\t\t\tif(document.forms[0].dep_type.value==\'A\' && parseFloat(tot_adm_dep_amt)>0)\n\t\t\t{\n\t\t\t\n\t\t\t\tdocument.forms[0].stlmt_amount.value=tot_adm_dep_amt;\n\t\t\t\tvar slmt_amt1=eval(\"document.forms[0].stlmt_amount\");\n\t\t\t\tputdeci(slmt_amt1);\n\t\t\t}\n\t\t\telse if(document.forms[0].dep_type.value==\'T\' && parseFloat(tot_trf_dep_amt)>0)\n\t\t\t{\t\t\t\n\t\t\t\t\tdocument.forms[0].stlmt_amount.value=tot_trf_dep_amt;\n\t\t\t}\n\t\t\telse if(document.forms[0].dep_type.value==\'O\' && parseFloat(tot_othr_dep_amt)>0)\n\t\t\t\t{\t\t\t\n\t\t\t\t\n\t\t\t\t\tdocument.forms[0].stlmt_amount.value=tot_othr_dep_amt;\n\t\t\t}\n\t\t\telse if(document.forms[0].dep_type.value==\'P\')\n\t\t\t{\t\t\t\n\t\t\t\t\n\t\t\t\t\tdocument.forms[0].stlmt_amount.value=\'";
    private final static byte[]  _wl_block25_2Bytes = _getBytes( _wl_block25_2 );

    private final static java.lang.String  _wl_block26 ="\';\n\t\t\t}\n\t\t\telse{\n\t\t\t\t\n\t\t\t\t\tdocument.forms[0].stlmt_amount.value=\"\";\n\n\t\t\t}\n\t\t}\n\n/*******************FUNCTION ADDED FOR PACKAGE BILLING*************************/\n\tfunction setAmtpkg(obj,function_id)\n\t\t{\t\t\t\n\t\t\tvar partial_dep_yn = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\t\t\t\n\t\t\tvar min_dep_amt = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\t\t\t\n\t\t\tvar tot_min_dep_amt = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\t\t\t\n//\t\t\tvar pkgamt=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t//var pkgamt=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t//\tif(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'!=\"\"){\n\t\t//\tvar pkgamt=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t//}else{\n\t\t\tvar pkgamt=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t//}\n\t\t\tvar pkgamtfld=obj.value;\t\n\n\t\t\t/*if(partial_dep_yn ==\"N\")\n\t\t\t{\n\t\t\t\tif(parseInt(pkgamtfld)  < parseInt(pkgamt)){\n\t\t\t\talert(\"For this Package Partial deposit not allowed\");\n\t\t\t\tobj.select();\n\t\t\t\t}\n\n\t\t\t}else{\n\t\t\t\tif(parseInt(pkgamtfld)  < parseInt(min_dep_amt)){\n\t\t\t\t\talert(\"Package Deposit Must be equal to min. deposit Amount\"+\"=\"+min_dep_amt);\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}*/\n\t\t\t//Added for MMS-DM-SCF-0013\n\t\t\tvar minMandAmtFinal = parent.frames[4].document.forms[0].totMinDeposit.value;\n\t\t\tvar minMandAmtDtl = document.forms[0].totMinDepositDtl.value;\n\t\t\tvar derivedFromDtl = document.forms[0].derivedFromDtl.value;\n\t\t\t//In Details page if value is Y then override this page value\n\t\t\tif(derivedFromDtl == \'Y\'){\n\t\t\t\tminMandAmtFinal = minMandAmtDtl;\n\t\t\t}\n\t\t\ttot_min_dep_amt = parseFloat(tot_min_dep_amt) - parseFloat(minMandAmtFinal);\n\t\t\t//Added for MMS-DM-SCF-0013\n\t\t\tif (parseInt(pkgamtfld)  > parseInt(pkgamt))\n\t\t\t{\n\t\t\t\t//alert(\"Amount should not be greater than Package Amount\"+pkgamt);\n\t\t\t\talert(getMessage(\"BL8660\",\"BL\")+\':\'+pkgamt);\n\t\t\t\tobj.select();\n\n\t\t\t}else if(parseFloat(pkgamtfld)<parseFloat(tot_min_dep_amt))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL8658\",\"BL\")+\':\'+tot_min_dep_amt);\n\t\t\t\tobj.select();\n\t\t\t}else{\n\t\t\t\tsetAmt(obj);\n\t\t\t}\n\n\t\t}\n\t\t\n\t\t\n\n\t</script>\n\t\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\n<BODY onLoad=\"defaultReceipttype(\'rcptnature\');\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\">\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<BODY onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\">\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n<!--  onLoad=\"setDepType();\" -->\n<FORM name=\'EnterReceiptRefundForm\' id=\'EnterReceiptRefundForm\' action=\"\" method=\'\'>\t\n\n\t<!--<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\t\n\t <tr>\n\t  <td class=\"label\" width=\"25%\"><b>Down Town Entry</b>\n\t  <input type=\'checkbox\' name=\'down_town_entry\' id=\'down_town_entry\' size=\'5\'  maxlength=\'5\' value=\"\" onclick=\"enableall()\"></td>\n\t  <td width=\"25%\"  class=\'labels\'>\n\t  <td width=\"25%\"  class=\'labels\'>\n\t  <td width=\"25%\"  class=\'labels\'>\n\n\t  </tr>\n\t  <tr> \n\t  \n\t\t <td class=\"label\" width=\"25%\">Document No\n\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'doc_no_desc\' id=\'doc_no_desc\' size=\'15\' maxlength=\'15\'   value=\'\'  onBlur=\"\" readonly>/<input type=\'text\' name=\'doc_no\' id=\'doc_no\' size=\'10\' maxlength=\'10\'   value=\'\'  onBlur=\"\" readonly><input type=\'button\' class=\'button\' name=\"doc_btn\" id=\"doc_btn\"   value=\'?\'  tabindex=\'0\' onClick=\'DocNoLookup()\' disabled>\n\t\t<input type= \'hidden\' name=\"doc_no_code\" id=\"doc_no_code\"  value=\"\">\n\t\t<td class=\"label\" width=\"10%\">Date<input type=\'text\' name=\'doc_date\' id=\'doc_date\' size=\'10\' maxlength=\'10\' value=\'\'  onBlur=\"validDateChk();\" ><div id=\'cal_img_id\' style=\'display:none\'><input name=\'cal_btn\' id=\'cal_btn\' type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'doc_date\',null,\'hh:mm\');\" style=\'cursor:pointer\' ></div></td>\n\t\t <td class=\"label\" width=\"15%\">Reason<input type=\'text\' name=\'reason\' id=\'reason\' size=\'15\' maxlength=\'15\'  value=\'\'  onBlur=\"\" readonly><input type=\'button\' class=\'button\' name=\"reason_btn\" id=\"reason_btn\"   value=\'?\'  tabindex=\'0\' onClick=\'reasonLookup()\' disabled></td>\n\t\t</tr>\n\t  <tr> </tr>\t  <tr> </tr>\n\t</table>-->\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\t\n\t\t<table>\n\t\t<tr>\n\t\t <td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<input type=\"checkbox\" id=\'DownTimeEntry\' name=\"DownTimeEntry\" id=\"DownTimeEntry\" value=\'\'  >\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t<table>\n\t\t<tr name=\"trdowntypeentry\" id=\"trdowntypeentry\">\n\t\t<td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t</td>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t<td  width=\"5%\"> \n\t\t<input type=\'text\' name=\'doc_type_number\' id=\'doc_type_number\' id=\'doc_type_number\' size=\'10\' maxlength=\'30\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(document_number,doc_type_number,2,1); } else{ fnClearCode(document_number); }\"   >\t\t \n\t\t <label>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</label>\n\t\t<input type=\'text\' name=\'document_number\' id=\'document_number\' id=\'document_number\' size=\'10\' maxlength=\'8\' onkeypress=\'return checkAlpha(event);\' onBlur=\'checkForNumber(this)\' value=\'\'  onBlur=\'\' ><input type=\'button\' class=\'button\' name=\"docnumber\" id=\"docnumber\"   value=\'?\'  tabindex=\'0\' onClick=\"callCommonLookupCode(document_number,doc_type_number,2,2);\"><img src=\'../../eCommon/images/mandatory.gif\'>\t\t\t\t\t \n\t\t</td>\n\t\t<td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t </td>\n\t\t <td width=\"5%\" >\n\t\t <input type=\'text\' name=\'deposit_date\' id=\'deposit_date\' size=\'17\' maxlength=\'22\'  value=\'\'  onBlur=\'isValidDateTime(deposit_date);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'deposit_date\',\'dd/mm/yyyy\',\'hh:mm\');\" >\t\t \t\t\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\t\n\t\t</td>\n\t\t <td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t</td>\n\t\t <td width=\"3%\" >\n\t\t <input type=\'text\' name=\'deposit_reason\' id=\'deposit_reason\' size=\'10\' maxlength=\'30\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(dep_reason,deposit_reason,3,1); } else{ fnClearCode(dep_reason); }\">\t\t\t \t\t\n\t\t<input type=\'text\' name=\'dep_reason\' id=\'dep_reason\' size=\'10\' maxlength=\'30\'  value=\'\'  onBlur=\'\'><input type=\'button\' class=\'button\' name=\"reason\" id=\"reason\"   value=\'?\'  tabindex=\'0\' onClick=\"callCommonLookupCode(dep_reason,deposit_reason,3,2);\"><img src=\'../../eCommon/images/mandatory.gif\'>\t\t\t\t\t \n\t\t</td>\t\t\t \t\t\t\t\n\t\t</tr>\t\t\t\n\t\t<br/><br/>\t\t\t\t\t\t\t\t\n\t\t<tr>\t\n\t\t <td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\t \n\t\t <!-- Modified by Manivel N on 16-08-22 for TH-KW-CRF-0156 -->\n\t\t<td width=\"5%\" class=\"fields\">\n\t\t\t<input type=\'text\' name=\'receipt_nature_code\' id=\'receipt_nature_code\'  size=\'10\' maxlength=\'22\'  value=\'\'  onBlur=\"if(this.value!=\'\'){callCommonLookupCode(receipt_nature,receipt_nature_code,5,1);if(document.forms[0].rec_ref.value == \'R\') defaultReceipttype(\'rcptnature\') } else{ fnClearCode(receipt_nature); }\" >\t\n\t\t\t\n\t\t\t<input type=\'text\' name=\'receipt_nature\' id=\'receipt_nature\'  size=\'10\' maxlength=\'22\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(receipt_nature,receipt_nature_code,5,2); } else{ fnClearCode(receipt_nature_code); };if(document.forms[0].rec_ref.value == \'R\') defaultReceipttype(\'rcptnature\');\" ><input type=\'button\' class=\'button\' name=\"receiptNatureBtn\" id=\"receiptNatureBtn\"  value=\'?\'  tabindex=\'0\' onClick=\"callCommonLookupCode(receipt_nature,receipt_nature_code,5,2);if(document.forms[0].rec_ref.value == \'R\') defaultReceipttype(\'rcptnature\');\">\t\t\t\t \t\n\t\t</td>\n\t\t<td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t</td>\n\t\t <td id=\"rec_refund\" width=\'3%\' class=\"fields\">\n\t\t <select name=\'recpt_refund_ind\' id=\'rec_ref\' >\n\t\t <option value=\'R\'>Receipt</option>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t-------\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t-------  \n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t<option value=\'F\'>Refund</option>\n\t\t\t\t\t\t</option>\n\t\t\t\t</select></td>\n\t\t \n\t \t \t\t \t\n\t\t \t\t <td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t</td>\n\t\t<td class=\"fields\" width=\"5%\">\n\t\t\t<input type=\'text\' name=\'receipt_type_code\' id=\'receipt_type_code\'  size=\'05\' maxlength=\'22\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(receipt_desc,receipt_type_code,1,1); } else{ fnClearCode(receipt_desc); } \">\n\t\t\t\n\t\t\t<input type=\'text\' name=\'receipt_desc\' id=\'receipt_desc\'  size=\'17\' maxlength=\'22\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(receipt_desc,receipt_type_code,1,2); } else{ fnClearCode(receipt_type_code); }\">\n\t\t\t\n\t\t\t<input type=\'button\' class=\'button\' name=\"rec_type\" id=\"rec_type\"  value=\'?\'  tabindex=\'0\' onClick=\"callCommonLookupCode(receipt_desc,receipt_type_code,1,2)\">\n\t\t</td> \t\t\t\t\t\t\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t<td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t<td width=\"5%\" class=\"fields\"><input type=\"text\" name=\"remarks\" id=\"remarks\" size=\"20\" maxlength=\"30\"  value=\'\'  onBlur=\"\">\n\t\t</td>\n\t\t\n\t\t\n\t\t<td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t<td width=\'3%\' class=\"fields\">\n\t\t\t\t<select name=\'dep_type\' id=\'dep_type\' id=\'dep_type\' onChange=\"deptypecheck();\" >\n\t\t\t\t<option value=\'A\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n\t\t\t\t<option value=\'N\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t\t<option value=\'T\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n\t\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option>\n\t\t\t\t<option value=\'K\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</option>\n\t\t\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</option>\n\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t<td width=\"2%\" class=\"label\" id=\'reqlabel\' >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t</td>\n\t<td class=\"fields\" width=\"5%\" id=\'request_id\'><input type=\'text\' name=\'reqid\' id=\'reqid\'  size=\'07\' maxlength=\'22\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(req,reqid,7,1); } else{ fnClearCode(stlmt_amount); }\"><input type=\'button\' class=\'button\' name=\"requestid\" id=\"requestid\"    value=\'?\'  tabindex=\'0\' onClick=\'callCommonLookupCode(req,reqid,7,2);\'>\t\n\t</td> \t\n\t\n\t\t\n\t\t\t\t\n\t\t \n\t\t</tr>\n\t\t<tr>\n\t <td width=\"2%\"  class=\'label\' >";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n  </td>\n\t<td width=\"5%\" class=\"fields\"><input type=\'text\' name=\'reference\' id=\'reference\' size=\'20\' maxlength=\'30\'  value=\'\'  onBlur=\"\">\n\t</td>\t\n\t\n\t<td class=\"label\"  width=\"2%\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t</td>\n\t<td width=\"5%\" class=\"fields\"><input type=\'text\' name=\'stlmt_amount\' id=\'stlmt_amount\'  size=\'15\' maxlength=\'15\'  value=\'\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInputDeposit(this,event,document.forms[0].noofdecimal.value,document.forms[0].rec_ref.value))\' onBlur=\'checkForNumber(this);putdeci(this);setAmt(this);stlmt_amountcheck();\'>\n\t</td>\n\t\t<td width=\"2%\"  class=\'label\' id=\'customerid\' >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n \t\t</td>\n\t\t<td width=\"5%\" class=\"fields\" id=\'cus_id\'><input type=\'text\' name=\'customer_code\' id=\'customer_code\'  size=\'05\' maxlength=\'22\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(customer_name,customer_code,4,1); } else{ fnClearCode(customer_name); }\" >\t\t\n\t\t<input type=\'text\' id=\'customer_name\' name=\'customer_name\' size=\'17\' maxlength=\'22\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(customer_name,customer_code,4,2); } else{ fnClearCode(customer_code); }\" ><input type=\'button\' class=\'button\' name=\"reason\" id=\"reason\"  value=\'?\'  tabindex=\'0\' onClick=\"callCommonLookupCode(customer_name,customer_code,4,2);\"><td id=\'cusmandatory\'><img  src=\'../../eCommon/images/mandatory.gif\'></td>\t\t\t\t\t \t\n\t\t</td>\t\t\n\t\n \t</tr>\n<tr>\t\n\t <td width=\"2%\" class=\"label\" id=\'accountcode\' >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t </td>\n\t\t <td width=\'5%\' class=\"fields\" id=\'act_code\'><input type=\'text\' name=\'ext_acc_code\' id=\'ext_acc_code\' id=\'ext_acc_code\' size=\'15\' maxlength=\'15\'  value=\'\' onBlur=\"\" >\n\t\t </td>\n\t\t \n\t <td width=\'2%\' class=\'label\'id=\'deptcode\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t </td>\n\t\t <td width=\'5%\' class=\"fields\" id=\'deptdesc\' ><input type=\'text\' name=\'dept_desc\' id=\'dept_desc\' id=\'dept_desc\' size=\'30\' maxlength=\'45\'  value=\'\'   onBlur=\"if(this.value!=\'\'){ callCommonLookupCode(dep_code,dept_desc,6,1); } else{ fnClearCode(dep_code); }\" ><input type=\'button\' class=\'button\' name=\"dept_btn\" id=\"dept_btn\" id=\"dept_btn\"  value=\'?\'  tabindex=\'0\' onClick=\'callCommonLookupCode(dep_code,dept_desc,6,2);\'>\n\t\t </td>\t\n\t\n</tr>\n\t<tr>\n\t <tr>\n\t<td width=\"2%\"  class=\'label\' id=\'totamt\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n  \t</td>\n\t<td width=\"5%\" class=\"fields\" id=\'totalbillamt\'>\t\n\t<input type=\'text\' name=\'totalbillamt\' id=\'totalbillamt\'  size=\'17\' maxlength=\'30\'  value=\'\'  onBlur=\"\">\n\t</td>\t\n\t<td class=\"label\" id=\"paidamt\" width=\"2%\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t</td>\n\t<td width=\"5%\" class=\"fields\" id=\'billpaidamt\'>\n\t<input type=\'text\' name=\'billpaidamt\' id=\'billpaidamt\'  size=\'17\' maxlength=\'30\'  value=\'\'  onBlur=\"\">\n\t</td>\n\t<td class=\"label\" width=\"2%\" id=\'doclabel\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t<td width=\"5%\" id=\'document_number1\'>\n\t\t<input type=\'text\' name=\'doc_number\' id=\'doc_number\' id=\'doc_number\' size=\'10\' maxlength=\'30\'  value=\'\'  onBlur=\"\" readonly >\t\t\n\t\t<label id=\'slash1\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</label>\t\t\n\t \t<input type=\'text\' name=\'doc_num\' id=\'doc_num\' id=\'doc_num\' size=\'10\' maxlength=\'30\'  value=\'\'  onBlur=\"\"readonly >\t\t\t\t\t \n\t\t<label id=\'slash2\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</label>\t\t\n\t\t<input type=\'text\' name=\'documnumber\' id=\'documnumber\' id=\'documnumber\' size=\'10\' maxlength=\'30\'  value=\'\'  onBlur=\"\" readonly >\t\t\n\t\t<input type=\'button\' class=\'button\' name=\"doc_btn\" id=\"doc_btn\" id=\"doc_btn\"  value=\'?\'  tabindex=\'0\' onClick=\'originaldocnum();\'>\n\t\t</td>\t\t\t\t\t\n\t</tr></table>\n\t\t\t<table>\n \t <tr>\n\t  <td width=\"5%\">\n\t  <input type=\'button\' class=\'button\' name=\"depest\" id=\"depest\" id=\'depest\'   value=\' Estimate For Deposit\'  tabindex=\'0\' onClick=\"estdep();\">\n\t  <input type=\'button\' class=\'button\' name=\"splAgnDep\" id=\"splAgnDep\" id=\'splAgnDep\'   value=\' Special Agency Deposit\'  tabindex=\'0\' onClick=\"splAgencyDeposit();\">\n\t</td>\n\t<td class=\"label\" width=\"2%\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\n\t<input type=\'checkbox\' name=\'thru_mail\' id=\'thru_mail\' size=\'5\'  maxlength=\'5\' value=\"\" onclick=\"\"></td>\t\t\n\t\n\t </tr> \n\t</table>\n\t</table>\n\t\n\t\n\t<input type= \'hidden\' name=\"downTimeAllowDays\" id=\"downTimeAllowDays\"  value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type= \'hidden\' name=\"medrep_pay_int_mode\" id=\"medrep_pay_int_mode\" id=\"medrep_pay_int_mode\"  value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type= \'hidden\' name=\"misc_rcpt_type\" id=\"misc_rcpt_type\" id=\"misc_rcpt_type\"  value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<!--  <input type=\'hidden\' name=\'depcount\' id=\'depcount\'  id=\"depcount\"  value=\"<//%=depcount %>\" \n\t<input type=\'hidden\' name=\'depreturn\' id=\'depreturn\' id=\"depreturn\" value=\"<//%=depreturn %>\"-->\n\t\n\t\n\t<input type= \'hidden\' name=\"locale\" id=\"locale\"  value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type= \'hidden\' name=\"facility_id\" id=\"facility_id\"  value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\t\n\t<input type= \'hidden\' name=\"rcpt_ip_allowed_yn\" id=\"rcpt_ip_allowed_yn\"  value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\t\n\t<input type= \'hidden\' name=\"rcpt_ref_allowed_yn\" id=\"rcpt_ref_allowed_yn\"  value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\t\n\t<input type= \'hidden\' name=\"rcpt_op_allowed_yn\" id=\"rcpt_op_allowed_yn\"  value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\t\n\t<input type= \'hidden\' name=\"rfnd_ip_allowed_yn\" id=\"rfnd_ip_allowed_yn\"  value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\t\n\t<input type= \'hidden\' name=\"rfnd_op_allowed_yn\" id=\"rfnd_op_allowed_yn\"  value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\t\n\t<input type= \'hidden\' name=\"rfnd_ref_allowed_yn\" id=\"rfnd_ref_allowed_yn\"  value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\t\t\t\n\t<input type= \'hidden\' name=\"rfnd_allowed_yn\" id=\"rfnd_allowed_yn\"  value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\t\n\t<input type= \'hidden\' name=\"rcpt_allowed_yn\" id=\"rcpt_allowed_yn\"  value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\t\n\t<input type= \'hidden\' name=\"down_time_rcpt_doc_type\" id=\"down_time_rcpt_doc_type\"  value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\t\n\t<input type= \'hidden\' name=\"down_time_rfnd_doc_type\" id=\"down_time_rfnd_doc_type\"  value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\t\n\t<input type= \'hidden\' name=\"noofdecimal\" id=\"noofdecimal\"  value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\t\n\t<input type= \'hidden\' name=\"tot_adm_dep_amt\" id=\"tot_adm_dep_amt\"  value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\t\t\n\t<input type= \'hidden\' name=\"tot_trf_dep_amt\" id=\"tot_trf_dep_amt\"  value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\t\n\t<input type= \'hidden\' name=\"tot_othr_dep_amt\" id=\"tot_othr_dep_amt\"  value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\t\n\t<input type= \'hidden\' name=\"tot_adm_dep_paid_amt\" id=\"tot_adm_dep_paid_amt\"  value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\t\n\t<input type= \'hidden\' name=\"collect_dep_amt_in_adv_yn\" id=\"collect_dep_amt_in_adv_yn\"  value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\t\n\t<input type= \'hidden\' name=\"shift_id\" id=\"shift_id\"  value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\t\n\t<input type= \'hidden\' name=\"cash_counter_code\" id=\"cash_counter_code\"  value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\t\n\t<input type= \'hidden\' name=\"ext_acc_facility_id\" id=\"ext_acc_facility_id\"  value=\"\">\t\n\t<input type= \'hidden\' name=\"ext_dept_ind\" id=\"ext_dept_ind\"  value=\"\">\t\t\n\t<input type= \'hidden\' name=\"ext_acc_int_YN\" id=\"ext_acc_int_YN\"  value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\t\n\t<input type= \'hidden\' name=\"pkgAmount\" id=\"pkgAmount\"  value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\t\n\t<input type= \'hidden\' name=\"tot_package_amt\" id=\"tot_package_amt\"  value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\t\n\t<input type= \'hidden\' name=\"d_tot_package_amt\" id=\"d_tot_package_amt\"  value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\t\t\n\t<input type= \'hidden\' name=\"dep_code\" id=\"dep_code\" id=\"dep_code\" value=\"\">\t\t\n\t<input type= \'hidden\' name=\"req_id\" id=\"req_id\" id=\"req_id\" value=\"\">\t\t\n\t<input type= \'hidden\' name=\"tdentry\" id=\"tdentry\" id=\"tdentry\" value=\"\">\t\t\n\t\n\n\t<input type= \'hidden\' name=\"patient_id\" id=\"patient_id\" id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\t\n\t\n\t<input type= \'hidden\' name=\"episode_type\" id=\"episode_type\" id=\'episode_type\'  value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\t\n\t<input type= \'hidden\' name=\"episode_id\" id=\"episode_id\"  value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\t\n\t<input type= \'hidden\' name=\"visit_id\" id=\"visit_id\"  value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\t\n\t<input type= \'hidden\' name=\"encounter_id\" id=\"encounter_id\"  value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\t\n\t<input type= \'hidden\' name=\"reln_code\" id=\"reln_code\"  value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\t\n\t<input type= \'hidden\' name=\"function_id\" id=\"function_id\"  value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\t\n\t<input type= \'hidden\' name=\"funct_mode\" id=\"funct_mode\"  value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\t\n\t<input type= \'hidden\' name=\"deposit_man_yn\" id=\"deposit_man_yn\"  value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\t\n\t<input type= \'hidden\' name=\"packseqno\" id=\"packseqno\"  value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\t\n\t<input type= \'hidden\' name=\"pkgCode\" id=\"pkgCode\"  value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\t\n\t<input type= \'hidden\' name=\"min_dep_amt\" id=\"min_dep_amt\"  value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\t\n\t<input type= \'hidden\' name=\"min_dep_amt_man\" id=\"min_dep_amt_man\"  value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\t\n\t<input type= \'hidden\' name=\"pkgSeqAmtForSub\" id=\"pkgSeqAmtForSub\"  value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\t\n\t<input type= \'hidden\' name=\'ignoreMandValidationDtl\' id=\'ignoreMandValidationDtl\' id=\'ignoreMandValidationDtl\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\t<input type= \'hidden\' name=\'derivedFromDtl\' id=\'derivedFromDtl\' id=\'derivedFromDtl\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t<input type=\'hidden\' name=\'totMinDepositDtl\' id=\'totMinDepositDtl\' id=\'totMinDepositDtl\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t <input type=\'hidden\' name=\'rec_nature_code\' id=\'rec_nature_code\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'  onBlur=\"\">\n\t\t<input type=\'hidden\' name=\'rec_nature\' id=\'rec_nature\' value=\'\'  onBlur=\"\">\t \n\n\t<input type= \'hidden\' name=\"recptTypCode\" id=\"recptTypCode\"  value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\t\n\t<input type= \'hidden\' name=\"recptTypLongDesc\" id=\"recptTypLongDesc\"  value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\t\n\n\t<input type= \'hidden\' name=\"splAgnDepYN\" id=\"splAgnDepYN\"  value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\t\n\t<input type= \'hidden\' name=\"splAgnDepChkYN\" id=\"splAgnDepChkYN\"  value=\"N\">\t\n\t<input type= \'hidden\' name=\"splAgnEffFrom\" id=\"splAgnEffFrom\"  value=\"\">\t\n\t<input type= \'hidden\' name=\"splAgnEffTo\" id=\"splAgnEffTo\"  value=\"\">\t\n\t<input type= \'hidden\' name=\"cusid\" id=\"cusid\"  id=\'cusid\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t<input type= \'hidden\' name=\"reqamount\" id=\"reqamount\"  id=\'reqamount\' value=\"\">\n\t\t<input type= \'hidden\' name=\"reqcheck\" id=\"reqcheck\"  id=\'reqcheck\' value=\"\">\n\t\t  <input type= \'hidden\' name=\"req\" id=\"req\" id=\"req\" value=\'\'> \n\t\t\t  <input type= \'hidden\' name=\"orgdoc_amt\" id=\"orgdoc_amt\" id=\"orgdoc_amt\" value=\'\'> \n\t\t\t\t\t\t  <input type= \'hidden\' name=\"orgdoc_type\" id=\"orgdoc_type\" id=\"orgdoc_type\" value=\'\'> \n\t\t\t  <input type= \'hidden\' name=\"orgdoc_num\" id=\"orgdoc_num\" id=\"orgdoc_num\" value=\'\'> \n\t\t\t  <input type= \'hidden\' name=\"orgdoc_srno\" id=\"orgdoc_srno\" id=\"orgdoc_srno\" value=\'\'> \n\t\n\t<input type=\'hidden\' name=\'refundDownCode\' id=\'refundDownCode\' id=\'refundDownCode\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t<input type=\'hidden\' name=\'receiptDownCode\' id=\'receiptDownCode\' id=\'receiptDownCode\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\n\n</form>\n\t<script>\n\t\n</script>\n</BODY>\t\n</HTML>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" \n\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	ResultSet rscurr = null; //ResultSet rs1 = null;		
	CurrencyFormat cf = new CurrencyFormat();
	String recptTypCode =null ;
	String recptTypLongDesc =null ;
	String splAgnDepYN  =null ;
	String beanId = "EstimateDepositBean" ;
	String beanName = "eBL.BLEstimateDepositBean";
	String strCustomerId="";
	
	//Added by NamrataCharate for TH-KW-CRF-0156
	boolean dfltRcptTypeForDeposit = false;
	boolean isDfltPkgRcptTypeSetup = false;

	try
	{
		
		BLEstimateDepositBean depositbean = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request);
		//cleanBeanObject(beanId, beanName, request);
		depositbean.clearAll();
		
		String calledFrom=request.getParameter("called_from");
			
		
		
		String medrep_pay_int_mode="";
		String chiefcomplaint =  request.getParameter("chiefcomplaint")==null?"":request.getParameter("chiefcomplaint");
		String nursing_unit_code = request.getParameter("nursing_unit_code")==null?"":request.getParameter("nursing_unit_code");
		String customer_id=(String)session.getValue("CUSTOMER_ID");
		String chiefComplaintDesc = request.getParameter("chiefComplaintDesc")==null?"":request.getParameter("chiefComplaintDesc");
		//System.out.println("remarks : "+chiefComplaintDesc);
		con	=	ConnectionManager.getConnection(request);
		String strDownTimeAllowDays="";
		String receiptDownCode = "";
		String refundDownCode = "";
		String misc_rcpt_type="";
		String depcount="";
		String depreturn="";		
		//int depamt=0;
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String remarks_desc="";
		if((customer_id!=null && customer_id.equals("KDAH"))&&(!chiefcomplaint.equals(""))){
			remarks_desc = chiefComplaintDesc;
		}

		try
		{
		pstmt=con.prepareStatement("SELECT MEDREP_PAY_INT_MODE FROM   MR_PARAMETER");	
		 rs = pstmt.executeQuery();	
		if( rs != null ) 
		{
			if( rs.next() )
			{			
				medrep_pay_int_mode  =  rs.getString(1);	
			}
		}
		System.out.println("query returned value MEDREP_PAY_INT_MODE "+medrep_pay_int_mode);
		if(medrep_pay_int_mode == null) medrep_pay_int_mode="N";			
		pstmt.close();
		if(rs!=null) rs.close();			
		}catch(Exception e){
			System.out.println("Exception from QRY MEDREP_PAY_INT_MODE:"+e);
			e.printStackTrace();
		}
		
		//Added by NamrataCharate for TH-KW-CRF-0156
		try 
		{
			dfltRcptTypeForDeposit = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENBL_DFLT_RCPT_TYPE_FOR_NATURE");
		} catch(Exception ex) {
			System.err.println("Error in BLEnterReceiptRefundDtl.jsp for getting dfltRcptTypeForDeposit Connection: "+ex);
			ex.printStackTrace();
		}	
		
		int noofdecimal=2;
		
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	

		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
		System.out.println("cc machine id"+strclientip);
		//System.out.println("encoded "+encoded);
		String patient_id ="";
		if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
			patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		}else{
			patient_id	= request.getParameter("patient_id");
			if(patient_id==null) patient_id="";	
		} //V220801	
		System.out.println("patient_id ,BLDepositRefund.jsp  "+patient_id); 

/*		String patient_id = request.getParameter("patient_id");	
		if(patient_id==null) patient_id="";	
		System.out.println("patient_id ,refund"+patient_id);
 	*///V220801	
	
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		
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
		System.out.println("Episode id depositrefund="+episode_id);
		
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
		System.out.println("visit_id="+visit_id);
		String strencounter_id = replaceNull(request.getParameter("encounter_id"));	
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
		
		/*try
		{
		pstmt=con.prepareStatement(" select count(*) from bl_receipt_refund_HDR where operating_facility_id = '"+facilityid+"' and patient_id = '"+patient_id+"' and episode_id = '"+episode_id+"' and episode_type = NVL('"+episode_type+"','I') and recpt_refund_ind = 'R'and recpt_nature_code = 'AD'and nvl(cancelled_ind,'N') != 'Y' ");	
		 rs = pstmt.executeQuery();			
		 if( rs != null ) 
		{
			if( rs.next() )
			{			
				depcount  =  rs.getString(1);	
				
			}
		}
		
		if(depcount == null || depcount=="") 
			{
			depcount=Integer.toString(0);
			}
		System.out.println("query returned value depcount "+depcount);
		pstmt.close();
		if(rs!=null) rs.close();			
		}catch(Exception e){
			System.out.println("Exception from QRY depcount:"+e);
			e.printStackTrace();
		}*/
				
		/*try
		{
		pstmt=con.prepareStatement("select nvl(trn_dep,0) i from bl_ip_adt_trn_vw where patient_id = '"+patient_id+"' and episode_id = '"+episode_id+"' and facility_id = '"+facilityid+"' and trn_code = 'A' and nvl(adt_trn_status,'0') != '9' ");	
		 rs = pstmt.executeQuery();	
		if( rs != null ) 
		{
			if( rs.next() )
			{			
				depreturn  =  rs.getString(1);	
			}
		}
		if(depreturn == null || depreturn=="")
		{
			System.out.println("if");
			depreturn=Integer.toString(0);
			
		}
		
		System.out.println("query returned value depreturn "+depreturn);
		pstmt.close();
		if(rs!=null) rs.close();			
		}catch(Exception e){
			System.out.println("Exception from QRY depreturn:"+e);
			e.printStackTrace();
		}*/

		try{
			
			String sqlsiteParam = "Select CUSTOMER_ID from SM_SITE_PARAM ";
			pstmt = con.prepareStatement(sqlsiteParam);		
			rs = pstmt.executeQuery();
			
			if(rs != null){			
				while(rs.next()){
					strCustomerId = rs.getString("CUSTOMER_ID");
					strCustomerId=strCustomerId==null?"":strCustomerId;
			
				}
			System.out.println("strCustomerId:::"+strCustomerId);
			}
			pstmt = null;
			rs = null;			

		}
		catch(Exception e)
		{
			System.out.println("Exception in getting CUSTOMER_ID"+e);
			e.printStackTrace();
		}
		
		try
		{
		pstmt=con.prepareStatement("SELECT MISC_RCPT_TYPE_FOR_MED_REP FROM   BL_PARAMETERS WHERE  OPERATING_FACILITY_ID = '"+facilityid+"' ");	
		 rs = pstmt.executeQuery();	
		if( rs != null ) 
		{
			if( rs.next() )
			{			
				misc_rcpt_type =  rs.getString(1);	
			}
		}
		System.out.println("query returned value misc_rcpt_type "+misc_rcpt_type);
		if(misc_rcpt_type  == null) misc_rcpt_type ="N";			
		pstmt.close();
		if(rs!=null) rs.close();			
		}catch(Exception e){
			System.out.println("Exception from QRY MISC_RCPT_TYPE_FOR_MED_REP:"+e);
			e.printStackTrace();
		}
		

/************ADDED FOR PACKAGE BILLING **********************/
		String function_id =  request.getParameter("function_id");	
		if(function_id==null) function_id="";	
		String funct_mode =  request.getParameter("funct_mode");	
		if(funct_mode==null) funct_mode="";	
		String str_bl_package_enabled_yn="N";

		String pkgCode = request.getParameter("pkgCode");// MMS-CRF-0023 moved here	
		if(pkgCode==null) pkgCode="";
		String packseqno = request.getParameter("packseqno");	
		//String packseqno = request.getParameter("packseqno");	
		if(packseqno==null) packseqno="";	

		String pkgAmount = request.getParameter("pkgAmount");	
//		String pkgAmount = request.getParameter("pkg_amt");	
		if(pkgAmount==null) pkgAmount="";

		String tot_package_amt = request.getParameter("tot_package_amt");	
		
		String modeOfCall = request.getParameter("modeOfCall");
		if(modeOfCall == null)	modeOfCall="";
		
		String blng_class = request.getParameter("blng_class");
		if(blng_class == null)	blng_class="";
		
		//Added for MMS-DM-SCF-0013
		String ignoreMandValidationDtl = "N";
		String derivedFromCust = "";
		String derivedFromBase = "";
		String depositReqYn = "";
		String derivedFromDtl = "N";
		double totMinDepositDtl = 0.00;
		// Added for SCF 501.1
		String pkgSeqAmtForSub = "";
		PartialDepositMasterBean refBean = new PartialDepositMasterBean();
		System.out.println("Inside pkgAmount"+pkgAmount);
		System.out.println("Inside tot_package_amt"+ tot_package_amt);
		if(tot_package_amt==null) tot_package_amt="";
		double tot_min_dep_amt=0.00;double d_tot_package_amt=0.00;
		String rec_found_flag="N";String doc_amt="";
		String str_deposit_man_yn = "",	str_partial_dep_yn	= "",	str_min_dep_amt	= "",str_err_level= "",	str_sys_message_id= "",	str_error_text= "";	
		//if(!funct_mode.equals("") && funct_mode.equals("VISIT_REGISTRATION")){
		String bean_id		= "PkgSubsBean" ;
		String bean_name	= "eBL.PkgSubsBean";
		PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id, bean_name, request ) ;	
		HashMap  patPackSubsDetails=bean.getPatientPackSubsDtls();	

		//String doc_amt="";
		String bean_id1		= "PkgEnterReceptRefundBean" ;
		String bean_name1	= "eBL.PkgEnterReceptRefundBean";
		PkgEnterReceptRefundBean bean1			= (PkgEnterReceptRefundBean)getBeanObject( bean_id1, bean_name1, request ) ;
		//PkgEnterReceptRefundBean bean1			= (PkgEnterReceptRefundBean)getBeanObject( bean_id1, bean_name1, request ) ;
		//bean1.clearBean();
		//putObjectInBean(bean_id1,bean1,request);
		
		/*Karthik added the below code for Partial Deposit - Starts MMS-CRF-0023*/
		/*Karthik moved the code below the code to calculate Total package amount for subscription cases IN050265  */
			String par_dep_bean_id		= "PartialDepositMasterBean" ;
			String par_dep_bean_name	= "eBL.PartialDepositMasterBean";
			PartialDepositMasterBean par_dep_bean			= (PartialDepositMasterBean)getBeanObject( par_dep_bean_id, par_dep_bean_name, request ) ;
			StringTokenizer stTokpkgCode=new StringTokenizer(pkgCode,"^");  
			StringTokenizer stTokSeqNo=new StringTokenizer(packseqno,"^"); 
			StringTokenizer stBlngClass = new StringTokenizer(blng_class,"^"); 

			
	if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
		{
 		 if(episode_type.equals("I") ||episode_type.equals("R")){
			String chargeLogic=	par_dep_bean.getChargeLogic(facilityid);	
				if(chargeLogic.equals("Y")){
			
					double partialDepositAmount=0.00;	
					double partDepAmtTemp = 0.00;
					double minDepAmount = 0.00;
					double minDepAmtTemp = 0.00;
					CallableStatement callMinDep = null;

					int checkTotalPackageCount=stTokpkgCode.countTokens();
					//For Multi Package subscription cases
					if(checkTotalPackageCount>1){
		
						while(stTokpkgCode.hasMoreTokens()){
							String pkgCodeNoDelimiter=stTokpkgCode.nextToken();
							String packseqnoNoDelimiter=stTokSeqNo.nextToken();
							String blng_class_token = "";
							
							HashMap<String,String> parDepMap = par_dep_bean.getCodesForPackage(patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con);
							if(parDepMap != null){
								blng_class_token = parDepMap.get("blngClassCode");
							}
							boolean validPartialDepositCase=	par_dep_bean.checkValidPartialDepositCase(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, blng_class_token, con);
							System.out.println("$$$$$$$validPartialDepositCase:"+validPartialDepositCase+" pkgCodeNoDelimiter: "+pkgCodeNoDelimiter+" packseqnoNoDelimiter: "+packseqnoNoDelimiter);
							//If the Case is a Valid PartialDeposit Case Add PartialDeposit otherwise add Deposit Amount to it
							//Note the Package Amount is not considered here
							if(validPartialDepositCase){
								partDepAmtTemp = par_dep_bean.getPartialDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
								partialDepositAmount+=partDepAmtTemp;
								minDepAmtTemp = par_dep_bean.getMinimumDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
								minDepAmount+=minDepAmtTemp;
							}else{
								HashMap<String,String> hashMapCode= par_dep_bean.getCodesForPackage(patient_id,pkgCodeNoDelimiter,packseqnoNoDelimiter, con);
								String blngClassCode = hashMapCode.get("blngClassCode");
								String custGrpCode = hashMapCode.get("custGrpCode");
								String custCode = hashMapCode.get("custCode");								
								partDepAmtTemp = par_dep_bean.GetPackagePrice(facilityid, pkgCodeNoDelimiter,blngClassCode, custGrpCode,  custCode, con);
								partialDepositAmount+=partDepAmtTemp;
								
								//Mn Dep Amt
								callMinDep = con.prepareCall("{ call  blpackage.get_pkg_deposit_dtls (?,?,?,?,?,?,?,?,?,?)}");			
								callMinDep.setString(1,facilityid);				
								callMinDep.setString(2,packseqnoNoDelimiter);				
								callMinDep.setString(3,pkgCodeNoDelimiter);				
								callMinDep.setDouble(4,partDepAmtTemp);											
								callMinDep.registerOutParameter(5,java.sql.Types.VARCHAR); // p_deposit_man_yn   			
								callMinDep.registerOutParameter(6,java.sql.Types.VARCHAR); // p_partial_dep_yn   	
								callMinDep.registerOutParameter(7,java.sql.Types.VARCHAR); // p_min_dep_amt      
								callMinDep.registerOutParameter(8,java.sql.Types.VARCHAR); //p_err_level 
								callMinDep.registerOutParameter(9,java.sql.Types.VARCHAR); // p_sys_message_id
								callMinDep.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text				
								callMinDep.execute();				
								str_deposit_man_yn	 = callMinDep.getString(5);
								str_partial_dep_yn	 = callMinDep.getString(6);
								str_min_dep_amt		 = callMinDep.getString(7);		
								str_err_level		 = callMinDep.getString(8);		
								str_sys_message_id	 = callMinDep.getString(9);		
								str_error_text		 = callMinDep.getString(10);		
								callMinDep.close();	
								if ( str_deposit_man_yn == null ) str_deposit_man_yn = "";
								if ( str_partial_dep_yn == null ) str_partial_dep_yn = "";
								if ( str_min_dep_amt == null ) str_min_dep_amt = "";
								if ( str_err_level == null ) str_err_level = "";
								if ( str_sys_message_id == null ) str_sys_message_id = "";
								if ( str_error_text == null ) str_error_text = "";	
								
								minDepAmount+= Float.parseFloat(str_min_dep_amt);
								//Min Dep Amt
							}
						}
					}else{//For Single Package Subscription Cases
						while(stTokpkgCode.hasMoreTokens()){;
							String pkgCodeNoDelimiter=stTokpkgCode.nextToken();
							String packseqnoNoDelimiter=stTokSeqNo.nextToken();
							String blng_class_token = "";
							
							HashMap<String,String> parDepMap = par_dep_bean.getCodesForPackage(patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con);
							if(parDepMap != null){
								blng_class_token = parDepMap.get("blngClassCode");
							}
							
							boolean validPartialDepositCase=	par_dep_bean.checkValidPartialDepositCase(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, blng_class_token, con);
							System.out.println("$$$$$$$validPartialDepositCase:"+validPartialDepositCase+" pkgCodeNoDelimiter: "+pkgCodeNoDelimiter+" packseqnoNoDelimiter: "+packseqnoNoDelimiter);
							//If the Case is a Valid PartialDeposit Case Add PartialDeposit otherwise add Deposit Amount to it
							if(validPartialDepositCase){
								if(pkgAmount.equals("")){
									partDepAmtTemp=	par_dep_bean.getPartialDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
									minDepAmtTemp = par_dep_bean.getMinimumDepositAmount(facilityid, patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con) ;
								}else{						//Note the Package Amount is  considered here
									StringTokenizer stTokPkgAmount=new StringTokenizer(pkgAmount,"^"); 
									String pkgAmountNoDelimiter=stTokPkgAmount.nextToken();
									System.out.println(pkgCodeNoDelimiter +"|"+packseqnoNoDelimiter +"|"+pkgAmountNoDelimiter );
									HashMap<String,String> hashMapCode= par_dep_bean.getCodesForPackage(patient_id,pkgCodeNoDelimiter,packseqnoNoDelimiter, con);
									String blngClassCode = hashMapCode.get("blngClassCode");
									int encounterSequenceNo= 	par_dep_bean.getEncounterSequenceNo(patient_id,packseqnoNoDelimiter, con);
									partDepAmtTemp=		par_dep_bean.calculatePartialDepositAmountFromDB(facilityid,pkgCodeNoDelimiter,encounterSequenceNo,Float.parseFloat(pkgAmountNoDelimiter),blngClassCode, con);
									minDepAmtTemp = par_dep_bean.calculateMinimumDepositAmountFromDB(facilityid,pkgCodeNoDelimiter,encounterSequenceNo,Float.parseFloat(pkgAmountNoDelimiter),blngClassCode, con);
								}
								partialDepositAmount+=partDepAmtTemp;
								minDepAmount+=minDepAmtTemp;
							}else{
								HashMap<String,String> hashMapCode= par_dep_bean.getCodesForPackage(patient_id,pkgCodeNoDelimiter,packseqnoNoDelimiter, con);
								String blngClassCode = hashMapCode.get("blngClassCode");
								String custGrpCode = hashMapCode.get("custGrpCode");
								String custCode = hashMapCode.get("custCode");								
								partDepAmtTemp = par_dep_bean.GetPackagePrice(facilityid, pkgCodeNoDelimiter,blngClassCode, custGrpCode,  custCode, con);
								partialDepositAmount+=partDepAmtTemp;
								//Mn Dep Amt
								callMinDep = con.prepareCall("{ call  blpackage.get_pkg_deposit_dtls (?,?,?,?,?,?,?,?,?,?)}");			
								callMinDep.setString(1,facilityid);				
								callMinDep.setString(2,packseqnoNoDelimiter);				
								callMinDep.setString(3,pkgCodeNoDelimiter);				
								callMinDep.setDouble(4,partDepAmtTemp);											
								callMinDep.registerOutParameter(5,java.sql.Types.VARCHAR); // p_deposit_man_yn   			
								callMinDep.registerOutParameter(6,java.sql.Types.VARCHAR); // p_partial_dep_yn   	
								callMinDep.registerOutParameter(7,java.sql.Types.VARCHAR); // p_min_dep_amt      
								callMinDep.registerOutParameter(8,java.sql.Types.VARCHAR); //p_err_level 
								callMinDep.registerOutParameter(9,java.sql.Types.VARCHAR); // p_sys_message_id
								callMinDep.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text				
								callMinDep.execute();				
								str_deposit_man_yn	 = callMinDep.getString(5);
								str_partial_dep_yn	 = callMinDep.getString(6);
								str_min_dep_amt		 = callMinDep.getString(7);		
								str_err_level		 = callMinDep.getString(8);		
								str_sys_message_id	 = callMinDep.getString(9);		
								str_error_text		 = callMinDep.getString(10);		
								callMinDep.close();	
								if ( str_deposit_man_yn == null ) str_deposit_man_yn = "";
								if ( str_partial_dep_yn == null ) str_partial_dep_yn = "";
								if ( str_min_dep_amt == null ) str_min_dep_amt = "";
								if ( str_err_level == null ) str_err_level = "";
								if ( str_sys_message_id == null ) str_sys_message_id = "";
								if ( str_error_text == null ) str_error_text = "";	
								
								minDepAmount+= Float.parseFloat(str_min_dep_amt);
								//Min Dep Amt
							}
						}						
					}
					
		
					pkgAmount=partialDepositAmount+"^";
					tot_package_amt=partialDepositAmount+"^";
					d_tot_package_amt = partialDepositAmount;
					tot_min_dep_amt = minDepAmount;
					
					System.out.println("BLEnterReceiptRefundDtl.jsp partialDepositAmount:"+ partialDepositAmount);
					}

		}  
		}
		/*Karthik added the below code for Partial Deposit - ends MMS-CRF-0023*/
		
		HashMap  support_data = bean1.getSupportData();		
		HashMap  mult_slmt_vals = bean1.getMultSlmtVals();	
		//System.out.println("support_data: "+support_data);
		if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
		{			
		 if(support_data!=null && support_data.size()>0)
		 {			
			doc_amt = (String)support_data.get("doc_amt");
			if(doc_amt==null) doc_amt="0";	
			//System.out.println("doc_amt 123:"+doc_amt);
			d_tot_package_amt=Double.parseDouble(doc_amt);							  
			rec_found_flag="Y";
			//String min_dep_amt = bean1.getMinDepAmt();	
			//tot_min_dep_amt = Double.parseDouble(min_dep_amt);							  							
			HashMap  db_values = bean1.getDBValues(patPackSubsDetails,patient_id,facilityid);				
			str_err_level		=(String)db_values.get("str_err_level");
			if(str_err_level==null) str_err_level="";	
			str_sys_message_id	=(String)db_values.get("str_sys_message_id");
			if(str_sys_message_id==null) str_sys_message_id="";	
			str_error_text		=(String)db_values.get("str_error_text");
			if(str_error_text==null) str_error_text="";				
			if ((str_err_level.equals("10") && (!str_error_text.equals(""))) ||!str_sys_message_id.equals(""))
			{
				if ( !(str_sys_message_id.equals("")))
				{	
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(str_sys_message_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
				}
				if ( !(str_error_text.equals("")) || !(str_err_level.equals("")) )
				{	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block8Bytes, _wl_block8);
			}	
			}else{
				String s_tot_min_dep_amt="";
				s_tot_min_dep_amt=(String)db_values.get("str_tot_min_dep_amt");
				if(s_tot_min_dep_amt==null) s_tot_min_dep_amt="0";
				tot_min_dep_amt = Double.parseDouble(s_tot_min_dep_amt);	

				String s_tot_package_amt="";
				s_tot_package_amt=(String)db_values.get("str_tot_package_amt");
														
				if(s_tot_package_amt==null) s_tot_package_amt="0";	
				d_tot_package_amt = Double.parseDouble(s_tot_package_amt);	
			}

		}
		}else{
			bean1.clearBean();
			putObjectInBean(bean_id1,bean1,request);
		}
//	}
		/*bean1.clearBean();
		putObjectInBean(bean_id1,bean1,request);*/
	
//		String pkgCode = request.getParameter("pkg_code");	

//		String str_deposit_man_yn = "",	str_partial_dep_yn	= "",	str_min_dep_amt	= "",str_err_level = "",	str_sys_message_id = "",		    str_error_text = "";	
		String sel_list="";
		//double tot_min_dep_amt=0.00;double d_tot_package_amt=0.00;
		String rcpt_type_long_desc="",rcpt_type_code="";
		String blng_class_code	="",blng_class_desc="";
		String payerGrpCode="",payerGrpDesc="",payerCode="",payerDesc="",pkg_codes_for_disc="",ppkgprice="";
		
/************ENDS**********************************************/
		String rcpt_ip_allowed_yn="",rcpt_op_allowed_yn="", rcpt_ref_allowed_yn="",rfnd_ip_allowed_yn="", rfnd_op_allowed_yn="", rfnd_ref_allowed_yn="",sys_message_id ="", error_text="",cash_counter_code="",shift_id="",rfnd_allowed_yn="",rcpt_allowed_yn="",strDownTimeRcptDocType = "",		   strDownTimeRfndDocType="", strRecptNaturedesc="",  strRecptNatureCode="",ext_acc_int_YN="",tot_adm_dep_amt="",tot_trf_dep_amt="", 	tot_othr_dep_amt="",tot_adm_dep_paid_amt="",collect_dep_amt_in_adv_yn="";
		String reln_code="";

            _bw.write(_wl_block9Bytes, _wl_block9);
	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block12Bytes, _wl_block12);


	try{
		/*********************ADDED FOR PACKAGE BILLING***************************/		
		try{				
			PreparedStatement pstmt1=con.prepareStatement("select bl_package_enabled_yn('"+facilityid+"') from dual");	
			ResultSet rs2 = pstmt1.executeQuery();	
			if( rs2 != null ) 
			{
				if( rs2.next() )
				{			
					str_bl_package_enabled_yn  =  rs2.getString(1);	
				}
			}
			if(str_bl_package_enabled_yn == null) str_bl_package_enabled_yn="N";			
			pstmt1.close();
			if(rs2!=null) rs2.close();			
			}catch(Exception e){
				System.out.println("Exception from QRY bl_package_enabled_yn:"+e);
				e.printStackTrace();
			}
			String pkg_seq_token="",pkg_code_token="",pkg_amt_token="";
		
		if(str_bl_package_enabled_yn.equals("Y") && function_id.equals("PKG_BILLING"))
		{			
			try{		
				String query_kk = "SELECT RECEIPT_TYPE_CODE,LONG_DESC FROM BL_RECEIPT_TYPE_lang_vw WHERE RECEIPT_TYPE_CODE IN (SELECT pat_dep_for_pkg FROM bl_parameters WHERE operating_facility_id='"+facilityid+"') AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') AND acc_entity_code= (SELECT ACC_ENTITY_CODE FROM sy_Acc_entity WHERE ACC_ENTITY_ID='"+facilityid+"')";
				PreparedStatement pstmt2=con.prepareStatement(query_kk);	
				ResultSet rs3 = pstmt2.executeQuery();	
				while(rs3.next())
					{			
						rcpt_type_code  =  rs3.getString(1);	
						rcpt_type_long_desc  =  rs3.getString(2);	
						isDfltPkgRcptTypeSetup = true;   //Added by NamrataCharate for TH-KW-CRF-0156
					}
				if(rcpt_type_code == null) rcpt_type_code="";			
				if(rcpt_type_long_desc == null) rcpt_type_long_desc="";			
				pstmt2.close();
				if(rs3!=null) rs3.close();			
				}catch(Exception e){
					System.out.println("Exception in receipt type simple:"+e);
					e.printStackTrace();
				}
		if(rec_found_flag.equals("N")){
		if(!funct_mode.equals("") && funct_mode.equals("VISIT_REGISTRATION"))
		{
			/*String bean_id		= "PkgSubsBean" ;
			String bean_name	= "eBL.PkgSubsBean";
			PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id, bean_name, request ) ;	
			HashMap  patPackSubsDetails=bean.getPatientPackSubsDtls();	*/		
		  if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
			{
				ArrayList	pkgDtls		=	new ArrayList();
				ArrayList	pkgCodes		=	new ArrayList();
				ArrayList	pkgFrmDate		=	new ArrayList();
				ArrayList	pkgToDate		=	new ArrayList();
				ArrayList	pkgAmt		=	new ArrayList();
				ArrayList	blng_class_code_list	=	new ArrayList();
				ArrayList	blng_class_desc_list	=	new ArrayList();	
				ArrayList	payerGrpCode_list	=	new ArrayList();
				ArrayList	payerGrpDesc_list	=	new ArrayList();
				ArrayList	payerCode_list	=	new ArrayList();
				ArrayList	payerDesc_list	=	new ArrayList();
					String packageCode="",fromDate="",toDate="",packAmt="N";
				//packEnId="",strEMYN="N",strIPYN="N",strDCYN="N" 
				//String str_error_level="",str_sysmesage_id="",str_error_text="";
				
		if(patPackSubsDetails.containsKey(patient_id))
		{
			pkgDtls					=(ArrayList)patPackSubsDetails.get(patient_id);		
			if(pkgDtls.size()>0)
			{
				pkgCodes = (ArrayList)pkgDtls.get(0);
				pkgFrmDate = (ArrayList)pkgDtls.get(2);
				pkgToDate = (ArrayList)pkgDtls.get(3);
				pkgAmt = (ArrayList)pkgDtls.get(4);
				blng_class_code_list = (ArrayList)pkgDtls.get(5);
				blng_class_desc_list = (ArrayList)pkgDtls.get(6);			
				payerGrpCode_list=(ArrayList)pkgDtls.get(7);
				payerGrpDesc_list=(ArrayList)pkgDtls.get(8);
				payerCode_list=(ArrayList)pkgDtls.get(9);
				payerDesc_list=(ArrayList)pkgDtls.get(10);			
			}
			int totRec = 0;
			if(pkgCodes.size() >0)
			totRec = pkgCodes.size();		
		for(int i=0;i<totRec;i++)
		{	
			packageCode	=(String)pkgCodes.get(i);
			//Added for MMS-DM-SCF-0013
			try{
				packageCode = packageCode.substring(0,packageCode.lastIndexOf("@:"));
			}
			catch(Exception pkgEx){
				
			}
			//Added for MMS-DM-SCF-0013
			pkg_codes_for_disc = packageCode+"|"+pkg_codes_for_disc;
			fromDate	=(String)pkgFrmDate.get(i);
			toDate	=(String)pkgToDate.get(i);
			packAmt	=(String)pkgAmt.get(i);	
			d_tot_package_amt=d_tot_package_amt+Double.parseDouble(packAmt);
			blng_class_code	=(String)blng_class_code_list.get(i);
			blng_class_desc	=(String)blng_class_desc_list.get(i);
			payerGrpCode	=(String)payerGrpCode_list.get(i);	
			payerGrpDesc	=(String)payerGrpDesc_list.get(i);		
			payerCode	=(String)payerCode_list.get(i);
			payerDesc	=(String)payerDesc_list.get(i);	

			CallableStatement call12 = con.prepareCall("{ call  blpackage.getpackageMinDeposit(?,?,?,?,?,sysdate,?,?,?,?,?)}");		
			call12.setString(1,facilityid);				
			call12.setString(2,packageCode);				
			call12.setString(3,blng_class_code);				
			call12.setString(4,payerGrpCode);	
			call12.setString(5,payerCode);	
			call12.registerOutParameter(6,java.sql.Types.VARCHAR); // p_min_dep_amt      		
			call12.registerOutParameter(7,java.sql.Types.VARCHAR); //p_err_level 			
			call12.registerOutParameter(8,java.sql.Types.VARCHAR); // p_sys_message_id			
			call12.registerOutParameter(9,java.sql.Types.VARCHAR); // p_error_text			
			call12.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text	
		
			call12.execute();				
			ppkgprice	 = call12.getString(6);
			str_min_dep_amt	 = call12.getString(7);	
			str_err_level		 = call12.getString(8);		
			str_sys_message_id	 = call12.getString(9);		
			str_error_text		 = call12.getString(10);			
			call12.close();	

			//Added for MMS-DM-SCF-0013
			if(!"".equals(payerGrpCode) && !"".equals(payerCode)){
				derivedFromDtl = "Y";
				call12 = null;
				call12 = con.prepareCall("{ call  blpackage.getpackagepricedtls(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				call12.setString(1,facilityid);
				call12.setString(2,packageCode);
				if(blng_class_code.equals(""))
					call12.setString(3,null);
				else
					call12.setString(3,blng_class_code);
				call12.setString(4,payerGrpCode);
				call12.setString(5,payerCode);
				call12.registerOutParameter(6,java.sql.Types.VARCHAR);
				call12.registerOutParameter(7,java.sql.Types.VARCHAR);
				call12.registerOutParameter(8,java.sql.Types.VARCHAR);
				call12.registerOutParameter(9,java.sql.Types.VARCHAR);
				call12.registerOutParameter(10,java.sql.Types.VARCHAR);
				call12.registerOutParameter(11,java.sql.Types.VARCHAR);
				call12.registerOutParameter(12,java.sql.Types.VARCHAR);
				call12.registerOutParameter(13,java.sql.Types.VARCHAR);
				
				call12.registerOutParameter(14,java.sql.Types.DATE);
				call12.registerOutParameter(15,java.sql.Types.VARCHAR);
				call12.registerOutParameter(16,java.sql.Types.VARCHAR);
				call12.registerOutParameter(17,java.sql.Types.VARCHAR);
				call12.registerOutParameter(18,java.sql.Types.VARCHAR);
				call12.registerOutParameter(19,java.sql.Types.VARCHAR);
				call12.registerOutParameter(20,java.sql.Types.VARCHAR);
				call12.registerOutParameter(21,java.sql.Types.VARCHAR);
				call12.registerOutParameter(22,java.sql.Types.VARCHAR);
				call12.registerOutParameter(23,java.sql.Types.VARCHAR);
				call12.registerOutParameter(24,java.sql.Types.VARCHAR);
				call12.registerOutParameter(25,java.sql.Types.VARCHAR);
				call12.registerOutParameter(26,java.sql.Types.VARCHAR);
				call12.registerOutParameter(27,java.sql.Types.VARCHAR);
				call12.registerOutParameter(28,java.sql.Types.VARCHAR);
				call12.registerOutParameter(29,java.sql.Types.VARCHAR);
				call12.execute();	

				derivedFromCust = call12.getString(9);
				derivedFromBase = call12.getString(10);
				depositReqYn = call12.getString(21);
				
				if("Y".equals(derivedFromCust)){
					/*
					Code Flow comes here when the given customer definition is
					available in the Package
					*/
					if(!"Y".equals(depositReqYn)){
						ignoreMandValidationDtl = "Y";
					}
				}
				else{
					/*
					Code Flow comes here when the given customer definition is
					unavailable and derived from cash
					*/
					ignoreMandValidationDtl = "Y";
					
					if ( str_min_dep_amt == null ){
						str_min_dep_amt = "";
					}
					
					if("".equals(str_min_dep_amt)){
						str_min_dep_amt = "0.0";
					}
					
					totMinDepositDtl = totMinDepositDtl + Double.parseDouble(str_min_dep_amt);
				}
				
			}
			//Added for MMS-DM-SCF-0013
			
			if ( ppkgprice == null ) ppkgprice = "";
			if ( str_min_dep_amt == null ) str_min_dep_amt = "0.0";
			if ( str_err_level == null ) str_err_level = "";
			if ( str_sys_message_id == null ) str_sys_message_id = "";
			if ( str_error_text == null ) str_error_text = "";	
			if ( !(str_sys_message_id.equals("")))
			{	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(str_sys_message_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
			}
			if ( !(str_error_text.equals("")) || !(str_err_level.equals("")) )
			{	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block14Bytes, _wl_block14);
			}			
			tot_min_dep_amt =tot_min_dep_amt + Double.parseDouble(str_min_dep_amt);
		}
	}
	}else{
		bean1.clearBean();
		putObjectInBean(bean_id1,bean1,request);

            _bw.write(_wl_block15Bytes, _wl_block15);
		}
		}else{
			CallableStatement call1 = null;
			StringTokenizer st_seqno; 
			StringTokenizer st_pkgcode; 
			StringTokenizer st_pkgamt; 
			StringTokenizer st_blng_class;
			sel_list="SELECTED";
			st_pkgcode=new StringTokenizer(pkgCode,"^");
			st_seqno=new StringTokenizer(packseqno,"^");
			st_pkgamt=new StringTokenizer(pkgAmount,"^");
			st_blng_class = new StringTokenizer(blng_class,"^");
			if("Associate".equals(modeOfCall)){
				if(st_pkgamt.hasMoreTokens()){
					pkg_amt_token = st_pkgamt.nextToken();	
					d_tot_package_amt = d_tot_package_amt+Double.parseDouble(pkg_amt_token);
					float minDepAmtReq = 0;
					try{
						minDepAmtReq = Float.parseFloat(request.getParameter("minDepAmtReq"));
					}
					catch(Exception eMin){
						minDepAmtReq = 0;
					}
					tot_min_dep_amt = minDepAmtReq;
				}			
			}
			else {//  Karthik commented the code to calculate Total package amount for subscription cases IN050265 ("Subscription".equals(modeOfCall) || "".equals(modeOfCall))
				boolean isPartDeposit = false;
				while(st_pkgcode.hasMoreTokens()){
					pkg_code_token = st_pkgcode.nextToken();
					pkg_seq_token = st_seqno.nextToken();	
					pkg_amt_token = st_pkgamt.nextToken();	
					//blng_class = st_blng_class.nextToken();
					
					/* Karthik commented the code to calculate Total package amount for subscription cases IN050265- starts */
					String pkgCodeNoDelimiter=stTokpkgCode.nextToken();
					String packseqnoNoDelimiter=stTokSeqNo.nextToken();
					HashMap<String,String> parDepMap = par_dep_bean.getCodesForPackage(patient_id, pkgCodeNoDelimiter, packseqnoNoDelimiter, con);
					if(parDepMap != null){
						blng_class = parDepMap.get("blngClassCode");
					}
					/* Karthik commented the code to calculate Total package amount for subscription cases IN050265- Ends */
					
					isPartDeposit = refBean.checkValidPartialDepositCase(facilityid, patient_id, pkg_code_token, pkg_seq_token, blng_class, con);
					if(isPartDeposit){						
						pkg_amt_token = String.valueOf(refBean.getPartialDepositAmount(facilityid, patient_id, pkg_code_token, pkg_seq_token,con));
						pkgSeqAmtForSub += "^"+pkg_amt_token;
						d_tot_package_amt=d_tot_package_amt+Double.parseDouble(pkg_amt_token);
						str_min_dep_amt = String.valueOf(refBean.getMinimumDepositAmount(facilityid, patient_id, pkg_code_token, pkg_seq_token,con));
					}
					else{
						d_tot_package_amt=d_tot_package_amt+Double.parseDouble(pkg_amt_token);
						call1 = con.prepareCall("{ call  blpackage.get_pkg_deposit_dtls (?,?,?,?,?,?,?,?,?,?)}");			
						call1.setString(1,facilityid);				
						call1.setString(2,pkg_seq_token);				
						call1.setString(3,pkg_code_token);				
						call1.setString(4,pkg_amt_token);											
						call1.registerOutParameter(5,java.sql.Types.VARCHAR); // p_deposit_man_yn   			
						call1.registerOutParameter(6,java.sql.Types.VARCHAR); // p_partial_dep_yn   	
						call1.registerOutParameter(7,java.sql.Types.VARCHAR); // p_min_dep_amt      
						call1.registerOutParameter(8,java.sql.Types.VARCHAR); //p_err_level 
						call1.registerOutParameter(9,java.sql.Types.VARCHAR); // p_sys_message_id
						call1.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text				
						call1.execute();				
						str_deposit_man_yn	 = call1.getString(5);
						str_partial_dep_yn	 = call1.getString(6);
						str_min_dep_amt		 = call1.getString(7);		
						str_err_level		 = call1.getString(8);		
						str_sys_message_id	 = call1.getString(9);		
						str_error_text		 = call1.getString(10);		
						call1.close();	
						if ( str_deposit_man_yn == null ) str_deposit_man_yn = "";
						if ( str_partial_dep_yn == null ) str_partial_dep_yn = "";
						if ( str_min_dep_amt == null ) str_min_dep_amt = "";
						if ( str_err_level == null ) str_err_level = "";
						if ( str_sys_message_id == null ) str_sys_message_id = "";
						if ( str_error_text == null ) str_error_text = "";		
						if ( !(str_sys_message_id.equals("")))
						{	
							
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(str_sys_message_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
						if ( !(str_error_text.equals("")) || !(str_err_level.equals("")) )
						{	
							
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
					}
					tot_min_dep_amt =tot_min_dep_amt + Double.parseDouble(str_min_dep_amt);
				}
			}
			
			
			}
			//bean1.setMinDepAmt(str_min_dep_amt);
			//putObjectInBean(bean_id1,bean1,request);
		}//rec_found_flag
	}
	/************************ENDS PACKAGE BILLING******************************/

		String query_date=" select COLLECT_DEP_DURING_ADM_YN from bl_ip_nursing_unit_type where NURSING_UNIT_TYPE_CODE = (Select nursing_unit_type_code from ip_nursing_unit where nursing_unit_code='"+nursing_unit_code+"' and facility_id='"+facilityid+"') ";
		PreparedStatement pst2=con.prepareStatement(query_date);
		ResultSet rst2 = pst2.executeQuery();
		if (rst2!=null)
		{
		   if (rst2.next())
		   {
				 collect_dep_amt_in_adv_yn = rst2.getString(1);
		   }
		}

		if (rst2 != null)   rst2.close();
		if (pst2 != null)   pst2.close();
		
	
	}catch(Exception ee)
	{
		System.err.println("Error from collect deposit"+ee);
		ee.printStackTrace();

	}

	try{
		double factor =  Math.pow(10, 2);
		d_tot_package_amt = Math.round(d_tot_package_amt * factor)/factor;
		tot_min_dep_amt = Math.round(tot_min_dep_amt * factor)/factor;
	}
	catch(Exception ex){
		
	}
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(collect_dep_amt_in_adv_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);

		try{
			String sqlQ=" select nvl(DOWNTIME_ENTRIES_ALLOW_DAYS,0), DOWNTIME_RECEIPT_DOC_TYPE, DOWNTIME_REFUND_DOC_TYPE  from bl_parameters where operating_facility_id = '"+facilityid+"'";
			pstmt = con.prepareStatement(sqlQ);
			rs = pstmt.executeQuery();	
			while(rs.next())
				{
				   strDownTimeAllowDays  =  rs.getString(1);	
				   receiptDownCode = rs.getString("DOWNTIME_RECEIPT_DOC_TYPE");
				   refundDownCode = rs.getString("DOWNTIME_REFUND_DOC_TYPE");
				}	
				rs.close();
				pstmt.close();
		
	
				CallableStatement call = 
				con.prepareCall(
				"{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");			
				call.setString(1,facilityid);				
				call.setString(2,episode_type);				
				call.setString(3,strloggeduser);				
				call.setString(4,strclientip);				
				call.registerOutParameter(5,java.sql.Types.VARCHAR); // Cash Counter
				
				call.registerOutParameter(6,java.sql.Types.VARCHAR); // shift
				
				call.registerOutParameter(7,java.sql.Types.VARCHAR); // Error code
				
				call.execute();				

				cash_counter_code	 = call.getString(5);
				shift_id		 = call.getString(6);
				sys_message_id	 = call.getString(7);		
				call.close();	
				if ( cash_counter_code == null ) cash_counter_code = "";
				if ( shift_id == null ) shift_id = "";
				if ( sys_message_id == null ) sys_message_id = "";		

				if ( !(sys_message_id.equals("")))
				{	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sys_message_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
				}

				/*String recauth=null;
				pstmt=con.prepareCall("select Distinct RECEIPT_AUTH_YN from bl_users_for_credit_auth where operating_facility_id = '"+facilityid+"' AND upper(credit_auth_user_id) = upper('"+strloggeduser+"')");	
					//rs=pstmt.execute();
					 rs = pstmt.executeQuery();	
						if( rs != null ) 
						{
							if( rs.next() )
							{			
								recauth  =  rs.getString(1);	
							}
						}
						System.out.println("query returned value recauth "+recauth);*/
				/*	if(recauth.equals("N"))
					{*/
			
            _bw.write(_wl_block23Bytes, _wl_block23);
		//}
		

			String sqlRcptRfnd="{ call blcommon.get_receipt_refund_check('"+facilityid+"','"+cash_counter_code+"',?,?,?,?,?,?,?,?)}";
			call = con.prepareCall(sqlRcptRfnd);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.execute();
			rcpt_ip_allowed_yn=call.getString(1);
			rcpt_op_allowed_yn=call.getString(2);
			rcpt_ref_allowed_yn=call.getString(3);
			rfnd_ip_allowed_yn=call.getString(4);
			rfnd_op_allowed_yn=call.getString(5);
			rfnd_ref_allowed_yn=call.getString(6);
			sys_message_id=call.getString(7);
			error_text=call.getString(8);
			
			if(rcpt_ip_allowed_yn==null) rcpt_ip_allowed_yn="";
			if(rcpt_op_allowed_yn==null) rcpt_op_allowed_yn="";
			if(rcpt_ref_allowed_yn==null) rcpt_ref_allowed_yn="";
			if(rfnd_ip_allowed_yn==null) rfnd_ip_allowed_yn="";
			if(rfnd_op_allowed_yn==null) rfnd_op_allowed_yn="";
			if(rfnd_ref_allowed_yn==null) rfnd_ref_allowed_yn="";
			if(sys_message_id==null) sys_message_id="";
			if(error_text==null) error_text="";
			call.close();
			String sqlChkRfnd="{ call blcommon.check_for_refund('"+strloggeduser+"','"+facilityid+"','"+cash_counter_code+"',?,?,?)}";
			call = con.prepareCall(sqlChkRfnd);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);			
			call.execute();
		 
			rfnd_allowed_yn = call.getString(1);
			sys_message_id = call.getString(2);
			error_text = call.getString(3);
			
			if(rfnd_allowed_yn==null) rfnd_allowed_yn="";
			if(sys_message_id==null) sys_message_id="";
			if(error_text==null) error_text="";

			call.close();
			if ( !(sys_message_id.equals("")) || !(error_text.equals("")) )
				{	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sys_message_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
				}


			String sqlChkRcpt="{ call blcommon.check_for_receipt('"+strloggeduser+"','"+facilityid+"','"+cash_counter_code+"',?,?,?)}";
			call = con.prepareCall(sqlChkRcpt);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);			
			call.execute();
		 
			rcpt_allowed_yn = call.getString(1);
			sys_message_id = call.getString(2);
			error_text = call.getString(3);
			
			if(rcpt_allowed_yn==null) rcpt_allowed_yn="";
			if(sys_message_id==null) sys_message_id="";
			if(error_text==null) error_text="";

			call.close();
			if ( !(sys_message_id.equals("")) || !(error_text.equals("")) )
				{	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sys_message_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
				}

			String sqlD="select DOWNTIME_RECEIPT_DOC_TYPE, DOWNTIME_REFUND_DOC_TYPE  from   BL_PARAMETERS  where  OPERATING_FACILITY_ID = '"+facilityid+"' ";
			pstmt = con.prepareStatement(sqlD);
			rs = pstmt.executeQuery();	
			while(rs.next())
				{
				   strDownTimeRcptDocType =  rs.getString(1);							
				   strDownTimeRfndDocType =  rs.getString(2);							
				}	

				if(strDownTimeRcptDocType==null) strDownTimeRcptDocType="";
				if(strDownTimeRfndDocType==null) strDownTimeRfndDocType="";


				rs.close();
				pstmt.close();	
				
	/*************************added for package billing***************************/
			String sqlN="";
			/*if(function_id.equals("PKG_BILLING"))
			{
				 sqlN="select LONG_DESC RCPT_NATURE_DESC, RECPT_NATURE_CODE RCPT_NATURE_CODE from BL_RECEIPT_NATURE_LANG_VW  where RECPT_NATURE_CODE ='PK' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') ";
			}else{*/
				 sqlN="select LONG_DESC RCPT_NATURE_DESC, RECPT_NATURE_CODE RCPT_NATURE_CODE from BL_RECEIPT_NATURE_LANG_VW  where RECPT_NATURE_CODE ='AD' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"') ";
			//}		
			pstmt = con.prepareStatement(sqlN);
			rs = pstmt.executeQuery();	
			while(rs.next())
				{
				   strRecptNaturedesc=  rs.getString(1);							
				   strRecptNatureCode =  rs.getString(2);							
				}	
				if(strRecptNaturedesc==null) strRecptNaturedesc="";
				if(strRecptNatureCode==null) strRecptNatureCode="";


				rs.close();
				pstmt.close();	
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{	noofdecimal  =  rscurr.getInt(1);}	
		if(rscurr != null) rscurr.close();
		pstmt.close();
	//	pkgAmount=cf.formatCurrency(pkgAmount, noofdecimal);
		pstmt = con.prepareStatement( "SELECT  NVL(EXT_ACCOUNT_INTERFACE_YN,'N') FROM BL_PARAMETERS  WHERE OPERATING_FACILITY_ID='"+facilityid+"' ");
		rs = pstmt.executeQuery();	
		while(rs.next())
		{	ext_acc_int_YN  =  rs.getString(1);}	
		if(rs != null) rs.close();
		pstmt.close();

		pstmt = con.prepareStatement( "SELECT NVL(TOT_ADM_DEP_AMT,0)-NVL(TOT_ADM_DEP_PAID_AMT,0) tot_adm_dep_amt,NVL(TOT_TRF_DEP_AMT,0)-NVL(TOT_TRF_DEP_PAID_AMT,0) tot_trf_dep_amt ,NVL(TOT_OTH_DEP_AMT,0)-NVL(TOT_OTH_DEP_PAID_AMT,0) tot_othr_dep_amt,NVL(TOT_ADM_DEP_PAID_AMT,0) FROM   BL_EPISODE_FIN_DTLS WHERE operating_facility_id = '"+facilityid+"' and EPISODE_TYPE in ('D','I')   AND    EPISODE_ID   = '"+episode_id+"' ");
		rs = pstmt.executeQuery();	
		while(rs.next())
		{	
			tot_adm_dep_amt  =  rs.getString(1);			
			tot_trf_dep_amt  =  rs.getString(2);
			tot_othr_dep_amt  =  rs.getString(3);			
			tot_adm_dep_paid_amt  =  rs.getString(4);
		}	

				if(tot_adm_dep_amt==null) tot_adm_dep_amt="";
				if(tot_trf_dep_amt==null) tot_trf_dep_amt="";
				if(tot_othr_dep_amt==null) tot_othr_dep_amt="";
				if(tot_adm_dep_paid_amt==null) tot_adm_dep_paid_amt="";

				tot_adm_dep_amt=cf.formatCurrency(tot_adm_dep_amt, noofdecimal);
		if(rs != null) rs.close();
		pstmt.close();

		pstmt = con.prepareStatement( "select blcommon.get_reln_code('"+patient_id+"') from dual");
		rs = pstmt.executeQuery();	
		while(rs.next())
		{	
			reln_code  =  rs.getString(1);			
		}	
		if(rs != null) rs.close();
		pstmt.close();

		if(reln_code==null) reln_code="";

		}catch(Exception e)
		{
			System.err.println("str days error="+e.toString());
			e.printStackTrace();
		}

		


            _bw.write(_wl_block25_0Bytes, _wl_block25_0);
            _bw.write(_wl_block25_1Bytes, _wl_block25_1);
            _bw.write(_wl_block25_2Bytes, _wl_block25_2);
            out.print( String.valueOf(d_tot_package_amt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(str_partial_dep_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_min_dep_amt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tot_min_dep_amt));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tot_package_amt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(d_tot_package_amt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(doc_amt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(doc_amt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(d_tot_package_amt));
            _bw.write(_wl_block34Bytes, _wl_block34);

	System.err.println("Function_id in BLDepositRefund.jsp: "+function_id);
	System.err.println("dfltRcptTypeForDeposit in BLDepositRefund.jsp: "+dfltRcptTypeForDeposit);
	if(dfltRcptTypeForDeposit){

            _bw.write(_wl_block35Bytes, _wl_block35);
 
	}
	else
	{

            _bw.write(_wl_block36Bytes, _wl_block36);

	}

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strDownTimeAllowDays));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(misc_rcpt_type));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(facilityid ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rcpt_ip_allowed_yn ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rcpt_ref_allowed_yn ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(rcpt_op_allowed_yn ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(rfnd_ip_allowed_yn ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(rfnd_op_allowed_yn ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(rfnd_ref_allowed_yn ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(rfnd_allowed_yn ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(rcpt_allowed_yn ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strDownTimeRcptDocType ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(strDownTimeRfndDocType ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(noofdecimal ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tot_adm_dep_amt ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(tot_trf_dep_amt ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(tot_othr_dep_amt ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(tot_adm_dep_paid_amt ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(collect_dep_amt_in_adv_yn ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(shift_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(ext_acc_int_YN));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(pkgAmount));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(tot_package_amt));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(d_tot_package_amt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(reln_code));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(funct_mode));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(str_deposit_man_yn));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(packseqno));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(pkgCode));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(str_min_dep_amt));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(tot_min_dep_amt));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(pkgSeqAmtForSub));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(ignoreMandValidationDtl));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(derivedFromDtl));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totMinDepositDtl ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strRecptNatureCode));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(recptTypCode));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(recptTypLongDesc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(splAgnDepYN));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(strCustomerId ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(refundDownCode ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(receiptDownCode ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(calledFrom ));
            _bw.write(_wl_block118Bytes, _wl_block118);

	}
	catch(Exception e )
	{ 
		System.err.println("BLEnterServiceSerachResult:"+e);
		e.printStackTrace();
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block119Bytes, _wl_block119);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DownTimeEntry.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DocumentNo.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DocNoslash.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DepositDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DepositReason.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REC_NATURE.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECEIPT_REFUND.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECEIPT_TYPE.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DEPOSIT_TYPE.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADM_DEP.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TRN_DEP.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OTH_DEP.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PKG_DEP.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DepositAgainstSurgery.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.requestid.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BookingReference.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ACCOUNT_CODE.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.department.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TotalBillAmount.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillPaidAmount.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OriginalDocNo.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DocNoslash.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DocNoslash.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.THRU_MAIL.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }
}
