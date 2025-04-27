<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           									created
13/12/2012		IN035950		Nijitha											CHL Hospital suggested that the presentation of the Clinician desktop 
																				be changed and more appealing. Keeping the display of information more clear and visible. 
19/01/2018  IN066218  		PRATHYUSHA P		28/1/2018		Ramesh G		ML-MMOH-CRF-0985.1												
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
12/04/2023		IN039052	Ramesh Goli											ML-BRU-CRF-0634
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%	
		
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

	String EHR_YN = request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");
	String event_called = request.getParameter("event_called")==null?"":request.getParameter("event_called");
	//out.println("<script>alert('here"+event_called+"');</script>");

	String p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
	String p_event_class		=	request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
	String hist_type = request.getParameter("hist_type")==null?"":request.getParameter("hist_type");//CHL_CRF_0044
	String title		=	request.getParameter("title");
	String encBeanKey = "";
	if(encounterid.equals("")) encBeanKey = "0";
	else encBeanKey = encounterid;

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientid+encBeanKey,"eCA.PatientBannerGroupLine",session);
	manageEmailBean.clearBean();
	
%>

<html>
<%
	if(EHR_YN.equals("N")){
		//CHL_CRF_0044 Start
	if("CA_RESULTS_WIDGET".equals(p_called_from)){
	%>
		<title><%=title%></title>
	<%
	}else{
//CHL_CRF_0044 End
%>
<title><fmt:message key="eCA.FlowSheet.label" bundle="${ca_labels}"/></title>
<%
	}//CHL_CRF_0044
}
else{
%>
<title><fmt:message key="eCA.ClinicalEventsCentralRepFor.label" bundle="${ca_labels}"/>&nbsp; <%=patientid%></title>
<%
}
%>
		<script src="../../eCommon/js/common.js"			language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCA/js/FlowSheet.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String facilityId = request.getParameter("facilityId")==null?"":request.getParameter("facilityId");
		String flowsheet_id = request.getParameter("flowsheet_id")==null?"":request.getParameter("flowsheet_id");
		String enc_called_from = request.getParameter("enc_called_from")==null?"":request.getParameter("enc_called_from");
		String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
		String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");

		String practitioner_id = (String)session.getValue("ca_practitioner_id") == null ? "" : (String)session.getValue("ca_practitioner_id");
		String 	login_user_id		=	(String) session.getValue("login_user");
		String relationship_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
		//IN066218 Start.
		String che_default_mode=request.getParameter("che_default_mode")==null?"T":request.getParameter("che_default_mode"); 
		String calling_from_2T=request.getParameter("calling_from_2T")==null?"N":request.getParameter("calling_from_2T");
		String history_type_2T=request.getParameter("history_type")==null?"":request.getParameter("history_type");
		String event_class_2T=request.getParameter("event_class")==null?"":request.getParameter("event_class");
		String from_date_2T=request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date_2T=request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String event_item_2T=request.getParameter("event_item")==null?"":request.getParameter("event_item");
		String order_type_3T=request.getParameter("order_type_3T")==null?"":request.getParameter("order_type_3T"); //39052
		String event_class_3T=request.getParameter("event_class_3T")==null?"":request.getParameter("event_class_3T");//39052
		
		String archivalYN	= request.getParameter("archivalYN")==null?"": request.getParameter("archivalYN"); //52176
		
		//IN066218 End.
		if(encounterid.equals(""))
		{
			encounterid = episode_id;
		}

		String pat_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id;//IN035950
		//IN066218 Start.
		//  String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&hist_type="+hist_type;//IN035950
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&hist_type="+hist_type+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type_2T+"&event_class="+event_class_2T+"&from_date="+from_date_2T+"&to_date="+to_date_2T+"&event_item="+event_item_2T+"&che_default_mode="+che_default_mode;//IN066218//IN071561
		//39052 Start.
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&hist_type="+hist_type+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type_2T+"&event_class="+event_class_2T+"&from_date="+from_date_2T+"&to_date="+to_date_2T+"&event_item="+event_item_2T+"&che_default_mode="+che_default_mode+"&p_review_rad_yn="+p_review_rad_yn;//IN066218//IN071561
		String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&facilityId="+facilityId+"&patient_class="+pat_class+"&flowsheet_id="+flowsheet_id+"&called_from="+enc_called_from+"&ql_ref="+ql_ref+"&EHR_YN="+EHR_YN+"&default_yn="+default_yn+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&hist_type="+hist_type+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type_2T+"&event_class="+event_class_2T+"&from_date="+from_date_2T+"&to_date="+to_date_2T+"&event_item="+event_item_2T+"&che_default_mode="+che_default_mode+"&p_review_rad_yn="+p_review_rad_yn+"&order_type_3T="+order_type_3T+"&event_class_3T="+event_class_3T+"&archivalYN="+archivalYN;
		//39052
		//IN066218 End.

		String called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
		String rows="";
		String patient_details ="";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			con = ConnectionManager.getConnection(request);
			if(practitioner_id.equals(""))
			{
				pstmt = con.prepareStatement("select func_role_id from sm_appl_user where appl_user_id = ?");
				pstmt.setString(1,login_user_id);
				rs = pstmt.executeQuery();

				if(rs.next())
				{
					practitioner_id = rs.getString("func_role_id");
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				session.putValue("ca_practitioner_id",practitioner_id);
			}
		}
		catch(Exception e)
		{
			//out.println("Exception @ try:"+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			try{
					
				if(con != null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){
			
			out.println("Exception @ FlowSheet.jsp"+e.toString());
			}
		}

		if(called_from.equals("OR")){
			patientid = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
			rows="*,6%,0%";
			
			try{
				con = ConnectionManager.getConnection(request);
				
				pstmt = con.prepareStatement("select get_patient.get_line_detail(?,?) Pline FROM dual");
				pstmt.setString(1,patientid);
				pstmt.setString(2,locale);

				rs = pstmt.executeQuery();

				while(rs.next()){
					patient_details = rs.getString("Pline");
				}
				%>
				<script>
					window.document.title=getLabel("eCA.FlowSheet.label","CA")+' - '+("<%=patient_details%>");
				</script>
				<%
			
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e){
				//out.println("Exception @ try:"+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}

			finally{
				try{
					
					if(con != null) ConnectionManager.returnConnection(con,request);
				}catch(Exception e){
				
				out.println("Exception @ FlowSheet.jsp"+e.toString());
				}
			}
		}else{
			// Modified by kishore kumar N on 19-12-2008 for CRF 0387 after css changes.
			//CHL-CRF Start [Ramesh]
			if("CA_RESULTS_WIDGET".equals(p_called_from)){ 
				rows="24%,*,6%,0%"; // modified from 22 to 24 for IN058886
			}else{
			//CHL-CRF End[Ramesh]
				rows="24%,*,0%"; // modified from 22 to 24 for IN058886
			} //CHL-CRF [Ramesh]
		}
		
%>
<%-- <frameset rows="<%=rows%>" border=0 frameborder=0 style='border-style: solid; border-color: black;border-width:2' name='myFrameSet' id='myFrameSet' onbeforeunload='clearMailPrintBean()'>
	<%if(!called_from.equals("OR")){%>
		<frame src="../../eCA/jsp/FlowSheetCriteria.jsp?event_called=<%=event_called%>&<%=params%>" name="criteria_f1" id="criteria_f1"  scrolling="no" frameborder="0" noresize>
	<%}%>
	
	<%if(called_from.equals("OR")){%>
			<!--<frame src="../../eCA/jsp/FlowSheetDetails.jsp?<%=request.getQueryString()%>" name="details"  scrolling="no" frameborder="0" noresize>--><!--IN071561-->
		<frame src="../../eCA/jsp/FlowSheetDetails.jsp?<%=request.getQueryString()%>&p_review_rad_yn=<%=p_review_rad_yn%>" name="details" id="details"  scrolling="no" frameborder="0" noresize><!--IN071561-->
		<frame src="../../eCommon/jsp/error.jsp" name="messageFrame" id="messageFrame"  scrolling="yes" frameborder="0" noresize>
	<%}else{%>
		<frame src="../../eCommon/html/blank.html" name="details"  id="details"  scrolling="no" frameborder="0" noresize>
	<%}%>
	<!-- CHL-CRF Start. [Ramesh] -->
	<%if("CA_RESULTS_WIDGET".equals(p_called_from)){%>
		<frame src="../../eCommon/jsp/error.jsp" name="messageFrame"  id="messageFrame" scrolling="yes" frameborder="0" noresize>
	<%}%>
	<!-- CHL-CRF End. [Ramesh] -->
		<frame src="../../eCommon/html/blank.html" name="addToGroupsFrame"  id="addToGroupsFrame" scrolling="no" frameborder="0" noresize>
</frameset> --%>
	<div id="myFrameSet" style="border-style: solid; border-color: black; border-width: 2px;">
        <% if(!called_from.equals("OR")) { %>
            <iframe src="../../eCA/jsp/FlowSheetCriteria.jsp?event_called=<%=event_called%>&<%=params%>" name="criteria_f1" id="criteria_f1" style="width: 98vw; height: 24vh; border: none;" scrolling="no"></iframe>
        <% } %>
        <% if(called_from.equals("OR")) { %>
            <iframe src="../../eCA/jsp/FlowSheetDetails.jsp?<%=request.getQueryString()%>&p_review_rad_yn=<%=p_review_rad_yn%>" name="details" id="details" style="width: 98vw; height: 75vh; border: none;" scrolling="no"></iframe>
            <iframe src="../../eCommon/jsp/error.jsp" name="messageFrame1" id="messageFrame1" style="width: 99vw; height: 10vh; border: none;" scrolling="yes"></iframe>
        <% } else { %>
            <iframe src="../../eCommon/html/blank.html" name="details" id="details" style="width: 98vw; height: 65vh; border: none;" scrolling="no"></iframe>
        <% } %>
        <% if("CA_RESULTS_WIDGET".equals(p_called_from)) { %>
            <iframe src="../../eCommon/jsp/error.jsp" name="messageFrame1" id="messageFrame1" style="width: 99vw; height: 10vh; border: none;" scrolling="yes"></iframe>
        <% } %>
        <iframe src="../../eCommon/html/blank.html" name="addToGroupsFrame" id="addToGroupsFrame" style="width: 99vw; height: 0vh; border: none;" scrolling="no"></iframe>
    </div>
</html>

