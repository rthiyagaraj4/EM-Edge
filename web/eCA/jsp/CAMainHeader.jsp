<!DOCTYPE html>

<%@ page import="java.text.*,java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../js/CAMenu.js' language='javascript'></script>
<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
<script src='../../eCA/js/CAMainMenuLookup.js' language='javascript'></script>
<jsp:useBean id="keyGen" scope="page" class="eCA._ca_license_rights">
</jsp:useBean>
<script>

function displaydatetime()
{
	//var x = new Array(getLabel("Common.sun.label",'COMMON'), getLabel("Common.mon.label",'COMMON'),getLabel("Common.tue.label",'COMMON'));
	//x = x.concat(getLabel("Common.wed.label",'COMMON'),getLabel("Common.thu.label",'COMMON'), getLabel("Common.fri.label",'COMMON'));
	//x = x.concat(getLabel("Common.sat.label",'COMMON'));

	var date = new Date();
	var hr = date.getHours(); if ( hr >= 0 && hr <= 9) hr='0'+ hr ;
	var min = date.getMinutes(); if ( min >= 0 && min <= 9) min='0'+ min ;
	
	//var day = date.getDay();
	//var currdatetime = x[day]+' '+date.getDate()+'/'+((date.getMonth())+1)+'/'+date.getYear()+' '+hr+':'+min;
	
	var date1 = date.getDate(); if ( date1 >= 0 && date1 <= 9) date1='0'+ date1 ;
	var month = date.getMonth()+1; if ( month >= 0 && month <= 9) month='0'+ month ;

	var currdatetime = date1+'/'+month+'/'+date.getYear()+' '+hr+':'+min

	if (document.getElementById("datetime"))
	   document.getElementById("datetime").innerText= currdatetime;
}
window.setInterval("displaydatetime()", "60000");

function MM_preloadImages() { 
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { 
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { 
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() {
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

</script>

</head>
<body class="HEADER" onKeyDown="lockKey()" onMouseDown="CodeArrest()" onload="MM_preloadImages('../../eCA/images/MI_Switch2.gif','../../eCA/images/MI_Logout2.gif','../../eCA/images/MI_Close2.gif')">
<form name='CAMainHeaderForm' id='CAMainHeaderForm'>
<%
//	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
//	String locale = request.getParameter("LOCALE") == null ? "" : request.getParameter("LOCALE");

	String jdbc_user = (String) session.getValue( "login_user" ) ;
	String facility_name =(String) session.getValue( "facility_name" ) ;
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String child_window = request.getParameter("child_window")==null?"":request.getParameter("child_window");
	String episode_id = request.getParameter("episode_id");
 	String visit_id = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
	String wname = patient_id+episode_id+visit_id;
	String strRelnYn		= request.getParameter("RelnYn")==null?"Y":request.getParameter("RelnYn");
	String queryStringForChart		=	request.getQueryString() == null ? "" : request.getQueryString();
	String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
	//out.println("<script>alert('lookupFileName"+lookupFileName+"');</script>");
	String limit_function_id = request.getParameter("limit_function_id")==null?"":request.getParameter("limit_function_id");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String from_service_yn = request.getParameter("from_service_yn")==null?"N":request.getParameter("from_service_yn");
//	String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
//	String queryString = request.getQueryString()== null?"":request.getQueryString() ;
	if(from_service_yn.equals(""))
		from_service_yn="N";

	String altText = "Close Chart";
	
//	StringBuffer detl_sql = new StringBuffer();
	boolean pat_sel = false ;
	if( patient_id!=null || episode_id != null )
		pat_sel = true;
	if(patient_id == null) patient_id="";
	if(episode_id == null) episode_id="";

//	String respid =session.getValue("responsibility_id")==null?"":(String) session.getValue("responsibility_id");
	
//	String facilityid = session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	//relationcode = (String)session.getValue("relationship_id");
	
//	String relationcode = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	
		
	Connection con = null;
	PreparedStatement pstmt = null,stmt = null;
	ResultSet rs = null,rset = null;
	
	try
	{
		con = ConnectionManager.getConnection(request);

	
	String site = "" ;
	stmt = con.prepareStatement("SELECT SITE_NAME FROM SM_SITE_PARAM WHERE 'Y' = (SELECT DISPLAY_SITE_NAME_YN FROM SM_FACILITY_PARAM WHERE FACILITY_ID = '"+(String) session.getAttribute( "facility_id" )+"')");
	rset = stmt.executeQuery();
	if(rset != null)
	{
		if(rset.next())
		{
			site = "<br>"+rset.getString("SITE_NAME");
		}
	}
	
%>
<script>
function closeFunction(childyn,wname,flag)
{
	top.content.messageFrame.document.write("<html><body onKeyDown='lockKey()'><form name='openChartWrapperIntermediateForm' id='openChartWrapperIntermediateForm' method='post' action='../../eCA/jsp/OpenChartWrapperIntermediate.jsp?queryStringForChart=<%=queryStringForChart%>'><input type='hidden' name='patientID' id='patientID' value='<%=patient_id%>'><input type='hidden' name='episodeID' id='episodeID' value='<%=episode_id%>'><input type='hidden' name='child_window' id='child_window' value='<%=child_window%>'><input type='hidden' name='FromPatChart' id='FromPatChart' value=''><input type='hidden' name='FromCloseOrSwitch' id='FromCloseOrSwitch' value='Close'><input type='hidden' name='windName' id='windName' value='"+wname+"'><input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'></form></body></html>");
	top.content.messageFrame.openChartWrapperIntermediateForm.submit();
}

function ShowPats(FromPatChart)
{
	top.content.messageFrame.document.write("<html><body onKeyDown='lockKey()'><form name='openChartWrapperIntermediateForm' id='openChartWrapperIntermediateForm' method='post' action='../../eCA/jsp/OpenChartWrapperIntermediate.jsp?queryStringForChart=<%=queryStringForChart%>'><input type='hidden' name='patientID' id='patientID' value='<%=patient_id%>'><input type='hidden' name='episodeID' id='episodeID' value='<%=episode_id%>'><input type='hidden' name='FromPatChart' id='FromPatChart' value='"+FromPatChart+"'><input type='hidden' name='FromCloseOrSwitch' id='FromCloseOrSwitch' value='Switch'><input type='hidden' name='RelnYn' id='RelnYn' value='<%=strRelnYn%>'></form></body></html>");
	top.content.messageFrame.openChartWrapperIntermediateForm.submit();
}

</script>
<%
	if(patient_id.equals(""))
	{
%>
	<table width="100%" border="1" cellpadding=0 cellspacing=0>
	<tr>
	<td width='100%' align="left" class="HEADERTITLE">
	&nbsp;<img src="../../eCommon/images/ielogo.gif" height="10" ></img> <font size="2">eHospital Information System - Microsoft Internet Explorer </font>
	</td>
	</tr>
	</table>
<%
	}
	else
	{
%>
		<script>
			parent.workArea.rows = "6%,*,0%";
		</script>
<%
	}
%>
<table width="100%" cellpadding=0 cellspacing=0>
<tr class="HEADER">
	<td class="HEADER" align="center" valign="top" width="5%">
		<img src="../../eCommon/images/orgLogo.gif" vspace=0 hspace=0>
	</td>

	<td class="HEADER" align="left" valign="top" width="35%">
	<b><font size="-1"><%=facility_name%> <%=site%>
	</font></b>
	</td>

	<td class="HEADER" align="left" valign="top" width="15%">
	&nbsp;&nbsp;&nbsp;&nbsp;<b><font size="-1">
	<%= jdbc_user %>
	<!--</font>
	</b>
	</td>

	<td class="HEADER" align="left" valign="top" width="15%">
	<font size="-1">
	<b> -->

    <!-- added date/time -->
	<div id="datetime" style="font-size: 80%; text-align: left; padding: 2px" value=""></div>
	<script>
	displaydatetime();
	</script>
    <!-- end- added date/time -->

	
	</font></b>
	
	</td>
	
	<td class="HEADER" align="right" valign="top" width="30%">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
	<td class="HEADER" align="right">
		<%if((eCA._ca_license_rights.getKey()).equals("CACLDC")  || (eCA._ca_license_rights.getKey()).equals("CABASIC"))
		{	
			if(lookupFileName.equals("") && from_service_yn.equals("N")&& limit_function_id.equals("")){%>
				<img onclick="ShowPats()" src='../../eCA/images/MI_Switch1.gif' alt='Switch' id='switch' name='switch' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('switch','','../../eCA/images/MI_Switch2.gif',1)"></img>
		<%	}
		}%>
		<%
			if(!lookupFileName.equals(""))
			{%>
				<img src='../../eCA/images/MI_Switch1.gif' onclick='getParentWindow()' alt='Patient Chart' id='pc' name='pc' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('pc','','../../eCA/images/MI_Switch2.gif',1)"></img>
		<%	}%>
		
		<img src='../../eCA/images/MI_Logout1.gif'  onclick="logOff('<%=patient_id%>')" alt='Logout' id='logout' name='logout' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('logout','','../../eCA/images/MI_Logout2.gif',1)"></img>
		
	<%
		if(!child_window.equals("Y"))
		{
			altText = "Close";
		}
		if(lookupFileName.equals("")){%>
			<img src='../../eCA/images/MI_Close1.gif' onclick="closeFunction('<%=child_window%>','<%=wname%>','Y')" alt='<%=altText%>' id='close' name='close' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('close','','../../eCA/images/MI_Close2.gif',1)"></img>

		<%}%>
		<%
			if(!lookupFileName.equals(""))
			{%>
				<img src='../../eCA/images/MI_Close1.gif' onclick='hideLookupButton()' alt='<%=altText%>' id='cc' name='cc' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('cc','','../../eCA/images/MI_Close2.gif',1)"></img>
		<%	}
		%>
		&nbsp;&nbsp;</td>
		</tr>
		</table>
	</td>
	<td class="HEADER" align="center" valign="top" width="5%">
		<img src="../../eCommon/images/product_small.gif" alt="IBA Health">
	</td>
</tr>
</table>
</form>
</body>


<%	
	if(rs!= null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(rset!= null)	rset.close();	
	if(stmt != null)	stmt.close();
} 
	catch (Exception e)
	{
		//out.println("Exception in CAMainHeader.jsp"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally 
	{
		if(con != null) ConnectionManager.returnConnection(con, request);
	}
	
%>



