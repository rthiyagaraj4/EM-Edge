<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%          
			request.setCharacterEncoding("UTF-8");
			Connection con = null;
            Statement stmt = null;
            ResultSet rset=null;
			String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		try{
			con=ConnectionManager.getConnection(request);
            stmt = con.createStatement();

            String servicecode="";
			String servicedesc="";
            String common=request.getParameter("Common_Text");
            String srv_code=request.getParameter("srv_code");
            String srv_desc=request.getParameter("srv_desc");
            String sectionType = request.getParameter("sectionType");
            if(sectionType == null) sectionType="";
            String toPopulatefs = request.getParameter("toPopulatefs");
            if(toPopulatefs == null) toPopulatefs="";

			String speciality=request.getParameter("speciality");
			if(speciality == null) speciality = "";
		
            String clinicSectionName=null, clinicSectionSql, clinicSectionCode=null;
				
			String facilityid=(String)session.getValue("facility_id");


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

			//Firing ClincSection query
         if(rset != null) rset.close();
		 

			rset=stmt.executeQuery(clinicSectionSql);

			//Creating Html Response for Populating section list item
			
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

      if(rset != null) rset.close();
	 
%>

<script language="javascript">
	function onLoadAction()
	{
		<%-- Reset Section and Service list boxes --%>
			
		var n=parent.frames[1].document.forms[0].service.options.length;
						
		for(var i=0;i<n;i++)	
			parent.frames[1].document.forms[0].service.remove("service");
		
		n=parent.frames[1].document.forms[0].section.options.length;

        for(var i=0;i<n;i++)	
			parent.frames[1].document.forms[0].section.remove("section");
			
		
		if(parent.document.frames[1].clinic_form.eff_status.checked==true)
        {
			var optService=parent.document.frames[1].document.createElement("OPTION");
            optService.text="  -------- "+getLabel("Common.defaultSelect.label","Common")+" --------  ";
            optService.value="";
			optService.selected=true;

			var optSection=parent.document.frames[1].document.createElement("OPTION");
            optSection.text="  -------- "+getLabel("Common.defaultSelect.label","Common")+" --------  ";
            optSection.value="";
			optSection.selected=true;
            
            
            if(parent.document.frames[1].document.forms[0].service != null)
			    parent.document.frames[1].document.forms[0].service.add(optService); 
			
			<%-- if() below added for section List Item --%>
			
			if(parent.document.frames[1].document.forms[0].section != null)	parent.document.frames[1].document.forms[0].section.add(optSection); 
			    
            var counter;
			if(parent.document.frames[1].document.forms[0].section != null)
			for(counter=0;counter<sectionLength;counter++){			optSection=parent.document.frames[1].document.createElement("OPTION");
            optSection.text=arraySectionName.pop();
            optSection.value=arraySectionCode.pop();
			parent.document.frames[1].document.forms[0].section.add(optSection);
			}
			

			if(parent.document.frames[1].document.forms[0].service != null)
			for(counter=0;counter<serviceLength;counter++){			optService=parent.document.frames[1].document.createElement("OPTION");
            optService.text=arrayServiceName.pop();
            optService.value=arrayServiceCode.pop();
			parent.document.frames[1].document.forms[0].service.add(optService);
			}
			            	
		}

	}<%-- function onLoadAction closes --%>

    
    </script> 
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>



</head>
	<body onload="onLoadAction();" CLASS='MESSAGE' onKeyDown = 'lockKey();'>
	
	
    <form name='nam1' id='nam1'>

<%

            
      }
      else if(toPopulatefs.equals("populate"))
      {
		String sql_l =" Select short_desc,fs_locn_code,permanent_file_area_yn, locn_identity from fm_storage_locn where facility_id = '"+facilityid+"' and locn_identity = '"+sectionType+"' and eff_status = 'E' order by short_desc ";
	            rset = stmt.executeQuery(sql_l);  
				out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
                if(rset != null) 
                {
%>                                  
    <script>
            var tp ="  -------- "+getLabel("Common.defaultSelect.label","Common")+" --------  ";
            var opt=parent.document.frames[1].document.createElement("OPTION");
            opt.text=tp;
            opt.value="";
            
            if(parent.document.frames[1].document.forms[0].mr_location_code != null)
                parent.document.frames[1].document.forms[0].mr_location_code.add(opt);                   
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
            var opt=parent.document.frames[1].document.createElement("OPTION");
            opt.text=temp1;
            opt.value=temp;
		 parent.document.frames[1].clinic_form.mr_location_code.value="<%=servicecode%>";
            
            if(parent.document.frames[1].document.forms[0].mr_location_code != null)
                parent.document.frames[1].document.forms[0].mr_location_code.add(opt);
   	
   	</script>
     			
<%     		
		}
     	}           
                  
           if(rset != null) rset.close();
		  
	  }
	  else
			{
		 String vitalsgncode="";
		 out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'  onKeyDown='lockKey();'><form name='nam1' id='nam1'>");

				String sql="select vital_signs_battery_id from am_speciality where eff_status='E' and speciality_code='"+speciality+"' order by short_desc";
				   rset = stmt.executeQuery(sql);  
				   if(rset != null)
				{
					   while (rset.next())
					{
						   
						  vitalsgncode=rset.getString(1);
						   
							
					}
					%>
					<script language ='javascript'>
						var objlength=parent.frames[1].document.forms[0].vitalsignsb.length;
					for(i=1;i<objlength;i++)
					{					
						
						if(parent.frames[1].document.forms[0].vitalsignsb.item(i).value == "<%=vitalsgncode%>" )
						{
							parent.frames[1].document.forms[0].vitalsignsb.item(i).selected=true;
						}						
					}
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



					<%
				}

			if(rset != null) rset.close();
			

			}
			
       
   if (stmt != null) stmt.close();
	}catch(Exception e) { 
		e.printStackTrace();
		//out.println(e.toString());
		
		}
    finally
    {
      if (stmt != null) stmt.close();
      if (rset != null) rset.close();
      if(con!=null) ConnectionManager.returnConnection(con,request);
    }
        out.println("</form></body></html>");       
                            
%>          
            
            

