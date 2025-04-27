<!DOCTYPE html>
  <!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	\FM\File Lost-Archeived File status
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* , java.sql.Date"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/QueryFMLostSearch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="QueryFMSearchResult" id="QueryFMSearchResult" action="../../eFM/jsp/QueryFMLostSearchResult.jsp" method="post" 	>
 <%
		Connection con	= ConnectionManager.getConnection(request);
		Statement stmt	= null;
		ResultSet rset	= null;
		Statement stmt1 = null;
		ResultSet rs	= null;
		
	//	String params = request.getQueryString() ;
		
	//	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy") ;
	//	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;

		String queryCriteria	= request.getParameter("criteria")	  ;
		String from				= request.getParameter("from")  	  ;
		String to				= request.getParameter("to")	      ;
		String file_type_appl_yn	= request.getParameter("file_type_appl_yn")==null?"":request.getParameter("file_type_appl_yn");	
		String facilityid		= (String) session.getValue("facility_id");
		
		String flag				= request.getParameter("flag")	      ;
		int    nextRecord		= 
		(request.getParameter("nextRecord")==null)? 0:Integer.parseInt(request.getParameter("nextRecord"));
		int	   previousRecord	= 
		(request.getParameter("previousRecord")==null)? 0 :                           Integer.parseInt(request.getParameter("previousRecord"));
		
		int counter				 = 0  ;
		int fromRecordNumber	 = 0  ;
		int toRecordNumber  	 = 0  ;
		int noOfRecords			 = 0  ;  
		
		String sql				 = "" ;	
		String sql1				 = "";
		String classValue		 = "";
		String reportedDate      ="";//changed  @UAT-3
		String locale=(String)session.getAttribute("LOCALE");//changed  @UAT-3

		try
		{
 			if(from != null)
			{
				from = "'" + from + "'" ; 
			}   
			if(to != null)
			{
				to   = "'" + to + "'" ; 
			}  			

			//sql="SELECT a.file_no,a.file_type_desc,a.volume_no,get_patient_line(a.patient_id,'"+localeName+"')patientline,a.curr_fs_locn_desc,a.CURR_FS_LOCN_IDENTITY, a.PREV_FS_LOCN_DESC, to_char(a.MODIFIED_DATE,'dd/mm/yyyy hh24:mi') reportedDate,a.MODIFIED_BY_ID reportedById, substr(b.appl_user_name,1,60)appl_user_name FROM FM_CURR_LOCN_VW a, sm_appl_user b WHERE TRUNC(a.MODIFIED_DATE) BETWEEN NVL( TO_DATE(" +  from + ",'dd/MM/yyyy'), TO_DATE('01/01/1900','dd/MM/yyyy')) AND NVL( TO_DATE(" +  to   + ",'dd/MM/yyyy'),TO_DATE('31/12/5000','dd/MM/yyyy')) AND  a.curr_file_status='" + queryCriteria + "' and a.facility_id='"+facilityid+"' and a.modified_by_id=b.appl_user_id order by file_no";

			sql="SELECT  a.file_no  ,MR_GET_DESC.MR_FILE_TYPE(A.FACILITY_ID, A.FILE_TYPE_CODE,'"+localeName+"','2') file_type_desc  ,a.volume_no  ,get_patient_line(a.patient_id,'"+localeName+"')patientline  ,FM_GET_DESC.FM_STORAGE_LOCN(A.CURR_FACILITY_ID, A.CURR_FS_LOCN_CODE,'"+localeName+"','2') curr_fs_locn_desc  ,a.CURR_FS_LOCN_IDENTITY  ,FM_GET_DESC.FM_STORAGE_LOCN(A.PREV_FACILITY_ID, A.PREV_FS_LOCN_CODE,'"+localeName+"','2') PREV_FS_LOCN_DESC  ,TO_CHAR(a.MODIFIED_DATE,'dd/mm/yyyy hh24:mi') reportedDate  ,a.MODIFIED_BY_ID reportedById  ,SM_GET_DESC.SM_APPL_USER(a.modified_by_id,'"+localeName+"','1') appl_user_name  FROM  FM_CURR_LOCN a WHERE TRUNC(a.MODIFIED_DATE) BETWEEN NVL( TO_DATE(" + from + ",'dd/MM/yyyy'), TO_DATE('01/01/1900','dd/MM/yyyy'))   AND NVL( TO_DATE(" + to + ",'dd/MM/yyyy'),TO_DATE('31/12/5000','dd/MM/yyyy'))   AND a.curr_file_status='" + queryCriteria + "'   AND a.facility_id='"+facilityid+"'  ORDER BY  file_no" ;
			
			stmt			= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			stmt1			= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			rset		 	= stmt.executeQuery(sql) ;
 
			 while(rset.next())
			 noOfRecords = noOfRecords + 1;%>
<%
			  rset.beforeFirst(); 
%>
			<table align='right'>
			<tr>
				<td>
<%				 if("next".equals(flag.trim()))
			     {
					fromRecordNumber= nextRecord	   + 1;
					toRecordNumber	= fromRecordNumber + 4;//put x-1 in place of 4 where x RecTODisplay
					 if(nextRecord-1> 0)
					 {
%>
						<a href="javascript:getNext('previous')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/><a>
<%
					}
					if(nextRecord + 5 < noOfRecords)
					{	//put x in place of 5 where x is RecTODisplay
%>
						<a href="javascript:getNext('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/><a>
<%
					}
				}
				if("previous".equals(flag.trim()))
				{
					fromRecordNumber	= previousRecord   - 5;//put x in place of 5 where x is RecTODisplay
					toRecordNumber	= fromRecordNumber + 4;//put x-1 place of 1 where x is RecTODisplay
					if( previousRecord - 5  > 1)
					{						//put x in place of 5 where x is RecTODisplay
%>
	     				<a href="javascript:getNext('previous')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/><a>							
<%					}
					if (previousRecord <= noOfRecords )
					{
%>
	    				<a href="javascript:getNext('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/><a>
<%					}
				}
%>
			</td>
		</tr>
	</table>
	    <br><br>
		<table border="1" cellpadding="0" cellspacing="0" align='center' width="100%">
<%		
		if(queryCriteria.trim().equals("L"))
		{
%>
			<tr><td colspan='5' class='COLUMNHEADER' ><fmt:message key="eFM.LostFilesStatus.label" bundle="${fm_labels}"/></td></tr>
<%
		}
		else
		{
%>
		   	<tr><td colspan='5' class='COLUMNHEADER' ><fmt:message key="eFM.ArchiveFilesStatus.label" bundle="${fm_labels}"/></td></tr>
<%
		}
%> 
		<tr><td></td></tr>
		<tr>
	<%  if(file_type_appl_yn.equals("N")){%>
			<td  width="35%" class='COLUMNHEADER' ><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
			<td  width="15%" class='COLUMNHEADER'><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
	<%} else if(file_type_appl_yn.equals("Y")){%>
			<td  width="35%" class='COLUMNHEADER' ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
			<td  width="15%" class='COLUMNHEADER' nowrap><fmt:message key="eFM.FileTypeVolumeNo.label" bundle="${fm_labels}"/></td>
	<%}%>
			<td  width="18%" class='COLUMNHEADER' ><fmt:message key="eFM.PreviousFSLocation.label" bundle="${fm_labels}"/></td>
			<td  width="15%" class='COLUMNHEADER' ><fmt:message key="Common.ReportedDate.label" bundle="${common_labels}"/></td>
			<td  width="32%" class='COLUMNHEADER' ><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></td>
		</tr>
<%
		int p_count			= 0;
		String p_prev_locn	= "";
		String p_prev_identity="";
		int p_rec_cnt		= 0;
		
		while(rset.next())
		{
			counter++ ;

			sql1 = "select count(*) rec_cnt from fm_movement_log where facility_id='"+facilityid+"' and file_no='"+((rset.getString("file_no")==null)?"":rset.getString("file_no"))+ "' "; 

			rs = stmt1.executeQuery(sql1);
			while (rs.next())
			{
				p_count = rs.getInt("rec_cnt");
			}
			if(rs!=null)	rs.close();
			if (p_count > 0 )
			{			
			
			//	sql1="select DEST_FS_LOCN_CODE rec_fs_locn_code, DEST_FS_LOCN_DESC  rec_fs_locn_desc ,  decode(DEST_LOCN_IDENTITY,'D','Department','N','Nursing Unit','C','Clinic','X','Other Facility','T','Practitioner' , 'E','Procedure Unit','Y','Daycare Unit')rec_locn_identity ,DEST_FS_LOCN_DESC,SRC_FS_LOCN_DESC, decode(SRC_LOCN_IDENTITY,'D','Department','N','Nursing Unit','C','Clinic','X','Other Facility','T','Practitioner', 'E','Procedure Unit','Y','Daycare Unit') SRC_LOCN_IDENTITY1 from FM_MOVEMENT_LOG_VW where facility_id='"+facilityid+"' and file_no='"+rset.getString("file_no")+"'  and REC_DATE_TIME in (select max(rec_date_time) from FM_MOVEMENT_LOG_VW where facility_id='"+facilityid+"' and file_no='"+rset.getString("file_no")+"' ) order by REC_DATE_TIME";
				sql1=" SELECT  DEST_FS_LOCN_CODE rec_fs_locn_code  ,FM_GET_DESC.FM_STORAGE_LOCN(A.DEST_FACILITY_ID, A.DEST_FS_LOCN_CODE,'"+localeName+"','2') rec_fs_locn_desc   ,DEST_LOCN_IDENTITY rec_locn_identity   ,FM_GET_DESC.FM_STORAGE_LOCN(A.DEST_FACILITY_ID, A.DEST_FS_LOCN_CODE,'"+localeName+"','2') DEST_FS_LOCN_DESC   ,FM_GET_DESC.FM_STORAGE_LOCN(A.SRC_FACILITY_ID, A.SRC_FS_LOCN_CODE,'"+localeName+"','2') SRC_FS_LOCN_DESC   ,SRC_LOCN_IDENTITY SRC_LOCN_IDENTITY1  FROM  FM_MOVEMENT_LOG A WHERE facility_id='"+facilityid+"'   AND file_no='"+rset.getString("file_no")+"'   AND REC_DATE_TIME IN (SELECT max(rec_date_time) FROM FM_MOVEMENT_LOG WHERE facility_id='"+facilityid+"' AND file_no='"+rset.getString("file_no")+"')  ORDER BY  REC_DATE_TIME";
			}
			else
			{
				//sql1 = "select fs_locn_code rec_fs_locn_code,fs_locn_desc rec_fs_locn_desc,locn_identity_desc rec_locn_identity from fm_mr_pat_file_index_vw where file_no='"+rset.getString("file_no")+"' and facility_id='"+facilityid+"' ";
				sql1 = "SELECT  fs_locn_code rec_fs_locn_code  ,FM_GET_DESC.FM_STORAGE_LOCN(A.FACILITY_ID, A.FS_LOCN_CODE,'"+localeName+"','2') rec_fs_locn_desc   ,(SELECT LOCN_IDENTITY FROM FM_STORAGE_LOCN WHERE FACILITY_ID = A.FACILITY_id AND FS_LOCN_CODE = A.FS_LOCN_CODE) rec_locn_identity  FROM  mr_pat_file_index A WHERE file_no='"+rset.getString("file_no")+"'   AND facility_id='"+facilityid+"'";
			}
			rs = stmt1.executeQuery(sql1);
			rs.next();		
			
			 p_prev_locn			= (rs.getString("rec_fs_locn_desc")==null)?"":rs.getString("SRC_FS_LOCN_DESC");
			 p_prev_identity		= (rs.getString("rec_locn_identity")==null)?"":rs.getString("SRC_LOCN_IDENTITY1");
			if(!p_prev_locn.equals(""))
			{
				switch(p_prev_locn.charAt(0))
				{
					case 'D' : p_prev_locn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

					case 'C' : p_prev_locn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

					case 'N' : p_prev_locn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

					case 'T' : p_prev_locn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

					case 'X' : p_prev_locn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

					case 'E' : p_prev_locn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

					case 'Y' : p_prev_locn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
			
				}
			}

		if(!p_prev_identity.equals(""))
		{
			switch(p_prev_identity.charAt(0))
			{
				case 'D' : p_prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : p_prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : p_prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : p_prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : p_prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : p_prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : p_prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}





			 if(rs!=null)		rs.close();
			 if( counter % 2 == 0 )
		  		classValue = "QRYODD" ;
			else
		  		classValue = "QRYEVEN" ;
			if(counter >=fromRecordNumber && counter <= toRecordNumber)
			{
%>
			<tr>
			<td  width="39%" height="20" class='<%=classValue%>'><font size=1>
	<%  if(file_type_appl_yn.equals("N")){%>
			<%=(rset.getString("file_no")==null)?"":"<b>"+rset.getString("file_no")+"</b><br>&nbsp;&nbsp;"+rset.getString("patientline").substring(0,rset.getString("patientline").length()-6)%>
	<%} else if(file_type_appl_yn.equals("Y")){%>
				<%=rset.getString("patientline").substring(0,rset.getString("patientline").length()-6)%>
	<%}%>
			</td>
			<td  width="11%" height="20" class='<%=classValue%>'><font size=1> <!--CENTER tag removed by mano aganist ML-MMOH-SCF-0789-->
		<%if(file_type_appl_yn.equals("N")){%>
				<%=rset.getString("volume_no")%> <!--CENTER tag removed by mano aganist ML-MMOH-SCF-0789-->
		<% } else if(file_type_appl_yn.equals("Y")){%>
			<%=(rset.getString("file_type_desc")==null)?"&nbsp":""+(rset.getString("file_type_desc")+" / ")%><%=rset.getString("volume_no")%> <!--Removed center tag by mano against  ML-MMOH-SCF-0789-->
		<%}%>
			</td>
			<td  width="17%" height="20" class='<%=classValue%>' ><font size=1> <%=p_prev_locn%>&nbsp;( <%=p_prev_identity%> ) </td> <!--br tag removed by mano aganist ML-MMOH-SCF-789-->
			<td  width="13%" height="20" class='<%=classValue%>'><font size=1>
		<%
			reportedDate =(rset.getString("reportedDate")==null)?"":rset.getString("reportedDate");//changed  @UAT-3
			String reportedDate_display =DateUtils.convertDate(reportedDate,"DMYHM","en",locale);//changed  @UAT-3
		%>
			<%=reportedDate_display%></td><!--changed  @UAT-3 -->
			<td  width="28%" height="20" class='<%=classValue%>'><font size=1>
			<%=(rset.getString("appl_user_name")==null)?"":rset.getString("appl_user_name")%></td>
			</tr>		
						   
<%
	}
	 p_prev_locn="&nbsp;";
	 p_rec_cnt++;
 }
%>
<script>
	var p_rec_cnt = '<%=p_rec_cnt%>';
	if (parseInt(p_rec_cnt)==0)
	{
		parent.frames[2].location.href='../../eCommon/html/blank.html';
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
		parent.frames[1].document.forms[0].Search.disabled=false;
	}
</script>
</table>
<%
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
	if(rs!=null)	rs.close();
	if(stmt1!=null)	stmt1.close();
	}
	catch(Exception e)
	{
		 out.println("Exception while fetching connection :" + e );
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);
	}
%>
<script>
	parent.frames[1].document.forms[0].Search.disabled=false;
</script>
  <input type='hidden' name='previousRecord' id='previousRecord' value='<%=fromRecordNumber%>' >
  <input type='hidden' name='nextRecord' id='nextRecord' value='<%=toRecordNumber%>' >	 
  <input type='hidden' name='from' id='from' value=<%=from%> >
  <input type='hidden' name='to' id='to' value=<%=to%> >	 
  <input type='hidden' name='flag' id='flag' value='<%=flag%>' >
  <input type='hidden' name='criteria' id='criteria' value='<%=queryCriteria%>' >	 
  <input type='hidden' name='noOfRecords' id='noOfRecords' value='<%=noOfRecords%>' >
  <input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>' >
</form>
</body>
</html>

