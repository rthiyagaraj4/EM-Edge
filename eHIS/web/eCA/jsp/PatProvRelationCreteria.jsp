<!DOCTYPE html>
<%@page import="java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 06/12/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
 function clearclick()
 {
      document.location.reload();
	  top.content.workAreaFrame.PatProvrelationResultFrame.location.href='../../eCommon/html/blank.html';

 }
</script>
<head>
	<title><fmt:message key="eCA.ViewPatientAllergyCriteriaJSP.label" bundle="${ca_labels}"/></title>
</head>

<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<center>
		<form name='CAViewPatientAllergyCriteriaForm' id='CAViewPatientAllergyCriteriaForm' method='post'  target = 'PatProvrelationResultFrame' action='PatProvRelationResult.jsp?<%=request.getQueryString()%>'>
			<table border=0 align=center cellpadding=3 cellspacing=0 width='100%' >
			<tr>
				<td class=label  width='4%'><input type="radio" name="lifetime" id="lifetime" value ='1'></td><td  valign='center' class='LABEL'  width='15%'><fmt:message key="eCA.LifeTime.label" bundle="${ca_labels}"/></td>
				<td   ></td>  <!-- class=QRYODD   -->
				<td class=label  width='4%'> <input type="radio" name="self" id="self" value ='1' checked></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="Common.self.label" bundle="${common_labels}"/></td>
				<td  ></td>
				<td class=label  width='4%' ><input type="radio" name="active" id="active"	value ='1' Checked></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="Common.active.label" bundle="${common_labels}"/></td>
				<td ></td>
				<td class=label   width='4%'><input type="radio" name="encounter" id="encounter" value ='1'  ></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="eCA.SelectedEncounter.label" bundle="${ca_labels}"/></td>
				<td ></td>
				</tr>
			<tr>
				<td class=label   width='4%'><input type="radio" name="lifetime" id="lifetime" value ='2'></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></td>
				<td ></td>  <!--class=QRYODD width='1%' -->
				<td class=label   width='4%'><input type="radio" name="self" id="self"	 value ='2'></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="Common.others.label" bundle="${common_labels}"/></td>
				<td ></td>
				<td class=label   width='4%'><input type="radio" name="active" id="active" value ='2'></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="Common.Expired.label" bundle="${common_labels}"/></td>
				<td ></td>
				<td class=label   width='4%'><input type="radio" name="encounter" id="encounter" value ='2' checked></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="Common.AllEncounters.label" bundle="${common_labels}"/></td>
				<td ></td>
			</tr>
			<tr>
				<td class=label   width='4%'><input type="radio" name="lifetime" id="lifetime" value ='3' checked></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
				<td ></td>
				<td class=label   width='4%'><input type="radio" name="self" id="self"	 value ='3'></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
				<td ></td>
				<td class=label  width='4%'><input type="radio" name="active" id="active"	value ='3'></td><td  valign='center' class='LABEL' width='15%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
				<td ></td>
				<td class=label align='right' >&nbsp;</td>
				<td class=label align='right' >&nbsp;</td>
				<td ></td>
			</tr>
			<tr>
			<td colspan=10></td><td colspan=1></td>
			<td  align=right nowrap>
					<input type='submit' class='button' name='search' id='search'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'>
					<input type = 'button'  class = 'button' name = 'clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick = 'javascript:clearclick()'>
				</td>
				
				</tr>
			</table>
			<!-- added by kishore kumar n on 06/12/2009  -->
			<%if(!imgUrl.equals("")){ %>
				 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>
				<!--ends here -->
		</form>
	</center>
</body>
</html>

