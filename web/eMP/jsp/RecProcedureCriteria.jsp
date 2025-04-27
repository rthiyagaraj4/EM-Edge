<!--
CRF Reference No     :  NMC-JD-CRF-102.18
Detected Release  No      :  MARCH 2024 Release 
File prepared by          :  SANTHOSH KUMAR N
File prepared date        :  13-03-2024
Purpose of the Change   :  As a PAS user I should be able to record external referrals as well as display "Nphies orders" lookup field to select Nphies orders a multi-selection of orders and thus the selected orders will be displayed in referral screen. 
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All Sites    
-->
<%@ page import="java.sql.*, java.util.*, java.text.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			request.setCharacterEncoding("UTF-8");

			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }
			
			
			String searchText=request.getParameter("termDesc");
			String selectedCodeDtl=request.getParameter("checkedNPHData");
			String event=request.getParameter("event");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
    <script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
    <script src="../js/RecordProcedure.js" language="javascript"></script>
    <script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;

		var fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = getLabel("Common.code.label","common")
		fieldLegend["DESC_LEGEND"] = getLabel("Common.description.label","common")
		
    </script>
</head>
<body onKeyDown = 'lockKey()' onload="chk_spl_char();validatetext('<%=searchText%>','S','<%=event%>');">

<form name="CriteriaForm" id="CriteriaForm">
<table  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr >
        <td>&nbsp;&nbsp;</td> 
		<td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>

        <td  class="fields"><input type="radio" name="search_by" id="search_by" class="label" value="C"    onclick="SearchByVal(this)"><script>document.write(fieldLegend["CODE_LEGEND"])</script>
        <input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="SearchByVal(this)" checked><script>document.write(fieldLegend["DESC_LEGEND"])</script></td>
		
		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
       
    </tr> 
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text" value="<%=searchText%>" width="30%" align="left" size="40" maxlength="75" >
        </td>
		<td class="label">&nbsp;</td>

        <td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="validatetext(search_text,search_criteria);" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForms(this.form)" class="button" >
        </td>
    </tr>
</table>
<br>
<%if(!imgUrl.equals("")){ %>
	 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>

<input type="hidden" id="selectedCodeDtl" name="selectedCodeDtl" id="selectedCodeDtl" value="<%=selectedCodeDtl%>">

</form>
</body>
<script>
    //initializeText();
</script>
</html>
 

