<!DOCTYPE html>
<!--
File Name		: OPSpFoodItems.jsp
File Description: This file is for selecting Special Food Items.
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html locale="true">
<head>
	
	<%  
	    //Added Against MMS Vulnerability Issue - Starts
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		//Added Against MMS Vulnerability Issue - Ends

		String locale = (String)session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
	
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
	
		String strloggeduser	=  (String) httpSession.getValue("login_user");
		String strclientip ="";
		strclientip=p.getProperty("client_ip_address");
	
		String encounterId = request.getParameter("encounterId");
		String patientClass = request.getParameter("patientClass");
		String fecthedMealTypes = request.getParameter("fecthedMealTypes");

		
		System.out.println("locale: "+locale);
		System.out.println("encounterId: "+encounterId);
		System.out.println("patientClass:" + patientClass);
		System.out.println("fecthedMealTypes:"+fecthedMealTypes);
		
		String facility_id	= (String)session.getAttribute("facility_id");
		System.out.println("facility_id:"+facility_id);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<title>Special Food Items</title>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>		
	<Script language ="JavaScript" src ='../../eDS/js/DSCommon.js'></Script>
	
</head>
<body>
<form>
		<TABLE width="100%" align="center" CELLSPACING="0" cellpadding="0" >
			<TR>
				<TABLE width="100%" id="Able" CELLSPACING="0" cellpadding="0" style="display:block;visibility:visible;height:70;width:100%;border: 0px outset #9999FF" class="DECEASED">
							<tr>
								<TD noWrap class="label">
									<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}" />
								</TD>
								<TD>
									<select name="itemType" id="itemType" onchange="clearFood();">
										<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
										<%
 											try{
 												conn = ConnectionManager.getConnection(request);
												String splFoodMealTye_query = "SELECT DSITEMTYPE0_.SHORT_DESC AS SHORT_DESC, DSITEMTYPE0_.ITEM_TYPE AS ITEM_TYPE FROM DS_ITEM_TYPE_LANG_VW DSITEMTYPE0_ WHERE (DSITEMTYPE0_.EFF_STATUS='E' )AND(DSITEMTYPE0_.LANGUAGE_ID='"+locale+"' ) ORDER BY  2 , 1";
												System.out.println("splFoodMealTye_query :"+ splFoodMealTye_query );
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
										<input type="text" name="foodDesc" id="foodDesc" value="" size="10" onblur="if(this.value!='')showLookupForOPItemType(this);else foodType.value=''" > 
										<input type="button" name="click" id="click" value="?" onClick='return showLookupForOPItemType(document.getElementById("foodDesc"))' class="Button" />
										
										<img src='../../eCommon/images/mandatory.gif'></img>
										<INPUT type="hidden" name="foodType" id="foodType">
									</TD>
							</tr>
							<tr>
								<TD noWrap class="label">
										<fmt:message key="eOT.qty.Label" bundle="${ot_labels}" />
									</TD>
								<TD colspan="1">
									<input type="text" name="qty" id="qty" value="" maxlength="6" size="6" onkeyup="if(!CheckForNumber(this.value))this.value=''">
									<img src='../../eCommon/images/mandatory.gif'></img>
								</TD> 
								<td id="mealTypesId" onclick="return mealTypeOPSpFoodItems(this,'<%=fecthedMealTypes%>');" align="left" class="label" colspan="2">
									MealTypes...
								</td>
							</tr>

						</TABLE>

						<TABLE width="100%" id="Able" CELLSPACING="0" cellpadding="0" border ='0' style="display:block;visibility:visible;height:50;width:100%;border: 0px outset #9999FF" border="0">
							
							<TD align="right">
								<input type="button" name="" id="" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />' onClick="OPValidRecords()" class="Button">
								<input type="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}" />' onClick="return deleteOPSpItemRow();" class="Button">
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
											<fmt:message key="eOT.foodType.Label" bundle="${ot_labels}" />
										</th>
										<th nowrap="nowrap">
											<fmt:message key="eOT.qty.Label" bundle="${ot_labels}" />
										</th>
										<th nowrap="nowrap">
											<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
										</th>
									</tr>

									</tr>
								</TABLE>
							</div>
						</td>
					</tr>
					<TR>
						<TD colspan="4" align="right">
							<input type="button" name="" id="" value="<fmt:message key='Common.record.label' bundle='${common_labels}' />" onClick="setOPRecord();" class="Button">
							<input type="button" name="" id="" value="<fmt:message key='Common.close.label' bundle='${common_labels}' />" onClick="OPSpFoodClose();" class="Button">
						</TD>
					</TR>
				</TABLE>
				</td>
			</tr>
		</TABLE>

				<input type="hidden" name="mealType" id="mealType" />
				<INPUT type="hidden" name="language_id" id="language_id" value="<%=locale%>" />
				<INPUT type="hidden" name="rowNo" id="rowNo" value="">
				<INPUT type="hidden" name="delrowNo" id="delrowNo" value="">
</form>

<script language="Javascript" src="../../eDS/js/OPSpFoodItems.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</body>
</html>

