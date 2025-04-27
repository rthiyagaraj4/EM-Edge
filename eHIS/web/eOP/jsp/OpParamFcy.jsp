<!DOCTYPE html>
<html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<head>
</head>

<%
    request.setCharacterEncoding("UTF-8");
    Connection con = null;
    PreparedStatement pstmt=null;
    ResultSet rs=null ;
    String build_episode_yn=""; 
    String operating_facility_id=(String)session.getValue("facility_id");   
    try{
			con = ConnectionManager.getConnection(request);
            String sql="select BUILD_EPISODE_YN from op_param where operating_facility_id = '"+operating_facility_id+"' ";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();          
            while(rs.next())
            {
                build_episode_yn=rs.getString("BUILD_EPISODE_YN");      
            }   
    
    } catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace();
		}

    finally {
     
     if (pstmt != null)    pstmt.close();
      if (rs != null)       rs.close();
        ConnectionManager.returnConnection(con,request);  

    }

    if ((build_episode_yn.equals("N")) ||(build_episode_yn=="N"))
    {
        
%>      
        <script>      
        {
            alert(getMessage("NO_EPISODE_RULE","OP"));
			window.history.go(-1);
        }   
        </script>
<%      
    }
    else
    {
	%>
    <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eOP/js/OpParamFcy.js'></script>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
<%
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    
    String params = request.getQueryString() ;
    String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
    <iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'  src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
<%
    }
    
%>
</html>

