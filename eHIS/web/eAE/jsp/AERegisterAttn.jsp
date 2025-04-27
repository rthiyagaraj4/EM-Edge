<!DOCTYPE html>
<%@page import="java.util.*, java.sql.*, webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
    <%
        request.setCharacterEncoding("UTF-8");
        request = new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
                        
        String invoke_from = checkForNull(request.getParameter("invoke_from"));
        if (invoke_from.equals("EMER_REGN_NB")) { %>
            <title><fmt:message key="Common.RegisterAttendance.label" bundle="${common_labels}"/></title>
    <% } %>
    <link rel="stylesheet" type="text/css" href="../../eCommon/html/<%= sStyle %>"></link>
    <script language="javascript" src="../../eAE/js/AERegisterAttn.js"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
    <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
    <script src="../../eCommon/js/showModalDialog.js" language="javascript"></script>
</head>
<body>
<%
    
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		String bl_install_yn         = (String)session.getValue("bl_operational");
		String facilityId			= checkForNull((String)session.getValue("facility_id"));
        Connection	con             = null;
		PreparedStatement pstmt		= null;
		ResultSet rs				= null ;

        String StartDate1 = "";
        String AllowedDate = "";
        String bl_interface_yn = "";
        String visit_back_yn = "";
        String start_date = "";
        String sys_date = "";
        String cnt = "";
        String dflt_time_reg_auto_update = ""; // added by mujafar for KDAH-CRF-0526
        String dflt_emer_follow_type_code = "";

        // below lines added by venkatesh.S (4008) on 22/Feb/2012 against CRF Bru-HIMS-CRF-152 [IN030272]
        String max_hrs_for_re_attend = "";
        // end CRF Bru-HIMS-CRF-152 [IN030272]
        String reg_attendance_for_inpat_yn = "";
        StringBuffer sqlDate = new StringBuffer();
        /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 Start*/
        String five_level_triage_appl_yn = "N";
        /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 End*/

		try{
		con			            = ConnectionManager.getConnection(request);
	//	String sql1 = " select 1  from ae_param  where OPERATING_FACILITY_ID=?"; old query

				// Thursday, April 22, 2010 venkat s PE_EXE 
				   sqlDate.append("select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss')sys, ");
				   sqlDate.append("to_char((sysdate -(1/(24*60*60))*3600*MAX_HOURS_ALLOW_INSERT),'dd/mm/yyyy hh24:mi:ss')sys1, ");
				   sqlDate.append(" BILLING_INTERFACED_YN, ");
				   sqlDate.append(" VISIT_BACKDATING_ALLOWED_YN,  ");
				   sqlDate.append(" REG_ATTENDANCE_FOR_INPAT_YN,  ");
				// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
                   sqlDate.append(" MAX_HRS_FOR_RE_ATTEND,  ");
				  //end CRF  Bru-HIMS-CRF-152 [IN030272]
				   
				   sqlDate.append(" TO_CHAR(SYSDATE-(DECODE(VISIT_BACKDATING_ALLOWED_YN,");
				   sqlDate.append(" 'Y',MAX_HOURS_ALLOW_INSERT,0)*60)/1440,'dd/mm/yyyy hh24:mi')  start_date,to_char(trunc(sysdate),'dd/mm/yyyy') sys_date, 1 cnt  ");
				   /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 Start*/
				   sqlDate.append(" ,five_level_triage_appl_yn ");
				   /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 End*/
				   
				   /* for KDAH-CRF-0526 */
				   
				   sqlDate.append(" ,DFLT_TIME_REG_AUTO_UPDATE,DFLT_EMER_FOLLOW_TYPE_CODE  ");
				   /* for KDAH-CRF-0526 */
				   
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
						// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
				        max_hrs_for_re_attend = checkForNull(rs.getString("MAX_HRS_FOR_RE_ATTEND"));
						params  = params+"&max_hrs_for_re_attend="+max_hrs_for_re_attend;
						
						//end CRF  Bru-HIMS-CRF-152 [IN030272]
						params  = params+"&bl_interface_yn="+bl_interface_yn;
						visit_back_yn		= checkForNull(rs.getString("VISIT_BACKDATING_ALLOWED_YN"));
						params  = params+"&visit_back_yn="+visit_back_yn;
						reg_attendance_for_inpat_yn		= checkForNull(rs.getString("REG_ATTENDANCE_FOR_INPAT_YN"));
						params  = params+"&attendance_for_inpat_yn="+reg_attendance_for_inpat_yn;
						start_date			= checkForNull(rs.getString("start_date"));
						params  = params+"&start_date="+start_date;
						sys_date           = checkForNull(rs.getString("sys_date")); 
						params  = params+"&sys_date="+sys_date;
						cnt            = checkForNull(rs.getString("cnt")); 
						/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 Start*/
						five_level_triage_appl_yn	= (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");
						params	= params + "&five_level_triage_appl_yn="+five_level_triage_appl_yn;
						/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 End*/
						
						/*  for KDAH-CRF-0526*/ 
						dflt_time_reg_auto_update         = rs.getString("DFLT_TIME_REG_AUTO_UPDATE")==null?"0":rs.getString("DFLT_TIME_REG_AUTO_UPDATE");
						dflt_emer_follow_type_code          = checkForNull(rs.getString("dflt_emer_follow_type_code"));
						/* for KDAH-CRF-0526  */
						
					  }
				   }
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

            if (cnt.equals("")) {
                out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp'</script>");
            } else {
                if (bl_install_yn.equals("Y")) { %>
			<iframe name="commontoolbarFrame" id="commontoolbarFrame" src="<%=source%>" frameborder="0" scrolling="no" noresize style='height:7vh;width:100vw;'></iframe>
                    <iframe name="f_query_add_mod" id="f_query_add_mod" src="../../eAE/jsp/AERegisterAttnFrameset.jsp?dflt_time_reg_auto_update=<%=dflt_time_reg_auto_update%>&dflt_emer_follow_type_code=<%=dflt_emer_follow_type_code%>&<%=params%>" frameborder="0" scrolling="no" noresize style='height:83vh;width:100vw;'></iframe>
<!--                     <iframe name="dummyFrame" id="dummyFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style='height:10vh;width:100vw;'></iframe>
 -->                    <iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style='height:10vh;width:100vw;'></iframe>
                    <iframe name="billingfr" id="billingfr" src="../../eBL/jsp/BLSessionValuesReset.jsp" frameborder="0" noresize scrolling="auto" style='height:0vh;width:100vw;'></iframe>
			<%}else{%>
			
                    <iframe name="commontoolbarFrame" id="commontoolbarFrame" src="<%=source%>" frameborder="0" scrolling="no" noresize style='height:7vh;width:100vw;'></iframe>
                    <iframe name="f_query_add_mod" id="f_query_add_mod" src="../../eAE/jsp/AERegisterAttnFrameset.jsp?dflt_time_reg_auto_update=<%=dflt_time_reg_auto_update%>&dflt_emer_follow_type_code=<%=dflt_emer_follow_type_code%>&<%=params%>" frameborder="0" scrolling="no" noresize style='height:83vh;width:100vw;'></iframe>
                    <iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style='height:10vh;width:100vw;'></iframe>
				<%if(bl_install_yn.equals("Y")){%>
                    <iframe name="billingfr" id="billingfr" src="../../eBL/jsp/BLSessionValuesReset.jsp" frameborder="0" noresize scrolling="auto" style='height:0vh;width:100vw;'></iframe>
				
			<%}%>
                <% }
            }

			if((sqlDate != null) && (sqlDate.length() > 0))
			{
				sqlDate.delete(0,sqlDate.length());
			}

				}catch(Exception e){
			 e.printStackTrace();
		}finally{
		ConnectionManager.returnConnection(con,request);
       }	
		%>

        <input type="hidden" name="params" id="params" value="<%=params%>">
		<input type="hidden" name="tlbrsrc" id="tlbrsrc" value="<%=source%>">
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>
</body>
</html>
