<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			request.setCharacterEncoding("UTF-8");
			
			String excludePract  =	request.getParameter("excludePract");
			String practCount  =	request.getParameter("practCount")==null?"0":request.getParameter("practCount");
			String clinic_code  =	request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
			String appt_id  =	request.getParameter("appt_id")==null?"":request.getParameter("appt_id");
			String practList  =	request.getParameter("practList")==null?"":request.getParameter("practList");
			String curpractid  =	request.getParameter("practList")==null?"":request.getParameter("curpractid");
			if ((excludePract==null) || (excludePract.equals("null")))  excludePract = "";

		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
    <script src="../../eOP/js/QmgmtRe_AssignPract.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
    <script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;

		var fieldLegend     = window.dialogArguments[8] ;
		if(fieldLegend == null) {
		fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = getLabel("Common.code.label","common")
		fieldLegend["DESC_LEGEND"] = getLabel("Common.description.label","common")
		}
		
    </script>
</head>
<body onKeyDown = 'lockKey()' onunload='cancelCheckedPracts();'>

<form name="CriteriaForm" id="CriteriaForm"  >
<table  border="0" width="100%" cellspacing="0" cellpadding="0">
<tr>&nbsp;</tr>
    <tr >
        <td>&nbsp;&nbsp;</td> 
		<td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>

        <td  class="fields"><input type="radio" name="search_by_code" id="search_by_code" class="label" value="C"    onclick="storeVal1()"><script>document.write(fieldLegend["CODE_LEGEND"])</script>
        <input type="radio" name="search_by_desc" id="search_by_desc" class="label" value="D" checked onclick="storeVal2()" checked><script>document.write(fieldLegend["DESC_LEGEND"])</script></td>

		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_criteria" id="search_criteria" onchange="checkCriteria(this);">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
       
    </tr> 
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
		<td class="label">&nbsp;</td>

        <td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext();" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<br>
	 <input type='hidden' name='radioval' id='radioval' value='D'/>
	 <input type='hidden' name='excludePract' id='excludePract' value='<%=excludePract%>'/>
	<input type='hidden' name='practCount' id='practCount' value='<%=practCount%>'/> 
	<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>'/> 
	<input type='hidden' name='appt_id' id='appt_id' value='<%=appt_id%>'/> 
	<input type='hidden' name='practList' id='practList' value='<%=practList%>'/> 
	<input type='hidden' name='curpractid' id='curpractid' value='<%=curpractid%>'/> 
	<input type='hidden' name='searchcriteria' id='searchcriteria' value='S'/> 
</form>
</body>
<script>
</script>
</html>


