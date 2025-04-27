package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.SalesReturnBean;
import eST.SalesReturnBatchSearchBean;
import java.util.ArrayList;
import java.util.HashMap;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __salesreturnlistdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SalesReturnListDetail.jsp", 1709122176478L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/SalesReturn.js\"></script>\n\t</head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body  ><!--   onload=\"loadBatchCharges();\" Commented against GHL-CRF-0.413.5-->\n\t\t<form name=\'formSalesReturnListDetail\' id=\'formSalesReturnListDetail\'>\n\t\t\t<table border=\'1\' width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' align=\"center\">\n \t\t\t<tr>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n       \t\t    <th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t</tr>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" nowrap  name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  title=\"Sales: ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" nowrap  name=\"batch_id_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"batch_id_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" nowrap  name=\"trade_id_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"trade_id_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" nowrap style=\"TEXT-ALIGN:right\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" nowrap >\n\t\t\t\t\t\t<select class=\"STSMALL\" name=\"bin_location_code_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"bin_location_code_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" value=? >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" nowrap >\n\t\t\t\t\t<input type=\'text\'  name=\"item_qty_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"item_qty_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"  id=\"id_item_qty_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"   class=\"NUMBER\" size=12 maxlength=12 onkeypress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =");\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"  \n\t\t\t\t\tonBlur=\"checkBatchQty(this,available_qty_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =".value);viewBatchCharges(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="); TotalBatchCharges();\" ></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" nowrap ><input type=\'text\'  name=\"item_qty_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"  id=\"item_qty_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"  size=12 maxlength=12 class=\"NUMBER\" \n\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" onkeypress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =");\"  \n\t\t\t\t\tonBlur=\"checkBatchQty(this,available_qty_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t<input type=\"hidden\" name=\"trade_id_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"batch_id_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"barcode_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"barcode_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" nowrap ><input type=\"hidden\"  name=\"trade_id1_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"trade_id1_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"  value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"></td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" nowrap ><input type=\"hidden\"  name=\"gross_charge_amt_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"gross_charge_amt_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"  value=\"\"></td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" nowrap ><input type=\"hidden\"  name=\"net_charge_amt_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"net_charge_amt_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"  value=\"\"></td>\n\t\t\t\t\n\n\t\t\t\t\t<input type=\"hidden\" name=\"available_qty_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"available_qty_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t<input type=\"hidden\"   name=\"doc_srl_no_forbean\" id=\"doc_srl_no_forbean\"  value =\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t<input type=\"hidden\" name=\"total_checkboxes\" id=\"total_checkboxes\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\"hidden\"\t\tname=\"dec_allowed_yn\" id=\"dec_allowed_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t<input type=\"hidden\"\t\tname=\"no_of_decimals\" id=\"no_of_decimals\"\t\t\t value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t</table>\n\t\t</form>\n\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t<script language=\"JavaScript\">\n\tloadBatchCharges();//Added against GHL-CRF-0413.5\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\t\t\t\n\t\tparent.frameSalesReturnListHeader.addToList();\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\tparent.frameSalesReturnListHeader.callItemQtyUpdate();\n\t\tTotalBatchChargesBarcode();\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );
	
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
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
			java.util.Properties prop	=		(java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		=		prop.getProperty( "client_ip_address" );
			String bean_id				=		"salesReturnBean"+login_at_ws_no;
			String bean_name			=		"eST.SalesReturnBean";


		SalesReturnBean bean = (SalesReturnBean)getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		int i	=0;
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		String patient_id=bean.checkForNull(request.getParameter("patient_id"));
		String encounter_id=bean.checkForNull(request.getParameter("encounter_id"));
		String sal_trn_type=bean.checkForNull(request.getParameter("sal_trn_type"));
		
		String function = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));

		//String store_code = bean.checkForNull(request.getParameter("store_code"));
		String store_code = bean.checkForNull(bean.getStore_code());
   
		String item_qty = bean.checkForNull(request.getParameter("item_qty"));
		
		String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
		
		String addToList = request.getParameter("addToList");
        String mode = bean.checkForNull(bean.getMode());

		ArrayList alBatchRecords = null;
		HashMap hmBatchRecord = null;
	
		String className	=	"";
		//String dec_allowed_yn = bean.getAllowDecimalsYN(item_code);
		String dec_allowed_yn = "";
	//	String date_legend="Expiry Dt";
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
		int no_of_decimals					=			bean.getNoOfDecimals();
		String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
		//Added for GHL-CRF-0413.5 starts
		ArrayList barcodeExp = new ArrayList();
	        ArrayList itemCodeExp = new ArrayList();
		int doc_srl_no_forbean =0;
		String qtyList = "";
		String p[]=null;
		int tmp = 0;
		String	BARCODE_YN      = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
 		String defaultqty_appl  = request.getParameter("defaultqty_appl")==null?"N":request.getParameter("defaultqty_appl");
		String editqty_appl1    =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
		String Qty_disabled = "";
		String barcode_appl                 =  bean.checkForNull(bean.getBarcodeApplicable(),"N");
		String BarcodeWithMultipleBatches	=		bean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"),"N");
		boolean site=bean.isSite_spec_yn();
		String batchsearch					=		bean.checkForNull(request.getParameter("batchsearch"));
 		//Added for GHL-CRF-0413.5 ends
		try { 
			if(function.equals("modify"))	{

				//HashMap hmDetailRecord	=	(HashMap)bean.getDtlRecord(Integer.parseInt(index)); 
				alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index));
				//bean.setExpRecords( Integer.parseInt(index), alBatchRecords);//Added by suresh.r on 13-10-2014 against Inc 2919
				if(site){
	  				//Added against GHL-CRF-0413.5 starts
	  				doc_srl_no_forbean = (Integer.parseInt(index));
	  				ArrayList setTmpList = new ArrayList(alBatchRecords);
	  				bean.setTempBatchRecords(setTmpList);
					//Added against GHL-CRF-0413.5 ends
				}else
	  				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
			
			}
			else if(function.equals("edit"))	{

				HashMap hmParameters	=	new HashMap();

				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("PATIENT_ID",patient_id);
				hmParameters.put("ENCOUNTER_ID",encounter_id);
				hmParameters.put("TRN_QTY",item_qty);
				hmParameters.put("STORE_CODE",store_code);
                hmParameters.put("SAL_TRN_TYPE",sal_trn_type);
      			HashMap hmReturn	=	bean.getSalesReturnBatches(hmParameters);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
				bean.setExpRecords( Integer.parseInt(index), alBatchRecords);//Added by suresh.r on 13-10-2014 against Inc 2919
			}
			//Added against GHL-CRF-0413.5 starts
			else if (function.equals("additionalBatch")){ 
			try
			{
				String barcode = bean.checkForNull(request.getParameter("barcode"));
				String list_store_code = bean.checkForNull(request.getParameter("store_code"));
				qtyList = bean.checkForNull(request.getParameter("qtyList"));
				p=qtyList.split(",");
				ArrayList oldBatchExpList = new ArrayList();
				ArrayList tmpList  = new ArrayList();
				if(bean.getTempBatchRecords().size()>0 ){
					oldBatchExpList = bean.getTempBatchRecords();//old records in current trnsaction
   				}
   				HashMap newBatchId = null;
   				ArrayList alExp = new ArrayList();
   				  newBatchId=	(HashMap)bean.fetchRecord("select batch_id,TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, BIN_LOCATION_CODE  from st_sal_dtl_exp where FACILITY_ID=? and DOC_TYPE_CODE=? and doc_no = ? and STORE_CODE =? and BARCODE_ID = ?",new String[]{bean.getLoginFacilityId(),bean.getSalesDocTypeCode(),bean.getSalesDocNo(),list_store_code,barcode});
   				ArrayList alExp1 = new ArrayList();
   				alExp1 = bean.getAlTempExpRecords();
   				for(int c=0;c<alExp1.size();c++)
				{
				   HashMap hmExp1 = new HashMap();
				   hmExp1 = (HashMap)alExp1.get(c);
				   if((hmExp1.containsValue(newBatchId.get("BATCH_ID"))) && (hmExp1.containsValue(newBatchId.get("EXPIRY_DATE_OR_RECEIPT_DATE")))&& (hmExp1.containsValue(newBatchId.get("BIN_LOCATION_CODE"))))
					{
					tmpList.add(hmExp1);
					}
   				}
   				bean.getAlTempExpRecords().clear();
   				for(int binlocn=0; binlocn < tmpList.size() ; binlocn++) {
				HashMap hmBatchRecord1 = (HashMap)tmpList.get(binlocn);
				hmBatchRecord1.put("RET_ITEM_QTY",	"0");
				hmBatchRecord1.put("BARCODE_ID",	barcode);
				}
   				ArrayList tempBatchRecordsList = new ArrayList();
   				tempBatchRecordsList = null;
				if(oldBatchExpList.size()>0)
				{
					tempBatchRecordsList=oldBatchExpList;
					if(tmpList.size()>0)
					tempBatchRecordsList.addAll(tmpList);
				 }
				 else
					 if(tmpList.size()>0)
					 tempBatchRecordsList = tmpList;
					 if(tmpList.size()>0){
					  ArrayList setTmpList = new ArrayList(tempBatchRecordsList);
				   	  bean.setTempBatchRecords(setTmpList);  //curr trans all batches
				 }
				 ArrayList OldExpRecords = new ArrayList();
				 HashMap CurrBatchRecords = new HashMap();
				 doc_srl_no_forbean = bean.getDtlRecords().size();
				 ArrayList alTmpList = new ArrayList();
				 if(bean.getDtlRecords().size()>0 ){
					 for(int m1=0; m1 < bean.getDtlRecords().size() ; m1++){ ///get the index for the itemcode
						HashMap hmTmp=(HashMap) bean.getDtlRecords().get(m1);
						if( hmTmp.containsValue(item_code)){
							 tmp = m1;
					 		 doc_srl_no_forbean = tmp;	
						}
					}
				 }
				if(alBatchRecords==null)
					alBatchRecords = bean.getTempBatchRecords();
				else
					alBatchRecords.addAll(bean.getTempBatchRecords());//curr trans all batches  
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in SalesReturnListDetail.jsp ...function=additionalBatch..");
					throw ex;
				}
			 }//Added against GHL-CRF-0413.5 ends
			else
			{
				SalesReturnBatchSearchBean bean2 = (SalesReturnBatchSearchBean)getBeanObject("SalesReturnBatchSearchBean",  "eST.SalesReturnBatchSearchBean", request);
				bean2.setLanguageId(locale);
				alBatchRecords = bean2.getSelectedList();

                if (alBatchRecords==null) {
					throw new Exception("No batch selected..");
				}
				/*
				else
				{
						for(i=0;i<alBatchRecords.size();i++){
							hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
							hmBatchRecord.put("TO_BIN_LOCATION_CODE",defaultBinLocationCode);
						}
                } */				

				putObjectInBean("salesReturnBatchSearchBean",bean2,request);//Comment removed by suresh.r on 13-10-2014 against Inc 2919
				//Added for GHL-CRF-0413.5 starts
				if(site){
				doc_srl_no_forbean = Integer.parseInt(index);
				if(doc_srl_no_forbean== -1 && bean.getDtlRecords().size()>0){
					for(int h =0; h< bean.getDtlRecords().size();h++){
						HashMap hmDtl = new HashMap();
						hmDtl = bean.getDtlRecord(h);
						if(hmDtl.containsValue(item_code))
							doc_srl_no_forbean = h;
					}
				}
				bean.getTempBatchRecords().clear();
				ArrayList albaArrayList = alBatchRecords;
				bean.setTempBatchRecords(albaArrayList);
				}else
					bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
			}
			//Added for GHL-CRF-0413.5 ends

			if(expiry_yn.equals("N")) {
	//			date_legend="Receipt Dt";
				date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			}

			//bean.setExpRecords( Integer.parseInt(index), alBatchRecords);//Commented by suresh.r on 13-10-2014 against Inc 2919

	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(date_legend));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

				String batch_qty="";
				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
				//Added for GHL-CRF-0413.5 starts
				barcodeExp.add(bean.checkForNull((String)hmBatchRecord.get("BARCODE_ID"), ""));
				bean.setAlBarcodeExp(barcodeExp);
				itemCodeExp.add((String)hmBatchRecord.get("ITEM_CODE"));
				bean.setAlItemcodeExp(itemCodeExp);
				//Added for GHL-CRF-0413.5 ends
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
			/**
			 * @Name - Priya
			 * @Date - 19/05/2010
			 * @Inc# - 
			 * @Desc -  as item code was coming null in the request 'dec_allowed_yn' is derived based on the ITEM_CODE from the hmBatchRecord  
			 */
				if(i==0){
						dec_allowed_yn = bean.getAllowDecimalsYN((String)hmBatchRecord.get("ITEM_CODE"));
				}

			if(dec_allowed_yn.equals("N")){
				batch_qty=bean.setNumber((String)hmBatchRecord.get("QTY"),0);
			}else{
				batch_qty=bean.setNumber((String)hmBatchRecord.get("QTY"),no_of_decimals);
			}
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(className));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)hmBatchRecord.get("SAL_DOC_NO")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)hmBatchRecord.get("SAL_DOC_TYPE_CODE")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_RECEIPT_DT"),"DMY","en",locale)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(className));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(hmBatchRecord.get("BATCH_ID")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(className));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(hmBatchRecord.get("TRADE_NAME")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(className));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(hmBatchRecord.get("AVAIL_QTY")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(className));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(( (mode.equals("1") || mode.equals("2")  )&& index.equals("-1") )?(bean.getBinLocationList(store_code,(String)hmBatchRecord.get("BIN_LOCATION_CODE"))):(bean.getBinLocationList(store_code,(String)hmBatchRecord.get("NEW_BIN_LOCATION_CODE"))) ));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(function.equals("additionalBatch") ){//Added for GHL-CRF-0413.5 starts
					
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(className));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(p[i]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{ //Added for GHL-CRF-0413.5 ends
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(className));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((function.equals("edit")||function.equals("modify"))?batch_qty:""));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
} 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(hmBatchRecord.get("TRADE_ID")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(hmBatchRecord.get("BATCH_ID")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(hmBatchRecord.get("EXPIRY_RECEIPT_DT")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(hmBatchRecord.get("BARCODE_ID")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(className));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(hmBatchRecord.get("TRADE_ID")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(className));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(className));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(hmBatchRecord.get("AVAIL_QTY")));
            _bw.write(_wl_block61Bytes, _wl_block61);
	}
				
			
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(doc_srl_no_forbean ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dec_allowed_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block66Bytes, _wl_block66);

putObjectInBean(bean_id,bean,request);


            _bw.write(_wl_block67Bytes, _wl_block67);

	if (addToList!=null){

            _bw.write(_wl_block68Bytes, _wl_block68);

		}
	else if (function.equals("additionalBatch")){//Added additionalBatch for GHL-CRF-0413.5 starts
		if (defaultqty_appl.equals("Y")){
		
            _bw.write(_wl_block69Bytes, _wl_block69);
	}
		}//Added additionalBatch for GHL-CRF-0413.5 ends

            _bw.write(_wl_block70Bytes, _wl_block70);

		}
		catch (eST.Common.InsufficientBatchException insufficientBatchException) {
			out.println("Insufficient Quantity.");
			out.println(insufficientBatchException);
			insufficientBatchException.printStackTrace();
		}
		catch (Exception exception) {
			out.println(exception.getMessage());
			exception.printStackTrace();
			
		}
				

            _bw.write(_wl_block71Bytes, _wl_block71);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ToBinLocation.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.RetQty.label", java.lang.String .class,"key"));
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
}
