<!DOCTYPE html>
<!-- New file PlaceOrderRightsAddModify.jsp created against ML-MMOH-CRF-0677 on 10-oct-17  -->
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/PlaceOrderRights.js'></script>
<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String mode=request.getParameter("mode");
	String chk_edit_meals="checked"; 
	String chk_value1="Y";
	String chk_nut_supl="checked";
	String chk_value2="Y";
	String chk_food_dis="checked";
	String chk_value3="Y";
	String chk_spl_food_ord="checked";
	String chk_value4="Y";
	String appl_user_id = request.getParameter("appl_user_id")==null?"":request.getParameter( "appl_user_id" );
	String disable_flag="";
	String appl_user_name = request.getParameter("appl_user_name")==null?"":request.getParameter( "appl_user_name" );;
	String edit_meals_yn="";
	String nutrient_supplement_yn="";
	String food_dislike_yn="";
	String special_food_order_yn="";
	String sql_modify="";
	String facility_id=(String) session.getAttribute("facility_id");
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);

		sql_modify="SELECT A.APPL_USER_ID, B.APPL_USER_NAME, A.EDIT_MEALS_YN, A.NUTRIENT_SUPPLEMENT_YN, A.FOOD_DISLIKE_YN, A.SPECIAL_FOOD_ORDER_YN  FROM DS_PLACE_DIET_ORDER_RIGHTS A, SM_APPL_USER B WHERE A.OPERATING_FACILITY_ID = ? AND A.APPL_USER_ID = ? AND   B.APPL_USER_NAME=? ";
	
		stmt=con.prepareStatement(sql_modify);
		stmt.setString(1,facility_id);
		stmt.setString(2,appl_user_id);
		stmt.setString(3,appl_user_name);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			appl_user_id=rs.getString(1);
			appl_user_name=rs.getString(2);
			edit_meals_yn=rs.getString(3);
			nutrient_supplement_yn=rs.getString(4);
            food_dislike_yn=rs.getString(5);
			special_food_order_yn=rs.getString(6);				
		}
		
		if(edit_meals_yn.equals("Y"))
		{
			chk_edit_meals="checked";
		}
		else
		{
			chk_edit_meals="";
			chk_value1="N";
		}
		
		if(nutrient_supplement_yn.equals("Y"))
		{
			chk_nut_supl="checked";
		}
		else
		{
			chk_nut_supl="";
			chk_value2="N";
		}
		
		if(food_dislike_yn.equals("Y"))
		{
			chk_food_dis="checked";
		}
		else
		{
			chk_food_dis="";
			chk_value3="N";
		}
		
		if(special_food_order_yn.equals("Y"))
		{
			chk_spl_food_ord="checked";
		}
		else
		{
			chk_spl_food_ord="";
			chk_value4="N";
		}

}catch(Exception e)
	{
	e.printStackTrace();
	}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
		}		
	}
}
%>

<form name="placeOrderRights_form" id="placeOrderRights_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.PlaceOrderRightsServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
<% if(mode.equals("insert"))
	{ 
%>
<tr>
	<td class=label><fmt:message key="Common.name.label" bundle="${common_labels}"/>
	</td>
	<td class=fields>
		<input type="text" name="appl_user_id" id="appl_user_id" size="30" maxlength=30 value=" " onBlur="if(this.value!='')callLoginUser();">
		<input type="button" class="button" name="generic_search" id="generic_search" value="?"  onClick='callLoginUser();' >
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>	

<tr>
	<td class=label><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td class="fields">
		<input type="text" name="appl_user_name" id="appl_user_name" value=""  size=10 maxlength=10 readonly>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eDS.EditMeals.Label" bundle="${ds_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="edit_meals_yn" id="edit_meals_yn" checked="checked"
		onClick="editMealsYN();" value="<%=chk_value1%>">
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eDS.NutrientSupplement.Label" bundle="${ds_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="nutrient_supplement_yn" id="nutrient_supplement_yn" checked="checked"
		onClick="nutrientSupplementYN();" value="<%=chk_value2%>"> 
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eDS.FoodDislike.Label" bundle="${ds_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="food_dislike_yn" id="food_dislike_yn" checked="checked"
		onClick="foodDislikeYN();" value="<%=chk_value3%>">
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eDS.SpecialFoodOrder.Label" bundle="${ds_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="special_food_order_yn" id="special_food_order_yn" checked="checked"
		onClick="specialFoodOrderYN();" value="<%=chk_value4%>"> 
	</td>
</tr>

<%}else if(mode.equals("modify"))
{%>
<tr>
	<td class=label>
		<fmt:message key="Common.name.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="appl_user_name" id="appl_user_name" value="<%=appl_user_name%>"  disabled size=30 maxlength=30>
		<input type="button" class="button" name="generic_search" id="generic_search" value="?"  disabled >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label >
		<fmt:message key="Common.userid.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text"  name="appl_user_id" id="appl_user_id" size='30' value="<%=appl_user_id%>" disabled>
		<input type="hidden" name="appl_user_id1" id="appl_user_id1" value="<%=appl_user_id%>">
	</td> 
</tr>

<tr>
	<td class=label>
		<fmt:message key="eDS.EditMeals.Label" bundle="${ds_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="edit_meals_yn" id="edit_meals_yn"
		onClick="editMealsYN();" value="<%=chk_value1%>" <%=chk_edit_meals%>>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eDS.NutrientSupplement.Label" bundle="${ds_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="nutrient_supplement_yn" id="nutrient_supplement_yn"
		onClick="nutrientSupplementYN();" value="<%=chk_value2%>" <%=chk_nut_supl%>> 
	</td>
</tr>	

<tr>
	<td class=label>
		<fmt:message key="eDS.FoodDislike.Label" bundle="${ds_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="food_dislike_yn" id="food_dislike_yn"
		onClick="foodDislikeYN();" value="<%=chk_value3%>" <%=chk_food_dis%>>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eDS.SpecialFoodOrder.Label" bundle="${ds_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="special_food_order_yn" id="special_food_order_yn"
		onClick="specialFoodOrderYN();" value="<%=chk_value4%>" <%=chk_spl_food_ord%>>
	</td>
</tr>
<% }%>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='appl_user_name1' id='appl_user_name1' value="<%=appl_user_name%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

