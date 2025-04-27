package jsp_servlet._epo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePO.*;
import ePO.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __poitemdetailresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/POItemDetailResult.jsp", 1709121591341L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoMessages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/DeliveryOrder.js\"></script>\n    \t<script language=\'javascript\' src=\'../../ePO/js/PoTransaction.js\'></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<base target=_self>\n\t</head>\n<body>\n\t<form name= \"formPOItemDetailResult\">\n\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center>\n        <tr><th align=\'center\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th></tr>\n\t</table>\t\n\t\n\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\"hidden\" name=\"selected_doc_no\" id=\"selected_doc_no\" value=\"\">\n\t<input type=\"hidden\" name=\"sel_doc_batch_count\" id=\"sel_doc_batch_count\" value=\"\">\n\t<input type=\"hidden\" name=\"prev_ind\" id=\"prev_ind\" value=\"\">\n\t<input type=\"hidden\" name=\"total\" id=\"total\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"phy_inv_id\" id=\"phy_inv_id\" value=\"\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"qty_override_yn\" id=\"qty_override_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n        \n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\n\t<table  border = \'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center>\n\t\t\n\t\n\t\t<tr>\n\t\t<td align=\'left\' width=\'20%\'><input type=\"checkbox\" name=\"doc_no_check_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"doc_no_check_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"  onClick=\'enable_doc(this, \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\",\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\");\'  >\n\t\t<label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</b></label>&nbsp;</td>\n\n\t\t<td width=\'10%\'><label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;:</b></label></td>\n\t\t<td><label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</b></label></td>\n\t\t\n\t\t<td width=\'10%\'><label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b></label></td>\n\t\t\t\t\n\t\t<td class=\"label\" width=\'5%\'> \n\t\t\t\t<!--\t<input align=\"right\" type=button name=\"Add\" id=\"Add\"   value=\'  Add  \'  onclick=\"onadd();\"  >\t        -->\n\t\t\t\t</td>\t\n\t\t\t\t\t<input type=\"hidden\" name=\'batchcount_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'batchcount_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\n\t    </tr>\n\t</table>\n\t\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n                <th>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" <input type=\"checkbox\" name=\"doc_no_select_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"doc_no_select_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"  onClick=\'enable_all_doc(this, \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\");\'  disabled ></th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</th>\n\t\t        <th>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</th>\t\t\t\t\n\t\t\t\t<th>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</th>\t\t\t\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t <tr>\t                                                                         \n            <td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  style=\"font-family:verdana;font-size:10;text-align:right;\" width=\'5%\'><input type=\"checkbox\"  id=\'doc_no_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'   name=\'doc_no_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" onClick=\"\" disabled > </td>\n\t\t\t<td\tclass=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"  width=\'10%\'><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</label></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"  width=\'30%\' ><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</label>&nbsp;</td>\n\t\t\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"  width=\'10%\' style=\'text-align:right;\'><label  style=\"font-family:verdana;font-size:10;text-align:right;\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</label> &nbsp;</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</label> &nbsp;</td>\n\t\t\n\t\t\t<td\tclass=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</label></td>\n\t\t\t\n\t\t\t<td\tclass=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</label></td>\n\t\t\t\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\'item_code_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'item_code_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'       value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t<input type=\"hidden\" name=\'req_no_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'req_no_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'          value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t<input type=\"hidden\" name=\'delv_date_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'delv_date_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t<input type=\"hidden\" name=\'req_qty_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'req_qty_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' \t\t  value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t<input type=\"hidden\" name=\'po_qty_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'po_qty_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t<input type=\"hidden\" name=\'po_price_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'po_price_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t<input type=\"hidden\" name=\'pur_unit_code_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'pur_unit_code_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'   value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\t\n\t\t\t<input type=\"hidden\" name=\'local_currency_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'local_currency_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\t\n\t\t\t<input type=\"hidden\" name=\'trans_currency_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'trans_currency_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\t\n\t\t\t<input type=\"hidden\" name=\'conversion_rate_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\'conversion_rate_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\t\n\t\t\t<input type=\"hidden\" name=\'allow_deci_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'allow_deci_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' \t  value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\'item_remarks_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' id=\'item_remarks_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\'po_net_value_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' id=\'po_net_value_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\n\t</table>\n\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t<br>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=right>\n\t\t<td align=\"right\"><input align=\"right\" type=button name=\"Add\" id=\"Add\"   value=\'  Add to Delivery \'  onclick=\"onadd();\"  ></td>\n\t</table>  \n\t<input type=\"hidden\" name=\"tran_currency_temp\" id=\"tran_currency_temp\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t</form>\n\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );
	
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
		String locale		=	(String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
    

	String facility_id			=		(String) session.getValue( "facility_id" ) ;

	String bean_id              ="";
    String bean_name            ="";
	String store_code           ="";
	String from_doc_date        ="";
	String to_doc_date          ="";
	String item_code            ="";
	String po_number            ="";
	String supp_code			="";
	String pur_unit_code		="";
	String pur_unit_desc		="";
	String req_qty				="";		
	String req_uom				="";
	String classValue			="";
	String new_po_no			="";
	String st_uom_code			="";
	String st_uom_desc			="";
	String mode					="";
	String po_mode				= "";
	String tran_currency 		= "";
	String img_next_del_date		=	"hidden";
	

	bean_id                     = "deliveryOrderBean" ;
	bean_name                   = "ePO.DeliveryOrderBean";

    
	DeliveryOrderBean bean = (DeliveryOrderBean) getBeanObject( bean_id, bean_name,request );


	store_code           =  bean.checkForNull(request.getParameter("store_code"),"BANK");
	
	item_code            =  request.getParameter("item_desc").equals("")? "%": request.getParameter("item_code");
	from_doc_date        =  bean.checkForNull(request.getParameter("from_doc_date"),"");
	to_doc_date          =  bean.checkForNull(request.getParameter("to_doc_date"),"");	
	po_number            =  bean.checkForNull(request.getParameter("doc_no"),"%");
	supp_code            =  bean.checkForNull(request.getParameter("supp_code1"));
	pur_unit_code        =  bean.checkForNull(request.getParameter("purchase_unit"),"%");
	po_mode       		 =  bean.checkForNull(request.getParameter("po_mode"));
	mode				 =  bean.checkForNull(request.getParameter("mode"));
	tran_currency		 =	bean.checkForNull(request.getParameter("tran_currency"),"%");
	
	String tran_currency_temp								   =	   bean.checkForNull(request.getParameter("tran_currency_temp"));
	
	int no_deci                   =    bean.getNoOfDecimals();

	
	
	
	 
		
//	HashMap PO_Override			=	bean.fetchRecord(bean.getStRepositoryValue("SQL_PO_PARAMETER_OVERRIDE_ALLOW"));

//	String qty_override_yn		=	bean.checkForNull((String)PO_Override.get("ALLOW_QTY_OVERRIDE_IN_GRN"),"N");

//	String []stParameters = {store_code,facility_id,supp_code,from_doc_date,to_doc_date,po_number,pur_unit_code,item_code};
	String []stParameters = {facility_id,supp_code,from_doc_date,to_doc_date,po_number,pur_unit_code,item_code,po_mode,tran_currency};
	
	
	
//	String sql= "SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A') and HDR.SUPP_CODE = ? AND  HDR.PO_STATUS in ('FA','RA','PD')  AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO like ? and DTL.PUR_UNIT_CODE like ?  and dtl.item_code  like  ? and (NVL(DTL.PO_QTY,0)-NVL(DTL.GRN_QTY,0)) > 0  ORDER BY 2";

//	String sql= "SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO /* AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */ AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A') and HDR.SUPP_CODE = ? AND  HDR.PO_STATUS in ('FA','RA','PD')  AND EXPECTED_DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, '31/01/2999') ) AND DTL.PO_NO like ? and DTL.PUR_UNIT_CODE like ?  and dtl.item_code  like  ? and (NVL(DTL.PO_QTY,0)-NVL(DTL.GRN_QTY,0)) > 0  ORDER BY 2";
	
	String sql = "SELECT DISTINCT DTL.PO_NO , DTL.PUR_UNIT_CODE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE, HDR.PO_ORDER_MODE,HDR.TRANS_CURRENCY FROM po_order_hdr HDR ,po_order_fcy_dtl DTL, PO_ORDER_DELV_SCH delv WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A') and HDR.SUPP_CODE = ?   AND  HDR.PO_STATUS in ('FA','RA','PD','PR')  AND DELV.DELV_STATUS IN ('PD','ND','CD') AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) AND DTL.PO_NO like ? and DTL.PUR_UNIT_CODE like ?  and dtl.item_code  like  ?  AND HDR.PO_ORDER_MODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0  and HDR.TRANS_CURRENCY  like ? ORDER BY 2";
 
	ArrayList alTemp = new ArrayList();
	HashMap hmExpData = new HashMap();
	HashMap hmTemp = null;
	HashMap temp = null;

	alTemp =  bean.fetchRecords(sql,stParameters);
	
	int total = alTemp.size();	
/*	if(total ==0){
		
            _bw.write(_wl_block8Bytes, _wl_block8);
		
	}
*/	
	
	for(int j=0;j<total;){		

		HashMap hm = (HashMap)alTemp.get(j);
		
	
		
	//	String []stParameters1 = {locale,store_code,facility_id,from_doc_date,to_doc_date,(String)hm.get("PO_NO"),(String)hm.get("PUR_UNIT_CODE"),item_code};
		String []stParameters1 = {locale,locale,facility_id,from_doc_date,to_doc_date,(String)hm.get("PO_NO"),(String)hm.get("PUR_UNIT_CODE"),item_code,(String)hm.get("TRANS_CURRENCY")};

		String sql1 = "";

		if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){

		//	sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code  and (req_no=dtl.req_no or req_no = '*A') and (facility_id !='"+facility_id+"' or grn_doc_type_code!='"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"')))) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code and (req_no=dtl.req_no or req_no = '*A') and ( facility_id !='"+facility_id+"' or grn_doc_type_code!= '"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"'))) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? ) a  where a.item_qty_normal > 0 order by 2";
		
		//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, ((NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0)- NVL(delv.DO_BLOCKED_QTY,0)) ) delv_qty,delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 order by 2";

		//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-( NVL (delv.delivered_qty, 0) - nvl(DELVBAT.GRN_QTY,0)) - NVL(delv.DO_BLOCKED_QTY,0) - NVL (dtl.grn_qty, 0) )  delv_qty,delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS,(select SHORT_DESC from po_purchase_unit_lang_vw where PUR_UNIT_CODE=DTL.PUR_UNIT_CODE and language_id=?) PUR_UNIT_DESC  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,PO_DELV_ORD_DTL_BAT DELVBAT,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO AND DELVBAT.item_code (+)= DTL.item_code  AND DELVBAT.po_no(+) = DTL.po_no  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 AND a.delv_qty>0 order by 2";
		// Added condition SUM(NVL (DELVBAT.GRN_QTY, 0)) OVER(PARTITION BY DELVBAT.PO_NO,DELVBAT.ITEM_CODE) against INC#41091
		sql1 = "select * from (SELECT distinct DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-( NVL (delv.delivered_qty, 0) - SUM(NVL (DELVBAT.GRN_QTY, 0)) OVER(PARTITION BY DELVBAT.PO_NO,DELVBAT.ITEM_CODE) ) - NVL(delv.DO_BLOCKED_QTY,0) - NVL (dtl.grn_qty, 0) )  delv_qty,delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS,(select SHORT_DESC from po_purchase_unit_lang_vw where PUR_UNIT_CODE=DTL.PUR_UNIT_CODE and language_id=?) PUR_UNIT_DESC  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,PO_DELV_ORD_DTL_BAT DELVBAT,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO AND DELVBAT.item_code (+)= DTL.item_code  AND DELVBAT.po_no(+) = DTL.po_no  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 AND a.delv_qty>0 order by 2";
		
		}else{
				
		//	sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code ) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code )) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE  AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND EXPECTED_DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? ) a  where a.item_qty_normal > 0 order by 2"; 
			
		
			
			//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) - NVL(delv.DO_BLOCKED_QTY,0) )  delv_qty,delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND  TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 order by 2";

			//sql1 = "select * from (SELECT distinct DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-( NVL (delv.delivered_qty, 0) - nvl(DELVBAT.GRN_QTY,0)) - NVL(delv.DO_BLOCKED_QTY,0) - NVL (dtl.grn_qty, 0) )  delv_qty, delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS,(select SHORT_DESC from po_purchase_unit_lang_vw where PUR_UNIT_CODE=DTL.PUR_UNIT_CODE and language_id=?) PUR_UNIT_DESC  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,PO_DELV_ORD_DTL_BAT DELVBAT,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND  TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO  AND DELVBAT.item_code (+)= DTL.item_code  AND DELVBAT.po_no(+) = DTL.po_no  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 AND A.delv_qty>0 order by 2";

			// Added condition SUM(NVL (DELVBAT.GRN_QTY, 0)) OVER(PARTITION BY DELVBAT.PO_NO,DELVBAT.ITEM_CODE) against INC#41091
			sql1 = "select * from (SELECT distinct DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (delv.DELV_QTY, 0) - (NVL (delv.DELIVERED_QTY, 0) + NVL (delv.DO_BLOCKED_QTY, 0) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST, nvl(DTL.ITEM_NET_VALUE,0) ITEM_NET_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(delv.DELV_DATE,'dd/mm/yyyy') DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY, (NVL(delv.DELV_QTY,0)-( NVL (delv.delivered_qty, 0) - SUM(NVL (DELVBAT.GRN_QTY, 0)) OVER(PARTITION BY DELVBAT.PO_NO,DELVBAT.ITEM_CODE) ) - NVL(delv.DO_BLOCKED_QTY,0) - NVL (dtl.grn_qty, 0) )  delv_qty, delv.DELV_SRL_NO, DTL.PO_LINE_REMARKS,(select SHORT_DESC from po_purchase_unit_lang_vw where PUR_UNIT_CODE=DTL.PUR_UNIT_CODE and language_id=?) PUR_UNIT_DESC  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,PO_ORDER_DELV_SCH delv,PO_DELV_ORD_DTL_BAT DELVBAT,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE /*AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') */AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' )  AND DELV_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )   AND  TO_DATE (TO_CHAR (NVL (?, '01/01/2999' ) ), 'dd/mm/yyyy' ) and (NVL(delv.DELV_QTY,0)-NVL(delv.DELIVERED_QTY,0) ) > 0 AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ? AND delv.PO_NO = DTL.PO_NO AND delv.ITEM_CODE = DTL.ITEM_CODE AND delv.PO_SRL_NO = DTL.PO_SRL_NO  AND DELVBAT.item_code (+)= DTL.item_code  AND DELVBAT.po_no(+) = DTL.po_no  and dtl.item_code like  ? and HDR.TRANS_CURRENCY like  ? ) a  where a.item_qty_normal > 0 AND A.delv_qty>0 order by 2";
		}
		


		ArrayList alExpData =  (ArrayList)bean.fetchRecords(sql1,stParameters1);
		
        int alsize = alExpData.size();
		if ( alsize > 0 ){
		hmExpData.put((String)hm.get("PO_NO"),alExpData);
		j++;
		}
		else{
        alTemp.remove(j);
		total--;
		}
	}
	
	int total_hm = hmExpData.size();	
	if(total_hm == 0 || total == 0){
		
            _bw.write(_wl_block8Bytes, _wl_block8);
		
	}

		bean.setPoItemDetails(hmExpData);


	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(total));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()));
            _bw.write(_wl_block14Bytes, _wl_block14);

	for(int k=0;k<total;k++ ){  
	hmTemp = (HashMap)alTemp.get(k);
	
	 pur_unit_code =	bean.checkForNull((String)hmTemp.get("PUR_UNIT_CODE"));
	 pur_unit_desc = 	(String)bean.fetchRecord("SELECT pur_unit_code,long_desc short_desc FROM po_purchase_unit	WHERE pur_unit_code=?",pur_unit_code).get("SHORT_DESC");

	 ArrayList alBatchDetails = (ArrayList)hmExpData.get((String)hmTemp.get("PO_NO"));

	 new_po_no = bean.checkForNull((String)hmTemp.get("PO_NO"));
	 
	 int batchcount =	 alBatchDetails.size();
	
	 classValue	=	"QRYODD";
	 
	po_mode =  bean.checkForNull((String)hmTemp.get("PO_ORDER_MODE"));
	if(po_mode.equals("D"))
		po_mode = "Direct Order";
	else{
		po_mode = "Order Based On Request";
	}	
	
	String dflt_currency =	 bean.checkForNull((String)hmTemp.get("TRANS_CURRENCY"));
	String dflt_currency_desc = bean.checkForNull((String)bean.fetchRecord("SELECT currency_code, short_desc FROM sy_foreign_currency_lang_vw WHERE language_id = ? and currency_code = ? ORDER BY 2",new String[]{locale,dflt_currency}).get("SHORT_DESC"),"");

	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(k));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("PO_NO"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(k));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("PO_NO"))));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("PO_DATE"))));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pur_unit_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dflt_currency_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(k));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(k));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(k));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(k));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(k));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(k));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("PO_NO"))));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

		for(int i=0;i<alBatchDetails.size();i++){

		HashMap hmBatchDetails = (HashMap)alBatchDetails.get(i);
		
		
		
	/*	int delv_qty = 0 ;
		for(int j=i+1;j<alBatchDetails.size();j++){
			HashMap hmBatchDetails1 = (HashMap)alBatchDetails.get(j);
			
			if( (hmBatchDetails.get("ITEM_CODE").equals(hmBatchDetails1.get("ITEM_CODE"))) && (hmBatchDetails.get("DELV_DATE").equals(hmBatchDetails1.get("DELV_DATE")))){
			
			 delv_qty = Integer.parseInt((String)hmBatchDetails.get("DELV_QTY")) + Integer.parseInt((String)hmBatchDetails1.get("DELV_QTY"));
			
			 String s = new Integer(delv_qty).toString();
			 hmBatchDetails.put("DELV_QTY",s);
			 alBatchDetails.remove(j);
			}
		}
	*/	

		/*String[] qtyparam = {bean.checkForNull((String)hmBatchDetails.get("REQ_FACILITY_ID")),bean.checkForNull((String)hmBatchDetails.get("REQ_NO")),bean.checkForNull((String)hmBatchDetails.get("REQ_SRL_NO"))};
	 
		temp = bean.fetchRecord("SELECT REQ_QTY,REQ_UOM  FROM PO_REQUEST_DETAIL	WHERE FACILITY_ID=? and REQ_NO = ? and REQ_SRL_NO = ? " ,qtyparam);

		req_qty = bean.checkForNull((String)temp.get("REQ_QTY"));
		req_uom = bean.checkForNull((String)temp.get("REQ_UOM"));

		st_uom_code = bean.checkForNull((String)hmBatchDetails.get("DEF_ISSUE_UOM"));

			if(st_uom_code.equals("")){
			temp=null;

			String[] qtyparam1 = {(String)hmBatchDetails.get("ITEM_CODE"),store_code};
			temp = bean.fetchRecord("SELECT DEF_ISSUE_UOM  FROM ST_ITEM_STORE WHERE ITEM_CODE=? and STORE_CODE = ? " ,qtyparam1);

			st_uom_code = bean.checkForNull((String)temp.get("DEF_ISSUE_UOM"));
			}
		
			st_uom_desc = bean.checkForNull(bean.getUOMDesc(st_uom_code));
		*/	
			
			ArrayList alStoreList = new ArrayList();
			String st_code = bean.checkForNull((String)hmBatchDetails.get("REQ_STORE_CODE"));
			
			if(st_code.equals("*A"))
				st_code = "ALL";
			else {
			
				st_code =	bean.checkForNull((String)hmBatchDetails.get("REQ_STORE_CODE"));
				alStoreList.add(st_code);
				alStoreList.add(bean.getLanguageId());
				st_code = 	(String)bean.fetchRecord("SELECT STORE_CODE,long_desc short_desc FROM MM_STORE_LANG_VW	WHERE STORE_CODE=? AND LANGUAGE_ID=?",alStoreList).get("SHORT_DESC");
			}
			
			ArrayList alFacilityList = new ArrayList();
			String facility_code = bean.checkForNull((String)hmBatchDetails.get("REQ_FACILITY_ID"));
			
			if(facility_code.equals("*A"))
				facility_code = "ALL";
			else {
			
				facility_code =	bean.checkForNull((String)hmBatchDetails.get("REQ_FACILITY_ID"));
				alFacilityList.add(facility_code);
				alFacilityList.add(bean.getLanguageId());
				facility_code = 	(String)bean.fetchRecord("SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW  WHERE FACILITY_ID = ? and LANGUAGE_ID=?",alFacilityList).get("FACILITY_NAME");
			}
			
				
				
		
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("DELV_DATE"))));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_DESC"))));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("DELV_QTY"))));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("PUR_UOM_DESC"))));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(st_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(facility_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("DELV_DATE"))));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(req_qty));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_QTY_NORMAL"))));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_UNIT_COST"))));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(pur_unit_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("LOCAL_CURRENCY"))));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("TRANS_CURRENCY"))));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("CONVERSION_RATE"))));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ALLOW_DECIMALS_YN"),"N")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("PO_LINE_REMARKS"),"N")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_NET_VALUE"))));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
            _bw.write(_wl_block82Bytes, _wl_block82);

	}
	
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(tran_currency_temp));
            _bw.write(_wl_block84Bytes, _wl_block84);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PurchaseOrderDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.PODate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.PORaisedBy.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Currency.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.ScheduledDate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.itemDesc.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.RequestNo.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.pendingPoQty.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.POUOM.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Store.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Facility.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
