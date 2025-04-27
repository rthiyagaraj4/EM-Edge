package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.SplitBatchBean;
import eST.Common.*;
import eMM.Common.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.Common.*;
import java.util.HashMap;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __splitbatchcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SplitBatchCriteria.jsp", 1733029182057L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n---------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History    \tName\t\tRev. Date\t\tRev. By\t\t\tDescription\n---------------------------------------------------------------------------------------------------------\n09/02/2017\t\tIN061923\t\t\tBadmavathi B\t\t\t\t\t\t\tGHL-CRF-0413.6 - Barcode search\n07/08/2020      IN073577        B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2\n---------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\n\t\t<title> </title>\n<!--\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!--<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<!--<script language=\"javascript\" src=\"../../eST/js/StMessages.js\"></script> -->\n\t\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/StTransaction.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/SplitBatch.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t</head>\n<body onLoad=\"FocusFirstElement();diplayLbl();GoBarcode();\">\n<form name=formOpeningStockListHeader>\n\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\"center\">\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;&nbsp;</td><!-- Modified for TFS id:6938 -->\n\t\t<td colspan=5  class=\'fields\'>\n\t \t<input type=text name=barcode id=barcode size=80 maxlength=100 onkeypress=\"callBarCodeBatchSearchsplit1(event, barcode,trn_type,parent.parent.frameOpeningStockHeader.document.SplitBatchHeader.store_code,\'\',this.form,\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'OpeningStockListHeader\',\'OpeningStockListDetail\',\'OpeningStockDetail\'); \"   ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ></td> <!--Modified for IN:073577 increased size from 70 to 80 -->  \n\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;&nbsp;</td>\n\t\t<td colspan=5  class=\'fields\'>\n\t\t <!-- <input type=text name=item_desc size=70 maxlength=60 value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"   ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" ><input type=button name=\"item_search\" id=\"item_search\" class=\"button\" onClick=\"callItemSearchScreen(item_code)\"  value=\'?\' ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="  >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<b  id=td_uom  >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;</b></td>  --> \n\t\t<!-- onblur=\"ValidateItem(this);\" -->\n\t \t<input type=text name=item_desc id=item_desc size=70 maxlength=60 onkeypress=\"callBarCodeBatchSearchsplit(event, item_desc,trn_type,parent.parent.frameOpeningStockHeader.document.SplitBatchHeader.store_code,\'\',this.form,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'OpeningStockListHeader\',\'OpeningStockListDetail\',\'OpeningStockDetail\'); \"    value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ><input type=button name=\"item_search\" id=\"item_search\" class=\"button\"  onClick=\"callBarCodeBatchSearchsplit(event,item_desc,trn_type,parent.parent.frameOpeningStockHeader.document.SplitBatchHeader.store_code,\'\' ,this.form,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'OpeningStockListHeader\',\'OpeningStockListDetail\',\'OpeningStockDetail\');\"  value=\'?\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;</b></td>   \n\t</tr><!-- onblur=\"ValidateItem(this);\" -->\n\t\n\t<tr>\n\t\t<td  class=\'fields\'><input type=button name=\"batch_search\" id=\"batch_search\" class=\"button\" onClick=\"callVals()\" disabled value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' ></td>\n\t\t<td class=label  nowrap colspan=5><span id =\"bid_lbl\">&nbsp;</span><!-- </td> -->\n\t\t<b id =\"bid_data\" >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t<span id =ed_lbl nowrap >&nbsp;</span>\n\t\t<b id =ed_data >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</b>&nbsp;</td>\n\t\n\t</tr>\n\t<tr>\n\t\t<td   class=label nowrap ><span id =tn_lbl >&nbsp;</span></td>\n\t\t<td  class=\'fields\' colspan=5 ><b  id =tn_data class=\'fields\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t<span id =bl_lbl nowrap >&nbsp;</span>\n\t\t<b  id =bl_data class=\'fields\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</b>&nbsp;&nbsp;\n\t\t<span  id =aq_lbl nowrap>&nbsp;</span>\n\t\t<b   id =aq_data class=\'fields\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;</b></td>\n\t</tr>\n\t<tr>\n\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 19/01/2010\n\t\t\t* @Inc# - 15496 (SRR20056-CRF-0537.2)\n\t\t\t* @Desc - No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.\t\t\t\n\t\t-->\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<td class=label  >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;&nbsp;</td>\n\t\t<td   colspan=5 class=\'fields\' ><input type=text name=adj_item_qty size=12 value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" maxlength=12 class=\"NUMBER\" onKeyPress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =");\" onblur=\"checkDoubleFormat(this); ComputeCost();\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t<!-- @Name - Priya\n\t\t\t\t* @Date - 17/02/2010\n\t\t\t\t* @Inc# - 19404 \n\t\t\t\t* @Desc - value of \'Value\' & \'Cost\' is checked with \'checkForNull\' function as it is throwing number format exception.\n\t\t-->\n\t\t<!-- @Name - Priya\n\t\t\t\t* @Date - 24/05/2010\n\t\t\t\t* @Inc# -  \n\t\t\t\t* @Desc - bean.setNumber() function of \'Value\' & \'Cost\' is removed as it is already rounded up.\n\t\t-->\n\t\t<label id=\"id_item_unit_cost_label\" style=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</label>&nbsp;\n\t\t<b><label id=\"td_cost\" style=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</label></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t<label   id=\"val_id\" style=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">&nbsp;</label>\n\t\t<label id =\"val_dat\" style=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="><b>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;</b></label></td>\n\t</tr>\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;&nbsp;</td>\n\t\t<input type=\"hidden\" name=\"remarks_code\" id=\"remarks_code\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<td colspan=5 class=\'fields\'><textarea rows=2 cols=35 name=remarks readonly  >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</textarea>\n\t\t<input type=\'button\' class=\'BUTTON\' value=\'?\' name=\'remark\' id=\'remark\' onClick=\"searchRemarks(remarks_code,remarks);\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="></td>\n\t</tr>\n\t</table>\n\t<BR>\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\"doc_type_code\" id=\"doc_type_code\" >\n\t<input type=\"hidden\" name=\"doc_no\" id=\"doc_no\" >\n\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\"\t\t\t\t\tvalue=\"\">\n\t<input type=\"hidden\" name=\"item_unit_cost\" id=\"item_unit_cost\" >\n\t<input type=\"hidden\" name=\"uom\" id=\"uom\" >\n\t<input type=\"hidden\" name=\"uom_code\" id=\"uom_code\">\n\t<input type=\"hidden\" name=\"SQL_ST_ITEM_LOOKUP\" id=\"SQL_ST_ITEM_LOOKUP\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"expiry_yn\" id=\"expiry_yn\">\n\t<input type=\"hidden\" name=\"batch_id_applicable_yn\" id=\"batch_id_applicable_yn\">\n\t<input type=\"hidden\" name=\"trade_id_applicable_yn\" id=\"trade_id_applicable_yn\">\n\t<input type=\"hidden\" name=\"trade_id\" id=\"trade_id\">\n\t<input type=\"hidden\" name=\"bin_location_code\" id=\"bin_location_code\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"stock_item_yn\" id=\"stock_item_yn\">\n\t<input type=\"hidden\" name=\"stock_available_yn\" id=\"stock_available_yn\">\n\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"doc_srl_no\" id=\"doc_srl_no\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<!-- <input type=\"hidden\" name=\"SQL_MM_TRN_REMARKS_LOOKUP\" id=\"SQL_MM_TRN_REMARKS_LOOKUP\"   value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"> -->\n\t<input type=\"hidden\"\tname=\"SQL_ST_TRN_REMARKS_LOOKUP_SELECT\" id=\"SQL_ST_TRN_REMARKS_LOOKUP_SELECT\"\t\tvalue=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\n\t<input type=\"hidden\" name=\"phy_inv_id\" id=\"phy_inv_id\"\t\t\t\t\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"rem_trans_type\" id=\"rem_trans_type\"\t\t\tvalue=\"SPB\">\n\t\t\n\t<input type=\"hidden\"\t\tname=\"dec_allowed_yn\" id=\"dec_allowed_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"hidden\"\t\tname=\"no_of_decimals\" id=\"no_of_decimals\"\t\t\t value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"no_of_decimals_for_cost\" id=\"no_of_decimals_for_cost\" value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\n\t    <input type=\"hidden\"    name=\"trn_type\" id=\"trn_type\"\t\t\t\t\t\t    value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' >\n\t\t<input type=\"hidden\"    name=\"BARCODE_YN\" id=\"BARCODE_YN\"\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' >\n\t\t<input type=\"hidden\"    name=\"barcode_applicable\" id=\"barcode_applicable\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n\t\t<input type=\"hidden\"    name=\"bar_or_item_code\" id=\"bar_or_item_code\"\t\t\t\t\t value=\"\" >\n\t\t<input type=\"hidden\"    name=\"billable_item_yn\" id=\"billable_item_yn\"\t\t\t\t     value=\"\" ><!--dummy-->\n\t\t<input type=\"hidden\"    name=\"sale_req_qty\" id=\"sale_req_qty\"\t\t\t\t          value=\"\" ><!--dummy-->\n\t\t<input type=\"hidden\"    name=\"index_\" id=\"index_\"\t  \t\t\t\t\t  ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\t \n\t    \t<input type=\"hidden\"    name=\"site\" id=\"site\"\t \t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n</form>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	SplitBatchBean bean				=		(SplitBatchBean) getBeanObject( "splitBatchBean",  "eST.SplitBatchBean",  request );
	bean.setLanguageId(locale);

	StHeaderBean beanHdr			=		(StHeaderBean) getBeanObject( "stHeaderBean",  "eST.Common.StHeaderBean",request   );
	beanHdr.setLanguageId(locale);
	String bean_id = "SplitBatchBean";
	String bean_name = "eST.SplitBatchBean";

    String codeDisabled="enable";  //added by gangadharan

	String display_flag				=		"visibility:hidden";
	String store_code				=		(String)request.getParameter("store_code")==null?"":(String)request.getParameter("store_code");;
	String doc_srl_no				=		request.getParameter("doc_srl_no")==null?"-1":request.getParameter("doc_srl_no");
	HashMap DtlArray				=		new HashMap();
	
       String  trn_type  = "SPB";   
       String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	  // System.out.println("BARCODE_YN ===SPB==>"+BARCODE_YN);
	   String  barcode_applicable = "";
       String index						=		bean.checkForNull(request.getParameter("index"),"-1");     
     //Added for GHL-CRF-0413.6 starts
       Connection con				= null;
   	con						= ConnectionManager.getConnection(request);
   	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
   	bean.setSite_spec_yn(site);
  //Added for GHL-CRF-0413.6 ends
	if(!(store_code.equals(""))){
		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag			=		"visibility:visible";
	}

	/**
	* @Name - Priya
	* @Date - 13/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	int no_of_decimals = bean.getNoOfDecimals();

	//added by gangadharan
	if (!doc_srl_no.equals("-1")||doc_srl_no!="-1")
	{
     codeDisabled="Disabled";
	}
	//added ended		

			
		
            _bw.write(_wl_block9Bytes, _wl_block9);

	if(doc_srl_no!="-1")
	{
		DtlArray					=		bean.getDetailList(doc_srl_no);
	}

			/* 		
			* @Name - Priya
			* @Date - 18/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To get the value, whether decimals are allowed to this item or not.	
			*/
			String strAllowDecYN="N";
		 /** @Name - Priya
			* @Date - 23/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To enable & disable remarks look up button
			*/
			String strRemarksDisabled = "disabled";
			
		 if(!(bean.checkForNull((String)DtlArray.get("item_code"))).equals("")){
			  strAllowDecYN	= bean.getAllowDecimalsYN(((String)DtlArray.get("item_code")));
			   strRemarksDisabled = "enabled";
		 }

		 /**
		 * @Name - Priya
		 * @Date - 24/05/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
		 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
	 if (BARCODE_YN.equals("TRUE")){
		DtlArray					=		bean.getDetailList(doc_srl_no);
		barcode_applicable = "Y";
		} 
		System.out.println("barcode_applicable 112====>" +barcode_applicable);
		 String item_desc = bean.checkForNull(((String)DtlArray.get("item_desc")));
		

            _bw.write(_wl_block1Bytes, _wl_block1);
if(site){//Added against GHL-CRF-0413.6 
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block14Bytes, _wl_block14);
} 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("item_desc")))));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("uom")))));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("item_desc")))));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("uom")))));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("batch_id")))));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("expiry_date")))));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("trade_name_desc")))));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("bin_loc_desc")))));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("avl_qty")))));
            _bw.write(_wl_block32Bytes, _wl_block32);
	
		String str_adj_item_qty ="";
		if(doc_srl_no!="-1")
		{
			if(strAllowDecYN.equals("Y")){
				str_adj_item_qty = bean.setNumber(bean.checkForNull(((String)DtlArray.get("adj_item_qty")),"0"),no_of_decimals);
			}else{
				str_adj_item_qty = bean.setNumber(bean.checkForNull(((String)DtlArray.get("adj_item_qty")),"0"),0);
			}
		}
	
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(str_adj_item_qty));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((String)DtlArray.get("item_unit_cost")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)DtlArray.get("item_cost_value")));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("remarks_code")))));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("remarks")))));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strRemarksDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("item_code")))));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bean.checkForNull(((String)DtlArray.get("bin_loc_code")))));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((request.getParameter("doc_srl_no"))==null?"-1":request.getParameter("doc_srl_no")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(MmRepository.getMmKeyValue("SQL_MM_TRN_REMARKS_LOOKUP")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strAllowDecYN));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(trn_type));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(BARCODE_YN));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(barcode_applicable));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(site));
            _bw.write(_wl_block63Bytes, _wl_block63);

	putObjectInBean("splitBatchBean",bean,request);
	putObjectInBean("stHeaderBean",beanHdr,request);

            _bw.write(_wl_block1Bytes, _wl_block1);

//Added for GHL-CRF-0413.6 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413.6 ends

            _bw.write(_wl_block64Bytes, _wl_block64);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BarcodeId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BatchSearch.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cost.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
