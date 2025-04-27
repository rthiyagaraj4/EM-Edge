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

public final class __es_kendo_linear_tag extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ES_Kendo_Linear_tag.jsp", 1738424784281L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nCreated By: D. Sethuraman\nCreated Date: 21/01/2013\nUsed for: This page will be included to draw the Linear Gauge chart using Kendo Line Chart component.\nCalled from: CA module to display the Linear Gauge for the vitals, investigation results with one observations or result is available.\nThis page requires eleven parameters\n1. divID: String to be used as div ID for each line chart to be drawn.\n2. xAxisMin: Integer value to be used as minimum starting point of linear gauge \n3. xAxisMax: Integer value to be used as maximum point to be plotted in the linear gauge.\n4. rCriticalLow: Integer value to be used to point the range critical low value\n5. rNormalLow: Integer value to be used to point the range normal low value\n6. rNormalHigh: Integer value to be used to point the range normal high value\n7. rCriticalHigh: Integer value to be used to point the range critical high value\n8. rLowColor: String value to be used to display the range low color \n9. rNormalColor: String value to be used to point the range normal color\n10. rHighColor: String value to be used to point the range high color\n11. pValue: Integer value to be used to point the actual result value\n\nExample: \"../../eCA/jsp/ES_Kendo_Linear.jsp?divID=\"+divID+\"&xAxisMin=\"+xAxisMin+\"&xAxisMax=\"+xAxisMax+\"&rCriticalLow=\"+rCriticalLow+\"&rNormalLow=\"+rNormalLow+\"&rLowColor=\"+rLowColor+\"&rNormalHigh=\"+rNormalHigh+\"&rNormalColor=\"+rNormalColor+\"&rCriticalHigh=\"+rCriticalHigh+\"&rHighColor=\"+rHighColor+\"&pValue=\"+pValue;\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\t\n\t\t<link href=\"../../eCA/Kendo/styles/kendo.common.min.css\" rel=\'stylesheet\' />\n\t\t<link href=\"../../eCA/Kendo/styles/kendo.default.min.css\" rel=\'stylesheet\' />\n\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<script src=\"../../eCA/Kendo/js/kendo.all.min.js\"  type=\"text/javascript\"></script>\n\n<!--<div id=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"></div>-->      \n<div id=\"gauge-container\">\n\t<kendo:linearGauge name=\"gauge\">\n\t\t<kendo:linearGauge-pointer value=\"28\" />\n\t\t<kendo:linearGauge-scale minorUnit=\"2\" majorUnit=\"20\" min=\"-40\" max=\"60\">\n\t\t\t<kendo:linearGauge-scale-ranges>\n\t\t\t\t<kendo:linearGauge-scale-range from=\"-40\" to=\"-20\" color=\"#2798df\" />\n\t\t\t\t<kendo:linearGauge-scale-range from=\"30\" to=\"45\" color=\"#ffc700\" />\n\t\t\t\t<kendo:linearGauge-scale-range from=\"45\" to=\"60\" color=\"#c20000\" />\n\t\t\t</kendo:linearGauge-scale-ranges>\n\t\t</kendo:linearGauge-scale>\n\t</kendo:linearGauge>\n</div>          \n\n<style>\n\t\t#gauge-container {\n        \tbackground: transparent url(\"../../eCA/Kendo/gauge/linear-gauge-container-h.png\") no-repeat 50% 50%;\n            padding: 18px;\n            width: 300px;\n            height: 300px;\n            text-align: center;\n            margin: 0 auto;\n        }\n\n        #gauge {\n            height: 300px;\n            display: inline-block;\n            *display: inline;\n            zoom: 1;\n        }\n\n</style>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	int  xAxisMin=0, xAxisMax=0, rCriticalLow=0, rNormalLow=0, rNormalHigh=0, rCriticalHigh=0, pValue=0;
	String divID="", rLowColor="", rNormalColor="", rHighColor="";
	String splitRange = "";	
	
	divID = request.getParameter("divID");
	
	xAxisMin = Integer.parseInt(request.getParameter("xAxisMin"));
	xAxisMax = Integer.parseInt(request.getParameter("xAxisMax"));	
	
	splitRange = request.getParameter("splitRange");

	System.out.println(" - - inside ES_Kendo_Linear - - "+splitRange);	
	/*
	rCriticalLow = Integer.parseInt(request.getParameter("rCriticalLow"));
	rNormalLow = Integer.parseInt(request.getParameter("rNormalLow"));
	rNormalHigh = Integer.parseInt(request.getParameter("rNormalHigh"));
	rCriticalHigh = Integer.parseInt(request.getParameter("rCriticalHigh"));
	rLowColor = request.getParameter("rLowColor");
	rNormalColor = request.getParameter("rNormalColor");
	rHighColor = request.getParameter("rHighColor");
	*/
	pValue = Integer.parseInt(request.getParameter("pValue"));	
	

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
