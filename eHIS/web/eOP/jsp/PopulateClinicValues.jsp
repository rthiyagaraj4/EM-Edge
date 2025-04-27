<!DOCTYPE html>

<%@ page import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>

<%
	request.setCharacterEncoding("UTF-8");
	//String clinic_typ = request.getParameter("clinic_code");
	String clinic_code1 = request.getParameter("clinic_code1");
	String care_ind=request.getParameter("care_ind");
	
	String facility_id=(String)session.getValue("facility_id");
	
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;

	String clinic_type="";
	String age_group="";
	String department="";
	String dept_code = "";
	String service="";
	String nursing_unit_short_desc="";
	String specialty_desc="";
	StringBuffer sql=new StringBuffer();
	String short_desc="";
	
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	try{
		    con = ConnectionManager.getConnection(request);
			stmt= con.createStatement();
			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body>");
				
			StringBuffer sql_check = new StringBuffer();
			
			sql_check.append("Select count(*) from op_clinic ");
			sql_check.append("where upper(care_locn_type_ind)=upper('"+care_ind+"') and ");
			sql_check.append("facility_id='"+facility_id+"' and eff_status = 'E' ");
			
			
			ResultSet rs_check=stmt.executeQuery(sql_check.toString());
			rs_check.next();
			int count=rs_check.getInt(1);
			
			if(rs_check != null) rs_check.close();
		 
		    sql_check.setLength(0);
			
			%>
			<script> 
			var obj=parent.frames[1].frames[0].document.forms[0].clinic_code1;
			    var length = obj.length;
			    for(i=0;i<length;i++)
				    obj.remove(1);
			</script>
		<%	if(count==0) 
			{%>
				<script>
	
			    alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));
	
				parent.frames[1].frames[0].location.reload();
				parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
				
			</script>
			<%}
			else
			{
				
			/* sql.append("Select clinic_code, long_desc from op_clinic where (care_locn_type_ind='"+care_ind+"') and clinic_type in (select locn_type from am_care_locn_type where locn_type='"+clinic_typ+"') and facility_id='"+facility_id+"'  order by 2");
		
			 rs = stmt.executeQuery(sql.toString()) ;
				
				if(rs!=null)
				{
					while (rs.next())
					{			
						 clinic_type = rs.getString(1);	
						 if(clinic_type==null) clinic_type="";
				 
						 short_desc = rs.getString(2);
						 if(short_desc==null) short_desc="";
				*/
				 	%>
			<!--
			<script>
			         opt=parent.document.frames[1].document.createElement("OPTION");
				     opt.text="<%=short_desc%>";
				     opt.value="<%=clinic_type%>";
					 parent.frames[1].frames[0].document.forms[0].clinic_code1.add(opt);
					 if("<%=clinic_type%>"=="<%=clinic_code1%>")
		             opt.selected=true;
				 		
                </script>
			-->

				<%	
				/*
				}
				}
				
				if(rs != null) rs.close();
				*/

				sql.setLength(0);

		   sql.append("SELECT CARE_LOCN_DESC,AGE_GROUP_DESC,DEPT_DESC,SERVICE_DESC, SPECIALITY_DESC,DEPT_CODE  FROM OP_CLINIC_VW WHERE clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+care_ind+"' and facility_id='"+facility_id+"' ");
            
			rs = stmt.executeQuery(sql.toString()) ;
			if(rs!=null)
			{
			while (rs.next())
				{			
                   		 clinic_type = rs.getString(1);	
						 if(clinic_type==null) clinic_type="";
				 
						 age_group = rs.getString(2);
						 
						 if(age_group==null) age_group="";
				 
						 department = rs.getString(3);	
						 if(department==null) department="";

						 service = rs.getString(4);
				 
						 specialty_desc = rs.getString(5);
	
						 nursing_unit_short_desc=rs.getString(5);
					    if(nursing_unit_short_desc==null) nursing_unit_short_desc="";
				 
						dept_code = rs.getString(6);
						if (dept_code==null) dept_code = "";

						nursing_unit_short_desc = java.net.URLEncoder.encode(nursing_unit_short_desc);
		
%>	

             <script>
	            parent.frames[1].frames[0].document.forms[0].Search.disabled=false;
				parent.frames[1].frames[0].document.getElementById("tab").style.visibility='visible';	

				parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
				parent.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
			  
				parent.frames[1].frames[0].document.getElementById("td2").innerHTML="<b><%=age_group%></b>";
				
				parent.frames[1].frames[0].document.forms[0].dept_desc.value="<%=dept_code%>";
				parent.frames[1].frames[0].document.getElementById("td6").innerHTML="<b><%=specialty_desc%></b>";
			
			    if (parent.frames[1].frames[0].document.forms[0].dept_code)		
				parent.frames[1].frames[0].document.forms[0].dept_code.value="<%=dept_code%>";
				
				parent.frames[1].frames[0].document.getElementById("td4").innerHTML="<b><%=service%></b>";
		
				parent.frames[1].frames[0].document.forms[0].Search.focus();
				</script>
<%
				}
			}
			else
				{%>
		     		
				<script>
				
			    alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));
				parent.frames[1].frames[0].document.forms[0].clinic_code1.focus();
				return false;

				</script>

				<%}

		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();

        sql.setLength(0);

		}catch(Exception e) { out.println("Main : "+e.toString());}
	finally
	{
		try{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		}catch(Exception e) {}
		if(con != null) ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
	
%>	

