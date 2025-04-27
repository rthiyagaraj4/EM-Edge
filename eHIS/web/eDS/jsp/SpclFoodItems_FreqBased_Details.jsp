<!DOCTYPE html>

<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.util.ArrayList,java.util.ArrayList,eCommon.Common.*,java.net.URLEncoder" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	/* //Added Against MMS Vulnerability Issue - Starts
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    //Added Against MMS Vulnerability Issue - Ends  */
%>
<html>
<head>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eDS/js/MealPreparedServedComplaints.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >

<style>
		TD.OS{
		BACKGROUND-COLOR:#6666FF;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.PR{
		BACKGROUND-COLOR:#FF99FF;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.IN{
		BACKGROUND-COLOR:#CC0099;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.PO{
		BACKGROUND-COLOR:#FFCC33;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.FN{
		BACKGROUND-COLOR:#990099;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

	</style>
 <%
 	String facility_id=(request.getParameter("facility_id"));
	String nursingUnit_code= (request.getParameter("nursingUnit_code"));
	String date_freqBased=(request.getParameter("date_freqBased"));
	date_freqBased = DateUtils.convertDate(date_freqBased,"DMY", locale, "en"); //Date Localization	
	String patientId=(request.getParameter("patientId"));
	String whereClause = checkForNull(request.getParameter("whereclause"));
	if(whereClause==null) whereClause="";
	String from = checkForNull(request.getParameter("from"));
	String to = checkForNull(request.getParameter( "to" ));
	int start = (from.equals(""))?1:Integer.parseInt(from);
	int end = (to.equals(""))?14:Integer.parseInt(to);
	int maxRecord = 0;
	//Added Against ML-MMOH-CRF-1061 US3 Starts Here
	String patient_class_IP="IP";
	String status_code_IP="";
	String status_desc_IP="";
	String status_desc_MP="";
	String status_desc_MR="";
	String status_desc_MS="";
	String status_desc_MJ="";
	String status_code_MP="";
	String status_code_MR="";
	String status_code_MS="";
	String status_code_MJ="";
	String IPstatus_Pre_YN="";
	String IPstatus_Rec_YN="";
	String STATUS_ACT_YN_IP="";
	String sql_Query="";
	//Added Against ML-MMOH-CRF-1061 US3 Ends Here
		
	//IN:38887 
	String sql="select rownum,to_char(mealhdr.serving_Date,'HH24:MI') as servingTime,encounter.encounter_Id,encounter.patient_Id,patient.patient_Name,encounter.patient_Class,mealhdr.kitchen_Code,to_char(mealhdr.serving_Date,'DD/MM/YYYY HH24:MI') as servingDateTime,mealhdr.meal_Category,mealhdr.diet_Type,mealhdr.meal_Class,mealhdr.meal_Type,mealhdr.menu_Code,mealdtl.item_Sl,mealdtl.item_Type,mealdtl.item_Code,items.short_Desc,mealdtl.item_Qty,encounter.assign_Care_Locn_Code,mealdtl.item_SL,TO_CHAR(sysdate,'DD/MM/YYYY HH24:MI') as sys_date from Pr_Encounter encounter,Mp_Patient patient,Ds_Epsd_Meal_Plan_Dtl mealdtl,Ds_Epsd_Meal_Plan_Hdr mealhdr,Ds_Items items where encounter.patient_Id = patient.patient_Id and encounter.facility_Id = mealhdr.operating_Facility_Id and encounter.encounter_Id = mealhdr.encounter_Id and  mealdtl.operating_Facility_Id = mealhdr.operating_Facility_Id and  mealdtl.encounter_Id = mealhdr.encounter_Id and  mealdtl.serving_Date = mealhdr.serving_Date and  nvl(mealdtl.meal_Type,'!@')    = nvl(mealhdr.meal_Type,'!@') and  mealdtl.item_Code = items.food_Item_Code and  mealdtl.freq_Yn = 'Y' and items.language_Id = ? and mealhdr.operating_Facility_Id = ? and encounter.assign_Care_Locn_Code = ? and to_char(mealhdr.serving_Date,'dd/mm/yyyy') = NVL (?,  TO_CHAR (mealhdr.serving_date, 'dd/mm/yyyy')) and encounter.patient_Id = nvl(?,encounter.patient_Id)";

	
	String sysdate="", patient_id = "",patient_name	= "",short_Desc = "",item_Qty = "",item_SL="",item_Type="",srvDateTime="",complaint_desc= "",complaint_code="",selectedItemMP	= "",classValue = "",selectedItemMR	= "",selectedItemMS ="",selectedItemMJ ="",selectedItem = "",selectedOptionVal = "",temp ="",encounter_id="",servingDate="",servingTime="",eventDateTime="",patient_class="",kitchen_code="",meal_category="",meal_class="",meal_type="",menu_code="",status="",itemCode="",diet_type="",MealReplaceYn="",MealReplaceYes="",MealReplaceNo="",MealReplaceNoSelect="",MealReplaceYesSelect="", othComplaintDesc=""; // Added Against ML-MMOH-CRF-681
	String visibleStyle="";
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;
	boolean isMealComplaints = false; //Added Against MMOH-CRF-1125[IN:067026]
	try{
			connection			= ConnectionManager.getConnection(request);
			/* Added Against Start ML-MMOH-CRF-1125[IN:067026] */
			isMealComplaints = CommonBean.isSiteSpecific(connection,"DS","DS_MEAL_COMPLAINTS");		
			/* Added Against End ML-MMOH-CRF-1125[IN:067026] */
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,nursingUnit_code);
			pstmt.setString(4,date_freqBased);
			pstmt.setString(5,patientId);

			resultSet = pstmt.executeQuery();

			//getting maximum record
	    	resultSet.last();	maxRecord = resultSet.getRow();
			//modified by N Munisekhar on 22-May-2013 against [IN039044]
	    	if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));//history.go(-1);</script>");

			}
			//again move the resultset pointer to initial position
			resultSet.beforeFirst(); %>

<form name="FreqBasedDetailsForm" id="FreqBasedDetailsForm" target="messageFrame">
	<input type="hidden" name="startIndex" id="startIndex" value="<%=start%>"/>
	<input type="hidden" name="endIndex" id="endIndex" value="<%=end%>"/>
	<table align='right'>
	<tr><td>
	<%
	if ( !(start <= 1) )
	    out.println("<A HREF='../../eDS/jsp/SpclFoodItems_FreqBased_Details.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(whereClause)+"&locale="+(locale)+"&facility_id="+(facility_id)+"&date_freqBased="+(date_freqBased)+"&nursingUnit_code="+(nursingUnit_code) +"&patientId="+(patientId)+ "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
	    out.println("<A HREF='../../eDS/jsp/SpclFoodItems_FreqBased_Details.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(whereClause)+"&locale="+(locale)+"&facility_id="+(facility_id)+"&date_freqBased="+(date_freqBased)+"&nursingUnit_code="+(nursingUnit_code) +"&patientId="+(patientId)+ "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	%>
	</td></tr>
	</table>
	<br><br>
	<!--modified by N Munisekhar on 22-May-2013 against [IN039044]-->
	<%if(maxRecord != 0){ %>
		<table border='1' cellspacing='0' width='100%' align='center' id="freqBasedSelectedTable">

			<tr>
				<TH valign='top' class='ColumnHeaderCenter'>
					<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}"/>
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eOT.ItemQty.Label" bundle="${ot_labels}"/>
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eOT.ScheduleTime.Label" bundle="${ot_labels}"/>
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.status.label" bundle="${common_labels}"/>
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.datetime.label" bundle="${common_labels}"/>
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eOT.Complaints.Label" bundle="${ot_labels}"/>
				</TH>
				<!--Added Against Start ML-MMOH-CRF-681-->
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eDS.FoodReplacement.Label" bundle="${ds_labels}"/>
				</TH>
				<!-- Added Against End ML-MMOH-CRF-681-->
			</tr>

			<%}
				if ( start!= 1 ) resultSet.absolute(start-1);
				int i=start;
				while(resultSet != null && resultSet.next() && i<=end){
				status= selectedItemMP = srvDateTime = selectedItemMR=selectedItemMS =selectedItemMJ = complaint_code = complaint_desc= temp=eventDateTime="";
				visibleStyle="style='visibility:hidden;nowrap:true'";
				sysdate=resultSet.getString("sys_date");
				if(sysdate ==null) sysdate="";
				sysdate= DateUtils.convertDate(sysdate,"DMYHM", "en",  locale);
				patient_name=(resultSet.getString("patient_Name"));
				patient_id=(resultSet.getString("patient_Id"));
				short_Desc=(resultSet.getString("short_Desc"));
				item_Qty=(resultSet.getString("item_Qty"));
				itemCode=(resultSet.getString("item_Code"));
				item_SL=(resultSet.getString("item_SL"));
				item_Type=(resultSet.getString("item_Type"));
				srvDateTime=(resultSet.getString("servingDateTime"));
				meal_type=(resultSet.getString("meal_Type"));
				servingTime=(resultSet.getString("servingTime"));
				kitchen_code = (resultSet.getString("kitchen_Code"));
				patient_class = (resultSet.getString("patient_Class"));
				meal_category = (resultSet.getString("meal_Category"));
				meal_class = (resultSet.getString("meal_Class"));
				menu_code = (resultSet.getString("menu_Code"));
				diet_type=(resultSet.getString("diet_Type"));
				encounter_id = resultSet.getString("encounter_Id");

				ResultSet rs=null;
				String sql_FreqBased="select rownum,a.encounter_Id,to_char(a.serving_Date,'HH24:MI') as servingTime,to_char(a.serving_Date,'dd/mm/yyyy HH24:MI') as servingDateTime,to_char(a.event_Date_Time,'dd/mm/yyyy HH24:mi') as eventDateTime,a.status,a.complaint_Code,a.complaint_Desc,a.complaint_Source_Type,a.complaint_Source_Code,encounter.patient_Id,patient.patient_Name,a.item_Code,item.short_Desc,a.item_Qty,a.item_Sl,a.item_Type,a.meal_replace_yn,a.oth_complaint_desc,a.OTH_COMPLAINT_DESC from Ds_Epsd_Meal_Plan_Spl_Audit a,Pr_Encounter encounter,mp_patient patient,Ds_Items item where a.operating_Facility_Id = encounter.facility_Id and a.encounter_Id = encounter.encounter_Id and a.item_Code = item.food_Item_Code and item.language_Id = ? and a.operating_Facility_Id = ? and a.encounter_Id = ? and to_char(a.serving_Date,'dd/mm/yyyy HH24:MI') = ? and  a.freq_Yn = 'Y' and a.item_Code=? and patient.patient_id=encounter.patient_id order by  2 , 1";//Added against 060395 and 681 and CRF-1125

				pstmt = connection.prepareStatement(sql_FreqBased);
				pstmt.setString(1,locale);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,encounter_id);
				pstmt.setString(4,srvDateTime);
				pstmt.setString(5,itemCode);//Added against 060395
				rs=pstmt.executeQuery();
				while (rs.next()) {
					servingDate=(rs.getString("servingDateTime"));
					eventDateTime=(rs.getString("eventDateTime"));
					eventDateTime= DateUtils.convertDate(eventDateTime,"DMYHM", "en",  locale); //Date Localization
					
					status=(rs.getString("status"));
					complaint_code=(rs.getString("complaint_Code"));
					// Added Against ML-MMOH-CRF-681
					MealReplaceYn=(rs.getString("meal_replace_yn"));
					if(MealReplaceYn==null || MealReplaceYn.equals(""))
							MealReplaceYn="";
					// Added Against Start ML-MMOH-CRF-681					
					temp=(rs.getString("complaint_Desc"));
					if (temp!=null && !(temp.equals("null"))) complaint_desc=temp;
					othComplaintDesc=checkForNull(rs.getString("oth_complaint_desc")); //MMOH-CRF-1125[IN:067026]
					if(status!="" && status!=null) {
						if(status.equals("MP")) {selectedOptionVal = "Meal Prepared";selectedItemMP = "Selected";}
						else if(status.equals("MR")) {selectedOptionVal = "Meal Received";selectedItemMR = "Selected";}
						else if(status.equals("MS")) {selectedOptionVal = "Meal Served";selectedItemMS = "Selected";visibleStyle="style='visibility:visible;nowrap:true'";}
						else if(status.equals("MJ")) {selectedOptionVal = "Meal Reject";selectedItemMJ = "Selected";}
					}
					else status="";
					// Added Against Start ML-MMOH-CRF-681	
					if(MealReplaceYn.equals("N") || MealReplaceYn.equals("")){
						MealReplaceNo ="N";
						MealReplaceNoSelect = "Selected";						
					}
					else if (MealReplaceYn.equals("Y")){
						MealReplaceYes ="Y";
						MealReplaceYesSelect = "Selected";						
					}
					 // Added Against End ML-MMOH-CRF-681	
					classValue =(i%2==0)?"qryEven":"qryOdd";
				}// While loop closing
				
			//Added Against ML-MMOH-CRF-1061 US3 Starts Here
			sql_Query= "SELECT status_code , status_desc ,STATUS_ACT_YN FROM DS_MEAL_ACK_STATUS_MAST WHERE disp_sl_no <= 4 AND patient_class ='"+patient_class_IP+"' ORDER BY patient_class, disp_sl_no DESC";
			pstmt=connection.prepareStatement(sql_Query);
			rs=pstmt.executeQuery();
			while (rs.next()){		
			status_code_IP = rs.getString(1);
			status_desc_IP = rs.getString(2);
			STATUS_ACT_YN_IP = rs.getString(3);
				if((status_code_IP.equals("MP"))){
					status_code_MP = rs.getString(1);
					status_desc_MP = rs.getString(2);
					IPstatus_Pre_YN	= rs.getString(3);
				}else if((status_code_IP.equals("MR"))){
					status_code_MR = rs.getString(1);
					status_desc_MR = rs.getString(2);
					IPstatus_Rec_YN = rs.getString(3);
				}else if((status_code_IP.equals("MS"))){
					status_code_MS = rs.getString(1);
					status_desc_MS = rs.getString(2);
				}else if((status_code_IP.equals("MJ"))){
					status_code_MJ = rs.getString(1);
					status_desc_MJ = rs.getString(2);
				}
			}
			//Added Against ML-MMOH-CRF-1061 US3 Ends Here
				rs.close();
				pstmt.close();
		%>
<tr>
	<td class='<%=classValue%>' width='12%' nowrap><%=patient_name%></td>
	<td class='<%=classValue%>' width='12%' nowrap><%=patient_id%></td>
	<td class='<%=classValue%>' width='12%' nowrap><%=short_Desc%></td>
	<td class='<%=classValue%>' width='12%' nowrap><%=item_Qty%></td>
	<td class='<%=classValue%>' width='12%' nowrap><%=servingTime%></td>
	<td class='<%=classValue%>' width='12%' nowrap>
		<select name="effStatus<%=i%>" id="effStatus<%=i%>" onchange="changeSelectForMealType('<%=i%>',this.value)">
			<option value="<%=selectedItem%>">--Select--</option>
			<!-- Modified Against ML-MMOH-CRF-1061 US3 Starts Here -->
			<%if(IPstatus_Pre_YN.equals("Y")){%>
			<option value="MP" <%=selectedItemMP%>/><%=status_desc_MP%>
			</option>
			<%}%>
			<%if(IPstatus_Rec_YN.equals("Y")){%>
			<option value="MR" <%=selectedItemMR%>/><%=status_desc_MR%>
			</option>
			<%}%>
			<option value="MS" <%=selectedItemMS%>/><%=status_desc_MS%>
			</option>
			<option value="MJ" <%=selectedItemMJ%>/><%=status_desc_MJ%>
			</option>
			<!-- Modified Against ML-MMOH-CRF-1061 US3 Ends Here -->
		</select>
	</td>
	<td class='<%=classValue%>' width='12%' nowrap>
		<input type='hidden' name="date_time<%=i%>" id="date_time<%=i%>" value="<%=srvDateTime%>"/>
		<!--modified by N Munisekhar on 22-May-2013 against [IN039044]-->
		<%if(!eventDateTime.equals(null) && (eventDateTime!="") && (!status.equals(""))){%>
		<input type="text" name="eventDate_Freq<%=i%>" id="eventDate_Freq<%=i%>" value="<%=eventDateTime%>"  size="16" onblur="if(this.value!='') validateDate(this.value,'<%=i%>')"/>
		<%}else{%><input type="text" name="eventDate_Freq<%=i%>" id="eventDate_Freq<%=i%>" value="<%=sysdate%>" size="16" onblur="if(this.value!='') validateDate(this.value,'<%=i%>')" /> <%}%>
		<input type="hidden" name="eventDate_Freq_pattern<%=i%>" id="eventDate_Freq_pattern<%=i%>" value="dd/MM/yyyy HH:mm" length="15"/
		<a onclick="return showCalForNonFreq('<%=i%>','eventDate_Freq<%=i%>','%d/%m/%Y %H:%M','24',true,'eventDate_Freq<%=i%>')" >
			<img src="../../framework/images/img.gif" onclick="return showCalForNonFreq('<%=i%>','eventDate_Freq<%=i%>','%d/%m/%Y %H:%M','24',true,'eventDate_Freq<%=i%>')"/>
		</a>
	</td>
	<td class='<%=classValue%>' width='12%' nowrap>
		<%if(isMealComplaints){		
			//visibleStyle="style='visibility:visible;'";
			if(othComplaintDesc!="" && status.equals("MJ")){		
		%>
		<input type="text" value="<%=complaint_desc%>" disabled name="complaintDesc<%=i%>" id="complaintDesc<%=i%>" onblur="if(this.value!='') return  complaintsLookup('complaintDesc<%=i%>',<%=i%>); else complaintCode<%=i%>.value=''" onchange="enableOthers(<%=i%>)"/>
		<input type="hidden"  value="<%=complaint_code%>"  name="complaintCode<%=i%>" id="complaintCode<%=i%>"/>
		<input type="button" id="bt<%=i%>"  class="BUTTON" value="?" disabled onclick="complaintsLookup('complaintDesc<%=i%>',<%=i%>)" />	
		<%}else{
		%>
		<input type="text" value="<%=complaint_desc%>"  name="complaintDesc<%=i%>" id="complaintDesc<%=i%>" onblur="if(this.value!='') return  complaintsLookup('complaintDesc<%=i%>',<%=i%>); else complaintCode<%=i%>.value=''" onchange="enableOthers(<%=i%>)"/>
		<input type="hidden"  value="<%=complaint_code%>"  name="complaintCode<%=i%>" id="complaintCode<%=i%>"/>
		<input type="button" id="bt<%=i%>" class="BUTTON" value="?" onclick="complaintsLookup('complaintDesc<%=i%>',<%=i%>)" />			
		<%}}else{
		%>	
		<input type="text" value="<%=complaint_desc%>"  name="complaintDesc<%=i%>" id="complaintDesc<%=i%>" onblur="if(this.value!='') return  complaintsLookup('complaintDesc<%=i%>',<%=i%>); else complaintCode<%=i%>.value=''" onchange="enableOthers(<%=i%>)"/>
		<input type="hidden"  value="<%=complaint_code%>"  name="complaintCode<%=i%>" id="complaintCode<%=i%>"/>
		<input type="button" id="bt<%=i%>" class="BUTTON" value="?" onclick="complaintsLookup('complaintDesc<%=i%>',<%=i%>)" />			
		<%}%>
		<!-- Added Against Start ML-MMOH-CRF-1125[IN:067026] -->
		<%if(isMealComplaints){		
			if(!complaint_desc.equals("") && status.equals("MJ")){
				visibleStyle="style='visibility:visible;'";
		%>			
		<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%> disabled href="javascript:OtherComplaints(<%=i%>)"; > &nbsp&nbsp Others </a>		
		<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othComplaintDesc%>" />			
		<%}else if(!othComplaintDesc.equals("") && status.equals("MJ")){
				visibleStyle="style='visibility:visible;'";
		%>
		<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%> href="javascript:OtherComplaints(<%=i%>)"; > &nbsp&nbsp Others </a>		
		<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othComplaintDesc%>" />			
		<%}else{
				visibleStyle="style='visibility:hidden;'";
		%>
		<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%> href="javascript:OtherComplaints(<%=i%>)"; >Others</a>		
		<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othComplaintDesc%>" />			
		<%}}%>	
		<!-- Added Against End ML-MMOH-CRF-1125[IN:067026] -->
		<%if(!status.equals("MJ")){ %>
		<img id="cmp<%=i%>"  style="visibility:hidden;" src="../../eCommon/images/mandatory.gif"/>
		<%}else{%>
		<img id="cmp<%=i%>"  style="visibility:visible;" src="../../eCommon/images/mandatory.gif"/>			
		<%}%>

	</td>
	<!-- Added Against Start ML-MMOH-CRF-681 -->
	<td>
		<%if(status.equals("MJ")){%>
			<select  id="MealReplaceYn<%=i%>" name="MealReplaceYn<%=i%>" >
			<%if(MealReplaceYn.equals("Y")){%>
			<option value="Y" <%=MealReplaceYn%> /><fmt:message key="Common.yes.label" bundle="${common_labels}" /></option>
			<option value="N" <%=MealReplaceYn%>/><fmt:message key="Common.no.label" bundle="${common_labels}" /></option>
			<%}else{%>
			<option value="N" <%=MealReplaceYn%>/><fmt:message key="Common.no.label" bundle="${common_labels}" /></option>
			<option value="Y" <%=MealReplaceYn%> /><fmt:message key="Common.yes.label" bundle="${common_labels}" /></option>
			<%}%>
		<%}else{%>	
			<select  id="MealReplaceYn<%=i%>" name="MealReplaceYn<%=i%>" disabled>
			<option value="N" <%=MealReplaceYn%> / ><fmt:message key="Common.no.label" bundle="${common_labels}" /></option>
			<option value="Y" <%=MealReplaceYn%> / ><fmt:message key="Common.yes.label" bundle="${common_labels}" /></option>
		<%}%> 	
		</select>
	</td>
	<!-- Added Against End ML-MMOH-CRF-681 -->
	
	<input type="hidden" name="patientId<%=i%>" id="patientId<%=i%>" value="<%=patient_id%>"/>
	<input type="hidden" name="encounterId<%=i%>" id="encounterId<%=i%>" value="<%=encounter_id%>"/>
	<input type="hidden" name="servingDate<%=i%>" id="servingDate<%=i%>" value="<%=servingDate%>"/>
	<input type="hidden" name="servingDatePattern<%=i%>" id="servingDatePattern<%=i%>" value="dd/MM/yyyy"/>
	<input type="hidden" name="eventDateTimePattern<%=i%>" id="eventDateTimePattern<%=i%>" value="dd/MM/yyyy HH:mm"/>
	<input type="hidden" name="patientClass<%=i%>" id="patientClass<%=i%>" value="<%=patient_class%>"/>
	<input type="hidden" name="kitchenCode<%=i%>" id="kitchenCode<%=i%>" value="<%=kitchen_code%>"/>
	<input type="hidden" name="mealCategory<%=i%>" id="mealCategory<%=i%>" value="<%=meal_category%>"/>
	<input type="hidden" name="mealClass<%=i%>" id="mealClass<%=i%>" value="<%=meal_class%>"/>
	<input type="hidden" name="mealType<%=i%>" id="mealType<%=i%>" value="<%=meal_type%>"/>
	<input type="hidden" name="menuCode<%=i%>" id="menuCode<%=i%>" value="<%=menu_code%>"/>
	<input type="hidden" name="savedStatus<%=i%>" id="savedStatus<%=i%>" value="<%=status%>"/>
	<input type="hidden" name="test<%=i%>" id="test<%=i%>" value="<%=selectedItemMP%>"/>
	<input type="hidden" name="itemCode<%=i%>" id="itemCode<%=i%>" value="<%=itemCode%>"/>
	<input type="hidden" name="itemQty<%=i%>" id="itemQty<%=i%>" value="<%=item_Qty%>"/>
	<input type="hidden" name="itemSL<%=i%>" id="itemSL<%=i%>" value="<%=item_SL%>"/>
	<input type="hidden" name="itemType<%=i%>" id="itemType<%=i%>" value="<%=item_Type%>"/>

</tr>
	<%
	    i++;} //While loop closing
	if(i==0)
		 out.println("<script>callNoRecord();</script>");

	}catch(Exception e) {
		    e.printStackTrace();
            System.err.println("Exception=="+e);
	}finally{
				if(resultSet!=null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null)
					ConnectionManager.returnConnection(connection,request);
    }
%>
<input type="hidden" name="sysdate" id="sysdate" value="<%=sysdate%>">
<input type="hidden" name="totalRecords" id="totalRecords" value="0">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="date_freqBased" id="date_freqBased" value="">
<input type="hidden" name="splFoodItemYn" id="splFoodItemYn" value="N"/>
<input type="hidden" name="tabName" id="tabName" value="mealTypeTab"/>
<input type="hidden" name="isMealComplaints" id="isMealComplaints" id ="isMealComplaints" value="<%=isMealComplaints%>"> <!-- Added Against MMOH-CRF-1125 -->
</table>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
	</div>
</form>
</body>
</html>

