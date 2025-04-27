<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src='../../eCA/js/DisDataCharting.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%
				 Properties p = (Properties)session.getValue("jdbc");
				String locale	= (String) p.getProperty("LOCALE");
				String diag_type="";
				Connection con	=null;
				PreparedStatement stmt=null;
				ResultSet  rs	=null;

				try{
					String classValue="";
					String patient_id = request.getParameter("patient_id");
					int i=1;
					
					//String query="select decode(a.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, a.DIAG_CODE,  DIAG_DESC,  a.DIAG_CODE_SCHEME_DESC, j.APPL_USER_NAME ERROR_MARKED_BY_ID, to_char(a.error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date_1, a.error_Remarks remarks from pr_problem_vw a, sm_appl_user j where  a.ERROR_YN='Y' and a.patient_id=?  and j.APPL_USER_ID=a.ERROR_MARKED_BY_ID order by error_marked_date_1 desc ";

					String query="select a.diag_type diagtype, a.DIAG_CODE,  DIAG_DESC,  a.DIAG_CODE_SCHEME, B.PRACTITIONER_NAME, ERROR_MARKED_BY_ID, to_char(a.error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date_1, a.error_Remarks remarks from pr_problem a, AM_PRACTITIONER_LANG_VW b where  a.ERROR_YN='Y' and a.patient_id=?   and a.ERROR_MARKED_BY_ID = B.PRACTITIONER_ID and B.LANGUAGE_ID =  ? order by error_marked_date_1 desc ";
					con=ConnectionManager.getConnection(request);
					stmt=con.prepareStatement(query);					
					
					stmt.setString(1,patient_id);	
					stmt.setString(2,locale);
					
					rs=stmt.executeQuery();
			%>
			<title><fmt:message key="eCA.MarkedasErrorList.label" bundle="${ca_labels}"/></title>
	</head>

	<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll='scrollTitle()' >
<center>
			<div id='divDataTitle' style='postion:relative'>
				<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
					<tr>
						<td class='columnheader' width='20%'><fmt:message key="eCA.DiagType.label" bundle="${ca_labels}"/></td>
						<td class='columnheader' width='20%'><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></td>
						<td class='columnheader' width='10%'><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>
						<td class='columnheader' width='10%'><fmt:message key="Common.MarkedBy.label" bundle="${common_labels}"/></td>
						<td class='columnheader' width='20%'><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
						<td class='columnheader' width='20%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					</tr>
				</table>
			</div>
<table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff">
			<%

			while(rs.next())	{
				if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";	

						diag_type=rs.getString("diagtype");
						if(diag_type == null)	diag_type ="";
						if(diag_type.equals("P"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");

				if(diag_type.equals("D"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
				if(diag_type.equals("F"))

					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");
						%>
								<tr>
									<td width='18%'  class=<%=classValue%> ><%=diag_type%></td>
									<td width='17%' class=<%=classValue%>><%=rs.getString("DIAG_DESC")%></td>
									<td width='15%' class=<%=classValue%>><%=rs.getString("DIAG_CODE")%></td>
									<td width='15%' class=<%=classValue%>><%=rs.getString("ERROR_MARKED_BY_ID")%></td>
									<td width='17%' class=<%=classValue%>><%=rs.getString("ERROR_MARKED_DATE_1")%></td>
									<%
											String subString=(rs.getString("remarks")==null?" ":rs.getString("remarks"));
											int len=subString.length();
									%>
										
									<% if ( len > 15 ) {
											String printString=subString.substring(0,15);
									%>
										<td width='17%' class=<%=classValue%> ><%=printString%><a onclick="showRemarks('<%=rs.getString("remarks")%>','y',5)" style='cursor:pointer; color: blue'><b>...</b></a></td>
									<% }else{ %>
										<td width='17%' class=<%=classValue%> ><%=rs.getString("remarks")==null?" ":rs.getString("remarks")%></td>
									<%}%>
							<tr>
						<%
									i++;
							}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}catch(Exception e){
					//out.println("Exception "+e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
				}finally {
							if(con!=null)ConnectionManager.returnConnection(con,request);
					
				} %>
					<tr style='visibility:hidden'>
						<td class='columnheader'><fmt:message key="eCA.DiagType.label" bundle="${ca_labels}"/></td>
						<td class='columnheader'><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></td>
						<td class='columnheader'><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>
						<td class='columnheader'><fmt:message key="eCA.ErrorMarkedBy.label" bundle="${ca_labels}"/></td>
						<td class='columnheader'><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
						<td class='columnheader'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					</tr>
		        </table>
	    </center>
	</body>
</html>
<script>setTimeout("alignWidth()",100);</script>

