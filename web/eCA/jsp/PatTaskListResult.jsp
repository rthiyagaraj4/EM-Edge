<!DOCTYPE html>
<%@page import="java.util.*,eCA.PatTaskListRepository,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="patTask" class="eCA.PatTaskListRepository" scope='page'/>
<html>

<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<!-- <link rel="stylesheet" type="text/css" href="../html/CAPatTaskList.css">  -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/PatTaskList.js"></script>
	<style>
		TD.PLANSUBHEAD
		{
			FONT-SIZE: 9pt;
			BORDER-LEFT-COLOR: white;
			BORDER-BOTTOM-COLOR: white;
			BORDER-TOP-STYLE: solid;
			BORDER-TOP-COLOR: white;
			BORDER-RIGHT-STYLE: solid;
			BORDER-LEFT-STYLE: solid;
			HEIGHT: 18px;			
			BORDER-RIGHT-COLOR: white;
			BORDER-BOTTOM-STYLE: solid
		}
		 A:link
		{
			COLOR: yellow
		}
		A:visited
		{
			COLOR: yellow
		} 
	</style>
	<script>
	var child = null;
	function loadpage()
	{
		if (child != null)
		{
			if(child.closed == false)
			{
				child.focus();
				window.onblur = loadpage;
			}
			else
			{
				SearchTaskCriteria1('flagString');
			}
		}
	}
	function newWindow(action_url,arguments,features)
	{
		child =	window.open(action_url,arguments,features);
		child.onblur = loadpage;
	}
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" OnScroll="scrollTitle()" onfocus="loadpage()">

<script language='javascript'>

	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<form name='patTaskListResultForm' id='patTaskListResultForm'>
<%
	//out.println("<script>alert('1');</script>");
	//Properties property = null;
	ArrayList arrayDateTime = null;
	String sortOrder = patTask.checkForNull(request.getParameter("sortOrder"));
	String sortSelection = patTask.checkForNull(request.getParameter("sortSelection"));
	String color="";
	String thId = "";
	ArrayList arrayTaskType= null;
	ArrayList arrayTask= null;
	ArrayList arrayPriority= null;	
	ArrayList arrayPatDetail= null;
	ArrayList arrayStatus= null;
	String resultType ="";
	String resultId ="";
	//boolean Flag = false;
	ArrayList retArray = null;
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

	String encounterId ="";
	String patientClass ="";
	String adminStatus="";
	String facilityId ="";
	String flagString = request.getParameter("flagString")==null ? "" : request.getParameter("flagString");
	String flagString1 = request.getParameter("flagString1")==null ? "" : request.getParameter("flagString1");
	String dateTime =  request.getParameter("dateTime")==null ? "" :request.getParameter("dateTime");
	String patientDetail =  request.getParameter("patientDetail")==null ? "" :  request.getParameter("patientDetail");
	String taskSelect =  request.getParameter("taskSelect")==null ? "" : request.getParameter("taskSelect");
	String CP =request.getParameter("CP")==null ? "Y" : request.getParameter("CP");
	
	String tdColor="";
		
	try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		retArray = patTask.getTaskListQuery(request,locale);

		if(retArray != null)
		{
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
			arrayPatientClass= (ArrayList)retArray.get(24);
			
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

			if(arrayDateTime.size() ==0 && arrayTaskType.size()==0 && arrayTask.size()==0 && arrayPriority.size()==0 &&  arrayPatDetail.size()==0 && arrayStatus.size()==0 && arrayTaskSrlNo.size()==0)
			{
				out.println("<script>if(parent.patTaskListCriteriaFrame) parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.search.disabled=false</script>");		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'))</script>");
			out.println("<script>parent.patTaskListResultFrame.location.href='../../eCommon/html/blank.html'</script>");

			}
			else
			{%>
				<table border="1" cellpadding='3' cellspacing='0'   id='tableId' width="100%" align='center'>
					<tr id='divTitleTable' border='0'>						
						<td class='COLUMNHEADERCENTER' border='0'></td>
						<%if(!dateTime.equals("")){%>
							<td class='COLUMNHEADERCENTER' border='0' width='2%'></td>
							<%if(!patientDetail.equals("")){%>
								<td class='COLUMNHEADERCENTER' border='0' width='2%'></td>
								<%if(!taskSelect.equals("")){%>
									<td class='COLUMNHEADERCENTER' border='0' width='2%'></td>
								<%}
							}
						}%>
						<td class='COLUMNHEADERCENTER' nowrap id='thDateId' border='0'>
							<a href='javascript:' OnClick='sortRecord("Date",this)' id='anchorDateId' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></a>
						</td>
						<td class='COLUMNHEADERCENTER' id='thTaskType' width='15%' border='0'>
							<a href='javascript:' OnClick='sortRecord("TaskType",this)' id='anchorTaskType'><fmt:message key="eCA.TaskType.label" bundle="${ca_labels}"/></a>
						</td>
						<td class='COLUMNHEADERCENTER' border='0' id='thTask' width='<%=((dateTime.equals(""))?"45%":((!dateTime.equals("") && patientDetail.equals(""))?"46%":((!dateTime.equals("") && !patientDetail.equals("") && taskSelect.equals(""))?"47%":		((!taskSelect.equals(""))?"48%":""))))%>'>
							<a href='javascript:' OnClick='sortRecord("Task",this)' id='anchorTask' ><fmt:message key="Common.Task.label" bundle="${common_labels}"/></a>
						</td>
						<td class='COLUMNHEADERCENTER' id='thPriority' border='0'>
							<a href='javascript:' OnClick='sortRecord("Priority",this)' id='anchorPriority' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></a>
						</td>
						<td class='COLUMNHEADERCENTER' id='thPriority' border='0'>
							<fmt:message key="Common.Stage.label" bundle="${common_labels}"/>
						</td>
						<td class='COLUMNHEADERCENTER' id='thPriority' border='0'>
							<fmt:message key="Common.Position.label" bundle="${common_labels}"/>
						</td>
						<td class='COLUMNHEADERCENTER' id='thPatDetails' style='display' border='0' width='<%=((dateTime.equals(""))?"45%":((!dateTime.equals("") && patientDetail.equals(""))?"46%":((!dateTime.equals("") && !patientDetail.equals("") && taskSelect.equals(""))?"47%":		((!taskSelect.equals(""))?"48%":""))))%>'>
							<a href='javascript:' OnClick='sortRecord("PatientDetails",this)'  id='anchorPatDetails'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></a>
						</td>
						<td class='COLUMNHEADERCENTER'  id='thStatus' border='0'>
							<a href='javascript:' OnClick='sortRecord("Status",this)' id='anchorStatus'><fmt:message key="Common.status.label" bundle="${common_labels}"/></a>							
						</td>
						<script>		
							var patientId =""; 
							if (parent.patTaskListCriteriaFrame)
				{ patientId=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag;
				
				}
							if ( ('<%=dateTime%>'=='9')||(patientId.value !='')){//||('<%=CP%>'=='Y') (patientId.value !='')|| )
								document.getElementById("thPatDetails").style.display='none';}
								else{ 
									
									document.getElementById("thPatDetails").style.display='inline';}
						</script>
					</tr>
					<%		
		if(!sortOrder.equals(""))
	{
		if(sortOrder.equals("asc"))
		{
			color="#FFA6A6"	;
		}	
		else
		{
			color="#FFFF00"	;
		}
		if(!sortSelection.equals(""))
		{
			if(sortSelection.equals("6"))
				thId = "anchorDateId";
			else if(sortSelection.equals("3"))
				thId = "anchorTaskType";
			else if (sortSelection.equals("5"))
			thId = "anchorTask";
			else if (sortSelection.equals("11"))
			thId = "anchorPriority";
			else if (sortSelection.equals("9"))
				thId = "anchorPatDetails";
			else if(sortSelection.equals("12"))
				thId = "anchorStatus";
	
		}
		if(!thId.equals(""))
			out.println("<script>document.all."+thId+".style.color='"+color+"'</script>");
	}

						String classValue="";						
						String taskCode ="";
						String taskTypeCode="";
						String taskDesc="";	
						String taskTypeDesc = "";
						StringTokenizer tokenColon = null;
						String remarks="";
						String performedId = "";
                       
						if(dateTime.equals(""))
						{
							for(int index=0;index < arrayDateTime.size() ;index++)	
							{
								tokenColon = new StringTokenizer((String)arrayTaskType.get(index),":");
								taskTypeDesc = tokenColon.nextToken();
								taskTypeCode = tokenColon.nextToken();
								tokenColon = new StringTokenizer((String)arrayTask.get(index),":");
								taskDesc = tokenColon.nextToken();
								taskCode = tokenColon.nextToken();
								resultType=(String)arrayResultType.get(index) == null ? "" : (String)arrayResultType.get(index);
								adminStatus = arrayOrderStatusCode.get(index).toString()==null ? "" :arrayOrderStatusCode.get(index).toString();
								resultId=(String)arrayResultId.get(index) == null ? "" : (String)arrayResultId.get(index);
								encounterId = (String)arrayEncounterId.get(index) == null ? "" : (String)arrayEncounterId.get(index);
								patientClass = (String)arrayPatientClass.get(index) == null ? "" : (String)arrayPatientClass.get(index);

								facilityId = (String)arrayFacilityId.get(index) == null ? "" : (String)arrayFacilityId.get(index);

                               
								if(index % 2 ==0) 
									classValue="QRYEVEN" ;
								else
								classValue="QRYODD";

								out.println("<tr id='rowId"+index+"'>");
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
								out.println("<td nowrap  style='background:"+tdColor+"' class='label' align='center'><B>"+(arrayTaskCategory.get(index).toString())+"</B></td>");
								/*out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");
								out.println("<td  nowrap class='"+classValue+"'>&nbsp;</td>");
								out.println("<td  nowrap class='"+classValue+"'>&nbsp;</td>");*/
								out.println("<td  nowrap class='"+classValue+"'>"+(String)arrayScheduleDateTime.get(index)+"</td>");
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
								{	out.println("resultType  "+resultType);
									if(((String)arrayStatus.get(index)).equals("Pending") && ((String)arrayApplicableYN.get(index)).equals("Y") ) 
									{
										
										if(resultType.equals(""))
										{
											out.println("<td class='"+classValue+"'><a href='javascript:' OnClick='displayToolTip(event,"+index+")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='visibility:hidden'><table id='tooltiptable"+index+"' cellpadding=3 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
										}
										else
										{
											out.println("<td class='"+classValue+"'><a href='javascript:' OnClick='displayToolTipForEvents(event,"+index+",\""+resultType+"\",\""+resultId+"\")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='25%' style='visibility:hidden'><table id='tooltiptable"+index+"' cellpadding=3 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
										}
									}else
									{
										out.println("<td class='"+classValue+"'>" + taskDesc + anchor_guideLine + "</td>");
									}
								}
								else
								{
										out.println("<td class='"+classValue+"'><a href='javascript:' OnClick='displayToolTipForEvents(event,"+index+",\""+resultType+"\",\""+resultId+"\")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='visibility:hidden'><table id='tooltiptable"+index+"' cellpadding=3 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
								}
								}
								else
								{
									out.println("<td class='"+classValue+"'>"+taskDesc + anchor_guideLine + "</td>");
								}
								out.println("<td  class='"+classValue+"'>"+(String)arrayPriority.get(index)+"</td>");

								out.println("<td  class='"+classValue+"'>" + (String)arrayStageDesc.get(index) + "</td>");
								out.println("<td  class='"+classValue+"'>" + (String)arrayPositionDesc.get(index) + "</td>");

								out.println("<td class='" + classValue + "' id='tdPatientId" + index+"'>" + (String)arrayPatDetail.get(index) + "</td>");
								if((((String)arrayStatusDesc.get(index)).equals("Performed") || ((String)arrayStatusDesc.get(index)).equals("Not Performed"))) 
								{
									out.println("<td  class='"+classValue+"' ><a href='javascript:' OnClick='displayToolTip1(event,"+index+",\"Details\")'><font color='BLUE'>"+(String)arrayStatus.get(index)+"</font></a><div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='visibility:hidden'><table id='tooltiptable"+index+"' cellpadding=3 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
								}
								else
								{
									out.println("<td class='"+classValue+"'>"+(String)arrayStatusDesc.get(index)+"</td>");
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
								out.println("</tr>");%>
								<script>		
								var ThpatientId =document.getElementById("tdPatientId"+<%=index%>);
								if(patientId.value !='')
									ThpatientId.style.display='none';
								</script>
								<%			
							}
							out.println("<input type='hidden' name='count' id='count' value='"+arrayStatus.size()+"'>");
						}
						else			
				{
							
							request.setAttribute("retArray",retArray);

							%>
			<jsp:include page="PatTaskListPopulation.jsp" flush="true"></jsp:include>
<%				}
			}
		}
	}
	catch(Exception ee)
	{
		//out.println("Exception from Patient Task List Result Page :"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
	}
	finally 
	{
		if(arrayDateTime!=null)			arrayDateTime.clear();
		if(arrayTaskType!=null)			arrayTaskType.clear();
		if(arrayTask!=null)				arrayTask.clear();
		if(arrayPriority!=null)			arrayPriority.clear();
		if(arrayPatDetail!=null)		arrayPatDetail.clear();
		if(arrayStatus!=null)			arrayStatus.clear();
		if(arrayTaskSrlNo!=null)		arrayTaskSrlNo.clear();
		if(arrayRemarks!=null)			arrayRemarks.clear();
		if(arrayPerformedId!=null)		arrayPerformedId.clear();
		if(arrayResultType!=null)		arrayResultType.clear();
		if(arrayResultId!=null)			arrayResultId.clear();
		if(arrayEncounterId!=null)		arrayEncounterId.clear();
		if(arrayPatientClass!=null)		arrayPatientClass.clear();
		if(arrayFacilityId!=null)		arrayFacilityId.clear();
		if(arrayTaskCategory!=null)		arrayTaskCategory.clear();
		if(arrayScheduleDateTime!=null)	arrayScheduleDateTime.clear();
		if(arrayOrderId!=null)			arrayOrderId.clear();
		if(arrayOrderNum!=null)			arrayOrderNum.clear();
		if(arrayPatientId!=null)		arrayPatientId.clear();
		if(arrayStatusDesc!=null)		arrayStatusDesc.clear();
		if(arrayOrderStatusCode!=null)	arrayOrderStatusCode.clear();
		if(arrayStageDesc!=null)		arrayStageDesc.clear();
		if(arrayApplicableYN!=null)		arrayApplicableYN.clear();
		if(arrayGuildeLinelength!=null)	arrayGuildeLinelength.clear();
		if(arrayPositionDesc!=null)		arrayPositionDesc.clear();
		
	
		if (retArray!=null) retArray.clear();
	}
%>
</table>
<input type='hidden' name='qs' id='qs' value='<%=request.getParameter("qs")%>'>
<input type='hidden' name='patient_class' id='patient_class' value='<%=request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class")%>'>
<script>
if("<%=flagString1%>" == '')
{
	if("<%=flagString%>" != '')
	{
		var PatientId ='';

		if(parent.patTaskListCriteriaFrame)
			PatientId=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag.value
		
		if(PatientId == '')
		{
			if(parent.document.getElementById("patTaskListFrameSet").rows=='21%,0%,0%,*,0%,5%' ){
				parent.document.getElementById("patTaskListFrameSet").rows = '21%,0%,*,0%,0%,5%'
				}
			else
			{parent.document.getElementById("patTaskListFrameSet").rows = '21%,0%,0%,*,0%,5%' 
				}

		}
		else
		{
			if(parent.document.getElementById("patTaskListFrameSet").rows=='17%,0%,0%,*,0%,5%' )
			{
				
				parent.document.getElementById("patTaskListFrameSet").rows = '17%,0%,*,0%,0%,5%'
			}
			else
			{
				
				parent.document.getElementById("patTaskListFrameSet").rows = '17%,0%,0%,*,0%,5%' 
			}
		}
	}
	else
	{
		var PatientId ='';

		if ('<%=CP%>' !='Y')
		{
			if(parent.patTaskListCriteriaFrame)
				PatientId=  parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag.value;

			if(PatientId=='')
			{
				
				parent.document.getElementById("patTaskListFrameSet").rows='36%,0%,0%,*,0%,5%' 
			}
			else
			{	
				parent.document.getElementById("patTaskListFrameSet").rows='36%,0%,0%,*,0%,5%' 
			}
		}
	}
}
else
{
	var PatientId = '';

	PatientId=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag.value
		
	if(PatientId == '')
	{
		if(parent.document.getElementById("patTaskListFrameSet").rows=='21%,0%,0%,*,0%,5%' )
		{	
			parent.document.getElementById("patTaskListFrameSet").rows = '21%,0%,*,0%,0%,5%'
			}
		else
		{
		parent.document.getElementById("patTaskListFrameSet").rows = '36%,0%,0%,*,0%,5%' //21
		}
	}
	else
	{
		if(parent.document.getElementById("patTaskListFrameSet").rows=='17%,0%,0%,*,0%,5%' )
		{
			parent.document.getElementById("patTaskListFrameSet").rows = '36%,0%,*,0%,0%,5%'
		}
		else
		{	
			parent.document.getElementById("patTaskListFrameSet").rows = '36%,0%,0%,*,0%,5%' 
		}
	}

	if(parent.patTaskListCriteriaFrame)
		parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.flagString1.value=''
}

if(parent.patTaskListCriteriaFrame)
	parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.search.disabled=false
</script>
<%

%>
</body>
</html> 

