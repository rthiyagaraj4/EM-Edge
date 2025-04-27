<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        			Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 			10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ReasonCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
textarea {
  resize: none;
}
</style>
</head>
<body onload='FocusFirstElement()' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"   >
<form name='reason_code' id='reason_code' target='messageFrame' >
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String readOnly = "" ;
	String checked = "checked" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_reason_code" ;
	String bean_name = "eOR.ReasonCode";
	//String disabled = "" ;

	String action_type			=	"";
	String action_reason_code	=	"";
	String action_reason_desc	=	"";
	String action_description	=	"";
	String eff_status			=	"";
	String qry_string			=	"";

	//if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
	//	return ;

/* Mandatory checks end */

	/* Initialize Function specific start */
	ReasonCode bean = (ReasonCode)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;


/* Initialize Function specific end */

	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		qry_string = request.getQueryString();
		out.println("<input type=hidden name=qry_string value='"+qry_string+"'>");
		try{
			action_type			=	request.getParameter( "action_type" ) ;
			action_reason_code	=	request.getParameter( "action_reason_code" ) ;

			action_type = action_type.trim();
			action_reason_code = action_reason_code.trim();
			bean.setReasonType(action_type);
			bean.setReasonCode( action_reason_code);

			String[] recValues = new String[5];
			recValues = (String[])bean.loadDataForUpdate () ;

			action_description	=	recValues[2];
			action_reason_desc	=	recValues[3];
			eff_status			=	recValues[4];
			recValues=null;
	/*out.println("in display : "+action_type);
	out.println(action_reason_code);
	out.println(action_reason_desc);
	out.println(eff_status);*/

			if(eff_status == null){
				eff_status = "D";
			}
		}catch(Exception e){
			System.out.println(e);
		}
		if(action_type.equals("CN") ){
			bean.setReasonTypeDesc("CANCEL");
		} else if (action_type.equals("O")) {
            bean.setReasonTypeDesc("ORDER");
		} else if (action_type.equals("AM")) {
            bean.setReasonTypeDesc("AMEND");			        
		} else if("ND".equals(action_type)){ //IN061903 starts
			bean.setReasonTypeDesc("NOT DONE"); //IN061903 starts
		} else{
			bean.setReasonTypeDesc("HOLD / DISCONTINUE");
		}
		bean.setReasonDesc(action_reason_desc);
		bean.setReasonShortDesc(action_description);
		bean.setEffectiveStatus(eff_status);

		if(eff_status.equals("D")){
			checked = "";
			readOnly = "readonly" ;
		}else{
			checked = "checked";
		}
//		readOnly = "readonly" ;
//		disabled = "disabled" ;
	}
%>

<table cellpadding=3 cellspacing=0 border=0 width='100%' height='100%' align='center'>
<tr style="line-height:1">
	<td colspan="3"></td>
</tr>
<tr>
	<td class="label" width="40%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<!-- IN049419 / Changes start -- commented and added AmendOrder label for IN049419
	<td class='fields'><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
	{out.println("<input type=text name='reason_type1' id='reason_type1' value='"+bean.getReasonCodeTypeDesc()+"' readonly><input type=hidden name='reason_type' id='reason_type' value='"+bean.getReasonCodeType()+"'>");}else{%><select name="reason_type" id="reason_type" onChange='chkType(this);'><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><option value='O'><fmt:message key="Common.Order.label" bundle="${common_labels}"/></option><option value='CN'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option><option value='HD'><fmt:message key="eOR.HoldDiscontinue.label" bundle="${or_labels}"/></select><%}%><img src="../../eCommon/images/mandatory.gif" align=center></img></td>	
	-->
	<!--IN061903 start-->
	<!--<td class='fields'><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
	{out.println("<input type=text name='reason_type1' id='reason_type1' value='"+bean.getReasonCodeTypeDesc()+"' readonly><input type=hidden name='reason_type' id='reason_type' value='"+bean.getReasonCodeType()+"'>");}else{%><select name="reason_type" id="reason_type" onChange='chkType(this);'><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><option value='O'><fmt:message key="Common.Order.label" bundle="${common_labels}"/></option><option value='CN'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option><option value='HD'><fmt:message key="eOR.HoldDiscontinue.label" bundle="${or_labels}"/></option><option value='AM'><fmt:message key="eOR.AmendOrder.label" bundle="${common_labels}"/></select><%}%><img src="../../eCommon/images/mandatory.gif" align=center></img></td>-->
	<td class='fields'><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
	{out.println("<input type=text name='reason_type1' id='reason_type1' value='"+bean.getReasonCodeTypeDesc()+"' readonly><input type=hidden name='reason_type' id='reason_type' value='"+bean.getReasonCodeType()+"'>");}else{%><select name="reason_type" id="reason_type" onChange='chkType(this);'><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><option value='O'><fmt:message key="Common.Order.label" bundle="${common_labels}"/></option><option value='CN'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option><option value='HD'><fmt:message key="eOR.HoldDiscontinue.label" bundle="${or_labels}"/></option><option value='AM'><fmt:message key="eOR.AmendOrder.label" bundle="${or_labels}"/></option><option value='ND'><fmt:message key="eOR.NOTDONE.label" bundle="${or_labels}"/></select><%}%><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
	<!--IN061903 ends-->
</tr>
<tr>
	<td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='fields'><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
	{out.println("<input type=text name='reason_code1' id='reason_code1' value='"+bean.getReasonCode()+"' readonly><input type=hidden name='reason_code' id='reason_code' value='"+bean.getReasonCode()+"' onkeypress=return CheckForSpecChars(event) >");}else{%><input type='text' name='reason_code' id='reason_code' size='4' maxLength='4' value='<%=bean.getReasonCode()%>'  onBlur='ChangeUpperCase(this)' onkeypress="return CheckForSpecChars(event)" ><%}%><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class="fields"><input type="text" name="reason_short_desc" id="reason_short_desc" value="<%=bean.getReasonShortDesc()%>" onBlur="makeValidString(this);"  size='40' maxlength='40'><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="eOR.ReasonText.label" bundle="${or_labels}"/></td>
	<td class='fields'><TEXTAREA NAME="reason_desc" ROWS="3" COLS="40" onBlur = "return makeValidString(this)" onKeyPress="return CheckMaxLength(this,200)" <%=readOnly%>><%=bean.getReasonDesc()%></TEXTAREA><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="" <%=checked%> <%=readOnly%>></td>
</tr>
</table>
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

</form>
</body>
</html>


<%
		putObjectInBean(bean_id,bean,request);
 
%>

