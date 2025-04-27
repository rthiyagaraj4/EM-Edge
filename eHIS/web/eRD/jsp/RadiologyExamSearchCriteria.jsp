<!DOCTYPE html>
<%
/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735       PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
*/
%>
<%@page import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*, eRD.* ,eRD.Common.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>Radiology Exam Result Entry 
		
</title>
	<%
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties properties = (Properties)session.getValue("jdbc");
	String locale	= (String) properties.getProperty("LOCALE");
	String User	= (String) properties.getProperty("login_user");

	 String bean_id					= "RadiologyExamBean" ;
		String bean_name				= "eRD.RadiologyExamBean";
		RadiologyExamBean bean	= (RadiologyExamBean)getBeanObject( bean_id, bean_name , request) ;
		ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
		String curr_sys_date			= "";
		String last_month_date			= "";
		String last_week_date			= "";
		String sys_time_sec				= "";
		for(int i=0;i<sysdate.size();i++){
			curr_sys_date	= (String)sysdate.get(0);
			last_month_date = (String)sysdate.get(4);
			sys_time_sec	 = (String)sysdate.get(5);
			last_week_date = (String)sysdate.get(1);

		}
	    if(curr_sys_date.equals("null") || curr_sys_date.equals(" ")) curr_sys_date="";
		if(last_month_date.equals("null") || last_month_date.equals(" ")) last_month_date="";
		
		System.err.println(last_week_date);

	    curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",localeName);
	    last_month_date = com.ehis.util.DateUtils.convertDate(last_month_date,"DMY","en",localeName);
	    String facilityId = (String)session.getValue("facility_id");
		
		String order_facility_id="";
		String order_facility_name="";
		ArrayList OrderingFacility=bean.getOrderingFacilityId(locale);
		Connection con = ConnectionManager.getConnection();
		String rad_id="";
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
			
		try
		{
			pstmt1=con.prepareStatement("select * from am_practitioner_lang_vw where practitioner_id in (select func_role_id from sm_appl_user where upper(appl_user_id) = upper('"+User+"'))");	

			
			System.err.println("User "+User);
			System.err.println("locale "+locale);
			
			rs1 = pstmt1.executeQuery();
			while(rs1.next()) {
				rad_id =checkForNull(rs1.getString(1));
				System.err.println("rad_id--"+rad_id);
				}
		}catch(Exception e)
		{
			System.out.println("Exception while retriving radiologistid :"+e);
		}finally{
			ConnectionManager.returnConnection(con, request);
			
		}
		 
		
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src='../../eCommon/js/CommonLookup.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eOR/js/TeleRadiologyOrders.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/RadiologyExam.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%!
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
%>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="disableSearch('disable');SearchRadChart('RadExam')">
<form name ="radilogyExamCriteriaForm" >
<table border="0" cellspacing="0" id='tbId' width="100%" bordercolor=white>
<tr><td class=label  nowrap><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<select name="ordering_facility_name" id="ordering_facility_name" id="ordering_facility_name" style="width:200;"  >
		<option value="">-----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------</option>
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
		<td class=label  nowrap><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
		<td class="fields">
			<input type='text' size='30' maxlength='15' name='Reg_no' id='Reg_no' value="" onKeyPress='return CheckForSpecChars(event)' />
		</td> 
		<td class=label  nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td> 
		<td class="fields">
			<SELECT name="urgency_ind_criteria" id="urgency_ind_criteria" style="width:100;" >
				<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="eRD.stat.label" bundle="${rd_labels}"/></option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
				<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td> 
	</tr>

	<tr>
	
		<td class=label  nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class="fields">
			<input type='hidden' name='order_type' id='order_type' value=""/>
			<input type='text' size= 30 name='order_type_desc' id='order_type_desc' value="" onBlur="callordertypeSearch1(this);"  maxlength='' />
			<input type="button" name="ordertypesearch" id="ordertypesearch" value='?'  class="button"  onClick="callordertypeSearch();"/>
		</td>	
		<td class=label nowrap><fmt:message key="eRD.Exam.label" bundle="${rd_labels}"/></td>
		<td class="fields"><input type=text name='catalog' id='catalog' value='' size="30" >
			<SELECT name="catalog_search_criteria" id="catalog_search_criteria">
				<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		<td class="label" ><fmt:message key="eOR.ExamStatus.label" bundle="${or_labels}"/></td>
		<td class='fields' >
			<SELECT name="exam_search_criteria" id="exam_search_criteria" style="width:100;">
				<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
				<option value='D' selected><fmt:message key="Common.Pending.label" bundle="${common_labels}"/> </option>
				<option value='H'><fmt:message key="eOR.OnHold.label" bundle="${or_labels}"/> </option>
				<option value='P'><fmt:message key="eOR.Prelim.label" bundle="${or_labels}"/> </option>
				<option value='F'><fmt:message key="Common.Finalized.label" bundle="${common_labels}"/></option>
				<option value='M'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
	</tr>
	<tr>
		<td class=label  nowrap><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<input type='hidden' name='performing_facility_id' id='performing_facility_id' value='' />
			<input type='text' name='performing_facility_id_name' id='performing_facility_id_name' value='' size=30   onblur='getPerformingFacility1(this)' />
			<input type='button' value='?' name='performing_facility_buttn' id='performing_facility_buttn' class='button' Onclick='getPerformingFacility();'/>
		</td> 
		<td class=label  nowrap><fmt:message key="Common.Performed.label" bundle="${common_labels}"/> <fmt:message key="Common.by.label" bundle="${common_labels}"/>
		<td class='fields' >
			<input type='hidden' name='performed_by_code' id='performed_by_code' value=""/>
			<input type='text' size=30 name="performed_by" id="performed_by" value="" onBlur="checkRec(this)" />
			<input type='button' class='button' value='?'  name='search_ref' id='search_ref' onClick="getServiceCode1(this)"/>
	    </td>
	    <td class=label ><fmt:message key="eRD.Registrationdate.label" bundle="${rd_labels}"/> </td>
		<td class="fields" nowrap>
			<input type="text" name="date_from" id="date_from" value="<%=last_week_date%>" size="10" maxlength="10" onBlur="chkDateTime(this,'DMY','<%=locale%>');" />
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'/><img align="center" src="../../eCommon/images/mandatory.gif"></img>&nbsp;&nbsp;&nbsp;
			<fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;
			<input type=text name='date_to' id='date_to' value="<%=curr_sys_date%>" size="10" maxlength="10" onBlur="chkDateTime(this,'DMY','<%=locale%>');" />
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'/><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>			
	</tr>
	<tr>
		<td class=label  nowrap><fmt:message key="Common.RepFacility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<input type='hidden' name='reporting_facility_id' id='reporting_facility_id' value='' />
			<input type='text' name='reporting_facility_id_name' id='reporting_facility_id_name' value='' size= 30   onblur='getReportingFactility1(this)'  />
			<input type='button' value='?' name='reporting_facility_buttn' id='reporting_facility_buttn' class='button' Onclick=' getReportingFactility();' />
		</td> 
		<td class=label  nowrap><fmt:message key="Common.Assigned.label" bundle="${common_labels}"/> <fmt:message key="eOR.radiologist.label" bundle="${or_labels}"/></td>
		<td class='fields'  >
				<input type='text'  name="assigned_red_desc" id="assigned_red_desc" value="<%=User%>" disabled onBlur="getRadiologist1(this)" size='33' />
				<input type="hidden" name="assigned_red_code" id="assigned_red_code" value='<%=rad_id%>'/>
		</td> 	
		<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields' >
			<input type="text" name="Patient_Id" id="Patient_Id" size="30" maxlength="30" onKeyPress='return CheckForSpecChars(event)'/>
			<input type="button" name="Patient_Button" id="Patient_Button" value="?" class="button"  onClick="callPatientSearch(document.radilogyExamCriteriaForm.Patient_Id)" />
		</td>
	</tr>
	<tr>
		<td class='label' colspan="5"></td>
		<td align="right" colspan='2'>
			<input type='button' name='Search' id='Search' id='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick="disableSearch('disable');SearchRadChart('RadExam')"/>
			<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick="resetCriteria();"/>
		</td>
	</tr> 
</table>
<input type='hidden' name='locale' id='locale' value ='<%=locale%>'/>
<input type='hidden' name='facilityId' id='facilityId' value ='<%=facilityId%>'/>
<input type='hidden' name='current_date' id='current_date' value ='<%=curr_sys_date%>'/>
</form>
</body>
</html>

