package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.AuthorizeAtIssueStoreBean;
import eST.AuthorizeAtIssueStoreDetailBean;
import java.text.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __authorizeatissuestorelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/AuthorizeAtIssueStoreList.jsp", 1742808056628L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link> \n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/AuthorizeAtIssueStore.js\"></script>\n\t</head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body >\n\t\t<form name=\'formAuthorizeAtIssueStoreList\' id=\'formAuthorizeAtIssueStoreList\'>\n\t\t\t<table border=\'1\' width=\'100%\' cellpadding=\'0\' cellspacing=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<td class = \"OARED\">&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t<td width=\'48%\' class=\"LABEL\">&nbsp; ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t<td class = \"OAYELLOW\">&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t<td width=\'48%\' class=\"LABEL\">&nbsp; ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table name =\"tblItemList\" border=\'1\' width=\'100%\' cellpadding=\'0\' cellspacing=\'0\'>\n \t\t\t<tr>\n\t\t\t\t<th width=\"2%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<th onclick =\"changeOrder();\" width=\"22%\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;&nbsp;&nbsp;<img src=\"../../eST/images/Ascending.gif\" alt=\"Ascending Order\" border=none> </th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;&nbsp;&nbsp;<img src=\"../../eST/images/Descending.gif\" alt=\"Descending Order\" border=none> </th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<th width=\"22%\" style=\"WORD-BREAK:BREAK-ALL;\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<th width=\"6%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t\t<th width=\"8%\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th><!-- Added for MMS-DM-CRF-0097  -->\n\t\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n \t\t\t\t <!-- MO-CRF-20173 -->\n \t\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n \t\t\t\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" align=\'left\'>\n\t\t\t\t\t\t<a name=\"a";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"a";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">&nbsp;&nbsp;</a>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  align=\'left\' style=\"WORD-BREAK:BREAK-ALL;\" title=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" nowrap align=\'right\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<!-- Added for MMS-DM-CRF-0097  -->\n\t\t\t\t\t</td> \n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  Style = \" COLOR : #F40000  \" nowrap align=\'right\' title =\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"><B>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</B>&nbsp; </td>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" nowrap align=\'right\' >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp; </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\n\n\t\t\t\t</tr>\n\t\t\t\t\t<input type=\"hidden\" name=\"item_code_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"item_code_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"issuing_item_qty_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"issuing_item_qty_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\n\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">&nbsp;&nbsp;</a>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" style=\"WORD-BREAK:BREAK-ALL;\" align=\'left\' onClick=\"displayItemDetail(";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =");\" onMouseOver=\"changeCursor(this);\" title=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<font class=\"HYPERLINK\">\n\t\t\t\t\t\t<!--\t<java.net.URLDecoder.decode(detailBean.getItem_desc(),\"UTF-8\")%>  commented against GHL-SCF-1097 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t</font>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" style=\"WORD-BREAK:BREAK-ALL;\" align=\'left\' onClick=\"\" onMouseOver=\"\" title=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t<!--\t<java.net.URLDecoder.decode(detailBean.getItem_desc(),\"UTF-8\")%>  commented against GHL-SCF-1097 -->\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" nowrap align=\'right\' title=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t</td>\n\t\t\t\t       \n\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" nowrap align=\'right\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<!-- Added for MMS-DM-CRF-0097  --> \n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t<!-- MO-CRF-20173 -->\n \t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\n\t\t\t\t</tr>\n\t\t\t\t\t<input type=\"hidden\" name=\"item_code_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"total_checkboxes\" id=\"total_checkboxes\"\t\tvalue=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t<input type=\"hidden\" name=\"records\" id=\"records\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t<input type=\"hidden\" name=\"records_for_submission\" id=\"records_for_submission\"  value=\"\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t<input type=\"hidden\" name=\"doc_type_code\" id=\"doc_type_code\"\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"doc_no\" id=\"doc_no\"\t\t\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"doc_date\" id=\"doc_date\"\t\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"doc_ref\" id=\"doc_ref\"\t\t\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"request_by_store\" id=\"request_by_store\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"request_on_store\" id=\"request_on_store\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"item_class_code\" id=\"item_class_code\"\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"finalize_yn\" id=\"finalize_yn\"\t\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"autono_yn\" id=\"autono_yn\"\t\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"view_cost\" id=\"view_cost\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"> \n\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\n<script language=\"JavaScript\">\n\tstatusOfItem();\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t<script>\n\tprevObj=document.getElementById(\'tr_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\')\n\tprevColor=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\tprevSerColor=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\n\t// Commented by Sakti and passed prevObj index instead of item code. Problem happening if item_code is having \"-\" and \".\"\n\t//document.getElementById(\"a\")";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =".scrollIntoView();\n\t//document.getElementById(\"a\")";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =".scrollIntoView();\n\tdocument.getElementById(\'a";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\').scrollIntoView();\n\tdocument.getElementById(\'a";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\').scrollIntoView(); \n</script>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n</html>\n\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );
	
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

/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
20/04/2017		63281			B.Badmavathi								     To display Available Quantity at Request Store 
20/10/2021		TFS-24350			Shazana					20/10/2021		Manickam				MO-CRF-20173
--------------------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String bean_id							=			"authorizeAtIssueStoreBean";
		String bean_name						=			"eST.AuthorizeAtIssueStoreBean";
		String item_code						=			request.getParameter("item_code");
		String className						=			"";
		String prevObj							=			"";
		String prevColor						=			"";
		String prevSerColor						=			"";
		java.util.ArrayList alItemKeys			=			new java.util.ArrayList();
		java.util.ArrayList delListItems			=			new java.util.ArrayList();

		java.util.ArrayList alAddedItemKeys		=			null;
		java.util.HashMap hmItemStore			=			null;


		String mode								=			request.getParameter("mode");
		String function_id						=			request.getParameter("function_id");
		String itemStoreKey						=			"";
		AuthorizeAtIssueStoreBean bean			=			(AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
 	/**
	* @Name - Mahesh
	* @Date - 19/01/2010
	* @Inc# - IN015496
	* @Desc - No.of Decimals is storeed in a temp variable as this page displays more than one item at a time.
	*/
		int no_of_decimals_temp			=		bean.getNoOfDecimals();
		int no_of_decimals				=		0;
		alItemKeys.addAll(bean.getItemKeys());
		alAddedItemKeys							=			bean.getAddedItemKeys();
		if (alAddedItemKeys != null && alAddedItemKeys.size() >0) {
			alItemKeys.addAll(alAddedItemKeys);
		}
		hmItemStore								=		bean.getHmItemDetail();
		ArrayList	errorItems					=		bean.getKitErrorData();
		String severity							=		"";
		int i=0,j=1;
		String trObject							=		bean.checkForNull(request.getParameter("trObject"));
		String kit12							=		bean.checkForNull(request.getParameter("kit12"));
		double req_qty								=		0; 
		float unit_cost							=		0.0f;
		String stk_value						=		"0";
		String cost								=		"0";
		String	view_cost						=		bean.checkForNull((String)	bean.fetchRecord("select VIEW_COST_YN  from MM_VIEW_COST_FOR_USER where APPL_USER_ID=?",(String) session.getValue( "login_user" ) ).get("VIEW_COST_YN"),"N");
      
           try {
	        String[] strParameters = new String[3];
			
			strParameters[0] = bean.getDoc_no();
            strParameters[1] = bean.getDoc_type_code();
			strParameters[2] = CommonBean.getLoginFacilityId();
             delListItems = (ArrayList)bean.fetchRecords("SELECT distinct item_code FROM st_issue_dtl idtl, st_issue_hdr ihdr WHERE ihdr.doc_no = ? and  ihdr.doc_type_code = ? and ihdr.facility_id = ? and   ihdr.doc_no = idtl.doc_no AND ihdr.doc_type_code = idtl.doc_type_code AND ihdr.facility_id = idtl.facility_id AND ihdr.seq_no = idtl.seq_no AND ihdr.finalized_yn = 'D'",strParameters);
	
		   } catch (Exception ex)
		   {
		   ex.printStackTrace();
		   throw ex;
		   }

		   /**
			 * @Name - Priya
			 * @Date - 27/05/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
			int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
		boolean close_item_auth_appl=false;//MO-CRF-20173
		Connection con = null;
		try {
			con = ConnectionManager.getConnection();
			close_item_auth_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST", "ST_CLOSE_ITEM_AT_AUTHORIZE");
			System.err.println("value for close_item_auth_appl: " + close_item_auth_appl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in site specific " + e);
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, request);
		} //MO-CRF-20173 END
	
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
if(alItemKeys.size()>1){
					if(((String)bean.getTogglePoint()).equals("ASC")){
				
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}else if(((String)bean.getTogglePoint()).equals("DESC")){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
		}
				 }else{
				
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(view_cost.equals("Y")){
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

				int m = 0;
			String strCloseItemVal= ""; //MO-CRF-20173
				if (alItemKeys != null && (alItemKeys.size()>0)) {
					 int totalSize = alItemKeys.size();
					m = totalSize-1;
					AuthorizeAtIssueStoreDetailBean detailBean;
					for (i=0,j=1;	i<totalSize;	i++,j++){
						//Mahesh Sorting
						if(((String)bean.getTogglePoint()).equals("ASC")){
							itemStoreKey = (String) bean.arTempCode.get(m);
							m--;
							//itemStoreKey = (String) alItemKeys.get(i);
						}
						else if(((String)bean.getTogglePoint()).equals("DESC"))
							itemStoreKey = (String) bean.arTempCode.get(i);
						else
							itemStoreKey	= (String) alItemKeys.get(i);
			
							detailBean		= (AuthorizeAtIssueStoreDetailBean) hmItemStore.get(itemStoreKey);
							strCloseItemVal = detailBean.getClose_item_yn();//MO-CRF-20173
							if(strCloseItemVal==null || strCloseItemVal.equals("")){
								strCloseItemVal = "N";
							}//MO-CRF-20173
							// Added for GHL-SCF-1097 starts						
							String 	item_desc = detailBean.getItem_desc();
							item_desc = item_desc.replaceAll(" ","%20");
							item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
							item_desc = item_desc.replaceAll("%2520","%20");		
							// Added for GHL-SCF-1097 ends
			/**
			 * @Name - Priya
			 * @Date - 23/06/2010
			 * @Inc# - 20890
			 * @Desc -  To get CONVERSION FACTOR
			 */
				double convFactorReqonStore=bean.getConvFactTemp(detailBean.getItem_code(),bean.getRequest_on_store());
 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - If Decimals is allowed for that item, then No.of decimals is assigned to the variable else 0.
	*/
						if((bean.getAllowDecimalsYN((String)detailBean.getItem_code())).equals("Y")){
							no_of_decimals = no_of_decimals_temp;
						}else{
							no_of_decimals = 0;
						}
						if (detailBean != null) {
							className			=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
							if (detailBean.getSeverity_color().equals("HIGH")) {
								severity		=	"OARED";
							}
							else if (detailBean.getSeverity_color().equals("LOW")) {
								severity		=	"OAYELLOW";
							}
							else {
								severity		=	className;
							}
						String comm_qty =	bean.checkForNull(detailBean.getCommitted_item_qty(),"0");
					if(bean.getRequestStatus().equals("A") || bean.getRequestStatus().equals("P"))
					  
					  {
					   
					   if(!((comm_qty).equals("0")))
					    
					        {
                          
							detailBean.setIssuing_item_qty("0");  
						    
							}
					}

							if(!detailBean.getReq_on_min_stk_level().equals(""))
							{
							   if((Double.parseDouble(detailBean.getReq_on_qty_on_hand())*(bean.getConvFactTemp((String)detailBean.getItem_code(),(String)bean.getRequest_on_store())))<(Double.parseDouble(detailBean.getReq_on_min_stk_level())))
								{
								  								  
								  severity		=	"OARED";
								  
								}
							}
							if (item_code!=null){
								if (item_code.equals(detailBean.getItem_code())) {
									prevObj			=	""+i;
									prevColor		=	className;								
									prevSerColor	=	severity;								
									className		=	"STLIGHTPINK";

								}
							}
					double qty_diff =0;
					if (!detailBean.getReq_by_max_stk_level().equals(""))
						{
									double Max_by_qty=Double.parseDouble(detailBean.getReq_by_max_stk_level())*(bean.getConvFactTemp((String)detailBean.getItem_code(),(String)bean.getRequest_by_store()));
                                  
									qty_diff		= (Double.parseDouble(detailBean.getReq_by_qty_on_hand() )+Double.parseDouble(detailBean.getIssuing_item_qty())) - Double.parseDouble(""+Max_by_qty) ;
									//qty_diff = Integer.parseInt(detailBean.setNumber((""+qty_diff),3));
									
						}
					String kit						=	"";
					for(int k=0;k<errorItems.size();k++){
						if(((String)detailBean.getItem_code()).equals((String)errorItems.get(k))){
							kit = "kit";
							break;
						}
					}
					if(kit.equals("kit")){
					unit_cost = Float.parseFloat((String)bean.checkForNull(detailBean.getUnit_cost(),"0.0"));
					/**
					 * @Name - Priya
					 * @Date - 23/06/2010
					 * @Inc# - 20890
					 * @Desc -  To convert base qty to Issue Stock UOM Qty
					 */
					//req_qty =	Double.parseDouble((String)bean.checkForNull(detailBean.getReq_item_qty(),"0"))/convFactorReqonStore;
					req_qty =	Double.parseDouble((String)bean.checkForNull(detailBean.getReq_item_qty(),"0"));
					stk_value = bean.setNumber(""+unit_cost*req_qty,noOfDecimalsForCost);
					cost =bean.setNumber(""+unit_cost,noOfDecimalsForCost);
					
					detailBean.setIssuing_item_qty("0");
				
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(severity));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(className));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(detailBean.getItem_code()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLDecoder.decode(detailBean.getItem_desc(),"UTF-8")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getReq_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(view_cost.equals("Y")){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cost));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(stk_value));
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getCommitted_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getIssued_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getPending_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getReq_on_qty_on_hand(),"0"),no_of_decimals)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.getReq_by_avail_qty(detailBean.getItem_code()) ));
            _bw.write(_wl_block36Bytes, _wl_block36);

					if (qty_diff > 0)
					{
					String exceec_stock_level=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.exceedmaxStockLevel.label","st_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels");
					String qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels");
					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(className));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(exceec_stock_level));
            out.print( String.valueOf(qty_diff));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(qty_legend));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getIssuing_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block41Bytes, _wl_block41);
 }
					else
							{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(className));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getIssuing_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block44Bytes, _wl_block44);
	} 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(detailBean.getItem_code()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(detailBean.getIssuing_item_qty()));
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(severity));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
 if(detailBean.getCommitted_item_qty().equals("0")) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(className));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(detailBean.getItem_code()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(detailBean.getItem_desc()));
            _bw.write(_wl_block56Bytes, _wl_block56);
  } if(!(detailBean.getCommitted_item_qty().equals("0")) || delListItems.contains(detailBean.getItem_code()) ) { 
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(className));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(detailBean.getItem_code()));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(detailBean.getItem_desc()));
            _bw.write(_wl_block60Bytes, _wl_block60);
 } 
            _bw.write(_wl_block33Bytes, _wl_block33);

					unit_cost = Float.parseFloat((String)bean.checkForNull(detailBean.getUnit_cost(),"0.0"));
					/**
					 * @Name - Priya
					 * @Date - 23/06/2010
					 * @Inc# - 20890
					 * @Desc -  To convert base qty to Issue Stock UOM Qty
					 */
					//req_qty =	Double.parseDouble((String)bean.checkForNull(detailBean.getReq_item_qty(),"0"))/convFactorReqonStore;
					//Added against inc#50521 
					req_qty =	Double.parseDouble((String)bean.checkForNull(detailBean.getReq_item_qty(),"0"));
					stk_value =bean.setNumber(""+(unit_cost*req_qty),noOfDecimalsForCost);
					cost =bean.setNumber(""+unit_cost,noOfDecimalsForCost);
					
					
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getReq_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(view_cost.equals("Y")){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(className));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(cost));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(stk_value));
            _bw.write(_wl_block63Bytes, _wl_block63);

					}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getCommitted_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getIssued_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getPending_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(className));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(""+(Double.parseDouble(detailBean.getReq_on_qty_on_hand()))),no_of_decimals)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.getReq_by_avail_qty(detailBean.getItem_code()) ));
            _bw.write(_wl_block66Bytes, _wl_block66);

					if (qty_diff > 0)
					{
					String exceec_stock_level=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.exceedmaxStockLevel.label","st_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels");
					String qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels");
					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(className));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(exceec_stock_level));
            out.print( String.valueOf(qty_diff));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(qty_legend));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getIssuing_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block41Bytes, _wl_block41);
 }
					else
							{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(className));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull(detailBean.getIssuing_item_qty(),"0"),no_of_decimals)));
            _bw.write(_wl_block44Bytes, _wl_block44);
	} 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(className));
            _bw.write(_wl_block32Bytes, _wl_block32);

					if(detailBean.getClose_item_yn().equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");  
				
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(detailBean.getItem_code()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(detailBean.getIssuing_item_qty()));
            _bw.write(_wl_block69Bytes, _wl_block69);

					}}
				}
			}
			
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bean_name ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(view_cost));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block79Bytes, _wl_block79);
	
	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block80Bytes, _wl_block80);
if(trObject.length() > 1){
            _bw.write(_wl_block1Bytes, _wl_block1);
 } 
            _bw.write(_wl_block3Bytes, _wl_block3);
if (item_code!=null) {
	if(kit12.equals("kit12")){
	
            _bw.write(_wl_block81Bytes, _wl_block81);

		}
	
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(prevObj));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(prevColor));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(prevSerColor));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(prevObj));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(prevObj));
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block90Bytes, _wl_block90);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BelowMinimumStockLevel.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BelowRe-OrderLevel.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.S.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ReqQty.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Cost.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StockValue.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.CommittedQty.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssuedQuantity.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PendingQty.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvlQtyatIssueStore.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvlQtyatReqStore.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AuthorizeQuantity.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.CloseItem.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
