<!DOCTYPE html>
<%@  page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String locale = (String) session.getAttribute("LOCALE");
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
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<style>
TD.OS {
	BACKGROUND-COLOR: #6666FF;
	FONT-SIZE: 8pt;
	BORDER-STYLE: solid;
	BORDER-BOTTOM: #CC9966 0px solid;
	BORDER-LEFT: #CC9966 0px solid;
	BORDER-RIGHT: #CC9966 0px solid;
	BORDER-TOP: #CC9966 1px solid;
}

TD.PR {
	BACKGROUND-COLOR: #FF99FF;
	FONT-SIZE: 8pt;
	BORDER-STYLE: solid;
	BORDER-BOTTOM: #CC9966 0px solid;
	BORDER-LEFT: #CC9966 0px solid;
	BORDER-RIGHT: #CC9966 0px solid;
	BORDER-TOP: #CC9966 1px solid;
}

TD.IN {
	BACKGROUND-COLOR: #CC0099;
	FONT-SIZE: 8pt;
	BORDER-STYLE: solid;
	BORDER-BOTTOM: #CC9966 0px solid;
	BORDER-LEFT: #CC9966 0px solid;
	BORDER-RIGHT: #CC9966 0px solid;
	BORDER-TOP: #CC9966 1px solid;
}

TD.PO {
	BACKGROUND-COLOR: #FFCC33;
	FONT-SIZE: 8pt;
	BORDER-STYLE: solid;
	BORDER-BOTTOM: #CC9966 0px solid;
	BORDER-LEFT: #CC9966 0px solid;
	BORDER-RIGHT: #CC9966 0px solid;
	BORDER-TOP: #CC9966 1px solid;
}

TD.FN {
	BACKGROUND-COLOR: #990099;
	FONT-SIZE: 8pt;
	BORDER-STYLE: solid;
	BORDER-BOTTOM: #CC9966 0px solid;
	BORDER-LEFT: #CC9966 0px solid;
	BORDER-RIGHT: #CC9966 0px solid;
	BORDER-TOP: #CC9966 1px solid;
}
</style>
			<%
				String facility_id = (request.getParameter("facility_id"));
				String nursingUnit_code = (request.getParameter("nursingUnit_code"));
				String date_nonFreqBased = (request.getParameter("date_nonFreqBased"));
				date_nonFreqBased = DateUtils.convertDate(date_nonFreqBased,"DMY", locale, "en"); //Date Localization
				
				String patientId = (request.getParameter("patientId"));
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

				String sql = "SELECT ROWNUM AS rowNumber, TO_CHAR (mealplanhdr.serving_date, 'HH24:MI') AS servingTime, to_char(mealplanhdr.serving_Date,'DD/MM/YYYY HH24:MI') as servingDateTime,encounter.encounter_id AS encounter_Id, encounter.patient_id AS patient_Id, patient.patient_name AS patient_Name, mealplandtl.meal_type AS meal_Type, mealtype.short_desc AS mealType_shortDesc, mealplandtl.item_sl AS item_SL, mealplandtl.item_type AS item_Type, mealplandtl.item_code AS item_Code, items.short_desc AS item_shortDesc, mealplandtl.item_qty AS item_Qty, encounter.assign_care_locn_code AS locationCode, mealplandtl.kitchen_code AS kitchenCode, mealplandtl.patient_class AS patientClass, mealplanhdr.meal_Category as mealCategory, mealplanhdr.meal_Class, mealplanhdr.menu_Code,mealplanhdr.diet_Type, TO_CHAR(sysdate,'DD/MM/YYYY HH24:MI') as sys_date  FROM pr_encounter encounter, mp_patient patient, ds_epsd_meal_plan_dtl mealplandtl, ds_epsd_meal_plan_hdr mealplanhdr, ds_items items, ds_meal_type mealtype WHERE (encounter.patient_id = patient.patient_id) AND (encounter.facility_id = mealplanhdr.operating_facility_id) AND (encounter.encounter_id = mealplanhdr.encounter_id) AND (mealplandtl.meal_type = mealtype.meal_type) AND (mealplandtl.operating_facility_id =  mealplanhdr.operating_facility_id ) AND (mealplandtl.encounter_id = mealplanhdr.encounter_id) AND (mealplandtl.serving_date = mealplanhdr.serving_date) AND (NVL (mealplandtl.meal_type, '!@') =  NVL (mealplanhdr.meal_type, '!@') ) AND (mealplandtl.item_code = items.food_item_code) AND (items.language_id = ?) AND (mealplandtl.freq_yn = 'N') AND (mealplandtl.spl_food_item_yn = 'Y') AND (mealplanhdr.operating_facility_id = ?) AND (encounter.assign_care_locn_code = ?) AND (encounter.patient_id = NVL (?, encounter.patient_id) ) AND (TO_CHAR (mealplanhdr.serving_date, 'dd/mm/yyyy') = NVL (?,  TO_CHAR (mealplanhdr.serving_date, 'dd/mm/yyyy')   ) )ORDER BY 2,mealtype.meal_order ";
				String sysdate = "", patient_id = "", patient_name = "", short_Desc = "", item_Qty = "", item_SL = "", item_Type = "", srvDateTime = "",complaint_desc = "", complaint_code = "", selectedItemMP = "", classValue = "", selectedItemMR = "", selectedItemMS = "", selectedItemMJ = "", selectedItem = "", selectedOptionVal = "", temp = "", encounter_id = "", servingDate = "", servingTime = "", patient_class = "", kitchen_code = "", meal_category = "", meal_class = "", meal_type = "", menu_code = "", status = "", itemCode = "", mealType_desc = "", eventDateTime = "", diet_type="",MealReplaceYn="",MealReplaceYes="",MealReplaceNo="",MealReplaceNoSelect="",MealReplaceYesSelect="", othComplaintDesc=""; //Added Against Start ML-MMOH-CRF-681 and CRF-1125
				String visibleStyle = "";
				Connection connection = null;
				PreparedStatement pstmt = null;
				ResultSet resultSet = null;
				boolean isMealComplaints = false; //Added Against MMOH-CRF-1125[IN:067026]
				try{
					connection = ConnectionManager.getConnection(request);
					/* Added Against Below ML-MMOH-CRF-1125[IN:067026] */
					isMealComplaints = CommonBean.isSiteSpecific(connection,"DS","DS_MEAL_COMPLAINTS");	
					pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

					System.out.println("facility_id----->>" + facility_id);
					System.out.println("nursingUnit" + nursingUnit_code);
					System.out.println("date_nonFreqBased----->>"+ date_nonFreqBased);
					System.out.println("locale----->>" + locale);
					System.out.println("patientId----->>" + patientId);

					pstmt.setString(1, locale);
					pstmt.setString(2, facility_id);
					pstmt.setString(3, nursingUnit_code);
					pstmt.setString(4, patientId);
					pstmt.setString(5, date_nonFreqBased);
					resultSet = pstmt.executeQuery();

					//getting maximum record
			    	resultSet.last();	maxRecord = resultSet.getRow();
			    	if(maxRecord == 0){
					//modified by N Munisekhar on 22-May-2013 against [IN039044]
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); //history.go(-1);</script>");
					}
					//again move the resultset pointer to initial position
					resultSet.beforeFirst(); %>

				<form name="NonFreqBasedDetailsForm" id="NonFreqBasedDetailsForm" target="messageFrame">
					<input type="hidden" name="startIndex" id="startIndex" value="<%=start%>"/>
					<input type="hidden" name="endIndex" id="endIndex" value="<%=end%>"/>
					<table align='right'>
					<tr><td>
					<%
					if ( !(start <= 1) )
					    out.println("<A HREF='../../eDS/jsp/SpclFoodItems_NonFreqBased_Details.jsp?from="+(start-14)+"&to="+(end-14)+"&locale="+(locale)+"&facility_id="+(facility_id)+"&date_nonFreqBased="+(date_nonFreqBased)+"&nursingUnit_code="+(nursingUnit_code) +"&patientId="+(patientId)+ "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( !( (start+14) > maxRecord ) )
					    out.println("<A HREF='../../eDS/jsp/SpclFoodItems_NonFreqBased_Details.jsp?from="+(start+14)+"&to="+(end+14)+"&locale="+(locale)+"&facility_id="+(facility_id)+"&date_nonFreqBased="+(date_nonFreqBased)+"&nursingUnit_code="+(nursingUnit_code) +"&patientId="+(patientId)+ "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					%>
					</td></tr>
					</table>
					<br><br>
					<!--modified by N Munisekhar on 22-May-2013 against [IN039044]-->
					<%if(maxRecord != 0){ %>
					<table border='1' cellspacing='0' width='100%' align='center'
						id="nonFreqBasedSelectedTable">

						<tr>
							<TH valign='top' class='ColumnHeaderCenter'>
								<fmt:message key="Common.PatientName.label" bundle="${common_labels}" />
							</TH>
							<TH class='ColumnHeaderCenter'>
								<fmt:message key="Common.patientId.label" bundle="${common_labels}" />
							</TH>
							<TH class='ColumnHeaderCenter'>
								<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
							</TH>
							<TH class='ColumnHeaderCenter'>
								<fmt:message key="eOT.FoodItem.Label"	bundle="${ot_labels}" />
							</TH>
							<TH class='ColumnHeaderCenter'>
								<fmt:message key="eOT.ItemQty.Label" bundle="${ot_labels}" />
							</TH>
							<TH class='ColumnHeaderCenter'>
								<fmt:message key="Common.status.label" bundle="${common_labels}" />
							</TH>
							<TH class='ColumnHeaderCenter'>
								<fmt:message key="Common.datetime.label" bundle="${common_labels}"/>
							</TH>
							<TH class='ColumnHeaderCenter'>
								<fmt:message key="eOT.Complaints.Label" bundle="${ot_labels}" />
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

					while (resultSet != null && resultSet.next() && i<=end) {
						status = selectedItemMP = srvDateTime = selectedItemMR = selectedItemMS = selectedItemMJ = complaint_code = complaint_desc = temp = eventDateTime = mealType_desc = diet_type= MealReplaceYn="";//Added Against ML-MMOH-CRF-681
						visibleStyle = "style='visibility:hidden;nowrap:true'";
						sysdate = resultSet.getString("sys_date");
						if(sysdate ==null) sysdate="";
						sysdate= DateUtils.convertDate(sysdate,"DMYHM", "en",  locale);
						patient_name = (resultSet.getString("patient_Name"));
						patient_id = (resultSet.getString("patient_Id"));
						short_Desc = (resultSet.getString("item_shortDesc"));
						item_Qty = (resultSet.getString("item_Qty"));
						itemCode = (resultSet.getString("item_Code"));
						item_SL = (resultSet.getString("item_SL"));
						item_Type = (resultSet.getString("item_Type"));
						srvDateTime = (resultSet.getString("servingDateTime"));
						meal_type = (resultSet.getString("meal_Type"));
						servingTime = (resultSet.getString("servingTime"));
						mealType_desc = (resultSet.getString("mealType_shortDesc"));
						kitchen_code = (resultSet.getString("kitchenCode"));
						patient_class = (resultSet.getString("patientClass"));
						meal_category = (resultSet.getString("mealCategory"));
						meal_class = (resultSet.getString("meal_Class"));
						menu_code = (resultSet.getString("menu_Code"));
						diet_type=(resultSet.getString("diet_Type"));
						encounter_id = resultSet.getString("encounter_Id");

						ResultSet rs = null;
						String sql_NonFreqBased = "select rownum as rowNumber, to_char(mealPlanSplAudit.serving_Date,'HH24:MI') as servingTime,to_char(mealPlanSplAudit.serving_Date,'dd/mm/yyyy HH24:MI') as servingDateTime, mealPlanSplAudit.ENCOUNTER_ID as encounterId, encounter.PATIENT_ID as patientId, patient.PATIENT_NAME as patientName, mealPlanSplAudit.MEAL_TYPE as mealType, mealtype.SHORT_DESC as mealType_shortDesc, mealPlanSplAudit.ITEM_SL as itemSL, mealPlanSplAudit.ITEM_TYPE as itemType, mealPlanSplAudit.ITEM_CODE as itemCode, items.SHORT_DESC as item_shortDesc, mealPlanSplAudit.ITEM_QTY as itemQty, to_char(mealPlanSplAudit.EVENT_DATE_TIME, 'dd/mm/yyyy HH24:mi') as eventDateTime, mealPlanSplAudit.STATUS as status, mealPlanSplAudit.COMPLAINT_CODE as complaint_Code, mealPlanSplAudit.COMPLAINT_DESC as complaint_Desc, mealPlanSplAudit.COMPLAINT_SOURCE_TYPE as complaintSrcType, mealPlanSplAudit.COMPLAINT_SOURCE_CODE as complaintSrcCode,mealPlanSplAudit.MEAL_REPLACE_YN as meal_replace_yn, mealPlanSplAudit.OTH_COMPLAINT_DESC as oth_complaint_desc  from DS_EPSD_MEAL_PLAN_SPL_AUDIT mealPlanSplAudit, PR_ENCOUNTER encounter, DS_MEAL_TYPE mealtype, DS_ITEMS items, MP_PATIENT patient where encounter.PATIENT_ID=patient.PATIENT_ID and ((mealPlanSplAudit.OPERATING_FACILITY_ID=encounter.FACILITY_ID )and(mealPlanSplAudit.ENCOUNTER_ID=encounter.ENCOUNTER_ID )and(mealPlanSplAudit.MEAL_TYPE=mealtype.MEAL_TYPE )and(mealPlanSplAudit.ITEM_CODE=items.FOOD_ITEM_CODE )and(items.LANGUAGE_ID=? )and(mealPlanSplAudit.OPERATING_FACILITY_ID=? )and(mealPlanSplAudit.ENCOUNTER_ID=? )and(mealPlanSplAudit.MEAL_TYPE=? )and(mealPlanSplAudit.ITEM_CODE=? )and(to_char(mealPlanSplAudit.SERVING_DATE , 'dd/mm/yyyy HH24:MI')=? )and(mealPlanSplAudit.FREQ_YN='N' )) order by  2 , 1"; // meal_replace_yn Added Against ML-MMOH-CRF-681
						pstmt = connection.prepareStatement(sql_NonFreqBased);
						pstmt.setString(1, locale);
						pstmt.setString(2, facility_id);
						pstmt.setString(3, encounter_id);
						pstmt.setString(4, meal_type);
						pstmt.setString(5, itemCode);
						pstmt.setString(6, srvDateTime);						
						rs = pstmt.executeQuery();
						while (rs.next()) {
							servingDate = (rs.getString("servingDateTime"));
							status = (rs.getString("status"));
							eventDateTime = (rs.getString("eventDateTime"));
							eventDateTime= DateUtils.convertDate(eventDateTime,"DMYHM", "en",  locale); //Date Localization
							complaint_code = (rs.getString("complaint_Code"));
							//Added Against ML-MMOH-CRF-681
							MealReplaceYn=(rs.getString("meal_replace_yn"));
							if(MealReplaceYn==null || MealReplaceYn.equals(""))
							MealReplaceYn="";
							//Added Against Start ML-MMOH-CRF-681
							temp = (rs.getString("complaint_Desc"));
							if (temp != null && !(temp.equals("null")))	complaint_desc = temp;
							othComplaintDesc=checkForNull(rs.getString("oth_complaint_desc")); //ML-MMOH-CRF-1125							
							if (status != "" && status != null) {
								if (status.equals("MP")) {
									selectedOptionVal = "Meal Prepared";
									selectedItemMP = "Selected";
								} else if (status.equals("MR")) {
									selectedOptionVal = "Meal Received";
									selectedItemMR = "Selected";
								} else if (status.equals("MS")) {
									selectedOptionVal = "Meal Served";
									selectedItemMS = "Selected";
									visibleStyle = "style='visibility:visible;nowrap:true'";
								} else if (status.equals("MJ")) {
									selectedOptionVal = "Meal Reject";
									selectedItemMJ = "Selected";
								}
							} else
								status = "";
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
							classValue = (i % 2 == 0) ? "qryEven" : "qryOdd";
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
				<td class='<%=classValue%>' width='12%' nowrap><%=mealType_desc%></td>
				<td class='<%=classValue%>' width='12%' nowrap><%=short_Desc%></td>
				<td class='<%=classValue%>' width='12%' nowrap><%=item_Qty%></td>
				<td class='<%=classValue%>' width='12%' nowrap>
				<select name="effStatus<%=i%>" id="effStatus<%=i%>" onchange="changeSelectForMealType('<%=i%>',this.value)">
						<option value="<%=selectedItem%>">--Select--</option>
						<!-- Modified Against ML-MMOH-CRF-1061 US3 Starts Here -->
						<%if(IPstatus_Pre_YN.equals("Y")){%>
						<option value="MP" <%=selectedItemMP%> /><%=status_desc_MP%></option>
						<%}%>
						<%if(IPstatus_Rec_YN.equals("Y")){%>
						<option value="MR" <%=selectedItemMR%> /><%=status_desc_MR%></option>
						<%}%>
						<option value="MS" <%=selectedItemMS%> /><%=status_desc_MS%></option>
						<option value="MJ" <%=selectedItemMJ%> /><%=status_desc_MJ%></option>
						<!-- Modified Against ML-MMOH-CRF-1061 US3 Ends Here -->
				</select>
				</td>
				<td class='<%=classValue%>' width='12%' nowrap><input type='hidden' name="date_time<%=i%>" id="date_time<%=i%>" value="<%=srvDateTime%>" />
				<!--modified by N Munisekhar on 22-May-2013 against [IN039044]-->
				<%if(!eventDateTime.equals(null) &&(eventDateTime!="") && (!status.equals(""))){%>
				<input type="text" name="eventDate_NonFreq<%=i%>" id="eventDate_NonFreq<%=i%>" value="<%=eventDateTime%>" size="16" onblur="if(this.value!='') validateDate(this.value,'<%=i%>')" /> 
				<%}else{%><input type="text" name="eventDate_NonFreq<%=i%>" id="eventDate_NonFreq<%=i%>" value="<%=sysdate%>" size="16" onblur="if(this.value!='') validateDate(this.value,'<%=i%>')" /> <%}%>
				<input type="hidden" name="eventDate_NonFreq_pattern<%=i%>" id="eventDate_NonFreq_pattern<%=i%>" value="dd/MM/yyyy HH:mm" length="15"/>

				<a onclick="return showCalForNonFreq('<%=i%>','eventDate_NonFreq<%=i%>','%d/%m/%Y %H:%M','24',true,'eventDate_NonFreq<%=i%>')" >
					<img src="../../framework/images/img.gif" onclick="return showCalForNonFreq('<%=i%>','eventDate_NonFreq<%=i%>','%d/%m/%Y %H:%M','24',true,'eventDate_NonFreq<%=i%>')"/>
				</a></td>
	<td class='<%=classValue%>' width='12%' nowrap>
		<%if(isMealComplaints){		
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
			<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othComplaintDesc%>"		
			<%}else{
				visibleStyle="style='visibility:hidden;'";
			%>
			<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%> href="javascript:OtherComplaints(<%=i%>)"; >Others</a>		
			<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othComplaintDesc%>" />	
			<%}}%>
			<!-- Added Against End ML-MMOH-CRF-1125[IN:067026] -->
			<%if(!status.equals("MJ")){%>
			<img id="cmp<%=i%>" style="visibility: hidden;"	src="../../eCommon/images/mandatory.gif" />
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
			
				<input type="hidden" name="patientId<%=i%>" id="patientId<%=i%>"	value="<%=patient_id%>" />
				<input type="hidden" name="encounterId<%=i%>" id="encounterId<%=i%>" value="<%=encounter_id%>" />
				<input type="hidden" name="servingDate<%=i%>" id="servingDate<%=i%>" value="<%=servingDate%>" />
				<input type="hidden" name="servingDatePattern<%=i%>" id="servingDatePattern<%=i%>" value="dd/MM/yyyy" />
				<input type="hidden" name="eventDateTimePattern<%=i%>" id="eventDateTimePattern<%=i%>" value="dd/MM/yyyy HH:mm" />
				<input type="hidden" name="patientClass<%=i%>" id="patientClass<%=i%>" value="<%=patient_class%>" />
				<input type="hidden" name="kitchenCode<%=i%>" id="kitchenCode<%=i%>" value="<%=kitchen_code%>" />
				<input type="hidden" name="mealCategory<%=i%>" id="mealCategory<%=i%>" value="<%=meal_category%>" />
				<input type="hidden" name="mealClass<%=i%>" id="mealClass<%=i%>" value="<%=meal_class%>" />
				<input type="hidden" name="mealType<%=i%>" id="mealType<%=i%>" value="<%=meal_type%>" />
				<input type="hidden" name="menuCode<%=i%>" id="menuCode<%=i%>" value="<%=menu_code%>" />
				<input type="hidden" name="savedStatus<%=i%>" id="savedStatus<%=i%>" value="<%=status%>" />
				<input type="hidden" name="test<%=i%>" id="test<%=i%>" value="<%=selectedItemMP%>" />
				<input type="hidden" name="itemCode<%=i%>" id="itemCode<%=i%>" value="<%=itemCode%>" />
				<input type="hidden" name="itemQty<%=i%>" id="itemQty<%=i%>" value="<%=item_Qty%>" />
				<input type="hidden" name="itemSL<%=i%>" id="itemSL<%=i%>" value="<%=item_SL%>" />
				<input type="hidden" name="itemType<%=i%>" id="itemType<%=i%>" value="<%=item_Type%>" />

			</tr>
			<%
				/* }// While loop closing
				rs.close();
				pstmt.close(); */
			 i++;} //While loop closing
			if(i==0) out.println("<script>callNoRecord();</script>");

			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Non freq details tab Exception==" + e);
			} finally {
				if (resultSet != null) resultSet.close();
				if (pstmt != null) pstmt.close();
				if (connection != null)
					ConnectionManager.returnConnection(connection, request);
			}
			%>
			<input type="hidden" name="sysdate" id="sysdate" value="<%=sysdate%>">
			<input type="hidden" name="totalRecords" id="totalRecords" value="0">
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="date_nonFreqBased" id="date_nonFreqBased" value="">
			<input type="hidden" name="splFoodItemYn" id="splFoodItemYn" value="N" />
			<input type="hidden" name="tabName" id="tabName" value="mealTypeTab" />
			<input type="hidden" name="isMealComplaints" id="isMealComplaints" id ="isMealComplaints" value="<%=isMealComplaints%>"> <!-- Added Against MMOH-CRF-1125 -->
		</table>
		<div name='tooltiplayer' id='tooltiplayer'
			style='position: absolute; width: 20%; visibility: hidden;'
			bgcolor='blue'></div>
	</form>
</body>
</html>

