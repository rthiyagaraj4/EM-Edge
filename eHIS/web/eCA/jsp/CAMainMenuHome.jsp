<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           										created
21/11/2012		IN035912		Nijitha												CHL Hospital suggested that the
																					presentation of the Clinician desktop be changed and more appealing. Keeping the display of information more clear and visible.   								 
06/08/2013		IN036733		Nijitha												Bru-HIMS-CRF-328 	

28/08/2015		IN057229		Vijayakumar K		28/08/2015		Ramesh Goli		Regression-EM-Alpha-Unable to access 
																					CA functions in Desktop as well as in patient Chart.
05/08/2016		IN052053		Ramesh G											AAKH-CRF-0062																					
18/07/2017		IN061885		Raja S			18/07/2017		Ramesh G			ML-MMOH-CRF-0537
08/05/2018		IN066237	   Prakash C 		08/05/2018		Ramesh G			MMS-DM-CRF-0123
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String styleMap = "";
		
		//IN035912 Starts
		Connection			con			=	null;
		PreparedStatement	pstmt		=	null;
		ResultSet			rs			=	null;
		String summDesc	= "";
		String navigDesc = "";
		String specialty_id		= (String)session.getValue("specialty_id");
		String pract_id		= (String)session.getValue("ca_practitioner_id");
		String pract_type_id		= (String)session.getValue("practitioner_type");		
		String facility_id		= (String)session.getValue("facility_id");		//IN036733	
		String autoRefNumber ="600000"; //IN052053
		String selfnotesnumber ="";//IN066237
		boolean 	Self_Notes_flag = false;
		boolean 	outPatient_flag=false; //51215
		String login_user 			= (String) session.getValue( "login_user" ) ;//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]

		try
		{
			con	= ConnectionManager.getConnection();
			 	Self_Notes_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","SELF_NOTE_REFRESH");//IN066237
				outPatient_flag=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION_SDG");  //51215
			//pstmt	=	con.prepareStatement("SELECT ca_get_menu_navig(?,?,?,?) summ_navig FROM DUAL");  //IN036733 - commented
			pstmt	=	con.prepareStatement("SELECT ca_get_menu_navig(?,?,?,?,?) summ_navig FROM DUAL");  //IN036733
			pstmt.setString	(	1,	specialty_id);
			pstmt.setString	(	2,	""	);
			pstmt.setString	(	3,	pract_id );
			pstmt.setString	(	4,	pract_type_id);
			pstmt.setString	(	5,	facility_id);		//IN036733
			
			rs		=	pstmt.executeQuery();
			
			if (rs.next()){
			String str = (String)rs.getString("summ_navig");
			
			String[] temp_ = str.split("~");
			
			summDesc = temp_[0];
			navigDesc = temp_[1];
			}
			//IN052053 Start.
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();			
			//pstmt	=	con.prepareStatement("SELECT (SUM_MENU_AUTO_REF*60)*1000 AUTOREFNUM FROM CA_PARAM");
			pstmt	=	con.prepareStatement("SELECT (SUM_MENU_AUTO_REF*60)*1000 AUTOREFNUM,(SELF_NOTES_AUTO_REF*60)*1000 SELFNOTESNUM FROM CA_PARAM");//IN066237
			rs		=	pstmt.executeQuery();			
			if (rs.next()){
			autoRefNumber = (String)rs.getString("AUTOREFNUM");
			selfnotesnumber = (String)rs.getString("SELFNOTESNUM");//IN066237
			}
			//IN052053 End.
		}catch(Exception e) {
		e.printStackTrace();
		}
		finally{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		//IN035912 Ends
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
	<%
	
	String layout_value=request.getParameter("layoutValue")==null? "" : request.getParameter("layoutValue");	
	String desktop_id = request.getParameter("deskTopID") == null ? "" : request.getParameter("deskTopID");	
	String dfltFunctionId = request.getParameter("dfltFunctionId") == null ? "" : request.getParameter("dfltFunctionId");	
	String menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");
	String screensize = request.getParameter("screensize")==null?"0":request.getParameter("screensize");//IN057229
%>	
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCA/js/CASummaryMenu.js' language='javascript'></script>
	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/CAMenu.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script Language="JavaScript" src="../../eCommon/js/logout.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</script>
	<script>
		//IN052053 Start.
        $(document).ready(function() {
                setInterval(function() {
                        $('#SummaryDtl').load("../../eCA/jsp/CAMainHomePageTree.jsp?desktopID=<%=desktop_id%>").fadeIn("slow");
                }, Number(<%=autoRefNumber %>));
        });
		//IN052053 End.
      //IN066237 starts
		if(<%=Self_Notes_flag%> &&(<%=selfnotesnumber%>!= "" && <%=selfnotesnumber%>!=null)) {
        	myVar = setInterval(function(){ selfNoteAutoRefresh(); }, Number(<%=selfnotesnumber%>));		
		}
      
        function selfNoteAutoRefresh() { 
        	var summ_id="HPC_NT_RVP";
			var deskid='<%=desktop_id%>'
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;	
			xmlStr += "summ_id=\""+ summ_id + "\" " ;		
			xmlStr += "desktopID=\""+ deskid + "\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
			xmlHttp.open( "POST", "CAMainMenuIntermediate.jsp", false ) ;
			xmlHttp.send(xmlDoc ) ;
			responseText=trimString(xmlHttp.responseText);

			var resultStr =responseText.split("|");
			if(responseText!=''){
		
			document.getElementById(resultStr[0]).innerHTML ="&nbsp;&nbsp;&nbsp;&nbsp;"+resultStr[1];						
			}
		}
		//IN066237 ends
		//5125 Start.
		if(<%=outPatient_flag%>) {
        	myVar = setInterval(function(){ outPatientAutoRefresh(); }, Number(300000));		
		}
		function outPatientAutoRefresh() { 
        	var summ_id="HPC_PL_OP";
			var deskid='<%=desktop_id%>'
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;	
			xmlStr += "summ_id=\""+ summ_id + "\" " ;		
			xmlStr += "desktopID=\""+ deskid + "\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
			xmlHttp.open( "POST", "CAMainMenuIntermediate.jsp", false ) ;
			xmlHttp.send(xmlDoc ) ;
			responseText=trimString(xmlHttp.responseText);

			var resultStr =responseText.split("|");
			if(responseText!=''){
				var outResultStr="&nbsp;&nbsp;&nbsp;&nbsp;"+resultStr[1];
				if(resultStr[2]>0 || resultStr[3]>0)
					outResultStr=outResultStr+"&nbsp;<img src='../../eCA/images/bellIcon.png' alt='Patients Waiting for Virtual Consultation'/>";
				document.getElementById('resultStr').innerHTML =outResultStr;
			}
			if(resultStr[2]>0)
				alert("Patient Arrived - A patient has joined the C4C meeting and is currently waiting in the virtual waiting area. Your attention is needed for the scheduled conslultation.");
		}
		//51215 End.
        
</script>
<!-- IN061885 Changes starts -->
<style>
DIV.divslideActive1
{
	 position:absolute;					
	 width:217px;					 	
	 height:21px;					
	background-image:url('../../eCommon/images/Sliding-active.jpg');
	background-repeat: repeat-x;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9pt;
	color: #000000;
	font-weight:bold;
	text-align:left;
	padding-left:5px;
	padding-right:0px;
	vertical-align:top;
	border-left:2px;
	border-right:2px;
	border-top:2px;
	border-bottom:2px;
	border-color:#A2C1C6;
	border-style:solid;
	margin:0;
	border-collapse: collapse;
}
DIV.divslideInActive1
{
	 position:absolute;					
	 width:217px;					 	 
	 height:21px;					
	background-image:url('../../eCommon/images/Sliding-normal.jpg');
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
	border-color:#A2C1C6;
	border-style:solid;
	margin:0;
	border-collapse: collapse;
}
</style>
<!-- IN061885 Changes Ends -->
</head>

<body  class="NavigIconsBorder" OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="setCustLayout('Summary','SummaryDtl','Navigation','Desktop')">
<div id="master" STYLE="position:absolute; left:0; top:0;" >
	<TABLE width="100%" CELLSPACING=0 class="COMMON_TOOLBAR" cellpadding="0" border=1>
	<TR ><TD >
				<!-- Modified by Dharma 16th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start-->
				<!--<IMG style="cursor:pointer" SRC="../../eCommon/images/Logout.gif" BORDER=0 ALT="" align="absmiddle"   TITLE='<fmt:message key="Common.logout.label" bundle="${common_labels}"/>' onclick="imagetoolFunction(1)">-->
				<IMG style="cursor:pointer" SRC="../../eCommon/images/Logout.gif" BORDER=0 ALT="" align="absmiddle"   TITLE='<fmt:message key="Common.logout.label" bundle="${common_labels}"/>' onclick="imagetoolFunction(1,'<%=login_user%>')">
				<!-- Modified by Dharma 16th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End-->
				<IMG style="cursor:pointer" SRC="../../eCommon/images/switch_resp.gif" BORDER=0 ALT="" align="absmiddle" onclick="imagetoolFunction(2)" TITLE='<fmt:message key="Common.switchResponsibility.label" bundle="${common_labels}"/>'>
				<IMG style="cursor:pointer" SRC="../../eCommon/images/personalize02.gif" BORDER=0 ALT="" align="absmiddle"  onclick="imagetoolFunction(3)"  TITLE='<fmt:message key="Common.personalize.label" bundle="${common_labels}"/>'>
			</TD>
		</TR>
	</table>
</div>
<%	
if(!desktop_id.equals("") ){ %>	 
		 <div id="mainDIV" >		
			<div id="Summary" class="divslideActive1" style="top:20px" title='<%=summDesc%>' onclick="slidPanelOnclick(this,'Navigation','SummaryDtl','Desktop')" ><!--Summary IN035912--> <!-- Changed class divslideActive to divslideActive1 IN061885-->
			<%=summDesc%>	<!-- IN035912-->   
			 
		  </div>	
	
		  <div id="SummaryDtl" 
			  style="position:absolute;
					 width:222px;
					 height:400px;           
					 top:40px;
					 left:0px;
					 background:#FFFFFF;
					 overflow:auto;display"> <!-- Changed width 197 to 217 IN061885-->

			<jsp:include page="../../eCA/jsp/CAMainHomePageTree.jsp" flush="true" >
			<jsp:param name="desktopID" value="<%=desktop_id%>" />
			</jsp:include>
			
		  </div>	
		  
				<div id="Navigation" class="divslideActive1"	title='<%=navigDesc%>' style="top: 430px;height: 20px;" onclick="slidPanelOnclick(this,'Summary','Desktop','SummaryDtl')">
				<!--Navigation IN035912-->   <!-- Changed class divslideActive to divslideActive1 IN061885-->
				<%=navigDesc%><!--IN035912-->				 
			  </div>
			  <div id="Desktop" 
				  style="position:absolute;
						 width:222px;
						 height:415px;
						 top:60px;
						 left:0px;
						 background:#FFFFFF;						 
						 overflow:auto;"> <!-- Changed width 197 to 217 IN061885-->
						<!--IN057229 starts-->
						<jsp:include page="../../eCA/jsp/CAMainMenu.jsp" flush="true"> 
							<jsp:param name="dfltFunctionId" value="<%=dfltFunctionId%>" />
							<jsp:param name="menuId" value="<%=menu_id%>" />
							<jsp:param name="screensize" value="<%=screensize%>" /> 
						</jsp:include>	
						<!--IN057229 ends-->				
		  </div>		  
		<% } if(desktop_id.equals("")) {%>	
				
		<div id="mainDIV" >		
			<div id="Summary" class="divslideActive1" style="top:20px;display:none" >			   
			<!--Summary IN035912--> <!-- Changed class divslideActive to divslideActive1 IN061885-->
			<%=summDesc%>	<!-- IN035912-->  
		  </div>		
		  <div id="SummaryDtl" 
			  style="position:absolute;
					 width:222px;
					 height:400px;           
					 top:40px;
					 left:0px;
					 background:#FFFFFF;
					 overflow:auto;display:none"> 		 <!-- Changed width 197 to 217 IN061885-->
			
		  </div>	
		  
				<div id="Navigation" class="divslideActive1"	style="top:430px" >
				<!--Navigation IN035912-->  <!-- Changed class divslideActive to divslideActive1 IN061885-->
				<%=navigDesc%><!--IN035912-->				 
			  </div>
			  <div id="Desktop" 
				  style="position:absolute;
						 width:217px;
						 height:444px;
						 top:40px;
						 left:0px;
						 background:#FFFFFF;
						 
						 overflow:auto;"> <!-- Changed width 197 to 217 IN061885-->
						 <!--IN057229 starts-->
						<jsp:include page="../../eCA/jsp/CAMainMenu.jsp" flush="true"> 
							<jsp:param name="dfltFunctionId" value="<%=dfltFunctionId%>" />
							<jsp:param name="menuId" value="<%=menu_id%>" />
							<jsp:param name="screensize" value="<%=screensize%>" /> 
						</jsp:include>
						<!--IN057229 ends-->
		  </div>		
		  <% } %>

	<div id="persMenuFrm" class="NavigIconsBorder" style="position:absolute;
						 width:217px;
						 height:150px;
						 top:525px;
						 left:0px;
						 background:#FFFFFF;
						 overflow:auto;
						display:none;">		 <!-- Changed width 197 to 217 IN061885-->	
<jsp:include page="../../eCommon/jsp/PersonalizeList.jsp" flush="true"> 
<jsp:param name="persFrom" value="HomeSummary" />
<jsp:param name="called_from" value="CA" />
</jsp:include>
	</div>
 <FORM name='desktopParam' id='desktopParam'>
 <input type=hidden name="layoutValue" id="layoutValue" value="<%=layout_value%>">
 <% if(!desktop_id.equals("") ){ %>
 <input type=hidden name="desktop_id" id="desktop_id" value="<%=desktop_id%>">
 <% } %>
 </FORM>
</body>
</html>

