<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?       created
12/02/2013		CHL_CRF		Nijitha		CHL_CRF - File Added and Changes as part of Default and Personlised themes to be applied for All widgets		
26/03/2013	   IN038959		Nijitha		REGRESSION-CRF-CA- CHL-CRF- 0008 /12- Chart Summary->Some icons in the Widget are not displayed								 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page  
contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<HTML>
<HEAD>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<TITLE>Personalize Themes</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<%


Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
StringBuilder personaliseThemeQuery = new StringBuilder();
StringBuilder totalStyleSheetQuery = new StringBuilder();
//ArrayList positionsList = new ArrayList();	//Checkstyle 4.0 Beta 6
//int temp =0,tempRowId=0,totalRows = 0, tempExists = 0,totalCols=0;	//Checkstyle 4.0 Beta 6
//float widthPerCell=0,heightPerCell=0;	//Checkstyle 4.0 Beta 6
String contentID = request.getParameter("contentID");
String summaryId = request.getParameter("summaryId");
String patientClass = request.getParameter("patClass");
String practitioner = request.getParameter("practitioner");
String speciality =request.getParameter("speciality");
//String titleContent =request.getParameter("titleContent");	//Checkstyle 4.0 Beta 6
//String totalCount =request.getParameter("totalCount");	//Checkstyle 4.0 Beta 6

//String summaryDesc = request.getParameter("summaryDesc");//Checkstyle 4.0 Beta 6
String styleSheetNameOld = request.getParameter("styleSheetName");
//personaliseThemeQuery.append("select SRL_NO,STYLE_SHEET,STYLE_SHEET_NAME,STYLE_SHEET_IMAGE from CA_WIDGET_STYLE_SHEET where content_id = ?");
//personaliseThemeQuery.append("SELECT WSH.STYLE_SHEET_ID,CSCN.CONTENT_ID,WSH.STYLE_SHEET,WSH.STYLE_SHEET_NAME,WSH.STYLE_SHEET_IMAGE FROM CA_CHART_SUMM_CONTENT CSCN,CA_WIDGET_STYLE_SHEET WSH WHERE WSH.content_id = cscn.content_id AND WSH.content_id = ?");
personaliseThemeQuery.append("SELECT WSH.STYLE_SHEET_ID,CSCN.CONTENT_ID,WSH.STYLE_SHEET,WSH.STYLE_SHEET_NAME,WSH.STYLE_SHEET_IMAGE FROM CA_CHART_SUMM_CONTENT CSCN,CA_WIDGET_STYLE_SHEET WSH WHERE WSH.content_id = cscn.content_id AND WSH.content_id = ? ORDER BY WSH.STYLE_SHEET_ID ASC");
totalStyleSheetQuery.append("select count(STYLE_SHEET_ID) as style from ca_widget_style_sheet where content_id = ?");
%>
<script>
function setPersonalizedTheme(widgetStyleSheetName,contentID,id,totalStyleSheet)
{
document.getElementsByName("image").className='';

for(var i=1;i<=totalStyleSheet;i++)
{
var className = document.getElementById("image"+i).className;
if(className !="")
 document.getElementById("image"+i).className = '';
}

document.getElementById("image"+id).className='borderOnSelection';

document.getElementsByName("personalizeTheme").value = widgetStyleSheetName;

}

function applytToAll(){

	var contentID = '<%=contentID%>';
	var summaryId = '<%=summaryId%>';
		var patientClass = '<%=patientClass%>';
			var practitioner = '<%=practitioner%>';
				var speciality = '<%=speciality%>';
				var old = '<%=styleSheetNameOld%>';
	var personalizeTheme = document.getElementsByName("personalizeTheme").value;
	
	
	var xmlDoc  = ""; // new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ChartSummaryPersThemeTransaction.jsp?summaryId="+summaryId+"&practitioner="+practitioner+"&patientClass="+patientClass+"&speciality="+speciality+"&personalizeTheme="+personalizeTheme+'&applyToAllWidget=Y',false ) ;
	
	xmlHttp.send( xmlDoc ) ;
	responseText = xmlHttp.responseText ;
    //window.close();
	  const dialogTag = parent.document.getElementById('dialog_tag');    
	  dialogTag.close();   
	
}

function applyTheme(flag){
	//alert("flag");
	var contentID = '<%=contentID%>';
	var summaryId = '<%=summaryId%>';
		var patientClass = '<%=patientClass%>';
			var practitioner = '<%=practitioner%>';
				var speciality = '<%=speciality%>';
				var old = '<%=styleSheetNameOld%>';
				var applyToAllWidget="N";
	var personalizeTheme = document.getElementsByName("personalizeTheme").value;
	if(personalizeTheme==null)
	personalizeTheme = old;
	if("D"==flag)
	personalizeTheme=null;
	if("DY"==flag)
	{
	personalizeTheme=null;
	applyToAllWidget="Y"
	}
	
	var xmlDoc  =""; // new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ChartSummaryPersThemeTransaction.jsp?contentID="+contentID+"&summaryId="+summaryId+"&practitioner="+practitioner+"&patientClass="+patientClass+"&speciality="+speciality+"&personalizeTheme="+personalizeTheme+"&applyToAllWidget="+applyToAllWidget,false ) ;
	
	xmlHttp.send( xmlDoc ) ;
	responseText = xmlHttp.responseText ;
	//alert('132 in ChartSummaryPersonalisedThemes.jsp');
	// window.close();
	// const dialogTag =document.getElementById("chartSummPersTheme");    
    // dialogTag.close();  
	// let dialogBody = parent.parent.document.getElementById('dialog-body');
    // dialogBody.contentWindow.returnValue = retVal;
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 

}
</script>

    <style type="text/css">
	.DIVA{
	margin:5px;
	width:145px;
	height:auto;
	background-color:#ffffff;
	border:1px solid #cdcdcd;
	padding:1px;
	cursor:pointer;
	}
	.DIVB{
	width:auto;
	height:auto;
	background-color:#ffffff;
	border:2px solid #f6f6f6;
	padding-top:2px;
	padding-left:2px;
	padding-right:2px;
	padding-bottom:0px;
	}
	.DIVB:hover
	{
	border:2px solid #3b4247;}
	.borderOnSelection{
	background-repeat: repeat-x;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9pt;
	color: #000000;
	font-weight:normal;
	text-align:left;
	padding-left:5px;
	padding-right:0px;
	vertical-align:top;
	border-left:2px;
	border-right:2px;
	border-top:2px;
	border-bottom:2px;
	border-color:red;
	border-style:solid;
	margin:10;
	border-collapse: collapse;
}
	</style>
</HEAD>

<BODY onKeyDown = 'lockKey()' >
<form name='chartSummPersTheme' id='chartSummPersTheme'>
<%
try{
	int totalStyleSheet = 0;
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(totalStyleSheetQuery.toString());
	pstmt.setString(1,contentID);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
		totalStyleSheet = rs.getInt("style");
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	
	pstmt = con.prepareStatement(personaliseThemeQuery.toString());
	//pstmt.setString(1,summaryId);
	pstmt.setString(1,contentID);
	rs = pstmt.executeQuery();
	
	String content_id = "";
	String styleSheetName ="";
	String styleSheetId = "";
	String themesDisplay = "";
	String className ="";
	int a = 0;
	
	while(rs.next()){
			
			content_id = rs.getString("CONTENT_ID");
			styleSheetName=rs.getString("STYLE_SHEET");
			styleSheetId =	rs.getString("STYLE_SHEET_ID");
			themesDisplay = "<div class='DIVA'><div class='DIVB'><a href='javascript:setPersonalizedTheme(\""+rs.getString("STYLE_SHEET")+"\",\""+rs.getString("CONTENT_ID")+"\",\""+rs.getString("STYLE_SHEET_ID")+"\",\""+totalStyleSheet+"\")' title='Themes' selected>"+"<img  src='../../eCA/images/"+rs.getString("STYLE_SHEET_IMAGE")+"' />"+"</div></div></a>";
			//	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+styleSheetName+"' type='text/css' />");
			//out.println("<a href='javascript:setPersonalizedTheme(\""+rs.getString("STYLE_SHEET")+"\",\""+rs.getString("CONTENT_ID")+"\");' title='Themes'>");
			
			if(null!=styleSheetNameOld && null!=styleSheetName && !"".equals(styleSheetName) && !"".equals(styleSheetNameOld) && styleSheetName.equals(styleSheetNameOld))
			{
				className = "borderOnSelection";
			}
	//	out.println("<img  src='../../eCA/images/"+rs.getString("STYLE_SHEET_IMAGE")+"' onClick='setPersonalizedTheme(\""+rs.getString("STYLE_SHEET")+"\",\""+rs.getString("CONTENT_ID")+"\");'/>");
			//out.println("<table width='100%'><tr><td class='COLUMNHEADERCENTERNEW"+styleSheetId+"'>"+themesDisplay+"</td></tr></table>");
			if(a==0)
			{
				out.println("<table width='70%' cellspacing='7' cellpadding='7'>");
			}
			if(a==0 || a== 5 || a== 10 || a== 15 || a==20)
			{
				out.println("<tr>");
			}	
			out.println("<td id='image"+styleSheetId+"' name='image' class='"+className+"'>"+themesDisplay+"</td>");
			
			if(a==4 || a== 9 || a==14 || a==19)
			{
				out.println("</tr>");
			}		
			//if(a==17)	//IN038959
			if(a==18)	//IN038959
				out.println("</table>");
			//out.println("<table width='100%'><tr><td class='COLUMNHEADERCENTERNEW"+styleSheetId+"'>"+themesDisplay+"</td></tr></table>");
			className="";
			a++;
	}%>
	<!--	<table  border=0 align ='right'>
	<tr>
	<input type='button' name='Apply Default Theme' id='Apply Default Theme' value ='Default Theme'  onClick='applyTheme("D")'/>
	</tr>
	</table>
	 <table  border=0 align ='right'>
		<tr>
		<input type='button' name='Apply Theme' id='Apply Theme' value ='Apply Theme'  onClick='applyTheme()'/>
		
		</tr>
		</table>
		<table  border=0 align ='right'>
		<tr>
		<input type='button' name='ApplyToAllWidgets' id='ApplyToAllWidgets' value ='Apply Theme To All Widgets'  onClick='applytToAll()'/>
		
		</tr>
		</table>
		<table  border=0 align ='right'>
		<tr>
		<input type='button' name='DefaultToAllWidgets' id='DefaultToAllWidgets' value ='Default Theme To All Widgets'  onClick='applyTheme("DY")'/>
		
		</tr>
		</table> --> 
		<div style="text-align: right;">
    <input type='button' name='DefaultToAllWidgets' id='DefaultToAllWidgets' value='Default Theme To All Widgets' onClick='applyTheme("DY")'/>
    <input type='button' name='ApplyToAllWidgets' id='ApplyToAllWidgets' value='Apply Theme To All Widgets' onClick='applytToAll()'/>
    <input type='button' name='Apply Theme' id='Apply Theme' value='Apply Theme' onClick='applyTheme()'/>
	<input type='button' name='Apply Default Theme' id='ApplyDefaultTheme' value='Default Theme' onClick='applyTheme("D")'/>
</div>
		<%
		
		
}catch(Exception e){
	out.println("Error while getting the display Table--Exception in ChartSummaryPersonalisedThemes.jsp: ");
	e.printStackTrace();
}
finally{
	try{
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}catch(Exception e){
		out.println("Exception in ChartSummaryPersonalThemes.jsp: ");
		e.printStackTrace();
	}
}
%>
	

		<input type=hidden name='personalizeTheme' id='personalizeTheme' value="">
		<input type=hidden name='contentID' id='contentID' value="<%=contentID%>">
		<input type=hidden name='patientClass' id='patientClass' value="<%=patientClass%>">
		<input type=hidden name='speciality' id='speciality' value="<%=speciality%>">
		<input type=hidden name='practitioner' id='practitioner' value="<%=practitioner%>">
		
</form>
</BODY>
</HTML>


