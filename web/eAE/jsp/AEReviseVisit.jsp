<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>

	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAE/js/AEReviseVisit.js'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<%
		Connection			con			=	null;
  try{
	    request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    con=ConnectionManager.getConnection(request);
        PreparedStatement	pstmt		=	null;
		ResultSet			rset		=	null;

		String url						=	"../../eCommon/jsp/commonToolbar.jsp?" ;
		String params					=	request.getQueryString() ;
		String source					=	url + params ;
		String facilityId    			=	(String) session.getValue("facility_id" ) ;
		String userId					=	(String) session.getValue("login_user");
		String StartDate				=	"";
		String sys_date					=	"";
		String RevCanceldays			=	"";
		String max_days_allow_update	=	"";
		String start_date               =	"";
		String OsVal					=	"";
		String Patient_Id_Length	  	=	"";
		String p_mode					=	"REVISEVISIT";
		StringBuffer sqlAEParam			=	new  StringBuffer(); 
		String  function_name=request.getParameter("function_name");
		String five_level_triage_appl_yn	= "N";//Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
// Tuesday, May 18, 2010 venkat s PE_EXE
		// sqlAEParam.append("select to_char(sysdate - a.MAX_DAYS_ALLOW_UPDATE,'dd/mm/yyyy hh24:mi') startdate,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date,to_char(sysdate-a.MAX_DAYS_ALLOW_UPDATE,'dd/mm/yyyy hh24:mi')sys_1date,a.MAX_DAYS_ALLOW_UPDATE,TO_CHAR(SYSDATE-(DECODE(a.VISIT_BACKDATING_ALLOWED_YN,		  'Y',a.MAX_HOURS_ALLOW_INSERT,0)*60)/1440,'dd/mm/yyyy hh24:mi')  start_date,(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+userId+"','C','','REVISE_VISIT_YN')) osval,(select patient_id_length from mp_param where module_id='MP') Patient_Id_Length  from dual,ae_param a where a.operating_facility_id= ?");
 		// five_level_triage_appl_yn Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		sqlAEParam.append("select to_char(sysdate - a.MAX_DAYS_ALLOW_UPDATE,'dd/mm/yyyy hh24:mi') startdate,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date,to_char(sysdate-a.MAX_DAYS_ALLOW_UPDATE,'dd/mm/yyyy hh24:mi')sys_1date,a.MAX_DAYS_ALLOW_UPDATE,TO_CHAR(SYSDATE-(DECODE(a.VISIT_BACKDATING_ALLOWED_YN,		  'Y',a.MAX_HOURS_ALLOW_INSERT,0)*60)/1440,'dd/mm/yyyy hh24:mi')  start_date,(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+userId+"','C','','REVISE_VISIT_YN')) osval,(select patient_id_length from mp_param where module_id='MP') Patient_Id_Length,five_level_triage_appl_yn  from dual,ae_param a where a.operating_facility_id= ?");
		 pstmt = con.prepareStatement(sqlAEParam.toString());
		 pstmt.setString(1, facilityId);
		 rset = pstmt.executeQuery();
				 if (rset != null && rset.next())
				  {
								  
					  StartDate=rset.getString("startdate");
					  params  = params+"&StartDate="+StartDate ;
					  sys_date = rset.getString("sys_date");
					  params  = params+"&sys_date="+sys_date ;
					  RevCanceldays=rset.getString("sys_1date");
					  params  = params+"&RevCanceldays="+RevCanceldays ;
					  max_days_allow_update =rset.getString("MAX_DAYS_ALLOW_UPDATE");
					  params  = params+"&max_days_allow_update="+max_days_allow_update ;
					  start_date = rset.getString("start_date");
					  params  = params+"&start_date="+start_date ;
					  OsVal = rset.getString("osval");
					  Patient_Id_Length = rset.getString("Patient_Id_Length");
					 /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014 Start*/
					  five_level_triage_appl_yn			=	(rset.getString("five_level_triage_appl_yn")==null || rset.getString("five_level_triage_appl_yn")=="")?"N":rset.getString("five_level_triage_appl_yn");
					  params  = params+"&five_level_triage_appl_yn="+five_level_triage_appl_yn ;
					  /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014 End*/
					 /**********   Added new for Oper Stn Check    ***********/
					

			  		if(OsVal.equals("1"))
					{
						out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else if(OsVal.equals("2"))
					{
						out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("3"))
					{
						out.print(" <script>alert(getMessage('AE_REVISIT_NOT_ALL_OPERSTN','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("4"))
					{
						out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("5"))
					{
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
					else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4"))  && (!OsVal.equals("5")))
					{
							params = params+"&oper_stn_id="+OsVal;

					%>
							<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw' ></iframe>
								<iframe name='searchCriteria' id='searchCriteria' frameborder=no scrolling='no' src='../../eAE/jsp/AESearchVisitQueryCriteria.jsp?p_mode=<%=p_mode%>&Patient_Id_Length=<%=Patient_Id_Length%>&params=<%=params%>&functionname=<%=java.net.URLEncoder.encode(function_name,"UTF-8")%>' style='height:18vh;width:100vw'></iframe><iframe name='PatientLine' id='PatientLine'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:6vh;width:100vw'></iframe> <iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='yes' style='height:60vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
						<input type="hidden" name="params" id="params" value="<%=params%>">
		         <%
				  }
			      else
			      {
					%>
							<script language='javascript'>
							alert(getMessage('AE_REVISIT_NOT_ALL_OPERSTN','AE'));
							parent.content.location.href = '../../eCommon/jsp/dmenu.jsp';
							</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

					<%
					} 	
					}else{
							out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
					}
								
				 if(rset!=null)	rset.close();
				 if(pstmt!=null)	pstmt.close();
				// end of else
				 if((sqlAEParam != null) && (sqlAEParam.length() > 0))
					{
						sqlAEParam.delete(0,sqlAEParam.length());
					} 
}
catch(Exception e)
{
	e.printStackTrace();
}
finally{
		ConnectionManager.returnConnection(con,request);
       }
%>
</html>

