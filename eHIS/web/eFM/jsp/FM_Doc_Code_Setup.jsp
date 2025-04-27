<!DOCTYPE html>
<!--

	Created On	: 24/8/2004
	Created By	: Kiran K K.
	Module		: File Management (FM)
	Function	: Document Code Setup
	
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById("t").rows[prev].cells[0].className=prevcol;
				prevcol=ro.cells[0].className;
				ro.cells[0].className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
			if(val == 'DocumentType')
				parent.frames[1].location.href = '../../eFM/jsp/FMDocumentType.jsp?module_id=FM&function_id=DOC_TYPE&function_name='+encodeURIComponent(getLabel('Common.documenttype.label','Common'))+'&function_type=F&access=YYYNY';
			if(val == 'DocumentFolder')
				parent.frames[1].location.href = '../../eFM/jsp/FMDocumentFolder.jsp?module_id=FM&function_id=DT_DOC_FOLDER&function_name='+encodeURIComponent(getLabel('eFM.DocumentFolder.label','FM'))+'&function_type=F&access=YYYNY';
			if(val == 'DocumentTypeInFolder')
				parent.frames[1].location.href = '../../eFM/jsp/FMDocumentTypeInFolder.jsp?module_id=FM&function_id=DT_DOC_TYPE_FOLDER&function_name='+encodeURIComponent(getLabel('eFM.DocumentTypeinFolder.label','FM'))+'&function_type=F&access=YYNNY';
			if(val == 'DocumentFolderInFSLocn')
				parent.frames[1].location.href = '../../eFM/jsp/DTFolderInFSLocn.jsp?module_id=FM&function_id=DT_FOLDER_FSLOCATION&function_name='+encodeURIComponent(getLabel('eFM.DocumentFolderInFSLocn.label','FM'))+'&function_type=F&access=YYNNY';			
			
		}

	</script>

	</head>

	<body style="background-color:dimgray;" onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
		

		<tr onclick='chcol(this)'>
		<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DocumentType') class='MENUSUBLEVELLINK'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DocumentFolder') class='MENUSUBLEVELLINK'><fmt:message key="eFM.DocumentFolder.label" bundle="${fm_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DocumentTypeInFolder') class='MENUSUBLEVELLINK'><fmt:message key="eFM.DocumentTypeinFolder.label" bundle="${fm_labels}"/></td>
		</tr>		
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DocumentFolderInFSLocn') class='MENUSUBLEVELLINK'><fmt:message key="eFM.DocumentFolderInFSLocn.label" bundle="${fm_labels}"/></td>
		</tr>


<!-- 		<tr><td class="BLANK_ROW">&nbsp;</td></tr> -->

<!-- 		<tr>
			<td class='MENUHIGHERLEVELCOLOR' onClick=javascript:goHomePage() class='MENUHIGHERLEVELLINK'><b>HOME</b></td>
		</tr>
 -->
			 <tr>
				 <td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.home.label" bundle="${common_labels}"/></b></a></td>
			 </tr>
	</table>

	</body>
	</form>
</html>

