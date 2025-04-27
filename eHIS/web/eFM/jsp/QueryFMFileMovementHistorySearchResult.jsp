<!DOCTYPE html>
 <!-- Developed By	   :	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\File movement history
-->
<%@ page contentType="text/html; charset=UTF-8"  import="java.sql.*, java.util.*, webbeans.eCommon.*,java.text.*,java.sql.Date" %>  
<%@ page %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>
<HEAD>
	<!-- <LINK rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
	<script language='javascript' src='../../eFM/js/QueryFMFileMovementHistroy.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<HEAD>
<BODY onMouseDown="CodeArrest();" onLoad='FocusFirstElement();' onKeyDown = 'lockKey();'>
<FORM name="QueryFMSearchResult" id="QueryFMSearchResult" action="../../eFM/jsp/QueryFMFileMovementHIstorySearchResult.jsp" method="post">
<%
		Connection con  = ConnectionManager.getConnection(request);
		PreparedStatement pstmt_temp = null;
		ResultSet rs_temp = null;
		Statement stmt	= null;
		ResultSet rset	= null;
		Statement st	= null;
		ResultSet rs	= null;		
		
		String sql					= "";
		String mysql				= ""; 		
		String volumeCriteria		= "";
		String classValue			= "",p_req_remarks="",p_iss_remarks="";
		String current_locn_desc	= "";		
		String curr_file_status		= "";
		String IssueDate			= "";
		String recordedDateTime		= "";
		String curr_id_desc		    = "";
		String doc_folder_name = "";
		String doc_type = "";
		String intransit = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels");
		StringBuffer selectCriteria	= null;
      String mrd_receipt_remarks	= "";
//		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
		
		String queryCriteria = (request.getParameter("criteria")==null)?"":request.getParameter("criteria");
		String volume_no	 = ( (request.getParameter("volume_no")==null) || ((request.getParameter("volume_no").equals("null"))))?"":request.getParameter("volume_no");
		String queryfiletypeCriteria	= (request.getParameter("filetypeCriteria")==null)?"":request.getParameter("filetypeCriteria");
		String flag				=
		(request.getParameter("flag")==null)?"":request.getParameter("flag");
		String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility");
		String from				=
		(request.getParameter("from")==null)?"":request.getParameter("from");
		String to				=
		(request.getParameter("to")==null)?"":request.getParameter("to");
		String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid");
		String currStatDesc		= (request.getParameter("currStatDesc")==null)?"":request.getParameter("currStatDesc");
		String currIdDesc		= (request.getParameter("currIdDesc")==null)?"":request.getParameter("currIdDesc");
		String Curr_locn_desc	= (request.getParameter("Curr_locn_desc")==null)?"":request.getParameter("Curr_locn_desc");
		String curr_facility_name	= (request.getParameter("curr_facility_name")==null)?"":request.getParameter("curr_facility_name");
		String currentFileStatus	= (request.getParameter("currentFileStatus")==null)?"":request.getParameter("currentFileStatus");
		String file_type_appl_yn	= (request.getParameter("file_type_appl_yn")==null)?"":request.getParameter("file_type_appl_yn");
		String doc_type_code		= (request.getParameter("doc_type_code")==null)?"":request.getParameter("doc_type_code");
		String doc_folder_id		= (request.getParameter("doc_folder_id")==null)?"":request.getParameter("doc_folder_id");
		String maintain_doc_or_file	= (request.getParameter("maintain_doc_or_file")==null)?"":request.getParameter("maintain_doc_or_file");
		
		int  nextRecord		= (request.getParameter("nextRecord")==null)? 									 0:Integer.parseInt(request.getParameter("nextRecord"));

		int	previousRecord	= (request.getParameter("previousRecord")==null)? 0 :                           Integer.parseInt(request.getParameter("previousRecord"));

		int counter					= 0;
		int fromRecordNumber		= 0;
		int toRecordNumber  		= 0;
		int noOfRecords				= 0;

		try
		{
			selectCriteria = new StringBuffer();
	 		if(from != null)
			{
				from = "'" + from + "'";
			}
			if(to != null)
			{
				to   = "'" + to + "'";
			}
			if(maintain_doc_or_file.equals("F"))
			{
				if(file_type_appl_yn.equals("N"))
				{
					selectCriteria.append("AND a.file_no= '"+queryCriteria+"' ");
				}
				else if(file_type_appl_yn.equals("Y"))
				{
					selectCriteria.append("AND a.file_no= '"+queryCriteria+"' ");
					selectCriteria.append(" AND a.file_type_code= '"+queryfiletypeCriteria+"' ");
				}
				if(!volume_no.equals(""))
				volumeCriteria = " AND a.volume_no = "+volume_no+" ";
			}
			else if(maintain_doc_or_file.equals("D"))
			{
				selectCriteria.append("AND a.file_no= '"+queryCriteria+"' ");
				selectCriteria.append("AND a.doc_folder_id= '"+doc_folder_id+"' ");
				selectCriteria.append("AND a.doc_type_code= '"+doc_type_code+"' ");
			}
			
			//sql	= "SELECT a.file_no, a.patient_id, a.file_type_code, a.volume_no,a.doc_folder_id,a.doc_type_code,to_char(a.sent_date_time,'DD/MM/YYYY HH24:MI')issuedate, a.src_locn_identity, a.src_fs_locn_desc, (CASE WHEN rec_date_time IS NOT NULL THEN TO_CHAR(a.rec_date_time,'DD/MM/YYYY HH24:MI')ELSE 'In Transit' END)recordeddatetime, a.dest_locn_identity, a.dest_fs_locn_desc, SUBSTR(c.appl_user_name,1,60)appl_user_name,(CASE WHEN a.facility_id<>a.dest_facility_id THEN b.facility_name ELSE '&nbsp;' END)facility_name, a.req_remarks, a.iss_remarks, a.mrd_receipt_remarks FROM fm_movement_log_vw a, sm_facility_param b, sm_appl_user c WHERE	TRUNC(a.SENT_DATE_TIME) BETWEEN " +			"NVL( TO_DATE("+from+ ", 'dd/MM/yyyy'),TO_DATE('01/01/1900','DD/MM/YYYy')) AND " + 			"NVL( TO_DATE("+to+ ", 'DD/MM/YYYY'),TO_DATE('31/12/5000','DD/MM/YYYY')) "+selectCriteria+" "+volumeCriteria+" AND a.patient_id = '"+patientid+"' AND a.dest_facility_id=b.facility_id and a.dest_user_id=c.appl_user_id(+) ORDER BY sent_date_time desc ";
			sql = " SELECT  a.file_no  , a.patient_id  , a.file_type_code  , a.volume_no  ,a.doc_folder_id  ,a.doc_type_code  ,TO_CHAR(a.sent_date_time,'DD/MM/YYYY HH24:MI')issuedate  , a.src_locn_identity  , FM_GET_DESC.FM_STORAGE_LOCN(A.SRC_FACILITY_ID, A.SRC_FS_LOCN_CODE,'"+localeName+"','2') src_fs_locn_desc  , (  CASE   WHEN rec_date_time IS  NOT NULL   THEN  TO_CHAR(a.rec_date_time,'DD/MM/YYYY HH24:MI')  ELSE '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels")+"'   END)recordeddatetime  , a.dest_locn_identity  , FM_GET_DESC.FM_STORAGE_LOCN(A.DEST_FACILITY_ID, A.DEST_FS_LOCN_CODE,'"+localeName+"','2') dest_fs_locn_desc  , SM_GET_DESC.SM_APPL_USER(a.dest_user_id,'"+localeName+"','1') appl_user_name  ,(  CASE   WHEN a.facility_id<>a.dest_facility_id   THEN  SM_GET_DESC.SM_FACILITY_PARAM(a.dest_facility_id,'"+localeName+"','1')   ELSE '&nbsp;'   END)facility_name  , a.req_remarks  , a.iss_remarks  , a.mrd_receipt_remarks  FROM  fm_movement_log a WHERE TRUNC(a.SENT_DATE_TIME) BETWEEN " + "NVL( TO_DATE("+from+ ", 'dd/MM/yyyy'),TO_DATE('01/01/1900','DD/MM/YYYy'))   AND " + "NVL( TO_DATE("+to+ ", 'DD/MM/YYYY'),TO_DATE('31/12/5000','DD/MM/YYYY')) "+selectCriteria+" "+volumeCriteria+"  AND a.patient_id = '"+patientid+"'  ORDER BY  sent_date_time desc ";
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rset = stmt.executeQuery(sql);
			while(rset.next())
			noOfRecords = noOfRecords + 1;
			
			rset.beforeFirst(); 
		    if (noOfRecords== 0)
			{
%>
			  	<SCRIPT>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
			    	
					parent.frames[2]. location.href ="../../eCommon/html/blank.html";
				</SCRIPT>
<%
		  }
 		  else
		  {
%>
				<TABLE align='right'>
					<TR>
						<TD>
<%						if("next".equals(flag.trim()))
						{
							fromRecordNumber= nextRecord	   + 1;
							toRecordNumber	= fromRecordNumber + 8;//put x-1 in place of 8 where x RecTODisplay
							 if(nextRecord-1> 0){%>
							  <A href="javascript:getNext('previous')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/><A>
<%						}
						if(nextRecord + 9 < noOfRecords )
						{//put x in place of 9 where x is RecTODisplay%>
							  <A href="javascript:getNext('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/><A>
<%						}
			}
			if("previous".equals(flag.trim()))
			{
				fromRecordNumber	= previousRecord   - 9;//put x in place of 9 where x is RecTODisplay
				toRecordNumber	= fromRecordNumber + 8;//put x-1 place of 1 where x is RecTODisplay
				if( previousRecord - 9  > 1)
				{//put x in place of 9 where x is RecTODisplay%>
     				<A href="javascript:getNext('previous')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/><A>
<%				}
				if (previousRecord <= noOfRecords )
				{
%>
	    			<A href="javascript:getNext('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/><A>
<%				}
			}
%>
			</TD>
		</TR>
	</TABLE>	
	<BR>
	<BR>
	<TABLE border="0" cellpadding="0" cellspacing="0" align='center' width="99%">
<% 
	if(maintain_doc_or_file.equals("D")){
		try{
	String sql_temp = " SELECT A.DOC_FOLDER_NAME, B.PATIENT_ID, B.FROM_PERIOD, B.TO_PERIOD, B.PATIENT_PERIOD_SPECIFIC,(CASE WHEN B.PATIENT_PERIOD_SPECIFIC='D'  THEN ', ' || TO_CHAR(B.FROM_PERIOD,'DD/MM/YYYY ') || ' - ' || TO_CHAR(B.TO_PERIOD,'DD/MM/YYYY ')ELSE ', ' || GET_PATIENT_LINE(B.PATIENT_ID,'"+localeName+"') END)DOC_TYPE FROM FM_CURR_LOCN_VW A, FM_DOC_FOLDER B WHERE A.FACILITY_ID = '"+facility+"'  AND A.DOC_FOLDER_ID = B.DOC_FOLDER_ID(+) AND A.FACILITY_ID = B.FACILITY_ID  "+selectCriteria+" AND A.PATIENT_ID = '"+patientid+"' ";
	pstmt_temp = con.prepareStatement(sql_temp);
	rs_temp = pstmt_temp.executeQuery();
	while(rs_temp.next())
		{
			doc_folder_name = rs_temp.getString("doc_folder_name")==null?"":rs_temp.getString("doc_folder_name");
			doc_type = rs_temp.getString("doc_type")==null?"":rs_temp.getString("doc_type");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
%>
	<tr>
		<td colspan='3' class='PATIENTLINECOLOR'>
	<font size=1 color='white'><b><%=doc_folder_name%>&nbsp;<%=doc_type%>&nbsp;</b></font>	
		</td>
	
	</tr>		
<% } else { %>
		<TR>
			<TD colspan='3'>
				<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name="Patient_ID" value="<%=patientid%>"/>
				</jsp:include>
			</TD>
		</TR>

<% } %>
		<TR><TD  class='BODYCOLORFILLED' colspan='3'>&nbsp;</TD></TR>
		<TR>

<%
	//mysql = "SELECT curr_fs_locn_desc, facility_name,decode (curr_fs_locn_identity,'D', 'Department', 'C', 'Clinic','N','Nursing Unit','T','Practitioner', 'E','Procedure Unit','Y','Daycare Unit') curr_fs_locn_identity, DECODE (curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L', 'Lost',    'A', 'Archived', 'O', 'Outside', 'R', 'Returned') curr_file_status FROM fm_curr_locn_vw a WHERE a.facility_id='"+facility+"' "+selectCriteria+" "+volumeCriteria+" ";
	mysql = "SELECT  b.long_desc curr_fs_locn_desc  , (CASE  WHEN a.facility_id IS NOT NULL  THEN (SELECT SM_GET_DESC.SM_FACILITY_PARAM(a.curr_facility_id,'"+localeName+"','1')  FROM sm_facility_param  WHERE facility_id = a.facility_id)  END ) facility_name  ,curr_fs_locn_identity curr_fs_locn_identity  ,curr_file_status curr_file_status  FROM  fm_curr_locn a   , fm_storage_locn_lang_vw b WHERE a.facility_id='"+facility+"' "+selectCriteria+" "+volumeCriteria+"   AND a.curr_facility_id = b.facility_id  AND a.curr_fs_locn_code =b.fs_locn_code  AND language_id='"+localeName+"'";
	
	st = con.createStatement();
	rs = st.executeQuery(mysql);
	if(rs.next())
    {
		current_locn_desc  = rs.getString("curr_fs_locn_desc");
		curr_facility_name = rs.getString("facility_name");
		curr_file_status   = rs.getString("curr_file_status");
		curr_id_desc       = rs.getString("curr_fs_locn_identity");
    }

	if(!curr_id_desc.equals(""))
		{
			switch(curr_id_desc.charAt(0))
			{
				case 'D' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
%>
		<TD  class='label'><b><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/> :</B>&nbsp;
		(<%=curr_id_desc%>)&nbsp;<%=current_locn_desc%>&nbsp; - &nbsp;&nbsp;<%=curr_facility_name%></TD>
		</TR>
	</TABLE>
	<TABLE border="1" cellpadding="0" cellspacing="0" align='center' width="99%">
<%	
	if(rset.next())
	{
%>
		<TR><TD></TD><TR>
<%
		rset.beforeFirst();
	}
%>
		<TR>
			<th rowspan="2" height="15" class='columnheader' width='15%' align="left"><fmt:message key="eFM.Issuedon.label" bundle="${fm_labels}"/></th>
			<th	colspan="2"	height="15" width='34%' class='columnheader' align="left"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></th>
			<th rowspan="2" height="15" width='6%' class='columnheader' align="left"><fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></th>
			<th rowspan="2" height="15" width='6%' class='columnheader' align="left"><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></th>
			<th rowspan="2" height="15" width='15%' class='columnheader' align="left"><fmt:message key="eFM.Receivedon.label" bundle="${fm_labels}"/></th>
			<th rowspan="2" height="15" width='6%' class='columnheader' align="left"><fmt:message key="eFM.ReturnRemarks.label" bundle="${fm_labels}"/></th>
			<th rowspan="2" height="15" width='24%' class='columnheader' align="left"><fmt:message key="Common.ReceivedBy.label" bundle="${common_labels}"/></th>
		</TR>
		<TR>
			<th height="15" width='18%' class='columnheader' align="left"><fmt:message key="Common.Issued.label" bundle="${common_labels}"/></th>
			<th height="15" width='18%' class='columnheader' align="left"><fmt:message key="Common.received.label" bundle="${common_labels}"/></th>
		</TR>
<%
		int i = 1;
		while(rset.next()) 
		{
			p_req_remarks = rset.getString("req_remarks");
			p_iss_remarks = rset.getString("iss_remarks");

			counter++;
			if ( counter % 2 == 0 )
			  	classValue = "QRYODD";
			else
		  		classValue = "QRYEVEN";
			if(counter >=fromRecordNumber && counter <= toRecordNumber)
			{
				IssueDate=rset.getString("IssueDate");
				if(IssueDate != null)
				{
				IssueDate=DateUtils.convertDate(IssueDate,"DMYHM","en",localeName);
				}
				else
					IssueDate="";
%>
		<TR>
			<TD  height="20"  class='<%=classValue%>'><FONT size=1><%=IssueDate%>
			</TD>
			<TD  height="20" class='<%=classValue%>' ><FONT size=1>
<%
			String identity = "";
			String identityDescription =(rset.getString("SRC_LOCN_IDENTITY")==null)?"&nbsp;"
			:rset.getString("SRC_LOCN_IDENTITY");

			if("D".equals(identityDescription) || "d".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
			if("T".equals(identityDescription) || "t".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			if("C".equals(identityDescription) || "c".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			if("N".equals(identityDescription) || "n".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			if("Y".equals(identityDescription) || "y".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
			if("E".equals(identityDescription) || "e".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
%>
			<%=(rset.getString("SRC_FS_LOCN_DESC")==null)?"&nbsp;":rset.getString("SRC_FS_LOCN_DESC")%>
			<%=" ("  +  identity +  ")"%>
			</TD>
<%
				String identityReceived = "";
				String identityDescriptionReceived =(rset.getString("DEST_LOCN_IDENTITY")==null)?"&nbsp;":rset.getString("DEST_LOCN_IDENTITY");
				if( "D".equals(identityDescriptionReceived) || "d".equals(identityDescriptionReceived))
				  identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
				if( "T".equals(identityDescriptionReceived) || "t".equals(identityDescriptionReceived))
				  identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				if( "C".equals(identityDescriptionReceived) || "c".equals(identityDescriptionReceived))
					identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
				if( "N".equals(identityDescriptionReceived) || "n".equals(identityDescriptionReceived))
				    identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
				if( "Y".equals(identityDescriptionReceived) || "y".equals(identityDescriptionReceived))
				    identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
				if( "E".equals(identityDescriptionReceived) || "e".equals(identityDescriptionReceived))
				    identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
%>
                <% String fac_name=rset.getString("FACILITY_NAME");%>
				<TD	height="20" class="<%=classValue%>"><FONT size=1>
				<%=(rset.getString("DEST_FS_LOCN_DESC")==null)?"&nbsp;":rset.getString("DEST_FS_LOCN_DESC")%>
				<%if(!fac_name.equals("&nbsp;")){%>
				<%="("  +  identityReceived +  ")"%> / <%=rset.getString("FACILITY_NAME")%>
				<%}else{%>
                <%="("  +  identityReceived +  ")"%>
				<%}%>
				</TD>
				<TD  height="20" class="<%=classValue%>"><FONT size=1>
<%
				if(p_req_remarks==null)
				{
					out.println("&nbsp;</font></td>");
				}
				else
				{
%>
				   <A href='javascript:GetShowRemarks("ReqComm<%=i%>","<%=p_req_remarks%>","R")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>
			   </FONT>
					<INPUT type='hidden' name="ReqComm<%=i%>" id="ReqComm<%=i%>" value='<%=p_req_remarks%>' >   
				   </TD>
<%
				}
%>
				<TD  height="20" class="<%=classValue%>"><FONT size=1>
<%
				if(p_iss_remarks==null)
				{
					out.println("&nbsp;</font></td>");
				}
				else
				{
%>
				   <A href='javascript:GetShowRemarks("txtComm<%=i%>","<%=p_iss_remarks%>","IR")'> <fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </A>
				   </FONT>
					 <INPUT type='hidden' name="txtComm<%=i%>" id="txtComm<%=i%>" value='<%=p_iss_remarks%>' >     
				   </TD>
<%
			}
				   recordedDateTime=rset.getString("recordedDateTime");
				if(recordedDateTime != null)
				{
				
			if(!intransit.equals(recordedDateTime))
				{
				recordedDateTime=DateUtils.convertDate(recordedDateTime,"DMYHM","en",localeName);
				}
				}
				else
					recordedDateTime="";
if(curr_file_status.equals("R"))
				{
curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels");
		recordedDateTime=curr_file_status;	}
		%>
			<TD  height="20" class="<%=classValue%>"><FONT size=1>
			<%=recordedDateTime%>
			</TD>
			<TD  height="20" class="<%=classValue%>"><FONT size=1>
<%
			mrd_receipt_remarks = rset.getString("MRD_RECEIPT_REMARKS");
			if(mrd_receipt_remarks==null) mrd_receipt_remarks="";
			if(mrd_receipt_remarks == null || mrd_receipt_remarks.equals("#")) mrd_receipt_remarks="";
			if(mrd_receipt_remarks==null || mrd_receipt_remarks.equals(""))
			{
				out.println("&nbsp;</font></td>");
			}
			else
			{
%>
	<A href='javascript:GetReturnRemarks("ReqComm<%=i%>","<%=mrd_receipt_remarks%>","RR")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </a>
			     </FONT>
		<INPUT type='hidden' name="ReqComm<%=i%>" id="ReqComm<%=i%>" value='<%=mrd_receipt_remarks%>'>    
	</TD> 
<%			
			}
%>	
			</TD>
			<TD  height="20" class="<%=classValue%>"><FONT size=1>
			<%=(rset.getString("appl_user_name")==null)?"&nbsp;":rset.getString("appl_user_name")%></TD>
			</TR>
<%			
			}
	  	i++;
		}
	  }
%>
	</TABLE>
<%
		if(rs_temp!=null)rs_temp.close();
		if(pstmt_temp!=null)pstmt_temp.close();
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
		if(st!=null) st.close();


	}
	catch(Exception e)
	{
		  e.printStackTrace() ;
	}
	finally
	{
		ConnectionManager.returnConnection(con, request);
	}
%> 
   <INPUT type='hidden' name='previousRecord' id='previousRecord' value='<%=fromRecordNumber%>' >
	<INPUT type='hidden' name='nextRecord' id='nextRecord' value='<%=toRecordNumber%>' >
	<INPUT type='hidden' name='flag' id='flag' value='<%=flag%>' >
	<INPUT type='hidden' name='volume_no' id='volume_no' value='<%=volume_no%>' >
	<INPUT type='hidden' name='noOfRecords' id='noOfRecords' value='<%=noOfRecords%>' >
	<INPUT type='hidden' name='facility' id='facility' value='<%=facility%>' >
	<INPUT type='hidden' name='from' id='from' value='<%=from%>' >
	<INPUT type='hidden' name='to' id='to' value='<%=to%>' >
	<input type='hidden' name='patientid' id='patientid' value='<%=patientid%>' >
	<INPUT type='hidden' name='currStatDesc' id='currStatDesc' value='<%=currStatDesc%>'>
	<INPUT type='hidden' name='currIdDesc' id='currIdDesc' value='<%=currIdDesc%>'>
	<INPUT type='hidden' name='Curr_locn_desc' id='Curr_locn_desc' value='<%=Curr_locn_desc%>'>
	<INPUT type='hidden' name='curr_facility_name' id='curr_facility_name' value='<%=curr_facility_name%>'>
	<INPUT type='hidden' name='currentFileStatus' id='currentFileStatus' value='<%=currentFileStatus%>'>
	<INPUT type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
	<INPUT type='hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value='<%=maintain_doc_or_file%>'>
	<INPUT type='hidden' name='doc_folder_id' id='doc_folder_id' value='<%=doc_folder_id%>'>
	<INPUT type='hidden' name='doc_type_code' id='doc_type_code' value='<%=doc_type_code%>'>
	 <INPUT type='hidden' name='criteria' id='criteria' value='<%=queryCriteria%>' >
	 <%
	  if(file_type_appl_yn.equals("Y"))
	{
%>
		<INPUT type='hidden' name='filetypeCriteria' id='filetypeCriteria' value='<%=queryfiletypeCriteria%>' >
<%
	}
%>
	
</FORM>
</BODY>
</HTML>

