<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html> 
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src='../../eCA/js/DisDataCharting.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<%
				Connection con	=null;
				try{
					String classValue="";
					String patient_id = request.getParameter("patient_id");
					int i=1;
					PreparedStatement stmt=null;
					ResultSet  rs	=null;
					String query="Select b.SHORT_DESC test_name ,to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi:ss') date_time ,a.DISCR_MSR_RESULT_TYPE result_type , a.DISCR_MSR_RESULT_NUM , a.DISCR_MSR_RESULT_STR ,a.DISCR_MSR_RESULT_DATA  ,a.ERROR_MARKED_BY_ID ,to_char(a.ERROR_MARKED_DATE,'dd/mm/yyyy hh24:mi:ss') ERROR_MARKED_DATE ,a.ERROR_REMARKS remarks ,a.TEST_OBSERV_DT_TM    from ca_encntr_discr_msr a ,am_discr_msr b , sm_appl_user c where c.appl_USER_ID=a.ERROR_MARKED_BY_ID and b.DISCR_MSR_ID=a.DISCR_MSR_ID and a.patient_id=? and ERROR_YN='Y' order by ERROR_MARKED_DATE";
					con=ConnectionManager.getConnection(request);
					stmt=con.prepareStatement(query);					
					stmt.setString(1,patient_id);		
					rs=stmt.executeQuery();
			%>
			<title><fmt:message key="eCA.MarkedasErrorList.label" bundle="${ca_labels}"/></title>
	</head>

	<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onScroll='scrollTitle()' >

<center>
			<div id='divDataTitle' style='postion:relative'>
				<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
					<tr>
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Variable.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.datetime.label" bundle="${ca_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ErrorMarkedBy.label" bundle="${ca_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					</tr>
				</table>
			</div>
<table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff">
						<%
								String type;
							while(rs.next())	{
								if(i%2==0) classValue = "QRYEVEN";
									else classValue = "QRYODD";	
						%>
								<tr>
									<td  class=<%=classValue%>><%=rs.getString("test_name")%></td>
									<td  class=<%=classValue%>><%=rs.getString("date_time")%></td>
						<%		
								type= rs.getString("result_type");
								if(type.equals("N")){ %>
									<td  class=<%=classValue%>><%=rs.getString("DISCR_MSR_RESULT_NUM")%></td>
								<%} else if(type.equals("E") || type.equals("D") || type.equals("T"))	{%>
									<td  class=<%=classValue%>><%=rs.getString("DISCR_MSR_RESULT_STR")%></td>
								<%}	else {%>
									<td  class=<%=classValue%>>&nbsp;</td>
								<%}	%>
								<td  class=<%=classValue%>><%=rs.getString("ERROR_MARKED_BY_ID")%></td>
								<td  class=<%=classValue%>><%=rs.getString("ERROR_MARKED_DATE")%></td>
									<%
											String subString=rs.getString("remarks");
											int len=subString.length();
									%>
										
									<% if ( len > 15 ) {
											String printString=subString.substring(0,15);
									%>
										<td  class=<%=classValue%> ><%=printString%><a onclick="showRemarks('<%=java.net.URLEncoder.encode(rs.getString("remarks"))%>','y',5)" style='cursor:pointer; color: blue'><b>...</b></a></td>
									<% }else{ %>
										<td  class=<%=classValue%> ><%=rs.getString("remarks")%></td>
									<%}%>
							<tr>
						<%
									i++;
							}
							if(rs != null)rs.close();
							if(stmt != null)stmt.close();
							

				}catch(Exception e){
				//	out.println("Exception "+e);//COMMON-ICN-0181
                                        e.printStackTrace();//COMMON-ICN-0181
				}finally {
					if(con!=null)ConnectionManager.returnConnection(con,request);
				} %>
					<tr style='visibility:hidden'>
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Variable.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.datetime.label" bundle="${ca_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ErrorMarkedBy.label" bundle="${ca_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					</tr>
		        </table>
	    </center>
	</body>
</html>
<script>setTimeout("alignWidth()",100);</script>

