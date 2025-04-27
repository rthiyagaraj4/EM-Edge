<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Register File Not Pulled
	Function		:	This function is used for Search Result.
-->
<%@ page contentType="text/html; charset=UTF-8" import= "java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="pullinglistrefno" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="pullinglistremarks" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="pullinglistFileNo" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="pullinglistpatientId" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="pullinglistVolumeNo" class="webbeans.eCommon.RecordSet" scope="session"/>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMConfirmPullingList.js'></script>

</head>
<body  onLoad='dispRecord(); loadCurrPage();' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='FMConfirmPullingListForm' id='FMConfirmPullingListForm' action='FMConfirmPullingListResults.jsp' method='post'>
<%!
	int row_count=0;
	int total_count=0;
%>
<%
	Connection con			=	null;
	java.sql.Statement stmt			=	null;
	PreparedStatement pstmt =	null;	
	PreparedStatement pstmt1 =	null;	
	java.sql.Statement stmt_other	=	null;	
	ResultSet rs			=	null;
	ResultSet rs1			=	null;
	ResultSet rs_other_appt	=	null;
	ResultSet rset3			=	null;	
	
//	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
//	String addedById	= p.getProperty( "login_user" ) ;
	String other_appt= "",appt_date="",confirm_all_check="";
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();		
		stmt_other	=	con.createStatement();
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		String alt_id2_type ="";
		String file_type_appl_yn ="";
		//String auto_yn="";
		boolean dis_oth_flag = false;
	
		String facility_id=(String)session.getValue("facility_id");
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i1=1;
         int reccnt=0;
		if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 60 ; }   else {  end = Integer.parseInt( to ) ; }       
            
        String  req_start   =   "", req_end     =   "",confirm_all_dis="";
		        
	    String flagSelect		= request.getParameter("flagSelect");
		appt_date				=request.getParameter("appt_date");
		String p_gender			= request.getParameter("gender");
		String p_fm_clinic_code	= request.getParameter("fm_clinic_code");
		String p_fm_pract_id	= request.getParameter("fm_pract_id");
		String pull_type		= request.getParameter("pull_type");
		String p_to_pract_id	= request.getParameter("to_pract_id");
		String p_fs_locn_code	= request.getParameter("fs_locn_code");		
		String confirm_yn		= request.getParameter("confirm_yn");
		String check			= request.getParameter("check");
		String added_file_vol	= request.getParameter("added_file_vol"); 
		//New variable 'temp' added for SRR20056-SCF-7380.1 [IN:028088] by Venkatesh S on 09.08.2011
		String temp	= request.getParameter("temp");		
		String where_cond="";
		String patient_id1=request.getParameter("patient_id");
		String filenum=request.getParameter("filenum");
		String volume_no1=request.getParameter("volume_no");
		String  str1="";
		 String flag="false";		  
		String curr_filestatus="";
		boolean chkStatus = true;
		int OTHER_APPTS=0;
		if(appt_date==null)	
		{
			//appt_date=DateUtils.convertDate(appt_date,"DMY",localeName,"en");
			appt_date="";
		}
		
		
		if(patient_id1==null)			patient_id1="";
		if(filenum==null)			filenum="";
		if(volume_no1==null)			volume_no1="";
		if(p_gender==null)			p_gender="";
		if(pull_type==null)			pull_type="";
		if(check==null)				check="";
		if(p_fm_clinic_code==null)	p_fm_clinic_code=""; //it will show all clinics
		if(p_fm_pract_id==null)		p_fm_pract_id="";
		if(p_to_pract_id==null)		p_to_pract_id="";
		if(p_fs_locn_code==null)	p_fs_locn_code="";
		if(added_file_vol==null)	added_file_vol="";
		  
	   if(!filenum.equals("")){ 
		  str1="select curr_file_status from fm_curr_locn where patient_id='"+patient_id1+"' and curr_fs_locn_code='"+p_fs_locn_code+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";		
		  pstmt	= con.prepareStatement(str1);
		  rs		= pstmt.executeQuery();
		  if(rs != null){			  
			if(rs.next()){				
			 curr_filestatus=rs.getString("curr_file_status");
			}else{			  
			  chkStatus = false;			 
		    }
		  }	
	   }	
	   
	   if(rs!=null)	rs.close();
       if(pstmt != null) pstmt.close();
		
	
		where_cond = "where  a.facility_id=? and a.appt_date = to_date(?,'dd/mm/yyyy') and a.facility_id=b.facility_id and a.file_no=b.file_no and a.volume_no=b.volume_no";
		if(!p_fm_clinic_code.equals("")){
		  where_cond=where_cond+" and a.clinic_code = nvl(?,'!') ";
		}		
		where_cond=where_cond+" and (a.practitioner_id is null or a.practitioner_id between nvl(?,'!') and nvl(?,'~')) and ( ? is null or ? is null or a.practitioner_id is not null)and  f.gender=decode(?,'A', f.gender,?) and a.facility_id=d.facility_id AND a.src_fs_locn_code=d.src_fs_locn_code AND a.dest_fs_locn_code = d.dest_fs_locn_code and d.clinic_code = a.clinic_code and a.appt_date=d.appt_date and a.facility_id=f.facility_id(+) and a.appt_ref_no=f.appt_ref_no(+) and a.auto_track_yn = 'N' and a.pull_list_type=decode(?,'A',a.pull_list_type,?)";
         if (confirm_yn.equals("C")){ 
		   where_cond=where_cond+"AND f.appt_date = (select max(appt_date) from oa_appt_del_tr where FACILITY_ID = f.facility_id and APPT_REF_NO = f.appt_ref_no)";
		}
		 
		 String ret_status = "and fm_return_appt_status(?,?,?,?,?,a.appt_ref_no,a.patient_id)";
		
				
		if (confirm_yn.equals("C"))
			where_cond =  where_cond + ret_status + " ='C'";
		else if (confirm_yn.equals("T"))
		where_cond =  where_cond + ret_status + " ='T'";				
		else if (confirm_yn.equals("S"))
			where_cond = where_cond + ret_status + " ='S'";	
		else if (confirm_yn.equals("F"))
			where_cond = where_cond +" and (curr_facility_id != ? or b.perm_fs_locn_code != b.curr_fs_locn_code and b.curr_file_status!='T' )";
		else if (confirm_yn.equals("N")){
		    where_cond = where_cond + ret_status + " not in ('C','T','S') and A.CONFIRM_YN ='"+confirm_yn+"' and (curr_facility_id = ? or b.perm_fs_locn_code = b.curr_fs_locn_code) and b.curr_file_status NOT in('O','R','T','E','A')";	 
		}
		else if (confirm_yn.equals("Y")){
			where_cond = where_cond + ret_status + " not in ('C','T','S') and A.CONFIRM_YN ='Y' and (curr_facility_id =? or b.perm_fs_locn_code = b.curr_fs_locn_code) and b.curr_file_status NOT in('O','R','T','E','A')";	 
		}
			
				
			confirm_all_check="";
			confirm_all_dis="disabled";
		if(confirm_yn.equals("Y")||confirm_yn.equals("N")){
			confirm_all_dis="";
			if (flagSelect!=null)	
			check="Y";
		}
        if(check.equals("Y"))
			confirm_all_check="checked";
		 else
			confirm_all_check="";
			//String param_val ="select alt_id2_type,file_type_appl_yn from mp_param";
			String param_val ="select mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+localeName+"','1') alt_id2_type,file_type_appl_yn from mp_param";
			pstmt		=	con.prepareStatement(param_val);
			rset3 = pstmt.executeQuery();
			rset3.next();
			alt_id2_type = rset3.getString(1);
			file_type_appl_yn = rset3.getString(2);
			if(alt_id2_type == null || alt_id2_type.equals("null"))alt_id2_type="";			
			if(file_type_appl_yn == null || file_type_appl_yn.equals("null"))file_type_appl_yn ="";

			if(rset3 != null) rset3.close();
			if(pstmt != null) pstmt.close();
			
		if(flagSelect !=null)
		{
		 if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
			{
			pullinglistrefno.clearAll();
			pullinglistremarks.clearAll();
			pullinglistFileNo.clearAll();
			pullinglistpatientId.clearAll();
			pullinglistVolumeNo.clearAll();
		 	confirm_all_check="checked";
			StringBuffer rePopulate = null;
			StringBuffer rePopulate1 = null;
			rePopulate				 = new StringBuffer();
			rePopulate1				 = new StringBuffer();
			//rePopulate.append("select patient_id,file_no,volume_no,appt_ref_no, remarks from fm_pulling_list where facility_id = ? and appt_date= to_date(?,'dd/mm/yyyy') and clinic_code =nvl(?,'!')  and (practitioner_id is null or practitioner_id between nvl(?,'!') and nvl(?,'~')) and (? is null or ? is null or practitioner_id is not null)and src_fs_locn_code=? and confirm_yn = ? and pull_list_type = decode(?,'A',pull_list_type,?)");
			rePopulate.append("SELECT a.patient_id, a.file_no, a.volume_no, appt_ref_no, a.remarks FROM fm_pulling_list a,fm_curr_locn b WHERE a.facility_id = ? AND appt_date = TO_DATE (?,'dd/mm/yyyy') ");
			if(!p_fm_clinic_code.equals("")){
				rePopulate.append("and a.clinic_code =nvl(?,'!') ");
			}
			rePopulate.append(" AND (   a.practitioner_id IS NULL OR a.practitioner_id BETWEEN NVL(?,'!') AND NVL (?,'~')) and (? is null or ? is null or a.practitioner_id is not null) and a.src_fs_locn_code=? and a.confirm_yn = ? and a.pull_list_type = decode(?,'A',a.pull_list_type,?)");		
		
			if (!p_gender.equals("A"))
			rePopulate.append(" and a.patient_id in (select patient_id from mp_patient where sex = decode(?,'A',sex,?)) ");
		rePopulate1=rePopulate;
	/*	if(!patient_id1.equals("") && !filenum.equals("") && !volume_no1.equals("") )
				{
		rePopulate1.append(" and patient_id ='"+patient_id1+"'  and file_no='"+filenum+"' and volume_no='"+volume_no1+"' ");
				} */
			
			if(!added_file_vol.equals(""))
			{  //New condition added for SRR20056-SCF-7380.1 [IN:028088] by Venkatesh S on 09.08.2011
				if(!added_file_vol.equals(temp)){					
					rePopulate1.append(" and (a.FILE_NO,a.VOLUME_NO,a.patient_id) IN ("+temp+")  ");
				}else{ 
					rePopulate.append(" and (a.FILE_NO,a.VOLUME_NO,a.patient_id) IN ("+added_file_vol+")  ");
			    }
			}
	
			rePopulate1.append(" and a.patient_id=b.patient_id and b.curr_file_status = 'I'"); //included for the SCF - SKR-SCF-0498 32707 
			
			pstmt		=	con.prepareStatement(rePopulate.toString());
  			pstmt1		=	con.prepareStatement(rePopulate1.toString());
			int pstcnt = 0;
			int pstcnt2 = 0;
			
			pstmt.setString(++pstcnt,facility_id);
			pstmt.setString(++pstcnt,appt_date);
			pstmt1.setString(++pstcnt2,facility_id);
			pstmt1.setString(++pstcnt2,appt_date);
			if(!p_fm_clinic_code.equals(""))
			{
			pstmt.setString(++pstcnt,p_fm_clinic_code);
			pstmt1.setString(++pstcnt2,p_fm_clinic_code);
			}
			pstmt.setString(++pstcnt,p_fm_pract_id);
			pstmt.setString(++pstcnt,p_to_pract_id);
			pstmt.setString(++pstcnt,p_fm_pract_id);
			pstmt.setString(++pstcnt,p_to_pract_id);
			pstmt.setString(++pstcnt,p_fs_locn_code);
			pstmt.setString(++pstcnt,confirm_yn);
			pstmt.setString(++pstcnt,pull_type);
			pstmt.setString(++pstcnt,pull_type);
			
			pstmt1.setString(++pstcnt2,p_fm_pract_id);
			pstmt1.setString(++pstcnt2,p_to_pract_id);
			pstmt1.setString(++pstcnt2,p_fm_pract_id);
			pstmt1.setString(++pstcnt2,p_to_pract_id);
			pstmt1.setString(++pstcnt2,p_fs_locn_code);
			pstmt1.setString(++pstcnt2,confirm_yn);
			pstmt1.setString(++pstcnt2,pull_type);
			pstmt1.setString(++pstcnt2,pull_type);
			if (!p_gender.equals("A"))
				{
				pstmt.setString(++pstcnt,p_gender);
				pstmt.setString(++pstcnt,p_gender);
				
				pstmt1.setString(++pstcnt2,p_gender);
				pstmt1.setString(++pstcnt2,p_gender);
				}
			rset3 = pstmt.executeQuery();
			
			if(!patient_id1.equals("")){
				rs1=pstmt1.executeQuery();
				if(rs1 !=null){
				 while(rs1.next()){
				   reccnt++;
				 }
				}				
 
			if((reccnt==0 && !patient_id1.equals("")) || chkStatus == false ){
				 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.frames[0].document.forms[0].patient_id.value='';parent.frames[0].document.getElementById('patientid1').onblur();parent.frames[0].document.forms[0].patient_id.focus();</script>"); //this line modified for this incident [IN:044324]
				 flag="true"	;
			   }
			}			
			
			String remarks1 ="";
					
			if(rset3 !=null){
			  while(rset3.next()){
				pullinglistrefno.putObject(rset3.getString("appt_ref_no"));
				pullinglistFileNo.putObject(rset3.getString("file_no"));	pullinglistVolumeNo.putObject(rset3.getString("volume_no"));pullinglistpatientId.putObject(rset3.getString("patient_id"));
				remarks1 = rset3.getString("remarks");
				if(remarks1 == null) remarks1="";
				  pullinglistremarks.putObject(remarks1);
			  }
			}
			if(pstmt !=null) pstmt.close();
			}
	     }
		req_start       =   (request.getParameter("start")==null)   ?   "1" :   request.getParameter("start");
        req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
        if(from != null && to != null)
        {
                int j=0;
                for( i1=(Integer.parseInt(req_start)); i1<=(Integer.parseInt(req_end)); i1++)
                {
					if(request.getParameter("pull_yn"+(i1)) != null)
                    {
                        String checkedApptRefNo = request.getParameter("p_appt_ref_no"+(i1));
                        String checkedRemarks=request.getParameter("p_remarks"+(i1));
                        String checkedFileNo=request.getParameter("p_file_no"+(i1));
						String checkedVolumeNo=request.getParameter("p_volume_no"+(i1));
                        String checkedPatientID=request.getParameter("p_patient_id"+(i1));
                      //  String Appt_Time=request.getParameter("p_remarks"+(i1));
                        if(checkedRemarks == null) checkedRemarks="";
                        if(!(pullinglistrefno.containsObject(checkedApptRefNo))) { 
                            pullinglistrefno.putObject(checkedApptRefNo);
                            pullinglistremarks.putObject(checkedRemarks);
                            pullinglistFileNo.putObject(checkedFileNo);
							pullinglistVolumeNo.putObject(checkedVolumeNo);
                            pullinglistpatientId.putObject(checkedPatientID);
                            }
                        j++;
                    }
                }       
            out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
            out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
        }
        i1 = 1 ;
        int recordCount = 0;
        recordCount =	pullinglistrefno.getSize();

		int fm_disp=0, to_disp=0;
		
		String file_no="", patient_id="",tblrow_id="",classValue="";
	//	String pull_yn="N",file_pull_yn="N",file_pulled_color="";
		String pat_details="",	clinic_desc="", clinic_code="", fs_locn_code="",curr_file_status="",pull_yn_prop="";
		String fs_locn_desc="", practitioner_name="", practitioner_id="", result_query="";
		String curr_fs_locn_code="", curr_facility_id="",curr_file_status1="",curr_fs_locn_short_desc="";
		String pull_list_type="",appt_status="",file_creation_date="",remarks="";
		String appt_status_color="",alt_id2_no="",sex="",appt_ref_no="",file_pulled_yn="";
		String file_type_code="";
		String file_type_desc="";
		String volume_no = "";
	//	String login_id		=	(String)session.getValue("login_user");
		String mode			=	request.getParameter("mode") ;
		String appl_user_id		= request.getParameter("appl_user_id");
		String p_dflt_remarks	= "",mr_pat_fs_locn_code="" ,appt_time="";
		String p_group_by_clause = "",appt_status_checked="";
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
		String start_time		 = (request.getParameter("start_time")==null || request.getParameter("start_time")=="")?"":request.getParameter("start_time");
		String end_time			 = (request.getParameter("end_time")==null || request.getParameter("end_time")=="")?"":request.getParameter("end_time");
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/
		
		
		if(mode == null || mode.equals("null")) mode="";
		if(appl_user_id == null || appl_user_id.equals("null")) mode="";
		if (p_fm_clinic_code==null) p_fm_clinic_code="";
		if (p_fm_pract_id==null) p_fm_pract_id="";
		if (p_to_pract_id==null) p_to_pract_id="";
		if ( to == null )
	  		end = 60 ;
		else
			end = Integer.parseInt( to ) ;

	//	String client_ip_address=addedById;
		//result_query = "select long_desc from fm_parameter a,fm_narration b where a.facility_id='"+facility_id+"' and a.dflt_narr_code_for_auto_track = b.narration_code";
		result_query = "SELECT Long_desc FROM fm_Parameter a,  fm_narration_lang_vw b WHERE a.Facility_Id = '"+facility_id+"'  AND LANGUAGE_ID='"+localeName+"'  AND a.dflt_narr_Code_For_Auto_Track = b.Narration_Code";

		rs = stmt.executeQuery(result_query);
		result_query="";
       
		while (rs.next())
		{
			p_dflt_remarks = rs.getString("long_desc");
		}
		if(rs != null) rs.close();
		if(mode.equals(""))
		{
		//result_query="select to_char(f.appt_time,'hh24:mi') appt_time,a.file_no,a.FILE_TYPE_CODE,a.FILE_TYPE_DESC,a.VOLUME_NO, a.patient_id, to_char(b.added_date,'dd/mm/rrrr') file_creation_date, a.clinic_desc, a.clinic_code, a.src_fs_locn_code, a.DEST_FS_LOCN_DESC src_fs_locn_desc, nvl(a.practitioner_name,'Not Identified') practitioner_name	 , a.practitioner_id, f.patient_name pat_details/*get_patient_line(a.patient_id) pat_details*/ , decode(b.curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived', 'O', 'Outside', 'R', 'Returned' ) curr_file_status,curr_file_status curr_file_status1,b.curr_fs_locn_code,b.curr_facility_id,g.short_desc || '<br>&nbsp;&nbsp;&nbsp;' || '(' || decode(b.curr_fs_locn_identity,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','Procedure Unit','Y','Daycare Unit') || ')' curr_fs_locn_short_desc, a.pull_list_type,a.remarks,f.alt_id2_no,decode(f.gender,'M','Male','F','Female','Unknown')sex,a.appt_ref_no,a.pulled_file_status file_pulled_yn,(case when a.appt_date=to_date(?,'dd/mm/yyyy') then 'Y' else 'N' end)appt_status_checked,b.perm_fs_locn_code mr_pat_fs_locn_code from fm_pulling_list_vw a,fm_curr_locn b,fm_pulling_list_ctl d,op_clinic e,oa_appt f,fm_storage_locn g  ";			
		result_query = "SELECT"
					  +"  TO_CHAR(f.appt_Time,'hh24:mi') appt_Time"
					  +"  , a.File_No"
					  +"  , a.FILE_TYPE_CODE"
					  +"  , mr_get_desc.MR_FILE_TYPE('"+facility_id+"',a.FILE_TYPE_CODE,'"+localeName+"',2) FILE_TYPE_DESC"
					  +"  , a.VOLUME_NO"
					  +"  , a.Patient_Id"
					  +"  , TO_CHAR(b.Added_Date,'dd/mm/rrrr') File_Creation_Date"
					  +"  , op_Get_desc.OP_CLINIC('"+facility_id+"',a.Clinic_Code,'"+localeName+"',1) clinic_desc"
					  +"  , a.Clinic_Code"
					  +"  , a.src_fs_Locn_Code"
					  +"  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.src_fs_Locn_Code,'"+localeName+"',2) src_fs_Locn_desc"
					  +"  , Nvl((AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+localeName+"','1')),'Not Identified') Practitioner_Name"
					  +"  , a.Practitioner_Id"
					  +"  , decode('"+localeName+"', 'en', f.patient_name, nvl(f.patient_name_loc_lang, f.patient_name)) Pat_Details"
					  +"  , b.Curr_File_Status Curr_File_Status"
					  +"  , B.Curr_File_Status Curr_File_Status1"
					  +"  , b.Curr_fs_Locn_Code"
					  +"  , b.Curr_Facility_Id"
					  +"  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',b.curr_fs_locn_code,'"+localeName+"',2) ||'&nbsp;' ||'(' || decode(b.curr_fs_locn_identity,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','Procedure Unit','Y','Daycare Unit','X','External') ||')' Curr_fs_Locn_Short_desc"
					  +"  , a.Pull_List_Type"
					  +"  , a.Remarks"
					  +"  , f.alt_Id2_No"
					  +"  , f.Gender Sex"
					  +"  , a.appt_ref_No"
					  +"  , a.CONFIRM_YN File_Pulled_yn"
					  +"  , ("
					  +"  CASE "
					  +"  WHEN a.appt_Date = TO_DATE(sysdate,'dd/mm/yyyy') "
					  +"  THEN"
					  +"    'Y' "
					  +"  ELSE 'N' "
					  +"  END) appt_Status_Checked"
					  +"  , b.Perm_fs_Locn_Code mr_Pat_fs_Locn_Code  "
					 +"  ,  (SELECT COUNT (1) FROM fm_pulling_list B  WHERE B.facility_id =     A.FACILITY_ID AND TRUNC(B.appt_date) = TRUNC(A.APPT_DATE) 	 AND    B.patient_id = a.patient_id) OTHER_APPTS "
					
					  +"FROM"
					  +"  fm_PullIng_List a"
					  +"  , fm_Curr_Locn b"
					  +"  , fm_PullIng_List_ctl d";

		//Modified above result_query by Thamizh selvi on 17th Jan 2018 against ML-MMOH-CRF-0933 
		if ( confirm_yn.equals("C") || confirm_yn.equals("S") )
			result_query =  result_query + " , OA_APPT_DEL_TR f ";		
		else 
			result_query =  result_query + " , oa_appt f ";					  
			
		result_query = result_query + where_cond;
		if(!added_file_vol.equals(""))
				result_query=result_query+" and (b.FILE_NO,b.VOLUME_NO,a.patient_id) IN ("+added_file_vol+")  ";
		
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
		if(!start_time.equals("") && !end_time.equals("")){
			String start_time_number	= start_time.replace(":", "");
			String end_time_number		= end_time.replace(":", "");
			result_query	= result_query + "and to_number(to_char(a.appt_time,'hh24mi'))  between "+start_time_number+" and "+end_time_number+"";
		}
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/
		
		result_query =result_query +  " order by a.clinic_code,a.practitioner_id,sex, b.terminal_digit, b.TERMINAL_DIGIT_GRP1, b.TERMINAL_DIGIT_GRP2, b.TERMINAL_DIGIT_GRP3, a.file_no, appt_time";


		try{
			pstmt		=	con.prepareStatement(result_query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			/*pstmt.setString(1,appt_date);
            pstmt.setString(2,facility_id);
            pstmt.setString(3,appt_date);
            pstmt.setString(4,p_fm_clinic_code);
            pstmt.setString(5,p_fm_pract_id);
            pstmt.setString(6,p_to_pract_id);
            pstmt.setString(7,p_fm_pract_id);
            pstmt.setString(8,p_to_pract_id);
			pstmt.setString(9,p_gender);
            pstmt.setString(10,p_gender);
            pstmt.setString(11,pull_type);
            pstmt.setString(12,pull_type);
			out.println("confirm_yn"+confirm_yn);
			if (confirm_yn.equals("F"))
			{
            pstmt.setString(13,facility_id);
			}
            else
			{
			pstmt.setString(13,facility_id);
            pstmt.setString(14,p_fs_locn_code);
            pstmt.setString(15,appt_date);
			pstmt.setString(16,p_fm_clinic_code);
			pstmt.setString(17,p_fm_clinic_code);
			if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
            pstmt.setString(18,facility_id);
			}*/
          /*  pstmt.setString(1,facility_id);
            pstmt.setString(2,appt_date);
            pstmt.setString(3,p_fm_clinic_code);
            pstmt.setString(4,p_fm_pract_id);
            pstmt.setString(5,p_to_pract_id);
            pstmt.setString(6,p_fm_pract_id);
            pstmt.setString(7,p_to_pract_id);
			pstmt.setString(8,p_gender);
            pstmt.setString(9,p_gender);
            pstmt.setString(10,pull_type);
            pstmt.setString(11,pull_type);
			if (confirm_yn.equals("F"))
			{
            pstmt.setString(12,facility_id);
			}
            else
			{
			pstmt.setString(12,facility_id);
            pstmt.setString(13,p_fs_locn_code);
            pstmt.setString(14,appt_date);
			pstmt.setString(15,p_fm_clinic_code);
			pstmt.setString(16,p_fm_clinic_code);
			if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
            pstmt.setString(17,facility_id);
			}*/


				
			int pstcnt1 = 0;

			pstmt.setString(++pstcnt1,facility_id);
            pstmt.setString(++pstcnt1,appt_date);
			if(!p_fm_clinic_code.equals(""))
			{
				pstmt.setString(++pstcnt1,p_fm_clinic_code);
			}
            pstmt.setString(++pstcnt1,p_fm_pract_id);
            pstmt.setString(++pstcnt1,p_to_pract_id);
            pstmt.setString(++pstcnt1,p_fm_pract_id);
            pstmt.setString(++pstcnt1,p_to_pract_id);
			pstmt.setString(++pstcnt1,p_gender);
            pstmt.setString(++pstcnt1,p_gender);
            pstmt.setString(++pstcnt1,pull_type);
            pstmt.setString(++pstcnt1,pull_type);
			if (confirm_yn.equals("F"))
			{
				pstmt.setString(++pstcnt1,facility_id);
			}
            else
			{
				pstmt.setString(++pstcnt1,facility_id);
				pstmt.setString(++pstcnt1,p_fs_locn_code);
				pstmt.setString(++pstcnt1,appt_date);
				pstmt.setString(++pstcnt1,p_fm_clinic_code);
				pstmt.setString(++pstcnt1,p_fm_clinic_code);
				if (confirm_yn.equals("Y")||confirm_yn.equals("N")){
					pstmt.setString(++pstcnt1,facility_id);
				}
			}
			
			rs=pstmt.executeQuery();
			rs.beforeFirst();
			rs.last();
			maxRecord = rs.getRow();
			rs.beforeFirst();



		if(maxRecord == 0 && !curr_filestatus.equals("L") && flag.equals("false"))
  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.frames[0].document.forms[0].flag.value='true'; parent.frames[0].document.forms[0].patient_id.value='';parent.frames[0].document.getElementById('patientid1').onblur();parent.frames[0].document.forms[0].patient_id.focus();</script>"); //this line modified for this incident [IN:044324]
	
		}catch(Exception e){out.println(e);
		e.printStackTrace();}


			int p_counter = 1,i = 1;
			String p_next_group_by_clause = "";
			%>
<!-- 				<table width='95%'>
				<tr>
				<td  id='prevNext'  class='BODYCOLORFILLED'>
				<%
					if ( !(start <= 1)) {
				%>
					<a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
				<%
					}
					if ( !((start+10) > maxRecord )){
				%>
					<a href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
				<%
					}
				%> 
				</td>
				</tr>
				</table>-->
					<%
			if(maxRecord != 0)	
			{
			%>
			<table cellpadding='0' cellspacing='0' border='1' width='100%'  >
			
			<%
				if(file_type_appl_yn.equals("Y"))
				{
				%>
			<td width='40%' class='columnheader'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
			<td width='8%' class='columnheader'><fmt:message key="eFM.FileTypeVolumeNo.label" bundle="${fm_labels}"/></td>
					<%
					}else{
					%>
			<td width='40%' class='columnheader'><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
			<td width='10%' class='columnheader'><fmt:message key="Common.volume.label" bundle="${common_labels}"/></td>
					<%
					}
					%>
			<td width='8%' class='columnheader'><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>
			<td width='13%' class='columnheader'><fmt:message key="Common.filecreated.label" bundle="${common_labels}"/>?</td>
			<td width='10%' class='columnheader'><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></td>
			
					<td width='10%' class='columnheader'><%=alt_id2_type%> <fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
			<td width='10%' class='columnheader' nowrap><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/>&nbsp;</td><!--Added by Thamizh selvi on 17th Jan 2018 against ML-MMOH-CRF-0933-->
			<td width='10%' nowrap class='columnheader'><fmt:message key="Common.confirm.label" bundle="${common_labels}"/>?<input type=checkbox name=select_all id=select_all value='' onClick="SelectAll(from,end)" <%=confirm_all_check%> <%=confirm_all_dis%>></td>
		  <%}
		 %>
<%
	if(rs !=null)
	{
		if ( start != 0 )
		{
		 for( int j=1; j<start; i++,j++ ){
		  rs.next() ;
		  }
		}		
		while(rs.next()&&i<=end )
				{					
					file_no				=	rs.getString("file_no");
					file_type_code		=	rs.getString("FILE_TYPE_CODE");
					file_type_desc		=	rs.getString("FILE_TYPE_DESC");
					volume_no			=	rs.getString("VOLUME_NO");
					patient_id			=	rs.getString("patient_id");
					clinic_desc			=	rs.getString("clinic_desc");
					clinic_code			=	rs.getString("clinic_code");
					fs_locn_code		=	rs.getString("src_fs_locn_code");
					fs_locn_desc		=	rs.getString("src_fs_locn_desc");
					practitioner_name	=	rs.getString("practitioner_name");
					practitioner_id		=	rs.getString("practitioner_id");
					curr_file_status	=	rs.getString("curr_file_status");
					curr_file_status1	=	rs.getString("curr_file_status1");
					pat_details			=	rs.getString("pat_details").substring(0,rs.getString("pat_details").length());
					curr_fs_locn_code	=	rs.getString("curr_fs_locn_code");
					curr_facility_id	=	rs.getString("curr_facility_id");
					curr_fs_locn_short_desc = rs.getString("curr_fs_locn_short_desc");
					pull_list_type		=	rs.getString("pull_list_type");
					file_creation_date	=	rs.getString("file_creation_date");
					remarks				=	rs.getString("remarks");
					alt_id2_no			=	rs.getString("alt_id2_no");
					sex					=	rs.getString("sex");
					appt_ref_no			=	rs.getString("appt_ref_no");
					file_pulled_yn		=	rs.getString("file_pulled_yn");					
					appt_status_checked	=   rs.getString("appt_status_checked");
					mr_pat_fs_locn_code	=	rs.getString("mr_pat_fs_locn_code");
					appt_time			=	rs.getString("appt_time");
                   OTHER_APPTS  =	rs.getInt("OTHER_APPTS");
			   // String   appt_Date  =appt_time			=	rs.getString("appt_Date");
			  					
					if(file_no == null || file_no.equals("null"))file_no="";
					if(file_type_code == null || file_type_code.equals("null"))file_type_code="";
					if(file_type_desc == null || file_type_desc.equals("null"))file_type_desc="";
					if(volume_no == null || volume_no.equals("null"))volume_no="";
					if(patient_id == null || patient_id.equals("null"))patient_id="";
					if(clinic_desc == null || clinic_desc.equals("null"))clinic_desc="";				if(clinic_code == null || clinic_code.equals("null"))clinic_code="";
					if(fs_locn_code == null || fs_locn_code.equals("null"))fs_locn_code="";
					if(fs_locn_desc == null || fs_locn_desc.equals("null"))fs_locn_desc="";
					if(practitioner_name == null || practitioner_name.equals("null"))practitioner_name="";
					if(practitioner_id == null || practitioner_id.equals("null"))practitioner_id="";
					if(pat_details == null || pat_details.equals("null"))pat_details="";
					if(curr_file_status == null || curr_file_status.equals("null"))curr_file_status="";
					if(curr_file_status1 == null || curr_file_status1.equals("null"))curr_file_status1="";
					if(curr_fs_locn_code == null || curr_fs_locn_code.equals("null"))curr_fs_locn_code="";
					if(curr_facility_id == null || curr_facility_id.equals("null"))curr_facility_id="";
					if(curr_fs_locn_short_desc == null || curr_fs_locn_short_desc.equals("null"))curr_fs_locn_short_desc="";
					if(pull_list_type == null || pull_list_type.equals("null"))pull_list_type="";
					if(file_creation_date!=null)	
					{
						file_creation_date=DateUtils.convertDate(file_creation_date,"DMY","en",localeName);
					}
					else
						file_creation_date="";

					if(remarks == null || remarks.equals("null"))remarks=p_dflt_remarks;
					if(alt_id2_no == null || alt_id2_no.equals("null"))alt_id2_no="";
					if(sex == null || sex.equals("null"))sex="";
					if(appt_ref_no == null || appt_ref_no.equals("null"))appt_ref_no="";
					if(file_pulled_yn == null || file_pulled_yn.equals("null"))file_pulled_yn="";
					if(appt_status_checked == null || appt_status_checked.equals("null"))appt_status_checked="";
					if(mr_pat_fs_locn_code == null || mr_pat_fs_locn_code.equals("null"))mr_pat_fs_locn_code="";
					if(appt_time == null || appt_time.equals("null"))appt_time="";
					
					if(!sex.equals(""))
					{
						switch(sex.charAt(0))
						{
							case 'M' : sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"); break;

							case 'F' : sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"); break;

							default : sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

							
					
						}
					}
					
					if (confirm_yn.equals("Y")||confirm_yn.equals("N") && (OTHER_APPTS>1))
					{
					//String sql_other_appt ="select b.short_desc  clinic,nvl(c.practitioner_name,'Not Identified')practitioner_name,to_char(a.appt_time,'hh24:mi') appt_time,sign(TO_DATE(TO_CHAR(a.appt_time, 'hh24:mi'), 'hh24:mi')-to_date('"+appt_time+"','hh24:mi')) diff from fm_pulling_list a, op_clinic b, am_practitioner c where a.facility_id     = b.facility_id and a.clinic_code = b.clinic_code and a.practitioner_id = c.practitioner_id(+) and a.facility_id='"+facility_id+"' and trunc(appt_date)= to_date('"+appt_date+"','dd/mm/yyyy') and a.patient_id = '"+patient_id+"' and a.appt_ref_no != '"+appt_ref_no+"' order by appt_time";
					
					String sql_other_appt = "SELECT"
								  +"  OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.CLINIC_CODE,'"+localeName+"','1') Clinic"
								  +"  , Nvl((AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+localeName+"','1')),'Not Identified') Practitioner_Name"
								  +"  , TO_CHAR(a.appt_Time,'hh24:mi') appt_Time"
								  +"  , Sign(TO_DATE(TO_CHAR(a.appt_Time,'hh24:mi'),'hh24:mi') - TO_DATE('"+appt_time+"','hh24:mi')) dIff "
								  +"FROM"
								  +"  fm_PullIng_List a "
								  +"WHERE a.facility_id='"+facility_id+"' "
								  +"  AND trunc(A.appt_date)= TO_DATE('"+appt_date+"','dd/mm/yyyy') "
								  +"  AND a.patient_id = '"+patient_id+"' "
								  +"  AND a.appt_ref_no != '"+appt_ref_no+"' "
								  +"ORDER BY"
								  +"  appt_time";
		  
					rs_other_appt = stmt_other.executeQuery(sql_other_appt);
					other_appt = "";
					dis_oth_flag=false;
					pull_yn_prop="";
					while(rs_other_appt!=null&&rs_other_appt.next())
					{
                    String oth_clinic     = rs_other_appt.getString(1);
					if(oth_clinic == null || oth_clinic.equals("null"))oth_clinic="";
					String oth_pract_name = rs_other_appt.getString(2);
					if(oth_pract_name == null || oth_pract_name.equals("null"))oth_pract_name="";
					String oth_appt_time  = rs_other_appt.getString(3);
					if(oth_appt_time == null || oth_appt_time.equals("null"))oth_appt_time="";
					int  diff  = rs_other_appt.getInt(4);					
					
					if ((diff<0) && (!dis_oth_flag))
						dis_oth_flag = true;
					other_appt = other_appt + "&nbsp;&nbsp;&nbsp;&nbsp;"+oth_clinic+" / "+oth_pract_name +" - "+oth_appt_time;
					other_appt = other_appt +  "<br>";
					}						
					
					
					if(rs_other_appt != null) rs_other_appt.close();
					} else {						
						//Added the below code for SRR20056-SCF-6482 [IN:025931] by Suresh M on 18.01.2001 
						other_appt = "";
						dis_oth_flag=false;
					}
		     classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		   String remarks_bean ="";		   
			if(pullinglistrefno.containsObject(appt_ref_no)) 
					{                   
					file_pulled_yn = "CHECKED";
					}
			else
			file_pulled_yn="";
			int recordIndex = pullinglistrefno.indexOfObject(appt_ref_no);
			if(recordIndex!=-1)
			{
			if(file_pulled_yn.equals("CHECKED")) 
				{ 
				pullinglistrefno.removeObject(recordIndex);
				pullinglistFileNo.removeObject(recordIndex);
				pullinglistVolumeNo.removeObject(recordIndex);
				pullinglistpatientId.removeObject(recordIndex);
			    remarks_bean=(String)pullinglistremarks.getObject(recordIndex);
				if (remarks_bean=="")remarks_bean=remarks;
				if (!remarks_bean.equals(remarks))
				remarks = remarks_bean;
				pullinglistremarks.removeObject(recordIndex);                            
				}
			}
		    appt_status="";			
			if (dis_oth_flag) {
			pull_yn_prop="disabled";
			file_pulled_yn="";
			}
			else
			{
				pull_yn_prop="";
				file_pulled_yn="CHECKED";
			}			
			
	  	if (confirm_yn.equals("C"))
		{
			pull_yn_prop="disabled";
			appt_status_color="#FF0066";
			file_pulled_yn="";
		}
		else if (confirm_yn.equals("S"))
		{
			pull_yn_prop="disabled";
			appt_status_color="FF9999";
			file_pulled_yn="";
		}
		else if (confirm_yn.equals("T"))
		{
			pull_yn_prop="disabled";
			appt_status_color="#FF66FF";
			file_pulled_yn="";
		}
		else if (confirm_yn.equals("Y"))
		{
		    appt_status_color = "SkyBlue";
		}
        else
		{
			appt_status_color = "";
		}
		if (facility_id.equals(curr_facility_id) && mr_pat_fs_locn_code.equals(curr_fs_locn_code) && !curr_file_status1.equals("T"))
		{

		}
		else
		{
		 if (confirm_yn.equals("F"))          
			{
			file_pulled_yn="";
			pull_yn_prop="disabled";
			appt_status_color="lightgreen";
			appt_status="X";					
			}
		}


			tblrow_id	=	"tblrow_id"+i;
			p_next_group_by_clause = clinic_desc + " / " + practitioner_name + " / " + sex;
		if (p_counter==0)
		{
			p_group_by_clause	= clinic_desc + " / " + practitioner_name + " / " + sex;
%>
        <tr>
            <td  width="100%" height="20" colspan=8 class='CAGROUPHEADING' ><b><%=p_group_by_clause%></b></td>
        </tr>
<%
		}
        else if (!p_group_by_clause.equals(p_next_group_by_clause))
            {
%>
        <tr>
            <td  width="100%" height="20" colspan=8 class='CAGROUPHEADING' ><b><%=p_next_group_by_clause%></b></td>
        </tr>
<%
            }
			p_group_by_clause = p_next_group_by_clause ;
		%>
			<tr id='<%=tblrow_id%>'>
			<td class='<%=classValue%>' nowrap width=40%>
			<%
			if(file_type_appl_yn.equals("N") ){
			%>
			<font size='1'><b>			
			<%=((file_no.equals(""))?"&nbsp;":file_no)%>			
				</font></b> / <%
			}
			%><font size='1'><%=((patient_id.equals(""))?"&nbsp;":patient_id)%>&nbsp;<%=((pat_details.equals(""))?"&nbsp;":pat_details)%></font><input type=hidden name=p_file_no<%=i% id=p_file_no<%=i%> value=<%=file_no%>><input type=hidden name=p_appt_ref_no<%=i% id=p_appt_ref_no<%=i%> value=<%=appt_ref_no%>><input type=hidden name=p_patient_id<%=i% id=p_patient_id<%=i%> value=<%=patient_id%>><input type=hidden name=p_volume_no<%=i% id=p_volume_no<%=i%> value=<%=volume_no%>></td>
				<td class='<%=classValue%>' align='center' width=7%><font size='1'><%
			if(file_type_appl_yn.equals("Y") && !file_type_code.equals("")){
			%>
			<%=((file_type_code.equals(""))?"&nbsp;":file_type_desc)%>/<%=((volume_no.equals(""))?"&nbsp;":volume_no)%>
			<%
			}else{
				%>
			<%=((volume_no.equals(""))?"&nbsp;":volume_no)%>
			
			<%
			}
			%></font></td>
			<td class='<%=classValue%>' align='center' width=10%><font size='1'><%=((appt_time.equals(""))?"&nbsp;":appt_time)%></font></td>
			<td class='<%=classValue%>' align='center' width=13%><font size='1'><%=((file_creation_date.equals(""))?"&nbsp;":file_creation_date)%></font></td>
		<%
			if (confirm_yn.equals("C") || confirm_yn.equals("S") || appt_status.equals("X") || confirm_yn.equals("T")||dis_oth_flag)
			{
		%>
				<td class='<%=classValue%>' align='center' width=10%><font size='1'>&nbsp;</font></td>
				<input type=hidden name=p_remarks<%=i% id=p_remarks<%=i%> value="<%=remarks%>" >
		<%
			}
			else if (appt_status.equals("W") && appt_status_checked.equals("Y"))
			{
		%>
				<td class='<%=classValue%>' align='center' width=10%><font size='1'><a href='javascript:GetRemarks(<%=i%>,"<%=java.net.URLEncoder.encode(remarks)%>")'><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/> </a></font></td>
				<input type=hidden name=p_remarks<%=i% id=p_remarks<%=i%> value="<%=remarks%>" >
		<%	
			}
			else if (appt_status.equals("W") && appt_status_checked.equals("N"))
			{
		%>
				<td class='<%=classValue%>' align='center' width=10%><font size='1'>&nbsp;</font></td>
				<input type=hidden name=p_remarks<%=i% id=p_remarks<%=i%> value="<%=remarks%>" >
		<%	
			}
			else
			{
		%>
				<td class='<%=classValue%>' align='center' width=10%><font size='1'><a href='javascript:GetRemarks(<%=i%>,"<%=java.net.URLEncoder.encode(remarks)%>")'><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/> </a></font></td>
				<input type=hidden name=p_remarks<%=i% id=p_remarks<%=i%> value="<%=remarks%>" >
		<%	
			}
		%>
			<input type='hidden' name='rem_recnum_<%=i%>' value=''>

			<td class='<%=classValue%>' width=10%><font size='1'><%=((alt_id2_no.equals(""))?"&nbsp;":alt_id2_no)%></font></td>
			<td class='<%=classValue%>' width='10%'><font size='1'><%=((curr_fs_locn_short_desc.equals(""))?"&nbsp;":curr_fs_locn_short_desc)%></font></td><!--Added by Thamizh selvi on 17th Jan 2018 agains ML-MMOH-CRF-0933-->
			<td class="<%=classValue%>" align=center width=12% style=background-color:<%=appt_status_color%>><input type='checkbox' name='pull_yn<%=i%>'  value='Y'  <%=file_pulled_yn%> onClick="UnselectPullAll(this)" onTest='CBValue(this,"<%=i%>");' <%=pull_yn_prop%> ></td>
			</tr>
		<%
				
           if (!other_appt.equals(""))
			{
			%>
			<tr>
            <td colspan = '8'><font size='1'>
			<%=other_appt%></font>
			</td>
			</tr>
		<%
			}
			p_counter++;
					i++;
				}
				total_count = p_counter;
%>
				<script>			

				parent.frames[0].document.forms[0].fs_locn_code.disabled=false;
				parent.frames[0].document.forms[0].appt_date.disabled=false;
				parent.frames[0].document.forms[0].p_gender.disabled=false;
				parent.frames[0].document.forms[0].fm_clinic_code.disabled=false;
				parent.frames[0].document.forms[0].fm_pract_id.disabled=false;				
				parent.frames[0].document.forms[0].confirm_yn.disabled=false;
				parent.frames[0].document.forms[0].pull_type.disabled=false;
				parent.frames[0].document.forms[0].subBotton.disabled=false;
				parent.frames[0].document.forms[0].pract_id.disabled=false;				

				</script>		
			<%
			}
			if(rs != null) rs.close();
			if (p_counter==0 && !curr_filestatus.equals("L"))
			{
				//String	msg1="APP-FM0061 No records found";				
			%>
				<script>
				var msg1=getMessage("FM_NO_RECORDS_FOUND","FM");	
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+ msg1+"&err_value=0";
                 parent.frames[0].document.forms[0].flag.value="true";
					parent.frames[0].document.forms[0].fs_locn_code.disabled=false;
				parent.frames[0].document.forms[0].appt_date.disabled=false;
				parent.frames[0].document.forms[0].p_gender.disabled=false;
				parent.frames[0].document.forms[0].fm_clinic_code.disabled=false;
				parent.frames[0].document.forms[0].fm_pract_id.disabled=false;				
				parent.frames[0].document.forms[0].confirm_yn.disabled=false;
				parent.frames[0].document.forms[0].pull_type.disabled=false;
				parent.frames[0].document.forms[0].subBotton.disabled=false;
				parent.frames[0].document.forms[0].pract_id.disabled=false;				

				</script>		
			<%
			}
if (curr_filestatus.equals("L"))
			{
				//String	msg1="APP-FM0061 No records found";				
			%>
				<script>
				var msg1=getMessage('FILE_IS_LOST','FM');	
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+ msg1+"&err_value=0";
            //     parent.frames[0].document.forms[0].flag.value="true";
					parent.frames[0].document.forms[0].fs_locn_code.disabled=false;
				parent.frames[0].document.forms[0].appt_date.disabled=false;
				parent.frames[0].document.forms[0].p_gender.disabled=false;
				parent.frames[0].document.forms[0].fm_clinic_code.disabled=false;
				parent.frames[0].document.forms[0].fm_pract_id.disabled=false;				
				parent.frames[0].document.forms[0].confirm_yn.disabled=false;
				parent.frames[0].document.forms[0].pull_type.disabled=false;
				parent.frames[0].document.forms[0].subBotton.disabled=false;
				parent.frames[0].document.forms[0].pract_id.disabled=false;				

				</script>	
		
		
	<%	
			}
	}

%>
<script>
</script>

</table>

<input type='hidden' name='from' id='from' value='<%=start%>'>
<input type='hidden' name='to' id='to' value='<%=end%>'>
<input type='hidden' name='start' id='start' value='<%=start%>'>
<input type='hidden' name='end' id='end' value='<%=end%>'>
<input type='hidden' name='fs_locn_code' id='fs_locn_code' value='<%=fs_locn_code%>'>
<input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=appl_user_id%>'>
<input type='hidden' name='gender' id='gender' value='<%=p_gender%>'>
<input type='hidden' name='appt_date' id='appt_date' value='<%=appt_date%>'>
<input type='hidden' name='fm_clinic_code' id='fm_clinic_code' value='<%=p_fm_clinic_code%>'>
<input type='hidden' name='fm_pract_id' id='fm_pract_id' value='<%=p_fm_pract_id%>'>
<input type='hidden' name='to_pract_id' id='to_pract_id' value='<%=p_to_pract_id%>'>
<input type='hidden' name='confirm_yn' id='confirm_yn' value='<%=confirm_yn%>'>

<input type='hidden' name='row_count' id='row_count' value='<%=row_count%>'>
<input type='hidden' name='fm_disp' id='fm_disp' value='<%=fm_disp%>'>
<input type='hidden' name='to_disp' id='to_disp' value='<%=to_disp%>'>
<input type='hidden' name='p_counter' id='p_counter' value='<%=total_count%>'>
<input type='hidden' name='operation' id='operation' value='modify'>
<input type='hidden' name='p_concat_string' id='p_concat_string' value=''>
<input type='hidden' name='p_gender' id='p_gender' value='<%=p_gender%>'>
<input type='hidden' name='check' id='check' value='<%=check%>'>

<input type='hidden' name='print_pulled_list' id='print_pulled_list' value=''>
<input type='hidden' name='print_tracer_card' id='print_tracer_card' value=''>
<input type='hidden' name='print_req_slip' id='print_req_slip' value=''>
<input type='hidden' name='p_fs_locn_code' id='p_fs_locn_code' value='<%=p_fs_locn_code%>'>
<input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=appl_user_id%>'>
<input type='hidden' name='where_cond' id='where_cond' value="<%=java.net.URLEncoder.encode(where_cond)%>">
<input type='hidden' name='pull_type' id='pull_type' value="<%=pull_type%>">
<input type='hidden' name='start_time' id='start_time' value='<%=start_time%>'>
<input type='hidden' name='end_time' id='end_time' value='<%=end_time%>'>
<input type='hidden' name='print_bar_code' id='print_bar_code'  value="Y" /> <!--Added by Dharma on Dec 23rd 2014 against HSA-SCF-0088.1 [IN:052889] -->

</form>

<%
if(rset3 != null) rset3.close();
if(rs1 != null) rs1.close();
if(stmt != null) stmt.close();
if(pstmt1 != null) pstmt1.close();
if(pstmt != null) pstmt.close();
if(stmt_other != null) stmt_other.close();
if(rs_other_appt != null) rs_other_appt.close();
}
catch(Exception e)
{
	out.println("Exception in fetching connection"+e.toString());
	e.printStackTrace();
}
finally
{	
	ConnectionManager.returnConnection(con,request);
	session.setAttribute("pullinglistrefno", pullinglistrefno);
	session.setAttribute("pullinglistremarks", pullinglistremarks);
	session.setAttribute("pullinglistFileNo", pullinglistFileNo);
	session.setAttribute("pullinglistVolumeNo", pullinglistVolumeNo);
	session.setAttribute("pullinglistpatientId", pullinglistpatientId);
}
%>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script LANGUAGE="JavaScript">
parent.frames[1].clearpatid();
//parent.frames[1].document.forms[0].patient_id.value='';
//parent.frames[1].document.getElementById('patientid1').onblur();
</SCRIPT>
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

