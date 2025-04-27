package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.pendingorders.healthobject.PendingOrderCountHO;
import eIPAD.chartsummary.pendingorders.response.PendingOrderCountResponse;
import eIPAD.chartsummary.results.request.ResultsCatConstants;
import java.util.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Locale;
import eIPAD.chartsummary.results.request.ResultsCatConstants;
import java.util.Locale;
import java.util.ResourceBundle;

public final class __pendingordersview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/PendingOrdersView.jsp", 1709118020271L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n<script>\nvar path;\n$(document).ready(function(){\n\t\n\tpath = $(\'#hdnPath\').val();\n\tvar firstOrderCat = $(\'#firstOrderCat\').val();\n\t$(\"#OrdersDataFrame\").load( path + \"/mobile/chartsummary/PendingOrdersDataView?OrderCategory=\"+firstOrderCat,function(){\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n});\n function openPendingOrderExpandedView(){\n\t$(\"#PageLoadingAnimation\").show();\n\t\n\twindow.location.replace( path + \'/mobile/chartsummary/PendingOrdersAllDataView\');\n} \n\nfunction showResultOf(cat, widObj){\n\t$(\"#OrdersDataFrame\").empty();\n\t$(\"#OrdersDataFrame\").load( path + \"/mobile/chartsummary/PendingOrdersAllDataView\",function(){\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n\t$(\".widgetTab\").each(function(i){\n\t\t$(this).removeClass(\"widgetTabActiveTheme\").addClass(\"widgetTabNonActiveTheme\").addClass(\"widgetTabNonActive\");\n\t\t$(widObj).removeClass(\"widgetTabNonActiveTheme\").removeClass(\"widgetTabNonActive\").addClass(\"widgetTabActiveTheme\");\n\t})\n}\n\nfunction openPOType(obj){\n\tvar poType=$(obj).data(\"code\");\n\t$(\"#OrdersDataFrame\").empty();\n\t$(\"#OrdersDataFrame\").load( path + \"/mobile/chartsummary/PendingOrdersDataView?OrderCategory=\"+poType,function(){\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n\t$(\".widgetPOTab\").each(function(i){\n\t\t$(this).removeClass(\"widgetTabActiveTheme\").addClass(\"widgetTabNonActiveTheme\").addClass(\"widgetTabNonActive\");\n\t\t$(obj).removeClass(\"widgetTabNonActiveTheme\").removeClass(\"widgetTabNonActive\").addClass(\"widgetTabActiveTheme\");\n\t})\n\t\n}\n</script>\n<style>\n#PageLoadingAnimation{\n\tz-index: 10000;\n\tposition: absolute;\n\tleft: 0px;\n\ttop: 0px;\n\twidth: 100%;\n\theight: 100%;\n\tbackground-color: #808080;\n\topacity: 0.6;\n\tbackground-image: url(";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tdisplay: none; \n}\n\n\n</style>\n\n<div id=\"PageLoadingAnimation\" > </div>\n\t<div class=\"widgetParent widgetParentTheme\" data-role = \"none\">\n\t<form id=\"POWidgetForm\" class=\"POWidgetForm\" action=\"\" method=\"post\" name=\"POWidgetForm\" id=\"POWidgetForm\"> \n\t\t<div class=\"widgetTable\" data-role = \"none\">\n\t\t\t<div class=\"widgetHeaderRow widgetHeaderRowTheme\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderMarginExtn widgetHeaderMarginExtnTheme\" data-role = \"none\"></div>\n\t\t\t\t\t<div class=\"widgetHeaderIcontriangle\" data-role = \"none\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetHeaderCell widgetHeaderCellTheme\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderSubTable\" data-role = \"none\">\n\t\t\t\t\t\t<div class=\"widgetHeaderSubRow\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"widgetHeaderIconCol1\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"widgetHeaderIconButton widgetHeaderIconButtonTheme\" data-role = \"none\"><img src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/CS_Allergies.PNG\" class=\"widgetHeaderButtonImage\"></div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t\t<div class=\"widgetHeaderHeadingTextCol\" data-role = \"none\"><span class=\"widgetHeaderHeadingTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t<input type=\"button\" class=\"widgetHeaderCountButtonTheme\" id=\"pendingOrderViewCount\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"widgetHeaderPlusButtonCell\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"openPendingOrderExpandedView()\"><img src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/thumbb.png\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\n\n\t\t\t<div class=\"widgetContentRow\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetContentCell widgetContentCellTheme\" data-role = \"none\">\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t<div style=\"display:table-row\" class=\"\">\n\t\t\t\t\t\t\t<div style=\"display:table-cell\" class=\"widgetTabBckgrndTheme\"><!-- Tab container -->\n\t\t\t\t\t\t\t\t<div style=\"text-align:center;margin-top:10px;font-size:0px\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t<div style=\"display:inline-block\" class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" widgetTab widgetPOTab\" onclick=\"openPOType(this)\" data-code=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"><!-- Individual tabs -->\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;height:100%;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"margin-left:5px;margin-right:5px\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="(";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div style=\"display:table-row;width:100%;\">\n\t\t\t\t\t\t\t<div style=\"display:table-cell;width:100%;\"><!-- Order data frame container -->\n\t\t\t\t\t\t\t\t<div src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/eIPAD/jsp/chartwidgets/PendingOrderDetails.jsp\" style=\"border:0;height:auto;width:100%;min-height:50px;background:#ffffff\" id=\"OrdersDataFrame\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t</div> \n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<div class=\"WidgetVwErrContainer\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \n\t\t\t\t\t</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<input type=\"hidden\" name=\"firstOrderCat\" id=\"firstOrderCat\" id=\"firstOrderCat\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"\n \t\t</form> \n\t</div>\n\t\n\t\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);  

PendingOrderCountResponse countResponse = (PendingOrderCountResponse)request.getAttribute("CountResponse");
String firstOrderCat = "";
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();

if(countResponse!=null){
	errorList = countResponse.getErrorsList();
}


            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(csResBundle.getString("pendingOrder.pendingOrders") ));
            _bw.write(_wl_block7Bytes, _wl_block7);
 if(countResponse!=null && countResponse.isSuccessResponse() && !countResponse.isEmptyDataResponse()){
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(countResponse.getPendingOrdersTotalCount()));
            _bw.write(_wl_block9Bytes, _wl_block9);
} 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if(countResponse!=null && countResponse.isSuccessResponse() && !countResponse.isEmptyDataResponse()){
					ArrayList<PendingOrderCountHO> countList = countResponse.getPendingOrderCountList();
					firstOrderCat = countList.get(0).getOrderCategoryCode();
				
            _bw.write(_wl_block12Bytes, _wl_block12);

								String tabStyle;
								for(int i=0;i<countList.size();i++) {
									if(i==0){
										tabStyle = "widgetTabActiveTheme";
									}else{
										tabStyle = "widgetTabNonActiveTheme widgetTabNonActive";
									}
										
									PendingOrderCountHO curHO = countList.get(i);
									if(curHO!=null){
								
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tabStyle ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curHO.getOrderCategoryCode()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(curHO.getOrderCategoryDesc() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(curHO.getOrderCount() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
	} 
								}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
} 
					else{
					
            _bw.write(_wl_block20Bytes, _wl_block20);

						for(int k=0;k<errorList.size();k++){
						
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( errorList.get(k).getErrorMessage()));
            _bw.write(_wl_block22Bytes, _wl_block22);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);
} 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( firstOrderCat ));
            _bw.write(_wl_block25Bytes, _wl_block25);
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
