<!DOCTYPE html>
<%
/*
Added by Niveditha For GHL-CRF-0602.1
*/
%>

<%@page import="java.util.*,java.sql.*, eBT.*,webbeans.eCommon.*, eCommon.Common.*,java.util.*,java.lang.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String login_user;
		String strFid = "";
		Connection con = null;
		Properties p = null;
		HttpSession httpSession = request.getSession(false);
		p = (Properties)httpSession.getValue("jdbc"); 
		strFid = ""+httpSession.getAttribute("facility_id");
		login_user = p.getProperty("login_user");
		String locale = (String)session.getAttribute("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

		String facilityId = (String)session.getValue("facility_id");

		int sNo=0;

		String section_code = request.getParameter("lab_dept_name_search") == null ? "" : request.getParameter("lab_dept_name_search");
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String specimen_number = request.getParameter("specimen_number") == null ? "" : request.getParameter("specimen_number");
		String order_facility_name_search = request.getParameter("order_facility_name_search") == null ? "" : request.getParameter("order_facility_name_search");
		String performing_facility_id_search = request.getParameter("performing_facility_id_search") == null ? "" : request.getParameter("performing_facility_id_search");
		String ordering_pract_code_search = request.getParameter("ordering_pract_code_search") == null ? "" : request.getParameter("ordering_pract_code_search");
		String reporting_facility_id_search = request.getParameter("reporting_facility_id_search") == null ? "" : request.getParameter("reporting_facility_id_search");
		String fromDate_search = request.getParameter("fromDate_search") == null ? "" : request.getParameter("fromDate_search");
		String toDate_search = request.getParameter("toDate_search") == null ? "" : request.getParameter("toDate_search");
		String assigned_red_code_search = request.getParameter("assigned_red_code_search") == null ? "" : request.getParameter("assigned_red_code_search");
		String lab_order_status = request.getParameter("lab_order_status") == null ? "" : request.getParameter("lab_order_status");

	con = ConnectionManager.getConnection(request);

	PathologistWorkListBean bean = new PathologistWorkListBean();

	ArrayList PathologistRecords = (ArrayList)bean.getPathologistWorkList(section_code,patient_id,specimen_number,order_facility_name_search,performing_facility_id_search,ordering_pract_code_search,reporting_facility_id_search,fromDate_search,toDate_search,assigned_red_code_search,lab_order_status);
%>
<html>
<head>
	<script language="javascript" src="../../eBT/js/PathologistWorkListResult.js"></script>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">	
   <form name ="PathologistWorkListResultForm" action="../../servlet/eBT.PathologistWorkListResultServlet" method=post target="messageFrame">

<%
if(PathologistRecords.size()==0){
		%>
		<script>errorCall()</script>

<%	
}	else{%>
	<div id='table_container_left' style='overflow:auto;width:100%;height:319px;' >  
	<table  width="100%"  class='grid' id='titleTable' >
         <tr  style='height:60px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2);'>
		  <th width="20%" class='COLUMNHEADER' ><input type="checkbox" name="selectAll" id="selectAll"  value="Y" onclick="selectCheckBoxes(this);" /><fmt:message key="Common.selectall.label" bundle="${common_labels}"/></th>
            <th width="15%" class='COLUMNHEADER' ><fmt:message key="eBT.Slno.label" bundle="${bt_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eBT.LabOrderStatus.label" bundle="${bt_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eBT.SpecimenNumber.label" bundle="${bt_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.PatientName_fs.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.age.label" bundle="${common_labels}"/> / <fmt:message key="Common.Sex.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eBT.ReportingFacility.label" bundle="${bt_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="eBT.AssignedPathologist.label" bundle="${bt_labels}"/></th>
			<th width="20%" class='COLUMNHEADER' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
        </tr>
        
		<%for(int i=0;i<PathologistRecords.size();i=i+17){%>	
		<tr  id='divTitleTable1'  height='0%'>

    
			
			
			
			
			<% 
				 if(null !=PathologistRecords.get(i+15) && !"".equals(PathologistRecords.get(i+15))){
					if((PathologistRecords.get(i+15)).equals("H")) {%>
			    <td class='gridDataChart' nowrap><input type="checkbox" name="select<%=sNo%>" id="select<%=sNo%>" disabled value="" onclick="selectedRecord(this)" /></td> <!--SELECT-->
		<%  }else {
			
          %>
		   <td class='gridDataChart' nowrap><input type="checkbox" name="select<%=sNo%>" id="select<%=sNo%>" value="" onclick="selectedRecord(this)" /></td> <!--SELECT-->
				 <%} }else{ %>
		   <td class='gridDataChart' nowrap><input type="checkbox" name="select<%=sNo%>" id="select<%=sNo%>" value="" onclick="selectedRecord(this)" /></td> <!--SELECT-->
		 <%  }%>  
		   
		   

            <td class='gridDataChart' nowrap><%=sNo+1%></td>


			<%  
			if(null !=PathologistRecords.get(i+10)  && !"".equals(PathologistRecords.get(i+10))) {
				int count=Integer.parseInt((String)PathologistRecords.get(i+9)); 	
				if(count>0){  %>
				<td class='gridDataChart' nowrap><%=PathologistRecords.get(i+10) %></a></td>
				<%}else{ %>
					<td class='gridDataChart' nowrap> <%=PathologistRecords.get(i+10) %></td> <!--LABORDERSTATUS-->
				<% }  
			}else { %>
				<td class="gridDataChart" nowrap></td>
           <%} %>
        	
			
			<% 
				 if(null !=PathologistRecords.get(i)  && !"".equals(PathologistRecords.get(i))) {
					 %>
			    <td class='gridDataChart' nowrap><%=PathologistRecords.get(i) %></td> <!--SPECIMEN_NO-->
		<%  }else {
			
          %>
		  <td class="gridDataChart" nowrap></td>
           <%} %>
		   
		   
			
			
			<% 
				 if(null !=PathologistRecords.get(i+1)  && !"".equals(PathologistRecords.get(i+1))) {
					 %>
			   <td class='gridDataChart' nowrap><%=PathologistRecords.get(i+1) %></td><!--DATE/TIME-->
		<%  }else {
			
          %>
		  <td class="gridDataChart" nowrap></td>
           <%} %>
		   
		   
			
           
		   <% 
				 if(null !=PathologistRecords.get(i+2)  && !"".equals(PathologistRecords.get(i+2))) {
					 %>
			   <td class='gridDataChart' nowrap><%=PathologistRecords.get(i+2) %></td> <!--PATIENT_ID-->
		<%  }else {
			
          %>
		  <td class="gridDataChart" nowrap></td>
           <%} %>
		   
		   
			<% 
				 if(null !=PathologistRecords.get(i+3)  && !"".equals(PathologistRecords.get(i+3))) {
					 %>
			    <td class='gridDataChart' nowrap><%=PathologistRecords.get(i+3) %></td> <!--PATIENT_NAME-->
		<%  }else {
			
          %>
		  <td class="gridDataChart" nowrap></td>
           <%} %>
		   
		   
            
            <% 
				 if(null !=PathologistRecords.get(i+4)  && !"".equals(PathologistRecords.get(i+4))) {
					 %>
			   <td class='gridDataChart' nowrap><%=PathologistRecords.get(i+4) %></td> <!--AGE/SEX-->
		<%  }else {
			
          %>
		  <td class="gridDataChart" nowrap></td>
           <%} %>
		   
		   
			<% 
				 if(null !=PathologistRecords.get(i+5)  && !"".equals(PathologistRecords.get(i+5))) {
					 %>
			   <td class='gridDataChart' nowrap><%=PathologistRecords.get(i+5) %></td> <!--PERFORMING_FACILITY-->
		<%  }else {
			
          %>
		  <td class="gridDataChart" nowrap></td>
           <%} %>
		   
		   
			<% 
				 if(null !=PathologistRecords.get(i+6)  && !"".equals(PathologistRecords.get(i+6))) {
					 %>
			   <td class='gridDataChart' nowrap><%=PathologistRecords.get(i+6) %></td> <!--REPORTING_FACILITY_ID-->
		<%  }else {
			
          %>
		  <td class="gridDataChart" nowrap></td>
           <%} %>

			<% 
				 if(null !=PathologistRecords.get(i+16)  && !"".equals(PathologistRecords.get(i+16))) {
					 %>
			  <td class='gridDataChart' nowrap><%=PathologistRecords.get(i+16)%></td> <!--REPORTING_PATHOLOGIST_ID-->
		<%  }else {
			
          %>
		  <td class="gridDataChart" nowrap></td>
           <%} %>

		         <% 
				 if(null !=PathologistRecords.get(i+8)  && !"".equals(PathologistRecords.get(i+8))) {
					 String encodeRemarks =java.net.URLEncoder.encode((String)PathologistRecords.get(i+8), "UTF-8");
					 %>
			  <td    class="gridDataChart"  nowrap onMouseOver = "showToolTipsForChnFldRmks(this,'<%=encodeRemarks%>')" style="color:blue;"><fmt:message key="eBT.ViewRemark.label" bundle="${bt_labels}"/></td> <!--ASSIGN_PATHO_REMARKS-->
		<%  }else {
			
          %>
		  <td class="gridDataChart" nowrap></td>
           <%} %>

		   
		   	<input type="hidden" value="<%=PathologistRecords.get(i+11)%>" name="ordering_facility_id<%=sNo%>" /> 
			<input type="hidden" value="<%=PathologistRecords.get(i+12)%>" name="operating_facility<%=sNo%>" /> 
            <input type="hidden" value="<%=PathologistRecords.get(i+13)%>" name="ordering_pract<%=sNo%>" /> 
			<input type="hidden" value="<%=PathologistRecords.get(i)%>" name="specimen_no_pass<%=sNo%>" /> 
            <input type="hidden" value="<%=PathologistRecords.get(i+2)%>" name="patient_id_pass<%=sNo%>" /> 
            <input type="hidden" value="<%=PathologistRecords.get(i+6)%>" name="reporting_facility_id<%=sNo%>" /> 
		   
		</tr>
			<% sNo++; 
	}%>
    </table>
    </div> 
	
	
	 <table border="0" cellpadding="3" cellspacing="0" id='tbId' width="100%" valign='bottom'>
	<tr>	
		<td class=label  width="15%"><fmt:message key="eBT.ReportingFacility.label" bundle="${bt_labels}"/></td>
		<td class='fields' width="25%" >
			<input type='text' name="reporting_facility_id_name" id="reporting_facility_id_name" value=""  onBlur='getReportingFactility1(this)' size='30' />
			<input type='button' name='reporting_facility_buttn' id='reporting_facility_buttn'  value='?' class='button' onClick="getReportingFactility()" />
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			<input type='hidden' name='reporting_facility_id' id='reporting_facility_id' value='' />
		</td>
		<td class=label  width="10%"  ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
		<td  rowSpan="2" width="30%" >
			<input type="hidden" value="" name="Remarks" id="Remarks">
			<textarea rows="3" id="Remarks_assign" name="remarks_name" cols="90" maxLength="5" onKeyPress="return ( this.value.length < 250);" onblur="return checkCharRange(this,'250') "  ></textarea>
		</td>	
	</tr>
	<tr>

			
		<td class=label width="10%"  ><fmt:message key="eBT.AssignPathologist.label" bundle="${bt_labels}"/></td>
		<td class='fields' width="25%"  >
			<input type='text'  name="assign_desc" id="assign_desc" value="" onBlur='getAssignedPathologist1(this)' size='30' />
			<input type='button' name='search' id='search' value='?'  class='button' onClick="getAssignedPathologist()"/>
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			<input type='hidden' name="assign_code" id="assign_code" value=''/>
		</td>	   
		<td class=label width="10%" >&nbsp;</td>
	</tr>  
	<tr>
		<td colspan="3" class=label >&nbsp;</td>
		<td width='50%' align="right">
			<input type='button' name='Assign' id='Assign' value='Assign' class="button" onclick="insertRecords()"/>
			<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class=button onclick="resetCriteria();" />
		</td>
	</tr>
	</table> 	
 <%}	
%>
    <input type="hidden" value="<%=sNo-1%>" name="count" />
    <input type='hidden' name='locale' id='locale' value ='<%=locale%>'>  
    <input type='hidden' name='section_code' id='section_code' value ='<%=section_code%>'>  
    <input type='hidden' name='performing_facility_id_search' id='performing_facility_id_search' value ='<%=performing_facility_id_search%>'>  

</form>
</body>
</html>

