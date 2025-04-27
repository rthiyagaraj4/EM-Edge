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

public final class __blrcmtransgeneratebillresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLRCMTransGenerateBillResult.jsp", 1742752541852L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/RCMTransactions.js\"></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n<style>\n.bordered-table {\n    border-collapse: collapse;\n    border: 1px solid #e0e0e0;\n    width: 100%;\n}\n\n.bordered-table th, .bordered-table td {\n    border: 1px solid #e0e0e0;\n    padding: 8px;\n}\n\n.colored-cell {\n    background-color: yellow; /* Default background color */\n}\n\n.no-border td {\n    border: none; /* Remove borders for cells in the selected row */\n}\n</style>\n</HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n<script>\nfunction handleClick(row){\n\tvar tot_rec = document.getElementById(\"appr_tot_rec\").value;\n\tvar img;\n\tfor(var i=1;i<=tot_rec;i++)\n\t{\n\t\tif(i == row){\n\t\t\tif(document.getElementById(\"appr_\"+i).style.display==\"none\"){\n\t\t\t\tdocument.getElementById(\"appr_\"+i).style.display = \"inline\";\n\t\t\t\timg = document.getElementById(\"gifImage_\"+i);\n\t\t\t\timg.src = \"../../eCommon/images/nolines_minus.gif\";\n\t\t\t}else{\n\t\t\t\tdocument.getElementById(\"appr_\"+i).style.display = \"none\";\n\t\t\t\timg = document.getElementById(\"gifImage_\"+i);\n\t\t\t\timg.src = \"../../eCommon/images/nolines_plus.gif\";\n\t\t\t}\n\t\t}\n\t\telse{\n\t\t\tdocument.getElementById(\"appr_\"+i).style.display = \"none\";\n\t\t\timg = document.getElementById(\"gifImage_\"+i);\n\t\t\timg.src = \"../../eCommon/images/nolines_plus.gif\";\n\t\t}\n\t}\n}\n\nfunction loadBtnFrame(){\n\tvar listOfApprDocNum = document.getElementById(\"listOfApprDocNum\").value;\n\tvar insuranceStatus = document.getElementById(\"insuranceStatus\").value;\n\tvar claims_services_level = document.getElementById(\"claims_services_level\").value;\n\tvar appr_tot_rec = document.getElementById(\"appr_tot_rec\").value;\n\t\n\tif(appr_tot_rec > 0)\n\t\tparent.frames[3].document.location.href = \"../../eBL/jsp/BLRCMTransResultQryBtn.jsp?listOfApprDocNum=\"+listOfApprDocNum+\"&p_ins_status=\"+insuranceStatus+\"&p_level_of_srch=\"+claims_services_level;\n\t\n}\n</script>\n    \n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onLoad=\"loadBtnFrame();\" >\n<form name=\"BLRCMTransGenerateBillRes\" id=\"BLRCMTransGenerateBillRes\" enctype=\"multipart/form-data\">\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n<TABLE class=\'grid\' border=1 width=\"100%\" cellspacing=0 cellpadding=3 align=\'center\'>\n\n\t\t<td class=\'columnheadercenter\' width=\"2%\"><input type=\"checkbox\" id=\"checkheader\" name=\"checkheader\" id=\"checkheader\" onclick=\"payerCheck(this)\" value=\"\"/></td>\n\t\t<td class=\'columnheadercenter\'  width=\"5%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=\'columnheadercenter\'  width=\"10%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=\'columnheadercenter\'  width=\"5%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td class=\'columnheadercenter\'  width=\"6%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/ ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td> \n\t\t<td class=\'columnheadercenter\'  width=\"6%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td class=\'columnheadercenter\'  width=\"7%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=\'columnheadercenter\'  width=\"9%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\t\n</TABLE>\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<table cellpadding=\'2\' cellspacing=0 width=\"100%\" align=\"center\">\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<input type=\"checkbox\" id=\"check_payer";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" name=\"check_payer";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onclick=\"check_payer(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\');\" value=\"\">\n\t\t\t\t\n\t\t\t\t<img src=\"../../eCommon/images/nolines_plus.gif\" alt=\"GIF Image\" id=\"gifImage_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onclick=\"handleClick(";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =")\">\n\t\t\t\t<label for=\"gifImage_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =")\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =":";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</label>\n\t\t\t\t<br>\n\t\t\t\t<div id=\"appr_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" name=\"appr_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" style=\'display:none\'>\n\t\t\t\t\t<input type=\"hidden\" id=\"appr_Num_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" name=\"appr_Num_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t\t\t\t\t<table align=\'center\'  cellpadding=3 cellspacing=1  width=\'100%\' id=\"panel_categories_table\" name=\"panel_categories_table\" id=\"panel_categories_table\" class=\"bordered-table\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr id=\'tr_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onClick = \"loadPolicyDetails(\'tr_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\" >   \n\t\t\t\t\t\t<td\t class=\'label\' id=\'td_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="_0\' width=\"2%\">&nbsp;</td>\n\t\t\t\t\t\t<td\t class=\'label\' id=\'td_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="_1\' width=\"5%\">\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" &nbsp;</td> \n\t\t\t\t\t\t<td  class=\'label\'\tid=\'td_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="_2\' width=\"10%\">\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="_3\' width=\"5%\"> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="_4\' width=\"6%\"> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" &nbsp;</td>\n\t\t\t\t\t\t<td  class=\'label\'\tid=\'td_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="_5\' width=\"6%\"> ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;</td> \n\t\t\t\t\t\t<td  class=\'label\'\tid=\'td_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="_6\' width=\"7%\"> ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="_7\' width=\"7%\"> ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="_8\' width=\"7%\">\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="_9\' width=\"5%\">  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="_10\' width=\"5%\"> ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="_11\' width=\"7%\"> ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="_12\' width=\"9%\"><a href=\"#\" name=\"remarks_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"remarks_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" onclick=\"callRemarkPopup(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\', \'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\',\'B\',\'\');\">     ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</a> &nbsp;</td> \n\t\t\t\t\t\t<td  class=\'label\'\tid=\'td_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="_13\' width=\"9%\"> ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t\t\t\t<input type=\"hidden\" id=\"claimID_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" name=\"claimID_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"patientId_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" name=\"patientId_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"apprDocRefNum_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" name=\"apprDocRefNum_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"billDocTypeCode_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" name=\"billDocTypeCode_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"billNum_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" name=\"billNum_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'label\' id=\'td_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="_14\' width=\"10%\">\n\t\t\t\t\t\t\t<input type=\"file\" name=\"patFile_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"patFile_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" value=\"\"  size=10 maxlength=40 onchange=\"getFileType(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\')\" onkeypress=\"return onkeyPressEvent(event);\" >\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t<input type=\"hidden\"   id=\"DocUplYN";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" \t\t\t\tname=\"DocUplYN";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"  \t\t\tvalue=\"N\" />\n\t\t\t\t\t\t<input type=\"hidden\" id=\"payerGrp_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" name=\"payerGrp_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"payerGrpCode_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" name=\"payerGrpCode_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"payer_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" name=\"payer_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"payerCode_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" name=\"payerCode_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"policyType_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" name=\"policyType_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"policyTypeCode_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" name=\"policyTypeCode_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"episodeType_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" name=\"episodeType_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"encounterId_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" name=\"encounterId_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"visitAdmitDt_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" name=\"visitAdmitDt_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"checkoutDiscDt_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" name=\"checkoutDiscDt_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" >\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" id=\"patientName_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" name=\"patientName_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"netBillAmt_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" name=\"netBillAmt_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"apprBillAmt_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" name=\"apprBillAmt_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"receiptDocRefNum_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" name=\"receiptDocRefNum_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"billRemarks_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" name=\"billRemarks_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"claimStatus_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" name=\"claimStatus_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"checkedStatus_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" name=\"checkedStatus_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" value=\"N\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"claimsServicesLevel_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" name=\"claimsServicesLevel_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"membershipNo_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" name=\"membershipNo_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" id=\"fileName_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" name=\"fileName_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" value=\"\" >\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\t\n\t\t\t</td>\n\t\t</tr>\n\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\t\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t<input type = \"hidden\" id = \"listOfApprDocNum\" name = \"listOfApprDocNum\" value = \"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" >\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' value=\'N\'>\n\t<input type=\'hidden\' name=\'rowClicked\' id=\'rowClicked\' value = \'\'>\n\t<input type=\"hidden\" name=\"State_dur_from\" id=\"State_dur_from\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t<input type=\"hidden\" name=\"State_dur_to\" id=\"State_dur_to\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t<input type = \"hidden\" id = \"tot_rec\" name = \"tot_rec\" value = \"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" >\n\t<input type = \"hidden\" id = \"appr_tot_rec\" name = \"appr_tot_rec\" value = \"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" >\n\t<input type = \"hidden\" id = \"bill_tot_rec\" name = \"bill_tot_rec\" value = \"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" >\n\t<input type = \"hidden\" id = \"p_action_id\" name = \"p_action_id\" value = \"\" >\n\t<input type = \"hidden\" id = \"insuranceStatus\" name = \"insuranceStatus\" value = \"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >\n\t<input type = \"hidden\" id = \"claims_services_level\" name = \"claims_services_level\" value = \"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n\t<input type=\'hidden\' name=\'filePath\' id=\'filePath\' id=\'filePath\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\t \n\t<input type=\'hidden\' name=\'pathExist\' id=\'pathExist\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\t\n\t<input type=\'hidden\' name=\'writeAccess\' id=\'writeAccess\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<input type=\'hidden\' name=\'called_from_dashboard_YN\' id=\'called_from_dashboard_YN\' id=\'called_from_dashboard_YN\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t<input type=\'hidden\' name=\'qry_search_params\' id=\'qry_search_params\' id=\'qry_search_params\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\n</table>\n\n";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\t\n<Script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\nparent.frames[3].document.location.href = \'../../eCommon/html/blank.html\';\t\n</script>\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n<Script>checkBoxEnableDisable(this);</script>\t\t\n</form>\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n</body>\t\n\t\n</HTML>\n\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		ResultSet rst1=null;

		try
		{
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			System.err.println("params IN BLRCMTransGenerateBillResult.jsp is: "+params);
			
			con=ConnectionManager.getConnection(request);
			String sql = "";
			
			String facilityId = (String)session.getAttribute("facility_id");
			String locale = (String)session.getAttribute("LOCALE");
			String called_from_dashboard_YN = request.getParameter("called_from_dashboard_YN");
			if(called_from_dashboard_YN == null || called_from_dashboard_YN.equals("")) called_from_dashboard_YN = "N";
			System.err.println(" called_from_dashboard_YN= "+called_from_dashboard_YN);
			
			String visitId = checkForNull(request.getParameter("visitId"));
			String patientId =checkForNull(request.getParameter("patientId"));
			String episodeType = checkForNull(request.getParameter("episodeType"));
			String payerGrpCode = checkForNull(request.getParameter("payer_grp_code"));
			String payerCode = checkForNull(request.getParameter("payer_code"));
			String policyTypeCode =checkForNull(request.getParameter("policy_type_code"));
			String apprDocRefNum = checkForNull(request.getParameter("apprDocRefNum"));
			String apprDocRefTypeCode = checkForNull(request.getParameter("approval_doc_ref_type_code"));
			String claimId = checkForNull(request.getParameter("claimId"));
			String StateDurFrom = checkForNull(request.getParameter("State_dur_from"));
			String StateDurTo =checkForNull(request.getParameter("State_dur_to"));
			String insuranceStatus = checkForNull(request.getParameter("insurance_Status"));
			String claims_services_level = checkForNull(request.getParameter("claims_services_level"));
			int column_count = 1;
			String payer_Group = "", payer = "", policy_type = "", visit_Dt_Admit_Dt = "";
			String checkout_Dis_Dt = "";
			String patient_Name = "", bill_Doc_Type_Code = "", bill_Number = "", bill_Net_Amount = "", approved_Amt = "", receipt_Doc_Ref_No = "";
			String remarks = "", claim_Status = "", membershipNo = "";
			int bill_tot_rec = 0;
			int appr_tot_rec = 0;
			String var = "ApprDocNum_";
			String var1 = "BillNum_";
			String disabled = "";
			String listOfApprDocNum = "";
			String filePath="";
			String pathExist="";
			String writeAccess="";
			CurrencyFormat cf1 = new CurrencyFormat();	
			boolean amountRoundOff = true;
			int noofdecimal=2;			
			

            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);

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
	
	
	try
	{
		sql = "SELECT (b.APPR_DOC_REF_TYPE_CODE||'/'||b.appr_doc_ref_number) as Appr_Doc_Ref_No, COUNT (*) as total "+
				"FROM BL_CLAIM_BILL_DTL b "+
				"WHERE b.operating_facility_id = ? ";				
				
		if(!"".equals(patientId)){
			sql = sql + " and b.patient_id = nvl(?,b.patient_id) ";
		}
		
		if(!"".equals(episodeType)){
			sql = sql + " and b.EPISODE_TYPE = nvl(?,b.EPISODE_TYPE) ";
		}
		
		if(!"".equals(visitId)){
			sql = sql + " and b.encounter_id = nvl(?,b.encounter_id) ";
		}
		
		if(!"".equals(payerGrpCode))
			sql = sql + " and (b.cust_group_code = nvl(?,b.cust_group_code)) ";
		
		if(!"".equals(payerCode))
			sql = sql + " and (b.cust_code = nvl(?,b.cust_code)) ";
		
		if(!"".equals(policyTypeCode))
			sql = sql + " and (b.policy_type_code = nvl(?,b.policy_type_code)) ";
		
		if(!"".equals(apprDocRefNum))
			sql = sql + " and (b.appr_doc_ref_number = nvl(?,b.appr_doc_ref_number)) ";
		
		if(!"".equals(apprDocRefTypeCode))
			sql = sql + " and (b.APPR_DOC_REF_TYPE_CODE = nvl(?,b.APPR_DOC_REF_TYPE_CODE)) ";
		
		if(!"".equals(claimId))
			sql = sql + " and (b.claim_id = nvl(?,b.claim_id)) ";
		
		if(!"".equals(StateDurFrom) && !"".equals(StateDurTo))
			sql = sql + " and (trunc(b.doc_ref_date) between NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
				" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
				" ,'DD-MON-YYYY HH24:MI:SS'))) ";					
				
		if("C".equals(claims_services_level)){
			if(!"**".equals(insuranceStatus))
				sql = sql + " and b.claim_status = ?  ";
		}

		if("S".equals(claims_services_level)){
			sql = sql + " and exists (select 1 from bl_claim_service_dtl a "+
				" WHERE a.operating_facility_id = b.operating_facility_id "+
				"   AND a.bill_doc_type_code    = b.bill_doc_type_code "+
				"   AND a.bill_doc_num          = b.bill_doc_num ";
				
			if(!"**".equals(insuranceStatus))
				sql = sql + " and a.claim_status = ?  )";
			else
				sql = sql + ")" ;
		}
		sql = sql + "GROUP BY b.APPR_DOC_REF_TYPE_CODE,b.appr_doc_ref_number ORDER BY b.APPR_DOC_REF_TYPE_CODE,b.appr_doc_ref_number asc";
		
		pstmt = con.prepareStatement(sql);
		
		System.err.println("patientId: "+patientId);
		System.err.println("apprDocRefNum: "+apprDocRefNum);
		System.err.println("claimId: "+claimId);
		
		pstmt.setString(column_count,facilityId);
		
		if(!"".equals(patientId))
			pstmt.setString(++column_count,patientId);
		if(!"".equals(episodeType))
			pstmt.setString(++column_count,episodeType);
		if(!"".equals(visitId))
			pstmt.setString(++column_count,visitId);
		if(!"".equals(payerGrpCode))
			pstmt.setString(++column_count,payerGrpCode);
		if(!"".equals(payerCode))
			pstmt.setString(++column_count,payerCode);
		if(!"".equals(policyTypeCode))
			pstmt.setString(++column_count,policyTypeCode);
		if(!"".equals(apprDocRefNum))
			pstmt.setString(++column_count,apprDocRefNum);
		if(!"".equals(apprDocRefTypeCode))
			pstmt.setString(++column_count,apprDocRefTypeCode);
		if(!"".equals(claimId))
			pstmt.setString(++column_count,claimId);
		if(!"".equals(StateDurFrom) && !"".equals(StateDurTo)){
			pstmt.setString(++column_count,StateDurFrom);
			pstmt.setString(++column_count,StateDurTo);
		}
		if("C".equals(claims_services_level)){
			if(!"**".equals(insuranceStatus))
				pstmt.setString(++column_count,insuranceStatus);
		}if("S".equals(claims_services_level)){
			if(!"**".equals(insuranceStatus))
				pstmt.setString(++column_count,insuranceStatus);
		}
		System.err.println("Sql is: "+sql);
		
		rst = pstmt.executeQuery();		

		while ( rst.next() )
		{
			apprDocRefNum = checkForNull(rst.getString("Appr_Doc_Ref_No"));
			
			int cnt = rst.getInt("total");	
			appr_tot_rec++;
			
			if(appr_tot_rec == 1 )
				listOfApprDocNum = apprDocRefNum;
			else
				listOfApprDocNum = listOfApprDocNum + "~~" + apprDocRefNum;						
			
			System.err.println("Manivel:"+listOfApprDocNum);
			if(appr_tot_rec == 1 ){

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

			}	

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(apprDocRefNum));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(apprDocRefNum));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(appr_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(apprDocRefNum));
            _bw.write(_wl_block34Bytes, _wl_block34);
			
							System.err.println("apprDocRefNum is: "+apprDocRefNum);
							try
							{
								column_count = 1;
								sql = "SELECT b.claim_id as claim_Id, b.cust_group_code as  cust_group_code,"+
										"DECODE (b.cust_group_code,'**', 'All Payer Group',(SELECT grp.long_desc FROM ar_cust_group grp WHERE "+
										"grp.cust_group_code =  b.cust_group_code)) payer_Group, "+
										"b.cust_code as cust_code,DECODE (b.cust_code,'**', 'All Payer',(SELECT cust.long_name FROM ar_customer cust WHERE "+
										"cust.cust_code = b.cust_code)) payer, "+
										"b.POLICY_TYPE_CODE as POLICY_TYPE_CODE,DECODE (b.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc FROM bl_ins_policy_types pol "+
										"where pol.policy_type_code = b.policy_type_code AND pol.operating_facility_id  = b.operating_facility_id )) policy_type, "+
										"b.episode_type as episode_Type, b.encounter_id as encounter_ID, "+
										"to_char(b.visit_adm_date_time,'dd/MM/yyyy HH24:mi:ss') as visit_Dt_Admit_Dt, "+
										"to_char(b.chkout_dis_date_time,'dd/MM/yyyy HH24:mi:ss') as checkout_Dis_Dt, "+
										"b.patient_id as patient_ID, "+
										"(SELECT patient_name FROM mp_patient WHERE patient_id = b.patient_id) patient_Name, "+
										"b.bill_doc_type_code as bill_Doc_Type_Code, "+
										"b.bill_doc_num as bill_Number, "+
										"b.bill_net_amount as bill_Net_Amount, "+
										"b.approved_amt as approved_Amt, "+
										"b.receipt_ref_num as receipt_Doc_Ref_No, "+
										"b.remarks as remarks, "+
										"b.claim_status as claim_Status, "+
										"c.LIST_ELMT_LABEL as claim_status_desc, "+
										"b.MEMBERSHIP_NO as membership_no "+
										"FROM bl_claim_bill_dtl b, sm_list_item c  "+
										"WHERE b.operating_facility_id = ? "+
										"AND b.claim_status = c.LIST_ELMT_VALUE "+
										"AND c.MODULE_ID = 'BL' "+
										"AND c.LIST_REF = 'L_INS_CLAIM_STATUS' " +
										"AND (b.appr_doc_ref_type_code||'/'||b.appr_doc_ref_number) = nvl(?,(b.appr_doc_ref_type_code||'/'||b.appr_doc_ref_number))";
										
										if("C".equals(claims_services_level)){
											if(!"**".equals(insuranceStatus))
												sql = sql + " and b.claim_status = ?  ";
										}
					 

										if("S".equals(claims_services_level)){
											sql = sql + " and exists (select 1 from bl_claim_service_dtl a "+
												" WHERE a.operating_facility_id = b.operating_facility_id "+
												"   AND a.bill_doc_type_code    = b.bill_doc_type_code "+
												"   AND a.bill_doc_num          = b.bill_doc_num ";
												
											if(!"**".equals(insuranceStatus))
												sql = sql + " and a.claim_status = ? ) ";
											else
												sql = sql + ")" ;
											
										}
								
										
										pstmt = con.prepareStatement(sql);
										pstmt.setString(column_count,facilityId);
										pstmt.setString(++column_count,apprDocRefNum);
										
										if("C".equals(claims_services_level)){
											if(!"**".equals(insuranceStatus))
												pstmt.setString(++column_count,insuranceStatus);
										}if("S".equals(claims_services_level)){
											if(!"**".equals(insuranceStatus))
												pstmt.setString(++column_count,insuranceStatus);
										}
															
										System.err.println("Sql is: "+sql);
										
										rst1 = pstmt.executeQuery();		

										while ( rst1.next() )
										{
											disabled = "disabled";
											claimId = checkForNull(rst1.getString("claim_Id"));
											payer_Group = checkForNull(rst1.getString("payer_Group"));
											payer = checkForNull(rst1.getString("payer"));
											policy_type = checkForNull(rst1.getString("policy_type"));
											payerGrpCode = checkForNull(rst1.getString("cust_group_code"));
											payerCode = checkForNull(rst1.getString("cust_code"));
											policyTypeCode = checkForNull(rst1.getString("POLICY_TYPE_CODE"));
											episodeType = checkForNull(rst1.getString("episode_Type"));
											visitId = checkForNull(rst1.getString("encounter_ID"));
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
											
											if(claim_Status.equalsIgnoreCase("P") || claim_Status.equalsIgnoreCase("C")){ 
												disabled = "";
											}
											
												System.err.println("disabled is: "+disabled);
											System.err.println("insuranceStatus is: "+insuranceStatus);
									

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bill_tot_rec ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(appr_tot_rec ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bill_tot_rec ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(claimId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(payer_Group));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(visit_Dt_Admit_Dt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(checkout_Dis_Dt));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bill_Doc_Type_Code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bill_Number));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bill_Net_Amount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(approved_Amt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(receipt_Doc_Ref_No));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bill_Doc_Type_Code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bill_Number));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(apprDocRefNum));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((remarks!= null && !remarks.equals(""))?remarks:"..."));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(checkForNull(rst1.getString("claim_status_desc"))));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(claimId));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(apprDocRefNum));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bill_Doc_Type_Code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bill_Number));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(payer_Group));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(payerGrpCode));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(payerCode));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(policy_type));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(policyTypeCode));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(visit_Dt_Admit_Dt));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkout_Dis_Dt));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bill_Net_Amount));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(approved_Amt));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(receipt_Doc_Ref_No));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(claim_Status));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(claims_services_level));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(membershipNo));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bill_tot_rec));
            _bw.write(_wl_block117Bytes, _wl_block117);

						
												bill_tot_rec++;
											}

            _bw.write(_wl_block118Bytes, _wl_block118);

							}catch(Exception e){
								System.err.println("Query Result Exception= "+e.toString());
							}
												
					}
			}catch(Exception e){
				System.err.println("Query Result Exception= "+e.toString());
			}

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(listOfApprDocNum));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(StateDurFrom));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(StateDurTo));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(	bill_tot_rec));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(	appr_tot_rec));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(	bill_tot_rec));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(insuranceStatus));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(claims_services_level));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(filePath));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(pathExist));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(writeAccess));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(called_from_dashboard_YN));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(params));
            _bw.write(_wl_block134Bytes, _wl_block134);
					
		
		if(appr_tot_rec == 0){

            _bw.write(_wl_block135Bytes, _wl_block135);

		}

            _bw.write(_wl_block136Bytes, _wl_block136);
	
		}catch(Exception e){
			out.println("Exception in BLRCMTransGenerateBillResult.jsp: "+e);
			System.err.println("Exception in BLRCMTransGenerateBillResult.jsp: "+e);
		}finally{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(con,request);		
		}

            _bw.write(_wl_block137Bytes, _wl_block137);
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Receipt_Doc_Reference_No.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.approval_ref_no.label", java.lang.String .class,"key"));
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
