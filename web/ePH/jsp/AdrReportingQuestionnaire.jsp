<!DOCTYPE html>
	<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*, java.io.*,ePH.*,ePH.Common.*,eCommon.Common.*,java.text.*,java.net.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<html> 
<head>
<Title><fmt:message key="ePH.Questionnaire.label" bundle="${ph_labels}"/></Title>
<%
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" SRC="../../eCommon/js/dchk.js"></script>
	<script language="javascript" SRC="../../eCommon/js/CommonLookup.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
    <script language="JavaScript" src="../js/ADRReporting.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
   // String	login_user		=	(String)session.getValue("login_user");
   	String	bean_id			=	"ADRReport" ;
	String	bean_name		=	"ePH.ADRReportBean";
	String  sysdate;
	String	question_code	=null;
	String	question_desc	=null;
	//String	yes_scor		=null;
	//String	no_score		=null;
	//String	not_known_score	=null;
	String	rdresponse		=null;
	String	rdbutton1		="";
	String	rdbutton2		="";
	String	rdbutton3		="";
	ArrayList questionList=null;
	//String mode=request.getParameter("mode");
	//String adr_no=request.getParameter("adr_no");
	String verified_by=request.getParameter("verified_by");
	String disable = "";
	if(!verified_by.equals(""))
	disable = "disabled";
	ADRReportBean bean = (ADRReportBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	sysdate=bean.getSysdate();
	questionList=bean.getQuestionnaire();
%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="adrreportquestionnaire" id="adrreportquestionnaire">
<div style="height: 96vh; overflow-y: auto;">
<table cellpadding="0" cellspacing="0"  border="1" width="100%" align="center">
<tr>
<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="ePH.Question.label" bundle="${ph_labels}"/></th>
<th><fmt:message key="Common.yes.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.no.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.NotKnown.label" bundle="${common_labels}"/></th>
</tr>
<%
String Qryclass="";
int rowcount=2;
HashMap adrlist;
try{
int n=questionList.size();
for(int j=0;j<n;j++){
	rdbutton1="";
	rdbutton2="";
	rdbutton3="";
	adrlist=new HashMap();
	adrlist=(HashMap)questionList.get(j);
	question_code	=(String)adrlist.get("code");
	question_desc	=(String)adrlist.get("description");
	rdresponse		=(String)adrlist.get("response");
	if(rdresponse==null)rdresponse="";
	if(rdresponse.equals("Y")){
		rdbutton1="checked";
	}else if(rdresponse.equals("N")){
		rdbutton2="checked";
	}else if(rdresponse.equals("U")){
		rdbutton3="checked";
	}
			if(rowcount%2==0)
		{
			Qryclass="QRYEVEN";
		}
		else
		{
			Qryclass="QRYODD";
		}%>
		<tr >
		<td class="<%=Qryclass%>" width='6%'><%=question_code%></td>
		<td class="<%=Qryclass%>" width='50%'><%=question_desc%></td>
		<td class="<%=Qryclass%>" width='8%'><input type="radio" name="<%=adrlist.get("code")%>" id="<%=adrlist.get("code")%>" class="<%=Qryclass%>" value="Y"    <%=rdbutton1%> onclick="modadrresponse(<%=j%>,1)" <%=disable%>></td>
		<td class="<%=Qryclass%>" width='8%'><input type="radio" name="<%=adrlist.get("code")%>" id="<%=adrlist.get("code")%>" class="<%=Qryclass%>" value="N"    <%=rdbutton2%> onclick="modadrresponse(<%=j%>,2)" <%=disable%>></td>
		<td class="<%=Qryclass%>" width='8%'><input type="radio" name="<%=adrlist.get("code")%>" id="<%=adrlist.get("code")%>" class="<%=Qryclass%>" value="U"    <%=rdbutton3%> onclick="modadrresponse(<%=j%>,3)" <%=disable%>></td>
		</tr>
<%rowcount++;}
}catch(Exception e){

}

putObjectInBean(bean_id,bean,request);
%>
<tr width='100%' align="right">
		<td colspan="7" >
		<input type="button" align="right" name="ok" id="ok" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="window.returnValue=true,window.close();" class='button'>&nbsp;
		<input type="button"  align="right" name="clear" id="clear" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class='button'  onClick="window.returnValue=5,window.close();">
		</td>
</tr>
</table>
</div>


	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">
</form>
</body>
</html>

