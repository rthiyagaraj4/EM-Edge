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

public final class __es_kendo_linear extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ES_Kendo_Linear.jsp", 1738424778283L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nCreated By: D. Sethuraman \nCreated Date: 21/01/2013\nUsed for: This page will be included to draw the Linear Gauge chart using Kendo Line Chart component.\nCalled from: CA module to display the Linear Gauge for the vitals, investigation results with one observations or result is available.\nThis page requires five parameters\n1. divID: String to be used as div ID for each line chart to be drawn.\n2. xAxisMin: Integer value to be used as minimum starting point of linear gauge. \n3. xAxisMax: Integer value to be used as maximum point to be plotted in the linear gauge.\n4. splitRange: String value contains the ranges (From, To and Color).\n5. pValue: Integer value to be used to point the actual result value.\n\nExample: \"../../eCA/jsp/ES_Kendo_Linear.jsp?divID=\"+divID+\"&xAxisMin=\"+xAxisMin+\"&xAxisMax=\"+xAxisMax+\"&splitRange=\"+splitRange+\"&pValue=\"+pValue;\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\"../../eCA/Kendo/js/kendo.all.min.js\"  type=\"text/javascript\"></script>\n<script src=\"../../eCA/js/ES_Kendo.js\"  type=\"text/javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link href=\"../../eCA/Kendo/styles/kendo.common.min.css\" rel=\'stylesheet\' />\n<link href=\"../../eCA/Kendo/styles/kendo.default.min.css\" rel=\'stylesheet\' />\n<body>\t\t\t\n<div id=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"></div>           \n\n<script>\n           \n\t$(document).ready(function() {\t\n\t\tsetTimeout(function() {\n\t\t\tcreateBar(\"#";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\",";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =", ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =", \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\");\n\t\t}, 400);\n        $(\".configuration\").bind(\"change\", refresh);\n    });\n\n\t\n    function refresh() {\t\t\t\t\t\n        var gauge = $(\"#";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\").data(\"kendoLinearGauge\"),\n            showLabels = $(\"#labels\").prop(\"checked\"),\n            showRanges = $(\"#ranges\").prop(\"checked\"),\n            isVertical = $(\"#vertical\").prop(\"checked\"),\n            positionInputs = $(\"input[name=\'labels-position\']\"),\n            options = gauge.options;\n\n        options.transitions = false;\n        options.scale.labels.visible = showLabels;\n        options.scale.vertical = isVertical;\n        options.scale.ranges = showRanges ? window.configuredRanges : [];\n\n        $(\"#gauge-container-";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\").toggleClass(\"horizontal\", 1);\n\n        gauge.refresh();\t\t\t\t\t\n    }\t\n    \n    $(window).load(function() {\t\t\n\t\tsetTimeout(function() {\n\t\t\tparent.printPage();\n\t\t}, 1000);\n\t});\n\n</script>\n\n<style>               \n\t#";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" {\n\t\ttext-align: \"left\";\n        width: 400px;\n        height: 50px;   \t\t\t\t\t\n    }\t\t\t\t\n</style>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
	//int  xAxisMin=0, xAxisMax=0, rCriticalLow=0, rNormalLow=0, rNormalHigh=0, rCriticalHigh=0, pValue=0;
	double  xAxisMin=0.0, xAxisMax=0.0, rCriticalLow=0.0, rNormalLow=0.0, rNormalHigh=0.0, rCriticalHigh=0.0, pValue=0.0;
	String divID="", rLowColor="", rNormalColor="", rHighColor="";
	String splitRange = "";	
	String strPValue = "";
	
	divID = request.getParameter("divID");	
	//xAxisMin = Integer.parseInt(request.getParameter("xAxisMin"));
	//xAxisMax = Integer.parseInt(request.getParameter("xAxisMax"));	
	
	xAxisMin = Double.parseDouble(request.getParameter("xAxisMin"));
	xAxisMax = Double.parseDouble(request.getParameter("xAxisMax"));
	
	splitRange = request.getParameter("splitRange");
	splitRange = splitRange.replace('>', '#');
	//pValue = Integer.parseInt(request.getParameter("pValue"));
	strPValue = request.getParameter("pValue");
	

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(strPValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(xAxisMin));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(xAxisMax));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(splitRange));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
