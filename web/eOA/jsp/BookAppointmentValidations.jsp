//below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A

var myarr = new Array();
var sp_code=new Array();
var sp_des=new Array();
index=0;
//end  Bru-HIMS-CRF-168 [IN030287]_0A

<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
webbeans.op.PatientData patdata = new webbeans.op.PatientData();
Map hash = (Map)obj.parseXMLString( request ) ;
hash = (Map)hash.get("SEARCH") ;
request.setCharacterEncoding("UTF-8");	

Connection conn = null;
String facilityid=(String)session.getValue("facility_id");
String patientid=(String) hash.get("pat_id");
String cliniccode=(String) hash.get("clinic_code");
String alcn_criteria=(String) hash.get("alcn_criteria_pop");
String ip_installed_yn=(String) hash.get("ip_installed_yn");
String rad_installed_yn=(String) hash.get("rad_installed_yn");
String visit_type_cd=(String) hash.get("visit_type_cd");
String sel_service_code=(String) hash.get("sel_service_code");
if(visit_type_cd==null) visit_type_cd="";
//String age_group_code=(String) hash.get("age_group_code");
String pat_cat_code="";
//below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A
//String param             ="N";
String speciality_code   =(String)hash.get("speciality_code");
String dtl_msg_yn        =(String)hash.get("dtl_msg_yn");
String sp_code           ="";
String sp_des            ="";
//end  Bru-HIMS-CRF-168 [IN030287]_0A

Statement stmtc=null;
PreparedStatement pstmt=null;

ResultSet rsc=null;
ResultSet rs=null;
Statement stmt=null;

int maxRecord1=0;
int ip_bkgs=0;
int rad_bkgs=0;

int prev_encntr=0;

try{
	conn = ConnectionManager.getConnection(request);
	String In_patient_status =  patdata.CheckInPatient(conn,patientid,facilityid);

	if(In_patient_status.equals("CURRENTLY_IN_PATIENT")){%>
		parent.frames[0].document.forms[0].inpatient_yn.value='Y';
	<%}else{%>
		parent.frames[0].document.forms[0].inpatient_yn.value='N';
	 <%}
				
	//pstmt = conn.prepareStatement("select count(1) as total from oa_appt where patient_id='"+patientid+"'  and trunc(Appt_date)>=trunc(sysdate) and nvl(appt_status,1)!='A' order by appt_date,appt_slab_from_time");
pstmt = conn.prepareStatement("SELECT  a. speciality_code, b.short_desc,COUNT (*) AS total FROM oa_appt a,am_speciality b WHERE patient_id = '"+patientid+"' and a.speciality_code = b.speciality_code AND TRUNC (appt_date) >= TRUNC (SYSDATE) AND NVL (appt_status, 1) != 'A' GROUP BY a.speciality_code,b.short_desc ORDER BY a.speciality_code");

	rs = pstmt.executeQuery();
	while(rs!=null && rs.next())
	{ 
		 //below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A
		sp_code=rs.getString("speciality_code");
		sp_des=rs.getString("short_desc"); %>
	    sp_code[index]="<%=sp_code%>";
		 sp_des[index]="<%=sp_des%>";
		 index++;
		//end  Bru-HIMS-CRF-168 [IN030287]_0A
		<% maxRecord1 = rs.getInt("total");
		
	   
	
	}
	
	
	if(pstmt !=null) pstmt.close();
	if(rs !=null) rs.close();
	if(rad_installed_yn.equals("Y")){

		pstmt = conn.prepareStatement("SELECT count(1) as total FROM RD_APPT where patient_id='"+patientid+"' and trunc(APPT_DATE)>=trunc(sysdate)  AND NVL (appt_status, 1) != 'A'");

		rs = pstmt.executeQuery();	
		if(rs!=null){
			rs.next();
			rad_bkgs = rs.getInt("total");
		}
	}

if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();
	if(ip_installed_yn.equals("Y")){
String sql2="select count(1) as total from ip_booking_list where  patient_id='"+patientid+"' and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1";
		pstmt = conn.prepareStatement(sql2);

		rs = pstmt.executeQuery();	
		if(rs!=null){
			rs.next();
			ip_bkgs = rs.getInt("total");
		}
	}
	
	if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();
	%>
	parent.frames[0].document.forms[0].maxrecord.value='<%=maxRecord1%>';
	parent.frames[0].document.forms[0].ipbookings.value='<%=ip_bkgs%>';
	parent.frames[0].document.forms[0].radbookings.value='<%=rad_bkgs%>';
	parent.frames[2].document.forms[0].OtherAppts.disabled=true;
	parent.frames[2].document.getElementById("other_id1").style.visibility='hidden';
	<%if(dtl_msg_yn.equals("N") || dtl_msg_yn.equals("n") ){ 
	if(maxRecord1 !=0 || ip_bkgs !=0 || rad_bkgs!=0){%>


		parent.frames[2].document.forms[0].OtherAppts.disabled=false;
		parent.frames[2].document.getElementById("other_id1").style.visibility='visible';
		alert(getMessage("PAT_FUTURE_APPT_EXISTS",'OA'));
		<%} 
	}else{ 
            if(maxRecord1 !=0){	%>
			//below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A
          
		    parent.frames[2].document.forms[0].OtherAppts.disabled=false;
		    parent.frames[2].document.getElementById("other_id1").style.visibility='visible';
		    var main_msg=getMessage("PAT_FUTURE_APPT_EXISTS",'OA');
		
		   
		    var flag=0;
		    var msg1;
		    var msg2='';
            var dotvalidation=(sp_code.length-1);	
          
		  
		 
		      //VALIDATION FOR MULTIPLE RECORD	
			  
			  if(sp_code.length >=2)
			  {
			 
			  for(i=0;i<sp_code.length;i++)
			 { 
			 
            if(sp_code[i]=="<%=speciality_code%>")
		     { 
			 flag=1 
		      msg1=sp_des[i];
			 
			 }
			 else
			 {
			 
			  
			 if( dotvalidation > i )
		   {    
		   if(sp_code[sp_code.length-1]=="<%=speciality_code%>"){ msg2=msg2+sp_des[i]+"."}else{
		 
		   msg2=msg2+sp_des[i]+"," }
		   }
		   else{   
		   msg2=msg2+sp_des[i]+"." 
		
		   }
			 
			 
			 }
			 
			 } // for end;
			
             if( flag==1)
			 {
			  alert(main_msg+" in same Specialty; "+msg1+" & other Specialty(ies); "+msg2)
			
			 }
			else
			 {
			 alert (main_msg+" in other Specialty(ies); "+msg2)
			   }

			} //first if end
			 
			
			 
			 //VALIDATION FOR SINGLE RECORD
			
			if(sp_code.length ==1) 
			{
			  if(sp_code[0]== "<%=speciality_code%>")
			  {
			  alert (main_msg+" in same specialty; "+sp_des[0]+".")
			 } 
			 else 
			 { 
			 alert (main_msg+" in other specialty(ies); "+sp_des[0]+".") 
			 }
			 }
			 
			  
		  		   
	//end  Bru-HIMS-CRF-168 [IN030287]_0A
	
	<%}}
	%>
	
	<%
		String sql12="select count(1) total from pr_encounter where facility_id='"+facilityid+"' and patient_id='"+patientid+"'";
	pstmt = conn.prepareStatement(sql12);

	rs = pstmt.executeQuery();

	%>
	parent.frames[2].document.getElementById("previous_encounter").disabled = true;
	<%
	if(rs!=null){
		rs.next();
		prev_encntr = rs.getInt("total");
	}
	if(pstmt !=null) pstmt.close();
	if(rs !=null) rs.close();
%>

	<%if(prev_encntr !=0 ){%>
		parent.frames[2].document.getElementById("previous_encounter").disabled = false;
	<%}
	

	if(!alcn_criteria.equals("")){
		String pat_cat_desc="";
		pstmt = conn.prepareStatement("select STAT_GRP_ID, STAT_GRP_DESC from (select STAT_GRP_ID, STAT_GRP_DESC from am_stat_group UNION select '*O' STAT_GRP_ID,   'Others'  STAT_GRP_DESC from dual) where STAT_GRP_ID=NVL(GET_PAT_CAT_CODE('"+patientid+"'),'*O')");
		rs = pstmt.executeQuery();	
		if(rs!=null){
			if(rs.next())
			   pat_cat_code = rs.getString("STAT_GRP_ID");
			   pat_cat_desc = rs.getString("STAT_GRP_DESC");
		}

if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();
		if(!pat_cat_code.equals("")){%>
		var obj1=parent.frames[0].document.forms[0].pat_cat;
		while(obj1.options.length>0) obj1.remove(obj1.options[0]);
		opt=document.createElement('OPTION');
		opt.value='<%=pat_cat_code%>';
		opt.text='<%=pat_cat_desc%>';
		obj1.add(opt);
		parent.frames[0].document.forms[0].pat_cat.value='<%=pat_cat_code%>';
		parent.frames[0].document.forms[0].pat_category.value='<%=pat_cat_code%>';
				parent.frames[0].document.forms[0].pat_cat.value='<%=pat_cat_code%>';
				if(parent.frames[0].document.forms[0].pat_cat.value=="")
					parent.frames[0].document.forms[0].pat_cat.value="*O";

			<%if (!pat_cat_code.equals("*O")){%>	
					parent.frames[0].document.forms[0].pat_cat.disabled=true;
			<%}else{%>	
					parent.frames[0].document.forms[0].pat_cat.disabled=true;
			<%}
		}
	}



	if(visit_type_cd.equals("S")){
		
			stmt=conn.createStatement();
			String override_vtype_on_epsd_yn="";
		String sql = "select OVERRIDE_VTYPE_ON_EPSD_YN from op_param where OPERATING_FACILITY_ID='"+facilityid+"'" ;
		pstmt=conn.prepareStatement(sql);

		 rs=pstmt.executeQuery();

		int cnt=0;

		if(rs!=null && rs.next()){

	 override_vtype_on_epsd_yn = rs.getString("OVERRIDE_VTYPE_ON_EPSD_YN");
		}

		if(rs !=null)rs.close();
			if (override_vtype_on_epsd_yn.equals("N") && !visit_type_cd.equals("F")){
				String sql_one="";
				if(sel_service_code==null || sel_service_code.equals("")){
				sql_one="select count(*) count from pr_encounter where facility_id ='"+facilityid+"' and assign_care_locn_code = '"+cliniccode+"' and visit_adm_type_ind = 'F' and patient_id ='"+patientid+"' and patient_class = 'OP'";
				}else{
					sql_one="SELECT COUNT (*) COUNT FROM pr_encounter WHERE facility_id = '"+facilityid+"' AND service_code = '"+sel_service_code+"' and patient_id ='"+patientid+"'   AND visit_adm_type_ind = 'F' AND patient_class = 'OP'";
				}

		  rs=stmt.executeQuery(sql_one);
		  
		

		%>
		<%
	if(rs !=null && rs.next())
		 {
			cnt=rs.getInt("count");
			if (cnt==0){//validation for series visit - for incident no 36620 - called when series visit type is selected.
				if(sel_service_code==null || sel_service_code.equals("")){%>
				
				var err_age = getMessage( "FIRST_VISIT_ONLY_ALLOWED",'OA' ) ;
				alert(err_age);
				parent.frames[2].document.forms[0].recurring.disabled=true;
			<%}else{%>
				var err_age = getMessage( "NO_SERVICE_VISIT_FIRST_VISIT_ONLY",'OA' ) ;
				alert(err_age);
				parent.frames[2].document.forms[0].recurring.disabled=true;
			<%}
			}else{%>
				parent.frames[2].document.forms[0].recurring.disabled=false;
			<%}
		}
	}
	}
if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();

	

	
	if(rs != null) rs.close();
	if(rsc != null) rsc.close();
	if(stmtc !=null) stmtc.close();
	if(stmt !=null) stmt.close();
	if(pstmt !=null) pstmt.close();
	hash.clear();

}catch(Exception e) { 
	//out.println(e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
