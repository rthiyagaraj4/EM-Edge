<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.* ,com.ehis.util.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="selectProblem" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
<title><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></title>
<head>

<%

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eMR/js/RecDiagnosis.js' language='javascript'></script>
<script src='../../eMR/js/RecDiagnosisMain.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js'  language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<%
	java.util.Properties p			= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale					= (String) p.getProperty("LOCALE");

	Connection con					= null;
	PreparedStatement pstmt			= null;
	Statement		stmt			= null;
	ResultSet rs					= null;
	ResultSet rset					= null;

	String facility_id				= (String) session.getValue("facility_id");
	String encounter_id				= checkForNull(request.getParameter("encounter_id"));
	String patient_id				= checkForNull(request.getParameter("patient_id"));
	String callFunction				= checkForNull(request.getParameter("callFunction"));
	String short_desc				= checkForNull(request.getParameter("short_desc"));
	String term_code				= checkForNull(request.getParameter("term_code"));
	String term_set_id				= checkForNull(request.getParameter("term_set_id"));
	String onset_date				= checkForNull(request.getParameter("onset_date"));
	String occur_srl_no				= checkForNull(request.getParameter("occur_srl_no"));
	String sql_cnt                  = "";
	String sql                      = "";
	String complaint_id             = "";
	String _complaint_id            = "";
	String complaint_desc           = "";
	String _complaint_desc          = "";
	String classValue				= "";
	String onset_datetime_str		= "";
	String _onset_datetime_str		= "";
	String onset_datetime_strDisp	= "";
	String _term_code				= "";
	String _short_desc				= "";
	String chkDisabled				= "";
	String onset_date_converted		= "";
	String _onset_date_converted	= "";
	String complaint				= "";
	String chkLink					= "";
	String prev_complaint_id		= "";
	String _linkedProblems			= "";
	String _occur_srl_no			= "";
	ArrayList linkedProblems		= new ArrayList();
	ArrayList tempProblems			= new ArrayList();
//out.println("<script>alert(\"occur_srl_no:"+occur_srl_no+"\");</script>");	
	int j							= 0;
	int k							= 0;
	int counts						= 0;
	int counts1						= 0;
	int counts2						= 0;
	int max_record					= 0;
	int max_count					= 0;
	boolean chk						= true ;
	StringBuffer sbSql				= new StringBuffer();
	StringBuffer sdesc				= new StringBuffer();
	String link_Complaint			= (String) session.getValue("linkComplaint");
	if(link_Complaint == null)
		link_Complaint				= "$";

	StringTokenizer complaintToken  = new StringTokenizer(link_Complaint, "$");
	while (complaintToken.hasMoreTokens())
	{
		complaint					= complaintToken.nextToken();
		tempProblems.add(complaint);
		/*if(!complaint.equals(""))
			chkLink					= "checked";
		else
			chkLink					= "";
			*/
	}
%>
</head>

<body onKeyDown="lockKey()">
<form name = 'selectProblem'>
<%
try{
	con	= ConnectionManager.getConnection(request);

	String diag_desc = "";
	
	if(sdesc.length() > 0) sdesc.delete(0,sdesc.length());

	 sdesc.append("select term_code_short_desc from pr_diagnosis_compl_enc_dtl a where a.facility_id='"+facility_id+"' and a.encounter_id='"+encounter_id+"' and a.term_set_id='"+term_set_id+"'  "); 
	
	//if(!term_code.equals("*OTH"))
		sdesc.append("and a.term_code = '"+term_code+"' ");
	//else
		sdesc.append("and a.occur_srl_no = '"+occur_srl_no+"' ");



	stmt   = con.createStatement();
	rs	   = stmt.executeQuery(sdesc.toString());
	while(rs.next()){
			diag_desc=rs.getString("term_code_short_desc");
	}
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();


	if(callFunction.equals("selectProblem"))
	{
		try
		{
			
			sql_cnt = "select count(*)  from ca_encntr_chief_complaint where facility_id='"+facility_id+"' and encounter_id='"+encounter_id+"' order by onset_datetime desc";
			
			stmt   = con.createStatement();
			rs	   = stmt.executeQuery(sql_cnt.toString());
			
			rs.next();
				max_record = rs.getInt(1);
			
			if(rs != null) rs.close();
				if(stmt != null) stmt.close();

			if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append("select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text, to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str,term_code,term_code_short_desc from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? ");
				
				sbSql.append("order by a.onset_date desc");

				pstmt = con.prepareStatement(sbSql.toString());
				pstmt.setString(1,locale);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,encounter_id);
				pstmt.setString(4,term_set_id);
				
				rset		   = pstmt.executeQuery();
				
				
				while(rset.next())
				{
					
						_complaint_id		= rset.getString("complaint_id")==null?"":rset.getString("complaint_id");
						_complaint_desc		= rset.getString("complaint_text")==null?"":rset.getString("complaint_text");
						_term_code			= rset.getString("term_code")==null?"":rset.getString("term_code");
						_short_desc			= rset.getString("term_code_short_desc")==null?"":rset.getString("term_code_short_desc");
						linkedProblems.add(_complaint_id);
				}	


			sql = "select a.complaint_id complaint_id, complaint_desc, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy HH24:MI') onset_datetime_str from ca_encntr_chief_complaint a where a.facility_id=? and a.encounter_id=? order by a.onset_datetime desc";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,encounter_id);
			rs = pstmt.executeQuery();
			

			
	%>
	<!--<table border='1' width='100%' cellpadding='3' cellspacing='0' align='center'>
		<tr ><td class="COLUMNHEADER" colspan=4 ><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></td></tr>
	</table>-->

	<br>
		<table border='0' width='100%' cellpadding='0' cellspacing='0' align='center' >
			<tr><td class="COLUMNHEADER" style='BACKGROUND-COLOR: #ffc5b5;COLOR: black;'><font='verdana' size='1'><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></font></td>
			</tr>
		</table>
	
	
	<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
		<tr>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></td>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="Common.Problem.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="Common.Problem.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
		</tr>

	<%
			while(rs.next())
			{
				counts++;
					if ( j%2 == 0 )
					classValue			= "QRYEVEN" ;
				 else
					classValue			= "QRYODD" ;
			   
				complaint_id			= rs.getString("complaint_id")==null?"":rs.getString("complaint_id");
				complaint_desc			= rs.getString("complaint_text")==null?"":rs.getString("complaint_text");
				onset_datetime_str		= rs.getString("onset_datetime_str")==null?"":rs.getString("onset_datetime_str");
				onset_date_converted	=	DateUtils.convertDate(onset_datetime_str,"DMYHM","en",locale); 
				if(linkedProblems.contains(complaint_id))
					chkDisabled   = "disabled";
				else
					chkDisabled   = "";

				if(tempProblems.contains(complaint_id))
					chkLink					= "checked";
				else
					chkLink					= "";
				%>
					<tr>
						<td class=<%=classValue%> nowrap><input type ='checkbox' name = 'select<%=j%>' value = 'N' <%=chkDisabled%><%=chkLink%> ></input></td>
						<td class=<%=classValue%> nowrap><%=complaint_id%><input type ='hidden' name = 'complaint_id<%=j%>' value = '<%=complaint_id%>'></input></td>
						<td class=<%=classValue%> nowrap><%=complaint_desc%><input type ='hidden' name = 'complaint_desc<%=j%>' value = '<%=complaint_desc%>'></input></td>
						<input type='hidden' name = 'comp_onset_date<%=j%>' value='<%=onset_date_converted%>'/>
					</tr>
				<%
				
				
				//prev_complaint_id = complaint_id;
				j++;
			}
			if(counts==0){%><script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));parent.parent.document.getElementById("dialog_tag").close();history.go(-1);</script>
			<%}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}		
		catch(Exception e)
		{
			//out.println("Exception @ try"+e.toString());
			e.printStackTrace(System.err);
		}
%>
	</table>
<%
	}else if(callFunction.equals("showProblem"))
	{
		try
		{
			con	= ConnectionManager.getConnection(request);
			sbSql.append("select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text, to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? ");
			if(!term_code.equals("*OTH"))
				sbSql.append("and a.term_code = ? ");
			else
				sbSql.append("and a.term_code_short_desc = ? ");
			sbSql.append("order by a.onset_date desc");

			pstmt = con.prepareStatement(sbSql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,encounter_id);
			pstmt.setString(4,term_set_id);
			if(!term_code.equals("*OTH"))
				pstmt.setString(5,term_code);
			else
				pstmt.setString(5,diag_desc);
			rs = pstmt.executeQuery();



%>
		<br>
		<table border='0' width='100%' cellpadding='0' cellspacing='0' align='center' >
			<tr><td class="COLUMNHEADER" style='BACKGROUND-COLOR: #ffc5b5;COLOR: black;'><font='verdana' size='1'><fmt:message key="Common.ChiefComplaint.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<%=diag_desc%></font></td>
			</tr>
		</table>
		
		<table border='1' width='100%' id='showTitleTable' cellpadding='0' cellspacing='0' align='center' >
		<tr>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
		</tr>
<%
		while(rs.next())
			{
				if ( j%2 == 0 )
					classValue		= "QRYEVEN" ;
				 else
					classValue		= "QRYODD" ;
			   
				complaint_id		= rs.getString("complaint_id")==null?"":rs.getString("complaint_id");
				complaint_desc		= rs.getString("complaint_text")==null?"":rs.getString("complaint_text");
				onset_datetime_str  = rs.getString("onset_datetime_str")==null?"":rs.getString("onset_datetime_str");
				if(!(onset_datetime_str==null || onset_datetime_str.equals("")))
				onset_datetime_strDisp	=	DateUtils.convertDate(onset_datetime_str,"DMYHM","en",localeName);
				out.println("<tr><td class='"+classValue+"' nowrap>"+complaint_id+"</td>");
				out.println("<td class='"+classValue+"' nowrap>"+complaint_desc+"</td>");
				out.println("<td class='"+classValue+"' nowrap>"+onset_datetime_strDisp+"</td></tr>");

				j++;
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception @ try"+e.toString());
			e.printStackTrace(System.err);
		}
%>		
</table>
<%
	}else if(callFunction.equals("modifyProblem"))
	{
		try
		{
			String linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' "; 
			/*
			if(!term_code.equals("*OTH"))
				linkviewcnt_sql=linkviewcnt_sql+" TERM_CODE = '"+term_code+"'";
			else
				linkviewcnt_sql=linkviewcnt_sql+" TERM_CODE_SHORT_DESC = '"+short_desc+"'";
			*/
			con	= ConnectionManager.getConnection(request);
			stmt   = con.createStatement();
			rs	   = stmt.executeQuery(linkviewcnt_sql.toString());
			

			rs.next();
				max_record = rs.getInt(1);
			if(max_record > 0)
			{
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append("select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text, to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str,term_code,term_code_short_desc,occur_srl_no from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=?  ");
					
					/*
					if(!term_code.equals("*OTH"))
						sbSql.append("and a.term_code = ? ");
					else
						sbSql.append("and a.term_code_short_desc = ? ");
					*/
					sbSql.append("order by a.onset_date desc");
					
					pstmt = con.prepareStatement(sbSql.toString());
					pstmt.setString(1,locale);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,encounter_id);
					
					//pstmt.setString(4,term_set_id);
					/*
					if(!term_code.equals("*OTH"))
						pstmt.setString(5,term_code);
					else
						pstmt.setString(5,short_desc);
					*/
					rset = pstmt.executeQuery();

					//out.println("<script>alert(\""+sbSql.toString()+"\");</script>");

%>
		<br>
			<table border='0' width='100%' cellpadding='0' cellspacing='0' align='center' >
				<tr><td class="COLUMNHEADER" style='BACKGROUND-COLOR: #ffc5b5;COLOR: black;'><font='verdana' size='1'><fmt:message key="Common.Amend.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.Recorded.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></font></td>
				</tr>
			</table>
		
		<table border='1' width='100%' cellpadding='0' cellspacing='0' align='center' >
		<tr>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></td>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="Common.Problem.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="Common.Problem.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
		</tr>
<%			
	while(rset.next())
			{
				counts1++;
					if ( j%2 == 0 )
					classValue			= "QRYEVEN" ;
				 else
					classValue			= "QRYODD" ;
			   
				complaint_id			= rset.getString("complaint_id")==null?"":rset.getString("complaint_id");
				complaint_desc			=			
					rset.getString("complaint_text")==null?"":rset.getString("complaint_text");
				_term_code				= rset.getString("term_code")==null?"":rset.getString("term_code");
				_short_desc				= 
					rset.getString("term_code_short_desc")==null?"":rset.getString("term_code_short_desc");
				onset_datetime_str		= 
					rset.getString("onset_datetime_str")==null?"":rset.getString("onset_datetime_str");
				onset_date_converted	=	DateUtils.convertDate(onset_datetime_str,"DMYHM","en",locale); 
				_occur_srl_no				= rset.getString("occur_srl_no")==null?"":rset.getString("occur_srl_no");
				//if((!(_term_code.equals(term_code) && _term_code.equals("*OTH"))) || (_term_code.equals("*OTH") && !(_short_desc.equals(short_desc))))

				if(!(_term_code.equals(term_code)) && !(_term_code.equals("*OTH")) || ((_term_code.equals("*OTH") && !(_short_desc.equals(short_desc)))))
					chkDisabled   = "disabled";
								
				/*Thursday, February 11, 2010 IN019107 when term codes are same */
				else if(((_term_code.equals(term_code)) && !(_term_code.equals("*OTH")) && !(_occur_srl_no.equals(occur_srl_no))) || ((_term_code.equals("*OTH")) && (_short_desc.equals(short_desc)) && !(_occur_srl_no.equals(occur_srl_no))))
					chkDisabled   = "disabled";
				else
					chkDisabled   = "";

				if(tempProblems.contains(complaint_id))
					chkLink					= "checked";
				else
					chkLink					= "";
	
				%>
					<tr>
						<td class=<%=classValue%> nowrap ><input type ='checkbox' name = 'select<%=j%>' value = 'Y' checked <%=chkDisabled%><%=chkLink%> ></input></td>
						<td class=<%=classValue%> nowrap><%=complaint_id%><input type ='hidden' name = 'complaint_id<%=j%>' value = '<%=complaint_id%>'></input></td>
						<td class=<%=classValue%> nowrap><%=complaint_desc%><input type ='hidden' name = 'complaint_desc<%=j%>' value = '<%=complaint_desc%>'></input></td>
						<input type='hidden' name = 'comp_onset_date<%=j%>' value='<%=onset_date_converted%>'/>
					</tr>
				<%
				j++;
			}
			
			
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
%>
	</table>			
<%
			}
			if(rs != null) rs.close();
				if(stmt != null) stmt.close();

			sql_cnt = "select Count(*) from ca_encntr_chief_complaint a where a.facility_id='"+facility_id+"' and a.encounter_id='"+encounter_id+"' and not exists(select 1 from pr_diagnosis_compl_enc_dtl where facility_id=a.facility_id and encounter_id= a.encounter_id and complaint_id = a.complaint_id)order by a.onset_datetime DESC";
			
			stmt   = con.createStatement();
			rs	   = stmt.executeQuery(sql_cnt.toString());
			
			rs.next();
				max_count = rs.getInt(1);

			if(max_count > 0)
			{
			
%>
	<br>
		<table border='0' width='100%' cellpadding='0' cellspacing='0' align='center' >
			<tr><td class="COLUMNHEADER" style='BACKGROUND-COLOR: #ffc5b5;COLOR: black;'><font='verdana' size='1'><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></font></td>
			</tr>
		</table>
	

	<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
		<tr>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></td>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="Common.Problem.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter' align='center' nowrap><fmt:message key="Common.Problem.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
		</tr>
<%
		
				sql = "select a.complaint_id complaint_id, complaint_desc, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy HH24:MI') onset_datetime_str from ca_encntr_chief_complaint a where a.facility_id=? and a.encounter_id=? and not exists(select 1 from pr_diagnosis_compl_enc_dtl where facility_id=a.facility_id and encounter_id= a.encounter_id  and complaint_id = a.complaint_id)order by a.onset_datetime DESC";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,encounter_id);
				//pstmt.setString(4,term_set_id);
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					counts2++;
						if ( k%2 == 0 )
						classValue		= "QRYEVEN" ;
					 else
						classValue		= "QRYODD" ;
				   
					_complaint_id		= rs.getString("complaint_id")==null?"":rs.getString("complaint_id");
					_complaint_desc		= rs.getString("complaint_text")==null?"":rs.getString("complaint_text");

					_onset_datetime_str	= 
						rs.getString("onset_datetime_str")==null?"":rs.getString("onset_datetime_str");
					_onset_date_converted=	DateUtils.convertDate(_onset_datetime_str,"DMYHM","en",locale); 
					
					if(tempProblems.contains(_complaint_id))
						chkLink					= "checked";
					else
						chkLink					= "";

					%>
						<tr>
							<td class=<%=classValue%> nowrap><input type ='checkbox' name = '_select<%=k%>' value = 'N' <%=chkLink%> ></input></td>
							<td class=<%=classValue%> nowrap><%=_complaint_id%><input type ='hidden' name = '_complaint_id<%=k%>' value = '<%=_complaint_id%>'></input></td>
							<td class=<%=classValue%> nowrap><%=_complaint_desc%><input type ='hidden' name = '_complaint_desc<%=k%>' value = '<%=_complaint_desc%>'></input></td>
							<input type='hidden' name = '_comp_onset_date<%=k%>' value='<%=_onset_date_converted%>'/>
						</tr>
					<%
					k++;
				}
			}
			if(counts1==0 && counts2==0){%><script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));window.close();history.go(-1);</script>
			<%}
		
		}
		catch(Exception e)
		{
			//out.println("Exception @ try"+e.toString());
			e.printStackTrace(System.err);
		}
%>
	</table>
<%
	}
}catch(Exception ex){
	ex.printStackTrace();
}finally{
	if(con!=null){
			ConnectionManager.returnConnection(con,request);
		}
	}

%>


<input type = 'hidden' name = 'total_cnt' value='<%=j%>'>
<input type = 'hidden' name = 'max_record' value='<%=max_record%>'>
<input type = 'hidden' name = 'max_count' value='<%=max_count%>'>
<input type = 'hidden' name = 'callFunction' value='<%=callFunction%>'>
<input type = 'hidden' name = 'diag_onset_date' value='<%=onset_date%>'>
</form>
</body>
<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

