<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.*,java.sql.PreparedStatement,java.sql.CallableStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eDS/js/ModifyMealPlan.js'></script>
<script language='javascript' src='../../eDS/js/PlaceDietOrderPHIS.js'></script>


</head>
<body onLoad="" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
		String facility_id	= (String) session.getValue("facility_id");
		//Checkstyle Violation commented by Munisekhar
		//String func_mode = request.getParameter("func_mode") ;
		//String patient_id	= "";

		String encounter_id = request.getParameter("encounterId");
		if(encounter_id==null) encounter_id="";

		String service_date = request.getParameter("servingDate");
		if(service_date==null) service_date="";

		String kitchenCode = request.getParameter("kitchenCode");
		if(kitchenCode==null) kitchenCode="";

		String mealType = request.getParameter("mealType");
		if(mealType==null) mealType="";
		String dietType = request.getParameter("dietType");
		if(dietType==null) dietType="";
		//String frequency = request.getParameter("frequency");
		  String frequency = "N";
		//if(frequency==null) frequency="";
        //Checkstyle Violation commented by Munisekhar
		//String strSysDate="";
		//String table_name ="";
        //String class_val = "";

		//String frequency = request.getParameter("frequency");
		//if(frequency==null) frequency="";

		String item_sl= "";
		 item_sl= (String) request.getParameter("item_slr");
        // if (null == item_sl) item_slr = (String) request.getAttribute("item_slr");
        //if (null == item_sl) item_sl= "";


       // item_sl = request.getParameter("item_slr");
		String item_Type   =request.getParameter("item_Type");
		if(item_Type==null) item_Type="";
		String item_Code   = "";
		String short_Desc   = request.getParameter("short_Desc");
		if(short_Desc==null) short_Desc="";
		String item_Qty   = request.getParameter("item_Qty");
		if(item_Qty==null) item_Qty="";
		String meal_Category   = "";
		String patient_Class = "";
		String serving_Uom_Code = "";
		String spl_Food_Item_Yn = request.getParameter("spl_Food_Item_Yn");
		if(spl_Food_Item_Yn==null) spl_Food_Item_Yn="";
		String freq_Yn = request.getParameter("freq_Yn");
		if(freq_Yn==null) freq_Yn="";
		String status = request.getParameter("status");
		String mode="";
		//Checkstyle Violation commented by Munisekhar
		//String serving_Date = request.getParameter("servingDate");
		//String PatIDLen ="";
        // String item_type_disable ="";
		//String item_select = "";
		//String classValue= "";
		//String rowNum = "";
		//Statement stmt	= null;
		//PreparedStatement pstmt1=null;
		//ResultSet rs1=null;
		//int rowCount = 0;
		String item_desc = "";
		String item_slr   = "";
		Connection conn=null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt3=null;	//MMS-KH-CRF-0029.1-US009
		ResultSet rs=null;
		ResultSet rs3=null;
		String enableDrugYN="";//MMS-KH-CRF-0029.1-US009		
		conn = ConnectionManager.getConnection(request);
		
		try	{
%>

<script type="text/javascript">
function callMouseOver(obj){
			currClass = obj.className ;
			obj.className = 'OTMENU';
		}

		function callOnMouseOut(obj){
			obj.className = currClass;
		}
// Added for INC 41451
function itemSelect(){
   var flag =checkNull();
   if(flag==true){
		var class_val ="";
		var required_Duplicate_Check = 0;
		var totalRows = parent.frames[2].document.getElementById("listContentTable").rows.length;
		var formObj = parent.frames[2];
		var rowCount = document.forms[0].rowCount.value;
		var item_slr = document.forms[0].srlNo.value;
		var item_Desc = document.getElementById("itemType").options[document.getElementById('itemType').selectedIndex].text;
		var item_Type = document.forms[0].itemType.value;
		var item_desc = document.forms[0].itemDesc.value;
		var item_Code = document.forms[0].itemCode.value;
		var short_Desc = document.forms[0].short_Desc.value;//MMS-KH-CRF-029.1
		var item_Qty = document.forms[0].itemQty.value;
		var spl_Food_Item_Yn = "N";
		var freq_Yn = "N";
		if(document.forms[0].splFoodItem.checked) {spl_Food_Item_Yn = "Y";}
		if(document.forms[0].freq.checked) {freq_Yn = "Y";}

		if(document.forms[0].srlNo.disabled != true){
		if(required_Duplicate_Check != 1){
				var f1=srlNoDuplicateCheck(item_slr);
					if(f1 == false)
					return
				var f2=foodItemDuplicateCheck(item_Code);
					if(f2 == false)
					return
			}
		}
		//MMS-KH-CRF-0029.1-US009 Start
		var drugCode="";
		var enabledrugfoodYN = document.getElementById("enableDrugYN").value;	
		if(enabledrugfoodYN=="Y"){
			var v_intr_flag = modifyMeal();
			drugCode = document.forms[0].drugCode.value;
			if (v_intr_flag == 'N')
				return;
		}
		//MMS-KH-CRF-0029.1-US009 End
		if(document.forms[0].srlNo.disabled == true){
			formObj.document.getElementById("item_Qty"+rowCount).innerText = item_Qty;
			formObj.document.getElementById("hid_item_Qty"+rowCount).value = item_Qty;
		}
		else{
				var newRow = parent.frames[2].document.all("listContentTable").insertRow();
				var cell1=newRow.insertCell(0);
				var cell2=newRow.insertCell(1);
				var cell3=newRow.insertCell(2);
				var cell4=newRow.insertCell(3);
				cell4.setAttribute('id','item_Qty'+totalRows);
				var cell5=newRow.insertCell(4);
				var cell6=newRow.insertCell(5);

				cell1.innerHTML="<td id='"+"item_slr"+totalRows+"' class='"+class_val+"'>"+"<a href=\"javascript:getItemDetails('"+item_slr+"','"+item_Type+"','"+item_Code+"','"+short_Desc+"','"+spl_Food_Item_Yn+"','"+freq_Yn+"','"+totalRows+"');\">"+item_slr+"</a><input type='hidden' name='"+"hid_item_slr"+totalRows+"' id='"+"hid_item_slr"+totalRows+"' value='"+item_slr+"' /></td>";

				cell2.innerHTML="<td id='"+"item_Type"+totalRows+"' class='"+class_val+"'>"+item_Desc+"<input type='hidden' name='"+"hid_item_Type"+totalRows+"' id='"+"hid_item_Type"+totalRows+"' value='"+item_Type+"' /></td>";

				cell3.innerHTML="<td id='"+"item_Code"+totalRows+"' class='"+class_val+"'>"+item_desc+"<input type='hidden' name='"+"hid_item_Code"+totalRows+"' id='"+"hid_item_Code"+totalRows+"' value='"+item_Code+"' /><input type='hidden' name='"+"hid_drug_Code"+totalRows+"' id='"+"hid_drug_Code"+totalRows+"' value='"+drugCode+"'/></td>"; // Modified for MMS-KH-CRF-0029.1-US009

                cell4.innerHTML="<td id='"+"item_Qty"+totalRows+"' class='"+class_val+"'>"+item_Qty+"<input type='hidden' name='"+"hid_item_Qty"+totalRows+"' id='"+"hid_item_Qty"+totalRows+"' value='"+item_Qty+"' /></td>";

				cell5.innerHTML="<td id='"+"spl_Food_Item_Yn"+totalRows+"' class='"+class_val+"'>"+spl_Food_Item_Yn+"<input type='hidden' name='"+"hid_spl_Food_Item_Yn"+totalRows+"' id='"+"hid_spl_Food_Item_Yn"+totalRows+"' value='"+spl_Food_Item_Yn+"' /></td>";

				cell6.innerHTML="<td id='"+"freq_Yn"+totalRows+"' class='"+class_val+"'>"+freq_Yn+"<input type='hidden' name='"+"mode"+totalRows+"' id='"+"mode"+totalRows+"' value='insert'/><input type='hidden' name='"+"hid_freq_Yn"+totalRows+"' id='"+"hid_freq_Yn"+totalRows+"' value='"+freq_Yn+"' /></td>";
		}
		resetFields();
		}
}


//Added for MMS-KH-CRF-0029.1 - US009 Start
async function modifyMeal()
{
	var language_Id =document.getElementById("locale").value;
	var facility=document.getElementById("facility_id").value;
	var encounter = parent.frames[0].document.forms[0].encounter_id.value;	
	var fromDate=parent.frames[0].document.forms[0].service_date.value;
	var dateTo = parent.frames[0].document.forms[0].service_date.value;
	var item_Code = document.forms[0].itemCode.value;
	var mode = "modify_Meal";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	var param="locale="+language_Id+"&facility="+facility+"&encounter="+encounter+"&fromDate="+fromDate+"&dateTo="+dateTo+"&item_Code="+item_Code+"&mode_diet="+mode; 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.ModifyMealPlanServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	var restrict = retVal.split(",");
	var param1="func_mode=getretVal&ret_val="+retVal+"&fromDate="+fromDate+"&dateTo="+dateTo;
	if(retVal!="" && restrict[8] ==" E")	
	{ 
 		var retVal2;
		var dialogUrl1 = "../../eDS/jsp/AlertValidation.jsp?"+param1;
		var dialogArguments = "";
		var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";			
		retVal2 = await window.showModalDialog(dialogUrl1, dialogArguments ,dialogFeatures);
		if(restrict[7]==" N")		
		{
			document.getElementById("remarksImg").style.visibility = 'visible';
			document.getElementById("remarksAlert").value = 'Y';
			var tempVar = localTrimString(restrict[9]);
			tempVar = tempVar.substr(0, tempVar.length - 1);
			document.getElementById("drugCode").value = tempVar;
			return "Y";
		}
		else if(restrict[7]==" Y")
			return "N";
	}
	else{
		document.getElementById("drugCode").value = "";
		return "Y";
	}
}

var remarks = "";
async function Remarks(){	
	var remarkHdr = "";
	var formObj = parent.frames[2].document.forms[0];
	if(document.getElementById("remarks").value != "null" &&  document.getElementById("remarks").value != "" && remarks == ""){
		remarkHdr = document.getElementById("remarks").value;
	}
	//Added for MMS-KH-CRF-0029.1 - US009 Start
	if(parent.ModifyMealPlanSearch.document.forms[0].onLoadRem.value != null &&  formObj.document.getElementById("onLoadRem").value != "" && 				parent.ModifyMealPlanSearch.document.forms[0].onLoadRem.value != undefined && parent.ModifyMealPlanSearch.document.forms[0].onLoadRem.value != "undefined"){
		remarkHdr = formObj.document.getElementById("onLoadRem").value;
	}
	//Added for MMS-KH-CRF-0029.1 - US009 End
	if(remarks != null || remarks == undefined){
	if(remarkHdr != ""){
		remarks = remarkHdr;
	}
	else{
		remarkHdr = remarks;
	}
	}
	else{
		remarkHdr = "";
	}
	var dialogUrl1 = "../../eDS/jsp/Remarks.jsp?&remarkHdr="+encodeURIComponent(remarkHdr);
	var dialogArguments = remarks;
	var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
	returnRemarks = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(returnRemarks != null){
		remarks = returnRemarks;
		document.getElementById("remarksVal").value = returnRemarks;
	}

	if(returnRemarks == undefined){
		returnRemarks = dialogArguments;		
	}
}
//Added for MMS-KH-CRF-0029.1 - US009 End

// modified by N Munisekhar on 12-June-2013 against [IN40763]
function checkNull(){
	var flag;
 	var error="";
 	var srlNo=document.forms[0].srlNo.value;
 	var srlNo_label=getLabel("Common.SrlNo.label","Common");
 	var itemType=document.forms[0].itemType.value;
 	var itemType_label=getLabel("Common.Itemtype.label","Common");
	var itemDesc=document.forms[0].itemDesc.value;
 	var itemDesc_label=getLabel("Common.item.label","Common");
	var itemQty=document.forms[0].itemQty.value;;
 	var itemQty_label=getLabel("eOT.ServingQty.Label","OT");


 	if(srlNo=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",srlNo_label)+"<br>";
 	}
 	if(itemType=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",itemType_label)+"<br>";
 	}

	if(itemDesc=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",itemDesc_label)+"<br>";
 	}
 	if(itemQty=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",itemQty_label)+"<br>";
 	}
	parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	if(flag==false) return false; else return true;
 }
function resetFields(){
		document.forms[0].srlNo.value = "";
		document.forms[0].itemType.value = "";
		document.forms[0].itemDesc.value = "";
		document.forms[0].itemCode.value = "";
		document.forms[0].itemQty.value = "";
		// modified by N Munisekhar on 23-May-2013 against [IN39955]
		//document.forms[0].splFoodItem.value = "";
		document.getElementById("splFoodItem").checked = false;
		document.getElementById("freq").checked = false;
		//document.forms[0].frequency.value ="";

		parent.ModifyMealPlanItem.document.forms[0].srlNo.disabled = false;
		parent.ModifyMealPlanItem.document.forms[0].itemType.disabled = false;
		parent.ModifyMealPlanItem.document.forms[0].itemDesc.disabled = false;
		
		// modified by Subhani on 08-07-2013 against [INC 41244]
		parent.ModifyMealPlanItem.document.forms[0].splFoodItem.disabled = false;
		parent.ModifyMealPlanItem.document.forms[0].freq.disabled = false;
}

function srlNoDuplicateCheck(item_slr){
	var formObj = parent.frames[2];
    var totRows= parent.frames[2].document.getElementById("listContentTable").rows.length;
		var f1;
		var error="";
	
		for(var i=1;i<totRows;i++)
		{
				var srlNo = formObj.document.getElementById("hid_item_slr"+i).value;
				if(item_slr == srlNo){
					alert(getMessage("DS_DUP_SRLNUM","DS")); //"DUPILICATE SERIAL NUMBER");
					f1 = false;
					break;
				}
		}
		if(f1==false)
			return false;
		else
			return true;
	}

function foodItemDuplicateCheck(item_Code){
		var formObj = parent.frames[2];
		var totRows= parent.frames[2].document.getElementById("listContentTable").rows.length;
		var f1;
		var error="";
		for(var i =1;i<totRows;i++)
		{
				var itemCode = formObj.document.getElementById("hid_item_Code"+i).value;
				if(item_Code == itemCode){
					alert(getMessage("DS_DUP_ITMCODE","DS")); //"DUPILICATE ITEM CODE");
					f1 = false;
					break;
				}
		}
		if(f1==false)
			return false;
		else
			return true;
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<form name="ModifyMealPlan_Item" id="ModifyMealPlan_Item"  onload='FocusFirstElement()'  action="../../servlet/eDL.ModifyMealPlanServlet" method="post" target="messageFrame">
			<table width="100%" border="0" cellpadding="" cellspacing="0">
						<tr><td>
						<table border="0 " cellpadding="" cellspacing="0" >
						<tr>
							<td align="right" class="label" width='25%'>
							<fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/>
							</td>
							<td>
							<input type=text name="srlNo" id="srlNo" onkeypress="CheckNumber()" size="2" maxlength="2" value =""/>
							<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>

						<tr>
							<td align="right" class="label">
								<fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/>
							</td>
						<td>
						<select name="itemType" id="itemType" onchange="" >
						<option value="">
							<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
						</option>
			<%
				try{
						String sql_meal ="SELECT DS_GET_DESC.DS_ITEM_TYPE(ITEM_TYPE,'"+locale+"','2'),ITEM_TYPE FROM DS_item_type WHERE NVL (EFF_STATUS, 'E') = 'E'";
						pstmt			= conn.prepareStatement(sql_meal) ;
						rs				= pstmt.executeQuery();
						while(rs!=null && rs.next()){
						item_Code=rs.getString(2);
						item_desc=rs.getString(1);
						if(item_desc != null && !item_desc.equals("")){
						
			%>
					<option value="<%=item_Code%>">
						<%=item_desc%>
					</option>
			<%
						}
						}
						}catch(Exception e){
						e.printStackTrace();
					   }finally{
				try{
						if(rs!=null)rs.close();
						if(cstmt!=null)cstmt.close();
						//if(conn!=null) ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
				}
			%>
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			</tr>
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.item.label" bundle="${common_labels}"/>
			</td>
			<td>
          <!--modified by N Munisekhar on 23-May-2013 against [IN39955]-->
				<input type="hidden" name="itemCode" id="itemCode" value="">
				<input type="text" name="itemDesc" id="itemDesc" size="10" onkeypress="return CheckForSpecChars(event)" onblur="if(this.value!='')showLookup(itemCode,itemDesc); else itemCode.value=''" value="" />
				<input type="button" class="button" name="lookUp" id="lookUp" value="?"  onclick='showLookup(itemCode,itemDesc);' >
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.ServingQty.Label" bundle="${ot_labels}"/></td>
			<td>
				<input type=text name="itemQty" id="itemQty" onkeypress="CheckNumber()" size="6" value ="" maxlength="6"/>
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
	<tr>
		<td align="right" class="label">
			<fmt:message key="eOT.ScheduleTime.Label" bundle="${ot_labels}"/>
		</td>
		<td>
			<input type=text name="sheduleTime" id="sheduleTime" onkeypress="vaidateFromTime()" size="5" maxlength="5" disabled/>
		</td>
	</tr>
	<tr>
		<td align="right" class="label">
			<fmt:message key="eOT.SpclFoodItems.Label" bundle="${ot_labels}"/>
		</td>
		<td><!--modified by N Munisekhar on 23-May-2013 against [IN39955]-->
			<input type="checkbox" id='splFoodItem' name="splFoodItem" id="splFoodItem" value=""/>
		</td>

		<td align="right" class="label">
			<fmt:message key="eOT.Freq.Label" bundle="${ot_labels}"/>
		</td>
		<td><!--modified by N Munisekhar on 23-May-2013 against [IN39955]-->
			<input type="checkbox" id='freq' name="freq" id="freq"  onclick="EnabledScheduleTime()" value=""/>
		</td>
	</tr>

	<tr>
		<td colspan='2' align='right'>
			<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick="itemSelect()" >
		</td>
		<td align='right'>
			<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="cancelRecord()" >
		</td>
		<%
			//MMS-KH-CRF-0029.1 - US009 Start
			String enableDrugFood="select ENABLE_DRUG_FOOD_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";
			pstmt3=conn.prepareStatement(enableDrugFood);						
			rs3=pstmt3.executeQuery();
			while(rs3 != null && rs3.next()){
				enableDrugYN=checkForNull(rs3.getString("ENABLE_DRUG_FOOD_YN"));
			}
			if(rs3!=null) rs3.close();
			if(pstmt3!=null) pstmt3.close();
			//MMS-KH-CRF-0029.1 - US009 Ends
			if(enableDrugYN.equals("Y")){
		%>
		<td align='right'>
			<div id="remarks" style='visibility:visible'>&nbsp;
				<a href="#" onclick="return Remarks();"> <fmt:message key="eOT.Remarks.Label" bundle="${ot_labels}" /></a>
				<img id="remarksImg" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img>	<!--Added Against ICN-72015-->
			</div>
		</td>
		<%}%>
	</tr>

</table>
	</td>
</table>
	<%
	
	}catch(Exception e)
	{
	e.printStackTrace();
	}finally
		{
			try{
				if(rs!=null) rs.close();
				pstmt.close();
				ConnectionManager.returnConnection(conn, request);
				}catch(Exception ee){
					ee.printStackTrace();
					System.err.println("Exception in modify123==>"+ee);
				}
			}%>

			<input type=hidden name="rowCount" id="rowCount" value="" />
			<input type=hidden name="item_slr" id="item_slr" value="<%=item_slr%>" />
			<input type=hidden name="encounter_id" id="encounter_id" id="encounter_id" value="<%=encounter_id%>" />
			<input type=hidden name="service_date" id="service_date" value="<%=service_date%>" />
			<input type=hidden name="kitchenCode" id="kitchenCode" value="<%=kitchenCode%>" />
			<input type=hidden name="mealType" id="mealType" value="<%=mealType%>" />
			<input type=hidden name="dietType" id="dietType" value="<%=dietType%>" />
			<input type=hidden name="frequency" id="frequency" value="<%=frequency%>" />
			<input type=hidden name="item_Type" id="item_Type" value="<%=item_Type%>" />
			<input type=hidden name="item_Code" id="item_Code" value="<%=item_Code%>" />
			<input type=hidden name="short_Desc" id="short_Desc" value="<%=short_Desc%>" />
			<input type=hidden name="item_Qty" id="item_Qty" value="<%=item_Qty%>" />
			<input type=hidden name="meal_Category" id="meal_Category" value="<%=meal_Category%>" />
			<input type=hidden name="patient_Class" id="patient_Class" value="<%=patient_Class%>" />
			<input type=hidden name="status" id="status" value="<%=status%>" />
			<!--<input type=hidden name="spl_Food_Item_Yn" id="spl_Food_Item_Yn" value="<%=spl_Food_Item_Yn%>" />
			<input type=hidden name="freq_Yn" id="freq_Yn" value="<%=freq_Yn%>" />-->
			<input type=hidden name="serving_Uom_Code" id="serving_Uom_Code" value="<%=serving_Uom_Code%>" />
			<input type=hidden name="locale" id="locale" value="<%=locale%>" />

			<input type=hidden name="facility_id" id="facility_id" value="<%=facility_id%>" />
			<input type=hidden name="mode" id="mode" value="<%=mode%>" />
			<!-- MMS-KH-CRF-0029.1-US009 Start-->
			<input type="hidden" name="enableDrugYN" id="enableDrugYN" id="enableDrugYN" value="<%=enableDrugYN%>"/>
			<input type="hidden" name="remarksAlert" id="remarksAlert" id="remarksAlert" value=""/>
			<input type="hidden" name="remarksVal" id="remarksVal" id="remarksVal" value=""/>
			<input type="hidden" name="drugCode" id="drugCode" id="drugCode" value=""/>
			<!-- MMS-KH-CRF-0029.1-US009 End-->
		</form>
</html>

