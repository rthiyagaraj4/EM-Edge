<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
20/01/2012		CHL-CRF [IN035950]	Ramesh G		CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="Common.HighRisk.label" bundle="${common_labels}"/></title>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- ****  Modified by kishor kumar n on 03/12/2008 for crf0387 applied new css grid. **** -->


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCA/js/rowcolor.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
 
	Connection conn=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String highriskcode="";
	String highriskdesc="";
	String srlno="", onset_date="";
	String rowclass="QRY_EVEN";
	String date_type = "";
	int i=0, anam  = 0;
	String p_called_from_widget = ""; //CHL-CRF [IN035950]
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
    String locale = (String) p.getProperty("LOCALE");
		
	String Patient_Id  = request.getParameter("Patient_Id");
	String Encounter_Id = request.getParameter("Encounter_Id");
	String Practitioner_Id = request.getParameter("Practitioner_Id");
	String Clinic_Code = request.getParameter("Clinic_Code");
	String Location_Type = request.getParameter("Location_Type");
	p_called_from_widget  = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
	String modal_yn = request.getParameter("modal_yn");
	if(modal_yn == null) modal_yn="N";
	
	try{
		conn=ConnectionManager.getConnection(request);
		String strsql = " Select a.high_risk_code, b.short_desc, b.long_desc,a.remarks, a.srl_no, to_char(a.onset_date,'dd/mm/yyyy') onset_date, ONSET_DATE_TYPE date_type from PR_HIGH_RISK_CONDITION A, MR_HIGH_RISK_LANG_VW B  where a.patient_id =? and a.close_date is null and A.HIGH_RISK_CODE=B.HIGH_RISK_CODE and b.language_id = ? " ;
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,Patient_Id);
		stmt.setString(2,locale);
		rs = stmt.executeQuery();

%>

<form name='f' id='f'>
<div align='center'>
<table width="100%" class='grid' id='tb1'>
<%if(modal_yn.equals("Y")){%>
	<tr>
		<th width='44%' class='columnheader'><fmt:message key="Common.HighRiskConditions.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
	</tr>
<%}%>
<%
	if(rs == null)
	{
		for(int y=0; y<5; y++)
		{
		   if (y % 2 == 0 )
	   			rowclass = "QRYODD";
		  else	
			   	rowclass = "QRYEVEN";

		out.print("<tr><td width='44%' class='gridData'>&nbsp;</td><td class='gridData'>&nbsp;</td></tr>");
		}
	}
	else
	{
		while(rs.next())
		{
			  if (i % 2 == 0 )
				   	rowclass = "QRYODD";
			  else
		   			rowclass = "QRYEVEN";

			highriskdesc = rs.getString("long_desc");
				if(highriskdesc == null) highriskdesc = "&nbsp;";
			highriskcode = rs.getString("high_risk_code");
				if(highriskcode == null) highriskcode = "&nbsp;";
			onset_date = rs.getString("onset_date");
				if(onset_date == null) onset_date = "&nbsp;";

			if(!onset_date.equals("&nbsp;") )
				onset_date = com.ehis.util.DateUtils.convertDate(onset_date,"DMY","en",locale);

			srlno = rs.getString("srl_no");
			date_type = rs.getString("date_type");
			
			out.println("<tr style='background-color:;' ><td width='44%'  class='gridData'>");
			if(modal_yn.equals("Y"))
			{
				out.println(highriskdesc+"</td><td class='gridData'>"+onset_date);
				if(date_type.equals("E"))
				{
					out.println("<img src='../../eCA/images/mc_history.gif' height='15'></td></tr>");
				}
				else
					out.println("</td></tr>");
			}
			else
			{
				out.println("<a class='gridLink' name='"+anam+"' onclick='javascript:changeRowColor(this,2)'  href='../../eCA/jsp/addModifyPatHighRisk.jsp?high_risk_code="+highriskcode+"&srl_no="+srlno+"&Patient_Id="+Patient_Id+"&Practitioner_Id="+Practitioner_Id+"&Clinic_Code="+Clinic_Code+"&Location_Type="+Location_Type+"&Encounter_Id="+Encounter_Id+"&p_called_from_widget="+p_called_from_widget+ "' target='frame2'>");
				out.println(highriskdesc+"</a></td><td   class='gridData'>"+onset_date);
				if(date_type.equals("E"))
				{
					out.println("<img src='../../eCA/images/mc_history.gif' height='15'></td></tr>");
				}
				else
					out.println("</td></tr>");
			}
			i++;
			anam++;
	}
}

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();

}catch(Exception e){
		out.println("Exception @ try"+e.toString());
}
finally {
	
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>
</div>
</table>
</form>
</BODY>
</html>

