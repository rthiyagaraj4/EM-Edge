<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	%>
<html>
 <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	String vccSchReffNo = request.getParameter("vaccSchReff")==null?"":request.getParameter("vaccSchReff");
	String vaccId = request.getParameter("vaccID")==null?"":request.getParameter("vaccID");
	String doseNO = request.getParameter("doseNO")==null?"":request.getParameter("doseNO");
	String vaccDesc = request.getParameter("vaccine_desc")==null?"":request.getParameter("vaccine_desc");
%>
<head>
	 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	 <script language='javascript' src='../../eCommon/js/common.js'></script>
     <script src='../js/ScheduleForVacination.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form>
		<table class='grid' width='100%'>
				<tr>
					<td class='columnheadercenter' colspan='6'><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<%=vaccDesc%></td>
				</tr>
				<tr>				
					<td class='columnheadercenter'><fmt:message key="eCA.AdministerDate.label" bundle="${ca_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/>/<BR><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="eCA.MarkedErrorDate.label" bundle="${ca_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="eCA.MarkedInErrorBy.label" bundle="${ca_labels}"/></td>
					<td class='columnheadercenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				</tr>
 <%
	

	String sql = "SELECT  SM_get_desc.SM_APPL_USER(a.err_marked_by,?,1) err_marked_by, to_char(a.err_marked_date,'dd/mm/yyyy') err_marked_date, a.err_remarks, to_char(a.administered_date, 'dd/mm/yyyy') administered_date, SM_get_desc.SM_APPL_USER(a.administered_by,?,1) administered_by  FROM ca_im_pat_vac_err_dtl a WHERE a.vac_sch_ref = ? and a.VACCINE_ID = ? and a.DOSE_NO = ? ORDER BY to_date(a.err_marked_date,'dd/mm/yyyy')";

	String adminDate = "";
	String adminBy = "";
	String errDate = "";
	String errBy = "";
	String remorks = "";



	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
//	int cnt = 0;

	try
	{
		con = ConnectionManager.getConnection(request);
		pst = con.prepareStatement(sql);
		pst.setString(1, locale);
		pst.setString(2, locale);
		pst.setString(3, vccSchReffNo);
		pst.setString(4, vaccId);
		pst.setString(5, doseNO);
		rs= pst.executeQuery();
		while(rs.next())
		{
				adminDate = rs.getString(5);
				adminBy = rs.getString(4);
				errDate = rs.getString(2);
				errBy = rs.getString(1);
				remorks = rs.getString(3);
		%>
			<tr>
				<td class='gridData'><%=adminBy%></td>
				 <td class='gridData'><%=adminDate%></td> 
				<td class='gridData'><%=errDate%></td>
				<td class='gridData'><%=errBy%></td>
				<td class='gridData'><%=remorks%></td>
			</tr>
		<%}
		if(rs != null)
		{
			rs.close();
		}

		if(pst != null)
		{
			pst.close();
		}

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try 
		{
			if(con != null)		
			{
				con.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
 %>
	  </table>
    </form>
 </body>
</html>

