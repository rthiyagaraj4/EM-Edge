<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); 
%>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<script language='javascript' src='../js/MpAccessRights.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;

        Connection conlConn = null;
        Statement Stmt = null;
        ResultSet rstlRs = null;


        conlConn = ConnectionManager.getConnection(request);
        StringBuffer sblQry = new StringBuffer();


        try{

            accessRightRecSet.clearAll();

			sblQry.append("SELECT resp_id ");
            sblQry.append("FROM MP_ACCESS_RIGHTS ");
            sblQry.append("WHERE view_pat_photo_yn = 'Y'");

            Stmt = conlConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	       
            rstlRs = Stmt.executeQuery(sblQry.toString());
            
			String resp_id = "";

			while(rstlRs.next()){
				resp_id = rstlRs.getString("resp_id");
				accessRightRecSet.putObject(resp_id);
			}

        }catch(Exception e){
           // out.println("Error in select Query "+e);
			e.printStackTrace();
        }finally{

            if(rstlRs != null)  rstlRs.close();
            if(Stmt != null) Stmt.close();
            if(conlConn != null)  
				ConnectionManager.returnConnection(conlConn,request);


    }
%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='mp_access_frame' id='mp_access_frame' 	src='mpaccessrightsform.jsp' frameborder=0 noresize style='height:15vh;width:100vw'></iframe>
		<iframe name='mp_access_details' id='mp_access_details' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:68vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>


