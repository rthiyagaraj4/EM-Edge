<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html locale="true">
<head>
			<%
				String locale = (String)session.getAttribute("LOCALE");
				String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
				:"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";

				HttpSession httpSession = request.getSession(false);
				Properties p = (Properties)httpSession.getValue("jdbc");

				String strloggeduser	=  (String) httpSession.getValue("login_user");
				String strclientip ="";
				strclientip=p.getProperty("client_ip_address");

				String encounterId = request.getParameter("encounterId");
				String patientClass = request.getParameter("patientClass");
				String mealTypeCode = request.getParameter("mealTypeCode");
				String mealTypeDesc = request.getParameter("mealTypeDesc");
				String profileSL = request.getParameter("profileSL");
				String flag = request.getParameter("flag");
				String check = request.getParameter("check");
				
				String facility_id	= (String)session.getAttribute("facility_id");
				
				//ML-MMOH-CRF-0427 US3 starts
				String restrict_date_inpatients_yn=checkForNull(request.getParameter("restrict_date_inpatients_yn"));
				String maximum_days_allowed=checkForNull(request.getParameter("maximum_days_allowed"));
				boolean profileFlag=Boolean.valueOf(request.getParameter("profileFlag"));
				//ML-MMOH-CRF-0427 US3 ends				
	
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				Connection conn = null;
				conn = ConnectionManager.getConnection(request);
			%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>


	<title>Special Food Items</title>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type="text/javascript" src="../../eDS/js/PlaceBulkDietOrder.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<!--ML-MMOH-CRF-427 starts-->
	<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery.datetimepicker.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery-ui-timepicker-addon.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/timepicker.css"/>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>	
	
	<!--<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-ar.js"></script>
	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-th.js"></script>-->
	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-<%=locale%>.js"></script>
	<!--ML-MMOH-CRF-427 ends-->
	<script type="text/javascript">
	</script>

</head>
<body onLoad="defaultDisabled();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form action="">
		<TABLE width="100%" align="center" CELLSPACING="0" cellpadding="0" >
			<TR>
				<TABLE width="100%" id="Able" CELLSPACING="0" cellpadding="0" style="display:block;visibility:visible;height:70;width:100%;border: 0px outset #9999FF" class="DECEASED">
						<tr>
							<TD class="label">&nbsp;&nbsp;
								<fmt:message key="eOT.FreqBased.Label" bundle="${ot_labels}" />
							</TD>
							<td>
								<input type="checkbox" name="frequencyBasedYn" id="frequencyBasedYn" onclick="freqEnable(this.value);"/>
							</td>
							<TD noWrap class="label">
								<fmt:message key="Common.fromdate.label" bundle="${common_labels}" />
							</TD>
								<TD>

									<input type="text" name="from" id="from" id="from" size="16" maxlength="16" value="" onblur="isValidDate(this);" >
									<!--
									<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from');">
									<img src='../../eCommon/images/mandatory.gif'></img>
									-->
									<!--ML-MMOH-CRF-0427 US3 start-->
									<%
										if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
									%>
										<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='datepickerimg' onclick="grayOutCalendar('from',<%=maximum_days_allowed%>,'<%=locale%>')">
										<img src='../../eCommon/images/mandatory.gif' />
									<%	
									}else{
									%>	
									<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from');">																
									<img src='../../eCommon/images/mandatory.gif'></img>														
									<%	
									}
								%>
								<!--ML-MMOH-CRF-0427 US3  ends-->
									<input type='hidden' name='from.pattern' id='from.pattern' value='dd/MM/yyyy HH:mm'>
								</TD>
									<td id="mealTypesId" onclick="return mealTypeSpFoodItems(this,'<%=mealTypeCode%>','<%=mealTypeDesc%>');" align="left" class="label" colspan="2">
									<fmt:message key="eDS.mealTypes.Label" bundle="${ds_labels}" />
									<img src='../../eCommon/images/mandatory.gif'></img><!-- ML-MMOH-CRF-1060 -->
									</td>
							</tr>
						</TR>

							<tr>
								<TD noWrap class="label">&nbsp;&nbsp;
									<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}" />
								</TD>
								<TD>
									<select name="itemType" id="itemType" onchange="clearFood();">
										<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
										<%
// 											conn = ConnectionManager.getConnection(request);
											try{
												String splFoodMealTye_query = "SELECT DSITEMTYPE0_.SHORT_DESC AS SHORT_DESC, DSITEMTYPE0_.ITEM_TYPE AS ITEM_TYPE FROM DS_ITEM_TYPE_LANG_VW DSITEMTYPE0_ WHERE (DSITEMTYPE0_.EFF_STATUS='E' )AND(DSITEMTYPE0_.LANGUAGE_ID='"+locale+"' ) ORDER BY  2 , 1";
												pstmt = conn.prepareStatement(splFoodMealTye_query);
												rs = pstmt.executeQuery();
												while(rs != null && rs.next()){
													String SHORT_DESC = rs.getString(1);
													String ITEM_TYPE = rs.getString(2);
											%>
												<option value="<%=ITEM_TYPE%>">
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

									</select><img src='../../eCommon/images/mandatory.gif'></img>
									</TD>
									<TD noWrap class="label">
										<fmt:message key="Common.item.label" bundle="${common_labels}" />
									</TD>
									<TD>
										<input type="text" name="foodDesc" id="foodDesc" value="" size="10" onblur="if(this.value!='')showLookupForItemType(this);else foodType.value=''" > 
										<input type="button" name="click" id="click" value="?" onClick='return showLookupForItemType(document.getElementById("foodDesc"))' class="Button" />
										
										<img src='../../eCommon/images/mandatory.gif'></img>
										<INPUT type="hidden" name="foodType" id="foodType">
									</TD>
									<TD noWrap class="label">
										<fmt:message key="eOT.qty.Label" bundle="${ot_labels}" />
									</TD>
								<TD colspan="1">
									<input type="text" name="qty" id="qty" value="" maxlength="6" size="6" onkeyup="if(!CheckForNumber(this.value))this.value=''">
									<img src='../../eCommon/images/mandatory.gif'></img>
								</TD>
							</tr>

						</TABLE>

						<TABLE width="100%" id="Able" CELLSPACING="0" cellpadding="0" border ='0' style="display:block;visibility:visible;height:50;width:100%;border: 0px outset #9999FF" border="0">
							<TD noWrap class="label">&nbsp;&nbsp;
								<fmt:message key="eOT.frequency.Label" bundle="${ot_labels}" />
							</TD>
							<TD>
								<input type="text" name="frequency" id="frequency" onkeypress="checkDigit();" onkeyup="return setPeriod(this);" size="2" maxlength="2" />
								<img id="mandatory_Freq" src='../../eCommon/images/mandatory.gif'></img>
							</TD>
							</TD>
							<TD noWrap class="label">
								<fmt:message key="eOT.periodBetween.Label" bundle="${ot_labels}" />
							</TD>
							<TD class="label">
								<input type="text" name="periodBetween" id="periodBetween"  onblur="verify(this)" size="5" maxlength="5" />
								<img id="mandatory_PeriodBetweem" src='../../eCommon/images/mandatory.gif' alt=""></img>
							</TD>
							<TD align="right">
								<input type="button" name="" id="" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />' onClick="ValidRecords()" class="Button">
								<input type="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}" />' onClick="return deleteSpItemRow();" class="Button">
							</TD>
								<TD>
									<table border="0">
										<tbody id="FoodItems1" class="data">
										</tbody>
									</table>
									<table border="0">
										<tbody id="spFoodItems" class="data">
										</tbody>
								</table>
							</div>
						</TD>
							</td>

							</TABLE>
						</TABLE>
				</td>
			</tr>
			<TR>
				<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr style="BACKGROUND-COLOR:white;">
					<br />
						<td colspan="4">
							<br />
							<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:320;width:100%;border: 1px outset #9999FF;" align="center" >

								<TABLE border='1' cellpadding='2' cellspacing='0' width='100%' align='center' id="listContentTable">
									<tr>
										<th nowrap="nowrap">
											<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}" />
										</th>
										<th nowrap="nowrap">
											<fmt:message key="Common.fromdate.label" bundle="${common_labels}" />
										</th>
										<th nowrap="nowrap">
											<fmt:message key="eOT.foodType.Label" bundle="${ot_labels}" />
										</th>
										<th nowrap="nowrap">
											<fmt:message key="eOT.qty.Label" bundle="${ot_labels}" />
										</th>
										<th nowrap="nowrap">
											<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
										</th>
										<th nowrap="nowrap">
											<fmt:message key="eOT.frequency.Label" bundle="${ot_labels}" />
										</th>
										<th nowrap="nowrap">
											<fmt:message key="eOT.periodBetween.Label" bundle="${ot_labels}" />
										</th>
									</tr>

									</tr>
								</TABLE>
							</div>
						</td>
					</tr>
					<TR>
						<TD colspan="4" align="right">
<!-- 							<input type="button" name="" id="" value="Record" onClick="setSplFoodItemRec();setRecord();" class="Button"> -->
							<input type="button" name="" id="" value="Ok" onClick="setRecord();" class="Button">
							<input type="button" name="" id="" value="<fmt:message key='Common.close.label' bundle='${common_labels}'/>" onClick="top.close();" class="Button">
						</TD>
					</TR>
				</TABLE>
				</td>
			</tr>
		</TABLE>

		<input type="hidden" name="patientId" id="patientId" />
		<input type="hidden" name="encounterId" id="encounterId" value="<%=encounterId%>"/>
		<input type="hidden" name="patientClass" id="patientClass" value="<%=patientClass%>"/>
		<input type="hidden" name="locationCode" id="locationCode" />
		<input type="hidden" name="profileSL" id="profileSL" value="<%=profileSL%>" />
		<input type="hidden" name="flag" id="flag" value="<%=flag%>" />
		<input type="hidden" name="check" id="check" value="<%=check%>" />
		
		<input type="hidden" name="ageGroup" id="ageGroup" />

		<input type="hidden" name="addedFacilityId" id="addedFacilityId" value="<%=facility_id%>"/>
<!--		<input type="hidden" name="flag6" id="flag6" value="insertSplFoodItems"/>-->
		<input type="hidden" name="mealType" id="mealType" />
		<input type="hidden" name="dietCategoryForSpFood" id="dietCategoryForSpFood" />
		<input type="hidden" name="ageGroupCode" id="ageGroupCode" />

		<input type="hidden" name="dietType" id="dietType" />
		<input type="hidden" name="mealClass" id="mealClass" />
		<input type="hidden" name="kitchenCode" id="kitchenCode" />

		<input type="hidden" name="addedById" id="addedById" value="<%=strloggeduser%>" />
		<input type="hidden" name="workStationNo" id="workStationNo" value="<%=strclientip%>" />

		<input type="hidden" name="method" id="method" />
<!-- 		<input type="hidden" name="frequency" id="frequency" value="1"/> -->
		<INPUT type="hidden" name="servingUomCode" id="servingUomCode">
		<INPUT type="hidden" name="caloriVal" id="caloriVal">
		<input type="hidden" name="mealType" id="mealType" value=""/>
		<INPUT type="hidden" name="rowNo" id="rowNo" value="">
		<INPUT type="hidden" name="chkMTR" id="chkMTR" />
		<INPUT type="hidden" name="chkMTC" id="chkMTC" />
		<INPUT type="hidden" name="mealtype" id="mealtype" />
		<INPUT type="hidden" name="mealTypeDesc" id="mealTypeDesc" />
		<INPUT type="hidden" name="language_id" id="language_id" value="<%=locale%>" />
		<INPUT type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
		
		<!--ML-MMOH-CRF-0427-->
		<input type="hidden" name="profileFlag" id="profileFlag" id="profileFlag" value="<%=profileFlag%>" />
		<input type="hidden" name="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" id="restrict_date_inpatients_yn" value="<%=restrict_date_inpatients_yn%>" />
		<input type="hidden" name="maximum_days_allowed" id="maximum_days_allowed" id="maximum_days_allowed" value="<%=maximum_days_allowed%>" />
		<!--ML-MMOH-CRF-0427-->
</form>
<script type="text/javascript">
// getSlNo();
if(dialogArguments)
{
	var jsonObj=dialogArguments;
	//parent.specialFoodItemsObject=jsonObj;
	specialFoodItemsObject=jsonObj;
	if(jsonObj.items != null) {
		parent.spclFoodItemsArr=jsonObj.items;
	}
	if(jsonObj.items!=null) {
		var tableObj = document.getElementById("listContentTable");
		for (var i = 0; i < jsonObj.items.length; i++) {
		    var obj = jsonObj.items[i].item;
	        if (obj != null) {
	            var countRow = tableObj.rows.length;
	            var row_ind = 1;
	            var newRow = tableObj.insertRow(row_ind);
	            var newCellitemType = newRow.insertCell(newRow.cells.length);
	            var sub = "<A  href=\"#\" onclick=\"return fetchSpFoodItemRow('" + i + "','"+obj.freqFlag+"');\" >" + obj.itemTypeDesc + "</A>";
	            newCellitemType.innerHTML = sub;
	            var newCellDate = newRow.insertCell(newRow.cells.length);
	            newCellDate.appendChild(document.createTextNode(obj.from));
	            var newCellfoodType = newRow.insertCell(newRow.cells.length);
	            newCellfoodType.appendChild(document.createTextNode(obj.foodDesc));
	            var newCellqty = newRow.insertCell(newRow.cells.length);
				var temp = parseFloat((Math.round(obj.calorie*Math.pow(10,2))/Math.pow(10,2)));
	            newCellqty.appendChild(document.createTextNode(obj.qty+" "+obj.servingUomCode+"("+temp+" "+obj.energyUom+")"));
				var newCellMealType = newRow.insertCell(newRow.cells.length);
				newCellMealType.appendChild(document.createTextNode(obj.mealTypeDesc));

				var newCellFrequency = newRow.insertCell(newRow.cells.length);
				newCellFrequency.appendChild(document.createTextNode(obj.frequency));
					
				var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
				newCellPeriodBetween.appendChild(document.createTextNode(obj.periodBetween));
					
	        }
	    }
	}
}
</script> 
</body>
</html>

