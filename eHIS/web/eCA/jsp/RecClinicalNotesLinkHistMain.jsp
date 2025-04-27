<%
/*
Date		Edit History	Name				Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------------------------------
26/07/2024    64277		 Gomathi Sivakumar						Ramesh G		MMS-DM-CRF-0260-US005
30/10/2024    70704       Gunasekar R          31/10/2024       Ashwini Ragupathi	   ML-MMOH-CRF-1759
-----------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="Bean" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="AllergyTypeBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
<head>
<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkMed.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eCA.LinkResultDocuments.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

</head>

<%

  String result_linked_rec_type="";

  result_linked_rec_type=	(request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type"));

if(result_linked_rec_type.equals("CLNT"))
{	
	  %>
		<iframe name="RecClinicalNotesLinkHistNoteCriteriaFrame" id="RecClinicalNotesLinkHistNoteCriteriaFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkHistNoteCriteria.jsp?<%=request.getQueryString()%>"></iframe>
			<frameset name="TreeFrameSet" cols='30%,70%'>
				<!-- 1st Frame --><iframe name="RecClinicalNotesLinkHistNoteTreeFrame" id="RecClinicalNotesLinkHistNoteTreeFrame" src="../../eCommon/html/blank.html" frameborder=1></iframe>
				<frameset id='notesexp' rows = '40%,10%,40%,10%' frameborder=1>
				<!-- 2nd Frame --><iframe name="RecClinicalNotesLinkHistNoteAddTextHdrFrame" id="RecClinicalNotesLinkHistNoteAddTextHdrFrame" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></iframe>
				<!-- 3rd Frame --><iframe name="RecClinicalNotesLinkHistNoteAddButtonsFrame" id="RecClinicalNotesLinkHistNoteAddButtonsFrame" frameborder="1" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesLinkHistNoteAddButtons.jsp" scrolling="no"></iframe>
				<!-- 4th Frame --><!--<iframe name="RecClinicalNotesLinkHistNoteSelectedTextFrame" id="RecClinicalNotesLinkHistNoteSelectedTextFrame" frameborder="1" scrolling="auto" noresize src = "../../eCA/jsp/RecClinicalNotesLinkHistNoteSelectedText.jsp"></iframe>-->
				<iframe name="RecClinicalNotesLinkHistNoteSelectedTextFrame" id="RecClinicalNotesLinkHistNoteSelectedTextFrame" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></iframe>
				<!-- 5th Frame --><iframe name="RecClinicalNotesLinkHistNoteSelectButtons" id="RecClinicalNotesLinkHistNoteSelectButtons" frameborder="1" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkHistNoteSelectButtons.jsp" scrolling="no"></iframe>
			
		</frameset>
		<!-- 3rd Frame --><frame name="messageFrameReference" id="messageFrameReference" frameborder="0" scrolling="no" noresize src = "../../eCommon/html/blank.html"></frame>
	</frameset>
	<%
}
else if(result_linked_rec_type.equals("MEDN"))
{	
	%>
	<frameset name="notes" rows = '23%,*,3%' id='notes' frameborder=0 >
	<!-- ist Frame --><frame name="RecClinicalNotesLinkMedCriteriaFrame" id="RecClinicalNotesLinkMedCriteriaFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkMedCriteria.jsp?<%=request.getQueryString()%>"></frame>
	<frameset  rows='61%,30%,9%' onunLoad="<%=Bean.clearAll()%>">
	<!-- 1st Frame --><frame name="RecClinicalNotesLinkMedResultFrame" id="RecClinicalNotesLinkMedResultFrame" src="../../eCommon/html/blank.html" frameborder=0></frame>
	<!-- 2 nd Frame --><frame name="RecClinicalNotesLinkMedSelectedTextFrame" id="RecClinicalNotesLinkMedSelectedTextFrame" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
	<!-- 3 rd Frame --><frame name="RecClinicalNotesLinkMedSelectButtonsFrame" id="RecClinicalNotesLinkMedSelectButtonsFrame" frameborder="1" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkMedSelectButtons.jsp?<%=request.getQueryString()%>" scrolling="no"></frame>
	</frameset>
	<!-- 3rd Frame --><frame name="messageFrameReference" id="messageFrameReference" frameborder="0" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
	</frameset>
	<%
}
else if(result_linked_rec_type.equals("DIAG"))
{	
	
	  %>
		<!-- Modified by kishore kumar N on 10/12/2008 , altered frameset sizes -->
		<frameset name="notes" rows = '28%,*,3%' id='notes' frameborder=0 >
		<!-- ist Frame --><frame name="RecClinicalNotesLinkDiagCriteriaFrame" id="RecClinicalNotesLinkDiagCriteriaFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkDiagCriteria.jsp?<%=request.getQueryString()%>"></frame>
		<!-- 2 nd Frame --><!-- <frame name="RecClinicalNotesLinkHistNoteResultFrame" id="RecClinicalNotesLinkHistNoteResultFrame" frameborder="0" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame> -->
		<frameset  rows='61%,*%,9%' onunLoad="<%=Beannew.clearAll()%>">
		<!-- 1st Frame --><frame name="RecClinicalNotesLinkDiagResultFrame" id="RecClinicalNotesLinkDiagResultFrame" src="../../eCommon/html/blank.html" frameborder=0></frame>
		<!-- 2 nd Frame --><frame name="RecClinicalNotesLinkDiagSelectedTextFrame" id="RecClinicalNotesLinkDiagSelectedTextFrame" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
		<!-- 3 rd Frame --><frame name="RecClinicalNotesLinkDiagSelectButtonsFrame" id="RecClinicalNotesLinkDiagSelectButtonsFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkDiagSelectButtons.jsp?<%=request.getQueryString()%>" scrolling="no"></frame>
		</frameset>
		<!-- 3rd Frame --><frame name="messageFrameReference" id="messageFrameReference" frameborder="0" scrolling="no" noresize src = "../../eCommon/html/blank.html"></frame>
		</frameset>
		<!-- ends here. -->
	<%
}
else if(result_linked_rec_type.equals("ALGY"))
{	
	  %>
		<frameset name="notes" rows = '24%,*,3%' id='notes' frameborder=0 >
		<!-- ist Frame --><frame name="RecClinicalNotesLinkAlrgCriteriaFrame" id="RecClinicalNotesLinkAlrgCriteriaFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkAlrgCriteria.jsp?<%=request.getQueryString()%>"></frame>
		<!-- 2 nd Frame --><!-- <frame name="RecClinicalNotesLinkHistNoteResultFrame" id="RecClinicalNotesLinkHistNoteResultFrame" frameborder="0" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame> -->
		<frameset  rows='59%,30%,11%' onunLoad="<%=AllergyTypeBean.clearAll()%>">
		<!-- 1st Frame --><frame name="RecClinicalNotesLinkAlrgResultFrame" id="RecClinicalNotesLinkAlrgResultFrame" src="../../eCommon/html/blank.html" frameborder=0></frame>
		<!-- 2 nd Frame --><frame name="RecClinicalNotesLinkAlrgSelectedTextFrame" id="RecClinicalNotesLinkAlrgSelectedTextFrame" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
		<!-- 3 rd Frame --><frame name="RecClinicalNotesLinkAlrgSelectButtonsFrame" id="RecClinicalNotesLinkAlrgSelectButtonsFrame" frameborder="1" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkAlrgSelectButtons.jsp?<%=request.getQueryString()%>" scrolling="no"></frame>
		</frameset>
		<!-- 3rd Frame --><frame name="messageFrameReference" id="messageFrameReference" frameborder="0" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
		</frameset>
	 <%
}   
else if(result_linked_rec_type.equals("FEVT"))
{	
		%>

		<frameset name="event1" rows = '20%,*,3%' id='event1' frameborder=0 >
		<frame name="RecClinicalNotesLinkFutureEventCriteriaFrame" id="RecClinicalNotesLinkFutureEventCriteriaFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkFutureEventCriteria.jsp?<%=request.getQueryString()%>"></frame>
		<frameset id='tree' cols='14%,86%' onunLoad="">
        <frame name="RecClinicalNotesLinkFutureApptTreeFrame" id="RecClinicalNotesLinkFutureApptTreeFrame" src="../../eCommon/html/blank.html" frameborder=1></frame>
        <frameset  id='result' rows='56%,33%,8%' onunLoad="<%=EventBean.clearAll()%>">
        <frame name="RecClinicalNotesLinkFutureApptResultFrame" id="RecClinicalNotesLinkFutureApptResultFrame" src="../../eCommon/html/blank.html" frameborder=1></frame>
        <frame name="RecClinicalNotesLinkFutureApptSelectedTextFrame" id="RecClinicalNotesLinkFutureApptSelectedTextFrame" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
        <frame name="RecClinicalNotesLinkFutureApptSelectButtonsFrame" id="RecClinicalNotesLinkFutureApptSelectButtonsFrame" frameborder="1" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkFutureApptSelectButtons.jsp?<%=request.getQueryString()%>" scrolling="no"></frame>
        </frameset>
		</frameset>
		<frame name="messageFrameReference" id="messageFrameReference" frameborder="0" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
		</frameset>
		<%
}
else if(result_linked_rec_type.equals("NBDT"))
{	
		%>
		<frameset name="born" rows = '10%,*,7%,0%' id='born' frameborder=0  onunLoad="<%=AllergyTypeBean.clearAll()%>">
		<frame name="RecClinicalNotesLinkBornEnctrFrame" id="RecClinicalNotesLinkBornEnctrFrame" frameborder="0" scrolling="no"  noresize src = "../../eCA/jsp/RecClinicalNotesLinkBirthDetails.jsp?<%=request.getQueryString()%>">
		</frame>
		<frame name="RecClinicalNotesLinkBornMainFrame" id="RecClinicalNotesLinkBornMainFrame" frameborder="1" scrolling="auto"  noresize src = "../../eCommon/html/blank.html">
		</frame>
		<frame name="RecClinicalNotesLinkBornSelectButtonsFrame" id="RecClinicalNotesLinkBornSelectButtonsFrame" frameborder="1" scrolling="no" noresize src ='../../eCA/jsp/RecClinicalNotesLinkBirthDetailsToolbar.jsp?<%=request.getQueryString()%>'>
		</frame>
		<frame name="messageFrameReference" id="messageFrameReference" frameborder="0" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
		</frameset>
		<%
}
//64277 Starts
else if(result_linked_rec_type.equals("CHIC"))
{
	%>

		<frameset name="notes" rows = '20%,*,3%' id='notes' frameborder=0 >
			<frame name="RecClinicalNotesLinkChiefCompCriteriaFrame" id="RecClinicalNotesLinkChiefCompCriteriaFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkChiefCompCriteria.jsp?<%=request.getQueryString()%>"></frame> 
			<frameset name="chief" rows='59%,30%,11%' onunLoad="<%=Beannew.clearAll()%>">
				<frame name="RecClinicalNotesLinkChiefCompResultFrame" id="RecClinicalNotesLinkChiefCompResultFrame" src="../../eCommon/html/blank.html" frameborder=0></frame>
				<frame name="RecClinicalNotesLinkChiefCompSelectedTextFrame" id="RecClinicalNotesLinkChiefCompSelectedTextFrame" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
				<frame name="RecClinicalNotesLinkChiefCompSelectButtonsFrame" id="RecClinicalNotesLinkChiefCompSelectButtonsFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkChiefCompSelectButtons.jsp?<%=request.getQueryString()%>" scrolling="no"></frame> 
			</frameset>
			<frame name="messageFrameReference" id="messageFrameReference" frameborder="0" scrolling="no" noresize src = "../../eCommon/html/blank.html"></frame>
		</frameset> 
	<%
}
//64277 Ends

//70704 Start
else if(result_linked_rec_type.equals("MHD"))
{	
	  %>
		<frameset name="notes" rows = '22%,*,3%' id='notes' frameborder=0 >
		<frame name="RecClinicalNotesLinkMenstCriteriaFrame" id="RecClinicalNotesLinkMenstCriteriaFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkMenstHistDtlCriteria.jsp?<%=request.getQueryString()%>"></frame>
		<frameset  rows='48%,*%,6%' onunLoad="<%=Beannew.clearAll()%>">
		<frame name="RecClinicalNotesLinkMenstResultFrame" id="RecClinicalNotesLinkMenstResultFrame" src="../../eCommon/html/blank.html" frameborder=0></frame>
		<frame name="RecClinicalNotesLinkMenstSelectedTextFrame" id="RecClinicalNotesLinkMenstSelectedTextFrame" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
		<frame name="RecClinicalNotesLinkMenstSelectButtonsFrame" id="RecClinicalNotesLinkMenstSelectButtonsFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkMenstSelectButtons.jsp?<%=request.getQueryString()%>" scrolling="no"></frame>
		</frameset>
		<frame name="messageFrameReference" id="messageFrameReference" frameborder="0" scrolling="no" noresize src = "../../eCommon/html/blank.html"></frame>
		</frameset>
	<%
}//70704 End

else
			//if(result_linked_rec_type.equals("LBIN")||result_linked_rec_type.equals("LBRP")||result_linked_rec_type.equals("PTCR")||result_linked_rec_type.equals("RDIN")||result_linked_rec_type.equals("RDRP")||result_linked_rec_type.equals("SUNT")||result_linked_rec_type.equals("TRET")||result_linked_rec_type.equals("FDOC")||result_linked_rec_type.equals("RXIN") ||result_linked_rec_type.equals("BLTF"))
{
	
	%>

<!-- <frameset name="notes" rows = '21%,*,3%' id='notes' frameborder=0 > -->
			<iframe name="RecClinicalNotesLinkHistRepCriteriaFramenew" id="RecClinicalNotesLinkHistRepCriteriaFramenew" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkHistRepCriteria.jsp?<%=request.getQueryString()%>" style='height:17vh;width:100vw'></iframe> 
<!-- <frameset name="notes1" rows='53%,8%,30%,9%' onunLoad=""> -->
				<iframe name="RecClinicalNotesLinkHistRepResultFramenew" id="RecClinicalNotesLinkHistRepResultFramenew" src="../../eCommon/html/blank.html" frameborder=0 style='height:45vh;width:100vw'></iframe>
				<iframe name="RecClinicalNotesLinkHistRepShowButtonsFramenew" id="RecClinicalNotesLinkHistRepShowButtonsFramenew" frameborder="0" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesLinkHistRepShowButtons.jsp?<%=request.getQueryString()%>" scrolling="no" style='height:6vh;width:100vw'></iframe>
				<iframe name="RecClinicalNotesLinkHistSelectedTextFramenew" id="RecClinicalNotesLinkHistSelectedTextFramenew" frameborder="0" scrolling="auto" noresize src = "../../eCommon/html/blank.html" style='height:20vh;width:100vw'></iframe>
				<iframe name="RecClinicalNotesLinkHistRepSelectButtonsFramenew" id="RecClinicalNotesLinkHistRepSelectButtonsFramenew" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkHistRepSelectButtons.jsp?<%=request.getQueryString()%>" scrolling="no" style='height:9vh;width:100vw'></iframe> 
<!-- </frameset> -->
			<iframe name="messageFrameReference" id="messageFrameReference" frameborder="0" scrolling="no" noresize src = "../../eCommon/html/blank.html" style='height:3vh;width:100vw'></iframe>
<!--</frameset> -->
	<%
}
%>
</html>












