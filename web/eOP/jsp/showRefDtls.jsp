<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
    <head>
       <!--  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	   <%
	   request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <title><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></title>
    </head>
    
    <body onKeyDown ='lockKey()'>
    <%
         String locale = localeName;
		 Connection con  =  null;
         PreparedStatement stmt = null ;
         ResultSet rs = null ;
         try
         {
		 con  =  ConnectionManager.getConnection(request);
    %>
        <table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>
             <tr>
                <td class='columnheader' align='left'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></td>
            </tr>
            <%
				stmt  = con.prepareStatement("select get_referral_detail_line(?,?,?) from dual");
                stmt.setString(1,request.getParameter("referral_id"));
                stmt.setString(2,"FROM");
				stmt.setString(3,locale);
                rs = stmt.executeQuery() ;
                rs.next() ;
            %>       
           <tr>
                <td  width='75%' id='refdetails' style='position:relative;'><%= (rs.getString(1).substring(2))%></td>
           </tr>
           <tr>
            <td align='right' class='bodycolorfilled'>
                <input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick ='window.close()' >
            </td>
           </tr>
       </table>
       <%
        }
        catch(Exception e){out.println(e); }
        finally 
        {
            if (stmt != null) stmt.close();
            if (rs != null)   rs.close();
            ConnectionManager.returnConnection(con,request);
        }       
       %>
    </body>
</html>

