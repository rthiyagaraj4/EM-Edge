<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created

08/11/2011	  IN29177		 Dinesh T	 Changed for the thai language support
28/02/2013	  IN038075		 Nijitha S	 Alpha-CA-Chart Summary->System is displaying Internal Server error for the 									 Recorded Vital Sign with special character '%'
20/10/2015		IN057138			Karthi L	Chief Complaint ( Long Text ) which has been recorded  from the Manage Patient Queue vital battery
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
16/01/2019		IN068560			Raja S			16/01/2019		Ramesh G		ML-MMOH-SCF-1078
02/09/2021	14801				Ramesh 											SKR-SCF-1578	
---------------------------------------------------------------------------------------------------------
-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />  
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	function doClose()
	{
		window.close();
	}	
</script>
<%
	try{
		String resComments	= request.getParameter("resultStr") == null?"":request.getParameter("resultStr");
		//resComments = java.net.URLDecoder.decode(resComments); //ML-BRU-SCF-1642 - IN057138 //14801
		String modal_title	= request.getParameter("modal_title");
		if(resComments.indexOf("<BR>")!=-1)//IN068560
					resComments = resComments.replaceAll("<BR>","\r\n");//IN068560
		// commented below line for - ML-BRU-SCF-1642 - IN057138- Start
		/*if( resComments == null) 
			resComments="";
		else
		{
			if(resComments.indexOf("~")!=-1)
					resComments = resComments.replaceAll("~","\r\n");			
			if(resComments.indexOf("`")!=-1)
					resComments = resComments.replaceAll("`","'");			
			if(resComments.indexOf("|")!=-1)
					resComments = resComments.replaceAll("|","\"");			
			if(resComments.indexOf("&amp;")!=-1)	
				resComments = resComments.replaceAll("&amp;","&");	
			/*while(resComments.indexOf("~")!=-1)
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
		// commented below line for - ML-BRU-SCF-1642 - End
		if( modal_title == null) 
			modal_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Result.label","common_labels");
%>
<title><%=modal_title%></title>
</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<center>
	<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>
		<tr><td>
			<table width='50%' border='0' cellspacing='0' cellpadding='3' align=center>
				<tr>
					<td colspan=2></td>
				</tr>
				<tr>
					<!--<td class='fields'><textarea name="comments" rows="17" cols="54" readOnly><%//=java.net.URLDecoder.decode(resComments)%></textarea></td>--><!--IN29177,[IN038075]-->
					<td class='fields'><textarea name="comments" rows="17" cols="54" readOnly><%=resComments%></textarea></td><!--IN038075-->
					
				</tr>
				<tr>
					<td colspan=2></td>
				</tr>
				<tr>
					<td align='right'><input type='Button' class='Button' name='Ok' id='Ok' value='   <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>   ' onclick='doClose()'></td>
				</tr>
				<tr>
					<td colspan=2></td>
				</tr>
			</table>
		</td></tr>
	</table>
</center>
</body>
	<%
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	%>
</html>

