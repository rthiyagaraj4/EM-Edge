<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
	<head>
		<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
				:"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";
			String functionId = (String) session.getAttribute("functionId");
			String moduleId = (String) session.getAttribute("moduleId");
			String facilityId=(String)session.getAttribute("facility_id");
			String language_Id = (String)session.getAttribute("LOCALE");
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			conn = ConnectionManager.getConnection(request);
			String sql="";
			String strCode ="";
			String strDesc ="";

		%>
		<Script Language="JavaScript" src="../../eDS/js/FoodItemAreaMain.js"></Script>

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		
</head>

<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="FoodItemForKitchenArea" id="FoodItemForKitchenArea" action="../../servlet/eDS.FoodItemForKitchenAreaServlet" method="post" target="messageFrame">
		<table border='0' cellpadding='2' cellspacing='0' width='80%' align='center'>
			<tr>
				<td align="right" class="label" colspan="30">
					<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}" />
				</td>
					<td colspan="30" >
						<select name="kitchen" id="kitchen"  onchange="return foodItemForKitchenArea(this);">
							<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
								<%
									try
									{
										sql ="select kitchen.kitchen_Code,kitchen.short_Desc from Ds_Kitchens_Lang_Vw kitchen where kitchen.operating_Facility_Id like '"+facilityId+"' and   kitchen.language_Id = '"+language_Id+"' and kitchen.eff_Status ='E'";
										pstmt=conn.prepareStatement(sql);
										rst = pstmt.executeQuery();
										while(rst.next()){
										strCode = rst.getString(1);
										strDesc =  rst.getString(2);
								%>	
							<option value="<%=strCode%>"><%=strDesc%></option>
							<%}

									}
									  catch(Exception DCat)
										  {
										  System.out.println("Exception Kitchen"+DCat);
									  }
									   finally
									   {
										   if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
										    ConnectionManager.returnConnection(conn);
									   }

								%>
						</select>
					<img src='../../eCommon/images/mandatory.gif' />
				</td>
			</tr>
				<tr>
					<td align="right" class="label" colspan="30" >
						<fmt:message key="eOT.KitchenArea.Label" bundle="${ot_labels}" />
					</td>
				<td colspan="30">
					<select name="kitchenArea" id="kitchenArea" id='kitchenArea' onchange="foodItemForKitchenAreaItem();">
						<option value="">
							<fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
						</option>
					</select>
					<img src='../../eCommon/images/mandatory.gif' />
				</td>
			</tr>
		</table>
		<br>	
		<table border='0' cellpadding='2' cellspacing='0' width='80%' align='center'>
			<tr>
				<td align="center">
					<table  border='0 ' cellpadding='2' cellspacing='0' > 
						<td align="right" class="label">
								<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}" />
							</td>
								<td align="right">
									<input type="text" name="foodItemCodeDescription" id="foodItemCodeDescription" onblur="getLookupDetail();"/>
									<input class='BUTTON' type="button" name="lookUp" id="lookUp" value="?" onClick="showLookup();" />
									<!-- <img src='../../eCommon/images/mandatory.gif' /> -->
								</td>
							</tr>
						<tr>
						<td colspan="2" align="right">
						<br>
							<input class="BUTTON" type="button" name="select" id="select" value="Select" onClick="selectRecord();"/>
							<input type="button" class='BUTTON' name="cancel" id="cancel" value="Cancel" onClick="cancelRecord();"/>
							
						</td>
					</tr>
				</table>
				</td>
					<td align="right">
						<div id="listContentLayer" style="display:block;visibility:visible;overflow:no;height:18;width:25vw; border: 1px outset black" align="right">
							<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center' id="listContentTable1">
								<tr>
									<th>
										<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}" />
									</th>
								</tr>
						</table>
					</div>
					<div id="listContentLayer" style="display:block;visibility:visible;overflow:auto;height:25vh;width:25vw; border: 1px outset black" align="right">
							<table border='1' cellpadding='2' cellspacing='0' width='100%' align='center' name="listContentTable" id="listContentTable">
								<tr></th>
						</table>
					</div>
				</td>
			</tr>
		</table>
			<input type="hidden" name="method" id="method" />
			<input type="hidden" name="functionId" id="functionId" value="<%=functionId%>" />
			<input type="hidden" name="moduleId" id="moduleId" value="<%=moduleId%>" />
			<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>"/>
			<input type="hidden" name="language_id" id="language_id" value="<%=language_Id%>"/>
			<input type="hidden" name="kitchen1" id="kitchen1" value="" />
			<input type="hidden" name="kitchenArea1" id="kitchenArea1" value=""/>
			<input type="hidden" name="mode" id="mode" value=""/>
			<input type="hidden" name="flag" id="flag" />
			<input type='hidden' name='forUpdate' id='forUpdate' value=''>
			<input type="hidden" name="foodItemCode" id="foodItemCode" value=""/>
			<input type="hidden" name="foodItemCode1" id="foodItemCode1" value=""/>		
		</form>
	</body>
</html>

