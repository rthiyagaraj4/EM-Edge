<!DOCTYPE html>
<!-- Developed By      :   Prashant Bhalsingh
     Created on        :    21/06/2001
     Module Name       :    FM\File Not returned to MRD
-->
<%@ page  import="java.sql.*,java.util.*,webbeans.eCommon.*, java.text.* , java.sql.Date,java.math.*,com.ehis.util.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
   <!--  <LINK rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
   <%
   request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
    <SCRIPT src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<SCRIPT language='javascript' src='../../eFM/js/QueryFMFileNotReturnedToMRD.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<HEAD>
<BODY OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();' >
	<FORM name="QueryFMSearchResult" id="QueryFMSearchResult" action="../../eFM/jsp/QueryFMFileNotReturnedToMRDSearchResult.jsp" method="post">
<% 
        Connection con				= ConnectionManager.getConnection(request);
       	java.sql.Statement mystmt	= null;
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null;
		PreparedStatement pstmt2	= null;
		PreparedStatement pstmt3	= null;
		PreparedStatement pstmt4	= null;
		PreparedStatement pstmt5	= null;
        ResultSet rset				= null;
       	ResultSet rset1				= null;
		ResultSet rset2				= null;
			
       // java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy") ;

        String discharge_date_time = "";
       String discharge_date_time1="";
		//int	nextRecord = (request.getParameter("nextRecord")==null)? 0 : Integer.parseInt(request.getParameter("nextRecord"));
        
//        int	previousRecord = (request.getParameter("previousRecord")==null)? 0 : Integer.parseInt(request.getParameter("previousRecord"));        
       
        String sql               = "";  
      //  String sql0              = "";  
        String sql1              = "";  
        String sql11             = ""; 
		String sql2				 = "";        
        String file_type_appl_yn = "";  
        String classValue        = "";
		String req_start		 = "", req_end = "";
        String patient_id="";
		String curr_locn_id="";
		String iss_date_time = "";
		String return_date_time = "";
		String nia_return_date = "";
       	StringBuffer sqlCriteria	= null;
		sqlCriteria					= new StringBuffer();

        String from_search		= request.getParameter("from_search");
		String from				= request.getParameter("from");
		String to				= request.getParameter("to");
		String queryCriteria    = request.getParameter("criteria");
        String flag             = request.getParameter("flag");
        String facility_id      = request.getParameter("facility_id");
        String out_facility_id	= request.getParameter("out_facility_id");
		String out_criteria		= request.getParameter("out_criteria");
		//out.println("out_criteria==="+out_criteria);
		String fs_locn_id		= request.getParameter("fs_locn_id");
		file_type_appl_yn		= request.getParameter("file_type_appl_yn");
		String doc_or_file				= request.getParameter("doc_or_file");//Added on 7th Mar 2017 for ML-MMOH-SCF-0588
       	int parameter_hours = 0;	
		if(out_facility_id == null || out_facility_id.equals("null")) out_facility_id = "";
		if(out_criteria == null || out_criteria.equals("null")) out_criteria = "";
		if(queryCriteria == null || queryCriteria.equals("null")) queryCriteria = "";
		if(fs_locn_id == null || fs_locn_id.equals("null")) fs_locn_id = "";
		if(facility_id == null || facility_id.equals("null")) facility_id = "";
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
		if(doc_or_file == null || doc_or_file.equals("null")) doc_or_file = "";//Added on 7th Mar 2017 for ML-MMOH-SCF-0588
		
		int counter             = 0;
        int fromRecordNumber    = 0;
        int toRecordNumber      = 0;
        int noOfRecords         = 0; 
		double diffhrs=0.00; 
		int maxRecord	= 0;
	    int start		= 0;
		int end			= 0;
	    int i			= 1;
		
		if (from == null){ start = 0; } else { start = Integer.parseInt(from); }
	    if (to == null){ end = 5; } else { end = Integer.parseInt(to); }

		req_start  = (request.getParameter("start") == null) ? "0" : request.getParameter("start");
		req_end    = (request.getParameter("end") == null)   ? "0" : request.getParameter("end");

        if(from_search == null)from_search = "";
		
		try
		{
			if(from_search.equals("Y"))
		    {
				if(!out_facility_id.equals(""))
					sqlCriteria.append( " AND  a.curr_facility_id = '"+out_facility_id+"' ");
				if(!out_criteria.equals(""))
					sqlCriteria.append(" AND  a.curr_fs_locn_code = '"+out_criteria+"' ");
				if(!queryCriteria.equals(""))
					sqlCriteria.append(" AND  a.PERM_FS_LOCN_CODE = '"+queryCriteria+"' ");
				if(!fs_locn_id.equals(""))
					sqlCriteria.append(" AND  a.curr_fs_locn_identity = '"+fs_locn_id+"' ");
			}
			else
			{
				if(!queryCriteria.equals(""))            
					sqlCriteria.append(" AND  a.PERM_FS_LOCN_CODE='" + queryCriteria + "' " );
			}
			
			i = 1;

           	mystmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//sql	= "SELECT a.file_no,a.file_type_desc,a.volume_no,get_patient_line(a.patient_id,'"+localeName+"') patient_line,a.curr_fs_locn_code,a.curr_fs_locn_short_desc,DECODE(a.curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing unit','X','External', 'E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity,DECODE(A.CURR_FILE_STATUS,'R','Returned', 'I','Inside','O','Outside','L','Lost','T','InTransit','A','Archived','E','Other Facility')curr_file_status,TO_CHAR(a.iss_date_time,'dd/mm/rrrr hh24:mi') iss_date_time,TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') return_date_time,(CASE WHEN sysdate > return_date_time THEN 'Y' ELSE 'N' END) time_bar,(CASE WHEN facility_id<>curr_facility_id THEN '(' || curr_facility_name ||')' ELSE '&nbsp;' END) curr_facility_name,a.return_criteria,a.no_of_dh_to_return_op, a.duration_type,TO_CHAR(a.nia_return_date,'dd/mm/rrrr hh24:mi') nia_return_date FROM fm_curr_locn_vw a WHERE a.curr_fs_locn_code<>a.mr_pat_fs_locn_code AND doc_folder_id is null AND a.facility_id='"+ facility_id +"' "+sqlCriteria+" ORDER BY a.curr_fs_locn_short_desc,a.file_no " ;
			sql	= "SELECT  a.file_no ,a.curr_locn_id ,a.patient_id, MR_GET_DESC.MR_FILE_TYPE(a.facility_id, a.file_type_code, '"+localeName+"', 2) file_type_desc  ,a.volume_no  ,get_patient_line(a.patient_id,'"+localeName+"') patient_line  ,a.curr_fs_locn_code  ,FM_GET_DESC.FM_STORAGE_LOCN(A.CURR_FACILITY_ID, a.curr_fs_locn_code,'"+localeName+"','2') curr_fs_locn_short_desc  ,a.curr_fs_locn_identity curr_fs_locn_identity  ,A.CURR_FILE_STATUS curr_file_status  ,TO_CHAR(a.iss_date_time,'dd/mm/rrrr hh24:mi') iss_date_time  ,TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') return_date_time  ,(  CASE   WHEN sysdate > return_date_time   THEN  'Y'   ELSE 'N'   END) time_bar  ,(  CASE   WHEN a.facility_id<>curr_facility_id   THEN  '(' || SM_GET_DESC.SM_FACILITY_PARAM(A.CURR_FACILITY_ID,'"+localeName+"','1') ||')'   ELSE '&nbsp;'   END) curr_facility_name  ,b.return_criteria  ,b.no_of_dh_to_return_op  , b.duration_type  ,TO_CHAR(a.nia_return_date,'dd/mm/rrrr hh24:mi') nia_return_date  FROM  fm_curr_locn a,   fm_storage_locn b WHERE a.curr_fs_locn_code<>a.PERM_FS_LOCN_CODE   AND doc_folder_id IS null   AND a.facility_id='"+ facility_id +"'   "+sqlCriteria+"  AND a.curr_facility_id = b.facility_id  AND a.curr_fs_locn_code = b.fs_locn_code ORDER BY  FM_GET_DESC.FM_STORAGE_LOCN(A.CURR_FACILITY_ID, a.curr_fs_locn_code,'"+localeName+"','2')  ,a.file_no  " ;
	
	
			try
			{
		  		rset = mystmt.executeQuery(sql);
				rset.last();
				maxRecord = rset.getRow();
				rset.beforeFirst();
	        }catch(Exception e){
				out.println("resultset"+e);
				e.printStackTrace() ;
			}
			%>				
            <TABLE cellpadding="0" cellspacing="0" align='center' width="100%">
				<TR>
				<TD align='right' >
				<% if(!(start <= 1)) { %>
					<A href='javascript:getNext(<%=(start-5)%>,<%=(end-5)%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
				<% } if(!((start+5) >= maxRecord)) {
					%>
					<A href='javascript:getNext(<%=(start+5)%>,<%=(end+5)%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
				<% } %>
				</TD>
					</TR>
				</TABLE>
<!--Added for ML-MMOH-SCF-0588 on 7th Mar 2017 Start-->
<TABLE border="1" cellpadding="0" cellspacing="0" align='center' width="100%">
<% if(doc_or_file.equals("D")) { %>
	  <TR><Td colspan="7" class='columnheader'><fmt:message key="eFM.CurrentFSlocationoftheDocument.label" bundle="${fm_labels}"/></Td></TR>
	  <TR><TD></TD></TR>
	  <TR>
	  <Th class='columnheader' width="38%"><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></Th> 
	  <Th class='columnheader' width="12%"<fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></Th>
      <Th class='columnheader' width="10%"><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/></Th>
<% } else if(doc_or_file.equals("F")) { %>
	  <TR><Th colspan="7" class='columnheader'><fmt:message key="eFM.CurrentFSlocationoftheFile.label" bundle="${fm_labels}"/></Th></TR>
	  <TR><TD></TD></TR>
	  <TR>
 <% if(file_type_appl_yn.equals("Y")) { %>
      <Th class='columnheader' width="38%"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></Th>
 <% } else if(file_type_appl_yn.equals("N")) { %>
      <Th width="38%" class='columnheader'><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></Th>
 <% } %>
	  <Th class='columnheader' width="12%"><fmt:message key="eFM.FileTypeVolumeNo.label" bundle="${fm_labels}"/></Th>
      <Th class='columnheader' width="10%"><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></Th>
<% } %>
	  <Th class='columnheader' width="10%"><fmt:message key="Common.issueddate.label" bundle="${common_labels}"/></Th>
	  <!--Modified by Ashwini on 18-Jul-2017 for ML-MMOH-SCF-0763-->
      <Th class='columnheader' width="10%"><fmt:message key="eFM.ReturnDueDateTime.label" bundle="${fm_labels}"/></Th>
      <Th class='columnheader' width="10%"><fmt:message key="eFM.NIADueDate.label" bundle="${fm_labels}"/></Th>
	  <Th class='columnheader' width="10%"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></Th> 
    </TR>
</TABLE>
<!--End-->
		        <TABLE border="1" cellpadding="0" cellspacing="0" align='cenetr' width="100%">
				<%
		        String p_first_curr_fs_locn_code = "";				
				String bgcolor                   = "";
				String nia_bgcolor               = "";
				String return_criteria			 = "";
			//	String no_of_dh_to_return_ip	 = "";
				String no_of_dh_to_return_op	 = "";
				String curr_fs_locn_identity	 = "";
				String duration_type			 = "";
				String f_no						 = "";
				String vol_no					 = "";
				String returnfile_date_time		 = "";
				//String no_hours					 = "0";
				double no_hours					 = 0.00;
				//String nia_no_hours				 = "0";
				double nia_no_hours				 = 0.00;
				String curr_file_status			 = "";
					
				int p_rec_cnt	= 0;
				int cnt			= 0;  //To Display the total No of Files Groupwise - by Meghanath.

				if(start != 0)
				{
					for(int j=1; j<=start; i++,j++)
					{
						rset.next() ;
					}
				}

				/*sql0 = "SELECT to_char(MAX(ISS_DATE_TIME)+ (?/24),'dd/mm/rrrr hh24:mi') returndate FROM FM_CURR_LOCN WHERE FILE_NO = ? ";
				pstmt = con.prepareStatement(sql0);*/

				sql1 = "SELECT (sysdate - max(DISCHARGE_DATE_TIME)) *24 diffinhours FROM pr_encounter WHERE discharge_date_time is not null AND facility_id = ? and assign_care_locn_code=? AND patient_id in (select patient_id FROM fm_movement_log where FILE_NO = ? AND patient_id=? AND facility_id = ? AND SENT_DATE_TIME IS NOT null)";
				pstmt1 = con.prepareStatement(sql1);

			//	sql11 = "SELECT (sysdate-max(SENT_DATE_TIME)) *24 diffinhours from fm_movement_log where FILE_NO = ? AND VOLUME_NO = ? AND facility_id = ? and SENT_DATE_TIME is not null";
			
			sql11 = "SELECT (sysdate-max(RETURN_DATE_TIME)) diffinhours from fm_curr_locn where FILE_NO = ? AND patient_id =? AND VOLUME_NO = ? AND facility_id = ? ";
				pstmt2 = con.prepareStatement(sql11);
				
				sql2 = "SELECT (sysdate - max(nia_return_date)) *24 nia_diffinhours from fm_curr_locn where nia_return_date is not null AND facility_id = ? and patient_id in (select patient_id from fm_movement_log WHERE file_no = ? AND patient_id =? AND facility_id = ? and sent_date_time is not null)";
				pstmt3 = con.prepareStatement(sql2);

			//	String mysql1 = "SELECT to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi')discharge_date_time,to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id = ? AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no = ? AND facility_id = ? AND sent_date_time IS NOT null)";
			//	pstmt5 = con.prepareStatement(mysql1);

			
           while(rset.next() && i<=end)
				{
					return_criteria			= rset.getString("return_criteria");
				//	no_of_dh_to_return_ip	= rset.getString("no_of_dh_to_return_ip");
					no_of_dh_to_return_op	= rset.getString("no_of_dh_to_return_op");
					curr_fs_locn_identity	= rset.getString("curr_fs_locn_identity");
					duration_type			= rset.getString("duration_type");
					 patient_id=rset.getString("patient_id");
				curr_locn_id=rset.getString("curr_locn_id");
		      if(patient_id==null) patient_id="";
				if(curr_locn_id==null) curr_locn_id="";	
					
					f_no					= rset.getString("file_no");
					vol_no					= rset.getString("volume_no");
					curr_file_status= rset.getString("curr_file_status")==null? "&nbsp" :rset.getString("curr_file_status");

					if(return_criteria == null || return_criteria.equals("null")) return_criteria = "";
				//	if(no_of_dh_to_return_ip == null) no_of_dh_to_return_ip = "0";
					if(no_of_dh_to_return_op == null) no_of_dh_to_return_op = "0";
					if(curr_fs_locn_identity == null ) curr_fs_locn_identity = "";
					if(duration_type == null ) duration_type = "";
					if(f_no == null) f_no = "";
					if(vol_no == null) vol_no = "";

					if(!curr_fs_locn_identity.equals(""))
		{
			switch(curr_fs_locn_identity.charAt(0))
			{
				case 'D' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
				
			if(!curr_file_status.equals(""))
			{
				switch(curr_file_status.charAt(0))
				{
					case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

					case 'R' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels"); break;

					case 'E' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels"); break;
			
				}
			}					

				
										
					if(duration_type.equals("D"))
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}

			        if(counter == 0)
					{
						p_first_curr_fs_locn_code = rset.getString("curr_fs_locn_code");
						%>
						<TR> 
							<TD  width="100%"  colspan='7' class='CAGROUPHEADING' ><B><%=rset.getString("curr_fs_locn_short_desc")+" ("+curr_fs_locn_identity+") "%></B></TD>
						</TR>
						<%
					}
			        else if(!p_first_curr_fs_locn_code.equals(rset.getString("curr_fs_locn_code")))
					{
						if(classValue.equals("QRYODD"))
						{
							classValue = "QRYEVEN";
						}
						else if(classValue.equals("QRYEVEN"))
						{
							classValue = "QRYODD";
						}
						%>						
						<TR><TD colspan='7' class='<%=classValue%>'><FONT size=1><B>
							<fmt:message key="eFM.TotalNoofFiles.label" bundle="${fm_labels}"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cnt%></B></FONT>
							</TD>
						</TR>
						<%
						cnt = 0;
						%>
						<TR>
							<TD  width="100%"  colspan='7' class='CAGROUPHEADING'  ><B><%=rset.getString("curr_fs_locn_short_desc")+" ("+curr_fs_locn_identity+") "%></B></TD>
						</TR>
					<%
					}

					counter++;

					if(counter % 2 == 0) classValue = "QRYODD";
					else classValue = "QRYEVEN" ;
						
					//no_hours				= "0";
					no_hours				= 0.00;
					//nia_no_hours			= "0";
					nia_no_hours			= 0.00;
					returnfile_date_time	= "";
		
		///////////////////////////////////////////////////////////////////////
		
					/*pstmt.setInt(1,parameter_hours);
					pstmt.setString(2,f_no);
					
					rset2 = pstmt.executeQuery();
					
					while(rset2 != null && rset2.next())
					{
						returnfile_date_time = rset2.getString("returndate");
						if(returnfile_date_time == null) returnfile_date_time = "";
					} if(rset2 != null) rset2.close();*/

		/////////////////////////////////////////////////////////////////////////////
          
		
		   if(return_criteria.equals("D"))
					{

		/////////////////////////////////////////////////////////////////////////////

						pstmt1.setString(1,facility_id);
						pstmt1.setString(2,curr_locn_id);
						pstmt1.setString(3,f_no);
						pstmt1.setString(4,patient_id);
						pstmt1.setString(5,facility_id);
						rset1 = pstmt1.executeQuery();

		/////////////////////////////////////////////////////////////////////////////
						
					}
					else
					{

	/////////////////////////////////////////////////////////////////////////////                       
						pstmt2.setString(1,f_no);
						pstmt2.setString(2,patient_id);
						pstmt2.setString(3,vol_no);
						pstmt2.setString(4,facility_id);
						rset1 = pstmt2.executeQuery();

		/////////////////////////////////////////////////////////////////////////////

					}
					
					while(rset1 != null && rset1.next())
					{
						no_hours = rset1.getDouble("diffinhours");
						//if(no_hours == null) no_hours=0.00;
						//else if(no_hours == "0") no_hours=0.00;
						//no_hours =  no_hours.substring(0,no_hours.indexOf("."));
					} if(rset1  !=null) rset1.close();

		/////////////////////////////////////////////////////////////////////////////
					//if(!no_hours.equals("-")){
						//	if(Integer.parseInt(no_hours) <= parameter_hours)
						if(no_hours <= 0.00)
						{
							bgcolor="orange";		
						}
					//	else if(Integer.parseInt(no_hours) > parameter_hours)
						else if(no_hours > 0.00)
						{
							bgcolor = "red";		
						}	
					//}
					if(return_criteria.equals("D"))
					{

		/////////////////////////////////////////////////////////////////////////////

						pstmt3.setString(1,facility_id);
						pstmt3.setString(2,f_no);
						pstmt3.setString(3,patient_id);
						pstmt3.setString(4,facility_id);
						
						rset1 = pstmt3.executeQuery();
						
						while(rset1!= null && rset1.next())
						{
							nia_no_hours = rset1.getDouble("nia_diffinhours");
							//if(nia_no_hours == null) nia_no_hours="0.00";
							//nia_no_hours =  nia_no_hours.substring(0,nia_no_hours.indexOf("."));
						} if(rset1  !=null) rset1.close();

		/////////////////////////////////////////////////////////////////////////////

					}						
					if(return_criteria.equals("D"))
					{
						if(nia_no_hours <= parameter_hours)
						{
							nia_bgcolor = "orange";		
						}
						else if(nia_no_hours > parameter_hours)
						{
							nia_bgcolor = "red";		
						}	
										
					}
					else
					{
						if(no_hours <= parameter_hours)
						{
							nia_bgcolor = "orange";		
						}
						else if(no_hours > parameter_hours)
						{
							nia_bgcolor = "red";		
						}	
					}
				////////////////////////////////////////////////////////////////////
				// Modified against HSA-SCF-0112 : Getting IncompleteLocation from the table-FM_PARAMETER 
				/*Change Desc: If incompletefslocation of FM Parameter value exists, then in search criteria, avoiding the clinic code check 
								in where condition of the below query 'mysql1' */
				
				String sqlChkInCompleteLocn = "SELECT DFLT_INCOMPLETE_FS_LOCN_CODE  FROM FM_PARAMETER  WHERE FACILITY_ID = '"+facility_id+"'";
				String sIncompleteFSLocn = "";
				String mysql1 = "";
				
				pstmt5 = con.prepareStatement(sqlChkInCompleteLocn);	
				rset1  = pstmt5.executeQuery();
				
				if(rset1 != null && rset1.next())
				{
					sIncompleteFSLocn  = rset1.getString("DFLT_INCOMPLETE_FS_LOCN_CODE");
				} 
				if(rset1 != null) rset1.close();
				if(pstmt5 != null) pstmt5.close();
				
				if( sIncompleteFSLocn != null && sIncompleteFSLocn != "")
				{
					mysql1 = "SELECT to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi')discharge_date_time,to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time,(sysdate-(discharge_date_time+ "+(parameter_hours)+" / 24)) diffhrs  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id = ? AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no = ? AND facility_id = ? AND sent_date_time IS NOT null)";
					 
					pstmt5 = con.prepareStatement(mysql1);
					pstmt5.setString(1,facility_id);
					pstmt5.setString(2,f_no);
					pstmt5.setString(3,facility_id); 
				}else
				{
					mysql1 = "SELECT to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi')discharge_date_time,to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time,(sysdate-(discharge_date_time+ "+(parameter_hours)+" / 24)) diffhrs  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id = ? AND assign_care_locn_code=? AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no = ? AND facility_id = ? AND sent_date_time IS NOT null)";
					pstmt5 = con.prepareStatement(mysql1);
					pstmt5.setString(1,facility_id);
					pstmt5.setString(2,curr_locn_id);
					pstmt5.setString(3,f_no);
					pstmt5.setString(4,facility_id); 
				}
				
					rset1 = pstmt5.executeQuery();
					
					discharge_date_time = "";
 
					if(rset1 != null && rset1.next())
					{
						discharge_date_time = rset1.getString(1);
					    discharge_date_time1 = rset1.getString(2);
					  diffhrs                  =rset1.getDouble("diffhrs");
					} if(rset1 != null) rset1.close();
					if(pstmt5 != null) pstmt5.close();//checkstyle changes for 35865

		//////////////////////////////////////////////////////////////////////
						if(!discharge_date_time.equals(""))
						{
							discharge_date_time=DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
						}
						else
					{
						discharge_date_time ="&nbsp";
					}
					if(discharge_date_time1 != null || (!discharge_date_time1.equals(""))) 
					{
                    discharge_date_time1=DateUtils.convertDate(discharge_date_time1,"DMYHM","en",localeName);
					}else{
                     discharge_date_time1 ="&nbsp";
                 
					}
					%>
				    <TR>
				       <TD  width="38%" class='<%=classValue%>' ><FONT size=1>
						<%
						if(file_type_appl_yn.equals("N"))
						{
						%>
						<%=(rset.getString("file_no")==null)?"":"<b>"+rset.getString("file_no")+"</b><br>&nbsp;&nbsp;"+rset.getString("patient_line").substring(0,rset.getString("patient_line").length()-6)%></FONT></TD>
					<% } else if(file_type_appl_yn.equals("Y")) { %>
					<%=(rset.getString("patient_line").substring(0,rset.getString("patient_line").length()-6))%></FONT></TD>
					<% } %>
						<TD  width="12%" class='<%=classValue%>' nowrap><CENTER><FONT size=1><%=(rset.getString("file_type_desc")==null)?"&nbsp;":(rset.getString("file_type_desc")+" / ")%>
						<%=(rset.getString("volume_no")==null)?"&nbsp;":rset.getString("volume_no")%>
						</FONT></CENTER>
						</TD>
						<TD  width="10%" class='<%=classValue%>'><FONT size=1>
           				<%=curr_file_status+"<br>"+rset.getString("curr_facility_name")+""%></FONT></TD>
						<%
						iss_date_time = rset.getString("iss_date_time");
						if(iss_date_time != null)
						{
							iss_date_time=DateUtils.convertDate(iss_date_time,"DMYHM","en",localeName);
						}
						else
							iss_date_time = "&nbsp";
						%>
				        <TD  width="10%" class='<%=classValue%>'><FONT size=1>
						<%=iss_date_time%></FONT></TD>
						<%
						if(rset.getString("return_date_time") == null || rset.getString("return_date_time").equals(""))
							bgcolor="";
						
						return_date_time = rset.getString("return_date_time");
						if(return_date_time != null)
						{
							return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
						}
						else
							return_date_time = "&nbsp";
						
						if(return_criteria.equals("D")){	 			
															
						
						if(parameter_hours<=0)
							{
						discharge_date_time1="&nbsp;";
						}
							if(return_date_time.equals("&nbsp"))
							{
							return_date_time=discharge_date_time1; 
						    }
						if(!return_date_time.equals("") && parameter_hours>0)
							{
											
						if(diffhrs <= 0.00)
						{
							bgcolor="orange";		
						}
					//	else if(Integer.parseInt(no_hours) > parameter_hours)
						else if(diffhrs >0.00)
						{
							bgcolor = "red";		
						}
							}
						}
						if(return_date_time.equals(""))
					    {
                         return_date_time="&nbsp";
						   }
												
						if(!discharge_date_time.equals("&nbsp") && return_criteria.equals("D") && parameter_hours>0)					
						{
						%>	
					      <TD  width="10%" class='<%=classValue%>' style='background-color:<%=bgcolor%>'><FONT size=1>
					       <%=discharge_date_time1%></FONT>
						<%}else{%>
						 <TD  width="10%" class='<%=classValue%>' style='background-color:<%=bgcolor%>'><FONT size=1>
					       <%=return_date_time%></FONT>
						<%}%>
						</TD>
						<%
						return_date_time="";
						  discharge_date_time1="";
						  if(rset.getString("nia_return_date") == null || rset.getString("nia_return_date").equals(""))
							nia_bgcolor="";

						nia_return_date = rset.getString("nia_return_date");
					
					if(discharge_date_time.equals("&nbsp") && return_criteria.equals("D") &&  nia_return_date != null)
					  {
					 nia_return_date=null;
					nia_bgcolor="";
						}
						
						
						if(nia_return_date != null)
						{
							nia_return_date=DateUtils.convertDate(nia_return_date,"DMYHM","en",localeName);
						}
						else
							nia_return_date = "&nbsp";
						
												
						
						
						
						%>	
						  <TD  width="10%" class='<%=classValue%>' style='background-color:<%=nia_bgcolor%>'><FONT size=1>
							<%=nia_return_date%></FONT>
						</TD>
						
						  <TD  width="10%" class='<%=classValue%>'><FONT size=1>
							  <%=discharge_date_time%>	  
						  </FONT>
						 
						  </TD>  
					</TR>
					<%
	                p_first_curr_fs_locn_code = rset.getString("curr_fs_locn_code");
   			       	p_rec_cnt++;
					if(p_first_curr_fs_locn_code.equals(rset.getString("curr_fs_locn_code")))
					{
						cnt++;
					}i++;
				}
				if(cnt !=0)
				{
					if(classValue.equals("QRYODD"))
					{
						classValue = "QRYEVEN";
					}
					else if(classValue.equals("QRYEVEN"))
					{
						classValue = "QRYODD";
					}
					%>
					<TR><TD colspan='7' class='<%=classValue%>'><FONT size=1><B>
							<fmt:message key="eFM.TotalNoofFiles.label" bundle="${fm_labels}"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cnt%></B></FONT>
						</TD>
					</TR>
				<% } %>
				<SCRIPT>
					var p_rec_cnt = '<%=p_rec_cnt%>';
					var p_criteria = '<%=queryCriteria%>';
					if (p_criteria=='all')
					{
						
						alert(getMessage('FILE_STORAGE_NOT_BLANK','FM'));
					}
					else if (parseInt(p_rec_cnt)==0)
					{
						
						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
					}
				</SCRIPT>
				<input type='hidden' name='from' id='from' value='<%=start%>'>
				<input type='hidden' name='to' id='to' value='<%=end%>'>
			 </TABLE>
		<%
		if(rset  !=null) rset.close(); 
		if(rset1 !=null) rset1.close();
		if(rset2 !=null) rset2.close();
		if(mystmt !=null) mystmt.close();
		if(pstmt !=null) pstmt.close();
		if(pstmt1 !=null) pstmt1.close();
		if(pstmt2 !=null) pstmt2.close();
		if(pstmt3 !=null) pstmt3.close();
		if(pstmt4 !=null) pstmt4.close();
		if(pstmt5 !=null) pstmt5.close();

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
	<SCRIPT>
		parent.frames[1].document.forms[0].search.disabled=false;
	</SCRIPT>
	<INPUT type='hidden' name='doc_or_file' id='doc_or_file' value='<%=doc_or_file%>'><!--Added by Thamizh selvi on 7th Mar 2017 for ML-MMOH-SCF-0588-->
	<INPUT type='hidden' name='previousRecord' id='previousRecord' value='<%=fromRecordNumber%>'>
	<INPUT type='hidden' name='nextRecord' id='nextRecord' value='<%=toRecordNumber%>'>   
	<INPUT type='hidden' name='flag' id='flag' value='<%=flag%>' >
	<INPUT type='hidden' name='criteria' id='criteria' value='<%=queryCriteria%>'>  
	<INPUT type='hidden' name='noOfRecords' id='noOfRecords' value='<%=noOfRecords%>'>     
	<INPUT type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<INPUT type='hidden' name='fs_locn_id' id='fs_locn_id' value='<%=fs_locn_id%>'>
	<INPUT type='hidden' name='from_search' id='from_search' value='<%=from_search%>'>
	<INPUT type='hidden' name='out_criteria' id='out_criteria' value='<%=out_criteria%>'>
	<INPUT type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
    <INPUT type='hidden' name='out_facility_id' id='out_facility_id' value='<%=out_facility_id%>'>

</FORM>
</BODY>
</HTML>

