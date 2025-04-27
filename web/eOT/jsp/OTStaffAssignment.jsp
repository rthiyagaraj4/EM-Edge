<!DOCTYPE html>
<%-- JSP Page specific attributes start  --%>
<%@ page import=  "java.sql.Connection,
				java.sql.PreparedStatement,
				java.sql.Statement,
				java.sql.ResultSet,
				webbeans.eCommon.ConnectionManager,
				eCommon.Common.CommonBean,
				eOT.*,
				eOT.Common.*,
				eOT.OTStaffAssignBean,
				java.util.ArrayList,
				java.util.HashMap" 
%>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page import ="java.text.SimpleDateFormat,java.util.Date" %>  
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<head>
	<meta charset="utf-8" />
		<title> Operation Theatre - 3 slot display </title>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<link rel="stylesheet" href="../../eOT/html/style.css" type="text/css" media="screen, projection" /> </link>
		<link rel="StyleSheet" type="text/css" href="../../eOT/html/style.css"></link>
		<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function closeHelp()
		{ 
		    var key = event.keyCode; 
			if (key == 27)
			{
				if(parent.parent.opener != null)
				 {
					parent.parent.opener.closeDashboard();
				 }
				else
				  {
					 window.close();	
				  }
			}
		} 	
			function displayRoomCode(roomCode)
			{
				var labelRoomCode = getLabel("eOT.OperationRoom.Label","OT") + " : " + roomCode;
				document.getElementById("roomCodeId").innerHTML = labelRoomCode;
			}
		</script>
</head> 
<%
	int from = 0; 
	int to = 0;	
	int z=0;
	int x=0;
	int autoRefreshTime = 0;
	int screenHeight = 0;
	int screenWidth = 0;
	String refreshIntervalId = request.getParameter("refreshIntervalId") == null ? "" : request.getParameter("refreshIntervalId");
	String intervalId = request.getParameter("intervalId") == null ? "" : request.getParameter("intervalId");
	if(intervalId != null && intervalId.indexOf("~") != -1)
		intervalId = intervalId.substring(0, intervalId.indexOf("~"));
	String staffAssignmentId = request.getParameter("staffAssignmentId") == null ? "" : request.getParameter("staffAssignmentId");
	String frameName = request.getParameter("frameName") == null ? "" : request.getParameter("frameName");
	String chkedValues = request.getParameter("chkedValues") == null ? "" : request.getParameter("chkedValues");
	String allCount = request.getParameter("allCount") == null ? "" : request.getParameter("allCount");
	String roomCount = request.getParameter("roomCount") == null ? "" : request.getParameter("roomCount");
	String staffAssignment = request.getParameter("staffAssignment") == null ? "" : request.getParameter("staffAssignment");
	String bean_id	 = "OTStaffAssignBean_" + frameName;
	String bean_name = "eOT.OTStaffAssignBean";
	OTStaffAssignBean bean	 = (OTStaffAssignBean)mh.getBeanObject( bean_id, request, bean_name );
	String statusBeanId = "StaffAssignmentBean_" + frameName;
	String statusBeanName = "eOT.StaffAssignmentBean";
	String fromMenu = request.getParameter("fromMenu");
	StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)mh.getBeanObject( statusBeanId, request, statusBeanName );
	if((allCount != null && allCount.trim().length() > 0 && Integer.parseInt(allCount) == 0) || (roomCount != null && roomCount.trim().length() > 0 && Integer.parseInt(roomCount) == 0))
		staffAssignmentBean.NO_OF_PATIENTS = 10;
	else
		staffAssignmentBean.NO_OF_PATIENTS = 5;
//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	screenHeight = screenSize.height;
//	screenWidth = screenSize.width;
// 	Map<String, List<OTStaffAssignBean>> staffMap = bean.getAssignedStaffDtls(frameName, chkedValues, String.valueOf(from), String.valueOf(to));
	if(intervalId != null && intervalId.equalsIgnoreCase("SS"))
		autoRefreshTime = Integer.parseInt(refreshIntervalId);
	else if(intervalId != null && intervalId.equalsIgnoreCase("MM"))
		autoRefreshTime = Integer.parseInt(refreshIntervalId) * 60;
	response.setIntHeader("Refresh", autoRefreshTime);
	String locale = (String)session.getAttribute("LOCALE");
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	Date todaysDate = new Date();
	String formatedDate = dateFormat.format(todaysDate);
	String formatedTime = timeFormat.format(todaysDate);
    String minuteFormat = formatedTime.substring(0, formatedTime.lastIndexOf(':'));
    String secondFormat = formatedTime.substring(formatedTime.lastIndexOf(':')+1, formatedTime.length());
	String roomCode = null;
	String roomCodeKey = null;
	List staffdetailsList = new ArrayList();
	List roomCodesList = new ArrayList();
	OTStaffAssignBean otStaffBean = new OTStaffAssignBean();
	int staffAssignedCount = 0;
	String tempRoomCode = "";
	String dyc = request.getParameter("dyc");
	String dyc_class1 = "";
	String dyc_class2 = "";
	String dyc_height = ""; 	
	String dyc_height1 = ""; 	
	if(dyc.equals("y"))
	{
		dyc_class1	= "detailpaneldh";
		dyc_class2	= "staffinfopaneldh";
	}
	else
	{
		dyc_class1	= "detailpanel";
		dyc_height	= "height:99%;";
		if(staffAssignment.equalsIgnoreCase("Y"))
			dyc_height1	= "height:73%";
		else
			dyc_height1	= "height:88%";
		dyc_class2	= "staffinfopanel";
	}
%>

<body  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onkeypress="closeHelp()">
<div class="detailslot" >
			<div class="columnone_slotone">
				<div class="<%=dyc_class1%>" style="overflow:hidden;<%=dyc_height%>"  >
<%
				if(staffAssignment != null && staffAssignment.equalsIgnoreCase("Y"))
				{
%>
					<div class="rdheadercontainer">
							<div class="rdcheaderleft"></div>
							<div class="rdcheader">
								<div class="stftext"><fmt:message key="eOT.StaffAssignment.Label" bundle="${ot_labels}"/></div>
							</div>
							<div class="rdcheaderright"></div>
					</div>
<%
				}
						Map<String, List<OTStaffAssignBean>> staffMap = bean.getAssignedStaffDtls(frameName, chkedValues, "", "");
%>
						<div class="<%=dyc_class2%>" style="<%=dyc_height1%>">
							<div class="staffinfodetail">
								<div class="sinfoheader">
									<div class="sinfoheaderleft"></div>
									<div class="staffroominfo" id='roomCodeId'></div>
									<div class="sinfoheaderright"></div>
								</div>
								<div class="ribbonbg"></div>
								<div class="detailscontainer">
									<div class="detailholder"> 
<%
							if(staffMap != null && staffMap.size() > 0)
							{
								staffdetailsList = staffMap.get("STAFFDETAILS");
											if(staffAssignmentBean.totalPatients != staffdetailsList.size())
											{
												staffAssignmentBean.setCurrentPageNo(0);
												staffAssignmentBean.lisIterCount = 0;
												staffAssignmentBean.roomCountPagination = 0;
											}
								staffAssignmentBean.totalPatients = staffdetailsList.size();
								if(staffAssignmentBean.lisIterCount >= staffAssignmentBean.totalPatients)
								{
									staffAssignmentBean.lisIterCount = 0;
									staffAssignmentBean.roomCountPagination = 0;
								}
								roomCodesList = staffMap.get("ROOMCODES");
								System.out.println("=====staffAssignmentBean.getCurrentPageNo()====="+staffAssignmentBean.getCurrentPageNo());
								if(staffAssignmentBean.getCurrentPageNo() == 0 )
								{
									staffAssignmentBean.clear();
									roomCode = "'"+(String)roomCodesList.get(staffAssignmentBean.roomCountPagination)+"'";
									staffAssignedCount = bean.getAssignedStaffDtlsAllCount("Room", roomCode);
									System.out.println("====staffAssignedCount===="+staffAssignedCount);
									staffAssignmentBean.populateInformation(staffAssignedCount);
								}
								Map<String,Integer> pageInfoMap = staffAssignmentBean.getCurrentPageInformation();
								from = pageInfoMap.get("FROM");
								to = pageInfoMap.get("TO");
								System.out.println("======from======"+from);
								System.out.println("======to======"+to);
								System.out.println("====roomCodesList===="+roomCodesList);
								System.out.println("===staffdetailsList==before===="+staffdetailsList);
								System.out.println("===staffAssignmentBean.lisIterCount==before===="+staffAssignmentBean.lisIterCount);
								for(int y=0; y<staffAssignmentBean.lisIterCount; y++)
								{
									System.out.println("===y==before===="+y);
									staffdetailsList.remove(0);
									System.out.println("===staffdetailsList==forrrr===="+staffdetailsList);
								}
											for(z=0,x=0; z<staffdetailsList.size()&&x<staffAssignmentBean.NO_OF_PATIENTS; z++,x++)
								{
									otStaffBean = (OTStaffAssignBean)staffdetailsList.get(z);
									System.out.println("=====otStaffBean===="+otStaffBean);
									if(tempRoomCode.equals(otStaffBean.getStrRoomCode()) || tempRoomCode.trim().length() == 0)
									{
													out.println("<script>displayRoomCode('"+otStaffBean.getStrRoomDesc()+"')</script>");
										staffAssignmentBean.lisIterCount++;
										tempRoomCode = otStaffBean.getStrRoomCode();
%>
										<div class="detailstrip" style="height:8vhpx;overflow:hidden;">
												<div class="floatleft">
													<div class="dstrip">
														<span class="fontblue"><%=CommonBean.checkForNull((String)otStaffBean.getStrStaffShortName())%></span> <br/>
														<span class="fontitalic"><%=CommonBean.checkForNull((String)otStaffBean.getStrRoleDesc())%>	</span>
													</div>
												</div>
											<div class="floatright" >
												<div class="dstrip" style="width:100%">
												<span class="fontnormal"><%=CommonBean.checkForNull((String)otStaffBean.getStrFromTime())%>	- <%=CommonBean.checkForNull((String)otStaffBean.getStrToTime())%></span>
												</div>
											</div>
										</div>
<%
													if(z == staffdetailsList.size()-1)
													{
														staffAssignmentBean.setCurrentPageNo(0);
														staffAssignmentBean.roomCountPagination++;
													}
													if(x == staffAssignmentBean.NO_OF_PATIENTS-1 && staffdetailsList.size() > staffAssignmentBean.NO_OF_PATIENTS)
													{
														otStaffBean = (OTStaffAssignBean)staffdetailsList.get(z+1);
														if(!tempRoomCode.equals(otStaffBean.getStrRoomCode()))
														{
															staffAssignmentBean.setCurrentPageNo(0);
															staffAssignmentBean.roomCountPagination++;
														}
													}
									}
									else
									{
										staffAssignmentBean.setCurrentPageNo(0);
										staffAssignmentBean.roomCountPagination++;
										break;
									}
								}
%>
<br />
	</div>
								</div>
								<div class="staffpagination"  >
<%
										if(x < staffAssignmentBean.NO_OF_PATIENTS)
											to = staffAssignmentBean.staffCountRoom;
%>
										<span class="staffcountdisplay"><%=from%> - <%=to%> Of <%=staffAssignmentBean.staffCountRoom%></span>
								<span style="float:left; ">
<%
							System.out.println("===pageInfoMap===OTStaffAssignment==="+pageInfoMap);
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
							if(staffAssignmentBean.getNoOfPages() >= pageNo2)
							{
%>
								<span class="<%=span2Class%>"><%=pageInfoMap.get("PAGE_NO_2") %></span>
<%
							}
							if(staffAssignmentBean.getNoOfPages() >= pageNo3)
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
%>
							</div>
							</div>
						</div>
				</div>
			</div>
		</div>
</body>
</html>
	

