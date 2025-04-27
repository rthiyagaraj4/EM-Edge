<!DOCTYPE html>
<!--
	Developed by 	:	Bangarraju	
	Created on		:	11/03/2009
	Module			:	IP
	Function		:	IP Online Report
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, webbeans.eCommon.RecordSet" %>
<jsp:useBean id="IPOnlineReportRecordSet" scope="session" class="webbeans.eCommon.RecordSet"/>

<%!int row_count=0;%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%


	request.setCharacterEncoding("UTF-8");
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;

	String chk1	= "", chk2 = "", chk3 = "", chk4 = "", chk5 = "", chk6 = "",chk7 = "",selectChk="";
	String disabledDischarge="",disabledOthers="",disabledBkg="",
           disabledDischargeAdvise="",disabledTrsfRequest="",disabledadm="",disabledassign="";
	

	Hashtable		htRecord	=	null;
 
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();

		
		
		String code="",  valid="", function_code="",  classValue="", tblrow_id="", operation="",module_id="";
		String Function="";
		String desc="";
		StringBuffer result_query = new StringBuffer();

		String facility_id  =	(String)session.getValue("facility_id");
		
		String mode			=	request.getParameter("mode") ;
		if(mode == null || mode.equals("null")) mode="";

		function_code=request.getParameter("function_code");
			if(function_code==null)function_code="";

		operation = request.getParameter("operation");
			if(operation==null)operation="";

		Function = request.getParameter("Function");
			if(Function==null)Function="";
		
		if(Function.equals("pract"))
		{}
		else if(Function.equals("nurs")){}

		if(operation.equals("insert")) {}
		else if(operation.equals("modify"))
		{
			IPOnlineReportRecordSet.clearAll();
		}
		
		String online_mr_notfn_yn	= "";

		String mr_notfn_yn = "select online_mr_notfn_yn from ip_nursing_unit where facility_id = '"+facility_id+"' and nursing_unit_code ='"+function_code+"' and eff_status = 'E'"; 

		rs=stmt.executeQuery(mr_notfn_yn);
			if(rs != null && rs.next())
			{
				online_mr_notfn_yn = rs.getString("online_mr_notfn_yn");
			}
			if(rs!=null)	rs.close();
			
		String pat_check_in_yn	= "";

		String ip_param = "select pat_check_in_allowed_yn from ip_param where facility_id = '"+facility_id+"' "; 

		rs=stmt.executeQuery(ip_param);
			if(rs != null && rs.next())
			{
				pat_check_in_yn = rs.getString("pat_check_in_allowed_yn");
			}
			if(rs!=null)	rs.close();


		if(mode.equals(""))
		{
			if(!(function_code.equals(""))) IPOnlineReportRecordSet.clearAll();
			
			if(operation.equals("insert"))
			{
		
				//result_query.append("select A.REPORT_ID,REPORT_DESC,PRINT_ON_BOOKING_YN, PRINT_ON_ADMISSION_YN, PRINT_ON_TRANSFER_REQUEST_YN, PRINT_ON_CONFORM_TRANSFER_YN, PRINT_ON_BED_ASSIGNED_YN, PRINT_ON_DISCHARGE_YN,PRINT_ON_DISCH_ADV_YN,'Y' as \"Update\"  FROM IP_ONLINE_REPORT A, SM_REPORT B WHERE A.MODULE_ID = 'IP' AND A.FACILITY_ID='"+facility_id+"' AND A.NURSING_UNIT_CODE='"+function_code+"' AND A.REPORT_ID=B.REPORT_ID  AND B.REPORT_ID != 'IPBLVPAS' UNION  select REPORT_ID,REPORT_DESC,'N','N','N','N','N','N','N','N' FROM SM_REPORT WHERE MODULE_ID='IP' "+ "AND REPORT_ID NOT IN ( 'IPBLVPAS', 'IPBGTPAS', 'IPBABNOT') AND INTERNAL_REQUEST_YN = 'Y' AND REPORT_ID NOT IN (SELECT REPORT_ID FROM IP_ONLINE_REPORT WHERE FACILITY_ID = '"+facility_id+"' AND NURSING_UNIT_CODE = '"+function_code+"')ORDER BY 2");
				
				result_query.append("select A.REPORT_ID,REPORT_DESC,a.module_id,PRINT_ON_BOOKING_YN, PRINT_ON_ADMISSION_YN, PRINT_ON_TRANSFER_REQUEST_YN, PRINT_ON_CONFORM_TRANSFER_YN, PRINT_ON_BED_ASSIGNED_YN, PRINT_ON_DISCHARGE_YN,PRINT_ON_DISCH_ADV_YN,'Y' as \"Update\"  FROM IP_ONLINE_REPORT A, SM_REPORT B WHERE A.MODULE_ID = 'IP' AND A.FACILITY_ID='"+facility_id+"' AND A.NURSING_UNIT_CODE='"+function_code+"' AND A.REPORT_ID=B.REPORT_ID  AND B.REPORT_ID != 'IPBLVPAS'");
				if(online_mr_notfn_yn.equals("Y"))
				{
					result_query.append(" UNION SELECT   a.report_id, report_desc,a.module_id, print_on_booking_yn,  print_on_admission_yn, print_on_transfer_request_yn, print_on_conform_transfer_yn,  print_on_bed_assigned_yn, print_on_discharge_yn, print_on_disch_adv_yn, 'Y' AS \"Update\" FROM ip_online_report a, sm_report b  WHERE a.module_id = 'FM' AND a.facility_id = '"+facility_id+"' AND a.nursing_unit_code = '"+function_code+"' AND a.report_id = b.report_id AND b.report_id = 'FMFLRQSL'");
				}
				result_query.append(" UNION  select REPORT_ID,REPORT_DESC,module_id,'N','N','N','N','N','N','N','N' FROM SM_REPORT WHERE MODULE_ID='IP' "+ "AND REPORT_ID NOT IN ( 'IPBLVPAS', 'IPBGTPAS', 'IPBABNOT','IPBWBLBW','IPBWBLBB','IPBWBLBR') AND INTERNAL_REQUEST_YN = 'Y' AND REPORT_ID NOT IN (SELECT REPORT_ID FROM IP_ONLINE_REPORT WHERE FACILITY_ID = '"+facility_id+"' AND NURSING_UNIT_CODE = '"+function_code+"')");
				if(online_mr_notfn_yn.equals("Y"))
				{
					result_query.append(" UNION SELECT   report_id, report_desc,module_id, 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N'  FROM sm_report WHERE module_id = 'FM' AND report_id = 'FMFLRQSL' AND internal_request_yn = 'Y' AND REPORT_ID NOT IN (SELECT REPORT_ID FROM IP_ONLINE_REPORT WHERE FACILITY_ID = '"+facility_id+"' AND NURSING_UNIT_CODE = '"+function_code+"') ");
				}

				result_query.append(" ORDER BY 2");
				
			
			}

			
			rs=stmt.executeQuery(result_query.toString());
			if(rs != null)
			{
				while(rs.next())
				{
					code		=	rs.getString("REPORT_ID");
					desc		=	rs.getString("REPORT_DESC");
					valid		=	rs.getString("Update");
					module_id	=	rs.getString("module_id");
				if(rs.getString("print_on_booking_yn").equals("Y"))
					chk1="CHECKED";
				else
					chk1="";

				if(rs.getString("print_on_admission_yn").equals("Y"))
					chk4="CHECKED";
				else
					chk4="";


				if(rs.getString("print_on_transfer_request_yn").equals("Y"))
					chk3="CHECKED";
				else
					chk3="";
			
				if(rs.getString("print_on_conform_transfer_yn").equals("Y"))
					chk2="CHECKED";
				else
					chk2="";

				if(rs.getString("print_on_bed_assigned_yn").equals("Y")) 
					chk5="CHECKED";
				else
					chk5="";

				if(rs.getString("print_on_discharge_yn").equals("Y")){
					chk6="CHECKED";
				}
				else
					chk6="";

				if(rs.getString("print_on_disch_adv_yn").equals("Y")){
					chk7="CHECKED";
				}
				else
					chk7="";
						

					if(code == null || code.equals("null"))code="";
					if(desc == null || desc.equals("null"))desc="";
					if(valid == null || valid.equals("null"))valid="";

					htRecord			=	new Hashtable();
					/**
					Valid  associate_yn -->Operation
					================================
					 Y			Y		-->Delete
					 Y			N		-->Update
					 N			Y		-->Insert
					 N			N		-->NOP*/

					htRecord.put("code"	,	code);
					htRecord.put("desc"	,	desc);
					htRecord.put("module_id"	,	module_id);
					htRecord.put("valid",	valid);		//Flag1
					htRecord.put("associate_yn" , "N"); //Flag2
					htRecord.put("booking_yn" , chk1); 
					htRecord.put("transferConfirmation_yn" , chk2); 
					htRecord.put("print_on_transfer_request_yn" ,chk3); 
					htRecord.put("admissionWithBed_yn" , chk4); 
					htRecord.put("admissionWithoutBed_yn" ,chk5); 
					htRecord.put("print_on_disch_adv_yn" , chk7);
					htRecord.put("discharge_yn" , chk6); 

					IPOnlineReportRecordSet.putObject(htRecord);
				}

			if(rs!=null)	rs.close();
			if(stmt!=null)	stmt.close();
			}

			row_count				=	IPOnlineReportRecordSet.getSize();

			
		}
		
		
	%>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		
		<script language='javascript' src='../../eIP/js/IPOnlineReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onLoad='dispRecord(); ' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='IPOnlineReportForm' id='IPOnlineReportForm' action='../../servlet/eIP.IPOnlineReportServlet' method='post' target='messageFrame'>

	
	
	<table cellpadding='0' cellspacing='0' border='1' width='90%' align='center' >
	<tr>
	<th width='' ><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></th>
	<th width='' colspan='7'><fmt:message key="eIP.PrintOn.label" bundle="${ip_labels}"/></th>
	<th width='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;</th>
	</tr>
	<tr>
	<th width='' >&nbsp;</th>	
	<th width='' ><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp;</th>
	<th width='' ><fmt:message key="Common.admission.label" bundle="${common_labels}"/>&nbsp;</th>
	<th width='' ><fmt:message key="Common.AssignBed.label" bundle="${common_labels}"/>&nbsp;</th>
	<th width='' ><fmt:message key="eIP.TransferRequest.label" bundle="${ip_labels}"/>&nbsp;</th>
	<th width='' ><fmt:message key="eIP.TransferConfirmation.label" bundle="${ip_labels}"/>&nbsp;</th>
	<th width='' ><fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/>&nbsp;</th>
	<th width='' ><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>&nbsp;</th>
	<th width='' >&nbsp;</th>			
	</tr>
	<%
	try
	{
	
	
	for(int i=0; i<row_count; i++)
		{
			classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
			htRecord			=	(java.util.Hashtable)	IPOnlineReportRecordSet.getObject(i);
			code			=	(String)htRecord.get("code");
			desc			=	(String)htRecord.get("desc");
			valid			=	(String)htRecord.get("valid");
			
				chk1			=	(String)htRecord.get("booking_yn");
				chk4			=	(String)htRecord.get("admissionWithBed_yn");
				chk5			=	(String)htRecord.get("admissionWithoutBed_yn");
				chk3			=	(String)htRecord.get("print_on_transfer_request_yn");
				chk2			=	(String)htRecord.get("transferConfirmation_yn");
				chk7			=	(String)htRecord.get("print_on_disch_adv_yn");
				chk6			=	(String)htRecord.get("discharge_yn");
			
			
					if(valid.equals("Y"))
					{
						selectChk	="checked";
						if(code==null)code="";
					}
					else
						selectChk	="";
/*
					if(code.equals("IPBBKSLP"))
					{
						disabledBkg	="";
						disabledOthers="disabled";
						disabledDischarge="disabled";
					}
					if(code.equals("IPHKPLTR"))
					{
						disabledOthers="disabled";
					}
					else
					{
						disabledBkg	="disabled";
						disabledOthers="";
						if(code.equals("IPBENFRM"))
							disabledDischarge="disabled";
						else
							disabledDischarge="";
					}
*/


		

		/*
			*** Added  by Bangarraju K  on 3/06/2009.. 
	
			****************************************************
			Report ID - Report Deescription
			****************************************************
		*	IPBBKSLP	Admission Booking Slip
		*	IPBADLBL	Admission Label
		*	IPBABLBL	Admission Label for Bed
		*	IPBADNOT	Admission Notification
		*	IPBADREC	Admission Record
		*	IPBAORFR	At Own Risk Form
		*	IPBBDYTG	Body Tag
		*	IPBENFRM	Encounter Form
		*	IPBWBLBL	Inpatient Wristband Label
		*	IPBINWBL	Inpatient Wristband Label for Infant's
		*	IPBINBCC	Intimation for Bed Class Change
		*	IPBINDIS	Intimation for Discharge
		*	IPBMDNOT	Notification Of Maternal Death
			****************************************************
		*/
		

			if(code.equals("IPBADLBL") || code.equals("IPBABLBL") || code.equals("IPBADNOT") || code.equals("IPBADREC") || code.equals("IPBENFRM") || code.equals("IPBWBLBL")|| code.equals("IPBINWBL") || code.equals("IPADFORM") || code.equals("IPOSIDEN"))
			{
				disabledBkg			= "disabled";
				disabledOthers		= "";
				disabledDischarge	= "disabled";
				disabledDischargeAdvise="disabled";
				disabledTrsfRequest="disabled";
			}


			if(code.equals("IPBAORFR") || code.equals("IPBBDYTG") || code.equals("IPBMDNOT") || code.equals("IPDISSUM") || code.equals("PHBORDSM"))
			{
				disabledBkg			= "disabled";
				disabledOthers		= "disabled";
				disabledDischarge	= "";
				disabledDischargeAdvise="disabled";
				disabledTrsfRequest="disabled";
			}
				if(code.equals("IPBINDIS"))
			{ 
				disabledBkg			= "disabled";
                disabledDischarge      = "disabled";
				disabledOthers   = "disabled";
				disabledDischargeAdvise	= "";
				disabledTrsfRequest="disabled";
			}
		  if(code.equals("IPBINBCC"))
			{ 
				disabledBkg			= "disabled";
                disabledDischargeAdvise="disabled";
				disabledOthers   = "disabled";        
				disabledDischarge= "disabled";
				disabledTrsfRequest="";
				
				
			}


			if(code.equals("IPBBKSLP"))
			{
				disabledBkg			    = "";
				disabledOthers		    = "disabled";
				disabledDischarge	    = "disabled";
				disabledDischargeAdvise ="disabled";
				disabledTrsfRequest     ="disabled";
			}

			if(code.equals("FMFLRQSL"))
			{
				disabledadm				= "";
				disabledassign			= "";
				disabledDischarge	    = "disabled";
				
			}
		

		/*	if(code.equals("IPBMDSUM"))
			{
				disabledBkg			= "disabled";
				disabledOthers		= "disabled";
				disabledDischarge	= "disabled";
			} */

			tblrow_id	=	"tblrow_id"+i;
		%>
		<tr id='<%=tblrow_id%>' nowrap>

		<td class='<%=classValue%>' align='left' nowrap><%=((desc.equals(""))?"&nbsp;":desc)%></td>
	
		<input type="hidden" name="reportCode<%=i%>" id="reportCode<%=i%>" value="<%=code%>">

		<td class='<%=classValue%>' align='center' nowrap><input type='checkbox' name='select_booking_yn<%=i%>' id='select_booking_yn<%=i%>' <%=chk1%> <%=disabledBkg%> value='' onClick='SelectCBValue(this,"<%=i%>");'></td>

		<td class='<%=classValue%>' align='center' nowrap><input type='checkbox' name='select_admissionWithBed_yn<%=i%>' id='select_admissionWithBed_yn<%=i%>' <%=chk4%> <%if(!code.equals("FMFLRQSL"))
			{%><%=disabledOthers%> <%}%> <%=disabledadm%> value='' onClick='SelectCBValue(this,"<%=i%>");'></td>

		<td class='<%=classValue%>' align='center' nowrap><input type='checkbox' name='select_admissionWithoutBed_yn<%=i%>' id='select_admissionWithoutBed_yn<%=i%>' <%=chk5%> <%if(!code.equals("FMFLRQSL"))
			{%> <%=disabledOthers%> <%}%> <%=disabledassign%> value='' onClick='SelectCBValue(this,"<%=i%>");'></td>

		<td class='<%=classValue%>' align='center' nowrap><input type='checkbox' name='select_transferrequest_yn<%=i%>' id='select_transferrequest_yn<%=i%>' <%=chk3%> <%=disabledTrsfRequest%> value='' onClick='SelectCBValue(this,"<%=i%>");'></td>

		<td class='<%=classValue%>' align='center' nowrap><input type='checkbox' name='select_transferConfirmation_yn<%=i%>' id='select_transferConfirmation_yn<%=i%>' <%=chk2%> <%=disabledOthers%> value='' onClick='SelectCBValue(this,"<%=i%>");'></td>

	
	    <td class='<%=classValue%>' align='center' nowrap><input type='checkbox' name='print_on_discharge_yn<%=i%>' id='print_on_discharge_yn<%=i%>' <%=chk7%> <%=disabledDischargeAdvise%> value=''  onClick='SelectCBValue(this,"<%=i%>");'></td>

		<td class='<%=classValue%>' align='center' nowrap><input type='checkbox' name='select_discharge_yn<%=i%>' id='select_discharge_yn<%=i%>' <%=chk6%> <%=disabledDischarge%> value='' onClick='SelectCBValue(this,"<%=i%>");'></td>

	 	<td class='<%=classValue%>' align='center' nowrap><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' <%=selectChk%> value='' onClick='SelectCBValue(this,"<%=i%>");SelectEnableDisable(this,"<%=code%>","<%=i%>")'></td>

		</tr>
			<%
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception@2: "+e);
		}
	%>
	</table>
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">

	<input type='hidden' name='SelectYNStr' id='SelectYNStr' value="">
	<input type='hidden' name='operation' id='operation' value="<%=operation%>">
	<input type='hidden' name='function_code' id='function_code' value=''>
	<input type='hidden' name='Function' id='Function' value="<%=Function%>">
	<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value="<%=function_code%>">
	<input type='hidden' name='SelectYNStrBkg' id='SelectYNStrBkg' value="">
	<input type='hidden' name='SelectYNStrConf' id='SelectYNStrConf' value="">
	<input type='hidden' name='SelectYNStrBed' id='SelectYNStrBed' value="">
	<input type='hidden' name='SelectYNStrWoBed' id='SelectYNStrWoBed' value="">
	<input type='hidden' name='SelectYNStrTransReqest' id='SelectYNStrTransReqest' value="">
    <input type='hidden' name='SelectYNStrPrint_on_discharge' id='SelectYNStrPrint_on_discharge' value=""> 
	<input type='hidden' name='SelectYNStrDischarge' id='SelectYNStrDischarge' value="">
	<input type='hidden' name='SelectYNStrCode' id='SelectYNStrCode' value="">
	<input type=hidden name=isRecordSelected_YN id=isRecordSelected_YN value="N">
	
	</form>
	<%
	}
	catch(Exception e)
	{
		out.println("Exception in fetching connection"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
	%>
</body>
</html>
	
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

