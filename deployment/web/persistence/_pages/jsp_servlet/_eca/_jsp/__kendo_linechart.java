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

public final class __kendo_linechart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/Kendo_LineChart.jsp", 1738424864374L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="  \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<script src=\"../../eCA/Kendo/js/kendo.all.min.js\"  type=\"text/javascript\"></script>\n\t\t<script src=\"../../eCA/js/KendoChart.js\"  type=\"text/javascript\"></script>\n\t\t<link href=\"../../eCA/Kendo/styles/kendo.common.min.css\" rel=\'stylesheet\' />\n\t\t<link href=\"../../eCA/Kendo/styles/kendo.default.min.css\" rel=\'stylesheet\' />\n\n\t\t\t\n        <div id=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"></div>\n            \n\t\t\t\n            <script>             \n\n                $(document).ready(\n                   function() {\n                        // Initialize the chart with a delay to make sure\n                        // the initial animation is visible\n                        createChart(\"#";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\",\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\",";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =",";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =",\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\n\t\t\t\t\t\t/*\n                        $(\"#example\").bind(\"kendo:skinChange\", function(e) {\n                            createChart(\"#";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");\t\n                        });\n\t\t\t\t\t\t*/\n                    }\n\n                   \n                );\n\n                \n                \n            </script>\n            <style>                \n\t\t\t\t#";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" {\n\t\t\t\t\ttext-align: \"left\";\n                    width: ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="px;\n                    height: ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="px;   \t\t\t\t\t\n                }\n            </style>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005-US001
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String divID="";
	int chartWidth=0,chartHeight=0;
	int  yAxisMin=0, yAxisMax=0;
	String xAxisDataType="", yAxisDataType="";
	String xAxisTitle="", yAxisTitle="";
	String splitRange ="";
	String valuesRange ="";
	String legendName = "";
	
	divID = request.getParameter("divID");	
	yAxisMin = request.getParameter("yAxisMin") == null ? 0 :  Integer.parseInt(request.getParameter("yAxisMin"));		
	yAxisMax = request.getParameter("yAxisMax") == null ? 200 :  Integer.parseInt(request.getParameter("yAxisMax"));
	xAxisDataType = request.getParameter("xAxisDataType");
	yAxisDataType = request.getParameter("yAxisDataType");
	splitRange = request.getParameter("splitRange");
	valuesRange = request.getParameter("valuesRange");
	legendName	= request.getParameter("legendName") == null ? "" :  (String)request.getParameter("legendName");
	chartWidth = request.getParameter("chartWidth") == null ? 100 : Integer.parseInt(request.getParameter("chartWidth"));		
	chartHeight = request.getParameter("chartHeight") == null ? 200 : Integer.parseInt(request.getParameter("chartHeight"));
	
	xAxisTitle	=request.getParameter("xAxisTitle")== null ? "" : (String) request.getParameter("xAxisTitle");
	yAxisTitle	= request.getParameter("yAxisTitle")== null ? "" : (String) request.getParameter("yAxisTitle");


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(legendName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( yAxisMin));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( yAxisMax));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(xAxisTitle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(yAxisTitle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( xAxisDataType));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( yAxisDataType));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( splitRange));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( valuesRange));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( divID));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(legendName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( yAxisMin));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( yAxisMax));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(xAxisTitle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(yAxisTitle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( xAxisDataType));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( yAxisDataType));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( splitRange));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( valuesRange));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(chartWidth));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(chartHeight));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
