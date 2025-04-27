<!DOCTYPE html>
<!-- This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release -->

<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,eDS.Common.JSONObject,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<jsp:setProperty name="DSCommonBeanObj" property="Locale" value='<%=session.getAttribute("LOCALE").toString()%>'/>

<html>
<head>

<%
	String locale = (String)session.getAttribute("LOCALE");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
	.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
	:"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";		
%>

	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../framework/js/PopupWindow.js" type="text/javascript"></script>
	<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eDS/js/DSPlaceSupplementaryOrder.js"></script>
	<script language="Javascript" src="../../eDS/js/PlaceSupplementaryOrder.js"></script>
	<script language='javascript' src='../../eDS/js/MealAcknowledgeReport.js'></script>
	<script Language="JavaScript" src="../../eDS/js/DSCommon.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script Language="JavaScript" src="../../eDS/js/DSSupplementaryMealtickets.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
  		$(document).ready(function(){	
	  	setPatientIdLength();
		getCurrentServerDate();
		});
	</script>

 </head>
 
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String facility_id  = (String) session.getValue("facility_id");			
	String sql="";
	String strWtype = "";
	String strWDesc = "";
	String servingDate="";	
	String pat_id_length="";
	String Attendent_Label_Name="";
	ArrayList<JSONObject> DS_Param_List = new ArrayList<JSONObject>();
	DS_Param_List=DSCommonBeanObj.getDSParameterValue();
	Iterator<JSONObject> itr=DS_Param_List.iterator();
	JSONObject childobject=new JSONObject();
	while(itr.hasNext()){
		childobject=itr.next();
		Attendent_Label_Name=childobject.get("Attendent_Label_Name").toString();		
	}
	String ProcessedbyKitchen=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.ProcessedbyKitchen.Label","ds_labels");
	String RejectedbyKitchen=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.RejectedbyKitchen.Label","ds_labels");
	String AcceptedbyPatient=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.AcceptedbyPatient.Label","ds_labels");
	String RejectedbyPatient=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.RejectedbyPatient.Label","ds_labels");
	AcceptedbyPatient=AcceptedbyPatient.replace("#",Attendent_Label_Name);
	RejectedbyPatient=RejectedbyPatient.replace("#",Attendent_Label_Name);

%>
	<body onload ="fieldDisabled();">
		<form name="SupplementaryMealTicket" id="SupplementaryMealTicket" target="messageFrame" method="post" >
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<!-- Supplementary Order Date -->
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			<tr>
				<td  class="label">
					<fmt:message key="Common.date.label" bundle="${common_labels}" />
				</td>
				<td>
					<input type="text" name="servingDate" id="servingDate"  maxlength="10" size="10" value="" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('servingDate');">
					<img src='../../eCommon/images/mandatory.gif'/>							
				</td>				
			</tr>
			<!-- Supplementary Order Date -->

			<!-- Supplementary Order For -->
			<tr>
				<td class="label">
					<fmt:message key="eDS.SupplementaryOrderFor.Label" bundle="${ds_labels}"/></td>
				<td>
					<select name="supplementaryfor" id="supplementaryfor" onChange="">
						<option value="">Both</option>							
						<option value="P">Patient</option>							
						<option value="A"><%=Attendent_Label_Name%></option>							
					</select>
				</td>
				</td>				
			</tr>
			<!-- Supplementary Order For -->
			
			<!-- Kitchen -->
			<tr>
				<td  class="label">
					<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}" />
				</td>
				<td>
					<select name="kitchen" id="kitchen"  onchange="SupplementaryloadWards(this.value);">
						<option value=""><fmt:message key="eDS.select.Label" bundle="${ds_labels}"/> </option>
						<%
							ArrayList<JSONObject> KitchenList = new ArrayList<JSONObject>();		
							KitchenList=DSCommonBeanObj.getKitchen();						
							itr=KitchenList.iterator();
							while(itr.hasNext()){
								childobject=itr.next();
						%>
							<option value=<%=childobject.get("KITCHEN_CODE") %>><%= childobject.get("SHORT_DESC")%></option>
						<%	
							}
						 %>
					</select>
						<img src='../../eCommon/images/mandatory.gif' />
						</td>
					<td>
				</td>
			</tr>	
			<!-- Kitchen -->

			<!-- Ward Code -->
			<tr>
				<td  class="label">
					<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<select name="ward" id="ward" >
					<option value=""><fmt:message key="eDS.select.Label" bundle="${ds_labels}" /></option>
					     <%
							ArrayList<JSONObject> WardValueList = new ArrayList<JSONObject>();		
							WardValueList=DSCommonBeanObj.getWardDetails();						
							itr=WardValueList.iterator();
							while(itr.hasNext()){
								childobject=itr.next();
						 %>
							<option value=<%=childobject.get("WARD_CODE") %>><%= childobject.get("SHORT_DESC")%></option>
						 <%	
							}
						 %>
					</select>
				</td>
			</tr>	
			<!-- Ward Code -->

			<!-- Item Type -->
			<tr>
					<td class="label">
						<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}" />
					</td>
					<td>
					<select name="itemtype" id="itemtype" onChange="itemChange()">					
					<option value=""><fmt:message key="eDS.select.Label" bundle="${ds_labels}" /></option>
						<%
							ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();				
							keyValueList=DSCommonBeanObj.getItemTypes();						
							itr=keyValueList.iterator();
							while(itr.hasNext()){
								childobject=itr.next();
						%>
							<option value=<%=childobject.get("Code") %>><%= childobject.get("Short_Desc")%></option>
						<%	
						}
						 %>			
						</select>						
					</td>
				</tr>
				<!-- Item Type -->

				<!-- Food Item -->
				<tr>
					<td class="label">
						<fmt:message key="eDS.FoodItem.Label" bundle="${ds_labels}" />
					</td>
					<td>
						<input type="text" name="item" id="item"  value="" size="12" onblur="itemLookUp();">
						<input type="button" name="fooditembtn" id="fooditembtn" id="fooditembtn" value="?" onclick="itemLookUp();">				
						<input type="hidden" id="itemcode" name="itemcode" id="itemcode" value="">
						<input type="hidden" id="item1" name="item1" id="item1" value="">
					</td>					
				</tr>			
			<!-- Food Item -->			

			<!-- Meal Type -->
			<tr>
						<td  class="label">
							<fmt:message key="eDS.MealType.Label" bundle="${ds_labels}"/>
						</td>
						<td>
							<select name="mealType" id="mealType" id="mealType"><option value=""><fmt:message key="eDS.select.Label" bundle="${ds_labels}"/></option>

							<%
								ArrayList<JSONObject> MealtypeList = new ArrayList<JSONObject>();			
								MealtypeList=DSCommonBeanObj.getMealType();						
								itr=MealtypeList.iterator();
								while(itr.hasNext()){
									childobject=itr.next();
							%>
									<option value=<%=childobject.get("MEAL_TYPE") %>><%= childobject.get("SHORT_DESC")%></option>
							<%	
								}
							%>							
							</select>
						</td>
			</tr>
			<!-- Meal Type -->

			<!-- Supplementary patientId -->
			<tr>
			
				<td align="left" class='label'>
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
				<td>
					<input type="text" name="patient_id" id="patient_id"  maxlength="" onkeypress="restrictSpecialChars(event);return CheckForSpecChars(event);"  size="12"/>
				</td>
			<tr>
			<!-- Supplementary patientId -->

			<!-- Supplementary status -->
			<tr> 
		  		<td  class='label'>				
						<fmt:message key="Common.status.label" bundle="${common_labels}"/>
				</td>
				<td>
					<select name="setStatus" id="setStatus" onChange="">
						<option value=''>
						<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
						<option value="PK" ><%=ProcessedbyKitchen %></option>
				   <option value="RK" /><%=RejectedbyKitchen %></option>
				   <option value="AP" /><%=AcceptedbyPatient %></option>
				   <option value="RP" /><%=RejectedbyPatient %></option>
					</select>		
				</td>
			</tr>
			<!-- Supplementary status -->

			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			</table>			
			
					<INPUT TYPE="hidden" name="module_id" id="module_id" VALUE="DS">
					<input type="hidden" name="p_module_id" id="p_module_id" value="DS"/>
					
					<input type="hidden" name="report_id" id="report_id" value="DSRSSPMT"/>
					<input type="hidden" name="p_report_id" id="p_report_id" value="DSRSSPMT"/>			
					
					<INPUT TYPE="hidden" name="facility_id" id="facility_id" id ="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
					<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
					
					<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
					<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
					
					<input type="hidden" id="locale" name="locale" id="locale" value="<%=locale%>">
					<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
					<input type='hidden' name='datepattrn' id='datepattrn' value="dd/MM/yyyy"/>				

					<input type="hidden" name="converDate" id="converDate" value="" />
		</form>
	</body>
</html>

