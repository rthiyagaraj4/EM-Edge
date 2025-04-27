<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,eCommon.Common.*,java.util.StringTokenizer,java.util.TreeMap" %>
 
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE"); 
String loginUser = (String)session.getValue("login_user");
String facility_id1 = (String) session.getValue( "facility_id" ) ;

Connection con=null; 
Statement stmt=null;
ResultSet rset=null;  
int maxRecord=0;
int c=0;
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

<script language='javascript' src='../../eOP/js/OPCancelCheckout.js'></script>

</head>
<%
Boolean isPriorityZoneAppl=false;  //Added By Shanmukh for MMS-DM-CRF-0147

	String facility_id=checkForNull(request.getParameter("facility_id"));
	String module_id=checkForNull(request.getParameter("module_id"));
	String speciality=checkForNull(request.getParameter("speciality"));
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String loc_type=checkForNull(request.getParameter("loc_type"));
	String oplocation=checkForNull(request.getParameter("oplocation"));
	String pract=checkForNull(request.getParameter("pract"));
	String gender=checkForNull(request.getParameter("gender"));
	//String chkoutFrom=checkForNull(request.getParameter("chkoutFrom"));
	//String chkoutTo=checkForNull(request.getParameter("chkoutTo"));

	/*if(module_id.equals("AE"))
	{*/
		String disaster=checkForNull(request.getParameter("disaster"));
		String caseoftrauma=checkForNull(request.getParameter("caseoftrauma"));
		String pat_class=checkForNull(request.getParameter("pat_class"));
		String oper_stn_id=checkForNull(request.getParameter("oper_stn_id"));
		//String loginUser=checkForNull(request.getParameter("loginUser"));
		
	//}

	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	
		//String oper_stn_id = "";

	 

	String from = request.getParameter( "from" );	
	String to = request.getParameter( "to" );
	String registered_in_mo_yn = "";
	
	Boolean isVIPimgpatfrontappl = false;//Added by Mujafar against ML-MMOH-CRF-1070

	
	int start = 0 ;
	 int end = 0 ;
	 int i=1;

	 if ( from == null )
		start = 1 ;
	 else
		start = Integer.parseInt( from ) ;

	 if ( to == null )
	  	end = 8;
	 else
		end = Integer.parseInt( to ) ;
	
	try
	{
		con =  ConnectionManager.getConnection(request); 
		
		 isPriorityZoneAppl			=	CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");//Added By Shanmukh for MMS-DM-CRF-0147
		 isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070
%>

<BODY onLoad='' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="OPCancelChkoutResult" id="OPCancelChkoutResult">
<%
	String class_val = "";
	StringBuffer sqlBuff=new StringBuffer();
	StringBuffer Where=new StringBuffer();
	String order_by = ""; 
	String gender_tab = "";
	String gender_st = "";

	//boolean isAfter = false;
	//String pat_class = "";

	if(module_id.equals("AE"))
		pat_class = "EM";
	else if(module_id.equals("OP"))
		pat_class = "OP";


	if(!speciality.equals(""))
		Where.append(" and a.SPECIALITY_CODE = '"+speciality+"' ");
	if(!patient_id.equals(""))
		Where.append(" and a.PATIENT_ID = '"+patient_id+"' ");
	if(!loc_type.equals(""))
		Where.append(" and a.LOCN_TYPE = '"+loc_type+"' ");
	if(!oplocation.equals(""))
		Where.append(" and a.LOCN_CODE = '"+oplocation+"' ");
	if(!pract.equals(""))
		Where.append(" and a.PRACTITIONER_ID = '"+pract+"' ");
	if(!gender.equals("A"))
	{
	if(!gender.equals(""))
		Where.append(" and b.Sex = '"+gender+"' ");
	}

	if(module_id.equals("AE"))
	{
	if(!disaster.equals(""))
		Where.append(" and a.DISASTER_YN = '"+disaster+"' ");
	if(!caseoftrauma.equals(""))
		Where.append(" and a.TRAUMA_YN = '"+caseoftrauma+"' ");
	}


	order_by = " order by a.patient_id, a.QUEUE_DATE desc";

	//Below line modified by Shanmukh for MMS-DM-CRF-0147
	sqlBuff.append("SELECT a.PATIENT_ID, am_get_desc.am_disposition_type(a.disposition_type,'"+locale+"',2) disposition_short_desc, TO_CHAR(a.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_date,to_char(a.queue_date,'dd/mm/yyyy hh24:mi:ss') queue_date, a.SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(a.SPECIALITY_CODE, '"+locale+"',2)  SPECIALITY_DESC,(DECODE('"+locale+"' ,'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name))) patient_name,b.Sex Gender,a.encounter_id, a.LOCN_CODE clinic_code,OP_GET_DESC.OP_CLINIC(a.facility_id,a.LOCN_CODE,'"+locale+"','1')  clinic_desc,a.LOCN_TYPE clinic_type, a.treatment_area_code treatment_area_code,  AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id, a.LOCN_CODE ,a.treatment_area_code,'"+locale+"','2') treatment_area_desc, a.PRACTITIONER_ID PRACTITIONER_ID,  AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID, '"+locale+"','1') practitioner_name ,TO_CHAR(a.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, TO_CHAR(a.CHECK_IN_DATE_TIME, 'dd/mm/yyyy hh24:mi') queue_date_time, a.queue_STATUS, a.TRAUMA_YN, a.DISASTER_YN, a.SERVICE_CODE, b.REGISTERED_IN_MO_YN,a.OP_EPISODE_VISIT_NUM, op_get_desc.OP_VISIT_TYPE(facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type, a.episode_id episode_id, am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1) practitioner_name1, a.medical_yn medical_yn,a.surgical_yn surgical_yn, a.trauma_yn, a.oscc_yn, a.o_and_g_yn, a.non_emerg_yn, a.mech_injury_catg_code, a.mech_injury_subcatg_code, a.mlc_yn mlc_yn,a.pm_yn pm_yn, a.high_risk_yn high_risk_yn, TO_CHAR(b.DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_time,  a.LOCN_CODE, a.PRIORITY_ZONE, b.DECEASED_YN, a.VISIT_TYPE_IND,a.AE_BED_NO,(SELECT NVL(AE_BED_CHARGE_APPL_YN,'N') FROM Bl_parameters Where  operating_facility_id = 'HS') ae_bed_charge,to_char(sysdate,'dd/mm/yyyy hh24:mi') cdate,(select eff_status from AE_PRIORITY_ZONE where priority_zone=a.priority_zone) priority_zone_status  FROM  op_patient_queue a, mp_patient b WHERE  a.facility_id = '"+facility_id1+"' AND  a.patient_id = b.patient_id AND queue_STATUS = '07' AND patient_class='"+pat_class+"' AND  trunc(a.DISCHARGE_DATE_TIME) = trunc(sysdate) AND (a.facility_id,a.LOCN_TYPE,a.LOCN_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+facility_id1+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+loginUser+"' and CANCEL_CHECKOUT_YN = 'Y')");//Modified by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646


	sqlBuff.append(Where.toString());
	sqlBuff.append(order_by);

	if (rset != null) rset.close();
	if (stmt != null) stmt.close();		

	 
	
	stmt=con.createStatement();
    rset=stmt.executeQuery(sqlBuff.toString());

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rset.next() ;
	  }
	while (rset!=null && i<=end && rset.next())
    {
			
			if(maxRecord == 0)
			{

%>
<P>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eOP/jsp/OPCancelCheckoutSearchResult.jsp?from="+(start-8)+"&to="+(end-8)+"&facility_id="+facility_id+"&speciality="+speciality+"&patient_id="+patient_id+"&loc_type="+loc_type+"&oplocation="+oplocation+"&pract="+pract+"&gender="+gender+"&disaster="+disaster+"&caseoftrauma="+caseoftrauma+"&pat_class="+pat_class+"&oper_stn_id="+oper_stn_id+"&loginUser="+loginUser+"&module_id="+module_id+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
			
		%>
		<td align ='right' id='next' style='visibility:hidden'>
		<%
			out.println("<A HREF='../../eOP/jsp/OPCancelCheckoutSearchResult.jsp?from="+(start+8)+"&to="+(end+8)+"&facility_id="+facility_id+"&speciality="+speciality+"&patient_id="+patient_id+"&loc_type="+loc_type+"&oplocation="+oplocation+"&pract="+pract+"&gender="+gender+"&disaster="+disaster+"&caseoftrauma="+caseoftrauma+"&pat_class="+pat_class+"&oper_stn_id="+oper_stn_id+"&loginUser="+loginUser+"&module_id="+module_id+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
		<br><br>
</P>

<table border="1"  cellspacing='0' cellpadding='0' width="100%">
	<tr>
		<th><fmt:message key="Common.DispType.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></th>
	    <th><fmt:message key="Common.CheckoutDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<%
			if(module_id.equals("AE"))
			{
		%>
		<th><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></th>
		<%
			}
		%>
	</tr>
	
<%		
	}			
%>
<tr>		
	</tr>
<%
			gender_tab=rset.getString("Gender");
		if(gender_tab.equals("M"))
			gender_st="Male";
		else if(gender_tab.equals("F"))
			gender_st="Female";
		else if(gender_tab.equals("U"))
			gender_st="Unknown";

			if (c % 2 == 0 )
			class_val = "QRYEVEN" ;
		else
			class_val = "QRYODD" ;

		String encounter_id=rset.getString("encounter_id");
		String pat_id=rset.getString("PATIENT_ID");
		String clinic_type=rset.getString("clinic_type");
		String location_id=rset.getString("clinic_code");
		String pract_id=rset.getString("PRACTITIONER_ID");
		String service_code = rset.getString("SERVICE_CODE");
		String queue_date	=rset.getString("QUEUE_DATE");			
		registered_in_mo_yn	=rset.getString("REGISTERED_IN_MO_YN");	// Tuesday, April 27, 2010 registered_in_mo_yn	

		String visit_type =rset.getString("visit_type")==null?"":rset.getString("visit_type"); 
//		String practitioner_name =  rset.getString("practitioner_name1")==null?"":rset.getString("practitioner_name1"); 
		String disposition =  rset.getString("disposition_short_desc")==null?"":rset.getString("disposition_short_desc"); 
		String medical_yn =  rset.getString("medical_yn")==null?"":rset.getString("medical_yn"); 
		String surgical_yn =  rset.getString("surgical_yn")==null?"":rset.getString("surgical_yn"); 
		String mlc_yn =  rset.getString("mlc_yn")==null?"":rset.getString("mlc_yn"); 
		String deceased_time =  rset.getString("deceased_time")==null?"":rset.getString("deceased_time");
		String discharge_date_time = rset.getString("discharge_date_time")==null?"":rset.getString("discharge_date_time");
		String discharge_date_time1 = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
		/*Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646 Start*/
		String traumaYn			=  checkForNull(rset.getString("trauma_yn"),"N"); 
		String osccYn			=  checkForNull(rset.getString("oscc_yn"),"N"); 
		String OandGYn			=  checkForNull(rset.getString("o_and_g_yn"),"N"); 
		String nonEmergYn		=  checkForNull(rset.getString("non_emerg_yn"),"N"); 
		String mechInjCode		=  checkForNull(rset.getString("mech_injury_catg_code"),""); 
		String mechInjSubCode	=  checkForNull(rset.getString("mech_injury_subcatg_code"),""); 
		/*End*/

		String visit_type_ind = rset.getString("visit_type_ind")==null?"":rset.getString("visit_type_ind");
		String p_visit_id = rset.getString("OP_EPISODE_VISIT_NUM")==null?"":rset.getString("OP_EPISODE_VISIT_NUM");
		String p_episode_id = rset.getString("episode_id")==null?"":rset.getString("episode_id");
		String treatment_area_code =  rset.getString("treatment_area_code")==null?"":rset.getString("treatment_area_code");
		String locn_code = rset.getString("locn_code")==null?"":rset.getString("locn_code");
		String priority_zone =  rset.getString("priority_zone")==null?"":rset.getString("priority_zone");
		String deceased_yn = rset.getString("deceased_yn")==null?"":rset.getString("deceased_yn");
		String ae_bed_no =  rset.getString("ae_bed_no")==null?"":rset.getString("ae_bed_no");
		String high_risk_yn = rset.getString("high_risk_yn")==null?"":rset.getString("high_risk_yn");
		String pm_yn = rset.getString("pm_yn")==null?"":rset.getString("pm_yn");
		String ae_bed_charge = rset.getString("ae_bed_charge")==null?"":rset.getString("ae_bed_charge");
		String cdate = rset.getString("cdate")==null?"":rset.getString("cdate");
	    String priority_zone_status = rset.getString("priority_zone_status")==null?"":rset.getString("priority_zone_status");//Added By Shanmukh for MMS-DM-CRF-0147
		String visit_date=rset.getString("visit_date");
		visit_date = DateUtils.convertDate(visit_date,"DMYHM","en",locale);
		
		
		 String img_temp="";
			if(isVIPimgpatfrontappl) // added by mujafar for ML-MMOH-CRF-1070
			{	
			
			String vip_pat_yn = eOA.OACommonBean.getVIPPatient(con,pat_id,facility_id);
			if(vip_pat_yn.equals("TRUE"))
			img_temp="<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>";	
			else
			img_temp = "";


			}
		
		

		out.println("<tr>");	
		out.println("<td class='"+class_val+"'><font size=1>" +disposition+"</td>");
		//out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("visit_date")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +visit_date+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +discharge_date_time1+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("PATIENT_ID")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +img_temp+""+rset.getString("patient_name")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +gender_st+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>");		
		%>
		<!--<a href="javascript:loadCancelChkout('<%=module_id%>','<%=encounter_id%>','<%=pat_id%>','<%=clinic_type%>','<%=location_id%>','<%=pract_id%>','<%=queue_date%>','<%=service_code%>','<%=oper_stn_id%>','<%=registered_in_mo_yn%>','<%=visit_type%>','<%=disposition%>','<%=medical_yn%>','<%=surgical_yn%>','<%=mlc_yn%>','<%=deceased_time%>','<%=discharge_date_time%>','<%=visit_type_ind%>','<%=p_visit_id%>','<%=p_episode_id%>','<%=treatment_area_code%>','<%=locn_code%>','<%=priority_zone%>','<%=deceased_yn%>','<%=ae_bed_no%>','<%=high_risk_yn%>','<%=pm_yn%>','<%=ae_bed_charge%>','<%=cdate%>' );">-->
		<a
		href='javascript:loadCancelChkout("<%=module_id%>","<%=encounter_id%>","<%=pat_id%>","<%=clinic_type%>","<%=location_id%>","<%=pract_id%>","<%=queue_date%>","<%=service_code%>","<%=oper_stn_id%>","<%=registered_in_mo_yn%>","<%=visit_type%>","<%=java.net.URLEncoder.encode(disposition).replace("+","%20")%>","<%=medical_yn%>","<%=surgical_yn%>","<%=mlc_yn%>","<%=deceased_time%>","<%=discharge_date_time%>","<%=visit_type_ind%>","<%=p_visit_id%>","<%=p_episode_id%>","<%=treatment_area_code%>","<%=locn_code%>","<%=priority_zone%>","<%=deceased_yn%>","<%=ae_bed_no%>","<%=high_risk_yn%>","<%=pm_yn%>","<%=ae_bed_charge%>","<%=cdate%>","<%=traumaYn%>","<%=osccYn%>","<%=OandGYn%>","<%=nonEmergYn%>","<%=mechInjCode%>","<%=mechInjSubCode%>","<%=priority_zone_status%>" );'><!--Modified by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646-->
		<%
		out.println(encounter_id+"</a></td>");//Modified by Rameswar Against IN55430
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("clinic_desc")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("SPECIALITY_DESC")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("practitioner_name")+"</td>");

		if(module_id.equals("AE"))
		{
			String disaster_st = "";
			String dis_status = "";
			String trauma_st = "";
			String trauma_status = "";

			disaster_st=rset.getString("DISASTER_YN");
		if(disaster_st.equals("Y"))
			dis_status="Yes";
		else
			dis_status="No";

		trauma_st=rset.getString("TRAUMA_YN");
		if(trauma_st.equals("Y"))
			trauma_status="Yes";
		else
			trauma_status="No";

		out.println("<td class='"+class_val+"'><font size=1>" +dis_status+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +trauma_status+"</td>");
		
		}

		out.println("</tr>");
				
		c++;
		i++;
		maxRecord++;
	}
	if(maxRecord == 0)
		{
			 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); </script>");
			 
		}

		if ( maxRecord < 8 || (!rset.next()) )
		{
		%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
			</script>
		<% 
		}
		else
		{%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%
		}

if(rset!=null)
	rset.close();	
if(stmt!=null)
	stmt.close();

%>

</table>

<input type="hidden" name="function_id" id="function_id"		value="<%=function_id%>">
<input type='hidden' name='isPriorityZoneAppl' id='isPriorityZoneAppl' value='<%=isPriorityZoneAppl%>'>	<!--Added By Shanmukh for MMS-DM-CRF-0147-->	
</form>
</body>
</html>
<%
}
catch(Exception e)
{	
	out.println("Exception="+e.toString());
	e.printStackTrace();
	
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

