<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

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

		//String facility_id		=	(String) session.getValue("facility_id");




	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkRep.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script>

async function ShowComments(resultStr)
	{
		var comments;
		var retVal;
		var dialogHeight ='10' ;
		var dialogWidth = '30' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		retVal 			= await window.showModalDialog('../../eCA/jsp/ResComments.jsp?resultStr='+resultStr,arguments,features);
	}

async function getText_res(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)
{
	//alert("Histrectype..."+Histrectype+"...Contrsysid.."+Contrsysid+"...Accessionnum.."+Accessionnum+"..Contrsyseventcode..."+Contrsyseventcode);
	
	var win_height		= "28";
	var win_width		= "50";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){
		win_height		= "23";
		win_width		= "37";
		win_scroll_yn	= "no";
}

var retVal = new String();
//var dialogHeight = "28" ;
//var dialogWidth = "50" ;

var dialogHeight = win_height ;
var dialogWidth = win_width ;
var dialogTop = "122";
var status = "no";
var scroll = win_scroll_yn;
var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
var arguments	= Accessionnum ;

Accessionnum	=	escape(Accessionnum);
retVal =await  window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);
}

function addToList(obj,rowCnt,histdatatype,histrectype,accessionnum,contr_sys_id,contr_sys_event_code,result_disp,hist_rec_type_desc,event_date_time,sort_by)
{
	
	//alert("sort_by ...."+sort_by);
	//alert("histdatatype.in addto list.."+histdatatype+"..histrectype.."+histrectype+"..accessionnum.."+accessionnum+"..contr_sys_id.."+contr_sys_id+"..contr_sys_event_code.."+contr_sys_event_code+"...result_disp..."+result_disp+'...hist_rec_type_desc...'+hist_rec_type_desc+'...event_date_time...'+event_date_time);

	var mode='';
	var count =parseInt(parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.count.value);
	//alert("count..."+count);
	if(obj.checked)
	{
		mode ='add';
		count=count+1;
	}
	else
	{
		mode ='remove';
		count=count-1;
	}
	
	if(result_disp=="&nbsp;")
	{
		result_disp="SPACE";
	}
	
	//alert("result_disp.."+result_disp);

	var patient_id = parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.patient_id.value;
	var encounter_id = parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.encounter_id.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.sec_hdg_code.value;
	var child_sec_hdg_code = parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.child_sec_hdg_code.value;
	//alert("sec_hdg_code.."+sec_hdg_code+"..child_sec_hdg_code.."+child_sec_hdg_code);
	//(this,"+rowCnt+",'"+histdatatype+"','"+histrectype+"','"+accessionnum+"','"+contr_sys_id+"','"+contr_sys_event_code+"');
	//patient_id,encounter_id,sec_hdg_code,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode
	
	/*var ret_val = parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.return_str.value;

	var chk_val = eval("parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.chk_value"+rowCnt+".value");
	//alert("chk_val..."+chk_val);
	if(ret_val=="")
	{
		ret_val=chk_val;
	}
	else
	{
		ret_val=ret_val+"@"+chk_val;
	}
	parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.return_str.value=ret_val; */

	//histdatatype,histrectype,accessionnum,contr_sys_id,contr_sys_event_code
	//patient_id,encounter_id,sec_hdg_code,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode

	//var HTMLVal = "<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' type='text/css' /><script src='../../eCommon/js/ValidateControl.js' language='javascript'></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' method='post' action='RecClinicalNotesLinkMultiHistIntermediate.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code +"&histdatatype="+histdatatype+"&Histrectype="+histrectype+"&Contrsysid="+contr_sys_id+"&Contrsyseventcode="+contr_sys_event_code+"&Accessionnum="+encodeURIComponent(accessionnum,"UTF-8")+"&result_disp="+result_disp+"&hist_rec_type_desc="+hist_rec_type_desc+"&event_date_time="+event_date_time+"&mode="+mode+"&sort_by="+sort_by+"'></form></BODY></HTML>";
	var HTMLVal = "<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' type='text/css' /></HEAD><BODY CLASS='MESSAGE'><form name='form1' method='post' action='RecClinicalNotesLinkMultiHistIntermediate.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code +"&histdatatype="+histdatatype+"&Histrectype="+histrectype+"&Contrsysid="+contr_sys_id+"&Contrsyseventcode="+contr_sys_event_code+"&Accessionnum="+encodeURIComponent(accessionnum,"UTF-8")+"&result_disp="+result_disp+"&hist_rec_type_desc="+hist_rec_type_desc+"&event_date_time="+event_date_time+"&mode="+mode+"&sort_by="+sort_by+"'></form></BODY></HTML>";
		parent.messageFrame.document.write(HTMLVal);
		parent.messageFrame.document.forms[0].submit();

	parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.count.value =count;

}


</script>


</head>

<%
	
	Connection con = null;
	PreparedStatement stmt=null;
	PreparedStatement stHist=null;
	ResultSet rs=null;
	ResultSet rsHist=null;
	
	String	from_date_time		=	"",		to_date_time		=	"";
	String	from_date_time_th	=	"",		to_date_time_th		=	"";
	int		rowCnt			= 0 ;
	int		txt_count		= 0 ;

	int start = 0, end = 0 ,i=1;
	StringBuffer strsql1 = new StringBuffer(" ");

	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	
	if(!from_date_time.equals(""))
	{
		from_date_time_th	=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	}
	if(!to_date_time.equals(""))
	{
	to_date_time_th		=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	}

	String  patient_id	 = "";
	String  sec_hdg_code	 = "";
	String  child_sec_hdg_code	 = "";
	String  hist_rec_type	 = "";
	String  current_encounter	 = "";
	String	encounter_id = "";
	String	past_encounter_yn = "";
	String	past_encounter = "";
	String	pat_class_yn = "";
	String	pat_class = "";
	String	med_template = "";
	String	histrectype = "";
	String	histrectype_prev = "";
	String	hist_rec_type_desc = "";
	String	event_date_time = "";
	String	event_date = "";
	String	classValue = "";
	String	histdatatype = "";
	String data = "";
	String sqlHist ="";
	String resultstr="";
	String contr_sys_id = "";
	String accessionnum="";
	String contr_sys_event_code  = "";
	String eventdesc="";
	String result_disp="";
	String sort_by="";
	String secKey = "";
	String hashKey = "";
	String eventclassdesc = "";
	String preveventclass = "";
	String colspanval ="3";
	String curreventgroupevent="";
	String eventgroupdesc="";
	//String eventgroupdesc="";
	//String eventdesc="";
	String preveventgroupevent="";
	String event_date_prev="";
	String operation_mode="";
	String accession_num="";
//	String result_linked_key="";
	String chkstat = "";
	String from = "";
	String to = "";
	String facilityIdSel = "";

	
	//String curreventgroupevent="";
	int count = 0;
	boolean flag = true;
//	ArrayList arrList =new ArrayList();

	sqlHist="select count(*) from CR_ENCOUNTER_DETAIL_TXT where hist_rec_type =? and contr_sys_id = ? and accession_num = ? and contr_sys_event_code=?";
	


	patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	sec_hdg_code			=	(request.getParameter("sec_hdg_code")==null)	?	""	:	request.getParameter("sec_hdg_code");
	child_sec_hdg_code			=	(request.getParameter("child_sec_hdg_code")==null)	?	""	:	request.getParameter("child_sec_hdg_code");
	encounter_id		=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
	current_encounter		=	(request.getParameter("current_encounter")==null)	?	""	:	request.getParameter("current_encounter");
	past_encounter_yn		=	(request.getParameter("past_encounter_yn")==null)	?	""	:	request.getParameter("past_encounter_yn");
	past_encounter		=	(request.getParameter("past_encounter")==null)	?	""	:	request.getParameter("past_encounter");
	pat_class_yn		=	(request.getParameter("pat_class_yn")==null)	?	""	:	request.getParameter("pat_class_yn");
	pat_class		=	(request.getParameter("pat_class")==null)	?	""	:	request.getParameter("pat_class");
	med_template		=	(request.getParameter("med_template")==null)	?	""	:	request.getParameter("med_template");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");
	operation_mode		=	(request.getParameter("operation_mode")==null)	?	""	:	request.getParameter("operation_mode");
	accession_num		=	(request.getParameter("accession_num")==null)	?	""	:	request.getParameter("accession_num");
	sort_by		=	(request.getParameter("sort_by")==null)	?	""	:	request.getParameter("sort_by");
	from		=	(request.getParameter("from")==null)	?"1"	:	request.getParameter("from");
	to		=	(request.getParameter("to")==null)	?	"14"	:	request.getParameter("to");
	facilityIdSel		=	(request.getParameter("facilityIdSel")==null)	?	""	:	request.getParameter("facilityIdSel");
	
	start =Integer.parseInt(from);
	end =Integer.parseInt(to);
		try
		{
			con =  ConnectionManager.getConnection(request);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception caught in RecClinicalNotesLinkMultiHIstDetails.jsp ...@ 1" + e);
		}


	/*	try
		{
			
			String sort_qry =" select DISPLAY_ORDER  from ca_section_hdg b where b.SEC_HDG_CODE=? and b.ADDED_FACILITY_ID =? ";

			stmt = con.prepareStatement(sort_qry);
			stmt.setString(1,sec_hdg_code);
			stmt.setString(2,facility_id);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			 sort_by = rs.getString("DISPLAY_ORDER")==null?"C":rs.getString("DISPLAY_ORDER");
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e )
		{
			e.printStackTrace();
			out.println("Exception caught in RecClinicalNotesLinkMultiHIst.jsp" + e);

		} */
		eCA.PatientBannerGroupLine manageEmailBean = null;
		manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

		//manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

		
	/*	if(operation_mode.equals("Update")|| operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum"))
		{
			try{
			String arrPopQry ="select a.RESULT_LINKED_KEY  from CA_SECTION_MULT_RESULT_KEY a where a.ACCESSION_NUM =? " ;

			stmt = con.prepareStatement(arrPopQry);
			stmt.setString(1,accession_num);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			 result_linked_key = rs.getString("RESULT_LINKED_KEY")==null?"":rs.getString("RESULT_LINKED_KEY");
			 arrList.add(result_linked_key);
			
				if(!manageEmailBean.returnSortList().contains(result_linked_key))
					{
						manageEmailBean.addRecordstoLine2(result_linked_key);
					}
			 
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				out.println("Exception caught in RecClinicalNotesLinkMultiHIstdetails.jsp ..@ 2" + e);
			}

		} */



	

	//manageEmailBean.clearBean(); 



	

	//out.println("patient_id..."+patient_id+"encounter_id..."+encounter_id+"hist_rec_type..."+hist_rec_type);
	
	
	strsql1.append(" Select a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'dd/mm/yyyy') event_date ,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX||DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'2') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind normalcy_str,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT From cr_encounter_detail a  where a.patient_id = ?");

	strsql1.append(" AND  EXISTS (SELECT 1 FROM CA_SECTION_RESULT_EVENT WHERE SEC_HDG_CODE=? AND EVENT_CODE=A.EVENT_CODE AND EVENT_GROUP_CODE=NVL(A.EVENT_GROUP,A.EVENT_CODE))"); 

	if(!from_date_time_th.equals("")){
		strsql1.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
		}

	if(!to_date_time_th.equals("")){
		strsql1.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+.00068287 "); //adding 59 seconds more to the todate
		}

	if(!facilityIdSel.equals(""))
		strsql1.append(" and a.facility_id = ?");

	if (!current_encounter.equals("N"))
		strsql1.append(" and a.encounter_id=? ");

	if(sort_by.equals("D"))
	  		strsql1.append(" order by a.event_date ");
	if(sort_by.equals("C"))
	  		strsql1.append(" order by a.hist_rec_type desc");

	
	try{
	
		//con =  ConnectionManager.getConnection(request);
				
		stHist=con.prepareStatement(sqlHist);
	
		stmt = con.prepareStatement(strsql1.toString());
		int count1=0;
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,patient_id);
		stmt.setString(++count1,sec_hdg_code);
	if(!from_date_time_th.equals(""))
		stmt.setString(++count1,from_date_time_th);			
	if(!to_date_time_th.equals(""))
		stmt.setString(++count1,to_date_time_th);
	if(!facilityIdSel.equals(""))
		stmt.setString(++count1,facilityIdSel);
	if (!current_encounter.equals("N"))
		stmt.setString(++count1,encounter_id);


		
	
		rs = stmt.executeQuery();
	%>
		<body onKeyDown="lockKey()">
		<form name='RecClinicalNotesLinkMultiHistDetForm' id='RecClinicalNotesLinkMultiHistDetForm'>
		<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
	<%

 /*	if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rs.next() ; */
		
	//while(rs.next()&& i<=end)
	int j=1;
	while(rs.next())
	{
			
			flag = false ;
			
			rowCnt++;
			data="";
			txt_count = 0;

			if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";
		
		histrectype = rs.getString("HIST_REC_TYPE")==null?"":rs.getString("HIST_REC_TYPE");
		hist_rec_type_desc = rs.getString("HIST_REC_TYPE_DESC")==null?"":rs.getString("HIST_REC_TYPE_DESC");
		eventclassdesc = rs.getString("event_class_desc")==null?"":rs.getString("event_class_desc");
		event_date_time = rs.getString("EVENT_DATE_TIME")==null?"":rs.getString("EVENT_DATE_TIME");
		event_date = rs.getString("event_date")==null?"":rs.getString("event_date");
		histdatatype = rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
		resultstr = rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
		contr_sys_id = rs.getString("contr_sys_id")==null?"":rs.getString("contr_sys_id");
		accessionnum = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
		contr_sys_event_code = rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code");
		eventdesc = rs.getString("event_desc")==null?"":rs.getString("event_desc");
		eventgroupdesc = rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");
		// eventdesc = rs.getString("event_desc");

		//result_disp = rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM")+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));

		if(histdatatype.equals("NUM"))
				{
					result_disp = rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM")+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
					if(result_disp.equals(""))
					{
						result_disp="&nbsp;";
					}
					data =data +result_disp; //rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM")+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
		//*** checking for if there is any STR  
					if(!resultstr.equals("") && resultstr !=null)
					{
						resultstr=replaceSpecialChar(resultstr);
						data=data +"<a href=javaScript:ShowComments('"+java.net.URLEncoder.encode(resultstr)+"')>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")+" </a>";
					}
					// 

					//stHist.clearParameters();
					
					stHist.setString(1,rs.getString("HIST_REC_TYPE"));
					stHist.setString(2,rs.getString("CONTR_SYS_ID"));
					stHist.setString(3,rs.getString("ACCESSION_NUM"));
					stHist.setString(4,rs.getString("contr_sys_event_code"));
					rsHist=stHist.executeQuery();

					/*
					sqlHist.append("select count(*) from CR_ENCOUNTER_DETAIL_TXT " );
					sqlHist.append(" where hist_rec_type = '"+rs.getString("HIST_REC_TYPE")+"' and contr_sys_id = '"+rs.getString("CONTR_SYS_ID")+"' " +
								" and accession_num = '"+rs.getString("ACCESSION_NUM")+"' and contr_sys_event_code ='"+rs.getString("contr_sys_event_code")+"' ");
						 stHist=con.prepareStatement(sqlHist.toString());
						 //out.println("insidesqlHist"+sqlHist.toString());
						 rsHist=stHist.executeQuery();
						 */
			
						if (rsHist.next()) 
						{ 
							

							if(rsHist.getInt(1) >0) {
							data=data +"<a href=\"javascript:getText_res('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' border=0 src='../../eCA/images/flow_text.gif' ></a></font>";
							txt_count = 1;
							}
						}

					//***

					/*if(!normalrange.equals(" - "))
						range = range + "Normal Range : "+normalrange+" ,	 ";
					if(!criticalrange.equals(" - "))
						range = range + "Critical Range : "+criticalrange; */
				}
				else if(histdatatype.equals("STR"))
				{

					result_disp = resultstr+"";
					if(result_disp.equals(""))
					{
						result_disp="&nbsp;";
					}
					data =data + resultstr+"";
					 //sqlHist  =new StringBuffer();
					//stHist.clearParameters();
					
					stHist.setString(1,rs.getString("HIST_REC_TYPE"));
					stHist.setString(2,rs.getString("CONTR_SYS_ID"));
					stHist.setString(3,rs.getString("ACCESSION_NUM"));
					stHist.setString(4,rs.getString("contr_sys_event_code"));
					 rsHist=stHist.executeQuery();

					/*
					sqlHist.append(" select count(*) from CR_ENCOUNTER_DETAIL_TXT ");
					sqlHist.append(" where hist_rec_type = '"+rs.getString("HIST_REC_TYPE")+"' and contr_sys_id = '"+rs.getString("CONTR_SYS_ID")+"' " +
								" and accession_num = '"+rs.getString("ACCESSION_NUM")+"' and contr_sys_event_code ='"+rs.getString("contr_sys_event_code")+"' ");
						 stHist=con.prepareStatement(sqlHist.toString());
						 rsHist=stHist.executeQuery();
						//out.println("insidesqlHist"+sqlHist.toString());


						*/
						while(rsHist.next()) 
						{ 
							

							if(rsHist.getInt(1) >0) {
							data=data +"<a href=\"javascript:getText_res('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' border=0 src='../../eCA/images/flow_text.gif' ></a></font>";
							txt_count = 1;
							}
						}

				}
				else if(histdatatype.equals("HTM")||histdatatype.equals("TXT"))
				{
					
							

							 
					

					
					//data = "<a href=\"javascript:showDocDetails('"+histdatatype+"','"+histrectype+"','"+accessionnum+"','"+java.net.URLEncoder.encode(eventdesc)+"','"+contr_sys_id+"','"+contr_sys_event_code+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";
					data = "<a href=\"javascript:getText_res('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' border=0 src='../../eCA/images/flow_text.gif' ></a></font>";

							
						
					

				}
				else if(histdatatype.equals("DOC"))
				{
				data = data + "<a href=\"javascript:showDocDetails('"+histdatatype+"','"+histrectype+"','"+accessionnum+"','"+java.net.URLEncoder.encode(eventdesc)+"','"+contr_sys_id+"','"+contr_sys_event_code+"')\"><img border=0 src='../../eCA/images/flow_text.gif'></img></a>";

				
				}



				else if(histdatatype.equals("IMG")) 
				{
					//data +="<a href=javascript:showDocDetails(\""+histdatatype+"\",\""+histrectype+"\",\""+accessionnum+"\",\""+java.net.URLEncoder.encode(eventdesc)+"\",\""+extimageapplid+"\")><img border=no src='../../eCA/images/flow_image.gif'></img></a>";
				}
		
	/*	if(sort_by.equals("D"))
		{
			if(!event_date.equals(event_date_prev))
			{
				out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><font size=1>"+event_date+"</font></td></tr>");	
			}
		} 

		if(!histrectype.equals(histrectype_prev))
			{
			out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><font size=1>"+hist_rec_type_desc+"</font></td></tr>");
			}
			
				if(!preveventclass.equals(eventclassdesc))
				{
					out.println("<tr ><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>");
					//printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>";
				}

				if (!eventgroupdesc.equals(""))
					 curreventgroupevent = "("+eventgroupdesc+")-"+eventdesc;
				else
					 curreventgroupevent = eventdesc;

				if(!curreventgroupevent.equals(preveventgroupevent))
					{
					out.println("<tr ><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1>" +curreventgroupevent+ "</font></td></tr>");
					}
					*/

			
			
			if(result_disp.equals("")||result_disp==null)
				result_disp ="&amp;nbsp;";//3
			
			//putting all in bean
	
				hashKey = histrectype+"~"+contr_sys_id+"~"+accessionnum+"~"+contr_sys_event_code+"~"+sec_hdg_code ;
			
			if(sort_by.equals("D"))
				{
					secKey = sort_by+"~"+event_date_time+"~"+histrectype+"~"+contr_sys_id+"~"+accessionnum+"~"+contr_sys_event_code+"~"+result_disp+"~"+hist_rec_type_desc+"~"+sec_hdg_code;

					

					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
				}
				else if(sort_by.equals("C"))
				{
					secKey=sort_by+"~"+histrectype+"~"+contr_sys_id+"~"+accessionnum+"~"+contr_sys_event_code+"~"+result_disp+"~"+hist_rec_type_desc+"~"+event_date_time+"~"+sec_hdg_code;

					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
					
				}

		
			
			if(operation_mode.equals("Update")|| operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum"))
			{
				if(manageEmailBean.returnSortList().contains(hashKey)&& !(manageEmailBean.returnList1().contains(hashKey)))
				{
					chkstat ="checked";
					count++;

					if(!manageEmailBean.returnSortList().contains(hashKey))
					{
						manageEmailBean.addRecordsToSortList(hashKey);
						manageEmailBean.addToHashMap(hashKey,secKey);
					}
				
				}
				else
				{
									
					chkstat ="";
				}
			}
			else
			{
				if(manageEmailBean.returnSortList().isEmpty())
				{
					chkstat ="";
				/*
				if(!(manageEmailBean.returnList1().contains(hashKey)))
				{
					chkstat ="checked";

					count++;
					if(!manageEmailBean.returnSortList().contains(hashKey))
						{
							manageEmailBean.addRecordsToSortList(hashKey);
							manageEmailBean.addToHashMap(hashKey,secKey);
						}
				}
				else
				{
					chkstat ="";
				}*/
				}
				else
				{
						
					if((manageEmailBean.returnSortList().contains(hashKey)))
					{
						chkstat ="checked";
						count++;

						/*if(!manageEmailBean.returnSortList().contains(hashKey))
							{
								manageEmailBean.addRecordsToSortList(hashKey);
								manageEmailBean.addToHashMap(hashKey,secKey);
							}*/
					}
					else
					{
						chkstat ="";
					}


				}
			}

				
				/*	if ( start != 1 )
				 for( int j=1; j<start; i++,j++ )
				 rs.next() ; */
		
				//while(rs.next()&& i<=end)



			if((j<start)||(i>end))
			{
				j++;
				i++;
				continue;
			}

			if(sort_by.equals("D"))
		{
			if(!event_date.equals(event_date_prev))
			{
				out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><font size=1>"+event_date+"</font></td></tr>");	
			}
		} 

		if(!histrectype.equals(histrectype_prev))
			{
			out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><font size=1>"+hist_rec_type_desc+"</font></td></tr>");
			}
			
				if(!preveventclass.equals(eventclassdesc))
				{
					out.println("<tr ><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>");
					//printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>";
				}

				if (!eventgroupdesc.equals(""))
					 curreventgroupevent = "("+eventgroupdesc+")-"+eventdesc;
				else
					 curreventgroupevent = eventdesc;

				if(!curreventgroupevent.equals(preveventgroupevent))
					{
					out.println("<tr ><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1>" +curreventgroupevent+ "</font></td></tr>");
					}



			//new 

			out.println("<tr><td class='"+classValue+"' width='40%'>"+event_date_time+"</td><td class='"+classValue+"' width='40%'>"+data+"</td><td class='"+classValue+"' width='20%''><input type='checkbox' name ='select"+rowCnt+"' value ='' "+chkstat+" onClick=\"addToList(this,"+rowCnt+",'"+histdatatype+"','"+histrectype+"','"+accessionnum+"','"+contr_sys_id+"','"+contr_sys_event_code+"','"+java.net.URLEncoder.encode(result_disp)+"','"+hist_rec_type_desc+"','"+event_date_time+"','"+sort_by+"');\"><input type='hidden' name='chk_value"+rowCnt+"' id='chk_value"+rowCnt+"' value='"+histrectype+"~"+accessionnum+"~"+java.net.URLEncoder.encode(eventdesc)+"~"+contr_sys_id+"~"+contr_sys_event_code+"'></td></tr>");

							
				//count++;


			// putting
			event_date_prev =event_date;
			preveventgroupevent = curreventgroupevent;
			histrectype_prev = histrectype; //rowCnt
			preveventclass = eventclassdesc;
			//"+histrectype+"~"+accessionnum+"~"+java.net.URLEncoder.encode(eventdesc)+"~"+contr_sys_id+"~"+contr_sys_event_code+"
			//this,\'"+rowCnt+"\'
			//+",\'"+histdatatype+"\',\'"+histrectype+"\',\'"+accessionnum+"\',\'"+contr_sys_id+"\',\'"+contr_sys_event_code+"\'
	i++;
	j++;
	}
		
	putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);
	
	
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception caught in RecClinicalNotesLinkMultiHIst.jsp" + e);//COMMON-ICN-0181

	}
	finally 
	{
	
	ConnectionManager.returnConnection(con,request);
	}

	if(flag)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}



%>
		</table> 
		<!--<input type='hidden' name='return_str' id='return_str' value=""> -->
		<input type='hidden' name='count' id='count' value="<%=count%>">
		<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
		<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
		<input type='hidden' name='sec_hdg_code' id='sec_hdg_code' value="<%=sec_hdg_code%>">
		<input type='hidden' name='child_sec_hdg_code' id='child_sec_hdg_code' value="<%=child_sec_hdg_code%>">
	</form>
  </body>
</html>

<%!
	String replaceSpecialChar(String resultStr)
	{
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		return resultStr;
	}

%>

