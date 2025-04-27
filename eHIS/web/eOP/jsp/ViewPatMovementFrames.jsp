<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<html>
	<HEAD>
		<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    <%
        String tit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ViewPatientMovement.label","op_labels");
    %>
	<title><%=tit%></title>
	<%  
		request.setCharacterEncoding("UTF-8");
		String encounterid=request.getParameter("encounter_id");
		String facility= (String) session.getValue( "facility_id" ) ;
       			
		%>
			<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling='no' style='height:11vh;width:100vw'></iframe>
			<iframe name='result' id='result' src='../../eOP/jsp/ViewPatMovementResult.jsp?encounterid=<%=encounterid%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='auto' style='height:88vh;width:100vw'></iframe>
			<iframe name='Dummy_frame' id='Dummy_frame' src='../../eCommon/html/blank.html' framesetborder=0 frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
   </HEAD>
</html>

