package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.results.request.ResultsCatConstants;
import java.util.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Locale;
import eIPAD.chartsummary.results.request.ResultsCatConstants;

public final class __resultsview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ResultsView.jsp", 1709118024959L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<script>\nvar path;\n$(document).ready(function(){\n\t\n\tpath = $(\'#hdnPath\').val();\n\t\n\t$(\"#resultDataFrame\").load( path + \"/mobile/chartsummary/ResultsDataView?Category=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\",function(){\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n});\nfunction openChartsView(){\n\t\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.location.replace( path + \'/mobile/chartsummary/ResultsChartView\');\n}\n\nfunction showResultsOf(cat, widObj){\n\t$(\"#resultDataFrame\").empty();\n\t$(\"#resultDataFrame\").load( path + \"/mobile/chartsummary/ResultsDataView?Category=\"+cat,function(){\n\t\tscrollerRefresh(CSMainScroll);\n\t});\n\t$(\".widgetResTab\").each(function(i){\n\t\t$(this).removeClass(\"widgetTabActiveTheme\").addClass(\"widgetTabNonActiveTheme\").addClass(\"widgetTabNonActive\");\n\t\t$(widObj).removeClass(\"widgetTabNonActiveTheme\").removeClass(\"widgetTabNonActive\").addClass(\"widgetTabActiveTheme\");\n\t})\n}\n\n\n</script>\n<style>\n\n#PageLoadingAnimation{\n\tz-index: 10000;\n\tposition: absolute;\n\tleft: 0px;\n\ttop: 0px;\n\twidth: 100%;\n\theight: 100%;\n\tbackground-color: #808080;\n\topacity: 0.6;\n\tbackground-image: url(";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tdisplay: none; \n}\n\n\n\n</style>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<div id=\"PageLoadingAnimation\" > </div>\n\t<div class=\"widgetParent widgetParentTheme\" data-role = \"none\">\n<!-- \t<form id=\"AllergyWidgetForm\" class=\"AllergyWidgetForm\" action=\"\" method=\"post\" name=\"AllergyWidgetForm\" id=\"AllergyWidgetForm\"> -->\n\t\t<div class=\"widgetTable\" data-role = \"none\">\n\t\t\t<div class=\"widgetHeaderRow widgetHeaderRowTheme\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderMarginExtn widgetHeaderMarginExtnTheme\" data-role = \"none\"></div>\n\t\t\t\t\t<div class=\"widgetHeaderIcontriangle\" data-role = \"none\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetHeaderCell widgetHeaderCellTheme\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderSubTable\" data-role = \"none\">\n\t\t\t\t\t\t<div class=\"widgetHeaderSubRow\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"widgetHeaderIconCol1\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"widgetHeaderIconButton widgetHeaderIconButtonTheme\" data-role = \"none\"><img src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/images/CS_Allergies.PNG\" class=\"widgetHeaderButtonImage\"></div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t\t<div class=\"widgetHeaderHeadingTextCol\" data-role = \"none\"><span class=\"widgetHeaderHeadingTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span> <input type=\"button\" class=\"widgetHeaderCountButtonTheme\" id=\"resultsViewCount\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></div>\n\t\t\t\t\t\t\t<div class=\"widgetHeaderPlusButtonCell\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"openChartsView()\"><img src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/images/Chart11.png\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\n\n\t\t\t<div class=\"widgetContentRow\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetContentCell widgetContentCellTheme\" data-role = \"none\">\n\t\t\t\t\t<div style=\"display:table;width:100%;text-align: -webkit-center;\">\n\t\t\t\t\t\t<div style=\"display:table-row\" class=\"\">\n\t\t\t\t\t\t\t<div style=\"display:table-cell\" class=\"widgetTabBckgrndTheme\"><!-- Tab container -->\n\t\t\t\t\t\t\t\t<div class=\"\" style=\"display:table;margin-top:10px\">\n\t\t\t\t\t\t\t\t\t<div class=\"widgetleftview\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:48%\"><!-- Empty area -->\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\" class=\"widgetTabActiveTheme widgetTab widgetResTab\" onclick=\"showResultsOf(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',this)\"><!-- Individual tabs -->\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"widgetItemTxt\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" (";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\" class=\"widgetTabNonActiveTheme widgetTabNonActive widgetTab widgetResTab\" onclick=\"showResultsOf(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:48%\"><!-- Empty area -->\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t<div style=\"display:table-cell\"><!-- Results data frame container -->\n\t\t\t\t\t\t\t\t<div src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/mobile/chartsummary/ResultsDataView?Category=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" style=\"border:0;height:auto;width:100%;overflow:auto;min-height:50px;background:#ffffff\" id=\"resultDataFrame\"></iframe>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t\n\t\t\t\n\t\t</div>\n<!-- \t</form>  -->\n\t</div>\n\t\n\t\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(ResultsCatConstants.RESULTCATEGORY_LABORATORY ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);

int allCount = request.getAttribute("AllCount")==null?0:(Integer)request.getAttribute("AllCount");
int labCount = request.getAttribute("LabCount")==null?0:(Integer)request.getAttribute("LabCount");
int radCount = request.getAttribute("RadCount")==null?0:(Integer)request.getAttribute("RadCount");
int surgCount = request.getAttribute("SurgCount")==null?0:(Integer)request.getAttribute("SurgCount");
int diagCount = request.getAttribute("DiagCount")==null?0:(Integer)request.getAttribute("DiagCount");
int othersCount = request.getAttribute("OthersCount")==null?0:(Integer)request.getAttribute("OthersCount");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(csResBundle.getString("results.results") ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(allCount));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ResultsCatConstants.RESULTCATEGORY_LABORATORY));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(csResBundle.getString("results.laboratory") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(labCount ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ResultsCatConstants.RESULTCATEGORY_RADIOLOGYIMAGING));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(csResBundle.getString("results.radiology") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(radCount ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ResultsCatConstants.RESULTCATEGORY_SURGERYPROCEDURE));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(csResBundle.getString("results.surgery") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(surgCount ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ResultsCatConstants.RESULTCATEGORY_DEPTDIAGNOSTICS));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(csResBundle.getString("results.deptdiagnostics") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(diagCount ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ResultsCatConstants.RESULTCATEGORY_OTHERS));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(csResBundle.getString("results.others") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(othersCount ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ResultsCatConstants.RESULTCATEGORY_OTHERS));
            _bw.write(_wl_block15Bytes, _wl_block15);
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
