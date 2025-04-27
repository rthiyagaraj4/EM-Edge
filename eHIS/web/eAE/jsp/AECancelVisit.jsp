<!DOCTYPE html>
<!-- 	Function Name Cancel Visit 	Created by M.Sathis Kumar on 28/02/2000 -->
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<html>
	<head>
    <meta http-equiv="Expires" content="0">  
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
    <Script src="../../eOP/js/CancelVisit.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

    <%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String url						= "../../eCommon/jsp/commonToolbar.jsp?from_id=EM&" ;
		String params					= request.getQueryString() ;
		String source					= url + params ; 
		String fac_id    				= (String) session.getValue( "facility_id" ) ;
		String userid					= (String) session.getValue("login_user");
		String p_mode					=	"CANCELVISIT";
		String StartDate				=	"";
		String sys_date					=	"";
		String RevCanceldays			=	"";
		String max_days_allow_update	=	"";
		String OsVal					= "";
		String op_cnt					= "";
		String Patient_Id_Length					= "";
        String function_name=request.getParameter("function_name");
		String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
		
		PreparedStatement	pstmt		=	null;
		ResultSet			rset		=	null;
		Connection con=null;

        try
		{
 // Wednesday, May 12, 2010 venkat s PE_EXE 
				con=ConnectionManager.getConnection(request);
				StringBuffer sqlAEParam =	new  StringBuffer(); 
      			 sqlAEParam.append("select  to_char(sysdate - a.MAX_DAYS_ALLOW_UPDATE,");
				 sqlAEParam.append("'dd/mm/yyyy hh24:mi') startdate, ");
				 sqlAEParam.append(" to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date,");
				 sqlAEParam.append(" to_char(sysdate-a.MAX_DAYS_ALLOW_UPDATE,");
				 sqlAEParam.append(" 'dd/mm/yyyy hh24:mi')sys_1date,a.MAX_DAYS_ALLOW_UPDATE , (AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','CANCEL_VISIT_YN')) OsVal,(SELECT 1 FROM op_param WHERE operating_facility_id ='"+fac_id+"') op_cnt,(select patient_id_length from mp_param where module_id='MP') Patient_Id_Length from ");
				 sqlAEParam.append(" ae_param a where a.operating_facility_id= ? ");

				 pstmt = con.prepareStatement(sqlAEParam.toString());
				 pstmt.setString(1, fac_id);
				 rset = pstmt.executeQuery();
				 if (rset != null && rset.next())
				  {
				  					  
					  OsVal=rset.getString("OsVal");
					  StartDate=rset.getString("startdate");
					  params  = params+"&StartDate="+StartDate ;
					  sys_date = rset.getString("sys_date");
					  params  = params+"&sys_date="+sys_date ;
					  RevCanceldays=rset.getString("sys_1date");
					  params  = params+"&RevCanceldays="+RevCanceldays ;
					  max_days_allow_update =rset.getString("MAX_DAYS_ALLOW_UPDATE");
					  params  = params+"&max_days_allow_update="+max_days_allow_update ;
					  OsVal=rset.getString("OsVal");
					  op_cnt=rset.getString("op_cnt");
					  Patient_Id_Length=rset.getString("Patient_Id_Length");

					if(op_cnt.equals(""))
					  {
							out.println("<script>alert(getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
					  }
					  else{
					if(OsVal.equals("1"))
					{
						out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else if(OsVal.equals("2"))
					{
						out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("3"))
					{
						out.print(" <script>alert(getMessage('CANCEL_VISIT_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("4"))
					{
						out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("5"))
					{
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
					else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
					{
					  params = params + "&oper_stn_id="+OsVal+"&" ;
					 %>

						<%-- <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
						<iframe name='searchCriteria' id='searchCriteria' frameborder=no scrolling='no' src='../../eAE/jsp/AESearchVisitQueryCriteria.jsp?function_id=<%=function_id%>&Patient_Id_Length=<%=Patient_Id_Length%>&p_mode=<%=p_mode%>&params=<%=params%>&function_name=<%=java.net.URLEncoder.encode(function_name,"UTF-8")%>' style='height:19vh;width:100vw'></iframe>
						<iframe name='PatientLine' id='PatientLine'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:0vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:64vh;width:100vw'></iframe>
						<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe> --%>
	 <frameset rows='42,100,0,*,50' id=frameSetId onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()" >
           <frame name='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize>
           <frame name='searchCriteria' frameborder=no scrolling='no' src='../../eAE/jsp/AESearchVisitQueryCriteria.jsp?function_id=<%=function_id%>&Patient_Id_Length=<%=Patient_Id_Length%>&p_mode=<%=p_mode%>&params=<%=params%>&function_name=<%=java.net.URLEncoder.encode(function_name,"UTF-8")%>'>
           <frame name='PatientLine'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no'>
           <frame name='f_query_add_mod'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no'>
           <frame name='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
     </frameset>
				
<%
	 } 
	 } 
	 }
	 else
	{
		out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}
		 if(rset!=null)	rset.close();
		if(pstmt!=null)	pstmt.close();
		if((sqlAEParam!= null) && (sqlAEParam.length() > 0))
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

