<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eDS.DSCommonBean,eDS.*,java.util.ArrayList,java.net.URLEncoder" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script type='text/javascript' language="JavaScript" src="../../eDS/js/MealPreparedServedComplaints.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
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
	String mealType_code= (request.getParameter("mealType_code"));
	String nursingUnit_code= (request.getParameter("nursingUnit_code"));
	String from_date=(request.getParameter("from_date"));
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
	from_date = DateUtils.convertDate(from_date,"DMY", locale, "en"); //Date Localization
	
	String whereClause = checkForNull(request.getParameter("whereclause"));
	if(whereClause==null) whereClause="";
	String from = checkForNull(request.getParameter("from"));
	String to = checkForNull(request.getParameter( "to" ));
	int start = (from.equals(""))?1:Integer.parseInt(from);
	int end = (to.equals(""))?14:Integer.parseInt(to);
	int maxRecord = 0;

	String sql="select prencounte0_.ENCOUNTER_ID as col_0_0_, prencounte0_.PATIENT_ID as col_1_0_, mppatient1_.PATIENT_NAME as col_2_0_, prencounte0_.PATIENT_CLASS as col_3_0_, dsepsdmeal2_.KITCHEN_CODE as col_4_0_, to_char(dsepsdmeal2_.SERVING_DATE, 'dd/mm/yyyy') as col_5_0_, dsepsdmeal2_.MEAL_CATEGORY as col_6_0_, dsepsdmeal2_.DIET_TYPE as col_7_0_, ds_get_desc.ds_diet_type(dsepsdmeal2_.diet_type,'"+locale+"','2') as diet_desc,dsepsdmeal2_.MEAL_CLASS as col_8_0_, dsepsdmeal2_.MEAL_TYPE as col_9_0_, dsepsdmeal2_.MENU_CODE as col_10_0_, TO_CHAR(sysdate,'DD/MM/YYYY HH24:MI') as sys_date from PR_ENCOUNTER prencounte0_, MP_PATIENT mppatient1_, DS_EPSD_MEAL_PLAN_HDR dsepsdmeal2_ where (prencounte0_.PATIENT_ID=mppatient1_.PATIENT_ID ) and (prencounte0_.FACILITY_ID=dsepsdmeal2_.OPERATING_FACILITY_ID ) and (prencounte0_.ENCOUNTER_ID=dsepsdmeal2_.ENCOUNTER_ID )";

	String sysdate="", patient_id = "",patient_name	= "",diet_type = "",diet_type_desc="",status = "",date_time = "",date_time1="", complaint_desc= "",complaint_code="",selectedItemMP	= "",classValue = "",selectedItemMR	= "",selectedItemMS ="",selectedItemMJ ="",selectedItem = "",selectedOptionVal = "",temp ="",encounter_id="",servingDate="",patient_class="",kitchen_code="",meal_category="",meal_class="",meal_type="",menu_code="",rejectedItemsCount="",MealReplaceYn="",MealReplaceYes="",MealReplaceNo="",MealReplaceYesSelect="",MealReplaceNoSelect="",rejected_by="", othComplaintDesc="";//CRF-681 and CRF-1125
	String visibleStyle="",visibleOthers="";
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;

	if((whereClause == null || whereClause.equals(""))){
 			if ( !(mealType_code == null || mealType_code.equals("")) ){
 				whereClause = whereClause + "and dsepsdmeal2_.MEAL_TYPE = '"+mealType_code+"'";
			}
			if ( !(nursingUnit_code == null || nursingUnit_code.equals("")) ){
				whereClause = whereClause + "and prencounte0_.ASSIGN_CARE_LOCN_CODE= '"+nursingUnit_code+"'";
			}
			if ( !(facility_id == null || facility_id.equals("")) ){
				whereClause = whereClause + "and dsepsdmeal2_.OPERATING_FACILITY_ID= '"+facility_id+"'";
			}
			if ( !(from_date == null || from_date.equals("")) ){
				whereClause = whereClause + "and (to_char(dsepsdmeal2_.SERVING_DATE , 'dd/mm/yyyy')=nvl('"+from_date+"', to_char(dsepsdmeal2_.SERVING_DATE , 'dd/mm/yyyy')))";
			}

	}
		 sql = sql+whereClause;
         //end of where clause IF
		 // int i=0;
		boolean isMealComplaints =false; //Added Against MMOH-CRF-1125[IN:067026]
	try{
			connection	= ConnectionManager.getConnection(request);
			/* Added Against ML-MMOH-CRF-1125[IN:067026] */
			isMealComplaints = CommonBean.isSiteSpecific(connection,"DS","DS_MEAL_COMPLAINTS");		
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			/*pstmt.setString(1,mealType_code);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,nursingUnit_code);
			pstmt.setString(4,from_date);*/
			resultSet = pstmt.executeQuery();

			//getting maximum record
	    	resultSet.last();	maxRecord = resultSet.getRow();
			//modified by N Munisekhar on 22-May-2013 against [IN039044]
	    	if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); //history.go(-1);</script>");
			}
			//again move the resultset pointer to initial position
			resultSet.beforeFirst(); %>

<form name="MealPreparedServedComplaintsDetailsForm" id="MealPreparedServedComplaintsDetailsForm" target="messageFrame">
<input type="hidden" name="startIndex" id="startIndex" value="<%=start%>"/>
<input type="hidden" name="endIndex" id="endIndex" value="<%=end%>"/>
<table align='right'>
<tr><td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/MealPreparedServedComplaints_Details.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(whereClause)+"&mealType_code="+(mealType_code)+"&facility_id="+(facility_id)+"&from_date="+(from_date)+"&nursingUnit_code="+(nursingUnit_code) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/MealPreparedServedComplaints_Details.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(whereClause)+"&mealType_code="+(mealType_code)+"&facility_id="+(facility_id)+"&from_date="+(from_date)+"&nursingUnit_code="+(nursingUnit_code) +"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td></tr>
</table>
<br><br>
<!-- modified by N Munisekhar on 22-May-2013 against [IN039044]-->
<%if(maxRecord != 0){ %>
		<table border='1' cellspacing='0' width='100%' align='center' id="mealSelectedTable">

			<tr>
				<TH valign='top' class='ColumnHeaderCenter'>
					<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</TH>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
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
				status= selectedItemMP = selectedItemMR=selectedItemMS =selectedItemMJ = complaint_code = complaint_desc= temp= rejectedItemsCount= "";
				visibleStyle="style='visibility:hidden;nowrap:true'";
				sysdate=resultSet.getString("sys_date");
				sysdate = DateUtils.convertDate(sysdate,"DMYHM", "en",  locale); //Localization
				if(sysdate ==null) sysdate="";
				patient_name=(resultSet.getString("col_2_0_"));
				patient_id=(resultSet.getString("col_1_0_"));
				diet_type=(resultSet.getString("col_7_0_"));
				diet_type_desc=(resultSet.getString("diet_desc"));
				patient_class=(resultSet.getString("col_3_0_"));
				kitchen_code=(resultSet.getString("col_4_0_"));
				meal_category=(resultSet.getString("col_6_0_"));
				meal_class=(resultSet.getString("col_8_0_"));
				meal_type=(resultSet.getString("col_9_0_"));
				menu_code=(resultSet.getString("col_10_0_"));
				encounter_id = resultSet.getString("col_0_0_");
				ResultSet rs=null, rs_rejectedItems=null;
				String sql_meal_details="select dsepsdmeal0_.ENCOUNTER_ID as col_0_0_, to_char(dsepsdmeal0_.SERVING_DATE, 'dd/mm/yyyy') as col_1_0_, dsepsdmeal0_.MEAL_TYPE as col_2_0_, to_char(dsepsdmeal0_.EVENT_DATE_TIME, 'dd/mm/yyyy HH24:mi') as col_3_0_, dsepsdmeal0_.STATUS as col_4_0_, dsepsdmeal0_.COMPLAINT_CODE as col_5_0_, dsepsdmeal0_.COMPLAINT_DESC as col_6_0_, dsepsdmeal0_.COMPLAINT_SOURCE_TYPE as col_7_0_, dsepsdmeal0_.COMPLAINT_SOURCE_CODE as col_8_0_, prencounte1_.PATIENT_ID as col_9_0_, mppatient2_.PATIENT_NAME as col_10_0_, dsepsdmeal0_.KITCHEN_CODE as col_11_0_, dsepsdmeal0_.PATIENT_CLASS as col_12_0_, dsepsdmeal0_.MEAL_CATEGORY as col_13_0_, dsepsdmeal0_.MEAL_CLASS as col_14_0_, dsepsdmeal0_.MEAL_TYPE as col_15_0_, dsepsdmeal0_.MENU_CODE as col_16_0_, dsepsdmeal0_.DIET_TYPE as col_17_0_, dsepsdmeal0_.MEAL_REPLACE_YN AS MEAL_REPLACE_YN,dsepsdmeal0_.rejected_by AS rejected_by ,dsepsdmeal0_.oth_complaint_desc AS oth_complaint_desc from DS_EPSD_MEAL_PLAN_HDR_AUDIT dsepsdmeal0_, PR_ENCOUNTER prencounte1_, MP_PATIENT mppatient2_ where dsepsdmeal0_.OPERATING_FACILITY_ID=prencounte1_.FACILITY_ID and dsepsdmeal0_.ENCOUNTER_ID=prencounte1_.ENCOUNTER_ID and prencounte1_.PATIENT_ID=mppatient2_.PATIENT_ID and dsepsdmeal0_.OPERATING_FACILITY_ID=prencounte1_.FACILITY_ID and dsepsdmeal0_.ENCOUNTER_ID=prencounte1_.ENCOUNTER_ID and ((dsepsdmeal0_.OPERATING_FACILITY_ID=? )and(dsepsdmeal0_.ENCOUNTER_ID=? )and(to_char(dsepsdmeal0_.SERVING_DATE , 'dd/mm/yyyy')=? )and(dsepsdmeal0_.MEAL_TYPE=? )) order by  2 , 1";//CRF-681 and MMOH-CRF-1125[IN:067026]
				pstmt = connection.prepareStatement(sql_meal_details);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounter_id);
				pstmt.setString(3,from_date);
				pstmt.setString(4,mealType_code);
				rs=pstmt.executeQuery();				
				if(rs.next()) {
					servingDate=(rs.getString("col_1_0_"));
					date_time=(rs.getString("col_1_0_"));
					date_time = DateUtils.convertDate(date_time,"DMY", "en",  locale); //Date Localization and changes for exception value too short//CRF-681
					date_time1=(rs.getString("col_3_0_"));
					date_time1 = DateUtils.convertDate(date_time1,"DMYHM", "en",  locale); //Date Localization
					status=checkForNull(rs.getString("col_4_0_"));
		
					complaint_code=checkForNull(rs.getString("col_5_0_"));
					temp=checkForNull(rs.getString("col_6_0_"));
					MealReplaceYn=checkForNull(rs.getString("MEAL_REPLACE_YN"));
					rejected_by=checkForNull(rs.getString("rejected_by"));
					othComplaintDesc=checkForNull(rs.getString("oth_complaint_desc")); //MMOH-CRF-1125[IN:067026]
					if (temp!=null && !(temp.equals("null"))) 
					complaint_desc=temp;		
		
					if(date_time1 == null) 
					date_time1="&nbsp;";
		
					if(status!="" && status!=null) {
					if(status.equals("MP")){						
						selectedOptionVal = "Meal Prepared";
						selectedItemMP = "Selected";
					}
					else if(status.equals("MR")){
						selectedOptionVal = "Meal Received";
						selectedItemMR = "Selected";
					}
					else if(status.equals("MS")){
						selectedOptionVal = "Meal Served";
						selectedItemMS = "Selected";
						visibleStyle="style='visibility:visible;nowrap:true'";
					}
					else if(status.equals("MJ")){
						selectedOptionVal = "Meal Reject";
						selectedItemMJ = "Selected";
					}
					}
					else status="";
					if(MealReplaceYn.equals("N") || MealReplaceYn.equals("")){
						MealReplaceNo ="N";
						MealReplaceNoSelect = "Selected";						
					}
					else if (MealReplaceYn.equals("Y")){
						MealReplaceYes ="Y";
						MealReplaceYesSelect = "Selected";
					}
				}
				
				String sql_rejected_items="select count(item_code) from ds_epsd_meal_item_rejections WHERE operating_facility_id = ? and encounter_id =? and serving_date = TO_DATE (?, 'DD/MM/YYYY hh24:mi') and spl_food_item_yn = 'N' and meal_type=? and rejected_yn='Y'";
				pstmt = connection.prepareStatement(sql_rejected_items);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounter_id);
				pstmt.setString(3,from_date);
				pstmt.setString(4,mealType_code);
				rs_rejectedItems=pstmt.executeQuery();
				
				if(rs_rejectedItems.next()) {
					rejectedItemsCount=rs_rejectedItems.getString(1);
				}	
				
				rs.close();
				pstmt.close();

			classValue =(i%2==0)?"qryEven":"qryOdd";
			
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
		%>

<tr>
	<td class='<%=classValue%>' width='12%' nowrap><%=patient_name%></td>
	<td class='<%=classValue%>' width='12%' nowrap><%=patient_id%></td>
	<td class='<%=classValue%>' width='12%' nowrap><%=diet_type_desc%></td>

	<td>
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
		<%if (!(rejectedItemsCount.equals("0") || rejectedItemsCount.equals(""))){
		%><strong>		
		<%}%>
		<a id="link<%=i%>" <%=visibleStyle%> href="javascript:show_FoodItems_ModalWindow(<%=i%>);" >&nbsp&nbsp "Rejected Items ?" </a>
		<%if(!(rejectedItemsCount.equals("0") || rejectedItemsCount.equals(""))){%>
		</strong>
		<%}%>
	</td>
	<td>
		<input type='hidden' name="NonFreq[<%=i%>]" id="NonFreq[<%=i%>]" value="<%=date_time%>"/>
		<!--modified by N Munisekhar on 22-May-2013 against [IN039044]-->
		<%
		if(!date_time1.equals(null) && (date_time1!="") && (!status.equals(""))){
		%>
		<input type="text" name="eventDate<%=i%>" id="eventDate<%=i%>" value="<%=date_time1%>"  size="16" onblur="if(this.value!='') validateDate(this.value,'<%=i%>')"/>
		<%}else{%><input type="text" name="eventDate<%=i%>" id="eventDate<%=i%>" value="<%=sysdate%>"  size="16" onblur="if(this.value!='') validateDate(this.value,'<%=i%>')"/> <%}%>
		<input type="hidden" name="eventDate_pattern<%=i%>>" id="eventDate_pattern<%=i%>>" value="dd/MM/yyyy HH:mm" length="15"/>
		<a onclick="return showCalForNonFreq('<%=i%>','eventDate<%=i%>','%d/%m/%Y %H:%M','24',true,'eventDate<%=i%>')" >
			<img src="../../framework/images/img.gif" onclick="return showCalForNonFreq('<%=i%>','eventDate<%=i%>','%d/%m/%Y %H:%M','24',true,'eventDate<%=i%>')"/>
		</a>
	</td>
<td>
	
		<%if(isMealComplaints){		
			if(othComplaintDesc!="" && status.equals("MJ")){
		%>
		<input type="text" value="<%=complaint_desc%>" disabled name="complaintDesc<%=i%>" id="complaintDesc<%=i%>" onblur="if(this.value!='') return  complaintsLookup('complaintDesc<%=i%>',<%=i%>);   else complaintCode<%=i%>.value=''" onchange="enableOthers(<%=i%>)"/> 
		<input type="hidden"  value="<%=complaint_code%>"  name="complaintCode<%=i%>" id="complaintCode<%=i%>"/>
		<input type="button" id="bt<%=i%>"  class="BUTTON" value="?" disabled onclick="complaintsLookup('complaintDesc<%=i%>',<%=i%>)" />	
		<%}else{
		%>
		<input type="text" value="<%=complaint_desc%>"  name="complaintDesc<%=i%>" id="complaintDesc<%=i%>" onblur="if(this.value!='') return  complaintsLookup('complaintDesc<%=i%>',<%=i%>);  else complaintCode<%=i%>.value=''" onchange="enableOthers(<%=i%>)"/>
		<input type="hidden"  value="<%=complaint_code%>"  name="complaintCode<%=i%>" id="complaintCode<%=i%>"/>
		<input type="button" id="bt<%=i%>" class="BUTTON" value="?" onclick="complaintsLookup('complaintDesc<%=i%>',<%=i%>)" />			
		<%}
		}else{
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
		<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%> disabled href="javascript:OtherComplaints(<%=i%>)";>Others</a>		
		<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othComplaintDesc%>" />			
		<%}else if(!othComplaintDesc.equals("") && status.equals("MJ")){
			visibleStyle="style='visibility:visible;'";
		%>
		<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%> href="javascript:OtherComplaints(<%=i%>)";>Others</a>		
		<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othComplaintDesc%>" />		
		<%}else{
			visibleStyle="style='visibility:hidden;'";
		%>
		<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%> href="javascript:OtherComplaints(<%=i%>)"; >Others</a>		
		<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="" />			
		<%}}%>	
		<!-- Added Against End ML-MMOH-CRF-1125[IN:067026] -->
		<%if(!status.equals("MJ")){
		visibleStyle="style='visibility:hidden;'";
		}else{
		visibleStyle="style='visibility:visible;'";
		}%>
		<img id="cmp<%=i%>"  <%=visibleStyle%> src="../../eCommon/images/mandatory.gif"/>			
	</td>		
	<td>
		<%if(status.equals("MJ")){		
		%>
			<select  id="MealReplaceYn<%=i%>" name="MealReplaceYn<%=i%>" >
			<%if(MealReplaceYn.equals("Y")){%>
			<option value="Y" <%=MealReplaceYn%> /><fmt:message key="Common.yes.label" bundle="${common_labels}" /></option>
			<option value="N" <%=MealReplaceYn%>/><fmt:message key="Common.no.label" bundle="${common_labels}" /></option>
			<%}else{%>
			<option value="N" <%=MealReplaceYn%>/><fmt:message key="Common.no.label" bundle="${common_labels}" /></option>
			<option value="Y" <%=MealReplaceYn%> /><fmt:message key="Common.yes.label" bundle="${common_labels}" /></option>
			<%}%>
		<%}else{		
		%>	
			<select  id="MealReplaceYn<%=i%>" name="MealReplaceYn<%=i%>" disabled>
			<option value="N" <%=MealReplaceYn%> / ><fmt:message key="Common.no.label" bundle="${common_labels}" /></option>
			<option value="Y" <%=MealReplaceYn%> / ><fmt:message key="Common.yes.label" bundle="${common_labels}" /></option>
		<%}%> 	
		</select>
	</td>

	<input type="hidden" name="patientId<%=i%>" id="patientId<%=i%>" value="<%=patient_id%>"/>
	<input type="hidden" name="encounterId<%=i%>" id="encounterId<%=i%>" value="<%=encounter_id%>"/>
	<input type="hidden" name="servingDate<%=i%>" id="servingDate<%=i%>" value="<%=servingDate%>"/>
	<input type="hidden" name="dietType<%=i%>" id="dietType<%=i%>" value="<%=diet_type%>"/>
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
	<input type="hidden" name="rejected_by<%=i%>" id="rejected_by<%=i%>" value="<%=rejected_by%>"/>
	

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
<input type="hidden" name="sysdate" id="sysdate" value="<%=sysdate%>"/>
<input type="hidden" name="totalRecords" id="totalRecords" value="0"/>
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>"/>
<input type="hidden" name="locale" id="locale" value="<%=locale%>"/>
<input type="hidden" name="date_mealtype" id="date_mealtype" value=""/>
<input type="hidden" name="splFoodItemYn" id="splFoodItemYn" value="N"/>
<input type="hidden" name="tabName" id="tabName" value="mealTypeTab"/>
<input type="hidden" name="from_date" id="from_date" value="<%=from_date%>"/>
<input type="hidden" name="isMealComplaints" id="isMealComplaints" id ="isMealComplaints" value="<%=isMealComplaints%>"> <!-- Added Against MMOH-CRF-1125 -->
</table>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
	</div>
</form>
</body>
</html>

