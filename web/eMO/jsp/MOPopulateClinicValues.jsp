<!DOCTYPE html>



<%@ page import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<%
	
	Statement stmt					= null;
	ResultSet rs					= null;
	Connection con					= null;
	StringBuffer sql				= new StringBuffer();
	request.setCharacterEncoding("UTF-8");
	String clinic_typ				= request.getParameter("clinic_code");
	String clinic_code1				= request.getParameter("clinic_code1");
	String care_ind					= request.getParameter("care_ind");
	String facility_id				= (String)session.getValue("facility_id");
	String clinic_type				= "";
	String age_group				= "";
	String department				= "";
	String dept_code				= "";
	String nursing_unit_short_desc	= "";
	String short_desc				= "";
    String sStyle	                =   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	try{
		    con = ConnectionManager.getConnection(request);
			
			if(clinic_typ.equals("N"))
		    {
		         sql.append("select NURSING_UNIT_CODE,short_desc from  ip_nursing_unit_lang_vw where language_id='"+localeName+"' and eff_status='E' order by 2");
		         stmt	= con.createStatement();
			     rs		= stmt.executeQuery(sql.toString()) ;%>
				
			 <script> 
			    var obj		= parent.frames[1].document.forms[0].clinic_code1;
			    var length	= obj.length;
			    for(i=0;i<length;i++)
				    obj.remove(1);
			</script>
			<%	if(rs!=null)
				{
					while (rs.next())
					{			
						 clinic_type	= rs.getString(1);	
						 if(clinic_type==null) clinic_type="";
				 
						 short_desc		= rs.getString(2);
						 if(short_desc==null) short_desc="";
				 	%>
				<script>
			         opt		= parent.frames[1].document.createElement("OPTION");
				     opt.text	= "<%=short_desc%>";
				     opt.value	= "<%=clinic_type%>";
					 parent.frames[1].document.forms[0].clinic_code1.add(opt);
					 if("<%=clinic_type%>"=="<%=clinic_code1%>")
		             opt.selected= true;
                </script>
				<%	}
				}
				if(rs != null) rs.close();
				sql.setLength(0);
		   }else
		   {
			
			stmt			= con.createStatement();
			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body>");
				
			StringBuffer sql_check = new StringBuffer();
			
			sql_check.append("Select count(*) from op_clinic ");
			sql_check.append("where upper(care_locn_type_ind)=upper('"+care_ind+"') and ");
			sql_check.append("facility_id='"+facility_id+"' and eff_status = 'E' ");
			
			
			ResultSet rs_check	=stmt.executeQuery(sql_check.toString());
			rs_check.next();
			int count			=rs_check.getInt(1);
			
			if(rs_check != null) rs_check.close();
		 
		    sql_check.setLength(0);
			
			%>
			<script> 
				var obj=parent.frames[1].document.forms[0].clinic_code1;
			    var length = obj.length;
			    for(i=0;i<length;i++)
				    obj.remove(1);
			</script>
		<%	if(count==0) 
			{%>
			<script>
			    //parent.frames[1].frames[0].location.reload();
				//parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
				// Modified against - PAS-MO-Deceased Registration [IN:045484] by Lenin 		
				parent.frames[1].location.reload();
				parent.frames[1].location.href="../../eCommon/html/blank.html";
				//[IN:045484] ends
				
			</script>
			<%}
			else
			{
			 sql.append("Select clinic_code, short_desc from op_clinic_lang_vw where (care_locn_type_ind='"+care_ind+"') and clinic_type in (select locn_type from am_care_locn_type where locn_type='"+clinic_typ+"') and facility_id='"+facility_id+"' and language_id = '"+localeName+"' and eff_status='E' order by 2");
		
			 rs = stmt.executeQuery(sql.toString()) ;

			 if(rs!=null)
				{
					while (rs.next())
					{			
						 clinic_type = rs.getString(1);	
						 if(clinic_type==null) clinic_type="";
				 
						 short_desc = rs.getString(2);
						 if(short_desc==null) short_desc="";
				 	%>
				<script>
			         opt=parent.frames[1].document.createElement("OPTION");
				     opt.text="<%=short_desc%>";
				     opt.value="<%=clinic_type%>";
					 parent.frames[1].document.forms[0].clinic_code1.add(opt);
					 if("<%=clinic_type%>"=="<%=clinic_code1%>")
		             opt.selected=true;
                </script>
				<%	}
				}
				if(rs != null) rs.close();
				sql.setLength(0);

		    sql.append("SELECT CARE_LOCN_DESC,AGE_GROUP_DESC,DEPT_DESC,SERVICE_DESC, SPECIALITY_DESC,DEPT_CODE  FROM OP_CLINIC_VW WHERE clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+care_ind+"' and facility_id='"+facility_id+"' ");
            
			rs = stmt.executeQuery(sql.toString()) ;
			if(rs!=null)
			{
			while (rs.next())
				{			
                   		 clinic_type		= rs.getString(1);	
						 if(clinic_type==null) clinic_type="";
						 age_group			= rs.getString(2);
						 if(age_group==null) age_group="";
						 department			= rs.getString(3);	
						 if(department==null) department="";
						 nursing_unit_short_desc=rs.getString(5);
					     if(nursing_unit_short_desc==null) nursing_unit_short_desc="";
						 dept_code			= rs.getString(6);
						 if (dept_code==null) dept_code = "";
						 nursing_unit_short_desc = java.net.URLEncoder.encode(nursing_unit_short_desc);
				}
			}
			else
			{%>
				<script>
					parent.frames[1].frames[0].document.forms[0].clinic_code1.focus();
					return false;
				</script>
			<%}
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
        sql.setLength(0);
		   }
	}catch(Exception e) { out.println("Main : "+e.toString());}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
%>	

