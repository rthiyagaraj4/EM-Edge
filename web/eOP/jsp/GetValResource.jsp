<!DOCTYPE html>
<%@ page import ="java.sql.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>


<%          
            request.setCharacterEncoding("UTF-8"); 
			request= new XSSRequestWrapper(request);
	        response.addHeader("X-XSS-Protection", "1; mode=block");
	        response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con = null;
            Statement stmt = null;
            ResultSet rset=null;
			Statement dfstmt=null;
			ResultSet dfrset=null;
						
			String default_code="";
			String default_desc="";
			String fmInstallyn="";
			String mrcode="";
			String mrdesc="";
			String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
try
{
	con=ConnectionManager.getConnection(request);
    stmt = con.createStatement();
	String servicecode="";
	String servicedesc="";

	String common=request.getParameter("Common_Text");
	String srv_code=request.getParameter("srv_code");
	String srv_desc=request.getParameter("srv_desc");
	String sectionType = request.getParameter("sectionType");
	String defaultlocn=request.getParameter("defaultlocn");
	if(defaultlocn == null) defaultlocn="";
	String centralValue=request.getParameter("centralValue");
       if(centralValue==null)centralValue="";
	fmInstallyn=request.getParameter("fminstall");
	if(sectionType == null) sectionType="";
	String toPopulatefs = request.getParameter("toPopulatefs");
	if(toPopulatefs == null) toPopulatefs="";

	String mrsectionName=request.getParameter("mrsectionName");
	if(mrsectionName==null)mrsectionName="";
	String seperatefile=request.getParameter("seperatefile");
	if(seperatefile==null)seperatefile="";
	String sormid=request.getParameter("sormfiles");
	if(sormid==null)sormid="";

	String speciality=request.getParameter("speciality");
	if(speciality == null) speciality = "";
	String callfunction=request.getParameter("callfunction");
	String levelfcare=(request.getParameter("levelfcare")==null)?"":request.getParameter("levelfcare");

	String clinicSectionName=null, clinicSectionSql, clinicSectionCode=null;
	String facilityid=(String)session.getValue("facility_id");
    String sectionPop=request.getParameter("sectionpop");
	 if(sectionPop==null)sectionPop="";
	 String revisVisitFlag = request.getParameter("revisVisitFlag")==null?"":request.getParameter("revisVisitFlag");
	 String p_to_locn_code = request.getParameter("p_to_locn_code")==null?"":request.getParameter("p_to_locn_code");
	 String p_referral_id = request.getParameter("p_referral_id")==null?"":request.getParameter("p_referral_id");
	 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	 String callingfrom = request.getParameter("callingfrom")==null?"":request.getParameter("callingfrom");
	 String multi_speciality_yn = request.getParameter("multi_speciality_yn")==null?"N":request.getParameter("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
	  String sql_1="";
	  String sql_2="";
	  String to_locn_code="";
	  String p_patient_id="";

	 
	if(revisVisitFlag.equals("Y")) {
		String refSql = "select to_locn_code,patient_id from PR_REFERRAL_REGISTER where REFERRAL_ID= '"+p_referral_id+"' and to_facility_id = '"+facilityid +"'  ";		
		
		rset=stmt.executeQuery(refSql.toString());
		if ( !rset.next() ) 
		{
			if(!callingfrom.equals("IP")){
			out.println("<script>alert(getMessage('INVALID_REF_ID','OP'));parent.frames[2].document.forms[0].referal_id1.value='';</script>");	out.println("<script>parent.frames[3].location.href='../../eCommon/jsp/error.jsp';</script>");	
			} else {				out.println("<script>alert(getMessage('INVALID_REF_ID','OP'));parent.frames[1].document.forms[0].referral_id.value='';</script>");	out.println("<script>parent.frames[2].location.href='../../eCommon/jsp/error.jsp';</script>");	
			}
		} else {
			to_locn_code = rset.getString("to_locn_code");
			p_patient_id = rset.getString("patient_id");
			if(to_locn_code=="null" || to_locn_code==null) to_locn_code = "";
			if(p_patient_id=="null" || p_patient_id==null) p_patient_id = "";			
			
			 if(!p_patient_id.equals(patient_id)){
				  out.println("<script>alert(getMessage('MISMATCH_REFERRALID_PATIENTID','COMMON'))</script>");	
				  if(!callingfrom.equals("IP"))
				    out.println("<script>parent.frames[2].document.forms[0].referal_id1.value='';</script>");	
				  else
					  out.println("<script>parent.frames[1].document.forms[0].referral_id.value='';</script>");	
			  } else if(!to_locn_code.equals(p_to_locn_code)){
				  out.println("<script>alert(getMessage('MISMATCH_REFERRALID_CLINIC','COMMON'))</script>");	
				  if(!callingfrom.equals("IP"))
				    out.println("<script>parent.frames[2].document.forms[0].referal_id1.value='';</script>");	
				  else
					  out.println("<script>parent.frames[1].document.forms[0].referral_id.value='';</script>");	
			  }
			if(!callingfrom.equals("IP")){
			 out.println("<script>parent.frames[3].location.href='../../eCommon/jsp/error.jsp';</script>");	
			} else {
				out.println("<script>parent.frames[2].location.href='../../eCommon/jsp/error.jsp';</script>");	
			}
		} 
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
  }
	
	if(sectionPop.equals("sectionPop"))
	{
	if(toPopulatefs.equals(""))
	{
		if(srv_code == null) srv_code="";
		if(srv_desc == null) srv_desc="";
		
		String sql = "select service_code,service_short_desc from am_facility_service_vw where eff_status = 'E' and operating_facility_id ='"+facilityid+"' and medical_yn='Y' and dept_Code='" + common.trim() + "' order by service_short_desc desc";
		rset = stmt.executeQuery(sql);          
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
				
		clinicSectionSql="Select clinicSection.SHORT_DESC clinicSectionName, clinicSection.SECTION_CODE clinicSectionCode from am_dept_section clinicSection, am_facility_section facilitySection where clinicSection.DEPT_CODE = facilitySection.DEPT_CODE and clinicSection.SECTION_CODE = facilitySection.SECTION_CODE and clinicSection.EFF_STATUS = 'E' and clinicSection.DEPT_CODE = '"+common.trim()+"' and facilitySection.OPERATING_FACILITY_ID='"+facilityid+"' order by 1 desc";

		   
			
%>

<script language="javascript">
	var counter,arrayServiceName,arrayServiceCode,arraySectionName,arraySectionCode,selectServiceCodeIndex,sectionLength=0,serviceLength=0;
</script>

<%
  	  if(rset != null) 
		{    
%>       
            <script language="javascript">
             arrayServiceCode=new Array();
             arrayServiceName=new Array();
<%
	  	int counter=0;
		while( rset.next() ) 
		{
			counter++;
			servicecode=rset.getString("service_code");
			servicedesc=rset.getString("service_short_desc");
		%>
			arrayServiceCode.push("<%=servicecode%>");
			arrayServiceName.push("<%=servicedesc%>");
		<%
    	}
%>
serviceLength=<%=counter%>;
 </script>
<%
		}
      if(rset != null )rset.close();
	 
	  rset=stmt.executeQuery(clinicSectionSql);
	
		if(rset!=null)
		{
		
%>

<script language="javascript">
arraySectionCode=new Array();
arraySectionName=new Array();	


<%
			int counter=0;
			while(rset.next())
			{
				counter++;
				clinicSectionName=rset.getString("clinicSectionName");
				clinicSectionCode=rset.getString("clinicSectionCode");
			%>
 			    arraySectionCode.push("<%=clinicSectionCode%>");
			    arraySectionName.push("<%=clinicSectionName%>");
			<%                
			}
%>
	sectionLength=<%=counter%>;
	</script>
<%
		}

      if(rset != null )rset.close();
	 
%>

<script language="javascript">
function onLoadAction()
{
	var n=parent.f_query_add_mod.document.clinic_sub.document.forms[0].service.options.length;
	for(var i=0;i<n;i++)	
		parent.f_query_add_mod.document.clinic_sub.document.forms[0].service.remove("service");
		n=parent.f_query_add_mod.document.clinic_sub.document.forms[0].section.options.length;
	for(var i=0;i<n;i++)	
		parent.f_query_add_mod.document.clinic_sub.document.forms[0].section.remove("section");
	if(parent.f_query_add_mod.frames[0].document.clinic_main_resource_form.eff_status.checked==true)
	{
		var optService=parent.document.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
		optService.text="  --------"+getLabel('Common.defaultSelect.label','Common')+"--------  ";
		optService.value="";
		optService.selected=true;

		var optSection=parent.document.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
		optSection.text="  -------- "+getLabel('Common.defaultSelect.label','Common')+" --------  ";
		optSection.value="";
		optSection.selected=true;
		
		
		if(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].service != null)
			parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].service.add(optService); 
		
		<%-- if() below added for section List Item --%>
		
		if(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].section != null)	parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].section.add(optSection); 
			
		var counter;
		if(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].section != null)
		for(counter=0;counter<sectionLength;counter++){			optSection=parent.document.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
		optSection.text=arraySectionName.pop();
		optSection.value=arraySectionCode.pop();
		parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].section.add(optSection);
		}
		

		if(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].service != null)
		for(counter=0;counter<serviceLength;counter++){			optService=parent.document.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
		optService.text=arrayServiceName.pop();
		optService.value=arrayServiceCode.pop();
		parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].service.add(optService);
		}
						
	}

}<%-- function onLoadAction closes --%>
</script>           
</head>
<body onload="onLoadAction();" CLASS='MESSAGE' onKeyDown = 'lockKey();'>
<form name='nam1' id='nam1'>
<%
	
}
}
else if(mrsectionName.equals("mr_section_type"))
	{
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'  onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
	   if(!sectionType.equals("")){
		   	   
	   if(sectionType.equals("C"))
		{
	    if(seperatefile.equals("N")){
			
		sql_2="select mr_section_code,short_name from mr_section where facility_id='"+facilityid+"' and mr_section_type ='C'  and eff_status='E' order by short_name";
		rset=stmt.executeQuery(sql_2);
		}
		}else if(sectionType.equals("D"))
		{
		sql_2="select mr_section_code,short_name from mr_section where facility_id='"+facilityid+"' and mr_section_type = 'D' and eff_status='E' order by short_name";
		rset=stmt.executeQuery(sql_2);
		}
		
		if(rset!=null)
			{
			while(rset.next())
				{
				  mrcode=rset.getString(1);
				  mrdesc=rset.getString(2);
				%><script>
				var opt=parent.document.
				f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
                opt.text="<%=mrdesc%>";
				opt.value="<%=mrcode%>";
			parent.f_query_add_mod.document.clinic_sub.document.forms[0].mr_section.add(opt);
				</script>

				<%}
			}

		 if(rset != null ) rset.close();
		 
	 if(toPopulatefs.equals("populatefs"))
    {
	 
	  if(sectionType.equals("C")){
	  sql_1 =" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityid+"' and  permanent_file_area_yn='N' and locn_identity = '"+centralValue+"' and eff_status = 'E' order by short_desc ";
	  }else if(sectionType.equals("D")){
	  sql_1 ="Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityid+"' and eff_status = 'E' and MR_LOCN_YN='Y' and permanent_file_area_yn='Y' and locn_identity = '"+centralValue+"' order by short_desc ";
	  
	  }
	rset = stmt.executeQuery(sql_1);  
	if(rset != null) 
	{
%>                                  
<script>
		
		var opt=parent.document.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
	                   
</script>           
								
<%              
		while( rset.next() ) 
		{
		String fs_locn_code=rset.getString("fs_locn_code");
		String short_desc=rset.getString("short_desc");     	
%>
<script>
		var temp = "<%=fs_locn_code%>";
		var temp1="<%=short_desc%>";
		var opt=parent.document.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
		opt.text=temp1;
		opt.value=temp;
	 parent.document.f_query_add_mod.document.clinic_sub.document.clinic_resource_form.mr_location_code.value="<%=servicecode%>";
		
		if(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].mr_location_code != null)
		parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].mr_location_code.add(opt);

</script>
			
<%     		
		}
	}           
 
         if(rset != null ) rset.close();
	}
  }
  else
  {	    		
	 if(toPopulatefs.equals("populatefs"))
    { 	 
	  sql_1 =" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityid+"' and  permanent_file_area_yn='N' and locn_identity = '"+centralValue+"' and eff_status = 'E' order by short_desc "; 
    }
	rset = stmt.executeQuery(sql_1);  
	if(rset != null) 
	{
%>                                  
<script>
		
		var opt=parent.document.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
	                   
</script>           
								
<%              
		while( rset.next() ) 
		{
		String fs_locn_code=rset.getString("fs_locn_code");
		String short_desc=rset.getString("short_desc");     	
%>
<script>
		var temp = "<%=fs_locn_code%>";
		var temp1="<%=short_desc%>";
		var opt=parent.document.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
		opt.text=temp1;
		opt.value=temp;
	 parent.document.f_query_add_mod.document.clinic_sub.document.clinic_resource_form.mr_location_code.value="<%=servicecode%>";
		
		if(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].mr_location_code != null)
		parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].mr_location_code.add(opt);

</script>
			
<%     		
		}
	}           
 
         if(rset != null ) rset.close();
	}


}
else if(toPopulatefs.equals("populatevs"))
{
	 String vitalsgncode="";
	 out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");

	 String sql="select vital_signs_battery_id,multi_speciality_yn from am_speciality where eff_status='E' and speciality_code='"+speciality+"' order by short_desc";//modified for the crf - Bru-HIMS-CRF-0198
			
	   rset = stmt.executeQuery(sql);  
	 	 if(rset != null)
			{
				while (rset.next())
				{
					vitalsgncode=rset.getString("vital_signs_battery_id");
					multi_speciality_yn=rset.getString("multi_speciality_yn");//Added for the CRf - Bru-HIMS-CRf-0198
				}
				%>
				<script language ='javascript'>
					var objlength=parent.f_query_add_mod.document.clinic_sub.document.forms[0].vitalsignsb.length;
	
					for(i=1;i<objlength;i++)
					{					
						if(parent.f_query_add_mod.document.clinic_sub.document.forms[0].vitalsignsb.item(i).value == "<%=vitalsgncode%>" )
						{
							parent.f_query_add_mod.document.clinic_sub.document.forms[0].vitalsignsb.item(i).selected=true;
						}						
					}
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%
				//Added for the CRF - Bru-HIMS - CRF - 0198
				if(multi_speciality_yn.equals("Y")){%>
				<script>
				parent.f_query_add_mod.document.clinic_sub.document.forms[0].multi_speciality_yn.value='Y';
				if(parent.f_query_add_mod.document.clinic_sub.document.forms[0].centralValue.value!='Y'){
					if(parent.f_query_add_mod.document.clinic_sub.document.forms[0].function_name.value=='modify'){
					parent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.remove(1);
					var opt1=document.createElement("OPTION");
					opt1.text=getLabel("Common.room.label","Common");
					opt1.value="R";
						
					parent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.add(opt1);
					}
				parent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.value='R';
				parent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.disabled=true;
				parent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.onchange();
				}
				
				</script>	
				<%}
			}

		if(rset != null )rset.close();
	   
		}else if(toPopulatefs.equals("populateDF"))
		{
		
		StringBuffer dfsql=new StringBuffer();

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
		
		if(fmInstallyn.equals("Y"))
		{
			dfsql.append("select a.file_type_code file_type_code,b.short_desc  file_type_desc from fm_file_type_for_fsl a,mr_file_type b where b.facility_id ='"+facilityid+"'  and a.facility_id = b.facility_id and a.fs_locn_code ='"+defaultlocn+"' and a.file_type_code = b.file_type_code "); 
		   if((levelfcare.equals("A"))&&(!callfunction.equals("DaycareUnit")))
			 dfsql.append(" and b.appl_to_op='Y'");
			else if((levelfcare.equals("A"))&&(callfunction.equals("DaycareUnit")))
			 dfsql.append(" and b.appl_to_dc='Y'");
			else if(levelfcare.equals("E"))
             dfsql.append(" and b.appl_to_em='Y'");
		}
		else if(fmInstallyn.equals("N"))
		{
			dfsql.append("select file_type_code,SHORT_DESC file_type_desc from mr_file_type  	where facility_id ='"+facilityid+"' and EFF_STATUS = 'E'");
			if((levelfcare.equals("A"))&&(!callfunction.equals("DaycareUnit")))
			 dfsql.append(" and appl_to_op='Y'");
			else if((levelfcare.equals("A"))&&(callfunction.equals("DaycareUnit")))
			 dfsql.append(" and appl_to_dc='Y'");
			else if(levelfcare.equals("E"))
             dfsql.append(" and appl_to_em='Y'");
		} 
			dfsql.append(" order by file_type_desc ");
		 
		
			dfstmt=con.createStatement();
			dfrset=dfstmt.executeQuery(dfsql.toString());

			if(dfrset!=null)
			{
				while(dfrset.next())
				{
					  default_code=dfrset.getString("file_type_code");
					  default_desc=dfrset.getString("file_type_desc");
					  %>
					  <script>
						var opt= parent.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
						opt.text="<%=default_desc%>";
						opt.value="<%=default_code%>";
						parent.f_query_add_mod.document.clinic_sub.document.forms[0].dflt_file_type.add(opt);
					  </script>
					<%
				}
			}
		     if(dfrset != null )dfrset.close();
			 if(dfstmt != null )dfstmt.close();
			 dfsql.setLength(0);
			 
		}
		 else if(toPopulatefs.equals("populatept"))
		{
			String sql="";
			String primaryrestype="";
			String primaryrestypedesc="";
			String primaryresclass=(request.getParameter("primary_res_class") == null)?"":request.getParameter("primary_res_class");
			out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
			if(primaryresclass.equals(""))
			{
			%>
					<script>
			var len=parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.length;	
			 for(i=1;i<len;i++)
		    parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.remove(1);
			 var opt=document.createElement("OPTION");
			var opt1=document.createElement("OPTION");
			opt1.text=getLabel('eOP.NotIdentifiable.label','OP');				
			opt1.value="X";
			opt.text=getLabel('Common.resource.label','Common');				
			opt.value="P";
	        parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt1);
	        parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);
			 
			 </script>
				 <%
				if(levelfcare.equals("E"))
				{
					%><script>
				var 
opt=document.createElement("OPTION");
				opt.text=getLabel('eOP.NotIdentifiable.label','OP');	
				opt.value="X";
				opt.selected=true;
				opt.disabled=true;
		parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);
		parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.disabled=true;
		parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.checked=true;	
			</script>
				<%
				}else{
		 
		 %><script>
		parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.disabled=false;
		 parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.checked=false;
		parent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_type.disabled=false;
		</script>
			<%
			}
			}
			if(!primaryresclass.equals(""))
			{
			if(primaryresclass.equals("P"))
			{
			  if(levelfcare.equals("A")){
			 %>
				<script>
			var len=parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.length;	
			 for(i=1;i<len;i++)
		parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.remove(1);
		
			var opt=document.createElement("OPTION");
			var opt1=document.createElement("OPTION");
			opt1.text=getLabel('eOP.NotIdentifiable.label','OP');	
			opt1.value="X";
			opt.text=getLabel('Common.resource.label','Common');
			opt.value="P";
	 parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt1);
	 parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);
	 parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.disabled=false;
				 </script>
				<%
			  }else	 if(levelfcare.equals("E"))
				{
					%><script>
				var 
opt=document.createElement("OPTION");
				opt.text=getLabel('eOP.NotIdentifiable.label','OP');	
				opt.value="X";
				opt.selected=true;
				opt.disabled=true;
			parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);
				</script>
				<%
				}

				 sql="select pract_type, desc_sysdef from am_pract_type where eff_status='E' order by seq_no";
			}
			else {
				
				if(levelfcare.equals("A")){
				%>
				<script>
			var len=parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.length;
	 for(i=1;i<len;i++)
		parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.remove(1);
			var opt=document.createElement("OPTION");
			opt.text=getLabel('Common.resource.label','Common');
			opt.value="P";
			opt.selected=true;
	  parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);
	  parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.disabled=true;
	  parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.checked=false;
	  parent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_type.disabled=false;
			</script>
				<%
			}else if(levelfcare.equals("E"))
				{
					%><script>
				var 
opt=document.createElement("OPTION");
				opt.text=getLabel('eOP.NotIdentifiable.label','OP');
				opt.value="X";
				opt.selected=true;
				opt.disabled=true;
				parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);
				</script>
				<%
				}
			if(primaryresclass.equals("R"))
			{
			sql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' order by short_desc";
			}else if(primaryresclass.equals("E"))
			{
				
				sql="select resource_type,short_desc from am_resource_type where resource_class='E' order by short_desc";
			 }else if(primaryresclass.equals("O"))
			{
				sql="select resource_type,short_desc from am_resource_type where resource_class='O' order by short_desc";
			}
		
			}
				rset=stmt.executeQuery(sql);
				if(rset != null)
				{
					while(rset.next())
					{
						primaryrestype=rset.getString(1);
						primaryrestypedesc=rset.getString(2);
						%>
						<script>
							 var opt=parent.document.f_query_add_mod.document.clinic_sub.document.createElement("OPTION");
							opt.text="<%=primaryrestypedesc%>";
							opt.value="<%=primaryrestype%>";
							if(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_type != null)
							parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_type.add(opt);
						</script>
							<%

					}
				}				
			
			if(rset != null ) rset.close();
			
			}
			
		}
		else if(toPopulatefs.equals("populateOther"))
	{
		String oth_class=request.getParameter("oth_class");
		if(oth_class == null) oth_class="";
	

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
		String osql="";
		String othres="";
		String othresDesc="";
		if(!oth_class.equals(""))
		{
		if(oth_class.equals("R"))
			{
			osql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' order by short_desc";
			}else if(oth_class.equals("E"))
			{
				
				osql="select resource_type,short_desc from am_resource_type where resource_class='E' order by short_desc";
			 }else if(oth_class.equals("O"))
			{
				osql="select resource_type,short_desc from am_resource_type where resource_class='O' order by short_desc";
			}
			rset=stmt.executeQuery(osql);
			if(rset != null)
			{
				while(rset.next())
				{
				  othres=rset.getString(1);
				  othresDesc=rset.getString(2);
				  %>
				<script>
				 var opt=parent.document.frames[1].document.frames[1].document.createElement("OPTION");
				 opt.text="<%=othresDesc%>";
				 opt.value="<%=othres%>";
				 
				 parent.document.frames[1].document.frames[1].document.forms[0].other_type.add(opt);
				</script>
				<%
				}
			}
		}
			if(rset != null) rset.close();
	}else if(toPopulatefs.equals("pract_check"))
	{
		String pract_name=request.getParameter("pract_obj");
		if(pract_name == null) pract_name="";
		String cliniccode=request.getParameter("cliniccode");
		if(cliniccode == null) cliniccode="";
		int practcnt=0;
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");

		String sql="select count(*) from op_pract_for_clinic where clinic_code='"+cliniccode+"' and resource_class='P' and "+pract_name+" ='W' ";

		rset=stmt.executeQuery(sql);
		if(rset != null)
		{
			if(rset.next())
			{
				practcnt=rset.getInt(1);
			}
		}
		if(rset != null) rset.close();
		if(practcnt > 0)
		{%>
			<script>
			alert(getMessage('PRACT_WORKING_CAN_NOT_UNCHECK','OP'));
			eval("parent.f_query_add_mod.clinic_sub.document.forms[0]."+"<%=pract_name%>").checked=true;
			eval("parent.f_query_add_mod.clinic_sub.document.forms[0]."+"<%=pract_name%>").value="W";
			eval("parent.f_query_add_mod.clinic_sub.document.forms[0]."+"<%=pract_name%>"+"1").value="W";

			</script>
		<%}
	}else if(toPopulatefs.equals("pract_check1"))
	{
		String pract_name=request.getParameter("pract_obj");
		if(pract_name == null) pract_name="";
		String cliniccode=request.getParameter("cliniccode");
		if(cliniccode == null) cliniccode="";
		int practcnt=0;
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
		
		for(int i=1;i<=5;i++)
		{

		String sql="select count(*) from op_pract_for_clinic where clinic_code='"+cliniccode+"' and resource_class='P' and working_week_"+i+"_day_"+pract_name+" ='W' ";
		rset=stmt.executeQuery(sql);
		if(rset != null)
		{
			if(rset.next())
			{
				practcnt=rset.getInt(1);
			}
		}
		if(rset != null) rset.close();
		if(practcnt > 0)
		{%>
			<script>
			
		eval("parent.f_query_add_mod.clinic_sub.document.forms[0].working_week_"+"<%=i%>"+"_day_"+"<%=pract_name%>").checked=true;
		eval("parent.f_query_add_mod.clinic_sub.document.forms[0].working_week_"+"<%=i%>"+"_day_"+"<%=pract_name%>"+"1").value="W";

			</script>
		<%}else{%>
				<script>
				eval("parent.f_query_add_mod.clinic_sub.document.forms[0].working_week_"+"<%=i%>"+"_day_"+"<%=pract_name%>").checked=false;
		eval("parent.f_query_add_mod.clinic_sub.document.forms[0].working_week_"+"<%=i%>"+"_day_"+"<%=pract_name%>"+"1").value="N";

			</script>
		<%}
	}
  }	
if (stmt != null) stmt.close();   
	
}catch(Exception e) { 
	e.printStackTrace();
		}
    finally
    {
		try{

			if(rset != null) rset.close();
			if(stmt != null) stmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}
       if(con!=null) ConnectionManager.returnConnection(con,request);
    }
        out.println("</form></body></html>");       
                            
%>          
            
            

