<!DOCTYPE html>
<!-- DisDataViewErrorList.jsp -->
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
	<head>
	<script>

	function alignWidth(){
	var totalRows =  parent.frame1.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.frame1.document.getElementById("dataTitleTable").rows[1].cells.length;
	for(var i=0;i<temp;i++) {
		parent.frame1.document.getElementById("dataTitleTable").rows[1].cells[i].width=parent.frame1.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
	}
}

</script>
 <% 	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
 <%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<!-- modified by Arvind @ 05-12-08--> 
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src='../../eCA/js/DisDataCharting.js' language='javascript'></script>
		<script src='../../eCA/js/procedures.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
				Connection con	=null;
					String classValue="";
					String patient_id = request.getParameter("patient_id");
					//String locale=(String)session.getValue( "LOCALE" ) ;
					java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
					String locale = (String) p.getProperty("LOCALE");
                    String markedDate = "";

				try{
					int i=1;
					PreparedStatement stmt=null;
					ResultSet  rs	=null;

					//String query="select proc_code,  proc_narration,  decode(proc_code_scheme,'3','CPT 4','4','ICD 9CM') scheme, ERROR_MARKED_BY_ID, to_char(error_marked_date,'dd/mm/yyyy') error_marked_date, error_Remarks remarks from	pr_encounter_procedure where  ERROR_YN='Y' and patient_id=?";
					//String query="select proc_code,  proc_narration,  b.Term_Set_Desc scheme,  to_char(error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date_str, error_Remarks remarks,c.APPL_USER_NAME  ERROR_MARKED_BY_ID,srl_no from	pr_encounter_procedure a,mr_term_set  b,sm_appl_user c where  ERROR_YN='Y' and patient_id=? and a.proc_code_scheme = b.term_set_id and c.appl_user_id=a.ERROR_MARKED_BY_ID order by error_marked_date desc";
					String query="select proc_code,  proc_narration,  b.Term_Set_Desc scheme,  to_char(error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date_str, error_Remarks remarks,SM_GET_DESC.SM_APPL_USER( a.ERROR_MARKED_BY_ID,?,'1')  ERROR_MARKED_BY_ID,srl_no from	pr_encounter_procedure a,mr_term_set  b where  ERROR_YN='Y' and patient_id=? and a.proc_code_scheme = b.term_set_id order by error_marked_date desc";
					con=ConnectionManager.getConnection(request);
					stmt=con.prepareStatement(query);
					stmt.setString(1,locale);
					stmt.setString(2,patient_id);		
					rs=stmt.executeQuery();
			%>
			<title><fmt:message key="eCA.MarkedasErrorList.label" bundle="${ca_labels}"/></title>
	</head>

	<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll='scrollTitle()' >
	<form>
			<div id='divDataTitle' style='postion:relative'>
				<table  border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
					<tr>
						<th class='COLUMNHEADERCENTER' align='left' width = '18%'><fmt:message key="Common.ProcedureCode.label" bundle="${common_labels}"/></th>
						<th class='COLUMNHEADERCENTER' align='left' width = '18%' ><fmt:message key="Common.ProcedureDescription.label" bundle="${common_labels}"/></th>
						<th class='COLUMNHEADERCENTER' align='left' width = '15%'><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></th>
						<th class='COLUMNHEADERCENTER' align='left' width = '18%'><fmt:message key="eCA.ErrorMarkedBy.label" bundle="${ca_labels}"/></th>
						<th class='COLUMNHEADERCENTER' align='left' width = '20%'><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></th>
						<th class='COLUMNHEADERCENTER' align='left' width = '16%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
					</tr>
				</table>
			</div>
<table class='grid' border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' >
				<%
					while(rs.next())	{
						if(i%2==0) classValue = "gridData";
							else classValue = "gridData";	
							markedDate=rs.getString("error_marked_date_str")==null?"":rs.getString("error_marked_date_str");
								if(!markedDate.equals(""))
							markedDate= com.ehis.util.DateUtils.convertDate(markedDate,"DMYHM","en",locale);
				%>
						<tr>
						<td class='<%=classValue%>'  width = '18%'> <%=rs.getString("proc_code")==null?"":rs.getString("proc_code")%></td>
						<td class='<%=classValue%>' width = '18%' ><%=rs.getString("proc_narration")==null?"":rs.getString("proc_narration")%></td>
						<td class='<%=classValue%>'  width = '16%'><%=rs.getString("scheme")==null?"":rs.getString("scheme")%></td>
						<td class='<%=classValue%>' width = '16%'> <%=rs.getString("ERROR_MARKED_BY_ID")==null?"":rs.getString("ERROR_MARKED_BY_ID")%></td>
						<td class='<%=classValue%>' width = '16%'> <%=markedDate%></td>
						<td class='<%=classValue%>' width = '16%'>
							<a onClick="javascript:showDetails('<%=rs.getString("proc_code")%>','<%=rs.getInt("srl_no")%>')" class='gridLink' style='cursor:pointer; color: blue'> 
								<fmt:message key="Common.details.label" bundle="${common_labels}"/> 
							</a>
						</td>
						</tr>
				<%
							i++;
					}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
				}catch(Exception e){
					//out.println("Exception "+e);//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
				}finally {
					ConnectionManager.returnConnection(con,request);
				} %>
					<!--<tr style='visibility:hidden'>
						<td class='columnheader'><fmt:message key="Common.AllergyClass.label" bundle="${common_labels}"/></td>
						<td class='columnheader'><fmt:message key="eCA.AllergicTo.label" bundle="${ca_labels}"/></td>
						<td class='columnheader'><fmt:message key="Common.AllergicDesc.label" bundle="${common_labels}"/></td>
						<td class='columnheader'><fmt:message key="Common.MarkedBy.label" bundle="${common_labels}"/></td>
						<td class='columnheader'><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
						<td class='columnheader'><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
					</tr>-->
		        </table>
		<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>' >
		</form>
	</body>
</html>
<script>setTimeout("alignWidth()",100);</script>

