<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html> 
<head>
	<%
	String locale = ((String)session.getAttribute("LOCALE"));
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");


%>

    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link   rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
  	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js' > </script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
	<script language='javascript' src='../../eMO/js/MORegDetailsQuery.js'> </script>
	 <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	 
	 
</head>
<body  onMouseDown='CodeArrest();' onload="selarea('Area_Type');document.forms[0].search.click();" onKeyDown="lockKey();">
 <center>
  <form name='AreaAvailForm' id='AreaAvailForm' target='result' >
   <table border='0' cellpadding='3' cellspacing='0' width='100%'>
    <% 
	   String	facility_id =  (String) session.getValue( "facility_id" ) ;
	   Connection con		=	null;
	   Statement	st		=	null;
	   ResultSet	rs		=	null;
	   String short_desc	=   "";
	   String area_code 	=   "";
	   String patient_length=   "";
	   String callfrommoreg =   "";
	   String regno         =   "";
	   String parmeters     ="";
	   String defaultdate1="";
	   String defaultdate2="";
	   String queue_refresh_interval      = "";
	   StringBuffer sql =new StringBuffer();
	   PreparedStatement pstmt			= null;


    try
     {
		 
	   String getdate="select to_char(sysdate,'dd/mm/yyyy') date1	from dual";
       con	 =	(Connection)ConnectionManager.getConnection(request);
       st               = con.createStatement();
	   rs               = st.executeQuery(getdate);
	   while( rs.next())
	   {
	    defaultdate1=rs.getString("date1");
	    defaultdate2=defaultdate1;
	   }
	defaultdate1 = DateUtils.convertDate(defaultdate1,"DMY","en",localeName);
	defaultdate2 = DateUtils.convertDate(defaultdate2,"DMY","en",localeName);
	if(rs!=null)rs.close();
	if(st!=null)st.close(); 
       st	 =	con.createStatement();
       rs=st.executeQuery("select patient_id_length from mp_param");
	   while(rs.next())
	   {
		patient_length = rs.getString(1);
	   }
	   if (rs!=null) rs.close();
	   if (st!=null) st.close();
	   callfrommoreg =request.getParameter("callfrom");
	   if (callfrommoreg==null) callfrommoreg ="";
//out.println("<script>alert('callfrommoreg-- "+callfrommoreg+"')</script>");
	   
	   regno =request.getParameter("param");
	   if (regno==null) regno ="";
	parmeters= request.getQueryString(); 
	   if (parmeters==null) parmeters ="";


	sql.append("select QUEUE_REFRESH_INTERVAL from mo_parameter where facility_id=? ");
	pstmt		      = con.prepareStatement(sql.toString());
	pstmt.setString(1,facility_id);
	rs	          = pstmt.executeQuery();
	if(rs != null)
	{
	while(rs.next())
	{
	
	queue_refresh_interval =rs.getString("QUEUE_REFRESH_INTERVAL");
	if(queue_refresh_interval == null) queue_refresh_interval="0";
	
	} 
	}
	if(rs != null) rs.close();
	if(pstmt!=null) pstmt.close();





	
	%>
	<tr>
	 	 <td class='LABEL' width='25%' ><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>

		 <td class='fields' width='25%'><input type='text' name="registration_no" id="registration_no" value="<%=regno%>" size='20'  maxlength="" onKeyPress="return CheckForSpecChars(event)" onBlur="ChangeToUpper(this)"><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="searchCode(this, registration_no);" ></td>

         <td class='LABEL'  width='25%'  ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>

  		 <td class='fields'  width='25%'><input type='text'  name=patient_id  value="" maxLength='<%=patient_length%>' size='20' onKeyPress="return CheckForSpecChars(event);"><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="callPatient(patient_id);" >	</td>
	</tr>

	<tr>
		 <td class='LABEL'><fmt:message key="eMO.AreaType.label" bundle="${mo_labels}"/></td>

		 <td class='fields'>
	<%if(callfrommoreg.equals("releaseDeceased")||callfrommoreg.equals("ExpoOfDeceased") ||callfrommoreg.equals("RevertRelease")){%>
			<select name='Area_Type' id='Area_Type' disabled onchange ='selarea(this);'>
			<option value='R' selected><fmt:message key="eMO.ReleaseArea.label" bundle="${mo_labels}"/></option></select>
	<%}else{%>
		   <select name='Area_Type' id='Area_Type' onchange ='selarea(this);'>
		   <option value=''>--------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---------------</option>

			<option value='P'><fmt:message key="eMO.PostmortemArea.label" bundle="${mo_labels}"/></option>
			<option value='R'><fmt:message key="eMO.ReleaseArea.label" bundle="${mo_labels}"/></option>
			<option value='S'><fmt:message key="eMO.StorageArea.label" bundle="${mo_labels}"/></option>
			<option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			</select>
		 </td>
    <%}%>
		
	
		<td class='LABEL' ><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name='area_code' id='area_code'>
		<option value=''>--------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---------------</option>
		<% String sqlstr ="";
		 if(callfrommoreg.equals("callfrommoreg"))
			 {
			 sqlstr ="select area_code,short_desc from mo_area_lang_vw where facility_id = '"+facility_id+"' and  language_id='"+locale+"' union select '*' area_code,'"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels")+"' short_desc from dual order by 2  ";
			 }else{
			 sqlstr ="select area_code,short_desc from mo_area_lang_vw where facility_id = '"+facility_id+"' and language_id='"+locale+"' union select '*' area_code,'"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels")+"' short_desc from dual union select '$' area_code,'"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Unregistered.label","mo_labels")+"' short_desc from dual order by short_desc";
			 }

		   st               = con.createStatement();
		   rs               = st.executeQuery(sqlstr);
		   while (rs!=null && rs.next())
		   {
			area_code =rs.getString("area_code");
			short_desc=rs.getString("short_desc");
			%>
				<option value='<%=area_code%>'><%=short_desc%></option>
			
			<%}
			if ( st != null ) st.close() ;
			if ( rs != null ) rs.close() ;
		 }
		catch(Exception e)
		 {
			out.println("Exception in File MORegnDtlsQueryCriteria"+e.toString());
			e.printStackTrace();
		 }
		finally
		 {
			ConnectionManager.returnConnection(con,request);
		 }		
		%>
		</select></td>
	</tr>

	<tr>
		 <td class='LABEL'><fmt:message key="eMO.PostmortemStatus.label" bundle="${mo_labels}"/></td>

		 <td class='fields'><select name='pm_status' id='pm_status' >
		 <option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------</option>
			 <%if(callfrommoreg.equals("releaseDeceased")||callfrommoreg.equals("ExpoOfDeceased")){%>
			 <option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			 <option value='E'><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
			<% }else{%>
			 <option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			 <option value='A'><fmt:message key="eMO.NotRequested.label" bundle="${mo_labels}"/></option>
			 <option value='R'><fmt:message key="Common.Requested.label" bundle="${common_labels}"/></option>
			 <option value='S'><fmt:message key="Common.InProgress.label" bundle="${common_labels}"/></option>
			 <option value='E'><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
			 <%}%>
		 </td>
		
		 <td class='LABEL' ><fmt:message key="eMO.ReleaseStatus.label" bundle="${mo_labels}"/></td>
			 <%if(callfrommoreg.equals("callfrommoreg")||callfrommoreg.equals("callfrommanage")||callfrommoreg.equals("releaseDeceased")||callfrommoreg.equals("callfrombdyprt")){%>

			<td class='fields'><select name='rel_status' id='rel_status' disabled>
			<option value='C'><fmt:message key="eMO.NotReleased.label" bundle="${mo_labels}"/></option>
			</select>

			<%}else if(callfrommoreg.equals("ExpoOfDeceased") || callfrommoreg.equals("RevertRelease")){%>

			<td class='fields'><select name='rel_status' id='rel_status' disabled>
			<option value='R'><fmt:message key="eMO.Released.label" bundle="${mo_labels}"/></option>
			</select>

			<% }else{%>

			<td class='fields'><select name='rel_status' id='rel_status' >
			<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------</option>
			<option value='R'><fmt:message key="eMO.Released.label" bundle="${mo_labels}"/></option>
			<option value='C'><fmt:message key="eMO.NotReleased.label" bundle="${mo_labels}"/></option>
			</select>

			<%}%>
		 </td>
	</tr>

	<tr>
			 <td class='LABEL' ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>

			 <td class='fields' ><input type="text" name="ot_date_time" id="ot_date_time"  onblur='validDateObj(this,"DMY",localeName)' value='<%=defaultdate2%>' size=10 maxlength=10   ><img src='../../eCommon/images/CommonCalendar.gif' id='otdatetime'  name='OTDate' onClick="document.forms[0].ot_date_time.select();return showCalendar('ot_date_time',null,null);"  tabindex=-1 style="cursor='hand'"></img>&nbsp;<img name='mandatory' src='../../eCommon/images/mandatory.gif'></img></td>

			 <td  class='LABEL'><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>

			 <td class='fields'><input type="text"   onblur='validDateObj(this,"DMY",localeName)' value='<%=defaultdate1%>' id='ot_date_time1' name="ot_date_time1" size=10 maxlength=10   value ="" tabindex='13' ><img src='../../eCommon/images/CommonCalendar.gif'  name='OTDate1' onClick="document.forms[0].ot_date_time1.select();return showCalendar('ot_date_time1',null,null);" style="cursor='hand'" tabindex=-1>
			 <img name='mandatory' src='../../eCommon/images/mandatory.gif'></img></td>
			  
	</tr>

	<tr>
		 <td class='LABEL'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>

		 <td class='fields'><select name='gender' id='gender'>
		 <option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		 <option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/> </option>
		 <option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/> </option>
		 <option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/> </option>
		 </select></td>

	 	 <td class='LABEL' ><fmt:message key="eMO.BurialPermitNo.label" bundle="${mo_labels}"/></td>

		 <td class='fields'><input type='text' name="burial_permit_no" id="burial_permit_no" value="" size='16'  maxlength="16" onKeyPress="return CheckForSpecCharsLocal(event);" onBlur="ChangeToUpper(this)"><input type="button" name="burial_permit_srch" id="burial_permit_srch" class=BUTTON value="?" onClick="searchCode1(this, burial_permit_no);" ></td>

	</tr>

	<tr>
		 <td class='LABEL' ><fmt:message key="eMO.BodyPartType.label" bundle="${mo_labels}"/>&nbsp;</td>
  		 <td class='fields'>
			<% 
			  if(callfrommoreg.equals("callfrombdyprt")){%>
			  
			 <select name='obt_frm' id='obt_frm' >
			 <option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------</option>
			 <option value='A'><fmt:message key="eMO.AmputatedBodyPart.label" bundle="${mo_labels}"/></option>
			 <option value='D'><fmt:message key="eMO.DeadFetus.label" bundle="${mo_labels}"/></option>
			 <option value='U'><fmt:message key="eMO.UnidentifiedBodyPart.label" bundle="${mo_labels}"/></option>
			 </select>

			 <%}else {%>

			 <select name='obt_frm' id='obt_frm' disabled >
			 <option value='C'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			 </select>
			 <%}%>
		</td>


		<td class='LABEL' >
		<% 
			  if(callfrommoreg.equals("callfrommanage") || callfrommoreg.equals("releaseDeceased") || callfrommoreg.equals("RevertRelease")  ){%>
			  
			  <fmt:message key="Common.RefreshInterval.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><input type='text' name='queue_refresh_interval' id='queue_refresh_interval' value='<%=queue_refresh_interval%>' maxLength='4' size='2' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chkNumval(this);if(ChkPosNum(this)){checkRangeMax(this);}'>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
		<fmt:message key="Common.MIN.label" bundle="${common_labels}"/>
		
		<%}%>
		</td>	
		
		
		<td colspan='2'>&nbsp;</td>

	</tr>
</table>

<table align='right' cellpadding="0" cellspacing="0" border="0">

	<tr>
		 <td align='right' class='button'>
		 <input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='submitPage();'>
		 <input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onclick='clearAll()'>
		 </td>
	</tr>
	

	<% if(callfrommoreg.equals("callfrommanage") || callfrommoreg.equals("releaseDeceased")  ){%>
	<br><tr>
                    <td  align='right' class='label' nowrap><fmt:message key="Common.LastRefreshTime.label" bundle="${common_labels}"/></td> <td  class='querydata' id="sys_date" ></td>
                </tr>
	<%}%>
		


</table>
	
	     <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
         <input type='hidden' name='callfrommoreg' id='callfrommoreg' value='<%=callfrommoreg%>'>  
		 <input type='hidden' name='parmeters' id='parmeters' value='<%=parmeters%>'>  
		 <input type='hidden' name='queue_refresh_interval1' id='queue_refresh_interval1' value='<%=queue_refresh_interval%>'>  
		 <input type='hidden' name='queryExecute' id='queryExecute' value="deseasedqry">
   <% if(callfrommoreg.equals("callfrommanage") || callfrommoreg.equals("releaseDeceased") ){%>
	<script>
	document.getElementById('sys_date').innerHTML = getCurrentDate("HM","<%=locale%>");	
	</script>
	<%}%>
  </form>
 </center>
</body>


</html>

