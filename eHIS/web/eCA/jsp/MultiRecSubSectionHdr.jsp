<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

// added by Arvind @  06-12-08 

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
	<Script src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCA/js/MultiRecSubSection.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body class='CONTENT' OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
	<form name="HeaderForm" id="HeaderForm" >
	<center>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center"> 
		<tr>
			<td class="label" ><fmt:message key="eCA.MainSection.label" bundle="${ca_labels}"/></td>
			<td class='fields'><input type='hidden' name='section' id='section' value='' ><input type='text' name ='sectionCode' onBlur='getMultiSubSectionCode(this)' OnChange='resetValues();setValue()'><input type ='button' class='button' name='section_search' id='section_search' value='?' onclick='resetValues();getMultiSubSectionCode(this)'><img src="../../eCommon/images/mandatory.gif"></img>
				<td colspan = 2 align ='right'>
					<input type="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="fetchRecords();"  class="button">
				</td>
		</tr>
		</center>
	</table>
	<!-- added by arvind @ 06-12-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->
	    <input type='hidden' name='flag' id='flag' value='true'>
		<input type="hidden" name="selectYNStr" id="selectYNStr" value="">
		<input type="hidden" name="finalString" id="finalString" value=""><!-- Holds The ConCatenated Final String Value -->
	</form>
</body>
</html>


