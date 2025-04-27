<!DOCTYPE html>
<%
//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.*" 
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.Common.*" %>
<% request.setCharacterEncoding("UTF-8");%>

<% 
	String params = request.getQueryString(); 
	String tab_id = CommonBean.checkForNull(request.getParameter("parent_tab_id"));

%>


<% if(tab_id.equals("details_tab")){ 	%>
	<FRAMESET COLS='*,0%' border='0'>	
		 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/SurgeryDetails.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME>
         <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
	</FRAMESET>
<% } else if(tab_id.equals("personnel_tab")) {  %>
   <FRAMESET COLS='*,0%' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/SugeryHistoryPersonnel.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	  <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>
 <% } else if(tab_id.equals("operative_record_tab")) { %>
   <FRAMESET COLS='*,0%' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/SurgeryHistoryAllNotes.jsp?<%=params%>'  scrolling='yes' noresize='no'></FRAME> 
	 <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>
<% } else if(tab_id.equals("post_oper_diagnosis_tab")) { %>
   <FRAMESET ROWS='22%,*' border='0'>	
	<FRAME NAME='PostOperDiagFrame' SRC='../../eOT/jsp/SurgeryHistoryDiagHdr.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	<FRAMESET COLS='0%,*' border='0'>	
	    <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/PostOperDiagnosisRecord.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	    <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
  </FRAMESET>
  </FRAMESET>
<% } else if(tab_id.equals("consumable_tab")) { %>
	<!--<FRAMESET ROWS='4%,3%,*' border='0'>-->
	<FRAMESET ROWS='6%,*' border='0'>
	<FRAME name="euip_tab" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/EquipmentTab.jsp?<%=params%>"></FRAME>
	<!--<FRAME name="ChildTitleFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"></FRAME>-->
	<FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
    </FRAMESET>
	<%} else if(tab_id.equals("specimen_tab")) { %>
   <FRAMESET COLS='0%,*' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/SpecimenRecord.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	 <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>
	 <%} else if(tab_id.equals("disposal_tab")) { %>
   <FRAMESET COLS='0%,*' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/NursingDisposalRecord.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	 <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='yes' noresize='no'></FRAME>
 </FRAMESET>
	 <%} else if(tab_id.equals("unusal_tab")) { %>
   <FRAMESET COLS='*,0%' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='SurgeryHistoryUnusualOccur.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	 <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>
	<%} else if(tab_id.equals("pre_oper_checklist_tab")) { %>
   <FRAMESET COLS='*,0%' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/SurgeryHistoryPreOperChkList.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	 <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>
 <%} else if(tab_id.equals("post_oper_checklist_tab")) { %>
   <FRAMESET COLS='*,0%' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/SurgeryHistoryPreOperChkList.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	 <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>
 <!--Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013-->
 <!--Start-->
 <%} else if(tab_id.equals("intra_oper_checklist_tab")) { %>
   <FRAMESET COLS='*,0%' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/SurgeryHistoryPreOperChkList.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	 <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>
 <!--End-->
<%} else if(tab_id.equals("swab_count_tab")) { %>
   <FRAMESET COLS='*,0%' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/SwabCountMain.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	 <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>
<%}%>

