<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</link>
<!-- <script language='javascript' src='../../eOP/js/OPEncounter.js'></script> -->
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
function reset()
{

document.location.reload();
}

/*function query() 
{
       var dialogHeight= "40" ;
       var dialogWidth = "70" ;
       var dialogTop = "63";
       var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+"; dialogTop:"+dialogTop+"; status=no" ;
       var arguments   = "" ;
       var encounterid = window.showModalDialog("../../eOP/jsp/PaintSearchVisit.jsp",arguments,features);

       if(encounterid!=null)
       {
           var encounterids= encounterid.split("|")
           encounterid=encounterids[0];
				
		   document.location.href = "../../eOP/jsp/OpinternlReportReprintModal.jsp?encounterid="+encounterid+"&file_created_at_regn_yn=N";
	   }
}*/
</script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<%
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
		String userid           = (String) session.getValue("login_user");
		Connection con=null;	
		
	try{
            con=ConnectionManager.getConnection(request);        
			Statement stmt=null;
			ResultSet rs=null;					
			String OsVal="";			
			String Patient_Id_Length="";			
		
			stmt	= con.createStatement();	
			rs	= stmt.executeQuery("select oper_stn_id, (Select patient_id_length from mp_param where module_id='MP') Patient_Id_Length  from am_user_for_oper_stn where appl_user_id='"+userid+"' and facility_id='"+fac_id+"' and trunc(sysdate)<=trunc(nvl(eff_date_to,sysdate))") ;
			if(rs!=null && rs.next()) {
				OsVal=rs.getString("oper_stn_id");	  
				Patient_Id_Length   = rs.getString("Patient_Id_Length");
			}
			
			if (stmt != null)    stmt.close();
			if (rs != null)       rs.close();  
	%> 

			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
					<iframe name='group_head' id='group_head'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eOP/jsp/SearchVisitQueryCriteria.jsp?oper_id=<%= OsVal %>&Patient_Id_Length=<%=Patient_Id_Length%>' style='height:18vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='auto' style='height:65vh;width:100vw'></iframe>
					<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
					<iframe name='dummyFrame' id='dummyFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
			</html>
		<%
			if (stmt != null)    stmt.close();
				  if (rs != null)       rs.close();
		}catch(Exception e) {e.printStackTrace();}
		finally{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}
		%>

