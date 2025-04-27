<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
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
		<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
		<script language=javascript src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%

	Connection con	=null;
	PreparedStatement stmt = null;
	ResultSet  rs	= null;
	try
	{
			
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");
				String classValue="";
				String patient_id = request.getParameter("patient_id");
				int i=1;
				

				//String query="select a.ALLERGY_CLASS_DESC,  a.ALLERGIC_ITEM,  a.allergy_type_desc,j.APPL_USER_NAME  ERROR_MARKED_BY_ID, to_char(a.error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date_1, a.error_marked_date, a.error_Remarks remarks from	pr_allergy_vw a, sm_appl_user j where a. ERROR_YN='Y' and a.patient_id=? and j.APPL_USER_ID=a.ERROR_MARKED_BY_ID  order by error_marked_date desc ";
				String query="select a.ALLERGY_CLASS,  a.ALLERGIC_ITEM,  MR_GET_DESC.MR_ALLERGY_TYPE(A.ALLERGY_TYPE_CODE,?,'2')    allergy_type_desc,SM_GET_DESC.SM_APPL_USER(a.error_marked_by_id,?,'1')  ERROR_MARKED_BY_ID, to_char(a.error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date_1, a.error_marked_date, a.error_Remarks remarks from	pr_allergy a where a. ERROR_YN='Y' and a.patient_id=? order by error_marked_date desc";
				con=ConnectionManager.getConnection(request);
				stmt=con.prepareStatement(query);					
				stmt.setString(1,locale);
				stmt.setString(2,locale);
				stmt.setString(3,patient_id);		
				rs=stmt.executeQuery();
			%>
			<title><fmt:message key="eCA.MarkedasErrorList.label" bundle="${ca_labels}"/></title>
	</head>

	<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll='scrollTitle()' >
<center>
			<div id='divDataTitle' style='postion:relative'>
				<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
					<tr>
						<td class='columnHeadercenter' ><fmt:message key="Common.AllergyClass.label" bundle="${common_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="eCA.AllergicTo.label" bundle="${ca_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="Common.AllergicDesc.label" bundle="${common_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="eCA.ErrorMarkedBy.label" bundle="${ca_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					</tr>
				</table>
			</div>
			<table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff">
						<%
								String subString ="";
								String printString = "";
								String allergyClass="";
								String allergyClassDesc="";
								String strErrMarkDate	="";
								int len = 0;

								while(rs.next())
								{
									if(i%2==0) 
										classValue = "QRYEVEN";
									else 
										classValue = "QRYODD";
									allergyClass =rs.getString("ALLERGY_CLASS");
									if  (allergyClass.equals("D"))
										allergyClassDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Drug.label","common_labels");										
									else if(allergyClass.equals("F"))
										allergyClassDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Food.label","common_labels");
									else if(allergyClass.equals("G"))
										allergyClassDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels");
									else if(allergyClass.equals("I"))
										allergyClassDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inhalant.label","common_labels");
									else if(allergyClass.equals("T"))
										allergyClassDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Topical.label","common_labels");
									else
										allergyClassDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");

										strErrMarkDate	= rs.getString("error_marked_date_1");
										strErrMarkDate	= com.ehis.util.DateUtils.convertDate(strErrMarkDate,"DMYHM","en",locale);

								%>
									<tr>
									<td class=<%=classValue%>><%=allergyClassDesc%></td>
									<td  class=<%=classValue%>><%=rs.getString("ALLERGIC_ITEM")%></td>
									<td  class=<%=classValue%>><%=rs.getString("allergy_type_desc")%></td>
									<td  class=<%=classValue%>><%=rs.getString("ERROR_MARKED_BY_ID")%></td>
									<td  class=<%=classValue%>><%=strErrMarkDate%></td>
									<%
										subString=(rs.getString("remarks")==null?" ":rs.getString("remarks"));
										len=subString.length();
											
										if ( len > 15 ) 
										{
											printString=subString.substring(0,15);
											%>
											<td  class=<%=classValue%> ><%=printString%><a onclick="showRemarks('<%=rs.getString("remarks")%>','y',5)" style='cursor:pointer; color: blue'><b>...</b></a></td>
											<% 
										}
										else
										{	%>
											<td class=<%=classValue%> ><%=rs.getString("remarks")==null?" ":rs.getString("remarks")%></td>
											<%
										}
									%>
									<tr>
								<%
									i++;
								}

					if(rs!=null)  rs.close();
					if(stmt!=null) stmt.close();
					
				}
				catch(Exception e)
				{
					//out.println("Exception "+e.toString());//common-icn-0181
					e.printStackTrace();//COMMON-ICN-0181
				}
				finally
				{
					
					if(con!=null)
					   ConnectionManager.returnConnection(con,request);
				} 
		%>
					<tr style='visibility:hidden'>
						<td class='columnHeadercenter' ><fmt:message key="Common.AllergyClass.label" bundle="${common_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="eCA.AllergicTo.label" bundle="${ca_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="Common.AllergicDesc.label" bundle="${common_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="eCA.ErrorMarkedBy.label" bundle="${ca_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
						<td class='columnHeadercenter' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					</tr>
		        </table>
	    </center>
	</body>
</html>
<script>setTimeout("alignWidth()",100);</script>

