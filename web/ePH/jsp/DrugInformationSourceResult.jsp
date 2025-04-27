<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>


	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DrugInformationSource.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
</SCRIPT>


</head>
<body  onMouseDown="" onKeyDown="lockKey()">
 <form name="frmdrugsourceresult" id="frmdrugsourceresult">
<%
	String hdrcode ="";
	String hdrdescription ="";
	String hdrsequenceno ="";
	String hdreffstatus = "";
	String mode	 ="" ;

	String bean_id		= "DrugInformationSourceBean" ;
    String bean_name	= "ePH.DrugInformationSourceBean";

	mode				    = request.getParameter("mode") ;
	hdrcode					= request.getParameter("code") ;
	hdrdescription			= request.getParameter("description") ;
	hdrsequenceno			= request.getParameter("display_sequence_no") ;
	hdreffstatus			= request.getParameter("eff_status") ;	

	String  classValue = "";
	String readOnly = "" ;

	if ( mode == null || mode.equals("") )
        return ;


	//added for audit log
	String log_bean_id			= "SetupAuditLogBean" ;
	String log_bean_name		= "ePH.SetupAuditLogBean";
	SetupAuditLogBean log_bean	= (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);

	String audit_log_visible	="visibility:hidden";
	String table_id				="PH_DRUG_INFO_ENQ_DTL";
    String pkey_value           ="";


    if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
        return ;

	 DrugInformationSourceBean bean = (DrugInformationSourceBean)getBeanObject( bean_id, bean_name , request ) ;
	 bean.setLanguageId(locale);
%>

	   <%
		   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
 		%>

<table border="1" width="60%" cellspacing="0" cellpadding="0"  align ="center">
 <tr>
		<td class='COLUMNHEADER' width='20' nowrap>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='40' nowrap>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='20' nowrap>&nbsp;<fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='20' nowrap>&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
</tr>
<%
	int count=0;
while(count < 10)
	 {
       if ( count % 2 == 0 )
           classValue = "QRYEVEN" ;
       else
           classValue = "QRYODD" ;
	 %>
<tr >
		<td class='<%=classValue%>' >&nbsp;<input type=text name='info_code<%=count%>' id='info_code<%=count%>' onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this);resetColorCode(this)" size=4 maxlength=4 value='' <%=readOnly%>>
		</td>
		<td class='<%=classValue%>'>&nbsp;<input type=text name='info_short_desc<%=count%>' id='info_short_desc<%=count%>' onBlur="check(this.value, '<%=count%>'); makeValidString(this)" size="40" maxlength="20" value=""  <%=readOnly%>  >
		</td>
		<td class='<%=classValue%>'>&nbsp;<input type="text" name='seq_no<%=count%>' id='seq_no<%=count%>' value="" onBlur="chkzero(this,'<%=count%>');resetColorCode(this)" onKeyPress="return allowValidNumber(this,event,2,0);" size="5" maxlength="2" <%=readOnly%> >
		</td>
		<td class='<%=classValue%>'>&nbsp;<input type="checkbox" name='info_eff_status<%=count%>' id='info_eff_status<%=count%>' value="E"   <%=readOnly%> onclick="checkText(this,'<%=count%>')" ></td>
</tr>

<% count++;} 
%>

<input type="hidden" name="totalRecords" id="totalRecords" value="10">
</table> 
	<%
	  } if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals("2")){ 
				
		String disable="";String readonly="";
		if(hdreffstatus.equals("D"))
			disable ="disabled";
		%>
<table border="1" width="70%" cellspacing="0" cellpadding="0"  align ="center">
<tr>
		<td class='COLUMNHEADER' width='10' nowrap>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='30' nowrap>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='20' nowrap>&nbsp;<fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
 		<td class='COLUMNHEADER' width='20' nowrap>&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
        <td class='COLUMNHEADER' width='20' nowrap>&nbsp;</td >
        
</tr> 
	<%
		ArrayList DrugInfo = bean.getDrugInformationSource(hdrcode) ;
			for( int count=0 ; count< DrugInfo.size() ; count++ ) {

				String[] record = (String[])DrugInfo.get(count);
		
				if(count % 2 == 0){
					classValue = "QRYEVEN";
				}else{
					classValue = "QRYODD";
				}
				if(record[3].equals("null") || record[3]==null)
					record[3]="";
				if(record[3].equals("D"))
					readonly ="disabled";
				else
					readonly = "";
			/*-------------------------code added for showing audit log---------------------------*/						
  
			//code for adding pk_values
				ArrayList Pk_values    = new ArrayList();
				Pk_values.add(hdrcode.trim());
				Pk_values.add(record[0]);  
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				pkey_value       ="";
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible = "visibility:visible";
					pkey_value        = (String)log_bean.getpk_value();
				}else{
					audit_log_visible= "visibility:hidden";
					log_bean.clear();
				}

	      /*--------------------------------------ends here---------------------------------------*/
	
	 %>
<tr >
		<td class='<%=classValue%>' >&nbsp;<input type=text disabled name='info_code<%=count%>' id='info_code<%=count%>' onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this);resetColorCode(this)" size=4 maxlength=4 value='<%=record[0]%>' <%=readOnly%> <%=readonly%>>
		</td>
		<td class='<%=classValue%>'>&nbsp;<input type=text name='info_short_desc<%=count%>' id='info_short_desc<%=count%>' onBlur="check(this.value, '<%=count%>');makeValidString(this);resetColorCode(this);checkText(this,'<%=count%>')" size="40" maxlength="20" value="<%=record[1]%>"  <%=readOnly%> <%=readonly%> <%=disable%>>
		</td>
		<td class='<%=classValue%>'>&nbsp;<input type="text" name='seq_no<%=count%>' id='seq_no<%=count%>' value="<%=record[2]%>" onBlur="chkzero(this,'<%=count%>');resetColorCode(this)" onKeyPress="return allowValidNumber(this,event,2,0);" size="5" maxlength="2" <%=readOnly%> <%=readonly%> <%=disable%>>
		</td>		
		<td class='<%=classValue%>'>&nbsp;<input type="checkbox" name='info_eff_status<%=count%>' id='info_eff_status<%=count%>' value="<%=record[3]%>"
		<%=(record[3].equals("E")?"checked":"")%>  <%=readOnly%> <%=disable%> >
		</td>

      <TD> <INPUT TYPE="button" CLASS="button" name="audit_log<%=count%>" id="audit_log<%=count%>" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>

</tr>
<%
	} // for lup ends here
	

%>
		</table> 
		<input type="hidden" name="totalRecords" id="totalRecords" value="<%=DrugInfo.size()%>">
<%
} 
%>	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"> 
	<input type="hidden" name="code" id="code" value="<%=hdrcode%>">
	<input type="hidden" name="description" id="description" value="<%=hdrdescription%>">
	<input type="hidden" name="display_sequence_no" id="display_sequence_no" value="<%=hdrsequenceno%>">
	<input type="hidden" name="eff_status" id="eff_status" value="<%=hdreffstatus%>">
	<input type="hidden" name="info_dup_chk" id="info_dup_chk" value="N"> 
	<input type="hidden" name="dup_chk" id="dup_chk" value="N">

<% 

putObjectInBean(bean_id,bean,request);
putObjectInBean(log_bean_id,log_bean,request);
%>


</form>
</body>
</html>

