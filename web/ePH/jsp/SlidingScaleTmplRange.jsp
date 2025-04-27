<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
	    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale= (String)session.getAttribute("LOCALE");
         String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||
		               (session.getAttribute("PREFERRED_STYLE")!="")?
					    (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../ePH/js/SlidingScaleTmpl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 <SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT> 
</HEAD>
<%
	String	mode			=	request.getParameter( "mode" ) ;
	String	bean_id			=	"SlidingScaleTmpl" ;
	String	bean_name		=	"ePH.SlidingScaleTmplBean";
	
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
		

	/* Mandatory checks end */
	/* Initialize Function specific start */
	SlidingScaleTmplBean bean = (SlidingScaleTmplBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String facility_id		=		(String)session.getValue( "facility_id" );

    //All parameters
	String index			=		bean.checkForNull(request.getParameter("index"),"-1");
	String adminUnits		=		"";
	String fromUOM			=		"";
	String remarks			=		"";
    String toUOM			=		"";
	String db_action		=		"";
	String rangeUnite		=		"";
	String andimUnite		=		"";
	String informPractitioner =     "N";
	String cheked			=		"";
	String focusflag		=		request.getParameter("focusflag")==null?"":request.getParameter("focusflag");
	adminUnits				=		request.getParameter("admin_units")==null?"":request.getParameter("admin_units");
	fromUOM					=		request.getParameter("from_uom")==null?"":request.getParameter("from_uom");

	toUOM					=		(request.getParameter("to_uom")==null ||
	                        (request.getParameter("to_uom").trim()).equals(String.valueOf(0)))?"":request.getParameter("to_uom");

	remarks					=		request.getParameter("remarks")==null?"":request.getParameter("remarks");
	informPractitioner		=		request.getParameter("informPractitioner")==null?"N":request.getParameter("informPractitioner");
	

	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
		    rangeUnite		=		request.getParameter("rangeUOM_desc")==null?"":request.getParameter("rangeUOM_desc");
			andimUnite		=		request.getParameter("adminUnitUOM_desc")==null?"":request.getParameter("adminUnitUOM_desc");
	}
	if(((String)informPractitioner).equals("Y"))
				cheked  = "checked";
	%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name="formSlidingScaleTmplRange" id="formSlidingScaleTmplRange"   onload="document.formSlidingScaleTmplRange.fromUOM.focus();" onreset="FocusFirstElement();">
	<table cellpadding="0" cellspacing="3" width="100%" align="center" border="0">
 		<tr>
			<th align="left" colspan="8" class="label">&nbsp;</th>
		</tr> 
		<tr>
			<td  class="label" align="left"  style="font-weight:bold"> <fmt:message key="Common.Range.label" bundle="${common_labels}"/> </td>
			&nbsp;<td  align="left" colspan="7">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label" align="right"> 
			<fmt:message key="ePH.FROMRANGE.label" bundle="${ph_labels}"/>
			</td>
			<td  align="left" colspan="1">&nbsp;<input type="text" name="fromUOM" id="fromUOM" tabIndex="0"class="NUMBER" value="<%=fromUOM.trim()%>" size="10" maxlength="10"  onKeyPress="return allowValidNumber(this, event,6,3)" 
			onblur="allowValidNumber(this, event,6,3);return checkDoubleFormat(this);document.formSlidingScaleTmplRange.fromUOM.focus();">
			&nbsp;<label id="range_unit_from"><%=rangeUnite%></label>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			<td  class="label" align="right">
			<fmt:message key="ePH.TORANGE.label" bundle="${ph_labels}"/>
			</td>
			<td  align="left" colspan="1">&nbsp;
			<input type="text" name="toUOM" id="toUOM" class="NUMBER"  value="<%=toUOM.trim()%>" size="10" maxlength="10"
			onKeyPress="return allowValidNumber(this, event,6,3)"
			onblur="allowValidNumber(this, event,6,3);return checkDoubleFormat(this);">
			&nbsp;<label id="range_unit_to" ><%=rangeUnite%></label>
			<!-- <img src="../../eCommon/images/mandatory.gif" align="center"></img> --></td>
            &nbsp;
			 <td  class="label" align="right">
			<fmt:message key="ePH.InformPractitioner.label" bundle="${ph_labels}"/> &nbsp;&nbsp;
			<input type="checkBox" name="informPractitioner" id="informPractitioner" value="<%=informPractitioner%>" onclick="assignInfoPractitioner(this);" <%=cheked%> ></td><td  align="left" colspan="1">&nbsp;
		  </tr><tr>
			<td  class="label" align="right"><fmt:message key="ePH.ADMINVALUE.label" bundle="${ph_labels}"/>
			</td>
			<td  align="left" colspan="1">&nbsp;<input type="text" name="adminUnits" id="adminUnits" class="NUMBER" value="<%=adminUnits.trim()%>" size="10" maxlength="10" onKeyPress="return allowValidNumber(this, event,6,3)" onblur="allowValidNumber(this, event,6,3);return checkDoubleFormat(this); " >
			
			&nbsp;<label id="admin_unit"><%=andimUnite%></label>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
            	<td  class="label" align="right"> 
				<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td  align="left" colspan="3">&nbsp;&nbsp;<input type="text" name="remarks" id="remarks" value="<%=remarks%>" size="60" maxlength="60" >
			  <td  align="left" colspan="0">&nbsp;
			</tr>		
			<tr>
			<td  align="left" colspan="5">&nbsp;
		   <td align="right" class="label">
				<input type="button" class="button" name="Ok" id="Ok" 
				value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" 
				 onclick="if( EnableDisableUOM())addToRangeDetails(this,document.formSlidingScaleTmplRange);test(this,'<%=mode%>');">
				<input type="button" class="button" name="Cancel" id="Cancel"
				value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" 
				onclick="cancel(document.formSlidingScaleTmplRange);">
			</td>&nbsp;
<td  align="left" colspan="1">
		</tr>	
	</table>
     <input type="hidden" name="index" id="index"		value="<%=index%>">
	<input type="hidden" name="db_action" id="db_action"	value="<%=db_action%>">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%= locale %>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
	
</FORM>
</BODY>
<script>
changeUnit();
//document.frames.formSlidingScaleTmplRange.fromUOM.focus();
</script>
<%if(focusflag.equals("focusflag")){%>
<script>
document.formSlidingScaleTmplRange.fromUOM.focus();
</script>
<%}%>
</HTML>

