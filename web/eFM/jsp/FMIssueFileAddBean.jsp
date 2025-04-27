<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.io.*, java.text.*,webbeans.eCommon.*,eFM.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<jsp:useBean id="FMIssueFileAddBean" scope="session" class="eFM.FMIssueFileAddBean"/>
<jsp:useBean id="FMIssueFilesCart" scope="session" class="webbeans.eFM.FMFilesIssueCart"/>
<html>

<head>
	<% 
	 request.setCharacterEncoding("UTF-8");
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 

<%
	
	Connection con			 = null;	
	PreparedStatement pstmt	 = null;
	ResultSet rs			 = null;
	try
	{
	con = ConnectionManager.getConnection(request);
	
    String login_facility_id	= (String) session.getValue("facility_id");
  String currfacility=(String) session.getValue("facility_id");
  String userSecurity		= checkForNull( request.getParameter("userSecurity"));
	String resLocnIdentities	= checkForNull( request.getParameter("resLocnIdentities"));
	String strLocn				= checkForNull( request.getParameter("strLocn"));
	String file_type_yn			= checkForNull( request.getParameter("file_type_yn"));
	String s_file_type			= checkForNull( request.getParameter("s_file_type"));
	String access_all  = checkForNull( request.getParameter("access_all"),"access_all");
	String file_no_concat=checkForNull( request.getParameter("file_no_concat"));
	String volume_no_concat=checkForNull( request.getParameter("volume_no_concat"));
	String NoOfDays			= request.getParameter("NoOfdays");
	if(NoOfDays==null) NoOfDays="0";
	String s_file_no				= checkForNull(request.getParameter("s_file_no"));
	String s_fs_locn_identity	= checkForNull(request.getParameter("s_fs_locn_identity"));
	String s_fs_locn_code		= checkForNull(request.getParameter("s_fs_locn_code"));
	String s_fs_narration		= checkForNull(request.getParameter("s_fs_narration"));
	String s_request_date		= checkForNull(request.getParameter("s_request_date"));
	String s_request_by_id	= checkForNull(request.getParameter("s_request_by_id"));
   String s_volume_no		=checkForNull( request.getParameter("s_volume_no"));
	s_file_type		=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
	s_volume_no	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;
	 /*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
	String issue_file_refresh_interval	= (request.getParameter("issue_file_refresh_interval")=="" || request.getParameter("issue_file_refresh_interval")==null)?"":request.getParameter("issue_file_refresh_interval");
	String isRefreshIntervalAvailable	= checkForNull(request.getParameter("isRefreshIntervalAvailable"),"false");
	String isAutoPopulateAvailable		= checkForNull(request.getParameter("isAutoPopulateAvailable"),"false");
	String ChkIncludePreviousDayRequest	= (request.getParameter("ChkIncludePreviousDayRequest")=="" || request.getParameter("ChkIncludePreviousDayRequest")==null)?"N":request.getParameter("ChkIncludePreviousDayRequest");
	/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
	 
	 if(file_no_concat==null) file_no_concat="";
	if(volume_no_concat==null) volume_no_concat="";
			boolean file_exist = false;
			boolean file_found = false;
  
				String From = "";
			
	      
			StringBuffer SelectSqlBuffer = null;
	       SelectSqlBuffer				 = new StringBuffer();
			
			SelectSqlBuffer.append("SELECT " );
					SelectSqlBuffer.append("  k.national_id_no");
					SelectSqlBuffer.append("  ,k.alt_id1_no");					
					SelectSqlBuffer.append("  ,a.File_No " );
					//SelectSqlBuffer.append("  , d.Curr_File_Status " );
					SelectSqlBuffer.append("  , d.Curr_File_Status File_Status " );
					SelectSqlBuffer.append("  , d.Curr_fs_Locn_Code " );
					SelectSqlBuffer.append("  , b.Short_desc Curr_fs_Locn_desc " );
					//SelectSqlBuffer.append("  , a.req_To_fs_Locn_Code" );
					SelectSqlBuffer.append("  , d.Perm_fs_Locn_Code" );
					SelectSqlBuffer.append("  , Nvl(b.mr_Locn_yn,'N') Curr_mr_Locn_yn " );
					SelectSqlBuffer.append("  , a.Patient_Id " );
					SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne " );
						SelectSqlBuffer.append("  , d.Remarks " );
					SelectSqlBuffer.append("  , Ltrim(Rtrim(a.Remarks)) req_Remarks " );
					SelectSqlBuffer.append("  , TO_CHAR(d.Iss_Date_Time,'DD/MM/YYYY HH:MI') Iss_Date_Time " );
					SelectSqlBuffer.append("  , a.Volume_No " );
					SelectSqlBuffer.append("  , a.File_Type_Code" );
					SelectSqlBuffer.append("  , mr_get_desc.mr_file_type(a.REQ_TO_FACILITY_ID, a.file_type_code, '"+localeName+"', 2) File_Type" );
					SelectSqlBuffer.append("  , TO_CHAR(a.File_Required_On,'DD/MM/YYYY HH24:MI') req_On " ); //this line modified for this incident [40681]
					SelectSqlBuffer.append("  , TO_CHAR(a.added_date,'DD/MM/YYYY HH24:MI') requested_On " ); //this line modified for this incident [40681]
					SelectSqlBuffer.append("  , a.req_No req_No " );
					SelectSqlBuffer.append("  , c.req_User_Id req_By " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.req_User_Id IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    (sm_get_desc.sm_appl_user(c.req_User_Id, '"+localeName+"', 1)) " );
					SelectSqlBuffer.append("  END) req_By_Name " );
					SelectSqlBuffer.append("  , c.req_Facility_Id " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.req_Facility_Id IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    (sm_get_desc.sm_facility_param(c.req_Facility_Id, '"+localeName+"', 1)) " );
					SelectSqlBuffer.append("  END) req_Facility_Name " );
					SelectSqlBuffer.append("  , c.req_fs_Locn_Code " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.req_fs_Locn_Code IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    (fm_get_desc.fm_storage_locn(c.REQ_FACILITY_ID, c.req_fs_Locn_Code, '"+localeName+"', 2)) " );
					SelectSqlBuffer.append("  END) req_fs_Locn_desc " );
					SelectSqlBuffer.append("  , c.Narration_Code " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.Narration_Code IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    (fm_get_desc.fm_narration(c.Narration_Code, '"+localeName+"', 2)) " );
					SelectSqlBuffer.append("  END) Narration_desc " );
					SelectSqlBuffer.append("  , b.Locn_Identity Locn_Identity" );
					SelectSqlBuffer.append("  , f.Locn_Identity Req_fs_locn_identity");
					SelectSqlBuffer.append("  , c.Requesting_From " );
					SelectSqlBuffer.append("  , (" );
					SelectSqlBuffer.append("  CASE " );
					SelectSqlBuffer.append("  WHEN c.Requesting_From IS" );
					SelectSqlBuffer.append("    NOT NULL " );
					SelectSqlBuffer.append("  THEN" );
					SelectSqlBuffer.append("    DECODE(f.Locn_Identity, 'N', ip_get_desc.ip_nursing_unit(c.req_Facility_Id, c.RequestIng_From, '"+localeName+"', 1), 'T', am_get_desc.am_practitioner(c.RequestIng_From, '"+localeName+"', 1), op_get_desc.op_clinic(c.req_Facility_Id, c.RequestIng_From, '"+localeName+"', 1)) " );
					SelectSqlBuffer.append("  END) Requesting_from_desc " );
					SelectSqlBuffer.append("  , (CASE WHEN (select count(*) from pr_encounter where Facility_Id = '"+login_facility_id+"' and patient_id=a.patient_id and (VISIT_STATUS < '07' or adt_status < '08') and mlc_yn='Y') > 0 THEN 'Y' ELSE 'N' END) mlc_yn,(SELECT am_get_desc.am_practitioner (attend_practitioner_id,'"+localeName+"',1) FROM pr_encounter WHERE encounter_id = a.encounter_id AND facility_id = c.req_facility_id) req_pract " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  fm_req_dtl a " );
					SelectSqlBuffer.append("  , fm_req_hdr c " );
					SelectSqlBuffer.append("  , fm_Curr_Locn d " );
					SelectSqlBuffer.append("  , fm_Storage_Locn_lang_vw b " );
					SelectSqlBuffer.append("  , fm_Storage_Locn f " );					
					SelectSqlBuffer.append("  , mp_patient k " );
					//SelectSqlBuffer.append("  WHERE a.req_To_fs_Locn_Code = '"+strLocn+"' " );
					SelectSqlBuffer.append("  WHERE d.Perm_fs_Locn_Code = '"+strLocn+"' " );
					if (!(s_fs_locn_identity.equals("null") || s_fs_locn_identity.equals("")))
			        SelectSqlBuffer.append(" AND f.LOCN_IDENTITY = '"+s_fs_locn_identity+"' ");
					SelectSqlBuffer.append(" AND a.req_No = c.req_No " );
					SelectSqlBuffer.append("AND a.patient_id = k.patient_id" );
					SelectSqlBuffer.append("  AND a.req_To_Facility_Id = '"+login_facility_id+"' " );
					//SelectSqlBuffer.append("  AND a.req_To_fs_Locn_Code = '"+strLocn+"' " );
					SelectSqlBuffer.append("  AND a.Iss_yn = 'N' " );
					SelectSqlBuffer.append("  AND Nvl(a.Cancel_yn,'N') = 'N' " );
					SelectSqlBuffer.append("  AND  A.REQ_NO LIKE a.req_no " );
					SelectSqlBuffer.append("  AND a.file_no LIKE '%%' " );
					SelectSqlBuffer.append("  AND a.volume_no LIKE '%%' " );
					SelectSqlBuffer.append("  AND a.req_to_facility_id = d.facility_id(+)");
					SelectSqlBuffer.append("  AND a.File_No = d.File_No(+) " );
					SelectSqlBuffer.append("  AND a.Volume_No = d.Volume_No(+) " );
					SelectSqlBuffer.append("  AND c.req_fs_Locn_Code != d.Curr_fs_Locn_Code " );
					SelectSqlBuffer.append("  AND d.Curr_Facility_Id = b.Facility_Id " );
					SelectSqlBuffer.append("  AND d.Curr_fs_Locn_Code = b.fs_Locn_Code " );
					SelectSqlBuffer.append("  AND c.req_Facility_Id = f.Facility_Id " );
					SelectSqlBuffer.append("  AND c.req_fs_Locn_Code = f.fs_Locn_Code " );
					SelectSqlBuffer.append("  AND b.language_id = '"+localeName+"' " );
				
				
		if (!(s_file_no.equals("null") || s_file_no.equals("")))
			SelectSqlBuffer.append(" AND A.FILE_NO = '"+s_file_no+"' ");
    	if ((!s_volume_no.equals("")) && (!s_volume_no.equals("null")))
		 SelectSqlBuffer.append(" AND A.VOLUME_NO = "+s_volume_no+" ");
     	   if (!(s_fs_locn_code.equals("null") || s_fs_locn_code.equals("")))
		SelectSqlBuffer.append(" AND C.REQ_FS_LOCN_CODE = '"+s_fs_locn_code+"' ");	
			if (!(s_request_by_id.equals("null") || s_request_by_id.equals("")))
			SelectSqlBuffer.append(" AND C.REQ_USER_ID = '"+s_request_by_id+"' ");

		if (!(s_fs_narration.equals("null") || s_fs_narration.equals("")))
			SelectSqlBuffer.append(" AND C.NARRATION_CODE = '"+s_fs_narration+"' ");

	//	if (!(s_fs_locn_identity.equals("null") || s_fs_locn_identity.equals("")))
		//	SelectSqlBuffer.append(" AND f.LOCN_IDENTITY = '"+s_fs_locn_identity+"' ");
			s_request_date=DateUtils.convertDate(s_request_date,"DMY",localeName,"en");

		if (!(s_request_date.equals("null") || s_request_date.equals(""))){
			if(isAutoPopulateAvailable.equals("true") && ChkIncludePreviousDayRequest.equals("Y")){
				SelectSqlBuffer.append(" AND TRUNC (a.added_date) between TO_DATE ('"+s_request_date+"', 'dd/mm/yyyy') - 1  and TO_DATE ('"+s_request_date+"', 'dd/mm/yyyy')");
				
			
			}else{
				SelectSqlBuffer.append(" AND TO_DATE(TO_CHAR(TRUNC(A.ADDED_DATE),'dd/mm/yyyy'),'dd/mm/yyyy') = TO_DATE('"+s_request_date+"','dd/mm/yyyy') ");
			}
		}
			//SelectSqlBuffer.append(" order by A.FILE_NO ");	
			
			
				pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		   rs	  = pstmt.executeQuery();
			int cnt=0;	
					while(rs != null && rs.next())		
				{
						 String FileNoValue = rs.getString("file_no");
						if(FileNoValue == null || FileNoValue.equals("null")) FileNoValue = "";
			            String      volume_no	=	checkForNull( rs.getString("volume_no"));
			         	String   file_type_code	=	checkForNull( rs.getString("File_Type_Code"));
			            String   file_type	=	checkForNull( rs.getString("file_type"));
				   String    Req_by_name = checkForNull( rs.getString("REQ_BY_NAME"));
			       String   Req_by = checkForNull( rs.getString("REQ_BY"));
			       String    Req_no = checkForNull( rs.getString("REQ_NO"));
		         String      patient_id = checkForNull(rs.getString("PATIENT_ID"));
              		String   mlc_yn = rs.getString("mlc_yn") == null?"N":rs.getString("mlc_yn");		
					String requesting_from_desc = checkForNull(rs.getString("REQUESTING_FROM_DESC"));//added for MMS-QH-CRF-0146.1 [IN:045787]
					String req_pract = checkForNull(rs.getString("REQ_PRACT"));//added for MMS-QH-CRF-0146.1 [IN:045787]
					String 	ReqOn				= checkForNull(rs.getString("REQ_ON"));
					String 	RequestedOn		= checkForNull(rs.getString("requested_On"));
					String iss_date_time=rs.getString("ISS_DATE_TIME");
					 iss_date_time=DateUtils.convertDate(iss_date_time,"DMYHM","en",localeName);
					String 	Reqfacilityid			= checkForNull(rs.getString("REQ_FACILITY_ID"));
					String 	Reqfacilityname	= checkForNull( rs.getString("REQ_FACILITY_NAME"));
					String 	Reqlocncode		= checkForNull( rs.getString("REQ_FS_LOCN_CODE"));
					String 	Reqlocndesc		= checkForNull( rs.getString("REQ_FS_LOCN_DESC"));
					String 	Reqlocnidentity	= checkForNull( rs.getString("Req_fs_locn_identity"));

      				String 	Narrationcode		= checkForNull( rs.getString("NARRATION_CODE"));
				    String 	Narrationdesc		= checkForNull( rs.getString("NARRATION_DESC"));
					String 	Reqlocnid			= checkForNull( rs.getString("REQUESTING_FROM"));
					String 	Reqlocnismrlocn = checkForNull( rs.getString("CURR_MR_LOCN_YN"));
              		String remarks  = rs.getString("REMARKS");	
					if(remarks==null) remarks="";
						String cuurIden = checkForNull( rs.getString("LOCN_IDENTITY"));
						if(cuurIden == null || cuurIden.equals("null")){
						cuurIden="";}
						String currStatus = checkForNull( rs.getString("File_Status"));
						if(currStatus == null || currStatus.equals("null")){
						currStatus="";}					
						String currlocn = checkForNull( rs.getString("CURR_FS_LOCN_CODE"));
						if(currlocn == null || currlocn.equals("null")){
						currlocn="";}
						 String currdesc=rs.getString("CURR_FS_LOCN_DESC");
						if(currdesc==null) currdesc="";
						String permLocn = checkForNull( rs.getString("Perm_fs_Locn_Code"));
						if(permLocn ==null || permLocn.equals("null")){
						permLocn="";}
					    String 	req_remarks		= checkForNull( rs.getString("REQ_REMARKS"));
						if(req_remarks ==null) req_remarks="";
					String	nat_id= rs.getString("national_id_no")==null?"":rs.getString("national_id_no");
               				String tempstr = rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
						StringTokenizer st = new StringTokenizer(tempstr, ",");
						st.nextToken();
						st.nextToken();
						st.nextToken();
			String pline=rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
			file_exist = FMIssueFileAddBean.FileNoExist(Req_no,FileNoValue,volume_no);
			file_found = FMIssueFileAddBean.CurrFacilityFileNoExist(currfacility,FileNoValue, volume_no);
					if((!file_exist))
					{
					if(login_facility_id.equals(Reqfacilityid)) From = "S";
					else From = "D";
					
					webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
						fissuebean.setRequest_From(From);
						fissuebean.setFile_No(FileNoValue);
						fissuebean.setFile_Type(file_type_code);
						fissuebean.setVolume_No(volume_no);
						fissuebean.setPatient_Id(patient_id);
						fissuebean.setPatient_Line(pline);
						fissuebean.setRec_Locn_Code(Reqlocncode);
						fissuebean.setIndex_Value(Reqlocndesc);
						fissuebean.setRec_Locn_Identity(Reqlocnidentity);
						fissuebean.setRec_Name(Req_by);
						fissuebean.setRec_Name_Desc(Req_by_name);
						fissuebean.setNarration_Code(Narrationcode);
						fissuebean.setMovement_Narration(Narrationdesc);
						fissuebean.setRemarks(remarks);
						fissuebean.setReq_Facility_Id(Reqfacilityid);
						fissuebean.setReq_Facility_Name(Reqfacilityname);
						fissuebean.setReq_No(Req_no);
						fissuebean.setIss_Locn_Code(currlocn);   
						fissuebean.setIss_Locn_Desc(currdesc);
						fissuebean.setIss_Locn_Identity(cuurIden);
						fissuebean.setIss_MR_Location(iss_date_time); 	
						fissuebean.setRec_MR_Location(Reqlocnismrlocn);
						fissuebean.setRet_Date_Time(ReqOn);				
						fissuebean.setRequest_Date_Time(RequestedOn);
						fissuebean.setCurr_Facility_Id(currfacility);
						fissuebean.setSrc_Facility_Id(login_facility_id);
						fissuebean.setSrc_User_Id(permLocn);
						fissuebean.setReq_Remarks(req_remarks);
						fissuebean.setMLC_Check(mlc_yn);
						fissuebean.setFile_Typedesc(file_type);
						fissuebean.setRequesting_From(Reqlocnid);
                        fissuebean.setRequesting_From_Desc(requesting_from_desc);
						fissuebean.setReq_Pract(req_pract);
						fissuebean.setThird_Party_Name(currStatus);
						fissuebean.setCarried_By(nat_id);
									
						FMIssueFileAddBean.addIssuestoCart(fissuebean);
						
						}
            cnt++;
			  }					
				
              ArrayList ArrFileCart	= (ArrayList) FMIssueFileAddBean.getPresCart();
	          int countRec	= ArrFileCart.size();
    if(cnt>0)
		{%>
	<iframe name='OutstanListDetail' id='OutstanListDetail' src='../../eFM/jsp/FMIssueFileOutstandingDetail.jsp?userSecurity=<%=userSecurity%>&access_all=<%=access_all%>&resLocnIdentities=<%=resLocnIdentities%>&file_type_yn=<%=file_type_yn%>&strLocn=<%=strLocn%>&s_file_no=<%=s_file_no%>&s_fs_locn_code=<%=s_fs_locn_code%>&s_fs_narration=<%=s_fs_narration%>&s_request_date=<%=s_request_date%>&s_request_by_id=<%=s_request_by_id%>&file_no_concat=<%=file_no_concat%>&s_fs_locn_identity=<%=s_fs_locn_identity%>&volume_no_concat=<%=volume_no_concat%>&s_file_type=<%=s_file_type%>&s_volume_no=<%=s_volume_no%>&issue_file_refresh_interval=<%=issue_file_refresh_interval%>&isRefreshIntervalAvailable=<%=isRefreshIntervalAvailable%>&isAutoPopulateAvailable=<%=isAutoPopulateAvailable%>&ChkIncludePreviousDayRequest=<%=ChkIncludePreviousDayRequest%>' scrolling=auto frameborder=0 noresize style='height:83vh	;width:100vw'></iframe>
	<iframe name='OutstanListButton' id='OutstanListButton' src='../../eFM/jsp/FMIssueFileOutstandingButton.jsp?resLocnIdentities=<%=resLocnIdentities%>'  style='border-style: solid;	border-color:black; border-width:1; height:10vh;width:100vw' scrolling=no frameborder=0 noresize ></iframe>
			

		<%} if(cnt==0 )
			{
			%>
			<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));						
			
			</script>
			<!-- issue_file_refresh_interval,isRefreshIntervalAvailable,ChkIncludePreviousDayRequest and isAutoPopulateAvailable Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014 -->
			<frameset rows='83%,*'>
			<frame name='OutstanListDetail' id='OutstanListDetail' src='../../eFM/jsp/FMIssueFileOutstandingDetail.jsp?userSecurity=<%=userSecurity%>&access_all=<%=access_all%>&resLocnIdentities=<%=resLocnIdentities%>&file_type_yn=<%=file_type_yn%>&strLocn=<%=strLocn%>&s_file_no=<%=s_file_no%>&s_fs_locn_code=<%=s_fs_locn_code%>&s_fs_narration=<%=s_fs_narration%>&s_request_date=<%=s_request_date%>&s_request_by_id=<%=s_request_by_id%>&file_no_concat=<%=file_no_concat%>&s_fs_locn_identity=<%=s_fs_locn_identity%>&volume_no_concat=<%=volume_no_concat%>&s_file_type=<%=s_file_type%>&s_volume_no=<%=s_volume_no%>&issue_file_refresh_interval=<%=issue_file_refresh_interval%>&isRefreshIntervalAvailable=<%=isRefreshIntervalAvailable%>&isAutoPopulateAvailable=<%=isAutoPopulateAvailable%>&ChkIncludePreviousDayRequest=<%=ChkIncludePreviousDayRequest%>' scrolling=auto frameborder=0 noresize>
		
			<%if(countRec>0) {%>
			<frame name='OutstanListButton' id='OutstanListButton' src='../../eFM/jsp/FMIssueFileOutstandingButton.jsp?resLocnIdentities=<%=resLocnIdentities%>' style="border-style: solid; border-color:black; border-width:1 ; height: 10vh; width:100vw;" scrolling=no frameborder=0 noresize>
		<%}else{%>
			<frame name='OutstanListButton' id='OutstanListButton' src='../../eCommon/html/blank.html'   scrolling=no frameborder=0 noresize style="height: 10vh; width:100vw;">
		<%}%>
		</frameset>		
			<%
			} 
			
				%>
				<script>
			
				</script>
				<%
		  if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
				{
				SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
				}
			if(rs!=null)	rs.close();
			if(pstmt!=null) pstmt.close();
		session.putValue("FMIssueFilesBean",FMIssueFileAddBean);
	}catch(Exception e){
		e.printStackTrace();
	
	} finally {				
			ConnectionManager.returnConnection(con,request);
	}
	
	%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

