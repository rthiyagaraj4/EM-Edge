<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" 
contentType="text/html; charset=UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script Language="JavaScript" src='../js/ProcessReferrals.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>			
<body  onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<% 
String Facility_Id = (String) session.getValue("facility_id");
String responsibility_id=(String)session.getAttribute("responsibility_id");	
String userId = (String) session.getAttribute("login_user");
String p_privilege_val = "";
String p_allowed_yn = "";
String functionID	= 	"PROCESS_REF";
String privID	= 	"CHG_REFERRAL_STATUS";
String privilege_yn = "N";
String locale = (String) session.getValue("LOCALE");
boolean isAuthorized = false;
  if((Boolean)session.getValue("is_authorized_for_proc_ref_nref")==null){
	isAuthorized = false;  
  }else{
	  isAuthorized = true;
  }
String whereClause = request.getParameter("whereclause");
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
Connection conn = null ;
Statement stmt=null;
ResultSet rset=null;
String and_yn = "";
StringBuffer sql =new StringBuffer();
try
{
	conn  =  ConnectionManager.getConnection(request);
try{
		CallableStatement cstmt1 = conn.prepareCall("{ call BLPOLICYUSERACCESSDTLS.get_bl_privlege_yn(?,?,?,?,?,sysdate,?,?)}");
		cstmt1.setString(1, Facility_Id);			
		cstmt1.setString(2, userId);			
		cstmt1.setString(3, responsibility_id);			
		cstmt1.setString(4, functionID);			
		cstmt1.setString(5, privID);	
		cstmt1.registerOutParameter(6, java.sql.Types.VARCHAR);
		cstmt1.registerOutParameter(7, java.sql.Types.VARCHAR);
		cstmt1.execute();	
		p_privilege_val = cstmt1.getString(6);
		p_allowed_yn = cstmt1.getString(7);
		
		if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y")){
			privilege_yn ="Y";
		}else{
			privilege_yn = "N";
		}
		%>
		
		<form name="proc_ref_priv_form" id="proc_ref_priv_form">
		
		<input type="hidden" name="privilege_yn" id="privilege_yn" value="<%=privilege_yn%>">
		
		</form>
		
		<%
		
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	stmt = conn.createStatement();
	if ( (whereClause == null || whereClause.equals("")) )
	{
	 String dtfrm=request.getParameter("dtfrm");
	String dtto=request.getParameter("dtto");
	String episode_id=request.getParameter("episode_id");
	if(dtfrm.equals("")) dtfrm="";
	if(dtto.equals("")) dtto="";
	if(episode_id.equals("")) episode_id="";
	sql.append("b.PATIENT_ID=a.PATIENT_ID and ");
	sql.append("a.PATIENT_CLASS='OP' and ");
	sql.append("a.visit_type_ind = 'F' and ");
	sql.append("a.queue_status != '99' and ");
	sql.append(" a.locn_code in (select clinic_code from op_clinic where category in( select clinic_proc_catg_code from op_clinic_proc_category where eff_status = 'E') AND eff_status = 'E' ) and ");
	
	sql.append(" a.locn_code=c.clinic_code and ");
	sql.append(" a.facility_id = d.operating_facility_id and ");
	sql.append(" c.encounter_id = d.encounter_id and ");
	
	sql.append("a.facility_id  = c.operating_facility_id and ");
	sql.append("a.patient_id = c.patient_id and ");
	sql.append("a.patient_id = d.patient_id and ");
	sql.append("a.EPISODE_ID = d.EPISODE_ID and ");
	sql.append("c.EPISODE_ID = d.EPISODE_ID and ");
	
	sql.append("a.encounter_id = d.encounter_id and ");
	
	sql.append("c.CUR_ACCT_SEQ_NO = d.ACCT_SEQ_NO and ");
	sql.append("a.OP_EPISODE_VISIT_NUM = c.visit_id and ");
	sql.append("c.visit_id = d.visit_id and ");
	sql.append("c.episode_type = d.episode_type and ");
	sql.append("c.episode_type = 'O' and ");
	sql.append(" ((c.SETTLEMENT_IND != 'C' and d.priority = 1) OR (c.SETTLEMENT_IND = 'C' and d.priority IS NULL)) ");
	//sql.append("d.SETTLEMENT_IND = 'X'  ");	
	if (!dtfrm.equals(""))
		{
			sql.append(and_yn).append("and trunc(a.queue_date) >= to_date('"+dtfrm+"','dd/mm/yyyy')");
			and_yn = " and ";
		}
		if (!dtto.equals(""))
		{
			sql.append( and_yn).append("trunc(a.queue_date) <= to_date('"+dtto+"','dd/mm/yyyy')");
			
		}
		if(!episode_id.equals("")){
			sql.append(" and a.encounter_id = '"+episode_id+"'");
		}	
	}
	else {		
	     sql.append(whereClause);
	}
	StringBuffer strsql1 = new StringBuffer();
	strsql1.append("SELECT a.locn_type,a.locn_code,  a.patient_id, TO_CHAR(a.queue_date,'dd/mm/yyyy hh24:mi') adm_date_time, a.patient_class,	a.service_code,		  am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)service_short_desc, op_get_desc.op_clinic (a.facility_id, a.locn_code, 'en', 1) clinic_desc, op_get_desc.OP_VISIT_TYPE(a.facility_id,a.VISIT_TYPE_code,'"+locale+"',2)visit_type_desc,			  am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',2) practitioner_name,		  am_get_desc.am_disposition_type(a.disposition_type,'"+locale+"',2)disposition_short_desc,  NVL(op_episode_visit_num,''),	 a.ENCOUNTER_ID, 'A' visit_type_ind,  a.queue_date,  a.CANCEL_REASON_CODE,am_get_desc.am_contact_reason(a.CANCEL_REASON_CODE,'"+locale+"',2)CANCEL_REASON_DESC,a.SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(a.SPECIALITY_CODE,'"+locale+"',2)  SPECIALITY_DESC,sm_get_desc.SM_APPL_USER(a.ADDED_BY_ID,'en',1) user_name,a.episode_id,a.referred_yn, NVL(a.referral_id,'') referral_id, b.patient_name,a.locn_code,   blcommonproc.get_customer_desc(d.cust_code, '"+locale+"','S') cust_desc,        blcommonproc.get_customer_group_desc(d.cust_group_code, '"+locale+"','S') cust_group_desc,		        blcommonproc.get_polity_type_desc(d.policy_type_code, '"+locale+"', 'S') policy_type_desc,  blcommon.bl_enc_post_flags (a.facility_id,'O', a.patient_id, a.episode_id,a.op_episode_visit_num) posted_yn, d.SETTLEMENT_IND,c.visit_id,a.PATIENT_CLASS FROM op_patient_queue a, mp_patient b,bl_visit_fin_dtls c, bl_encounter_payer_priority d	WHERE a.facility_id = '"+Facility_Id+"' and ").append(sql);
	strsql1.append( " order by a.queue_date desc");
	String endOfRes="1";
    int start = 0 ;
    int end = 0 ;
    int i=1;
	int cnt=0;
    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 10 ;
    else
        end = Integer.parseInt( to ) ;
	rset = stmt.executeQuery(strsql1.toString());	 
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rset.next() ;  
	while ( i<=end && rset.next() )
	{
	String modfDis = "";
	if(rset.getString("posted_yn").equals("Y")){
	   modfDis = "disabled";
	}
 if(rset.getString("SETTLEMENT_IND").equals("C")){
		 modfDis = "disabled";
	} 
	if (cnt == 0)
	{
	%>
	<form name="process_referral_form" id="process_referral_form" >
	<P>
	<table align='right'>
	<tr>
	<td>
		<%
		if ( !(start <= 1) )
			out.println("<A HREF='../../eOP/jsp/ProcessReferralResult.jsp?from="+(start-10)+"&to="+(end-10)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( endOfRes.equals("1") ){
		out.println("<A id='nextval' HREF='../../eOP/jsp/ProcessReferralResult.jsp?from="+(start+10)+"&to="+(end+10)+"&dtfrm=&episode_id=&dtto=&whereclause="+URLEncoder.encode(sql.toString())+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
		%>
		</td>
	</tr>
</table><br><br>
</P>
    <table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
    <tr><td align='center'>
    <table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
	<input name="name" id="name" value="<%= i %>" type="hidden">
    <td class='columnheader' align='center'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
    <td class='columnheader' align='center'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
    <td class='columnheader' align='center'><fmt:message key="eMR.EpisodeNo.label" bundle="${mr_labels}"/></td>	
    <td class='columnheader' align='center'><fmt:message key="eOP.clinic.label" bundle="${op_labels}"/></td>
    <td class='columnheader' align='center'><fmt:message key="Common.practitioner.label" bundle="${op_labels}"/></td>
	<td class='columnheader' align='center'><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></td>
	<td class='columnheader' align='center'><fmt:message key="Common.CustomerGroup.label" bundle="${common_labels}"/></td>
	<td class='columnheader' align='center'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
	<td class='columnheader' align='center'><fmt:message key="eBL.POLICY.label" bundle="${common_labels}"/></td>
   	<td class='columnheader' align='center'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></td>
	<td class='columnheader' align='center'><fmt:message key="Common.Modify.label" bundle="${common_labels}"/></td>
	<td class='columnheader' align='center'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>
	</tr>
	<%
	}
   String classValue = "" ; 

   if ( i % 2 == 0 )
       classValue = "QRYEVEN" ;
   else
	   classValue = "QRYODD" ;
   %>
	<tr>
	<td  class='<%=classValue%>' nowrap><%= rset.getString("patient_id") %></td>
	<td  class='<%=classValue%>' nowrap><%= rset.getString("patient_name") %></td>
	<td  class='<%=classValue%>' nowrap><%= rset.getString("encounter_id") %></td>
	<td  class='<%=classValue%>' nowrap><%= rset.getString("clinic_desc") %></td>
	<td  class='<%=classValue%>' nowrap><%if( rset.getString("practitioner_name") == null ){
		out.println("");
	}else{
		out.println(rset.getString("practitioner_name"));
	} %></td>
	<td  class='<%=classValue%>' nowrap><%= rset.getString("adm_date_time") %></td>
	<td  class='<%=classValue%>' nowrap><% if(rset.getString("cust_group_desc")==null){out.println("&nbsp;");}else{out.println(rset.getString("cust_group_desc"));} %></td>
	<td  class='<%=classValue%>' nowrap><% if(rset.getString("cust_desc")==null){out.println("&nbsp;");}else{out.println(rset.getString("cust_desc"));} %></td>
	<td  class='<%=classValue%>' nowrap><% if(rset.getString("policy_type_desc")==null){out.println("&nbsp;");}else{out.println(rset.getString("policy_type_desc"));} %></td>
	<td  class='<%=classValue%>' nowrap><% if(rset.getString("referral_id")==null){
		
		out.println("No");
	}else{
		out.println("Yes");
	} %></td>	
	<td  class='<%=classValue%>' nowrap><input type='radio' class='Button' onclick="authUser('<%= rset.getString("patient_id") %>','<%= rset.getString("speciality_code") %>','<%= rset.getString("locn_type") %>', '<%= rset.getString("locn_code") %>', <%= i %>, '<%= rset.getString("referred_yn") %>', '<%= rset.getString("episode_id") %>', '<%=rset.getString("encounter_id") %>', '<%=rset.getString("service_code") %>', '<%=(rset.getString("referral_id")==null)?" ":rset.getString("referral_id") %>','<%=(rset.getString("visit_id")==null)?" ":rset.getString("visit_id") %>','<%=(rset.getString("patient_class")==null)?" ":rset.getString("patient_class") %>');" name='Modify_but_no' <%=modfDis%>></td>
	<td  class='<%=classValue%>' nowrap><input type='text' id = "ref_det_fld_<%= i %>" name='ref_details_field_<%= i %>' readOnly value='<% if(rset.getString("referral_id")== null || rset.getString("referral_id").equals("") || rset.getString("referral_id").equals("undefined")){
		out.println("&nbsp;");
	}else{
		out.println(checkForNull(rset.getString("referral_id")));
	} %>' size='15' maxlength='15' <%=modfDis%>></td> 
<%
	i++;
	cnt++;
}
//out.println Message NO_RECORD_FOUND_FOR_CRITERIA commented and ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US004
if( cnt == 0 )
	out.println("<script>parent.frames[0].document.query_criteria_form.search_button.disabled=false;alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
if(!rset.next() && cnt!=0 )
{
	 endOfRes = "0";		
%>
<script>
	document.getElementById("nextval").innerHTML=" ";
</script>
<% }
strsql1.setLength(0);
sql.setLength(0);
}
catch(Exception e){
	System.err.println("Exception in ProcessReferralResult.jsp :  "+e.toString());
	e.printStackTrace();
	}
finally
{
	try
	{
		if (rset != null ) rset.close();
		if( stmt != null) stmt.close();
	}catch(Exception e) {}
    if(conn!=null) ConnectionManager.returnConnection(conn,request);  
}
    %>
    </table>
    </td></tr>
    </table>
<script>
if(parent.frames[0].document.query_criteria_form.search_button){
	parent.frames[0].document.query_criteria_form.search_button.disabled=false;
}
</script>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
	%>

