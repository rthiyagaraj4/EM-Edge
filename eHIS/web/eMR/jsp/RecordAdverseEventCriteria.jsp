<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src='../../eCommon/js/messages.js' ></script>
  <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script>
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
  <script language='javascript' src="../js/RecordAdverseEventCriteria.js"></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
  String p_user_name		= (String) session.getValue( "login_user" ) ;
  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs   = null;
  Statement stmt = null;
  String pat_id_length = "";
	try 
	{
		String jsp_name =request.getParameter("jsp_name");
		if( jsp_name == null) jsp_name="";
		String window_styl=request.getParameter("window_styl");
		if( window_styl == null) window_styl="";
		String close_yn	=request.getParameter("close_yn");
		if( close_yn == null) close_yn="";
		String win_top =request.getParameter("win_top");
		if( win_top == null) win_top="";
		String win_height =request.getParameter("win_height");
		if(win_height ==null) win_height="";
		String win_width =request.getParameter("win_width");
		if( win_width == null) win_width="";
		
		String call_function=request.getParameter("call_function");
		if(call_function == null) call_function="";		
		String modal=request.getParameter("modal");
		if(modal == null) modal="";			
		String dialogTop =request.getParameter("dialogTop");
		if(dialogTop ==null) dialogTop="";			
		//module=ph
		String module=request.getParameter("module");
		if(module == null) module="";
		String model_window=request.getParameter("model_window");
		if( model_window == null) model_window="";
		
		String function_id=request.getParameter("function_id");
		if( function_id == null) function_id="";
		
		String prog_id=request.getParameter("prog_id");
		if( prog_id == null) prog_id="";

		String practitioner_id=request.getParameter("practitioner_id");
		if( practitioner_id == null) practitioner_id="";
		
		String wherecondn = request.getParameter("wherecondn");
		if(wherecondn == null) wherecondn ="";	
		String operstn	= request.getParameter("wherecondn");
		if(wherecondn == null) wherecondn ="";	

		String encounterID_repDischargeAdvice=request.getParameter("encounter_id");
		if( encounterID_repDischargeAdvice == null) encounterID_repDischargeAdvice="";
		String loginUser = (String)session.getValue("login_user");
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String SystemDate = "";

			/*Commented On 6/4/2010 For PE
			try
			{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy hh24:mi') SystemDate from dual");
 				 if (rs.next() && rs != null)
					 SystemDate = rs.getString(1);
			
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			}
			catch(Exception e) 
			{
				//out.println("Exception in Sysdate : "+e.toString());
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
			}*/
			try{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select patient_id_length,to_char(sysdate,'dd/mm/yyyy hh24:mi') SystemDate from mp_param");
 				 if (rs.next() && rs != null){
					 pat_id_length = rs.getString("patient_id_length");
					 SystemDate = rs.getString("SystemDate");
				 }
			}catch(Exception e){
				//out.println("Exception in Sysdate : "+e.toString());
				e.printStackTrace();
			}finally{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
%>
<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
      <div>
        <table cellpadding='0'  border="0" cellspacing='0' width='100%' align='center' >
			<tr>
				<td align='right' width='11%' class="label">Patient ID</td>
				<td align=left>&nbsp;<input type=text  name='PatientId' id='PatientId' size="" maxlength="<%=pat_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);document.forms[0].clear.onclick();" onKeypress='makeValidString(this);return CheckForSpecChars(event);' align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'>
				<% out.println("call_function :" +call_function);
				if (!call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT") ) 
				{%>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' id='patID_img' style="visibility:visible"></img><% 
				} %><input type='button' name='search' id='search' value='Search' class='button' onclick='submitPage()'></td>
	<%	if(call_function.equals("QUERY_MATERNAL_REPORT")) 
		{	%>
			<td align='right' class='label' nowrap>Cause Indicator&nbsp;</td>
			<td class=label><select name="cause_ind" id="cause_ind">
				<option>----- Select -----</option>
				<%	
					rs = stmt.executeQuery("select DISCHARGE_TYPE_CODE, SHORT_DESC from ip_discharge_type where  MATERNAL_DEATH_YN = 'Y' and EFF_STATUS = 'E' order by 2 ")  ;
					if(rs != null)
					{									
						while (rs.next())
						{	%>       
							<option value='<%=rs.getString("DISCHARGE_TYPE_CODE")%>'><%=rs.getString("SHORT_DESC")%></option>
					<%	}
					}	%>
				</select>						
			</td>
<%	}	%>


<%	if(!call_function.equals("QUERY_MATERNAL_REPORT")&& !call_function.equals("QUERY_MARK_MLC_OSCC")) 
	{	%>
				<td align='right' class='label'>&nbsp;&nbsp;</td>			
				<td align='right' class='label'>&nbsp;&nbsp;</td>	
<%	}	%>
<%	if(call_function.equals("QUERY_MARK_MLC_OSCC")) 
	{	%>
				<td align='right' class='label'>Marked Status&nbsp;</td>
				<td align='left' ><select name='marked_status' id='marked_status'>
					 <option value=''>---Select---</option>
					 <option value='O'>OSCC</option>
					 <option value='M'>MLC</option>
				</td>
<%	}	%><td align='right'  class='label'>&nbsp;</td>			
		  <td align='right'  class='label'>&nbsp;</td>
          </tr>
	<tr>
		<td colspan=6 align=left width='100%'>
		<table cellpadding='0'  border=0 cellspacing='0' width='100%' align='left' >
		<tr align=left>			
		<td class=label width='100%' align=left>
			<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="patient_id"  value= "" />	
				<jsp:param name ="alert_reqd_yn"   value= ""  />
				<jsp:param name ="mr_transaction"   value= "Y"  />
			</jsp:include>
		</td>
		</tr>
		</table>
		</td>
	</tr>
</table>
<table cellpadding='0'  border='0' cellspacing='0' width='100%' align='left' >
	<tr>
		<td  align='right' class="label" width="11%">Enc Period&nbsp;</td><td  align=left width = "44%">&nbsp;<input type="text" name="alt_id1_exp_date" id="alt_id1_exp_date" size="16" maxlength='16' id='altidexpdt1'  onblur="ComparePeriodFromToTime(this,alt_id2_exp_date);CompareSysDatecriteria(document.forms[0].SystemDate,this);" onkeypress="return Valid_DT(event)"></input><input type='image' src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].alt_id1_exp_date.focus();return showCalendar('altidexpdt1',null,'hh:mm');">&nbsp;-&nbsp;<input type="text" name="alt_id2_exp_date" id="alt_id2_exp_date" size="16" maxlength='16' id='altidexpdate2'  onblur="ComparePeriodFromToTime(alt_id1_exp_date,this);CompareSysDatecriteria(document.forms[0].SystemDate,this);" onkeypress="return Valid_DT(event)" ></input><input type='image' src='../../eCommon/images/CommonCalendar.gif'   onClick="document.forms[0].alt_id2_exp_date.focus();return showCalendar('altidexpdate2',null,'hh:mm');">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' id='encDate_img' style="visibility:hidden"></img></td>

<%		if(call_function.equals("DIAG_RECODE"))
		{	%>
			<script>
				document.getElementById("patID_img").style.visibility = "hidden";
				document.forms[0].alt_id1_exp_date.value = "<%=SystemDate%>";
				document.forms[0].alt_id2_exp_date.value = "<%=SystemDate%>";
			</script>
	<%	}	%>
		
<%	if(!call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	%>			
		<td align='right' class="label" >Encounter Type&nbsp;</td>
			<td align=left>
				<select name="lstPatientClass" id="lstPatientClass">
				<option>----- Select -----</option>
				<%	
					if(rs != null) rs = null;
					rs = stmt.executeQuery("select PATIENT_CLASS, short_desc from am_patient_class order by 1")  ;
					if(rs != null)
					{									
						while (rs.next())
						{	%>
							<option value='<%=rs.getString("PATIENT_CLASS")%>'><%=rs.getString("short_desc")%></option>
					<%	}
					}	%>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' id='encType_img' style="visibility:hidden"></img></td>

				<td align='right' class='label'>&nbsp;&nbsp;</td>	
				<td align='right' class='label'>&nbsp;&nbsp;</td>
<% }else { %>
				<td align='right' class='label'>&nbsp;&nbsp;</td>			
				<td align='right' class='label'>&nbsp;&nbsp;</td>	
				<td align='right' class='label'>&nbsp;&nbsp;</td>	
				<td align='right' class='label'>&nbsp;&nbsp;</td>	

<% } %>

	</tr>

<% if(call_function.equals("QUERY_MATERNAL_REPORT")||call_function.equals("DIAG_RECODE")) {%>
	<tr>
		<td align='right' class="label" >Disch Date&nbsp;</td>
		<td align='left' >&nbsp;<input name='p_discharge_date_from' id='p_discharge_date_from' id='dischargedatefrom' value='' size='16' maxlength='16' onkeypress="return Valid_DT(event)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dischargedatefrom',null,'hh:mm' );" ></input>&nbsp;-&nbsp;<input name='p_discharge_date_to' id='p_discharge_date_to' id='dischargedateto' value='' size='16' maxlength='16' onkeypress="return Valid_DT(event)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dischargedateto',null,'hh:mm' );"></input></td>
		<td align='right'  class='label'>&nbsp;</td>			
		<td align='right'  class='label'>&nbsp;</td>		
		<td align='right'  class='label'>&nbsp;</td>		
		<td align='right'  class='label'>&nbsp;</td>		
	</tr>
<% } %>
	<tr>
		<td align='right' class="label">Encounter ID&nbsp;</td>
		<td  nowrap  align=left>&nbsp;<input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)" align="center"></td>		
		<td align='right' class="label" nowrap>Order By&nbsp;</td>
		<td nowrap ><select name="orderBy" id="orderBy"><option>----- Select -----</option>
			<option value="ED" selected>Encounter Date</option>
			<option value="ET"  >Encounter Type</option>
			</select>		
		</td>
		<td align='right' colspan=2 class='label'>&nbsp;&nbsp;</td>		
		
		</tr>
	<tr>
			<td align='right'  class='label' colspan='3'>&nbsp;&nbsp;</td>
			<td align='right'colspan=3 nowrap><input type='button' name='search' id='search' value='Search' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='Clear' class='button' onclick='clearAll()'>&nbsp;&nbsp;</td>
		</tr>
		</table>

     </div>

	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
	<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
	<input type='hidden' name='param' id='param' value="<%=call_function%>" >	
	<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
	<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
	<input type='hidden' name='module' id='module' value="<%=module%>" >
	<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>" >
	<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
	<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
	<input type='hidden' name='SystemDate' id='SystemDate' value="<%=SystemDate%>" >
	<input type='hidden' name='qerString' id='qerString' value="<%=request.getQueryString()%>" >


     <input type='hidden' name='p_report_id' id='p_report_id' value='MRBIPFFPRC'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
     <input type='hidden' name='sys_date' id='sys_date' value=''></input>

<%	if(call_function.equals("DIAG_RECODE"))
	{	%>
		<script>
			 document.forms[0].all.encType_img.style.visibility = 'visible';
			 document.forms[0].all.encDate_img.style.visibility = 'visible';
		</script>
<%	}	%>
	 
	 <%
     } catch(Exception e) {
          //out.println(e.toString());
		  e.printStackTrace();
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
     }
     finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }
%>
  </form>
</body>

</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

