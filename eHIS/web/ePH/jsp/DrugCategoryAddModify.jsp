
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
     
		request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	   
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugCategory.js"></SCRIPT>
	<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	/* Mandatory checks start onKeyDown="lockKey()" */
	String	mode			=	request.getParameter( "mode" ) ;
	String	bean_id			=	"DrugCategory" ;
	String	bean_name		=	"ePH.DrugCategoryBean";
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";

//added for audit log
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_DRUG_CATG";
	String pkey_value			="";
	String	readOnly		=	"" ;
	int	    totalRecords	=	0;
	String pinauthreqdYN		    ="N";
	String MARAuthChk		= "";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	DrugCategoryBean bean      = (DrugCategoryBean)getBeanObject( bean_id, bean_name, request ) ;
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	bean.clear() ;
	log_bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	 bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );
	pinauthreqdYN	=   CommonBean.checkForNull(bean.PinAuthReqdYN());
	/* Initialize Function specific end */
if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
		if((pinauthreqdYN).equals("Y"))
		{
			//out.println("if");
			MARAuthChk = "CHECKED";
		}
		else if((pinauthreqdYN).equals("N"))
		{
			//out.println("else");
			MARAuthChk = " ";
		}
}



%>
<form name="formDrugCategory" id="formDrugCategory" id="Drug Category Form" >

<%
		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
%>

	<BR><BR><BR><BR><BR>
	<table cellpadding="0" cellspacing="0" width="90%" align="center" border=1>
	<TR >
		<TH ><fmt:message key="Common.code.label" bundle="${common_labels}"/></TH>
		<TH ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></TH>
		<TH ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></TH>
		<TH ><fmt:message key="ePH.AuthenticationforMARRequired?.label" bundle="${ph_labels}"/></TH>
		<TH ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TH>
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
			<TD  CLASS="<%=classValue %>" >
				<INPUT TYPE="text" CLASS='UPPER' name="drug_catg_code<%=cnt %>" id="drug_catg_code<%=cnt %>"  SIZE="4" MAXLENGTH="4" <%= readOnly %> onKeyPress="return CheckForSpecChars(event)" onBlur="toUpper(this);DrugCatgCheck(this);">
			</TD>
			<TD  CLASS="<%=classValue %>" >
				<INPUT TYPE="text" name="long_desc<%=cnt %>" id="long_desc<%=cnt %>"  SIZE="42" MAXLENGTH="40" onBlur="resetColorCode(this);makeValidString(this)">
			</TD>
			<TD  CLASS="<%=classValue %>" >
				<INPUT TYPE="text" name="short_desc<%=cnt %>" id="short_desc<%=cnt %>" SIZE="20" MAXLENGTH="20" onBlur="resetColorCode(this);makeValidString(this)">
			</TD>
		
			<TD  CLASS="<%=classValue %>">
				<INPUT TYPE="checkBox" name="pin_auth_reqd_yn<%=cnt %>" id="pin_auth_reqd_yn<%=cnt %>"  onClick="setValue(this)" VALUE="<%=pinauthreqdYN%>" <%= MARAuthChk%>>
			</TD>

			<TD  CLASS="<%=classValue %>">
				<INPUT TYPE="checkBox" name="eff_status<%=cnt %>" id="eff_status<%=cnt %>" VALUE="E" CHECKED >
			</TD>
		</TR>
<%
	}
%>
	</table>
<script>
	document.formDrugCategory.drug_catg_code0.focus() ;
</script>
<%
	}

	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		//out.println("modify");
		bean.setDrugCatgCode( request.getParameter( "drug_catg_code" ).trim() ) ;
		bean.loadData();
//out.println("==bean.getauthreqdYN()====="+bean.getauthreqdYN());
		if((bean.getauthreqdYN()).equals("Y"))
		{
			//out.println("if");
			MARAuthChk = "CHECKED";
		}
		else if((pinauthreqdYN).equals("N"))
		{
			//out.println("else");
			MARAuthChk = " ";
		}	



		if((bean.getEffStatus()).equals("D"))
		{

			readOnly = "readonly" ;
		}
		
		/*if((PinauthreqdYN()).equals("N"))
			checked = "checked" ;

		/*-------------------------code added for showing audit log---------------------------*/
		//code for adding pk_values
		ArrayList Pk_values    =new ArrayList();
		Pk_values.add( bean.getDrugCatgCode());      

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
		/*--------------------------------------ends here---------------------------------------*/

%>

	<BR><BR><BR><BR><BR><BR><BR><BR>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="70%" ALIGN="center" BORDER="0">
	<TR>
		<TD >&nbsp;</TD>
		<td align="right"><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></td>
	</TR>
	<TR>
		<TD  CLASS="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></TD>
		<TD >&nbsp;&nbsp;<INPUT TYPE="text" name="drug_catg_code" id="drug_catg_code" VALUE="<%= bean.getDrugCatgCode() %>" SIZE="4" MAXLENGTH="4" readOnly>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
	</TR>
	<TR>
		<TD COLSPAN="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD CLASS="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></TD>
		<TD>&nbsp;&nbsp;<INPUT TYPE="text" name="long_desc" id="long_desc" VALUE="<%=bean.getLongDesc() %>" SIZE="42" MAXLENGTH="40" <%= readOnly %> onBlur="makeValidString(this)">
		<img src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
	</TR>
	<TR>
		<TD COLSPAN="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD  CLASS="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></TD>
		<TD >&nbsp;&nbsp;<INPUT TYPE="text" name="short_desc" id="short_desc" VALUE="<%= bean.getShortDesc() %>" SIZE="20" MAXLENGTH="20" <%= readOnly %> onBlur="makeValidString(this)">
		<img src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
	</TR>
		<!-- ENHANCEMENT MADE BY SANDHYA on DT:14/10/08 -->
	<TR>
		<TD COLSPAN="2">&nbsp;</TD>
		<TR>
		<TD class="label"><fmt:message key="ePH.AuthenticationforMARRequired?.label" bundle="${ph_labels}"/></TD>
		<TD>&nbsp;&nbsp;<input type="checkBox" name="pin_auth_reqd_yn" id="pin_auth_reqd_yn" onClick="setValue(pin_auth_reqd_yn)" VALUE="<%=pinauthreqdYN%>" <%= MARAuthChk%>>
		</TD>
	</TR>
	</TR>
	<TR>
		<TD class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TD>
			<% if((bean.getEffStatus()).equals("E")) {%>
		<TD>&nbsp;&nbsp;<input type="checkBox" name="eff_status" id="eff_status" value="E" checked>
			<% } else { %>
		<TD ALIGN="left">&nbsp;&nbsp;<input type="checkBox" name="eff_status" id="eff_status" value="E">
			<%	}	%>
		</TD>
	</TR>
	<TR>
		<TD COLSPAN="2">&nbsp;</TD>
	</TR>
<%
	if((bean.getEffStatus()).equals("E")) {
%>
	<script language="javascript">
			document.formDrugCategory.long_desc.focus() ;
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
		}
	}//modify end
%>
	</TABLE>

	<input TYPE="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
</FORM>
</BODY>
</HTML>


<%
putObjectInBean(bean_id,bean,request);
%>

