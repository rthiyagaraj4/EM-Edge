<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>

<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="pullinglistrefno" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="pullinglistremarks" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="pullinglistFileNo" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="pullinglistpatientId" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="tracer" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% 
		Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH") ;
		String localeName =((String)session.getAttribute("LOCALE"));
		String facility_id=(String)session.getValue("facility_id");
		Connection con = ConnectionManager.getConnection(request);
		ResultSet rs=null;
		ResultSet rs1=null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt1 =null;
	 try{
		
		String confirm_yn			=(String) hash.get("confirm_yn");
		String appt_date			=(String) hash.get("appt_date");
		String p_fm_clinic_code	=(String) hash.get("p_fm_clinic_code");
 		String p_to_clinic_code	=(String) hash.get("p_to_clinic_code");
		String p_fm_pract_id		=(String) hash.get("p_fm_pract_id");
		String p_to_pract_id		=(String) hash.get("p_to_pract_id");
		String p_gender			=(String) hash.get("p_gender");
		String pull_type				=(String) hash.get("pull_type");
		String p_fs_locn_code		=(String) hash.get("p_fs_locn_code");
		String check					=(String) hash.get("check");
		String steps					=(String) hash.get("steps");  
		if (confirm_yn==null) confirm_yn="";   
		if (steps==null) steps="";   
		if (check==null) check="";  
		if (appt_date==null) appt_date="";  
		if (p_fm_clinic_code==null) p_fm_clinic_code="";  
		if (p_to_clinic_code==null) p_to_clinic_code="";  
		if (p_fm_pract_id==null) p_fm_pract_id="";  
		if (p_to_pract_id==null) p_to_pract_id="";  
		if (p_gender==null) p_gender="";  
		if (pull_type==null) pull_type="";  
		if (p_fs_locn_code==null) p_fs_locn_code="";  		

		if (steps.equals("1"))
		 {
			pullinglistrefno.clearAll();
	        if (check.equals("Y"))
			{
			   String result_query="select distinct a.file_no from fm_pulling_list a,oa_appt b where a.facility_id = b.facility_id and a.appt_ref_no = b.appt_ref_no";
			   pstmt=con.prepareStatement(result_query);
			   rs=pstmt.executeQuery();
			   while(rs!=null&&rs.next())
				{
				 tracer.putObject(rs.getString(1));
				}
			   if(rs !=null) rs.close();
			   if(pstmt !=null) pstmt.close();
		    }
		 }
		else if (steps.equals("2"))
		 {
			//String result_query="select clinic_code,short_desc from op_clinic where facility_id = ? and mr_location_code =? ";
			String result_query="SELECT Clinic_Code, long_desc FROM   op_clinic_lang_vw WHERE  Facility_Id = ?  AND mr_Location_Code =  ? AND LANGUAGE_ID=? ";
			pstmt=con.prepareStatement(result_query);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,p_fs_locn_code);
			pstmt.setString(3,localeName);
			rs=pstmt.executeQuery();
			String clinic_code = "";
			String clinic_desc = "";
			while(rs!=null&&rs.next())
				{
				  clinic_code = rs.getString(1);
				  clinic_desc = rs.getString(2);
				%>
					var opt=document.createElement("OPTION");
					opt.text="<%=clinic_desc%>";
					opt.value="<%=clinic_code%>";
					document.forms[0].fm_clinic_code.add(opt);
				<%	
				}
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
		 }else if (steps.equals("FMHoliday")){
		 String currSelHolidays= (String) hash.get("currSelHolidays");
		
		ArrayList selectedHolidays= new ArrayList();
		int currPage=0;	
		selectedHolidays.add(currPage,currSelHolidays);

		int count=0;
		
		for(int i=0;i< selectedHolidays.size();i++){
			String temp=(String)selectedHolidays.get(i);
			if (temp.equals("")) count++;

		}

		if (selectedHolidays.size()==count){%>
			alert(f_query_add_mod.getMessage('ATLEAST_ONE_SELECTED','Common'));
			var result=false;
		<%}else{%>
			var result=confirm(f_query_add_mod.getMessage('DELETE_RECORD','Common'));
		<%}
selectedHolidays.clear();
	}else if (steps.equals("Holiday_Date_Check")){ %>
	var flag=0;
	<%
		//Added for HSA-CRF-0306.1
		String facilityid= (String) hash.get("facility_id");
		String fileno= (String) hash.get("fileno");
		String volume_no= (String) hash.get("volume_no");
		String Patient_Id= (String) hash.get("Patient_Id");
		String strLocn= (String) hash.get("strLocn");
		String retdate= (String) hash.get("retdate");
		int ret=0; String returnflag="FALSE";
		
		    String holidayQuery="select FM_VALIDATE_RETURN_DATE('"+facilityid+"','"+fileno+"','"+volume_no+"','"+Patient_Id+"','"+strLocn+"','"+retdate+"') retvalue from dual";	
           		
		    pstmt=con.prepareStatement(holidayQuery);			
			rs=pstmt.executeQuery();			
			if(rs!=null&&rs.next())
			{
			returnflag=rs.getString(1);				
			}			
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
	       if(returnflag.equals("TRUE")){%>
		     flag=1;
		   <%}else{ %>
		     flag=0;
		   <%}	
	   //End HSA-CRF-0306.1
	} else{
		 StringBuffer sql = null;
		 sql			  = new StringBuffer();
		 sql.append("select to_char(a.appt_time,'hh24:mi') appt_time,a.clinic_code,a.patient_id,a.practitioner_id,a.file_no,a.appt_ref_no, a.remarks  from fm_curr_locn b, fm_pulling_list a  where  b.facility_id=a.facility_id and b.file_no=a.file_no  and a.facility_id=?  and a.appt_date = to_date(?,'dd/mm/yyyy') and a.clinic_code = nvl(?,a.clinic_code) and (a.practitioner_id is null or a.practitioner_id between nvl(?,'!') and nvl(?,'~')) and (? is null or ? is null or a.practitioner_id is not null) and a.pull_list_type=decode(?,'A',a.pull_list_type,?) and a.auto_track_yn = 'N' and fm_return_appt_status(?,?,?,?,?,a.appt_ref_no,a.patient_id) not in ('C','T','S') and (b.curr_facility_id = ? and b.perm_fs_locn_code = b.curr_fs_locn_code) ");
		
		if (confirm_yn.equals("Y"))
			sql.append(" and a.confirm_yn = 'Y'");
        else
			sql.append(" and a.confirm_yn = 'N'");

		if (!(p_gender.equals("A")))
           sql.append(" and a.patient_id in (select patient_id from mp_patient where sex =?)");

		String remarks1="";

		pullinglistrefno.clearAll();
		pullinglistremarks.clearAll();
		pullinglistFileNo.clearAll();
		pullinglistpatientId.clearAll();
        if (check.equals("Y"))
		{
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,appt_date);
			pstmt.setString(3,p_fm_clinic_code);
			pstmt.setString(4,p_fm_pract_id);
			pstmt.setString(5,p_to_pract_id);
			pstmt.setString(6,p_fm_pract_id);
			pstmt.setString(7,p_to_pract_id);
			pstmt.setString(8,pull_type);
            pstmt.setString(9,pull_type);
            pstmt.setString(10,facility_id);
            pstmt.setString(11,p_fs_locn_code);
            pstmt.setString(12,appt_date);
			pstmt.setString(13,p_fm_clinic_code);
            pstmt.setString(14,p_to_clinic_code);
            pstmt.setString(15,facility_id);
			if (!(p_gender.equals("A")))
			pstmt.setString(16,p_gender);
			rs=pstmt.executeQuery();
			while(rs!=null&&rs.next())
			{
                String appt_time	   = rs.getString("appt_time");
                String appt_ref_no	   = rs.getString("appt_ref_no");
                String patient_id	   = rs.getString("patient_id");
                //String practitioner_id = rs.getString("practitioner_id");
				String sql_other_appt ="select sign(a.appt_time-to_date(?,'hh24:mi')) diff from oa_appt a  where a.facility_id=? and appt_date= to_date(?,'dd/mm/yyyy') and a.patient_id = ? and a.appt_ref_no != ?";
				boolean dis_oth_flag=false;
				pstmt1=con.prepareStatement(sql_other_appt);
				pstmt1.setString(1,appt_time);
				pstmt1.setString(2,facility_id);
				pstmt1.setString(3,appt_date);
				pstmt1.setString(4,patient_id);
				pstmt1.setString(5,appt_ref_no);
				rs1 = pstmt1.executeQuery();
				int diff=0;
				while(rs1!=null&&rs1.next())
				 {		 
					  diff = rs1.getInt(1);
					  if ((diff<0) && (!dis_oth_flag))
						dis_oth_flag = true;
				}
				if(rs1 !=null) rs1.close();
				if(pstmt1 !=null) pstmt1.close();
				if (dis_oth_flag)
				{
					pullinglistrefno.putObject(rs.getString("appt_ref_no"));
					pullinglistFileNo.putObject(rs.getString("file_no"));
					pullinglistpatientId.putObject(patient_id);
					remarks1 = rs.getString("remarks");
				}

		  if(remarks1 == null) remarks1="";
		  pullinglistremarks.putObject(remarks1);
		 }
		 }
	 }
	  if(rs !=null) rs.close();
	  if(pstmt !=null) pstmt.close();
	  if(rs1 !=null) rs1.close();
	  if(pstmt1 !=null) pstmt1.close();
	}catch( Exception e ){
		out.println(e.toString());
	}
	finally
	{			
		ConnectionManager.returnConnection(con,request);
	}
%>
