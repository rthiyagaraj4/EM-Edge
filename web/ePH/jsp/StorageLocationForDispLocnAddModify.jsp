<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");	
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//endss
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../js/StorageLocationForDispLocn.js"></script>
	<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

     <SCRIPT>
		var function_id = "<%= request.getParameter( "function_id" ) %>"
		</SCRIPT>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String	mode			=	request.getParameter( "mode" ) ;
	String	bean_id			=	"StorageLocationForDispLocnBean" ;
	String	bean_name		=	"ePH.StorageLocationForDispLocnBean";
    String	readOnly		=	"" ;
    String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";

	//added for audit log
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_STORAGE_BIN_LOCN";
	String pkey_value="";
	

    if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;

StorageLocationForDispLocnBean bean = (StorageLocationForDispLocnBean)getBeanObject(bean_id,bean_name,request);
bean.setLanguageId(locale);
SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
bean.setMode( mode ) ;
bean.clear() ;
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
int totalRecords	= Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );



%>
<form name="formStorageLocation" id="formStorageLocation" id="Storage Location Form" >
<%
	if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
%>
<BR><BR>
	<table cellpadding="0" cellspacing="0" width="90%" align="center" border=1 id="storageLocation_insert" name="storageLocation_insert">
	<tr>
		<td class="label" colspan="" style="border:none"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td class="label" colspan="" style="border:none">&nbsp;
			<select name="disp_locn_code" id="disp_locn_code" >
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
</tr>
	<tr >
		<td colspan="8" style="border:none;" class="white">&nbsp;</td>
	</tr>
	
	<TR >
		<TH style="border-top:none"><fmt:message key="Common.code.label" bundle="${common_labels}"/></TH>
		<TH style="border-top:none"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
       	<TH style="border-top:none"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TH>
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
			<TD align="center" CLASS="<%=classValue %>" >
				<INPUT TYPE="text" CLASS='UPPER' id="dis_loc_cod" name="storage_bin_code<%=cnt %>" id="storage_bin_code<%=cnt %>" SIZE="4" MAXLENGTH="4" 
				<%= readOnly %> onKeyPress="return CheckForSpecChars(event)" onBlur="toUpper(this);DispLocnCheck(this);onBlurCheck('<%=cnt%>')">
			</TD>
			<TD align="center"  CLASS="<%=classValue %>">
				<INPUT TYPE="text" name="description<%=cnt %>" id="description<%=cnt %>"  SIZE="15" MAXLENGTH="15" 
				onBlur="resetColorCode(this);makeValidString(this);onBlurCheck('<%=cnt%>')">
			</TD>

			<TD align="center" CLASS="<%=classValue %>" >
				<INPUT TYPE="checkBox" name="eff_status<%=cnt %>" id="eff_status<%=cnt %>" VALUE="E"  >
			</TD>
			
		</TR>
<%
	}
%>
</table>  
<%
	}
else if (mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ))
    {
	String disp_locn_code = request.getParameter("disp_locn_code").trim();
	String storage_bin_code = request.getParameter("storage_bin_code").trim();
	//String disp_locn_desc = request.getParameter("disp_locn_desc");
	bean.clear();
	bean.loadData(disp_locn_code.trim(),storage_bin_code.trim());
	String effStatusCheck = bean.getEffStatus();
	String disableAll="";
	if (effStatusCheck.equals("E")){
		effStatusCheck = "checked";
		disableAll = "";
	}else{
		effStatusCheck = "";
		disableAll = "disabled";
	}
	
		//-------------------------code added for showing audit log---------------------------
		//code for adding pk_values
		ArrayList Pk_values    =new ArrayList();
		Pk_values.add(bean.getLoggedInFacility());      
		Pk_values.add(disp_locn_code.trim());      
		Pk_values.add(storage_bin_code);      
         
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
		//--------------------------------------ends here---------------------------------------
%>
<br><br><br><br><br><br><br><br>
	<table cellpadding=0 cellspacing=0 width="90%" align="center" id="storageLocationTable" border="0">
		<tr>
			<th colspan="30" align="left"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<td class="label" align="right" colspan="2" style="width:45%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td align="left" colspan="2" style="width:55%">&nbsp;
				<input type="text" name="disp_locn_code" id="disp_locn_code" size="6" maxlength="6" disabled value="<%=disp_locn_code %>">
			</td>
			<td class="label" align='right'><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE="Audit Log"   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></td>
			</tr>
		<tr>
			<td class="label" align="right" colspan="2" style="width:50%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td align="left" colspan="3" style="width:50%">&nbsp;
		
				<input type="text" name="disp_locn_desc" id="disp_locn_desc" size="15" maxlength="15" disabled value="<%=bean.getDispLocnDesc()%>">
			</td>
		</tr>
		<tr>
			<th colspan="5" align="left"><fmt:message key="ePH.DispenseLocationStorage.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<td class="label" align="right" colspan="2" style="width:50%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td align="left" colspan="3" style="width:50%">&nbsp;
	        
				<input type="text" name="storage_bin_code" id="storage_bin_code" size="6" maxlength="2" disabled value="<%=storage_bin_code%>">
			</td>
		</tr>
		<tr>
			<td class="label" align="right" colspan="2" style="width:50%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		
			<td align="left" colspan="3" style="width:50%">&nbsp;
				<input type="text" name="storage_locn_desc" id="storage_locn_desc" size="15" maxlength="15" <%=disableAll%> value="<%=bean.getStorageLocnDesc()%>">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'>
			</td>
				
		</tr>
         <tr>
			<td class="label" align="right" colspan="2" style="width:50%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td align="left" colspan="3" style="width:50%">&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E" <%=effStatusCheck%>>
			</td>
		</tr>	
	</table>

<%
	}
%>
 <input TYPE="hidden" name="mode" id="mode" value="<%= mode %>">
    <input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">


</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

