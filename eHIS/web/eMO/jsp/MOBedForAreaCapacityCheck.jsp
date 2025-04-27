<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
   Connection conn = null;
     PreparedStatement pstmt	= null;
   ResultSet prset=null;

   String  capacityCount="";
   String capacityCheck="";
   String bed_for_area="";
   request.setCharacterEncoding("UTF-8");
   String code1=request.getParameter("area_code");
   	String	 facilityId 			= (String) session.getValue( "facility_id" ) ;

 try{
             
                conn = ConnectionManager.getConnection(request);              
				capacityCheck="select CAPACITY from mo_area where area_code='"+code1+"' and facility_id = '"+facilityId+"' ";
				 
				 pstmt   = conn.prepareStatement(capacityCheck);
				 prset   = pstmt.executeQuery();
				 while(prset!=null && prset.next())
				 {
					capacityCount=prset.getString(1); 
				 
				}
			}catch(Exception e){out.println(e.toString());
			e.printStackTrace();}
			 finally{
				 if(prset!=null) prset.close();
				 if(pstmt!=null) pstmt.close();
				     }
		 

		 try{
			    
				bed_for_area="select count(*) cnt from mo_bed_for_area where area_code='"+code1+"' and facility_id = '"+facilityId+"' ";
				
				 pstmt   = conn.prepareStatement( bed_for_area);
				 prset   = pstmt.executeQuery();
				 while(prset!=null && prset.next())
				 {
		           
				if(prset.getInt("cnt")<Integer.parseInt(capacityCount))
			 {
			
			 }else
			 {
			out.println("<script>alert(getMessage('CANNOT_CREATE_BAYS','MO'));</script>");
			out.println("<script>parent.frames[1].document.forms[0].area_code.options[0].selected=true</script>");
			
			 }
				
				 
				 }
				
						}catch(Exception e){out.println(e.toString());
						e.printStackTrace();}
			 finally{
				 if(prset!=null) prset.close();
				 if(pstmt!=null) pstmt.close();
				  ConnectionManager.returnConnection(conn,request);
				     }
		 
 %>

