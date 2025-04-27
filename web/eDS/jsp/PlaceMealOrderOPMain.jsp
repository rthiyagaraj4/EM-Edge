<!DOCTYPE html>
<!--
File Name		: PlaceMealOrderOPMain.jsp
File Description:  Result Frame : This file is for Placing OP Meal Order.
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.Common.*,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.sql.Timestamp,java.text.DateFormat,java.text.SimpleDateFormat"%>

<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<head>
<%
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
	(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
	String facility_Id	= (String)session.getAttribute("facility_id");
	String language_Id  = (String)session.getAttribute("LOCALE");
 %>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<style>
	select
	{
     min-width: 3vw;
     overflow: auto;
    }
</style>
	<fmt:setLocale value="<%=language_Id %>"/>
	<fmt:setBundle basename="eDS.resources.Labels" var="ds_labels"/>
	
</head>
<script language="javascript">
 //ML-MMOH-CRF-0596
	function checkTheBox(mealTypes,checkBoxCount,encounterCount,row_ind1,secondCount) 
    	{	 
	      var temp=0;
	      var temp1=0;
	        for (i=0; i<mealTypeList.length; i++) {
			//var meal1 = ""	;//Commented Against Ml-MMOH-CRF-0825(ICN-68623)
			var meal=mealTypeList[i].mealType+""+row_ind1;//63577
		    if (parent.frames[1].document.getElementById(meal).checked == true){//63577
			//Commented Against Ml-MMOH-CRF-0825(ICN-68623) Starts here
			//meal1=parent.frames[1].document.getElementById(meal).name.substring(0,meal.length-1);
			//parent.frames[1].document.getElementById("mealone").value= meal1;
			////Commented Against Ml-MMOH-CRF-0825(ICN-68623) Ends here
			temp++;
			document.QueryResult.ChkboxCount.value=temp;
		    } if (parent.frames[1].document.getElementById(meal).checked == false){// 63577				
				temp1++;
			}
			}
			 if(mealTypeList.length == temp1 && parseInt(encounterCount) == 0)
			{			 
			temp=0;		
			encounterCount=0;			 
			}			
			if(parseInt(temp) > 1 || parseInt(encounterCount) > 0 )
				{
				if(parseInt(encounterCount) > 0)
				{
			   	if(parseInt(temp) > 1)
				{
					alert("Not Allowed to Place Multiple Meals for a Day");
					var mealType1=mealTypeList[checkBoxCount].mealType+""+row_ind1; //63577
					parent.frames[1].document.getElementById(mealType1).checked = false;//63577				 
				}	
				else if(parseInt(temp)== 1 && parseInt(secondCount) == 0)
				{
					alert("Not Allowed to Place Multiple Meals for a Day");
					var mealType1=mealTypeList[checkBoxCount].mealType+""+row_ind1;//63577
					parent.frames[1].document.getElementById(mealType1).checked = false;	//63577					 
				}		
				}				
				else{
				if(parseInt(document.QueryResult.ChkboxCount.value) > 1  || (document.QueryResult.encounterCount.value ) > 0 )
					alert("Not Allowed to Place Multiple Meals for a Day");
				 	var mealType1=mealTypeList[checkBoxCount].mealType+""+row_ind1;//63577
				 	parent.frames[1].document.getElementById(mealType1).checked = false;	//63577		
					}				 
	            }
			//Added Against Ml-MMOH-CRF-0825(ICN-68623) Starts here		
			var check = document.querySelectorAll('input[type="checkbox"].'+mealTypes);
			var chkedValues = "" ;
			var chkedArray = new Array();
			var j = 0; 
			for (i=0; i < check.length; i++)
			{
			if (check[i].checked)
				{
				if(chkedValues.length == 0)
				chkedValues = chkedValues;
				chkedValues = chkedValues + check[i].value + ",";
				chkedArray[j] = i;
				j++;
				}
			}
			chkedValues=chkedValues.substring(0,chkedValues.length-1);
			parent.frames[1].document.getElementById("mealone").value = chkedValues;
			//Added Against Ml-MMOH-CRF-0825(ICN-68623) Ends here
	    }		
//ML-MMOH-CRF-0596	
	
//Added Against ML-MMOH-CRF-0825 Starts Here
function checkTheBox1(mealTypes,checkBoxCount,encounterCount,row_ind1,secondCount,obj){
		var check = document.querySelectorAll('input[type="checkbox"].'+mealTypes);
        var chkedValues = "";
		var chkedArray = new Array();
		var j = 0;
		for (i=0; i < check.length; i++)
		{
		
		if (check[i].checked)
			{
			if(chkedValues.length == 0)
			chkedValues = chkedValues;
			//check[i].value =  check[i].value.substring(0,check[i].value.length-1);
			chkedValues = chkedValues + check[i].value + ",";
			chkedArray[j] = i;
			j++;
			}
		}
		
	 chkedValues=chkedValues.substring(0,chkedValues.length-1);
	 document.forms[0].mealone.value = chkedValues; 
	}
//Added Against ML-MMOH-CRF-0825 Ends Here

</script>
<!-- Added Against ML-MMOH-CRF-0825 Starts Here -->
<%
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
    	String SystemDate_display = dateFormat.format(date);
	SystemDate_display = com.ehis.util.DateUtils.convertDate(SystemDate_display,"DMY","en",language_Id);
%>
<!-- Added Against ML-MMOH-CRF-0825 Ends Here -->
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	
<form name='QueryResult' id='QueryResult' action='../../servlet/eDS.PlaceMealOrderOPServlet' method='post' >
<%
	String params = request.getQueryString() ; 
	String splility=request.getParameter("splility");
	//out.println("splility=>"+splility);
	//Added Against ML-MMOH-CRF-0825 Starts Here
	PreparedStatement pstmt = null;
	ResultSet rs=null;	
	String LATE_IRREGULAR_DIET_ORD_FOR_OP = "";
	//Added Against ML-MMOH-CRF-0825 Ends Here
	Connection conn = null;
%>

<input type="hidden" name="locationCode" id="locationCode" value="">
<input type="hidden" name="locationType" id="locationType" value="">
<input type="hidden" name="jsonData" id="jsonData" value="">
<input type="hidden" name="mode" id="mode" value="">
<input type="hidden" name="ChkboxCount" id="ChkboxCount" value=""><!---ML-MMOH-CRF-0596----->
<input type="hidden" name="splility" id="splility" value="<%=splility%>"> <!--ML-MMOH-CRF-0596------>
<input type="hidden" name="encounterCount" id="encounterCount" value=""> <!---ML-MMOH-CRF-0596--->
<input type="hidden" name="secondCount" id="secondCount" value=""> <!---ML-MMOH-CRF-0596--->
<input type="hidden" name="patient_id" id="patient_id" value=""> <!---ML-MMOH-CRF-0596--->
<input type="hidden" name="systemDate" id="systemDate" id="systemDate" value="<%=SystemDate_display%>"><!-- ML-MMOH-CRF-0825 -->
<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0">		
		
	<tr>
		<td class=LABEL><fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}" /></td>
		<td><input name="kitchen" id="kitchen" type="text" readonly/>
			<input name="hdnkitchen" id="hdnkitchen" type="hidden" readonly/>
		</td>
		<td  class=LABEL colspan="1" ><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /></td>
		<td nowrap colspan="1" id="tdHdrDietType" >
			<select name="dietType" id="dietType" onKeyUp="diettype_Autocomplete();" onchange="fecthDietTypeToMealClass();" onClick="Select()"> <!--Modified Against ML-MMOH-CRF-0674--->
				<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
				</option>
			</select><img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>
</table>
<br/><br/>
<table border="1" cellpadding="0" cellspacing="0" width="100%"   align="center" >
	<tr><th colspan=13 align=left><fmt:message key="eDS.SelectedPatients.label" bundle="${ds_labels}" /> </th></tr>
	<tr><td><br/></td></tr>	
</table>	

	<div border="2" style="width:100%;height:80%;float:left;overflow-x: scroll;overflow-y: scroll;position:absolute;">
	<table width=200% border="1" cellpadding="0" cellspacing="0"   id="result" >
			<thead id="divOPMealOrderHdr" height=10%><tr>
					</tr></thead>
	
			<tbody id="divOPMealOrderList" height=90% style = "overflow:scroll;">	
			</tbody>
	</table>
	</div>	
	
		<input type=hidden name="mealTypeCount" id="mealTypeCount"/>
		<input type=hidden name="facilityId" id="facilityId" value="<%=facility_Id%>"/>
<table><tr><td></td></tr>
</table>
<%
    	//ML-MMOH-CRF-0596
		boolean isMealType = false;
	    boolean isMenuType =false;
			try{ //Common-ICN-0071
	conn = ConnectionManager.getConnection(request);	
	isMealType = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");//Using same function for Selayang
	//ML-MMOH-CRF-0596
	
	 //Added Against ML-MMOH-CRF-0825 Starts Here
	String Late_Irr_OP_Query = "select LATE_IRREGULAR_DIET_ORD_FOR_OP from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ? "; 
	pstmt = conn.prepareStatement(Late_Irr_OP_Query);	
	pstmt.setString(1,facility_Id);	
	rs	= pstmt.executeQuery();
	if(rs != null && rs.next()){
			LATE_IRREGULAR_DIET_ORD_FOR_OP=rs.getString("LATE_IRREGULAR_DIET_ORD_FOR_OP");
		}
	  //Added Against ML-MMOH-CRF-0825 Ends Here	    
%>
<%
     //ML-MMOH-CRF-0684

     isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
	  }
		catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
		} //Common-ICN-0071
%>

<input type="hidden" name="LATE_IRREGULAR_DIET_ORD_FOR_OP" id="LATE_IRREGULAR_DIET_ORD_FOR_OP" id="LATE_IRREGULAR_DIET_ORD_FOR_OP" value="<%=LATE_IRREGULAR_DIET_ORD_FOR_OP%>" /><!-- Added Against ML-MMOH-CRF-0825 -->

<script language="javascript">
/**
File Name			: PlaceMealOrderOPMain.js
File Description	: This is to Placing order for Outpatient.
CRF#				: Bru-HIMS-CRF-230
Author				: Abirami
Date				: Aug-2013
**/

	var gRecordUpdated = new Array();
	var nIndex = 0;
	//Set Flag for identifying the changes on row.
	function setFlagForDietType(rowind, modFlag)
	{	
		if(modFlag == "N" || modFlag == "Y" )
			gRecordUpdated[nIndex++] = rowind;
	}
	//CRF-0684
	function setFlagForMenuType(rowind, modFlag)
	{
		if(modFlag == "N" || modFlag == "Y" )
			gRecordUpdated[nIndex++] = rowind;
	}
	
	//Set Flag for identifying the changes on row.
	function setFlag(rowind)
	{ 
		gRecordUpdated[nIndex++] = rowind;
	}
	
	//Fetching Header Diet Type values to the Diettype column of all the rows of the table.
	function fecthDietTypeToMealClass(){
		for(var i=0;i<divOPMealOrderList.rows.length; i++)
			{
				var tmpmodFlag = parent.frames[1].document.getElementById("modFlag"+i).value;
				//Added Against Ml-MMOH-CRF-0674 starts Here
				document.getElementById("diettype_auto1").value="";
				document.getElementById("auto_flag1").value="false";				
				fecthDietType1(i,tmpmodFlag);
				//Added Against Ml-MMOH-CRF-0674 Ends Here
				parent.frames[1].document.getElementById("dietTypes"+i).value = document.getElementById("dietTypes").value ;
				
				if( tmpmodFlag == "N" || tmpmodFlag == "Y") 
					gRecordUpdated[nIndex++] = i; // Set Flag for identifying the changes on row
			}
	}
	
	var checkBoxCount =""; //ML-MMOH-CRF-0596
	//Non-Function Source: This code will be executed on this page load:
	var globalMealTypeList = new Array();
	var globalSplFoodList  = new Array();
	var globalFoodDislike  = new Array();
	var OPMealTypes = new Array();
	var PreparatoryInstruction_Label=getLabel("eOT.preparatoryInstruction.Label","OT");//417
	var Remarks_Label=getLabel("eDS.Remarks.Label","DS");//417
		
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var params = parent.jsonOPObj;
	
	var diettype_auto="";//Added Against ML-MMOH-CRF-0674
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+params+"&diettype_auto="+diettype_auto,false);//Added Against ML-MMOH-CRF-0674
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;	
	
	var jsonObjResponse=eval('(' + retVal + ')');
	
	/*** Setting Header Values****/
	
	//Getting and Setting Kitchen values::
	document.getElementById("kitchen").value = jsonObjResponse.jsonKitchenDesc;
	document.getElementById("hdnkitchen").value = jsonObjResponse.jsonKitchenCode;
	
	//Getting and Setting Diet type values::
	//Getting diet type list::
	var dietList=new Array();
	dietList = jsonObjResponse.jsonDietList;
	
	//Added Starts against ML-MMOH-CRF-0418 
	var dietListlength=0;
	if(typeof(dietList)!='undefined')
	dietListlength=dietList.length; 
	//Added Ends against ML-MMOH-CRF-0418
	
	var selObj = "<SELECT name='dietTypes' id='dietTypes' onKeyUp='diettype_Autocomplete();' onClick='Select()' onchange='fecthDietTypeToMealClass();'>";//Added Against ML-MMOH-CRF-0674
	var label=getLabel("Common.defaultSelect.label","Common");
	//Added against ML-MMOH-CRF-0418 
	if(dietListlength!=1)
	selObj += "<OPTION value=''>"+label+"</OPTION>";
	for (var j=0; j < dietListlength;j++) {//Modified against ML-MMOH-CRF-0418 
		var value = (dietList[j].DietCode);
		var desc = (dietList[j].DietDesc);
		selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
	}	
	document.getElementById("tdHdrDietType").innerHTML = selObj;
	
	//Added for CRf-0684
      	  var menuList=new Array();
	  menuList = jsonObjResponse.jsonMenuList;
	  var menuListlength=0;
	  if(typeof(menuList)!='undefined')
	  	menuListlength=menuList.length;
      		var selObj = "<SELECT name='menuType' id='menuType'  >";
	  	var label=getLabel("Common.defaultSelect.label","Common");
	  if(menuListlength!=1)
	   	selObj += "<OPTION value=''>"+label+"</OPTION>";
	   for (var j=0; j < menuListlength;j++) {
	   	var value = (menuList[j].menuCode);
       		var desc = (menuList[j].shortDesc);
	   	selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
		}	               
					
	/****** Setting Table values ******/
	
	//Getting Meal Type List::
	var mealTypeList=new Array();
	mealTypeList = jsonObjResponse.jsonMealList;
	globalMealTypeList = jsonObjResponse.jsonMealList;
	var strMealTypes = "";
	
	for (var j=0; j < globalMealTypeList.length;j++) {
	
		if(strMealTypes != "")
		{
			//strMealTypes += "," + globalMealTypeList[j].mealType + "," + globalMealTypeList[j].shortDesc;
			strMealTypes += "::" + globalMealTypeList[j].mealType;
		}
		else
		{
			//strMealTypes += globalMealTypeList[j].mealType + "," + globalMealTypeList[j].shortDesc;
			strMealTypes += globalMealTypeList[j].mealType;
		}
	}	
	OPMealTypes = strMealTypes;
	
	 var tHead = document.getElementById("divOPMealOrderHdr");
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='Common.patientId.label' bundle='${common_labels}' />";
	
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='Common.PatientName.label' bundle='${common_labels}' />";
	 
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='Common.ApptDate/Time.label' bundle='${common_labels}' />";
	 
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='eDS.VisitDateTime.label' bundle='${ds_labels}' />";
	 
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='Common.apptno.label' bundle='${common_labels}' />";
	 
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='Common.encounterid.label' bundle='${common_labels}' />";
	 
	  //CRF 684
	  <%if(isMenuType)
	    {
	  %>
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='eDS.MenuType.Label' bundle='${ds_labels}' />";	
	  <%}%>
	 
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='eDS.DietType.Label' bundle='${ds_labels}' />";
	
		
	  for (var j=0; j < mealTypeList.length;j++) {
			var newTH = document.createElement('th');
			tHead.rows[0].appendChild(newTH); //append ne th to table 
			
			newTH.innerHTML = mealTypeList[j].shortDesc;
			//newTH.innerHTML = mealTypeList[j][1];
		}

	  //Setting hidden value for mealtype count::
	 document.getElementById("mealTypeCount").value = mealTypeList;	
		
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='eDS.FoodDislike.Label' bundle='${ds_labels}' />";
	
     	var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='eDS.SpecialFoodItem.Label' bundle='${ds_labels}' />";
	
	//MMOH-CRF-417
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='eOT.preparatoryInstruction.Label' bundle='${ot_labels}' />";
	//MMOH-CRF-417
	 
	 var newTH = document.createElement('th');
	 tHead.rows[0].appendChild(newTH); //append ne th to table 
	 newTH.innerHTML = "<fmt:message key='eDS.Remarks.Label' bundle='${ds_labels}' /></TH>"; 
	
 	//Getting Meal Record List::
	var orderList=new Array();
	orderList = jsonObjResponse.jsonOrderList;
	var divOPMealOrderList = document.getElementById("divOPMealOrderList");
	var row_ind1 = 0;
	
	if(orderList!=null)
	{
		//getting maximum record
		
	    if(orderList.length == 0){
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
		}
		else{	
			//Mealtype outer list , which has the list for all records
			var mealList=new Array();
			mealList = jsonObjResponse.jsonMealTypeList;
			
			for(var itr=0; itr <orderList.length;itr++){
					var newRow3 = divOPMealOrderList.insertRow(row_ind1);
					//FOr Mealtype::
					
					var objMealTypes = new Array();
					if(orderList[itr].apptno != "")
					{
						objMealTypes = eval("mealList[0].appt"+orderList[itr].apptno);
					}else if(orderList[itr].encounterid != "")
					{
						objMealTypes = eval("mealList[0].enct"+orderList[itr].encounterid);
					}
					 
					 var specality=document.QueryResult.splility.value;//ML-MMOH-CRF-0596

					 
					//Patient ID:
					var newCellDesc = fnInsertCell(newRow3);
					newCellDesc.appendChild(document.createTextNode(orderList[itr].patientId));
					newCellDesc.id = "patId"+ row_ind1;
					newCellDesc.value = orderList[itr].patientId;
					if(orderList[itr].patientId == "")
						newCellDesc.innerHTML = "&nbsp;";
					//ML-MMOH-CRF-0596
					var patient_id = newCellDesc.value;			
			                var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					var params = "func_mode=OPMealCount&patient_id="+patient_id+"&specality="+specality;//ML-MMOH-CRF-0596
					xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					var encounterCount =retVal;
					document.QueryResult.encounterCount.value=encounterCount;
					//ML-MMOH-CRF-0596

					
					//PatientName:
					var newCellDesc2 = fnInsertCell(newRow3);
					newCellDesc2.appendChild(document.createTextNode(orderList[itr].patientName));
					newCellDesc2.id = "patName"+ row_ind1;
					newCellDesc2.value = orderList[itr].patientName;
					if(orderList[itr].patientName == "")
						newCellDesc2.innerHTML = "&nbsp;";
					
					//Appointment Date:
					var newCellDesc2 = fnInsertCell(newRow3);
					newCellDesc2.appendChild(document.createTextNode(orderList[itr].apptDate + " " + orderList[itr].apptTime));
					newCellDesc2.id = "apptDate"+ row_ind1;
					newCellDesc2.value = orderList[itr].apptDate;
					if(orderList[itr].apptDate == "")
						newCellDesc2.innerHTML = "&nbsp;";
						
					//Visit Date:
					var newCellDesc2 = fnInsertCell(newRow3);
					newCellDesc2.appendChild(document.createTextNode(orderList[itr].visitDate));
					newCellDesc2.id = "visitDate"+ row_ind1;
					newCellDesc2.value = orderList[itr].visitDate;
					if(orderList[itr].visitDate == "")
						newCellDesc2.innerHTML = "&nbsp;";
						
					//Appointment No:
					var newCellDesc2 = fnInsertCell(newRow3);
					if(orderList[itr].ApptNo == null)
						orderList[itr].ApptNo = "";
					newCellDesc2.appendChild(document.createTextNode(orderList[itr].apptno));
					newCellDesc2.id = "apptNo"+ row_ind1;
					newCellDesc2.value = orderList[itr].apptno;
					if(orderList[itr].apptno == "")
						newCellDesc2.innerHTML = "&nbsp;";
						
					//Encounter ID:
					var newCellDesc2 = fnInsertCell(newRow3);
					newCellDesc2.appendChild(document.createTextNode(orderList[itr].encounterid));
					newCellDesc2.id = "enctId"+ row_ind1;
					newCellDesc2.value = orderList[itr].encounterid;
					if(orderList[itr].encounterid == "")
						newCellDesc2.innerHTML = "&nbsp;";
					
					//ML-MMOH-CRF-0596						
	                		var encounteridnew=newCellDesc2.value;
			        	var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					var params2 = "func_mode=OPMealCount2&encounteridnew="+encounteridnew+"&specality="+specality;//ML-MMOH-CRF-0596
					xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params2,false);
					xmlHttp.send(xmlDoc);
					var retVal2 = trimString(xmlHttp.responseText);
					var secondCount =retVal2;
					document.QueryResult.secondCount.value=secondCount;	
					//ML-MMOH-CRF-0596
					
			//CRF-684
			 <%
				if(isMenuType){
	                  %>
				var newCellDesc2 = fnInsertCell(newRow3);
				var sModFlag = orderList[itr].modifiedFlag;
				var selObj = "<SELECT name='menuType"+row_ind1+"' id='menuType"+row_ind1+"'    onchange=\"setFlagForMenuType('"+row_ind1+"','"+sModFlag+"');\">";
				var label=getLabel("Common.defaultSelect.label","Common");						

				var menuList=new Array();
				menuList = jsonObjResponse.jsonMenuList;
				var menuListlength=0;
				if(typeof(menuList)!='undefined')
				menuListlength=menuList.length;
				if(menuListlength!=1)
				selObj += "<OPTION value=''>"+label+"</OPTION>";
				for (var j=0; j < menuListlength;j++) {
				var value = (menuList[j].menuCode);
				var desc = (menuList[j].shortDesc);
				var DEFAULT_YN = (menuList[j].DEFAULT_YN);
				var defaultcount = (menuList[j].defaultcount);
			    	if(defaultcount == 1 && DEFAULT_YN == "Y")
				{
				    selObj += "<OPTION value='" + value + "' selected>" + desc + "</OPTION>";
				}
	                 	else if((menuList[j].menuCode) == (orderList[itr].menuType))
				{
					 selObj += "<OPTION value='" + value + "' selected>" + desc + "</OPTION>";
			    	}
				else{
					    selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";							
				}
				}		           
	                 			
				selObj += "</SELECT>";						
				selObj += "<img src='../../eCommon/images/mandatory.gif' id=\'menuType"+row_ind1+"\'  style=\'visibility:visible\' />";
				newCellDesc2.innerHTML = selObj;
			  <%}%>
					 

					//Diet Type:
					var newCellDesc2 = fnInsertCell(newRow3);
					var sModFlag = orderList[itr].modifiedFlag;

					var selObj = "<SELECT name='dietTypes"+row_ind1+"' id='dietTypes"+row_ind1+"' onKeyUp=\"diettype_Autocomplete1('"+row_ind1+"','"+sModFlag+"')\" onClick=\"Select1('"+row_ind1+"','"+sModFlag+"')\" onchange=\"setFlagForDietType('"+row_ind1+"','"+sModFlag+"');\">";//Added Against Ml-MMOH-CRF-0674				
				
					var label=getLabel("Common.defaultSelect.label","Common");
				
         		   //Added Starts against ML-MMOH-CRF-0418 
	               var dietListlength=0;
	               if(typeof(dietList)!='undefined')
	               dietListlength=dietList.length;
	               //Added Ends against ML-MMOH-CRF-0418
	
	                //Added against ML-MMOH-CRF-0418 
	                if(dietListlength!=1)
					 selObj += "<OPTION value=''>"+label+"</OPTION>";
					for (var j=0; j <dietListlength;j++) { //Modified against ML-MMOH-CRF-0418 
						//var value = (dietList[j]);
						//var desc = (dietList[j]);
						var value = (dietList[j].DietCode);
						var desc = (dietList[j].DietDesc);
						if((dietList[j].DietCode) == (orderList[itr].diettype)){
							selObj += "<OPTION value='" + value + "' selected>" + desc + "</OPTION>";
                           					
						}
						else{
							selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
							
						}
					}
					
					selObj += "</SELECT>";
					newCellDesc2.innerHTML = selObj;					
                     
					//MealTypes:
					     <%
						if(!isMealType){
					     %>						
					   for (var j=0; j < mealTypeList.length;j++) {
						var newCellDesc2 = newRow3.insertCell(newRow3.cells.length);
						newCellDesc2.align = "center";
						var tmpMealtype = mealTypeList[j].mealType;
						var varMealName = mealTypeList[j].mealType + "" + row_ind1;
						
						//Added Against ML-MMOH-CRF-0825 Starts Here
						var ServingStartTimeOP = mealTypeList[j].ServingStartTimeOP;
						if (ServingStartTimeOP == "undefined" || ServingStartTimeOP== null){
							ServingStartTimeOP = "";
						}
						var ServingEndTimeOP = mealTypeList[j].ServingEndTimeOP;
						if (ServingEndTimeOP == "undefined" || ServingEndTimeOP== null){
							ServingEndTimeOP = "";
						}
						var IrregularStartTimeOP = mealTypeList[j].IrregularStartTimeOP;
						if (IrregularStartTimeOP == "undefined" || IrregularStartTimeOP== null){
							IrregularStartTimeOP = "";
						}
						var IrregularEndTimeOP = mealTypeList[j].IrregularEndTimeOP;
						if (IrregularEndTimeOP == "undefined" || IrregularEndTimeOP== null){
							IrregularEndTimeOP = "";
						}
						var nextServingStartTimeOP = mealTypeList[j].nextServingStartTimeOP;
						if(ServingStartTimeOP=="" && ServingEndTimeOP=="" && IrregularStartTimeOP=="" && IrregularEndTimeOP==""){
							IrregularEndTimeOP = nextServingStartTimeOP;
						}
						var today = new Date(); 
						var hour=today.getHours();
						if(hour<=9){
							hour="0"+""+hour;
						}
						var minute=today.getMinutes();
						if(minute<=9){
							minute="0"+""+minute;
						}
						var Sys_time = hour+":"+minute;	
						var lateIrregularDietOrderOP = document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_OP").value;
						//Added Against ML-MMOH-CRF-0825 Ends Here
						
						//var mealName1 = mealTypeList[j].mealType;
						
						if(objMealTypes != "undefined" && objMealTypes.contains(tmpMealtype))
						{
						//Modified Against ML-MMOH-CRF-0825 Starts Here
							if(lateIrregularDietOrderOP == "Y" && IrregularEndTimeOP == "" && ServingEndTimeOP != "" && ServingEndTimeOP < Sys_time){
								sel = "<input type='checkbox' class='mealTypes' align = 'center' disabled onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='N'>";
							}
							else if(lateIrregularDietOrderOP == "Y" && IrregularEndTimeOP != "" && IrregularEndTimeOP < Sys_time){
								sel = "<input type='checkbox' class='mealTypes'  align = 'center' disabled onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='N'>";
							}else{
								sel = "<input type='checkbox' class='mealTypes' align = 'center' onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' checked value='"+ varMealName +"' onclick =\"checkTheBox1(this.className,'"+checkBoxCount+"','"+encounterCount+"','"+row_ind1+"','"+secondCount+"',this);\">";
							}							
						}
						else
						{	
							if(lateIrregularDietOrderOP == "Y" && IrregularEndTimeOP == "" && ServingEndTimeOP != "" && ServingEndTimeOP < Sys_time){
								sel = "<input type='checkbox' class='mealTypes' align = 'center' disabled onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='N'>";
							}
							else if(lateIrregularDietOrderOP == "Y" && IrregularEndTimeOP != "" && IrregularEndTimeOP < Sys_time){
								sel = "<input type='checkbox' class='mealTypes'  align = 'center' disabled onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='N'>";
							}else{
								sel = "<input type='checkbox' class='mealTypes' align = 'center' onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='"+ varMealName +"' onclick =\"checkTheBox1(this.className,'"+checkBoxCount+"','"+encounterCount+"','"+row_ind1+"','"+secondCount+"',this);\">";
							}					
						}
						//Modified Against ML-MMOH-CRF-0825 Ends Here
						newCellDesc2.innerHTML = sel;
					    }
					   <% } %>						
					 <%
					     //ML-MMOH-CRF-0596
					     if(isMealType){
					 %>				   
					    for (var j=0; j < mealTypeList.length;j++) {
						var newCellDesc2 = newRow3.insertCell(newRow3.cells.length);
						newCellDesc2.align = "center";
						var tmpMealtype = mealTypeList[j].mealType;
						//Added Against ML-MMOH-CRF-0825 Starts Here
						var ServingStartTimeOP = mealTypeList[j].ServingStartTimeOP;
						if (ServingStartTimeOP == "undefined" || ServingStartTimeOP== null){
							ServingStartTimeOP = "";
						}
						var ServingEndTimeOP = mealTypeList[j].ServingEndTimeOP;
						if (ServingEndTimeOP == "undefined" || ServingEndTimeOP== null){
							ServingEndTimeOP = "";
						}
						var IrregularStartTimeOP = mealTypeList[j].IrregularStartTimeOP;
						if (IrregularStartTimeOP == "undefined" || IrregularStartTimeOP== null){
							IrregularStartTimeOP = "";
						}
						var IrregularEndTimeOP = mealTypeList[j].IrregularEndTimeOP;
						if (IrregularEndTimeOP == "undefined" || IrregularEndTimeOP== null){
							IrregularEndTimeOP = "";
						}
						var nextServingStartTimeOP = mealTypeList[j].nextServingStartTimeOP;
						if(ServingStartTimeOP=="" && ServingEndTimeOP=="" && IrregularStartTimeOP=="" && IrregularEndTimeOP=="" ){
							IrregularEndTimeOP = nextServingStartTimeOP;
						}
						var today = new Date();
						var hour=today.getHours();
						if(hour<=9){
							hour="0"+""+hour;
						}
						var minute=today.getMinutes();
						if(minute<=9){
							minute="0"+""+minute;
						}
						var Sys_time = hour+":"+minute;
						var lateIrregularDietOrderOP = document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_OP").value;
						//Added Against ML-MMOH-CRF-0825 Ends Here
						
						var varMealName = mealTypeList[j].mealType + "" + row_ind1;
						if(objMealTypes != "undefined" && objMealTypes.contains(tmpMealtype))
						{
							//Modified Against ML-MMOH-CRF-0825 Starts Here
							if(lateIrregularDietOrderOP == "Y" && IrregularEndTimeOP == "" && ServingEndTimeOP != "" && ServingEndTimeOP < Sys_time){
								checkBoxCount=j;
								sel = "<input type='checkbox' class='mealTypes' align = 'center' disabled onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='N' onclick =\"checkTheBox(this.className,'"+checkBoxCount+"','"+encounterCount+"','"+row_ind1+"','"+secondCount+"');\">";
							}							
							else if(lateIrregularDietOrderOP == "Y" && IrregularEndTimeOP != "" && IrregularEndTimeOP < Sys_time ){
								checkBoxCount=j;
								sel = "<input type='checkbox' class='mealTypes'  align = 'center' disabled onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='N' onclick =\"checkTheBox(this.className,'"+checkBoxCount+"','"+encounterCount+"','"+row_ind1+"','"+secondCount+"');\">";
							}else{
								checkBoxCount=j;
								sel = "<input type='checkbox' class='mealTypes' align = 'center' onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' checked value='"+ varMealName +"' onclick =\"checkTheBox(this.className,'"+checkBoxCount+"','"+encounterCount+"','"+row_ind1+"','"+secondCount+"');\" >";//ML-MMOH-CRF-0596 and Modified Against ML-MMOH-CRF-0825(ICN-68623)
							}
						}
						
						else{
							if(lateIrregularDietOrderOP == "Y" && IrregularEndTimeOP == "" && ServingEndTimeOP != "" && ServingEndTimeOP < Sys_time){
								checkBoxCount=j;
								sel = "<input type='checkbox' class='mealTypes' align = 'center' disabled onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='N' onclick =\"checkTheBox(this.className,'"+checkBoxCount+"','"+encounterCount+"','"+row_ind1+"','"+secondCount+"');\">"; //ML-MMOH-CRF-0596
							}
							else if(lateIrregularDietOrderOP == "Y" && IrregularEndTimeOP != "" && IrregularEndTimeOP < Sys_time){
								checkBoxCount=j;
								sel = "<input type='checkbox' class='mealTypes' align = 'center' disabled onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='N' onclick =\"checkTheBox(this.className,'"+checkBoxCount+"','"+encounterCount+"','"+row_ind1+"','"+secondCount+"');\">"; //ML-MMOH-CRF-0596
							}else{
								checkBoxCount=j;
								sel = "<input type='checkbox' class='mealTypes' align = 'center' onchange=\"setFlag('"+row_ind1+"');\" name='"+ varMealName +"' id='"+ varMealName +"' value='"+ varMealName +"' onclick =\"checkTheBox(this.className,'"+checkBoxCount+"','"+encounterCount+"','"+row_ind1+"','"+secondCount+"');\">"; //ML-MMOH-CRF-0596 and Modified Against ML-MMOH-CRF-0825(ICN-68623)
							}
						}
						//Modified Against ML-MMOH-CRF-0825 Ends Here
						newCellDesc2.innerHTML = sel;
				    	}
						
					  <%}%>
				
					//Food Dislike:
					var foodDislike = new Array();
					foodDislike = orderList[itr].jsonFoodList.jsonFoodItem;
					
					if(foodDislike != undefined)
					{
						globalFoodDislike[row_ind1] = orderList[itr].jsonFoodList.jsonFoodItem;
					}
					else
					{
						globalFoodDislike[row_ind1] = new Array();
					}
						
					//globalFoodDislike. push(foodDislike);
					
					var nFoodDislike = 'foodDislike'+row_ind1;
					var newCellDesc2 = fnInsertCell(newRow3);
					var selObj = "<div id='"+nFoodDislike+"' value="+foodDislike+"><SELECT name='fooddislike' id='fooddislike' onchange=\"setFlag('"+row_ind1+"');\" size=2>";
					if(foodDislike != undefined)
					{
						for (var j=0; j < foodDislike.length;j++) {
							var internObj = foodDislike[j];
							
							var value = internObj[0]
							var desc = internObj[1];
							selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
						}	
					}
					selObj += "</SELECT></div>";
					selObj += "<input type='button' class='button' value='<fmt:message key='eOT.edit.Label' bundle='${ot_labels}' />'   name='btnfoodDislike' onClick=\"return getFoodItem(this,\'" + nFoodDislike + "\',\'" + row_ind1 + "\')\";>";	
					newCellDesc2.innerHTML = selObj;

					//Special Food Item:
					
					var splfoodList = new Array();
					splfoodList = orderList[itr].jsonSplFoodList.jsonSplFoodItem;
					if(splfoodList != undefined)
						globalSplFoodList[row_ind1] = orderList[itr].jsonSplFoodList.jsonSplFoodItem;
					else
						globalSplFoodList[row_ind1] = new Array();
					
										
					var nSplFood = 'splFoodSrl'+itr;
					var newCellDesc2 = fnInsertCell(newRow3);
						var selObj = "<div id='"+nSplFood+"'><SELECT name='splfooditem' id='splfooditem' onchange=\"setFlag('"+row_ind1+"');\" size=2>";
				   
					if(splfoodList != undefined)
					{
						var uniqueFoodItem = new Array();
						var indexUniqueFI = 0;
						for (var j=0; j < splfoodList.length;j++) {
							var splinternObj = splfoodList[j];
							var value = splinternObj[1];
							var desc = splinternObj[3];
							if(!uniqueFoodItem.contains(value)) //To avoid replication of same food item [with different mealtype] in placeorder screen
							{	
								uniqueFoodItem[indexUniqueFI++] = value;
								selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
							}
						}	
					}	
					selObj += "</SELECT></div>";
					selObj += "<input type='button' class='button' value='<fmt:message key='eOT.edit.Label' bundle='${ot_labels}' />'   name='btnsplfoodItem' onClick=\"return getSplFoodItem(\'" + row_ind1 + "\',\'" + nSplFood + "\')\";>";
					
					//Hidden Variables:
					//1- SplFoodItem hidden variable::
					
					var nHdnSplFood = 'hdnsplfoodItem'+row_ind1;
					var nHdnFoodDislike = 'hdnfoodDislikeItem'+row_ind1;
					
					selObj += "<input type='hidden' value='"+ foodDislike +"'   name='" + nHdnFoodDislike + "' id='" + nHdnFoodDislike + "'/>";
					selObj += "<input type='hidden' value='"+ splfoodList +"'   name='" + nHdnSplFood + "' id='" + nHdnSplFood + "'/>";
					//2-ModFlag::
					selObj += "<input type='hidden' value='"+orderList[itr].modifiedFlag+"'   name='modFlag"+row_ind1+"' id='modFlag"+row_ind1+"'/>";
					//3-ServingDate::
					var nHdnServingDate = 'hdnservingdate'+row_ind1;
					selObj += "<input type='hidden' value='"+orderList[itr].servingDate+"'   name='" + nHdnServingDate + "' id='" + nHdnServingDate + "'/>";
					newCellDesc2.innerHTML = selObj;
					
					//Prepartory Instruction
					//MMOH-CRF-417					
					var newCellDesc3 = fnInsertCell(newRow3);
					htmlRemarks = "<textarea  onkeypress=\"restrictSpecialChars(event)\" onchange=\"setFlag('"+row_ind1+"');\" name='prepartoryInstr"+ row_ind1 +"' id='prepartoryInstr"+ row_ind1 +"' onKeyPress=\"return maxLength(this,'400');\" onKeyUp=\"return maxLengthPaste(this,'400','"+row_ind1+"');\" onblur=\"return hasInvalidChars(this,'"+PreparatoryInstruction_Label+"');\" value='\"+orderList[itr].prepartoryInstr+\"' rows=2>"+decodeURIComponent(orderList[itr].prepartoryInstr)+"</textarea>";
					<!--058037-->
					newCellDesc3.innerHTML = htmlRemarks;
					//MMOH-CRF-417					
					
					//Remarks:
					var newCellDesc2 = fnInsertCell(newRow3);
										
					htmlRemarks = "<textarea onchange=\"setFlag('"+row_ind1+"');\" name='remarks"+ row_ind1 +"' id='remarks"+ row_ind1 +"'  onKeyPress=\"return maxLength(this,'150');\" onKeyUp=\"return maxLengthPaste(this,'150','"+row_ind1+"');\" value='\"+orderList[itr].remarks+\"' rows=2>"+decodeURIComponent(orderList[itr].remarks)+"</textarea>";
					//MMOH-CRF-417
					htmlRemarks = "<textarea  onkeypress=\"restrictSpecialChars(event)\" onchange=\"setFlag('"+row_ind1+"');\" name='remarks"+ row_ind1 +"' id='remarks"+ row_ind1 +"' onKeyPress=\"return maxLength(this,'150');\" onKeyUp=\"return maxLengthPaste(this,'150','"+row_ind1+"');\" onblur=\"return hasInvalidChars(this,'"+Remarks_Label+"');\" value='\"+orderList[itr].remarks+\"' rows=2>"+decodeURIComponent(orderList[itr].remarks)+"</textarea>"; <!--058037-->
					//htmlRemarks = "<textarea onchange=\"if(trim(this.value)!='')setFlag('"+row_ind1+"');\" name='remarks"+ row_ind1 +"'  onkeypress=\"restrictSpecialChars(event)\"   maxlength=150 value='"+orderList[itr].remarks+"' rows=2>"+orderList[itr].remarks+"</textarea>";
					
					newCellDesc2.innerHTML = htmlRemarks;
					
					row_ind1++;
				}	
			} 
	}else
	{
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
	}
	
	//To restrict the control characters to maximum given extent:
	  function maxLength(field,maxChars)
	 { 
		  if(field.value.length >= maxChars) {
			  event.returnValue=false; 
			  
			  return false;
		   }
	 }  

	 function maxLengthPaste(field,maxChars,rowind)
	 {
		if(field.value.length > maxChars) {
			var str = field.value;
			field.value = str.substring(0,maxChars);
			setFlag(rowind);
		}
	 }

	//Function : Create new Cell on the row: 
	function fnInsertCell(newRow)
	{
			var newCellDesc = newRow.insertCell(newRow.cells.length);
				newCellDesc.className = "lable";
				
				newCellDesc.colSpan = "1";
				newCellDesc.align = "center";
				newCellDesc.setAttribute("border", "0px");
				newCellDesc.style.fontSize ="10pt"
				newCellDesc.style.color = "#4E387E"				
				return newCellDesc;
	}

	//var foodDislikeList = new Array();
	var countRowValue = 0;
	var foodDislikeListArr = new Array();
	var itemCodeDel = new Array();
	//Getting Food Dislike Items:
	async function getFoodItem(obj1, obj2, rowno)
	{
		var foodDislikeList = new Array();
		var dialogUrl1 = "../../eDS/jsp/OPFoodDislikes.jsp";
		var nFoodDislikeSrl = "hdnfoodDislikeItem" + rowno;
		var dialogArguments = document.getElementById(nFoodDislikeSrl).value;
		var tmpFoodDislike = document.getElementById(nFoodDislikeSrl).value;
		var dialogFeatures = "dialogHeight:52vh;dialogWidth:50vw;status:no;scroll:no";
		
		returnVal1 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
		
		if (returnVal1) {
			foodDislikeList = returnVal1;
			globalFoodDislike[rowno] = returnVal1;
			var tbodyObj = document.getElementById(obj2);
			var selObj = "<SELECT name='fooddislike' id='fooddislike' size=2>";
			for (var i = 0; i < foodDislikeList.length; i++) {
				var arrFoodItem = foodDislikeList[i];
				if(arrFoodItem != null && arrFoodItem[2] != "-1")
				{
					var value = arrFoodItem[0];
					var desc = arrFoodItem[1];
					selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
				}
			}	
			selObj += "</SELECT>";
			tbodyObj.innerHTML = selObj;
			tbodyObj.value=foodDislikeList; //used as hidden field for taking row values on insertion..
			document.getElementById(nFoodDislikeSrl).value = returnVal1;
		}else
		{
			document.getElementById(nFoodDislikeSrl).value = tmpFoodDislike;
		}
		setFlag(rowno); //Updating the flag which is for notifying that record is updated with fooditem.
	}
	
	var supplimentArray = new Array();
	var returnVal1 = null;
	
	//Function : Getting Special Food Items:
	async function getSplFoodItem(iter,obj2)
	{	
		var k=0;
		var j=0;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";
		var nSplFoodSrl = "hdnsplfoodItem" + iter;
		
		//var encounterId = document.getElementById("encounterId").value;
		//var patientClass = document.getElementById("patientClass").value;

		var encounterId  =  "E1";
		var patientClass =  "OP";
		var dialogUrl1 = "../../eDS/jsp/OPSpFoodItems.jsp?encounterId="+encounterId+"&patientClass="+patientClass+"&fecthedMealTypes="+OPMealTypes;
		
		var dialogArguments = document.getElementById(nSplFoodSrl).value ;
		
		var tmpSplFoods = document.getElementById(nSplFoodSrl).value;
		var dialogFeatures = "dialogHeight:90vh;dialogWidth:80vw;status:no;scroll:no";
		returnVal1 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);		
		
		if (returnVal1) {
		
			splfoodList = returnVal1;
			globalSplFoodList[iter] = returnVal1;
			
			var tbodyObj = document.getElementById(obj2);
			
			var selObj = "<SELECT name='splfooditem' id='splfooditem' size=2>";
			var uniqueFoodItem = new Array();
			var indexUniqueFI = 0;
			for (var i = 0; i < splfoodList.length; i++) { //Abirami
				var arrFoodItem = splfoodList[i];
				if(arrFoodItem[7] != -1)
				{
					var value = arrFoodItem[0];
					var desc = arrFoodItem[3];
					if(!uniqueFoodItem.contains(value)) //To avoid replication of same food item [with different mealtype] in placeorder screen
					{	
						uniqueFoodItem[indexUniqueFI++] = value;
						selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
					}
				}
			}	
			selObj += "</SELECT>";
			tbodyObj.innerHTML = selObj;
			document.getElementById(nSplFoodSrl).value = returnVal1;
		}else if(tmpSplFoods == "")
		{
			var tbodyObj = document.getElementById(obj2);
			var selObj = "<SELECT name='splfooditem' id='splfooditem' size=2>";
			selObj += "<OPTION value=''></OPTION>";
			selObj += "</SELECT>";
			tbodyObj.innerHTML = selObj;
			document.getElementById(nSplFoodSrl).value = "";
		}else
		{
			document.getElementById(nSplFoodSrl).value = tmpSplFoods;
		}
		setFlag(iter); //Updating the flag which is for notifying that record is updated with fooditem.
	}	
	
	//Function : Inserting/Updating the Records of Placed Order into the Database:  
	function apply()
	{ 
		//for(var i =0 ; i<gRecordUpdated.length; i++)
		var sWarnMsgForMealType = ""
		var divOPMealOrderList = parent.frames[1].document.getElementById("divOPMealOrderList");
		for(var i=0;i<divOPMealOrderList.rows.length; i++) //For each row
		{ 
				var remarks     = trim(parent.frames[1].document.getElementById("remarks"+i).value);
				var prepartoryInstr     = trim(parent.frames[1].document.getElementById("prepartoryInstr"+i).value);//MMOH-CRF-417 
				var foodDislike = globalFoodDislike[i];
				var splFoodItem = globalSplFoodList[i]; 
				var sPatId 		= parent.frames[1].document.getElementById("patId"+i).value;
				var sPatName 	= parent.frames[1].document.getElementById("patName"+i).value;
				var sApptNo 	= parent.frames[1].document.getElementById("apptNo"+i).value;
				var sEnctId 	= parent.frames[1].document.getElementById("enctId"+i).value;
				var bRowMealTypeChecked = false;
				var valExistsInFD = false;
				var valExistsInSplFood = false;
				
				for (var count = 0; count < foodDislike.length; count++) {
					if(foodDislike[count]!=null && foodDislike[count][2] != null && foodDislike[count][2] != "-1")
					{
						valExistsInFD = true;
					}
				}	
				
				for (var icount = 0; icount < splFoodItem.length; icount++) {
					if(splFoodItem[icount]!=null && splFoodItem[icount][7] != null && splFoodItem[icount][7] != "-1")
					{
						valExistsInSplFood = true;
					}
				}
				//if( (remarks!="" || foodDislike!="" || splFoodItem !="") ) //if one of these fields are entered
				if( (remarks!="" || valExistsInFD == true || valExistsInSplFood == true || prepartoryInstr!="") ) //if one of these fields are entered
				{  
					//417 checking any special character are there in preparatoryInstruction column and remarks column
					var sp_flag=hasInvalidChars(parent.frames[1].document.getElementById("prepartoryInstr"+i),PreparatoryInstruction_Label);
					if(sp_flag==true){
					sp_flag=hasInvalidChars(parent.frames[1].document.getElementById("remarks"+i),Remarks_Label);
						if(sp_flag==false){
							return false;
						}
						}else{
							return false;
						}
					for (var j=0; j < mealTypeList.length;j++) { // for each mealtype
						var varMealType = globalMealTypeList[j].mealType+""+i;
						if(parent.frames[1].document.getElementById(varMealType).checked) //if mealtype is checked
						{ 
							bRowMealTypeChecked = true; 
						}
					}
					if(!bRowMealTypeChecked) //if none of the mealtype is checked
					{ 
						if(sWarnMsgForMealType != "")
						{
							sWarnMsgForMealType += "\n"+ sApptNo +"\t" + sEnctId;
						}else
						{
							//sWarnMsgForMealType = "Atleast One MealType Should be selected for the following appointment/visit:\nAppt No\tEncounter ID \n"+ sApptNo +"\t" + sEnctId;
							sWarnMsgForMealType = getMessage("DS_SEL_MEALTYPE","DS") + "\n"+ sApptNo +"\t" + sEnctId;
						}
					}
				}
		}
	
		if(sWarnMsgForMealType!="")
		{
			alert(sWarnMsgForMealType);
			return;
		} 
		// CRF- 0684 
		<%if(isMenuType){%>
 	    if(parent.frames[1].document.querySelectorAll("menuType").value ==  ""){
			alert(getMessage("DS_MENU_TYPE","DS"));
			return;
		}
		<%}%>
	    // CRF- 0684
		if(gRecordUpdated.length <1)
		{
			//alert('Atleast one Record Should be Updated...');
			alert(getMessage("DS_UPD_REC","DS"));
			return;
		}

		//Added Against ML-MMOH-CRF-0825 Starts Here
		for (var j=0; j < mealTypeList.length;j++) {
				var Mealtype_Name = mealTypeList[j].shortDesc+""+row_ind1;
				var mealTypeCode = mealTypeList[j].mealType+""+row_ind1;
				var irregular_meal_name="";
				var irregular_meal_code="";				
				var dateFrom=document.getElementById("systemDate").value;
				var ServingStartTimeOP = mealTypeList[j].ServingStartTimeOP;
				var IrregularStartTimeOP = mealTypeList[j].IrregularStartTimeOP;
					if (IrregularStartTimeOP == "undefined" || IrregularStartTimeOP== null){
						IrregularStartTimeOP = "";
					}
				var IrregularEndTimeOP = mealTypeList[j].IrregularEndTimeOP;
					if (IrregularEndTimeOP == "undefined" || IrregularEndTimeOP== null){
						IrregularEndTimeOP = "";
					}
				var nextServingStartTimeOP = mealTypeList[j].nextServingStartTimeOP;
					if(IrregularEndTimeOP==""){
						IrregularEndTimeOP = nextServingStartTimeOP;
					}
				var today = new Date();
				var hour=today.getHours();
				if(hour<=9){
					hour="0"+""+hour;
				}
				var minute=today.getMinutes();
				if(minute<=9){
					minute="0"+""+minute;
				}
				var Sys_time = hour+":"+minute;
				var lateIrregularDietOrderOP = document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_OP").value;
			
			irregular_meal_name=Mealtype_Name.substring(0,Mealtype_Name.length-1);
			irregular_meal_code=mealTypeCode.substring(0,mealTypeCode.length-1);
			
			var chkvalue = parent.frames[1].document.getElementById("mealone").value;
			<%
				if(isMealType){
			%>	
					if(lateIrregularDietOrderOP == "Y" && IrregularStartTimeOP!="" && IrregularEndTimeOP!="" && IrregularStartTimeOP < Sys_time && IrregularEndTimeOP > Sys_time){
						var msg=getMessage("DS_IRREGULAR_DIET_ORDER","DS");
						msg=msg.replace("#", dateFrom);
						msg+=""+irregular_meal_name;
						//Modified Against ML-MMOH-CRF-0825(ICN-68623) Starts Here
						var str_array = chkvalue.split(',');
						for(var i = 0; i < str_array.length; i++) {
							str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
							str_array[i] =  str_array[i].substring(0,str_array[i].length-1);
							if(str_array[i] != "undefined" && str_array[i] == irregular_meal_code){
								alert(msg);
								break;
							}
						}
						//Modified Against ML-MMOH-CRF-0825(ICN-68623) Ends Here
					}
			<%}%>
			
			<%
			if(!isMealType){
			%>
				if(lateIrregularDietOrderOP == "Y" && IrregularStartTimeOP!="" && IrregularEndTimeOP!="" && IrregularStartTimeOP < Sys_time && IrregularEndTimeOP > Sys_time){
					var msg=getMessage("DS_IRREGULAR_DIET_ORDER","DS");
					msg=msg.replace("#", dateFrom);
					msg+=""+irregular_meal_name;
					var str_array = chkvalue.split(',');
					for(var i = 0; i < str_array.length; i++) {
						str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
						str_array[i] =  str_array[i].substring(0,str_array[i].length-1);
						if(str_array[i] != "undefined" && str_array[i] == irregular_meal_code){
							alert(msg);
							break;//Added Against ML-MMOH-CRF-0825(ICN-68623)
						}
					}
				}
			<%}%>
		 }
		//Added Against ML-MMOH-CRF-0825 Ends Here
		
		var jsonObjMealOrders 	= new Object();	
		
		var jsonArrMealOrders	= new Array();
		var noEntry = true;
		var sWarningMsg = "";
		var tmpjsonApptObj 		= new Array();
		var tmpjsonEnctObj 		= new Array();
		var nIndexForAppt = 0;
		var nIndexForEnct = 0;
		//Getting records and sending as JSON object into servlet: 
		for(var i=0;i<divOPMealOrderList.rows.length; i++)
		{ 
			if(gRecordUpdated.contains(i))
			{ 
				//Declaration::			
				var jsonRowDataObject 	= new Object();
				var jsonMealTypeObj 	= new Array();
				
				var sPatId 		=	parent.frames[1].document.getElementById("patId"+i).value;
				var sPatName 	=	parent.frames[1].document.getElementById("patName"+i).value;
				var sApptNo 	=	parent.frames[1].document.getElementById("apptNo"+i).value;
				var sEnctId 	=	parent.frames[1].document.getElementById("enctId"+i).value;
				//Getting values::
				jsonRowDataObject.patientId   = sPatId;
				jsonRowDataObject.patientName = sPatName;

				jsonRowDataObject.apptDate    = parent.frames[1].document.getElementById("apptDate"+i).value;
				jsonRowDataObject.visitDate   = parent.frames[1].document.getElementById("visitDate"+i).value;
				jsonRowDataObject.servingDate = parent.frames[1].document.getElementById("hdnservingdate"+i).value;
				jsonRowDataObject.apptNo      = sApptNo;
				jsonRowDataObject.enctId      = sEnctId;
				jsonRowDataObject.dietTypes   = parent.frames[1].document.getElementById("dietTypes"+i).value;
				<%if(isMenuType){%>
				jsonRowDataObject.menuType   = parent.frames[1].document.getElementById("menuType"+i).value;
				<%}%>
				//jsonRowDataObject.remarks     = trim(parent.frames[1].document.getElementById("remarks"+i).value);
				jsonRowDataObject.remarks     = encodeURIComponent(trim(parent.frames[1].document.getElementById("remarks"+i).value)); // Lang-support for Remarks
				jsonRowDataObject.prepartoryInstr     = encodeURIComponent(trim(parent.frames[1].document.getElementById("prepartoryInstr"+i).value)); // MMOH-CRF-417
				jsonRowDataObject.foodDislike = globalFoodDislike[i];	
				jsonRowDataObject.splFoodItem = globalSplFoodList[i];
				jsonRowDataObject.modFlag 	= parent.frames[1].document.getElementById("modFlag"+i).value;

				if(jsonRowDataObject.enctId != "")
					tmpjsonEnctObj[nIndexForEnct++] = jsonRowDataObject.enctId;
				else
					tmpjsonApptObj[nIndexForAppt++] = jsonRowDataObject.apptNo;
					
				if(jsonRowDataObject.modFlag == 'N' || jsonRowDataObject.modFlag == 'Y')
				{
					if(sWarningMsg != "")
					{
						sWarningMsg += "\n"+sApptNo +"\t" + sEnctId ;
					}else
					{
						//sWarningMsg = "Meal Order has already been placed for the following appointment/visit. Saving the changes will override the previous meal order. Are you sure you wish to continue?\nAppt No\tEncounter ID"
						sWarningMsg = getMessage("DS_OVERRIDE_MEALORDER","DS") + "\n"+ sApptNo +"\t" + sEnctId;
					}
				}
				
				for (var j=0; j < mealTypeList.length;j++) {
					var varMealType = globalMealTypeList[j].mealType+""+i;
					
					if(parent.frames[1].document.getElementById(varMealType).checked)
						jsonMealTypeObj.push(globalMealTypeList[j].mealType);
				}
				jsonRowDataObject.mealTypes = jsonMealTypeObj;
				if( (jsonRowDataObject.mealTypes != "" && jsonRowDataObject.modFlag == "") || jsonRowDataObject.modFlag != "")
					jsonArrMealOrders.push({rowmealOrder:jsonRowDataObject});
			}
		}
		if(sWarningMsg!="")
		{
			if(!window.confirm(sWarningMsg))
				return false;
		}
		//Check if the selected appointments are cancelled:: Start
		var tmpjsonDataObject = new Object();

		tmpjsonDataObject.apptObj = tmpjsonApptObj;
		tmpjsonDataObject.enctObj = tmpjsonEnctObj;

		var tmpjsonData = JSON.stringify(tmpjsonDataObject);
		var arguments="jsonData="+tmpjsonData+"&language_Id=en&mode=chkCanceledAppt";
	
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+arguments,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
		
		var tmpjsonObjResponse=eval('(' + retVal + ')');

		var apptList=new Array();
		var enctList=new Array();
		apptList = tmpjsonObjResponse.apptList;
		enctList = tmpjsonObjResponse.enctList;
		var sWarMsgForInvalidOrder = "";
		
		if (apptList!= "undefined" && apptList != null && apptList.length>0) 
		{ 
			//sWarMsgForInvalidOrder = "Unable to place meal order as the Appointment/Visit details do not match for the following Appointment/Visit: \nAppt No  Encounter ID";
			sWarMsgForInvalidOrder = getMessage("DS_UNABLE_PLACE_ORDER","DS");
			for (var j=0; j < apptList.length;j++) {
				sWarMsgForInvalidOrder += "\n" + apptList[j];
			}	
		}
		if (enctList!= "undefined" && enctList != null && enctList.length>0) 
		{ 
			if(sWarMsgForInvalidOrder == "")
			{
				//sWarMsgForInvalidOrder = "Unable to place meal order as the Appointment/Visit details do not match for the following Appointment/Visit: \nAppt No  Encounter ID";
				sWarMsgForInvalidOrder = getMessage("DS_UNABLE_PLACE_ORDER","DS");
			}
			for (var j=0; j < enctList.length;j++) {
				sWarMsgForInvalidOrder += "\n" + enctList[itr].appt_id + "\t" + enctList[itr].encounter_id;
			}	
		}

		if(sWarMsgForInvalidOrder  != "")
		{ 
			if(!window.confirm(sWarMsgForInvalidOrder))
				return;
		}
	
		// Inserting the other selected Encounter/Appoint Meal Order into the Database:
		jsonObjMealOrders.mealOrders = jsonArrMealOrders;
			
		var jsonData = JSON.stringify(jsonObjMealOrders);
		
		document.getElementById("jsonData").value = jsonData;
		document.getElementById("mode").value = "insertOPMealOrder";
		document.getElementById("kitchen").value = document.getElementById("hdnkitchen").value;
		document.forms[0].submit();
		
	}
	//Added Against Ml-MMOH-CRF-0674 starts Here
	function fecthDietType()
	{
	
	var diettype_auto=document.getElementById("diettype_auto").value;
	
	//var diettype_auto=parent.frames[1].document.getElementById("diettype_auto").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var params = parent.jsonOPObj;	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+params+"&diettype_auto="+diettype_auto,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;	
	var jsonObjResponse=eval('(' + retVal + ')');		
	var dietList=new Array();
	dietList = jsonObjResponse.jsonDietList;
	
	//Added Starts against ML-MMOH-CRF-0418 
	var dietListlength=0;
	if(typeof(dietList)!='undefined')
	dietListlength=dietList.length;
	//Added Ends against ML-MMOH-CRF-0418
	var selObj = "<SELECT name='dietTypes' id='dietTypes' onKeyUp='diettype_Autocomplete();' onClick='Select()' onchange='fecthDietTypeToMealClass();'>";
	var label=getLabel("Common.defaultSelect.label","Common");
	//Added against ML-MMOH-CRF-0418 
	//if(dietListlength!=1)
	selObj += "<OPTION value=''>"+label+"</OPTION>";
	for (var j=0; j < dietListlength;j++) {//Modified against ML-MMOH-CRF-0418 
		var value = (dietList[j].DietCode);
		var desc = (dietList[j].DietDesc);
		selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
	}	
	document.getElementById("tdHdrDietType").innerHTML = selObj;
	
	var str=document.getElementById("dietTypes").value;
	var auto_flag=document.getElementById("auto_flag").value
	if(str == "" && auto_flag == "true")
	{
		var sel = document.getElementById('dietTypes');
		var len = sel.options.length;
		if(len <= 3)
			sel.setAttribute('size', len);
		else
			sel.setAttribute('size', 3);
	}
	else if(str != "" && auto_flag == "false2")
	{
		var sel = document.getElementById('dietTypes');
		var len = sel.options.length;
		if(len <= 3)
			sel.setAttribute('size', len);
		else
			sel.setAttribute('size', 3);
	}		
}
	
function diettype_Autocomplete()
{
	document.getElementById("diettype_auto").value=""; 
	var selText="";
	var theKeyCode = window.event.keyCode;
	if(theKeyCode != 37 && theKeyCode != 38 && theKeyCode != 39 && theKeyCode != 40 && theKeyCode != 13 && theKeyCode != 8)
	{
		document.getElementById("auto_flag").value="true";
		selText += String.fromCharCode(theKeyCode);
		document.getElementById("diettype_auto").value=selText;
		fecthDietType();			 
	}
}

function Select()
{
	var auto_flag=document.getElementById("auto_flag").value;
	var myDropDown = document.getElementById("dietTypes");
	var str = myDropDown.options[myDropDown.selectedIndex].value;	   
		if(auto_flag == "true" && str!="")
		{	myDropDown.size = 1;
			document.getElementById("auto_flag").value="false2";
			document.getElementById("diettype_auto").value="";
		}
		else if(auto_flag == "true" && str=="")
		{			
			myDropDown.size = 1;  
			document.getElementById("diettype_auto").value="";
			document.getElementById("auto_flag").value="false";
			fecthDietType();				
		}
		else if(auto_flag == "false2" && str=="")
		{
			document.getElementById("diettype_auto").value="";
			document.getElementById("auto_flag").value="false";
			fecthDietType();			 
		}		
}   

function diettype_Autocomplete1(rowcount,sModFlag)
{
	document.getElementById("diettype_auto1").value=""; 
	var selText="";
	var theKeyCode = window.event.keyCode;
	if(theKeyCode != 37 && theKeyCode != 38 && theKeyCode != 39 && theKeyCode != 40 && theKeyCode != 13 && theKeyCode != 8)
	{
		document.getElementById("auto_flag1").value="true";
		selText += String.fromCharCode(theKeyCode);
		document.getElementById("diettype_auto1").value=selText;
		fecthDietType1(rowcount,sModFlag);			 
	}
}

function fecthDietType1(rowcount,sModFlag)
	{
	var diettype_auto=document.getElementById("diettype_auto1").value;
	var objnew;
		objnew = document.getElementById("dietTypes"+rowcount);
		while(objnew.length > 0){
			objnew.remove(0);
		}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var params = parent.jsonOPObj;	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+params+"&diettype_auto="+diettype_auto,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;	
	var jsonObjResponse=eval('(' + retVal + ')');		
	var dietList=new Array();
	dietList = jsonObjResponse.jsonDietList;				
         		//Added Starts against ML-MMOH-CRF-0418 
	               var dietListlength=0;
	               if(typeof(dietList)!='undefined')
	               dietListlength=dietList.length;
	               //Added Ends against ML-MMOH-CRF-0418
	
		var Entry = document.createElement("OPTION");
		var msg=getLabel("Common.defaultSelect.label","Common");					 		
		Entry.text = msg;
		Entry.value= "";
		objnew.add(Entry);
		for (var j=0; j <dietListlength;j++) {
				var Entry = document.createElement("option");				
				Entry.text = msg;
				Entry.value= "";
				var value = (dietList[j].DietCode);
				var desc = (dietList[j].DietDesc);						
				Entry.value  =value ;
				Entry.text  =desc ;
				objnew.add(Entry);			
			}
		//	parent.frames[1].document.getElementById("modFlag"+rowcount).value=sModFlag;
				//For Extended Dropdown List starts Here
		var str = document.getElementById('dietTypes'+rowcount).value;
		var auto_flag=document.getElementById("auto_flag1").value;
		if(str == "" && auto_flag == "true")
			{
				var sel = document.getElementById('dietTypes'+rowcount);
				var len = sel.options.length;
				if(len <= 3)
					sel.setAttribute('size', len);
				else
					sel.setAttribute('size', 3);
			}
		else if(str != "" && auto_flag == "false2")
			{
				var sel = document.getElementById('dietTypes'+rowcount);
				var len = sel.options.length;
				if(len <= 3)
					sel.setAttribute('size', len);
				else
					sel.setAttribute('size', 3);
			}
			//For Extended Dropdown List Ends Here
	}

function Select1(rowcount,sModFlag)
{
		var auto_flag=document.getElementById("auto_flag1").value;
		var myDropDown = document.getElementById("dietTypes"+rowcount);		
		var str = myDropDown.options[myDropDown.selectedIndex].value;  
		
			if(auto_flag == "true" && str!="")
			{	myDropDown.size = 1;
				document.getElementById("auto_flag1").value="false2";
				document.getElementById("diettype_auto1").value="";				
			}
			else if(auto_flag == "true" && str=="")
			{			
				myDropDown.size = 1;  
				document.getElementById("diettype_auto1").value="";
				document.getElementById("auto_flag1").value="false";
				fecthDietType1(rowcount,sModFlag);		 				
			}
		else if(auto_flag == "false2" && str=="")
			{
				document.getElementById("diettype_auto1").value="";
				document.getElementById("auto_flag1").value="false";
				fecthDietType1(rowcount,sModFlag);			 
			}		
}

 //Added against ML-MMOH-CRF-0674 Ends Here
</script>
	<INPUT type="hidden" name="diettype_auto" id="diettype_auto" id="diettype_auto" value=""><!-- Added against ML-MMOH-CRF-0674-->
	<INPUT type="hidden" name="auto_flag" id="auto_flag" id="auto_flag" value="false"><!-- Added against ML-MMOH-CRF-0674-->
	<INPUT type="hidden" name="diettype_auto1" id="diettype_auto1" id="diettype_auto1" value=""><!-- Added against ML-MMOH-CRF-0674-->
	<INPUT type="hidden" name="auto_flag1" id="auto_flag1" id="auto_flag1" value="false"><!-- Added against ML-MMOH-CRF-0674-->	
	<INPUT type="hidden" name="mealone" id="mealone" id="mealone" value=""><!-- Added against ML-MMOH-CRF-0825-->	
 </form>
</body>

