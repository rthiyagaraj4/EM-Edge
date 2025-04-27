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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMIPConfirmPullingList.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

</head>
<body  onLoad='dispRecord(); loadCurrPage();' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='FMConfirmPullingListForm' id='FMConfirmPullingListForm' action='FMIPConfirmPullingListResults.jsp' method='post'>
<%!
	int row_count=0;
	int total_count=0;
%>
<%
	Connection con			=	null;
	Statement stmt			=	null;
	PreparedStatement pstmt =	null;
	ResultSet rs			=	null;
	PreparedStatement pstmt1 =	null;
	ResultSet rs1			=	null;
	ResultSet rs_other_appt	=	null;
	ResultSet rset3			=	null;	
//	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
//	String addedById	= p.getProperty( "login_user" ) ;
	String other_appt= "",preferred_date="",preferred_date1="",confirm_all_check="";
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();		
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		String alt_id2_type ="";
		String file_type_appl_yn ="";
		boolean dis_oth_flag = false;
		String facility_id=(String)session.getValue("facility_id");
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i1=1;
        int reccnt=0;
		if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }        
            
        String  req_start   =   "", req_end     =   "",confirm_all_dis="";		        
	    String flagSelect		= request.getParameter("flagSelect");
		preferred_date				=request.getParameter("preferred_date");
		String p_gender			= request.getParameter("gender");
		String p_fm_nursing_unit_code	= request.getParameter("fm_nursing_unit_code");
		String p_fm_pract_id	= request.getParameter("fm_pract_id");
		String pull_type		= request.getParameter("pull_type");
		String p_to_pract_id	= request.getParameter("to_pract_id");
		String p_fs_locn_code	= request.getParameter("fs_locn_code");		
		String confirm_yn		= request.getParameter("confirm_yn");
		String check			= request.getParameter("check");
		String added_file_vol	= request.getParameter("added_file_vol");
		String temp=request.getParameter("temp");
	    String flag="false";		  
		String where_cond="";
		String patient_id1=request.getParameter("patient_id");
		String filenum=request.getParameter("filenum");
		String volume_no1=request.getParameter("volume_no");
		String  str1="";
		String curr_filestatus="";
		if(preferred_date==null)
		{
		preferred_date="";	
		//preferred_date=DateUtils.convertDate(preferred_date,"DMY",localeName,"en");
		} else{
      preferred_date1=preferred_date;
	   preferred_date=DateUtils.convertDate(preferred_date,"DMY",localeName,"en");
		}
			
		if(p_gender==null)			p_gender="";
		if(pull_type==null)			pull_type="";
		if(check==null)				check="";
		if(p_fm_nursing_unit_code==null)	p_fm_nursing_unit_code="";
		if(p_fm_pract_id==null)		p_fm_pract_id="";
		if(p_to_pract_id==null)		p_to_pract_id="";
		if(p_fs_locn_code==null)	p_fs_locn_code="";
		if(added_file_vol==null)	added_file_vol="";
		if(patient_id1==null)			patient_id1="";
		if(filenum==null)			filenum="";
		if(volume_no1==null)			volume_no1="";
		
		//where_cond = "where a.patient_id=c.patient_id and a.facility_id=? and a.preferred_date = to_date(?,'dd/mm/yyyy') and a.facility_id=b.facility_id and a.file_no=b.file_no and a.volume_no=b.volume_no and a.nursing_unit_code = nvl(?,'!')  and (a.practitioner_id is null or a.practitioner_id between nvl(?,'!') and nvl(?,'~')) and ( ? is null or ? is null or a.practitioner_id is not null)and c.sex=decode(?,'A',c.sex,?) and a.facility_id=d.facility_id AND a.src_fs_locn_code=d.src_fs_locn_code and d.nursing_unit_code = a.nursing_unit_code and a.preferred_date=d.preferred_date and a.nursing_unit_code=e.nursing_unit_code and a.facility_id=e.facility_id and e.fs_locn_code=d.dest_fs_locn_code  and a.facility_id=f.facility_id(+) and a.bkg_lst_ref_no=f.bkg_lst_ref_no(+) and a.auto_track_yn = 'N' and a.pull_list_type=decode(?,'A',a.pull_list_type,?)";
		
		
		   if(!filenum.equals(""))
     { 
      str1="select curr_file_status from fm_curr_locn where facility_id = '"+facility_id+"' and patient_id='"+patient_id1+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";
     
		System.out.println(" ************** Inside FMIPConfirmPullingListResults jsp 117 str1 : "+str1);
		pstmt	= con.prepareStatement(str1);
		rs		= pstmt.executeQuery();
	if(rs != null)
	{
		if(rs.next())
		{
	     curr_filestatus=rs.getString("curr_file_status");
		
		}
	}	
	
	}

	
  if(rs!=null)	rs.close();
  if(pstmt != null) pstmt.close();
  
  System.out.println(" ************** Inside FMIPConfirmPullingListResults jsp 135 curr_filestatus : "+curr_filestatus);
		
		
		where_cond = "where a.patient_id=c.patient_id and a.facility_id=? and a.preferred_date = to_date(?,'dd/mm/yyyy') and a.facility_id=b.facility_id and a.file_no=b.file_no and a.volume_no=b.volume_no ";
		if(!p_fm_nursing_unit_code.equals(""))
		{
		where_cond = where_cond + " and a.nursing_unit_code = nvl(?,'!')";
		}
		
		where_cond = where_cond + "and (a.practitioner_id is null or a.practitioner_id between nvl(?,'!') and nvl(?,'~')) and ( ? is null or ? is null or a.practitioner_id is not null)and c.sex=decode(?,'A',c.sex,?) and a.facility_id=d.facility_id AND a.src_fs_locn_code=d.src_fs_locn_code and d.nursing_unit_code = a.nursing_unit_code and a.preferred_date=d.preferred_date and  a.facility_id=f.facility_id(+) and a.bkg_lst_ref_no=f.bkg_lst_ref_no(+) and a.auto_track_yn = 'N' and a.pull_list_type=decode(?,'A',a.pull_list_type,?)";

        String ret_status = "and fm_return_booking_status(?,?,?,?,?,a.bkg_lst_ref_no,a.patient_id)";
		if (confirm_yn.equals("C"))
			where_cond =  where_cond + ret_status + " ='C'";
		else if (confirm_yn.equals("T"))
			where_cond =  where_cond + ret_status + " ='T'";				
		else if (confirm_yn.equals("S"))
			where_cond = where_cond + ret_status + " ='S'";	
		else if (confirm_yn.equals("F"))
			where_cond = where_cond +" and (curr_facility_id != ? or b.PERM_FS_LOCN_CODE != b.curr_fs_locn_code and b.curr_file_status!='T' )";
		else if (confirm_yn.equals("N"))
		    where_cond = where_cond + ret_status + " not in ('C','T','S') and a.CONFIRM_YN ='N' and (curr_facility_id = ? and b.PERM_FS_LOCN_CODE = b.curr_fs_locn_code) and b.curr_file_status NOT in('O','R','T','E','A')";	 
		    //where_cond = where_cond + ret_status + " not in ('C','T','S') and file_pulled_yn ='N' and (curr_facility_id = ? and b.PERM_FS_LOCN_CODE = b.curr_fs_locn_code)";	 

		else if (confirm_yn.equals("Y"))
			where_cond = where_cond + ret_status + " not in ('C','T','S') and a.CONFIRM_YN ='Y' and (curr_facility_id = ? and b.PERM_FS_LOCN_CODE = b.curr_fs_locn_code) and b.curr_file_status NOT in('O','R','T','E','A') ";	 
			//where_cond = where_cond + ret_status + " not in ('C','T','S') and file_pulled_yn ='Y' and (curr_facility_id = ? and b.PERM_FS_LOCN_CODE = b.curr_fs_locn_code)";	 
			confirm_all_check="";
			confirm_all_dis="disabled";
		if(confirm_yn.equals("Y")||confirm_yn.equals("N"))
			{
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
			
			System.out.println(" ************** Inside FMIPConfirmPullingListResults jsp 182 alt_id2_type : "+alt_id2_type+ " file_type_appl_yn : "+file_type_appl_yn);
			
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
			pullinglistVolumeNo.clearAll();
			pullinglistpatientId.clearAll();
		 	confirm_all_check="checked";			
			if(pstmt != null) pstmt.close();
			StringBuffer rePopulate = null;
			StringBuffer rePopulate1 = null;
			rePopulate				 = new StringBuffer();
			rePopulate1				 = new StringBuffer();
			rePopulate.append("select a.patient_id,a.file_no,a.volume_no, a.bkg_lst_ref_no, a.remarks from fm_ip_pulling_list a,fm_curr_locn b where a.facility_id = ? and a.preferred_date= to_date(?,'dd/mm/yyyy') and b.curr_file_status NOT IN ('O', 'R', 'T', 'E', 'A')  AND a.facility_id = b.facility_id AND a.file_no = b.file_no  AND a.volume_no = b.volume_no ");
			if(!p_fm_nursing_unit_code.equals(""))
			{
			rePopulate.append(" and a.nursing_unit_code =nvl(?,'!') ");
			}
			rePopulate.append("and (a.practitioner_id is null or a.practitioner_id between nvl(?,'!') and nvl(?,'~')) and (? is null or ? is null or a.practitioner_id is not null)and a.src_fs_locn_code=? and a.confirm_yn = ? and a.pull_list_type = decode(?,'A',a.pull_list_type,?)");
			if (!p_gender.equals("A"))
			rePopulate.append(" and a.patient_id in (select patient_id from mp_patient where sex = decode(?,'A',sex,?)) ");
			rePopulate1=rePopulate;
	/*	if(!patient_id1.equals("") && !filenum.equals("") && !volume_no1.equals("") )
				{
		rePopulate1.append(" and patient_id ='"+patient_id1+"'  and file_no='"+filenum+"' and volume_no='"+volume_no1+"' ");
				} */
			
			if(!added_file_vol.equals(""))
			{
				if(!added_file_vol.equals(temp)){					
					rePopulate1.append(" and (a.FILE_NO,a.VOLUME_NO,a.patient_id) IN ("+temp+")  ");
				}else{
				rePopulate.append(" and (a.FILE_NO,a.VOLUME_NO,a.patient_id) IN ("+added_file_vol+")  ");
				}
			}

				System.out.println(" ************** Inside FMIPConfirmPullingListResults jsp 182 rePopulate : "+rePopulate.toString()+ " \n rePopulate1 : "+rePopulate1.toString());
			
			pstmt		=	con.prepareStatement(rePopulate.toString());
    			
			pstmt1		=	con.prepareStatement(rePopulate1.toString());
			int pstcnt = 0;
			int pstcnt1 = 0;
			pstmt.setString(++pstcnt,facility_id);
			pstmt.setString(++pstcnt,preferred_date);
			pstmt1.setString(++pstcnt1,facility_id);
			pstmt1.setString(++pstcnt1,preferred_date);
				
			if(!p_fm_nursing_unit_code.equals(""))
			{
			pstmt.setString(++pstcnt,p_fm_nursing_unit_code);
			pstmt1.setString(++pstcnt1,p_fm_nursing_unit_code);
			}
			pstmt.setString(++pstcnt,p_fm_pract_id);
			pstmt.setString(++pstcnt,p_to_pract_id);
			pstmt.setString(++pstcnt,p_fm_pract_id);
			pstmt.setString(++pstcnt,p_to_pract_id);
			pstmt.setString(++pstcnt,p_fs_locn_code);
			pstmt.setString(++pstcnt,confirm_yn);
			pstmt.setString(++pstcnt,pull_type);
			pstmt.setString(++pstcnt,pull_type);
			
			pstmt1.setString(++pstcnt1,p_fm_pract_id);
			pstmt1.setString(++pstcnt1,p_to_pract_id);
			pstmt1.setString(++pstcnt1,p_fm_pract_id);
			pstmt1.setString(++pstcnt1,p_to_pract_id);
			pstmt1.setString(++pstcnt1,p_fs_locn_code);
			pstmt1.setString(++pstcnt1,confirm_yn);
			pstmt1.setString(++pstcnt1,pull_type);
			pstmt1.setString(++pstcnt1,pull_type);
			
			if (!p_gender.equals("A"))
				{
				pstmt.setString(++pstcnt,p_gender);
				pstmt.setString(++pstcnt,p_gender);
				
				pstmt1.setString(++pstcnt1,p_gender);
				pstmt1.setString(++pstcnt1,p_gender);
				}
		
		rset3 = pstmt.executeQuery();
			if(!patient_id1.equals(""))
				{
			rs1=pstmt1.executeQuery();
			if(rs1 !=null)
			{
				 while(rs1.next())
				 {
				   reccnt++;
	 				 }
			   }
		
		if(reccnt==0 && !patient_id1.equals("") )	
				{
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));	</script>");
			flag="true"	;
			}
				}
			
			
			String remarks1 ="";
			String volume1 = "";
			if(rset3 !=null)
			{
				 while(rset3.next())
				 {
					
						pullinglistrefno.putObject(rset3.getString("bkg_lst_ref_no"));
					pullinglistFileNo.putObject(rset3.getString("file_no"));				
					pullinglistpatientId.putObject(rset3.getString("patient_id"));
						volume1 = rset3.getString("volume_no");
					if(volume1 == null) volume1="";
				    	pullinglistVolumeNo.putObject(volume1);
					remarks1 = rset3.getString("remarks");
					if(remarks1 == null) remarks1="";
				    pullinglistremarks.putObject(remarks1);

				}
			}
			if(rset3 != null) rset3.close();
			if(pstmt != null) pstmt.close();
			//}
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
                        String checkedBkgLstRefNo = request.getParameter("p_bkg_lst_ref_no"+(i1));
                        
						
						String checkedRemarks=request.getParameter("p_remarks"+(i1));
                        String checkedFileNo=request.getParameter("p_file_no"+(i1));
						String checkedVolumeNo=request.getParameter("p_volume_no"+(i1));
                        String checkedPatientID=request.getParameter("p_patient_id"+(i1));
                   //     String Appt_Time=request.getParameter("p_remarks"+(i1));
                        if(checkedRemarks == null) checkedRemarks="";
                        if(!(pullinglistrefno.containsObject(checkedBkgLstRefNo))) { 
                            pullinglistrefno.putObject(checkedBkgLstRefNo);
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
		
		String file_no="", patient_id="", tblrow_id="",classValue="";//pull_yn="N",
		String pat_details="",	nursing_unit_desc="", nursing_unit_code="",fs_locn_code="",curr_file_status="",pull_yn_prop="";
		String fs_locn_desc="",practitioner_name="",practitioner_id="",result_query="";
		String curr_fs_locn_code="", curr_facility_id="",curr_file_status1="",curr_fs_locn_short_desc="";
		String pull_list_type="",booking_status="",file_creation_date="",remarks="";
		String booking_status_color="",alt_id2_no="",sex="",bkg_lst_ref_no="",file_pulled_yn="";
		String file_type_code="";
		String file_type_desc="";
		String volume_no = "";
	
		String mode			=	request.getParameter("mode") ;
				
		String appl_user_id		= request.getParameter("appl_user_id");
		String p_dflt_remarks	= "",mr_pat_fs_locn_code="" ,preferred_time="";
		String p_group_by_clause = "",booking_status_checked="";
		if(mode == null || mode.equals("null")) mode="";
		if(appl_user_id == null || appl_user_id.equals("null")) mode="";
		if (p_fm_nursing_unit_code==null) p_fm_nursing_unit_code="";
		if (p_fm_pract_id==null) p_fm_pract_id="";
		if (p_to_pract_id==null) p_to_pract_id="";
		if ( to == null )
	  		end = 10 ;
		else
			end = Integer.parseInt( to ) ;

		result_query = "select long_desc from fm_parameter a,fm_narration b where a.facility_id='"+facility_id+"' and a.dflt_narr_code_for_auto_track = b.narration_code";

		rs = stmt.executeQuery(result_query);
		result_query="";
       
		while (rs.next())
		{
			p_dflt_remarks = rs.getString("long_desc");
		}
		if(rs != null) rs.close();
		if(mode.equals(""))
		{
		//result_query="select to_char(f.preferred_date,'hh24:mi') preferred_time,a.file_no,a.FILE_TYPE_CODE,a.FILE_TYPE_DESC,a.VOLUME_NO, a.patient_id, to_char(b.file_creation_date,'dd/mm/rrrr') file_creation_date, a.nursing_unit_desc, a.nursing_unit_code, a.src_fs_locn_code, a.DEST_FS_LOCN_DESC src_fs_locn_desc, nvl(a.practitioner_name,'Not Identified') practitioner_name	 , a.practitioner_id, c.patient_name pat_details/*get_patient_line(a.patient_id) pat_details*/ , decode(b.curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived', 'O', 'Outside' ) curr_file_status,curr_file_status curr_file_status1,b.curr_fs_locn_code,b.curr_facility_id,b.curr_fs_locn_short_desc || '<br>&nbsp;&nbsp;&nbsp;' || '(' || decode(b.curr_fs_locn_identity,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','Procedure Unit','Y','Daycare Unit') || ')' curr_fs_locn_short_desc, a.pull_list_type,a.remarks,c.alt_id2_no,decode(c.sex,'M','Male','F','Female','Unknown')sex,a.bkg_lst_ref_no,a.pulled_file_status file_pulled_yn,(case when a.preferred_date=to_date(?,'dd/mm/yyyy') then 'Y' else 'N' end)booking_status_checked,b.mr_pat_fs_locn_code  from fm_ip_pulling_list_vw a,fm_curr_locn_vw b,mp_patient c,fm_ip_pulling_list_ctl d,ip_nursing_unit e,ip_booking_list f  ";			
		result_query="select to_char(f.preferred_date,'hh24:mi') preferred_time, a.file_no, a.FILE_TYPE_CODE, MR_GET_DESC.MR_FILE_TYPE(A.FACILITY_ID,  A.FILE_TYPE_CODE,'"+localeName+"','2') FILE_TYPE_DESC, a.VOLUME_NO, a.patient_id, to_char(b.ADDED_date,'dd/mm/rrrr') file_creation_date, IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.NURSING_UNIT_CODE,'"+localeName+"','1') nursing_unit_desc, a.nursing_unit_code, a.src_fs_locn_code, FM_GET_DESC.FM_STORAGE_LOCN(A.FACILITY_ID, A.src_fs_locn_code,'"+localeName+"','2') src_fs_locn_desc, nvl(AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+localeName+"','1'),'Not Identified') practitioner_name, a.practitioner_id, decode('"+localeName+"', 'en', c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name)) pat_details, b.curr_file_status curr_file_status, curr_file_status curr_file_status1, b.curr_fs_locn_code, b.curr_facility_id, FM_GET_DESC.FM_STORAGE_LOCN(B.CURR_FACILITY_ID, B.curr_fs_locn_code,'"+localeName+"','2') || '&nbsp;' || '(' || decode(b.curr_fs_locn_identity,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','Procedure Unit','Y','Daycare Unit') || ')' curr_fs_locn_short_desc, a.pull_list_type, a.remarks, c.alt_id2_no, c.sex sex, a.bkg_lst_ref_no, a.CONFIRM_YN file_pulled_yn, (case when a.preferred_date=to_date(?,'dd/mm/yyyy') then 'Y' else 'N' end)booking_status_checked, b.PERM_FS_LOCN_CODE from fm_ip_pulling_list a, fm_curr_locn b, mp_patient c, fm_ip_pulling_list_ctl d, ip_booking_list f ";			
		result_query = result_query + where_cond;
		if(!added_file_vol.equals(""))
		{
				result_query=result_query+" and (b.FILE_NO,b.VOLUME_NO,B.patient_id) IN ("+added_file_vol+")  ";
		}
		result_query =result_query +  " order by a.nursing_unit_code,a.practitioner_id,c.sex,f.preferred_date, b.terminal_digit,a.file_no, b.TERMINAL_DIGIT_GRP1,b.TERMINAL_DIGIT_GRP2,b.TERMINAL_DIGIT_GRP3";
		
    	try{
			
			pstmt		=	con.prepareStatement(result_query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			int pstcnt1 = 0;

			
  			pstmt.setString(++pstcnt1,preferred_date);
            pstmt.setString(++pstcnt1,facility_id);
            pstmt.setString(++pstcnt1,preferred_date);
				
			if(!p_fm_nursing_unit_code.equals(""))
			{
            pstmt.setString(++pstcnt1,p_fm_nursing_unit_code);
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
            pstmt.setString(++pstcnt1,preferred_date);
			pstmt.setString(++pstcnt1,p_fm_nursing_unit_code);
			pstmt.setString(++pstcnt1,p_fm_nursing_unit_code);
			
			
			if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
            pstmt.setString(++pstcnt1,facility_id);
			}

           /* pstmt.setString(1,preferred_date);
            pstmt.setString(2,facility_id);
            pstmt.setString(3,preferred_date);
            pstmt.setString(4,p_fm_nursing_unit_code);
            pstmt.setString(5,p_fm_pract_id);
            pstmt.setString(6,p_to_pract_id);
            pstmt.setString(7,p_fm_pract_id);
            pstmt.setString(8,p_to_pract_id);
			pstmt.setString(9,p_gender);
            pstmt.setString(10,p_gender);
            pstmt.setString(11,pull_type);
            pstmt.setString(12,pull_type);
			if (confirm_yn.equals("F"))
			{
            pstmt.setString(13,facility_id);
			}
            else
			{
			pstmt.setString(13,facility_id);
            pstmt.setString(14,p_fs_locn_code);
            pstmt.setString(15,preferred_date);
			pstmt.setString(16,p_fm_nursing_unit_code);
			pstmt.setString(17,p_fm_nursing_unit_code);
			if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
            pstmt.setString(18,facility_id);
			}*/

			rs=pstmt.executeQuery();
			rs.beforeFirst();
			rs.last();
			maxRecord = rs.getRow();
			rs.beforeFirst();
		if(maxRecord == 0 && !curr_filestatus.equals("L") && flag.equals("false"))
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));	parent.frames[0].document.forms[0].flag.value='true';</script>");
		}catch(Exception e){out.println(e);
		e.printStackTrace();}


			int p_counter = 1,i = 1;
			String p_next_group_by_clause = "";
			
			if(maxRecord != 0)	
			{
			%>
				<table width='95%'>
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
				</table>
					
			<table cellpadding='0' cellspacing='0' border='1' width='100%'  >
			
			<%
				if(file_type_appl_yn.equals("Y"))
				{
				%>
			<td width='38%' class='columnheader'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
			<td width='8%' class='columnheader'><fmt:message key="eFM.FileTypeVolumeNo.label" bundle="${fm_labels}"/></td>
					<%
					}else{
					%>
			<td width='38%' class='columnheader'><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
			<td width='8%' class='columnheader'><fmt:message key="Common.volume.label" bundle="${common_labels}"/></td>
					<%
					}
					%>			
			<td width='8%' class='columnheader'><fmt:message key="eFM.PreferredTime.label" bundle="${fm_labels}"/></td>
			<td width='13%' class='columnheader'><fmt:message key="Common.filecreated.label" bundle="${common_labels}"/>?</td>
			<td width='10%' class='columnheader'><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></td>
			<td width='10%' class='columnheader'><%=alt_id2_type%> No</td>
			<td width='10%' class='columnheader' nowrap><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/>&nbsp;</td><!--Added by Thamizh selvi on 22nd Jan 2018 against ML-MMOH-CRF-0933-->
			<td width='10%' nowrap class='columnheader'><fmt:message key="Common.confirm.label" bundle="${common_labels}"/>?<input type=checkbox name=select_all value='' onClick="SelectAll(from,end)" <%=confirm_all_check%> <%=confirm_all_dis%>></td></td>
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
					nursing_unit_desc			=	rs.getString("nursing_unit_desc");
					nursing_unit_code			=	rs.getString("nursing_unit_code");
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
					bkg_lst_ref_no			=	rs.getString("bkg_lst_ref_no");
					file_pulled_yn		=	rs.getString("file_pulled_yn");
					booking_status_checked	=   rs.getString("booking_status_checked");
					mr_pat_fs_locn_code	=	rs.getString("PERM_FS_LOCN_CODE");
					preferred_time			=	rs.getString("preferred_time");

					if(file_no == null || file_no.equals("null"))file_no="";
					if(file_type_code == null || file_type_code.equals("null"))file_type_code="";
					if(file_type_desc == null || file_type_desc.equals("null"))file_type_desc="";
					if(volume_no == null || volume_no.equals("null"))volume_no="";
					if(patient_id == null || patient_id.equals("null"))patient_id="";
					if(nursing_unit_desc == null || nursing_unit_desc.equals("null"))nursing_unit_desc="";				if(nursing_unit_code == null || nursing_unit_code.equals("null"))nursing_unit_code="";
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
					if(file_creation_date != null)
					{
						file_creation_date=DateUtils.convertDate(file_creation_date,"DMY","en",localeName);
					}
					else
						file_creation_date="";

					if(remarks == null || remarks.equals("null"))remarks=p_dflt_remarks;
					if(alt_id2_no == null || alt_id2_no.equals("null"))alt_id2_no="";
					if(sex == null || sex.equals("null"))sex="";
					if(bkg_lst_ref_no == null || bkg_lst_ref_no.equals("null"))bkg_lst_ref_no="";
					if(file_pulled_yn == null || file_pulled_yn.equals("null"))file_pulled_yn="";
					if(booking_status_checked == null || booking_status_checked.equals("null"))booking_status_checked="";
					if(mr_pat_fs_locn_code == null || mr_pat_fs_locn_code.equals("null"))mr_pat_fs_locn_code="";
					if(preferred_time == null || preferred_time.equals("null"))preferred_time="";
					if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
					{

					}
		   classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		   String remarks_bean ="";
			
			if(pullinglistrefno.containsObject(bkg_lst_ref_no)) 
					{                   
					file_pulled_yn = "CHECKED";
					}
			else
			file_pulled_yn="";
			int recordIndex = pullinglistrefno.indexOfObject(bkg_lst_ref_no);
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
		booking_status="";
	  	if (confirm_yn.equals("C"))
		{
			pull_yn_prop="disabled";
			booking_status_color="#FF0066";
			file_pulled_yn="";
		}
		else if (confirm_yn.equals("S"))
		{
			pull_yn_prop="disabled";
			booking_status_color="FF9999";
			file_pulled_yn="";
		}
		else if (confirm_yn.equals("T"))
		{
			pull_yn_prop="disabled";
			booking_status_color="#FF66FF";
			file_pulled_yn="";
		}
		else if (confirm_yn.equals("Y"))
		{
		    booking_status_color = "SkyBlue";
		}
        else
		{
			booking_status_color = "";
		}
		if (facility_id.equals(curr_facility_id) && mr_pat_fs_locn_code.equals(curr_fs_locn_code) && !curr_file_status1.equals("T"))
		{

		}
		else
		{
		 if (confirm_yn.equals("F"))          
			{
			pull_yn_prop="disabled";
			booking_status_color="lightgreen";
			booking_status="X";
			}
		}

		if (dis_oth_flag) {
			pull_yn_prop="disabled";
			file_pulled_yn="";
			}
			tblrow_id	=	"tblrow_id"+i;
			p_next_group_by_clause = nursing_unit_desc + " / " + practitioner_name + " / " + sex;
		if (p_counter==0)
		{
			p_group_by_clause	= nursing_unit_desc + " / " + practitioner_name + " / " + sex;
%>
        <tr>
            <td  width="100%" height="20" colspan=8  class='CAGROUPHEADING' ><b><%=p_group_by_clause%></b></td>
        </tr>
<%
		}
        else if (!p_group_by_clause.equals(p_next_group_by_clause))
            {
%>
        <tr>
            <td  width="100%" height="20" colspan=8 class='CAGROUPHEADING'  ><b><%=p_next_group_by_clause%></b></td>
        </tr>
<%
            }
			p_group_by_clause = p_next_group_by_clause ;
		%>
			<tr id='<%=tblrow_id%>'>
			<td class='<%=classValue%>'  width=39%>
			<%
			if(file_type_appl_yn.equals("N") ){
			%>
			<font size='1'><b>			
			<%=((file_no.equals(""))?"&nbsp;":file_no)%>			
				</font></b> / <%
			}
			%><font size='1'><%=((patient_id.equals(""))?"&nbsp;":patient_id)%>&nbsp;<%=((pat_details.equals(""))?"&nbsp;":pat_details)%></font><input type=hidden name=p_file_no<%=i%> value=<%=file_no%>><input type=hidden name=p_bkg_lst_ref_no<%=i%> value=<%=bkg_lst_ref_no%>><input type=hidden name=p_patient_id<%=i%> value=<%=patient_id%>><input type=hidden name=p_volume_no<%=i%> value=<%=volume_no%>></td>
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
			<td class='<%=classValue%>' align='center' width=8%><font size='1'><%=((preferred_time.equals(""))?"&nbsp;":preferred_time)%></font></td>
			<td class='<%=classValue%>' align='center' width=15%><font size='1'><%=((file_creation_date.equals(""))?"&nbsp;":file_creation_date)%></font></td>
		<%
			if (confirm_yn.equals("C") || confirm_yn.equals("S") || booking_status.equals("X") || confirm_yn.equals("T")||dis_oth_flag)
			{
		%>
				<td class='<%=classValue%>' align='center' width=8%><font size='1'>&nbsp;</font></td>
				<input type=hidden name=p_remarks<%=i%> value="<%=remarks%>" >
		<%
			}
			else if (booking_status.equals("W") && booking_status_checked.equals("Y"))
			{
		%>
				<td class='<%=classValue%>' align='center' width=8%><font size='1'><a href='javascript:GetRemarks(<%=i%>,"<%=java.net.URLEncoder.encode(remarks)%>")'><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/> </a></font></td>
				<input type=hidden name=p_remarks<%=i%> value="<%=remarks%>" >
		<%	
			}
			else if (booking_status.equals("W") && booking_status_checked.equals("N"))
			{
		%>
				<td class='<%=classValue%>' align='center' width=8%><font size='1'>&nbsp;</font></td>
				<input type=hidden name=p_remarks<%=i%> value="<%=remarks%>" >
		<%	
			}
			else
			{
		%>
				<td class='<%=classValue%>' align='center' width=8%><font size='1'><a href='javascript:GetRemarks(<%=i%>,"<%=java.net.URLEncoder.encode(remarks)%>")'><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/> </a></font></td>
				<input type=hidden name=p_remarks<%=i%> value="<%=remarks%>" >
				
		<%	
			}
		%>
		<input type='hidden' name='rem_recnum_<%=i%>' id='rem_recnum_<%=i%>' value=''>
		<%
		%>
			<td class='<%=classValue%>'  width=10%><font size='1'><%=((alt_id2_no.equals(""))?"&nbsp;":alt_id2_no)%></font></td>
			<td class='<%=classValue%>' width='10%'><font size='1'><%=((curr_fs_locn_short_desc.equals(""))?"&nbsp;":curr_fs_locn_short_desc)%></font></td><!--Added by Thamizh selvi on 22nd Jan 2018 agains ML-MMOH-CRF-0933-->
			<td class="<%=classValue%>" align=center width=10% style=background-color:<%=booking_status_color%>><input type='checkbox' name='pull_yn<%=i%>' id='pull_yn<%=i%>'  value='Y'  <%=file_pulled_yn%> onClick="UnselectPullAll(this)" onTest='CBValue(this,"<%=i%>");' <%=pull_yn_prop%> ></td>
			</tr>
		<%
           if (!other_appt.equals(""))
			{
			%>
			<tr>
            <td colspan = '6'><font size='1'>
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
				parent.frames[0].document.forms[0].preferred_date.disabled=false;
				parent.frames[0].document.forms[0].p_gender.disabled=false;
				parent.frames[0].document.forms[0].fm_nursing_unit_code.disabled=false;
				parent.frames[0].document.forms[0].fm_pract_id.disabled=false;				
				parent.frames[0].document.forms[0].confirm_yn.disabled=false;
				parent.frames[0].document.forms[0].pull_type.disabled=false;
				parent.frames[0].document.forms[0].subBotton.disabled=false;
				parent.frames[0].document.forms[0].pract_id.disabled=false;				

				</script>		
			<%
			}
			if (p_counter==0 && !curr_filestatus.equals("L"))
			{
			//	String	msg1="APP-FM0061 No records found";				
			%>
				<script>
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" + getMessage('FM_NO_RECORDS_FOUND','FM')+"&err_value=0";
				parent.frames[0].document.forms[0].flag.value="true";
				parent.frames[0].document.forms[0].fs_locn_code.disabled=false;
				parent.frames[0].document.forms[0].preferred_date.disabled=false;
				parent.frames[0].document.forms[0].p_gender.disabled=false;
				parent.frames[0].document.forms[0].fm_nursing_unit_code.disabled=false;
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
					
			%>
		<script>
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" + getMessage('FILE_IS_LOST','FM')+"&err_value=0";
				//parent.frames[0].document.forms[0].flag.value="true";
				parent.frames[0].document.forms[0].fs_locn_code.disabled=false;
				parent.frames[0].document.forms[0].preferred_date.disabled=false;
				parent.frames[0].document.forms[0].p_gender.disabled=false;
				parent.frames[0].document.forms[0].fm_nursing_unit_code.disabled=false;
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
<input type='hidden' name='preferred_date' id='preferred_date' value='<%=preferred_date1%>'>
<input type='hidden' name='fm_nursing_unit_code' id='fm_nursing_unit_code' value='<%=p_fm_nursing_unit_code%>'>
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



</form>

<%
if(rs != null) rs.close();
if(rs1 != null) rs1.close();
if(stmt != null) stmt.close();
if(rset3 != null) rset3.close();
if(pstmt != null) pstmt.close();	
if(pstmt1 != null) pstmt1.close();	
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
<SCRIPT LANGUAGE="JavaScript">
//parent.frames[1].clearpatid();
parent.frames[0].document.forms[0].patient_id.value='';
parent.frames[0].document.getElementById("patient_id").onblur();
parent.frames[0].document.forms[0].patient_id.focus();
</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</body>
</html>


