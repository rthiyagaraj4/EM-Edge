<!DOCTYPE html>
<html><%@ page contentType="text/html;charset=UTF-8"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eXH.XHDBAdapter" %>
 <head>

	<%request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ; 
		ResultSet resultset = null;
		Statement stment=null;
		Connection conn = null;
		String flag="N";										    
		try																				 
		{ 
		if(conn==null) conn = ConnectionManager.getConnection();
		}
		 catch(Exception exp)													   
			  {

				 System.out.println("Error in calling getconnection method of XHTranslationManagerMainN.jsp :"+exp.toString());
				exp.printStackTrace(System.err);
				//exceptions=exceptions+"1"+"*"+exp.toString();
			  }
		try{

		 stment= conn.createStatement();
		 resultset = stment.executeQuery("	SELECT MASTER_CODE_MAP_YN FROM XH_PARAM");
		 while(resultset.next())
		{
		flag=XHDBAdapter.checkNull(resultset.getString(1));
		}

		}																 
		catch(Exception e)
		{
		}
		finally
		{
		if(stment!=null) 
			{
			stment.close();
			 resultset.close() ;
				}
				 ConnectionManager.returnConnection(conn);
		}

        %>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../js/XHTranslationManagerN.js'></script>
		<script language="JavaScript" src='../../eCommon/js/messages.js'> </Script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		   <title> Entity Cross Reference</title> 
		</head>
		<%
		if(flag.equals("Y"))
		{
		%>

			<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='Search' id='Search' 	src='../../eXH/jsp/XHTranslationManagerCriteriaN.jsp'   frameborder=0 scrolling=auto noresize style='height:20vh;width:100vw'></iframe>																		 						   
				<iframe name='result' id='result' 	src='../../eCommon/html/blank.html'   frameborder=0 scrolling=auto noresize style='height:65vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
				<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>

			<%} else {out.println("<script>alert(getMessage('XH0070','XH'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
									
     		}%>																	    

</html>
 									 

