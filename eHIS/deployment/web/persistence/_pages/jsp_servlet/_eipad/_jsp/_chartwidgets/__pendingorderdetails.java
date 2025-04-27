package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.List;
import eIPAD.chartsummary.pendingorders.healthobject.PendingOrderItems;
import eIPAD.chartsummary.pendingorders.healthobject.PendingOrders;
import eIPAD.chartsummary.pendingorders.response.PendingOrderResponse;
import eIPAD.chartsummary.common.response.ErrorInfo;
import java.util.ArrayList;

public final class __pendingorderdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/PendingOrderDetails.jsp", 1709118020053L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script type=\"text/javascript\">\n\nfunction showPOFormatPopup(obj,popupId){\n\t\n\tvar popupObj = $(\"#\"+popupId);\n\n    \n    var popupTitle = $(obj).data(\"title\");\n    //alert(encodeURI($(obj).data(\"linkurl\")));\n    var url = $(obj).data(\"linkurl\");\n    var orderid = $(obj).data(\"orderid\");\n    var linenum = $(obj).data(\"linenum\");\n    url = url + \"?OrderId=\"+orderid+\"&LineNum=\"+linenum;\n    //alert(url);\n    //var linkurl = encodeURI(url);\n    //alert(linkurl);\n    var scrollerId = popupId+\"-scroller\";\n    var wrapperId = popupId+\"-wrapper\";\n    var contentsId = popupId+\"-contents\";\n    \n    //var LinkedResPopupScroll;\n\n    //clearing the contents\n    $(\"#\"+contentsId).empty();\n\n    $(\"#\"+popupId+\"-title\").html(popupTitle);\n    \n\t$(popupObj).show();\n\t$(\"#dvMez\").show();\n\t$(\"#dvMez\").data(\"popid\",popupId);\n\tsetTimeout(function() {\n\t\t$(\"#dvMez\").on(\"click\",closeMez);\n\t}, 500);\n/* \tif(LinkedResPopupScroll!=null){\n\t\tLinkedResPopupScroll.refresh();\n\t} */\n    $(\"#\"+contentsId).load(url, function(){\n    \t\n    \tLinkedResPopupScroll = new iScroll(wrapperId, {\n    \t\tuseTransform : true,\n    \t\tzoom : false,\n    \t\tonBeforeScrollStart : function(e) {\n    \t\t\tvar target = e.target;\n    \t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n    \t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' ){\n    \t\t\t\te.preventDefault();\n    \t\t\t}\n\n    \t\t\te.stopPropagation();\n    \t\t}\n    \t});\n    \tif(LinkedResPopupScroll!=null){\n    \t\tLinkedResPopupScroll.refresh();\n    \t}\n    });\n\n}\n\n\n</script>\n\n<style>\n.poContentRow {\n    height: 65px;\n}\n.poItemRow1 {\n    height: 41px;\n}\n.poModifyButton{\n\tdisplay: none;\n    position: absolute;\n    right: 10px;\n    z-index: 1;\n}\n\n\n</style>\n\n<div style=\"width:100%;\" data-role = \"none\">\n<form id=\"PODataForm\" action=\"\" method=\"post\" name=\"PODataForm\" id=\"PODataForm\"> \n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\t\t\n\t<div class=\"WidgetContentStripTheme\"  style=\"display:table;width:100%\" data-role = \"none\"> <!--  content table starts -->\n\t\t<div class=\"poContentRow\" style=\"display:table-row;width:100%;\" data-role = \"none\"> <!-- content row starts -->\n\t\t\t<div style=\"display:table-cell;width:100%;\" data-role = \"none\"><!-- contentCell starts here -->\n\t\t\t\t<div style=\"display:table;width:100%;height:100%\" data-role = \"none\">\n\t\t\t\t\t<div class = \"poItemRow1\" style=\"display:table-row;width:100%\" data-role = \"none\">\n\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class = \"WidgetParaHeadTextTheme\" style=\"padding-left:12px;padding-top:10px;\" data-role = \"none\">\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t <span class=\"WidgetNormalTextItalicTheme\" > (";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =")</span> \n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonTheme poModifyButton\" data-role = \"none\">Modify</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:right\"data-role = \"none\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t<div class = \"poOrderlineImg\" style=\"display:inline-block;padding-right:20px \" data-role = \"none\" data-orderid=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" \n\t\t\t\t\t\t\t\tdata-linenum=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  data-title=\"Order Line Format\"  onclick=\"showPOFormatPopup(this,\'CSCommonPopUpContainer\')\" data-linkurl=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/mobile/chartsummary/PendingOrdersFormatView\">\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div style=\"display:table;width:100%;height:100%\" data-role = \"none\">\n\t\t\t\t\t<div style=\"display:table-row;width:100%\" data-role = \"none\">\n\t\t\t\t\t\t<div style=\"display:table-cell\" data-role = \"none\">\n\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;height:100%\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t   <div class = \"WidgetNormalTextTheme\" style=\"padding-left:12px;padding-bottom:10px;\"data-role = \"none\">\n\t\t                                \tby ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t                              </div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:right\"data-role = \"none\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"WidgetDateTextTheme\" style=\"display:inline-block;padding-right:20px\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div>\n\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div><!-- contentCell ends here -->\t\n\t\t</div><!-- content row ends -->\n\t</div><!--  content table ends -->\n\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<div class=\"WidgetVwErrContainer\">\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \n\t</div>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\n\t\n</form>\n</div>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

PendingOrderResponse ordersResp = (PendingOrderResponse)request.getAttribute("POResponse");
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();

if(ordersResp!=null){
	errorList = ordersResp.getErrorsList();
}


            _bw.write(_wl_block3Bytes, _wl_block3);

		if(ordersResp.isSuccessResponse()&&!ordersResp.isEmptyDataResponse()){
			List<PendingOrders> pendingOrderList = ordersResp.getPendingOrderList();
			if(pendingOrderList!=null){
				for(int i=0;i<pendingOrderList.size();i++){
					List<PendingOrderItems> pendingOrderItemList =  pendingOrderList.get(i).getPendingOrderItemList();
					if(pendingOrderItemList!=null){
						for(int j=0;j<pendingOrderItemList.size();j++){
							PendingOrderItems orderItem = pendingOrderItemList.get(j);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(orderItem.getCatalogDescription() ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(orderItem.getOrderStatusDesc() ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
if(orderItem.getFormatExistYN().equals("Y")){ 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(orderItem.getOrderId() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(orderItem.getOrderLineNum() ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
} 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orderItem.getPractitionerName() ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(orderItem.getOrderDateTime() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
					}
					}
				}
			}
	
            _bw.write(_wl_block16Bytes, _wl_block16);
} else{
	
            _bw.write(_wl_block17Bytes, _wl_block17);

		for(int k=0;k<errorList.size();k++){
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( errorList.get(k).getErrorMessage()));
            _bw.write(_wl_block19Bytes, _wl_block19);
} 
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);
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
