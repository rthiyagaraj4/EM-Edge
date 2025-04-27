package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryticksheets extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryTickSheets.jsp", 1739966008000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryRapidPreview.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"tickSheetForm\" id=\"tickSheetForm\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t     <td width=\'10%\'   class=\'label\' nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t <td width=\'20%\' class=\'fields\'>\n\t\t   \t <select name=\'order_category\' id=\'order_category\'  onChange=\"allowNewOrders(this,\'tickSheetForm\');\"><option value=\'\'>---- ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" -----\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</select>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<td width=\"10%\"  class=\"label\" nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td  width=\"20%\" class=\"fields\" nowrap>\n\t\t\t<input type=\'hidden\' name=\'order_type\' id=\'order_type\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"><input type=\'text\' width=\'16%\' name=\'order_type_desc\' id=\'order_type_desc\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" onBlur=\"populateordertypeSearch(order_type_desc,order_type,\'tickSheetForm\');clearactivityvalues(\'tickSheetForm\');storeValues(\'\',\'tickSheetItemsForm\');\" onChange=\"\" maxlength=\'\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="><input type=button name=\"ordertypesearch\" id=\"ordertypesearch\" value=\'?\'  class=button tabIndex=\"4\" onClick=\"callordertypeSearch(order_type_desc,order_type,\'tickSheetForm\');storeValues(\'\',\'tickSheetItemsForm\');\">\n\t\t   \t<!--  <select name=\"order_type\" id=\"order_type\" onChange=\"popSections(this);storeValues(\'\',\'tickSheetItemsForm\');populateActivityType(this, \'tickSheetForm\')\"><option value=\'\'> -->\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</select>\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" id=\"order_type_mand\" style=\"visibility:hidden\"></img>\n\t\t\t</td>\n\t\t\t\n\t\t </tr>\n\t\t <tr>\n\n\t\t   <td width=\"10%\" class=\"label\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td class=\"fields\" width=\"20%\" ><input type=\'hidden\' name=\'activity_type\' id=\'activity_type\' value=\"\"><input type=\'text\' width=\'16%\' name=\'activity_type_desc\' id=\'activity_type_desc\' value=\"\" onBlur=\"populateActivitySearch(activity_type_desc,activity_type,\'tickSheetForm\');storeValues(\'\',\'tickSheetItemsForm\');\"  maxlength=\'\' ><input type=button name=search value=\'?\'  class=button tabIndex=\"4\" onClick=\"callActivitySearch(activity_type_desc,activity_type,\'tickSheetForm\');storeValues(\'\',\'tickSheetItemsForm\');\">\n\n\t\t\t<!-- <select name=\"activity_type\" id=\"activity_type\" onChange=\"popSections(this);storeValues(\'\',\'tickSheetItemsForm\');\"> -->\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\n\t\t\t</select>\n\t\t\t</td>\n\n\t\t     <td width=\"10%\"   class=\"label\" nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t <td  width=\"20%\" class=\"fields\">\n\t\t   \t <!-- IN038787 Start.-->\n\t\t\t <!--<select name=\"tick_sheet_id\" id=\"tick_sheet_id\"  onChange=\"popTickSheetValues(this);storeValues(\'\',\'tickSheetItemsForm\')\" onload=\"popTickSheetValues(this)\"> -->\n\t\t\t <select name=\"tick_sheet_id\" id=\"tick_sheet_id\"  onChange=\"popTickSheetValues(this);tickSheetOnChanges();\" onload=\"popTickSheetValues(this)\">\n\t\t\t <!-- IN038787 End. -->\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<option value=\'\'>---- ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" -----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<option value=\'\'>---- ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" -----</option>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t</select>\n\t\t\t\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td class=\"label\" colspan=\'2\'></td>\n\t\t\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="<input type=\"checkbox\" name=\"ApplicableCatalogs\" id=\"ApplicableCatalogs\" checked value=\"Y\" onclick=\"SetApplicability(this);\"></td>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<td class=\"label\" colspan=\'3\'></td>\n\t\t\t\t<input type=\"hidden\" name=\"ApplicableCatalogs\" id=\"ApplicableCatalogs\" value=\"\">\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<td colspan=\"\" class=\"button\" style=\'text-align:right\'>\n\t\t\t<input type=\"button\" class=\"button\" name=\"search\" id=\"search\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onClick=\"popTickSheetValues(document.getElementById(\"tick_sheet_id\"));\" TITLE=\"Search\"><input type=\"button\" class=\"button\" name=\"preview\" id=\"preview\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onClick=\"rapidPreview()\" TITLE=\"Preview\">\n\t\t\t</td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t\t\t<td class=\"button\" style=\'text-align:right\'><input type=\"button\" class=\"button\" name=\"search\" id=\"search\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onClick=\"popTickSheetValues(document.getElementById(\"tick_sheet_id\"));\" TITLE=\"Search\"></td>\t\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t  </tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<img src=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' width=\'100%\' height=\'15\'/> \n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<input type=\"hidden\" name=\"order_category_yn\" id=\"order_category_yn\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t<input type=\"hidden\" name=\"ammend_called_from\" id=\"ammend_called_from\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_type_yn\" id=\"order_type_yn\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t<input type=\"hidden\" name=\"activity_sql\" id=\"activity_sql\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_type_sql\" id=\"order_type_sql\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_dispaly_verticalYN\" id=\"order_dispaly_verticalYN\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"> <!--  IN038787 -->\n\t\t \t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<script>populateTickSheetId(document.tickSheetForm.order_category)</script>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<script>popTickSheetValues(document.getElementById(\"tick_sheet_id\"));//added by Channaveer B on 02/07/2010\n\t\t\t\t//storeValues(\'\',\'tickSheetItemsForm\');   //Line commented for IN038787\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n \t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
----------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        		Description
----------------------------------------------------------------------------------------------------------------------------
?            	100            		?           		created
01/12/2013		IN038787		Ramesh G			Bru-HIMS-CRF-358
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
----------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 				= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");
	String disableOrderCategory = "";
	String disableOrderType		= "";
	String order_category		= "";
	String ordertype = "";
	String ordertypedesc = "";
	String privApplicability = "";
  	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);

	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */
	//Properties properties		= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean
	String ammend_called_from	= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	if(bean.getOrderCategoryYn().equalsIgnoreCase("Y"))
				order_category 	= bean.checkForNull(bean.getOrderCategoryValue(),"");

 	String function_from		= bean.checkForNull(request.getParameter("function_from"),"");
	ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
	String existing_bean_id		= "";
	String existing_bean_name	= "";
	String ext_order_category	= ""; String ext_order_type_code = "";
	String order_dispaly_verticalYN	=	(String)bean.getOrderDisplayVerticalYN();  //IN038787
	bean.setSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
	if(function_from.equals("EXTERNAL_ORDER")) { // Get the Bean Instance of External Orders
		existing_bean_id 		= "Or_ExternalOrders";
		existing_bean_name		= "eOR.ExternalOrdersBean";
		//external_bean_obj		= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		external_bean_obj		= (ExternalOrdersBean)getBeanObject(existing_bean_id, existing_bean_name, request ) ;
		// Bean instance is needed, if it is coming from the external orders, to default the order_category and the order_type_code
		external_bean_obj.setLanguageId(localeName);

		ext_order_category		= bean.checkForNull(external_bean_obj.getOrderCategory(),"");
		ext_order_type_code		= bean.checkForNull(external_bean_obj.getOrderType(),"");
		order_category			= bean.checkForNull(ext_order_category,"");
	} 
	String licence_key			= eOR.OR_license_rights.getKey(); // Get the Licence Key from the Class
	String[] record				= null;
	ArrayList TickSheets		= null;

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
				ArrayList OrderCategory = bean.getOrderCategory("TICK_SHEETS");
			    for(int i=0; i<OrderCategory.size(); i++)
			    {
					record = (String[])OrderCategory.get(i);
					if(record[1].equalsIgnoreCase("Non Specific"))
					{
						record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NonSpecific.label","or_labels");
					}
					if(ammend_called_from.equalsIgnoreCase("existing_order") || (function_from.equals("EXTERNAL_ORDER") && ext_order_category.equals(record[0])) || (bean.getOrderCategoryYn().equalsIgnoreCase("Y") && !bean.getOrderCategoryValue().equalsIgnoreCase("")))
						disableOrderCategory = "DISABLED";
					else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N"))
						disableOrderCategory = "";
					if( (bean.getOrderCategoryValue().equalsIgnoreCase(record[0]) && (ammend_called_from.equalsIgnoreCase("existing_order") || bean.getOrderCategoryYn().equals("Y") )) || (function_from.equals("EXTERNAL_ORDER") && ext_order_category.equals(record[0])) || (licence_key.equals("ORPV")) )
						out.println("<option value = '"+record[0]+"' selected> "+record[1]+" </option>");
					else
						out.println("<option value = '"+record[0]+"'> "+record[1]+" </option>");
					
			    }

            _bw.write(_wl_block11Bytes, _wl_block11);

				if(bean.getOrderCategoryYn().equals("Y"))
					out.println("<img src=\"../../eCommon/images/mandatory.gif\"></img>");
		
            _bw.write(_wl_block12Bytes, _wl_block12);

		if(ammend_called_from.equalsIgnoreCase("existing_order") || (function_from.equals("EXTERNAL_ORDER") && ext_order_type_code.equals(record[0])) || (bean.getOrderCategoryYn().equals("Y") && bean.getOrderTypeCodeYn().equals("Y") && !bean.getOrderTypeValue().equals("")))
					 	disableOrderType = "DISABLED";
		else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N"))
						disableOrderType = "";

		if( (!(bean.checkForNull(bean.getOrderTypeValue(),"").equals("") )&& (ammend_called_from.equalsIgnoreCase("existing_order") || bean.checkForNull(bean.getOrderCategoryYn(),"").equals("Y"))))
		{
			ordertype=bean.getOrderTypeValue();
			ordertypedesc=bean.getOrderTypeDesc(ordertype);
		}else if(function_from.equals("EXTERNAL_ORDER") && !(bean.checkForNull(ext_order_type_code,"").equals("")))
		{
			ordertype=ext_order_type_code;
			ordertypedesc=bean.getOrderTypeDesc(ordertype);
		}else if(!(bean.checkForNull(bean.getAmendOrderType(),"").equals("")))
		{
			ordertype=bean.getAmendOrderType();
			ordertypedesc=bean.getOrderTypeDesc(ordertype);
		}
			
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ordertype));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ordertypedesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disableOrderType));
            _bw.write(_wl_block17Bytes, _wl_block17);

				/*ArrayList OrderType = bean.getOrderType(order_category);
			    for(int i=0; i<OrderType.size(); i++)
			    {
					record = (String[])OrderType.get(i);
					if(ammend_called_from.equalsIgnoreCase("existing_order") || (function_from.equals("EXTERNAL_ORDER") && ext_order_type_code.equals(record[0])) || (bean.getOrderCategoryYn().equals("Y") && bean.getOrderTypeCodeYn().equals("Y") && !bean.getOrderTypeValue().equals("")))
					 	disableOrderType = "DISABLED";
					else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N"))
						disableOrderType = "";
					if( (bean.getOrderTypeValue().equals(record[0]) && (ammend_called_from.equalsIgnoreCase("existing_order") ||  bean.getOrderCategoryYn().equals("Y"))) || (function_from.equals("EXTERNAL_ORDER") && ext_order_type_code.equals(record[0]))  || bean.getAmendOrderType().equalsIgnoreCase(record[0]))
						out.println("<option value = \""+record[0]+"\" selected> "+record[1]+"");
					else
						out.println("<option value = \""+record[0]+"\"> "+record[1]+"");
					record = null;	// Nullifying the objects
			    }*/

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

				/*ArrayList ActivityType = beanQueryObj.getActivityType(properties, order_category, bean.getOrderTypeValue()); // first parameter OrderCategory is passed as '' to populate all and if category is set, and next parameter is the order_type_code it will be passed
				 for(int i=0; i<ActivityType.size(); i++)
				 {
					record = (String[])ActivityType.get(i);
					out.println("<option value = \""+record[0]+"\"> "+record[1]+"");
					record = null;		//nullifying the objects
				 }*/

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

				if(bean.getOrderCategoryYn().equals("N")) // If order category for presel_order_category_yn is "N"
				{
		   			TickSheets = bean.getTickSheet(order_category); // First time order_category will be null
					if(TickSheets.size()==0)
					{
					
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

					}
			    	for(int i=0; i<TickSheets.size(); i++)
			    	{
						record = (String[])TickSheets.get(i);
						out.println("<option value = \""+record[0]+"\"> "+record[1]+"");
						//out.println("<script>alert('record[0]="+record[0]+"');</script>");
						//out.println("<script>alert('record[1]="+record[2]+"');</script>");
						record = null;		//nullifying the objects
			    	}
			    }
				else
				{
				
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
				}

            _bw.write(_wl_block26Bytes, _wl_block26);

			privApplicability = bean.getPrivilegeApplicability();
			if(privApplicability.equalsIgnoreCase("Y"))
			{
			
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

			}
			else
			{
			
            _bw.write(_wl_block29Bytes, _wl_block29);

			}
			
            _bw.write(_wl_block30Bytes, _wl_block30);
	if (!function_from.equals("AMEND_ORDER") && !function_from.equals("MULTI_PATIENT_ORDERS")) { 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Preview.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
		} else {	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
		} 
            _bw.write(_wl_block36Bytes, _wl_block36);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.getOrderCategoryYn()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ammend_called_from));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean.getOrderTypeCodeYn()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_LOOKUP")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(order_dispaly_verticalYN));
            _bw.write(_wl_block49Bytes, _wl_block49);

				if(disableOrderCategory.equalsIgnoreCase("DISABLED"))
					out.println("<script>disableOrderCategory('tickSheetForm')</script>");
				if(disableOrderType.equalsIgnoreCase("DISABLED"))
					out.println("<script>disableOrderType('tickSheetForm')</script>");
					out.println("<script>OrderTypedisable('tickSheetForm')</script>");
			
            _bw.write(_wl_block50Bytes, _wl_block50);

			if(!bean.getOrderCategoryYn().equals("Y"))
			{
				
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
	
			// Nullifying the objects
			record				= null;		
			if(OrderCategory	!= null) {
				OrderCategory.clear();	OrderCategory = null;
			}
			//if(OrderType	!= null) {
				//OrderType.clear();	OrderType = null;
		   //}
			//if(ActivityType	!= null) {
				//ActivityType.clear();	ActivityType = null;
			//}
			record = null;	// Nullifying the objects
			if(TickSheets	!= null) {
				TickSheets.clear();	TickSheets = null;
			}

            _bw.write(_wl_block52Bytes, _wl_block52);

	// no need to set it back persistence( no set methods used)
	//putObjectInBean(bean_id,bean,request);
	//	if(function_from.equals("EXTERNAL_ORDER")) { // Get the Bean Instance of External Orders
	//	putObjectInBean(existing_bean_id,external_bean_obj,request);
	//}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderCategory.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ActivityType.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.TickSheet.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.LimitToMyApplicableCatalogs.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
