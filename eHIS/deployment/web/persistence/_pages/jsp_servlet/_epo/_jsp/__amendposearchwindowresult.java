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

public final class __amendposearchwindowresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/AmendPOSearchWindowResult.jsp", 1709121583216L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/AmendPurchaseOrder.js\"></script>\n    \t<script language=\'javascript\' src=\'../../ePO/js/PoTransaction.js\'></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<base target=_self>\n</head>\n<body>\n\t<form name= \"formAmendPOSearchWindowResult\">\n\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center>\n\t\t\t<tr>\n\t\t\t\t<th align=\'center\' > Purchase Request Details </th>\t\t\n\t\t\t</tr>\n\t\t</table>\n\t\n\t\t<input type=\"hidden\" name=\"finalstring\" id=\"finalstring\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t<input type=\"hidden\" name=\"selected_doc_no\" id=\"selected_doc_no\" value=\"\">\n\t\t<input type=\"hidden\" name=\"sel_doc_batch_count\" id=\"sel_doc_batch_count\" value=\"\">\n\t\t<input type=\"hidden\" name=\"prev_ind\" id=\"prev_ind\" value=\"\">\n\t\t<input type=\"hidden\" name=\"total\" id=\"total\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n        <table  border = \'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center>\n\t\t\t<tr>\n\t\t\t\t<td align=\'left\' class=\"label\">\n\t\t\t\t\t<input type=\"checkbox\" name=\"doc_no_check_";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" id=\"doc_no_check_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"  onClick=\"enable_doc(this, ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =");\"  >\n\t\t\t\t\t<label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" &nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></label> \n\t\t\t\t</td>\n\t\t\t\t<td align=\'left\' class=\"label\">Request By Facility\n\t\t\t\t\t<label style=\"font-family:verdana;font-size:10\">&nbsp;&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </b></label>\n\t\t\t\t</td>\n\t\t\t\t<td align=\'left\' class=\"label\">Request By Store\n\t\t\t\t\t<label style=\"font-family:verdana;font-size:10\">&nbsp;&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </b></label>\n\t\t\t\t</td>\t\t    \t\n\t\t\t\t<td class=\"label\" width=\'5%\'> \n\t\t\t\t\t<input align=\"right\" type=button name=\"Add\" id=\"Add\"   value=\'  Add  \'  onclick=\"onadd();\"  >\t        \n\t\t\t\t</td>\t\n\t\t\t\t\t<input type=\"hidden\" name=\'batchcount_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'batchcount_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t</tr>\n\t\t</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n                <th>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t        <th>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t\t<th>Stock UOM</th>\n\t\t\t\t<th colspan= \"2\">Req Qty</th>\n\t\t\t\t<th>Required By Date</th>\n\t\t\t\t<th>Pending Qty</th>\n\t\t\t\t<th>Order Qty</th>\n\t\t\t\t<th>Order UOM</th>\n\t\t\t</tr>\n\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t  \n\t\t\t<tr>\t      \n                                                                                     \n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  style=\"font-family:verdana;font-size:10;text-align:right;\"  width=\'6%\'>&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"checkbox\"  id=\"doc_no_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" name=\"doc_no_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"  value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onClick=\'getItemQty(this,";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =");\'> \n\t\t\t\t</td>\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"   width=\'30%\' >\n\t\t\t\t\t<label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</label>&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"  width=\'10%\'>\n\t\t\t\t\t<label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </label> <input type=\"hidden\" name=\'stock_uom_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'stock_uom_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t</td>\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</label>\n\t\t\t\t\t<input type=\"hidden\"  name=\'req_qty_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'req_qty_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t\t</td>\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" </label> \n\t\t\t\t\t<input type=\"hidden\" name=\'req_uom_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'req_uom_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">   \n\t\t\t\t</td>\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"  width=\'15%\'>\n\t\t\t\t\t<label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</label>    \n\t\t\t\t\t<input type=\"hidden\" name=\'order_by_date_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'order_by_date_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</label>\n\t\t\t\t\t<input type=\"hidden\"  name=\'pending_qty_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'pending_qty_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"  width=\'10%\' align=\'right\'>\n\t\t\t\t\t<input type=\"text\"  id=\'order_qty_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' name=\'order_qty_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'  value=\"\" disabled>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" </label>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\'doc_type_code_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'doc_type_code_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\'item_code_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'item_code_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'     value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t\t<input type=\"hidden\" name=\'item_name_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'item_name_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\t\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\'store_code_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'store_code_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'    value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\'doc_srl_no_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'doc_srl_no_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t<input type=\"hidden\" name=\'facility_id_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'facility_id_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'   value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\'order_uom_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'order_uom_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\t\n\t\t\t\n\t\t\t</tr> \n\t\t   \n\t\t   \n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n\t\t</table>\t\n        \n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\n\n\t</form>\n\n</body>\n</html>\n    \n\n";
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
    
	 
	String bean_id              =			"";
    String bean_name            =			"";
	String req_store_code       =			"";
	String from_doc_date        =			"";
	String to_doc_date          =			"";
	String item_code            =			"";
	String item_desc            =			"";
	String req_no     			=			"";
	String facility_id 			= 			"";
	bean_id                     = 			"amendPurchaseOrderBean" ;
	bean_name                   = 			"ePO.AmendPurchaseOrderBean";
	
	String po_purchase_unit = request.getParameter("po_purchase_unit");
	System.out.println("po_purchase_unit = "+po_purchase_unit);
	
	AmendPurchaseOrderBean bean 		= 			(AmendPurchaseOrderBean) getBeanObject( bean_id, bean_name,request );
	facility_id         		=   		CommonBean.checkForNull(request.getParameter( "facility_id"),"%");
	req_store_code       		=  			CommonBean.checkForNull(request.getParameter( "req_store_code"   ),"%");
	item_desc            		=  			CommonBean.checkForNull(request.getParameter("item_desc"),"");
	item_code            		=  			request.getParameter("item_desc").equals("")? "%": request.getParameter("item_code");
	from_doc_date        		=  			CommonBean.checkForNull(request.getParameter("from_doc_date"),"");
	to_doc_date          		=  			CommonBean.checkForNull(request.getParameter("to_doc_date"),"");	
	req_no             			=  			CommonBean.checkForNull(request.getParameter("req_no"),"%");
	String []stParameters 		= 			{from_doc_date,to_doc_date,req_no,facility_id,req_store_code};

	String sql = "SELECT  DISTINCT  hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code  FROM po_request_header hdr, po_request_detail dtl  WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  hdr.req_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),   'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) and hdr.req_no LIKE  ? and hdr.facility_id LIKE ? and hdr.req_store_code LIKE ?  and hdr.REQ_STATUS = 'FA' and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0 ";
	
	System.out.println("sql==>"+sql);
	
	ArrayList alTemp = new ArrayList();
	alTemp =  bean.fetchRecords(sql,stParameters);
	 
	System.out.println("alTemp==>"+alTemp);

	int total = alTemp.size();	
	if(total ==0){

            _bw.write(_wl_block8Bytes, _wl_block8);
		
	}
	
	String global_unit_yn =		bean.checkForNull((String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PO_GLOBAL_YN"),po_purchase_unit).get("GLOBAL_UNIT_YN"));
	System.out.println("global_unit_yn = "+global_unit_yn);
	
	HashMap hmExpData = new HashMap();
	
	for(int i=0;i<total;){		
		HashMap hm = (HashMap)alTemp.get(i);
		//String []stParameters1 = {locale,(String)hm.get("REQ_NO"),(String)hm.get("FACILITY_ID"),(String)hm.get("REQ_STORE_CODE"),item_code };

		ArrayList alParameters = new ArrayList();
		if(global_unit_yn.equals("Y")){
			alParameters.add(locale);
			alParameters.add((String)hm.get("REQ_NO"));
			alParameters.add((String)hm.get("FACILITY_ID"));
			alParameters.add((String)hm.get("REQ_STORE_CODE"));
			alParameters.add(item_code);
		}else if(global_unit_yn.equals("N")){
			alParameters.add(locale);
			alParameters.add((String)hm.get("REQ_NO"));
			alParameters.add(bean.getLoginFacilityId());
			alParameters.add((String)hm.get("REQ_STORE_CODE"));
			alParameters.add(item_code);
		}		
		
	//	ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty ,dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND hdr.req_no = ? AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0  ORDER BY hdr.facility_id, hdr.req_code, hdr.req_no, dtl.REQ_SRL_NO",alParameters);
		
		ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT hdr.facility_id, hdr.req_store_code, hdr.req_no, hdr.req_code,dtl.item_code,mm.short_desc item_name,dtl.req_qty , (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) pending_qty , dtl.REQ_UOM,AM.SHORT_DESC REQ_UOM_DESC,TO_CHAR (hdr.REQ_DATE,'dd/mm/yyyy') req_date,dtl.REQ_SRL_NO ,ST.DEF_ISSUE_UOM st_uom , AM1.SHORT_DESC ST_UOM_DESC FROM po_request_header hdr, po_request_detail dtl,mm_item_lang_vw mm, ST_ITEM_STORE st,AM_UOM_LANG_VW am ,AM_UOM_LANG_VW am1 WHERE hdr.req_no = dtl.req_no AND hdr.facility_id = dtl.facility_id  AND  dtl.item_code = mm.item_code  and mm.language_id = ?  and DTL.ITEM_CODE = ST.ITEM_CODE and HDR.REQ_STORE_CODE = ST.STORE_CODE AND hdr.req_no = ? AND hdr.facility_id = ? AND hdr.req_store_code = ? AND dtl.item_code like upper(?)  and DTL.REQ_UOM=AM.UOM_CODE and AM.LANGUAGE_ID= mm.language_id and AM.LANGUAGE_ID=AM1.LANGUAGE_ID AND ST.DEF_ISSUE_UOM = AM1.UOM_CODE and (nvl(dtl.REQ_QTY,0)-nvl(dtl.PO_QTY,0)) > 0  ORDER BY hdr.facility_id, hdr.req_code, hdr.req_no, dtl.REQ_SRL_NO",alParameters);
	

        int alsize = alExpData.size();
		if ( alsize > 0 ){
		hmExpData.put((String)hm.get("REQ_NO"),alExpData);
		i++;
		}else{
        alTemp.remove(i);
		total--;
		}
	}	

	bean.setPoItemDetails(hmExpData);


 	String classValue			= "";
	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(total));
            _bw.write(_wl_block11Bytes, _wl_block11);
 
		String new_doc_no ="";
		for(int i=0;i<total;i++ ){  
	        HashMap hmTemp = new HashMap();
            hmTemp = (HashMap)alTemp.get(i);
			
		ArrayList alStoreList = 	new ArrayList();
		ArrayList alFacList = 	new ArrayList();
		ArrayList alReqList = 	new ArrayList();
		String req_store = "";
		String facility_code = "";
		String req_code = "";
		
		req_store =	bean.checkForNull((String)hmTemp.get("REQ_STORE_CODE"));
		alStoreList.add(req_store);
		alStoreList.add(bean.getLanguageId());
		req_store = 	(String)bean.fetchRecord("SELECT STORE_CODE,long_desc short_desc FROM MM_STORE_LANG_VW	WHERE STORE_CODE=? AND LANGUAGE_ID=?",alStoreList).get("SHORT_DESC");
	 
		facility_code =	bean.checkForNull((String)hmTemp.get("FACILITY_ID"));
		alFacList.add(bean.getLanguageId());
		alFacList.add(facility_code);
		facility_code = 	(String)bean.fetchRecord("SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW  WHERE LANGUAGE_ID=?  AND FACILITY_ID=?",alFacList).get("FACILITY_NAME");
		
		req_code =	bean.checkForNull((String)hmTemp.get("REQ_CODE"));
		alReqList.add(bean.getLanguageId());
		alReqList.add(req_code);
		alReqList.add("POREQN");
		req_code = 	(String)bean.fetchRecord("SELECT MASTER_TYPE,MASTER_CODE,LONG_DESC SHORT_DESC  FROM PO_MASTER_CODE_LANG_VW  WHERE LANGUAGE_ID=?  AND MASTER_CODE=? AND MASTER_TYPE=?",alReqList).get("SHORT_DESC");
			
			
			ArrayList alBatchDetails = (ArrayList)hmExpData.get((String)hmTemp.get("REQ_NO"));
			int batchcount = alBatchDetails.size();
			new_doc_no = bean.checkForNull((String)hmTemp.get("REQ_NO"));

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("REQ_NO"))));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(req_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facility_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(req_store));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

	for(int j=0;j<alBatchDetails.size();j++){

			 HashMap hmBatchDetails = (HashMap)alBatchDetails.get(j);
			 classValue	=	"QRYODD";	

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME"))));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ST_UOM_DESC"))));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ST_UOM_DESC"))));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_QTY"))));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_QTY"))));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_UOM_DESC"))));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_UOM_DESC"))));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_DATE"))));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_DATE"))));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("PENDING_QTY"))));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("PENDING_QTY"))));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_UOM_DESC"))));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_CODE"))));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(java.net.URLEncoder.encode(bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME")))));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_STORE_CODE"))));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_SRL_NO"))));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("FACILITY_ID"))));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_UOM"))));
            _bw.write(_wl_block72Bytes, _wl_block72);
 }
            _bw.write(_wl_block73Bytes, _wl_block73);
 } 
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
}
