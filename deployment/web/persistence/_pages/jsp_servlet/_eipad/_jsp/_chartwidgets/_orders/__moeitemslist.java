package jsp_servlet._eipad._jsp._chartwidgets._orders;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsSearchRequest;
import eIPAD.chartsummary.orderentry.healthobject.MOrderCatalogHO;
import eOR.OrderEntryBean;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.orderentry.bc.MOrderEntryBC;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest;
import java.util.*;
import javax.servlet.http.HttpSession;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __moeitemslist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/orders/MoeItemsList.jsp", 1709116946020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n/* $(document).ready(function(){\n\t\n\t$(\".ontapimg\").on(\"tap\",function(){\n\t\t  $(this).hide();\n\t\t});\n}); */\n</script>\n\n<div id=\"OrdListHWrapper_";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" class=\"ordListHWrapper\"  style=\"position:relative\">\n\t<div class=\"ordListcontainer ordItemscroller\" id=\"OrdItemscroller_";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n\t\t<ul id=\"OrdListColWrap_";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" class=\"ordListColWrap\">\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\n\t\t\t\t<li>\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<div class=\"ordDraggable ordItemBoxTheme ordDraggable_";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" data-ordercatalogcode=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" data-ordertypecode=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" data-ordercategorycode=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t\t<div class=\"ordItemBtnIcon\">\n\t\t\t\t\t\t\t<div class=\"ordItemLeftBlock\">  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t<div class=\"ordItemText\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<div class=\"ordItemRightBlock\"  onclick=\"openPanelOrderSetContents(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\"><img src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/Drop_Arrow.png\" width=\"28\" height=\"44\" class=\"ontapimg\"></div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t<div class=\"ordItemRightBlock ordItemDragBtn\"><img src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/eIPAD/images/Drop_icon.PNG\" width=\"3\" height=\"17\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</li>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</ul>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<div> Orders could not be got due to some error</div>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\n\t</div>\n</div>\n\n\t\n";
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
MOrderCatalogListResponse searchResponse = null;
String orderNature = "";
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
	String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
	String or_bean_name = "eOR.OrderEntryBean";
	OrderEntryBean bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
	String searchMode = request.getParameter("SearchMode") == null?"":request.getParameter("SearchMode");
	//Tick Sheet Search
	if(searchMode.equals("T")){
		String tickSheetId = request.getParameter("TickSheetId") == null?"":request.getParameter("TickSheetId");
		String sectionCode = request.getParameter("SectionCode") == null?"":request.getParameter("SectionCode");
		orderNature = request.getParameter("OrderNature") == null?"":request.getParameter("OrderNature");
		MOrderCatalogsTickSearchRequest tickSearchRequest = new MOrderCatalogsTickSearchRequest();
		tickSearchRequest.setPatientContext(patientContext);
		tickSearchRequest.setOrderEntryBean(bean);
		tickSearchRequest.setTickSheetId(tickSheetId);
		tickSearchRequest.setSectionCode(sectionCode);
		tickSearchRequest.setOrderNature(orderNature);
		MOrderEntryBC bc = new MOrderEntryBC();
		searchResponse =  bc.getTickSheetOrders(tickSearchRequest, true);
	} 
	//Additional Search
	else if(searchMode.equals("A")){
		String orderCategory = request.getParameter("OrderCategory") == null?"":request.getParameter("OrderCategory");
		String orderType = request.getParameter("OrderType") == null?"":request.getParameter("OrderType");
		String searchText = request.getParameter("SearchText") == null?"":request.getParameter("SearchText");
		orderNature = request.getParameter("OrderNature") == null?"":request.getParameter("OrderNature");
		MOrderCatalogsSearchRequest addlSearchRequest = new MOrderCatalogsSearchRequest();
		addlSearchRequest.setPatientContext(patientContext);
		addlSearchRequest.setOrderEntryBean(bean);
		addlSearchRequest.setOrderCategory(orderCategory);
		addlSearchRequest.setOrderType(orderType);
		addlSearchRequest.setSearchText(searchText);
		addlSearchRequest.setOrderNature(orderNature);
		MOrderEntryBC bc = new MOrderEntryBC();
		searchResponse =  bc.getOrdersBySearch(addlSearchRequest, true);
	}
}



            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block5Bytes, _wl_block5);

		if(searchResponse!=null && searchResponse.isSuccessResponse() && !searchResponse.isEmptyDataResponse()){
			ArrayList<MOrderCatalogHO> ordersList = searchResponse.getOrderCatalogList();
			if(ordersList!=null && !ordersList.isEmpty()){
				for(int i=0;i<ordersList.size();i++){
					MOrderCatalogHO orderItem = ordersList.get(i);
					if(orderItem!=null){
		
            _bw.write(_wl_block6Bytes, _wl_block6);

					String orderCategoryCode = orderItem.getCatalogNature().equals("S")?"CS":orderItem.getOrderCategory();
					
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(orderItem.getOrderCatalogCode()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(orderItem.getOrderTypeCode()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(orderCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orderItem.getCatalogSynonym()));
            _bw.write(_wl_block13Bytes, _wl_block13);
if(!orderItem.getCatalogNature().equals("A")) {
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(orderItem.getOrderCatalogCode()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderItem.getCatalogNature()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderItem.getContrMsrPanelId()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderItem.getOrderCategory()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderItem.getOrderCatalogCode()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderItem.getCatalogSynonym()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);

						}
					}
				}
            _bw.write(_wl_block20Bytes, _wl_block20);
	} else{
            _bw.write(_wl_block21Bytes, _wl_block21);
 	}
	
            _bw.write(_wl_block22Bytes, _wl_block22);
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
