<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");	
		String displayExpand ="display:none";
		String displayCollapse ="display";
	%>
<script>
	
//cols...0%,60px,*,0%


function expandMe()
{
	//alert('cols...'+parent.trFrm.cols);
	
	if(top.content.workArea.cols=='0%,200px,*,0%')
	{
		parent.trFrm.cols='*%,25%'
		//alert('scroll...'+parent.maternitytreeframe.scrolling);
		parent.maternitytreeframe.scrolling='No'
		top.content.workArea.cols='0%,60px,*,0%'
		document.getElementById("moveLeft").style.display='none';
		document.getElementById("moveRight").style.display='inline';
	}
	else
	{	
		parent.trFrm.cols='90%,10%'
		top.content.workArea.cols='0%,200px,*,0%'
		document.getElementById("moveLeft").style.display='inline';
		document.getElementById("moveRight").style.display='none';
	}

}
</script>

</head>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<img src="../../eCommon/images/iGridNextDIS16.gif" id='moveRight' onClick="expandMe();" align="left" style='<%=displayExpand%>' alt='Expand'>
<img src="../../eCommon/images/iGridPreviousDIS16.gif" id='moveLeft' onClick="expandMe();" align="right" style='<%=displayCollapse%>' alt='Collapse' >
<!-- <table border=1 ><tr><td><img src="../../eCommon/images/next.jpg" align="left" ></td></tr></table> -->
<script>
	
	if (top.content.workArea.cols =="0%,60px,*,0%" )
	{ 	
		parent.trFrm.cols='*%,25%'
		parent.maternitytreeframe.scrolling='No'
		//top.content.workArea.cols='0%,60px,*,0%'
		document.getElementById("moveRight").style.display='inline';			
		document.getElementById("moveLeft").style.display='none';		
	}else{
		document.getElementById("moveLeft").style.display='inline';
		document.getElementById("moveRight").style.display='none';
	}
</script>
</html>
