package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.BatchSearchBean;
import eST.Common.*;
import eST.StockTransferBean;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eST.BatchSearchBeanForBarcode;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __stocktransferlistdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StockTransferListDetail.jsp", 1709122224212L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n \n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/StockTransfer.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t</head>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<!--<body onLoad=\"FocusFirstElement()\">-->\n\t<body>\n\t\t<form name=\'formStockTransferListDetail\' id=\'formStockTransferListDetail\'>\n\t\t\t<table border=\'1\' width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' align=\"center\">\n \t\t\t<tr>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t <th style=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>  \n\t\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\n\n<tr id=\"tr_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t\t\t\t\n           ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" nowrap   name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<font class=\"DATAHIGHLIGHT\"><center>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</center></font>\n\t\t\t\t\t</td>\n\n                    \n\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n                  \t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" nowrap style = \"cursor:pointer\"   onClick=\"showHistory(tr_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =",";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =");\" name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<center><font class=\"DATAHIGHLIGHT\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></center></td>\n\n\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<td  class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></center></td>\n\t\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \n\t\t<td  class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" nowrap    name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font></center></td>\n\t\n\t\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n                   \n            ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n \t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n\t\t\t\t <td  class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" style = \"cursor:pointer\"   onClick=\"showHistory(tr_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =");\" >\t\t\t\t<center>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<br><font class=\"DATAHIGHLIGHT\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font></center>\n                 </td>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t <td  class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =");\" >\t\t<center>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</font></center>\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t  \n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t     <td  class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"  >\n\t\t\t\t\t\t<center>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</center>\n                     </td>\n                 ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" nowrap  name=\"batch_id_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"  >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t<!-- \t\t\t\t\t\n\t\t\t\t\t\t* @Name - Priya\n\t\t\t\t\t\t* @Date - 19/02/2010\n\t\t\t\t\t\t* @Inc# - IN019466\n\t\t\t\t\t\t* @Desc - To right align Avaiable Qty.\t\t\t\t\n\t\t\t\t\t-->\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" nowrap  name=\"avail_qty\" style=\"TEXT-ALIGN:right\"><span id=\"id_stock_avail_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</span>&nbsp;</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" nowrap ><select class=\"STSMALL\" name=\"to_bin_location_code_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"to_bin_location_code_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</select></td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" nowrap ><input type=\'text\'  name=\"item_qty_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"item_qty_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"  size=12 maxlength=12 class=\"NUMBER\" onkeypress=\"allow_restrict_decimals1(this,event);\" onBlur=\"return CheckDtlQuantity(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"   ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" ></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t \t<td class=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" nowrap  name=\"saleprice\" style =  \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\"TEXT-ALIGN:right\"><span id=\"id_sales_price";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</span>&nbsp;</td>  \n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\n\t\t\t\t</tr>\n\t\t\t\t\t<!--added-->\n\t\t\t\t\t<input type=\"hidden\" name=\"batch_id_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"batch_id_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t\t<!--ended-->\n\t\t\t\t\t<input type=\"hidden\" name=\"trade_id_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"trade_id_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bin_location_code_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"bin_location_code_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"manufacturer_name_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"manufacturer_name_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t\t \n\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t<input type=\"hidden\" name=\"total_checkboxes\" id=\"total_checkboxes\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t<input type=\"hidden\" name=\"expired_batch\" id=\"expired_batch\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t<input type=\"hidden\" name=\"ex_param_days\" id=\"ex_param_days\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n           <input type=\"hidden\" name=\"allow_deci_yn\" id=\"allow_deci_yn\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n            <input type=\"hidden\" name=\"no_deci\" id=\"no_deci\"\t\t value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t <input type=\"hidden\" name=\"store_code\" id=\"store_code\"\t\t value=\"\">\n\n\t\t\t\t<input type=\"hidden\" name=\"batchsearch\" id=\"batchsearch\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\n\n\n\n\t\t</form>\n\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t<script language=\"JavaScript\">\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\t\t\n\t\tparent.frameStockTransferListHeader.addToList1();\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\tparent.frameStockTransferListHeader.addToList();\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\t\n\tparent.frameStockTransferListHeader.callItemQtyUpdate();\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\t\n\tparent.frameStockTransferListHeader.newbatch(\'stockTransferBean\',\'eST.StockTransferBean\');\n\tparent.frameStockTransferListHeader.addToListforBarCode1(\'stockTransferBean\',\'eST.StockTransferBean\',\'StockTransferListHeader\',\'StockTransferListDetail\',\'StockTransferDetail\');\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t<!--Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014-->\n\t\t\t<script>alert(getMessage(\"INSUFFICIENT_BATCH_QTY\",\"ST\"));</script>\n\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );
	
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
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
??
23/06/2017		IN064605			Badmavathi B								ML-BRU-SCF-1717
---------------------------------------------------------------------------------------------------------
*/

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
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


		StockTransferBean bean = (StockTransferBean)getBeanObject("stockTransferBean","eST.StockTransferBean",request);
		bean.setLanguageId(locale);
		eST.Common.StDuoHeaderBean beanHdr = (eST.Common.StDuoHeaderBean) getBeanObject("stDuoHeaderBean","eST.Common.StDuoHeaderBean",request);
		int i	=0;
		beanHdr.setLanguageId(locale);
		String index=bean.checkForNull(request.getParameter("index"),"-1");
	//	String doc_srl_no=bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
		String function = bean.checkForNull(request.getParameter("function"));
		String fnction = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));
		String store_code = bean.checkForNull(request.getParameter("store_code"));
		String to_store_code = bean.checkForNull(beanHdr.getTo_store_code());
		String item_qty = bean.checkForNull(request.getParameter("item_qty"));
	//	String function_id = bean.checkForNull(request.getParameter("function_id"));
		String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
		String addToList = request.getParameter("addToList");
		String LoginFacilityId = bean.getLoginFacilityId();

		//ganga
		String batchsearch					=		bean.checkForNull(request.getParameter("batchsearch"));
		String barcode_appl                 =		bean.checkForNull(bean.getBarcodeApplicable(),"N");
		String BarcodeWithMultipleBatches	=		bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"),"N");
		
		

        String allow_deci_yn            =   bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
	    String no_deci            =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		if(allow_deci_yn.equals("N"))
        no_deci ="0";

		

		String kit = (String)request.getParameter("kit")==null?"":(String)request.getParameter("kit");
		ArrayList alBatchRecords = null;
		
		HashMap hmBatchRecord = null;
		//String BatchKey = "";
		String className	=	"";
		//String date_legend="Expiry Dt";
		String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
        int EWDays = 0;
		int expired_batch = 0;
        String   trn_type = "";
		String  saleprice= ""; 
		String  display_flag					= "visibility:hidden";
		String  display = ""; 

		

		String	BARCODE_YN      = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
 		String defaultqty_appl  = request.getParameter("defaultqty_appl")==null?"N":request.getParameter("defaultqty_appl");
		String editqty_appl1    =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
		String Qty_disabled = "";
		String mode = bean.getMode();
		

		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl1.equals("N")){
		Qty_disabled  = "disabled"	;
		}

		try { 
			

			EWDays = bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));

			if(expiry_yn.equals("N")) {
				//date_legend="Receipt Dt";
				 date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			}

			String defaultBinLocationCode	=	bean.getDefaultBinLocationCode(to_store_code,item_code);	
			System.out.println("defaultBinLocationCode== T95 === >"+defaultBinLocationCode);				
			
			
			if(function.equals("modify"))	{
				
				//alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 

				if (BARCODE_YN.equals("TRUE"))
				alBatchRecords =(ArrayList)bean.getExpRecordsforBarCode(Integer.parseInt(index)); 
				else
				alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 


				}
			else if(function.equals("edit"))	{
				
				StUtilities bean1 = (StUtilities)getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean1.setLanguageId(locale);
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn	=	bean1.getBatches(hmParameters);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
				ArrayList alTemp	= null;
				HashMap hmTemp		= null;
				for(i=0;i<alBatchRecords.size();i++){
					hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				
                    String stItem_code =(String)hmBatchRecord.get("ITEM_CODE");
					String stBatch_id=(String)hmBatchRecord.get("BATCH_ID");
					String stExpiry_date=(String)hmBatchRecord.get("EXPIRY_DATE");
					alTemp = bean.getBatchStatus(stItem_code,stBatch_id,stExpiry_date);
					hmTemp = (HashMap)alTemp.get(0) ;
                    String stBatch_status =  (String)hmTemp.get("BATCH_STATUS") ;
					hmBatchRecord.put("BATCH_STATUS",stBatch_status);
				}

				System.out.println("kit...in..StockTransListDetail.jsp... "+kit+"--bean.getBarcodeApplicable():"+bean.getBarcodeApplicable());
				if(((String)kit).equals("kit")  && bean.getBarcodeApplicable().equals("Y")){
				for(int h=0;h<alBatchRecords.size();h++){
				HashMap ht = (HashMap)alBatchRecords.get(h);
				ht.put("KIT","KIT");
				}
				System.out.println("kit...in..StockTransListDetail.jsp... "+alBatchRecords);
				bean.setExpRecordsforBarCode( Integer.parseInt(index), alBatchRecords);
				}



				putObjectInBean("stUtilities",bean1,request);
			}
			//added for barcode
				else if(function.equals("barcode"))	{
				try
				{
				boolean check = true;
				ArrayList OldExpRecords = new ArrayList();
				HashMap CurrBatchRecords = new HashMap();

				if(BarcodeWithMultipleBatches.equals("Y")){
					BatchSearchBeanForBarcode bean3 = (BatchSearchBeanForBarcode) getBeanObject("batchSearchBeanForBarcode","eST.BatchSearchBeanForBarcode", request  );
					bean3.setLanguageId(locale);
					alBatchRecords = bean3.getSelectedList();
					System.out.println("alBatchRecords getSelectedList in StockTransferListDetail.jsp ..."+alBatchRecords);
					if (alBatchRecords==null) {
					throw new Exception("No batch selected..");
					}
					putObjectInBean("batchSearchBeanForBarcode",bean3,request);
				}else{
					alBatchRecords = bean.getBatchRecords() ;
				}

				//alBatchRecords = bean.getBatchRecords() ;

				System.out.println("StockTransferListDetail alBatchRecords=====148=>"+alBatchRecords); 
				for(int binlocn=0; binlocn < alBatchRecords.size() ; binlocn++) {
				HashMap hmBatchRecord1 = (HashMap)alBatchRecords.get(binlocn);
				//HashMap hmBatchRecord1 = (HashMap)alBatchRecords.get(0);
				hmBatchRecord1.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				hmBatchRecord1.put("RET_ITEM_QTY",	"0");

				store_code = (String)hmBatchRecord1.get("STORE_CODE");
				}

				System.out.println("StockTransferListDetail alBatchRecords=====155=>"+alBatchRecords); 
				System.out.println("index...in..StockTransferListDetail.jsp... "+index);				
				
				ArrayList DtlRecords  = new ArrayList();
				DtlRecords =	bean.getDtlRecordsforBarCode()==null?DtlRecords:bean.getDtlRecordsforBarCode();

				if (DtlRecords.size()>0){
					ArrayList altemp = bean.getDtlRecordsforBarCode();
					for (int m = 0 ; m < altemp.size() ; m++){
					HashMap temp = (HashMap)altemp.get(m);
					if((temp.get("item_code")).toString().equals(item_code)) {
					//int pdoc_srl_no = Integer.parseInt((String)temp.get("doc_srl_no"));
					//--pdoc_srl_no;
					int pdoc_srl_no = m;

					OldExpRecords = bean.getExpRecordsforBarCode(pdoc_srl_no);
												
					int OldExp = OldExpRecords.size();
					for ( int m1=0; m1 < alBatchRecords.size(); m1++ ){
					boolean isExist = false;
					CurrBatchRecords =(HashMap)alBatchRecords.get(m1) ;					
					
					for ( int m2 = 0 ; m2 < OldExp ; m2++){
					HashMap exp = (HashMap)OldExpRecords.get(m2);
				
					if (( CurrBatchRecords.get("ITEM_CODE").equals(exp.get("ITEM_CODE")) &&  CurrBatchRecords.get("BATCH_ID").equals(exp.get("BATCH_ID")) &&  CurrBatchRecords.get("EXPIRY_DATE").equals(exp.get("EXPIRY_DATE"))	&& 	CurrBatchRecords.get("BIN_LOCATION_CODE").equals(exp.get("BIN_LOCATION_CODE")) &&  CurrBatchRecords.get("TRADE_ID").equals(exp.get("TRADE_ID")))){
					isExist = true;
					}  					
					}
					if (!isExist){
					OldExpRecords.add(CurrBatchRecords);
					}				
					}					
					bean.setExpRecordsforBarCode( pdoc_srl_no, OldExpRecords);
					check = false;
					}
				}
				}
				if(check){
				System.out.println("StockTransferListDetail.jsp 176.."+bean.getExpRecordsforBarCode());	
				hmBatchRecord = (HashMap)alBatchRecords.get(0);
				hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				hmBatchRecord.put("RET_ITEM_QTY",	"0");
				bean.setExpRecordsforBarCode( Integer.parseInt(index), alBatchRecords);
				System.out.println("StockTransferListDetail.jsp 178.."+bean.getExpRecordsforBarCode());	
				}

				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in StockTransferListDetail.jsp ...function=barcode..");
					System.out.println(ex.toString());
				}
				}

				else if (fnction.equals("addbarcode")){
				
				try
				{
				StUtilities bean2 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean2.setLanguageId(locale);
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn	=	bean2.getBatches(hmParameters);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
				//Modified against ML-BRU-SCF-1717 starts
				/*
				hmBatchRecord = (HashMap)alBatchRecords.get(0);
				hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);	
				hmBatchRecord.put("RET_ITEM_QTY",	"0");
				*/
				for(int k=0; k < alBatchRecords.size() ; k++) {
					hmBatchRecord = (HashMap)alBatchRecords.get(k);
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
					hmBatchRecord.put("RET_ITEM_QTY",	"0");
				}
				//Modified against ML-BRU-SCF-1717 ends
				bean.setAddBatchRecords(alBatchRecords);
				putObjectInBean("stUtilities",bean2,request);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in StockTransferListDetail.jsp ...function=addbarcode..");
					throw ex;//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
				}
			}
				else if(function.equals("2DBARCODE")){//Added for MOHE-CRF-0167
					String bar_code = bean.checkForNull(request.getParameter("bar_code"));
					String barcodeExist="";
					String newitem_exist="";
					 String select_array="";
					 ArrayList select_hashmap=new ArrayList();
					String item_2d_barcode_yn =bean.barcode2DApplicable();
					ArrayList alBatchRecords1 = new ArrayList();
					HashMap barcodeBatchRecords = new HashMap();
					HashMap ExpRecords = new HashMap();
					alBatchRecords1=bean.get2DBarcodeBacthes(store_code,bar_code);
					if(alBatchRecords1.size()>0){
					barcodeBatchRecords=(HashMap)alBatchRecords1.get(0);
					int avail_qty=Integer.parseInt((String)barcodeBatchRecords.get("AVAIL_QTY"));
					if(avail_qty>0){
					
						 if(((bean.getExpRecords()).size()>=1) && !item_code.equals("")){	
								ExpRecords=bean.getExpRecords();
								for (Object key : ExpRecords.keySet()) {
									String k = (String) key;
							alBatchRecords = (ArrayList)bean.getExpRecords(Integer.parseInt(k));
							for(i=0;i<alBatchRecords.size();i++){
								hmBatchRecord=(HashMap)alBatchRecords.get(i);
								String barcodeitem_code=(String)barcodeBatchRecords.get("ITEM_CODE");
								if(barcodeitem_code.equals((String)hmBatchRecord.get("ITEM_CODE"))){

									  select_array=k;
									  select_hashmap.add(i);
								}
							} // end i
							} // end j
								if(!select_array.equals("")){
								for (Object key : ExpRecords.keySet()) {
									String k = (String) key;
									if(select_array.equals(k)){
										alBatchRecords = (ArrayList)bean.getExpRecords(Integer.parseInt(k));
										for(int x=0 ; x<select_hashmap.size() ; x++ ){
											hmBatchRecord=(HashMap)alBatchRecords.get(x);
								String barcode_data1=(String)barcodeBatchRecords.get("EXPIRY_DATE")+(String)barcodeBatchRecords.get("BATCH_ID")+(String)barcodeBatchRecords.get("TRADE_ID")+(String)barcodeBatchRecords.get("BIN_LOCATION_CODE")+(String)barcodeBatchRecords.get("ITEM_CODE");
								if(barcode_data1.equals((String)hmBatchRecord.get("EXPIRY_DATE")+(String)hmBatchRecord.get("BATCH_ID")+(String)hmBatchRecord.get("TRADE_ID")+(String)hmBatchRecord.get("BIN_LOCATION_CODE")+(String)hmBatchRecord.get("ITEM_CODE"))) {
									barcodeExist="Y";
									int j=Integer.parseInt((String)hmBatchRecord.get("QTY"));
									j=j+1;
									String Str_j=String.valueOf(j);
									hmBatchRecord.put("QTY",Str_j);
							}
							} // end i
							} // end j
								} 
							if(!barcodeExist.equals("Y")){		
								barcodeBatchRecords.put("QTY","1");
								barcodeBatchRecords.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
							alBatchRecords.add(barcodeBatchRecords);
					}
						 }else {
									alBatchRecords = bean.get2DBarcodeBacthes(store_code,bar_code);
									hmBatchRecord=(HashMap)alBatchRecords.get(0);
									hmBatchRecord.put("QTY","1");
								}
						
						}else {
							alBatchRecords = bean.get2DBarcodeBacthes(store_code,bar_code);
							hmBatchRecord=(HashMap)alBatchRecords.get(0);
							hmBatchRecord.put("QTY","1");
						}
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
					function="edit";
					
					} else {
						throw new InsufficientBatchException();
					}
						
					} else {
						throw new Exception("ITEM_STORE_ITEM_CLASS_NOT_FOUND");
					}
				} // end


			else
			{

				BatchSearchBean bean2 = (BatchSearchBean) getBeanObject("batchSearchBean","eST.BatchSearchBean", request );
				bean2.setLanguageId(locale);
				alBatchRecords = bean2.getSelectedList();
				if (alBatchRecords.size() >0)
				{
					for(i=0;i<alBatchRecords.size();i++){
					hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
					hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
				}
				}
				else
				{
					//	hmRecord=bean.getDtlRecord(Integer.parseInt(index));
					alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
					function="modify";
								}
			putObjectInBean("batchSearchBean",bean2,request);
			}
			
			//if((function.equals("barcode")) || (fnction.equals("barcode")) || ( batchsearch.equals("newbatch") && barcode_appl.equals("Y"))){
			//}
			//else{
				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
			//}


			//Added By Rabbani #inc no:28266 on 16/09/11 
	       //Starts Here

		   ArrayList  alist =  bean.getTrnTypeArrayList();
	         for(int k=0; k<alist.size(); k++){
	         HashMap  blist = (HashMap)alist.get(k);
	         for(int l=0; l<blist.size();l++){
	          trn_type = (String)blist.get("TRNTYPE");
	           if(trn_type.equals("TFR")){
		       if(((String)bean.getAccessSaleyn(store_code)).equals("Y")){ 
		         display = "visible";		   
	  	         display_flag	="visibility:visible"; 
			 }		 
		   } 
		}
	}
	 
	 //ends



	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(date_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(display.equals("visible")){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
				//Added By Rabbani #inc no:28266 on 16/09/11

				try{
				String pitem_code=(String)hmBatchRecord.get("ITEM_CODE");
				String pbatch_id=(String)hmBatchRecord.get("BATCH_ID");
			    String ptrade_id=(String)hmBatchRecord.get("TRADE_ID");
				saleprice	 =  (String)bean.getSalePrice(LoginFacilityId,"I",pitem_code,ptrade_id,pbatch_id);
			  }
			  catch ( Exception e ){
					e.printStackTrace() ;
				}
				//ends
			 

				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);

					if (((String)hmBatchRecord.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)hmBatchRecord.get("NOD")) <= EWDays){
					expired_batch = expired_batch + 1;    
            _bw.write(_wl_block19Bytes, _wl_block19);

					 if(Integer.parseInt((String)hmBatchRecord.get("NOD")) > 0){
			
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(className));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("Exp. "+(String)hmBatchRecord.get("NOD")+"Days"));
            _bw.write(_wl_block24Bytes, _wl_block24);
	}else{
            _bw.write(_wl_block25Bytes, _wl_block25);

                      // String stTempStatus = "Expired";
String stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
					   if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C")){
		//				   stTempStatus ="Exp./Notified" ;
		stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Notified.label","st_labels");

						   
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(className));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stTempStatus));
            _bw.write(_wl_block31Bytes, _wl_block31);

							 } else if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S")){
						//	stTempStatus ="Exp./Suspnd" ;
							stTempStatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired/Suspend.label","st_labels");
					   
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(className));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stTempStatus));
            _bw.write(_wl_block33Bytes, _wl_block33);
                  } else {

	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(className));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stTempStatus));
            _bw.write(_wl_block36Bytes, _wl_block36);

}
					} 
					  
            _bw.write(_wl_block37Bytes, _wl_block37);

					} else {
					   
            _bw.write(_wl_block38Bytes, _wl_block38);

					if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("C"))
				{ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(className));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

				}
				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("S"))
				{ 
						
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(className));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
 
				}  
            _bw.write(_wl_block47Bytes, _wl_block47);

				if(((String)hmBatchRecord.get("BATCH_STATUS")).equals("A"))
				{ 	
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(className));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block50Bytes, _wl_block50);
 
				       }
			}			 
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(className));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(hmBatchRecord.get("BATCH_ID")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(className));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(hmBatchRecord.get("TRADE_NAME")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(className));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(hmBatchRecord.get("BIN_DESC")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(className));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean.setNumber((String)hmBatchRecord.get("AVAIL_QTY"),Integer.parseInt(no_deci))));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(className));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean.getSTITBin_location_code_List(to_store_code,(String)hmBatchRecord.get("ITEM_CODE"),(String)hmBatchRecord.get("TO_BIN_LOCATION_CODE"),locale)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(className));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf((function.equals("edit")||function.equals("modify"))?bean.setNumber((String)hmBatchRecord.get("QTY"),Integer.parseInt(no_deci)):""));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(Qty_disabled));
            _bw.write(_wl_block66Bytes, _wl_block66);
if(display.equals("visible")){
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(className));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(saleprice));
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(hmBatchRecord.get("BATCH_ID")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(hmBatchRecord.get("EXPIRY_DATE")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(hmBatchRecord.get("TRADE_ID")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(hmBatchRecord.get("BIN_LOCATION_CODE")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(hmBatchRecord.get("MANUFACTURER_NAME")));
            _bw.write(_wl_block82Bytes, _wl_block82);
	}
				
			
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(expired_batch));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(EWDays));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(allow_deci_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(batchsearch));
            _bw.write(_wl_block89Bytes, _wl_block89);

putObjectInBean("stockTransferBean",bean,request);
putObjectInBean("stDuoHeaderBean",beanHdr,request);


            _bw.write(_wl_block90Bytes, _wl_block90);

	if (addToList!=null){
		if(((String)kit).equals("kit")|| (fnction.equals("edit"))){

            _bw.write(_wl_block91Bytes, _wl_block91);
		
		}else{

            _bw.write(_wl_block92Bytes, _wl_block92);

		}
	}
	else if (fnction.equals("barcode")){
	if (defaultqty_appl.equals("Y")){
	
            _bw.write(_wl_block93Bytes, _wl_block93);
	}
	}
	else if (fnction.equals("addbarcode")){
	
            _bw.write(_wl_block94Bytes, _wl_block94);
	
	}
	
            _bw.write(_wl_block95Bytes, _wl_block95);

		}
		catch (eST.Common.InsufficientBatchException insufficientBatchException) {
		//	out.println("Insufficient Quantity.");
            _bw.write(_wl_block96Bytes, _wl_block96);
insufficientBatchException.printStackTrace();
		}
		catch (Exception exception) {
		//	out.println(exception);
			exception.printStackTrace();
			
		}
				

            _bw.write(_wl_block97Bytes, _wl_block97);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ToStoreMasterBin.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.TransferQty.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.saleprice.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Notified.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Suspended.label", java.lang.String .class,"key"));
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
