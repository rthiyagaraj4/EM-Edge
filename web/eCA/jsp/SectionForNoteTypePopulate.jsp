<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.SectionforNoteType.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		// added by Arvind @  06-12-08 

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<Script src ='../../eCommon/js/CommonLookup.js'></Script>
		
		<script language='javascript' src='../../eCA/js/SectionForNoteType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'secForNoteTypeValuesForm' id = 'secForNoteTypeValuesForm'>
			<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<tr>
					<td class='label'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
					<td class='fields' ><input type='text' name='note_type_txt' id='note_type_txt' value='' OnKeyPress='return CheckForSpeChar(event)' OnBlur ='getNoteCode(this)' OnChange='resetValues();setValue()' ><input type="button" value="?"  class="button" name='notetype_srch' id='notetype_srch' OnClick='resetValues();getNoteCode(this)'><input type ="hidden" name ="note_type" ><input type='hidden' name='flag' id='flag' value='true'><img src="../../eCommon/images/mandatory.gif"></img>
				</td>
				<td align='right' colspan ='2'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick="loadFrames();"></td>
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

