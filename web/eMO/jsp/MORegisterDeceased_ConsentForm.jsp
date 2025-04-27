<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>

	<%
	request.setCharacterEncoding("UTF-8");
	String consent_received_desc="";
	String patient_id="";
	String title=request.getParameter("title");
     String sStyle	=    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<title><%=title%></title>
<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>    
	  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>	
	<script src='../../eMO/js/MORegisterAttn.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
</head>
<%
	Connection con            = null;
	PreparedStatement pstmt   = null;
	ResultSet rs              = null;
		
	String code = "";
	String sys_date="";
	String body_received_date_time="";
	String conscentgivenby="";
    String deceasedrelationship="";
    String consent_received_by="";
    String consent_received_date="";
	String mode="";
	String locale = (String)session.getAttribute("LOCALE");
    String facilityId	= (String)session.getValue("facility_id");
	conscentgivenby = request.getParameter("conscentgivenby")==null?"":request.getParameter("conscentgivenby");
	out.println(mode);
	mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	if(mode.equals("viewdata"))mode="disabled";
	
	deceasedrelationship = request.getParameter("deceasedrelationship")==null?"":request.getParameter("deceasedrelationship");
	consent_received_date = request.getParameter("consent_received_date")==null?"":request.getParameter("consent_received_date");

	//if(consent_received_date!=null && !consent_received_date.equals(""))	
		//consent_received_date = DateUtils.convertDate(consent_received_date,"DMYHM","en",localeName); 	
	
	consent_received_by = request.getParameter("consent_received_by")==null?"":request.getParameter("consent_received_by");
	   
	consent_received_desc = request.getParameter("consent_received_desc")==null?"":request.getParameter("consent_received_desc");
					
 con = ConnectionManager.getConnection(request);
%>

<body OnMouseDown='CodeArrest()' onUnLoad="" onLoad="FocusFirstElement();populatedetails();dispdetails();" onKeyDown = 'lockKey()'>
 <form name='service_form' id='service_form'  method='post' target='messageFrame'>
	<table border='0' cellpadding='3' cellspacing='0'  width='100%' align='center'>
 
		<tr>
			<td class='label' width='50%'><fmt:message key="eMO.ConsentGivenBy.label" bundle="${mo_labels}"/></td>
			<td class='fields' width='50%'><INPUT TYPE="text" name="conscentgivenby" id="conscentgivenby" <%=mode%> maxlength=30     value="<%=conscentgivenby%>"><img src='../../eCommon/images/mandatory.gif'align='center' id=id1 ></img></td>
		</tr>

		<tr>
			<td class='label'><fmt:message key="eMO.RelnWithDeceased.label" bundle="${mo_labels}"/></td>
			<td class='fields'><SELECT name="deceasedrelationship" id="deceasedrelationship"  <%=mode%>><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	<% 
	   pstmt = con.prepareStatement("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_VW where LANGUAGE_ID='"+locale+"' and eff_status='E' order by 2");
	   rs=pstmt.executeQuery();
	  
	   while(rs.next())
	   {  if(rs.getString("RELATIONSHIP_CODE").equals(deceasedrelationship))
		   {
		   %>
			
			<option selected value='<%=rs.getString("RELATIONSHIP_CODE")%>'><%=rs.getString("SHORT_DESC")%></option>
		 <% }%>
			<option value='<%=rs.getString("RELATIONSHIP_CODE")%>'><%=rs.getString("SHORT_DESC")%></option>
		 	
			
			
		<%	}
			 if(rs!=null) rs.close();
			 if(pstmt!=null) pstmt.close();
					
	 			%>
	
	
	
	</SELECT><img src='../../eCommon/images/mandatory.gif'align='center' id=id2 ></img></td>
	</tr>
	
	<tr>
		<td class='label'><fmt:message key="Common.ConsentForm.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name='consent_code' id='consent_code' onchange='dispdetails()'  <%=mode%>>
		<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
				<%
				try
				{
					 patient_id = request.getParameter("patient_id");
					 if(patient_id==null || patient_id.equals("null"))patient_id="";
					 sys_date = request.getParameter("sys_date")==null?"":request.getParameter("sys_date");
					 body_received_date_time = request.getParameter("body_received_date_time")==null?"":request.getParameter("body_received_date_time");					
		             
					
					String sql1="select CONSENT_FORM_CODE from MO_CONSENT_FORM_lang_vw where LANGUAGE_ID='"+locale+"' and eff_status='E'";
					
					
					pstmt = con.prepareStatement(sql1);
					rs=pstmt.executeQuery();
					

					while(rs.next())
					{
					code = rs.getString(1);
					%>
					<option value='<%=code%>'><%=code%></option>
				 <% }
					 if(rs!=null) rs.close();
					 if(pstmt!=null) pstmt.close();
					
	 			%>
					</select><img src='../../eCommon/images/mandatory.gif'align='center' id=id3 ></img>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class='fields'><TEXTAREA id='TEXTAREA1' cols='40' rows='10'	 name='terms_desc' id='terms_desc' readonly onKeyPress=""  ></TEXTAREA>
		</tr>	

		<tr>
			<td class='label'><fmt:message key="eMO.ConsentFormReceivedBy.label" bundle="${mo_labels}"/></td>
			<td class='fields'><input type="text" name="consent_received_desc" id="consent_received_desc" <%=mode%> value="<%=consent_received_desc%>" size="30" maxlength="30" onBlur='beforeGetPractitioner(document.forms[0].pract_id,this); '><input type='button' name='pract_id' id='pract_id'  <%=mode%> value='?' class='button' onclick='searchCode(this, consent_received_desc)'>
	        <input type='hidden' name='consent_received_by' id='consent_received_by' value ="<%=consent_received_by%>"><img id='id4' src='../../eCommon/images/mandatory.gif' align='center'   >
			</td>
        </tr>
		<tr>
			 <td class='label' ><fmt:message key="eMO.ConsentFormReceivDate.label" bundle="${mo_labels}"/></td>
			 <td class='fields'><input type=text name="consent_received_date" id="consent_received_date"    value="<%=consent_received_date%>" onblur="if(validDateObj(this,'DMYHM',localeName)){chkWithSysDt(this);chkWithDates(this,'CFD');}" <%=mode%> size=16 maxlength=16 ><img id='image1' <%=mode%>  src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].consent_received_date.select();return showCalendar('consent_received_date', null, 'hh:mm' );" style="cursor='hand'"><img id='id5' src='../../eCommon/images/mandatory.gif' align='center'   ></td>
		</tr>
        <tr>
			<td class='LABEL'></td>  
			<td class='button' align='right'><input type="button" name="Close" id="Close" class='BUTTON' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="closeme()"></td>
		</tr>
   	</table>
<% }
				  catch(Exception e){
					 e.printStackTrace();
				  }
				  finally
                  {
       		
		          ConnectionManager.returnConnection(con,request);
                  }%>
   	<input type='hidden' name='system_date' id='system_date' value ='<%=sys_date%>'>
	<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">
	<input type='hidden' name='body_received_date_time' id='body_received_date_time' value ='<%=body_received_date_time%>'>
	 
	</form>
   	</body>
   	</html>

