<!DOCTYPE html>

<!--

	Created On	: 6/7/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Code Setup
	
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con			=	null;
	java.sql.Statement stmt	=	null;
	ResultSet	rs			=	null;
	String maintain_doc_or_file = "";
	String mysql				= "SELECT maintain_doc_or_file FROM mp_param";
	try
	{
		con  = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs   =  stmt.executeQuery(mysql);
		if(rs != null && rs.next())
		{
			maintain_doc_or_file = rs.getString("maintain_doc_or_file");
		}
	%>
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
				document.getElementById('t').rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
			if(val == 'FMNarration')
				parent.frames[1].location.href = '../../eFM/jsp/FMNarration.jsp?module_id=FM&function_id=FM_NARRATION&function_name='+encodeURIComponent(getLabel('eFM.Narration.label','FM'))+'&function_type=F&access=YYYNY';
			if(val == 'FMDeficiency')
				parent.frames[1].location.href = '../../eFM/jsp/FMDeficiency.jsp?module_id=FM&function_id=FM_DEFICIENCY&function_name='+encodeURIComponent(getLabel('eFM.Deficiency.label','FM'))+'&function_type=F&access=YYYNY';
			if(val == 'FMFileStorageLocation')
				parent.frames[1].location.href = '../../eFM/jsp/FMFileStorageLocation.jsp?module_id=FM&function_id=FM_FILE_STORAGE_LOCN&function_name='+encodeURIComponent(getLabel('Common.FileStorageLocation.label','common'))+'&function_type=F&access=YYYNY';

			if(val == 'FMRequestMode')
				parent.frames[1].location.href = '../../eFM/jsp/FMRequestMode.jsp?module_id=FM&function_id=FM_REQUEST_MODE&function_name='+encodeURIComponent(getLabel('Common.RequestMode.label','Common'))+'&function_type=F&access=YYYNY';
		/*	if(val == 'FMFileTransportMode')
				parent.frames[1].location.href = '../../eFM/jsp/FMFileTransportMode.jsp?module_id=FM&function_id=FM_FILE_TRANSPORT_MODE&function_name=File Transport Mode&function_type=F&access=YYYNY';*/
			if(val == 'DTFileStorageLocation')
				parent.frames[1].location.href = '../../eFM/jsp/FMFileStorageLocation.jsp?module_id=FM&function_id=FM_FILE_STORAGE_LOCN&function_name='+encodeURIComponent(getLabel('Common.StorageLocation.label','Common'))+'&function_type=F&access=YYYNY';
			if(val == 'FMFileTypeforFSLocnMode')
				parent.frames[1].location.href = '../../eFM/jsp/AddFileTypeforFSLocn.jsp?module_id=FM&function_id=FM_FILE_TYPE_FOR_FSLOCATION&function_name='+encodeURIComponent(getLabel('eFM.FileTypeforFSLocation.label','FM'))+'&function_type=F&access=YYYNY';

			if(val == 'DocumentType')
				parent.frames[1].location.href = '../../eFM/jsp/FMDocumentType.jsp?module_id=FM&function_id=DOC_TYPE&function_name='+encodeURIComponent(getLabel('Common.documenttype.label','common'))+'&function_type=F&access=YYYNY';
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
		<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('FMNarration') class='MENUSUBLEVELLINK'><fmt:message key="eFM.Narration.label" bundle="${fm_labels}"/></td>
		</tr>

	<%
			if(maintain_doc_or_file.equals("F"))
			{
	%>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('FMDeficiency') class='MENUSUBLEVELLINK'><fmt:message key="eFM.Deficiency.label" bundle="${fm_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('FMRequestMode') class='MENUSUBLEVELLINK'><fmt:message key="Common.RequestMode.label" bundle="${common_labels}"/></td>
		</tr>
	
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('FMFileStorageLocation') class='MENUSUBLEVELLINK'><fmt:message key="Common.FileStorageLocation.label" bundle="${common_labels}"/></td>
		</tr>
		
		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('FMFileTransportMode') class='MENUSUBLEVELLINK'>File Transport Mode</td>
		</tr> -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('FMFileTypeforFSLocnMode') class='MENUSUBLEVELLINK'><fmt:message key="eFM.FileTypeforFSLocation.label" bundle="${fm_labels}"/></td>
		</tr> 

	<%		
			}
	%>
 		 <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DocumentType') class='MENUSUBLEVELLINK'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
		</tr> 
	<%
			if(maintain_doc_or_file.equals("D"))
			{
	%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DocumentFolder') class='MENUSUBLEVELLINK'><fmt:message key="eFM.DocumentFolder.label" bundle="${fm_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DocumentTypeInFolder') class='MENUSUBLEVELLINK'><fmt:message key="eFM.DocumentTypeinFolder.label" bundle="${fm_labels}"/></td>
		</tr>		
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DTFileStorageLocation') class='MENUSUBLEVELLINK'><fmt:message key="Common.StorageLocation.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DocumentFolderInFSLocn') class='MENUSUBLEVELLINK'><fmt:message key="eFM.DocumentFolderInFSLocn.label" bundle="${fm_labels}"/></td>
		</tr>
	<%		
			}
	%>

<!-- 		<tr><td class="BLANK_ROW">&nbsp;</td></tr> -->

<!-- 		<tr>
			<td class='MENUHIGHERLEVELCOLOR' onClick=javascript:goHomePage() class='MENUHIGHERLEVELLINK'><b>HOME</b></td>
		</tr>
 -->
			 <tr>
				 <td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
			 </tr>

	</table>
	</form>
	
<%
	if(rs   != null) rs.close();
	if(stmt != null) stmt.close();
	}
		catch(Exception e)
		{
			out.println("Exception e:"+e.toString());
		}
		finally
		{			
			ConnectionManager.returnConnection(con,request);
		}
%>
</body>	
</html>

