<!DOCTYPE html>
<%@ page import ="eOR.*,java.sql.*,webbeans.eCommon.*,java.util.*, eOR.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="chiefcomplnt" class="eCA.ChiefComplaintSplty" scope='session'/>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");	
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/ChiefComplaintSplty.js'></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<STYLE TYPE="text/css">
	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 

	</STYLE>

</head>
<%
	String mode = "1";
	chiefcomplnt.clearList();
	chiefcomplnt.clearLoadList();
	chiefcomplnt.clearAssociateddata();
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	try{

%>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<form name="ChiefComplaintSpltyCriteriafrm" id="ChiefComplaintSpltyCriteriafrm">
<table border='0' cellspacing='0' cellpadding='0' width='100%' height='100%' align='center'>
<tr>
<td class='label'><fmt:message key="Common.ChiefComplaint.label" bundle="${common_labels}"/></td>
<td class="fields">
<input type='hidden' name='complnt_code' id='complnt_code' value="">
<input type='text' name='complnt_desc' id='complnt_desc' value="" onBlur="if(this.value!='')show_complnt_lookup_blur(this,complnt_code);">
<input type="button" class="button" name="complnt_button" id="complnt_button" value="?" onclick="show_complnt_lookup(complnt_desc,complnt_code)"><img src="../../eCommon/images/mandatory.gif" >
<input type="hidden" name="temp_complnt_desc" id="temp_complnt_desc" value="">
</td>
</tr>
<tr><td class="label" colspan="2"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td></tr>
<tr><td colspan="2" align="left">
	<table align="left" cellspacing="0" cellpadding="0" width="30%" border="1">
	<tr>
	<td id="SelectTab" class="clicked" width="15%" height="20"><a href='javascript:displayLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
	<td id="AssociateTab" class="normal" width="15%" height="20"><a href='javascript:displayLink("A")'><fmt:message key="eOR.Associate.label" bundle="${or_labels}"/></a></td>
	</tr>
	</table>
	</td>
</tr>
	<td colspan='2' id='linkId' >
	<jsp:include page="../../eOR/jsp/OrCommonAlphaLink.jsp" flush="true"/>
	</td>

<% }catch(Exception e){
	//out.println("Error in Chief Complaint splty CA :"+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}finally{
}
%>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="sel_mode" id="sel_mode" value="S">
</form>
</body>
</html>

