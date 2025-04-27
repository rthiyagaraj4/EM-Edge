<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@ page import ="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.Common.*,webbeans.eCommon.ConnectionManager,eDS.DSCommonBean,eDS.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<html>
<head>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/MealOrderList.js'></script>
<script language='javascript' src='../../eDS/js/MealTickets.js'></script>
<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<!-- ML-MMOH-CRF-406 -->
<script>
/* Added Against Start AMS-CRF-0180 */
function datechange(obj){
	var isDateOption="";
	isDateOption = document.getElementById("isDateOption").value;
	if(isDateOption=="true"){
	if(obj.value=="DR"){	
		document.getElementById("servingDate1").readOnly = false;
		document.getElementById("servingDate2").readOnly = false;
		document.getElementById("imgDateFrom").style.visibility = "visible";
		document.getElementById("imgMonthFrom").style.visibility = "visible";
		document.getElementById("imgDateTo").style.visibility = "visible";
		document.getElementById("imgMonthTo").style.visibility = "visible";				
		document.getElementById("patientIdTo").style.visibility = "hidden";
		document.getElementById("searchPatTo").style.visibility = "hidden";
		document.getElementById("imgPatFrom").style.visibility = "visible";
		// Added Below Agianst[IN:069633]
		document.getElementById("mealPlanRow").style.visibility = "hidden";
		document.getElementById("SearchFor").style.visibility='hidden';
		document.getElementById("SearchForLabel").style.visibility='hidden';
	}else if(obj.value=="CD"){	
		document.getElementById("servingDate1").readOnly = true;
		document.getElementById("servingDate2").readOnly = true;	
		document.getElementById("imgDateFrom").style.visibility = "hidden";
		document.getElementById("imgMonthFrom").style.visibility = "hidden";	
		document.getElementById("imgDateTo").style.visibility = "hidden";
		document.getElementById("imgMonthTo").style.visibility = "hidden";
		document.getElementById("servingDate2").value = document.getElementById("servingDate").value;		
		document.getElementById("searchPatTo").style.visibility = "visible";
		document.getElementById("imgPatFrom").style.visibility = "hidden";
		document.getElementById("patientIdTo").style.visibility = "visible";
		// Added Below Agianst[IN:069633]
		document.getElementById("mealPlanRow").style.visibility = "visible";
		document.getElementById("SearchFor").style.visibility='visible';
		document.getElementById("SearchForLabel").style.visibility='visible';
	}
	}	
}

function enable_disable(){
	var isDateOption="";
	isDateOption = document.getElementById("isDateOption").value;
	if(isDateOption=="true"){
	if(document.forms[0].dateOption.value=="CD"){	
		document.getElementById("servingDate1").readOnly = true;
		document.getElementById("servingDate2").readOnly = true;	
		document.getElementById("imgMonthFrom").style.visibility = "hidden";
	}
	}
}
/* Added Against End AMS-CRF-0180 */

function callPatientSearch(obj){
	var pat_id =  PatientSearch();
	if(pat_id != null){
		if(obj == 'from'){			
			document.getElementById("patientIdFrom").value = pat_id;
		}else if(obj == 'to'){
			document.getElementById("patientIdTo").value = pat_id;
		}
	}
}

//Added against MMS-DM-CRF-0044
function changeRepId()
{
	var isMenuType =document.getElementById("isMenuType").value;	
	var MealTicketfor = document.getElementById("MealTicketfor").value;
	var isDateOption = document.getElementById("isDateOption").value; //Added Against AMS-CRF-0180
	if(MealTicketfor == 'Patient')
	{
		document.getElementById("report_id").value = "DSRSTDMT";
		document.getElementById("p_report_id").value = "DSRSTDMT";
		document.getElementById("mealPlanSeqNo").disabled=false;
		//ML-MMOH-CRF-409
		document.getElementById("SearchFor").style.visibility='visible';
		document.getElementById("SearchForLabel").style.visibility='visible';
		//KDAH-CRF-0352
		if(isMenuType=="true"){
			return false;
		}else{
			document.getElementById("feedTypeLabel").style.visibility='visible'
			document.getElementById("feedTypeFrom").style.visibility='visible'
			document.getElementById("feedTypeTo").style.visibility='visible'
		}
		//ML-MMOH-CRF-409 & KDAH-CRF-0352
		//Added Against Start AMS-CRF-0180
		if(isDateOption=="true"){
			document.getElementById("imgDateFrom").style.visibility = "hidden";
			document.getElementById("imgMonthFrom").style.visibility = "hidden";
			document.getElementById("toLabel").style.visibility = "visible";
			document.getElementById("servingDate2").style.visibility = "visible";				
			document.getElementById("reportRow").style.visibility = "visible";	
			document.getElementById("servingDate1").value = document.getElementById("servingDate").value;
			document.getElementById("servingDate1").readOnly = true;	
			// Added Against[IN:069633]
			if(document.getElementById("dateOption").value=="DR") {
			document.getElementById("imgPatFrom").style.visibility = "visible";	
			document.getElementById("imgDateFrom").style.visibility = "visible";
			document.getElementById("imgMonthFrom").style.visibility = "visible";
			document.getElementById("imgDateTo").style.visibility = "visible";
			document.getElementById("imgMonthTo").style.visibility = "visible";
			document.getElementById("SearchFor").style.visibility='hidden';
			document.getElementById("SearchForLabel").style.visibility='hidden';
			}else if(document.getElementById("dateOption").value=="CD") {
			document.getElementById("imgPatFrom").style.visibility = "hidden";	
			}
		}
		//Added Against End AMS-CRF-0180
	}
	else if(MealTicketfor == 'Attendant')
	{
		document.getElementById("report_id").value = "DSRSTADMT";
		document.getElementById("p_report_id").value = "DSRSTADMT";
		document.getElementById("mealPlanSeqNo").disabled=true;
		//ML-MMOH-CRF-409
		document.getElementById("SearchFor").style.visibility='hidden';
		document.getElementById("SearchForLabel").style.visibility='hidden';
		//KDAH-CRF-0352
		if(isMenuType=="true"){
			return false;
		}
		else{
			document.getElementById("feedTypeLabel").style.visibility='hidden';
			document.getElementById("feedTypeFrom").style.visibility='hidden';
			document.getElementById("feedTypeTo").style.visibility='hidden';
		}
		//ML-MMOH-CRF-409 & KDAH-CRF-0352
		//Added Against Start AMS-CRF-0180
		if(isDateOption=="true"){
			document.getElementById("imgDateFrom").style.visibility = "visible";
			document.getElementById("imgMonthFrom").style.visibility = "visible";			
			document.getElementById("toLabel").style.visibility = "hidden";
			document.getElementById("servingDate2").style.visibility = "hidden";				
			document.getElementById("reportRow").style.visibility = "hidden";	
			document.getElementById("servingDate1").readOnly = false;
			document.getElementById("imgDateTo").style.visibility = "hidden";
			document.getElementById("imgMonthTo").style.visibility = "hidden";
			// Added Against[IN:069633]
			document.getElementById("imgPatFrom").style.visibility = "hidden";
			document.getElementById("imgPatFrom").style.visibility = "hidden";			
		}
		//Added Against End AMS-CRF-0180
	}
}

/* Added against start for IN:057371 */
 function changeMealseq(obj1) {
	var formObj = document.forms[0];
	var locale = document.getElementById("locale").value;
	var servingDate =	document.getElementById("servingDate").value;
	var facility=document.getElementById("facility_id").value; 
	var obj = formObj.mealPlanSeqNo;
	 while(obj.length > 0){
		  obj.remove(0);
	 }
   	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getmealPlanSeqNo&facility="+facility+"&servingDate="+convertDate(servingDate,'DMY',locale,'en');
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
		if(retVal!=''){
		var retValArr = retVal.split("???");
		var mealPlanSeqNo = "";
		if(retValArr!=''){
		var listOption1	= document.createElement('OPTION');		
		var msg = "----select----";
		listOption1.text = msg;
		listOption1.value= "";
		obj.add(listOption1);
		for(var i=0; i<retValArr.length; i++){
			mealPlanSeqNo = retValArr[i].split(":::");
			var listOption1	= document.createElement('option');
			var msg = "----select----";
			listOption1.text = msg;
			listOption1.value= "";
			
			listOption1.value = mealPlanSeqNo[1];
			listOption1.text = mealPlanSeqNo[0];			
			obj.add(listOption1);				
			}				
			}		
		}
}
/* Added against End for IN:057371  */

//Added against MMS-DM-CRF-0044
function loadBedNumber() {	
	var wardFrom=document.getElementById("nursingUnitFrom").value;
	var wardTo=document.getElementById("nursingUnitTo").value;
	var facility=document.getElementById("facility_id").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getBedNumbers&facility="+facility+"&wardCodeFrom="+wardFrom+"&wardCodeTo="+wardTo;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var bedNumberFrom = document.getElementById("bedNumberFrom");
	var bedNumberTo = document.getElementById("bedNumberTo");
	
	if(wardFrom !='' || wardTo !='') {
		document.getElementById("bedNumberFrom").disabled=false;
		document.getElementById("bedNumberTo").disabled=false;
	}
	else{//56658	
		document.getElementById("bedNumberFrom").disabled=true;
		document.getElementById("bedNumberTo").disabled=true;
	}
		
	while(bedNumberFrom.length > 0){
		bedNumberFrom.remove(0);
	}
	
	while(bedNumberTo.length > 0){
		bedNumberTo.remove(0);
	}	
	var listOption1	= document.createElement('option');
	var listOption2	= document.createElement('option');
	
	listOption1.text ="-----select-----";
	listOption1.value ="";
	bedNumberFrom.add(listOption1);
	
	listOption2.text ="-----select-----";
	listOption2.value ="";
	bedNumberTo.add(listOption2);	
	
	if(retVal != null && retVal != ""){
		var retValArr = retVal.split("???");
		if(retValArr!=''){
			for(var i=0; i<retValArr.length; i++){
				var bedNumber = retValArr[i];
				var listOption1	= document.createElement('option');
				var listOption2	= document.createElement('option');
				
					listOption1.value = bedNumber;
					listOption1.text = bedNumber;
					
					listOption2.value = bedNumber;
					listOption2.text = bedNumber;					
					
					bedNumberFrom.add(listOption1);
					bedNumberTo.add(listOption2);
			}
		}
	}	
	
}
</script>

</head>

<body onload="changeMealseq(this);enable_disable()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	boolean isDateOption = false; //Added Against AMS-CRF-0180
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	boolean isMenuType =false;//KDAH-CRF-0352
	String facility_id  = (String) session.getValue("facility_id");
	HashMap<String,String> feedMap = DSCommonBeanObj.getFeedType(locale);//KDAH-CRF-0352
	String sql="";
	String strCode ="";
	String strDesc ="";
	String servingDate="";
	String patient_id_length="";
	//MMS-DM-CRF-0044
	String sql_cust_id="select customer_id from SM_SITE_PARAM where rownum = 1";
	String customer_id="";
	PreparedStatement pstmt1=null;
	ResultSet rst1=null;	
							 
	//MMS-DM-CRF-0044
try{
	conn = ConnectionManager.getConnection(request);
	
	//Added by Santhosh for ML-MMOH-SCF-2331 
	boolean isSpecialDiet = false;
	isSpecialDiet = CommonBean.isSiteSpecific(conn,"DS","SPECIAL_DIET_CATEGORY");
	
	//MMS-DM-CRF-0044
	//KDAH-CRF-0352	
    	isMenuType = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");
	//KDAH-CRF-0352
	isDateOption = CommonBean.isSiteSpecific(conn,"DS","PLACE_DIET_ORDER_INSTR"); //Added against Ams-CRf-0180
	pstmt1=conn.prepareStatement(sql_cust_id);
	rst1=pstmt1.executeQuery();
	if(rst1 !=null && rst1.next())
	{
		customer_id=checkForNull(rst1.getString("customer_id"));
	}	
	if(rst1!=null)rst1.close();
	if(pstmt1!=null)pstmt1.close();
	//MMS-DM-CRF-0044

	pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

	rst = pstmt.executeQuery();
	while(rst.next()){
		servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
	}
	if(rst!=null)rst.close();
	if(pstmt!=null)pstmt.close();
%>
<form name="MealStatisticsReport" id="MealStatisticsReport" method="post"  target="messageFrame">
	<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
	<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>	
	<tr>
		<td class="label">
			<fmt:message key="eOT.MealTicketfor.Label" bundle="${ot_labels}"/>	
		</td>	
		<td class='label'>
			<select name="MealTicketfor" id="MealTicketfor" id="MealTicketfor" onchange="changeRepId();">		
				<option value="Patient"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
				<option value="Attendant"><%=DSCommonBeanObj.getAttendantLabel()%></option><!--ML-MMOH-CRF-406-->	
			</select>
		</td>
	</tr>
		<!-- Added Against Start AMS-CRF-0180 -->
		<% if(isDateOption){%>
		<tr id="reportRow">	
			<td class="label">				
				<fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.duration.label" bundle="${common_labels}"/>	
			</td>
			<td class='label'>
			<select name="dateOption" id="dateOption" id="dateOption" onchange="datechange(this)">		
				<option value="CD"><fmt:message key="Common.CurrentDate.label" bundle="${common_labels}"/></option>
				<option value="DR"><fmt:message key="Common.DateRange.label" bundle="${common_labels}"/></option>
			</select>
		</td>
	</tr>				
	<tr>
		<td class="label"> </td>
		<td class="label">
			<fmt:message key="Common.from.label" bundle="${common_labels}"/>
		</td>
		<td class="label" id="toLabel">
			<fmt:message key="Common.to.label" bundle="${common_labels}"/>
		</td>
	</tr>
	<tr>
		<td class="label">
			<fmt:message key="Common.date.label" bundle="${common_labels}"/>
		</td>
		<td class="label">
			<input type="text" name="servingDate1" id="servingDate1" id="servingDate1" maxlength="10" size="10" value="<%=servingDate%>" onBlur='dateDisable(this);isValidDate(this);changeMealseq(this)' onkeypress="return checkForSpecCharsforID(event);changeMealseq(this)">			
			<img src="../../eCommon/images/CommonCalendar.gif"  id='imgMonthFrom' onClick="return showCalendar('servingDate1'); style='visibility:hidden'" >
			<img src='../../eCommon/images/mandatory.gif' id="imgDateFrom" style='visibility:hidden'/>
		</td>
		<td class="label">
			<input type="text" name="servingDate2" id="servingDate2" id="servingDate2" maxlength="10" size="10" value="<%=servingDate%>" onBlur='dateDisable(this);' onkeypress="return checkForSpecCharsforID(event);changeMealseq(this)">
			<img src="../../eCommon/images/CommonCalendar.gif"  id='imgMonthTo' onClick="return showCalendar('servingDate2');" style='visibility:hidden'>
			<img src='../../eCommon/images/mandatory.gif' id="imgDateTo" style='visibility:hidden'/>
		</td>
		<input type="hidden" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>">			
	</tr>
	<tr>
		<td class="label">
			<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
		</td>
		<td class='label'>
			<select name="kitchenFrom" id="kitchenFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
			<%
				try
				{
					sql ="select  KITCHEN_CODE,SHORT_DESC  from DS_KITCHENS_LANG_VW  where language_id ='"+locale+"' and operating_facility_id ='"+facility_id+"'";

					pstmt=conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
					while(rst.next()){
					strCode = rst.getString(1);
					strDesc =  rst.getString(2);
			%>
			<option value="<%=strCode%>"><%=strDesc%></option>
					<%} %>
			</select>
			<img src='../../eCommon/images/mandatory.gif' />
		</td>
		<td class='label'>
				<select name="kitchenTo" id="kitchenTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
			<%
					pstmt=conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
					while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2); 
			%>
				<option value="<%=strCode%>"><%=strDesc%></option>
			<%} %>
				</select>
					<img src='../../eCommon/images/mandatory.gif' />
			</td>
			<%    }catch(Exception DCat){
					  System.out.println("GenerateMeal Plan Kitchen"+DCat);
				  }finally{
					   if(rst != null) rst.close();
					   if(pstmt != null) pstmt.close();
				   }
			%>
		</tr>
		<tr>
				<td class="label">
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
				<%
					try
					{
						sql ="select patient_id_length from MP_PARAM where MODULE_ID='MP'";
						pstmt = conn.prepareStatement(sql);

						rst = pstmt.executeQuery();
						while(rst.next()){
							patient_id_length = rst.getString("patient_id_length");
						}
						if(rst!=null)rst.close();
						if(pstmt!=null)pstmt.close();				
					}catch(Exception e){
					e.printStackTrace();
					}finally{
					  if(rst !=null) rst.close();
					  if(pstmt !=null) pstmt.close();
					} 
				%>					
			<td class='label'>
				<input type="text"  name="patientIdFrom" id="patientIdFrom" size="12" maxlength="<%=patient_id_length%>" value="" onKeypress='return CheckForSpecChars(event);' onBlur="makeValidString(this);ChangeUpperCase(this);">
				<input type='button' class='button' name="searchPatFrom" id="searchPatFrom" value='?' class=button onClick="callPatientSearch('from')">
				<img src='../../eCommon/images/mandatory.gif' id="imgPatFrom" style='visibility:hidden'/>
			</td>
			<td class='label'>
				<input type="text"  name="patientIdTo" id="patientIdTo" size="12" maxlength="<%=patient_id_length%>" value="" onKeypress='return CheckForSpecChars(event);' onBlur="makeValidString(this);ChangeUpperCase(this);">
				<input type='button' class='button' name="searchPatTo" id="searchPatTo" id="searchPatTo" value='?' class=button onClick="callPatientSearch('to')">
			</td>
		</tr>  	
		<tr>
			<td class='label'> <fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/> </td>
			<td class='label'>
					<select name="mealTypeFrom" id="mealTypeFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

				<%
					try
					{
						sql ="select MEAL_TYPE,SHORT_DESC From  DS_MEAL_TYPE_LANG_VW where language_id ='"+locale+"' order by meal_order";

						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>

						<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
					</select>
			</td>
			<td class='label'>
				<select name="mealTypeTo" id="mealTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
							while(rst.next()){
								strCode = rst.getString(1);
								strDesc =  rst.getString(2); %>
				<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
				</select>
			</td>
				<%  }catch(Exception mt){
					  mt.printStackTrace();
					}finally{
						if(rst !=null) rst.close();
						if(pstmt !=null) pstmt.close();
					}
				%>
		</tr>
		<tr>
			<td class="label">
				<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}"/>
			</td>
			<td class='label'>
					<select name="nursingUnitFrom" id="nursingUnitFrom" onchange="loadBedNumber()"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{
						sql ="SELECT NURSING_UNIT_CODE ,SHORT_DESC  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'";

							pstmt=conn.prepareStatement(sql);
							rst = pstmt.executeQuery();
							while(rst.next()){
							strCode = rst.getString(1);
							strDesc =  rst.getString(2);
				%>

					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
					</select>
			</td>
				<% 	}catch(Exception wc){
						  wc.printStackTrace();
					}finally{
						   if(rst !=null) rst.close();
							if(pstmt !=null) pstmt.close();
					}
				%>

			<td class='label'>
				<select name="nursingUnitTo" id="nursingUnitTo" onchange="loadBedNumber()"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					pstmt=conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
						while(rst.next()){
							strCode = rst.getString(1);
							strDesc =  rst.getString(2); 
				%>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td class="label">
				<fmt:message key="eDS.BedNumber.Label" bundle="${ds_labels}"/>
 			</td>
			<td class='label'>
				<select name="bedNumberFrom" id="bedNumberFrom" disabled>
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				</select>
			</td>

			<td class='label'>
				<select name="bedNumberTo" id="bedNumberTo" disabled>
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				</select>
			</td>
		</tr>
		<%if(!isMenuType) { %> 
		<!-- KDAH-CRF-0352 Starts -->
		<tr>
			<td class="label" id="feedTypeLabel" name="feedTypeLabel" style="hidden">
				<fmt:message key="eDS.FeedType.Label" bundle="${ds_labels}"/>
			</td>
			<td class='label'>
				<select name="feedTypeFrom" id="feedTypeFrom">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{								
						for (String keymap : feedMap.keySet()) {					
				%>
					<option value="<%=keymap%>"><%=feedMap.get(keymap)%></option>
				<%}%>
					</select>
			</td>
			<td class='label'>
				<select name="feedTypeTo" id="feedTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
						for (String keymap : feedMap.keySet()) {
				%>
					<option value="<%=keymap%>"><%=feedMap.get(keymap)%></option>
				<%}%>
				</select>
			</td>
				<% }catch(Exception ft){
						  ft.printStackTrace();
				   }finally{
						if(rst !=null) rst.close();
						if(pstmt !=null) pstmt.close();
				   }
				%>
		</tr>
		<!-- KDAH-CRF-0352 Ends -->
		<%}%>	
		<tr>
			<td class="label">
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
			</td>
			<td class='label'>
				<select name="dietTypeFrom" id="dietTypeFrom">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{
						sql ="SELECT DIET_TYPE,SHORT_DESC from  DS_DIET_TYPE_LANG_VW  WHERE  LANGUAGE_ID ='"+locale+"' AND EFF_STATUS='E'" ;

						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
					</select>
			</td>
			<td class='label'>
				<select name="dietTypeTo" id="dietTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
							strCode = rst.getString(1);
							strDesc =  rst.getString(2); 
				%>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%}%>
				</select>
			</td>
				<% }catch(Exception dt){
					  dt.printStackTrace();
				   }finally{
					   if(rst !=null) rst.close();
					   if(pstmt !=null) pstmt.close();
				   }
				%>
		</tr>
		<tr>
			<td class="label">
				<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
			</td>
			<td class='label'>
				<select name="mealClassFrom" id="mealClassFrom">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

				<%
					try
					{
						sql = "SELECT MEAL_CLASS, SHORT_DESC  FROM DS_MEAL_CLASS_LANG_VW where  language_id ='"+locale+"' and EFF_STATUS='E'" ;

						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
				</select>
			</td>
			<td class='label'>
				<select name="mealClassTo" id="mealClassTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					pstmt=conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
						while(rst.next()){
							strCode = rst.getString(1);
							strDesc =  rst.getString(2); %>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
				</select>
			</td>
				<%	}catch(Exception mc){
						mc.printStackTrace();
					}finally{
						   if(rst !=null) rst.close();
						   if(pstmt !=null) pstmt.close();
					}					
				%>
			</tr>
			<!-- Added Against End AMS-CRF-0180 -->
	  <%}else{%>
	<tr>
		<td class="label">			
			<fmt:message key="Common.date.label" bundle="${common_labels}"/>			
		</td>
		<td class="label">					
			<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);changeMealseq(this)" onblur='isValidDate(this);changeMealseq(this)'>
			<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
			<img src='../../eCommon/images/mandatory.gif' />						
		</td>		
	</tr>

	<tr>
		<td>
		</td>
		<td class="label">
			<fmt:message key="Common.from.label" bundle="${common_labels}"/>
		</td>
		<td class="label">
			<fmt:message key="Common.to.label" bundle="${common_labels}"/>
		</td>
	</tr>

	<tr>
		<td class="label">
			<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
		</td>
		<td class='label'>
			<select name="kitchenFrom" id="kitchenFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
			<%
				try
				{
					sql ="select  KITCHEN_CODE,SHORT_DESC  from DS_KITCHENS_LANG_VW  where language_id ='"+locale+"' and operating_facility_id ='"+facility_id+"'";

					pstmt=conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
					while(rst.next()){
					strCode = rst.getString(1);
					strDesc =  rst.getString(2);
			%>
			<option value="<%=strCode%>"><%=strDesc%></option>
			<%} %>
			</select>
			<img src='../../eCommon/images/mandatory.gif' />
		</td>
		<td class='label'>
				<select name="kitchenTo" id="kitchenTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
			<%
					pstmt=conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
					while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2); 
			%>
				<option value="<%=strCode%>"><%=strDesc%></option>
			<%} %>
				</select>
					<img src='../../eCommon/images/mandatory.gif' />
			</td>
			<%    }catch(Exception DCat){
					  System.out.println("GenerateMeal Plan Kitchen"+DCat);
				  }finally{
					   if(rst != null) rst.close();
					   if(pstmt != null) pstmt.close();
				   }
			%>
		</tr>
		<%
			if(customer_id.equalsIgnoreCase("WCH")) {
		%>
		
		<!-- CRF 782 Start-->
		<tr>
			<td align='right' class='label'>
				<fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}"/>
			</td>
			<td>
				<select name="dietCategory" id="dietCategory">
				<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try{
							conn = ConnectionManager.getConnection(request);
							String dietCategoryCode = "";
							String description =  "";
							String sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,'"+locale+"', 1) description from Ds_Diet_Category";
							pstmt = conn.prepareStatement(sql_diet_Category);
							rst	= pstmt.executeQuery();
							while(rst != null && rst.next()){
							dietCategoryCode=rst.getString(1);
							description=rst.getString(2);
				
							if(isSpecialDiet){//Added by Santhosh for ML-MMOH-SCF-2331
								if(!dietCategoryCode.equals("SD01")){%>
									<option value="<%=dietCategoryCode%>"><%=description%></option>
								<%}
							} else{ %>
									<option value="<%=dietCategoryCode%>"><%=description%></option>
							<%}
							} %>
				</select>
				</td>
				<%	}catch(Exception e){
						e.printStackTrace();
					}finally{
						 if(rst != null) rst.close();
						 if(pstmt != null) pstmt.close();
					}
				%>				
		</tr>
		<%}%>

		<!-- CRF 782 End-->
		<tr>
			<td align="left" class='label'>
				<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
			</td>
			<td class='label'>
					<select name="mealTypeFrom" id="mealTypeFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

				<%
					try
					{
						sql ="select MEAL_TYPE,SHORT_DESC From  DS_MEAL_TYPE_LANG_VW where language_id ='"+locale+"' order by meal_order";

						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>

						<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
					</select>
			</td>
			<td class='label'>
				<select name="mealTypeTo" id="mealTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
							while(rst.next()){
								strCode = rst.getString(1);
								strDesc =  rst.getString(2); %>
				<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
				</select>
			</td>
				<%  }catch(Exception mt){
					  mt.printStackTrace();
					}finally{
						if(rst !=null) rst.close();
						if(pstmt !=null) pstmt.close();
					}
				%>
		</tr>

		<tr>
			<td class="label">
				<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}"/>
			</td>
			<td class='label'>
					<select name="nursingUnitFrom" id="nursingUnitFrom" onchange="loadBedNumber()"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{
						sql ="SELECT NURSING_UNIT_CODE ,SHORT_DESC  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'";

							pstmt=conn.prepareStatement(sql);
							rst = pstmt.executeQuery();
							while(rst.next()){
							strCode = rst.getString(1);
							strDesc =  rst.getString(2);
				%>

					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
					</select>
			</td>
				<% 	}catch(Exception wc){
						  wc.printStackTrace();
					}finally{
						   if(rst !=null) rst.close();
							if(pstmt !=null) pstmt.close();
					}
				%>

			<td class='label'>
				<select name="nursingUnitTo" id="nursingUnitTo" onchange="loadBedNumber()"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					pstmt=conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
						while(rst.next()){
							strCode = rst.getString(1);
							strDesc =  rst.getString(2); 
				%>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
				</select>
			</td>
		</tr>
		
		<tr>
			<td class="label">
				<fmt:message key="eDS.BedNumber.Label" bundle="${ds_labels}"/>
 			</td>
			<td class='label'>
				<select name="bedNumberFrom" id="bedNumberFrom" disabled>
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				</select>
			</td>

			<td class='label'>
				<select name="bedNumberTo" id="bedNumberTo" disabled>
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				</select>
			</td>
		</tr>
	<%if(!isMenuType) { %> 
		<!-- KDAH-CRF-0352 Starts -->
		<tr>
			<td class="label" id="feedTypeLabel" name="feedTypeLabel" style="hidden">
				<fmt:message key="eDS.FeedType.Label" bundle="${ds_labels}"/>
			</td>
			<td class='label'>
				<select name="feedTypeFrom" id="feedTypeFrom">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{								
						for (String keymap : feedMap.keySet()) {					
				%>
					<option value="<%=keymap%>"><%=feedMap.get(keymap)%></option>
				<%}%>
					</select>
			</td>
			<td class='label'>
				<select name="feedTypeTo" id="feedTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
						for (String keymap : feedMap.keySet()) {
				%>
					<option value="<%=keymap%>"><%=feedMap.get(keymap)%></option>
				<%}%>
				</select>
			</td>
				<% }catch(Exception ft){
						  ft.printStackTrace();
				   }finally{
						if(rst !=null) rst.close();
						if(pstmt !=null) pstmt.close();
				   }
				%>
		</tr>
		<!-- KDAH-CRF-0352 Ends -->
		<%}%>		
		<tr>
			<td class="label">
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
			</td>
			<td class='label'>
				<select name="dietTypeFrom" id="dietTypeFrom">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{
						sql ="SELECT DIET_TYPE,SHORT_DESC from  DS_DIET_TYPE_LANG_VW  WHERE  LANGUAGE_ID ='"+locale+"' AND EFF_STATUS='E'" ;

						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
					</select>
			</td>
			<td class='label'>
				<select name="dietTypeTo" id="dietTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
							strCode = rst.getString(1);
							strDesc =  rst.getString(2); 
				%>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%}%>
				</select>
			</td>
				<% }catch(Exception dt){
					  dt.printStackTrace();
				   }finally{
					   if(rst !=null) rst.close();
					   if(pstmt !=null) pstmt.close();
				   }
				%>
		</tr>

		<tr>
			<td class="label">
				<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
			</td>
			<td class='label'>
				<select name="mealClassFrom" id="mealClassFrom">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

				<%
					try
					{
						sql = "SELECT MEAL_CLASS, SHORT_DESC  FROM DS_MEAL_CLASS_LANG_VW where  language_id ='"+locale+"' and EFF_STATUS='E'" ;

						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
				</select>
			</td>
			<td class='label'>
				<select name="mealClassTo" id="mealClassTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					pstmt=conn.prepareStatement(sql);
					rst = pstmt.executeQuery();
						while(rst.next()){
							strCode = rst.getString(1);
							strDesc =  rst.getString(2); %>
					<option value="<%=strCode%>"><%=strDesc%></option>
				<%} %>
				</select>
			</td>
				<%	}catch(Exception mc){
						mc.printStackTrace();
					}finally{
						   if(rst !=null) rst.close();
						   if(pstmt !=null) pstmt.close();
					}					
				%>
			</tr>

			<tr>
				<td class="label">
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
				<%
					try
					{
						sql ="select patient_id_length from MP_PARAM where MODULE_ID='MP'";
						pstmt = conn.prepareStatement(sql);

						rst = pstmt.executeQuery();
						while(rst.next()){
							patient_id_length = rst.getString("patient_id_length");
						}
						if(rst!=null)rst.close();
						if(pstmt!=null)pstmt.close();				
					}catch(Exception e){
					e.printStackTrace();
					}finally{
					  if(rst !=null) rst.close();
					  if(pstmt !=null) pstmt.close();
					} 
				%>		
				<td class="label">
					<input type="text" name="patientIdFrom" id="patientIdFrom" value=""  maxlength="<%=patient_id_length%>" onkeypress="return CheckForSpecChars(event)">					
				</td>
				<td class="label">
					<input type="text" name="patientIdTo" id="patientIdTo" value=""  maxlength="<%=patient_id_length%>" onkeypress="return CheckForSpecChars(event)">					
				</td>
			</tr>  
			<%}%> 
			
			<!-- Added Against End AMS-CRF-0180 -->
			
			<tr id ="mealPlanRow">
				<td class="label">
					<fmt:message key="eOT.MealplanSeqno.Label" bundle="${ot_labels}"/>
				</td>
				<td class="label">
					<select name="mealPlanSeqNo" id="mealPlanSeqNo" >
						<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					</select>
				</td>
				<td>
				</td>
		   </tr>
			<!-- Added against CRF-409 -->
            <tr>
				<td class="label" id="SearchForLabel" name="SearchForLabel" style="hidden">
				<fmt:message key="eDS.SearchFor.Label" bundle="${ds_labels}"/>
				</td>
				<td class='label'>
				<select name="SearchFor" id="SearchFor" id="SearchFor">
					<option value="RLO">
						<fmt:message key="eDS.RegularLateIrregularDietOrders.Label" bundle="${ds_labels}"/>
					</option>
					<option value="RO">
						<fmt:message key="eDS.RegularDietOrders.Label" bundle="${ds_labels}"/>
					</option>
					<option value="LO">
						<fmt:message key="eDS.LateIrregularDietOrders.Label" bundle="${ds_labels}"/>
					</option>
				</td>
		 </tr>
		<!-- Added against CRF-409 -->
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
	</table>
	<% }catch(Exception mc){
			mc.printStackTrace();
		}finally{
			try{
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)
			ConnectionManager.returnConnection(conn, request); //Common-ICN-0071
			}catch(Exception e){
				System.err.println("Exception in Meal Tickets CUD:"+e);
				e.printStackTrace();
			}
		}
	%>
				<input type="hidden" name="method" id="method"/>
				<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

				<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
				<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
				<input type="hidden" name="p_user" id="p_user"	value="<%=session.getValue("login_user")%>"/><!--55878-->

				<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
				<input type="hidden" name="module_id" id="module_id" value="DS">
			<%--
				<input type="hidden" name="p_report_id" id="p_report_id" value="DSRSTDMT">
				<input type="hidden" name="report_id" id="report_id" value="DSRSTDMT"/>
			--%> 
				<input type="hidden" name="report_id" id="report_id" id = "report_id" value="DSRSTDMT">
				<input type="hidden" name="p_report_id" id="p_report_id" id = "p_report_id" value="DSRSTDMT">

				<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
				<input type='hidden' name='datepattrn' id='datepattrn' value="dd/MM/yyyy">
				<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>

				<input type='hidden' name='conDate' id='conDate' >
				<input type='hidden' name='nd_serv_date' id='nd_serv_date' >
				<input type='hidden' name='p_kitchen_code_from' id='p_kitchen_code_from' >
				<input type='hidden' name='p_kitchen_code_to' id='p_kitchen_code_to' >
				<input type='hidden' name='customer_id' id='customer_id' value = '<%=customer_id%>'>
				<input type='hidden' name='p_diet_category' id='p_diet_category' > <!-- Added Against CRF 782 --> 
				<input type='hidden' name='nd_fr_meal' id='nd_fr_meal' >
				<input type='hidden' name='nd_to_meal' id='nd_to_meal' >
				<input type='hidden' name='nd_fr_ward_code' id='nd_fr_ward_code' >
				<input type='hidden' name='nd_to_ward_code' id='nd_to_ward_code' >
				<input type='hidden' name='nd_fr_diet_type' id='nd_fr_diet_type' >
				<input type='hidden' name='nd_to_diet_type' id='nd_to_diet_type' >
				<input type='hidden' name='nd_fr_meal_class' id='nd_fr_meal_class' >
				<input type='hidden' name='nd_to_meal_class' id='nd_to_meal_class' >
				<input type='hidden' name='nd_fr_pat_id' id='nd_fr_pat_id' >
				<input type='hidden' name='nd_to_pat_id' id='nd_to_pat_id' >
				<input type='hidden' name='nd_from_bed_no' id='nd_from_bed_no' >
				<input type='hidden' name='nd_to_bed_no' id='nd_to_bed_no' >
				<input type='hidden' name='P_MEAL_PLAN_SEQ_NO' id='P_MEAL_PLAN_SEQ_NO' >
				<input type='hidden' name='chkPatientId1' id='chkPatientId1' >
				<input type='hidden' name='chkPatientId2' id='chkPatientId2' >
				<input type="hidden" name="isMenuType" id="isMenuType" id="isMenuType" value="<%=isMenuType%>">
				<input type="hidden" name="isDateOption" id="isDateOption" id="isDateOption" value="<%=isDateOption%>"> <!--Added Against AMS-CRF-0180 -->				
			</form>
		</body>
</html>

