<!DOCTYPE html>
<%@page import ="java.util.*,java.sql.*,eBT.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%request.setCharacterEncoding("UTF-8");	%>

<html>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<head>

<script  language="javascript" src="../../eBT/js/PathologistWorkList.js"></script>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script src="../../eBT/js/BTTransaction.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eBT/js/BTMaster.js"></Script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<Script Language="JavaScript" src="../../eBT/js/BTMessage.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


 <body onLoad="callStorageLocation()" onMouseDown="CodeArrest()" onKeyDown="lockKey()>
    <form name='pathologistWorkListCriteriaForm' id='pathologistWorkListCriteriaForm' method='post'   action='' target='messageFrame'> 

   	 <%
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

		
		String strFacilityId;
	    String strPatientId;
	    String strIssuedDate;
	    String strReservedDate;
	    String strSysDate;
	    String strDateRange;
	    String strExpiryDate="";
		String facilityId = (String)session.getValue("facility_id");

		String bean_id					= "PathologistWorkListBean" ;
		String bean_name				= "eBT.PathologistWorkListBean";
		String order_facility_id="";
		String order_facility_name="";
	
		



		strFacilityId=request.getParameter("OPERATING_FACILITY_ID");
		strPatientId=request.getParameter("PATIENT_ID");

		
		strSysDate		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
		strDateRange = com.ehis.util.DateUtils.minusDate(strSysDate,"DMY",locale,30,"d");

	try
{

	con = ConnectionManager.getConnection(request);

	PathologistWorkListBean bean = new PathologistWorkListBean();
	ArrayList OrderingFacility=bean.getOrderingFacilityId(locale);	

%>
		


<div style="overflow:auto;width:100%;height:auto;">
<table width='100%'  cellpadding='0' cellspacing='0' border='0'>

		<tr>
			<td class='label'><fmt:message key="eBT.LabDept.label" bundle="${bt_labels}"/></td>
			<td class='fields'>
				<select name="lab_dept_name" onchange='callvalidlabdept()' style="width:200;" name="lab_dept" id="lab_dept" id="lab_dept" >
						<option value="">-----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------</option>
		<% 
					
					String lab_dept_section_code="";
					String settingHeader = null;
					Statement stmt = null; 
					ResultSet rs   = null;
					PreparedStatement pstmt		= null;
		try															    
		{  
			String queryApplication = "SELECT SECTION_CODE,LONG_NAME FROM RL_SECTION_CODE";
			stmt = con.createStatement();
			rs	 = stmt.executeQuery(queryApplication);			

			while(rs.next())
			{
				if(lab_dept_section_code.equals(rs.getString(1).toString().trim()) && lab_dept_section_code.equalsIgnoreCase(rs.getString(1).toString().trim()))
				{
					settingHeader = rs.getString(2);
	%>				 
				<option value='<%=rs.getString(1).toString().trim()%>' selected><%=rs.getString(2)%></option> 
	<%
				}
				else
				{
	%>
				<option value='<%=rs.getString(1).toString().trim()%>' ><%=rs.getString(2)%></option> 
	<%
				}
			}
		}
		catch(Exception e1)
		{
			System.out.println("(PathologistWorkListCriteria.jsp:Exception-1) "+e1.toString());
		}
	%>

					</SELECT>
					<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			</td>
					 
			<td class="label" ><fmt:message key="eBT.RegisteredDate.label" bundle="${bt_labels}"/></td>
			<td class='fields'>
				<input type="text" name="date_from" id="date_from" value="<%=strDateRange%>" size="10" maxlength="10" onBlur="chkDateTime(this,'DMY','<%=locale%>');" />
				<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'/>
				<fmt:message key="eBT.RegisteredDateTo.label" bundle="${bt_labels}"/>
				<input type=text name='date_to' id='date_to' value="<%=strSysDate%>" size="10" maxlength="10" onBlur="chkDateTime(this,'DMY','<%=locale%>');" />
				<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'/>
			</td>
			<td class='label'><fmt:message key="eBT.SpecimenNumber.label" bundle="${bt_labels}"/></td>
			<td class="fields">
					<input type='text' name="specimen_number" id="specimen_number" value="" style="width:200;" />
			</td>
		</tr>
			
		<tr>		
			<td class='label'><fmt:message key="eBT.OrderingFacility.label" bundle="${bt_labels}"/></td>
			<td class='fields'>
					<select name="ordering_facility_name" id="ordering_facility_name" style="width:200;">
					<option value="">-----------------All-----------------</option>
					<%
					for (int i=0;i<OrderingFacility.size();i+=2){
						order_facility_id=(String)OrderingFacility.get(i);
						order_facility_name=(String)OrderingFacility.get(i+1);
						if(facilityId.equals(order_facility_id))	{
%>
							<option value='<%=order_facility_id%>'selected><%=order_facility_name%></option>
<%
						}
						else{
%>
		   					<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%						
						}
					}
%>
					</SELECT>
			</td>
			<td class='label'><fmt:message key="eBT.OrderingPractitioner.label" bundle="${bt_labels}"/></td>
			<td class="fields">
				<input type='text'  name="ordering_pract_desc" id="ordering_pract_desc" value="" onBlur='getPractitioner1(this)' size="30" />&nbsp;
				<input type='button' name='search' id='search' value='?'  class='button' onClick="getPractitioner()"/>
				<input type="hidden" name="ordering_pract_code" id="ordering_pract_code" value=''/>
			</td>	
			<td class='label'><fmt:message key="eBT.LabOrderStatus.label" bundle="${bt_labels}"/></td>
			<td class='fields'>
				<select name="" style="width:200;" name="lab_order_status" id="lab_order_status" id="lab_order_status" >
					
					<% 
					
					String lab_order_status="";
		try															    
		{  
			String queryApplication = "SELECT list_elmt_value, list_elmt_label FROM sm_list_item WHERE module_id='BT' AND list_ref='BT_LAB_ORDER_STATUS'";
			stmt = con.createStatement();
			rs	 =	stmt.executeQuery(queryApplication);			

			while(rs.next())
			{
				if(lab_order_status.equals(rs.getString(1).toString().trim()) && lab_order_status.equalsIgnoreCase(rs.getString(1).toString().trim()))
				{
					settingHeader = rs.getString(2);
	%>				 
				<option value='<%=rs.getString(1).toString().trim()%>' selected><%=rs.getString(2)%></option> 
	<%
				}
				else
				{
	%>
				<option value='<%=rs.getString(1).toString().trim()%>' ><%=rs.getString(2)%></option> 
	<%
				}
			}
		}
		catch(Exception e1)
		{
			System.out.println("(PathologistWorkListCriteria.jsp:Exception-1) "+e1.toString());
		}
	%>
				</SELECT>
			</td>
		</tr>
		
		
		<tr>
			<td class='label'><fmt:message key="eBT.PerformingFacility.label" bundle="${bt_labels}"/></td>
			<td class='fields'>
				<input type='text' name='performing_facility_id_name' id='performing_facility_id_name' value='' size="30" onblur='getPerformingFacility1(this)' />
				<input type='hidden' name='performing_facility_id' id='performing_facility_id' value='' />
				<input type='button' value='?' name='performing_facility_buttn' id='performing_facility_buttn' class='button' Onclick='getPerformingFacility();' />
			</td> 
			<td class='label'><fmt:message key="eBT.PatientID.label" bundle="${bt_labels}"/></td>
			<td class='fields'>
				<input type="text" name="Patient_Id" id="Patient_Id" size="30" onKeyPress='return CheckForSpecChars(event)'/>&nbsp;
				<input type="button" name="Patient_Button" id="Patient_Button" value="?" class="button"  onClick="callPatientSearch(document.pathologistWorkListCriteriaForm.Patient_Id)" />	
			</td>		
		</tr>  
		
		
		<tr>
			<td class='label'><fmt:message key="eBT.ReportingFacility.label" bundle="${bt_labels}"/></td>
			<td class='fields'>
					<input type='text' name='reporting_facility_id_name' id='reporting_facility_id_name' value='' size="30"  onblur='getReportingFactility1(this)'  />
					<input type='hidden' name='reporting_facility_id' id='reporting_facility_id' value='' />
					<input type='button' value='?' name='reporting_facility_buttn' id='reporting_facility_buttn' class='button' Onclick=' getReportingFactility();' />
			</td> 
			<td class='label'><fmt:message key="eBT.AssignedPathologist.label" bundle="${bt_labels}"/></td>
			<td class='fields'>
					<input type='text'  name='assigned_red_desc' id='assigned_red_desc' value='' size="30" onBlur='getAssignedPathologist1(this)'/>
					<input type='hidden' name='assigned_red_code' id='assigned_red_code' value=''/>
					<input type='button' name='search' id='search' value='?'  class='button' onClick="getAssignedPathologist()" />
			</td> 	
		</tr>
		
		<tr>
			<td class='label' colspan="5"></td>
			<td align="right" colspan='2'>
				<input type='button' name='Search' id='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class=button onClick="SearchChart('jsp')"/>
				<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class=button onclick="resetCriteria();"/>
			</td>
		</tr> 

</table>
</div>  
<%
}
catch(Exception ee)
{
	ee.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}%>

<input type='hidden' name='locale' id='locale' value ='<%=locale%>'/>
<input type='hidden' name='facilityId' id='facilityId' value ='<%=facilityId%>'/>

</form>
</body>
</html>

