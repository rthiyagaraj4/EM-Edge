<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  <script src='../../eCommon/js/common.js' language='javascript'></script>

 <%
		Connection con		      =  null;
		ResultSet rs 		      = null;
		//ResultSet rs1 		      = null;
		PreparedStatement pstmt   = null; 
		StringBuffer sqlSer         = null;

		request.setCharacterEncoding("UTF-8");
	    //String locale			 = (String)session.getAttribute("LOCALE");
        //String facilityId 	     = checkForNull((String) session.getValue( "facility_id" )) ;
		String pat_ser_grp_code	 = checkForNull(request.getParameter("pat_ser_grp_code"));
		String separator_value   ="";
		String separator_position="";
		String separator_position1="";
		String pat_number_using   = "";
%>
	<html>
	<head>
	<%
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<BODY class='message' onKeyDown = 'lockKey()'>
	<form>
	<%
	try
	{
	   con					      = ConnectionManager.getConnection(request);
	   if(!pat_ser_grp_code.equals(""))
		{
		      sqlSer = new StringBuffer();
              sqlSer.append("select SEPARATOR_VALUE, SEPARATOR_POSITION ,PID_USE_ALT_ID1_OR_SYS_GEN from mp_pat_ser_grp where PAT_SER_GRP_CODE='"+pat_ser_grp_code+"' ");
			  pstmt   = con.prepareStatement(sqlSer.toString());

			  rs		 = pstmt.executeQuery();
	 	      while(rs!=null && rs.next())
			  {		
				separator_value			= rs.getString("SEPARATOR_VALUE");
				separator_position		= rs.getString("SEPARATOR_POSITION");
				pat_number_using		= checkForNull(rs.getString("PID_USE_ALT_ID1_OR_SYS_GEN"));
				if (separator_position.equals("P"))
					separator_position1="Prefix";
		        else
					separator_position1="Suffix";

				if(pat_number_using.equals("A"))
				  {
					%>
					<script>
						
						 //top.content.frames[1].frames[1].document.forms[0].patient_numbering_using[0].checked=true;
						   parent.frames[1].document.forms[0].patient_numbering_using[0].checked=true;
							
						 //top.content.frames[1].frames[1].document.forms[0].patient_numbering_using[1].disabled=true;
						 parent.frames[1].document.forms[0].patient_numbering_using[1].disabled=true;
						  
					</script>
					<%
				  }
				else if(pat_number_using.equals("S"))
				  {
					%>
					<script>
						
						 //top.content.frames[1].frames[1].document.forms[0].patient_numbering_using[1].checked=true;
						 parent.frames[1].document.forms[0].patient_numbering_using[1].checked=true;
						
						 //top.content.frames[1].frames[1].document.forms[0].patient_numbering_using[0].disabled=true;
						 parent.frames[1].document.forms[0].patient_numbering_using[0].disabled=true;
					</script>
					<%
				  }
				else
				  {
					%>
					<script>	
						
						parent.frames[1].document.forms[0].patient_numbering_using[0].disabled=false;
					
						parent..frames[1].document.forms[0].patient_numbering_using[1].disabled=false;
						 parent..frames[1].document.forms[0].patient_numbering_using[0].checked=false;
						 parent.frames[1].document.forms[0].patient_numbering_using[1].checked=false;
					</script>
					<%
				  }
			  %>
		        <script>
				 
				     //top.content.frames[1].frames[1].document.forms[0].SeparatorValue.value="<%=separator_value%>";
				     parent.frames[1].document.forms[0].SeparatorValue.value="<%=separator_value%>";
					//top.content.frames[1].frames[1].document.forms[0].SeparatorPosition.value="<%=separator_position1%>";
					parent.frames[1].document.forms[0].SeparatorPosition.value="<%=separator_position1%>";
	  	        </script>	
	<%	      }//End of while	
              if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlSer != null) && (sqlSer.length() > 0))
			  {
				sqlSer.delete(0,sqlSer.length());
			  } 
		  }
		if(pstmt!=null) pstmt.close();
	    if(rs!=null) rs.close(); 
		 }catch(Exception e){}
         finally {
		           ConnectionManager.returnConnection(con,request);  
		    }
		%>
		</form>
			<%!
		// To Handle java.lang.NullPointerException.
		public static String checkForNull(String inputString)
		{
			return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
		}
	%>

		</body>
		</html>	 

