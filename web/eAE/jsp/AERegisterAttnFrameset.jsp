<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eAE/js/AERegisterAttn.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String params				= checkForNull(request.getQueryString()) ;
		String facilityId			= checkForNull((String)session.getValue("facility_id"));
		String user_id 	 			= checkForNull((String)session.getValue("login_user")) ;
        Connection	con             = null;
		java.sql.Statement stmt     = null;
        ResultSet rset              = null ;
		
		String dflt_emer_follow_type_code = checkForNull(request.getParameter("dflt_emer_follow_type_code")); // added by mujafar for KDAH-CRF-0526
		String dflt_time_reg_auto_update = checkForNull(request.getParameter("dflt_time_reg_auto_update"));
		
      try{
			con = ConnectionManager.getConnection(request);
	/*	String StartDate1           = "";
		String AllowedDate          = "";
		String bl_interface_yn      = "";
		String visit_back_yn		= "";
		String start_date			= "";
		String sys_date             = "";
		String reg_attendance_for_inpat_yn = "";
		StringBuffer sqlDate = new StringBuffer();
 
			 Thursday, April 22, 2010 venkat s PE_EXE
				 sqlDate.append("select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss')sys, ");
				   sqlDate.append("to_char((sysdate -(1/(24*60*60))*3600*MAX_HOURS_ALLOW_INSERT),'dd/mm/yyyy hh24:mi:ss')sys1, ");
				   sqlDate.append(" BILLING_INTERFACED_YN, ");
				   sqlDate.append(" VISIT_BACKDATING_ALLOWED_YN,  ");
				   sqlDate.append(" REG_ATTENDANCE_FOR_INPAT_YN,  ");
				   sqlDate.append(" TO_CHAR(SYSDATE-(DECODE(VISIT_BACKDATING_ALLOWED_YN,");
				   sqlDate.append(" 'Y',MAX_HOURS_ALLOW_INSERT,0)*60)/1440,'dd/mm/yyyy hh24:mi')  start_date,to_char(trunc(sysdate),'dd/mm/yyyy') sys_date  ");
				   sqlDate.append(" from ae_param  where operating_facility_id= ? ");
				   if (pstmt != null) pstmt.close();
				   pstmt  = con.prepareStatement(sqlDate.toString());
		   
				   pstmt.setString(1,facilityId);
				 
				   rs = pstmt.executeQuery();
				   if (rs != null)
				   {
					 if(rs.next()) 
					  {
						StartDate1          = checkForNull(rs.getString("sys"));
						params  = params+"&StartDate1="+StartDate1;
						AllowedDate         = checkForNull(rs.getString("sys1"));
						params  = params+"&AllowedDate="+AllowedDate;
						bl_interface_yn     = checkForNull(rs.getString("BILLING_INTERFACED_YN"));
						params  = params+"&bl_interface_yn="+bl_interface_yn;
						visit_back_yn		= checkForNull(rs.getString("VISIT_BACKDATING_ALLOWED_YN"));
						params  = params+"&visit_back_yn="+visit_back_yn;
						reg_attendance_for_inpat_yn		= checkForNull(rs.getString("REG_ATTENDANCE_FOR_INPAT_YN"));
						params  = params+"&attendance_for_inpat_yn="+reg_attendance_for_inpat_yn;
						start_date			= checkForNull(rs.getString("start_date"));
						params  = params+"&start_date="+start_date;
						sys_date            = checkForNull(rs.getString("sys_date")); 
						params  = params+"&sys_date="+sys_date;
					  }
				   }
				   if(rs != null)  rs.close();
				   if(pstmt != null) pstmt.close();  
				   */

					/**********   Added new for Check    ***********/
                   stmt	= con.createStatement();	
				   rset	= stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+user_id+"','C','','REGISTER_VISIT_YN') FROM dual") ;
				   rset.next();

				   String OsVal=rset.getString(1);

					if(OsVal.equals("1"))
						{
							out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else if(OsVal.equals("2"))
						{
							out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else  if(OsVal.equals("3"))
						{
							out.print(" <script>alert(getMessage('AE_REG_ATTN_NOT_ALL_OPERSTN','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else  if(OsVal.equals("4"))
						{
							out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else  if(OsVal.equals("5"))
						{
							out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}
						else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
						{				   
						%>
							<iframe name='patientFrame' id='patientFrame' src='../../eAE/jsp/AERegisterAttnSearch.jsp?dflt_time_reg_auto_update=<%=dflt_time_reg_auto_update%>&dflt_emer_follow_type_code=<%=dflt_emer_follow_type_code%>&oper_stn_id=<%=OsVal%>&<%=params%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
								<iframe name='patientLine' id='patientLine' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
								<iframe name='patientDetailsFrame' id='patientDetailsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:86vh;width:100vw'></iframe>
			<%			}
                   if(rset != null)  rset.close();
				   if(stmt != null) stmt.close();
				
				 /*  if(rs != null)  rs.close();
				   if(pstmt != null) pstmt.close(); 
				   if((sqlDate != null) && (sqlDate.length() > 0))
				   {
					 sqlDate.delete(0,sqlDate.length());
				   }
				   */
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(con,request);
		}
%>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>
</html>

