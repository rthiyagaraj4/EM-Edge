<!DOCTYPE html>
<!-- DisDataViewErrorList.jsp -->

<!-- 
		*     Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
		*	   Application     : eCA
		*     Purpose        : Responsible for Displaying All Error Messages for the Particular Paient and their Remarks for Error Messages
		*     Created By    : Chitra
		*     Modified By   : Suresh Babu .C
		*     Modified On  : 25 Feb 2004
		*	   Note		: See this Prg. with WordWrap UnChecked to see the correct flow of the Prg. 
-->


<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<html> 
	<head>
<%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src='../../eCA/js/DisDataCharting.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%
				Connection con	=null;
				PreparedStatement stmt=null;
				ResultSet  rs	=null;

				try{
					String classValue="";
					String patient_id = request.getParameter("patient_id");
					int i=1;
					
					String query="select decode(b.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, b.DIAG_CODE,  b.DIAG_DESC,  DECODE(B.DIAG_CODE_SCHEME,'1','ICD 1O','2','ICD 9CM') DIAG_CODE_SCHEME_DESC, j.PRACTITIONER_NAME      ERROR_MARKED_BY_ID, to_char(a.error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date_1, A.error_Remarks||'<br><br>Encounter:'||A.FACILITY_ID||'/'||A.ENCOUNTER_ID remarks from pr_problem_enc_err_log a, pr_problem b, AM_PRACTITIONER j where  a.patient_id=?  and b.patient_id=a.patient_id and b.SRL_NO=a.SRL_NO and j.PRACTITIONER_ID=A.ERROR_MARKED_BY_ID order by A.	error_marked_date desc ";
					con=ConnectionManager.getConnection(request);
					stmt=con.prepareStatement(query);					
					
					stmt.setString(1,patient_id);		
					
					rs=stmt.executeQuery();
			%>
			<title>Marked as Error List</title>
	</head>

	<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll='scrollTitle()' >
<center>
			<div id='divDataTitle' style='postion:relative'>
				<table border='1' width='100%' id='dataTitleTable' cellpadding='0' cellspacing='0' align='center' >
					<tr>
						<th align ='left'>Diag Type</th>
						<th align ='left'>Diag Desc</th>
						<th align ='left'>Diag Code</th>
						<th align ='left'>Marked by</th>
						<th align ='left'>Marked Date</th>
						<th align ='left'>Remarks</th>
					</tr>
				</table>
			</div>
<table border='1' width='100%' id='dataTable' cellpadding='0' cellspacing='0' align='center' style="border-bottom:#ffffff">
						<%

							while(rs.next())	{
								if(i%2==0) classValue = "QRYEVEN";
									else classValue = "QRYODD";	
						%>
								<tr>
									<td align ='left' class=<%=classValue%>><%=rs.getString("diagtype")%></td>
									<td align ='left' class=<%=classValue%>><%=rs.getString("DIAG_DESC")%></td>
									<td align ='left' class=<%=classValue%>><%=rs.getString("DIAG_CODE")%></td>
									<td align ='left' class=<%=classValue%>><%=rs.getString("ERROR_MARKED_BY_ID")%></td>
									<td align ='left' class=<%=classValue%>><%=rs.getString("ERROR_MARKED_DATE_1")%></td>
										
									<td align ='left' class=<%=classValue%> ><%=rs.getString("remarks")==null?" ":rs.getString("remarks")%></td>
									
							<tr>
						<%
									i++;
							}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}catch(Exception e){
					//out.println("Exception "+e.toString());
					e.printStackTrace();
				}finally {
							if(con!=null)ConnectionManager.returnConnection(con,request);
					
				} %>
					<tr style='visibility:hidden'>
						<th align ='left'>Diag Type</th>
						<th align ='left'>Diag Desc</th>
						<th align ='left'>Diag Code</th>
						<th align ='left'>Error Marked by</th>
						<th align ='left'>Marked Date</th>
						<th align ='left'>Remarks</th>
					</tr>
		        </table>
	    </center>
	</body>
</html>
<script>setTimeout("alignWidth()",100);</script>

