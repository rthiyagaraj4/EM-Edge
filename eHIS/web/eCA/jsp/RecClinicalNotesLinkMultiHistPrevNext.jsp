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

		String facility_id		=	(String) session.getValue("facility_id");




	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkRep.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%

	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	StringBuffer strsql1 = new StringBuffer(" ");

	String disablePrev = " disabled ";
	String disableNext = "disabled";

	String	from_date_time		=	"",		to_date_time		=	"";
	String	from_date_time_th	=	"",		to_date_time_th		=	"";
		
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
	/*String	histrectype = "";
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
	String result_disp="";*/
	String sort_by="";
/*	String secKey = "";
	String eventclassdesc = "";
	String preveventclass = "";
	String colspanval ="3";
	String curreventgroupevent="";
	String eventgroupdesc="";
	//String eventgroupdesc="";
	//String eventdesc="";
	String preveventgroupevent="";
	String event_date_prev="";*/
	String operation_mode="";
	String accession_num="";
	String facilityIdSel="";
	

	int nKey = 0;
//	int nIndex =1;
	int maxRecord = 0;
//	int from_new = 0;
//	int to_new = 0;
	int noofpages = 0;
	int curidxval = 1;



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
	facilityIdSel		=	(request.getParameter("facilityIdSel")==null)	?	""	:	request.getParameter("facilityIdSel");

	//String from = request.getParameter( "from" ) ;
    //String to = request.getParameter( "to" ) ;

	// new 
	
	int start = 1 ;
    int end = 14 ;
//    int i=1;

 /*   if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ; */
	
	try
		{
			con =  ConnectionManager.getConnection(request);
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
			//out.println("Exception caught in RecClinicalNotesLinkMultiHIst.jsp" + e);//COMMON-ICN-0181

		}


	//new
	strsql1.append(" Select count(*) total From cr_encounter_detail a  where a.patient_id = ?");

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

	try
	{
		//con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(strsql1.toString());
		int count1=0;
		
		pstmt.setString(++count1,patient_id);
		pstmt.setString(++count1,sec_hdg_code);
	if(!from_date_time_th.equals(""))
		pstmt.setString(++count1,from_date_time_th);			
	if(!to_date_time_th.equals(""))
		pstmt.setString(++count1,to_date_time_th);
	if(!facilityIdSel.equals(""))
		pstmt.setString(++count1,facilityIdSel);
	if (!current_encounter.equals("N"))
		pstmt.setString(++count1,encounter_id);
		
	
//	int nCtr = 0;
		rs = pstmt.executeQuery();
		
//		String strDateRecd = "";
			//String strLastDt = "";

			while (rs.next())
			{
				
				//strDateRecd = rs.getString(1);
				maxRecord = rs.getInt("total"); 
				//out.println("date recievd++++"+strDateRecd);
						
			}

			noofpages =(int)Math.ceil(maxRecord/14);
			if(maxRecord%14>0)
			{
				noofpages++;
			}

			
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception cauight in RecClinicalNotesLinkmulticriteria.jsp" + e);//COMMON-ICN-0181
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}


		if ( !(start <= 1) )
		{
			disablePrev ="";
			//from_new = start-14;
			//to_new = end-14 ;
		}
		if ( !( (start+14) > maxRecord ) )
		{
			disableNext="";

			//from_new = start+14;
			///to_new=end+14;
		}



%>

</head>
<BODY  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='multiHistform' id='multiHistform' >
<input type = hidden  name = idx_value		value = <%=nKey%> - 1>
<input type = hidden  name = maxRecord		value = <%=maxRecord%>>
<input type = hidden  name = cur_idx_value	value = "0">

<input type = hidden  name = 'from_date'	value ='<%=from_date_time%>' >
<input type = hidden  name = 'to_date'		value ='<%=to_date_time%>'>
<input type = hidden  name = patient_id		value =<%=patient_id%> >
<input type = hidden  name = encounter_id		value =<%=encounter_id%>>
<input type = hidden  name = hist_rec_type		value =<%=hist_rec_type%>>
<input type = hidden  name = sec_hdg_code		value =<%=sec_hdg_code%>>
<input type = hidden  name = child_sec_hdg_code		value =<%=child_sec_hdg_code%>>
<input type = hidden  name = current_encounter		value =<%=current_encounter%>>
<input type = hidden  name = past_encounter_yn		value =<%=past_encounter_yn%>>
<input type = hidden  name = pat_class_yn		value =<%=pat_class_yn%>>
<input type = hidden  name = pat_class		value =<%=pat_class%>>
<input type = hidden  name = past_encounter		value =<%=past_encounter%>>
<input type = hidden  name = operation_mode		value =<%=operation_mode%>>
<input type = hidden  name = accession_num		value =<%=accession_num%>>
<input type = hidden  name = sort_by		value =<%=sort_by%>>
<input type = hidden  name = from		value =<%=start%>>
<input type = hidden  name = to			value =<%=end%>>
<input type = hidden  name = noofpages			value =<%=noofpages%>>
<input type = hidden  name = curidxval			value =<%=curidxval%>>
<input type = hidden  name = facilityIdSel			value =<%=facilityIdSel%>>

<% if(noofpages>0) {%>

<table border=0 cellpadding=3 cellspacing=0 width="100%" align='center' id='tablePrevNext' style='display'>
	<tr>
		<td  width='85%'></td>
		<td align='left' width='5%'><input type='button' id='prev' name='prev' id='prev' value='<' <%=disablePrev%> class='button' onclick='loadPrevNext1(this,document.forms[0].from.value,document.forms[0].to.value)' align='right'></td>
		<td  align ='center' class = 'QRYEVEN'>
				<input type ='label' class="LABEL" name = 'label_cap' readonly> 
		</td>
		<td align='left' width='5%'><input type='button' id='next' name='next' id='next' value='>' <%=disableNext%> class='button' onclick='loadPrevNext1(this,document.forms[0].from.value,document.forms[0].to.value)' ></td>
	</tr>
	
</table>

<%}%>

<script> 

function defaultPage()
{
	//var idx_value	= document.forms[0].idx_value.value;

	//var called_from = parent.encountercontrol.document.forms[0].called_from.value;
	//var graphorder = parent.encountercontrol.document.forms[0].strGraphOrder.value;
	
//	var cur_idx_value = document.forms[0].cur_idx_value.value;

	//var fromDateTime ="";
	//var toDateTime ="";
	var displend = "";
	var displstart = 1;

	//if(idx_value > 0)
	//{
	/*	fromDateTime	= dtArr[0];
		toDateTime		= dtArr[0];

		if (idx_value >= 1)
		{
			
				toDateTime = dtArr[1];
			

			displend = eval(idx_value) ;
		}
		else
			displend = 1; */
		//new
		var start	= document.forms[0].from.value;
		var end	= document.forms[0].to.value;
		if(start==null)
			start =1;
		else
			start = parseInt(start);
		
		if(end==null)
			end =14;
		else
			end = parseInt(end);

		

		var maxRecord	= document.forms[0].maxRecord.value;
		var noofpages	= document.forms[0].noofpages.value;
		var curidxval	= document.forms[0].curidxval.value;
		
		//alert('start..'+start+'..end...'+end+'...maxRecord...'+maxRecord);
		//displstart = ((start/14)+1).toFixed(0) ;
		displstart = curidxval ;
		//displend  =  (maxRecord)/14)+1 ;
		displend  =  noofpages ;
		//alert('displstart..'+displstart+'..displend...'+displend);
		//new


		//document.forms[0].cur_idx_value.value = 0;
		if(parseInt(noofpages)>0){
			document.forms[0].label_cap.value = displstart + " of " + displend;
		}

	/*	if(idx_value == 1)
		{
			document.forms[0].next.disabled = true;
			document.forms[0].prev.disabled = true;

		}*/

			//alert("fromDateTime..."+fromDateTime+"...toDateTime..."+toDateTime);
			populateControl1(start,end);
			
		
	//}
}

defaultPage();

</script>

</form>
</BODY>
</HTML>

