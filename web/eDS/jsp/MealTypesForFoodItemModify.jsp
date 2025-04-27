<!DOCTYPE html>
<!-- Newly Created for KDAH-CRF-0359.1-->
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
	<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
					.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
					.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		if (sStyle == null)
			sStyle = "IeStyle.css";
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String Existingcode=request.getParameter("ExistingItemcode");
	//String fetchedMealTypes=request.getParameter("fetchedMealTypes");
	StringBuffer fetchedMealTypes = new StringBuffer(request.getParameter("fetchedMealTypes"));
	String mealtype=(String)request.getParameter("mealtype");
	String dietcode=request.getParameter("dietcode");
	int maxRecord=0;
	String sql_mealtype = "";
	sql_mealtype="select distinct meal_type, ds_get_desc.ds_meal_type(meal_type,'en', '2') meal_type_desc from ds_menu where MENU_CODE IN (select MENU_CODE from ds_menu_item where ITEM_CODE = '"+Existingcode+"') and diet_type IN ("+dietcode+")  AND meal_type IS NOT NULL";
	System.err.println("sql_mealtype"+sql_mealtype);
	try{
			conn = ConnectionManager.getConnection(request);
			pstmt = conn.prepareStatement(sql_mealtype,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
			rst	= pstmt.executeQuery();			
			int l=0;
			//getting maximum record
	    	rst.last();	maxRecord = rst.getRow();		
			//again move the resultset pointer to initial position
			rst.beforeFirst();	
		while(rst != null && rst.next())
		{
			l++;
			//fetchedMealTypes+=rst.getString(1)+",";
			fetchedMealTypes.append(rst.getString(1)).append(",");
			if(l == maxRecord){
			//fetchedMealTypes+=rst.getString(2);
			fetchedMealTypes.append(rst.getString(2));
			}else{
			//fetchedMealTypes+=rst.getString(2)+",";		
			fetchedMealTypes.append(rst.getString(2)).append(",");
			}
			System.err.println("fetchedMealTypes Mealtype=>"+fetchedMealTypes.toString());
		}
	 }
	catch(Exception e)
	 {
		e.printStackTrace();
	 }
	  finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(conn);
			}
			catch(Exception e){
				System.err.println("Exception in MealType Modify:"+e);
			}
		}
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type="text/javascript" src="../../eDS/js/FooditemModify.js"></script>
	<title>MealTypes</title>
	<style type="text/css">
	@import url(../../eDS/css/css2/themes/winxp/skin.css);
	</style>
	<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
	<form name="" id="" action="" target="messageFrame">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<tr id="contentsForAssignDietType" style="display:inline;">
					<td align="center">	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<% if(mealtype.equals("")){%>
					  <span class="label">Select All</span>
					  <input type="checkbox" onclick="getmealTypeSelectAll(this,<%=maxRecord%>)" name="mealTypeSelectAll" id="mealTypeSelectAll"></input>
					<% }%>
					 <div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:136;width:245;border: 1px outset #9999FF" align="center">
					        <TABLE width="100%" id="AbleM" CELLSPACING="0" cellpadding="0">
							</TABLE>
						</div>
					</td>
			   </tr>
			<tr>
				<td colspan="4" align="center">
				<% if(mealtype.equals("")){%>
					<input type="button" name="Close" id="Close" value="<fmt:message key='Common.ok.label' bundle='${common_labels}'/>" onClick="getMealTypesSpFoodItems()" class="Button">
				<% }%>
				</td>
			</tr>
		</table>
		
		<input type="hidden" name="fetchedMealTypes" id="fetchedMealTypes" value="<%=fetchedMealTypes.toString()%>" />
		<input type="hidden" name="mealtype" id="mealtype" value="<%=mealtype%>" />
		<input type="hidden" name="MealmaxRecord" id="MealmaxRecord" value="<%=maxRecord%>" /><!--ICN-064175-->
		<script>
			var fetchedMealTypes = document.getElementById("fetchedMealTypes").value;
			var mealtype = document.getElementById("mealtype").value;			
			getMealTypes(fetchedMealTypes,mealtype);		
		</script>
	</form>
</body>
</html>

