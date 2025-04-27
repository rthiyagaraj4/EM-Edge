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

public final class __chartrecordingprintdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingPrintData.jsp", 1738290595011L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<html>\n\t\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script Language=\"vbscript\">\n\t\t\tDim WSHShell\n\t\t\tDim myHeader\n\t\t\tDim myFooter\n\t\t\tDim myMarginleft \n\t\t\tDim myMarginright \n\t\t\tSet WSHShell = CreateObject(\"WScript.Shell\")\n\n\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", \"&bPage &p of &P\"\n\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"&b&d\"\n\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\", \"0.5\"\n\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\", \"0.3\"\n\n  \n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t<style>\n\t\t\t\n\t\t\tTD.CACHARTQRYEVEN {\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tBORDER-COLOR: black;\n\t\t\t}\n\n\t\t\tTD.CACHARTFOURTHLEVELCOLOR \n\t\t\t{\n\t\t\t\theight: 3px;\n\t\t\t\tBORDER-COLOR: black;\n\t\t\t}\n\n\t\t\tTD.CRITICAL{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#D2B48C;\n\t\t\t\tBORDER-COLOR: black;\n\t\t\t}\n\n\t\t\tTD.ABNORMAL{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#FFF8DC;\n\t\t\t\tBORDER-COLOR: black;\n\t\t\t}\n\t\t\tTD.HIGH{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#FFDAB9\n\t\t\t}\n\t\t\tTD.LOW{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#F0FFFF;\n\t\t\t\tBORDER-COLOR: black;\n\t\t\t}\n\t\t\tTD.CRITICALLOW{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#D8BFD8;\n\t\t\t\tBORDER-COLOR: black;\n\t\t\t}\n\t\t\tTD.CRITICALHIGH{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#F4A460;\n\t\t\t\tBORDER-COLOR: black;\n\t\t\t}\n\t\t\tTD.DELTAFAIL{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#FFE4E1;\n\t\t\t\tBORDER-COLOR: black;\n\t\t\t}\n\t\t</style>\n\t</head>\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad = \"Print()\">\n\t\t\t<form name =\"ChartLayoutListForm\">\n\t\t\t<table width=\'95%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =",";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr><td><center><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></center></td></tr>\n\t\t\t</table>\n\t\t\t<table  id=\'titleTable\' width=\'95%\' class=\'grid\'>\n\t\t\t<tr id=\'divTitleTable\'>\n\t\t\t<td rowspan=\'2\' class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td rowspan=\'2\' class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar rowValue = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"\n\t\t\t\t\t\t\t\t\t//var thRowId = eval(\"document.getElementById(\"rowId\")\"+rowValue)\n\t\t\t\t\t\t\t\t\tvar thRowId = document.getElementById(\"rowId\" + rowValue);\n\t\t\t\t\t\t\t\t\tthRowId.colSpan += 1\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</tr>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"detailYN\" id=\"detailYN\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"summaryYN\" id=\"summaryYN\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t\t\t</table>\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"sumVal\" id=\"sumVal\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\t\n\t\t</form>\n\t\t\t\t<script>\n\t\t\t\t\t/*var count = document.getElementById(\"titleTable\").rows.length;\n\t\t\t\t\tvar sumVal = document.getElementById(\"sumVal\").value;\n\t\t\t\t\tvar values = sumVal.split(\"`\");\n\t\t\t\t\tvar length = values.length;\n\t\t\t\t\tfor(var i=3;i<count;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tfor(var j=0;j<length-1;j++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar val = values[j];\n\t\t\t\t\t\t\tval = parseInt(val,10)+2;\n\t\t\t\t\t\t\tif(document.getElementById(\"titleTable\").rows(i).cells(val) != null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif(document.getElementById(\"titleTable\").rows(i).cells(val).className != \'CAFOURTHLEVELCOLOR\')\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\"titleTable\").rows(i).cells(val).className= \'CASUMMARY\';\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}*/\n\t\t\t\t\t\n\t\t\t\t\tfunction Print() \n\t\t\t\t\t{\n\t\t\t\t\t\tif (document.all)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar res = confirm(\'Continue printing?\');\n\t\t\t\t\t\t\tif(res)  \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\twindow.print();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t</body>\n\t</html>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\n\n";
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/01/2019      IN067541        Sivabagyam M       21/01/2019       Ramesh G        ML-MMOH-CRF-1159
4/02/2019      IN069501        Sivabagyam M       4/02/2019       Ramesh G      CA-Common-Record Charts
---------------------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	 
		String encounterId		=	request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");

		if(encounterId.equals("")) encounterId = "0";

		String detailDate		=	request.getParameter("detailDate") == null ? "" : request.getParameter("detailDate");
		String sort_by			=	request.getParameter("sort_by") == null ? "D" : request.getParameter("sort_by");
		String adm_date			=	request.getParameter("visit_adm_date") == null ? "" : request.getParameter("visit_adm_date");

		int daySummary = 0;
	
		if(request.getParameter("summaryText") == null || request.getParameter("summaryText").equals(""))
			daySummary = 0;
		else
			daySummary = Integer.parseInt(request.getParameter("summaryText"));

		if(daySummary == 0 && !sort_by.equals("A")) 
			adm_date = detailDate + " 00:00";
		else 
			adm_date = request.getParameter("visit_adm_date") == null ? "" : request.getParameter("visit_adm_date");

		String summaryYN		=	request.getParameter("summaryYN") == null ? "" : request.getParameter("summaryYN");
		String detailYN			=	request.getParameter("detailYN") == null ? "Y" : request.getParameter("detailYN");
	
		String facilityId		=	(String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
		String patientId		=	request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String chartId			=	request.getParameter("chartId") == null ? "" : request.getParameter("chartId");
		String fromDate			=	request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
		String toDate			=	request.getParameter("toDate") == null ? "" : request.getParameter("toDate");
		
		String strSql= "",	chartName = "";
		String pline = "", patient_name = "";
		StringBuffer summaryVal = new StringBuffer();
		StringTokenizer token = null;

		HashMap grpList = new HashMap();
		HashMap discrList = new HashMap();
		HashMap finalHash = new HashMap();
		HashMap hash = new HashMap();
		
		fromDate				=	com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM", locale,"en");
		toDate					=	com.ehis.util.DateUtils.convertDate(toDate,"DMYHM", locale,"en");

		try
		{
			if(encounterId.equals(""))
			{
				strSql="select get_patient.get_line_detail(?,?) Pline FROM dual";
			}
			else
			{
				strSql="select get_patient.get_line_detail(?,?,?) Pline FROM dual";
			}
			pstmt = con.prepareStatement(strSql);
			if(encounterId.equals(""))
			{
				pstmt.setString(1, patientId);
				pstmt.setString(2, locale);
			}else{
				pstmt.setString(1, facilityId);
				pstmt.setString(2, encounterId);
				pstmt.setString(3, locale);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
					pline = rs.getString(1);
				}

			if(pline != null)
			{
				token = new StringTokenizer(pline,"|");
				patient_name = token.nextToken();
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
			strSql = "select a.SHORT_DESC from ca_chart_LANG_VW a where a.eff_status='E' and language_id = ? and chart_id = ?";
			pstmt = con.prepareStatement(strSql);
			pstmt.setString(1, locale);
			pstmt.setString(2, chartId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
					chartName = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	
		catch(Exception e)
		{
			//out.println(" from Charting Recording List Population :"+e.toString());//common-icn-0181
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}
		finalHash = (HashMap)session.getValue("dataHash"+encounterId);
		ArrayList dates = (ArrayList)session.getValue("dateArray"+encounterId);
		HashMap hashData = (HashMap)session.getValue("chartEvents"+encounterId);
		ArrayList arrayChartGrp = (ArrayList)session.getValue("chartGrp"+encounterId);
		ArrayList arrayResultType = (ArrayList)session.getValue("arrayResultType"+encounterId);
		ArrayList arrList = (ArrayList)session.getValue("arrList"+encounterId);
		
		if(dates.size()>0)
		{

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(chartName));
            _bw.write(_wl_block6Bytes, _wl_block6);

		
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(chartName));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

					String groupId = "",	groupDesc = "",		prevGroupId = "";
					String discrId = "",	discrDesc = "",		uom = "";
					int i=0;

					for(i=0;i<arrList.size();i++)
					{
						hash = (HashMap)arrList.get(i);
						groupId = (String)(hash.get("CHART_GROUP_ID")) == null ? "" : (String)(hash.get("CHART_GROUP_ID"));
						groupDesc = (String)(hash.get("CHART_GORUP_DESC")) == null ? "" : (String)(hash.get("CHART_GORUP_DESC"));
						if(!prevGroupId.equals(groupId))
						{
							grpList.put(groupId,groupDesc);
						}
						uom = (String)(hash.get("UOM")) == null ? "&nbsp;" : (String)(hash.get("UOM"));
						if(uom.equals("")) uom = "&nbsp;";
						discrId = (String)(hash.get("DISCR_MSR_ID")) == null ? "" : (String)(hash.get("DISCR_MSR_ID"));
						discrDesc = (String)(hash.get("SHORT_DESC")) == null ? "" : (String)(hash.get("SHORT_DESC"));
						if(!discrId.equals(""))
							discrList.put(discrId,discrDesc+"`"+uom);
					}

					StringTokenizer tokenizeSpace = null;
					String dt = "";
					String currDate="";
					String prevDateTemp = "";
					String dummyDateString = "";
					int ii = 0;
					int index = 0;
					boolean flag = true;;
					int actualIndex = 0;
					if(dates != null)
					{
						for(ii=0;ii<dates.size();ii++)
						{
							dt = (String)dates.get(ii);
							tokenizeSpace = new StringTokenizer(dt," ");
							currDate = tokenizeSpace.nextToken();
							if(!currDate.equals(prevDateTemp)){
								
								out.println("<td class='DateLink' width='40px' id='rowId"+index+"'>"+com.ehis.util.DateUtils.convertDate(currDate,"DMY","en",locale)+"</td>");
								prevDateTemp = currDate;
								actualIndex = index;
								index++;
							}
							else
							{
								

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(actualIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
							}
						}
					}
					String dummyString="";
					String currDate1="";
					String anchorObj = "";
					String anchorObjEnd = "";
					out.println("</tr>");
					out.println("<tr id='divTitleTable1'>");
					if(dates!=null)
					{
						for( ii=0;ii<dates.size();ii++)
						{
							dt = (String)dates.get(ii);
							dummyString=(String)arrayResultType.get(ii);
							tokenizeSpace = new StringTokenizer(dt," ");
							currDate1 = tokenizeSpace.nextToken();
							currDate = tokenizeSpace.nextToken();
							if(!currDate.equals(prevDateTemp))
							{
								dummyDateString = currDate1;
								currDate1= currDate1.replace('/','_');
								//IN067541 STARTS
								if(dummyString.equals("S")){
									currDate="Day Summary";
								}
								 if(dummyString.equals("S1")){
										currDate="Shift1 Summary";
								 }
								 if(dummyString.equals("S2")){
										currDate="Shift2 Summary";
								 }
								if(dummyString.equals("S3")){
									currDate="Shift3 Summary";
								}								
								String strSuminthai = currDate;
								if(strSuminthai.equals("Day Summary"))
								{
									strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DaySummary.label","ca_labels");
									summaryVal = summaryVal.append(ii+"`");
								}
								if(strSuminthai.equals("Shift1 Summary")){
									strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AMShift.label","ca_labels");//IN067541
									summaryVal = summaryVal.append(ii+"`");
								}
								if(strSuminthai.equals("Shift2 Summary")){
									strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PMShift.label","ca_labels");//IN067541
									summaryVal = summaryVal.append(ii+"`");
								}
								if(strSuminthai.equals("Shift3 Summary")){
									strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ONShift.label","ca_labels");//IN067541
									summaryVal = summaryVal.append(ii+"`");
									}
								out.println("<td class='TimeLink' nowrap width='40px' id='thId"+currDate1+ii+"'> "+anchorObj+" "+strSuminthai+" "+anchorObjEnd+" </td>");
								prevDateTemp =currDate;
								
							}
							/*else
							{
								if(dummyString.equals("S"))
									currDate="DAY/SUM";
								String strsum_thai=currDate;
								if(strsum_thai.equals("DAY/SUM")){
									//strsum_thai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Daysum.label","ca_labels");//IN069501
									strsum_thai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DaySum.label","ca_labels");//IN069501
								}
								out.println("<td class='columnHeadercenter'  width='40px' id='thId"+currDate1+ii+"'>"+strsum_thai+"</td>");
							}*/
							//IN067541 ends
						}
					}
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block18Bytes, _wl_block18);

					ArrayList cols = new ArrayList();
					ArrayList discrArray = new ArrayList();
					HashMap setOfValues = new HashMap();
					String printVal = "";
					String classValue = "gridDataChart";
					String styleValue = "";
					String result_type = "";
					String discrMsrId = "", discrMsrDesc = "";
					String tempStringTemp = "";
					String tempString1 = "";
					int indexJ = 0;
					String normalStr="",normalRangeColor = "",criticalStr = "";
					String currGroupId ="", currGroupDesc = "";
					String eventDate = "";
					String tooltip = "";
					String currEventDate="";
					StringTokenizer tk = null;
					int z =0 ;int indexK = 0;int k=0;
					int tempIntForGraph = 0;
				String shiftColor="";//IN067541
				String resultTypeTemp="";//IN067541
					for( indexJ= 0 ; indexJ < arrayChartGrp.size();indexJ++){
							flag = true;
							index = 0;
							currGroupId = (String)arrayChartGrp.get(indexJ)==null ? "" : (String)arrayChartGrp.get(indexJ) ;
							discrArray	= (ArrayList)hashData.get(currGroupId);
							currGroupDesc = (String)grpList.get(currGroupId);
							//out.println("<tr >&nbsp</tr>");//IN058155(Removed the extra space)
							out.println("<tr ><td colspan=4>&nbsp;<td></tr>");//IN058155
							out.println("<tr >");
							out.println("<td class='COLUMNHEADER' colspan='2' >"+currGroupDesc+"</td>");
							for(k=0;k<dates.size();k++)
							{
								out.println("<td class='COLUMNHEADER'>&nbsp;</td>");
							}
							out.println("</tr>");
							for(indexK =0 ;indexK <discrArray.size();indexK++)
							{
								discrMsrId = (String)discrArray.get(indexK);
								out.println("<tr id='tdrowId"+indexJ+indexK+"'>");
								discrMsrDesc = (String)discrList.get(discrMsrId);
								tk = new StringTokenizer(discrMsrDesc,"`");
								
								out.println("<td class='gridDataChart' border='1'>"+tk.nextToken()+"</td>");
								out.println("<td class='gridDataChart' border='1'>"+tk.nextToken()+"</td>");
								cols = (ArrayList)finalHash.get(currGroupId+"~"+discrMsrId);
								for(k=0,z=0;k<dates.size();k++)
								{
									resultTypeTemp= (String)arrayResultType.get(k);//IN067541
									if(cols != null)
									{
										if(cols.size() > z)
										{
											setOfValues = (HashMap)cols.get(z);
											eventDate = (String)dates.get(k);
										
											currEventDate = (String)(setOfValues.get("VALUE_DATE"))==null ? "" : (String)(setOfValues.get("VALUE_DATE"));
											if(currEventDate.equals(eventDate))
											{
											//IN067541 starts
												//IN065535 Start.
												result_type = (String)(setOfValues.get("RESULT_TYPE")==null?"":setOfValues.get("RESULT_TYPE"));
												if((!result_type.equals("S") && !result_type.equals("S1") && !result_type.equals("S2") && !result_type.equals("S3")) ||
													((result_type.equals("S") || result_type.equals("S1") || result_type.equals("S2") || result_type.equals("S3")) && (result_type.equals(arrayResultType.get(k))))){
													//IN065535 End.
													//IN067541 ends
												printVal = (String)setOfValues.get("VALUE")== null ? "" :(String)setOfValues.get("VALUE") ;
												
												normalStr = (String)(setOfValues.get("NORMALSTR")==null?"":setOfValues.get("NORMALSTR"));
												normalRangeColor = (String)(setOfValues.get("COLOR")==null?"":setOfValues.get("COLOR"));
	
												criticalStr = (String)(setOfValues.get("CRITICALSTR")==null?"":setOfValues.get("CRITICALSTR"));
												result_type = (String)(setOfValues.get("RESULT_TYPE")==null?"":setOfValues.get("RESULT_TYPE"));
												//IN067541 STARTS
												if(result_type.equals("S")||result_type.equals("S1")||result_type.equals("S2")||result_type.equals("S3"))
												{
													shiftColor="style='background-color:#d3d3d3;'";
												}else{
													shiftColor="";
												}
												//IN067541 ends
												if(result_type.equals("L")){
													if(!printVal.equals("")){
														if(printVal.indexOf("||") !=-1){
																tokenizeSpace =  new StringTokenizer(printVal,"||");
																tempString1 = tokenizeSpace.nextToken();
	
																tempStringTemp = tokenizeSpace.nextToken();
																
																printVal=tempStringTemp;
	
														}
														printVal = tempString1 + " " + printVal;
													}		
												}
												if(flag==true){
												if(!printVal.equals(""))
												{
													if(!normalStr.equals("") && !criticalStr.equals(""))
														tooltip = normalStr+", "+criticalStr;
													else if(!normalStr.equals(""))
														tooltip = normalStr;
													else if(!criticalStr.equals(""))
														tooltip = criticalStr;
													else
														tooltip="";
												}
												else
												{
													tooltip="";
												}
											}
											if(!result_type.equals("S")){
											if(!normalRangeColor.equals(""))
											{
												//styleValue = "STYLE= 'FONT-SIZE: 7PT;BORDER-STYLE: THIN ;background-color:"+normalRangeColor+"' ";
												classValue	=	"gridDataChart";
												styleValue = "class = '"+classValue+"' ";
											}
											else
											{
													if((indexK%2)==0)
													{
														classValue	=	"gridDataChart";
														styleValue = "class = '"+classValue+"' ";
													}
													else
													{
														classValue	=	"gridDataChart";
														styleValue = "class = '"+classValue+"' ";
													}
												}
											}
											else if(result_type.equals("S"))
											{

												classValue = "gridDataChart";
												styleValue = "class = '"+classValue+"' ";

											}
											//out.println("<td width='40px' "+styleValue+">"+printVal+"</td>");//IN067541
											out.println("<td width='40px'  "+shiftColor+" "+styleValue+">"+printVal+"</td>");//IN067541
											
											z++;
											printVal="";
												//IN067541 starts
											//IN065535 Start.
											}else{
												if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1") || resultTypeTemp.equals("S2") || resultTypeTemp.equals("S3")){
													shiftColor="style='background-color:#d3d3d3;'";
												}//IN067541 ENDS
												if((indexK%2)==0){
													classValue	=	"gridDataChart";
													styleValue = "class = '"+classValue+"' ";
												}else{
													classValue	=	"gridDataChart";
													styleValue = "class = '"+classValue+"' ";
												}
												//out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
												out.println("<td width='40px'  "+shiftColor+" "+styleValue+">"+printVal+"</td>");//IN067541
											}
											//IN065535 End.
											//IN067541ends
										}
										else
										{
										//IN067541 starts
											if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1")||resultTypeTemp.equals("S2")||resultTypeTemp.equals("S3"))
											{
												shiftColor="style='background-color:#d3d3d3;'";
											}else{
												shiftColor="";
											}
											//IN067541ends
											if((indexK%2)==0)
											{
												classValue	=	"gridDataChart";
												styleValue = "class = '"+classValue+"' ";
											}
											else
											{
												classValue	=	"gridDataChart";
												styleValue = "class = '"+classValue+"' ";
											}
											//out.println("<td width='40px' "+styleValue+"></td>");//IN067541
											out.println("<td width='40px' "+shiftColor+" "+styleValue+" >&nbsp;</td>");//IN067541
										}
									}
									else
									{
										//IN067541starts
										if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1")||resultTypeTemp.equals("S2")||resultTypeTemp.equals("S3"))
										{
											shiftColor="style='background-color:#d3d3d3;'";
										}else{
											shiftColor="";
										}
										//IN067541ends
										if((indexK%2)==0)
										{
											classValue	=	"gridDataChart";
											styleValue = "class = '"+classValue+"' ";
										}
										else
										{
											classValue	=	"gridDataChart";
											styleValue = "class = '"+classValue+"' ";
										}
										//out.println("<td width='40px' "+styleValue+">"+printVal+"</td>");//IN067541
										out.println("<td width='40px' "+shiftColor+"  "+styleValue+" >&nbsp;</td>");//IN067541
									}
								}
								else
								{
									//IN067541 starts
									if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1")||resultTypeTemp.equals("S2")||resultTypeTemp.equals("S3"))
									{
										shiftColor="style='background-color:#d3d3d3;'";
									}else{
										shiftColor="";
									}
									//IN067541ends
									if((indexK%2)==0)
									{
										classValue	=	"gridDataChart";
										styleValue = "class = '"+classValue+"' ";
									}
									else
									{
										classValue	=	"gridDataChart";
										styleValue = "class = '"+classValue+"' ";
									}
									//out.println("<td width='40px' "+styleValue+">"+printVal+"</td>");//IN067541
									out.println("<td width='40px' "+shiftColor+" "+styleValue+" >&nbsp;</td>");//IN067541
								}
							}
							tempIntForGraph++;
							out.println("</tr>");					
						}
				}

				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(summaryVal.toString()));
            _bw.write(_wl_block20Bytes, _wl_block20);
}

if(discrList != null) discrList.clear();
if(grpList != null) grpList.clear();
//if(hash != null) hash.clear();
}//end of try
catch(Exception ee)
{

	
	ee.printStackTrace();
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}

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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
