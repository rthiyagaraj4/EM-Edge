<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.ArrayList,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager"%>
<%@page  contentType=" text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<% 
	String facility_id=(String)session.getValue("facility_id");
	String called_from = checkForNull(request.getParameter("called_from"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/><link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language="JavaScript" src="../../eOT/js/SurgeryHistory.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="JavaScript">
var count=0;


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%if("OT_SLATE".equals(called_from)){%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload="disableMenuButton()">
<%}else{%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%}%>

<form name="SurgeryHistoryQryCriteriaForm" id="SurgeryHistoryQryCriteriaForm">
<input type="hidden" name="facility_id" id="facility_id" value=<%=facility_id%> >
<input type="hidden" name="called_from" id="called_from" value=<%=called_from%> >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<% 

	String patient_name="";
	String patient_name1="";
	String dob = "";
	String sex = "";
	String oper_num =""; 
	String PatIDLen="";
	
	String SQL="SELECT facility_id,facility_name FROM sm_facility_param WHERE facility_id IN (SELECT facility_id FROM sm_modules_facility WHERE module_id = 'OT')";
	String disable_flag=("OT_SLATE".equals(called_from)||"OPER_REG".equals(called_from))?"disabled":"";
	

	//String SQL1 = "SELECT patient_name from surgery_history where patient_id=?"
	
	ArrayList list = new ArrayList();
    Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst = null;
	ResultSet rst1 = null;
	try{
		con = ConnectionManager.getConnection(request);
		try{
		String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
		pstmt=con.prepareStatement(sqlLen);
		rst=pstmt.executeQuery();
		while(rst.next() && rst!=null)
		{
		PatIDLen   = (rst.getString("PATIENT_ID_LENGTH")==null)?"0":rst.getString("PATIENT_ID_LENGTH");
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		}catch(Exception  ee){}

		pstmt = con.prepareStatement(SQL);
		rst=pstmt.executeQuery();
		while (rst.next()){
			list.add(rst.getString(1));
			list.add(rst.getString(2));
		}
		if(called_from.equals("OT_SLATE") || called_from.equals("OPER_REG") ){
			String sql_1="SELECT PATIENT_NAME,SEX,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH FROM OT_POST_OPER_DETAILS_VW A WHERE OPERATING_FACILITY_ID	=? AND PATIENT_ID=?";
			pstmt1 = con.prepareStatement(sql_1);
			pstmt1.setString(1,facility_id);
			pstmt1.setString(2,patient_id);
			rst1=pstmt1.executeQuery();
				while (rst1.next()){
					patient_name=checkForNull(rst1.getString(1));
					patient_name1=patient_name.replace("'","");//MMHADHOC
					sex=rst1.getString(2);
					//dob=rst1.getString(3);
					//Buddhist date conversion (Thai Locale)
					dob=com.ehis.util.DateUtils.convertDate(rst1.getString(3),"DMY","en",locale);
					
					
				}
		}
	}catch(Exception e){
		 e.printStackTrace();
		 System.err.println("Err Msg in SurgeryHistoryQryCriteria"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(rst1!=null)rst1.close();
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>
<table cellpadding=3 cellspacing="0" border="0" width="100%" align='center'>
<%
	if(called_from.equals("OT_SLATE") || called_from.equals("OPER_REG") ){
		// Hide the Patient Details. 
%>
	<input type='hidden' class="fields" name='patient_id' id='patient_id' size='12' value= "<%=patient_id%>" readonly >
	<input type='hidden' class="fields" name='patient_name' id='patient_name'  size='30' value= "<%=patient_name%>" readonly>
	<input type='hidden' class='button' value='?' name='PatLookUp' id='PatLookUp' onClick="callPatientSearch();" <%=disable_flag%> >
	<input type='hidden' class="fields" name='sex' id='sex'  size='8' value= "<%=sex%>" readonly>
	<input type='hidden' name='date_of_birth' id='date_of_birth' size='10'  width="25%" value='' disabled>
	<input type='hidden' name='surgeon_code' id='surgeon_code' value="">
	<input type='hidden' name='surgeon_desc' id='surgeon_desc' maxlength='15' size='20' value= '' >
	<input type='hidden' class='button' value='?' name='surgeonLookUp' id='surgeonLookUp' onClick="searchSurgeon2(surgeon_desc);">
	<tr>
		<td width="25%" class="label" >
				<fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
		<td width="25%"class="fields"> 
				<select name='fac_id' id='fac_id' <%=disable_flag%> >
				<% 	
					if(list.size()>0){		
					for(int i=0;i<list.size();i+=2){
					 String selected = (facility_id.equals((String)list.get(i)))?"selected":"";
				%>
				<option value="<%=list.get(i)%>" <%=selected%> ><%=list.get(i+1)%>  </option>
				<%}}%>
				</select>
		</td>
		<td class='label' width="25%">
				<fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%">
				<input type='hidden' name='oper_code' id='oper_code' value=''>
				<input type='text' name='oper_desc' id='oper_desc' size='20' onBlur="if(this.value!='') searchOperation2(oper_desc); else oper_code.value=''">
				<input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' onClick="searchOperation2(oper_desc);" >
		</td>
				
	</tr>
	<tr>
		<td width="25%" class='label'>
				<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/> </td>
		<td  width="25%" class="fields">
				<input type='text' name='from_date' id='from_date' size='11'   value=''  maxlength='10' onblur='checkDateFormat(this)'>		
				<img src="../../eCommon/images/CommonCalendar.gif"	
				onClick="return showCalendar('from_date');">
		</td>
		<td  width="25%"  class='label'>
				<fmt:message key="Common.todate.label" bundle="${common_labels}"/> </td>
		<td  width="25%" class="fields">
				<input type='text' name='to_date' id='to_date' size='11'   value=''  maxlength='10' onblur='checkDateFormat(this)'>
				<img src="../../eCommon/images/CommonCalendar.gif" 
				onClick=" return showCalendar('to_date');">
		 </td>
	</tr>
	<tr>
	  <td class="fields" width="25%"></td>  <td class="fields" width="25%"></td>
		<td class="fields" width="25%"></td>
	  <td class="fields" width="25%" colspan='4'>
				<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callSearch();">
				<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' 	onClick="clearForm();" <%=disable_flag%> >
	  </td>
	</tr>

<%
	}else{  // Called from the Menu.. Queries->Surgery History
%>
	<tr>
		<td  width="25%"  class='label'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class="fields" width="25%" >
			<input type='text' name='patient_id' id='patient_id' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onkeypress="return CheckForSpecChars(event)" value= "<%=patient_id%>" onBlur="if(this.value!='')callPatSearch();else clearDesc()"  >
			<input type='button' class='button' value='?' name='PatLookUp' id='PatLookUp' onClick="callPatSearch();" <%=disable_flag%> >
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td  width="25%"  class='label'>
			<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width="25%">
			<input type='text' name='patient_name' id='patient_name'  size='30' value= "<%=patient_name%>" readonly>
		</td>
	</tr>
	<tr>
		<td  width="25%"  class='label'>
			<fmt:message key="Common.gender.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width="25%">
			<input type='text' name='sex' id='sex' size='12'  align='right' value='<%=sex%>' disabled>
		</td>
		<td  width="25%"  class='label'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%">
			<input type='text' name='date_of_birth' id='date_of_birth' size='10'  align='right' value='' disabled>
		</td>
</tr>
<tr>
		<td  width="25%"  class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
		<td class="fields" width="25%"> 
		<select name='fac_id' id='fac_id' <%=disable_flag%> >
			<% 	
				if(list.size()>0){		
				for(int i=0;i<list.size();i+=2){
				 String selected = (facility_id.equals((String)list.get(i)))?"selected":"";
			%>
		<option value="<%=list.get(i)%>" <%=selected%> ><%=list.get(i+1)%>  </option>
			<%}}%>
		</select>
		</td>
	
		<td  width="25%"  class='label'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%">
			<input type='hidden' name='surgeon_code' id='surgeon_code' value="">
			<input name='surgeon_desc' id='surgeon_desc' maxlength='15' size='20' value= '' onBlur="if(this.value!='') searchSurgeon2(surgeon_desc); else surgeon_code.value=''">
			<input type='button' class='button' value='?' name='surgeonLookUp' id='surgeonLookUp' onClick="searchSurgeon2(surgeon_desc);">
		</td>
	</tr>
	<tr>
		<td  width="25%"  class='label'>
			<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/> 
		</td>
		<td class="fields" width="25%">
			<input type='text' name='from_date' id='from_date' size='11'   value=''  maxlength='10'  onblur='checkDateFormat(this)'>		
			<img src="../../eCommon/images/CommonCalendar.gif"	
			onClick="return showCalendar('from_date');">
		</td>
	<td  width="25%"  class='label'>
			<fmt:message key="Common.todate.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width="25%">
				<input type='text' name='to_date' id='to_date' size='11'   value=''  maxlength='10' onblur='checkDateFormat(this)'>
				<img src="../../eCommon/images/CommonCalendar.gif" 
				onClick=" return showCalendar('to_date');">
		 </td>

</tr>
<tr>
	<td  width="25%"  class='label'>
		<fmt:message key="Common.operation.label" bundle="${common_labels}"/>  
	</td>
	<td class="fields" width="25%">
		<input type='hidden' name='oper_code' id='oper_code' value=''>
		<input type='text' name='oper_desc' id='oper_desc' size='20' onBlur="if(this.value!='') searchOperation2(oper_desc); else oper_code.value=''">
		<input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' onClick="searchOperation2(oper_desc);" >
	</td>
	  <td  width="25%" ></td>
	  <td  width="25%"  >
			<input type="button"  name="search" id="search" class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callSearch();">
			<input type="button"  name="clear" id="clear" class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearForm();" <%=disable_flag%> >
	  </td>
	</tr>
<%
	}
%>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<% 
if(called_from.equals("OPER_REG") || called_from.equals("OT_SLATE") ){
	 out.println("<script>autoCall('"+patient_id+"','"+patient_name1+"','"+dob+"','"+sex+"')</script>");
	}

%>

</form>
</body>
</html>

