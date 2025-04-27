<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	String jsp_name						=request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");
	String window_styl					=request.getParameter("window_styl")==null?"":request.getParameter("window_styl");
	String close_yn							=request.getParameter("close_yn")==null?"":request.getParameter("close_yn");
	String win_height						=request.getParameter("win_height")==null?"":request.getParameter("win_height");
	String win_width						=request.getParameter("win_width")==null?"":request.getParameter("win_width");
	String win_top							=request.getParameter("win_top")==null?"":request.getParameter("win_top");
	String act_yn  							=request.getParameter("act_yn")==null?"":request.getParameter("act_yn"); 
	String srr									=request.getParameter("srr")==null?"":request.getParameter("srr");
	String register_button_yn			=request.getParameter("register_button_yn")==null?"":request.getParameter("register_button_yn");
	String func_act							=request.getParameter("func_act")==null?"":request.getParameter("func_act");
	
	String defaultgender				=request.getParameter("default_gender")==null?"":request.getParameter("default_gender");
	String enablegenderyn			=request.getParameter("enable_gender_yn")==null?"":request.getParameter("enable_gender_yn");
	String dr_function_id=request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
	String func_idpassed=request.getParameter("func_idpassed")==null?"":request.getParameter("func_idpassed");
	//Maheshwaran K added for MMS-DM-CRF-0208.1
	String suspend_inactive_pat_yn=request.getParameter("suspend_inactive_patient_yn")==null?"N":request.getParameter("suspend_inactive_patient_yn");
	// Added for IN0 by Suresh M on 20.12.2010
	String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	
	//Added for this CRF HSA-CRF-0289
	String alterIdSearch=request.getParameter("alterIdSearch")==null?"":request.getParameter("alterIdSearch");
	String isAlternateId=request.getParameter("isAlternateId")==null?"":request.getParameter("isAlternateId");	
	String alternate_no=request.getParameter("alternate_no")==null?"":request.getParameter("alternate_no");
	//Added by Ashwin K for AAKH-CRF-0150
	String contact_no=request.getParameter("contact_no")==null?"":request.getParameter("contact_no");	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
 
<html>

<head>
<form name='patsearch' id='patsearch'>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<title><fmt:message key="Common.SearchPatient.label" bundle="${common_labels}"/> </title>
<script src="../../eMP/js/PatientSearch.js" language="JavaScript"></Script>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

 <!--	<frameset rows='*,20,0' >
		<frameset id='pat_search' rows='20,25,245,20,*'>
			<frame name='commontoolbar' src='../../eMP/jsp/PatientSearchToolBar.jsp'  frameborder=0 noresize scrolling='no'>
			<frame name='Pat_Search_Tabs_Frame' src='../../eMP/jsp/PatSearchTabsFrame.jsp?suspend_inactive_pat_yn=<%=suspend_inactive_pat_yn%>&jsp_name=<%=jsp_name%>&window_styl=<%=window_styl%>&close_yn=<%=close_yn%>&win_top=<%=win_top%>&win_width=<%=win_width%>&win_height=<%=win_height%>&act_yn=<%=act_yn%>&srr=<%=srr%>&register_button_yn=<%=register_button_yn%>&func_act=<%=func_act%>&default_gender=<%=defaultgender%>&enable_gender_yn=<%=enablegenderyn%>&dr_function_id=<%=dr_function_id%>&func_idpassed=<%=func_idpassed%>&patient_class=<%=patient_class%>&alterIdSearch=<%=alterIdSearch%>&isAlternateId=<%=isAlternateId%>
			&alternate_no=<%=alternate_no%>&contact_no=<%=contact_no%>' frameborder=0 noresize scrolling='no'>
			<!-- Added contact_no on the above line by Ashwin K for AAKH-CRF-0150 -->
			

			<!-- <frame name='commontoolbar' src='../../eCommon/jsp/commonToolbar.jsp?home_required_yn=N' frameborder=0 noresize scrolling='no'> -->
<!-- 			<frame name='tabSelectFrame' src='../jsp/DupTabsFrame.jsp' frameborder=0 noresize scrolling='no'>-->
	
	<!--	<frame name='Pat_Search_Criteria_Frame' src='../../eMP/jsp/BasicPatientSearchCriteria.jsp?suspend_inactive_pat_yn=<%=suspend_inactive_pat_yn%>&jsp_name=<%=jsp_name%>&window_styl=<%=window_styl%>&close_yn=<%=close_yn%>&win_top=<%=win_top%>&win_width=<%=win_width%>&win_height=<%=win_height%>&act_yn=<%=act_yn%>&srr=<%=srr%>&register_button_yn=<%=register_button_yn%>&func_act=<%=func_act%>&default_gender=<%=defaultgender%>&enable_gender_yn=<%=enablegenderyn%>&dr_function_id=<%=dr_function_id%>&func_idpassed=<%=func_idpassed%>&alterIdSearch=<%=alterIdSearch%>&isAlternateId=<%=isAlternateId%>&alternate_no=<%=alternate_no%>' frameborder=0 scrolling='no'>
			<frame name='Pat_Search_Toolbar_Frame' src='../../eMP/jsp/SearchToolbar.jsp?suspend_inactive_pat_yn=<%=suspend_inactive_pat_yn%>&register_button_yn=<%=register_button_yn%>&func_act=<%=func_act%>&dr_function_id=<%=dr_function_id%>' noresize frameborder=0 scrolling='no'>  
			<frame name='Pat_Results_Frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto'>
		</frameset> 
		<frame name='colurFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='NO'>
		<frame name='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='NO'>
	</frameset> -->
	<iframe name='commontoolbar' id ='commontoolbar' src='../../eMP/jsp/PatientSearchToolBar.jsp'  frameborder=0 noresize scrolling='no' style='height:4vh;width:99vw'></iframe>
	<iframe name='Pat_Search_Tabs_Frame' id='Pat_Search_Tabs_Frame' src='../../eMP/jsp/PatSearchTabsFrame.jsp?suspend_inactive_pat_yn=<%=suspend_inactive_pat_yn%>&jsp_name=<%=jsp_name%>&window_styl=<%=window_styl%>&close_yn=<%=close_yn%>&win_top=<%=win_top%>&win_width=<%=win_width%>&win_height=<%=win_height%>&act_yn=<%=act_yn%>&srr=<%=srr%>&register_button_yn=<%=register_button_yn%>&func_act=<%=func_act%>&default_gender=<%=defaultgender%>&enable_gender_yn=<%=enablegenderyn%>&dr_function_id=<%=dr_function_id%>&func_idpassed=<%=func_idpassed%>&patient_class=<%=patient_class%>&alterIdSearch=<%=alterIdSearch%>&isAlternateId=<%=isAlternateId%>&alternate_no=<%=alternate_no%>&contact_no=<%=contact_no%>' frameborder=0 noresize scrolling='no' style='height:3vh;width:99vw'></iframe>
    <iframe name='Pat_Search_Criteria_Frame' id='Pat_Search_Criteria_Frame' src='../../eMP/jsp/BasicPatientSearchCriteria.jsp?suspend_inactive_pat_yn=<%=suspend_inactive_pat_yn%>&jsp_name=<%=jsp_name%>&window_styl=<%=window_styl%>&close_yn=<%=close_yn%>&win_top=<%=win_top%>&win_width=<%=win_width%>&win_height=<%=win_height%>&act_yn=<%=act_yn%>&srr=<%=srr%>&register_button_yn=<%=register_button_yn%>&func_act=<%=func_act%>&default_gender=<%=defaultgender%>&enable_gender_yn=<%=enablegenderyn%>&dr_function_id=<%=dr_function_id%>&func_idpassed=<%=func_idpassed%>&alterIdSearch=<%=alterIdSearch%>&isAlternateId=<%=isAlternateId%>&alternate_no=<%=alternate_no%>' frameborder=0 scrolling='auto' style='height:42vh;width:99vw'></iframe>
	<iframe name='Pat_Search_Toolbar_Frame' id='Pat_Search_Toolbar_Frame' src='../../eMP/jsp/SearchToolbar.jsp?suspend_inactive_pat_yn=<%=suspend_inactive_pat_yn%>&register_button_yn=<%=register_button_yn%>&func_act=<%=func_act%>&dr_function_id=<%=dr_function_id%>' noresize frameborder=0 scrolling='no' style='height:4vh;width:99vw'></iframe> 
	<iframe name='Pat_Results_Frame' id='Pat_Results_Frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:10vh;width:99vw'></iframe>
	<iframe name='colurFrame' id='colurFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='NO' style='height:5vh;width:99vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='NO' style='height:0vh;width:99vw'></iframe>
		
</html>
