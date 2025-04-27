<!DOCTYPE html>
<!--    Function Name VisitRegistration
    Created by M.Sathis Kumar on 13/12/2000 -->

<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
        Connection con = null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String  facility_id = (String) session.getValue("facility_id"); 
        String  l_encounter_id      = request.getParameter("encounter_id");
        String  procedure_output = "";
        try
        {
			con = ConnectionManager.getConnection(request);
            pstmt   = con.prepareStatement( "select get_patient_last_visit('"+facility_id+"','"+l_encounter_id+"') from dual");
            rs = pstmt.executeQuery();
            if( rs != null ) 
            {
                while( rs.next() ) 
                {
                    procedure_output = rs.getString(1);
                    if (procedure_output==null) procedure_output = "";
                }
            }
        }
        catch(Exception e) { out.println(e.toString());}
        finally 
        {
            if (pstmt != null) pstmt.close();
            if (rs != null)   rs.close();
            ConnectionManager.returnConnection(con,request);
        }
%>
<%=procedure_output%>
<html>
<head>
    <meta http-equiv="Expires" content="0">
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>    
        <script language='javascript'>
            function ButtonClick()
            {
                parent.window.returnValue="Y";
                parent.window.close();
            }
        </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body class='content' topmargin='0' bottommargin='0' onKeyDown ='lockKey()'>
        <form name='last_visit_detail2' id='last_visit_detail2'>
                <table width='90%' border="0" cellpadding="0" cellspacing="0" align="center" valign="middle">       
                    <tr>
                        <td align="right" class="white">
                            <input type="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="ButtonClick()"  class="Button">
                        </td>
                    </tr>
                </table>
        </form>
</body>
</html>

