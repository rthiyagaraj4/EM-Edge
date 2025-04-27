<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../js/ReferralPatListResult.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>

<STYLE TYPE="text/css">
A:link {
	COLOR: white;
}

A:visited {
	COLOR:white ;
}
A:active {
	COLOR: white;
}
</STYLE>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);

	String queryString  = request.getQueryString();
	String allowSecondLevel = request.getParameter("allowSecondLevel");

	if(allowSecondLevel == null || allowSecondLevel.equals(""))
		allowSecondLevel="";

	String locationType  = request.getParameter("locationType");
	
	if(locationType == null || locationType =="") 
		locationType="";
	
	String classArray[] = new String[4];
	
	HashSet patClassSet = PatSearch.getFirstLevel();

	int j=0;
	
	if(patClassSet!=null && patClassSet.size()>0)
	{
		Iterator itr = patClassSet.iterator();

		while(itr.hasNext())
		{
			classArray[j] = (String)itr.next();
			j++;
		}
	}

	patClassSet = null;

	if(classArray[0]==null )
	{
%>
		<script language=javascript>

			if(top.content.workAreaFrame.PatResultFr.LocnResult.location != null)
			{
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	}
%>
<script>
	function callLevelTwo(obj)
	{
		if('<%=allowSecondLevel%>' == "Y")
		{
			var url = '<%=queryString%>&pat_type='+obj;
			var count = url.indexOf("&pat_type=");
			url = url.substring(0,count);
			url = url+'&pat_type='+obj;

			top.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href='../../eCA/jsp/ReferralPatListPatLocn.jsp?'+url;
		}
		else if('<%=allowSecondLevel%>' == "N")
		{
			var url = '<%=queryString%>&locn_type='+obj;
			top.content.workAreaFrame.PatResultFr.LocnResult.location.href='../../eCA/jsp/ReferralPatListResult.jsp?'+url;
		}

		//if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href.indexOf(".jsp") != -1)
		  // top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href='../../eCommon/html/blank.html';
	}
</script>
	<body class ='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
       <form name="formLocnResultPatClass" id="formLocnResultPatClass">
           <table border='0' cellpadding='0' cellspacing='0' class='' id="tab" width="50%">
           <tr>
<%
				String classValue="";
				for(int i=0;i<classArray.length;i++)
				{
					if(i==0)  classValue="FIRSTSELECTED";
					else classValue="FIRSTNORMAL";
			
					if(classArray[i]!=null)
					{
%>
						<td class='<%=classValue%>'  align="center" onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);'style='cursor:pointer;' onclick="display(this);callLevelTwo('<%=classArray[i]%>');" >
						<a href="javascript:callLevelTwo('<%=classArray[i]%>');"> <%=getPatientClassName(classArray[i],pageContext)%></a></td>
<%                   }
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
        if(classArray[0]!=null)
		{
            pat_type = classArray[0];
            if(!allowSecondLevel.equals(""))
			{
%>
				<script>
				 	top.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href='../../eCA/jsp/ReferralPatListPatLocn.jsp?<%=queryString%>&pat_type=<%=pat_type%>';
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
            }
            return null;
        }
%>

