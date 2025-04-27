<!DOCTYPE html>
<%@  page import ="java.util.*,java.sql.*,java.net.*,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>




<html lang="en">
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/messages.js' language='javascript'></script>
 <script src='../../eDS/js/GenerateMealPlan.js' language='javascript'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
 </head>
	<script>
		function getSysDateForDischargePatients(){
			var locale= document.getElementById("locale").value;
		}

	</script>
	<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="GenerateMealPlanForm" id="GenerateMealPlanForm" method="post" action="GenerateMealPlanAction" target="messageFrame">


		<%
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			//Checkstyle Violation commented by Munisekhar
			//String facility_id  = (String) session.getValue("facility_id");
			//String params="";
			//String source ="";
			//String duration ="";
			String sql="";
			String locale=(String) session.getValue("LOCALE");
			String strCode ="";
			String strDesc ="";
			String servingDate="";

			try{

				conn = ConnectionManager.getConnection(request);


				pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();

		%>

			<table border='0' cellpadding='2' cellspacing='0' width='40%' align='left'>


			<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
					</td>
					<td align="right" class='label'>
					<input type="text" name="servingDate" id="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);checkDateValidate(this)'>
								<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
							<img src='../../eCommon/images/mandatory.gif' />
					</td>
				</tr>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}"/>
					</td>
					<td align="right" class='label'>
						<select name="dietCategory" id="dietCategory"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
						<%
									try
									{
									sql ="SELECT  DIET_CATEGORY_CODE,DESCRIPTION FROM DS_DIET_CATEGORY_LANG_VW  where language_id ='"+locale+"'";

											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>

							<option value="<%=strCode%>"><%=strDesc%></option>

							<%}

									}
									  catch(Exception DCat)	  {}
									   finally
									   {//Checkstyle Correction added by Munisekhar
										   if(rst!= null) rst.close();
										    if(pstmt!= null) pstmt.close();
									   }

								%>

					</td>
				</tr>
				<tr>
					<td align="left" class='label'>
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
					</td>
					<td align="right" class='label'>
						<select name="mealType" id="mealType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

						<%
									try
									{
									sql ="select MEAL_TYPE,SHORT_DESC From  DS_MEAL_TYPE_LANG_VW where language_id ='"+locale+"'";

											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>

							<option value="<%=strCode%>"><%=strDesc%></option>

							<%}

									}
									  catch(Exception DCat)	  {}
									   finally
									   {//Checkstyle Correction added by Munisekhar
										   if(rst!= null) rst.close();
										   if(pstmt!= null) pstmt.close();
									   }

								%>
					</td>
				</tr>
			</table>

			<%
			}
		catch(Exception e){
			e.printStackTrace();
			out.println(e);
		}finally{

		if(conn!=null)  ConnectionManager.returnConnection(conn, request);
		}
			 %>
			 <input type="hidden" name="tab_id" id="tab_id" value="DsMealPlanDischarge">
		</form>
</body>
</html>

