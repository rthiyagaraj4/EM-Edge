<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
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
<script language='javascript' src='../../eDS/js/Recipe.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var  testpopup5="";
	var val="";

	function setval(){
		val=document.getElementById("prepInstructions_popup").value;
		document.getElementById("prepInstructions").value=val;

	}

	function test5popupactivate(anchor) {
		if(testpopup5=="")
			testpopup5 = new PopupWindow();
		val=document.getElementById("prepInstructions").value;
/* 		if(val == "" || val == null)
			document.getElementById("prepInstructions_popup").value="";
		else
			document.getElementById("prepInstructions_popup").value=val; */
		testpopup5.height=250;
		testpopup5.width=410;
		testpopup5.offsetX=-10;
		testpopup5.offsetY=10;
		testpopup5.autoHide();
		//getServerMessage("com.iba.ehis.ds.receipe.prepinstr");
		var prepLable = "Preparatory Instruction"; 
		//  modified by N Munisekhar on 23-May-2013 against [IN39908]
        var	prepLble="Preparatory Instruction"; 
		testpopup5.populate('<title>'+prepLable+'..</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left"> '+prepLble+'  </td></tr><tr><td  align="center"><textarea rows=12 cols=52 maxlength=2000 name="prepInstructions_popup" onkeyup="window.opener.document.getElementById("prepInstructions").value=this.value;">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();" value="OK"/></td></tr></table> </FORM></CENTER>');
		testpopup5.showPopup(anchor);
		//setval();
	}
</script>
</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
   String foodItem = "";
   String prepUom = "";
   String baseQty = "";
   String foodItemCode = "";
   int totalRows = 0;
   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;
   String mode = request.getParameter("mode");
   if("modify".equals(mode)){
   		try{
   			foodItem = request.getParameter("foodItem");
   			prepUom = request.getParameter("prepUom");
   			baseQty = request.getParameter("baseQty");
   			foodItemCode = request.getParameter("fooditem_Code");
   		}catch(Exception e){
	   		System.err.println("Error in RecipeAddModify.jsp->"+e);
			e.printStackTrace();
   		}
   }
%>
<br>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="recipe_form" id="recipe_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MenuCycleServlet" method="post" target="messageFrame">
		<table align="center" border='0' cellpadding='2' cellspacing='0' width='80%' align='center'>
			<tr>
				<td align="left" class="label">
					<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<input type='text' name="foodItemDesc" id="foodItemDesc" value='<%=foodItem %>' onblur="if(this.value!=''){ getLookup(foodItemDesc); }"/>
					<input type='button' class='button' value='?' onClick="getLookup(foodItemDesc);" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td colspan='2'>
				</td>
			</tr>

			<tr>
				<td align="left" class="label">
					<fmt:message key="eOT.PrepUOM.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<input type='text' name="prep_Uom" id="prep_Uom" value="<%=prepUom %>"/>
				</td>

				<td align="left" class="label">
					<fmt:message key="eOT.BaseQty.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<input type='text' name="base_Qty" id="base_Qty" value="<%=baseQty %>"/>
				</td>
			</tr>
			<tr>
				<td colspan=4 align="right">
					<a href="javascript:popUpInstructions()" onclick="test5popupactivate(this.id);return false;"
						name="prepAnchor"  id="prepAnchor" class="label"><fmt:message key="eOT.preparatoryInstruction.Label" bundle="${ot_labels}"/></a>
<!-- 						<input type="hidden" name="prepInstructions_popup" id="prepInstructions_popup" value="" maxlength="2000"/> -->
						<input type="hidden" name="prepInstructions" id="prepInstructions" value=""/>
					</td>
				</tr>
			</table>
		<br>
		<br>
		<br>
		<table align="center" border='0' cellpadding='2' cellspacing='0' width='80%' align='center'>
			<tr>
				<td width="50%">
					<table border='0' cellpadding='2' cellspacing='0' align='center'>
					<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(DlQuery.DL_DS_INGREDIENT);
						pstmt.setString(1, locale);
						rst = pstmt.executeQuery();
					%>
						<tr>
							<td align="left" class="label"> 
								<fmt:message key="eOT.Ingredients.Label" bundle="${ot_labels}"/>
							</td>
							<td nowrap>
								<select name="ingredient_Code" id="ingredient_Code" onBlur="changeIngredient(this)"><!-- Added Against PMG2017-COMN-CRF-0012.1-US004 -->
									<option value="">
										<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
									</option>
									<%while(rst.next()){%>
											<option value="<%=rst.getString("ingredient_code")%>">
									<%=rst.getString("short_desc") %>
									</option>
								<%}
								pstmt = null;
								rst = null;%>
								</select>
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>
						<tr>
							<td align="left" class="label">
								<fmt:message key="eOT.Qty.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<input type="text" name="qty" id="qty" maxlength="8" size="8" onblur="checkNumber(this)" />
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>
						<tr>
							<td align="left" class="label">
								<fmt:message key="eOT.Uom.Label" bundle="${ot_labels}"/>
							</td>
							<td nowrap>
								<select name="uom_Value" id="uom_Value" id="uom_Value" onBlur="changeUom(this)"><!-- Added Against PMG2017-COMN-CRF-0012.1-US004 -->
									<option value="">
										<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
									</option>
									<%pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
									pstmt.setString(1, locale);
									rst = pstmt.executeQuery();
									while(rst.next()) {%>
											<option value="<%=rst.getString("uom_code")%>">
									<%=rst.getString("short_desc") %>
									</option>
									<%}
									pstmt = null;
									rst = null;%>
								</select>
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>
						<tr>
							<td align="left" class="label">
							<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
							</td>
							<td>
								<input type="checkbox" name="status" id="status" value="E" />
							</td>						
						</tr>
				<%}catch(Exception e){
					System.err.println("Exception in Menu Time table:"+e);
					e.printStackTrace();
				}finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}catch(Exception e){
						System.err.println("Exception in Menu Time Table:"+e);
						e.printStackTrace();
					}
				}
				%>	<tr>
							<td align="right" class="label" colspan=2>
							<br>
								<input class="BUTTON" type="Button" name="select" id="select" value="Select" onClick="selectRecord1()">
								<input class="BUTTON" type="Button" name="cancel" id="cancel" value="Cancel" onClick="cancelRecord()">
							</td>
						</tr>
					</table>
				</td>
				<td>
					<div id="listContentLayer"
						style="display:block;visibility:visible;overflow:auto;height:197;width:500;border: 1px outset white"
						align="center">
						<table width="100%" id="listContentTable" border='1' cellpadding='2' cellspacing='0' align='center'>
							<tr>
								<th>
									<fmt:message key="eOT.Ingredients.Label" bundle="${ot_labels}"/>
								</th>
								<th>
									<fmt:message key="eOT.Qty.Label" bundle="${ot_labels}"/>
								</th>
								<th>
									<fmt:message key="eOT.Uom.Label" bundle="${ot_labels}"/>
								</th>
								<th>
									<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
								</th>
							</tr>
							<% try{
					con = ConnectionManager.getConnection(request);
					pstmt = con.prepareStatement(DlQuery.DL_FOOD_ITEM_INGREDIENT);
					pstmt.setString(1, foodItemCode);
					rst = pstmt.executeQuery();
					int i=0;
					int cnt=2;
					while(rst.next()){
						int counter=cnt-1;// Added Against PMG2017-COMN-CRF-0012.1-US004
					%>
						<tr>
						<!-- Modified Against PMG2017-COMN-CRF-0012.1-US004 Starts Here -->
						<td><a href='javascript:callfn12(<%=cnt%>);'><%=rst.getString("ingredient_desc")%></a>
						<input type="hidden" name="ingredientCode<%=counter%>" id="ingredientCode<%=counter%>" value="<%=rst.getString("ingredient_code")%>"/>
						</td> 
						<td><%=checkForNull(rst.getString("ingredient_qty"))%></td>
						<td><%=checkForNull(rst.getString("serving_uom_desc"))%>
						<input type='hidden' name='uomCode<%=counter%>' id='uomCode<%=counter%>'  value='<%=rst.getString("ingredient_uom")%>'/>
						</td>
						<!-- Modified Against PMG2017-COMN-CRF-0012.1-US004 Ends Here-->
						<td><%if("E".equals(rst.getString("eff_status"))){ %>
								<img src='../../eCommon/images/enabled.gif'></img>
							<%}else{%>
								<img src='../../eCommon/images/RRnwd.gif'></img>
							<%}%>
							</td>
						</tr>
						<input type='hidden' name='nutMode<%=i %>' id='nutMode<%=i %>' value='U'>
						<%i++;
						cnt++;%>
					<%}
					totalRows = i;
				}catch(Exception e){
					System.err.println("Exception in Food Item Nutrients:"+e);
					e.printStackTrace();
				}finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}catch(Exception e){
						System.err.println("Exception in Food Item Nutrients:"+e);
						e.printStackTrace();
					}
				}
				%>
				</table>
			</div>
		</td>
	</tr>
</table>
		<input type="hidden" name="locale" id="locale" value="<%=locale%>" />
		<input type='hidden' name='valueForNutCode' id='valueForNutCode' value='<%=foodItemCode%>'>
		<input type='hidden' name='valueForIngCode' id='valueForIngCode' value=''><!-- Added Against PMG2017-COMN-CRF-0012.1-US004 --> 
		<input type='hidden' name='valueForUomCode' id='valueForUomCode' value=''><!-- Added Against PMG2017-COMN-CRF-0012.1-US004 -->
		<input type='hidden' name='forUpdate' id='forUpdate' value=''>
		<input type='hidden' name='totalRows' id='totalRows' value='<%=totalRows%>'>
		<input type=hidden name="flag" id="flag" />
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		</form>
	</body>
</html>

