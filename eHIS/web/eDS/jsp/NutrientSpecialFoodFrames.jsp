<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
<head>
<%      
        //Added Against MMS Vulnerability Issue - Starts
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		//Added Against MMS Vulnerability Issue - Ends
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
		(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";
		//Checkstyle Violation commented by Munisekhar		
		//String facility_id	= (String)session.getAttribute("facility_id");
		String params = request.getQueryString();
		System.err.println("params :NutrientSpecialFoodFrames :"+params);
		String CalledFrom=request.getParameter("calledFrom");
		//String str = request.getParameter("MealItemsArray");
		String Title=request.getParameter("Title");
 %>
 <script type="text/javascript">
var params1="<%=params%>";
function onSuccess(){
	//parent.f_query_add_mod.location.reload();
// 		var formObj =mealMenu.document.forms[0];
// 		var params = formObj.paramValues.value;
		
		mealMenu.location.href="../../eDS/jsp/mealMenuItems.jsp?"+params1;
}
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

    <title><%=Title%></title>
</head>
		<!-- 	<frameset rows="*,0%,10%" id="frames" frameborder="no" framespacing="0"> -->
			<%
				if(CalledFrom.equals("Nutrient")){
				System.err.println("line 37 came in nutrient");
			%>
				
					<iframe name='nutrient' id='nutrient' src="../../eDS/jsp/NutrientApp.jsp?<%=params%>" scrolling='no' style="height:82vh;width:99vw" ></iframe>
			<%		
				}else if(CalledFrom.equals("SpecialFoodItem")){
			%>	
				<iframe name='spfooditem' id='spfooditem' src="../../eDS/jsp/SpFoodItems.jsp?<%=params%>" scrolling='no' style="height:82vh;width:99vw"></iframe>
			<%	
				}else if(CalledFrom.equals("SpecialFoodItemForBulkOrder")){
			%>
				<iframe name='spfooditem' id='spfooditem' src="../../eDS/jsp/SpFoodItemsForBulkOrder.jsp?<%=params%>" scrolling='no' style="height:82vh;width:99vw"></iframe>
			<%
				}
			%>
			
			<iframe name='qa_query_result' id='qa_query_result' src="../../eCommon/html/blank.html" frameborder=0 style="height:6vh;width:99vw"></iframe>
			<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style="height:10vh;width:99vw"></iframe>
	 <!--  </frameset> -->

</html>

