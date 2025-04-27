<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.response.*"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.*"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC"%>
<%@page import="com.google.gson.Gson;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value= "${pageContext.request.contextPath}" />
<%
	Locale appLocale;
	String noteStatus = "";
	if (session.getAttribute("LOCALE") != null
			&& !session.getAttribute("LOCALE").equals(""))
		appLocale = new Locale((String) session.getAttribute("LOCALE"));
	else
		appLocale = new Locale("en");
	ResourceBundle csResBundle = ResourceBundle.getBundle(
			"eIPAD.chartsummary.common.resourcebundle.cslabels",
			appLocale);
	
	int nListSize = 0;
	int noteCount = 0;
	int totalNoteCount = 0;
	ClinicalNotesResponse oCnRes = null;
	List<ClinicalNoteGroup> listNoteGroup = null;
	if(request.getAttribute("ClinicalNotesViewResponse") != null)
	{
		oCnRes = (ClinicalNotesResponse)request.getAttribute("ClinicalNotesViewResponse");
		if(oCnRes != null)
		{
			listNoteGroup = oCnRes.getListNoteGroup();
			
		}
		if(listNoteGroup != null)
		{
			nListSize = listNoteGroup.size();
			for(int i=0;i<nListSize;i++){
				noteCount = listNoteGroup.get(i).getChildCount();
				totalNoteCount = totalNoteCount + noteCount;
			}
		}
	}	
	Gson gson = new Gson();
	String jsonFieldRes = "";
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
	String loggedInUser = patientContext.getLoggedInUser();
%>
<script type="text/javascript">
	var myScrollnotes;
	function scrollNotes() {
		$('.swipeWrapper').bind('touchstart click', function(event) {
			 var currentNotesId = $(this).attr('id');
			 if(currentNotesScrollingId)
			 {
				 if(currentNotesScrollingId != currentNotesId)
				 {
						myScrollnotes = new iScroll(currentNotesId, {
							hScrollbar : false
					});
						currentNotesScrollingId = currentNotesId;	
				 }
			 }
			 else
			 {
				 currentNotesScrollingId = currentNotesId;
					myScrollnotes = new iScroll(currentNotesId, {
						hScrollbar : false
				});
			 }
		});
	} 
     
    function filterNotes(filterBy,loggedInUser) 
	{		
		if(loggedInUser == undefined)
		  loadClinicalNotes(filterBy, 'widgetView', '', '', '');
	    else
		  loadClinicalNotes(filterBy, loggedInUser, '', '', '');
   }
    
    function showNoteContentClick(bubbleObj)
    {
    	var accessionNum = $(bubbleObj).attr("data-accNumber");
    	if(accessionNum != null && accessionNum != "")
    		{
    		accessionNum = escape(accessionNum);
    		}
    	window.parent.showNotesContent(accessionNum);
    }
	$(document).ready(function() {
		assignSliderWidth();
		setScrollerWidth();
		scrollNotes();		
	});
</script>
<div class="procWidgetParent widgetParentTheme" data-role="none">
	<div class="widgetTable" data-role="none">
		<div class="widgetHeaderRow widgetHeaderRowTheme" data-role="none"><!-- header row -->
			<div class="widgetHeaderMarginCell" data-role="none">
				<div class="widgetHeaderMarginExtn widgetHeaderMarginExtnTheme" data-role="none"></div>
				<div class="widgetHeaderIcontriangle" data-role="none"></div>
			</div>
			<div class="widgetHeaderCell widgetHeaderCellTheme" data-role="none">
				<div class="widgetHeaderSubTable" data-role="none">
					<div class="widgetHeaderSubRow" data-role="none">
						<div class="widgetHeaderIconCol1" data-role="none">
							<div class="widgetHeaderIconButton widgetHeaderIconButtonTheme" data-role="none">
								<img src="${path}/eIPAD/images/CS_Clinical_Notes_32x32.PNG" class="widgetHeaderButtonImage"></img>
							</div>
						</div>

						<div class="widgetHeaderHeadingTextCol" data-role="none">
							<span class="widgetHeaderHeadingTextTheme" data-role="none">Clinical Notes</span> <input type="button" class="widgetHeaderCountButtonTheme" id="ClinicalNotesCountBtn" value="<%=totalNoteCount%>">
						</div>
						<div class="notesFilterCol" data-role="none" >
							<table style="height: 100%; width: 100%" cellpadding="0" cellspacing="0" border="0">
								<tr style="height: 100%; width: 100%">
									<td style="width: 100%" align="right" valign="center">
										<div data-role="none" class="notesFilterContainer">
											<table style="width: 100%; height: 100%;" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<%-- <td class="notesIconTheme" valign="center" align="center" data-filterIcon = "T" data-filterBy = "A"   onclick = "filterNotes('A')"><img src="${path}/eIPAD/images/view01.png" style="vertical-align: middle;" /></td> --%>
													<td class="notesIconTheme" filter-type="N" valign="center" align="center"
														data-filterIcon="T" data-filterBy="NUR$"
														onclick="filterNotes('N')"><img
														src="${path}/eIPAD/images/Nursing_NotesW24x24.png"
														style="vertical-align: middle;" /></td>
													<td class="notesIconTheme" filter-type="P" valign="center" align="center"
														data-filterIcon="T" data-filterBy="PHY$"
														onclick="filterNotes('P')"><img
														src="${path}/eIPAD/images/PhysicianNotesW24x24.png"
														style="vertical-align: middle;" /></td>
													<td class="notesIconTheme" filter-type="C" valign="center" align="center"
														data-filterIcon="T" data-filterBy="CLI$"
														onclick="filterNotes('C')"><img
														src="${path}/eIPAD/images/Clinician_NotesW24x24.png"
														style="vertical-align: middle;" /></td>
													<td class="notesIconTheme" filter-type="SPL" valign="center" align="center"
														data-filterIcon="T" 
														onclick="filterNotes('SPL','<%=loggedInUser%>')"><img
														src="${path}/eIPAD/images/MySpecialty24x24.png"
														style="vertical-align: middle;" /></td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div><!-- header row ends -->
		<div class="widgetContentRow" id="CNdivcnt" data-role="none"><!-- content row starts -->
			<div class="widgetHeaderMarginCell" data-role="none"></div>
			<div class="widgetContentCell" data-role="none">
			<%
					ArrayList<String> accArray = new ArrayList<String>();
		        int nLoopCount = 0;
			    String notesImage = "PhysicianNotesW24x24.png" ;
			   	if(nListSize > 0 )
			   	{
			   		ClinicalNoteGroup oCnGrp = null;
			   		int nSubLoopCount = 0;
			   		int nSubLoopSize = 0;
			   		String dateValue = "";
			   		for(nLoopCount = 0; nLoopCount < nListSize; nLoopCount++)
			   		{
			   			oCnGrp = listNoteGroup.get(nLoopCount);
			   			if(oCnGrp != null)
			   			{
			   				 nSubLoopCount = 0;
					   		 nSubLoopSize = 0;
					   		 List<NoteDetails> oLstNoteDetails = null;
					   		 oLstNoteDetails = oCnGrp.getListNoteDetails();
					   		 if(oLstNoteDetails != null)
					   		 {
					   			nSubLoopSize = oLstNoteDetails.size();
					   		 }
					   		
			 %> 
				<div class="AllergyContentTable WidgetContentStripTheme clinicalNotesContent"
				    data-notetype="<%=oCnGrp.getGroupDescription().getGroupByValue()%>" 
					data-role="none" id="cTable">
					<!-- content strip starts -->
					<div class="AllergyContentRow AllergyContentRowTheme" data-role="none">
						<div class="notesContentCol1 WidgetContentStripCol1Theme" data-role="none">
							<div class="AllergyReactionCount WidgetContentStripCol1BoxTheme" data-role="none">
								<div class="AllergyReactionCountCircleTheme" data-role="none">
									<div class="AllergyReactionCountCircleText" data-role="none"><%=oCnGrp.getChildCount() %></div>
								</div>
								<%
								   String eventClass = oCnGrp.getGroupDescription().getEventClass();
								   if(eventClass != null)
								   {
									   if(eventClass.equals("NUR$"))
									   {
										   notesImage = "Nursing_NotesW24x24.png";
									   }
									   else if(eventClass.equals("CLI$"))
									   {
										   notesImage = "Clinician_NotesW24x24.png";
									   }
									   else
									   {
										   notesImage = "PhysicianNotesW24x24.png" ;
									   }
								   }
								%>
								<img src="${path}/eIPAD/images/<%=notesImage %>"  class="NotesImage" />
							</div>
						</div>
						<div class="notesContentCol2" data-role="none">
							<div data-role="none" class="swipeTable" id="swipeTable" data-count="1" >
								<div data-role="none" style="display: table-row;vertical-align:middle; width: 100%; height: 100%">
									<div data-role="none" data-content="1" style="display: table-cell;word-break:break-all; width: 1%; height: 67px; vertical-align: middle; text-align: left">
										<div data-role="none" class="WidgetParaHeadTextTheme notesText"><%= oCnGrp.getGroupDescription().getGroupByDesc()%></div>
									</div>
									<div data-role="none" style="display: table-cell; width: 98%; height: 67px; vertical-align: middle; text-align: left">
										<div data-role="none" class="swipeWrapper" id="wrapper<%=nLoopCount%>" data-IdCount = "<%=nLoopCount%>" data-noteType = "<%= oCnGrp.getGroupDescription().getGroupByValue()%>"> <!-- wrapper starts -->
											<div data-role="none" class="notesScroller" id="notesScroller<%=nLoopCount%>"> <!-- scroller starts -->
											<%
												if(nSubLoopSize > 0)
												{
													NoteDetails oNoteDetails = null;
													for(nSubLoopCount = 0 ; nSubLoopCount < nSubLoopSize;nSubLoopCount++ )
													{
														oNoteDetails = oLstNoteDetails.get(nSubLoopCount);
														if(oNoteDetails != null)
														{
											  %>
											  				<%
											  				if(nSubLoopCount > 0)
   		 							 				   		{
   		 							 				   			if(!dateValue.equals(oNoteDetails.getDescription().getDescription())  )
   		 							 				   			{
   		 							 				   				%>
   		 							 				   					<div data-role="none" class = "bubbleDivider notesDividerTheme" data-noteTypeValue = "<%= oCnGrp.getGroupDescription().getGroupByValue()%>"></div>
   		 							 				   				<% 
   		 							 				   			}
   		 							 				   		}
   		 							 				      dateValue = oNoteDetails.getDescription().getDescription();
   		 							 				      if(oNoteDetails.getStatus() != null)
   		 							 				      {
   		 							 				    	  if(oNoteDetails.getStatus().equals("1"))
   		 							 				    	  {
   		 							 				    		  noteStatus = "In_Progress24x24.png";
   		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("2"))
   		 							 				    	  {
   		 							 				    		  noteStatus = "Transcribed24x24.png";
   		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("3"))
 		 							 				    	  {
 		 							 				    		  noteStatus = "Unauthorized24x24.png";
 		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("4"))
		 							 				    	  {
		 							 				    		  noteStatus = "Authorized24x24.png";
		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("5"))
		 							 				    	  {
		 							 				    		  noteStatus = "Modified.png";
		 							 				    	  }
   		 							 				    	  else if(oNoteDetails.getStatus().equals("9"))
		 							 				    	  {
		 							 				    		  noteStatus = "InError24x24.png";
		 							 				    	  }
   		 							 				    	  else
   		 							 				    	  {
   		 							 				    		  noteStatus = "";
   		 							 				    	  }
   		 							 				      }
											  				%>
															<div data-role="none" class="dataContainerFullView" data-notetype="<%=oNoteDetails.getNoteType()%>" data-noteTypeValue = "<%= oCnGrp.getGroupDescription().getGroupByValue()%>" data-accNumber = "<%=oNoteDetails.getAccessionNum() %>" onclick = "showNoteContentClick(this)"> <!-- data buble starts-->
																<div data-role="none" style="display: table; width: 100%; height: 100%">
																	<div data-role="none" style="display: table-row; width: 100%; height: 100%">
																		<div data-role="none" style="display: table-cell; width: 1%; height: 100%; vertical-align: middle; text-align: center; border-radius: 30px">
																			<div data-role="none" class="iconContainer">
																			    <%
																			    	if(!noteStatus.equals(""))
																			    	{
																			    		%>
																			    		<img src="${path}/eIPAD/images/<%=noteStatus%>"></img>
																			    		<% 
																			    	}
																			    %>
																				
																			</div>
																		</div>
																		<div data-role="none" style="display: table-cell; width: 99%; height: 100%; border-radius: 30px; vertical-align: middle">
																			<div data-role="none" class="dateContainer">
																				<div data-role="none" class="notesDate"><%=oNoteDetails.getDescription().getDescription() %> <%=oNoteDetails.getDescription().getEventTime() %></div>
																			</div>
																		</div>
																	</div>
																</div>
															</div><!-- data bubble ends -->
												<%
														}//if notedetails
													}//for
												}//if subloop
												%>
											</div><!-- scroller ends -->
										</div><!-- wrapper ends -->
									</div>
								</div>
							</div>
						</div>
						<div class="notesContentCol3" data-role="none">
							<div class="notesExpandCollapse" data-role="none" data-expandNoteType = "<%= oCnGrp.getGroupDescription().getGroupByValue()%>" onclick = "showFullViewNotes(this)">
								<img src="${path}/eIPAD/images/Expandview.png" id="ExpCollAllergy" data-imagaeNoteType = "<%= oCnGrp.getGroupDescription().getGroupByValue()%>"></img>
							</div>
						</div>
					</div>
				</div><!-- div table ends   -->
				<%
			   			}//oCrgp
			   			%>
			   	<!-- full view for each table -->
				<div data-role = "none" style = "display:none;width:100%;height:auto;background-color:#ffffff" data-fullViewNoteType = "<%= oCnGrp.getGroupDescription().getGroupByValue()%>" data-fullView = "true">
				</div>
				<!-- full view for each table ends -->		
			   	<% 		
			   		}//for
			   	}//if
			   	else
			   	{
			   		%>
			   		<div class="WidgetVwErrContainer">
						<div class="WidgetErrorResponse WidgetErrorResponseTheme">
						<%
							 		if(oCnRes != null)
							 		{
							 			%>
							 				<%=oCnRes.getErrorsList().get(0).getErrorMessage() %>
							 			<% 
							 		}
							 %>
						</div>
					</div>

			   		<%
			   	}
			   	int count = accArray.size();
			   
				%>
				<input type="hidden" name="hdnCNCount" id="hdnCNCount" id="hdnCNCount"
					value='<%=count%>' />
				<%
				jsonFieldRes = gson.toJson(accArray);
				if(nListSize > 0 )
				{
				%>
				<div class="WidgetVwErrContainer mySpecialityNoRecords" style="display:none">
						<div class="WidgetErrorResponse WidgetErrorResponseTheme">
							No clinical notes recorded for the patient
						</div>
				</div>
				<%
				}
				%>
				<input type="hidden" name="hdnAccessionNum" id="hdnAccessionNum" id="hdnAccessionNum"
					value='<%=jsonFieldRes%>' />
			
			 <!-- mySpecialityList STARTS -->
                            <%
                            int nLoopCount1 = 0;
                        	int nRowCount = 0;
                        	String specCode= "";
                        	ClinicalNotesBC objBC = new ClinicalNotesBC();//calling bc
							ClinicalNotesFieldResponse oClintSPL = objBC.getMySpecialityList(patientContext);//for response
						 	List<ClinicalNotesFieldItem> MySpecialityListSFS;//to get the list
							ClinicalNotesFieldItem oCNFieldItemsSPL;//obj to get field values
							MySpecialityListSFS = oClintSPL.getFieldList();
							int nLstCountSPL = MySpecialityListSFS.size(); 
							
							%>
							<input type = "hidden" name ="hdnCount" id ="hdnCount" value = "<%=nLstCountSPL%>"/>
							<input type = "hidden" name ="hdnLoggedInUser" id ="hdnLoggedInUser" value = "<%=loggedInUser%>"/>
							<%
							for(nLoopCount1=0; nLoopCount1<nLstCountSPL; nLoopCount1++){ 
								oCNFieldItemsSPL = MySpecialityListSFS.get(nLoopCount1);
								  	if(oCNFieldItemsSPL != null ){
									specCode = oCNFieldItemsSPL.getDesc();
							%>
							<input type = "hidden" name ="hdnSpeciality" id ="hdnSpeciality<%=nLoopCount1%>" value = "<%=specCode%>"/>
							<%
								  	}
							}
							%>
			</div><!-- content cell ends -->
		</div><!-- content row ends -->
	</div><!-- widget table ends -->
</div><!-- div paren end -->

