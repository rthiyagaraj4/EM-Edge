<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
	out.println(search_text);
%>
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
		 //end
		 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = "document.getElementById("search_text").focus()">
<form name='locationCreteria' id='locationCreteria'>
<script>

	var radioval="D";
	function closew()
	{
		parent.window.close();
	}
	function CallDescFrame()
	{
		var listval=document.getElementById("search_criteria").options.value;
		var txtbox=document.getElementById("search_text").value.toUpperCase();
		//var splty_code =document.getElementById("speciality").value;
		parent.frames[1].location.href='LocationforPractSearchResult.jsp?<%=request.getQueryString()%>&search_by='+radioval+'&search_criteria='+listval+'&search_text='+txtbox
		//+'&splty_code='+splty_code
	 }

	function storeVal(currad)
	{
		radioval=currad.value
	}
	function valtext(comp)
	{
		// var txt=comp.value.toUpperCase();
		//if (comp.value=="" || comp.value==null)
		//alert ("Search Text Cannot Be Blank")
		//else
			CallDescFrame(this);
	}
</script>



<table align='center'  border="0" width=100% cellspacing='0' cellpadding='3'>
	<tr >
		<td  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td>	<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
		</td>
		<td><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
		<td>
		<select name="search_criteria" id="search_criteria">
		<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
		<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
		<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>		</select>
		</td>
	</tr>
	<tr>		
		<td class='label' ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
		<td>	<input type="text"  name="search_text" id="search_text" value='<%=search_text%>' width=30%  size='40' maxlength='70' >
		</td><td></td>
		<td ><input type="button" width='20%'  name="Search" id="Search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="valtext(search_text); " class='button' >
		<input type="button" align="left" name="Reset" id="Reset" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>" onClick="resetForm(this.form)" class="button" >
		
		</td>
	</tr>
</table>
 <%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%> 
<BR>
<BR>
<%
	if(!search_text.equals(""))
	{
%>
<script>
	valtext('<%=search_text%>');
		//return false;
function resetForm(obj)
{
	obj.reset();
	parent.frames[1].location.href = "../../eCommon/html/blank.html";
}
</script>
<%	
	}
%>
</form>
</body>
</html>

