<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   								 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
//String sStyle = "";
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
	String locale = (String) p.getProperty("LOCALE");
	%>



<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<SCRIPT LANGUAGE="JavaScript">
function show_Reference_details(appt_no2,fac_id2)
{
var dialogHeight = "37.5" ;
var dialogWidth	= "50" ;
var dialogTop = "160" ;
var center = "1" ;
var status="no";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;
window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}

function showToolTip(obj)
{
	var displayText = "<table cellpadding=3 cellspacing=0 border=0 width='100%' align='center'><td class=YELLOW>"+getLabel("eCA.ClickheretoviewSecondaryResources.label","CA")+"</td></table>";

	document.getElementById("secondaryResources").innerHTML = displayText;
	//document.getElementById("secondaryResources").style.top  = obj.offsetTop+15; 
	document.getElementById("secondaryResources").style.top  = obj.offsetTop+30; //Changed for CHL_CRF Issue
	document.getElementById("secondaryResources").style.left  = obj.offsetLeft ;
	document.getElementById("secondaryResources").style.visibility='visible' ;
	
	
}
function hideToolTip()
{
	document.getElementById("secondaryResources").style.visibility='hidden' ;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
	<!--<title><fmt:message key="eCA.PEND_SCH.label" bundle="${ca_labels}"/></title>--><!--IN035950-->
	<title><%=title%></title><!--IN035950-->
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<center>
		<form name='CAViewPatientAllergyForm' id='CAViewPatientAllergyForm' method='post'>
		<table class='grid' colspan=9 width='100%'>
		<!--IN037701 Starts-->
		<%if("CA_SPC".equals(p_called_from)){%>
			<tr>
					<td class='columnHeadercenter'  colspan="1" ><fmt:message key="eCA.LOCATIONORPRACT.label" bundle="${common_labels}"/></td>
					<td class='columnHeadercenter'  colspan="2" ><fmt:message key="eCA.APPOINTMENTDATE.label" bundle="${common_labels}"/></td>
					<td class='columnHeadercenter'  colspan="2" ><fmt:message key="eCA.ACCESSSEDBY.label" bundle="${common_labels}"/></td>
					<td class='columnHeadercenter'  colspan="2" ><fmt:message key="eCA.ACCESSEDDATETIME.label" bundle="${common_labels}"/></td>
			</tr>
			<%}%>
		<!--IN037701 Ends-->
			<% String patient_id = "", appt_date_str = "", pend_sche = "";
			String from_time_str = "",  to_time_str = "",classValue = "",	location_desc	=	"",currdate = "";
			String speciality_desc = "", resource_name = "",appt_ref_no = "",facility_id ="";
			int i=0,sec_resource_cnt=0;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet	rs = null;
			String modified_date = "";
			String modified_by_id = "";
			try	{
				patient_id = request.getParameter("patient_id");
				if(patient_id==null) patient_id = "";
				facility_id=(String) session.getValue("facility_id");
				//pend_sche = "select TO_CHAR(APPT_DATE,'DD/MM/YYYY') APPT_DATE_STR, TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR, TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI')  TO_TIME_STR, CLINIC_SHORT_DESC LOCATION_DESC, SPECIALITY_DESC, nvl2( PRACTITIONER_SHORT_NAME,DECODE(RESOURCE_CLASS,'P','Practitioner','R','Room')||'/',null)||PRACTITIONER_SHORT_NAME resource_name, APPT_REF_NO,(select count(appt_ref_no) from oa_resource_for_appt where appt_ref_no = oa_appt_vw.appt_ref_no  and FACILITY_ID=oa_appt_vw.FACILITY_ID)  sec_resource_cnt from oa_appt_vw where FACILITY_ID= ? AND PATIENT_ID=? AND  APPT_DATE>=trunc(sysdate) ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME ";
				// modified on 04/08/2010 for the Incident 23079	SRR20056-SCF-4928
				//pend_sche ="select TO_CHAR(APPT_DATE,'DD/MM/YYYY')APPT_DATE_STR,TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR, TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI') TO_TIME_STR,(CASE WHEN a.clinic_code IS NOT NULL THEN OP_GET_DESC.OP_CLINIC(a.facility_id,a.clinic_code,?,'1') END )LOCATION_DESC,(CASE WHEN a.clinic_code IS NOT NULL THEN (SELECT x.short_desc FROM am_speciality_LANG_vW x, op_clinic y WHERE x.speciality_code = y.speciality_code AND y.facility_id = a.facility_id AND y.clinic_code = a.clinic_code AND X.LANGUAGE_ID = ? ) END ) SPECIALITY_DESC, nvl2( B.SHORT_NAME,DECODE(RESOURCE_CLASS,'P','Practitioner','R','Room')||'/',null)||B.SHORT_NAME resource_name, APPT_REF_NO,(select count(appt_ref_no) from oa_resource_for_appt where appt_ref_no = a.appt_ref_no  and oa_resource_for_appt.FACILITY_ID=a.FACILITY_ID) sec_resource_cnt from oa_appt_vw A,am_practitioner_lang_vw B where A.FACILITY_ID= ? AND A.PATIENT_ID=? AND  A.APPT_DATE>=trunc(sysdate) and b.practitioner_id=a.practitioner_id      and b.language_id=? and ((ORDER_ID is not null and exists (select 1 from or_order_line where ORDER_ID = a.ORDER_ID and ORDER_LINE_NUM = a.ORDER_LINE_NUM and order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code 	WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF= 'EXT_COMPL_ORD') or order_status_type in ('99','96','97','93'))))OR ORDER_ID is null) ORDER BY A.APPT_DATE, A.APPT_SLAB_FROM_TIME";
				pend_sche ="select TO_CHAR(APPT_DATE,'DD/MM/YYYY')APPT_DATE_STR,TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR, TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI') TO_TIME_STR,(CASE WHEN a.clinic_code IS NOT NULL THEN OP_GET_DESC.OP_CLINIC(a.facility_id,a.clinic_code,?,'1') END )LOCATION_DESC,(CASE WHEN a.clinic_code IS NOT NULL THEN (SELECT x.short_desc FROM am_speciality_LANG_vW x, op_clinic y WHERE x.speciality_code = y.speciality_code AND y.facility_id = a.facility_id AND y.clinic_code = a.clinic_code AND X.LANGUAGE_ID = ? ) END ) SPECIALITY_DESC, DECODE(RESOURCE_CLASS,'P','Practitioner','R','Room','Others')||'/'|| case when RESOURCE_CLASS='P' then am_get_desc.am_practitioner(PRACTITIONER_ID,?,'1') when RESOURCE_CLASS='R' then am_get_desc.AM_FACILITY_ROOM(a.FACILITY_ID,a.PRACTITIONER_ID,?,'1') else am_get_desc.AM_RESOURCE(a.FACILITY_ID,a.PRACTITIONER_ID,?,'1') end  resource_name, APPT_REF_NO,(select count(appt_ref_no) from oa_resource_for_appt where appt_ref_no = a.appt_ref_no  and oa_resource_for_appt.FACILITY_ID=a.FACILITY_ID) sec_resource_cnt,TO_CHAR(a.modified_date,'DD/MM/YYYY HH24:MI') modified_date,AM_GET_DESC.AM_PRACTITIONER(a.modified_by_id,?,1) pract_name from oa_appt_vw A where A.FACILITY_ID= ? AND A.PATIENT_ID=? AND  A.APPT_DATE>=trunc(sysdate) and ((ORDER_ID is not null and exists (select 1 from or_order_line where ORDER_ID = a.ORDER_ID and ORDER_LINE_NUM = a.ORDER_LINE_NUM and order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code 	WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF= 'EXT_COMPL_ORD') or order_status_type in ('99','96','97','93'))))OR ORDER_ID is null) and appt_status = '1' ORDER BY A.APPT_DATE, A.APPT_SLAB_FROM_TIME";
				con = ConnectionManager.getConnection(request);
				pstmt	=	con.prepareStatement(pend_sche);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,locale);
				pstmt.setString(6,locale);
				pstmt.setString(7,facility_id);
				pstmt.setString(8,patient_id);
		
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					i++;
					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";
					appt_date_str			=	rs.getString("APPT_DATE_STR")== null ? "" : rs.getString("APPT_DATE_STR");
					from_time_str			=	rs.getString("FROM_TIME_STR")== null ? "" : rs.getString("FROM_TIME_STR");
					to_time_str				=	rs.getString("TO_TIME_STR") == null ? "" : rs.getString("TO_TIME_STR");
					location_desc			=	rs.getString("LOCATION_DESC") == null ? "" : rs.getString("LOCATION_DESC");
					speciality_desc			=	rs.getString("SPECIALITY_DESC") == null ? "" : rs.getString("SPECIALITY_DESC");
					resource_name			=	rs.getString("resource_name") == null ? "&nbsp;" : rs.getString("resource_name");
					appt_ref_no				=	rs.getString("APPT_REF_NO") == null ? "" : rs.getString("APPT_REF_NO"); 
					sec_resource_cnt		=	rs.getInt("sec_resource_cnt");
					modified_by_id				=	rs.getString("pract_name") == null ? "" : rs.getString("pract_name"); //IN037701
					modified_date				=	rs.getString("modified_date") == null ? "" : rs.getString("modified_date");//IN037701 
					appt_date_str		= com.ehis.util.DateUtils.convertDate(appt_date_str,"DMY","en",locale);
//					from_time_str		= com.ehis.util.DateUtils.convertDate(from_time_str,"DMYHM","en",locale);
//					to_time_str			= com.ehis.util.DateUtils.convertDate(to_time_str,"DMYHM","en",locale);
					modified_date			= com.ehis.util.DateUtils.convertDate(modified_date,"DMYHM","en",locale);//IN037701
					//IN037701 Starts
					if("CA_SPC".equals(p_called_from))
					{%>
						
						<tr>
						<td class='gridData'  colspan="1" ><%=location_desc%>/<%=resource_name%></td>
						<td class='gridData'  colspan="2" ><%=appt_date_str%></td>
						<td class='gridData'  colspan="2" ><%=modified_by_id%></td>
						<td class='gridData'  colspan="2" ><%=modified_date%></td>
						</tr>
					<%}
					else{//IN037701 Ends
					if(!currdate.trim().equalsIgnoreCase(appt_date_str.trim())){%>
					<tr><td class='gridData' colspan='9'><%=appt_date_str%></td></tr>
					<% currdate =	 appt_date_str; }%>
						<tr>
						<td class='gridData'  colspan="1" ><%=from_time_str%>-<%=to_time_str%></td>
						<td class='gridData'  colspan="2" ><%=location_desc%></td>
						<td class='gridData'  colspan="2" ><%=speciality_desc%></td>
						<td class='gridData'  colspan="2" ><%=resource_name%></td>
                       <% if(sec_resource_cnt > 0)
					{%>
						<td class='gridData'  colspan="1" ><a class='gridLink' href="javascript:show_Reference_details('<%=appt_ref_no%>','<%=facility_id%>')" onMouseOver="showToolTip(this)" onMouseOut="javascript:hideToolTip()"> Ref:<%=appt_ref_no%></td></a></tr>
					<%}
						else
					{%>
                        <td class='gridData'  colspan="2" > Ref:<%=appt_ref_no%></td></tr>

						
					<%}
				}//IN037701
			}
		//IN035950  Starts
		if(i==0)
		{
		out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
		}
		//IN035950  Ends
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}	catch(Exception e){
					//out.println("Exception@1 : "+e.getMessage());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
				}  finally	{
					if(con!=null)ConnectionManager.returnConnection(con,request);
				}
		%>
		</table>
		</form>
		<div id='secondaryResources' style='position:absolute; visibility:hidden;overflow:overflow'></div>
	</center>
</body>
</html>

