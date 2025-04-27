<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
		String code="";
		String desc="";
		Connection con = null;
		ResultSet rset=null;
		PreparedStatement pstmt1   		=	null;

		try{
			request.setCharacterEncoding("UTF-8");
	        String locale			= (String)session.getAttribute("LOCALE");
			con=ConnectionManager.getConnection(request);
			String cliniccode=request.getParameter("clinic_code");
			String priority=request.getParameter("priority");
			String facility_id=request.getParameter("facility_id");
			String gender=request.getParameter("gender");
			String called_from_ca		=	(request.getParameter("ca")==null)	? "" : request.getParameter("ca"); 
		%>
          <html><HEAD>
			
			<%
String sStyle	=  
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
				</HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>
         
		  <%
		  StringBuffer sqlTreat = new StringBuffer();
		  
		  sqlTreat.append("SELECT TREATMENT_AREA_CODE, SHORT_DESC FROM AE_TMT_AREA_FOR_CLINIC_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  and FACILITY_ID = ?  AND CLINIC_CODE = ? AND PRIORITY_ZONE= ? and EFF_STATUS='E' and (GENDER = ?  OR GENDER IS NULL) ORDER BY 2");
		  pstmt1   = con.prepareStatement(sqlTreat.toString());
		  pstmt1.setString(1,facility_id);
		  pstmt1.setString(2,cliniccode);
		  pstmt1.setString(3,priority);
		  pstmt1.setString(4,gender);

		  rset=pstmt1.executeQuery();
		  while(rset.next()&&rset!=null)
			{
			  desc=rset.getString(2);
			  code=rset.getString(1);

	  if (called_from_ca.equals("Y")){
		 %>
			<script>
		       if (parent.frames[1].document.forms[0].treatment_area_code!=null){
					var opt=parent.frames[1].document.createElement("OPTION");
			    	opt.text="<%=desc%>";
				    opt.value="<%=code%>";
				    parent.frames[1].document.forms[0].treatment_area_code.add(opt);
			   
				}else{
				   var opt=parent.frames[3].document.createElement("OPTION");
				   opt.text="<%=desc%>";
				   opt.value="<%=code%>";
				   parent.frames[3].document.forms[0].treatment_area_code.add(opt);
				}
         	</script>	  
		<%}else{
				%>
			<script>
				var opt=parent.frames[1].document.createElement("OPTION");
				opt.text="<%=desc%>";
				opt.value="<%=code%>";
				parent.frames[1].document.forms[0].treatment_area_code.add(opt);
         	</script>
        <%}
		  }
		 if(rset!=null) rset.close();
	     if(pstmt1!=null) pstmt1.close();
		 if((sqlTreat != null) && (sqlTreat.length() > 0))
		 {
			sqlTreat.delete(0,sqlTreat.length());
		 }
		}catch(Exception e){ e.toString();}
	   finally
	   {
		ConnectionManager.returnConnection(con,request);
	   }
%>

