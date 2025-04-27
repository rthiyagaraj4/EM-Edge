<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7		
21/07/2020  	IN072759	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.8
22/08/2020      IN073751    Chandrashekar                                   MO-CRF-20101.11
21/09/2020  	IN072760	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.9
26/11/2020	6450		SIVABAGYAM M	26/11/2020		RAMESH G	MO-CRF-20101.10
20/07/2023	  24094	   Ranjith P R		21/07/2023		RAMESH G		ML-MMOH-CRF-1804
---------------------------------------------------------------------------------------------------------------
*/
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCA/js/ClinicalEventHistoryNew.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function populateEvents(){
		var queryStr   =document.forms[0].queryString.value;
		//Adding start for IN072762
		var pract_id        = document.forms[0].clinician_id.value;
		var patient_class   = document.forms[0].patient_class.value;
		var patient_id      = document.forms[0].patient_id.value;
		var from_date       = document.forms[0].fromDate.value;
		var to_date         = document.forms[0].toDate.value;
		var generic_id      = document.forms[0].generic_id.value;
		var drug_id         = document.forms[0].drug_code.value;
		var status          = document.forms[0].med_status.value;
		var encounter_id    = document.forms[0].encounterId.value;
		var facility_id     = document.forms[0].fac_id.value;
		var selTab          = document.forms[0].selTab.value;
		var order_type      = document.forms[0].order_type.value;
		var date_order      = document.forms[0].date_Ordr.value;
		var item_type       = document.forms[0].item_type.value;
		var selHistType     = document.forms[0].selHistType.value;
		
		if("MEDN"==document.forms[0].selHistType.value){
				//parent.document.getElementById("eventDetails").cols="12%,0%,*,0%";
				parent.document.getElementById("eventNamesFrame").style.width="0vw";
				parent.document.getElementById("eventDataFrame").style.width="85vw";
				parent.eventDataFrame.location.href="../../eCA/jsp/MedicationOrdersFrams.jsp?pract_id="+pract_id+"&patient_class="+patient_class+"&patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&generic_id="+generic_id+"&drug_id="+drug_id+"&status="+status+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&selTab="+selTab+"&order_type="+order_type+"&date_order="+date_order+"&item_type="+item_type+"&selHistType="+selHistType;
		}else{//Adding end for IN072762
			if("CLNT"==document.forms[0].selHistType.value){
				//parent.document.getElementById("eventDetails").cols="12%,0%,*,0%";
				
				parent.document.getElementById("eventNamesFrame").style.width="0vw";
				parent.document.getElementById("eventDataFrame").style.width="85vw";

				parent.eventNamesFrame.location.href="../../eCommon/html/blank.html";	
				parent.eventDataFrame.location.href="../../eCA/jsp/ClinicalEventHistoryClinicalNoteData.jsp?"+queryStr; //IN071596			
			}else if("RDIN"==document.forms[0].selHistType.value){ //IN072759
				//parent.document.getElementById("eventDetails").cols="12%,0%,*,0%";
				parent.document.getElementById("eventNamesFrame").style.width="0vw";
				parent.document.getElementById("eventDataFrame").style.width="85vw";
				parent.eventNamesFrame.location.href="../../eCommon/html/blank.html";	
				parent.eventDataFrame.location.href="../../eCA/jsp/ClinicalEventHistoryRadiologyData.jsp?"+queryStr; //IN071596
			}
			else if("SUNT"==document.forms[0].selHistType.value){ //IN072760 starts
				//parent.document.getElementById("eventDetails").cols="12%,0%,*,0%";
				parent.document.getElementById("eventNamesFrame").style.width="0vw";
				parent.document.getElementById("eventDataFrame").style.width="85vw";
				parent.eventNamesFrame.location.href="../../eCommon/html/blank.html";	
				parent.eventDataFrame.location.href="../../eCA/jsp/ClinicalEventHistoryOTSurgeryData.jsp?"+queryStr;
			}//IN072760 ends
			else if("MERP"==document.forms[0].selHistType.value){ //6450 starts
				//parent.document.getElementById("eventDetails").cols="12%,0%,*,0%";
				parent.document.getElementById("eventNamesFrame").style.width="0vw";
				parent.document.getElementById("eventDataFrame").style.width="85vw";
				parent.eventNamesFrame.location.href="../../eCommon/html/blank.html";	
				parent.eventDataFrame.location.href="../../eCA/jsp/ClinicalEventHistoryMedicalReports.jsp?"+queryStr;
			}//6450 ends
			else{
				//parent.document.getElementById("eventDetails").cols="12%,25%,*,0%";
				parent.document.getElementById("eventNamesFrame").style.width="25vw";
				parent.document.getElementById("eventDataFrame").style.width="62vw";
				parent.eventNamesFrame.location.href="../../eCA/jsp/ClinicalEventHistoryResultEvents.jsp?"+queryStr;
				parent.eventDataFrame.location.href="../../eCA/jsp/ClinicalEventHistoryResultData.jsp?"+queryStr;
			}
			
		}    
		parent.controlsFrame.location.href="../../eCA/jsp/ClinicalEventHistoryControls.jsp?"+queryStr;
		parent.ClinicalEventButtonFrame.location.href="../../eCA/jsp/ClinicalEventHistoryButtons.jsp?"+queryStr;		
	}
	</script>
</HEAD>
<%
	Properties p;
	session 		= request.getSession(false);
	p 				= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale 	= (String) p.getProperty("LOCALE");
	Connection con 	= null;
	
	String bean_id				= "NewClinicalEventHistBean" ;
	String bean_name			= "eCA.NewClinicalEventHistBean";
	String bean_id_1			= "MedicationOrdersBean" ;//Added for MO-CRF-20101.11
	String bean_name_1			= "eCA.MedicationOrdersBean";//Added for MO-CRF-20101.11
	String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String facilityid 			= (String)session.getValue("facility_id");
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	String resp_id				= (String)session.getValue("responsibility_id");
	String orderCatalogNature	= request.getParameter("orderCatalogNature")==null?"":request.getParameter("orderCatalogNature");
	String ql_ref				= request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");//IN069654
	String ql_nlcyInd			= request.getParameter("ql_nlcyInd")==null?"":request.getParameter("ql_nlcyInd");//IN069654
	String selTab				= request.getParameter("selTab")==null?"":request.getParameter("selTab");
	//IN069654 starts
	String abnormal				= request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
	String eventCls				= request.getParameter("eventCls")==null?"":request.getParameter("eventCls");
	String eventGrp				= request.getParameter("eventGrp")==null?"":request.getParameter("eventGrp");
	String eventItem			= request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
	String date_Ordr			= request.getParameter("date_Ordr")==null?"":request.getParameter("date_Ordr");
	String reln_id				= request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String patient_class		= request.getParameter("ql_patClass")==null?"":request.getParameter("ql_patClass");
	//IN069654 ends
	if(date_Ordr.equals(""))
		date_Ordr="D";

	String encounterId 			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
	String fac_id 				= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String fromDate 			= request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	String toDate 				= request.getParameter("to_date")==null	?"":request.getParameter("to_date");	
	String grphistory_type		= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");
	String selHistType			= request.getParameter("selHistType")==null	?"LBIN":request.getParameter("selHistType");
	String med_status			= request.getParameter("status")==null	?"":request.getParameter("status");//IN072762
	String drug_code			= request.getParameter("drug_id")==null	?"":request.getParameter("drug_id");//IN072762
	String generic_id			= request.getParameter("generic_id")==null	?"":request.getParameter("generic_id");//IN072762
	String order_type        	= request.getParameter("order_type")==null	?"":request.getParameter("order_type");//IN072762
	String item_type            = request.getParameter("item_type")==null?"D":request.getParameter("item_type");//IN072762
	NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
	MedicationOrdersBean bean_1		= (MedicationOrdersBean)getBeanObject( bean_id_1, bean_name_1 , request) ;//IN072762
	ArrayList eventDates = new ArrayList() ;
	try{
		con = ConnectionManager.getConnection(request);	
		//eventDates = bean.getEventDates(con,locale,grphistory_type,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate,orderCatalogNature,selTab,fac_id,abnormal,eventCls,eventGrp,eventItem,reln_id,date_Ordr,patient_class,facilityid); //IN069654
		if(selHistType.equals("MEDN")){//Added if else Condition for MO-CRF-20101.11
		       if(item_type.equals(""))
				   item_type ="D";
			eventDates = bean_1.getMedicationEventDates(con,locale,patient_id,encounterId,clinician_id,fromDate,toDate,selTab,patient_class,fac_id,med_status,drug_code,generic_id,item_type,order_type,date_Ordr); 
		}else if(selHistType.equals("MERP")){//6450 starts
			bean.clear();
			ArrayList searchData = new ArrayList();		
			searchData = bean.getMedicalReports(patient_id,fac_id,clinician_id,fromDate,toDate,selTab,encounterId,date_Ordr,patient_class);
			eventDates=	bean.getEvent_date();
		}//6450 ends
		else{
		
		eventDates = bean.getEventDates(con,locale,selHistType,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate,orderCatalogNature,selTab,fac_id,abnormal,eventCls,eventGrp,eventItem,reln_id,date_Ordr,patient_class,facilityid); //IN069654
		}
%>
     <BODY   class='CONTENT' onMouseDown="CodeArrest()" onScroll='datesScrollFrame()' onKeyDown="lockKey()"><!-- Moved body and form below to here for IN073751  -->
				<form name='flowSheetEventsForm' id='flowSheetEventsForm'>
<%
		if(eventDates!=null && !(eventDates.isEmpty())){
%>
			<!-- moved up for IN073751<BODY   class='CONTENT' onMouseDown="CodeArrest()" onScroll='datesScrollFrame()' onKeyDown="lockKey()">
				<form name='flowSheetEventsForm' id='flowSheetEventsForm'> -->
					<div id='divDateTitle' style='postion:relative'>
						<TABLE  width='100%' id='dateTitleTable' class='grid' border="1" cellspacing='0' cellpadding='0' align='center' >
							<TR><td class='gridHeader' nowrap align="center">Recorded Date/Time</td></TR>				
						</TABLE>
					</div>
					<TABLE width='100%' id='dateTable' class='grid' border="1" cellspacing='0' cellpadding='0' align='center'>
						<%
						//24094 starts
						for(int i=0;i<eventDates.size();i++){
						HashMap<String,String>  resultMap= new HashMap<String,String>();
						resultMap = (HashMap<String,String>)eventDates.get(i);
						// 24094 ends
						%>
						<TR id='<%=i+1%>'>
							<TD class='QRYODDNOBORDER' width='100%' onClick="moveScroll('<%=i+1%>','<%=selHistType%>','<%=item_type%>','<%=(String)resultMap.get("Event_Date")%>');"><A href="#"><%=(String)resultMap.get("Event_Date")%></A>
							<!-- 24094  starts-->	
							<% String Modifiedyn =(String)resultMap.get("Modified_Date_YN");
							if(Modifiedyn.equals("Y")){%>
							&nbsp;<img src='../../eCA/images/modifiedresult.png' />
							<%}%></TD>
								<!-- item_type ,envdates added for //IN072762 --<!-- 24094 ends-->		
						</TR>
						<%--  <input type='hidden' name='modified_date' id='modified_date' value='<%=(String)resultMap.get("Modified_Date")%>'/><!-- 24094 -->	 --%>
					     <input type='hidden' name='event_date' id='event_date' value='<%=(String)resultMap.get("Event_Date")%>'/><!-- 24094 -->	
					     <input type='hidden' name='modifiedyn' id='modifiedyn' value='<%=(String)resultMap.get("Modified_Date_YN")%>'/><!-- 24094 -->	
				    	<%}%>
						<TR>
							<TD class='QRYEVENNOBORDER' colspan="3">&nbsp;</TD>
						</TR>			
						<input type="hidden" name="currentScrollPositon" id="currentScrollPositon" value="0"/>			
					</Table>	
					<input type='hidden' value="<%=request.getQueryString()%>" id='queryString' name='queryString' />
					<input type='hidden' value="<%=ql_ref%>" id='ql_ref' name='ql_ref' /><!--IN069654-->
					<input type='hidden' value="<%=ql_nlcyInd%>" id='ql_nlcyInd' name='ql_nlcyInd' /><!--IN069654-->
					<input type='hidden' value="<%=selHistType%>" id='selHistType' name="selHistType"/>
					<input type='hidden' value="<%=clinician_id%>" id='clinician_id' name="clinician_id"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=patient_class%>" id='patient_class' name="patient_class"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=patient_id%>" id='patient_id' name="patient_id"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=fac_id%>" id='fac_id' name="fac_id"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=date_Ordr%>" id='date_Ordr' name="date_Ordr"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=encounterId%>" id='encounterId' name="encounterId"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=fromDate%>" id='fromDate' name="fromDate"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=toDate%>" id='toDate' name="toDate"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=med_status%>" id='med_status' name="med_status"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=drug_code%>" id='drug_code' name="drug_code"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=generic_id%>" id='generic_id' name="generic_id"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=order_type%>" id='order_type' name="order_type"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=item_type%>" id='item_type' name="item_type"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=selTab%>" id='selTab' name="selTab"/><!-- MO-CRF-20101.11 -->
					<script>
						populateEvents();
						if(top.content!=null)
							top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";	
						else
							parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";	
				
					</script>
				<!-- moved body and for below for IN073751</form>
			</BODY> -->
		<%	
		}else{		
		%>
		            <input type='hidden' value="<%=request.getQueryString()%>" id='queryString' name='queryString' />
					<input type='hidden' value="<%=ql_ref%>" id='ql_ref' name='ql_ref' /><!--IN073751-->
					<input type='hidden' value="<%=ql_nlcyInd%>" id='ql_nlcyInd' name='ql_nlcyInd' /><!--IN073751-->
					<input type='hidden' value="<%=selHistType%>" id='selHistType' name="selHistType"/>
					<input type='hidden' value="<%=clinician_id%>" id='clinician_id' name="clinician_id"/><!-- IN073751 -->
					<input type='hidden' value="<%=patient_class%>" id='patient_class' name="patient_class"/><!-- IN073751 -->
					<input type='hidden' value="<%=patient_id%>" id='patient_id' name="patient_id"/><!-- IN073751 -->
					<input type='hidden' value="<%=fac_id%>" id='fac_id' name="fac_id"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=date_Ordr%>" id='date_Ordr' name="date_Ordr"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=encounterId%>" id='encounterId' name="encounterId"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=fromDate%>" id='fromDate' name="fromDate"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=toDate%>" id='toDate' name="toDate"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=med_status%>" id='med_status' name="med_status"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=drug_code%>" id='drug_code' name="drug_code"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=generic_id%>" id='generic_id' name="generic_id"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=order_type%>" id='order_type' name="order_type"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=item_type%>" id='item_type' name="item_type"/><!-- MO-CRF-20101.11 -->
					<input type='hidden' value="<%=selTab%>" id='selTab' name="selTab"/><!-- MO-CRF-20101.11 -->
			<script>
				var  selHistType = document.forms[0].selHistType.value;//ADding start for IN073751
				if(selHistType =="MEDN"){
					populateEvents();
				}else{//Adding end for IN073751
					parent.eventNamesFrame.location.href="../../eCommon/html/blank.html";
					parent.eventDataFrame.location.href="../../eCommon/html/blank.html";
					parent.controlsFrame.location.href="../../eCommon/html/blank.html";
					parent.ClinicalEventButtonFrame.location.href="../../eCommon/html/blank.html";<!--IN069243-->
					if(top.content!=null)			
						top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.";	
					else
						parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.";
				}
			</script>
			<%
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</BODY>
</html>

