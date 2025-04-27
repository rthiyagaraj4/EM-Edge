<!DOCTYPE html>
<!-- New file created against MMS-DM-CRF-0044 -->
<%@  page import ="java.util.*,java.sql.*,java.net.*,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eDS/js/GenerateMealPlan.js' language='javascript'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>

<script type="text/javascript">
	function callPatientSearch(){
			var pat_id =  PatientSearch();
			if(pat_id != null)
			document.getElementById("patientId").value = pat_id;
		}

	function getSysForGenerateMealPlanDate(){
			var locale = document.getElementById("locale").value;
		}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<br>
<form name="GenerateMealPlanForm" id="GenerateMealPlanForm" method="post"  target="messageFrame">
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String facility_id  = (String) session.getValue("facility_id");
	String sql="";
	String strCode="";
	String strDesc="";
	String locale=(String) session.getValue("LOCALE");
	String servingDate ="";
	String maxMealPlan="";

	try{

		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

		rst = pstmt.executeQuery();

		while(rst.next()){
			servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();

        pstmt = conn.prepareStatement("select MAX_MEAL_PLAN_CREAT_DAYS from ds_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'");

		rst = pstmt.executeQuery();

		while(rst.next()){
			maxMealPlan = rst.getString(1);
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
				<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);checkDateValidate(this);maxMealPlandDate(this);'/>
				<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
				<img src='../../eCommon/images/mandatory.gif' />
			</td>
			</tr>
		<tr>
			<td align="left" class='label'> <fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}"/> </td>
			<td align="right" class='label'>
			<select name="dietCategory" id="dietCategory"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
			<%
				try
				{
					sql ="SELECT  DIET_CATEGORY_CODE,ds_get_desc.ds_diet_category(DIET_CATEGORY_CODE,'"+locale+"',1) SHORT_DESC FROM ds_diet_category";

					pstmt=conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
					while(rst.next()){
					strCode = rst.getString(1);
					strDesc =  rst.getString(2);
			%>
					<option value="<%=strCode%>"><%=strDesc%></option>
			<%}
					}
					  catch(Exception  DCat)
						  {
						  System.out.println("DS generateMeal plan "+DCat);
					  }
					   finally
					   {
						   if(rst !=null) rst.close();
							if(pstmt !=null) pstmt.close();
					   }
				%>
			</td>
			</tr>			
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.NursingUnit.Label" bundle="${ot_labels}"/>
				</td>
				<td align="right" class='label'>
			<select name="nursingUnit" id="nursingUnit"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
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
			<%}
				}
				catch(Exception DCat)	  {}
				   finally
				   {
					   if(rst !=null) rst.close();
						if(pstmt !=null) pstmt.close();
				   }
			%>
			</td>
			</tr>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
				</td>
				<td align="right" class='label'>
					<select name="mealClass" id="mealClass"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

					<%
						try
						{										
							sql = "SELECT MEAL_CLASS, ds_get_desc.ds_meal_class(MEAL_CLASS,'"+locale+"',2)  FROM DS_MEAL_CLASS where EFF_STATUS='E'" ;

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
						   {
							   if(rst !=null) rst.close();
								if(pstmt !=null) pstmt.close();
						   }

					%>
				</td>
			</tr>
			<tr>
				<td align="right" class='label'>
				<fmt:message key="eOT.RegnerateMealplan.Label" bundle="${ot_labels}"/>
				</td>
				<td  class='label'>
						<input type="checkbox" name="regnYn" id="regnYn" value="on">
				</td>
			</tr>
			<tr>
				<td align="left" class='label'>
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
				</td>
				<td align="right" class='label'>
					<select name="dietType" id="dietType" multiple>
				<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>					<%
							try
							{
							sql ="SELECT DIET_TYPE,DS_GET_DESC.DS_DIET_TYPE(DIET_TYPE,'"+locale+"',2) from  DS_DIET_TYPE WHERE EFF_STATUS='E'" ;
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
							   {
								   if(rst !=null) rst.close();
									if(pstmt !=null) pstmt.close();
							   }
						%>
			</td>
	</tr>
	<tr>
		<%   String pat_id_length="";
			try{
				pstmt = conn.prepareStatement("select patient_id_length from mp_param where MODULE_ID='MP'");
				rst	=pstmt.executeQuery();
				if (rst.next() && rst != null)
				 {
				  pat_id_length = rst.getString(1);
				  
				 }
				}catch(Exception e){
					e.printStackTrace();
				}
				finally	{
				  if(rst !=null) rst.close();
				  if(pstmt != null) pstmt.close();
						}
			 %>
			<td align="left" class='label'>
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			</td>
			<td align="right" class='label'>
				<input type="text" name="patientId" id="patientId"  maxlength='<%=pat_id_length%>' onKeypress='return CheckForSpecChars(event);' size='12' value="">
				<input align='right' type="button" class='BUTTON' name=search id=search value='?'  class="button" onClick="callPatientSearch()">
			</td>
			</tr>
		</table>
<%
	}
	catch(Exception e){
		e.printStackTrace();
		out.println(e);
	}finally{
	if(conn!=null)
		ConnectionManager.returnConnection(conn, request);
	}
%>
		<input type="hidden" name="tab_id" id="tab_id" value="GenerateMealPlan"/>
		<input type="hidden" name="maxMealPlan" id="maxMealPlan" value="<%=maxMealPlan%>"/>
	</form>
</body>
</html>

