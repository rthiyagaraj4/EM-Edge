<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
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
<style>
</style>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/ClinicalEventHistoryNew.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function onLinePrinting(event_grp,fdate){
	var queryStr    = document.forms[0].queryString.value
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   	xmlHttp.open("POST", "../../eCA/jsp/NewCEHIntermediate.jsp?"+queryStr+"&group="+event_grp+"&fdate="+fdate+"&Mode=printResult", true);
   	xmlHttp.send(xmlDoc);
	alert(getMessage('RPT_SUBMIT_TO_PRINTER','OR'));
}
function onLinePrintingEvent(event_class){
	var queryStr    = document.forms[0].queryString.value
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   	xmlHttp.open("POST", "../../eCA/jsp/NewCEHIntermediate.jsp?"+queryStr+"&event_cls="+event_class+"&Mode=printEvent", true);
   	xmlHttp.send(xmlDoc);
	alert(getMessage('RPT_SUBMIT_TO_PRINTER','OR'));
}


</script>
</HEAD>
<%
	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	ArrayList eventsTreeArr = new ArrayList() ;
	String bean_id					= "NewClinicalEventHistBean" ;
	String bean_name				= "eCA.NewClinicalEventHistBean";
	String patient_id				= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String orderCatalogNature				=  request.getParameter("orderCatalogNature")==null?"":request.getParameter("orderCatalogNature");
	String selTab				=  request.getParameter("selTab")==null?"":request.getParameter("selTab");
	//IN069243 starts
	String strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String abnormal				=  request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
	String eventCls				=  request.getParameter("eventCls")==null?"":request.getParameter("eventCls");
	String eventGrp				=  request.getParameter("eventGrp")==null?"":request.getParameter("eventGrp");
	String eventItem				=  request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String patient_class = request.getParameter("ql_patClass")==null?"":request.getParameter("ql_patClass");
	String facilityid = (String)session.getValue("facility_id");
	//IN069243 ends

	String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String fromDate="",toDate="";
	String fac_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	fromDate = request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	toDate = request.getParameter("to_date")==null	?"":request.getParameter("to_date");
	
	if (toDate.equals(""))
		toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	
	String grphistory_type			= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");//IN069654
	NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 

	eCA.ChartRecordingAddGroupBean chartingBean = null; 
	chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+strEncId,"eCA.ChartRecordingAddGroupBean",session);
	chartingBean.clearBean();
	try{
		con = ConnectionManager.getConnection(request);	

		eventsTreeArr = bean.getEventTree(con,locale,grphistory_type,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate,orderCatalogNature,selTab,fac_id,abnormal,eventCls,eventGrp,eventItem,reln_id,patient_class,facilityid); //IN069654

%>
<BODY   class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='eventForm' id='eventForm'>

		<div id='divUnitTitle' style='postion:relative'>
			<table  width='100%' id='unitTitleTable' class='grid' border="1" cellspacing='0' cellpadding='3' align='center' >
				<TR><td class='gridHeader' colspan='3'>Event</td></TR>				
			</TABLE>
		</div>
		<table width='100%' id='unitTable' class='grid' border="1" cellspacing='0' cellpadding='3' align='center'>
		<%	String tempEventGroup = "";
			String tempEventClass  = "";
			String tempEventCode  = "";
			String fdate="";    //IN070032
			int count=0;
			for(int i=0;i<eventsTreeArr.size();i++){
			String[] event_list  = (String[])eventsTreeArr.get(i);
			if(tempEventClass.equals("") && tempEventGroup.equals("") && tempEventCode.equals("")){
		%>
			<TR id='<%=count++%>'>
				<TD colspan='2' class='CAFLOWSHEETLEVEL1' width='100%'><%=event_list[4]%>&nbsp;&nbsp;<img  src='../../eCA/images/Print.png' onclick="onLinePrintingEvent('<%=event_list[5]%>')" alt='Print Event'></img></TD>
			</TR>
			<TR id='<%=count++%>'>
				<!-- <TD colspan='2' class='CAFLOWSHEETLEVEL3' width='100%'><%=event_list[1]%>&nbsp;&nbsp;<img  src='../../eCA/images/Print.png' onclick="onLinePrinting('<%=event_list[0]%>')" alt='Print Result'></img></TD> -->
				<TD colspan='2' class='CAFLOWSHEETLEVEL3' width='100%'><%=event_list[1]%>&nbsp;&nbsp;<img  src='../../eCA/images/Print.png' onclick="onLinePrinting('<%=event_list[0]%>','<%=fdate %>')" alt='Print Result'></img></TD><!-- IN070032 -->
			</TR>
			<TR id='<%=count++%>'>
			<%if(event_list[6].equals("NUM"))
			{
			%>
				<TD class='gridDataChart' width='100%'><%=event_list[3]%></TD>
				<TD  class='gridDataChart' width='100%' align=center><input type='checkbox'  id='chkGraphID<%=count%>' name='chkGraph' value='<%=event_list[2]%>' onClick='constructValsForGraph(<%=count%>);'></input><input type='hidden' name='UOM<%=count%>' id='UOM<%=count%>' value='<%=event_list[7]%>'><input type='hidden' name='desc<%=count%>' id='desc<%=count%>' value='<%=event_list[3]%>'></TD>
			<%}else{%>
				<TD colspan='2' class='gridDataChart' width='100%'><%=event_list[3]%></TD>
			<%}%>
			</TR>
		<%
			}else{

				if(event_list[5].equals(tempEventClass)){
					if(event_list[0].equals(tempEventGroup)){
						if(!event_list[2].equals(tempEventCode)){
		%>
					<TR id='<%=count++%>'>
					<%if(event_list[6].equals("NUM"))
					{
					%>
						<TD class='gridDataChart' width='100%'><%=event_list[3]%></TD>
						<TD  class='gridDataChart' width='100%' align=center><input type='checkbox'  id='chkGraphID<%=count%>' name='chkGraph' value='<%=event_list[2]%>' onClick='constructValsForGraph(<%=count%>);'></input><input type='hidden' name='UOM<%=count%>' id='UOM<%=count%>' value='<%=event_list[7]%>'><input type='hidden' name='desc<%=count%>' id='desc<%=count%>' value='<%=event_list[3]%>'></TD>
					<%}else{%>
						<TD colspan='2' class='gridDataChart' width='100%'><%=event_list[3]%></TD>
					<%}%>
					</TR>
		<%				}
					}else{
		%>
					<TR id='<%=count++%>'>
					<!-- <TD colspan='2' class='CAFLOWSHEETLEVEL3' width='100%'><%=event_list[1]%>&nbsp;&nbsp;<img  src='../../eCA/images/Print.png' onclick="onLinePrinting('<%=event_list[0]%>')" alt='Print Result'></img></TD> -->
						<TD colspan='2' class='CAFLOWSHEETLEVEL3' width='100%'><%=event_list[1]%>&nbsp;&nbsp;<img  src='../../eCA/images/Print.png' onclick="onLinePrinting('<%=event_list[0]%>','<%=fdate %>')" alt='Print Result'></img></TD><!-- IN070032 -->
					</TR>
					<TR id='<%=count++%>'>
					<%if(event_list[6].equals("NUM"))
					{
					%>
						<TD class='gridDataChart' width='100%'><%=event_list[3]%></TD>
						<TD  class='gridDataChart' width='100%' align=center><input type='checkbox'  id='chkGraphID<%=count%>' name='chkGraph' value='<%=event_list[2]%>' onClick='constructValsForGraph(<%=count%>);'></input><input type='hidden' name='UOM<%=count%>' id='UOM<%=count%>' value='<%=event_list[7]%>'><input type='hidden' name='desc<%=count%>' id='desc<%=count%>' value='<%=event_list[3]%>'></TD>
					<%}else{%>
						<TD colspan='2' class='gridDataChart' width='100%'><%=event_list[3]%></TD>
					<%}%>
					</TR>
		<%
					}

				
				}else{
%>
					<TR id='<%=count++%>'>
						<TD colspan='2' class='CAFLOWSHEETLEVEL1' width='100%'><%=event_list[4]%>&nbsp;&nbsp;<img  src='../../eCA/images/Print.png' onclick="onLinePrintingEvent('<%=event_list[5]%>')" alt='Print Event'></img></TD>
					</TR>
<%					if(event_list[0].equals(tempEventGroup)){
						if(!event_list[2].equals(tempEventCode)){
		%>
					<TR id='<%=count++%>'>
					<%if(event_list[6].equals("NUM"))
					{
					%>
						<TD class='gridDataChart' width='100%'><%=event_list[3]%></TD>
						<TD  class='gridDataChart' width='100%' align=center><input type='checkbox'  id='chkGraphID<%=count%>' name='chkGraph' value='<%=event_list[2]%>' onClick='constructValsForGraph(<%=count%>);'></input><input type='hidden' name='UOM<%=count%>' id='UOM<%=count%>' value='<%=event_list[7]%>'><input type='hidden' name='desc<%=count%>' id='desc<%=count%>' value='<%=event_list[3]%>'></TD>
					<%}else{%>
						<TD colspan='2' class='gridDataChart' width='100%'><%=event_list[3]%></TD>
					<%}%>
					</TR>
		<%				}	
					}else{
		%>
					<TR id='<%=count++%>'>
					<!-- <TD colspan='2' class='CAFLOWSHEETLEVEL3' width='100%'><%=event_list[1]%>&nbsp;&nbsp;<img  src='../../eCA/images/Print.png' onclick="onLinePrinting('<%=event_list[0]%>')" alt='Print Result'></img></TD> -->
						<TD colspan='2' class='CAFLOWSHEETLEVEL3' width='100%'><%=event_list[1]%>&nbsp;&nbsp;<img align='right' src='../../eCA/images/Print.png' onclick="onLinePrinting('<%=event_list[0]%>','<%=fdate %>')" alt='Print Result'></img></TD><!-- IN070032 -->
					</TR>
					<TR id='<%=count++%>'>
					<%if(event_list[6].equals("NUM"))
					{
					%>
						<TD class='gridDataChart' width='100%'><%=event_list[3]%></TD>
						<TD  class='gridDataChart' width='100%' align=center><input type='checkbox'  id='chkGraphID<%=count%>' name='chkGraph' value='<%=event_list[2]%>' onClick='constructValsForGraph(<%=count%>);'></input><input type='hidden' name='UOM<%=count%>' id='UOM<%=count%>' value='<%=event_list[7]%>'><input type='hidden' name='desc<%=count%>' id='desc<%=count%>' value='<%=event_list[3]%>'></TD>
					<%}else{%>
						<TD colspan='2' class='gridDataChart' width='100%'><%=event_list[3]%></TD>
					<%}%>
					</TR>
		<%
					}

				}

			}
			tempEventGroup=event_list[0];
			tempEventClass=event_list[5];
			tempEventCode=event_list[2];
			
			}
		%>
		
			<!-- Don't delete below TR.-->
			<TR id='<%=count++%>'>
				<TD class='QRYEVENNOBORDER' colspan="2">&nbsp;</TD>
			</TR>			
		</Table>	
<input type=hidden name="noOfChkdBoxes" id="noOfChkdBoxes" value='0'>
<input type=hidden name="patient_id" id="patient_id" value='<%=patient_id%>'>
<input type=hidden name="encounter_id" id="encounter_id" value='<%=encounterId%>'>
<input type=hidden name='rowsForGraph' id='rowsForGraph' value='<%=count%>'>
<input type=hidden name='totRows' id='totRows' value='<%=count%>'>
<input type=hidden name='fromDate' id='fromDate' value='<%=fromDate%>'>
<input type=hidden name='toDate' id='toDate' value='<%=toDate%>'>
<input type='hidden' value="<%=request.getQueryString()%>" name="queryString" />
</form>		
	</BODY>
	<div id='extraTD' style='position:absolute; height:5%; width:30%; visibility:hidden;'></div>
<%}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
</html>

