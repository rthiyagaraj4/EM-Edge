<!DOCTYPE html>
  <%@ page import="java.sql.*,webbeans.eCommon.*,java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HTML>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title>View - Access History for Clinical Studies Patient List</title>
<%
	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;
	
	

	String	practitionerId		=	(request.getParameter("practitionerId")==null?"":request.getParameter("practitionerId"));
	String	facilityId		=	(request.getParameter("facilityId")==null?"":request.getParameter("facilityId"));
	String	practitionerName			=	(request.getParameter("practitionerName")==null?"":request.getParameter("practitionerName"));	
	
%>
<SCRIPT>
function colseWindow(){
	//window.close();
	parent.document.getElementById('dialog_tag').close();
}
</SCRIPT>
</HEAD>
<BODY>
	<TABLE border="0" cellpadding="3" cellspacing="0" width="100%" height="100%" align='center'>
		<TR height="5%">
			<TH  align="center" colspan="2"><font size="2"><B>Access History for Clinical Studies Patient List</B></font></TH>
		</TR>
		<TR height="5%">
			<TH  align="center" colspan="2"><font size="1"><B>Practitioner Name : <%=practitionerName%></B></font></TH>
		</TR>
		</TABLE>		
		<!-- <TR height="85%">
			<TD colspan="2"> -->
				<DIV style="width:100%; overflow: auto; height: 80vh;">
				<TABLE border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
					<TR><TH align="center" >Start Date</TD>
						<TH align="center" >End Date</TD>
						<TH align="center" >Record Created By</TD>
						<TH align="center" >Record Date</TD>
						<TH align="center" >Record Status</TD>
					</TR>
					<%					
						String sql = "SELECT TO_CHAR(CRSAL.RES_FROM_DATE,'dd/MM/yyyy') RES_FROM_DATE,TO_CHAR(CRSAL.RES_TO_DATE,'dd/MM/yyyy') RES_TO_DATE,(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=CRSAL.ADDED_BY_ID) PRACTITIONER_NAME,TO_CHAR(ADDED_DATE,'dd/MM/yyyy') ADDED_DATE,DECODE(ROW_STATUS,'I','Created','U','Modified','D','Deleted') ROWSTATUS FROM CA_RES_STUDY_ALLOWED_LOG CRSAL WHERE CRSAL.PRACTITIONER_ID=? AND CRSAL.FACILITY_ID=?  ORDER BY CRSAL.ADDED_DATE DESC";
						try{
							con	= ConnectionManager.getConnection(request);
							pstmt	= con.prepareStatement(sql);
							pstmt.setString(1, practitionerId);
							pstmt.setString(2, facilityId);
							

							rs = pstmt.executeQuery();
							int i=0;
							if(rs!=null){
								while(rs.next()){
									String resFromDate = rs.getString("RES_FROM_DATE")==null?"":(String)rs.getString("RES_FROM_DATE");
									String resToDate = rs.getString("RES_TO_DATE")==null?"":(String)rs.getString("RES_TO_DATE");
									String practitionerName_ = rs.getString("PRACTITIONER_NAME")==null?"":(String)rs.getString("PRACTITIONER_NAME");
									String addedDate = rs.getString("ADDED_DATE")==null?"":(String)rs.getString("ADDED_DATE");
									String rowStatus = rs.getString("ROWSTATUS")==null?"":(String)rs.getString("ROWSTATUS");
									 %>
									 <TR>
										<TD><%=resFromDate%></TD>
										<TD><%=resToDate %></TD>
										<TD><%=practitionerName_%></TD>
										<TD><%=addedDate %></TD>
										<TD><%=rowStatus %></TD>
									</TR>
									 <%
									 i++;
								}
							}
							if(i==0){
								%>
								<TR><TD colspan="5">&nbsp;</TD></TR>
								<TR><TD colspan="5">&nbsp;</TD></TR>
								<TR><TD colspan="5" align="center">Access History Not available.</TD></TR>
								<TR><TD colspan="5">&nbsp;</TD></TR>
								<TR><TD colspan="5">&nbsp;</TD></TR>
								<%
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							
						}catch(Exception e){
								e.printStackTrace();
							//	out.println("Exception from ClinicalStudiesPatientListHistDetails.jsp " + e.toString());//COMMON-ICN-0181
						}finally{
								if(con != null) ConnectionManager.returnConnection(con, request);
						} 
						
					%>
					
				</TABLE>
				</DIV>
		<!-- 	</TD>
		</TR> -->
		<TABLE border="0" cellpadding="3" cellspacing="0" width="100%" height="100%" align='center'>
	<tr>
	<TD align="right" colspan="2">
				<input type="button" value="Close" onClick="javascript:colseWindow();" />
	</TD>
	</tr>
	</TABLE>
</BODY>	
</HTML>

