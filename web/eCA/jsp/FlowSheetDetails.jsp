<!DOCTYPE html>
<!--
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------		
18/01/2016	IN058886		Karthi L										Search,Clear and More Criteria buttons are truncated in View Clinical Event History Screen.
12/10/2016	IN047572		Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ‘View Clinical Notes’ and ‘Clinical Event History’
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
---------------------------------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<script language='javascript'>
function getMessageFrame()
{
	if(top.content!=null && !top.document.getElementById('dialog-body')){
		return top.content.messageFrame;
	}else if(parent.parent.messageFrame1){
		return parent.parent.messageFrame1;	
	}
	else{
		return parent.parent.messageFrame;
	}
}
	var messageFrameReference = getMessageFrame();
	function removeObjectsFromSession()
		{
		  if(messageFrameReference!=null)
			{
				messageFrameReference.location.href="../../eCA/jsp/FlowSheetEventsRemoveObjects.jsp";
			}
		}
</script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</HEAD>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
	String graphorder = request.getParameter("graphorder")==null?"D":request.getParameter("graphorder");
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561

	String rows="";
	if(called_from.equals("OR")){
		rows="*,6%";	
	}else{
		rows="18%,*";
	}
%>

<div id="frameContainer" style="display: flex; flex-direction: column; height: 100vh;">
  <div style="flex: 1; display: flex; flex-direction: row; height: 70vh;">
    <iframe src="../../eCommon/html/blank.html" name="unitFrame" style="width: 30vw; border: none;"></iframe>
    <iframe src="../../eCommon/html/blank.html" name="dataFrame" style="flex: 1; border: none; overflow-y: auto;"></iframe>
    <iframe src="../../eCommon/html/blank.html" name="manageEmailFrame" style="width: 0%; border: none;"></iframe>
  </div>
  <iframe src="../../eCA/jsp/FlowSheetControls.jsp?<%=request.getQueryString()%>&graphorder=<%=graphorder%>" name="controlsFrame" style="width: 100vw; height: 13vh; border: none;"></iframe>
</div>
</HTML>
 <script>
  if (top.content != null) {
    document.getElementById('dataFrame').style.height = '75vh';
    document.getElementById('controlsFrame').style.height = '13vh';
  } else {
    document.getElementById('dataFrame').style.height = '75vh';
    document.getElementById('controlsFrame').style.height = '13vh';
  }
</script>
	<%-- <FRAMESET ROWS="*,13%" id='myFrameSetControls' FRAMEBORDER=NO onUnload='removeObjectsFromSession()'>
<FRAMESET COLS="30%,*,0%" FRAMEBORDER=0 marginheight=1 marginwidth=1 BORDERCOLOR = '#000000'>
	<FRAME SRC="../../eCommon/html/blank.html" name='unitFrame' FRAMEBORDER=NO scrolling=NO noresize>
	<FRAME SRC="../../eCommon/html/blank.html" name='dataFrame' FRAMEBORDER=NO scrolling=yes noresize>
	<frame src="../../eCommon/html/blank.html" name="manageEmailFrame"  frameborder="0" noresize> 
</FRAMESET>
	<FRAME SRC="../../eCA/jsp/FlowSheetControls.jsp?<%=request.getQueryString()%>&graphorder=<%=graphorder%>" name='controlsFrame' FRAMESPACING=NO FRAMEBORDER=NO scrolling=no>  
<%if(!called_from.equals("OR")){%>
	</FRAMESET>
<%}%> --%>
<!-- <script>
	if(top.content != null) 
	{
		/** Modified by Kishore Kumar N on 05/12/2008 for CRF0387
			modified the frameset width.		
		*/
		myFrameSetControls.rows = '*,13%';
	}
	else
	{	
		parent.myFrameSet.rows = "26%,*"; //Modified from 21 to 24 for IN058886 -- // modified from 24 to 26 for MMS-QH-CRF-0177 [IN047572] 
		myFrameSetControls.rows = '*,13%';
	}
</script>
 -->
 