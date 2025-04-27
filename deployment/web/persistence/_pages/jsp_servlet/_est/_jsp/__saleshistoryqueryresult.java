package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.SalesHistoryBean;
import java.util.*;
import com.ehis.util.*;
import java.text.NumberFormat;
import java.lang.*;
import java.io.*;
import eCommon.Common.*;
import eST.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __saleshistoryqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SalesHistoryQueryResult.jsp", 1709122169932L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  <!--GHL-CRF-0557.1 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eST/js/SalesHistory.js\"> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body >\n<form name=\"formStockStatusByStoreResult\" id=\"formStockStatusByStoreResult\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t\t\t<tr id=\"heading\">\n\t\t\t\t\t\t\t<td width=\"80%\" class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t<td width=\"20%\" class=\"label\" bgcolor=\"white\">&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t<div  style=\"position:relative;height:460px;overflow:auto\">\n\n\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'tb1\'>\n\t\t\t\t<tr style=\'position:relative\'style=\'top:expression(this.offsetParent.scrollTop-2)\'>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<th width=\'60\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<th width=\'50\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" align=\'left\' class=\'ITEMSELECT\' width=\"60%\"><font size=1><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" : </b> \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\"  class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\"  class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\n\n\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=9  class=\'ITEMSELECT\' width=\"60%\"><font size=1><b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" : </b> \n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=13 align=\'left\' class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =":</b> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\n\t<td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" align=\"left\" ><font size=1>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</font></td>\n\t<td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" align=\"left\" style=\'WORD-BREAK:BREAK-ALL;\'><font size=1>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" align=\"right\" ><font size=1>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</font></td>\n\t\n\t<td class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" align=\"center\" ><font size=1>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</font></td>\n\t <!-- \t\t\t\t\t\n\t\t\t\t\t\t* @Name - Priya\n\t\t\t\t\t\t* @Date - 19/02/2010\n\t\t\t\t\t\t* @Inc# - IN019466\n\t\t\t\t\t\t* @Desc - To right align Sale Quantity,CostValue,SaleValue,Sub Total, Grand Total.\t\t\t\t\n\t\t\t\t\t-->\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"  style=\"TEXT-ALIGN:right\"><font \n\tsize=1>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</font>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</font>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t<!-- <td class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"  style=\"TEXT-ALIGN:right\"><font size=1>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</font>&nbsp;</td> -->\n\t<td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</font>&nbsp;</td>\n\t\n\t\n\t<td class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</font>&nbsp;</td> \n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\n\t<td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" ><font size=1>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</font></td>\n\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" style=\'WORD-BREAK:BREAK-ALL;\'><font size=1>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</font></td>\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\n\t<td class=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"><font size=1>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font></td>\n\n\t<td class=\'NODISPLAY\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\t\n\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td colspan=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="   class=\'ITEMSELECT\'><font size=1 width=\"60%\"><b>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" : </b> \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n\t\t\t\n\t\t\t<tr> </tr>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td  colspan=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="  align=\'left\' class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" : </b></td> \n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t<td colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'><font size=1><B>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</B></font>&nbsp;</td>\n\t\t\t\t<td colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'><font size=1><B>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t<td colspan=2 align=\'left\' class=\'ITEMSELECT\'>&nbsp;&nbsp;</td>\n\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\n\t\t\n\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n</form>\t\t\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n</body>\n\n<!-- <script>activeLink();</script> -->\n</html>\n\n\n\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		 NumberFormat nf = NumberFormat.getInstance(new Locale(locale));
		 

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


	String bean_id				=		"SalesHistoryBean";
	String bean_name			=		"eST.SalesHistoryBean";
	SalesHistoryBean bean		=		(SalesHistoryBean) getBeanObject(bean_id, bean_name,request  );  
	bean.clear();
	String store_code			=		request.getParameter( "p_fr_st_code")==null?"":request.getParameter( "p_fr_st_code") ;
	String from_date			=		request.getParameter( "from_date")==null?"":request.getParameter( "from_date") ;
	from_date					=		DateUtils.convertDate(from_date,"DMY",locale,"en");
	String to_date				=		request.getParameter( "to_date")==null?"":request.getParameter( "to_date") ;
	to_date						=		DateUtils.convertDate(to_date,"DMY",locale,"en");
	String item_code			=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String patient_id			=		request.getParameter( "patient_id" )==null?"":request.getParameter( "patient_id" ) ;
	String  encounter_id		=		request.getParameter( "encounter_id" )==null?"":request.getParameter( "encounter_id" ) ;

	String sal_trn_type			=		request.getParameter( "sal_trn_type" )==null?"":request.getParameter( "sal_trn_type" ) ;

	String classvalue			=		"";
	String facility_id			=		(String) session.getValue( "facility_id" ) ;
	double subtotal				=		0.0;
	double pre_subtotal			=		0.0;
	boolean flag				=		true;
	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	String grand_total			=		request.getParameter( "grand_total" )==null?"0":request.getParameter( "grand_total" ) ;
	String store_compare		=		request.getParameter( "store_compare" )==null?"0":request.getParameter( "store_compare" ) ;
	double grand_tot			=		Double.parseDouble(grand_total);
//	boolean no_record			=		false;
//	boolean count				=		false;
	double cost_value_sub_total = 0.0;
	double pre_cost_value_sub_total = 0.0;
	int headercpls=7;
	/**
			* @Name - krishna
			* @Date - 24/12/2009
			* @Inc# - CRF537.1
			* @Desc - No of decimal positions No of decimal positions when u r find fmt
			* @Modified by : Priya (For the Incident 18095)
	 */
	int no_of_decimals=bean.getNoOfDecimals();		
	String view_cost_details_yn = (String)bean.getAccessCostDetails();

	/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
			  nf.setMaximumFractionDigits(noOfDecimalsForCost);
			  nf.setMinimumFractionDigits(noOfDecimalsForCost);

			  /* @Name - Priya
			 * @Date - 07/07/2010
			 * @Inc# - 21346 (AK-CRF-0018)
			 * @Desc - To get the parameter values from sales history query criteria 
			*/
			  String sal_doc_type			=		request.getParameter( "sal_doc_type" )==null?"":request.getParameter( "sal_doc_type" ) ;
			  String doc_no			=		request.getParameter( "doc_no" )==null?"":request.getParameter( "doc_no" ) ;

			  patient_id = patient_id.toUpperCase();
			  System.out.println("patient_id" + patient_id);

try{

			if((bean.getCustomerID()).equals("MC")){
				headercpls=9;
			}
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			store_code			=		CommonBean.checkForNull(store_code);
			item_code			=		CommonBean.checkForNull(item_code);
			from_date			=		CommonBean.checkForNull(from_date);
			to_date				=		CommonBean.checkForNull(to_date);
			patient_id			=		CommonBean.checkForNull(patient_id);
			encounter_id		=		CommonBean.checkForNull(encounter_id);
			sal_trn_type		=		CommonBean.checkForNull(sal_trn_type,"%");
			sal_doc_type		=		CommonBean.checkForNull(sal_doc_type);  
			doc_no				=		CommonBean.checkForNull(doc_no);

			String store_code2	=		CommonBean.checkForNull(store_code);
			String item_code2	=		CommonBean.checkForNull(item_code);
			String from_date2	=		CommonBean.checkForNull(from_date);
			String to_date2		=		CommonBean.checkForNull(to_date);
			String patient_id2	=		CommonBean.checkForNull(patient_id);
			String encounter_id2=		CommonBean.checkForNull(encounter_id);
			String sal_trn_type2=		CommonBean.checkForNull(sal_trn_type,"%");  
			String sal_doc_type2 =		CommonBean.checkForNull(sal_doc_type);  
			String doc_no2		 =		CommonBean.checkForNull(doc_no);  

			String strGrandTotFlag ="";
			
				HashMap sqlMap			=		new HashMap();
				HashMap funcMap			=		new HashMap();
				ArrayList displayFields =		new ArrayList();
				ArrayList chkFields		=		new ArrayList();
				String curr_item_store	=		"";
				String prev_item_store	=		"";

				
				String sal_trn_type_query = "";

				 if(sal_trn_type.equals("I")){
					  sal_trn_type_query = "and b.take_home_yn ='N'";
				 }else if(sal_trn_type.equals("H")){
					  sal_trn_type_query = "and b.take_home_yn ='Y'";
					  sal_trn_type = "I";
				 }

				//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_SALES_HISTORY"));
				//sqlMap.put("sqlData","select a.doc_type_code, c.short_desc doc_type_desc,a.doc_no, to_char(a.DOC_DATE,'dd/mm/yyyy') doc_date,a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name, b.item_qty sale_qty,round(nvl(b.GROSS_CHARGE_AMT,0),2) GROSS_CHARGE_AMT, ROUND(NVL(b.item_sal_value,0),2) item_sal_value ,ROUND(NVL(b.item_cost_value,0),2)  item_cost_value , a.sal_trn_type,b.take_home_yn  from  st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f where a.facility_id=b.facility_id and a.doc_type_code=b.doc_type_code and a.doc_no=b.doc_no and a.doc_type_code=c.doc_type_code and  a.store_code=d.store_code and b.item_code=e.item_code and a.patient_id=f.patient_id and a.facility_id = (?) and a.store_code LIKE UPPER(?) and b.item_code LIKE UPPER(?) and a.sal_trn_type like ? "+sal_trn_type_query+"and a.patient_id LIKE UPPER(?) and (a.doc_date BETWEEN to_date(TO_CHAR(nvl(?,'01/01/1901')),'dd/mm/yyyy') and to_date(TO_CHAR(nvl(?,'31/12/3012')),'dd/mm/yyyy')) and to_char(NVL(encounter_id,'0')) LIKE ? and a.FINALIZED_YN = 'Y'");	
				//sqlMap.put("sqlData","SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = (?) AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? "+sal_trn_type_query+" AND a.patient_id LIKE UPPER (?) AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND TO_CHAR (NVL (a.encounter_id, '0')) LIKE ? AND a.finalized_yn = 'Y' AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')");
				//String sql = "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND  g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num  AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? AND a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy') and a.sal_trn_type LIKE ? ";
				// Commented by ganga Wednesday, November 21, 2012 for IN034623
				
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND  g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num  AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";

				//Modified by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND  g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num  AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";

				//Modified by Sakti against MMS-SCF-0381 inc#50206 Unit_cost logic changed. 
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND  g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num  AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT curr_unit_cost FROM st_item_unit_cost_history aa  WHERE aa.changed_date = (SELECT MAX (changed_date)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN') AND item_code = b.item_code AND TRUNC (changed_date) <= a.doc_date) AND aa.item_code = b.item_code AND trn_type IN ('OBS', 'GRN') AND ROWNUM = 1)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";
				//Modified by Sakti against MMS-SCF-0381 inc#50206 Unit_cost,sale_value(MMS-SCF-0380,MMS-SCF-0344) logic changed. 
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND ((  (  b.item_qty * (st_display_unit_cost(b.item_code,trunc(a.doc_date)))) * st_get_uom_conv_fac_sing_str (b.item_code, a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";
				//Modified by suresh.r on 03-11-2014 against Inc 52256 (unitcost fun passed modified_date)
				//String sql = "SELECT DISTINCT a.doc_type_code, (select short_desc from sy_doc_type_master_lang_vw where doc_type_code = a.doc_type_code and language_id= ?) doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,(select short_desc from mm_store_lang_vw where store_code=a.store_code and language_id= ?) store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,(CASE WHEN a.sal_trn_type = 'X'  THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END)  patient_name1, b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT'  THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND ((  (  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code, a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,a.added_by_id,TO_CHAR (a.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM st_sal_hdr a, st_sal_dtl b, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.finalized_yn = 'Y' AND  a.doc_date BETWEEN to_date(?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')  ";
				//Query moved to StRepoistory by suresh.r on 04-05-2015 against Inc 53228
				
				/*GHL-CRF-0557.1*/
				Connection	con1=null;
				boolean site=false;
				try
				{
					con1	= ConnectionManager.getConnection(request);
					 site = eCommon.Common.CommonBean.isSiteSpecific(con1, "ST","ST_SAL_PRICE_CHANGE");
				}
				finally
				{
					con1.close();
				}
				
				String sql="";
				if(site)
					sql =eST.Common.StRepository.getStKeyValue("SQL_ST_SALES_HISTORY_QUERY1");
				else
					sql =eST.Common.StRepository.getStKeyValue("SQL_ST_SALES_HISTORY_QUERY");
				/*GHL-CRF-0557.1*/

				displayFields.add("store_desc"); 	
				displayFields.add("item_code");	
				displayFields.add("item_desc");	
				displayFields.add("doc_type_desc");
				displayFields.add("doc_no");
				displayFields.add("doc_date");
				displayFields.add("sale_qty");
				displayFields.add("item_cost_value");
				//displayFields.add("item_sal_value");
				//displayFields.add("item_cost_value");
				displayFields.add("gross_charge_amt");
				displayFields.add("patient_id");
				displayFields.add("patient_name");
				displayFields.add("store_code");
				displayFields.add("sal_trn_type");
				displayFields.add("take_home_yn");
				displayFields.add("sale_req_qty");
				displayFields.add("pen_sal_req_qty");
				displayFields.add("added_by_id");
				displayFields.add("ADDED_DATE");
				displayFields.add("patient_name1");
				displayFields.add("item_cost_value_new");//Added by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(facility_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
			
				
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			if(!(sal_trn_type.equals("%"))	){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(store_code.equals(""))	){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}
			if(!(item_code.equals(""))	){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(patient_id.equals(""))	){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))	){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_trn_type_query.equals(""))	){
			sql = sql + sal_trn_type_query ;
			}			

			sql = sql + " ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')" ;


				sqlMap.put("sqlData",sql);
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
			int cnt=2;
			String no_records="";
						int grandpreviouscnt=0;
						int grandnextcnt=0;
						int int_grandpreviouscnt=0;
						int int_grandnextcnt=0;
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
			{
			//		count=true;
					HashMap hshSalesType = new HashMap();
					hshSalesType.put("I",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inpatients.label","common_labels"));
					hshSalesType.put("O",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatients.label","common_labels"));
					hshSalesType.put("R",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Referrals.label","st_labels"));
					hshSalesType.put("H",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels"));
					hshSalesType.put("X",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels"));
					hshSalesType.put("E",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
					hshSalesType.put("D",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels"));
					hshSalesType.put("C",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Consumption.label","st_labels"));

					
					
					if(((String)result.get(1)).indexOf("(")>0){
						strGrandTotFlag = "N";
					}else{
						strGrandTotFlag = "Y";
					}
					
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block11Bytes, _wl_block11);

						no_records				=		(result.get(1).toString());
					
						int_grandpreviouscnt	=		no_records.indexOf('P');
						grandpreviouscnt		=		int_grandpreviouscnt;
						int_grandnextcnt		=		no_records.indexOf('N');
						grandnextcnt			=		int_grandnextcnt;
						
						try{
							if(int_grandpreviouscnt > 0)
							{
							if((no_records.substring(int_grandpreviouscnt,(int_grandpreviouscnt+8))).equals("Previous"))
							grandpreviouscnt	=		int_grandpreviouscnt;
							else 
							grandpreviouscnt	=		int_grandpreviouscnt;
							}
						}catch(Exception e1) { }
							
							try{
							if(int_grandnextcnt > 0)
							{
							if((no_records.substring(int_grandnextcnt,(int_grandnextcnt+4))).equals("Next")) 
								grandnextcnt	=		int_grandnextcnt;
							}
							else
								grandnextcnt	=		int_grandnextcnt;
							}
							catch(Exception e2) { }
						
            _bw.write(_wl_block12Bytes, _wl_block12);

						
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if((bean.getCustomerID()).equals("MC")){
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if((bean.getCustomerID()).equals("MC")){
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
if(view_cost_details_yn.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

							
							ArrayList records=new ArrayList();
							
							for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++)
							{  // for for records
								cnt ++;
								classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
								//String link_columns = "1";
								records=(ArrayList) result.get(recCount);
								

				
            _bw.write(_wl_block23Bytes, _wl_block23);

							curr_item_store=(String)records.get(0);
							if(!curr_item_store.equals(prev_item_store))
							{
								flag=true;
								if(cost_value_sub_total>=0 && subtotal >= 0 && !curr_item_store.equals(prev_item_store) && cnt > 3)
								{	// if loop sub total
								if(view_cost_details_yn.equals("Y")){
					
								
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(headercpls));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block28Bytes, _wl_block28);
 
								}
									subtotal=0.0f;
									cost_value_sub_total=0.0f;
									 // if loop sub total
								
            _bw.write(_wl_block29Bytes, _wl_block29);

								
								}	// if loop 
								else if(cost_value_sub_total>=0 && subtotal >= 0 && flag==false && store_compare.equals(store_code)) 
									{
									pre_subtotal +=subtotal;
									pre_cost_value_sub_total+=cost_value_sub_total;
									if(view_cost_details_yn.equals("Y")){
									
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+pre_cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+pre_subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block33Bytes, _wl_block33);

									}
								} 
								
            _bw.write(_wl_block34Bytes, _wl_block34);

										store_code=CommonBean.checkForNull((String)records.get(0),"");
								//}
								
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(0),"")));
            _bw.write(_wl_block37Bytes, _wl_block37);

							}

				String str_sales_type = CommonBean.checkForNull((String)records.get(12));
				if(str_sales_type.equals("I") && (CommonBean.checkForNull((String)records.get(13)).equals("Y"))){
					 str_sales_type = "H";
				}
								
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(2),"&nbsp;")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(3),"0")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(hshSalesType.get(str_sales_type)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(4),"0")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(DateUtils.convertDate(CommonBean.checkForNull((String)records.get(5),"0"),"DMY","en",locale)));
            _bw.write(_wl_block46Bytes, _wl_block46);
if((bean.getCustomerID()).equals("MC")){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.setNumberFormat(bean.checkForNull((String)records.get(14),"0"),no_of_decimals)));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.setNumberFormat(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)));
            _bw.write(_wl_block50Bytes, _wl_block50);
if((bean.getCustomerID()).equals("MC")){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.setNumberFormat(bean.checkForNull((String)records.get(15),"0"),no_of_decimals)));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block51Bytes, _wl_block51);

		String cost_value_1=CommonBean.checkForNull((String)records.get(8),"0");
		subtotal = subtotal + Double.parseDouble(cost_value_1);

		//cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(7),"0"));
		cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(19),"0"));
		
            _bw.write(_wl_block4Bytes, _wl_block4);
if(view_cost_details_yn.equals("Y")){
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(7),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(19),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(8),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(9),"0")));
            _bw.write(_wl_block59Bytes, _wl_block59);
 if(str_sales_type.equals("X")) {
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(18),"0")));
            _bw.write(_wl_block61Bytes, _wl_block61);

		}
	else
	{
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(10),"0")));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)records.get(16)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(17),"DMYHMS","en",locale)));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(records.get(11)));
            _bw.write(_wl_block65Bytes, _wl_block65);

			
			prev_item_store=curr_item_store;
			}	// for loop for records
grand_tot = grand_tot + subtotal;
		}		// main if loop
		else{
			
		//	 no_record=true;
		
            _bw.write(_wl_block66Bytes, _wl_block66);

		
		}
				if(view_cost_details_yn.equals("Y")){

						if(cnt == result.size() && subtotal >= 0 && cost_value_sub_total>=0)
						
						{
							
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(headercpls));
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block71Bytes, _wl_block71);

							}
				}
//		if(no_record==false && (count==false) )
		if(view_cost_details_yn.equals("Y")){
		if((grandnextcnt == -1  && grandpreviouscnt > 0 && (result.size() == cnt )) || (strGrandTotFlag.equals("Y")) )
		//if((result.size() == cnt ) )
		{
		
            _bw.write(_wl_block72Bytes, _wl_block72);




		ArrayList  result2=new ArrayList(); 
				
			//result2=bean.queryResultDetails(facility_id,store_code2,item_code2,sal_trn_type2,patient_id2, from_date2 , to_date2,encounter_id2);
			  /* @Name - Priya
			 * @Date - 07/07/2010
			 * @Inc# - 21346 (AK-CRF-0018)
			 * @Desc - Two parameters have been added to the function 'queryResultDetails' in SalesHistoryBean 
			*/
			result2=bean.queryResultDetails(facility_id,store_code2,item_code2,sal_trn_type2,patient_id2, from_date2 , to_date2,encounter_id2,sal_doc_type2,doc_no2);
		//CommonBean.clear( );
		
	
		if((result2.size()>0) )
			{			// record if loop

				
						HashMap records2=new HashMap();
						for(int recCount=0; recCount<result2.size(); recCount++)
						{			// record for loop

							records2=(HashMap)result2.get(recCount);
				
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(headercpls));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

			
						String grandt=CommonBean.checkForNull((String)records2.get("grand_tot"),"0");
						String cost_grand_tot = CommonBean.checkForNull((String)records2.get("cost_grand_tot"),"0");
						
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.setNumberFormat(cost_grand_tot,noOfDecimalsForCost)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean.setNumberFormat(grandt,noOfDecimalsForCost)));
            _bw.write(_wl_block78Bytes, _wl_block78);

						}	// record for loop
			}		// result for loop
		
		}		// if loop for grand total ends
		}
		out.println(" </table>");
		out.println("	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/SalesHistoryQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}

            _bw.write(_wl_block79Bytes, _wl_block79);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block80Bytes, _wl_block80);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SalesType.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocNo.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Req.SaleQuantity.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SaleQuantity.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PendingSaleQuantity.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.CostValue.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SaleValue.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Createdby.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.createddate.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GrandTotal.label", java.lang.String .class,"key"));
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
}
