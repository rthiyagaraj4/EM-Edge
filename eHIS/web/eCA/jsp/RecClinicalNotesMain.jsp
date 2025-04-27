<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
23/03/2013		IN038840		Nijitha			CRF-CA- CHL-CRF-0011/05- Social History Widget->If the Role is modified after sign note we get script error   								 
02/06/2014		IN037701		Nijitha			SKR-CRF-0036   								 
15/02/2018	 	IN063799		Prakash C	15/02/2018		Ramesh		ML-MMOH-CRF-0808
27/05/2020		IN072879		SIVABAGYAM M		27/05/2020		RAMESH G		MMS-DM-SCF-0688
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	
%>
<html>
<head>
<title>RecClinicalNotesMain</title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%

	String operation_mode				=	"";
	String function_id					=	"";
	String doc_linked_note_yn			=	"";
	String patient_id					=	"";
	String encounter_id					=	"";
	String appl_task_id					=	"";
	String accessnum					= 	"";	//[IN033677]
	String facility_id					=	""; //[IN033677]
	String srl_no						=	"";
	String location_code="",speciality_name="";//IN072879
	//String rttext						=	"";commented for checkstyle

		String p_called_from_widget= request.getParameter("p_called_from_widget");//IN038840
		String p_soc_his= request.getParameter("p_soc_his");//IN038840
		String p_create_mode= request.getParameter("p_create_mode");//IN038840
	//StringBuffer traceBeanOBJ					=	new StringBuffer();

	operation_mode		= (request.getParameter("operation_mode")==null) ? "" : request.getParameter("operation_mode");
	String p_called_from = (request.getParameter("p_called_from")==null) ? "" : request.getParameter("p_called_from");//IN037701
	function_id			= request.getParameter("function_id")==null?"":request.getParameter("function_id");
	doc_linked_note_yn	= request.getParameter("doc_linked_note_yn")==null?"N":request.getParameter("doc_linked_note_yn");
	patient_id			= (request.getParameter("patient_id")==null) ? "" : request.getParameter("patient_id");
	encounter_id		= (request.getParameter("encounter_id")==null) ? "" : request.getParameter("encounter_id");
	
	appl_task_id			=	(request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");
	//[IN033677] Start
	facility_id			= (String)session.getValue("facility_id"); //[IN033677]
	accessnum			= (request.getParameter("accession_num")==null)?"":request.getParameter("accession_num");  //[IN033677]
	location_code=(request.getParameter("location_code")==null)?"":request.getParameter("location_code");  //IN072879
	speciality_name=(request.getParameter("speciality_name")==null)?"":request.getParameter("speciality_name"); //IN072879
	
	//[IN033677] End
	//IN063799 starts
	Connection con  = null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String display = "Y";
			try{
				
				String sql ="Select EMPTY_GRD_MAT_DISP_YN from CA_PARAM";
				con = ConnectionManager.getConnection() ;	
				pstmt = con.prepareStatement(sql);
				resultSet	= pstmt.executeQuery();

				while(resultSet.next())
					{
					 display  = resultSet.getString("EMPTY_GRD_MAT_DISP_YN")==null?"":resultSet.getString("EMPTY_GRD_MAT_DISP_YN");
					}
			}catch( Exception e )	
			{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;			
			} 
		finally 
			{
				
				if(pstmt !=null) pstmt.close();
				if(resultSet !=null)resultSet.close();
				if(con !=null) con.close();
			}
	//IN063799 ends
%>
<script language='javascript'>

	function getMessageFrame()
	{
		if(undefined != top.content && top.content!=null)//IN037701
			return top.content.messageFrame;
		else
			return top.messageframe;
	}
	
	var messageFrameReference = getMessageFrame();
	
	function clearMessageFrame()
	{
		//IN037701 Starts
		//messageFrameReference.location.href = '../../eCommon/jsp/error.jsp';
		if(undefined != messageFrameReference && null!=messageFrameReference.location)
			messageFrameReference.location.href = '../../eCommon/jsp/error.jsp';
		else
			top.messageframe.location.href = '../../eCommon/jsp/error.jsp';
		//IN037701 Ends
	}
	
	function clearBean()
	{
		//IN037701 Starts
		//messageFrameReference.location.href = '../../eCA/jsp/RecClinicalNotesClearBean.jsp?patient_id=<%=patient_id%>';
		if(undefined != messageFrameReference && null!=messageFrameReference.location)
			messageFrameReference.location.href = '../../eCA/jsp/RecClinicalNotesClearBean.jsp?patient_id=<%=patient_id%>';
		else
			top.messageframe.location.href = '../../eCA/jsp/RecClinicalNotesClearBean.jsp?patient_id=<%=patient_id%>';
		//IN037701 Ends	

	}
</script>
</head>
<%
	String strKey = "";

	strKey = patient_id + "~" + encounter_id;
	strKey = strKey.trim();

	//traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesMain.jsp at 8  ====>>>"+sectionBean+"   strKey   :    "+strKey+"   session   :   "+session);

	sectionBean.removePatientSection(strKey);	
	sectionBean.startPatientSection(strKey);	
	// Test Code
	
//	String resultKey = sectionBean.getpropPatientSection(strKey);	
	//traceBeanOBJ.append("patientKey Existance in Bean RecClinicalNotesMain.jsp at 70  ====>>>"+resultKey+"  sectionBean   :   "+sectionBean+"   session   :   "+session+"**encounter_id**"+encounter_id+"**patient_id**"+patient_id+"**Login User**"+(String)session.getValue("login_user"));
	//Test Code End
	
	putObjectInBean("sectionBean",sectionBean,session); 
	
//	traceBeanOBJ.append("patientKey Existance in Bean RecClinicalNotesMain.jsp at 70  ====>>>"+sectionBean.getpropPatientSection(strKey)+"  sectionBean   :   "+sectionBean+"   session   :   "+session+"**encounter_id**"+encounter_id+"**patient_id**"+patient_id+"**Login User**"+(String)session.getValue("login_user"));


System.out.println("RecClinicalNotesMain.jsp==================>"+request.getQueryString());
if(operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") )
{
  //IN037701 Starts	
  if("CA_SPC".equals(p_called_from)){
		%>
		<frameset rows='20%,73%,7%,0%,5%' framespacing='0' frameborder='0' onLoad='clearMessageFrame()' onunLoad="clearBean()" name='frameSetIdHeader' id='frameSetIdHeader'> 	
<%}else{%>
<frameset rows='20%,73%,7%,0%' framespacing='0' frameborder='0' onLoad='clearMessageFrame()' onunLoad="clearBean()" id='frameSetIdHeader' name='frameSetIdHeader'> 
<%}
//IN037701 Ends
//IN038840 Starts
}else if(("CA_SOCIAL_HISTORY".equals(p_called_from_widget) || "Y".equals(p_soc_his) )  && operation_mode.equals("") && "N".equals(p_create_mode) )
{
%>
<frameset rows='100%,0%' framespacing='0' frameborder='0' onLoad='clearMessageFrame()' onunLoad="clearBean()" id='frameSetIdHeader' name='frameSetIdHeader'> 
<%
//IN038840 Ends
}else {
%>
<frameset rows='40%,50%,10%,0%' framespacing='0' frameborder='0' onLoad='clearMessageFrame()' onunLoad="clearBean()" id='frameSetIdHeader' name='frameSetIdHeader'>
<%}
if( operation_mode.equals("ModifyAddendum") )
{ 
%>	
	<frame name="RecClinicalNotesHeaderFrame" id="RecClinicalNotesHeaderFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesHeader.jsp?<%=request.getQueryString()%>&srl_no=<%=srl_no%>" style="height:40%; width: 100vw;"> <!-- [IN033677] -->
	</frame>
	<frameset cols='30%,70%,0%' frameborder=1 id='frameSetIdSection' name='frameSetIdSection' >
		<frameset rows='*%,0%' frameborder=0  id='frameSetIdMessage' names='frameSetIdMessage'>
			<frame name="RecClinicalNotesSectionFrame" id="RecClinicalNotesSectionFrame" frameborder="1" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesSection.jsp?<%=request.getQueryString()%>"></frame>
			<frame name="processMsgframe" id="processMsgframe" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesProcessControlMsg.jsp"></frame>
		</frameset>			
		<!-- <frameset rows='6%,42%,52%' frameborder=1 id=frameSetIdAddendum>  [IN32064]-->
		<frameset rows='6%,42%,6%,46%' frameborder=1 id='frameSetIdAddendum' name='frameSetIdAddendum'>
			<frame name="EditorTitleFrame" id="EditorTitleFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?<%=request.getQueryString()%>">
			</frame>
		    <frame name="RecClinicalNotesContentViewFrame" id="RecClinicalNotesContentViewFrame" frameborder="1" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesContentView.jsp?<%=request.getQueryString()%>">
			</frame>
			<frame name="RecClinicalNotesSecDetailsFrame" id="RecClinicalNotesSecDetailsFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesAddendumHeader.jsp?<%=request.getQueryString()%>">
			</frame>
			<!-- [IN033869] Start-->
			<!--<frame name="RecClinicalNotesRTEditorFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RTEditor.jsp?content_editable_yn=&editor_param=R"> 
			</frame>-->
			<frame name="RecClinicalNotesSecDetailsEditorFrame" id="RecClinicalNotesSecDetailsEditorFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame>
			<!-- [IN033869] End-->
		</frameset>
	<frame name="RecClinicalNotesSecControlFrame" id="RecClinicalNotesSecControlFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesSectionAddendumControl.jsp?<%=request.getQueryString()%>">
	</frame>
	</frameset>
	<frame name="RecClinicalNotesToolbarFrame" id="RecClinicalNotesToolbarFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesToolbar.jsp?<%=request.getQueryString()%>">
	</frame>
	<frame name="RecClinicalNotesSecTempControlFrame" id="RecClinicalNotesSecTempControlFrame" frameborder="0" scrolling="no" noresize >	</frame>
<%
	//IN037701 Starts
	if("CA_SPC".equals(p_called_from)){
	%>	
	<frame name="messageframe" id="messageframe" frameborder="0" scrolling="auto" noresize src="../../eCommon/jsp/error.jsp"></frame>
	<%}//IN037701 Ends
}
else if(operation_mode.equals("Update") || operation_mode.equals("ModifySection"))
{
%>
	<!-- <frame name="RecClinicalNotesHeaderFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesHeader.jsp?<%=request.getQueryString()%>"></frame>-->
	<frame name="RecClinicalNotesHeaderFrame"  id="RecClinicalNotesHeaderFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesHeader.jsp?<%=request.getQueryString()%>&display=<%=display%>" marginheight="0" marginwidth="0" style="height:40%; width: 100vw;"></frame>
	<frameset cols='30%,70%,0%' frameborder=1 id='frameSetIdSection' name='frameSetIdSection'>
		<frameset rows='*%,0%' frameborder=0  id='frameSetIdMessage' name='frameSetIdMessage'>
			<frame name="RecClinicalNotesSectionFrame" id="RecClinicalNotesSectionFrame" frameborder="1" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesSection.jsp?<%=request.getQueryString()%>"></frame>
			<frame name="processMsgframe" id="processMsgframe"  frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesProcessControlMsg.jsp"></frame>
		</frameset>					
		<frameset rows='10%,90%' frameborder=1>
			<frame name="EditorTitleFrame" id="EditorTitleFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?<%=request.getQueryString()%>"></frame>
			<frame name="RecClinicalNotesSecDetailsFrame" id="RecClinicalNotesSecDetailsFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame>
		</frameset>
		<frame name="RecClinicalNotesSecControlFrame"  id="RecClinicalNotesSecControlFrame"  frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesSectionControl.jsp?<%=request.getQueryString()%>"></frame>
	</frameset>
	<frame name="RecClinicalNotesToolbarFrame" id="RecClinicalNotesToolbarFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesToolbar.jsp?<%=request.getQueryString()%>"></frame>
	<frame name="RecClinicalNotesSecTempControlFrame" id="RecClinicalNotesSecTempControlFrame" frameborder="0" scrolling="no" noresize ></frame>
<%
	//IN037701 Starts
	if("CA_SPC".equals(p_called_from)){
	%>	
	<frame name="messageframe" id="messageframe" frameborder="0" scrolling="auto" noresize src="../../eCommon/jsp/error.jsp"></frame>
	<%}
	//IN037701 Ends
}
//IN038840 Starts
else if(("CA_SOCIAL_HISTORY".equals(p_called_from_widget) || "Y".equals(p_soc_his)) && null!=p_called_from_widget && operation_mode.equals("") && "N".equals(p_create_mode) )
{
%>
		<%if(!"Y".equals(p_soc_his))
				{%>
		<frameset rows='15%,*,0%' frameborder=0>
		<%
		}else{%>
		<frameset rows='*%' frameborder=0>
		<%
		}%>
		<%if(!"Y".equals(p_soc_his))
		{%>
		<frame name="RecClinicalNotesSearchToolbarFrame" id="RecClinicalNotesSearchToolbarFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesSearchToolbar.jsp?<%=request.getQueryString()%>"></frame>
		<%
		}%>
		<frame name="RecClinicalNotesSearchDetailsFrame" id="RecClinicalNotesSearchDetailsFrame" frameborder="0" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesSearchDetails.jsp?<%=request.getQueryString()%>"></frame> 
		<%if(!"Y".equals(p_soc_his))
		{%>
		<frame name="messageframe" id="messageframe" frameborder="0" scrolling="auto" noresize src="../../eCommon/jsp/error.jsp"></frame> 
		<%
		}%>
	</frameset>
	<!--IN038840 Ends-->
	<%}
	
else
{
	%>
	<!-- <frame name="RecClinicalNotesHeaderFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesHeader.jsp?<%=request.getQueryString()%>"></frame>-->
	<frame name="RecClinicalNotesHeaderFrame" id="RecClinicalNotesHeaderFrame" frameborder="no" marginheight="0" marginwidth="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesHeader.jsp?<%=request.getQueryString()%>&display=<%=display%>" style="height:40%; width: 100vw;"></frame>
	<frameset cols='30%,70%,0%' frameborder=1 id='frameSetIdSection' name='frameSetIdSection'>
		<frameset rows='*%,0%' frameborder=0  id='frameSetIdMessage' name='frameSetIdMessage'>
			<frame name="RecClinicalNotesSectionFrame"   id="RecClinicalNotesSectionFrame" frameborder="1" scrolling="no" noresize src="../../eCommon/html/blank.html"></frame>
			<frame name="processMsgframe" id="processMsgframe" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesProcessControlMsg.jsp"></frame>
		</frameset>		
		<frameset rows='10%,90%' frameborder=1>
			<frame name="EditorTitleFrame" id="EditorTitleFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?<%=request.getQueryString()%>"></frame>
			<frame name="RecClinicalNotesSecDetailsFrame" id="RecClinicalNotesSecDetailsFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame>
		</frameset>
		<frame name="RecClinicalNotesSecControlFrame" id="RecClinicalNotesSecControlFrame" frameborder="0" scrolling="yes" noresize src="../../eCA/jsp/RecClinicalNotesSectionControl.jsp?<%=request.getQueryString()%>"></frame>
	</frameset>
	<frame name="RecClinicalNotesToolbarFrame" id="RecClinicalNotesToolbarFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesToolbar.jsp?function_id=<%=function_id%>&appl_task_id=<%=appl_task_id%>&doc_linked_note_yn=<%=doc_linked_note_yn%>"></frame>
	
	<frame name="RecClinicalNotesSecTempControlFrame" id="RecClinicalNotesSecTempControlFrame" frameborder="0" scrolling="no" noresize ></frame>


<%
}
%>
</frameset>
</html>
