package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __reviewresultsdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ReviewResultsDetail.jsp", 1742364182000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n-----------------------------------------------------------------------\nDate       \t  Edit History  Name        Description\n-----------------------------------------------------------------------\n?             100         \t?            created\t\n05/07/2012    IN033610      Chowminya G\t Add Notification Alert in summary \t\t\t\t\t\t\t\t \n09/10/2012 \t  IN035654\t\tNijithas\t Attachment icon we get tool tip as �X-ray�. It should be \"Result\"\t\t\n03/06/2013\t  EMG   \t\tChowminya G\t  PACS LIVE issue\t \n22/06/2013    IN041006\t\tChowminya G\t  Review Results->Image hyperlink not displayed\t\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n08/09/2014  IN050936\t\tChowminya\t\t\t\t\t\t\t\t\t\tNone of the order retrieving any image from RIS/PACS but already having order image in PACS\n26/02/2018  IN066119\t\tRaja S\t\t26/02/2018\t\tRamesh G\t\tML-MMOH-CRF-1024\n07/06/2018\tIN067651\t\tRaja S\t\t07/06/2018\t\tRamesh G\t\tGHL-SCF-1338\n-----------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ReviewResults.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eCA/js/CAOpenExternalApplication.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \t<script>\n\t\tfunction alignWidth() {\n\t\t\tvar last=eval(document.getElementById(\'detailTab\').rows.length)-1;\n\t\t\t\tif(document.getElementById(\'detailTab\')!=null) {\n\t\t\t\t\tfor(i=0;i <document.getElementById(\'detailTab\').rows[last].cells.length;i++) {\n\t\t\t\t\t\tvar wid=document.getElementById(\'detailTab\').rows[last].cells[i].offsetWidth;\n\t\t\t\t\t\tvar wid1= parent.ReviewResultsHeader.document.getElementById(\'titleTab\').rows[0].cells[i].offsetWidth;\n\t\t\t\t\t\tif(eval(wid1) <eval(wid)){\n\t\t\t\t\t\t\tparent.ReviewResultsHeader.document.getElementById(\'titleTab\').rows[0].cells[i].width=wid;\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tdocument.getElementById(\'detailTab\').rows[last].cells[i].width = wid1;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t</script>\n\t \n</head>\n<body   onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">     \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\tparent.ReviewResultsSearch.document.review_result_search.search_btn.disabled =false;\n\t\t\tparent.ReviewResultsHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\t\tparent.ReviewResultsResult.location.href = \"../../eCommon/html/blank.html\"\n\t\t\tparent.ReviewResultsBtn.location.href = \"../../eCommon/html/blank.html\"\n\n\t\t</script>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<script>focusOnResult();</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<form name=\'review_results_dtl\' id=\'review_results_dtl\'  action=\"../../eOR/jsp/ReviewResultsDetail.jsp\" method=\"post\">\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" id=\'detailTab\' class=\"grid\" >\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t <!--\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="   \n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\t\t \n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="  \n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\t\n\t\t\t\t-->\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n  <input type=hidden name=\'hist_rec_type";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'hist_rec_type";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type=hidden name=\'contr_sys_id";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'contr_sys_id";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t<input type=hidden name=\'contr_sys_event_code";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'contr_sys_event_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=hidden name=\'accession_num";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'accession_num";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t<input type=hidden name=\'review_type";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'review_type";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t<input type=hidden name=\'result_str";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'result_str";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type=hidden name=\'create_date_time";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'create_date_time";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t<input type=hidden name=\'patient_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'patient_id";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t<input type=hidden name=\'event_code";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'event_code";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=hidden name=\'event_group";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'event_group";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=hidden name=\'event_class_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'event_class_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t<input type=hidden name=\'normalcy_ind";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'normalcy_ind";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t<input type=hidden name=\'normal_ind";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'normal_ind";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'> \n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<tr><Td colspan=\'9\' class =\'PATIENTLINECOLOROTHLANG\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</Td></tr>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t <tr> <Td colspan=\'9\' class =\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</Td></tr>\n\t\t  ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n       <tr>\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n                 <td width=\'7%\' id=\'status";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' title = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"><input type=checkbox name=\'chk";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'chk";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' onClick=\"clickChk(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\')\" value=\"\"><label id=\"remark_td";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"></label><input type=\'hidden\' name=\'review_remarks";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'review_remarks";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' value=\'\'></td>\n\t\t\t     <td width=\'22%\' class=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"><font size=1>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</font></td>\n\t\t\t     <td width=\'9.5%\' class=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</font></td>\n\t\t\t     <td width=\'10%\' class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</font></td>\n\t\t\t     ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t     <td width=\'10%\' class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</font> </td>\n\t\t\t     <td width=\'14%\' class=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" </font></td>\n\t   \t\t     <td width=\'14%\' class=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</font></td>\n\t   \t\t    <!--  <td id=\"remark_td";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" width=\'5.5%\' class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">&nbsp;</td> -->\n\t\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</font></td>\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t        <!--<table cellpadding=0 cellspacing=0 border=1 width=\"98%\" id=\'innerTab\' >-->\n                    ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t<TR>\n\t\t\t        <TR ><TD><input type=checkbox name=\'chkgrp";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' id=\'chkgrp";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'maingrp";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' onClick=\"checkgroup(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\')\" ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="  value=\'chk";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'  ></TD><!--IN066119 added check box-->\n\t\t\t        <TD colspan=\'9\' >\n                    <Font size=1>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</Font>\n                    </TD>\n                    </TR>\n\n\t\t\t        <TR>\n\t\t\t           ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t            <td width=\'7%\' class=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" > <input type=checkbox name=\'chk";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' onClick=\"javascript:clickChk(\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\')\" id=\'subgrp";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' value=\"\" ><input type=\'hidden\' name=\'headval";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' id=\'headval";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'><label id=\"remark_td";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' id=\'subgrp_remarks";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' value=\'\'></td><!-- Added for IN066119-->\n\t\t\t            <td width=\'22%\' class=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" ><font size=1>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</font></td>\n\t\t\t            <td width=\'9.5%\' class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</font></td>\n\t\t\t            <td width=\'10%\' class=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</font></td>\n\n\t\t\t            ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t            <td width=\'10%\' class=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</font> </td>\n\t\t\t            <td width=\'14%\' class=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" </font></td>\n\t\t\t            <td width=\'14%\' class=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</font></td>\n\t\t\t           <!--  <td width=\'5.5%\' id=\"remark_td";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" class=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' title =\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" >&nbsp;</td> -->\n\t\t\t\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</font>&nbsp;</td>\n\t\t\t        </TR>\n                   ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n                   <TR>\n\t\t\t            ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"> <input type=checkbox id=\'subgrp";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' name=\'chk";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\')\" value=\"\" ><input type=\'hidden\' name=\'headval";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' value=\'\'></td><!-- IN066119 Modified-->\n\t\t\t            <td width=\'22%\' class=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</font></td>\n\t\t\t            <td width=\'9.5\' class=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"  class=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">&nbsp;</td> -->\n\t\t\t\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t<!--</Table>-->";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t</tr>\n\n\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t<TR>\n\t\t\t<td width=\'8.5%\' class=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\')\" value=\"\" ><label id=\"remark_td";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' value=\'\'></td>\n\t\t\t<td width=\'22%\' class=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</font></td>\n\t\t\t<td width=\'9.5%\' class=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</font></td>\n\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</font></td>\n\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</font></td>\n\t\t\t<td width=\'14.5%\' class=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" </font></td>\n\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</font></td>\n\t\t\t<!-- <td width=\'4%\' id=\"remark_td";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">&nbsp;</td> -->\n\t\t\t<td width=\'9%\' class=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</font></td>\n\t\t</TR>\n    ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n</table>\n<!-- Next, Prev --> \n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n<!-- Next, Prev Till here--> \n\n<input type=hidden name=\'requested_by_pract_id\' id=\'requested_by_pract_id\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n<input type=hidden name=\'requested_by_pract_name\' id=\'requested_by_pract_name\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n<input type=hidden name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n<input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\n<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n<input type=\"hidden\" name=\"normalcy_ind\" id=\"normalcy_ind\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n<input type=\"hidden\" name=\"result_type\" id=\"result_type\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n<input type=\"hidden\" name=\"event_class\" id=\"event_class\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n<input type=\"hidden\" name=\"groupby\" id=\"groupby\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n<input type=\"hidden\" name=\"ca_normalcy_ind\" id=\"ca_normalcy_ind\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n<input type=\"hidden\" name=\"modal\" id=\"modal\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n<input type=\"hidden\" name=\"period_from\" id=\"period_from\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n<input type=\"hidden\" name=\"period_to\" id=\"period_to\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n</form>\n<script>\n\tif(parent.ReviewResultsHeader.document.getElementById(\'titleTab\')!=null) {\n\t\talignWidth();\n\t}\n\tparent.ReviewResultsSearch.document.review_result_search.search_btn.disabled =false;\n\n//alert(\"111\"+parent.ReviewResultsSearch.document.review_result_search.remark_td0.innerHTML);\n//parent.ReviewResultsSearch.document.review_result_search.remark_td0.innerHTML=\"ragha\";\n//alert(\"sss\"+parent.ReviewResultsSearch.document.review_result_search.remark_td0.innerHTML);\n\n</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;



	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReviewResults" ;
	String bean_name = "eOR.ReviewResults";


	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
    String user_id = (String)session.getValue("login_user");

	if(resp_id== null)resp_id = "";
	if (user_id == null) user_id = "";


//	out.println(">"+practitioner_id+"<<br>");
//	out.println(">"+resp_id+"<");

	String priority		= CommonBean.checkForNull((String)request.getParameter("priority"));
	String normal_ind = CommonBean.checkForNull((String)request.getParameter("normalcy_ind"));
	String result_type	= CommonBean.checkForNull((String)request.getParameter("result_type"));

	String patientId	= CommonBean.checkForNull((String)request.getParameter("patientId"));
	String event_class	= CommonBean.checkForNull((String)request.getParameter("event_class"));

	String group_by		= CommonBean.checkForNull((String)request.getParameter("groupby"));

	String patient_class		= CommonBean.checkForNull((String)request.getParameter("patient_class"));
	String ca_normalcy_ind		= CommonBean.checkForNull((String)request.getParameter("ca_normalcy_ind"));

	String modal                = CommonBean.checkForNull((String)request.getParameter("modal"));
	String period_from                = CommonBean.checkForNull((String)request.getParameter("period_from"));
	String period_to                = CommonBean.checkForNull((String)request.getParameter("period_to"));
	String get_task_applicability   = CommonBean.checkForNull((String)request.getParameter("get_task_applicability"));
	//out.println("<script>alert('in jsp,period_from="+period_from+"');</script>");
	//out.println("<script>alert('in jsp,period_to="+period_to+"');</script>");
	ArrayList allValues = new ArrayList();

	String total_query_records  = "0";
	String from	 = CommonBean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = CommonBean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);

		//IN066119 starts
		String fac_id= (String) session.getValue("facility_id");//IN066119
		String bean_id1 = "Or_ViewOrder" ;
		String bean_name1 = "eOR.ViewOrder";
		ViewOrder vbean = (ViewOrder)getBeanObject( bean_id1, bean_name1,request ) ;
		String hideSpecimenType = "N";
		HashMap orParamFac = new HashMap();
		String mainGrpDisable ="";
		Connection con = null;
		int j = 1;
	try{
		con =  ConnectionManager.getConnection(request);
		orParamFac=vbean.orParamFacility(con, fac_id);
		hideSpecimenType = (String)orParamFac.get("HIDE_SPECIMENTYPE");
		//IN066119 ends
		//Added for IN067651 starts
		boolean isPracSiteSpecific = false;
		isPracSiteSpecific=eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER");
		//Added for IN067651 starts
/* Mandatory checks end */

	/* Initialize Function specific start */
	ReviewResults bean = (ReviewResults)getBeanObject( bean_id, bean_name ,  request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	if (practitioner_id == null) {
	   String [] practitionerDetails = (String[])bean.getPractitionerDetails(user_id);
	   practitioner_id = practitionerDetails[0];
	}

	if(practitioner_id == null)practitioner_id = "";

	//allValues		= bean.getDetails(practitioner_id,priority,normal_ind,result_type,resp_id,patientId,event_class);
		//out.println("<script>alert('=group_by=="+group_by+"=event_class===="+event_class+"===');</script>");

	//out.println("practitioner_id"+practitioner_id+"priority"+priority+"normal_ind"+normal_ind+"result_type"+result_type+"resp_id"+resp_id+"patientId"+patientId+"event_class"+event_class+"group_by"+group_by+"patient_class"+patient_class+"ca_normalcy_ind"+ca_normalcy_ind+"modal"+modal+"period_from"+period_from+	"period_to"+period_to+"start"+start+"end"+end);

	allValues		= bean.getDetails(practitioner_id,priority,normal_ind,result_type,resp_id,patientId,event_class,group_by,patient_class,ca_normalcy_ind,modal,period_from,period_to,get_task_applicability,start,end);

	String result_data[] = (String[])bean.getAbnormalCondition();


	String high_str			= result_data[0];
	String low_str			= result_data[1];
	String abn_str			= result_data[2];

	String crit_str			= result_data[3];
	String crit_high_str	= result_data[4];
	String crit_low_str		= result_data[5];
	String tooltip			= "";
	String result			= "";

/* Initialize Function specific end */
//out.println("allValues.size() " + allValues.size());
	if(allValues.size() == 0){

            _bw.write(_wl_block11Bytes, _wl_block11);
	}
            _bw.write(_wl_block2Bytes, _wl_block2);
if(allValues.size() != 0){
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);


	String 	episode_details				= "";
	String temp_episode_details         = "";
	String 	event						= "";
	String 	contr_sys_event_code		= "";
	//String 	order_type_code				= "";
	String 	order_id					= "";
	String 	accession_num				= "";
	String 	hist_rec_type				= "";
	String 	contr_sys_id				= "";
	//String 	pract_id					= "";
	String 	review_types				= "";
	String 	review_type					= "";
	String 	hist_data_type				= "";
	//String 	reported_by					= "";
	String 	reported_at					= "";
	//String 	authorized_by_id			= "";
	//String 	event_auth_date_time		= "";
	String 	result_num					= "";
	String 	result_num_uom				= "";
	String 	result_str					= "";
	String 	normal_low					= "";
	String 	normal_high					= "";
	String 	normalcy_ind				= "";
	String 	ext_image_obj_id			= "";
	String 	ext_image_appl_id			= "";
	String 	practitioner_name			= "";
	String 	create_date_time			= "";
	String  status						= "";
    String  ordering_practitioner		= "";
    //Added by Siva Kumar
    String  hist_rec_type_desc          = "";
    String  event_class_desc            = "";
    String  event_group_desc            = "";
	String  temp_res_event_header       = "";
	String  temp_event_group_desc       = "";
    String	temp_order_id				= "";
    String  patient_id                  = "";
    String  event_code                  = "";
    String  event_group                 = "";
    String  event_class_code            = "";
    String  requested_by_pract_id            = "";
    String  requested_by_pract_name            = "";
	String  ext_image_upld_id            = "";//IN041006
    //End of Addition
	
	StringBuffer disp_value = new StringBuffer();
	String slClassValue = "";
	String[] record  = null;
	
	for(int i=0; i<allValues.size(); i++){
		record  = (String[])allValues.get(i);
		if (record[0].indexOf(",")!=-1){

			StringTokenizer fieldTokenizer = new StringTokenizer(record[0],",");
			record[0]="";
		
		while (fieldTokenizer.hasMoreTokens()) {
		  String tempToken = fieldTokenizer.nextToken();
		 
		   if ((tempToken.indexOf('/'))==1)
			{
			  String tempstr=tempToken.substring(1);
			  if (tempToken.charAt(0)=='M')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
			  else if(tempToken.charAt(0)=='F')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
			record[0]=record[0].concat(tempToken).concat(",");
			  
         

		}
					 }
					
		
		episode_details				=CommonBean.checkForNull(record[0]);
		event						=CommonBean.checkForNull(record[1]);
		contr_sys_event_code		=CommonBean.checkForNull(record[2]);
		//order_type_code				=CommonBean.checkForNull(record[3]);
		order_id					=CommonBean.checkForNull(record[4]);
		accession_num				=CommonBean.checkForNull(record[5]);
		hist_rec_type				=CommonBean.checkForNull(record[6]);
		contr_sys_id				=CommonBean.checkForNull(record[7]);
		//pract_id					=CommonBean.checkForNull(record[8]);
		review_types				=CommonBean.checkForNull(record[9]);
		review_type					=CommonBean.checkForNull(record[10]);
		hist_data_type				=CommonBean.checkForNull(record[11]);
		//reported_by					=CommonBean.checkForNull(record[12]);
		reported_at					=CommonBean.checkForNull(record[13]);
		reported_at = com.ehis.util.DateUtils.convertDate(reported_at,"DMYHM","en",localeName);// for thai date validations. convert date from english to local language(thai)
		//authorized_by_id			=CommonBean.checkForNull(record[14]);
		//event_auth_date_time		=CommonBean.checkForNull(record[15]);
		result_num					=CommonBean.checkForNull(record[16]);
		result_num_uom				=CommonBean.checkForNull(record[17]);
		result_str					=CommonBean.checkForNull(record[18]);
		normal_low					=CommonBean.checkForNull(record[19]);
		normal_high					=CommonBean.checkForNull(record[20]);
		normalcy_ind				=CommonBean.checkForNull(record[21]);
		ext_image_obj_id			=CommonBean.checkForNull(record[22]);
		ext_image_appl_id			=CommonBean.checkForNull(record[23]);
		//IN067651 changes starts
		//practitioner_name			=CommonBean.checkForNull(record[24]);
		if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
		{
			practitioner_name			=CommonBean.checkForNull(record[41]);
		}else{
			practitioner_name			=CommonBean.checkForNull(record[24]);
		}
		//IN067651 changes ends
		create_date_time			=CommonBean.checkForNull(record[26]);
		create_date_time = com.ehis.util.DateUtils.convertDate(create_date_time,"DMYHM","en",localeName);// for thai date validations. convert date from english to local language(thai)
		status						=CommonBean.checkForNull(record[27]);
		ordering_practitioner		=CommonBean.checkForNull(record[28]);
		hist_rec_type_desc          =CommonBean.checkForNull(record[29]);
		event_class_desc            =CommonBean.checkForNull(record[30]);
		event_group_desc            =CommonBean.checkForNull(record[31]);
		patient_id                  = CommonBean.checkForNull(record[32]);
        event_code                  = CommonBean.checkForNull(record[33]);
        event_group                 = CommonBean.checkForNull(record[34]);
        event_class_code            = CommonBean.checkForNull(record[35]);
		result			            = CommonBean.checkForNull(record[36]);
		//out.println("result"+result+"*");
		requested_by_pract_id	    = CommonBean.checkForNull(record[37]);
		requested_by_pract_name     = CommonBean.checkForNull(record[38]);
		ext_image_upld_id			= CommonBean.checkForNull(record[39]);//IN041006
		if(review_type.equalsIgnoreCase("O"))
		{
			review_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingPractitioner.label","common_labels");
		}
			else if (review_type.equalsIgnoreCase("A"))
		{
			review_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels");
		}
		if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(high_str) || normalcy_ind.equalsIgnoreCase(low_str) || normalcy_ind.equalsIgnoreCase(abn_str) ))
			normalcy_ind = "<FONT COLOR='RED' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"<br></FONT>";  //<a href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' align=center></img></a>
		else if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
			normalcy_ind= "<FONT COLOR='MAGENTA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalAbnormal.label","or_labels")+"<br></FONT>";
			 //<a href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' align=center></img></a>
		else if(normalcy_ind!=null && normalcy_ind.equals("."))
			normalcy_ind = "<FONT COLOR='BLACK' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"<br></FONT>";  //<a href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' align=center></img></a>
		else
			normalcy_ind = "<FONT COLOR='RED' ></FONT>";   //<a href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' align=center></img></a>
		//out.println(">"+normalcy_ind+"<");
		if(!status.equals("") && status.equals("C"))
		{
			slClassValue = "ORSTATUSPARTIAL";
			tooltip      = "This result has been Modified";
		}
		else
		{
			tooltip = "";
			/*if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}*/
			slClassValue="gridData";
		}  

		if(i==0){
					//if(record[39] != null)//IN041006
				if(record[40] != null)//IN041006	
					total_query_records = bean.checkForNull((String)record[40],"0");//Changed from 39 to 40
				 
            _bw.write(_wl_block14Bytes, _wl_block14);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("chk")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("review_results_dtl")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block21Bytes, _wl_block21);
				
		}
	disp_value = new StringBuffer();
 	disp_value.append("&nbsp;");
	//IN066119 start
	if("Y".equals(hideSpecimenType))
		result_str="";
	//IN066119 ends
		if(hist_data_type.trim().equals("NUM")){

			disp_value.append(result_num + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;"+"("+normal_low+"-"+normal_high+")"+" "+normalcy_ind);
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value .append( "<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultComments.label","or_labels")+" </a>");
			}
			//disp_value = disp_value +"<br>"+(result_str == null ? "" : result_str);
//result = bean.getClobData(accession_num);
			if(result!=null && !result.equals(""))
			{
 
				disp_value.append( "<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		} else
		if(hist_data_type.trim().equals("STR")){
			//disp_value  = result_str+" "+normalcy_ind;
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultComments.label","or_labels")+" </a>");
			}
			disp_value.append(" "+normalcy_ind);
//result = bean.getClobData(accession_num);
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		} else
		if(hist_data_type.trim().equals("TXT")){
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultComments.label","or_labels")+" </a>");
			}
			disp_value.append(" "+normalcy_ind);
//result = bean.getClobData(accession_num);
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
			//disp_value  = "<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0>";
		}else
	 	if(hist_data_type.trim().equals("HTM")){
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultComments.label","or_labels")+" </a>");
			}
			disp_value.append(" "+normalcy_ind);
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobDataHtm('"+accession_num+"','"+hist_data_type+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		}
	/*	if ((ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_appl_id!=null && !ext_image_appl_id.equals("")) ) {
			disp_value.append("<br><a class='gridLink' href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"')\"> ");
		//disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='XRAY' align=center></a>");//IN035654
		disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result' align=center></a>");//IN035654
			
		}*/ //Commentted for EMG
		//Added docul condition for EMG
		if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
		{
			if(!("DOCUL").equals(ext_image_appl_id)) 
			{
				if(!ext_image_upld_id.equals("SPEC_IMG")) //IN041006 Added if condition 
				{
					//IN050936 included patient_id
					disp_value.append("<br><a class='gridLink' href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+ext_image_obj_id+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\"> ");
					disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result' align=center></a>");//IN035654
				}	
			}
			else
			{
				//IN050936 included patient_id
				disp_value.append("<br><a class='gridLink' href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\"> ");
				disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result' align=center></a>");//IN035654
			}
											
		}		

		disp_value.append("<a class='gridLink' href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' title='Previous Results' border='0' align=center></img></a>");

		if(status.equals("P"))
			disp_value.append("<font color='red'>(Preliminary)</font>");

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(contr_sys_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(contr_sys_event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(review_types));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(create_date_time));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_group));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_class_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((record[21]==null)?"":record[21]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(normal_ind));
            _bw.write(_wl_block49Bytes, _wl_block49);
 //IN033610 included normal_ind above
			if (!group_by.equals("E")) {
        if (!temp_episode_details.equals(episode_details)) { 
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(episode_details));
            _bw.write(_wl_block51Bytes, _wl_block51);

		  temp_episode_details = episode_details;
		  temp_res_event_header = "";
		  }
    if (!temp_res_event_header.equals(hist_rec_type_desc+"/"+event_class_desc)) {
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(hist_rec_type_desc+"/"+event_class_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);

         temp_res_event_header =  hist_rec_type_desc+"/"+event_class_desc;
         }
       
            _bw.write(_wl_block54Bytes, _wl_block54);
if (event_group_desc.equals("")) {//out.println("here");
				//IN066119 starts
	   			j++;
				temp_event_group_desc="";
				temp_order_id ="";
				//IN066119 ends
			
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(event));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disp_value));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block68Bytes, _wl_block68);
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(reported_at));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(review_type));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(ordering_practitioner));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(requested_by_pract_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
}else {//out.println("here in elseif");
            _bw.write(_wl_block76Bytes, _wl_block76);
if ((!temp_event_group_desc.equals(event_group_desc))|| (!temp_order_id.equals(order_id))) {    // || (!temp_order_id.equals(order_id))
                    		j++;	//IN066119 added
                    
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(j));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(mainGrpDisable));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(event_group_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(event));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disp_value));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block97Bytes, _wl_block97);
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(reported_at));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(review_type));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(ordering_practitioner));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(requested_by_pract_name));
            _bw.write(_wl_block105Bytes, _wl_block105);
temp_order_id=order_id;temp_event_group_desc = event_group_desc;}else {
            _bw.write(_wl_block106Bytes, _wl_block106);
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(event));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disp_value));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block97Bytes, _wl_block97);
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(reported_at));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(review_type));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(ordering_practitioner));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(requested_by_pract_name));
            _bw.write(_wl_block105Bytes, _wl_block105);
}
            _bw.write(_wl_block114Bytes, _wl_block114);
}
            _bw.write(_wl_block115Bytes, _wl_block115);
  	} else {
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(event));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disp_value));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(reported_at));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(episode_details));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(review_type));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(ordering_practitioner));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(requested_by_pract_name));
            _bw.write(_wl_block126Bytes, _wl_block126);
}
	}

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(from));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(to));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(requested_by_pract_id));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(requested_by_pract_name));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(allValues.size()));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block136Bytes, _wl_block136);
//=bean.getFunctionId()
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf((String)request.getParameter("priority")));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf((String)request.getParameter("normalcy_ind")));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf((String)request.getParameter("result_type")));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf((String)request.getParameter("patientId")));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf((String)request.getParameter("event_class")));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)request.getParameter("groupby")));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf((String)request.getParameter("patient_class")));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((String)request.getParameter("ca_normalcy_ind")));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf((String)request.getParameter("modal")));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf((String)request.getParameter("period_from")));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf((String)request.getParameter("period_to")));
            _bw.write(_wl_block148Bytes, _wl_block148);
putObjectInBean(bean_id,bean,request);
} 
catch(Exception ex) {
	System.out.println(" 1084. ReviewResultsDetail.jsp ===> " + ex.getMessage());
}
finally
{
	ConnectionManager.returnConnection(con,request);
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
}
