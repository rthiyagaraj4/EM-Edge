<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String fac_id		= (String) session.getValue( "facility_id" ) ;
StringBuffer sql = new StringBuffer("") ; 

StringBuffer sql1 = new StringBuffer("") ;

String locale = (String)session.getAttribute("LOCALE");
int maxRecord = 0;
String locationType = request.getParameter("locationType") ;
if (locationType ==null) locationType="";
String group_id = request.getParameter("group_id") ; 
if (group_id ==null) group_id="";
String location = request.getParameter( "location" ) ;
if (location ==null) location="";
String fromdate = request.getParameter("fromDate") ;
if (fromdate ==null) fromdate="";
String todate = request.getParameter("toDate") ;
if (todate ==null) todate="";
String from = request.getParameter("from") ;
String to = request.getParameter( "to" ) ;
fromdate=DateUtils.convertDate(fromdate,"DMY",locale,"en");
todate=DateUtils.convertDate(todate,"DMY",locale,"en");

String group_name = request.getParameter("group_name") ;
if (group_name ==null) group_name="";

/*Below line added by senthil*/
int minpat_check=0;
String min_patient= request.getParameter("min_patient");if(min_patient==null) min_patient="";
if(!min_patient.equals("")) minpat_check=Integer.parseInt(min_patient);
//End senthil 


String classValue	 = "";
int start = 0 ;
int end = 0 ;
int i=1;

if ( from == null )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to == null )
	end = 14 ;
else
	end = Integer.parseInt( to ) ;

PreparedStatement pstmt=null;

Statement stmt				= null;
ResultSet rs				= null;
Connection conn = null;	

Statement stmt1				= null;
ResultSet rs1				= null;


Statement stmt2				= null;
ResultSet rs2				= null;


try {
	conn = ConnectionManager.getConnection(request);	
	stmt = conn.createStatement();	
	stmt1 = conn.createStatement();	
	
	stmt2 = conn.createStatement();	
	
	%>
	<HTML>
	<head>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script type="text/javascript">
	window.onload = function () { 
		if(document.getElementById("Qry_grp_appt_dtls")!=null){
			fxheaderInit('Qry_grp_appt_dtls',300);
		}
	}
	</script>
	<script>
		//function show_Reference_details(grp_id,app_date,prac_id,loc_type,loc)
		function show_Reference_details(fromTime,toTime,grp_id,app_date,prac_id,loc_type,loc)
		{
			var dialogHeight = "35" ;
			var dialogWidth	= "45" ;
			var dialogTop = "160" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			window.showModalDialog("../../eOA/jsp/GroupApptFrame.jsp?fromTime="+fromTime+"&toTime="+toTime+"&group_id="+grp_id+"&app_date="+app_date+"&prac_id="+prac_id+"&loc_type="+loc_type+"&loc="+loc,arguments,features);
		}
	//function overlap_details(fromTime,toTime,groupId,apptDate)
	function overlap_details(fromTime,toTime,group_id,apptDate,location)
		{ 	var dialogHeight = "35" ;
			var dialogWidth	= "45" ;
			var dialogTop = "160" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ; 
			window.showModalDialog("../../eOA/jsp/GroupApptOverlapFrames.jsp?fromTime="+fromTime+"&toTime="+toTime+"&group_id="+group_id+"&apptDate="
			+apptDate+"&location="+location,arguments,features);
			
		}
		/*Below  function modified for this incident [44296]*/
		function show_Appointmentslip_details(grp_id,app_date,prac_id,loc_type,loc,fromtime,totime)
		{
			var dialogHeight = "30" ;
			var dialogWidth	= "40" ;
			var dialogTop = "160" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			//window.showModalDialog("../../eOA/jsp/AppointmentSlip.jsp?app_date="+app_date+"&group_id="+grp_id+"&prac_id="+prac_id+"&loc_type="+loc_type+"&loc="+loc,arguments,features);
			if(confirm(getMessage("PRINT_APP_SLIP","OA"))){ 
			location.href="../../eOA/jsp/AppointmentSlip.jsp?app_date="+app_date+"&group_id="+grp_id+"&prac_id="+prac_id+"&loc_type="+loc_type+"&loc="+loc+"&fromtime="+fromtime+"&totime="+totime+"";
            alert(getMessage("REPORT_SUBMIT_SERVER","Common"));		 
		 }//else{
		   //}
		}
	
 
  
function showTooltip(e,text,div, title, desc)
{ 
if(text!=""&&text=="t2"){
 div.style.display = 'inline'; 
// div.style.position = 'relative';
 div.style.position = 'absolute';
 //div.style.float='right';
  document.getElementById("t2").style.top = e.y;
 document.getElementById("t2").style.left = e.x;
 div.style.width = '200';
 div.style.backgroundColor = '#EFFCF0';  
 div.style.border = 'dashed 1px black';
 div.style.padding = '10px';
 //div.innerHTML = '<b>' + title + '</b><div style="padding-left:10; padding-right:5">' + desc + '</div>';
 div.innerHTML ='<div style="padding-left:10; padding-right:5">' + desc + '</div>';
 }else{
 hideTooltip(div);
 }
 
}
 
function hideTooltip(div)
{
 div.style.display = 'none';
}
</script>
	
		
	</script>
	
	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
		</head>
	<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
	<form name='QueryGroupResult' id='QueryGroupResult'>

	<%

		sql.append(" where ");  sql1.append(" where "); 
		if(!locationType.equals("")){
			sql.append("CARE_LOCN_TYPE_IND='"+locationType+"' and ") ;
			sql1.append("CARE_LOCN_TYPE_IND='"+locationType+"' and ") ;
		}
		if(!location.equals("")){
			sql.append(" clinic_code = '"+location+"' and ");
			sql1.append(" clinic_code = '"+location+"' and ");
		}
		
		if(!group_id.equals("")){
			sql.append("group_id='"+group_id+"' and ") ;
			sql1.append("group_id='"+group_id+"' and ") ;
		}

		if(!fromdate.equals("") && !todate.equals("")){
			sql.append("appt_date between to_date(nvl('"+fromdate+"','01/01/1400'),'dd/mm/yyyy') and ");
	        sql.append(" to_date(nvl('"+todate+"','31/12/5000'),'dd/mm/yyyy') ");
			sql.append("GROUP BY TO_CHAR (appt_date, 'dd/mm/yyyy'),practitioner_id,GROUP_ID,RESOURCE_CLASS,appt_slab_from_time,appt_slab_to_time order by  appt_Date , appt_slab_from_time, appt_slab_to_time DESC");
			
			sql1.append("appt_date between to_date(nvl('"+fromdate+"','01/01/1400'),'dd/mm/yyyy') and ");
	        sql1.append(" to_date(nvl('"+todate+"','31/12/5000'),'dd/mm/yyyy') ");
			}
		
		StringBuffer sqlStr = new StringBuffer("");
		sqlStr.append("select distinct TO_CHAR (appt_Date, 'dd/mm/yyyy') appt_Date,practitioner_id,group_id,count(APPT_REF_NO) as no_appt,nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time,nvl(to_char(appt_slab_to_time,'hh24:mi'),' ') appt_slab_to_time,RESOURCE_CLASS from oa_appt");
		
	   StringBuffer sqlStr1 = new StringBuffer("");
	   sqlStr1.append("select  AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name1, AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') practitioner_name2, AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') practitioner_name3 from  oa_appt ");
	   
	   	
	   
	   sqlStr1.append(sql1.toString());
		
		sqlStr.append(sql.toString());
		
		rs = stmt.executeQuery(sqlStr.toString());
	
			 if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
				rs.next() ;
				
			}
			while ( i<=end && rs.next() )
				{
					if(maxRecord==0)
					{
			%>
			<P>
			<table align='right'>
			<tr>
		<%	if ( !(start <= 1) )
				
			/*Below line modified for this incident [44253]*/	
			 out.println("<td align ='right' id='prev'><A HREF='../../eOA/jsp/QueryGroupApptResult.jsp?locationType="+locationType+"&group_name="+group_name+"&min_patient="+min_patient+"&group_id="+group_id+"&location="+location+"&fromDate="+fromdate+"&toDate="+todate+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/QueryGroupApptResult.jsp?locationType="+locationType+"&group_name="+group_name+"&min_patient="+min_patient+"&group_id="+group_id+"&location="+location+"&fromDate="+fromdate+"&toDate="+todate+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		    sql.setLength(0);
		%>
			</tr>
			</table><br>
			</P>
			<table border="1" width="100%" cellspacing='0' cellpadding='0' id="Qry_grp_appt_dtls">
			<tr height='15%'>
			<th class='COLUMNHEADER'><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER'><fmt:message key="eOA.AppointmentGroups.label" bundle="${oa_labels}"/></th>
			<th class='COLUMNHEADER'><fmt:message key="eOA.PrintAllSlip.label" bundle="${oa_labels}"/></th>
			<th class='COLUMNHEADER'><fmt:message key="eOA.OverlapDetails.label" bundle="${oa_labels}"/></th>
			<th class='COLUMNHEADER' width="17%"><fmt:message key="eOA.noofpatsappts.label" bundle="${oa_labels}"/></th>
			</tr>
			
			<%}
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
					classValue = "QRYODD" ;
                    
					group_id = checkForNull(rs.getString("group_id"));
					String appt_Date= checkForNull(rs.getString("appt_Date"));
					String prac_id= checkForNull(rs.getString("PRACTITIONER_ID"));
					
					//String practitioner_name=checkForNull(rs.getString("practitioner_name"));
					
					String fromTime=checkForNull(rs.getString("appt_slab_from_time"));
				    String toTime=checkForNull(rs.getString("appt_slab_to_time"));
					
					String resource_class=checkForNull(rs.getString("RESOURCE_CLASS"));
					
					int referance_count=0;String minpat_indicator=""; String div_val=""; String disply_desc="";
					referance_count=rs.getInt("no_appt"); 
					if(referance_count<minpat_check){
					minpat_indicator="#FF9F9F"; //cursor_hand="cursor:pointer;";
					div_val="t2";					
					disply_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Grouppatient.label","oa_labels");
					}
					
					String overlapping="";int slapcount=0;
					//String count_Query="SELECT count(*) SlabOverLapCount  FROM oa_appt WHERE facility_id = '"+fac_id+"'   AND ((TO_DATE('"+fromTime+"','HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE ('"+toTime+"', 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE ('"+fromTime+"', 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'),'hh24:miss') < TO_DATE ('"+toTime+"', 'hh24:miss'))) AND appt_date = TO_DATE ('"+appt_Date+"', 'dd/mm/yyyy')   AND patient_id IN (SELECT patient_id FROM oa_group_dtls where group_id = '"+group_id+"')  and CLINIC_CODE not in('"+location+"')";
					String count_Query="SELECT count(*) SlabOverLapCount  FROM oa_appt WHERE facility_id = ?   AND ((TO_DATE(?,'HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE (?, 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE (?, 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'),'hh24:miss') < TO_DATE (?, 'hh24:miss'))) AND appt_date = TO_DATE (?, 'dd/mm/yyyy')   AND patient_id IN (SELECT patient_id FROM oa_group_dtls where group_id = ?)  and CLINIC_CODE not in(?)";
					
					
					//rs1 = stmt1.executeQuery(count_Query);
					pstmt = conn.prepareStatement(count_Query);
					pstmt.setString(1,fac_id);
					pstmt.setString(2,fromTime);
					pstmt.setString(3,toTime);
					pstmt.setString(4,fromTime);
					pstmt.setString(5,toTime);
					pstmt.setString(6,appt_Date);
					pstmt.setString(7,group_id);
					pstmt.setString(8,location);
					rs1 = pstmt.executeQuery();
					if(rs1.next()){
					  slapcount=rs1.getInt("SlabOverLapCount");				 	
					}
					if(0<slapcount){
					overlapping="Overlap Details";
					}else{
					overlapping="&nbsp;";
					}
					
					String practitioner_name="";
					rs2 = stmt2.executeQuery(sqlStr1.toString());
					if(rs2.next()){
					    if(resource_class.equals("P"))	
                           practitioner_name=checkForNull(rs2.getString("practitioner_name1"));
                        if(resource_class.equals("R"))	
                           practitioner_name=checkForNull(rs2.getString("practitioner_name2"));
                        if(resource_class.equals("E"))	
                           practitioner_name=checkForNull(rs2.getString("practitioner_name3")); 						
					}
					
					out.println("<tr>");
                    out.println("<td class='"+classValue+"'>" + appt_Date+"&nbsp;</td>");
					out.println("<td class='"+classValue+"'>"+practitioner_name+"&nbsp;</td>");
					out.println("<td class='"+classValue+"'>"+fromTime+"&nbsp;</td>");
					out.println("<td class='"+classValue+"'>" +toTime+"&nbsp;</td>");
					out.println("<td nowrap  class='"+classValue+"' style='color:blue;cursor:pointer;'> <a href=javascript:show_Reference_details('"+fromTime+"','"+toTime+"','"+group_id+"','"+appt_Date+"','"+prac_id+"')>"+group_name+"</a>&nbsp;</td>");
					out.println("<td nowrap  class='"+classValue+"' style='color:blue;cursor:pointer;'> <a href=javascript:show_Appointmentslip_details('"+group_id+"','"+appt_Date+"','"+prac_id+"','"+locationType+"','"+location+"','"+fromTime+"','"+toTime+"')>Appointment Slip</a></td>");
					/*Above line modified for this incident [44296]*/
					%>
					<td nowrap  class='<%=classValue%>' style='color:blue;cursor:pointer;'><%if(0<slapcount){%>
					<a href=javascript:overlap_details('<%=fromTime%>','<%=toTime%>','<%=group_id%>','<%=appt_Date%>','<%=location%>')><fmt:message key="eOA.OverlapDetails.label" bundle="${oa_labels}"/></a><%}%>&nbsp;</td>					
					<td nowrap width="17%" style="background-color:<%=minpat_indicator%>;border-style:SOLID;border-left-color:#D5E2E5;border-right-color: #D5E2E5;border-top-color:#D5E2E5;border-bottom-color:#D5E2E5;FONT-SIZE:9pt;cursor:pointer;" onMouseOut="hideTooltip(t2)" onMouseOver="showTooltip(event,'<%=div_val%>',t2, 'Group Appointment Details', '<%=disply_desc%>')"><%=referance_count%>&nbsp;</td>					
					<%					
					out.println("</tr>");
					i++;
					maxRecord++;
				}// while
	%>
	
	</table>
	
	<div style="display:none;float: center;" id="t2"></div>
	
	<%
	if(maxRecord == 0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
	<%}

	if ( maxRecord < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<%
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}
	
	if ( rs2!= null ) rs2.close() ;
	if ( stmt2 != null ) stmt2.close() ;

	if ( rs1 != null ) rs1.close() ;
	if ( stmt1 != null ) stmt1.close() ;
	
	if ( rs != null ) rs.close() ;
	if ( stmt != null ) stmt.close() ;
}
catch ( Exception e ){
	e.printStackTrace();
	//out.println("Exception  "+  e);
}

finally{

	if (conn !=null) ConnectionManager.returnConnection(conn,request);
	}
%>

<script>
parent.frames[1].document.forms[0].select.disabled=false;
</script>

</form>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}	
%>
</body>
</html>

