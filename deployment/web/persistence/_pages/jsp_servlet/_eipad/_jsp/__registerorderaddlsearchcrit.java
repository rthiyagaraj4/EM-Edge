package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __registerorderaddlsearchcrit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/RegisterOrderAddlSearchCrit.jsp", 1738426176671L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<!DOCTYPE html>\n<html>\n<head>\n<title>Order Entry Additional Search</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/jquery.mobile-1.0a4.1.min.css\" /> -->\n\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/css/iPadNew_IP.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/iPADNew.css\" />\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  -->\n<script>\n\n\n$(document).ready(function(){\n\tonloadAddnlSearchCriteria();\n});\n\nfunction onloadAddnlSearchCriteria(){\n\tvar ordCatDesc = $(\"#hdnOrderCategory\").val();\n\tvar ordCatCode = $(\"#hdnOrderCategoryCode\").val();\n\tif(ordCatDesc && ordCatCode){\n\t\t//enable ordertype selection and text box  and the search button\n\t\t$(\"#OrderTypeSelection\").css(\"opacity\",\"1\");\n\t\t$(\"#OrderTypeSelection\").attr(\"onclick\", \"openSearchResults(\'OT\')\");\n\t\t$( \"#OrderTypeSelection\" ).click(function() {\n\t\t\topenSearchResults(\'OT\');\n\t\t});\n\t\t\n\t\t$(\"#SearchTextContainer\").css(\"opacity\",\"1\");\n\t\t$(\"#OrdSearchText\").removeAttr(\"disabled\");\n\t\t\n\t\t$(\"#AddlSearchButton\").removeClass(\"ipSearchHeaderButtonDisabledTheme\").addClass(\"ipSearchHeaderButtonTheme\");\n\t\t$( \"#AddlSearchButton\" ).click(function() {\n\t\t\tperformAddlSearch();\n\t\t});\n\t}\n}\n\nfunction openSearchResults(sfsContext){\n\t$(\"#hdnSfsContext\").val(sfsContext);\n\t$(\"#OrderSfsForm\").submit();\n}\nfunction cancelSearch(){\n\tparent.toggleAddlSearch();\n}\nfunction performSearch(){\n\tvar orderCat = $(\"#hdnOrderCategoryCode\").val();\n\tvar orderType = $(\"#hdnOrderTypeCode\").val();\n\tvar searchText = $(\"#OrdSearchText\").val();\n\tparent.loadAddlSearchOrders(orderCat,orderType,searchText);\n\tparent.toggleAddlSearch();\n}\n\nvar addnlSearchScroll;\nfunction assignAddnlSearchListScroller() {\n\taddnlSearchScroll = new IScroll(\'#contentWrapper\', { \n\t\tscrollX: false, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true,\n\t\tdisableMouse: false,\n    disablePointer: true\n\t\t/* interactiveScrollbars: true,\n\t\tshrinkScrollbars: \'scale\',*/\n\t\t/* fadeScrollbars: true  */\n\t});\n}\nfunction selectSFSItem(code,description){\n\tvar sfsContext = $(\"#hdnSfsContext\").val();\n\t\n\tif(sfsContext == \'OC\'){\t\t\n\t\t$(\"#hdnOrderCategory\").val(description);\n\t\t$(\"#hdnOrderCategoryCode\").val(code);\n\t}\n\telse if(sfsContext == \'OT\'){\n\t\t$(\"#hdnOrderType\").val(description);\n\t\t$(\"#hdnOrderTypeCode\").val(code);\n\t}\n\t\n\t$(\"#OrderSfsForm\").submit();\n}\nfunction backToSearchCrit(){\n\tvar searchForm = document.getElementById(\"OrderSfsForm\");\n\tsearchForm.submit();\n}\nfunction performAddlSearch(){\n\tvar orderCat = $(\"#hdnOrderCategoryCode\").val();\n\tvar orderCatDesc = $(\"#hdnOrderCategory\").val();\n\tvar orderType = $(\"#hdnOrderTypeCode\").val();\n\tvar orderTypeDesc = $(\"#hdnOrderType\").val();\n\tparent.loadAddlSearchOrders(orderCat,orderCatDesc, orderType,orderTypeDesc);\n\tparent.toggleAddlSearch();\n}\n</script>\n<style>\n .sfs_header {\n\twidth: 100%;\n\theight: 47px;\n\t\n}\n.sfs_headerTheme{\n\tbackground: #16a4c6; /* Old browsers */\n\tbackground: -moz-linear-gradient(top, #16a4c6 0%, #1087af 50%, #085f8c 100%); /* FF3.6+ */\n\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#16a4c6), color-stop(50%,#1087af), color-stop(100%,#085f8c)); /* Chrome,Safari4+ */\n\tbackground: -webkit-linear-gradient(top, #16a4c6 0%,#1087af 50%,#085f8c 100%); /* Chrome10+,Safari5.1+ */\n\tbackground: -o-linear-gradient(top, #16a4c6 0%,#1087af 50%,#085f8c 100%); /* Opera 11.10+ */\n\tbackground: -ms-linear-gradient(top, #16a4c6 0%,#1087af 50%,#085f8c 100%); /* IE10+ */\n\tbackground: linear-gradient(to bottom, #16a4c6 0%,#1087af 50%,#085f8c 100%); /* W3C */\n\tfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr=\'#16a4c6\', endColorstr=\'#085f8c\',GradientType=0 ); /* IE6-9 */\n}\n.sfsHeaderRibTheme{\n\twidth: 100%;\n\theight: 45px;\n\tbackground-repeat: repeat-x;\n\tbackground-image: url(Header_Bg_Rib.PNG);\n\tbackground-position: bottom;\n}\n.sfsBtnTheme {\n\t-moz-box-shadow:inset 0px 1px 0px 0px #0ba1ce;\n\t-webkit-box-shadow:inset 0px 1px 0px 0px #0ba1ce;\n\tbox-shadow:inset 0px 1px 0px 0px #0ba1ce;\n\tbackground:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #0e89ae), color-stop(1, #0a678c) );\n\tbackground:-moz-linear-gradient( center top, #0e89ae 5%, #0a678c 100% );\n\tfilter:progid:DXImageTransform.Microsoft.gradient(startColorstr=\'#0e89ae\', endColorstr=\'#0a678c\');\n\tbackground-color:#0e89ae;\n-webkit-border-radius: 2px;\n-moz-border-radius: 2px;\nborder-radius: 2px;\n\ttext-indent:2px;\n\tborder:1px solid #214656;\n\tdisplay:inline-block;\n\tcolor:#ffffff;\n\tfont-family:Arial;\n\tfont-size:13px;\n\tfont-weight:bold;\n\tfont-style:normal;\n\theight:33px;\n\tline-height:33px;\n\twidth:71px;\n\ttext-decoration:none;\n\ttext-align:center;\n\ttext-shadow:1px 1px 0px #07455c;\n\tmargin:3px;\n\tfloat: left;\n}\n.sfsBtnTheme:hover {\n\tbackground:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #0a678c), color-stop(1, #0e89ae) );\n\tbackground:-moz-linear-gradient( center top, #0a678c 5%, #0e89ae 100% );\n\tfilter:progid:DXImageTransform.Microsoft.gradient(startColorstr=\'#0a678c\', endColorstr=\'#0e89ae\');\n\tbackground-color:#0a678c;\n}.sfsBtnTheme:active {\n\tposition:relative;\n\ttop:1px;\n}\n.sfsHeaderTitle\n{\n\theight:45px;\n    width:180px;\n    text-align:center;\n    display: table-cell; \n    vertical-align:middle;\n\tfloat:left;\n}\n.sfsHeaderTitleTxt\n{\n\theight: 45px;\n\twidth: 180px;\n\ttext-align: center;\n\tdisplay: table-cell;\n\tvertical-align: middle;\n\t\n}\n.sfsHeaderTitleTxtTheme{\n\tfont-family:Arial, Helvetica, sans-serif;\n\tfont-size:16px;\n\tfont-weight:bold;\n\tcolor:#ffffff;\n\ttext-shadow: 1px 1px 1px rgba(0, 0, 0, 1);\n} \n\n</style>\n</head>\n<body style=\"width: 100%; height: 100%;\">\n\t<form name=\'OrderSfsForm\' id=\'OrderSfsForm\' method=\'post\' id=\"OrderSfsForm\" action=\"RegisterOrderAddlSearchList.jsp\">\n\t\t<!-- <div class=\"sfs_header sfs_headerTheme\">\n\t\t\t<div class=\"sfsHeaderRibTheme\">\n\t\t\t\t<div class=\"sfsBtnTheme\" onclick=\"cancelSearch()\"> Cancel </div>\n\t\t\t\t<div class=\"sfsHeaderTitle\">\n\t\t\t\t\t<div class=\"sfsHeaderTitleTxtTheme sfsHeaderTitleTxt\">Additional Search</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"sfsBtnTheme\" onclick=\"\" id=\"AddlSearchButton\">Search</div>\n\t\t\t</div>\n\t\t</div> -->\n\t\t<div class=\"ipSearchHeader ipSearchHeaderTheme\" style=\"height:36px\">\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td style=\"width:100px\"><div class=\"ipSearchHeaderButtonTheme\" onclick=\"cancelSearch()\">Cancel</div></td>\n\t\t\t\t\t<td style=\"width:200px\"><div class=\"ipSearchHeaderTextTheme\">Order Category/Type</div></td>\n\t\t\t\t\t<td style=\"width:100px\"><div class=\"ipSearchHeaderButtonDisabledTheme\" onclick=\"\" id=\"AddlSearchButton\">Search</div></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div> \n\t\t<div class=\"ipSearchContainer ipSearchContainerTheme\" style=\"height:80%\">\n\n\t\t\t<div class=\"ipSearchItem ipSearchItemTheme\" id=\"OrderCategorySelection\" onclick=\"openSearchResults(\'OC\')\">\n\t\t\t\t<div class=\"ipSearchItemHeading ipSearchItemHeadingTheme\">Order Category</div>\n\t\t\t\t<div style=\"padding-left:7px\">\n\t\t\t\t\t<input type=\"text\" class=\"ipSearchItemTextbox ipSearchItemTextboxTheme\" name=\"OrdCategory\" id=\"OrdCategory\" id=\"OrdCategory\" placeholder=\"Select Order Category\" value =\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" readonly />\n\t\t\t\t</div>\t\t\n\t\t\t</div>\n\t\t\t<div class=\"ipSearchItem ipSearchItemTheme\" id=\"OrderTypeSelection\" onclick=\"\" style=\"opacity:0.5\">\n\t\t\t\t<div class=\"ipSearchItemHeading ipSearchItemHeadingTheme\">Order Type</div>\n\t\t\t\t<div style=\"padding-left:7px\">\n\t\t\t\t\t<input type=\"text\" class=\"ipSearchItemTextbox ipSearchItemTextboxTheme\" name=\"OrdType\" id=\"OrdType\" id=\"OrdType\" placeholder=\"Select Order Type\" value =\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" readonly />\n\t\t\t\t</div>\t\t\n\t\t\t</div>\n\t\t</div>\n\t\t\n\t\t<input type = \"hidden\" name =\"hdnOrderCategory\" id =\"hdnOrderCategory\" value =\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnOrderCategoryCode\" id =\"hdnOrderCategoryCode\" value =\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnOrderType\" id =\"hdnOrderType\" value =\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnOrderTypeCode\" id =\"hdnOrderTypeCode\" value =\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnSfsContext\" id =\"hdnSfsContext\" value =\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" />\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

String orderCategory = request.getParameter("hdnOrderCategory") == null?"":request.getParameter("hdnOrderCategory");
String orderCategoryCode = request.getParameter("hdnOrderCategoryCode") == null?"":request.getParameter("hdnOrderCategoryCode");
String orderType = request.getParameter("hdnOrderType") == null?"":request.getParameter("hdnOrderType");
String orderTypeCode = request.getParameter("hdnOrderTypeCode") == null?"":request.getParameter("hdnOrderTypeCode");
String sfsContext = request.getParameter("hdnSfsContext") == null?"":request.getParameter("hdnSfsContext");

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
            out.print( String.valueOf(orderCategory));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(orderType));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(orderCategory));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(orderCategoryCode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orderType));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(orderTypeCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sfsContext));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
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
