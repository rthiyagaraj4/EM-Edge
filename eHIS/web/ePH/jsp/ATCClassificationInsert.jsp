<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu Start.
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		
		String level_num	=	request.getParameter("level");
		String title		=	"";
		String classval		=	"";
		  if(level_num.equals("1"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AnatomicalClass.label","ph_labels");
		  if(level_num.equals("2"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
		  if(level_num.equals("3"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
		  if(level_num.equals("4"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
		  if(level_num.equals("5"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
%>
<title><fmt:message key="ePH.ATCClassificationModifyAll.label" bundle="${ph_labels}"/> -<%=title%> </title>


<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>


<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>
<%

	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "PhATCClassification" ;
	String bean_name = "ePH.ATCClassificationBean";
	int	    totalRecords				=	0;
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ATCClassificationBean bean = (ATCClassificationBean)getBeanObject(bean_id,bean_name ,request);
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	/* Initialize Function specific end */
	/* Variable Declarations Start*/
	String	title1						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AnatomicalClass.label","ph_labels");
	String	title2						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
	String	title3						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
	String	title4						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
	String  anatomical_class_code		=	"";
	String  anatomical_class_desc		=	"";
	String	therapeutic_class_code		=	"";
	String	therapeutic_class_desc		=	"";
	String	therapeutic_class_subcode	=	"";
	String	therapeutic_class_subdesc	=	"";
	String	chemical_class_code			=	"";
	String	chemical_class_desc			=	"";
	String	chemical_class_subcode		=	"";
	String	chemical_class_subdesc		=	"";

		/* Variable Declarations End*/

	if(level_num.equals("2")) {
		anatomical_class_code	=	title1;
		anatomical_class_desc	=	bean.getATCLev1Desc();
	}
	if(level_num.equals("3")) {
		anatomical_class_code		=	title1;
		anatomical_class_desc		=	bean.getATCLev1Desc();
		therapeutic_class_code		=	title2;
		therapeutic_class_desc		=	bean.getATCLev2Desc();
	}
	if(level_num.equals("4")) {
		anatomical_class_code		=	title1;
		anatomical_class_desc		=	bean.getATCLev1Desc();
		therapeutic_class_code		=	title2;
		therapeutic_class_desc		=	bean.getATCLev2Desc();
		therapeutic_class_subcode	=	title3;
		therapeutic_class_subdesc	=	bean.getATCLev3Desc();
	}
	if(level_num.equals("5")) {
		anatomical_class_code		=	title1;
		anatomical_class_desc		=	bean.getATCLev1Desc();
		therapeutic_class_code		=	title2;
		therapeutic_class_desc		=	bean.getATCLev2Desc();
		therapeutic_class_subcode	=	title3;
		therapeutic_class_subdesc	=	bean.getATCLev3Desc();
		chemical_class_code			=	title4;
		chemical_class_desc			=	bean.getATCLev4Desc();
	}


%>
<!-- <body topmargin="0" onLoad="parent.focusFirstItem('<%=mode%>','insert')"> -->
<body onMouseDown="" onKeyDown="lockKey()" topmargin="0" onLoad="parent.focusFirstItem('<%=mode%>','insert')">
<form name="ATCClassification_Insert" id="ATCClassification_Insert" >
<table border="0" cellpadding="0" cellspacing="0" width="99%"  align="center">
    <tr>
		<td class=' COLUMNHEADER' width="22%" ><fmt:message key="ePH.ATCClass.label" bundle="${ph_labels}"/></td>
		<td class=' COLUMNHEADER' width="78%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td align="left" class="td" width="22%">&nbsp;<%=anatomical_class_code%></td>
		<td align="left" class="td" width="78%">&nbsp;<%=anatomical_class_desc%></td>
	</tr>
	<tr>
		<td align="left" class="td" width="22%">&nbsp;<%=therapeutic_class_code%></td>
		<td align="left" class="td" width="78%" >&nbsp;<%=therapeutic_class_desc%></td>
	</tr>
		<tr>
		<td align="left" class="td" width="22%" >&nbsp;<%=therapeutic_class_subcode%></td>
		<td align="left" class="td" width="78%" >&nbsp;<%=therapeutic_class_subdesc%></td>
	</tr>
	<tr>
		<td align="left" class="td" width="22%" >&nbsp;<%=chemical_class_code%></td>
		<td align="left" class="td" width="78%" >&nbsp;<%=chemical_class_desc%></td>
	</tr>
	<tr>
		<td align="left" class="td" width="22%" >&nbsp;<%=chemical_class_subcode%></td>
		<td align="left" class="td" width="78%" >&nbsp;<%=chemical_class_subdesc%></td>
	</tr>
	<tr>
		<td colspan="2" class="white">&nbsp;</td>
	</tr>
</table>


	<table border="0" cellpadding="0" cellspacing="0" width="99%" align="center">
	<tr>
		<td class=' COLUMNHEADER' colspan="4" style="background-color:white; color:black"><fmt:message key="Common.Add.label" bundle="${common_labels}"/> <%=title%> <fmt:message key="Common.details.label" bundle="${common_labels}"/> </td>
	</tr>
	</table>
	<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center" id="atcinserttable">
	<tr>
		<td class=' COLUMNHEADERCENTER' width="11%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADERCENTER' width="70%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADERCENTER' width="11%"><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></td>
		<td class=' COLUMNHEADERCENTER' width="8%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	</tr>
	<%
	int j=1;
	int row=1;
	int disp_no		=	bean.getMaxDisplaySeqNo(level_num);
	if(disp_no >=999999)
	disp_no	=	0;

	for(int i=0; i<totalRecords; i++) {
	disp_no	+=	10;
		if(row%2==0)
			classval="QRYEVEN";
		else
			classval="QRYODD";
	%>
	<tr>
		<%if(level_num.equals("5")) {%>
			<td align="left" width="11%" class="<%=classval%>"><input type="text"  name="atc_class_lev_code_<%=j%>" id="atc_class_lev_code_<%=j%>" maxlength="8" size="8" onKeyPress="parent.enableDesc('<%=j%>'); return CheckForSpecChars(event);" oninput="this.value = this.value.toUpperCase();"  onBlur="parent.resetColorCode(this);makeValidString(this);parent.checkSplChars(this);"> </td>
		<%}else{%>
            <td align="left" width="11%" class="<%=classval%>"><input type="text"  name="atc_class_lev_code_<%=j%>" id="atc_class_lev_code_<%=j%>" maxlength="6" size="6" onKeyPress="parent.enableDesc('<%=j%>'); return CheckForSpecChars(event);" oninput="this.value = this.value.toUpperCase();"  onBlur="parent.resetColorCode(this);makeValidString(this);parent.checkSplChars(this);"> </td>

        <%}%> 
		<td align="left" width="70%" class="<%=classval%>"><input type="text" name="atc_class_lev_desc_<%=j%>" id="atc_class_lev_desc_<%=j%>" maxlength="100" size="75"  onBlur="this.value = parent.trimString(this.value);parent.resetColorCode(this);parent.makeSelectChk('<%=j%>'); makeValidString(this);"></td>
		<td align="left" width="11%" class="<%=classval%>"><input type="text" name="display_seq_no_<%=j%>" id="display_seq_no_<%=j%>" maxlength="6" size="6" value="<%=disp_no%>" style="text-align:right" onKeyPress="return(parent.ChkNumberInput(this,event,0))"  onBlur="parent.resetColorCode(this);parent.CheckPositiveNumber(this);parent.chkDecimal(this);parent.checkForZero(this)"></td>
		<td align="center" width="8%" class="<%=classval%>"><input type="checkbox" name="select_<%=j%>" id="select_<%=j%>" ></td>
	</tr>
	<% j++;
		row++;
		}
		
putObjectInBean(bean_id,bean,request);
	%>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width="99%" align="center">
	<tr>
			<td align="right" colspan="4"  class="white">
			<input type="button" class="BUTTON" name="record" id="record" value="Record" onClick="parent.apply('<%=mode%>')"><input type="reset" class="BUTTON"  name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick="parent.resetScreen()"><input type="button" class="BUTTON" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="parent.callClose()">
			</td>
		</tr>
	</table>
	<input type="hidden" name="level_no" id="level_no" value="<%=level_num%>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
</form>
</body>
</html>

