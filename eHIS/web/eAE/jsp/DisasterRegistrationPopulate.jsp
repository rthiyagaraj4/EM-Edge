<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*,java.io.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,blopin.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<html>
<body class='MESSAGE' onKeyDown = 'lockKey()'> 
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	 
   <% 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		//String locale			= (String)session.getAttribute("LOCALE");

        String process = request.getParameter("process_id");
		if(process==null) process="";
		Connection con = null;
		java.sql.Statement st = null;
		PreparedStatement pstmt=null; 
		ResultSet rs = null;
		
		
		String loginfacility = (String) session.getValue("facility_id");
		String sql = "";
		String visit_type_code="";
		String visit_type_desc="";
        String service_code="";
		String service_desc="";
		StringBuffer sqlbuf=new StringBuffer();
    try
     {
		 con = ConnectionManager.getConnection(request);

		 if(process.equals("clinic_code"))
				{
					String location_code = request.getParameter("location_code");
						
					sql = "select a.visit_type_code, b.SHORT_DESC visit_type_short_desc  from  op_visit_type_for_clinic a, op_visit_type b where a.facility_id=b.facility_id and a.visit_type_code=b.visit_type_code and b.visit_type_ind='E'  and a.eff_status='E' and a.clinic_code= '"+location_code+"'  and a.facility_id='"+loginfacility+"'";
		            pstmt = con.prepareStatement(sql);
					                
					rs = pstmt.executeQuery();
					while (rs!=null && rs.next() )
					{

						visit_type_code=rs.getString("visit_type_code");
							visit_type_desc=rs.getString("visit_type_short_desc");
						%>
						<script>
										
							var oOption = parent.frames[1].document.createElement("OPTION");
							oOption.text="<%=visit_type_desc%>";
							oOption.value="<%=visit_type_code%>";
							parent.frames[1].document.forms[0].visit_type.add(oOption);
						</script>
						<%
					}
			       	if(rs != null)		rs.close();
			        if(pstmt	  != null)		pstmt.close();

					sqlbuf.append("SELECT A.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A, AM_FACILITY_SERVICE B,OP_CLINIC_FOR_SERVICE C WHERE C.FACILITY_ID='"+loginfacility +"' AND C.CLINIC_CODE = '"+location_code+"' AND B.OPERATING_FACILITY_ID = C.FACILITY_ID AND C.SERVICE_CODE = B.SERVICE_CODE AND A.SERVICE_CODE = B.SERVICE_CODE UNION SELECT b.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A,OP_CLINIC B WHERE B.FACILITY_ID='"+loginfacility+"'  AND b.CLINIC_CODE='"+location_code+"' AND A.SERVICE_CODE = B.SERVICE_CODE ORDER BY 2");

					
                    st = con.createStatement();
					rs = st.executeQuery(sqlbuf.toString());
					while (rs!=null && rs.next() )
					{
						service_code=rs.getString(1);
							service_desc=rs.getString(2);
						%>
						<script>
										
							var oOption = parent.frames[1].document.createElement("OPTION");
							oOption.text="<%=service_desc%>";
							oOption.value="<%=service_code%>";
							parent.frames[1].document.forms[0].service_code.add(oOption);
						</script>
						<%
					}
				} 
				else if(process.equals("refresh_dates"))
				 {
					String AllowedDate = request.getParameter("AllowedDate");
					String sys_date = request.getParameter("sys_date");
				// Thursday, April 22, 2010 Venkats PE_EXE		
					/*	sql = "SELECT TO_CHAR (SYSDATE,'dd/mm/yyyy hh24:mi') SYS, TO_CHAR ((SYSDATE - (1 / (24 * 60 * 60)) * 3600 * max_hours_allow_insert ), 'dd/mm/yyyy hh24:mi' ) sys1  FROM ae_param where operating_facility_id='"+loginfacility+"'";

		            pstmt = con.prepareStatement(sql);
					            
					rs = pstmt.executeQuery();
					while (rs!=null && rs.next() )
					{

						     sys_date1=rs.getString("SYS");
							 AllowedDate1=rs.getString("sys1");

		                     sysdate2=DateUtils.convertDate(sys_date1,"DMYHM","en",locale);
		                     AllowedDate2=DateUtils.convertDate(AllowedDate1,"DMYHM","en",locale); */ 

						%>
						<script>
						    parent.frames[1].frames[2].document.forms[0].AllowedDate.value='<%=AllowedDate%>'
							parent.frames[1].frames[2].document.forms[0].sysdate.value='<%=sys_date%>'
		      
						</script>
						<%
	
				 }

	sqlbuf.setLength(0);

	if(rs != null)		rs.close();
	if(st	  != null)		st.close();
	
	}catch(Exception e){e.printStackTrace();}
    finally
    {
     if(con!=null)   
     ConnectionManager.returnConnection(con,request);
    }	

	%>

	</body>
	</html>


