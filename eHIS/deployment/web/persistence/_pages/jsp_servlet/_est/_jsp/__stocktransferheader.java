package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.StockTransferBean;
import eCommon.Common.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __stocktransferheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StockTransferHeader.jsp", 1709122223915L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StDuoHeader.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n<body>\n<form name=\"formStockTransferHeader\" id=\"formStockTransferHeader\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n        ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="   \n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<input type=\"hidden\"\tname=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\"hidden\"\tname=\"bean_name\" id=\"bean_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\"hidden\"\tname=\"mode\" id=\"mode\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t<input type=\"hidden\"\tname=\"records_to_delete\" id=\"records_to_delete\"\tvalue=\"\" >\n\t<input type=\"hidden\"\tname=\"finalize_allowed_yn\" id=\"finalize_allowed_yn\"\tvalue=\"N\">\n\t<input type=\"hidden\"\tname=\"item_class_code1\" id=\"item_class_code1\"\t\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\"hidden\"\tname=\"trn_type\" id=\"trn_type\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\"\tname=\"tfr_delete_yn\" id=\"tfr_delete_yn\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\n\n\t<input type=\"hidden\"    name=\"barcode_applicable1\" id=\"barcode_applicable1\"\t\t\tvalue=\"\" >\n\t<input type=\"hidden\"    name=\"defaultqty_appl1\" id=\"defaultqty_appl1\"\t\t\t\tvalue=\"\" >\n\t<input type=\"hidden\"\tname=\"defaultqty_value1\" id=\"defaultqty_value1\"\t\t\tvalue=\"\">\n\t<input type=\"hidden\"    name=\"editqty_appl1\" id=\"editqty_appl1\"\t\t\t\tvalue=\"\" >\n\t<input type=\"hidden\"    name=\"chargeable_yn\" id=\"chargeable_yn\"\t\t\t\tvalue=\"\" ><!--dummy-->\n</form>\n\n\n<script>\ncallBarCodeApplicable(\'TFR\',\'formStockTransferHeader\',\'stockTransferBean\',\'eST.StockTranferBean\');\nparent.frameStockTransferDetail.document.location.href=\"../../eST/jsp/StockTransferDetail.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\nparent.frameStockTransferList.document.location.href=\"../../eST/jsp/StockTransferListFrame.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\t\n</script>\n</body>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );
	
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
		String locale				=		(String)session.getAttribute("LOCALE");
		
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String mode							=		request.getParameter("mode");
	//String	item_class_desc				=		(request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
	String	item_class_code				=		(request.getParameter( "item_class_code" )!=null ? (request.getParameter("item_class_code").trim()):"" );
	String trn_type						=		"TFR";
	String bean_id						=		"stockTransferBean";
	String bean_name					=		"eST.StockTranferBean";
	String sql_from_store				=		"SQL_ST_STOCK_TFR_FROM_STORE";
	String sql_to_store					=		"SQL_ST_STOCK_TO_STORE";
//	String item_class_code				=		"SQL_ST_ITEM_CLASS_SELECT_LIST";
	String Modal_Window_Open			=		"Yes";

	String param = request.getQueryString();
	
	eST.StockTransferBean bean			=		(eST.StockTransferBean) getBeanObject( bean_id ,  bean_name , request);
	bean.setLanguageId(locale); 
	boolean site_alna = bean.getStockTransferSite();  //Added for NMC-JD-CRF-0174 
	
	/*eST.Common.StTransaction st_bean = (eST.Common.StTransaction)getBeanObject( "stTransaction","eST.Common.StTransaction", request  );
	st_bean.setLanguageId(locale);
	st_bean.clear();
	st_bean.initialize();*/


	//System.out.println("BARCODE_YN==t=>=="+ st_bean.getDtlRecordsforBarCode());
	//System.out.println("BARCODE_YN==t=>=="+ st_bean.getExpRecordsforBarCode());



	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		Modal_Window_Open				=		"No";
		 bean.setItem_class_code(item_class_code);
		 
	}
	
	String tfr_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  tfr_delete_yn  from  ST_USER_ACCESS_FOR_STORE where user_id=? and store_code=? ",new String[]{(String)session.getValue( "login_user"),bean.checkForNull(bean.getFrom_store_code())}).get("TFR_DELETE_YN"),"N");


            _bw.write(_wl_block1Bytes, _wl_block1);
            {java.lang.String __page ="../../eST/jsp/StDuoHeader.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("mode"), weblogic.utils.StringUtils.valueOf(mode
                        )},{ weblogic.utils.StringUtils.valueOf("doc_type_code"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getDoc_type_code())
                        )},{ weblogic.utils.StringUtils.valueOf("doc_no"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getDoc_no())
                        )},{ weblogic.utils.StringUtils.valueOf("doc_date"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getDoc_date())
                        )},{ weblogic.utils.StringUtils.valueOf("doc_ref"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getDoc_ref())
                        )},{ weblogic.utils.StringUtils.valueOf("from_store_code"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getFrom_store_code())
                        )},{ weblogic.utils.StringUtils.valueOf("to_store_code"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getTo_store_code())
                        )},{ weblogic.utils.StringUtils.valueOf("item_class_code"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getItem_class_code())
                        )},{ weblogic.utils.StringUtils.valueOf("trn_type"), weblogic.utils.StringUtils.valueOf(trn_type
                        )},{ weblogic.utils.StringUtils.valueOf("sql_from_store"), weblogic.utils.StringUtils.valueOf(sql_from_store
                        )},{ weblogic.utils.StringUtils.valueOf("sql_to_store"), weblogic.utils.StringUtils.valueOf(sql_to_store
                        )},{ weblogic.utils.StringUtils.valueOf("Modal_Window_Open"), weblogic.utils.StringUtils.valueOf(Modal_Window_Open
                        )},{ weblogic.utils.StringUtils.valueOf("site_alna"), weblogic.utils.StringUtils.valueOf(site_alna
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(item_class_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(trn_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tfr_delete_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(param));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(param));
            _bw.write(_wl_block21Bytes, _wl_block21);
  putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
