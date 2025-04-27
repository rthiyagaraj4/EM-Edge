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
import webbeans.eCommon.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __drugstockstatusbystoreresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/DrugStockStatusByStoreResult.jsp", 1709122036777L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eST/js/DrugStockStatusByStore.js\"> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n<form name=\"formStockStatusByStoreResult\" id=\"formStockStatusByStoreResult\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table  border = 0 cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t  \n\t\t\t<tr>\n\t\t\t\t<td width=\"80%\" class=\"white\" >&nbsp;</td>\n\t\t\t\t<td width=\"20%\" class=\"white\" >&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<!--<table   cellpadding=0 cellspacing=1 width=\"100%\" align=\"center\">\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<th nowrap width=\"64%\" colspan=2>&nbsp;</th>\n\t\t\t\t<th nowrap colspan=3 width = \"14%\">Inventory On Hand</th>\n\t\t\t\t<th nowrap colspan=2>&nbsp;</th>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n                  <th nowrap width=\"64%\" colspan=2>&nbsp;</th>\n\t\t\t\t<th  colspan=2 width = \"14%\">Inventory On Hand</th>\n\t\t\t\t<th nowrap colspan=2>&nbsp;</th>\n                 ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</table>-->\n\t\t\t    <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'tb1\'>\n\t\t\t\t<th nowrap width=\"15%\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"item_code\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;&nbsp;<img name=\"item_code\" style=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" src=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" border=none alt=\"Sort Order\"></th>\n\t\t\t\t<!--Added by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013 -->\n\t\t\t\t<th nowrap width=\"18%\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"atc_class_lev4_desc\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;&nbsp;<img name=\"atc_class_lev4_desc\" style=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" border=none alt=\"Sort Order\"></th>\n\t\t\t\t<th nowrap style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"item_desc\" width=\"15%\"onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;&nbsp;<img name=\"item_desc_img\" style=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" border=none alt=\"Sort Order\"></th>\n\t\t\t\t<th nowrap style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"generic_name\" width=\"15%\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;&nbsp;<img name=\"generic_name_img\" style=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" border=none alt=\"Sort Order\"></th>\n\t\t\t\t<!--Added by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013 -->\n\t\t\t\t<!--<th nowrap style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"dosage_form\" width=\"15%\"onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;&nbsp;<img name=\"dosage_form\" style=  src=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" border=none alt=\"Sort Order\"></th>  -->\n\t\t\t\t<th colspan=2 width = \"20%\" align=\"center\" > Inventory On Hand\n\t\t\t\t<table border=\"\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"> \n\t\t\t\t<th nowrap width=\"30%\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"qty_on_hand\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">QOH&nbsp;<img name=\"qoh_img\" style=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" border=none alt=\"Sort Order\"></th>\n\t\t\t\t\n\t\t\t\t<th nowrap width=\"30%\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"issue_uom_avl\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">Avl.Qty<img name=\"avail_qty_img\" style=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" border=none alt=\"Sort Order\"></th>\n\t\t\t\t</table></th>\n\t\t\t\t<th nowrap width=\"12%\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"issue_uom\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">UOM<img name=\"uom_img\" style=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" border=none alt=\"Sort Order\"></th>\n\t\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<th nowrap width=\"12%\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"unit_cost\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<img name=\"unit_cost_img\" style=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" border=none alt=\"Sort Order\"></th>\n\t\t\t\t<th nowrap width=\"12%\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"item_value\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">Cost Value &nbsp;<img name=\"item_value_img\" style=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" border=none alt=\"Sort Order\"></th>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\n\t\t\t\t<th nowrap width=\"12%\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"stock_item_yn\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<img name=\"stock_item_img\" style=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" border=none alt=\"Sort Order\"></th>\n\t\t\t\t<th nowrap width=\"12%\" style=\"WORD-BREAK:BREAK-ALL;cursor:pointer\" name=\"reorder_level\" onclick =\"sortOrder(this,\'../../eST/images/Ascending.gif\',\'../../eST/images/Descending.gif\');\">RO Level<img name=\"Ro_level_img\" style=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" border=none alt=\"Sort Order\"></th>\n\t\t\t</tr> \n\t\t\t\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t    ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<tr>\n\t\t\t\t<td colspan=12 align=\'left\' class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =":</b> \n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;</td>\n\t\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\n\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<td class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" onClick=\"callBatchSearchScreen(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' );\" onmouseover=\"changeCursor(this);\" ><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</font></td>\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onClick=\"callATCdesc(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\');\" onmouseover=\"changeCursor(this);\" ><font size = 1 >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</font><font size = 1 class=\'HYPERLINK\'><b>...More</b></font></td>\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" align=\"left\" style=\"font-size:7pt;WORD-BREAK:BREAK-ALL;\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t<td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t \n\t<td class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" style=\"TEXT-ALIGN:right\"><font size=1>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</font></td>\n \t\n\t<td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" style=\"TEXT-ALIGN:right\"><font size=1 >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</font></td>\n\t<td class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" align=\"left\"><font size=1>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</font></td>\n\t\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" style=\"TEXT-ALIGN:right\" title=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"><font size=1>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" style=\"TEXT-ALIGN:right\"><font size=1>\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\n\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</font></td>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" align=\"center\"><font size=1>\n\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\n\t\t\t\t</font></td>\n\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</font></td>\n\t\t<td class=\'NODISPLAY\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\t\n\t\t  \n      \n\t\t</tr>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String bean_id					=		"DrugStockStatusByStoreBean";
	String bean_name				=		"eST.DrugStockStatusByStoreBean";
	DrugStockStatusByStoreBean bean		=		(DrugStockStatusByStoreBean) getBeanObject(bean_id,  bean_name, request );  
	bean.setLanguageId(locale);
	bean.clear();
	String item_code_img    = "display:none";
	String atc_desc_img     = "display:none";
	String item_desc_img    = "display:none";
	String generic_name_img = "display:none";
	String qoh_img          = "display:none";
	//Added by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013
	String avail_qty_img    = "display:none";
	String uom_img          = "display:none";
	String unit_cost_img    = "display:none";
	String item_value_img   = "display:none";
	String stock_item_img   = "display:none";
	String Ro_level_img     = "display:none";
	//ends
	//String base_uom_qoh_img ="display:none";
	//String item_alpha_code_img = "display:none";
	//String dosage_form_img = "display:none";
	//String qty_on_hand_img = "display:none";
	
			
	String s1 ="../../eST/images/Ascending.gif";
	String s2 ="../../eST/images/Descending.gif";
	String sort_order = request.getParameter("sort_order");
	String item_code				=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String store_code_from			=		request.getParameter( "store_code_from")==null?"":request.getParameter( "store_code_from") ;
	String store_code_to			=		request.getParameter( "store_code_to")==null?"":request.getParameter( "store_code_to") ;
	String item_desc				=		request.getParameter( "item_desc" )==null?"":request.getParameter( "item_desc" ) ;
	String stock_level				=		request.getParameter( "stock_level")==null?"":request.getParameter( "stock_level" ) ;
	String fm_item_class			=		request.getParameter( "fm_item_class")==null?"":request.getParameter( "fm_item_class" ) ;
	String to_item_class			=		request.getParameter( "to_item_class")==null?"":request.getParameter( "to_item_class" ) ;
	String fm_anal1					=		request.getParameter( "fm_anal1")==null?"":request.getParameter( "fm_anal1" ) ;
	String to_anal1					=		request.getParameter( "to_anal1")==null?"":request.getParameter( "to_anal1" ) ;
	String fm_anal2					=		request.getParameter( "fm_anal2")==null?"":request.getParameter( "fm_anal2" ) ;
	String to_anal2					=		request.getParameter( "to_anal2")==null?"":request.getParameter( "to_anal2" ) ;
	String fm_anal3					=		request.getParameter( "fm_anal3")==null?"":request.getParameter( "fm_anal3" ) ;
	String to_anal3					=		request.getParameter( "to_anal3")==null?"":request.getParameter( "to_anal3" ) ;
	String stock_item				=		request.getParameter( "stock_item" ).trim( )==null?"":request.getParameter( "stock_item" ) ;
	
//String item_alpha_code			=		request.getParameter( "item_alpha_code" )==null?"":request.getParameter( "item_alpha_code" ) ;
	//String dosage_form				=		request.getParameter( "dosage_form" )==null?"":request.getParameter( "dosage_form" ) ;
	String generic_name				=		request.getParameter( "generic_name" )==null?"":request.getParameter( "generic_name" ) ;
	
	String classvalue				=		"";
	boolean searched				=		(request.getParameter("searched") == null) ?false:true;
	DecimalFormat dfTest1 = new DecimalFormat("###,###.00");
	
	int no_of_decimals=bean.getNoOfDecimals(); 
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	int count = 0;

	try{

		CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
		store_code_from				=		CommonBean.checkForNull(store_code_from);
		store_code_to				=		CommonBean.checkForNull(store_code_to);
		item_code					=		CommonBean.checkForNull(item_code);
		item_desc					=		CommonBean.checkForNull(item_desc)+"%";
		//stock_item					=		CommonBean.checkForNull(stock_item,"")+"%";
		stock_item					=		CommonBean.checkForNull(stock_item,"%");
		
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		String curr_item_store		=		"";
		String prev_item_store		=		"";
				
		//Commented by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013
		//String sql="SELECT DISTINCT x.store_code, store_desc, itm_code, item_desc, stock_item_yn,qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom,unit_cost, item_value, avail_qty, base_uom_qoh, issue_uom_avl, reorder_level,item_alpha_code,generic_name,dosage_form FROM (SELECT   store_code, store_desc,  itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost, item_value, (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) avail_qty, base_uom_qoh,ROUND (NVL(  (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) / NVL ((st_get_uom_conv_fac_sing_str (itm_code, store_code ) ), 1 ),0 ), 4 ) issue_uom_avl, reorder_level, item_alpha_code,generic_name,dosage_form FROM (SELECT DISTINCT stb.batch_id, a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn,NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = c.gen_uom_code AND language_id = ?) uom_desc, a.def_issue_uom def_issue_uom, TRIM (st_display_cost_decimals (a.item_code, a.store_code ) ) unit_cost, item_value, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = a.def_issue_uom AND language_id = ?) issue_uom, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL ((st_get_uom_conv_fac_sing_str (a.item_code, a.store_code ) ), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level, c.alpha_code item_alpha_code,(SELECT generic_name FROM ph_generic_name_lang_vw phg, ph_drug_lang_vw phd WHERE phg.generic_id = phd.generic_id AND phd.item_code = a.item_code AND phg.language_id = phd.language_id AND phd.language_id = ? AND phd.drug_code = k.item_code ) generic_name, (SELECT form_desc FROM ph_form_lang_vw phf, ph_drug_lang_vw phd WHERE phf.form_code = phd.form_code AND phd.item_code = a.item_code AND phf.language_id = phd.language_id AND phf.language_id = ? AND phd.drug_code = k.item_code ) dosage_form FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, st_store e, st_item_batch stb, st_item k WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND a.store_code BETWEEN ? AND ? AND a.item_code = NVL (?, a.item_code) AND UPPER (c.short_desc) LIKE UPPER (?) AND (   (    NVL (a.qty_on_hand, 0) >= 0 AND 'A' = ? ) OR (    NVL (a.qty_on_hand, 0) > 0 AND 'S' = ? ) OR (    NVL (a.qty_on_hand, 0) = 0 AND 'Z' = ? ) OR (    NVL (a.qty_on_hand, 0) < NVL (a.reorder_level, 0)AND 'B' = ? ) ) AND (a.stock_item_yn LIKE (?)) AND b.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = ? AND c.item_class_code BETWEEN NVL (?,'!') AND NVL (?,'~') AND NVL (c.item_anal1_code, 'X') BETWEEN NVL(?,NVL(c.item_anal1_code,'X')) AND NVL(?,NVL(c.item_anal1_code,'X')) AND NVL (c.item_anal2_code, 'X') BETWEEN NVL (?,NVL (c.item_anal2_code,'X')) AND NVL (?,NVL (c.item_anal2_code,'X')) AND NVL (c.item_anal3_code, 'X') BETWEEN NVL(?,NVL (c.item_anal3_code,'X')) AND NVL(?,NVL (c.item_anal3_code,'X')) AND facility_id = ? AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND k.item_code = a.item_code AND (   expiry_yn = 'N' OR (    expiry_yn = 'Y' AND (   (    use_after_expiry_yn = 'Y' AND ('Y' = 'Y') ) OR decode(a.qty_on_hand, 0, sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('','dd/mm/yyyy'), SYSDATE )) )) )) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, issue_uom, reorder_level, item_alpha_code, generic_name,dosage_form, unit_cost, base_uom_qoh) x, st_acc_entity_param i, st_user_access_for_store j WHERE j.user_id LIKE (CASE WHEN i.restrict_view_stk_status = 'ALL' THEN '%' WHEN i.restrict_view_stk_status = 'UAS' THEN ? END ) AND x.store_code = j.store_code";

			
	
	    //ADDED by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 23-July-2013
		String sql=  eST.Common.StRepository.getStKeyValue("SQL_ST_DRUG_STOCK_STATUS_BY_STORE_QUERY_RESULT");
		
	
	    chkFields.add(locale);
		chkFields.add(locale);
		chkFields.add(locale);
		//chkFields.add(locale);
		chkFields.add(locale); //atc_desc chk fileld
		chkFields.add(locale); //generic_id chk fileld
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
       	chkFields.add(item_code);
		
          if (!(item_desc.equals("%"))) {
			sql = sql + "  AND UPPER (c.short_desc) LIKE UPPER (?)" ;
			chkFields.add(item_desc); 
		 }
		 
		 if(stock_level.equals("A")){
		 sql = sql + " and NVL (a.qty_on_hand, 0) >=0 "; 
		 }else if(stock_level.equals("S")){
  		 sql = sql + " and NVL (a.qty_on_hand, 0) > 0 ";		
		}else if(stock_level.equals("Z")){
  		 sql = sql + " and NVL (a.qty_on_hand, 0) = 0 ";		
		}else if(stock_level.equals("B")){
  		 sql = sql + " and NVL (a.qty_on_hand, 0) < NVL (a.reorder_level,0) ";		
		}
		if (!stock_item.equals("%")) {
			sql = sql + "  AND a.stock_item_yn =  ? " ;
			chkFields.add(stock_item);
		}
		sql = sql + " AND b.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = ?";
		chkFields.add( locale);
		
		if (!(fm_item_class.equals("")) ||  !(to_item_class.equals(""))) {
		
		sql = sql + " AND  c.item_class_code BETWEEN NVL (?,'!') AND NVL (?,'~')"; 
		
		    chkFields.add(fm_item_class);
			chkFields.add(to_item_class);
		}
		
		if (!(fm_anal1.equals("")) ||  !(to_anal1.equals(""))) {

			sql = sql + " AND NVL (c.item_anal1_code, 'X') BETWEEN NVL(?,NVL(c.item_anal1_code,'X')) AND NVL(?,NVL(c.item_anal1_code,'X')) ";  
			
			chkFields.add(fm_anal1);
			chkFields.add(to_anal1);
		}
		
		
		 if (!(fm_anal2.equals("")) ||  !(to_anal2.equals(""))) {

			sql = sql + " AND NVL (c.item_anal2_code, 'X') BETWEEN NVL (?,NVL (c.item_anal2_code,'X')) AND NVL (?,NVL (c.item_anal2_code,'X')) ";

			chkFields.add(fm_anal2);
			chkFields.add(to_anal2);
		}
		if (!(fm_anal3.equals("")) ||  !(to_anal3.equals(""))) {
			sql = sql +  " AND NVL (c.item_anal3_code, 'X') BETWEEN NVL(?,NVL (c.item_anal3_code,'X')) AND NVL(?,NVL (c.item_anal3_code,'X'))" ;
			
			chkFields.add(fm_anal3);
			chkFields.add(to_anal3);
		}
		    String trn_across_facility_yn =		bean.checkForNull((String)bean.fetchRecord("select  trn_across_facility_yn  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("TRN_ACROSS_FACILITY_YN"),"N");
			if(trn_across_facility_yn.equals("N")){
            sql = sql + "  AND FACILITY_ID  = ? ";
		    chkFields.add(bean.getLoginFacilityId());
            }
		sql = sql + "  AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND k.item_code = a.item_code AND (expiry_yn = 'N' OR (expiry_yn = 'Y' AND ((('Y' = 'Y')) OR decode(a.qty_on_hand, 0, sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('','dd/mm/yyyy'), SYSDATE )))) )) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, issue_uom, reorder_level, generic_name,unit_cost, base_uom_qoh, generic_id, atc_class_lev4_desc, medical_item_yn,drug_item_yn,base_unit_cost) x, st_acc_entity_param i, st_user_access_for_store j WHERE j.user_id LIKE (CASE WHEN i.restrict_view_stk_status = 'ALL' THEN '%' WHEN i.restrict_view_stk_status = 'UAS' THEN ? END ) AND x.store_code = j.store_code";
		
		chkFields.add(bean.getLoginById());
		
		
		 if(sort_order.equals("")){
			// sort_order = " ORDER BY store_desc, item_desc";
			//Added by Rabbani #Inc no:42039 on 30-July-2013
			 //sort_order = " ORDER BY store_desc, medical_item_yn";
			 sort_order = " ORDER BY  store_desc,DRUG_ITEM_YN DESC, medical_item_yn DESC,UPPER(generic_name)";
		     generic_name_img ="display:''";
		 }else if(sort_order.contains("item_code")){
			 if(sort_order.contains("Asc")){
		     	sort_order = " ORDER BY store_desc,itm_code";
				item_code_img ="display:''";
			    s2=s1;
			}
			 if(sort_order.contains("Desc")){
		           sort_order = " ORDER BY store_desc,itm_code DESC";
	               item_code_img ="display:''";
			       s1=s2;
		         }		
		}else if(sort_order.contains("atc_class_lev4_desc")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     atc_desc_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))	{
               sort_order = " ORDER BY "+sort_order;
			   atc_desc_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("item_desc")){
		     if(sort_order.contains("Asc")){
              sort_order = " ORDER BY "+sort_order;
			  item_desc_img ="display:''";
			  s2=s1;
			}
			if(sort_order.contains("Desc")){
			   sort_order = " ORDER BY "+sort_order;
			   item_desc_img ="display:''";
			   s1=s2;			
			}
	     }else if(sort_order.contains("generic_name")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     generic_name_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc")){
               sort_order = " ORDER BY "+sort_order;
			   generic_name_img ="display:''";
			   s1=s2;			
			}
		}
		/*else if(sort_order.contains("BASE_UOM_QOH")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     base_uom_qoh_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc")){
               sort_order = " ORDER BY "+sort_order;
			   base_uom_qoh_img ="display:''";
			   s1=s2;			
			}
		}*/
		//Added by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013
		else if(sort_order.contains("qty_on_hand")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     qoh_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc")){
               sort_order = " ORDER BY "+sort_order;
			   qoh_img ="display:''";
			   s1=s2;			
			}
		}
		//else if(sort_order.contains("avail_qty")){
		else if(sort_order.contains("issue_uom_avl")){ //Added by Rabbani #Inc no:44420(RUT-SCF-0307) on 21-OCT-2013
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     avail_qty_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))	{
               sort_order = " ORDER BY "+sort_order;
			   avail_qty_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("issue_uom")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     uom_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))	{
               sort_order = " ORDER BY "+sort_order;
			   uom_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("unit_cost")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     unit_cost_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))	{
               sort_order = " ORDER BY "+sort_order;
			   unit_cost_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("item_value")){
			if(sort_order.contains("Asc")){
              sort_order = " ORDER BY "+sort_order;
			  item_value_img ="display:''";
			  s2=s1;
			}else{
			   sort_order = " ORDER BY "+sort_order;
			   item_value_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("stock_item_yn")){
			if(sort_order.contains("Asc")){
              sort_order = " ORDER BY "+sort_order;
			  stock_item_img ="display:''";
			  s2=s1;
			 }else{
			   sort_order = " ORDER BY "+sort_order;
			   stock_item_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("reorder_level")){
			if(sort_order.contains("Asc")){
              sort_order = " ORDER BY "+sort_order;
			  Ro_level_img ="display:''";
			  s2=s1;
			}else{
			   sort_order = " ORDER BY "+sort_order;
			   Ro_level_img ="display:''";
			   s1=s2;			
			}
		}
		//ends
		
		 sqlMap.put("sqlData", sql+sort_order);
		
		displayFields.add("STORE_DESC");	
		displayFields.add("ITM_CODE");		
		displayFields.add("ITEM_DESC");
		displayFields.add("AVAIL_QTY");        
		displayFields.add("ISSUE_UOM");         
		displayFields.add("ISSUE_UOM_AVL");     
		
		displayFields.add("BASE_UOM_QOH");        
		displayFields.add("UOM_DESC");
		displayFields.add("QTY_ON_HAND");       
		displayFields.add("UNIT_COST");
		displayFields.add("ITEM_VALUE");
		displayFields.add("STOCK_ITEM_YN");
		displayFields.add("STORE_CODE");
		displayFields.add("REORDER_LEVEL"); //13
	  //displayFields.add("ITEM_ALPHA_CODE");
		displayFields.add("GENERIC_NAME");
	  //displayFields.add("DOSAGE_FORM");
		displayFields.add("ATC_CLASS_LEV4_DESC"); //15
		displayFields.add("GENERIC_ID"); //16
		displayFields.add("BASE_UNIT_COST"); //Added by Sakti against TTM-SCF-0106 to get base_unit_cost
		displayFields.add("ITEM_VALUE_NEW"); //Added by Sakti against TTM-SCF-0106 to get (base uom unit_cost*qty)item_value_new

		 
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block10Bytes, _wl_block10);
if(((String)bean.getAccessCostDetails()).equals("N")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
if(((String)bean.getAccessCostDetails()).equals("Y")){
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_code_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(atc_desc_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(item_desc_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(generic_name_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qoh_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(avail_qty_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(uom_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(((String)bean.getAccessCostDetails()).equals("Y")){
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(unit_cost_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(item_value_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(stock_item_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(Ro_level_img));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s1));
            _bw.write(_wl_block36Bytes, _wl_block36);

						ArrayList records=new ArrayList();
						for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++) {
								classvalue			=	(recCount % 2 == 0)?"QRYEVEN":"QRYODD";
	
								records				=	(ArrayList) result.get(recCount);
							   count = Integer.parseInt((String)bean.fetchRecord(StRepository.getStKeyValue("SQL_ST_DRUG_STOCK_STATUS_BY_STORE_ATC_COUNT"),new String[]{CommonBean.checkForNull((String)records.get(16)), locale}).get("COUNT"));
				
            _bw.write(_wl_block37Bytes, _wl_block37);

				
								curr_item_store		=		(String)records.get(0);
				if(!curr_item_store.equals(prev_item_store))
				{
				
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(0),"")));
            _bw.write(_wl_block40Bytes, _wl_block40);

								store_code_from			=		CommonBean.checkForNull((String)records.get(0),"");
			  }
			 else{
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)records.get(12)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block47Bytes, _wl_block47);
if(count>1){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)records.get(16)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(15),"&nbsp;")));
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(15),"&nbsp;")));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(2),"&nbsp;")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(14),"&nbsp;")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.setNumberFormat(bean.checkForNull((String)records.get(8),"0"),no_of_decimals)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bean.setNumberFormat(bean.checkForNull((String)records.get(5),"0"),no_of_decimals)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bean.checkForNull((String)records.get(4),"&nbsp;")));
            _bw.write(_wl_block61Bytes, _wl_block61);
 String val=CommonBean.checkForNull((String)records.get(17),"0"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
if(((String)bean.getAccessCostDetails()).equals("Y")){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(val));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bean.setNumberFormat(bean.checkForNull(val,"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block64Bytes, _wl_block64);
 String num=CommonBean.checkForNull((String)records.get(18),"0");
	
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(num.equals("0")? "0.00":bean.setNumberFormat(bean.checkForNull(num,"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);

	if(CommonBean.checkForNull((String)records.get(11)).equals("Y"))
	out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
	out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");

				
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(13),"&nbsp;")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records.get(8)));
            _bw.write(_wl_block70Bytes, _wl_block70);

			prev_item_store=curr_item_store;
			}
		
            _bw.write(_wl_block71Bytes, _wl_block71);

	
		} 
		else{
			

		
            _bw.write(_wl_block72Bytes, _wl_block72);

		
		}
		out.println(" </table>	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/DrugStockStatusByStoreResult.jsp", searched));

		
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());

		e.printStackTrace();
	}

            _bw.write(_wl_block73Bytes, _wl_block73);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block74Bytes, _wl_block74);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ATCClassification.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GenericName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.DosageForm.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitCost.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StockItem.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
}
