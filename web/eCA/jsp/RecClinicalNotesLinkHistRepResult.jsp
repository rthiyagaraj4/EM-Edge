<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
08/02/2012	IN030996	Menaka V	CA>Patient Chart>Clinical event history>When the already recorded details
										 are accessed we get Java Lang null pointer exception Script Error.
26/12/2013	IN045993	Ramesh G	Bru-HIMS-CRF-391-42552/10	
28/04/2014	IN048844	Chowminya	Issue with result linking a laboratory result  with a decimal point								 
--------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="Bean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
	<head>
		<title></title>
		<%
		  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");

	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkRep.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<%
	String	from_date_time		=	"",		to_date_time		=	"";
	String	from_date_time_th	=	"",		to_date_time_th		=	"";
    String  patient_id = "";
    String  hist_rec_type	 = "";
	String  class1	 = "";
    String  event_group	 = "";
   	String  comp_id_code	 = "";
    String  current_encounter	 = "";
	String	encounter_id = "";
    String  order_by1	 = "";
    String  order_by2	 = "";
    String  event_date_str	 = "";
    String  event_date_str_prev	 = "";
    String  event_group_desc	 = "";
    String  event_group_desc_prev = "";
    String  event_time_str	 = "";
    String  event_desc	 = "";
    String  result_num	 = "";
    String  result_num_uom	 = "";
    String  normalcy	 = "";
	String  normalcy_str	 = "";
    String  normal_low_value_str	 = "";
    String  normal_high_value_str	 = "";
    String  result_str	 = "";
    String  hist_data_exists	 = "";
    String  contr_sys_id	 = "";
    String  accession_num	 = "";
    String  abnormal	 = "";
    String  contr_sys_event_code	 = "";
    String  return_format	 = "";
    String  chkbox	 = "N";
    String classValue="";
    String hist_data_type="";
    String clearBean = "";
	
	StringBuffer strsql1 = new StringBuffer(" ");

	
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	from_date_time_th	=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time_th		=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
    patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");
	return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	class1				=	(request.getParameter("class1")==null)	?	""	:	request.getParameter("class1");
	event_group			=	(request.getParameter("event_group")==null)	?	""	:	request.getParameter("event_group");
	comp_id_code		=	(request.getParameter("comp_id_code")==null)	?	""	:	request.getParameter("comp_id_code");
	current_encounter	=	(request.getParameter("current_encounter")==null)	?	""	:	request.getParameter("current_encounter");
	order_by1			=	(request.getParameter("order_by1")==null)	?	""	:	request.getParameter("order_by1");
	order_by2			=	(request.getParameter("order_by2")==null)	?	""	:	request.getParameter("order_by2");
	abnormal			=	(request.getParameter("abnormal")==null)	?	"N"	:	request.getParameter("abnormal");
	clearBean			=	(request.getParameter("clearBean")==null)	?	"N"	:	request.getParameter("clearBean"); //Added by Archana Dhal on 5/26/2010 for IN021332.
	String from 		= 	request.getParameter("from");
	String to 			= 	request.getParameter("to");
	String rowid="";
		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	int start = 0 ;
	int end = 0 ;
	int i=1;
	int d=0;
	int t=0;
	int x=0;
	int k=0;
	int time=0;
	int maxRecord =0;
	
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;
    
	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

     //Added by Archana Dhal on 5/26/2010 for IN021332 start
	RecClinicalNotesLinkRepBean recBean  = (RecClinicalNotesLinkRepBean)getObjectFromBean("RecClinicalNotesLinkRepBean","eCA.RecClinicalNotesLinkRepBean",session);

	if(clearBean.equals("Y"))
	{
		recBean.clearBean();
	}
   //end


   	try
	{
      con =  ConnectionManager.getConnection(request);
	  StringBuffer str=new StringBuffer();
	  //PER110914 Starts
	  //str.append("SELECT COUNT(*) as total FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE NVL(A.STATUS,'*') != 'E' AND B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE AND C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP and C.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =?  AND A.EVENT_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY hh24:mi') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY hh24:mi')");
	  str.append("SELECT COUNT(*) as total FROM CR_ENCOUNTER_DETAIL A WHERE NVL(A.STATUS,'*') != 'E' AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =?");
		
	  if(!"".equals(from_date_time_th) && !"".equals(to_date_time_th))
	  {
		 str.append(" AND A.EVENT_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY hh24:mi') and TO_DATE(?,'DD/MM/YYYY hh24:mi')");
	  }
	 //PER110914 Ends
	  if(!(event_group.equals("")))
	  str.append(" and A.EVENT_GROUP =?");
	  
	  if(!(class1.equals("")))
	  str.append(" and A.EVENT_CLASS =?"); 
	  if(!(comp_id_code.equals("")))
		str.append(" and A.EVENT_CODE =?"); //PER110914

	  if (!current_encounter.equals("N"))
			str.append(" and a.encounter_id=? ");

	  if(abnormal.equals("Y"))
			 str.append(" and nvl(a.normalcy_ind,'.')!='.' ");

		stmt = con.prepareStatement(str.toString());
	 	
		int st1=0;

		stmt.setString(++st1,patient_id);     
		stmt.setString(++st1,hist_rec_type);
		//PER110914 Starts
		if(!"".equals(from_date_time_th) && !"".equals(to_date_time_th))	  
		{
			stmt.setString(++st1,from_date_time_th);
			stmt.setString(++st1,to_date_time_th);
		}
        //PER110914 Ends
	   if(!(event_group.equals("")))
		 stmt.setString(++st1,event_group);
        
	   if(!(class1.equals("")))
		   stmt.setString(++st1,class1);
		if(!(comp_id_code.equals("")))
		stmt.setString(++st1,comp_id_code);
       
	   if (!current_encounter.equals("N"))
			stmt.setString(++st1,encounter_id);	
	   

		rs = stmt.executeQuery();
	    
		if(rs!=null && rs.next())
			maxRecord=rs.getInt("total");
	
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();

		if (maxRecord== 0)
		{
			chkbox="Y";
			%>
	  			<script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				</script>
			<%
		}
		
	/*  strsql1.append("SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.LONG_DESC EVENT_GROUP_DESC,C.EVENT_GROUP,B.LONG_DESC EVENT_DESC, B.EVENT_CODE,	  A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,'ABNORMAL',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.FACILITY_ID,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP AND  c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =?  AND A.EVENT_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY hh24:mi') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY hh24:mi')");	
		
	  if(!(event_group.equals("")))
	  strsql1.append(" and C.EVENT_GROUP =?");
	  
	  if(!(class1.equals("")))
	  strsql1.append(" and A.EVENT_CLASS =?"); 
	  
	  if(!(comp_id_code.equals("")))
		strsql1.append(" and B.EVENT_CODE =?"); 

	  	if (!current_encounter.equals("N"))
			strsql1.append(" and a.encounter_id=? ");

		  
	  if(order_by1.equals("D"))
	   {
		if(order_by2.trim().equals("AS"))
		{
				strsql1.append(" order by A.EVENT_DATE,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
		}
		else
		{
			strsql1.append(" order by A.EVENT_DATE desc ,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
		}
	  }
	   else if (order_by1.equals("N"))
	   {
		if(order_by2.trim().equals("AS"))
		 {
			strsql1.append(" order by a.REQUEST_NUM_SEQ,C.LONG_DESC,A.EVENT_DATE");
		 }
	    else
		 {
		   strsql1.append(" order by a.REQUEST_NUM_SEQ desc,C.LONG_DESC desc,A.EVENT_DATE desc ");
		 }
	   }
		{
		strsql1.append(" ,6,7,8,9,3");
		}
		*/
		//
	  strsql1.append("SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.short_desc EVENT_GROUP_DESC,C.EVENT_GROUP,B.short_desc EVENT_DESC, B.EVENT_CODE,	  A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(a.normalcy_ind,HIGH_STR,'A',LOW_STR,'A',CRIT_STR,'C',ABN_STR,'A',CRIT_HIGH_STR,'C',CRIT_LOW_STR,'C','')FROM CR_CLIN_EVENT_PARAM) Normalcy_Str, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.FACILITY_ID,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLN_EVT_MST_LANG_VW B ,CR_CLN_EVT_GRP_LANG_VW C WHERE NVL(A.STATUS,'*') != 'E' AND B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND B.language_id = ? and C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP AND  c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND C.language_id(+) = ? AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =?  AND A.EVENT_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY hh24:mi') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY hh24:mi')");	
		
	  if(!(event_group.equals("")))
	  strsql1.append(" and C.EVENT_GROUP =?");
	  
	  if(!(class1.equals("")))
	  strsql1.append(" and A.EVENT_CLASS =?"); 
	  
	  if(!(comp_id_code.equals("")))
		strsql1.append(" and B.EVENT_CODE =?"); 

	  if (!current_encounter.equals("N"))
			strsql1.append(" and a.encounter_id=? ");

	  if(abnormal.equals("Y"))
			 strsql1.append(" and nvl(a.normalcy_ind,'.')!='.' ");
	//IN045993 Start.
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN042552
	String resp_id			= (String)session.getValue("responsibility_id") == null ? "" : (String) session.getValue("responsibility_id");
	strsql1.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.event_group),'N')='Y' "); //IN042552
	//IN045993 End.	  
	  
	  if(order_by1.equals("D"))
	   {
		if(order_by2.trim().equals("AS"))
		{
				strsql1.append(" order by A.EVENT_DATE,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
		}
		else
		{
			strsql1.append(" order by A.EVENT_DATE desc ,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
		}
	  }
	   else if (order_by1.equals("N"))
	   {
		if(order_by2.trim().equals("AS"))
		 {
			strsql1.append(" order by a.REQUEST_NUM_SEQ,C.LONG_DESC,A.EVENT_DATE");
		 }
	    else
		 {
		   strsql1.append(" order by a.REQUEST_NUM_SEQ desc,C.LONG_DESC desc,A.EVENT_DATE desc ");
		 }
	   }
		{
		strsql1.append(" ,6,7,8,9,3");
		}

		int st=0;
		stmt = con.prepareStatement(strsql1.toString());
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,patient_id);
		stmt.setString(++st,hist_rec_type);
   		stmt.setString(++st,from_date_time_th);
        stmt.setString(++st,to_date_time_th);
       
	   if(!(event_group.equals("")))
	   stmt.setString(++st,event_group);
	
		if(!(class1.equals("")))
		 stmt.setString(++st,class1);
		if(!(comp_id_code.equals("")))
		stmt.setString(++st,comp_id_code);

		if (!current_encounter.equals("N"))
			stmt.setString(++st,encounter_id);	

		rs = stmt.executeQuery();
		%>

<body onScroll="scrollTitle()" onKeyDown="lockKey()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<form name="RecClinicalNotesLinkMedResultForm" id="RecClinicalNotesLinkMedResultForm">	
<div id='divDataTitle' style='postion:relative'>
<table border="1" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr >


<%

if ( !(start <= 1) )
{
	out.println("<td width='85%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' class='CAGROUP'>");
	out.println("<A  class= 'gridLink' HREF='../../eCA/jsp/RecClinicalNotesLinkHistRepResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&current_encounter="+current_encounter+"&encounter_id="+encounter_id+"&event_group="+event_group+"&hist_rec_type="+hist_rec_type+"&return_format="+return_format+"&order_by1="+order_by1+"&order_by2="+order_by2+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"'"+"text-decoration='none' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
}
else
{
	out.println("<td width='100%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' class='CAGROUP'>");
}

  if ( !( (start+14) > maxRecord ) )
  {
	out.println("<A class= 'gridLink'  HREF='../../eCA/jsp/RecClinicalNotesLinkHistRepResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&current_encounter="+current_encounter+"&encounter_id="+encounter_id+"&event_group="+event_group+"&hist_rec_type="+hist_rec_type+"&return_format="+return_format+"&order_by1="+order_by1+"&order_by2="+order_by2+"&patient_id="+patient_id+"&from="+(start+14)+"&to="+(end+14)+"'"+" text-decoration='none' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
  }
%>	
</td>
</tr>
</table>
</div>
<table class='grid' width="100%" name="resultTable" id="resultTable" id="resultTable">
<TBODY id='allChkObj'>
	<% 

	if ( start != 1 )
	{
	    for( int j=1; j<start; i++,j++ )
		{
	       rs.next() ;
	    }
	}
	
		classValue = "gridData";
		int hdrCnt = 0;
		int subHdrCnt = 0;
		int eChkCnt = 0;
		while(rs!=null && rs.next() && i<=end)
		{
			 event_date_str=rs.getString("EVENT_DATE_STR")==null?"":rs.getString("EVENT_DATE_STR");
			 event_date_str	=	com.ehis.util.DateUtils.convertDate(event_date_str,"DMY","en",locale);
			 rowid=rs.getString("ROW_ID")==null?"":rs.getString("ROW_ID");
			 event_group_desc=rs.getString("EVENT_GROUP_DESC")==null?"":rs.getString("EVENT_GROUP_DESC");
			 event_time_str=rs.getString("EVENT_TIME_STR")==null?"":rs.getString("EVENT_TIME_STR");
			 event_desc=rs.getString("EVENT_DESC")==null?"":rs.getString("EVENT_DESC");
			 result_num=rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");
			 result_num_uom=rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
			 //normalcy_str=rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
			 normalcy = rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
			 //
				if  (normalcy.equals("A"))
					normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");
				else if(normalcy.equals("C"))
					normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
				else
					normalcy_str = "";
				
			 hist_data_type=rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
			 //IN048844 - modified Start
			//normal_low_value_str=rs.getString("normal_low_value_str")==null?"0":rs.getString("normal_low_value_str");
			 normal_low_value_str=rs.getString("normal_low_value_str")==null?"":rs.getString("normal_low_value_str");	
			//int normal_low_value=(int)Float.parseFloat(normal_low_value_str);
			//normal_low_value_str=String.valueOf(normal_low_value); 
			normal_high_value_str=rs.getString("normal_high_value_str")==null?"":rs.getString("normal_high_value_str");
			//normal_high_value_str=rs.getString("normal_high_value_str")==null?"0":rs.getString("normal_high_value_str");
			//int normal_high_value=(int)Float.parseFloat(normal_high_value_str);
			//normal_high_value_str=String.valueOf(normal_high_value);
			 //IN048844 - modified End
			result_str =rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
	   		hist_data_exists =rs.getString("HIST_DATA_EXISTS")==null?"":rs.getString("HIST_DATA_EXISTS");
		    contr_sys_id =rs.getString("CONTR_SYS_ID")==null?"":rs.getString("CONTR_SYS_ID");
			accession_num =rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
			contr_sys_event_code =rs.getString("CONTR_SYS_EVENT_CODE")==null?"":rs.getString("CONTR_SYS_EVENT_CODE");

			eChkCnt++;

			/*Below line is added and the following lines are commented by Archana Dhal on 5/26/2010 for IN021332 */

			List<String> selRowsId = recBean.getSelectedRows();	
			
            %>
			<!-- Below check box and hidden field names of Header, SubHeader and Elements are changed  by Archana Dhal on 5/26/2010 for IN021332 -->
				<tr>
				<td>
				<table class='grid' width='100%'>
				<tr>
					<td class="CAHIGHERLEVELCOLOR" colspan="2">
					<%
					time++;
					if(!event_date_str_prev.equals(event_date_str))
					{		
						++x;
						d++;
						hdrCnt++;
						subHdrCnt = 0;
						eChkCnt = 1;
						%>
						<input type="checkbox" name="ChkHDR_<%=hdrCnt%>" id="ChkHDR_<%=hdrCnt%>" onClick="perform(this,'<%=hist_rec_type%>','HDR', '<%=hdrCnt%>')" value="<%=hdrCnt%>" <%if(selRowsId != null && selRowsId.contains("HDR_"+rowid)){%>checked<%}%>>
						<%=event_date_str%>
						<input type='hidden' name='hidChkVal_<%=hdrCnt%>' id='hidChkVal_<%=hdrCnt%>' value="HDR_<%=rowid%>">
						<input type='hidden' name='hidHDR_<%=hdrCnt%>' id='hidHDR_<%=hdrCnt%>' value='D<%=d%>'> 
						<%
						event_group_desc_prev = "";
						t = 0;						
					}
					%>
					</td>				
				</tr>
				<%
				if(!event_group_desc_prev.equals(event_group_desc))
			    {
					++x;
					t++;
					eChkCnt = 1;
					subHdrCnt++;
					%>					 
					<tr>
						<td  class=CAGROUP colspan=2><input type="checkbox" name="ChkHDR_<%=hdrCnt%>_SUB_<%=subHdrCnt%>" id="ChkHDR_<%=hdrCnt%>_SUB_<%=subHdrCnt%>" onClick="perform(this,'<%=hist_rec_type%>', 'SUB', '<%=subHdrCnt%>')" value="<%=hdrCnt%>" <%if(selRowsId != null && selRowsId.contains("SUB_"+rowid)){%>checked<%}%> ><%=event_group_desc%></td>
						<input type='hidden' name='hidChkVal_<%=hdrCnt%>_SUB_<%=subHdrCnt%>' id='hidChkVal_<%=hdrCnt%>_SUB_<%=subHdrCnt%>' value="SUB_<%=rowid%>">
						<input type='hidden' name='hidHDR_<%=hdrCnt%>_SUB_<%=subHdrCnt%>' id='hidHDR_<%=hdrCnt%>_SUB_<%=subHdrCnt%>' value='D<%=d%>T<%=t%>'>
					</tr>
					<%
					time=1;
					
				 }
				%>
				<tr>	
					<td  class='<%=(hist_data_type.equals("HTM")?"OAYELLOW":"CAFOURTHLEVELCOLOR")%>' width='40%' >					
					<input type="checkbox" name="ChkHDR_<%=hdrCnt%>_SUB_<%=subHdrCnt%>_ELE_<%=eChkCnt%>" id="ChkHDR_<%=hdrCnt%>_SUB_<%=subHdrCnt%>_ELE_<%=eChkCnt%>" onClick="performchkbox(this,'<%=hist_rec_type%>')" value="<%=x%>" <%if(selRowsId != null && selRowsId.contains("ELE_"+rowid)){%>checked<%}%>  >
					<%=event_time_str%>&nbsp;&nbsp;<%=event_desc%>
					</td>
					<td class=CAFOURTHLEVELCOLOR>					
					<%if (hist_data_type.equals("NUM")){%>
					<%=result_num%>&nbsp;<%=result_num_uom%>&nbsp;&nbsp;&nbsp;<%=normalcy_str%>
					<!--<%//if(!normal_low_value_str.equals("0") && !normal_high_value_str.equals("0"))//{%> //IN048844-->
					<%if(!normal_low_value_str.equals("") && !normal_high_value_str.equals("")){%> 
							(<%=normal_low_value_str%>-<%=normal_high_value_str%>)
					<%}%>	
						<%if (!result_str.equals("")) %>
							&nbsp;<%=result_str%>&nbsp;
				
					<%}
					else if (hist_data_type.equals("STR")){%>
					<%=result_str%>&nbsp;
					<%}%>
					
					<%if(hist_data_exists.equals("Y")){%>
					
					<img id='textimg' src='../../eCA/images/flow_text.gif' onClick="return getText('<%=hist_rec_type%>','<%=contr_sys_id%>','<%=accession_num%>','<%=contr_sys_event_code%>')" >
									
					<%}%>
					</td>
					<input type='hidden' name='hidChkVal_<%=hdrCnt%>_SUB_<%=subHdrCnt%>_ELE_<%=eChkCnt%>' id='hidChkVal_<%=hdrCnt%>_SUB_<%=subHdrCnt%>_ELE_<%=eChkCnt%>' value="ELE_<%=rowid%>">
                    <input type='hidden' name='hidHDR_<%=hdrCnt%>_SUB_<%=subHdrCnt%>_ELE_<%=eChkCnt%>' id='hidHDR_<%=hdrCnt%>_SUB_<%=subHdrCnt%>_ELE_<%=eChkCnt%>' value='D<%=d%>T<%=t%>E<%=time%>'> 					
					</tr>
					</table>
				</td>
				</tr>							
			<%
				i++;
				k++;

				

				event_date_str_prev=event_date_str;
				event_group_desc_prev=event_group_desc;
		}%>
			<input type='hidden' name='totHDRChkCnt' id='totHDRChkCnt' value='<%=hdrCnt%>'>
		<%	
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		 	
	

}
			
			
catch(Exception e)
{
	e.printStackTrace(System.err);
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}

%>
			
	<input type="hidden" name="count" id="count" value="<%=k%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="countcheck" id="countcheck" value="<%=x%>">	
	<input type="hidden" name="enc_id" id="enc_id" value="<%=encounter_id%>"><!--IN030996-->	
	</TBODY>
			
</table>
<%if(chkbox.equals("N"))
{
out.println("<script>perform1()</script>");

}
%>
</form>
</body>
</script>
</html>

