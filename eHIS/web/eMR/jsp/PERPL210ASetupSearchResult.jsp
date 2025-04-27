<!DOCTYPE html>
<!--Created by Ashwini on 03-Sep-2020 for ML-MMOH-CRF-1351-->
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	    <script src='../js/PERPL210ASetup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%
		Connection con = null;
		String facility_id = checkForNull((String)session.getValue("facility_id"));
		String Checked_yn = "";
        
		try
		{
			con	= ConnectionManager.getConnection(request);	

			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			
			String class_val		= "QRYEVEN";	
			String service_list		= checkForNull(request.getParameter("service_list"));
			
		%>
</head>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			
	<form name='PERPL210ASetupResultForm' id='PERPL210ASetupResultForm' action="../../servlet/eMR.PERPL210ASetupServlet" method='post' target='messageFrame'>

<%
		JSONObject json = new JSONObject();
		JSONArray clinicListjsonArr = new JSONArray();
		json = eMR.MRCommonBean.getEDOBClinicList(con, service_list, facility_id);
		int noOfRecords	= 0;
		noOfRecords	= (Integer) json.get("noOfRecords");

		if(noOfRecords == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		else
		{
%>
			<table cellspacing='0' cellpadding='0' align='center' width='90%' border='1' style='margin-left:5px;'>	
				<tr>
					<td width='20%' height="20" class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='60%' height="20" class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='20%' height="20" class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.Select.label" bundle="${common_labels}"/>&nbsp;</td>
				</tr>		
<%
				clinicListjsonArr = (JSONArray)json.get("clinicListArray");
				for(int i = 0 ; i < clinicListjsonArr.size() ; i++) 
				{
					JSONObject clinicListObj	= (JSONObject)clinicListjsonArr.get(i);
					String clinic_code			= (String) clinicListObj.get("clinic_code");
					String short_desc			= (String) clinicListObj.get("short_desc");
					String check_yn				= (String) clinicListObj.get("check_yn");

					if(("Y").equals(check_yn))
					{
						Checked_yn = "checked";
					}else
					{
						Checked_yn = "";
					}

					if ( (i+1) % 2 == 0 )
						class_val = "QRYODD";
					else
						class_val = "QRYEVEN";
%>
					<tr>
						<td width='20%' class='<%=class_val%>' nowrap><%=clinic_code%></td>
						<td width='60%' class='<%=class_val%>' nowrap><%=short_desc%></td>
						<td width='20%' class='<%=class_val%>' style='text-align:center;'><input type='checkbox' name='inc<%=i%>' id='inc<%=i%>' value='<%=check_yn%>' onClick='funCheck(this,clinic_code<%=i%>);' <%=Checked_yn%>></td>
						<input type="hidden" name="clinic_code<%=i%>" id="clinic_code<%=i%>" value="<%=clinic_code%>">
					</tr>
<%
				}
%>
			</table>
			<input type ='hidden' name ='facility_id' value ='<%=facility_id%>'>
			<input type ='hidden' name ='service_list' value ='<%=service_list%>'>
			<input type ='hidden' name ='maxrecord' value ='<%=noOfRecords%>'>
<%
		}
%>	
	</form>

</body>

<%			
		}catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
%>

</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
	}
%>

