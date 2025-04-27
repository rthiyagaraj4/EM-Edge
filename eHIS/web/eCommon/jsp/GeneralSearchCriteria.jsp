<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*" %>
<html>
<%


	String search_text="";
%>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;
		var argArray;
		var fieldLegend;
        argArray = window.parent.dialogArguments ;
		if(fieldLegend == null) {
		fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = getLabel("Common.code.label","common")
		fieldLegend["DESC_LEGEND"] = getLabel("Common.description.label","common")
		}
		else{
			fieldLegend     = argArray[8] ;
		}
		
    </script>
</head>
<body onKeyDown = 'lockKey()'  onLoad = document.getElementById("search_text").focus()>
<script>

	var radioval="D";
	function closew()
	{
		parent.window.close();
	}
	function CallDescFrame()
	{
		var listval=document.getElementById("search_criteria").value;
		var txtbox=document.getElementById("search_text").value;
		parent.frames[1].location.href='../../eCommon/jsp/GeneralSearchResult.jsp?<%=request.getQueryString()%>&search_by='+radioval+'&search_criteria='+listval+'&search_text='+encodeURIComponent(txtbox);
	 }

	function storeVal(currad)
	{
	radioval=currad.value
	 }

	 function valtext(comp)
	 {   
		 var txt=comp.value;
		//if (comp.value=="" || comp.value==null)
			//alert ("Search Text Cannot Be Blank")
		 //else
			CallDescFrame(this);
	}
</script>


<table align='right'  border="0" width=100% cellspacing='0' cellpadding='0'>
	<tr width='100'>
		<td>&nbsp;&nbsp;</td>

		<td class="label" nowrap><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		
		<td  class="fields">
			 <input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'><script>document.write(fieldLegend["DESC_LEGEND"])</script>
			<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><script>document.write(fieldLegend["CODE_LEGEND"])</script>
		</td>



		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>

		<td class='fields'>
			<select name="search_criteria" id="search_criteria">
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
		</td>


	</tr>
	<tr>
		<td>&nbsp;&nbsp;</td>

		<td class='label' nowrap><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>

		<td class="fields"><input type="text" onBlur='makeValidString(this);'  name="search_text" id="search_text" value='<%=search_text%>' width=30% align="left" size='40' maxlength='70' ></td>

		<td>&nbsp;</td>

		<td align='left'><input type="button" width='20%' align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext(search_text); " class='button' >
		</td>

	</tr>
</table>
<BR>
<BR>
</form>
</body>
</html>

