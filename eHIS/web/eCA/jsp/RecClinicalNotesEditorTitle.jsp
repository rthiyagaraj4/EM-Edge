<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title></title>

<%
	request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
	<center>
	<form name='RecClinicalNotesEditorTitleForm' id='RecClinicalNotesEditorTitleForm'>
	<%
		String	editor_title	=	"";
		String image_linked_yn = "";
		String disable_bttn = "visibility:none";

		editor_title	=	(request.getParameter("editor_title")==null)	?	""	:	request.getParameter("editor_title");
			
		image_linked_yn	=	(request.getParameter("image_linked_yn")==null)	?	""	:	request.getParameter("image_linked_yn");
		
		if(!(editor_title.equals("")))
		{
			if(editor_title.equals("Notes View"))
				disable_bttn = "visibility:hidden";
			
	%>
	<p align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center' style="margin-top: -11px;">
		<tr>
			<td class='ITEMSELECT' width = '35%'>
				<b><%=editor_title%></b>
			</td>
			<%
			if((image_linked_yn.equals("Y")))
			{%>
				<td class='ITEMSELECT' width = '65%' colspan = 3 align ='right'>
	<input type="button" name = "button1" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShowImage.label","ca_labels")%>"onclick = "arrangeView(this)"	style="<%=disable_bttn%>">
					<input type="button" name = "button2" class="button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShowBoth.label","ca_labels")%>" onclick = "arrageForViewingBoth(this)" style="<%=disable_bttn%>" >

	<!--				
	<input type="button" name = "button1" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShowImage.label","ca_labels")%>" onclick = "arrangeView(this)"	style="<%=disable_bttn%>">
					<input type="button" name = "button2" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShowBoth.label","ca_labels")%>" onclick = "arrageForViewingBoth(this)" style="<%=disable_bttn%>" >
					-->
				</td>
			<%}%>
		</tr>
		</table>
	</p>
	<%
		}
	%>
	</form>
	</center>
</body>
</html>

