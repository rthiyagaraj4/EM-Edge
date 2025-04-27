<!DOCTYPE html>
<html> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,java.text.SimpleDateFormat" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%
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
		 System.out.println("Error in calling getconnection method of FilteringAndSchedulingMasterMain1.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
try{

 stment= conn.createStatement();
 resultset = stment.executeQuery("select FILTER_YN from XH_PARAM ");
 while(resultset.next())
{
flag=resultset.getString(1);
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
	
		}
		if(resultset!=null)
	{
			 resultset.close() ;
	}

		 ConnectionManager.returnConnection(conn);
}

%>
<script language="JavaScript" src='../../eXH/js/Filtergl.js'> </Script>
<script language="JavaScript" src='../../eXH/js/Filter.js'> </Script>
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<title>Interface Filter</title>
	<%
	if(flag.equals("Y"))
	{
		// frameset size changed by prithivi for enotification requirement on 11/05/2016
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>  
	<iframe name='search' id='search' src="../../eXH/jsp/FilterAndSchedulingSelectMaster.jsp?<%=params%>" frameborder=0  scrolling='no' style='height:6vh;width:100vw'></iframe>
	<iframe name='filterframe' id='filterframe' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:10vh;width:100vw'></iframe>
	<iframe name='recordframe_detail' id='recordframe_detail' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:20vh;width:100vw'></iframe>
	<iframe name='recordframe' id='recordframe' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:40vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:12vh;width:100vw'></iframe>
	<%}else{
												    
	out.println("<script>alert(getMessage('XH0069','XH'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");	
	}
		%>
 
 
     


	
	
</html>

