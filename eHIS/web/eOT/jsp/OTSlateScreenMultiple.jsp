<!DOCTYPE html>
<html>
<%-- JSP Page specific attributes start  --%>
<%@ page import ="eOT.OT_Slate_Bean,java.util.*,java.util.HashMap, java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.*,eOT.Common.*" %>  
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<head>
<meta charset="utf-8" />
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link rel="stylesheet" href="../../eOT/html/style.css" type="text/css" media="screen, projection" /> </link>
	<script>
		function displayRoomDetails(roomCode, fromTime, toTime, bookingCount)
		{
			var labelTimeDet = '';
			var labelRoomCode = getLabel("eOT.OperationRoom.Label","OT") + " : " + roomCode;
			var labelBookings = getLabel("eOT.Bookings.Label","OT") + " " + bookingCount;
			if(fromTime != '')
				labelTimeDet = " - " + fromTime + " to " + toTime;
			document.getElementById("roomCodeId").innerHTML = labelRoomCode; //IN047845
			document.getElementById("bookingCountTime").innerHTML = labelBookings + labelTimeDet;
		}
	</script>
</head>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<link rel="StyleSheet" type="text/css" href="../../eOT/html/style.css"></link>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script>
	function closeHelp()
		{ 
		    var key = event.keyCode; 
			if (key == 27)
			{
				if(parent.parent.opener != null)
					parent.parent.opener.closeDashboard();
				else
					 window.close();	
			}
		} 	
</script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int fetchCount=0;
	int Count=0;
	String from_time="";
	String strToTime="";
	String strRoomCode="";
	String str_append="rs";
	int duration=0;
	int from = 0; 
	int to = 0;	
	int z=0;
	int x=0;
	int patientsCount = 0;
	int autoRefreshTime = 0;
	int frameCountStyle = 0;
	int bookingCount = 0;
	int noOfPatients = 0;
	List beanList = new ArrayList();
	List roomCodesList = new ArrayList();
	String roomCode = "";
	String tempRoomCode = "";
	String roomCodeForCnt = "";
	String chkedValuesTempCode = "";
	String fromTime = "";
	String toTime = "";
	String  auto_refresh="";
	String refresh_interval="";
	String operDuration = "";
	String operDurationHr = "";
	int operDurationMin = 0;
	String  refresh_interval_time="";
	String operTime = "";
	int operHr = 0;
	int operMin = 0;
	String anestStaffName = "";
	String nurseStaffName = "";
	LinkedHashMap<String,String> facilityMap = null;
	String tempCode = "";
	int totalmin = 0;
	int splhours = 0;
	int splmin = 0;	
	String ClassStyle = "";
	String unSchedStatus = "";
	String unSchedColorCode = "";
	String str_comma = ",";
	String caseType = "";
try 
{
	String fromMenu = request.getParameter("fromMenu") == null ? "" : request.getParameter("fromMenu");
	String room_no = request.getParameter("room_no") == null ? "" : request.getParameter("room_no");
	String room_name = request.getParameter("room_name") == null ? "" : request.getParameter("room_name");
	String roomDispCalc = request.getParameter("roomDispCalc") == null ? "" : request.getParameter("roomDispCalc");
	String frameCount = request.getParameter("frameCount") == null ? "1" : request.getParameter("frameCount");
	if(roomDispCalc != null && roomDispCalc.equals("3"))
		frameCount = "3";
	else
		frameCount = "2";
	String staffAssignmentId = request.getParameter("staffAssignmentId") == null ? "" : request.getParameter("staffAssignmentId");
	String refreshIntervalId = request.getParameter("refreshIntervalId") == null ? "" : request.getParameter("refreshIntervalId");
	String intervalId = request.getParameter("intervalId") == null ? "" : request.getParameter("intervalId");
	String roomDispVals = request.getParameter("roomDispVals") == null ? "" : request.getParameter("roomDispVals");
	String frameName = request.getParameter("frameName") == null ? "" : request.getParameter("frameName");
	if(intervalId != null && intervalId.equalsIgnoreCase("SS"))
		autoRefreshTime = Integer.parseInt(refreshIntervalId);
	else if(intervalId != null && intervalId.equalsIgnoreCase("MM"))
		autoRefreshTime = Integer.parseInt(refreshIntervalId) * 60;
	response.setIntHeader("Refresh", autoRefreshTime);

	String statusBeanId = "PatientRoomStatusBeanMultiple_" + frameName;
	OT_Slate_Bean otSlateBean = new OT_Slate_Bean();
	OT_Slate_Bean dataListVal = new OT_Slate_Bean();
	String statusBeanName = "eOT.PatientRoomStatusBean";
	PatientRoomStatusBean patientRoomStatusBean = (PatientRoomStatusBean)mh.getBeanObject( statusBeanId, request, statusBeanName );
	String bean_id	 = "OT_Slate_BeanMultiple_" + frameName;
	String bean_name = "eOT.OT_Slate_Bean";
	OT_Slate_Bean bean = (OT_Slate_Bean)mh.getBeanObject( bean_id, request, bean_name );
	String bean_id1	 = "OTWidgetSelectionBean";
	String bean_name1 = "eOT.OTWidgetSelectionBean";
	OTWidgetSelectionBean bean1	 = (OTWidgetSelectionBean)mh.getBeanObject( bean_id1, request, bean_name1 );
	facilityMap =bean1.getSurgeryTypeDtls();
	frameCountStyle = Integer.parseInt(frameCount);
	if(staffAssignmentId != null && staffAssignmentId.equalsIgnoreCase("Y"))
		frameCountStyle = Integer.parseInt(frameCount) + 1;
	String Class_Multi_Single = frameCountStyle==1 ? "singlecol_patientinfopanel" : "patientinfopanel";
	if(frameCount != null && frameCount.equals("1") && frameCountStyle==1)
		patientRoomStatusBean.NO_OF_PATIENTS = 6;
	else
		patientRoomStatusBean.NO_OF_PATIENTS = 3;

	ArrayList<OT_Slate_Bean> dataList = new ArrayList();
	Map<String, List<OT_Slate_Bean>> beanMap = bean.getBookingDtls(roomDispVals, "", "");
	ArrayList allChkedValuesList = new ArrayList(Arrays.asList(roomDispVals.split(",")));
	ArrayList chkedValuesList = new ArrayList();
	for(int i=0; i<allChkedValuesList.size(); i++)
	{
		tempCode = (String)allChkedValuesList.get(i);
		chkedValuesList.add(tempCode.substring(1, tempCode.length() - 1));
	}
	if(beanMap == null || beanMap.size() == 0)
		beanMap.put("ROOMDETAILS", new ArrayList());
%>
<body  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'  onkeypress="closeHelp()" >
	<div class="detailslot">
		<div id="div_dynamic_height">
			<div class="<%=request.getParameter("class")%>, slotex">
				<div class="detailpanel" >
					<div class="roomdetailcontainer" >

						<div id='showHide' class="rdheadercontainer">
							<div class="rdcheaderleft"></div>
							<div class="rdcheader">
								<div class="hdtext" id='roomCodeId'></div>
								<div class="bookingtext"id='bookingCountTime'></div>
							</div>
							<div class="rdcheaderright"></div>
						</div>
<%
	if(beanMap != null && beanMap.size() > 0)
	{
		beanList = beanMap.get("ROOMDETAILS");
		if(patientRoomStatusBean.totalPatients != beanList.size() && (beanList != null && beanList.size() > 0))
		{
			patientRoomStatusBean.setCurrentPageNo(0);
			patientRoomStatusBean.lisIterCount = 0;
			patientRoomStatusBean.roomCountPagination = 0;
		}
		patientRoomStatusBean.totalPatients = beanList.size();
		if(patientRoomStatusBean.lisIterCount >= patientRoomStatusBean.totalPatients && (beanList != null && beanList.size() > 0))
		{
			patientRoomStatusBean.lisIterCount = 0;
			patientRoomStatusBean.roomCountPagination = 0;
		}
		if(patientRoomStatusBean.roomCountPagination > chkedValuesList.size() - 1)
			patientRoomStatusBean.roomCountPagination = 0;

		roomCodesList = beanMap.get("ROOMCODES");
		if(chkedValuesList != null && chkedValuesList.size() > 0)
			chkedValuesTempCode = (String)chkedValuesList.get(patientRoomStatusBean.roomCountPagination);
		if(roomCodesList != null && roomCodesList.contains(chkedValuesTempCode))
		{
		if(patientRoomStatusBean.getCurrentPageNo() == 0)
		{
			patientRoomStatusBean.clear();
			roomCodeForCnt = (String)chkedValuesList.get(patientRoomStatusBean.roomCountPagination);
			dataList = bean.getBookingDtlsCount(roomCodeForCnt);
			dataListVal = (OT_Slate_Bean)dataList.get(0);
				if(dataListVal.getTotalBookingCount() != null && dataListVal.getTotalBookingCount().trim().length() > 0)
			bookingCount = Integer.parseInt(dataListVal.getTotalBookingCount());
				else
					bookingCount = 0;
			patientRoomStatusBean.bookingCntDisp = bookingCount;
			fromTime = dataListVal.getStrFromTime();
			toTime = dataListVal.getStrToTime();
			if(fromTime == null || fromTime.trim().length() == 0)
				fromTime = "";
			if(toTime == null || toTime.trim().length() == 0)
				toTime = "";
			patientRoomStatusBean.fromTimeDisp = fromTime;
			patientRoomStatusBean.toTimeDisp = toTime;
			patientRoomStatusBean.populateInformation(bookingCount);
		}
		Map<String,Integer> pageInfoMap = patientRoomStatusBean.getCurrentPageInformation();
		from = pageInfoMap.get("FROM");
		to = pageInfoMap.get("TO");
		for(int y=0; y<patientRoomStatusBean.lisIterCount; y++)
			beanList.remove(0);
		String staffAnesthPopulateRoomCode = (String)chkedValuesList.get(patientRoomStatusBean.roomCountPagination);
		List<OT_Slate_Bean> beanList1 = bean.getAnaesthetistDtls(staffAnesthPopulateRoomCode);
		List<OT_Slate_Bean> beanList2 = bean.getStaffDtls(staffAnesthPopulateRoomCode);
%>
					<div class="rdccontent">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="pinfoname trancolor">
							<tr>
								<td>
									<marquee direction="up" scrollamount="2" height="50" > 
<%
										for(OT_Slate_Bean getAnaesthetistdtl : beanList1) 
										{
											if(anestStaffName != null && !anestStaffName.equals(getAnaesthetistdtl.getRoleTypeDescSysDef()))
											{
												anestStaffName = getAnaesthetistdtl.getRoleTypeDescSysDef();
%>
												<%=getAnaesthetistdtl.getRoleTypeDescSysDef()%><br/>
<%
											}
%>
											<%=getAnaesthetistdtl.getStrSurgeon()%><br/>
<%
										}
%>
									</marquee>
								</td>
								<td>
									<marquee direction="up" scrollamount="2"   height="50" >
<%
										for(OT_Slate_Bean getStaffDtls : beanList2) 
										{
											if(nurseStaffName != null && !nurseStaffName.equals(getStaffDtls.getRoleTypeDescSysDef()))
											{
												nurseStaffName = getStaffDtls.getRoleTypeDescSysDef();
%>
												<%=getStaffDtls.getRoleTypeDescSysDef()%><br/>
<%
											}
%>
											<%=getStaffDtls.getStrStaff()%><br/>
<%
										}
%>
									</marquee>
								</td>
							</tr>
						</table>
					</div>
<%
		for(z=0,x=0; z<beanList.size()&&x<patientRoomStatusBean.NO_OF_PATIENTS; z++,x++)
		{
			otSlateBean = (OT_Slate_Bean)beanList.get(z);
			roomCode = (String)otSlateBean.getStrOperRoomCode();
			if(tempRoomCode.equals(roomCode) || tempRoomCode.trim().length() == 0)
			{
				out.println("<script>displayRoomDetails('"+facilityMap.get(roomCode)+"','"+patientRoomStatusBean.fromTimeDisp+"','"+patientRoomStatusBean.toTimeDisp+"','"+patientRoomStatusBean.bookingCntDisp+"')</script>");
				patientRoomStatusBean.lisIterCount++;
				tempRoomCode = roomCode;
				operTime = CommonBean.checkForNull((String)otSlateBean.getStrOperNum());
				if(operTime != null && operTime.trim().length() > 0 && operTime.indexOf(":") != -1)
				{
					if(operTime.contains(","))
					{	
							totalmin = 0;
						String[] splits = operTime.split(",");
						for(int spltime=0; spltime<splits.length; spltime++)
						{
								splhours = 0;
								splmin = 0;	
							String asset=splits[spltime];		
							splhours = Integer.parseInt(asset.substring(0, asset.indexOf(":")));
							if(splhours > 0)
								splhours = splhours * 60;
							totalmin =totalmin+Integer.parseInt(asset.substring(asset.indexOf(":") + 1, asset.length())) + splhours;
						}
						operMin=totalmin;
					}
					else
					{
						operHr = Integer.parseInt(operTime.substring(0, operTime.indexOf(":")));
						if(operHr > 0)
							operHr = operHr * 60;
						operMin = Integer.parseInt(operTime.substring(operTime.indexOf(":") + 1, operTime.length())) + operHr;
					}
				}
					ClassStyle = "";
					unSchedStatus = "";
					unSchedColorCode = "";
					str_comma = ",";
					caseType = CommonBean.checkForNull((String)otSlateBean.getCaseType());
%>
				<div class="<%=Class_Multi_Single%>">
					<div class="patientinfodetail">
						<div class="patientinfoheader">
							<div class="distable">
								<div class="disrow">
									<div class="discellleft">
										<div class="pribbonhead">
											<div class="bgsss"></div>
											<div class="bgscolor">
												<div class="infoid"><%=CommonBean.checkForNull((String)otSlateBean.getStrPatientID())%></div>
												<div class="infotime"><%=CommonBean.checkForNull((String)otSlateBean.getStrFromTime())%>-<%=CommonBean.checkForNull((String)otSlateBean.getStrToTime())%></div>
											</div>
											<div class="bgsstrip"></div>
										</div>
									</div>
									<div class="discellright">
										<div class="distablefix">
											<div class="disrow">
												<div class="statustext">
													<div class="alignrighttext"><%=CommonBean.checkForNull((String)otSlateBean.getStrDisplayStatus())%></div>
												</div>
												<div class="statustextat">
<%
													if((String)otSlateBean.getStrDisplayTime() != null && ((String)otSlateBean.getStrDisplayTime()).trim().length() > 0)
													{
%>
														at <%=CommonBean.checkForNull((String)otSlateBean.getStrDisplayTime())%>
<%
													}
%>
												</div>
											<div class="inbutton" style="background-color:<%=CommonBean.checkForNull((String)otSlateBean.getStrColorCode())%>"></div>
										</div>
									</div>
<%
									if(caseType.equals("0"))
									{
										ClassStyle="";
										unSchedStatus = "UnScheduled";		
										unSchedColorCode = "style='color:#FF0000'";		
%>
										<div class="distablefix" >
											<div class="disrow" >
												<div class="statustext">
													<div class ='alignrighttext' >
														<div class ="new" <%=unSchedColorCode%>><%=unSchedStatus%></div> 
													</div>	
												</div>	
											</div>
										</div>
<%
									}	
%>
								</div>
							</div>
						</div>
					</div>
					<div class="patientdetail">
						<div class="pinfoname"><%=CommonBean.checkForNull((String)otSlateBean.getStrPatientName())%></div>
						<div class="pinfodetail"><%=otSlateBean.getStrAge()+""+str_append%>,&nbsp;<%=CommonBean.checkForNull((String)otSlateBean.getStrGender())%>, &nbsp;<%=CommonBean.checkForNull((String)otSlateBean.getStrShortDesc())%></div>
					</div>
				</div>
				<div class="proceduredetail">
					<div class="prodetailhd"><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/> </div>
					<div class="pinfodetail"><%=CommonBean.checkForNull((String)otSlateBean.getStrOperDesc())%><br>
						<%=CommonBean.checkForNull((String)otSlateBean.getStrSurgeonName())%>
<%
						if(((String)otSlateBean.getStrSurgeonName() != null && ((String)otSlateBean.getStrSurgeonName()).trim().length() > 0) && ((String)otSlateBean.getStrAsstSurgeonOne() != null && ((String)otSlateBean.getStrAsstSurgeonOne()).trim().length() > 0))
						{
%>
							<%=str_comma%>
<%
						}
%>
						<%=CommonBean.checkForNull((String)otSlateBean.getStrAsstSurgeonOne())%>
<%
						if(((String)otSlateBean.getStrAsstSurgeonOne() != null && ((String)otSlateBean.getStrAsstSurgeonOne()).trim().length() > 0) && ((String)otSlateBean.getStrAsstSurgeonTwo() != null && ((String)otSlateBean.getStrAsstSurgeonTwo()).trim().length() > 0))
						{
%>
							<%=str_comma%>
<%
						}
%>
						<%=CommonBean.checkForNull((String)otSlateBean.getStrAsstSurgeonTwo())%></br>
					</div>
				</div>
			</div>
<% 
				if(z == beanList.size()-1)
				{
					patientRoomStatusBean.setCurrentPageNo(0);
					patientRoomStatusBean.roomCountPagination++;
				}
				if(x == patientRoomStatusBean.NO_OF_PATIENTS-1 && beanList.size() > patientRoomStatusBean.NO_OF_PATIENTS)
				{
					otSlateBean = (OT_Slate_Bean)beanList.get(z+1);
					if(!tempRoomCode.equals(roomCode))
					{
						patientRoomStatusBean.setCurrentPageNo(0);
						patientRoomStatusBean.roomCountPagination++;
					}
				}
			}
			else
			{
				patientRoomStatusBean.setCurrentPageNo(0);
				patientRoomStatusBean.roomCountPagination++;
				break;
			}
		}
		if(beanList != null && beanList.size() > 0)
		{
%>
									<div class="staffpagination">
<%
										if(x < patientRoomStatusBean.NO_OF_PATIENTS)
											to = patientRoomStatusBean.roomCount;
%>
										<span class="staffcountdisplay"><%=from%> - <%=to%> Of <%=patientRoomStatusBean.roomCount%></span>
										<span style="float:left; ">
<%
											String span1Class = "";
											String span2Class = "";
											String span3Class = "";
											if(pageInfoMap.get("PAGE_NO_1") == pageInfoMap.get("CURRENT_PAGE"))
											{
												span1Class = "selectedpagePagination";
												span2Class = "unselectedpagePagination";
												span3Class = "unselectedpagePagination";
											}
											else if(pageInfoMap.get("PAGE_NO_2") == pageInfoMap.get("CURRENT_PAGE"))
											{
												span2Class = "selectedpagePagination";
												span1Class = "unselectedpagePagination";
												span3Class = "unselectedpagePagination";
											}
											else if(pageInfoMap.get("PAGE_NO_3") == pageInfoMap.get("CURRENT_PAGE"))
											{
												span3Class = "selectedpagePagination";
												span1Class = "unselectedpagePagination";
												span2Class = "unselectedpagePagination";
											}
											int pageNo2 = pageInfoMap.get("PAGE_NO_2");
											int pageNo3 =  pageInfoMap.get("PAGE_NO_3");
%>
											<span class="<%=span1Class%>"><%=pageInfoMap.get("PAGE_NO_1") %></span>
<%
											if(patientRoomStatusBean.getNoOfPages() >= pageNo2)
											{
%>
												<span class="<%=span2Class%>"><%=pageInfoMap.get("PAGE_NO_2") %></span>
<%
											}
											if(patientRoomStatusBean.getNoOfPages() >= pageNo3)
											{
%>
												<span class="<%=span3Class%>"><%=pageInfoMap.get("PAGE_NO_3") %></span>
<%
											}
%>
										</span>
									</div>
<%
			}
		}
		else
		{
			roomCodeForCnt = (String)chkedValuesList.get(patientRoomStatusBean.roomCountPagination);
			dataList = bean.getBookingDtlsCount(roomCodeForCnt);
			dataListVal = (OT_Slate_Bean)dataList.get(0);
			if(dataListVal.getTotalBookingCount() != null && dataListVal.getTotalBookingCount().trim().length() > 0)
			bookingCount = Integer.parseInt(dataListVal.getTotalBookingCount());
			else
				bookingCount = 0;
			fromTime = dataListVal.getStrFromTime();
			toTime = dataListVal.getStrToTime();
			if(fromTime == null || fromTime.trim().length() == 0)
				fromTime = "";
			if(toTime == null || toTime.trim().length() == 0)
				toTime = "";
			out.println("<script>displayRoomDetails('"+facilityMap.get(chkedValuesTempCode)+"','"+fromTime+"','"+toTime+"','"+bookingCount+"')</script>");
			if(patientRoomStatusBean.roomCountPagination >= chkedValuesList.size() - 1)
				patientRoomStatusBean.roomCountPagination = 0;
			else
				patientRoomStatusBean.roomCountPagination++;
%>
			<div class="rdccontent">
			</div>
<%
		}
	}
%>
					</div>
			</div>
		</div>
	<div>
<div>
</body>
<%
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</html>

