<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	//Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
	String resp_id     = (String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String function_id = (String)session.getAttribute("function_id");
   
 
	//String diag_code="";
	//String diag_desc="";
    String fid = "";
	String fname = "";
	String free_text_applicable_yn = "";
	String pat_length = ""; 


%>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

		<script src="../../eCommon/js/ValidateControl.js"></script>
		<script src="../../eCommon/js/common.js"></script>
		<script src='../js/MRReports.js' language='javascript'></script> 
		<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<script>

	/*function resetValue(){
		document.forms[0].p_frm_term_grp_id.value="";
		document.forms[0].p_to_term_grp_id.value="";

  } */


		
		</script>
<%

	SimpleDateFormat dateFormat1 = new SimpleDateFormat( "dd/MM/yyyy" ) ;
   	String currentdate 		= dateFormat1.format(new java.util.Date()) ;

  Connection con =null;
  ResultSet rs   = null;
  Statement stmt = null;

  con =  ConnectionManager.getConnection(request);
  stmt	= con.createStatement();
    
 

%>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="HAAD_Diseasereport_Form" id="HAAD_Diseasereport_Form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
 
<table border="0" width='60%' cellpadding="4" cellspacing="0"  align='center' >

	

	
		<tr> 
		
			<td class='label'>&nbsp;</td>
            <td class="querydata" nowrap><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
	
	<tr>
		<td class="label"  nowrap ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td class='fields' >		
		<input type='text'  name='P_From_Date' id='P_From_Date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validatePeriod_From_1(this);" maxLength='10'></input><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('P_From_Date');"/><img src='../../eCommon/images/mandatory.gif'>&nbsp;&nbsp;-&nbsp;&nbsp;
		<input type='text'  name='P_To_Date' id='P_To_Date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validatePeriod_To_1(this);" maxLength='10'></input><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('P_To_Date');"/><img src='../../eCommon/images/mandatory.gif'>
		</td> 
 
	</tr>  
	<tr> 
			<td class=label><fmt:message key="eMR.Disease.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<select name="P_DISEASE_ID" id="P_DISEASE_ID" enable_code()" ><option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
				
				<%
					  
					String disease_id   = "";
					String disease_name = "";
					String sql = "select DISEASE_ID,DISEASE_NAME  FROM MR_HAAD_DISEASE_HDR  where EFF_STATUS='E' ORDER BY DISEASE_NAME ";

					rs = stmt.executeQuery(sql);
					
						while( rs.next())
						    {
	        				disease_id = rs.getString("DISEASE_ID") ;
	        				disease_name=rs.getString("DISEASE_NAME");
	        				out.println("<option value='"+disease_id+ "'  >"+disease_name+"</option>");
							}
				%>
						
				</td> 
		
			</tr> 
			<!--	<tr>
            <td class='label'>&nbsp;</td>
            <td class='querydata'><fmt:message key="Common.from.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
          </tr> --> 
			<!--<tr>
			 <td class='label' nowrap>
			 <fmt:message key="eMR.TerminologyGroup.label" bundle="${mr_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>
		
			 	 </td>
             <td class='fields'>
               <input name='p_frm_term_grp_id' id='p_frm_term_grp_id' value='' size='5' maxlength='4' disabled><input type='button' name='fm_diag_button' id='fm_diag_button' value='?' class='button' onclick='searchCodeDischarge(this, p_frm_term_grp_id)' disabled>
               &nbsp;&nbsp;-&nbsp;&nbsp;
               <input name='p_to_term_grp_id' id='p_to_term_grp_id' value='' size='5' maxlength='4' disabled><input type='button' name='to_diag_button' id='to_diag_button' value='?' class='button' onclick='searchCodeDischarge(this, p_to_term_grp_id)' disabled>
             </td>
			
          </tr> -->
		
			
	<input type='hidden' name='CurrentDate' id='CurrentDate' value = "<%=currentdate%>"></input>

    <input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
	<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
	<input type="hidden" name="function_id" id="function_id"		value="NEW_REPORT">


</table> 
</form>
</body>
</html>

