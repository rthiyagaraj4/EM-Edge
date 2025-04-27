<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
	String description = request.getParameter("desc_val")==null?"":request.getParameter("desc_val");	
%>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	// added by Arvind @ 10-12-08 
			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad='' onKeyDown="lockKey()">
<center>
<form name='CAComponentLookUpCriteriaForm' id='CAComponentLookUpCriteriaForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="Common.ComponentID.label" bundle="${common_labels}"/></td>
	<td>&nbsp;<input type='text' name='comp_id' id='comp_id' value='<%=description%>' size='15' maxLength='15'></td>
	<td class='LABEL' align='RIGHT'><fmt:message key="Common.ComponentPrompt.label" bundle="${common_labels}"/></td>
	<td >&nbsp;<input type='text' name='comp_prompt' id='comp_prompt' value='' size='20' maxLength='20'></td>
</tr>
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/></td>
	<td>&nbsp;<select name='comp_type' id='comp_type'>
		<option value=''>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
		<option value='D'><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>
		<option value='E'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.DecimalNumeric.label" bundle="${common_labels}"/></option>
		<%if(!calledFrom.equals("PF") && !calledFrom.equals("GD") && !calledFrom.equals("MA")){%>
		<option value='P'><fmt:message key="Common.EmbeddedComponent.label" bundle="${common_labels}"/></option>
		<option value='A'><fmt:message key="Common.Formula.label" bundle="${common_labels}"/></option>
		<%}%>
		<%if(calledFrom.equals("") || (!calledFrom.equals("PF") && !calledFrom.equals("MA") && !calledFrom.equals("GD"))){%>
		<option value='R'><fmt:message key="Common.GridComponent.label" bundle="${common_labels}"/></option>	
		<%}%>
		<option value='I'><fmt:message key="Common.IntegerNumeric.label" bundle="${common_labels}"/></option>
		<option value='L'><fmt:message key="Common.ListItem.label" bundle="${common_labels}"/></option>
		<%if(!calledFrom.equals("GD") && !calledFrom.equals("MA")){%>
		<option value='F'><fmt:message key="Common.LongText.label" bundle="${common_labels}"/></option>
		<%}%>
		<%if(calledFrom.equals("") || (!calledFrom.equals("PF") && !calledFrom.equals("MA") && !calledFrom.equals("GD"))){%>
		<option value='X'><fmt:message key="Common.MatrixComponent.label" bundle="${common_labels}"/></option>		
		<%}%>
		
		<option value='H'><fmt:message key="Common.ShortText.label" bundle="${common_labels}"/></option>
		<option value='T'><fmt:message key="Common.time.label" bundle="${common_labels}"/></option>
		<option value='C'><fmt:message key="Common.YesNo.label" bundle="${common_labels}"/></option>
	
	

	
		</select>
	</td>
	<td class='LABEL' align='RIGHT' >&nbsp;</td>
	<td class='LABEL' align='LEFT' ><input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='return callComponentLookup("<%=calledFrom%>");'></td>
</tr>
<tr>
	<td class='LABEL' align='RIGHT' colspan='4'>&nbsp;</td>
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
<script>
checkCriteria("<%=calledFrom%>");
</script>
</form>
</center>

</body>
</html>

