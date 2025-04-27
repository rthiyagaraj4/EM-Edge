<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,com.ehis.util.*,webbeans.op.CurrencyFormat,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs	=null;

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";	
	String classval=""; String strFacilityId=""; int total_records=0;
	int noofdecimal = 2, curr_inp_cnt=0, exp_discharge = 0;
	String strPatientId="", strNursingUnitCode = "", strCalledFrom="",strExpDischrg="";
	String no_of_days="";
	String strDate="", strBookings="", strExpDischarge="";
	String params = "";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
	java.util.ResourceBundle bl_messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
	String strTitle=(String) bl_labels.getString("eBL.PAT_ENCOUNTER_DETAILS.label");

	String ws_no = p.getProperty("client_ip_address");

	try
	{
		con	=	ConnectionManager.getConnection(request);

		CurrencyFormat cf = new CurrencyFormat();

		strFacilityId = (String)httpSession.getValue("facility_id");
		if(strFacilityId==null) strFacilityId="";

		strPatientId = request.getParameter("patient_id");
		if(strPatientId==null) strPatientId="";	

		strNursingUnitCode = request.getParameter("nursing_unit_code");
		if(strNursingUnitCode==null) strNursingUnitCode="";	

		strCalledFrom = request.getParameter("called_from");
		if(strCalledFrom==null) strCalledFrom="";	

		no_of_days = request.getParameter("no_of_days");
		if(no_of_days==null) no_of_days="";	

		strExpDischrg = request.getParameter("exp_dischrg");
		if(strExpDischrg==null) strExpDischrg="0";	

		exp_discharge = Integer.parseInt(strExpDischrg);
		
		params = request.getQueryString();
		if(params==null) params="";	
		
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				noofdecimal  =  rs.getInt(1);		
			}	
			rs.close();
			pstmt.close();
			
		}
		catch(Exception e)
		{
			System.out.println("3="+e.toString());
		}
		
		try
		{	
			String curr_inp_qry = "Select count(*) from IP_NURSING_UNIT_BED where OCCUPYING_PATIENT_ID is not null and NURSING_UNIT_CODE='"+strNursingUnitCode+"' and PSEUDO_BED_YN='N'";

			pstmt = con.prepareStatement(curr_inp_qry);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				curr_inp_cnt  =  rs.getInt(1);		
			}	
			rs.close();
			pstmt.close();
			
		}
		catch(Exception e)
		{
			System.out.println("curr_inp_cnt="+e.toString());
		}
		
		curr_inp_cnt = curr_inp_cnt - exp_discharge;

%>
<HTML>
<HEAD>
</HEAD>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
		
		<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-5); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		</style>

<script>
function call_graph()
{
	var center='1';
	var dialogTop = "320";
	var dialogHeight = "25" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title="Occupancy Forecast Graph";
	title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions;
	retVal=window.showModalDialog("../../eBL/jsp/BLNursingUnitForecastGraph.jsp?"+param,arguments,features);
}

</script>
<body onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<form name='BLNursingUnitQueryForm' id='BLNursingUnitQueryForm' action="" method="post" target="">
<%
		try
		{				
//			String sqlPatEncDet="Select null IND_DATE,null NO_OF_BOOKINGS,null EXP_DISCHRG,null CURR_INP from dual where 1=2";
			String sqlPatEncDet="select to_char(sdate,'DD/MM/YYYY') IND_DATE,  (Select count(*) Booked_beds from ip_bed_booking where REQ_NURSING_UNIT_CODE='"+strNursingUnitCode+"' and to_date(a.sdate) between trunc(BLOCKED_FROM_DATE_TIME) and trunc(BLOCKED_UNTIL_DATE_TIME) and BOOKING_STATUS <> '4' and CANCELLED_BY_ID is  null) NO_OF_BOOKINGS,(Select count(*) from pr_encounter where trunc(nvl(discharge_date_time,EXP_DISCHARGE_DATE_TIME))= trunc(a.sdate) and PAT_CURR_LOCN_TYPE='N' and PAT_CURR_LOCN_CODE='"+strNursingUnitCode+"' and facility_id='"+strFacilityId+"') EXP_DISCHRG from ( select * from (select trunc((sysdate+1)+rownum-1) sdate from all_objects a where trunc((sysdate+1)+rownum-1) <= trunc(sysdate+"+no_of_days+"))) a";
/*				
			HashMap sqlMap = new HashMap();
			sqlMap.put("sqlData",sqlPatEncDet);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("IND_DATE");
			displayFields.add("NO_OF_BOOKINGS");
			displayFields.add("EXP_DISCHRG");
//			displayFields.add("CURR_INP");
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			//out.println("resutl==>"+result.size());
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{
*/
			
%>
<!--		<div>
		<table border='0' cellpadding='0' cellspacing='0' align = 'center' id='' width='100%'>						
			<tr>
				<td class='COLUMNHEADER' colspan='12'><div align='left'></div> </td>
			</tr>
			<tr>		
				<td width="100%" class='label'>&nbsp;</td>			
				
<%			
//				out.println(result.get(1));
%>
				</td>
			</tr>
		</table>
		</div>-->
		<div id="tbl-container" STYLE="overflow: auto; height: 156px;   padding:3px; margin: 0px">
		<table border='1' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
		<thead>
			<tr>			
				<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.booking.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='25%'><fmt:message key="eIP.ExpectedDischarge.label" bundle="${ip_labels}"/></td>
				<td class='COLUMNHEADER' width='25%'><fmt:message key="eBL.EXPECTED_IP.label" bundle="${bl_labels}"/></td>
			</tr>
		</thead>
<%
			pstmt = con.prepareStatement(sqlPatEncDet);
			rs = pstmt.executeQuery();	
			if( rs != null) 
			{
			while(rs.next())
			{
				int i=0;
/*
			int i=0;	
			ArrayList records=new ArrayList();
			for(int j=2; j<result.size(); j++)
			{
*/
   				if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
/*
				records=(ArrayList) result.get(j);		

				strDate = (String)records.get(0);
				if(strDate==null) strDate="";

				strBookings = (String)records.get(1);
				if(strBookings==null) strBookings="0";

				strExpDischarge = (String)records.get(2);
				if(strExpDischarge==null) strExpDischarge="0";
*/				
				strDate = rs.getString(1);
				if(strDate==null) strDate="";
				strBookings = rs.getString(2);
				if(strBookings==null) strBookings="0";

				strExpDischarge = rs.getString(3);
				if(strExpDischarge==null) strExpDischarge="0";

				int curr_bookings = Integer.parseInt(strBookings);
				int curr_exp_dischrg = Integer.parseInt(strExpDischarge);
				curr_inp_cnt = (curr_inp_cnt + curr_bookings)-curr_exp_dischrg;

				if(!strDate.equals(""))
					strDate = com.ehis.util.DateUtils.convertDate(strDate,"DMY","en",locale);
				
%>
		<tbody>
			<tr id=row<%=i%>>	
<%
				if(ws_no.equals("INDBGL-W00081"))
				{
%>
				<td class=<%=classval%> width='25%'><a href="javascript:call_graph();"><%=strDate%></a></td>
<%
				}
				else
				{
%>
				<td class=<%=classval%> width='25%'><%=strDate%></td>	 
<%
				}
%>
				<td class=<%=classval%> width='25%' style='text-align:right'><%=strBookings%></td>	 
				<td class=<%=classval%> width='25%' style='text-align:right'><%=strExpDischarge%></td>	
				<td class=<%=classval%> width='25%' style='text-align:right'><%=curr_inp_cnt%></td>	 				
			</tr>
<%
				i++;
				total_records++; 
			}
			rs.close();
			}//for loop
%>
		</tbody>
		</table>
		</div>
<%
				out.flush();
//			}
//			else
			if(total_records == 0)
			{

			 %>
		<div id="tbl-container" STYLE="overflow: auto; height: 156px;   padding:3px; margin: 0px">
		<table border='1' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
		<thead>
			<tr>			
				<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.booking.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='25%'><fmt:message key="eIP.ExpectedDischarge.label" bundle="${ip_labels}"/></td>
				<td class='COLUMNHEADER' width='25%'><fmt:message key="eBL.EXPECTED_IP.label" bundle="${bl_labels}"/></td>
			</tr>
		</thead>
			<tbody>
<%
		String noRecord = bl_messages.getString("BL9813");
%>
<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));
</script>

<!--
			<tr>
					<td colspan='10'><div align='center'><%=noRecord%> </div></td>
			</tr>
-->
			</tbody>
			</table></div>
<%
			}
		}
		catch(Exception ee)
		{
			System.err.println("Exception in OccForecast:" +ee); 
		}
%>
	<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>	
	<input type='hidden' name='params' id='params' value='<%=params%>'>	
	<input type='hidden' name='curr_inp_count' id='curr_inp_count' value='<%=curr_inp_cnt%>'>		

	<script>parent.frames[2].location.href='../../eCommon/html/blank.html';</script>

</form>
<!--
	<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLNursingUnitQueryResultsOccuForecastBody.jsp",searched));%> -->
</body>
<%
	}
	catch(Exception eee)
	{
		System.err.println("Exception main"+ eee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
</HTML>

