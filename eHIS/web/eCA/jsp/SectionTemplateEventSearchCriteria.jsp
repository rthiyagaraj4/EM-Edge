<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%


	String search_text="";
	String textval=request.getParameter("text_Val")==null?"":request.getParameter("text_Val");
	search_text=textval==null?"":textval;
%>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request); //MOHE-SCF-0153
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by Ambiga on 29/12/2008  */
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	/** ends here*/


%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
    <script language='javascript' src="../../eCommon/js/common.js"></script>
    <script>
		function onLoadFn()
		{
			document.getElementById("search_text").focus();
		}
		var radioval="D";
		function closew()
		{
			parent.window.close();
		}
		function CallDescFrame()
		{
			var listval=document.getElementById("search_criteria").value;
			var txtbox=document.getElementById("search_text").value;
			
			parent.frames[1].location.href='../../eCA/jsp/SectionTemplateEventSearchResult.jsp?<%=request.getQueryString()%>&search_by='+radioval+'&search_criteria='+listval+'&search_text='+escape(txtbox);
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
</head>
<body onLoad = "onLoadFn()" onKeyDown="lockKey()">



<table align='center'  border="0" width=100% cellspacing='0' cellpadding='3'>
	<tr width='100'>
		
		<td  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>&nbsp;<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class="label"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
		<td class="field">
		<select name="search_criteria" id="search_criteria">
		<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
		<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
		<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
		</select>
		</td>
		
	</tr>
	<tr>
		
		<td class='label' colspan=2  ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
		<input type="text"  onBlur='makeValidString(this);' name="search_text" id="search_text" value='<%=search_text%>' width=30%  size='40' maxlength='70' >
		<!--<img src='../../eMP/images/mandatory.gif'align='center'></img>-->
		</td>
		<td class='fields'><input type="button" width='20%'  name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="valtext(search_text); " class='button' >
		<!--<td align='right'><input type="button" width='20%' align="left" name="Search" id="Search" value="Search" class='button' >-->
		</td>
	</tr>
</table>
<!-- added by Ambiga on 29/12/2008  -->
			<%if(!imgUrl.equals("")){ %>
				 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>
<!--ends here -->	
<BR>
<BR>
<SCRIPT LANGUAGE="JavaScript">
<!--
	var searchtxt=document.getElementById("search_text").value;
	if(searchtxt!=null)
	{
	  valtext(searchtxt);
	}
//-->
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</form>
</body>
</html>

