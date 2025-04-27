<!DOCTYPE html>
<%@page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,eXH.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale		=	(String)session.getAttribute("LOCALE");
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
    <script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
	<script language="javascript" src="../../eXH/js/Validate.js" ></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language="javascript" src="../../eXH/js/DispenseItemMachineCodes.js"></script>
</head>
<body onSelect="codeArrestThruSelect();">	 

<%

   String mode;
   String function_id;
   String facility_id = "";
   String DispLocn = "";
   String Machine = "";
   String high_aler_drug_yn = "";
   String pack_only_expensive_drug_yn = "";

   
   boolean editMode			=		false;
   mode						=		request.getParameter("mode");
   System.out.println("DispItemForMachineCodes ::: Mode ::: "+mode);
   String facilityID_rslt = request.getParameter("facility_id");
   String dispLocn_rslt = request.getParameter("disp_locn");
   String machine_rslt = request.getParameter("machine_code");
   String item_rslt = request.getParameter("item_desc");
   String highAlert_rslt = request.getParameter("high_alert_yn")==null?"":request.getParameter("high_alert_yn");
   String packOnly_rslt = request.getParameter("pack_only_yn")==null?"":request.getParameter("pack_only_yn");
   System.out.println("DispItemForMachineCodes ::: fac ::: "+facilityID_rslt+" :: "+dispLocn_rslt+" :: "+machine_rslt+" :: "+item_rslt+" :: "+highAlert_rslt+" :: "+packOnly_rslt);
	
   String facilityName = request.getParameter("facilityName");
   String dispLocnName = request.getParameter("dispLocnName");
   String machineName = request.getParameter("machineName");
   String itemName = request.getParameter("itemName");

   System.out.println("facilityName :: "+facilityName+":: dispLocnName :: "+dispLocnName+" :: machineName :: "+machineName+" :: itemName :: "+itemName);
	
	String disabled				=		"";	
	String checked				=		"";	
	String gif_visibility		=		"visibility:visibile";
	String modify_legend		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
	String add_legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String dis_abled			=		"disabled";
	
%>
<script type="text/javascript">
//*************************************************
// function	addForm
//*************************************************
function addSelect() {
	//alert("add button");
	var flag = checkNull();
	if(flag==true){
		var class_val ="";
		var required_Duplicate_Check = 0;
		var totalRows = parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows.length;
		//alert("totalRows.."+totalRows);
		var formObj = parent.frames[0];		
		var rowCount = document.forms[0].rowCount.value;
		var dispList_facility = document.forms[0].facility_id.value;
		//alert(dispList_facility);
		var dispList_dispLocn = document.forms[0].disp_locn.value;
		var dispList_machine = document.forms[0].machine_code.value;
		var dispList_item = document.forms[0].item_desc.value;

		var hid_facility = document.forms[0].facility.value;
		var hid_disp_locn = document.forms[0].disp_location.value;
		var hid_machinde = document.forms[0].machine.value;
		var hid_item = document.forms[0].item.value;
		

		var high_alert_drug = "N";
		var pack_only = "N";
		var select = "";
		if(document.forms[0].high_alert_yn.checked) {high_alert_drug = "Y";}
		if(document.forms[0].pack_only_yn.checked) {pack_only = "Y";}

		//var newRow = parent.frames[0].document.all("dispItemsMachineCodesListTable").insertRow();
		var newRow = parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").insertRow();
		var cell1=newRow.insertCell(0);
		var cell2=newRow.insertCell(1);
		var cell3=newRow.insertCell(2);
		var cell4=newRow.insertCell(3);
		
		var cell5=newRow.insertCell(4);
		var cell6=newRow.insertCell(5);
		var cell7=newRow.insertCell(6);

		

		cell1.innerHTML="<td id='"+"dispList_facility"+totalRows+"' class='"+class_val+"'>"+"<a href=\"javascript:getItemDetails('"+dispList_facility+"','"+dispList_dispLocn+"','"+dispList_machine+"','"+dispList_item+"','"+high_alert_drug+"','"+pack_only+"','"+select+"','"+totalRows+"');\">"+dispList_facility+"</a><input type='hidden' name='"+"hid_facility_id"+totalRows+"' id='"+"hid_facility_id"+totalRows+"' value='"+hid_facility+"' /></td>";

		cell2.innerHTML="<td id='"+"dispList_dispLocn"+totalRows+"' class='"+class_val+"'>"+dispList_dispLocn+"<input type='hidden' name='"+"hid_dispense_location"+totalRows+"' id='"+"hid_dispense_location"+totalRows+"' value='"+hid_disp_locn+"' /></td>";

		cell3.innerHTML="<td id='"+"dispList_machine"+totalRows+"' class='"+class_val+"'>"+dispList_machine+"<input type='hidden' name='"+"hid_machine"+totalRows+"' id='"+"hid_machine"+totalRows+"' value='"+hid_machinde+"' /></td>";

		cell4.innerHTML="<td id='"+"dispList_item"+totalRows+"' class='"+class_val+"'>"+dispList_item+"<input type='hidden' name='"+"hid_item"+totalRows+"' id='"+"hid_item"+totalRows+"' value='"+hid_item+"' /></td>";

		cell5.innerHTML="<td id='"+"high_alert_drug"+totalRows+"' class='"+class_val+"'>"+high_alert_drug+"<input type='hidden' name='"+"hid_high_alert_drug"+totalRows+"' id='"+"hid_high_alert_drug"+totalRows+"' value='"+high_alert_drug+"' /></td>";

		cell6.innerHTML="<td id='"+"pack_only"+totalRows+"' class='"+class_val+"'>"+pack_only+"<input type='hidden' name='"+"mode"+totalRows+"' id='"+"mode"+totalRows+"' value='insert'/><input type='hidden' name='"+"hid_pack"+totalRows+"' id='"+"hid_pack"+totalRows+"' value='"+pack_only+"' /></td>";

		cell7.innerHTML="<td id='"+"select"+totalRows+"' class='"+class_val+"'>"+select+"<input type='checkbox' name='"+"selectBox"+totalRows+"' id='"+"selectBox"+totalRows+"' value='"+select+"' /><input type='hidden' name='"+"hid_selectBox"+totalRows+"' id='"+"hid_selectBox"+totalRows+"' /></td>";

		



		//alert("after cell1");
		resetFields();
		//reloadQueueFrame();

		
	}
	
}

//*************************************************
// function	checkNull
//*************************************************
function checkNull(){
	//alert("checkNull");
	var flag;
 	var error="";
	var facilityId = document.forms[0].facility_id.value;
	var facilityId_label = getLabel("eXH.FacilityID.label","Common");
	var dispLocn = document.forms[0].disp_locn.value;
	var dispLocn_label = getLabel("eXH.DispLocnCode.label","Common");
	var machine = document.forms[0].machine_code.value;
	var machine_label = getLabel("eXH.Machine.label","Common");
	var item = document.forms[0].item_desc.value;
	var item_label = getLabel("eXH.item.label","Common");

	if(facilityId=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",facilityId_label)+"<br>";
 	}
 	if(dispLocn=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",dispLocn_label)+"<br>";
 	}

	if(machine=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",machine_label)+"<br>";
 	}
 	if(item=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",item_label)+"<br>";
 	}
	parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	if(flag==false) return false; else return true;
}

//*********************************************************************
// function resetFields
//*********************************************************************
function resetFields(){
		document.forms[0].facility_id.value = "";
		document.forms[0].disp_locn.value = "";
		document.forms[0].machine_code.value = "";
		document.forms[0].item_desc.value = "";
		//document.forms[0].itemQty.value = "";
		document.getElementById("high_alert_yn").checked = false;
		document.getElementById("pack_only_yn").checked = false;
		
		document.forms[0].facility_id.disabled = false;
		document.forms[0].disp_locn.disabled = false;
		document.forms[0].machine_code.disabled = false;
		document.forms[0].item_desc.disabled = false;
		
		
		document.forms[0].high_alert_yn.disabled = false;
		document.forms[0].pack_only_yn.disabled = false;
}
//****************************************************************
// function cancelRecord
//****************************************************************
function cancelRecord(){
	var facilityID = document.getElementById("facility_id").value;
	var dispLocation = document.getElementById("disp_locn").value;
	var machine = document.getElementById("machine_code").value;
	var item = document.getElementById("item_desc").value;	
	var highAlert=document.getElementById("high_aler_drug_yn").value;
	var packOnly = document.getElementById("pack_only_expensive_drug_yn").value;			
	var rowCount = document.forms[0].rowCount.value;
	//var totalRows = parent.frames[2].document.getElementById("listContentTable").rows.length;
	var totalRows = parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows.length;
	alert("cancelRecord totalRows.."+totalRows);
	if(totalRows>0){			
		for(i=1;i<=totalRows;i++){				
	 var hdnI = i;
	 var selectedText = parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows[i].cells[0].innerText;
	 alert("selectedText.."+selectedText);
		 if(selectedText == facilityID){				
			if(i<=rowCount){			
					//resetFields();					
					parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows[i].cells[0].innerText = selectedText;
					parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows[i].cells[0].style.color = '#FF0000';
					parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows[i].cells[1].style.color = '#FF0000';
					parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows[i].cells[2].style.color = '#FF0000';
					parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows[i].cells[3].style.color = '#FF0000';
					parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows[i].cells[4].style.color = '#FF0000';
					parent.frames[0].document.getElementById("dispItemsMachineCodesListTable").rows[i].cells[5].style.color = '#FF0000';
					
					var hdntxt = "mode"+hdnI;
					alert("hdntxt.."+hdntxt);
					parent.frames[0].document.getElementById(hdntxt).value='delete';
				}					
				return true;
			}
		}
	}
}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<form name="formDispItemsForMachineCodesTab" id="formDispItemsForMachineCodesTab" id="frmid"  method="post" action="../../servlet/eXH.XHDispItemsForMachineCodeServlet">
<%
if(mode.equals("Insert")){

%>
		<table border="0" cellpadding="1" cellspacing="0" width='100%'  align=center>
			<a  name="tab1"></a>
			<img  src="../../eST/images/IndividualItem.gif" border=0>
			<tr>
				<td  colspan="4">&nbsp;</td>
			</tr>
			<tr>

			     <td  class="label"><fmt:message key="eXH.FacilityID.label" bundle="${xh_labels}"/></td>
				<td class='fields'>
				 <input type='text' id="facilityID" name='facility_id' id='facility_id' size=25 value='' onBlur='GetFacilityLookup(facility_id)'>
				 <input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetFacilityLookup(facility_id)'>
				 <img src='../../eCommon/images/mandatory.gif' align=middle>
				 <input type=hidden id="facility"  name ='facility' value='' ></td>	
				 <td colspan=2> </td>
				
				 <td  class="label"><fmt:message key="eXH.DispLocnCode.label" bundle="${xh_labels}"/></td>
				<td class='fields'>
				 <input type='text' id="dispenseLocantion" name='disp_locn' id='disp_locn' size=25 value='' onBlur='GetMachineLocnLookup(disp_locn,facility)'>
				 <input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetMachineLocnLookup(disp_locn,facility)'>
				 <img src='../../eCommon/images/mandatory.gif' align=middle>
				 <input type=hidden id="disp_location"  name ='disp_location' value='' ></td>	
				 <td colspan=2> </td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eXH.Machine.label" bundle="${xh_labels}"/></td>
				<td class='fields'>
				 <input type='text' id="machineCode" name='machine_code' id='machine_code' size=25 value='' onBlur='GetMachineLookup(machine_code)'>
				 <input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetMachineLookup(machine_code)'>
				 <img src='../../eCommon/images/mandatory.gif' align=middle>
				 <input type=hidden id="machine"  name ='machine' value='' ></td>	
				 <td colspan=2> </td>

				<td  class="label"><fmt:message key="eXH.item.label" bundle="${xh_labels}"/></td>
				<td  class='fields'><input type='text' id="itemCode" name="item_desc" id="item_desc" value='' maxLength=25 size=25 onBlur='GetItemLookup(item_desc)'>
				<input name="item_search" id="item_search" class="button" onClick="GetItemLookup(item_desc);" type="button" value="?" <%=disabled%> >&nbsp;<IMG src="../../eCommon/images/mandatory.gif"align='center'></td>
				<input type=hidden id="item"  name ='item' value='' ></td>
				
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eXH.HighAlertDrugYN.label" bundle="${xh_labels}"/></td>
				
				<td class='fields'><input type=checkbox id ="high_alert_yn" name ='high_aler_drug_yn' <%=high_aler_drug_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(high_aler_drug_yn);' value='<%=high_aler_drug_yn.equals("Y")?"Y":"N"%>'></td>
				<td  class="label"><fmt:message key="eXH.PackOnlyExpensiveDrugYN.label" bundle="${xh_labels}"/></td>

				<td class='fields'><input type=checkbox id="pack_only_yn" name ='pack_only_expensive_drug_yn' <%=pack_only_expensive_drug_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(pack_only_expensive_drug_yn);' value='<%=pack_only_expensive_drug_yn.equals("Y")?"Y":"N"%>'></td>
				
			</tr>
			
			<tr>
			
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align=center>
			<tr>
			<tr>
				<td  class="label" colspan='4'>&nbsp;</td>
			</tr>
			<tr>
				<td  class="label" colspan='4'>&nbsp;</td>
			</tr>
				
				<td  class='fields'>
				    
					<input type='button' value='<%=editMode?modify_legend:add_legend%>' name='add_single' class='BUTTON' onClick='addSelect();'></input>&nbsp;&nbsp;&nbsp; 
					<input class="button" type="add_single"  name="ove" id="ove" disabled style='display:none' value='Move' > 
				</td>
				</tr>
				</table>
			</tr>
			
			</table>
			<br> <br><br><br><br><br><br><br><br><br><br><br><br>

			<input type="hidden" name="mode" id="mode" value="<%=mode%>">			
			<input type=hidden name='locale' id='locale' value='<%=locale%>'>
			<input type=hidden name="rowCount" id="rowCount" value="" />
<%
}else if(mode.equals("Modify")){
%>
				<table border="0" cellpadding="1" cellspacing="0" width='100%'  align=center>
			<a  name="tab1"></a>
			<img  src="../../eST/images/IndividualItem.gif" border=0>
			<tr>
				<td  colspan="4">&nbsp;</td>
			</tr>
			<tr>
			     <td  class="label"><fmt:message key="eXH.FacilityID.label" bundle="${xh_labels}"/></td>
				<td class='fields'>
				 <input type='text' id="facilityID" name='facility_id' id='facility_id' size=25 value='<%=facilityName%>' onBlur='GetFacilityLookup(facility_id)' disabled>
				 <input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetFacilityLookup(facility_id)' disabled>
				 <img src='../../eCommon/images/mandatory.gif' align=middle>
				 <input type=hidden id="facility"  name ='facility' value='<%=facilityID_rslt%>' ></td>	
				 <td colspan=2> </td>
				
				 <td  class="label"><fmt:message key="eXH.DispLocnCode.label" bundle="${xh_labels}"/></td>
				<td class='fields'>
				 <input type='text' id="dispenseLocantion" name='disp_locn' id='disp_locn' size=25 value='<%=dispLocnName%>' onBlur='GetMachineLocnLookup(disp_locn,facility)' disabled>
				 <input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetMachineLocnLookup(disp_locn,facility)' disabled>
				 <img src='../../eCommon/images/mandatory.gif' align=middle>
				 <input type=hidden id="disp_location"  name ='disp_location' value='<%=dispLocn_rslt%>' ></td>	
				 <td colspan=2> </td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eXH.Machine.label" bundle="${xh_labels}"/></td>
				<td class='fields'>
				 <input type='text' id="machineCode" name='machine_code' id='machine_code' size=25 value='<%=machineName%>' onBlur='GetMachineLookup(machine_code)' >
				 <input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetMachineLookup(machine_code)'>
				 <img src='../../eCommon/images/mandatory.gif' align=middle>
				 <input type=hidden id="machine"  name ='machine' value='<%=machine_rslt%>' ></td>	
				 <td colspan=2> </td>

				<td  class="label"><fmt:message key="eXH.item.label" bundle="${xh_labels}"/></td>
				<td  class='fields'><input type='text' id="itemCode" name="item_desc" id="item_desc" value='<%=itemName%>' maxLength=25 size=25 onBlur='GetItemLookup(item_desc)' disabled>
				<input name="item_search" id="item_search" class="button" onClick="GetItemLookup(item_desc);" type="button" value="?" <%=disabled%>  disabled>&nbsp;<IMG src="../../eCommon/images/mandatory.gif"align='center'></td>
				<input type=hidden id="item"  name ='item' value='<%=item_rslt%>' ></td>
				
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eXH.HighAlertDrugYN.label" bundle="${xh_labels}"/></td>				
				<td class='fields'><input type=checkbox id ="high_alert_yn" name ='high_aler_drug_yn' <%=highAlert_rslt.equals("Y")?"checked":""%> onClick='validatecheckbox(high_aler_drug_yn);' value='<%=high_aler_drug_yn.equals("Y")?"Y":"N"%>'></td>

				<td  class="label"><fmt:message key="eXH.PackOnlyExpensiveDrugYN.label" bundle="${xh_labels}"/></td>
				<td class='fields'><input type=checkbox id="pack_only_yn" name ='pack_only_expensive_drug_yn' <%=packOnly_rslt.equals("Y")?"checked":""%> onClick='validatecheckbox(pack_only_expensive_drug_yn);' value='<%=pack_only_expensive_drug_yn.equals("Y")?"Y":"N"%>'></td>
				
			</tr>
			
			<tr>
			
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align=center>
			<tr>
			<tr>
				<td  class="label" colspan='4'>&nbsp;</td>
			</tr>
			<tr>
				<td  class="label" colspan='4'>&nbsp;</td>
			</tr>
				
				<td  class='fields'>
				    
					<input type='button' value='<%=editMode?modify_legend:add_legend%>' name='add_single' class='BUTTON' onClick='addSelect();'></input>&nbsp;&nbsp;&nbsp; 
					<input class="button" type="add_single"  name="ove" id="ove" disabled style='display:none' value='Move' > 
				</td>
				</tr>
				</table>
			</tr>
			
			</table>
			<br> <br><br><br><br><br><br><br><br><br><br><br><br>

			<input type="hidden" name="mode" id="mode" value="<%=mode%>">			
			<input type=hidden name='locale' id='locale' value='<%=locale%>'>
			<input type=hidden name="rowCount" id="rowCount" value="" />
				<%
			}
%>
			
	</form>
</body>
</html>

