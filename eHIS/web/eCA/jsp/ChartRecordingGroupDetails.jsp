<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
10/11/2011  IN029392        Menaka      	Clinical Event History>View Graph Select event result and then click View graph										 
16/08/2019	IN069564		Ramesh Goli		CA-Common-Record Charts									 
---------------------------------------------------------------------------------------------------------------
--> 
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = "";
	if(flowsheetGraph.equals("Y"))
		encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	else
		encounter_id = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");

		String numOfchkedBoxes = request.getParameter("numOfchkedBoxes") == null ? "0" : request.getParameter("numOfchkedBoxes");
		//out.println("<script>alert('numOfchkedBoxes = "+numOfchkedBoxes+"');</script>");

	
	eCA.ChartRecordingAddGroupBean chartingBean = null; 
//(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	if(flowsheetGraph.equals("Y"))
	{
		if(encounter_id.equals("") || encounter_id == null) 
			encounter_id = request.getParameter("encounterId");

		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}
	else
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}



%>
<html>
	<head>
		<title><fmt:message key="Common.GroupDetails.label" bundle="${common_labels}"/></title>
		<%
			String displayRad1 = "display:none";
			String displayRad2 = "display:none";
			String displayRad3 = "display:none";
			String displayRad4 = "display:none";
			String displayRadNew = "display";

			int Group1 = 0;
			int Group2 = 0;
			int Group3 = 0;
			int Group4 = 0;

			//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			//String locale = (String) p.getProperty("LOCALE");
			
			String count = request.getParameter("count") == null ? "1" : request.getParameter("count");
			String flagGraph = request.getParameter("flagGraph") == null ? "N" : request.getParameter("flagGraph");
			String sentFromGraph = request.getParameter("sentFromGraph") == null ? "" : request.getParameter("sentFromGraph");
			String sentFrom = request.getParameter("sentFrom") == null ? "" : request.getParameter("sentFrom");
			
			String groupName = request.getParameter("groupName") == null ? "" : request.getParameter("groupName");
			String statusChecked = request.getParameter("statusChecked") == null ? "" : request.getParameter("statusChecked");

			String classValue = "";
			String grpDetails = "";
			int i=0;
			int grpCount = 0;

			StringTokenizer strToken = null;
			StringTokenizer strTokenRadBtn = null;
			
		%>
		<script src='../../eCA/js/ChartRecording.js' language='javascript'></script>	
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<%

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		
	</head>
	<body onKeyDown="lockKey()">
		<form name='chartRecordingGrpDetailsForm' id='chartRecordingGrpDetailsForm'>
			<table class='grid' width='100%'>
				<tr>
					<td class='CAGROUPHEADING' align='center' colspan='2'><fmt:message key="eCA.GeneralGraph.label" bundle="${ca_labels}"/></td>
				</tr>
				<tr></tr>
			</table>
			<table class='grid' width='100%'>
			<tr>
				<td class='CACHARTFOURTHLEVELCOLOR' align='left' colspan='2'><fmt:message key="eCA.StandardView.label" bundle="${ca_labels}"/></td>
			</tr>
			<tr>
				<td colspan='2' align='left'><input type='radio' name='axis_range' id='axis_range' value='S' checked><fmt:message key="Common.single.label" bundle="${common_labels}"/>
				<input type='radio' name='axis_range' id='axis_range' value='M'><fmt:message key="Common.multiple.label" bundle="${common_labels}"/></td>
			</tr>
			<%
			try
			{
				HashMap map = new HashMap();
				
				String keyForMap = "";
				String valueFromMap = "";
				String discrMsrDesc = "";
				String groupNo = "";
				String prevGroupNo = "";
				String chkdUnchked = "";
				String datesValues = "";
				String units = "";
				String radBtnCode = "";
				if(sentFrom.equals("radBtn"))
				{
					strTokenRadBtn = new StringTokenizer(statusChecked,"!!");
				}
				ArrayList list = chartingBean.retrieveRecords();				
				
				if(sentFrom.equals("radBtn"))
				{
					list = chartingBean.retrieveRecords();
					map = chartingBean.getHashValues();
					int size = 	strTokenRadBtn.countTokens();

					for(int k=0;k<size;k++)
					{
						radBtnCode = strTokenRadBtn.nextToken();
						for(int m=0;m<list.size();m++)
						{
							keyForMap = (String) list.get(m);
							valueFromMap = (String) map.get(keyForMap);
							strToken = new StringTokenizer(valueFromMap,"~");
							discrMsrDesc = strToken.nextToken();
							//groupNo = strToken.nextToken();
							chkdUnchked = strToken.nextToken();			
							datesValues = strToken.nextToken();
							units = strToken.nextToken();
							groupNo = strToken.nextToken();  //IN052210
							if(radBtnCode.equals(keyForMap))
							{
								groupNo = groupName;
								//Modification starts for IN29392
								//chartingBean.addRecords(keyForMap,java.net.URLDecoder.decode(discrMsrDesc) + "~" + groupNo + "~" + chkdUnchked + "~" + datesValues + "~" + units);
								//IN052210 Start.
								//chartingBean.addRecords(keyForMap,discrMsrDesc + "~" + groupNo + "~" + chkdUnchked + "~" + datesValues + "~" + units);
								chartingBean.addRecords(keyForMap,discrMsrDesc + "~" + chkdUnchked + "~" + datesValues + "~" + units+ " ~" + groupNo);
								//IN052210 End.
								//Modification ends for IN29392
								if(flowsheetGraph.equals("Y"))
									putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
								else
									putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);
								
								m = list.size();
							}
						}
					}
				}
				chartingBean.reArrangeGroups(); //IN069564

				list = chartingBean.retrieveRecords();
				map = chartingBean.getHashValues();
			
				for(int j=1;j<5;j++)
				{
					for(int m=0;m<list.size();m++)
					{
						/*if(i % 2 == 0)
							classValue = "QRYEVEN";
						else
							classValue = "QRYODD";*/

						 classValue="gridData";


						keyForMap = (String) list.get(m);
						valueFromMap = (String) map.get(keyForMap);
						strToken = new StringTokenizer(valueFromMap,"~");
						discrMsrDesc = strToken.nextToken();
						//discrMsrDesc = java.net.URLDecoder.decode(discrMsrDesc);//Modification for IN29392
						//IN052210 Start.
						/*
						groupNo = strToken.nextToken();
						chkdUnchked = strToken.nextToken();		
						strToken.nextToken();*/
						chkdUnchked = strToken.nextToken();	
						datesValues = strToken.nextToken();
						units = strToken.nextToken();
						groupNo = strToken.nextToken();
						//IN052210 End.
						if(groupNo.equals("Group "+j))
						{
							if(!prevGroupNo.equals(groupNo))
							{
								out.println("<tr>");
								//out.println("<td class='CAGROUPHEADING' colspan='2'><img align='left' src='../../eCommon/images/iGridNextDIS16.gif' id='"+groupNo+"'><a class='NormalGroup' href='javascript:loadDetailsPage(\""+groupNo+"\")' title='Click the Group Name to regroup'> ");
								out.println("<td class='NormalGroup' colspan='2' onclick='loadDetailsPage(\""+groupNo+"\")' onmouseover='activateLink(this,\""+j+"\")' onmouseout='deactivateLink(this,\""+j+"\")'><img align='left' src='../../eCommon/images/iGridNextDIS16.gif' id='group"+j+"'>"+groupNo+"</td>");
								//out.println(groupNo);
								//out.println("</td>");							
								out.println("</tr>");
								grpCount++;
							}					
							grpDetails = discrMsrDesc + "^^" + groupNo+ "!!" + grpDetails;
							out.println("<tr>");
							out.println("<td class='"+classValue+"' width='3%'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='chkDiscrMsr"+i+"'  id='"+keyForMap+"' onclick='addToNewGrp(\""+i+"\",\""+groupNo+"\",this)'>");
							out.println("</td>");
							out.println("<td class='"+classValue+"' width='97%'>"+keyForMap+"</td>");
							out.println("</tr>");
							prevGroupNo = groupNo;
							i++;							
							if(groupNo.equals("Group 1"))
							{
								Group1++;								
							}
							if(groupNo.equals("Group 2"))
							{
								Group2++;								
							}
							if(groupNo.equals("Group 3"))
							{
								Group3++;								
							}
							if(groupNo.equals("Group 4"))
							{
								Group4++;								
							}
						}					
					}
				}
				if(flowsheetGraph.equals("Y"))
					putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
				else
					putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);

				if(flagGraph.equals("Y"))
				{
					count = sentFromGraph;
				}
				else
				{
					Integer tempCnt = new Integer(Group1 + Group2 + Group3 + Group4);
					count = tempCnt.toString();
				}

				if(grpCount == 2)
				{
					displayRad1 = "display";
					if(Integer.parseInt(count) > 2)
					{
						displayRad2 = "display";
						displayRadNew = "display";
					}

					if(Group1 == 1)
					{
						displayRad2 = "display:none";
					}
				}
				else if(grpCount == 3)
				{
					displayRad1 = "display";
					displayRad2 = "display";

					if(Integer.parseInt(count) > 3)
					{
						displayRad3 = "display";
						displayRadNew = "display";
					}
				}
				else if(grpCount == 4)
				{
					displayRad1 = "display";
					displayRad2 = "display";
					displayRad3 = "display";
					displayRad4 = "display";
					displayRadNew = "display:none";
				}
				if(flowsheetGraph.equals("Y"))
					putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
				else
					putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);

/*				out.println("group count = "+grpCount);
				out.println("grp1 = "+Group1);
				out.println("grp2 = "+Group2);
				out.println("grp3 = "+Group3);
				out.println("grp4 = "+Group4);*/
			}
			catch(Exception e)
			{
				//out.println("Exception in ChartRecordingGroupDetails.jsp -- "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			%>
			
			</table>
			<table width='100%' style='border-bottom-color:#666666'>
			<tr>
				<td class='CAGROUPHEADING'>
					<input type='button' name='graph' id='graph' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")%>' onclick ='closeWindow()'><input type='button' name='newgroup' id='newgroup' style='<%=displayRadNew%>' id='radNew' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.New.label","common_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Group.label","common_labels")%>' onclick ='loadDetailsPage("New Group")'>
					<!-- <a class='gridLink' href='javascript:loadDetailsPage("New Group")'><fmt:message key="Common.New.label" bundle="${common_labels}"/><fmt:message key="Common.Group.label" bundle="${common_labels}"/></a> -->
					
				</td>
			</tr>
			</table>
			<div id='toolTipDiv' style='position:absolute; width:20%; display:none'>
				<table id='toolTiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
					<tr><td width='100%' id='tdID'></td></tr>
				</table>
			</div>
			<input type='hidden' name='grpValueHidden' id='grpValueHidden' value=''>
			<input type='hidden' name='noOfRecs' id='noOfRecs' value='<%=i%>'>			
			<input type='hidden' name='grpCount' id='grpCount' value='<%=grpCount%>'>
			<input type='hidden' name='grpDetails' id='grpDetails' value='<%=grpDetails%>'>
			<input type='hidden' name='no_of_selections' id='no_of_selections' value='<%=request.getParameter("no_of_selections")%>'>
			<input type='hidden' name='selected_events_uom' id='selected_events_uom' value='<%=request.getParameter("selected_events_uom")%>'>
			<input type='hidden' name='group1' id='group1' value='<%=Group1%>'>
			<input type='hidden' name='group2' id='group2' value='<%=Group2%>'>
			<input type='hidden' name='group3' id='group3' value='<%=Group3%>'>
			<input type='hidden' name='group4' id='group4' value='<%=Group4%>'>			
			<input type='hidden' name='grp1Val' id='grp1Val' value='0'>	
			<input type='hidden' name='grp2Val' id='grp2Val' value='0'>	
			<input type='hidden' name='grp3Val' id='grp3Val' value='0'>	
			<input type='hidden' name='grp4Val' id='grp4Val' value='0'>
			<input type='hidden' name='grp1ValTemp' id='grp1ValTemp' value='0'>	
			<input type='hidden' name='grp2ValTemp' id='grp2ValTemp' value='0'>	
			<input type='hidden' name='grp3ValTemp' id='grp3ValTemp' value='0'>	
			<input type='hidden' name='grp4ValTemp' id='grp4ValTemp' value='0'>
			<input type='hidden' name='GroupName1' id='GroupName1' value=''>
			<input type='hidden' name='GroupName2' id='GroupName2' value=''>
			<input type='hidden' name='GroupName3' id='GroupName3' value=''>
			<input type='hidden' name='GroupName4' id='GroupName4' value=''>
			<input type='hidden' name='facility_id' id='facility_id' value='<%=request.getParameter("facility_id")%>'>
			<input type='hidden' name='encounterId' id='encounterId' value='<%=encounter_id%>'>
			<input type='hidden' name='patient_id' id='patient_id' value='<%=request.getParameter("patient_id")%>'>
			<input type='hidden' name='allDatesForGraph' id='allDatesForGraph' value='<%=request.getParameter("allDatesForGraph")%>'>
			<input type='hidden' name='flowsheetGraph' id='flowsheetGraph' value='<%=flowsheetGraph%>'>
			<input type='hidden' name='numOfchkedBoxes' id='numOfchkedBoxes' value='<%=numOfchkedBoxes%>'>
		</form>
	</body>
</html>

