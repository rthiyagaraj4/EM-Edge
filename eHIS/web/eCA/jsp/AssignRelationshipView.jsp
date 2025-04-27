<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.AssignRelationship.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCA/js/AssignRelationship.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()"  onScroll='scrollTitle()'>
<form name='AssignRelationshipForm' id='AssignRelationshipForm' method='POST' action='../../servlet/eCA.AssignRelationshipServlet'>

<%
	//out.println("QueryString = "+request.getQueryString());
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	String facility_id = (String) session.getAttribute("facility_id");
	String query_string = "";
	String current_date_time= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	String modal_yn = request.getParameter("modal_yn") == null ? "N" : request.getParameter("modal_yn");
	String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String visit_id = request.getParameter("visit_id") == null ? "ABC" : request.getParameter("visit_id");
	String episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
	
	if(episode_type.equals("I"))	visit_id		=	"1";

	//String patInfoBuff = "";
	String patient_name = "";
	String encounter_details = "";
	String practitionerInfo = "";
	String expiry_period="";	
     String reason_text="";
	StringBuffer strBuffPatientInfo = null;
	StringTokenizer tokenPatDetails = null;

	String pline = "";
	Connection			con		=	null;
	try
	{
    con = ConnectionManager.getConnection(request);

	if(modal_yn.equals("Y"))
	{
		String sql_pline = "";

		if(episode_id.equals(""))
		{
			sql_pline = "select get_patient.get_line_detail(?,?) Pline FROM dual";
		}
		else
		{
			sql_pline = "select get_patient.get_line_detail(?,?,?) Pline FROM dual";
		}

		PreparedStatement ps_pline = null;
		ResultSet res_pline = null;

		/* modified try
		{*/
			
			ps_pline = con.prepareStatement(sql_pline);

			if(episode_id.equals(""))
			{
				ps_pline.setString(1,patient_id);
				ps_pline.setString(2,locale);
			}
			else
			{
				ps_pline.setString(1,facility_id);
				ps_pline.setString(2,episode_id);
				ps_pline.setString(3,locale);
			}

			res_pline = ps_pline.executeQuery();

			while(res_pline.next())
			{
				pline = res_pline.getString("Pline");
			}

			if(pline != null)
			{
				strBuffPatientInfo = new StringBuffer();
				tokenPatDetails = new StringTokenizer(pline,"|");

				while(tokenPatDetails.hasMoreTokens())
				{
					patient_name = tokenPatDetails.nextToken();
					strBuffPatientInfo.append(tokenPatDetails.nextToken());
					if(!episode_id.equals(""))
					{
						practitionerInfo = tokenPatDetails.nextToken();
						encounter_details = tokenPatDetails.nextToken();
					}
				}
			}
		%>
		
		<div id='divDataTitle' style='postion:relative' >			
		<table  width='100%'  class='grid' align='center'>
			
		</table>
		<%
			if(ps_pline != null) ps_pline.close();
			if(res_pline != null) res_pline.close();
		/*}
		catch(Exception e)
		{
			out.println("Exception in AssignRelationshipView.jsp"+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}*/
	}
	else
	{
%>
	<div id='divDataTitle' style='postion:relative' >			
<%} %>
	<center>
	
	<table width='100%' id='dataTitleTable' class='grid' align='center' >
		<TR>
			<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADERCENTER' width='25%' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
		</tr>
		</table>
	</div>
	<table class='grid' width='100%' id='dataTable' align='center'>
	<%
        /*modified con = null; */

		String head_desc = "", prev_head_desc = "";
		String phy_prov_name = "", phys_prov_reln_name = "", begin_date = "", end_date = "";
		//String whereClause = "";
		String practitioner_type="",practitioner_id="",relationship_id="",added_date="",added_id="";
		String relationship_name="",expiry_based="",expiry_rule="",expiry_rule1="";
		String terminateRelnCheck=""; // this variable is used for the next frame reference.
		String 	login_user_id		=	(String) session.getValue("login_user");
		String 	responsibility_id		=	(String) session.getValue("responsibility_id");
		String sql="";
		String CAN_TERMINATE_YN="N";

		/*modal_yn	=	request.getParameter("modal_yn");
		if(modal_yn==null) modal_yn = "N";*/
		//out.println("<script>alert('modal_yn = "+modal_yn+"');</script>");
	/*	try
		{ */
			PreparedStatement	 pstmt	=	null;
			PreparedStatement pstmt1=null;
			ResultSet			rs		=	null;
			ResultSet rs1=null;
			
			//con					=	(Connection) session.getValue("connection");

			/* modified con = ConnectionManager.getConnection(request); */
			//patient_id			=	request.getParameter("patient_id");
			//episode_id			=	request.getParameter("episode_id");
			//episode_type		=	request.getParameter("episode_type");
			//visit_id			=	request.getParameter("visit_id");
			query_string		=	request.getQueryString();

			//if(patient_id==null)		patient_id			=	"";
			//if(episode_id==null)		episode_id			=	"";
			//if(episode_type==null)		episode_type		=	"";
			//if(episode_type.equals("I"))	visit_id		=	"1";

			//String query_patient_encounter_details = "select PHY_PROV_TYPE practitioner_type,PHYS_PROV_ID practitioner_id,PHYS_PROV_RELN_ID relationship_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') current_date_time, ADDED_BY_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss')  added_date,replace (PHYS_PROV_RELN_NAME,'''','') relationship_name,EXPIRY_BASED_YN expiry_based,to_char(expiry_period)||decode(expiry_rule, 'DAE', ' Days After Effect', 'HAE', ' Hours After Effect', 'DAA', ' Days After Adm/Visit', 'HAA', ' Hours After Adm/Visit', 'DAT', ' Days After Transfer', 'HAT', ' Hours After Transfer', 'DAD', ' Days After Discharge', 'HAD', ' Hours After Discharge') expiry_rule,decode(lifetime_or_encntr,'L','Lifetime','E','Encounter') head_desc, replace (phy_prov_name,'''','') phy_prov_name,     replace(phys_prov_reln_name ,'''','') phys_prov_reln_name,to_char(begin_date_time,'dd/mm/yyyy hh24:mi') begin_date, to_char(end_date_time,'dd/mm/yyyy hh24:mi') end_date from ca_encntr_pract_reln_vw where patient_id = ?  and sysdate between begin_date_time and nvl(end_date_time,sysdate) and (( LIFETIME_OR_ENCNTR ='L') or (episode_id = ? "+whereClause+")) order by LIFETIME_OR_ENCNTR, begin_date_time ";

			//String query_patient_encounter_details=" select PHY_PROV_TYPE practitioner_type,PHYS_PROV_ID practitioner_id,PHYS_PROV_RELN_ID relationship_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') current_date_time, ADDED_BY_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss')  added_date,replace (CA_GET_DESC.CA_PRACT_RELN(PRACT_RELN_ID,?,'1'),'''','') relationship_name,EXPIRY_BASED_YN expiry_based,to_char(expiry_period) expiry_period, expiry_rule,decode(lifetime_or_encntr,'L','Lifetime','E','Encounter') head_desc, replace (AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'),'''','') phy_prov_name,     replace(CA_GET_DESC.CA_PRACT_RELN(PRACT_RELN_ID,?,'1') ,'''','') phys_prov_reln_name,to_char(begin_date_time,'dd/mm/yyyy hh24:mi') begin_date, to_char(end_date_time,'dd/mm/yyyy hh24:mi') end_date from ca_encntr_pract_reln_vw where patient_id = ?  and sysdate between begin_date_time and nvl(end_date_time,sysdate) and (( LIFETIME_OR_ENCNTR ='L') or (episode_id = ? "+whereClause+")) order by LIFETIME_OR_ENCNTR, begin_date_time";

			//commented for perfmonace tuning 
			//String query_patient_encounter_details=" select PHY_PROV_TYPE practitioner_type,PHYS_PROV_ID practitioner_id,PHYS_PROV_RELN_ID relationship_id, ADDED_BY_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss')  added_date,replace (CA_GET_DESC.CA_PRACT_RELN(PHYS_PROV_RELN_ID,?,'1'),'''','') relationship_name,EXPIRY_BASED_YN expiry_based,to_char(expiry_period) expiry_period, expiry_rule,lifetime_or_encntr head_desc, replace (AM_GET_DESC.AM_PRACTITIONER(PHYS_PROV_ID,?,'1'),'''','') phy_prov_name,     replace(CA_GET_DESC.CA_PRACT_RELN(PHYS_PROV_RELN_ID,?,'1') ,'''','') phys_prov_reln_name,to_char(begin_date_time,'dd/mm/yyyy hh24:mi') begin_date, to_char(end_date_time,'dd/mm/yyyy hh24:mi') end_date from ca_encntr_pract_reln_vw where patient_id = ?  and sysdate between begin_date_time and nvl(end_date_time,sysdate) and (( LIFETIME_OR_ENCNTR ='L') or (episode_id = ? "+whereClause+")) order by LIFETIME_OR_ENCNTR, begin_date_time";

			String query_patient_encounter_details="SELECT a.practitioner_id,         a.pract_reln_id relationship_id, a.added_by_id,TO_CHAR (a.added_date, 'dd/mm/yyyy hh24:mi:ss') added_date,REPLACE  (ca_get_desc.ca_pract_reln (a.pract_reln_id, ?, '1'),'''', '') relationship_name, expiry_based_yn expiry_based, TO_CHAR (expiry_period) expiry_period, expiry_rule, lifetime_or_encntr head_desc,  REPLACE (am_get_desc.am_practitioner (a.practitioner_id, ?, '1'), '''','' ) phy_prov_name,TO_CHAR (begin_date_time, 'dd/mm/yyyy hh24:mi') begin_date,      TO_CHAR (end_date_time, 'dd/mm/yyyy hh24:mi') end_date,(select pract_type from am_practitioner where practitioner_id=a.practitioner_id) pract_type, a.remarks FROM ca_encntr_pract_reln a, ca_pract_reln b WHERE patient_id = ? AND SYSDATE BETWEEN begin_date_time AND NVL (end_date_time, SYSDATE) AND ((lifetime_or_encntr = 'L') OR (encounter_id = ?)) and b.pract_reln_id=a.pract_reln_id AND NVL(STATUS,'01')!='09' ORDER BY lifetime_or_encntr, begin_date_time ";

			pstmt		=	con.prepareStatement(query_patient_encounter_details);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			//pstmt.setString(3,locale);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,episode_id);
			
			
			rs	=	pstmt.executeQuery();
			
				//if(pstmt!=null) pstmt.close();
			int i=0;
			//String classValue = "";
					sql="select  CAN_TERMINATE_YN from ca_pract_reln_for_resp a, sm_resp_for_user b where b.appl_user_id =  ? AND  pract_reln_id =?  and a.resp_id = b.resp_id and a.resp_id=? ";
				pstmt1=con.prepareStatement(sql);	


			while(rs.next())
			{
				i++;
				//if((i%2)==0) 	classValue = "QRYEVEN";
				//else classValue = "QRYODD";

				head_desc			=	rs.getString("head_desc");

				if(head_desc.equals("L") )
					head_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
				else if(head_desc.equals("E") )
					head_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");

				phy_prov_name		=	rs.getString("phy_prov_name");
				//phys_prov_reln_name	=	rs.getString("phys_prov_reln_name");//tune
				begin_date			=	rs.getString("begin_date");
				end_date			=	rs.getString("end_date");
				practitioner_type	=	rs.getString("pract_type"); 
				practitioner_id		=	rs.getString("practitioner_id");
				relationship_id		=	rs.getString("relationship_id");		
				added_id			=	rs.getString("ADDED_BY_ID");
				added_date			=	rs.getString("added_date");
				relationship_name 	=	rs.getString("relationship_name");
				expiry_based 		=	rs.getString("expiry_based");
				expiry_period		=	rs.getString("expiry_period");
				expiry_rule1 		=	rs.getString("expiry_rule");			
				reason_text = rs.getString("remarks");	

				if(phy_prov_name==null)			phy_prov_name		= "&nbsp;";
				if(phys_prov_reln_name==null)	phys_prov_reln_name = "&nbsp;";
				if(begin_date==null)			begin_date			= "";
				if(end_date==null)				end_date			= "";
				if(practitioner_type==null)		practitioner_type	= "";
				if(practitioner_id==null)		practitioner_id	= "";
				if(relationship_id==null)		relationship_id	= "";
				if(added_date==null)		added_date	= "";
				if(relationship_name==null)		relationship_name	= "";
				if(expiry_based==null)		expiry_based	= "";
				if(expiry_period==null)		expiry_period	= "";
				if(expiry_rule==null)		expiry_rule	= "";

				if(added_id==null) added_id	= "";
				if(expiry_rule1==null) expiry_rule1	= "";
				
				begin_date	= com.ehis.util.DateUtils.convertDate(begin_date,"DMYHM","en",locale);
				end_date	= com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale);
				if(expiry_rule1.equals("DAE"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterEffect.label","ca_labels");

			if(expiry_rule1.equals("HAE"))
				expiry_rule = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterEffect.label","ca_labels");

			if(expiry_rule1.equals("DAA"))
				expiry_rule= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterAdmit.label","ca_labels");

			if(expiry_rule1.equals("HAA"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterAdmit.label","ca_labels");

			if(expiry_rule1.equals("DAT"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterTransfer.label","ca_labels");
				
			if(expiry_rule1.equals("HAT"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterTransfer.label","ca_labels");

			if(expiry_rule1.equals("DAD"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DayAfterDischarge.label","common_labels");

			if(expiry_rule1.equals("HAD"))
				expiry_rule= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HourAfterDischarge.label","common_labels");

				expiry_rule=expiry_period+" " + expiry_rule;
				if(!(prev_head_desc.equals(head_desc)))
				{
%>
				<tr>
					<td class='CAGROUP' colspan=4><%=head_desc%></td>
				</tr>
	<%
					prev_head_desc = head_desc;
				}
	/*modified try{	 */
				
					
				
				//if(pstmt1!=null) pstmt1.close();
		/*}catch(Exception e){
				out.println("Exception in AssignRelationshipView.jsp "+e.toString());
		} */
			if (added_id.equals(login_user_id)){
				terminateRelnCheck="N";
				CAN_TERMINATE_YN="N";
		
				pstmt1.setString(1,login_user_id);
				pstmt1.setString(2,relationship_id);
				pstmt1.setString(3,responsibility_id);
				rs1=pstmt1.executeQuery();
 
				while (rs1.next()){
						CAN_TERMINATE_YN=(rs1.getString("CAN_TERMINATE_YN")==null?"N":rs1.getString("CAN_TERMINATE_YN"));
				}

				if(rs1!=null)rs1.close();
					if(CAN_TERMINATE_YN.equals("Y")){
							terminateRelnCheck="Y";
					}
			}
			

	%>

				<tr>		
				<td class='gridData' width='25%'><%if(modal_yn.equals("N")){%><a class='gridLink' href="javascript:displayDetails('<%=practitioner_type%>','<%=practitioner_id%>','<%=relationship_id%>','<%=begin_date%>','<%=end_date%>','<%=added_date%>','<%=phy_prov_name%>','<%=relationship_name%>','<%=expiry_based%>','<%=expiry_rule%>','<%=terminateRelnCheck%>','<%=reason_text%>')"><%=phy_prov_name%>
				</a>  
				<%
					if(begin_date.equals(""))	begin_date	= "&nbsp;";
					if(end_date.equals(""))				end_date = "&nbsp;";
				}else{
					if(begin_date.equals(""))	begin_date	= "&nbsp;";
					if(end_date.equals(""))				end_date = "&nbsp;";	
					%><%=phy_prov_name%><%}%></td>
					<td class='gridData' width='25%'><%=relationship_name%></td>
					<td class='gridData' width='25%'><%=begin_date%></td>
					<td class='gridData' width='25%'><%=end_date%></td>
				</tr>
	<%
						
			

			}


	


			if(pstmt1!=null) pstmt1.close();
		
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}catch(Exception e){
			//out.println("Exception in AssignRelationshipView.jsp:"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}finally	{
			
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
		
	%>
	<TR style='visibility:hidden'>
		<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
	</tr>
	</table>

		<input type='hidden' name='modal_yn' id='modal_yn' value='<%=modal_yn%>'>
		<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
		<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>'>
		<input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id%>'>
		<input type='hidden' name='query_string' id='query_string' value='<%=query_string%>'>
		<input type='hidden' name='currentDateTime' id='currentDateTime' value='<%=current_date_time%>'>
	</form>
	</center>
</body>
</html>
<script>alignWidth();</script>

