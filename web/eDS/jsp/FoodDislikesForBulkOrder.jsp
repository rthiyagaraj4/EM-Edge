<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<head>
	<%String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
				:"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";
				String locale = (String)session.getAttribute("LOCALE");

	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../../eCommon/js/ValidateControl.js"></Script>
	<title><fmt:message key="eOT.foodDislikes.Label" bundle="${ot_labels}" /></title>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type="text/javascript" src="../../eDS/js/PlaceBulkDietOrder.js"></script>
</head>
<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
					<TR align="center">
						<TD align="center" colspan="2" class="lable" >
							<fmt:message key="Common.item.label" bundle="${common_labels}" />
							<input type="hidden" name="foodType" id="foodType" value="">
							<input type="text" name="foodDesc" id="foodDesc" value="" onblur="if(this.value!='')showLookup(this);else foodType.value=''"/>
							<input type="button" name="click" id="click" value="?" onClick='showLookup(document.getElementById("foodDesc"));' class="Button"/>
							
<!-- 							<input type="text" name="foodDesc" id="foodDesc" value="" onblur="showLookup(this)"> -->
<!-- 							<input type="button" name="click" id="click" value="?" onClick="showLookup(document.getElementById(foodDesc))" class="Button"/> -->
						</TD>
					</TR>
					<TR>
						<TD colspan="2" align="right">
							<input type="button" name="" id="" value="<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />" onClick="AddFoodDislikeItem();" class="Button">
							 <input type="button" name="cancel" id="cancel" value="<fmt:message key="Common.cancel.label" bundle="${common_labels}" />" onClick="return deleteFoodDislikesRow();" class="Button">
							<input type="hidden" name="rowNo" id="rowNo" value="">
						</TD>
					</TR>
				</table>
		<TR>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr style="BACKGROUND-COLOR:white;">
						<br/>
						<td colspan="2">
							<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:200;width:100%;border: 1px outset #9999FF" align="center">
								<table border='1' cellpadding='2' cellspacing='0' width='75%' align='center' id="listContentTable">
									<tr>
										<th>
											<fmt:message key="Common.item.label" bundle="${common_labels}" />
										</th>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<TR>
						<TD colspan="4" align="right">
							<input type="button" name="" id="" value="<fmt:message key='Common.close.label' bundle='${common_labels}'/>" onClick="getFoodDislikeDtls()" class="Button">
						</TD>
					</TR>
					<input type="hidden" name="language_id" id="language_id" value="<%=locale%>"/>
				</table>
			</td>
		</TR>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
	if(dialogArguments)
	{
// 		foodDislikeList = dialogArguments;
		var jsonObj=dialogArguments;
		parent.foodDislikeJSONObj=jsonObj;
		var tableObj = document.getElementById("listContentTable");
		if(jsonObj.items != null) {
			parent.foodDislikeList=jsonObj.items;
		}		
		var count=0;
		if(jsonObj.items!=null) {
			for (var i = 0; i < jsonObj.items.length; i++) {
				var obj = jsonObj.items[i];
				if (obj.item != null) {
					if(obj.item.flag !="-1")
			        {
			            var countRow = tableObj.rows.length;
			            var row_ind = 1;
			            var newRow = tableObj.insertRow(row_ind);
			            newRow.id = countRowValue;
			            var newCellitemType = newRow.insertCell(newRow.cells.length);
			            var sub = "<A href=\"#\" onclick=\"return fetchFoodDislikesRow('" + i + "');\" >" + obj.item.itemDesc + "</A>";
								//alert(sub)
			            newCellitemType.innerHTML = sub;
			         }
				}
			}
		}
	}
	</script>
</body>

