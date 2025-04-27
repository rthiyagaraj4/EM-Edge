package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldItem;
import java.util.ArrayList;
import eOR.OrderEntryBean;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ResourceBundle;
import java.util.Locale;
import eIPAD.chartsummary.orderentry.bc.MOrderEntryBC;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __registerorderaddlsearchlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/RegisterOrderAddlSearchList.jsp", 1738426195896L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>Order Entry Additional Search</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/jquery.mobile-1.0a4.1.min.css\" /> -->\n\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/iPadNew_IP.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/iPADNew.css\" />\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>  -->\n<script src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/js/iscroll5/iscroll.js\"></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script>\n\n\n\ndocument.addEventListener(\'DOMContentLoaded\', assignAddnlSearchListScroller, false);\n\nfunction onloadAddnlSearchCriteria(){\n\tvar ordCatDesc = $(\"#hdnOrderCategory\").val();\n\tvar ordCatCode = $(\"#hdnOrderCategoryCode\").val();\n\tif(ordCatDesc && ordCatCode){\n\t\t//enable ordertype selection and text box  and the search button\n\t\t$(\"#OrderTypeSelection\").css(\"opacity\",\"1\");\n\t\t$(\"#OrderTypeSelection\").attr(\"onclick\", \"openSearchResults(\'OT\')\");\n\t\t$( \"#OrderTypeSelection\" ).click(function() {\n\t\t\topenSearchResults(\'OT\');\n\t\t});\n\t\t\n\t\t$(\"#SearchTextContainer\").css(\"opacity\",\"1\");\n\t\t$(\"#OrdSearchText\").removeAttr(\"disabled\");\n\t\t\n\t\t$(\"#AddlSearchButton\").removeClass(\"ipSearchHeaderButtonDisabledTheme\").addClass(\"ipSearchHeaderButtonTheme\");\n\t\t$( \"#AddlSearchButton\" ).click(function() {\n\t\t\tperformSearch();\n\t\t});\n\t}\n}\n\nfunction openSearchResults(sfsContext){\n\t$(\"#hdnSfsContext\").val(sfsContext);\n\t$(\"#OrderSfsForm\").submit();\n}\nfunction cancelSearch(){\n\tparent.toggleAddlSearch();\n}\nfunction performSearch(){\n\tvar orderCat = $(\"#hdnOrderCategoryCode\").val();\n\tvar orderType = $(\"#hdnOrderTypeCode\").val();\n\tvar searchText = $(\"#OrdSearchText\").val();\n\tparent.loadAddlSearchOrders(orderCat,orderType,searchText);\n\tparent.toggleAddlSearch();\n}\n\nvar addnlSearchScroll;\nfunction assignAddnlSearchListScroller() {\n\taddnlSearchScroll = new IScroll(\'#contentWrapper\', { \n\t\tscrollX: false, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true,\n\t\tdisableMouse: false,\n    disablePointer: true\n\t\t/* interactiveScrollbars: true,\n\t\tshrinkScrollbars: \'scale\',*/\n\t\t/* fadeScrollbars: true  */\n\t});\n}\nfunction selectSFSItem(code,description){\n\tvar sfsContext = $(\"#hdnSfsContext\").val();\n\t\n\tif(sfsContext == \'OC\'){\t\t\n\t\tvar prevOrderCat = $(\"#hdnOrderCategoryCode\").val();\n\t\t//resetting orderType selection while order catergory selection is changed\n\t\tif(prevOrderCat != code){\n\t\t\t$(\"#hdnOrderType\").val(\"\");\n\t\t\t$(\"#hdnOrderTypeCode\").val(\"\");\n\t\t}\n\t\t$(\"#hdnOrderCategory\").val(description);\n\t\t$(\"#hdnOrderCategoryCode\").val(code);\n\t}\n\telse if(sfsContext == \'OT\'){\n\t\t$(\"#hdnOrderType\").val(description);\n\t\t$(\"#hdnOrderTypeCode\").val(code);\n\t}\n\t\n\t$(\"#OrderSfsForm\").submit();\n}\nfunction backToSearchCrit(){\n\tvar searchForm = document.getElementById(\"OrderSfsForm\");\n\tsearchForm.submit();\n}\n\n\n\n\n</script>\n<style>\n.vscroller5{\n\twidth: 100%;\n\theight: auto;\n\tposition: absolute;\n\tz-index: 1;\n}\n.ipSearchResWrapper2{\n\tposition:relative;\n\theight:210px;\n\toverflow:hidden;\n\tz-index:1000;\n\tmargin:2px;\n}\n\n</style>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/css/iPADNew.css\" />\n</head>\n<body style=\"width: 100%; height: 100%;\">\n\t<form name=\'OrderSfsForm\' id=\'OrderSfsForm\' method=\'post\' id=\"OrderSfsForm\" style= \"width:100%; height:100%;\" action=\"RegisterOrderAddlSearchCrit.jsp\">\n\t\t<div class=\"ipSearchHeader ipSearchHeaderTheme\" style=\"height:36px\">\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td style=\"width:100px;\"><div class=\"ipSearchHeaderButtonTheme\" onclick=\"backToSearchCrit()\">Back</div></td>\n\t\t\t\t\t<td style=\"width:200px;\"><div class=\"ipSearchHeaderText ipSearchHeaderTextTheme\"></div></td>\n\t\t\t\t\t<td style=\"width:100px;\"><div class=\"ipSearchHeaderButtonDisabledTheme\">Search</div></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<div class=\"ipSearchContainer ipSearchContainerTheme\" style=\"height:80%\"> <!-- style=\"width: 392px; height: 254px;\" -->\n\t\t\t<div>\n\t\t\t\t<table  cellpadding = \"0\" cellspacing = \"0\" border = \"0\" style=\"width:100%;height:100%;\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td style=\"width:50%;\"><div class=\"ipSearchTabSelected ipSearchTabSelectedTheme\"><div class=\"ipSearchTabText\">Search</div></div></td>\n\t\t\t\t\t\t<td style=\"width:50%;\"><div class=\"ipSearchTabNotSelected ipSearchTabNotSelectedTheme\"><div class=\"ipSearchTabText\">Recent Search</div></div></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<div  data-role = \"none\" id = \"contentWrapper\" class=\"ipSearchResWrapperTheme ipSearchResWrapper2\" style=\"height:140px\" >\n\t\t\t\t<div data-role = \"none\" class=\"vscroller5\">\n\t\t\t\t\t<div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing = \"0\" style=\"width: 100%; height: 100%;overflow:hidden\" class=\"ipSearchResultsTableTheme\">\n\t\t\t\t\t\t\t<tr class=\"ipSearchResultsHeading ipSearchResultsHeadingTheme\">\n\t\t\t\t\t\t\t\t<th style=\"width:20%\"><span class=\"ipSearchResultsHeadingText\">Code</span></th>\n\t\t\t\t\t\t\t\t<th style=\"width:80%\"><span class=\"ipSearchResultsHeadingText\">Description</span></th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t \t\t\t\t<tr class=\"ipSearchResultsBody ipSearchResultsBodyTheme\" onclick=\"selectSFSItem(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\', \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\">\n\t\t\t\t\t\t\t\t<td><span class=\"ipSearchResultsBodyText\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span></td>\n\t\t\t\t\t\t\t\t<td><span class=\"ipSearchResultsBodyText\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span></td>\n\t\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t     \t\t<div class=\"sfsSearchResultsEmptyTheme\">No Records Found</div><!-- TODO Translate -->\n\t\t\t     \t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n \t\t\n\t\t\t<input type = \"hidden\" name =\"hdnOrderCategory\" id =\"hdnOrderCategory\" value =\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/>\n\t\t\t<input type = \"hidden\" name =\"hdnOrderCategoryCode\" id =\"hdnOrderCategoryCode\" value =\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\n\t\t\t<input type = \"hidden\" name =\"hdnOrderType\" id =\"hdnOrderType\" value =\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/>\n\t\t\t<input type = \"hidden\" name =\"hdnOrderTypeCode\" id =\"hdnOrderTypeCode\" value =\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/>\n\t\t\t<input type = \"hidden\" name =\"hdnSfsContext\" id =\"hdnSfsContext\" value =\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/>\n\t\t</div>\n\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" />\n\t</form>\n \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

String orderCategory = request.getParameter("hdnOrderCategory") == null?"":request.getParameter("hdnOrderCategory");
String orderCategoryCode = request.getParameter("hdnOrderCategoryCode") == null?"":request.getParameter("hdnOrderCategoryCode");
String orderType = request.getParameter("hdnOrderType") == null?"":request.getParameter("hdnOrderType");
String orderTypeCode = request.getParameter("hdnOrderTypeCode") == null?"":request.getParameter("hdnOrderTypeCode");
String sfsContext = request.getParameter("hdnSfsContext") == null?"":request.getParameter("hdnSfsContext");

MOrderEntryBC bc = new MOrderEntryBC();
MOrderEntryFieldResponse sfsResp = null;
Locale appLocale;
String locale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals("")){
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
	locale = (String)session.getAttribute("LOCALE");
}
else {
	appLocale = new Locale("en");
	locale = "en";
}
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(sfsContext.equals("OC")){
	sfsResp = bc.getAllOrderCategories(locale, true);
}
else if(sfsContext.equals("OT")){
	sfsResp = bc.getOrderTypesUnderCategory(locale, orderCategoryCode, true);
}


            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);

					if(sfsResp!=null && sfsResp.getResponseStatus()==0 && sfsResp.getFieldItems()!=null && !sfsResp.getFieldItems().isEmpty()){
						
					
					
            _bw.write(_wl_block10Bytes, _wl_block10);
 
							ArrayList<MOrderEntryFieldItem> sfsItems = sfsResp.getFieldItems();
							for(int i=0;i<sfsItems.size();i++) {
								MOrderEntryFieldItem sfsItem = sfsItems.get(i);
							
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sfsItem.getCode() ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sfsItem.getDesc() ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sfsItem.getCode() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sfsItem.getDesc() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{ 
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(orderCategory));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(orderCategoryCode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(orderType));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(orderTypeCode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sfsContext));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
}
