package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __chartcomponentintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartComponentIntermediate.jsp", 1724667643437L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<script language=\"JavaScript\" src =\"../../eCA/js/ChartComponent.js\"></script> <!-- to call the function callFunction()-->\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\tvar returnArray;\n\t\t</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\"lockKey()\" onLoad=\"callLookupFunc()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\t\t//var label = \"eCA.DiscreteMeasureSearch.label\";\n\t\tvar textObj = eval(\"parent.chartComponentListFrame.ChartComponentListForm.\"+\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"); \n\t\tvar hidObj = eval(\"parent.chartComponentListFrame.ChartComponentListForm.\"+\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"); \n\t\tretArray = callFunction(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\",getLabel(\"eCA.DiscreteMeasureSearch.label\",\"eCA\"),textObj)\n\t\t\n\t\t\tvar ret1=unescape(retArray);\n\t\t \tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t} \n\t\t\t\n\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t{\n\t\t\t\ttextObj.value = arr[1];\n\t\t\t\thidObj.value = arr[0];\n\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\ttextObj.value = \'\'\n\t\t\t\thidObj.value = \'\'\n\t\t\t\n\t\t\t}\n\t\tchkDupSummValues(textObj,\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');////IN039171 \n\t</script>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<script>\n\tasync function callLookupFunc(){\n\t//var label = \"eCA.Chart.label\";\t\n\t\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",getLabel(\"eCA.Chart.label\",\"eCA\"),parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc)\n\t\n\t\tvar ret1=unescape(retArray);\n\t \tvar arr=ret1.split(\",\");\n\t \tif(arr[1]==undefined) \n \t\t{\n\t \t\tarr[0]=\"\";\t\n\t \t\tarr[1]=\"\";\t\n \t\t} \n\t\tif(retArray != null && retArray !=\"\")\t\n\t\t{\n\t\t\tparent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartCompSearch.value = arr[0];\n\t\t\tparent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc.value = arr[1];\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartCompSearch.value = \'\';\n\t\t\tparent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc.value = \'\';\t\t\n\t\t}\n\t}\n\t</script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n </body>\n</html>\n\n";
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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
26/06/2013    	IN039171		Dinesh	 System do not calculate 'day summary' in chart that summary  required such as ?intake/output chart?
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String description = "";
	String sql = "";
	String calledFrom = "";
	String summaryValue = "";
	String objText = "";
	String objHidden = "";
	String objTextName = "";
	String hidObjName = "";
	String summaryId = "";
	String summarySql = "";


	calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
	summaryValue = request.getParameter("summaryValue") == null ? "" : request.getParameter("summaryValue");
	objText = request.getParameter("objText") == null ? "" : request.getParameter("objText");
	objHidden = request.getParameter("objHidden") == null ? "" : request.getParameter("objHidden");
	objTextName = request.getParameter("objTextName") == null ? "" : request.getParameter("objTextName");
	hidObjName = request.getParameter("hidObjName") == null ? "" : request.getParameter("hidObjName");
	String k = request.getParameter("k") == null ? "" : request.getParameter("k");//IN039171
	String noofrows = request.getParameter("noofrows") == null ? "" : request.getParameter("noofrows");//IN039171
	try
	{
	/*
		In the below if-else block, if block was added by
		Name   : T DINESH
		Date   : 2010-08-04
		INCNO  : IN022998
		Reason : For opening a new lookup for the discrete measure in the chart component function in CA
				 and also taken the existing code in this page and put them in the else block of this page itself
	*/
	
	if(calledFrom.equals("summaryDefn"))
	{
		con = ConnectionManager.getConnection(request);
		summarySql = "select discr_msr_id code , short_desc description from am_discr_msr where eff_status = 'E' and upper(discr_msr_id) like  upper(?) and upper(short_desc) like upper(?) and  result_type='S' order by 2";
		summaryId = summaryId + "%";
		summaryValue = summaryValue + "%";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(objTextName));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(hidObjName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(summarySql));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(k));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(noofrows));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else
	{
	int count =0;
	
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("chartCode") == null ? "" : request.getParameter("chartCode");
			sql = "Select CHART_ID, SHORT_DESC from ca_chart where eff_status='E' and upper(SHORT_DESC) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(count == 1)
			{
				ps = con.prepareStatement(sql);
				ps.setString(1,description);
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
					out.println("parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc.value='"+rs.getString(2)+"' ");
					out.println("parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartCompSearch.value='"+rs.getString(1)+"' ");
				}
			}
			out.println("</script>");
			
			if(count == 0 || count > 1)
			{
				sql = "Select CHART_ID code, SHORT_DESC description from ca_chart where eff_status='E'  and upper(CHART_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block14Bytes, _wl_block14);
		
		 }
	if(rs != null) rs.close();
	 if(ps != null) ps.close();
				
	}
	}//end of try-1
	catch(Exception ee)
	{
		//out.println("Exception in try-1 of ChartComponentIntermediate.jsp "+ee.toString());//COMMON-ICN-0181
                  ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
				if(con != null) ConnectionManager.returnConnection(con);
		
	}

            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
