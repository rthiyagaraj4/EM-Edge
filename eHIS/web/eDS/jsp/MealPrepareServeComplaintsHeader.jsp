<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"
%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<%
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id	= (String)session.getAttribute("facility_id");
	String params = request.getQueryString();
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%  
    //Added Against MMS Vulnerability Issue - Starts
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String imgUrl = "";
	if (sStyle.equals("IeStyle.css")) {
		imgUrl = "../../eCommon/images/searchBoxBG.jpg";
	}
%>
<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eDS/js/MealPreparedServedComplaints.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%

	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String ward_code="";
	String ward_description="";
	String mealtype_description="";
	String mealtype_code="";
	String sql = "";
	String SystemDate_display="";
	String servingDate="";
try{
	con = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
	rs = stmt.executeQuery();
	while(rs.next()){
		servingDate = rs.getString("CURRENT_DATE");
	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();

	SystemDate_display = DateUtils.convertDate(servingDate,"DMY" ,"en",localeName);

	}catch(Exception e)
	{
		e.printStackTrace();
		out.println("exp"+e);
	}
	finally{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	//ML-MMOH-CRF-0687
	boolean isComplaintCnt = false;
	isComplaintCnt = CommonBean.isSiteSpecific(con,"DS","DS_NOTIFICATIONS");
	//ML-MMOH-CRF-0687
	
	//Added Against ML-MMOH-SCF-1681 Starts
	boolean isNotification = false;
	isNotification = CommonBean.isSiteSpecific(con,"DS","DS_MEAL_COMPLAINTS");
	//Added Against ML-MMOH-SCF-1681 Ends
						
		
%>
	<form name="MealAcknowledgementForm" id="MealAcknowledgementForm" action="/MealPreparedServedComplaintsAction" method="post">
		<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			<tr>
				<td colspan="1" class="label">
					<fmt:message key="Common.date.label" bundle="${common_labels}" />
					<input type="text" name="date_mealtype" id="date_mealtype" size="10" maxlength="10" value="<%=SystemDate_display%>"  
					onblur="isValidDate(this);" >
					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_mealtype');" >
                    <img src='../../eCommon/images/mandatory.gif' align='center'>
				</td>
				<td colspan="1" class="label">
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
					<select name="mealType" id="mealType">
						<option value=''>
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>

		<% try
			  {
				//sql= "select meal_type,short_desc from Ds_Meal_Type where eff_Status ='E'";
				sql= "select meal_type,ds_get_desc.ds_meal_type(meal_type,'"+locale+"',2) from Ds_Meal_Type where eff_Status ='E' AND nvl(IP_MEAL_ORDER_YN,'N') = 'Y' order by meal_order";//ML-MMOH-CRF-1006 - US4
				stmt=con.prepareStatement(sql);
				rs=stmt.executeQuery();
				if(rs!=null)
				{
				   while(rs.next())
						{
							mealtype_code=rs.getString(1);
							mealtype_description=rs.getString(2);
							%>
						   <option value="<%=mealtype_code%>"><%=mealtype_description%>
					<%  }
			  }%>
					</select><img src='../../eCommon/images/mandatory.gif' align='center'>

			 <%}catch(Exception e){
			 e.printStackTrace();
			 }finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
				}
			}
		%>
		</td>
		<td colspan="1" class="label">
			<fmt:message key="eOT.NursingUnit.Label" bundle="${ot_labels}" />
			<select name="nursingUnit" id="nursingUnit">
				<option value=''>
					<fmt:message key="Common.Select.label" bundle="${common_labels}" />
				</option>

<% try
      {
		sql= "select ip_ward.nursing_Unit_Code, ip_ward.short_Desc from Ip_Nursing_Unit_Lang_Vw ip_ward where ip_ward.eff_Status ='E' and ip_ward.facility_Id='"+facility_id+"' and ip_ward.language_Id ='"+locale+"'  ORDER BY 2,1";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        ward_code=rs.getString(1);
			        ward_description=rs.getString(2);
                    %>
	               <option value="<%=ward_code%>"><%=ward_description%>
            <%  }
	  }%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'>

	 <% }catch(Exception e){
		 e.printStackTrace();
		 out.println("exp"+e);
	 }

	  finally{
	try{

	 if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e)
		{
		e.printStackTrace();
		out.println("exp"+e);
		}
}
%>
			</td>
	</tr>
	<tr align="right">
			<td align="right" colspan="3">
				<input type="button" value="<fmt:message key="Common.search.label" bundle="${common_labels}" />" property="Select" onclick="getMealPlanDetails()" class="BUTTON" />
				<input type="button"  value="Cancel" property="<fmt:message key="Common.cancel.label" bundle="${common_labels}" />" onclick="calCancel()" class="BUTTON" />
				</td>
	</tr>
</table>
		<input type='hidden' name='params' id='params' value='<%=params%>' >
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
		<input type='hidden' name='locale' id='locale' value='<%=locale%>' >
		<input type='hidden' name='isComplaintCnt' id='isComplaintCnt' value='<%=isComplaintCnt%>' >
		<input type='hidden' name='isNotification' id='isNotification' value='<%=isNotification%>' > <!--Added Against ML-MMOH-SCF-1681-->
</form>

</body>
</html>

