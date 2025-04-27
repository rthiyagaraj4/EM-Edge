package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import ePH.Common.*;
import eST.*;
import eST.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __directdispallocatedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DirectDispAllocateDetails.jsp", 1723113575899L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"Javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../ePH/js/PhCommon.js\"></SCRIPT>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DirectDispensing.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t</HEAD>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"Directdispensingallocateform\" id=\"Directdispensingallocateform\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' colspan=8>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp\n\t\t\t\t\t\t\t\t\t   <select onChange=\"issueUOM(this,\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\" name=\"issue_uom_select\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" selected>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t</select>&nbsp;\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  style=\"font-size:9\" width=\"10%\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:9\" width=\"13%\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td> \n\t\t\t\t\t<td class= \"COLUMNHEADER\"  style=\"font-size:9\" width=\"20%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  style=\"font-size:9\" width=\"20%\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  style=\"font-size:9\" width=\"16%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  style=\"font-size:9\" width=\"12%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" </td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  style=\"font-size:9\" width=\"8%\"nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </td>\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  style=\"font-size:9\" width=\"8%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  width=\"10%\" class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"nowrap style=\"font-size:9\">&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\"13%\" class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td> \n\t\t\t\t\t\t\t\t<td width=\"20%\" class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\"20%\" class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\"16%\" class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\"12%\" class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t\t\t\t\t<td width=\"8%\" class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"nowrap style=\"font-size:9\">\n\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"flat\" size=\"4\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" name=\"issue_qty_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" style=\"text-align:right\" onKeyPress=\"return allowValidNumber(this,event,6,0);\" onBlur=\"validateQty(this,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\');\" maxlength=\"5\"> \n\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\'font-size:8\'><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</b></label>\n\t\t\t\t\t\t\t\t\t<label id=\"issue_uom_lbl_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" name=\"issue_uom_lbl_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" class=\"label\" style style=\'font-size:8\' ><b>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</b></label>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  width=\"8%\" class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"nowrap style=\"font-size:9\"><input type=\"checkbox\"  name=\"select_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"select_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" onClick=\"validateCheck(this,\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\" checked></td> \n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"item_code_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"item_code_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"expiry_date_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"expiry_date_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_id_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"batch_id_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"trade_id_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"trade_id_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bin_locn_code_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"bin_locn_code_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alloc_qty_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"alloc_qty_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"issue_uom_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_qty_old";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"issue_qty_old";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"  value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_qty";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"issue_uom_qty";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"  value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_uom";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"issue_uom_uom";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"  value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_desc";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"issue_uom_desc";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_avl_qty_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"batch_avl_qty_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\"  value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"tot_qty\" id=\"tot_qty\"  value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"cal_tot_qty\" id=\"cal_tot_qty\"  value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"><!-- qty after for period defined in dispense location -->\n\t\t\t\t\t<input type=\"hidden\" name=\"base_to_disp_uom_equl_val\" id=\"base_to_disp_uom_equl_val\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"base_to_def_uom_equl_val\" id=\"base_to_def_uom_equl_val\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"base_to_orig_def_uom_equl_val\" id=\"base_to_orig_def_uom_equl_val\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"issuebyuom\" id=\"issuebyuom\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"BASE_UOM\" id=\"BASE_UOM\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"><!-- added for AAKH-SCF-0189 [IN:054663]-->\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t<script> \n\t\t\t\t\t\t\t\t\talert(getMessage(\"PH_ITEM_UOM_DEF_NOT_FOUND\",\"PH\"));\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\talert(getMessage(\"PH_DIRECT_DISPENCING_NO_STOCK\",\"PH\"));\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t alert(getMessage(\"PH_DIRECT_DISPENCING_NO_STOCK\",\"PH\"));\n\t\t\t\t\t\t\t</script>\t\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.parent.f_drug_detail.f_button_1.prescription_button.confirm.disabled=true;\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t</table>\t\n\t\t\t\t</form>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );
	
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

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			String mode                     = request.getParameter("mode") ; 
			String facility_id					= (String) session.getValue("facility_id"); //added for AAKH-SCF-0189 [IN:054663]
			try{
			if(mode.equals("modify")||mode.equals("taper")){
				String dir_bean_id				= "DirectDispensingBean" ;
				String dir_bean_name			= "ePH.DirectDispensingBean";
				DirectDispensingBean dir_bean	= (DirectDispensingBean)getBeanObject(dir_bean_id,dir_bean_name,request);

				/** Stock Bean Integration -Starts ***/ 
				String	bean_id_2		=	"StUtilities" ;
				String	bean_name_2		=	"eST.Common.StUtilities";
				StUtilities bean_2		=	null; 
				try { 
					bean_2 = (StUtilities)getBeanObject(bean_id_2,bean_name_2,request);
					bean_2.setLanguageId(locale);
				}
				catch (Exception exception) {
					out.println(exception);
					exception.printStackTrace();
				}
				String	bean_id_3			=	"batchSearchBean" ;
				String	bean_name_3			=	"eST.BatchSearchBean";

				BatchSearchBean bean_3	= (BatchSearchBean)getBeanObject(bean_id_3,bean_name_3,request);
				bean_3.setLanguageId(locale);
				/** Stock Bean Integration -End ***/ 
				String class_name			=	"";
				String batch_id				=	"";
				String expiry_date			=	"";
				String issue_qty			=	"";
				String item_drug_code		=	"";
				String trade_name			=	"";
				String manufacturer_name	=	"";
				String bin_location			=	"";
				String trade_id				=	"";
				String bin_locn_code		=	"";
				String qty_value		    =   "";
				int rec_no					=   0;
				double tot_qty_1			=   0;
				String uom_code				=  "", content_in_pres_base_uom="";
				String select_status		=  "";
				String order_qty			=  "";
				String sch_size				=  "1";
				String split_dose_yn        =  "";	
				String drug_code            =  ""; 
				String srl_No				=  "";
				String pres_base_uom		=  "";
				String conv_factor          =  "";
				String item_code			=  "";
				String diff_qty             =  "0";	
				String min_end_date			=  "";	
				String pack_size			=  "";
				String calc_qty				=  "";
				String alloc_qty			=  "";
				String tot_qty				=  "";
				String fract_dose			=  "";	
				String act_strength_value	=  "";
				String trade_code			=	"";
				HashMap drugDetails			=  null;
				HashMap drug_detail_1		=  null;		
				HashMap	stock				=  new HashMap();
				ArrayList	stock_detail	=  new ArrayList();
				ArrayList st_detail	        =  null;
				HashMap alloc_batch_qty_details =new HashMap();
				ArrayList alloc_batch_details =null;
				String extdrugCode			=  request.getParameter("drug_code") ;
				String srlNo				=  request.getParameter("srl_no") ;
				String dosage_type			=  request.getParameter("dosage_type") ;
				String qty_desc             =  request.getParameter("qty_desc");
				String durn_value			=  request.getParameter("durn_value") ;
				String end_date             =  request.getParameter("end_date")==null?"":request.getParameter("end_date") ;
				String called_from          =  request.getParameter("called_from") ;
				split_dose_yn       =  request.getParameter("split_dose_yn_val") ;
				String orig_qty_value       =  request.getParameter("qty_value") ;
				String called_when          =  request.getParameter("called_when"); 
				String flag					=  request.getParameter("flag"); 
				String repeat_val			=  request.getParameter("repeat_val"); 
				String freq_nature			=  request.getParameter("freq_nature"); 
				String interval_value		=  request.getParameter("interval_value"); 
				String dispense_location_code  = dir_bean.getDispLocnCode();
				String store_code			   = dir_bean.getStoreCode(dispense_location_code);
				String physical_inv_item_yn ="";
				String stock_uom					=	"";
				String base_to_disp_uom_equl_val	=	"1";
				String base_to_def_uom_equl_val		=	"1";
				String stk_unit_code				=	"";
				String stk_unit_desc				=	"";
				String stk_equval_value				=	"";
				String act_stk_equval_value			=	"";
				String issue_uom_desc				=	"";
				String repeat_durn_type				=	"D";

				boolean variable_flag               =  false;
				int  issue_qty_val					= 0;
				int  issue_qty_val_1				= 0;
				double  variable_conv_factor			= 0;
				double base_to_disp_uom_equl           = 0;
				double base_to_def_uom_equl            = 0;
				StringBuffer issue_qty_dtl			= new StringBuffer();
				String IssueByUOM			        =  dir_bean.getIssueByUOMBy();
				String base_to_orig_def_uom_equl_val ="1"; // initialized to "1" for ICN 30879
				double Actual_Equl_Value =1;
				String barcode_2d_applicable_yn =dir_bean.get2DBarcodeApplicable();//Addef for MMS-DM-CRF-0174.5

				int op_dispperiod			=  dir_bean.getopdispperiod(store_code);
				//Added for difect 13744  To show Tappered drug, Prescribed Quantity
				ArrayList schedule;
				/*if(mode.equals("taper")){
						String tsrlNO=Integer.parseInt(srlNo)+1+"";
						schedule			=  (ArrayList)dir_bean.getScheduleFrequencyStr(extdrugCode+tsrlNO,"0");
				//out.println("==tsrlNO=="+tsrlNO);
				}else{*/
				schedule			=  (ArrayList)dir_bean.getScheduleFrequencyStr(extdrugCode+srlNo,"0");
				//}
				boolean split_chk			=  dir_bean.checkSplit(schedule);
				String dflt_issue_uom		=  "";
				String orig_dflt_issue_uom   =  "";
				String base_uom              =  "";
				String display_list			=  "";	
				String uom_desc				= "";//AAKH-SCF-0338
				ArrayList  stk_units			=  null;
				HashMap issue_uom_qty_hm		=  null;
				HashMap IssueUOMAndBaseUOM	=  null;
				HashMap  detail        = null;
				HashMap issue_uom_qty = null;
				ArrayList presDetails		=  (ArrayList) dir_bean.getpresDetails();
				if(presDetails!=null && presDetails.size()>0 ){
					for(int i=0;i<presDetails.size();i++){
						drugDetails					= (HashMap)presDetails.get(i);
						drug_code					= (String)drugDetails.get("DRUG_CODE");
						srl_No						= (String)drugDetails.get("SRL_NO");
						String tap_srl_no			= "";
						if(mode.equals("taper")){
							srl_No	=Integer.parseInt(srl_No)+1+"";
						}
						pres_base_uom				= (String)drugDetails.get("PRES_BASE_UOM");

						if(dosage_type.equals("Q")){
							conv_factor = (String) dir_bean.getConvFactor(qty_desc,pres_base_uom);						
						}
						if((extdrugCode.equals(drug_code) && srlNo.equals(srl_No)) || (mode.equals("taper")&& extdrugCode.equals(drug_code) && srlNo.equals(srl_No))){
							physical_inv_item_yn =(String)drugDetails.get("PHY_INV_ITEM_YN");
							if( physical_inv_item_yn.equals("N")){
								item_code				= (String)drugDetails.get("ITEM_CODE");
								pack_size				= (String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
								fract_dose				= (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
								act_strength_value	    = (String)drugDetails.get("ACT_STRENGTH_VALUE");
								trade_code				= (String)drugDetails.get("TRADE_CODE");
								stock_uom				= (String)drugDetails.get("STOCK_UOM") ;//drug master dispensing uom
								//freq_nature		    = ((String)drugDetails.get("FREQ_NATURE"))==null?"":(String)drugDetails.get("FREQ_NATURE");
								repeat_durn_type		= (String)drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String)drugDetails.get("REPEAT_DURN_TYPE") ;
								uom_code			=	(String)drugDetails.get("STOCK_UOM");//added for AAKH-SCF-0189 [IN:054663]
								content_in_pres_base_uom	= drugDetails.get("CONTENT_IN_PRES_BASE_UOM")==null?"1":(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");//added for AAKH-SCF-0189 [IN:054663]
		/*=============================variable uom=======================================================================================*/
								dflt_issue_uom		=  "";
								orig_dflt_issue_uom   =  "";
								base_uom              =  "";
								display_list			=  "";	

								stk_units			=  dir_bean.loadStockUnit(drug_code);
								
								issue_uom_qty_hm		=  dir_bean.getIssueUomQty();
								IssueUOMAndBaseUOM	=  null;
								detail = null;
								if(issue_uom_qty_hm.size()>0){	
									if(issue_uom_qty_hm.containsKey(drug_code+srl_No)){
										detail  = (HashMap) issue_uom_qty_hm.get(drug_code+srl_No);
									}
									if(detail!= null && detail.containsKey(drug_code+srl_No+"_uom")){
										dflt_issue_uom = (String)detail.get(drug_code+srl_No+"_uom");
									}
								}

								IssueUOMAndBaseUOM			 =	(HashMap)dir_bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);
								if(dflt_issue_uom.equals("")){
									dflt_issue_uom	  =  (String)((IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM") == null ) ? "" : IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM") );
									detail            =   new HashMap();
									detail.put(drug_code+srl_No+"_uom",dflt_issue_uom);
									dir_bean.setIssueUomQty( drug_code+srl_No,detail);
								}
								orig_dflt_issue_uom		 =	(String)((IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM") == null ) ? "" :IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"));
								base_uom					 =	(String)((IssueUOMAndBaseUOM.get("BASE_UOM") == null) ? "": IssueUOMAndBaseUOM.get("BASE_UOM"));
								if(base_uom.equals(uom_code))//if block and else condition added for AAKH-SCF-0226 [IN:058002]
									base_to_disp_uom_equl = 1;
								else
									base_to_disp_uom_equl       =	dir_bean.getEqulValue ( drug_code, base_uom, uom_code);//stock_uom --uom_code for AAKH-SCF-0189 [IN:054663]
								if(base_uom.equals(dflt_issue_uom)) //if block and else condition added for AAKH-SCF-0226 [IN:058002]
									base_to_disp_uom_equl = 1;
								else
									base_to_def_uom_equl	     =  dir_bean.getEqulValue ( drug_code, base_uom, dflt_issue_uom);
								if(base_uom.equals(dflt_issue_uom) && base_to_def_uom_equl==0)
									base_to_def_uom_equl= 1;
								/*if(base_uom.equals(stock_uom))//Added for ICN 30879 -start //commented for AAKH-SCF-0189 [IN:054663]
									base_to_disp_uom_equl =1;
								if(base_uom.equals(dflt_issue_uom))
									base_to_def_uom_equl = 1;//Added for ICN 30879 -End*/
								Actual_Equl_Value           = dir_bean.getActualEqulValue(drug_code, base_uom, dflt_issue_uom);
								if(Actual_Equl_Value==0)
									Actual_Equl_Value =1;
								if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl!=0){
									variable_flag =true;
								}
								if(IssueByUOM.equals("D")){
									display_list= "display:none";
								}
/*=============================variable ends here====================================================================================*/

								//added for AAKH-SCF-0338 - start
									if(stk_units!=null && stk_units.size()>0){
										if(!stk_units.contains(orig_dflt_issue_uom)){
											uom_desc = dir_bean.getUOMDesc(orig_dflt_issue_uom);
											stk_units.add(orig_dflt_issue_uom);
											stk_units.add(uom_desc);
											stk_units.add("1");
											stk_units.add("1");
										}
									}
								//added for AAKH-SCF-0338 - end
								if(!mode.equals("taper")){
									if(drugDetails.containsKey("SEL_BATCHES")){
										if(!called_when.equals("ONCLICK")){
											alloc_batch_qty_details     =  (HashMap)drugDetails.get("SEL_BATCHES") ;
											alloc_batch_details         =  (ArrayList)drugDetails.get("BATCH_DETAILS") ;
										}
										else{
										   drugDetails.put("SEL_BATCHES",new HashMap());
										}
									}
								}
								float    tot_qty_value    =0; 
								if(dosage_type.equals("S")||dosage_type.equals("Q")){
									if(schedule.size() > 0 && (split_dose_yn.equals("N"))) {
										//HashMap detail	=	(HashMap)schedule.get(0);
										ArrayList dose_list		= (ArrayList)schedule.get(4);
										if(fract_dose.equals("N")){
											if(dose_list.size()>0){
												qty_value		=	(String)dose_list.get(0);
												if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
											}
											else{
												if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
												qty_value="1";
											}
										}
										else{
											if(dosage_type.equals("S")){
												 if(dose_list.size()>0){
													qty_value		=	(String)dose_list.get(0);
													if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
														qty_value="1";
												 }
												 else{
													 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
														 qty_value="1";
												 }
												qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
											}
											else if(dosage_type.equals("Q")){
												if(dose_list.size()>0){
													qty_value		=	(String)dose_list.get(0);
													if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1.0f";
												}
												else{
													if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1.0f";
												}
												qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
											 }  
										 }
										sch_size	 =	""+dose_list.size();	
									}
									else {
										if(split_dose_yn.equals("Y")){
											if(fract_dose.equals("N")){
												if(schedule.size() > 0){
													ArrayList dose_list		= (ArrayList)schedule.get(4);
													String final_qty ="";
													//for(int n=0; n<schedule.size(); n++) {
													for(int n=0; n<dose_list.size(); n++) {
														sch_size		=	"1";
														//HashMap  detail	=  (HashMap)schedule.get(n);
														final_qty=(String)dose_list.get(n);
														if(!(final_qty.equals("")||final_qty.equals("0")||final_qty==null))
															tot_qty_value =  tot_qty_value+Float.parseFloat((String)dose_list.get(n));
														else
															tot_qty_value =  tot_qty_value+1.0f;													 
													}
												}
											}
											else{
												if(schedule.size() > 0){
													ArrayList dose_list		= (ArrayList)schedule.get(4);
													for(int n=0; n<dose_list.size(); n++) {
														sch_size		=	"1";
														//HashMap  detail	=  (HashMap)schedule.get(n);

														if(dosage_type.equals("S")){
															qty_value		=	(String)dose_list.get(n);
															if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
																qty_value="1";
															qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
													   }
													   else if(dosage_type.equals("Q")){
															qty_value		=	(String)dose_list.get(n);
															if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
																qty_value="1";
															qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
													   }  
													   tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
													}
												}
											}
											qty_value       =tot_qty_value+"";
										}
										else{
											if(freq_nature.equals("O")){
												if(fract_dose.equals("Y")&&dosage_type.equals("S")){
												     qty_value        =   (Math.ceil(Float.parseFloat(orig_qty_value)/Float.parseFloat(act_strength_value)))+"";
												}
											}
										}
									}
								}
								//order_qty calculation
								 if(qty_value.equals("")){
									 qty_value=orig_qty_value;
								 }
								 if(flag.equals("Y")){
									sch_size=repeat_val;

								 }
								order_qty =	dir_bean.getOrderQty(drugDetails,qty_value,sch_size,durn_value,dosage_type,conv_factor,split_chk,interval_value,freq_nature,"Allocation");
								// order qty calculation ends here
								order_qty		= new Float(order_qty).intValue()+"";
								tot_qty			= order_qty;
								/*==code for validating OP_DISP_PERIOD in ph_disp_locn Table it will default qty for no of days defined in dispenselocation===========*/
								//out.println(op_dispperiod);
							   int tmp_durn_val=0;
							   if(repeat_durn_type.equals("H"))
								   tmp_durn_val=new Float(Math.ceil(Integer.parseInt(durn_value)/24)).intValue();
							   else if(repeat_durn_type.equals("M"))
								   tmp_durn_val=new Float(Math.ceil(Integer.parseInt(durn_value)/(24*60))).intValue();
							   else if(repeat_durn_type.equals("D"))
								   tmp_durn_val=Integer.parseInt(durn_value)*1;
							   else if(repeat_durn_type.equals("W"))
								   tmp_durn_val=Integer.parseInt(durn_value)*7;
							   else if(repeat_durn_type.equals("L"))
								   tmp_durn_val=Integer.parseInt(durn_value)*30;
							   else if(repeat_durn_type.equals("Y"))
								   tmp_durn_val=Integer.parseInt(durn_value)*365;						   						   
							   if(op_dispperiod!=0){
								   if(tmp_durn_val>op_dispperiod){						
									  order_qty  = (Float.parseFloat(order_qty)/ Float.parseFloat(tmp_durn_val+""))+"" ;
									  order_qty  = ( new Float(Math.ceil(Float.parseFloat(order_qty)* Float.parseFloat(op_dispperiod+""))).intValue())+"" ;	
								   }
							   } 

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(display_list));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(srl_No));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
										for(int k=0; k<stk_units.size(); k+=4) { 
											stk_unit_code			=	(String)stk_units.get(k);
											stk_unit_desc			=	(String)stk_units.get(k+1);
											stk_equval_value		=	(String)stk_units.get(k+2);
											act_stk_equval_value	=	(String)stk_units.get(k+3);

											if(stock_uom.equals(stk_unit_code)){
												base_to_disp_uom_equl_val = stk_equval_value;
											}
											if(orig_dflt_issue_uom.equals(stk_unit_code)){ 
												 base_to_orig_def_uom_equl_val =  stk_equval_value;
											}
											if(dflt_issue_uom.equals(stk_unit_code)){
												issue_uom_desc            =  stk_unit_desc;
												base_to_def_uom_equl_val  =  stk_equval_value;

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(stk_unit_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(stk_equval_value));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(act_stk_equval_value));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);

											}
											else{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(stk_unit_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(stk_equval_value));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(act_stk_equval_value));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);

											}	
										}

            _bw.write(_wl_block18Bytes, _wl_block18);

								if(variable_flag){
									variable_conv_factor  = dir_bean.lcm( Double.parseDouble(base_to_orig_def_uom_equl_val), Double.parseDouble(base_to_def_uom_equl_val));
									variable_conv_factor  = dir_bean.lcm(variable_conv_factor,  base_to_disp_uom_equl);

									issue_uom_qty = dir_bean.getIssueUomQty();
									detail       = (HashMap)issue_uom_qty.get(drug_code+srl_No); 
									detail.put(drug_code+srl_No+"_conv_factor",variable_conv_factor+"");
									detail.put(drug_code+srl_No+"_uom_desc",issue_uom_desc);
									detail.put(drug_code+srl_No+"_base_to_orig_def_uom_equl",base_to_orig_def_uom_equl_val);
									detail.put(drug_code+srl_No+"_base_to_def_uom_equl",base_to_def_uom_equl_val);
									detail.put(drug_code+srl_No+"_base_to_disp_uom_equl",base_to_disp_uom_equl+"");
									detail.put(drug_code+srl_No+"_base_to_disp_uom_equl_Actu",Actual_Equl_Value+"");

									dir_bean.setIssueUomQty( drug_code+srl_No,detail);
									if(base_to_disp_uom_equl!=base_to_def_uom_equl){
										issue_qty_val_1		= new Float(Math.ceil(Integer.parseInt(order_qty)*base_to_disp_uom_equl)).intValue(); 
									}
									else{
										issue_qty_val_1 =Integer.parseInt(order_qty);
									}
									// issue_qty_val= new Float(Math.ceil(((Math.ceil(issue_qty_val_1/variable_conv_factor))*(variable_conv_factor))/base_to_def_uom_equl)).intValue();
									/*============================================================ variable UOM  ends here=============================================*/
									if(!locale.equals("en"))
										min_end_date		=	com.ehis.util.DateUtils.convertDate(end_date,"DMY",locale,"en");
									//stock integration starts
									HashMap params		=	new HashMap();
									params.put("ITEM_CODE",item_code+"="+trade_code);
									params.put("STORE_CODE",store_code);

									params.put("TRN_QTY",issue_qty_val_1+"");
									params.put("INCLUDE_SUSPENDED","FALSE");
									params.put("INCLUDE_EXPIRED","FALSE");
									params.put("CUT_OFF_DATE",end_date);
									params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
									params.put("ALREADY_USED_QTY",diff_qty);
									params.put("MIN_EXP_DATE",min_end_date);	
									if(!dir_bean.getBarcode_id().equals("") && called_when.equals("ONLOAD"))  // MMS-DM-CRF-0112  - Start
										params.put("BARCODE_ID",dir_bean.getBarcode_id().trim());
									else
										dir_bean.setBarcode_id("");  // MMS-DM-CRF-0112  - End
									//System.err.println("params@@@directdispallocate.jsp==="+params);
									if(barcode_2d_applicable_yn.equals("Y") && !dir_bean.getBarcode_id().equals("")){//Added if condition  for MMS-DM-CRF-0174.5
										stock				=	bean_2.get2DBarcodeDetails(params);
									}else{
									    stock				=	bean_2.getBatches(params);
									}
									stock_detail		=	(ArrayList)stock.get("BATCH_DATA");
									st_detail	=	new ArrayList();
									if(called_from.equals("stock") && bean_3.getSelectedList()!=null) {
										st_detail.add(bean_3.getSelectedList());
									}
									else if(called_from.equals("allocate")&& alloc_batch_qty_details.size()==0){
										st_detail.add((ArrayList)stock.get("BATCH_DATA"));
									}
									else{
										st_detail          =  alloc_batch_details;
									} 
									calc_qty           = issue_qty_val_1+"";
									if(!mode.equals("taper")){
										drugDetails.put("BATCH_DETAILS",st_detail) ;
									}
									else{	
										dir_bean.setTaperBatchDetails(st_detail,drug_code+srl_No);
									}
								}
								else{
									st_detail	=	new ArrayList();
								}
							}
							else{
									st_detail	=	new ArrayList();
							}
						}
					}
				}

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

				for(int i=0; i<st_detail.size(); i++)	{
					batch_id			=	"";
					expiry_date			=	"";
					issue_qty			=	"";
					trade_id			=	"";
					bin_locn_code		=	"";	
					boolean from_drug_dtl_flag =false;
					if(st_detail.get(i) != null)
						stock_detail	=	(ArrayList) st_detail.get(i);
						for(int j=0; j<stock_detail.size(); j++ ) {	
							drug_detail_1		=	(HashMap)stock_detail.get(j);
							item_drug_code		=	(String)drug_detail_1.get("ITEM_CODE");	
							expiry_date			=	(String)drug_detail_1.get("EXPIRY_DATE");	
							batch_id			=	(String)drug_detail_1.get("BATCH_ID");	
							trade_id			=	(String)drug_detail_1.get("TRADE_ID");	
							trade_name			=	(String)drug_detail_1.get("TRADE_NAME");	
							manufacturer_name	=	(String)drug_detail_1.get("MANUFACTURER_NAME");	
							bin_locn_code		=	(String)drug_detail_1.get("BIN_LOCATION_CODE");
							bin_location		=	(String)drug_detail_1.get("BIN_DESC");	
							issue_qty			=	(String)drug_detail_1.get("AVAIL_QTY");	
							if((called_from.equals("allocate")&& alloc_batch_qty_details.size()==0)||(called_from.equals("stock"))){
								if(Double.parseDouble(issue_qty)<Double.parseDouble(calc_qty) ){									       
									alloc_qty   =issue_qty;
									calc_qty    =(Double.parseDouble(calc_qty)-Double.parseDouble(issue_qty))+"";	
								 }
								 else{									
									alloc_qty   =calc_qty;
									calc_qty    ="0";										   
								 }
							}
							else{  
								 if(alloc_batch_qty_details.containsKey(j+"")){
									 alloc_qty =(String) alloc_batch_qty_details.get(j+"");
									 from_drug_dtl_flag =true;
								 }
								 else{
									 continue;
								 }
							}
							select_status		=	"";
							tot_qty_1		   +=	Double.parseDouble(issue_qty);
							rec_no				=    j;	
							if(called_from.equals("stock") && expiry_date!=null){
								expiry_date=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);
							}
							/*===========================================================variable uom============================================================*/
							int  disp_avail_qty  = 0;
							int  batch_alloc_qty = 0; 
							if(from_drug_dtl_flag){
								batch_alloc_qty = (int)Double.parseDouble(alloc_qty);
								//alloc_qty       = ( new Float(Math.ceil(((Float.parseFloat(alloc_qty)*base_to_disp_uom_equl)/base_to_def_uom_equl))).intValue())+"";
								if(base_to_disp_uom_equl!=base_to_def_uom_equl){
									alloc_qty       = ( new Float(Math.ceil(((Float.parseFloat(alloc_qty)*base_to_disp_uom_equl)/Actual_Equl_Value))).intValue())+"";
								}
							 }
							 else{
                                if(base_to_disp_uom_equl!=base_to_def_uom_equl){
									 batch_alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat(alloc_qty))/variable_conv_factor))*(variable_conv_factor))/base_to_disp_uom_equl)).intValue();
									//alloc_qty       = ( new Float(Math.ceil(((batch_alloc_qty*base_to_disp_uom_equl)/base_to_def_uom_equl))).intValue())+"";
									alloc_qty       = ( new Float(Math.ceil(((batch_alloc_qty*base_to_disp_uom_equl)/Actual_Equl_Value))).intValue())+"";
								}
								else{
									batch_alloc_qty =new Float(Float.parseFloat(alloc_qty)).intValue();
								}
							}
							disp_avail_qty = new Float(Math.ceil(Double.parseDouble(issue_qty)/base_to_disp_uom_equl)).intValue(); 
							issue_qty_dtl   =  new StringBuffer();
							if(IssueByUOM.equals("I")){ 
								issue_qty_dtl   =  issue_qty_dtl.append("(").append(alloc_qty).append(" ").append(issue_uom_desc).append(")");
							}
							int noOfDecimals=dir_bean.getNoOfDecimals();
							/*=====================================================variable uom ends here========================================================*/

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(manufacturer_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bin_location));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dir_bean.retunFormatedInt(issue_qty,noOfDecimals)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(batch_alloc_qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dir_bean.getUomDisplay(facility_id,uom_code)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(item_drug_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bin_locn_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(disp_avail_qty));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(batch_alloc_qty));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(issue_qty));
            _bw.write(_wl_block74Bytes, _wl_block74);

						}
					}

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tot_qty));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(base_to_orig_def_uom_equl_val));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(IssueByUOM));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(base_uom));
            _bw.write(_wl_block83Bytes, _wl_block83);

					if(tot_qty_1==0 ){
						if( physical_inv_item_yn.equals("N")){
							if(!variable_flag){

            _bw.write(_wl_block84Bytes, _wl_block84);

							}
							else{

            _bw.write(_wl_block85Bytes, _wl_block85);

							}    
						}
						else{

            _bw.write(_wl_block86Bytes, _wl_block86);

						}

            _bw.write(_wl_block87Bytes, _wl_block87);

					}

            _bw.write(_wl_block88Bytes, _wl_block88);
	
				putObjectInBean(dir_bean_id,dir_bean,request);
				putObjectInBean(bean_id_2,bean_2,request); 
				putObjectInBean(bean_id_3,bean_3,request);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

            _bw.write(_wl_block89Bytes, _wl_block89);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ISSUEUOM.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
