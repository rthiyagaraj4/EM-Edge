package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.IssueBean;
import java.util.ArrayList;
import java.util.HashMap;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __issuedetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/IssueDetail.jsp", 1720615557201L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n\t\t<title> </title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/Issue.js\"></script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t</head>\n<body>\n<form name=\'formIssueDetail\' id=\'formIssueDetail\' action=\"../../eST/jsp/IssueHistoryResult.jsp\" method=\"post\"  target=\"formIssueHistoryResult\">\n<div name=\'msg\' id=\'msg\' style=\"position:absolute;width: 0; height: 0; left: 201; top: 80;\">\n\t</div>\t\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\'>\n\t<tr>\t\n\t<td class=label>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t<input type=\"text\" name=\"search_str\" id=\"search_str\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" size=25 maxlength=50 onclick=\"blockFormSubmit();if(this.value!=\'\'){this.select()};\" onkeyPress=\"CallBarcodeVerifyItems(event,this)\"></td>&nbsp;&nbsp;\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<input type=\"text\" name=\"search_str\" id=\"search_str\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" size=25 maxlength=50>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t</td>\n\t<td class=label><img src=\"../images\\GoIcon16Cool.gif\" id=\"go\" onclick=\"locateItem(event,search_str);\" title=\"Locate Item\" ></img></td>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</tr>\n\t</table>\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=300 align=center>\n\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t<!-- Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014 -->\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<th>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </th>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\n\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" style=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\n\t\t\t\t<td align=\'center\' width=\'1\' class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"> \n\t\t\t\t\t<input type=\'checkbox\' name=\"checkbox";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"checkbox";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" checked disabled>\n\t\t\t\t</td>\n\t\t\t\t<!-- //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014 -->\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td align=\'center\' width=\'1\' class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"> \n\t\t\t\t\t<input type=\'checkbox\' name=\"hold_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"hold_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"  disabled>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<input type=\"hidden\" name=\"item_desc_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"item_desc_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t\t\t<td width=\'230\' class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" style=\"WORD-BREAK:BREAK-ALL;\">\n\t\t\t<font size=1>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<br>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =":&nbsp;&nbsp;<span style=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =":";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</span></font>&nbsp;<a style=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =";\'href=\"javascript:callItemSpcfnWindow(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',document.formIssueDetail.item_desc_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =");\"><img onmouseover=\"onMOver(msg,event,\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\"   onMouseout=\"onMOut(msg);\"  src=\'../../eST/images/info.gif\' alt=\"Item Remarks/Specification\"  ></img></a>\n\t\t\t</td>\n\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\n\t\t\t<td align=\'center\' width=\'1\' class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"> \n\t\t\t\t <input type=\'checkbox\' name=\"checkbox";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"  ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" onclick = \"chkstatus(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');\">\n\t\t\t</td>\n\t\t\t<!-- //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014 -->\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<td align=\'center\' width=\'1\' class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"> \n\t\t\t\t <input type=\'checkbox\' name=\"hold_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"   ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="  ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="  onclick = \"chkholdstatus(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\');\">\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<!-- ends -->\n\n\t\t\t<td width=\'230\' class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" style=\"WORD-BREAK:BREAK-ALL;\">\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t<img src=\"../images\\info1.gif\" title=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" height=12 >&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t<!--<font size=1><a name=\"a_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" href=\"javascript:modifyData(";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =");setTempConvFactor(";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =");\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&nbsp;&nbsp;<span style=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</span></font></a>-->\n\n\t\t\t\t<font size=1>\n\t\t\t\t<a name=\"a_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"a_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&nbsp;</a>\n\t\t\t\t<a style=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =";\' href=\"javascript:callItemSpcfnWindow(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =");\"> <img onmouseover=\"onMOver(msg,event,\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\');\"   onMouseout=\"onMOut(msg);\"  src=\'../../eST/images/info.gif\' ></img></a>\n\t\t\t\t<a href=\"javascript:modifyData(";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =");\"><br>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</span></font></a>\n\t\t\t\t<input type=\"hidden\" name=\"item_desc_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"barcode_item_exist_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"barcode_item_exist_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" > \n\t\t\t\t<input type = \"hidden\" name = \"item_hold_close_yn_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" value = \"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n\t\t\t</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t</table>\n\t<input type=\"hidden\" name=\"total_checkboxes\" id=\"total_checkboxes\"\t\tvalue=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\"hidden\" name=\"records_to_delete\" id=\"records_to_delete\"\t\tvalue=\"\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t<input type=\"hidden\" name=\"close_yn\" id=\"close_yn\"\t\t\t\tvalue=\"\">\n\t<input type=\"hidden\" name=\"tmp_conv\" id=\"tmp_conv\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t<input type=\"hidden\" name=\"remarks\" id=\"remarks\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t<input type=\"hidden\" name=\"count\" id=\"count\"\t\t\t\t\tvalue=\"\">\n\n\t<input type=\"hidden\" name=\"BARCODE_YN\" id=\"BARCODE_YN\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t<input type=\"hidden\" name=\"validatebarcode\" id=\"validatebarcode\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t</form>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n</body>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t<script>\n\t\tsetTimeout(\"parent.frameIssueList.frameIssueListHeader.example();\",300);//example1();\n\t</script>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n<script language=\"JavaScript\">\n\tdocument.getElementById(\"a_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\").scrollIntoView();\n\tchangeRowColor(document.getElementById(\"tr_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"));\t\n</script>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n <script language=\"JavaScript\">\n changeRowColorForBarcode(";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =");\n </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" \n \n</html>\n\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );
	
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
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       		Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
15/10/2019		IN071552			Shazana Hasan								TBMC-SCF-0099 
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try
	{
	
	int i							=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String avail_qty				=		"";
	String item_code				=		"";
	String remarks					=		"";
	String search_str				=		"";
	String item_desc = "";

	String tmp_conv					=		(String)request.getParameter("tmp_conv");
	String kit12					=		(String)request.getParameter("kit12")==null?"":(String)request.getParameter("kit12");
	String kit_temp_code			=		(String)request.getParameter("kit_temp_code")==null?"":(String)request.getParameter("kit_temp_code");
	String usage_type				=		(String)request.getParameter("usage_type")==null?"":(String)request.getParameter("usage_type");  

	
	ArrayList alDetailData			=		new ArrayList();
	mode							=		request.getParameter( "mode" ) ;

	function_id						=		request.getParameter( "function_id" ) ;
	search_str						=		request.getParameter( "search_str" )==null?"":request.getParameter( "search_str" ) ;
	bean_id							=		"issueBean" ;
	bean_name						=		"eST.IssueBean";												 
	HashMap expdtl					=		new HashMap();

	IssueBean bean					=		(IssueBean)getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);

 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	
	String BARCODE_YN					=		request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");

	int no_of_decimals_temp			=			bean.getNoOfDecimals();
	int no_of_decimals				=			0;
	
	//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-feb-2014
	String  display_hold		   =	  "";
	String iss_item_hold_yn        =      "Y";
	String iss_item_hold_chk       =      "N";
	String iss_hold_item_disabled  =      "";
	String iss_hold_item_checked   =      "";
	String Close_yn                =      "N";   
	//ends
	
	//alDetailData					=		bean.getDtlRecords();//bean.getDetailValues();this one
	//alDetailData					=		bean.getDetailValues();

	ArrayList dummy = new ArrayList();

	if (BARCODE_YN.equals("TRUE"))
	alDetailData		=		bean.getDtlRecordsforBarCode()==null?dummy:bean.getDtlRecordsforBarCode();
	else
	alDetailData		=		bean.getDtlRecords();
  
	String temp						=		request.getParameter("arr")==null?"":request.getParameter("arr");

	java.util.StringTokenizer st	=		new java.util.StringTokenizer(temp,",");

	ArrayList arr					=		new ArrayList();

	while( st.hasMoreElements()){
			arr.add(st.nextElement() );
	}

	//expdtl							=		bean.getExpRecords();

	if (BARCODE_YN.equals("TRUE"))
		expdtl					=		bean.getExpRecordsforBarCode();
	else
		expdtl					=		bean.getExpRecords();
	
	boolean validatebarcode		=	bean.isBarCodeApplicableForValidation("VALIDATEBARCODE",bean.checkForNull(bean.getTrn_type(),"URG"));//Added for RUT-CRF-0079
	
	//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	 String trn_type = "URG";
	 if(bean.getTrn_type () != null) 
		trn_type					=		bean.getTrn_type ();
	 
	 if(trn_type.equals("ISS"))
		display_hold   = "visible";
		boolean site = bean.isSite_spec_yn();//Added for GHL-CRF-0413
	 //ends


            _bw.write(_wl_block10Bytes, _wl_block10);
 if(!site){//Added for GHL-CRF-0413
if(validatebarcode && !bean.checkForNull(mode).equals("1")){

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_str));
            _bw.write(_wl_block12Bytes, _wl_block12);

}else{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(search_str));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
} //Added for GHL-CRF-0413
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if(display_hold.equals("visible")){
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);


	if(mode==null){
		mode				=		"1";
	}

		HashMap ht					=		null;
		String classValue			=		"";
		String item_qty				=		"";
		String alt_text				=		"";
		HashMap rol_min				=		null;
		int expired_batch			=		0;
		String nod					=		"";
		Double qty					=		0.0;
		String to_store_max_qty		=		"";
		String to_store_qty_on_hand =		"";
		String display_flag			=		"visibility:hidden";
		String display_flag1		=		"display:";
		boolean display_gif			=		false;
		int EWDays					=		bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
		String barcode_item_exist	=		"";
		String locate_item			=		request.getParameter("locate_item")==null?"N":request.getParameter("locate_item");
		String exp_yn					=		"";//IN071552

	
		for(i=0;i<alDetailData.size();i++)
		{
			display_flag1		=		"display:";
			qty=0.0;
			if(((String)bean.getAccessCostDetails()).equals("Y")){
				display_flag		=		"visibility:visible";
			}
			ht					=		(HashMap)alDetailData.get(i);
				
			remarks				=		(String)ht.get("remarks");
			bean.setRemarks(remarks); //corrected by Sakti Sankar against inc#-720
			 String chk_chcked = "";
		    String chk_disabled = "";
			if(!((((String)ht.get("item_desc")).toLowerCase()).startsWith(search_str.toLowerCase())) &&  (locate_item.equals("Y") || !validatebarcode)){
				display_flag1   =		"display:none";
			}
			if(i%2==0){
				classValue	=		"QRYEVEN";
			}else{
				classValue	=		"QRYODD"; 
			}
			
		
		//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
				HashMap hmRecord	=	null;
				String spcfn_img_display;
				hmRecord = bean.getItemSpecfnRemarks(bean.checkForNull((String)ht.get("item_code")),bean.getLanguageId());
				String item_specfin_name = CommonBean.checkForNull((String)hmRecord.get("ITEM_SPECIFICATION"),"");
				String item_remarks = CommonBean.checkForNull((String)hmRecord.get("ITEM_REMARKS"),"");
				spcfn_img_display="display:inline";
				if(item_specfin_name.equals("") && item_remarks.equals("")) {
					spcfn_img_display="display:none";
				}

				if(!item_specfin_name.equals("")){
					item_specfin_name = item_specfin_name.replaceAll(" ","%20");
					item_specfin_name = java.net.URLEncoder.encode(item_specfin_name,"UTF-8");
					item_specfin_name = item_specfin_name.replaceAll("%2520","%20");
				}
					if(!item_remarks.equals("")){
					item_remarks = item_remarks.replaceAll(" ","%20");
					item_remarks = java.net.URLEncoder.encode(item_remarks,"UTF-8");
					item_remarks = item_remarks.replaceAll("%2520","%20");
				}
				//Added ends
				//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
				item_desc = (String)ht.get("item_desc");
				item_desc = item_desc.replaceAll(" ","%20");
				item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
				item_desc = item_desc.replaceAll("%2520","%20");
				//Added ends
		if(((bean.checkForNull((String)ht.get("expiry_yn"))).equals("XX"))||(bean.checkForNull((String)ht.get("item_unit_cost"))).equals("")||((String)ht.get("stock_available")).equals("0")){
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(display_flag1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(display_hold.equals("visible")){
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ht.get("item_desc")));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ht.get("item_cost_value")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(spcfn_img_display));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.checkForNull((String)ht.get("item_code"))));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(item_specfin_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(item_remarks));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
				expired_batch				=		0;
				for(int k=0; k<((ArrayList)expdtl.get(i+"")).size(); k++){
				nod							=		(String)((HashMap)((ArrayList)expdtl.get(i+"")).get(k)).get("NOD");
				exp_yn							=   (String)((HashMap)((ArrayList)expdtl.get(i+"")).get(k)).get("EXPIRY_YN"); //IN071552
				
					qty=qty+Double.parseDouble((String)((HashMap)((ArrayList)expdtl.get(i+"")).get(k)).get("QTY"));
					if( (Integer.parseInt(nod) < EWDays) && (exp_yn.equalsIgnoreCase("Y")) ){  //IN071552
						expired_batch++;
					}
				}
				classValue					=		"";
				item_code					=		(String)ht.get("item_code") ;
 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
				if((bean.getAllowDecimalsYN((String)ht.get("item_code"))).equals("N")){
					no_of_decimals = 0;
				}else{
					no_of_decimals = no_of_decimals_temp;
				}
				//avail_qty					=		bean.checkForNull((String)bean.getDtlRecord(Integer.parseInt(i+"")).get("stock_available"),"0");	
				
				if (BARCODE_YN.equals("TRUE"))
				avail_qty		=		bean.checkForNull((String)bean.getDtlRecordforBarCode(Integer.parseInt(i+"")).get("stock_available"),"0");	
				else
				avail_qty		=		bean.checkForNull((String)bean.getDtlRecord(Integer.parseInt(i+"")).get("stock_available"),"0");	




				item_qty					=		bean.checkForNull((String)ht.get("item_qty"),"0");
				
				rol_min						=		bean.getROL((String)ht.get("item_code"),(String)ht.get("store_code"));

			if(((String)bean.getAccessCostDetails()).equals("Y")){
				display_flag				=		"visibility:visible";
			}
			//to_store_max_qty			=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
			//to_store_qty_on_hand		=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	

			if (BARCODE_YN.equals("TRUE")){
			to_store_max_qty			=		bean.checkForNull((String)bean.getMinMaxRecordforBarcode(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
			to_store_qty_on_hand		=		bean.checkForNull((String)bean.getMinMaxRecordforBarcode(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	
			}else{
			to_store_max_qty			=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
			to_store_qty_on_hand		=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	
			}


			alt_text					=		"";
			display_gif					=		false;
			if(expired_batch > 0){
				String exp_batch			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
				alt_text					=		expired_batch +exp_batch;
			}
			//if(i%2==0) classValue			=		"QRYEVEN";
			//else		classValue			=		"QRYODD"; 

			


			  String kit_usage_type = "";

			  /*if(ht.containsKey("kit_temp_code")){
				 kit_usage_type = bean.checkForNull((String)bean.getUsageType((String)ht.get("kit_temp_code"),(String)ht.get("item_code")));
			  }*/
			   if(ht.containsKey("usage_type")){
				 kit_usage_type = bean.checkForNull((String)ht.get("usage_type"));
			  }
			  
			  if(kit_usage_type.equals("R")){
			      chk_chcked   ="";
			      chk_disabled = "disabled";
			      }
			   else if(kit_usage_type.equals("O")){
			      chk_chcked   ="";
			     chk_disabled = "";
			   }
			  
			   else if(kit_usage_type.equals("P")){
			    chk_chcked   ="checked";
			    chk_disabled = "";
			   }
			    else if(kit_usage_type.equals("D")){
				chk_chcked   ="checked";
			    chk_disabled = "disabled";				
				}
    			 
			  
			  barcode_item_exist =	bean.checkForNull((String)ht.get("barcode_item_exist"));//added for RUT-CRF-0079;
			  
			  //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014	
			      Close_yn = bean.checkForNull(bean.getClose_yn(),"N");
				 if(trn_type.equals("ISS") && Close_yn.equals("N")){ 
					 
			    iss_item_hold_yn = bean.checkForNull((String)ht.get("iss_item_hold_yn"),"Y");
			    iss_item_hold_chk = bean.checkForNull((String)ht.get("iss_item_hold_chk"),"N");
			    iss_hold_item_disabled = "";
			    iss_hold_item_checked  = "";
			    
			    if(iss_item_hold_chk.equals("Y")){ 
			    	iss_hold_item_checked  = "checked";
				  }
					  if(iss_item_hold_yn.equals("N")){
						  iss_hold_item_disabled = "disabled";
						  iss_hold_item_checked  = "";
					  } 
				 }else{
					 iss_hold_item_disabled = "disabled";
					  iss_hold_item_checked  = "";
					 
				 }
			  //ends
			  
			  
			
			
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(display_flag1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(chk_chcked));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(chk_disabled));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
if(display_hold.equals("visible")){
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(iss_hold_item_disabled ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(iss_hold_item_checked ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
 
					if ( (Double.parseDouble(avail_qty) - Double.parseDouble(item_qty))  <  Double.parseDouble(bean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0"))){
						String less_than_min_stock		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.LessThanROLinFromStore.label","st_labels");
						alt_text						=		less_than_min_stock+"\n" + alt_text;
						//alt_text						=		alt_text + "Less Than R.O.L in From Store \n";
						display_gif						=		true;
					}
					if ( (Double.parseDouble(avail_qty) - Double.parseDouble(item_qty))  <  Double.parseDouble(bean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0"))){
						String BelowMinStkinFromStore	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.BelowMinStkinFromStore.label","st_labels");
						alt_text						=		alt_text+ BelowMinStkinFromStore+"\n";
						//alt_text						=		alt_text + "Below Min. Stk. in From Store \n";
						display_gif						=		true;
					}
					if (expired_batch > 0){
						display_gif = true;
					}
					if ( !(to_store_max_qty == null || to_store_max_qty.equals(""))){
						if ( (Double.parseDouble(to_store_qty_on_hand) + Double.parseDouble(item_qty))  >  Double.parseDouble(to_store_max_qty))
						{
						String ExceedsMaxStkinToStore	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExceedsMaxStkinToStore.label","st_labels");
						alt_text						=	alt_text+ExceedsMaxStkinToStore+"\n";
							//alt_text					=	alt_text + "Exceeds Max. Stk. in To Store \n";
							display_gif					=	true;
						}
					}
					if (display_gif) {
					
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(alt_text));
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tmp_conv));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ht.get("item_desc")));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.setNumber(""+qty,no_of_decimals)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ht.get("item_cost_value")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tmp_conv));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ht.get("item_desc")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(spcfn_img_display));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bean.checkForNull((String)ht.get("item_code"))));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(item_specfin_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(item_remarks));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tmp_conv));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.setNumber(""+qty,no_of_decimals)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ht.get("item_cost_value")));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(barcode_item_exist));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(iss_item_hold_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
		}
	}
		bean.getTempBatchRecords().clear();//Added for GHL-CRF-0413

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( function_id ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(tmp_conv));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( BARCODE_YN ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( validatebarcode ));
            _bw.write(_wl_block91Bytes, _wl_block91);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block92Bytes, _wl_block92);

	if(kit12.equals("kit")){

            _bw.write(_wl_block93Bytes, _wl_block93);
}
 if (request.getParameter("index")!=null && !(kit12.equals("kit"))) {

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( (request.getParameter("index").equals("-1") ? "" + (i - 1) : request.getParameter("index")) ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf( (request.getParameter("index").equals("-1") ? "" + (i - 1) : request.getParameter("index")) ));
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);

}
	catch(Exception exception){
		System.out.println("exception..in issue..."+exception.getMessage());
		System.err.println("exception..in issue..."+exception.getMessage());
		exception.printStackTrace();
	}

            _bw.write(_wl_block99Bytes, _wl_block99);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hold.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ItemDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
}
