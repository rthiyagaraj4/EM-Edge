<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.response.*"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
int nListSize = 0;
int nRecPerPage = 15;
String noteStatus = "";
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
	}
}
int nLoopCount = 0;
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
	   		if(nSubLoopSize > 0)
	   		{
	   			NoteDetails oNoteDetails = null;
	   			for(nSubLoopCount = 0 ; nSubLoopCount < nSubLoopSize && nSubLoopCount < nRecPerPage;nSubLoopCount++ )
	   			{
	   				oNoteDetails = oLstNoteDetails.get(nSubLoopCount);
	   				if(oNoteDetails != null)
	   				{
	   					%>
	   					<div data-role="none" class="notesBubbleContainer" data-accNumber = "<%=oNoteDetails.getAccessionNum() %>" onclick = "showNoteContentClick(this)">
	   						 <%
		   		 							 				   		if(nSubLoopCount > 0)
		   		 							 				   		{
		   		 							 				   			if(!dateValue.equals(oNoteDetails.getDescription().getDescription())  )
		   		 							 				   			{
		   		 							 				   				%>
		   		 							 				   					<div data-role="none" class = "notesDivider2 notesDividerTheme"></div>
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
	   						<div data-role="none" class="fullViewDataContainer">
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
																				<div data-role="none"
																					style="display: table-cell; width: 99%; height: 100%; border-radius: 30px; vertical-align: middle">
																					<div data-role="none" class="dateContainer">
																						<div data-role="none" class="notesDate"><%=oNoteDetails.getDescription().getDescription() %> <%=oNoteDetails.getDescription().getEventTime() %></div>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>	
	   					</div>
	   					<%
	   				}
	   			}
	   		}
		}
	}
}
%>
