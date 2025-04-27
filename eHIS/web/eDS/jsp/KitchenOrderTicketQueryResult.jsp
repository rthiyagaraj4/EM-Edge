<!DOCTYPE html>
<!-- Created Against KDAH-CRF-0350 -->
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,java.util.HashMap,java.util.*,eCommon.Common.CommonBean,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<% 
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	%>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eDS/js/KitchenOrderTicket.js'></script>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%

		String patientClass = "";
		String servDate ="";
		String MealType ="";
		String DietCategory ="";
		String MealClass ="";
		String DietType ="";
		String kitchenCode ="";
		String short_desc ="";
		String prep_base_qty ="";
		String food_item_code ="";
		String kitchenQuery="";
		String dietType="";
	try{
		patientClass = request.getParameter("patient_Class");
		servDate =request.getParameter("serv_Date");
		MealType =request.getParameter("MealType");
		DietCategory =request.getParameter("DietCategory");
		MealClass =request.getParameter("MealClass");
		DietType =request.getParameter("DietType");
		kitchenCode =request.getParameter("kitchenCode");	
		System.out.println(patientClass);
		System.out.println(servDate);
		System.out.println(MealType);
		System.out.println(DietCategory);
		System.out.println(MealClass);
		System.out.println(DietType);
		System.out.println(kitchenCode);
		System.out.println(facility_id);
%>
<form name='QueryResult' id='QueryResult' method="post"  target="messageFrame">
<%
	String classValue= " ";
%>
<P>
<table align='right'>
<tr>
<td>
</td>
</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<div id="KitchenOrder" style="overflow-y:auto;height:385;width:100%;" align="center" >
<table border="1" width="100%" cellspacing='0' cellpadding='0' align='right'>
<% response.setIntHeader("Refresh", 120);%>
<%
try{	
		kitchenQuery = DSCommonBeanObj.getFoodItems(locale,facility_id,kitchenCode,MealType,patientClass,DietCategory,MealClass,DietType,servDate);
		System.out.println("kitchenQuery: " + kitchenQuery);
		String firstName = "";
		String lastName = "";
		String middleName = "";
		String mealType="";
		int k = 0;
		if(kitchenQuery !=null && !kitchenQuery.equals("")){
			String[] myStrArr = kitchenQuery.split("##");
		for( int y=0 ; y<myStrArr.length ; y++){						
			String[] myStrArr1 = myStrArr[y].split(",");							
			 if(k%2 == 0)
				classValue = "QRYEVEN";
			 else
			 classValue = "QRYODD";
			 
		firstName =	myStrArr1[0];
		lastName  =	myStrArr1[1];
		middleName= myStrArr1[2];             
										
		if(!firstName.equals(mealType)){%>									
	<tr class="">
		<td colspan='2' style=" background-color:#83AAB4; border:1px solid #fff; text-align: center; color:#fff;">
			<%=firstName%></td>			
	</tr>
		<tr>
		<th class='columnheader'><fmt:message key="eDS.FoodItem.Label" bundle="${ds_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>				
	</tr>
		<%}%>
	<tr>	
		<td class="<%=classValue%>">
		<%=lastName%>
		</td>
		<td class="<%=classValue%>">
		<%=middleName%>
			</td>
	</tr>

<%	
	k++;
	mealType=firstName;
	}
	}else{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");			
		}
 }
catch(Exception e)
{
	e.printStackTrace();
} 
%>		
</table>
</div>
<br/>
<table width="100%">
	<tr>
		<td width="40%" ></td>
		<td width="25%"></td>
		<td width="25%"></td>
		<td width="10%" colspan='6' align="right" class="label">
		<input type="button" class='BUTTON' name="print" id="print" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onclick="submitForm1();"/>
		</td>
	</tr>	
</table>
</center>
<br><center>
<%
}
catch(ArrayIndexOutOfBoundsException e)
{
    e.printStackTrace();
	System.err.println("KitchenOrderTicketQueryResult.jsp===ArrayIndexOutOfBoundsException======="+e);
}
catch(Exception e)
{
    e.printStackTrace();
	System.err.println("KitchenOrderTicketQueryResult.jsp=========="+e);
}
%>
</center>
		<input type='hidden' name="servDate" id="servDate" value="<%=servDate%>">
		<input type='hidden' name="Patient_Class" id="Patient_Class" value="<%=patientClass%>">
		<input type='hidden' name="MealType" id="MealType" value="<%=MealType%>">
		<input type='hidden' name="DietCategory" id="DietCategory" value="<%=DietCategory%>">
		<input type='hidden' name="MealClass" id="MealClass" value="<%=MealClass%>">
		<input type='hidden' name="DietType" id="DietType" value="<%=DietType%>">
		<input type='hidden' name="kitchenCode" id="kitchenCode" value="<%=kitchenCode%>">
		<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
		<input type="hidden" name="p_report_id" id="p_report_id" value="DSKITORDTKT">
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
		<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
</form>
</body>
</html>

