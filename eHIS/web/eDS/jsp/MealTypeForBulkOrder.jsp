<!DOCTYPE html>
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
         //Checkstyle Violation commented by Munisekhar
		//String locale = (String)request.getAttribute("LOCALE");

		String mealtype=(String)request.getParameter("mealtype");

		String mealTypeCode=request.getParameter("mealTypeCode");
		String mealTypeDesc=request.getParameter("mealTypeDesc");


	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type="text/javascript" src="../../eDS/js/PlaceBulkDietOrder.js"></script>
	<title>MealTypes...</title>
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
					<TD>
						<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:136;width:233;border: 1px outset #9999FF" align="center">
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
		<input type="hidden" name="mealTypeCode" id="mealTypeCode" value="<%=mealTypeCode%>" />
		<input type="hidden" name="mealTypeDesc" id="mealTypeDesc" value="<%=mealTypeDesc%>" />
		
		<input type="hidden" name="mealtype" id="mealtype" value="<%=mealtype%>" />
		<script>
			var mealTypeCode = document.getElementById("mealTypeCode").value;
			var mealTypeDesc = document.getElementById("mealTypeDesc").value;
			
			var mealtype = document.getElementById("mealtype").value;
			getMealTypes(mealTypeCode,mealTypeDesc,mealtype);
		</script>
	</form>

</body>

</html>

