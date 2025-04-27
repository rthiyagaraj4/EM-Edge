<!DOCTYPE html>
<%@page import="java.util.*,eCA.PatTaskListRepository,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="patTask" class="eCA.PatTaskListRepository" scope='page'/>
<script>
document.getElementById("thStatus").colSpan+=1
</script>
	<script language="javascript" src="../../eCA/js/PatTaskList.js"></script>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//out.println("<script>alert('2');</script>");
	ArrayList arrayDateTime = null;
	ArrayList arrayTaskType= null;
	ArrayList arrayTask= null;
	ArrayList arrayPriority= null;
	ArrayList arrayPatDetail= null;
	ArrayList arrayStatus= null;
	ArrayList retArray = null;
	ArrayList ArrayGrpHeading = null;
	ArrayList arrayTaskSrlNo = null;	
	ArrayList arrayRemarks=null;
	ArrayList arrayPerformedId=null;
	ArrayList arrayResultType=null;
	ArrayList arrayResultId=null;
	ArrayList arrayEncounterId= null;
	ArrayList arrayPatientClass= null;
	ArrayList arrayFacilityId= null;
	ArrayList arrayTaskCategory = null;
	ArrayList arrayScheduleDateTime= null;
	ArrayList arrayOrderId= null;
	ArrayList arrayOrderNum = null;
	ArrayList arrayPatientId = null;
	ArrayList arrayStatusDesc = null;
	ArrayList arrayOrderStatusCode = null;
	ArrayList arrayStageDesc = null;

	ArrayList arrayApplicableYN = new ArrayList();
	ArrayList arrayGuildeLinelength = new ArrayList();
	ArrayList arrayPositionDesc = new ArrayList();

	String adminStatus="";
	String encounterId ="";
	String patientClass ="";
	String facilityId ="";
	boolean flag=false;
	String resultType ="";
	String resultId ="";
	StringTokenizer tokenSpace = null;
	retArray =(ArrayList) request.getAttribute("retArray");
    
	String dateTime = request.getParameter("dateTime")==null ? "" :request.getParameter("dateTime");
	
	if(dateTime.equals("9"))	
	{
		out.println("<script>document.getElementById('thPatDetails').style.display='none'</script>");
	}
	String patientDetail =  request.getParameter("patientDetail")==null ? "" :  request.getParameter("patientDetail");
	String taskSelect =  request.getParameter("taskSelect")==null ? "" : request.getParameter("taskSelect");
	String grpHeading="";
	String prevGrpHeading="";
	StringTokenizer tokenColon=null;
	int noOfRows=0;
	int index=0;
	int indexJ=0;
	int indexK=0;
	String time="";
	String tempHeader = "";
	String taskCode ="";
	String taskTypeCode="";
	String taskDesc="";	
	String taskTypeDesc = "";String tdColor="";
	String remarks="";
	String performedId = "";
	String CP =request.getParameter("CP")==null ? "Y" : request.getParameter("CP");
	


	try
	{
		if(!dateTime.equals("") && taskSelect.equals("") && patientDetail.equals(""))
		{			
			if(dateTime.equals("3"))
			{
				out.println("<script>document.getElementById('thTaskType').style.display='none'</script>");
			}
			if(dateTime.equals("6"))
			{
				if(retArray != null)
					ArrayGrpHeading =(ArrayList)retArray.get(14);
			}
			else if(dateTime.equals("3"))
			{
				if(retArray != null)					
					ArrayGrpHeading =(ArrayList)retArray.get(1);					
			}
			else
			{
				if(retArray != null)					
				{
					
					ArrayGrpHeading =(ArrayList)retArray.get(17);				
					flag = true;
				}
			}			
			if(ArrayGrpHeading != null)
			{				
				String classValue="";	
				arrayDateTime = (ArrayList)retArray.get(0);
				arrayTaskType	 = (ArrayList)retArray.get(1);
				arrayTask	 = (ArrayList)retArray.get(2);
				arrayPriority	 = (ArrayList)retArray.get(3);
				arrayPatDetail	 = (ArrayList)retArray.get(4);
				arrayStatus	 = (ArrayList)retArray.get(5);
				arrayTaskSrlNo= (ArrayList)retArray.get(6);
		
				arrayRemarks= (ArrayList)retArray.get(7);
				arrayPerformedId= (ArrayList)retArray.get(8);
				arrayResultType= (ArrayList)retArray.get(9);
				arrayResultId= (ArrayList)retArray.get(10);
				arrayEncounterId= (ArrayList)retArray.get(11);
				arrayFacilityId= (ArrayList)retArray.get(12);				
				arrayTaskCategory = (ArrayList)retArray.get(13);
				
				arrayScheduleDateTime= (ArrayList)retArray.get(14);
				arrayOrderId= (ArrayList)retArray.get(15);
				arrayOrderNum = (ArrayList)retArray.get(16);
				arrayPatientId= (ArrayList)retArray.get(17);
				arrayStatusDesc= (ArrayList)retArray.get(18);
				arrayOrderStatusCode= (ArrayList)retArray.get(19);

				arrayStageDesc= (ArrayList)retArray.get(20);

				arrayApplicableYN = (ArrayList)retArray.get(21);
				arrayGuildeLinelength = (ArrayList)retArray.get(22);
				arrayPositionDesc = (ArrayList)retArray.get(23);
				arrayPatientClass= (ArrayList)retArray.get(24);
                
				for(index=0;index < ArrayGrpHeading.size();index++)
				{
					adminStatus = (String)arrayOrderStatusCode.get(index)==null ? "" :arrayOrderStatusCode.get(index).toString();
				
							if(adminStatus.equals("D"))
								{
									tdColor = "#CCFFCC";	
								}
								else if(adminStatus.equals("O"))
								{
									tdColor = "#FFFFCC";
								}
								else if(adminStatus.equals("E"))
								{
									tdColor = "#D5006A";
								}
								else if(adminStatus.equals("C"))
								{
									tdColor = "#0099FF";

								}
								else if(adminStatus.equals("F"))
								{
									tdColor = "#FFCCCC";
								}
					

					grpHeading = (String)ArrayGrpHeading.get(index);
					if(grpHeading.indexOf("/") != -1)
					{
						tokenSpace = new StringTokenizer(grpHeading," ");						
						grpHeading = tokenSpace.nextToken();
					}
					if(index % 2 ==0) 
							classValue="QRYEVEN" ;
						else
						classValue="QRYODD";						
						if(grpHeading.indexOf(":") != -1)						
						{
							tokenColon = new StringTokenizer(grpHeading,":");
							grpHeading = tokenColon.nextToken();
							
						}
						
					if(!grpHeading.equals(prevGrpHeading))
					{
						
						if(flag==true)
						{
							tempHeader = arrayPatDetail.get(index).toString();
						}
						else
						{
							tempHeader = grpHeading;
						}
						out.println("<tr id='trRowIdHeader"+indexJ+"'>");
							out.println("<td  nowrap class='CAHIGHERLEVELCOLOR'>&nbsp;</td>");
						out.println("<td class='CAHIGHERLEVELCOLOR' align='center' ><a href='javascript:' OnClick='collapseAll(this,"+indexJ+")' id='linkCollapse"+indexJ+"'><font color='#FFFFFF'>-</font></a></td><Td  class='CAHIGHERLEVELCOLOR'  colspan='8'  align='left'>"+tempHeader+"</td>");
						if(!prevGrpHeading.equals(""))
							out.println("<input type='hidden' name='noOfRows"+indexK+"' id='noOfRows"+indexK+"' value='"+noOfRows+"'>");						
						out.println("</tr>");
						noOfRows = 0;
						indexK = indexJ;
						indexJ++;
						prevGrpHeading = grpHeading;						
					}
					out.println("<tr  id='trRowId"+indexK+""+noOfRows+"'>");

					

					//out.println("<td nowrap  style='background:"+tdColor+"' class='"+classValue+"' align='center'><B>"+arrayTaskCategory.get(index).toString()+"</B></td>");
					out.println("<td nowrap  style='background:"+tdColor+"' class='label' align='center'><B>"+(arrayTaskCategory.get(index).toString())+"</B></td>");
					out.println("<td  nowrap class='"+classValue+"'>&nbsp;</td>");
					/*out.println("<td  nowrap class='"+classValue+"'>&nbsp;</td>");
					out.println("<td  nowrap class='"+classValue+"'>&nbsp;</td>");*/
					if(dateTime.equals("6"))
					{
						tokenColon = new StringTokenizer((String)arrayScheduleDateTime.get(index)," ");
						time = tokenColon.nextToken();
						time = tokenColon.nextToken();
					}
					else
					{
						time= (String)arrayScheduleDateTime.get(index);
					}
					out.println("<td  nowrap class='"+classValue+"'>"+time+"</td>");
					tokenColon = new StringTokenizer((String)arrayTaskType.get(index),":");
					taskTypeDesc = tokenColon.nextToken();
					taskTypeCode = tokenColon.nextToken();
					tokenColon = new StringTokenizer((String)arrayTask.get(index),":");
					taskDesc = tokenColon.nextToken();
					taskCode = tokenColon.nextToken();
					
					resultType=(String)arrayResultType.get(index) == null ? "" : (String)arrayResultType.get(index);
					resultId=(String)arrayResultId.get(index) == null ? "" : (String)arrayResultId.get(index);
					encounterId = (String)arrayEncounterId.get(index) == null ? "" : (String)arrayEncounterId.get(index);
					patientClass = (String)arrayPatientClass.get(index) == null ? "" : (String)arrayPatientClass.get(index);
					facilityId = (String)arrayFacilityId.get(index) == null ? "" : (String)arrayFacilityId.get(index);
					out.println("<td   class='"+classValue+"' id='tdTaskType"+index+"'>"+taskTypeDesc+"</td>");

					String anchor_guideLine = "";
					if (Integer.parseInt((String)arrayGuildeLinelength.get(index)) > 0)
					{
						anchor_guideLine = "&nbsp;&nbsp;<a href='javascript:' onclick='showGuideLine(\"" + taskCode + "\")'><font color='BLUE'>(G)</font></a>";
					}
					else
						anchor_guideLine = "&nbsp;";


					if(adminStatus.equals("D") || adminStatus.equals("O"))
					{
						if(arrayTaskCategory.get(index).toString().equals("I"))
						{  
							if(((String)arrayStatus.get(index)).equals("Pending") && ((String)arrayApplicableYN.get(index)).equals("Y")) 
							{
								if(resultType.equals(""))
								{
									out.println("<td  class='"+classValue+"'><a href='javascript:' OnClick='displayToolTipForPopulation(event,"+index+","+indexK+","+noOfRows+")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='position:absolute;visibility:hidden;'><table id='tooltiptable"+index+"' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
									//out.println("<td    nowrap class='"+classValue+"' ><a href='javascript:' OnClick='displayToolTip(event,"+index+")'><font color='BLUE'>"+taskDesc+"</font></a><div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='position:absolute;visibility:hidden;'><table id='tooltiptable"+index+"' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
								}
								else
								{
									out.println("<td  class='"+classValue+"'><a href='javascript:' OnClick='displayToolTipForEventsPopulation(event,"+index+" ,"+indexK+","+noOfRows+",\""+resultType+"\",\""+resultId+"\")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='position:absolute;visibility:hidden;'><table id='tooltiptable"+index+"' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
									
								}
							}
							else
							{
								out.println("<td  class='"+classValue+"'>"+taskDesc + anchor_guideLine + "</td>");
							}
						}
						else
						{
							
								out.println("<td  class='"+classValue+"'><a href='javascript:' OnClick='displayToolTipForEventsPopulation(event,"+index+" ,"+indexK+","+noOfRows+",\""+resultType+"\",\""+resultId+"\")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='position:absolute;visibility:hidden;'><table id='tooltiptable"+index+"' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
						}
					}
					else
					{
						out.println("<td  class='"+classValue+"'>"+taskDesc + anchor_guideLine +"</td>");
					}
					
					out.println("<td  class='"+classValue+"'>"+(String)arrayPriority.get(index)+"</td>");

					out.println("<td  class='"+classValue+"'>" + (String)arrayStageDesc.get(index) + "</td>");
					
					out.println("<td  class='"+classValue+"'>" + (String)arrayPositionDesc.get(index) + "</td>");

					out.println("<td class='"+classValue+"' id='tdPatientId"+index+"'>"+(String)arrayPatDetail.get(index)+"</td>");
					if(!(((String)arrayStatusDesc.get(index)).equals("Performed") || ((String)arrayStatusDesc.get(index)).equals("Not Performed"))) 
						{
							out.println("<td  nowrap class='"+classValue+"'>"+(String)arrayStatusDesc.get(index)+"</td>");
						}
						else
						{
							out.println("<td    nowrap class='"+classValue+"' ><a href='javascript:' OnClick='displayToolTipForPopulation1(event,"+index+","+indexK+","+noOfRows+")'><font color='BLUE'>"+(String)arrayStatus.get(index)+"</font></a><div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='position:absolute;visibility:hidden;'><table id='tooltiptable"+index+"' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
						}
					out.println("<input type='hidden' name='patientClass"+index+"' id='patientClass"+index+"' value='"+patientClass+"'>");
					out.println("<input type='hidden' name='taskType"+index+"' id='taskType"+index+"' value='"+taskTypeCode+"'>");
					out.println("<input type='hidden' name='taskCode"+index+"' id='taskCode"+index+"' value='"+taskCode+"'>");
					out.println("<input type='hidden' name='taskSrlNo"+index+"' id='taskSrlNo"+index+"' value='"+(String)arrayTaskSrlNo.get(index)+"'>");
					remarks = (String)arrayRemarks.get(index) == null ? "" : (String)arrayRemarks.get(index);
					performedId=(String)arrayPerformedId.get(index) == null ? "" : (String)arrayPerformedId.get(index);
					out.println("<input type='hidden' name='remarks"+index+"' id='remarks"+index+"' value='"+remarks+"'>");
					out.println("<input type='hidden' name='performedId"+index+"' id='performedId"+index+"' value='"+performedId+"'>");
					out.println("<input type='hidden' name='resultType"+index+"' id='resultType"+index+"' value='"+resultType+"'>");
					out.println("<input type='hidden' name='resultId"+index+"' id='resultId"+index+"' value='"+resultId+"'>");
					out.println("<input type='hidden' name='performedDate"+index+"' id='performedDate"+index+"' value='"+(String)arrayDateTime.get(index)+"'>");
					out.println("<input type='hidden' name='facilityId"+index+"' id='facilityId"+index+"' value='"+facilityId+"'>");
					out.println("<input type='hidden' name='encounterId"+index+"' id='encounterId"+index+"' value='"+encounterId+"'>");
					out.println("<input type='hidden' name='taskCategory"+index+"' id='taskCategory"+index+"' value='"+patTask.checkForNull(arrayTaskCategory.get(index).toString())+"'>");
					out.println("<input type='hidden' name='scheduleDate"+index+"' id='scheduleDate"+index+"' value='"+patTask.checkForNull(arrayScheduleDateTime.get(index).toString())+"'>");
					out.println("<input type='hidden' name='orderId"+index+"' id='orderId"+index+"' value='"+patTask.checkForNull(arrayOrderId.get(index).toString())+"'>");
					out.println("<input type='hidden' name='orderNum"+index+"' id='orderNum"+index+"' value='"+patTask.checkForNull(arrayOrderNum.get(index).toString())+"'>");
					out.println("<input type='hidden' name='patientId"+index+"' id='patientId"+index+"' value='"+patTask.checkForNull(arrayPatientId.get(index).toString())+"'>");
					out.println("<input type='hidden' name='status"+index+"' id='status"+index+"' value='"+patTask.checkForNull(arrayStatus.get(index).toString())+"'>");
					out.println("<input type='hidden' name='adminStatus"+index+"' id='adminStatus"+index+"' value='"+adminStatus+"'>");
					out.println("<input type='hidden' name='priority"+index+"' id='priority"+index+"' value='"+patTask.checkForNull(arrayPriority.get(index).toString())+"'>");
						out.println("</tr>");
					noOfRows++;%>
					<script>
						var ThpatientId =document.getElementById("tdPatientId"+"<%=index%>");
						var tdTaskType	=document.getElementById("tdTaskType"+"<%=index%>");
						//if(   || ('<%=CP%>' =='Y'))
						if( ("<%=dateTime%>"=='9') ||(patientId.value !='') )//(patientId.value !='')|||| ('<%=CP%>' =='Y')
						{	
							
							ThpatientId.style.display='none';
						}
						if("<%=dateTime%>"=='3')
						{
							tdTaskType.style.display='none';
						}
					</script>
<%
					}
				out.println("<input type='hidden' name='noOfRows"+indexK+"' id='noOfRows"+indexK+"' value='"+noOfRows+"'>");
				out.println("<input type='hidden' name='noOfHeaders' id='noOfHeaders' value='"+indexJ+"'>");
				out.println("<input type='hidden' name='noOfRow' id='noOfRow' value='"+noOfRows+"'>");
				out.println("<input type='hidden' name='count' id='count' value='"+arrayStatus.size()+"'>");
			}

%>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' >
	<tr><td width='100%' id='t'></td></tr>
	</table>
	</div>	
<%

}
		else
		{
			if(dateTime.equals("6"))
			{
						if(retArray != null)					
						{	
							ArrayGrpHeading =(ArrayList)retArray.get(14);
							
						}
			}
			else if(dateTime.equals("3"))
			{
					if(retArray != null)					
					{	
						ArrayGrpHeading =(ArrayList)retArray.get(1);
					}
			}
			else
			{
					if(retArray != null)					
					{	
						ArrayGrpHeading =(ArrayList)retArray.get(17);		flag = true;

					}
			}
			
			


			request.setAttribute("FirstGrpBy",ArrayGrpHeading);
			request.setAttribute("FirstGrpByFlag",new Boolean(flag));
%>
		<jsp:include page="PatTaskListPopulationCriteria.jsp" />
<%	}


	}
	catch(Exception ee)
	{
		
		
		ee.printStackTrace();
	}
	finally
	{
		//arrayDateTime.clear();                    
		//arrayTaskType.clear();                    
		//arrayTask.clear();                       
		//arrayPriority.clear();                    
		//arrayPatDetail.clear();                   
		//arrayStatus.clear();                      
		retArray.clear();                         
		ArrayGrpHeading.clear();                  
		//arrayTaskSrlNo.clear();                   
		//arrayRemarks.clear();                     
		//arrayPerformedId.clear();                 
		//arrayResultType.clear();                  
		//arrayResultId.clear();                    
		//arrayEncounterId.clear();                 
		//arrayFacilityId.clear();                  
		//arrayTaskCategory.clear();                
		//arrayScheduleDateTime.clear();            
		//arrayOrderId.clear();                     
		//arrayOrderNum.clear();                    
		//arrayPatientId.clear();                   
		//arrayStatusDesc.clear();                  
		//arrayOrderStatusCode.clear();             
		//arrayStageDesc.clear();                   
		arrayApplicableYN.clear();                
		arrayGuildeLinelength.clear();            
		arrayPositionDesc.clear();                  

	}
%>
</form>

