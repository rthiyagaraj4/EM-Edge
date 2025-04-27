<!DOCTYPE html>
<%@  page  language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,java.util.ArrayList" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%	
    //Added Against MMS Vulnerability Issue - Starts
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

    String functionId = (String) session.getAttribute("functionId");
	String facility_id = (String)session.getAttribute("facility_id");

	String title = (String) request.getParameter("title");
	String moduleId = (String) session.getAttribute("moduleId");
	String encounterId = (String) request.getParameter("encounterId");
	String mealType = (String) request.getParameter("mealType");
	String servingDate = (String) request.getParameter("servingDate");
	String eventDate = (String) request.getParameter("eventDate");
	String languageId = (String) request.getParameter("languageId");
	String sourceCode = (String) request.getParameter("sourceCode");
	String patientId = (String) request.getParameter("patientId");
	String patientClass = (String) request.getParameter("patientClass");
	String kitchenCode = (String) request.getParameter("kitchenCode");
	String mealCategory = (String) request.getParameter("mealCategory");
	String dietType = (String) request.getParameter("dietType");
	String mealClass = (String) request.getParameter("mealClass");
	//String status = (String) request.getParameter("status");
	String complaintCode = (String) request.getParameter("complaintCode");
	String complaintDesc = (String) request.getParameter("complaintDesc");
	String menuCode = (String) request.getParameter("menuCode");
	String splFoodItemYn = (String) request.getParameter("splFoodItemYn");
	//Added Against Start ML-MMOH-CRF-1125[IN:067026]
	String othersComp = (String) request.getParameter("othersComp");
	boolean isMealComplaints =false;
	isMealComplaints=Boolean.valueOf(request.getParameter("isMealComplaints"));	
	//Added Against End ML-MMOH-CRF-1125[IN:067026]
	//String fName = (String) request.getParameter("fName");

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
					.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
					.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script type="text/javascript" src="../../core/lookup/js/Lookup.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script type='text/javascript' src='../../eDS/js/MealPreparedServedComplaints.js'></script>
	<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eCommon/js/dchk.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<script>
</script>
<title><%=title%></title>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" 	onLoad="getFoodItem('<%=encounterId%>','<%=mealType%>','<%=servingDate%>','<%=languageId%>', '<%=splFoodItemYn%>','<%=kitchenCode%>', '<%=facility_id%>')">
	<form name="rejectedItemsForm" id="rejectedItemsForm" method="post">

		<table  id="contentTable1" border='0' cellspacing='0' width='100%'  align='center'>
		<tr>
		<th width='30%'><fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}" /></th>
		<th width='10%'><fmt:message key="eOT.Rejected.Label" bundle="${ot_labels}" /></th>
		<th width='25%'><fmt:message key="Common.datetime.label" bundle="${common_labels}" /></th>		
		<th width='30%'>
		<%if(isMealComplaints){%>
		<fmt:message key="eOT.Complaints.Label" bundle="${ot_labels}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="Common.others.label" bundle="${common_labels}" />
		<%}else{%>
		<fmt:message key="eOT.Complaints.Label" bundle="${ot_labels}" />	
		<%}%>
		</th>
		
		</tr>
		</table>
		<div id="listContentLayer" style="overflow: auto;height: 180px;">
		<table  id="contentTable" border='1' cellspacing='0' width='100%' align='center'>
		<%
			String sql="select b.food_Item_Code,b.short_Desc,a.item_Qty from Ds_Epsd_Meal_Plan_Dtl a,Ds_Items b where a.encounter_Id like :encounterId and a.meal_Type like :mealType and to_char(a.serving_Date,'dd/MM/yyyy') like :srvDate and a.item_Code = b.food_Item_Code and b.language_Id like :languageId";
			String food_Item_Code="",foodItem_desc="",quantity="",classValue="",rejected_YN="",complaint_long_desc="",rejDateTime="",complaint_code="",othersCompDesc="",visibleStyle=""; //Added Against ML-MMOH-CRF-1125
			Connection connection   = null ;
			PreparedStatement pstmt = null ;
			PreparedStatement ps = null ;
			ResultSet resultSet     = null ;
			ResultSet rs     = null ;
			int i=0;
			try{
					connection			= ConnectionManager.getConnection(request);
					pstmt = connection.prepareStatement(sql);
					pstmt.setString(1,encounterId);
					pstmt.setString(2,mealType);
					pstmt.setString(3,servingDate);
					pstmt.setString(4,languageId);
					resultSet = pstmt.executeQuery();

					while(resultSet.next()){
						food_Item_Code= foodItem_desc = quantity= complaint_long_desc= rejected_YN= rejDateTime=complaint_code= othersCompDesc =""; //Added Against ML-MMOH-CRF-1125
// 						sysdate=resultSet.getString("sys_date");
// 						if(sysdate ==null) sysdate="";
						food_Item_Code=(resultSet.getString("food_Item_Code"));
						foodItem_desc=(resultSet.getString("short_Desc"));
						quantity=(resultSet.getString("item_Qty"));
						i++;
					classValue =(i%2==0)?"qryEven":"qryOdd";
					/* Modified Against Start ML-MOH-CRF-1125 */
					//String sql_rejItems="select rejections.REJECTED_YN,rejections.rejected_reason, complaints.long_desc,to_char(rejections.REJECTED_DATE,'DD/MM/YYYY hh24:mi') as rejDateTime,rejections.OTH_COMPLAINT_DESC from Ds_Epsd_Meal_Item_Rejections rejections,DS_COMPLAINTS_LANG_VW complaints where rejections.operating_Facility_Id =? and rejections.encounter_Id =? and  to_char(rejections.serving_date,'dd/mm/yyyy')=? and rejections.spl_Food_Item_Yn ='N' and rejections.meal_Type =? and  rejections.item_Code =? and rejections.rejected_reason=complaints.complaint_code and complaints.eff_status='E' and complaints.language_id=?";					
					String sql_rejItems="select rejections.REJECTED_YN, rejections.rejected_reason,ds_get_desc.ds_complaints(rejections.rejected_reason,?,'1') long_desc,TO_CHAR (rejections.rejected_date,'DD/MM/YYYY hh24:mi') AS rejDateTime,rejections.OTH_COMPLAINT_DESC from Ds_Epsd_Meal_Item_Rejections rejections WHERE rejections.operating_facility_id = ? AND rejections.encounter_id = ? AND TO_CHAR (rejections.serving_date, 'dd/mm/yyyy') = ? AND rejections.spl_food_item_yn = 'N' AND rejections.meal_type = ? AND rejections.item_code = ?";
					/* Modified Against End ML-MOH-CRF-1125 */
					ps = connection.prepareStatement(sql_rejItems);					 
					ps.setString(1,languageId);
					ps.setString(2,facility_id);
					ps.setString(3,encounterId);
					ps.setString(4,servingDate);
					ps.setString(5,mealType);
					ps.setString(6,food_Item_Code);					
					rs = ps.executeQuery();
					while(rs.next()){
						rejected_YN=rs.getString("REJECTED_YN");
						complaint_code=rs.getString("rejected_reason");
						if(complaint_code==null) complaint_code="";
						complaint_long_desc=rs.getString("long_desc");
						if(complaint_long_desc==null) complaint_long_desc="";
						rejDateTime=rs.getString("rejDateTime");
						if(rejDateTime==null) rejDateTime="";
						othersCompDesc=rs.getString("OTH_COMPLAINT_DESC"); //Added Against ML-MMOH-CRF-1125
						if(othersCompDesc==null) othersCompDesc=""; 
						
					}
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
		%>
			<tr>
				<td class="<%=classValue%>" width="30%" nowrap><%=foodItem_desc%></td>
				<input type="hidden" name="itemCode<%=i%>" id="itemCode<%=i%>" value="<%=food_Item_Code%>"/>
				<input type="hidden" name="rejectedQty<%=i%>" id="rejectedQty<%=i%>" value="<%=quantity%>"/>
				<td class="<%=classValue%>" width="10%" nowrap>
					<input type="checkbox" name="rejectedYn<%=i%>" id="rejectedYn<%=i%>" onclick="getCellVal(this,'<%=i%>')"/>
					<script>
						var chk='<%=rejected_YN%>';
						var i=<%=i%>;
						if(chk=="Y") {
							document.getElementById("rejectedYn"+i).checked=true;
							document.getElementById("rejectedYn"+i).value='Y';
						}
					</script>
				</td>
				<td class="<%=classValue%>" width="25%" nowrap>
					<input type="text" name="rejdate<%=i%>" id="rejdate<%=i%>" value="<%=rejDateTime%>" length="16" onblur="val_date(this)"/>
					<a onclick="return showCalForNonFreq('<%=i %>','rejdate<%=i%>','%d/%m/%Y %H:%M','24',true,'rejdate<%=i%>');" >
						<img id="cal<%=i%>" disabled src="../../framework/images/img.gif">
					</a>
				</td>
	<td class="<%=classValue%>" width="30%" nowrap>				
		<%if(isMealComplaints){		
			if(othersCompDesc!=""){
		%>			
		<input type="text" disabled size="35" name="complaintDesc<%=i%>" id="complaintDesc<%=i%>" onblur="showComplaintslookup(this,'<%=i%>')"  value="<%=complaint_long_desc%>">
		<input type="hidden" name="complaintCode<%=i%>" id="complaintCode<%=i%>" value="<%=complaint_code %>">
		<input type="button" id="RejectedItemLookup<%=i%>" disabled class="BUTTON" value="?" onclick="showComplaintslookup(this,'<%=i%>')" />
		<%}else{
		%>			
		<input type="text" size="35" name="complaintDesc<%=i%>" id="complaintDesc<%=i%>" onblur="showComplaintslookup(this,'<%=i%>')"  value="<%=complaint_long_desc%>">
		<input type="hidden" name="complaintCode<%=i%>" id="complaintCode<%=i%>" value="<%=complaint_code %>">
		<input type="button" id="RejectedItemLookup<%=i%>" class="BUTTON" value="?" onclick="showComplaintslookup(this,'<%=i%>')" />
		<%}}else{
		%>
		<input type="text" size="35" name="complaintDesc<%=i%>" id="complaintDesc<%=i%>" onblur="showComplaintslookup(this,'<%=i%>')"  value="<%=complaint_long_desc%>">
		<input type="hidden" name="complaintCode<%=i%>" id="complaintCode<%=i%>" value="<%=complaint_code %>">
		<input type="button" id="RejectedItemLookup<%=i%>" class="BUTTON" value="?" onclick="showComplaintslookup(this,'<%=i%>')" />
		<%}%>
					
		<!-- Added Against Start ML-MMOH-CRF-1125[IN:067026] -->
		<%if(isMealComplaints){	
			if(!complaint_long_desc.equals("")){ 
				visibleStyle="style='visibility:visible;'"; %>
		<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%>  disabled href="javascript:OtherCompReject(<%=i%>)"; > &nbsp&nbsp Others </a>		
		<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othersCompDesc%>" />
		<%}else if(!othersCompDesc.equals("")){ 
			visibleStyle="style='visibility:visible;'"; %>
		<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%> href="javascript:OtherCompReject(<%=i%>)"; > &nbsp&nbsp Others </a>		
		<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othersCompDesc%>" />	
		<%}else{ 
			visibleStyle="style='visibility:hidden;'"; %>
		<a id="othersLink<%=i%>" name="othersLink<%=i%>" <%=visibleStyle%> href="javascript:OtherCompReject(<%=i%>)"; > &nbsp&nbsp Others </a>		
		<input type="hidden" id="othersComp<%=i%>" name="othersComp<%=i%>" value="<%=othersCompDesc%>" />	
		<%}}%>
		<!-- Added Against End ML-MMOH-CRF-1125[IN:067026] -->
		<img id="mandatory<%=i%>" style="visibility:hidden" src="../../framework/images/mandatory.gif"/>
	</td>
</tr>
	<%
	    } //While loop closing
		}catch(Exception e){
			e.printStackTrace();
	        System.err.println("Exception=="+e);
		}finally{
			if(resultSet!=null) resultSet.close();
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(ps!=null) ps.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
	    }
%>			<input type="hidden" name="index" id="index" value="<%=i%>"/>
	</table>
</div>
	<table  id="buttonTable" border='0' cellspacing='0' width='100%'  align='center'>
		<tr>
			<td width='30%'></td>
			<td width='10%'></td>
			<td width='25%'></td>
			<td width='30%' align='right'>
		<!-- TODO: setDate validation -->
		<input type='button'  class='BUTTON' name='select' id='select' value='Select' onClick='submit123()'/>
		<input type='reset' class='BUTTON' name='cancel' id='cancel' value='Cancel' onClick='parent.parent.document.getElementById("dialog_tag").close(); '/></td>
		</tr>
	</table>
		<input type="hidden" name="method" id="method" />
		<input type="hidden" name="functionId" id="functionId" value="<%=functionId%>" />
		<input type="hidden" name="moduleId" id="moduleId" value="<%=moduleId%>" />
		<!-- <input type="text" name="method" id="method" /> -->
		<input type="hidden" name="checkFlag" id="checkFlag" value="Y"  />
		<input type="hidden" name="updateFlag" id="updateFlag" value="N"/>		
		<input type="hidden" name="mealType" id="mealType" value="<%=mealType%>" />
		<input type="hidden" name="sourceCode" id="sourceCode" value="<%=sourceCode%>" />		
		<input type="hidden" name="sourceType" id="sourceType" value="N" />
		
		<input type="hidden" name="splFoodItemYn" id="splFoodItemYn" value="N" />
		
		<input type="hidden" name="freqYn" id="freqYn" value="N" />
		<input type="hidden" name="encounterId" id="encounterId" value="<%=encounterId%>" />
		<input type="hidden" name="patientClass" id="patientClass" value="<%=patientClass%>" />
		<input type="hidden" name="kitchenCode" id="kitchenCode" value="<%=kitchenCode%>" />
		<input type="hidden" name="operatingFacilityId" id="operatingFacilityId" value="<%=facility_id%>" />
		<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>" />
		<input type="hidden" name="mealServedDate" id="mealServedDate" value="<%=eventDate%>" />
		<input type="hidden" name="mealServedDatePattern" id="mealServedDatePattern" value="dd/MM/yyyy HH:mm" />
		<input type="hidden" name="servingDate" id="servingDate" value="<%=servingDate%>" />
		<input type="hidden" name="servingDatePattern" id="servingDatePattern" value="dd/MM/yyyy" />
		<input type="hidden" name="dietType" id="dietType" value="<%=dietType%>" />
		<input type="hidden" name="locale1" id="locale1" value="<%=languageId%>" />
		<input type="hidden" name="languageId" id="languageId" value="<%=languageId%>" />
		<input type="hidden" name="eventDate" id="eventDate" value="<%=eventDate%>" />
		<input type="hidden" name="index" id="index"/>
		<input type="hidden" name="index1" id="index1"/>
		<input type="hidden" name="status" id="status" value="MS" />
		
		<input type="hidden" name="complaintCode" id="complaintCode" value="<%=complaintCode%>" />
		<input type="hidden" name="complaintDesc" id="complaintDesc" value="<%=complaintDesc%>" />
		<input type="hidden" name="menuCode" id="menuCode" value="<%=menuCode%>" />
		<input type="hidden" name="mealClass" id="mealClass" value="<%=mealClass%>" />
		<input type="hidden" name="mealCategory" id="mealCategory" value="<%=mealCategory%>" />
		
		<input type="hidden" name="splFoodItemYn" id="splFoodItemYn" value="<%=splFoodItemYn%>" />
		<input type="hidden" name="frameName" id="frameName"  value="mealTypeFrame" />
		<input type="hidden" name="status" id="status"  value="MS" />
		<input type="hidden" name="status1" id="status1"  value="PMR" />

		<input type="hidden" name="totalItems" id="totalItems"  value="<%=i%>" />
		<input type="hidden" name="isMealComplaints" id="isMealComplaints" id="isMealComplaints"  value="<%=isMealComplaints%>" /> <!-- Added Against ML-MOH-CRF-1125 -->
	</form>
</body>

</html>

