<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
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
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
					.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
					.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	if (sStyle == null)
		sStyle = "IeStyle.css";
	String mealtype=(String)request.getParameter("mealtype");
	String fecthedMealTypes=request.getParameter("fecthedMealTypes");
	String facility_Id	= (String)session.getAttribute("facility_id");//Added Against ML-MMOH-CRF-0825
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
<title>MealTypes...</title>
<style type="text/css">
@import url(../../eDS/css/css2/themes/winxp/skin.css);
</style>
<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	//Added Against ML-MMOH-CRF-0825 Starts Here
	PreparedStatement pstmt = null;
	ResultSet rs=null;	
	String LATE_IRREGULAR_DIET_ORD_FOR_SP = "";
	Connection conn = null;
	conn = ConnectionManager.getConnection(request);	
	
	String Late_Irr_SUP_Query = "select LATE_IRREGULAR_DIET_ORD_FOR_SP from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ? "; 
	pstmt = conn.prepareStatement(Late_Irr_SUP_Query);	
	pstmt.setString(1,facility_Id);	
	rs	= pstmt.executeQuery();
	if(rs != null && rs.next()){
		LATE_IRREGULAR_DIET_ORD_FOR_SP=rs.getString("LATE_IRREGULAR_DIET_ORD_FOR_SP");
	}	
	//Added Against ML-MMOH-CRF-0825 Ends Here
%>
<body>
<form name="" id="" action="" target="messageFrame">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
	<tr id="contentsForAssignDietType" style="display:inline;">
		<TD>
			<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:85vh;width:95vw;border: 1px outset #9999FF" align="center">
			<TABLE width="100%" id="AbleM" CELLSPACING="0" cellpadding="0">
			</TABLE>
			</div>
		</TD>
	</tr>
	<TR>
		<TD colspan="4" align="center">
			<input type="button" name="Close" id="Close" value="<fmt:message key='Common.close.label' bundle='${common_labels}'/>" onClick="getMealTypesSpFoodItems()" class="Button">
		</TD>
	</TR>
	</table>
	<input type="hidden" name="test" id="test" value="Test" />
	<input type="hidden" name="fecthedMealTypes" id="fecthedMealTypes" value="<%=fecthedMealTypes%>" />
	<input type="hidden" name="mealtype" id="mealtype" value="<%=mealtype%>" />
	<!--Added Against ML-MMOH-CRF-0825 Starts Here -->
	<input type="hidden" id ="facility_Id" name="facility_Id" id="facility_Id" value="<%=facility_Id%>" />	
	<input type="hidden" name="LATE_IRREGULAR_DIET_ORD_FOR_SP" id="LATE_IRREGULAR_DIET_ORD_FOR_SP" id="LATE_IRREGULAR_DIET_ORD_FOR_SP" value="<%=LATE_IRREGULAR_DIET_ORD_FOR_SP%>" />
	<!--Added Against ML-MMOH-CRF-0825 Ends Here -->
	<script>
		var fecthedMealTypes = document.getElementById("fecthedMealTypes").value;
		var mealtype = document.getElementById("mealtype").value;
		getMealTypes(fecthedMealTypes,mealtype);
	</script>
	</form>
</body>
</html>

