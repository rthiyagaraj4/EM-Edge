<!DOCTYPE html>
<%
/** Jsp file for generating file type , mr Section depending on file storage location from createfileComponent.jsp and also for calling the Create_Patient_File procedure for gererating file */
%>

<%@ page import="java.sql.*,java.io.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,eFM.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
     
	 <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	 <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
</head>
<body onKeyDown='lockKey();'>											   
<%

 Connection con = null;
 CallableStatement cs = null;
 PreparedStatement pstmt = null;
 PreparedStatement pstmt1 = null;
 java.sql.Statement stmt = null;
 ResultSet rset = null;
 
 ResultSet rset2 = null;
 
//Added for this CRF HSA-CRF-0306.1
boolean isCurrentFsLocation=false;
CallableStatement cstmt = null;
//End CRF HSA-CRF-0306.1


 try { /* outer try */

		/* Portion for getting the request Parameters */
			
		String result_file_no = "";
		String result_error_value ="";
		String mr_section_code = "";
		String mr_section_code_desc = "";
	   int cnt=0;
		String facility_id = (String)session.getAttribute("facility_id");
        String value1 = request.getParameter("field1")==null?"":request.getParameter("field1");

		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
		//this value is obtained only for populating the values of file_type.
		String install_yn = request.getParameter("install_yn")==null?"":request.getParameter("install_yn");
		//this value is obtained only for populating the values of file_type.
		String file_type_appl_yn = request.getParameter("file_type_appl_yn")==null?"":request.getParameter("file_type_appl_yn");
		String multi_files_in_same_fs_locn_yn = request.getParameter("multi_files_in_same_fs_locn_yn")==null?"":request.getParameter("multi_files_in_same_fs_locn_yn");
        String value2 = request.getParameter("field2")==null?"":request.getParameter("field2");
		String p_facility_id = request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");

		String p_patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");

		String p_single_or_multi_files_ind = request.getParameter("p_single_or_multi_files_ind")==null?"":request.getParameter("p_single_or_multi_files_ind");

		String p_separate_file_no_yn = request.getParameter("p_separate_file_no_yn")==null?"":request.getParameter("p_separate_file_no_yn");

		String p_location_code = request.getParameter("p_location_code")==null?"":request.getParameter("p_location_code");

		String p_pat_ser_grp_code = request.getParameter("p_pat_ser_grp_code")==null?"":request.getParameter("p_pat_ser_grp_code");

		String p_mr_section_type = request.getParameter("p_mr_section_type")==null?"":request.getParameter("p_mr_section_type");

		String p_mr_section_code = request.getParameter("p_mr_section_code")==null?"":request.getParameter("p_mr_section_code");

		String p_fs_location_code = request.getParameter("p_fs_location_code")==null?"":request.getParameter("p_fs_location_code");

		String p_file_type_code = request.getParameter("p_file_type_code")==null?"":request.getParameter("p_file_type_code");

		String p_old_file_no = request.getParameter("p_old_file_no")==null?"":request.getParameter("p_old_file_no");

		String p_alt_file_no = request.getParameter("p_alt_file_no")==null?"":request.getParameter("p_alt_file_no");  //Added by Sangeetha for GDOH-CRF-0103
				
		String p_called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");

		String Location_Code = request.getParameter("Location_Code")==null?"":request.getParameter("Location_Code");

		String p_encounter_id = request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id");        
		String p_patient_class = request.getParameter("p_patient_class")==null?"":request.getParameter("p_patient_class");       
		String p_encounter_date_time = request.getParameter("p_encounter_date_time")==null?"":request.getParameter("p_encounter_date_time");
			
		
		String filetypecode = "";
		String filetypedesc = "";
		String filetypecodetemp = "";
		//String filetypedesctemp = "";
		
		String value4 = request.getParameter("field4")==null?"":request.getParameter("field4");
		String AddedAtWsNo = "";
		String addedById = "";
		String sysdate = "";
		//Added by S.Sathish for SRR20056-SCF-4443 on Friday, May 07, 2010 starts here
		String fac_id = request.getParameter("fac_id")==null?"":request.getParameter("fac_id");  
		String file_typ_code = request.getParameter("file_type_code")==null?"":request.getParameter("file_type_code");  
		String from_where = request.getParameter("from_where")==null?"":request.getParameter("from_where");  
		//Ends here
		con = ConnectionManager.getConnection(request);
		/* Portion for generating the other items depending on file storage location */
		
		if (value4.equals("create"))
		{
		try {


					//Query for generating mr section description
		String sql2 = "select b.short_name mr_section, a.mr_section_code mr_section_code from fm_storage_locn a, mr_section b where a.facility_id = b.facility_id and a.fs_locn_code =? and a.mr_section_code = b.mr_section_code";
		if(pstmt!=null) pstmt.close();
		if (rset!=null) rset.close();
		pstmt=con.prepareStatement(sql2);
		pstmt.setString(1,value1);
		rset = pstmt.executeQuery();
		if(value1.equals("")){%>
		<script>if(parent.frames[0].document.getElementById('mr_section')!=null)parent.frames[0].document.getElementById('mr_section').innerHTML = '';</script>
		<%}
		if (rset!=null)
		{
			if(rset.next())
			{
				mr_section_code_desc = rset.getString("mr_section")==null?"":rset.getString("mr_section");
                            %>
				<script>
						// var temp ="<%=mr_section_code%>";
						var temp1 = "<%=mr_section_code_desc%>"
						if(parent.frames[0].document.getElementById('mr_section')!=null)
						parent.frames[0].document.getElementById('mr_section').innerHTML = temp1;
				</script>
                            <%
            }
			else
			{%>
			<script>if(parent.frames[0].document.getElementById('mr_section')!=null)parent.frames[0].document.getElementById('mr_section').innerHTML = '';</script>
			<%}

		}
	file_type_appl_yn="Y";
			
		
		if (file_type_appl_yn.equals("Y")) //Then populate the values for file type
		{
		//If called from is OP or called from is AE
		StringBuffer sql4 = new StringBuffer("select dflt_file_type_code, b.short_desc from op_clinic a, mr_file_type b where a.facility_id = '");
		sql4.append(value2);
		sql4.append("'  and a.clinic_code = '");
		sql4.append(Location_Code);
		sql4.append("'  and a.dflt_file_type_code = b.file_type_code(+)");
		if(called_from.equals("OP")){sql4.append(" and b.appl_to_op='Y'");}
		if(called_from.equals("AE")){sql4.append(" and b.appl_to_em='Y'");}
		
		
		//If Called from is IP
		StringBuffer sql5 = new StringBuffer("select dflt_file_type_code, b.short_desc from ip_nursing_unit a, mr_file_type b where a.facility_id = '");
		sql5.append(value2);
		sql5.append("' and a.nursing_unit_code = '");
		sql5.append(Location_Code);
		sql5.append("' and a.dflt_file_type_code = b.file_type_code(+) and (b.appl_to_ip='Y' OR b.appl_to_dc='Y') ");

		
		
		//The following query will be executed for generating file types if FM is not installed

	
		
		
		
		StringBuffer sql7 = new StringBuffer("Select short_desc, file_type_code from mr_file_type where facility_id = '");
		sql7.append(value2);
		sql7.append("' and eff_status = 'E' ");

		if(called_from.equals("OP")){sql7.append(" and appl_to_op='Y' ");}
		if(called_from.equals("AE")){sql7.append(" and appl_to_em='Y' ");}
		if(called_from.equals("IP")){sql7.append(" and (appl_to_ip='Y' or appl_to_dc='Y') ");}
		sql7.append(" order by short_desc "); 
				if(install_yn.equals("Y")){
					
				if (called_from.equals("OP")||called_from.equals("IP")||called_from.equals("AE"))
				{ 
				if(called_from.equals("OP")||called_from.equals("AE"))
					{ pstmt1 = con.prepareStatement(sql4.toString());}
				else if (called_from.equals("IP")) 
					{ pstmt1 = con.prepareStatement(sql5.toString());}
		
				try{
				rset2 = pstmt1.executeQuery();
				
				if(rset2!=null && rset2.next())
					{					
						filetypecodetemp = rset2.getString("dflt_file_type_code")==null?"":rset2.getString("dflt_file_type_code");
					
						//filetypedesctemp = rset2.getString("short_desc")==null?"":rset2.getString("short_desc");
					}
				}
				catch(Exception e){}
			
				}
				//If FM is installed then the following query will be executed else sql7 will be executed
			/*	StringBuffer sql6 = new StringBuffer("Select b.short_desc, a.file_type_code from fm_file_type_for_fsl a, mr_file_type b where a.facility_id = '");
				sql6.append(value2);
				sql6.append("' and a.fs_locn_code = '");
				sql6.append(value1);
				sql6.append("' and a.facility_id = b.facility_id and a.file_type_code = b.file_type_code and a.eff_status='E'");
				if(called_from.equals("OP")){sql6.append(" and b.appl_to_op='Y' ");}
				if(called_from.equals("AE")){sql6.append(" and b.appl_to_em='Y' ");}
				if(called_from.equals("IP")){sql6.append(" and (b.appl_to_ip='Y' or b.appl_to_dc='Y') ");}
				sql6.append(" order by short_desc "); */

          	StringBuffer sql6 = new StringBuffer("Select b.short_desc, a.file_type_code from fm_file_type_for_fsl a, mr_file_type b where a.facility_id = '");
		   sql6.append(facility_id);
		   sql6.append("' and a.fs_locn_code = '");
		    sql6.append(value1);
				sql6.append("' and a.facility_id = b.facility_id and a.file_type_code = b.file_type_code and a.eff_status=b.eff_status  and a.eff_status='E'");
				if(called_from.equals("OP")){sql6.append(" and b.appl_to_op='Y' ");}
				if(called_from.equals("AE")){sql6.append(" and b.appl_to_em='Y' ");}
				if(called_from.equals("IP")){sql6.append(" and (b.appl_to_ip='Y' or b.appl_to_dc='Y') ");}
				sql6.append(" order by short_desc "); 
		

				if(pstmt1!=null)pstmt1.close();
				if(rset2!=null)rset2.close();
				stmt =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
				//	con.prepareStatement(sql6.toString());
					
				rset2 = stmt.executeQuery(sql6.toString());
                 rset2.last();
				cnt=rset2.getRow();
				rset2.beforeFirst();
			   
				if(rset2!=null){
				
					%>
				<script>
					
				var cnt ="<%=cnt%>" ;
				//var  value1="<%=value1%>" ;
				if(parent.frames[0].document.forms[0].file_type) {
					var n = parent.frames[0].document.forms[0].file_type.options.length;
						for(var i=0;i<n;i++)
						{				parent.frames[0].document.forms[0].file_type.remove("file_type");	
						}
							var temp = "";
							var temp1="----"+parent.frames[0].getLabel('Common.defaultSelect.label','common')+"----";

							var opt=parent.frames[0].document.createElement("OPTION");
							opt.text=temp1;
							opt.value=temp;
							if(cnt!=1)
							parent.frames[0].document.forms[0].file_type.add(opt);
				}
				</script>
			<%
				while(rset2.next())	{	
					cnt++;
					filetypecode = rset2.getString("file_type_code")==null?"":rset2.getString("file_type_code");
					filetypedesc = rset2.getString("short_desc")==null?"":rset2.getString("short_desc");
				//Default the file type code which is obtained from the previous query	

				%>
					<script>
					if(parent.frames[0].document.forms[0].file_type) {
						var temp2 = "<%=filetypecodetemp%>"
						var temp = "<%=filetypecode%>";
						var temp1="<%=filetypedesc%>";
                  			var opt=parent.frames[0].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						if(temp2==temp)
						{
						 opt.selected = true;
						}
						parent.frames[0].document.forms[0].file_type.add(opt);
					}
					</script>
			<%
				}
			}			
		}//if ends for Fm installed
		else if(install_yn.equals("N")||install_yn.equals(""))
		{ 
				if(pstmt1!=null) pstmt1.close();
				if(rset2!=null)rset2.close();
				if (called_from.equals("OP")||called_from.equals("IP")||called_from.equals("AE"))
				{ 
				if(called_from.equals("OP")||called_from.equals("AE"))
					{ pstmt1 = con.prepareStatement(sql4.toString());}
				else if (called_from.equals("IP")) 
					{ pstmt1 = con.prepareStatement(sql5.toString());}
		
				try {
				rset2 = pstmt1.executeQuery();
				if(rset2!=null && rset2.next())
					{					
						filetypecodetemp = rset2.getString("dflt_file_type_code")==null?"":rset2.getString("dflt_file_type_code");
						//filetypedesctemp = rset2.getString("short_desc")==null?"":rset2.getString("short_desc");
					}
				}
				catch(Exception e){}
			
				}
				if(pstmt1!=null) pstmt1.close();
				if(rset2!=null)rset2.close();

		
				
				
				pstmt1 = con.prepareStatement(sql7.toString());
				rset2 = pstmt1.executeQuery(sql7.toString());
				if(rset2!=null){
			%>
				<script>
					if(parent.frames[0].document.forms[0].file_type) {
					var n = parent.frames[0].document.forms[0].file_type.options.length;
					for(var i=0;i<n;i++)
						{				parent.frames[0].document.forms[0].file_type.remove("file_type");	
						}

							var temp = "";		
							var temp1="----"+parent.frames[0].getLabel('Common.defaultSelect.label','common')+"----";

							var opt=parent.frames[0].document.createElement("OPTION");
							opt.text=temp1;
							opt.value=temp;
							parent.frames[0].document.forms[0].file_type.add(opt);	
				}
								
				</script>
			<%
				while(rset2.next())
				{
					filetypecode = rset2.getString("file_type_code")==null?"":rset2.getString("file_type_code");
					filetypedesc = rset2.getString("short_desc")==null?"":rset2.getString("short_desc");
				%>
					<script>
					if(parent.frames[0].document.forms[0].file_type) {
								
						var temp = "<%=filetypecode%>";          
						var temp1="<%=filetypedesc%>";          
						var temp2="<%=filetypecodetemp%>";      
						var opt=parent.frames[0].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						if(temp==temp1)
						{
							 opt.selected = true;
						}
						parent.frames[0].document.forms[0].file_type.add(opt);
					}
					</script>
		
				<%
				}
				}
				}
		}//end if for file_type_appl_yn
		
		}//
		catch (Exception e)
		{ 			
			e.printStackTrace();
		}
		}/*End of portion for dynamically generating values depending on file storage location */

		/* Portion for calling the procedure starts */
		if(value4.equals("submit"))
		{
		try{
			int file_count = 0;
			try{
			//Check for whether file number already exists for that file type.			
			
				if(file_type_appl_yn.equals("Y"))
				{
					String sql_file_exists = " select count(1) from mr_pat_file_index where patient_id = ? and facility_id=? and file_type_code=? ";
					if(pstmt!=null) pstmt.close();
					if (rset!=null) rset.close();
					pstmt=con.prepareStatement(sql_file_exists);
					pstmt.setString(1,p_patient_id);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,p_file_type_code);
					rset = pstmt.executeQuery();
					if(rset!=null)
					{
						while(rset.next())
						{
							file_count = rset.getInt(1);				
						}
					}
				}else if(file_type_appl_yn.equals("N") && multi_files_in_same_fs_locn_yn.equals("N") )
				{
					String sql_file_exists = "select count(1) from mr_pat_file_index where patient_id = ? and facility_id = ? and fs_locn_code = ?";
					if(pstmt!=null) pstmt.close();
					if (rset!=null) rset.close();
					pstmt=con.prepareStatement(sql_file_exists);
					pstmt.setString(1,p_patient_id);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,p_fs_location_code);
					rset = pstmt.executeQuery();
					if(rset!=null)
					{
						while(rset.next())
						{
							file_count = rset.getInt(1);				
						}
					}
				}
			}catch(Exception e){}
			//Display an alert stating that file is already created.

			if(file_count > 0)
			{
				if(file_type_appl_yn.equals("Y"))
					out.println("<script>alert(getMessage('FILE_ALREADY_CREATED_FT','MP'));</script>");	
				else if(file_type_appl_yn.equals("N"))
					out.println("<script>alert(getMessage('FILE_ALREADY_CREATED_FS','MP'));</script>");
			}
			else 
			{			
			Properties p = null;
			p = ( java.util.Properties ) session.getAttribute( "jdbc" ) ;
		    AddedAtWsNo     =  p.getProperty("client_ip_address");
			addedById       = p.getProperty( "login_user" ) ;

			if(pstmt!=null) pstmt.close();
			if (rset!=null) rset.close();			

			con.setAutoCommit(false);				
			cs = con.prepareCall("{call Create_Patient_File(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	//Modified by Sangeetha for GDOH_CRF_0103	
			
			cs.setString( 1 ,p_facility_id);			
            cs.setString( 2 ,p_patient_id);			
			cs.setString( 3 ,p_single_or_multi_files_ind);			
			cs.setString( 4 ,p_separate_file_no_yn);			
			cs.setString( 5 ,p_location_code);
			cs.setString( 6 ,p_pat_ser_grp_code);
			cs.setString( 7 ,p_mr_section_type);
			cs.setString( 8 ,p_mr_section_code);			
			cs.setString( 9 ,p_fs_location_code);
			cs.setString( 10 ,p_file_type_code);
			cs.setString( 11 ,p_old_file_no);
			cs.setString( 12 ,p_called_from);
			cs.setString( 13 ,addedById);			
			cs.setString( 14 ,sysdate);
			cs.setString( 15 ,AddedAtWsNo);
			cs.setString( 16 ,facility_id);
			cs.setString( 17 ,addedById);			
			cs.setString( 18 ,sysdate);
			cs.setString( 19 ,AddedAtWsNo);
			cs.setString( 20 ,facility_id);
			cs.setString( 21 ,p_encounter_id);
			cs.setString( 22 ,p_patient_class);
			cs.setString( 23 ,p_encounter_date_time);
			cs.registerOutParameter(24,java.sql.Types.VARCHAR);
			cs.registerOutParameter(25,java.sql.Types.VARCHAR);	
			cs.setString( 26 ,p_alt_file_no);  //Added by Sangeetha for GDOH-CRF-0103
			
            
			

			try{	
				cs.execute();
	
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}	
			/* Get the file number and error message if any*/
			result_file_no = cs.getString(24)==null?"":cs.getString(24);
			result_error_value=cs.getString(25)==null?"":cs.getString(25);
			con.commit();
           		
		 /*Below line Added for this CRF HSA-CRF-0306.1*/
		 isCurrentFsLocation=CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");
		 String PatientClass="", Assigncarecode="", errmsg="";//,dischargedatetime=""; 
         String fslocn_return_criteria="",durations_type="";		 
         int recorCount=0;
         String current_fs_locn_code="",permenant_fs_locn_code="",current_file_status=""; 		 
	     ArrayList List=(ArrayList)FMCurrentEncounterDetails.getCurrentEncounterDetails(con,result_file_no,p_facility_id,p);
            recorCount=List.size();		 
			for(int i=0; i<List.size(); i++){
			    FMCurrentEncounterDetailsBean currencounterDetails=(FMCurrentEncounterDetailsBean)List.get(i);                
				PatientClass=currencounterDetails.getPatientClass();
				Assigncarecode=currencounterDetails.getAssigncarecode();					   
			    //dischargedatetime=currencounterDetails.getDischargedatetime();
			}
		 	
		 String currLocQuery="select curr_fs_locn_code, perm_fs_locn_code, curr_file_status from fm_curr_locn where facility_id='"+p_facility_id+"' and file_no='"+result_file_no+"'"; 
         		 
       		 
		 pstmt=con.prepareStatement(currLocQuery);
		 rset = pstmt.executeQuery();					
    	 if(rset != null && rset.next()){
             current_fs_locn_code =rset.getString("curr_fs_locn_code");
             permenant_fs_locn_code	=rset.getString("perm_fs_locn_code");	
             current_file_status=rset.getString("curr_file_status");				 
		 }		  
       if(rset!=null)rset.close();
       if(pstmt!=null) pstmt.close();
	   
	   String durationsqlQuery="SELECT (CASE  WHEN locn_identity IN 'C' and exists (SELECT 1 FROM op_clinic             WHERE clinic_type = 'C' AND level_of_care_ind = 'E'   AND clinic_code = '"+p_location_code+"' AND mr_location_code = '"+current_fs_locn_code+"' ) THEN  no_of_dh_to_return_em     ELSE (CASE                  WHEN locn_identity IN ('C', 'E') THEN no_of_dh_to_return_op   ELSE (CASE                            WHEN locn_identity = 'N' THEN no_of_dh_to_return_ip    ELSE (CASE                                      WHEN locn_identity = 'Y' THEN no_of_dh_to_return_dc   END)  END)                  END) END) no_of_dh_to_return, duration_type, return_criteria, permanent_file_area_yn, locn_identity FROM fm_storage_locn WHERE fs_locn_code = '"+current_fs_locn_code+"' AND facility_id='"+p_facility_id+"'" ;		
				
				
		 pstmt=con.prepareStatement(durationsqlQuery);
		 rset = pstmt.executeQuery();					
    	 if(rset != null && rset.next()){           
			durations_type = rset.getString(2);
            fslocn_return_criteria = rset.getString(3);   				 
		 }
		 if(fslocn_return_criteria == null || fslocn_return_criteria.equals("null")) fslocn_return_criteria = "";
		 if(fslocn_return_criteria.equals("")) fslocn_return_criteria="I";
		 
       if(rset!=null)rset.close();
       if(pstmt!=null) pstmt.close();
	   
	   	   
	   if(isCurrentFsLocation && recorCount >= 1 && fslocn_return_criteria.equals("I")){
	           
				cstmt = con.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				cstmt.setString(1, current_fs_locn_code);
				cstmt.setString(2, p_facility_id);
				cstmt.setString(3, "FILE_CREATED");
				cstmt.setString(4, result_file_no);	
                cstmt.setString(5, "");	
                cstmt.setString(6, "");	
                cstmt.setString(7, "");	  				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.execute();					
				errmsg=cstmt.getString(8); 
				
		}			
		//End HSA-CRF-0306.1	
		
		%>
			<script>
				var generated_file_no = '';				
				generated_file_no = '<%=result_file_no%>';
				if((generated_file_no==null)||(generated_file_no==''))
					{					
				parent.frames[0].document.forms[0].file_no.value='<%=result_file_no%>';
				parent.frames[0].document.forms[0].error_value.value='<%=result_error_value%>';				
			var retVal = "";
            if(parent.frames[0].document.forms[0].file_no)  
				retVal = parent.frames[0].document.forms[0].file_no.value;
            if(parent.frames[0].document.forms[0].error_value)    
				retVal +="`"+ parent.frames[0].document.forms[0].error_value.value
			else 
				retVal+="`"				
			
			window.returnValue = retVal ;
					}
				else{				
				parent.frames[0].document.forms[0].file_no.value='<%=result_file_no%>';
				parent.frames[0].document.forms[0].error_value.value='<%=result_error_value%>';

					var retVal = "";
		            if(parent.frames[0].document.forms[0].file_no)  
						retVal = parent.frames[0].document.forms[0].file_no.value;
		            if(parent.frames[0].document.forms[0].error_value)    
						retVal +="`"+ parent.frames[0].document.forms[0].error_value.value
		            else    
						retVal+="`"
					//parent.parent.document.getElementById("dialog-body").contentWindow.returnValue = retVal ;
		            window.returnValue = retVal ;
				}//parent.parent.document.getElementById("dialog_tag").close();
            	window.close();

			</script>   
					
		<%}//end of else part for file number exists check
			if(pstmt1!=null) pstmt1.close();
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			if(rset2!=null) rset2.close();
			if(cs!=null)cs.close();		 
		}
		catch (Exception e)
		{		
			e.printStackTrace();
	
		%>
			<script>window.close()</script>
		<%
		}

		}	
		//Added by S.Sathish for SRR20056-SCF-4443 on Friday, May 07, 2010 starts here
		if(from_where.equals("File_type"))
		{	
			try{
					String sql_file_type = "select count(1) from fm_file_type_for_fsl where facility_id=? and file_type_code=? and default_yn='Y' ";
					int count=0;
					if(pstmt!=null) pstmt.close();
					if (rset!=null) rset.close();
					pstmt=con.prepareStatement(sql_file_type);
					pstmt.setString(1,fac_id);
					pstmt.setString(2,file_typ_code);					
					rset = pstmt.executeQuery();
					if(rset!=null)
					{
						while(rset.next())
						{
							count = rset.getInt(1);				
						}
					}
					if(count == 0){%>
					<script>							
					        parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
					</script>
					<%}else{%>
					<script>
							alert(getMessage('FILE_TYPE_DEFAULT','FM'));	
							parent.frames[1].document.forms[0].eff_status.value='E';
							parent.frames[1].document.forms[0].eff_status.checked=true;
							parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
					</script>	
					<%}	



			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		//Ends here
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
		if(rset2!=null) rset2.close();
		if(cs!=null)cs.close();
}catch(Exception e){out.println("Error in Creating File :"+e);}
finally{
	if(con!=null){
				ConnectionManager.returnConnection(con,request);
	}
}		
%>

	<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

