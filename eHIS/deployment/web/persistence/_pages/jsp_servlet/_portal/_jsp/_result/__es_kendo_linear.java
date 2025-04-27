package jsp_servlet._portal._jsp._result;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

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
        if (sci.isResourceStale("/portal/jsp/result/ES_Kendo_Linear.jsp", 1669269355937L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\r\n<!--\r\nCreated By: D. Sethuraman\r\nCreated Date: 21/01/2013\r\nUsed for: This page will be included to draw the Linear Gauge chart using Kendo Line Chart component.\r\nCalled from: CA module to display the Linear Gauge for the vitals, investigation results with one observations or result is available.\r\nThis page requires eleven parameters\r\n1. divID: String to be used as div ID for each line chart to be drawn.\r\n2. xAxisMin: Integer value to be used as minimum starting point of linear gauge \r\n3. xAxisMax: Integer value to be used as maximum point to be plotted in the linear gauge.\r\n4. rCriticalLow: Integer value to be used to point the range critical low value\r\n5. rNormalLow: Integer value to be used to point the range normal low value\r\n6. rNormalHigh: Integer value to be used to point the range normal high value\r\n7. rCriticalHigh: Integer value to be used to point the range critical high value\r\n8. rLowColor: String value to be used to display the range low color \r\n9. rNormalColor: String value to be used to point the range normal color\r\n10. rHighColor: String value to be used to point the range high color\r\n11. pValue: Integer value to be used to point the actual result value\r\n\r\nExample: \"../../eCA/jsp/ES_Kendo_Linear.jsp?divID=\"+divID+\"&xAxisMin=\"+xAxisMin+\"&xAxisMax=\"+xAxisMax+\"&rCriticalLow=\"+rCriticalLow+\"&rNormalLow=\"+rNormalLow+\"&rLowColor=\"+rLowColor+\"&rNormalHigh=\"+rNormalHigh+\"&rNormalColor=\"+rNormalColor+\"&rCriticalHigh=\"+rCriticalHigh+\"&rHighColor=\"+rHighColor+\"&pValue=\"+pValue;\r\n-->\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n\t\t\t<!--<div id=\"gauge-container-";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\">-->\r\n                <div id=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></div>\r\n            <!--</div>-->\r\n\r\n            <script>\r\n                \r\n\r\n                $(document).ready(function() {\r\n                    createGauge(\"#";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\",";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =", ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =", \"#";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\", ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =");\r\n\r\n                    $(\".configuration\").bind(\"change\", refresh);\r\n\r\n                    $(document).bind(\"kendo:skinChange\", function(e) {\r\n                        createGauge(\"#";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =");\r\n\t\t\t\t\t\trefresh();                        \r\n                    });\r\n\r\n                    window.configuredRanges = $(\"#";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\").data(\"kendoLinearGauge\").options.scale.ranges;\r\n                });\r\n\r\n                function refresh() {\r\n\t\t\t\t\t\r\n                    var gauge = $(\"#";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\").data(\"kendoLinearGauge\"),\r\n                        showLabels = $(\"#labels\").prop(\"checked\"),\r\n                        showRanges = $(\"#ranges\").prop(\"checked\"),\r\n                        isVertical = $(\"#vertical\").prop(\"checked\"),\r\n                        positionInputs = $(\"input[name=\'labels-position\']\"),\r\n                        options = gauge.options;\r\n\r\n                    options.transitions = false;\r\n                    options.scale.labels.visible = showLabels;\r\n                    options.scale.vertical = isVertical;\r\n                    options.scale.ranges = showRanges ? window.configuredRanges : [];\r\n\t\t\t\t\t\r\n                    $(\"#gauge-container-";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\").toggleClass(\"horizontal\", 1);\r\n\r\n                    gauge.redraw();\r\n                }\t\t\t\t\r\n            </script>\r\n\r\n            <style>\r\n                #gauge-container-";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" {\r\n                    text-align: center;\r\n                    margin-left: 30px;\r\n\t\t\t\t\tbackground: transparent url(\"../../images/linear-gauge-container-h.png\") no-repeat 50% 50%;                   \r\n                    padding: 18px;\r\n                    width: 300px;\r\n                    height: 300px;\r\n                }\r\n\r\n                #gauge-container.horizontal {\r\n                    background-image: url(\"../../images/linear-gauge-container-h.png\");\r\n                }\r\n\r\n                #";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" {\r\n\t\t\t\t\ttext-align: \"left\";\r\n                    width: 400px;\r\n                    height: 50px;   \t\t\t\t\t\r\n                }\r\n            </style>\r\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);

	int  xAxisMin=0, xAxisMax=0, rCriticalLow=0, rNormalLow=0, rNormalHigh=0, rCriticalHigh=0, pValue=0;
	int majorUnit=0,minorUnit=0;
	String divID="", rLowColor="", rNormalColor="", rHighColor="";

	divID = request.getParameter("divID");	
	
	xAxisMin = Integer.parseInt(request.getParameter("xAxisMin"));
	xAxisMax = Integer.parseInt(request.getParameter("xAxisMax"));
	rCriticalLow = Integer.parseInt(request.getParameter("rCriticalLow"));
	rNormalLow = Integer.parseInt(request.getParameter("rNormalLow"));
	rNormalHigh = Integer.parseInt(request.getParameter("rNormalHigh"));
	rCriticalHigh = Integer.parseInt(request.getParameter("rCriticalHigh"));
	rLowColor = request.getParameter("rLowColor");
	rNormalColor = request.getParameter("rNormalColor");
	rHighColor = request.getParameter("rHighColor");
	pValue = Integer.parseInt(request.getParameter("pValue"));
	majorUnit = Integer.parseInt(request.getParameter("majorUnit"));
	minorUnit = Integer.parseInt(request.getParameter("minorUnit"));
	

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(pValue));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(xAxisMin));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(xAxisMax));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rCriticalLow));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rNormalLow));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rLowColor));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rNormalLow));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rNormalHigh));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rNormalColor));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rNormalHigh));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rCriticalHigh));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rHighColor));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(majorUnit));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(minorUnit));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(pValue));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(xAxisMin));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(xAxisMax));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rCriticalLow));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rNormalLow));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rLowColor));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rNormalLow));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rNormalHigh));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rNormalColor));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rNormalHigh));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rCriticalHigh));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rHighColor));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(majorUnit));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(minorUnit));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
