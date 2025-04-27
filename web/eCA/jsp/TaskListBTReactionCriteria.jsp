<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%
	/*
		Added by kishore kumar N on 29/04/2010 for ICN-20903
	*/
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/*
		ends here.
	*/
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 08/12/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	/** ends here*/
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onLoad = "document.getElementById("search_text").focus()" onKeyDown="lockKey()">
<%
	/*Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;*/

	String search_text = request.getParameter("search_text") == null ? "" : request.getParameter("search_text");
%>
<script>

	var radioval="D";
	function closew()
	{
		parent.window.close();
	}
	function CallDescFrame()
	{
		
		var listval=document.getElementById("search_criteria").options.value;
		var txtbox=document.getElementById("search_text").value;
		parent.frames[1].location.href='../../eCA/jsp/TaskListBTReactionResult.jsp?search_by='+radioval+'&search_criteria='+listval+'&search_text='+escape(txtbox);
		
	}

	function storeVal(currad)
	{
		radioval = currad.value
	}

</script>

<form name='SearchCriteria' id='SearchCriteria'>
<br/>
<table  border="0" width='100%' cellspacing='0' cellpadding='0'>
	
	<tr>
		<td>&nbsp;&nbsp;</td>

		<td class="label" nowrap><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		
		<td  class="fields">
			 <input type="radio" name="search_by" id="search_by" class="label" value="C"  onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
			<input type="radio" name="search_by" id="search_by" class="label" value="D" checked onclick='storeVal(this)'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
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

		<td align='left'><input type="button" width='20%' align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="CallDescFrame(); " class='button' >		
		</td>
	</tr>
</table>
<!-- added by kishore kumar n on 08/12/2009  -->
<%
	if(!imgUrl.equals("")){%>
	
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>

<!--ends here -->
</form>
<script>
	if('<%=search_text%>' != '')
		document.forms[0].Search.click();
</script>
</body>
</html>

