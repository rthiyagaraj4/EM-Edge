package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __linechart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/LineChart.jsp", 1738426208231L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n   <meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n   <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n   <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/css/kendo.dataviz.min.css\" />\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n   <script src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/kendo.dataviz.min.js\"></script>\n   <script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/console.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n   \n   <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/iPADThemeA.css\" />\n   <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/iPADNew.css\" />\n   <style>\n   \n\n   </style>\n   <script>\n   var xAxis = [];\n   var yAxis = [];\n   var normalLow = 0;\n   var normalHigh = 0;\n   var valueAxisTitle = \"\";\n   document.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n   function setYAxisTitle()\n   {\n\t   var tempTitle = $(\'#hdnVT\').val();\n\t   if(tempTitle != null && tempTitle != \"\"){\n\t\t   valueAxisTitle = \"Values in \" + tempTitle;\n\t   }\n   }\n   function setNormalValues()\n   {\n\t   var nl = $(\'#hdnNL\').val();\n\t   var nh = $(\'#hdnNH\').val();\n\t   if(nl != null && nl != \"\" && nh != null && nh != \"\")\n\t\t {\n\t\t     normalLow = parseInt(nl);\n\t\t     normalHigh = parseInt(nh);\n\t\t  }\n   }\n   function createChart() {\n\t   var scatterChartData = [];\n\t   for(i=0;i<xAxis.length;i++){\n\t\t   var xyPair = [new Date(xAxis[i]),yAxis[i]];\n\t\t   scatterChartData.push(xyPair);\n\t   }\n\t   //alert(scatterChartData);\n\n       $(\"#lineChart\").kendoChart({\n           title: {\n               text: \"\"\n           },\n           legend: {\n               position: \"bottom\"\n           },\n           chartArea: {\n               background: \"\"\n           },\n           seriesDefaults: {\n               \n               style: \"smooth\"\n           },\n           series: [{\n        \t   type: \"scatterLine\",\n        \t   data: scatterChartData,\n        \t   \n        \t   markers: {\n                   size: 10\n               }\n                \n           }],\n           valueAxis: {\n               labels: {\n                   format: \"{0:d}\" \n               },\n               title: {\n            \t      text: valueAxisTitle ,\n            \t      font: \"12px Arial\",\n            \t      rotation: -90\n            \t    },\n              \n               line: {\n                   visible: false\n               },\n               axisCrossingValue: -10\n           },\n           categoryAxis: {\n        \t   labels: {\n        \t\t      rotation: 95\n        \t\t    },\n                \n               axisCrossingValue: -10,\n               baseUnitStep: \"auto\",\n             \n\n               majorGridLines: {\n                   visible: false\n               }\n           },\n           xAxis: {\n        \t    type: \"date\",\n        \t    baseUnit: \"days\",\n        \t    labels: {\n        \t        dateFormats: {\n        \t          days: \"MMM-d\"\n        \t        }\n        \t      }\n\t\t  },\n          yAxis: {\n        \t   \n                plotBands: [\n                          { from: normalLow, \n                        \t  to: normalHigh , \n                        \t  color: \"Green\", \n                        \t  opacity: 0.4 }\n                        ]\n              },\n           tooltip: {\n               visible: true,\n               format: \"Date:{0:dd-MMM-yy HH:mm}<br>Value:{1}\",\n           }\n       });\n   }\n   $(document).ready(function () {\n\t  \n\t  // alert(yAxis);\n\t  \n\t  \n\t  try\n\t  {\n\t\t   xAxis = window.parent.getXAxis();\n\t\t   yAxis = window.parent.getYAxis();\n\t\t   setNormalValues();\t\n\t\t   setYAxisTitle();\n\t       createChart();\n\t  }\n\t  catch(e)\n\t  {\n\t\t  alert(e);\n\t  }\n   });\n   function closeLineChart()\n   {\n\t   window.parent.closeLineChart();\n   }\n   function navigatePage(action)\n   {\n\t \n\t //  alert(\"hi\");\n\t /*\n\t alert(action);\n\t   var selectedRecord = $(\'#hdnSelectedRecord\').val();\n\t   //if(isNaN(selectedRecord))\n\t\t //  {\n\t\t       alert(\"sele\");\n\t\t   \t\tvar rowCount = parseInt(selectedRecord);\n\t\t   \t\tif(action == \"Next\")\n\t\t   \t\t{\n\t\t   \t\t\trowCount = rowCount + 1;\t\n\t\t   \t\t}\n\t\t   \t\telse\n\t\t   \t\t\t{\n\t\t   \t\t  rowCount = rowCount - 1;\t\n\t\t   \t\t\t}\n\t\t   \t\twindow.parent.paginateLineChart(rowCount) ;\n\t\t//   }\n\t   */\n\t   var eventCode = $(\'#hdnEventCode\').val();\n\t   window.parent.paginateLineChart(eventCode,action);\n\t \n\t   \n   }\n   </script>\n</head>\n<body style = \"padding :0px;display : block;margin: 0px; height: 100%; width: 100%;\">\n\t<div id=\"divParent\" class=\"divParent\" data-role=\"page\" style=\"padding: 0px\">\n\t\t<div data-role = \"none\" class = \"lineChartTitle\" onclick = \"closeLineChart()\">\n\t\t\t<div data-role = \"none\" class = \"graphTitle\">\n\t\t\t\t<div data-role = \"none\" class = \"dvTitle\"> ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="(";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =") </div>\n\t\t\t</div>\n\t\t\t<div data-role = \"none\" class = \"graphCloseButtonArea\">\n\t\t\t\t<div data-role = \"none\" class = \"graphCloseButton graphCloseButtonTheme\">\n\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/Close10x10.PNG\" style = \"position:relative;margin-top:3px;margin-left : 5px\"></img>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t<div data-role = \"none\" class = \"graphContainer\">\n\t\t\t\n\t\t\t<div data-role = \"none\" class = \"graphArea\">\n\t\t\t   <div data-role = \"none\" class = \"navigateIconsContainer\" onclick = \"navigatePage(\'Previous\')\">\n\t\t\t\t<div data-role = \"none\" class = \"navigateIcons\">\n\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/ChartLeftArrow.PNG\" ></img>\n\t\t\t\t</div>\n\t\t\t  </div>\n\t\t\t\t<div data-role = \"none\" class = \"lineChartArea\">\n\t\t\t\t\t<div data-role = \"none\" id = \"lineChart\"></div>\n\t\t\t\t</div>\n\t\t\t  <div data-role = \"none\" class = \"navigateIconsContainer\" onclick = \"navigatePage(\'Next\')\">\n\t\t\t\t<div data-role = \"none\" class = \"navigateIcons\">\n\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/ChartRightArrow.PNG\" ></img>\n\t\t\t\t</div>\n\t\t\t </div>\n\t\t\t\t\n\t\t\t</div>\n\t\t\t\n\t\t</div>\n\t\t<div data-role = \"none\" class = \"graphFooter\">\n\t      ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t  <div data-role = \"none\" class = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" style = \"margin-bottom : 5px\"></div>\n\t\t\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</div>\n\t</div>\n\t<input  type = \"hidden\" name = \"hdnSelectedRecord\" id = \"hdnSelectedRecord\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n\t<input  type = \"hidden\" name = \"hdnTotalRecords\" id = \"hdnTotalRecords\" value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n\t<input  type = \"hidden\" name = \"hdnEventCode\" id = \"hdnEventCode\" value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\n\t<input  type = \"hidden\" name = \"hdnNL\" id = \"hdnNL\" value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/>\n\t<input  type = \"hidden\" name = \"hdnNH\" id = \"hdnNH\" value = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\n\t<input type = \"hidden\" name = \"hdnVT\" id = \"hdnVT\" value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" />\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block0Bytes, _wl_block0);

	String selectedRecord = "" ;
    String totalRecords = "" ;
    String eventCode = "";
    String desc = "";
    String normalLow = "";
    String normalHigh = "";
    String yAxisTitle = "";
    int currentPageNumber = 0;
    int nTotalRecords = 0;
    
    
    if(request.getParameter("SR") != null)
    {
    	selectedRecord = request.getParameter("SR");
    }
    if(request.getParameter("TR") != null)
    {
    	totalRecords = request.getParameter("TR");
    	if(!request.getParameter("TR").equals(""))
    	{
    		try
    		{
    			nTotalRecords = Integer.parseInt(request.getParameter("TR"));
    		}
    		catch(Exception e)
    		{
    			nTotalRecords = 0;
    		}
    	}
    }
    if(request.getParameter("SEC") != null)
    {
    	eventCode = request.getParameter("SEC");
    }
    if(request.getParameter("NL") != null)
    {
    	normalLow = request.getParameter("NL");
    }
    if(request.getParameter("NH") != null)
    {
    	normalHigh = request.getParameter("NH");
    }
    if(request.getParameter("DESC") != null)
    {
    	desc = request.getParameter("DESC");
    }
    if(request.getParameter("TI") != null)
    {
    	yAxisTitle = request.getParameter("TI");
    }
    if(request.getParameter("PNO") != null && !request.getParameter("PNO").equals(""))
    {
    	try
    	{
    		currentPageNumber = Integer.parseInt(request.getParameter("PNO"));
    	}
    	catch(Exception e)
    	{
    		currentPageNumber = 0;
    	}
    }

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(desc ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(yAxisTitle ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);

	      int nCount =0;
		  String className = "normalPageIcons";
		  for(nCount = 0 ; nCount < nTotalRecords; nCount ++)
		  {
			  if(nCount == currentPageNumber)
			  {
				  className = "selectedPageIcons";
			  }
			  
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(className));
            _bw.write(_wl_block14Bytes, _wl_block14);
 
			  className = "normalPageIcons";
		  }
	      
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(selectedRecord));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(eventCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(normalLow));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(normalHigh));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(yAxisTitle ));
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
