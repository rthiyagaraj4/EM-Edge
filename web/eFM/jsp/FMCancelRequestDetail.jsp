<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMCancelRequestFiles.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String facility_id			= (String) session.getValue("facility_id");
		String FSLocation			= request.getParameter("FSLocation");
		String file_num				= request.getParameter("fileno");
		String file_type_code		= request.getParameter("file_type_code");
		String patient_id			= request.getParameter("patient_id");
		String volume_no			= request.getParameter("volume_no");
		String request_date			= request.getParameter("RecDate");
		String file_type_appl_yn	= request.getParameter("file_type_appl_yn");
		String p_stored_val   = request.getParameter("p_stored_val");
	   	
		String filetype=request.getParameter("filetype");;
		String filenum=request.getParameter("filenum");
		String volume_no1=request.getParameter("volume_no1");
		String patient_id1=request.getParameter("patient_id1");
		String file_faci=request.getParameter("file_faci");
		
		String filetypedesc			= "";
		String patientno_volume="";
		String pat_id="";
		String vol_no="";
		String pat_file_vol= request.getParameter("pat_file_vol");
		String pat_file_vol1="";
		String patfilevol="";
		String status="false";
		String str="";
		String str1="";
		String file_no_new="";
		String curr_file_status="";
		int P_count=0;
		int count=0;
		int count_tokens=0;
		if(FSLocation == null || FSLocation.equals("null"))
			FSLocation = "";
		if(patient_id == null || patient_id.equals("null"))
			patient_id = "";
		if(pat_file_vol == null || pat_file_vol.equals("null"))
			pat_file_vol = "";
		
		if(file_faci == null || file_faci.equals("null"))
			file_faci = "";
		
		if(file_faci.equals(""))
		{
		file_faci=facility_id;
		}
		
		if(request_date != null)
		{
		request_date=DateUtils.convertDate(request_date,"DMY",localeName,"en");
		}
		else
			request_date = "";
		if(file_num == null || file_num.equals("null")) 
			file_num = "";
		if(file_type_code == null || file_type_code.equals("null"))
			file_type_code = "";
			if(volume_no == null || volume_no.equals("null")) 
			volume_no = "";
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null"))
			file_type_appl_yn = "";

	      if(filetype == null || filetype.equals("null")) filetype = "";
		  if(volume_no1 == null || volume_no1.equals("null")) volume_no1 = "";
			if(patient_id1 == null || patient_id1.equals("null")) patient_id1= "";
			if(filenum == null || filenum.equals("null")) filenum = "";
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='CancelRequestDtl_form' id='CancelRequestDtl_form' action='../../servlet/eFM.FMCancelRequestServlet' method='post' target='messageFrame'>
<script>
	parent.frames[2].document.getElementById("hdr_tab0").style.visibility = 'Visible';
	parent.frames[2].document.getElementById("hdr_tab").style.visibility = 'Visible';
</script>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center' id="test">
<%
		Connection con			= ConnectionManager.getConnection(request);
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		
		String classValue		= "";		

		StringBuffer SelectSqlBuffer	= null;
		SelectSqlBuffer					= new StringBuffer();
		StringBuffer CriteriaSqlBuffer	= null;
		CriteriaSqlBuffer				= new StringBuffer();

		int i = 1, p_rec_cnt = 0;
		try 
		{
			
			if(!filetype.equals("") || !filenum.equals(""))
			{

           if(filetype.equals(""))
             {

     str="select curr_file_status ,file_no from fm_curr_locn where facility_id = '"+facility_id+"' and patient_id='"+patient_id1+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";
	//	str="select curr_file_status from fm_curr_locn where facility_id = '"+facility_id+"' and patient_id='"+patient_id1+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";
			 }
     if(filenum.equals(""))
     { 
      str="select curr_file_status,file_no from fm_curr_locn where facility_id = '"+facility_id+"' and patient_id='"+patient_id1+"' AND file_type_code='"+filetype+"' and volume_no='"+volume_no1+"' ";
     
	  
	  
	  }
			
			pstmt = con.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				
				curr_file_status			= rs.getString("curr_file_status");	
		     file_no_new			= rs.getString("file_no");	
			if(curr_file_status==null) curr_file_status="";
			if(file_no_new==null) file_no_new="";
			}
			
			}
			
		
	
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
			
		if(!file_no_new.equals(""))	
			{
			   str1="select * from FM_REQ_DTL A,FM_REQ_HDR B where A.REQ_NO = B.REQ_NO AND B.REQ_FS_LOCN_CODE ='"+FSLocation+"' AND B.REQ_FACILITY_ID ='"+facility_id+"' AND A.ISS_YN = 'N' AND A.CANCEL_YN='N' and A.patient_id='"+patient_id1+"'  and A.file_no='"+file_no_new+"' and A.volume_no='"+volume_no1+"' ";

	    	pstmt = con.prepareStatement(str1);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next())
			{
			count++;
			}
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
			}
		
			
			if(file_type_appl_yn.equals("N") && (!file_num.equals("")))
			{
			
			  /*	CriteriaSqlBuffer.append( " AND A.PATIENT_ID in ("+patient_id+") ");
				//CriteriaSqlBuffer.append( " AND A.FILE_NO in ("+file_num+") ");
				if(!(volume_no == null || volume_no.equals("")))
				{
					CriteriaSqlBuffer.append(" AND VOLUME_NO in ("+volume_no+") ");
				} */
			
		
			
			StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	      count_tokens=pat_volumeno.countTokens();
	       int P_cnt=0;
	     CriteriaSqlBuffer.append( "AND ( ");
		 while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	  StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	  while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	if(fileno1.hasMoreTokens())
	vol_no	=fileno1.nextToken();
	}
	// SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	 CriteriaSqlBuffer.append( " ( A.PATIENT_ID ='"+pat_id+"' ");
	// if (!vol_no.equals(""))
		//	{
		if(count_tokens >P_cnt){
   // SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
		CriteriaSqlBuffer.append(" AND A.VOLUME_NO ='"+vol_no+"' ) OR ");	
			} else{
              //   SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
		     	CriteriaSqlBuffer.append(" AND A.VOLUME_NO ='"+vol_no +"' )");	
			}
			
			//}
		
		
		P_count=P_cnt;
		}	
	//	CriteriaSqlBuffer.append( " ) ");
		CriteriaSqlBuffer.append( " ) AND A.FILE_NO in ("+file_num+") ");
		
		}
		else if(file_type_appl_yn.equals("Y") && !(file_type_code.equals("")))
			{
		StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	    count_tokens=pat_volumeno.countTokens();
	   int P_cnt=0;
	 CriteriaSqlBuffer.append( "AND ( ");
	  while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	if(fileno1.hasMoreTokens())
	vol_no	=fileno1.nextToken();
	}
	// SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	 CriteriaSqlBuffer.append( " ( A.PATIENT_ID ='"+pat_id+"' ");
	// if (!vol_no.equals(""))
		//	{
		if(count_tokens >P_cnt){
   // SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
		CriteriaSqlBuffer.append(" AND A.VOLUME_NO ='"+vol_no+"' ) OR ");	
			} else{
              //   SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
		     	CriteriaSqlBuffer.append(" AND A.VOLUME_NO ='"+vol_no +"' )");	
			}
			
			//}
		P_count=P_cnt;
		}	
				
		CriteriaSqlBuffer.append( ") AND A.FILE_TYPE_CODE in ("+file_type_code+") ");
			//	CriteriaSqlBuffer.append( " AND A.FILE_TYPE_CODE in ("+file_type_code+") ");
			/*	if(!(volume_no == null || volume_no.equals("")))
				{
					CriteriaSqlBuffer.append(" AND VOLUME_NO in ("+volume_no+") ");
				}
			CriteriaSqlBuffer.append( " AND A.FILE_TYPE_CODE in ("+file_type_code+") ");
			} */
			
			}
			if(file_num.equals("") && file_type_code.equals(""))
			{
				if(file_type_appl_yn.equals("N"))
				{
				//SelectSqlBuffer.append("SELECT A.REQ_NO,A.REMARKS,A.FILE_NO,A.FILE_TYPE_CODE,TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH24:MI')ADDED_DATE, GET_PATIENT_LINE(A.PATIENT_ID)PLINE, A.CANCEL_YN,A.REQ_TO_FACILITY_ID,A.REQ_TO_FS_LOCN_CODE,C.SHORT_DESC REQ_TO_FS_LOCN_DESC,A.VOLUME_NO FROM FM_REQ_DTL A, FM_REQ_HDR B, FM_STORAGE_LOCN C WHERE A.REQ_NO=B.REQ_NO AND B.REQ_FS_LOCN_CODE = ? AND B.REQ_FACILITY_ID  = ?  AND A.ISS_YN = 'N' AND TRUNC(A.ADDED_DATE) = NVL(?,(TRUNC(A.ADDED_DATE))) AND A.CANCEL_YN='N' AND A.REQ_TO_FACILITY_ID=C.FACILITY_ID AND A.REQ_TO_FS_LOCN_CODE=C.FS_LOCN_CODE AND  NVL(A.CANCEL_YN,'N')='N' AND A.DOC_FOLDER_ID is null ORDER BY 3,5");StringBuffer sqlBuffer = new StringBuffer();
					SelectSqlBuffer.append("SELECT" );
					SelectSqlBuffer.append("  A.REQ_NO" );
					SelectSqlBuffer.append("  , A.REMARKS" );
					SelectSqlBuffer.append("  , A.FILE_NO" );
					SelectSqlBuffer.append("  , a.patient_id" );
					SelectSqlBuffer.append("  , A.FILE_TYPE_CODE" );
					SelectSqlBuffer.append("  , TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH24:MI') ADDED_DATE" );
					SelectSqlBuffer.append("  , Get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE" );
					SelectSqlBuffer.append("  , A.CANCEL_YN" );
					SelectSqlBuffer.append("  , A.REQ_TO_FACILITY_ID" );
					SelectSqlBuffer.append("  , A.REQ_TO_FS_LOCN_CODE" );
					SelectSqlBuffer.append("  , C.SHORT_DESC REQ_TO_FS_LOCN_DESC" );
					SelectSqlBuffer.append("  , A.VOLUME_NO " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  FM_REQ_DTL A" );
					SelectSqlBuffer.append("  , FM_REQ_HDR B" );
					SelectSqlBuffer.append("  , FM_STORAGE_LOCN_LANG_VW C " );
						SelectSqlBuffer.append("  , FM_CURR_LOCN D " );
					SelectSqlBuffer.append("WHERE A.REQ_NO = B.REQ_NO " );
					SelectSqlBuffer.append("  AND B.REQ_FS_LOCN_CODE = ? " );
					SelectSqlBuffer.append("  AND B.REQ_FACILITY_ID = ? " );
					SelectSqlBuffer.append("  AND A.ISS_YN = 'N' " );
					SelectSqlBuffer.append("  AND Trunc(A.ADDED_DATE) =NVL(TO_DATE(?,'DD/MM/YYYY'),(Trunc(A.ADDED_DATE))) " );
					SelectSqlBuffer.append("  AND A.CANCEL_YN = 'N' " );
					SelectSqlBuffer.append("  AND A.REQ_TO_FACILITY_ID = C.FACILITY_ID " );
					SelectSqlBuffer.append("  AND A.REQ_TO_FS_LOCN_CODE = C.FS_LOCN_CODE " );
					SelectSqlBuffer.append("  AND Nvl(A.CANCEL_YN,'N') = 'N' " );
					SelectSqlBuffer.append("  AND A.DOC_FOLDER_ID IS" );
					SelectSqlBuffer.append("  NULL " );
					SelectSqlBuffer.append("  AND C.LANGUAGE_ID='"+localeName+"' " );
					SelectSqlBuffer.append("  AND D.volume_status not in('L') " );
					//SelectSqlBuffer.append("  AND D.facility_id = b.req_facility_id " );
					SelectSqlBuffer.append("  AND a.file_no = D.file_no " );
                    SelectSqlBuffer.append("  AND a.volume_no = D.volume_no " ); 
					
					
					SelectSqlBuffer.append("ORDER BY 3,5,12" );
				}
				else if(file_type_appl_yn.equals("Y"))
				{
				//SelectSqlBuffer.append("SELECT A.REQ_NO,A.REMARKS,A.FILE_NO,A.FILE_TYPE_CODE,d.short_desc file_type_desc,TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH24:MI')ADDED_DATE, GET_PATIENT_LINE(A.PATIENT_ID)PLINE, A.CANCEL_YN,A.REQ_TO_FACILITY_ID,A.REQ_TO_FS_LOCN_CODE,C.SHORT_DESC REQ_TO_FS_LOCN_DESC,A.VOLUME_NO FROM FM_REQ_DTL A, FM_REQ_HDR B, FM_STORAGE_LOCN C,mr_file_type d WHERE A.REQ_NO=B.REQ_NO AND a.req_to_facility_id = d.facility_id(+)  AND a.file_type_code = d.file_type_code(+) AND B.REQ_FS_LOCN_CODE = ? AND B.REQ_FACILITY_ID  = ?  AND A.ISS_YN = 'N' AND TRUNC(A.ADDED_DATE) = NVL(?,(TRUNC(A.ADDED_DATE))) AND A.CANCEL_YN='N' AND A.REQ_TO_FACILITY_ID=C.FACILITY_ID AND A.REQ_TO_FS_LOCN_CODE=C.FS_LOCN_CODE AND NVL(A.CANCEL_YN,'N')='N' AND A.DOC_FOLDER_ID is null ORDER BY 3,5");

					SelectSqlBuffer.append("SELECT" );
					SelectSqlBuffer.append("  A.REQ_NO" );
					SelectSqlBuffer.append("  , A.REMARKS" );
					SelectSqlBuffer.append("  , A.FILE_NO" );
					SelectSqlBuffer.append("  , a.patient_id" );
					SelectSqlBuffer.append("  , A.FILE_TYPE_CODE" );
					SelectSqlBuffer.append("  , d.Short_desc File_Type_desc" );
					SelectSqlBuffer.append("  , TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH24:MI') ADDED_DATE" );
					SelectSqlBuffer.append("  , Get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE" );
					SelectSqlBuffer.append("  , A.CANCEL_YN" );
					SelectSqlBuffer.append("  , A.REQ_TO_FACILITY_ID" );
					SelectSqlBuffer.append("  , A.REQ_TO_FS_LOCN_CODE" );
					SelectSqlBuffer.append("  , C.SHORT_DESC REQ_TO_FS_LOCN_DESC" );
					SelectSqlBuffer.append("  , A.VOLUME_NO " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  FM_REQ_DTL A" );
					SelectSqlBuffer.append("  , FM_REQ_HDR B" );
					SelectSqlBuffer.append("  , FM_STORAGE_LOCN_LANG_VW C" );
					SelectSqlBuffer.append("  , mr_file_type_lang_vw D " );
					SelectSqlBuffer.append("  , FM_CURR_LOCN E " );
					SelectSqlBuffer.append("   WHERE A.REQ_NO = B.REQ_NO " );
					SelectSqlBuffer.append("  AND a.req_to_facility_id = d.facility_id(+) " );
					SelectSqlBuffer.append("  AND a.file_type_code = d.file_type_code(+) " );
					SelectSqlBuffer.append("  AND B.REQ_FS_LOCN_CODE = ? " );
					SelectSqlBuffer.append("  AND B.REQ_FACILITY_ID = ? " );
					SelectSqlBuffer.append("  AND A.ISS_YN = 'N' " );
					SelectSqlBuffer.append("  AND TRUNC(A.ADDED_DATE) = NVL(TO_DATE(?,'DD/MM/YYYY'),(TRUNC(A.ADDED_DATE))) " );
					SelectSqlBuffer.append("  AND A.CANCEL_YN='N' " );
					SelectSqlBuffer.append("  AND A.REQ_TO_FACILITY_ID=C.FACILITY_ID " );
					SelectSqlBuffer.append("  AND A.REQ_TO_FS_LOCN_CODE=C.FS_LOCN_CODE " );
					SelectSqlBuffer.append("  AND NVL(A.CANCEL_YN,'N')='N' " );
					SelectSqlBuffer.append("  AND A.DOC_FOLDER_ID IS" );
					SelectSqlBuffer.append("  NULL " );
					SelectSqlBuffer.append("  AND C.language_id=D.LANGUAGE_ID " );
					SelectSqlBuffer.append("  AND C.LANGUAGE_id = '"+localeName+"' " );
					SelectSqlBuffer.append("  AND E.volume_status not in('L') " );
					//SelectSqlBuffer.append("  AND e.facility_id = b.req_facility_id " );
					SelectSqlBuffer.append("  AND a.file_no = e.file_no " );
                    SelectSqlBuffer.append("  AND a.volume_no = e.volume_no and d.facility_id='"+file_faci+"' " ); 
									
					SelectSqlBuffer.append("ORDER BY 3,5,13" );
				}
			}
			else if(!(file_num.equals("")) || !(file_type_code.equals("")))
			{
				if(file_type_appl_yn.equals("N"))
				{
				//SelectSqlBuffer.append("SELECT a.req_no, a.remarks,a.file_no,a.file_type_code,TO_CHAR(a.added_date, 'DD/MM/RRRR HH24:MI') added_date,get_patient_line (a.patient_id) pline, a.cancel_yn,       a.req_to_facility_id, a.req_to_fs_locn_code,c.short_desc req_to_fs_locn_desc, a.volume_no  FROM fm_req_dtl a,fm_req_hdr b,fm_storage_locn c  WHERE a.req_no = b.req_no AND b.req_fs_locn_code = ? AND b.req_facility_id = ? AND a.iss_yn = 'N' AND TRUNC (a.added_date) = NVL (?, (TRUNC (a.added_date))) AND a.cancel_yn = 'N' AND a.req_to_facility_id = c.facility_id AND a.req_to_fs_locn_code = c.fs_locn_code "+CriteriaSqlBuffer+" AND NVL (a.cancel_yn, 'N') = 'N' AND A.DOC_FOLDER_ID is null ");
					SelectSqlBuffer.append("SELECT" );
					SelectSqlBuffer.append("  a.req_No" );
					SelectSqlBuffer.append("  , a.Remarks" );
					SelectSqlBuffer.append("  , a.File_No" );
					SelectSqlBuffer.append("  , a.patient_id" );
					SelectSqlBuffer.append("  , a.File_Type_Code" );
					SelectSqlBuffer.append("  , TO_CHAR(a.Added_Date,'DD/MM/RRRR HH24:MI') Added_Date" );
					SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
					SelectSqlBuffer.append("  , a.Cancel_yn" );
					SelectSqlBuffer.append("  , a.req_To_Facility_Id" );
					SelectSqlBuffer.append("  , a.req_To_fs_Locn_Code" );
					SelectSqlBuffer.append("  , c.Short_desc req_To_fs_Locn_desc" );
					SelectSqlBuffer.append("  , a.Volume_No " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  fm_req_dtl a" );
					SelectSqlBuffer.append("  , fm_req_hdr b" );
					SelectSqlBuffer.append("  , FM_STORAGE_LOCN_LANG_VW c " );
					SelectSqlBuffer.append("  , FM_CURR_LOCN d " );
					SelectSqlBuffer.append("WHERE a.req_No = b.req_No " );
					SelectSqlBuffer.append("  AND b.req_fs_Locn_Code = ? " );
					SelectSqlBuffer.append("  AND b.req_Facility_Id = ? " );
					SelectSqlBuffer.append("  AND a.Iss_yn = 'N' " );
					SelectSqlBuffer.append("  AND Trunc(a.Added_Date) = NVL(TO_DATE(?,'DD/MM/YYYY'),(Trunc(a.Added_Date))) " );
					SelectSqlBuffer.append("  AND a.Cancel_yn = 'N' " );
					SelectSqlBuffer.append("  AND a.req_To_Facility_Id = c.Facility_Id " );
					SelectSqlBuffer.append("  AND a.req_To_fs_Locn_Code = c.fs_Locn_Code " );
					SelectSqlBuffer.append(CriteriaSqlBuffer);
					SelectSqlBuffer.append("  AND Nvl(a.Cancel_yn,'N') = 'N' " );
					SelectSqlBuffer.append("  AND A.DOC_FOLDER_ID IS" );
					SelectSqlBuffer.append("  NULL " );
					SelectSqlBuffer.append("  AND C.LANGUAGE_id = '"+localeName+"'" );
                    SelectSqlBuffer.append("  AND d.volume_status not in('L') " );
					//SelectSqlBuffer.append("  AND d.facility_id = b.req_facility_id " );
					SelectSqlBuffer.append("  AND a.file_no = d.file_no " );
                    SelectSqlBuffer.append("  AND a.volume_no = d.volume_no " ); 
				   SelectSqlBuffer.append("ORDER BY 3,5,12" );
				}
				else if(file_type_appl_yn.equals("Y"))
				{
				//SelectSqlBuffer.append("SELECT a.req_no, a.remarks,a.file_no,a.file_type_code,d.short_desc file_type_desc, TO_CHAR (a.added_date, 'DD/MM/RRRR HH24:MI') added_date,get_patient_line(a.patient_id) pline, a.cancel_yn,a.req_to_facility_id,a.req_to_fs_locn_code,c.short_desc req_to_fs_locn_desc, a.volume_no FROM fm_req_dtl a,fm_req_hdr b,fm_storage_locn c,mr_file_type d WHERE a.req_no = b.req_no AND a.req_to_facility_id = d.facility_id(+) AND a.file_type_code = d.file_type_code(+) AND b.req_fs_locn_code = ? AND b.req_facility_id = ? AND a.iss_yn = 'N' AND TRUNC (a.added_date) = NVL (?, (TRUNC (a.added_date))) AND a.cancel_yn = 'N' AND a.req_to_facility_id = c.facility_id AND a.req_to_fs_locn_code = c.fs_locn_code "+CriteriaSqlBuffer+" AND NVL (a.cancel_yn, 'N') = 'N' AND A.DOC_FOLDER_ID is null ");
					SelectSqlBuffer.append("SELECT" );
					SelectSqlBuffer.append("  a.req_No" );
					SelectSqlBuffer.append("  , a.Remarks" );
					SelectSqlBuffer.append("  , a.File_No" );
					SelectSqlBuffer.append("  , a.patient_id" );
					SelectSqlBuffer.append("  , a.File_Type_Code" );
					SelectSqlBuffer.append("  , d.Short_desc File_Type_desc" );
					SelectSqlBuffer.append("  , TO_CHAR(a.Added_Date,'DD/MM/RRRR HH24:MI') Added_Date" );
					SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
					SelectSqlBuffer.append("  , a.Cancel_yn" );
					SelectSqlBuffer.append("  , a.req_To_Facility_Id" );
					SelectSqlBuffer.append("  , a.req_To_fs_Locn_Code" );
					SelectSqlBuffer.append("  , c.Short_desc req_To_fs_Locn_desc" );
					SelectSqlBuffer.append("  , a.Volume_No " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  fm_req_dtl a" );
					SelectSqlBuffer.append("  , fm_req_hdr b" );
					SelectSqlBuffer.append("  , FM_STORAGE_LOCN_LANG_VW c" );
					SelectSqlBuffer.append("  , mr_file_type_lang_vw d " );
					SelectSqlBuffer.append("  , fm_curr_locn e " );
					SelectSqlBuffer.append("WHERE a.req_No = b.req_No " );
					SelectSqlBuffer.append("  AND C.language_id=D.LANGUAGE_ID " );
					SelectSqlBuffer.append("  AND C.LANGUAGE_id = '"+localeName+"' " );
					SelectSqlBuffer.append("  AND a.req_to_facility_id = d.facility_id(+) " );
					SelectSqlBuffer.append("  AND a.file_type_code = d.file_type_code(+) " );
					SelectSqlBuffer.append("  AND b.req_fs_locn_code = ? " );
					SelectSqlBuffer.append("  AND b.req_facility_id = ? " );
					SelectSqlBuffer.append("  AND a.iss_yn = 'N' " );
					SelectSqlBuffer.append("  AND TRUNC (a.added_date) = NVL(TO_DATE(?,'DD/MM/YYYY'),(TRUNC (a.added_date))) " );
					SelectSqlBuffer.append("  AND a.cancel_yn = 'N' " );
					SelectSqlBuffer.append("  AND a.req_to_facility_id = c.facility_id " );
					SelectSqlBuffer.append("  AND a.req_to_fs_locn_code = c.fs_locn_code " );
					SelectSqlBuffer.append(CriteriaSqlBuffer);
					SelectSqlBuffer.append("  AND NVL (a.cancel_yn, 'N') = 'N' " );
					SelectSqlBuffer.append("  AND A.DOC_FOLDER_ID IS" );
					SelectSqlBuffer.append("  NULL" );
				   SelectSqlBuffer.append("  AND e.volume_status not in('L') " );
					//SelectSqlBuffer.append("  AND e.facility_id = b.req_facility_id " );
					SelectSqlBuffer.append("  AND a.file_no = e.file_no " );
                    SelectSqlBuffer.append("  AND a.volume_no = e.volume_no and d.facility_id='"+file_faci+"' " ); 
				    SelectSqlBuffer.append("ORDER BY 3,5,13" );
				}
			}
     		
			
			pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		    pstmt.setString(1,FSLocation);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,request_date);
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				if ( i % 2 == 0 )
					classValue = "QRYODD" ;
				else
					classValue = "QRYEVEN" ;
			
				String fileno			= rs.getString("FILE_NO");
				String patientid			= rs.getString("patient_id");
				String volumeno			= rs.getString("VOLUME_NO");
				String reqno			= rs.getString("REQ_NO");
				String pline			= rs.getString("PLINE");
				
				if(pline == null || pline.equals("null"))
				{ 
					pline = ""; 
				}
				else
				{
					pline = rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
				}
				
				String requestDate		= rs.getString("ADDED_DATE");
				String senderlocndesc	= rs.getString("REQ_TO_FS_LOCN_DESC");
				String issuedate		= "";
				String p_req_remarks	= rs.getString("REMARKS")==null?"":rs.getString("REMARKS");
				// p_req_remarks=java.net.URLDecoder.decode( p_req_remarks,"UTF-8");
				if(reqno == null || reqno.equals("null")) reqno="";
				if(pline == null || pline.equals("null")) pline="";
				if(fileno == null || fileno.equals("null")) fileno="";
				if(requestDate != null )
				requestDate=DateUtils.convertDate(requestDate,"DMYHM","en",localeName);
					else
						requestDate="";
				if(volumeno == null || volumeno.equals("null")) volumeno="";
				if(p_req_remarks == null || p_req_remarks.equals("null")) p_req_remarks="";
				if(p_req_remarks == null || p_req_remarks.equals("null")) p_req_remarks="";
				if(issuedate == null || issuedate.equals("null")) issuedate = "&nbsp;";
				if(senderlocndesc == null || senderlocndesc.equals("null")) 
					senderlocndesc = "&nbsp;";
		
				if(file_type_appl_yn.equals("N"))
				{
					out.println("<tr><td class='"+classValue+"' width='40%'>");
					out.println("<font 	size=1><b>"+fileno+"</b><br>&nbsp;&nbsp;"+pline+"</font></td>");
					out.println("<td class='"+classValue+"' width='13%'><font size=1><CENTER>");
				}
				else if (file_type_appl_yn.equals("Y"))
				{
					out.println("<tr><td class='"+classValue+"' width='40%'>");
					out.println("<font size=1>&nbsp;"+pline+"</font></td>");
					out.println("<td class='"+classValue+"' width='13%'><font size=1><CENTER>");
					if(file_type_appl_yn.equals("Y"))
					{
						filetypedesc = rs.getString("file_type_desc");
						if(filetypedesc == null || filetypedesc.equals("null"))  
							filetypedesc= "&nbsp;";
						out.println(filetypedesc);
						if(!filetypedesc.equals("&nbsp;"))
							out.println(" / ");
					}
				}
				
				out.println(volumeno+"</CENTER></font></td>");
				out.println("<td class='"+classValue+"' width='13%'>");
				out.println("<font size=1>"+requestDate+"</font></td>");
				out.println("<td class='"+classValue+"'width='15%'>");

				if(senderlocndesc == null || senderlocndesc.equals("null"))
					out.println("&nbsp;</td>");
				else
				out.println("<font size=1>"+senderlocndesc+" </font></td>");
				out.println("<td  align='center' class='"+classValue+"' width='9%'>");
				%>
				
				
				<%
				
				pat_file_vol1=patientid+"`"+fileno+"`"+volumeno;
		if(!pat_file_vol.equals(""))
		{
		StringTokenizer patfilevolume=new StringTokenizer(pat_file_vol,",");		
	     while(patfilevolume.hasMoreTokens())
		 {
	     patfilevol =patfilevolume.nextToken();	
	       if(patfilevol.equals(pat_file_vol1))
		   {
           status="true";
		   }
		   }
			}		
				if(status.equals("true"))
					{
				status="false";
				%>
				<input type='checkbox' name='cancelbox<%=i%>' id='cancelbox<%=i%>' checked value='N' onClick='cancelSelection(this);'></td>
				
				<%
				out.println("<td id='td1"+i+"' style='display:none'  class='"+classValue+"' width='10%'><font size=1>");
				%>
				<a href='javascript:GetRemarks(<%= i %>)'>&nbsp;</a></font></td>
				<%
				out.println("<td id='td2"+i+"'  class='"+classValue+"' width='10%'><font size=1> ");
				%>
				<a href='javascript:GetRemarks(<%=i%>)'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td></tr>
				
				
				<%}else{ %> 
				
				<input type='checkbox'  name='cancelbox<%=i%>' id='cancelbox<%=i%>'   value='N' onClick='cancelSelection(this);'></td>
				
				<%
				out.println("<td id='td1"+i+"' class='"+classValue+"' width='10%'><font size=1>");
				%>
				<a href='javascript:GetRemarks(<%= i %>)'>&nbsp;</a></font></td>
				<%
				out.println("<td id='td2"+i+"' style='display:none' class='"+classValue+"' width='10%'><font size=1> ");
				%>
				<a href='javascript:GetRemarks(<%= i %>)'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td></tr>
							
				<%} %>
				
				<input type="hidden" name="rem_recnum_<%= i %>" id="rem_recnum_<%= i %>" value="">
				<input type="hidden" name="p_req_remarks<%= i %>" id="p_req_remarks<%= i %>" value="<%=p_req_remarks.trim()%>">
				<%
				out.println("<input type='hidden' name='file"+i+"' id='file"+i+"' value='"+fileno+"'>");
				out.println("<input type='hidden' name='volume"+i+"' id='volume"+i+"' value='"+volumeno+"'>");
				out.println("<input type='hidden' name='req_no"+i+"' id='req_no"+i+"' value='"+reqno+"'>");
                out.println("<input type='hidden' name='patient_id"+i+"' id='patient_id"+i+"' value='"+patientid+"'>");
				i++;
				p_rec_cnt++;
			} 
			if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
			{
				SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
			}

			
			%>
			<script>
				var p_rec_cnt = '<%=p_rec_cnt %>'
				var curr_file_status = '<%=curr_file_status %>'
				var file_no_new= '<%=file_no_new %>'
				var count= '<%=count %>'
				if(curr_file_status!="L")
			{
			if (p_rec_cnt==0)
			{
					
					parent.frames[2].document.forms[0].volumelistvals.value="";
                    parent.frames[2].document.forms[0].patientlistvals.value="";
	                parent.frames[2].document.forms[0].filelistvals.value="";
					parent.frames[2].document.getElementById("hdr_tab").style.visibility = 'hidden';	
					parent.frames[2].document.getElementById("hdr_tab0").style.visibility = 'hidden';
					alert(getMessage('NO_FILE_FOR_CANCEL_REQUEST','FM'));
					parent.frames[3].location.href='../../eCommon/html/blank.html';
				}else if(count==0 && file_no_new!="")
				{
					parent.frames[2].document.getElementById("hdr_tab").style.visibility = 'hidden';	
					parent.frames[2].document.getElementById("hdr_tab0").style.visibility = 'hidden';
					alert(getMessage('NO_FILE_FOR_CANCEL_REQUEST','FM'));
					parent.frames[2].document.getElementById("hdr_tab").style.visibility = 'Visible';	
					parent.frames[2].document.getElementById("hdr_tab0").style.visibility = 'Visible';	
						}
				for (i=0;i<6;i++)
				{
					if ((document.getElementById("test").rows[i+1] != null) && (document.getElementById("test").rows[i+1].cells[i] != null))
					{
						parent.cancel_criteria.document.getElementById("hdr_tab").rows[0].cells[i].width = document.getElementById("test").rows[i+1].cells[i].width; 
					}
				}
		  parent.frames[2].document.forms[0].patient_id.value = "";
			parent.frames[2].document.forms[0].patient_id.onblur();
			}	
				

			if(curr_file_status=="L")
			{
					
					var p_rec_cnt='<%=p_rec_cnt%>';
					
					if(p_rec_cnt==0)
				    {
					parent.frames[2].document.getElementById("hdr_tab").style.visibility = 'hidden';	
					parent.frames[2].document.getElementById("hdr_tab0").style.visibility = 'hidden';
					}
					parent.frames[2].document.forms[0].volumelistvals.value="";
                    parent.frames[2].document.forms[0].patientlistvals.value="";
	                parent.frames[2].document.forms[0].filelistvals.value="";
								
					alert(getMessage('FILE_IS_LOST','FM'));
								
				//	parent.frames[3].location.href='../../eCommon/html/blank.html';
			
				for (i=0;i<6;i++)
				{
					if ((document.getElementById("test").rows[i+1] != null) && (document.getElementById("test").rows[i+1].cells[i] != null))
					{
						parent.cancel_criteria.document.getElementById("hdr_tab").rows[0].cells[i].width = document.getElementById("test").rows[i+1].cells[i].width; 
					}
				}
		parent.frames[2].document.forms[0].patient_id.value = "";
			parent.frames[2].document.forms[0].patient_id.onblur();
			}
			</script>
		
		
	<%	if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
		}catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{			
			ConnectionManager.returnConnection(con,request);
		}
		%>
		<script>
		    parent.frames[2].document.forms[0].patient_id.focus();
					
		</script>
		</table>
		<input type='hidden' name='reccount' id='reccount' value='<%=i%>'>
		<input type='hidden' name='filenos' id='filenos' value=''>
		<input type='hidden' name='volumenos' id='volumenos' value=''>
		<input type='hidden' name='req' id='req' value=''>
		<input type='hidden' name='remarks' id='remarks' value=''>
		<input type='hidden' name='can_locn_code' id='can_locn_code' value=''>
		<input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
</form>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

