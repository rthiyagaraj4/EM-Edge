package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __itemsearchqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ItemSearchQueryResult.jsp", 1742813401665L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"Javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t\t<script language=\"Javascript\" src=\"../../eST/js/ItemSearch.js\"> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\n</head>\n<body>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<form name=ItemsearchForm id=ItemsearchForm  >\n\t\t\t\n\t\t\t<div name=\'msg\' id=\'msg\' style=\"position:fixed; width: 0; height: 0; left: 201; top: 62\">\n\t\t\t</div>\n\t\t\t<table cellpadding=2 cellspacing=0 width=\"100%\"  align=center>\n\t\t\t<tr>\n\t\t\t<table border=\"1\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\"  id=\'tb1\'>\n\t\t\t<th width=\'10%\'  class=\'CAGROUP_HEADING\' nowrap><a href=\"javascript:ordercols(\'ITEM_CODE\');\"><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b></a></th>\n\t\t\t<th width=\'1%\'  class=\'CAGROUP_HEADING\'><a href=\"javascript:ordercols(\'ITEM_DESC\');\"><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></a></th>\n\t\t\t<th width=\'3%\'  class=\'CAGROUP_HEADING\'><a href=\"javascript:ordercols(\'EXPIRY_YN\');\"><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></a></th>\n\t\t\t<th width=\'1%\'  class=\'CAGROUP_HEADING\'><a href=\"javascript:ordercols(\'UOM_DESC\');\"><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></a></th>\n\t\t\t<th width=\'3%\'  class=\'CAGROUP_HEADING\'><a href=\"javascript:ordercols(\'ITEM_CLASS_DESC\');\"><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></a></th>\n\t\t\t<th width=\'3%\'  class=\'CAGROUP_HEADING\'><a href=\"javascript:ordercols(\'ALPHA_CODE\');\"><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></a></th>\n\t\t\t<th width=\'3%\'  class=\'CAGROUP_HEADING\'><a href=\"javascript:ordercols(\'GEN_UOM_DESC\');\"><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></a></th><!-- Added by suresh.r on 08-08-2014 against  MMS-SCF-0390 -->\n\t\t\t<!--Added by Sakti sankar against AMRI-CRF-100024 and AMS-CRF-0028-->\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<th width=\'1%\'  class=\'CAGROUP_HEADING\' nowrap><a href=\"javascript:ordercols(\'QTY_ON_HAND\');\"><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></a></th>\n\t\t\t<th width=\'3%\'  class=\'CAGROUP_HEADING\' nowrap><a href=\"javascript:ordercols(\'AVAILABLE_QTY\');\"><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></a></th>\n\t\t\t<!-- //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 -->\n\t\t\t<th width=\'1%\'  class=\'CAGROUP_HEADING\' nowrap><a href=\"javascript:ordercols(\'MIN_STR_QTY\');\"><b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b></a></th>\n\t\t<th width=\'3%\'  class=\'CAGROUP_HEADING\' nowrap><a href=\"javascript:ordercols(\'REORDER_LEVEL\');\"><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></a></th>\n\t\t<th width=\'3%\'  class=\'CAGROUP_HEADING\' nowrap><a href=\"javascript:ordercols(\'MAX_STR_QTY\');\"><b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</b></a></th>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<script>\n\t\t\t\t//returnVals(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\",\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\");\n\t\t\t\treturnVals(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n<!-- \t\t\t\t<tr onClick=\"returnVals(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\" >\n -->\t\t\t\t<tr onClick=\"returnVals(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');\" >\n\t\t\t\t\t<!--commented by Rabbani #Inc no:35672 on 19/10/12\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"   onmouseover=\"changeCursor(this);onMMove(msg,event,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\');\"   onMouseout=\"onMOut(msg);\" nowrap><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font></td>\n\t\t\t\t\t \n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></td> -->\n\t\t\t\t\t\n\n\t\t\t\t\t<!--  Added by Sakti against AMS-CRF-0011 Function Specific enable and disable hyper link -->\n\t\t\t\t\t<!-- Modified if cdn by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 added trn_type.equals(\"PRQ\") -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<!-- <td class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onmouseover=\"changeCursor(this);onMMove(msg,event,\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font></td> -->\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" style=\"cursor: pointer;\" onclick=\"onMMove(msg,event,\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\"><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</font></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" onclick=\"onMMove(msg,event,\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="  style=\"cursor: pointer;\" onclick=\"onMMove(msg,event,\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="><font class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</font></td> \n\t\t\t\t\t\t\t<!--<td class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" onmouseover=\"onMMove(msg,event,\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');  changeCursor(this); \" ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="  onMouseout=\"onMOut(msg);\" nowrap><font class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</font></td>-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t<!-- Added by Sakti against AMS-CRF-0011 to disable item code hyperlink if available qty is zero --> \n\t\t\t\t\t\t<!--<td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</font></td>-->\n\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'); \" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"><font style=\"cursor: pointer;\" class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</font></td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t<!-- Added ends Function Specific enable and disable hyper link -->\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"   onclick=\"disableClick(event);\" nowrap  >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&nbsp;<a style=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =";\' href=\"javascript:callimageframe(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\"><img  src=\'../../eST/images/Arrow.png\' alt=\"Item Image\"  ></img></a>&nbsp;&nbsp;<a style=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =";\'  href=\"javascript:callItemSpcfnWindow(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\');\"><img onmouseover=\"onMOver(msg,event,\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\');\"   onMouseout=\"onMOut(msg);\"  src=\'../../eST/images/info.gif\'   ></img></a></td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"   onclick=\"disableClick(event);\" nowrap>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="<img  src=\'../../eCommon/images/enabled.gif\'></img>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="<img  src=\'../../eCommon/images/disabled.gif\'></img>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td><!-- Added by suresh.r on 08-08-2014 against  MMS-SCF-0390 -->\n\t\t\t\t\t<!--Added by Sakti sankar against AMRI-CRF-100024-Inc#32850 and AMS-CRF-0028-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" style=\"TEXT-ALIGN:right\"   onclick=\"disableClick(event);\" >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t</tr> \n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" \n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\" >\n\t\t\t<input type=\"hidden\" name=\"short_desc\" id=\"short_desc\" >\n\t\t\t<input type=\"hidden\" name=\"store_desc\" id=\"store_desc\"\tvalue=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t<input type=\"hidden\" name=\"alpha_code\" id=\"alpha_code\" >\n\t\t\t<input type=\"hidden\" name=\"machine_code\" id=\"machine_code\" >\n\t\t\t<input type=\"hidden\" name=\"spare_part_id\" id=\"spare_part_id\" >\n\t\t\t<input type=\"hidden\" name=\"start\" id=\"start\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\"hidden\" name=\"end\" id=\"end\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\"\t\tvalue=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\t\t\t<input type=\"hidden\" name=\"displaySize\" id=\"displaySize\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t<input type=\"hidden\" name=\"count\" id=\"count\"\t\t\t\tvalue=\"1\">\n\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t<input type=\"hidden\" name=\"img_path\" id=\"img_path\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t <script>\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'==\"IC\" && ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="==true){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tchangeRadVal();\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\tparent.qryCriteria.document.ItemSearchCriteria_Form.next.disabled=true;\t\t\t\t\t\t\n\t\t\t\t\t\tparent.qryCriteria.document.ItemSearchCriteria_Form.previous.disabled=true;\n\t\t\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n</body>\n</form>\n<script>activeLink();</script>\n</html>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );
	
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



public String replaceNewLineChar(String message) {
		String changed			=		"";
        changed					=		 message.replaceAll("\n","\\n/");
		changed					=		 changed.replaceAll("\"","\\\"");
		changed					=		 changed.replaceAll("'","\\\\'");	
        return changed;
}
 /*/ Modified on 5/9/2006  as per TSG request
   public String replaceNewLineChar(String message) {
	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]={"\n","\"","'"};
        String chChar[]={"\\n/","\\\"","\\\'"};
        sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
					{
                    for(int j=0;j<spChar.length;j++)
                    {
                        if(spChar[j].equals(String.valueOf(sb.charAt(i))))
                        {
                            sb.deleteCharAt(i);
                            sb.insert(i,chChar[j].toCharArray());
							i+=chChar[j].length();
							System.err.println("J="+j+" =="+sb);
                            continue upper;
                        }
                    }
System.err.println("i="+i+" =="+sb);
					}
	}
	catch(Exception e)
	{
		sb.append("Exception@replaceNewLineChar : "+e.toString());
	}
	System.err.println("Return string="+sb.toString());
        return sb.toString();
    } */


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
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603			Badmavathi B						GHL-CRF-0456
---------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

			 request.setCharacterEncoding("UTF-8");
			String locale			=		(String)session.getAttribute("LOCALE");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	String mfg_base_qty					=			"";
	String curr_supp_code				=			"";
	String uom_desc						=			"";
	String manufacture_desc				=			"";
	String min_stk_qty					=			"";
	String max_stk_qty					=			"";
	String long_desc					=			"";
	String ps_item_yn					=			"";
	String sole_source_yn				=			"";
	String manufacturer_id				=			"";
	String gen_uom_code					=			"";
	String unit_cost					=			"";
	String mfg_item_yn					=			"";
	String medical_item_yn				=			"";
	String abc_class_code				=			"";
	String machine_code					=			"";
	String spare_part_id				=			"";
	String trade_id_applicable_yn		=			"";
	String batch_id_applicable_yn		=			"";
	String classvalue					=			"";
	String expiryyn						=			"";
	String item_code					=			"";
	String item_name					=			"";
	String item_class					=			"";
	String alpha_code					=			"";
	String consignment					=			"";
	String preparation_type				=			"";
	String preparation_mode				=			"";
	String str_uom_code					=			"";
	String gen_uom_desc					=			"";
	String req_uom_code					=			"";
	String allow_decimals_yn			=			"";
	int	no_of_decimals					=			0;

	int maxRec							=			0; 
	int start							=			0;
	int end								=			0;
	int displaySize						=			0;
	int count							=			0;
	String item_specfin_name = "";
	String item_remarks = "";
	String qty_on_hand = "";
	String avl_qty = "";
	
	String min_str_qty = "";
	String max_str_qty = "";
	String reorder_level = "";

	String from							=			request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=			request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String radioval						=			request.getParameter( "radioval" )==null?"IC":request.getParameter( "radioval" ) ;
	String trn_type						=			request.getParameter( "trn_type" )==null?"":request.getParameter( "trn_type" ) ; //Added by Sakti against AMS-CRF-0011
	String search_no					=			request.getParameter( "search_no" )==null?"":request.getParameter( "search_no" ) ; //Added by suresh.r on 17-06-2014 against
	
	String bean_id						=			 "ItemSearchBean";
	String bean_name					=			 "eST.ItemSearchBean";
	ItemSearchBean bean					=			(ItemSearchBean) getBeanObject( bean_id,bean_name,request);

	//need to remoce
	String img_path = bean.checkForNull((String)(((HashMap)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_IMAGE_CATLG_PATH_SELECT"),bean.getLoginFacilityId())).get("ITEM_IMAGE_CATLG_PATH")));
	

	
	String store_desc					=			CommonBean.checkForNull(bean.getStore_desc(),"");

	String store_code					=			CommonBean.checkForNull(bean.getStore_code(),"");
	//String item_class_code			=			CommonBean.checkForNull(bean.getItem_class(),"");
	
	
	store_desc							=			store_desc.equals("%")?"":store_desc;
	store_code							=			store_code.equals("%")?"":store_code;
	bean.setLanguageId(locale);
//	String search_string				=			bean.getSearch_string();
	boolean search						=			bean.getSearch() ;

	//if(radioval=="IC")search			=			true;
	ArrayList result					=			new ArrayList();	
	HashMap dataList					=			null;
	try{
		result							=			bean.getDataList();
		maxRec							=			result.size();
		displaySize						=			Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize						=			Integer.parseInt("12");
		if ( from == null || from =="" )
			start						=			0;
		else
			start						=			Integer.parseInt( from ) ;
		if ( to == null || to ==""){
			end							=			displaySize ;
		}
		else{
			end							=			 Integer.parseInt( to ) ;	
		}
		if(result.size() > 0 ){
		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(!store_code.equals("")){
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}//Added ends
			count	= start;
			int chkCount = 0;
			String img_display;
			String spcfn_img_display; //Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
			while ( count < maxRec && count < end)
			{
				dataList = (HashMap)result.get(count);
				//Added by Sakti sankar against CRF#12 and INC#29966	
				String []parameters = {bean.checkForNull((String)dataList.get("ITEM_CODE")),bean.getLoginFacilityId()};
				String img_file_name = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getStRepositoryValue("SQL_IMAGE_FILE_NAME_SELECT"),parameters)).get("FILE_NAME"));
				
				System.out.println("img_file_name"+img_file_name);
				img_display="display:none";
				if(!img_file_name.equals("")) {
					img_display="display:inline";
				}
				//Added ends

				//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
				
				HashMap hmRecord	=	null;
				hmRecord = bean.getItemSpecfnRemarks(bean.checkForNull((String)dataList.get("ITEM_CODE")),bean.getLanguageId());
				item_specfin_name = CommonBean.checkForNull((String)hmRecord.get("ITEM_SPECIFICATION"),"");
				item_remarks = CommonBean.checkForNull((String)hmRecord.get("ITEM_REMARKS"),"");
				spcfn_img_display="display:inline";
				if(item_specfin_name.equals("") && item_remarks.equals("")) {
					spcfn_img_display="display:none";
				}
			   //Added ends
			   
			   /*Added by suresh.r on 08-08-2014 against  MMS-SCF-0390 beg
				String []param = {bean.checkForNull((String)dataList.get("ITEM_CODE")),bean.getLanguageId()};
				String base_uom_desc = bean.checkForNull((String)((HashMap)bean.fetchRecord("SELECT AM.SHORT_DESC DESCR FROM MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE MM.GEN_UOM_CODE=AM.UOM_CODE AND MM.LANGUAGE_ID=AM.LANGUAGE_ID AND MM.ITEM_CODE=? AND MM.LANGUAGE_ID=?",param)).get("DESCR"));
				Added by suresh.r on 08-08-2014 against  MMS-SCF-0390 end*/

				if ( count % 2 == 0 )
					classvalue				=			"QRYEVEN" ;
				else
					classvalue				=			 "QRYODD" ;
	
				mfg_base_qty				=			CommonBean.checkForNull((String)dataList.get("MFG_BASE_QTY"),"0");
				machine_code				=			CommonBean.checkForNull((String)dataList.get("MACHINE_CODE"));
				min_stk_qty					=			CommonBean.checkForNull((String)dataList.get("MIN_STK_QTY"),"0");
				max_stk_qty					=			CommonBean.checkForNull((String)dataList.get("MAX_STK_QTY"),"0");

				long_desc					=			CommonBean.checkForNull((String)dataList.get("LONG_DESC"));
				
				if(!long_desc.equals("")){
					long_desc = long_desc.replaceAll(" ","%20");
					long_desc = java.net.URLEncoder.encode(long_desc,"UTF-8");
					long_desc = long_desc.replaceAll("%2520","%20");
				}
				
				//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
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

				ps_item_yn					=			CommonBean.checkForNull((String)dataList.get("PS_ITEM_YN"),"N");
				sole_source_yn				=			CommonBean.checkForNull((String)dataList.get("SOLE_SOURCE_YN"),"N");
				manufacturer_id				=			CommonBean.checkForNull((String)dataList.get("MANUFACTURER_ID"));
				gen_uom_code				=			CommonBean.checkForNull((String)dataList.get("GEN_UOM_CODE"));
				unit_cost					=			CommonBean.checkForNull((String)dataList.get("UNIT_COST"),"0");

				uom_desc					=			CommonBean.checkForNull((String)dataList.get("UOM_DESC"));

				if(!uom_desc.equals("")){
					uom_desc = uom_desc.replaceAll(" ","%20");
					uom_desc = java.net.URLEncoder.encode(uom_desc,"UTF-8");
					uom_desc = uom_desc.replaceAll("%2520","%20");
				}

				manufacture_desc			=			CommonBean.checkForNull((String)dataList.get("MANUFACTURE_DESC"));
				
				if(!manufacture_desc.equals("")){
					manufacture_desc = manufacture_desc.replaceAll(" ","%20");
					manufacture_desc = java.net.URLEncoder.encode(manufacture_desc,"UTF-8");
					manufacture_desc = manufacture_desc.replaceAll("%2520","%20");
				}
				
				spare_part_id				=			CommonBean.checkForNull((String)dataList.get("SPARE_PART_ID"));
				mfg_item_yn					=			CommonBean.checkForNull((String)dataList.get("MFG_ITEM_YN"));
				medical_item_yn				=			CommonBean.checkForNull((String)dataList.get("MEDICAL_ITEM_YN"));
				abc_class_code				=			CommonBean.checkForNull((String)dataList.get("ABC_CLASS_CODE"));
				trade_id_applicable_yn		=			CommonBean.checkForNull((String)dataList.get("TRADE_ID_APPLICABLE_YN"),"N");
				batch_id_applicable_yn		=			CommonBean.checkForNull((String)dataList.get("BATCH_ID_APPLICABLE_YN"),"N");
		
		
		
				expiryyn					=			CommonBean.checkForNull((String)dataList.get("EXPIRY_YN"),"N");
				item_code					=			CommonBean.checkForNull((String)dataList.get("ITEM_CODE"),"");
				item_name					=			CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"");
				
				if(!item_name.equals("")){
					item_name = item_name.replaceAll(" ","%20");
					item_name = java.net.URLEncoder.encode(item_name,"UTF-8");
					item_name = item_name.replaceAll("%2520","%20");
				}

				item_class					=			CommonBean.checkForNull((String)dataList.get("ITEM_CLASS_DESC"),"");
				if(!item_class.equals("")){
					item_class = item_class.replaceAll(" ","%20");
					item_class = java.net.URLEncoder.encode(item_class,"UTF-8");
					item_class = item_class.replaceAll("%2520","%20");
				}

				alpha_code					=			CommonBean.checkForNull((String)dataList.get("ALPHA_CODE"),"");
				consignment					=			CommonBean.checkForNull((String)dataList.get("CONSIGNMENT_ITEM_YN"),"N");
				curr_supp_code				=			CommonBean.checkForNull((String)dataList.get("CURR_SUPP_CODE"),"");
				preparation_type			=			CommonBean.checkForNull((String)dataList.get("PREPARATION_TYPE"),"");
				preparation_mode			=			CommonBean.checkForNull((String)dataList.get("PREPARATION_MODE"),"");
				//str_uom_code				=			CommonBean.checkForNull((String)dataList.get("DEF_ISSUE_UOM"),"");

				gen_uom_desc				=			CommonBean.checkForNull((String)dataList.get("GEN_UOM_DESC"),"");
				if(!gen_uom_desc.equals("")){
					gen_uom_desc = gen_uom_desc.replaceAll(" ","%20");
					gen_uom_desc = java.net.URLEncoder.encode(gen_uom_desc,"UTF-8");
					gen_uom_desc = gen_uom_desc.replaceAll("%2520","%20");
				}

				req_uom_code				=			CommonBean.checkForNull((String)dataList.get("DEF_REQUEST_UOM"),"");
				no_of_decimals				=			Integer.parseInt(CommonBean.checkForNull((String)dataList.get("NO_OF_DECIMALS"),"0"));
				allow_decimals_yn				=			CommonBean.checkForNull((String)dataList.get("ALLOW_DECIMALS_YN"),"N");
				//Added by Sakti sankar against AMRI-CRF-100024 and AMS-CRF-0028
				if(!store_code.equals("")){
				qty_on_hand = CommonBean.checkForNull((String)dataList.get("QTY_ON_HAND"),"0");
				avl_qty =CommonBean.checkForNull((String)dataList.get("AVAILABLE_QTY"),"0");
				
				//min_str_qty =   CommonBean.checkForNull((String)dataList.get("MIN_STR_QTY"),"0");  
				//max_str_qty =   CommonBean.checkForNull((String)dataList.get("MAX_STR_QTY"),"0");
				//reorder_level = CommonBean.checkForNull((String)dataList.get("REORDER_LEVEL"),"0");
				//ADDED BY Rabbani Inc no :50694 on 22-AUG-2014
				min_str_qty =   CommonBean.checkForNull((String)dataList.get("MIN_STR_QTY"),"");  
				max_str_qty =   CommonBean.checkForNull((String)dataList.get("MAX_STR_QTY"),"");
				reorder_level = CommonBean.checkForNull((String)dataList.get("REORDER_LEVEL"),"");
				
				if(min_str_qty.equals("0"))
				 min_str_qty = "";
				 if(max_str_qty.equals("0"))
				 max_str_qty = "";
				 if(reorder_level.equals("0"))
				 reorder_level = "";
				 
				 
				 
				}//Added ends

				// Added by Sakti against AMS-CRF-0011 to disable item code hyperlink if available qty is zero
				String hyper = "";
				String onClick = "";
				if((!store_code.equals("")) && avl_qty.equals("0")  ) { 
					onClick = "onClick=\"disableClick(event);\"";
					hyper = "";
				}else{
					hyper = "HYPERLINK";
				}
				//Added ends
				//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 beg
				if((trn_type.equals("PRD") || trn_type.equals("PRQ")) && search_no.equals("2")){
					hyper = "HYPERLINK";
					onClick = "";
				}//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 end

				if(maxRec==1){
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mfg_base_qty));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(min_stk_qty));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(max_stk_qty));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(manufacturer_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(gen_uom_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(manufacture_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(trade_id_applicable_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(expiryyn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(item_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(item_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alpha_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curr_supp_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(preparation_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(preparation_mode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_uom_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(mfg_base_qty));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(min_stk_qty));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(max_stk_qty));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(replaceNewLineChar(long_desc)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(manufacturer_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(gen_uom_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(manufacture_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(trade_id_applicable_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(expiryyn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(item_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(item_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alpha_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curr_supp_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(preparation_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(preparation_mode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(gen_uom_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(req_uom_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(allow_decimals_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
				
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(mfg_base_qty));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(min_stk_qty));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(max_stk_qty));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(replaceNewLineChar(long_desc)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(manufacturer_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(gen_uom_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(replaceNewLineChar(manufacture_desc)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(trade_id_applicable_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(expiryyn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(replaceNewLineChar(item_name)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(item_class));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alpha_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curr_supp_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(preparation_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(preparation_mode));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_uom_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(mfg_base_qty));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(min_stk_qty));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(max_stk_qty));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(replaceNewLineChar(long_desc)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(manufacturer_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(gen_uom_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(replaceNewLineChar(manufacture_desc)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(trade_id_applicable_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(expiryyn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(replaceNewLineChar(item_name)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(item_class));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alpha_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curr_supp_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(preparation_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(preparation_mode));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(gen_uom_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(req_uom_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(allow_decimals_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLDecoder.decode(long_desc,"UTF-8")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(! (trn_type.equals("RTV") || trn_type.equals("URG") || trn_type.equals("REQ") || trn_type.equals("RET") || trn_type.equals("MFG") || trn_type.equals("SAL") || trn_type.equals("TFR") || trn_type.equals("PRD") || trn_type.equals("CBL") || trn_type.equals("CHANGE_EXP") || trn_type.equals("CEB") || trn_type.equals("SPB") || trn_type.equals("SUSPEND") || trn_type.equals("SRT") || trn_type.equals("PRQ"))) { 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block39Bytes, _wl_block39);
}else{ 
            _bw.write(_wl_block40Bytes, _wl_block40);
if(trn_type.equals("PRD") || trn_type.equals("PRQ")){ //Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 beg
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(onClick ));
            _bw.write(_wl_block43Bytes, _wl_block43);
if((!store_code.equals("")) && avl_qty.equals("0") && search_no.equals("1")) {
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
} 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(hyper));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(onClick ));
            _bw.write(_wl_block43Bytes, _wl_block43);
if((!store_code.equals("")) && avl_qty.equals("0") && search_no.equals("1")) {
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(hyper));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block53Bytes, _wl_block53);
}else{ //Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 end
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(onClick ));
            _bw.write(_wl_block43Bytes, _wl_block43);
if((!store_code.equals("")) && avl_qty.equals("0") ) {
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(hyper));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(onClick ));
            _bw.write(_wl_block43Bytes, _wl_block43);
if((!store_code.equals("")) && avl_qty.equals("0") ) {
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(machine_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ps_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sole_source_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(unit_cost));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spare_part_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mfg_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_item_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abc_class_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
} 
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(hyper));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
} 
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(java.net.URLDecoder.decode(item_name,"UTF-8")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(img_display));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(img_file_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(spcfn_img_display));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)dataList.get("ITEM_CODE"))));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLDecoder.decode(item_name,"UTF-8")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(item_specfin_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(item_remarks));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(item_name));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
if(((String)dataList.get("EXPIRY_YN")).equals("Y")){
            _bw.write(_wl_block69Bytes, _wl_block69);
}else{
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(java.net.URLDecoder.decode(uom_desc,"UTF-8")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(java.net.URLDecoder.decode(item_class,"UTF-8")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf((String)dataList.get("ALPHA_CODE")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf((String)dataList.get("GEN_UOM_DESC")));
            _bw.write(_wl_block73Bytes, _wl_block73);
if(!store_code.equals("")){
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(qty_on_hand));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(CommonBean.checkForNull(min_str_qty,"&nbsp;")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(CommonBean.checkForNull(reorder_level,"&nbsp;")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(CommonBean.checkForNull(max_str_qty,"&nbsp;")));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);


	
				count++;
			chkCount++;
			}
		
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bean.getStore_desc()));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(start));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(end));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(result.size()));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(displaySize));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( img_path ));
            _bw.write(_wl_block87Bytes, _wl_block87);

			out.flush();
		} else{
		
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(radioval));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(search));
            _bw.write(_wl_block90Bytes, _wl_block90);

		}
	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block91Bytes, _wl_block91);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Expiry.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StockUOM.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemClass.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AlphaCode.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BaseUOM.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.QtyOnHand.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.MinimumLevel.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ROLevel.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.MaximumLevel.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
