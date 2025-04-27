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

public final class __es_kendo_linechart_head extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ES_Kendo_LineChart_Head.jsp", 1738424821043L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nCreated By: D. Sethuraman\nCreated Date: 21/01/2013\nUsed for: This page will be included to draw the line chart using Kendo Line Chart component.\nCalled from: CA module to display the line chart for the vitals, investigation results when more than one observations or results are available.\nThis page requires Seven parameters \n1. divID: To be used as div ID for each line chart to be drawn.\n2. yAxisMin: Integer value of Y-Axis minimum\n3. yAxisMax: Integer Value of Y-Axis Maximum\n4. xAxisdataType: String Data of X-Axis data type\n5. yAxisdataType: String Data of Y-Axis data type\n6. splitRange: String value contains the ranges (From, To and Color).\n7. valuesRange: String value contains the ranges (xAxis and yAxis values).\n\nExample: \"../../eCA/jsp/ES_Kendo_LineChart_Head.jsp?divID=\"+divID+\"&yAxisMin=\"+yAxisMin+\"&yAxisMax=\"+yAxisMax+\"&xAxisDataType=\"+xAxisDataType+\"&yAxisDataType=\"+yAxisDataType+\"&splitRange=\"+splitRange+\"&valuesRange=\"+valuesRange;\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<table class=\"breakTableLC\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=450px height=250px>\n\t<tbody>\n\t\t<tr class=\"breakTrLC\">\n\t\t\t<td style=\"text-align: left\" valign=\"top\">\n\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\n\t\t\t\t<table  class=\"breakTable\" valign=\"top\" align=\"left\" border=\"0\" width=400px height=200px>\n\t\t\t\t\t<tbody>\n\t\t\t\t\t\t<tr class=\"breakTrLC\">\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</tbody>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</tbody>\n</table>\n<style>\n\n\t.LineGTable{\n\t\theight: 170px; \n\t}\n\n\t.colorG100I {    \t\n\t\t\tposition:relative;\t\t\n\t\t\ttop: 22px;\n\t\t\tleft:77px;\n\t}  \n\t.colorL100I {    \t\n\t\t\tposition:relative;\t\t\n\t\t\ttop: 22px;\n\t\t\tleft:70px;\n\t}  \t\n\t.colorL100D {    \t\n\t\t\tposition:relative;\t\t\n\t\t\ttop: 22px;\n\t\t\tleft:74px;\n\t}  \t\n\t.colorL001I {    \t\n\t\t\tposition:relative;\t\t\n\t\t\ttop: 22px;\n\t\t\tleft:80px;\n\t}  \n</style>\n\t\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
	String splitRange ="", splitRange1 ="";
	String valuesRange ="";

	divID = request.getParameter("divID");	
	//yAxisMin = Integer.parseInt(request.getParameter("yAxisMin"));		
	//yAxisMax = Integer.parseInt(request.getParameter("yAxisMax"));
	yAxisMin = Double.parseDouble(request.getParameter("yAxisMin"));		
	yAxisMax = Double.parseDouble(request.getParameter("yAxisMax"));
	
	xAxisDataType = request.getParameter("xAxisDataType");
	yAxisDataType = request.getParameter("yAxisDataType");
	splitRange = request.getParameter("splitRange");
	//splitRange = splitRange.replace('>', '#');
	valuesRange = request.getParameter("valuesRange");

	/*************************/
	String tbodyStr = "<tbody>";
	String trStr = "<tr class=\"breakTr\">";
	String ctrStr = "</tr>";
	String ctbodyStr = "</tbody>";
	String ctableStr = "</table>";

	//int tdRangeDiff = 0;
	double tdRangeDiff = 0.0;
	//int tdRangeTot = 0;
	double tdRangeTot = 0.0;
	double tdHeight = 0.0;
	//int tdRoundHeight = 0;
	double tdRoundHeight = 0.0;
	//int totHeight = 0;
	double totHeight = 0.0;

	//int rangeMin = 0, rangeMax = 0;
	double rangeMin = 0, rangeMax = 0;
	
	//int pValue=0;
	double pValue=0;

	StringBuffer htmlData = new StringBuffer();	
	
	splitRange1 = splitRange.replace('>', '#');
	
	String[][] lineRange = null;		
	String[] ranges = null;	
	String[] rangeArray = null;	
	String pageSource = "", iFrameTag = "";
	
	DecimalFormat decim = new DecimalFormat("#.00");

	
	if (splitRange1.length() > 0) 
	{
		rangeArray = splitRange1.split("@");	
		for (int x=0; x<rangeArray.length; x++)
		{			
			ranges = rangeArray[x].split("~");			
		}
		lineRange = new String[rangeArray.length][ranges.length];	
		
		for (int x=0; x<rangeArray.length; x++)
		{						
			ranges = rangeArray[x].split("~");			
			for (int y=0;y<ranges.length;y++){
				lineRange[x][y] =  ranges[y];				
			}			
		}
	}

            _bw.write(_wl_block3Bytes, _wl_block3);

				if (splitRange1.length() > 0) 
				{
					
					if (yAxisMax>=100)
					{
						htmlData.append("<div class=\"colorG100I\">");	
					}
					else if (yAxisMax<100)
					{
						if (yAxisMin>1 && (yAxisMin % 1) == 0) {
							htmlData.append("<div  class=\"colorL100I\">");
						}
						else if (yAxisMin>1) 
						{
							htmlData.append("<div  class=\"colorL100D\">");
						}
						else
						{
							htmlData.append("<div  class=\"colorL001I\">");
						}
					}	
					totHeight = yAxisMax - yAxisMin;
					htmlData.append("<table class=\"LineGTable\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  align=\"left\">");
					//htmlData.append("<table Height=\""+totHeight+"\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  align=\"left\">");
						htmlData.append(tbodyStr);	
							//rangeMin = Integer.parseInt(lineRange[0][0]);
							//rangeMax = Integer.parseInt(lineRange[lineRange.length-1][1]);
							
							
							rangeMin = Double.parseDouble(lineRange[0][0]);
							rangeMax = Double.parseDouble(lineRange[lineRange.length-1][1]);
							
							if (totHeight>tdRangeTot)
							{
								if (yAxisMax>rangeMax)
								{
									tdRangeDiff = yAxisMax - rangeMax;				
									tdHeight = Math.round(((tdRangeDiff/(double)totHeight) * 100));

									htmlData.append(trStr);	
									htmlData.append("<td style=\"border-left:5px solid transparent\"  height=\""+tdHeight+"%\">&nbsp;</td>"); 
									htmlData.append(ctrStr);
								}
							}
							
							for (int i=lineRange.length-1;i>=0;i--){
								tdRangeDiff = Double.parseDouble(lineRange[i][1]) - Double.parseDouble(lineRange[i][0]);
								tdRangeDiff = Double.parseDouble(decim.format(tdRangeDiff));
								totHeight = Double.parseDouble(decim.format(totHeight));
								tdHeight = Math.round(((tdRangeDiff/(double)totHeight) * 100));
								tdHeight = Double.parseDouble(decim.format(tdHeight));
								htmlData.append(trStr);	
								htmlData.append("<td style=\"border-left:5px solid "+lineRange[i][2]+"\"  height=\""+tdHeight+"%\" title=\""+lineRange[i][0]+ " - "+lineRange[i][1]+"\">&nbsp;</td>"); 
								htmlData.append(ctrStr);
							}
							if (totHeight>tdRangeTot)
							{
								if (yAxisMin<rangeMin)
								{
									tdRangeDiff = rangeMin - yAxisMin;
									tdHeight = Math.round(((tdRangeDiff/(double)totHeight) * 100));
									htmlData.append(trStr);	
									htmlData.append("<td style=\"border-left:5px solid transparent\"  height=\""+tdHeight+"%\">&nbsp;</td>"); 
									htmlData.append(ctrStr);
								}
							}
						htmlData.append(ctbodyStr);
					htmlData.append(ctableStr);	
					htmlData.append("</div>");
					
				}
				
					pageSource = "../../eCA/jsp/ES_Kendo_LineChart_Child.jsp?divID="+divID+"&yAxisMin="+yAxisMin+"&yAxisMax="+yAxisMax+"&xAxisDataType="+xAxisDataType+"&yAxisDataType="+yAxisDataType+"&splitRange="+splitRange+"&valuesRange="+valuesRange;

					iFrameTag = "<iframe frameborder=\"0\" id=\""+divID+"\" src=\""+pageSource+"\" width=\"100%\" height=\"250px\" scrolling=\"no\"></iframe>";
				
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(htmlData));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(iFrameTag));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
