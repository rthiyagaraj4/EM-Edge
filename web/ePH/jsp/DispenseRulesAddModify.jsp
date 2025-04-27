<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
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

	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>

    <script language="JavaScript" src="../js/DispenseRules.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
     /* Mandatory checks start */
    String mode			= request.getParameter("mode");
	String bean_id		= "DispenseRulesBean" ;
    String bean_name	= "ePH.DispenseRulesBean";
    String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_DISP_DURATION_RULE";
	String pkey_value		="";
	String drugCatgCode	= "";
	String patientClass	= "";
	String dispGroupCode= "";
	String Action		= "";
	HashMap getValues	= new HashMap();

	if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
    DispenseRulesBean bean = (DispenseRulesBean)getBeanObject(bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
    bean.clear() ;
    bean.setMode( mode ) ;
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	String max_durn_for_op_pres	=	"";
	String max_durn_for_ip_pres	=	"";

	ArrayList disp_duration		= bean.validateDispenseDuration();

	if(disp_duration.size() ==2) {
		max_durn_for_op_pres	=	(String) disp_duration.get(0);
		max_durn_for_ip_pres	=	(String) disp_duration.get(1);
	}

	HashMap intialValues = new HashMap();

	if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
		intialValues = (HashMap) bean.loadIntialValues();
	}
	else{
		
		intialValues = (HashMap) bean.loadIntialValues();
		drugCatgCode	= request.getParameter( "drug_catg_code" ) ;
		patientClass	= request.getParameter( "patient_class" ) ;
		dispGroupCode  = request.getParameter( "stat_group_id" ) ;
		Action			= request.getParameter( "action" ) ;

String error =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Error.label","ph_labels");
String Warning =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels");



		if(Action!=null && Action.equals(error)) Action="E";
		else if(Action!=null && Action.equals(Warning)) Action="W";
		 if(patientClass.equals("*All")){patientClass="*A";}
		getValues = (HashMap) bean.loadIntialValues(drugCatgCode.trim(),patientClass.trim(),dispGroupCode.trim(),Action.trim());
	 }
	boolean fineAll				= false;
	ArrayList drug_catg_code		= (ArrayList) intialValues.get("drug_catg_code");
	ArrayList catg_desc			= (ArrayList) intialValues.get("catg_desc");
		  for(int i=0;drug_catg_code.size()>i;i++){
			 if(catg_desc.get(i).equals("*All")){
						fineAll=true;
						break;
			}else{
					fineAll=false;
				}
		  }
  /*-------------------------code added for showing audit log---------------------------*/
	//primary_key_1  ------>DRUG_CATG_CODE
	//primary_key_2  ------>PATIENT_CLASS
	//primary_key_3  ------>STAT_GROUP_ID
	//code for adding pk_values
	ArrayList Pk_values    =new ArrayList();
	Pk_values.add(drugCatgCode.trim());      
	Pk_values.add(patientClass);      
	Pk_values.add(dispGroupCode.trim());      
	String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
	pkey_value   ="";
	if(display_audit_log_button_yn.equals("Y")){
		audit_log_visible= "visibility:visible";
		pkey_value       = (String)log_bean.getpk_value();
	}else{
		audit_log_visible= "visibility:hidden";
		log_bean.clear();
	}

  /*--------------------------------------ends here---------------------------------------*/
	%>
<form name="dispense_rules" id="dispense_rules" >
<br><br><br><br><br><br><br>
   <table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" id="patient_table">
        <tr><td class="label" colspan="3">&nbsp;</td></tr>
		<tr>
           <td class="label" width="35%" ><fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></td>
           <td >&nbsp;
		   <%
			   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
				String desc=(String)getValues.get("DRUG_CATG_DESC");
				if(desc == null){desc="*ALL";}

				%><input type="text" value="<%=desc%>" name="drug_category_desc" disabled size="30">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img></input>
				<input type="hidden" value="<%=drugCatgCode.trim()%>" name="drug_category"></input>
				<%
			   }else{
			   %>
			   <select name="drug_category" id="drug_category">
                   <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<%
				 if(!fineAll){
				%>
				<option value="*ALL">*<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<%
				}
				for(int i=0;drug_catg_code.size()>i;i++){

				  %>
					<option value="<%=drug_catg_code.get(i)%>"><%=catg_desc.get(i)%></option>
				  <%
				  }
				  %>
                </select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
				<%
			     }
				%>
				</td>
				<td> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
         </tr>
		 <tr>
           <td class="label" ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
           <td colspan="2">&nbsp;
               <%
			   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
				    if(patientClass.equals("*A")){
				%>
					<input type="text" value="*ALL" name="patient_class_desc" id="patient_class_desc" disabled size="30"></input>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
				<input type="hidden" value="*A" name="patient_class" id="patient_class" ></input>
				<%
			   }else{ %>
				<input type="text" value="<%=getValues.get("SHORT_DESC")%>" name="patient_class_desc" disabled size="30"></input>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
				<input type="hidden" value="<%=patientClass%>" name="patient_class" ></input>
				<%
			   }}else{
			   %>
			    <select name="patient_class" id="patient_class">
                   <option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				  <%
				  ArrayList patient_class		= (ArrayList) intialValues.get("patient_class");
				  ArrayList short_desc			= (ArrayList) intialValues.get("short_desc");
				  for(int i=0;patient_class.size()>i;i++){

				  %>
					<option value="<%=patient_class.get(i)%>"><%=short_desc.get(i)%></option>
				  <%
				  }
				  %>
               </select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img><%
			   }
			   %>
            </td>
         </tr>
		 <tr>
           <td class="label" ><fmt:message key="ePH.DispensingGroup.label" bundle="${ph_labels}"/></td>
           <td colspan="2">&nbsp;<%
			   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
				%>
				<input type="text" value="<%=getValues.get("STAT_GRP_DESC")%>" name="dispensing_group_desc" disabled size="30"></input>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img><input type="hidden" value="<%=dispGroupCode.trim()%>" name="dispensing_group"></input>
				<%
			   }else{
			   %>
				   <select name="dispensing_group" id="dispensing_group">
                   <option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;</option>
				   <%
				  ArrayList stat_grp_id		= (ArrayList) intialValues.get("stat_grp_id");
				  ArrayList stat_grp_desc			= (ArrayList) intialValues.get("stat_grp_desc");
				  for(int i=0;stat_grp_id.size()>i;i++){

				  %>
					<option value="<%=stat_grp_id.get(i)%>"><%=stat_grp_desc.get(i)%></option>
				  <%
				  }
				  %>
               </select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img><%
			   }
			   %></td>
         </tr>
		 <tr>
           <td class="label" ><fmt:message key="ePH.MaxDispenseDuration.label" bundle="${ph_labels}"/></td>
           <td class="fields" colspan="2" >&nbsp;&nbsp;
		   <input type="text" name="dispense_duration" id="dispense_duration" value="<%=getValues.get("MAX_DISP_DURATION")== null ? "" : getValues.get("MAX_DISP_DURATION") %>" size="3" maxlength="3" onKeyPress="return(ChkNumberInput(this,event,0));" class="NUMBER"  onblur="DurationValidate(this)">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
         </tr>
		 <tr>
           <td class="label" ><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
           <td colspan="2">&nbsp;
               <select name="action" id="action">
                   <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				   <option value="E"><fmt:message key="Common.Error.label" bundle="${common_labels}"/></option>
				   <option value="W"><fmt:message key="Common.Warning.label" bundle="${common_labels}"/></option>
               </select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
            </td>
			<%
			   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
				%>
				<script>document.dispense_rules.action.value="<%=Action%>"</script>
			<%
			   }
			%>
         </tr>
		 <tr>
           <td class="label" ><fmt:message key="Common.MessageText.label" bundle="${common_labels}"/></td>
		   <td colspan="2">&nbsp;&nbsp;<textarea cols="50" rows="4" name="msg_text" onblur="ChkMaxLen(this,255,'mode');" ><%=getValues.get("MESSAGE")== null ? "" : getValues.get("MESSAGE") %></textarea></td>
		  </tr>
		  <tr><td class="label" colspan="3">&nbsp;</td></tr>
   </table>
   <%
    if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
	%>
   <script>document.dispense_rules.drug_category.focus();</script>
   <%}
	%>



<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="max_durn_for_op_pres" id="max_durn_for_op_pres" VALUE="<%=max_durn_for_op_pres%>">
<INPUT TYPE="hidden" name="max_durn_for_ip_pres" id="max_durn_for_ip_pres" VALUE="<%=max_durn_for_ip_pres%>">
 </form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

