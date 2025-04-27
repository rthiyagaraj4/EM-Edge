package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eBL.BLReportIdMapper;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import java.net.*;
import eXH.*;
import java.util.*;
import com.ehis.util.*;

public final class __blbillslmttype2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtType2.jsp", 1737915620399L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\t   Developer Name\n-----------------------------------------------------------------------------------------------\n1            V210113            8157          \tNMC-JD-CRF-0072               \tShikha Seth\n2            V210224            8157          \tNMC-JD-CRF-0072               \tShikha Seth\n3            V210319            16156          \tNMC-JD-CRF-0072.2            \tShikha Seth\n4\t\t\t\t\t\t\t\t15771\t       \tNMC-JD-SCF-0164\t\t\t\t\tSethuraman D\n5            V210624            20638          \tNMC-JD-SCF-0206               \tMuthukumarN\n6\t\t\t\t\t\t\t\t15858\t\t\tMOHE-CRF-0076\t\t\t\t\tSethuraman D\n7\t\t\t V211014\t\t\t25015\t\t    MMS-DM-SCF-0790\t\t\t\t\t MohanaPriya K\n8\t     \t\t\t\t\t\t\t\t\t\tMOHE-SCF-0179\t\t\t\t\tSethuraman D\n9\t\t\t V220721\t\t\t31991\t\t\tTH-KW-CRF-0017\t\t\t\t\t MohanaPriya K\n10\t\t\tV220808\t\t\t\t35014\t\tBL-TH-KW-CRF-0017-US001/03-Other\n\t\t\t\t\t\t\t\t\t\t\t\tSettlement types\t\t\t\tMohanaPriya K\n11\t\t\tV230418/V230824\t\t\t\t\t\t\tMMS-DM-SCF-0861\t\t\t\t\tMohanapriya\n12\t\tV230627\t\t45564\t\tML-MMOH-CRF-1928.2\t\tGopinath R\n13\t\t\t\t\t\t\t\t39579\t\tNMC-JD-CRF-0199\t\t\t\t\t\tMonika Gupta\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\n\t\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\';\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\talert(v_error);\t\t\t\t \t\t\t\t\t\t\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'BL\'));\n\t\t\t\t\t\t//alert(\"Invalid Credit Card Number\");\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.forms[0].instref.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].batchno.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].saledraftno.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].payername.value=\"\";\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\t\n\t\t\t\t<script>\t\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.disabled=true;\n\t\t\t\t\tparent.frames[0].document.forms[0].slmttype.disabled=true;\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\n\t\t\t\t<script> \n\t\t\t\t\tvar v_error_text = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\t\t\t\t\t\n\t\t\t\t\tif ( v_error_text != \'\')\n\t\t\t\t    {\n\t\t\t\t\t\talert(v_error_text);\n\t\t\t\t\t\t//return false;\n\t\t\t\t\t\t//window.close();\t\n\t\t\t\t\t}\n\t\t\t\t</script>  \n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<html>\n  \t\t<head>\n\t\t\t<meta charset=\"utf-8\">\n\t\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n\t\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n\t\t<!--<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>-->\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eBL/js/AddModifyPatFinDetails.js\"></script>\n<!--\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\t\t\n\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eBL/js/BLDepositReceipt.js\"></script>\n\t\t\t<!--Added by Sethu for GHL-CRF-0415 on 19/04/2017-->\n\t\t\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\n\t<script>\t\n\t\t$(document).ready(function(){\n\n\t\t\tvar cash_slmt_tpe = $(\'#cashslmtflag\').val();\n\t\t\tvar chequeLengthChange = $(\'#chequeLengthChange\').val();\n\n\t\t\tif((chequeLengthChange == true || chequeLengthChange == \'true\') && cash_slmt_tpe == \'D\'){\n\t\t\t\t$(\'#instref\').attr(\'maxlength\',100);\n\t\t\t\t$(\'#tdChqCarfBankNo\').text(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15_0 ="\');\n\t\t\t}\n\n\t\t\tvar action_ind = $(\'#action_ind\').val();\n\n\t\t\tif (action_ind == \"add\" || action_ind == \"modify\"){\n\t\t\t\tdisp_valid_button();\n\t\t\t}\n\t\t});\n\t\t// This Function has been copied from Common JS file as we needed the last five sepcial characters to be allowed(/-. )\n\t\tfunction CheckForSpecChars_tid(event)\n\t\t{\n\t\t    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-# \';  // Added by Monika against NMC-JD-CRF-0199......\n\t\t    var whichCode = (window.Event) ? event.which : event.keyCode;\n\t\t    key = String.fromCharCode(whichCode);  // Get key value from key code\n\t\t    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n//\t\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n//\t\t\t\treturn (event.keyCode -= 32);\n\t\t\treturn true ;\n\t\t}\n\t\t\n\t\tfunction validate_py_tranx(trans)\n\t\t{\n\t\t\tvar returnData = \"\";\n\t\t\tvar patientID = \"\";\n\t\t\tvar payTMUserCode = \"\";\n\t\t\tvar payAmount = \"\";\n\t\t\tvar payTMPromoCode = \"\";\n\t\t\tvar merchantOrderID = \"\";\n\t\t\t\n\t\t\tvar payTMReturnStr = \"\";\n\t\t\tvar payTMData = \"\";\n\n\t\t\tvar errMessage = \"\";\n\n\t\t\tvar payTMTransDate = \"\";\n\n\t\t\tvar payTransStatus = \"\";\n\t\t\tvar loggedUser = \"\";\n\t\t\tvar facilityid = \"\";\n\n\t\t\tvar frm = document.BillSlmtTypeForm;\n\t\t\tvar rad = frm.PayTMOption;\n\t\t\tvar selection = \'\';\n\t\t\tfor(var i=0;i<rad.length;i++){\n\t\t\t\tif(rad[i].checked){\n\t\t\t\t\tselection = rad[i].value;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tvar otp = \"\";\n\n\t\t\tvar errMess = \"\";\n\n\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\n\t\t\tif(parent.frames[0].document.forms[0].billpayableamt.value != \"\")\n\t\t\t{\n\t\t\t\tpatientID = document.forms[0].patientid.value;\t\t\t\n\t\t\t\tpayTMUserCode = document.forms[0].instref.value;\n\t\t\t\tpayAmount = parent.frames[0].document.forms[0].billpayableamt.value;\n\t\t\t\tpayTMPromoCode = document.forms[0].batchno.value;\n\n\t\t\t\tmerchantOrderID = document.forms[0].saledraftno.value;\n\n\t\t\t\tloggedUser = document.forms[0].LoggedUser.value;\n\t\t\t\tfacilityid = document.forms[0].facilityid.value;\t\n\t\t\t\tclientIpAddress = document.forms[0].clientIpAddress.value;\n\t\t\t\t\n\t\t\t\tif (selection == \"T\")\n\t\t\t\t\totp = document.forms[0].paytmOtp.value;\n\t\t\t\telse\n\t\t\t\t\totp = \"\";\n\t\t\t\t\n\t\t\t\tif (trans == \"PAY\") {\n\n\t\t\t\t\tif (selection == \"B\"){\n\t\t\t\t\t\t\n\t\t\t\t\t\tif (document.forms[0].instref.value == \"\"){\n\t\t\t\t\t\t\talert(\" PayTM User Code cannot be empty, kindly scan the PayTM user code.\");\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\tif (selection == \"T\"){\n\n\t\t\t\t\t\tif (document.forms[0].instref.value == \"\"){\n\t\t\t\t\t\t\talert(\" PayTM Phone Number cannot be empty, kindly enter the 10 digit phone number and the OTP.\");\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t}\n\n\t\t\t\t\tif (selection == \"T\"){\n\t\t\t\t\t\tif (document.forms[0].paytmOtp.value == \"\"){\n\t\t\t\t\t\t\talert(\" PayTM OTP cannot be empty, kindly enter the PayTM OTP.\");\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t}\n\n\t\t\t\t\tif (document.forms[0].instref.value != \"\"){\n\n\t\t\t\t\t\tpayTMUserCode = document.forms[0].instref.value;\n\n\t\t\t\t\t\t//--l_req := \'<PATIENT_ID>0924168$!^<PAYTM_CODE>281005028j8ym3yygE56E72c$!^<AMOUNT>0.01$!^<PROMO_CODE>$!^<REQUEST>WITHDRAW_MONEY$!^<REQUEST_TYPE>merchantTxnId$!^<ORDER_ID>$!^<TRN_TYPE>withdraw$!^<TRN_GUID>$!^<SESSION_ID>REGPAT$!^<USER>SETHU$!^<FACILITY_ID>DF$!^\';\n\t\t\t\t\t\treturnData = \"<PATIENT_ID>\"+patientID+\"$!^<PAYTM_CODE>\"+payTMUserCode+\"$!^<AMOUNT>\"+payAmount+\"$!^<PROMO_CODE>\"+payTMPromoCode+\"$!^<REQUEST>WITHDRAW_MONEY$!^<REQUEST_TYPE>merchantTxnId$!^<ORDER_ID>$!^<TRN_TYPE>withdraw$!^<TRN_GUID>$!^<SESSION_ID>REGPAT$!^<USER>\"+loggedUser+\"$!^<FACILITY_ID>\"+facilityid+\"$!^<PAYBY_OPTION>\"+selection+\"$!^<OTP>\"+otp+\"$!^<USER_WSNO>\"+clientIpAddress+\"$!^\";\n\t\t\t\t\t}\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if (trans == \"CHECKSTATUS\") {\n\t\t\t\t\tif (document.forms[0].saledraftno.value != \"\"){\n\t\t\t\t\t\t//l_req := \'<PATIENT_ID>0924168$!^<PAYTM_CODE>281005028j8ym3yyg9019E2c$!^<AMOUNT>0.01$!^<PROMO_CODE>$!^<REQUEST>CHECK_STATUS$!^<REQUEST_TYPE>merchantTxnId$!^<ORDER_ID>5009$!^<TRN_TYPE>withdraw$!^<TRN_GUID>9447270090$!^<SESSION_ID>REGPAT$!^<USER>SETHU$!^<FACILITY_ID>DF$!^\';\n\t\t\t\t\t\treturnData = \"<PATIENT_ID>\"+patientID+\"$!^<PAYTM_CODE>\"+payTMUserCode+\"$!^<AMOUNT>\"+payAmount+\"$!^<PROMO_CODE>\"+payTMPromoCode+\"$!^<REQUEST>CHECK_STATUS$!^<REQUEST_TYPE>merchantTxnId$!^<ORDER_ID>\"+merchantOrderID+\"$!^<TRN_TYPE>withdraw$!^<TRN_GUID>$!^<SESSION_ID>REGPAT$!^<USER>\"+loggedUser+\"$!^<FACILITY_ID>\"+facilityid+\"$!^<PAYBY_OPTION>\"+selection+\"$!^<OTP>\"+otp+\"$!^<USER_WSNO>\"+clientIpAddress+\"$!^\";\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\talert(\" To check PayTM Transaction staus, Merchant Order ID cannot be empty, kindly enter the Merchant Order ID.\");\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\n\t\t\t\t}\n\n\t\t\t\t\n\t\t\t\tif (returnData.length > 0){\n\n\t\t\t\t\tpayTMReturnStr = payTMTransaction(returnData);\n\n\t\t\t\t\tif (!(payTMReturnStr.indexOf(\"$!^\") > 0))\n\t\t\t\t\t{\n\t\t\t\t\t\tif (payTMReturnStr.indexOf(\"ORA-12535\")>0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\terrMess = \"<H5 style=\'color:blue\'>EM Web Service Error - Issue with EM Web service Configuration, Kindly check with System Administrator. </H5>\" +\"<br>\" ;\n\t\t\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\t\t\treturn false; \n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif (payTMReturnStr.indexOf(\"ORA-12541\")>0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\terrMess = \"<H5 style=\'color:blue\'>EM Web Service Error - EM Web Service is not running, Kindly check with System Administrator. </H5>\" +\"<br>\" ;\n\t\t\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\t\t\treturn false; \n\t\t\t\t\t\t}\n\n\t\t\t\t\t\terrMess = \"<H5 style=\'color:blue\'>EM Application Error - \"+payTMReturnStr+\" </H5>\" +\"<br>\" ;\n\t\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\t\treturn false; \n\n\t\t\t\t\t}\n\n\t\t\t\t\tpayTMData = payTMReturnStr.split(\"$!^\");\n\n\t\t\t\t\tvar errMess = \"\" ;\n\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\n\t\t\t\t\tif (payTMData.length > 0)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].saledraftno.disabled = false;\n\t\t\t\t\t\tdocument.forms[0].apprrefno.disabled = false;\n\t\t\t\t\t\tdocument.forms[0].instdate.disabled = false;\n\n\t\t\t\t\t\tif (payTMData[0] == \"SUCCESS\"){\n\t\t\t\t\t\t\tdocument.forms[0].instref.disabled = true;\n\t\t\t\t\t\t\tdocument.forms[0].paytmOtp.disabled = true;\n\t\t\t\t\t\t\tdocument.forms[0].batchno.disabled = true;\n\t\t\t\t\t\t\tdocument.forms[0].saledraftno.disabled = true;\n\t\t\t\t\t\t\tdocument.forms[0].apprrefno.disabled = true;\n\t\t\t\t\t\t\tdocument.forms[0].instdate.disabled = true;\n\t\t\t\t\t\t\tfor(var i=0;i<rad.length;i++){\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\trad[i].disabled = true;\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\tdocument.forms[0].validate_paytm_pay.disabled = true;\t\t\t\t\t\t\n\n\t\t\t\t\t\t\tdocument.forms[0].saledraftno.value = payTMData[3];\n\t\t\t\t\t\t\tdocument.forms[0].apprrefno.value = payTMData[4];\n\t\t\t\t\t\t\tdocument.forms[0].instdate.value = payTMData[5];\n\n\t\t\t\t\t\t\tif (trans == \"PAY\") {\n\t\t\t\t\t\t\t\tdocument.forms[0].PayTMTransDate.value = payTMData[5];\n\t\t\t\t\t\t\t\tpayTransStatus = \"Payment \";\n\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif (trans == \"CHECKSTATUS\") \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tpayTransStatus = \"Check Status \";\n\t\t\t\t\t\t\t\tpayTMTransDate = document.forms[0].PayTMTransDate.value;\t\n\n\t\t\t\t\t\t\t\tif (payTMTransDate.length > 0)\n\t\t\t\t\t\t\t\t\tdocument.forms[0].instdate.value = payTMTransDate;\n\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\terrMess = \"<H5 style=\'color:green\'>\"+payTransStatus+\"Transaction - Successful</H5>\" +\"<br>\" ;\n\t\t\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\t\t\treturn false; \n\t\t\t\t\t\t}\n\t\t\t\t\t\telse \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tfor(var i=0;i<rad.length;i++){\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\trad[i].disabled = false;\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tdocument.forms[0].instref.disabled = false;\n\t\t\t\t\t\t\tdocument.forms[0].paytmOtp.disabled = false;\n\t\t\t\t\t\t\tdocument.forms[0].batchno.disabled = false;\n\t\t\t\t\t\t\tdocument.forms[0].saledraftno.value = payTMData[3];\t\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.forms[0].apprrefno.value = \"\";\n\t\t\t\t\t\t\tdocument.forms[0].instdate.value = \"\";\n\t\t\t\t\t\t\tdocument.forms[0].PayTMTransDate.value = \"\";\n\t\t\t\t\t\t\terrMessage = payTMData[1] + \" - \" + payTMData[2];\n\t\t\t\t\t\t\terrMess = \"<H5 style=\'color:red\'>Transaction declined - \"+errMessage+\"</H5>\" +\"<br>\" ;\n\t\t\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\t\t\treturn false; \n\t\t\t\t\t\t}\n\n\t\t\t\t\t}\n\n\n\t\t\t\t}\n\t\t\t}\t\t\t\n\t\t}\n\t\t//Added by Sethu for GHL-CRF-0415 on 19/04/2017\n\n\t\tfunction disp_valid_button()\n\t\t{\t\n\t\t\tvar str_credit_card_machine_int_yn=document.forms[0].str_credit_card_machine_int_yn.value;\t\t\n\n\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'none\';\n\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'none\';\n\n\t\t\tif(document.forms[0].str_credit_card_machine_int_yn.value==\"Y\" && document.forms[0].application_id.value!=\"PAYTM\") \n\t\t\t{\t\t\t\n\t\t\t\tif(parent.frames[0].document.forms[0].billpayableamt.value != \"\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'inline\';\n\t\t\t\t\t//Added by Sethu for KDAH-CRF-0504 on 14/08/2019\n\t\t\t\t\tif (document.forms[0].credit_card_status_yn.value==\"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'inline\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'none\';\n\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'none\';\n\t\t\t}\n\n\t\t\t//Added by Sethu for MOHE-CRF-0076 on 04/08/2021 - STARTS HERE\n\t\t\tif(document.forms[0].str_credit_card_machine_int_yn.value==\"Y\" && document.forms[0].application_id.value!=\"PAYSKY\") \n\t\t\t{\t\n\t\t\t\tif(parent.frames[0].document.forms[0].billpayableamt.value != \"\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'inline\';\n\t\t\t\t\t//Added by Sethu for KDAH-CRF-0504 on 14/08/2019\n\t\t\t\t\tif (document.forms[0].credit_card_status_yn.value==\"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'inline\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\n\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'none\';\n\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'none\';\n\t\t\t}\n\t\t\t\n\t\t\t//Added by Sethu for MOHE-CRF-0076 on 04/08/2021 - ENDS HERE\n\n\t\t\tif(document.forms[0].application_id.value==\"PAYTM\")\n\t\t\t{\n\n\t\t\t\tdocument.getElementById(\"show_payTM_field1\").style.display=\'inline\';\n\t\t\t\tdocument.getElementById(\"show_payTM_field2\").style.display=\'inline\';\n\t\t\t\tdocument.getElementById(\"show_payTM_field3\").style.display=\'inline\';\n\t\t\t\tdocument.getElementById(\"show_payTM_field4\").style.display=\'inline\';\n\t\t\t\tif(document.forms[0].str_credit_card_machine_int_yn.value==\"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"show_payTM_button1\").style.display=\'inline\';\n\t\t\t\t\tdocument.getElementById(\"show_payTM_button2\").style.display=\'inline\';\n\t\t\t\t}\n\n\t\t\t}\n\n\t\t\t//Added by Sethu for MOHE-CRF-0076 on 04/08/2021 - STARTS HERE\n\n\t\t\tif(document.forms[0].application_id.value==\"PAYSKY\")\n\t\t\t{\n\n\t\t\t\tif(document.forms[0].str_credit_card_machine_int_yn.value==\"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"show_paysky_button1\").style.displa";
    private final static byte[]  _wl_block15_0Bytes = _getBytes( _wl_block15_0 );

    private final static java.lang.String  _wl_block15_1 ="y=\'inline\';\n\t\t\t\t}\n\n\t\t\t}\n\t\t\t//Added by Sethu for MOHE-CRF-0076 on 04/08/2021 - ENDS HERE\n\n\t\t}\n\n\t\t//Added by Sethu for GHL-CRF-0415.2 on 02/02/2018\n\n\t\tfunction fnChangePayTM()\n\t\t{\t\n\n\t\t\tvar frm = document.BillSlmtTypeForm;\n\t\t\tvar rad = frm.PayTMOption;\n\t\t\tvar selection = \'\';\n\t\t\tfor(var i=0;i<rad.length;i++){\n\t\t\t\tif(rad[i].checked){\n\t\t\t\t\tselection = rad[i].value;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tvar str_credit_card_machine_int_yn=document.forms[0].str_credit_card_machine_int_yn.value;\t\n\t\t\t\n\t\t\tdocument.getElementById(\"show_payTM_field1\").style.display=\'none\';\n\t\t\tdocument.getElementById(\"show_payTM_field2\").style.display=\'none\';\n\t\t\tdocument.getElementById(\"show_payTM_field3\").style.display=\'none\';\n\t\t\tdocument.getElementById(\"show_payTM_field4\").style.display=\'none\';\n\t\t\n\t\t\tdocument.getElementById(\"show_payTM_phone1\").style.display=\'none\';\n\t\t\t//document.getElementById(\"show_payTM_phone2\").style.display=\'none\';\n\t\t\tdocument.getElementById(\"show_payTM_otp1\").style.display=\'none\';\n\t\t\tdocument.getElementById(\"show_payTM_otp2\").style.display=\'none\';\n\n\t\t\tdocument.getElementById(\"instref\").value = \"\";\n\t\t\n\t\t\tif(selection == \'B\'){\t\t\n\n\t\t\t\tdocument.getElementById(\"instref\").size = \"30\";\n\n\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'none\';\n\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'none\';\n\n\t\t\t\tif(document.forms[0].str_credit_card_machine_int_yn.value==\"Y\" && document.forms[0].application_id.value!=\"PAYTM\") \n\t\t\t\t{\t\t\t\n\t\t\t\t\tif(parent.frames[0].document.forms[0].billpayableamt.value != \"\")\n\t\t\t\t\t{\t\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'inline\';\n\t\t\t\t\t\t//Added by Sethu for KDAH-CRF-0504 on 14/08/2019\n\t\t\t\t\t\tif (document.forms[0].credit_card_status_yn.value==\"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'inline\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'none\';\n\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'none\';\n\t\t\t\t}\n\n\n\t\t\t\tif(document.forms[0].application_id.value==\"PAYTM\")\n\t\t\t\t{\n\n\t\t\t\t\tdocument.getElementById(\"show_payTM_field1\").style.display=\'inline\';\n\t\t\t\t\tdocument.getElementById(\"show_payTM_field2\").style.display=\'inline\';\n\t\t\t\t\tdocument.getElementById(\"show_payTM_field3\").style.display=\'inline\';\n\t\t\t\t\tdocument.getElementById(\"show_payTM_field4\").style.display=\'inline\';\n\t\t\t\t\tif(document.forms[0].str_credit_card_machine_int_yn.value==\"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\"show_payTM_button1\").style.display=\'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"show_payTM_button2\").style.display=\'inline\';\n\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(selection == \'T\'){\t\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\"instref\").size = \"14\";\n\n\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'none\';\n\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'none\';\n\n\t\t\t\tif(document.forms[0].str_credit_card_machine_int_yn.value==\"Y\" && document.forms[0].application_id.value!=\"PAYTM\") \n\t\t\t\t{\t\t\t\n\t\t\t\t\tif(parent.frames[0].document.forms[0].billpayableamt.value != \"\")\n\t\t\t\t\t{\t\t\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'inline\';\n\t\t\t\t\t\t//Added by Sethu for KDAH-CRF-0504 on 14/08/2019\n\t\t\t\t\t\tif (document.forms[0].credit_card_status_yn.value==\"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'inline\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button\").style.display=\'none\';\n\t\t\t\t\tparent.frames[0].document.getElementById(\"show_button_status\").style.display=\'none\';\n\t\t\t\t}\n\n\n\t\t\t\tif(document.forms[0].application_id.value==\"PAYTM\")\n\t\t\t\t{\n\n\t\t\t\t\tdocument.getElementById(\"show_payTM_phone1\").style.display=\'inline\';\n\t\t\t\t\tdocument.getElementById(\"show_payTM_field2\").style.display=\'inline\';\n\t\t\t\t\tdocument.getElementById(\"show_payTM_otp1\").style.display=\'inline\';\n\t\t\t\t\tdocument.getElementById(\"show_payTM_otp2\").style.display=\'inline\';\n\t\t\t\t\tdocument.getElementById(\"show_payTM_field3\").style.display=\'inline\';\n\t\t\t\t\tdocument.getElementById(\"show_payTM_field4\").style.display=\'inline\';\n\t\t\t\t\tif(document.forms[0].str_credit_card_machine_int_yn.value==\"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\"show_payTM_button1\").style.display=\'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"show_payTM_button2\").style.display=\'inline\';\n\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tfunction showCalendar_loc(Val1, Val2)\n\t\t{\t\n\t\t\tif (Val2.disabled == true)\t\t\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn showCalendar(Val1);\n\t\t\t}\n\t\t}\n\t\t/*function chkDateAftSysDate(instdate,sys_date)\n\t\t{\n\t\t\tvar locale=document.forms[0].locale.value;\n\t\t\talert(\"date\");\n\t\t\talert(\"instdate \"+instdate.value);\n\t\t\t\n\t\t\tif(instdate.value!=\"\")\n\t\t\t{\n\t\t\t\tif((validDate(instdate.value,\'DMY\',locale)))\n\t\t\t\t{\n\t\t\t\t\tvar instDate = instdate.value ;\n\t\t\t\t\tvar sysDate = sys_date.value;\n\t\t\t\t\tif(isAfterNow(instDate,\'DMY\',locale))\n\t\t\t\t\t{\n\t\t\t\t\t\treturn true;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL9115\",\'BL\'));\n\t\t\t\t\t\tinstdate.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}*/\n\t\tfunction ChkNumberInput2(fld, e, deci)\n\t\t{ \n\t\t\t\n\t\t\tvar strCheck = \'-1234567890.\';\n\t\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\t\tkey = String.fromCharCode(whichCode);  \n\t\t\tif (strCheck.indexOf(key) == -1) return false;  \n\t\t\treturn true ;\n\t\t}\n\t\tfunction checkForNumber(obj){\n\t\t\tif(isNaN(obj.value)){\n\t\t\t\tdocument.forms[0].cash_return.value = \'\';\n\t\t\t\talert(getMessage(\'BL8532\',\'BL\'));\n\t\t\t\tobj.select();\n\t\t\t}\n\t\t\t\n\t\t}\n\t\t\t\n\t\tfunction rectypelkup()\n\t\t{\n\t\t\tvar msg=\"\";\n\t\t\tvar target\t\t\t\t= document.forms[0].rectype;\n\t\t\tvar retVal\t\t\t\t= new String();\n\t\t\tvar dialogTop\t\t\t= \"40\";\n\t\t\tvar dialogHeight\t\t= \"40\" ;\n\t\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\tvar sql\t\t\t\t\t= \"\";\n\t\t\tvar search_desc\t\t\t= \"\";\n\t\t\tvar tit\t\t\t\t\t= \"\";\n\t\t\t\n\t\t\tvar v_ext_acc_interface_yn = \"";
    private final static byte[]  _wl_block15_1Bytes = _getBytes( _wl_block15_1 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\tvar\tv_single_serv_grp = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\tvar v_acc_episode_type = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\tvar v_acc_catg_code = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\tvar v_acc_serv_grp_used_yn = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\tvar v_serv_grp = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\tvar v_episode_type = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\tvar v_reln_code =\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\n\t\t\tvar locale = document.forms[0].locale.value;\n\n\t\t\t\t\n\t\t\tsql = \"select receipt_type_code, long_desc from bl_receipt_type_lang_vw where language_id=`\"+locale+\"` and recpt_nature_code = `BI` and status is null and (( `\"+v_ext_acc_interface_yn+\"` = `Y` and  receipt_type_code in ( select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code = `BI` and status is null and ((`\"+v_single_serv_grp+\"`=`Y` and episode_type in (`\"+v_acc_episode_type+\"`,`U`) and category in (`UNRESTRICTED`,`\"+v_acc_catg_code+\"`) and ((`\"+v_acc_serv_grp_used_yn+\"` = `Y` and blng_serv_grp = `\"+v_serv_grp+\"`) or (`\"+v_acc_serv_grp_used_yn+\"` = `N` and  blng_serv_grp is null ))) or (`\"+v_single_serv_grp+\"`=`N` and episode_type in (`U`,`\"+v_episode_type+\"`) and category IN ( `\"+v_reln_code+\"`,`UNRESTRICTED`) and blng_serv_grp is null )))) or `\"+v_ext_acc_interface_yn+\"` = `N`    )\";\t\t\n\n\t\t\tsearch_code=\"receipt_type_code\";\n\t\t\tsearch_desc=\"long_desc\";\n\t//\t\ttit=\"Receipt Types\"; \n\t\t\ttit=getLabel(\"eBL.RECEIPT_TYPE.label\",\"BL\");\t\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\t\n\t\t\tvar arr=new Array();\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\tvar retVal=unescape(retVal);\n\t\t\t\tarr=retVal.split(\"::\");\n\t\t\t\n\t\t\t\tdocument.forms[0].rectypedesc.value=arr[0];\n\t\t\t\tdocument.forms[0].rectype.value=arr[1];\n\t\t\t\t\n\t\t\t\tdocument.forms[0].acccode.value=\'\';\n\t\t\t\tdocument.forms[0].acccodedesc.value=\'\';\n\n\t\t\t\tdocument.forms[0].dept.value=\'\';\n\t\t\t\tdocument.forms[0].deptdesc.value=\'\';\n\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\n\t\t\t\n\t\t\t\tdocument.forms[0].rectypedesc.value=\'\';\n\t\t\t\tdocument.forms[0].rectype.value = \'\';\t\t\t\t\t\t\n\n\t\t\t\tdocument.forms[0].acccode.value=\'\';\n\t\t\t\tdocument.forms[0].acccodedesc.value=\'\';\n\n\t\t\t\tdocument.forms[0].dept.value=\'\';\n\t\t\t\tdocument.forms[0].deptdesc.value=\'\';\n\n\t\t\t\ttarget.focus();\n\t\t\t}\n\t\t\n\n\t\t}\n\n\t\tfunction acccodelkup()\n\t\t{\n\t\t\tvar msg=\"\";\n\t\t\tvar target\t\t\t\t= document.forms[0].acccode;\n\t\t\tvar retVal\t\t\t\t= new String();\n\t\t\tvar dialogTop\t\t\t= \"40\";\n\t\t\tvar dialogHeight\t\t= \"40\" ;\n\t\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\tvar sql\t\t\t\t\t= \"\";\n\t\t\tvar search_desc\t\t\t= \"\";\n\t\t\tvar tit\t\t\t\t\t= \"\";\n\t\t\t\n\t\t\tvar v_ext_acc_interface_yn = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\tvar v_rec_type = document.forms[0].rectype.value;\t\t\n\n\t\t\tvar locale = document.forms[0].locale.value;\n\t\t\t\n\t\t\tsql = \"\tselect distinct a.account_code, b.long_desc from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`\"+locale+\"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code  and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `\"+v_rec_type+\"` and a.status is null and ((`\"+v_single_serv_grp+\"`=`Y` and a.episode_type in (`U`, `\"+v_acc_episode_type+\"`) and a.category in (`UNRESTRICTED`,`\"+v_acc_catg_code+\"` ) and ((`\"+v_acc_serv_grp_used_yn+\"` = `Y` and a.blng_serv_grp = `\"+v_serv_grp+\"`) or (`\"+v_acc_serv_grp_used_yn+\"` = `N` and  a.blng_serv_grp is null ))) or (`\"+v_single_serv_grp+\"`=`N` and a.episode_type in (`U`, `\"+v_episode_type+\"`) and a.category IN ( `\"+v_reln_code+\"`,`UNRESTRICTED`) and a.blng_serv_grp is null ))\";\t\n\n\t\t\tsearch_code=\"a.account_code\";\n\t\t\tsearch_desc=\"b.long_desc\";\n\t//\t\ttit=\"Account Codes\"; \n\t\t\ttit=getLabel(\"eBL.ACCOUNT_CODE.label\",\"BL\");\n\t\t\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\t\n\t\t\tvar arr=new Array();\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\tvar retVal=unescape(retVal);\n\t\t\t\tarr=retVal.split(\"::\");\n\t\t\t\n\t\t\t\tdocument.forms[0].acccodedesc.value=arr[0];\n\t\t\t\tdocument.forms[0].acccode.value=arr[1];\n\t\t\t\tdocument.forms[0].acccode.focus();\t\t\t\t\n\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\n\t\t\t\n\t\t\t\tdocument.forms[0].acccodedesc.value=\'\';\n\t\t\t\tdocument.forms[0].acccode.value = \'\';\t\t\t\t\t\t\t\t\t\n\n\t\t\t\ttarget.focus();\n\t\t\t}\n\t\t\n\n\t\t}\n\n\n\t\tfunction deptlkup()\n\t\t{\n\t\t\tvar msg=\"\";\n\t\t\tvar target\t\t\t\t= document.forms[0].dept;\n\t\t\tvar retVal\t\t\t\t= new String();\n\t\t\tvar dialogTop\t\t\t= \"40\";\n\t\t\tvar dialogHeight\t\t= \"40\" ;\n\t\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\t\tvar features\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\tvar sql\t\t\t\t\t= \"\";\n\t\t\tvar search_desc\t\t\t= \"\";\n\t\t\tvar tit\t\t\t\t\t= \"\";\n\t\t\t\n\t\t\tvar v_dept_code = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\tvar v_facility_id = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26_0 ="\";\n\n\t\t\tvar locale = document.forms[0].locale.value;\n\n\t\t\t\n\t\t\tsql = \"\tselect dept_code, long_desc from am_dept_lang_vw where language_id=`\"+locale+\"` and dept_code like nvl(`\"+v_dept_code+\"`,dept_code )\";\n\n\t\t\tsearch_code=\"dept_code\";\n\t\t\tsearch_desc=\"long_desc\";\n\t//\t\ttit=\"Accounting Departments\"; \n\t\t\ttit=getLabel(\"eBL.ACCOUNTING_DEPT.label\",\"BL\");\t\t\n\t\t\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\t\n\t\t\tvar arr=new Array();\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\tvar retVal=unescape(retVal);\n\t\t\t\tarr=retVal.split(\"::\");\n\t\t\t\n\t\t\t\tdocument.forms[0].deptdesc.value=arr[0];\n\t\t\t\tdocument.forms[0].dept.value=arr[1];\n\t\t\t\tdocument.forms[0].dept.focus();\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\n\t\t\t\n\t\t\t\tdocument.forms[0].deptdesc.value=\'\';\n\t\t\t\tdocument.forms[0].dept.value = \'\';\t\t\t\t\t\t\n\t\t\t\ttarget.focus();\n\t\t\t}\n\t\t\n\n\t\t}\t\n\n\n\t\tasync function bankcardlkup(clng_evnt)\n\t\t{\n\t\t\tvar msg=\"\";\n\t\t\tvar target\t\t\t\t= document.forms[0].instremark;\n\n\t\t\tif(clng_evnt == \'B\')\n\t\t\t{\n\t\t\t\tif( target.value == \"\")\n\t\t\t\t{\n\t\t\t\t\ttarget.value = \"\";\n\t\t\t\t\tdocument.forms[0].instbranch.value=\'\';\n\t\t\t\t\tdocument.forms[0].instremarkcode.value = \'\';\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tvar retVal\t\t\t\t= new String();\n\t\t\t\n\t\t\t/* var dialogTop\t\t\t= \"90\";\n\t\t\tvar dialogHeight\t\t= \"27\" ;\n\t\t\tvar dialogWidth\t\t\t= \"40\" ; */\n\t\t\t\n\t\t\tvar dialogTop\t\t\t= \"0vh\";\n\t\t\tvar dialogHeight\t\t= \"90vh\" ;\n\t\t\tvar dialogWidth\t\t\t= \"80vw\" ;\n\t\t\tvar features= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\tvar sql\t\t\t\t\t= \"\";\t\t\n\t\t\tvar tit\t\t\t\t\t= \"\";\t\t\n\t\t\tvar v_cash_slmt_flag = document.forms[0].cashslmtflag.value; \n\t\t\tvar locale = document.forms[0].locale.value;\n\t\t\t/*ML-MMOH-0527 - Rajesh V*/\n\t\t\tvar slmttype = parent.frames[0].document.forms[0].slmttype.value;\n\t\t\tvar v_slmt_type_code=slmttype.substring(0,2);\n\t\t\tvar v_cheque_type_enabled = 0;\n\t\t\tvar chequeCategorize = document.forms[0].chequeCategorize.value;\n\t\t\tif(chequeCategorize == \'true\'){\n\t\t\t\tv_cheque_type_enabled = 1;\n\t\t\t}\n\n\t\t/*ML-MMOH-0527 - Rajesh V*/\n\t\t//added \"Y\" in where clause in\n\t\t//sql = \" select name bank_name, nvl(branch_name,\' \') branch_name, code bank_code from bl_bank_credit_company_lang_vw where language_id=\'\"+locale+\"\' and ((\'\"+v_cash_slmt_flag+\"\' = \'A\' and nvl(bank_credit_company_ind,\'~\') = \'C\') or (\'\"+v_cash_slmt_flag+\"\' in( \'B\',\'C\',\'D\',\'Y\') and    nvl(bank_credit_company_ind,\'~\') = \'B\')) and  nvl(status,\'~\') <> \'S\'\"; \t\t\n/*\t\t\n\t\tsql = \"SELECT NAME bank_name, NVL (branch_name, \' \') branch_name, code bank_code \"+\n\t\t  \"FROM bl_bank_credit_company_lang_vw \"+\n\t\t  \"WHERE language_id = \'\"+locale+\"\' \"+\n\t\t    \"AND (   (    \'\"+v_cash_slmt_flag+\"\' = \'A\' \"+\n\t\t             \"AND NVL (bank_credit_company_ind, \'~\') = \'C\' \"+\n\t\t            \") \"+\n\t\t         \"OR (    \'\"+v_cash_slmt_flag+\"\' IN (\'B\') \"+\n\t\t             \"AND NVL (bank_credit_company_ind, \'~\') IN (\'B\') \"+\n\t\t             \"AND (   (    EXISTS ( \"+\n\t\t                             \"SELECT b.bank_code \"+\n\t\t                               \"FROM bl_slmt_type a, bl_bank_name b \"+\n\t\t                              \"WHERE a.cheque_type = b.cheque_type \"+\n\t\t                                \"AND slmt_type_code = \'\"+v_slmt_type_code+\"\' \"+\n\t\t                                \"AND b.bank_code = code) \"+\n\t\t                      \"AND \'\"+v_cheque_type_enabled+\"\' > 0 \"+\n\t\t                     \") \"+\n\t\t                  \"OR \'\"+v_cheque_type_enabled+\"\' = 0 \"+\n\t\t                 \") \"+\n\t\t            \") \"+\n\t\t         \"OR (    \'\"+v_cash_slmt_flag+\"\' IN (\'B\') \"+\n\t\t             \"AND NVL (bank_credit_company_ind, \'~\') IN (\'B\') \"+\n\t\t             \"AND (   (    EXISTS ( \"+\n\t\t                             \"SELECT b.bank_code \"+\n\t\t                               \"FROM bl_slmt_type a, bl_bank_name b \"+\n\t\t                              \"WHERE a.cheque_type = b.cheque_type \"+\n\t\t\t\t\t      //\"WHERE a.cheque_type = b.cheque_type(plus) \"+//Commented against V210624\n\t\t                                \"AND a.slmt_type_code = \'\"+v_slmt_type_code+\"\' \"+\n\t\t                                \"AND a.cheque_type IS NULL \"+\n\t\t                                \"AND b.bank_code = code) \"+\n\t\t\t\t\t      //\"AND b.bank_code(plus) = code) \"+//Commented against V210624\n\t\t                      \"AND \'\"+v_cheque_type_enabled+\"\' > 0 \"+\n\t\t                     \") \"+\n\t\t                  \"OR \'\"+v_cheque_type_enabled+\"\' = 0 \"+\n\t\t                 \") \"+\n\t\t            \") \"+\n\t\t         \"OR (    \'\"+v_cash_slmt_flag+\"\' IN (\'C\', \'D\', \'Y\') \"+\n\t\t             \"AND NVL (bank_credit_company_ind, \'~\') = \'B\' \"+\n\t\t            \") \"+\n\t\t        \") \"+\n\t\t    \"AND NVL (status, \'~\') <> \'S\' \";\n\t\t\t\n\t\tsql = escape(sql);\t\t\t\t\t\n*/ //Commented against V211014 \n\n\t\t\tvar column_sizes = escape(\"30%,60%,10%\");               \n\n\t\t\tif ( v_cash_slmt_flag == \'A\' )\n\t\t\t{\n\t//\t\t\ttit = \"Credit Card Company Names\";\t\t    \n\t\t\t\t//tit=getLabel(\"eBL.CREDIT_CARD_COMP_NAMES.label\",\"BL\");\n\t\t\t\t//var creditcardconame=getLabel(\"eBL.CREDIT_CARD_CO.label\",\"BL\");\n\t\t\t\t//var branchname=getLabel(\"eBL.BRANCH_NAME.label\",\"BL\");\n\t\t\t\t//var code=getLabel(\"Common.code.label\",\"common\");\n\t\t\t\ttit=encodeURIComponent(getLabel(\"eBL.CREDIT_CARD_COMP_NAMES.label\",\"BL\"));\n\t\t\t\tvar creditcardconame=encodeURIComponent(getLabel(\"eBL.CREDIT_CARD_CO.label\",\"BL\"));\n\t\t\t\tvar branchname=encodeURIComponent(getLabel(\"eBL.BRANCH_NAME.label\",\"BL\"));\n\t\t\t\tvar code=encodeURIComponent(getLabel(\"Common.code.label\",\"common\"));\n\n\t//\t\t\tvar column_descriptions = escape(\"Credit Card Co. Name,Branch Name,Code\"); \n\t\t\t\tvar column_descriptions =creditcardconame+\",\"+branchname+\",\"+code;\n\t\t\t}\n\t\t\telse\t\t\t\n\t\t\t{\n\t\t\t\n\t//\t\t\ttit=\"Bank Names\"; \n\t\t\t\t//tit=getLabel(\"eBL.BANK_NAME.label\",\"BL\");\n\t\t\t//\tvar bankname=getLabel(\"eBL.BANK_NAME.label\",\"BL\");\n\t\t\t//\tvar branchname=getLabel(\"eBL.BRANCH_NAME.label\",\"BL\");\n\t\t\t//\tvar code=getLabel(\"Common.code.label\",\"common\");\n\t\t\t\t\n\t\t\t\ttit=encodeURIComponent(getLabel(\"eBL.BANK_NAME.label\",\"BL\"));\n\t\t\t\tvar bankname=encodeURIComponent(getLabel(\"eBL.BANK_NAME.label\",\"BL\"));\n\t\t\t\tvar branchname=encodeURIComponent(getLabel(\"eBL.BRANCH_NAME.label\",\"BL\"));\n\t\t\t\tvar code=encodeURIComponent(getLabel(\"Common.code.label\",\"common\"));\n\t//\t\t\tvar column_descriptions = escape(\"Bank Name,Branch Name,Code\"); \n\t\t\t\tvar column_descriptions =bankname+\",\"+branchname+\",\"+code;\n\t\t\t}\n\t\t\n\n\t\tvar message = \'\';\n\t\t\n\t//sql=\"BLINTERNALREP_10::blsql::\"+locale+\"::\"+v_cash_slmt_flag+\"::\"+v_cash_slmt_flag+\"::\"+v_slmt_type_code+\"::\"+v_cheque_type_enabled+\"::\"+v_cheque_type_enabled+\"::\"+v_cash_slmt_flag+\"::\"+v_slmt_type_code+\"::\"+v_cheque_type_enabled+\"::\"+v_cheque_type_enabled+\"::\"+v_cash_slmt_flag+\"::\";\n\tsql=\"BLINTERNALREP_10::blsql::\"+locale+\"::\"+v_cash_slmt_flag+\"::\"+v_slmt_type_code+\"::\"+v_cheque_type_enabled+\"::\"; //V230824\n\t\n\t\n\t//V230418\n\t\t//ML-MMOH-CRF-0527 Added Called For\n\t\tvar param = \"title=\"+tit+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"locale=\"+locale+\"&\"+\"v_cash_slmt_flag=\"+v_cash_slmt_flag+\"&\"+\"v_slmt_type_code=\"+v_slmt_type_code+\"&\"+\"v_cheque_type_enabled=\"+v_cheque_type_enabled+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYY&called_for=BankAndBranch&sqlData=\"+sql;//Added against V211014 //added sqldata V230418\n\t//\tvar param = \"title=\"+tit+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYY&called_for=BankAndBranch\"; //Commented against V211014\n\t\n\t\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\t\tvar arr=new Array();\n\t\tif(retVal == null) retVal=\'\';\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\t\n\t\t\tvar retVal=unescape(retVal);\n\t\t\t//arr=retVal.split(\"::\");\n\t\t\tarr=retVal.split(\"^~^\");\n\t\t    \t\n\t\t\tdocument.forms[0].instremark.value=arr[0];\n\t\t\tdocument.forms[0].instbranch.value=arr[1];\n\t\t    document.forms[0].instremarkcode.value=arr[2];\t\t\n\t\t\t\n\t\n\t\t\tif (document.forms[0].instremark.value == \'undefined\')\n\t\t\t\tdocument.forms[0].instremark.value = \'\';\n\n\t\t\t\tif (document.forms[0].instbranch.value == \'undefined\')\n\t\t\t\t\tdocument.forms[0].instbranch.value = \'\';\n\n\t\t\t\tif (document.forms[0].instremarkcode.value == \'undefined\')\n\t\t\t\t\tdocument.forms[0].instremarkcode.value = \'\';\n\t//\t\t\t\tdocument.forms[0].instremark.focus();\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\n\t\t\t\tdocument.forms[0].instremark.value=\'\';\n\t\t\t\tdocument.forms[0].instbranch.value=\'\';\n\t\t\t\tdocument.forms[0].instremarkcode.value = \'\';\t\t\t\t\t\t\n\t//\t\t\ttarget.focus();\n\t\t\t}\t\n\t\t}\t\n\t\t\n\t\t\n\t\tfunction fn_cash_check(){\n\t\t\t\n\t\t\tvar setld_amt=parent.frames[0].document.forms[0].billslmtamt.value;\n\t\t\t//alert(\"setld_amt 807 ==> \"+setld_amt);//muthu\n\t\t\t\n\t\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\t\tif(document.forms[0].cash_given.value==\"\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].cash_return.value=\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar c_given=document.forms[0].cash_given.value;\t\t\t  \n\t\t\t\tvar c_return=\"\";\n\t\t\t\tif(setld_amt<0)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t//c_return=parseFloat(c_given)-(parseFloat(setld_amt));\t\t\t\t  \n\t\t\t\t\tc_return=parseFloat(setld_amt)-parseFloat(c_given);\n\t\t\t\t\tc_return=c_return.toFixed(decimal);\n\t\t\t\t\tdocument.forms[0].cash_return.value=c_return;\t\t\t\t  \n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\t\n\t\t\t\t\tc_return=parseFloat(c_given)-parseFloat(setld_amt);\n\t\t\t\t\tc_return=c_return.toFixed(decimal);\n\t\t\t\t\tif(c_return<0)\n\t\t\t\t\t{\t\t\t\n\t\t\t\t\t\tdocument.forms[0].cash_given.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].cash_return.value=\"\";\t\t\t\t  \n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].cash_return.value=c_return;\n\t\t\t\t\t}\t\n\t\t\t\t}\n\t\t\t\tvar temp_cash_given=eval(\"document.forms[0].cash_given\");\n\t\t\t\tvar temp_cash_return=eval(\"document.forms[0].cash_return\");\n\t\t\t\tputdeci(temp_cash_given);\n\t\t\t\tputdeci(temp_cash_return);\n\t\t\t}\n\n\t\t\t\n\t\t}\n\t\t\n\t\tfunction fun_cash_check()\n\t\t{\n\t\t\tvar setld_amt=parent.frames[0].document.forms[0].billslmtamt.value;\n\t\t\t//alert(\"setld_amt 807 ==> \"+setld_amt);//muthu\n\t\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\t\tif(document.forms[0].cash_given.value==\"\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].cash_return.value=\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar c_given=document.forms[0].cash_given.value;\t\t\t  \n\t\t\t\tvar c_return=\"\";\n\t\t\t\tif(setld_amt<0)\n\t\t\t\t{\n\t\t\t\t\tc_return=parseFloat(c_given)+(-parseFloat(setld_amt));\t\t\t\t  \n\t\t\t\t\tc_return=c_return.toFixed(decimal);\n\t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].cash_return.value=-c_return;\t\t\t\t  \n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\t\n\t\t\t\t\tc_return=parseFloat(c_given)-parseFloat(setld_amt);\n\t\t\t\t\tc_return=c_return.toFixed(decimal);\n\t\t\t\t\tif(c_return<0)\n\t\t\t\t\t{\t\t\t\n\t\t\t\t\t\tdocument.forms[0].cash_given.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].cash_return.value=\"\";\t\t\t\t  \n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].cash_return.value=c_return;\n\t\t\t\t\t}\t\n\t\t\t\t}\n\t\t\t\tvar temp_cash_given=eval(\"do";
    private final static byte[]  _wl_block26_0Bytes = _getBytes( _wl_block26_0 );

    private final static java.lang.String  _wl_block26_1 ="cument.forms[0].cash_given\");\n\t\t\t\tvar temp_cash_return=eval(\"document.forms[0].cash_return\");\n\t\t\t\tputdeci(temp_cash_given);\n\t\t\t\tputdeci(temp_cash_return);\n\t\t\t}\n\t\t}\n\t\tfunction putdeci(object)\n\t\t{\t\n\t\t\tif(object.value!=\'\')\n\t\t\t{\n\t\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\t\tputDecimal(object,17,decimal);\n\t\t\t}\n\t\t}\n\t\t\t\n\t\t\t\t\n\t\tfunction disableAllElements_billslmt_remove()\n\t\t{\n\t\t\t//var len = document.forms[0].elements.length;\n\t\t\tfor(var i=0;i<10;i++)\n\t\t\t{\n\t\t\t\tdocument.forms[0].elements(i).disabled=true;\n\t\t\t}\n\t\t//document.forms[0].remove_button.disabled=false;\n\t\t//document.forms[0].cancel_button.disabled=false;\n\t\t}\n\t\tfunction fnCashcheck()\n\t\t{\n\t\t\t\n\t\t\t\n\t\t\tvar amt_sett=parent.frames[0].document.forms[0].billslmtamt.value;\n\t\t\t//alert(\"amt_sett 866 ==> \"+amt_sett);//muthu\n\t\t\tvar cash_giv=document.forms[0].cash_given.value;\n\t\t\tif(cash_giv!=\'\')\n\t\t\t\t{\n\t\t\t\n\t\t\tif(parseFloat(Math.abs(cash_giv))<parseFloat(Math.abs(amt_sett)))\n\t\t\t{\n\t\t\t\t//alert(\"Cash given is less than the Amount Settled\");\n\t\t\t\talert(getMessage(\"BL9618\",\"BL\"));\n\t\t\t\tdocument.forms[0].cash_given.select();\t\t\t\n\t\t\t\tdocument.forms[0].cash_given.value=\'\';\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\t\t\tif(cash_giv>0)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9863\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].cash_given.value=\'\';\n\t\t\t\t\tdocument.forms[0].cash_given.select();\t\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t/*  if(cash_giv==\"\")\n\t\t\t{\n\t\t\t\t//alert(\"cash given should not be blank\");\n\t\t\t\t alert(getMessage(\"BL9638\",\"BL\"));\n\t\t\t\t//document.forms[0].cash_given.focus();\n\t\t\t\t//return false;\n\t\t\t}*/\n\t\t\t\n\t\t\t fn_cash_check()\n\t\t}\n\t\t\n\t\t}\n\t\tfunction funCashcheck()\n\t\t{\n\t\t\tvar amt_sett=parent.frames[0].document.forms[0].billslmtamt.value;\n\t\t\t//alert(\"amt_sett 866 ==> \"+amt_sett);//muthu\n\t\t\tvar cash_giv=document.forms[0].cash_given.value;\n\t\t\tif(amt_sett<0){\n\t\t\t\tif((parseFloat(cash_giv)>parseFloat(amt_sett))&&(parseFloat(cash_giv)<0))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9618\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].cash_given.value = \"\";\n\t\t\t\t\tdocument.forms[0].cash_given.select();\t\t\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tif(amt_sett<0 && parseFloat(cash_giv)>0 )\n\t\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL0623\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].cash_given.value = \"\";\n\t\t\t\t\tdocument.forms[0].cash_given.focus();\t\t\t\n\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t}\n\t\t\telse{\n\t\t\tif(parseFloat(cash_giv)<parseFloat(amt_sett))\n\t\t\t{\n\t\t\t\t//alert(\"Cash given is less than the Amount Settled\");\n\t\t\t\talert(getMessage(\"BL9618\",\"BL\"));\n\t\t\t\tdocument.forms[0].cash_given.value = \"\";\n\t\t\t\tdocument.forms[0].cash_given.select();\t\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t}\n\t\t/*  if(cash_giv==\"\")\n\t\t\t{\n\t\t\t\t//alert(\"cash given should not be blank\");\n\t\t\t\t alert(getMessage(\"BL9638\",\"BL\"));\n\t\t\t\t//document.forms[0].cash_given.focus();\n\t\t\t\t//return false;\n\t\t\t}*/\n\t\t\t\n\t\t\t fun_cash_check()\n\t\t\t}\n\n\t\tfunction disable_elements()\n\t\t{\n\t\t\t//Added V060618-Subha/IN67859/Starts\n\t\t\tif(eval(\"parent.frames[0]\").value != \"undefined\" && eval(\"parent.frames[0]\").value != undefined) {\n\t\t\t\tvar slmttype = parent.frames[0].document.forms[0].slmttype.value;\n\t\t\t\tif(slmttype != \"null\" && slmttype != null) {\n\t\t\t\t\tvar slmttypeflag = slmttype.charAt(2); \n\t\t\t\t\t//Added V060618-Subha/IN67859/Ends\n\t\t\t\t\tif(slmttypeflag==\"B\" )\n\t\t\t\t\t{\n\t//\t\t\t\t\tdocument.forms[0].instbranch.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].batchno.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].apprrefno.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].saledraftno.value=\"\";\n\t\t\t\t\t}\n\t\t\t\t\tif(slmttypeflag==\"D\")\n\t\t\t\t\t{\n\t//\t\t\t\t\tdocument.forms[0].instremark.value=\"\";\n\t//\t\t\t\t\tdocument.forms[0].instbranch.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].batchno.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].apprrefno.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].saledraftno.value=\"\";\n\t\t\t\t\t}\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tfunction callCardNoValidation(obj)\n\t\t{\n\t\t\tvar credit_card_num = obj.value;\n\t\t\tvar slmttype = parent.frames[0].document.forms[0].slmttype.value;\n\t\t\t//alert(\"slmttype \"+slmttype);\n\t\t\tvar slmt_type_code=slmttype.substring(0,2);\t\n\t\t\t//alert(\"slmt_type_code \"+slmt_type_code); \n\t\t\tvar slmt_flag=slmttype.charAt(2);\t\n\t\t\tvar caldFormanualcc=\"MANUALCC\";\t\t\t\t\t\t\t\n\t\t\t parent.frames[4].location.href=\"../../eBL/jsp/BLCreditCardInterfaceValidate.jsp?caldFormanualcc=\"+caldFormanualcc+\"&slmt_type_code=\"+slmt_type_code+\"&credit_card_num=\"+credit_card_num;\n\t\t}\n\t\tfunction setFocus(){\t\t\t\n\t\t\tvar cashGiv=document.forms[0].cash_given;\t\t\n\t\t\t\tif(cashGiv != null && cashGiv !=\"\"){\t\t\t\n\t\t\t\t\tcashGiv.focus();\n\t\t\t\t}\n\t\t}\n\n\t\tfunction ValidateDateTimesp(obj)\n\t\t{\n\t\t\tif(!(obj.value==\"\"))\n\t\t\t{\n\t\t\t\tif(!doDateTimeChk(obj)){\n\t\t\t\t\tvar datemessage=getMessage(\'INVALID_VALUE\',\'Common\').replace(\'#\',\'date time format\')\t\t\n\t\t\t\t\talert(datemessage);\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tCheckcurrdate(obj);\n\t\t\t\t}\n\t\t\t }\n\t\t}\n\n\t\tfunction Checkcurrdate(from) {\n\t\t\tvar fromarray; var toarray;\n\t\t\tvar fromdate = from.value ;\n\t\t\tvar d =  new Date(); \n\t\t\tif(fromdate.length > 0 ) {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\t\t\tvar year =  fromarray[2].split(\" \");\n\t\t\t\t\tvar hourmins=year[1].split(\":\");\n\n\t\t\t\t\tvar fromdt = new Date(year[0],fromarray[1],fromarray[0],hourmins[0],hourmins[1]);\t\t\t\n\t\t\t\t\n\t\t\t\t\tvar todt = new Date(d.getYear(),d.getMonth() + 1,d.getDate(),d.getHours(),d.getMinutes());\t\n\t\t\t\t\tif(Date.parse(todt) > Date.parse(fromdt)) {\n\n\t\t\t\t\talert(getMessage(\'XH0073\',\'XH\'));\n\t\t\t\t\t\tfrom.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\telse if(Date.parse(todt) <= Date.parse(fromdt)) return true;\n\t\t\t}\t\n\t\t\treturn true;\n\t\t}\n\t\tfunction doDateTimeChk(obj)  \n\t\t{\n\t\t\tif(obj.value.indexOf(\'.\') !=-1)\n\t\t\t{\n\t\t\t\tretval= false\n\t\t\t\tobj.focus()\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar comp=obj\n\t\t\t\tobj=obj.value\n\t\t\t\tvar dttime = obj.split(\" \");\n\t\t\t\tvar dt\n\t\t\t\tvar time\n\t\t\t\tvar retval=true\n\t\t\t\tif(dttime.length>1)\n\t\t\t\t{\n\t\t\t\t\tdt=dttime[0]\n\t\t\t\t\ttime=dttime[1]\n\n\t\t\t\t\tif(!checkDt(dt) )\n\t\t\t\t\t{\n\t\t\t\t\t\tretval= false\n\t\t\t\t\t\tcomp.focus()\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif(time==null || time==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tretval= false;\n\t\t\t\t\t\t\tcomp.focus()\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\tif(!chkTime(time))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tretval= false\n\t\t\t\t\t\t\t\tcomp.focus()\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tretval= false\n\t\t\t\t\tcomp.focus()\n\t\t\t\t}\n\n\t\t\t\tif(retval)\n\t\t\t\t{\n\t\t\t\t\t//callDateFunction(comp)\n\t\t\t\t}\n\t\t\t}\n\t\t\treturn retval\n\t\t}\n\t\t//V210113 start\n\t\tfunction couponcodelkup() {\t\t\n\t\t\tvar patientID = document.forms[0].patientid.value;\n\t\t\tvar setld_amt=parent.frames[0].document.forms[0].billslmtamt.value;\n\t\t\tvar remainingAmt = parent.frames[0].document.forms[0].billpayableamt.value; //V210224\n\t\t\tvar cash_given=document.forms[0].cash_given.value;\t\t\n\t\t\tvar decimal=document.forms[0].noofdecimal.value; //V210224\n\t\t\tvar action_ind = document.forms[0].action_ind.value; //V210224\n\t\t\tvar coupon=\'\';\n\t\t\tvar transactionid=\'\';\t\t\n\t\t\tvar LoggedUser = document.forms[0].LoggedUser.value;\t\t\n\t\t\tvar clientIpAddress = document.forms[0].clientIpAddress.value;\t\t\n\t\t\tvar NuhdeekResponse = NuhdeekTransactions(\'COUPON\',patientID,coupon,transactionid, LoggedUser, clientIpAddress);\n\t\t\tvar NuhdeekResponseArr = NuhdeekResponse.split(\"$!^\");\n\t\t\tif (NuhdeekResponseArr[0] == \'S\') {\t\t\n\t\t\t\tvar couponStr =\tNuhdeekResponseArr[2].replace(/#/g,\"|\");\n\t\t\t\tvar center=\'1\';\n\t\t\t\tvar dialogTop = \"200\";\n\t\t\t\tvar dialogHeight = \"25\" ; //V210224\n\t\t\t\tvar dialogWidth = \"55\" ; //V210319\n\t\t\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\n\t\t\t\tvar title=encodeURIComponent(getLabel(\"eBL.CouponCodes.Label\",\"BL\"));\t\n\t\t\t\tvar arguments = \"\" ;\n\t\t\t\tvar column_sizes = escape(\"\");               \n\t\t\t\tvar column_descriptions =\"\";\t\t\n\t\t\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&coupons=\"+couponStr+\"&patientID=\"+patientID+\"&LoggedUser=\"+LoggedUser+\"&clientIpAddress=\"+clientIpAddress+\"&setld_amt=\"+setld_amt+\"&remainingAmt=\"+remainingAmt; //V210224\n\t\t\t\tvar retVal=window.showModalDialog(\"../../eBL/jsp/BLSelectNuhdeekCoupon.jsp?\"+param,arguments,features);\n\t\t\t\tif (retVal==\'undefined\' || retVal ==\t undefined || retVal==\"\") {\n\t\t\t\t//V210224start\n\t\t\t\t\tif(action_ind != \'modify\') {  \n\t\t\t\t\t\tif(document.getElementById(\'couponcodeTA\').value == \'undefined\' || document.getElementById(\'couponcodeTA\').value ==\t undefined || document.getElementById(\'couponcodeTA\').value ==\"\" ) { //V210224\n\t\t\t\t\t\t\tdocument.getElementById(\"couponcode\").value = \"\";\n\t\t\t\t\t\t\tdocument.getElementById(\'couponcodeTA\').value = \"\";\n\t\t\t\t\t\t\t//document.getElementById(\'cash_given\').value = \"\";\n\t\t\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.value=\"\";\n\t\t\t\t\t\t\tdocument.getElementById(\'couponAndAmt\').value = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t} ////V210224 end\t\t\t\t\n\t\t\t\t} else {\n\t\t\t\t\tvar returnvalue = retVal.split(\"::\");\n\t\t\t\t\t//V210224 start\n\t\t\t\t\tvar couponcodeTA = document.getElementById(\'couponcodeTA\').value;\n\t\t\t\t\tvar couponCode = document.getElementById(\"couponcode\").value;\n\t\t\t\t\tvar cash_setl =parent.frames[0].document.forms[0].billslmtamt.value;\n\t\t\t\t\t//var cashgiven = document.getElementById(\'cash_given\').value;\n\t\t\t\t\tvar couponAndAmt = document.getElementById(\'couponAndAmt\').value;\t\t\t\t\n\t\t\t\t\tif(couponcodeTA==\'undefined\' || couponcodeTA ==\t undefined || couponcodeTA==\"\") {\n\t\t\t\t\t\t couponCode = \"\";\n\t\t\t\t\t\t couponcodeTA=\"\";\n\t\t\t\t\t\t //cashgiven = \"\";\n\t\t\t\t\t\t cash_setl=\"\";\n\t\t\t\t\t\t couponAndAmt =\"\";\n\t\t\t\t\t}\t\t\t\t\n\t\t\t\t\tif(couponcodeTA!=\"\"){\n\t\t\t\t\t\tdocument.getElementById(\'couponcodeTA\').value = couponcodeTA+\", \"+returnvalue[2];\n\t\t\t\t\t\tdocument.getElementById(\'couponAndAmt\').value = couponAndAmt+\", \"+returnvalue[2];\n\t\t\t\t\t\tdocument.getElementById(\"couponcode\").value = couponCode+\",\"+returnvalue[0];\n\t\t\t\t\t\t//cashgiven = parseFloat(cashgiven)+parseFloat(returnvalue[1]);\t\t\t\t\t\n\t\t\t\t\t\tcash_setl = parseFloat(cash_setl)+parseFloat(returnvalue[1]);\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tdocument.getElementById(\"couponcode\").value = returnvalue[0];\n\t\t\t\t\t\tdocument.getElementById(\'couponcodeTA\').value = returnvalue[2];\n\t\t\t\t\t\tdocument.getElementById(\'couponAndAmt\').value =returnvalue[2];\n\t\t\t\t\t\t//cashgiven = parseInt(returnvalue[1]);\n\t\t\t\t\t\tcash_setl = parseFloat(returnvalue[1]);\n\t\t\t\t\t}\t\t\t\t\n\t\t\t\t\tcash_setl=cash_setl.toFixed(decimal);\t\t\t\t\n\t\t\t\t\tif(parseFloat(cash_setl) > parseFloat(remainingAmt)) {\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.value=remainingAmt;\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.value=cash_setl;\n\t\t\t\t\t}\n\t\t\t\t\t//V210224  end\n\t\t\t\t\t//cashgiven=cashgiven.toFixed(decimal);\n\t\t\t\t\t//document.getElementById(\'cash_given\').value=cashgiven;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t} else if (NuhdeekResponseArr[0]==\'E\') {\n\t\t\t\t\talert(NuhdeekResponseArr[4]);\n\t\t\t\t\treturn false;\n\t\t\t}\t\t\n\t\t}\n\t\t//V210113 end\n\t\t\n\t\t//Added by Sethu for MOHE-CRF-0076 on 01/08/2021\n\t\tfunction validate_ps_tranx(trans)\n\t\t{\n\t\t\tvar returnData = \"\";\n\t\t\tvar patientID = \"\";\n\t\t\tvar payAmount = \"\";\n\t\t\tvar merchantOrderID = \"\";\n\t\t\t\n\t\t\tvar payskyReturnStr = \"\";\n\t\t\tvar paySkyData = \"\";\n\n\t\t\tvar errMessage = \"\";\n\n\t\t\tvar payTransStatus = \"PaySky\";\n\t\t\tvar loggedUser = \"\"";
    private final static byte[]  _wl_block26_1Bytes = _getBytes( _wl_block26_1 );

    private final static java.lang.String  _wl_block26_2 =";\n\t\t\tvar facilityid = \"\";\n\t\t\tvar insuranceID = \"\";\n\t\t\t\n\t\t\tvar segmentId = \"\", waittime = \"\";\n\n\t\t\tvar documentModeStr = document.documentMode;\n\n\t\t\tvar errMess = \"<H5 style=\'color:blue\'>Processing PaySky Transaction... Kindly wait...</H5><br>\" ;\n\n\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\n\t\t\tif(parent.frames[0].document.forms[0].billpayableamt.value != \"\")\n\t\t\t{\n\t\t\t\tpatientID = document.forms[0].patientid.value;\t\t\t\n\t\t\t\tpayAmount = parent.frames[0].document.forms[0].billpayableamt.value;\n\t\t\t\tmerchantOrderID = document.forms[0].saledraftno.value;\n\n\t\t\t\tloggedUser = document.forms[0].LoggedUser.value;\n\t\t\t\tfacilityid = document.forms[0].facilityid.value;\t\n\t\t\t\tclientIpAddress = document.forms[0].clientIpAddress.value;\n\t\t\t\t\n\t\t\t\tsegmentId = document.forms[0].segment_id.value;\n\n\t\t\t\t//alert(\" Patient ID... \"+patientID+ \" Pay Amount... \"+payAmount+ \" Merchant Order ID... \"+merchantOrderID+ \" Logged User... \"+loggedUser+ \" Facility Id... \"+facilityid+ \" Client IP Address... \"+clientIpAddress);\n\t\t\t\t\n\t\t\t\tvar paySkyParam=\"\";\n\n\t\t\t\tvar formName= parent.frames[0].document.forms[0];\n\t\t\t\tvar dataElements=\"\";\n\t\t\t\tdataElements+=\"P_patient_id=\"+formName.patientid.value;\n\t\t\t\tdataElements+=\"&P_settlement_type=\"+(formName.slmttype.value).substring(0,2);\n\t\t\t\tdataElements+=\"&P_trn_type=\"+formName.trn_type.value;\n\t\t\t\tdataElements+=\"&p_doc_date=\"+formName.p_doc_date.value;\n\t\t\t\tdataElements+=\"&P_Bill_Doc_Type=\"+formName.billdoctypecode.value;\n\t\t\t\tdataElements+=\"&P_Bill_Doc_Num=\"+formName.billdocnum.value;\n\t\t\t\tdataElements+=\"&P_Total_Bill_Amount=\"+formName.billslmtamt.value; \n\t\t\t\tdataElements+=\"&P_doc_amt=\"+formName.total_amt_payable.value;\n\t\t\t\tdataElements+=\"&P_USER_ID=\"+formName.loggeduser.value;;\n\t\t\t\tdataElements+=\"&P_RESP_ID=\"+formName.responsibility_id.value;\n\t\t\t\tdataElements+=\"&P_FACILITY_ID=\"+formName.facilityid.value;\n\t\t\t\tdataElements+=\"&P_MODULE_ID=\"+formName.moduleid.value;\n\t\t\t\tdataElements+=\"&P_FUNCTION_ID=\"+formName.function_id.value;\n\t\t\t\tdataElements+=\"&P_LANGUAGE_ID=\"+formName.locale.value;\n\t\t\t\tdataElements+=\"&P_WS_NO=\"+formName.strclientip.value;\n\t\t\t\tdataElements+=\"&P_Trx_No=\"+formName.trn_number.value;\n\t\t\t\tdataElements+=\"&P_Ext_Input_Key=\"+formName.ext_input_key.value;\n\t\t\t\tdataElements+=\"&P_Ext_Application_ID=PAYSKY\"; \n\t\t\t\tdataElements+=\"&P_Ext_Function=\"+formName.ext_function.value;\n\t\t\t\tdataElements+=\"&P_Reciept_number=\"+formName.receipt_number.value;// changed\n\t\t\t\tdataElements+=\"&intExtAppID=PAYSKY\";\n\t\t\t\t\n\t\t\t\t//alert(\" Date Elements... \"+dataElements);\n\t\t\t\t\n\t\t\t\tif (trans == \"PAY\") {\n\n\t\t\t\t\tinsuranceID = GetInsuranceId(patientID);\n\t\t\t\t\t\n\t\t\t\t\tif (!(insuranceID.length>0)){\n\t\t\t\t\t\terrMess = \"<H5 style=\'color:red\'>Unable to proceed with PaySky Transaction - Health ID information not available for this patient</H5>\" +\"<br>\" ;\n\t\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\t\treturn false; \n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tmerchantOrderID = GetTransactionId(dataElements);\n\t\t\t\t\t\n\t\t\t\t\twaitime = getWaitTime(segmentId);\n\t\t\t\t\t//Added by Sethu for MOHE-SCF-0179 on 21/04/2022\n\t\t\t\t\tvar paymentData = \"\";\n\n\t\t\t\t\t//alert(\"Total Amount Payable : \"+formName.total_amt_payable.value+\" Bill Settlement Amount : \"+formName.billslmtamt.value+\" Pay Amount : \"+payAmount);\n\t\t\t\t\t\n\t\t\t\t\tif (formName.billslmtamt.value>0)\n\t\t\t\t\t{\n\t\t\t\t\t\tpaymentData = \"{\\\"PatientId\\\":\"+insuranceID+\", \\\"TransactionId\\\":\"+merchantOrderID+\", \\\"Amount\\\":\"+formName.billslmtamt.value+\"}\";\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\terrMess = \"<H5 style=\'color:red\'>Unable to proceed with PaySky Transaction - Settlement Amount should be entered</H5>\" +\"<br>\" ;\n\t\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\t\treturn false; \n\t\t\t\t\t}\t\t\t\t\t\t\t\t\t \n\t\t\n\t\t\t\t\tdataElements+=\"&REQUEST_TEXT=\"+paymentData;\n\n\t\t\t\t\tdocument.forms[0].saledraftno.value = merchantOrderID;\n\n\t\t\t\t\tdataElements+=\"&P_Saledraftno=\"+merchantOrderID;\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tpaySkyParam+=\"saledraftno=\"+merchantOrderID;\n\t\t\t\t\tpaySkyParam+=\"&patientid=\"+insuranceID;\n\t\t\t\t\t\n\t\t\t\t\tif (formName.billslmtamt.value>0)\n\t\t\t\t\t{\n\t\t\t\t\t\tpaySkyParam+=\"&amount=\"+formName.billslmtamt.value;\n\t\t\t\t\t}\n\t\t\t\t\t//Added by Sethu for MOHE-SCF-0179 on 21/04/2022\n\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tpaySkyParam+=\"&requesttype=RequestPayment\";\n\t\t\t\t\tpaySkyParam+=\"&waitime=\"+waitime;\n\t\t\t\t\t\n\t\t\t\t\tpayskyReturnStr = \"\";\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tpayskyReturnStr = PaySkyTransaction(paySkyParam);\t\n\t\t\t\t\t/*\n\t\t\t\t\tif (document.forms[0].saledraftno.value != \"\"){\n\t\t\t\t\t\tpayskyReturnStr = PaySkyTransaction(paySkyParam);\t\t\t\t\t\t\n\t\t\t\t\t}\t\n\t\t\t\t\t*/\n\t\t\t\t\tdataElements+=\"&RESPONSE_TEXT=\"+payskyReturnStr;\n\t\t\t\t\t\n\t\t\t\t\tvar auditStatus = PaySkyAuditInfo(dataElements);\n\t\t\t\t}\n\n\t\t\t\tif (payskyReturnStr.length > 0){\n\n\t\t\t\t\tpaySkyData = payskyReturnStr.split(\"$!^\");\n\n\t\t\t\t\tvar errMess = \"\" ;\n\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\n\t\t\t\t\tif (paySkyData.length > 0)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].saledraftno.disabled = false;\n\t\t\t\t\t\tdocument.forms[0].apprrefno.disabled = false;\n\t\t\t\t\t\tdocument.forms[0].instdate.disabled = false;\n\n\t\t\t\t\t\t//alert(paySkyData[0] + \" ::: \" + paySkyData[3] + \" ::: \" + paySkyData[4] + \" ::: \" + paySkyData[5]);\n\n\t\t\t\t\t\tif (paySkyData[0] == \"SUCCESS\"){\n\t\t\t\t\t\t\tdocument.forms[0].saledraftno.disabled = true;\n\t\t\t\t\t\t\tdocument.forms[0].apprrefno.disabled = true;\n\t\t\t\t\t\t\tdocument.forms[0].instdate.disabled = true;\n\n\t\t\t\t\t\t\tdocument.forms[0].validate_paysky_pay.disabled = true;\t\t\t\t\t\t\n\n\t\t\t\t\t\t\tdocument.forms[0].saledraftno.value = paySkyData[4];\n\t\t\t\t\t\t\tdocument.forms[0].apprrefno.value = paySkyData[3];\n\t\t\t\t\t\t\tdocument.forms[0].instdate.value = paySkyData[5];\n\n\t\t\t\t\t\t\terrMess = \"<H5 style=\'color:green\'>\"+payTransStatus+\" Transaction - Successful</H5>\" +\"<br>\" ;\n\t\t\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\t\t\treturn false; \n\t\t\t\t\t\t}\n\t\t\t\t\t\telse \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].saledraftno.value = paySkyData[4];\t\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.forms[0].apprrefno.value = \"\";\n\t\t\t\t\t\t\tdocument.forms[0].instdate.value = \"\";\n\t\t\t\t\t\t\terrMessage = paySkyData[1] + \" - \" + paySkyData[2];\n\t\t\t\t\t\t\terrMess = \"<H5 style=\'color:red\'>Transaction declined - \"+errMessage+\"</H5>\" +\"<br>\" ;\n\t\t\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\t\t\treturn false; \n\t\t\t\t\t\t}\n\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\t\t\t\n\t\t}\n\t\t//Added by Sethu for MOHE-CRF-0076 on 01/08/2021\n\t</script>\n  \t</head>\n";
    private final static byte[]  _wl_block26_2Bytes = _getBytes( _wl_block26_2 );

    private final static java.lang.String  _wl_block27 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"disableAllElements_billslmt_remove();setFocus()\" >\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"disable_elements();setFocus()\" >\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<body onLoad=\"setFocus()\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"   onSelect=\"codeArrestThruSelect();\">\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<form name=\'BillSlmtTypeForm\' id=\'BillSlmtTypeForm\' method=\'post\' action=\'\'  scrolling=no >\t\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\n\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\t\n\t\t<tr>\n<!--\t\t\t<td class=\"label\" align=\"right\" width=\"8%\">Receipt Type</td> -->\n\t\t\t<!--ram\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' readonly name=\"rectype\" id=\"rectype\" maxlength=\'3\' size=\'3\'  tabindex=\'1\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'><input type=\'button\' class=\'button\' name=\"rectypebut\" id=\"rectypebut\" value=\'?\' onClick=\"return rectypelkup()\" tabindex=\'2\'>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t<input type= hidden name=\"rectypedesc\" id=\"rectypedesc\"  value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\t\t\t\t\n\t\t\t\t<td width=\"25%\"></td>\n\t\t\t\t<td width=\"25%\"></td>\n\n\t\t</tr> ram-->\n\t\t<tr>\n\t\t\t<!--\n\t\t\t\t<td width=\"\" align=\"left\" colspan=\"1\"></td>\n\t\t\t\t<td width=\"\" align=\"right\" class=\"label\">Receipt Type</td>\t\n\t\t\t\t<td width=\"\" align=\"left\">&nbsp;<input type=\'text\' name=\'rectype\' id=\'rectype\' size=\'20\' maxlength=\'3\' value=\'\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t<td class=\"label\" align=\"right\" width=\"10%\">Account Code</td> -->\n\n\t\t\t<!--ram\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\t\n\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' readonly name=\"acccode\" id=\"acccode\" maxlength=\'10\' size=\'10\'  tabindex=\'3\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'><input type=\'button\' class=\'button\' name=\"acccodebut\" id=\"acccodebut\" value=\'?\' onClick=\"return acccodelkup()\" tabindex=\'4\'>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t<input type= hidden name=\"acccodedesc\" id=\"acccodedesc\"  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\tram-->\n\t\t\t\t\n\t\t\t<!--\n\t\t\t\t<td width=\"\" align=\"right\" class=\"label\">Account Code</td>\t\n\t\t\t\t<td width=\"\" align=\"left\" colsan=\"2\">&nbsp;<input type=\'text\' name=\'extacccode\' id=\'extacccode\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td> -->\n\n\n<!--\t\t\t<td class=\"label\" align=\"right\" width=\"6%\">Dept</td> -->\n\t\t\t<!--ram\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' readonly name=\"dept\" id=\"dept\" maxlength=\'6\' size=\'6\'  tabindex=\'5\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'><input type=\'button\' class=\'button\' name=\"deptbut\" id=\"deptbut\" value=\'?\' onClick=\"return deptlkup()\" tabindex=\'6\'>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t<input type= hidden name=\"deptdesc\" id=\"deptdesc\"  value=\'\'>\t\n\t\t</tr> ram-->\n\t\t\t   <!--\n\t\t\t\t<td width=\"\" align=\"right\" class=\"label\">Dept</td>\t\n\t\t\t\t<td width=\"\" align=\"left\">&nbsp;<input type=\'text\' name=\'extacccode\' id=\'extacccode\' size=\'15\' maxlength=\'6\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\t-->\t\n\t\t<!--\n        <tr><td width=\"\" align=\"left\" colspan=\"10\"></td></tr>\t\t\t\n\t\t<tr><td width=\"\" align=\"left\" colspan=\"10\"></td></tr>\t\t\t\n\t\t<tr><td width=\"\" align=\"left\" colspan=\"10\"></td></tr>\t\t\t\n\t\t<tr><td width=\"\" align=\"left\" colspan=\"10\"></td></tr>\t\t\n\t\t-->\n\t\t</table> \n\t\t\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\t\t\t\t\n\t\t\t<tr>\t\t\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'cash_given\' id=\'cash_given\' size=\'14\' maxlength=\'10\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" style=\'text-align:right\' onKeyPress=\'return(ChkNumberInputDeposit(this,event,document.forms[0].noofdecimal.value,document.forms[0].rec_ref.value))\' onBlur=\'fnCashcheck();checkFrNumber(this);\'> </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput2(this,event,document.forms[0].noofdecimal.value))\' onBlur=\'funCashcheck();checkForNumber(this);\'> </td>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\' onBlur=\'funCashcheck()\'> </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'cash_given\' id=\'cash_given\' size=\'14\' maxlength=\'10\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" style=\'text-align:right\' onKeyPress=\'return(ChkNumberInputDeposit(this,event,document.forms[0].noofdecimal.value,document.forms[0].rec_ref.value))\' onBlur=\'fnCashcheck();checkFrNumber(this);\'> </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'cash_given\' id=\'cash_given\' size=\'14\' maxlength=\'10\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" style=\'text-align:right\' readonly> </td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\' onBlur=\'funCashcheck()\'> </td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\n\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\t\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'cash_return\' id=\'cash_return\' id=\'cash_return\'  size=\'14\' maxlength=\'10\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" style=\'text-align:right\' readonly > </td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<tr>\t\t\n\t\t\t<td id=\'tdChqCarfBankNo\' class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\t\t \n\t\t\t<td class=\"fields\" width=\"25%\" ><input type=\'text\' name=\'instref\' id=\'instref\' id=\'instref\' size=\'15\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" >\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t</td>\t\t\n\t\t\t\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\t\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'instdate\' id=\'instdate\' size=\'15\' maxlength=\'10\' onBlur=\'return checkDateBL(this);\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'instdate\');\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =">\n\t  ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\t\t\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t</td> \n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\'  name=\"instremark\" id=\"instremark\" maxlength=\'100\' size=\'15\'  tabindex=\'0\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' onBlur=\"return bankcardlkup(\'B\')\" ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="><input type=\'button\' class=\'button\' name=\"bankcardbut\" id=\"bankcardbut\" value=\'?\' onClick=\"return bankcardlkup(\'C\')\" tabindex=\'0\' ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' readonly name=\"instbranch\" id=\"instbranch\" maxlength=\'100\' size=\'25\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" ></td>  \n\t\t\t\t<input type= hidden name=\"instremarkcode\" id=\"instremarkcode\"  value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\t        \t\t\n\t\t\t\t\n\t\t\t</tr>\n\t\t<INPUT TYPE=\"HIDDEN\" id=\"cashslmtflag\" name=\"cashslmtflag\" id=\"cashslmtflag\" SIZE=\"1\" MAXLENGTH=\"10\" VALUE=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"> \n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t<tr>\n<!--\t\t<td width=\"\" align=\"right\" class=\"label\" colspan = \'2\'>Payer\'s Name</td>\t-->\n\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\t\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'payername\' id=\'payername\' size=\'15\' maxlength=\'100\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\'></td>\n\n<!--\t\t<td width=\"\" align=\"right\" class=\"label\">Payer\'s Ref ID</td>\t-->\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\t\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'recrefidno\' id=\'recrefidno\' size=\'15\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" onKeyPress=\'return CheckForSpecChars(event)\'> </td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t<tr>\n\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\t\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' readonly name=\'membershipID\' id=\'membershipID\' size=\'15\' maxlength=\'100\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\'>\n\t\t\t<input type=\'button\' class=\'button\' name=\"couponButton\" id=\"couponButton\" value=\'Select\' onClick=\"couponcodelkup()\">\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\t\n\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\t\t\t\n\t\t\t<td width=\"25%\" height=\"50\" ><textarea readonly name=\"couponcodeTA\" id=\"couponcodeTA\" rows=\"4\" cols=\"47\"  maxlength = \"155\" value=\"\" >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</textarea></td>\n\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t<td width=\"25%\" height=\"50\" ><textarea readonly name=\"couponcodeTA\" id=\"couponcodeTA\" rows=\"4\" cols=\"47\"  maxlength = \"155\" value=\"\" ></textarea></td>\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t</tr>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t</table>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\n\t\t<INPUT TYPE=\"HIDDEN\" name=\"ext_acc_interface_yn\" id=\"ext_acc_interface_yn\" MAXLENGTH=\"10\" VALUE=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\t\t<INPUT TYPE=\"HIDDEN\" name=\"ext_acc_fac_id\" id=\"ext_acc_fac_id\" MAXLENGTH=\"10\" VALUE=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\t\n\t\t<tr>\t\t\n<!--\t<td align=\"right\" class=\"label\">Instrument Ref</td>\t\t -->\n\t\t<td id=\'tdChqCarfBankNo\' class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\t\t \n\t\t<td class=\"fields\" width=\"25%\" ><input type=\'text\' name=\'instref\' id=\'instref\' id=\'instref\' size=\'15\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" onKeyPress=\'return CheckForSpecChars(event)\' ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" onblur=\"callCardNoValidation(this)\">\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t</td>\t\t\n\t\t\t\n<!--\t<td width=\"\" align=\"right\" class=\"label\">Instrument Date</td>\tonBlur=\'return CheckDate(this);\'return \t\t\t\t\tchkDtGreaterEqualThanSysDateNew(document.forms[0].instdate,sys_date);\'showCalendar_loc(\'instdate\',document.forms[0].instdate);\"-->\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\t\n\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'instdate\' id=\'instdate\' size=\'15\' maxlength=\'10\' onBlur=\'return checkDateBL(this);\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =">\n\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\t\t\n\t\t\t\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;\t\t\t\t\t\n\t\t\t<applet code=\"CreditCardApplet.class\" name=\"CreditCardReader\" \n\t\t\t\t\tcodebase=\"../CreditCard/\" archive=\"CreditCardApplet.jar\" width=\"10\" height=\"10\">\n\t\t\t\t<PARAM name=\"button_width\" value=\"50\" />\n\t\t\t\t<PARAM name=\"button_height\" value=\"50\" />\n\t\t\t\t<PARAM name=\"button_label\" value=\"Credit Card\" />\t\n\t\t\t\t<PARAM name=\"input_data\" value=\"\" />\n\t\t\t\t<PARAM name=\"application_id\" value=\"\" />\t\n\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\tSorry, Your browser does not support Java applet!\n\t\t\t</applet> \n\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\t\t\n\t\t</td> \n\t\t<!--onClick=\"return showCalendar(\'instdate\');\"-->\n\t\t</tr> \t\t\t\n\t\t<tr>\t\t\t\t\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\t\t\n<!--\t\t\t<td class=\"label\" align=\"right\" width=\"6%\">Credit Card Co.</td> -->\n\t\t\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\t\t\n<!--\t\t\t<td class=\"label\" align=\"right\" width=\"6%\">Bank Name</td> -->\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\t\n\t\t\t<td width=\"25%\" class=\"fields\">\t\t\t\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t<input type=\'text\'  name=\"instremark\" id=\"instremark\" maxlength=\'100\' size=\'15\'  tabindex=\'0\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' onBlur=\"return bankcardlkup(\'B\')\" ><input type=\'button\' class=\'button\' name=\"bankcardbut\" id=\"bankcardbut\" value=\'?\' onClick=\"return bankcardlkup(\'C\')\" tabindex=\'0\' >\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\t\t\t\t\n\t\t\t\t<input type=\'text\'  name=\"instremark\" id=\"instremark\" maxlength=\'100\' size=\'15\'  tabindex=\'0\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =">\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\t\t\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\t\t\n\t\t\t\t</td>\n<!--\t\t<td class=\"label\" align=\"right\" width=\"\">Branch Name</td> -->\n\t\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" ></td>  \n\n   </tr>\n\t\t<input type= hidden name=\"instremarkcode\" id=\"instremarkcode\"  value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\t        \t\t\n\t\t<tr>\n<!--\t<td width=\"\" align=\"right\" class=\"label\">Online Apprv.</td>\t-->\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\t\t\n\t\t\t\t<td width=\"25%\" class=\"fields\" ><input type=\'checkbox\' name=\'onlineapproval\' id=\'onlineapproval\' ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="></td>\t\t\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\t\n\t\t\t\t<td width=\"25%\"  class=\"fields\"><input type=\'checkbox\' name=\'onlineapproval\' id=\'onlineapproval\' disabled></td>\t\t\t\t\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\t\n<!--\t<td width=\"\" align=\"right\" class=\"label\">Batch No</td>\t -->\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</td> \n\t    <td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'batchno\' id=\'batchno\' size=\'8\' maxlength=\'8\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' onKeyPress=\'return CheckForSpecChars(event)\' ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =">\n\t    \t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t    \t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t    \t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t    \t</td>\n\t\t</tr>\t\t\n\t\t<tr>\n<!-- \t<td width=\"\" align=\"right\" class=\"label\">Approval Code</td>\t -->\n\t \t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\t\n\t\t<!-- Changed by Subha V20180814/GHL-CRF-0544 apprrefno maxlength has been changed from 30 - 100-->\n\t    <td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'apprrefno\' id=\'apprrefno\' size=\'15\' maxlength=\'100\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\t\t\t\n\n<!--\t<td width=\"\" align=\"right\" class=\"label\">Batch No</td>\t-->\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</td>\t\n\t    <td width=\"25%\" class=\"fields\" ><input type=\'text\' name=\'batchno\' id=\'batchno\' size=\'8\' maxlength=\'8\' DISABLED value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" onKeyPress=\'return CheckForSpecChars(event)\'></td>\t\n\n        </tr>\n\t\t\n\t\t<tr>\n\n<!--\t<td width=\"\" align=\"right\" class=\"label\">Approval Code</td>\t-->\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</td>\t\n\t\t<!-- Changed by Subha V20180814/GHL-CRF-0544 apprrefno maxlength has been changed from 30 - 100-->\n\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t    \t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'apprrefno\' id=\'apprrefno\' size=\'15\' maxlength=\'100\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =">\n\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'apprrefno\' id=\'apprrefno\' size=\'15\' maxlength=\'100\' DISABLED value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" onKeyPress=\'return CheckForSpecChars(event)\'>\n\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\t\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\t\t\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\t\t\n\t\t</td>    \n\n<!--\t<td width=\"\" align=\"right\" class=\"label\">Sale Draft No</td>\t\t\t-->\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\t\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'saledraftno\' id=\'saledraftno\' size=\'15\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'saledraftno\' id=\'saledraftno\' size=\'15\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" DISABLED onKeyPress=\'return CheckForSpecChars(event)\'>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\t\t\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\t\t\t\t\n\t\t</td>\n\t\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t<tr>\t\t\n\t\t<!--\t<td width=\"\" align=\"right\" class=\"label\">Payer\'s Name</td>\t-->\n\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\t\n\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'payername\' id=\'payername\' size=\'15\' maxlength=\'100\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\'>\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\t\t\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\t\t\t\t\t\n\t\t\t\t</td>\n\n\t\t<!--\t<td width=\"\" align=\"right\" class=\"label\">Payer\'s Ref ID</td>\t-->\n\t\t\t\t<td width=\"25%\"class=\"label\">";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\t\n\n\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'recrefidno\' id=\'recrefidno\' size=\'15\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" onKeyPress=\'return CheckForSpecChars(event)\'>\n\n\t\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\t\t\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\t\t\t\t\t\n\t\t\t\t</td>      \t   \t\n\t\t\t</tr>\t\n";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t<tr>\t\t\n\t<!--\t<td width=\"\" align=\"right\" class=\"label\">Payer\'s Name</td>\t-->\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</td>\t\n\t\t\t<td width=\"25%\" class=\"fields\">\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t<input type=\'text\' name=\'payername\' id=\'payername\' size=\'15\' maxlength=\'100\' value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' >\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\t\t\t\n\t\t\t<input type=\'text\' name=\'payername\' id=\'payername\' size=\'15\' maxlength=\'100\' value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\t\t\t\t\t\n\t\t\t</td>\n\n\t<!--\t<td width=\"\" align=\"right\" class=\"label\">Payer\'s Ref ID</td>\t-->\n\t\t\t<td width=\"25%\"class=\"label\">";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</td>\t\n\n\t\t<td width=\"25%\" class=\"fields\">\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t<input type=\'text\' name=\'recrefidno\' id=\'recrefidno\' size=\'15\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" onKeyPress=\'return CheckForSpecChars(event)\' >\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\t\t\t\n\t\t\t<input type=\'text\' name=\'recrefidno\' id=\'recrefidno\' size=\'15\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\t\t\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t</td>      \t   \t\n\t\t\t</tr>\n\t\t\t<!-- <tr><td colspan=\"4\" >&nbsp;</td></tr> -->\t\t\t\t\t\t\n\t\t\t<!--<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>-->\n";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n<!-- Added by Monika for NMC-JD-CRF-0199 -->\n\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t<tr>\n\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\'cc_term_id_num\' id=\'cc_term_id_num\' size=\'15\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" onKeyPress=\'return CheckForSpecChars_tid(event)\' ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =">\n\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =">\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t<td colspan=\"2\"></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t<tr><td colspan=\"4\" ><input type=hidden id=\'cc_term_id_num\' name=\'cc_term_id_num\' id=\'cc_term_id_num\' value=\"\"></td></tr>\n\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t<!--<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>\n\t\t<tr><td colspan=\"4\" >&nbsp;</td></tr>-->\n\t   </table>\t\n\t\t<INPUT TYPE=\'HIDDEN\' id=\"cashslmtflag\" name=\"cashslmtflag\" id=\"cashslmtflag\" SIZE=\"1\" MAXLENGTH=\"10\" VALUE=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\"> \n<!--  <input type=\"hidden\" name=\"cashslmtflag\" id=\"cashslmtflag\" SIZE=\"1\" MAXLENGTH=\"10\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"> -->\n\t\t\t \n\t\t\t\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' valign = \'left\' width=\'60%\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"25%\">\n\t\t\t\t\t<div id=\'show_payTM_option\' style=\'display:inline\'>";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</div>\n\t\t\t\t</td>\n\t\t\t\t<td width=\'25%\' class=\"label\">\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="&nbsp;\n\t\t\t\t\t<input type=\"radio\" id=\'PayTMOption\' name=\'PayTMOption\' id=\'PayTMOption\' value=\'B\' checked=\"checked\" onclick=\"fnChangePayTM();\">\n\t\t\t\t</td>\n\t\t\t\t<td width=\'25%\' class=\"label\">\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="&nbsp;\n\t\t\t\t\t<input type=\"radio\" id=\'PayTMOption\' name=\'PayTMOption\' id=\'PayTMOption\' value=\'T\' onclick=\"fnChangePayTM();\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" width=\"18%\">\n\t\t\t\t\t\t<div id=\'show_payTM_field1\' style=\'display:inline\'>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</div>\n\t\t\t\t\t\t<div id=\'show_payTM_phone1\' style=\'display:none\'>";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="</div>&nbsp;&nbsp;\n\t\t\t\t\t\t<!--<div id=\'show_payTM_phone2\' style=\'display:none\'><INPUT TYPE=\"TEXT\" name=\"instref\" id=\"instref\" ID=\"instref\" SIZE=\"14\" style=\'text-align:left\' value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"></div>-->\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"fields\" width=\"32%\">\n\t\t\t\t\t\t<div id=\'show_payTM_field2\' style=\'display:inline\'><INPUT TYPE=\"TEXT\" name=\"instref\" id=\"instref\" ID=\"instref\" SIZE=\"30\" maxlength=\"25\" style=\'text-align:left\' value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\"></div> &nbsp;&nbsp;\n\t\t\t\t\t\t<div id=\'show_payTM_otp1\' style=\'display:none\'>";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</div>&nbsp;&nbsp;\n\t\t\t\t\t\t<div id=\'show_payTM_otp2\' style=\'display:none\'><INPUT TYPE=\"TEXT\" name=\"paytmOtp\" id=\"paytmOtp\" ID=\"paytmOtp\" SIZE=\"10\" maxlength=\"10\" style=\'text-align:left\'></div>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\" width=\"15%\">\n\t\t\t\t\t\t<div id=\'show_payTM_field3\' style=\'display:none\'>";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</div>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"fields\" width=\"15%\">\n\t\t\t\t\t\t<div id=\'show_payTM_field4\' style=\'display:none\'><INPUT TYPE=\"TEXT\" name=\"batchno\" id=\"batchno\" ID=\"batchno\" SIZE=\"10\" style=\'text-align:left\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'></div>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\t\n\t\t\t\t\t\t<td class=\"fields\" width=\"10%\">\n\t\t\t\t\t\t\t<div id=\'show_payTM_button1\' style=\'display:none\'><input type=\'button\' name=\'validate_paytm_pay\' id=\'validate_paytm_pay\' value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" class=\'button\' onClick=\'validate_py_tranx(\"PAY\")\' ";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" width=\"10%\">\n\t\t\t\t\t\t\t<div id=\'show_payTM_button2\' style=\'display:none\'><input type=\'button\' name=\'validate_paytm_check\' id=\'validate_paytm_check\' value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" class=\'button\' onClick=\'validate_py_tranx(\"CHECKSTATUS\")\' ";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\n\t\t\t\t</tr>\n\t\t\t\t<tr>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\t\n\t\t\t\t\t<td width=\"18%\"class=\"label\">";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="</td>\t\n\t\t\t\t\t<!-- Changed by Subha V20180814/GHL-CRF-0544 apprrefno maxlength has been changed from 30 - 100-->\n\t\t\t\t\t<td width=\"32%\" class=\"fields\"><input type=\'text\' name=\'apprrefno\' id=\'apprrefno\' size=\'15\' maxlength=\'100\' value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 =">\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\t\t\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\t\t\t\t\t\n\t\t\t\t\t</td>  \n\t\t\t\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\t\n\t\t\t\t\t<td width=\"15%\" class=\"label\">";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</td>\t\n\t\t\t\t\t<td width=\"15%\" class=\"fields\"><input type=\'text\' name=\'instdate\' id=\'instdate\' size=\'15\' maxlength=\'10\' onBlur=\'return ValidateDateTimesp(this);\' value=\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 =">&nbsp;&nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" id=\"PayTMCal\" onClick=\"return showCalendar(\'instdate\',null,\'hh:mm:ss\');\" ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 =">\n\t\t\t\t\t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\t\t\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\t\t\n\t\t\t\t\t</td> \n\t\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t</tr> \t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"18%\" class=\"label\">";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\t\n\t\t\t\t\t\t<td width=\"32%\" class=\"fields\"><input type=\'text\' name=\'saledraftno\' id=\'saledraftno\' size=\'15\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" onKeyPress=\'return CheckForSpecChars(event)\'>\n\t\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t\t\t<td width=\"30%\" class=\"fields\"><input type=\'text\' name=\'saledraftno\' id=\'saledraftno\' size=\'15\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"15%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t\n\t\t\t\t</tr>\n\n\t\t   </table>\t\n\t\t\t<INPUT TYPE=\'HIDDEN\' id=\"cashslmtflag\" name=\"cashslmtflag\" id=\"cashslmtflag\" SIZE=\"1\" MAXLENGTH=\"10\" VALUE=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\"> \n\t\t\t<!--  <input type=\"hidden\" name=\"cashslmtflag\" id=\"cashslmtflag\" SIZE=\"1\" MAXLENGTH=\"10\" value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\"> -->\n\t\t\t\t \n\t\t\t\n";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\t\t\t\n\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\n\t\t\t<tr>\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\t\n\t\t\t\t<td width=\"18%\">&nbsp;</td>\n\t\t\t\t<td width=\"32%\">&nbsp;</td>\n\t\t\t\t<td width=\"15%\">&nbsp;</td>\n\t\t\t\t<td class=\"fields\" width=\"15%\" align=\"left\">\n\t\t\t\t\t<div id=\'show_paysky_button1\'  style=\'display:none\'>\n\t\t\t\t\t<input type=\'button\' name=\'validate_paysky_pay\' id=\'validate_paysky_pay\' value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" class=\'button\' onClick=\'validate_ps_tranx(\"PAY\")\' ";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 =">\n\t\t\t\t\t</div>\n\t\t\t\t</td>\t\t\n\t\t\t\t<td width=\"10%\">&nbsp;</td>\t\t\t\t\t\t\t\t\n\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t<td width=\"18%\">&nbsp;</td>\n\t\t\t\t<td width=\"32%\">&nbsp;</td>\n\t\t\t\t<td width=\"15%\">&nbsp;</td>\n\t\t\t\t<td width=\"15%\">&nbsp;</td>\n\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\n\t\t\t</tr>\n\t\t\t<tr>\t\n\t\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\t\n\t\t\t\t<td width=\"18%\"class=\"label\">";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="</td>\t\n\t\t\t\t<td width=\"32%\" class=\"fields\"><input type=\'text\' name=\'apprrefno\' id=\'apprrefno\' size=\'15\' maxlength=\'100\' value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\t\t\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\t\t\t\t\t\n\t\t\t\t</td>  \n\t\t\t\t";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\t\n\t\t\t\t<td width=\"15%\" class=\"label\">";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="</td>\t\n\t\t\t\t<td width=\"15%\" class=\"fields\"><input type=\'text\' name=\'instdate\' id=\'instdate\' size=\'15\' maxlength=\'10\' onBlur=\'return ValidateDateTimesp(this);\' value=\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\t\t\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\t\t\n\t\t\t\t</td> \n\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t</tr> \t\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td width=\"18%\" class=\"label\">";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</td>\n\t\t";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\t\n\t\t\t\t\t<td width=\"32%\" class=\"fields\"><input type=\'text\' name=\'saledraftno\' id=\'saledraftno\' size=\'15\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" onKeyPress=\'return CheckForSpecChars(event)\'>\n\t\t";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t\t\t\t<td width=\"30%\" class=\"fields\"><input type=\'text\' name=\'saledraftno\' id=\'saledraftno\' size=\'15\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td width=\"15%\">&nbsp;</td>\n\t\t\t\t<td width=\"15%\">&nbsp;</td>\n\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t<td width=\"10%\">&nbsp;</td>\t\t\t\n\t\t\t</tr>\n\n\t\t</table>\t\n\t\t<INPUT TYPE=\'HIDDEN\' id=\"cashslmtflag\" name=\"cashslmtflag\" id=\"cashslmtflag\" SIZE=\"1\" MAXLENGTH=\"10\" VALUE=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\"> \t\t\n";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 =" \n\t<input type= hidden name=\"locale\" id=\"locale\"  value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">\n\t<input type=\'hidden\' name=\'short_desc\' id=\'short_desc\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\n\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\" >\n\t<input type=hidden name=\'sys_date\' id=\'sys_date\' value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\n\t<input type=hidden name=\'str_credit_card_machine_int_yn\' id=\'str_credit_card_machine_int_yn\' value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n\t<input type=hidden name=\'cashier_cheque_yn\' id=\'cashier_cheque_yn\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n\t<input type=hidden name=\'sale_draft_reqd_yn\' id=\'sale_draft_reqd_yn\' value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n\t<input type=hidden name=\'payer_name_reqd_yn\' id=\'payer_name_reqd_yn\' value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t<input type=hidden name=\'payer_ref_reqd_yn\' id=\'payer_ref_reqd_yn\' value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n\t<input type=hidden name=\'credit_card_num_yn\' id=\'credit_card_num_yn\' value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n\t<input type=hidden name=\'credit_card_co_yn\' id=\'credit_card_co_yn\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t<input type=hidden name=\'approval_code_yn\' id=\'approval_code_yn\' value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t<input type=hidden name=\'credit_card_check_yn\' id=\'credit_card_check_yn\' value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t<input type=hidden name=\'terminal_id_reqd_yn\' id=\'terminal_id_reqd_yn\' value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\t\t\t\t\t<!--Added by Monika for NMC-JD-CRF-0199 on 07/07/203-->\t\n\t<input type=hidden name=\'cc_terminal_id_enable\' id=\'cc_terminal_id_enable\' value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n\t\n\t<input type=hidden name=\'batch_no_reqd_yn\' id=\'batch_no_reqd_yn\' value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\">\n\t<input type=hidden name=\'slmt_doc_ref_date_reqd_yn\' id=\'slmt_doc_ref_date_reqd_yn\' value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n\n\t<input type=hidden name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\">\n\t<input type=hidden name=\'rec_ref\' id=\'rec_ref\' id=\'rec_ref\' value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\">\n\t<input type=hidden name=\'chequeCategorize\' id=\'chequeCategorize\' id=\'chequeCategorize\' value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\">\n\t<input type=hidden name=\'chequeLengthChange\' id=\'chequeLengthChange\' id=\'chequeLengthChange\' value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\">\n\n\t<!--Added by Sethu for GHL-CRF-0415 on 19/04/2017-->\n\t<input type=hidden name=\'slmt_type\' id=\'slmt_type\' value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\">\n\t<input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=\'";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\'>\n\t<input type=\'hidden\' name=\'PayTMTransDate\' id=\'PayTMTransDate\' value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\">\n\t<input type=\'hidden\' name=\'LoggedUser\' id=\'LoggedUser\' value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n\t<input type=hidden name=\'application_id\' id=\'application_id\' value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\">\n\t<input type=hidden name=\'facilityid\' id=\'facilityid\' value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n\t<input type=hidden name=\'clientIpAddress\' id=\'clientIpAddress\' value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\">\n\t<!--Added by Sethu for GHL-CRF-0373 on 05/06/2019-->\n\t<input type=hidden id=\'action_ind\' name=\'action_ind\' id=\'action_ind\' value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n\t<!--Added by Sethu for KDAH-CRF-0504 on 14/08/2019-->\n\t<input type=hidden id=\'credit_card_status_yn\' name=\'credit_card_status_yn\' id=\'credit_card_status_yn\' value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n\t<input type=hidden id=\'credit_card_batch_id\' name=\'credit_card_batch_id\' id=\'credit_card_batch_id\' value=\"\">\n\t<input type=hidden id=\'credit_card_roc_no\' name=\'credit_card_roc_no\' id=\'credit_card_roc_no\' value=\"\">\n\t<input type=hidden id=\'credit_card_trn_no\' name=\'credit_card_trn_no\' id=\'credit_card_trn_no\' value=\"\">\n\t<input type=hidden id=\'credit_trn_status\' name=\'credit_trn_status\' id=\'credit_trn_status\' value=\"N\">\n\t<!--Added by Sethu for KDAH-CRF-0535 on 07/01/2020-->\n\t<input type=hidden id=\'cc_request_type\' name=\'cc_request_type\' id=\'cc_request_type\' value=\"\">\n\t<input type=hidden id=\'credit_card_urn_no\' name=\'credit_card_urn_no\' id=\'credit_card_urn_no\' value=\"\">\n\t<!--Added by Sethu for KDAH-CRF-0535 on 07/01/2020-->\n\t<input type=\'hidden\' name=\'coupon_yn\' id=\'coupon_yn\' value=\'";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\'>\n\t<input type=\'hidden\' name=\'patMembershipID\' id=\'patMembershipID\' value=\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\'>\t\n\t<input type=\'hidden\' name=\'siteCouponInSlmt\' id=\'siteCouponInSlmt\' value=\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\'>\n\t<input type=\'hidden\' name=\'couponAndAmt\' id=\'couponAndAmt\' value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\" >\t\t\n\t<input type=\'hidden\' name=\'coupons\' id=\'coupons\' value=\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\'>\n\t<input type=\'hidden\' name=\'couponcode\' id=\'couponcode\' value=\'";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\'>\n\t<!--Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t<!-- <input type=hidden id=\'cc_term_id_num\' name=\'cc_term_id_num\' id=\'cc_term_id_num\' value=\"\"> --> \t<!-- Used this field to display for NMC-JD-CRF-0199 so commented this -->\n\t<input type=hidden id=\'cc_issuing_bank\' name=\'cc_issuing_bank\' id=\'cc_issuing_bank\' value=\"\">\n\t<input type=hidden id=\'cc_trx_date_time\' name=\'cc_trx_date_time\' id=\'cc_trx_date_time\' value=\"\">\t\n\t<!--Added by Sethu for MOHE-CRF-0076 on 25/08/2021-->\n\t<input type=\'hidden\' name=\'segment_id\' id=\'segment_id\' value=\'";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\'>\n\t\n</form>\t \n</body>\n";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n</html>\n\n\n\n\n";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );
	
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

	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt		= null;
	CallableStatement call = null;
	ResultSet rs = null; 
	ResultSet rs21 = null; 
	ResultSet rs2= null; ResultSet rscurr=null;
	con	=	ConnectionManager.getConnection(request);
	//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
	String		strfacilityid ="";String strscashcountercode="";
	int noofdecimal=2;
	String batch_no_reqd_yn="",slmt_doc_ref_date_reqd_yn="", readonly1="";

	//unused variable, commented on 09/06/05
	String      strloggeduser = "";
	String		strslmtidno = request.getParameter("slmtidno");	
	String		strslmtpayername = request.getParameter("slmtpayername");
	String		strbilldoctypecode = request.getParameter("billdoctypecode");	
	String		strbilldocnum = request.getParameter("billdocnum");	
	String		str_receipt_type_code = "";	String		str_ext_acc_facility_id = "";
	String		str_ext_account_code	= "";	String		str_ext_dept_ind = "";
	String		str_ext_dept_code     = "";	String		str_single_service_grp_yn = "";
	String		str_service_grp		= "";	String		str_acc_episode_type= "";
	String		str_acc_category_code	= "";	String		str_acc_serv_grp_used_yn	= "";
	String		str_reln_code		= "";	String		str_episode_type		= "";
	String		str_error_text		= "";	String		short_desc= "";
	String    action_ind="";
	String	str_credit_card_machine_int_yn = "N";	String str_credit_card_machine_id= "";	String	 str_err_code= "";
	String	str_sys_message_id = "";String field_separator="";String piped_op="";String credit_card_approvd_YN="";
	String strApprovel="",strMerchant="",strTermIdentNo="",strExpiryDate="",strTransTime ="";
	String rec_ref="";
	
	String function_id = request.getParameter("function_id");
	String custId = BLReportIdMapper.getCustomerId();	
	if(function_id == null) function_id="";

	//Added by Sethu for GHL-CRF-0415 on 19/04/2017
	boolean isDebugYN = false; 
	String  strslmttype= request.getParameter("slmttype");
	String	strpatientid = request.getParameter("patientid");
	//V210113
	String 	strcoupon_yn = request.getParameter("coupon_yn");
	String  patMembershipID = "";
	String  coupon_yn = "";
	//V210113
	String couponcode="";//V210224
	String strApplicationID = "";
	String payTMOption = "B";

	Properties p;		
	String strClientIpAddress = "";
	//Added by Sethu for GHL-CRF-0415 on 19/04/2017

	String    billslmtamt=""; String    slmttype=""; String    cash_given=""; 
	String    cash_return=""; String    instref="";   String    instdate=""; String    creditcardco="";     String    instbankname=""; String   instbranch=""; String    batchno=""; String    apprrefno=""; 
	String    saledraftno="";   String    onlineapproval="checked";
	String temp_bank_credit=""; String p_instremarkcode=""; String sys_date="";String billslmtamtdet2="",slmt_change="",slmt_flag="",cashier_cheque_yn="";
	String readonly_fld="",disabled_fld="";
	String sale_draft_reqd_yn="",payer_name_reqd_yn="",payer_ref_reqd_yn="",error_level="",sys_message_id="",error_text="";
	String credit_card_num_yn="";
	String credit_card_co_yn="";
	String approval_code_yn="";
	String credit_card_check_yn="";
	String val_crCard="";
	String terminal_id_reqd_yn = "N";
	double billslmtamtdetDb=0.00;
	String locale	= (String)session.getAttribute("LOCALE");	
	if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) 
	{strslmtidno = "";}

	if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null")) 
	{strslmtpayername = "";}
	/*  Added by Monika against NMC-JD-CRF-0199	*/
	boolean cc_terminal_id_enable = CommonBean.isSiteSpecific(con, "BL", "CC_TERMINAL_ID_ENABLE");
	/* ML-MMOH-CRf-0527 - Rajesh V */
	boolean chequeCategorize = CommonBean.isSiteSpecific(con, "BL", "CHEQUE_TYPE_ENABLED");
	//Added for ML-MMOH-CRF-1088 - Rajesh V
	boolean chequeLengthChange = CommonBean.isSiteSpecific(con, "BL", "CHEQUE_OTHERS_MAX_CHARS");
	//Added against ML-MMOH-SCF-1576
	boolean isSiteSpec = false;
	String siteSettletypeYN = "N";	
	try {
			isSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "GST_FOR_CREDIT_CARD");
			if (isSiteSpec)
				siteSettletypeYN = "Y";
			else
				siteSettletypeYN = "N";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in isSiteSpec_GHL " + e);
		}
	//Added against ML-MMOH-SCF-1576
//V220721
	boolean  defaultRefund= false;
	String defaultRefundYN = "N";	
	try {
		defaultRefund = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "DFLT_SLMTAMT_AS_CASHGIVEN_RFND");
		if (defaultRefund)
			defaultRefundYN = "Y";
		else
			defaultRefundYN = "N";
	  } catch (Exception ex) {
		ex.printStackTrace();
		System.err.println("Exception in defaultRefund " + ex);
	}
	System.err.println("defaultRefundYN " + defaultRefundYN);
	//V220721
	//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	
	String sqlStatement = "";
	int ccAppletCount = 0;

	//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019
	String slmt_check_status = "N";
	String standard_code = "", segment_id = "";

	boolean siteCouponInSlmt = CommonBean.isSiteSpecific(con, "BL", "TO_ENABLE_COUPON_IN_SETTLEMENT");	//V210113
	String coupons=""; //V210224
	String couponAndAmts=""; //V210224
	
	//Added by Sethu for GHL-CRF-0415 on 01/09/2017
	try
	{
		isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		if(isDebugYN)
			System.out.println("***Inside Settlement Type 2 - Patient ID... "+strpatientid+" ***Settlement Type... "+strslmttype);

		String queryApplicationID="select NVL(APPLICATION_ID,'') from XH_FILTER_DMS_VW where KEY_1 = ?";
		pstmt = con.prepareStatement(queryApplicationID);
		pstmt.setString(1,strslmttype);
		rs = pstmt.executeQuery() ;
		if( rs!= null ) 
		{
			while( rs.next() )
			{  
				strApplicationID = rs.getString(1);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
	}		
	catch(Exception e)
	{
		//out.println("Exception while fetching APPLICATION_ID from XH_FILTER_DMS_VW :"+e);
		e.printStackTrace();
	}
	
	if(isDebugYN)
		System.out.println("***Inside Settlement Type 2 - Application ID... "+strApplicationID);	
	 
	try
	{
		String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date) ;
		if( rs!= null ) 
		{
			while( rs.next() )
			{  
				sys_date = rs.getString(1);
			}
		}
		if(rs != null) rs.close();
		stmt.close();
	}		
	catch(Exception e)
	{
		//out.println("Exception :"+e);
		e.printStackTrace();
	}
	//V210113 start
	try
	{
		String membershipIDQuery="select nvl(ALT_ID4_NO,'') from mp_patient where patient_id = ?";
		
		pstmt=con.prepareStatement(membershipIDQuery);
		pstmt.setString(1,strpatientid);
		
		
		rs = pstmt.executeQuery() ;
		if( rs!= null ) 
		{
			while( rs.next() )
			{  
				patMembershipID = checkForNull(rs.getString(1));
			}
		}
		if(rs != null) rs.close();
		if(pstmt!=null) pstmt.close();
	}		
	catch(Exception e)
	{
		//out.println("Exception patMembershipID:"+e);
		e.printStackTrace();
	}
	//V210113 end
  	try
  	{	
		
		

		//con	=	ConnectionManager.getConnection(request);			
		strfacilityid	=  (String) session.getValue("facility_id");
		//unused variable, commented on 09/06/05
		strloggeduser	=  (String) session.getValue("login_user");		
		
		//Added by Sethu for GHL-CRF-0415 on 19/04/2017
		p = (java.util.Properties)session.getValue("jdbc");
		strClientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");

		String cash_slmt_flag = "";				
		String ext_acc_interface_yn = "";
		String cc_term_id_num = "";
		String querystring=(String)request.getQueryString();
		System.out.println("Request Parameter in BLBillSlmtType2 : "+querystring);
		if( strslmttype == null) strslmttype="";
		billslmtamtdet2=request.getParameter("billslmtamt");		
		if(billslmtamtdet2==null)  billslmtamtdet2="";
		billslmtamtdetDb=Double.parseDouble(billslmtamtdet2);
		if(strcoupon_yn == null) strcoupon_yn ="";//V210113
		rec_ref=request.getParameter("rec_ref");
		if(rec_ref==null || rec_ref.equals("")) rec_ref="";
		
		System.err.println("rec_ref "+rec_ref);
		action_ind=request.getParameter("action");	
		if(action_ind==null || action_ind.equals("")) action_ind="";
		System.err.println("action_ind "+action_ind);
		System.err.println("billslmtamtdetDb "+billslmtamtdetDb);

		strscashcountercode=request.getParameter("strscashcountercode");
		if(strscashcountercode==null || strscashcountercode.equals("")) strscashcountercode="";


		credit_card_approvd_YN=request.getParameter("credit_card_approvd_YN");
		if(credit_card_approvd_YN==null || credit_card_approvd_YN.equals("")) credit_card_approvd_YN="N";

		slmt_change=request.getParameter("slmt_change");
		if(slmt_change==null || slmt_change.equals("undefined")) slmt_change="N";
		System.err.println("slmt_change="+slmt_change);
		slmt_flag=request.getParameter("slmt_flag"); //V220808
		System.err.println("slmt_flag="+slmt_flag);
		if(action_ind.equals("modify") && !slmt_change.equals("Y"))
		{	
			//V210113 start
			coupon_yn = request.getParameter("coupon_yn");
			if(coupon_yn==null || coupon_yn.equals("")) coupon_yn = "";
			System.err.println("coupon_yn="+coupon_yn);
			//V210113 end
			//V210224 start
			coupons = request.getParameter("couponcode");
			System.err.println("coupons=>"+coupons);
			//if(coupons.equals("")) coupons = "";
			if(coupons==null || coupons.equals("")) coupons = "";
			System.err.println("coupons="+coupons);
			couponAndAmts = request.getParameter("couponAndAmt");
			if(couponAndAmts==null || couponAndAmts.equals("")) couponAndAmts="";
			//V210224 end
			billslmtamt=request.getParameter("billslmtamt");
			if(billslmtamt==null || billslmtamt.equals("")) billslmtamt="";	
			slmttype=request.getParameter("slmttype");
			if(slmttype==null || slmttype.equals("")) slmttype="";
			cash_given=request.getParameter("cash_given");
			if(cash_given==null || cash_given.equals("")) cash_given="";
			System.err.println("cash_given "+cash_given);
			cash_return=request.getParameter("cash_return");
			if(cash_return==null || cash_return.equals("")) cash_return="";
			instref=request.getParameter("instref");
			if(instref==null || instref.equals("")) instref="";		
			instdate=request.getParameter("instdate");
			if(instdate==null || instdate.equals("")) instdate="";
			creditcardco=request.getParameter("creditcardco");
			if(creditcardco==null || creditcardco.equals("")) creditcardco="";
			instbankname=request.getParameter("instbankname");
			if(instbankname==null || instbankname.equals("")) instbankname="";
			p_instremarkcode=request.getParameter("instremarkcode");
			if(p_instremarkcode==null || p_instremarkcode.equals("")) p_instremarkcode="";

			slmt_flag=request.getParameter("slmt_flag");
			if(slmt_flag==null || slmt_flag.equals("")) slmt_flag="";
						if(!slmt_flag.equals("A"))
			{
				temp_bank_credit=instbankname;
			}
			else{
				temp_bank_credit=creditcardco;
				}
			instbranch=request.getParameter("instbranch");
			if(instbranch==null || instbranch.equals("")) instbranch="";
			batchno=request.getParameter("batchno");
			if(batchno==null || batchno.equals("")) batchno="";
			apprrefno=request.getParameter("apprrefno");
			if(apprrefno==null || apprrefno.equals("")) apprrefno="";
			saledraftno=request.getParameter("saledraftno");
			if(saledraftno==null || saledraftno.equals("")) saledraftno="";
			strslmtpayername=request.getParameter("payername");
			if(strslmtpayername==null || strslmtpayername.equals("")) strslmtpayername="";
			strslmtidno=request.getParameter("recrefidno");
			if(strslmtidno==null || strslmtidno.equals("")) strslmtidno="";
			onlineapproval=request.getParameter("onlineapproval");
			if(onlineapproval==null || onlineapproval.equals("")) onlineapproval="";	
			cc_term_id_num = request.getParameter("cc_term_id_num");
			if(cc_term_id_num == null || cc_term_id_num.equals("")) cc_term_id_num = "";
		}	
		//V220721
		
		if(defaultRefundYN.equals("Y"))
		{
			if(slmt_flag.equals("Y")){ //V220808
				if(billslmtamtdetDb<0){
					cash_given=billslmtamtdet2;
					System.err.println("cash_given,315- " + cash_given);
				}else{
					if(rec_ref.equals("F"))
					{
						cash_given=billslmtamtdet2;
						System.err.println("cash_given,319- " + cash_given);
					}
				}	
			}
		}
		//V220721
		
//cc interface logic
		try
		{
			piped_op=request.getParameter("piped_op");
			if(piped_op==null || piped_op.equals("")) piped_op="";
			field_separator=request.getParameter("field_separator");
			if(field_separator==null || field_separator.equals("")) field_separator="";
			StringTokenizer st=new StringTokenizer(piped_op,field_separator);
			//int i=0;
			while(st.hasMoreTokens())
			{	
				strApprovel = st.nextToken();
				apprrefno = st.nextToken();
				saledraftno = st.nextToken();
				strMerchant  = st.nextToken();
				strTermIdentNo  = st.nextToken();						
				temp_bank_credit  = st.nextToken();
				instref  = st.nextToken();
				//instdate  = st.nextToken();						
				instdate  = st.nextToken();
				batchno  = st.nextToken();
				strExpiryDate  = st.nextToken();													
				strTransTime  = st.nextToken();
				strslmtidno  = st.nextToken();
				p_instremarkcode  = st.nextToken();
				strslmtpayername  = st.nextToken();
				//i++;
			}
			//for validating credit card num
			
				String strqry = "{ call BLCORE.VALIDATE_CREDIT_CARD_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
				
			call = con.prepareCall(strqry);	
			call.setString(1,strslmttype);
			call.setString(2,instref);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);
			call.registerOutParameter(11,java.sql.Types.VARCHAR);
			call.registerOutParameter(12,java.sql.Types.VARCHAR);
			call.registerOutParameter(13,java.sql.Types.VARCHAR);
			call.registerOutParameter(14,java.sql.Types.VARCHAR);
			call.registerOutParameter(15,java.sql.Types.VARCHAR);
			
			call.execute();
			sale_draft_reqd_yn=call.getString(3);
			if(sale_draft_reqd_yn == null) sale_draft_reqd_yn="";
			payer_name_reqd_yn=call.getString(4);
			if(payer_name_reqd_yn == null) payer_name_reqd_yn="";
			payer_ref_reqd_yn=call.getString(5);
			if(payer_ref_reqd_yn == null) payer_ref_reqd_yn="";

			/***  Added against CRF  AAKH-CRF-0014   37864				*/
			batch_no_reqd_yn=call.getString(6);	
			if(batch_no_reqd_yn == null) batch_no_reqd_yn="";			
  
			/***  Added by Monika against NMC-JD-CRF-0199	*/
			terminal_id_reqd_yn = call.getString(7);	
			if(terminal_id_reqd_yn == null) terminal_id_reqd_yn="N";
			System.out.println("terminal_id_reqd_yn : "+terminal_id_reqd_yn);
			
			slmt_doc_ref_date_reqd_yn=call.getString(8);
			if(slmt_doc_ref_date_reqd_yn == null) slmt_doc_ref_date_reqd_yn="";			

				credit_card_num_yn=call.getString(9);
				if(credit_card_num_yn == null) credit_card_num_yn="";
				credit_card_co_yn=call.getString(10);
				if(credit_card_co_yn == null) credit_card_co_yn="";
				approval_code_yn=call.getString(11);
				if(approval_code_yn == null) approval_code_yn="";
				credit_card_check_yn=call.getString(12);
				if(credit_card_check_yn == null) credit_card_check_yn="";
				
				error_level=call.getString(13);
				if(error_level == null) error_level="";
				sys_message_id=call.getString(14);
				if(sys_message_id == null) sys_message_id="";
				error_text=call.getString(15);
				if(error_text == null) error_text="";


				call.close();	


			if ((error_level.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))
			{
				if (error_level.equals("10") ||(!error_text.equals("")))
				{

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(error_text));
            _bw.write(_wl_block6Bytes, _wl_block6);
				
				}
				if(!sys_message_id.equals(""))
				{

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sys_message_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
				
				}
			}
			//end CC validation
			if(credit_card_approvd_YN.equals("Y"))
			{

            _bw.write(_wl_block9Bytes, _wl_block9);

			}
		}
		catch(Exception cc)
		{
			System.err.println("Exception  cc"+cc);
			
		}
		//end cc

		try 
		{
			pstmt = con.prepareStatement("select SHORT_DESC  from bl_slmt_type_lang_vw where SLMT_TYPE_CODE=? and LANGUAGE_ID=? ");
			pstmt.setString(1,strslmttype);
			pstmt.setString(2,locale);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{						
				while( rs2.next() ) 
				{												
					short_desc = rs2.getString( "short_desc" ) ;							
					if ( short_desc == null ) short_desc ="";
		 		}
			}
			if(rs2 != null) rs2.close();
			pstmt.close();
		}
		catch(Exception e) 
		{
			//out.println(e.toString());
			e.printStackTrace();	
		}
	
		ext_acc_interface_yn = request.getParameter("ext_acc_interface_yn");
		if(ext_acc_interface_yn == null) ext_acc_interface_yn="N";
/* Commented and added getparameter for PE Changes
		String query_ext_acc="Select nvl(ext_account_interface_yn,'N') ext_acc_interface from bl_parameters where operating_facility_id='"+strfacilityid+"'";
		try
		{
			stmt=con.createStatement();
			rs21=stmt.executeQuery(query_ext_acc);
			if(rs21 != null)
			{
				while(rs21.next())
				{
					ext_acc_interface_yn =rs21.getString("ext_acc_interface");
				}
			}
			if(rs21 != null) rs21.close();
			stmt.close();
		}  
		catch(Exception e )
		{	
			out.println(e);
		} 
*/		   	
	//Package depoist restricted call below packages  modified on 18/11/2014
		if(!function_id.equals("rcpt_rfnd") && !function_id.equals("PKG_BILLING"))
		{
			try
			{
				call =  con.prepareCall("{ call blopin.proc_ext_acc_serv_group_check (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");			
				call.setString(1,strfacilityid);
				call.setString(2,strbilldoctypecode);
				call.setString(3,strbilldocnum);
				call.setString(4,"BI");
				call.registerOutParameter(5,java.sql.Types.VARCHAR);	
				call.registerOutParameter(6,java.sql.Types.VARCHAR);	
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
				call.registerOutParameter(17,java.sql.Types.VARCHAR);	
			
				call.execute();									

				str_receipt_type_code	 = call.getString(5);	
				str_ext_acc_facility_id  	 = call.getString(6);	
				str_ext_account_code	 = call.getString(7);	
				str_ext_dept_ind		 = call.getString(8);	
				str_ext_dept_code     	 = call.getString(9);	
				str_single_service_grp_yn = call.getString(10);	
				str_service_grp		= call.getString(11);	
				str_acc_episode_type	= call.getString(12);	
				str_acc_category_code	= call.getString(13);	
				str_acc_serv_grp_used_yn	= call.getString(14);	
				str_reln_code		= call.getString(15);	
				str_episode_type		= call.getString(16);	
				str_error_text		= call.getString(17);	

				call.close();

				if (str_receipt_type_code == null) str_receipt_type_code = "";
				if (str_ext_acc_facility_id == null) str_ext_acc_facility_id = "";
				if (str_ext_account_code == null) str_ext_account_code = "";
				if (str_ext_dept_ind == null) str_ext_dept_ind = "";
				if (str_single_service_grp_yn == null) str_single_service_grp_yn = "";
				if (str_service_grp == null) str_service_grp = "";
				if (str_acc_episode_type == null) str_acc_episode_type = "";
				if (str_acc_category_code == null) str_acc_category_code = "";
				if (str_acc_serv_grp_used_yn == null) str_acc_serv_grp_used_yn = "";
				if (str_reln_code == null) str_reln_code = "";
				if (str_episode_type == null) str_episode_type = "";
				if (str_error_text == null) str_error_text = "";
				if (str_ext_dept_code == null) str_ext_dept_code = "";
	

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			catch(Exception e )
			{
				//out.println(e);
				e.printStackTrace();
			}
		}

		String query_cash_slmt_type="Select cash_slmt_flag,CASHIER_CHEQUE_YN,nvl(coupon_yn,'N') from bl_slmt_type where slmt_type_code=?"; //V210113

		try
		{
			pstmt=con.prepareStatement(query_cash_slmt_type);
			pstmt.setString(1,strslmttype);
			rs21=pstmt.executeQuery();
			if(rs21 != null)
			{
				while(rs21.next())
				{
					cash_slmt_flag=rs21.getString(1);
					cashier_cheque_yn=rs21.getString(2);
					coupon_yn = rs21.getString(3); //V210113
				}
			}
		}
		catch(Exception e )
		{	
			out.println(e);
		} 
		   	
		//for credit card machine dtl		
		try
		{
			if(cash_slmt_flag.equals("A") ||  cash_slmt_flag.equals("D") && (cash_slmt_flag.equals("D") && coupon_yn.equals("N"))) //V210113
			{
				String ccCheck="{ call BLCOMMON.GET_CREDIT_CARD_INT_DTL (?,?,?,?,?,?,?,?)}";
				call =	con.prepareCall(ccCheck);	

				call.setString(1,strfacilityid);
				call.setString(2,strscashcountercode);
				call.setString(3,strslmttype);
				call.registerOutParameter(4,java.sql.Types.VARCHAR);				
				call.registerOutParameter(5,java.sql.Types.VARCHAR);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);
				call.registerOutParameter(7,java.sql.Types.VARCHAR);
				call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.execute();

				str_credit_card_machine_int_yn = call.getString(4);
				if(str_credit_card_machine_int_yn == null) str_credit_card_machine_int_yn="";

				str_credit_card_machine_id=call.getString(5);
				if(str_credit_card_machine_id == null) str_credit_card_machine_id="";

				str_err_code= call.getString(6);
				if(str_err_code == null) str_err_code="";

				str_error_text= call.getString(7);
				if(str_error_text == null) str_error_text="";

				str_sys_message_id = call.getString(8);
				if(str_sys_message_id == null) str_sys_message_id="";
				
				//Added by Monika Gupta for NMC-JD-CRF-0199
				boolean allowCCDataEditing = CommonBean.isSiteSpecific(con, "BL", "ALLOW_USER_TO_MODIFY_CC_DATA");
				System.out.println("Function control value for CC : "+allowCCDataEditing+" str_credit_card_machine_int_yn : "+str_credit_card_machine_int_yn);
				if(str_credit_card_machine_int_yn.equals("Y") && !allowCCDataEditing)
				{
					readonly_fld="readonly";
					disabled_fld="disabled";
					onlineapproval="checked";

				}
				
				call.close();
				//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019
				if(isDebugYN)
					System.out.println("***Inside Settlement Type 2 - Settlement Type Code "+strslmttype);

				String stdQuery = "select SEGMENT_ID, STANDARD_CODE from XH_STANDARD_CONTROL_SEG where ELEMENT_ID = 'SETTLEMENT_TYPE' and DEFAULT_VALUE = ? ";

				if (strslmttype.length() >0)
				{
					try{	
						pstmt = con.prepareStatement(stdQuery);						
						pstmt.setString(1, strslmttype);
						rs = pstmt.executeQuery() ;

						if( rs != null ) 
						{							
							while( rs.next() ) 
							{
								segment_id = rs.getString( "SEGMENT_ID" ) ;
								standard_code = rs.getString( "STANDARD_CODE" ) ;																
							}
						}
						if(rs != null) rs.close();
						pstmt.close();
					}
					catch(Exception ee)
					{
						System.out.println("***Inside Settlement Type 2 - Exception in checking the segment, standard code for the payemnt type... "+ee.getMessage());
					}
					
					if(isDebugYN)
						System.out.println("***Inside Settlement Type 2 - Settlement Type Code "+strslmttype+ " ***Segment ID... "+segment_id+" ***Standard Code... "+standard_code);

					if (segment_id.length()>0 && standard_code.length()>0)
					{
						stdQuery = "select DEFAULT_VALUE from XH_STANDARD_CONTROL_SEG where SEGMENT_ID = ? and ELEMENT_ID = 'CHECK_TRN_STATUS' and STANDARD_CODE = ? ";

						try{								
							pstmt = con.prepareStatement(stdQuery);
							
							pstmt.setString(1, segment_id);
							pstmt.setString(2, standard_code);
							rs = pstmt.executeQuery() ;

							if( rs != null ) 
							{							
								while( rs.next() ) 
								{
									slmt_check_status = rs.getString( "DEFAULT_VALUE" ) ;
								}
							}	
							
							
						}
						catch(Exception ee)
						{
							System.out.println("***Inside Settlement Type 2 - Exception in checking the payment type check status flag for the Payment Type... "+ee.getMessage());
						}							

					}
				}
				
				if(isDebugYN)
					System.out.println("***Inside Settlement Type 2 - Settlement Type Code "+strslmttype+ " ***Segment ID... "+segment_id+" ***Standard Code... "+standard_code+" ***Settlement Stattus Check... "+slmt_check_status);	

			}

		}
		catch(Exception ee)
		{
			System.out.println("***Inside Settlement Type 2 - Exception... "+ee);
		}
		
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}	
			if(rscurr != null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e) 
		{
			System.out.println("***Inside Settlement Type 2 - Exception in getting the Decimal places... "+e.toString());
		}

		//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic			
		ccAppletCount = 0;

		try {
			sqlStatement = "select count(*) applet_count from SM_FUNCTION_CONTROL a, sm_site_param b "
								+ "	where a.MODULE_ID = ? and a.FUNCTIONALITY_ID like '%CREDITCARD%' and a.SITE_ID = b.customer_id "
								+ "	and a.KEY_1 = ? AND VALUE_1 = 'Y' ";
			pstmt = con.prepareStatement(sqlStatement);
			pstmt.setString(1,"XH");
			pstmt.setString(2,strslmttype);

			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					ccAppletCount = rs2.getInt("applet_count");
				}
			}
			
			if(isDebugYN)
				System.out.println("***Inside Settlement Type 2 - Credit Card applet query... "+sqlStatement+" ***Applet Count... "+ccAppletCount);
		}
		catch (Exception e){
			System.out.println("***Inside Settlement Type 2 - Exception in fetching CC Applet "+e.getMessage() );
		}
		finally {
			if (rs2 != null)   rs2.close();
		}
		//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic
		
		//Added by Gopinath for ML-MMOH-CRF-1928.2 on 28/06/2023
		String stdQuery="";
		String enable_bank_name = "";
		String enable_payer_name = "";
		String enable_payer_refID = "";		
		if (segment_id.length()>0 && standard_code.length()>0)
		{
			//Credit Card Company Filed Enable Check
			stdQuery = "select DEFAULT_VALUE from XH_STANDARD_CONTROL_SEG where SEGMENT_ID = ? and ELEMENT_ID = 'ENABLE_BANK_NAME' and STANDARD_CODE = ? ";
			try{								
				pstmt = con.prepareStatement(stdQuery);
							
				pstmt.setString(1, segment_id);
				pstmt.setString(2, standard_code);
				rs = pstmt.executeQuery() ;

				if( rs != null ) 
				{							
					while( rs.next() ) 
					{
						enable_bank_name = rs.getString( "DEFAULT_VALUE" );
					}
				}	
				if(isDebugYN)
					System.out.println("***Inside Settlement Type 2 - checking the Enable Status for the Credit Card Company query... "+stdQuery+" ***enable_bank_name... "+enable_bank_name);
			}
			catch(Exception ee)
			{
				System.out.println("***Inside Settlement Type 2 - Exception in checking the Enable Status for the Credit Card Company... "+ee.getMessage());
			}
			
			//Payers Name Filed Enable Check
			stdQuery = "select DEFAULT_VALUE from XH_STANDARD_CONTROL_SEG where SEGMENT_ID = ? and ELEMENT_ID = 'ENABLE_PAYER_NAME' and STANDARD_CODE = ? ";
			try{								
				pstmt = con.prepareStatement(stdQuery);
							
				pstmt.setString(1, segment_id);
				pstmt.setString(2, standard_code);
				rs = pstmt.executeQuery() ;

				if( rs != null ) 
				{							
					while( rs.next() ) 
					{
						enable_payer_name = rs.getString( "DEFAULT_VALUE" );
					}
				}	
				if(isDebugYN)
					System.out.println("***Inside Settlement Type 2 - checking the Enable Status for the Payers Name query... "+stdQuery+" ***enable_payer_name... "+enable_payer_name);
			}
			catch(Exception ee)
			{
				System.out.println("***Inside Settlement Type 2 - Exception in checking the Enable Status for the Payers Name... "+ee.getMessage());
			}
			
			//Added by Gopinath for ML-MMOH-SCF-2508 on 09/08/2023
			//Payers Ref ID Filed Enable Check
			stdQuery = "select DEFAULT_VALUE from XH_STANDARD_CONTROL_SEG where SEGMENT_ID = ? and ELEMENT_ID = 'ENABLE_PAYER_REFID' and STANDARD_CODE = ? ";
			try{								
				pstmt = con.prepareStatement(stdQuery);
							
				pstmt.setString(1, segment_id);
				pstmt.setString(2, standard_code);
				rs = pstmt.executeQuery() ;

				if( rs != null ) 
				{							
					while( rs.next() ) 
					{
						enable_payer_refID = rs.getString( "DEFAULT_VALUE" );
					}
				}	
				if(isDebugYN)
					System.out.println("***Inside Settlement Type 2 - checking the Enable Status for the Payers Ref ID query... "+stdQuery+" ***enable_payer_refID... "+enable_payer_refID);
			}
			catch(Exception ee)
			{
				System.out.println("***Inside Settlement Type 2 - Exception in checking the Enable Status for the Payers Ref ID... "+ee.getMessage());
			}
			//Added by Gopinath for ML-MMOH-SCF-2508 on 09/08/2023
			finally 
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		
				ConnectionManager.returnConnection(con, request);
				
			}
		}
		//Added by Gopinath for ML-MMOH-CRF-1928.2 on 28/06/2023

            _bw.write(_wl_block12Bytes, _wl_block12);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15_0Bytes, _wl_block15_0);
            _bw.write(_wl_block15_1Bytes, _wl_block15_1);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(str_single_service_grp_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(str_acc_episode_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(str_acc_category_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(str_acc_serv_grp_used_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(str_service_grp));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(str_reln_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(str_single_service_grp_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(str_acc_episode_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(str_acc_category_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(str_acc_serv_grp_used_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(str_service_grp));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(str_reln_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(str_ext_dept_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block26_0Bytes, _wl_block26_0);
            _bw.write(_wl_block26_1Bytes, _wl_block26_1);
            _bw.write(_wl_block26_2Bytes, _wl_block26_2);

	if(action_ind.equals("remove"))
	{

            _bw.write(_wl_block27Bytes, _wl_block27);

	}
	else if(action_ind.equals("modify"))
	{

            _bw.write(_wl_block28Bytes, _wl_block28);

	}
	else
	{

            _bw.write(_wl_block29Bytes, _wl_block29);

	}

            _bw.write(_wl_block30Bytes, _wl_block30);

	if (ext_acc_interface_yn.equals("Y") && !cash_slmt_flag.equals(""))
	{

            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(str_receipt_type_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(str_receipt_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(str_ext_account_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(str_ext_account_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(str_ext_account_code));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(str_ext_dept_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_ext_dept_code));
            _bw.write(_wl_block41Bytes, _wl_block41);

	}
	
	if (cash_slmt_flag.equals("Y") || (siteCouponInSlmt && cash_slmt_flag.equals("D") && strcoupon_yn.equals("Y"))) //V210113
	{ 

            _bw.write(_wl_block42Bytes, _wl_block42);

				if(billslmtamtdetDb<0)
				{
					if(rec_ref.equals("F")){
				

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cash_given));
            _bw.write(_wl_block45Bytes, _wl_block45);

					}
					else{ 
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cash_given));
            _bw.write(_wl_block46Bytes, _wl_block46);
 	}}
				else
				{
					if(custId.equals("GP"))
					{
					
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cash_given));
            _bw.write(_wl_block47Bytes, _wl_block47);

					}else{
						if(rec_ref.equals("F")){
						
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(cash_given));
            _bw.write(_wl_block50Bytes, _wl_block50);
}else
						{ 
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
 if(siteCouponInSlmt && cash_slmt_flag.equals("D") && strcoupon_yn.equals("Y")) { 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(cash_given));
            _bw.write(_wl_block53Bytes, _wl_block53);
 } else { 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(cash_given));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
 	}						
				
						}
				}
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(cash_return));
            _bw.write(_wl_block58Bytes, _wl_block58);

			if(cashier_cheque_yn.equals("Y") && cash_slmt_flag.equals("Y"))
			{

            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(instref));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block62Bytes, _wl_block62);
if("Y".equals(credit_card_num_yn)){ 
            _bw.write(_wl_block63Bytes, _wl_block63);
} 
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(instdate));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disabled_fld));
            _bw.write(_wl_block68Bytes, _wl_block68);

		if(slmt_doc_ref_date_reqd_yn.equals("Y")==true )
		{
		
            _bw.write(_wl_block69Bytes, _wl_block69);
} 
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(temp_bank_credit));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disabled_fld));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(instbranch));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(p_instremarkcode));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(cash_slmt_flag));
            _bw.write(_wl_block79Bytes, _wl_block79);

			}

            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block84Bytes, _wl_block84);
 //V210113 start
				if(siteCouponInSlmt && cash_slmt_flag.equals("D") && strcoupon_yn.equals("Y")) {					
			
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(patMembershipID));
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
 //V210224 start
				if(action_ind.equals("modify") && !slmt_change.equals("Y"))
				{ 
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(couponAndAmts ));
            _bw.write(_wl_block90Bytes, _wl_block90);

				}else {
			
            _bw.write(_wl_block91Bytes, _wl_block91);
}  //V210224 end
			
            _bw.write(_wl_block92Bytes, _wl_block92);
 } else {  //V210113 end
			
            _bw.write(_wl_block93Bytes, _wl_block93);
 } 
            _bw.write(_wl_block94Bytes, _wl_block94);

	 }

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(str_ext_acc_facility_id));
            _bw.write(_wl_block97Bytes, _wl_block97);

	if(isDebugYN)
		System.out.println("***Inside Settlement Type 2 - Cash Settlement Flag : "+cash_slmt_flag+" ***Settlement Type... "+strslmttype+" ***Reference No... "+instref);

	if(!(cash_slmt_flag.equals("Y")) && (!(strApplicationID.equals("PAYTM"))) && (!(strApplicationID.equals("PAYSKY")))  && !(strcoupon_yn.equals("Y"))) //V210113
	{
		if(isDebugYN)
			System.out.println("***Inside Settlement Type 2 - INSIDE CREDIT CARD FUNCTION ");

            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(instref));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block101Bytes, _wl_block101);
if("Y".equals(credit_card_num_yn)){ 
            _bw.write(_wl_block102Bytes, _wl_block102);
} 
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(instdate));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disabled_fld));
            _bw.write(_wl_block105Bytes, _wl_block105);

		if(slmt_doc_ref_date_reqd_yn.equals("Y")==true )
		{
		
            _bw.write(_wl_block69Bytes, _wl_block69);

		} 
		//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	

		if (ccAppletCount>0)
		{
			if(isDebugYN)
				System.out.println("***Inside Settlement Type 2 - Inside Credit Card Applet.... ");
			
		
            _bw.write(_wl_block106Bytes, _wl_block106);
			
		}	

		
            _bw.write(_wl_block107Bytes, _wl_block107);
 
			if ( cash_slmt_flag.equals("A"))
			{

            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
 
			}
			else 
			{

            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

			}

            _bw.write(_wl_block111Bytes, _wl_block111);
 
			//Added by Gopinath for ML-MMOH-CRF-1928.2 on 28/06/2023 - Credit Card Company Enale Checking
			if(enable_bank_name.equals("Y")){

            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(temp_bank_credit));
            _bw.write(_wl_block113Bytes, _wl_block113);
 
			} else {

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(temp_bank_credit));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disabled_fld));
            _bw.write(_wl_block115Bytes, _wl_block115);
			
			}
			//Added by Gopinath for ML-MMOH-CRF-1928.2 on 28/06/2023 - Credit Card Company Enale Checking
			
			
//				if ( cash_slmt_flag.equals("A") || cash_slmt_flag.equals("B") )
				if(!"Y".equals(cash_slmt_flag) && "Y".equals(credit_card_co_yn))
				{

            _bw.write(_wl_block116Bytes, _wl_block116);

				}	

            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(instbranch));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(p_instremarkcode));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
 
			//added against ML-MMOH-SCF-1576
			if (cash_slmt_flag.equals("A") || cash_slmt_flag.equals("D"))
			{

            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(onlineapproval));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(disabled_fld));
            _bw.write(_wl_block122Bytes, _wl_block122);

			}
			else
			{

            _bw.write(_wl_block123Bytes, _wl_block123);

			}
		     //added against ML-MMOH-SCF-1576
			if ( cash_slmt_flag.equals("A") || cash_slmt_flag.equals("D")) 
			{

            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(batchno));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block127Bytes, _wl_block127);
if("Y".equals(batch_no_reqd_yn)){	 
            _bw.write(_wl_block128Bytes, _wl_block128);
} 
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(apprrefno));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block115Bytes, _wl_block115);
 
		  }
		else		 
		{	

            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(batchno));
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);

	//added against ML-MMOH-SCF-1576
	if ( cash_slmt_flag.equals("D")) 
	{
	
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(apprrefno));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block136Bytes, _wl_block136);
 } else {
	
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(apprrefno));
            _bw.write(_wl_block138Bytes, _wl_block138);

	}
	
            _bw.write(_wl_block139Bytes, _wl_block139);

		}

		if ( cash_slmt_flag.equals("A"))
		if("A".equals(cash_slmt_flag) && "Y".equals(approval_code_yn))	//Modified by Rajesh V
			{

            _bw.write(_wl_block140Bytes, _wl_block140);

			}

            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
 
		//added against ML-MMOH-SCF-1576
		if ( cash_slmt_flag.equals("A") || cash_slmt_flag.equals("D")) 
		{

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(saledraftno));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block115Bytes, _wl_block115);

		}
		else
		{

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(saledraftno));
            _bw.write(_wl_block144Bytes, _wl_block144);
 
		}	

		if (cash_slmt_flag.equals("A") && sale_draft_reqd_yn.equals("Y")) 
		{

            _bw.write(_wl_block145Bytes, _wl_block145);

		}

            _bw.write(_wl_block146Bytes, _wl_block146);
		if(action_ind.equals("modify"))
		{

            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block149Bytes, _wl_block149);
 
				if ( cash_slmt_flag.equals("B")==true &&  payer_name_reqd_yn.equals("Y")==true )
				{
	
            _bw.write(_wl_block150Bytes, _wl_block150);

				}

            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block153Bytes, _wl_block153);
 
				if ( "Y".equals(payer_ref_reqd_yn)==true )
				{
		
            _bw.write(_wl_block154Bytes, _wl_block154);

				}
		
            _bw.write(_wl_block155Bytes, _wl_block155);

			}
		else{

            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);
 
		//Added by Gopinath for ML-MMOH-CRF-1928.2 on 28/06/2023 - Payer Name Enable Checking
		if(enable_payer_name.equals("Y")){

            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block159Bytes, _wl_block159);
 
		} else {

            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block115Bytes, _wl_block115);

		}
		//Added by Gopinath for ML-MMOH-CRF-1928.2 on 28/06/2023 - Payer Name Enable Checking


		//	if ( cash_slmt_flag.equals("B"))
			

            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
 
		//Added by Gopinath for ML-MMOH-SCF-2508 on 09/08/2023 - Payer Ref ID Enable Checking
		if(enable_payer_refID.equals("Y")){

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block164Bytes, _wl_block164);
 
		} else {

            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block115Bytes, _wl_block115);

		}
		//Added by Gopinath for ML-MMOH-SCF-2508 on 09/08/2023 - Payer Ref ID Enable Checking
		
		
			if ( "Y".equals(payer_ref_reqd_yn)==true )
			{
	
            _bw.write(_wl_block166Bytes, _wl_block166);

			}
			
	
            _bw.write(_wl_block167Bytes, _wl_block167);
	
		}

            _bw.write(_wl_block168Bytes, _wl_block168);
 if ( cash_slmt_flag.equals("A") && cc_terminal_id_enable){ 
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
		if(action_ind.equals("modify"))
						{
				
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(cc_term_id_num));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block173Bytes, _wl_block173);
 		}else { 
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(strTermIdentNo));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block174Bytes, _wl_block174);
 		} 
            _bw.write(_wl_block175Bytes, _wl_block175);
 
			if ( "Y".equals(terminal_id_reqd_yn)==true )
			{
	
            _bw.write(_wl_block166Bytes, _wl_block166);

			}	
	
            _bw.write(_wl_block176Bytes, _wl_block176);
 } else{ 
            _bw.write(_wl_block177Bytes, _wl_block177);
 } 
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(cash_slmt_flag));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(cash_slmt_flag));
            _bw.write(_wl_block180Bytes, _wl_block180);
 	


	}	
	//Added by Sethu for GHL-CRF-0415 on 18/04/2017
	if(!(cash_slmt_flag.equals("Y")) && ((strApplicationID.equals("PAYTM"))))
	{

            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(instref));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(instref));
            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(batchno));
            _bw.write(_wl_block191Bytes, _wl_block191);

					if(str_credit_card_machine_int_yn.equals("Y"))
					{
					
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYTM_PAY.label","bl_labels")));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(readonly1));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYTM_CHECK_STATUS.label","bl_labels")));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(readonly1));
            _bw.write(_wl_block196Bytes, _wl_block196);

					}
					else
					{
					
            _bw.write(_wl_block197Bytes, _wl_block197);

					}
					
            _bw.write(_wl_block198Bytes, _wl_block198);
 

					if ( strslmtidno.length() > 0 )
						readonly_fld="readonly";
					else
						readonly_fld="";
					
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(apprrefno));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block201Bytes, _wl_block201);
 

						if ( "Y".equals(payer_ref_reqd_yn)==true )
						{
						
            _bw.write(_wl_block202Bytes, _wl_block202);

						}
						
            _bw.write(_wl_block203Bytes, _wl_block203);
 

					if ( strslmtidno.length() > 0 )
					{
						readonly_fld="readonly";
						disabled_fld="disabled";
					}
					else
					{
						readonly_fld="";
						disabled_fld="";
					}
					
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(instdate));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(disabled_fld));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(disabled_fld));
            _bw.write(_wl_block207Bytes, _wl_block207);

					if(slmt_doc_ref_date_reqd_yn.equals("Y")==true )
					{
					
            _bw.write(_wl_block208Bytes, _wl_block208);
} 
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);
 
					if ( cash_slmt_flag.equals("A") )
					{
			
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(saledraftno));
            _bw.write(_wl_block212Bytes, _wl_block212);

					}
					else
					{
			
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(saledraftno));
            _bw.write(_wl_block212Bytes, _wl_block212);
 
					}					
			
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(cash_slmt_flag));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(cash_slmt_flag));
            _bw.write(_wl_block216Bytes, _wl_block216);
 

	}	
	//Added by Sethu for GHL-CRF-0415 on 18/04/2017 -- Ends here.

	if(isDebugYN)
		System.out.println("***Inside Settlement Type 2 - Cash Settlement Flag : "+cash_slmt_flag+" ***Settlement Type... "+strslmttype+" ***Interface_YN... "+str_credit_card_machine_int_yn);

	//Added by Sethu for MOHE-CRF-0076 on 01/08/2021
	if(!(cash_slmt_flag.equals("Y")) && ((strApplicationID.equals("PAYSKY"))))
	{

            _bw.write(_wl_block217Bytes, _wl_block217);

			if(isDebugYN)
				System.out.println("***Inside Settlement Type 2 - ***Interface_YN... "+str_credit_card_machine_int_yn);

			if(str_credit_card_machine_int_yn.equals("Y"))
			{
				if(isDebugYN)
					System.out.println("***Inside Settlement Type 2 - ***Interface_YN... Inside YES ***********");
			
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYSKY_PAY.label","bl_labels")));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(readonly1));
            _bw.write(_wl_block220Bytes, _wl_block220);

			}
			else
			{
				if(isDebugYN)
					System.out.println("***Inside Settlement Type 2 - ***Interface_YN... Inside No ***********");
			
            _bw.write(_wl_block221Bytes, _wl_block221);

			}
			
            _bw.write(_wl_block222Bytes, _wl_block222);
 
				if ( strslmtidno.length() > 0 )
					readonly_fld="readonly";
				else
					readonly_fld="";
				
            _bw.write(_wl_block223Bytes, _wl_block223);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(apprrefno));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(readonly_fld));
            _bw.write(_wl_block207Bytes, _wl_block207);
 
					if ( "Y".equals(payer_ref_reqd_yn)==true )
					{
					
            _bw.write(_wl_block225Bytes, _wl_block225);

					}
					
            _bw.write(_wl_block226Bytes, _wl_block226);
 
				if ( strslmtidno.length() > 0 )
				{
					readonly_fld="readonly";
					disabled_fld="disabled";
				}
				else
				{
					readonly_fld="";
					disabled_fld="";
				}
				
            _bw.write(_wl_block227Bytes, _wl_block227);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(instdate));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(disabled_fld));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(disabled_fld));
            _bw.write(_wl_block173Bytes, _wl_block173);

				if(slmt_doc_ref_date_reqd_yn.equals("Y")==true )
				{
				
            _bw.write(_wl_block229Bytes, _wl_block229);
} 
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);
 
				if ( cash_slmt_flag.equals("A") )
				{
		
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(saledraftno));
            _bw.write(_wl_block233Bytes, _wl_block233);

				}
				else
				{
		
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(saledraftno));
            _bw.write(_wl_block233Bytes, _wl_block233);
 
				}					
		
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(cash_slmt_flag));
            _bw.write(_wl_block236Bytes, _wl_block236);
 
		}	
	
	}catch(Exception e )
		{
			//out.println(e);
			System.out.println("main :"+e);
		} 
		finally
		{
			if (rs21 != null)   rs21.close();			
			if(stmt != null)stmt.close();
			ConnectionManager.returnConnection(con, request);
		}		 

            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(str_credit_card_machine_int_yn));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(cashier_cheque_yn));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(sale_draft_reqd_yn));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(payer_name_reqd_yn));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(payer_ref_reqd_yn));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(credit_card_num_yn));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(credit_card_co_yn));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(approval_code_yn));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(credit_card_check_yn));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(terminal_id_reqd_yn));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(cc_terminal_id_enable));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(batch_no_reqd_yn));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(slmt_doc_ref_date_reqd_yn));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(rec_ref));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(chequeCategorize));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(chequeLengthChange));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(strslmttype));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(instdate));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(strApplicationID));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(strClientIpAddress));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(action_ind));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(slmt_check_status));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(strcoupon_yn));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(patMembershipID));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(siteCouponInSlmt));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(couponAndAmts ));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(coupons ));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(coupons ));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(segment_id));
            _bw.write(_wl_block274Bytes, _wl_block274);
            _bw.write(_wl_block275Bytes, _wl_block275);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CHQ_CARD_BANK_NO_OTH.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECEIPT_TYPE.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ACCOUNT_CODE.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.department.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_REFUNDED.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_REFUNDED.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AMOUNT_REND.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_REFUNDED.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_GIVEN.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_RETURNED.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CHQ_CARD_BANK_NO.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BANK_NAME.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BRANCH_NAME.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_NAME.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_DEP_REF_NO.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MembershipID.Label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CouponCode.Label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CHQ_CARD_BANK_NO.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_CARD_CO.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BANK_NAME.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BRANCH_NAME.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ONLINE_APPROVAL.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchNo.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVAL_CODE.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchNo.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVAL_CODE.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SALE_DRAFT_NO.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_NAME.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_DEP_REF_NO.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_NAME.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_DEP_REF_NO.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TID_NO.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_PAYBY_OPTION.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_PAYBY_BARCODE.label", java.lang.String .class,"key"));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_PAYBY_TOTP.label", java.lang.String .class,"key"));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_USER_CODE.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_PHONE_NO.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_OTP.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_PROMO_CODE.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_TXN_NO.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_ORDER_NO.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYSKY_TXN_NO.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYTM_ORDER_NO.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }
}
