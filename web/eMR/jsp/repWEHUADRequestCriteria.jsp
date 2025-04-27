<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  
  
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
  <script language='javascript' src="../../eMR/js/MRReports.js"></script>
</head>
<script>
function PeriodcheckDateTime(obj1,obj2)
{	
	var a=obj1.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 = a[0].split("/")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));

	 a=obj2.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 = a[0].split("/")
	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));

	 if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
		document.forms[0].alt_id2_exp_date.focus();
		document.forms[0].alt_id2_exp_date.select();
		return false;
	}
}
function ComparePeriodFromToTime(from,to)
{

	var frdt = from.value;
	var tdt = to.value;

	if(from !='')
	{
		var t1 = CheckDate(from);		
		if(!t1)
		{
			from.value=""; 
			from.focus();
			return;
		}
	}
	if(to !='')
	{
		var t1 = CheckDate(to);		
		if(!t1)
		{
			to.value=""; 
			to.focus();
			return;
		}
	}

		PeriodcheckDateTime(frdt,tdt);
}
function reset()
{	
	f_query_add_mod.document.forms[0].reset();
}


function submitPage()
{
	var continue_yn = "Y";
	
	if(document.forms[0].call_function.value == 'DIAG_RECODE' ||
	document.forms[0].call_function.value=='MRBWEHUA' || document.forms[0].call_function.value=='MRBWEHUD' || document.forms[0].call_function.value == 'MRBCANNT')
	{
		if(document.forms[0].alt_id2_exp_date.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK",'Common');
			error = error.replace('$', getLabel("Common.encounter.label","Common")+' '+getLabel("Common.periodto.label","Common"));
			alert(error);
			document.forms[0].alt_id2_exp_date.focus();
		}
		else if(document.forms[0].alt_id1_exp_date.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK",'Common');
			error = error.replace('$', getLabel("Common.encounter.label","Common")+' '+getLabel("Common.periodfrom.label","Common"));
			alert(error);
			document.forms[0].alt_id1_exp_date.focus();
		}
	}
	
	if(document.forms[0].call_function.value!='QUERY_MARK_MLC_OSCC' && document.forms[0].call_function.value!='QUERY_MATERNAL_REPORT' && document.forms[0].call_function.value!='DIAG_RECODE' && document.forms[0].call_function.value!='MRBWEHUA' && document.forms[0].call_function.value!='MRBWEHUD' &&  
	document.forms[0].call_function.value!='MRBCANNT') 
	{
		if(document.forms[0].PatientId.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK",'Common');
			error = error.replace('$', getLabel("Common.patientId.label","Common"));
			alert(error);
			document.forms[0].PatientId.focus();
		}
	}
	if(continue_yn == "Y")
	{
		var condition=""
		for(var i=0; i<document.forms[0].elements.length; i++)
				condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
			
		oper_stn = document.forms[0].operstn.value;

		var call_function = document.forms[0].call_function.value;

		parent.frames[2].location.href= '../../eMR/jsp/repWEHUADRequestResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y&fromSelect=fromSelect';
	}
}
</script>

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
		stmt = con.createStatement();
		
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		try
		{
			 
			 rs	=	stmt.executeQuery("select patient_id_length from mp_param");
			 if (rs.next() && rs != null)
				 pat_id_length = rs.getString(1);

		}catch(Exception e) 
		{
			//out.println("Exception in Sysdate : "+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
		}
%>
<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
      <div>
        <table cellpadding='0'  border="0" cellspacing='0' width='100%' align='center' >
			<tr>
				<td align='right' width='10%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td align=left>&nbsp;<input type=text  name='PatientId' id='PatientId' size="" maxlength="<%=pat_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);" onKeypress='makeValidString(this);return CheckForSpecChars(event);' align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreenrepWEHUADReqCri()'><% if (!call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("MRBWEHUA") && !call_function.equals("MRBWEHUD") && !call_function.equals("MRBCANNT")) 
				{%>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' id='patID_img' style="visibility:visible"></img><% 
				} %></td>


<%	if(!call_function.equals("QUERY_MATERNAL_REPORT")&& !call_function.equals("QUERY_MARK_MLC_OSCC")) 
	{	%>
				<td align='right' class='label'>&nbsp;&nbsp;</td>			
				<td align='right' class='label'>&nbsp;&nbsp;</td>	
<%	}	%>
<td align='right'  class='label'>&nbsp;</td>			
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
		<td  align='right' class="label" width="10%"><fmt:message key="eMR.EncPeriod.label" bundle="${mr_labels}"/>&nbsp;</td><td  align=left width = "44%">&nbsp;<input type="text" name="alt_id1_exp_date" id="alt_id1_exp_date" size="10" maxlength='10' id='altidexpdt1'  onblur="ComparePeriodFromToTime(this,alt_id2_exp_date);" onkeypress="return submitFormrepWEHUADReqCri(event)"></input><input type='image' src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].alt_id1_exp_date.focus();return showCalendar('altidexpdt1');">&nbsp;-&nbsp;<input type="text" name="alt_id2_exp_date" id="alt_id2_exp_date" size="10" maxlength='10' id='altidexpdate2'  onblur="ComparePeriodFromToTime(alt_id1_exp_date,this);" onkeypress="return submitFormrepWEHUADReqCri(event)" ></input><input type='image' src='../../eCommon/images/CommonCalendar.gif'   onClick="document.forms[0].alt_id2_exp_date.focus();return showCalendar('altidexpdate2');">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' id='encDate_img' style="visibility:hidden"></img></td>

<%	if(!call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	%>			
		<td align='right' class="label" ><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/>&nbsp;</td>
			<td align=left>
				<select name="lstPatientClass" id="lstPatientClass">
				<option>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
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

	<tr>
		<td align='right' class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</td>
		<td  nowrap  align=left>&nbsp;<input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumValrepWEHUADReqCri(this)" align="center"></td>		
		<td align='right' class="label" nowrap><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;</td>
		<td nowrap ><select name="orderBy" id="orderBy"><option>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<option value="ED" selected><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></option>
			<option value="ET"  ><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></option>
			</select>		
		</td>
		<td align='right' colspan=2 class='label'>&nbsp;&nbsp;</td>		
		
		</tr>
	<tr>
			<td align='right'  class='label' colspan='3'>&nbsp;&nbsp;</td>
			<td colspan=3 nowrap class='button'><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAllrepWEHUADReqCri()'>&nbsp;&nbsp;</td>
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

     <input type='hidden' name='p_report_id' id='p_report_id' value='MRBIPFFPRC'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
     <input type='hidden' name='sys_date' id='sys_date' value=''></input>

<%	if( call_function.equals("MRBWEHUD") || call_function.equals("MRBWEHUA") || call_function.equals("MRBCANNT"))
	{	%>
		<script>
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
		 try
		 {
		  if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		 }
		 catch(Exception e)
		 {
		 }
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

