<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eCA.*,eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page  import="java.util.*,eOR.* ,eCA.Common.*,eCommon.XSSRequestWrapper"%>
<html>
<head>
<%
Connection con 		= null;
PreparedStatement pstmt 	= null;
ResultSet rs = null;
	String locale = ((String)session.getAttribute("LOCALE"));
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
  	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js' > </script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
	<script language='javascript' src='../../eCA/js/ConsultationTagging.js'> </script>	
	<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>	
</head>
<html>
<head>
	<title><fmt:message key="eCA.RelatedPatientHistoryCriteria.label" bundle="${ca_labels}"/></title>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	%>
			<body OnMouseDown='CodeArrest()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		 	<form name='consultationTagQuery2Frm' id='consultationTagQuery2Frm' method='post' target='messageFrame' action='../../servlet/eCA.ConsultationTaggingServlet'>
<table cellpadding="3" cellspacing="0" border="0" width="100%" align="center">
			  	 <%
			  	 try{
			  	 	  	 	  	     String mode="";
			  	 	  	 	  	     String	option_id="";
			  	 	  	 	  	     String patient_id="";
			  	 	  	 	  		 String	facility_id				 =  (String) session.getValue( "facility_id" ) ;
			  	 	  	 			 patient_id				 =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			  	 	  	 			 String disableString="";
			  	 	  	 			 String	visit_adm_date =  request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
			  	 	  	 			 String	encounter_id =  request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			  	 	  	 			 String clinicianId =(String)session.getValue("ca_practitioner_id");
			  	 	  	 			 option_id =  request.getParameter("option_id")==null?"":request.getParameter("option_id");
			  	 	  	 			 String	mode1 =  request.getParameter("mode1")==null?"":request.getParameter("mode1");
			  	 	  	 			 String spl_code="";
			  	 	  	 			 String spl_description="";
			  	 	  	 			 String getCurrentDate="";
			  	 	  	 			 String disable="";
			  	 	  	 			 String speciality_code="";
			  	 	  	 			 String tag_practitioner_id="";
			  	 	  	 			 String start_date="";
			  	 	  	 			 String end_date="";
			  	 	  	 			 String splCode="";
			  	 	  	 			 String spl_desc="";
			  	 	  	 			 String tag_pract_id="";
			  	 	  	 			 String tag_pract_desc="";
			  	 	  	 			 
			  	 	  	 		     start_date= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		  	 	  	 				 end_date = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);

		  	 	  	 			        if("CONSULT_TAGGING".equals(option_id))
			  	 	  	 			    visit_adm_date = com.ehis.util.DateUtils.formatDate(visit_adm_date,"DMYHMS","DMYHM",locale);

                                        String spltCode = (request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"));
			
			  	 	  	                try{
			  	 	  	 		  	    String practSPLQry ="SELECT primary_speciality_code spl_code,SHORT_DESC spl_desc FROM am_practitioner d,am_speciality_lang_vw e  WHERE d.practitioner_id =? AND d.PRIMARY_SPECIALITY_CODE=e.SPECIALITY_CODE AND e.EFF_STATUS ='E' AND e.LANGUAGE_ID=?";
			  	 	  	 				con = ConnectionManager.getConnection(request);
			  	 	  	 		  	    pstmt = con.prepareStatement(practSPLQry);
			  	 	  	 				pstmt.setString(1,clinicianId);
			  	 	  	 				pstmt.setString(2,locale);
			  	 	  	 				rs = pstmt.executeQuery();

			  	 	  	 				if(rs.next())
			  	 	  	 				{
			  	 	  	 				splCode = rs.getString("spl_code")==null?"":rs.getString("spl_code");
			  	 	  	 			    spl_description	= rs.getString("spl_desc")==null?"":rs.getString("spl_desc");
			  	 	  	 				}
			  	 	  	 	} catch (Exception e) {
			  	 	  	 		e.printStackTrace();
			  	 	  	 	} finally {
			  	 	  	 		if (rs != null) rs.close();
			  	 	  	 		if (pstmt != null) pstmt.close();
			  	 	  	 	}

			  	 	  	if(mode1.equals("modify")){
			  	 	  	 disable = "Disabled";
			  	 	    option_id = request.getParameter("option_id") == null ? "": request.getParameter("option_id");
			  	 	  	patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			  	 		speciality_code = request.getParameter("speciality_code") == null ? "": request.getParameter("speciality_code");
			  	 		tag_practitioner_id = request.getParameter("tag_practitioner_id") == null ? "": request.getParameter("tag_practitioner_id");
			  	 		start_date = request.getParameter("start_date") == null ? "" : request.getParameter("start_date");
			  	 		end_date = request.getParameter("end_date") == null ? "" : request.getParameter("end_date");
			  	 		encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
			  	 		visit_adm_date = request.getParameter("visit_adm_date") == null ? "" : request.getParameter("visit_adm_date");

			  	 		String comp_desc = "SELECT speciality_code,short_desc FROM am_speciality where speciality_code=?";

			  	 		pstmt = con.prepareStatement(comp_desc);
			  	 		pstmt.setString(1, speciality_code);
			  	 		rs = pstmt.executeQuery();
			  	 		while (rs.next()) {
			  	 			splCode = rs.getString("speciality_code") == null ? "" : rs.getString("speciality_code");
			  	 			spl_description = rs.getString("short_desc") == null ? "" : rs.getString("short_desc");
			  	 		}
			  	 		if (pstmt != null)
			  	 			pstmt.close();
			  	 		if (rs != null)
			  	 			rs.close();
			  	 		String comp_desc1 = "SELECT practitioner_id, practitioner_name FROM am_practitioner  where practitioner_id=?";

			  	 		pstmt = con.prepareStatement(comp_desc1);
			  	 		pstmt.setString(1, tag_practitioner_id);
			  	 		rs = pstmt.executeQuery();
			  	 		while (rs.next()) {

			  	 			tag_pract_id = rs.getString("practitioner_id") == null ? "" : rs.getString("practitioner_id");
			  	 			tag_pract_desc = rs.getString("practitioner_name") == null ? "" : rs.getString("practitioner_name");
			  	 		}

			  	 		if (pstmt != null)
			  	 			pstmt.close();
			  	 		if (rs != null)
			  	 			rs.close();

			  	 	} else {
			  	 		mode = "insert";
			  	 	}
			  	 %>
<br>
<tr>
<td class='label' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
<td class='fields'><input type="hidden" name="splCode" id="splCode" value='<%=splCode%>'><input type="text" name="splName" id="splName"  nowrap size='16' maxlength='20' onblur='getSpecialtyCall(this);setTagPractitioner();' OnChange='resetValues()' value="<%=spl_description%>" <%if(mode1.equals("modify")){  %> <%=disable%> <%}%>><input type="button" value="?" class="button" name='splSearch' id='splSearch' onblur='setTagPractitioner();' onClick='getSpecialty1();' <%if(mode1.equals("modify")){  %> <%=disable%>  <%}%>>
<img src='../../eCommon/images/mandatory.gif'></td>

<td class="label" nowrap><fmt:message key="eCA.TaggedPractitioner.label" bundle="${ca_labels}"/></td>
<td class='fields'><input type='hidden' name='practitionerId' id='practitionerId' value=''><input type='text' name='practitioner_desc' id='practitioner_desc' value="<%=tag_pract_desc%>" nowrap size=16 maxlength=35 <%if(mode1.equals("modify")){  %> <%=disable%>  <%}%>><input type='button' name='practitioner_button' id='practitioner_button' class='button' value='?' onClick='show_practtioner_window(document.getElementById("practitioner_desc"));' <%if(mode1.equals("modify")){  %> <%=disable%>  <%}%>>
<img src="../../eCommon/images/mandatory.gif"></td>	
</tr>		
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>

<tr>

<td class='LABEL' width='16%'><fmt:message key="eCA.StartDateTime.label" bundle="${ca_labels}"/></td>	
<td class='fields'>	<input type='text' name='start_Date' id='start_Date' id='startDate' value='<%=start_date%>' size='18' maxlength='17' OnBlur='CheckDateTimefrom(this,"<%=locale%>","<%=visit_adm_date%>");' OnKeyPress='return CheckForNumsAndColon(event)' ><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('start_Date');">
<img align='center'  src='../../eCommon/images/mandatory.gif'> 
</td>
   
 
<td class='LABEL' width='16%'><fmt:message key="eCA.EndDateTime.label" bundle="${ca_labels}"/></td>
<td class='fields'><input type='text' name='end_Date' id='end_Date' id='enddate' value='<%=end_date%>' size='18' maxlength='17' OnBlur='CheckDateTimeTo(this,start_Date,"<%=locale%>","<%=visit_adm_date%>");' OnKeyPress='return CheckForNumsAndColon(event)' ><img type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('end_Date');"><img align='center'  src='../../eCommon/images/mandatory.gif'> 
</td>

</tr>
<tr>
<td></td><td></td><td></td>
<td align='right' class='button'>
					
					  <input type='button' name='record' id='record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class='button' onClick='apply();'>
                      <% 
					if("modify".equals(mode1))
					{
					%>
					<input type='button' name='delete' id='delete' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class='button' onClick='deleteRecord();'>
				   <%}%>
                      <input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearAll();'>
					</td>
					</tr>
				</table>
				  <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
				  <input type='hidden' name='clinicianId' id='clinicianId' value='<%=clinicianId%>'>  
				  <input type='hidden' name='language_id' id='language_id' value='<%=locale%>'>
				  <input type='hidden' name='specialty_code' id='specialty_code' value='<%=spl_code%>'>  
				  <input type='hidden' name='visit_adm_date1' id='visit_adm_date1' value='<%=visit_adm_date%>'>
				  <input type='hidden' name='loginPract' id='loginPract' value='<%=clinicianId%>'>
				  <input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
				  <input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
				  <input type="hidden" name="prac_sql" id="prac_sql" value="<%=CaRepository.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_ADMIN2")%>">
                  <input type="hidden" name="prac_sql1" id="prac_sql1" value="<%=CaRepository.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2_ADMIN2")%>">
                  <input type='hidden' name='mode1' id='mode1' value='<%=mode1%>'>
                  <input type='hidden' name='tag_practitioner_id' id='tag_practitioner_id' value='<%=tag_practitioner_id%>'> 
                  <input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>  
          		  <input type='hidden' name='option_id' id='option_id' value='<%=option_id%>'>
          			  
		</form>	
	
	</body>
</html>
<% 
}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
			  	%>

