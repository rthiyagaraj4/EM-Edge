<!DOCTYPE html>
<html>
<%@page import="eOT.*, eOT.Common.*,eCommon.Common.*, eCommon.Common.CommonBean,eOT.PatientStatusBean" contentType="text/html;charset=UTF-8" %>
<%
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	int refreshCount = PatientStatusBean.getAutoRefreshTime(facilityId);
%>
<% response.addHeader("Refresh",refreshCount + ""); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<head>
	<meta charset="utf-8" /> 
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<head>


	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<Script src="../../eOT/js/jquery-latest.js" language="JavaScript"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel="stylesheet" href="../../eOT/html/disstyle.css" type="text/css" media="screen, projection" />
	<style type="text/css">
		#divWidth
		{
			width: 400px;
			margin-left: auto;
			margin-right: auto;
		}
	</style>
	<script>
		$(document).ready(function(){
			$(window).load(function(){
				var detheight = parseInt($(window).height())- (parseInt($(".header").height())+ parseInt($(".footer").height())); 
				$(".detailslot").css("height", detheight);
			});
			$(window).resize(function(){
				var detheight = parseInt($(window).height())- (parseInt($(".header").height())+ parseInt($(".footer").height())); 
				$(".detailslot").css("height", detheight);
			});
		});
		
	function submitPrevNext(from, to)
	{
		var param = "from="+parseInt(from)+
		"&to="+parseInt(to);
		window.location.href = '../../eOT/jsp/PatientCurrentStatusMenu.jsp?'+param;
	}		
	
	function start()
	{
		var dateTime = getCurrentDate("DMYHMS","<%=locale%>");
		var dateTimeArray = dateTime.split(" ");
		document.getElementById("dateDiv").innerHTML = dateTimeArray[0];
		var timeSecArray = dateTimeArray[1].split(":");
		document.getElementById("timeDiv").innerHTML = timeSecArray[0] + ":" + timeSecArray[1];
		document.getElementById("secDiv").innerHTML = ":" + timeSecArray[2];
		timer=setTimeout("start()",1000);
	}
	function CodeArrest() 
	{
	    if((window.event.button == 1) || (window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) 
		{
	        alert("Welcome to eHIS");
	    }
	}
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
	</script>
</head>

<%
	
	HashMap scheduled_case_details = new HashMap();
	LinkedHashMap detailMap = new LinkedHashMap();
	String colourAndDesc = "";
	String params = request.getQueryString();
	ArrayList displayResultList = new ArrayList(Arrays.asList(params.split(",")));
	if(params != null && params.trim().length() > 0)
	{
		for(int i=0; i<displayResultList.size(); i++)
		{
			colourAndDesc = (String)displayResultList.get(i);
			//System.out.println("==colourAndDesc=="+colourAndDesc);
			String[] colourAndDescArr = colourAndDesc.split("~~");
			//System.out.println("===colourAndDescArr==0=="+colourAndDescArr[0]);
			//System.out.println("===colourAndDescArr==1=="+colourAndDescArr[1]);
			detailMap.put(colourAndDescArr[0], colourAndDescArr[1].replaceAll("%20", " ").replaceAll("%26", "&"));
		}
	}
	String bean_id = "SlateBean";
	String bean_name	= "eOT.SlateBean";
	SlateBean bean = (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	bean.clear();
	String statusBeanId = "PatientStatusBean";
	String statusBeanName = "eOT.PatientStatusBean";
	String fromMenu = request.getParameter("fromMenu");
	PatientStatusBean statusBean = (PatientStatusBean)mh.getBeanObject( statusBeanId, request, statusBeanName );
	int patientCount = 0;
	//get the Page No from the Session
	
	/*
		First time the page is loaded 
	*/
	
	if(statusBean.getCurrentPageNo() == 0 )
	{
		statusBean.clear();
		patientCount = bean.getPatientCount(facilityId);
		statusBean.populateInformation(patientCount);
	}
	
	Map<String,Integer> pageInfoMap = statusBean.getCurrentPageInformation();
	
	int from = pageInfoMap.get("FROM");
	int to = pageInfoMap.get("TO");
	HashMap patientCurrentStatusMap = bean.patientCurrentStatus(from + "", to + "", facilityId, detailMap);
	String sysDateTime = bean.getSysDateTime();
	
%>

<body OnMouseDown='CodeArrest()' onkeypress="closeHelp()">

		
		<div class="detailslot">
			<div class="columnone_slotone" >
				<div class="nobgdetailpanel">
					<div class="rdcheader">
						<div class="stftext">Patient Current Status</div>
					</div>
<table>
<%
	int z = 0;
		for(int j=0; j<5 && z < patientCurrentStatusMap.size(); j++)
		{
%>
				<tr>
<%
			for(int k=0; k<3 && z < patientCurrentStatusMap.size() ; k++)
			{
				scheduled_case_details = (HashMap)patientCurrentStatusMap.get(z);
				String image = CommonBean.checkForNull((String)scheduled_case_details.get("imageicon"));
				String unSchedColorCode = "";
				String prevDay = (String)scheduled_case_details.get("PREV_DAY");
				if("0".equals((String)scheduled_case_details.get("IS_SCHD")))
				{
					//unSchedColorCode = "style='background-color:#FF0000'";
					unSchedColorCode = "";
				}
%>
					<td width="32%">
						<div class="pstatuspanelbg">
							<div class="pstatusinfopanel">
								<div class="patientifostrip" id="divWidth">
									<div class="pstripleft">
										<div class="pinfoheaderstrip">
											<div class="pstripinfoid"  <%= unSchedColorCode %>><%=CommonBean.checkForNull((String)scheduled_case_details.get("PATIENT_ID"))%></div>
										</div>
										<div class="pstripgender"><%=CommonBean.checkForNull((String)scheduled_case_details.get("SEX"))%></div>
										<div class="pstripgender"><%=CommonBean.checkForNull((String)scheduled_case_details.get("CURRENT_LOCN"))%></div>
									</div>
									<div class="pstripright" >
										<div id="inbutton" style='background-color:<%= (String)scheduled_case_details.get("COLOR_CODE")%>'> </div>
										<div class="tablestrip">
											<div class="pstripstatus" ><%=CommonBean.checkForNull((String)scheduled_case_details.get("STATUS"))%></div>
											<!-- Added for IN:44800-->
											<%
											if("0".equals((String)scheduled_case_details.get("IS_SCHD")))
												{
													unSchedColorCode = "";
											%>											
											<div class="pstripinfoid" style='color:#FF0000' <%= unSchedColorCode %>>Unscheduled</div>
											<%
											}
											%>
										<!-- End  for IN:44800--->
									<%
										if("1".equals(prevDay))
										{
									%>
											<div class="pstripstatus">Previous Day Booking</div>
									<%
										}
									%>		
										</div>
									</div>
								</div>
							</div>
						</div>
					</td>
<%
			z++;
			}
%>
					</tr>
<%
		}
//	}
%>
</table>
					<div class="pagination" >
						
					<%
						String span1Class = "";
						String span2Class = "";
						String span3Class = "";
						if(pageInfoMap.get("PAGE_NO_1") == pageInfoMap.get("CURRENT_PAGE"))
						{
							span1Class = "selectedpage";
							span2Class = "unselectedpage";
							span3Class = "unselectedpage";
						}
						else if(pageInfoMap.get("PAGE_NO_2") == pageInfoMap.get("CURRENT_PAGE"))
						{
							span2Class = "selectedpage";
							span1Class = "unselectedpage";
							span3Class = "unselectedpage";
						}
						else if(pageInfoMap.get("PAGE_NO_3") == pageInfoMap.get("CURRENT_PAGE"))
						{
							span3Class = "selectedpage";
							span1Class = "unselectedpage";
							span2Class = "unselectedpage";
						}
						int pageNo2 = pageInfoMap.get("PAGE_NO_2");
						int pageNo3 =  pageInfoMap.get("PAGE_NO_3");
					%>
						<span class="<%=span1Class%>"><%=pageInfoMap.get("PAGE_NO_1") %></span>
					<%
						if(statusBean.getNoOfPages() >= pageNo2)
						{
					%>	
						<span class="<%=span2Class%>"><%=pageInfoMap.get("PAGE_NO_2") %></span>
					<%
						}
						if(statusBean.getNoOfPages() >= pageNo3)
						{
					%>	
						<span class="<%=span3Class%>"><%=pageInfoMap.get("PAGE_NO_3") %></span>
					<%
						}
					%>	
						
					</div>
				</div>
			</div>

			</div>

</body>
</html>

