<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</HEAD>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body class='message' onKeyDown = 'lockKey();'>
<form name='formloc' id='formloc'>

<%          
            Connection con = null;
			ResultSet rset=null;
			Statement stmt=null;
			boolean allow_apply=false;
            try{

				con=ConnectionManager.getConnection(request);
		        stmt = con.createStatement();
          
				String mr_location_code=request.getParameter("mr_location_code");
				String mr_section_type=(request.getParameter("mr_section_type") == null)?"":request.getParameter("mr_section_type");
				String facilityid=(String)session.getValue("facility_id");
				String centralValue=request.getParameter("centralValue");
				String sql_l="";
				
				if(!(mr_section_type.equals("")))
				{	
					if(mr_location_code!=null && !(mr_location_code.equals(""))  ){
					if(mr_section_type!=null && (mr_section_type.equals("") || mr_section_type.equals("C"))){
					sql_l =" Select fs_locn_code from fm_storage_locn where facility_id = '"+facilityid+"' and locn_identity='"+centralValue+"' and permanent_file_area_yn='N' and fs_locn_code='"+mr_location_code+"' and eff_status = 'E' order by short_desc ";
					}
					else{

					 sql_l =" Select fs_locn_code from fm_storage_locn where facility_id = '"+facilityid+"' and  MR_LOCN_YN='Y' and permanent_file_area_yn='Y' and locn_identity='"+centralValue+"'  and fs_locn_code='"+mr_location_code+"' and eff_status = 'E' order by short_desc ";
						
					}
				   
				   rset = stmt.executeQuery(sql_l);          
					if(rset != null && rset.next()) 
					{
					allow_apply=true;
					}
					else{
						allow_apply=false;
					}

				}
				else
				{
					allow_apply=true;
				}
			}
			else
			{			
				allow_apply=true;
			}
			

			if(allow_apply){
			%>
			<script>
				
			parent.frames[1].document.clinic_sub.document.clinic_resource_form.submit();			
			</script>
			<%
			}
			else{
			%>
			<script>
			
		 	parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
			var errors=getMessage('STORAGE_LOCATION','OP');
			alert(errors);
			parent.frames[1].document.frames[1].document.getElementByid("mr_location_code").focus();
			</script>
			<%		
			}
			}
			catch(Exception e) { 
				
				//out.println(e.toString());
				e.printStackTrace();
				
				}
			finally
			{
				try{
				if (stmt != null) stmt.close();
				if (rset != null) rset.close();
			}catch(Exception e){}
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
                           
%>       </form>   
</body></html>            
            

