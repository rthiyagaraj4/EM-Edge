<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import=" java.io.*, java.sql.*, java.util.*, java.text.*, webbeans.eCommon.* " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<SCRIPT>
	function run()
	{
		frames[1].run();
	}

	

	function reset()
	{
		frames[1].document.location.reload();
		messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
</SCRIPT>
<%
	String url    = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
	
	String callFrom = request.getParameter("callFrom");
	if(callFrom == null || callFrom.equals("null"))
		callFrom = "";
	if(callFrom.equals("mainFrame"))
	{
		String p_module_id		= "FM" ;
		//String p_report_id		= "FMBDCTLB" ;
		String p_facility_id	= (String) session.getValue( "facility_id" ) ;
		String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
	<HEAD>
		<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/DTDocumentNumberLookup.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<SCRIPT>
		async function docTypeLookup(document_type,Obj)
		{	
			//changed from CommonDocumentLookup to general search.
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
		
		tit=getLabel('Common.documenttype.label','common');
		sql="SELECT doc_type_code,doc_type_name FROM fm_doc_type_lang_vw where language_id=`"+localeName+"` ";
		search_code="doc_type_code";
		search_desc= "doc_type_name";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

		var arr=new Array();

		if(retVal != null && retVal != "" )
			{
				var ret1	=	unescape(retVal);
				arr=retVal.split("::");
				if(Obj == 'doc_type_from')
				{
					document.forms[0].doc_type_from.value		= arr[0];
					document.forms[0].doc_type_from_code.value	= arr[1];
				}
				if(Obj == 'doc_type_to')
				{
					document.forms[0].doc_type_to.value		 = arr[0];
					document.forms[0].doc_type_to_code.value = arr[1];
				}
			}
			else
			{
				if(Obj == 'doc_type_from')
				{
					document.forms[0].doc_type_from.value		= "";
					document.forms[0].doc_type_from_code.value	= "";
				}
				if(Obj == 'doc_type_to')
				{
					document.forms[0].doc_type_to.value		 = "";
					document.forms[0].doc_type_to_code.value = "";
				}
			} 


		}
		function run()
		{
			/*if(document.forms[0].bar_code.checked == true)
			{
				document.forms[0].bar_code.value = 'Y';
				document.forms[0].p_report_id.value = 'FMBDCTLB';
			}
			else if(document.forms[0].bar_code.checked == false)
			{
				document.forms[0].bar_code.value = 'N';
				document.forms[0].p_report_id.value = 'FMBDTLST';
			}*/
			
			var fields = new Array  (document.forms[0].doc_type_from,document.forms[0].doc_type_to,document.forms[0].p_report_id)
			var names  = new Array (getLabel('Common.documenttype.label','common')+" "+getLabel('Common.from.label','common'),getLabel('Common.documenttype.label','common')+" "+getLabel('Common.to.label','common'),getLabel('Common.reporttype.label','common'))
			if(checkFields(fields,names,parent.messageFrame))
			{
				if(CheckString(getLabel('Common.documenttype.label','common'),
				document.forms[0].doc_type_from,document.forms[0].doc_type_to,parent.messageFrame))
				{
					document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					document.forms[0].target="messageFrame";
					document.forms[0].submit();
				}
			}
		}

		
	</SCRIPT>
		<BODY onMouseDown="CodeArrest();"  onload='document.forms[0].doc_type_from.focus();' onKeyDown = 'lockKey();'> 
			<FORM name='DocTypeRepForm' id='DocTypeRepForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
				<TABLE cellpadding='5' cellspacing='0' border='0' width='80%' align='center'>
				<BR><BR><BR>
				<TR><TD colspan='4'>&nbsp;</TD></TR>
				<TR>
					<TD class='label' width='30%'>&nbsp;</TD>
					<TD class='querydata' width='30%' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
					<TD class='label' width='10%'>&nbsp;</TD>
					<TD class='querydata' width='30%' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
				</TR>
				
				<TR>
					<TD class='label' ><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></TD>
					<TD class='fields'><INPUT type="text" maxlength="15" size="18" name="doc_type_from" id="doc_type_from" ><INPUT type='button' class='button' name='doc_fold_search' id='doc_fold_search' value='?' align=center onClick='docTypeLookup(doc_type_from.value,"doc_type_from");'><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG>
					<!-- <INPUT type="text" maxlength="15" size="18" name="doc_type_from" id="doc_type_from"  onChange='docTypeLookup(this.value,"doc_type_from");'> --></TD>
					<TD class='label' ></TD>
					<TD class='fields' ><INPUT type="text" maxlength="15" size="18" name="doc_type_to" id="doc_type_to" ><INPUT type='button' class='button' name='doc_fold_search' id='doc_fold_search' value='?' align=center onClick='docTypeLookup(doc_type_to.value,"doc_type_to");'><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG>
					<!-- <INPUT type="text" maxlength="15" size="18" name="doc_type_to" id="doc_type_to"  onChange='docTypeLookup(this.value,"doc_type_to");'> --></TD>
				</TR>
				<TR>
					<TD class='label' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></TD>
					<TD class='fields' ><SELECT name='p_eff_status' id='p_eff_status'>
							<OPTION value='B' selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></OPTION>
							<OPTION value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></OPTION>
							<OPTION value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></OPTION>
						</SELECT></TD>
					<TD colspan='2'>&nbsp;</TD>
				</TR>
				<TR>
					<TD class='label' ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </TD>
					<TD class='fields' ><SELECT name='p_report_id' id='p_report_id'>
							<OPTION value='' >----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</OPTION>
							<OPTION value='FMBDCTLB' ><fmt:message key="Common.Label.label" bundle="${common_labels}"/></OPTION>
							<OPTION value='FMBDTLST'><fmt:message key="Common.List.label" bundle="${common_labels}"/></OPTION>
						</SELECT><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG></TD>
					<TD colspan='2'>&nbsp;</TD>
				</TR>
				<TR><TD colspan='4'>&nbsp;</TD></TR>
			</TABLE>
			<INPUT type='hidden' name='p_module_id' id='p_module_id' value='<%=p_module_id%>'>
			<INPUT type='hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'>
			<INPUT type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'>
			<INPUT type='hidden' name='doc_type_from_code' id='doc_type_from_code' value=''>
			<INPUT type='hidden' name='doc_type_to_code' id='doc_type_to_code' value=''>
			<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
		</FORM>
	</BODY>
</HTML>
<%
	}
	else
	{
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='docTypeRepFrame' id='docTypeRepFrame' src='../../eFM/jsp/DTRepGenDocType.jsp?callFrom=mainFrame' frameborder='0' scrolling='no' noresize style='height:83vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
		
<%
	}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

