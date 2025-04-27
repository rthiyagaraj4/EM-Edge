<!DOCTYPE html>

<% 
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
20/05/2014    IN037701		Ramesh G				      					SKR-CRF-0036 	
17/06/2014	  IN049720		Nijitha 										SKR-CRF-0036	 	
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<HTML>
	<HEAD>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCA/js/SinglePageConsultation.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<style>
		body{
			font-family: Tahoma, Arial, Helvetica, sans-serif;
			font-size: 11px;
			margin: 1px 1px 10px 10px;
			padding: 0 0 0 0;
			color:#000000;
			background:#ffffff;
		}
	</style>
	</HEAD>
<TITLE>Single Page Consultation</TITLE>

<body onKeyDown='lockKey()' OnMouseDown='CodeArrest();'>
	<form name="encounterSpecificTABform" id="encounterSpecificTABform" action="../../eCA/jsp/CAEncounterSpecificTAB.jsp" method="post">
	<%!int total_tab_count = 0;%>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		webbeans.eCommon.RecordSet SubSecRecordSet = (webbeans.eCommon.RecordSet) getObjectFromBean("SubSecRecordSet", "webbeans.eCommon.RecordSet", session);
		
		
				
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
		String encounter_id_spc = null;
		String patient_class_spc = null;
		String location_code_spc = "";
		String	facility_id			=	(String) session.getValue("facility_id");
		String  patient_id			=	request.getParameter("patient_id");
		String req_encounter_id= request.getParameter("encounter_id")==null?"":(String)request.getParameter("encounter_id");
		String practitioner_id = null,speciality_name=null,patient_class = null;
		practitioner_id = (String)session.getValue("ca_practitioner_id");
		if(practitioner_id == null) practitioner_id="";
		speciality_name = request.getParameter("location_code")==null?"":request.getParameter("location_code");
		patient_class = request.getParameter("patient_class")==null?"EM":request.getParameter("patient_class");
		String disp_mode = request.getParameter("disp_mode")==null?"":request.getParameter("disp_mode");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmtencounter = null;
		ResultSet rsencounter = null;
		ArrayList encounterList = new ArrayList();
		HashMap<String, String> encounterMap = null;
		HashMap<String, String> encounterMapPage = null;
		List<String> displayIconDtl = new ArrayList<String>();
		ArrayList encounterDtlList = new ArrayList();
		String result_header_icon ="";
		
		int page_tab_count = 4;
		String encounter_head_disp="";
		String queryString = "";
		int encounterIndex=0;
		int from_tab =0;
		int to_tab =0;
		int start = 0;
		int end = 0;
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String onLoadEncounterData = "";
		String onLoadPatientClassData = "";
		int onLoadEncounterIndex = 0;
		if (from == null) {
			start = 1;
		} else {
			start = Integer.parseInt(from);
		}
		if (to == null) {
			end = page_tab_count;
		} else {
			end = Integer.parseInt(to);
		}
				
		
		String encounterQuery = "select ca_encntr_header_disp(a.facility_id,a.encounteR_id,a.patient_class,a.patient_id,ATTEND_PRACTITIONER_ID) encounter_head_disp,TAB_FONT_COLOR, TAB_PREFER_IND, TAB_BG_COLOR, TAB_FONT_SIZE, TAB_FONT_BOLD_YN, IMAGE_FILE__YN, IMAGE_FILE_PATH, ALLOW_COMP_NO, a.facility_id,a.encounteR_id ,a.patient_id ,'*ALL' workflow_Comp_id,a.patient_class,a.ASSIGN_CARE_LOCN_CODE from pr_encounter_vw a, CA_ENCNTR_MR_PARAM b where a.patient_class = b.patient_class and b.PAT_CLASS_APPL_YN = 'Y' and patient_id = ? order by visit_adm_Date_time desc ";
		
		
		try{
			int encounter_spc_index = 1;
			if (disp_mode.equals("")) 
			{
				SubSecRecordSet.clearAll();
				con = ConnectionManager.getConnection(request);
				pstmtencounter = con.prepareStatement(encounterQuery);
				
				pstmtencounter.setString(1,patient_id);
				
				rsencounter = pstmtencounter.executeQuery();
				while(rsencounter.next())
				{
					/*encounterMap = new HashMap();
					encounterMap.put("ENCOUNTER_ID",rsencounter.getString("encounter_id"));
					encounterMap.put("encounter_head_disp",rsencounter.getString("encounter_head_disp"));
					encounterMap.put("tab_bg_color",rsencounter.getString("tab_bg_color"));
					encounterMap.put("tab_font_size",rsencounter.getString("tab_font_size"));
					encounterMap.put("tab_font_bold_yn",rsencounter.getString("tab_font_bold_yn"));
					encounterMap.put("image_file_path",rsencounter.getString("image_file_path"));
					encounterMap.put("TAB_FONT_COLOR",rsencounter.getString("TAB_FONT_COLOR")); */
					
					encounterList.add(rsencounter.getString("encounter_id"));
					encounterList.add(rsencounter.getString("encounter_head_disp"));
					encounterList.add(rsencounter.getString("tab_bg_color"));
					encounterList.add(rsencounter.getString("tab_font_size"));
					
					if("Y".equals(rsencounter.getString("tab_font_bold_yn"))) 
						encounterList.add("bold");
					else 
						encounterList.add("normal");
					
					encounterList.add(rsencounter.getString("image_file_path"));
					encounterList.add(rsencounter.getString("TAB_FONT_COLOR")); 
					encounterList.add(rsencounter.getString("patient_class"));
					encounterList.add(rsencounter.getString("ASSIGN_CARE_LOCN_CODE"));
					//SubSecRecordSet.putObject(encounterMap);
				}
				for (int i = 0; i < encounterList.size(); i += 9) 
				{
					System.out.println("125------------------->"+(String)encounterList.get(i));
					if(req_encounter_id.equals((String)encounterList.get(i)))
					{
						encounterMap = new HashMap(); 
						encounterMap.put("ENCOUNTER_ID",(String)encounterList.get(i));
						encounterMap.put("encounter_head_disp",(String)encounterList.get(i+1));
						encounterMap.put("tab_bg_color",(String)encounterList.get(i+2));
						encounterMap.put("tab_font_size",(String)encounterList.get(i+3));
						encounterMap.put("tab_font_bold_yn",(String)encounterList.get(i+4));
						encounterMap.put("image_file_path",(String)encounterList.get(i+5));
						encounterMap.put("TAB_FONT_COLOR",(String)encounterList.get(i+6));
						encounterMap.put("patient_class",(String)encounterList.get(i+7));
						encounterMap.put("ASSIGN_CARE_LOCN_CODE",(String)encounterList.get(i+8));
						SubSecRecordSet.putObject(encounterMap); 
					} 
				}
				for (int j = 0; j < encounterList.size(); j += 9) 
				{
					if(!req_encounter_id.equals((String)encounterList.get(j)))
					{
						encounterMap = new HashMap();
						System.out.println("145------------------->"+(String)encounterList.get(j));
						encounterMap.put("ENCOUNTER_ID",(String)encounterList.get(j));
						encounterMap.put("encounter_head_disp",(String)encounterList.get(j+1));
						encounterMap.put("tab_bg_color",(String)encounterList.get(j+2));
						encounterMap.put("tab_font_size",(String)encounterList.get(j+3));
						encounterMap.put("tab_font_bold_yn",(String)encounterList.get(j+4));
						encounterMap.put("image_file_path",(String)encounterList.get(j+5));
						encounterMap.put("TAB_FONT_COLOR",(String)encounterList.get(j+6)); 
						encounterMap.put("patient_class",(String)encounterList.get(j+7));
						encounterMap.put("ASSIGN_CARE_LOCN_CODE",(String)encounterList.get(j+8));
						SubSecRecordSet.putObject(encounterMap);
					}
				}
				
				total_tab_count = SubSecRecordSet.getSize();
				System.out.println("		total_tab_count------------------->"+total_tab_count);
				from_tab=0;
				to_tab=(page_tab_count-1);
				if (from_tab > (total_tab_count - 1))
					to_tab = (total_tab_count - 1);
	
				from = "" + (start - 1);
				to = "" + (end - 1);
			}
			else
			{
				int from_val = 0;
				int to_val = 0;

				from_val = Integer.parseInt(from);
				to_val = Integer.parseInt(to);
				if (disp_mode.equals("Next")) {
					disp_mode = "Next";
					from = "" + (start + page_tab_count);
					to = "" + (end + page_tab_count);

				} else if (disp_mode.equals("Previous")) {
					disp_mode = "Previous";
					from = "" + (start - page_tab_count);
					to = "" + (end - page_tab_count);
				}
				if (to_val > (total_tab_count - 1))
					to_val = (total_tab_count - 1);
				for (int j = from_val; j <= to_val; j++) 
				{
					encounterMapPage = (java.util.HashMap) SubSecRecordSet.getObject(j);
					SubSecRecordSet.setObject(j, encounterMapPage);
				}
				from_tab = Integer.parseInt(from);
				to_tab = Integer.parseInt(to);

				if (to_tab > (total_tab_count - 1))
					to_tab = (total_tab_count - 1);

				start = Integer.parseInt(from);
				end = Integer.parseInt(to);
			}
			
				%>
		<table  cellpadding=0 cellspacing=0 border='0' width='100%' height='48px'>			
			<tr>
				<td valign="top">
					<style>
div.menu3
{
    /*width:500px;margin:0 auto;*//*Uncomment this line to make the menu center-aligned.*/
    text-align:left;
    font-size:0;
    height: 25px;    
    border-bottom:1px solid #696000;
    *position:relative;*top:1px;/*Hacks for IE6 & IE7 */    
}

div.menu3 a
{
    display: inline-block;
    padding: 0 5px;
    margin-right:1px; /* It specifies the distance between each tab */
    /*background:#F7F7F7;*/
    color:Black;
    text-decoration:none;
   /* font: normal 12px Arial;*/
    line-height: 24px;
    border:1px solid #696000;
    border-bottom:0;
    color:#666;
    vertical-align:top;/*ChangeSet#2*/
    text-decoration:none;
    height:45px;
    width:240px;
    
    -webkit-border-radius: 4px;
	-moz-border-radius: 4px;
    border-radius: 4px 4px 0px 0px;
    behavior: url(../../eCA/html/PIE.htc);
}

</style>

					<div class="menu3">
						
						<% 
						for (int i = from_tab; i <= to_tab; i++) {
							encounterMap = (java.util.HashMap) SubSecRecordSet.getObject(i);
							if(null!=encounterMap && encounterMap.size() > 0)
							{
								encounterIndex++;
								encounter_id_spc = (String) encounterMap.get("ENCOUNTER_ID");
								patient_class_spc = (String) encounterMap.get("patient_class");
								location_code_spc = (String) encounterMap.get("ASSIGN_CARE_LOCN_CODE");
								if(i==from_tab){
									
									onLoadEncounterData = encounter_id_spc;
									onLoadPatientClassData = patient_class_spc;
									onLoadEncounterIndex = encounterIndex;
								}
								encounter_head_disp = (String) encounterMap.get("encounter_head_disp");
								%>								
								<a id='encounterTab<%=encounterIndex%>'   href="javascript:showEncounterSpecificData('<%=req_encounter_id%>','<%=encounter_id_spc%>','','<%=encounterIndex%>','<%=patient_class_spc%>');"  style="text-color:Red;font: <%=(String) encounterMap.get("tab_font_bold_yn")%> <%=(String) encounterMap.get("tab_font_size")%>pt  Verdana,SansSerif,Arial; background : <%=(String) encounterMap.get("tab_bg_color")%>;" onMouseOver="highlightOnSelection('<%=encounterIndex%>','<%=(String) encounterMap.get("tab_bg_color")%>');" onMouseOut="removehighlightOnSelection();">
									<img src="../../eCA/images/<%=(String) encounterMap.get("image_file_path")%>" border=0 /> &nbsp;
								<%= encounter_head_disp%>
								</a>
								
								<INPUT TYPE='hidden' name='encounter_id<%=i%>' id='encounter_id<%=i%>'  value='<%=encounter_id_spc%>' >
								<INPUT TYPE='hidden' name='encounterTabBgColor<%=encounterIndex%>' id='encounterTabBgColor<%=encounterIndex%>'  value='<%=(String) encounterMap.get("tab_bg_color")%>' >
								<%
							}	
						}
						if ((!(start <= 1))){
						%>	
							<A style="display: inline-block;padding: 0 5px;margin-right:1px;color:Black;text-decoration:none;line-height: 24px;border:0px;color:#666;vertical-align:middle;text-decoration:none;height:45px;width:10px;font: bold 38px Arial; background :#FFFFFF; " href='javascript:onClick=showNextPreviousData("Previous");' >&#60;</A>
						<%
						}
						if (!((start + page_tab_count) > total_tab_count)) {//IN049720 
						%>
							<A style="display: inline-block;padding: 0 10px;margin-right:1px;color:Black;text-decoration:none;line-height: 24px;border:0px;color:#666;vertical-align:middle;text-decoration:none;height:45px;width:10px;font: bold 38px Arial; background :#FFFFFF; " href='javascript:onClick=showNextPreviousData("Next");' >&#62;</A>
						<%}
						if(encounterIndex == 0){
								out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NOOPDAEENCOUNTER.label","ca_labels")+"</td></tr><table>");
						}

						%>			
					</div>
				</td>				
			</tr>
				<input type='hidden' value='<%=encounterIndex %>' name='totalVisits'>
				<input type='hidden' value='<%=onLoadEncounterIndex %>' name='encounterIndex'>
				<input type='hidden' value='<%=req_encounter_id %>' name='req_encounter_id'>
				<input type='hidden' value='' name='encounter_id_spc' id='encounter_id_spc'>
				<input type='hidden' name='total_tab_count' id='total_tab_count' value="<%=total_tab_count%>">
				<input type='hidden' name='from_tab' id='from_tab' value="<%=from_tab%>">
				<input type='hidden' name='to_tab' id='to_tab' value="<%=to_tab%>">
				<input type='hidden' name='from' id='from' value="<%=from%>">
				<input type='hidden' name='to' id='to' value="<%=to%>">
				<input type='hidden' name='disp_mode' id='disp_mode' value="<%=disp_mode%>">
				<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
				<input type='hidden' name='location_code_spc' id='location_code_spc' value="<%=location_code_spc%>">
				<input type='hidden' value='<%=request.getQueryString()%>' name='query_string'>
			
			</table>				
				<%		
		if(rsencounter!=null)rsencounter.close();		
		if(pstmtencounter!=null)pstmtencounter.close();
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
		%>
</body>
</HTML>
<SCRIPT LANGUAGE="JavaScript">	
	showEncounterSpecificData(
		<%=onLoadEncounterData%>,'','ONLOAD',<%=onLoadEncounterIndex%>,'<%=onLoadPatientClassData%>');		
	
		</SCRIPT>

