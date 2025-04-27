<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
        request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
		<script language="JavaScript" src="../js/LabelText.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  onload='FocusFirstElement()' >
<%
		String mode	= request.getParameter( "mode" ) ;
		String bean_id = "LabelTextBean" ;
		String bean_name = "ePH.LabelTextBean";
		String log_bean_id		= "SetupAuditLogBean" ;
		String log_bean_name	= "ePH.SetupAuditLogBean";
		String audit_log_visible="visibility:hidden";
		String table_id			="PH_LABEL_TEXT";
		String pkey_value		="";
		String readonly = "" ;
		String IDReadOnly="";
		String disabled = "" ;
		String checked="checked";
		String label_text_id= "";
		String label_text_1="";
		String label_text_2="";
		String label_text_type="";
		String label_text_1_loc_lang="";
		String label_text_2_loc_lang="";
		String eff_status="";
		String fetchedval="";                    

		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
		LabelTextBean bean = (LabelTextBean)getBeanObject( bean_id,  bean_name , request) ;
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setLanguageId(locale);
		bean.YNforLocLang();//function call to get the param from ph_param to dislay in local language
		String PARAM_YN=(String)bean.getPARAM_YN();
		bean.fetchCautionTextMax();
		String caution_text_max_200=bean.getCautionTextMax();
		String localDescDisplay = "display:none", strLocalAlign="";
		SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
		log_bean.setLanguageId(locale);
		int iDescsize = 60, iDescMax=60;

		if (mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
			label_text_id	=	request.getParameter( "label_text_id" )==null?"":request.getParameter( "label_text_id" ) ;
			IDReadOnly="readonly";
			ArrayList record= bean.getDataForHyperLink(label_text_id.trim());
			if (record.size()>1){
				label_text_type= record.get(1)==null?"":(String)record.get(1);
				label_text_1=record.get(2)==null?"":(String)record.get(2);
				label_text_2=record.get(3)==null?"":(String)record.get(3);
				label_text_1_loc_lang=record.get(4)==null?"":(String)record.get(4);
				label_text_2_loc_lang=record.get(5)==null?"":(String)record.get(5);
				eff_status=record.get(6)==null?"":(String)record.get(6);
			}
			if(label_text_type.equals("SpecialInstructions")){
				fetchedval="S";
			}
			else if(label_text_type.equals("Cautions")){
				fetchedval="C";
			}
			if (eff_status.equals("D")){
				checked="";	
				readonly = "readonly" ;
				disabled = "disabled" ;
			}
		}
  /*-------------------------code added for showing audit log---------------------------*/
		ArrayList Pk_values    =new ArrayList();
		Pk_values.add(label_text_id);      
		
		String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
		pkey_value   ="";
		if(display_audit_log_button_yn.equals("Y")){
			audit_log_visible= "visibility:visible";
			pkey_value       = (String)log_bean.getpk_value();
		}
		else{
			audit_log_visible= "visibility:hidden";
			log_bean.clear();
		}/*--------------------------------------ends here---------------------------------------*/
		if(PARAM_YN.equals("Y") || caution_text_max_200.equals("Y")) //added for MMS-QH-CRF-0200 [IN:052044] -start
			localDescDisplay = "display:inline";
		if(caution_text_max_200.equals("Y")){
			iDescsize = 140;
			iDescMax=200;
			strLocalAlign = "text-align:right";
		} //MMS-QH-CRF-0200 [IN:052044] -end
%>
		<form name="formLabelText" id="formLabelText" method='post' target='messageFrame'> <!--action='LabelTextTemp.jsp removed for MMS-QH-CRF-0200 [IN:052044]-->
			<table cellpadding=0  border="0" cellspacing=0 width="91%" align="center" cols=4 >
				<tr >
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr >
					<td class="label" width="30%" ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
					<td>&nbsp;
					<input type="text" name="label_text_id" id="label_text_id" value="<%=label_text_id%>" size="1" maxlength="2" onBlur="toUpper(this);LabelTextCheck(this);"  onKeyPress="return CheckForSpecChars( event );"  <%=IDReadOnly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
					</td>
					<td> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
				</tr>

				<tr >
					<td colspan="3">&nbsp;</td>
				</tr>

<%
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )){
%>
				<tr >
					<td class="label" ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
					<td colspan="2" >&nbsp;&nbsp;<SELECT name="label_text_type" id="label_text_type" >
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
					<option value="C"><fmt:message key="ePH.Caution.label" bundle="${ph_labels}"/></option>
					<option value="S"><fmt:message key="ePH.SpecialInstructions.label" bundle="${ph_labels}"/>
					</option>
					</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
					</td>
				<tr >
					<td colspan="3">&nbsp;</td>
				</tr>
<%
			}
			else if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )){		
%>
				<tr >
					<td class="label" ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
					<td colspan="2" class="label">
						<SELECT name="label_text_type" id="label_text_type" <%=disabled%>>
						<option value="<%=fetchedval%>"><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+label_text_type+".label","ph_labels")%></option>
<% 
						if(fetchedval.equals("S")){
%>
							<option value="C"><fmt:message key="ePH.Caution.label" bundle="${ph_labels}"/></option>
<%
						}
						else{
%>
							<option value="S"><fmt:message key="ePH.SpecialInstructions.label" bundle="${ph_labels}"/></option>
<%
						}
%>
						</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
					</td>
				</tr>
				<tr >
					<td colspan="3">&nbsp;</td>
				</tr>
<%
			}//else modify ends
%>
		<tr>
			<td  class="label"  nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td  colspan="2">&nbsp;
			<input type="text" name="label_text_1" id="label_text_1" size="<%=iDescsize%>" maxlength="<%=iDescMax%>" onKeyPress="if(event.keyCode==38) {return false;}" onBlur="makeValidString(this);" value="<%=label_text_1%>"  <%=readonly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
		</tr>
		<tr > 
			<td colspan="3" style="display:none">&nbsp;</td>
		</tr>
		<tr style="display:none">
			<td  class="label"  nowrap><fmt:message key="Common.Text.label" bundle="${common_labels}"/> 2</td>
			<td  colspan="2">&nbsp;
			<input type="text" name="label_text_2" id="label_text_2" size="<%=iDescsize%>" maxlength="<%=iDescMax%>" value="." <%=readonly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>

		</tr>
		<tr >
			<td colspan="3">&nbsp;</td>
		</tr>
			<tr id='trdescLocLang' name='trdescLocLang'>
				<td class="label"  nowrap><fmt:message key="ePH.DescriptioninLocalLanguage.label" bundle="${ph_labels}"/></td>
				<td colspan="2" >&nbsp;
				<input type="text" style='<%=strLocalAlign%>;' name="label_text_1_loc_lang" size="<%=iDescsize%>" maxlength="<%=iDescMax%>" onKeyPress="if(event.keyCode==38) {return false;}" onBlur="makeValidString(this);" value="<%=label_text_1_loc_lang%>"  <%=readonly%>>
				</td>
			</tr>
		<tr id='trEmtydescLocLang' name='trEmtydescLocLang'>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr style="display:none" >
			<td  class="label"  nowrap><fmt:message key="ePH.Text2InLocalLanguage.label" bundle="${ph_labels}"/></td>
			<td colspan="2">&nbsp;
			<input type="text"  name="label_text_2_loc_lang" id="label_text_2_loc_lang" size="<%=iDescsize%>" maxlength="<%=iDescMax%>" onBlur="makeValidString(this);loadEnglish();" value="." <%=readonly%> style='text-align:right' onFocus='loadArabic()'  class='OTHLANGTEXT'>
			</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td colspan="2">&nbsp;
			<input type="checkbox" name="eff_status" id="eff_status" <%=checked%> value="E"></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
		</table>
		<input type="hidden" name="param_yn" id="param_yn" value="<%=PARAM_YN%>">
		<input type="hidden" name="caution_text_max_200" id="caution_text_max_200" value="<%=caution_text_max_200%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	</form>
	<script>
		document.formLabelText.label_text_id.focus() ;
	</script>
<%
	if(mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )){
%>

		<script>
			document.formLabelText.label_text_id.focus() ;
		</script>
<%
	}

	if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ))
		if(checked.equals("checked")){
%>
		<script>
			document.formLabelText.label_text_type.focus() ;
		</script>
<%
	}
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>      

