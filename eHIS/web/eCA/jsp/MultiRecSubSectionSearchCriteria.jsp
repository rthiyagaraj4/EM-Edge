<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
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
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/MultiRecSubSection.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
     <form name="MultiRecSubSectionSearchfrm" id="MultiRecSubSectionSearchfrm" >
	 <table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
		<tr align='left'><th class='columnHeader' width='100%' colspan='3'><fmt:message key="eCA.SelectSubSection.label" bundle="${ca_labels}"/></th></tr>
		<tr>
				<td class='label'  ><fmt:message key="eCA.SectionStartsWith.label" bundle="${ca_labels}"/></td>
				<td class='fields' ><input type='text' name='searchtext' id='searchtext' size='20' maxlength='20' value="" OnKeyPress ="return CheckForSpecChars(event)"></input><img src="../../eCommon/images/mandatory.gif"></img></td><td align=right><input type='button' name='search' id='search' class='Button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' OnClick="SearchCriteria()"> </input>
		</tr>
	</table>
	<!-- added by arvind @ 06-12-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->
	
	</form>
</body>
</html>


