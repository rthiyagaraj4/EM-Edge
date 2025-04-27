<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language='javascript' src='../js/ChartRecording.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">

<form name='chartRecordingCriteriaForm' id='chartRecordingCriteriaForm' method='post' action ='../../servlet/eCA.ChartRecordingCriteriaServlet'>
<table class='grid' width='100%' id='titleTable' >
<tr>
<td class='columnheadercenter'><fmt:message key="Common.Events.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>
</tr>
<%
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");

Connection con = null;

PreparedStatement psSql = null;
PreparedStatement psSelect = null;
PreparedStatement psSelectTrn = null;

ResultSet rsSql = null;
ResultSet rsSelect = null;	
ResultSet rsSelectTrn = null;	

try
{
	con = ConnectionManager.getConnection(request);

	int index=0;
	int count = 0;
	int recordCount = 0;
	int countTrn = 0;
	
	String facilityId =session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
	String chartId = request.getParameter("chartId")==null ? "" :request.getParameter("chartId") ;
	String encounterId = request.getParameter("encounterId")==null ? "" :request.getParameter("encounterId");
	String sqlCheck = "select count(*) from CA_ENCNTR_CHART_DRAFT where ENCOUNTER_ID=? and CHART_ID= ? AND FACILITY_ID = ?";
	
	psSelect = con.prepareStatement(sqlCheck);
	psSelect.setString(1,encounterId);
	psSelect.setString(2,chartId);
	psSelect.setString(3,facilityId);
	rsSelect = psSelect.executeQuery();

	while(rsSelect.next())
	{
		recordCount = rsSelect.getInt(1);
	}
	
	if(rsSelect != null)rsSelect.close();
	if(psSelect != null)psSelect.close();

	sqlCheck = "select count(*) from  CA_ENCNTR_DISCR_MSR where ENCOUNTER_ID=? and CHART_ID= ? and FACILITY_ID = ? and DISCR_MSR_ID=? ";
	
	psSelectTrn = con.prepareStatement(sqlCheck);
	psSelectTrn.setString(1,encounterId);
	psSelectTrn.setString(2,chartId);
	psSelectTrn.setString(3,facilityId);
	
	sqlCheck = "select count(*) from CA_ENCNTR_CHART_DRAFT where FACILITY_ID = ? AND ENCOUNTER_ID=? and CHART_ID= ?  and PANEL_ID=? and  DISCR_MSR_ID=?";
	psSelect = con.prepareStatement(sqlCheck);
	psSelect.setString(1,facilityId);
	psSelect.setString(2,encounterId);
	psSelect.setString(3,chartId);

	String sql = "SELECT A.PANEL_ID SECTION_ID, AM_GET_DESC.AM_DISCR_MSR(A.PANEL_ID,?,'2')  SECTION_DESC, a.DISCR_MSR_ID discr_msr_id, AM_GET_DESC.AM_DISCR_MSR(A.DISCR_MSR_ID,?,'2') DISCR_MSR_DESC, DISCR_MSR.RESULT_TYPE result_type, A.PANEL_DISP_ORDER_SEQ DISPLAY_ORDER_SEQ, a.DISCR_DISP_ORDER_SEQ ORDER_SRL_NO, a.DEFAULT_DISPLAY_YN,a.SUMMARY_TYPE, a.SUMMRY_COLUMN, a.SUM_YN,a.FORMULA_DEF formula_def,a.mandatory_yn FROM ca_chart_section_comp A, AM_DISCR_MSR DISCR_MSR WHERE A.CHART_ID=? AND  DISCR_MSR.DISCR_MSR_ID=  A.DISCR_MSR_ID AND DISCR_MSR.CH_APPL_YN='Y'  ORDER BY A.PANEL_DISP_ORDER_SEQ,a.dISCR_DISP_ORDER_SEQ";
	String sectionId = "";
	String prevSectionId = "";
	String sectionDesc = "";
	String discrMsrId = "";
	String discrMsrDesc = "";
	String resultType = "";
	String displayOrderSeqNo = "";
	String orderSrlNo = "";
	String formulaDef = "";
	String defaultYN = "";
	String sumYN = "";
	String summaryColumn = "";
	String summaryType = "";
	String classValue ="";
	String mandatory_yn="";

	psSql = con.prepareStatement(sql);
	psSql.setString(1,locale);
	psSql.setString(2,locale);
	psSql.setString(3,chartId);

	rsSql = psSql.executeQuery();
	
	while(rsSql.next())
	{
		classValue = (index % 2) == 0 ? "gridData" : "gridData";
		sectionId = 	rsSql.getString("SECTION_ID") == null ? "" : rsSql.getString("SECTION_ID");
	
		if(!prevSectionId.equals(sectionId))
		{
			out.println("<tr>");		
			sectionDesc = rsSql.getString("SECTION_DESC") == null ? "" : rsSql.getString("SECTION_DESC");
			out.println("<td colspan='2' class='CAGROUPHEADING'>"+sectionDesc+"</td>");		
			out.println("</tr>");
			prevSectionId = sectionId;
		}
		
		out.println("<tr>");		
		out.println("<td class='"+classValue+"'>");		
		out.println("<input type='hidden' name='sectionId"+index+"' id='sectionId"+index+"' value='"+sectionId+"'>");
		discrMsrDesc =  rsSql.getString("DISCR_MSR_DESC") == null ? "" : rsSql.getString("DISCR_MSR_DESC");
		discrMsrId =  rsSql.getString("discr_msr_id") == null ? "" : rsSql.getString("discr_msr_id");
		psSelect.setString(4,sectionId);
		psSelect.setString(5,discrMsrId);
		rsSelect =psSelect.executeQuery();
		
		while(rsSelect.next())
		{
			count = rsSelect.getInt(1);
		}
		
		if(rsSelect != null)rsSelect.close();

		resultType=   rsSql.getString("result_type") == null ? "" : rsSql.getString("result_type");
		displayOrderSeqNo=   rsSql.getString("DISPLAY_ORDER_SEQ") == null ? "" : rsSql.getString("DISPLAY_ORDER_SEQ");
		orderSrlNo=   rsSql.getString("ORDER_SRL_NO") == null ? "" : rsSql.getString("ORDER_SRL_NO");
		formulaDef =  rsSql.getString("formula_def") == null ? "" : rsSql.getString("formula_def");
		sumYN =  rsSql.getString("SUM_YN") == null ? "N" : rsSql.getString("SUM_YN");

		if(sumYN.equals("") || sumYN.equals("null") || sumYN.equals("NULL")) 
			sumYN = "N";

		summaryColumn = rsSql.getString("SUMMRY_COLUMN") == null ? "N" : rsSql.getString("SUMMRY_COLUMN");
		summaryType =  rsSql.getString("SUMMARY_TYPE") == null ? "" : rsSql.getString("SUMMARY_TYPE");
		mandatory_yn =  rsSql.getString("mandatory_yn") == null ? "" : rsSql.getString("mandatory_yn");
		
		if(mandatory_yn.equals("null") || mandatory_yn.equals("") || mandatory_yn.equals("NULL"))
			mandatory_yn = "N";

		out.println("<input type='hidden' name='discrMsrId"+index+"' id='discrMsrId"+index+"' value='"+discrMsrId+"'>");
		out.println("<input type='hidden' name='resultType"+index+"' id='resultType"+index+"' value='"+resultType+"'>");
		out.println("<input type='hidden' name='displayOrderSeqNo"+index+"' id='displayOrderSeqNo"+index+"' value='"+displayOrderSeqNo+"'>");
		out.println("<input type='hidden' name='orderSrlNo"+index+"' id='orderSrlNo"+index+"' value='"+orderSrlNo+"'>");
		out.println("<input type='hidden' name='formulaDef"+index+"' id='formulaDef"+index+"' value='"+formulaDef+"'>");
		out.println("<input type='hidden' name='sumYN"+index+"' id='sumYN"+index+"' value='"+sumYN+"'>");
		out.println("<input type='hidden' name='summaryColumn"+index+"' id='summaryColumn"+index+"' value='"+summaryColumn+"'>");
		out.println("<input type='hidden' name='summaryType"+index+"' id='summaryType"+index+"' value='"+summaryType+"'>");
		out.println("<input type='hidden' name='mandatory_yn"+index+"' id='mandatory_yn"+index+"' value='"+mandatory_yn+"'>");
		
		out.println(discrMsrDesc);	
		
		if(mandatory_yn.equals("Y"))
			out.println("<img align=center src='../../eCommon/images/mandatory.gif'></img>");

		out.println("</td>");	
		defaultYN =  rsSql.getString("DEFAULT_DISPLAY_YN") == null ? "" : rsSql.getString("DEFAULT_DISPLAY_YN");
		
		
		if(recordCount ==0)
		{	
			if(defaultYN.equals("Y"))
			{
				if(mandatory_yn.equals("Y"))
					out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked  disabled value='Y'></td>");
				else
					out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked   value='Y'></td>");
			}
			else
				out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' ></td>");
		}
		else
		{
			psSelectTrn.setString(4,discrMsrId);
			rsSelectTrn = psSelectTrn.executeQuery();

			while(rsSelectTrn.next())
			{
				countTrn = rsSelectTrn.getInt(1);
			}	
	
			
			if(count !=0)
			{
				if(countTrn !=0)
					out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked disabled></td>");
				else
				{
					if(mandatory_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked disabled></td>");
					else
						out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked ></td>");
				}
			}
			else
				out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' ></td>");
		}

		out.println("<input type='hidden' name='defaultYN"+index+"' id='defaultYN"+index+"' value=''>");
		out.println("</tr>");		
		index++;
	}
	
	if(psSelect != null)psSelect.close();
	if(rsSelectTrn != null)rsSelectTrn.close();
	if(psSelectTrn != null)psSelectTrn.close();
	if(rsSql != null)rsSql.close();
	if(psSql != null)psSql.close();

	out.println("<input type='hidden' name='index' id='index' value='"+index+"'>");
	out.println("<input type='hidden' name='chartId' id='chartId' value='"+chartId+"'>");
	out.println("<input type='hidden' name='encounterId' id='encounterId' value='"+encounterId+"'>");
	out.println("<input type='hidden' name='flagMsg' id='flagMsg' value=''>");
%>
<%
}
catch(Exception ee)
{
	//out.println("Exception from ChartRecordingCriteriaForAddingItems.jsp "+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con != null)ConnectionManager.returnConnection(con);
}
%>
<script>
if(parent.chartRecordingBottomFrame != null)
parent.chartRecordingBottomFrame.location.href='../../eCA/jsp/ChartRecordingToolBarForAddItems.jsp?<%=request.getQueryString()%>';
</script>
</form>
</table>
</body>	
</html>

