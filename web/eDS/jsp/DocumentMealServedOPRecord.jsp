<!DOCTYPE html>
<!--
File Name		: DocumentMealServedOPRecord.jsp
File Description: Document Result frame: This is to document/acknowledge the placed order .
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@page
import="java.sql.Connection,java.sql.Statement,java.sql.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eDS.DSCommonBean,eDS.*,java.util.ArrayList,java.net.URLEncoder"%><!-- Modified Against ML-MMOH-CRF-1125 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %> <!-- Added Against 683 CRF-->
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String imgUrl = "";
	if (sStyle.equals("IeStyle.css")) {
		imgUrl = "../../eCommon/images/searchBoxBG.jpg";
	}
%>
<link rel="StyleSheet" type="text/css"
	href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
<!--<script language="Javascript" src="../../eDS/js/MealPreparedServedComplaints.js"></script> -->
<script language="Javascript" src="../../eDS/js/json.js"></script>
<script language="Javascript" src="../../eDS/js/DocumentOPMealServed.js"></script>
<script language="javascript" src="../../eDS/js/DSCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name="MultipleSelectForAllPatients" id="MultipleSelectForAllPatients">
<!-- ML-MMOH-CRF-0681-->
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String sysDate ="";
	String locale=(String) session.getValue("LOCALE");
	//Added Against ML-MMOH-CRF-1061-US4 Starts Here
	String patient_class_OP="OP";
	String status_code_OP="";
	String status_desc_OP="";

	String status_code1="";
	String status_code2="";
	String status_code3="";
	String status_desc1="";
	String status_desc2="";
	String status_desc3="";
	
	String OPstatus_Ser_YN="";
	String OPstatus_Acc_YN="";
	String OPstatus_Rej_YN="";	
	String STATUS_ACT_YN_OP="";
	String sql_Query="";
	//Added Against ML-MMOH-CRF-1061-US4 Ends Here
	boolean isMealComplaints =false; //Added Against ML-MMOH-CRF-1125
	try{
		conn = ConnectionManager.getConnection(request);
		isMealComplaints = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_COMPLAINTS"); //Added Against ML-MMOH-CRF-1125
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'DD/MM/YYYY HH24:MI') CURRENT_DATE FROM DUAL");

		rst = pstmt.executeQuery();
		while(rst.next()){
			sysDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMYHM","en",locale);
		}

		//Added Against ML-MMOH-CRF-1061-US4 Starts Here
			sql_Query= "SELECT status_code , status_desc ,STATUS_ACT_YN FROM DS_MEAL_ACK_STATUS_MAST WHERE disp_sl_no <= 3 AND patient_class ='"+patient_class_OP+"' AND STATUS_ACT_YN ='Y' ORDER BY patient_class, disp_sl_no DESC";
			pstmt=conn.prepareStatement(sql_Query);
			rst=pstmt.executeQuery();
			while (rst.next()){		
			status_code_OP = rst.getString(1);
			status_desc_OP = rst.getString(2);
			STATUS_ACT_YN_OP = rst.getString(3);
				if((status_code_OP.equals("MS"))){
					status_code1 = rst.getString(1);
					status_desc1 = rst.getString(2);
					OPstatus_Ser_YN	= rst.getString(3);
				}else if((status_code_OP.equals("MA"))){
					status_code2 = rst.getString(1);
					status_desc2 = rst.getString(2);
					OPstatus_Acc_YN = rst.getString(3);
				}else if((status_code_OP.equals("MR"))){
					status_code3 = rst.getString(1);
					status_desc3 = rst.getString(2);
					OPstatus_Rej_YN = rst.getString(3);
				}
			}
			//Added Against ML-MMOH-CRF-1061-US4 Ends Here
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();		
%>
<!-- ML-MMOH-CRF-0681-->
	<input type="hidden" name="from" id="from" value="<%=request.getParameter("from")%>">
	<input type="hidden" name="to" id="to" value="<%=request.getParameter( "to" )%>">
	<!-- Added Against ML-MMOH-CRF-1061-US4 Starts Here -->	
	<input type="hidden" name="OPstatus_Ser_YN" id="OPstatus_Ser_YN" id="OPstatus_Ser_YN" value="<%=OPstatus_Ser_YN%>"/>
	<input type="hidden" name="OPstatus_Acc_YN" id="OPstatus_Acc_YN" id="OPstatus_Acc_YN" value="<%=OPstatus_Acc_YN%>"/>
	<input type="hidden" name="OPstatus_Rej_YN" id="OPstatus_Rej_YN" id="OPstatus_Rej_YN" value="<%=OPstatus_Rej_YN%>"/>	
	<!-- Added Against ML-MMOH-CRF-1061-US4 Ends Here -->
	<input type="hidden" name="locale" id="locale" value="<%=locale%>"/> <!-- Added Against 683 CRF-->
	<input type="hidden" name="isMealComplaints" id="isMealComplaints" id ="isMealComplaints" value="<%=isMealComplaints%>"> <!-- Added Against ML-MMOH-CRF-1125-->
	<div id="tableResult" style="display:none">
	<table width="100%" border="0">
			<tr align="left">
				<td width=20% align="right" class="label"><fmt:message
						key="eOT.statusDateTimeforAllPatients.Label"
						bundle="${ot_labels}" /></td>
				<!-- <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> -->

				<td width=50% >
					<select name="setStatus" id="setStatus" onchange="setStatusForAll();">
						<option value=''>
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
				<!-- Modified Against ML-MMOH-CRF-1061-US4 Starts Here -->
					<%if(OPstatus_Ser_YN.equals("Y")){%>
						<option value='MS'>
							<%=status_desc1%>							
						</option>
					<%}%>
					<%if(OPstatus_Acc_YN.equals("Y")){%>
						<option value='MA'>
							<%=status_desc2%>
						</option>
					<%}%>
					<%if(OPstatus_Rej_YN.equals("Y")){%>
						<option value='MR'>
							<%=status_desc3%>
						</option>
					<%}%>
				<!-- Modified Against ML-MMOH-CRF-1061-US4 Starts Here -->
					</select>
					<input type="text" name="setDate" id="setDate" onchange="setDateForAll();" size="16" maxlength="16" value ="<%=sysDate%>">
					<img src='../../eCommon/images/CommonCalendar.gif' onclick="showCalendar('setDate','DD/MM/YYYY','hh:mm');setDateForAll();"/>
				</td>
				<td width=20%>&nbsp;</td>
			</tr>
	</table>
	
	<table align='right'>
	<tr nowrap>
	<%
	String from = request.getParameter("from");
	String to = request.getParameter( "to" );

	int start = (from.equals(""))?0:Integer.parseInt(from);
	int end = (to.equals(""))?13:Integer.parseInt(to);
	if ( !(start <= 0) ) {%>
	<td>
	<A HREF="../../eDS/jsp/DocumentMealServedOPRecord.jsp?from=<%=(start-13)%>&to=<%=(end-13)%>" text-decoration='none'><fmt:message key="Common.previous.label" bundle='${common_labels}' /></A>
	</td>
	<%}%>
	<td id="hrefNextMealOrder">
	<A HREF="../../eDS/jsp/DocumentMealServedOPRecord.jsp?from=<%=(start+13)%>&to=<%=(end+13)%>" text-decoration='none'><fmt:message key="Common.next.label" bundle='${common_labels}' /></A>
	</td>
	</tr>
	</table>
	<br><br>
		<table border='1' cellspacing='0' width='100%' align='center' id="mealSelectedTable">
			<tr>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.patientId.label" bundle="${common_labels}" />
				</th>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.PatientName.label" bundle="${common_labels}" />
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.ApptDate/Time.label" bundle="${common_labels}" />
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eDS.VisitDateTime.label" bundle="${ds_labels}" />
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.apptno.label" bundle="${common_labels}" />
				</TH>		
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.encounterid.label" bundle="${common_labels}" />
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.status.label" bundle="${common_labels}" />
				</TH> 
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.datetime.label" bundle="${common_labels}"/>
				</TH>
				<!-- Added Against Start 683 CRF-->
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eOT.Complaints.Label" bundle="${ot_labels}" />
				</TH>
				<!-- Added Against End 683 CRF-->
				<!--Added Against Start ML-MMOH-CRF-681-->
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eDS.FoodReplacement.Label" bundle="${ds_labels}"/>
				</TH>
				<!-- Added Against End ML-MMOH-CRF-681-->
			</tr>
			<tbody id="divDocOPOrderList">
			</tbody>
			<input type=hidden name="totalRows" id="totalRows" value=""/>
		</table>
		</div>
		<script>
	loadResult();
		// Function  : This will executed on loading of this Script: - Start
	
	function loadResult()
	{
		var jsonDataObject = new Object();
		var orderList=new Array();
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		
		//jsonDataObject.facilityid 	= parent.frames[1].document.forms[0].facility_id.value;
		jsonDataObject.speciality 	= parent.frames[1].document.getElementById("speciality").value;
		jsonDataObject.locationType = parent.frames[1].document.getElementById("loctype").value;
		
		if(jsonDataObject.locationType == "Y")
			jsonDataObject.locationType = "D";
			
		if(parent.frames[1].document.getElementById("location").value == "")
			jsonDataObject.locationCode = "";
		else
			jsonDataObject.locationCode = parent.frames[1].document.getElementById("hdnlocation").value;
		
		jsonDataObject.restype 		= parent.frames[1].document.getElementById("resourceType_1").value; 
		if(parent.frames[1].document.getElementById("practitioner_name").value == "")
			jsonDataObject.resource		= "";
		else
			jsonDataObject.resource 	= parent.frames[1].document.getElementById("practitioner").value; 
		
		jsonDataObject.servingdate  = parent.frames[1].document.getElementById("servingdate").value;
		jsonDataObject.mealType		= parent.frames[1].document.getElementById("mealType").value; 

		var jsonData = JSON.stringify(jsonDataObject);

		 
		var param="jsonData="+jsonData+"&language_Id=en&mode=searchDocMealOrder";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.DocumentOPMealServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
		var jsonObjResponse=eval('(' + retVal + ')');
		//Getting Meal Record List::
		orderList = jsonObjResponse.jsonDocOPOrderList;
		var divOrderList = document.getElementById("divDocOPOrderList");
		var row_ind1 = 0;

		var from = document.getElementById("from").value;
		var to = document.getElementById("to").value;
		
		//Added Against ML-MMOH-CRF-1061-US4 Starts Here
		var OPstatus_Ser_YN = document.getElementById("OPstatus_Ser_YN").value;
		var OPstatus_Acc_YN = document.getElementById("OPstatus_Acc_YN").value;
		var OPstatus_Rej_YN = document.getElementById("OPstatus_Rej_YN").value;
		//Added Against ML-MMOH-CRF-1061-US4 Ends Here
		var isMealComplaints = document.getElementById("isMealComplaints").value;//Added Against ML-MMOH-CRF-1125
		
		var start = "";
		var end = "";
		if(from == "")
		  start = 0; 
		else
		  start = from;
		  
		if(to == "")
		  end = 13; 
		else
		  end = to;

		if(orderList!=null)
		{
			//getting maximum record
			//document.getElementById("totalRows").value = orderList.length;
			if(orderList.length == 0){
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
				document.getElementById("tableResult").style.display = "none";
				return;
			}	
			else{
				document.getElementById("tableResult").style.display = "inline";
				//for(var itr=0; itr < orderList.length;itr++){
				if(orderList.length <= end)
				{
					end = orderList.length;
					document.getElementById("hrefNextMealOrder").innerHTML="";
				}
				
				//if((from+13) == orderList.length)
				//	document.getElementById("hrefNextMealOrder").innerHTML="";
					
				for(var itr=start; parseInt(itr,10) <parseInt(end,10);itr++){
				
						var newRow3 = divOrderList.insertRow(row_ind1);
						
						var newCellDesc = fnInsertCell(newRow3);
						var selPatId = "<label>"+orderList[itr].patient_id+"</label>";
						selPatId += "<input type=hidden  name=\'patId"+ row_ind1+"\' id=\'patId"+ row_ind1+"\' value=\'"+orderList[itr].patient_id+"\'/>";
						newCellDesc.innerHTML = selPatId;
								
						var newCellDesc2 = fnInsertCell(newRow3);
						var selPatName = "<label>"+orderList[itr].patient_name+"</label>";
						selPatName += "<input type=hidden  name=\'patName"+ row_ind1+"\' id=\'patName"+ row_ind1+"\' value=\'"+orderList[itr].patient_name+"\'/>";
						newCellDesc2.innerHTML = selPatName;
						
						var newCellDesc2 = fnInsertCell(newRow3);
						var selApptDate = "";
						if(orderList[itr].ApptDate != null && orderList[itr].ApptDate != "undefined" && orderList[itr].ApptDate != "")
							selApptDate = "<label>"+orderList[itr].ApptDate + " " + orderList[itr].ApptTime +"</label>";
						else	
							selApptDate = "<label>&nbsp;</label>";
						selApptDate += "<input type=hidden  name=\'apptDate"+ row_ind1+"\' id=\'apptDate"+ row_ind1+"\' value=\'"+orderList[itr].ApptDate + " " + orderList[itr].ApptTime +"\'/>";
						newCellDesc2.innerHTML = selApptDate;
						
						var newCellDesc2 = fnInsertCell(newRow3);
						var selVisitDate = "";
						if(orderList[itr].VisitDate != null && orderList[itr].VisitDate != "undefined" && orderList[itr].VisitDate != "")
							selVisitDate = "<label>"+orderList[itr].VisitDate+"</label>";
						else	
							selVisitDate = "<label>&nbsp;</label>";
							
						selVisitDate += "<input type=hidden  name=\'visitDate"+ row_ind1+"\' id=\'visitDate"+ row_ind1+"\' value=\'"+orderList[itr].VisitDate+"\'/>";
						newCellDesc2.innerHTML = selVisitDate;
							
						var newCellDesc2 = fnInsertCell(newRow3);
						var selApptNo;
						if(orderList[itr].ApptNo == null)
						{
							selApptNo = "<label>&nbsp;</label>";
							selApptNo += "<input type=hidden  name=\'apptNo"+ row_ind1+"\' id=\'apptNo"+ row_ind1+"\' value=\''/>";
						}
						else
						{
							selApptNo = "<label>"+orderList[itr].ApptNo+"</label>";
							selApptNo += "<input type=hidden  name=\'apptNo"+ row_ind1+"\' id=\'apptNo"+ row_ind1+"\' value=\'"+orderList[itr].ApptNo+"\'/>";
						}
						newCellDesc2.innerHTML = selApptNo;
						
						var newCellDesc2 = fnInsertCell(newRow3);
						var selEnctId;
						if(orderList[itr].Encounterid == null)
						{						
							selEnctId = "<label>&nbsp;</label>";
							selEnctId += "<input type=hidden  name=\'encounterid"+ row_ind1+"\' id=\'encounterid"+ row_ind1+"\' value=\''/>";
						}else
						{
							selEnctId = "<label>"+orderList[itr].Encounterid+"</label>";
							selEnctId += "<input type=hidden  name=\'encounterid"+ row_ind1+"\' id=\'encounterid"+ row_ind1+"\' value=\'"+orderList[itr].Encounterid+"\'/>";
						}
						newCellDesc2.innerHTML = selEnctId;
						
						//Status:
						var newCellDesc2 = fnInsertCell(newRow3);
						var selObj = "<SELECT name='status"+row_ind1+"' id='status"+row_ind1+"' onchange=\"chkStatus(this,'"+row_ind1+"');\">";
						var label="Select";
						selObj += "<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}" /></option>";
						
				//Modified Against ML-MMOH-CRF-1061-US4 Starts Here 
					if(OPstatus_Ser_YN=='Y'){
						if(orderList[itr].status == 'MS')
							selObj += "<option value='MS' selected><%=status_desc1%></option>";
						else
							selObj += "<option value='MS'><%=status_desc1%></option>";
					}	
					if(OPstatus_Acc_YN=='Y'){					
						if(orderList[itr].status == 'MA')
							selObj += "<option value='MA' selected><%=status_desc2%></option>";
						else
							selObj += "<option value='MA'><%=status_desc2%></option>";
					}
					if(OPstatus_Rej_YN=='Y'){
						if(orderList[itr].status == 'MR')
							selObj += "<option value='MR' selected><%=status_desc3%></option>";						
						else
							selObj += "<option value='MR'><%=status_desc3%></option>";
					}
				//Modified Against ML-MMOH-CRF-1061-US4 Ends Here
						
						if(orderList[itr].status != null)
							selObj += "<input type=hidden  name=\'hdnstatus"+ row_ind1+"\' id=\'hdnstatus"+ row_ind1+"\' value=\'"+orderList[itr].status+"\'/>";
						else
							selObj += "<input type=hidden  name=\'hdnstatus"+ row_ind1+"\' id=\'hdnstatus"+ row_ind1+"\' value=\''/>";						
						newCellDesc2.innerHTML = selObj;
						
						// Acknowledgement Date::
						var newCellDesc2 = newRow3.insertCell(newRow3.cells.length);

						var sAckDate = orderList[itr].AckDate;
						//ML-MMOH-CRF-681
						var sCurDate = orderList[itr].sys_date;						
						
						if(sAckDate == null || sAckDate == "undefined" || sAckDate == "")
							sCurDate = orderList[itr].sys_date;						
						else						
							sCurDate = orderList[itr].AckDate;
						
						var selAckDate = "<input type=\"text\" name=\'ackDate"+row_ind1+"\' id=\'ackDate"+row_ind1+"\' value=\'"+ sCurDate + "\'  onblur=\"if(trim(this.value)!='')isValidDateTime_AllPatients(this);\" >";
						selAckDate += "<img src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('ackDate"+row_ind1+"\','DD/MM/YYYY','hh:mm');\" >"; 
						selAckDate += "<input type=hidden  name=\'hdnackDate"+ row_ind1+"\' id=\'hdnackDate"+ row_ind1+"\' value=\'"+sCurDate+"\'/>";
						//ML-MMOH-CRF-681
						newCellDesc2.innerHTML = selAckDate;
						newCellDesc.align = "center";
						
						//for compliants Added Against Start ML-MMOH-CRF-0683 [IN062278]
				//Modified Against ML-MMOH-CRF-1125 Starts Here
				if(isMealComplaints=="true"){
					if(orderList[itr].othersComp_desc!="" && orderList[itr].status=='MR'){
						var newCellDesc2 = fnInsertCell(newRow3);
						var row_ind2 =row_ind1+0;
						var selComplaint = "<input type=\"text\"  id=\'complaintDesc"+row_ind2+"\' name=\'complaintDesc"+ row_ind2+"\' id=\'complaintDesc"+ row_ind2+"\' disabled value=\'"+orderList[itr].complaint_desc+"\' onblur=\"if(trim(this.value)!='') return complaintsLookup('complaintDesc"+row_ind2+"','"+row_ind2+"\');\" >";
						var empty="";
						
						selComplaint += "<input type=hidden  id=\'complaintCode"+row_ind2+"\' name=\'complaintCode"+ row_ind2+"\' id=\'complaintCode"+ row_ind2+"\' value=\'"+orderList[itr].complaint_code+"\'/>";
						var sym= "?";
						selComplaint += "<input type=\"button\" id=\'bt"+row_ind2+"\' disabled class=\"BUTTON\" name=\'bt"+row_ind2+"\' id=\'bt"+row_ind2+"\' value=\'"+ sym + "\'  onclick=\"if(trim(this.value)!='') return complaintsLookup('complaintDesc"+row_ind2+"','"+row_ind2+"\');\" else \'complaintCode"+row_ind2+"\' value=\'"+empty+"\'>";
					}else{
						var newCellDesc2 = fnInsertCell(newRow3);
						var row_ind2 =row_ind1+0;
						var selComplaint = "<input type=\"text\"  id=\'complaintDesc"+row_ind2+"\' name=\'complaintDesc"+ row_ind2+"\' id=\'complaintDesc"+ row_ind2+"\' value=\'"+orderList[itr].complaint_desc+"\' onblur=\"if(trim(this.value)!='') return complaintsLookup('complaintDesc"+row_ind2+"','"+row_ind2+"\');\" onchange=\"enableOthers_OP('"+row_ind2+"');\" >";
						var empty="";
						
						selComplaint += "<input type=hidden  id=\'complaintCode"+row_ind2+"\' name=\'complaintCode"+ row_ind2+"\' id=\'complaintCode"+ row_ind2+"\' value=\'"+orderList[itr].complaint_code+"\'/>";
						var sym= "?";
						selComplaint += "<input type=\"button\" id=\'bt"+row_ind2+"\' class=\"BUTTON\" name=\'bt"+row_ind2+"\' id=\'bt"+row_ind2+"\' value=\'"+ sym + "\'  onclick=\"if(trim(this.value)!='') return complaintsLookup('complaintDesc"+row_ind2+"','"+row_ind2+"\');\" else \'complaintCode"+row_ind2+"\' value=\'"+empty+"\'>";
					} 
				}else{
						var newCellDesc2 = fnInsertCell(newRow3);
						var row_ind2 =row_ind1+0;
						var selComplaint = "<input type=\"text\"  id=\'complaintDesc"+row_ind2+"\' name=\'complaintDesc"+ row_ind2+"\' id=\'complaintDesc"+ row_ind2+"\' value=\'"+orderList[itr].complaint_desc+"\' onblur=\"if(trim(this.value)!='') return complaintsLookup('complaintDesc"+row_ind2+"','"+row_ind2+"\');\" >";
						var empty="";
						
						selComplaint += "<input type=hidden  id=\'complaintCode"+row_ind2+"\' name=\'complaintCode"+ row_ind2+"\' id=\'complaintCode"+ row_ind2+"\' value=\'"+orderList[itr].complaint_code+"\'/>";
						var sym= "?";
						selComplaint += "<input type=\"button\" id=\'bt"+row_ind2+"\' class=\"BUTTON\" name=\'bt"+row_ind2+"\' id=\'bt"+row_ind2+"\' value=\'"+ sym + "\'  onclick=\"if(trim(this.value)!='') return complaintsLookup('complaintDesc"+row_ind2+"','"+row_ind2+"\');\" else \'complaintCode"+row_ind2+"\' value=\'"+empty+"\'>";
				}
				//Modified Against ML-MMOH-CRF-1125 Ends Here
						
				//Newly Added Against ML-MMOH-CRF-1125 Starts Here
				var Others = "Others";
				if(isMealComplaints=="true"){
					if(orderList[itr].complaint_code!="" && orderList[itr].status == 'MR'){
							selComplaint += "<a id=\'othersLink"+row_ind2+"\' name=\'othersLink"+row_ind2+"\' id=\'othersLink"+row_ind2+"\' style=\'visibility:visible\'  disabled href='javascript:OtherComplaints("+row_ind2+");'> "+Others+" </a>";
							selComplaint +="<input type=hidden id=\'othersComp"+row_ind2+"\' name=\'othersComp"+row_ind2+"\' id=\'othersComp"+row_ind2+"\'  value=\'"+orderList[itr].othersComp_desc+"\'>";
							selComplaint += "<img src='../../eCommon/images/mandatory.gif' id=\'cmp"+row_ind2+"\'  style=\'visibility:visible\' />";
					 }else if(orderList[itr].othersComp_desc!="" && orderList[itr].status == 'MR'){
							selComplaint += "<a id=\'othersLink"+row_ind2+"\' name=\'othersLink"+row_ind2+"\' id=\'othersLink"+row_ind2+"\' style=\'visibility:visible\'  href='javascript:OtherComplaints("+row_ind2+");'> "+Others+" </a>";
							selComplaint +="<input type=hidden id=\'othersComp"+row_ind2+"\' name=\'othersComp"+row_ind2+"\' id=\'othersComp"+row_ind2+"\' value=\'"+orderList[itr].othersComp_desc+"\'>";
							selComplaint += "<img src='../../eCommon/images/mandatory.gif' id=\'cmp"+row_ind2+"\'  style=\'visibility:visible\' />";
					}else{
						selComplaint += "<a id=\'othersLink"+row_ind2+"\' name=\'othersLink"+row_ind2+"\' id=\'othersLink"+row_ind2+"\' style=\'visibility:hidden\'  href='javascript:OtherComplaints("+row_ind2+");'> "+Others+" </a>";
							selComplaint +="<input type=hidden id=\'othersComp"+row_ind2+"\' name=\'othersComp"+row_ind2+"\' id=\'othersComp"+row_ind2+"\' value=\'"+orderList[itr].othersComp_desc+"\'>";
							selComplaint += "<img src='../../eCommon/images/mandatory.gif' id=\'cmp"+row_ind2+"\'  style=\'visibility:hidden\' />";
					}
				}
				//Newly Added Against ML-MMOH-CRF-1125 Ends Here
						
						selComplaint += "<img src='../../eCommon/images/mandatory.gif' id=\'cmp"+row_ind2+"\'  style=\'visibility:hidden\' />";
						
						newCellDesc2.innerHTML = selComplaint; 
						//Added Against End ML-MMOH-CRF-0683 [IN062278]
						//Added Against Start ML-MMOH-CRF-681	
						var MealReplaceYn = orderList[itr].MealReplaceYn;
						if(MealReplaceYn == null || MealReplaceYn == "undefined" || MealReplaceYn == "&nbsp")
							MealReplaceYn = "N";
						else if(MealReplaceYn == "Y")
							MealReplaceYn = "Y";
							var newCellDesc2 = fnInsertCell(newRow3);
							var label="Select";
							var mealObj = "";
						if(orderList[itr].status == 'MR'){
							mealObj = "<SELECT id='MealReplaceYn"+row_ind1+"' name='MealReplaceYn"+row_ind1+"' id='MealReplaceYn"+row_ind1+"'>";
							if(MealReplaceYn =="N"){
							mealObj += "<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}" /></option>";
							mealObj += "<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}" /></option>";
							}else{
							mealObj += "<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}" /></option>";
							mealObj += "<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}" /></option>";
							}
							}else{
							mealObj = "<SELECT id='MealReplaceYn"+row_ind1+"' name='MealReplaceYn"+row_ind1+"' id='MealReplaceYn"+row_ind1+"' disabled>";		
							mealObj += "<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}" /></option>";
							mealObj += "<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}" /></option>";
							}
						if(orderList[itr].status != null){
							mealObj += "<input type=hidden  name=\'mealstatus"+ row_ind1+"\' id=\'mealstatus"+ row_ind1+"\' value=\'"+MealReplaceYn+"\'/>";
							}	
							else{
							mealObj += "<input type=hidden  name=\'mealstatus"+ row_ind1+"\' id=\'mealstatus"+ row_ind1+"\' value=\''"+MealReplaceYn+"'/>";  
							}
							newCellDesc2.innerHTML = mealObj;
						//Added Against End ML-MMOH-CRF-681	
						row_ind1++;
						
				}
				document.getElementById("totalRows").value = row_ind1;
			}
		}else
		{
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
		}
	}
	// Function  : This will executed on loading of this Script: - End
		</script>
	</form> 
<!-- ML-MMOH-CRF-0681-->
<%
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("489,exception============="+e);
		}finally{
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
		}
%>
<!-- ML-MMOH-CRF-0681-->
</body>
</html>

