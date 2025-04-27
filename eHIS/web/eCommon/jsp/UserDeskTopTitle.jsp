<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*, eCA.CAOpenChartServlet" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

 <head>	
 	
<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<STYLE TYPE="text/css">
	A.imageClass1 
	{
		width:30px;
		height:28px;
		margin-left:0;
		margin-right:0;
		margin-top:0;
		margin-bottom:0;
		padding-left:3px;
		padding-right:3px;
		padding-top:2px;
		padding-bottom:1px;
		border-top:0px;
	}
	A.imageClass2 
	{
		background-color:#FFFFFF;
		width:30px;
		height:28px;
		margin-left:0;
		margin-right:0;
		margin-top:0;
		margin-bottom:0;
		padding-left:2px;
		padding-right:2px;
		padding-top:2px;
		padding-bottom:1px;
		border-left:1px solid;
		border-right:1px solid;
		BORDER-COLOR: #75768B;
	}
	img
	{
		border:0;
	}

	TR.iconBarRow
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBG.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	TR.iconBarRowBlue
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGBlue.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	TR.iconBarRowLime
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGLime.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	TR.iconBarRowOrange
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGOrange.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	TR.iconBarRowViolet
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGViolet.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	IMG.imageClass
	{
		vertical-align: middle;
	}

</STYLE>
      <script src='../js/CAMenu.js' language='javascript'></script>
      <script src='../../eCommon/js/common.js' language='javascript'></script>
	  <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <%
			 
			 String styleMap = "";
			 if(sStyle.equals("IeStyleBlue.css"))
			 {
				styleMap = "Blue";
			 }
			 else if(sStyle.equals("IeStyleLime.css"))
			 {
				styleMap = "Lime";
			 }
			 else if(sStyle.equals("IeStyleOrange.css"))
			 {
				styleMap = "Orange";
			 }
			 else if(sStyle.equals("IeStyleVoilet.css"))
			 {
				styleMap = "Violet";
			 }
			 else
			 {
				styleMap = "";
			 }
			

%>
<script>
function goHomePage() {
	parent.location.reload();
	//parent.menucontent.location.href = "../../eCommon/jsp/UserDesktop.jsp";	
} 

function showMenu(obj) {	
	parent.menucontent.expand();
	if(obj.name == 'ShowMenu') {		
		document.getElementById("ShowMenu").style.display='none';
		document.getElementById("HideMenu").style.display='inline';
	} else {		
		document.getElementById("ShowMenu").style.display='inline';
		document.getElementById("HideMenu").style.display='none';
	}

}
function hotStateImage(obj) {
	obj.className = 'imageClass2';
}

function restorePrevState(obj) {
	obj.className = 'imageClass1';
}
</script>
</head>
  <table width="100%" cellspacing='0' cellpadding='0' border='0'>
        <tr  class='iconBarRow<%=styleMap%>'>		
			<td width='5%'><a href="#" class="imageClass1" ><img align='center' src='../../eCA/images/MI_Show.gif' name='ShowMenu' style='' onclick="showMenu(this);" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' accesskey='M' alt='Show Menu'></img>
			<img align='center' src='../../eCA/images/MI_Hide.gif' name='HideMenu' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)' style='display:none'  onclick="showMenu(this);" accesskey='M' alt='Hide Menu'></img></a>
			<a href="#" class="imageClass1" ><img onclick="goHomePage();" id='searchPatHome' src='../../eCA/images/MI_Home.gif' alt='Home Page' align='center' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'></img></a></td>
		</tr>
    </table>
</html>

