<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?			?				?												?
04/02/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005
07/03/2016	IN059461		Ramesh G										This issue happens when chart recorded exactly on shift timings.
11/03/2016	IN059532		Raja S											Alpha-Regression-CA - System doesn't display graph in Clinical 																				Event History.
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%

	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	String encounterId = "";
	if(flowsheetGraph.equals("Y"))
		encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	else
		encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");	
	
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.ChartRecordingAddGroupBean chartingBean = null;

	//(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	if(flowsheetGraph.equals("Y"))
	{
		if(encounterId.equals("") || encounterId == null)
			encounterId = request.getParameter("encounterId");
		
		if(encounterId.equals(""))
		{
			encounterId ="0";
		}

		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+encounterId,"eCA.ChartRecordingAddGroupBean",session);
	}
	else
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounterId,"eCA.ChartRecordingAddGroupBean",session);
	}
		

%>

<HTML>
<HEAD>
<script language='javascript' src='../../eCA/js/ChartRecording.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='JavaScript'>
	var arrValues = new Array();
	var values2bsent = new Array();
	var dates2bsent = new Array();
	var desc2bsent = new Array();
	var new_total_col ;
	var event_val ;
	var unit_val ;
	var noOfSeries ;
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onKeyDown="lockKey()">
<%

	String noOfGroups = request.getParameter("noOfGroups") == null ? "1" : request.getParameter("noOfGroups");
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
	String axis_range = request.getParameter("axis_range") == null ? "S" : request.getParameter("axis_range");
	String numOfchkedBoxes = request.getParameter("numOfchkedBoxes") == null ? "0" : request.getParameter("numOfchkedBoxes");

	//out.println("<script>alert('"+numOfchkedBoxes+"')</script>");

	String allDatesForGraph = request.getParameter("allDatesForGraph") == null ?"" : request.getParameter("allDatesForGraph");
	StringTokenizer strTokDates = new StringTokenizer(allDatesForGraph,"$$");
	ArrayList list = chartingBean.retrieveRecords();
	
	ArrayList tempArrayList = new ArrayList();
	ArrayList dateArrayList = new ArrayList();
	HashMap map = new HashMap();
	StringTokenizer strToken = null;
	StringTokenizer strTokenDatesAndValues = null;
	StringTokenizer strTkTdDatesAndValues = null;
	map = chartingBean.getHashValues();
	
	String keyForMap = "";
	String valueFromMap = "";
	String discrMsrDesc = "";
	String groupNo = "";
	String chkdUnchked = "";
	String datesAndValues = "";
	String tdDatesAndValues = "";
	String discrMsrId = "";		//IN058139.

	String graphDates = "";
	String graphValues = "";
	String graphResultType = ""; //IN059461
	String legendString = "";
	String discrUOM = "";
	StringBuffer descToGraph = new StringBuffer();
	int tempInt = 0;

	ArrayList listForGrp1 = new ArrayList();
	ArrayList listForGrp2 = new ArrayList();
	ArrayList listForGrp3 = new ArrayList();
	ArrayList listForGrp4 = new ArrayList();
	//IN058139 Start.	
	Set<String> disSetForGrp1 = new HashSet<String>();
	Set<String> disSetForGrp2 = new HashSet<String>();
	Set<String> disSetForGrp3 = new HashSet<String>();
	Set<String> disSetForGrp4 = new HashSet<String>();
	//IN058139 End.

	String groupNames = "";
	String datesForGrf = "";
	String valuesForGrf = "";
	String legendForGrf = "";
	String allDatesForGrf = "";
	String allDetailsForGraphs = "";
	String grfDatesAndValues = "";
	String graphDatesAndValues = "";
	StringTokenizer detailsForGrf = null;

	try
	{	
	if(axis_range.equals("S"))
	{
		for(int i=0;i<list.size();i++)
		{
			keyForMap = (String) list.get(i);
			discrMsrId = keyForMap; //IN058139
			valueFromMap = (String) map.get(keyForMap);	
			strToken = new StringTokenizer(valueFromMap,"~");
			discrMsrDesc = strToken.nextToken();
			descToGraph.append(discrMsrDesc+",");
			//groupNo = strToken.nextToken();
			chkdUnchked = strToken.nextToken();
			datesAndValues = strToken.nextToken();
			discrUOM = strToken.nextToken();
			groupNo = strToken.nextToken(); //IN052210
		
			if(!discrUOM.equals(" "))
			{
				legendString = discrMsrDesc + " (" + discrUOM + ")";
			}
			else
				legendString = discrMsrDesc;

			if(legendString.indexOf("%") != -1)
			{
				legendString = legendString.replaceAll("%","%25");
			}
			strTokenDatesAndValues = new StringTokenizer(datesAndValues,">");
			
			while(strTokenDatesAndValues.hasMoreTokens())
			{
				tdDatesAndValues = strTokenDatesAndValues.nextToken();
				strTkTdDatesAndValues = new StringTokenizer(tdDatesAndValues,"^%");
				while(strTkTdDatesAndValues.hasMoreTokens())
				{
					if(tempInt % 2 == 0)
					{
						graphDates = strTkTdDatesAndValues.nextToken();
					}
					else
					{
						graphValues = strTkTdDatesAndValues.nextToken();
						// IN059532 start
						if(flowsheetGraph.equals("Y"))
						graphResultType = "N"; //N is hardcoded.Bcoz results adding temparraylist thru flowsheetview in clinicalEventHistory
						else	// IN059532 end					
							graphResultType = strTkTdDatesAndValues.nextToken(); //IN059461
						if(!graphValues.equals(" "))
						{
							//IN058139 Start.
							//tempArrayList.add(groupNo+"`"+graphDates+"`"+graphValues+"`"+legendString);
							if(!"S".equals(graphResultType)&&!"S1".equals(graphResultType)&&!"S2".equals(graphResultType)&&!"S3".equals(graphResultType)){ //IN059461
								tempArrayList.add(groupNo+"`"+graphDates+"`"+graphValues+"`"+legendString+"`"+discrMsrId);
							} //IN059461
							//IN058139 End.
						}
					}
					tempInt++;
				}
			}
		}

		while(strTokDates.hasMoreTokens())
		{
			allDatesForGrf = (String) strTokDates.nextToken();
			for(int i=0;i<tempArrayList.size();i++)
			{
				allDetailsForGraphs = (String) tempArrayList.get(i);
				detailsForGrf = new StringTokenizer(allDetailsForGraphs,"`");
				groupNames = (String) detailsForGrf.nextToken();
				datesForGrf = (String) detailsForGrf.nextToken();
				valuesForGrf = (String) detailsForGrf.nextToken();
				legendForGrf = (String) detailsForGrf.nextToken();
				discrMsrId = (String) detailsForGrf.nextToken();
				if(datesForGrf.equals(allDatesForGrf))
				{
					if(groupNames.equals("Group 1"))
					{
						listForGrp1.add(datesForGrf+"`"+valuesForGrf+"`"+legendForGrf);
						disSetForGrp1.add(discrMsrId); //IN058139
					}	
					else if(groupNames.equals("Group 2"))
					{
						listForGrp2.add(datesForGrf+"`"+valuesForGrf+"`"+legendForGrf);
						disSetForGrp2.add(discrMsrId); //IN058139
					}
					else if(groupNames.equals("Group 3"))
					{
						listForGrp3.add(datesForGrf+"`"+valuesForGrf+"`"+legendForGrf);
						disSetForGrp3.add(discrMsrId); //IN058139
					}
					else if(groupNames.equals("Group 4"))
					{
						listForGrp4.add(datesForGrf+"`"+valuesForGrf+"`"+legendForGrf);
						disSetForGrp4.add(discrMsrId); //IN058139
					}
				}
			}
		}
	}
	else if(axis_range.equals("M"))
	{
		while(strTokDates.hasMoreTokens())
		{
			allDatesForGrf = (String) strTokDates.nextToken();
			dateArrayList.add(allDatesForGrf);
		}
		for(int i=0;i<list.size();i++)
		{
			keyForMap = (String) list.get(i);
			valueFromMap = (String) map.get(keyForMap);
			strToken = new StringTokenizer(valueFromMap,"~");
			discrMsrDesc = strToken.nextToken();
			//groupNo = strToken.nextToken();
			chkdUnchked = strToken.nextToken();
			datesAndValues = strToken.nextToken();
			discrUOM = strToken.nextToken();
			groupNo = strToken.nextToken();//IN052210
			if(!discrUOM.equals(" "))
			{
				legendString = discrMsrDesc + " (" + discrUOM + ")";
			}
			else
				legendString = discrMsrDesc;

			if(legendString.indexOf("%") != -1)
			{
				legendString = legendString.replaceAll("%","%25");
			}

			strTokenDatesAndValues = new StringTokenizer(datesAndValues,">");
			while(strTokenDatesAndValues.hasMoreTokens())
			{
				tdDatesAndValues = strTokenDatesAndValues.nextToken();
				strTkTdDatesAndValues = new StringTokenizer(tdDatesAndValues,"^%");
				while(strTkTdDatesAndValues.hasMoreTokens())
				{
					graphDates = strTkTdDatesAndValues.nextToken();
					graphValues = strTkTdDatesAndValues.nextToken();
					// IN059532 start
					if(flowsheetGraph.equals("Y"))
					graphResultType = "N";  //N is hardcoded.Bcoz results adding temparraylist thru flowsheetview in clinicalEventHistory
					else	// IN059532 ends
						graphResultType = strTkTdDatesAndValues.nextToken(); //IN059461
					for(int j=0;j<dateArrayList.size();j++)
					{
						if(graphDates.equals(dateArrayList.get(j)))
						{
							if(!"S".equals(graphResultType)&&!"S1".equals(graphResultType)&&!"S2".equals(graphResultType)&&!"S3".equals(graphResultType)){ //IN059461
							grfDatesAndValues = graphDates+"^%"+graphValues;
							graphDatesAndValues = graphDatesAndValues+grfDatesAndValues+">";
							}//IN059461
						}
					}
				}
			}

			if(groupNo.equals("Group 1"))
			{
				if(!graphDatesAndValues.equals("")){
					//IN058139 Start.
					//listForGrp1.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString);
					listForGrp1.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString+"~"+keyForMap);
					//IN058139 End.
				}
			}	
			else if(groupNo.equals("Group 2"))
			{
				if(!graphDatesAndValues.equals("")){
					//IN058139 Start.
					//listForGrp2.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString);
					listForGrp2.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString+"~"+keyForMap);
					//IN058139 End.
				}
			}
			else if(groupNo.equals("Group 3"))
			{
				if(!graphDatesAndValues.equals("")){
					//IN058139 Start.
					//listForGrp3.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString);
					listForGrp3.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString+"~"+keyForMap);
					//IN058139 End.
				}
			}
			else if(groupNo.equals("Group 4"))
			{
				if(!graphDatesAndValues.equals("")){
					//IN058139 Start.
					//listForGrp4.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString);
					listForGrp4.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString+"~"+keyForMap);
					//IN058139 End.
				}
			}
			grfDatesAndValues = "";
			graphDatesAndValues = "";
		}
	}
		chartingBean.addToHashMap("Group 1",listForGrp1);
		chartingBean.addToHashMap("Group 2",listForGrp2);
		chartingBean.addToHashMap("Group 3",listForGrp3);
		chartingBean.addToHashMap("Group 4",listForGrp4);
		chartingBean.addToHashMap("SetGroup 1",new ArrayList<String>(disSetForGrp1)); //IN058139
		chartingBean.addToHashMap("SetGroup 2",new ArrayList<String>(disSetForGrp2));  //IN058139
		chartingBean.addToHashMap("SetGroup 3",new ArrayList<String>(disSetForGrp3)); //IN058139
		chartingBean.addToHashMap("SetGroup 4",new ArrayList<String>(disSetForGrp4)); //IN058139

		if(flowsheetGraph.equals("Y"))
			putObjectInBean("flowsheetBean"+patient_id+encounterId,chartingBean,session);
		else
			putObjectInBean("chartingBean"+patient_id+encounterId,chartingBean,session);
	}
	catch(Exception ex)
	{
		
		ex.printStackTrace();
	}
	%>

	<script>
	if('<%=numOfchkedBoxes%>' != 0)
		location.href = '../../eCA/jsp/ChartRecordingGraphFrame.jsp?noOfGroups=<%=noOfGroups%>&numOfchkedBoxes=<%=numOfchkedBoxes%>&patient_id=<%=patient_id%>&encounterId=<%=encounterId%>&facility_id=<%=facility_id%>&axis_range=<%=axis_range%>&flowsheetGraph=<%=flowsheetGraph%>';
	else
		location.href = '../../eCA/jsp/blank.jsp';
	</script>
</html>

