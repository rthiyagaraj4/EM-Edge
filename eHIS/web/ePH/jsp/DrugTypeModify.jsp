<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
   
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/DrugType.js"></SCRIPT>
    
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="DrugTypeModify" id="DrugTypeModify">
<%
    /* Mandatory checks start */
    String mode = request.getParameter( "mode" ) ;
	String gCode = request.getParameter( "gcode" ) ;
	String	bean_id			=	"DrugTypeBean";
	String	bean_name		=	"ePH.DrugTypeBean";
	String log_bean_id			= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	String audit_log_visible	= "visibility:hidden";
	String table_id				= "PH_DRUG_TYPE";
	String pkey_value		="";
	if ( mode == null || mode.equals("") )
        return ;
    if ( !mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
        return ;

    DrugTypeBean bean = (DrugTypeBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	HashMap TypeDetails=bean.getTypeDetails(gCode,locale);
	String gName=(String)TypeDetails.get("GNAME");
	String eff_status=(String) TypeDetails.get("EFF_STATUS");


		String disableAll = "";

		if (eff_status.equals("D"))
		{
			disableAll = "disabled";
		}

	       /*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>DRUG_TYPE
				
  
			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(gCode);      
			
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				pkey_value   ="";
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible= "visibility:visible";
					pkey_value       = (String)log_bean.getpk_value();
				}
				else{
					audit_log_visible= "visibility:hidden";
					log_bean.clear();
				}
	      /*--------------------------------------ends here---------------------------------------*/
%>
<span style="position:absolute;top:130;left:100">
<TABLE align="center" cellspacing="0" cellpadding="0" width="100%" border=0>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr> <td colspan="3">&nbsp;</td></tr>
<tr>
	<td  class="label"><fmt:message key="ePH.DrugType.label" bundle="${ph_labels}"/> &nbsp;&nbsp;</td>
	<td  ><input type ="text" name ="drug_type" value = "<%=gCode%>" size ="4" maxlength ="4"
	onBlur = "toUpper(this)" onKeyPress = "return CheckForSpecChars(event);" disabled>
	<img src="../../eCommon/images/mandatory.gif" align="center"></img> </td>
   <td ><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></td>
	</tr>
<tr> <td colspan="3">&nbsp;</td></tr>
<tr>
	<td   class="label"><fmt:message key="ePH.DrugTypeDescription.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
	<td  colspan="2"><input type ="text" name ="drug_desc" value = "<%=gName%>" size ="80" maxlength ="100"
	onBlur="makeValidString(this);"  <%=disableAll%> >	
	<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>
</tr>
<tr> <td colspan="3">&nbsp;</td></tr>
<tr>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td colspan="2"><%
						if (eff_status.equals("E"))
						{
							%>
							<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>
							<%
						}
						else
						{
							%>
							<input type="checkbox" name="eff_status" id="eff_status" value="E" >
							<%
						}
					%>
	</td>
</tr>
<tr> <td colspan="3">&nbsp;</td></tr>


</TABLE>
</span>
<%
putObjectInBean(bean_id,bean,request);
%>
	<input type="hidden" name="mode" id="mode"		value="<%= mode %>">	
	<input type="hidden" name="bean_id" id="bean_id"		value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
</form>
</body>
</html>

