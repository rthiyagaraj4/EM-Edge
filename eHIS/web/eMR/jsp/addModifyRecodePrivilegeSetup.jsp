<!DOCTYPE html>

<!--
*	Copyright � iSoft Solutions (P) Ltd.
*	
	Module			:   eMR
	Function		:  Recode Set Up
*	Created On		:	18 Dec 2008
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>

<html>
	<head>
	<script>
	function setVariable(obj,obj2){
		if(obj.checked){
			obj2.value="Y";
		}
		else{
			obj2.value="N";
		}

}
	</script>
	
		<%	

		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		 String locale = ((String)session.getAttribute("LOCALE"));
		 //String _select_colr="";
		
		String _stage_code="";
		String _stage_desc="";
		String  _serial_no="";
		String _colour_ind="";
		String _text_colour_ind="";
		String _specific_ind="";
		String _cf_pr_fr_recode_dys_fm_vstcmpl="";
		String _cf_pr_fr_recode_dys_fm_disc="";
		String _action_if_not_done="";
		String _allow_authorization_yn="";
		String _confirm_not_appl = "Y"; //added by mujafar for ML-MMOH-CRF-0878
		String _confirm_chk="checked";
		Boolean isConfirmApplicable = false; // added by mujafar for ML-MMOH-CRF-0878
		String _select_colr_BR="";
		String _select_colr_Y="";
		
		String _select_colr_B="";
		String _select_colr_R="";
		String _select_colr_DB="";
		String _select_colr_MA="";
		String _select_colr_P="";
		String _select_colr_C="";
		String _select_colr_G="";

		String _txt_BL="";
		String _txt_WH="";

		String _spc_ind_s="";
		String _spc_ind_a="";

		String _action_s="";
		String _action_a="";
		//String _all_chk="";

		String _mr_drg_dis="";
		String _mrParam_IPDC_dis="";
		String _mrParam_OPEM_dis="";

		String _update_mode_yn=checkForNull(request.getParameter("_update_mode_yn"));
		String _spec_user_id=checkForNull(request.getParameter("_spec_user_id"));
		//String dis_chk="";
		String _sel_stage_no1="";
		String _sel_stage_no2="";
		String _sel_stage_no3="";


		int authStage=0;
		//String stageDisable=" ";

		

         String disab_code="";
		if(_update_mode_yn.equals("update_db")){
			disab_code="disabled";
			_stage_code=checkForNull(request.getParameter("_stage_code"));
          _stage_desc=checkForNull(request.getParameter("_stage_desc"));
          _serial_no=checkForNull(request.getParameter("_serial_no"));
          _colour_ind=checkForNull(request.getParameter("_colour_ind"));

		  if(_serial_no.equals("1"))
			  _sel_stage_no1="selected";
		  else if(_serial_no.equals("2"))
			  _sel_stage_no2="selected";
		  else if(_serial_no.equals("3"))
			  _sel_stage_no3="selected";


		  if(_colour_ind.equals("BROWN"))
			_select_colr_BR="selected";
		else if(_colour_ind.equals("YELLOW"))
			   _select_colr_Y="selected";
	   else if(_colour_ind.equals("GREEN"))
			  _select_colr_G="selected";
	  else if(_colour_ind.equals("BLUE"))
		_select_colr_B="selected";
	  else if(_colour_ind.equals("RED"))
		 _select_colr_R="selected";
		else if(_colour_ind.equals("DARK BLUE"))
		  _select_colr_DB="selected";
	  else if(_colour_ind.equals("MAGENTA"))
		 _select_colr_MA="selected";
	  else if(_colour_ind.equals("PINK"))
		 _select_colr_P="selected";
	  else if(_colour_ind.equals("CYAN"))
		_select_colr_C="selected";
	   else if(_colour_ind.equals("GRAY"))
		_select_colr_G="selected";

          _text_colour_ind=checkForNull(request.getParameter("_text_colour_ind"));
		 if(_text_colour_ind.equals("BL"))
			 _txt_BL="selected";
		 else if(_text_colour_ind.equals("WH"))
			 _txt_WH="selected";
          _specific_ind=checkForNull(request.getParameter("_specific_ind"));
		  if(_specific_ind.equals("SPC"))
			  _spc_ind_s="selected";
		  else if(_specific_ind.equals("*ALL"))
                _spc_ind_a="selected";
          _cf_pr_fr_recode_dys_fm_vstcmpl=checkForNull(request.getParameter("_cf_pr_fr_recode_dys_fm_vstcmpl"));
          _cf_pr_fr_recode_dys_fm_disc=checkForNull(request.getParameter("_cf_pr_fr_recode_dys_fm_disc"));
          _action_if_not_done=checkForNull(request.getParameter("_action_if_not_done"));
		  if(_action_if_not_done.equals("S"))
               _action_s="selected";
		 else if(_action_if_not_done.equals("A"))
               _action_a="selected";
          _allow_authorization_yn=checkForNull(request.getParameter("_allow_authorization_yn"));
		  
		  _confirm_not_appl = checkForNull(request.getParameter("_confirm_not_appl")); //added by mujafar for ML-MMOH-CRF-0878
		  
		  if(_confirm_not_appl.equals("N"))
			      _confirm_chk="";
		  else
			  _confirm_chk = "checked";
		  
		/*  if(_allow_authorization_yn.equals("Y")){
				_all_chk="checked";
//				dis_chk="disabled";
		  }else{
				_all_chk="";
//				dis_chk="disabled";
			}*/
          
		}
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script language='javascript' src='../../eMR/js/RecodePrivilegeSetup.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
		<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onKeyDown='lockKey()'  OnMouseDown='CodeArrest()' onLoad="EnableAlowAuth();" >
		<form >
			<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>
				<tr>
					<td width='30vw'></td>
					<td width='70vw'></td>
					
				</tr>
				<!--
				<tr>
					<td class=label ><fmt:message key="Common.StageCode.label" bundle="${common_labels}"/></td>
					<td width='25%' class="fields"><input type="text" name="stage_code" id="stage_code" <%=disab_code%> value='<%=_stage_code%>'   size=2  maxlength=2   onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)">
					<img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
				-->
				<%
				Connection conn  =  ConnectionManager.getConnection(request);
				    PreparedStatement _stmt = null;
					ResultSet _rset=null;
				try{
					isConfirmApplicable      = eCommon.Common.CommonBean.isSiteSpecific(conn, "MR", "CONFIRM_IN_RECODE_APPL"); // added by mujafar for ML-MMOH-CRF-0878
//					String sql="SELECT * from mr_parameter";
					String sql="SELECT AUTH_AT_STAGE  from mr_parameter";
					_stmt = conn.prepareStatement(sql);
					_rset = _stmt.executeQuery();
					_rset.next();
					authStage=_rset.getInt("AUTH_AT_STAGE");
					if(_stmt!=null)_stmt.close();
					if(_rset!=null)_rset.close();

					/*if(authStage>1 || authStage==1)
						stageDisable="";
					else
						stageDisable="disabled";*/
				%>
				<tr>
					<td class=label >
					<fmt:message key="Common.Stage.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.no.label" bundle="${common_labels}"/>
					</td>
					<td class='fields' ><select name="srl_no" id="srl_no" <%=disab_code%> onChange="stageAuth(this,'<%=authStage%>')">
					
						<option value="1" <%=_sel_stage_no1%> >1</option>
						<option value="2" <%=_sel_stage_no2%>>2</option>
						<option value="3" <%=_sel_stage_no3%>>3</option>
						
						</select><img src='../../eCommon/images/mandatory.gif'>
					
					</td>
					
				</tr>
				<tr>
					<td class=label ><fmt:message key="Common.Stage.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td  class="fields"><input type="text" name="stage_description" id="stage_description" value='<%=_stage_desc%>'  size=30 maxlength=30 >
					<img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
			<!-- Note:
					The Color And Text Color Fields Are removed(For Time Being) 
					and Created Two Hidden Fields With The same name  @ line 312 and 313
			-->

				<tr>
					<td class=label ><fmt:message key="eOT.SpecificIndicator.Label" bundle="${ot_labels}"/></td>
					<td  class="fields">
					<select name="specific_indicator" id="specific_indicator" onChange="ChkApplcationposition(this)">
						<option value="SPC" <%=_spc_ind_s%>><fmt:message key="eOT.SpecificUsers.Label" bundle="${ot_labels}"/></option>
						<option value="*ALL" <%=_spc_ind_a%>><fmt:message key="eOT.AllUsers.Label" bundle="${ot_labels}"/></option>
						
						</select>
					</td>
				</tr>
				<%
				
					StringBuffer _getdbV_sql=new StringBuffer();
					if(_update_mode_yn.equals("")){	
						if(_getdbV_sql.length() > 0) _getdbV_sql.delete(0,_getdbV_sql.length());
							_getdbV_sql.append("SELECT * from mr_parameter");
							_stmt = conn.prepareStatement(_getdbV_sql.toString());
							_rset = _stmt.executeQuery();
							_rset.next();
							String drg_calculation_yn=_rset.getString("DRG_CALCULATION_YN");
							String recode_for_op_yn=_rset.getString("RECODE_FOR_OP_YN");
							String recode_for_em_yn=_rset.getString("RECODE_FOR_EM_YN");
							String recode_for_ip_yn=_rset.getString("RECODE_FOR_IP_YN");
							String recode_for_dc_yn=_rset.getString("RECODE_FOR_DC_YN");

							if(drg_calculation_yn.equals("N"))
								_mr_drg_dis="disabled";
							else
								_mr_drg_dis="";
							if(recode_for_op_yn.equals("N") ||recode_for_em_yn.equals("N"))
								_mrParam_OPEM_dis="disabled";
							else
								_mrParam_OPEM_dis="";

							if(recode_for_ip_yn.equals("N") ||recode_for_dc_yn.equals("N"))
								_mrParam_IPDC_dis="disabled";
							else
								_mrParam_IPDC_dis="";
					}
				}catch(Exception ex_Parameter){
						ex_Parameter.printStackTrace();
					}finally{
						if(_stmt!=null)_stmt.close();
						if(_rset!=null)_rset.close();
						//if(conn!=null)conn=null;
						ConnectionManager.returnConnection(conn,request);

					}
				%>
				<%
				// below code added for 241 runiin site Date:Friday, February 12, 2010 icn:241
				if(_cf_pr_fr_recode_dys_fm_vstcmpl.equals("0"))
				{
					_cf_pr_fr_recode_dys_fm_vstcmpl="";
				}
				if(_cf_pr_fr_recode_dys_fm_disc.equals("0"))
				{
					_cf_pr_fr_recode_dys_fm_disc="";
				} 
				
				%>


				<tr>

					<td class=label ><fmt:message key="eMR.CutOffPeriodForRecoding.label" bundle="${mr_labels}"/></td>
					<td class="fields"><input type="text" name="cutoff_period" id="cutoff_period"  <%=_mrParam_IPDC_dis%>  value="<%=_cf_pr_fr_recode_dys_fm_vstcmpl%>"  size=3 maxlength=3 onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chkAllZeros(this)'>&nbsp;&nbsp;
					<fmt:message key="eMR.DaysFromVisitCompletion.label" bundle="${mr_labels}"/>&nbsp;/&nbsp;
					<input type="text" name="days_fromVisit" id="days_fromVisit" <%=_mrParam_OPEM_dis%> value="<%=_cf_pr_fr_recode_dys_fm_disc%>"  size=3 maxlength=3 onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='chkAllZeros(this)'>&nbsp;
					<fmt:message key="eMR.daysfromdischarge.label" bundle="${mr_labels}"/>
					</td>
					
				</tr>

				<tr>
					<td class="label" >
					<fmt:message key="eMR.AllowAuthorization.label" bundle="${mr_labels}"/>
					<td class="fields"><input type="checkbox" name="allow_auth" id="allow_auth"  onClick="setCheckValue();setAllusers(); setVariable(this,'chkAuth');validateAuth(this)">
					</td>
				</tr>

				<tr>
					<td class=label ><fmt:message key="eMR.ActionIfNotDone.label" bundle="${mr_labels}"/></td>
					<td  class="fields"><select name="action_ifnot_done" id="action_ifnot_done" onChange="/*ChkApplcationposition(this);*/">
					<option value="S" <%=_action_s%>><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option>
					<option value="A" <%=_action_a%>><fmt:message key="Common.Alert.label" bundle="${common_labels}"/></option>
					</select>
					</td>
				</tr>
				<%
				if(isConfirmApplicable)	 // added by mujafar for ML-MMOH-CRF-0878
				{					
				%>
				<tr>
					<td class="label" >
					<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>
					<td class="fields"><input type="checkbox" name="confirm_not_appl" id="confirm_not_appl"  <%=_confirm_chk%>  value=<%=_confirm_not_appl%>  onClick="setConfirmValue()" >
					</td>
				</tr>
				
				<%}%>
				
				<!--
				<tr>
					<td>
						<table  width='100%'  align=center>
							<tr>
							<td class='SECONDSELECTED' id='users'   align=left style='cursor:pointer;' nowrap onclick="users_search('users');"><font color='black'><fmt:message key="eSM.Users.label" bundle="${sm_labels}"/></font></td>
							<td class='FIRSTNORMAL' id='criteria'  align=left style='cursor:pointer;' nowrap onclick="criteria_search('criteria');"><font color='black'><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></font></td>
						</tr>
						</table>
					</td>
				</tr>
				-->
				</table>
				<input type='hidden' name='term_set' id='term_set' value="">
				<INPUT TYPE='hidden' name='_update_mode_yn' id='_update_mode_yn' VALUE="<%=_update_mode_yn%>">
				<INPUT TYPE='hidden' name='_spec_user_id' id='_spec_user_id' VALUE="<%=_spec_user_id%>">
				<INPUT TYPE='hidden' name='locale' id='locale' VALUE="<%=locale%>">
				<INPUT TYPE='hidden' name='authStage' id='authStage' VALUE="<%=authStage%>">
				<INPUT TYPE='hidden' name='_allow_authorization_yn' id='_allow_authorization_yn' VALUE="<%=_allow_authorization_yn%>">
				<input type="hidden" name="chkAuth" id="chkAuth" value="N">
				<input type="hidden" name="color_ind" id="color_ind" value="BROWN">
				<input type="hidden" name="text_color" id="text_color" value="BL">
				<input type='hidden' name='isConfirmApplicable' id='isConfirmApplicable' VALUE="<%=isConfirmApplicable%>"> <!-- added by mujafar for ML-MMOH-CRF-0878 -->
			

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

