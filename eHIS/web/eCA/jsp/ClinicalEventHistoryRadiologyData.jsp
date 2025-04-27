<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7

---------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,java.math.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<HEAD>
		<TITLE> New Document </TITLE>
		<META NAME="Generator" CONTENT="EditPlus">
		<META NAME="Author" CONTENT="">
		<META NAME="Keywords" CONTENT="">
		<META NAME="Description" CONTENT="">
		<%
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCA/js/ClinicalEventHistoryNew.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script language='javascript' src='../../eCA/js/Encounters.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<%
	session = request.getSession(false);
	Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String ws_no			= (String) p.getProperty( "client_ip_address" )  ;
	String login_user 		= (String) session.getValue("login_user"); 
	String facilityid 		= (String) session.getValue("facility_id");
	String clinician_id		= (String) session.getValue("ca_practitioner_id");
	String resp_id			= (String) session.getValue("responsibility_id");
	String	login_user_id	= (String) session.getValue("login_user");
	
	
	String bean_id			= "NewClinicalEventHistBean" ;
	String bean_name		= "eCA.NewClinicalEventHistBean";
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	
	String selTab			=  request.getParameter("selTab")==null?"":request.getParameter("selTab");
	
	String called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
	String facility_id  	= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String patient_class	= request.getParameter("ql_patClass")==null?"":request.getParameter("ql_patClass");
	String strEncId			= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String abnormal			= request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
	String eventCls			= request.getParameter("eventCls")==null?"":request.getParameter("eventCls");
	String eventGrp			= request.getParameter("eventGrp")==null?"":request.getParameter("eventGrp");
	String eventItem		= request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
	String reln_id			= request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String date_Ordr		= request.getParameter("date_Ordr")==null?"":request.getParameter("date_Ordr");
	String encounterId 		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String strNormalcyInd 	= request.getParameter("normalcy")==null?"I":request.getParameter("normalcy");
	String fromDate 		= request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	String toDate 			= request.getParameter("to_date")==null	?"":request.getParameter("to_date");
	String grphistory_type	= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");
	String selHistType= request.getParameter("selHistType")==null	?"":request.getParameter("selHistType");
	System.out.println("facility_id===="+facility_id);
	String ql_ref= request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
	if(!ql_ref.equals(""))
		strNormalcyInd	= request.getParameter("ql_nlcyInd")==null?"I":request.getParameter("ql_nlcyInd");
	if(date_Ordr.equals(""))
		date_Ordr="D";
	String url				= application.getRealPath("/eCA")+"/";
	NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
	ArrayList searchData = new ArrayList();		
	searchData = bean.getSelectedClinicalNotesDetails(locale,patient_id,facility_id,clinician_id,resp_id,fromDate,toDate,login_user_id,url,selTab,encounterId,date_Ordr,eventCls,eventGrp,eventItem,selHistType,patient_class);//IN071596
	java.util.Date dt = new java.util.Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	   
%>
	<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<FORM name="" id="">
			
				<table class='grid' cellspacing=0 cellpadding=0 width='100%'>
					<%
					 System.out.println("		ClinicalEventHistoryClinicalNoteData.jsp  ----1---->"+formatter.format(dt));  
					int count = 1;
					for(int i=0;i<searchData.size();i++){
						HashMap<String,String>  resultMap= new HashMap<String,String>();
						resultMap = (HashMap<String,String>)searchData.get(i);
					%>
					<tr id='tableTRId<%=count%>'>
						<td class="CAHIGHERLEVELCOLOR">
							<input type=button name='collapseButton<%=count%>' id='collapseButton<%=count%>' id="collapseButton<%=count%>" value=' + ' onclick="collapseExpandNew(this,'<%=count%>');"> &nbsp; 
							&nbsp;
							<font size=1><%=(String)resultMap.get("Event_Date_Time")%></font>&nbsp;&nbsp;<%=(String)resultMap.get("Note_Type_Desc")%> </font>
						</td>
					</tr>
					<tr>
						<td>
							<table width='100%' id='tableId<%=count%>' style="display:none;">
								<tr>
									<td id='tableTDId<%=count%>'>&nbsp;</td>
								</tr>						
							</table>
						</td>
					</tr>
					<input type='hidden' name='hist_data_type<%=count%>' id='hist_data_type<%=count%>' value='<%=(String)resultMap.get("hist_data_type")%>'/>
					<input type='hidden' name='accessionNum<%=count%>' id='accessionNum<%=count%>' value='<%=(String)resultMap.get("accessionNum")%>'/>
					<input type='hidden' name='event_date_time<%=count%>' id='event_date_time<%=count%>' value='<%=(String)resultMap.get("Event_Date_Time")%>'/>
					<input type='hidden' name='contr_sys_event_code<%=count%>' id='contr_sys_event_code<%=count%>' value='<%=(String)resultMap.get("contr_sys_event_code")%>'/> 
					<input type='hidden' name='encounterId<%=count%>' id='encounterId<%=count%>' value='<%=(String)resultMap.get("reEncounterId")%>'/>
					<input type='hidden' name='facility_id<%=count%>' id='facility_id<%=count%>' value='<%=(String)resultMap.get("reFacilityId")%>'/>
					<%
					count++;
					}
					java.util.Date dt1 = new java.util.Date();
					System.out.println("ClinicalEventHistoryRadiologyData.jsp  ----2---->"+formatter.format(dt1));  
					%>
				</table>
				<input type='hidden' name='url' id='url' value='<%=url%>'/>
				<input type='hidden' name='clinician_id' id='clinician_id' value='<%=clinician_id%>'/>
				<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'/>
				<input type='hidden' name='login_user_id' id='login_user_id' value='<%=login_user_id%>'/>
				<input type='hidden' name='totalRecords' id='totalRecords' value='<%=count%>'/>
				<input type='hidden' name='strNormalcyInd' id='strNormalcyInd' value='<%=strNormalcyInd%>'/>
				<input type='hidden' name='selHistType' id='selHistType' value='<%=selHistType%>'/>
				<input type='hidden' name='currentSelectRecorde' id='currentSelectRecorde' value=''/>
			
		</FORM>
		<script>
			moveScroll('1','RDIN');
		</script>
	</BODY>
</HTML>

