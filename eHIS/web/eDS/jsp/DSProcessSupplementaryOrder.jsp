<!DOCTYPE html>
<!-- This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release -->
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList,eDS.Common.JSONObject"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<jsp:setProperty name="DSCommonBeanObj" property="Locale" value='<%=session.getAttribute("LOCALE").toString()%>'/>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	//String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip		= "";
	strclientip				= p.getProperty("client_ip_address");
	String facility_id		= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";
	
	String Grace_Period="",Attendent_Label_Name="";
	
	ArrayList<JSONObject> DS_Param_List = new ArrayList<JSONObject>();
	DS_Param_List=DSCommonBeanObj.getDSParameterValue();
	JSONObject paramObj=new JSONObject();
	Iterator<JSONObject> paramItr=DS_Param_List.iterator();
	while(paramItr.hasNext()){
		paramObj=paramItr.next();
		Grace_Period=paramObj.get("Grace_Period").toString();
		Attendent_Label_Name=paramObj.get("Attendent_Label_Name").toString();		
	}
	if(Grace_Period.equals("-")){
		Grace_Period="";
	}
	
	String ProcessedbyKitchen=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.ProcessedbyKitchen.Label","ds_labels");
	String RejectedbyKitchen=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.RejectedbyKitchen.Label","ds_labels");
	String AcceptedbyPatient=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.AcceptedbyPatient.Label","ds_labels");
	String RejectedbyPatient=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.RejectedbyPatient.Label","ds_labels");
			
	AcceptedbyPatient=AcceptedbyPatient.replace("#",Attendent_Label_Name);
	RejectedbyPatient=RejectedbyPatient.replace("#",Attendent_Label_Name);	
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>		
		<script language="JavaScript" src="../../framework/js/PopupWindow.js" type="text/javascript"></script>
		<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
		<script type="text/javascript" src="../../eDS/js/simpletreemenu.js"></script>
		<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
		<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
		<!--script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script-->
		<script language="Javascript" src="../../eDS/js/json.js"></script>		
		<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script language="Javascript" src="../../eDS/js/Moment.js"></script>
		<script language="Javascript" src="../../eDS/js/MomentRange.js"></script>
		<script language="Javascript" src="../../eDS/js/MealAcknowledgeReport.js"></script>	
		<script language="Javascript" src="../../eDS/js/DSPlaceSupplementaryOrder.js"></script>
		<script language="Javascript" src="../../eDS/js/DSProcessSupplementary.js"></script>
		
		<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
		 
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
  		$(document).ready(function() {
	  	//loadIPNursingUnit();
	  	setPatientIdLength();
		getCurrentServerDate();
		});
		</script>
	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form action="" style="width:100%;height:100%;">
		<div id="search" style="width:100%;height:20%;border: 0px outset #9999FF;" align="center">
		<table border="0" cellpadding="2" cellspacing="0" width="90%" align="center" >
				<tr>
					<td class="label" >
						<fmt:message key="Common.date.label" bundle="${common_labels}" />
					</td>
					<td>
						<input type="text" name="servingDate" id="servingDate" id="servingDate" size="10" maxlength="10" value="" onkeypress="return checkForSpecCharsforID(event);"   onblur="isValidDate(this);" >
						<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('servingDate');">
						<img src='../../eCommon/images/mandatory.gif' align='center'>
					</td>
					<td class="label" ></td><!--Blank td-->
					<td class="label" width="10%">
						<fmt:message key="Common.patientId.label"   bundle="${common_labels}"/>
					</td>
					<td>
						<input type="text" name="patient_id" id="patient_id" id="patient_id" onKeypress='return CheckForSpecChars(event);' onBlur="makeValidString(this);ChangeUpperCase(this);">
						<input type='button' class='button' name=search value='?' class=button tabIndex="4" onClick="callPatientSearch()">
					</td>
					<td class="label" ></td><!--Blank td-->
				</tr>
				<tr>
					<td class="label" >
						<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="kitchen" id="kitchen" id="kitchen" onchange="NursingUnitForKithcen(this.value)"><option value="All"><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
						
						<% 
	             ArrayList<JSONObject> ProcesskeyValueList = new ArrayList<JSONObject>();

				 ProcesskeyValueList=DSCommonBeanObj.getKitchen();
				 Iterator<JSONObject> itr=ProcesskeyValueList.iterator();

				 JSONObject childobject=new JSONObject();

				while(itr.hasNext()){
					childobject=itr.next();

			 %>
			    <option value=<%=childobject.get("KITCHEN_CODE") %>><%= childobject.get("SHORT_DESC")%></option>
			 <%	
				}
			 %>		
						
						
					</td>
					
					<td class="label" ></td><!--Blank td-->
					
					<td class="label" >
						<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
					</td>
					<td>
						<select name="nursing_Unit" id="nursing_Unit" id="nursing_Unit" onChange="">							
						<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
	         <% 
	             ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();
						
						keyValueList=DSCommonBeanObj.getNursingUnit();
						
						System.err.println("keyValueList in jsp--->"+keyValueList);
						
                        itr=keyValueList.iterator();
						while(itr.hasNext()){
							childobject=itr.next();
	         %>
			 <option value=<%=childobject.get("nursing_Unit_Code") %>><%= childobject.get("Short_Desc")%></option>
			 <%	
				}
			 %>		
						</select>
						
						
					</td>
					<td class="label" ></td><!--Blank td-->
					
				</tr>	
				
				<tr>
					<td class="label" >
						<fmt:message key="eDS.SupplementaryOrderFor.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<select name="supplementaryfor" id="supplementaryfor" id="supplementaryfor" onChange="">
							<option value="B">Both</option>							
							<option value="P">Patient</option>							
							<option value="A"><%=Attendent_Label_Name %></option>							
						</select>
					</td>
					<td class="label" >
					
					</td>
					<td class="label" >
					
					</td>
					<td class="label" >
					
					</td>
					<td class="label" >
						<input type="button" value="Search"  onclick="getResult()" class="BUTTON"/>
					</td>
				</tr>
				
				<tr>
					<td class="label" >
						
					</td>
					<td>
						
					</td>
					<td class="label" >
						<fmt:message key="eDS.SetStatusforallPatients.Label" bundle="${ds_labels}" />
					</td>
					<td class="label" >
						<select name="setStatusForAll" id="setStatusForAll" id="setStatusForAll" onChange="updateStatus(this.value);">
				<option value=''>
				<fmt:message key="Common.Select.label" bundle="${common_labels}" />
				</option>
				<option value='PK'><%=ProcessedbyKitchen %></option>
				<option value='RK'><%=RejectedbyKitchen %></option>
				<option value='AP'><%=AcceptedbyPatient %></option>
				<option value='RP'><%=RejectedbyPatient %></option>
			</select>
					</td>
					<td class="label" >
					
					</td>
					<td class="label" >
						
					</td>
				</tr>
				
			
			</table>
		</div>
		<div id="nextprev" style="width:100%;height:5%;border: 0px outset #9999FF;visibility:visible" align="center">
		<table align='right' id="nextprevtable">		
		</table>
		</div>
		<div id="result" style=" scroll;width:100%;height:70%;border: 0px outset #9999FF;" align="center">
		<table border="1" cellpadding="1" cellspacing="0" width='100%' align='center' id="supplementaryplacesearchtable" style="overflow-y: scroll;width:100%;/* border: 1px outset #9999FF; */">
		<!--tbody></tbody-->
		</table>
		</div>
		<div id="footer" style="width:100%;height:5%;border: 0px outset #9999FF;visibility:hidden" align="center">
		<table width="100%" height="100%" >
		<tr>
			<td align=='right' width='3%' class='ORANGE'> </td>
			<td align='left' width='13%' colspan='3' class='label'><fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}"/></td>

			<td ></td>
			<td align='left' width='13%' colspan='3' class='label'></td>

			<td ></td>
			<td align='left' width='13%' colspan='3' class='label'></td>

			<td > </td>
			<td align='left' width='13%' colspan='3' class='label'></td>
	
			<td align='right' width='3%'>
			</td>
			<td align='left' width='13%' colspan='3' class='label'></td>	
		</tr>
		</table>
		</div>
		<input type="hidden" id="locale" name="locale" id="locale" value=<%=locale%>>
		<input type="hidden" id="facility_id" name="facility_id" id="facility_id" value=<%=facility_id%>>	
		<input type="hidden" id="Grace_Period" name="Grace_Period" id="Grace_Period" value=<%=Grace_Period %>>
		<input type="hidden" id="Attendent_Label_Name" name="Attendent_Label_Name" id="Attendent_Label_Name" value="<%=Attendent_Label_Name %>">
		</form>
	</body>
</html>

