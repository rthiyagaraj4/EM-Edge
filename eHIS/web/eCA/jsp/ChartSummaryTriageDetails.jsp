<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
25/02/2013	IN035924	  Karthi L	 	CA View chart summary ?RESULT WIDGET? should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018) 
13/03/2013  IN038713	 Nijitha S		CRF-CA- CHL-CRF-0018/04- Scope for Data to be displayed in Widget defined->Other facility->we get exception error
13/03/2014	IN044157	 Chowminya		 [AAKH CRF 0010.1]Five level Triage system AE requirement 	
16/09/2014  IN050047 	Nijitha S		 The triage details does not populate correctly in Patient Secondary Triage History screen as per date/time selected from the patient chart.
---------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date	Rev.Name	Description
---------------------------------------------------------------------------------------------------------
28/06/2018	IN065341		Prakash C	29/06/2018	Ramesh G 	MMS-DM-CRF-0115
---------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    	/*String strFacilityId     =  (String)session.getValue("facility_id");
	if(strFacilityId == null) strFacilityId = "";
	String strEncounterId =  request.getParameter("episode_id");commented for IN065341*/
	//String strPatientId = request.getParameter("patient_id");
%>

<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}

//[IN035950] Ends
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	%>

	<!--<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />-->
	<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css' />
	
   	<script src='../../eCommon/js/common.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

	
	//function TriageDetail(patient_id,encounter_id,visit_adm_date_time)
	async function TriageDetail(patient_id,encounter_id,visit_adm_date_time,facility_id,called_from,clob_data,RepDb)//IN065341
	{
	    var retVal = "";
		var function_id ="query";
		//var dialogHeight= "36" ;
		//var dialogWidth	= "48" ;
		//var dialogTop ="113";
		var dialogTop		= "";
		var dialogHeight	= "90vh";
		var dialogWidth		= "90vw";
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
		//var action_url		=	"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id="+patient_id+"&episode_id="+encounter_id+"&visit_adm_date_time="+visit_adm_date_time+"&function_id="+function_id;
		//var action_url		=	"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id="+patient_id+"&episode_id="+encounter_id+"&rec_date_time="+visit_adm_date_time+"&function_id="+function_id;//IN050047 modified the key name from visit_adm_date_time to rec_date_time
		var action_url		=	"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id="+patient_id+"&episode_id="+encounter_id+"&rec_date_time="+visit_adm_date_time+"&function_id="+function_id+"&facility_id="+facility_id+"&called_from="+called_from+"&clob_data="+clob_data+"&RepDb="+RepDb;
		retVal = await top.window.showModalDialog(action_url,arguments,features);
	}
 
</script>
<title><%=title%></title>
</head>
<html>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<table width="100%" class='grid'>
<%
	String P_patient_id = request.getParameter("patient_id"); // moved for CHL-CRF-018 IN035924
	String qryTriageDates = "";  // moved for CHL-CRF-018 IN035924
	//IN065341 starts
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	String encounter_id="";
	String strFacilityId     =  "";
	String strEncounterId = "";
	int no_of_days=0;
	String scope_disp="D";
	if(called_from.equals("CDR")){
		encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		strFacilityId=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
		  strEncounterId =  request.getParameter("enc_id1");
	}else{//IN065341 ends
	   encounter_id = request.getParameter("encounter_id");//IN035924
	   strFacilityId     =  (String)session.getValue("facility_id");
	    strEncounterId =  request.getParameter("episode_id");
	}//IN065341
	
	// added below lines for CHL-CRF-018 IN035924 - START
	StringBuffer encListBuf = new StringBuffer();
	ArrayList encounterList = null;
	//IN065341 starts	
	if(!called_from.equals("CDR")){
		CAEncounterList oEncounterList = new CAEncounterList();
		HashMap encounterMap = oEncounterList.getPatEncounterList(P_patient_id, strFacilityId, content_ID);
		 scope_disp = (String)encounterMap.get("SCOPE_DISP");
		Integer no_of_days_before = (Integer)encounterMap.get("NO_OF_DAYS");
		 no_of_days = no_of_days_before.intValue();
		encounterList = (ArrayList)encounterMap.get("ENC_LIST");
		
		if( no_of_days >= 1  &&  scope_disp.equalsIgnoreCase("P"))
		{
			Iterator iterator = encounterList.iterator();
			int index = 0;
			
			while(iterator.hasNext())
			{	
				index++;
				encListBuf.append("'");
				encListBuf.append(iterator.next());
				if(encounterList.size() >= index )
				{
					encListBuf.append("'");
				}
				if(encounterList.size() != index )
				{
					encListBuf.append(",");
				}
			}
		}
		else if(scope_disp.equalsIgnoreCase("P"))
		{
			encListBuf.append("'");
			encListBuf.append(encounter_id);
			encListBuf.append("'");
		}
		//IN038713 Starts
		if(encListBuf.equals("") || null==encListBuf || encounter_id==null || encounter_id.equals(""))
				encListBuf.append("''");
		//IN038713 Ends
		//CHL-CRF-018 IN035924 - END
	}//IN065341 ends
	//String qryTriageDates = "select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI')  recorded_date_time, PRIORITY_ZONE,(SELECT short_desc                      FROM ae_pat_priority                     WHERE priority_code = a.pat_priority) PATIENT_PRIORITY_DESC,(SELECT short_desc                         FROM ae_tmt_area_for_clinic                         WHERE facility_id =  a.facility_id                           AND clinic_code = a.clinic_code                           AND treatment_area_code = a.treatment_area_code)|| nvl2(a.bed_no,' / '||a.bed_no,null)   location from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?  order by a.RECORDED_DATE";

	if(scope_disp.equalsIgnoreCase("D")) // condition added/modified for CHL-CRF-018 IN035924 - START
	{
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?  order by a.RECORDED_DATE "; 
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?  order by a.RECORDED_DATE "; //IN050047 retreiving recorded datetime with seconds //IN044157
		qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY ##REPDB##(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color ##REPDB##(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail ##REPDB## a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?  order by a.RECORDED_DATE "; //IN065341
	}	
	else if(scope_disp.equalsIgnoreCase("P")) 
	{
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI')  recorded_date_time, ENCOUNTER_ID, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID in ("+encListBuf+") order by a.RECORDED_DATE "; 
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, ENCOUNTER_ID, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID in ("+encListBuf+") order by a.RECORDED_DATE "; //IN050047 retreiving recorded datetime with seconds//IN044157
		if(called_from.equals("CDR")){	
			qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, ENCOUNTER_ID, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY ##REPDB##(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color ##REPDB##(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail ##REPDB## a where a.FACILITY_ID=? and a.ENCOUNTER_ID in ("+encounter_id+") order by a.RECORDED_DATE "; //IN065341
		}else{
			qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, ENCOUNTER_ID, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY ##REPDB##(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color ##REPDB##(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail ##REPDB## a where a.FACILITY_ID=? and a.ENCOUNTER_ID in ("+encListBuf+") order by a.RECORDED_DATE "; 
		}
	}
	else if(scope_disp.equalsIgnoreCase("C"))
	{
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null) location from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=? and RECORDED_DATE between (sysdate - ?) and sysdate order by a.RECORDED_DATE "; 
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null) location,ca_ae_get_priority_zone_color(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=? and RECORDED_DATE between (sysdate - ?) and sysdate order by a.RECORDED_DATE"; //IN050047 retreiving recorded datetime with seconds//IN044157
		qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY ##REPDB##(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null) location,ca_ae_get_priority_zone_color ##REPDB##(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail ##REPDB## a where a.FACILITY_ID=? and a.ENCOUNTER_ID=? and RECORDED_DATE between (sysdate - ?) and sysdate order by a.RECORDED_DATE"; //IN065341
	} // condition added/modified for CHL-CRF-018 IN035924 - END
%>
<%
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rsTriage=null;
	//String P_patient_id = request.getParameter("patient_id"); // commented for CHL-CRF-018 IN035924
	String strRecDtTime = "";
	//String encounter_id = request.getParameter("encounter_id"); // commented and moved top for CHL-CRF-018 IN035924

	if (encounter_id==null) encounter_id="";
	String visit_adm_date = request.getParameter("visit_adm_date");
	if (visit_adm_date==null) visit_adm_date="";
	
	try{
		conn = ConnectionManager.getConnection(request);
		//IN044157 - Start
		String AEZone5 = "N";
		
		//IN065341 starts
		//PreparedStatement stmtAE = conn.prepareStatement("Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM where OPERATING_FACILITY_ID=?");
		PreparedStatement stmtAE=null;
		ResultSet rsAE = null;
		String sql1="Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM ##REPDB## where OPERATING_FACILITY_ID=?";
		sql1=sql1.replaceAll("##REPDB##",RepDb);
		stmtAE = conn.prepareStatement(sql1);
		//IN065341 ends
		stmtAE.setString(1,strFacilityId);
		rsAE = stmtAE.executeQuery();
		while(rsAE.next()){
			AEZone5 = rsAE.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
		}
		if(stmtAE!=null)stmtAE.close();
		if(rsAE!=null)rsAE.close();
		//IN044157 - End
		
		qryTriageDates=qryTriageDates.replaceAll("##REPDB##",RepDb);//IN065341
		pstmt = conn.prepareStatement(qryTriageDates);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,strFacilityId);
		
		if(scope_disp.equalsIgnoreCase("D") || scope_disp.equalsIgnoreCase("C"))
		{ 
			//condition added for CHL-CRF-018 IN035924
			pstmt.setString(4,strEncounterId);
		}
		
		if(scope_disp.equalsIgnoreCase("C"))
		{ 
			// added for CHL-CRF-018 IN035924
			pstmt.setInt(5,no_of_days);	
		}	
		
		rsTriage = pstmt.executeQuery();
//		int counter = 0;
		String classValue = "";
		String priorityzone="";
		String prioritycolor = "";//IN044157
        String zonecolorclassvalue="";
        String tag="";
		int recordCount=0;//IN035950
		if(rsTriage != null)
		{
			while(rsTriage.next())
			{
				recordCount++;
				/*if(counter%2 == 0){
					classValue = "gridData";
				}else{
					classValue = "gridData";				
				}*/

				classValue = "gridData";
				priorityzone=rsTriage.getString("PRIORITY_ZONE")==null?"":rsTriage.getString("PRIORITY_ZONE");
				prioritycolor=rsTriage.getString("ae_zone_color")==null?"":rsTriage.getString("ae_zone_color");//IN044157
				strRecDtTime	= rsTriage.getString("recorded_date_time")==null?"":rsTriage.getString("recorded_date_time");

				//strRecDtTime	= com.ehis.util.DateUtils.convertDate(strRecDtTime,"DMYHM","en",locale);//IN050047
				
				if(scope_disp.equalsIgnoreCase("P")) // added for CHL-CRF-018
				{ 
					encounter_id = rsTriage.getString("ENCOUNTER_ID")==null?"":rsTriage.getString("ENCOUNTER_ID");
				}	
				//added if condition IN044157
				if(AEZone5.equals("N")){
					if(!priorityzone.equals(""))
					{
						if(priorityzone.equals("G"))
						{
							zonecolorclassvalue="NONCRITICAL"; 
							tag="<font size=1 color=white>";
						}
						else if(priorityzone.equals("R"))
						{
							zonecolorclassvalue="CRITICAL"; 
							tag="<font size=1 color=white>";
						}
						else if(priorityzone.equals("Y"))
						{
							zonecolorclassvalue="SEMICRITICAL";
							tag="<font size=1 color=black>";
						}
						else 
						zonecolorclassvalue=classValue;
					}
				}
				%>
			<!--IN065341 starts-->		
				<!--<TR><TD CLASS='classValue' width='40%'><a class='gridLink' href="javascript:TriageDetail('<%=P_patient_id%>','<%=encounter_id%>','<%=strRecDtTime%>')"><%=strRecDtTime%></a></TD>--><!--Passing recorded date/time-->
				<TR><TD CLASS='classValue' width='40%'><a class='gridLink' href="javascript:TriageDetail('<%=P_patient_id%>','<%=encounter_id%>','<%=strRecDtTime%>','<%=strFacilityId%>','<%=called_from%>','<%=clob_data%>','<%=RepDb%>')"><%=strRecDtTime%></a></TD>
			<!--IN065341 ends-->	
				<%
				if(AEZone5.equals("N")){
				%>
				<TD CLASS='<%=zonecolorclassvalue%>' width='30%'><%=tag%><%=rsTriage.getString("PATIENT_PRIORITY_DESC")==null?"&nbsp;":rsTriage.getString("PATIENT_PRIORITY_DESC")%></TD>
				<%
				}else{				
				%>
				<TD style=background-color:"<%=prioritycolor%>";FONT-SIZE:9pt; width='30%'><%=tag%><%=rsTriage.getString("PATIENT_PRIORITY_DESC")==null?"&nbsp;":rsTriage.getString("PATIENT_PRIORITY_DESC")%></TD> 
				<%}%>
				<TD CLASS='classValue' width='30%'><%=rsTriage.getString("location")==null?"&nbsp;":rsTriage.getString("location")%></TD></TR>
				<%}
		}
		//IN035950  Starts
		if(recordCount==0)
		{
		out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
		}
		//IN035950  Ends
		if(rsTriage != null)rsTriage.close();
		if(pstmt!=null)pstmt.close();


	}catch(Exception exec)
	{
		//out.println(exec.toString());//COMMON-ICN-0181
		exec.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(conn != null)
		ConnectionManager.returnConnection(conn,request);
	}
%>
	
		</table>
	</body>
</html>

