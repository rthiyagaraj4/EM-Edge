package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordingsplchtlinks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingSplChtLinks.jsp", 1709115681512L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head>\n\t\t\n\t\t<body style=\'background-color:#E2E3F0;\' onKeyDown=\"lockKey()\">\n\t\t\t<form name=\'splChartLinksForm\' id=\'splChartLinksForm\'>\n\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'CAGROUPHEADING\' align=\'center\' colspan=\'2\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr></tr>\n\t\t\t\t</table>\n\t\t\t\t<table class=\'grid\' width=\'100%\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'CACHARTFOURTHLEVELCOLOR\' align=\'left\' colspan=\'2\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'graphDesc";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' id=\'graphDesc";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'xAxisElementType";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'xAxisElementType";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'yAxisElementType";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'yAxisElementType";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'splChartType";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'splChartType";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'splChartTypeGrpId";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'splChartTypeGrpId";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'CAGROUPHEADING\' align=\'left\'>\n\t\t\t\t\t\t<input type=\'button\' name=\'graph\' id=\'graph\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onclick =\'loadSplGraphs()\'>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'chart_id\' id=\'chart_id\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'Sex\' id=\'Sex\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'splChartType\' id=\'splChartType\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'index\' id=\'index\' value=\'\'>\n\t\t\t</form>\t\t\t\t\n\t\t</body>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' == \'0\' || \'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' == \'\')\n\t\t\t{\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' == \'GR\')\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\tdocument.splChartLinksForm.index.value = \'0\';\t\n\t\t\t\t\tif(document.splChartLinksForm.splChrt !=\"undefined\" && document.splChartLinksForm.splChrt !=undefined){\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.splChartLinksForm.splChrt.value==undefined || document.splChartLinksForm.splChrt.value==\"undefined\"){\n\t\t\t\t\t\tdocument.splChartLinksForm.splChrt[0].checked=true;\n\t\t\t\t\t\tloadSplGraphs();\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tdocument.splChartLinksForm.splChrt.checked=true;\n\t\t\t\t\t\t\tloadSplGraphs();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t//if(document.getElementById(\"anchorTag0\") != null)\n\t\t\t\t\t//document.getElementById(\"anchorTag0\").click();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' == \'GR\')\n\t\t\t\t{\t\n\t\t\t\t\tdocument.splChartLinksForm.index.value = \'0\';\n\t\t\t\t\tif(document.splChartLinksForm.splChrt != \"undefined\" && document.splChartLinksForm.splChrt != undefined){\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.splChartLinksForm.splChrt.value == undefined || document.splChartLinksForm.splChrt.value == \"undefined\"){\n\t\t\t\t\t\t\tdocument.splChartLinksForm.splChrt[0].checked = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.splChartLinksForm.splChrt.checked = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t//document.splChartLinksForm.splChrt[0].checked = true;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

					java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
					String locale = (String) p.getProperty("LOCALE");

					String splChartType = request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
					String patientID = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
					String encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
					String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
					String chartID = request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");
					String Sex = request.getParameter("Sex") == null ? "" : request.getParameter("Sex");

					int i = 0;

					String graphCode = "";
					String graphDesc = "";
					String xAxisElementType = "";
					String yAxisElementType = "";
					String splChartTypeGrpId = "";
					String splChartTypeGrpDesc = "";
					String classValue = "";

					Connection con = null;
					PreparedStatement ps = null;
					PreparedStatement psSplGrpId = null;
					ResultSet res = null;
					ResultSet resSplGrpId = null;

					String sqlGrpId = "select SPL_CHART_TYPE_GRP_ID, SPL_CHART_TYPE_GRP_DESC from CA_SPL_CHTY_GRP_LANG_VW where SPL_CHART_TYPE = ? AND LANGUAGE_ID = ?  AND EXISTS (SELECT 1 FROM CA_SPL_CHART_GRAPH WHERE SPL_CHART_TYPE=CA_SPL_CHTY_GRP_LANG_VW.SPL_CHART_TYPE AND SPL_CHART_TYPE_GRP_ID=CA_SPL_CHTY_GRP_LANG_VW.SPL_CHART_TYPE_GRP_ID)  UNION ALL 	SELECT '*A' SPL_CHART_TYPE_GRP_ID , 'NO GROUP' SPL_CHART_TYPE_GRP_DESC FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM CA_SPL_CHART_TYPE WHERE SPL_CHART_TYPE = ? AND SPL_CHART_TYPE_GRP_APPL_YN='N' AND EXISTS (SELECT 1 FROM CA_SPL_CHART_GRAPH WHERE SPL_CHART_TYPE=CA_SPL_CHART_TYPE.SPL_CHART_TYPE  AND  SPL_CHART_TYPE_GRP_ID='*A')) ";

					StringBuffer sql = new StringBuffer("select GRAPH_CODE, GRAPH_DESC, X_AXIS_ELEMENT_TYPE, Y_AXIS_ELEMENT_TYPE from CA_SPL_CHART_GRAPH_LANG_VW where EFF_STATUS='E' AND language_id = ? and SPL_CHART_TYPE = ? and SPL_CHART_TYPE_GRP_ID = ? ");

					try
					{
						con = ConnectionManager.getConnection(request);
						psSplGrpId = con.prepareStatement(sqlGrpId);
						psSplGrpId.setString(1,splChartType);
						psSplGrpId.setString(2,locale);
						psSplGrpId.setString(3,splChartType);
						resSplGrpId = psSplGrpId.executeQuery();
						ps = con.prepareStatement(sql.toString());
					    ps.setString(1,locale);
						ps.setString(2,splChartType);


						while(resSplGrpId.next())
						{
							splChartTypeGrpId = resSplGrpId.getString("SPL_CHART_TYPE_GRP_ID");
							splChartTypeGrpDesc = resSplGrpId.getString("SPL_CHART_TYPE_GRP_DESC");
							if(!splChartTypeGrpId.equals("*A"))
							{
								out.println("<tr>");
								out.println("<td class='CAGROUPHEADING' colspan='2'>&nbsp;"+splChartTypeGrpDesc+"</td>");
								out.println("</tr>");						
							}							

							ps.setString(3,splChartTypeGrpId);
							res = ps.executeQuery();
							
							while(res.next())
							{
								graphCode = res.getString("GRAPH_CODE");
								graphDesc = res.getString("GRAPH_DESC");
								xAxisElementType = res.getString("X_AXIS_ELEMENT_TYPE");
								yAxisElementType = res.getString("Y_AXIS_ELEMENT_TYPE");
								
								/*if(i % 2 == 0) classValue = "QRYEVEN";
								else classValue = "QRYODD";*/

                                classValue="gridData";

								out.println("<tr>");
								//out.println("<td class='"+classValue+"' width='10%'>&nbsp;&nbsp;&nbsp;<img src='../../eCA/images/graph.gif' onclick='loadSplGraphs(\""+graphDesc+"\",\""+xAxisElementType+"\",\""+yAxisElementType+"\",\""+splChartType+"\",\""+splChartTypeGrpId+"\")' title='Show Graph'>&nbsp;&nbsp;</td>");
								//out.println("<td class='"+classValue+"'><a class='gridLink' href='javascript:loadSplGraphs(\""+graphDesc+"\", \""+xAxisElementType+"\", \""+yAxisElementType+"\", \""+splChartType+"\", \""+splChartTypeGrpId+"\")' id='anchorTag"+i+"'>"+graphDesc+"</a></td>");
								//out.println("<td class='"+classValue+"' width='10%'>&nbsp;&nbsp;&nbsp;<img src='../../eCA/images/graph.gif' onclick='loadSplGraphs(\""+i+"\")' title='Show Graph'>&nbsp;&nbsp;</td>");
								//out.println("<td class='"+classValue+"'><a class='gridLink' href='javascript:loadSplGraphs(\""+i+"\")' id='anchorTag"+i+"'>"+graphDesc+"</a></td>");
								out.println("<td class='"+classValue+"'><input type='radio' name='splChrt' id='splChrt' value='"+i+"'  onclick='setIndex(this)' >"+graphDesc+"</input></td>");
						
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(graphDesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(xAxisElementType));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(yAxisElementType));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(splChartType));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(splChartTypeGrpId));
            _bw.write(_wl_block22Bytes, _wl_block22);

								out.println("</tr>");
								i++;
							}
							if(res != null) res.close();
						}

						//if(res != null) res.close();
						if(resSplGrpId != null) resSplGrpId.close();
						if(ps != null) ps.close();
						if(psSplGrpId != null) psSplGrpId.close();
					}
					catch(Exception e)
					{
						//out.println(e.toString());//COMMON-ICN-0181
						
						e.printStackTrace();
					}
					finally
					{
						if(con!=null)
							ConnectionManager.returnConnection(con,request);
					}
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(chartID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(splChartType));
            _bw.write(_wl_block30Bytes, _wl_block30);

			String numOfchkedBoxes = request.getParameter("numOfchkedBoxes") == null ? "0" : request.getParameter("numOfchkedBoxes");
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(numOfchkedBoxes));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(numOfchkedBoxes));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splChartType));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splChartType));
            _bw.write(_wl_block35Bytes, _wl_block35);
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SpecialChartLinks.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.GrowthChart.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SpecificView.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
