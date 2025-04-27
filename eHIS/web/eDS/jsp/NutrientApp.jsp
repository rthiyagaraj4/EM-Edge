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
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn = null;
	conn = ConnectionManager.getConnection(request);
	String check = request.getParameter("check");
	//ML-MMOH-CRF-0427 US3 starts
	String restrict_date_inpatients_yn=checkForNull(request.getParameter("restrict_date_inpatients_yn"));//ML-MMOH-CRF-0427
	String maximum_days_allowed=checkForNull(request.getParameter("maximum_days_allowed"));//ML-MMOH-CRF-0427
	boolean profileFlag=Boolean.valueOf(request.getParameter("profileFlag"));//ML-MMOH-CRF-0427
	//ML-MMOH-CRF-0427 US3 ends
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='StyleSheet1' href='../../eCommon/html/body.css' type='text/css'/>
<title><fmt:message key="eOT.nutrientSupplient.Label" bundle="${ot_labels}" /></title>
<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<Script Language="JavaScript" src="../../../eCommon/js/ValidateControl.js"></Script>

<!--ML-MMOH-CRF-0427 US3 start-->
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script> 
<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
<script language='javascript' src='../../eDS/js/common/semiDisabledDateTime/jquery.common.datepicker.js'></script>
<link rel="stylesheet" href="../../eDS/css/jquery-ui.css">
<script type="text/javascript" src="../../eDS/js/common/semiDisableDate/jquery-ui.js"></script>
<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-<%=locale%>.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!--ML-MMOH-CRF-0427 US3 ends-->	 
</head>
<body>
<form>
	<table width="100%" align="center" cellpadding="0" cellspacing="0" >
	<tr>
	<td>
	<table width="100%" cellspacing="0" cellpadding="2" align="center">
		<TR>
			<TD noWrap class="label" >
				<fmt:message key="Common.fromdate.label" bundle="${common_labels}" />
			</TD>
			<TD>
				<input type="text" name="from" id="from" id="from" size="12" value="">
				
				<!--ML-MMOH-CRF-0427 US3 start-->
				<%
					if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
				%>
					<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='datepickerimg' onclick="grayOutCalendar('from',<%=maximum_days_allowed%>,'<%=locale%>')">
					<img src='../../eCommon/images/mandatory.gif' />
			<%	
			}else{
			%>	
				<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from');"><img src='../../eCommon/images/mandatory.gif'></img>											
			<%	
			}
			%>
			<!--ML-MMOH-CRF-0427 US3 ends-->				<!--img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from');"-->
			<input type='hidden' name='from.pattern' id='from.pattern' value='dd/MM/yyyy HH:mm'>
			<!--img src='../../eCommon/images/mandatory.gif'></img-->
			</TD>
			<TD noWrap class="label" >
				<fmt:message key="Common.todate.label" bundle="${common_labels}" />
			</TD>
			<TD>
				<input type="text" name="to" id="to" id="to" size="12" value="">
				<!--ML-MMOH-CRF-0427 US3 start-->
			<%
				if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
			%>
			<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='datepickerimg' onclick="grayOutCalendar('to',<%=maximum_days_allowed%>,'<%=locale%>')">
				
			<%	
			}else{
			%>	
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to');">		
		<%	
			}
		%>
		<!--ML-MMOH-CRF-0427 US3 ends-->
			<!--img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to');"-->
			<input type='hidden' name='to.pattern' id='to.pattern' value='dd/MM/yyyy HH:mm'>
			</TD>
		</TR>
		<TR>
			<TD noWrap class="label" >
				<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}" />
			</TD>
			<TD>
				<select name="itemType" id="itemType" onchange="clearFood();">
				<option value="">
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
				<%
					conn = ConnectionManager.getConnection(request);
					try{
						//String splFoodMealTye_query = "SELECT DSITEMTYPE0_.SHORT_DESC AS SHORT_DESC, DSITEMTYPE0_.ITEM_TYPE AS ITEM_TYPE FROM DS_ITEM_TYPE_LANG_VW DSITEMTYPE0_ WHERE (DSITEMTYPE0_.EFF_STATUS='E' )AND(DSITEMTYPE0_.LANGUAGE_ID='"+locale+"' ) ORDER BY  2 , 1";
						String splFoodMealTye_query = "SELECT ds_get_desc.ds_item_type(DSITEMTYPE0_.ITEM_TYPE,'"+locale+"', 2) AS SHORT_DESC, DSITEMTYPE0_.ITEM_TYPE AS ITEM_TYPE FROM DS_ITEM_TYPE DSITEMTYPE0_ WHERE (DSITEMTYPE0_.EFF_STATUS='E' ) ORDER BY  2 , 1";
						pstmt = conn.prepareStatement(splFoodMealTye_query);
						rs = pstmt.executeQuery();
						while(rs != null && rs.next()){
							String SHORT_DESC = rs.getString(1);
							String ITEM_TYPE = rs.getString(2);
							if(SHORT_DESC != null && !SHORT_DESC.equals("")){
				%>
					<option value="<%=ITEM_TYPE%>">
								<%=SHORT_DESC%>
					</option>
				<%
					}
					}
					}catch(Exception e){
							e.printStackTrace();
						}finally{
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
							if(conn!=null)ConnectionManager.returnConnection(conn,request);
						}
				%>
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
			</TD>
			<TD noWrap class="label" >
				<fmt:message key="Common.item.label" bundle="${common_labels}" />
			</TD>
			<TD>
				<input type="text" name="foodDesc" id="foodDesc" value="" size="20">
				<input type="button" name="click" id="click" value="?" onClick="showLookupForItemType(foodDesc);" class="Button" />
				<img src='../../eCommon/images/mandatory.gif'></img>
			</TD>
		</TR>
		<TR>
			<TD noWrap class="label" >
				<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
			</TD>
			<TD>
				<select name="mealType" id="mealType">
					<option value="ALL">
					<fmt:message key="Common.all.label" bundle="${common_labels}" />
					<%
							conn = ConnectionManager.getConnection(request);
							try{
								//String splFoodMealTye_query = "SELECT MT.SHORT_DESC,MT.MEAL_TYPE FROM DS_MEAL_TYPE_LANG_VW MT WHERE MT.EFF_STATUS ='E' AND MT.LANGUAGE_ID='"+locale+"' ORDER BY  2 , 1";
								String splFoodMealTye_query = "SELECT ds_get_desc.ds_meal_type(MT.MEAL_TYPE,'"+locale+"', 2)  SHORT_DESC,MT.MEAL_TYPE,MT.MEAL_ORDER FROM DS_MEAL_TYPE MT WHERE MT.EFF_STATUS ='E' AND nvl(IP_MEAL_ORDER_YN,'N') = 'Y' ORDER BY  3";//ML-MMOH-CRF-1006 - US4
								pstmt = conn.prepareStatement(splFoodMealTye_query);
								rs = pstmt.executeQuery();
								while(rs != null && rs.next()){
									String SHORT_DESC = rs.getString(1);
									String MEAL_TYPE = rs.getString(2);
							%>
								<option value="<%=MEAL_TYPE%>">
												<%=SHORT_DESC%>
								</option>
							<%
								}
								}catch(Exception e){
									e.printStackTrace();
								}finally{
									if(rs!=null) rs.close();
									if(pstmt!=null) pstmt.close();
									if(conn!=null)ConnectionManager.returnConnection(conn,request);
								}
					%>
				</select>
			</TD>
			<TD noWrap class="label" >
				<fmt:message key="eOT.qty.Label" bundle="${ot_labels}" />
			</TD>
			<TD>
				<input type="text" name="qty" id="qty" value="" size="6" onkeyup="if(!CheckForNumber(this.value))this.value=''">
				<img src='../../eCommon/images/mandatory.gif'></img>
			</TD>
		</TR>
		<TR>
			<TD colspan="4" align="right">
				<input type="button" name="" id="" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />' onClick="AddItem()" class="Button">
				<input type="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}" />' onClick="return deleteRow();" class="Button">
				<INPUT type="hidden" name="rowNo" id="rowNo" value="">
				<INPUT type="hidden" name="foodType" id="foodType">
				<INPUT type="hidden" name="servingUomCode" id="servingUomCode">
			</TD>
			</TR>
			</table>
		</td>
		</tr>
		<TR>
		</td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr style="BACKGROUND-COLOR:white;">
			<br/>
				<td colspan="4" >
				<div id="listContentLayer" style="visibility:visible;overflow-y: scroll;height:65vh;width:100%;border: 1px outset #9999FF;" align="center" class="DECEASED" >

				<table border='1' cellpadding='2' cellspacing='0' width='100%' align='center' id="listContentTable">
				<tr>
					<th nowrap="nowrap">
						<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}" />
					</th>
					<th nowrap="nowrap" >
						<fmt:message key="Common.fromdate.label" bundle="${common_labels}" /> - <fmt:message key="Common.todate.label" bundle="${common_labels}" />
					</th>
					<th nowrap="nowrap">
						<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}" />
					</th>
					<th nowrap="nowrap">
						<fmt:message key="eOT.qty.Label" bundle="${ot_labels}" />
					</th>
				</tr>
				</table>
				</div>
				</td>
			</tr>
			<TR>
				<TD colspan="4" align="right">
					<input type="button" name="" id="" value="<fmt:message key="Common.close.label" bundle="${common_labels}" />" onClick="getRowDtls()" class="Button">
				</TD>
			</TR>
		</TABLE>
			</td>
		</tr>
		<input type="hidden" name="language_Id" id="language_Id" value="<%=locale%>">
		<input type="hidden" name="locale" id="locale" value="<%=locale%>" />
		<input type="hidden" name="fICode" id="fICode" />
		<input type="hidden" name="check" id="check" value="<%=check%>" />
		<input type="hidden" name="itemSlNo" id="itemSlNo" value="" />
		<!--ML-MMOH-CRF-0427-->
		<input type="hidden" name="profileFlag" id="profileFlag" id="profileFlag" value="<%=profileFlag%>" />
		<input type="hidden" name="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" value="<%=restrict_date_inpatients_yn%>" />
		<input type="hidden" name="maximum_days_allowed" id="maximum_days_allowed" id="maximum_days_allowed" value="<%=maximum_days_allowed%>" />
		<!--ML-MMOH-CRF-0427-->
	</table>
</form>
<script>
if(dialogArguments)
{
	nutriArr = dialogArguments;
	var tableObj = document.getElementById("listContentTable");
	var count =0;
	if(document.getElementById("check").value == "true"){
	for (var i = 0; i < nutriArr.length; i++) {
	var obj = nutriArr[i];
	if (obj != null) {
	if(obj[6]!="-1")
	{
		var countRow = tableObj.rows.length;
		var row_ind = 1;
		var newRow = tableObj.insertRow(row_ind);
		var newCellitemType = newRow.insertCell(newRow.cells.length);
		/* if(obj[6] == "0"){			
			var sub = "<A href=\"#\" onclick=\"return fetchRow('" + i + "');\" >" + obj[8] + "</A>";
		}else{
			var sub = "<A href=\"#\" onclick=\"return fetchRow('" + i + "');\" >" + obj[8] + "</A>";
		}*/ //Commented Against Nutrient Supplement & Special food item [IN:067653] 
		var sub = "<A href=\"#\" onclick=\"return fetchRow('" + i + "');\" >" + obj[8] + "</A>"; //Added Against Nutrient Supplement & Special food item [IN:067653]
	
		newCellitemType.innerHTML = sub;
		var newCellDate = newRow.insertCell(newRow.cells.length);
		if(obj[1] == "null"){
			obj[1] = "";
			newCellDate.appendChild(document.createTextNode(obj[0] + "-" + obj[1]));
		}else{
			newCellDate.appendChild(document.createTextNode(obj[0] + "-" + obj[1]));
		}
		
		var newCellfoodType = newRow.insertCell(newRow.cells.length);
		/* if(obj[6] == "0"){
			newCellfoodType.appendChild(document.createTextNode(obj[7]));
		}else{
			newCellfoodType.appendChild(document.createTextNode(obj[7]));
		}*/ //Commented Against Nutrient Supplement & Special food item [IN:067653]
		newCellfoodType.appendChild(document.createTextNode(obj[7]));//Added Against Nutrient Supplement & Special food item [IN:067653]
		var newCellqty = newRow.insertCell(newRow.cells.length);
		//newCellqty.innerHTML=obj[4]+" "+obj[9]+"("+obj[12]+" "+obj[13]+")" //Commented Against PMG2017-COMN-CRF-0012.1-US001
		newCellqty.innerHTML=obj[4]+" "+obj[17]+"("+obj[12]+" "+obj[16]+")" //Added Against PMG2017-COMN-CRF-0012.1-US001 and Modified Against Nutrient Supplement & Special food item [IN:067653]
	}
	}
	}
}else{
for (var i = 0; i < nutriArr.length; i++) {
	var obj = nutriArr[i];
	if (obj != null) {
	if(obj[6]!="-1")
	{
		var countRow = tableObj.rows.length;
		var row_ind = 1;
		var newRow = tableObj.insertRow(row_ind);
		var newCellitemType = newRow.insertCell(newRow.cells.length);
		var sub = "<A href=\"#\" onclick=\"return fetchRow('" + i + "');\" >" + obj[8] + "</A>";//Added Against Nutrient Supplement & Special food item [IN:067653] 
		newCellitemType.innerHTML = sub;
		var newCellDate = newRow.insertCell(newRow.cells.length);
	   if(obj[1] == " null"){
		  obj[1] = "";
		 newCellDate.appendChild(document.createTextNode(obj[0] + "-" + obj[1]));
	   }else{
		  newCellDate.appendChild(document.createTextNode(obj[0] + "-" + obj[1]));
	   }
			
		var newCellfoodType = newRow.insertCell(newRow.cells.length);
		newCellfoodType.appendChild(document.createTextNode(obj[7]));//Added Against Nutrient Supplement & Special food item [IN:067653] 
		var newCellqty = newRow.insertCell(newRow.cells.length);
		//newCellqty.appendChild(document.createTextNode(obj[4]));
		if(obj[16]==undefined){
			obj[16]=obj[14];
		}
		if(obj[17]==undefined){
			obj[17]=obj[15];
		}//Added Against Nutrient Supplement & Special food item [IN:067653]
		//newCellqty.innerHTML=obj[4]+" "+obj[9]+"("+obj[12]+" "+obj[13]+")" //Commented Against PMG2017-COMN-CRF-0012.1-US001
		newCellqty.innerHTML=obj[4]+" "+obj[17]+"("+obj[12]+" "+obj[16]+")"//Added Against PMG2017-COMN-CRF-0012.1-US001 and Modified Against Nutrient Supplement & Special food item [IN:067653]
		//alert("323,newCellqty.innerHTML=="+newCellqty.innerHTML);
		}
	}
}
}
}
</script>
</body>
</html>

