<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%

	request.setCharacterEncoding("UTF-8");	
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<!--<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>-->
	<script language="JavaScript" src="../../ePH/js/TokenSeries.js"></script>
	<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
	<SCRIPT>
		var function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String	mode			=	request.getParameter( "mode" ) ;
	String	bean_id			=	"TokenSeriesBean" ;
	String	bean_name		=	"ePH.TokenSeriesBean";
	String	readOnly		=	"" ;
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
    String  facility_id     = (String)session.getValue("facility_id"); 
//added for audit log
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_TOKEN_SERIES";
	String pkey_value="";
	String status=""; //added for [IN032818]
    int countVal=0;
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	TokenSeriesBean bean = (TokenSeriesBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	int totalRecords	= Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );
    
	countVal =bean.getCountValue();
%>
<form name="formTokenSeries" id="formTokenSeries" id="Token Series Form" >

<%
	if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
		
%>
	<BR><BR>
	<table cellpadding="0" cellspacing="0" width="90%" align="center" border=1 id="tokenSeriesTable_insert">
	<tr>
		<td class="label" colspan="3" style="border:none"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td class="label" colspan="12" style="border:none">&nbsp;
			<select name="disp_locn_code" id="disp_locn_code" onchange="checkOrderStatus(this)" >
				<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%
					ArrayList arrList	=	bean.getDispLocForList();
					for (int i=0;i<arrList.size();i=i+2){
			%>
					<option value="<%=arrList.get(i)%>"><%= arrList.get(i+1)%></option>
			<%
					}
			%>
			</select>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</td>
	</tr>
	<tr>
	  <td colspan="14" style="border:none;" class="white">&nbsp;</td>
	</tr>
	<TR >
		<TH style="border-bottom:none">&nbsp;</TH>
		<TH style="border-bottom:none">&nbsp;</TH>
		<TH style="border-bottom:none"><fmt:message key="ePH.Genarate.label" bundle="${ph_labels}"/></TH>
		<TH style="border-bottom:none"><fmt:message key="Common.Start.label" bundle="${common_labels}"/> </TH>
		<TH colspan="3"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></TH>
		<TH colspan="5"><fmt:message key="ePH.QMS.label" bundle="${ph_labels}"/></TH>
		<TH style="border-bottom:none">&nbsp;</TH>
		<TH style="border-bottom:none">&nbsp;</TH>
	</TR>
	<TR >
		<TH style="border-top:none"><fmt:message key="Common.code.label" bundle="${common_labels}"/></TH>
        <TH style="border-top:none"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
        <TH style="border-top:none"><fmt:message key="ePH.Token.label" bundle="${ph_labels}"/>
		</TH>	
		<TH style="border-top:none"><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></TH>
		<TH ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></TH>
		<TH ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></TH>
		<TH ><fmt:message key="ePH.GenerationUpon.label" bundle="${ph_labels}"/></TH>
		<TH colspan="4"><fmt:message key="Common.required.label" bundle="${common_labels}"/></TH>
		<TH ><fmt:message key="ePH.EditToken.label" bundle="${common_labels}"/></TH>
		<TH style="border-top:none"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TH>
		<TH style="border-top:none"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></TH>
	</TR>

<%
	String classValue="";
	for ( int cnt=0; cnt<totalRecords; cnt++ ) {
		if(cnt%2 ==0)
			classValue="QRYEVEN";
		else
			classValue="QRYODD";
%>

		 <TR>
			<TD CLASS="<%=classValue %>" >
				<INPUT TYPE="text" CLASS='UPPER' name="token_series_code<%=cnt %>" id="token_series_code<%=cnt %>"  SIZE="1" MAXLENGTH="2" <%= readOnly %> onKeyPress="return CheckForSpecChars(event)" onBlur="toUpper(this);TokenSeriesCheck(this);onBlurCheck('<%=cnt%>')">
			</TD>
			<TD CLASS="<%=classValue %>" >
				<INPUT TYPE="text" name="description<%=cnt %>" id="description<%=cnt %>"  SIZE="15" MAXLENGTH="15" onBlur="resetColorCode(this);makeValidString(this);onBlurCheck('<%=cnt%>'); onBlurCheck('<%=cnt%>');">
			</TD>
            <TD CLASS="<%=classValue %>">
				<INPUT TYPE="checkBox" name="gen_token<%=cnt %>" id="gen_token<%=cnt %>" VALUE="Y" CHECKED onclick='ValidateQMS("<%=cnt %>","GEN");'>
			</TD>
			<TD CLASS="<%=classValue %>" >
				<INPUT TYPE="text" name="start_serial_no<%=cnt %>" id="start_serial_no<%=cnt %>" SIZE="6" MAXLENGTH="6" onBlur="resetColorCode(this);makeValidString(this);validateSerialNo(this)" onkeyPress='return allowValidNumber(this,event,6,0)' class="NUMBER" style="text-align:right" oncopy="return false" onpaste="return false">
			</TD>
			<TD CLASS="<%=classValue %>">
				<select name="applicable_sex_ind<%=cnt %>" id="applicable_sex_ind<%=cnt %>">
					<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
				</select>
			</TD>
			<TD CLASS="<%=classValue %>">
				<select name="nationality_ind<%=cnt %>" id="nationality_ind<%=cnt %>">
					<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Nationals.label" bundle="${ph_labels}"/></option>
					<option value="E"><fmt:message key="ePH.Expatriates.label" bundle="${ph_labels}"/></option>
				</select>
			</TD>
			<TD CLASS="<%=classValue %>">
				<select name="Genera_Upon<%=cnt %>" id="Genera_Upon<%=cnt %>"onChange="CheckRegisterStatus(this,'<%=cnt%>')">
					<option value="RG" selected><fmt:message key="Common.RegisterOrder.label" bundle="${common_labels}"/></option>
					<option value="RI"><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/></option>
					<option value="RM"><fmt:message key="ePH.ReturnMedication.label" bundle="${ph_labels}"/></option>
					<option value="DD"><fmt:message key="ePH.DirectDispensing.label" bundle="${ph_labels}"/></option>
					<option value="OR"><fmt:message key="ePH.OrderRelease.label" bundle="${ph_labels}"/></option>
					
				</select>
			</TD>
			<!-- Added for Bru-HIMS-CRF-076 [IN:029942] start -->
			<TD CLASS="<%=classValue %>" colspan="4">
				<INPUT TYPE="checkBox" name="QMS_required<%=cnt %>" id="QMS_required<%=cnt %>" VALUE="N" onclick='ValidateQMS("<%=cnt %>","QMS");'>
			</TD>
			<TD CLASS="<%=classValue %>">
				<INPUT TYPE="checkBox" name="QMS_edit_token<%=cnt %>" id="QMS_edit_token<%=cnt %>" VALUE="N" disabled>
			</TD>
			<!-- Added for Bru-HIMS-CRF-076 [IN:029942] end -->
			<TD CLASS="<%=classValue %>">
				<INPUT TYPE="checkBox" name="eff_status<%=cnt %>" id="eff_status<%=cnt %>" VALUE="E" CHECKED >
			</TD>
			<TD CLASS="<%=classValue %>">
				<INPUT TYPE="checkBox" name="select<%=cnt %>" id="select<%=cnt %>" VALUE="E" >
			</TD>
		</TR>
<%
	}
%>
	</table>
<%
	}
	else if (mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )){
		try{
		String disp_locn_code = request.getParameter("disp_locn_code");
		String token_series_code = request.getParameter("token_series_code");
		String token_gen_stage="";
		token_gen_stage = request.getParameter("token_gen_stage");
		if(token_gen_stage!=null){
			token_gen_stage=token_gen_stage.trim();
			if(token_gen_stage.equals("RegisterOrder")){
				token_gen_stage="RG";
			}
			else if(token_gen_stage.equals("OrderRelease")){
				token_gen_stage="OR";
			}
			else if(token_gen_stage.equals("ReissueMedication")){
				token_gen_stage="RI";
			}
			else if(token_gen_stage.equals("ReturnMedication")){
				token_gen_stage="RM";
			}
			else if(token_gen_stage.equals("DirectDispensing")){
				token_gen_stage="DD";
			}
		}
		bean.setTokenGenStage(token_gen_stage);
		bean.clear();
		bean.loadData(disp_locn_code.trim(),token_series_code.trim());
		String effStatusCheck = bean.getEffStatus();
		String disableAll="";
		String QMS_required_yn = bean.getQMSReq(); //Added for Bru-HIMS-CRF-076 [IN:029942]
		String QMS_edit_token_yn = bean.getQMSEditToken(); //Added for Bru-HIMS-CRF-076 [IN:029942]
		String QMS_enable="", edit_start_srl_no=""; //Added for Bru-HIMS-CRF-076 [IN:029942]
		if (effStatusCheck.equals("E")){
			status="E"; //added for [IN032818]
			effStatusCheck = "checked";
			disableAll = "";
		}
		else{
			effStatusCheck = "";
			status=""; //added for [IN032818]
			disableAll = "disabled";
			QMS_enable = "disabled"; //Added for Bru-HIMS-CRF-076 [IN:029942]
		}
		if(QMS_required_yn!=null && QMS_required_yn.equals("Y"))
			edit_start_srl_no = "readOnly";
		String gentokenCheck1=bean.getGenToken();
		String gentokenCheck="";

		if (gentokenCheck1.equals("Y")){
			gentokenCheck = "checked";		
		}
		else{
			gentokenCheck = "";		
		}
		String	applicableSexInd	= (bean.getApplicableSexInd()).trim();
		String  selectMale = "",selectFemale="",selectBoth="";
		if (applicableSexInd.equals("B")){
			selectBoth = "selected";
		}
		else if (applicableSexInd.equals("M")){
			selectMale = "selected";
		}
		else if (applicableSexInd.equals("F")){
			selectFemale = "selected";
		}
		String	nationalityInd		= bean.getNationalityInd();
		String  selectNationals = "",selectExpatriates="",selectBothNID="";
		if (nationalityInd.equals("B")){
			selectBothNID	= "selected";
		}
		else if (nationalityInd.equals("N")){
			selectNationals = "selected";
		}
		else if (nationalityInd.equals("E")){
			selectExpatriates = "selected";
		}
		String modifyNotAllowedValue = (String)bean.allowToChange();;
		String modifyNotAllowed = "";
		if (modifyNotAllowedValue.equals("Y")){
			modifyNotAllowed = "";
		}
		else{
			modifyNotAllowed = "disabled";
			QMS_enable = "disabled"; //Added for Bru-HIMS-CRF-076 [IN:029942]
		}
		/*-------------------------code added for showing audit log---------------------------*/
		//code for adding pk_values
		ArrayList Pk_values    =new ArrayList();
		Pk_values.add(bean.getLoggedInFacility());      
		Pk_values.add(disp_locn_code.trim());      
		Pk_values.add(token_series_code);      

		String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
		if(display_audit_log_button_yn.equals("Y")){
			audit_log_visible= "visibility:visible";
			pkey_value       = (String)log_bean.getpk_value();
		}
		else{
			audit_log_visible= "visibility:hidden";
			pkey_value="";
			log_bean.clear();
		}
		if(token_gen_stage==null){
			token_gen_stage=bean.getGeneraUpon();
		}
        //int cntVal=0;
		String defaultStage="";

		if(token_gen_stage.equals("RG")){
			defaultStage="selected";
		}
		else{
			defaultStage="";
			QMS_required_yn = ""; //Added for Bru-HIMS-CRF-076 [IN:029942]
			QMS_edit_token_yn = ""; //Added for Bru-HIMS-CRF-076 [IN:029942]
			QMS_enable ="disabled"; //Added for Bru-HIMS-CRF-076 [IN:029942]
		}
		//cntVal=bean.getQueryVal(facility_id,disp_locn_code,token_series_code,token_gen_stage,status); // token_series_code,token_gen_stage,status added for [IN032818]
	/*--------------------------------------ends here---------------------------------------*/
%>
	<br><br><br><br><br><br><br><br>
		<table cellpadding=0 cellspacing=0 width="90%" align="center" id="tokenSeriesTable" border="0">
		<tr>
			<th colspan="5"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<td class="label" colspan="2" style="width:40%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td colspan="2" style="width:60%">&nbsp;
				<input type="text" name="disp_locn_code" id="disp_locn_code" size="6" maxlength="6" disabled value="<%=disp_locn_code %>">
			</td>
			<td class="label"><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></td>

		</tr>
		<tr>
			<td class="label" colspan="2" style="width:40%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td colspan="3" style="width:60%">&nbsp;
				<input type="text" name="disp_locn_desc" id="disp_locn_desc" size="15" maxlength="15" disabled value="<%=bean.getDispLocnDesc()%>">
			</td>
		</tr>
		<tr>
			<th colspan="5"><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<td class="label" colspan="2" style="width:40%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td colspan="3" style="width:60%">&nbsp;
				<input type="text" name="token_series_code" id="token_series_code" size="2" maxlength="2"  value="<%=token_series_code%>" <%=disableAll%>>
			</td>
		</tr>
		<tr>
			<td class="label" colspan="2" style="width:40%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td colspan="3" style="width:60%">&nbsp;
				<input type="text" name="token_series_desc" id="token_series_desc" size="15" maxlength="15" <%=disableAll%> value="<%=bean.getTokenSeriesDesc()%>">
			</td>
		</tr>
         <tr>
			<td class="label" colspan="2" style="width:40%"><fmt:message key="ePH.GenerateToken.label" bundle="${ph_labels}"/></td>
			<td colspan="3" style="width:60%" class='label'>&nbsp;<input type="checkbox" name="gen_token" id="gen_token" value="<%=gentokenCheck1%>" <%=gentokenCheck%>  <%=disableAll%> onclick='ValidateQMS("-1","GEN");'>
			</td>
		</tr>
          <tr>
		  <td class="label" colspan="2" style="width:40%"><fmt:message key="ePH.GenerationUpon.label" bundle="${common_labels}"/></td>
		  
           <td colspan="3" style="width:60%">&nbsp;
		     <select name="Genera_Upon" id="Genera_Upon" <%=disableAll%> onchange="ValidateQMS('-1', 'GENUP');">
				<option value="RG" <%=defaultStage%>><fmt:message key="Common.RegisterOrder.label" bundle="${common_labels}"/></option>
<%
				 //[IN032818]  Added on medication value and count from method return -- begin 
				HashMap hmStageWiseCount=bean.getCountForTokenGenStages(facility_id,disp_locn_code,token_series_code );
				ArrayList GenTokenUponYN=bean.GenTokenUponYN(facility_id,disp_locn_code,locale);
				String ReIssueMediYN=(String)GenTokenUponYN.get(0);
				String ReturnMediYN=(String)GenTokenUponYN.get(1);
				String DirectDispYN=(String)GenTokenUponYN.get(2);
				int count = 0;
				if(hmStageWiseCount !=null && hmStageWiseCount.size()>0){
					if(ReturnMediYN.equals("Y")){
						if(hmStageWiseCount.containsKey("RM"))
							count=Integer.parseInt(hmStageWiseCount.get("RM").toString());
						if(token_gen_stage.equals("RM"))
							defaultStage="selected";
						else
							defaultStage="";
						if(count==0){
%>
						 <option value="RM" <%=defaultStage%>><fmt:message key="ePH.ReturnMedication.label" bundle="${ph_labels}"/></option>
<%
						}
					}
					if(ReIssueMediYN.equals("Y")){
						count=0;
						if(hmStageWiseCount.containsKey("RI"))
							count=Integer.parseInt(hmStageWiseCount.get("RI").toString());
						if(token_gen_stage.equals("RI"))
							defaultStage="selected";
						else
							defaultStage="";
						if(count==0){
%>
						<option value="RI" <%=defaultStage%>><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/></option>
<%
						}
					}
					count=0;
					if(hmStageWiseCount.containsKey("OR"))
						count=Integer.parseInt(hmStageWiseCount.get("OR").toString());
					if(token_gen_stage.equals("OR"))
						defaultStage="selected";
					else
						defaultStage="";
					if(count==0){
%>
			          <option value="OR" <%=defaultStage%>><fmt:message key="ePH.OrderRelease.label" bundle="${ph_labels}"/></option>
<%
					}
					if(DirectDispYN.equals("Y")){
						count=0;
						if(hmStageWiseCount.containsKey("DD"))
							count=Integer.parseInt(hmStageWiseCount.get("DD").toString());
						if(token_gen_stage.equals("DD"))
							defaultStage="selected";
						else
							defaultStage="";
						if(count==0){
%>
						 <option value="DD" <%=defaultStage%>><fmt:message key="ePH.DirectDispensing.label" bundle="${ph_labels}"/></option>
<%
						}
					}
				}
				else{
			        if(token_gen_stage.equals("RM")){
%>
						<option value="RM" selected><fmt:message key="ePH.ReturnMedication.label" bundle="${ph_labels}"/></option>
<%
						if(ReIssueMediYN.equals("Y")){
%>
			    			<option value="RI"><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/></option>
<%
						}
%>
			    		<option value="OR"><fmt:message key="ePH.OrderRelease.label" bundle="${ph_labels}"/></option>
<%
						if(DirectDispYN.equals("Y")){
%>
			    			<option value="DD"><fmt:message key="ePH.DirectDispensing.label" bundle="${ph_labels}"/></option>
<%
						}
					}
					if(token_gen_stage.equals("RI")){
						if(ReturnMediYN.equals("Y")){
%>
			      			<option value="RM"><fmt:message key="ePH.ReturnMedication.label" bundle="${ph_labels}"/></option>
<%
						}
%>
		      			<option value="RI" selected><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/></option>
						<option value="OR"><fmt:message key="ePH.OrderRelease.label" bundle="${ph_labels}"/></option>
<%
						if(DirectDispYN.equals("Y")){
%>
			      			<option value="DD"><fmt:message key="ePH.DirectDispensing.label" bundle="${ph_labels}"/></option>
<%
						}
					}
					if(token_gen_stage.equals("DD")){ 
						if(ReturnMediYN.equals("Y")){
%>
			      			<option value="RM"><fmt:message key="ePH.ReturnMedication.label" bundle="${ph_labels}"/></option>
<%
						}
						if(ReIssueMediYN.equals("Y")){
%>
			      			<option value="RI"><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/></option>
<%
						}
%>
						<option value="OR" ><fmt:message key="ePH.OrderRelease.label" bundle="${ph_labels}"/></option>
						<option value="DD" selected><fmt:message key="ePH.DirectDispensing.label" bundle="${ph_labels}"/></option>
<%
					}
					if(token_gen_stage.equals("OR")){ 
						if(ReturnMediYN.equals("Y")){
%>
			      			<option value="RM"><fmt:message key="ePH.ReturnMedication.label" bundle="${ph_labels}"/></option>
<%
						}
						if(ReIssueMediYN.equals("Y")){
%>
			      			<option value="RI"><fmt:message key="ePH.ReissueMedication.label" bundle="${ph_labels}"/></option>
<%
						}
%>
			      		<option value="OR" selected><fmt:message key="ePH.OrderRelease.label" bundle="${ph_labels}"/></option>
<%
						if(DirectDispYN.equals("Y")){
%>
							<option value="DD"><fmt:message key="ePH.DirectDispensing.label" bundle="${ph_labels}"/></option>
<%
						}
					} //[IN032818]  Added on medication value and count from method return -- End
		      }
%>
				</select>
				
				<input TYPE="hidden" name="token_gen_stage" id="token_gen_stage" value="<%= token_gen_stage %>">
				</td>
             	</tr>
		<tr>
			<td class="label" colspan="2" style="width:50%"><fmt:message key="Common.StartSerialNo.label" bundle="${common_labels}"/></td>
			<td colspan="3" style="width:50%">&nbsp;
				<input type="text" name="start_serial_no" id="start_serial_no" size="6" maxlength="6" value="<%=bean.getStartSeriesNo()%>" onBlur="validateSerialNo(this);" onkeyPress='return allowValidNumber(this,event,6,0)' <%=disableAll%> class="NUMBER" <%=modifyNotAllowed%> <%=edit_start_srl_no%> oncopy="return false" onpaste="return false">&nbsp;&nbsp;&nbsp;
				<input type="hidden" name="modified_not_allowed" id="modified_not_allowed" value="<%=modifyNotAllowedValue%>">
			</td>
		</tr>
		<!-- Added for Bru-HIMS-CRF-076 [IN:029942] start -->
		<tr>
			<td class="label" colspan="2" style="width:50%">
				<fmt:message key="ePH.QMS.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.required.label" bundle="${common_labels}"/></td>
				<td class="label" colspan="4">
<%
				if(QMS_required_yn!=null && QMS_required_yn.equals("Y")){
%>
					<input type="checkbox" name="QMS_required" id="QMS_required" value="<%=QMS_required_yn%>" checked  <%=QMS_enable%>  onclick='ValidateQMS("-1","QMS");'>
<%
				}
				else{
%>
					<input type="checkbox" name="QMS_required" id="QMS_required" value="<%=QMS_required_yn%>"   <%=QMS_enable%> onclick='ValidateQMS("-1","QMS");'>
<%
					QMS_enable = "disabled";
				}
%>
				&nbsp;&nbsp;
				<fmt:message key="ePH.EditToken.label" bundle="${common_labels}"/>&nbsp;&nbsp;
<%
				if(QMS_edit_token_yn!=null && QMS_edit_token_yn.equals("Y")){
%>
					<input type="checkbox" name="QMS_edit_token" id="QMS_edit_token" value="<%=QMS_edit_token_yn%>" checked  <%=QMS_enable%> >
<%
				}
				else{
%>
					<input type="checkbox" name="QMS_edit_token" id="QMS_edit_token" value="<%=QMS_edit_token_yn%>" <%=QMS_enable%> >
<%
				}
%>
			</td>
		</tr>
		<!-- Added for Bru-HIMS-CRF-076 [IN:029942] end -->		
		<tr>
			<td class="label" colspan="2" style="width:50%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td colspan="3" style="width:50%">&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E" <%=effStatusCheck%>>
			</td>
		</tr>
		<tr>
			<th colspan="5"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></th>
		</tr>
		<tr>
			 <td class="label"></td>
			<td class="label">
				<fmt:message key="Common.gender.label" bundle="${common_labels}"/>
			</td>
			<td width="15%">&nbsp;
				<select name="applicable_sex_ind" id="applicable_sex_ind" <%=disableAll%> >
					<option value="B" <%=selectBoth%>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option value="M" <%=selectMale%>><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value="F" <%=selectFemale%>><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td class="label" width="10%">
				<fmt:message key="Common.nationality.label" bundle="${common_labels}"/>
			</td>
			<td>
				<select name="nationality_ind" id="nationality_ind" <%=disableAll%>>
					<option value="B" <%=selectBothNID%>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option value="N" <%=selectNationals%>><fmt:message key="ePH.Nationals.label" bundle="${ph_labels}"/></option>
					<option value="E" <%=selectExpatriates%>><fmt:message key="ePH.Expatriates.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
		</tr>

	</table>
<%
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>
	<input TYPE="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">

<%
	if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
%>
	<script language="javascript">
		document.getElementById("disp_locn_code").focus();
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	}
%>
</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

