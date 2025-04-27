<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
20/05/2014    IN037701		Ramesh G				      					SKR-CRF-0036
18/06/2014	  IN049701		Nijitha S										SKR-CRF-0036	
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCA.*,java.net.URLEncoder,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCA/js/SinglePageConsultation.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesFileUpload.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<TITLE>Single Page Consultation</TITLE>
	<script>
		function resizeIframe(obj){
			if ( obj.readyState  == 'complete' ) {				
				document.forms[0].reloadWidgetCount.value=(parseInt(document.forms[0].reloadWidgetCount.value))+1;
				var reloadWidgetCount = document.forms[0].reloadWidgetCount.value;
				var totalWidgetCount = document.forms[0].totalWidgetCount.value;
				
				var newheight;
				
				if(document.getElementById){
					newheight=obj.contentWindow.document.body.scrollHeight;
				}
				
				obj.style.height= (newheight) + "px";
				if(parseInt(reloadWidgetCount)==parseInt(totalWidgetCount)){
					resizeAllIFrames();
				}
				
				return;
			}
			window.setTimeout('resizeIframe();', 100);
			
		}
 		function resizeIframe1(obj){
 			
			document.forms[0].reloadWidgetCount.value=(parseInt(document.forms[0].reloadWidgetCount.value))+1;
			var reloadWidgetCount = document.forms[0].reloadWidgetCount.value;
			var totalWidgetCount = document.forms[0].totalWidgetCount.value;			
			var newheight;
			if(document.getElementById){
				newheight=obj.contentWindow.document.body.scrollHeight;
			}
			obj.style.height= (newheight) + "px";
			if(parseInt(reloadWidgetCount)==parseInt(totalWidgetCount)){
				resizeAllIFrames();
			}
    	}
 		function resizeAllIFrames(){
 			var iframeCount = document.getElementsByTagName("iframe").length;
 			for(var i=1;i<=iframeCount;i++){
 				var F = document.getElementById("iFrameID"+i);
 				var TA = document.getElementById("TABLEID"+i).rows;
 				  if(F.contentDocument) {
 				  	TA[0].height = TA[0].height;
 					TA[1].height =  (F.contentDocument.documentElement.scrollHeight+30)+"px";
 					TA[2].height = TA[2].height; 
 				 } else {
 					TA[0].height = TA[0].height;
 					TA[1].height =  (F.contentWindow.document.body.scrollHeight)+"px";
 					TA[2].height = TA[2].height; 
 				 } 				
 				
 			}
 		
 		} 		
		function showResults(queryString){
			var dialogHeight	= "39" ;
			var dialogWidth		= "60" ;
			var status			= "no";
			var scroll			= "yes";
			var dialogTop		= "100";
			var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
			window.open('../../eCA/jsp/ViewResults.jsp?'+queryString+'&modal_YN=Y',"",arguments,features);
		}
		
		async function showFilteredData(retVal,widgetName){
			var dialogHeight	= "39" ;
			var dialogWidth		= "60" ;
			var status			= "no";
			var scroll			= "yes";
			var dialogTop		= "100";
			var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
			if("High Risk"==widgetName || "Active Problems"==widgetName){
				window.open(retVal,"","height=350,width=1000,scrollbars=yes");
			}else{
				var retData =await window.showModalDialog(retVal,arguments,features);
			}
		}

		async function recordTransaction(fileName,queryString,widgetName,tableId,oldtableId){
			var dialogHeight	= "39" ;
			var dialogWidth		= "60" ;
			var status			= "no";
			var scroll			= "yes";
			var dialogTop		= "100";
			var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
				
			if("Clinical Note for Nurse"==widgetName || "Clinical Note for Physician"==widgetName || "Personal and Family History"==widgetName || "Medication Certificate"==widgetName){
				var action_url ="../../eCA/jsp/RecClinicalNotesModal.jsp?"+queryString;
			 
				var title1="";
		
				var dialogHeight= "100";
				var dialogWidth	= "100";
				var status = "no";
				var arguments	= "";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				
				secondwindow  = window.showModalDialog(action_url, title1, features);	
				
				//top.content.workAreaFrame.singlepageconsultationworkflow.location.reload();
				if(((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).indexOf("&reloadTableId="))!=-1){
					top.content.workAreaFrame.singlepageconsultationworkflow.location.href = ((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).replace("&reloadTableId="+oldtableId,"&reloadTableId="+tableId));				
				}else{
					top.content.workAreaFrame.singlepageconsultationworkflow.location.href = top.content.workAreaFrame.singlepageconsultationworkflow.location.href+"&reloadTableId="+tableId;				
				}
			
			}else if("Allergies"==widgetName){
				var dialogHeight	= "100" ;
				var dialogWidth		= "60" ;
				var status			= "no";
				var scroll			= "yes";
				var dialogTop		= "100";
				var arguments	= "";
				var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
				
				var retData = window.showModalDialog(fileName+queryString,arguments,features);	
				//top.content.workAreaFrame.singlepageconsultationworkflow.location.reload();
				if(((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).indexOf("&reloadTableId="))!=-1){
					top.content.workAreaFrame.singlepageconsultationworkflow.location.href = ((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).replace("&reloadTableId="+oldtableId,"&reloadTableId="+tableId));				
				}else{
					top.content.workAreaFrame.singlepageconsultationworkflow.location.href = top.content.workAreaFrame.singlepageconsultationworkflow.location.href+"&reloadTableId="+tableId;				
				}
			}else if("Initial Assessment "==widgetName){
				var dialogHeight	= "100" ;
				var dialogWidth		= "60" ;
				var status			= "no";
				var scroll			= "yes";
				var dialogTop		= "100";
				var arguments	= "";
				var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
				
				var retData = window.showModalDialog(fileName+queryString,arguments,features);	
				//top.content.workAreaFrame.singlepageconsultationworkflow.location.reload();
				if(((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).indexOf("&reloadTableId="))!=-1){
					top.content.workAreaFrame.singlepageconsultationworkflow.location.href = ((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).replace("&reloadTableId="+oldtableId,"&reloadTableId="+tableId));				
				}else{
					top.content.workAreaFrame.singlepageconsultationworkflow.location.href = top.content.workAreaFrame.singlepageconsultationworkflow.location.href+"&reloadTableId="+tableId;				
				}
			}
			else if("Pending Schedules"==widgetName){//IN049701 Starts
				var retVal = 	new String();
				var dialogHeight= "42" ;
				var dialogWidth = "70" ;
				var dialogTop 	= "85";
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					
				retVal =await  window.showModalDialog(fileName+queryString,arguments,features);
				
				if (retVal != null && retVal != "")
				{
					var returnVal = retVal.split("^");
					var mode = returnVal[0];
					h = returnVal[1];
					if (mode=="1")
					{
						 h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');					
						 retVal =await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h,arguments,features);		
						 if (retVal=="OP")
							 recordTransaction(false);
					}
					else if (mode=="2")
					{
						 h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');
						 retVal =await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+h,arguments,features);
						 if (retVal=="OP")
							recordTransaction(false);
					}
					else if (mode=="3")
					{
						h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');
						retVal =await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+h,arguments,features);
						if (retVal=="OP")
							recordTransaction(false);
					}

					if(retVal != null && retVal != "")
					{		
						if(retVal !="")
						{						
							recordTransaction(fileName,queryString,widgetName);
						}
					}
				}
				top.content.workAreaFrame.location.reload();
			
			}//IN049701 Ends
			else{
				var retData = window.showModalDialog(fileName+queryString,arguments,features);
				//top.content.workAreaFrame.singlepageconsultationworkflow.location.reload();
				if(((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).indexOf("&reloadTableId="))!=-1){
					top.content.workAreaFrame.singlepageconsultationworkflow.location.href = ((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).replace("&reloadTableId="+oldtableId,"&reloadTableId="+tableId));				
				}else{
					top.content.workAreaFrame.singlepageconsultationworkflow.location.href = top.content.workAreaFrame.singlepageconsultationworkflow.location.href+"&reloadTableId="+tableId;				
				}
			}
		}

		function borderHighLite(obj){
			obj.className = 'borderhighlight';
		}
		
		function borderEnlight(obj){
			obj.className = '';
		}
		
		function refreshParent()
		{
			top.content.workAreaFrame.location.reload();			
		}

	</script>
	
	<%	
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String pageStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown='lockKey()' >
	<form name='singlepageconsultationform' id='singlepageconsultationform'>
		<%
			String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
			String patient_id = request.getParameter("patient_id");
			String encounter_id1 = request.getParameter("encounter_id") == null ? "" : (String) request.getParameter("encounter_id");
			String req_encounter_id = request.getParameter("encounter_id_spc") == null ? "": (String) request.getParameter("encounter_id_spc");
			
		%>
		
		<div id='main' style="position: absolute; width: 100%; height: 100%; left: 0px; padding-left: 10px;padding-right: 10px; background: #FFFFFF; overflow: auto; display: inline">
		<%
			Properties p = (Properties) session.getValue("jdbc");
			String locale = (String) p.getProperty("LOCALE");
			String encounter_id = null;
			String facility_id = (String) session.getValue("facility_id");
			String practitioner_id = null, speciality_name = null, patient_class = null,patient_class_spc="";
			practitioner_id = (String) session.getValue("ca_practitioner_id");
			if (practitioner_id == null)
				practitioner_id = "";
			speciality_name = request.getParameter("location_code") == null ? "": request.getParameter("location_code");
			String location_code_spc = request.getParameter("location_code_spc") == null ? "": request.getParameter("location_code_spc");
			patient_class = request.getParameter("patient_class") == null ? "EM": request.getParameter("patient_class");
			patient_class_spc = request.getParameter("patient_class_spc") == null ? "EM": request.getParameter("patient_class_spc");
			String reloadTableId = request.getParameter("reloadTableId") == null ? "": (String)request.getParameter("reloadTableId");
			String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");
			String widgetHeaderShade = request.getParameter("widgetHeaderShade");
			
			String qs = request.getQueryString();
			qs = qs.replace("&encounter_id="+encounter_id1,"&encounter_id="+req_encounter_id);
			qs = qs.replace("&episode_id="+encounter_id1,"&episode_id="+req_encounter_id);
			qs = qs.replace("&patient_class="+patient_class,"&patient_class="+patient_class_spc);
			qs = qs+"&facility_id="+facility_id;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			PreparedStatement pstmtencounter = null;
			ResultSet rsencounter = null;
			ArrayList positionsList = new ArrayList();
			HashMap<String, String> prefChartStyleMap = new HashMap<String, String>();
			List<String> displayIconDtl = new ArrayList<String>();
			String result_header_icon = "";
			String styleSheetName = "";
			String contentID = "";
			String fileName = "";
			String widgetName = "";
			//int totalRows = 0;
			String queryString = "";
			int encounterIndex = 0;
			int widgetIndex = 0;
			int totalWidgetCount = 0; //Ramesh
			//String strSql = "SELECT NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT,DECODE(M.INSTALL_YN,'Y',CSCN.CONTENT_EXEC_NAME,'N','../../eCA/jsp/blank.jsp') CONTENT_EXEC_NAME, CSCN.CONTENT_SYSDEF_DESC SYSTEM_DESC,CSCN.CONTENT_ID,CSCN.ADDL_CRITERIA_PARAM FROM ca_spc_content_lang_vw CSCN, SM_MODULE M  WHERE CSCN.LANGUAGE_ID = ? AND M.MODULE_ID = CSCN.MODULE_ID ORDER BY CSCN.CONTENT_ID";
			
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT, ");
			strSql.append("DECODE(M.INSTALL_YN,'Y',CSCN.CONTENT_EXEC_NAME,'N','../../eCA/jsp/blank.jsp') CONTENT_EXEC_NAME,");
			strSql.append("CSCN.CONTENT_SYSDEF_DESC SYSTEM_DESC,");
			strSql.append("CSCN.CONTENT_ID,");
			strSql.append("CSCN.ADDL_CRITERIA_PARAM,");
			strSql.append("ca_get_spc_style_id (?,?,?,csd.summary_id,csd.content_id) pref_chart_style ");
			strSql.append(" FROM CA_SPC_DETAIL csd,CA_spc_HEADER csh,ca_spc_content_lang_vw cscn, sm_module m ");
			strSql.append(" WHERE csh.summary_id = CA_GET_SPC_ID(?,?,?) ");
			strSql.append("AND csh.summary_id = csd.summary_id ");
			strSql.append("AND csd.content_id = cscn.content_id ");
			strSql.append("AND cscn.language_id = ? ");
			strSql.append("AND m.module_id = cscn.module_id ");
			strSql.append("ORDER BY TO_NUMBER(cscn.content_id)");
			String displayIconSql = "SELECT a.IMAGE_ICON_ALIGN IMAGE_ICON_ALIGN , b.NO_OF_MENU NO_OF_MENU,b.content_id content_id , a.image_icon_file image_icon_file, a.comp_exe_name comp_exe_name, a.comp_exe_tooltip comp_exe_tooltip,a.ADDL_CRITERIA_PARAM ADDL_CRITERIA_PARAM FROM CA_SPC_CRITERIA_DTL a,CA_SPC_CRITERIA_HDR b, CA_SPC_CONTENT c WHERE a.sum_criteria_id = b.sum_criteria_id and  b.content_id = c.content_id  AND c.content_id = ? order by to_number (a.sum_sl_no) desc";

			/**************** Ramesh **************/			
			StringBuilder widgetCountSql = new StringBuilder();
			widgetCountSql.append("SELECT COUNT(*) totalCount");
			widgetCountSql.append(" FROM CA_SPC_DETAIL csd,CA_spc_HEADER csh,ca_spc_content_lang_vw cscn, sm_module m ");
			widgetCountSql.append(" WHERE csh.summary_id = CA_GET_SPC_ID(?,?,?) ");
			widgetCountSql.append("AND csh.summary_id = csd.summary_id ");
			widgetCountSql.append("AND csd.content_id = cscn.content_id ");
			widgetCountSql.append("AND cscn.language_id = ? ");
			widgetCountSql.append("AND m.module_id = cscn.module_id ");
			widgetCountSql.append("ORDER BY cscn.content_id");
			/**************** Ramesh ***************/
			try {
				con = ConnectionManager.getConnection(request);
				/**************** Ramesh ****** Start *********/
				pstmt = con.prepareStatement(widgetCountSql.toString());
				pstmt.setString(1, location_code_spc);
				pstmt.setString(2, patient_class_spc);
				pstmt.setString(3, practitioner_id);
				pstmt.setString(4, locale);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					totalWidgetCount = Integer.parseInt((String)rs.getString("totalCount"));
				}
				
				if(pstmt!=null)pstmt.close();
				if(rs!=null) rs.close();
				
				/**************** Ramesh ******** End *******/
				pstmt = con.prepareStatement(strSql.toString());
				
				pstmt.setString(1, location_code_spc);
				pstmt.setString(2, patient_class_spc);
				pstmt.setString(3, practitioner_id);
				pstmt.setString(4, location_code_spc);
				pstmt.setString(5, patient_class_spc);
				pstmt.setString(6, practitioner_id);
				pstmt.setString(7, locale);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					//totalRows++;
					
					positionsList.add(rs.getString("TITLE_CONTENT")); //TITLE_CONTENT
					positionsList.add(rs.getString("CONTENT_EXEC_NAME")); //CONTENT_EXEC_NAME 	
					positionsList.add(rs.getString("SYSTEM_DESC")); //SYSTEM_DESC 	
					positionsList.add(rs.getString("CONTENT_ID"));//CONTENT_ID 
					positionsList.add(rs.getString("ADDL_CRITERIA_PARAM")==null?"":rs.getString("ADDL_CRITERIA_PARAM"));//ADDL_CRITERIA_PARAM 
					positionsList.add(rs.getString("pref_chart_style")==null?"":rs.getString("pref_chart_style"));//ADDL_CRITERIA_PARAM
					prefChartStyleMap.put(rs.getString("CONTENT_ID"), rs.getString("pref_chart_style"));
				}
				int count =1;
				for (int i = 0; i < positionsList.size(); i += 6) {
					widgetIndex++;
					if(("PRINT".equals(called_from) && "Y".equals(request.getParameter("print_yn"+widgetIndex))) || ("PRINTPREVIEW".equals(called_from) && "Y".equals(request.getParameter("print_yn"+widgetIndex))) || (!"PRINTPREVIEW".equals(called_from) && (!"PRINT".equals(called_from))))
					{
					fileName = (String) positionsList.get(i + 1);									
					if(fileName!=""){//&& prefChartStyleMap.containsKey(fileName)
						styleSheetName = prefChartStyleMap.get(positionsList.get(i+3));
						if(null!=styleSheetName && !"null".equals(styleSheetName) && styleSheetName!=""){
							out.println("<link rel='StyleSheet' href='../../eCommon/html/"+styleSheetName+"' type='text/css' />");
							contentID = (String)positionsList.get(i+3);
						}else{
							contentID="";
						 	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+pageStyle+"' type='text/css' />");
							styleSheetName=pageStyle;
						}
					}
					try {
						pstmt = con.prepareStatement(displayIconSql);
						pstmt.setString(1, (String) positionsList.get(i + 3));
	
						rs = pstmt.executeQuery();
						while (rs.next()) {
							displayIconDtl.add(rs.getString("content_id"));
							displayIconDtl.add(rs.getString("image_icon_file"));
							displayIconDtl.add(rs.getString("comp_exe_name"));
							displayIconDtl.add(rs.getString("comp_exe_tooltip"));
							displayIconDtl.add(rs.getString("NO_OF_MENU"));
							displayIconDtl.add(rs.getString("ADDL_CRITERIA_PARAM"));
							displayIconDtl.add(rs.getString("IMAGE_ICON_ALIGN"));
						}
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
									
					if( !"PRINTPREVIEW".equals(called_from) && encounter_id1.equals(req_encounter_id)){
						for (int cnt = 0; cnt < displayIconDtl.size(); cnt += 7) {
							if ("" != displayIconDtl.get(cnt + 1) &&  null != displayIconDtl.get(cnt + 1)&& "L".equals(displayIconDtl.get(cnt + 6))) {
								queryString = URLEncoder.encode(qs,"UTF-8")+ displayIconDtl.get(cnt + 5);

								if (!"".equals(encounter_id)) {
									widgetName = "<a style='color:ffffff' href='javascript:recordTransaction(\""+ displayIconDtl.get(cnt + 2)+ "?"+ "\",\""+ queryString+ "&title="+ displayIconDtl.get(cnt + 3)+ "&prefStyle="+ styleSheetName+ "&content_ID="+ displayIconDtl.get(cnt)+ "\",\""+ (String) positionsList.get(i + 2)+ "\",\"TABLEID"+count+"\",\""+reloadTableId+"\")' title='"+ displayIconDtl.get(cnt + 3)+ "'><img style='color:ffffff' src='../../eCA/images/"+ displayIconDtl.get(cnt + 1)+ "' align='left'/></a>"+widgetName;
								}
							}
						}
					}
					if( !"PRINTPREVIEW".equals(called_from) ){
						if (!displayIconDtl.isEmpty() && displayIconDtl.size() > 0) {
						for (int j = 0; j < displayIconDtl.size(); j += 7) {
							queryString =  URLEncoder.encode(qs,"UTF-8") + displayIconDtl.get(j + 5);
							if (null != displayIconDtl.get(j + 1) && "" != displayIconDtl.get(j + 2) && "R".equals(displayIconDtl.get(j + 6))) {
								result_header_icon = result_header_icon+ "<a style='color:ffffff' href='javascript:showFilteredData(\""+ displayIconDtl.get(j + 2)+ "?"+ queryString+ "&title="+ displayIconDtl.get(j + 3)+ "&prefStyle="+ styleSheetName+ "&content_ID="+ displayIconDtl.get(j)+ "\",\""+ (String) positionsList.get(i + 2)+ "\")' title='"+ displayIconDtl.get(j + 3)+ "'><img style='color:ffffff' src='../../eCA/images/"+ displayIconDtl.get(j + 1)+ "' align='right'/></a>";
							System.out.println("---------result_header_icon------>"+result_header_icon);
							}
							}
						}
					}	
					displayIconDtl.clear();
					fileName = fileName + "?" + qs+ "&title=" + positionsList.get(i)+ "&prefStyle=" + styleSheetName + "&content_ID="+ positionsList.get(i + 3)+positionsList.get(i+4)+"&chart_encounter_id="+encounter_id1;
					System.out.println("fileName:SinglePageConsultation.jsp"+fileName);
					
		%>

					
					<TABLE id="TABLEID<%=count%>" class="ROUNDCORNNERSTYLE<%=positionsList.get(i + 3) %>" cellpadding=0 cellspacing=0 border=0 width='100%'   >
						<TR>							
							<TD width="80%" class='COLUMNHEADERCENTERSPC<%=positionsList.get(i + 3) %>'>								
								 <%=widgetName%>&nbsp;<%=(String) positionsList.get(i)%>	
							</TD>
							<%
							if(!"PRINT".equals(called_from) && !"PRINTPREVIEW".equals(called_from))
							{
							%>
								<TD class='COLUMNHEADERCENTERSPC<%=positionsList.get(i + 3) %>' width="18%" align="right"><%=result_header_icon%>&nbsp;</TD>
								<TD class='COLUMNHEADERCENTERSPC<%=positionsList.get(i + 3) %>' width="5px;"><input type="checkbox" name='print_yn<%=widgetIndex%>' id='print_yn<%=widgetIndex%>' onclick='printWidget(this)' value="N" /></TD>
							<%
							}
							%>
						</TR>
						<TR style="background: #FFFFFF;" id="TRID<%=count%>">
							<TD align="center" colspan="3" valign="top">
								<TABLE cellpadding=0 cellspacing=0 width='100%' border=0>
								<TR>
									<TD valign="top" id="RecID<%=count%>">
											<%if(count!=12){%>
												<jsp:include page="<%=fileName %>"></jsp:include> &nbsp;
											<%}else{%>
												<iframe id="FrameID<%=count%>" src='<%=fileName %>' width='100%' height="600px;" frameborder='0' scrolling='no'></iframe>
											<%}%>
									</TD>
									
								</TR>										
								</TABLE>
							</TD>
						</TR>
						
					</TABLE>
					<br>
		<%
					result_header_icon = "";
					widgetName="";
					count++;
					}
				}
		%>
		
		<input type='hidden' value='<%=encounterIndex%>' name='totalVisits'>
		<input type='hidden' value='<%=req_encounter_id%>' name='req_encounter_id'> 
		<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
		<input type='hidden' name='no_of_widgets' id='no_of_widgets' value="<%=widgetIndex%>">
		<input type='hidden' name='called_from' id='called_from' value=''>
		<input type='hidden' name='reloadWidgetCount' id='reloadWidgetCount' value='0'>
		<input type='hidden' name='totalWidgetCount' id='totalWidgetCount' value='<%=totalWidgetCount %>'/>
		<input type='hidden' name='authorize_diagnosis' id='authorize_diagnosis' value=''/>
		<input type='hidden' name='option_id' id='option_id' value='<%=option_id%>'>
		<input type='hidden' name='chart_encounter_id' id='chart_encounter_id' value='<%=encounter_id1%>'>

		<%
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					ConnectionManager.returnConnection(con, request);
			}
		%>

		</div>
	</form>
</BODY>
</HTML>
<script>
		var called_from = '<%=called_from%>';
		if(!"PRINT"==called_from)
		{
			parent.singlepageconsultationActionButton.document.frmPrint.totalWidgetCount.value='<%=totalWidgetCount %>';
			parent.singlepageconsultationActionButton.document.frmPrint.totalVisits.value='<%=encounterIndex%>';
			parent.singlepageconsultationActionButton.document.frmPrint.req_encounter_id.value= '<%=req_encounter_id%>';
			parent.singlepageconsultationActionButton.document.frmPrint.patient_id.value= '<%=patient_id%>';
			parent.singlepageconsultationActionButton.document.frmPrint.no_of_widgets.value='<%=widgetIndex%>';
			parent.singlepageconsultationActionButton.document.frmPrint.called_from.value='';
			parent.singlepageconsultationActionButton.document.frmPrint.reloadWidgetCount.value='0';
			parent.singlepageconsultationActionButton.document.frmPrint.authorize_diagnosis.value='';
			parent.singlepageconsultationActionButton.document.frmPrint.option_id.value='<%=option_id%>';
			
			var no_of_widgets= document.getElementById("no_of_widgets").value;
			for(var k=1;k<=no_of_widgets;k++)
			{
				 parent.singlepageconsultationworkflow.document.getElementById("print_yn"+k).value = "Y";
				 parent.singlepageconsultationworkflow.document.getElementById("print_yn"+k).checked = true;
			}
		}	
		
		if('<%=reloadTableId%>'!="" ){
			var container = document.getElementById('main');
			var rowToScrollTo = document.getElementById('<%=reloadTableId%>');
			container.scrollTop = rowToScrollTo.offsetTop;
			rowToScrollTo.focus();
		}
		
			
</script>

