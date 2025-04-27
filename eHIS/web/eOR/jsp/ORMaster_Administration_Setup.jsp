<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="java.util.*, eOR.*" contentType="text/html;charset=UTF-8" %>
<%
	 String licence_key= eOR.OR_license_rights.getKey();
%>

<html>
	<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>

	<style>
		A:active {
			COLOR: white;
		}

	</style>

	<script language="javascript">
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){

				//parent.location.href='../../eCommon/jsp/CommonClearObjects.jsp';
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		/*function openMenu(obj){
		
				parent.parent.parent.parent.frames[1].expand(obj)	
		}

		function dummy(){}*/

		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/

			if(val == 'OR_Parameter'){
				parent.frames[1].location.href = 'ORParameter.jsp?module_id=OR&function_id=OR_Parameter&function_name='+encodeURIComponent(getLabel("eOR.ORParameter.label","OR"))+'&function_type=F&access=NYNNN';
			}
			if(val == 'OR_Param_for_Facility'){
				parent.frames[1].location.href = 'ORParamforFacility.jsp?module_id=OR&function_id=OR_Param_for_Facility&function_name='+encodeURIComponent(getLabel("eOR.ORParameterforFacility.label","OR"))+'&function_type=F&access=NYNNN';
			}
		if(val == 'Order_Print(Requistion)_Routing'){
				parent.frames[1].location.href = 'OrderPrintRouting.jsp?module_id=OR&function_id=Order_Print(Requistion)_Routing&function_name='+encodeURIComponent(getLabel("eOR.ORPrintingRules.label","OR"))+'&function_type=F&access=YYYYN';
			}
		if(val == 'User_for_Review'){
				parent.frames[1].location.href = 'UserforReview.jsp?module_id=OR&function_id=User_for_Review&function_name='+encodeURIComponent(getLabel("eOR.UsersforOrderReview.label","OR"))+'&function_type=F&access=YYYYN';
			}
		if(val == 'User_for_Reporting'){
				parent.frames[1].location.href = 'UserforReporting.jsp?module_id=OR&function_id=User_for_Reporting&function_name='+encodeURIComponent(getLabel("eOR.UsersforResultReporting.label","OR"))+'&function_type=F&access=YYYYN';
			}
		// Scheduled for 2nd Phase delivery

			if(val == 'Specimen_Collection'){
				parent.frames[1].location.href = 'SpecimenCollection.jsp?module_id=OR&function_id=Specimen_Collection&function_name='+encodeURIComponent(getLabel("Common.SpecimenCollection.label","COMMON"))+'&function_type=F&access=YYYYY';
			}
		if(val == 'Specimen_Label_Generation'){
				parent.frames[1].location.href = 'SpecimenLblGeneration.jsp?module_id=OR&function_id=Specimen_Label_Generation&function_name='+encodeURIComponent(getLabel("eOR.SpecimenLabelGeneration.label","OR"))+'&function_type=F&access=YYYYN';
			}
		if(val == 'Accession_Numbering_Rules'){
				parent.frames[1].location.href = 'AccessionNumberingRules.jsp?module_id=OR&function_id=Accession_Numbering_Rules&function_name='+encodeURIComponent(getLabel("eOR.AccessionNumberingRules.label","OR"))+'&function_type=F&access=YYYNN';
			}

		if(val == 'Privilege_Exception_Group'){
				parent.frames[1].location.href = 'PrivilegeExceptionGroup.jsp?module_id=OR&function_id=Privilege_Exception_Group&function_name='+encodeURIComponent(getLabel("eOR.PrivilegeGroup.label","OR"))+'&function_type=F&access=YYYNN';
			}
		
		if(val == 'Privilege_Group'){
				parent.frames[1].location.href = 'PrivilegeGroup.jsp?module_id=OR&function_id=Privilege_Group&function_name='+encodeURIComponent(getLabel("eOR.PrivilegeGroup.label","OR"))+'&function_type=F&access=YYYNN';
			}

			if(val == 'Assign_Privilege_Group'){
				parent.frames[1].location.href = 'AssignPrivilegeGroup.jsp?module_id=OR&function_id=Assign_Privilege_Group&function_name='+encodeURIComponent(getLabel("eOR.AssignPrivilegeGroup.label","OR"))+'&function_type=F&access=YYNNY';
			}
/*		if(val == 'Privilege_by_User'){
				parent.frames[1].location.href = 'PrivilegebyUser.jsp?module_id=OR&function_id=Privilege_by_User&function_name=Privilege by User&function_type=F&access=YYYNN';
			}
		if(val == 'Privilege_by_PP_Relations'){
				parent.frames[1].location.href = 'PrivilegebyPPRelations.jsp?module_id=OR&function_id=Privilege_by_PP_Relations&function_name=Privilege by PP Relations&function_type=F&access=YYYNN';
			}
		if(val == 'Privilege_by_Responsibility'){
				parent.frames[1].location.href = 'PrivilegebyResponsibility.jsp?module_id=OR&function_id=Privilege_by_Responsibility&function_name=Privilege by Responsibility&function_type=F&access=YYYNN';
			}
*/
		if(val == 'Privilege_by_Level'){
				parent.frames[1].location.href = 'PrivilegebyLevel.jsp?module_id=OR&function_id=Privilege_by_Level&function_name='+encodeURIComponent(getLabel("eOR.AssignPrivileges.label","OR"))+'&function_type=F&access=YYYNN';
			}
		if(val == 'Ordering_Rule_by_Patient_Class'){
				parent.frames[1].location.href = 'OrderingRulebyPatientClass.jsp?module_id=OR&function_id=Ordering_Rule_by_Patient_Class&function_name='+encodeURIComponent(getLabel("eOR.OrderingRulebyPatientClass.label","OR"))+'&function_type=F&access=YYYNN';
			}
		/* Scheduled for second Phase
		if(val == 'Pin_Identification_by_Order_Type'){
						parent.frames[1].location.href = 'PinIdentificationByOrderType.jsp?module_id=OR&function_id=Pin_Identification_by_Order_Type&function_name=Pin Identification by Order Type&function_type=F&access=NYNNN';
					}
		*/
		if(val == 'Closing_Processed_Order'){
						parent.frames[1].location.href = 'ClosingProcessedOrders.jsp?module_id=OR&function_id=Closing_Processed_Order&function_name='+encodeURIComponent(getLabel("eOR.AutoClosingRulesforPendingOrders.label","OR"))+'&function_type=F&access=YYYNN';
					}
		if(val == 'Wait_Time_Pending_Orders'){
				parent.frames[1].location.href = 'WaitTimePendingOrders.jsp?module_id=OR&function_id=Wait_Time_Pending_Orders&function_name='+encodeURIComponent(getLabel("eOR.WaitTimeForPendingOrdersTab.label","OR"))+'&function_type=F&access=YYYNN';
		}
		
		if(val == 'Ordering_Rule_by_Practitioner_Type'){
				parent.frames[1].location.href = 'OrderingRuleByPractitioner.jsp?module_id=OR&function_id=Ordering_Rule_by_Practitioner_Type&function_name='+encodeURIComponent(getLabel("eOR.OrderingRuleByPractitionerType.label","OR"))+'&function_type=F&access=YYNNN';
		}
		if(val == 'Place_Orders_For_Other_Practitioners'){
				parent.frames[1].location.href = 'ORPlaceOrdersForOthPract.jsp?module_id=OR&function_id=Place_Orders_For_Other_Practitioners&function_name='+encodeURIComponent(getLabel("eOR.PlaceOrdersForOtherPractitioners.label","OR"))+'&function_type=F&access=YNNNN';
		}



/*		if(val=="R&D"){
					parent.frames[1].location.href = 'DynamicTemplate.jsp?module_id=OR&function_id=Dynamic_template&function_name=Dynamic Template&function_type=F&access=YYYNN';
		}
*/
		/*if(val == 'PendingOrdersAppointment'){
						parent.frames[1].location.href = 'PendingOrdersSchedule.jsp';
					}
		*/
			

}



	async function showFunctionality(){
		var retVal = new Array();

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';
		var arguments	= '' ;

		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;

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

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>

	<body style="background-color:dimgray;" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
	<tr onclick='chcol(this)'>
		<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OR_Parameter')"><fmt:message key="eOR.ORParameter.label" bundle="${or_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OR_Param_for_Facility')"><fmt:message key="eOR.ORParameterforFacility.label" bundle="${or_labels}"/></td>
		</tr>
	</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Ordering_Rule_by_Patient_Class')"><fmt:message key="eOR.OrderingRulebyPatientClass.label" bundle="${or_labels}"/></td>
		</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Closing_Processed_Order')"><fmt:message key="eOR.AutoClosingRulesforPendingOrders.label" bundle="${or_labels}"/></td>
		</tr>

	<tr onclick='chcol(this)'>
		<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Order_Print(Requistion)_Routing')"><fmt:message key="eOR.ORPrintingRules.label" bundle="${or_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('User_for_Review')"><fmt:message key="eOR.UsersforOrderReview.label" bundle="${or_labels}"/></td>
	</tr>
<% if(licence_key.equals("ORFV")) { %>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('User_for_Reporting')"><fmt:message key="eOR.UsersforResultReporting.label" bundle="${or_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Specimen_Collection')"><fmt:message key="Common.SpecimenCollection.label" bundle="${common_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Specimen_Label_Generation')"><fmt:message key="eOR.SpecimenLabelGeneration.label" bundle="${or_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Accession_Numbering_Rules')"><fmt:message key="eOR.AccessionNumberingRules.label" bundle="${or_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Privilege_Group')"><fmt:message key="eOR.PrivilegeGroup.label" bundle="${or_labels}"/></td>
	</tr>

	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Assign_Privilege_Group')"><fmt:message key="eOR.AssignPrivilegeGroup.label" bundle="${or_labels}"/></td>
	</tr>

	  <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Ordering_Rule_by_Practitioner_Type')"><fmt:message key="eOR.OrderingRuleByPractitionerType.label" bundle="${or_labels}"/></td>
	</tr>

<% } %>

<!-- Commented on 26-01-2007 -  Murthy - Start 1 
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Privilege_Exception_Group')"><fmt:message key="eOR.PrivilegeGroup.label" bundle="${or_labels}"/></td>
	</tr>
Commented on 26-01-2007 -  Murthy - End 1 --> 



	
	<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Privilege_by_User')">Privilege by User</td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Privilege_by_PP_Relations')">Privilege by PP Relations</td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Privilege_by_Responsibility')">Privilege by Responsibility</td>
		</tr> -->


<!-- Commented on 26-01-2007 -  Murthy - Start 2
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Privilege_by_Level')"><fmt:message key="eOR.AssignPrivileges.label" bundle="${or_labels}"/></td>
Commented on 26-01-2007 -  Murthy - End 2 --> 


 <!--  Scheduled for Second Phase
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Pin_Identification_by_Order_Type')">Pin Identification by Order Type</td>
		</tr>
	-->


	<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PendingOrdersAppointment')">Pending Orders Schedule</td>
	</tr>
	-->

	  <!-- <tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' >
			<a href="javascript:callJSPs('R&D')" >R&D</a></td>
	    </tr>  -->

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Wait_Time_Pending_Orders')"><fmt:message key="eOR.WaitTimeForPendingOrdersTab.label" bundle="${or_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Place_Orders_For_Other_Practitioners')"><fmt:message key="eOR.PlaceOrdersForOtherPractitioners.label" bundle="${or_labels}"/></td>
		</tr>
		 <tr>
			<td class='ECMENUHIGHERLEVELCOLOR' >
			<a href="javascript:goHomePage()" style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
	    </tr> 
	<!-- <tr >
			<td class='ECMENUHIGHERLEVELCOLOR' onclick=openMenu(this) style="cursor:pointer"><b>Menu</b></td>
				
	</tr>-->

	</table>

	</body>
	</form>
</html>

