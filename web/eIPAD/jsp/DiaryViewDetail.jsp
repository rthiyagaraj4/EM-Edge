<!DOCTYPE html>
<%@page import="eIPAD.DiaryView.bc.DiaryViewBC"%>
<%@page import="eIPAD.DiaryView.request.DiaryViewRequest"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ page import ="eIPAD.DiaryView.response.DiaryViewResponse" %> 
<%@page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@page import="eIPAD.DiaryView.healthobject.AppointmentBlockItem"%>
<%@page import="eIPAD.DiaryView.healthobject.AppointmentDetailItem"%>
<%@page import="eIPAD.DiaryView.healthobject.OPApptDetailItem"%>
<%@page import="eIPAD.DiaryView.healthobject.OTApptDetailItem"%>
<%@page import="eIPAD.DiaryView.healthobject.OTProcDetail"%>
<%@ page import ="eIPAD.DiaryView.response.OTProcDetailResponse" %> 
<%@page import="java.util.*"%>
<%@page import="java.lang.Object" %>
<%@page import ="java.text.SimpleDateFormat" %>
<%@page import ="org.joda.time.Period" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<script type="application/javascript" src="../js/iscroll.js"></script>

<!-- TODO indent the code completely, add comments to code blocks -->
<script>
$(document).ready(function() {
//TODO move this comment inside the js function
	//this piece of code is to add an empty block to the end of the page so that even the last date scrolls to the top when its corresponding date is selected
addEmptyDiv();
	
});
/* var currentExpanded = "";
function expandedView(count)
{
	if(currentExpanded !="")
	{
		$('.expandedView'+currentExpanded).toggle();
		$('.collapsedView'+currentExpanded).toggle();
	}
	$('.expandedView'+count).toggle();
	$('.collapsedView'+count).toggle();
	if($('.expandedView'+count).is(':visible'))
	{
		currentExpanded = count;	
	}
	else
		currentExpanded = "";
	if(scrollContent1){
		scrollContent1.refresh();
	}
} */
  var currentExpanded ;
var prevExpanded;
function expandedView(count)
{
	currentExpanded = count;

	if(prevExpanded !=null)
		{
	
		if(currentExpanded != prevExpanded)
			{
		$('#OT_DPD_Patient'+prevExpanded).removeClass('OT_DPD_Patient_Exp').addClass('OT_DPD_Patient');
		$('#DPD_Date-Con'+prevExpanded).removeClass('DPD_Date-Con_Exp').addClass('DPD_Date-Con');
		$('.expandedView'+prevExpanded).hide();
		$('#OT_DPD_Patient'+currentExpanded).removeClass('OT_DPD_Patient').addClass('OT_DPD_Patient_Exp');	
		$('#DPD_Date-Con'+currentExpanded).removeClass('DPD_Date-Con').addClass('DPD_Date-Con_Exp')
		$('.expandedView'+currentExpanded).show();
			}
	 	else  
			{
			if($('.expandedView'+currentExpanded).is(':visible'))
				{
				/*  $('#OT_DPD_Patient'+prevExpanded).removeClass('OT_DPD_Patient_Exp').addClass('OT_DPD_Patient');
				$('#DPD_Date-Con'+prevExpanded).removeClass('DPD_Date-Con_Exp').addClass('DPD_Date-Con');
				$('.expandedView'+prevExpanded).hide();  */
				}
			else
				{
				$('#OT_DPD_Patient'+currentExpanded).removeClass('OT_DPD_Patient').addClass('OT_DPD_Patient_Exp');	
				$('#DPD_Date-Con'+currentExpanded).removeClass('DPD_Date-Con').addClass('DPD_Date-Con_Exp')
				$('.expandedView'+currentExpanded).show();
				}
			}	
		}
	else 
		{
		$('#OT_DPD_Patient'+currentExpanded).removeClass('OT_DPD_Patient').addClass('OT_DPD_Patient_Exp');	
		$('#DPD_Date-Con'+currentExpanded).removeClass('DPD_Date-Con').addClass('DPD_Date-Con_Exp');
		$('.expandedView'+currentExpanded).show();
		}
	prevExpanded = count;

	
	
	/* if(prevExpanded != null)
		{
		$('expandedView'+prevExpanded).hide();
		} */

		
	//alert(prevExpanded);
	
	//$('.expandedView'+count).toggle();
	/* $('.collapsedView'+count).toggle(); */
	/* if($('.expandedView'+count).is(':visible'))
	{
		currentExpanded = count;	
	}
	else
		currentExpanded = ""; */
	
	
	
	  if(scrollContent1){
		scrollContent1.refresh();
	}  
	 
}  
</script>
					
<%
/*taken from servlet */
String practitionerId = (String) session.getAttribute("practitioner_id");
String startDt = request.getParameter("startDate");
String endDt = request.getParameter("endDate");
String patCategoryFilter = request.getParameter("hdnOrderBy");
String localLang =(String) session.getAttribute("LOCALE")  ;
String locale = localLang == null? "en" : localLang; 
//String facilityID = (String) session.getAttribute("facility_id");

DiaryViewRequest diaryViewRequest = new DiaryViewRequest();
diaryViewRequest.setPractitionerId(practitionerId);
diaryViewRequest.setStartDate(startDt);
diaryViewRequest.setEndDate(endDt);
diaryViewRequest.setPatCategoryFilter(patCategoryFilter);
diaryViewRequest.setLocale(locale);
DiaryViewBC bc = new DiaryViewBC();
DiaryViewResponse diaryViewResponse = bc.getDiaryViewDetails(diaryViewRequest);
/*end of - taken from servlet */

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //TODO variable name to be more meaningful and specific
String[] mthNameArr = { "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};//TODO Months needs top be localized
String[] dayNmArr = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};//TODO to localize
String[] singleDigitNo= {"0","1", "2" , "3", "4", "5", "6","7","8","9"};
Date weekStartDate = null;
Date weekEndDate = null;
Date sysDt = new Date();
String sysDate = null;
Date systemDate = null;
Date weekFirstDate = null;
Date weekDay = null;
Date chckPrevBookingDate = null;
int k= 0;
ArrayList<Date> weekDayList = new ArrayList<Date>();
try{
	weekStartDate = formatter.parse(startDt);
	weekEndDate = formatter.parse(endDt);
	sysDate = formatter.format(sysDt);
	systemDate = formatter.parse(sysDate);
}
catch(Exception e){
	weekStartDate = new Date();
}
Calendar weekDayCal = Calendar.getInstance();
if((systemDate.after(weekStartDate)||systemDate.equals(weekStartDate)) && (systemDate.before(weekEndDate)||systemDate.equals(weekEndDate)))
{ 
	weekFirstDate = systemDate;
	weekDayCal.setTime(systemDate);
	weekDayList.add(weekFirstDate);
}
else
{
	weekFirstDate = weekStartDate;
	weekDayCal.setTime(weekStartDate);
	weekDayList.add(weekFirstDate);
}
   while(weekFirstDate.before(weekEndDate))// to generate the arraylist of all the dates which are present in the current week
 {
	 int i =1;
	 weekDayCal.add(Calendar.DATE, i);
	 weekDay = weekDayCal.getTime();
	 weekDayList.add(weekDay);
	 i++;
	 weekFirstDate = weekDay;
 } 
 Date prevBookingDate = null;// for checking the condition in printing the date seperator. TODO - Make it a date variable - DONE
List<AppointmentBlockItem> apptBlockItemList = null; // TODO , the block logic need to be tested thoroughly with data variance in Date, facility, clinic, op/ot
AppointmentBlockItem diaryBlockItem = null; //TODO - name should be diaryBlockItem  - DONE
String facilityName = null;
String locationName = null;
String speciality = null;
//DiaryViewResponse diaryViewResp = (DiaryViewResponse) request.getAttribute("DVResponse");
apptBlockItemList = diaryViewResponse.getApptBlockItemList();
if (!apptBlockItemList.isEmpty()) { // TODO null check for apptBlockItemList
	for(int i = 0; i < apptBlockItemList.size(); i++){
		diaryBlockItem = apptBlockItemList.get(i);
		int count = diaryBlockItem.getApptDetailCount();
		facilityName = diaryBlockItem.getFaciltityDesc(); 
		String apptType = diaryBlockItem.getAppointmentType(); //TODO variable declarations to be made uniformly -- possibly in the same blocks
		locationName = diaryBlockItem.getLocationDesc();
		speciality = diaryBlockItem.getSpecialityDesc();
		String slotType = "1";
		String slabType = "2"; //TODO what about 3 - Ask Dhivakar and see what's to be done  - DONE
		int hour = diaryBlockItem.getHourCount(); //TODO meaningful variable name
		int min = diaryBlockItem.getMinCount(); //TODO meaningful variable name
		Date bookingDt = diaryBlockItem.getBookingDate();
		Date bookingDate = null;
		String bookDt = null;
				try{
			/* weekStartDate = formatter.parse(startDt);
			weekEndDate = formatter.parse(weekEndDt); */
			bookDt = formatter.format(bookingDt);
			bookingDate = formatter.parse(bookDt);
			
		}
		catch (Exception e)//TODO exception type to be specific
		{
			weekStartDate = new Date();
		}
				Date chckBookingDate = bookingDate;
				
				if(chckBookingDate.equals(chckPrevBookingDate))
				{
					k--;
				}

		int bookingDtNum =bookingDate.getDate();
		//int bookingDtNum =bookingDate.getDate(); //TODO meaningful variable name - DONE
		Calendar bookingDtCal = Calendar.getInstance(); //TODO meaningful variable name - DONE
		//bookingDtCal.setTime(bookingDate);
		bookingDtCal.setTime(bookingDate);
		int bookingDtyear = bookingDtCal.get(Calendar.YEAR); //TODO meaningful variable name -DONE
		int bookingDtmth = bookingDtCal.get(Calendar.MONTH); //TODO meaningful variable name - DONE
		String bookingDtMonthName =  mthNameArr [bookingDtmth];//TODO meaningful variable name -DONE
		
		int bookingDtDay = bookingDtCal.get(Calendar.DAY_OF_WEEK); //TODO meaningful variable name -DONE
		String bookingDtDayName = dayNmArr[bookingDtDay-1]; //TODO meaningful variable name -DONE
		
	
		
		
             while(bookingDate.after(weekDayList.get(k)))
             {
            	 Date weekDate = weekDayList.get(k);
            	 int weekDateNum= weekDate.getDate();
            	 Calendar weekDateCal = Calendar.getInstance();
            	 weekDateCal.setTime(weekDate);
            	 int weekDateYear = weekDateCal.get(Calendar.YEAR);
            	 int weekDateMonth = weekDateCal.get(Calendar.MONTH);
            	 String weekDateMthName = mthNameArr [weekDateMonth];
            	 int weekDateDay = weekDateCal.get(Calendar.DAY_OF_WEEK);
            	 String weekDateDayName = dayNmArr[weekDateDay-1];
						
						    	   if ((!weekDate.equals(systemDate)) && (!weekDate.equals(weekStartDate))  && (!weekDate.equals(prevBookingDate)))
						    	   {
						    		   %>
						    	    <div class="center_block Diary_Msg_Box" >
						   			<div style="height:1px;background:white" class="dateSeperatorStart" data-bookingdate="<%= formatter.format(weekDate) %>" data-datecount="<%=k%>" id="dateSeperator<%=k%>"></div>
						   	          <div class="content">
						               <div class="top_block Calendar_Con_A">
						                 <div class="content">
						                   <div class="top_block Cal_Top_A">
						                     <div class="content">
						                       <div class="background Cal_Right_A">
						                         <div class="right_block Cal_Right_A">
						                           <div class="content">
						                            <div class="top_block Cal_Right_Top_A">
						                               <div class="content">
						                                 <div class="background Date_Num_A">
						                                   <div class="right_block Date_Num_A">
						                                     <div class="content DayNumfont_A">
						                                      <%
                                  	if(weekDateNum<10) {
                                  %>
                                  
                                  0<%= weekDateNum %> 
                                  <%
                                  	}
                                  	else
                                  	{
                                  %>
                                  <%= weekDateNum %>
                                  <% } %>
						                                     </div>
						                                   </div>
						                                 </div>
						                                <div class="background Date_Month_A">
						                                   <div class="center_block Date_Month_A">
						                                     <div class="content">
						                                       <div class="top_block Date_Month_Display_A">
						                                         <div class="content Monthfont_A"><%= weekDateMthName%>, <%=weekDateYear %> </div>
						                                       </div>
						                                       <div class="center_block Date_day_A">
						                                         <div class="content dayfont_A"><%=weekDateDayName %> </div>
						                                       </div>
						                                     </div>
						                                   </div>
						                                 </div>
						                               </div>
						                             </div>
						                           </div>
						                           
						                         </div>
						                       </div>
						                       
						                       <div class="center_block Cal_Left_A">
						                         <div class="content"> </div>
						                       </div>
						                     </div>
						                   </div>
						                   <div class="background Cal_Bottom_A">
						                     <div class="center_block Cal_Bottom_A">
						                       <div class="content"></div>
						                     </div>
						                   </div>
						                 </div>
						               </div>
						             </div>
						           </div>
						           <% } else{
						           %>
						           <div style="height:1px;background:white" class="dateSeperatorStart" data-bookingdate="<%= formatter.format(weekDate) %>" data-datecount="<%=k%>" id="dateSeperator<%=k%>"></div>
						          <%} %>
						          
						    	   <div  style="height:50px;width:98%; text-align:center;display:block;border:1px; border-style:solid; border-color: #eaeaea;line-height:4" class="Nodata_D"> No Appointments for This Day</div>
						    	   
						    	   
						    	    <% 
						          
						    	    k++;
		}
						       if ((!bookingDate.equals(systemDate)) && (!bookingDate.equals(weekStartDate)) && (!bookingDate.equals(prevBookingDate)))
								{
					%>
				
		<div class="center_block Diary_Msg_Box" >
		<div style="height:1px;background:white" class="dateSeperatorStart" data-bookingdate="<%= formatter.format(bookingDate) %>" data-datecount="<%=k%>" id="dateSeperator<%=k%>"></div>
	          <div class="content">
            <div class="top_block Calendar_Con_A">
              <div class="content">
                <div class="top_block Cal_Top_A">
                  <div class="content">
                    <div class="background Cal_Right_A">
                      <div class="right_block Cal_Right_A">
                        <div class="content">
                          <div class="background Cal_Right_Bottom_A">
                          
                        </div>
                          <div class="top_block Cal_Right_Top_A">
                            <div class="content">
                              <div class="background Date_Num_A">
                                <div class="right_block Date_Num_A">
                                  <div class="content DayNumfont_A">
                                  <%
                                  	if(bookingDtNum<10) {
                                  %>
                                  
                                  0<%= bookingDtNum %> 
                                  <%
                                  	}
                                  	else
                                  	{
                                  %>
                                  <%= bookingDtNum %>
                                  <% } %></div>
                                </div>
                              </div>
                             <div class="background Date_Month_A">
                                <div class="center_block Date_Month_A">
                                  <div class="content">
                                    <div class="top_block Date_Month_Display_A">
                                      <div class="content Monthfont_A"><%= bookingDtMonthName %>, <%= bookingDtyear %> </div>
                                    </div>
                                    <div class="center_block Date_day_A">
                                      <div class="content dayfont_A"> <%= bookingDtDayName %> </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        
                      </div>
                    </div>
                    
                    <div class="center_block Cal_Left_A">
                      <div class="content"> </div>
                    </div>
                  </div>
                </div>
                <div class="background Cal_Bottom_A">
                  <div class="center_block Cal_Bottom_A">
                    <div class="content"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
						 
			   <%
			  
			   prevBookingDate = bookingDate;
								}	
							
									
									else{ 
									%>
									<div style="height:1px;background:white" class="dateSeperatorStart" data-bookingdate="<%= formatter.format(bookingDate) %>" data-datecount="<%=k%>" id="dateSeperator<%=k%>"></div>
							<%	
									}
						/*    	ArrayList<AppointmentDetailItem> apptDetailItemList = diaryBlockItem.getAppointmentDetail(); */
						   
									
						       
		   			if (apptType.equals("op")) 
		   			{
		   				ArrayList<OPApptDetailItem> oOPapptDetailItemList = diaryBlockItem.getOpapptDetailList();
		  		 %>
			                        
			    <div class="top_block Diary_Content_OP">
                <div class="content">
                  <div class="top_block Diary_OP_Header">
                    <div class="content">
                      <div class="background D_OP_Icon">
                        <div class="left_block D_OP_Icon">
                          <div class="content D_Header_Icon"> <img src="${path}/eIPAD/images/OP_icon.png" width="25" height="24"> </div>
                        </div>
                      </div>
                      <div class="background D_OP_Right_Col">
                        <div class="right_block D_OP_Right_Col">
                          <div class="content"> </div>
                        </div>
                      </div>
                      <div class="background D_OP_Counter">
                        <div class="right_block D_OP_Counter">
                          <div class="content">
                            <div class="top_block D_Con_Total">
                              <div class="content"> 
                              
                              <div class="D_C_Box"> <div class="D_C_Box1"> <i class="D_C_Left"></i> <i class="D_C_Center D_H_Count"><%=count%></i> <i class="D_C_Right"></i> </div>
                              
                              
                               </div>
                               </div>
                            </div>
                            <div class="top_block D_Con_Dur">
                              <div class="content D_H_Count1"> 
                              <% if(hour != 0 ) { %> <%= hour %><% if(hour == 1) {%> Hr <% } else {  %> hrs  <% }} if(min != 0) { %> <%= min  %><% if(min == 1) {%>  min <% }else%> mins <% }%>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="background D_OP_header">
                        <div class="center_block D_OP_header">
                          <div class="content">
                            <div class="top_block D_OP_Header-Title">
                              <div class="content D_H_Title"> Clinic </div>
                            </div>
                            <div class="top_block D_OP_Header_SubTitle ">
                              <div class="content D_H_SubTitle"> <%= locationName %>, <%= speciality  %> , <%=facilityName%> </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <%
                  Date slabBookingTime  = null;
					Date prevSlabBookingTime = null;
                  	for (int j = 0; j < oOPapptDetailItemList.size(); j++)
                  	{
                  		OPApptDetailItem apptItem = oOPapptDetailItemList.get(j);
                  					
                  					/* ArrayList<OPApptDetailItem> oOPApptDetailItemList = apptItem.getOpApptDetailItemList();// this will come as null as we not seeting d opaaptlist aply
                  					OPApptDetailItem oOPApptDetailItem = oOPApptDetailItemList.get(j); */
                  					Date startTime = apptItem.getStartTime();
                  					Date endTime= apptItem.getEndTime();
                  					Calendar cal = Calendar.getInstance();
    								cal.setTime(startTime);
    								int stHrs = cal.get(Calendar.HOUR_OF_DAY);
                  					String stHr = Integer.toString(stHrs);
                  					if( Arrays.asList( singleDigitNo).contains(stHr))
    								{
    									stHr = ("0").concat(stHr);
    								}
                  					int stMins = cal.get(Calendar.MINUTE);
                  					String stMin = Integer.toString(stMins);
                  					if( Arrays.asList( singleDigitNo).contains(stMin))
    								{
    									stMin = ("0").concat(stMin);
    								}
    								Calendar calEndTm = Calendar.getInstance(); 
    								calEndTm.setTime(endTime);
    								int endHrs = calEndTm.get(Calendar.HOUR_OF_DAY);
                  					String endHr = Integer.toString(endHrs);
                  					if( Arrays.asList( singleDigitNo).contains(endHr))
    								{
    									endHr = ("0").concat(endHr);
    								}
    								int endMins = calEndTm.get(Calendar.MINUTE);
                  					String endMin = Integer.toString(endMins);
                  					if( Arrays.asList( singleDigitNo).contains(endMin))
    								{
    									endMin = ("0").concat(endMin);
    								}
    								
    								String age= apptItem.getPatientAge();
    								String[] ageYears = age.split(" ");
                  					Date apptDuration = apptItem.getAppointmentDuration();
                  					Calendar calApptDur = Calendar.getInstance(); 
                  					calApptDur.setTime(apptDuration);
                  					int apptDurHr = calApptDur.get(Calendar.HOUR_OF_DAY);
                  					int apptDurMin = calApptDur.get(Calendar.MINUTE);
                  					String opApptType = apptItem.getTimeTableType();
                  					slabBookingTime = startTime;
                  					String patientType= apptItem.getPatientType();
                  					if(opApptType.equals("1")||opApptType.equals("3"))
                  					{
                  						
                  					
                  %>
                  
                  <div class="top_block D_Patient_Details">
                    <div class="content">
                      <div class="top_block DPD_Patient">
                        <div class="content">
                        
                        
                            <div class="left_block DPD_Date-Con">
                              <div class="content">
                                <div class="top_block DPD_FTET">
                                  <div class="content D_H_FTET">  <%=stHr %>:<%= stMin %> - <%=endHr %>:<%= endMin %> </div>
                                </div>
                                <div class="top_block DPD_Dur">
                                  <div class="content D_H_Dur"> <% if(apptDurHr != 0 ) { %> <%= apptDurHr %> <% if(apptDurHr == 1) %> Hr <% else %> Hrs<%  }  %>  <% if(apptDurMin != 0) { %> <%= apptDurMin  %><% if(apptDurMin == 1) %> Min <% else  %> Mins <% } %>  </div>
                                </div>
                                <div class="top_block DPD_fl">
                                  <div class="content D_H_fl"> <%=apptItem.getVisitDesc() %> </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="background DPD_Date-Con_bor_OP">
                            <div class="left_block DPD_Date-Con_bor_OP">
                              <div class="content"> </div>
                            </div>
                          </div>
                          
                          <% 
                        if(patientType.equals("Y"))
                  							{
                  								%>
                  							<div class="background OP_OT">
				                                <div class="left_block OP_OT">
				                                  <div class="content">
				                                  <span class="OPOT"> 
				                                  <img src="${path}/eIPAD/images/OPOT.png">
				                                  </span>
				                                   </div>
				                                </div>
				                              </div>
				                            <% } %>
                          
                          <div class="background DPD_Photo">
                            <div class="right_block DPD_Photo imgPhotoTheme">
                            <%
                            if(!(apptItem.getPatientId()).equals(null))
                            {
                            %>
                              <div class="content"> <img src="${path}/mobile/PatientImageServlet?PatientId=<%=apptItem.getPatientId() %>" class="photoFrame PatImgTagTheme"></img> </div>
                            <%
                            }
                            else
                            {
                            %>
                            <div class="content"> <img src="${path}/eIPAD/images/Photo-4.png %>" class="photoFrame"></img> </div>
                            <%} %>
                            </div>
                          </div>
                          <div class="background DPD_Pat_D">
                            <div class="center_block DPD_Pat_D">
                              <div class="content">
                                <div class="top_block DPD_P_Name">
                                  <div class="content D_P_Name"> <%=apptItem.getPatientName()%> </div>
                                </div>
                                 
                                <div class="top_block DPD_P_ID">
                                  <div class="content D_P_ID"> <%=apptItem.getPatientId() %>, (<%=apptItem.getPatientSex() %>),  <%=ageYears[0] %> </div>
                                </div>
                                
                              </div>
                            </div>
                          </div>
                         
                      </div>
                    </div>
                    </div>
                    <% } else
                  		if(opApptType.equals("2"))
                  			{
                  			if(!slabBookingTime.equals(prevSlabBookingTime))
  							{
                  							%>
                  							 <div class="top_block Diary_OP_Slot_Header">
                        						<div class="content">
                          							<span class="D_H_FTET">
                         							<%=stHr %>:<%= stMin %> - <%=endHr %>:<%= endMin %>
                         							 </span>
						                        </div>
						                      </div>
						                      <%
						                      prevSlabBookingTime = slabBookingTime;
  							}
  												%>
                  							
                  							<div class="top_block D_Patient_Details">
						                        <div class="content">
						                        <% 
						                        if(patientType.equals("Y"))
	                  							{
	                  								%>
	                  							<div class="background OP_OT">
					                                <div class="left_block OP_OT">
					                                  <div class="content">
					                                  <span class="OPOT"> 
					                                  <img src="${path}/eIPAD/images/OPOT.png">
					                                  </span>
					                                   </div>
					                                </div>
					                              </div>
					                            <% } %>
						                          <div class="top_block DPD_Patient">
						                            <div class="content">
						                              <div class="background DPD_Date-Con">
						                                <div class="left_block DPD_Date-Con">
						                                  <div class="content">
						                                      <div class="top_block DPD_fl_Slot">
						                                      <div class="content D_H_fl_slab"> <%=apptItem.getVisitDesc() %> </div>
						                                    </div>
						                                  </div>
						                                </div>
						                              </div>
						                              <div class="background DPD_Date-Con_bor_OP">
						                                <div class="left_block DPD_Date-Con_bor_OP">
						                                  <div class="content"> </div>
						                                </div>
						                              </div>
						                              <div class="background DPD_Photo">
						                                <div class="right_block DPD_Photo imgPhotoTheme">
						                                  <div class="content">  <img src="${path}/mobile/PatientImageServlet?PatientId=<%=apptItem.getPatientId() %>" class="photoFrame PatImgTagTheme"></img> </div>
						                                </div>
						                              </div>
						                              <div class="background DPD_Pat_D">
						                                <div class="center_block DPD_Pat_D">
						                                  <div class="content">
						                                    <div class="top_block DPD_P_Name">
						                                      <div class="content D_P_Name"> <%=apptItem.getPatientName()%>  </div>
						                                    </div>
						                                    <div class="top_block DPD_P_ID">
						                                      <div class="content D_P_ID"> <%=apptItem.getPatientId() %>, (<%=apptItem.getPatientSex() %>),  <%=ageYears[0] %> </div>
						                                    </div>
						                                  </div>
						                                </div>
						                              </div>
						                            </div>
						                          </div>
						                        </div>
						                      </div>
                  						<% 
                  						}
		   			}
		   			%>
                  </div>
                </div>
              </div>

				<%
					} 		   			
		   			else  // OT BLOCK 
		   			{
		   				ArrayList<OTApptDetailItem> oOTapptDetailItemList = diaryBlockItem.getOtapptDetailList();
				%>			                        
			                        
			   <div class="top_block Diary_Content_OT">
                <div class="content">
                  <div class="top_block Diary_OP_Header">
                    <div class="content">
                      <div class="background D_OT_Icon">
                        <div class="left_block D_OT_Icon">
                          <div class="content D_Header_Icon"> <img src="${path}/eIPAD/images/OT.png" width="25" height="24"> </div>
                        </div>
                      </div>
                      <div class="background D_OT_Right_Col">
                        <div class="right_block D_OT_Right_Col">
                          <div class="content"> </div>
                        </div>
                      </div>
                      <div class="background D_OP_Counter">
                        <div class="right_block D_OP_Counter">
                          <div class="content">
                            <div class="top_block D_Con_Total">
                              <div class="content">  <div class="D_C_Box"> <div class="D_C_Box1"> <i class="D_C_Left"></i> <i class="D_C_Center D_H_Count"><%=count%></i> <i class="D_C_Right"></i> </div>
                              
                              
                               </div></div>
                            </div>
                            <div class="top_block D_Con_Dur">
                              <div class="content D_H_Count1">
                               <% if(hour != 0 ) { %> <%= hour %> <% if(hour == 1) %> Hr <% else %> Hrs <% }  %> <% if(min != 0) { %> <%= min  %> <% if(min == 1) %> Min <% else %> min <% } %>
                               </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="background D_OP_header">
                        <div class="center_block D_OP_header">
                          <div class="content">
                            <div class="top_block D_OP_Header-Title">
                              <div class="content D_H_Title"> Operation Theater </div>
                            </div>
                            <div class="top_block D_OP_Header_SubTitle ">
                              <div class="content D_H_SubTitle"> <%= locationName %> , <%=facilityName%> </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
					<%
						for (int j = 0; j < oOTapptDetailItemList.size(); j++) {
							OTApptDetailItem apptItem = oOTapptDetailItemList.get(j);
							
							/* ArrayList<OTApptDetailItem> oOTApptDetailItemList = apptItem.getOtApptDetailItemList();
          					OTApptDetailItem oOTApptDetailItem = oOTApptDetailItemList.get(j); */
          					
							Date startTime = apptItem.getStartTime();
          					Date endTime= apptItem.getEndTime();
          					Calendar cal = Calendar.getInstance();
							cal.setTime(startTime);
							int stHrs = cal.get(Calendar.HOUR_OF_DAY);
          					String stHr = Integer.toString(stHrs);
          					if( Arrays.asList( singleDigitNo).contains(stHr))
							{
								stHr = ("0").concat(stHr);
							}
          					int stMins = cal.get(Calendar.MINUTE);
          					String stMin = Integer.toString(stMins);
          					if( Arrays.asList( singleDigitNo).contains(stMin))
							{
								stMin = ("0").concat(stMin);
							}
							Calendar calEndTm = Calendar.getInstance(); 
							calEndTm.setTime(endTime);
							int endHrs = calEndTm.get(Calendar.HOUR_OF_DAY);
          					String endHr = Integer.toString(endHrs);
          					if( Arrays.asList( singleDigitNo).contains(endHr))
							{
								endHr = ("0").concat(endHr);
							}
							int endMins = calEndTm.get(Calendar.MINUTE);
          					String endMin = Integer.toString(endMins);
          					if( Arrays.asList( singleDigitNo).contains(endMin))
							{
								endMin = ("0").concat(endMin);
							}
							String age= apptItem.getPatientAge();
							String[] ageYears = age.split(" ");
							Date apptDuration = apptItem.getAppointmentDuration();
          					Calendar calApptDur = Calendar.getInstance();
          					calApptDur.setTime(apptDuration);
          					int apptDurHr = calApptDur.get(Calendar.HOUR_OF_DAY);
          					int apptDurMin = calApptDur.get(Calendar.MINUTE);
          					String operationType= apptItem.getOperationType(); 
          					String specialtyDesc = apptItem.getSpecialityDesc();
          					String locationDesc = apptItem.getLocationDesc();
          					String procedureDetail = apptItem.getProcedureDetail();
          					Date operationDt = diaryBlockItem.getBookingDate();
          					String practRole = apptItem.getPractRole();
					%>
					
					
					<!-- Test -->
					
					
<!-- Col -->
<div class="collapsedView<%=operationDt %>-<%=i %>-<%=j %>"  >
<div class="top_block OT_D_Patient_Details" onclick = "expandedView('<%=operationDt %>-<%=i %>-<%=j %>')" >
  <div class="content">
    <div class="top_block OT_DPD_Patient" id = "OT_DPD_Patient<%=operationDt %>-<%=i %>-<%=j %>">
      <div class="content">
        <div class="background DPD_Date-Con" id="DPD_Date-Con<%=operationDt %>-<%=i %>-<%=j %>">
          <div class="left_block DPD_Date-Con">
            <div class="content">
              <div class="top_block DPD_FTET">
                <div class="content D_H_FTET"> <%=stHr %>:<%= stMin %> - <%=endHr %>:<%= endMin %> </div>
              </div>
              <div class="top_block DPD_Dur">
                <div class="content D_H_Dur">
                  <% if(apptDurHr != 0 ) { %>
                  <%= apptDurHr %> <% if(apptDurHr == 1 )%> Hr <%else  %> Hrs
                  <% }  %>
                  <% if(apptDurMin != 0) { %>
                  <%= apptDurMin  %><% if(apptDurMin == 1) %> Min <%else %>  Mins
                  <% } %>
                </div>
              </div>
              <div class="top_block DPD_fl">
                <div class="content OT_D_H_fl">
                  <%
                                     if(operationType.equals("ST01"))
                                     {
                                  %>
                  Elective
                  <%
                                     }
                                     else
                                    	 if(operationType.equals("ST02"))
                                    	 {
                                  %>
                  Emergency
                  <%
                                    	 }
                                    	 else
                                    	 {	 
                                  %>
                  Urgent
                  <%
                                    	 }
                                  %>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="background DPD_Date-Con_bor_OT">
          <div class="left_block DPD_Date-Con_bor_OT">
            <div class="content"> </div>
          </div>
        </div>
        <div class="background DPD_Photo">
          <div class="right_block DPD_Photo imgPhotoTheme">
             <%
                            if(!(apptItem.getPatientId()).equals(null))
                            {
                            %>
                              <div class="content"> <img src="${path}/mobile/PatientImageServlet?PatientId=<%=apptItem.getPatientId() %>" class="photoFrame PatImgTagTheme"></img> </div>
                            <%
                            }
                            else
                            {
                            %>
                            <div class="content"> <img src="${path}/eIPAD/images/Photo-4.png %>" class="photoFrame"></img> </div>
                            <%} %>
          </div>
        </div>
        <div class="background DPD_Pat_D">
          <div class="center_block DPD_Pat_D">
            <div class="content">
              <div class="left_block OT_DPD_P_Name">
                <div class="content D_P_Name"> <%=apptItem.getPatientName()%>  </div>
              </div>
              <div class="Right_block OT_DPD_P_Name OT_DPD_P_Name_SPC">
                <div class="content D_P_ID_OT"> <%= specialtyDesc %> </div>
              </div>
              <div class="left_block OT_DPD_P_ID">
                <div class="content D_P_ID"> <%=apptItem.getPatientId() %>, (<%=apptItem.getPatientSex() %>), <%=ageYears[0] %> </div>
              </div>
              <div class="Right_block OT_DPD_P_ID OT_DPD_P_Name_SPC ">
                <div class="content D_P_ID_OT"> <%= locationDesc %> </div>
              </div>
            </div>
          </div>
        </div>
        <!-- contents to be shown after click -->
       <div class="expandedView<%=operationDt %>-<%=i %>-<%=j %> " style="display:none;" >
        <div class="background OT_Div">
                                <div class="Center_block OT_Div">
                                  <div class="content OT_DiV_Border "></div>
                                </div>
                              </div>
                              <div class="background DPD_Pat_D_OT ">
                                <div class="center_block DPD_Pat_D">
                                  <div class="content">
                                    <div class="left_block OT_DPD_P_SPC">
                                      <div class="content D_P_Name_OT"><!--  TODO localize these roles -->
                                      <%
                                     if(practRole.equals("MS"))
                                     {
                                	  %>
                  					  as Surgeon
                  					<%
                                    }
                                    	else
                                    	 if(practRole.equals("AS1"))
                                    	 {
                                  	%>
                  				as Assistant Surgeon 1  
                  					<%
                                    	 }
                                    	 else
                                    		if(practRole.equals("AS2"))
                                    	 {	 
                                  %>
                  					as Assistant Surgeon 2
                    			<%
                                    	 }
						 
                   	 					else
                   		 			if(practRole.equals("AN"))
                   	 				{	 
                 				%>
 				  			as Anesthetist
 							<%
                   	 			}
                           String bookingStage = apptItem.getBookingStage();
                 			%>            
                                  </div>
                                  
                                  
                                   
                                  <%
                                  // 	calling of procedure detail response to get the procedure detail
                                  /* String bookingNo = apptItem.getBookingNo();
                                  String facilityID = apptItem.getFacilityId();
               					OTProcDetailResponse procDetailResponse = bc.getProcDetails(bookingNo, facilityID, locale);
               					ArrayList<OTProcDetail> procDetailList = new ArrayList<OTProcDetail>();
               					OTProcDetail oProcDetail = new OTProcDetail();
               					procDetailList = procDetailResponse.getOtProcDetailList();  */
               					ArrayList<String> procDetail = apptItem.getProcDetail();
               					if(!procDetail.isEmpty())
               					{
               						for(int m=0;m<procDetail.size();m++)
               						{
               							/* oProcDetail = procDetailList.get(m); */
               						String procedureDetails = procDetail.get(m);
                                  %>
                                    <div class="content D_P_Name_OT content D_P_Name_OT_Surgen"><%= procedureDetails %></div>
                                  <%
               						}
               					}
                                  %>
                                  </div>
                                  
                                  <div class="Right_block OT_DPD_PAC_Status">
                                    <div class="content D_P_PAC_OT">
                                    <div>
                                    <%
                                    String PACStatus = apptItem.getPACStatus();
                                    if(PACStatus.equals("PACDONE") )
                                    %>
                                   <span style="border-right: #fff 1px solid; color:#0E7206" >PAC </span>
                                   <%
                                   else
                                	   if(PACStatus.equals("PACORDERED"))
                                	   {
                                	%>
                                	<span style= "border-right: #fff 1px solid; color:#c5c5c5">PAC </span>
                                	<% 
                                	   }
                                    if(bookingStage.equals("FN")) {
                                   %>
                                   <span style="margin-left: 4px;">  <%=apptItem.getStatusDesc() %> </span>
                                   <%  } %> 
                                    </div>
                                  
                                    </div>
                                   </div>
                                  </div>
                                </div>
                              </div>
                              </div>
        
  	 </div>     
    </div>
      
     	<div class="Center_block OT_DPD_P_Bottom" >
    		<div class="content OT_DPD_P_Bottom GreenStrip_Sw"> </div>
  		</div>
    </div>
  </div>
</div>

<!-- Col End -->
<!-- EXP -->

<%-- <div class="expandedView<%=operationDt %>-<%=i %>-<%=j %> " style="display:none;" >

<div class="top_block OT_D_Patient_Details" onclick = "expandedView('<%=operationDt %>-<%=i %>-<%=j %>')">
                        <div class="content">
                          <div class="top_block OT_DPD_Patient_Exp">
                            <div class="content">
                              <div class="background DPD_Date-Con_Exp" style="padding-top:20px">
                            <div class="left_block DPD_Date-Con">
                              <div class="content">
                                <div class="top_block DPD_FTET">
                                  <div class="content D_H_FTET"> <%=stHr %>:<%= stMin %> - <%=endHr %>:<%= endMin %> </div>
                                </div>
                                <div class="top_block DPD_Dur">
                                  <div class="content D_H_Dur"> <% if(apptDurHr != 0 ) { %> <%= apptDurHr %> hrs <% }  %> <% if(apptDurMin != 0) { %> <%= apptDurMin  %> mins <% } %> </div>
                                </div>
                                <div class="top_block DPD_fl">
                                  <div class="content OT_D_H_fl"> <!--  TODO localize -->
                                  <%
                                     if(operationType.equals("ST01"))
                                     {
                                  %> 
                                  Elective
                                  <%
                                     }
                                     else
                                    	 if(operationType.equals("ST02"))
                                    	 {
                                  %>
                                  Emergency
                                  <%
                                    	 }
                                    	 else
                                    	 {	 
                                  %>
                                  Urgent
                                  <%
                                    	 }
                                  %>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="background DPD_Date-Con_bor_OT">
                            <div class="left_block DPD_Date-Con_bor_OT">
                              <div class="content"> </div>
                            </div>
                          </div>
                          <div class="background DPD_Photo">
                            <div class="right_block DPD_Photo imgPhotoTheme">
                              <div class="content"> <img src="${path}/mobile/PatientImageServlet?PatientId=<%=apptItem.getPatientId() %>" class="photoFrame PatImgTagTheme"></img> </div>
                            </div>
                          </div>
                          <div class="background DPD_Pat_D">
                            <div class="center_block DPD_Pat_D">
                              <div class="content">
                                <div class="left_block OT_DPD_P_Name">
                                  <div class="content D_P_Name"> <%=apptItem.getPatientName()%>  </div>
                                </div>
                                <div class="Right_block OT_DPD_P_Name OT_DPD_P_Name_SPC">
                                  	<div class="content D_P_ID_OT"> <%= specialtyDesc %> </div>
                                 </div>
                                <div class="left_block OT_DPD_P_ID">
                                  <div class="content D_P_ID"> <%=apptItem.getPatientId() %> ,(<%=apptItem.getPatientSex() %>) ,  <%=ageYears[0] %>   </div>
                                </div>
                                <div class="Right_block OT_DPD_P_ID OT_DPD_P_Name_SPC ">
                                      <div class="content D_P_ID_OT"> <%= locationDesc %> </div>
                                 </div>
                              </div>
                            </div>
                          </div>
                          <!-- To be shown on click -->
                  				<div class="background OT_Div">
                                <div class="Center_block OT_Div">
                                  <div class="content OT_DiV_Border "></div>
                                </div>
                              </div>
                              <div class="background DPD_Pat_D_OT ">
                                <div class="center_block DPD_Pat_D">
                                  <div class="content">
                                    <div class="left_block OT_DPD_P_SPC">
                                      <div class="content D_P_Name_OT"><!--  TODO localize these roles -->
                                      <%
                                     if(practRole.equals("MS"))
                                     {
                                	  %>
                  					  as Surgeon
                  					<%
                                    }
                                    	else
                                    	 if(practRole.equals("AS1"))
                                    	 {
                                  	%>
                  				as Assistant Surgeon 1  
                  					<%
                                    	 }
                                    	 else
                                    		if(practRole.equals("AS2"))
                                    	 {	 
                                  %>
                  					as Assistant Surgeon 2
                    			<%
                                    	 }
						 
                   	 					else
                   		 			if(practRole.equals("AN"))
                   	 				{	 
                 				%>
 				  			as Anesthetist
 							<%
                   	 			}
                           String bookingStage = apptItem.getBookingStage();
                 			%>            
                                  </div>
                                  
                                  
                                   
                                  <%
                                  // 	calling of procedure detail response to get the procedure detail
                                  /* String bookingNo = apptItem.getBookingNo();
                                  String facilityID = apptItem.getFacilityId();
               					OTProcDetailResponse procDetailResponse = bc.getProcDetails(bookingNo, facilityID, locale);
               					ArrayList<OTProcDetail> procDetailList = new ArrayList<OTProcDetail>();
               					OTProcDetail oProcDetail = new OTProcDetail();
               					procDetailList = procDetailResponse.getOtProcDetailList();  */
               					ArrayList<String> procDetail = apptItem.getProcDetail();
               					if(!procDetail.isEmpty())
               					{
               						for(int m=0;m<procDetail.size();m++)
               						{
               							/* oProcDetail = procDetailList.get(m); */
               						String procedureDetails = procDetail.get(m);
                                  %>
                                    <div class="content D_P_Name_OT content D_P_Name_OT_Surgen"><%= procedureDetails %></div>
                                  <%
               						}
               					}
                                  %>
                                  </div>
                                  
                                  <div class="Right_block OT_DPD_PAC_Status">
                                    <div class="content D_P_PAC_OT">
                                    <div>
                                    <%
                                    String PACStatus = apptItem.getPACStatus();
                                    if(PACStatus.equals("PACDONE") )
                                    %>
                                   <span style="border-right: #fff 1px solid; color:#0E7206" >PAC </span>
                                   <%
                                   else
                                	   if(PACStatus.equals("PACORDERED"))
                                	   {
                                	%>
                                	<span style= "border-right: #fff 1px solid; color:#c5c5c5">PAC </span>
                                	<% 
                                	   }
                                    
                                   %>
                                   <span style="margin-left: 4px;"> <%  if(bookingStage.equals("FN")) { %> <%=apptItem.getStatusDesc() %> <%  } %> </span>
                                    </div>
                                  
                                    </div>
                                   </div>
                                  </div>
                                </div>
                              </div>
                        </div>
                      </div>
                     
                    </div>

                     <div class="Center_block OT_DPD_P_Bottom" >
                      	<div class="content OT_DPD_P_Bottom GreenStrip_Sw"> </div>
                    </div> 
                  </div>
				</div> --%>
<!-- Exp End -->
  <%
                     	}
                     %>
                </div>
              </div>
			        <%
							  
			        	}  
	k++;		
	chckPrevBookingDate = chckBookingDate;
	}
/* k++; */
while(k<weekDayList.size())
{
	Date weekDate = weekDayList.get(k);
	 int weekDateNum= weekDate.getDate();
	 Calendar weekDateCal = Calendar.getInstance();
	 weekDateCal.setTime(weekDate);
	 int weekDateYear = weekDateCal.get(Calendar.YEAR);
	 int weekDateMonth = weekDateCal.get(Calendar.MONTH);
	 String weekDateMthName = mthNameArr [weekDateMonth];
	 int weekDateDay = weekDateCal.get(Calendar.DAY_OF_WEEK);
	 String weekDateDayName = dayNmArr[weekDateDay-1];

	%>
	 <div class="center_block Diary_Msg_Box" >
		 <div style="height:1px;background:white" class="dateSeperatorStart" data-bookingdate="<%= formatter.format(weekDate) %>" data-datecount="<%=k%>" id="dateSeperator<%=k%>"></div>
	          <div class="content">
            <div class="top_block Calendar_Con_A">
              <div class="content">
                <div class="top_block Cal_Top_A">
                  <div class="content">
                    <div class="background Cal_Right_A">
                      <div class="right_block Cal_Right_A">
                        <div class="content">
                          <div class="background Cal_Right_Bottom_A">
                          
                        </div>
                          <div class="top_block Cal_Right_Top_A">
                            <div class="content">
                              <div class="background Date_Num_A">
                                <div class="right_block Date_Num_A">
                                  <div class="content DayNumfont_A">
                                   <%
                                  	if(weekDateNum<10) {
                                  %>
                                  
                                  0<%= weekDateNum %> 
                                  <%
                                  	}
                                  	else
                                  	{
                                  %>
                                  <%= weekDateNum %>
                                  <% } %>
                                  </div>
                                </div>
                              </div>
                             <div class="background Date_Month_A">
                                <div class="center_block Date_Month_A">
                                  <div class="content">
                                    <div class="top_block Date_Month_Display_A">
                                      <div class="content Monthfont_A"><%= weekDateMthName %>, <%= weekDateYear %> </div>
                                    </div>
                                    <div class="center_block Date_day_A">
                                      <div class="content dayfont_A"><%= weekDateDayName %> </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        
                      </div>
                    </div>
                    
                    <div class="center_block Cal_Left_A">
                      <div class="content"> </div>
                    </div>
                  </div>
                </div>
                <div class="background Cal_Bottom_A">
                  <div class="center_block Cal_Bottom_A">
                    <div class="content"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
 	   <div  style="height:50px;width:98%; text-align:center;display:block;border:1px; border-style:solid; border-color: #eaeaea;line-height:4" class="Nodata_D"> No Appointments for This Day</div><!-- TODO remove inline css -->
 	   <% 
 	   k++;
}
					}
							else
						{
						
			        %>                 
			<div>
			<div  style="width:98%; text-align:center;display:block;line-height:10" class="Nodata_D"> No Appointments for This Week</div><!-- TODO remove inline css and error message should be from response -->
			</div>
			<% }
			%>  
			
		</div> 
		<div id="EmptyScrollArea" style="width:100%;height:0px;"></div>

