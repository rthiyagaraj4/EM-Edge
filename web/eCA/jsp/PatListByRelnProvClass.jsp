<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<%
	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);
%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString  = request.getQueryString();
	String allowedPatType = request.getParameter("allowedPatType");
	String relationshipCode = request.getParameter("relationshipCode");
	String locn_code = "";
	if(!relationshipCode.equals("ALL"))
		locn_code = relationshipCode;
	
	if(allowedPatType == null || allowedPatType.equals(""))allowedPatType="";

	String allowSecondLevel = request.getParameter("allowSecondLevel");
	if(allowSecondLevel == null || allowSecondLevel.equals(""))allowSecondLevel="";

	String locationType		= request.getParameter("locationType");
	if(locationType == null || locationType =="") locationType="";

		String classArray[] = new String[5];
		HashSet patClassSet =PatSearch.getFirstLevel();

		int j=0;
		if(patClassSet!=null && patClassSet.size()>0){
			Iterator itr = patClassSet.iterator();
			while(itr.hasNext()){
				classArray[j] = (String)itr.next();
				
				j++;
			}
		}	
		
		patClassSet = null;

		if(classArray[0]==null ){	//&& !allowSecondLevel.equals("N")
%>
			<script language=javascript>
					if(top.content.workAreaFrame.PatResultFr.LocnResult.location != null){
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
						}
			</script>
<%}%>

	
<html>
	<head>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCA/js/PatListByRelnProvResult.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
	<link rel="stylesheet" type="text/css" href="../../eCA/html/CAStyle.css"></link>
 -->	
  <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />


 <title><fmt:message key="eCA.ViewPatientListbyPPRelationResult.label" bundle="${ca_labels}"/></title>
	<STYLE TYPE="text/css">
	A:link {
		COLOR: white;
	}
/*
	TD.FIRSTSELECTED
	{
		background-color : #3399CC;
		border-width: thin ;
		border-style: inset;
		BORDER-LEFT-COLOR: #696969;
		BORDER-RIGHT-COLOR: #696969;
		BORDER-TOP-COLOR: #696969;
		BORDER-BOTTOM-COLOR: #696969 ;
		FONT-SIZE: 8pt ;
	}
	TD.FIRSTNORMAL
	{	
		background-color : DARKGRAY;
		border-width: thin ;
		border-style: inset;
		BORDER-LEFT-COLOR: #696969;
		BORDER-RIGHT-COLOR: #696969;
		BORDER-TOP-COLOR: #696969;
		BORDER-BOTTOM-COLOR: #696969 ;
		FONT-SIZE: 8pt ;
	}

	TD.SECONDSELECTED{
		background-color : DARKGRAY;
		border-width: thin ;
		border-style: inset;
		BORDER-LEFT-COLOR: #696969;
		BORDER-RIGHT-COLOR: #696969;
		BORDER-TOP-COLOR: #696969;
		BORDER-BOTTOM-COLOR: #696969 ;
		FONT-SIZE: 8pt ;
	}
	TD.SECONDNORMAL{
		background-color : PALEVIOLETRED;
		border-width: thin ;
		border-style: inset;
		BORDER-LEFT-COLOR: #696969;
		BORDER-RIGHT-COLOR: #696969;
		BORDER-TOP-COLOR: #696969;
		BORDER-BOTTOM-COLOR: #696969 ;
		FONT-SIZE: 8pt ;
	}
*/
	A:visited {
		COLOR:white ;
	}
	A:active {
		COLOR: white;
	}
	</STYLE>

	<script>
	/***********/
	
	/**********/
	function callLevelTwo(obj){
			if('<%=allowSecondLevel%>' == "Y")
			{
				var url = '<%=queryString%>&pat_type='+obj;
				var count = url.indexOf("&pat_type=");
				url = url.substring(0,count);
				//url = '<%=queryString%>&pat_type='+obj;
				url = url+'&pat_type='+obj;
				top.content.workAreaFrame.PatResultFr.RelnResultLocation.location.href='PatListByRelnProvLocn.jsp?'+url;
		}else if('<%=allowSecondLevel%>' == "N"){
			
			var url = '<%=queryString%>&locn_type='+obj+'&locn_code=<%=locn_code%>';
			top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatListByRelnProvResult.jsp?'+url;
			
		}

		if(top.content.workAreaFrame.PatResultFr.RelnResultTitle.location.href.indexOf(".jsp") != -1){
			top.content.workAreaFrame.PatResultFr.RelnResultTitle.location.href='../../eCommon/html/blank.html';
		}
	}



	 
	</script>
<!-- <B><font size='2'></font></B> -->
	</head>
	<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="formRelnResultPatClass" id="formRelnResultPatClass">
			<table border='0' cellpadding='3' cellspacing='0' class='' width="100%" id='tab'>
				<tr>
<%

							String classValue="";
							for(int i=0;i<classArray.length;i++)		{ 
								if(i==0)  classValue="FIRSTSELECTED";
								else classValue="FIRSTNORMAL";
					
								if(classArray[i]!=null){%>
										<td class='<%=classValue%>'   onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);'style='cursor:pointer;'  onclick="displayClass(this);callLevelTwo('<%=classArray[i]%>');" ><a href="javascript:callLevelTwo('<%=classArray[i]%>');"><%=getPatientClassName(classArray[i],pageContext)%></a></td>
<%							}
							 }
%>
						</tr>
						</table>
							<input type="hidden" name="queryString" id="queryString" value="<%=queryString%>">
							<input type="hidden" name="url" id="url" value="">
						</form>
			</body>

<%
	
		String pat_type = "";
		if(classArray[0]!=null){
			pat_type = classArray[0];
			if(!allowSecondLevel.equals("")){%>
		<script>
			top.content.workAreaFrame.PatResultFr.RelnResultLocation.location.href='PatListByRelnProvLocn.jsp?<%=queryString%>&pat_type=<%=pat_type%>';
		</script>
<%
			}
		}
%>
</html>

<%!
		String getPatientClassName(String code,PageContext pgContxt)
		{
			if(code!=null)
			{
              if(code.equals("IP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.inpatient.label","common_labels");
                else if(code.equals("OP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.Outpatient.label","common_labels");
                else if(code.equals("EM"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.emergency.label","common_labels");
                else if(code.equals("DC"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.daycare.label","common_labels");
				else if(code.equals("XT"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.external.label","common_labels");
  
			}
			return null;
		}	
%>

