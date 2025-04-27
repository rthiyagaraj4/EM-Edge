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
<script language='javascript' src='../../eDS/js/FoodItemNutrients.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onload="parent.parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String nutrient = "";
   String contentValue = "";
   String mode = request.getParameter("mode");
%>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="NutrientsAdd" id="NutrientsAdd"  onload='FocusFirstElement()'  action="../../servlet/eDS.FoodItemServlet" method="post" target="messageFrame">

				<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' style="height:60vh;">
						<tr>
							<td class='label' align="left">
								<fmt:message key="eOT.Nutrient.Label" bundle="${ot_labels}"/>
							</td>
							<td nowrap>
								<input type="text" name="nutrient_Code" id="nutrient_Code" value="<%=nutrient %>" size="15" maxlength="15" onblur="getLookuponblur(document.NutrientsAdd.nutrient_Code);" /> <!-- IN:39847-->
								<input type="button" class='BUTTON' name="lookUp" id="lookUp" value="?" onClick="getLookup(document.NutrientsAdd.nutrient_Code);"/>
								<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						</tr>
						<tr>
							<td class='label' align="left">
								<fmt:message key="eOT.ContentValue.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<input type="text" name="content_Value" id="content_Value" value="<%=contentValue %>"  size="15" maxlength="8" onkeyup="checkPosAfterEnter(this);" onkeydown="return CheckValidNumber(event);" onblur="CheckPosNumber('content_Value');" /> <!-- //IN:39847 - Modified by Abirami -->
								<input type="hidden" name="hdnContentValue" id="hdnContentValue" value="<%=contentValue %>"/>
								<img src='../../eCommon/images/mandatory.gif'></img>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						</tr>
                       <tr>
							<td align="left" class="label" style="display:inline-flex;">
								 <input class="BUTTON" type="button" name="select" id="select" value="Select" onClick="selectRecord1();"/>
								 &nbsp;&nbsp;&nbsp;
								<input type="button" class='BUTTON' name="cancel" id="cancel" value="Cancel" onClick="cancelRecord();"/>
							</td>
						</tr>
					</table>

			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='forUpdate' id='forUpdate' value=''>
		</form>
	</body>
</html>


