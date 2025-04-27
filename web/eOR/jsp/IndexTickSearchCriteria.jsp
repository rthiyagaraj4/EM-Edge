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
------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
09/10/2014	IN050655		VijayakumarK	09/10/2014							iASSIST ID : 807002 Index Tick sheet by practitioner is a 
																				good functionality to provide personalised tick sheets to practitioners.
																				This file is created newly for this CRF
------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<table>
<tr>
			<td>&nbsp;&nbsp;</td> 
			<td class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
			<td class="fields">	
				<input type="radio" name="search_by" id="search_by" id="rdCode" class="label" value="C" onclick="searchByRd(this)"><fmt:message key="Common.code.label" bundle="${common_labels}"/>
				<input type="radio" name="search_by" id="search_by" id="rdDesc" class="label" value="D" onclick="searchByRd(this)" checked><fmt:message key="Common.description.label" bundle="${common_labels}"/>
			</td>
			<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<select name="search_criteria" id="search_criteria">
					<option value="S" selected><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
				</select>
			</td>       
</tr> 
<tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields">
			<input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
		<td class="label">&nbsp;</td>
        <td align="left" nowrap>
			<input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchText(this);' class="button" >
			<input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetQueryForm();" class="button" >
        </td>
</tr>
</table>

