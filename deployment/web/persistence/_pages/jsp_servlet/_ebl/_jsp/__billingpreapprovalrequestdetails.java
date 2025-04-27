package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import eBL.PreApprovalRequestDetailsBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __billingpreapprovalrequestdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillingPreApprovalRequestDetails.jsp", 1743570992049L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No              Version                Incident              SCF/CRF                        Developer Name\n1                  V201013                IN73702            NMC-JD-CRF-0042.1         \t\t\tShikha Seth\n2                  V201024                IN73702            NMC-JD-CRF-0042.1         \t\t\tShikha Seth\n3\t      \t       V220324\t       \t      27973\t             MMS-ME-SCF-0046-TF\t\t\t        Mohana Priya K\n4           \t   V220627                31872      \t     NMC-JD-CRF-0170 US001              Mohanapriya K\n5\t\t\t\t   V220905\t\t\t\t  33891\t\t         TH-KW-CRF-0093                     Mohanapriya K\n6\t\t\t\t\tV221025\t\t\t\t \t\t\t\t\tTH-KW-CRF-0020.7\t\t\t\t\tMohanapriya\n7\t\t\t\t  V221216\t\t\t\t37915\t\t\t\tTH-KW-CRF-0084.1\t\t\t\t\tMohanapriya\n8\t\t\t\t  V230102\t\t\t\t\t\t\t\tTH-KW-CRF-0084\t\t\t\t\tMohanapriya\n9\t\t\t\tV230608\t\t\t\t\t\t\tMMS-KH-SCF-0199 \t\t\tMohanapriya\n10\t\t\t\t V230830\t\t\t\t\t\t\tNMC-JD-CRF-0102.2\t\t\tMohanapriya\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n<html>\n<head>\n<style>\n\t.billApproved{\n\t\twidth: 12.5px;\n\t\theight: 12.5px;\n\t\tbackground: red;\n\t}\n</style>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\t\n<script language=\"JavaScript\" src=\"../../eBL/js/BillingRecordApprovalScript.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\nvar ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\nvar PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\nvar PAYER_LOOKUP_RECORD_PREAPPROVAL\t\t\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\t\nvar POLICY_LOOKUP_RECORD_PREAPPROVAL\t\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\t\nvar PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\nvar PRE_APPROVAL_REQUEST_BILLINGSERVICECODE_LOOKUP\t\t\t=\t\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\nvar headTop = -1;\nvar FloatHead1;\nfunction processScroll()\n{\n\tif (headTop < 0)\n\t{\n\t\tsaveHeadPos();\t\t\t\n\t}\n\tif (headTop>0)\n\t{\n\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\ttheTop = document.documentElement.scrollTop;\n\t\telse if (document.body)\n\t\t\ttheTop = document.body.scrollTop;\n\n\t\tif (theTop>headTop)\n\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\telse\n\t\t\tFloatHead1.style.top = \'0px\';\n\t}\n}\n\nfunction saveHeadPos()\n{\n\tparTable = document.getElementById(\"divHeadSep\");\n\tif (parTable != null)\n\t{\n\t\theadTop = parTable.offsetTop + 3;\n\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\tFloatHead1.style.position = \"relative\";\n\t}\n}\n\t\nfunction lockKey()\n  {\t\t \t \n\tif(event.keyCode == 93)\n\t\talert(\"Welcome to eHIS\");\n  }\n\nfunction lockbackSpace()\n{\n\t// alert(document.order_type_form.mode.value);\n\tvar mode = document.mode.value;\n\t// alert(window.event.keyCode);\n\tif(mode==\'modify\' && window.event.keyCode==8)\n\t{\n\t//return false;\n\t}\n}\t\n\t\nfunction callFunction(index)\n{\n\t\t   \n/*    alert(\'index \'+index);\n   alert($(\'#approval_status\'+index).val());\n */   \n   var approval_status=$(\'#approval_status\'+index).val();\n\t\t   \n   $(\'#approvalstatus_hdn\').val(approval_status);  \n}\t   \n\t   \nfunction isNegativeCheck(event)\n{\n   if ( event.which == 45 || event.which == 189 ) {\n\t   return false;  \n\t   // event.preventDefault();\n\t   }\n\t\t   \n}\n\t   \n\t \nfunction isNumberEvent(evt,index,calledFrom)\n{\n\t\t  \n\t\t   \n   var qty = $(\'#approvedQty\'+index).val();\n   var amount =$(\'#approvedAmount\'+index).val();\n\t\t   \n   if(calledFrom==\'approvedQty\')\n   {\n   \t\tif (  qty <= 0 || qty >= 0) {\n\t\t       \n    \t\t\t\t\t\t\t\t}\n    \telse {\n        \tif ( qty.length > 0 ) {\n\n            alert(getMessage(\"NUM_ALLOWED\", \"SM\"));\n            $(\'#approvedQty\'+index).val(\'\');\n            return false;\n        \t\t\t\t\t\t\t}\n    \t\t }\n\t\t \n   }\n   else if(calledFrom==\'approvedAmount\')\n\t{\n\t\t\t\t\n\t   if (  amount <= 0 || amount >= 0) {\n\t\t\t       \n\t\t}\n\telse {\n\t\t\t\n\t\tif ( amount.length > 0 ) \n\t\t{\n\t\talert(getMessage(\"NUM_ALLOWED\", \"SM\"));\n\t\t$(\'#approvedAmount\'+index).val(\'\');\n\t\treturn false;\n\t\t}\n\t\t}\n\t}\n}   \n\t   \n async function authorize_check(index)\n {\n\tvar order_status= $(\'#order_status\'+index).val();\n\torder_status=$.trim(order_status);\t\t\n\tvar approval_stats= $(\'#approval_status\'+index).val();\n\tvar checkfor_authorise=$(\'#authorise_check\').val();\n\tvar authorisecheckforbilled=$(\'#authorise_check_billed\').val();\n\t//alert(\"authorisecheckforbilled \"+authorisecheckforbilled);\n\tvar approvalstatus_hdn=$(\'#approvalstatus_hdn\'+index).val();\n\t\t\n\tvar called_from=\'\';\n\tvar user_id=$(\'#user_id\').val();\n\tvar approvalstatus_hdn=$(\'#approvalstatus_hdn\').val();\n\tvar site_spec_approval_sts_hdr =$(\'#site_spec_approval_sts\').val();  // Added V190326-Dhananjay/MMS-DM-SCF-0612\n\tif((approvalstatus_hdn==\'A\' && site_spec_approval_sts_hdr == \'N\') || (site_spec_approval_sts_hdr == \'Y\')) // Added V190326-Dhananjay/MMS-DM-SCF-0612\n\t{\n\tif(order_status==\"Billed\" && approval_stats!=approvalstatus_hdn)\n\t{\n\t\t\n\t\tif(authorisecheckforbilled==\'N\')\n\t\t{\n\t\t\n\t\t\tcalled_from=\'Billed\'\n\t\t\tvar authcheck= await doUserAuthenticationValidation(user_id,called_from)\n\t\t\t//alert(\'authcheck \'+authcheck);\n\t\t\tif(authcheck==false)\n\t\t\t{\n\t\t\tvar dialogHeight= \"14\" ;\n\t\t\tvar dialogWidth\t= \"22\" ;\n\t\t\tvar dialogTop = \"225\" ;\n\t\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\t\t\n\t\t\tvar url=\"../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?called_frm=EBL_TRANS_INS_RECORD_APPROVAL&loggeduser=\"+user_id;\n\t\t\t\t\n\t\t\tvar retVal =await window.showModalDialog(url,arguments,features);\n\t\t\tif(retVal!=undefined)\n\t\t\t{\n\t\t\t\n\t\t\tvar successUser=$.trim(retVal[0]);\n\t\t\tvar success=$.trim(retVal[1]);\n\t\t/* \t\n\t\t\talert(\"successUser \"+successUser);\n\t\t\talert(\"success \"+success);\n\t\t */\t if(successUser==\'SuccessfulUser\' && success==\'Y\')\n\t\t\t\t{\n\t\t\t$(\'#authorise_check_billed\').val(\'Y\');\n\t\t\t\t}\n\t\t\t\t\n\t\t\telse\n\t\t\t\t{\n\t\t\t\t$(\'#authorise_check_billed\').val(\'N\');\t\n\t\t\t\t$(\'#approval_status\'+index).val(approvalstatus_hdn);\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t$(\'#authorise_check_billed\').val(\'N\');\t\n\t\t\t\t\t$(\'#approval_status\'+index).val(approvalstatus_hdn);\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\n\t\t\t}\t\t\t\n\t\t}\n\t\t}\t\t\n }\t \n\t \nfunction doUserAuthenticationValidation(successfulUser,calledFrom) {\n\tvar retVal=\"\";\t\n\t$.ajax({\n\t\ttype:\"POST\",\n\t\turl:\"../jsp/UserAuthenticationPayerPolicyValidation.jsp\",\n\t\tdata:\"successfulUser=\"+successfulUser+\"&calledFromPage=\"+calledFrom,\n\t\tdataType:\"text\",\n\t\tasync:false,\n\t\tsuccess: function(data){\n\t\t\t//alert(data)\n\t\t\tretVal = $.trim(data);\n\t\t\t//alert(retval);\n\t\t},\n\t\t error: function(data){\n\t\t\t //alert(data)\n\t     }\n\t});\n\t\n\t//alert(\"retVal$$$$ \"+retVal);\n\tif(retVal.indexOf(\'@@@SUCCESS@@@\')==-1){ //If success string is not found return false\n\t\treturn false;\n\t}else{\t\t\n\t\treturn true;\t\n\t}\n}\n</script>\n</head>\n<style>\n\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 160px; \t/* must be greater than tbody*/\n\t\toverflow: auto;\n\t\tmargin: 0 auto;\n\t}\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\t\t\n</style>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<body onScroll=\"processScroll()\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"    ; onSelect=\"codeArrestThruSelect();\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<form id=\"BillingPreApprovalRequestDetailsForm\" name=\"BillingPreApprovalRequestDetailsForm\" id=\"BillingPreApprovalRequestDetailsForm\" enctype=\"multipart/form-data\" >\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<form id=\"BillingPreApprovalRequestDetailsForm\" name=\"BillingPreApprovalRequestDetailsForm\" id=\"BillingPreApprovalRequestDetailsForm\" >\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t<table align=\'center\'  cellpadding=2 cellspacing=0  width=\'100%\' id=\"record_approval_details_table\" name=\"record_approval_details_table\" id=\"record_approval_details_table\" border=\"1\">\t\t \n\t<div id=\"tableContainer\">\n\t<thead style=\"position: sticky;z-index: 1;top: 0;\">\n\t<tr>\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\'\tnowrap\twidth=\"3%\"\talign=\"left\">Status</th>\n<!-- \t\t\t\t\t\t<th class=\'CAFLOWSHEETLEVEL1\'\tnowrap\twidth=\"3%\"\talign=\"left\">test</th>\n -->\t \t\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t \n \t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap  width=\"3%\"  align=\"left\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \t\t\n\t \t\t<th class=\'CAFLOWSHEETLEVEL1\'\tnowrap\twidth=\"9%\"\talign=\"left\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"7%\" \talign=\"left\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"7%\" \talign=\"left\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\t\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>  \n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"8%\" \talign=\"left\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"6%\" \talign=\"left\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<!--V220905-->\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"6%\" \talign=\"left\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"5%\" \talign=\"left\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"6%\" \talign=\"left\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</th>  \n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"7%\" \talign=\"left\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</th>\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"4%\" \talign=\"left\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</th>\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"3%\" \talign=\"left\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</th>\n\t\t\t<!-- NMC-JD-CRF-0102.2-->\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"3%\" \talign=\"left\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</th>\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td nowrap=\"nowrap\">\n\t\t&nbsp;\n\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<td>\n\t\t\n\t\t<input type=\'text\' name=\'encounterIdFilter\' id=\'encounterIdFilter\' id=\'encounterIdFilter\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<td  nowrap>\n\t\t\t\t\t<select name=\'criteriaFilter\' id=\'criteriaFilter\' style=\"width: 120px;\">\t\t\n\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' selected>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t</select>\n\t\t</td>\n\t\t<td  nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'bg_code_filter\' name=\'bg_code_filter\' id=\'bg_code_filter\' size=\'10\'   value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' onblur=\"if(this.value!=\'\'){ callBGDescCode(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_desc_filter); } \" >\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'bg_desc_filter\' name=\'bg_desc_filter\' id=\'bg_desc_filter\'  size=\'10\'  value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' onblur=\"if(this.value!=\'\'){ callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_code_filter); }\">\n\t\t\t<input type=\'button\' id=\'bg_but_filter\' value=\'?\'  onclick=\'callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter)\' >\t\t\t\t\t\n\t\t\t\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'serviceDate_filter\' name=\'serviceDate_filter\' id=\'serviceDate_filter\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' size=\'8\' onblur=\'isValidDate(this);\'>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'serviceDate_ctrl_filter\' onClick=\'return showCalendar(\"serviceDate_filter\")\' />\n\t\t\t\n\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t<td nowrap align=\"left\">\n\t\t \t<input type=\'text\' id=\'orderStatusFilter\' name=\'orderStatusFilter\' id=\'orderStatusFilter\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' size=\'8\' onblur=\'\'>\n\t\t\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'serviceAmount_filter\' name=\'serviceAmount_filter\' id=\'serviceAmount_filter\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'serviceQuantity_filter\' name=\'serviceQuantity_filter\' id=\'serviceQuantity_filter\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprReqDate_filter\' name=\'apprReqDate_filter\' id=\'apprReqDate_filter\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' size=\'8\' onblur=\'isValidDate(this);\'>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'apprReqDate_ctrl_filter\' onClick=\'return showCalendar(\"apprReqDate_filter\")\' />\t\t\t\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprGvnDate_filter\' name=\'apprGvnDate_filter\' id=\'apprGvnDate_filter\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' size=\'8\' onblur=\'isValidDate(this);\'>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'apprGvnDate_ctrl_filter\' onClick=\'return showCalendar(\"apprGvnDate_filter\")\' />\t\t\t\t\t\t\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'MCN_no\' name=\'MCN_no\' id=\'MCN_no\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' onkeypress=\'return CheckForSpecChars_loc(event,this)\'  onBlur=\'CheckForSpecChar(event,this)\' size=\'10\' maxlength=\'50\' >\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<!--V220905-->\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprNo_filter\' name=\'apprNo_filter\' id=\'apprNo_filter\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap>\n\t\t\t<select id=\"approval_status_filter\"\tname=\"approval_status_filter\" id=\"approval_status_filter\" style=\"width: 60px;\">\n\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</option>\n\t\t\t\t<option value=\"A\"  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" >Approved</option>\n\t\t\t\t<option value=\"R\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" >Rejected</option>\n\t\t\t\t<option value=\"P\" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" >Pending</option>\n\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" >Send to Insurance</option>\n\t\t\t\t<option value=\"H\" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" >Hold</option>\n\t\t\t\t<option value=\"C\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" >Clarification</option>\t\t\t\t\n\t\t\t</select>\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprQty_filter\' name=\'apprQty_filter\' id=\'apprQty_filter\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprAmt_filter\' name=\'apprAmt_filter\' id=\'apprAmt_filter\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap>\n\t\t\t<input type=\'text\' id=\'reason_filter\' name=\'reason_filter\' id=\'reason_filter\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' size=\'10\' >\n\t\t\t<input type=\'hidden\' id=\'reason_hdn_filter\' name=\'reason_hdn_filter\' id=\'reason_hdn_filter\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' >\n\t\t\t&nbsp;\n\t\t\t<input type=\'button\' class=\'button\' name=\"reason_lookup_filter\" id=\"reason_lookup_filter\" id=\"reason_lookup_filter\" value=\'?\' onClick=\"reasonCodeLookupFilter(reason_filter,reason_hdn_filter)\" \t/>\n\t\t\t\n\t\t</td>\n\t\t<td nowrap>\n\t\t\t<input type=\'text\' id=\'remarks_filter\' name=\'remarks_filter\' id=\'remarks_filter\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' size=\'10\' >\n\t\t</td>\n\t</tr>\n\t</thead>\n\t\n\t<TBODY style=\"height: 20px;\">\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t<tr> \n\t\t\t\t<td nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t<span class=\'billApproved\'></span>\n\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t \t<td nowrap class=\"fields\" \twidth=\"10%\"\t><input type=\"text\" name=\"encounter_id";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"encounter_id";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"  title=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" \t\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" size=\"15\"  readonly /></td>\n\t\t\t\t  ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t<td  nowrap class=\"fields\" \twidth=\"10%\"\t\t><select id=\"included_excluded";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"\t\t\t\t\t\t\tname=\"included_excluded";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"\t\t\tstyle=\"width: 120px;\"\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="  ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" > <option value=";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</option></select></td>\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td nowrap class=\"fields\"\twidth=\"7%\" \t\t>\t\t\t\t\n\t\t\t\t<input type=\"hidden\"\tid=\"billing_service_code";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"\t\t\t\tname=\"billing_service_code";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"\t\ttitle=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"  />\n\t\t\t\t<input type=\"text\"\tid=\"billing_service_display";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"\t\t\t\tname=\"billing_service_display";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" size=\"10\"\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" />\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t \n\t\t\t\t<td nowrap class=\"fields\"\twidth=\"7%\" \t\t><input type=\"text\" id=\"billing_service_desc";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"\tname=\"billing_service_desc";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" \t\ttitle=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" size=\"11\"\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" /></td>\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"8%\"\t\t><input type=\"text\" id=\"service_date";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"\t\t\t\t\t\tname=\"service_date";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"\t\t  \t\ttitle=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" size=\"7\"\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" /><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'service_date";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\');\"  onKeyPress=\"return lockbackSpace();\"\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="  name=\"service_date_cal";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"service_date_cal";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"></td> \n\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"8%\"\t\t><input type=\"text\" id=\"order_status";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"\t\t\t\t\t\tname=\"order_status";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" /></td> \t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"7%\"\t\t><input type=\"text\" id=\"available_service_amount";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"\t\t\tname=\"available_service_amount";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"\ttitle=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\t /></td>\n\t\t\t\t <td nowrap class=\"fields\" \twidth=\"7%\"\t\t><input type=\"text\" id=\"available_service_qty";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"\t\t\tname=\"available_service_qty";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\t /></td>\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"8%\"\t\t><input type=\"hidden\" name=\"p_app_req_date";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"p_app_req_date";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"  value =\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" ><input type=\"text\" id=\"app_req_date";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\"\t name=\"app_req_date";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"\t\t\t\ttitle=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" onblur=\"CopyValue(\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\');\"\t\tonchange=\"CopyValue(\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\')\"   /><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'app_req_date";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\');\" name=\"approved_req_cal";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"approved_req_cal";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" onKeyPress=\"return lockbackSpace();\"  ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\tonClick=\"CopyValue(\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\');\" ></td>\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"8%\"\t\t><input type=\"hidden\" name=\"p_approved_date";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" id=\"p_approved_date";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"><input type=\"text\" id=\"approved_date";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"\t\t\t\t\tname=\"approved_date";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\t\tonblur=\"CopyValue(\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\');\"       onchange=\"CopyValue(\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\')\"   /><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'approved_date";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\');\" name=\"approved_given_cal";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" id=\"approved_given_cal";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\');\" ></td>\n\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t<td nowrap class=\"fields\" \twidth=\"6%\"\t\t><input type=\"hidden\" name=\"p_MCN_number";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"p_MCN_number";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"> \n\t\t\t\t\t<input type=\"text\" id=\"MCN_number";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"\t\t\t\t\tname=\"MCN_number";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"\t\t\ttitle=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" size=\"10\"  ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\t \tonkeypress=\'return CheckForSpecChars_loc(event,this)\' onchange=\"checkMCNsts(\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\');CopyData(\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\')\"  onBlur=\'CheckForSpecChar(event,this)\' maxlength=\"50\" /></td><!--V220905-->\n\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"6%\"\t\t><input type=\"hidden\" name=\"p_approval_number";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" id=\"p_approval_number";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t\t<input type=\"text\" id=\"approval_number";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"\t\t\t\t\tname=\"approval_number";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\t \tonchange=\"CopyValue(\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\')\"  maxlength=\"20\" /></td>\n\t\t\t\t\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"5%\"\t\t>\n\t\t\t\t<input type=\"hidden\" name=\"p_approval_status";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" id=\"p_approval_status";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t\t\t\t<select id=\"approval_status";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"\t\t\t\t\t\t\tname=\"approval_status";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"\t\t\tstyle=\"width: 60px;\"\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="    onFocus=\"callFunction(\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\')\";      onchange=\"defaultGivenDate(\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\');CopyValue(\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\');  authorize_check(\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'); isChanged(this,\'apprSts\',\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'); ckckStatus(\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\');\"> <!--V220627-->\n\t\t\t\t<option ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =" value=\"A\" ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" >Approved</option>\n\t\t\t\t<option ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =" value=\"R\" ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =" >Rejected</option>\n\t\t\t\t<option ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =" value=\"P\"  ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =" >Pending</option>\n\t\t\t\t<option ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" value=\"S\" ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =" >Send to Insurance</option>\n\t\t\t\t<option ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =" value=\"H\" ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" >Hold</option>\n\t\t\t\t<option ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =" value=\"C\" ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 =" >Clarification</option>\t\t\t\t\n\t\t\t\t</select>\n\t\t\t \t<input type=\"hidden\" name=\"approvalstatus_hdn";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" id=\"approvalstatus_hdn";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'prevSts";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\' id=\'prevSts";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'\tid=\'prevSts";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'\t value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" ><!-- V221129 -->\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"6%\"\t\t><input type=\"hidden\" name=\"p_approvedQty";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" id=\"p_approvedQty";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"><input type=\"text\" id=\"approvedQty";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\"\t\t\t\t\tname=\"approvedQty";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\t\tonchange=\"CopyValue(\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\')\"  onBlur=\"isNumberEvent(event,\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\',\'approvedQty\');isChanged(this,\'apprQty\',\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\');\"   onkeypress=\"return isNegativeCheck(event);\" /></td><!--V220627-->\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"7%\"\t\t><input type=\"hidden\" name=\"p_approvedAmount";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" id=\"p_approvedAmount";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\"><input type=\"text\" id=\"approvedAmount";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\"\t\t\t\t\tname=\"approvedAmount";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\',\'approvedAmount\');isChanged(this,\'apprAmt\',\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\');\"  onkeypress=\"\"  /></td>\t\t\t<!--V220627-->\t \n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"7%\"\t\t><input type=\"hidden\" name=\"p_reason";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" id=\"p_reason";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\"><input type=\"text\" id=\"reason";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\"\t\t\t\t\t\t\tname=\"reason";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\"\t\t\t\t\t\ttitle=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" size=\"5\"\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\')\"   /><input type=\'button\' class=\'button\' name=\"reason_lookup";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" id=\"reason_lookup";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" value=\'?\' onClick=\"return reasonCodeLookup(\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\')\"  tabindex=\'2\' ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\t/></td>\n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"4%\"\t\t><input type=\"hidden\" name=\"p_approval_remarks";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" id=\"p_approval_remarks";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\"><input type=\"text\" id=\"approval_remarks";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\"\t\t\t\t\tname=\"approval_remarks";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" size=\"4\"\t";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\')\"   /></td> \n\t\t\t\t<td nowrap class=\"fields\" \twidth=\"3%\"\t\t><input type=\'Checkbox\'\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 =" id=\"select_all";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" name=\"select_all";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" \talign=\"left\" \tonclick=\"copySelected(\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\')\" /></td> \n\t\t\t\t<!-- NMC-JD-CRF-0102.2-->\n\t\t\t\t<input type=\"hidden\"   id=\"primary_key_main";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\" \t\t\tname=\"primary_key_main";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\"  \t\t\tvalue=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"primary_key_line_no";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" \t\t\tname=\"primary_key_line_no";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\"  \t\tvalue=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\" />\n\t\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="<!-- NMC-JD-CRF-0102.2-->\n\t\t\t\t <input type=\"hidden\"   id=\"effective_from";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" \t\t\t\tname=\"effective_from";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"effective_to";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" \t\t\t\tname=\"effective_to";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\"  \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"patient_class";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\" \t\t\t\tname=\"patient_class";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"episode_encounter_flag";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\"\t\tname=\"episode_encounter_flag";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\"  \tvalue=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"clinic_nursing_ind";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" \t\t\tname=\"clinic_nursing_ind";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"clinic_nursing_code";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\" \t\t\tname=\"clinic_nursing_code";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"specilaity_code";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\" \t\t\t\tname=\"specilaity_code";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"preapproval_amt_capping";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\" \t\tname=\"preapproval_amt_capping";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"preapproval_qty_capping";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" \t\tname=\"preapproval_qty_capping";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"service_level_approval";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\" \t\tname=\"service_level_approval";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"preapproval_amt_gross_net";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\"\tname=\"preapproval_amt_gross_net";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\"  value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"utilized_qty";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\" \t\t\t\tname=\"utilized_qty";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"sex";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" \t\t\t\t\t\t\tname=\"sex";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\"  \t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"age_group_code";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" \t\t\t\tname=\"age_group_code";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"primary_key_facility_id";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" \t\tname=\"primary_key_facility_id";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"primary_key_module_id";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" \t\tname=\"primary_key_module_id";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"primary_key_bling_service_code";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" name=\"primary_key_bling_service_code";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"primary_key_service_item_code";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" name=\"primary_key_service_item_code";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\"   value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"billApprovedYn";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\" name=\"billApprovedYn";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"preapproval_dur_capping";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\" \t\tname=\"preapproval_dur_capping";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" />\n\t\t\t\t<!-- 102.2 -->\n\t\t\t\t<input type=\"hidden\"   id=\"seqNo";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" name=\"seqNo";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"requestID";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\" name=\"requestID";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"curSrlno";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" \t\tname=\"curSrlno";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\" />\n\t\t\t\t<input type=\"hidden\"   id=\"approved_dur_qty";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" \t\tname=\"approved_dur_qty";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" />\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="<td class=\"label\" \talign=\"right\" >\n\t\t\t\t\t\t\t<input type=\"file\" name=\"UpdDoc";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" id=\"UpdDoc";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\"  id=\"UpdDoc";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\" ";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="  onchange=\"getFileType(\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\')\" > \n\t\t\t\t\t  </td>\t\n\t\t\t\t";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\t\n\t\t\t\t\t <td class=\"label\" \talign=\"right\" >\n\t\t\t\t\t\t\t<input type=\"file\"  name=\"UpdDoc";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" disabled  onchange=\"getFileType(\'";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\')\"  > \n\t\t\t\t\t </td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\n\t\t\t\t<input type=\"hidden\"   id=\"DocUplYN";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\" \t\t\t\tname=\"DocUplYN";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\"  \t\t\tvalue=\"N\" />\n\t\t\t\t<!-- NMC-JD-CRF-0102.2-->\n\t\t\t\t";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\t<input type=\"hidden\" name=\"p_Loc_code";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\" id=\"p_Loc_code";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\"> <!--V221025-->\n\t\t\t";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\t\t\n\t\t\t</tr> \n\t";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\t\n\t</table>\n\t<input type=\'hidden\' name=\'authorisecheck\' id=\'authorisecheck\'\tid=\'authorisecheck\'  value=\"\" >\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\'\t\tid=\'locale\' \t \tvalue=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\" >\n\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\'\tid=\'facilityId\' \tvalue=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\" >\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' id=\'mode\'\tvalue=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\" >\n\t<input type=\'hidden\' name=\'isUserCanAcess\' id=\'isUserCanAcess\' id=\'isUserCanAcess\'\tvalue=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" />\n\t<input type=\'hidden\' name=\'authorized\' id=\'authorized\' \tid=\'authorized\'\t\tvalue=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\" />\n\t<input type=\'hidden\' name=\'patinetId\' id=\'patinetId\' \tid=\'patinetId\'\t\tvalue=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\" >\n\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' id=\'episodeType\'\tvalue=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\" >\n\t<input type=\'hidden\' name=\'visitId\' id=\'visitId\' \tid=\'visitId\'\t\tvalue=\"";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\" >\n\t<input type=\'hidden\' name=\'priority\' id=\'priority\' \tid=\'priority\'\t\tvalue=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\" />\n\t<input type=\'hidden\' name=\'acctSeqNo\' id=\'acctSeqNo\' \tid=\'acctSeqNo\'\t\tvalue=\"";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\" />\n\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\'  id=\'encounterId\'\tvalue=\"";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\" >\n\t<input type=\'hidden\' name=\'policyTypeCode\' id=\'policyTypeCode\' id=\'policyTypeCode\'\tvalue=\"";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\" >\n\t<input type=\'hidden\' name=\'custGroupCode\' id=\'custGroupCode\' id=\'custGroupCode\'\tvalue=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\" >\n\t<input type=\'hidden\' name=\'custCode\' id=\'custCode\' \tid=\'custCode\'\t\tvalue=\"";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" />\n\t<input type=\'hidden\' name=\'policyNumber\' id=\'policyNumber\' id=\'policyNumber\'\tvalue=\"";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\" />\n\t<input type=\'hidden\' name=\'episodeId\' id=\'episodeId\' \t\tid=\'episodeId\'\tvalue=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\" />\n\t<input type=\'hidden\' name=\'copyIndex\' id=\'copyIndex\'\t\tid=\'copyIndex\' \tvalue=\"";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\"\t/ >\n\t<input type=\'hidden\' name=\'approvedAmount\' id=\'approvedAmount\'\tid=\'approvedAmount\' value=\"";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\"\t/ >\n\t<input type=\'hidden\' name=\'requestStatus\' id=\'requestStatus\'\tid=\'requestStatus\' \tvalue=\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\"\t/ >\n\t<input type=\'hidden\' name=\'rowCount\' id=\'rowCount\'\tid=\'rowCount\' \t/ >\n\t<input type=\'hidden\' name=\'prevRow\' id=\'prevRow\'\t\tid=\'prevRow\' \t / >\n\t<input type=\'hidden\' name=\'recalc_charges\' id=\'recalc_charges\'\tid=\'recalc_charges\' / >\n\t<input type=\'hidden\'  name =\'sys_date\'\tvalue = \"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\" />\n\t<input type=\'hidden\' name=\'siteId\' id=\'siteId\' id =\'siteId\' value=\'";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\' />\n\t<input type=\'hidden\' name=\'expiryDate\' id=\'expiryDate\' id =\'expiryDate\' value=\'";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\' />\t <!--Karthik Record approval   -  MMS-QH-CRF-0165 - Starts  -->\n\t<input type=\'hidden\' name=\'effectiveTo\' id=\'effectiveTo\' id =\'effectiveTo\' value=\'";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\' />\t <!-- Record approval   -  MMS-QH-CRF-0165 - Starts -->\n\t<input type=\'hidden\' name=\'disableVal\' id=\'disableVal\'\t\tid=\'disableVal\' \tvalue=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\"\t/ >\n\t<input type=\'hidden\' name=\'effectiveToModified\' id=\'effectiveToModified\' id=\'effectiveToModified\' \t value=\'\'\t/ >\n\t<input type=\'hidden\' name=\'sysDateTime\' id=\'sysDateTime\' id=\'sysDateTime\' value=\'";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\' />\n\t<input type=\'hidden\' name=\'authorise_check_billed\' id=\'authorise_check_billed\' id=\'authorise_check_billed\' value=\'N\' />\n\t<input type=\'hidden\' name=\'user_id\' id=\'user_id\' id=\'user_id\' value=\'";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\' />\n\t<input type=\'hidden\' name=\'approvalstatus_hdn\' id=\'approvalstatus_hdn\' id=\'approvalstatus_hdn\' value=\'\' />\n\t<input type=\'hidden\' name=\'site_spec\' id=\'site_spec\' id=\'site_spec\' value=\'";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\'/>\n\t<input type=\'hidden\' name=\'enableMCNNumberYN\' id=\'enableMCNNumberYN\' id=\'enableMCNNumberYN\' value=\'";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\'/><!--V220905-->\n\t<input type=\'hidden\' name=\'currMCNNum\' id=\'currMCNNum\' id=\'currMCNNum\' value=\'\'/><!--V220905-->\n\t<input type=\'hidden\' name=\'currMCNNumidx\' id=\'currMCNNumidx\' id=\'currMCNNumidx\' value=\'\'/><!--V220905-->\n\t<input type=\'hidden\' name=\'site_spec_approval_sts\' id=\'site_spec_approval_sts\' id=\'site_spec_approval_sts\' value=\'";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\'/> <!-- Added V190513-Dhananjay/MMS-DM-SCF-0612-->\n\t<input type=\'hidden\' name=\'authorizedUserId\' id=\'authorizedUserId\' id=\'authorizedUserId\' value=\'\'>\t\t\n\t<input type=\'hidden\' name=\'site3TierAlmoFeatureYN\' id=\'site3TierAlmoFeatureYN\' id=\'site3TierAlmoFeatureYN\' value=\'";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\'/>\n\t<!--  AAKH-SCF-0404.1 -->\n\t<input type=\'hidden\' name=\'siteRecAppRecalChargeYN\' id=\'siteRecAppRecalChargeYN\'\t\tid=\'siteRecAppRecalChargeYN\' \tvalue=\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\" /><!--V220627-->\n\t<input type=\'hidden\' name=\'siteApprovalStatusColorCodeYN\' id=\'siteApprovalStatusColorCodeYN\' id=\'siteApprovalStatusColorCodeYN\' value=\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\'/>\n\t<input type=\'hidden\' name=\'enableQueuePKID\' id=\'enableQueuePKID\' id=\'enableQueuePKID\' value=\'";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\'/><!--V221025-->\n\t<input type=\'hidden\' name=\'insurance_clr\' id=\'insurance_clr\'\tid=\'insurance_clr\' / ><!--V221216-->\n\t<input type=\'hidden\' name=\'calledForm\' id=\'calledForm\'\tid=\'calledForm\' value=\'";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\' / ><!--V230102--> \n\t<!-- NMC-JD-CRF-0102.2-->\n\t<input type=\'hidden\' name=\'docCnt\' id=\'docCnt\' id=\'docCnt\' value=\"0\">\n\t<input type=\'hidden\' name=\'membershipNo\' id=\'membershipNo\' id=\'membershipNo\' value=\"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\" />\n\t<input type=\'hidden\' name=\'siteSpecUploadDoc\' id=\'siteSpecUploadDoc\'\tid=\'siteSpecUploadDoc\' value=\'";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\' / >\n\t<input type=\'hidden\' name=\'filePath\' id=\'filePath\' id=\'filePath\' value=\'";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\'>\t \n\t<input type=\'hidden\' name=\'pathExist\' id=\'pathExist\' value=\'";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\'>\t\n\t<input type=\'hidden\' name=\'writeAccess\' id=\'writeAccess\' value=\"";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\">\n\t<!-- NMC-JD-CRF-0102.2-->\n\n\t";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\n\t\t<script>initiateAuthorization();</script>\n\t";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\n\t</form>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\t\n\t</body>\n\t</TBODY>\n</div>\n</body>\n";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n</html>\n\n";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//V220324 Starts
	 request.setCharacterEncoding("UTF-8"); 
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 //V220324 ends

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PRE_APPROVAL_REQUEST_BILLINGSERVICECODE_LOOKUP")));
            _bw.write(_wl_block13Bytes, _wl_block13);

	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	//String applyMode																		=	new String();
	String locale																				=	"";
	String facilityId																			=	"";
	//String loggedInUser																			=	"";
	String mode																				=	"";
	mode																						=	"";
	String isUserCanAcess																		=	"";
	String bean_id																				=	"";
	String bean_name																			=	"";
	//String modifyStatus     																	=	"";
	String patinetId																			=	"";
	String episodeType																			=	"";
	String episodeId																			=	"";
	String visitId																				=	"";
	String priority																				=	"";
	String acctSeqNo																			=	"";
	//String authorized																			=	"";
	String encounterId																			=	"";
	//String billingGrpId																			=	"";
	String policyTypeCode																		=	"";
	String custGroupCode   																		=	"";
	String custCode   																			=	"";
	String policyNumber																			=	"";
	String copyIndex																			=	"";
	String requestStatus																		=	"";
	String approvedAmount																		=	"";
	String disable																				=	"DISABLED";
	String disableYN																			=	"DISABLED";//V230608
	String readOnlyYN																			="";


	String criteriaFilter = "";
	String bg_code_filter = "";
	String bg_desc_filter = "";
	String serviceDate_filter = "";
	String serviceAmount_filter = "";
	String serviceQuantity_filter = "";
	String apprReqDate_filter = "";
	String apprGvnDate_filter = "";
	String apprNo_filter = "";
	String approval_status_filter = "";
	String apprQty_filter = "";
	String apprAmt_filter = "";
	String reason_filter = "";
	String reason_hdn_filter = "";
	String remarks_filter = "";
	String userAuthorization = "";
	String encounterIdFilter=""; // Added by Vijay for mms crf 0077
	String orderStatusFilter=""; // Added by Vijay for mms crf 0077
	String siteId = "";
	String enabValue=""; 		//pradeepa - CRF 0165 Record approval
	String siteSpec="";	
	Boolean site_Specapproval_sts =false;	
	String siteSpecapprovalsts="";		// Added V190326-Dhananjay/MMS-DM-SCF-0612

			
	LinkedHashMap preApprovalRequestDetailsDataMap												=	null;
	//ArrayList<String[]>		preApprovalRequestDetailsList										=	null;
		
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	String sysDateTime = "";

	String	strLoggedUser	=  "";
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "N";
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	//Added V200807 SHIKHA against NMC-JD-CRF-0042
	String Acolor = "";
	String Pcolor = "";
	String Hcolor = "";
	String Scolor = "";
	String Rcolor = "";
	String Ccolor = "";
	String AtimeLimit = "0";//V201014
	String PtimeLimit = "0";//V201014
	String HtimeLimit = "0";//V201014
	String StimeLimit = "0";//V201014
	String RtimeLimit = "0";//V201014
	String CtimeLimit = "0";//V201014
	boolean siteApprovalStatusColorCode = false;
	String siteApprovalStatusColorCodeYN = "N";
	//Ended V200807 SHIKHA against NMC-JD-CRF-0042
	//V220627 starts
	boolean siteRecAppRecalCharge = false;
	String siteRecAppRecalChargeYN = "";
	//V220627 ends
	String enableMCNNumberYN = ""; //V220905
	String MCN_no="";//V220905
	String calledForm="";//V230102
String enableYN="";//V230608 .testing
	//NMC-JD-CRF-0102.2
	String filePath = "";
	String pathExist="";
	String writeAccess="";
	PreparedStatement pstmt2 = null;
	ResultSet res2 = null;
	String membershipNo="";
	//NMC-JD-CRF-0102.2
	try  
	{	 
		sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		locale 																					= 	(String)session.getAttribute("LOCALE");
		strLoggedUser																			=	(String) session.getValue("login_user");	
		if (strLoggedUser==null) strLoggedUser = "";

		facilityId																				=   (String) session.getValue( "facility_id" ) ;
		patinetId																				=	checkForNull(request.getParameter("patinetId"));
		enableMCNNumberYN																				=	checkForNull(request.getParameter("enableMCNNumberYN"));//V220905
		episodeType																				=	checkForNull(request.getParameter("episodeType"));
		episodeId																				=	checkForNull(request.getParameter("episodeId"));
		visitId																					=	checkForNull(request.getParameter("visitId"));
		priority																				=	checkForNull(request.getParameter("priority"));
		acctSeqNo																				=	checkForNull(request.getParameter("acctSeqNo"));
		encounterId																				=	java.net.URLDecoder.decode(checkForNull(request.getParameter("encounterId")));
		//billingGrpId																			=	checkForNull(request.getParameter("billingGrpId"));
		policyTypeCode																			=	checkForNull(request.getParameter("policyTypeCode"));
		custGroupCode																			=	checkForNull(request.getParameter("custGroupCode"));
		custCode																				=	checkForNull(request.getParameter("custCode"));
		policyNumber																			=	checkForNull(request.getParameter("policyNumber"));
		requestStatus																			=	checkForNull(request.getParameter("requestStatus"));
		approvedAmount																			=	checkForNull(request.getParameter("approvedAmount"));
		calledForm=	checkForNull(request.getParameter("calledForm"));//V230102
		membershipNo																			=	checkForNull(request.getParameter("membershipNo"));//102.2
		System.out.println("membershipNo "+membershipNo);
//V230608 testing starts
	enableYN																			=	checkForNull(request.getParameter("enableYN"));

//testing ends	

	
		String isDisabled="disabled"; //NMC-JD-CRF-0102.2

	
		criteriaFilter = checkForNull(request.getParameter("criteriaFilter"));
		bg_code_filter = checkForNull(request.getParameter("bg_code_filter"));
		bg_desc_filter = checkForNull(request.getParameter("bg_desc_filter"));
		serviceDate_filter = checkForNull(request.getParameter("serviceDate_filter"));
		serviceAmount_filter = checkForNull(request.getParameter("serviceAmount_filter"));
		serviceQuantity_filter = checkForNull(request.getParameter("serviceQuantity_filter"));
		apprReqDate_filter = checkForNull(request.getParameter("apprReqDate_filter"));
		apprGvnDate_filter = checkForNull(request.getParameter("apprGvnDate_filter"));
		apprNo_filter = checkForNull(request.getParameter("apprNo_filter"));
		approval_status_filter = checkForNull(request.getParameter("approval_status_filter"));
		apprQty_filter = checkForNull(request.getParameter("apprQty_filter"));
		MCN_no=checkForNull(request.getParameter("MCNnumber"));//V220909
		apprAmt_filter = checkForNull(request.getParameter("apprAmt_filter"));
		reason_filter = checkForNull(request.getParameter("reason_filter"));
		reason_hdn_filter = checkForNull(request.getParameter("reason_hdn_filter"));
		remarks_filter = checkForNull(request.getParameter("remarks_filter"));
		userAuthorization = checkForNull(request.getParameter("userAuthorization"));
		encounterIdFilter= checkForNull(request.getParameter("encounterIdFilter"));
		orderStatusFilter= checkForNull(request.getParameter("orderStatusFilter"));
		siteSpec=checkForNull(request.getParameter("site_spec"));
		System.out.println("site spec "+siteSpec);
		System.out.println("encounterId 432  "+encounterId);
		
		siteId = BLReportIdMapper.getCustomerId();
		preApprovalRequestDetailsDataMap														=	new LinkedHashMap();
		//System.err.println("BillingPreApprovalRequestDetails.jsp Request Param ::::::"+request.getQueryString());
	
		bean_id																					= 	"PreApprovalRequestDetailsBean" ;
		bean_name																				= 	"eBL.PreApprovalRequestDetailsBean";
		PreApprovalRequestDetailsBean preApprovalRequestDetailsBean								= 	(PreApprovalRequestDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
		isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
		/* Added 3 more empty parameters/Added by Aravindh/11-04-2018/MMS-DM-CRF-0125 */
		preApprovalRequestDetailsDataMap														=	preApprovalRequestDetailsBean.getPreApprovalRequestDetailsData(patinetId, episodeType, episodeId, visitId, priority,requestStatus,acctSeqNo, facilityId, locale,custGroupCode,custCode,policyTypeCode,
				criteriaFilter,bg_code_filter,serviceDate_filter,serviceAmount_filter,serviceQuantity_filter,apprReqDate_filter,
				apprGvnDate_filter,apprNo_filter,approval_status_filter,apprQty_filter,apprAmt_filter,reason_hdn_filter,remarks_filter,encounterId,encounterIdFilter,orderStatusFilter,"","","");		
		System.out.println("hashmap, size=>"+preApprovalRequestDetailsDataMap.size());
		
		con = ConnectionManager.getConnection(request); 
		String sqlBillingService = "SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) description FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = 'BL' AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = 'L_SERV_INC_EXC_CR' AND B.LANGUAGE_ID (+) = ? and A.LIST_ELMT_VALUE = ? ";
		String blngServDesc = "";
	
		//String rowChange = "";	
	//Added V200807 SHIKHA against NMC-JD-CRF-0042
	try {		
		siteApprovalStatusColorCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","APPROVAL_STATUS_COLORCODE");
		if(siteApprovalStatusColorCode){
			siteApprovalStatusColorCodeYN ="Y";
		} else{
			siteApprovalStatusColorCodeYN ="N";
		}		
	} catch(Exception ex) {
		ex.printStackTrace();
	}
		
	try
	{
		String sqlRecordColor = "SELECT REQUEST_STATUS,SUBSTR(TIME_LIMIT,0,INSTR(TIME_LIMIT,':')-1)*60 + SUBSTR(TIME_LIMIT,INSTR(TIME_LIMIT,':')+1),COLOR_CODE FROM BL_COLOR_INDICATOR_RULE_STATUS WHERE facility_id = '"+facilityId+"'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlRecordColor) ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  				
				if (rs.getString(1).equals("A")){
					Acolor = rs.getString(3); 
					AtimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("P")){
					Pcolor = rs.getString(3); 
					PtimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("S")){
					Scolor = rs.getString(3); 
					StimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("R")){
					Rcolor = rs.getString(3); 
					RtimeLimit = rs.getString(2);
				}else if (rs.getString(1).equals("H")){
					Hcolor = rs.getString(3); 
					HtimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("C")){
					Ccolor = rs.getString(3); 
					CtimeLimit = rs.getString(2);
				}
			}
		}		
		if(rs !=null) rs.close();
		stmt.close();						
	}
	catch(Exception e)
	{
		out.println("Exception @ BL_COLOR_INDICATOR_RULE_STATUS"+e);
		e.printStackTrace();
	}
	//Ended V200807 SHIKHA against NMC-JD-CRF-0042
	String sys_date = "";
	
	try
	{
		//Query Modified for MMS-CRF-0198.1
		String query_date="select to_char(sysdate,'dd/mm/yyyy'), to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') curr_time from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date) ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  				
				sys_date = rs.getString(1); 
				sysDateTime = rs.getString("curr_time");
			}
		}
		if(rs !=null) rs.close();
		stmt.close();
		
		String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
		pstmt = con.prepareStatement(inclExclSql);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();
		
		if(rst!=null){
			while(rst.next()){
				criteriaMap.put(rst.getString("code"),rst.getString("description"));
			}	
		}
		
		pstmt = null;
		rst = null;
	}
	catch(Exception e)
	{
		out.println("Exception @ sys_date_wht_sec"+e);
		e.printStackTrace();
	}
	
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try {
		//con	=	ConnectionManager.getConnection(request); commented against checkstyle
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
		if (site3TierAlmoFeature) {
			site3TierAlmoFeatureYN = "Y";
		}else {
			site3TierAlmoFeatureYN = "N";
		}
	} catch(Exception ex) {
		System.err.println("Error in BillingPreApprovalRequestDetails.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	
	try {
		// Added V190326-Dhananjay/MMS-DM-SCF-0612/Starts
		site_Specapproval_sts = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_REC_APPR_USR_AUTH_VAL_APPR");
		System.out.println("site_Specapproval_sts"+site_Specapproval_sts);
		if(site_Specapproval_sts){
			siteSpecapprovalsts ="Y";
		} else{
			siteSpecapprovalsts ="N";
		}
		// Added V190326-Dhananjay/MMS-DM-SCF-0612/Ends	
	} catch(Exception ex) {
		ex.printStackTrace();
	}
		//Added V220627
		try {
			siteRecAppRecalCharge = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "RECAL_CHARGES");
			System.err.println("siteRecAppRecalCharge--" + siteRecAppRecalCharge);
			if (siteRecAppRecalCharge) {
				siteRecAppRecalChargeYN = "Y";
			} else {
				siteRecAppRecalChargeYN = "N";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//V220627 ends
		//V221025
		String enableQueuePKID="N";
		boolean isEnablePkid=false; 
		try{
			isEnablePkid = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENB_QMS_IN_BILL_GEN");
			if (isEnablePkid) {
				enableQueuePKID = "Y";
			}else {
				enableQueuePKID = "N";
			}
			System.err.println("enableQueuePKID "+enableQueuePKID);
		} catch(Exception ex) {
			System.err.println("Error in BillingPreApprovalRequestDetails.jsp for getting isEnablePkid Connection: "+ex);
			ex.printStackTrace();
		}//V221025
		
		//NMC-JD-CRF-0102.2
		boolean siteSpecUploadDoc=false; 
		String siteSpecUploadDocYN="N";
		try{
		
			siteSpecUploadDoc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","REC_APPR_EXT_INT_ENABLED");
			System.out.println("siteSpecUploadDoc "+siteSpecUploadDoc);
			if(siteSpecUploadDoc){
				siteSpecUploadDocYN="Y";
			}
		} catch(Exception ex) {
			System.err.println("Error in BillingPreApprovalRequestDetails.jsp for getting siteSpecUploadDoc Connection: "+ex);
			ex.printStackTrace();
		}
		//NMC-JD-CRF-0102.2
	pstmt = con.prepareStatement(sqlBillingService);

            _bw.write(_wl_block14Bytes, _wl_block14);

if(siteSpecUploadDocYN.equals("Y")){
	
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
 }
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(siteSpec.equals("true")){  
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
} 
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 if(enableMCNNumberYN.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

				if(siteSpecUploadDoc && episodeType.equals("O")){
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

				}
			
            _bw.write(_wl_block36Bytes, _wl_block36);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(encounterIdFilter));
            _bw.write(_wl_block38Bytes, _wl_block38);
} 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

					for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
						String type = (String) iterator.next();
						if(type.equals(criteriaFilter)){
					
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(type));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(criteriaMap.get(type) ));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
						else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(type));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(criteriaMap.get(type) ));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
					}
					
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bg_code_filter ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bg_desc_filter ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(serviceDate_filter ));
            _bw.write(_wl_block50Bytes, _wl_block50);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(orderStatusFilter ));
            _bw.write(_wl_block52Bytes, _wl_block52);
} 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(serviceAmount_filter ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(serviceQuantity_filter ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(apprReqDate_filter ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(apprGvnDate_filter ));
            _bw.write(_wl_block57Bytes, _wl_block57);
 if(enableMCNNumberYN.equals("Y")){
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(MCN_no ));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(apprNo_filter ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(("A".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(("R".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(("P".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(("S".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(("H".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(("C".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(apprQty_filter ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(apprAmt_filter ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(reason_filter ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(reason_hdn_filter ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(remarks_filter ));
            _bw.write(_wl_block73Bytes, _wl_block73);
 
	Iterator iterator= preApprovalRequestDetailsDataMap.keySet().iterator();
	int rows=0;
	while(iterator.hasNext())
	{
		
		int index =    (Integer)iterator.next();
		rows=rows+1;
		System.out.println("IN getPreApprovalRequestDetailsData index:::::::"+index);
		preApprovalRequestDetailsBean = (PreApprovalRequestDetailsBean) preApprovalRequestDetailsDataMap.get(index);  
		/*	System.out.println("INDEX::: "+index+" ::::p_patient_class::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getPatientClass());
			System.out.println("INDEX::: "+index+" ::::p_episode_or_encounter_flag::::::::::: "+preApprovalRequestDetailsBean.getEpisodeEncounterFlag());
			System.out.println("INDEX::: "+index+" ::::p_clinic_nursing_ind:::::::::::::::::: "+preApprovalRequestDetailsBean.getClinicNursingIndicator());
			System.out.println("INDEX::: "+index+" ::::p_clinic_nursing_code::::::::::::::::: "+preApprovalRequestDetailsBean.getClinicNursingCode());
			System.out.println("INDEX::: "+index+" ::::p_splty_code:::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getSpecialiltyCode());
			System.out.println("INDEX::: "+index+" ::::p_sex::::::::::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getSex());
			System.out.println("INDEX::: "+index+" ::::p_age_group_code:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getAgeGroupCode());
			System.out.println("INDEX::: "+index+" ::::p_blng_serv_code:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getBillingServiceCode());
			System.out.println("INDEX::: "+index+" ::::p_serv_excl_incl_crit::::::::::::::::: "+preApprovalRequestDetailsBean.getIncludedExcluded());
			System.out.println("INDEX::: "+index+" ::::p_effective_from:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getEffectiveFrom());
			System.out.println("INDEX::: "+index+" ::::p_effective_to:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getEffectiveTo());
			System.out.println("INDEX::: "+index+" ::::p_preapproval_amt_capping::::::::::::: "+preApprovalRequestDetailsBean.getApprovalAmountCapping());
			System.out.println("INDEX::: "+index+" ::::p_preapproval_qty_capping::::::::::::: "+preApprovalRequestDetailsBean.getApprovalQuantityCapping());
			System.out.println("INDEX::: "+index+" ::::p_preapproval_amt_gross_net::::::::::: "+preApprovalRequestDetailsBean.getApprovalGrossNetAmount());
			System.out.println("INDEX::: "+index+" ::::p_service_level_approval_yn::::::::::: "+preApprovalRequestDetailsBean.getServiceLevelApprovalFlag());
			System.out.println("INDEX::: "+index+" ::::p_pre_app_num::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getApprovalNumber());
			System.out.println("INDEX::: "+index+" ::::p_app_req_date:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getApprovalRequiredDate());
			System.out.println("INDEX::: "+index+" ::::p_app_given_date:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getApprovalGivenDate());
			System.out.println("INDEX::: "+index+" ::::p_pre_app_status:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getStatus());
			System.out.println("INDEX::: "+index+" ::::p_pre_app_remark:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getRemarks());
			System.out.println("INDEX::: "+index+" ::::p_reason_code::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getReason());
			System.out.println("INDEX::: "+index+" ::::p_utilized_amount::::::::::::::::::::: "+preApprovalRequestDetailsBean.getUtilizedAmount());
			System.out.println("INDEX::: "+index+" ::::p_utilized_qty:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getUtilizedQuantity());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_facility_id::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyFacilityId());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_module_id::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyModuleId());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_main:::::::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyMain());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_line_no::::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyLineNo());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_blng_serv_code:::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_serv_item_code:::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode());
			System.out.println("INDEX::: "+index+" ::::p_serv_desc::::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode());
			System.out.println("INDEX::: "+index+" ::::p_service_date:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode());
			System.out.println("INDEX::: "+index+" ::::p_serv_desc::::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getBillingServiceDesc());
			System.out.println("INDEX::: "+index+" ::::p_service_date:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getServiceDate());
			*/
			
			System.err.println("INSIDE enableYN "+enableYN);
	if(enableYN.equals("Y")){
		if((!siteId.equals("ALMO") || (preApprovalRequestDetailsBean.getBillApprovedYN().equals("N"))) || (!site3TierAlmoFeatureYN.equals("Y") || preApprovalRequestDetailsBean.getBillApprovedYN().equals("N"))){ 
					disable="";	
					disableYN="disabled";
					readOnlyYN="readOnly";
					enabValue="Y";
		}
		//NMC-JD-CRF-0102.2
		if(siteSpecUploadDoc && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("C") && episodeType.equals("O")){
			isDisabled="";
		}
		System.err.println("INSIDE ENABLE ");
		//To check config done for upload document
		if(siteSpecUploadDoc && episodeType.equals("O")){
		  try{
			// Query to get file path for copying uploaded doc STARTS here
			String sqlFilePath = "select record_appr_doc_path from bl_parameters where OPERATING_FACILITY_ID = ? ";
			pstmt2 = con.prepareStatement(sqlFilePath);
			pstmt2.setString(1,facilityId);
			
			res2 = pstmt2.executeQuery();
			while(res2.next())
			{
				filePath = res2.getString(1) == null ? "" : res2.getString(1);
			}
			System.out.println("filePath in jsp "+filePath);
			if(res2 != null) res2.close();
			if(pstmt2 != null) pstmt2.close(); 
			
			//filePath = filePath.replace("\\", "/");
			System.out.println("filePath  1 "+filePath);
			String separator = System.getProperty( "file.separator" );
			File f = new File(filePath);
			if(f.exists())
			{
				pathExist="true";
				File file1 = new File(filePath+separator+System.currentTimeMillis()+".txt"); 
				try
				{
					if (file1.createNewFile())
					{
						writeAccess="true";
						file1.delete();
					}
					else
					{
						writeAccess="false";
					}
				}
				catch (IOException e)
		        {
					writeAccess="false";
		        }
			}
			else
			{
				pathExist="false";
			}
			System.out.println("billingpreapproval filePath after:" + filePath);
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in try of billingpreapproval jsp --"+e.toString());
			e.printStackTrace();
		}
		}
		System.out.println("929");
	}//V230608-NMC-JD-CRF-0102.2
			
	
	//Added V200807 SHIKHA against NMC-JD-CRF-0042
	//  int preAppStatusMaxDateTime =0; //V201013//checklist
	  String bgcolor = "";
	if ( siteApprovalStatusColorCode) {
	//V201024 commented try & catch	
		/*
	  try {
		  String preApprStatusStr = "select NVL(cast ((sysdate - max(PRE_APP_STATUS_DATE)) * 24 * 60 as int),0) from bl_ins_preappr_ser_lvl_dtlslog where OPERATING_FACILITY_ID= '"+facilityId+"' and patient_id ='"+patinetId +"' and episode_type ='"+episodeType+"' and  episode_id ='"+episodeId+"' and visit_id = '"+visitId
				  +"' and acct_seq_no='"+acctSeqNo+"'  and priority='"+priority+"' and PRIMARY_KEY_BLNG_SERV_CODE = '"+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode()+"' and PRIMARY_KEY_MAIN='"+preApprovalRequestDetailsBean.getPrimaryKeyMain()+"' and PRIMARY_KEY_LINE_NO='"+preApprovalRequestDetailsBean.getPrimaryKeyLineNo()+"'";
		  stmt = con.createStatement();		
		  rs = stmt.executeQuery(preApprStatusStr) ;
					
		  if( rs != null ) 
			{
				while( rs.next() )
				{  				
					preAppStatusMaxDateTime = rs.getInt(1);
				}
			}		
			if(rs !=null) rs.close();
			stmt.close();		  
	  } catch(Exception e) {
		e.printStackTrace();  
	  }	  */
	  if (preApprovalRequestDetailsBean.getColorStatus().equals("Y")) { //V201024 added
		  if (preApprovalRequestDetailsBean.getStatus().equals("P")) {
			  //if (preAppStatusMaxDateTime > Integer.parseInt(PtimeLimit)) { //V201024 commented			
				  bgcolor = "style=background-color:"+Pcolor;
				  //}  //V201024 commented
		  } else if (preApprovalRequestDetailsBean.getStatus().equals("A")) {
			  if ( !preApprovalRequestDetailsBean.getApprovalNumber().equals("Default Approved")) {					  
				 // if (preAppStatusMaxDateTime > Integer.parseInt(AtimeLimit)) { //V201024 commented
						bgcolor = "style=background-color:"+Acolor;						
					//  }  //V201024 commented
			  }
		  }else if (preApprovalRequestDetailsBean.getStatus().equals("H")) {		  
			  //if (preAppStatusMaxDateTime > Integer.parseInt(HtimeLimit)) { //V201024 commented
					bgcolor = "style=background-color:"+Hcolor;
				//  }  //V201024 commented
		  }else if (preApprovalRequestDetailsBean.getStatus().equals("C")) {			
			  //if (preAppStatusMaxDateTime > Integer.parseInt(CtimeLimit)) { //V201024 commented
					bgcolor = "style=background-color:"+Ccolor;
				//  }  //V201024 commented
		  }else if (preApprovalRequestDetailsBean.getStatus().equals("S")) {
			  //if (preAppStatusMaxDateTime > Integer.parseInt(StimeLimit)) {//V201024 commented
					bgcolor = "style=background-color:"+Scolor;
				//  }  //V201024 commented
		  }else if (preApprovalRequestDetailsBean.getStatus().equals("R")) {
			//  if (preAppStatusMaxDateTime > Integer.parseInt(RtimeLimit)) {//V201024 commented
				bgcolor = "style=background-color:"+Rcolor;
			 // }  //V201024 commented
		  } 
	  }
	}
	//Ended V200807 SHIKHA against NMC-JD-CRF-0042	  
	
            _bw.write(_wl_block74Bytes, _wl_block74);
if("Y".equals(preApprovalRequestDetailsBean.getBillApprovedYN())){ 
            _bw.write(_wl_block75Bytes, _wl_block75);
} else{ 
            _bw.write(_wl_block76Bytes, _wl_block76);
} 
            _bw.write(_wl_block77Bytes, _wl_block77);


					pstmt.setString(1,locale);
					pstmt.setString(2,preApprovalRequestDetailsBean.getIncludedExcluded());
					rst = pstmt.executeQuery();
					if(rst != null){
						while(rst.next()){
							blngServDesc = rst.getString("description");
						}
					}
					
				
            _bw.write(_wl_block78Bytes, _wl_block78);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(index));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEncounterId()			!=	null	?	preApprovalRequestDetailsBean.getEncounterId()		:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEncounterId()			!=	null	?	preApprovalRequestDetailsBean.getEncounterId()		:	""	 ));
            _bw.write(_wl_block83Bytes, _wl_block83);
} 
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(index));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(index));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(readOnlyYN));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getIncludedExcluded()	!=	null	?	preApprovalRequestDetailsBean.getIncludedExcluded()	:	""	 ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( blngServDesc	!=	null	?	blngServDesc	:	""	 ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(index));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(index));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceCode()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceCode()		:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceCode()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceCode()		:	""	 ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(index));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceDisplay()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDisplay()		:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceDisplay()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDisplay()		:	""	 ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disableYN));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(readOnlyYN ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(index));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(index));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceDesc()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDesc()		:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceDesc()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDesc()		:	""	 ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(readOnlyYN ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(index));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(index));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceDate()				!=	null	?	preApprovalRequestDetailsBean.getServiceDate()				:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceDate()				!=	null	?	preApprovalRequestDetailsBean.getServiceDate()				:	""	 ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(readOnlyYN));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(index));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(index));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(index));
            _bw.write(_wl_block109Bytes, _wl_block109);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(index));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(index));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getOrderStatus()				!=	null	?	preApprovalRequestDetailsBean.getOrderStatus()				:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getOrderStatus()				!=	null	?	preApprovalRequestDetailsBean.getOrderStatus()				:	""	 ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disableYN));
            _bw.write(_wl_block112Bytes, _wl_block112);
} 
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(index));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(index));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getUtilizedAmount()				!=	null	?	preApprovalRequestDetailsBean.getUtilizedAmount()			:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getUtilizedAmount()				!=	null	?	preApprovalRequestDetailsBean.getUtilizedAmount()			:	""	 ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(readOnlyYN));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(index));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(index));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceQty()				!=	null	?	preApprovalRequestDetailsBean.getServiceQty()			:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceQty()				!=	null	?	preApprovalRequestDetailsBean.getServiceQty()			:	""	 ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(readOnlyYN));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(index));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalRequiredDate()	));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(index));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalRequiredDate()			!=	null	?	preApprovalRequestDetailsBean.getApprovalRequiredDate()		:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalRequiredDate()		!=	null	?	preApprovalRequestDetailsBean.getApprovalRequiredDate()		:	""	 ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(index));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(index));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(index));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(index));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(index));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(index));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf( preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 	?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	sys_date	 ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(index));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(index));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 ?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	sys_date	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 	?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	sys_date	 ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(index));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(index));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(index));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(index));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(index));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(index));
            _bw.write(_wl_block140Bytes, _wl_block140);
 if(enableMCNNumberYN.equals("Y")){
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(index));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getMcnNumber()				!=	null	?	preApprovalRequestDetailsBean.getMcnNumber()			:	""	 ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(index));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(index));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getMcnNumber()				!=	null	?	preApprovalRequestDetailsBean.getMcnNumber()			:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getMcnNumber()				!=	null	?	preApprovalRequestDetailsBean.getMcnNumber()			:	""	 ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(index));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(index));
            _bw.write(_wl_block149Bytes, _wl_block149);
}
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(index));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(index));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(index));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(index));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(index));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus() !=null ? preApprovalRequestDetailsBean.getStatus() : "P" ));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(index));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(index));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(index));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(index));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(index));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(index));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(index));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("A") ? "SELECTED" : "" ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("R") ? "SELECTED" : "" ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("P") ? "SELECTED" : "" ));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("S") ? "SELECTED" : "" ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("H") ? "SELECTED" : "" ));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("C") ? "SELECTED" : "" ));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(index));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(index));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(index));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus() != null ? preApprovalRequestDetailsBean.getStatus():""  ));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(index));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(index));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(index));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus() !=null ? preApprovalRequestDetailsBean.getStatus() : "P" ));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(index));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 ));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(index));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(index));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(index));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(index));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(index));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 ));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(index));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(index));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(index));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(index));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(index));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 ));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(index));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(index));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 ));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(index));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(index));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(index));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(index));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(index));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(index));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 ));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(index));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(index));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 ));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(index));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(index));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(index));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(index));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(index));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(index));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyMain()				!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyMain()			: 	"" 	 ));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(index));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(index));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyLineNo()			!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyLineNo()			: 	"" 	 ));
            _bw.write(_wl_block222Bytes, _wl_block222);
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(index));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(index));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEffectiveFrom()  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveFrom()			: 	"" 	 ));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(index));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(index));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEffectiveTo()	  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveTo()				: 	"" 	 ));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(index));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(index));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPatientClass()				!=null 		? 	preApprovalRequestDetailsBean.getPatientClass()				: 	"" 	 ));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(index));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEpisodeEncounterFlag()		!=null 		? 	preApprovalRequestDetailsBean.getEpisodeEncounterFlag()		: 	"" 	 ));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(index));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(index));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getClinicNursingIndicator()		!=null 		? 	preApprovalRequestDetailsBean.getClinicNursingIndicator()	: 	"" 	 ));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(index));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(index));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getClinicNursingCode()			!=null 		? 	preApprovalRequestDetailsBean.getClinicNursingCode()		: 	"" 	 ));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(index));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(index));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getSpecialiltyCode()			!=null 		? 	preApprovalRequestDetailsBean.getSpecialiltyCode()			: 	"" 	 ));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(index));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalAmountCapping()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalAmountCapping()	: 	"" 	 ));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(index));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalQuantityCapping()	!=null 		? 	preApprovalRequestDetailsBean.getApprovalQuantityCapping()	: 	"" 	 ));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(index));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceLevelApprovalFlag()	!=null 		? 	preApprovalRequestDetailsBean.getServiceLevelApprovalFlag()	: 	"" 	 ));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(index));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(index));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalGrossNetAmount()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalGrossNetAmount()	: 	"" 	 ));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(index));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(index));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getUtilizedQuantity()			!=null 		? 	preApprovalRequestDetailsBean.getUtilizedQuantity()			: 	"" 	 ));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(index));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(index));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getSex()						!=null 		? 	preApprovalRequestDetailsBean.getSex()						: 	"" 	 ));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(index));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(index));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getAgeGroupCode()				!=null 		? 	preApprovalRequestDetailsBean.getAgeGroupCode()				: 	"" 	 ));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(index));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyFacilityId()		!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyFacilityId()		: 	"" 	 ));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(index));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyModuleId()			!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyModuleId()		: 	"" 	 ));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(index));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(index));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode()!=null 	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode():"" 	 ));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(index));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(index));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode()!=null	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode():"" ));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(index));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(index));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillApprovedYN()!=null	? 	preApprovalRequestDetailsBean.getBillApprovedYN():"" ));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(index));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalDurationCapping()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalDurationCapping()	: 	"" 	 ));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(index));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(index));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getSeqno()!=null	? 	preApprovalRequestDetailsBean.getSeqno():"" ));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(index));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(index));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getRequestID()!=null	? 	preApprovalRequestDetailsBean.getRequestID():"" ));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(index));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getCurrSrlno()		!=null 		? 	preApprovalRequestDetailsBean.getCurrSrlno()	: 	"" 	 ));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(index));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedDurationQty()		!=null 		? 	preApprovalRequestDetailsBean.getApprovedDurationQty()	: 	"" 	 ));
            _bw.write(_wl_block276Bytes, _wl_block276);

				System.out.println("INDEX::: "+index+" ::::requestID::::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getRequestID());
				System.out.println("INDEX::: "+index+" ::::getCurrSrlno:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getCurrSrlno());
				
				if(siteSpecUploadDoc && episodeType.equals("O")){ 
					if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("C")){
					
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(index));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(index));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(index));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(isDisabled));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(index));
            _bw.write(_wl_block282Bytes, _wl_block282);
	}else{ 
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(index));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(index));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(index));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(index));
            _bw.write(_wl_block285Bytes, _wl_block285);
}
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(index));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(index));
            _bw.write(_wl_block288Bytes, _wl_block288);
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(index));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(index));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getLocationCode()				!=	null	?	preApprovalRequestDetailsBean.getLocationCode()			:	""	 ));
            _bw.write(_wl_block291Bytes, _wl_block291);
            _bw.write(_wl_block292Bytes, _wl_block292);

		}	
	if(rows==0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	}
	
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(isUserCanAcess));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(enabValue));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(patinetId));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(acctSeqNo));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(policyTypeCode));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(custGroupCode));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(custCode));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(policyNumber));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(copyIndex));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(approvedAmount));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(requestStatus));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(sys_date ));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(siteId ));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(request.getParameter("expiryDate")));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(request.getParameter("effectiveTo")));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(sysDateTime ));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf( strLoggedUser));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(siteSpec ));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(enableMCNNumberYN));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(siteSpecapprovalsts ));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(site3TierAlmoFeatureYN ));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(siteRecAppRecalChargeYN));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(siteApprovalStatusColorCodeYN ));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(enableQueuePKID ));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(calledForm));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(membershipNo));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(siteSpecUploadDocYN));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(filePath));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(pathExist));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(writeAccess));
            _bw.write(_wl_block332Bytes, _wl_block332);
if("Y".equals(userAuthorization)){ 
            _bw.write(_wl_block333Bytes, _wl_block333);
} 
            _bw.write(_wl_block334Bytes, _wl_block334);

	}
	catch(Exception e)
	{
		System.err.println("Exception in BillingPreApprovalRequestDetails.jsp::"+e);
		e.printStackTrace();
	}
	finally{
		ConnectionManager.returnConnection(con);
		pstmt = null;
		rst = null;
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block335Bytes, _wl_block335);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INCLUDED_EXCLUDED.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLNG_SERV_CODE.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingServiceDesc.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_DATE.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderStatus.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceAmount.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceQuantity.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprovalRequiredDate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprovalGivenDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MCNno.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprovalNumber.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_QTY.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UploadDocuments.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
}
