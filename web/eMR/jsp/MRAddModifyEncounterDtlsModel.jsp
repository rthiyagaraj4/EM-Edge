<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<HTML>
	<HEAD>
		<Title><fmt:message key="eMR.UpdateInjDtls.label" bundle="${mr_labels}"/></Title>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
		<script src='../../eMR/js/MRUpdateEncounterDtls.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%  
			request.setCharacterEncoding("UTF-8");
			String encounterID=request.getParameter("encounterID");
			//Added Senthil
			String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id"); 
			/* Added by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] Start*/
			String checkedEncCount=request.getParameter("checkedEncCount")==null?"":request.getParameter("checkedEncCount"); 			
			String checkedEncIds=request.getParameter("checkedEncIds")==null?"":request.getParameter("checkedEncIds"); 	
			/* Added by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] End*/
			
			String facility= (String) session.getValue( "facility_id" );
		%>
			<FRAMESET ROWS='25%,*,18%' framespacing=0>
			<FRAME name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterID%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling=no>
			<!-- Added by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] Start-->
			<!--
			<frame name='updateDetails' id='updateDetails' src='../../eMR/jsp/MRAddModifyEncounterDtls.jsp?encounterID=<%=encounterID%>&patient_id=<%=patient_id%>' scrolling=no frameborder=no noresize>-->
			<frame name='updateDetails' id='updateDetails' src='../../eMR/jsp/MRAddModifyEncounterDtls.jsp?encounterID=<%=encounterID%>&patient_id=<%=patient_id%>&checkedEncCount=<%=checkedEncCount%>&checkedEncIds=<%=checkedEncIds%>' scrolling=no frameborder=no noresize>
						<!-- Added by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] End-->
			<frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize frameborder=no marginheight=0 marginwidth=0 scrolling=no>
		</FRAMESET>

	</HEAD>

</HTML>

