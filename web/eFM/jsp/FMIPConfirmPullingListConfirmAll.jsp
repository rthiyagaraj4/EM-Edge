<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="pullinglistrefno" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="pullinglistremarks" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="pullinglistFileNo" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="pullinglistpatientId" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="tracer" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%
		request.setCharacterEncoding("UTF-8");
		Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH") ;
		String facility_id=(String)session.getValue("facility_id");
		Connection con = ConnectionManager.getConnection(request);
		ResultSet rs=null;		
		PreparedStatement pstmt =null;
		
	 try{
		String confirm_yn			=(String) hash.get("confirm_yn");
		String preferred_date			=(String) hash.get("preferred_date");
		String p_fm_nursing_unit_code		=(String) hash.get("p_fm_nursing_unit_code");
		String p_to_nursing_unit_code		=(String) hash.get("p_to_nursing_unit_code");
		String p_fm_pract_id		=(String) hash.get("p_fm_pract_id");
		String p_to_pract_id		=(String) hash.get("p_to_pract_id");
		String p_gender				=(String) hash.get("p_gender");
		String pull_type			=(String) hash.get("pull_type");
		String p_fs_locn_code		=(String) hash.get("p_fs_locn_code");
		String check				=(String) hash.get("check");
		String steps				=(String) hash.get("steps");
		String where_cond="";
		if (confirm_yn==null) confirm_yn="";   
		if (steps==null) steps="";   
		if (check==null) check="";  
		if (preferred_date==null) preferred_date="";  
		if (p_fm_nursing_unit_code==null) p_fm_nursing_unit_code="";  
		if (p_to_nursing_unit_code==null) p_to_nursing_unit_code="";  
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
			   String result_query="select distinct a.file_no from fm_ip_pulling_list a,ip_booking_list b where a.facility_id = b.facility_id and a.bkg_lst_ref_no = b.bkg_lst_ref_no";
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
			String result_query="select nursing_unit_code,long_desc short_desc from ip_nursing_unit where facility_id = ? and fs_locn_code =? ";
			pstmt=con.prepareStatement(result_query);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,p_fs_locn_code);
			rs=pstmt.executeQuery();
			String nursing_unit_code = "";
			String nursing_unit_desc = "";
			while(rs!=null&&rs.next())
				{
				  nursing_unit_code = rs.getString(1);
				  nursing_unit_desc = rs.getString(2);
				%>
					var opt=document.createElement("OPTION");
					opt.text="<%=nursing_unit_desc%>";
					opt.value="<%=nursing_unit_code%>";
					document.forms[0].fm_nursing_unit_code.add(opt);
				<%	
				}
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
		 }
		 else
		 {
		StringBuffer sql = null;
		sql				 = new StringBuffer();
		sql.append("select to_char(a.preferred_date,'hh24:mi') preferred_time,a.nursing_unit_code,a.patient_id,a.practitioner_id,a.file_no,a.bkg_lst_ref_no, a.remarks from fm_curr_locn b, fm_ip_pulling_list a  where   b.facility_id=a.facility_id and b.file_no=a.file_no  and a.facility_id=?  and a.preferred_date = to_date(?,'dd/mm/yyyy') and a.nursing_unit_code = nvl(?,a.nursing_unit_code) and (a.practitioner_id is null or a.practitioner_id between nvl(?,'!') and nvl(?,'~')) and (? is null or ? is null or a.practitioner_id is not null) and a.pull_list_type=decode(?,'A',a.pull_list_type,?) and a.auto_track_yn = 'N' and fm_return_booking_status(?,?,?,?,?,a.bkg_lst_ref_no,a.patient_id) not in ('C','T','S') and (b.curr_facility_id = ? and b.perm_locn_code = b.curr_fs_locn_code) ");
		
		if (confirm_yn.equals("Y"))
			sql.append(" and a.confirm_yn = 'Y'");
        else
			sql.append(" and a.confirm_yn = 'N'");

		if (!(p_gender.equals("A")))
           sql.append(" and a.patient_id in (select patient_id from mp_patient where sex =?)");

		String remarks1="";

		where_cond=java.net.URLDecoder.decode(where_cond);
		sql.append(where_cond);
		pullinglistrefno.clearAll();
		pullinglistremarks.clearAll();
		pullinglistFileNo.clearAll();
		pullinglistpatientId.clearAll();
        if (check.equals("Y"))
		{
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,preferred_date);
			pstmt.setString(3,p_fm_nursing_unit_code);
			pstmt.setString(4,p_fm_pract_id);
			pstmt.setString(5,p_to_pract_id);
			pstmt.setString(6,p_fm_pract_id);
			pstmt.setString(7,p_to_pract_id);
			pstmt.setString(8,pull_type);
            pstmt.setString(9,pull_type);
            pstmt.setString(10,facility_id);
            pstmt.setString(11,p_fs_locn_code);
            pstmt.setString(12,preferred_date);
			pstmt.setString(13,p_fm_nursing_unit_code);
            pstmt.setString(14,p_to_nursing_unit_code);
            pstmt.setString(15,facility_id);
			if (!(p_gender.equals("A")))
			pstmt.setString(16,p_gender);
			rs=pstmt.executeQuery();
			while(rs!=null&&rs.next())
			{
              //  String bkg_lst_ref_no	   = rs.getString("bkg_lst_ref_no");
				String patient_id	   = rs.getString("patient_id");
			//	String practitioner_id = rs.getString("practitioner_id");

					pullinglistrefno.putObject(rs.getString("bkg_lst_ref_no"));
					pullinglistFileNo.putObject(rs.getString("file_no"));
					pullinglistpatientId.putObject(patient_id);
					remarks1 = rs.getString("remarks");

		  if(remarks1 == null) remarks1="";
		  pullinglistremarks.putObject(remarks1);
		 }
		 }
	}
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();	
	}catch( Exception e ){
		out.println(e.toString());
	}
	finally
	{			
		ConnectionManager.returnConnection(con,request);
	}
%>
