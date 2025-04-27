<!--
	Module			:	eMR
	Modified On		:	12/05/2005
	Modified By		:   Vinod Babu for View Death Register
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src="../../eMR/js/DiagProcedureRecoding.js"></script>
	<!--<script language='javascript' src="../js/MedRecRequestCriteria.js"></script>
	<script language='javascript' src="../js/MedRecRequestMain.js"></script>-->

	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String p_user_name		= (String) session.getValue( "login_user" );
	String locale           = (String) session.getAttribute("LOCALE");
	Connection con = ConnectionManager.getConnection(request);
	Boolean isAllowModifyDiscPeriod =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","ALLOW_MODIFY_DISC_PERIOD"); //Added by Mujafar for ML-MMOH-CRF-1405 
	ResultSet rs   = null;
	ResultSet rs1   = null;
	Statement stmt = null;
	Statement stmt1 = null;
	String pat_id_length = "";
	String action_if_not_done="";
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

		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id == null) oper_stn_id="";	

		String oper_stn_id1=request.getParameter("oper_stn_id1");
		if(oper_stn_id1 == null) oper_stn_id1="";	


		String reportname=request.getParameter("reportname");
		if(reportname == null) reportname="";	
		String encounterID_repDischargeAdvice=request.getParameter("encounter_id");
		if( encounterID_repDischargeAdvice == null) encounterID_repDischargeAdvice="";
		String loginUser = (String)session.getValue("login_user");
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String SystemDate = "";
		String SystemDate_op = "";
		String SystemDate_ip = "";
		String recode_for_op_yn = "";
		String recode_for_ip_yn = "";
		String recode_for_em_yn = "";
		String recode_for_dc_yn = "";
		String SDate = "";
		String stage_no = "";
		String recode_OP_yn = "";
		String recode_IP_yn = "";
		String allow_recode_diag_yn="";
		String allow_recode_proc_yn="";
		String allow_ot_proc_recode_yn="";
		String allow_non_ot_proc_recode_yn="";
		int op_visit=0;
		int ip_disch=0;
	

		try
		{
			stmt = con.createStatement();
			rs	=	stmt.executeQuery("SELECT a.STAGE_NO,a.CF_PR_FR_RECODE_DYS_FM_VSTCMPL,a.CF_PR_FR_RECODE_DYS_FM_DISC FROM mr_recode_privi_setup a, mr_recode_privi_setup_dtl b WHERE a.STAGE_NO = b.STAGE_NO AND b.APPL_USER_ID='"+loginUser+"' and facility_id = '"+p_facility_id+"'");
			if (rs.next() && rs != null)
			{
				stage_no = rs.getString(1);
				op_visit = rs.getInt(2);
				ip_disch = rs.getInt(3);

				
			}
		}catch(Exception e) 
		{
			//out.println("Exception in mr_recode_privi_setup : "+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}


		if(stage_no.equals(""))
		{
			try
		{
			stmt = con.createStatement();
			rs	=	stmt.executeQuery("  SELECT STAGE_NO,CF_PR_FR_RECODE_DYS_FM_VSTCMPL,CF_PR_FR_RECODE_DYS_FM_DISC FROM mr_recode_privi_setup WHERE  SPECIFIC_IND='*ALL' ORDER BY  STAGE_NO DESC");
			if (rs.next() && rs != null)
			{
				stage_no = rs.getString(1);
				op_visit = rs.getInt(2);
				ip_disch = rs.getInt(3);
				
			}
		}catch(Exception e) 
		{
			//out.println("Exception in mr_recode_privi_setup : "+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}

		}
		String max_level_for_op_yn = "";
		String max_level_for_ip_yn = "";
		String max_level_for_dc_yn = "";
		String max_level_for_em_yn = "";
		int grace_period = 0;
		try{
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT (SELECT ACTION_IF_NOT_DONE FROM mr_recode_privi_setup WHERE  STAGE_NO='"+stage_no+"') action_if_not_done, RECODE_FOR_OP_YN,RECODE_FOR_IP_YN,RECODE_FOR_EM_YN,RECODE_FOR_DC_YN,MAX_LEVEL_FOR_OP_YN,MAX_LEVEL_FOR_IP_YN,MAX_LEVEL_FOR_DC_YN,MAX_LEVEL_FOR_EM_YN,GRACE_PERIOD,ALLOW_RECODE_DIAG_YN, ALLOW_RECODE_PROC_YN, ALLOW_OT_PROC_RECODE_YN, ALLOW_NON_OT_PROC_RECODE_YN FROM mr_parameter");
						
			if(rs1 != null)
			{									
				while (rs1.next())
				{	action_if_not_done=checkForNull(rs1.getString("action_if_not_done"));
					recode_for_op_yn=checkForNull(rs1.getString("RECODE_FOR_OP_YN"));
					recode_for_ip_yn=checkForNull(rs1.getString("RECODE_FOR_IP_YN"));
					recode_for_em_yn=checkForNull(rs1.getString("RECODE_FOR_EM_YN"));
					recode_for_dc_yn=checkForNull(rs1.getString("RECODE_FOR_DC_YN"));
					max_level_for_op_yn=checkForNull(rs1.getString("MAX_LEVEL_FOR_OP_YN"));
					max_level_for_ip_yn=checkForNull(rs1.getString("MAX_LEVEL_FOR_IP_YN"));
					max_level_for_dc_yn=checkForNull(rs1.getString("MAX_LEVEL_FOR_DC_YN"));
					max_level_for_em_yn=checkForNull(rs1.getString("MAX_LEVEL_FOR_EM_YN"));

					allow_recode_diag_yn=checkForNull(rs1.getString("ALLOW_RECODE_DIAG_YN"));
					allow_recode_proc_yn=checkForNull(rs1.getString("ALLOW_RECODE_PROC_YN"));
					allow_ot_proc_recode_yn=checkForNull(rs1.getString("ALLOW_OT_PROC_RECODE_YN"));
					allow_non_ot_proc_recode_yn=checkForNull(rs1.getString("ALLOW_NON_OT_PROC_RECODE_YN"));

					grace_period=rs1.getInt("GRACE_PERIOD");

							
				}
			}	
			if(rs1!=null) rs1.close();
			/*F.Y.I:
				When operator station for a user having more with different Effective dates the commented Query is to be used
			*/
				String crt_sql="select DIAG_PROC_RECODE_FOR_IP_YN, DIAG_PROC_RECODE_FOR_OP_YN from am_oper_stn where facility_id='"+p_facility_id+"'  and OPER_STN_ID = (select OPER_STN_ID from am_user_for_oper_stn where appl_user_id='"+loginUser+"' and facility_id='"+p_facility_id+"' AND trunc(SYSDATE) BETWEEN trunc (NVL(eff_date_from,SYSDATE))AND trunc (NVL(eff_date_to,SYSDATE)))";
			
			rs1 = stmt1.executeQuery(crt_sql);			

						
			if(rs1 != null)
			{									
				while (rs1.next())
				{	
					recode_OP_yn =checkForNull(rs1.getString("DIAG_PROC_RECODE_FOR_OP_YN"));
					recode_IP_yn =checkForNull(rs1.getString("DIAG_PROC_RECODE_FOR_IP_YN"));
				}
			}	
			if(rs1!=null) rs1.close();




		}
		catch(Exception e)
		{
			//out.println("Exception in mr_parameter : "+e.toString());
		}

		
		
		
		String op_grace = "";
		String ip_grace = "";
		try
		{
			stmt = con.createStatement();
			rs	=	stmt.executeQuery("select patient_id_length, to_char(sysdate+1 - "+op_visit+",'dd/mm/yyyy')SystemDate_op, to_char(sysdate+1 - "+ip_disch+",'dd/mm/yyyy')SystemDate_ip,to_char(sysdate,'dd/mm/yyyy')SystemDate,to_char(sysdate,'dd/mm/yyyy')SDate,to_char(sysdate+1 - "+(op_visit+grace_period)+",'dd/mm/yyyy')op_grace,to_char(sysdate+1 - "+(ip_disch+grace_period)+",'dd/mm/yyyy')ip_grace  from mp_param");
			if (rs.next() && rs != null)
			{
				pat_id_length = rs.getString(1);
				SystemDate_op = rs.getString(2);
				SystemDate_ip = rs.getString(3);
				SystemDate = rs.getString(4);
				SDate = rs.getString(5);
				op_grace = rs.getString(6);
				ip_grace = rs.getString(7);

			}
		}catch(Exception e) 
		{
			//out.println("Exception in Sysdate : "+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
		}

		

		SystemDate_op = DateUtils.convertDate(SystemDate_op,"DMY" ,"en",localeName);
		SystemDate_ip = DateUtils.convertDate(SystemDate_ip,"DMY" ,"en",localeName);
		//String SystemDate_display = DateUtils.convertDate(SystemDate,"DMY" ,"en",localeName);
		String SystemDischarge_display = DateUtils.convertDate(SDate,"DMY" ,"en",localeName);
		op_grace = DateUtils.convertDate(op_grace,"DMY" ,"en",localeName);
		ip_grace = DateUtils.convertDate(ip_grace,"DMY" ,"en",localeName);
		String serialNo = "";
		int cutOffVisit = 0;
		String cutOffDischarge = "";
%>
<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 
		<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="patient_id"  value= "" />	
			<jsp:param name ="alert_reqd_yn"   value= ""  />
			<jsp:param name ="mr_transaction"   value= "Y"  />
		</jsp:include>
	
	<table cellpadding='2'  border='0' cellspacing='0' width='100%'  >
		
 <tr>
     <td width="23%" class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td width="24%" class="fields" ><input type=text name='PatientId' id='PatientId' size="" maxlength="<%=pat_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);PatValidations(document.forms[0].PatientId);" onKeypress='return CheckForSpecChars(event);' align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'>
  </td>
<td class="label" nowrap width='24%'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
	<td class="fields" width='30%'><select name='search_by' id='search_by' onChange='getStatus(this);'>
					 <option value='M'><fmt:message key="eMR.MyLevel.label" bundle="${mr_labels}"/></option>
					 <%
					if(!stage_no.equals("1")) {
					%>
					 <option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					 <%}%>
				</select>
			</td>

	</tr>
	<tr>
	<td width="22%" class="label" ><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
		<td  class="fields"><select name="lstPatientClass" id="lstPatientClass" onchange="chkPeriod(this); clearResultPage(this)">
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%
						if(recode_OP_yn.equals("Y")){
							if(recode_for_em_yn.equals("Y"))
								%><option value='EM'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option> <%
						
							if(recode_for_op_yn.equals("Y"))
								%><option value='OP'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option> <%
						}

						if(recode_IP_yn.equals("Y")){
							if(recode_for_dc_yn.equals("Y"))
								%><option value='DC'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option> <%
							
							if(recode_for_ip_yn.equals("Y"))
								%><option value='IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option> <%
						}
						%>
					</select><img src='../../eCommon/images/mandatory.gif' align='center' id='encType_img' style="visibility:hidden"></img></td>
					<td class="label" ><fmt:message key="eMR.DischPeriod.label" bundle="${mr_labels}"/></td>
		<td class="fields" ><input name='p_discharge_date_from' id='p_discharge_date_from'  value='' size='12' maxlength='16' onblur='validDateObj(this,"DMY","<%=locale%>");disChargePeriodChk(this);CompareDisPeriodFromToTime(this,p_discharge_date_to);/*validateDate(this)*/'><img id='d1' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_discharge_date_from');" ></input>-<input name='p_discharge_date_to' id='p_discharge_date_to'  value='' size='12' maxlength='16' onblur='validDateObj(this,"DMY","<%=locale%>");disChargePeriodChk(this);CompareDisPeriodFromToTime(p_discharge_date_from,this);' onkeypress="return Valid_DT(event)"><img id='d2' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_discharge_date_to');"></input>
		<%if(isAllowModifyDiscPeriod){%>
		<img src='../../eCommon/images/mandatory.gif' align='center' id='discDate_img' style="visibility:hidden"><%}%>  <!-- commented by mujafar for ML-MMOH-CRF-1271  enabled by mujafar  for ML-MMOH-CRF-1405 --> 
		</td>

	</tr>
	<tr>
	<td class="label" width="25%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		 <td class='fields'>
		  <select name='speciality_code' id='speciality_code' onchange='clearResultPage(this)'><option value='' > ----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
		  <%
		  String speciality_code=""; 
		  String short_desc=""; 
		  String spSql="select SPECIALITY_CODE,short_desc from am_speciality where eff_status='E' order by 2";
		  rs=stmt.executeQuery(spSql);
				if(rs !=null) 
      		    { 
			    while(rs.next())
			    {
				 speciality_code=rs.getString("speciality_code");
				 short_desc=rs.getString("short_desc");
				 String sel="";
				 /*if (speciality_code.equals(sp_code))
					 sel = "selected";
				 else
					 sel = "";*/
				 out.println("<option value =\""+speciality_code+"\" "+sel+">"+short_desc+"</option>");
			    }
      		    }
      		    %>
      		    </select>
      		    </td>
				<td class="label" width="25%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='fields'>
				<input type='text' name='locn_code' id='locn_code' OnBlur="beforeGetLoc('<%=loginUser%>','<%=p_facility_id%>',locn_code)"><input type="button" name="loc_butt" id="loc_butt" value="?" class="button" onClick="getLocn('<%=loginUser%>','<%=p_facility_id%>',locn_code);">
      		    
				<input type="hidden" name="Hloc" id="Hloc" value="">
				</td>
				</tr>

		<tr>
		<td class="label" width="25%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%"><input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)" align="center"></td>		
		<td  class="label" width="25%"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>
		<td class='fields' width="25%" ><select name="orderBy" id="orderBy" onchange='clearResultPage(this)'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value="ED" selected><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></option>
			<option value="ET"  ><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></option>
			</select>	
			</td>
	</tr>
	<tr>
	<td class='label' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td class='fields'><select name="status" id="status"><option value="PR"  ><fmt:message key="eMR.PendingReview.label" bundle="${mr_labels}"/></option><option value="PC"  ><fmt:message key="Common.PartiallyCompleted.label" bundle="${common_labels}"/></option>
				<option value="C"  ><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
				<option value="A"  ><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></option>
				</select><img src='../../eMP/images/mandatory.gif' id='mand_gif3'>
				</td>
				<td class='label' >&nbsp;</td>
			<td class="button"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'></td>
		</tr>
		</table>

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
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'></input>
	<input type='hidden' name='oper_stn_id1' id='oper_stn_id1' value='<%=oper_stn_id1%>'></input>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
	<input type='hidden' name='SystemDischarge_display' id='SystemDischarge_display' value='<%=SystemDischarge_display%>'></input>
	<input type='hidden' name='serialNo' id='serialNo' value='<%=serialNo%>'></input>
	<input type='hidden' name='cutOffVisit' id='cutOffVisit' value='<%=cutOffVisit%>'></input>
	<input type='hidden' name='cutOffDischarge' id='cutOffDischarge' value='<%=cutOffDischarge%>'></input>
	<input type='hidden' name='SystemDate_op' id='SystemDate_op' value='<%=SystemDate_op%>'></input>
	<input type='hidden' name='SystemDate_ip' id='SystemDate_ip' value='<%=SystemDate_ip%>'></input>
	<input type='hidden' name='stage_no' id='stage_no' value='<%=stage_no%>'></input>
	<input type='hidden' name='op_visit' id='op_visit' value='<%=op_visit%>'></input>
	<input type='hidden' name='ip_disch' id='ip_disch' value='<%=ip_disch%>'></input>
	<input type='hidden' name='grace_period' id='grace_period' value='<%=grace_period%>'></input>
	<input type='hidden' name='max_level_for_op_yn' id='max_level_for_op_yn' value='<%=max_level_for_op_yn%>'></input>
	<input type='hidden' name='max_level_for_ip_yn' id='max_level_for_ip_yn' value='<%=max_level_for_ip_yn%>'></input>
	<input type='hidden' name='max_level_for_dc_yn' id='max_level_for_dc_yn' value='<%=max_level_for_dc_yn%>'></input>
	<input type='hidden' name='max_level_for_em_yn' id='max_level_for_em_yn' value='<%=max_level_for_em_yn%>'></input>
	<input type='hidden' name='op_grace' id='op_grace' value='<%=op_grace%>'></input>
	<input type='hidden' name='ip_grace' id='ip_grace' value='<%=ip_grace%>'></input>
	<input type='hidden' name='reportname' id='reportname' value='<%=reportname%>'></input>
<!-- 	<input type='hidden' name='duration_period' id='duration_period' value=''></input>Commented On 5/14/2010 -->	
	<input type='hidden' name='action_if_not_done' id='action_if_not_done' value='<%=action_if_not_done%>'></input>
	<input type='hidden' name='allow_recode_diag_yn' id='allow_recode_diag_yn' value='<%=allow_recode_diag_yn%>'></input>
	<input type='hidden' name='allow_recode_proc_yn' id='allow_recode_proc_yn' value='<%=allow_recode_proc_yn%>'></input>
	<input type='hidden' name='allow_ot_proc_recode_yn' id='allow_ot_proc_recode_yn' value='<%=allow_ot_proc_recode_yn%>'></input>
	<input type='hidden' name='allow_non_ot_proc_recode_yn' id='allow_non_ot_proc_recode_yn' value='<%=allow_non_ot_proc_recode_yn%>'></input>
	<input type='hidden' name='isAllowModifyDiscPeriod' id='isAllowModifyDiscPeriod' value='<%=isAllowModifyDiscPeriod%>'></input> <!-- Added by mujafar for ML-MMOH-CRF-1405 -->

	
	<script>
		document.getElementById("encType_img").style.visibility = 'visible';
		//document.forms[0].all.encDate_img.style.visibility = 'visible';
	</script>
	

<%
     } catch(Exception e) {
          //out.println(e.toString());
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  e.printStackTrace();
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

