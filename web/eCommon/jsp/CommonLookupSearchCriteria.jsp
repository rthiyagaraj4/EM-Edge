<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.text.*"  contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="x-ua-compatible" content="IE=Edge"/>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			request.setCharacterEncoding("UTF-8");

			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src="../js/ValidateControl.js" language="javascript"></script>
    <script src="../js/common.js" language="javascript"></script>
    <script src="../js/CommonLookup.js" language="javascript"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
    
    <script>
	//alert("inisde script 1");
        var chkBothCriteria = false ;
        var fromCalledPage = false ;
        
        //var argArray = window.parent.dialogArguments;        
        var argArray = parent.window.dialogArguments ;
		if(argArray==undefined)
         argArray =  parent.parent.document.getElementById('dialog-body').contentWindow.dialogArguments ;
		
		//var fieldLegend     = parent.window.dialogArguments[8] ;
		var fieldLegend     = argArray[8] ;
		//var fieldLegend;
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
<body onKeyDown = 'lockKey()' onload='chk_spl_char()'>

<form name="CriteriaForm" id="CriteriaForm"  >
<table  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr >
        <td>&nbsp;&nbsp;</td> 
		<td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>

        <td  class="fields"><input type="radio" name="search_by" id="search_by" class="label" value="C"    onclick="storeVal(this)"><script>document.write(fieldLegend["CODE_LEGEND"])</script>
        <input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="storeVal(this)" checked><script>document.write(fieldLegend["DESC_LEGEND"])</script></td>

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
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="75" >
        </td>
		<td class="label">&nbsp;</td>

        <td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext(search_text); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<br>
<%if(!imgUrl.equals("")){ %>
	 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
</form>
</body>
<script>
    initializeText();
</script>
</html>

