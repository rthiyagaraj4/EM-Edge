<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.RegRecepients.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 06/12/2009 for CRF-0387 */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCA/js/EMail.js" language="javascript"></script>
	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
		<form name='regNamesCriteriaForm' id='regNamesCriteriaForm'>
				<table align="center"  border="0" width="100%" cellspacing="0" cellpadding="3">
				<tr>
					<td class='label' colspan='8'><b><fmt:message key="eCA.ToRegdRecepient.label" bundle="${ca_labels}"/></b></td>
				</tr>
				<tr>
					<td  class='label'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/> <input type='radio' name='radSearch' id='radSearch' value='D' checked><fmt:message key="eCA.RegisteredRecipientName.label" bundle="${ca_labels}"/>&nbsp;<input type='radio' name='radSearch' id='radSearch' value='C'><fmt:message key="eCA.RegisteredRecipientID.label" bundle="${ca_labels}"/>&nbsp;</td>
					<td  colspan='2'>&nbsp;</td>
					<td  class='fields' ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
						<select name="search_criteria" id="search_criteria">
							<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
							<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
						</select>
						<td   colspan=4>&nbsp;</td>
					</td>
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/><input type="text" name="search_text" id="search_text" size='30' maxlength='8' value=""></td>
					<td   colspan=2>&nbsp;</td>
					<td  align='center'><input type="button"  name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onclick='loadRegNames()' ></td>					
					<td >

					</td>
				</tr>
			</table>
				<!-- added by kishore kumar n on 06/12/2009  -->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
				<!--ends here -->

		</form>
	</body>

