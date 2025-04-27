<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

	String std_comp_id = request.getParameter( "std_comp_id" );
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String search_text = request.getParameter( "search_text" )==null?"":request.getParameter( "search_text" );//IN067538
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
    <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
    <script src="../../eCA/js/CommonLookUp.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body >
<form name="CriteriaForm" id="CriteriaForm"  >
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr width="100">
        <td class="label" ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
        <td  class="fields"><input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick="	document.CriteriaForm.radBtnVal.value = this.value;"><fmt:message key="Common.description.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="	document.CriteriaForm.radBtnVal.value = this.value;"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
       </tr>
    <tr>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields" ><input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="<%=search_text%>" width="30%" align="left" size="40" maxlength="70" ><!--IN067538-->
        </td><td>&nbsp;</td>
        <td align="right"><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext('<%=std_comp_id%>'); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<BR>
<BR>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type='hidden' name='radBtnVal' id='radBtnVal' value='D'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
</form>
</body>
<!--IN067538 start-->
<%if(!"".equals(search_text)){%>
<script>
  valtext('<%=std_comp_id%>')
</script>
<%}%>
<!--IN067538 end-->
</html>

