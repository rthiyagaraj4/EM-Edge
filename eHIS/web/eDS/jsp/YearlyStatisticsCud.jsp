<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/YearlyStatistics.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function callPatientSearch(){

	var pat_id =  PatientSearch();
	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

//56035
function changeRepId()
{	
	var repType = document.getElementById("repType").value;	
	if(repType == 'Summary')
	{
		document.getElementById("report_id").value = "DSRYWSDT";
		document.getElementById("p_report_id").value = "DSRYWSDT";
	}
	else if(repType == 'Detail')
	{
		document.getElementById("report_id").value = "DSRYWDDT";
		document.getElementById("p_report_id").value = "DSRYWDDT";
	}
}
//56035
</script>

</head>


	<%
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String facility_id  = (String) session.getValue("facility_id");
			//Checkstyle Violation commented by Munisekhar
			//String params="";
			//String source ="";
			//String duration ="";
			String sql="";
			String strCode ="";
			String strDesc ="";
			String servingDate="";

			try{

				conn = ConnectionManager.getConnection(request);


				pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'yyyy') CURRENT_DATE FROM DUAL");

				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = rst.getString("CURRENT_DATE");
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();

		%>
<form name="MonthlyStatisticsReport" id="MonthlyStatisticsReport" method="post"  target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
				<tr>
					<td  class="label">
						<fmt:message key="Common.date.label" bundle="${common_labels}"/>
					</td>
					<td>
						<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
						<img src='../../eCommon/images/mandatory.gif' />
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td  class="label">
						<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
					</td>
					<td  class='label'>
					<select name="kitchen" id="kitchen"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

						<%
									try
									{
									sql ="select  KITCHEN_CODE,SHORT_DESC  from DS_KITCHENS_LANG_VW  where language_id ='"+locale+"' and operating_facility_id ='"+facility_id+"'";

											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>

							<option value="<%=strCode%>"><%=strDesc%></option>

							<%}

									}
									  catch(Exception DCat)
										  {
										  System.out.println("GenerateMeal Plan Kitchen"+DCat);
									  }
									   finally
									   {
										   if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
									   }

								%>
								</select>
								<img src='../../eCommon/images/mandatory.gif' />

					</td>
					<td>
					</td>
				</tr>
				<tr>
   					<td>
					</td>
					<td align="left" class="label">
						<fmt:message key="Common.from.label" bundle="${common_labels}"/>
					</td>
					<td align="left" class="label">
						<fmt:message key="Common.to.label" bundle="${common_labels}"/>
					</td>
				</tr>
				<tr>
					<td  class="label">
						<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}"/>
					</td>
					<td  class='label'>
						<select name="nursingUnitFrom" id="nursingUnitFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<%
									try
									{
										sql ="SELECT NURSING_UNIT_CODE ,SHORT_DESC  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'";

											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>

						<option value="<%=strCode%>"><%=strDesc%></option>
					<%} %>
						</select>
					</td>
							<%

									}
									  catch(Exception DCat)	  {}
									   finally
									   {
										   if(rst !=null) rst.close();
										    if(pstmt !=null) pstmt.close();
									   }

								%>

					<td  class='label'>
						<select name="nursingUnitTo" id="nursingUnitTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
							<%pstmt=conn.prepareStatement(sql);
							rst = pstmt.executeQuery();
							while(rst.next()){
								strCode = rst.getString(1);
								strDesc =  rst.getString(2); %>
						<option value="<%=strCode%>"><%=strDesc%></option>
							<%} %>
						</select>
					</td>
				</tr>
				<tr>
					<td  class="label">
						<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
					</td>
					<td  class='label'>
						<select name="dietTypeFrom" id="dietTypeFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

					<%
									try
									{
									sql ="SELECT DIET_TYPE,SHORT_DESC from  DS_DIET_TYPE_LANG_VW  WHERE  LANGUAGE_ID ='"+locale+"' AND EFF_STATUS='E'" ;

											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>

							<option value="<%=strCode%>"><%=strDesc%></option>
					<%} %>
						</select>
					</td>
					<td  class='label'>
						<select name="dietTypeTo" id="dietTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
							<%pstmt=conn.prepareStatement(sql);
							rst = pstmt.executeQuery();
							while(rst.next()){
								strCode = rst.getString(1);
								strDesc =  rst.getString(2); %>
						<option value="<%=strCode%>"><%=strDesc%></option>
							<%} %>
						</select>
					</td>
							<%

									}
									  catch(Exception DCat)	  {}
									   finally
									   {
										   if(rst !=null) rst.close();
										    if(pstmt !=null) pstmt.close();
									   }
								}
								catch(Exception DCat)	  {}
								 finally
								   {
										try{
											if(pstmt!=null) pstmt.close();
											if(rst!=null) rst.close();
											ConnectionManager.returnConnection(conn);
										}
										catch(Exception e){
											System.err.println("Exception in Yearly Statistics CUD.jsp"+e);
										}
								   }

								%>
			</tr>
				<tr>
					<td  class="label">
							<fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>
					</td>
					<td align="left">
							<select name="repType" id="repType"  onchange="changeRepId();"><!--56035-->
							<option value="Summary"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
							<option value="Detail"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
							</select>
						</td>
					<td>
					</td>
				</tr>

			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
		</table>
			<input type="hidden" name="method" id="method"/>

			<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

			<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>

			<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
			<input type="hidden" name="module_id" id="module_id" value="DS">
			<!--
			<input type="hidden" name="p_report_id" id="p_report_id" value="DSRYWDDT">
			<input type="hidden" name="report_id" id="report_id" value="DSRYWDDT"/>
			-->
			
			<input type="hidden" name="report_id" id="report_id" id = "report_id" value="DSRYWSDT"/>
			<input type="hidden" name="p_report_id" id="p_report_id" id = "p_report_id" value="DSRYWSDT"/>
			
			
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			<input type='hidden' name='datepattrn' id='datepattrn' value="dd/MM/yyyy">
			<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>

			<input type="hidden" name="P_kitchen_code" id="P_kitchen_code" value=''>
			<input type='hidden' name='PARAM1' id='PARAM1' value=''>
			<input type='hidden' name='PARAM2' id='PARAM2' value=''>
			<input type='hidden' name='PARAM3' id='PARAM3' value=''>
			<input type='hidden' name='PARAM4' id='PARAM4' value=''>
			<input type='hidden' name='PARAM5' id='PARAM5' value=''>

		</form>
	</body>
</html>

