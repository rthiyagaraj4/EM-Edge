<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,org.json.simple.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="Common.StartConsult.label" bundle="${common_labels}"/></title>
<head>
<%			/*Added by Thamizh selvi on 26th Oct 2017 for ML-MMOH-CRF-0623 Start*/
			Connection con					= null;
			JSONObject aePatCurrStatusJson	= new JSONObject();
			String facilityId				= (String)session.getValue("facility_id");
			/*End*/
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			String encounterid=request.getParameter("p3"); 			
			String p_status = "";
			String sdate	= "";
			String dt		= "";	
			String queueStatusNum = "";
         /*Below line added for this CRF Bru-HIMS-CRF-133*/
		String queue_date=request.getParameter("p18")==null?"":request.getParameter("p18");		
	    String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
	    String p_patient_id=request.getParameter("p2")==null?"":request.getParameter("p2");
		String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
		//End Bru-HIMS-CRF-133 
		
		String moduleId	= request.getParameter("module_id")==null?"":request.getParameter("module_id");//Added by Thamizh selvi on 20th Oct 2017 for ML-MMOH-CRF-0623

/*Added by Thamizh selvi on 26th Oct 2017 for ML-MMOH-CRF-0623 Start*/
try
{
	con	= ConnectionManager.getConnection(request);
	if(moduleId.equals("AE")){
		aePatCurrStatusJson	= eAE.AECommonBean.getCurrentStatusOfAEPatient(con, facilityId, encounterid);
		dt					= (String)aePatCurrStatusJson.get("assignTmtAreaTime");
		sdate				= (String)aePatCurrStatusJson.get("sysDateTime");
		queueStatusNum		= (String)aePatCurrStatusJson.get("queueStatus");
		if(queueStatusNum.equals("02"))
			p_status		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels");
	}else{
		dt			= request.getParameter("p16");
		sdate		= request.getParameter("p14");
		p_status    = request.getParameter("p15");
	}
/*End*/%>

	<iframe name='Pline' id='Pline'	src='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>' noresize  frameborder=no scrolling=no style='height:25vh;width:100vw'></iframe>
	<iframe name='ConsStart' src='../../eOP/jsp/RecordStartCons.jsp?encounterid=<%=encounterid%>&sdate=<%=sdate%>&p_status=<%=p_status%>&dtime=<%=dt%>&p_queue_date=<%=queue_date%>&p_patient_id=<%=p_patient_id%>&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>&moduleId=<%=moduleId%>' noresize  frameborder=no scrolling=no style='height:50vh;width:100vw'></iframe>
		<iframe name='ConsButton' id='ConsButton' src='../../eOP/jsp/RecordStartConsButt.jsp' scrolling=no frameborder=no noresize style='height:42vh;width:100vw'></iframe>
		<iframe name='DUMMY' id='DUMMY' src='../../eCommon/html/blank.html' scrolling=no frameborder=no noresize style='height:0%;width:100vw'></iframe>
	


</head>
<%
}catch(Exception e){ e.printStackTrace();}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
</html>

