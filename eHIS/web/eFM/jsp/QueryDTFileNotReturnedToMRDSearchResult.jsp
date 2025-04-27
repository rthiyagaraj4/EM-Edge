<!DOCTYPE html>
<!-- Developed By      :    Utpal Sen
     Created on        :    06/09/2001
     Module Name       :    DT\Document Not returned to MRD
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* , java.sql.Date,java.math.*"  contentType="text/html; charset=UTF-8" %>
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
<BODY OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
	<FORM name="QueryFMSearchResult" id="QueryFMSearchResult" action="../../eFM/jsp/QueryDTFileNotReturnedToMRDSearchResult.jsp" method="post">
<%
        Connection con   = ConnectionManager.getConnection(request);
        java.sql.Statement stmt   = null;
	    java.sql.Statement stmt1  = null;
		java.sql.Statement stmt2  = null;
        ResultSet rset   = null ;
		ResultSet rset1  = null ;
		ResultSet rset2  = null ;	
		
		String req_start		 = "", req_end = "";
 
		String from				= request.getParameter("from");
		String to				= request.getParameter("to");
        String queryCriteria    = request.getParameter("criteria")    ;
        String flag             = request.getParameter("flag")        ;
        String facility_id      = request.getParameter("facility_id")     ;
        String out_facility_id	= request.getParameter("out_facility_id");
		String out_criteria		= request.getParameter("out_criteria");
		String fs_locn_id		= request.getParameter("fs_locn_id");
		
		String discharge_date_time = "";

		String sql              = "";  
        String classValue       ="";
        String from_search      = request.getParameter("from_search");
		StringBuffer sqlCriteria	= null;
		sqlCriteria					= new StringBuffer();

		if(out_facility_id==null || out_facility_id.equals("null")) out_facility_id="";
		if(out_criteria==null || out_criteria.equals("null")) out_criteria="";
		if(queryCriteria==null || queryCriteria.equals("null")) queryCriteria="";
		if(fs_locn_id==null || fs_locn_id.equals("null")) fs_locn_id="";
		if(facility_id==null || facility_id.equals("null")) facility_id="";
		
	//	int    nextRecord       =         (request.getParameter("nextRecord")==null)? 0:Integer.parseInt(request.getParameter("nextRecord"));
        
        //int    previousRecord   =        (request.getParameter("previousRecord")==null)? 0 :             Integer.parseInt(request.getParameter("previousRecord"));
        
        int counter             = 0;
        int fromRecordNumber    = 0;
        int toRecordNumber      = 0;
        int noOfRecords         = 0;  
		
		int maxRecord	= 0;
	    int start		= 0;
		int end			= 0;
//	    int i			= 1;
		
		if (from == null){ start = 0; } else { start = Integer.parseInt(from); }
	    if (to == null){ end = 5; } else { end = Integer.parseInt(to); }

		req_start  = (request.getParameter("start") == null) ? "0" : request.getParameter("start");
		req_end    = (request.getParameter("end") == null)   ? "0" : request.getParameter("end");        
	
        

        if (from_search==null)from_search="";
		try
		{
	         if (from_search.equals("Y"))
		     {
				if (!out_facility_id.equals(""))
					sqlCriteria.append(" AND  a.curr_facility_id='"+out_facility_id+"' ");
				if (!out_criteria.equals(""))
					sqlCriteria.append( " AND  a.curr_fs_locn_code='"+out_criteria+"' ");
				if (!queryCriteria.equals(""))
					sqlCriteria.append(" AND  a.mr_pat_fs_locn_code='"+queryCriteria+"' ");
				if (!fs_locn_id.equals(""))
					sqlCriteria.append(" AND  a.curr_fs_locn_identity='"+fs_locn_id+"' ");	
			}
			else
			{
				if (!queryCriteria.equals(""))            
					sqlCriteria.append(" AND  a.mr_pat_fs_locn_code='" + queryCriteria + "' ");
			}
			//The following query is the main one to get the records.
			sql = "SELECT a.file_no,a.file_type_desc,a.volume_no,get_patient_line(a.patient_id,'"+localeName+"') patient_line,a.curr_fs_locn_code,a.curr_fs_locn_short_desc,decode(a.curr_fs_locn_identity,	'D','Department','T','Practitioner','C','Clinic','N','Nursingunit','X','External','E','Procedure Unit','Y','Daycare Unit')		   curr_fs_locn_identity,DECODE(a.curr_file_status,'R','Returned','I','Inside','O','Outside',	'L','Lost','T','InTransit','A','Archived','E','Other Facility')curr_file_status, TO_CHAR(a.iss_date_time,'dd/mm/rrrr hh24:mi') iss_date_time, TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') return_date_time,(CASE WHEN sysdate > a.return_date_time THEN 'Y' ELSE 'N' END) time_bar,(CASE WHEN a.facility_id<>a.curr_facility_id THEN '(' || a.curr_facility_name ||')' ELSE '&nbsp;' END )curr_facility_name,a.return_criteria,a.no_of_dh_to_return_ip,a.no_of_dh_to_return_op,a.duration_type,a.doc_folder_id, a.doc_folder_name,a.doc_type_name, b.patient_id, b.from_period, b.to_period, b.patient_period_specific,(CASE WHEN b.patient_period_specific='D' THEN ', ' || TO_CHAR(b.from_period,'dd/mm/yyyy ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/yyyy ') ELSE ', ' || get_patient_line(b.patient_id) END)doc_type,TO_CHAR(a.nia_return_date,'dd/mm/rrrr hh24:mi') nia_return_date FROM fm_curr_locn_vw a,fm_doc_folder b WHERE a.curr_fs_locn_code<>a.mr_pat_fs_locn_code and a.facility_id='"+facility_id+"' AND a.doc_folder_id = b.doc_folder_id(+) AND a.facility_id = b.facility_id "+sqlCriteria+" ORDER BY a.curr_fs_locn_short_desc,a.file_no";
	
			stmt	= con.createStatement();
		    rset    = stmt.executeQuery(sql) ;
%>				
	 <TABLE cellpadding="0" cellspacing="0" align='right' width="100%" > 
				<TR>
					<TD >
				<% if(!(start <= 1)) { %>
					<A href='javascript:getNext(<%=(start-5)%>,<%=(end-5)%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
				<% } if(!((start+5) >= maxRecord)) { %>
					<A href='javascript:getNext(<%=(start+5)%>,<%=(end+5)%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
				<% } %>
						</TD>
					</TR>
				</TABLE>
		        <TABLE border="1" cellpadding="0" cellspacing="0" align='center' width="100%">
<%
		        String p_first_curr_fs_locn_code = "";				
				String bgcolor                   = "";
				String nia_bgcolor               = "";
				String return_criteria           ="";
				String no_of_dh_to_return_ip = "";
				String no_of_dh_to_return_op = "";
				String curr_fs_locn_identity = "";
				String duration_type		 = "";
				String sql2					 = "";

				String p_doc_folder_id	 = "";
				String p_doc_folder_name = "";
				String p_doc_type_name	 = "";
				String p_doc_type	     = "";

				int p_rec_cnt	= 0;
				int cnt			= 0; //To Display total No of Documents Groupwise - by Meghanath.
		
				while(rset.next())
				{
					return_criteria		  = rset.getString("return_criteria");
					no_of_dh_to_return_ip = rset.getString("no_of_dh_to_return_ip");
					no_of_dh_to_return_op = rset.getString("no_of_dh_to_return_op");
					curr_fs_locn_identity = rset.getString("curr_fs_locn_identity");
					duration_type  = rset.getString("duration_type");
					p_doc_folder_id  = rset.getString("doc_folder_id")==null?"&nbsp;":rset.getString("doc_folder_id");
					p_doc_folder_name  = rset.getString("doc_folder_name")==null?"&nbsp;":rset.getString("doc_folder_name");
					p_doc_type_name  = rset.getString("doc_type_name")==null?"&nbsp;":rset.getString("doc_type_name");
					p_doc_type  = rset.getString("doc_type")==null?"&nbsp;":rset.getString("doc_type");

					if(return_criteria == null || return_criteria.equals("null")) return_criteria="";
					if(no_of_dh_to_return_ip == null) no_of_dh_to_return_ip="0";
					if(no_of_dh_to_return_op == null) no_of_dh_to_return_op="0";
						if(curr_fs_locn_identity == null ) curr_fs_locn_identity="";
					
					if(duration_type ==null ) duration_type ="";
					int parameter_hours=0;	
					if(duration_type.equals("D"))
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}
			        if (counter==0)
					{
						p_first_curr_fs_locn_code = rset.getString("curr_fs_locn_code");
%>
						<TR> 
							<TD width="100%"  colspan='7' class='CAGROUPHEADING' ><B><%=rset.getString("curr_fs_locn_short_desc")+" ( " + rset.getString("curr_fs_locn_identity") +") "%></B></TD>
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
%>						<TR><TD colspan='7' class='<%=classValue%>'><FONT size=1><B>
							<fmt:message key="eFM.TotalNoofDocuments.label" bundle="${fm_labels}"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cnt%></B></FONT>
							</TD>
						</TR>
<%
						cnt = 0;
%>
						<TR>
							<TD width="100%"  colspan='7' class='CAGROUPHEADING' ><B><%=rset.getString("curr_fs_locn_short_desc")+" ( " + rset.getString("curr_fs_locn_identity") +") "%></B></TD>
						</TR>
<%
					}
					counter++ ;
					if(counter % 2 == 0)
			            classValue = "QRYODD";
					else
			            classValue = "QRYEVEN";
						
					String f_no = rset.getString("file_no");

					String sql1                 = "";		
					String no_hours             = "0";
					String nia_no_hours         = "0";
					String returnfile_date_time = "";
		
					sql2=" SELECT to_char(MAX(iss_date_time)+("+parameter_hours+"/24),'dd/mm/rrrr hh24:mi') returndate FROM fm_curr_locn WHERE file_no= '"+f_no+"'";
			
					stmt2	= con.createStatement();
				    rset2    = stmt2.executeQuery(sql2) ;
				
					while(rset2.next())
					{
						returnfile_date_time = rset2.getString("returndate");
						if(returnfile_date_time == null) returnfile_date_time="";
					}
					if(rset2 != null) rset2.close();
					if(stmt2 != null) stmt2.close();
					if(f_no == null) f_no="";
					if(return_criteria !=null && return_criteria.equals("D"))
					{
						sql1 ="SELECT (sysdate - max(discharge_date_time)) *24 diffinhours FROM pr_encounter WHERE facility_id = '"+facility_id+"' and discharge_date_time is not null AND patient_id in (select patient_id FROM fm_movement_log where facility_id = '"+facility_id+"' and file_no='"+f_no+"' AND SENT_DATE_TIME is not null)";
					}
					else
					{
					//	sql1="SELECT (sysdate-max(sent_date_time)) * 24 diffinhours  FROM fm_movement_log WHERE file_no='"+f_no+"'  AND sent_date_time is not null";
						sql1 = "SELECT (sysdate-max(RETURN_DATE_TIME)) diffinhours from fm_curr_locn where FILE_NO ='"+f_no+"'  AND facility_id = '"+facility_id+"' ";
					}
					stmt1	= con.createStatement();
				    rset1    = stmt1.executeQuery(sql1) ;
				
					while(rset1.next())
					{
						no_hours = rset1.getString("diffinhours");
						if(no_hours == null) no_hours="0.00";
						no_hours =  no_hours.substring(0,no_hours.indexOf("."));
					}
					if(rset1 != null) rset1.close();
					if(stmt1 != null) stmt1.close();

				//	if(Integer.parseInt(no_hours) <= parameter_hours)
					if(Integer.parseInt(no_hours) <= 0)
					{
						bgcolor="orange";		
					}
				//	else if(Integer.parseInt(no_hours) > parameter_hours)
					else if(Integer.parseInt(no_hours) > 0)
					{
						bgcolor = "red";		
					}

					if(return_criteria !=null && return_criteria.equals("D"))
					{
						sql2 ="SELECT (sysdate - max(nia_return_date)) *24 nia_diffinhours from fm_curr_locn where facility_id = '"+facility_id+"' and nia_return_date is not null and patient_id in (select patient_id from fm_movement_log WHERE facility_id = '"+facility_id+"' and file_no='"+f_no+"' and sent_date_time is not null)";
					}
					else
					{
						sql2="SELECT (sysdate-max(sent_date_time)) * 24 nia_diffinhours FROM fm_movement_log WHERE facility_id = '"+facility_id+"' and file_no='"+f_no+"'  AND sent_date_time is not null";
					}
					stmt1	 = con.createStatement();
				    rset1    = stmt1.executeQuery(sql2) ;
				
					while(rset1.next())
					{
						nia_no_hours = rset1.getString("nia_diffinhours");
						if(nia_no_hours == null) nia_no_hours="0.00";
						nia_no_hours =  nia_no_hours.substring(0,nia_no_hours.indexOf("."));
					}
					if(rset1 != null) rset1.close();
					if(stmt1 != null) stmt1.close();

					if(curr_fs_locn_identity.equals("Clinic"))
					{
						if(Integer.parseInt(nia_no_hours) <= parameter_hours)
						{
							nia_bgcolor="orange";		
						}
						else if(Integer.parseInt(nia_no_hours) > parameter_hours)
						{
							nia_bgcolor="RED";		
						}	
					}
					else if(curr_fs_locn_identity.equals("N"))
					{
						if(Integer.parseInt(nia_no_hours) < parameter_hours)
						{
							nia_bgcolor="orange";		
						}
						else if(Integer.parseInt(nia_no_hours) > parameter_hours)
						{
							nia_bgcolor="RED";		
						}
					}
					String mysql1 ="SELECT to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time FROM pr_encounter WHERE facility_id = '"+facility_id+"' and  DISCHARGE_DATE_TIME is not null AND patient_id in (select patient_id FROM fm_movement_log WHERE facility_id = '"+facility_id+"' and FILE_NO='"+f_no+"' AND sent_date_time is not null)";
					stmt1	= con.createStatement();
					rset1    = stmt1.executeQuery(mysql1) ;
					discharge_date_time = "&nbsp;";
					if(rset1.next())
					{
						discharge_date_time = rset1.getString("discharge_date_time");
						if(discharge_date_time == null || discharge_date_time.equals("null")) 
							discharge_date_time = "&nbsp";
					}
					if(rset1 != null) rset1.close();
					if(stmt1 != null) stmt1.close();
%>
				    <TR>
				       <TD width="38%" class='<%=classValue%>' ><FONT size=1><B><%=p_doc_folder_id%></B><BR>&nbsp;<%=p_doc_folder_name%>&nbsp;<%=p_doc_type%></TD>
						<td  width="12%" class='<%=classValue%>' wrap><CENTER><FONT size=1><%=p_doc_type_name%></CENTER>
						</TD>
						<TD width="10%" class='<%=classValue%>'><FONT size=1>
          					<%=(rset.getString("curr_file_status")==null)?"&nbsp":rset.getString("curr_file_status")+"<br>"+rset.getString("curr_facility_name")+""%></TD>
				        <TD width="10%" class='<%=classValue%>'><font size=1>
							<%=(rset.getString("iss_date_time")==null)?"&nbsp":rset.getString("iss_date_time")%></TD>
<%
							if(rset.getString("return_date_time") == null || rset.getString("return_date_time").equals(""))
								bgcolor="";
%>	
				        <TD width="10%" class='<%=classValue%>' style='background-color:<%=bgcolor%>' ><FONT size=1>
					       <%=(rset.getString("return_date_time")==null)?"&nbsp":rset.getString("return_date_time")%></FONT>
						</TD>
<%
						if(rset.getString("nia_return_date") == null || rset.getString("nia_return_date").equals(""))
							nia_bgcolor="";
%>
						<TD width="10%" class='<%=classValue%>' style='background-color:<%=nia_bgcolor%>'><font size=1>
					     <%=(rset.getString("nia_return_date")==null)?"&nbsp":rset.getString("nia_return_date")%></FONT>
						</TD>
						<TD width="10%" class='<%=classValue%>'><FONT size=1>
							<%=discharge_date_time%>
						 </TD>  
					</TR>
<%
	                p_first_curr_fs_locn_code = rset.getString("curr_fs_locn_code");
   			       	p_rec_cnt++;
					if(p_first_curr_fs_locn_code.equals(rset.getString("curr_fs_locn_code")))
					{
						cnt++;
					}
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
					<TR><TD  colspan='7' class='<%=classValue%>'><FONT size=1><B>
							<fmt:message key="eFM.TotalNoofDocuments.label" bundle="${fm_labels}"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cnt%></B></FONT>
							</TD>
						</TR>
<%				
				}
%>
				<SCRIPT>
					var p_rec_cnt = '<%=p_rec_cnt%>';
					var p_criteria = '<%=queryCriteria%>';
					if (p_criteria=='all')
					{						
						var str = getMessage('CAN_NOT_BE_BLANK','Common');
						str = str.replace('$','Document Storage Location ')
						alert(str);
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
		if(rset  != null) rset.close(); 
		if(rset1 != null) rset1.close();
		if(rset2 != null) rset2.close();
		if(stmt  != null) stmt.close();
		if(stmt1 != null) stmt1.close();
		if(stmt2 != null) stmt2.close();
			}
		catch(Exception e)
		{

			out.println("Exception while fetching connection :" + e ) ;

		}
		finally
		{
		   
		  	ConnectionManager.returnConnection(con, request); 
	   }
%>
	<SCRIPT>
		parent.frames[1].document.forms[0].search.disabled=false;
	</SCRIPT>
	<INPUT type='hidden' name='previousRecord' id='previousRecord' value='<%=fromRecordNumber%>'>
	<INPUT type='hidden' name='nextRecord' id='nextRecord' value='<%=toRecordNumber%>'>   
	<INPUT type='hidden' name='flag' id='flag' value='<%=flag%>'>
	<INPUT type='hidden' name='criteria' id='criteria' value='<%=queryCriteria%>'>  
	<INPUT type='hidden' name='noOfRecords' id='noOfRecords' value='<%=noOfRecords%>'>     
	<INPUT type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'> 
	<INPUT type='hidden' name='fs_locn_id' id='fs_locn_id' value='<%=fs_locn_id%>'>
	<INPUT type='hidden' name='from_search' id='from_search' value='<%=from_search%>'>
	<INPUT type='hidden' name='out_criteria' id='out_criteria' value='<%=out_criteria%>'>
 </FORM>
</BODY>
</HTML>

