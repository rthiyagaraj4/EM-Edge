<!DOCTYPE html>
<%@ page import= "java.text.*,java.sql.Types,java.sql.Statement,java.sql.CallableStatement,java.sql.Connection,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
	<head>
<% 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style>
		A:active{ 
			COLOR: white; 
		}
	</style>
	
	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='ECMENUHIGHERLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
			parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}		
		function chcol(ro){ 
			document.getElementById("t").rows(prev).cells(0).className=prevcol
			prevcol=ro.cells(0).className
			ro.cells(0).className="MENUSELECTEDCOLOR"
			prev=ro.rowIndex;				
		}

		function callJSPs(val){
			var setupparameter_function_name = encodeURIComponent(getLabel("eOT.SetupParameter.Label","OT"));
			var setupparametersforfacility_function_name = encodeURIComponent(getLabel("eOT.SetupParametersForFacility.Label","OT"));
			var setupopertimerangesforrept_function_name = encodeURIComponent(getLabel("eOT.SetUpOperTimeRangesForRept.Label","OT"));
			var otstatusdescriptions_function_name = encodeURIComponent(getLabel("eOT.OTStatusDescriptions.Label","OT"));
			var function_function_name = encodeURIComponent(getLabel("Common.Function.label","common"));
			var functionsforstatus_function_name = encodeURIComponent(getLabel("eOT.FunctionsForStatus.Label","OT"));
			var roletype_function_name = encodeURIComponent(getLabel("Common.RoleType.label","common"));
			var practitionertypesforroletypes_function_name = encodeURIComponent(getLabel("eOT.PractitionerTypesForRoleTypes.Label","OT"));
			var role_function_name = encodeURIComponent(getLabel("Common.Role.label","common"));
			var functionsforrole_function_name = encodeURIComponent(getLabel("eOT.FunctionsForRole.Label","OT"));
			var functionsforuser_function_name = encodeURIComponent(getLabel("eOT.FunctionsForUser.Label","OT"));
			var operatingroom_function_name = encodeURIComponent(getLabel("Common.OperatingRoom.label","common"));
			var holdingarea_function_name = encodeURIComponent(getLabel("eOT.HoldingArea.Label","OT"));
		//	var recoveryroom_function_name = encodeURIComponent(getLabel("eOT.RecoveryRoom.Label","OT"));
			var preoperativeindicator_function_name = encodeURIComponent(getLabel("eOT.PreOperativeIndicator.Label","OT"));
			var bookingfinalizationstages_function_name = encodeURIComponent(getLabel("eOT.BookingFinalizationStages.Label","OT"));
			var bookingpriority_function_name = encodeURIComponent(getLabel("eOT.BookingPriority.Label","OT"));
			var holidays_function_name = encodeURIComponent(getLabel("Common.Holidays.label","Common"));
			var blocktheatreslots_function_name = encodeURIComponent(getLabel("eOT.BlockTheatreSlots.Label","OT"));
			var releasetheatreslots_function_name = encodeURIComponent(getLabel("eOT.ReleaseTheatreSlots.Label","OT"));
			var bookingrights_function_name = encodeURIComponent(getLabel("eOT.BookingRights.Label","OT"));
			var surgeonsdiaryschedule_function_name = encodeURIComponent(getLabel("eOT.SurgeonsDiarySchedule.Label","OT"));
			var surgeonsdiarymaintainschedule_function_name = encodeURIComponent(getLabel("eOT.SurgeonsDiaryMaintainSchedule.Label","OT"));
			var setupparameter_function_name = encodeURIComponent(getLabel("eOT.SetupParameter.Label","OT"));
			var setupparametersforfacility_function_name = encodeURIComponent(getLabel("eOT.SetupParametersForFacility.Label","OT"));

			var formObj = document.forms[0];
			var ca_module_yn = formObj.ca_module_yn.value;
			/*
			document.getElementById("t").rows(prev).cells(0).className=prevcol
				prevcol=ro.cells(0).className
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
	
    		if(val == 'SetUpParameter'){
				if(ca_module_yn=="N"){
					alert(getMessage("CA_NOT_INSTALLED","Common"));
				}else{
					parent.frames[1].location.href = '../../eOT/jsp/SetUpParameter.jsp?module_id=OT&function_id=SetUpParameter&function_name='+setupparameter_function_name+'&function_type=F&access=NYNNN';
				}
			}
			if(val == 'SetUpParameterforFacility'){
				parent.frames[1].location.href = '../../eOT/jsp/SetUpParameterForFacility.jsp?module_id=OT&function_id=SetupParametersforFacility&function_name='+setupparametersforfacility_function_name+'&function_type=F&access=NYNNN';
			}
			if(val == 'SetupOperationTimeRanges'){
				parent.frames[1].location.href = '../../eOT/jsp/SetupOperationTimeRanges.jsp?module_id=OT&function_id=SetupOperationTimeRanges&function_name='+setupopertimerangesforrept_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'StatusDescriptions'){
				parent.frames[1].location.href = '../../eOT/jsp/StatusDescriptions.jsp?module_id=OT&function_id=OTStatusDescriptions&function_name='+otstatusdescriptions_function_name+'&function_type=F&access=NYYNN';
			}
			if(val == 'Functions'){
				parent.frames[1].location.href = '../../eOT/jsp/Functions.jsp?module_id=OT&function_id=Functions&function_name='+function_function_name+'&function_type=F&access=NYYNN';
			}
           			
			if(val == 'FunctionsforStatus'){
				parent.frames[1].location.href = '../../eOT/jsp/FunctionsForStatus.jsp?module_id=OT&function_id=FunctionsforStatus&function_name='+functionsforstatus_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'RoleTypes'){
				parent.frames[1].location.href = '../../eOT/jsp/RoleTypes.jsp?module_id=OT&function_id=RoleTypes&function_name='+roletype_function_name+'&function_type=F&access=NYYNN';
			}
			if(val == 'PractitionerTypesForRoleTypes'){
				parent.frames[1].location.href = '../../eOT/jsp/PractitionerTypesForRoleTypes.jsp?module_id=OT&function_id=RoleTypes&function_name='+practitionertypesforroletypes_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'Roles'){
				parent.frames[1].location.href = '../../eOT/jsp/Roles.jsp?module_id=OT&function_id=Roles&function_name='+role_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'FunctionsforRole'){
				parent.frames[1].location.href = '../../eOT/jsp/FunctionsForRole.jsp?module_id=OT&function_id=FunctionsforRoles&function_name='+functionsforrole_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'FunctionsforUser'){
				parent.frames[1].location.href = '../../eOT/jsp/FunctionsForUser.jsp?module_id=OT&function_id=FunctionsforUser&function_name='+functionsforuser_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'OperatingRooms'){
				parent.frames[1].location.href = '../../eOT/jsp/OperatingRooms.jsp?module_id=OT&function_id=OperatingRooms&function_name='+operatingroom_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'HoldingAreas'){
				parent.frames[1].location.href = '../../eOT/jsp/HoldingAreas.jsp?module_id=OT&function_id=HoldingAreas&function_name='+holdingarea_function_name+'&function_type=F&access=YYYNN';
			}
		/*	if(val == 'RecoveryRooms'){
				parent.frames[1].location.href = '../../eOT/jsp/RecoveryRoom.jsp?module_id=OT&function_id=RecoveryRooms&function_name='+recoveryroom_function_name+'&function_type=F&access=YYYNN';
			} */
			if(val == 'PreOpIndicator'){
				parent.frames[1].location.href = '../../eOT/jsp/PreOpIndicator.jsp?module_id=OT&function_id=PreOpIndicator&function_name='+preoperativeindicator_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'BookingFinalisationStages'){
				parent.frames[1].location.href = '../../eOT/jsp/BookingFinalisationStagesFrame.jsp?module_id=OT&function_id=BookingFinalisationStages&function_name='+bookingfinalizationstages_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'BookingPriority'){
				parent.frames[1].location.href = '../../eOT/jsp/BookingPriority.jsp?module_id=OT&function_id=BookingPriority&function_name='+bookingpriority_function_name+'&function_type=F&access=YYYNN';
			}

            if(val == 'Holidays'){
				parent.frames[1].location.href = '../../eOT/jsp/Holidays.jsp?module_id=OT&function_id=Holidays&function_name='+holidays_function_name+'&function_type=F&access=YYYYN';
			}
			if(val == 'BlockTheatreSlots'){
				
				parent.frames[1].location.href = '../../eOT/jsp/BlockTheatreSlots.jsp?module_id=OT&function_id=BlockTheatreSlots&function_name='+blocktheatreslots_function_name+'&function_type=J&access=NNNNN';
			}
			if(val == 'ReleaseTheatreSlots'){
				parent.frames[1].location.href = '../../eOT/jsp/RelaseTheatreSlots.jsp?module_id=OT&function_id=ReleaseTheatreSlots&function_name='+releasetheatreslots_function_name+'&function_type=J&access=NYNNN';
			}
			if(val == 'BookingRights'){
				parent.frames[1].location.href = '../../eOT/jsp/BookingRights.jsp?module_id=OT&function_id=BookingRights&function_name='+bookingrights_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'SurgeonDiaryGenerateSchedule'){
				parent.frames[1].location.href = '../../eOT/jsp/SurgeonDiarySchedule.jsp?module_id=OT&function_id=SurgeonDiaryGenerateSchedule&function_name='+surgeonsdiaryschedule_function_name+'&function_type=F&access=NNNNN';
			}
			if(val == 'SurgeonDiaryMaintainSchedule'){
				parent.frames[1].location.href = '../../eOT/jsp/SurgeonDiaryMaintainSchedule.jsp?module_id=OT&function_id=SurgeonDiaryMaintainSchedule&function_name='+surgeonsdiarymaintainschedule_function_name+'&function_type=F&access=NYNNN';
			}
			if(val == 'AnaesthesiaSetupParameters'){
				if(ca_module_yn=="N"){
					alert(getMessage("CA_NOT_INSTALLED","Common"));
				}else{
					parent.frames[1].location.href = '../../eOT/jsp/AnaesthesiaSetupParameters.jsp?module_id=OT&function_id=AnaesthesiaSetupParameters&function_name='+setupparameter_function_name+'&function_type=F&access=NYNNN';
				}
			}
			if(val == 'AnaesthesiaSetupParametersForFacility'){
				parent.frames[1].location.href = '../../eOT/jsp/AnesthSetupParamForFlty.jsp?module_id=OT&function_id=AnesthSetupParamForFlty&function_name='+setupparametersforfacility_function_name+'&function_type=F&access=NYNNN';
			}		
	}
	
	async function showFunctionality(){
		var retVal = new Array(); 

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';  
		var arguments	= '' ;  
		
		var vals = parent.parent.header.document.header_form.menu_values.value;
		OTAdminMasterMenu_form.menu_values.value = vals;
 		
		arguments = vals

		//retVal = window.showModalDialog('change_functionality.jsp',arguments,features);
		
		retVal	= await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}


	function refreshPage(){
		parent.frames[0].location.href='../../eOT/jsp/OTAdminSetupFunctions.jsp?expand='+expand
	}
		
	function chkRow( ro,val,exp ){
		var S =expand.charAt(0)
		var R =expand.charAt(1)
		var B =expand.charAt(2)			
		var A =expand.charAt(3)			
			
			if( val == "S" )
			{
				if( exp =="E")
					S = "C";
				else
					S = "E";
			}
			
			if( val == "R"  )
			{
				 if( exp =="E" )
					R= "C"
				else
					R = "E";
			}
			if( val == "B" )
			{
				if(exp =="E" )
					B="C";
				else
					B ="E"
			}
			if( val == "A" )
			{
				if(exp =="E" )
					A="C";
				else
					A ="E"
			}
			
		
			expand = S + R + B + A;
			//alert(parent.frames[1].name);
			parent.frames[1].location.href = '../../eCommon/html/blank.html'
		}
	</script>
	</head>
<% 
	String expand=request.getParameter("expand");
	if( expand == null) 
		expand="CCCC";
	String facility_id  = (String) session.getValue("facility_id");

	Connection con=null;
	CallableStatement cstmt = null;
	String modules_list = "";
	String ca_module_yn="";

	try{
		con = ConnectionManager.getConnection(request);
	// Check for CA Module Existence
		cstmt=con.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules_list=cstmt.getString(2);
		if(modules_list.indexOf("OR|")>=0)
			ca_module_yn="Y";	// When CA is  Operational
		else
			ca_module_yn="N";	// When CA is not Operational
	}catch(Exception e){
		out.println(e);
	}finally { 
		if(cstmt !=null) cstmt.close();
		ConnectionManager.returnConnection(con,request);
	}

%>

	<body style="background-color:dimgray;"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="OTAdminMasterMenu_form" id="OTAdminMasterMenu_form">
	<input type="hidden" name='menu_values' id='menu_values'>
	<input type="hidden" name='ca_module_yn' id='ca_module_yn' value="<%=ca_module_yn%>">
	
	<table cellspacing=1 cellpadding=3  width='100%' border=0 id='t'>
		
		 <tr onclick="chkRow(this,'S','<%=expand.charAt(0)%>')">
		    <% if(expand.charAt(0) == 'E') {%>
            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white;'>
				-<fmt:message key="Common.setup.label" bundle="${common_labels}"/>
			</td>
			<%} else {%>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white;'>
				+<fmt:message key="Common.setup.label" bundle="${common_labels}"/>
			</td>
			<%}%>
        </tr>
		<% if(expand.charAt(0) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SetUpParameter')">
				<fmt:message key="eOT.SetupParameter.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SetUpParameterforFacility')">
				<fmt:message key="eOT.SetupParametersForFacility.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SetupOperationTimeRanges')">
				<fmt:message key="eOT.SetUpOperTimeRangesForRept.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('StatusDescriptions')">
				<fmt:message key="eOT.OTStatusDescriptions.Label" bundle="${ot_labels}"/>
			</td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Functions')">
				<fmt:message key="Common.Function.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FunctionsforStatus')">
				<fmt:message key="eOT.FunctionsForStatus.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('RoleTypes')">
				<fmt:message key="Common.RoleType.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractitionerTypesForRoleTypes')">
				<fmt:message key="eOT.PractitionerTypesForRoleTypes.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Roles')">
				<fmt:message key="Common.Role.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FunctionsforRole')">
				<fmt:message key="eOT.FunctionsForRole.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FunctionsforUser')">
				<fmt:message key="eOT.FunctionsForUser.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<%}%>
		 <tr onclick="chkRow(this,'R','<%=expand.charAt(1)%>')">
			<% if(expand.charAt(1)=='E') {%>
            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white'>
				-<fmt:message key="Common.room.label" bundle="${common_labels}"/>
			</td>
			<%} else {%>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white'>
				+<fmt:message key="Common.room.label" bundle="${common_labels}"/>
			</td>
			<%}%>
        </tr>
		<% if(expand.charAt(1)=='E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OperatingRooms')">
				<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('HoldingAreas')">
				<fmt:message key="eOT.HoldingArea.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
<!-- newly added for SRR20056- CRF 224 by rajesh on 26/02/09 -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('RecoveryRooms')">
				<fmt:message key="eOT.RecoveryRoom.Label" bundle="${ot_labels}"/>
			</td>
		</tr>

		<!--<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PreOpIndicator')">
					<fmt:message key="eOT.PreOperativeIndicator.Label" bundle="${ot_labels}"/>
				</td>
		</tr>-->
		 <%}%>
		 <tr onclick="chkRow(this,'B','<%=expand.charAt(2)%>')">
			<% if(expand.charAt(2)=='E') {%>
            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white'>
				-<fmt:message key="Common.booking.label" bundle="${common_labels}"/>
			</td>
			<%} else {%>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white'>
				+<fmt:message key="Common.booking.label" bundle="${common_labels}"/>
			</td>
			<%}%>

        </tr>
		<% if(expand.charAt(2)=='E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BookingFinalisationStages')">
				<fmt:message key="eOT.BookingFinalizationStages.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BookingPriority')">
				<fmt:message key="eOT.BookingPriority.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Holidays')">
				<fmt:message key="Common.Holidays.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BlockTheatreSlots')">
				<fmt:message key="eOT.BlockTheatreSlots.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ReleaseTheatreSlots')">
				<fmt:message key="eOT.ReleaseTheatreSlots.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BookingRights')">
				<fmt:message key="eOT.BookingRights.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SurgeonDiaryGenerateSchedule')">
				<fmt:message key="eOT.SurgeonsDiarySchedule.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SurgeonDiaryMaintainSchedule')">
				<fmt:message key="eOT.SurgeonsDiaryMaintainSchedule.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<%}%>
		<tr onclick="chkRow(this,'A','<%=expand.charAt(3)%>')">
			<% if(expand.charAt(3) == 'E') {%>
            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white'>
				-<fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>
			</td>
			<%} else {%>
            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white'>
				+<fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>
			</td>
			<%}%>
        </tr>
		<% if(expand.charAt(3) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AnaesthesiaSetupParameters')">
				<fmt:message key="eOT.SetupParameter.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AnaesthesiaSetupParametersForFacility')">
				<fmt:message key="eOT.SetupParametersForFacility.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<%}
			out.println("<script>expand='"+ expand +"'</script>");
		%>
		
		<tr onclick='chcol(this)'>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b>
				<fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a>
			</td>
		</tr> 
	</table>

	</body>
	</form>
</html>

