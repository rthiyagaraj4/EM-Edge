package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordingsplchtdtlentry extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingSplChtDtlEntry.jsp", 1709115680512L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\t\n\t<body onKeyDown=\"lockKey()\">\n\t\t<form name=\'splChtPatDtlRecForm\' id=\'splChtPatDtlRecForm\' action=\'../../servlet/eCA.ChartRecordingSplChtPatRecDtlServlet\' method=\'post\'>\n\t\t\t<table border=\'1\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' id=\'tdHeadingTab\'>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' name=\'numOfDiscrMsrs\'>\n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' name=\'chartId\'>\n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' name=\'patientId\'>\n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' name=\'splChartType\'>\n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' name=\'splChartGrpId\'>\n\t\t\t<input type=\'hidden\' name=\'numOfRows\' id=\'numOfRows\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t<input type=\'hidden\' name=\'numOfCols\' id=\'numOfCols\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t<input type=\'hidden\' name=\'numOfTextBoxes\' id=\'numOfTextBoxes\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t<input type=\'hidden\' name=\'numOfRecords\' id=\'numOfRecords\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t</form>\n\t</body>\n\t<script>\n\t\tdocument.getElementById(\"ageTD\").innerText = document.getElementById(\"age\").value+\" (";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\";\n\t\talignKeyValHdg();\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		Connection con = null;
		PreparedStatement psDisc = null;
		ResultSet resDisc = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		String keyVal = "";
		String keyDesc = "";
		String keyUnit = "";
		String prevKeyVal = "";
		String transVal = "";
		String classValue = "";
		String discrMsr = "";
		String elementType = "";
		String elementUOM= "";

		StringBuffer strConcatVals = new StringBuffer();
		String chartId = request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");
		String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String splChartType = request.getParameter("splChtType") == null ? "" : request.getParameter("splChtType");
		String splChartGrpId = request.getParameter("splChtGrpId") == null ? "" : request.getParameter("splChtGrpId");

		String age = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels");

		int minNums = 0;
		int maxNums = 0;
		int decNums = 0;
		int maxLength = 20;
		int i = 0;
		int j = 0;
		int z = 0;

		ArrayList discrList = new ArrayList();
		ArrayList keyValList = new ArrayList();
		ArrayList keyDescList = new ArrayList();
		ArrayList discrDtlList = new ArrayList();
		HashMap keyValsMap = new HashMap();
		StringTokenizer valsTokenizer = null;

		String sqlVals = "SELECT  A.KEY_VALUE key_val,START_VALUE||'-'||END_VALUE key_desc, Decode(A.VALUE_UNIT,'M','Months','D','Days','W','Weeks','Y','Years') unit_val, B.ELEMENT_TYPE element_type, B.TRNS_VALUE trns_val FROM    CA_SPL_CHART_KEY_VALUE A, CA_SPL_CHART_PAT_REC_DTL B WHERE  A.X_ELEMENT_TYPE='*K' AND A.SPL_CHART_TYPE =?   AND   A.SPL_CHART_TYPE_GRP_ID =?  AND   B.PATIENT_ID(+)=?  AND   B.CHART_ID(+) =?   AND   B.KEY_VALUE(+)=A.KEY_VALUE AND B.SPL_CHART_TYPE_GRP_ID(+)=A.SPL_CHART_TYPE_GRP_ID ORDER BY A.START_VALUE , B.ELEMENT_TYPE ";

		String sqlDiscrNames = "select a.element_type ele_type, c.element_uom ele_uom ,a.discr_msr_id, b.SHORT_DESC discr_desc, b.num_digits_max max_nums, b.num_digits_min min_nums, b.num_digits_dec dec_nums from ca_chart_section_comp a, am_discr_msr b, CA_SPL_CHART_ELEMENT_TYPE c where a.chart_id = ? and a.element_type is not null and a.discr_msr_id = b.discr_msr_id and b.RESULT_TYPE in ('I','N','A') and a.element_type= c. element_type order by a.ELEMENT_TYPE";

		try
		{
			con = ConnectionManager.getConnection(request);

			psDisc = con.prepareStatement(sqlDiscrNames);
			psDisc.setString(1,chartId);
			resDisc = psDisc.executeQuery();

			ps = con.prepareStatement(sqlVals);
			ps.setString(1,splChartType);
			ps.setString(2,splChartGrpId);
			ps.setString(3,patientId);
			ps.setString(4,chartId);

			out.println("<tr>");
			out.println("<th align='left' id='ageTD'>");
			out.println(age);
			out.println("</th>");			

			while(resDisc.next())
			{
				discrMsr = resDisc.getString("discr_desc") == null ? "" : resDisc.getString("discr_desc");
				elementType = resDisc.getString("ele_type") == null ? "" : resDisc.getString("ele_type");
				elementUOM = resDisc.getString("ele_uom") == null ? "" : resDisc.getString("ele_uom");
				if("KM".equals(elementUOM))
					elementUOM="Kg\\m2";
				minNums = resDisc.getInt("min_nums");
				maxNums = resDisc.getInt("max_nums") == 0 ? 10 : resDisc.getInt("max_nums");
				decNums = resDisc.getInt("dec_nums") == 0 ? 10 : resDisc.getInt("dec_nums");

				if(maxNums == 10) maxLength = 21;
				else maxLength = maxNums;

				out.println("<th >"+discrMsr+" ("+elementUOM+")");
				out.println("</th>");
				discrList.add(elementType);
				discrDtlList.add(minNums+"`"+maxNums+"`"+decNums);
			}
			out.println("</tr>");
			out.println("</table>");
			out.println("<table class='grid' width='100%' id='valuesTab'>");

			if(resDisc != null) resDisc.close();
			if(psDisc != null) psDisc.close();

			res = ps.executeQuery();

			while(res.next())
			{
				keyVal = res.getString("key_val") == null ? "" : res.getString("key_val");
				keyDesc = res.getString("key_desc") == null ? "" : res.getString("key_desc");
				keyUnit = res.getString("unit_val") == null ? "" : res.getString("unit_val");
				elementType = res.getString("element_type") == null ? " " : res.getString("element_type");
				transVal = res.getString("trns_val") == null ? " " : res.getString("trns_val");
				
				if(!prevKeyVal.equals(keyVal))
				{
					keyValList.add(keyVal);
					keyDescList.add(keyDesc);
				}

				if(prevKeyVal.equals(keyVal) || prevKeyVal.equals(""))
				{
					strConcatVals.append(elementType+"~"+transVal);
					strConcatVals.append("`");
				}
				else
				{
					keyValsMap.put(prevKeyVal,strConcatVals.toString());
					strConcatVals.setLength(0);
					strConcatVals.append(elementType+"~"+transVal);
					strConcatVals.append("`");
				}
				keyValsMap.put(keyVal,strConcatVals.toString());
				prevKeyVal = keyVal;
			}

			if(res != null) res.close();
			if(ps != null) ps.close();

			String mapValues = "";
			String tokenRows = "";
			String tknElementType = "";
			String tknElementValue = "";
			String tempMapValues = "";
			String tempDetailValues = "";
			StringTokenizer strTokenValues = null;
			StringTokenizer discrDtlValues = null;
			StringBuffer tdValues = new StringBuffer();

			String tempIndexVal = "";

			for(i=0;i<keyValList.size();i++)
			{
				if(i % 2 == 0) classValue = "gridData";
				else classValue = "gridData";
				tempMapValues = "";
				mapValues = (String)keyValsMap.get((String)keyValList.get(i));
				tdValues.append("<tr>");
				tdValues.append("<td class='"+classValue+"'>"+(String)keyDescList.get(i)+"</td>");
				out.println("<input type='hidden' name='keyValue"+i+"' id='keyValue"+i+"' value='"+(String)keyValList.get(i)+"'>");
				if(mapValues != null)
				{
					for(j=0;j<discrList.size();j++)
					{
						tempIndexVal = (String)discrList.get(j);
				
						if(tempMapValues.equals(""))
							tempMapValues = mapValues;
						else
							tempMapValues = tempMapValues;

						valsTokenizer = new StringTokenizer(tempMapValues,"`");
						tokenRows = (String)valsTokenizer.nextToken();						

						if(mapValues.indexOf(tempIndexVal) == -1)
						{
							tempDetailValues = (String)discrDtlList.get(j);

							discrDtlValues = new StringTokenizer(tempDetailValues,"`");
							minNums = Integer.parseInt((String)discrDtlValues.nextToken());
							maxNums = Integer.parseInt((String)discrDtlValues.nextToken());
							decNums = Integer.parseInt((String)discrDtlValues.nextToken());

							tdValues.append("<td class='"+classValue+"'><input type='text' name='txt"+i+"Vals"+j+"' id='txt"+i+"Vals"+j+"' size='"+maxNums+"' maxlength = '"+maxLength+"' onkeypress=\"return allowValidNumberLocal2(this, event, '"+maxLength+"','"+decNums+"')\" onblur=\"validateNums(this,'"+minNums+"','"+maxNums+"','"+decNums+"')\"></td>");
							out.println("<input type='hidden' name='element"+i+"Type"+j+"' id='element"+i+"Type"+j+"' value='"+tempIndexVal+"'>");
							z++;
						}
						else
						{
							strTokenValues = new StringTokenizer(tokenRows,"~");
							tknElementType = (String) strTokenValues.nextToken();
							tknElementValue = (String)strTokenValues.nextToken();
							tdValues.append("<td class='"+classValue+"'>"+tknElementValue+"</td>");
							tempMapValues = tempMapValues.substring(tempMapValues.indexOf("`")+1);
						}
					}
				}
				tdValues.append("</tr>");
			}
			out.println(tdValues.toString());
		}//end of try
		catch(Exception e)
		{
			
		//	out.println("Exception@@@@@@ in try of ChartRecordingSplChtDtlEntry.jsp--"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(discrList.size()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(splChartType));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(splChartGrpId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(j));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(z));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(age));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(keyUnit));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
