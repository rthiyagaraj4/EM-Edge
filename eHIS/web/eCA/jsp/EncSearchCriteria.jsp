<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
   <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
  <script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
  <script language='javascript' src="../js/EncSearchCriteria.js"></script>
<script>
<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
function callcheck_val()
{ 
	if (document.forms[0].discharge_val.checked==true)
		document.forms[0].discharge_val.value="Y";
	else
		document.forms[0].discharge_val.value="N";
}

//Func will return an alert message if FROM DATE is null and TO Date is selected
function checkFromDt(to,frmDt)
{
	if ( (frmDt.value=='') && (to.value!='') )
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.fromdate.label","Common"));		
		alert(error);
		to.value='';
		frmDt.focus();
	}
		return;
}

function doDcsdDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) <= Date.parse(fromdt)) {
                return false;
            }
            else if(Date.parse(todt) > Date.parse(fromdt)) return true;
    }
return true;
}

function DscdPeriodChk(Dt)
{		
	if(Dt.value!="")	
	{
		var SystemDate	= document.forms[0].SystemDate.value;
		if(validDate(Dt.value,"DMY","en"))
		{
			var toDt	= convertDate(Dt.value,"DMY",localeName,"en");
			if(!isAfter(SystemDate,toDt,'DMY',localeName))// DateUtils.js
			{
				error=getMessage("MRDATE1_GT_DATE2","MR");
				error = error.replace('$', getLabel("eMR.DeceasedPeriod.label","MR"));		
				error = error.replace('#', getLabel("Common.CurrentDate.label","Common"));	
				alert(error);
				Dt.value='';
				Dt.focus();
			}
		}
	return;
}
}

//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
//Func will return an alert message if TO DATE is Less than FROM DATE
function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='' && tdt !='' )// DateUtils.js
	{
		if(validDate(frdt,"DMY","en") && validDate(tdt,"DMY","en"))
		{
			var fromDt	= convertDate(frdt,"DMY",localeName,"en");
			var toDt	= convertDate(tdt,"DMY",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.focus();
			}
		}
	}
}

</script>
</head>
<%
  String p_user_name		= (String) session.getValue( "login_user" ) ;
  String locale           = (String) session.getAttribute("LOCALE");
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

			try
			{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy') SystemDate from dual");
 				 if (rs.next() && rs != null)
					 SystemDate = rs.getString(1);
			
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			}
			catch(Exception e) 
			{
				//out.println("Exception in Sysdate : "+e.toString());//COMMON-ICN-0181
                               e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(rs!=null) rs.close();
			}
			try
			{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select patient_id_length from mp_param");
 				 if (rs.next() && rs != null)
					 pat_id_length = rs.getString(1);

			}catch(Exception e) 
			{
				//out.println("Exception in Sysdate : "+e.toString());//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(rs!=null) rs.close();
			}
			String SystemDate_display = DateUtils.convertDate(SystemDate,"DMY" ,"en",localeName);
%>
<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'enc_search_form' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">						<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" flush="true" >
			<jsp:param name ="patient_id"  value= "" />	
			<jsp:param name ="alert_reqd_yn"   value= ""  />
			<jsp:param name ="mr_transaction"   value= "Y"  />
		</jsp:include>
		<table cellpadding='2' border="0" cellspacing='0' width='100%' >
			<tr>
				<td width='25%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td width='25%' class="fields"><input type=text  name='PatientId' id='PatientId' size="" maxlength="<%=pat_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);document.forms[0].clear.onclick();" onKeypress='return CheckForSpecChars(event);' align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'>
				<td class="label" width="25%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class="fields" width="25%"><input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this);EncTypeMand(this);"></td>			
			</tr>
	<tr>
		<td class="label" width="25%"><fmt:message key="eMR.EncPeriod.label" bundle="${mr_labels}"/></td>
		<td class="fields" width="25%"><input type="text" name="alt_id1_exp_date" id="alt_id1_exp_date" size="10" maxlength='10' id='altidexpdt1'  onblur="validDateObj(this,'DMY','<%=locale%>');ComparePeriodFromToTime(this,alt_id2_exp_date);" onkeypress="return Valid_DT(event)"></input><input type='image' src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].alt_id1_exp_date.focus();return showCalendar('altidexpdt1');">-<input type="text" name="alt_id2_exp_date" id="alt_id2_exp_date" size="10" maxlength='10' id='altidexpdate2'  onblur="validDateObj(this,'DMY','<%=locale%>');ComparePeriodFromToTime(alt_id1_exp_date,this);" onkeypress="return Valid_DT(event)" ></input><input type='image' src='../../eCommon/images/CommonCalendar.gif'   onClick="document.forms[0].alt_id2_exp_date.focus();return showCalendar('altidexpdate2');">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' id='encDate_img' style="visibility:hidden"></img></td>

<%	
	
	if( call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL"))
		{	%>
			<script>
				document.getElementById("patID_img").style.visibility = "hidden";
				document.forms[0].alt_id1_exp_date.value = "<%=SystemDate_display%>";
				document.forms[0].alt_id2_exp_date.value = "<%=SystemDate_display%>";
			</script>
	
	<%
		}	
		
	%>
		
	<%	
	if(!call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	
	%>			
			<td width="22%" class="label" ><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
			<td  class="fields">
				<select name="lstPatientClass" id="lstPatientClass">
				<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%	
					if(rs != null) rs.close();
										
					rs = stmt.executeQuery("select patient_class, short_desc from am_patient_class_lang_vw where language_id='"+locale+"' order by 1");
					

					if(rs != null)
					{									
						while (rs.next())
						{	
						%>
							<option value='<%=rs.getString("patient_class")%>'><%=rs.getString("short_desc")%></option>
						<%
						}
					}	
					if(rs!=null) rs.close();
					
					%>

					</select><img src='../../eCommon/images/mandatory.gif' align='center' id='encType_img' style="visibility:hidden"></img></td>

	<% 
	}
	else 
	{ 
	%>
				<td width='25%' class='label'></td>			
				<td width='25%' class='label'></td>	
	<% 
	} 
%>
</tr>

<% if(call_function.equals("QUERY_MATERNAL_REPORT")||call_function.equals("DIAG_RECODE") || call_function.equals("MR_VIEW_DTH_REG"))
{
%>
	<tr>
	<% 
	  if (call_function.equals("MR_VIEW_DTH_REG"))
		{
	%>
			<td width="25%" class="label" ><fmt:message key="eMR.DeceasedPeriod.label" bundle="${mr_labels}"/></td>
			<td width="25%" class="fields"><input name='p_discharge_date_from' id='p_discharge_date_from' id='dischargedatefrom' onblur="validDateObj(this,'DMY','<%=locale%>');ComparePeriodFromToTime(this,p_discharge_date_to);DscdPeriodChk(this);" value='' size='10' maxlength='10' onkeypress="return Valid_DT(event)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].dischargedatefrom.focus();return showCalendar('dischargedatefrom','dd/mm/y',null );" ></input>-<input name='p_discharge_date_to' id='p_discharge_date_to' id='dischargedateto' value='' size='10' maxlength='10' onblur="validDateObj(this,'DMY','<%=locale%>');ComparePeriodFromToTime(p_discharge_date_from,this);DscdPeriodChk(this);" onkeypress="return Valid_DT(event)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dischargedateto','dd/mm/y',null );"></input></td>
	<%
		} 
		else 
		{
	%>
			<td width="25%" class="label"><fmt:message key="eMR.DischPeriod.label" bundle="${mr_labels}"/></td>
			<td width="25%" class="fields"><input name='p_discharge_date_from' id='p_discharge_date_from' id='dischargedatefrom' value='' size="10" maxlength='10' onkeypress="return Valid_DT(event)" onblur='validDateObj(this,"DMYHM","<%=locale%>");CompareDisPeriodFromToTime(this,p_discharge_date_to);disChargePeriodChk(this);'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dischargedatefrom',null,'hh:mm' );"></input><input name='p_discharge_date_to' id='p_discharge_date_to' id='dischargedateto' value='' size="10" maxlength='10' onblur="validDateObj(this,'DMYHM','<%=locale%>');CompareDisPeriodFromToTime(p_discharge_date_from,this);disChargePeriodChk(this);'" onkeypress="return Valid_DT(event)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dischargedateto',null,'hh:mm' );"></input><img src='../../eCommon/images/mandatory.gif' align='center' id='DischDate_img' style="visibility:hidden"></img></td>

	<% 
	} 
	if(call_function.equals("DIAG_RECODE"))
	{
	%>

		<script>
			document.forms[0].dischargedateto.value = "<%=SystemDate_display%>";
			document.forms[0].dischargedatefrom.value = "<%=SystemDate_display%>";
			document.getElementById("patID_img").style.visibility = "hidden";
		    document.getElementById("encDate_img").style.visibility = "hidden";
		</script>
	<%
	}
	%>
		<td width="25%"  class='label'>&nbsp;</td>			
		<td width="25%"   class='label'>&nbsp;</td>		
		<td width="25%"   class='label'>&nbsp;</td>		
		<td width="25%"   class='label'>&nbsp;</td>		
	</tr>
<% } %>
	<tr>
		<td class="label" width="25%" nowrap><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td nowrap ><select name="orderBy" id="orderBy"><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value="ED" selected><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></option>
			<option value="ET"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></option>
			</select>		
		</td>
		<td class="label" width="25%"></td>
		<td class="label" width="25%"></td>
	</tr>
	<tr>
		<%
			if(call_function.equals("MR_REC_PAT_VAL"))
			{
		%>
				<td width="25%" class='label' colspan='1'><fmt:message key="Common.discharged.label" bundle="${common_labels}"/></td>
				<td width="25%"  class='fields' colspan='1'><input type="checkbox" name="discharge_val" id="discharge_val" onclick="callcheck_val();"></td>
		<%
			}
			else 
			{
			%>
				<td  colspan='1'></td>
				<td  colspan='1'></td>

			<%
			}
			%>
			<td width="25%" class='label' colspan='1'></td>
			<td width="25%" class='button' colspan=3 nowrap><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'></td>
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

	<%	
	if(call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL") )
	{	
	%>
		<script>
			 document.forms[0].encType_img.style.visibility = 'visible';
			 document.forms[0].encDate_img.style.visibility = 'visible';
		</script>
	<%
	}
	if(call_function.equals("DIAG_RECODE"))
	{
	%>
		<script>
			 document.forms[0].DischDate_img.style.visibility = 'visible';
			 document.forms[0].encType_img.style.visibility = 'visible';
		</script>
		 
	 <%
	}
	 if(call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
	{
	%>
			<script>
				 document.forms[0].encType_img.style.visibility = 'visible';
			</script>
		 
	 <%
	 }
     } catch(Exception e) {
        //  out.println(e.toString());//COMMON-ICN-0181
            e.printStackTrace();//COMMON-ICN-0181
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

