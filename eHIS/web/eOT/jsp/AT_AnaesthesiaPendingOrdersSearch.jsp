<!DOCTYPE html>
<%-- Mandatory declarations start --%>              
<%-- JSP Page specific attributes start --%>
<%@page  import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8"); %>
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

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript"src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="JavaScript" src="../../eOT/js/Slate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--AAKH CRF-0069-->
</head>
<%
	String facility_id	= (String) session.getValue("facility_id");
	String params		= request.getQueryString() ;
	String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
	Connection connection   = null ;
	Statement stmt = null ;
	ResultSet resultSet     = null ;
	String surgery_date		= "",surgery_date2="";//AAKH CRF-0069
	try
	{
		connection			= ConnectionManager.getConnection(request);
		stmt				= connection.createStatement() ;
		resultSet			= stmt.executeQuery(sql_curr_date);
		while(resultSet!=null && resultSet.next()){
		surgery_date =com.ehis.util.DateUtils.convertDate(resultSet.getString("CURRENT_DATE"),"DMY","en",locale);
		surgery_date2 =com.ehis.util.DateUtils.convertDate(resultSet.getString("CURRENT_DATE"),"DMY","en",locale);//AAKH CRF-0069
		}
	}catch ( Exception e ) {
            e.printStackTrace() ;
	}finally {
       try{
   			if(resultSet!=null) resultSet.close();
			if(stmt!=null) stmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
          }catch(Exception es){es.printStackTrace();}
    }
	
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="RecordAnesthesiaDetailsForm" id="RecordAnesthesiaDetailsForm" >
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
<tr>
		<td class='label' width="25%" ><!-- FD-GHL-CRF-0357 -->
			<fmt:message key="eOT.SurgeryDateFrom.Label" bundle="${ot_labels}"/> 
		</td>
		<td class='fields' width="25%">
			<input type="text" name="surgeryDate" id="surgeryDate" size="10" maxlength=10 value="<%=surgery_date%>" onkeypress="return checkForSpecCharsforID(event);" onblur='if(!isValidDate(this)) this.value="";' >
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('surgeryDate');"> 
		</td>
		<!-- AAKH CRF-0069 START-->
		<td class='label' width="25%" ><!-- FD-GHL-CRF-0357 -->
			<fmt:message key="eOT.SurgeryDateTo.Label" bundle="${ot_labels}"/> 
		</td>
		<td class='fields' width="25%">
			<input type="text" name="surgeryDate2" id="surgeryDate2" size="10" maxlength=10 value="<%=surgery_date2%>" onkeypress="return checkForSpecCharsforID(event);" onblur='if(!isValidDate(this)) this.value="";' > 
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('surgeryDate2');"> 
		</td>
	</tr>
	<tr>	
		
			
		<!-- AAKH CRF-0069 END-->			
		<td class='Label' width="25%" >
			<fmt:message key= "eOT.AnaesthesiaOrderedDateFrom.Label" bundle="${ot_labels}"/> 
		</td>
		<td  class='fields' width="25%" >
			<input type="text" name="surgery_date" id="surgery_date" size="10" maxlength=10 onkeypress="return checkForSpecCharsforID(event);" onblur='if(!isValidDate(this)) this.value="";' > 
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('surgery_date');">
		</td>
		
		<!-- AAKH CRF-0069 -->
		<td class='Label' width="25%" >
			<fmt:message key= "eOT.AnaesthesiaOrderedDateTo.Label" bundle="${ot_labels}"/> 
		</td>
		<td  class='fields' width="25%" >
			<input type="text" name="surgery_date2" id="surgery_date2" size="10" maxlength=10 onkeypress="return checkForSpecCharsforID(event);" onblur='if(!isValidDate(this)) this.value="";' > 
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('surgery_date2');">
		</td>	
		<!-- AAKH CRF-0069 -->
</tr>
<tr>
	<td class='Label' width="25%" >
		<fmt:message key="Common.patientId.label" bundle="${common_labels}"/> 
	</td>
		<td class='fields' width="25%" >
			<input type='text' name='patient_id' id='patient_id' size='10' maxlength='10' value='' onkeypress="return checkSpecCharsforID(event);" onBlur="if(this.value!='') callPatSearch();else clearPatientName(); ">
			<input type='button' class='Button' name='patientLookUp' id='patientLookUp' value='?' onClick='callPatSearch();'>
		</td>
	<td class='Label' width="25%" >
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>  
	</td>
	<td class='fields' width="25%" >
		<input name="surgeon_name" id="surgeon_name" size='20' value="" onBlur="if(this.value!='') return searchSurgeon3(surgeon_name);else surgeon_code.value='' ">
		<input type="hidden" name="surgeon_code" id="surgeon_code" value="">
		<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="searchSurgeon3(surgeon_name);">
	</td>
</tr>
<tr>
	<td class='Label' width="25%" >
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>  
	</td>
	<td class='fields' width="25%" >
		<input name='speciality_desc' id='speciality_desc'  size='20' value= ""  onBlur="if(this.value!='') return searchSpeciality3(speciality_desc);else speciality_code.value='' ">
		<input type="hidden" name="speciality_code" id="speciality_code" value="">
		<input type='button' class='button' value='?' name='spcButton' id='spcButton' onClick="searchSpeciality3(speciality_desc);" >
	</td>
	<td class='Label' width="25%" >
			<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> 
	</td>
	<td class='fields' width="25%" colspan="2" >
		<input type='text' name='patient_name' id='patient_name' size='40' value='' readonly>
	</td>
</tr>
<tr>
		<td class='fields' width="25%" ></td><td class='fields' width="25%" ></td><td class='fields' width="25%" ></td>
		<td class='fields' width="25%" >	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="anesthesiaPendingOrders()">
			<!--against AAkH CRF-0069 <input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="funClearAll();">-->
		</td>
	</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<input type='hidden' name='params' id='params' value='<%=params%>' >
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >	
<input type='hidden' name='locale' id='locale' value='<%=locale%>' >	
</form>
</body>
</html>




