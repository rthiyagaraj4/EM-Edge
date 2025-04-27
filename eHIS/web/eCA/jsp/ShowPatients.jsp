<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, webbeans.eCommon.*, eCA.CAOpenChartServlet,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="eCA.SwitchOptions.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String childyn = request.getParameter("child_window")==null?"N":request.getParameter("child_window");
%>
    <head>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
        <script>
            function switchWindow(winname)
            {
                window.returnValue = winname;
                window.close()				
//				document.showPatsForm.submit();
            }
        </script>
		<style>
			TD.SWITCHOPTIONS
			{
				color:white;
				FONT-SIZE: 10pt ;
				background-color:#637BBD ;
				FONT-FAMILY: VERDANA ;
			}
		</style>
    </head>
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	<table border=1 cellpadding=0 cellspacing=0 width='100%' height="100%" align=center valign=top BORDERCOLOR=BLACK>
			<tr><td valign=TOP>
				<table border=0 cellpadding=0 cellspacing=1 width='100%' align=center valign=top >
<%
		String patientId = request.getParameter("patientID") == null ? "" : request.getParameter("patientID");
		String episodeId = request.getParameter("episodeID") == null ? "" : request.getParameter("episodeID");
		String visitId = request.getParameter("visitID") == null ? "" : request.getParameter("visitID");
		String queryStringForChart = request.getParameter("queryStringForChart") == null ? "" : request.getParameter("queryStringForChart");
		String windowName = patientId+episodeId+visitId;
   
		if(childyn.equals("Y"))
		{
			out.println("<tr><td class='SWITCHOPTIONS' onclick =\"javascript:switchWindow('CD')\">Clinician Desktop</td></tr>");
		}

		try
		{
		
			HashMap sessMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId());
			ArrayList sessList = (ArrayList) session.getAttribute("sessionList"+session.getId());
			
			HashMap patMap = new HashMap();
			String patString = "";
			String patWindowString = "";
			String patPatIDString = "";
			String patEpisodeString = "";
			String patVisitString = "";
			String patWindowName = "";
			String episodeVisitId = "";
			String patOtherDetails = "";
			String className = "SWITCHOPTIONS";
			int i = 0;

//			Set sessSet = (Set) sessMap.keySet();

			//while(sessIter.hasNext())
			for(i=0;i<sessList.size();i++)
			{
				//patString = (String) sessIter.next();
				patString = (String) sessList.get(i);
				patMap = (HashMap) sessMap.get(patString) == null ? new HashMap() : (HashMap) sessMap.get(patString);
				patWindowString = (String) patMap.get("windowObject"+patString);
				patPatIDString = (String) patMap.get("patientId"+patString);
				patEpisodeString = (String) patMap.get("episodeId"+patString);
				patVisitString = (String) patMap.get("visitId"+patString);
				patOtherDetails = (String) patMap.get("patOtherDetails"+patString);
				
				patOtherDetails		= java.net.URLDecoder.decode(patOtherDetails);

				patWindowName = patPatIDString+patEpisodeString+patVisitString;
				episodeVisitId = ", "+patPatIDString + ", "+patEpisodeString;
				if(!patVisitString.equals(""))
					episodeVisitId = episodeVisitId + "/" + patVisitString;

				if(!patString.equals(windowName))
				{
					out.println("<tr><td class='"+className+"' onclick =\"javascript:switchWindow('"+patWindowName+"')\">"+patOtherDetails+episodeVisitId+"</td></tr>");
				}
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in ShowPatients.jsp --"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
%>
<form name='showPatsForm' id='showPatsForm' action='../../servlet/eCA.CAOpenChartServlet' method='post'>
	<input type='hidden' name='queryStringForChart' id='queryStringForChart' value='<%=queryStringForChart%>'>
</form>
</body>
</html>

