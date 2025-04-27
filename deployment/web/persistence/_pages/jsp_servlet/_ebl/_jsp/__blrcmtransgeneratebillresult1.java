package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.Date;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __blrcmtransgeneratebillresult1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLRCMTransGenerateBillResult1.jsp", 1727253554504L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\r\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n<script language=\"javascript\" src=\"../../eBL/js/RCMTransactions.js\"></script>\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<HTML>\r\n<HEAD>\r\n<style>\r\n.bordered-table {\r\n    border-collapse: collapse;\r\n    border: 1px solid #e0e0e0;\r\n    width: 100%;\r\n}\r\n\r\n.bordered-table th, .bordered-table td {\r\n    border: 1px solid #e0e0e0;\r\n    padding: 8px;\r\n}\r\n\r\n.colored-cell {\r\n    background-color: yellow; /* Default background color */\r\n}\r\n\r\n.no-border td {\r\n    border: none; /* Remove borders for cells in the selected row */\r\n}\r\n</style>\r\n</HEAD>\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\r\n\t\t\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\r\n<script>\r\nfunction loadBtnFrame(){\r\n\tvar bill_tot_rec = document.getElementById(\"bill_tot_rec\").value;\r\n\tvar eligibleForResubmit = document.forms[0].eligible_For_Resubmit.value;  \r\n\tvar insuranceStatus = document.getElementById(\"insuranceStatus\").value;\r\n\tvar responseLevel = document.getElementById(\"responseLevel\").value;\r\n\t\r\n\tvar eligibleForResubmit = \'\';\r\n\tvar resubmit_yn = \'\';\r\n\tvar claim_status = \'\';\r\n\tvar claim_finalized_yn = \'\';\r\n\tvar sql_for_export = document.forms[0].sql_for_export.value;\r\n\tif(bill_tot_rec > 0){\r\n\t\t\r\n\t\tfor(var i=0;i<bill_tot_rec;i++){\r\n\t\t\t\r\n\t\t\tresubmit_yn = document.getElementById(\"resubmit_yn_\"+i).value;\r\n\t\t\tclaim_status = document.getElementById(\"claimStatus_\"+i).value;\r\n\t\t\tclaim_finalized_yn = document.getElementById(\"claim_finalized_yn_\"+i).value;\r\n\t\t\t\t\r\n\t\t\tif((claim_status == \'R\' || claim_status == \'L\') && resubmit_yn == \'Y\' && (claim_finalized_yn == \'N\' || claim_finalized_yn == \'\'))\r\n\t\t\t\teligibleForResubmit = \"Y\";\r\n\t\t}\t\t\r\n\t\t\r\n\t\tparent.frames(3).document.location.href = \"../../eBL/jsp/BLRCMTransResultQryBtn1.jsp?p_ins_status=\"+insuranceStatus+\"&eligibleForResubmit=\"+eligibleForResubmit+\"&p_level_of_srch=\"+responseLevel+\"&sql_for_export=\"+sql_for_export;\r\n\t\t\r\n\t\t\r\n\t}\r\n\t\r\n}\r\n</script>\r\n    \r\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onLoad=\"loadBtnFrame();\" >\r\n<form name=\"BLRCMTransGenerateBillRes1\" enctype=\"multipart/form-data\">\r\n\r\n\r\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\r\n\r\n\t\t\t\t\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t\t\r\n<TABLE class=\'grid\' border=1 width=\"100%\" cellspacing=0 cellpadding=3 align=\'center\'>\r\n\r\n\t\t<td class=\'columnheadercenter\' width=\"2%\"><input type=\"checkbox\" id=\"checkheader\" name=\"checkheader\" onclick=\"payerCheck1(this)\" value=\"\"/></td>\r\n\t\t<td class=\'columnheadercenter\'  width=\"5%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\r\n\t\t<td class=\'columnheadercenter\'  width=\"10%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\r\n\t\t<td class=\'columnheadercenter\'  width=\"5%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\r\n\t\t<td class=\'columnheadercenter\'  width=\"6%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/ ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td> \r\n\t\t<td class=\'columnheadercenter\'  width=\"6%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\r\n\t\t<td class=\'columnheadercenter\'  width=\"7%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\r\n\t\t<td class=\'columnheadercenter\'  width=\"8%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\r\n        <td class=\'columnheadercenter\'  width=\"5%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\r\n\t\t<td class=\'columnheadercenter\'  width=\"15%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\t\r\n\t\t\r\n\t\t\t\t\t\r\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t<tr id=\'tr_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onClick = \"loadPolicyDetails1(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\" >   \r\n\t\t\t\t<td><input type=\"checkbox\" id=\"check_payer";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" name=\"check_payer";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onclick=\"check_payer_1(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');\" value=\"\"></td>\r\n\t\t\t\t<td\t class=\'label\' id=\'td_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="_1\' width=\"5%\">\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" &nbsp;</td> \r\n\t\t\t\t<td  class=\'label\'\tid=\'td_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="_2\' width=\"10%\">\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="_3\' width=\"5%\"> ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="_4\' width=\"6%\"> ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" &nbsp;</td>\r\n\t\t\t\t<td  class=\'label\'\tid=\'td_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="_5\' width=\"6%\"> ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;</td> \r\n\t\t\t\t<td  class=\'label\'\tid=\'td_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="_6\' width=\"7%\"> ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="_7\' width=\"7%\"> ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="_8\' width=\"7%\">\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="_9\' width=\"5%\">  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="_10\' width=\"5%\"> ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="_11\' width=\"7%\"> ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="_12\' width=\"8%\"><a href=\"#\" name=\"remarks_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"remarks_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onclick=\"callRemarkPopup1(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\', \'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'B\',\'\');\">     ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</a> &nbsp;</td> \r\n\t\t\t\t<td  class=\'label\'\tid=\'td_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="_13\' width=\"5%\"> ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\r\n\t\t\t\t<td  class=\'label\'\tid=\'td_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="_14\' width=\"5%\">    ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" </td>\r\n\t\t\t\t<input type=\"hidden\" id=\"claimID_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" name=\"claimID_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"patientId_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" name=\"patientId_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"billDocTypeCode_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" name=\"billDocTypeCode_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\r\n\t\t\t\t<input type=\"hidden\" id=\"billNum_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" name=\"billNum_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"supp_doc_path_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" name=\"supp_doc_path_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t<td class=\'label\' id=\'td_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="_14\' width=\"15%\">\r\n\t\t\t\t<input type=\"file\" name=\"patFile_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"patFile_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" value=\"\"  size=10 maxlength=40 onchange=\"getFileType1(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\')\" onkeypress=\"return onkeyPressEvent(event);\" >\r\n\t\t\t\t\r\n\t\t\t\t<img  src=\'../../eCommon/images/folder.gif\' id=\"folderIcon\" onclick=\"navigateToFolder(\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\');\">\r\n\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\r\n\t\t\t\t<img  src=\'../../eCommon/images/Completed.gif\' onMouseOver=\'showToolTip(\"Eligible for Resubmission\");\' onMouseOut=\'hideToolTip();\' class = \'img\' >\r\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\r\n\t\t\t\t</td>\t\r\n\t\t\t\t<input type=\"hidden\"   id=\"DocUplYN";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" name=\"DocUplYN";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"  \t\t\tvalue=\"N\" />\r\n\t\t\t\t<input type=\"hidden\" id=\"payerGrp_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" name=\"payerGrp_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"payerGrpCode_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" name=\"payerGrpCode_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"payer_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" name=\"payer_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"payerCode_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" name=\"payerCode_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"policyType_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" name=\"policyType_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"policyTypeCode_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" name=\"policyTypeCode_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"episodeType_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" name=\"episodeType_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"encounterId_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" name=\"encounterId_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"visitAdmitDt_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" name=\"visitAdmitDt_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"checkoutDiscDt_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" name=\"checkoutDiscDt_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" >\r\n\t\t\t\t\t\t\r\n\t\t\t\t<input type=\"hidden\" id=\"patientName_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" name=\"patientName_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"netBillAmt_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" name=\"netBillAmt_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"apprBillAmt_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" name=\"apprBillAmt_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"receiptDocRefNum_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" name=\"receiptDocRefNum_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"billRemarks_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" name=\"billRemarks_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"claimStatus_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" name=\"claimStatus_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"responseLevel_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" name=\"responseLevel_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"checkedStatus_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" name=\"checkedStatus_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" value=\"N\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"membershipNo_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" name=\"membershipNo_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"fileName_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" name=\"fileName_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" value=\"\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"resubmit_yn_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" name=\"resubmit_yn_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"claim_finalized_yn_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" name=\"claim_finalized_yn_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" >\r\n\t\t\t\t\r\n\t\t\t\t<input type=\"hidden\" id=\"reqId_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" name=\"reqId_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"resId_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" name=\"resId_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"firstReqId_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" name=\"firstReqId_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"claimFirstReqId_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" name=\"claimFirstReqId_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"claimReqId_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" name=\"claimReqId_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"claimResId_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" name=\"claimResId_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"claimComResId_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" name=\"claimComResId_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"comResId_";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" name=\"comResId_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"claimTypeCode_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" name=\"claimTypeCode_";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"preAuthRefNo_";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" name=\"preAuthRefNo_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" >\r\n\t\t\t\t<input type=\"hidden\" id=\"claimType_";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" name=\"claimType_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" >\r\n\t\t\t\t<input type=\'hidden\' id=\'claim_sub_type";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' name=\'claim_sub_type";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t</tr>\r\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\r\n\r\n\t\t\r\n</TABLE>\t\r\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\t\r\n<Script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\r\nparent.frames(3).document.location.href = \'../../eCommon/html/blank.html\';\t\r\n</script>\r\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\t\t\t\t\r\n\r\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\t\r\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\r\n\t<input type=\'hidden\' name=\'locale\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\r\n\t<input type=\'hidden\' name=\'prevClicked\' value=\'N\'>\r\n\t<input type=\'hidden\' name=\'rowClicked\' value = \'\'>\r\n\t<input type = \"hidden\" id = \"tot_rec\" name = \"tot_rec\" value = \"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" >\r\n\t<input type = \"hidden\" id = \"bill_tot_rec\" name = \"bill_tot_rec\" value = \"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" >\r\n\t<input type = \"hidden\" id = \"p_action_id\" name = \"p_action_id\" value = \"\" >\r\n\t<input type = \"hidden\" id = \"insuranceStatus\" name = \"insuranceStatus\" value = \"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" >\r\n\t<input type=\'hidden\' name=\'filePath\' id=\'filePath\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\t \r\n\t<input type=\'hidden\' name=\'pathExist\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\t\r\n\t<input type=\'hidden\' name=\'writeAccess\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\r\n\t<input type=\'hidden\' name=\'qry_search_params\' id=\'qry_search_params\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\r\n\t<input type = \"hidden\" id = \"responseLevel\" name = \"responseLevel\" value = \"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" >\r\n\t<input type=\'hidden\' name=\'rcmTransFieldsMOHYN\' id=\'rcmTransFieldsMOHYN\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>  <!-- V240417 -->\r\n    <input type = \"hidden\" id = \"eligible_For_Resubmit\" name = \"eligible_For_Resubmit\" value = \"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" >\r\n\t<input type = \"hidden\" id = \"sql_for_export\" name = \"sql_for_export\" value = \"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" >\r\n\t<input type= \"hidden\" id=\"offline_claim_path\" name=\"offline_claim_path\" value= \"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" > <! -- Added by khaled for MOHE-CRF-0166.3 -->\r\n\t<input type=\'hidden\' id=\'preAuth_split_checker\' name=\'preAuth_split_checker\' value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\r\n\t\r\n\t\r\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\t\r\n<Script>//alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\r\n//parent.frames(3).document.location.href = \'../../eCommon/html/blank.html\';\t\r\n</script>\r\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\r\n<Script>checkBoxEnableDisable1(this);</script>\t\t\r\n</form>\r\n";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\r\n\r\n<div class=\'COLUMNHEADER\' name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:10%; visibility:hidden; background-color:blue;\'>\r\n\t \t<table id=\'tooltiptable\' cellpadding=\"0\" cellspacing=0 border-collapse=collapse  style=\'position:absolute;\' width=\'100%\' height=\'100%\' align=\'center\'>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\'100%\' id=\'menu_table\'></td>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n</body>\t\r\n\t\r\n</HTML>\r\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );
	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		ResultSet rst1=null;
		//PreparedStatement chkstmt=null; //V240826
		CallableStatement chkstmt = null;
		ResultSet chkrst=null; //V240826
		try
		{
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			System.err.println("params IN BLRCMTransGenerateBillResult.jsp is: "+params);
			
			con=ConnectionManager.getConnection(request);
			String sql = "";
			
			String facilityId = (String)session.getAttribute("facility_id");
			String locale = (String)session.getAttribute("LOCALE");			
			String encounterId = checkForNull(request.getParameter("visitId"));
			String patientId =checkForNull(request.getParameter("patientId"));
			String episodeType = checkForNull(request.getParameter("episodeType"));
			String payerGrpCode = checkForNull(request.getParameter("payer_grp_code"));
			String payerCode = checkForNull(request.getParameter("payer_code"));
			String policyTypeCode =checkForNull(request.getParameter("policy_type_code"));
			String claimId = checkForNull(request.getParameter("claimId"));
			String insuranceStatus = checkForNull(request.getParameter("insurance_Status"));
			String eligibleForResubmit = checkForNull(request.getParameter("eligible_For_Resubmit"));
			String billNo = checkForNull(request.getParameter("bill_no"));
			String docGenFromDt = checkForNull(request.getParameter("doc_Gen_From_Dt"));
			String docGenToDt = checkForNull(request.getParameter("doc_Gen_To_Dt"));
			String responseLevel = checkForNull(request.getParameter("responseLevel"));
			String billDurFromDt = checkForNull(request.getParameter("bill_Dur_From_Dt"));
			String billDurToDt = checkForNull(request.getParameter("bill_Dur_To_Dt"));
			String encounterFromDate = checkForNull(request.getParameter("encounter_From_Date"));
			String encounterToDate = checkForNull(request.getParameter("encounter_To_Date"));
			String rcmTransFieldsMOHYN = checkForNull(request.getParameter("rcmTransFieldsMOHYN"));  //V240417
			String submissionType      = checkForNull(request.getParameter("submissionType"));    // MOHE-CRF-0166.3
			Map insStatusListMoh = null;
			insStatusListMoh = (Map) BLHelper.getListOfItems(con, "BL", "L_INS_RCM_STATUS", locale); //V240417
			int column_count = 1;
			String payer_Group = "", payer = "", policy_type = "", visit_Dt_Admit_Dt = "";
			String checkout_Dis_Dt = "";
			String patient_Name = "", bill_Doc_Type_Code = "", bill_Number = "", bill_Net_Amount = "", approved_Amt = "", receipt_Doc_Ref_No = "";
			String remarks = "", claim_Status = "", membershipNo = "", claim_Status_desc = "", resubmit_yn = "", eligible_For_Resubmit = "N", claim_finalized_yn = "";
			String req_Id = "",res_Id = "",first_Req_Id = "",claim_First_Req_Id = "",claim_Req_Id = "",claim_Res_Id = "",claim_Com_Res_Id = "", com_Res_Id = "",encounter_Id = "";
			int bill_tot_rec = 0;
			int appr_tot_rec = 0;
			String var = "ApprDocNum_";
			String var1 = "BillNum_";
			String disabled = "";
			String listOfApprDocNum = "";
			String filePath="";
			String pathExist="";
			String writeAccess="";
			String supp_doc_path="";
			String sql_for_export="";
			CurrencyFormat cf1 = new CurrencyFormat();	
			boolean amountRoundOff = true;
			int noofdecimal=2;
			String offline_claim_path=""; //Added by Khaled For MOHE-CRF-0166.3
			String preAuth_split_checker=""; //V240826
			String claim_sub_type="";//V240925	
			String claim_type="", pre_auth_ref_no="",claimTypeCode="",batchId=""; //V240826
			

            _bw.write(_wl_block4Bytes, _wl_block4);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	try{
			// Query to get file path for copying uploaded doc STARTS here 
			String sqlFilePath = "select record_appr_doc_path from bl_parameters where OPERATING_FACILITY_ID = ? ";
			pstmt = con.prepareStatement(sqlFilePath);
			pstmt.setString(1,facilityId);
			rst = pstmt.executeQuery();
			while(rst.next())
			{
				filePath = rst.getString(1) == null ? "" : rst.getString(1);
			}
			System.out.println("filePath in jsp "+filePath);
		/*	if(rst != null) rst.close();
			if(pstmt2 != null) pstmt2.close(); 
			*/
		//	filePath = filePath.replace("\\", "/");
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
			System.out.println("eclaim filePath after:" + filePath);
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in try of BLRCMTransGenerateBillResult.jsp --"+e.toString());
			e.printStackTrace();
		}
	
	try{
		pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
			rst = pstmt.executeQuery();	
			if ( rst != null && rst.next()) {
				if(rst.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
					amountRoundOff = false;
				}
			}

			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rst = pstmt.executeQuery();	
			while(rst.next())
			{
				noofdecimal  =  rst.getInt(1);		
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in try of BLRCMTransGenerateBillResult.jsp for currency setup --"+e.toString());
			e.printStackTrace();
		}
		
	// Added By Khaled for MOHE-CRF-0166.3 US005	
	try{
			pstmt = con.prepareStatement("select OFFLINE_CLAIM_PATH from RCM_PARAMETERS where operating_facility_id= ?");
			pstmt.setString(1,facilityId);
			rst = pstmt.executeQuery();	
			if ( rst != null && rst.next()) {
				offline_claim_path=checkForNull(rst.getString("OFFLINE_CLAIM_PATH"));
					
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in try of BLRCMTransGenerateBillResult.jsp for getting offline claim path --"+e.toString());
			e.printStackTrace();
		}
	
	
	

            _bw.write(_wl_block8Bytes, _wl_block8);
			
		try
		{
			column_count = 1;
			sql = "SELECT hdr.claim_id as claim_Id, hdr.cust_group_code as  cust_group_code,"+
				"DECODE (hdr.cust_group_code,'**', 'All Payer Group',(SELECT grp.long_desc FROM ar_cust_group grp WHERE "+
				"grp.cust_group_code =  hdr.cust_group_code)) payer_Group, "+
				"hdr.cust_code as cust_code,DECODE (hdr.cust_code,'**', 'All Payer',(SELECT cust.long_name FROM ar_customer cust WHERE "+
				"cust.cust_code = hdr.cust_code)) payer, "+
				"hdr.POLICY_TYPE_CODE as POLICY_TYPE_CODE,DECODE (hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc FROM bl_ins_policy_types pol "+
				"where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )) policy_type, "+
				"hdr.episode_type as episode_Type, hdr.encounter_id as encounter_ID, "+
				"to_char(hdr.visit_adm_date_time,'dd/MM/yyyy HH24:mi:ss') as visit_Dt_Admit_Dt, "+
				"to_char(hdr.chkout_dis_date_time,'dd/MM/yyyy HH24:mi:ss') as checkout_Dis_Dt, "+
				"hdr.patient_id as patient_ID, "+
				"(SELECT patient_name FROM mp_patient WHERE patient_id = hdr.patient_id) patient_Name, "+
				"hdr.bill_doc_type_code as bill_Doc_Type_Code, "+
				"hdr.bill_doc_num as bill_Number, "+
				"hdr.bill_net_amount as bill_Net_Amount, "+
				"hdr.approved_amt as approved_Amt, "+
				"hdr.receipt_ref_num as receipt_Doc_Ref_No, "+
				"hdr.remarks as remarks, "+
				"hdr.claim_status as claim_Status, "+
				"c.LIST_ELMT_LABEL as claim_status_desc, "+
				"hdr.MEMBERSHIP_NO as membership_no, hdr.supp_doc_path as supp_doc_path, hdr.resubmit_yn as resubmit_yn,hdr.claim_finalized_yn as claim_finalized_yn, hdr.INT_FIRST_REQUEST_ID as first_request_id, hdr.INT_REQUEST_ID as request_id, hdr.INT_RESPONSE_ID as response_id, "+
				"hdr.claim_type as claim_type ,"+ 			//V240826
				"(select short_desc from BL_CLAIM_TYPE lst where hdr.claim_type=lst.claim_type) claim_type_desc, "+ 			//V240826
				"hdr.preauth_reference as preauth_ref,"+ 
				"hdr.INT_CLAIM_FIRST_REQUEST_ID as claim_first_request_id, hdr.INT_CLAIM_REQUEST_ID as claim_request_id, hdr.INT_CLAIM_RESPONSE_ID as claim_response_id, hdr.INT_CLAIM_COM_RESPONSE_ID as claim_com_response_id "+
				"FROM bl_claim_bill_dtl hdr, sm_list_item c  "+
				"WHERE hdr.operating_facility_id = ? "+
				"AND hdr.claim_status = c.LIST_ELMT_VALUE "+
				"AND c.MODULE_ID = 'BL' ";
				
				
				//sql_for_export = " WHERE hdr.operating_facility_id = '"+facilityId+"' AND hdr.claim_status = c.LIST_ELMT_VALUE AND c.MODULE_ID = 'BL' ";
				if(rcmTransFieldsMOHYN.equals("N")){
					sql = sql + " AND c.LIST_REF = 'L_INS_CLAIM_STATUS' " ;
				} else {
					sql = sql + " AND c.LIST_REF = 'L_INS_RCM_STATUS' " ;
					//sql_for_export = sql_for_export +  "AND c.LIST_REF = 'L_INS_RCM_STATUS' ";
				}
						
				
				if("C".equals(responseLevel)){
					if("B".equals(insuranceStatus)){
						sql = sql + " and (hdr.claim_status = ? or hdr.claim_status = ? )";
						sql_for_export = sql_for_export + " and (hdr.claim_status = 'R' or hdr.claim_status = 'L' ) )";
					}else{
						sql = sql + " and hdr.claim_status = ?  ";
						sql_for_export = sql_for_export + " and (hdr.claim_status = '"+insuranceStatus+"' ) ";
					}
				}
					 
				if("S".equals(responseLevel)){
					sql = sql + " and exists (select 1 from bl_claim_service_dtl a "+
						" WHERE a.operating_facility_id = hdr.operating_facility_id "+
						"   AND a.bill_doc_type_code    = hdr.bill_doc_type_code "+
						"   AND a.bill_doc_num          = hdr.bill_doc_num ";
						
					sql_for_export = sql_for_export + 	" and exists (select 1 from bl_claim_service_dtl a "+
						" WHERE a.operating_facility_id = hdr.operating_facility_id "+
						"   AND a.bill_doc_type_code    = hdr.bill_doc_type_code "+
						"   AND a.bill_doc_num          = hdr.bill_doc_num ";
					
					
					if("B".equals(insuranceStatus)){
						sql = sql + " and (a.claim_status = ? or a.claim_status = ? ) ) "; 
						sql_for_export = sql_for_export + " and (a.claim_status = 'R' or a.claim_status = 'L' ) ) ";
					}else{
						sql = sql + " and a.claim_status = ? ) ";
						sql_for_export = sql_for_export + " and a.claim_status = '"+insuranceStatus+"' ) ";
					}
				//	else
					//	sql = sql + ")" ;
				
				}
				
				if(!"".equals(billNo)){
					sql = sql + " and hdr.BILL_DOC_TYPE_CODE = substr(?,1,instr(?,'/')-1) and hdr.bill_doc_num = substr(?,instr(?,'/')+1)  ";
					sql_for_export = sql_for_export +  " and hdr.BILL_DOC_TYPE_CODE = substr('"+billNo+"',1,instr('"+billNo+"','/')-1) and hdr.bill_doc_num = substr('"+billNo+"',instr('"+billNo+"','/')+1)  ";
				}
				
				if(!"".equals(docGenFromDt) && !"".equals(docGenToDt)){
					sql = sql + " and (trunc(hdr.supp_doc_gen_date) between NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
						" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
						" ,'DD-MON-YYYY HH24:MI:SS'))) ";	

					sql_for_export = sql_for_export + " and (trunc(hdr.supp_doc_gen_date) between NVL((to_date('"+docGenFromDt+"','DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00'" +   " ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( '"+docGenToDt+"' ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
						" ,'DD-MON-YYYY HH24:MI:SS'))) ";
				}
				
				if(!"".equals(billDurFromDt) && !"".equals(billDurToDt)){
					sql = sql + " and (trunc(hdr.bill_date) between NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
						" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
						" ,'DD-MON-YYYY HH24:MI:SS'))) ";	
					sql_for_export = sql_for_export + " and (trunc(hdr.bill_date) between NVL((to_date( '"+billDurFromDt+"' ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
						" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( '"+billDurToDt+"' ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
						" ,'DD-MON-YYYY HH24:MI:SS'))) ";
				}
				
				if(!"".equals(encounterFromDate) && !"".equals(encounterToDate)){
					sql = sql + " and (trunc(hdr.VISIT_ADM_DATE_TIME) between NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
						" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
						" ,'DD-MON-YYYY HH24:MI:SS'))) ";	
					sql_for_export = sql_for_export + " and (trunc(hdr.VISIT_ADM_DATE_TIME) between NVL((to_date( '"+encounterFromDate+"' ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
						" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( '"+encounterToDate+"' ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
						" ,'DD-MON-YYYY HH24:MI:SS'))) ";	
				}
				
				if("Y".equals(eligibleForResubmit)){
					sql = sql + " and hdr.resubmit_yn = ?  ";
					sql_for_export = sql_for_export + " and hdr.resubmit_yn = '"+eligibleForResubmit+"'  ";
				}
				
				if(!"".equals(patientId)){
					sql = sql + " and hdr.patient_id = ?  ";
					sql_for_export = sql_for_export + " and hdr.patient_id = '"+patientId+"'  ";
				}
				
				if(!"".equals(payerGrpCode)){
					sql = sql + " and (hdr.cust_group_code = nvl(?,hdr.cust_group_code)) ";
					sql_for_export = sql_for_export + " and (hdr.cust_group_code = nvl('"+payerGrpCode+"',hdr.cust_group_code)) ";
				}
		
				if(!"".equals(payerCode)){
					sql = sql + " and (hdr.cust_code = nvl(?,hdr.cust_code)) ";
					sql_for_export = sql_for_export + " and (hdr.cust_code = nvl('"+payerCode+"',hdr.cust_code)) ";
				}
				
				if(!"".equals(policyTypeCode)){
					sql = sql + " and (hdr.policy_type_code = nvl(?,hdr.policy_type_code)) ";
					sql_for_export = sql_for_export + " and (hdr.policy_type_code = nvl('"+policyTypeCode+"',hdr.policy_type_code)) ";
				}
				
				if(!"".equals(encounterId)){
					sql = sql + " and (hdr.encounter_id = nvl(?,hdr.encounter_id)) ";
					sql_for_export = sql_for_export + " and (hdr.encounter_id = nvl('"+encounterId+"',hdr.encounter_id)) ";
				}

				if(!"".equals(claimId)){
					sql = sql + " and (hdr.claim_id = nvl(?,hdr.claim_id)) ";
					sql_for_export = sql_for_export + " and (hdr.claim_id = nvl('"+claimId+"',hdr.claim_id)) ";
				}
				if(!"".equals(episodeType)){
					sql = sql + " and hdr.EPISODE_TYPE = nvl(?,hdr.EPISODE_TYPE) ";
				}
				if("Y".equals(submissionType)){
					sql = sql + " and (hdr.SUBMISSION_OFFLINE_YN = nvl(?,hdr.SUBMISSION_OFFLINE_YN)) ";
					sql_for_export = sql_for_export + " and (hdr.SUBMISSION_OFFLINE_YN = nvl('"+submissionType+"',hdr.SUBMISSION_OFFLINE_YN)) ";
				}
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(column_count,facilityId);
										
				if("C".equals(responseLevel)){
					if("B".equals(insuranceStatus)){
						pstmt.setString(++column_count,"R");
						pstmt.setString(++column_count,"L");
					}else
						pstmt.setString(++column_count,insuranceStatus);
				}						
				if("S".equals(responseLevel)){
					if("B".equals(insuranceStatus)){
						pstmt.setString(++column_count,"R");
						pstmt.setString(++column_count,"L");
					}else
						pstmt.setString(++column_count,insuranceStatus);
				}	
				if(!"".equals(billNo)){
						pstmt.setString(++column_count,billNo);
						pstmt.setString(++column_count,billNo);
						pstmt.setString(++column_count,billNo);
						pstmt.setString(++column_count,billNo);
				}if(!"".equals(docGenFromDt) && !"".equals(docGenToDt)){
						pstmt.setString(++column_count,docGenFromDt);
						pstmt.setString(++column_count,docGenToDt);
				}if(!"".equals(billDurFromDt) && !"".equals(billDurToDt)){
						pstmt.setString(++column_count,billDurFromDt);
						pstmt.setString(++column_count,billDurToDt);
				}if(!"".equals(encounterFromDate) && !"".equals(encounterToDate)){
						pstmt.setString(++column_count,encounterFromDate);
						pstmt.setString(++column_count,encounterToDate);
				}							
				if("Y".equals(eligibleForResubmit)){
						pstmt.setString(++column_count,eligibleForResubmit);
				}
				if(!"".equals(patientId))
						pstmt.setString(++column_count,patientId);
				if(!"".equals(payerGrpCode))
					pstmt.setString(++column_count,payerGrpCode);
				if(!"".equals(payerCode))
						pstmt.setString(++column_count,payerCode);
				if(!"".equals(policyTypeCode))
					pstmt.setString(++column_count,policyTypeCode);
				if(!"".equals(encounterId))
					pstmt.setString(++column_count,encounterId);
				if(!"".equals(claimId))
					pstmt.setString(++column_count,claimId);
				if(!"".equals(episodeType))
					pstmt.setString(++column_count,episodeType);
				
				if("Y".equals(submissionType))
					pstmt.setString(++column_count,submissionType);
				
				System.err.println("Sql is: "+sql);
				
			
				System.err.println("sql_for_export is: "+sql_for_export);
									
				rst1 = pstmt.executeQuery();		
				while ( rst1.next() )
				{
					
					if(bill_tot_rec==0){
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

					
					}
					disabled = "disabled";
					claimId = checkForNull(rst1.getString("claim_Id"));
					payer_Group = checkForNull(rst1.getString("payer_Group"));
					payer = checkForNull(rst1.getString("payer"));
					policy_type = checkForNull(rst1.getString("policy_type"));
					payerGrpCode = checkForNull(rst1.getString("cust_group_code"));
					payerCode = checkForNull(rst1.getString("cust_code"));
					policyTypeCode = checkForNull(rst1.getString("POLICY_TYPE_CODE"));
					episodeType = checkForNull(rst1.getString("episode_Type"));
					encounter_Id = checkForNull(rst1.getString("encounter_ID"));
					visit_Dt_Admit_Dt = checkForNull(rst1.getString("visit_Dt_Admit_Dt"));
					checkout_Dis_Dt = checkForNull(rst1.getString("checkout_Dis_Dt"));
					patientId = checkForNull(rst1.getString("patient_ID"));
					patient_Name = checkForNull(rst1.getString("patient_Name"));
					bill_Doc_Type_Code = checkForNull(rst1.getString("bill_Doc_Type_Code"));
					bill_Number = checkForNull(rst1.getString("bill_Number"));
					bill_Net_Amount = checkForNull(rst1.getString("bill_Net_Amount"));
					if(amountRoundOff) {
						bill_Net_Amount = cf1.formatCurrency(bill_Net_Amount, noofdecimal);
					} else {
						bill_Net_Amount = BLReportIdMapper.truncateUptoTwoDecimal(bill_Net_Amount, noofdecimal);	
					}
					approved_Amt = checkForNull(rst1.getString("approved_Amt"));
					if(amountRoundOff) {
						approved_Amt = cf1.formatCurrency(approved_Amt, noofdecimal);
					} else {
						approved_Amt = BLReportIdMapper.truncateUptoTwoDecimal(approved_Amt, noofdecimal);	
					}
					receipt_Doc_Ref_No = checkForNull(rst1.getString("receipt_Doc_Ref_No"));
					remarks = checkForNull(rst1.getString("remarks"));
					claim_Status = checkForNull(rst1.getString("claim_Status"));
					membershipNo = checkForNull(rst1.getString("membership_no"));
					supp_doc_path = checkForNull(rst1.getString("supp_doc_path"));	
					resubmit_yn = checkForNull(rst1.getString("resubmit_yn"));
					claim_finalized_yn = checkForNull(rst1.getString("claim_finalized_yn"));
					
					req_Id = checkForNull(rst1.getString("request_id"));
					res_Id = checkForNull(rst1.getString("response_id"));
					claim_First_Req_Id = checkForNull(rst1.getString("claim_first_request_id"));
					claim_Req_Id = checkForNull(rst1.getString("claim_request_id"));
					claim_Res_Id = checkForNull(rst1.getString("claim_response_id"));
					claim_Com_Res_Id = checkForNull(rst1.getString("claim_com_response_id"));
					first_Req_Id = checkForNull(rst1.getString("first_request_id"));
				//	com_Res_Id = checkForNull(rst1.getString("com_Res_Id"));
					com_Res_Id = "";
					claim_type= checkForNull(rst1.getString("claim_type_desc"));
					claimTypeCode= checkForNull(rst1.getString("claim_type"));
					pre_auth_ref_no= checkForNull(rst1.getString("preauth_ref"));
					
					if("Y".equals(resubmit_yn) && ("".equals(claim_finalized_yn) || "N".equals(claim_finalized_yn)) && ("L".equals(claim_Status) || "R".equals(claim_Status)))
						eligible_For_Resubmit = "Y";
					else
						eligible_For_Resubmit = "N";
					System.err.println("eligible_For_Resubmit: "+eligible_For_Resubmit);
					if(claim_Status.equalsIgnoreCase("N") || claim_Status.equalsIgnoreCase("L") || claim_Status.equalsIgnoreCase("R") || claim_Status.equalsIgnoreCase("E")){ 
						disabled = "";
					}
					if(rcmTransFieldsMOHYN.equals("Y")){
						if(insStatusListMoh != null){
							Iterator it = insStatusListMoh.keySet().iterator();
							while(it.hasNext()){
								String key=(String)it.next();
								if(key.equals(claim_Status))
									claim_Status_desc = (String)insStatusListMoh.get(key);
							}
						}
					}
											
					System.err.println("disabled is: "+disabled);
					System.err.println("insuranceStatus is: "+insuranceStatus);
					System.err.println("supp_doc_path is: "+supp_doc_path);
					System.err.println("bill_tot_rec is: "+bill_tot_rec);
					System.err.println("claim_Status_desc is: "+claim_Status_desc);
					//Added By Khaled Samir
					try{
					//chkstmt = con.prepareStatement("select SPLIT_BY_PREAUTH_REF_YN,CLAIM_RESUBMISSION_TYPE from BL_CLAIM_TYPE_SETUP where cust_group_code=? and cust_code=? and policy_type_code=? and operating_facility_id=?");
						chkstmt = con.prepareCall("{call bl_insu_dashboard.bl_get_calim_type_param(?,?,?,?,?,?,?)}");
						chkstmt.setString(1,facilityId);
						chkstmt.setString(2,payerGrpCode);
						chkstmt.setString(3,payerCode);
						chkstmt.setString(4,policyTypeCode);
						chkstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
						chkstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						chkstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						chkstmt.execute();
						preAuth_split_checker 		= chkstmt.getString(5);
						claim_sub_type 	= chkstmt.getString(6);
						System.err.println("preAuth_split_checker after proc: "+ preAuth_split_checker);
						System.err.println("CLAIM_RESUBMISSION_TYPE: "+ claim_sub_type);
						if(!preAuth_split_checker.equals("Y")){
							pre_auth_ref_no="";
						}
					/* 	if ( chkrst != null && chkrst.next()) {
							preAuth_split_checker= checkForNull(chkrst.getString("SPLIT_BY_PREAUTH_REF_YN"));
							CLAIM_RESUBMISSION_TYPE= checkForNull(chkrst.getString("CLAIM_RESUBMISSION_TYPE"));
							System.err.println("preAuth_split_checker: "+ preAuth_split_checker);
							System.err.println("CLAIM_RESUBMISSION_TYPE: "+ CLAIM_RESUBMISSION_TYPE);
							if(!preAuth_split_checker.equals("Y")){
								pre_auth_ref_no="";
							}
							
						} */
							
						}
						catch(Exception e)
						{
							System.out.println("Exception in try of BLRCMTransGenerateBillResult1.jsp for getting split_by_preAuth_ref_yn --"+e.toString());
							e.printStackTrace();
						}				
				

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bill_tot_rec ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bill_tot_rec ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bill_tot_rec ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(claimId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(payer_Group));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(visit_Dt_Admit_Dt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkout_Dis_Dt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bill_Doc_Type_Code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bill_Number));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bill_Net_Amount));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(approved_Amt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(receipt_Doc_Ref_No));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bill_Doc_Type_Code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bill_Number));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((remarks!= null && !remarks.equals(""))?remarks:"..."));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(claim_Status_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( "N".equals(submissionType) ? "online" : ("Y".equals(submissionType) ? "offline" : ".....") ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(claimId));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bill_Doc_Type_Code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bill_Number));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(supp_doc_path));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bill_tot_rec ));
            _bw.write(_wl_block67Bytes, _wl_block67);
if("Y".equals(eligible_For_Resubmit)){
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(payer_Group));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(payerGrpCode));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(payerCode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(policy_type));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(policyTypeCode));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(visit_Dt_Admit_Dt));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(checkout_Dis_Dt));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bill_Net_Amount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(approved_Amt));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(receipt_Doc_Ref_No));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(claim_Status));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(responseLevel));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(membershipNo));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(resubmit_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(claim_finalized_yn));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(req_Id));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(res_Id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(first_Req_Id));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(claim_First_Req_Id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(claim_Req_Id));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(claim_Res_Id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(claim_Com_Res_Id));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(com_Res_Id));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(claimTypeCode));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pre_auth_ref_no));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(claim_type));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(claim_sub_type));
            _bw.write(_wl_block140Bytes, _wl_block140);

				bill_tot_rec++;		
					
				}

            _bw.write(_wl_block141Bytes, _wl_block141);
					
		
		if(bill_tot_rec == 0){

            _bw.write(_wl_block142Bytes, _wl_block142);

		}

            _bw.write(_wl_block143Bytes, _wl_block143);

		}catch(Exception e){
			System.err.println("Query Result Exception= "+e.toString());
		}

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(	bill_tot_rec));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(	bill_tot_rec));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(insuranceStatus));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(filePath));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(pathExist));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(writeAccess));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(params));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(responseLevel));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(rcmTransFieldsMOHYN));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(eligible_For_Resubmit));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(sql_for_export));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(offline_claim_path));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(preAuth_split_checker ));
            _bw.write(_wl_block159Bytes, _wl_block159);
					
		
		

            _bw.write(_wl_block160Bytes, _wl_block160);

	

            _bw.write(_wl_block161Bytes, _wl_block161);
	
		}catch(Exception e){
			out.println("Exception in BLRCMTransGenerateBillResult.jsp: "+e);
			System.err.println("Exception in BLRCMTransGenerateBillResult.jsp: "+e);
		}finally{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			if(chkstmt!=null)	chkstmt.close();
			if(chkrst!=null)	chkrst.close();
			ConnectionManager.returnConnection(con,request);		
		}

            _bw.write(_wl_block162Bytes, _wl_block162);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.claim_id.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admit.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CheckOut.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Discharge.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_NO.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NET_BILL_AMT.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Approved_Amt.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Payment_Reference.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Remarks.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CLAIM_STATUS.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.submissionType.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UploadDocuments.label", java.lang.String .class,"key"));
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
