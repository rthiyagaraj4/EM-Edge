package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eOR.*;
import java.math.*;
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

public final class __viewresultsdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewResultsDetail.jsp", 1742472514940L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      \t\tName        Description\n--------------------------------------------------------------------------------------------------------------------\n?             \t100            \t\t?           created\n20/09/2012\t\tPERF-1\t\t\tDinesh T\tCheck email dated 09/20/2012, added for performance tuning\n03/06/2013\t    EMG   \t\t\tChowminya G\tPACS LIVE issue\n18/12/2013\t\tIN045966\t\tRamesh G\tBru-HIMS-CRF-391/10 --- Notes Confidentiality\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History      Name        \tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n08/09/2014 \t\tIN050936\tChowminya\t\t\t\t\t\t\t     \t None of the order retrieving any image from RIS/PACS but already having order image in PACS\n07/10/2014\t\tIN041153\tKarthi\t\t\t\t\t\t\t\t\t\t\tSystem is displaying \'Result\' icon\n30/01/2015  \tIN053093\t\tNijitha S\t\t\t\t\t\t\t\t\t\tML-BRU-SCF-1515 \n19/03/2015\t\tIN052800\t\tKarthi L\t\t\t\t\t\t\t\t\t\tIf link image for Histology orderable, from CA, user not able to view the image. No link appear under View.\n07/07/2017\t\tIN064688\t\tRaja S\t\t\t08/07/2017\t\tRameshG\t\t\tML-MMOH-SCF-0753\n07/02/2018\t\tIN065970\t\tVijayakumar K\t07/02/2018\t\tRameshGo\t\tML-BRU-SCF-1611.1 [IN:065970]\n07/03/2018\t\tIN065970\t\tVijayakumar K\t07/03/2018\t\tRameshGo\t\tML-BRU-SCF-1611.1 [IN:065970] reopen\n19/03/2018\t\tIN067037\t\tRaja S\t\t\t19/03/2018\t\tRamesh G\t\tML-BRU-SCF-1787\n26/02/2018\t\tIN066119\t\tRaja S\t\t\t26/02/2018\t\tRamesh G\t\tML-MMOH-CRF-1024\n07/06/2018\t\tIN067651\t\tRaja S\t\t\t07/06/2018\t\tRamesh G\t\tGHL-SCF-1338\n03/02/2020\t\tIN071561\tSIVABAGYAM M\t\t03/02/2020\t\tRAMESH G\t\tGHL-CRF-0558.1\n15/12/2020\t\t7902\t\tSivabagyam M\t\t15/12/2020\t\tRamesh G\tMMS-DM-CRF-0180.1\n20/04/2021\t\t6484\t\t\tRamesh Goli\t\t20/04/2021\t\tRAMESH G\t\tMO-CRF-20147.7\n--------------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="<!-- Added math.* IN064688 -->\n \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n\n<html> \n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eCA/js/ViewResult.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eCA/js/CAOpenExternalApplication.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \t<script>\n\t\tfunction alignWidth()\n\t\t{\n\t\t\tvar last=eval(document.getElementById(\'detailTab\').rows.length)-1;\n\t\t\t\t\n\t\t\tif(document.getElementById(\'detailTab\')!=null)\n\t\t\t{\n\t\t\t\tfor(i=0;i <document.getElementById(\'detailTab\').rows(last).cells.length;i++)\n\t\t\t\t{\n\t\t\t\t\tvar wid=document.getElementById(\'detailTab\').rows(last).cells(i).offsetWidth;\n\t\t\t\t\tvar wid1= parent.ReviewResultsHeader.document.getElementById(\'titleTab\').rows(0).cells(i).offsetWidth;\n\t\t\t\t\t\t\n\t\t\t\t\tif(eval(wid1) <eval(wid))\n\t\t\t\t\t\tparent.ReviewResultsHeader.document.getElementById(\'titleTab\').rows(0).cells(i).width=wid;\n\t\t\t\t\telse\n\t\t\t\t\t\tdocument.getElementById(\'detailTab\').rows(last).cells(i).width = wid1;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n\t \n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">     \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<script>\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\tparent.ReviewResultsSearch.document.review_result_search.search_btn.disabled =false;\n\t\tparent.ReviewResultsHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\tparent.ReviewResultsResult.location.href = \"../../eCommon/html/blank.html\"\n\t\tparent.ReviewResultsBtn.location.href = \"../../eCommon/html/blank.html\"\n\t</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<script>focusOnResult();</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<form name=\'review_results_dtl\' id=\'review_results_dtl\'  action=\"../../eCA/jsp/ViewResultsDetail.jsp\" method=\"post\">\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" id=\'detailTab\' class=\"grid\" >\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<!--\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="   \n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t \n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="  \n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\t\n\t\tCommented for IN066119-->\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<input type=hidden name=\'hist_rec_type";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'hist_rec_type";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=hidden name=\'contr_sys_id";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'contr_sys_id";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type=hidden name=\'contr_sys_event_code";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'contr_sys_event_code";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t<input type=hidden name=\'accession_num";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'accession_num";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<input type=hidden name=\'review_type";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'review_type";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t<input type=hidden name=\'result_str";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'result_str";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t<input type=hidden name=\'create_date_time";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'create_date_time";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type=hidden name=\'patient_id";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'patient_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t<input type=hidden name=\'event_code";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'event_code";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=hidden name=\'event_group";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'event_group";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type=hidden name=\'event_class_code";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'event_class_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t<input type=hidden name=\'normalcy_ind";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'normalcy_ind";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<tr><Td colspan=\'9\' class =\'CAFLOWSHEETLEVEL3\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</Td></tr> \n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t<tr> <Td colspan=\'9\' class =\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</Td></tr>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<tr>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t<td width=\'7%\' id=\'status";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' title = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"><input type=checkbox name=\'chk";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' onClick=\"clickChk(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\" value=\"\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" ><label id=\"remark_td";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"></label><input type=\'hidden\' name=\'review_remarks";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' value=\'\'></td>\n\t\t\t\t<td width=\'22%\' class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"><font size=1>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</font></td>\n\t\t\t\t<td width=\'9.5%\' class=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</font></td>\n\t\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"><font size=1>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t</font> </td>\n\t\t\t\t<td width=\'14%\' class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</font></td>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t<TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD> <input type=\"checkbox\" name=\'chkgrp";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'maingrp";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' onClick=\"checkgroup(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\')\" ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="  value=\'chk";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'  ></TD><!--Modified for IN066119-->\n\t\t\t\t\t\t<TD colspan=\'9\' >\n\t\t\t\t\t\t\t<Font size=1>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</Font>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t<td width=\'7%\' class=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" > <input type=checkbox id=\'subgrp";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' name=\'chk";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' onClick=\"javascript:clickChk(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" ><input type=\'hidden\' name=\'headval";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'headval";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'><label id=\"remark_td";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'subgrp_remarks";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'  value=\'\'></td><!--Modified for IN066119-->\n\t\t\t\t\t\t<td width=\'22%\' class=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" ><font size=1>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</font></td>\n\t\t\t\t\t\t<td width=\'9.5%\' class=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</font></td>\n\t\t\t\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</font></td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t</font> </td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\'14%\' class=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</font>&nbsp;</td>\n\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"> <input type=checkbox id=\'subgrp";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' value=\'\'></td><!--Modified for IN066119-->\n\t\t\t\t\t\t<td width=\'22%\' class=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</font></td>\n\t\t\t\t\t\t<td width=\'9.5\' class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</font></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t<TR>\n\t\t\t\t<td width=\'8.5%\' class=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' id=\'chk";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\')\" value=\"\"   ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' id=\'review_remarks";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</font></td>\n\t\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t</font></td>\n\t\t\t\t<td width=\'14.5%\' class=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</font></td>\n\t\t\t\t<td width=\'9%\' class=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</font></td>\n\t\t\t</TR>\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n</table>\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" >\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" >\n\n\t<input type=hidden name=\'requested_by_pract_id\' id=\'requested_by_pract_id\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t<input type=hidden name=\'requested_by_pract_name\' id=\'requested_by_pract_name\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t<input type=hidden name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n\t<input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\n\t<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t<input type=\"hidden\" name=\"normalcy_ind\" id=\"normalcy_ind\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t<input type=\"hidden\" name=\"result_type\" id=\"result_type\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t<input type=\"hidden\" name=\"event_class\" id=\"event_class\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t<input type=\"hidden\" name=\"groupby\" id=\"groupby\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t<input type=\"hidden\" name=\"ca_normalcy_ind\" id=\"ca_normalcy_ind\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t<input type=\"hidden\" name=\"modal\" id=\"modal\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t<input type=\"hidden\" name=\"period_from\" id=\"period_from\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t<input type=\"hidden\" name=\"period_to\" id=\"period_to\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t<input type=\"hidden\" name=\"status_crit\" id=\"status_crit\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n</form>\n\n<script>\n\tif(parent.ReviewResultsHeader.document.getElementById(\'titleTab\')!=null)\n\t{\n\t\talignWidth();\n\t\tparent.ReviewResultsHeader.document.review_results_hdg.select_all.checked=false;\n\t\tif(\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'==\"false\")\n\t\t{\n\t\t\tparent.ReviewResultsHeader.document.review_results_hdg.select_all.disabled =true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.ReviewResultsHeader.document.review_results_hdg.select_all.disabled =false;\n\t\t}\n\t}\n\tparent.ReviewResultsSearch.document.review_result_search.search_btn.disabled =false;\n</script>\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );
	
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


	private String replace(String str ,String change ,String replace,String quotes)
	{
		int t = str.indexOf(change);
		if( t == -1)
			return str;
		if (quotes.equalsIgnoreCase("Y"))
			str   = str.substring(0,t) + " '" + replace.trim()+ "' " + str.substring(t+1)  ;
		else if (quotes.equalsIgnoreCase("N"))
			str   = str.substring(0,t) + " " + replace.trim()+ " " + str.substring(t+1)  ;
		return str ;
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet resultSet = null;
	ResultSet rs = null;

	StringBuffer tempNormCritStr = new StringBuffer();

	String details1 = "";
	
	String mode	= "1";

	String bean_id = "Or_ReviewResults" ;
	String bean_name = "eOR.ReviewResults";
	eCA.PatientBannerGroupLine manageEmailBean = null; //IN052800
	try { // added for IN041153
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String reln_id = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
    String user_id = (String)session.getValue("login_user");

	if(resp_id == null) resp_id = "";
	if (user_id == null) user_id = "";

	String priority		= CommonBean.checkForNull((String)request.getParameter("priority"));
	String normal_ind	= CommonBean.checkForNull((String)request.getParameter("normalcy_ind"));
	String result_type	= CommonBean.checkForNull((String)request.getParameter("result_type"));
	String patientId	= CommonBean.checkForNull((String)request.getParameter("patientId"));
	String event_class	= CommonBean.checkForNull((String)request.getParameter("event_class"));
	String group_by		= CommonBean.checkForNull((String)request.getParameter("groupby"));
	String ca_normalcy_ind	= CommonBean.checkForNull((String)request.getParameter("ca_normalcy_ind"));
	String modal            = CommonBean.checkForNull((String)request.getParameter("modal"));
	String period_from      = CommonBean.checkForNull((String)request.getParameter("period_from"));
	String period_to        = CommonBean.checkForNull((String)request.getParameter("period_to"));
	String encounter_id     = CommonBean.checkForNull((String)request.getParameter("encounter_id"));
	String curr_enc         = CommonBean.checkForNull((String)request.getParameter("curr_enc"));
	String status_crit      = CommonBean.checkForNull((String)request.getParameter("status_crit"));

	String legend_type = "";
	String color_cell_ind = "";
	String desc_cell_ind = "";
	String normal_range_symbol = "";
	String color_cell_indicator = "";
	String strNormalcyInd = "";
	String result_yn = "";
	String normalcy_str = "";
	String fac_id = "";//IN065970 reopen
	// added for IN041153 - Start
	Properties p			= (Properties)session.getValue("jdbc");
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");
	PreparedStatement pstmtImgView = null; 
	ResultSet resImgView = null; 
	PreparedStatement pstmtImgCount = null;
	PreparedStatement pstmtPerFacId = null;
	ResultSet rsetPerFacId = null;  
	ResultSet rsetImgCount = null; 
	int recCount = 0; 
	String ext_image_upld_id = ""; 
	String ext_img_file_locn = "";
	//IN066119 starts
	String facility_id= (String) session.getValue("facility_id");//IN066119
	String bean_id1 = "Or_ViewOrder" ;
	String bean_name1 = "eOR.ViewOrder";
	ViewOrder vbean = (ViewOrder)getBeanObject( bean_id1, bean_name1,request ) ;
	String hideSpecimenType = "N";
	HashMap orParamFac = new HashMap();
	String mainGrpDisable ="";
	//IN066119 ends
	// added for IN041153 - End
	boolean isPracSiteSpecific = false;//IN067651
	PreparedStatement pstmtImgView1 = null; //7902
	ResultSet resImgView1 = null;//7902
	String study_id="",ext_img_disable="",param_def_str="",ext_img_display="";//7902
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientId+encounter_id,"eCA.PatientBannerGroupLine",session); //IN052800
	ArrayList allValues = new ArrayList();

	String total_query_records = "0";
	String from	 = CommonBean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = CommonBean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);

	int loop_start = start;

	ReviewResults bean = (ReviewResults)getBeanObject(bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	if (practitioner_id == null)
	{
	   String [] practitionerDetails = (String[])bean.getPractitionerDetails(user_id);
	   practitioner_id = practitionerDetails[0];
	}

	if(practitioner_id == null)practitioner_id = "";

	if(normal_ind == null) normal_ind = "";

	try
	{
		con =  ConnectionManager.getConnection(request);
		//IN066119 starts
		orParamFac=vbean.orParamFacility(con, facility_id);
		hideSpecimenType = (String)orParamFac.get("HIDE_SPECIMENTYPE");
		//IN066119 ends
		//Added for IN067651 starts
		isPracSiteSpecific=eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER");
		//Added for IN067651 starts
		boolean restrict_rd	=false;	//IN071561
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561

		stmt = con.prepareStatement("select VIEW_RESULT_DATETIME_YN from CA_ENCNTR_PARAM ");
		rs = stmt.executeQuery();
		if (rs.next())
		{
			result_yn = rs.getString(1) == null ? "N" : rs.getString(1);
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		StringBuffer SqlStr = new StringBuffer();
	
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix, result_num, result_num_uom, result_str, normal_low, normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN041153
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix, result_num, result_num_uom, result_str, normal_low, normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN041153
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix, result_num, result_num_uom, result_str, normal_low, normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str,a.facility_id  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN065970 facility id is added
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, result_num_uom, result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_low),TO_CHAR(normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_high),TO_CHAR(normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str,a.facility_id  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN065970 facility id is added//IN067037 //Commented for IN067651
		//6484 Start.
		//SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, AM_GET_DESC.AM_PRACTITIONER(authorized_by_id,?,1) resulted_prac_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, result_num_uom, result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_low),TO_CHAR(normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_high),TO_CHAR(normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str,a.facility_id  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); //IN065970 facility id is added//IN067037 //Modified for IN067651
		SqlStr.append(" SELECT  CA_GET_VISIT_DTL_NEW(FACILITY_ID,patient_class,ENCOUNTER_ID,PATIENT_ID,? ) episode_details ,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code, a.event_code_type, ? ,  '1' ) event, contr_sys_event_code, accession_num accession_num, a.hist_rec_type hist_rec_type,AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) practitioner_name, AM_GET_DESC.AM_PRACTITIONER(authorized_by_id,?,1) resulted_prac_name, contr_sys_id, PRACTITIONER_ID pract_id,  hist_data_type, performed_by_id reported_by, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') reported_at,'O' review_types, authorized_by_id, TO_CHAR (event_auth_date_time, 'dd/mm/yyyy hh24:mi' ) event_auth_date_time, result_num_prefix,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, result_num_uom, result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_low),TO_CHAR(normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(normal_high),TO_CHAR(normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high,critical_low,critical_high, normalcy_ind, ext_image_obj_id, EXT_IMAGE_UPLD_ID, ext_image_appl_id, authorized_by_id, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') create_date_time, a.status status, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,1) ordering_practitioner, cr_get_desc.cr_hist_rec_type (a.hist_rec_type,? ,'2' ) hist_rec_type_desc,  cr_get_desc.cr_event_class ( a.hist_rec_type, a.event_class, ? , '1' ) event_class_desc, cr_get_desc.cr_clin_event_group(a.hist_rec_type, a.event_group, a.event_group_type, ? , '1' ) event_group_desc, a.patient_id patient_id, a.event_class event_class, a.event_code event_code, a.event_group event_group,  (SELECT 'X'  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and (dbms_lob.getlength(hist_data)>0 or dbms_lob.getlength(compress_hist_data)>0 ))  hist_data, PRACTITIONER_ID requested_by_pract_id,'' requested_by_pract_name, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1 ),'N')  review_yn, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code,  abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code  ) FROM cr_clin_event_param) color_cell_ind, (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc, low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc,  crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc )  FROM cr_clin_event_param) desc_cell_ind, (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon,  low_str, low_symbol_icon, crit_str, crit_symbol_icon,  abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, '' )  FROM cr_clin_event_param) normal_range_symbol, a.normalcy_str,a.facility_id  FROM cr_encounter_detail a WHERE NVL (a.hist_rec_type, 'X') = NVL ((''  ), NVL (a.hist_rec_type, 'X')) "); 
		//6484 end.
		if(!normal_ind.equals("") && (!normal_ind.equalsIgnoreCase("N"))) 
		{
			SqlStr.append(" and NORMALCY_IND in ($) ");	 
		}
		else
		{
			SqlStr.append("	AND NVL (normalcy_ind, '.') IN NVL ( $, NVL (normalcy_ind, '.'))");
		}
		//IN045966 Start.
		SqlStr.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+practitioner_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,a.event_group),'N')='Y'");
		//IN045966 End.
		//IN071561 starts
		if(restrict_rd)
			SqlStr.append("AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+user_id+"')='N'");
		//IN071561 ends
		if(result_yn.equals("Y"))
			//SqlStr.append("	 AND (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N') = 'Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) = 'A')) AND patient_id = NVL (? , patient_id) AND a.event_class = NVL (?  , a.event_class) AND ((A.HIST_REC_TYPE != 'LBIN' and TRUNC (event_date) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy')) OR (A.HIST_REC_TYPE = 'LBIN' AND CONTR_SYS_ID='LB' and TRUNC (EVENT_AUTH_DATE_TIME) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy'))) AND NVL (a.status, '#')  not in('S','E') ");//PERF-1
			SqlStr.append("	 AND (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N') = 'Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) = 'A')) AND patient_id = ? AND a.event_class = NVL (?  , a.event_class) AND ((A.HIST_REC_TYPE != 'LBIN' and TRUNC (event_date) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy')) OR (A.HIST_REC_TYPE = 'LBIN' AND CONTR_SYS_ID='LB' and TRUNC (EVENT_AUTH_DATE_TIME) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy'))) AND NVL (a.status, '#')  not in('S','E') ");//PERF-1
		else
			//SqlStr.append("	 AND (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N') = 'Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) = 'A')) AND patient_id = NVL (? , patient_id) AND a.event_class = NVL (?  , a.event_class) AND TRUNC (event_date) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy'  ) AND NVL (a.status, '#') not in('S','E') ");//PERF-1
			SqlStr.append("	 AND (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N') = 'Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) = 'A')) AND patient_id = ? AND a.event_class = NVL (?  , a.event_class) AND TRUNC (event_date) BETWEEN TO_DATE (NVL (( ?), '01/01/1000'), 'dd/mm/yyyy'  ) AND TO_DATE (NVL (( ? ), '31/12/9999'), 'dd/mm/yyyy'  ) AND NVL (a.status, '#') not in('S','E') ");//PERF-1
	
		if(curr_enc.equals("Y"))
		{
			SqlStr.append(" and encounter_id = ? "); 
		}
		if(status_crit.equals("P"))
		{
			SqlStr.append(" and exists (select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE) "); 
		}
		else if(status_crit.equals("R"))
		{
			SqlStr.append(" and not exists (select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE) "); 
		}

		if(!result_type.equals(""))
		{
			SqlStr.append(" and hist_rec_type=? ");
		}
		else
		{
		  SqlStr.append(" and hist_rec_type in (select hist_rec_type from or_order_category where PREFERRED_VIEW_RESULT_YN='Y' )"); 
		}
		
		if(!priority.equals("") )
		{
			SqlStr.append(" and exists (select 1 from or_order ic where ic.order_id = SUBSTR (a.accession_num,                              INSTR (a.accession_num, '!') + 1, 15 ) and ic.PRIORITY=? )");
		}
		if(group_by.equals("E"))
		{
			if(result_yn.equals("Y"))
				SqlStr.append(" ORDER BY event ,1, a.hist_rec_type,  a.event_class, case when a.hist_rec_type='LBIN' AND CONTR_SYS_ID='LB' THEN  A.EVENT_AUTH_DATE_TIME ELSE event_date END, a.event_group, a.request_num_seq, a.event_code ");
			else
				SqlStr.append(" ORDER BY event ,1, a.hist_rec_type,  a.event_class, event_date, a.event_group, a.request_num_seq, a.event_code ");
		}
		else
		{
			if(result_yn.equals("Y"))
				SqlStr.append(" ORDER BY 1, a.hist_rec_type,  a.event_class, case when a.hist_rec_type='LBIN' AND CONTR_SYS_ID='LB' THEN  A.EVENT_AUTH_DATE_TIME ELSE event_date END, a.event_group, a.request_num_seq, a.event_code ");
			else
				SqlStr.append(" ORDER BY 1, a.hist_rec_type,  a.event_class, event_date, a.event_group, a.request_num_seq, a.event_code ");
		}
		
		stmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ");
		rs = stmt.executeQuery();
		if (rs.next())
		{
			legend_type = rs.getString(1) == null ? "S" : rs.getString(1);
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	
		if(normal_ind.equals(""))
		{
			strNormalcyInd = "nvl(NORMALCY_IND,'.')";
		}
		else if (normal_ind.equals("N"))
		{
			strNormalcyInd = "'.'";
		}
		else if (normal_ind.equals("A"))
		{
			stmt = con.prepareStatement("select ''''|| HIGH_STR   || '''' ||','||''''|| LOW_STR ||''''|| ','||''''|| ABN_STR|| '''' from cr_clin_event_param");
		}
		else if (normal_ind.equals("C"))
		{
			stmt = con.prepareStatement("select ''''|| CRIT_STR   || '''' ||','||''''|| CRIT_HIGH_STR ||''''|| ','||''''|| CRIT_LOW_STR|| '''' from cr_clin_event_param");	
		}

		if(!normal_ind.equals("") && (!normal_ind.equalsIgnoreCase("N"))) 
		{
			rs = stmt.executeQuery();
			if (rs.next())
			{
				strNormalcyInd = rs.getString(1);
			}
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
		}
		
		String SqlStr1 = SqlStr.toString();	
		SqlStr1 = replace(SqlStr1,"$",strNormalcyInd,"N");
		stmt = con.prepareStatement(SqlStr1);
		
		if(normal_ind==null) normal_ind = "";
		if(priority==null) priority = "";
		if(patientId==null) patientId = "";
		if(event_class==null) event_class = "";
		if (group_by==null) group_by = "";
		if (ca_normalcy_ind == null) ca_normalcy_ind = "";
		if (modal == null) modal = "";
		
		if(period_from.equals("null") || period_from.equals(" ")) period_from="";
		if(period_to.equals("null") || period_to.equals(" ")) period_to="";
		if (!localeName.equals("en"))
		{
			period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",localeName,"en");
			period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",localeName,"en");
		}

		int count = 1 ; 
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);
		stmt.setString(count++,localeName);//IN067651
		stmt.setString(count++,practitioner_id);
		stmt.setString(count++,resp_id);
		stmt.setString(count++,reln_id);
		stmt.setString(count++,patientId);
		stmt.setString(count++,event_class);
		if(result_yn.equals("Y"))
		{
			stmt.setString(count++,period_from);
			stmt.setString(count++,period_to);
			stmt.setString(count++,period_from);
			stmt.setString(count++,period_to);
		}
		else
		{
			stmt.setString(count++,period_from);
			stmt.setString(count++,period_to);
		}
		
		if(curr_enc.equals("Y"))
		{
		   stmt.setString(count++,encounter_id);	
		}
		if (status_crit.equals("P")||status_crit.equals("R"))
		{
			stmt.setString(count++,practitioner_id);
		}
		if (!result_type.equals(""))
			stmt.setString(count++,result_type);
		if (!priority.equals("") )
			stmt.setString(count++,priority);
		
		resultSet = stmt.executeQuery();

		if(resultSet!=null)
		{
			if(loop_start > 0)
		
			for(int i=0;(i<loop_start-1 && resultSet.next());i++);
		
			//while ( loop_start <= end && resultSet.next()) //Commented for IN066119
			while (  resultSet.next()) //Modified for IN066119
			{
				//String[] record = new String[46]; - commented for IN041153
				//String[] record = new String[47]; // modified for IN041153
				//String[] record = new String[48]; // modified for IN065970
				String[] record = new String[49]; // modified for IN067651
				record[0] = resultSet.getString( "episode_details" )  ;
				record[1] = resultSet.getString( "event" )  ;
				record[2] = resultSet.getString( "contr_sys_event_code" )  ;
				record[5] = resultSet.getString( "accession_num" )  ;
				record[6] = resultSet.getString( "hist_rec_type" )  ;
				record[7] = resultSet.getString( "contr_sys_id" )  ;
				record[8] = resultSet.getString( "pract_id" )  ;
				record[9] = resultSet.getString( "review_types" )  ;
				record[11] = resultSet.getString( "hist_data_type" )  ;
				record[12] = resultSet.getString( "reported_by" )  ;
				record[13] = resultSet.getString( "reported_at" )  ;
				record[14] = resultSet.getString( "authorized_by_id" )  ;
				record[15] = resultSet.getString( "event_auth_date_time" )  ;
				//IN064688 Changes starts
				//record[16] = resultSet.getString( "result_num" ) ;
				BigDecimal rm =resultSet.getBigDecimal("result_num");
				if(rm!=null)
				record[16]=rm.toString();
				else
				record[16]="";
				//IN064688 Changes Ends
				record[17] = resultSet.getString( "result_num_uom" )  ;
				record[18] = resultSet.getString( "result_str" )  ;
				//IN064688 Changes starts
				//record[19] = resultSet.getString( "normal_low" )  ;
				BigDecimal nl =resultSet.getBigDecimal("NORMAL_LOW");
				if(nl!=null)
				record[19]=nl.toString();
				else
				record[19]="";
				//record[20] = resultSet.getString( "normal_high" )  ;
				BigDecimal nh=resultSet.getBigDecimal("NORMAL_HIGH");
				if(nh!=null)
				record[20]=nh.toString();
				else
				record[20]="";
				//IN064688 Changes Ends
				record[21] = resultSet.getString( "normalcy_ind" )  ;
				record[22] = resultSet.getString( "ext_image_obj_id" )  ;
				record[23] = resultSet.getString( "ext_image_appl_id" )  ;
				record[24] = resultSet.getString( "practitioner_name" )  ;
				record[25] = resultSet.getString( "authorized_by_id" )  ;
				record[26] = resultSet.getString( "create_date_time" )  ;
				record[27] = resultSet.getString( "status" )  ;
				record[28] = resultSet.getString( "ordering_practitioner" )  ;
				record[29] = resultSet.getString("hist_rec_type_desc");
				record[30] = resultSet.getString("event_class_desc");
				record[31] = resultSet.getString("event_group_desc");
				record[32] = resultSet.getString("patient_id");
				record[33] = resultSet.getString("event_code");
				record[34] = resultSet.getString("event_group");
				record[35] = resultSet.getString("event_class");
				record[36] = resultSet.getString("hist_data"); 
				record[37] = resultSet.getString("requested_by_pract_id"); 
				record[38] = resultSet.getString("requested_by_pract_name"); 
				record[39] = resultSet.getString("Review_YN"); 
				record[40] = resultSet.getString("COLOR_CELL_IND"); 
				record[41] = resultSet.getString("DESC_CELL_IND"); 
				record[42] = resultSet.getString("normal_range_symbol"); 
				record[43] = resultSet.getString("result_num_prefix"); 
				record[44] = resultSet.getString("normalcy_str"); 
				record[45] = resultSet.getString("EXT_IMAGE_UPLD_ID"); // IN041153 
				record[47] = resultSet.getString("facility_id"); // IN065970 
				record[48] = resultSet.getString("resulted_prac_name"); // IN067651 
				
				allValues.add(record) ;
				loop_start++;
			}

			if (resultSet.next())
			{
				String[] templist = (String[])allValues.get(0);
				//templist[45] = ""+(end+7); - IN041153
				templist[46] = ""+(end+7); // IN041153
				allValues.set(0,templist);
			}
		}

		if(resultSet != null) resultSet.close();
		if(stmt != null) stmt.close();
	}//try ends
	catch ( Exception e )
	{
		e.printStackTrace() ; 
	} 
	// commented for IN041153 - Start
	/*finally 
	{
		ConnectionManager.returnConnection(con,request);
	}*/
	// commented for IN041153 - End
	String result_data[] = (String[])bean.getAbnormalCondition();

	String high_str			= result_data[0];
	String low_str			= result_data[1];
	String abn_str			= result_data[2];

	String crit_str			= result_data[3];
	String crit_high_str	= result_data[4];
	String crit_low_str		= result_data[5];
	String tooltip			= "";
	String result			= "";

	if(allValues.size() == 0)
	{

            _bw.write(_wl_block10Bytes, _wl_block10);
	
	}
	if(allValues.size() != 0)
	{

            _bw.write(_wl_block11Bytes, _wl_block11);

	}

            _bw.write(_wl_block12Bytes, _wl_block12);

	String 	episode_details				= "";
	String temp_episode_details         = "";
	String 	event						= "";
	String 	contr_sys_event_code		= "";
	String 	order_id					= "";
	String 	accession_num				= "";
	String 	hist_rec_type				= "";
	String 	contr_sys_id				= "";
	String 	review_types				= "";
	String 	review_type					= "";
	String 	hist_data_type				= "";
	String 	reported_at					= "";
	String 	result_num					= "";
	String 	result_num_prefix			= "";
	String 	result_num_uom				= "";
	String 	result_str					= "";
	String 	result_str_disp				= "";
	String 	normal_low					= "";
	String 	normal_high					= "";
	String 	normalcy_ind				= "";
	String 	ext_image_obj_id			= "";
	String 	ext_image_appl_id			= "";
	String 	practitioner_name			= "";
	String 	create_date_time			= "";
	String  status						= "";
    String  ordering_practitioner		= "";
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
    String  requested_by_pract_id       = "";
    String  requested_by_pract_name     = "";
    String  Review_YN					= "";
    String  chk_disable					= "";
	String  status_desc					= "";
	String  event_auth_date_time		= "";
	Boolean ckh_flag					= false;
	
	StringBuffer disp_value = new StringBuffer();
	String slClassValue = "";
	String[] record  = null;
	int j=1;//Added for IN066119
	
	for(int i=0; i<allValues.size(); i++)
	{
		record  = (String[])allValues.get(i);
		if (record[0].indexOf(",") != -1)
		{
			StringTokenizer fieldTokenizer = new StringTokenizer(record[0],",");
			record[0] = "";
		
			while (fieldTokenizer.hasMoreTokens())
			{
				String tempToken = fieldTokenizer.nextToken();
		 
				if((tempToken.indexOf('/'))==1)
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
		
		episode_details				= CommonBean.checkForNull(record[0]);
		event						= CommonBean.checkForNull(record[1]);
		contr_sys_event_code		= CommonBean.checkForNull(record[2]);
		accession_num				= CommonBean.checkForNull(record[5]);
		hist_rec_type				= CommonBean.checkForNull(record[6]);
		contr_sys_id				= CommonBean.checkForNull(record[7]);
		review_types				= CommonBean.checkForNull(record[9]);
		hist_data_type				= CommonBean.checkForNull(record[11]);
		reported_at					= CommonBean.checkForNull(record[13]);
		reported_at					= com.ehis.util.DateUtils.convertDate(reported_at,"DMYHM","en",localeName);
		event_auth_date_time		= CommonBean.checkForNull(record[15]);
		result_num					= CommonBean.checkForNull(record[16]);
		result_num_uom				= CommonBean.checkForNull(record[17]);
		result_str					= CommonBean.checkForNull(record[18]);
		normal_low					= CommonBean.checkForNull(record[19]);
		normal_high					= CommonBean.checkForNull(record[20]);
		normalcy_ind				= CommonBean.checkForNull(record[21]);
		ext_image_obj_id			= CommonBean.checkForNull(record[22]);
		ext_image_appl_id			= CommonBean.checkForNull(record[23]);
		//IN067651 changes starts
		//practitioner_name			=CommonBean.checkForNull(record[24]);
		if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
		{
			practitioner_name			=CommonBean.checkForNull(record[48]);
		}else{
			practitioner_name			=CommonBean.checkForNull(record[24]);
		}
		//IN067651 changes ends
		create_date_time			= CommonBean.checkForNull(record[26]);
		create_date_time			= com.ehis.util.DateUtils.convertDate(create_date_time,"DMYHM","en",localeName);
		status						= CommonBean.checkForNull(record[27]);
		ordering_practitioner		= CommonBean.checkForNull(record[28]);
		hist_rec_type_desc          = CommonBean.checkForNull(record[29]);
		event_class_desc            = CommonBean.checkForNull(record[30]);
		event_group_desc            = CommonBean.checkForNull(record[31]);
		patient_id                  = CommonBean.checkForNull(record[32]);
        event_code                  = CommonBean.checkForNull(record[33]);
        event_group                 = CommonBean.checkForNull(record[34]);
        event_class_code            = CommonBean.checkForNull(record[35]);
		result			            = CommonBean.checkForNull(record[36]);
		requested_by_pract_id	    = CommonBean.checkForNull(record[37]);
		requested_by_pract_name     = CommonBean.checkForNull(record[38]);
		Review_YN					= CommonBean.checkForNull(record[39]);
		color_cell_ind				= CommonBean.checkForNull(record[40]);
		desc_cell_ind				= CommonBean.checkForNull(record[41]);
		normal_range_symbol			= CommonBean.checkForNull(record[42]);
		result_num_prefix			= CommonBean.checkForNull(record[43]);
		normalcy_str				= CommonBean.checkForNull(record[44]);
		ext_image_upld_id			= CommonBean.checkForNull(record[45]); // IN041153
		fac_id						= CommonBean.checkForNull(record[47]); // IN065970 reopen
		if(normal_low == null || normal_low.equals(""))
		{
			normal_low = "";
		}
		if(normal_high == null || normal_high.equals(""))
		{
			normal_high = "";
		}
	
		if(legend_type.equals("C"))
			color_cell_indicator = color_cell_ind; 
		else if(legend_type.equals("S"))
			color_cell_indicator = normal_range_symbol; 
		
		if(!status.equals("") && status.equals("C"))
		{
			slClassValue = "ORSTATUSPARTIAL";
			tooltip      = "This result has been Modified";
		}
		else
		{
			tooltip = "";
			slClassValue="gridData";
		} 
		
		if(Review_YN.equals("Y"))
		{
			chk_disable="";
			ckh_flag = true;
			status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingReview.label","ca_labels");
		}
		else
		{
			chk_disable="disabled";	
			status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Reviewed.label","ca_labels");
		}

		if(i==0)
		{
			//if(record[45] != null) //- IN041153
			if(record[46] != null) // IN041153
			//total_query_records = bean.checkForNull((String)record[45],"0"); - IN041153
			total_query_records = bean.checkForNull((String)record[46],"0"); // IN041153

            _bw.write(_wl_block13Bytes, _wl_block13);
            {java.lang.String __page ="ViewResultsResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("chk")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("review_results_dtl")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block20Bytes, _wl_block20);
				
		}
		disp_value = new StringBuffer();
 		disp_value.append("&nbsp;");
		//IN066119 start
		if("Y".equals(hideSpecimenType))
			result_str="";
		//IN066119 ends
		
		if(result_str.length()>10)
		{
			result_str_disp=result_str.substring(0,9);
		}
		else
		{
			result_str_disp = result_str;
		}
				
		tempNormCritStr.setLength(0);
		if(hist_data_type.trim().equals("NUM"))
		{
			//Added by Jyothi.G on 09/12/2010 to fix IN025310
			if(!normal_low.equals("") && !normal_high.equals(""))
				details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : " + normal_low + " " + result_num_uom +" to "+ normal_high + " " + result_num_uom ;
			else if(!normal_low.equals(""))
				details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (>=" + normal_low + " " + result_num_uom + ")";
			else if(!normal_high.equals(""))
				details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (<=" + normal_high + " " + result_num_uom + ")";//END
							
			if(!color_cell_indicator.equals(""))
			{
				if(legend_type.equals("S"))
					disp_value.append("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				else
					disp_value.append("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' title='"+details1+"'' >&nbsp;&nbsp;</font>&nbsp;");
			}
			else
			{
				if(normalcy_ind.equals("."))
				{
					if(legend_type.equals("S"))
						disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
					else
						disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				}
				else if(!normal_low.equals("") && !normal_high.equals(""))
				{
					if(Float.parseFloat(result_num) > 0)
					{
						if((Float.parseFloat(result_num) >= Float.parseFloat(normal_low)) && (Float.parseFloat(result_num) <= 	Float.parseFloat(normal_high)))
						{
							if(legend_type.equals("S"))
								disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
							else
								disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
						}
					}
				}
				else if(!normal_low.equals("") && normal_high.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
				{
					if(Float.parseFloat(result_num) > 0)
					{
						if(Float.parseFloat(result_num) >= Float.parseFloat(normal_low))
						{
							if(legend_type.equals("S"))
								disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
							else
								disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
						}
					}
				}
				else if(normal_low.equals("") && !normal_high.equals(""))
				{
					if(Float.parseFloat(result_num) > 0)
					{
						if(Float.parseFloat(result_num) <= 	Float.parseFloat(normal_high))
						{
							if(legend_type.equals("S"))
								disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
							else
								disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
						}
					}
				}//END
			}
			//IN067037 changes starts
			/*
			//IN053093 Starts
			if(Float.parseFloat(result_num) < 1)
			{
				disp_value.append(result_num_prefix+Float.parseFloat(result_num) + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;");
			}
			else
			{
				disp_value.append(result_num_prefix+result_num + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;");
			}
			//IN053093 Ends
			*/
			if(!result_num.equals("")){
					disp_value.append(result_num_prefix+result_num + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;");
			}
			//IN067037 changes ends
			if(result_str!=null && !result_str.equals(""))
			{
				if(result_str.length()>11)
				{
					disp_value.append("<br> "+result_str_disp );
				}
				else
				{
					disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+result_str_disp+"... </a>");
				}
			}
			if(result!=null && !result.equals(""))
			{
				disp_value.append( "<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		} 
		else if(hist_data_type.trim().equals("STR"))
		{
			if(!color_cell_indicator.equals(""))
			{
			   if(legend_type.equals("S"))
				   disp_value.append("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			   else
				  disp_value.append("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' title='"+details1+"'' >&nbsp;&nbsp;</font>&nbsp;");
			}
			else if(normalcy_ind.equals("."))
			{
				if(legend_type.equals("S"))
					disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				else
					disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			}
			if(result_str!=null && !result_str.equals(""))
			{				
				if(result_str.length()<11)
				{
					disp_value.append("<br> "+result_str_disp );
				}
				else
				{
					disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+result_str_disp+"... </a>");
				}

			}
			if(!normalcy_str.equals(""))
			{
				disp_value.append(" <font color=blue>( Normal Value : " + normalcy_str + " )</font>");
			}
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		} 
		else if(hist_data_type.trim().equals("TXT"))
		{
			if(!color_cell_indicator.equals(""))
			{
			   if(legend_type.equals("S"))
				   disp_value.append("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			   else
				  disp_value.append("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' title='"+details1+"'' >&nbsp;&nbsp;</font>&nbsp;");
			}
			else if(normalcy_ind.equals("."))
			{
				if(legend_type.equals("S"))
					disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				else
					disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			}
			if(result_str!=null && !result_str.equals(""))
			{
				if(result_str.length()>11)
				{
					disp_value.append("<br> "+result_str_disp );
				}
				else
				{
					disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+result_str_disp+"... </a>");
				}
			}
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		}
		else if(hist_data_type.trim().equals("HTM"))
		{
			if(!color_cell_indicator.equals(""))
			{
			   if(legend_type.equals("S"))
				   disp_value.append("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			   else
				  disp_value.append("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' title='"+details1+"'' >&nbsp;&nbsp;</font>&nbsp;");
			}
			else if(normalcy_ind.equals("."))
			{
				if(legend_type.equals("S"))
					disp_value.append("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
				else
					disp_value.append("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' title='"+details1+"' >&nbsp;&nbsp;</font>&nbsp;");
			}
			if(result_str!=null && !result_str.equals(""))
			{				
				if(result_str.length()>11)
				{
					disp_value.append("<br> "+result_str_disp );
				}
				else
				{
					disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+result_str_disp+"... </a>");
				}
			}
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobDataHtm('"+accession_num+"','"+hist_data_type+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		}
		//7902 STARTS
		if(!ext_image_appl_id.equals("")&& ext_image_appl_id.equals("CPACS"))
		{
		
			ext_img_disable="disabled";
			
			pstmtImgView1 = con.prepareStatement("SELECT PARAM_DEF_STR  FROM CA_EXT_IMAGE_APPL_LANG_VW WHERE  EXT_IMAGE_APPL_ID=?"); 
			pstmtImgView1.setString(1,ext_image_appl_id);
			resImgView1 = pstmtImgView1.executeQuery();
			
			while(resImgView1.next())
			{
				param_def_str = resImgView1.getString("PARAM_DEF_STR") == null ? "" : resImgView1.getString("PARAM_DEF_STR");
			}
			if(pstmtImgView1!=null) pstmtImgView1.close();
			if(resImgView1!=null) resImgView1.close();
			
			if(!param_def_str.equals("") && param_def_str.contains("~STUDY_ID`")){
				pstmtImgView = con.prepareStatement("SELECT A.study_id  FROM or_order_line a, cr_encounter_detail b WHERE B.EXT_IMAGE_APPL_ID =? AND to_char(a.ext_appl_accession_num) = b.ext_image_obj_id AND b.ext_image_obj_id=?"); 
				pstmtImgView.setString(1,ext_image_appl_id);
				pstmtImgView.setString(2,ext_image_obj_id);
				resImgView = pstmtImgView.executeQuery();
				
				while(resImgView.next())
				{
					study_id = resImgView.getString("STUDY_ID") == null ? "" : resImgView.getString("STUDY_ID");
				}
				
				if(pstmtImgView!=null) pstmtImgView.close();
				if(resImgView!=null) resImgView.close();
			}
			
		}
		if(study_id.equals("null"))
			study_id="";
		if(!study_id.equals("") && param_def_str.contains("~STUDY_ID`"))
		{
			ext_img_disable="";
			ext_img_display="Result";
		} 
		else if(!study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
		{
			ext_img_disable="";
			ext_img_display="Result";
		} 
		else if(study_id.equals("") && param_def_str.contains("~STUDY_ID`")&& ext_image_appl_id.equals("CPACS"))
		{
			ext_img_disable="disabled";
			ext_img_display="Study ID not available, we cannot Proceed";
		}
		else if(study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
		{
			ext_img_disable="";
			ext_img_display="Result";
		}	//7902 ENDS
					
		
		if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
			pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
			pstmtImgView.setString(1,ext_image_upld_id);
			resImgView = pstmtImgView.executeQuery();
			String recCountInt = "";
			String perfFacilityId = "";  
			while(resImgView.next())
			{
				ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
			}
			
			pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
			pstmtPerFacId.setString(1,ext_image_obj_id);
			rsetPerFacId = pstmtPerFacId.executeQuery();
			if(rsetPerFacId.next()){
				perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
			}
			// IN052800 - Start
			if(perfFacilityId.equals("") || perfFacilityId == null){
				perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(ext_image_obj_id);
			}
			//IN052800 - End
			//IN065970 starts
			//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?"); 
			pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?"); 
			/*pstmtImgCount.setString(1,perfFacilityId);
			pstmtImgCount.setString(2,ext_image_obj_id);
			pstmtImgCount.setString(3,event_group);*/
			
			pstmtImgCount.setString(1,ext_image_obj_id);
			pstmtImgCount.setString(2,event_group);
			//IN065970 ends
			rsetImgCount = pstmtImgCount.executeQuery();
			if(rsetImgCount.next()) 
			{
				recCount = rsetImgCount.getInt(1);
			}
			recCountInt = String.valueOf(recCount);
			//IN065970 reopen starts
			//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",user_id).replace("~language_id#",localeName); 
			ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",user_id).replace("~language_id#",localeName); 
			//IN065970 reopen ends
			
			
			if(resImgView  != null) resImgView.close();
			if(pstmtImgView != null) pstmtImgView.close();

			if(rsetImgCount  != null)  rsetImgCount.close();
			if(pstmtImgCount  != null) pstmtImgCount.close();

			if(rsetPerFacId  != null) rsetPerFacId.close();
			if(pstmtPerFacId  != null) pstmtPerFacId.close();
		}
		
		
		// End	

		//if ((ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_appl_id!=null && !ext_image_appl_id.equals("")) )
	/*	if ((ext_image_appl_id!=null && !ext_image_appl_id.equals("")) )
		{
			disp_value.append("<br><a class='gridLink' href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"')\"> ");
			disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='XRAY' align=center></a>");
		}*/ //Commentted for EMG
		
		//Added docul condition for EMG
		if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
		{
			if(!("DMS").equals(ext_image_appl_id)) { // added for IN041153
				//if(!("DOCUL").equals(ext_image_appl_id)) // commented for IN041153
				if(!("DOCUL").equals(ext_image_appl_id) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))) // added for IN041153
				{
					//IN050936 included patient_id	
					if(ext_img_disable.equals("disabled")){
					disp_value.append("<br><a class='gridLink'> ");
					disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 "+ext_img_disable+" alt='"+ext_img_display+"'></a>");
					}
					else{
						disp_value.append("<br><a class='gridLink'  href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+ext_image_obj_id+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\"> ");
						disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='"+ext_img_display+"'></a>");
					}
					
				}
				else  if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")) // added for IN041153
				{
					//IN050936 included patient_id
					if(ext_img_disable.equals("disabled")){
						disp_value.append("<br><a class='gridLink'> ");
						disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 "+ext_img_disable+"  alt='"+ext_img_display+"'></a>");
						}
						else{
							disp_value.append("<br><a class='gridLink'  href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\"> ");
							disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='"+ext_img_display+"'></a>");
						}
					
				} 
				else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) { // added for IN041153 - Start
					disp_value.append("<br><a class='gridLink'  href=\"javascript:viewUploadedImg('"+ext_img_file_locn+"')\">" );
					disp_value.append(" View Image </a>");
				} // added for IN041153 - End
			}  	
								
		}

		disp_value.append("<a class='gridLink' href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' title='Previous Results' border='0' align=center></img></a>");

		if(status.equals("P"))
			disp_value.append("<font color='red'>(Preliminary)</font>");

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(contr_sys_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(contr_sys_event_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(review_types));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(create_date_time));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_group));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_class_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((record[21]==null)?"":record[21]));
            _bw.write(_wl_block46Bytes, _wl_block46);
 
		if(!group_by.equals("E"))
		{
			if (!temp_episode_details.equals(episode_details))
			{ 

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(episode_details));
            _bw.write(_wl_block48Bytes, _wl_block48);

			temp_episode_details = episode_details;
			temp_res_event_header = "";
			}
			if(!temp_res_event_header.equals(hist_rec_type_desc+"/"+event_class_desc))
			{

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(hist_rec_type_desc+"/"+event_class_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);

				temp_res_event_header =  hist_rec_type_desc+"/"+event_class_desc;
			}

            _bw.write(_wl_block51Bytes, _wl_block51);

			if (event_group_desc.equals(""))
			{
				//IN066119 starts
				j++;
				temp_event_group_desc="";
				temp_order_id ="";
				//IN066119 ends

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(event));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disp_value));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block64Bytes, _wl_block64);
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block66Bytes, _wl_block66);

				if(result_yn.equals("Y") && hist_rec_type.equals("LBIN") && contr_sys_id.equals("LB"))
					out.println(event_auth_date_time+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecimenCollectedAt.label","ca_labels")+" : "+reported_at+")");
				else
					out.println(reported_at);

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ordering_practitioner));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(status_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);

			}
			else
			{
				if ((!temp_event_group_desc.equals(event_group_desc))|| (!temp_order_id.equals(order_id)))
				{   
					j++;//IN066119

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(j));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(j));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(mainGrpDisable));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(event_group_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(event));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disp_value));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block88Bytes, _wl_block88);
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block66Bytes, _wl_block66);

						if(result_yn.equals("Y") && hist_rec_type.equals("LBIN") && contr_sys_id.equals("LB"))
							out.println(event_auth_date_time+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecimenCollectedAt.label","ca_labels")+" : "+reported_at+")");
						else
							out.println(reported_at);

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ordering_practitioner));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(status_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);

					temp_order_id=order_id;temp_event_group_desc = event_group_desc;
				}
				else
				{

            _bw.write(_wl_block92Bytes, _wl_block92);
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(event));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disp_value));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block96Bytes, _wl_block96);
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block66Bytes, _wl_block66);

						if(result_yn.equals("Y") && hist_rec_type.equals("LBIN") && contr_sys_id.equals("LB"))
							out.println(event_auth_date_time+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecimenCollectedAt.label","ca_labels")+" : "+reported_at+")");
						else
							out.println(reported_at);

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ordering_practitioner));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(status_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);

				}
			}

            _bw.write(_wl_block97Bytes, _wl_block97);
  	}
		else
		{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(event));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disp_value));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block66Bytes, _wl_block66);

				if(result_yn.equals("Y") && hist_rec_type.equals("LBIN") && contr_sys_id.equals("LB"))
					out.println(event_auth_date_time+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecimenCollectedAt.label","ca_labels")+" : "+reported_at+")");
				else
					out.println(reported_at);

            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(episode_details));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ordering_practitioner));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(status_desc));
            _bw.write(_wl_block105Bytes, _wl_block105);

		}
	}

            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(from));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(to));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(requested_by_pract_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(requested_by_pract_name));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(allValues.size()));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block115Bytes, _wl_block115);
//=bean.getFunctionId()
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)request.getParameter("priority")));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf((String)request.getParameter("normalcy_ind")));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf((String)request.getParameter("result_type")));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf((String)request.getParameter("patientId")));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf((String)request.getParameter("event_class")));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf((String)request.getParameter("groupby")));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf((String)request.getParameter("patient_class")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf((String)request.getParameter("ca_normalcy_ind")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf((String)request.getParameter("modal")));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf((String)request.getParameter("period_from")));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf((String)request.getParameter("period_to")));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf((String)request.getParameter("status_crit")));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(ckh_flag));
            _bw.write(_wl_block129Bytes, _wl_block129);

	putObjectInBean(bean_id,bean,request);

	} // added for IN041153
	catch(Exception ex) {
		System.out.println(" 1084. View ResultsDetail.jsp ===> " + ex.getMessage());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
