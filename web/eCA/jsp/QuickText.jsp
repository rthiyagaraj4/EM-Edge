<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/11/2015	IN057138		Karthi L										Chief Complaint ( Long Text ) which has been recorded  from the Manage Patient ...
11/05/2017	IN064071		Krishna Gowtham		11/05/2017		Ramesh G 	Alpha - CA-Clinical Event History-Flow sheet View-System does not display the 
																			Result Comments properly.
06/06/2018	IN067806		Raja S			06/06/2018		Ramesh G		MO-CRF-20144																	
06/06/2018	IN67889		Dinesh T			06/06/2018		Ramesh G	Transfer Date and Time is not displaying in flowchart --> Result / Remarks Webpage Dialog																			
21/01/2019	IN069434		Raja S			21/01/2019		Ramesh G		ML-MMOH-SCF-1128
-----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html> 
<head>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function doClose()
{
	window.close();
}

function loadInit(locale)
{
	var resComments = window.dialogArguments;
	
	resComments = unescape(resComments); //ML-BRU-SCF-1642 - IN057138
	//IN064071 Start
	resComments = resComments.replace( /\+/g, ' ' );
	resComments = resComments.replace("%20"," ");
	resComments = resComments.replace("%7E","~");
	resComments = resComments.replace("%3A",":");
	//IN064071 End
	//IN067806 added from below
	while(resComments.indexOf("&#126")!=-1) 
		resComments = resComments.replace("&#126","~");
	//IN067806 added from below
	while(resComments.indexOf("~ ")!=-1)
		resComments = resComments.replace("~ ","\r\n");
	/*while(resComments.indexOf("`")!=-1)
		resComments = resComments.replace("`","'");*/
	while(resComments.indexOf("|")!=-1)
		resComments = resComments.replace("|","\"");
	while(resComments.indexOf("&#92")!=-1) //ML-BRU-SCF-1642 - IN057138 Start
		resComments = resComments.replace("&#92","\\");
	while(resComments.indexOf("&#124")!=-1) 
		resComments = resComments.replace("&#124","|");
	while(resComments.indexOf("&#39")!=-1) 
		resComments = resComments.replace("&#39","'");
	while(resComments.indexOf("&#96")!=-1) 
		resComments = resComments.replace("&#96","`");
	//IN067806 commented here
	/*
	while(resComments.indexOf("&#126")!=-1) 
		resComments = resComments.replace("&#126","~");
	*/
	//IN067806 Commented here added to top
	while(resComments.indexOf("\\\"")!=-1) 
		resComments = resComments.replace("\\\"","\"");		
	while(resComments.indexOf("&#43")!=-1) 
		resComments = resComments.replace("&#43","+");	 //ML-BRU-SCF-1642 - IN057138 End
			
	var arr=new Array();
	var temp;
	var tempData = "";	
	var displaydtls = "";	
	arr=resComments.split(",");
	
	for(var index = 0; index < arr.length;index++){
		if(arr[index].indexOf("Transferred Date")!= -1)//IN67889, starts
		{
			temp = arr[index].substring(18,arr[index].length);
			temp = convertDate(temp,'DMYHM','en',locale);
			temp = " Transferred Date : "+temp;
			tempData += temp + ",";			
		}//IN67889, ends
		/* //commented for IN069434
		else if(arr[index].indexOf("Date")!= -1)
		{
			temp = arr[index].substring(7,arr[index].length);
			temp = convertDate(temp,'DMYHM','en',locale);
			temp = " Date : "+temp;
			tempData += temp + ",";		
		}//commented for IN069434
		*/		
		else
		{
			if(tempData != null || tempData != "")
			tempData += arr[index]+ ",";
		}
	}
	//Below line is added by Archana Dhal on 11/24/2010 related to IN025200.
	displaydtls = tempData.substring(0,tempData.length-1);

	
	document.forms[0].comments.value = displaydtls;	
	document.forms[0].comments.focus();
}


</script>
<%
	/*String resComments	= request.getParameter("resultStr");
	
	if( resComments == null) resComments="";
	else
	{
		while(resComments.indexOf("~")!=-1)
		{	
			int a=resComments.indexOf("~");
			StringBuffer temp=new StringBuffer(resComments);
			temp.replace(a,a+1,"\r\n");
			resComments=temp.toString();
		}
		while(resComments.indexOf("`")!=-1)
		{	
			int a=resComments.indexOf("`");
			StringBuffer temp=new StringBuffer(resComments);
			temp.replace(a,a+1,"'");
			resComments=temp.toString();
		}
		while(resComments.indexOf("|")!=-1)
		{	
			int a=resComments.indexOf("|");
			StringBuffer temp=new StringBuffer(resComments);
			temp.replace(a,a+1,"\"");
			resComments=temp.toString();
		}	
	}*/
%>
<title><fmt:message key="eCA.ResultRemarks.label" bundle="${ca_labels}"/></title>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload='loadInit("<%=locale%>")'>
<form>
<center>
	<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr><td>
	<table width='50%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr><td align='left'>&nbsp;</td></tr>
	<tr>
		<td align='center'><textarea name="comments" rows="12" cols="50" readOnly></textarea></td>
	</tr>
	<tr><td align='left'>&nbsp;</td></tr>
	<tr><td align='right'><input type='Button' class='Button' name='Ok' id='Ok' value='    Ok    ' onclick='doClose()'></td></tr>
	<tr><td align='left'>&nbsp;</td></tr>
</table></td></tr></table>
</center>
</form>
</body>
</html>

