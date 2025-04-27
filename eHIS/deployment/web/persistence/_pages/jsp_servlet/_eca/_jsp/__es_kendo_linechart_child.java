package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __es_kendo_linechart_child extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ES_Kendo_LineChart_Child.jsp", 1738424815507L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nCreated By: D. Sethuraman \nCreated Date: 21/01/2013\nUsed for: This page will be included to draw the line chart using Kendo Line Chart component.\nCalled from: CA module to display the line chart for the vitals, investigation results when more than one observations or results are available.\nThis page requires Seven parameters \n1. divID: To be used as div ID for each line chart to be drawn.\n2. yAxisMin: Integer value of Y-Axis minimum\n3. yAxisMax: Integer Value of Y-Axis Maximum\n4. xAxisdataType: String Data of X-Axis data type\n5. yAxisdataType: String Data of Y-Axis data type\n6. splitRange: String value contains the ranges (From, To and Color).\n7. valuesRange: String value contains the ranges (xAxis and yAxis values).\n\nExample: \"../../eCA/jsp/ES_Kendo_LineChart_Child.jsp?divID=\"+divID+\"&yAxisMin=\"+yAxisMin+\"&yAxisMax=\"+yAxisMax+\"&xAxisDataType=\"+xAxisDataType+\"&yAxisDataType=\"+yAxisDataType+\"&splitRange=\"+splitRange+\"&valuesRange=\"+valuesRange;\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\n\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\"../../eCA/Kendo/js/kendo.all.min.js\"  type=\"text/javascript\"></script>\n<script src=\"../../eCA/js/ES_Kendo.js\"  type=\"text/javascript\"></script>\n<link href=\"../../eCA/Kendo/styles/kendo.common.min.css\" rel=\'stylesheet\' />\n<link href=\"../../eCA/Kendo/styles/kendo.default.min.css\" rel=\'stylesheet\' />\n\n<div id=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"></div>\n<script>             \n\t\n\t$(document).ready(function() {\n\t\tsetTimeout(function() {\n\t\t\t// Initialize the chart with a delay to make sure\n\t\t\t// the initial animation is visible\n\t\t\tcreateChart(\"#";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\",";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =",";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =",\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\",\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\n\t\t\t\n\n\t\t\t$(\"#example\").bind(\"kendo:skinChange\", function(e) {\n\t\t\t\tcreateChart(\"#";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");\t\n\t\t\t});\n\t\t}, 800);\n\n\t\t$(\".configuration\").bind(\"change\", refresh);\n\t});\n\t\n\tfunction refresh() {\n\t\tvar chart = $(\"#";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\").data(\"kendoChart\"),\n\t\t\tseries = chart.options.series,\n\t\t\tcategoryAxis = chart.options.categoryAxis,\n\t\t\tbaseUnitInputs = $(\"input:radio[name=baseUnit]\"),\n\t\t\taggregateInputs = $(\"input:radio[name=aggregate]\");\n\n\t\tfor (var i = 0, length = series.length; i < length; i++) {\n\t\t\tseries[i].aggregate = aggregateInputs.filter(\":checked\").val();\n\t\t};\n\n\t\tcategoryAxis.baseUnit = baseUnitInputs.filter(\":checked\").val();\n\n\t\tchart.refresh();\n\t}\n\t$(window).load(function() {\t\t\n\t\tsetTimeout(function() {\n\t\t\tparent.printPage();\n\t\t}, 1000);\n\t});\n</script>\n\n\n\n\n\t<style>                \n\t\t#";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" {\n\t\t\ttext-align: \"left\";\n\t\t\twidth: 400px;\n\t\t\theight: 232px;   \t\t\t\t\t\n\t\t}\n\t</style>\n\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String divID="";
	//int  yAxisMin=0, yAxisMax=0;
	double  yAxisMin=0.0, yAxisMax=0.0;
	String xAxisDataType="", yAxisDataType="";
	String splitRange ="";
	String valuesRange ="";

	divID = request.getParameter("divID");	
	//yAxisMin = Integer.parseInt(request.getParameter("yAxisMin"));		
	//yAxisMax = Integer.parseInt(request.getParameter("yAxisMax"));
	yAxisMin = Double.parseDouble(request.getParameter("yAxisMin"));		
	yAxisMax = Double.parseDouble(request.getParameter("yAxisMax"));
	System.out.println(" ::: yAxisMin ::: "+yAxisMin+" :::: yAxisMax :::: "+yAxisMax);
	xAxisDataType = request.getParameter("xAxisDataType");
	yAxisDataType = request.getParameter("yAxisDataType");
	System.out.println(" ::: xAxisDataType ::: "+xAxisDataType+" :::: yAxisDataType :::: "+yAxisDataType);
	splitRange = request.getParameter("splitRange");
	System.out.println(" ::: splitRange ::: "+splitRange);
	splitRange = splitRange.replace('>', '#');	
	valuesRange = request.getParameter("valuesRange");
	
	System.out.println(" ::: splitRange ::: "+splitRange+" ::: valuesRange ::: "+valuesRange);


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( yAxisMin));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( yAxisMax));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( xAxisDataType));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( yAxisDataType));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( splitRange));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( valuesRange));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( yAxisMin));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( yAxisMax));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( xAxisDataType));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( yAxisDataType));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( splitRange));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( valuesRange));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
